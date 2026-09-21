<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.DataFilterViewPage" language="java"%>
<% DataFilterViewPage page1=(DataFilterViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.DataFilterViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>