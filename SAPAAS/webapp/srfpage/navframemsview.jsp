<%@page contentType="text/html; charset=GBK"%>
<%@ page import="SA.SRFDA.Web.SRFDAPageProxy" language="java"%>
<%@ page import="SA.SRFDA.Web.Default.NavFrameMSPage" language="java"%>
<% NavFrameMSPage page1=(NavFrameMSPage)SRFDAPageProxy.GetPage(pageContext,"SA.SRFDA.Web.Default.NavFrameMSPage");%>
<% page1.Init(pageContext);	page1.Load(); if(page1.IsStop()) return;%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
<HEAD>
<title>多选界面-<%=page1.OutputPageCaption()%></title>
<%@include file="/include/commonlib.jsp"%>
<LINK href="../sasrfex/css/default/common2.css" type="text/css" rel="stylesheet">
<%=page1.GetPageHeaderContent() %>
</HEAD>
<body >
<div id='west' >  
<%= page1.PANELS%>
</div>
<DIV id='center'>
<%= page1.Render("TabView")%>
</DIV>
<DIV id='east-dv' class="x-toolbar" > 
	<table  width='100%' height='100%'  border='0'   cellspacing='0' cellpadding='0'>
		<tr >
			<td valign='middle'    width="40"> 
				<table     width='100%'  border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td  align="center">
							<%=page1.Render("selectAllButton")%>
						</td>
					</tr>
					<tr>
						<td  align="center">
							<%=page1.Render("selectButton")%>
						</td>
					</tr>
					<tr>
						<td  align="center">
							<%=page1.Render("unselectButton")%>
						</td>
					</tr>
					<tr>
						<td  align="center">
							<%=page1.Render("unselectAllButton")%>
						</td>
					</tr>
				</table>
			</td>
			<td >
				<%=page1.Render("selectDataGrid")%>
			</td>
		</tr>
	</table>
</DIV>
<DIV id='south' align="right" class="x-toolbar">
<table   border='0' width='100%' cellspacing='0' cellpadding='0'   >
				<tr height='20' style='padding:2px;' >
					<td>&nbsp;</td>
					 
					<td  width="120">
						<%= page1.Render("CancelButton")%>	
					</td>
					<td width="120">
						<%= page1.Render("OKButton")%>	
					</td>
				</tr>
			</table>
