<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePickupPage" language="java"%>
<% NavFramePickupPage page1=(NavFramePickupPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePickupPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>