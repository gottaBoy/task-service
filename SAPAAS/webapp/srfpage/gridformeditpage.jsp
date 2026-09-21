<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.GridFormEditPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>±‡º≠ ”Õº-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;'>
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.Render("dataGrid")%>
		</td>
		
	</tr>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
	<tr>
		<td style='padding-left:4px;padding-right:4px;'>
			<%=page1.RenderErrorPanel()%>
		</td>
	</tr>
	<tr></tr>
</table>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		var _dgid = '<%=page1.GetCtrlUniqueId("dataGrid")%>';
		var _dg = $P.grid[_dgid];
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_dg){
			_dg.setWidth(nWidth-8);
		};
		if(_TAB!=null && _TAB!=undefined){
			_TAB.setWidth(nWidth-8);
			var nGridHeight = nHeight - _TAB.getHeight(); 
			nGridHeight = nGridHeight<=150?150:nGridHeight-40;
			var _dgDiv = Ext.get(_dgid);
			if(_dgDiv){
				_dgDiv.setHeight(nGridHeight);
			}
			_dg.setHeight(nGridHeight);
		}
	}   

    Ext.onReady(function(){ 
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
 	function submit(){
		var _F = $P.mainform;
		if(_F){
			_F.saveandnew = true;
			_F.save();
		}
 	}
 	function reset(){
 		var _F = $P.mainform;
 		if(_F){
 			$P.mainform.newdata();
 	 	}
 	}
</script>
</body>
</HTML>
