<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
<link rel="stylesheet" href="<%=basePath %>/css/my.css">
</head>
<body>
<table class= "zebra">
<!-- <table width="94%"  border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#97B150" > -->
  <tr>
    <td height="22" colspan="4" align="center" bgcolor="#00F5FF">-添加用户-</td>
  </tr>
  <sf:form method="post" modelAttribute="user">
  

  <tr align="center">
    <td width="40%" height="27" >用户名：</td>
    <td height="22" align="left" ><sf:input path="userName"/></td>
  </tr>
  
  <tr align="center">
    <td width="40%" height="27" >密码：</td>
    <td height="22" align="left" ><sf:input path="password" /></td>
  </tr>
 
  <tr>
    <td height="27" colspan="4" align="center" ><input type="submit" value="添加"/>
  </tr>
  </sf:form>
</table>		
</body>
</html>