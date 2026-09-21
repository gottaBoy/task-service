<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage2" language="java"%>
<% EditViewPage2 page1=(EditViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage2");%>
<%page1.setSimpleMode(true);page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>