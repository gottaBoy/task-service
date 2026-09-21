<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage3" language="java"%>
<% EditViewPage3 page1=(EditViewPage3)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage3");%>
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><%=page1.GetLocalization("PAGE.HEADER.EDITVIEW","±à¼­ÊÓÍ¼")%> - <%=page1.OutputPageCaption()%></title>
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
</table>
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
                    height:64
                }),
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
       
    });
</script>
</body>
</HTML>
