<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.UploadFileSavePage" language="java"%>
<% UploadFileSavePage page1=(UploadFileSavePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.UploadFileSavePage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>