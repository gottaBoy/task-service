<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.SPPreviewPage" />
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.RenderPanel()%>	
<%=page1.Render() %>