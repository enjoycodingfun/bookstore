<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/codeImageServlet?time="+new Date().getTime()+"";
	};
	
	$(function(){
		$("#myform").validate({
			rules:{
				"uname":{
					"required":true
				}
				
			}
			
		})
	})
	
</script>


</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/user/register"
			method="post" id="form">
			<!--<input type="hidden" name="action" value="register" /> -->
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%">
								<input type="text" class="textinput"
									name="uemail" id="uemail"/></td>
								<td><font color="#999999">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td>
									<input type="text" class="textinput" name="uname" id="uname" />
								</td>
								<td><font color="#999999">用户名设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="upwd" id="upwd" /></td>
								<td><font color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="reupwd" id="reupwd" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="ugender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="ugender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="utel" id="utel" /></td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="uintroduce" id="uintroduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput" id="code" name="code"/>
								<span id="codeError"></span>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/codeImageServlet" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="${pageContext.request.contextPath }/static/images/signup.gif" name="submit" border="0" id="sub">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="${pageContext.request.contextPath }/static/images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2012 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
<script type="text/javascript">
var codeFlag=false;//表示验证不对
$(function(){
	$("#form").submit(function(){
		var uemail=$("#uemail").val();
		var uname=$("#uname").val();
		var upwd=$("#upwd").val();
		var reupwd=$("#reupwd").val();
		var utel=$("#utel").val();
		
		var regexEmail=/^\w+@\w+\.\w+$/;
		var regexName=/^\w{6,}$/;
		var regexpwd=/^\w{6,}$/;
		var regexTel=/^[1][3458]\d{9}$/;
		
		if(!codeFlag){
			changeImage();
			$("#code").focus();
			return false;
		}
		if(!regexEmail.test(uemail)){
			
			alert("请输入正确的邮箱格式");
			$("#uemail").focus();
			return false;
		}
		if(!regexName.test(uname)){
			alert("请输入正确的用户名");
			$("#uname").focus();
			return false;
			
		}
		if(!regexpwd.test(upwd)){
			alert("请输入正确的密码格式");
			$("#upwd").focus();
			return false;
			
		}
		if(reupwd!=upwd){
			alert("两次输入的密码不一样");
			$("#reupwd").focus();
			return false;
			
		}
		if(!regexTel.test(utel)){
			alert("请输入正确的手机号");
			$("#utel").focus();
			return false;
			
		}
		
		return true;
		
	});	
	
	
	
	$("#code").blur(function(){//验证码失去焦点的时候去校验
		var  code=$("#code").val();

			//获取验证码
			$.ajax({
				url:"${pageContext.request.contextPath}/user/checkCode",
				data:{"code":code},
				dataType:"json",
				type:"post",
				cache:"false",
				success:function(data){
					if(data.flag=='1'){//对
						//改变验证码的标志
						codeFlag=true;
						$("#codeError").html("验证码ok！").css("color","green");
					}else{//验证不对
						codeFlag=false;//置为false
						$("#codeError").html("验证码错误！").css("color","red");
						//获取焦点
						$(this).focus();
						
					}
					
				},
				/* error:function(){
					alert("服务器异常~~");
				}	 */
		
	});
});
	
});
</script>
</html>
