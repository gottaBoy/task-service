<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.IndexPage" />
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>SA SRFramework DAPlatfom V3.0</title>
<%@include file="/include/commonlib.jsp"%>
<script type="text/javascript" src="../jscript/tabclosemenu.js"></script>
<script type="text/javascript">
	var mditab = null;
	var viewport = null;
	function $g(_1)
	 {
	 	if(mditab == null)
	 		return;
	 	
	 	for(var i=0;i<mditab.items.getCount();i++)
	 	{
	 		var tab2=mditab.items.get(i);
	 		if(tab2 == null)
	 			continue;
	 		if(tab2.satag == _1.src)
	 		{
	 			if(confirm($V(_1.text,'新分页')+'已经在界面中打开，需要回到已打开界面么？'))
	 			{
	 				tab2.show();
	 				return;
	 			}
	 		}
	 	}
	 	var tabid=Ext.id();
	    mditab.add({
	    		id:tabid,
	            title: $V(_1.text,'新分页'),
	            iconCls: 'tabs',
	            satag:_1.src,
	            html: '<iframe id="if_'+tabid+'" name="if_'+tabid +'" src="'+_1.src+'" width="100%" height="100%" SCROLLING="no" frameBorder="0" style="border-style:none;"></iframe> ',
	            closable:true,
	            autoScroll :false
	    }).show();
	    
	    viewport.syncSize();
	 }
    Ext.onReady(function(){
        
       Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
       	
        viewport = new Ext.Viewport({
            layout:'border',
            items:[
            new Ext.BoxComponent({ 
                    region:'north',
                    el: 'north',
                    height:25
                }),{
                    region:'south',
                    contentEl: 'south',
                    height: 20,
                    minSize: 100,
                    maxSize: 200,
                    collapsible: true,
                    margins:'0 0 0 0'
                }, 
                {
                    region:'west',
                    id:'west-panel',
                    title:'快捷区',
                    split:true,
                    width: 200,
                    minSize: 175,
                    maxSize: 400,
                    collapsible: true,
                    margins:'0 0 0 5',
                    layout:'accordion',
                    layoutConfig:{
                        animate:true
                    },
                    items: [{
                        contentEl: 'west',
                        title:'我的任务',
                        border:false,
                        iconCls:'nav'
                    }]
                },
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
        
        
        mditab.on('beforeremove',function(_1,_2){SRFRemoveIframe('if_'+_2.id);});
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     });
     
     Ext.EventManager.on(window, 'unload', function() {
     	for(var i =0;i<mditab.items.getCount();i++)
     	{
     		var id=mditab.items.get(i).id;
     		SRFRemoveIframe('if_'+id);
     	}
     	delete mditab;
     	mditab = null;
     	delete viewport;
     	viewport = null;
     });

	
	</script>
</HEAD>
<body>
<div id="north">
<table width="100%" border="0" height="47" align="left" cellpadding="0" cellspacing="0" >
<!-- 
	<tr>
	    <td  align="left" width='360'>&nbsp;</td >
	    <td>
			<table width="100%"  border="0" height="47" align="right" cellpadding="0" cellspacing="0"> 
				<tr height="5"><td></td></tr>
			  
			  	<tr height="20"><td align='right' class='sx-normaltext'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				<tr ><td >&nbsp;&nbsp;</td></tr>
			</table>
		</td>
 	 </tr> -->
  	<tr >
  		<td colspan='2'>
  			<%=page1.Render("mainMenu") %>
  		</td>
  	</tr>
  	<tr>
	    <td colspan='2' height="1" align="left" bgcolor="#ffffff">
	    </td >
  </tr>
</table>
</div>
<div id="west"></div>
<div id="south">
<!-- 内容区域:结束 -->
<%@include file="/include/bottom.jsp"%>
</div>
</body>
<%=page1.Render()%>
</HTML>
