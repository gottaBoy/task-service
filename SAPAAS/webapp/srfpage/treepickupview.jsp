<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreePickupPage" language="java"%>
<% TreePickupPage page1=(TreePickupPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreePickupPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.PICKUPVIEW","Ñ¡ÔñÊÓÍ¼")%> - <%=page1.OutputPageCaption()%></title> 
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden;padding:2px;' >
<table width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr>
		<td>
			<%= page1.Render("TreePanel")%>
		</td>
	</tr>	
	<tr  >
		<td align="right" height='25' class="x-toolbar">
			<table   border='0'  width="360" cellspacing='0' cellpadding='0'>
				<tr  style='padding:2px;' valign=middle>
					 
					<td width="120" height='20' >
						<%= page1.Render("CancelButton")%>	
					</td>
					<td  width="120">
						<%= page1.Render("ResetButton")%>	
					</td>
					<td  width="120">
						<%= page1.Render("OKButton")%>	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		var nInnerWidth = nWidth - 4;
		var nInnerHeight = nHeight - 4   -25  ;
		//nInnerHeight=200;
		$P.tree['<%=page1.GetCtrlUniqueId("treePanel")%>'].setWidth(nInnerWidth);
		$P.tree['<%=page1.GetCtrlUniqueId("treePanel")%>'].setHeight(nInnerHeight);
		<%=page1.GetCtrlUniqueId("treePanel")%>.style.height=nInnerHeight;
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
</script>
</body>
</HTML>
