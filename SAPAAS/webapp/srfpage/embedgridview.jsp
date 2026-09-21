<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedGridViewPage" language="java"%>
<% EmbedGridViewPage page1=(EmbedGridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedGridViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.gridview.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<DIV id='north'  class='x-panel-body-noheader x-panel-body' style='border-bottom:0 none;' >
<table id='tb_north' width='100%'  border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td class='sx-bar' height='26' >
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<%if(page1.IsRenderRowActionList()){%>
					<td width="50" align="right">
						<!-- 行操作对象 -->
						<div style='padding:2px'>
							<%=page1.Render("dataGridRowActionList")%>
						</div>
					</td>
					<%} %>
					<td width='2'></td>
					<!-- 输出CommandBar -->
					<td ><%=page1.Render("Toolbar")%></td>
				</tr>	
			</table>
		</td>
	</tr>
</table>
</DIV>
<%=page1.Render("DataGrid")%>

<%=page1.Render()%>
<script type="text/javascript">
	var pageHeader = null;
	var viewport = null;
	var sptab = null;
	var TB_HEIGHT = 27;
	
	function RelayoutCtrls()
	{
		var _1 = Ext.getDom('tb_north').clientHeight;
		if(_1<=0)
			_1 = 26;
		pageHeader.setHeight(_1);
		viewport.syncSize();
	}
	function onWindowResize(_1,_2)
	{
	}
	
	function reloadgrid(_1)
	{
		if($P.maingrid == null)return;
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
        if(!($P.mainview))
        {if(confirm('页面加载出现问题，点击确定重新加载，点击取消关闭窗口')){window.location.reload();}else{window.close();}return;}
    	pageHeader = $P.mainview.getpageheader();
   		var dataGrid = $P.grid['<%=page1.GetCtrlUniqueId("DATAGRID")%>'];
		dataGrid.region = 'center';
		
	    viewport = new Ext.Viewport({
            layout:'border',
            items:[
            	pageHeader
             	,dataGrid
             ]});
	   
       	Ext.EventManager.onWindowResize(onWindowResize);
      	RelayoutCtrls();
    });

    //外部传入的表单状态
    function setstates(_1)
    {
        //alert(Ext.urlEncode(_1));
    }
        
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
</script>
</body>
</HTML>