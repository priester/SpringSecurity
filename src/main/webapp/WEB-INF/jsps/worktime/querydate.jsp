<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateua</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>
<body>
	今日上下班登记 (当前时间:${datec})
	<form method="post">
		<table class="zebra">
			<tr>
				<td height="22" colspan="2" align="center" bgcolor="#00F5FF">-考勤情况-</td>
			</tr>
			<tr align="center">
				<td width="40%" height="27">开始时间：</td>
				<td height="22" align="left"><input type="text"
					name="sbegindate" /></td>
			</tr>
			<tr align="center">
				<td width="40%" height="27">结束时间：</td>
				<td height="22" align="left"><input type="text" name="senddate" /></td>
			</tr>
			<tr>
				<td height="27" colspan="4" align="center"><input type="submit"
					value="提交" />
			</tr>
		</table>
	</form>
</body>
</html>