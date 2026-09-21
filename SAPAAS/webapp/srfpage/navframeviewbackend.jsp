<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePage" language="java"%>
<% NavFramePage page1=(NavFramePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>