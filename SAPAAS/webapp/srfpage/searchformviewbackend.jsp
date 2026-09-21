<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.SearchFormViewPage" language="java"%>
<% SearchFormViewPage page1=(SearchFormViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.SearchFormViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>