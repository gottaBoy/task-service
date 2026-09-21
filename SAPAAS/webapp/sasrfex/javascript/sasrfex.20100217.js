Ext.BLANK_IMAGE_URL = '../resources/images/default/s.gif';
var exPage = {iframe:{},navigatebar: null, form: {}, button: {}, picker: {}, searchbar: {}, grid: {}, store: {}, tree: {}, tabview: {}, remotepanel: {}, remotetabpage: {}, tabpanel: {}, autocomplete: {}, shortcutbar: {}, link: {}, func: {}, param: {}, update: {}, htmleditor: {}, grideditor: {}, gridrender: {}, msg: {}, toolbar: {}, el: {}, sp: {}, mainform: null, maingrid: null, object: {}, mainformstate: null, mainview: null, maskhelper: null, maskinfo: '', nomask: false, html: {} };
var $P = exPage;
$P.AC = $P.autocomplete;
var SRFDA = {};
var SRFDEBUG =
{
	show:function(message)
	{
		var _OUTPUT = Ext.getDom('_DEBUG');
		if(_OUTPUT == null)
			return;
		_OUTPUT.value += message;
	}
};

$P.setpagedata = function(message) {
    var _1 = Ext.getDom('BAR_DATA');
    if (_1) {
        _1.innerHTML = message;
    }
};

$P.setpageinfo = function(message) {
    var _1 = Ext.getDom('BAR_INFO');
    if (_1) {
        _1.innerHTML = message;
        if (message == '')
            Ext.get(_1).hide(true);
         else
             Ext.get(_1).show(true);
    }
};

var SRFForm =
{
    setValue: function(itemid, value) {
        var element = Ext.getDom(itemid);
        if (element != null)
            element.value = value;
        if (exPage.autocomplete[itemid])
            exPage.autocomplete[itemid].lastvalue = value;
    },
    getValue: function(itemid) {
        var element = Ext.getDom(itemid);
        if (element != null)
            return element.value;
        return '';
    },
    setValue2: function(itemid, value) {
        var element = Ext.getDom(itemid);
        if (element != null) {
            element.innerHTML = value;
        }
    },
    getValue2: function(itemid) {
        var element = Ext.getDom(itemid);
        if (element != null)
            return element.innerHTML;
        return '';
    },
    setDTValue: function(itemid, itemid2, itemid3, itemid4, value) {
        var el = Ext.getDom(itemid);
        if (el != null)
            el.value = '';
        var el2 = Ext.getDom(itemid2);
        if (el2 != null)
            el2.value = '00';
        var el3 = Ext.getDom(itemid3);
        if (el3 != null)
            el3.value = '00';
        var el4 = Ext.getDom(itemid4);
        if (el4 != null)
            el4.value = '00';
        if (value == undefined || value == null || value == '') {
            return;
        }
        else {
            var _L = value.split(' ');
            if (_L.length >= 1) {
                if (el != null)
                    el.value = _L[0];
            }
            if (_L.length >= 2) {
                value = _L[1];
                var _L2 = value.split(':');
                if (_L2.length >= 1) {
                    if (el2 != null)
                        el2.value = _L2[0];
                }
                if (_L2.length >= 2) {
                    if (el3 != null)
                        el3.value = _L2[1];
                }
                if (_L2.length >= 3) {
                    if (el4 != null)
                        el4.value = _L2[2];
                }
            }
        }
    },
    setDTValueNow: function(itemid, itemid2, itemid3, itemid4) {
        var myDate = new Date();
        var value = '';
        value += myDate.getFullYear().toString();
        value += "-";
        if ((myDate.getMonth() + 1).toString().length < 2) {
            value += '0' + (myDate.getMonth() + 1).toString();
        } else {
            value += (myDate.getMonth() + 1).toString();
        }

        value += "-";

        if ((myDate.getDate() + 1).toString().length < 2) {
            value += '0' + myDate.getDate().toString();
        } else {
            value += myDate.getDate().toString();
        }

        value += ' ';
        value += myDate.toLocaleTimeString();
        SRFForm.setDTValue(itemid, itemid2, itemid3, itemid4, value);
    },

    getDTValue: function(itemid, itemid2, itemid3, itemid4) {
        var _V = '';
        var el = Ext.getDom(itemid);
        if (el != null)
            _V += el.value;
        if (_V != '')
            _V += ' ';
        var el2 = Ext.getDom(itemid2);
        if (el2 != null) {
            _V += el2.value;
        }
        else {
            if (_V == '')
                return '';
            _V += '00';
        }
        _V += ':';
        var el3 = Ext.getDom(itemid3);
        if (el3 != null) {
            _V += el3.value;
        }
        else
            _V += '00';

        _V += ':';
        var el4 = Ext.getDom(itemid4);
        if (el4 != null) {
            _V += el4.value;
        }
        else
            _V += '00';
        if (_V == '00:00:00')
            return '';
        return _V;
    },
    getCheckValue: function(itemid) {
        var element = Ext.getDom(itemid);
        if (element != null) {
            if (element.checked)
                return element.value;
        }
        return '';
    },
    setCheckValue: function(itemid, value) {
        var element = Ext.getDom(itemid);
        if (element != null) {
            if (element.value == value) {
                element.checked = true;
                return;
            }
            else {
                if (element.checked)
                    element.checked = false;
            }
        }
    },
    setRadioListValue: function(items, value) {
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null) {
                if (element.value == value) {
                    element.checked = true;
                    return;
                }
                else {
                    if (element.checked)
                        element.checked = false;
                }
            }
        }
    },
    getRadioListValue: function(items) {
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null)
                if (element.checked == true) {
                return element.value;
            }
        }
        return '';
    },
    setCheckListValue: function(items, value, separator) {
        var checked = false;
        var values = [];
        if (value != '')
            values = value.split(separator);
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null) {
                checked = false;
                for (var j = 0; j < values.length; j++) {
                    if (element.value == values[j]) {
                        checked = true;
                        break;
                    }
                }
                element.checked = checked;
            }
        }
    },
    setCheckListValue2: function(items, value) {
        var checked = false;
        var values = new Array();
        if (value != '') {
            var _1 = parseInt(value);
            if (_1 != NaN) {
                var _T = 1;
                while (_1 >= _T) {
                    if ((_1 & _T) > 0) {
                        values.push(_T.toString());
                    }
                    _T = _T * 2;
                }
            }
        }

        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null) {
                checked = false;
                for (var j = 0; j < values.length; j++) {
                    if (element.value == values[j]) {
                        checked = true;
                        break;
                    }
                }
                element.checked = checked;
            }
        }
    },
    getCheckListValue: function(items, separator) {
        var _V = '';
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null)
                if (element.checked) {
                if (_V != '')
                    _V += separator;
                _V += element.value;
            }
        }
        return _V;
    },
    getCheckListValue2: function(items) {
        var _V = 0;
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null)
                if (element.checked) {
                _V = _V | parseInt(element.value);
            }
        }
        if (_V == 0)
            return '';
        else
            return _V.toString();
    },
    setListBoxValue: function(itemid, value, separator) {
        var selected = false;
        var element = Ext.getDom(itemid);
        var values = [];
        if (value != '')
            values = value.split(separator);
        for (var i = 0; i < element.options.length; i++) {
            var opt = element.options[i];
            selected = false;
            for (var j = 0; j < values.length; j++) {
                if (opt.value == values[j]) {
                    selected = true;
                    break;
                }
            }
            opt.selected = selected;
        }
    },
    getListBoxValue: function(itemid, separator) {
        var _V = '';
        var element = Ext.getDom(itemid);
        for (var i = 0; i < element.options.length; i++) {
            var opt = element.options[i];
            if (opt.selected) {
                if (_V != '')
                    _V += separator;
                _V += opt.value;
            }
        }
        return _V;
    },
    getListBoxValue2: function(itemid, separator) {
        var _V = '';
        var element = Ext.getDom(itemid);
        for (var i = 0; i < element.options.length; i++) {
            var opt = element.options[i];
            if (_V != '')
                _V += separator;
            _V += opt.value;
        }
        return _V;
    },
    setListBoxPickupValue: function(itemid, strXML, separator) {
        if (SRFUtility.isNull(strXML))
            return;
        var xmlDoc = SRFUtility.parseXML(strXML);
        if (SRFUtility.isNull(xmlDoc)) {
            return; 
        }  
        var element = Ext.getDom(itemid);
        if(SRFUtility.isNull(element)){
        	return;
        }
        for (var i = 0; i < xmlDoc.childNodes.length; i++) {
            if (xmlDoc.childNodes[i].nodeName != 'SRFEXCODELIST') {
            	continue;
            }
            var codelistNode = xmlDoc.childNodes[i];
            for (var j = 0; j < codelistNode.childNodes.length; j++) {
                var codelistItemNode = codelistNode.childNodes[j];
                var codelistItemAtrributes =  codelistItemNode.attributes;
                var optValue = '';
               	var optText = '';
                for(var k = 0;k < codelistItemAtrributes.length; k++){
                	if(codelistItemAtrributes.item(k).name=='VALUE'){
                		optValue = codelistItemAtrributes.item(k).value;
                	}
                	if(codelistItemAtrributes.item(k).name=='TEXT'){
                		optText = codelistItemAtrributes.item(k).value;
                	}
                } 
                /****Append Options***/
                for (var i = 0; i < element.options.length; i++) {
			            var opt = element.options[i];
			            if (opt.text == optText && opt.value == optValue) {
			                return;
			            }
			        }
		        var oOption = document.createElement("OPTION");
		        oOption.text = optText;
		        oOption.value = optValue;
		        element.options.add(oOption);
            } 
        } 
    },
    getListBoxPickupValue: function(itemid,separator) {
    	var element = Ext.getDom(itemid);
        var nCnt = element.options.length;
        if(nCnt==0){
        	return '';
        } 
        var strXMLPrefix = '<?xml version="1.0" encoding="utf-8" ?>';
        var XML = new XMLWriter();
        XML.BeginNode('SRFEXCODELIST');
        XML.Attrib("VALUESEPARATOR",separator); 
        for (var i = 0; i < nCnt; i++) {
            var opt = element.options[i];
            XML.BeginNode('SRFEXCODEITEM');
            XML.Attrib("VALUE", opt.value);
            XML.Attrib("TEXT", opt.text);
            XML.EndNode();
        }
        XML.EndNode();
        XML.Close();
        return strXMLPrefix + XML.ToString();
    },
    resetFormError: function(errorid) {
        var element = Ext.getDom(errorid);
        if (element != null) {
            var e = Ext.get(element);
            if (e.isVisible(false)) {
                //e.hide(true);
                element.style.display = "none";
            }
            element.innerHTML = '';
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
                html += '&nbsp;<A href=\"javascript:SRFForm.flashFormItemError(\'' + flashid + '\')\"><IMG src=\'../sasrfex/images/default/icon_alert_s.gif\' border=\'0\' align=\'absmiddle\' alt=\'' + 'locate the error' + '\'></A>&nbsp;';
            html += ('<SPAN class=\'sx-normaltext-red\'>' + msg + '</SPAN>');
            element.innerHTML = html;
        }
    },
    showFormItemError: function(errorid, msg) {
        var element = Ext.getDom(errorid);
        if (element != null) {
            if (msg != null && msg != '') {
                Ext.get(element).show();
                element.innerHTML = '<IMG src=\'../sasrfex/images/default/icon_alert_s2.gif\' border=\'0\' alt=\'' + msg + '\'>';
            }
            else {
                element.innerHTML = '';
                Ext.get(element).hide();
            }
        }
    },
    flashFormItemError: function(errorid) {
        var element = Ext.get(errorid);
        if (element != null) {
            element.show(true);
        }
    },
    enableFormItem: function(itemid, state) {
        var item = Ext.getDom(itemid);
        if (item == null || item == undefined)
            return;
        item.readOnly = !state;
        if (!state)
            Ext.get(itemid).addClass("sx-ctrl-readonly");
        else
            Ext.get(itemid).removeClass("sx-ctrl-readonly");
    },
    enableFormItem2: function(itemid, state) {
        if (state)
            Ext.getDom(itemid).style.visibility = 'visible';
        else
            Ext.getDom(itemid).style.visibility = 'hidden';
    },
    enableFormItem3: function(itemid, state) {
        Ext.getDom(itemid).disabled = !state;
        if (!state)
            Ext.get(itemid).addClass("sx-ctrl-readonly");
        else
            Ext.get(itemid).removeClass("sx-ctrl-readonly");
    },
    enableFormItems: function(items, state) {
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null) {
                if (element.type == 'text')
                    element.readOnly = !state;
                else
                    element.disabled = !state;
                if (!state)
                    Ext.get(element).addClass("sx-ctrl-readonly");
                else
                    Ext.get(element).removeClass("sx-ctrl-readonly");
            }
        }
    },
    enableFormItems2: function(items, state) {
        for (var i = 0; i < items.length; i++) {
            var element = Ext.getDom(items[i]);
            if (element != null) {
                element.readOnly = !state;
            }
        }
    },
    addListBoxValue: function(itemid, text, value) {
        var element = Ext.getDom(itemid);
        for (var i = 0; i < element.options.length; i++) {
            var opt = element.options[i];
            if (opt.text == text && opt.value == value) {
                return;
            }
        }
        var oOption = document.createElement("OPTION");
        oOption.text = text;
        oOption.value = value;
        element.options.add(oOption);
    },
    removeListBoxValue: function(itemid) {
        var element = Ext.getDom(itemid);
        var _1 = true;
        while (_1) {
            _1 = false;
            for (var i = 0; i < element.options.length; i++) {
                var opt = element.options[i];
                if (opt.selected) {
                    _1 = true;
                    element.remove(i);
                    break;
                }
            }
        }

    },
    showFormItemErrorEx: function(errorid, msg) {
        if (errorid == '')
            return;
        var element = Ext.get(errorid);
        if (element != null) {
            if (msg != null && msg != '') {
                element.addClass('sx-dp-err');
                element.title = msg;
            }
            else {
                element.removeClass('sx-dp-err');
                element.title = '';
            }
        }
    },
    getFileUploaderValue: function(o) {
        if (o == null || o == undefined)
            return '';
        var XML = new XMLWriter();
        if (o.getCount() == 0)
            return '';
        XML.BeginNode('FILELIST');
        for (i = 0; i < o.getCount(); i++) {
            var rd = o.itemAt(i);
            XML.BeginNode('FILE');
            XML.Attrib("FILEID", rd.fileid);
            XML.Attrib("FILENAME", rd.filename);
            XML.EndNode();
        }
        XML.EndNode();
        XML.Close();
        return '<?xml version="1.0" encoding="utf-8" ?>' + XML.ToString();
    },
    setFileUploaderValue: function(strXML, items) {
        if (strXML == null || strXML == undefined)
            return '';

        var xmlDoc = SRFUtility.parseXML(strXML);
        if (xmlDoc == null) {
            return;
        }
        for (var i = 0; i < xmlDoc.childNodes.length; i++) {
            if (xmlDoc.childNodes[i].nodeName == 'FILELIST') {
                var xmlNode = xmlDoc.childNodes[i];
                for (var j = 0; j < xmlNode.childNodes.length; j++) {
                    var o = {};
                    SRFUtility.loadXMLNode(xmlNode.childNodes[j], o);
                    items.insert(items.getCount(), o);
                }
                break;
            }
        }
    },
    setFocus: function(itemid) {
        try {
            var element = Ext.getDom(itemid);
            if (element != null) {
                if (element.tagName == 'hidden')
                    return;
                if (element.style.display == 'none')
                    return;
                element.focus();
            }
        } catch (e) { }
    }
}


