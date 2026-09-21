<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.DGCustomViewPage" language="java"%>
<% DGCustomViewPage page1=(DGCustomViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.DGCustomViewPage");%>
<% page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>
