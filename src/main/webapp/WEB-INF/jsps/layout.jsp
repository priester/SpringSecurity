<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/my.css">
</head>
<body>
	<table class="bordered"> 
    <tr bgcolor="#E0FFFF">
        <td height="85" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr bgcolor="#F5FFFA">
        <td valign="top" height="520" width="150"><tiles:insertAttribute name="menu" /></td>
        <td valign="top" ><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr bgcolor="#E0FFFF">
        <td height="10" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>