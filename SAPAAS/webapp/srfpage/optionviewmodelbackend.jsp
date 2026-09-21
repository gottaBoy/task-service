<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.OptionViewPage" language="java"%>
<%
	OptionViewPage page1=(OptionViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.OptionViewPage");
%>
<% page1.setSimpleMode(true);page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>
