package com.root.user.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.Common;
import com.pageBean.Page;
import com.pageBean.PageBean;
import com.root.user.model.User;
import com.root.user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/* 分页展示用户信息 */
	@RequestMapping("list")
	public String showUser(HttpServletRequest request, Model model) {
		int pc = Page.getPc(request);
		int ps = 10;
		PageBean<User> pageBean = null;
		try {
			pageBean = userService.queryUserList(pc, ps);
		} catch (SQLException e) {
			model.addAttribute("error", "查询数据库异常，清联系管理员");
			return "error";
		}
		if (pageBean.getTr() == 0) {
			model.addAttribute("error", "没有查询到相关数据");
			return "error";
		}
		model.addAttribute("pageBean", pageBean);
		return "user/list";
	}

	@RequestMapping(value = "/updateua/{suserId}", method = RequestMethod.GET)
	public String update(@PathVariable int suserId, Model model) {
		model.addAttribute(new User());
		return "user/updateua";
	}

	/**
	 * 做更新操作,url类似REST风格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateua/{suserId}", method = RequestMethod.POST)
	public String updateua(@PathVariable int suserId,
			HttpServletRequest request, Model model) {
		String sroleId = request.getParameter("jroleId");
		int roleId = Integer.parseInt(sroleId);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(suserId);
		map.put("userId", suserId);
		System.out.println(roleId);
		map.put("roleId", roleId);
		try {
			userService.updateua(map);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "修改错误，请联系管理员");
			return "error";
		}
		return "ok";
	}

	/*
	 * @RequestMapping(value = "updateua", method = RequestMethod.GET) public
	 * String updateUserua1(HttpServletRequest request,Model model) { String
	 * value = request.getParameter("suserId"); int suserId =
	 * Integer.parseInt(value); System.out.println("suserId"+suserId);
	 * model.addAttribute("suserId",suserId); return "user/updateua"; }
	 * 
	 * @RequestMapping("updateua2") public String
	 * updateUserua2(HttpServletRequest request, Model model) { String suserId =
	 * (String)request.getAttribute("suserId"); System.out.println(suserId);
	 * String sroleId = request.getParameter("jroleId"); int roleId =
	 * Integer.parseInt(sroleId); System.out.println("roleId"+roleId);
	 */
	//
	// try {
	// userService.updateUserua(userId, roleId);
	//
	// } catch (SQLException e) {
	// model.addAttribute("error", "异常，前检查你的输入");
	// }
	// return "user/updateok";
	// }

	@RequestMapping(value = "updatepw", method = RequestMethod.GET)
	public String updateUserpw(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/updatepw";
	}

	@RequestMapping(value = "/updatepw", method = RequestMethod.POST)
	public String updatepw(@Valid User user, BindingResult bindingResult,
			Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "update";
		} else {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userName = userDetails.getUsername();
			user.setUserName(userName);
			userService.updateUserpw(user);
			return "user/updatepwok";
		}
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/adduser";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String add(@Valid User user, BindingResult bindingResult, Model model) {
		String userName = user.getUserName();
		if (userService.queryUser(userName) != null) {
			model.addAttribute("message", "用户名已经存在");
			return "user/adduser";
		} else {
			if (bindingResult.hasErrors()) {
				return "user/adduser";
			} else {
				String crDate = Common.getDate();
				user.setCrDate(crDate);
				int userId = 1;
				user.setUserId(userId);
				try {
					userService.addUser(user);
				} catch (SQLException e) {
					model.addAttribute("error", "用户添加失败");
					return "error";
				}
				return "user/list";
			}
		}
	}
}