$P.msg['networkerror'] = '向服务器发送处理请求出现故障，请确认您的网络连接是否正常！';
$P.msg['1'] = "系统内部发生错误";
$P.msg['2'] = "访问被拒绝，可能由于权限原因导致";
$P.msg['3'] = "数据不存在";
$P.msg['4'] = "数据的索引条件有误或不足";
$P.msg['5'] = "数据的信息有误或不足";
$P.msg['6'] = "重复的数据键";
$P.msg['20'] = "没有实现指定功能";
$P.msg.fmt = function(_1, _2) { return '系统处理失败，原因是：' + _1 + '。详细信息:' + _2; };
$P.msg.fmt2 = function(_1) { return '已经注册了返回值[' + _1 + ']，但没有处理，请向管理员联系确认！'; };
/*表格相关消息*/
$P.msg['dgnotload'] = '<SPAN class=\'sx-normaltext\'>数据表格数据还未加载，请点击【搜索】按钮加载您需要的数据。</SPAN>';
$P.msg['dgnorecord'] = '<SPAN class=\'sx-normaltext\'>没有找到符合您要求的数据。</SPAN>';

$P.msg['dgrowunsave'] = '表格中还有未保存的的数据，取消行编辑模式将丢失这些数据，确实要继续么？';
$P.msg['dgrowunsave2'] = '表格中还有未保存的的数据，重新载入表格数据将丢失这些数据，确实要继续么？';
$P.msg['dgexport'] = '选择确定导出当前分页数据，选择取消导出符合条件但最多不超过1000条记录？';
$P.msg.dgexportfmt =function(_1) {return  '选择确定导出当前分页数据，选择取消导出符合条件但最多不超过'+_1+'条记录？';};
$P.msg.dgexportfmt2 = function(_1) { return '选择确定继续上一次导出，从第' + _1 + '行开始，选择取消从第一行记录开始？'; };
$P.msg.dgexportfmt3 = function(_1) { return '选择确定继续上一次导出，从第' + _1 + '行开始？'; };
$P.msg['errorresponse'] = '系统没有对您的请求作出响应，请重试！';
$P.msg['processing'] = '系统处理中，请稍候...';



