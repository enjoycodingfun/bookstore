<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>js左侧边导航菜鼠标悬停展开二级菜单导航</title>
<meta name="description" content="用js制作一个js导航菜单，左侧纵向二级导航菜单，鼠标滑过当前选区高亮显示二级菜单内容，带点击展开和收缩按钮控制。内含js代码下载。" />

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
body{font-family:\5B8B\4F53,Arial Narrow,arial,serif;background:#FFFFFF;color:#000;font-size:12px;line-height:20px;text-align:left;}
a{color:#03c;text-decoration:none;}
a:hover{color:#f60;text-decoration:none;}

/* tjskl-sidebar */
.tjskl-sidebar{width:183px;margin:10px auto;}
.tjskl-sidebar #submain_hidden{border-top:0;display:none;}
.tjskl-sidebar .bsb{border-bottom:1px solid #c8d2e5;border-top:0;}
/* tj_submain */
.tj_submain{border:1px solid #c8d2e5;border-bottom:0;width:181px;font-weight:normal;}
.tj_submain .title{background:url("") repeat-x 0 -38px;height:24px;line-height:24px;font-size:12px;font-weight:bold;width:161px;padding-left:20px;}
.tj_submain li{width:181px;height:30px;border-bottom:1px solid #E7F3FF;position:relative;}
.tj_submain li a{width:141px;display:inline-block;padding:0 20px;height:30px;line-height:30px;}
.tj_submain li a.on{background:url("") no-repeat scroll 0 -9px;border-top:1px solid #FFC83D;width:161px;height:29px;line-height:29px;padding:0px 0px 0px 20px;position:relative;z-index:90;}
.tj_submain span{position:absolute;top:0;left:180px;z-index:1;background-color:#FFFAE2;border:#FFC83D solid 1px;display:none;}
.tj_submain span a{display:block;height:26px;line-height:26px;}
.tj_submain span a:hover{background:#FFFAE2;background:#ebf0f5;text-decoration:none;}
.tj_submain ul li{float:left;margin-right:10px;display:inline;}
.tj_submain ul li span a{text-decoration:none;}
.tj_submain ul li span a:hover{color:#f60;}
.tj_submain #more_submenu a{background:url("") no-repeat;text-align:right;display:block;width:125px;padding-right:19px;cursor:pointer;}
.tj_submain #more_submenu a.show{background-position:100% 2px;}
.tj_submain #more_submenu a.less{background-position:100% -25px;}
</style>

<script type="text/javascript">
function do_list_row_show(strid){
	strid.getElementsByTagName('a')[0].className='on';
	strid.getElementsByTagName('span')[0].style.display="block";
	strid.style.position="relative";
}
function do_list_row_unshow(strid){
	strid.getElementsByTagName('a')[0].className='';
	strid.getElementsByTagName('span')[0].style.display="";
	strid.style.position="";
}
submenu = function(box,div){
	var div_classname = document.getElementById(div).getElementsByTagName('a')[0];
	if(div_classname.className=='show'){
		with(document.getElementById(box).style){
			height='auto';display='block';
		}
		div_classname.className='less';div_classname.innerHTML='收缩';
	}else{
		with(document.getElementById(box).style){
			height='0';display='none';
		}
		div_classname.className='show';div_classname.innerHTML='展开';
	}
}
</script>

</head>
<body>

	<div class="tjskl-sidebar">
	
		<ul class="tj_submain">
			<li class="title"><a href="javascript:void(0)">后台管理系统</a></li>
			<li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
				<a href="#">商品管理</a>
			</li>
			<li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
				<a href="${pageContext.request.contextPath}/admin/showAllProducts" target="mainFrame">商品查看</a>
				
			</li>
			<li onMouseOut="do_list_row_unshow(this);" onMouseOver="do_list_row_show(this);">
				<a href="${pageContext.request.contextPath}/admin/showAllOrders" target="mainFrame">订单管理</a>
			</li>
		</ul>
	</div><!--tjskl-sidebar end-->
</body>
</html>
