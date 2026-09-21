<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreePage" language="java"%>
<% TreePage page1=(TreePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreePage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

