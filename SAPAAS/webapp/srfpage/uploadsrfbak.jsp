<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.UploadSRFBakPage"/>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>数据处理结果</title>
<base target="_self">
<LINK href="../resources/css/ext-all.css" type="text/css"	rel="stylesheet">
<LINK href="../sasrfex/css/default/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../jscript/ext/ext-all-ori.js"></script>
</HEAD>
<body style='background-color:#ffffff;overflow:hidden;padding:2px;'>
<DIV id='center' class='x-panel-body-noheader x-panel-body' style='overflow:auto;' >
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr>
		<td >
			<SPAN class='sx-normaltext'>数据处理结果：</SPAN>
		</td>
	</tr>
	<tr>
		<td>
			<DIV style='overflow:auto;height:480px;'>
				<SPAN class='sx-normaltext'>
					<%=page1.getProcessInfo() %>
				</SPAN>
			</DIV>
		</td>
	</tr>
</table>
</DIV>
</HTML>