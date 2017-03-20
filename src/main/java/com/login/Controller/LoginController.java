package com.login.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.Common;
import com.root.resc.service.RescService;
import com.root.user.model.User;
import com.root.user.model.UserLoginList;
import com.root.user.service.UserLoginListService;
import com.root.user.service.UserService;


@Controller

public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginListService userLoginListService;
	@Autowired
	private RescService rescService;
	@Autowired
	private AuthenticationManager myAuthenticationManager;

	/**
	 * @return
	 */
	@RequestMapping ("login")
	public String login(Model model,HttpServletRequest request)
	{
		//重新登录时销毁该用户的Session
		Object o = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		if(null != o){
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "login";
	}
	
	@RequestMapping ("loginCheck")
	public String loginCheck(String userName,String password,HttpServletRequest request){
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error","支持POST方法提交！");
			}
			if (Common.isEmpty(userName) || Common.isEmpty(password)) {
				request.setAttribute("error","用户名或密码不能为空！");
				return "login";
			}
			// 验证用户账号与密码是否正确
			User users = this.userService.queryUser(userName);
			if (users == null || !users.getPassword().equals(password)) {
				request.setAttribute("error", "用户或密码不正确！");
			    return "login";
			}
			Authentication authentication = myAuthenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
			
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);  
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
		    // 当验证都通过后，把用户信息放在session里

			request.getSession().setAttribute("userSession", users);
			// 记录登录信息
			UserLoginList userLoginList = new UserLoginList();
			userLoginList.setUserName(userName);
			userLoginList.setLoginTime(Common.getDate());
			userLoginList.setLoginIp(Common.toIpAddr(request));
			userLoginListService.addLoginList(userLoginList);
		} catch (AuthenticationException ae) {  
			request.setAttribute("error", "登录异常，请联系管理员！");
		    return "login";
		}
		return "welcome";
	}
	
	@RequestMapping("403")
	public String righterr() {
		return "403";
	}
	
}