</DIV>			
<%=page1.Render()%>
<script type="text/javascript">
var MSHelper = {
	srcId:'',
	targetId:'', 
	getGrid:function(_Id){
	 	return $P.grid[_Id];
	},
	getStore:function(_Id){
		return $P.store[_Id];
	}, 
	add:function(_bAll){
		alert(); 
	},		
	remove: function(_bAll){

	},
	getRecordById:function(_store,_Id){ 
		
	}

};

	function layoutleft(width,height)
    {
     	try
     	{
	     	<%=page1.LAYOUTCTRLS%>;
     	}
     	catch(e)
     	{}
    }
    
 	Ext.onReady(function(){
        	 
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[{
                    region:'west',
                    id:'west',
                    split:true,
                    width: 200,
                    minSize: 200,
                    maxSize: 200,
                    collapsible: true,
                    margins:'4 0 4 2',
                     <%if(page1.bCollapsible){%>
                    	layout:'accordion',
                    	hideCollapseTool:true,
                    <%}%>
                    layoutConfig:{
                        animate:true
                    },
                    items: [<%=page1.ITEMS%>]
                },
                new Ext.BoxComponent({
                	id:'center', 
                    region:'center',
                    el: 'center'
                }),
                {
                    region:'south',
                    contentEl: 'south',
                    height: 30,
                    minSize: 100,
                    maxSize: 200,
                    collapsible: false,
                    margins:'0 4 0 2'
                } 
                ,
                {
                	id:'selecteddg', 
                    region:'east',
                    contentEl: 'east-dv',
                    width: 270,
                    minSize: 270,
                    maxSize: 270,
                    collapsible: true,
                    margins:'4 4 4 2'
                } 
              ]
        });
        
		var varCenter = viewport.items.get('center');
		var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
       	varCenter.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
       		 var _TAB = $P.tabview['<%=page1.GetCtrlUniqueId("TabView")%>']._TAB;
       		_TAB.setSize(adjWidth,adjHeight);
       	});
       	_TAB.setSize(varCenter.getSize());
       	
       	var varWest = viewport.items.get('west');
     	varWest.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{    if(adjWidth==undefined || adjWidth== NaN)
           		adjWidth = obj.getWidth();
           	if(adjHeight==undefined || adjHeight== NaN)
           		adjHeight = obj.getHeight();
            if(adjWidth==undefined || adjHeight == undefined)
               	return;
       		layoutleft(adjWidth-2,adjHeight-25*<%=page1.PAGECNT%>);
       		
       		
       	});
       	
      
        var varEast = viewport.items.get('selecteddg');
       	var _SDG = $P.grid['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
        var gridH= varEast.getSize().height-5;
        var gridW= varEast.getSize().width-60;
        if (gridH>=0&&gridW>=0)
		{
	        	 
	        	_SDG.setSize(gridW,gridH);
	        	 <%=page1.GetCtrlUniqueId("selectDataGrid")%>.style.height=gridH;
	        	 <%=page1.GetCtrlUniqueId("selectDataGrid")%>.style.width=gridW;
	         
		} 
      	varEast.on('resize',function(obj, adjWidth, adjHeight,  rawWidth,  rawHeight)
       	{
       		
        	var _SDG = $P.grid['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
        	if (adjWidth-60>=0&&adjHeight-5>=0)
      		{	 
      			 
         		_SDG.setSize(adjWidth-60,adjHeight-5);
         		<%=page1.GetCtrlUniqueId("selectDataGrid")%>.style.height=adjHeight-5;
	        	 <%=page1.GetCtrlUniqueId("selectDataGrid")%>.style.width=adjWidth-60;
         		 
         	 
      		}
       	});
     
	     
        
        Ext.EventManager.onWindowResize(function(){this.syncSize();},viewport);
     });
       
       
        var westpagecnt=<%=page1.PAGECNT%>;
        var leftbarwidth=200;
        
        
      var _SELECTROW={};
     function selectvalue()
     {
     	$P.button['<%=page1.GetCtrlUniqueId("OkButton")%>'].fireEvent('click');
     }
     
   	 var strKeyName = '<%=page1.GetKeyName()%>';
   	  var strTextName = '<%=page1.GetTextName()%>';
   	 var _TOTALGRID=null;
   	 var _TOTALSTORE=null;
   	 var _IFrame;
   	 var varEXFlag=<%=page1.GetExFlag()%>;
   	 var items = new Ext.util.MixedCollection(false);
   	  var texts = new Ext.util.MixedCollection(false);
  	 var bRegisteredBeforeLoad = false;  
    
	 function totalstoreloaded(_1,_2,_3)
     { 
		var targetStore = $P.store['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
		 //targetStore.removeAll(); 
		registerBeforeLoad();   
		if(items.getCount()==0){
			return ;
		}  
		var arrReomve = new Array();
     	for(var i = 0;i<_1.getCount();i++){
   			var keyid = _1.getAt(i).get(strKeyName);
   			if(items.contains(keyid) && varEXFlag){
   				arrReomve.push(_1.getAt(i));
   			}	  
    	}
    	for(var i=0;i<arrReomve.length;i++){
    		_1.remove(arrReomve[i]);
        } 
    }
	function registerBeforeLoad(){
		_TOTALSTORE.on('beforeload',function(){return onBeforeLoad();});
	}
    function onBeforeLoad(){ 
        if(SRFUtility.isNull(_TOTALGRID)){
        	return true; 
        } 
    	var totalGrid =  _TOTALGRID;   
    	var totalStore =  _TOTALSTORE; 
    	var sm = totalGrid.gridmgr.getcheckedrowscollection(); 
    	if(sm == null || sm.length == 0){
    		
        }else{  
        	addselect('beforeload');
        }
      
		return true;
    } 
    function cancelCheckRow()
    {
		
    }
    function addselect(_1){ 
    	var srcGrid =  _TOTALGRID;  
    	var srcStore =  _TOTALSTORE;  
    	var strTargetStoreId = '<%=page1.GetCtrlUniqueId("selectDataGrid")%>';
    	var targetStore = $P.store[strTargetStoreId];
    	var sm = srcGrid.gridmgr.getcheckedrowscollection(); 
    	if(sm == null || sm.length ==0 ) 
    		return ;   
    	for(var i = 0;i<sm.length;i++){ 
        	var record = sm[i];
   			var strKeyValue = record.get(strKeyName);
   			var strTextValue = record.get(strTextName);
   			if(items.contains(strKeyValue)){    
				continue;  
   	   		} 
 			items.insert(items.getCount(),strKeyValue.toUpperCase());
 			texts.insert(items.getCount(),strTextValue.toUpperCase());
 			targetStore.insert(targetStore.getCount(),record);   
 			srcGrid.getSelectionModel().clearSelections();    
   		} 
   		if(_1 != 'beforeload')    
   			srcStore.reload();   
    }
    function contains(_store,_value){
    	for(var i=0;i<_store.length;i++){
			var _record = _store.getAt(i); 
			if(_record.get('KEYS')==_value)
			{
				return true;
			}
        } 
        return false;
    }

    function removeselect(){
    	var totalStore = _TOTALSTORE; 
    	var selectGrid = $P.grid['<%=page1.GetCtrlUniqueId("selectDataGrid")%>'];
    	var strTargetStoreId = '<%=page1.GetCtrlUniqueId("selectDataGrid")%>';
    	var targetStore = $P.store[strTargetStoreId];
     	var sm = selectGrid.getSelectionModel().getSelections();
    	if(sm == null || sm.length ==0) 
    		return ;
    	
    	for(var i = 0;i<sm.length;i++){
     		items.remove(sm[i].get(strKeyName).toUpperCase());
     		texts.remove(sm[i].get(strTextName).toUpperCase());
     		targetStore.remove(sm[i]);  
     		//selectGrid.removeAt(selectGrid.getIndexOf(sm[i]));    
   		}   
   		totalStore.reload();   
    }  
    
    function addall(){
    	var totalStore = _TOTALSTORE; 
    	var strTargetStoreId = '<%=page1.GetCtrlUniqueId("selectDataGrid")%>'; 
    	var targetStore = $P.store[strTargetStoreId];
      	for(var i = 0;i<totalStore.getCount();i++){
   			var keyid = totalStore.getAt(i).get(strKeyName);
   				
   			if(!items.contains(keyid)){ 
   				items.insert(items.getCount(),totalStore.getAt(i).get(strKeyName).toUpperCase());
   				texts.insert(items.getCount(),totalStore.getAt(i).get(strTextName).toUpperCase());
   				targetStore.insert(targetStore.getCount(),totalStore.getAt(i));    
   			}	
   		}
   		totalStore.reload();
    }
    
    function removeall(){
    	var totalStore = _TOTALSTORE;
    	var strTargetStoreId = '<%=page1.GetCtrlUniqueId("selectDataGrid")%>';
    	var targetStore = $P.store[strTargetStoreId];
    	items.clear();  
    	texts.clear();
    	targetStore.removeAll();   
    	totalStore.reload();
     }
     
     
    
  	 
     
</script>
</body>
</HTML>