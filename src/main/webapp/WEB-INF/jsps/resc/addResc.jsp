<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源管理</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>
<body>
	<table class="zabra">
		<!-- <table width="94%"  border="0" align="center" cellpadding="0"
	 			cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#97B150" > -->
		<tr>
			<td height="22" colspan="4" align="center" bgcolor="#00F5FF">--</td>
		</tr>
		<sf:form method="post" modelAttribute="resc">

			<tr>
				<td width="40%" height="27" bgcolor="#E8FEA9">资源名：</td>
				<td height="22" align="left" bgcolor="#E8FEA9"><sf:input
						path="rescName" /></td>
			</tr>

			<tr>
				<td width="40%" height="27" bgcolor="#E8FEA9">唯一Key：</td>
				<td height="22" align="left" bgcolor="#E8FEA9"><sf:input
						path="rescKey" /></td>
			</tr>

			<tr>
				<td width="40%" height="27" bgcolor="#E8FEA9">资源URL：</td>
				<td height="22" align="left" bgcolor="#E8FEA9"><sf:input
						path="resUrl" /></td>
			</tr>
			<tr>
				<td width="40%" height="27" bgcolor="#E8FEA9">描述：</td>
				<td height="22" align="left" bgcolor="#E8FEA9"><sf:input
						path="description" /></td>
			</tr>

			<tr>
				<td height="27" colspan="4" align="center" bgcolor="#E8FEA9"><input
					type="submit" value="添加" />
			</tr>
		</sf:form>
	</table>
</body>
</html>