var SRFUtility =
{
    isNull: function(_obj) {
        if (_obj == null || _obj == undefined) {
            return true;
        }
        return false;
    },
    getvalue: function(_1, _2) {
        if (_1 == undefined || _1 == null)
            return _2;
        return _1;
    },
    parsestring: function(_1) {
        if (_1.replace) {
            _1 = _1.replace(/\\'/g, "'");
            return _1.replace(/\\"/g, '"');
        }
        else
            return '';
    },
    parseXML: function(xml) {
        var xmlDoc = null;
        if (Ext.isIE) {
            xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async = "false";
            xmlDoc.loadXML(xml);
        }
        else {
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(xml, "text/xml");
        }
        return xmlDoc;
    },
    loadXMLNode: function(xmlNode, xml) {
        if (xml == null || xml == undefined)
            xml = {};
        for (var i = 0; i < xmlNode.attributes.length; i++) {
            var strName = xmlNode.attributes.item(i).name;
            var strValue = xmlNode.attributes.item(i).value;
            strName = strName.toLowerCase();
            xml[strName] = strValue;
        }
        return xml;
    },
    saveXMLNode: function(XML, obj) {
        var proName = '';
        for (proName in obj) {
            var proValue = obj[proName].toString();
            if (proValue != '')
                XML.Attrib(proName, proValue);
        }
    },
    checktimevalue: function(max, event) {
        var el = null;
        if (Ext.isIE) {
            el = window.event.srcElement;
        }
        else {
            el = event.target;
        }
        var varValue = el.value;
        varValue = varValue.trim();
        if (varValue.length == 0) {
            el.value = '00';
            return;
        }
        if (varValue.length == 1) {
            if (!isNaN(varValue)) {
                el.value = '0' + varValue;
            }
            else {
                el.value = '00';
            }
            return;
        }
        if (varValue.length == 2) {
            if (varValue.charAt(0) == '0') {
                if (isNaN(varValue.charAt(1))) {
                    el.value = '00';
                }
                return;
            }
            else {
                if (!isNaN(varValue)) {
                    var nValue = parseInt(varValue);
                    if (nValue < 0 || nValue >= max)
                        el.value = '00';
                }
                else {
                    el.value = '00';
                }
                return;
            }
        }
        el.value = '00';
        return;
    },

    check24: function(event) {
        this.checktimevalue(24, event);
    }
    ,
    check60: function(event) {
        this.checktimevalue(60, event);
    },
    selectall: function(event) {
        var el = null;
        if (Ext.isIE) {
            el = window.event.srcElement;
        }
        else {
            el = event.target;
        }
        el.select();
    },
    download: function(url) {
        //alert(url);
        //SRFUtility.root().location = url;
        window.open(url, '', 'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0,width=30,height=30', false);
    },
    openwin: function(_URL, _TARGET, _STYLE, _REPLACE, _WIDTH, _HEIGHT) {
        var SCRW = screen.width;
        var SCRH = screen.height;
        if (_WIDTH <= 0)
            _WIDTH = SCRW - 80;
        if (_HEIGHT <= 0)
            _HEIGHT = SCRH - 100;

        var WLEFT = 0;
        var WTOP = 0;
        if (SCRW - _WIDTH > 0)
            WLEFT = (SCRW - _WIDTH) / 2
        if (SCRH - _HEIGHT - 30 > 0)
            WTOP = (SCRH - _HEIGHT - 30) / 2
        WTOP -= 10;

        if (_TARGET == '' || _TARGET == null)
            _TARGET = '';
        if (_STYLE == '' || _STYLE == null)
            _STYLE = 'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0';
        var winWindow = window.open(_URL, _TARGET, _STYLE + ',width=' + _WIDTH + ',height=' + _HEIGHT + ',left=' + WLEFT + ',top=' + WTOP, _REPLACE);
    },
    showmodeldialog: function(_URL, _PARAMS, _STYLE, _WIDTH, _HEIGHT) {
        var SCRW = screen.width;
        var SCRH = screen.height;
        if (_WIDTH <= 0)
            _WIDTH = SCRW - 80;
        if (_HEIGHT <= 0)
            _HEIGHT = SCRH - 100;

        var WLEFT = 0;
        var WTOP = 0;
        if (SCRW - _WIDTH > 0)
            WLEFT = (SCRW - _WIDTH) / 2
        if (SCRH - _HEIGHT - 30 > 0)
            WTOP = (SCRH - _HEIGHT - 30) / 2
        WTOP -= 10;

        if (_STYLE == '' || _STYLE == null)
            _STYLE = 'scroll: yes;status: no;resizable: yes;';
        _STYLE = _STYLE.replace(/=/g, ':');
        _STYLE = _STYLE.replace(/,/g, ';');
        var _RET = window.showModalDialog(_URL, _PARAMS, _STYLE + ';dialogHeight: ' + _HEIGHT + 'px;dialogWidth: ' + _WIDTH + 'px;' + 'dialogLeft:' + WLEFT + 'px;dialogTop:' + WTOP + 'px;');
        return _RET;
    } /*,
    showmodeldialogex: function(_URL, _PARAMS, _STYLE, _WIDTH, _HEIGHT) {

        if (window.top != window) {
            alert('top');
            return;
        }

        var SCRW = screen.width;
        var SCRH = screen.height;
        if (_WIDTH <= 0)
            _WIDTH = SCRW - 80;
        if (_HEIGHT <= 0)
            _HEIGHT = SCRH - 100;

        var WLEFT = 0;
        var WTOP = 0;
        if (SCRW - _WIDTH > 0)
            WLEFT = (SCRW - _WIDTH) / 2
        if (SCRH - _HEIGHT - 30 > 0)
            WTOP = (SCRH - _HEIGHT - 30) / 2
        WTOP -= 10;


        var win = new Ext.Window({
            title: '新页面',
            maximizable: true,
            maximized: true,
            width: _WIDTH,
            height: _HEIGHT,
            autoScroll : true,
            bodyBorder : true,
            draggable : true,
            modal: true,
            resizable: true,
            contentEl: Ext.DomHelper.append(document.body, {
                tag: 'iframe',
                style: "border 0px none;scrollbar:true",
                src: url,
                height: "100%",
                width: "100%"
            })
        })
        win.show();

    }*/,
    navpdg: function(pos, keyid, frm, tabid) {
        var varGrid = null;
        if (window.dialogArguments && window.dialogArguments.$P && window.dialogArguments.$P.maingrid) {
            varGrid = window.dialogArguments.$P.maingrid;
        }
        if (varGrid == null && window.opener && !window.opener.closed && window.opener.$P && window.opener.$P.maingrid) {
            varGrid = window.opener.$P.maingrid;
        }
        if (varGrid == null) {
            alert('数据表格对象不存在，无法进行数据浏览'); return;
        }
        var varStore = varGrid.getStore();
        var varRD = null;
        var nCount = varStore.getCount();
        if (nCount == 0) {
            alert('数据表格没有记录，无法进行浏览操作!');
        }
        else {
            var varSM = varGrid.getSelectionModel();
            if (pos == 'FIRST') {
                varSM.selectFirstRow();
            }
            if (pos == 'LAST') {
                varSM.selectLastRow(false);
            }
            if (pos == 'PREV') {
                varSM.selectPrevious(false);
            }
            if (pos == 'NEXT') {
                varSM.selectNext(false);
            }
            var curSel = varSM.getSelected();
            if (curSel) {
                if (tabid != '') {
                    var varTVD = {}; varTVD[keyid] = curSel.get(keyid); $P.tabview[tabid].setdata(varTVD);
                }
                else {
                    frm.load2(curSel.get(keyid));
                }
            }
            delete varSM;
        }
        delete varGrid;
        delete varStore;
    },
    refreshpdg: function() {
        var varGrid = null;
        if (window.dialogArguments && window.dialogArguments.$P && window.dialogArguments.$P.maingrid) {
            varGrid = window.dialogArguments.$P.maingrid;
        }
        if (varGrid == null && window.opener && !window.opener.closed && window.opener.$P && window.opener.$P.maingrid) {
            varGrid = window.opener.$P.maingrid;
        }
        if (varGrid == null) { return; }
        var varStore = varGrid.getStore();
        if (varStore.lastOptions) {
            varStore.reload();
        }
        else {
            varStore.loaddefault();
        }

        delete varGrid; delete varStore;
    },
    refreshdg: function() {
        var varGrid = null;
        varGrid = $P.maingrid;
        if (varGrid == null) { return; }
        var varStore = varGrid.getStore();
        if (varStore.lastOptions) {
            varStore.reload();
        }
        else {
            varStore.loaddefault();
        }

        delete varGrid; delete varStore;
    },
    parseresponse: function(_RO) {
        if (_RO.responseText != undefined && _RO.responseText != null && _RO.responseText != '') {
            var _JO = eval("(" + _RO.responseText + ")");
            return _JO;
        }
        return null;
    },
    showerror: function(_JO) {
        var _info = '';
        if (_JO.info) {
            _info = _JO.info;
        }
        if (_info == '') {
            _info = $P.msg[_JO.ret.toString()];
            if (!_info) {
                _info = '未知错误';
            }
        }
        alert(_info);
    },
    root: function() {
        var root = top;
        while (true) {
            if (root && root.opener) {
                root = root.opener.top;
            }
            else {
                return root;
            }
        }
    }
}

SRFUtility.showmodaldialog = SRFUtility.showmodeldialog;

var SRFTree =
{	
	find: function(node,varNodeId){
		
		if(node.id == varNodeId)
			return node;
		
		if(node.childNodes == undefined || node.childNodes == null)
			return null;
		
		for(var i=0;i<node.childNodes.length;i++)
		{
			var findNode = SRFTree.find(node.childNodes[i],varNodeId);
			if(findNode != null)
				return findNode;
		}
		return null;
	}
}

var SRFAjaxResultHelper ={
	process:function(o)
	{
		if(o.url != null && o.url != '')
			window.location.href = o.url;
		if(o.code != null && o.code != '')
			eval(o.code);	
	}
}

var $ARP = SRFAjaxResultHelper.process;

/*form set value*/
var $FSV = SRFForm.setValue;
var $FSV2 = SRFForm.setValue2;
var $FSV3 = SRFForm.setCheckValue;
var $FSV6 = SRFForm.setFileUploaderValue;
/*form get value*/
var $FGV = SRFForm.getValue;
var $FGV2 = SRFForm.getValue;
var $FGV3 = SRFForm.getCheckValue;
var $FGV6 = SRFForm.getFileUploaderValue;
/*form enable value*/
var $FEI = SRFForm.enableFormItem;
var $FEI2 = SRFForm.enableFormItem2;
var $FEI3 = SRFForm.enableFormItem3;
var $FEI4 = SRFForm.enableFormItems;
var $FEI5 = SRFForm.enableFormItems2;
/*form set focus*/
var $FSF = SRFForm.setFocus;


SRFGridMgr = function(config) {
    Ext.apply(this, config);
    /** @private */
    this.addEvents({
        "rowselected": true,
        "rowselectedcancel": true,
        "rowclicked": true,
        "rowdblclicked": true,
        "rowcheckaction": true,
        "editablechange": true
    });

    this._GRIDID = this.gridid;
    this._LASTROWID = '';
    this._LASTSORTFIELD = this.sortfield || '';
    this._LASTSORTDIRECTION = '';
    if (this._LASTSORTFIELD != '')
        this._LASTSORTDIRECTION = this.sortdir || '';
    this._GRIDTHEMEID = this.gridthemeid || '';
    this._DGURL = this.dgurl || '';
    this._URL = this.url || '';
    this._EDITGRID = this.editgrid || false;
    this._NEWROWFLAG = false;
    this._SAVEROWCOUNT = 0;
    this._EDITABLE = true;
    this._NEWROWS = null;
    this._LASTDOWNLOAD = 0;
    this._LASTDOWNLOAD2 = 0;
    this._CONTINUEDOWNLOAD = false;
    this._LASTDOWNLOADPARAM = {};

    // check and correct shorthanded configs
    if (this.grid) {
        this._GRID = this.grid;
        delete this.grid;
        this._GRID.getSelectionModel().on('rowselect', this.onrowselect.createDelegate(this));
        this._GRID.getSelectionModel().on('selectionchange', this.onselectionchange.createDelegate(this));
        this._GRID.on('rowclick', this.onrowclicked.createDelegate(this));
        this._GRID.on('rowdblclick', this.onrowdblclicked.createDelegate(this));
        this._GRID.on('columnresize', this.oncolumnresize.createDelegate(this));
        this._GRID.colModel.on('columnlockchange', this.oncolumnchanged.createDelegate(this));
        this._GRID.colModel.on('columnmoved', this.oncolumnchanged.createDelegate(this));
        this._GRID.colModel.on('hiddenchange', this.oncolumnchanged.createDelegate(this));
        this._GRID.colModel.on('widthchange', this.oncolumnchanged.createDelegate(this));
    }
    if (this.store) {
        this._STORE = this.store;
        delete this.store;
        this._STORE.on('load', this.ondataload.createDelegate(this));
    }
    if (this.rd) {
        this._RECORD = this.rd;
        delete this.rd;
    }

    SRFGridMgr.superclass.constructor.call(this);
};
Ext.extend(SRFGridMgr, Ext.util.Observable,
{
    isloadcancel: function() {
        if (!this._EDITABLE)
            return false;
        if (this._SAVEROWCOUNT != 0)
            return false;
        var arr = new Array();
        var count = this._STORE.getCount();
        for (i = 0; i < count; i++) {
            var rd = this._STORE.getAt(i);
            if (rd.dirty) {
                rd.data.rowindex = i;
                arr.push(rd.data);
            }
        }
        if (arr.length > 0) {
            if (!confirm($P.msg['dgrowunsave2'])) {
                return true;
            }
        }
        return false;
    },
    seteditable: function(_1) {
        if (this._EDITABLE == _1 || !this._EDITGRID)
            return;

        if (!_1) {
            var arr = new Array();
            var count = this._STORE.getCount();
            for (i = 0; i < count; i++) {
                var rd = this._STORE.getAt(i);
                if (rd.dirty) {
                    rd.data.rowindex = i;
                    arr.push(rd.data);
                }
            }
            if (arr.length > 0) {
                if (!confirm($P.msg['dgrowunsave'])) {
                    this.saverow();
                    return;
                }
                else {
                    this._STORE.reload();
                }
            }
        }
        this._EDITABLE = _1;
        this.fireEvent("editablechange", this);
    },
    geteditable: function() {
        return this._EDITGRID && this._EDITABLE;
    },
    oncolumnchanged: function(_a, _b, _c) {
        var _1 = this._LASTSORTFIELD || '';
        _1 += '|';
        _1 += this._LASTSORTDIRECTION || '';

        if (this._STORE.groupField) {
            if (_1 == '')
                _1 += '|';
            _1 += '|';
            _1 += this._STORE.groupField;
        }

        var _CM = this._GRID.colModel;
        for (var i = 0; i < _CM.getColumnCount(); i++) {
            if (_1 != '')
                _1 += ';';
            _1 += i.toString();
            _1 += '|';
            _1 += _CM.getDataIndex(i);
            _1 += '|';
            if (_CM.isHidden(i))
                _1 += '0';
            else
                _1 += '1';
            _1 += '|';
            if (_CM.isLocked && _CM.isLocked(i))
                _1 += '1';
            else
                _1 += '0';
            _1 += '|';
            _1 += _CM.getColumnWidth(i).toString();
        }

        var _PARAMS = {};
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'datagridthemeaction', action: 'update', dgthemeid: this._GRIDTHEMEID, dgtheme: _1 });

        var _CALLBACK =
		{
		    success: this.onsavedgtheme.createDelegate(this),
		    failure: this.onsavedgtheme.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        Ext.lib.Ajax.request('post', this._DGURL, _CALLBACK, _POSTDATA);
    },
    oncolumnresize: function(_1, _2) {
        this.oncolumnchanged(1, 1, 1);
        this._GRID.getView().refresh(true); //layout();
    },
    getcheckedrows: function() {
        var ret = '';
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }

            if (Ext.getDom(checkid) && Ext.getDom(checkid).checked) {
                var _1 = Ext.getDom(checkid).value;
                if (_1 == '')
                    continue;
                if (ret != '')
                    ret += ',';
                ret += _1;
            }
        }
        return ret;
    },
    getcheckedrows2: function(_KEY) {
        var ret = '';
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }
            if (Ext.getDom(checkid) && Ext.getDom(checkid).checked) {
                var _1 = this._STORE.getAt(i).get(_KEY);
                if (_1 == '')
                    continue;
                if (ret != '')
                    ret += ',';
                ret += _1;
            }
        }
        return ret;
    },
    getcheckedrowscollection: function() {
        var ret = new Array();
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }

            if (Ext.getDom(checkid) && Ext.getDom(checkid).checked) {
                var _1 = Ext.getDom(checkid).value;
                if (_1 == '')
                    continue;
                ret.push(rd);
            }
        }
        return ret;
    },
    getcheckedrowcount: function() {
        var ret = 0;
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }
            if (Ext.getDom(checkid) && Ext.getDom(checkid).checked) {
                ret++;
            }
        }
        return ret;
    },
    checkalternative: function() {
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }
            if (Ext.getDom(checkid) != null)
                Ext.getDom(checkid).checked = !Ext.getDom(checkid).checked;
        }
        this.fireEvent("rowcheckaction", this);
    },
    checkall: function(_1) {
        for (var i = 0; i < this._STORE.getCount(); i++) {
            var checkid = this._GRIDID + '_SC' + i.toString();
            var rd = this._STORE.getAt(i);
            var srfrowid = rd.get('srfrowid');
            if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                checkid = this._GRIDID + '_SC' + srfrowid;
            }
            if (Ext.getDom(checkid) != null)
                Ext.getDom(checkid).checked = _1;
        }
        this.fireEvent("rowcheckaction", this);
    },
    onselectionchange: function(_T) {
        if (_T.getCount() == 0)
            this.fireEvent("rowselectedcancel", this);
        else {
            this.fireEvent("rowselected", this, this._GRID.getSelectionModel().getSelected());
        }
    },
    onrowclicked: function(_1, _2, _3) {
        this.fireEvent("rowclicked", this);
    },
    onrowdblclicked: function(_1, _2, _3) {
        this.fireEvent("rowdbclicked", this);
    },
    onrowselect: function(_T, _1) {
        if (this._GRID.getSelectionModel().getSelected() != null) {
            this._LASTROWID = this._GRID.getSelectionModel().getSelected().get('KEYS');
        }
        //   this.fireEvent("rowselected", this, this._GRID.getSelectionModel().getSelected());
    },
    ondataload: function(_T, _R, _O) {
        if (this._LASTROWID != '') {
            for (var i = 0; i < _R.length; i++) {
                if (_R[i].get('KEYS') == this._LASTROWID) {
                    this._GRID.getView().ensureVisible(i, 0, true);
                    this._GRID.getSelectionModel().selectRow(i, false);
                    return;
                }
            }
            this._LASTROWID = '';
        }
        this._LASTDOWNLOAD = 0;
        this.fireEvent("rowselectedcancel", this);
        var _SC = false;
        var state = this._STORE.getSortState();
        if (state == undefined || state == null) {
            if (this._LASTSORTFIELD != '')
                _SC = true;

            if (this._LASTSORTDIRECTION != '')
                _SC = true;
            this._LASTSORTFIELD = '';
            this._LASTSORTDIRECTION = '';
        }
        else {
            if (state.field != this._LASTSORTFIELD) {
                this._LASTSORTFIELD = state.field || '';
                _SC = true;
            }
            if (state.direction != this._LASTSORTDIRECTION) {
                this._LASTSORTDIRECTION = state.direction || '';
                _SC = true;
            }
        }
        if (_SC) {
            this.oncolumnchanged(1, 1, 1);
        }
    },
    onsavedgtheme: function(_1) {
    },
    exportexcel: function(_P, _2) {
        if (_2 == undefined)
            _2 = '1000';
        var _PARAMS = _P || {};
        this._CONTINUEDOWNLOAD = false;
        if (!confirm($P.msg.dgexportfmt(_2))) {
            // _PARAMS.start = 0;
            /*if (this._LASTDOWNLOAD != 0) {
                if (confirm($P.msg.dgexportfmt2((this._LASTDOWNLOAD + 1).toString()))) {
                    _PARAMS.start = this._LASTDOWNLOAD;
                }
            }*/
            _PARAMS.limit = parseInt(_2);
            this._LASTDOWNLOAD2 = _PARAMS.start + _PARAMS.limit;
            this._CONTINUEDOWNLOAD = true;
        }
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: 'srfdaexport', gridid: this._GRIDID });
        Ext.apply(this._LASTDOWNLOADPARAM, _PARAMS);
        var _CALLBACK =
		{
		    success: this.onexportok.createDelegate(this),
		    failure: this.onremovefailed.createDelegate(this),
		    timeout: 60000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    exportexcel2: function() {
        var _PARAMS = this._LASTDOWNLOADPARAM;
        if (this._LASTDOWNLOAD != 0) {
            _PARAMS.start = this._LASTDOWNLOAD;
        }
        this._LASTDOWNLOAD2 = _PARAMS.start + _PARAMS.limit;
        var _CALLBACK =
		{
		    success: this.onexportok.createDelegate(this),
		    failure: this.onremovefailed.createDelegate(this),
		    timeout: 60000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    onexportok: function(_RO) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            $ARP(_JO);
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
            }
            else {
                this._LASTDOWNLOAD = this._LASTDOWNLOAD2;
                if (this._CONTINUEDOWNLOAD) {
                    if (confirm($P.msg.dgexportfmt3((this._LASTDOWNLOAD + 1).toString()))) {
                        this.exportexcel2();
                    }
                }
            }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    remove: function(_P) {
        var _PARAMS = _P || {};
        if (!confirm('确实要删除以下数据？\r\n' + this.getcheckedrows2('srfdamajortext')))
            return false;

        var keys = this.getcheckedrows2(this.KEYS[0]);

        var varCon = true;
        while (varCon) {
            varCon = false;
            for (var i = 0; i < this._STORE.getCount(); i++) {
                var checkid = this._GRIDID + '_SC' + i.toString();
                var rd = this._STORE.getAt(i);
                var srfrowid = rd.get('srfrowid');
                if (srfrowid != null && srfrowid != undefined && srfrowid != '') {
                    checkid = this._GRIDID + '_SC' + srfrowid;
                }
                if (Ext.getDom(checkid) != null) {
                    if (Ext.getDom(checkid).checked) {
                        this._STORE.removeAt(i);
                        varCon = true;
                        break;
                    }
                }
            }
        }

        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: 'remove', gridid: this._GRIDID, srfdakeys: keys });
        var _CALLBACK =
		{
		    success: this.onremoveok.createDelegate(this),
		    failure: this.onremovefailed.createDelegate(this),
		    timeout: 30000
		};

        var _POSTDATA = Ext.urlEncode(_PARAMS);

        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }

        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);

    },
    onremoveok: function(_RO) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            $ARP(_JO);
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
                this._STORE.reload();
            }
            else {
                if (this._EDITGRID && this.geteditable())
                    return;
                this._STORE.reload();
            }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    onremovefailed: function(_1) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        alert($P.msg['networkerror']);
    },
    scustomcall: function(_P, callid, callname, bconfirm) {
        var _PARAMS = _P || {};
        if (bconfirm == null || bconfirm == undefined || bconfirm) {
            if (!confirm('确实要对以下数据执行[' + callname + ']操作吗？\r\n' + this.getSelectedText()))
                return false;
        }
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: callid, gridid: this._GRIDID, srfdakeys: this.getSelectedKey() });
        var _CALLBACK =
		{
		    success: this.oncustomcallok.createDelegate(this),
		    failure: this.oncustomcallfailed.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    customcall: function(_P, callid, callname, bconfirm) {
        var _PARAMS = _P || {};
        if (bconfirm == null || bconfirm == undefined || bconfirm) {
            if (!confirm('确实要对以下数据执行[' + callname + ']操作吗？\r\n' + this.getcheckedrows2('srfdamajortext')))
                return false;
        }
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: callid, gridid: this._GRIDID, srfdakeys: this.getcheckedrows2(this.KEYS[0]) });
        var _CALLBACK =
		{
		    success: this.oncustomcallok.createDelegate(this),
		    failure: this.oncustomcallfailed.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    customcall2: function(_P, callid, callname) {
        var _PARAMS = _P || {};
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: callid, gridid: this._GRIDID });
        var _CALLBACK =
		{
		    success: this.oncustomcallok.createDelegate(this),
		    failure: this.oncustomcallfailed.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    oncustomcallok: function(_RO) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            $ARP(_JO);
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
            }
            else {
                if (_JO.reload)
                    this._STORE.reload();
            }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    oncustomcallfailed: function(_1) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        alert($P.msg['networkerror']);
    },
    newrows: function(_P) {
        this._NEWROWS = _P;
        if (this._NEWROWS == null)
            return;
        if (this._NEWROWS.getCount() == 0)
            return;
        var _1 = this._NEWROWS.removeAt(0);
        newrow(_1);
    },
    newrow: function(_P) {

        if (this._NEWROWFLAG) {
            alert('新建行数据过程中，请稍候重试！');
            return;
        }

        this._NEWROWFLAG = true;

        var _PARAMS = _P || {};
        _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: 'newrow', gridid: this._GRIDID, rowindex: this._STORE.getCount().toString() });

        var _CALLBACK =
		{
		    success: this.onnewrowok.createDelegate(this),
		    failure: this.onnewrowfailed.createDelegate(this),
		    timeout: 30000
		};
        var _POSTDATA = Ext.urlEncode(_PARAMS);
        if ($P.maskhelper) {
            $P.maskhelper.maskprocessing($P.msg['processing']);
        }
        Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
    },
    onnewrowok: function(_RO) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        this._NEWROWFLAG = false;
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            $ARP(_JO);
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
            }
            else {
                if (_JO.row) {
                    var p = new this._RECORD(_JO.row);
                    if (_JO.rowdirty)
                        p.markDirty();
                    var index = this._STORE.getCount();
                    this._STORE.insert(index, p);
                    this._GRID.getView().ensureVisible(index, 0, true);
                }
                else
                    if (_JO.rows) {
                    for (var i = 0; i < _JO.rows.length; i++) {
                        var p = new this._RECORD(_JO.rows[i]);
                        if (_JO.rowdirty)
                            p.markDirty();
                        var index = this._STORE.getCount();
                        this._STORE.insert(index, p);
                        this._GRID.getView().ensureVisible(index, 0, true);
                    }
                }
                if (this._NEWROWS == null)
                    return;
                if (this._NEWROWS.getCount() == 0)
                    return;
                var _1 = this._NEWROWS.removeAt(0);
                newrow(_1);
            }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    onnewrowfailed: function(_1) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        this._NEWROWFLAG = false;
        alert($P.msg['networkerror']);
    },
    saverow: function() {
        if (this._SAVEROWCOUNT != 0) {
            alert('保存行数据过程中，请稍候重试！');
            return;
        }
        var arr = new Array();
        var count = this._STORE.getCount();
        for (i = 0; i < count; i++) {
            var rd = this._STORE.getAt(i);
            if (rd.dirty) {
                rd.data.rowindex = i;
                arr.push(rd.data);
            }
        }

        this._SAVEROWCOUNT = arr.length;
        for (i = 0; i < arr.length; i++) {
            var _PARAMS = arr[i];
            _PARAMS = Ext.apply(_PARAMS, { actiontype: 'gridaction', action: 'saverow', gridid: this._GRIDID });

            var _CALLBACK =
		    {
		        success: this.onsaverowok.createDelegate(this),
		        failure: this.onsaverowfailed.createDelegate(this),
		        timeout: 30000
		    };
            var _POSTDATA = Ext.urlEncode(_PARAMS);
            //alert(_POSTDATA);
            if ($P.maskhelper) {
                $P.maskhelper.maskprocessing($P.msg['processing']);
            }
            Ext.lib.Ajax.request('post', this._URL, _CALLBACK, _POSTDATA);
        }
    },
    onsaverowok: function(_RO) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        this._SAVEROWCOUNT--;
        var _JO = SRFUtility.parseresponse(_RO);
        if (_JO) {
            $ARP(_JO);
            if (_JO.ret != 0) {
                SRFUtility.showerror(_JO);
            }
            else {
                var p = new this._RECORD(_JO.row);
                var index = _JO.row.rowindex;
                var oldrd = this._STORE.getAt(index);
                this._STORE.remove(oldrd);

                this._STORE.insert(index, p);
                this._GRID.getView().ensureVisible(index, 0, true);
                this._STORE.reload();
            }
        }
        else {
            alert($P.msg['errorresponse']);
            return;
        }
    },
    onsaverowfailed: function(_1) {
        if ($P.maskhelper) { $P.maskhelper.unmask(); }
        this._SAVEROWCOUNT--;
    },
    getSelected: function() {
        return this._GRID.getSelectionModel().getSelected();
    },
    clearSelections: function() {
        this._GRID.getSelectionModel().clearSelections();
    },
    getSelectedKeys: function() {
        var _2 = {};
        var _1 = this.getSelected();
        if (_1 == null) return _2;

        for (var i = 0; i < this.KEYS.length; i++)
            _2[this.KEYS[i]] = _1.get(this.KEYS[i]);

        return _2;
    },
    getSelectedKey: function() {
        var _2 = {};
        var _1 = this.getSelected();
        if (_1 == null) return _2;

        for (var i = 0; i < this.KEYS.length; i++)
            _2[this.KEYS[i]] = _1.get(this.KEYS[i]);

        return _2[this.KEYS[0]];
    },
    getSelectedText: function() {
        var _2 = '';
        var _1 = this.getSelected();
        if (_1 == null) return _2;

        _2 = _1.get('srfdamajortext');

        return _2;
    },
    srfdestroy: function() {
        this.purgeListeners();
        if (this._GRID) {
            delete this._GRID;
        }
        if (this._STORE) {
            delete this._STORE;
        }
        if (this._RECORD) {
            delete this._RECORD;
        }
    }
});

 
SRFTabView = function(config){
   Ext.apply(this, config);
   
   this._DATA = {};
   this._PAGES={};
   this._NAME = '';
   this._IDMAP = {};
     /** @private */
	this.addEvents({
	    "datachanged" : true,
	    "listchanged" : true
	});
	
    // check and correct shorthanded configs
    if(this.tab){
        this._TAB = this.tab;
        delete this.tab;
        this._TAB.on('tabchange',this.ontabchange.createDelegate(this));
    }
    
     SRFTabView.superclass.constructor.call(this);
};
Ext.extend(SRFTabView, Ext.util.Observable,
{
    ontabchange: function(_1, _2) {
        if (this._PAGES[_2.contentEl] == undefined)
            return;

        var varPage = this._PAGES[_2.contentEl];

        if (varPage._LOAD) {
            return;
        }
        if (varPage._URL == '')
            return;

        if (exPage._UPDATE)
            exPage._UPDATE = null; 
            
        var varUpdate = new Ext.UpdateManager(_2.contentEl);
        varUpdate.on('update', varPage.onupdateok.createDelegate(varPage));
        varUpdate.on('failure', varPage.onupdatefailed.createDelegate(varPage));
        var varURL = varPage._URL;
        if (varURL.indexOf('?') == -1)
            varURL += '?';
        else
            varURL += '&';
        varURL += Ext.urlEncode({ tabviewid: this._NAME, tabviewpageid: _2.contentEl });

        varUpdate.update({ url: varURL, scripts: true, nocache: true });
        exPage._UPDATE = varUpdate;
    },
    createpage: function(_1, _2) {
        var page = new SRFTabViewPage({ tabview: this, id: _2, realid: _1 });
        this._IDMAP[_1] = _2;
        this._PAGES[_2] = page;
        return page;
    },
    changelist: function() {
        this.fireEvent("listchanged", this);
    },
    setdata: function(_1) {
        if (this._DATA == null && _1 == null)
            return;
        if (this._DATA != null && _1 != null) {
            var _last = Ext.urlEncode(this._DATA);
            var _cur = Ext.urlEncode(_1);

            if (_last == _cur)
                return;
        }
        this._DATA = _1;
        this.fireEvent("datachanged", this);
    },
    setdataex: function(_1) {
        this._DATA = _1;
        this.fireEvent("datachanged", this);
    },
    showpage: function(_1) {
        this._TAB.activate(this._IDMAP[_1]);
    },
    setpagevisible: function(_1, _2) {
        if (_2)
            this._TAB.unhideTabStripItem(this._IDMAP[_1]);
        else
            this._TAB.hideTabStripItem(this._IDMAP[_1]);
    },
    setvisible: function(_1) {
        this._TAB.setVisible(_1);
    },
    isactivepage: function(_1) {
        var _2 = this._TAB.getActiveTab();
        if (_2)
            return _2.id == this._IDMAP[_1];
        return false;
    },
    srfdestroy: function() {
        this.purgeListeners();
        if (this._TAB) {
            delete this._TAB;
        }
        if (this._PAGE) {
            for (proName in this._PAGE) {
                var varPage = this._PAGE[proName];
                if (varPage) {
                    varPage.srfdestroy();
                }
                this._PAGE[proName] = null;
            }
            delete this._PAGE;
        }
    }
});

