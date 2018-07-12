<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常地址页</title>
</head>
<body>
		<div align="center"><font color="red">发现未知错误,页面走丢了~~~~!!!${msg}</font></div>
		<img width="100%" alt="图片也丢了" src="${pageContext.request.contextPath}/static/images/error1.jpg">
</body>
</html>