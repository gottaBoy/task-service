<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.GridViewExPage" language="java"%>
<% GridViewExPage page1=(GridViewExPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.GridViewExPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>