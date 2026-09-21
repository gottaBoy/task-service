<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.UploadFileSavePage"/>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>上传文件</title>
<base target="_self">
</HEAD>
<body>
<script type="text/javascript">
	<%=page1.GetJSCode()%>
</script>
</body>
</HTML>
