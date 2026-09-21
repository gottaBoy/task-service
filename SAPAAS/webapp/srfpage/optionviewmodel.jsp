<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.OptionViewPage" language="java"%>
<%
	OptionViewPage page1=(OptionViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.OptionViewPage");
%>
<% page1.setSimpleMode(true);page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>