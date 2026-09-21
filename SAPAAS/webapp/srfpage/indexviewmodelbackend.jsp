<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.IndexPage" language="java"%>
<% IndexPage page1=(IndexPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.IndexPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

