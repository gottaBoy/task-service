<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFramework.WebEx.SRFExWebContext" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>正在跳转到登录界面...</title>
		<script type="text/javascript" src="../jscript/ext/ext-all.js"></script>
		<SCRIPT type="text/javascript" LANGUAGE='javascript'>
		if(navigator.userAgent.indexOf('WebKit')>0){
			window.onerror = errorhandler();
		}else {
			window.onerror = errorhandler;
		}
		function errorhandler(message, uri, line) { 
		    window.location.href='uaclogin6.jsp?<%=SRFExWebContext.FilterQueryString(request.getQueryString())%>';
		    return true; 
		}; 
		Ext.onReady(function(){
			 var url = '<%=request.getParameter("DIRECT")%>';
			 if(url!=null && url=='TRUE')
			 {
				 window.location.href='uaclogin6.jsp?<%=SRFExWebContext.FilterQueryString(request.getQueryString())%>';
			 }
			 else
			 {
				 var A = window.opener;
				 if(A)
				 {
					 if(A.closed)
					 {
						 A = window.top;
						 if(A&&!A.closed)
						 {
							 A.location.reload();
							 window.close();
						 }
						 else
						 {
							 window.location.href='uaclogin6.jsp?<%=SRFExWebContext.FilterQueryString(request.getQueryString())%>';
						 }	 
					 }
					 else
					 {
						A.location.reload();
					 	window.close();
					 }
				 }
				 else
				 {
					 if(window.top)
					 {
						 if(window.top==window)
						 {
							 window.location.href='uaclogin6.jsp?<%=SRFExWebContext.FilterQueryString(request.getQueryString())%>';
						 }
						 else
							 window.top.location.reload();
					 }
					 else
					 {
						 window.location.href='uaclogin6.jsp?<%=SRFExWebContext.FilterQueryString(request.getQueryString())%>';
					 }
				 }
		  	}
		});
	</SCRIPT>
</head>
	<body>
	</body>
</html>