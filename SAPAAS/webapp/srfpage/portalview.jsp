<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAWebUtil" language="java"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.PortalPage" />
<%	page1.Init(pageContext);page1.Load();if(page1.IsStop()) return; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.PORTALVIEW","门户视图")%>-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.min.jsp"%>
<script type="text/javascript" src="../jscript/portal/portal.js"></script>
<LINK href="../css/portal/portal.css" type="text/css"	rel="stylesheet">
<LINK href="../css/portal/liststyle.css" type="text/css"	rel="stylesheet">
 <script language="JavaScript" src="../charts/FusionCharts.js"></script>
 <script type="text/javascript" src="../sasrfex/datepicker/WdatePicker.js"></script>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >                                                   
<div id='north' style='padding-top:2px;padding-bottom:2px;background-color:#ffffff;'>
	<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td>&nbsp;</td>
			<td width='80' align='right'><span class='sx-normaltext'><%=page1.GetLocalization("PAGE.COMMON.PORTALVIEW.LAYOUTSTYLE","页面样式")%></span>&nbsp;</td>
			<td width='130' align='center'><%=page1.Render("ddlPortalPageStyle") %></td>
			<td width='100' align='center'><a href="<%=page1.GetAddWebPartLink()%>"><span class='sx-normaltext'><%=page1.GetLocalization("PAGE.COMMON.PORTALVIEW.ADDWEBPART","增加网页部件")%></span></a></td>
		</tr>
</table>
</div>
<%=page1.RenderWebParts()%>
</body>
<%=page1.Render()%>
<script type="text/javascript">
var varCenter = null;
var varViewport = null;
function recalcwebpart()
{
	var strModel='';
	for(var i = 0;i<varCenter.items.getCount();i++)
	{
		var varItem = varCenter.items.get(i);
		for(var j =0;j<varItem.items.getCount();j++)
		{
			if(strModel!='')
				strModel+=';';
			strModel += i.toString();
			strModel += '|';
			strModel += j.toString();
			strModel += '|';
			strModel += varItem.items.get(j).id;
		}
	}
//	alert(strModel);
	var _PARAMS = {ppmodel:strModel};
    var _CALLBACK =
	{
		timeout: 30000
	};
    var _POSTDATA = Ext.urlEncode(_PARAMS);
    Ext.lib.Ajax.request('post','../srfpage/ppmodelbackend.jsp?PPModelId=<%=page1.GetPPModelId()%>' , _CALLBACK, _POSTDATA);
}

Ext.onReady(function(){
    var tools = [{
        id:'close',
        handler: function(e, target, panel){
            panel.ownerCt.remove(panel, true);
            recalcwebpart();
        }
    }];

	varViewport = new Ext.Viewport({
        layout:'border',
        hideBorders :true,
        items:[
      	  new Ext.BoxComponent({ 
            		id:Ext.id(),
                    region:'north',
                    el: 'north',
                    height:22
                }),
        	{
        	id:'center',
            xtype:'portal',
            region:'center',
            margins:'0 0 0 0',
            
            items:[
            	<%for(int i =0;i<page1.GetPPMColumnCount();i++){%>
            	<%if(i!=0){%>,<%}%>{
	                columnWidth:.<%=page1.GetPPMColumnWidth(i)%>,
	                style:'padding:8px <%if(i+1==page1.GetPPMColumnCount()){%>20px<%}else{%>8px<%}%> 8px 8px',
	                items:[<%=page1.RenderPortlets(i)%>]
	            }
            <%}%>
             ]
             ,listeners: {
                'drop': function(e){
                 	var nWidth = varCenter.items.get(e.columnIndex).getSize().width - 16;
                 	if(e.columnIndex+1 == <%=page1.GetPPMColumnCount()%>)
                 		nWidth-=12;
                	if(nWidth<0)
                		nWidth = 0;
                	e.panel.setWidth(nWidth);
                 	recalcwebpart();
                }
           }
        }]
    });
    
    varCenter = varViewport.items.get('center');
    Ext.getDom(varCenter.body).style.overflowX='hidden';

    Ext.getDoc().on('click',function(){
       		if(window.top && window.top.Ext)
       			if(Ext.menu.MenuMgr != window.top.Ext.menu.MenuMgr)
       				window.top.Ext.menu.MenuMgr.hideAll();
     	  });
   	
   	<%=page1.RenderWebPartsVisble()%>
   	varViewport.syncSize();
   	varCenter.syncSize();
   	setctrlsoverflow();
   	if(Ext.isChrome)
 	   Ext.EventManager.onWindowResize(layoutctrls);
   	
});
function layoutctrls()
{
	for(var i = 0;i<varCenter.items.getCount();i++)
	{
		var varItem = varCenter.items.get(i);
		for(var j =0;j<varItem.items.getCount();j++)
		{
			var varItem2=varItem.items.get(j);
			varItem2.setVisible(true);
		}
	}
}

function setctrlsoverflow()
{
	for(var i = 0;i<varCenter.items.getCount();i++)
	{
		var varItem = varCenter.items.get(i);
		for(var j =0;j<varItem.items.getCount();j++)
		{
			var varItem2=varItem.items.get(j);
			varItem2.body.setStyle("OVERFLOW","AUTO");
		}
	}
}

Ext.EventManager.on(window, 'unload', function() {
	if(varCenter)
	{
     	delete varCenter;
     	varCenter = null;
    }
    if(varViewport)
    {
    	delete varViewport;
    	varViewport = null;
    }
});
</script>
</HTML>