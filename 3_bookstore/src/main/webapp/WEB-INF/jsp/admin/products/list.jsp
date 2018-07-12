<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/static/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/product/showaddpage";
	}
	function fa() {
		var a = document.getElementById("currentpage").value;
		if (a != '') {
			location.href = "${uri}currentpage=" + a;
		}
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/admin/findProductByManyCondition"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									商品编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="pid" size="15" value="${pid}" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									类别：</td>
								<td class="ta_01" bgColor="#ffffff"><select name="cid"
									id="category" value="">
										<option value="" selected="selected">--选择商品类目--</option>
										<c:forEach items="${categorys}" var="c">
											<option value="${c.cid}">${c.cname}</option>
										</c:forEach>
								</select></td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									商品名称：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="pname" size="15" value="${pname}" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									价格区间(元)：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="minprice" size="10" value="${minprice}" />- <input type="text"
									name="maxprice" size="10" value="${maxprice}" /></td>
							</tr>

							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%">商品编号</td>
								<td align="center" width="14%">商品图片</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">是否热门</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>

								<td width="8%" align="center">删除</td>
							</tr>

							<c:forEach items="${list}" var="p">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23">${p.pid}</td>
									<td align="center"><a href="${pageContext.request.contextPath}/product/toProductInfo?pid=${p.pid}">
									<img src="${pageContext.request.contextPath}/static/${p.pimage}"
									width="115" height="129" border="0"/> </a></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${p.pname}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${p.marketPrice}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">
										${p.isHot==1?"是":"否"}
										</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${p.category.cname}</td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/admin/showeditpage?pid=${p.pid}">
											<img
											src="${pageContext.request.contextPath}/static/images/admin/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="7%">
									<a href="javascript:" onclick="deleteById('${p.pid}')">
											<img
											src="${pageContext.request.contextPath}/static/images/admin/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand" >
									</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
			<td colspan="8" align="center">
			跳转<input type="text" id="currentpage" onblur="fa();" >当前页${page.pageNum}/${page.pages}
			<a href="${uri}currentpage=1">首页</a>
			<c:if test="${page.hasPreviousPage}">
				<a href="${uri}currentpage=${page.prePage}">上一页</a>
			</c:if>
			
			<c:forEach items="${page.navigatepageNums}" var="p">
				<c:choose>
					<c:when test="${page.pageNum==p}">
						<a style="background-color: #999" href="${uri}currentpage=${p}" >第${p}页</a>
					</c:when>
					<c:otherwise>
						<a style="background-color: white" href="${uri}currentpage=${p}" >第${p}页</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${page.hasNextPage}">
				<a href="${uri}currentpage=${page.nextPage}">下一页</a>
			</c:if>
			<a href="${uri}currentpage=${page.pages}">尾页</a>
			</td>
			</tr>
			<tr><td colspan="10" align="center">总个数${page.total}</td></tr>
							
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
<script type="text/javascript">

function deleteById(id){
	if (confirm("确认删除吗？")!= true)
		return;
	$.ajax({
		url:"${pageContext.request.contextPath}/admin/deleteProduct/"+id,
		type:"post",
		data:{"_method":"DELETE"},
		async:false,
		success:function(d){
			if(d.flag=='1'){
				alert('删除成功');
				location.href="${pageContext.request.contextPath}/admin/showAllProducts";
			}
			else{
				alert('异常');
			}
		},
		dataType:"json"
	})
}
var catagory = document.getElementById("category");//获取select元素
var cid = ${cid}//获取查询的实际cid
var opt = document.getElementsByTagName("option");//获取option元素集合
for(var i=0;i<opt.length;i++){
	if(opt[i].value==cid){//遍历每一个选项的value也就是类目的cid,与实际相同则选中
		opt[i].selected="true";
	}
}
</script>
</HTML>

