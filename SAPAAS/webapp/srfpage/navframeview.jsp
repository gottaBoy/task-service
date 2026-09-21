<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePage" language="java"%>
<% NavFramePage page1=(NavFramePage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<div id='west' style='width:100%;height:100%;' >  
<%= page1.PANELS%>
</div>
<DIV id='center'>
<%= page1.Render("TabView")%>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutleft(width,height)
    {
     	try
     	{
	     	<%=page1.LAYOUTCTRLS%>;
     	}
     	catch(e)
     	{}
    }
    
 	Ext.onReady(function(){
        
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[{
                    region:'west',
                    id:'west',
                    split:true,
                    width: 150,
                    minSize: 150,
                    maxSize: 200,
                    margins:'4 0 4 2',
                    <%if(page1.bCollapsible){%>
                    	layout:'accordion',
                    	hideCollapseTool:true,
                    	collapsible: true,
                    	//title:'±ßÀ¸',
                     <%}else{%>
                    collapsible: false,
                    <%}%>
                    layoutConfig:{
                        animate:true
                    },
                    items: [<%=page1.ITEMS%>]
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
       		
     
        var varWest = viewport.items.get('west');
       
     	varWest.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{  
     	    if(adjWidth==undefined || adjWidth== NaN)
           		adjWidth = obj.getWidth();
           	if(adjHeight==undefined || adjHeight== NaN)
           		adjHeight = obj.getHeight();
            if(adjWidth==undefined || adjHeight == undefined)
               	return;
            adjHeight=adjHeight-25*<%=page1.PAGECNT%>;
        	layoutleft(adjWidth-2,adjHeight);
        });
        
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     });
     
       var _IFrame;
       var westpagecnt=<%=page1.PAGECNT%>;
       var leftbarwidth=150;
</script>
</body>
</HTML>