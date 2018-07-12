<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css" type="text/css" />



</head>


<body class="main">
	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/view/user/index">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath }/view/user/cart">&nbsp;购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单
					</div>

					<form id="orderForm" action="${pageContext.request.contextPath }/order/createOrder" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td><table width="100%" border="0" cellspacing="0">
										<tr>
											<td><img src="${pageContext.request.contextPath }/static/images/buy2.gif" width="635" height="38" />
												<p>您好：${user.uname }先生！欢迎您来到商城结算中心</p></td>
										</tr>
										<tr>
											<td>
											
											<table cellspacing="1" class="carttable">
													<tr>
														<td width="10%">图片</td>
														<td width="40%">商品名称</td>
														<td width="10%">价格</td>
														<td width="10%">类别</td>
														<td width="10%">数量</td>
														<td width="10%">小计</td>

													</tr>
												</table>

												<table width="100%" border="0" cellspacing="0">
													<c:forEach  items="${cart.items }" var="entry">
													<tr>
														<td width="10%"><img style="width:30px;height:30px;" alt="" src="${pageContext.request.contextPath }/static/${entry.value.product.pimage }"></td>
														<td width="40%">${entry.value.product.pname }</td>
														<td width="10%">${entry.value.product.shopPrice }</td>
														<td width="10%">${entry.value.product.cid }</td>
														<td width="10%"><input name="text" type="text"
															value="${entry.value.buyNum}" style="width:20px" readonly="readonly" /></td>
														<td width="10%">${entry.value.subTotal }</td>

															</c:forEach>
												</table>


												<table cellspacing="1" class="carttable">
													<tr>
														<td style="text-align:right; padding-right:40px;"><font
															style="color:#FF0000">合计：&nbsp;&nbsp;${cart.total }元</font></td>
													</tr>
												</table>
											
												<p>
													收货地址：<input name="receiverAddress" type="text" value=""
														style="width:350px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input
														name="receiverName" type="text" value="${user.uname }"
														style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 联系方式：<input type="text" name="receiverPhone"
														value="${user.utel }" style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;

												</p>
												<hr />
												<p style="text-align:right">
													<input type="image" src="${pageContext.request.contextPath }/static/images/gif53_029.gif" width="204" height="51"
														border="0" />
												</p>
												
												
												</td>
												
										</tr>
									</table>
									</td>
							</tr>
						</table>
					</form></td>
			</tr>
		</table>
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
