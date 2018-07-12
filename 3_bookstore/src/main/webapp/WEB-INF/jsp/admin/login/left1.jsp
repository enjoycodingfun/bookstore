<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/static/css/left.css" rel="stylesheet" type="text/css">
<link rel="StyleSheet" href="${pageContext.request.contextPath}/static/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/dtree.js"></script>
	<script type="text/javascript">
		
		/* d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(1,0,'商品管理','${pageContext.request.contextPath}/view/admin/login/welcome','','mainFrame');
		d.add(2,0,'订单管理','${pageContext.request.contextPath}/view/admin/login/welcome','','mainFrame');
		
		
		//子目录添加
		d.add(11,1,'商品查看','${pageContext.request.contextPath}/admin/showAllProducts','','mainFrame');
		
		
		d.add(21,2,'订单查看','${pageContext.request.contextPath}/view/admin/orders/list','','mainFrame');
	
		
		document.write(d); */
		
		
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
