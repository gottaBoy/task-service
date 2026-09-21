<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedGridViewPage" language="java"%>
<% EmbedGridViewPage page1=(EmbedGridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedGridViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>

