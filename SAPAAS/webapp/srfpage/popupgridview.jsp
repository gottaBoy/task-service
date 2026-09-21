<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.PopupGridViewPage" language="java"%>
<% PopupGridViewPage page1=(PopupGridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.PopupGridViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden;padding:2px;' >
<table width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr>
		<td class='sx-bar' height='26' >
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td width='2'></td>
					<td width='20'>
						<IMG src="<%=page1.OutputPageIcon(true)%>" >
					</td>
					<td width='100' style='padding-top:2px;'>
						<span style='white-space: nowrap;' class='sx-bartext' ><%=page1.OutputPageCaption()%></span>
					</td>
					<!-- Êä³öCommandBar -->
					<td ><%=page1.Render("Toolbar")%></td>
					<td width='2'></td>
					<td width='50'>
						<%=page1.Render("dataGridRowActionList")%>
					</td>
				</tr>	
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<%= page1.Render("DataGrid")%>
		</td>
	</tr>	
	<tr>
		<td>
			<table   border='0' width='100%' cellspacing='0' cellpadding='0'   >
					<tr height='30' style='padding:2px;' >
					<td>&nbsp;</td>
					<td width="80">
						<%= page1.Render("CancelButton")%>	
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
		var nGridHeight = nHeight - 60;

		$P.grid['<%=page1.GetCtrlUniqueId("DataGrid")%>'].setWidth(nInnerWidth);
		$P.grid['<%=page1.GetCtrlUniqueId("DataGrid")%>'].setHeight(nGridHeight);
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
</script>
</body>
</HTML>
