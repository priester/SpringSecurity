<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色列表</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>

<body>
	
	<table class = "zebra">
	<!-- <table width="94%" border="0" align="center" cellpadding="0"
		cellspacing="1" bordercolor="#FFFFFF" bgcolor="#97B14E"> -->
		<tr>
			<td height="22" colspan="6" align="center" bgcolor="#00F5FF">-角色管理列表-</td>
		</tr>
		
		<tr>
			<td height="22" align="center" >角色编号</td>
			<td height="22" align="center" >角色名称</td>
			<td height="22" align="center" >角色Key</td>
			<td height="22" align="center" >描述</td>
			<td height="22" align="center" >修改角色</td>
			<td height="22" align="center" >删除角色</td>
		</tr>

		<c:forEach items="${pageBean.beanList}" var="role">
			<tr>
				<td height="22" align="center" >${role.roleId}</td>
				<td height="22" align="center" >${role.roleName}</td>
				<td height="22" align="center" >${role.roleKey}</td>
				<td height="22" align="center" >${role.description}</td>
				<td height="22" align="center" ><a
					href="updaterole?roleId=${role.roleId}">修改</a></td>
				<td height="22" align="center" bgcolor="#FFFFFF"><a
					href="deleterole?roleId=${role.roleId}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="addrole">添加信息</a>
	<center>

		<a href="<c:url value='/role/list?pc=1' />">首页</a> <a
			href="<c:url value='/role/list?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/role/list?pc=${pageBean.pc+1}' />">下一页</a> <a
			href="<c:url value='/role/list?pc=${pageBean.tp}' />">尾页</a>
	</center>
</html>
