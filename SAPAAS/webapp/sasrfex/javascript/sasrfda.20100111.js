SRFDA.DGACEditor = Ext.extend(Ext.form.ComboBox, {
    lastvalue: '',
    setValue: function(v) {
        this.lastvalue = v;
        var v2 = '';
        if (v) {
            var li = v.split("||SRF||");
            if (li.length == 2) {
                v2 = li[0];
            }
        }
        SRFDA.DGACEditor.superclass.setValue.call(this, v2);
    },
    getValue: function() {
        var v2 = SRFDA.DGACEditor.superclass.getValue.call(this);
        if (v2 == '')
            this.lastvalue = v2;
        return this.lastvalue;
    }
}
);


SRFDA.DGDateEditor = Ext.extend(Ext.form.TriggerField, {
    
}
);

SRFDA.PagingToolbar = Ext.extend(Ext.PagingToolbar, {

    initComponent: function() {
        SRFDA.PagingToolbar.superclass.initComponent.call(this);
        this.on('afterlayout', this.onafterlayout.createDelegate(this));
    },

    onafterlayout: function(ct, obj) {
        if (!this.trSummary) {
            var target = obj.container.getLayoutTarget();
            var tb = target.child('table.x-toolbar-ct', true);
            if (!tb) {
                return;
            }
            var nCellCount = tb.rows[0].cells.length;
            var tr = tb.insertRow(0);
            tr.style.height = $V(this.summaryheight, 30);
            this.trSummary = tr.insertCell(0);
            this.trSummary.colSpan = nCellCount;
            this.trSummary.className = 'sx-dg-summary';
            this.setSummaryInfo('未加载数据表格描述信息！');
        }
    },
    updateInfo: function() {
        SRFDA.PagingToolbar.superclass.updateInfo.call(this);
        try {
            if (this.store.reader.jsonData.summaryinfo) {
                this.setSummaryInfo(this.store.reader.jsonData.summaryinfo);
            }
        } catch (e) {
        }

    },
    setSummaryInfo: function(_info) {
        if (!this.trSummary) {
            return;
        }
        var _total = '<table width="100%" height="100%" style="background-color:#ffffff;"  ><tr><td align="center">' + _info + '</td></tr></table>';
        this.trSummary.innerHTML = _total;
    }
});



SRFDA.DPEx = function(config) {
    if (config) {
        Ext.apply(this, config);
     }
    this.varForm = this.form;
    delete this.form;

    this.varItems = new Ext.util.MixedCollection(false);
    this.varItems.getKey = function(o) { return o.id; };
    this.varItems.addAll(this.items);
    delete this.items;
    this.varTabId = this.tabid;
    delete this.tabid;
    if(this.returnnav)
        this.varKeyMap= Ext.getDoc().addKeyListener(13, this.onreturn.createDelegate(this));
}


Ext.extend(SRFDA.DPEx, Ext.util.Observable,
{
    onreturn: function() {
        var item = document.activeElement;
        if (item == null || item == undefined) { return; }
        var _1 = this.varItems.indexOfKey(item.id);
        if (_1 == -1)
            return;
        var last = this.varItems.itemAt(_1);
        if ($V(last.s, 0) == 1) {
            return;
        }
        for (var i = _1 + 1; i < this.varItems.getCount(); i++) {
            var o = this.varItems.itemAt(i);
            if (this.varForm.isenable(o.pid)) {
                if (last.gid != o.gid) {
                    $P.tabpanel[this.varTabId].activate(o.gid);
                }
                this.varForm.setfocus(o.id);
                break;
            }
        }
    },
    addFormError: function(errorid, msg, flashid) {
        var element = Ext.getDom(errorid);
        if (element != null) {
            var e = Ext.get(element);
            if (!e.isVisible(false)) {
                element.style.display = "";
                e.show(true);
            }

            var html = element.innerHTML;
            if (html != '')
                html += '<BR>';
            if (flashid != '')
                html += '&nbsp;<A href=\"#\" onclick=\"$P.object[\'' + this.varTabId + '\'].flashFormItemError(\'' + flashid + '\')\"><IMG src=\'../sasrfex/images/default/icon_alert_s.gif\' border=\'0\' align=\'absmiddle\' alt=\'' + 'locate the error' + '\'></A>&nbsp;';
            html += ('<SPAN class=\'sx-normaltext-red\'>' + msg + '</SPAN>');
            element.innerHTML = html;
        }
    },
    flashFormItemError: function(errorid) {
        var tabpageid = '';
        if (!this.simplemode) {
            var item = Ext.getDom(errorid);
            if (item == null || item == undefined)
                return;
            var nCount = 50;
            while (nCount > 0 && item != null && item != undefined) {
                nCount--;
                if (item.id.indexOf(this.varTabId + '_') == 0) {
                    tabpageid = item.id;
                    break;
                }
                if (item.id == this.varTabId) { break; }
                item = item.parentNode;
            }
        }
        if (tabpageid != '') {
            $P.tabpanel[this.varTabId].activate(tabpageid);
        }


        var element = Ext.get(errorid);
        if (element != null) {
            element.show(true);
            element.show(true);
            delete element;
        }
    }
    , srfdestroy: function() {
        if (this.varKeyMap) {
            this.varKeyMap.disable();
            if (this.varKeyMap.el) {
                this.varKeyMap.el = null;
            }
            delete this.varKeyMap;
        }
        this.purgeListeners();
        if (this.varForm) {
            delete this.varForm;
        }
        if (this.varItems) {
            this.varItems.clear();
            delete this.varItems;
        }
    }
});



