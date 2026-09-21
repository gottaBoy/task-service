<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.DataFilterViewPage" language="java"%>
<% DataFilterViewPage page1=(DataFilterViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.DataFilterViewPage");%>
<% page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>
