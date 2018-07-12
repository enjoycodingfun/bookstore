<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" type="text/css" />

</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />
<script type="text/javascript">

</script>

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath}/view/user/index">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="${pageContext.request.contextPath}/static/ad/page_ad.jpg" width="666" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td><img src="${pageContext.request.contextPath}/static/images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">图片</td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> 
												<table width="100%" border="0" cellspacing="0">
												<c:forEach items="${cart.items}" var="entry">
													<tr>
														<td width="10%"><img style="width:60px;height:60px;" alt="" src="${pageContext.request.contextPath}/static/${entry.value.product.pimage}"></td>
														<td width="30%">${entry.value.product.pname }</td>

														<td width="10%">${entry.value.product.shopPrice}</td>
														<td width="20%">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														${entry.value.buyNum }
														</td>
														<td width="10%">1</td>
														<td width="10%">${entry.value.subTotal }元</td>

														<td width="10%"><a href="javascript:deleteProductFromCart(${entry.value.product.pid })"
															style="color:#FF0000; font-weight:bold">X</a></td>
													</tr>
													</c:forEach>
												</table>
												
											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF6600; font-weight:bold">合计：${cart.total }&nbsp;&nbsp;元</font>
													</td>
												</tr>
											</table>
											<div style="text-align:right; margin-top:10px">
												<a
													href="${pageContext.request.contextPath}/product/showProductByPage?cid=1"><img
													src="${pageContext.request.contextPath}/static/images/gwc_jx.gif" border="0" /> </a>

												&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="${pageContext.request.contextPath}/view/user/order"><img
													src="${pageContext.request.contextPath}/static/images/gwc_buy.gif" border="0" /> </a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />

</body>
<script type="text/javascript">
function deleteProductFromCart(pid){
	window.location.href="${pageContext.request.contextPath}/product/deleteProductFromCart?pid="+pid+"";
	
}
</script>
</html>
