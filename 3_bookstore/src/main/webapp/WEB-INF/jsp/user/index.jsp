<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>bookStore首页</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" type="text/css" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//初始化书籍类目
	initNews();
});

function initNews(){
	$.ajax({
		url:"${pageContext.request.contextPath }/user/showNews",
		dataType:"json",
		type:"post",
		cache:"false",
		async:"true",
		
		success:function(data){
			var ne = data.news;
			var str="";
			for(var i=0;i<ne.length;i++){
				if(ne[i].title.length<=30){
					str+="<tr><td>&middot;<a href=\"#\" style=\"color:#000000\">"+ne[i].title+"</a></td></tr>";
				}else if(ne[i].title.length>30)
				str+="<tr><td>&middot;<a href=\"#\" style=\"color:#000000\">"+ne[i].title.substring(0,29)+">></a></td></tr>";							
			}	
			$("#initNews").html(str);
		},
	});
}
 

</script>

<body class="main">

	<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	<div id="divad">
		<img src="${pageContext.request.contextPath}/static/ad/index_ad.jpg" />
	</div>

	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497"><img src="${pageContext.request.contextPath}/static/images/billboard.gif" width="497"
					height="38" />
					<table cellspacing="0" class="ctl" id="initNews">
					
				
					
						<!-- <tr>
							<td>&middot;<a href="news.html" style="color:#000000">Lonely
									Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">2007年中旅游图书畅销榜速递
									中国游,世界游,旅游图书全部7折封顶</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
									畅销榜新书速递,促销天天有</a></td>
						</tr>  -->
					</table></td>
				<td style="padding:5px 15px 10px 40px"><table width="100%"
						border="0" cellspacing="0">
						<tr>
							<td><span style="color:black;font-size:16px;font-weight: bold;">热门商品</span>
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="${pageContext.request.contextPath}/static/bookcover/travelbook.jpg" width="102" height="130"
									border="0" /> </a><br /> <a href="info.html">TravelBook<br />
									作者:Lonley Plant</a></td>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="${pageContext.request.contextPath}/static/bookcover/java2.jpg" width="102" height="130" border="0" />
							</a><br /> <a href="info.html">Java2入门经典(JDK5) <br /> 作者:(美)霍顿</a>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp"/>


</body>
</html>
