package com.root.role.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pageBean.Page;
import com.pageBean.PageBean;
import com.root.role.model.Role;
import com.root.role.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "addrole", method = RequestMethod.GET)
	public String addRole(Model model) {
		model.addAttribute(new Role());
		return "role/addrole";
	}

	@RequestMapping(value = "addrole", method = RequestMethod.POST)
	public String addRole(@Valid Role role, Model model) {
		try {
			roleService.addRole(role);
		} catch (SQLException e) {

			e.printStackTrace();
			model.addAttribute("error", "添加错误");
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="deleterole" , method = RequestMethod.GET )
	public String delete(@RequestParam int roleId,Model model) {
		try {
			roleService.deleteRole(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "删除错误，请联系管理员");
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="updaterole" , method  = RequestMethod.GET)
	public String update(@RequestParam int roleId,Model model) {
		Role role = null;
		try {
			role = roleService.queryRoleById(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "错误，请联系管理员");
			return "error";
		}
		model.addAttribute("role", role);
		return "role/updaterole";
	}
	
	@RequestMapping(value="updaterole" , method = RequestMethod.POST)
	public String update (@RequestParam int roleId,@Valid Role role,Model model) {
		role.setRoleId(roleId);
		try {
			roleService.updateRole(role);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "错误，请联系管理员");
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping(value="list")
	public String showList(HttpServletRequest request,Model model) {
		int ps = 15;
		int pc = Page.getPc(request);
		PageBean<Role> pageBean = null;
		try {
			pageBean = roleService.queryAll(pc, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "数据库查询出错");
			return "error";
		}
		model.addAttribute("pageBean", pageBean);
		return "role/list";
	}
	
}

