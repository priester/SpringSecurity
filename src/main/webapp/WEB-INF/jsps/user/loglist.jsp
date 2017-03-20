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
		<!-- 	<table width="100%" border="1" align="center" cellpadding="1"
		cellspacing="0" bordercolor="#00F5FF" bgcolor="#E0FFFF"> -->
		<tr>
			<td height="22" colspan="6" align="center" bgcolor="#00F5FF">-登陆日志-</td>
		<tr>
			<td height="22" align="center">登陆编号</td>
			<td height="22" align="center">登陆用户</td>
			<td height="22" align="center">登陆时间</td>
			<td height="22" align="center">登陆Ip</td>
		</tr>

		<c:forEach items="${pageBean.beanList}" var="log">
			<tr>
				<td height="22" align="center">${log.loginId}</td>
				<td height="22" align="center">${log.userName}</td>
				<td height="22" align="center">${log.loginTime}</td>
				<td height="22" align="center">${log.loginIp}</td>

			</tr>
		</c:forEach>

	</table>


	${basePath}
	<center>

		<a href="<c:url value='/log/list?pc=1' />">首页</a> <a
			href="<c:url value='/log/list?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/log/list?pc=${pageBean.pc+1}' />">下一页</a> <a
			href="<c:url value='/log/list?pc=${pageBean.tp}' />">尾页</a>

	</center>
</html>
