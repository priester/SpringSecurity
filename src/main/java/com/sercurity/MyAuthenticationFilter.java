package com.sercurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.common.Common;
import com.root.user.dao.UserDao;
import com.root.user.model.User;
import com.root.user.model.UserLoginList;
import com.root.user.service.UserLoginListService;

/**
 * 这个类主要是用户登录验证
 */
public class MyAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserLoginListService userLoginListService;
	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
//		System.err.println(" ---------------  MyAuthenticationFilter attemptAuthentication--------------- ");
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}

		String userName = obtainUsername(request).trim();
		String password = obtainPassword(request).trim();
		
		if (Common.isEmpty(userName) || Common.isEmpty(password)) {
			BadCredentialsException exception = new BadCredentialsException(
					"用户名或密码不能为空！");// 在界面输出自定义的信息！！
			throw exception;
		}

		// 验证用户账号与密码是否正确
		User users = this.userDao.queryUser(userName);
		if (users == null || !users.getPassword().equals(password)) {
			BadCredentialsException exception = new BadCredentialsException(
					"用户名或密码不匹配！");// 在界面输出自定义的信息！！
			// request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
			// exception);
			throw exception;
		}
		// 当验证都通过后，把用户信息放在session里
		// 记录登录信息
		UserLoginList userLoginList = new UserLoginList();
		userLoginList.setUserName(userName);
		userLoginList.setLoginTime(Common.getDate());
		userLoginList.setLoginIp(Common.toIpAddr(request));
		userLoginListService.addLoginList(userLoginList);
		
		// 实现 Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				userName, password);
		// 允许子类设置详细属性
		setDetails(request, authRequest);

		// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}


	

}
