<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
.text1 {
	border: 1px solid #f60;
	color: #03C;
}

.text2 {
	border: 2px solid #390;
	width: 200px;
	height: 24px;
	font-size: 16px;
	font-weight: bold;
	line-height: 1.6;
}

.text3 {
	border: 2px solid #C3C;
	height: 20px;
	background: #ffeeff url(/upload/2010-08/28/icon9.gif) right 3px
		no-repeat;
}

.text4 {
	border: 2px solid #F60;
	width: 150px;
	height: 29px;
	font-size: 16px;
	line-height: 1.6;
	background:  0 0 no-repeat;
}

.area {
	border: 1px solid #F90;
	overflow: auto;
	background: #fff url(/upload/2010-08/28/bg_9_1.gif) right bottom
		no-repeat;
	width: 99%;
	height: 100px;
}
</style>
</head>
<body>
	<p>
		<input type="text" name="textfield" id="textfield" /> 这是默认样式
	</p>
	<p>
		<input name="textfield2" type="text" class="text1" id="textfield2"
			value="我是蓝色的" /> 这是改变边框的样式和文字颜色
	</p>
	<p>
		<input name="textfield3" type="text" class="text2" id="textfield3"
			value="看我大吧" /> 这是改变边框并设置高宽和字体大小的样式
	</p>
	<p>
		<input class="text3" type="text" name="textfield4" id="textfield4" />
		这是增加背景图片实例，也可放左侧
	</p>
	<p>
		<input class="text4" type="text" name="textfield5" id="textfield5" />
		这是增加了一个背景图片为gif动画
	</p>
	<p>
		<textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
	</p>
	<p>
		<textarea class="area" name="textarea2" id="textarea2" cols="45"
			rows="5"></textarea>
	</p>
</body>
</html>