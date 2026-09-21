<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.IndexPage" />
<% 	page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>SA SRFramework DAPlatform V3.0</title>
<%@include file="/include/commonlib.min.jsp"%>
<script type="text/javascript" src="../jscript/tabclosemenu.js"></script>
<script type="text/javascript" src="../sasrfex/javascript/shortcutbar.js"></script>
<script type="text/javascript">
var mditab = null;
var viewport = null;
var shortcuttree = null;
var shortcutbar = new SRFDA.ShortcutBar();
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
 	var param = $V(_1.srcparam,'');
 	var tabid=Ext.id();
    mditab.add({
    		id:tabid,
            title: $V(_1.text,'新分页'),
            iconCls: 'tabs',
            satag:_1.src,
            html: '<iframe id="if_'+tabid+'" name="if_'+tabid +'" src="'+_1.src+param+'" width="100%" height="100%" SCROLLING="no" frameBorder="0" style="border-style:none;"></iframe> ',
            closable:$V(_1.closable,true),
            autoScroll :false
    }).show();
    $P.iframe['if_'+tabid]='if_'+tabid;
    viewport.syncSize();
 }
</script>
</HEAD>
<body>
<div id="north">
<table width="100%" border="0"  align="left" cellpadding="0" cellspacing="0" >
	<tr height="60">
		<td><IMG src='../images/banner_oa.jpg'></IMG></td>
	</tr>
	<tr>
	    <td height="1" bgcolor="#c40a55"></td >
  	</tr>
  	<tr height="26">
  		<td ><%=page1.Render("mainMenu") %></td>
  	</tr>
  	<tr>
	    <td height="1" bgcolor="#ffffff"></td >
  	</tr>
</table>
</div>
<div id="west"></div>
<div id="south">
<table width="100%" border="0"  align="left" cellpadding="0" cellspacing="0" BACKGROUND="../images/banner_oa_b.jpg" >
	<tr height="20">
		<td align='right'><SPAN class='sx-normaltext'>上海聚微计算机技术有限公司 2009</SPAN></td>
		<td align='right' width='20'></td>
	</tr>
</table>
</div>
</body>
<%=page1.Render()%>
<script type="text/javascript">
	
    Ext.onReady(function(){
        
       Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
       	
       viewport = new Ext.Viewport({
            layout:'border',
            items:[
            new Ext.BoxComponent({ 
                    region:'north',
                    el: 'north',
                    height:88
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
                    title:'边栏',
                    split:true,
                    width: 200,
                    minSize: 175,
                    maxSize: 400,
                    collapsible: true,
                    margins:'2 2 2 5',
                    layout:'accordion',
                    layoutConfig:{
                        animate:true
                    },
                    items: [{
                        id:'shortcutbar',
                        contentEl: 'west',
                        title:'快捷方式',
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

        initshortcuttree();
        
	   	var varTVSideBar = viewport.items.get('west-panel').items.get('shortcutbar');
	   	if(varTVSideBar.isVisible (true))
	   	{
		   	shortcuttree.setWidth(varTVSideBar.getSize().width);
			shortcuttree.getTopToolbar().setWidth(varTVSideBar.getSize().width);
	        shortcuttree.setHeight(varTVSideBar.getSize().height);
	   	}
        varTVSideBar.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
          	if(adjWidth)
          	{
              	shortcuttree.setWidth(adjWidth);
           	}
         	if(adjHeight)
         	{
             	shortcuttree.setHeight((adjHeight-20>0)?adjHeight-20:0);
         	}
         	shortcuttree.syncSize();
       	});
       	
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     	$g({text:'首页',closable:false,tabid:'welcome',src:'../srfpage/portalview.jsp?SRFPPNAME=WELCOME'});

     	$P.object['shortcutbar']=shortcutbar;
     });
     
     Ext.EventManager.on(window, 'unload', function() {
  		shortcuttree = null;
 		shortcutbar = null;
 		mditab = null;
     	viewport = null;  
     });

     function initshortcuttree()
     {
		shortcuttree = shortcutbar.init();
        shortcuttree.render(Ext.get('west'));
	}
</script>
</HTML>
