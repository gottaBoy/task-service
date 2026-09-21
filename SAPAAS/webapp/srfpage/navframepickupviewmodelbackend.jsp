<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePickupPage" language="java"%>
<% NavFramePickupPage page1=(NavFramePickupPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePickupPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>