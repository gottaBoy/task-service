<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MenuTreeGridViewPage" language="java"%>
<% MenuTreeGridViewPage page1=(MenuTreeGridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MenuTreeGridViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

