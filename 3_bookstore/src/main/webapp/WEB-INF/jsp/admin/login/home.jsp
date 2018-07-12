<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
		body
		{
			SCROLLBAR-ARROW-COLOR: #ffffff;  SCROLLBAR-BASE-COLOR: #dee3f7;
		}
    </style>
  </head>
  
<frameset rows="103,*,43" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/view/admin/login/top" name="topFrame" scrolling="NO" noresize>
  <frameset cols="159,*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/view/admin/login/left" name="leftFrame" noresize scrolling="YES">
		<frame src="${pageContext.request.contextPath}/view/admin/products/list" name="mainFrame">
  </frameset>
  <frame src="${pageContext.request.contextPath}/view/admin/login/bottom" name="bottomFrame" scrolling="NO"  noresize>
</frameset>
</html>
