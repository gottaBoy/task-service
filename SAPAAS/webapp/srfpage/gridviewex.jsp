<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.GridViewExPage" language="java"%>
<% GridViewExPage page1=(GridViewExPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.GridViewExPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.gridviewex.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<DIV id='north'  <%if(page1.IsIfView()) {%> class='x-panel-body-noheader x-panel-body' style='border-bottom:0 none;' <%}%>>
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
						<td width='2'></td>
					<%}%>
					<td width="50" align="right">
						<!-- 行操作对象 -->
						<div style='padding:2px'>
							<%=page1.Render("dgExRowCountList")%>
						</div>
					</td>
					<!-- 输出CommandBar -->
					<td ><%=page1.Render("Toolbar")%></td>
					
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
<%=page1.Render("dgEx")%>
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
   		var dgEx = $P.gridex['<%=page1.GetCtrlUniqueId("DGEX")%>'];
   		dgEx.region = 'center';
		
	    viewport = new Ext.Viewport({
            layout:'border',
            items:[
            	 pageHeader
            	,dgEx
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
	
</script>
</body>
</HTML>