SRFTabViewPage = function(config) {
    Ext.apply(this, config);

    /** @private */
    this.addEvents({
        "datachanged": true,
        "listchanged": true
    });

    if (this.id) {
        this._ID = this.id;
        delete this.id;
    }
    if (this.realid) {
        this._REALID = this.realid;
        delete this.realid;
    }
    this._URL = '';
    this._LOAD = false;
    this._DATACHANGED = false;
    this._LISTCHANGED = false;
    this._UPDATE = null;

    if (this.tabview) {
        this._TABVIEW = this.tabview;
        delete this.tabview;
        this._TABVIEW.on('datachanged', this.ondatachanged.createDelegate(this));
        this._TABVIEW.on('listchanged', this.onlistchanged.createDelegate(this));
        this._TABVIEW._TAB.on('tabchange', this.ontabchange.createDelegate(this));
    }

    SRFTabViewPage.superclass.constructor.call(this);
};
Ext.extend(SRFTabViewPage, Ext.util.Observable,
{
    onupdateok: function(_1, _2) {
        SRFDEBUG.show('************************************************************\r\n');
        SRFDEBUG.show(_2.responseText);
        this._LOAD = true;
    },
    onupdatefailed: function(_1, _2) {
        _1.el = null;
        this._LOAD = false;
        Ext.getDom(this._ID).innerHTML = "<SPAN class='sx-normaltext-red'>加载网页失败，请重新刷新</SPAN> ";
    },
    ondatachanged: function(_1) {
        if (this._TABVIEW._TAB.getActiveTab() == null)
            return;

        if (this._TABVIEW._TAB.getActiveTab().id == this._ID)
            this.fireEvent("datachanged", this);
        else
            this._DATACHANGED = true;
    },
    onlistchanged: function(_1) {
        if (this._TABVIEW._TAB.getActiveTab().id == this._ID)
            this.fireEvent("listchanged", this);
        else
            this._LISTCHANGED = true;
    },
    ontabchange: function(_1, _2) {
        if (_2.id != this._ID)
            return;

        if (this._DATACHANGED) {
            this.fireEvent("datachanged", this);
            this._DATACHANGED = false;
        }

        if (this._LISTCHANGED) {
            this.fireEvent("listchanged", this);
            this._LISTCHANGED = false;
        }
    },
    getdata: function() {
        return this._TABVIEW._DATA;
    },
    srfdestroy: function() {
        this.purgeListeners();
        if (this._TABVIEW) {
            delete this._TABVIEW;
        }
        if (exPage._UPDATE) {
            delete exPage._UPDATE;
        }
    }
}
);


