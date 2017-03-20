<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
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
			<td colspan="2" align="center" bgcolor="#00F5FF">-信息修改-</td>
		</tr>
		<sf:form method="post" modelAttribute="empMessage">

			<tr>
				<td width="30%" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				<td align="left"><sf:input path="name" /> <sf:errors
						path="name" /></td>
			</tr>

			<tr>
				<td align="center">身份证号：</td>
				<td align="left"><sf:input path="idCard" />
					<sf:errors path="idCard" /></td>
			</tr>


			<tr>
				<td align="center">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
				<td><sf:input path="age" />
					<sf:errors path="age" /></td>
			</tr>

			<tr>
				<td align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				<td><label><input name="sex" type="radio" value="男" />男
				</label> <label><input name="sex" type="radio" value="女" />女 </label></td>
			</tr>

			<tr>
				<td align="center">家庭住址：</td>
				<td align="left"><sf:input path="addr" />
					<sf:errors path="addr" /></td>
			</tr>

			<tr>
				<td align="center">所学专业：</td>
				<td align="left"><sf:input path="specialty" />
					<sf:errors path="specialty" /></td>
			</tr>

			<tr>
				<td align="center">职位：</td>
				<td align="left"><sf:input path="job" />
					<sf:errors path="job" /></td>
			</tr>
			<tr>
				<td align="center" height="27">学&nbsp;&nbsp;&nbsp;&nbsp;历：</td>
				<td align="left"><sf:input path="studyeffort" />
					<sf:errors path="studyeffort" /></td>
			</tr>
			<tr>

				<td align="center">毕业学校：</td>
				<td align="left"><sf:input path="school" />
					<sf:errors path="school" /></td>
			</tr>

			<tr>
				<td align="center">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
				<td align="left"><sf:input path="tel" />
					<sf:errors path="tel" /></td>
			</tr>

			<tr>
				<td align="center">QQ：</td>
				<td align="left"><sf:input path="qq" />
					<sf:errors path="qq" /></td>
			</tr>

			<tr>
				<td align="center">Email：</td>
				<td align="left"><sf:input path="email" />
					<sf:errors path="email" /></td>
			</tr>

			<tr>
				<td height="30" colspan="4" align="center"><input name="Submit"
					type="submit" class="button" value="提交">
			</tr>

		</sf:form>
	</table>

</body>
</html>