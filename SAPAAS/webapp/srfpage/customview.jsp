<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.EditViewPage2" />
<% page1.setSimpleMode(true);page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.CUSTOMCONFIG","个性化设置")%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td><%=page1.Render("Toolbar")%></td>
		</tr>
		<tr height="24">
			<td>
				<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td width="5"></td>
						<td width="30">
						&nbsp;
						</td>
						<td width='300'><DIV style='padding:1px;'><div id='BAR_INFO' class="sx-infopanel sx-normaltext" style="width:290px;height:20px;display:none;"></div></DIV></td>
					</tr>	
				</table>
			</td>
		</tr>
</table>
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
<%=page1.Render()%>
<script type="text/javascript">
	function layoutctrls()
	{
		var nWidth = Ext.lib.Dom.getViewWidth(false);
		var nHeight = Ext.lib.Dom.getViewHeight(false);
		var _TAB  = $P.tabpanel['<%=page1.GetCtrlUniqueId("panel")%>'];
		if(_TAB!=null && _TAB!=undefined)
		{
			_TAB.setWidth(nWidth-8);
		}
			
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();

		 if($P.mainform){
		    var _themeid = $P.mainform._UID.appuitheme;
		    var _themevalue = $P.mainform.getvalue(_themeid);
		    Ext.get(_themeid).on('change', onpreview);
		 }
 	});
    function onpreview(){
	    var _preImg = document.getElementById('PREIMG') ;
	    var _themeid = $P.mainform._UID.appuitheme;
	    var _themevalue = $P.mainform.getvalue(_themeid);
	    if(_themevalue == null || _themevalue == ''){
	    	_themevalue = 'appuitheme_error';
		}
	    if(_themevalue){
			_themevalue = _themevalue.toLowerCase();
		}
	    if(_preImg){
	        _preImg.src= '../sasrfex/images/apptheme/'+_themevalue+'.png';
     	}
    }
</script>
</body>
</HTML>
