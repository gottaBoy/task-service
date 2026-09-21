<%@page contentType="text/html; charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.gridview.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<DIV id='north'  <%if(page1.IsIfGridView()) {%> class='x-panel-body-noheader x-panel-body' style='border-bottom:0 none;' <%}%>>
<table id='tb_north' width='100%'  border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td class='sx-bar' height='26' >
			<table width='100%' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<%if(page1.IsRenderCaption()) {%>
						<td width='2'></td>
						<td width='20'>
							<IMG src="<%=page1.OutputPageIcon(true)%>" >
						</td>
						<td width='<%=page1.GetCaptionWidth()%>' style='padding-top:2px;'>
							<span style='white-space: nowrap;' class='sx-bartext' ><%=page1.OutputPageCaption()%></span>
						</td>
					<%}%>
					<%if(page1.IsRenderDataGridTheme()) {%>
					<td width='2'></td>
					<td width='120'>
						<%=page1.RenderDataGridTheme()%>
					</td>
					<td width='2'></td>
					<%}%>
					<%if(page1.IsRenderRowCountList()){%>
					<td width="50" align="right">
						<!-- 行操作对象 -->
						<div style='padding:2px'>
							<%=page1.Render("dataGridRowCountList")%>
						</div>
					</td>
					<%}%>
					<%if(page1.IsRenderRowActionList()){%>
					<td width='50'>
						<%=page1.Render("dataGridRowActionList")%>
					</td>
					<%}%>
					<td width='2'></td>
					<!-- 输出CommandBar -->
					<td ><%=page1.Render("Toolbar")%></td>
					<%if(page1.IsRenderCustomSummaryArea()){%>
						<td width="60" align="right">
						<!-- 缩略区域 -->
						<div style='padding:2px'>
							<%=page1.Render("ddlSummaryArea")%>
						</div>
					</td>
					<%}%>
				</tr>	
			</table>
		</td>
	</tr>
</table>
<%if(page1.IsRenderSP()){ %>
<table id='TR_SPEX' style='display:none' width='100%'  border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:2px;background-color:#ffffff;' >
			<%=page1.Render("spEx")%>
		</td>
	</tr>
</table>
<%} %>
</DIV>
<%=page1.Render("DataGrid")%>
<%if(page1.IsRightSummary()){%>
<table id='tb_right' width='100%'  border='0' cellspacing='0' cellpadding='0'>
<%if(page1.IsRenderSummaryPageList()){ %>
<tr class='sx-bar' height='24'><td style='padding-top:2px'>&nbsp;<img src='../sasrfex/images/default/icon_relation.gif' align='absmiddle'><span class='sx-normaltext' >&nbsp;<%=page1.GetLocalization("PAGE.COMMON.GRIDVIEW.SUMMARY.NAME","数据关系区域")%></span><%=page1.Render("ddlSummaryPage")%></td></tr>
<%} %>
<tr><td valign='top'>	
<iframe id="if_summary" name="if_summary" src="" width="100%" height="100%" SCROLLING="auto" frameBorder="0" style="border-style:none;" ></iframe>
</td></tr></table> 
<%}%>
<%if(page1.IsBottomSummary()){%>
<table id='tb_bottom' width='100%'  border='0' cellspacing='0' cellpadding='0'>
<%if(page1.IsRenderSummaryPageList()){ %>
<tr class='sx-bar' height='24'><td style='padding-top:2px'>&nbsp;<img src='../sasrfex/images/default/icon_relation.gif' align='absmiddle'><span class='sx-normaltext' >&nbsp;<%=page1.GetLocalization("PAGE.COMMON.GRIDVIEW.SUMMARY.NAME","数据关系区域")%></span><%=page1.Render("ddlSummaryPage")%></td></tr>
<%} %>
<tr><td valign='top'>	
<iframe id="if_summary" name="if_summary" src="" width="100%" height="100%" SCROLLING="auto" frameBorder="0" style="border-style:none;" ></iframe>
</td></tr></table>  
<%}%>
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
		<%if(page1.IsRenderSP()){ %>
		 $P.sp['<%=page1.GetCtrlUniqueId("spEx")%>'].setWidth(Ext.lib.Dom.getViewWidth(false)-4);
		 <%} %>
	}
	<%if(page1.IsRenderSP()){ %>
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
	<%} %>
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
            	<%if(page1.IsBottomSummary()){%>
            	,new Ext.BoxComponent({
            		id:'summary',
                    region:'south',
                    el: 'tb_bottom',
                    split:true,
                    height:  <%=page1.GetSummaryHeight()%> ,
                    minSize: 50,
                    maxSize: 1000,
                    border:true,
                    frame:true
                   })
            	<%}%>
            	<%if(page1.IsRightSummary()){%>
            	,new Ext.BoxComponent({
            		id:'summary',
                    region:'east',
                    el: 'tb_right',
                    width: <%=page1.GetSummaryWidth()%> ,
                    minSize: 50,
                    maxSize: 1000,
                    split:true,
                    border:true,
                    frame:true
                   })
            	<%}%>
            	,dataGrid
             ]});
	    <%if(page1.IsRenderSP()){ %>
        $P.sp['<%=page1.GetCtrlUniqueId("spEx")%>'].setWidth(Ext.lib.Dom.getViewWidth(false));
        sptab=$P.tabpanel['<%=page1.GetSPExDPUniqueId()%>'];
        if(sptab!=null)
        {
        	sptab.on('tabchange', sptabchanged);
        }
        <%}%>
       	Ext.EventManager.onWindowResize(onWindowResize);
       <%if(page1.IsRightSummary() || page1.IsBottomSummary()){%>
       if(true){
        var varSummary = viewport.items.get('summary');
        var nHeight = varSummary.getSize().height;
        <%if(page1.IsRenderSummaryPageList()){ %>
        nHeight -=24;
        <%}%>
        if(nHeight<0)
        	nHeight = 0;
        Ext.getDom('if_summary').style.height=nHeight;
         if(Ext.isIE)
        {
      	 	Ext.get('if_summary').on('readystatechange',function(){summaryload();});
        }
        else
        {
        	Ext.get('if_summary').on('load',function(){summaryload();});
        }
       	varSummary.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
       		var nHeight = adjHeight;
       		<%if(page1.IsRenderSummaryPageList()){ %>
      		  nHeight -=24;
      		  <%}%>
       		if(nHeight<0)
       			nHeight = 0;
       		Ext.getDom('if_summary').style.height=nHeight;
        });}
       $P.iframe['if_summary']='if_summary';
        <%}%>
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
		var _W=ifr.contentWindow;
		if(_W==null)return;
		if($P.summarykey == undefined || $P.summarykey==null)
		{
			if(_W.$P){ifr.style.display='';_W.$P.maskinfo='<%=page1.GetLocalization("PAGE.COMMON.GRIDVIEW.SUMMARY.UNSELECTINFO","请选中表格数据")%>';}
			return;
		}
		if(_W.setsummarykey2){if(_W.$P.maskhelper){_W.$P.maskhelper.unmask();}ifr.style.display='';_W.setsummarykey2($P.summarykey);}
	}
	<%}%>
</script>
</body>
</HTML>