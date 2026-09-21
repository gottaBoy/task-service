SRFGridEx = function(config){
        Ext.apply(this, config);
       
        
         /** @private */
	    this.addEvents({
	        "datachanged": true,
	        "columnresize": true,
	        "columnlockchange":true,
	        "columnmoved":true,
	        "hiddenchange":true,
	        "widthchange":true,
	        "rowselectedchange":true,
	        "rowcheckedchange":true
	    });
	    
	   
	    
	    // check and correct shorthanded configs
        if(this.ds){
            this.store = this.ds;
            delete this.ds;
        }
        
        if(!(this.pagesize))
            this.pagesize = 20;
        if(this.pagesize==0)
            this.pagesize = 20;    
            
        
        this.store = Ext.StoreMgr.lookup(this.store);
        this.firstload = false;

        this.Init();
    	
	    SRFGridEx.superclass.constructor.call(this);
    };
    Ext.extend(SRFGridEx, Ext.util.Observable, 
    {	
        setgrid:function(sl2grid)
        {
            if(sl2grid)
            {
                this.grid = sl2grid;
                delete sl2grid;
                this.grid.SetJSDataGridMgr(this);
                if(!this.firstload)
                   this.onLoad();
            }
        },
    	Init:function()
    	{
    	   if(this.store)
    	    {
                this.store.on("load", this.onLoad, this);
                this.store.on("datachanged", this.onDataChange, this);
                this.store.on("add", this.onAdd, this);
                this.store.on("remove", this.onRemove, this);
                this.store.on("update", this.onUpdate, this);
                this.store.on("clear", this.onClear, this);
            }
    	},
    	
    	 // private
        onDataChange : function(){
        //  alert('onDataChange');
        },

        // private
        onClear : function(){
           alert('onClear');
        },

        // private
        onUpdate : function(ds, record){
           alert('onUpdate');
        },

        // private
        onAdd : function(ds, records, index){
          //  this.insertRows(ds, index, index + (records.length-1));
        },

        // private
        onRemove : function(ds, record, index, isUpdate){
           /* if(isUpdate !== true){
                this.fireEvent("beforerowremoved", this, index, record);
            }
            this.removeRow(index);
            if(isUpdate !== true){
                this.processRows(index);
                this.applyEmptyText();
                this.fireEvent("rowremoved", this, index, record);
            }*/
        },

        // private
        onLoad : function()
        {
            if(this.grid)
            {
                this.firstload = true;
               // this.scrollToTop();
               //alert('onload');
                this.grid.Store.IsInformChanged = false;
                this.grid.Store.Clear();
                
                var count = this.store.getCount();
                for(var i =0;i<count;i++)
                {
                    this.grid.Store.Add(this.store.getAt(i));
                }
                
                this.grid.Store.IsInformChanged = true;
                
                this.grid.UpdateContent();
                
                if(this.grid.IsShowPagingBar)
                {
                    if(this.store.lastOptions)
                    {
                        var c = this.store.lastOptions.params.start;
                        var nPageIndex = c/this.pagesize;
                        if(c%this.pagesize!=0)
                            nPageIndex = nPageIndex +1;
                        nPageIndex += 1;
                        this.grid.PagingToolbar.SetPagingInfo(this.store.getTotalCount(),this.pagesize,nPageIndex);
                    }
                }
                
                var state = this.store.getSortState();
		        if(state == undefined || state == null)
		        {
		            this.grid.SetSortParam('',true);
		        }
		        else
		        {
		            if(state.field && state.direction)
		            {
		                var bAsc =   state.direction == 'asc';
		                this.grid.SetSortParam(state.field,bAsc);    
		            }
		            else
		            {
		                this.grid.SetSortParam('',true);
		            }
		        }
            }
        },
        inform:function(_1,_2,_3)
        {
            //alert(_1);
               if(_1 == "columnwidthchanged")
              {
                  this.fireEvent("widthchange", this);
                  return;
              }
             
              if(_1 == "columnposchanged")
              {
                  this.fireEvent("columnmoved", this);
                  return;
              }   
                
              if(_1 == "columnlockedchanged")
              {
                  this.fireEvent("columnlockchange", this);
                  return;
              } 
              
              if(_1 == "columnhiddenchanged")
              {
                  this.fireEvent("hiddenchange", this);
                  return;
              }
              
               if(_1 == "rowselectedchanged")
              {
                //  this.fireEvent("rowselectedchange", this);
                  this.fireEvent("rowselectedchange", this);
                  return;
              }
              
              if(_1 == "rowcheckedchanged")
              {
                  this.fireEvent("rowcheckedchange", this);
                  return;
              }
              
              if(_1 == "columnsortedchanged")
              {
                 this.columnsorted();
                 return;
              }
              
              if(_1 == "gotopage")
              {
                   this.gotopage(_2);
                   return;
              }
        },
        columnsorted:function()
        {
            var si = this.grid.GetSortInfo();
            this.store.sort(si.SortParam,si.SortAsc?"asc":"desc");
        },
        gotopage:function(_1)
        {
            var ps = {params:{start:0,limit:20}};
            ps.params.start = (_1 - 1)*this.pagesize;
            ps.params.limit = this.pagesize;
            this.store.load(ps);
        }
    }	
);

