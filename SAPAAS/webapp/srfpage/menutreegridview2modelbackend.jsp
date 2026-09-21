<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MenuTreeGridViewPage2" language="java"%>
<% MenuTreeGridViewPage2 page1=(MenuTreeGridViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MenuTreeGridViewPage2");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

