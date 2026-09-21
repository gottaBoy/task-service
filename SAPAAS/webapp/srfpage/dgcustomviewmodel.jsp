<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.DGCustomViewPage" language="java"%>
<% DGCustomViewPage page1=(DGCustomViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.DGCustomViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>