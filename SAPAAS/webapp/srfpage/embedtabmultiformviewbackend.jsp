<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedTabMultiFormPage" language="java"%>
<% EmbedTabMultiFormPage page1=(EmbedTabMultiFormPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedTabMultiFormPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