SRFComboBoxHelper = function(element,config){
   Ext.apply(this, config);
   this._ELEMENT = element;
   delete element;
   SRFComboBoxHelper.superclass.constructor.call(this);
   
   	var _URL = this.url;
	var _TIMEOUT = this.timeout||30000;
	var _PARAMS = this.params||{};
	_PARAMS = Ext.apply(_PARAMS, {comboBoxid:this._ELEMENT.id});
	var _CALLBACK =
	{
		success:this.onloadok.createDelegate(this), 
		failure:this.onajaxfailed.createDelegate(this), 
		 timeout:_TIMEOUT
	};
	
	var _POSTDATA =  Ext.urlEncode(_PARAMS);
	Ext.lib.Ajax.request('post', _URL, _CALLBACK, _POSTDATA);
};
Ext.extend(SRFComboBoxHelper, Ext.util.Observable, 
{	
	onloadok:function(_1)
	{	
		if(_1.responseText != undefined &&_1.responseText != null &&_1.responseText != '')
		{
			var _JO = eval("("+_1.responseText+")");
			if(_JO == undefined ||_JO == null || _JO.ret == undefined)
			{
				this.onajaxfailed(_1);
			}
			else
			{
				var lastvalue;
				if(this._ELEMENT.selectedIndex != -1)
				{
					lastvalue = this._ELEMENT.value;
				}
				while(this._ELEMENT.options.length >0)
				{
					this._ELEMENT.options.remove(0);
				}
				
				for(var i=0;i<_JO.items.length;i++)
				{
					var oOption = document.createElement("OPTION");
					this._ELEMENT.options.add(oOption);
					oOption.innerText = _JO.items[i].text;
					oOption.value = _JO.items[i].value;
					if(lastvalue != undefined)
					{
						if(lastvalue == oOption.value)
							oOption.selected = true;
					}
				}
				SRFAjaxResultHelper.process(_JO);
			}
		}
	},
	onajaxfailed:function(_1)
	{
		alert('connection error!');
	}
}	
);


