<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedEditViewPage2" language="java"%>
<% EmbedEditViewPage2 page1=(EmbedEditViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedEditViewPage2");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>