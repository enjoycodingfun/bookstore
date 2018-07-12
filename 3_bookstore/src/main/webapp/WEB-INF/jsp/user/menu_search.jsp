<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/my.js"></script>
	
 <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.0.js"></script> 
<script type="text/javascript">
	$(document).ready(function(){
		//初始化书籍类目
		initCategory();
		
		
		
	});
	
function initCategory(){
	$.ajax({
		url:"${pageContext.request.contextPath}/category/ajaxFindCategorys",
		dataType:"json",
		type:"post",
		cache:"false",
		async:"true",
		success:function(data){//list<Category>
			var str="";
			var categorys = data.categorys;
			for(var i=0;i<data.categorys.length;i++){
				str+="<a href=\"${pageContext.request.contextPath}/product/showProductByPage?cid="+data.categorys[i].cid+"\">"+data.categorys[i].cname+"</a>";							
			}
			$("#divmenu").html(str);
			
		},
		/* error:function(){
			
			alert("服务器端异常");
		} */		
	});
}
</script>

<div id="divmenu">
	 <a
		href="${pageContext.request.contextPath}/showProductByPage?category=文学">文学</a>
	 <a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活">生活</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=计算机">计算机</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=外语">外语</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=经营">经管</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=励志">励志</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=社科">社科</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=学术">学术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=少儿">少儿</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=艺术">艺术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=原版">原版</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=科技">科技</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=考试">考试</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活百科">生活百科</a>
	 <a href="${pageContext.request.contextPath}/showProductByPage"
		style="color:#FFFF00">全部商品目录</a> 
</div>
<div id="divsearch">
	<form action="${pageContext.request.contextPath}/product/findProduct"
		method="post">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input
					type="text" name="name" value="${name }" class="inputtable" onkeyup="searchName();"
					id="name" /> 
					<input type="image" src="${pageContext.request.contextPath}/static/images/serchbutton.gif"
					border="0" style="margin-bottom:-4px">
				</td>
			</tr>
		</table>

	</form>
</div>
<div id="content"
	style="background-color:white;width:128px; text-align:left;margin-left:945px;color:black;float:left;margin-top: -20px;display: none">
</div>