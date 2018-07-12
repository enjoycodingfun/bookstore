<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" type="text/css" />
</head>

<body class="main">
	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/static/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/view/user/modifyuserinfo">用户信息修改</a></td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/static/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/order/showMyorders?name=${sessionScope.user.uname}">订单查询</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="${pageContext.request.contextPath}/static/images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">用戶退出</a>
							</td>
						</tr>
					</table></td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath}/view/user/index">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/view/user/myAccount">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<form action="${pageContext.request.contextPath}/user/modifyUserInfo" method="post">
									<input type="hidden" name="uid" value="${sessionScope.user.uid}">
									<table width="100%" border="0" cellspacing="2" class="upline">
										<tr>
											<td style="text-align:right; width:20%" >会员邮箱：</td>
											<td style="width:40%; padding-left:20px">
											<input type="text" name="uemail" class="textinput"
											value="${sessionScope.user.uemail}"/>
											</td>
											<td>&nbsp;</td>


										</tr>
										<tr>
											<td style="text-align:right">会员名：</td>
											<td style="padding-left:20px" >
											<input type="text" name="uname" class="textinput"
											value="${sessionScope.user.uname}"/>
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align:right">修改密码：</td>
											<td><input type="password" name="password"
												class="textinput" />
											</td>
											<td><font color="#999999">密码设置至少6位，请区分大小写</font>
											</td>
										</tr>
										<tr>
											<td style="text-align:right">重复密码：</td>
											<td><input type="password" class="textinput" />
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align:right">性别：</td>
											<td colspan="2"><c:if test="${sessionScope.user.ugender=='男'}">
	 <input type="radio" name="ugender" value="男" checked="checked">男<input type="radio" name="ugender" value="女">女
	</c:if>
	<c:if test="${sessionScope.user.ugender=='女'}">
	 <input type="radio" name="ugender" value="男" >男<input type="radio" name="ugender" value="女" checked="checked">女
	</c:if></td>
										</tr>
										<tr>
											<td style="text-align:right">联系方式：</td>
											<td colspan="2"><input name="utel" type="text"
												value="${sessionScope.user.utel}" class="textinput" />
											</td>
										</tr>

										<tr>
											<td style="text-align:right">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>


									<p style="text-align:center">

										<input type="image" src="${pageContext.request.contextPath}/static/images/botton_gif_025.gif" border="0">

									</p>
									<p style="text-align:center">&nbsp;</p>
								</form></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
