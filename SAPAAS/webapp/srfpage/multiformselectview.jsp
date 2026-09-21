<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.MultiFormSelectViewPage" />
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetLocalization("PAGE.HEADER.PICKUPVIEW","选择视图")%> - <%=page1.OutputPageCaption()%></title>
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
					<SPAN style='white-space: nowrap;' class='sx-normaltext16-b'><B>请选择要添加<%=page1.OutputPageCaption() %>的<%=page1.GetSelectObjectName()%></B></SPAN>&nbsp;&nbsp;&nbsp;&nbsp;
					<SPAN id='BAR_DATA' class='sx-normaltext10-b' style='color:blue;white-space: nowrap;'></SPAN>
				</td>
			</tr>
	</table>
	<DIV style="border:solid #c5e1e4;border-width:1px 1px 1px 1px;overflow:auto;width:100%;height:400px;">
  	<table  align="center" width="98%" border="0" cellspacing="0" cellpadding="0" >
    		<tr>
       			<td >
   					<%=page1.RenderIconView()%>
   				</td>
   			</tr>
   	</table>
   	</DIV>
   	<BR></BR>
 
<%=page1.Render()%>
<script type="text/javascript">
 	 function endview(arg)
 	 {
	 	 window.returnValue=arg;
	 	 window.close();
 	 }
</script>
</body>
</HTML>