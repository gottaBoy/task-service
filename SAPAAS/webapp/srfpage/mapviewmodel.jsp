<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MapViewPage" language="java"%>
<% MapViewPage page1=(MapViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MapViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>