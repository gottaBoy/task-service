<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.GridFormEditPage" language="java"%>
<% GridFormEditPage page1=(GridFormEditPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.GridFormEditPage");%>
<% page1.setSimpleMode(true);page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>
