<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.TreeExplorerPage" language="java"%>
<% TreeExplorerPage page1=(TreeExplorerPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.TreeExplorerPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.index.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<div id='west'> 
<table width='100%' border='0' cellspacing='0' cellpadding='0'>
<%if(page1.IsEnableRootSelect()){ %>
<tr height='28'>
	<td class='sx-bar' style='padding:2px'><%=page1.Render("ddlTreeDimension")%></td>
</tr>
<%} %>
<tr ><td>
<%=page1.Render("TreePanel")%>
</td></tr>
<%if(page1.IsEnableNodeSearch()){ %>
<tr height='28'>
	<td class='sx-bar' >
		<table width='100%' border='0' cellspacing='0' cellpadding='0'>
			<tr >
				<td style='padding:2px;' width='90' ><span class='sx-normaltext'>自动展开</span><INPUT id='cbAutoExpand' name='cbAutoExpand' style='margin:2px;'  type='checkbox'></td>
				<td style='padding:2px;'  width='100' ><%=page1.Render("tbTreeFilter")%></td>
				<td width='20' style='padding:2px;' align='center'><A href='#' onclick='nodefilter();' title='点击搜索'><IMG border='0' alt='点击搜索' src='../sasrfex/images/default/icon_lookup.png'></A></td>
				<td >&nbsp;</td>
			</tr>	
		</table>
	</td>
</tr>
<%} %>
</table>
</div>
<DIV id='center'>
<%=page1.Render("iFrame")%>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
 	Ext.onReady(function(){
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[{
                    region:'west',
                    id:'west-panel',
                    split:true,
                    width: <%=page1.GetTitleBarWidth()%>,
                    minSize: 175,
                    maxSize: 400,
                    margins:'4 0 4 2',
                    layout:'accordion',
                    <%if(page1.IsShowTitleBar()){%>
                    title:'<%=page1.GetTreeName()%>',
                    hideCollapseTool:false,
                    collapsible: true,
                    <%}%>
                    layoutConfig:{
                        animate:true
                    },
                    contentEl: 'west'
                },
                new Ext.BoxComponent({
                	id:'center', 
                    region:'center',
                    el: 'center'
                })
              ]
        });
        
		var varCenter = viewport.items.get('center');

       	var ifr = Ext.getDom('<%=page1.GetCtrlUniqueId("iframe")%>');
		if(ifr!=null)
		{
			ifr.style.width = varCenter.getSize().width-6;
			ifr.style.height = varCenter.getSize().height-6;
		}
		varCenter.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
       		var ifr = Ext.getDom('<%=page1.GetCtrlUniqueId("iframe")%>');
			if(ifr!=null)
			{
				ifr.style.width = adjWidth-6;
				ifr.style.height = adjHeight-6;
			}
       	});
       	
        
       	var _SIDEBAR = $P.tree['<%=page1.GetCtrlUniqueId("TreePanel")%>'] ;
        var varTVSideBar = viewport.items.get('west-panel');
        if(varTVSideBar)
        {
            var adjWidth=varTVSideBar.getSize().width-1;
            var adjHeight=varTVSideBar.getSize().height;
        	var nHeight=adjHeight-varTVSideBar.items.getCount()*25;
        	 <%if(page1.IsShowTitleBar()){%>
        	 nHeight -= 28;
        	 <%}%>
        	 <%if(page1.IsEnableRootSelect()){ %>
        	 	nHeight -= 28;
     		<%}%>
     		<%if(page1.IsEnableNodeSearch()){ %>
        	 	nHeight -= 28;
     		<%}%>
           	if(nHeight<0)
           		nHeight = 0;
           	_SIDEBAR.setSize(adjWidth,nHeight);
           	if(_SIDEBAR.getResizeEl())
           	{
           		_SIDEBAR.getResizeEl().setSize(adjWidth,nHeight);
           	}
        }
        varTVSideBar.on('resize',function(obj, adjWidth, adjHeight,rawWidth,rawHeight)
       	{
        	if(adjWidth==undefined || adjWidth== NaN)
           		adjWidth = obj.getWidth();
           	if(adjHeight==undefined || adjHeight== NaN)
           		adjHeight = obj.getHeight();
            if(adjWidth==undefined || adjHeight == undefined)
               	return;
        	adjWidth-=1;
           	var _SIDEBAR = $P.tree['<%=page1.GetCtrlUniqueId("TreePanel")%>'] ;
           	var nHeight=adjHeight-obj.items.getCount()*25;
            <%if(page1.IsShowTitleBar()){%>
       		 nHeight -= 28;
       		<%}%>
       		<%if(page1.IsEnableRootSelect()){ %>
       	 	nHeight -= 28;
    		<%}%>
    		<%if(page1.IsEnableNodeSearch()){ %>
       	 	nHeight -= 28;
    		<%}%>
           	if(nHeight<0)
           		nHeight = 0;
           	_SIDEBAR.setSize(adjWidth,nHeight);
           	if(_SIDEBAR.getResizeEl())
           	{
           		_SIDEBAR.getResizeEl().setSize(adjWidth,nHeight);
           	}
        });
     });

 	 Ext.EventManager.on(window, 'unload', function() {
      	SRFRemoveIframe('<%=page1.GetCtrlUniqueId("iframe")%>');
       });
</script>
</body>
</HTML>