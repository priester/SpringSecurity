package com.personal.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.CSVUtil;
import com.common.ExcelUtil;
import com.pageBean.Page;
import com.pageBean.PageBean;
import com.personal.model.EmpMessage;
import com.personal.service.EmpMessageService;
import com.root.user.model.User;
import com.root.user.service.UserService;

@Controller
@RequestMapping(value = "personal")
public class EmpMessageController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmpMessageService empMessageService;

	@RequestMapping(value = "contactlist")
	public String showList(HttpServletRequest request, Model model) {
		int ps = 10;
		int pc = Page.getPc(request);
		try {
			PageBean<EmpMessage> pageBean = empMessageService.queryContacts(pc,
					ps);
			model.addAttribute("pageBean", pageBean);
		} catch (SQLException e) {
			e.printStackTrace();
			model.addAttribute("error", "数据库查询异常，请联系管理员");
			return "error";
		}
		return "personal/contactlist";
	}

	@RequestMapping(value = "/addmessage", method = RequestMethod.GET)
	public String addEmpMesssage(Model model) {
		EmpMessage empMessage = new EmpMessage();
		model.addAttribute(empMessage);
		return "personal/addmessage";
	}

	@RequestMapping(value = "/addmessage", method = RequestMethod.POST)
	public String addEmpmesssage(@Valid EmpMessage empMessage,
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return "personal/addmessage";
		}
		empMessageService.addEmpMessage(empMessage);
		return "personal/addok";
	}

	@RequestMapping(value = "/addupmessage", method = RequestMethod.GET)
	public String addupEmpMesssage(Model model) {
		int empId = getUserId();
		try {
			EmpMessage empMessage = empMessageService.queryEmpMessage(empId);
			model.addAttribute("empMessage", empMessage);

		} catch (Exception e) {
			EmpMessage empMessage = new EmpMessage();
			empMessage.setEmpId(empId);
			try {
				empMessageService.addEmpMessage(empMessage);
			} catch (Exception e1) {
				e1.printStackTrace();
				return "error";
			}
			model.addAttribute("empMessage", empMessage);
		}
		return "personal/addupmessage";
	}

	@RequestMapping(value = "/addupmessage", method = RequestMethod.POST)
	public String addupEmpmesssage(@Valid EmpMessage empMessage,
			BindingResult bindingResult) throws Exception {
		int empId = getUserId();
		System.out.println(empId);
		empMessage.setEmpId(empId);
		empMessageService.addupMessage(empMessage);
		return "personal/addok";
	}

	@RequestMapping(value = "/showmessage")
	public String showMessage(Model model) throws Exception {
		int empId = getUserId();
		System.out.println(empId);
		EmpMessage empMessage = empMessageService.queryEmpMessage(empId);
		model.addAttribute("empMessage", empMessage);
		return "personal/showmessage";
	}

	public int getUserId() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		int userId = 0;
		try {
			User user = userService.queryUser(userName);
			System.out.println(user);
			userId = user.getUserId();
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	@RequestMapping(value = "downloadExcel.do")
	public String downloaddo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String fileName = "通讯录";
		// 填充数据
		List<EmpMessage> empMs = createData();
		List<Map<String, Object>> list = createExcelRecord(empMs);
		String columnNames[] = { "员工编号", "姓名", "电话", "QQ", "邮箱" };// 列名
		String keys[] = { "empId", "name", "tel", "qq", "email" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	private List<EmpMessage> createData() {
		List<EmpMessage> empMs = null;
		try {
			empMs = empMessageService.queryAllContacts();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empMs;
	}

	private List<Map<String, Object>> createExcelRecord(List<EmpMessage> empMs) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		for (EmpMessage empM : empMs) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("empId", empM.getEmpId());
			mapValue.put("name", empM.getName());
			mapValue.put("tel", empM.getTel());
			mapValue.put("qq", empM.getQq());
			mapValue.put("email", empM.getEmail());
			listmap.add(mapValue);
		}
		return listmap;
	}

	/**
     */
	@RequestMapping("downloadCSV.do")
	@ResponseBody
	public String downloadCSV(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		List<EmpMessage> empMs = createData();
		if (empMs.size() == 0) {
			model.addAttribute("message", "没有数据可以导出");
		}
		String sTitle = "员工编号,姓名,电话,QQ,邮箱";
		String fName = "通讯录";
		String mapKey = "empId,name,tel,qq,email";
		List<Map<String, Object>> list = createExcelRecord(empMs);
		OutputStream os = response.getOutputStream();
		try {
			CSVUtil.responseSetProperties(fName, response);
			CSVUtil.doExport(list, sTitle, mapKey, os);
			return null;
		} catch (Exception e) {
			System.out.print("用户导出错误");

		}
		return "error";
	}
}
