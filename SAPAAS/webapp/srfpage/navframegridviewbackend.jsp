<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFrameGridPage" language="java"%>
<% NavFrameGridPage page1=(NavFrameGridPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFrameGridPage");%>
<%page1.InitBackEnd(pageContext);page1.LoadBackEnd();%>