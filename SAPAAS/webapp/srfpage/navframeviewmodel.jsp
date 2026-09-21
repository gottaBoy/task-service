<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePage" language="java"%>
<% NavFramePage page1=(NavFramePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>