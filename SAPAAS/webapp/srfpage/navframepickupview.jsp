<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFramePickupPage" language="java"%>
<% NavFramePickupPage page1=(NavFramePickupPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFramePickupPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.PICKUPVIEW","Ñ¡ÔñÊÓÍ¼")%> - <%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<SCRIPT language="javascript" type="text/javascript">
function StripObjHtml(o)
{
	for(var key in o)
	{

            var strValue = o[key].toString();
            if (strValue != null && strValue != '' && strValue.indexOf('<')>=0)
            {
            	 
                strValue=StripHtml(strValue);
                o[key]=strValue;
                
            }
	}
	return o;
}

function StripHtml(html)
{
    html = html  || "";
    var scriptregex = "<scr" + "ipt[^>.]*>[sS]*?</sc" + "ript>";
    var scripts = new RegExp(scriptregex, "gim");
    html = html.replace(scripts, "");

    //Stripts the <style> tags from the html
    var styleregex = "<style[^>.]*>[sS]*?</style>";
    var styles = new RegExp(styleregex , "gim");
    html = html.replace(styles, "");

    //Strips the HTML tags from the html
    var objRegExp = new RegExp("<(.| )+?>", "gim");
    var  strOutput = html.replace(objRegExp, "");

    //Replace all < and > with &lt; and &gt;
    strOutput = strOutput.replace(/</, "&lt;");
    strOutput = strOutput.replace(/>/, "&gt;");
    strOutput = strOutput.replace('&nbsp;','');

    objRegExp = null;
    return strOutput;
}
</script>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<div id='west' >  
<%= page1.PANELS%>
</div>
<DIV id='center'>
<%= page1.Render("TabView")%>
</DIV>
<DIV id='south' align="right" class='x-toolbar'>
<table   border='0' width='100%' cellspacing='0' cellpadding='0'   >
				<tr height='20' style='padding:2px;' >
					<td>&nbsp;</td>
					<td  width="120">
						<%= page1.Render("CancelButton")%>	
					</td>
					<td  width="120">
						<%= page1.Render("ResetButton")%>	
					</td>
					<td width="120">
						<%= page1.Render("OKButton")%>	
					</td>
				</tr>
			</table>
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
                    width: 200,
                    minSize: 200,
                    maxSize: 200,
                    collapsible: true,
                    margins:'4 0 4 2',
                     <%if(page1.bCollapsible){%>
                    	layout:'accordion',
                    	hideCollapseTool:true,
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
                }),
                {
                    region:'south',
                    contentEl: 'south',
                    height: 30,
                    minSize: 100,
                    maxSize: 200,
                    collapsible: false,
                    margins:'0 4 0 2'
                } 
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
       		layoutleft(adjWidth-2,adjHeight-25*<%=page1.PAGECNT%>);
       		
       	});
        
        
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     });
      
     var _SELECTROW={};
     function selectvalue()
     {
     	$P.button['<%=page1.GetCtrlUniqueId("OkButton")%>'].fireEvent('click');
     }
       var _IFrame;
     
      var westpagecnt=<%=page1.PAGECNT%>;
      var leftbarwidth=200;
</script>
</body>
</HTML>