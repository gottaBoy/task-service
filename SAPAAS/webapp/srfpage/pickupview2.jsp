<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.PickupPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
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
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr height='32'>
					<td width="5"></td>
						<td width="30">
							<IMG src="<%=page1.OutputPageIcon(false)%>">
						</td>
					<td>
						<SPAN style='white-space: nowrap;' class='sx-normaltext16-b'><B><%=page1.OutputPageCaption()%></B></SPAN>&nbsp;&nbsp;&nbsp;&nbsp;
						<SPAN id='BAR_DATA' class='sx-normaltext10-b' style='color:blue;white-space: nowrap;'></SPAN>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<%= page1.Render("SPEx")%>
		</td>
	</tr>
	<tr>
		<td height='5'>
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
					<tr height='38' style='padding:2px;' >
						<td>
						 <%= page1.Render("NewButton")%>	
						</td>
					<td  width="80">
						<%= page1.Render("ResetButton")%>	
					</td>
					<td  width="80">
						<%= page1.Render("OKButton")%>	
					</td>
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
		var nGridHeight = nHeight - 4 - 5 -38 -32;
		
		$P.sp['<%=page1.GetCtrlUniqueId("SPEx")%>'].setWidth(nInnerWidth);
		$P.grid['<%=page1.GetCtrlUniqueId("DataGrid")%>'].setWidth(nInnerWidth);
		
		var nSPHeight = Ext.getDom('<%=page1.GetCtrlUniqueId("SPEx")%>').clientHeight;
		nGridHeight -= nSPHeight;
		$P.grid['<%=page1.GetCtrlUniqueId("DataGrid")%>'].setHeight(nGridHeight);
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
</script>
</body>
</HTML>
