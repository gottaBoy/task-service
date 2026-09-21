<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="header" scope="page" class="saeam.include.Header" />
<%	header.Init(pageContext);header.Load(); %>
<table width="960" border="0" height="47" align="center" cellpadding="0" cellspacing="0" style='background-image: url(../images/icon_banner_bg.gif);background-repeat: repeat-x;' >
	<tr>
	    <td  align="left" width='360'><IMG src='<%=header.getLogo() %>'></td >
	    <td>
			<table  border="0" height="47" align="right" cellpadding="0" cellspacing="0"> 
				<tr height="5"><td></td></tr>
			  
			  	<tr height="20"><td align='right' class='sx-normaltext'><span class='sx-normaltext'>»¶Ó­Äú</span> ,&nbsp;<%= header.getUserInfo() %>&nbsp;&nbsp;<A href='javascript:logout();'><IMG border='0' src='../images/btn_logout.gif' alt='' align='absmiddle'></A>&nbsp;&nbsp;</td></tr>
				<tr ><td ></td></tr>
			</table>

		</td>
 	 </tr>
	
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	    <td height="1" align="left" bgcolor="#ffffff">
	    </td >
  </tr>
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	    <td height="22" align="left" bgcolor="#e6e6e6" >
	    	<%=header.Render("mainMenu") %>
	    </td >
	    <td width="50" align="right" bgcolor="#e6e6e6"><a  class="gridlink" href='/SAEAM'><span class='sx-normaltext'>Ê×Ò³</span></a>&nbsp;&nbsp;</td>
  </tr>
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	    <td height="1" align="left" bgcolor="#ffffff">
	    </td >
  </tr>
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0" style="background-color:#777c76;">
	<tr>
		<td width="20"  height="26">
		</td>
	    <td align="left" width="60" style='padding-top: 3px;'>
	    	<IMG src="../images/icon_navi_prev.gif">&nbsp;<IMG src="../images/icon_navi_next.gif">
	    </td>
	    <td align="left" width='860' style='padding-top: 3px;padding-bottom: 3px;'>
	    	<SPAN id='NAVIGATEBAR' style='padding-left:2px;padding-right:2px;padding-top: 1px;padding-bottom: 1px;width:850px;background-color:#ffffff;'></SPAN>
	    </td>
	    <td>&nbsp;</td>
  </tr>
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr><td height="4" ></td ></tr>
</table>
<%= header.Render() %>