<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="saeam.include.AIHist" />
<% 	page1.Init(pageContext);	page1.Load(); %>
<table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr ><td height="3"> </td></tr>
	<%=page1.getAIHist()%>
	<tr ><td height="3"> </td></tr>
</table>