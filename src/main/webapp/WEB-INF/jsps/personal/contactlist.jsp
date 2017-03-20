<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
<script>
	function downloadExcel() {
		var url = "downloadExcel.do";
		window.open(url);
	}
</script>
<script>
	function downloadCSV() {
		var url = "downloadCSV.do";
		window.open(url);
	}
</script>

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
			<td colspan="5" align="center" bgcolor="#00F5FF">-员工通讯录-<a
				href="/maven01/personal/downloadExcel.do">点我下载</a>
			</td>
		</tr>

		<tr>
			<td align="center">员工编号</td>
			<td align="center">员工姓名</td>
			<td align="center">电话</td>
			<td align="center">QQ</td>
			<td align="center">Email</td>
		</tr>

		<c:forEach items="${pageBean.beanList}" var="empMes">
			<tr>
				<td align="center">${empMes.empId}</td>
				<td align="center">${empMes.name}</td>
				<td align="center">${empMes.tel}</td>
				<td align="center">${empMes.qq}</td>
				<td align="center">${empMes.email}</td>
			</tr>
		</c:forEach>

	</table>

	<center>
		<a href="<c:url value='/personal/contactlist?pc=1' />">首页</a> <a
			href="<c:url value='/personal/contactlist?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/personal/contactlist?pc=${pageBean.pc+1}' />">下一页</a>
		<a href="<c:url value='/personal/contactlist?pc=${pageBean.tp}' />">尾页</a>

	</center>
</html>
