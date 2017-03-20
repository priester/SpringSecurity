<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工基本信息</title>
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
		<tr>
			<td height="4" colspan="4" align="center" bgcolor="#00F5FF">-员工信息-</td>
		</tr>
		
		<tr>
			<td width="30%" align="center">员工编号：</td>
			<td align="left">${empMessage.empId}</td>
		</tr>
		
		<tr>
			<td align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
			<td align="left">${empMessage.name}</td>
		</tr>

		<tr>
			<td align="center">身份证号：</td>
			<td align="left">${empMessage.idCard}</td>
		</tr>
		<tr>
			<td align="center">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
			<td align="left">${empMessage.age}</td>
		</tr>

		<tr>
			<td align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
			<td align="left">${empMessage.sex}</td>
		</tr>
		
		<tr>
			<td align="center">家庭住址：</td>
			<td align="left">${empMessage.addr}</td>
		</tr>

		<tr>
			<td align="center">所学专业：</td>
			<td align="left">${empMessage.specialty}</td>
		</tr>

		<tr>
			<td align="center">职位：</td>
			<td align="left">${empMessage.job}</td>
		</tr>

		<tr align="center">
			<td align="center">学&nbsp;&nbsp;&nbsp;&nbsp;历：</td>
			<td align="left">${empMessage.studyeffort}</td>
		</tr>

		<tr>
			<td align="center">毕业学校：</td>
			<td align="left">${empMessage.school}</td>
		</tr>
		<tr>
			<td align="center">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
			<td align="left">${empMessage.tel}</td>
		<tr>
		<tr>
			<td align="center">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
			<td align="left">${empMessage.qq}</td>
		<tr>
		<tr>
			<td align="center">Email：</td>
			<td align="left">${empMessage.email}</td>
		</tr>


	</table>
</body>
</html>
