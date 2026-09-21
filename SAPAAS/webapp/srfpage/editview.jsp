<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage" language="java"%>
<% EditViewPage page1=(EditViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage");%>
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><%=page1.GetLocalization("PAGE.HEADER.EDITVIEW","编辑视图")%> - <%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<div id='north'>
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td><%=page1.Render("Toolbar")%></td>
		</tr>
		<tr>
			<td height='4'></td>
		</tr>
		<tr height="34">
			<td>
				<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td width="5"></td>
						<td width="30">
						<IMG src="<%=page1.OutputPageIcon(false)%>">
						</td>
						<td>
						<SPAN style='white-space: nowrap;' class='sx-normaltext16-b'><B><%=page1.OutputPageCaption()%></B></SPAN>&nbsp;&nbsp;&nbsp;&nbsp;
						<SPAN id='BAR_DATA' class='sx-normaltext10-b' style='color:blue;white-space: nowrap;'></SPAN>
						</td>
						<td width='300'><DIV style='padding:1px;'><div id='BAR_INFO' class="sx-infopanel sx-normaltext" style="width:290px;height:30px;display:none;"></div></DIV></td>
					</tr>	
				</table>
			</td>
		</tr>
		<%if(page1.IsEnableWFMainState()){%>
		<tr height="40">
			<td align='center' id='srfwfmstd'>
			</td>
		</tr>
		<%}%>
</table>
</div>
<div id='west'> 
<%= page1.Render("tabViewSideBar")%>
</div>
<div id='west2'> 
</div>
<DIV id='center'>
<%= page1.Render("TabView")%>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
 	Ext.onReady(function(){
        var viewport = new Ext.Viewport({
            layout:'border',
            items:[
            new Ext.BoxComponent({ 
            		id:Ext.id(),
                    region:'north',
                    el: 'north',
                    height:<%if(page1.IsEnableWFMainState()){%>104<%}else{%>64<%}%>
                }), 
                {
                    region:'west',
                    id:'west-panel',
                    split:true,
                    width: 200,
                    minSize: 175,
                    maxSize: 400,
                    collapsible: true,
                    margins:'4 0 4 2',
                    layout:'accordion',
                    hideCollapseTool:true,
                    layoutConfig:{
                        animate:true
                    },
                    items: [{
                    	id:'data_zone',
                        contentEl: 'west',
                        title:'<%=page1.GetLocalization("PAGE.COMMON.EDITVIEW.DATAANDRELATIONSHIP","数据及关系")%>',
                        border:false,
                        iconCls:'nav',
                        collapsible: true
                    },
                    {
                        contentEl: 'west2',
                        title:'<%=page1.GetLocalization("PAGE.COMMON.EDITVIEW.SHORTCUT","快捷操作")%>',
                        border:false,
                        iconCls:'nav'
                    }]
                },
                new Ext.BoxComponent({
                	id:'center', 
                    region:'center',
                    el:'center'
                })
              ]
        });

    	var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
       
       	var varCenter = viewport.items.get('center');
       	if(varCenter!=null)
       	{
	        varCenter.on('resize',function(obj, adjWidth, adjHeight, rawWidth,  rawHeight)
	        {
	        	var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
	       		_TAB.setSize(adjWidth,adjHeight);
	        });
	        _TAB.setSize(varCenter.getSize());
      	}
       	
        var _SIDEBAR = $P.tree['<%=page1.GetCtrlUniqueId("TabViewSideBar")%>'] ;
        var varTVSideBar = viewport.items.get('west-panel');
        if(varTVSideBar)
        {
            var adjWidth=varTVSideBar.getSize().width-1;
            var adjHeight=varTVSideBar.getSize().height;
        	var nHeight=adjHeight-varTVSideBar.items.getCount()*25;
           	if(nHeight<0)
           		nHeight = 0;
           	_SIDEBAR.setSize(adjWidth,nHeight);
           	if(_SIDEBAR.getResizeEl())
           	{
           		_SIDEBAR.getResizeEl().setSize(adjWidth,nHeight);
           	}
        }
       
        varTVSideBar.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
           	if(adjWidth==undefined || adjWidth== NaN)
           		adjWidth = obj.getWidth();
           	if(adjHeight==undefined || adjHeight== NaN)
           		adjHeight = obj.getHeight();
            if(adjWidth==undefined || adjHeight == undefined)
               	return;
           	adjWidth-=1;
           	var _SIDEBAR = $P.tree['<%=page1.GetCtrlUniqueId("TabViewSideBar")%>'] ;
           	var nHeight=adjHeight-obj.items.getCount()*25;
           	if(nHeight<0)
           		nHeight = 0;
           	_SIDEBAR.setSize(adjWidth,nHeight);
           	if(_SIDEBAR.getResizeEl())
           	{
           		_SIDEBAR.getResizeEl().setSize(adjWidth,nHeight);
           	}
       });
    });
</script>
<%@include file="/include/addin.editview.jsp"%>
</body>
</HTML>
