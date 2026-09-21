<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.FormViewPage" language="java"%>
<% FormViewPage page1=(FormViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.FormViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>