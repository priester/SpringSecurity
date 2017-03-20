<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>
<body>
	<table >
		<tr>
			<td><a href="/maven01/user/list">用户管理 </a></td>
		</tr>
		
		<tr>
			<td><a href="/maven01/role/list">角色管理</a></td>
		</tr>
		
		<tr>
			<td><a href="/maven01/resc/list">资源管理</a></td>
		</tr>
		
		<tr>
			<td><a href="/maven01/log/list">登陆信息</a></td>
		</tr>
	</table>
</body>
</html>