SRFFormMgr = function(config){
   Ext.apply(this, config);
     /** @private */
	this.addEvents({
	    "filled" : true,
	    "reseted":true,
	    "valuechanged":true,
	    "saved":true
	});
	
	if(this.form)
	{
		this._FORM = this.form;
		delete this.form;
		this._FORM._MGR = this;
	}
	SRFFormMgr.superclass.constructor.call(this);
};
Ext.extend(SRFFormMgr, Ext.util.Observable,
    {
        firefilled: function() {
            this.fireEvent("filled", this);
        },
        firereseted: function() {
            this.fireEvent("reseted", this);
        },
        firevaluechanged: function(item) {
            this.fireEvent("valuechanged", this, item);
        },
        firesaved: function(savetag) {
           this.fireEvent("saved", this, savetag);
        }
        
    }
);

var $V = SRFUtility.getvalue;

/*
*文件上传对象
*/
SRFFileUploader = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    this.varId = this.id;
    this.varFILELIST = this.filelistid;
    this.varEnable = true;
    this.varItems = new Ext.util.MixedCollection(false);
    this.varItems.getKey = function(o) { return o.fileid; };
    this.varUploadPage = this.uploadpage;
    this.varDownloadPage = this.downloadpage;
    this.varTpl = new Ext.XTemplate(
    '<table width="100%" border="0" cellspacing="0" cellpadding="3" >',
	    '<tpl for="items">',
            '<tr  style="padding:2px;">',
            '<td width="20"><A onclick="$P.object[\'', this.varId, '\'].remove(\'{fileid}\');"  href="#"><img src="../sasrfex/images/default/icon_delete.png" title="删除此文件"></a></td>',
            '<td width="20"><img src="../sasrfex/images/default/icon_file.gif" title="{filename}"></td>',
            '<td ><a href="#" onclick="$P.object[\'', this.varId, '\'].download(\'{fileid}\');"><span class="sx-normaltext">{filename}</span></a></td>',
	    '</tr>',
    '</tpl>',
    '</table>'
    );
}
Ext.extend(SRFFileUploader, Ext.util.Observable,
{
    setenable: function(e) {
        this.varEnable = e;
        this.refresh();
    },
    refresh: function() {
        var o = {};
        o.items = [];
        for (var i = 0; i < this.varItems.getCount(); i++) { o.items.push(this.varItems.itemAt(i)); }
        this.varTpl.overwrite(this.varFILELIST, o);
    },
    remove: function(fileid) {
        if (!this.varEnable)
            return;
        var filename = this.varItems.get(fileid).filename;
        if (!confirm('确实要移除文件 ' + filename + '?')) { return; }
        this.varItems.removeKey(fileid);
        this.refresh();
    },
    upload: function() {
        if (!this.varEnable)
            return;

        var _DIALOGRESULT = window.showModalDialog(this.varUploadPage, '', 'scroll: no;status: no;dialogHeight: 300px;resizable: no;dialogWidth: 500px;');
        var _ret = 'cancel';
        if (_DIALOGRESULT != null && _DIALOGRESULT != undefined && _DIALOGRESULT.ret != undefined)
            _ret = _DIALOGRESULT.ret;
        if (_ret == 'ok') {
            var o = {};
            o.filename = $V(_DIALOGRESULT.filename, '');
            o.fileid = $V(_DIALOGRESULT.fileid, '');
            this.varItems.insert(this.varItems.getCount(), o);
            this.refresh();
        }
    },
    download: function(fileid) {
    window.open(this.varDownloadPage + '?FILEID=' + fileid, '', 'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0,width=30,height=30', false);
    },
    getvalue: function() {
        return $FGV6(this.varItems);
    },
    setvalue: function(strXML) {
        this.varItems.clear();
        $FSV6(strXML, this.varItems);
        this.refresh();
    }
});
/*
 * 补字对象
 */
