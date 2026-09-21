<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreePickupPage" language="java"%>
<% TreePickupPage page1=(TreePickupPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreePickupPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>