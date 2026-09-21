<%@page contentType="text/html; charset=GBK"%>
<LINK href="../resources/css/ext-all.css" type="text/css"	rel="stylesheet">
<LINK href="../resources/css/xtheme-gray.css" type="text/css" rel="stylesheet">
<LINK href="../sasrfex/css/default/common.css" type="text/css" rel="stylesheet">
<LINK href="../css/lt.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../jscript/ext/ext-all-gridview.js"></script>
<script type="text/javascript" src="../jscript/ext/ux/ColumnHeaderGroup.js"></script>
<script type="text/javascript" src="../sasrfex/javascript/sasrfex.js"></script>
<script type="text/javascript" src="../sasrfex/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="../jscript/lt.js"></script>
<script type="text/javascript">
SRFDA.GridView = function(config) {
    if (config) {
        Ext.apply(this, config);
    }
    if (this.deid) {
        this.varDEId = this.deid;
        delete this.deid;
    }
    if (this.dgmode) {
        this.varDGMode = this.dgmode;
        delete this.dgmode;
    }
    if(this.spid)
    {
        this.varSPId = this.spid;
        delete this.spid;
    }

    this.varPageHeader = null;

    Ext.getDoc().addKeyListener(27, this.closemenu.createDelegate(this));
    Ext.getDoc().on('click', this.closemenu.createDelegate(this));

    if($P.sp[this.varSPId]&&this.spcs)
    {
	    var varForm = $P.sp[this.varSPId].varForm;
	    if(varForm)
	    {
	        $P.form[varForm.formid].on('reseted',this.resetcsm.createDelegate(this));
	    }
    }
}

Ext.extend(SRFDA.GridView, Ext.util.Observable,
{
    closemenu: function() {
        if (window.top && window.top.Ext)
            if (Ext.menu.MenuMgr != window.top.Ext.menu.MenuMgr)
            window.top.Ext.menu.MenuMgr.hideAll();
    },
    dgthememgr: function() {
        var urlparams = { DEID: this.varDEId, DGMODE: this.varDGMode };
        var _URL = '../srfpage/dgthememgrview.jsp?' + Ext.urlEncode(urlparams);
        var ret = SRFUtility.showmodeldialog(_URL, {}, 'resizable:no;scroll:no;status:no;dialogWidth:640px;dialogHeight:480px;', 640, 480);
        if (confirm('是否要重新加载当前视图？')) {
            window.location.reload();
        }
    },
    getpageheader: function() {
        if (this.varPageHeader != null)
            return this.varPageHeader;
        this.varPageHeader = new Ext.BoxComponent({ applyTo: 'north' });
        this.varPageHeader.id = Ext.id();
        this.varPageHeader.region = 'north';
        this.varPageHeader.height = 140;
        return this.varPageHeader;
    },
    resetcsm:function()
    {
    	 var varForm = $P.sp[this.varSPId].varForm;
    	 var varSF = Ext.getDom(this.varSPId+'_cslogic');
    	 if(varSF){
    		 varSF.innerHTML='无逻辑';
    		 varForm._DHC['srfcsm']='';
         }
    }
});


function spcustomsearch(_1)
{
	if($P.mainview==null||$P.mainview==undefined)
		return;
	var varForm = $P.sp[$P.mainview.varSPId].varForm;
	var varLast=varForm._DHC['srfcsm'];
	if(varLast && varLast!='' && varForm._DHC['srfcsmdesc'])
	{
		Ext.getDom($P.mainview.varSPId+'_cslogic').innerHTML=varForm._DHC['srfcsmdesc'].replace('\r\n','<BR>');
	}
	else
	{
		Ext.getDom($P.mainview.varSPId+'_cslogic').innerHTML=$P.msg['spex_nocondition'];	
	}
	var varItemPrivilege=false;

	if(_1!=undefined)
	{
		varItemPrivilege=_1;
	}
	var _DIALOGRESULT = SRFUtility.showmodaldialog('../srfds/customerspformdesigner.jsp?SRFDEID='+$P.mainview.varDEId+'&ITEMPRIVILEGE='+varItemPrivilege.toString(),varLast,'',600,450);
	if(SRFUtility.isNull(_DIALOGRESULT)){return;}
	if(_DIALOGRESULT.spItemModeDesc)
	{
		Ext.getDom($P.mainview.varSPId+'_cslogic').innerHTML=_DIALOGRESULT.spItemModeDesc.replace('\r\n','<BR>');
	}
	else
	{
		Ext.getDom($P.mainview.varSPId+'_cslogic').innerHTML=$P.msg['spex_nocondition'];
	}
	
	if(_DIALOGRESULT.spItemXML)
	{
		varForm._DHC['srfcsm']=_DIALOGRESULT.spItemXML;
		varForm._DHC['srfcsmdesc'] =_DIALOGRESULT.spItemModeDesc;
		varForm.search();
	}
	else
	{
		varForm._DHC['srfcsm']='';
		varForm._DHC['srfcsmdesc'] ='';
		varForm.search();
	}
}


</script>