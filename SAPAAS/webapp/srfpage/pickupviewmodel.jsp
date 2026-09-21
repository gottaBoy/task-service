<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.NavFramePickupPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.OutputPageModel()%>