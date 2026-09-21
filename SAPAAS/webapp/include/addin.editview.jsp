<%@page contentType="text/html; charset=GBK"%>
<div id="hello-win" class="x-hidden">
    <div class="x-window-header">处理 </div>
    <div id="divform">

    </div>
</div>
<div id="ad" style="position:absolute;width:140px;height:64px;">
</div>
<script type="text/javascript">



function resizeShortbar()
{
	var nWidth = Ext.lib.Dom.getViewWidth(false);
    var nHeight = Ext.lib.Dom.getViewHeight(false);
    
    var fLeft = nWidth-230;
    var fTop = nHeight-100;
    
    
   if(fLeft>0 && fTop>0 )
   {
   	ad.style.left = fLeft;
   	ad.style.top = fTop;
   }
}


function insertTextAreaValue(textObj, textFieldValue) {
    if (document.all) {/*for IE Explorer*/
        if (textObj.createTextRange && textObj.caretPos) {
            var caretPos = textObj.caretPos;
            caretPos.text = caretPos.text.charAt(caretPos.text.length - 1) == '   ' ? textFieldValue + '   ' : textFieldValue;
        } else {
            textObj.value = textObj.value + textFieldValue;
            
        }
    } else {/*for Mozilla based Explorer*/
        if (textObj.setSelectionRange) {
            var rangeStart = textObj.selectionStart;
            var rangeEnd = textObj.selectionEnd;
            var tempStr1 = textObj.value.substring(0, rangeStart);
            var tempStr2 = textObj.value.substring(rangeEnd);
            textObj.value = tempStr1 + textFieldValue + tempStr2;
        } else {
            alert('This   version   of   Mozilla   based   browser   does   not   support  function setSelectionRange');
        }
    } 
}
var win = null;
var formpanel = null;

