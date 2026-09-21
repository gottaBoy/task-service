<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.DataFilterViewPage" language="java"%>
<% DataFilterViewPage page1=(DataFilterViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.DataFilterViewPage");%>
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<div id='north'>

</div>
</body>
</HTML>
