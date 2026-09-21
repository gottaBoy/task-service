<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedEditViewPage2" language="java"%>
<% EmbedEditViewPage2 page1=(EmbedEditViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedEditViewPage2");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>