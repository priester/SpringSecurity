<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/maven01/user/list">用户管理</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="/maven01/personal/showmessage">信息管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/maven01/worktime/dakaTest">个人考勤</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/maven01/worktime/dakaTest">工资情况</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/maven01/commu/forum">交流园地</a><br>     
<div>username : <sec:authentication property="name"/></div>
<a href="/maven01/user/updatepw">修改密码</a>                                       
<a href="/maven01/login">退出</a><br>
</body>
</html>