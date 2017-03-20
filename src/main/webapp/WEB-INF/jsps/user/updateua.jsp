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
	<form method="post">
		<table class="zebra">
			<!-- <table width="100%"  border="1" align="center" cellpadding="1" cellspacing="0" bordercolor="#FFFFFF" > -->
			<tr>
				<td height="22" colspan="4" align="center">-修改用户权限-</td>
			</tr>
			<tr align="center">
				<td width="40%" height="27">权限：</td>
				<td height="22" align="left"><input type="text" name="jroleId" /></td>
			</tr>
			<tr>
				<td height="27" colspan="4" align="center"><input type="submit"
					value="修改" />
			</tr>
		</table>
	</form>
</body>
</html>