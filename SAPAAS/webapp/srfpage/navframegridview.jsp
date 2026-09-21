<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFrameGridPage" language="java"%>
<% NavFrameGridPage page1=(NavFrameGridPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFrameGridPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%@include file="../srfpage/inc_gridview.jsp"%>
<script type="text/javascript">

	function selectshowhidesp()
	{ 
		var _C=Ext.getDom('TR_SPEX');
		if(_C.style.display == '')
		{
			_C.style.display='none';  
			return false;
		}
		else
		{
			_C.style.display='';  
			return true;
		}
	}
	
 	 
</script>