<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage2" language="java"%>
<% EditViewPage2 page1=(EditViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage2");%>
<% page1.setSimpleMode(true);page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.EDITVIEW","±à¼­ÊÓÍ¼")%> - <%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td><%=page1.Render("Toolbar")%></td>
		</tr>
		<tr >
			<td align='center'>
				<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td width='300' align='center'><DIV style='padding:1px;'><div id='BAR_INFO' class="sx-infopanel sx-normaltext" style="width:290px;height:20px;display:none;"></div></DIV></td>
					</tr>	
				</table>
			</td>
		</tr>
</table>
<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
	<tr>
		<td style='padding-left:4px;padding-right:4px;'>
			<%=page1.RenderErrorPanel()%>
		</td>
	</tr>
</table>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		nWidth = nWidth-12;
		if(nWidth<0)
			nWidth=0;
				
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		var _TAB=$P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB)
		{
			_TAB.setWidth(nWidth-18);
		}

		nHeight -=25;
		if(nHeight<0)
			nHeight=0;
		Ext.getDom('center').style.height = nHeight ;
			
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
</script>
</body>
</HTML>
