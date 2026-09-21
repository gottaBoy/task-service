<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.CommonXMLFormDialogEx" />
<%
	page1.Init(pageContext);
	page1.Load();
	if (page1.IsStop())
		return;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
<base target="_self">
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<div class="x-panel-body"  style="float: left;">
<table cellSpacing="0" cellPadding="0" width="100%" border="0">
	<tr>
		<td id='maintoolbar' height='25'><%=page1.Render("Toolbar")%></td>
	</tr>
	<tr align='center'>
		<td style='padding: 2px;'>
		<div id='BAR_INFO' class="sx-infopanel sx-normaltext"
			style="display: none; height: 20px;"></div>
		</td>
	</tr>
	<tr>
		<td>
			<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
				<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr >
						<td style='padding: 4px; padding-top: 0px;'><%=page1.RenderPanel()%></td>
					</tr>
					<tr>
						<td height='4'></td>
					</tr>
					<tr>
						<td style='padding-right: 3px'><%=page1.RenderErrorPanel()%></td>
					</tr>
				</table>
			</DIV>
		</td>
	</tr>
</table>
</div>
</body>
<%=page1.Render()%>
<script type="text/javascript">
	 
    function onok()
	{
	   <%=page1.GetOnOKCode()%>
	   return true;
	}
	 
	function updateobject(obj)
	{
		 var node = window.dialogArguments;
     	 if(node == null)
     	 	return ;
     	 node.xml = {};
     	 Ext.apply(node.xml, obj);
		 window.returnValue  = {};
		 window.returnValue.ret = 'ok';
		 window.close();
	}
	

	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);

		nHeight -=45;
		if(nHeight<0)
			nHeight=0;	
		Ext.getDom('center').style.height = nHeight ;
		Ext.getDom('center').style.width = nWidth;
		
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB!=null && _TAB!=undefined)
		{
			_TAB.setWidth(nWidth-30);
		}
	}
	
   Ext.onReady(function(){
     	Ext.EventManager.onWindowResize(layoutctrls);
     	layoutctrls();
      	//º”‘ÿ ˝æ›
     	 var node = window.dialogArguments;
     	 if(node == null)
     	 	return ;
     	 <%=page1.getDefaultFormId()%>.loadxml(node.xml);
 	});
</script>
</HTML>