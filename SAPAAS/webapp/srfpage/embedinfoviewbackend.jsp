<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedInfoViewPage" language="java"%>
<% EmbedInfoViewPage page1=(EmbedInfoViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedInfoViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>