SRFDA.SPEx = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    this.varForm = this.form;
    delete this.form;
    this.varSPId = this.spid;
    delete this.spid;
    if (this.tabid) {
        this.varTabId = this.tabid;
        delete this.tabid;
    }
    else
        this.varTabId = '';

    this.varKeyMap = Ext.getDoc().addKeyListener(13, this.onreturn.createDelegate(this));
}


Ext.extend(SRFDA.SPEx, Ext.util.Observable,
{
    onreturn: function() {
        var item = document.activeElement;
        if (item == null || item == undefined) { return; }
        var nCount = 50;
        var bSearch = false;
        while (nCount > 0 && item != null && item != undefined) {
            nCount--;
            if (item.id == this.varSPId) { bSearch = true; break; }
            item = item.parentNode;
        }
        if (bSearch) { this.varForm.search(); }
    },
    setWidth: function(_1) {
        Ext.getDom(this.varSPId).style.width = _1;
        var _2 = _1 - 60;
        if (_2 < 0)
            _2 = 0;
        if (this.varTabId != '' && $P.tabpanel[this.varTabId]) {
            $P.tabpanel[this.varTabId].setWidth(_2);
        }
    }
   , srfdestroy: function() {
        if (this.varKeyMap) {
            this.varKeyMap.disable();
            if (this.varKeyMap.el) {
                this.varKeyMap.el = null;
            }
            delete this.varKeyMap;
        }
       this.purgeListeners();
       if (this.varForm) {
           delete this.varForm;
       }
   }
});



SRFDA.MaskHelper = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    this.varBody = Ext.getBody();
    this.varMask = null;
    Ext.EventManager.onWindowResize(this.onresize.createDelegate(this));
    if ($P.maskinfo != '') {
        this.maskinfo($P.maskinfo);
    }
}


Ext.extend(SRFDA.MaskHelper, Ext.util.Observable,
{
    onresize: function(_1, _2) {
        if (this.varMask == null)
            return;
        var nWidth = Ext.lib.Dom.getViewWidth(false);
        var nHeight = Ext.lib.Dom.getViewHeight(false);
        this.varMask.setSize(nWidth, nHeight);
    },
    maskprocessing: function(_1) {
        this.unmask();
        this.varMask = this.varBody.mask(_1, 'x-mask-loading');
    },
    maskinfo: function(_1) {
        this.unmask();
        this.varMask = this.varBody.mask(_1);
    },
    mask: function(_1, _2) {
        this.unmask();
        this.varMask = this.varBody.mask(_1, _2);
    },
    unmask: function() {
        if (this.varMask == null)
            return;
        this.varBody.unmask();
        this.varMask = null;
    },
    srfdestroy: function() {

        this.unmask();
        Ext.destroy(this.varBody);
        //this.varBody = null;
        delete this.varBody;
    }
});
Ext.onReady(function() {
if(!$P.nomask)
$P.maskhelper = new SRFDA.MaskHelper();
});





SRFDA.FormAutoFiller = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    if (this.url) {
        this.varURL = this.url;
        delete this.url;
    }
    if (this.afmode) {
        this.varAFMode = this.afmode;
        delete this.afmode;
    }
    if (this.form) {
        this.varForm = this.form;
        delete this.form;
    }
    if (this.afparams) {
        this.varAFParams = this.afparams;
    }
    if (this.afupdates) {
        this.varAFUpdates = this.afupdates;
    }
}


Ext.extend(SRFDA.FormAutoFiller, Ext.util.Observable,
{
    load: function() {
        var _PARAMS = {};
        //填充变量
        var li = this.afparams.split(",");
        for (var i = 0; i < li.length; i++) {
            var param = li[i];
            if (param.length == 0)
                continue;
            var params = param.split("|");
            if (params.length == 1) {
                _PARAMS[params[0].toLowerCase()] = this.varForm.getvalue(params[0]);
            }
            else {
                _PARAMS[params[0].toLowerCase()] = this.varForm.getvalue(params[1]);
            }
        }

        _PARAMS = Ext.apply(_PARAMS, { srfactiontype: 'autofill', srfafmode: this.varAFMode });
        var _CALLBACK =
		{
		    success: this.onloadok.createDelegate(this),
		    failure: this.onloadfailed.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);

        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    onloadok: function(_RO) {
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
            }
            else {

                var li = this.afupdates.split(",");
                for (var i = 0; i < li.length; i++) {
                    var param = li[i];
                    if (param.length == 0)
                        continue;
                    var params = param.split("|");

                    var _V = $V(_JO.items[params[0].toLowerCase()],'');
                    if (params.length == 1) {
                        this.varForm.setvalue(params[0],_V);
                    }
                    else {
                        this.varForm.setvalue(params[1], _V);
                    }
                }
             }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    onloadfailed: function(_1) {
        alert($P.msg['networkerror']);
    }
});
