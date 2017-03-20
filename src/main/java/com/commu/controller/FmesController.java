package com.commu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Common;
import com.commu.model.Comm;
import com.commu.model.Fmes;
import com.commu.service.CmService;
import com.commu.service.FmesService;
import com.pageBean.Page;
import com.pageBean.PageBean;
import com.root.user.model.User;

@RequestMapping("commu")
@Controller
public class FmesController {
	@Autowired
	private FmesService fmesService;
	@Autowired
	private CmService cmService;

	@RequestMapping(value = "forum", method = RequestMethod.GET)
	public String forum(HttpServletRequest request, Model model) {
		int ps = 10;
		int pc = Page.getPc(request);
		try {
			PageBean<Fmes> pageBean = fmesService.flist(pc, ps);
			model.addAttribute("pageBean", pageBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "commu/forum";
	}

	@RequestMapping(value = "forum", method = RequestMethod.POST)
	public String forum(HttpServletRequest request, @RequestParam String title,
			@RequestParam String message, Model model) {
		User user = (User) request.getSession().getAttribute("userSession");
		String acttime = Common.getDate();
		System.out.println(acttime);
		String time = Common.getDate();
		String username = user.getUserName();
		Fmes fmes = new Fmes();
		fmes.setTime(time);
		fmes.setActtime(acttime);
		fmes.setName(username);
		fmes.setTitle(title);
		fmes.setMessage(message);
		try {
			fmesService.fatie(fmes);
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
		return forum(request, model);
	}

	@RequestMapping(value = "comm", method = RequestMethod.GET)
	public String comm(Model model,HttpServletRequest request,@RequestParam int mesId) {
		int ps = 10;
		int pc = Page.getPc(request);
		//输出主题
		try {
			Fmes fmes = fmesService.queryById(mesId);
			model.addAttribute("fmes",fmes);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "error";
		}
			
		try {
			PageBean<Comm> pageBean = cmService.cmlist(pc, ps, mesId);
			model.addAttribute("pageBean",pageBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "commu/comm";
	}

	@RequestMapping(value = "comm", method = RequestMethod.POST)
	public String comm(Model model,HttpServletRequest request, @RequestParam int mesId,
			@RequestParam String cmmes) {
		Comm comm = new Comm();
		User user = (User)request.getSession().getAttribute("userSession");
		String name = user.getUserName();
		String time = Common.getDate();
		comm.setMesId(mesId);
		comm.setName(name);
		comm.setCmmes(cmmes);
		comm.setTime(time);
		try {
			cmService.addComm(comm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		try {
			int praise = cmService.cmcount(mesId);
			fmesService.updatepraise(mesId, praise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comm(model,request,mesId);

	}
}
