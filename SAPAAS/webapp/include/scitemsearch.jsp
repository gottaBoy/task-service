<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="saeam.include.SCItemSearch" />
<% 	page1.Init(pageContext);	page1.Load(); %>
<table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr ><td height="3"> </td></tr>
	<tr><td>
	<%=page1.RenderLoadingIndicator(page1.getFormId()+"_indicator") %>
	<%=page1.Render("panel")%>
	<div class="sx-panel" id="<%=page1.getFormId()%>_errorindicator" style="width:100%;height:50px;display:none;"></div>
	</td></tr>
	<tr><td align="center">
		<DIV class="sx-commandbar" style="width:160px;">
		<%=page1.Render("viewButton") %><%=page1.Render("costButton") %>
		</DIV>
	</td></tr>
	<tr><td align="center">
	<DIV class="sx-commandbar" style="width:160px;">
		<%=page1.Render("stockButton") %><%=page1.Render("ioButton") %>
	</DIV>
	</td></tr>
</table>
<%=page1.Render() %>