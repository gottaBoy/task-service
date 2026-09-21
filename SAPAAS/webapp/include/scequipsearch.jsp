<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="saeam.include.SCEquipSearch" />
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
		<%=page1.Render("infoButton") %><%=page1.Render("histButton") %>
		</DIV>
	</td></tr>
	<tr><td align="center">
	<DIV class="sx-commandbar" style="width:160px;">
		<%=page1.Render("runButton") %> <%=page1.Render("energyButton") %>
	</DIV>
	</td></tr>
</table>
<%=page1.Render() %>