<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreeExplorerPage" language="java"%>
<% TreeExplorerPage page1=(TreeExplorerPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreeExplorerPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

