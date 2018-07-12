<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
			<a href="${pageContext.request.contextPath }/view/user/index">
				<img src="${pageContext.request.contextPath}/static/images/logo.png"width="95" height="30" border="0" /> 
			</a>
			</td>
			<td style="text-align:right"><img src="${pageContext.request.contextPath}/static/images/cart.gif"
				width="26" height="23" style="margin-bottom:-4px" />&nbsp;
				<a href="${pageContext.request.contextPath}/view/user/cart">购物车</a> | 
				<a href="#">帮助中心</a> | 
				
				<c:if test="${empty sessionScope.user }">
				<a href="${pageContext.request.contextPath}/view/user/login">您好,请登录</a>
				</c:if>
				
				<c:if test="${!empty sessionScope.user }">
				<span>欢迎您：${sessionScope.user.uname }</span>
				</c:if>
				
				
				|<a href="${pageContext.request.contextPath}/view/user/register">新用户注册</a>
				
				
				|<a href="${pageContext.request.contextPath }/user/logout">注销</a> |
				| <a href="${pageContext.request.contextPath }/view/user/myAccount">我的账户</a> 
				</td>
		</tr>
	</table>
</div>