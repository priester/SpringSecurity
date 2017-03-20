package com.sercurity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.root.resc.dao.RescDao;
import com.root.user.dao.UserDao;

/**
 * User userdetail该类实现 UserDetails 接口，该类在验证成功后会被保存在当前回话的principal对象中
 * 
 * 获得对象的方式： WebUserDetails webUserDetails =
 * (WebUserDetails)SecurityContextHolder
 * .getContext().getAuthentication().getPrincipal();
 * 
 * 或在JSP中： <sec:authentication property="principal.username"/>
 * 
 * 如果需要包括用户的其他属性，可以实现 UserDetails 接口中增加相应属性即可 权限验证类
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RescDao rescDao;

	// 登录验证
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername ----------- ");

		// 取得用户的权限
		com.root.user.model.User users = userDao.queryUser(userName);
		if (users == null)
			throw new UsernameNotFoundException(userName + " not exist!");
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		// 封装成spring security的user
		User userdetail = new User(users.getUserName(), users.getPassword(),
				true, true, true, true, grantedAuths // 用户的权限
		);

		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(
			com.root.user.model.User user) {
		
		//用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
		//关联代码：applicationContext-security.xml
		// 关联代码：MySecurityMetadataSource#loadResourceDefine
	
		List<String> rescKeys = rescDao.qureySById(user.getUserId());
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (String s : rescKeys) {
			authSet.add(new SimpleGrantedAuthority("ROLE_" + s));
		}

		return authSet;

	}
}