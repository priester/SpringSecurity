<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>论坛</title>
<style type="text/css">
.area {
	border: 1px solid #F90;
	overflow: auto;
}
</style>
</head>
<body>
	${fmes.title} ${fmes.message} ${fmes.time} ${fmes.name}
	<HR
		style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9, strength=10)"
		align="left" width="100%" color=#00F5FF SIZE=1>
	<c:forEach items="${pageBean.beanList}" var="comm">
		${comm.cmmes}
		${comm.cmId}
		${comm.name}
		${comm.time}
		<HR
			style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9, strength=10)"
			align="left" width="100%" color=#00F5FF SIZE=1>
	</c:forEach>
	<center>
		<a href="<c:url value='/commu/forum?pc=1' />">首页</a> <a
			href="<c:url value='/commu/forum?pc=${pageBean.pc-1}' />">上一页</a>
		第${pageBean.pc}页，共${pageBean.tp}页 <a
			href="<c:url value='/commu/forum?pc=${pageBean.pc+1}' />">下一页</a> <a
			href="<c:url value='/commu/forum?pc=${pageBean.tp}' />">尾页</a>
	</center>
	<form method="post">
		<p>
			<textarea name="cmmes" id="textarea" cols="150" rows="5"></textarea>
		</p>
		<input name="Submit" type="submit" class="button" value="发表">
	</form>
</body>
</html>