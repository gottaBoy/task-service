<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.FormViewPage" language="java"%>
<% FormViewPage page1=(FormViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.FormViewPage");%>
<%	page1.Init(pageContext);page1.Load();if(page1.IsStop()) return; %>
<DIV ID="DIV_<%=page1.getID()%>" style="width:100px;height:200px;overflow:auto;owverflow-y: hidden;">
<table  width='100%' border='0' cellspacing='0' cellpadding='0' >
	<tr >
		<td >
			<%=page1.RenderPanel()%>
		</td>
	</tr>
</table>
<DIV style="padding-right:13px;padding-top:4px;">
<%=page1.RenderErrorPanel()%>
</DIV>
</DIV>
<%=page1.Render() %>
