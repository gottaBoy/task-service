<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.UploadFilePage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>上传文件</title>
<LINK href="../resources/css/ext-all.css" type="text/css"	rel="stylesheet">
<LINK href="../sasrfex/css/default/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../jscript/ext/ext-all-ori.js"></script>
<base target="_self">
</HEAD>
<body style='background-color:#ffffff;overflow:hidden;padding:2px;'>
<DIV id='center' class='x-panel-body-noheader x-panel-body' >
<FORM id='uploadform'  METHOD='POST' ENCTYPE="multipart/form-data" ACTION="uploadfile.jsp?<%=page1.getWebContext().GetQueryString()%>>" >
<table  width='100%' border='0' cellspacing='0' cellpadding='0'>
	<tr>
		<td colspan='2' >
			<SPAN class='sx-normaltext'>请选择要上传文件：</SPAN>
		</td>
	</tr>
	<tr>
		<td>
			<INPUT ID='UPLOAD' NAME='UPLOAD' type='file' width='400'>
		</td>
		<td width='100'>
			<INPUT type='button' value='上传' onclick='formsubmit();' >
		</td>
	</tr>
</table>
</FORM>
</DIV>
<%=page1.Render()%>
<script type="text/javascript"> 
	function waitInfo()
	{
		var msgWait = Ext.Msg.progress({
			   title: '', 
			   msg: ''  
			});		   
		msgWait.wait("","",{   
		   interval: 200, //bar will move fast! 
		   duration: 300000,   
		   increment: 10,     
		   text: '正在上传,请等候..',  
		   scope: this,
		   fn: function(){
		      Ext.fly('uploadInfo').update('上传文件超时!');
		      msgWait.hide(); 
		   }}  
  		 );		
	}

	function formtest()
	{
		window.returnValue={};
		window.close();
	}
	
	function formsubmit()
	{  
		var strFileURL = document.getElementById('UPLOAD').value;
		strFileURL = strFileURL.trim();
		if(strFileURL == '' || strFileURL==null || strFileURL == undefined || strFileURL.length == 0)
			return;
		waitInfo();   
		uploadform.submit();    
	} 

</script> 
</body>
</HTML>
