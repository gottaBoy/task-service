<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Admin.InternalLoginPage" />
<jsp:useBean id="tbx_LoginName" scope="page"
	class="SA.SRFramework.Web.SRFTextBox" />
<jsp:useBean id="tbx_LoginPassword" scope="page"
	class="SA.SRFramework.Web.SRFTextBox" />
<jsp:useBean id="Btn_Login" scope="page"
	class="SA.SRFramework.Web.SRFImgButton" />
<jsp:useBean id="lit_InputError" scope="page"
	class="SA.SRFramework.Web.SRFLiteral" />
<jsp:useBean id="Btn_Login1" scope="page"
	class="SA.SRFramework.Web.SRFImgButton" />
<jsp:useBean id="Btn_Login2" scope="page"
	class="SA.SRFramework.Web.SRFButton" />
<%
	//初始化页面对象
	page1.Init(pageContext);

	tbx_LoginName.setID("tbx_LoginName");
	tbx_LoginName.setCssClass("sx-input");
	tbx_LoginName.setWidth(150);
	page1.AddControl(tbx_LoginName);

	tbx_LoginPassword.setID("tbx_LoginPassword");
	tbx_LoginPassword.setCssClass("sx-input");
	tbx_LoginPassword.setWidth(150);
	page1.AddControl(tbx_LoginPassword);

	//Btn_Login.setID("Btn_Login");
	//Btn_Login.setAlternateText("登录到系统");
	//Btn_Login.setImageAlign("absMiddle");
	//Btn_Login.setImageUrl("../lyxg/btn_login_a.gif");
	//page1.AddControl(Btn_Login); 

	Btn_Login1.setID("Btn_Login1");
	Btn_Login1.setImageAlign("absMiddle");
	Btn_Login1.setImageUrl("images/btn_login.png");

	page1.AddControl(Btn_Login1);

	//增加文本对象
	lit_InputError.setID("lit_InputError");
	page1.AddControl(lit_InputError);

	//页面加载
	page1.Load();
%>

<html>
<head>
<title>SA BizSys Platform V3 登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../sasrfex/css/default/common.css" type="text/css"
	rel="stylesheet">
<style type="text/css">
body{

	background-color: #293A4A;
    SCROLLBAR:none;
}

<!--

.font-1 { 
	font-size: 12px; 
	color: white;
}
.font-error {
	font-size: 12px;
	font-weight: bold;
	color: red;
}
.input {
	font-size: 12px;
	border: 1px solid #adadad;
	width: 150px;
}
.normalinput {
	BORDER-RIGHT: #aaaaaa 1px solid; BORDER-TOP: #aaaaaa 1px solid; FONT-SIZE: 11px; BORDER-LEFT: #aaaaaa 1px solid; COLOR: #000000; BORDER-BOTTOM: #aaaaaa 1px solid; FONT-FAMILY: Verdana, Arial, "宋体", "幼圆"; HEIGHT: 19px; BACKGROUND-COLOR: #ffffff
}
-->
</style>

<script language="javascript">   
      
      
      function     reset()   
    {   
		  
		document.all.tbx_LoginName.focus();      
        
		document.all.tbx_LoginName.value="";   
        document.all.tbx_LoginPassword.value=""; 
        //document.all.lit_InputError.innerHTML="";
    }   
    
  function     load()   
    {   
		document.all.tbx_LoginName.focus();     
        //document.all.tbx_LoginName.select();   
        
		document.all.tbx_LoginName.onkeydown=nextInput;   
        document.all.tbx_LoginPassword.onkeydown=nextInput;
	//document.all.Btn_Login1.onkeydown=nextInput;   
    }   
      
  function   nextInput(){ 
  
      if(event.keyCode != 9){return;}  
	
      if(event.srcElement==document.all.tbx_LoginName)   
      {   
		
	      document.all.tbx_LoginPassword.focus();
		 
              //document.all.tbx_LoginPassword.select();   
      }   
     
      if(event.srcElement==document.all.tbx_LoginPassword)   
      {   
		
              document.all.tbx_LoginName.focus(); 
		  
              //document.all.Btn_Login1.select();   
     }   
	event.returnValue=false;
            
  }   
 
  </script>

</head>

<body onload="load()" bgcolor="#FFFFFF" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0">
<form id="<%=page1.getFormId()%>" name="<%=page1.getFormId()%>"
	method="post" action="<%=page1.getAction()%>"><%=page1.getDefaultPageCode()%>
<table width="100%"   border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td align="center" valign="top">
		<table width="960" height="600" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="68"></td>
			</tr>
			<tr>
				<td height="204" align="center">
				<table border="0" cellspacing="0" width="945" height="204" cellpadding="0">
					<tr>
						<td width="945" height="204"  align="center"><img
							src="images/logon.png" border="0" /> </td>
					</tr>
				</table>
				</td>
			</tr>
			 <tr>
				<td height="20"></td>
			</tr>
			<tr>
				<td align="center" height="80">

				<table width="400" height="80" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table>
								<tr>
									<td width="80" height="20" align="right"><span class="font-1">用户名：</span></td>
									<td width="160" align="left"><jsp:getProperty name="tbx_LoginName" property="HTML" /></td>
								</tr>
								<tr>
									<td width="80" height="20"  align="right" class="font-1">密&nbsp; 码：</td>
									<td width="160" align="left"><jsp:getProperty name="tbx_LoginPassword" property="HTML" /></td>
								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr >
									<td width="80" align="right"><jsp:getProperty name="Btn_Login1" property="HTML" /></td>
									<td>&nbsp;</td>
									<td width="80"><img style="cursor:hand;" src="images/btn_reset.png" align="middle" onclick="document.forms[0].reset();" ></td>
								</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td height="20" colspan=2></td>
					</tr>
					<tr>
						<td height="20" colspan=2 align="center" class="font-error"><jsp:getProperty name="lit_InputError" property="HTML" /></td>
					</tr>
				</table>
				</td>
			</tr>
			
			 <tr>
				<td height="10"></td>
			</tr>
			
			<tr>
				<td  align="center">
				<table width="945" height="2" border="0" bgcolor="#B2AEAF" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="80" height="2"  ></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td align="center" valign="top" height="5">  </td>
			</tr>
			<tr>
				<td align="center" valign="top" > <span style='font-family:Arial; font-size:12px;  color:white;'>Copyright &copy; 2007-2009  All Rights Reserved</span> <span style='font-family:微软雅黑; font-size:12px;  color:white;'></span></td>
			</tr>
		</table>
		</td>
	</tr>
</table> 
<%=page1.getStartupScript()%></form>
</body>
</html>





