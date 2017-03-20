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
		<tr>
			<td height="22" colspan="6" align="center" bgcolor="#00F5FF">-资源列表-</td>
		</tr>
		
		<tr>
			<td height="22" align="center" >资源编号</td>
			<td height="22" align="center" >资源名称</td>
			<td height="22" align="center" >唯一Key</td>
			<td height="22" align="center" >资源地址</td>
			<td height="22" align="center" >描述</td>
			<td height="22" align="center" >资源管理</td>
		</tr>

		<c:forEach items="${pageBean.beanList}" var="resc">
			<tr>
				<td height="22" align="center" >${resc.rescId}</td>
				<td height="22" align="center" >${resc.rescName}</td>
				<td height="22" align="center" >${resc.rescKey}</td>
				<td height="22" align="center" >${resc.resUrl}</td>
				<td height="22" align="center" >${resc.description}</td>
				<td height="22" align="center" ><a
					href="updateresc?rescId=${resc.rescId}">修改</a>
				<a href="delete?rescId=${resc.rescId}">删除</a></td>
			</tr>
		</c:forEach>

	</table>
	<a href="addResc">添加信息</a>
	<center>

		<a href="<c:url value='/resc/list?pc=1' />">首页</a> <a
			href="<c:url value='/resc/list?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/resc/list?pc=${pageBean.pc+1}' />">下一页</a> <a
			href="<c:url value='/resc/list?pc=${pageBean.tp}' />">尾页</a>

	</center>
</html>
