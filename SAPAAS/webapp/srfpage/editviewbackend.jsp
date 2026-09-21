<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage" language="java"%>
<% EditViewPage page1=(EditViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>