/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-05 06:10:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Language\" content=\"zh-cn\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("BODY {\r\n");
      out.write("\tMARGIN: 0px;\r\n");
      out.write("\tBACKGROUND-COLOR: #ffffff\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("BODY {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("TD {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("TH {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/Style.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction exitSys() {\r\n");
      out.write("\t\tvar flag = window.confirm(\"确认退出系统吗?\");\r\n");
      out.write("\t\tif (flag) {\r\n");
      out.write("\t\t\twindow.top.open('', '_parent', '');\r\n");
      out.write("\t\t\twindow.top.close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//如果你使用的是firefox浏览器必须要做以下设置 \r\n");
      out.write("\t\t//1、在地址栏输入about:config然后回车，警告确认 \r\n");
      out.write("\t\t//2、在过滤器中输入”dom.allow_scripts_to_close_windows“，双击即可将此值设为true 即可完成了 \r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table width=\"100%\" height=\"70%\" border=\"0\" cellspacing=\"0\"\r\n");
      out.write("\t\tcellpadding=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td width=\"100%\"\r\n");
      out.write("\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/top_11.png\">\r\n");
      out.write("\t\t\t\t<img alt=\"图片失联\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/top_11.png\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"30\" valign=\"bottom\"\r\n");
      out.write("\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_01.jpg\">\r\n");
      out.write("\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"85%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color=\"#000000\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<script language=\"JavaScript\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttmpDate = new Date();\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdate = tmpDate.getDate();\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmonth = tmpDate.getMonth() + 1;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tyear = tmpDate.getFullYear();\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(year);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(\"年\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(month);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(\"月\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(date);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.write(\"日 \");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray = new Array(6);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[0] = \"星期日\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[1] = \"星期一\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[2] = \"星期二\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[3] = \"星期三\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[4] = \"星期四\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[5] = \"星期五\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmyArray[6] = \"星期六\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tweekday = tmpDate.getDay();\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (weekday == 0 | weekday == 6) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(myArray[weekday])\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(myArray[weekday])\r\n");
      out.write("\t\t\t\t\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t\t\t\t\t// -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</script> </font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"16\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_05a.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twidth=\"6\" height=\"18\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"155\" valign=\"bottom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a href=\"javascript:void(0)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"exitSys()\">退出系统</a> </font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"10\" align=\"right\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/admin/mis_05c.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twidth=\"6\" height=\"18\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\" width=\"5%\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</HTML>\r\n");
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