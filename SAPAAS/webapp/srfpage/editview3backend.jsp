<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage3" language="java"%>
<% EditViewPage3 page1=(EditViewPage3)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage3");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>