function showwfactionselwin()
{
	$P.wfaction = '';
	$P.wfmemo = '';
	if(!win)
	{
		var myData = {
		records : [
					{ name : "Record 0", column1 : "0", column2 : "0" },
					{ name : "Record 1", column1 : "1", column2 : "1" },
					{ name : "Record 2", column1 : "2", column2 : "2" },
					{ name : "Record 3", column1 : "3", column2 : "3" },
					{ name : "Record 4", column1 : "4", column2 : "4" },
					{ name : "Record 5", column1 : "5", column2 : "5" },
					{ name : "Record 6", column1 : "6", column2 : "6" },
					{ name : "Record 7", column1 : "7", column2 : "7" },
					{ name : "Record 8", column1 : "8", column2 : "8" },
					{ name : "Record 9", column1 : "9", column2 : "9" }
				]
			};


			// Generic fields array to use in both store defs.
			var fields = [
			   {name: 'name', mapping : 'name'}
			];

		    // create the data store
		    var gridStore = new Ext.data.JsonStore({
		        fields : fields,
				data   : myData,
				root   : 'records'
		    });


			// Column Model shortcut array
			var cols = [
				{ id : 'name', header: "意见", width: 180, sortable: true, dataIndex: 'name'}
			];

			// declare the source Grid
		    var grid = new Ext.grid.GridPanel({
				ddGroup          : 'gridDDGroup',
		        store            : gridStore,
		        columns          : cols,
				enableDragDrop   : true,
		        stripeRows       : true,
		       // autoExpandColumn : 'name',
		        width            : 200,
		        height			 :200,
		        border			:true,
		        hideHeaders 	:true,
		        title			:'常见意见',
		        //frame			:true,
				//region           : 'west',
		        selModel         : new Ext.grid.RowSelectionModel({singleSelect : true})
		    });
			
			var options = $P.wfactions;
			if(options!=null&&options!=undefined){
				for(var i=0;i<options.length;i++){
					var item = options[i];
					item.boxLabel = item.logicname;
					item.name = 'rb-horiz';
					item.inputValue = item.action;
					if(i==0){
						item.checked = true;
					}
				}
			}
				
			
			
		    formpanel = new Ext.FormPanel({
                applyTo: 'divform',
                frame:true,
                bodyStyle:'padding:5px 5px 0',
                width: 600,
                items: [{
                    xtype:'radiogroup',
                    id:'decision',
                    fieldLabel:'选择决策',
                    height:30,
                    anchor:'98%',
                    allowBlank:false,
                    items:options
                },
                {
                    layout:'column',
                    items:[{
                        columnWidth:1,
                        layout: 'form',
                        items: [{
                            xtype:'textarea',
                            id:'memo',
                            fieldLabel:'填写意见',
                            height:200,
                            anchor:'98%',
                            allowBlank:false
                        }]
                    }, grid,{width:10}]
            	}]
            });
		    
		 grid.on('rowdblclick', function(_grid, _rowIndex, e ){
			 
			 //获取内容
			 var record =  _grid.getStore().getAt(_rowIndex);
			 if(record==null)
				 return;
			 var text = record.get('name');

			 var item = formpanel.findById("memo");
			 if(item == null)
				 return;
			 
			 
			 var strValue = item.getValue();
			 if(strValue == null || strValue == undefined)
				 strValue = '';
			 
			 strValue += text;
			 item.setValue(strValue);
		 });
			
		 win = new Ext.Window({
            applyTo:'hello-win',
            layout:'fit',
            width:650,
            height:400,
            closeAction:'hide',
            plain: true,
			modal:true,
            items: formpanel,

            buttons: [{
                text:'确定',
                //disabled:true,
                handler: function(){
                  	
                	
                	//获取值
                	if(!formpanel.getForm().isValid()){
                		
                		var item = formpanel.findById("decision");
                    	var memo = formpanel.findById("memo");
                    	
                 		if(item.getValue()==null||item.getValue()==''){
                			alert('请选择决策');
                			item.focus();
                			return;
                		}
                		
                		
                		if(memo.getValue()==null||memo.getValue()==''){
                			alert('请输入填写意见');
                			memo.focus();
                			return;
                		}
                		
                		return;
                	}
                	
                	var obj = formpanel.getForm().getFieldValues();
                 		
                	//关闭窗口，执行调用
                	$P.wfaction=obj.decision.inputValue;
                	$P.wfmemo = obj.memo.toString();
                		
                 	win.hide();
                	processWF();
                		
                	return;
                	}
                }
            ,{
                text: '关闭',
                handler: function(){
                    win.hide();
                }
            }]
        });
    }
    win.show(this);
}


function saveform()
{
	var maintoolbar = $P.toolbar['<%=page1.GetCtrlUniqueId("Toolbar")%>'];
	var items = maintoolbar.items;
	for(var i =0;i<items.getCount();i++){
		var item = items.get(i);
		if(item.getText==undefined)
			continue;
		
		var text = item.getText();
		if(text == '保存'){
			if(item.disabled)
				return;
			item.handler(item);
		}
	}
}

function processWF()
{
	var maintoolbar = $P.toolbar['<%=page1.GetCtrlUniqueId("Toolbar")%>'];
	var items = maintoolbar.items;
	for(var i =0;i<items.getCount();i++){
		var item = items.get(i);
		if(item.getText==undefined)
			continue;
		
		var text = item.getText();
		if(text == '处理'){
			if(item.disabled)
				return;
			item.handler(item);
		}
	}
}

Ext.onReady(function(){
			Ext.EventManager.onWindowResize(
				function(_1, _2)
				{
					resizeShortbar(); 
				});
			
			
		var maintoolbar = $P.toolbar['<%=page1.GetCtrlUniqueId("Toolbar")%>'];
		
		var tb=new Ext.Toolbar({height:64,renderTo:'ad',items:[
		{height:60,width:60,text:'处理',iconCls:'sx-tb-save',handler:function(_1){processWF();}},
		{height:60,width:60,icon:'../images/icon_down.gif',scale:'huge',handler:function(_1){saveform();}}
		]});
		
		resizeShortbar();
		
		}
	);
</script>