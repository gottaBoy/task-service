<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.SearchFormViewPage" language="java"%>
<% SearchFormViewPage page1=(SearchFormViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.SearchFormViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>ËÑË÷ÊÓÍ¼-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<DIV id='center' style='background-color:#ffffff;overflow:auto'> 
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr >
		<td style='padding:4px;'>
			<%=page1.RenderPanel()%>
		</td>
	</tr>
	<tr>
		<td style='padding:4px'>
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
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		Ext.getDom('center').style.height = nHeight ;
		Ext.getDom('center').style.width = nWidth;

		var _SP=$P.sp['<%=page1.GetCtrlUniqueId("spEx")%>'];
		if(_SP)
		{
			_SP.setWidth(nWidth-8);
		}
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
	});

    var varSearchParam = {};
	function spsearchback()
	{
		var A='<%=page1.GetSearchRedirectPage()%>';
		A+=Ext.urlEncode(varSearchParam);
		window.location.href=A;
	}
 	
</script>
</body>
</HTML>
