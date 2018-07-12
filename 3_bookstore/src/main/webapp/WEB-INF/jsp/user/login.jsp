<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
		//ajax异步请求服务器去验证用户名是否正确
		var unameFlag=true;
		$(function(){
			$("input[name='uname']").blur(function(){
				//获得用户名
				var uname=$("input[name='uname']");
				if(uname.val()!=null&&uname.val()!=""){
					$.ajax({
						url:"${pageContext.request.contextPath}/user/checkUname",
						method:"post",
						data:{"uname":uname.val()},
						dataType:"json",
						cache:"false",
						async:"true",
						success:function(data){
							if(data.flag=='1'){
								$("#err").html("<font color='green'>用户名输入正确<font>");
								unameFlag=true;
							}
							//置空
							//$("input[name='uname']").val("");
							//获取焦点
							else if(data.flag=='0'){
								$("#err").html("<font color='red'>用户名输入有误<font>");
							$("input[name='uname']").focus();
							unameFlag=false;
							}
							},
						/* error:function(){
							alert("服务器端异常");
						} */
						
					});
				}
			});
			
			
			
			
			
			
			
			
		});
	function formcheck(){
		var uname=$("input[name='uname']");
		var upwd=$("input[name='uname']");
		if(uname==null||uname==""){
			alert("用户名不能为空");
			$("input[name='uname']").focus();
			return false;
		}else if(upwd==null||upwd==""){
			alert("密码不能为空");
			$("input[name='upwd']").focus();
			return false;
			
		}else if(!unameFlag){
			alert("用户名输入不正确");
			$("input[name='uname']").focus();
			return false;
		}
		return true;
	}


</script>

</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
<%
	//取出cookie
	Cookie[] cookies=request.getCookies();
	String username="";
	String upwd="";
	String autoLogin="";
	
	if(cookies!=null){
	for(Cookie c : cookies){
		if("username".equals(c.getName())){
			username=c.getValue();
			
		}if("upwd".equals(c.getName())){
			upwd=c.getValue();
			
		}if("autoLogin".equals(c.getName())){
			autoLogin=c.getValue();
			
		}
	}
	}

	//把用户名和密码存储到page域对象
	pageContext.setAttribute("uname", username);
	pageContext.setAttribute("upwd", upwd);
	pageContext.setAttribute("autoLogin", autoLogin);
	



%>
	<div id="divcontent">
		<form  id="form" action="${pageContext.request.contextPath }/user/login" method="post" onsubmit="return formcheck()">
			<input type="hidden" value="login" name="action">
			<table width="900px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px"><div style="height:470px">
							<b>&nbsp;&nbsp;首页&nbsp;&raquo;&nbsp;个人用户登录</b>
							<div>
								<table width="85%" border="0" cellspacing="0">
									<tr>
										<td>
											<div id="logindiv">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td style="text-align:center; padding-top:20px"><img
															src="${pageContext.request.contextPath}/static/images/logintitle.gif" width="150" height="30" />
														</td>
													</tr>
													<tr>
														<td id="err" style="text-align:center;padding-top:20px;"><font
															color="#ff0000">${requestScope.error}<%-- ${requestScope["register_message"]} --%></font>
														</td>
													</tr>
													<tr>
														<td style="text-align:center">
															<table width="80%" border="0" cellspacing="0"
																style="margin-top:15px ;margin-left:auto; margin-right:auto">
																<tr>
																	<td
																		style="text-align:right; padding-top:5px; width:25%">用户名：</td>
																	<td style="text-align:left"><input name="uname"
																		type="text" class="textinput" value="${uname }" id="uname" />
																	</td>
																</tr>
																<tr>
																	<td style="text-align:right; padding-top:5px">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
																	<td style="text-align:left"><input name="upwd"
																		type="password" class="textinput" id="upwd" value="${upwd }" />
																	</td>
																</tr>
																<tr>
																	<td colspan="2" style="text-align:center"><input
																		type="checkbox" name="rememberMe" value="on" id="rememberMe" />
																		记住用户名&nbsp;&nbsp; <input type="checkbox"
																		name="autoLogin" id="autoLogin" value="on" /> 自动登录</td>
																</tr>
																<tr>
																	<td colspan="2"
																		style="padding-top:10px; text-align:center"><input
																		name="image" type="image" 
																		src="${pageContext.request.contextPath}/static/images/loginbutton.gif" width="83" height="22" />
																	</td>
																</tr>

																<tr>
																	<td colspan="2" style="padding-top:10px"><img
																		src="${pageContext.request.contextPath}/static/images/loginline.gif" width="241" height="10" />
																	</td>
																</tr>
																<tr>
																	<td colspan="2"
																		style="padding-top:10px; text-align:center"><a
																		href="${pageContext.request.contextPath}/view/user/register"><img name="image"
																			src="${pageContext.request.contextPath}/static/images/signupbutton.gif" width="135" height="33" />
																	</a></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div></td>
										<td style="text-align:left; padding-top:30px; width:60%"><h1>您还没有注册？</h1>
											<p>注册新会员，享受更优惠价格!</p>
											<p>千种图书，供你挑选！注册即享受丰富折扣和优惠，便宜有好货！超过万本图书任您选。</p>
											<p>超人气社区！精彩活动每一天。买卖更安心！支付宝交易超安全。</p>
											<p style="text-align:right">
												<a href="${pageContext.request.contextPath}/view/user/register"><img
													src="${pageContext.request.contextPath}/static/images/signupbutton.gif" width="135" height="33" /> </a>
											</p>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>



	<jsp:include page="foot.jsp" />


</body>
<script type="text/javascript">
$(function(){

	
	//从input框里面
/* window.location.href='${pageContext.request.contextPath}/login?username=${username}&upwd=${upwd}'; */
	var username=document.getElementById("uname").value;
	var upwd=document.getElementById("upwd").value;
	if(username!=""){
		document.getElementById("rememberMe").checked="checked";
	}
	
	
});


</script>
<script type="text/javascript">
$(function(){
	var auto="${autoLogin}";
	//从input框里面
/* window.location.href='${pageContext.request.contextPath}/login?username=${username}&upwd=${upwd}'; */
	var username=document.getElementById("uname").value;
	var upwd=document.getElementById("upwd").value;
	if(username!=""){
		document.getElementById("rememberMe").checked="checked";
	}
	if(auto!="" &&username!=""&&upwd!=""){
		document.getElementById("autoLogin").checked="checked";
		$("#form").submit();
	}
	
});
</script>
</html>

