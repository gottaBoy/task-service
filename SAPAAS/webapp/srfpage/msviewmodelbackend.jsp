<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFrameMSPage" language="java"%>
<% NavFrameMSPage page1=(NavFrameMSPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFrameMSPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>