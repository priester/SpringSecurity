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
        <h1>Common Page</h1>  
        <p>每个人都能访问的页面.</p>  
        <div>username : <sec:authentication property="name"/></div>
        <a href="/maven01/main/admin"> Go AdminPage </a>  
        <br/>  
     
<a href="j_spring_security_logout">Log Out</a>
      
    </body>  
    </html>  