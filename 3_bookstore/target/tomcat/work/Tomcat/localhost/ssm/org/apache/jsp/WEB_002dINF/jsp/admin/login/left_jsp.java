/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-05 06:08:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>js左侧边导航菜鼠标悬停展开二级菜单导航</title>\r\n");
      out.write("<meta name=\"description\" content=\"用js制作一个js导航菜单，左侧纵向二级导航菜单，鼠标滑过当前选区高亮显示二级菜单内容，带点击展开和收缩按钮控制。内含js代码下载。\" />\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("*{margin:0;padding:0;list-style-type:none;}\r\n");
      out.write("body{font-family:\\5B8B\\4F53,Arial Narrow,arial,serif;background:#FFFFFF;color:#000;font-size:12px;line-height:20px;text-align:left;}\r\n");
      out.write("a{color:#03c;text-decoration:none;}\r\n");
      out.write("a:hover{color:#f60;text-decoration:none;}\r\n");
      out.write("\r\n");
      out.write("/* tjskl-sidebar */\r\n");
      out.write(".tjskl-sidebar{width:183px;margin:10px auto;}\r\n");
      out.write(".tjskl-sidebar #submain_hidden{border-top:0;display:none;}\r\n");
      out.write(".tjskl-sidebar .bsb{border-bottom:1px solid #c8d2e5;border-top:0;}\r\n");
      out.write("/* tj_submain */\r\n");
      out.write(".tj_submain{border:1px solid #c8d2e5;border-bottom:0;width:181px;font-weight:normal;}\r\n");
      out.write(".tj_submain .title{background:url(\"\") repeat-x 0 -38px;height:24px;line-height:24px;font-size:12px;font-weight:bold;width:161px;padding-left:20px;}\r\n");
      out.write(".tj_submain li{width:181px;height:30px;border-bottom:1px solid #E7F3FF;position:relative;}\r\n");
      out.write(".tj_submain li a{width:141px;display:inline-block;padding:0 20px;height:30px;line-height:30px;}\r\n");
      out.write(".tj_submain li a.on{background:url(\"\") no-repeat scroll 0 -9px;border-top:1px solid #FFC83D;width:161px;height:29px;line-height:29px;padding:0px 0px 0px 20px;position:relative;z-index:90;}\r\n");
      out.write(".tj_submain span{position:absolute;top:0;left:180px;z-index:1;background-color:#FFFAE2;border:#FFC83D solid 1px;display:none;}\r\n");
      out.write(".tj_submain span a{display:block;height:26px;line-height:26px;}\r\n");
      out.write(".tj_submain span a:hover{background:#FFFAE2;background:#ebf0f5;text-decoration:none;}\r\n");
      out.write(".tj_submain ul li{float:left;margin-right:10px;display:inline;}\r\n");
      out.write(".tj_submain ul li span a{text-decoration:none;}\r\n");
      out.write(".tj_submain ul li span a:hover{color:#f60;}\r\n");
      out.write(".tj_submain #more_submenu a{background:url(\"\") no-repeat;text-align:right;display:block;width:125px;padding-right:19px;cursor:pointer;}\r\n");
      out.write(".tj_submain #more_submenu a.show{background-position:100% 2px;}\r\n");
      out.write(".tj_submain #more_submenu a.less{background-position:100% -25px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function do_list_row_show(strid){\r\n");
      out.write("\tstrid.getElementsByTagName('a')[0].className='on';\r\n");
      out.write("\tstrid.getElementsByTagName('span')[0].style.display=\"block\";\r\n");
      out.write("\tstrid.style.position=\"relative\";\r\n");
      out.write("}\r\n");
      out.write("function do_list_row_unshow(strid){\r\n");
      out.write("\tstrid.getElementsByTagName('a')[0].className='';\r\n");
      out.write("\tstrid.getElementsByTagName('span')[0].style.display=\"\";\r\n");
      out.write("\tstrid.style.position=\"\";\r\n");
      out.write("}\r\n");
      out.write("submenu = function(box,div){\r\n");
      out.write("\tvar div_classname = document.getElementById(div).getElementsByTagName('a')[0];\r\n");
      out.write("\tif(div_classname.className=='show'){\r\n");
      out.write("\t\twith(document.getElementById(box).style){\r\n");
      out.write("\t\t\theight='auto';display='block';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdiv_classname.className='less';div_classname.innerHTML='收缩';\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\twith(document.getElementById(box).style){\r\n");
      out.write("\t\t\theight='0';display='none';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdiv_classname.className='show';div_classname.innerHTML='展开';\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"tjskl-sidebar\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<ul class=\"tj_submain\">\r\n");
      out.write("\t\t\t<li class=\"title\"><a href=\"javascript:void(0)\">后台管理系统</a></li>\r\n");
      out.write("\t\t\t<li onMouseOut=\"do_list_row_unshow(this);\" onMouseOver=\"do_list_row_show(this);\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">商品管理</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li onMouseOut=\"do_list_row_unshow(this);\" onMouseOver=\"do_list_row_show(this);\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/showAllProducts\" target=\"mainFrame\">商品查看</a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li onMouseOut=\"do_list_row_unshow(this);\" onMouseOver=\"do_list_row_show(this);\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/showAllOrders\" target=\"mainFrame\">订单管理</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div><!--tjskl-sidebar end-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
