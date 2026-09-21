<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.EmbedEditViewPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>±‡º≠ ”Õº-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<DIV class='x-panel-body-noheader x-panel-body' style='overflow:hidden' >
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td><%=page1.Render("Toolbar")%></td>
		</tr>
		<tr align='center' >
			<td style='padding:2px;'>
				<div id='BAR_INFO' class="sx-infopanel sx-normaltext" style="display:none;height:20px;padding:4px;"></div>
			</td>
		</tr>
</table>
<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
	<tr>
		<td style='padding:4px'>
			<%=page1.RenderErrorPanel()%>
		</td>
	</tr>
</table>
</DIV>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);

		nHeight -=35;
		if(nHeight<0)
			nHeight=0;	
		Ext.getDom('center').style.height = nHeight ;
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB)
		{
			nWidth-=30;
			if(nWidth<0)
				nWidth = 0;
			_TAB.setWidth(nWidth);
		}
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
	});
 	
 	function setsummarykey(_1)
 	{
  		<%=page1.GetLoadFormCode()%>
 	}
 	function setsummarykey2(_1)
 	{
 		Ext.onReady(function(){
 		<%=page1.GetLoadFormCode()%>
  		});
 	}
</script>
</body>
</HTML>
