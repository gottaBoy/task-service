<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.NavFramePickupPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.PICKUPVIEW","Ñ¡ÔñÊÓÍ¼")%> - <%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<%=page1.GetPageHeaderContent() %>
<base target="_self">
</HEAD>
<body >
 
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
 	Ext.onReady(function(){
        
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[ 
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
                    margins:'0 4 0 4'
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
        
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     });
      
     var _SELECTROW={};
     function selectvalue()
     {
     	$P.button['<%=page1.GetCtrlUniqueId("OkButton")%>'].fireEvent('click');
     }
     
       var _IFrame;
</script>
</body>
</HTML>