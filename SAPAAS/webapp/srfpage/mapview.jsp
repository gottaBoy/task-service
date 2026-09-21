<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.MapViewPage" language="java"%>
<% MapViewPage page1=(MapViewPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.MapViewPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<%= page1.Render("TreePanel")%>
<%=page1.Render()%>
<script type="text/javascript">

	function <%=page1.getID()%>ontreeclick(_2)
	{   
		var ifr = _IFrame; 
		 
		if (_2.attributes['id']!=null&&_2.attributes['id']=='root')
		 	_2.attributes['id']='';
		if(ifr!=null)
		{ 
		 	
			<%=page1.GetTreeNodeSelectCode()%>
		}
	}
	  
	function <%=page1.getID()%>layoutctrls(width,height)
	{
		nInnerHeight=height;
		nInnerWidth=width;
	 
		var _PE=$P.tree['<%=page1.GetCtrlUniqueId("treePanel")%>'].container.dom;
		
		if (nInnerHeight==null||nInnerHeight==0) 
		{
			nInnerHeight=Ext.lib.Dom.getViewHeight(false)-25*westpagecnt-10;
			if (location.href.indexOf('navframepic')>=0||location.href.indexOf('navframems')>=0)
				nInnerHeight=nInnerHeight-25;
		}
		if (nInnerHeight==null||nInnerHeight==0)
			nInnerHeight=_PE.offsetHeight;
		if (nInnerWidth==null||nInnerWidth==0)
		{
			nInnerWidth=_PE.offsetWidth;
			if(nInnerWidth==0&&leftbarwidth!=undefined)
			{
				nInnerWidth=leftbarwidth;
			}
		}


		var A=$P.tree['<%=page1.GetCtrlUniqueId("treePanel")%>'];
		var B=<%=page1.GetCtrlUniqueId("treePanel")%>;
		 
	  	if (nInnerWidth>0  )
	  	{
			A.setWidth(nInnerWidth);
			B.style.width=nInnerWidth; 
			LWidth=nInnerWidth;
		}
		else
		{
			A.setWidth(LWidth);
			B.style.width=LWidth; 
		}
		 
		if (nInnerHeight>0  )
	  	{
			A.setHeight(nInnerHeight);
			B.style.height=nInnerHeight; 
			LHeight=nInnerHeight;
		}
		else
		{
			A.setHeight(LHeight);
			B.style.height=LHeight; 
		}
	}
     Ext.onReady(function(){ 
     	 <%=page1.getID()%>layoutctrls();
 	 });
</script>  
