SRFSearchBar = function(config){
    Ext.apply(this, config);
   
     /** @private */
	this.addEvents({
	    "datachanged" : true
	});
	
	this._STPARAMS = this.stparams;
	this._STURL = this.sturl;
	this._TIMEOUT = this.timeout||30000;
	this._SPID = this.spid;
	this._ID = this.id;
	this._NAMETEXTBOX = this.nametb ;
	
	if(this.sf!=undefined && this.sf!=null)
	{ 
		 this._SF = this.sf; 
		 delete this.sf;
	} 
	
	if(this.stlistid!=undefined && this.stlistid!= '' && this.stlistid!= null)
	{
			this._STLISTID = this.stlistid;
			Ext.get(this._STLISTID).on('change',this.onstlistchanged.createDelegate(this));
	}
	
	if(this.refreshbtn!=undefined && this.refreshbtn!= '' && this.refreshbtn!= null)
	{
			this._REFRESHBTN = exPage.button[this.refreshbtn];
			this._REFRESHBTN.on('click',this.onrefreshbtnclick.createDelegate(this));
	}
	
	if(this.searchbtn!=undefined && this.searchbtn!= '' && this.searchbtn!= null)
	{
			this._SEARCHBTN = exPage.button[this.searchbtn];
			this._SEARCHBTN.on('click',this.onsearchbtnclick.createDelegate(this));
	}
	
	if(this.savebtn!=undefined && this.savebtn!= '' && this.savebtn!= null)
	{
			this._SAVEBTN = exPage.button[this.savebtn];
			this._SAVEBTN.on('click',this.onsavebtnclick.createDelegate(this));
	}
	
	if(this.cancelbtn!=undefined && this.cancelbtn!= '' && this.cancelbtn!= null)
	{
			this._CANCELBTN = exPage.button[this.cancelbtn];
			this._CANCELBTN.on('click',this.oncancelbtnclick.createDelegate(this));
	}
	
	if(this.okbtn!=undefined && this.okbtn!= '' && this.okbtn!= null)
	{
			this._OKBTN = exPage.button[this.okbtn];
			this._OKBTN.on('click',this.onokbtnclick.createDelegate(this));
	} 
	
	if(this.removebtn!=undefined && this.removebtn!= '' && this.removebtn!= null)
	{
			this._REMOVEBTN = exPage.button[this.removebtn];
			this._REMOVEBTN.on('click',this.onremovebtnclick.createDelegate(this));
	} 

	if(this.resetbtn!=undefined && this.resetbtn!= '' && this.resetbtn!= null)
	{
			this._RESETBTN = exPage.button[this.resetbtn];
			this._RESETBTN.on('click',this.onresetbtnclick.createDelegate(this));
    }

    if (this.expandimg != undefined && this.expandimg != '' && this.expandimg != null) {
        this._EXPANDIMG = this.expandimg;
    }
	
	if (this.collapseimg != undefined && this.collapseimg != '' && this.collapseimg != null) {
	    this._COLLAPSEIMG = this.collapseimg;
	}
	if (this.spitem != undefined && this.spitem != '' && this.spitem != null) {
	    this._SPITEM = this.spitem;
	}
	
	SRFSearchBar.superclass.constructor.call(this);
};
Ext.extend(SRFSearchBar, Ext.util.Observable,
{
    showview: function(_1) {
        Ext.getDom(this._ID + '_1').style.display = ((_1 == 1) ? "" : "none");
        Ext.getDom(this._ID + '_2').style.display = ((_1 == 2) ? "" : "none");
    },
    onresetbtnclick: function(_1, _2) {
        this._SF.reset();
    },
    onremovebtnclick: function(_1, _2) {
        if (!confirm('缺省要删除选定的搜索主题么？数据将不可恢复！'))
            return;
        var _ELEMENT = Ext.getDom(this._STLISTID);
        var _TEMPID = _ELEMENT.value;
        if (_TEMPID == undefined || _TEMPID == null || _TEMPID == '')
            return;
        var _PARAMS = this._STPARAMS || {};
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'stlist', action: 'remove', searchthemeid: _TEMPID, comboBoxid: this._STLISTID });
        var _CALLBACK =
			{
			    success: this.onremovestlistok.createDelegate(this),
			    failure: this.onajaxfailed.createDelegate(this),
			    timeout: this._TIMEOUT
			};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        Ext.lib.Ajax.request('post', this._STURL, _CALLBACK, _POSTDATA);
    },
    onremovestlistok: function(_1) {
        if (_1.responseText != undefined && _1.responseText != null && _1.responseText != '') {
            var _JO = eval("(" + _1.responseText + ")");
            if (_JO == undefined || _JO == null || _JO.ret == undefined) {
                this.onajaxfailed(_1);
            }
            else {
                if (_JO.ret == 0) {
                    this.refreshlist();
                }
                else {
                    alert(_JO.info);
                }
            }
        }
    },
    onsavebtnclick: function(_1, _2) {
        var element = Ext.getDom(this._STLISTID);
        var stid = '';
        if (element.selectedIndex != -1) {
            stid = element.value;
        }

        if (stid == null || stid == '') {
            this.showview(2);
        }
        else {
            this._SF.savecondition(stid, element.options[element.selectedIndex].text, this.onsaveconditioncb.createDelegate(this));
        }
    },
    onsaveconditioncb: function(_1, _2, _3) {
        if (_2) {
            this.showview(1);
            this.refreshlist();
        }
    },
    onokbtnclick: function(_1, _2) {
        var varText = Ext.getDom(this._NAMETEXTBOX).value;
        if (varText == '') {
            alert('请输入搜索主题的名称!');
            Ext.get(this._NAMETEXTBOX).focus();
            return;
        }
        this._SF.savecondition('', varText, this.onsaveconditioncb.createDelegate(this));
    },
    oncancelbtnclick: function(_1, _2) {
        this.showview(1);
    },
    onstlistchanged: function() {
        this.loadcondition();
    },
    loadcondition: function() {
        if (this._SF != undefined && this._SF != null) {
            var element = Ext.getDom(this._STLISTID);
            var stid = '';
            if (element.selectedIndex != -1) {
                stid = element.value;
            }
            if (stid == '')
                this._REMOVEBTN.hide();
            else {
                if(Ext.getDom(this._SPITEM).style.display!='none')
                this._REMOVEBTN.show();
            }
            this._SF.loadcondition(this._SPID, stid);
        }
    },
    showsp: function(bShow) {
        if (bShow) {
            Ext.getDom(this._EXPANDIMG).style.display = 'none';
            Ext.getDom(this._COLLAPSEIMG).style.display = '';

            this._REFRESHBTN.show();
            this._SEARCHBTN.show();
            this._SAVEBTN.show();
            this._RESETBTN.show();
            var element = Ext.getDom(this._STLISTID);
            var stid = '';
            if (element.selectedIndex != -1) {
                stid = element.value;
            }
            if (stid == '')
                this._REMOVEBTN.hide();
            else
                this._REMOVEBTN.show();
        }
        else {
            Ext.getDom(this._COLLAPSEIMG).style.display = 'none';
            Ext.getDom(this._EXPANDIMG).style.display = '';
            this._REFRESHBTN.hide();
            this._SEARCHBTN.hide();
            this._SAVEBTN.hide();
            this._REMOVEBTN.hide();
            this._RESETBTN.hide();
        }
        Ext.getDom(this._SPITEM).style.display = bShow ? '' : 'none';
    },
    onsearchbtnclick: function(_1, _2) {
        if (this._SF != undefined && this._SF != null) {
            this._SF.search();
        }
    },
    refreshlist: function() {
        var _PARAMS = this._STPARAMS || {};
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'stlist', action: 'refresh', comboBoxid: this._STLISTID });

        var _CALLBACK =
		{
		    success: this.onloadstlistok.createDelegate(this),
		    failure: this.onajaxfailed.createDelegate(this),
		    timeout: this._TIMEOUT
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        Ext.lib.Ajax.request('post', this._STURL, _CALLBACK, _POSTDATA);
    }
	,
    onrefreshbtnclick: function(_1, _2) {
        this.refreshlist();
    },
    onloadstlistok: function(_1) {
        if (_1.responseText != undefined && _1.responseText != null && _1.responseText != '') {
            var _JO = eval("(" + _1.responseText + ")");
            if (_JO == undefined || _JO == null || _JO.ret == undefined) {
                this.onajaxfailed(_1);
            }
            else {
                var lastvalue;
                var _ELEMENT = Ext.getDom(this._STLISTID);
                if (_ELEMENT.selectedIndex != -1) {
                    lastvalue = _ELEMENT.value;
                }
                while (_ELEMENT.options.length > 0) {
                    _ELEMENT.options.remove(0);
                }

                for (var i = 0; i < _JO.items.length; i++) {
                    var oOption = document.createElement("OPTION");
                    _ELEMENT.options.add(oOption);
                    oOption.innerText = _JO.items[i].text;
                    oOption.value = _JO.items[i].value;
                    if (lastvalue != undefined) {
                        if (lastvalue == oOption.value)
                            oOption.selected = true;
                    }
                }
                if (_ELEMENT.value != lastvalue) {
                    this.loadcondition();
                }
                SRFAjaxResultHelper.process(_JO);
            }
        }
    },
    onajaxfailed: function(_1) {
        alert('无法连接到服务器!');
    }
}
);

