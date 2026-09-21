<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MapViewPage" language="java"%>
<% MapViewPage page1=(MapViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MapViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>