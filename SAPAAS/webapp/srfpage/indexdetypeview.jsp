<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.IndexDETypeViewPage" />
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>选择视图-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden'>
     <table width='98%' border='0' align="center"  cellspacing='0' cellpadding='0'>
			<tr height='32'>
				<td width="5"></td>
					<td width="30">
						<IMG src="<%=page1.OutputPageIcon(false)%>">
					</td>
				<td>
					<SPAN style='white-space: nowrap;' class='sx-normaltext16-b'><B>请选择要添加<%=page1.OutputPageCaption() %>的<%=page1.getDEHelper().GetIndexTypeDEFHelper().getLogicName()%></B></SPAN>&nbsp;&nbsp;&nbsp;&nbsp;
					<SPAN id='BAR_DATA' class='sx-normaltext10-b' style='color:blue;white-space: nowrap;'></SPAN>
				</td>
			</tr>
	</table>
  	<table  style="border:solid #c5e1e4;border-width:1px 1px 1px 1px;" align="center" width="98%" border="0" cellspacing="0" cellpadding="0" >
    			<tr>
       			<td >
   					<%=page1.RenderIconView()%>
   				</td>
   			</tr>
   			<tr><td height="20"></td></tr>
   	</table>
<%=page1.Render()%>
<script type="text/javascript">
 	 function editview(arg)
 	 {
	 	 window.returnValue=arg;
	 	 window.close();
 	 }

 	 function editviewmultiform(arg)
 	 {
 	 	var _URL = arg.url;
 		var _S='../srfpage/multiformselectview.jsp?SRFDEID='+arg.deid;
 		var ret = SRFUtility.showmodaldialog(_S,'','scroll:yes;status:no;dialogHeight:400px;resizable:yes;dialogWidth:600px;',600,400);
 		if(ret==null||ret.ret!='ok')return;
 		_URL+=(arg.mffield+'='+ret.id+'&');
 		arg.url = _URL;
 		editview(arg);
 		//SRFUtility.openwin(_URL,'','resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0',false,0,0);
 	}
</script>
</body>
</HTML>