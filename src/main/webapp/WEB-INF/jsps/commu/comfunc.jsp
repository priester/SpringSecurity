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
	<form method="post">
		<p>
			<textarea name="message" id="textarea" cols="150" rows="5"></textarea>
		</p>
		<input name="Submit" type="submit" class="button" value="发表">
	</form>
</body>
</html>