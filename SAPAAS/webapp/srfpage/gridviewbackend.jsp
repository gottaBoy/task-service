<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.GridViewPage" language="java"%>
<% GridViewPage page1=(GridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.GridViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

