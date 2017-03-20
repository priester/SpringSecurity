package com.root.recs.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pageBean.Page;
import com.pageBean.PageBean;
import com.root.resc.model.Resources;
import com.root.resc.service.RescService;

@RequestMapping("resc")
@Controller
public class RescController {
	@Autowired 
	private RescService rescService;
	
	
	@RequestMapping("list")
	public String showList(HttpServletRequest request,Model model) {
		int ps = 15;
		int pc = Page.getPc(request);
		try {
			PageBean<Resources> pageBean = rescService.queryRescList(pc, ps);
			model.addAttribute("pageBean", pageBean);
			return "resc/list";
		} catch (SQLException e) {
			model.addAttribute("error", "数据库读取异常，请联系管理员");
			return "error";
		}
	}
	
	@RequestMapping(value="addResc",method=RequestMethod.GET)
	public String addResc(Model model){
		Resources resc = new Resources();
		model.addAttribute("resc",resc);
		return "resc/addResc";
	}
	
	
	@RequestMapping(value="addResc",method=RequestMethod.POST)
	public String addResc(@Valid Resources resc,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()){
			return "addResc";
		} else {
			try {
				System.out.println(resc.getDescription());
				rescService.addResc(resc);
			} catch (SQLException e) {
				e.printStackTrace();
				model.addAttribute("error", "添加失败，请联系管理员");
				return "error";
			}
		}
		return "redirect:list";
	}
	
	@RequestMapping(value="updateresc",method = RequestMethod.GET)
	public String update(@RequestParam int rescId,Model model){
		Resources resc = null;
		try {
			resc = rescService.queryByRescId(rescId);
			System.out.println(resc);
		} catch (SQLException e) {
			model.addAttribute("error", "出错了，请重试");
			e.printStackTrace();
		}
		model.addAttribute("resc",resc);
		return "resc/updateresc";
	}
	
	@RequestMapping(value="updateresc",method = RequestMethod.POST)
	public String update(@RequestParam int rescId,@Valid Resources resc ,
			BindingResult result,Model model,HttpServletRequest request){
		resc.setRescId(rescId);
		try {
			rescService.updateResc(resc);
		} catch (SQLException e) {
			
			e.printStackTrace();
			model.addAttribute("error","用户修改失败，请联系管理员");
			return "error";
		}
		return showList(request,model);
	}
	
	@RequestMapping(value="delete")
	public String delete (@RequestParam int rescId,Model model) {
		try {
			rescService.deleteResc(rescId);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error","用户修改失败，请联系管理员");
			return "error";
		}
		return "ok";
	}
}