SRFCaret = function(config){
	if(config){
		Ext.apply(this,config);
	} 
	if(Ext.isIE){
		this.initCaret(this.caretObjId);
	}
} 
Ext.extend(SRFCaret, Ext.util.Observable,
{
	setCaret:function(_1){
	    var textObj = Ext.getDom(_1);
	    if(textObj.createTextRange){
	        textObj.caretPos = document.selection.createRange().duplicate();
	    }
	},
	initCaret:function(_1){
	    var textObj = Ext.getDom(_1);
	    if (SRFUtility.isNull(textObj)){ alert('CaertObj is null!'); return;}
	    textObj.onselect = function(_1){
			    if(textObj.createTextRange){
			        textObj.caretPos = document.selection.createRange().duplicate();
			    }
			};
	    textObj.onclick = function(_1){
			    if(textObj.createTextRange){
			        textObj.caretPos = document.selection.createRange().duplicate();
			    } 
			};
	    textObj.onkeyup = function(_1){ 
			    if(textObj.createTextRange){
			        textObj.caretPos = document.selection.createRange().duplicate();
			    }
			};
	},
	insertObjVauleAtCaret:function(_targetDomId, _sourceDomId) {
	    var _sourceDom = Ext.getDom(_sourceDomId);
	    if(SRFUtility.isNull(_sourceDom)) { alert('QuickTipObj is null!'); return; };
	    this.insertAtCaret(_targetDomId, _sourceDom.value);
	},
	insertAtCaret:function(_1, textFeildValue) {
	    var textObj = Ext.getDom(_1);
	    if (document.all) {/*for IE Explorer*/
	        if (textObj.createTextRange && textObj.caretPos) {
	            var caretPos = textObj.caretPos;
	            caretPos.text = caretPos.text.charAt(caretPos.text.length - 1) == '   ' ? textFeildValue + '   ' : textFeildValue;
	        } else {
	            textObj.value = textObj.value + textFeildValue;
	        }
	    } else {/*for Mozilla based Explorer*/
	        if (textObj.setSelectionRange) {
	            var rangeStart = textObj.selectionStart;
	            var rangeEnd = textObj.selectionEnd;
	            var tempStr1 = textObj.value.substring(0, rangeStart);
	            var tempStr2 = textObj.value.substring(rangeEnd);
	            textObj.value = tempStr1 + textFeildValue + tempStr2;
	        } else {
	            alert('This   version   of   Mozilla   based   browser   does   not   support  function setSelectionRange');
	        }
	    } 
	}
});

