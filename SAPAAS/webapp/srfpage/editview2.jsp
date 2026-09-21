<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EditViewPage2" language="java"%>
<% EditViewPage2 page1=(EditViewPage2)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EditViewPage2");%>
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
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
		<tr>
			<td height='4'></td>
		</tr>
		<tr height="34">
			<td>
				<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td width="5"></td>
						<td width="30"><IMG src='<%=page1.OutputPageIcon(false)%>'></td>
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
<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
	<tr id='TR_ERRORPANEL'>
		<td style='padding-left:4px;padding-right:8px;'>
			<%=page1.RenderErrorPanel()%>
		</td>
	</tr>
	<tr >
		<td style='padding:4px;'>
			<%= page1.RenderTabView()%>
		</td>
	</tr>
</table>
</DIV>
<%=page1.Render()%>
<script type="text/javascript">
 	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		nWidth = nWidth-12;
		if(nWidth<0)
			nWidth =0;
		nHeight -=<%if(page1.IsEnableWFMainState()){%>110<%}else{%>70<%}%>;
		if(nHeight<0)
			nHeight=0;	
		Ext.getDom('center').style.height = nHeight ;
		
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB!=null)
		{
			_TAB.setWidth(nWidth-18);
			nHeight-=_TAB.getSize().height;
		}
		
		var _TABVIEW = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>'];
		if(_TABVIEW!=null)
		{
			_TABVIEW._TAB.setWidth(nWidth-18);
			nHeight-=18;
			if(nHeight<0)
				nHeight = 0;
			if(nHeight<300)
			{
				nHeight=300;
			}
			_TABVIEW._TAB.setHeight(nHeight);
		}
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 var _TAB=$P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		 if(_TAB!=null)
		 {
		 	_TAB.on('tabchange', layoutctrls);
		 }
		 layoutctrls();
 	});
</script>
</body>
</HTML>
