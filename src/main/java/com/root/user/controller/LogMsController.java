package com.root.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pageBean.Page;
import com.pageBean.PageBean;
import com.root.user.model.UserLoginList;
import com.root.user.service.UserLoginListService;

@RequestMapping ("log")
@Controller
public class LogMsController {
	@Autowired 
	private  UserLoginListService userLoginListService;
	
	
	@RequestMapping ("list") 
	public String showlist (HttpServletRequest request,Model model) {
		int ps = 9;
		int pc = Page.getPc(request);
		PageBean<UserLoginList> pageBean = null;
		try {
			pageBean = userLoginListService.queryAlllog(pc, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "数据库操作异常，请联系管理员");
			return "error";
		}
		model.addAttribute("pageBean", pageBean);
		return "user/loglist";
	}
}
