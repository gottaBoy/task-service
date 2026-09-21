<%@page contentType="text/html; charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title></title>
<%@include file="/include/commonlib.gridview.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<DIV id='north'  <%if(page1.IsIfGridView()) {%> class='x-panel-body-noheader x-panel-body' style='border-bottom:0 none;' <%}%>>


</DIV>
<%=page1.Render("DataGrid")%>
<table id='tb_right' width='1'  height="0" border='0' cellspacing='0' cellpadding='0'>
<tr><td></td></tr></table> 

<%=page1.Render()%>
<script type="text/javascript">
	var pageHeader = null;
	var viewport = null;
	var sptab = null;
	var TB_HEIGHT = 207;
	function resize()
	{
		if(Ext.getDom('SEARCHPANEL').style.display == 'none')
			Ext.getDom('SEARCHPANEL').style.display='';
		else
			Ext.getDom('SEARCHPANEL').style.display='none';
		RelayoutCtrls();
		return;
		viewport.syncSize();
	}
	
	function RelayoutCtrls()
	{
		
		viewport.syncSize();
	}
	

	function showhidesp()
	{
		var _C=Ext.getDom('TR_SPEX');
		if(_C.style.display == '')
		{
			_C.style.display='none';
			pageHeader.setHeight(TB_HEIGHT);
			viewport.syncSize();
			return false;
		}
		else
		{
			_C.style.display='';
			pageHeader.setHeight(_C.clientHeight + 3 + TB_HEIGHT);
			viewport.syncSize();
			return true;
		}
	}

	function sptabchanged()
	{
		pageHeader.setHeight(sptab.getSize().height + 5 + TB_HEIGHT);
		viewport.syncSize();
	}
	
	function reloadgrid(_1)
	{
		if($P.maingrid == null)
		{
			return;
		}
		
		$P.maingrid.getStore().sysparams={};
		
		if($P.maingrid._groupkey )
		{
			if($P.maingrid.getStore().lastOptions)
			{
				for (proName in $P.maingrid._groupkey)
				{
					$P.maingrid.getStore().lastOptions.params[proName]='';
				}
          	}
         }
		$P.maingrid._groupkey={};
		Ext.apply($P.maingrid._groupkey,_1);	
		Ext.apply($P.maingrid.getStore().sysparams,_1);
		if($P.maingrid.getStore().lastOptions)
		{
			$P.maingrid.getStore().reload();
		}
		else
		{
			$P.maingrid.getStore().loaddefault();
		}
	}

	function reloadgrid2(_1)
	{
		if($P.maingrid == null)
			return;
		Ext.apply($P.maingrid.getStore().sysparams,_1);
		$P.maingrid.getStore().reload();
	}
	
	
    Ext.onReady(function(){
    	pageHeader = $P.mainview.getpageheader();
   		var dataGrid =  $P.grid['<%=page1.GetCtrlUniqueId("DATAGRID")%>'];
		dataGrid.region = 'center';
		
	    viewport = new Ext.Viewport({
            layout:'border',
            items:[
            	pageHeader
            	,dataGrid
             ]});
        
        
      
      	RelayoutCtrls();
        <%=page1.GetAfterOnReadyCode()%>	
     });
        
      
    function setsummarykey(_1)
 	{
  		if($P.maingrid)
 		{
 			<%=page1.GetLoadGridCode()%>
 		}
 	}
 	function setsummarykey2(_1)
 	{
  		Ext.onReady(function(){
  		if($P.maingrid)
 		{
  			var _1=this;
 			<%=page1.GetLoadGridCode()%>
  		}
 		else
 		{
 		    window.setTimeout("setsummarykey(Ext.urlDecode('"+Ext.urlEncode(this)+"'))",500);
  		}
  		},_1);
 	}

	<%if(page1.IsRightSummary() || page1.IsBottomSummary()){%>
	function summaryload()
	{
		var ifr=Ext.getDom('if_summary');
		if(ifr==null)return;
		if($P.summarykey == undefined || $P.summarykey==null)
		{
			if(ifr.contentWindow&&ifr.contentWindow.$P&&ifr.contentWindow.$P){ifr.style.display='';ifr.contentWindow.$P.maskinfo='请选中表格数据';}
			return;
		}
		if(ifr.contentWindow&&ifr.contentWindow.setsummarykey2){if(ifr.contentWindow.$P.maskhelper){ifr.contentWindow.$P.maskhelper.unmask();}ifr.style.display='';ifr.contentWindow.setsummarykey2($P.summarykey);}
	}
	<%}%>
</script>
</body>
</HTML>