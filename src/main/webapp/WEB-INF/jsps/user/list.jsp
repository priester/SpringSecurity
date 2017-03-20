<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>

<body>
	<table class="zebra">
		<!-- <table width="100%" border="1" align="center" cellpadding="1"
		cellspacing="0" bordercolor="#FFFFFF" bgcolor="#FFFFFF"> -->
		<tr>
			<td height="22" colspan="6" align="center" bgcolor="#00F5FF">-用户管理列表-</td>
		<tr>
			<td height="22" align="center">用户编号</td>
			<td height="22" align="center">用户名</td>
			<td height="22" align="center">密码</td>
			<td height="22" align="center">创建时间</td>
			<td height="22" align="center">用户角色</td>
			<td height="22" align="center">修改角色</td>
		</tr>

		<c:forEach items="${pageBean.beanList}" var="user">
			<tr>
				<td height="22" align="center">${user.userId}</td>
				<td height="22" align="center">${user.userName}</td>
				<td height="22" align="center">${user.password}</td>
				<td height="22" align="center">${user.crDate}</td>
				<td height="22" align="center">${user.roleName}</td>
				<td height="22" align="center"><a
					href="updateua/${user.userId}">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="adduser">添加信息</a>

	<center>
		<a href="<c:url value='/user/list?pc=1' />">首页</a> <a
			href="<c:url value='/user/list?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/user/list?pc=${pageBean.pc+1}' />">下一页</a> <a
			href="<c:url value='/user/list?pc=${pageBean.tp}' />">尾页</a>

	</center>
</html>
