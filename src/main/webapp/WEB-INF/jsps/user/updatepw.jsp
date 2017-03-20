<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<!-- <table width="100%" border="1" align="center" cellpadding="1"
		cellspacing="0" bordercolor="#FFFFFF"> -->
		<tr>
			<td height="22" colspan="4" align="center" bgcolor="#00F5FF">-修改用户密码-</td>
		</tr>
		<sf:form method="post" modelAttribute="user">

			<tr align="center">
				<td width="40%" height="27">密码：</td>
				<td height="22" align="left"><sf:input path="password" /></td>
			</tr>

			<tr>
				<td height="27" colspan="4" align="center" ><input
					type="submit" value="修改" />
			</tr>
		</sf:form>
	</table>
</body>
</html>