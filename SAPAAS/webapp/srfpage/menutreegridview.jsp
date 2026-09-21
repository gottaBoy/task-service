<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MenuTreeGridViewPage" language="java"%>
<% MenuTreeGridViewPage page1=(MenuTreeGridViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MenuTreeGridViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.index.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function gettreenodetext(text,cnt)
{
	if(cnt=='')return text;
	if(cnt=='0')
		return text+' <SPAN style="color:blue">('+cnt+')</SPAN>';
	else
		return '<B>'+text+'</B> <SPAN style="color:blue">('+cnt+')</SPAN>';
}

function showtreenode(node,bshow)
{
	if(bshow){node.getUI().show();}else{node.getUI().hide();}
}
</script>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<div id='west'> 
<%=page1.Render("TreePanel")%>
</div>
<DIV id='center'>
<%=page1.Render("TabView")%>
</DIV>
<DIV id='update' style='display:none'></DIV>
<%=page1.Render()%>
<script type="text/javascript">
 	Ext.onReady(function(){
        
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[{
                    region:'west',
                    id:'west-panel',
                    split:true,
                    width: 200,
                    minSize: 175,
                    maxSize: 400,
                    margins:'4 0 4 2',
                    layout:'accordion',
                    <%if(page1.IsShowTitleBar()){%>
                    title:'<%=page1.GetLocalization("PAGE.COMMON.MENUTREEVIEW.LEFTBARTITLE","±ßÀ¸")%>',
                    hideCollapseTool:false,
                    collapsible: true,
                    <%}%>
                    layoutConfig:{
                        animate:true
                    },
                    items: [{
                    	id:'data_zone',
                        contentEl: 'west',
                        title:'<%=page1.GetTreeName()%>',
                        border:false,
                        iconCls:'nav',
                        collapsible: true
                    }]
                },
                new Ext.BoxComponent({
                	id:'center', 
                    region:'center',
                    el: 'center'
                })
              ]
        });
        
		var varCenter = viewport.items.get('center');
		var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
       	varCenter.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
       		 var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
       		_TAB.setSize(adjWidth,adjHeight);
       	});
       	_TAB.setSize(varCenter.getSize());
       		
        
       	var _SIDEBAR = $P.tree['<%=page1.GetCtrlUniqueId("TreePanel")%>'] ;
        var varTVSideBar = viewport.items.get('west-panel');
        if(varTVSideBar)
        {
            var adjWidth=varTVSideBar.getSize().width-1;
            var adjHeight=varTVSideBar.getSize().height;
        	var nHeight=adjHeight-varTVSideBar.items.getCount()*25;
        	 <%if(page1.IsShowTitleBar()){%>
        	 nHeight -= 25;
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
       		 nHeight -= 25;
       		<%}%>
           	if(nHeight<0)
           		nHeight = 0;
           	_SIDEBAR.setSize(adjWidth,nHeight);
           	if(_SIDEBAR.getResizeEl())
           	{
           		_SIDEBAR.getResizeEl().setSize(adjWidth,nHeight);
           	}
        });
         <%=page1.GetUpdateCode()%>
     });
</script>
</body>
</HTML>