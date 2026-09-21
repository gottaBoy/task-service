<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="leftBar" scope="page" class="saeam.include.LeftBar" />
<%	leftBar.Init(pageContext);leftBar.Load(); %>
<%= leftBar.Render("leftMenu") %>
<table cellSpacing="0" cellPadding="0"  width="100%" border="0" height="10" >
<tr><td></td></tr>
</table>

<%= leftBar.Render() %>