<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedInfoViewPage" language="java"%>
<% EmbedInfoViewPage page1=(EmbedInfoViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedInfoViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>у╧й╬йсм╪-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<DIV class='x-panel-body-noheader x-panel-body' style='overflow:hidden' >
<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
</table>
</DIV>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);

		nHeight -=5;
		if(nHeight<0)
			nHeight=0;	
		Ext.getDom('center').style.height = nHeight ;
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB)
		{
			nWidth-=30;
			if(nWidth<0)
				nWidth = 0;
			_TAB.setWidth(nWidth);
		}
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
	});
 	
 	function setsummarykey(_1)
 	{
  		<%=page1.GetLoadFormCode()%>
 	}
 	function setsummarykey2(_1)
 	{
 		Ext.onReady(function(){
 		<%=page1.GetLoadFormCode()%>
  		});
 	}
</script>
</body>
</HTML>
