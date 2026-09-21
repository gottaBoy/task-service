<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.ErrorViewPage" />
<% page1.Init(pageContext);page1.Load();if (page1.IsStop())	return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>¥ÌŒÛœ‘ æ“≥√Ê</title>
<LINK href="../resources/css/ext-all.css" type="text/css"	rel="stylesheet">
<LINK href="../sasrfex/css/default/common.css" type="text/css"	rel="stylesheet">
<script type="text/javascript" src="../jscript/ext/ext-all.js"></script>
<script type="text/javascript" src="../sasrfex/javascript/sasrfex.js"></script>
</HEAD>
<body>
<DIV class='x-panel-body-noheader x-panel-body'>
<table cellSpacing="0" cellPadding="0" width="100%" height='100%'	border="0">
	<tr>
		<td id='TD1' align="center" valign="bottom">
		<IMG src='../sasrfex/images/default/icon_info.gif'>&nbsp;<SPAN class='sx-normaltext10-b'><%=page1.GetErrorInfo()%></SPAN>
		</td>
	</tr>
	<tr>
		<td id='TD2' >&nbsp;</td>
	</tr>
</table>
</DIV>
</body>
<script type="text/javascript">
function onWindowResize(_1,_2)
{
	var nHeight = Ext.lib.Dom.getViewHeight(false)-4;
	if(nHeight>0)
	{
		Ext.getDom('TD1').style.height = nHeight*0.4;
		Ext.getDom('TD2').style.height = nHeight-(nHeight*0.4);
	}
}
Ext.onReady(function(){
    	Ext.EventManager.onWindowResize(onWindowResize);
    	onWindowResize(0,0);
	  	Ext.getDoc().on('click',function(){
	    		if(window.top && window.top.Ext)
	    			if(Ext.menu.MenuMgr != window.top.Ext.menu.MenuMgr)
	    				window.top.Ext.menu.MenuMgr.hideAll();
	  	  });
    });
</script>
</HTML>