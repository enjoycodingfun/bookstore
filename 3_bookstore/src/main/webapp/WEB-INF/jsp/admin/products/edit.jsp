<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/static/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/static/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/static/js/check.js"></script>

</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/admin/updateProduct" method="post"
		enctype="multipart/form-data">
		<td><input type="hidden" value="${p.pid}" name="pid"></td>
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pname" class="bg" value="${p.pname}" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="marketPrice" class="bg" value="${p.marketPrice}" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">是否热门：</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="radio" name="isHot" ${p.isHot==1? 'checked="checked"':'' } value=1 class="bg" />是
	
				<input type="radio" name="isHot" ${p.isHot==0? 'checked="checked"':''} value=0 class="bg" />否
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="cid" id="category">
					<c:forEach items="${list}" var="c">
					<option value="${c.cid}">${c.cname}</option>
					</c:forEach>
					</select>
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td align="center"><a href="${pageContext.request.contextPath}/product/toProductInfo?pid=${p.pid}">
									<img src="${pageContext.request.contextPath}/static/${p.pimage}"
									width="115" height="129" border="0"/> </a></td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file" name="file" size="30" value="" /></td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
						name="pdesc" cols="30" rows="3" style="WIDTH: 96%">${p.pdesc}</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/static/images/admin/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>
</body>
<!-- 让商品类别回显 -->
<script type="text/javascript">
var catagory = document.getElementById("category");//获取select元素
var cid = ${p.cid}//获取商品的实际cid
var opt = document.getElementsByTagName("option");//获取option元素集合
for(var i=0;i<opt.length;i++){
	if(opt[i].value==cid){//遍历每一个选项的value也就是类目的cid,与实际相同则选中
		opt[i].selected="true";
	}
}



</script>
</HTML>