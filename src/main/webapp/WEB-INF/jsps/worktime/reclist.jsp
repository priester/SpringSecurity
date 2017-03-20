<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上下班记录</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>

<body>
	${latedate}
	<table class="zebra">
		<tr>
			<td height="22" colspan="6" align="center" bgcolor="#00F5FF">-上下班记录-</td>
		</tr>
		
		<tr>
			<td align="center" >日期</td>
			<td align="center" >上班时间</td>
			<td align="center" >下班时间</td>
		</tr>

		<c:forEach items="${workTimes}" var="wk">
			<tr>
				<td align="center" >${wk.datetime}</td>
				<td align="center" >${wk.wktime}</td>
				<td align="center" >${wk.offtime}</td>
			</tr>
		</c:forEach>

	</table>
	
</html>
