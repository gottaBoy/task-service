<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.CommonSelectPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td id='maintoolbar' height='25'><%=page1.Render("Toolbar")%></td>
		</tr>
		<tr>
			<td style='padding:20px;'>
				<table  width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td  id='TD_TOTALDG'>
							<span class='sx-normaltext'><%=page1.GetTotalDGTitle() %></span>
						</td>
						<td width='160'>&nbsp;</td>
						<td ><span class='sx-normaltext'><%=page1.GetSelectDGTitle() %></span></td>
					</tr>
					<tr>
						<td >
							<%=page1.Render("totalDataGrid")%>
						</td>
						<td valign='middle' >
							<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
								<tr>
									<td style='padding:4px;'>
										<%=page1.Render("selectAllButton")%>
									</td>
								</tr>
								<tr>
									<td style='padding:4px;'>
										<%=page1.Render("selectButton")%>
									</td>
								</tr>
								<tr>
									<td style='padding:4px;'>
										<%=page1.Render("cancelButton")%>
									</td>
								</tr>
								<tr>
									<td style='padding:4px;'>
										<%=page1.Render("cancelAllButton")%>
									</td>
								</tr>
							</table>
						</td>
						<td >
							<%=page1.Render("selectDataGrid")%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
</table>
<%=page1.Render()%>
<script type="text/javascript">
	var varKEYNAME = '<%=page1.GetKeyName()%>';
	function totalstoreloaded(_1,_2,_3)
    {
  	    var selectStore = $P.store['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
    	selectStore.removeAll();
    	var items = dialogArguments.items;
     	var rm = new Array();
   		for(var i = 0;i<_1.getCount();i++)
   		{
   			var keyid = _1.getAt(i).get(varKEYNAME);
   			keyid = keyid.toUpperCase();
   			if(items.containsKey(keyid))
   				rm.push(_1.getAt(i));
    	}
     	items.clear();
   		for(var i = 0;i<rm.length;i++)
   		{
   			_1.remove(rm[i]);
   			selectStore.insert(selectStore.getCount(),rm[i]);
   			items.insert(items.getCount(),rm[i].get(varKEYNAME).toUpperCase());
   		}
    }
    
    function addselect()
    {
    	var totalGrid = $P.grid['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'];
    	var selectStore = $P.store['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
    	var totalStore = $P.store['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'];
    	var sm = totalGrid.getSelectionModel().getSelections();
    	if(sm == null)
    		return ;
    	var items = dialogArguments.items;
    	for(var i = 0;i<sm.length;i++)
   		{
   			totalStore.remove(sm[i]);
   			selectStore.insert(selectStore.getCount(),sm[i]);
   			items.insert(items.getCount(),sm[i].get(varKEYNAME).toUpperCase());
   		}
    }
    
    function removeselect()
    {
    	var selectGrid = $P.grid['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
     	var sm = selectGrid.getSelectionModel().getSelections();
    	if(sm == null)
    		return ;
    	var items = dialogArguments.items;
    	for(var i = 0;i<sm.length;i++)
   		{
     		items.remove(sm[i].get(varKEYNAME).toUpperCase());
   		}
   		$P.store['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'].reload();
    }
    
    function addall()
    {
    	var totalStore = $P.store['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'];
     	var items = dialogArguments.items;
      	for(var i = 0;i<totalStore.getCount();i++)
   		{
   			items.insert(items.getCount(),totalStore.getAt(i).get(varKEYNAME).toUpperCase());
   		}
   		totalStore.reload();
    }
    
    function removeall()
    {
    	var items = dialogArguments.items;
    	items.clear();
    	$P.store['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'].reload();
     }
    
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		
		var nDGWidth = (nWidth - 160)/2;
		if(nDGWidth<0)
			nDGWidth = 0;
		var nDGHeight = nHeight - 100;
		if(nDGHeight<0)
			nDGHeight = 0;
		$P.grid['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'].setSize(nDGWidth,nDGHeight);
		$P.grid['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'].setSize(nDGWidth,nDGHeight);
	}

    Ext.onReady(function(){
     	 $P.store['<%=page1.GetCtrlUniqueId("totalDataGrid")%>'].on('load',totalstoreloaded);
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
</script>
</body>
</HTML>
