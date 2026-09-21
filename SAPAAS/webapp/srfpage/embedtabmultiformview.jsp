<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.EmbedTabMultiFormPage" language="java"%>
<% EmbedTabMultiFormPage page1=(EmbedTabMultiFormPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.EmbedTabMultiFormPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title><%=page1.GetPageHeader()%></title>
<%@include file="/include/commonlib.index.jsp"%>
<%=page1.GetPageHeaderContent() %>
<script type="text/javascript" src="../sasrfex/javascript/tabeditform.js"></script>
<script type="text/javascript" src="../jscript/tabclosemenu.js"></script>
</HEAD>
<body >
<%=page1.Render()%>
<script type="text/javascript">
	var mditab = null;
	var viewport=null;
	var tabEditForm = null;
    Ext.onReady(function()
 	{
       viewport = new Ext.Viewport({
            layout:'border',
            items:[
                new Ext.TabPanel({
		        id:'center',
		        deferredRender:false,
		        enableTabScroll:true,
		        defaults: {autoScroll:true},
		        plugins: new Ext.ux.TabCloseMenu(),
		      	region : 'center',
     			margins:'2 2 2 2'
			    })
              ]
        });
        
        mditab = viewport.items.get('center');
        //mditab.on('beforeremove',function(_1,_2){SRFRemoveIframe('if_'+_2.id);});
       tabEditForm = new SRFDA.TabEditForm({tab:mditab,backendurl:'<%=page1.getDefaultBackEndUrl()%>',editurl:'<%=page1.GetEditPath()%>',dataname:'<%=page1.GetDataName()%>',defaultcnt:<%=page1.GetTMFDefaultCnt()%>});

     });
     
     Ext.EventManager.on(window, 'unload', function() {
    	delete mditab;
     	delete viewport; 
     	mditab = null; 
     });



    //外部传入的表单状态
    function setstates(_1)
    {
    	//alert('setstates('+Ext.urlEncode(_1)+')');
    }

    var lastkey='';
    function setsummarykey(_1)
 	{
     	var curkey= Ext.urlEncode(_1);
     	if(lastkey==curkey){return;}
     	lastkey = curkey;
		//alert(lastkey);
        if(tabEditForm)
 		{
 			<%=page1.GetLoadCode()%>
 		}
  	}
	
 	function setsummarykey2(_1)
 	{
 		Ext.onReady(function(){
	 	    if(tabEditForm)
	 	 	{
	 	  		setsummarykey(this);
	 	  	}
	 	 	else
	 	 	{
	 	 		 window.setTimeout("setsummarykey(Ext.urlDecode('"+Ext.urlEncode(this)+"'))",500);
	 	  	}
 	  		},_1);
 	}

 	function savedata(_1)
 	{
 		if(tabEditForm)
 		{
 			lastkey='';
 	 		if(!tabEditForm.remove())
 	 	 		return false;
 	 		if(!tabEditForm.save())
 	 	 		return false;
 	 		return true;
 		}
 	 	return false;
 	}

 	function isdirty()
 	{
 		if(tabEditForm)
 		{ 
 			
 			return tabEditForm.isdirty();
 		}
 	 	return false;
 	}
</script>
</body>
</HTML>