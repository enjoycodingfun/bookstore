<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.0.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#buy").click(function(){
		
		var buyNum=$("#buyNum").val();
		
		window.location.href="${pageContext.request.contextPath}/product/addProductToCart?pid=${p.pid}&buyNum="+buyNum;

	});
	
	
});


function fm(){
	var val = $("#buyNum").val()-1;
	val = val>1? val:1;
	$("#buyNum").val(val);
}
function fp(){
	var val = $("#buyNum").val();
	val++;
	$("#buyNum").val(val);
}



</script>
</head>


<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath}/view/user/index">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/view/user/product_list">&nbsp;${p.category.cname }</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${p.pname}
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="${pageContext.request.contextPath }/static/ad/page_ad.jpg" width="645" height="84" />

								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img src="${pageContext.request.contextPath }/static/${p.pimage}"
														width="213" height="269" border="0" />
												</p>
											</div>

											<div style="text-align:center; margin-top:25px">
												<a href="#" id="buy">
													<img src="${pageContext.request.contextPath }/static/images/buybutton.gif" border="0" /> 
												</a>
											</div></td>
										<td style="padding:20px 5px 5px 5px"><img
											src="${pageContext.request.contextPath }/static/${p.pimage}" width="16" height="13" /><font
											class="bookname">&nbsp;&nbsp;Thinking in java</font>

											<hr />售价：<font color="#FF0000">￥${p.shopPrice }</font>
											&nbsp;市场价<span style="text-decoration: line-through;">￥${p.marketPrice }</span>
											<hr /> 类别：${p.category.cname }

											<hr />
											购买数量：<input type="button" value='-'
															style="width:20px" id="min" onclick="fm()">

															<input name="buyNum" type="text" id="buyNum" 
															style="width:40px;text-align:center" value="1" > <input
															type="button" value='+' style="width:20px" id="plus"
															onclick="fp()"> 
											<p>
												<b>内容简介：</b>
											</p> ${p.pdesc }</td>
									</tr>
								</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
