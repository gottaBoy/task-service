<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreePage" language="java"%>
<% TreePage page1=(TreePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreePage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>