/*
*照片对象
*/
SRFPicture = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    this.varPICTURE = this.pictureid;
    this.varEnable = true;
    this.varUploadPage = this.uploadpage;
    this.varDownloadPage = this.downloadpage;
    this.varFileId = '';
}
Ext.extend(SRFPicture, Ext.util.Observable,
{
    setenable: function(e) {
        this.varEnable = e;
    },
    remove: function() {
        if (!this.varEnable)
            return;
        this.varFileId = '';
        this.setpicture();
    },
    upload: function() {
        if (!this.varEnable)
            return;

        var _DIALOGRESULT = window.showModalDialog(this.varUploadPage, '', 'scroll: no;status: no;dialogHeight: 300px;resizable: no;dialogWidth: 500px;');
        var _ret = 'cancel';
        if (_DIALOGRESULT != null && _DIALOGRESULT != undefined && _DIALOGRESULT.ret != undefined)
            _ret = _DIALOGRESULT.ret;
        if (_ret == 'ok') {
            this.varFileId = $V(_DIALOGRESULT.fileid, '');
            this.setpicture();
        }
    },
    setpicture: function() {
        if (this.varFileId == '') {
            Ext.getDom(this.varPICTURE).src = '';
            Ext.getDom(this.varPICTURE + "_A").href = '#';
            Ext.getDom(this.varPICTURE + "_A").target = '_self';
            return;
        }
        else {
            Ext.getDom(this.varPICTURE).src = this.varDownloadPage + '?FILEID=' + this.varFileId;
            Ext.getDom(this.varPICTURE + "_A").href = Ext.getDom(this.varPICTURE).src;
            Ext.getDom(this.varPICTURE + "_A").target = '_blank';
            return;
        }
    },
    getvalue: function() {
        return this.varFileId;
    },
    setvalue: function(fileid) {
        this.varFileId = fileid;
        this.setpicture();
    }
});

Ext.EventManager.on(window, 'unload', function() {

    // alert('unload start ');

    var proName = '';
    try {
        for (proName in $P.iframe) {
            try {
                var proValue = $P.iframe[proName];
                if (proValue) {
                    SRFRemoveIframe(proValue);
                }
            } catch (e) {
            }
        }
        delete $P.iframe;

    } catch (e) { }

    try {
        for (proName in $P) {
            if (proName == 'navigatebar' || proName == 'mainform' || proName == 'maingrid' || proName == 'maskhelper' || proName == 'mainformstate') {
                if ($P[proName]) {
                    if ($P[proName].srfdestroy) exPage[proName].srfdestroy();
                }
                $P[proName] = null;
                continue;
            }
            if (proName != 'grid')
                SRFReset(proName, exPage[proName]);
            else {
                SRFResetGrid(exPage[proName]);
            }
        }
        exPage = null;
        $P = null;
    } catch (e) { }
/*
    // alert('unload 1 ');
    try {
        while (Ext.ComponentMgr.all.getCount() > 0) {
            var o = Ext.ComponentMgr.all.itemAt(0);
            try {
                o.destroy();
            }
            catch (e) {
                Ext.ComponentMgr.all.remove(o);
            }
        }
    } catch (e) { }

    //   alert('unload 2 ');
    try {
        if (Ext.Element.cache) {
            var nCount = 0;
            var temp = {};
            for (proName in Ext.Element.cache) {
                try {
                    temp[proName] = '';
                    nCount++;
                }
                catch (e) {
                }
            }
            for (proName in temp) {
                try {
                    var obj = Ext.Element.cache[proName];
                    Ext.destroy(Ext.Element.cache[proName]);
                    if (obj && obj.dom) {
                        obj.remove();
                    }
                }
                catch (e) {
                }
            }
        }
    } catch (e) { }

    //  alert('unload 3 ');
    try {
        if (Ext.Element.dataCache) {
            for (proName in Ext.Element.dataCache) {
                Ext.Element.dataCache[proName] = null;
            }
        }
        if (Ext.Element._flyweights) {
            for (proName in Ext.Element._flyweights) {
                Ext.Element._flyweights[proName] = null;
            }
        }
        delete Ext.Element.cache;
        delete Ext.Element.dataCache;
        delete Ext.Element._flyweights;
    } catch (e) {
    }

    //  alert('unload 4 ');
    if (Ext.isIE) {
        if (CollectGarbage)
            CollectGarbage();
    }

    //   alert('unload finish');
    */
});

function SRFReset(typename,obj) {
    if(obj == null || obj == undefined)
        return;
    var proName = '';
    for (proName in obj) {
        try {
            var proValue = obj[proName];
            if (proValue) {
                if (Ext.isFunction(proValue.srfdestroy))
                    proValue.srfdestroy();
                if (Ext.isFunction(proValue.destroy))
                    proValue.destroy();
                obj[proName] = null;
            }
        } catch (e) {
   //     alert(typename+' '+proName + '  ' + e.message);
        }
    }
}

function SRFResetGrid(obj) {
    if (obj == null || obj == undefined)
        return;
    var proName = '';
    for (proName in obj) {
    try {
        var proValue = obj[proName];
        if (proValue) {
            if (proValue.gridmgr) {
                proValue.gridmgr.srfdestroy();
                proValue.gridmgr = null;
                if (Ext.isFunction(proValue.destroy))
                    proValue.destroy();
            }
        }
        obj[proName] = null;
    }
    catch (e) {
       // alert(e.message);
    }
    }
}

function SRFRemoveIframe(if_id) {
    $P.iframe[if_id] = null;
  //  alert(if_id);
   var obj = document.getElementById(if_id);
    if (obj == null || obj == undefined)
        return;
    obj.src = "javascript:false";
    Ext.removeNode(obj);
    obj = null;
}


SRFFormStateMgr = function(config) {
    Ext.apply(this, config);
    /** @private */
    this.addEvents({
        "statechanged": true
    });

    this.varFormState = {};
    SRFFormStateMgr.superclass.constructor.call(this);
};
Ext.extend(SRFFormStateMgr, Ext.util.Observable, {
    getstate: function(_1) { return $V(this.varFormState[_1.toLowerCase()], false); },
    setstate: function(_1) { this.varFormState = {}; Ext.apply(this.varFormState, _1); this.fireEvent("statechanged", this); }
   , rfdestroy: function() {
       this.purgeListeners();
       delete this.varFormState;
   }
});


function XMLWriter()
{
        this.XML = [];
        this.Nodes = [];
        this.State = "";
        this.FormatXML = function(Str) {
            if (Str)
                return Str.replace(/&/g, "&amp;").replace(/\"/g, "&quot;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\n/g, "&#xA;").replace(/\r/g, "&#xD;");
            return ""
        }
        this.BeginNode = function(Name) {
            if (!Name) return;
            if (this.State == "beg") this.XML.push(">");
            this.State = "beg";
            this.Nodes.push(Name);
            this.XML.push("<" + Name);
        }
        this.EndNode = function() {
            if (this.State == "beg") {
                this.XML.push("/>");
                this.Nodes.pop();
            }
            else if (this.Nodes.length > 0)
                this.XML.push("</" + this.Nodes.pop() + ">");
            this.State = "";
        }
        this.Attrib = function(Name, Value) {
            if (this.State != "beg" || !Name) return;
            this.XML.push(" " + Name + "=\"" + this.FormatXML(Value) + "\"");
        }
        this.WriteString = function(Value) {
            if (this.State == "beg") this.XML.push(">");
            this.XML.push(this.FormatXML(Value));
            this.State = "";
        }
        this.Node = function(Name, Value) {
            if (!Name) return;
            if (this.State == "beg") this.XML.push(">");
            this.XML.push((Value == "" || !Value) ? "<" + Name + "/>" : "<" + Name + ">" + this.FormatXML(Value) + "</" + Name + ">");
            this.State = "";
        }
        this.Close = function() {
            while (this.Nodes.length > 0)
                this.EndNode();
            this.State = "closed";
        }
        this.ToString = function() { return this.XML.join(""); }
}

