package com.personal.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Common;
import com.personal.model.WorkTime;
import com.personal.service.WtService;
import com.root.user.model.User;
import com.root.user.service.UserService;

@RequestMapping("worktime")
@Controller
public class WtController {
	@Autowired
	private WtService wtService;
	@Autowired
	private UserService userService;

	// 测试打卡功能
	@RequestMapping(value = "dakaTest", method = RequestMethod.GET)
	public String dakaTest(Model model) {
		String datec = Common.getDate();
		model.addAttribute("datec", datec);
		return "worktime/dakaTest";
	}
	
	

	@RequestMapping(value = "dakaTest", method = RequestMethod.POST)
	public String dakaTest(@RequestParam String begindate,
			@RequestParam String enddate, HttpServletRequest request) {
		WorkTime wt = new WorkTime();
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		wt.setEmpId(userId);
		try {
			Date datetime = Common.tosql(begindate);
			wt.setDatetime(datetime);
			wt.setWktime(begindate);
			wt.setOfftime(enddate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			wtService.addWt(wt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}

	@RequestMapping(value = "querydate", method = RequestMethod.GET)
	public String querydate(Model model) {
		String datec = Common.getDate();
		model.addAttribute("datec", datec);
		return "worktime/querydate";
	}

	@RequestMapping(value = "querydate", method = RequestMethod.POST)
	public String querydate(@RequestParam String sbegindate,
			@RequestParam String senddate, Model model,
			HttpServletRequest request) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("userSession");
		int empId = user.getUserId();
		hashMap.put("empId", empId);
		try {
			Date begindate = Common.tosql(sbegindate);
			Date enddate = Common.tosql(senddate);
			hashMap.put("begindate", begindate);
			hashMap.put("enddate", enddate);
			List<WorkTime> workTimes;
			try {
				workTimes = wtService.querydate(hashMap);
			} catch (SQLException e) {
				e.printStackTrace();
				model.addAttribute("error", "数据异常，请联系管理员");
				return "error";
			}
			List<WorkTime> lateDate = new ArrayList<WorkTime>();;
			for (WorkTime wt : workTimes) {
				String sdate = wt.getWktime();
				Calendar cal = Common.toCalendar(sdate);
				int hour = cal.get(Calendar.HOUR);// 小时
				// int minute = cal.get(Calendar.MINUTE);// 分
				if (hour >= 8) {
					lateDate.add(wt);
				}
			}
			model.addAttribute("latedate", "迟到" + lateDate.size() + "天");
			model.addAttribute("workTimes", workTimes);

		} catch (ParseException e) {
			e.printStackTrace();
			model.addAttribute("error", "输入时间异常，请重试");
			return "error";
		}
		return "worktime/reclist";
	}
}
