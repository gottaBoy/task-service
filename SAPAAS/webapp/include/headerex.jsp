<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="header" scope="page" class="saeam.include.HeaderEx" />
<%	header.Init(pageContext);header.Load(); %>
<table width="100%" border="0" height="47" align="left" cellpadding="0" cellspacing="0" >
	<tr>
	    <td  align="left" width='360'><IMG src='<%=header.getLogo() %>'></td >
	    <td>
			<table width="100%"  border="0" height="47" align="right" cellpadding="0" cellspacing="0"> 
				<tr height="5"><td></td></tr>
			  	<tr height="20"><td align='right' class='sx-normaltext'><span class='sx-normaltext'>»¶Ó­Äú</span> ,&nbsp;<%= header.getUserInfo() %>&nbsp;&nbsp;<A href='javascript:logout();'><IMG border='0' src='../images/btn_logout.gif' alt='' align='absmiddle'></A>&nbsp;&nbsp;</td></tr>
				<tr ><td ><a  class="gridlink" href='/SAEAM'><span class='sx-normaltext'>Ê×Ò³</span></a>&nbsp;&nbsp;</td></tr>
			</table>
		</td>
 	 </tr>
  	<tr >
  		<td colspan='2'>
  			<%=header.Render("mainMenu") %>
  		</td>
  	</tr>
  	<tr>
	    <td colspan='2' height="1" align="left" bgcolor="#ffffff">
	    </td >
  </tr>
</table>
<%= header.Render() %>