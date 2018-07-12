<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

<div id="divpagecontent">
	<table width="900px" border="0" cellspacing="0">
		<tr>
			<td>
				<div style="text-align: right; margin: 5px 10px 5px 0px">
				<a href="${pageContext.request.contextPath}/view/user/index">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机

						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;商品列表
				</div>

				<table cellspacing="0" class="listcontent">
					<tr>
						<td>
							<h1>商品目录</h1>
							<hr />
							<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
							<hr />
							<div style="margin-top: 20px; margin-bottom: 5px">
							<img src="${pageContext.request.contextPath }/static/images/productlist.gif"
										width="100%" height="38" />
							</div>
					<table cellspacing="0" class="booklist">
				<tr>
			<c:forEach items="${list }" var="p">

					<td>
				<div class="divbookpic">
					<p>
					<a href="${pageContext.request.contextPath}/product/toProductInfo?pid=${p.pid}">
					<img src="${pageContext.request.contextPath}/static/${p.pimage}"
					width="115" height="129" border="0" /> </a>
					</p>
				</div>
					<div class="divlisttitle">
					<a href="${pageContext.request.contextPath}/product/toProductInfo?pid=${p.pid}">
					商品名:${p.pname }<br/>售价:${p.shopPrice}</a>
					</div></td>
			</c:forEach>
				</tr>
					</table>
						<div class="pagination">
							<ul>
			<div>
	跳转：<input style="width: 30px;" type="text" value="" id="currentPage" onblur="goC();">
	当前页：${page.pageNum }/${page.pages }<a href="${uri }currentPage=1">首页</a>
			<c:if test="${page.hasPreviousPage}">
				<a href="${uri }currentPage=${page.prePage}">上一页</a>
			</c:if>
			<c:forEach items="${page.navigatepageNums }" var="index">
			<c:choose>
				<c:when test="${page.pageNum==index }">
				<a style="color: red;" href="${uri }currentPage=${index}">第${index }页</a>
				</c:when>
				<c:otherwise>
				<a style="color: black;" href="${uri }currentPage=${index}">第${index }页</a>
				</c:otherwise>
			</c:choose>
			</c:forEach>
				<c:if test="${page.hasNextPage }">
					<a href="${uri }currentPage=${page.nextPage}">下一页</a>
				</c:if>
					<a href="${uri }currentPage=${page.pages}">尾页</a>
						总个数：${page.total };
				</div>
			</ul>
		</div>
		</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
<script type="text/javascript">
	function goC() {
		var a = document.getElementById("currentPage").value;
		if (a != '') {
			window.location.href = "${uri}currentPage=" + a;
		}
	}
</script>
</html>
