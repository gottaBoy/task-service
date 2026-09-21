<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.HelpDocPage" />
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>帮助文档--<%=page1.GetHelpDocName()%></title>
</HEAD>
<FRAMESET cols="30%,70%" title="" >
<FRAME src="<%=page1.GetHelpDocPath()%>" name="fr_dir" title="文档目录">
<FRAME src="<%=page1.GetHelpDocPath2()%>" name="fr_content" title="文档内容">
</FRAMESET>
<NOFRAMES>
</NOFRAMES>
</HTML>