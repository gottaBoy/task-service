<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.ChartFunnelPage" language="java"%>
<% ChartFunnelPage page1=(ChartFunnelPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.ChartFunnelPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%=page1.Render("funnelChart") %> 
<%=page1.Render()%>
<script type="text/javascript">
   
       
     
	function onfunnelclick(_1)
	{   
		var ifr = _IFrame; 
		if(ifr!=null)
		{ 
			<%=page1.GetFunnelClickCode()%>
		}
	}
	
	function layoutctrls()
	{ 
		var nWidth = Ext.lib.Dom.getViewWidth(false); 
		var nHeight = Ext.lib.Dom.getViewHeight(false);  
	 
		var _PE=Ext.getDom('<%=page1.GetCtrlUniqueId("funnelChart")%>').parentElement;
		 
		 
		nInnerHeight=_PE.offsetHeight;
		nInnerWidth=_PE.offsetWidth;
	  
	  	if (nInnerWidth>0)
	  	{ 
			Ext.getDom('<%=page1.GetCtrlUniqueId("funnelChart")%>').width=nInnerWidth;
			Ext.getDom('<%=page1.GetCtrlUniqueId("funnelChart")%>').lastChild.width=nInnerWidth;
			 
		}
		if (nInnerHeight>0)
	  	{ 
			Ext.getDom('<%=page1.GetCtrlUniqueId("funnelChart")%>').height=nInnerHeight;
			Ext.getDom('<%=page1.GetCtrlUniqueId("funnelChart")%>').lastChild.height=nInnerHeight;
		}
		 
	}

    Ext.onReady(function(){
		 Ext.EventManager.onWindowResize(layoutctrls);
		 layoutctrls();
 	});
 
	
</script>  