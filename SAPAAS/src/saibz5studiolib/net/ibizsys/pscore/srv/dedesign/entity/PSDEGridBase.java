/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGridBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGridBase.class);
    public static final String FIELD_AGGMODE = "AGGMODE";
    public static final String FIELD_AGGPSDEACTIONID = "AGGPSDEACTIONID";
    public static final String FIELD_AGGPSDEACTIONNAME = "AGGPSDEACTIONNAME";
    public static final String FIELD_AGGPSDEDSID = "AGGPSDEDSID";
    public static final String FIELD_AGGPSDEDSNAME = "AGGPSDEDSNAME";
    public static final String FIELD_AGGPSDEID = "AGGPSDEID";
    public static final String FIELD_AGGPSDENAME = "AGGPSDENAME";
    public static final String FIELD_AGGPSSYSVIEWPANELID = "AGGPSSYSVIEWPANELID";
    public static final String FIELD_AGGPSSYSVIEWPANELNAME = "AGGPSSYSVIEWPANELNAME";
    public static final String FIELD_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String FIELD_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String FIELD_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String FIELD_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String FIELD_BUFFERRENDERERMODE = "BUFFERRENDERERMODE";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLENABLEFILTER = "COLENABLEFILTER";
    public static final String FIELD_COLENABLELINK = "COLENABLELINK";
    public static final String FIELD_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String FIELD_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_ENABLEEDIT = "ENABLEEDIT";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String FIELD_FORCEFIT = "FORCEFIT";
    public static final String FIELD_FROZENCOL = "FROZENCOL";
    public static final String FIELD_FROZENLASTCOL = "FROZENLASTCOL";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String FIELD_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String FIELD_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String FIELD_GRIDMODEL = "GRIDMODEL";
    public static final String FIELD_GRIDSN = "GRIDSN";
    public static final String FIELD_GRIDSTYLE = "GRIDSTYLE";
    public static final String FIELD_GROUPMODE = "GROUPMODE";
    public static final String FIELD_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String FIELD_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String FIELD_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String FIELD_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String FIELD_GROUPPSDEUAGROUPID = "GROUPPSDEUAGROUPID";
    public static final String FIELD_GROUPPSDEUAGROUPNAME = "GROUPPSDEUAGROUPNAME";
    public static final String FIELD_GROUPPSSYSCSSID = "GROUPPSSYSCSSID";
    public static final String FIELD_GROUPPSSYSCSSNAME = "GROUPPSSYSCSSNAME";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "GROUPPSSYSPFPLUGINID";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "GROUPPSSYSPFPLUGINNAME";
    public static final String FIELD_GROUPSTYLE = "GROUPSTYLE";
    public static final String FIELD_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String FIELD_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";
    public static final String FIELD_IGNOREDSITEM = "IGNOREDSITEM";
    public static final String FIELD_ITEMPSSYSCSSID = "ITEMPSSYSCSSID";
    public static final String FIELD_ITEMPSSYSCSSNAME = "ITEMPSSYSCSSNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String FIELD_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String FIELD_MULTISELECT = "MULTISELECT";
    public static final String FIELD_NAVPSDERID = "NAVPSDERID";
    public static final String FIELD_NAVPSDERNAME = "NAVPSDERNAME";
    public static final String FIELD_NAVPSDEVIEWBASEID = "NAVPSDEVIEWBASEID";
    public static final String FIELD_NAVPSDEVIEWBASENAME = "NAVPSDEVIEWBASENAME";
    public static final String FIELD_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String FIELD_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String FIELD_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String FIELD_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String FIELD_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String FIELD_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String FIELD_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String FIELD_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String FIELD_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String FIELD_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String FIELD_PAGINGSIZE = "PAGINGSIZE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_SHOWHEADER = "SHOWHEADER";
    public static final String FIELD_SORTMODE = "SORTMODE";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_TREEPPSDEFID = "TREEPPSDEFID";
    public static final String FIELD_TREEPPSDEFNAME = "TREEPPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String FIELD_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String FIELD_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    private static final int INDEX_AGGMODE = 0;
    private static final int INDEX_AGGPSDEACTIONID = 1;
    private static final int INDEX_AGGPSDEACTIONNAME = 2;
    private static final int INDEX_AGGPSDEDSID = 3;
    private static final int INDEX_AGGPSDEDSNAME = 4;
    private static final int INDEX_AGGPSDEID = 5;
    private static final int INDEX_AGGPSDENAME = 6;
    private static final int INDEX_AGGPSSYSVIEWPANELID = 7;
    private static final int INDEX_AGGPSSYSVIEWPANELNAME = 8;
    private static final int INDEX_ASYNCPSDEDSID = 9;
    private static final int INDEX_ASYNCPSDEDSNAME = 10;
    private static final int INDEX_BATPSDETOOLBARID = 11;
    private static final int INDEX_BATPSDETOOLBARNAME = 12;
    private static final int INDEX_BUFFERRENDERERMODE = 13;
    private static final int INDEX_BUSYINDICATOR = 14;
    private static final int INDEX_CODENAME = 15;
    private static final int INDEX_COLENABLEFILTER = 16;
    private static final int INDEX_COLENABLELINK = 17;
    private static final int INDEX_COPYPSDEACTIONID = 18;
    private static final int INDEX_COPYPSDEACTIONNAME = 19;
    private static final int INDEX_CREATEDATE = 20;
    private static final int INDEX_CREATEMAN = 21;
    private static final int INDEX_CREATEPSDEACTIONID = 22;
    private static final int INDEX_CREATEPSDEACTIONNAME = 23;
    private static final int INDEX_CUSTOMCOND = 24;
    private static final int INDEX_CUSTOMTYPE = 25;
    private static final int INDEX_DYNAMODELFLAG = 26;
    private static final int INDEX_EMPTYTEXT = 27;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 28;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 29;
    private static final int INDEX_ENABLECUSTOMIZED = 30;
    private static final int INDEX_ENABLEEDIT = 31;
    private static final int INDEX_ENABLEITEMPRIV = 32;
    private static final int INDEX_ENABLEPAGINGBAR = 33;
    private static final int INDEX_FORCEFIT = 34;
    private static final int INDEX_FROZENCOL = 35;
    private static final int INDEX_FROZENLASTCOL = 36;
    private static final int INDEX_GETDRAFTPSDEACTIONID = 37;
    private static final int INDEX_GETDRAFTPSDEACTIONNAME = 38;
    private static final int INDEX_GETPSDEACTIONID = 39;
    private static final int INDEX_GETPSDEACTIONNAME = 40;
    private static final int INDEX_GRIDMODEL = 41;
    private static final int INDEX_GRIDSN = 42;
    private static final int INDEX_GRIDSTYLE = 43;
    private static final int INDEX_GROUPMODE = 44;
    private static final int INDEX_GROUPPSCODELISTID = 45;
    private static final int INDEX_GROUPPSCODELISTNAME = 46;
    private static final int INDEX_GROUPPSDEFID = 47;
    private static final int INDEX_GROUPPSDEFNAME = 48;
    private static final int INDEX_GROUPPSDEUAGROUPID = 49;
    private static final int INDEX_GROUPPSDEUAGROUPNAME = 50;
    private static final int INDEX_GROUPPSSYSCSSID = 51;
    private static final int INDEX_GROUPPSSYSCSSNAME = 52;
    private static final int INDEX_GROUPPSSYSPFPLUGINID = 53;
    private static final int INDEX_GROUPPSSYSPFPLUGINNAME = 54;
    private static final int INDEX_GROUPSTYLE = 55;
    private static final int INDEX_GROUPTEXTPSDEFID = 56;
    private static final int INDEX_GROUPTEXTPSDEFNAME = 57;
    private static final int INDEX_IGNOREDSITEM = 58;
    private static final int INDEX_ITEMPSSYSCSSID = 59;
    private static final int INDEX_ITEMPSSYSCSSNAME = 60;
    private static final int INDEX_LOCKFLAG = 61;
    private static final int INDEX_MEMO = 62;
    private static final int INDEX_MINORSORTDIR = 63;
    private static final int INDEX_MINORSORTPSDEFID = 64;
    private static final int INDEX_MINORSORTPSDEFNAME = 65;
    private static final int INDEX_MOVEPSDEACTIONID = 66;
    private static final int INDEX_MOVEPSDEACTIONNAME = 67;
    private static final int INDEX_MULTISELECT = 68;
    private static final int INDEX_NAVPSDERID = 69;
    private static final int INDEX_NAVPSDERNAME = 70;
    private static final int INDEX_NAVPSDEVIEWBASEID = 71;
    private static final int INDEX_NAVPSDEVIEWBASENAME = 72;
    private static final int INDEX_NAVVIEWFILTER = 73;
    private static final int INDEX_NAVVIEWHEIGHT = 74;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 75;
    private static final int INDEX_NAVVIEWMAXWIDTH = 76;
    private static final int INDEX_NAVVIEWMINHEIGHT = 77;
    private static final int INDEX_NAVVIEWMINWIDTH = 78;
    private static final int INDEX_NAVVIEWPARAM = 79;
    private static final int INDEX_NAVVIEWPOS = 80;
    private static final int INDEX_NAVVIEWSHOWMODE = 81;
    private static final int INDEX_NAVVIEWWIDTH = 82;
    private static final int INDEX_NOSORT = 83;
    private static final int INDEX_ORDERVALUEPSDEFID = 84;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 85;
    private static final int INDEX_PAGINGSIZE = 86;
    private static final int INDEX_PSACHANDLERID = 87;
    private static final int INDEX_PSACHANDLERNAME = 88;
    private static final int INDEX_PSCTRLLOGICGROUPID = 89;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 90;
    private static final int INDEX_PSCTRLMSGID = 91;
    private static final int INDEX_PSCTRLMSGNAME = 92;
    private static final int INDEX_PSDEDATASETID = 93;
    private static final int INDEX_PSDEDATASETNAME = 94;
    private static final int INDEX_PSDEFINPUTTIPSETID = 95;
    private static final int INDEX_PSDEFINPUTTIPSETNAME = 96;
    private static final int INDEX_PSDEGRIDID = 97;
    private static final int INDEX_PSDEGRIDNAME = 98;
    private static final int INDEX_PSDEID = 99;
    private static final int INDEX_PSDENAME = 100;
    private static final int INDEX_PSDYNAINSTID = 101;
    private static final int INDEX_PSSYSCSSID = 102;
    private static final int INDEX_PSSYSCSSNAME = 103;
    private static final int INDEX_PSSYSDYNAMODELID = 104;
    private static final int INDEX_PSSYSDYNAMODELNAME = 105;
    private static final int INDEX_PSSYSPFPLUGINID = 106;
    private static final int INDEX_PSSYSPFPLUGINNAME = 107;
    private static final int INDEX_PSSYSREQITEMID = 108;
    private static final int INDEX_PSSYSREQITEMNAME = 109;
    private static final int INDEX_PSVIEWMSGGROUPID = 110;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 111;
    private static final int INDEX_QUICKPSDETOOLBARID = 112;
    private static final int INDEX_QUICKPSDETOOLBARNAME = 113;
    private static final int INDEX_REMOVEPSDEACTIONID = 114;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 115;
    private static final int INDEX_SHOWHEADER = 116;
    private static final int INDEX_SORTMODE = 117;
    private static final int INDEX_SRFSYSPUB = 118;
    private static final int INDEX_TODOTASK = 119;
    private static final int INDEX_TREEPPSDEFID = 120;
    private static final int INDEX_TREEPPSDEFNAME = 121;
    private static final int INDEX_UPDATEDATE = 122;
    private static final int INDEX_UPDATEMAN = 123;
    private static final int INDEX_UPDATEPSDEACTIONID = 124;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 125;
    private static final int INDEX_USER2PSDEACTIONID = 126;
    private static final int INDEX_USER2PSDEACTIONNAME = 127;
    private static final int INDEX_USERPARAMS = 128;
    private static final int INDEX_USERPSDEACTIONID = 129;
    private static final int INDEX_USERPSDEACTIONNAME = 130;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGridBase proxyPSDEGridBase = null;
    private boolean aggmodeDirtyFlag = false;
    private boolean aggpsdeactionidDirtyFlag = false;
    private boolean aggpsdeactionnameDirtyFlag = false;
    private boolean aggpsdedsidDirtyFlag = false;
    private boolean aggpsdedsnameDirtyFlag = false;
    private boolean aggpsdeidDirtyFlag = false;
    private boolean aggpsdenameDirtyFlag = false;
    private boolean aggpssysviewpanelidDirtyFlag = false;
    private boolean aggpssysviewpanelnameDirtyFlag = false;
    private boolean asyncpsdedsidDirtyFlag = false;
    private boolean asyncpsdedsnameDirtyFlag = false;
    private boolean batpsdetoolbaridDirtyFlag = false;
    private boolean batpsdetoolbarnameDirtyFlag = false;
    private boolean bufferrenderermodeDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colenablefilterDirtyFlag = false;
    private boolean colenablelinkDirtyFlag = false;
    private boolean copypsdeactionidDirtyFlag = false;
    private boolean copypsdeactionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean enableeditDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablepagingbarDirtyFlag = false;
    private boolean forcefitDirtyFlag = false;
    private boolean frozencolDirtyFlag = false;
    private boolean frozenlastcolDirtyFlag = false;
    private boolean getdraftpsdeactionidDirtyFlag = false;
    private boolean getdraftpsdeactionnameDirtyFlag = false;
    private boolean getpsdeactionidDirtyFlag = false;
    private boolean getpsdeactionnameDirtyFlag = false;
    private boolean gridmodelDirtyFlag = false;
    private boolean gridsnDirtyFlag = false;
    private boolean gridstyleDirtyFlag = false;
    private boolean groupmodeDirtyFlag = false;
    private boolean grouppscodelistidDirtyFlag = false;
    private boolean grouppscodelistnameDirtyFlag = false;
    private boolean grouppsdefidDirtyFlag = false;
    private boolean grouppsdefnameDirtyFlag = false;
    private boolean grouppsdeuagroupidDirtyFlag = false;
    private boolean grouppsdeuagroupnameDirtyFlag = false;
    private boolean grouppssyscssidDirtyFlag = false;
    private boolean grouppssyscssnameDirtyFlag = false;
    private boolean grouppssyspfpluginidDirtyFlag = false;
    private boolean grouppssyspfpluginnameDirtyFlag = false;
    private boolean groupstyleDirtyFlag = false;
    private boolean grouptextpsdefidDirtyFlag = false;
    private boolean grouptextpsdefnameDirtyFlag = false;
    private boolean ignoredsitemDirtyFlag = false;
    private boolean itempssyscssidDirtyFlag = false;
    private boolean itempssyscssnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean movepsdeactionidDirtyFlag = false;
    private boolean movepsdeactionnameDirtyFlag = false;
    private boolean multiselectDirtyFlag = false;
    private boolean navpsderidDirtyFlag = false;
    private boolean navpsdernameDirtyFlag = false;
    private boolean navpsdeviewbaseidDirtyFlag = false;
    private boolean navpsdeviewbasenameDirtyFlag = false;
    private boolean navviewfilterDirtyFlag = false;
    private boolean navviewheightDirtyFlag = false;
    private boolean navviewmaxheightDirtyFlag = false;
    private boolean navviewmaxwidthDirtyFlag = false;
    private boolean navviewminheightDirtyFlag = false;
    private boolean navviewminwidthDirtyFlag = false;
    private boolean navviewparamDirtyFlag = false;
    private boolean navviewposDirtyFlag = false;
    private boolean navviewshowmodeDirtyFlag = false;
    private boolean navviewwidthDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean ordervaluepsdefidDirtyFlag = false;
    private boolean ordervaluepsdefnameDirtyFlag = false;
    private boolean pagingsizeDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdefinputtipsetidDirtyFlag = false;
    private boolean psdefinputtipsetnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean quickpsdetoolbaridDirtyFlag = false;
    private boolean quickpsdetoolbarnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean showheaderDirtyFlag = false;
    private boolean sortmodeDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean treeppsdefidDirtyFlag = false;
    private boolean treeppsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean user2psdeactionidDirtyFlag = false;
    private boolean user2psdeactionnameDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean userpsdeactionidDirtyFlag = false;
    private boolean userpsdeactionnameDirtyFlag = false;
    @Column(name="aggmode")
    private String aggmode;
    @Column(name="aggpsdeactionid")
    private String aggpsdeactionid;
    @Column(name="aggpsdeactionname")
    private String aggpsdeactionname;
    @Column(name="aggpsdedsid")
    private String aggpsdedsid;
    @Column(name="aggpsdedsname")
    private String aggpsdedsname;
    @Column(name="aggpsdeid")
    private String aggpsdeid;
    @Column(name="aggpsdename")
    private String aggpsdename;
    @Column(name="aggpssysviewpanelid")
    private String aggpssysviewpanelid;
    @Column(name="aggpssysviewpanelname")
    private String aggpssysviewpanelname;
    @Column(name="asyncpsdedsid")
    private String asyncpsdedsid;
    @Column(name="asyncpsdedsname")
    private String asyncpsdedsname;
    @Column(name="batpsdetoolbarid")
    private String batpsdetoolbarid;
    @Column(name="batpsdetoolbarname")
    private String batpsdetoolbarname;
    @Column(name="bufferrenderermode")
    private Integer bufferrenderermode;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="colenablefilter")
    private Integer colenablefilter;
    @Column(name="colenablelink")
    private Integer colenablelink;
    @Column(name="copypsdeactionid")
    private String copypsdeactionid;
    @Column(name="copypsdeactionname")
    private String copypsdeactionname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createpsdeactionid")
    private String createpsdeactionid;
    @Column(name="createpsdeactionname")
    private String createpsdeactionname;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="enableedit")
    private Integer enableedit;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enablepagingbar")
    private Integer enablepagingbar;
    @Column(name="forcefit")
    private Integer forcefit;
    @Column(name="frozencol")
    private Integer frozencol;
    @Column(name="frozenlastcol")
    private Integer frozenlastcol;
    @Column(name="getdraftpsdeactionid")
    private String getdraftpsdeactionid;
    @Column(name="getdraftpsdeactionname")
    private String getdraftpsdeactionname;
    @Column(name="getpsdeactionid")
    private String getpsdeactionid;
    @Column(name="getpsdeactionname")
    private String getpsdeactionname;
    @Column(name="gridmodel")
    private String gridmodel;
    @Column(name="gridsn")
    private String gridsn;
    @Column(name="gridstyle")
    private String gridstyle;
    @Column(name="groupmode")
    private String groupmode;
    @Column(name="grouppscodelistid")
    private String grouppscodelistid;
    @Column(name="grouppscodelistname")
    private String grouppscodelistname;
    @Column(name="grouppsdefid")
    private String grouppsdefid;
    @Column(name="grouppsdefname")
    private String grouppsdefname;
    @Column(name="grouppsdeuagroupid")
    private String grouppsdeuagroupid;
    @Column(name="grouppsdeuagroupname")
    private String grouppsdeuagroupname;
    @Column(name="grouppssyscssid")
    private String grouppssyscssid;
    @Column(name="grouppssyscssname")
    private String grouppssyscssname;
    @Column(name="grouppssyspfpluginid")
    private String grouppssyspfpluginid;
    @Column(name="grouppssyspfpluginname")
    private String grouppssyspfpluginname;
    @Column(name="groupstyle")
    private String groupstyle;
    @Column(name="grouptextpsdefid")
    private String grouptextpsdefid;
    @Column(name="grouptextpsdefname")
    private String grouptextpsdefname;
    @Column(name="ignoredsitem")
    private Integer ignoredsitem;
    @Column(name="itempssyscssid")
    private String itempssyscssid;
    @Column(name="itempssyscssname")
    private String itempssyscssname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
    @Column(name="movepsdeactionid")
    private String movepsdeactionid;
    @Column(name="movepsdeactionname")
    private String movepsdeactionname;
    @Column(name="multiselect")
    private Integer multiselect;
    @Column(name="navpsderid")
    private String navpsderid;
    @Column(name="navpsdername")
    private String navpsdername;
    @Column(name="navpsdeviewbaseid")
    private String navpsdeviewbaseid;
    @Column(name="navpsdeviewbasename")
    private String navpsdeviewbasename;
    @Column(name="navviewfilter")
    private String navviewfilter;
    @Column(name="navviewheight")
    private Double navviewheight;
    @Column(name="navviewmaxheight")
    private Double navviewmaxheight;
    @Column(name="navviewmaxwidth")
    private Double navviewmaxwidth;
    @Column(name="navviewminheight")
    private Double navviewminheight;
    @Column(name="navviewminwidth")
    private Double navviewminwidth;
    @Column(name="navviewparam")
    private String navviewparam;
    @Column(name="navviewpos")
    private String navviewpos;
    @Column(name="navviewshowmode")
    private Integer navviewshowmode;
    @Column(name="navviewwidth")
    private Double navviewwidth;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="ordervaluepsdefid")
    private String ordervaluepsdefid;
    @Column(name="ordervaluepsdefname")
    private String ordervaluepsdefname;
    @Column(name="pagingsize")
    private Integer pagingsize;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdefinputtipsetid")
    private String psdefinputtipsetid;
    @Column(name="psdefinputtipsetname")
    private String psdefinputtipsetname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="quickpsdetoolbarid")
    private String quickpsdetoolbarid;
    @Column(name="quickpsdetoolbarname")
    private String quickpsdetoolbarname;
    @Column(name="removepsdeactionid")
    private String removepsdeactionid;
    @Column(name="removepsdeactionname")
    private String removepsdeactionname;
    @Column(name="showheader")
    private Integer showheader;
    @Column(name="sortmode")
    private String sortmode;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="todotask")
    private String todotask;
    @Column(name="treeppsdefid")
    private String treeppsdefid;
    @Column(name="treeppsdefname")
    private String treeppsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatepsdeactionid")
    private String updatepsdeactionid;
    @Column(name="updatepsdeactionname")
    private String updatepsdeactionname;
    @Column(name="user2psdeactionid")
    private String user2psdeactionid;
    @Column(name="user2psdeactionname")
    private String user2psdeactionname;
    @Column(name="userparams")
    private String userparams;
    @Column(name="userpsdeactionid")
    private String userpsdeactionid;
    @Column(name="userpsdeactionname")
    private String userpsdeactionname;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objGroupPSCodeListLock = new Integer(1);
    private PSCodeList grouppscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objAggPSDELock = new Integer(1);
    private PSDataEntity aggpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objAggPSDEActionLock = new Integer(1);
    private PSDEAction aggpsdeaction = null;
    private Integer objCopyPSDEActionLock = new Integer(1);
    private PSDEAction copypsdeaction = null;
    private Integer objCreatePSDEActionLock = new Integer(1);
    private PSDEAction createpsdeaction = null;
    private Integer objGetDraftPSDEActionLock = new Integer(1);
    private PSDEAction getdraftpsdeaction = null;
    private Integer objGetPSDEActionLock = new Integer(1);
    private PSDEAction getpsdeaction = null;
    private Integer objMovePSDEActionLock = new Integer(1);
    private PSDEAction movepsdeaction = null;
    private Integer objRemovePSDEActionLock = new Integer(1);
    private PSDEAction removepsdeaction = null;
    private Integer objUpdatePSDEActionLock = new Integer(1);
    private PSDEAction updatepsdeaction = null;
    private Integer objUser2PSDEActionLock = new Integer(1);
    private PSDEAction user2psdeaction = null;
    private Integer objUserPSDEActionLock = new Integer(1);
    private PSDEAction userpsdeaction = null;
    private Integer objAggPSDEDSLock = new Integer(1);
    private PSDEDataSet aggpsdeds = null;
    private Integer objAsyncPSDEDSLock = new Integer(1);
    private PSDEDataSet asyncpsdeds = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objGroupPSDEFLock = new Integer(1);
    private PSDEField grouppsdef = null;
    private Integer objGroupTextPSDEFLock = new Integer(1);
    private PSDEField grouptextpsdef = null;
    private Integer objMinorSortPSDEFLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objOrderValuePSDEFLock = new Integer(1);
    private PSDEField ordervaluepsdef = null;
    private Integer objTreePPSEFLock = new Integer(1);
    private PSDEField treeppsef = null;
    private Integer objPSDEFInputTipSetLock = new Integer(1);
    private PSDEFInputTipSet psdefinputtipset = null;
    private Integer objNavPSDERLock = new Integer(1);
    private PSDER navpsder = null;
    private Integer objBatPSDEToolbarLock = new Integer(1);
    private PSDEToolbar batpsdetoolbar = null;
    private Integer objQuickPSDEToolbarLock = new Integer(1);
    private PSDEToolbar quickpsdetoolbar = null;
    private Integer objGroupPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup grouppsdeuagroup = null;
    private Integer objNavPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase navpsdeviewbase = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objGroupPSSysCssLock = new Integer(1);
    private PSSysCss grouppssyscss = null;
    private Integer objItemPSSysCssLock = new Integer(1);
    private PSSysCss itempssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objGroupPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin grouppssyspfplugin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objAggPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel aggpssysviewpanel = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDEGEIUpdatesLock = new Integer(1);
    private ArrayList<PSDEGEIUpdate> psdegeiupdates = null;
    private Integer objPSDEGridColsLock = new Integer(1);
    private ArrayList<PSDEGridCol> psdegridcols = null;
    private Integer objPSDEGridLogicsLock = new Integer(1);
    private ArrayList<PSDEGridLogic> psdegridlogics = null;

    public void setAggMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggmode = string;
        this.aggmodeDirtyFlag = true;
    }

    public String getAggMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggMode();
        }
        return this.aggmode;
    }

    public boolean isAggModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggModeDirty();
        }
        return this.aggmodeDirtyFlag;
    }

    public void resetAggMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggMode();
            return;
        }
        this.aggmodeDirtyFlag = false;
        this.aggmode = null;
    }

    public void setAggPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdeactionid = string;
        this.aggpsdeactionidDirtyFlag = true;
    }

    public String getAggPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEActionId();
        }
        return this.aggpsdeactionid;
    }

    public boolean isAggPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDEActionIdDirty();
        }
        return this.aggpsdeactionidDirtyFlag;
    }

    public void resetAggPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEActionId();
            return;
        }
        this.aggpsdeactionidDirtyFlag = false;
        this.aggpsdeactionid = null;
    }

    public void setAggPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdeactionname = string;
        this.aggpsdeactionnameDirtyFlag = true;
    }

    public String getAggPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEActionName();
        }
        return this.aggpsdeactionname;
    }

    public boolean isAggPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDEActionNameDirty();
        }
        return this.aggpsdeactionnameDirtyFlag;
    }

    public void resetAggPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEActionName();
            return;
        }
        this.aggpsdeactionnameDirtyFlag = false;
        this.aggpsdeactionname = null;
    }

    public void setAggPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdedsid = string;
        this.aggpsdedsidDirtyFlag = true;
    }

    public String getAggPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEDSId();
        }
        return this.aggpsdedsid;
    }

    public boolean isAggPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDEDSIdDirty();
        }
        return this.aggpsdedsidDirtyFlag;
    }

    public void resetAggPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEDSId();
            return;
        }
        this.aggpsdedsidDirtyFlag = false;
        this.aggpsdedsid = null;
    }

    public void setAggPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdedsname = string;
        this.aggpsdedsnameDirtyFlag = true;
    }

    public String getAggPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEDSName();
        }
        return this.aggpsdedsname;
    }

    public boolean isAggPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDEDSNameDirty();
        }
        return this.aggpsdedsnameDirtyFlag;
    }

    public void resetAggPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEDSName();
            return;
        }
        this.aggpsdedsnameDirtyFlag = false;
        this.aggpsdedsname = null;
    }

    public void setAggPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdeid = string;
        this.aggpsdeidDirtyFlag = true;
    }

    public String getAggPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEId();
        }
        return this.aggpsdeid;
    }

    public boolean isAggPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDEIdDirty();
        }
        return this.aggpsdeidDirtyFlag;
    }

    public void resetAggPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEId();
            return;
        }
        this.aggpsdeidDirtyFlag = false;
        this.aggpsdeid = null;
    }

    public void setAggPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpsdename = string;
        this.aggpsdenameDirtyFlag = true;
    }

    public String getAggPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEName();
        }
        return this.aggpsdename;
    }

    public boolean isAggPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSDENameDirty();
        }
        return this.aggpsdenameDirtyFlag;
    }

    public void resetAggPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSDEName();
            return;
        }
        this.aggpsdenameDirtyFlag = false;
        this.aggpsdename = null;
    }

    public void setAggPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpssysviewpanelid = string;
        this.aggpssysviewpanelidDirtyFlag = true;
    }

    public String getAggPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSSysViewPanelId();
        }
        return this.aggpssysviewpanelid;
    }

    public boolean isAggPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSSysViewPanelIdDirty();
        }
        return this.aggpssysviewpanelidDirtyFlag;
    }

    public void resetAggPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSSysViewPanelId();
            return;
        }
        this.aggpssysviewpanelidDirtyFlag = false;
        this.aggpssysviewpanelid = null;
    }

    public void setAggPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggpssysviewpanelname = string;
        this.aggpssysviewpanelnameDirtyFlag = true;
    }

    public String getAggPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSSysViewPanelName();
        }
        return this.aggpssysviewpanelname;
    }

    public boolean isAggPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggPSSysViewPanelNameDirty();
        }
        return this.aggpssysviewpanelnameDirtyFlag;
    }

    public void resetAggPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggPSSysViewPanelName();
            return;
        }
        this.aggpssysviewpanelnameDirtyFlag = false;
        this.aggpssysviewpanelname = null;
    }

    public void setAsyncPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAsyncPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asyncpsdedsid = string;
        this.asyncpsdedsidDirtyFlag = true;
    }

    public String getAsyncPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDSId();
        }
        return this.asyncpsdedsid;
    }

    public boolean isAsyncPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAsyncPSDEDSIdDirty();
        }
        return this.asyncpsdedsidDirtyFlag;
    }

    public void resetAsyncPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAsyncPSDEDSId();
            return;
        }
        this.asyncpsdedsidDirtyFlag = false;
        this.asyncpsdedsid = null;
    }

    public void setAsyncPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAsyncPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.asyncpsdedsname = string;
        this.asyncpsdedsnameDirtyFlag = true;
    }

    public String getAsyncPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDSName();
        }
        return this.asyncpsdedsname;
    }

    public boolean isAsyncPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAsyncPSDEDSNameDirty();
        }
        return this.asyncpsdedsnameDirtyFlag;
    }

    public void resetAsyncPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAsyncPSDEDSName();
            return;
        }
        this.asyncpsdedsnameDirtyFlag = false;
        this.asyncpsdedsname = null;
    }

    public void setBatPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.batpsdetoolbarid = string;
        this.batpsdetoolbaridDirtyFlag = true;
    }

    public String getBatPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbarId();
        }
        return this.batpsdetoolbarid;
    }

    public boolean isBatPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatPSDEToolbarIdDirty();
        }
        return this.batpsdetoolbaridDirtyFlag;
    }

    public void resetBatPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatPSDEToolbarId();
            return;
        }
        this.batpsdetoolbaridDirtyFlag = false;
        this.batpsdetoolbarid = null;
    }

    public void setBatPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBatPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.batpsdetoolbarname = string;
        this.batpsdetoolbarnameDirtyFlag = true;
    }

    public String getBatPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbarName();
        }
        return this.batpsdetoolbarname;
    }

    public boolean isBatPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBatPSDEToolbarNameDirty();
        }
        return this.batpsdetoolbarnameDirtyFlag;
    }

    public void resetBatPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBatPSDEToolbarName();
            return;
        }
        this.batpsdetoolbarnameDirtyFlag = false;
        this.batpsdetoolbarname = null;
    }

    public void setBufferRendererMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBufferRendererMode(n);
            return;
        }
        this.bufferrenderermode = n;
        this.bufferrenderermodeDirtyFlag = true;
    }

    public Integer getBufferRendererMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBufferRendererMode();
        }
        return this.bufferrenderermode;
    }

    public boolean isBufferRendererModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBufferRendererModeDirty();
        }
        return this.bufferrenderermodeDirtyFlag;
    }

    public void resetBufferRendererMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBufferRendererMode();
            return;
        }
        this.bufferrenderermodeDirtyFlag = false;
        this.bufferrenderermode = null;
    }

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setColEnableFilter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableFilter(n);
            return;
        }
        this.colenablefilter = n;
        this.colenablefilterDirtyFlag = true;
    }

    public Integer getColEnableFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableFilter();
        }
        return this.colenablefilter;
    }

    public boolean isColEnableFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableFilterDirty();
        }
        return this.colenablefilterDirtyFlag;
    }

    public void resetColEnableFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableFilter();
            return;
        }
        this.colenablefilterDirtyFlag = false;
        this.colenablefilter = null;
    }

    public void setColEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableLink(n);
            return;
        }
        this.colenablelink = n;
        this.colenablelinkDirtyFlag = true;
    }

    public Integer getColEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableLink();
        }
        return this.colenablelink;
    }

    public boolean isColEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableLinkDirty();
        }
        return this.colenablelinkDirtyFlag;
    }

    public void resetColEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableLink();
            return;
        }
        this.colenablelinkDirtyFlag = false;
        this.colenablelink = null;
    }

    public void setCopyPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCopyPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.copypsdeactionid = string;
        this.copypsdeactionidDirtyFlag = true;
    }

    public String getCopyPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEActionId();
        }
        return this.copypsdeactionid;
    }

    public boolean isCopyPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCopyPSDEActionIdDirty();
        }
        return this.copypsdeactionidDirtyFlag;
    }

    public void resetCopyPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCopyPSDEActionId();
            return;
        }
        this.copypsdeactionidDirtyFlag = false;
        this.copypsdeactionid = null;
    }

    public void setCopyPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCopyPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.copypsdeactionname = string;
        this.copypsdeactionnameDirtyFlag = true;
    }

    public String getCopyPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEActionName();
        }
        return this.copypsdeactionname;
    }

    public boolean isCopyPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCopyPSDEActionNameDirty();
        }
        return this.copypsdeactionnameDirtyFlag;
    }

    public void resetCopyPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCopyPSDEActionName();
            return;
        }
        this.copypsdeactionnameDirtyFlag = false;
        this.copypsdeactionname = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCreatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionid = string;
        this.createpsdeactionidDirtyFlag = true;
    }

    public String getCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionId();
        }
        return this.createpsdeactionid;
    }

    public boolean isCreatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionIdDirty();
        }
        return this.createpsdeactionidDirtyFlag;
    }

    public void resetCreatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionId();
            return;
        }
        this.createpsdeactionidDirtyFlag = false;
        this.createpsdeactionid = null;
    }

    public void setCreatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeactionname = string;
        this.createpsdeactionnameDirtyFlag = true;
    }

    public String getCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEActionName();
        }
        return this.createpsdeactionname;
    }

    public boolean isCreatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEActionNameDirty();
        }
        return this.createpsdeactionnameDirtyFlag;
    }

    public void resetCreatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEActionName();
            return;
        }
        this.createpsdeactionnameDirtyFlag = false;
        this.createpsdeactionname = null;
    }

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytext = string;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresid = string;
        this.emptytextpslanresidDirtyFlag = true;
    }

    public String getEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResId();
        }
        return this.emptytextpslanresid;
    }

    public boolean isEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResIdDirty();
        }
        return this.emptytextpslanresidDirtyFlag;
    }

    public void resetEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResId();
            return;
        }
        this.emptytextpslanresidDirtyFlag = false;
        this.emptytextpslanresid = null;
    }

    public void setEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresname = string;
        this.emptytextpslanresnameDirtyFlag = true;
    }

    public String getEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResName();
        }
        return this.emptytextpslanresname;
    }

    public boolean isEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResNameDirty();
        }
        return this.emptytextpslanresnameDirtyFlag;
    }

    public void resetEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResName();
            return;
        }
        this.emptytextpslanresnameDirtyFlag = false;
        this.emptytextpslanresname = null;
    }

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
    }

    public void setEnableEdit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableEdit(n);
            return;
        }
        this.enableedit = n;
        this.enableeditDirtyFlag = true;
    }

    public Integer getEnableEdit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableEdit();
        }
        return this.enableedit;
    }

    public boolean isEnableEditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableEditDirty();
        }
        return this.enableeditDirtyFlag;
    }

    public void resetEnableEdit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableEdit();
            return;
        }
        this.enableeditDirtyFlag = false;
        this.enableedit = null;
    }

    public void setEnableItemPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemPriv(n);
            return;
        }
        this.enableitempriv = n;
        this.enableitemprivDirtyFlag = true;
    }

    public Integer getEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemPriv();
        }
        return this.enableitempriv;
    }

    public boolean isEnableItemPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemPrivDirty();
        }
        return this.enableitemprivDirtyFlag;
    }

    public void resetEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemPriv();
            return;
        }
        this.enableitemprivDirtyFlag = false;
        this.enableitempriv = null;
    }

    public void setEnablePagingBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePagingBar(n);
            return;
        }
        this.enablepagingbar = n;
        this.enablepagingbarDirtyFlag = true;
    }

    public Integer getEnablePagingBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePagingBar();
        }
        return this.enablepagingbar;
    }

    public boolean isEnablePagingBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePagingBarDirty();
        }
        return this.enablepagingbarDirtyFlag;
    }

    public void resetEnablePagingBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePagingBar();
            return;
        }
        this.enablepagingbarDirtyFlag = false;
        this.enablepagingbar = null;
    }

    public void setForceFit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setForceFit(n);
            return;
        }
        this.forcefit = n;
        this.forcefitDirtyFlag = true;
    }

    public Integer getForceFit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getForceFit();
        }
        return this.forcefit;
    }

    public boolean isForceFitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isForceFitDirty();
        }
        return this.forcefitDirtyFlag;
    }

    public void resetForceFit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetForceFit();
            return;
        }
        this.forcefitDirtyFlag = false;
        this.forcefit = null;
    }

    public void setFrozenCol(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFrozenCol(n);
            return;
        }
        this.frozencol = n;
        this.frozencolDirtyFlag = true;
    }

    public Integer getFrozenCol() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFrozenCol();
        }
        return this.frozencol;
    }

    public boolean isFrozenColDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFrozenColDirty();
        }
        return this.frozencolDirtyFlag;
    }

    public void resetFrozenCol() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFrozenCol();
            return;
        }
        this.frozencolDirtyFlag = false;
        this.frozencol = null;
    }

    public void setFrozenLastCol(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFrozenLastCol(n);
            return;
        }
        this.frozenlastcol = n;
        this.frozenlastcolDirtyFlag = true;
    }

    public Integer getFrozenLastCol() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFrozenLastCol();
        }
        return this.frozenlastcol;
    }

    public boolean isFrozenLastColDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFrozenLastColDirty();
        }
        return this.frozenlastcolDirtyFlag;
    }

    public void resetFrozenLastCol() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFrozenLastCol();
            return;
        }
        this.frozenlastcolDirtyFlag = false;
        this.frozenlastcol = null;
    }

    public void setGetDraftPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDraftPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdraftpsdeactionid = string;
        this.getdraftpsdeactionidDirtyFlag = true;
    }

    public String getGetDraftPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEActionId();
        }
        return this.getdraftpsdeactionid;
    }

    public boolean isGetDraftPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDraftPSDEActionIdDirty();
        }
        return this.getdraftpsdeactionidDirtyFlag;
    }

    public void resetGetDraftPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDraftPSDEActionId();
            return;
        }
        this.getdraftpsdeactionidDirtyFlag = false;
        this.getdraftpsdeactionid = null;
    }

    public void setGetDraftPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDraftPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdraftpsdeactionname = string;
        this.getdraftpsdeactionnameDirtyFlag = true;
    }

    public String getGetDraftPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEActionName();
        }
        return this.getdraftpsdeactionname;
    }

    public boolean isGetDraftPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDraftPSDEActionNameDirty();
        }
        return this.getdraftpsdeactionnameDirtyFlag;
    }

    public void resetGetDraftPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDraftPSDEActionName();
            return;
        }
        this.getdraftpsdeactionnameDirtyFlag = false;
        this.getdraftpsdeactionname = null;
    }

    public void setGetPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getpsdeactionid = string;
        this.getpsdeactionidDirtyFlag = true;
    }

    public String getGetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEActionId();
        }
        return this.getpsdeactionid;
    }

    public boolean isGetPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetPSDEActionIdDirty();
        }
        return this.getpsdeactionidDirtyFlag;
    }

    public void resetGetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetPSDEActionId();
            return;
        }
        this.getpsdeactionidDirtyFlag = false;
        this.getpsdeactionid = null;
    }

    public void setGetPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getpsdeactionname = string;
        this.getpsdeactionnameDirtyFlag = true;
    }

    public String getGetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEActionName();
        }
        return this.getpsdeactionname;
    }

    public boolean isGetPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetPSDEActionNameDirty();
        }
        return this.getpsdeactionnameDirtyFlag;
    }

    public void resetGetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetPSDEActionName();
            return;
        }
        this.getpsdeactionnameDirtyFlag = false;
        this.getpsdeactionname = null;
    }

    public void setGridModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridmodel = string;
        this.gridmodelDirtyFlag = true;
    }

    public String getGridModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridModel();
        }
        return this.gridmodel;
    }

    public boolean isGridModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridModelDirty();
        }
        return this.gridmodelDirtyFlag;
    }

    public void resetGridModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridModel();
            return;
        }
        this.gridmodelDirtyFlag = false;
        this.gridmodel = null;
    }

    public void setGridSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridsn = string;
        this.gridsnDirtyFlag = true;
    }

    public String getGridSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridSN();
        }
        return this.gridsn;
    }

    public boolean isGridSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridSNDirty();
        }
        return this.gridsnDirtyFlag;
    }

    public void resetGridSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridSN();
            return;
        }
        this.gridsnDirtyFlag = false;
        this.gridsn = null;
    }

    public void setGridStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridstyle = string;
        this.gridstyleDirtyFlag = true;
    }

    public String getGridStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridStyle();
        }
        return this.gridstyle;
    }

    public boolean isGridStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridStyleDirty();
        }
        return this.gridstyleDirtyFlag;
    }

    public void resetGridStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridStyle();
            return;
        }
        this.gridstyleDirtyFlag = false;
        this.gridstyle = null;
    }

    public void setGroupMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmode = string;
        this.groupmodeDirtyFlag = true;
    }

    public String getGroupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMode();
        }
        return this.groupmode;
    }

    public boolean isGroupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupModeDirty();
        }
        return this.groupmodeDirtyFlag;
    }

    public void resetGroupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMode();
            return;
        }
        this.groupmodeDirtyFlag = false;
        this.groupmode = null;
    }

    public void setGroupPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppscodelistid = string;
        this.grouppscodelistidDirtyFlag = true;
    }

    public String getGroupPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeListId();
        }
        return this.grouppscodelistid;
    }

    public boolean isGroupPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSCodeListIdDirty();
        }
        return this.grouppscodelistidDirtyFlag;
    }

    public void resetGroupPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSCodeListId();
            return;
        }
        this.grouppscodelistidDirtyFlag = false;
        this.grouppscodelistid = null;
    }

    public void setGroupPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppscodelistname = string;
        this.grouppscodelistnameDirtyFlag = true;
    }

    public String getGroupPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeListName();
        }
        return this.grouppscodelistname;
    }

    public boolean isGroupPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSCodeListNameDirty();
        }
        return this.grouppscodelistnameDirtyFlag;
    }

    public void resetGroupPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSCodeListName();
            return;
        }
        this.grouppscodelistnameDirtyFlag = false;
        this.grouppscodelistname = null;
    }

    public void setGroupPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefid = string;
        this.grouppsdefidDirtyFlag = true;
    }

    public String getGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFId();
        }
        return this.grouppsdefid;
    }

    public boolean isGroupPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFIdDirty();
        }
        return this.grouppsdefidDirtyFlag;
    }

    public void resetGroupPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFId();
            return;
        }
        this.grouppsdefidDirtyFlag = false;
        this.grouppsdefid = null;
    }

    public void setGroupPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdefname = string;
        this.grouppsdefnameDirtyFlag = true;
    }

    public String getGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEFName();
        }
        return this.grouppsdefname;
    }

    public boolean isGroupPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEFNameDirty();
        }
        return this.grouppsdefnameDirtyFlag;
    }

    public void resetGroupPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEFName();
            return;
        }
        this.grouppsdefnameDirtyFlag = false;
        this.grouppsdefname = null;
    }

    public void setGroupPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeuagroupid = string;
        this.grouppsdeuagroupidDirtyFlag = true;
    }

    public String getGroupPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroupId();
        }
        return this.grouppsdeuagroupid;
    }

    public boolean isGroupPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEUAGroupIdDirty();
        }
        return this.grouppsdeuagroupidDirtyFlag;
    }

    public void resetGroupPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEUAGroupId();
            return;
        }
        this.grouppsdeuagroupidDirtyFlag = false;
        this.grouppsdeuagroupid = null;
    }

    public void setGroupPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeuagroupname = string;
        this.grouppsdeuagroupnameDirtyFlag = true;
    }

    public String getGroupPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroupName();
        }
        return this.grouppsdeuagroupname;
    }

    public boolean isGroupPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEUAGroupNameDirty();
        }
        return this.grouppsdeuagroupnameDirtyFlag;
    }

    public void resetGroupPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEUAGroupName();
            return;
        }
        this.grouppsdeuagroupnameDirtyFlag = false;
        this.grouppsdeuagroupname = null;
    }

    public void setGroupPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyscssid = string;
        this.grouppssyscssidDirtyFlag = true;
    }

    public String getGroupPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCssId();
        }
        return this.grouppssyscssid;
    }

    public boolean isGroupPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysCssIdDirty();
        }
        return this.grouppssyscssidDirtyFlag;
    }

    public void resetGroupPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysCssId();
            return;
        }
        this.grouppssyscssidDirtyFlag = false;
        this.grouppssyscssid = null;
    }

    public void setGroupPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyscssname = string;
        this.grouppssyscssnameDirtyFlag = true;
    }

    public String getGroupPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCssName();
        }
        return this.grouppssyscssname;
    }

    public boolean isGroupPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysCssNameDirty();
        }
        return this.grouppssyscssnameDirtyFlag;
    }

    public void resetGroupPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysCssName();
            return;
        }
        this.grouppssyscssnameDirtyFlag = false;
        this.grouppssyscssname = null;
    }

    public void setGroupPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyspfpluginid = string;
        this.grouppssyspfpluginidDirtyFlag = true;
    }

    public String getGroupPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPluginId();
        }
        return this.grouppssyspfpluginid;
    }

    public boolean isGroupPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysPFPluginIdDirty();
        }
        return this.grouppssyspfpluginidDirtyFlag;
    }

    public void resetGroupPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysPFPluginId();
            return;
        }
        this.grouppssyspfpluginidDirtyFlag = false;
        this.grouppssyspfpluginid = null;
    }

    public void setGroupPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppssyspfpluginname = string;
        this.grouppssyspfpluginnameDirtyFlag = true;
    }

    public String getGroupPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPluginName();
        }
        return this.grouppssyspfpluginname;
    }

    public boolean isGroupPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSSysPFPluginNameDirty();
        }
        return this.grouppssyspfpluginnameDirtyFlag;
    }

    public void resetGroupPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSSysPFPluginName();
            return;
        }
        this.grouppssyspfpluginnameDirtyFlag = false;
        this.grouppssyspfpluginname = null;
    }

    public void setGroupStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupstyle = string;
        this.groupstyleDirtyFlag = true;
    }

    public String getGroupStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupStyle();
        }
        return this.groupstyle;
    }

    public boolean isGroupStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupStyleDirty();
        }
        return this.groupstyleDirtyFlag;
    }

    public void resetGroupStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupStyle();
            return;
        }
        this.groupstyleDirtyFlag = false;
        this.groupstyle = null;
    }

    public void setGroupTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptextpsdefid = string;
        this.grouptextpsdefidDirtyFlag = true;
    }

    public String getGroupTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEFId();
        }
        return this.grouptextpsdefid;
    }

    public boolean isGroupTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTextPSDEFIdDirty();
        }
        return this.grouptextpsdefidDirtyFlag;
    }

    public void resetGroupTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTextPSDEFId();
            return;
        }
        this.grouptextpsdefidDirtyFlag = false;
        this.grouptextpsdefid = null;
    }

    public void setGroupTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptextpsdefname = string;
        this.grouptextpsdefnameDirtyFlag = true;
    }

    public String getGroupTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEFName();
        }
        return this.grouptextpsdefname;
    }

    public boolean isGroupTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTextPSDEFNameDirty();
        }
        return this.grouptextpsdefnameDirtyFlag;
    }

    public void resetGroupTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTextPSDEFName();
            return;
        }
        this.grouptextpsdefnameDirtyFlag = false;
        this.grouptextpsdefname = null;
    }

    public void setIgnoreDSItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreDSItem(n);
            return;
        }
        this.ignoredsitem = n;
        this.ignoredsitemDirtyFlag = true;
    }

    public Integer getIgnoreDSItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreDSItem();
        }
        return this.ignoredsitem;
    }

    public boolean isIgnoreDSItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreDSItemDirty();
        }
        return this.ignoredsitemDirtyFlag;
    }

    public void resetIgnoreDSItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreDSItem();
            return;
        }
        this.ignoredsitemDirtyFlag = false;
        this.ignoredsitem = null;
    }

    public void setItemPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempssyscssid = string;
        this.itempssyscssidDirtyFlag = true;
    }

    public String getItemPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysCssId();
        }
        return this.itempssyscssid;
    }

    public boolean isItemPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSSysCssIdDirty();
        }
        return this.itempssyscssidDirtyFlag;
    }

    public void resetItemPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSSysCssId();
            return;
        }
        this.itempssyscssidDirtyFlag = false;
        this.itempssyscssid = null;
    }

    public void setItemPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempssyscssname = string;
        this.itempssyscssnameDirtyFlag = true;
    }

    public String getItemPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysCssName();
        }
        return this.itempssyscssname;
    }

    public boolean isItemPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSSysCssNameDirty();
        }
        return this.itempssyscssnameDirtyFlag;
    }

    public void resetItemPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSSysCssName();
            return;
        }
        this.itempssyscssnameDirtyFlag = false;
        this.itempssyscssname = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMinorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortdir = string;
        this.minorsortdirDirtyFlag = true;
    }

    public String getMinorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortDir();
        }
        return this.minorsortdir;
    }

    public boolean isMinorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortDirDirty();
        }
        return this.minorsortdirDirtyFlag;
    }

    public void resetMinorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortDir();
            return;
        }
        this.minorsortdirDirtyFlag = false;
        this.minorsortdir = null;
    }

    public void setMinorSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefid = string;
        this.minorsortpsdefidDirtyFlag = true;
    }

    public String getMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFId();
        }
        return this.minorsortpsdefid;
    }

    public boolean isMinorSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFIdDirty();
        }
        return this.minorsortpsdefidDirtyFlag;
    }

    public void resetMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFId();
            return;
        }
        this.minorsortpsdefidDirtyFlag = false;
        this.minorsortpsdefid = null;
    }

    public void setMinorSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefname = string;
        this.minorsortpsdefnameDirtyFlag = true;
    }

    public String getMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFName();
        }
        return this.minorsortpsdefname;
    }

    public boolean isMinorSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFNameDirty();
        }
        return this.minorsortpsdefnameDirtyFlag;
    }

    public void resetMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFName();
            return;
        }
        this.minorsortpsdefnameDirtyFlag = false;
        this.minorsortpsdefname = null;
    }

    public void setMovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionid = string;
        this.movepsdeactionidDirtyFlag = true;
    }

    public String getMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionId();
        }
        return this.movepsdeactionid;
    }

    public boolean isMovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionIdDirty();
        }
        return this.movepsdeactionidDirtyFlag;
    }

    public void resetMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionId();
            return;
        }
        this.movepsdeactionidDirtyFlag = false;
        this.movepsdeactionid = null;
    }

    public void setMovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.movepsdeactionname = string;
        this.movepsdeactionnameDirtyFlag = true;
    }

    public String getMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEActionName();
        }
        return this.movepsdeactionname;
    }

    public boolean isMovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMovePSDEActionNameDirty();
        }
        return this.movepsdeactionnameDirtyFlag;
    }

    public void resetMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMovePSDEActionName();
            return;
        }
        this.movepsdeactionnameDirtyFlag = false;
        this.movepsdeactionname = null;
    }

    public void setMultiSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMultiSelect(n);
            return;
        }
        this.multiselect = n;
        this.multiselectDirtyFlag = true;
    }

    public Integer getMultiSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMultiSelect();
        }
        return this.multiselect;
    }

    public boolean isMultiSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMultiSelectDirty();
        }
        return this.multiselectDirtyFlag;
    }

    public void resetMultiSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMultiSelect();
            return;
        }
        this.multiselectDirtyFlag = false;
        this.multiselect = null;
    }

    public void setNavPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navpsderid = string;
        this.navpsderidDirtyFlag = true;
    }

    public String getNavPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDERId();
        }
        return this.navpsderid;
    }

    public boolean isNavPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavPSDERIdDirty();
        }
        return this.navpsderidDirtyFlag;
    }

    public void resetNavPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavPSDERId();
            return;
        }
        this.navpsderidDirtyFlag = false;
        this.navpsderid = null;
    }

    public void setNavPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navpsdername = string;
        this.navpsdernameDirtyFlag = true;
    }

    public String getNavPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDERName();
        }
        return this.navpsdername;
    }

    public boolean isNavPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavPSDERNameDirty();
        }
        return this.navpsdernameDirtyFlag;
    }

    public void resetNavPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavPSDERName();
            return;
        }
        this.navpsdernameDirtyFlag = false;
        this.navpsdername = null;
    }

    public void setNavPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navpsdeviewbaseid = string;
        this.navpsdeviewbaseidDirtyFlag = true;
    }

    public String getNavPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDEViewBaseId();
        }
        return this.navpsdeviewbaseid;
    }

    public boolean isNavPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavPSDEViewBaseIdDirty();
        }
        return this.navpsdeviewbaseidDirtyFlag;
    }

    public void resetNavPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavPSDEViewBaseId();
            return;
        }
        this.navpsdeviewbaseidDirtyFlag = false;
        this.navpsdeviewbaseid = null;
    }

    public void setNavPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navpsdeviewbasename = string;
        this.navpsdeviewbasenameDirtyFlag = true;
    }

    public String getNavPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDEViewBaseName();
        }
        return this.navpsdeviewbasename;
    }

    public boolean isNavPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavPSDEViewBaseNameDirty();
        }
        return this.navpsdeviewbasenameDirtyFlag;
    }

    public void resetNavPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavPSDEViewBaseName();
            return;
        }
        this.navpsdeviewbasenameDirtyFlag = false;
        this.navpsdeviewbasename = null;
    }

    public void setNavViewFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewfilter = string;
        this.navviewfilterDirtyFlag = true;
    }

    public String getNavViewFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewFilter();
        }
        return this.navviewfilter;
    }

    public boolean isNavViewFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewFilterDirty();
        }
        return this.navviewfilterDirtyFlag;
    }

    public void resetNavViewFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewFilter();
            return;
        }
        this.navviewfilterDirtyFlag = false;
        this.navviewfilter = null;
    }

    public void setNavViewHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewHeight(d);
            return;
        }
        this.navviewheight = d;
        this.navviewheightDirtyFlag = true;
    }

    public Double getNavViewHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewHeight();
        }
        return this.navviewheight;
    }

    public boolean isNavViewHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewHeightDirty();
        }
        return this.navviewheightDirtyFlag;
    }

    public void resetNavViewHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewHeight();
            return;
        }
        this.navviewheightDirtyFlag = false;
        this.navviewheight = null;
    }

    public void setNavViewMaxHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMaxHeight(d);
            return;
        }
        this.navviewmaxheight = d;
        this.navviewmaxheightDirtyFlag = true;
    }

    public Double getNavViewMaxHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMaxHeight();
        }
        return this.navviewmaxheight;
    }

    public boolean isNavViewMaxHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMaxHeightDirty();
        }
        return this.navviewmaxheightDirtyFlag;
    }

    public void resetNavViewMaxHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMaxHeight();
            return;
        }
        this.navviewmaxheightDirtyFlag = false;
        this.navviewmaxheight = null;
    }

    public void setNavViewMaxWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMaxWidth(d);
            return;
        }
        this.navviewmaxwidth = d;
        this.navviewmaxwidthDirtyFlag = true;
    }

    public Double getNavViewMaxWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMaxWidth();
        }
        return this.navviewmaxwidth;
    }

    public boolean isNavViewMaxWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMaxWidthDirty();
        }
        return this.navviewmaxwidthDirtyFlag;
    }

    public void resetNavViewMaxWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMaxWidth();
            return;
        }
        this.navviewmaxwidthDirtyFlag = false;
        this.navviewmaxwidth = null;
    }

    public void setNavViewMinHeight(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMinHeight(d);
            return;
        }
        this.navviewminheight = d;
        this.navviewminheightDirtyFlag = true;
    }

    public Double getNavViewMinHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMinHeight();
        }
        return this.navviewminheight;
    }

    public boolean isNavViewMinHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMinHeightDirty();
        }
        return this.navviewminheightDirtyFlag;
    }

    public void resetNavViewMinHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMinHeight();
            return;
        }
        this.navviewminheightDirtyFlag = false;
        this.navviewminheight = null;
    }

    public void setNavViewMinWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewMinWidth(d);
            return;
        }
        this.navviewminwidth = d;
        this.navviewminwidthDirtyFlag = true;
    }

    public Double getNavViewMinWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewMinWidth();
        }
        return this.navviewminwidth;
    }

    public boolean isNavViewMinWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewMinWidthDirty();
        }
        return this.navviewminwidthDirtyFlag;
    }

    public void resetNavViewMinWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewMinWidth();
            return;
        }
        this.navviewminwidthDirtyFlag = false;
        this.navviewminwidth = null;
    }

    public void setNavViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewparam = string;
        this.navviewparamDirtyFlag = true;
    }

    public String getNavViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewParam();
        }
        return this.navviewparam;
    }

    public boolean isNavViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewParamDirty();
        }
        return this.navviewparamDirtyFlag;
    }

    public void resetNavViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewParam();
            return;
        }
        this.navviewparamDirtyFlag = false;
        this.navviewparam = null;
    }

    public void setNavViewPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.navviewpos = string;
        this.navviewposDirtyFlag = true;
    }

    public String getNavViewPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewPos();
        }
        return this.navviewpos;
    }

    public boolean isNavViewPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewPosDirty();
        }
        return this.navviewposDirtyFlag;
    }

    public void resetNavViewPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewPos();
            return;
        }
        this.navviewposDirtyFlag = false;
        this.navviewpos = null;
    }

    public void setNavViewShowMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewShowMode(n);
            return;
        }
        this.navviewshowmode = n;
        this.navviewshowmodeDirtyFlag = true;
    }

    public Integer getNavViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewShowMode();
        }
        return this.navviewshowmode;
    }

    public boolean isNavViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewShowModeDirty();
        }
        return this.navviewshowmodeDirtyFlag;
    }

    public void resetNavViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewShowMode();
            return;
        }
        this.navviewshowmodeDirtyFlag = false;
        this.navviewshowmode = null;
    }

    public void setNavViewWidth(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNavViewWidth(d);
            return;
        }
        this.navviewwidth = d;
        this.navviewwidthDirtyFlag = true;
    }

    public Double getNavViewWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavViewWidth();
        }
        return this.navviewwidth;
    }

    public boolean isNavViewWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNavViewWidthDirty();
        }
        return this.navviewwidthDirtyFlag;
    }

    public void resetNavViewWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNavViewWidth();
            return;
        }
        this.navviewwidthDirtyFlag = false;
        this.navviewwidth = null;
    }

    public void setNoSort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoSort(n);
            return;
        }
        this.nosort = n;
        this.nosortDirtyFlag = true;
    }

    public Integer getNoSort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoSort();
        }
        return this.nosort;
    }

    public boolean isNoSortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoSortDirty();
        }
        return this.nosortDirtyFlag;
    }

    public void resetNoSort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoSort();
            return;
        }
        this.nosortDirtyFlag = false;
        this.nosort = null;
    }

    public void setOrderValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefid = string;
        this.ordervaluepsdefidDirtyFlag = true;
    }

    public String getOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFId();
        }
        return this.ordervaluepsdefid;
    }

    public boolean isOrderValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFIdDirty();
        }
        return this.ordervaluepsdefidDirtyFlag;
    }

    public void resetOrderValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFId();
            return;
        }
        this.ordervaluepsdefidDirtyFlag = false;
        this.ordervaluepsdefid = null;
    }

    public void setOrderValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordervaluepsdefname = string;
        this.ordervaluepsdefnameDirtyFlag = true;
    }

    public String getOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEFName();
        }
        return this.ordervaluepsdefname;
    }

    public boolean isOrderValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValuePSDEFNameDirty();
        }
        return this.ordervaluepsdefnameDirtyFlag;
    }

    public void resetOrderValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValuePSDEFName();
            return;
        }
        this.ordervaluepsdefnameDirtyFlag = false;
        this.ordervaluepsdefname = null;
    }

    public void setPagingSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPagingSize(n);
            return;
        }
        this.pagingsize = n;
        this.pagingsizeDirtyFlag = true;
    }

    public Integer getPagingSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPagingSize();
        }
        return this.pagingsize;
    }

    public boolean isPagingSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPagingSizeDirty();
        }
        return this.pagingsizeDirtyFlag;
    }

    public void resetPagingSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPagingSize();
            return;
        }
        this.pagingsizeDirtyFlag = false;
        this.pagingsize = null;
    }

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEFInputTipSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetid = string;
        this.psdefinputtipsetidDirtyFlag = true;
    }

    public String getPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetId();
        }
        return this.psdefinputtipsetid;
    }

    public boolean isPSDEFInputTipSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetIdDirty();
        }
        return this.psdefinputtipsetidDirtyFlag;
    }

    public void resetPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetId();
            return;
        }
        this.psdefinputtipsetidDirtyFlag = false;
        this.psdefinputtipsetid = null;
    }

    public void setPSDEFInputTipSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetname = string;
        this.psdefinputtipsetnameDirtyFlag = true;
    }

    public String getPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetName();
        }
        return this.psdefinputtipsetname;
    }

    public boolean isPSDEFInputTipSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetNameDirty();
        }
        return this.psdefinputtipsetnameDirtyFlag;
    }

    public void resetPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetName();
            return;
        }
        this.psdefinputtipsetnameDirtyFlag = false;
        this.psdefinputtipsetname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setQuickPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdetoolbarid = string;
        this.quickpsdetoolbaridDirtyFlag = true;
    }

    public String getQuickPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbarId();
        }
        return this.quickpsdetoolbarid;
    }

    public boolean isQuickPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEToolbarIdDirty();
        }
        return this.quickpsdetoolbaridDirtyFlag;
    }

    public void resetQuickPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEToolbarId();
            return;
        }
        this.quickpsdetoolbaridDirtyFlag = false;
        this.quickpsdetoolbarid = null;
    }

    public void setQuickPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdetoolbarname = string;
        this.quickpsdetoolbarnameDirtyFlag = true;
    }

    public String getQuickPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbarName();
        }
        return this.quickpsdetoolbarname;
    }

    public boolean isQuickPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEToolbarNameDirty();
        }
        return this.quickpsdetoolbarnameDirtyFlag;
    }

    public void resetQuickPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEToolbarName();
            return;
        }
        this.quickpsdetoolbarnameDirtyFlag = false;
        this.quickpsdetoolbarname = null;
    }

    public void setRemovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionid = string;
        this.removepsdeactionidDirtyFlag = true;
    }

    public String getRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionId();
        }
        return this.removepsdeactionid;
    }

    public boolean isRemovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionIdDirty();
        }
        return this.removepsdeactionidDirtyFlag;
    }

    public void resetRemovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionId();
            return;
        }
        this.removepsdeactionidDirtyFlag = false;
        this.removepsdeactionid = null;
    }

    public void setRemovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.removepsdeactionname = string;
        this.removepsdeactionnameDirtyFlag = true;
    }

    public String getRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEActionName();
        }
        return this.removepsdeactionname;
    }

    public boolean isRemovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemovePSDEActionNameDirty();
        }
        return this.removepsdeactionnameDirtyFlag;
    }

    public void resetRemovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemovePSDEActionName();
            return;
        }
        this.removepsdeactionnameDirtyFlag = false;
        this.removepsdeactionname = null;
    }

    public void setShowHeader(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowHeader(n);
            return;
        }
        this.showheader = n;
        this.showheaderDirtyFlag = true;
    }

    public Integer getShowHeader() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowHeader();
        }
        return this.showheader;
    }

    public boolean isShowHeaderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowHeaderDirty();
        }
        return this.showheaderDirtyFlag;
    }

    public void resetShowHeader() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowHeader();
            return;
        }
        this.showheaderDirtyFlag = false;
        this.showheader = null;
    }

    public void setSortMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sortmode = string;
        this.sortmodeDirtyFlag = true;
    }

    public String getSortMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortMode();
        }
        return this.sortmode;
    }

    public boolean isSortModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortModeDirty();
        }
        return this.sortmodeDirtyFlag;
    }

    public void resetSortMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortMode();
            return;
        }
        this.sortmodeDirtyFlag = false;
        this.sortmode = null;
    }

    public void setSRFSysPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(n);
            return;
        }
        this.srfsyspub = n;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
    }

    public void setTreePPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreePPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treeppsdefid = string;
        this.treeppsdefidDirtyFlag = true;
    }

    public String getTreePPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreePPSDEFId();
        }
        return this.treeppsdefid;
    }

    public boolean isTreePPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreePPSDEFIdDirty();
        }
        return this.treeppsdefidDirtyFlag;
    }

    public void resetTreePPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreePPSDEFId();
            return;
        }
        this.treeppsdefidDirtyFlag = false;
        this.treeppsdefid = null;
    }

    public void setTreePPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreePPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treeppsdefname = string;
        this.treeppsdefnameDirtyFlag = true;
    }

    public String getTreePPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreePPSDEFName();
        }
        return this.treeppsdefname;
    }

    public boolean isTreePPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreePPSDEFNameDirty();
        }
        return this.treeppsdefnameDirtyFlag;
    }

    public void resetTreePPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreePPSDEFName();
            return;
        }
        this.treeppsdefnameDirtyFlag = false;
        this.treeppsdefname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUpdatePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionid = string;
        this.updatepsdeactionidDirtyFlag = true;
    }

    public String getUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionId();
        }
        return this.updatepsdeactionid;
    }

    public boolean isUpdatePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionIdDirty();
        }
        return this.updatepsdeactionidDirtyFlag;
    }

    public void resetUpdatePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionId();
            return;
        }
        this.updatepsdeactionidDirtyFlag = false;
        this.updatepsdeactionid = null;
    }

    public void setUpdatePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdatePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatepsdeactionname = string;
        this.updatepsdeactionnameDirtyFlag = true;
    }

    public String getUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEActionName();
        }
        return this.updatepsdeactionname;
    }

    public boolean isUpdatePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdatePSDEActionNameDirty();
        }
        return this.updatepsdeactionnameDirtyFlag;
    }

    public void resetUpdatePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdatePSDEActionName();
            return;
        }
        this.updatepsdeactionnameDirtyFlag = false;
        this.updatepsdeactionname = null;
    }

    public void setUser2PSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeactionid = string;
        this.user2psdeactionidDirtyFlag = true;
    }

    public String getUser2PSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEActionId();
        }
        return this.user2psdeactionid;
    }

    public boolean isUser2PSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEActionIdDirty();
        }
        return this.user2psdeactionidDirtyFlag;
    }

    public void resetUser2PSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEActionId();
            return;
        }
        this.user2psdeactionidDirtyFlag = false;
        this.user2psdeactionid = null;
    }

    public void setUser2PSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdeactionname = string;
        this.user2psdeactionnameDirtyFlag = true;
    }

    public String getUser2PSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEActionName();
        }
        return this.user2psdeactionname;
    }

    public boolean isUser2PSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEActionNameDirty();
        }
        return this.user2psdeactionnameDirtyFlag;
    }

    public void resetUser2PSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEActionName();
            return;
        }
        this.user2psdeactionnameDirtyFlag = false;
        this.user2psdeactionname = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeactionid = string;
        this.userpsdeactionidDirtyFlag = true;
    }

    public String getUserPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEActionId();
        }
        return this.userpsdeactionid;
    }

    public boolean isUserPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEActionIdDirty();
        }
        return this.userpsdeactionidDirtyFlag;
    }

    public void resetUserPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEActionId();
            return;
        }
        this.userpsdeactionidDirtyFlag = false;
        this.userpsdeactionid = null;
    }

    public void setUserPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdeactionname = string;
        this.userpsdeactionnameDirtyFlag = true;
    }

    public String getUserPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEActionName();
        }
        return this.userpsdeactionname;
    }

    public boolean isUserPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEActionNameDirty();
        }
        return this.userpsdeactionnameDirtyFlag;
    }

    public void resetUserPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEActionName();
            return;
        }
        this.userpsdeactionnameDirtyFlag = false;
        this.userpsdeactionname = null;
    }

    protected void onReset() {
        PSDEGridBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGridBase pSDEGridBase) {
        pSDEGridBase.resetAggMode();
        pSDEGridBase.resetAggPSDEActionId();
        pSDEGridBase.resetAggPSDEActionName();
        pSDEGridBase.resetAggPSDEDSId();
        pSDEGridBase.resetAggPSDEDSName();
        pSDEGridBase.resetAggPSDEId();
        pSDEGridBase.resetAggPSDEName();
        pSDEGridBase.resetAggPSSysViewPanelId();
        pSDEGridBase.resetAggPSSysViewPanelName();
        pSDEGridBase.resetAsyncPSDEDSId();
        pSDEGridBase.resetAsyncPSDEDSName();
        pSDEGridBase.resetBatPSDEToolbarId();
        pSDEGridBase.resetBatPSDEToolbarName();
        pSDEGridBase.resetBufferRendererMode();
        pSDEGridBase.resetBusyIndicator();
        pSDEGridBase.resetCodeName();
        pSDEGridBase.resetColEnableFilter();
        pSDEGridBase.resetColEnableLink();
        pSDEGridBase.resetCopyPSDEActionId();
        pSDEGridBase.resetCopyPSDEActionName();
        pSDEGridBase.resetCreateDate();
        pSDEGridBase.resetCreateMan();
        pSDEGridBase.resetCreatePSDEActionId();
        pSDEGridBase.resetCreatePSDEActionName();
        pSDEGridBase.resetCustomCond();
        pSDEGridBase.resetCustomType();
        pSDEGridBase.resetDynaModelFlag();
        pSDEGridBase.resetEmptyText();
        pSDEGridBase.resetEmptyTextPSLanResId();
        pSDEGridBase.resetEmptyTextPSLanResName();
        pSDEGridBase.resetEnableCustomized();
        pSDEGridBase.resetEnableEdit();
        pSDEGridBase.resetEnableItemPriv();
        pSDEGridBase.resetEnablePagingBar();
        pSDEGridBase.resetForceFit();
        pSDEGridBase.resetFrozenCol();
        pSDEGridBase.resetFrozenLastCol();
        pSDEGridBase.resetGetDraftPSDEActionId();
        pSDEGridBase.resetGetDraftPSDEActionName();
        pSDEGridBase.resetGetPSDEActionId();
        pSDEGridBase.resetGetPSDEActionName();
        pSDEGridBase.resetGridModel();
        pSDEGridBase.resetGridSN();
        pSDEGridBase.resetGridStyle();
        pSDEGridBase.resetGroupMode();
        pSDEGridBase.resetGroupPSCodeListId();
        pSDEGridBase.resetGroupPSCodeListName();
        pSDEGridBase.resetGroupPSDEFId();
        pSDEGridBase.resetGroupPSDEFName();
        pSDEGridBase.resetGroupPSDEUAGroupId();
        pSDEGridBase.resetGroupPSDEUAGroupName();
        pSDEGridBase.resetGroupPSSysCssId();
        pSDEGridBase.resetGroupPSSysCssName();
        pSDEGridBase.resetGroupPSSysPFPluginId();
        pSDEGridBase.resetGroupPSSysPFPluginName();
        pSDEGridBase.resetGroupStyle();
        pSDEGridBase.resetGroupTextPSDEFId();
        pSDEGridBase.resetGroupTextPSDEFName();
        pSDEGridBase.resetIgnoreDSItem();
        pSDEGridBase.resetItemPSSysCssId();
        pSDEGridBase.resetItemPSSysCssName();
        pSDEGridBase.resetLockFlag();
        pSDEGridBase.resetMemo();
        pSDEGridBase.resetMinorSortDir();
        pSDEGridBase.resetMinorSortPSDEFId();
        pSDEGridBase.resetMinorSortPSDEFName();
        pSDEGridBase.resetMovePSDEActionId();
        pSDEGridBase.resetMovePSDEActionName();
        pSDEGridBase.resetMultiSelect();
        pSDEGridBase.resetNavPSDERId();
        pSDEGridBase.resetNavPSDERName();
        pSDEGridBase.resetNavPSDEViewBaseId();
        pSDEGridBase.resetNavPSDEViewBaseName();
        pSDEGridBase.resetNavViewFilter();
        pSDEGridBase.resetNavViewHeight();
        pSDEGridBase.resetNavViewMaxHeight();
        pSDEGridBase.resetNavViewMaxWidth();
        pSDEGridBase.resetNavViewMinHeight();
        pSDEGridBase.resetNavViewMinWidth();
        pSDEGridBase.resetNavViewParam();
        pSDEGridBase.resetNavViewPos();
        pSDEGridBase.resetNavViewShowMode();
        pSDEGridBase.resetNavViewWidth();
        pSDEGridBase.resetNoSort();
        pSDEGridBase.resetOrderValuePSDEFId();
        pSDEGridBase.resetOrderValuePSDEFName();
        pSDEGridBase.resetPagingSize();
        pSDEGridBase.resetPSACHandlerId();
        pSDEGridBase.resetPSACHandlerName();
        pSDEGridBase.resetPSCtrlLogicGroupId();
        pSDEGridBase.resetPSCtrlLogicGroupName();
        pSDEGridBase.resetPSCtrlMsgId();
        pSDEGridBase.resetPSCtrlMsgName();
        pSDEGridBase.resetPSDEDataSetId();
        pSDEGridBase.resetPSDEDataSetName();
        pSDEGridBase.resetPSDEFInputTipSetId();
        pSDEGridBase.resetPSDEFInputTipSetName();
        pSDEGridBase.resetPSDEGridId();
        pSDEGridBase.resetPSDEGridName();
        pSDEGridBase.resetPSDEId();
        pSDEGridBase.resetPSDEName();
        pSDEGridBase.resetPSDynaInstId();
        pSDEGridBase.resetPSSysCssId();
        pSDEGridBase.resetPSSysCssName();
        pSDEGridBase.resetPSSysDynaModelId();
        pSDEGridBase.resetPSSysDynaModelName();
        pSDEGridBase.resetPSSysPFPluginId();
        pSDEGridBase.resetPSSysPFPluginName();
        pSDEGridBase.resetPSSysReqItemId();
        pSDEGridBase.resetPSSysReqItemName();
        pSDEGridBase.resetPSViewMsgGroupId();
        pSDEGridBase.resetPSViewMsgGroupName();
        pSDEGridBase.resetQuickPSDEToolbarId();
        pSDEGridBase.resetQuickPSDEToolbarName();
        pSDEGridBase.resetRemovePSDEActionId();
        pSDEGridBase.resetRemovePSDEActionName();
        pSDEGridBase.resetShowHeader();
        pSDEGridBase.resetSortMode();
        pSDEGridBase.resetSRFSysPub();
        pSDEGridBase.resetToDoTask();
        pSDEGridBase.resetTreePPSDEFId();
        pSDEGridBase.resetTreePPSDEFName();
        pSDEGridBase.resetUpdateDate();
        pSDEGridBase.resetUpdateMan();
        pSDEGridBase.resetUpdatePSDEActionId();
        pSDEGridBase.resetUpdatePSDEActionName();
        pSDEGridBase.resetUser2PSDEActionId();
        pSDEGridBase.resetUser2PSDEActionName();
        pSDEGridBase.resetUserParams();
        pSDEGridBase.resetUserPSDEActionId();
        pSDEGridBase.resetUserPSDEActionName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggModeDirty()) {
            hashMap.put(FIELD_AGGMODE, this.getAggMode());
        }
        if (!bl || this.isAggPSDEActionIdDirty()) {
            hashMap.put(FIELD_AGGPSDEACTIONID, this.getAggPSDEActionId());
        }
        if (!bl || this.isAggPSDEActionNameDirty()) {
            hashMap.put(FIELD_AGGPSDEACTIONNAME, this.getAggPSDEActionName());
        }
        if (!bl || this.isAggPSDEDSIdDirty()) {
            hashMap.put(FIELD_AGGPSDEDSID, this.getAggPSDEDSId());
        }
        if (!bl || this.isAggPSDEDSNameDirty()) {
            hashMap.put(FIELD_AGGPSDEDSNAME, this.getAggPSDEDSName());
        }
        if (!bl || this.isAggPSDEIdDirty()) {
            hashMap.put(FIELD_AGGPSDEID, this.getAggPSDEId());
        }
        if (!bl || this.isAggPSDENameDirty()) {
            hashMap.put(FIELD_AGGPSDENAME, this.getAggPSDEName());
        }
        if (!bl || this.isAggPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_AGGPSSYSVIEWPANELID, this.getAggPSSysViewPanelId());
        }
        if (!bl || this.isAggPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_AGGPSSYSVIEWPANELNAME, this.getAggPSSysViewPanelName());
        }
        if (!bl || this.isAsyncPSDEDSIdDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSID, this.getAsyncPSDEDSId());
        }
        if (!bl || this.isAsyncPSDEDSNameDirty()) {
            hashMap.put(FIELD_ASYNCPSDEDSNAME, this.getAsyncPSDEDSName());
        }
        if (!bl || this.isBatPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_BATPSDETOOLBARID, this.getBatPSDEToolbarId());
        }
        if (!bl || this.isBatPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_BATPSDETOOLBARNAME, this.getBatPSDEToolbarName());
        }
        if (!bl || this.isBufferRendererModeDirty()) {
            hashMap.put(FIELD_BUFFERRENDERERMODE, this.getBufferRendererMode());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColEnableFilterDirty()) {
            hashMap.put(FIELD_COLENABLEFILTER, this.getColEnableFilter());
        }
        if (!bl || this.isColEnableLinkDirty()) {
            hashMap.put(FIELD_COLENABLELINK, this.getColEnableLink());
        }
        if (!bl || this.isCopyPSDEActionIdDirty()) {
            hashMap.put(FIELD_COPYPSDEACTIONID, this.getCopyPSDEActionId());
        }
        if (!bl || this.isCopyPSDEActionNameDirty()) {
            hashMap.put(FIELD_COPYPSDEACTIONNAME, this.getCopyPSDEActionName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreatePSDEActionIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONID, this.getCreatePSDEActionId());
        }
        if (!bl || this.isCreatePSDEActionNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEACTIONNAME, this.getCreatePSDEActionName());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isEnableEditDirty()) {
            hashMap.put(FIELD_ENABLEEDIT, this.getEnableEdit());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnablePagingBarDirty()) {
            hashMap.put(FIELD_ENABLEPAGINGBAR, this.getEnablePagingBar());
        }
        if (!bl || this.isForceFitDirty()) {
            hashMap.put(FIELD_FORCEFIT, this.getForceFit());
        }
        if (!bl || this.isFrozenColDirty()) {
            hashMap.put(FIELD_FROZENCOL, this.getFrozenCol());
        }
        if (!bl || this.isFrozenLastColDirty()) {
            hashMap.put(FIELD_FROZENLASTCOL, this.getFrozenLastCol());
        }
        if (!bl || this.isGetDraftPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETDRAFTPSDEACTIONID, this.getGetDraftPSDEActionId());
        }
        if (!bl || this.isGetDraftPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETDRAFTPSDEACTIONNAME, this.getGetDraftPSDEActionName());
        }
        if (!bl || this.isGetPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONID, this.getGetPSDEActionId());
        }
        if (!bl || this.isGetPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETPSDEACTIONNAME, this.getGetPSDEActionName());
        }
        if (!bl || this.isGridModelDirty()) {
            hashMap.put(FIELD_GRIDMODEL, this.getGridModel());
        }
        if (!bl || this.isGridSNDirty()) {
            hashMap.put(FIELD_GRIDSN, this.getGridSN());
        }
        if (!bl || this.isGridStyleDirty()) {
            hashMap.put(FIELD_GRIDSTYLE, this.getGridStyle());
        }
        if (!bl || this.isGroupModeDirty()) {
            hashMap.put(FIELD_GROUPMODE, this.getGroupMode());
        }
        if (!bl || this.isGroupPSCodeListIdDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTID, this.getGroupPSCodeListId());
        }
        if (!bl || this.isGroupPSCodeListNameDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTNAME, this.getGroupPSCodeListName());
        }
        if (!bl || this.isGroupPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEFID, this.getGroupPSDEFId());
        }
        if (!bl || this.isGroupPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEFNAME, this.getGroupPSDEFName());
        }
        if (!bl || this.isGroupPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEUAGROUPID, this.getGroupPSDEUAGroupId());
        }
        if (!bl || this.isGroupPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_GROUPPSDEUAGROUPNAME, this.getGroupPSDEUAGroupName());
        }
        if (!bl || this.isGroupPSSysCssIdDirty()) {
            hashMap.put(FIELD_GROUPPSSYSCSSID, this.getGroupPSSysCssId());
        }
        if (!bl || this.isGroupPSSysCssNameDirty()) {
            hashMap.put(FIELD_GROUPPSSYSCSSNAME, this.getGroupPSSysCssName());
        }
        if (!bl || this.isGroupPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GROUPPSSYSPFPLUGINID, this.getGroupPSSysPFPluginId());
        }
        if (!bl || this.isGroupPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, this.getGroupPSSysPFPluginName());
        }
        if (!bl || this.isGroupStyleDirty()) {
            hashMap.put(FIELD_GROUPSTYLE, this.getGroupStyle());
        }
        if (!bl || this.isGroupTextPSDEFIdDirty()) {
            hashMap.put(FIELD_GROUPTEXTPSDEFID, this.getGroupTextPSDEFId());
        }
        if (!bl || this.isGroupTextPSDEFNameDirty()) {
            hashMap.put(FIELD_GROUPTEXTPSDEFNAME, this.getGroupTextPSDEFName());
        }
        if (!bl || this.isIgnoreDSItemDirty()) {
            hashMap.put(FIELD_IGNOREDSITEM, this.getIgnoreDSItem());
        }
        if (!bl || this.isItemPSSysCssIdDirty()) {
            hashMap.put(FIELD_ITEMPSSYSCSSID, this.getItemPSSysCssId());
        }
        if (!bl || this.isItemPSSysCssNameDirty()) {
            hashMap.put(FIELD_ITEMPSSYSCSSNAME, this.getItemPSSysCssName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isMinorSortPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFID, this.getMinorSortPSDEFId());
        }
        if (!bl || this.isMinorSortPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFNAME, this.getMinorSortPSDEFName());
        }
        if (!bl || this.isMovePSDEActionIdDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONID, this.getMovePSDEActionId());
        }
        if (!bl || this.isMovePSDEActionNameDirty()) {
            hashMap.put(FIELD_MOVEPSDEACTIONNAME, this.getMovePSDEActionName());
        }
        if (!bl || this.isMultiSelectDirty()) {
            hashMap.put(FIELD_MULTISELECT, this.getMultiSelect());
        }
        if (!bl || this.isNavPSDERIdDirty()) {
            hashMap.put(FIELD_NAVPSDERID, this.getNavPSDERId());
        }
        if (!bl || this.isNavPSDERNameDirty()) {
            hashMap.put(FIELD_NAVPSDERNAME, this.getNavPSDERName());
        }
        if (!bl || this.isNavPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_NAVPSDEVIEWBASEID, this.getNavPSDEViewBaseId());
        }
        if (!bl || this.isNavPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_NAVPSDEVIEWBASENAME, this.getNavPSDEViewBaseName());
        }
        if (!bl || this.isNavViewFilterDirty()) {
            hashMap.put(FIELD_NAVVIEWFILTER, this.getNavViewFilter());
        }
        if (!bl || this.isNavViewHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWHEIGHT, this.getNavViewHeight());
        }
        if (!bl || this.isNavViewMaxHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWMAXHEIGHT, this.getNavViewMaxHeight());
        }
        if (!bl || this.isNavViewMaxWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWMAXWIDTH, this.getNavViewMaxWidth());
        }
        if (!bl || this.isNavViewMinHeightDirty()) {
            hashMap.put(FIELD_NAVVIEWMINHEIGHT, this.getNavViewMinHeight());
        }
        if (!bl || this.isNavViewMinWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWMINWIDTH, this.getNavViewMinWidth());
        }
        if (!bl || this.isNavViewParamDirty()) {
            hashMap.put(FIELD_NAVVIEWPARAM, this.getNavViewParam());
        }
        if (!bl || this.isNavViewPosDirty()) {
            hashMap.put(FIELD_NAVVIEWPOS, this.getNavViewPos());
        }
        if (!bl || this.isNavViewShowModeDirty()) {
            hashMap.put(FIELD_NAVVIEWSHOWMODE, this.getNavViewShowMode());
        }
        if (!bl || this.isNavViewWidthDirty()) {
            hashMap.put(FIELD_NAVVIEWWIDTH, this.getNavViewWidth());
        }
        if (!bl || this.isNoSortDirty()) {
            hashMap.put(FIELD_NOSORT, this.getNoSort());
        }
        if (!bl || this.isOrderValuePSDEFIdDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFID, this.getOrderValuePSDEFId());
        }
        if (!bl || this.isOrderValuePSDEFNameDirty()) {
            hashMap.put(FIELD_ORDERVALUEPSDEFNAME, this.getOrderValuePSDEFName());
        }
        if (!bl || this.isPagingSizeDirty()) {
            hashMap.put(FIELD_PAGINGSIZE, this.getPagingSize());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEFInputTipSetIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETID, this.getPSDEFInputTipSetId());
        }
        if (!bl || this.isPSDEFInputTipSetNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETNAME, this.getPSDEFInputTipSetName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isQuickPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_QUICKPSDETOOLBARID, this.getQuickPSDEToolbarId());
        }
        if (!bl || this.isQuickPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_QUICKPSDETOOLBARNAME, this.getQuickPSDEToolbarName());
        }
        if (!bl || this.isRemovePSDEActionIdDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONID, this.getRemovePSDEActionId());
        }
        if (!bl || this.isRemovePSDEActionNameDirty()) {
            hashMap.put(FIELD_REMOVEPSDEACTIONNAME, this.getRemovePSDEActionName());
        }
        if (!bl || this.isShowHeaderDirty()) {
            hashMap.put(FIELD_SHOWHEADER, this.getShowHeader());
        }
        if (!bl || this.isSortModeDirty()) {
            hashMap.put(FIELD_SORTMODE, this.getSortMode());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isTreePPSDEFIdDirty()) {
            hashMap.put(FIELD_TREEPPSDEFID, this.getTreePPSDEFId());
        }
        if (!bl || this.isTreePPSDEFNameDirty()) {
            hashMap.put(FIELD_TREEPPSDEFNAME, this.getTreePPSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUpdatePSDEActionIdDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONID, this.getUpdatePSDEActionId());
        }
        if (!bl || this.isUpdatePSDEActionNameDirty()) {
            hashMap.put(FIELD_UPDATEPSDEACTIONNAME, this.getUpdatePSDEActionName());
        }
        if (!bl || this.isUser2PSDEActionIdDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONID, this.getUser2PSDEActionId());
        }
        if (!bl || this.isUser2PSDEActionNameDirty()) {
            hashMap.put(FIELD_USER2PSDEACTIONNAME, this.getUser2PSDEActionName());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserPSDEActionIdDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONID, this.getUserPSDEActionId());
        }
        if (!bl || this.isUserPSDEActionNameDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONNAME, this.getUserPSDEActionName());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDEGridBase.get(this, n);
    }

    private static Object get(PSDEGridBase pSDEGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridBase.getAggMode();
            }
            case 1: {
                return pSDEGridBase.getAggPSDEActionId();
            }
            case 2: {
                return pSDEGridBase.getAggPSDEActionName();
            }
            case 3: {
                return pSDEGridBase.getAggPSDEDSId();
            }
            case 4: {
                return pSDEGridBase.getAggPSDEDSName();
            }
            case 5: {
                return pSDEGridBase.getAggPSDEId();
            }
            case 6: {
                return pSDEGridBase.getAggPSDEName();
            }
            case 7: {
                return pSDEGridBase.getAggPSSysViewPanelId();
            }
            case 8: {
                return pSDEGridBase.getAggPSSysViewPanelName();
            }
            case 9: {
                return pSDEGridBase.getAsyncPSDEDSId();
            }
            case 10: {
                return pSDEGridBase.getAsyncPSDEDSName();
            }
            case 11: {
                return pSDEGridBase.getBatPSDEToolbarId();
            }
            case 12: {
                return pSDEGridBase.getBatPSDEToolbarName();
            }
            case 13: {
                return pSDEGridBase.getBufferRendererMode();
            }
            case 14: {
                return pSDEGridBase.getBusyIndicator();
            }
            case 15: {
                return pSDEGridBase.getCodeName();
            }
            case 16: {
                return pSDEGridBase.getColEnableFilter();
            }
            case 17: {
                return pSDEGridBase.getColEnableLink();
            }
            case 18: {
                return pSDEGridBase.getCopyPSDEActionId();
            }
            case 19: {
                return pSDEGridBase.getCopyPSDEActionName();
            }
            case 20: {
                return pSDEGridBase.getCreateDate();
            }
            case 21: {
                return pSDEGridBase.getCreateMan();
            }
            case 22: {
                return pSDEGridBase.getCreatePSDEActionId();
            }
            case 23: {
                return pSDEGridBase.getCreatePSDEActionName();
            }
            case 24: {
                return pSDEGridBase.getCustomCond();
            }
            case 25: {
                return pSDEGridBase.getCustomType();
            }
            case 26: {
                return pSDEGridBase.getDynaModelFlag();
            }
            case 27: {
                return pSDEGridBase.getEmptyText();
            }
            case 28: {
                return pSDEGridBase.getEmptyTextPSLanResId();
            }
            case 29: {
                return pSDEGridBase.getEmptyTextPSLanResName();
            }
            case 30: {
                return pSDEGridBase.getEnableCustomized();
            }
            case 31: {
                return pSDEGridBase.getEnableEdit();
            }
            case 32: {
                return pSDEGridBase.getEnableItemPriv();
            }
            case 33: {
                return pSDEGridBase.getEnablePagingBar();
            }
            case 34: {
                return pSDEGridBase.getForceFit();
            }
            case 35: {
                return pSDEGridBase.getFrozenCol();
            }
            case 36: {
                return pSDEGridBase.getFrozenLastCol();
            }
            case 37: {
                return pSDEGridBase.getGetDraftPSDEActionId();
            }
            case 38: {
                return pSDEGridBase.getGetDraftPSDEActionName();
            }
            case 39: {
                return pSDEGridBase.getGetPSDEActionId();
            }
            case 40: {
                return pSDEGridBase.getGetPSDEActionName();
            }
            case 41: {
                return pSDEGridBase.getGridModel();
            }
            case 42: {
                return pSDEGridBase.getGridSN();
            }
            case 43: {
                return pSDEGridBase.getGridStyle();
            }
            case 44: {
                return pSDEGridBase.getGroupMode();
            }
            case 45: {
                return pSDEGridBase.getGroupPSCodeListId();
            }
            case 46: {
                return pSDEGridBase.getGroupPSCodeListName();
            }
            case 47: {
                return pSDEGridBase.getGroupPSDEFId();
            }
            case 48: {
                return pSDEGridBase.getGroupPSDEFName();
            }
            case 49: {
                return pSDEGridBase.getGroupPSDEUAGroupId();
            }
            case 50: {
                return pSDEGridBase.getGroupPSDEUAGroupName();
            }
            case 51: {
                return pSDEGridBase.getGroupPSSysCssId();
            }
            case 52: {
                return pSDEGridBase.getGroupPSSysCssName();
            }
            case 53: {
                return pSDEGridBase.getGroupPSSysPFPluginId();
            }
            case 54: {
                return pSDEGridBase.getGroupPSSysPFPluginName();
            }
            case 55: {
                return pSDEGridBase.getGroupStyle();
            }
            case 56: {
                return pSDEGridBase.getGroupTextPSDEFId();
            }
            case 57: {
                return pSDEGridBase.getGroupTextPSDEFName();
            }
            case 58: {
                return pSDEGridBase.getIgnoreDSItem();
            }
            case 59: {
                return pSDEGridBase.getItemPSSysCssId();
            }
            case 60: {
                return pSDEGridBase.getItemPSSysCssName();
            }
            case 61: {
                return pSDEGridBase.getLockFlag();
            }
            case 62: {
                return pSDEGridBase.getMemo();
            }
            case 63: {
                return pSDEGridBase.getMinorSortDir();
            }
            case 64: {
                return pSDEGridBase.getMinorSortPSDEFId();
            }
            case 65: {
                return pSDEGridBase.getMinorSortPSDEFName();
            }
            case 66: {
                return pSDEGridBase.getMovePSDEActionId();
            }
            case 67: {
                return pSDEGridBase.getMovePSDEActionName();
            }
            case 68: {
                return pSDEGridBase.getMultiSelect();
            }
            case 69: {
                return pSDEGridBase.getNavPSDERId();
            }
            case 70: {
                return pSDEGridBase.getNavPSDERName();
            }
            case 71: {
                return pSDEGridBase.getNavPSDEViewBaseId();
            }
            case 72: {
                return pSDEGridBase.getNavPSDEViewBaseName();
            }
            case 73: {
                return pSDEGridBase.getNavViewFilter();
            }
            case 74: {
                return pSDEGridBase.getNavViewHeight();
            }
            case 75: {
                return pSDEGridBase.getNavViewMaxHeight();
            }
            case 76: {
                return pSDEGridBase.getNavViewMaxWidth();
            }
            case 77: {
                return pSDEGridBase.getNavViewMinHeight();
            }
            case 78: {
                return pSDEGridBase.getNavViewMinWidth();
            }
            case 79: {
                return pSDEGridBase.getNavViewParam();
            }
            case 80: {
                return pSDEGridBase.getNavViewPos();
            }
            case 81: {
                return pSDEGridBase.getNavViewShowMode();
            }
            case 82: {
                return pSDEGridBase.getNavViewWidth();
            }
            case 83: {
                return pSDEGridBase.getNoSort();
            }
            case 84: {
                return pSDEGridBase.getOrderValuePSDEFId();
            }
            case 85: {
                return pSDEGridBase.getOrderValuePSDEFName();
            }
            case 86: {
                return pSDEGridBase.getPagingSize();
            }
            case 87: {
                return pSDEGridBase.getPSACHandlerId();
            }
            case 88: {
                return pSDEGridBase.getPSACHandlerName();
            }
            case 89: {
                return pSDEGridBase.getPSCtrlLogicGroupId();
            }
            case 90: {
                return pSDEGridBase.getPSCtrlLogicGroupName();
            }
            case 91: {
                return pSDEGridBase.getPSCtrlMsgId();
            }
            case 92: {
                return pSDEGridBase.getPSCtrlMsgName();
            }
            case 93: {
                return pSDEGridBase.getPSDEDataSetId();
            }
            case 94: {
                return pSDEGridBase.getPSDEDataSetName();
            }
            case 95: {
                return pSDEGridBase.getPSDEFInputTipSetId();
            }
            case 96: {
                return pSDEGridBase.getPSDEFInputTipSetName();
            }
            case 97: {
                return pSDEGridBase.getPSDEGridId();
            }
            case 98: {
                return pSDEGridBase.getPSDEGridName();
            }
            case 99: {
                return pSDEGridBase.getPSDEId();
            }
            case 100: {
                return pSDEGridBase.getPSDEName();
            }
            case 101: {
                return pSDEGridBase.getPSDynaInstId();
            }
            case 102: {
                return pSDEGridBase.getPSSysCssId();
            }
            case 103: {
                return pSDEGridBase.getPSSysCssName();
            }
            case 104: {
                return pSDEGridBase.getPSSysDynaModelId();
            }
            case 105: {
                return pSDEGridBase.getPSSysDynaModelName();
            }
            case 106: {
                return pSDEGridBase.getPSSysPFPluginId();
            }
            case 107: {
                return pSDEGridBase.getPSSysPFPluginName();
            }
            case 108: {
                return pSDEGridBase.getPSSysReqItemId();
            }
            case 109: {
                return pSDEGridBase.getPSSysReqItemName();
            }
            case 110: {
                return pSDEGridBase.getPSViewMsgGroupId();
            }
            case 111: {
                return pSDEGridBase.getPSViewMsgGroupName();
            }
            case 112: {
                return pSDEGridBase.getQuickPSDEToolbarId();
            }
            case 113: {
                return pSDEGridBase.getQuickPSDEToolbarName();
            }
            case 114: {
                return pSDEGridBase.getRemovePSDEActionId();
            }
            case 115: {
                return pSDEGridBase.getRemovePSDEActionName();
            }
            case 116: {
                return pSDEGridBase.getShowHeader();
            }
            case 117: {
                return pSDEGridBase.getSortMode();
            }
            case 118: {
                return pSDEGridBase.getSRFSysPub();
            }
            case 119: {
                return pSDEGridBase.getToDoTask();
            }
            case 120: {
                return pSDEGridBase.getTreePPSDEFId();
            }
            case 121: {
                return pSDEGridBase.getTreePPSDEFName();
            }
            case 122: {
                return pSDEGridBase.getUpdateDate();
            }
            case 123: {
                return pSDEGridBase.getUpdateMan();
            }
            case 124: {
                return pSDEGridBase.getUpdatePSDEActionId();
            }
            case 125: {
                return pSDEGridBase.getUpdatePSDEActionName();
            }
            case 126: {
                return pSDEGridBase.getUser2PSDEActionId();
            }
            case 127: {
                return pSDEGridBase.getUser2PSDEActionName();
            }
            case 128: {
                return pSDEGridBase.getUserParams();
            }
            case 129: {
                return pSDEGridBase.getUserPSDEActionId();
            }
            case 130: {
                return pSDEGridBase.getUserPSDEActionName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDEGridBase.set(this, n, object);
    }

    private static void set(PSDEGridBase pSDEGridBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridBase.setAggMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGridBase.setAggPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGridBase.setAggPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGridBase.setAggPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGridBase.setAggPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGridBase.setAggPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGridBase.setAggPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGridBase.setAggPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGridBase.setAggPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGridBase.setAsyncPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGridBase.setAsyncPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGridBase.setBatPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEGridBase.setBatPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGridBase.setBufferRendererMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEGridBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEGridBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGridBase.setColEnableFilter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEGridBase.setColEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEGridBase.setCopyPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGridBase.setCopyPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGridBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDEGridBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGridBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGridBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEGridBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEGridBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEGridBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEGridBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEGridBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEGridBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEGridBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEGridBase.setEnableEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEGridBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEGridBase.setEnablePagingBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEGridBase.setForceFit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDEGridBase.setFrozenCol(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDEGridBase.setFrozenLastCol(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEGridBase.setGetDraftPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEGridBase.setGetDraftPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEGridBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEGridBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEGridBase.setGridModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEGridBase.setGridSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEGridBase.setGridStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEGridBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEGridBase.setGroupPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEGridBase.setGroupPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEGridBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEGridBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEGridBase.setGroupPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEGridBase.setGroupPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEGridBase.setGroupPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEGridBase.setGroupPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEGridBase.setGroupPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEGridBase.setGroupPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEGridBase.setGroupStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEGridBase.setGroupTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEGridBase.setGroupTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEGridBase.setIgnoreDSItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSDEGridBase.setItemPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEGridBase.setItemPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEGridBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSDEGridBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEGridBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEGridBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEGridBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEGridBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEGridBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEGridBase.setMultiSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 69: {
                pSDEGridBase.setNavPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEGridBase.setNavPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEGridBase.setNavPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEGridBase.setNavPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEGridBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEGridBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 75: {
                pSDEGridBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 76: {
                pSDEGridBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 77: {
                pSDEGridBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 78: {
                pSDEGridBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 79: {
                pSDEGridBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEGridBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEGridBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSDEGridBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 83: {
                pSDEGridBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDEGridBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEGridBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEGridBase.setPagingSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDEGridBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEGridBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEGridBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEGridBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEGridBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEGridBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEGridBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEGridBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEGridBase.setPSDEFInputTipSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEGridBase.setPSDEFInputTipSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEGridBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEGridBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEGridBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEGridBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEGridBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEGridBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEGridBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEGridBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEGridBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEGridBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEGridBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEGridBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEGridBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEGridBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEGridBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEGridBase.setQuickPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEGridBase.setQuickPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEGridBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEGridBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEGridBase.setShowHeader(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEGridBase.setSortMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEGridBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 119: {
                pSDEGridBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEGridBase.setTreePPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEGridBase.setTreePPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEGridBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 123: {
                pSDEGridBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDEGridBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEGridBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEGridBase.setUser2PSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEGridBase.setUser2PSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEGridBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEGridBase.setUserPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEGridBase.setUserPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDEGridBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGridBase pSDEGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridBase.getAggMode() == null;
            }
            case 1: {
                return pSDEGridBase.getAggPSDEActionId() == null;
            }
            case 2: {
                return pSDEGridBase.getAggPSDEActionName() == null;
            }
            case 3: {
                return pSDEGridBase.getAggPSDEDSId() == null;
            }
            case 4: {
                return pSDEGridBase.getAggPSDEDSName() == null;
            }
            case 5: {
                return pSDEGridBase.getAggPSDEId() == null;
            }
            case 6: {
                return pSDEGridBase.getAggPSDEName() == null;
            }
            case 7: {
                return pSDEGridBase.getAggPSSysViewPanelId() == null;
            }
            case 8: {
                return pSDEGridBase.getAggPSSysViewPanelName() == null;
            }
            case 9: {
                return pSDEGridBase.getAsyncPSDEDSId() == null;
            }
            case 10: {
                return pSDEGridBase.getAsyncPSDEDSName() == null;
            }
            case 11: {
                return pSDEGridBase.getBatPSDEToolbarId() == null;
            }
            case 12: {
                return pSDEGridBase.getBatPSDEToolbarName() == null;
            }
            case 13: {
                return pSDEGridBase.getBufferRendererMode() == null;
            }
            case 14: {
                return pSDEGridBase.getBusyIndicator() == null;
            }
            case 15: {
                return pSDEGridBase.getCodeName() == null;
            }
            case 16: {
                return pSDEGridBase.getColEnableFilter() == null;
            }
            case 17: {
                return pSDEGridBase.getColEnableLink() == null;
            }
            case 18: {
                return pSDEGridBase.getCopyPSDEActionId() == null;
            }
            case 19: {
                return pSDEGridBase.getCopyPSDEActionName() == null;
            }
            case 20: {
                return pSDEGridBase.getCreateDate() == null;
            }
            case 21: {
                return pSDEGridBase.getCreateMan() == null;
            }
            case 22: {
                return pSDEGridBase.getCreatePSDEActionId() == null;
            }
            case 23: {
                return pSDEGridBase.getCreatePSDEActionName() == null;
            }
            case 24: {
                return pSDEGridBase.getCustomCond() == null;
            }
            case 25: {
                return pSDEGridBase.getCustomType() == null;
            }
            case 26: {
                return pSDEGridBase.getDynaModelFlag() == null;
            }
            case 27: {
                return pSDEGridBase.getEmptyText() == null;
            }
            case 28: {
                return pSDEGridBase.getEmptyTextPSLanResId() == null;
            }
            case 29: {
                return pSDEGridBase.getEmptyTextPSLanResName() == null;
            }
            case 30: {
                return pSDEGridBase.getEnableCustomized() == null;
            }
            case 31: {
                return pSDEGridBase.getEnableEdit() == null;
            }
            case 32: {
                return pSDEGridBase.getEnableItemPriv() == null;
            }
            case 33: {
                return pSDEGridBase.getEnablePagingBar() == null;
            }
            case 34: {
                return pSDEGridBase.getForceFit() == null;
            }
            case 35: {
                return pSDEGridBase.getFrozenCol() == null;
            }
            case 36: {
                return pSDEGridBase.getFrozenLastCol() == null;
            }
            case 37: {
                return pSDEGridBase.getGetDraftPSDEActionId() == null;
            }
            case 38: {
                return pSDEGridBase.getGetDraftPSDEActionName() == null;
            }
            case 39: {
                return pSDEGridBase.getGetPSDEActionId() == null;
            }
            case 40: {
                return pSDEGridBase.getGetPSDEActionName() == null;
            }
            case 41: {
                return pSDEGridBase.getGridModel() == null;
            }
            case 42: {
                return pSDEGridBase.getGridSN() == null;
            }
            case 43: {
                return pSDEGridBase.getGridStyle() == null;
            }
            case 44: {
                return pSDEGridBase.getGroupMode() == null;
            }
            case 45: {
                return pSDEGridBase.getGroupPSCodeListId() == null;
            }
            case 46: {
                return pSDEGridBase.getGroupPSCodeListName() == null;
            }
            case 47: {
                return pSDEGridBase.getGroupPSDEFId() == null;
            }
            case 48: {
                return pSDEGridBase.getGroupPSDEFName() == null;
            }
            case 49: {
                return pSDEGridBase.getGroupPSDEUAGroupId() == null;
            }
            case 50: {
                return pSDEGridBase.getGroupPSDEUAGroupName() == null;
            }
            case 51: {
                return pSDEGridBase.getGroupPSSysCssId() == null;
            }
            case 52: {
                return pSDEGridBase.getGroupPSSysCssName() == null;
            }
            case 53: {
                return pSDEGridBase.getGroupPSSysPFPluginId() == null;
            }
            case 54: {
                return pSDEGridBase.getGroupPSSysPFPluginName() == null;
            }
            case 55: {
                return pSDEGridBase.getGroupStyle() == null;
            }
            case 56: {
                return pSDEGridBase.getGroupTextPSDEFId() == null;
            }
            case 57: {
                return pSDEGridBase.getGroupTextPSDEFName() == null;
            }
            case 58: {
                return pSDEGridBase.getIgnoreDSItem() == null;
            }
            case 59: {
                return pSDEGridBase.getItemPSSysCssId() == null;
            }
            case 60: {
                return pSDEGridBase.getItemPSSysCssName() == null;
            }
            case 61: {
                return pSDEGridBase.getLockFlag() == null;
            }
            case 62: {
                return pSDEGridBase.getMemo() == null;
            }
            case 63: {
                return pSDEGridBase.getMinorSortDir() == null;
            }
            case 64: {
                return pSDEGridBase.getMinorSortPSDEFId() == null;
            }
            case 65: {
                return pSDEGridBase.getMinorSortPSDEFName() == null;
            }
            case 66: {
                return pSDEGridBase.getMovePSDEActionId() == null;
            }
            case 67: {
                return pSDEGridBase.getMovePSDEActionName() == null;
            }
            case 68: {
                return pSDEGridBase.getMultiSelect() == null;
            }
            case 69: {
                return pSDEGridBase.getNavPSDERId() == null;
            }
            case 70: {
                return pSDEGridBase.getNavPSDERName() == null;
            }
            case 71: {
                return pSDEGridBase.getNavPSDEViewBaseId() == null;
            }
            case 72: {
                return pSDEGridBase.getNavPSDEViewBaseName() == null;
            }
            case 73: {
                return pSDEGridBase.getNavViewFilter() == null;
            }
            case 74: {
                return pSDEGridBase.getNavViewHeight() == null;
            }
            case 75: {
                return pSDEGridBase.getNavViewMaxHeight() == null;
            }
            case 76: {
                return pSDEGridBase.getNavViewMaxWidth() == null;
            }
            case 77: {
                return pSDEGridBase.getNavViewMinHeight() == null;
            }
            case 78: {
                return pSDEGridBase.getNavViewMinWidth() == null;
            }
            case 79: {
                return pSDEGridBase.getNavViewParam() == null;
            }
            case 80: {
                return pSDEGridBase.getNavViewPos() == null;
            }
            case 81: {
                return pSDEGridBase.getNavViewShowMode() == null;
            }
            case 82: {
                return pSDEGridBase.getNavViewWidth() == null;
            }
            case 83: {
                return pSDEGridBase.getNoSort() == null;
            }
            case 84: {
                return pSDEGridBase.getOrderValuePSDEFId() == null;
            }
            case 85: {
                return pSDEGridBase.getOrderValuePSDEFName() == null;
            }
            case 86: {
                return pSDEGridBase.getPagingSize() == null;
            }
            case 87: {
                return pSDEGridBase.getPSACHandlerId() == null;
            }
            case 88: {
                return pSDEGridBase.getPSACHandlerName() == null;
            }
            case 89: {
                return pSDEGridBase.getPSCtrlLogicGroupId() == null;
            }
            case 90: {
                return pSDEGridBase.getPSCtrlLogicGroupName() == null;
            }
            case 91: {
                return pSDEGridBase.getPSCtrlMsgId() == null;
            }
            case 92: {
                return pSDEGridBase.getPSCtrlMsgName() == null;
            }
            case 93: {
                return pSDEGridBase.getPSDEDataSetId() == null;
            }
            case 94: {
                return pSDEGridBase.getPSDEDataSetName() == null;
            }
            case 95: {
                return pSDEGridBase.getPSDEFInputTipSetId() == null;
            }
            case 96: {
                return pSDEGridBase.getPSDEFInputTipSetName() == null;
            }
            case 97: {
                return pSDEGridBase.getPSDEGridId() == null;
            }
            case 98: {
                return pSDEGridBase.getPSDEGridName() == null;
            }
            case 99: {
                return pSDEGridBase.getPSDEId() == null;
            }
            case 100: {
                return pSDEGridBase.getPSDEName() == null;
            }
            case 101: {
                return pSDEGridBase.getPSDynaInstId() == null;
            }
            case 102: {
                return pSDEGridBase.getPSSysCssId() == null;
            }
            case 103: {
                return pSDEGridBase.getPSSysCssName() == null;
            }
            case 104: {
                return pSDEGridBase.getPSSysDynaModelId() == null;
            }
            case 105: {
                return pSDEGridBase.getPSSysDynaModelName() == null;
            }
            case 106: {
                return pSDEGridBase.getPSSysPFPluginId() == null;
            }
            case 107: {
                return pSDEGridBase.getPSSysPFPluginName() == null;
            }
            case 108: {
                return pSDEGridBase.getPSSysReqItemId() == null;
            }
            case 109: {
                return pSDEGridBase.getPSSysReqItemName() == null;
            }
            case 110: {
                return pSDEGridBase.getPSViewMsgGroupId() == null;
            }
            case 111: {
                return pSDEGridBase.getPSViewMsgGroupName() == null;
            }
            case 112: {
                return pSDEGridBase.getQuickPSDEToolbarId() == null;
            }
            case 113: {
                return pSDEGridBase.getQuickPSDEToolbarName() == null;
            }
            case 114: {
                return pSDEGridBase.getRemovePSDEActionId() == null;
            }
            case 115: {
                return pSDEGridBase.getRemovePSDEActionName() == null;
            }
            case 116: {
                return pSDEGridBase.getShowHeader() == null;
            }
            case 117: {
                return pSDEGridBase.getSortMode() == null;
            }
            case 118: {
                return pSDEGridBase.getSRFSysPub() == null;
            }
            case 119: {
                return pSDEGridBase.getToDoTask() == null;
            }
            case 120: {
                return pSDEGridBase.getTreePPSDEFId() == null;
            }
            case 121: {
                return pSDEGridBase.getTreePPSDEFName() == null;
            }
            case 122: {
                return pSDEGridBase.getUpdateDate() == null;
            }
            case 123: {
                return pSDEGridBase.getUpdateMan() == null;
            }
            case 124: {
                return pSDEGridBase.getUpdatePSDEActionId() == null;
            }
            case 125: {
                return pSDEGridBase.getUpdatePSDEActionName() == null;
            }
            case 126: {
                return pSDEGridBase.getUser2PSDEActionId() == null;
            }
            case 127: {
                return pSDEGridBase.getUser2PSDEActionName() == null;
            }
            case 128: {
                return pSDEGridBase.getUserParams() == null;
            }
            case 129: {
                return pSDEGridBase.getUserPSDEActionId() == null;
            }
            case 130: {
                return pSDEGridBase.getUserPSDEActionName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDEGridBase.contains(this, n);
    }

    private static boolean contains(PSDEGridBase pSDEGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGridBase.isAggModeDirty();
            }
            case 1: {
                return pSDEGridBase.isAggPSDEActionIdDirty();
            }
            case 2: {
                return pSDEGridBase.isAggPSDEActionNameDirty();
            }
            case 3: {
                return pSDEGridBase.isAggPSDEDSIdDirty();
            }
            case 4: {
                return pSDEGridBase.isAggPSDEDSNameDirty();
            }
            case 5: {
                return pSDEGridBase.isAggPSDEIdDirty();
            }
            case 6: {
                return pSDEGridBase.isAggPSDENameDirty();
            }
            case 7: {
                return pSDEGridBase.isAggPSSysViewPanelIdDirty();
            }
            case 8: {
                return pSDEGridBase.isAggPSSysViewPanelNameDirty();
            }
            case 9: {
                return pSDEGridBase.isAsyncPSDEDSIdDirty();
            }
            case 10: {
                return pSDEGridBase.isAsyncPSDEDSNameDirty();
            }
            case 11: {
                return pSDEGridBase.isBatPSDEToolbarIdDirty();
            }
            case 12: {
                return pSDEGridBase.isBatPSDEToolbarNameDirty();
            }
            case 13: {
                return pSDEGridBase.isBufferRendererModeDirty();
            }
            case 14: {
                return pSDEGridBase.isBusyIndicatorDirty();
            }
            case 15: {
                return pSDEGridBase.isCodeNameDirty();
            }
            case 16: {
                return pSDEGridBase.isColEnableFilterDirty();
            }
            case 17: {
                return pSDEGridBase.isColEnableLinkDirty();
            }
            case 18: {
                return pSDEGridBase.isCopyPSDEActionIdDirty();
            }
            case 19: {
                return pSDEGridBase.isCopyPSDEActionNameDirty();
            }
            case 20: {
                return pSDEGridBase.isCreateDateDirty();
            }
            case 21: {
                return pSDEGridBase.isCreateManDirty();
            }
            case 22: {
                return pSDEGridBase.isCreatePSDEActionIdDirty();
            }
            case 23: {
                return pSDEGridBase.isCreatePSDEActionNameDirty();
            }
            case 24: {
                return pSDEGridBase.isCustomCondDirty();
            }
            case 25: {
                return pSDEGridBase.isCustomTypeDirty();
            }
            case 26: {
                return pSDEGridBase.isDynaModelFlagDirty();
            }
            case 27: {
                return pSDEGridBase.isEmptyTextDirty();
            }
            case 28: {
                return pSDEGridBase.isEmptyTextPSLanResIdDirty();
            }
            case 29: {
                return pSDEGridBase.isEmptyTextPSLanResNameDirty();
            }
            case 30: {
                return pSDEGridBase.isEnableCustomizedDirty();
            }
            case 31: {
                return pSDEGridBase.isEnableEditDirty();
            }
            case 32: {
                return pSDEGridBase.isEnableItemPrivDirty();
            }
            case 33: {
                return pSDEGridBase.isEnablePagingBarDirty();
            }
            case 34: {
                return pSDEGridBase.isForceFitDirty();
            }
            case 35: {
                return pSDEGridBase.isFrozenColDirty();
            }
            case 36: {
                return pSDEGridBase.isFrozenLastColDirty();
            }
            case 37: {
                return pSDEGridBase.isGetDraftPSDEActionIdDirty();
            }
            case 38: {
                return pSDEGridBase.isGetDraftPSDEActionNameDirty();
            }
            case 39: {
                return pSDEGridBase.isGetPSDEActionIdDirty();
            }
            case 40: {
                return pSDEGridBase.isGetPSDEActionNameDirty();
            }
            case 41: {
                return pSDEGridBase.isGridModelDirty();
            }
            case 42: {
                return pSDEGridBase.isGridSNDirty();
            }
            case 43: {
                return pSDEGridBase.isGridStyleDirty();
            }
            case 44: {
                return pSDEGridBase.isGroupModeDirty();
            }
            case 45: {
                return pSDEGridBase.isGroupPSCodeListIdDirty();
            }
            case 46: {
                return pSDEGridBase.isGroupPSCodeListNameDirty();
            }
            case 47: {
                return pSDEGridBase.isGroupPSDEFIdDirty();
            }
            case 48: {
                return pSDEGridBase.isGroupPSDEFNameDirty();
            }
            case 49: {
                return pSDEGridBase.isGroupPSDEUAGroupIdDirty();
            }
            case 50: {
                return pSDEGridBase.isGroupPSDEUAGroupNameDirty();
            }
            case 51: {
                return pSDEGridBase.isGroupPSSysCssIdDirty();
            }
            case 52: {
                return pSDEGridBase.isGroupPSSysCssNameDirty();
            }
            case 53: {
                return pSDEGridBase.isGroupPSSysPFPluginIdDirty();
            }
            case 54: {
                return pSDEGridBase.isGroupPSSysPFPluginNameDirty();
            }
            case 55: {
                return pSDEGridBase.isGroupStyleDirty();
            }
            case 56: {
                return pSDEGridBase.isGroupTextPSDEFIdDirty();
            }
            case 57: {
                return pSDEGridBase.isGroupTextPSDEFNameDirty();
            }
            case 58: {
                return pSDEGridBase.isIgnoreDSItemDirty();
            }
            case 59: {
                return pSDEGridBase.isItemPSSysCssIdDirty();
            }
            case 60: {
                return pSDEGridBase.isItemPSSysCssNameDirty();
            }
            case 61: {
                return pSDEGridBase.isLockFlagDirty();
            }
            case 62: {
                return pSDEGridBase.isMemoDirty();
            }
            case 63: {
                return pSDEGridBase.isMinorSortDirDirty();
            }
            case 64: {
                return pSDEGridBase.isMinorSortPSDEFIdDirty();
            }
            case 65: {
                return pSDEGridBase.isMinorSortPSDEFNameDirty();
            }
            case 66: {
                return pSDEGridBase.isMovePSDEActionIdDirty();
            }
            case 67: {
                return pSDEGridBase.isMovePSDEActionNameDirty();
            }
            case 68: {
                return pSDEGridBase.isMultiSelectDirty();
            }
            case 69: {
                return pSDEGridBase.isNavPSDERIdDirty();
            }
            case 70: {
                return pSDEGridBase.isNavPSDERNameDirty();
            }
            case 71: {
                return pSDEGridBase.isNavPSDEViewBaseIdDirty();
            }
            case 72: {
                return pSDEGridBase.isNavPSDEViewBaseNameDirty();
            }
            case 73: {
                return pSDEGridBase.isNavViewFilterDirty();
            }
            case 74: {
                return pSDEGridBase.isNavViewHeightDirty();
            }
            case 75: {
                return pSDEGridBase.isNavViewMaxHeightDirty();
            }
            case 76: {
                return pSDEGridBase.isNavViewMaxWidthDirty();
            }
            case 77: {
                return pSDEGridBase.isNavViewMinHeightDirty();
            }
            case 78: {
                return pSDEGridBase.isNavViewMinWidthDirty();
            }
            case 79: {
                return pSDEGridBase.isNavViewParamDirty();
            }
            case 80: {
                return pSDEGridBase.isNavViewPosDirty();
            }
            case 81: {
                return pSDEGridBase.isNavViewShowModeDirty();
            }
            case 82: {
                return pSDEGridBase.isNavViewWidthDirty();
            }
            case 83: {
                return pSDEGridBase.isNoSortDirty();
            }
            case 84: {
                return pSDEGridBase.isOrderValuePSDEFIdDirty();
            }
            case 85: {
                return pSDEGridBase.isOrderValuePSDEFNameDirty();
            }
            case 86: {
                return pSDEGridBase.isPagingSizeDirty();
            }
            case 87: {
                return pSDEGridBase.isPSACHandlerIdDirty();
            }
            case 88: {
                return pSDEGridBase.isPSACHandlerNameDirty();
            }
            case 89: {
                return pSDEGridBase.isPSCtrlLogicGroupIdDirty();
            }
            case 90: {
                return pSDEGridBase.isPSCtrlLogicGroupNameDirty();
            }
            case 91: {
                return pSDEGridBase.isPSCtrlMsgIdDirty();
            }
            case 92: {
                return pSDEGridBase.isPSCtrlMsgNameDirty();
            }
            case 93: {
                return pSDEGridBase.isPSDEDataSetIdDirty();
            }
            case 94: {
                return pSDEGridBase.isPSDEDataSetNameDirty();
            }
            case 95: {
                return pSDEGridBase.isPSDEFInputTipSetIdDirty();
            }
            case 96: {
                return pSDEGridBase.isPSDEFInputTipSetNameDirty();
            }
            case 97: {
                return pSDEGridBase.isPSDEGridIdDirty();
            }
            case 98: {
                return pSDEGridBase.isPSDEGridNameDirty();
            }
            case 99: {
                return pSDEGridBase.isPSDEIdDirty();
            }
            case 100: {
                return pSDEGridBase.isPSDENameDirty();
            }
            case 101: {
                return pSDEGridBase.isPSDynaInstIdDirty();
            }
            case 102: {
                return pSDEGridBase.isPSSysCssIdDirty();
            }
            case 103: {
                return pSDEGridBase.isPSSysCssNameDirty();
            }
            case 104: {
                return pSDEGridBase.isPSSysDynaModelIdDirty();
            }
            case 105: {
                return pSDEGridBase.isPSSysDynaModelNameDirty();
            }
            case 106: {
                return pSDEGridBase.isPSSysPFPluginIdDirty();
            }
            case 107: {
                return pSDEGridBase.isPSSysPFPluginNameDirty();
            }
            case 108: {
                return pSDEGridBase.isPSSysReqItemIdDirty();
            }
            case 109: {
                return pSDEGridBase.isPSSysReqItemNameDirty();
            }
            case 110: {
                return pSDEGridBase.isPSViewMsgGroupIdDirty();
            }
            case 111: {
                return pSDEGridBase.isPSViewMsgGroupNameDirty();
            }
            case 112: {
                return pSDEGridBase.isQuickPSDEToolbarIdDirty();
            }
            case 113: {
                return pSDEGridBase.isQuickPSDEToolbarNameDirty();
            }
            case 114: {
                return pSDEGridBase.isRemovePSDEActionIdDirty();
            }
            case 115: {
                return pSDEGridBase.isRemovePSDEActionNameDirty();
            }
            case 116: {
                return pSDEGridBase.isShowHeaderDirty();
            }
            case 117: {
                return pSDEGridBase.isSortModeDirty();
            }
            case 118: {
                return pSDEGridBase.isSRFSysPubDirty();
            }
            case 119: {
                return pSDEGridBase.isToDoTaskDirty();
            }
            case 120: {
                return pSDEGridBase.isTreePPSDEFIdDirty();
            }
            case 121: {
                return pSDEGridBase.isTreePPSDEFNameDirty();
            }
            case 122: {
                return pSDEGridBase.isUpdateDateDirty();
            }
            case 123: {
                return pSDEGridBase.isUpdateManDirty();
            }
            case 124: {
                return pSDEGridBase.isUpdatePSDEActionIdDirty();
            }
            case 125: {
                return pSDEGridBase.isUpdatePSDEActionNameDirty();
            }
            case 126: {
                return pSDEGridBase.isUser2PSDEActionIdDirty();
            }
            case 127: {
                return pSDEGridBase.isUser2PSDEActionNameDirty();
            }
            case 128: {
                return pSDEGridBase.isUserParamsDirty();
            }
            case 129: {
                return pSDEGridBase.isUserPSDEActionIdDirty();
            }
            case 130: {
                return pSDEGridBase.isUserPSDEActionNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGridBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGridBase pSDEGridBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGridBase.getAggMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggmode", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggMode()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdedsid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdedsname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdeid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpsdename", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSDEName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpssysviewpanelid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAggPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggpssysviewpanelname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAggPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAsyncPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAsyncPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getAsyncPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getAsyncPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getBatPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getBatPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getBatPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getBatPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getBufferRendererMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bufferrenderermode", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getBufferRendererMode()), (boolean)false);
        }
        if (bl || pSDEGridBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getColEnableFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablefilter", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getColEnableFilter()), (boolean)false);
        }
        if (bl || pSDEGridBase.getColEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablelink", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getColEnableLink()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCopyPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCopyPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCopyPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCopyPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEGridBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEGridBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEnableEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableedit", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEnableEdit()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEGridBase.getEnablePagingBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepagingbar", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getEnablePagingBar()), (boolean)false);
        }
        if (bl || pSDEGridBase.getForceFit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"forcefit", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getForceFit()), (boolean)false);
        }
        if (bl || pSDEGridBase.getFrozenCol() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frozencol", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getFrozenCol()), (boolean)false);
        }
        if (bl || pSDEGridBase.getFrozenLastCol() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frozenlastcol", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getFrozenLastCol()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGetDraftPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGetDraftPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGetDraftPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGetDraftPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGridModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridmodel", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGridModel()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGridSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridsn", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGridSN()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGridStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridstyle", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGridStyle()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupstyle", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupStyle()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupTextPSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getGroupTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getGroupTextPSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getIgnoreDSItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoredsitem", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getIgnoreDSItem()), (boolean)false);
        }
        if (bl || pSDEGridBase.getItemPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getItemPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getItemPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getItemPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getMultiSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiselect", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getMultiSelect()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsderid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavPSDERId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdername", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavPSDERName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbaseid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbasename", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSDEGridBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEGridBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPagingSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagingsize", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPagingSize()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEFInputTipSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEFInputTipSetId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEFInputTipSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEFInputTipSetName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getQuickPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getQuickPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getQuickPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getQuickPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getShowHeader() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showheader", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getShowHeader()), (boolean)false);
        }
        if (bl || pSDEGridBase.getSortMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortmode", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getSortMode()), (boolean)false);
        }
        if (bl || pSDEGridBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEGridBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEGridBase.getTreePPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treeppsdefid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getTreePPSDEFId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getTreePPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treeppsdefname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getTreePPSDEFName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUser2PSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUser2PSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUser2PSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUser2PSDEActionName()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUserPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionid", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUserPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEGridBase.getUserPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionname", (Object)PSDEGridBase.getJSONValue((Object)pSDEGridBase.getUserPSDEActionName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGridBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGridBase pSDEGridBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGridBase.getAggMode() != null) {
            object = pSDEGridBase.getAggMode();
            xmlNode.setAttribute(FIELD_AGGMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEActionId() != null) {
            object = pSDEGridBase.getAggPSDEActionId();
            xmlNode.setAttribute(FIELD_AGGPSDEACTIONID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEActionName() != null) {
            object = pSDEGridBase.getAggPSDEActionName();
            xmlNode.setAttribute(FIELD_AGGPSDEACTIONNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEDSId() != null) {
            object = pSDEGridBase.getAggPSDEDSId();
            xmlNode.setAttribute(FIELD_AGGPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEDSName() != null) {
            object = pSDEGridBase.getAggPSDEDSName();
            xmlNode.setAttribute(FIELD_AGGPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEId() != null) {
            object = pSDEGridBase.getAggPSDEId();
            xmlNode.setAttribute(FIELD_AGGPSDEID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSDEName() != null) {
            object = pSDEGridBase.getAggPSDEName();
            xmlNode.setAttribute(FIELD_AGGPSDENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSSysViewPanelId() != null) {
            object = pSDEGridBase.getAggPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_AGGPSSYSVIEWPANELID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAggPSSysViewPanelName() != null) {
            object = pSDEGridBase.getAggPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_AGGPSSYSVIEWPANELNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAsyncPSDEDSId() != null) {
            object = pSDEGridBase.getAsyncPSDEDSId();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getAsyncPSDEDSName() != null) {
            object = pSDEGridBase.getAsyncPSDEDSName();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getBatPSDEToolbarId() != null) {
            object = pSDEGridBase.getBatPSDEToolbarId();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEGridBase.getBatPSDEToolbarName() != null) {
            object = pSDEGridBase.getBatPSDEToolbarName();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getBufferRendererMode() != null) {
            object = pSDEGridBase.getBufferRendererMode();
            xmlNode.setAttribute(FIELD_BUFFERRENDERERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getBusyIndicator() != null) {
            object = pSDEGridBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getCodeName() != null) {
            object = pSDEGridBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getColEnableFilter() != null) {
            object = pSDEGridBase.getColEnableFilter();
            xmlNode.setAttribute(FIELD_COLENABLEFILTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getColEnableLink() != null) {
            object = pSDEGridBase.getColEnableLink();
            xmlNode.setAttribute(FIELD_COLENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getCopyPSDEActionId() != null) {
            object = pSDEGridBase.getCopyPSDEActionId();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCopyPSDEActionName() != null) {
            object = pSDEGridBase.getCopyPSDEActionName();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCreateDate() != null) {
            object = pSDEGridBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridBase.getCreateMan() != null) {
            object = pSDEGridBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCreatePSDEActionId() != null) {
            object = pSDEGridBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCreatePSDEActionName() != null) {
            object = pSDEGridBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCustomCond() != null) {
            object = pSDEGridBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getCustomType() != null) {
            object = pSDEGridBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getDynaModelFlag() != null) {
            object = pSDEGridBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getEmptyText() != null) {
            object = pSDEGridBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getEmptyTextPSLanResId() != null) {
            object = pSDEGridBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getEmptyTextPSLanResName() != null) {
            object = pSDEGridBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getEnableCustomized() != null) {
            object = pSDEGridBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getEnableEdit() != null) {
            object = pSDEGridBase.getEnableEdit();
            xmlNode.setAttribute(FIELD_ENABLEEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getEnableItemPriv() != null) {
            object = pSDEGridBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getEnablePagingBar() != null) {
            object = pSDEGridBase.getEnablePagingBar();
            xmlNode.setAttribute(FIELD_ENABLEPAGINGBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getForceFit() != null) {
            object = pSDEGridBase.getForceFit();
            xmlNode.setAttribute(FIELD_FORCEFIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getFrozenCol() != null) {
            object = pSDEGridBase.getFrozenCol();
            xmlNode.setAttribute(FIELD_FROZENCOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getFrozenLastCol() != null) {
            object = pSDEGridBase.getFrozenLastCol();
            xmlNode.setAttribute(FIELD_FROZENLASTCOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getGetDraftPSDEActionId() != null) {
            object = pSDEGridBase.getGetDraftPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGetDraftPSDEActionName() != null) {
            object = pSDEGridBase.getGetDraftPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGetPSDEActionId() != null) {
            object = pSDEGridBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGetPSDEActionName() != null) {
            object = pSDEGridBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGridModel() != null) {
            object = pSDEGridBase.getGridModel();
            xmlNode.setAttribute(FIELD_GRIDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGridSN() != null) {
            object = pSDEGridBase.getGridSN();
            xmlNode.setAttribute(FIELD_GRIDSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGridStyle() != null) {
            object = pSDEGridBase.getGridStyle();
            xmlNode.setAttribute(FIELD_GRIDSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupMode() != null) {
            object = pSDEGridBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSCodeListId() != null) {
            object = pSDEGridBase.getGroupPSCodeListId();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSCodeListName() != null) {
            object = pSDEGridBase.getGroupPSCodeListName();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSDEFId() != null) {
            object = pSDEGridBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSDEFName() != null) {
            object = pSDEGridBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSDEUAGroupId() != null) {
            object = pSDEGridBase.getGroupPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSDEUAGroupName() != null) {
            object = pSDEGridBase.getGroupPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSSysCssId() != null) {
            object = pSDEGridBase.getGroupPSSysCssId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSSysCssName() != null) {
            object = pSDEGridBase.getGroupPSSysCssName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSSysPFPluginId() != null) {
            object = pSDEGridBase.getGroupPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupPSSysPFPluginName() != null) {
            object = pSDEGridBase.getGroupPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupStyle() != null) {
            object = pSDEGridBase.getGroupStyle();
            xmlNode.setAttribute(FIELD_GROUPSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupTextPSDEFId() != null) {
            object = pSDEGridBase.getGroupTextPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getGroupTextPSDEFName() != null) {
            object = pSDEGridBase.getGroupTextPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getIgnoreDSItem() != null) {
            object = pSDEGridBase.getIgnoreDSItem();
            xmlNode.setAttribute(FIELD_IGNOREDSITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getItemPSSysCssId() != null) {
            object = pSDEGridBase.getItemPSSysCssId();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getItemPSSysCssName() != null) {
            object = pSDEGridBase.getItemPSSysCssName();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getLockFlag() != null) {
            object = pSDEGridBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getMemo() != null) {
            object = pSDEGridBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMinorSortDir() != null) {
            object = pSDEGridBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMinorSortPSDEFId() != null) {
            object = pSDEGridBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMinorSortPSDEFName() != null) {
            object = pSDEGridBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMovePSDEActionId() != null) {
            object = pSDEGridBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMovePSDEActionName() != null) {
            object = pSDEGridBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getMultiSelect() != null) {
            object = pSDEGridBase.getMultiSelect();
            xmlNode.setAttribute(FIELD_MULTISELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavPSDERId() != null) {
            object = pSDEGridBase.getNavPSDERId();
            xmlNode.setAttribute(FIELD_NAVPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavPSDERName() != null) {
            object = pSDEGridBase.getNavPSDERName();
            xmlNode.setAttribute(FIELD_NAVPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavPSDEViewBaseId() != null) {
            object = pSDEGridBase.getNavPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavPSDEViewBaseName() != null) {
            object = pSDEGridBase.getNavPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavViewFilter() != null) {
            object = pSDEGridBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavViewHeight() != null) {
            object = pSDEGridBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewMaxHeight() != null) {
            object = pSDEGridBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewMaxWidth() != null) {
            object = pSDEGridBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewMinHeight() != null) {
            object = pSDEGridBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewMinWidth() != null) {
            object = pSDEGridBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewParam() != null) {
            object = pSDEGridBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavViewPos() != null) {
            object = pSDEGridBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getNavViewShowMode() != null) {
            object = pSDEGridBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNavViewWidth() != null) {
            object = pSDEGridBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getNoSort() != null) {
            object = pSDEGridBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getOrderValuePSDEFId() != null) {
            object = pSDEGridBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getOrderValuePSDEFName() != null) {
            object = pSDEGridBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPagingSize() != null) {
            object = pSDEGridBase.getPagingSize();
            xmlNode.setAttribute(FIELD_PAGINGSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getPSACHandlerId() != null) {
            object = pSDEGridBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSACHandlerName() != null) {
            object = pSDEGridBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEGridBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEGridBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSCtrlMsgId() != null) {
            object = pSDEGridBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSCtrlMsgName() != null) {
            object = pSDEGridBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEDataSetId() != null) {
            object = pSDEGridBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEDataSetName() != null) {
            object = pSDEGridBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEFInputTipSetId() != null) {
            object = pSDEGridBase.getPSDEFInputTipSetId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEFInputTipSetName() != null) {
            object = pSDEGridBase.getPSDEFInputTipSetName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEGridId() != null) {
            object = pSDEGridBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEGridName() != null) {
            object = pSDEGridBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEId() != null) {
            object = pSDEGridBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDEName() != null) {
            object = pSDEGridBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSDynaInstId() != null) {
            object = pSDEGridBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysCssId() != null) {
            object = pSDEGridBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysCssName() != null) {
            object = pSDEGridBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysDynaModelId() != null) {
            object = pSDEGridBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysDynaModelName() != null) {
            object = pSDEGridBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysPFPluginId() != null) {
            object = pSDEGridBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysPFPluginName() != null) {
            object = pSDEGridBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysReqItemId() != null) {
            object = pSDEGridBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSSysReqItemName() != null) {
            object = pSDEGridBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSViewMsgGroupId() != null) {
            object = pSDEGridBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getPSViewMsgGroupName() != null) {
            object = pSDEGridBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getQuickPSDEToolbarId() != null) {
            object = pSDEGridBase.getQuickPSDEToolbarId();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getQuickPSDEToolbarName() != null) {
            object = pSDEGridBase.getQuickPSDEToolbarName();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getRemovePSDEActionId() != null) {
            object = pSDEGridBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getRemovePSDEActionName() != null) {
            object = pSDEGridBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getShowHeader() != null) {
            object = pSDEGridBase.getShowHeader();
            xmlNode.setAttribute(FIELD_SHOWHEADER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getSortMode() != null) {
            object = pSDEGridBase.getSortMode();
            xmlNode.setAttribute(FIELD_SORTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getSRFSysPub() != null) {
            object = pSDEGridBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGridBase.getToDoTask() != null) {
            object = pSDEGridBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getTreePPSDEFId() != null) {
            object = pSDEGridBase.getTreePPSDEFId();
            xmlNode.setAttribute(FIELD_TREEPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getTreePPSDEFName() != null) {
            object = pSDEGridBase.getTreePPSDEFName();
            xmlNode.setAttribute(FIELD_TREEPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUpdateDate() != null) {
            object = pSDEGridBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGridBase.getUpdateMan() != null) {
            object = pSDEGridBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUpdatePSDEActionId() != null) {
            object = pSDEGridBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUpdatePSDEActionName() != null) {
            object = pSDEGridBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUser2PSDEActionId() != null) {
            object = pSDEGridBase.getUser2PSDEActionId();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUser2PSDEActionName() != null) {
            object = pSDEGridBase.getUser2PSDEActionName();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUserParams() != null) {
            object = pSDEGridBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUserPSDEActionId() != null) {
            object = pSDEGridBase.getUserPSDEActionId();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGridBase.getUserPSDEActionName() != null) {
            object = pSDEGridBase.getUserPSDEActionName();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGridBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGridBase pSDEGridBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGridBase.isAggModeDirty() && (bl || pSDEGridBase.getAggMode() != null)) {
            iDataObject.set(FIELD_AGGMODE, (Object)pSDEGridBase.getAggMode());
        }
        if (pSDEGridBase.isAggPSDEActionIdDirty() && (bl || pSDEGridBase.getAggPSDEActionId() != null)) {
            iDataObject.set(FIELD_AGGPSDEACTIONID, (Object)pSDEGridBase.getAggPSDEActionId());
        }
        if (pSDEGridBase.isAggPSDEActionNameDirty() && (bl || pSDEGridBase.getAggPSDEActionName() != null)) {
            iDataObject.set(FIELD_AGGPSDEACTIONNAME, (Object)pSDEGridBase.getAggPSDEActionName());
        }
        if (pSDEGridBase.isAggPSDEDSIdDirty() && (bl || pSDEGridBase.getAggPSDEDSId() != null)) {
            iDataObject.set(FIELD_AGGPSDEDSID, (Object)pSDEGridBase.getAggPSDEDSId());
        }
        if (pSDEGridBase.isAggPSDEDSNameDirty() && (bl || pSDEGridBase.getAggPSDEDSName() != null)) {
            iDataObject.set(FIELD_AGGPSDEDSNAME, (Object)pSDEGridBase.getAggPSDEDSName());
        }
        if (pSDEGridBase.isAggPSDEIdDirty() && (bl || pSDEGridBase.getAggPSDEId() != null)) {
            iDataObject.set(FIELD_AGGPSDEID, (Object)pSDEGridBase.getAggPSDEId());
        }
        if (pSDEGridBase.isAggPSDENameDirty() && (bl || pSDEGridBase.getAggPSDEName() != null)) {
            iDataObject.set(FIELD_AGGPSDENAME, (Object)pSDEGridBase.getAggPSDEName());
        }
        if (pSDEGridBase.isAggPSSysViewPanelIdDirty() && (bl || pSDEGridBase.getAggPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_AGGPSSYSVIEWPANELID, (Object)pSDEGridBase.getAggPSSysViewPanelId());
        }
        if (pSDEGridBase.isAggPSSysViewPanelNameDirty() && (bl || pSDEGridBase.getAggPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_AGGPSSYSVIEWPANELNAME, (Object)pSDEGridBase.getAggPSSysViewPanelName());
        }
        if (pSDEGridBase.isAsyncPSDEDSIdDirty() && (bl || pSDEGridBase.getAsyncPSDEDSId() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSID, (Object)pSDEGridBase.getAsyncPSDEDSId());
        }
        if (pSDEGridBase.isAsyncPSDEDSNameDirty() && (bl || pSDEGridBase.getAsyncPSDEDSName() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSNAME, (Object)pSDEGridBase.getAsyncPSDEDSName());
        }
        if (pSDEGridBase.isBatPSDEToolbarIdDirty() && (bl || pSDEGridBase.getBatPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARID, (Object)pSDEGridBase.getBatPSDEToolbarId());
        }
        if (pSDEGridBase.isBatPSDEToolbarNameDirty() && (bl || pSDEGridBase.getBatPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARNAME, (Object)pSDEGridBase.getBatPSDEToolbarName());
        }
        if (pSDEGridBase.isBufferRendererModeDirty() && (bl || pSDEGridBase.getBufferRendererMode() != null)) {
            iDataObject.set(FIELD_BUFFERRENDERERMODE, (Object)pSDEGridBase.getBufferRendererMode());
        }
        if (pSDEGridBase.isBusyIndicatorDirty() && (bl || pSDEGridBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEGridBase.getBusyIndicator());
        }
        if (pSDEGridBase.isCodeNameDirty() && (bl || pSDEGridBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEGridBase.getCodeName());
        }
        if (pSDEGridBase.isColEnableFilterDirty() && (bl || pSDEGridBase.getColEnableFilter() != null)) {
            iDataObject.set(FIELD_COLENABLEFILTER, (Object)pSDEGridBase.getColEnableFilter());
        }
        if (pSDEGridBase.isColEnableLinkDirty() && (bl || pSDEGridBase.getColEnableLink() != null)) {
            iDataObject.set(FIELD_COLENABLELINK, (Object)pSDEGridBase.getColEnableLink());
        }
        if (pSDEGridBase.isCopyPSDEActionIdDirty() && (bl || pSDEGridBase.getCopyPSDEActionId() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONID, (Object)pSDEGridBase.getCopyPSDEActionId());
        }
        if (pSDEGridBase.isCopyPSDEActionNameDirty() && (bl || pSDEGridBase.getCopyPSDEActionName() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONNAME, (Object)pSDEGridBase.getCopyPSDEActionName());
        }
        if (pSDEGridBase.isCreateDateDirty() && (bl || pSDEGridBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGridBase.getCreateDate());
        }
        if (pSDEGridBase.isCreateManDirty() && (bl || pSDEGridBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGridBase.getCreateMan());
        }
        if (pSDEGridBase.isCreatePSDEActionIdDirty() && (bl || pSDEGridBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSDEGridBase.getCreatePSDEActionId());
        }
        if (pSDEGridBase.isCreatePSDEActionNameDirty() && (bl || pSDEGridBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSDEGridBase.getCreatePSDEActionName());
        }
        if (pSDEGridBase.isCustomCondDirty() && (bl || pSDEGridBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEGridBase.getCustomCond());
        }
        if (pSDEGridBase.isCustomTypeDirty() && (bl || pSDEGridBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEGridBase.getCustomType());
        }
        if (pSDEGridBase.isDynaModelFlagDirty() && (bl || pSDEGridBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEGridBase.getDynaModelFlag());
        }
        if (pSDEGridBase.isEmptyTextDirty() && (bl || pSDEGridBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDEGridBase.getEmptyText());
        }
        if (pSDEGridBase.isEmptyTextPSLanResIdDirty() && (bl || pSDEGridBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDEGridBase.getEmptyTextPSLanResId());
        }
        if (pSDEGridBase.isEmptyTextPSLanResNameDirty() && (bl || pSDEGridBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDEGridBase.getEmptyTextPSLanResName());
        }
        if (pSDEGridBase.isEnableCustomizedDirty() && (bl || pSDEGridBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSDEGridBase.getEnableCustomized());
        }
        if (pSDEGridBase.isEnableEditDirty() && (bl || pSDEGridBase.getEnableEdit() != null)) {
            iDataObject.set(FIELD_ENABLEEDIT, (Object)pSDEGridBase.getEnableEdit());
        }
        if (pSDEGridBase.isEnableItemPrivDirty() && (bl || pSDEGridBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEGridBase.getEnableItemPriv());
        }
        if (pSDEGridBase.isEnablePagingBarDirty() && (bl || pSDEGridBase.getEnablePagingBar() != null)) {
            iDataObject.set(FIELD_ENABLEPAGINGBAR, (Object)pSDEGridBase.getEnablePagingBar());
        }
        if (pSDEGridBase.isForceFitDirty() && (bl || pSDEGridBase.getForceFit() != null)) {
            iDataObject.set(FIELD_FORCEFIT, (Object)pSDEGridBase.getForceFit());
        }
        if (pSDEGridBase.isFrozenColDirty() && (bl || pSDEGridBase.getFrozenCol() != null)) {
            iDataObject.set(FIELD_FROZENCOL, (Object)pSDEGridBase.getFrozenCol());
        }
        if (pSDEGridBase.isFrozenLastColDirty() && (bl || pSDEGridBase.getFrozenLastCol() != null)) {
            iDataObject.set(FIELD_FROZENLASTCOL, (Object)pSDEGridBase.getFrozenLastCol());
        }
        if (pSDEGridBase.isGetDraftPSDEActionIdDirty() && (bl || pSDEGridBase.getGetDraftPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONID, (Object)pSDEGridBase.getGetDraftPSDEActionId());
        }
        if (pSDEGridBase.isGetDraftPSDEActionNameDirty() && (bl || pSDEGridBase.getGetDraftPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONNAME, (Object)pSDEGridBase.getGetDraftPSDEActionName());
        }
        if (pSDEGridBase.isGetPSDEActionIdDirty() && (bl || pSDEGridBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSDEGridBase.getGetPSDEActionId());
        }
        if (pSDEGridBase.isGetPSDEActionNameDirty() && (bl || pSDEGridBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSDEGridBase.getGetPSDEActionName());
        }
        if (pSDEGridBase.isGridModelDirty() && (bl || pSDEGridBase.getGridModel() != null)) {
            iDataObject.set(FIELD_GRIDMODEL, (Object)pSDEGridBase.getGridModel());
        }
        if (pSDEGridBase.isGridSNDirty() && (bl || pSDEGridBase.getGridSN() != null)) {
            iDataObject.set(FIELD_GRIDSN, (Object)pSDEGridBase.getGridSN());
        }
        if (pSDEGridBase.isGridStyleDirty() && (bl || pSDEGridBase.getGridStyle() != null)) {
            iDataObject.set(FIELD_GRIDSTYLE, (Object)pSDEGridBase.getGridStyle());
        }
        if (pSDEGridBase.isGroupModeDirty() && (bl || pSDEGridBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSDEGridBase.getGroupMode());
        }
        if (pSDEGridBase.isGroupPSCodeListIdDirty() && (bl || pSDEGridBase.getGroupPSCodeListId() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTID, (Object)pSDEGridBase.getGroupPSCodeListId());
        }
        if (pSDEGridBase.isGroupPSCodeListNameDirty() && (bl || pSDEGridBase.getGroupPSCodeListName() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTNAME, (Object)pSDEGridBase.getGroupPSCodeListName());
        }
        if (pSDEGridBase.isGroupPSDEFIdDirty() && (bl || pSDEGridBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSDEGridBase.getGroupPSDEFId());
        }
        if (pSDEGridBase.isGroupPSDEFNameDirty() && (bl || pSDEGridBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSDEGridBase.getGroupPSDEFName());
        }
        if (pSDEGridBase.isGroupPSDEUAGroupIdDirty() && (bl || pSDEGridBase.getGroupPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPID, (Object)pSDEGridBase.getGroupPSDEUAGroupId());
        }
        if (pSDEGridBase.isGroupPSDEUAGroupNameDirty() && (bl || pSDEGridBase.getGroupPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPNAME, (Object)pSDEGridBase.getGroupPSDEUAGroupName());
        }
        if (pSDEGridBase.isGroupPSSysCssIdDirty() && (bl || pSDEGridBase.getGroupPSSysCssId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSID, (Object)pSDEGridBase.getGroupPSSysCssId());
        }
        if (pSDEGridBase.isGroupPSSysCssNameDirty() && (bl || pSDEGridBase.getGroupPSSysCssName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSNAME, (Object)pSDEGridBase.getGroupPSSysCssName());
        }
        if (pSDEGridBase.isGroupPSSysPFPluginIdDirty() && (bl || pSDEGridBase.getGroupPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINID, (Object)pSDEGridBase.getGroupPSSysPFPluginId());
        }
        if (pSDEGridBase.isGroupPSSysPFPluginNameDirty() && (bl || pSDEGridBase.getGroupPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINNAME, (Object)pSDEGridBase.getGroupPSSysPFPluginName());
        }
        if (pSDEGridBase.isGroupStyleDirty() && (bl || pSDEGridBase.getGroupStyle() != null)) {
            iDataObject.set(FIELD_GROUPSTYLE, (Object)pSDEGridBase.getGroupStyle());
        }
        if (pSDEGridBase.isGroupTextPSDEFIdDirty() && (bl || pSDEGridBase.getGroupTextPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFID, (Object)pSDEGridBase.getGroupTextPSDEFId());
        }
        if (pSDEGridBase.isGroupTextPSDEFNameDirty() && (bl || pSDEGridBase.getGroupTextPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFNAME, (Object)pSDEGridBase.getGroupTextPSDEFName());
        }
        if (pSDEGridBase.isIgnoreDSItemDirty() && (bl || pSDEGridBase.getIgnoreDSItem() != null)) {
            iDataObject.set(FIELD_IGNOREDSITEM, (Object)pSDEGridBase.getIgnoreDSItem());
        }
        if (pSDEGridBase.isItemPSSysCssIdDirty() && (bl || pSDEGridBase.getItemPSSysCssId() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSID, (Object)pSDEGridBase.getItemPSSysCssId());
        }
        if (pSDEGridBase.isItemPSSysCssNameDirty() && (bl || pSDEGridBase.getItemPSSysCssName() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSNAME, (Object)pSDEGridBase.getItemPSSysCssName());
        }
        if (pSDEGridBase.isLockFlagDirty() && (bl || pSDEGridBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEGridBase.getLockFlag());
        }
        if (pSDEGridBase.isMemoDirty() && (bl || pSDEGridBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGridBase.getMemo());
        }
        if (pSDEGridBase.isMinorSortDirDirty() && (bl || pSDEGridBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEGridBase.getMinorSortDir());
        }
        if (pSDEGridBase.isMinorSortPSDEFIdDirty() && (bl || pSDEGridBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEGridBase.getMinorSortPSDEFId());
        }
        if (pSDEGridBase.isMinorSortPSDEFNameDirty() && (bl || pSDEGridBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEGridBase.getMinorSortPSDEFName());
        }
        if (pSDEGridBase.isMovePSDEActionIdDirty() && (bl || pSDEGridBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSDEGridBase.getMovePSDEActionId());
        }
        if (pSDEGridBase.isMovePSDEActionNameDirty() && (bl || pSDEGridBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSDEGridBase.getMovePSDEActionName());
        }
        if (pSDEGridBase.isMultiSelectDirty() && (bl || pSDEGridBase.getMultiSelect() != null)) {
            iDataObject.set(FIELD_MULTISELECT, (Object)pSDEGridBase.getMultiSelect());
        }
        if (pSDEGridBase.isNavPSDERIdDirty() && (bl || pSDEGridBase.getNavPSDERId() != null)) {
            iDataObject.set(FIELD_NAVPSDERID, (Object)pSDEGridBase.getNavPSDERId());
        }
        if (pSDEGridBase.isNavPSDERNameDirty() && (bl || pSDEGridBase.getNavPSDERName() != null)) {
            iDataObject.set(FIELD_NAVPSDERNAME, (Object)pSDEGridBase.getNavPSDERName());
        }
        if (pSDEGridBase.isNavPSDEViewBaseIdDirty() && (bl || pSDEGridBase.getNavPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASEID, (Object)pSDEGridBase.getNavPSDEViewBaseId());
        }
        if (pSDEGridBase.isNavPSDEViewBaseNameDirty() && (bl || pSDEGridBase.getNavPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASENAME, (Object)pSDEGridBase.getNavPSDEViewBaseName());
        }
        if (pSDEGridBase.isNavViewFilterDirty() && (bl || pSDEGridBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEGridBase.getNavViewFilter());
        }
        if (pSDEGridBase.isNavViewHeightDirty() && (bl || pSDEGridBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSDEGridBase.getNavViewHeight());
        }
        if (pSDEGridBase.isNavViewMaxHeightDirty() && (bl || pSDEGridBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSDEGridBase.getNavViewMaxHeight());
        }
        if (pSDEGridBase.isNavViewMaxWidthDirty() && (bl || pSDEGridBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSDEGridBase.getNavViewMaxWidth());
        }
        if (pSDEGridBase.isNavViewMinHeightDirty() && (bl || pSDEGridBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSDEGridBase.getNavViewMinHeight());
        }
        if (pSDEGridBase.isNavViewMinWidthDirty() && (bl || pSDEGridBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSDEGridBase.getNavViewMinWidth());
        }
        if (pSDEGridBase.isNavViewParamDirty() && (bl || pSDEGridBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSDEGridBase.getNavViewParam());
        }
        if (pSDEGridBase.isNavViewPosDirty() && (bl || pSDEGridBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSDEGridBase.getNavViewPos());
        }
        if (pSDEGridBase.isNavViewShowModeDirty() && (bl || pSDEGridBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSDEGridBase.getNavViewShowMode());
        }
        if (pSDEGridBase.isNavViewWidthDirty() && (bl || pSDEGridBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSDEGridBase.getNavViewWidth());
        }
        if (pSDEGridBase.isNoSortDirty() && (bl || pSDEGridBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEGridBase.getNoSort());
        }
        if (pSDEGridBase.isOrderValuePSDEFIdDirty() && (bl || pSDEGridBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSDEGridBase.getOrderValuePSDEFId());
        }
        if (pSDEGridBase.isOrderValuePSDEFNameDirty() && (bl || pSDEGridBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSDEGridBase.getOrderValuePSDEFName());
        }
        if (pSDEGridBase.isPagingSizeDirty() && (bl || pSDEGridBase.getPagingSize() != null)) {
            iDataObject.set(FIELD_PAGINGSIZE, (Object)pSDEGridBase.getPagingSize());
        }
        if (pSDEGridBase.isPSACHandlerIdDirty() && (bl || pSDEGridBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEGridBase.getPSACHandlerId());
        }
        if (pSDEGridBase.isPSACHandlerNameDirty() && (bl || pSDEGridBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEGridBase.getPSACHandlerName());
        }
        if (pSDEGridBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEGridBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEGridBase.getPSCtrlLogicGroupId());
        }
        if (pSDEGridBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEGridBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEGridBase.getPSCtrlLogicGroupName());
        }
        if (pSDEGridBase.isPSCtrlMsgIdDirty() && (bl || pSDEGridBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEGridBase.getPSCtrlMsgId());
        }
        if (pSDEGridBase.isPSCtrlMsgNameDirty() && (bl || pSDEGridBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEGridBase.getPSCtrlMsgName());
        }
        if (pSDEGridBase.isPSDEDataSetIdDirty() && (bl || pSDEGridBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEGridBase.getPSDEDataSetId());
        }
        if (pSDEGridBase.isPSDEDataSetNameDirty() && (bl || pSDEGridBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEGridBase.getPSDEDataSetName());
        }
        if (pSDEGridBase.isPSDEFInputTipSetIdDirty() && (bl || pSDEGridBase.getPSDEFInputTipSetId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETID, (Object)pSDEGridBase.getPSDEFInputTipSetId());
        }
        if (pSDEGridBase.isPSDEFInputTipSetNameDirty() && (bl || pSDEGridBase.getPSDEFInputTipSetName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETNAME, (Object)pSDEGridBase.getPSDEFInputTipSetName());
        }
        if (pSDEGridBase.isPSDEGridIdDirty() && (bl || pSDEGridBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGridBase.getPSDEGridId());
        }
        if (pSDEGridBase.isPSDEGridNameDirty() && (bl || pSDEGridBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGridBase.getPSDEGridName());
        }
        if (pSDEGridBase.isPSDEIdDirty() && (bl || pSDEGridBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEGridBase.getPSDEId());
        }
        if (pSDEGridBase.isPSDENameDirty() && (bl || pSDEGridBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEGridBase.getPSDEName());
        }
        if (pSDEGridBase.isPSDynaInstIdDirty() && (bl || pSDEGridBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEGridBase.getPSDynaInstId());
        }
        if (pSDEGridBase.isPSSysCssIdDirty() && (bl || pSDEGridBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEGridBase.getPSSysCssId());
        }
        if (pSDEGridBase.isPSSysCssNameDirty() && (bl || pSDEGridBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEGridBase.getPSSysCssName());
        }
        if (pSDEGridBase.isPSSysDynaModelIdDirty() && (bl || pSDEGridBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEGridBase.getPSSysDynaModelId());
        }
        if (pSDEGridBase.isPSSysDynaModelNameDirty() && (bl || pSDEGridBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEGridBase.getPSSysDynaModelName());
        }
        if (pSDEGridBase.isPSSysPFPluginIdDirty() && (bl || pSDEGridBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEGridBase.getPSSysPFPluginId());
        }
        if (pSDEGridBase.isPSSysPFPluginNameDirty() && (bl || pSDEGridBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEGridBase.getPSSysPFPluginName());
        }
        if (pSDEGridBase.isPSSysReqItemIdDirty() && (bl || pSDEGridBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEGridBase.getPSSysReqItemId());
        }
        if (pSDEGridBase.isPSSysReqItemNameDirty() && (bl || pSDEGridBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEGridBase.getPSSysReqItemName());
        }
        if (pSDEGridBase.isPSViewMsgGroupIdDirty() && (bl || pSDEGridBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEGridBase.getPSViewMsgGroupId());
        }
        if (pSDEGridBase.isPSViewMsgGroupNameDirty() && (bl || pSDEGridBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEGridBase.getPSViewMsgGroupName());
        }
        if (pSDEGridBase.isQuickPSDEToolbarIdDirty() && (bl || pSDEGridBase.getQuickPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARID, (Object)pSDEGridBase.getQuickPSDEToolbarId());
        }
        if (pSDEGridBase.isQuickPSDEToolbarNameDirty() && (bl || pSDEGridBase.getQuickPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARNAME, (Object)pSDEGridBase.getQuickPSDEToolbarName());
        }
        if (pSDEGridBase.isRemovePSDEActionIdDirty() && (bl || pSDEGridBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSDEGridBase.getRemovePSDEActionId());
        }
        if (pSDEGridBase.isRemovePSDEActionNameDirty() && (bl || pSDEGridBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSDEGridBase.getRemovePSDEActionName());
        }
        if (pSDEGridBase.isShowHeaderDirty() && (bl || pSDEGridBase.getShowHeader() != null)) {
            iDataObject.set(FIELD_SHOWHEADER, (Object)pSDEGridBase.getShowHeader());
        }
        if (pSDEGridBase.isSortModeDirty() && (bl || pSDEGridBase.getSortMode() != null)) {
            iDataObject.set(FIELD_SORTMODE, (Object)pSDEGridBase.getSortMode());
        }
        if (pSDEGridBase.isSRFSysPubDirty() && (bl || pSDEGridBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEGridBase.getSRFSysPub());
        }
        if (pSDEGridBase.isToDoTaskDirty() && (bl || pSDEGridBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEGridBase.getToDoTask());
        }
        if (pSDEGridBase.isTreePPSDEFIdDirty() && (bl || pSDEGridBase.getTreePPSDEFId() != null)) {
            iDataObject.set(FIELD_TREEPPSDEFID, (Object)pSDEGridBase.getTreePPSDEFId());
        }
        if (pSDEGridBase.isTreePPSDEFNameDirty() && (bl || pSDEGridBase.getTreePPSDEFName() != null)) {
            iDataObject.set(FIELD_TREEPPSDEFNAME, (Object)pSDEGridBase.getTreePPSDEFName());
        }
        if (pSDEGridBase.isUpdateDateDirty() && (bl || pSDEGridBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGridBase.getUpdateDate());
        }
        if (pSDEGridBase.isUpdateManDirty() && (bl || pSDEGridBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGridBase.getUpdateMan());
        }
        if (pSDEGridBase.isUpdatePSDEActionIdDirty() && (bl || pSDEGridBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDEGridBase.getUpdatePSDEActionId());
        }
        if (pSDEGridBase.isUpdatePSDEActionNameDirty() && (bl || pSDEGridBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDEGridBase.getUpdatePSDEActionName());
        }
        if (pSDEGridBase.isUser2PSDEActionIdDirty() && (bl || pSDEGridBase.getUser2PSDEActionId() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONID, (Object)pSDEGridBase.getUser2PSDEActionId());
        }
        if (pSDEGridBase.isUser2PSDEActionNameDirty() && (bl || pSDEGridBase.getUser2PSDEActionName() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONNAME, (Object)pSDEGridBase.getUser2PSDEActionName());
        }
        if (pSDEGridBase.isUserParamsDirty() && (bl || pSDEGridBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEGridBase.getUserParams());
        }
        if (pSDEGridBase.isUserPSDEActionIdDirty() && (bl || pSDEGridBase.getUserPSDEActionId() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONID, (Object)pSDEGridBase.getUserPSDEActionId());
        }
        if (pSDEGridBase.isUserPSDEActionNameDirty() && (bl || pSDEGridBase.getUserPSDEActionName() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONNAME, (Object)pSDEGridBase.getUserPSDEActionName());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDEGridBase.remove(this, n);
    }

    private static boolean remove(PSDEGridBase pSDEGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGridBase.resetAggMode();
                return true;
            }
            case 1: {
                pSDEGridBase.resetAggPSDEActionId();
                return true;
            }
            case 2: {
                pSDEGridBase.resetAggPSDEActionName();
                return true;
            }
            case 3: {
                pSDEGridBase.resetAggPSDEDSId();
                return true;
            }
            case 4: {
                pSDEGridBase.resetAggPSDEDSName();
                return true;
            }
            case 5: {
                pSDEGridBase.resetAggPSDEId();
                return true;
            }
            case 6: {
                pSDEGridBase.resetAggPSDEName();
                return true;
            }
            case 7: {
                pSDEGridBase.resetAggPSSysViewPanelId();
                return true;
            }
            case 8: {
                pSDEGridBase.resetAggPSSysViewPanelName();
                return true;
            }
            case 9: {
                pSDEGridBase.resetAsyncPSDEDSId();
                return true;
            }
            case 10: {
                pSDEGridBase.resetAsyncPSDEDSName();
                return true;
            }
            case 11: {
                pSDEGridBase.resetBatPSDEToolbarId();
                return true;
            }
            case 12: {
                pSDEGridBase.resetBatPSDEToolbarName();
                return true;
            }
            case 13: {
                pSDEGridBase.resetBufferRendererMode();
                return true;
            }
            case 14: {
                pSDEGridBase.resetBusyIndicator();
                return true;
            }
            case 15: {
                pSDEGridBase.resetCodeName();
                return true;
            }
            case 16: {
                pSDEGridBase.resetColEnableFilter();
                return true;
            }
            case 17: {
                pSDEGridBase.resetColEnableLink();
                return true;
            }
            case 18: {
                pSDEGridBase.resetCopyPSDEActionId();
                return true;
            }
            case 19: {
                pSDEGridBase.resetCopyPSDEActionName();
                return true;
            }
            case 20: {
                pSDEGridBase.resetCreateDate();
                return true;
            }
            case 21: {
                pSDEGridBase.resetCreateMan();
                return true;
            }
            case 22: {
                pSDEGridBase.resetCreatePSDEActionId();
                return true;
            }
            case 23: {
                pSDEGridBase.resetCreatePSDEActionName();
                return true;
            }
            case 24: {
                pSDEGridBase.resetCustomCond();
                return true;
            }
            case 25: {
                pSDEGridBase.resetCustomType();
                return true;
            }
            case 26: {
                pSDEGridBase.resetDynaModelFlag();
                return true;
            }
            case 27: {
                pSDEGridBase.resetEmptyText();
                return true;
            }
            case 28: {
                pSDEGridBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 29: {
                pSDEGridBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 30: {
                pSDEGridBase.resetEnableCustomized();
                return true;
            }
            case 31: {
                pSDEGridBase.resetEnableEdit();
                return true;
            }
            case 32: {
                pSDEGridBase.resetEnableItemPriv();
                return true;
            }
            case 33: {
                pSDEGridBase.resetEnablePagingBar();
                return true;
            }
            case 34: {
                pSDEGridBase.resetForceFit();
                return true;
            }
            case 35: {
                pSDEGridBase.resetFrozenCol();
                return true;
            }
            case 36: {
                pSDEGridBase.resetFrozenLastCol();
                return true;
            }
            case 37: {
                pSDEGridBase.resetGetDraftPSDEActionId();
                return true;
            }
            case 38: {
                pSDEGridBase.resetGetDraftPSDEActionName();
                return true;
            }
            case 39: {
                pSDEGridBase.resetGetPSDEActionId();
                return true;
            }
            case 40: {
                pSDEGridBase.resetGetPSDEActionName();
                return true;
            }
            case 41: {
                pSDEGridBase.resetGridModel();
                return true;
            }
            case 42: {
                pSDEGridBase.resetGridSN();
                return true;
            }
            case 43: {
                pSDEGridBase.resetGridStyle();
                return true;
            }
            case 44: {
                pSDEGridBase.resetGroupMode();
                return true;
            }
            case 45: {
                pSDEGridBase.resetGroupPSCodeListId();
                return true;
            }
            case 46: {
                pSDEGridBase.resetGroupPSCodeListName();
                return true;
            }
            case 47: {
                pSDEGridBase.resetGroupPSDEFId();
                return true;
            }
            case 48: {
                pSDEGridBase.resetGroupPSDEFName();
                return true;
            }
            case 49: {
                pSDEGridBase.resetGroupPSDEUAGroupId();
                return true;
            }
            case 50: {
                pSDEGridBase.resetGroupPSDEUAGroupName();
                return true;
            }
            case 51: {
                pSDEGridBase.resetGroupPSSysCssId();
                return true;
            }
            case 52: {
                pSDEGridBase.resetGroupPSSysCssName();
                return true;
            }
            case 53: {
                pSDEGridBase.resetGroupPSSysPFPluginId();
                return true;
            }
            case 54: {
                pSDEGridBase.resetGroupPSSysPFPluginName();
                return true;
            }
            case 55: {
                pSDEGridBase.resetGroupStyle();
                return true;
            }
            case 56: {
                pSDEGridBase.resetGroupTextPSDEFId();
                return true;
            }
            case 57: {
                pSDEGridBase.resetGroupTextPSDEFName();
                return true;
            }
            case 58: {
                pSDEGridBase.resetIgnoreDSItem();
                return true;
            }
            case 59: {
                pSDEGridBase.resetItemPSSysCssId();
                return true;
            }
            case 60: {
                pSDEGridBase.resetItemPSSysCssName();
                return true;
            }
            case 61: {
                pSDEGridBase.resetLockFlag();
                return true;
            }
            case 62: {
                pSDEGridBase.resetMemo();
                return true;
            }
            case 63: {
                pSDEGridBase.resetMinorSortDir();
                return true;
            }
            case 64: {
                pSDEGridBase.resetMinorSortPSDEFId();
                return true;
            }
            case 65: {
                pSDEGridBase.resetMinorSortPSDEFName();
                return true;
            }
            case 66: {
                pSDEGridBase.resetMovePSDEActionId();
                return true;
            }
            case 67: {
                pSDEGridBase.resetMovePSDEActionName();
                return true;
            }
            case 68: {
                pSDEGridBase.resetMultiSelect();
                return true;
            }
            case 69: {
                pSDEGridBase.resetNavPSDERId();
                return true;
            }
            case 70: {
                pSDEGridBase.resetNavPSDERName();
                return true;
            }
            case 71: {
                pSDEGridBase.resetNavPSDEViewBaseId();
                return true;
            }
            case 72: {
                pSDEGridBase.resetNavPSDEViewBaseName();
                return true;
            }
            case 73: {
                pSDEGridBase.resetNavViewFilter();
                return true;
            }
            case 74: {
                pSDEGridBase.resetNavViewHeight();
                return true;
            }
            case 75: {
                pSDEGridBase.resetNavViewMaxHeight();
                return true;
            }
            case 76: {
                pSDEGridBase.resetNavViewMaxWidth();
                return true;
            }
            case 77: {
                pSDEGridBase.resetNavViewMinHeight();
                return true;
            }
            case 78: {
                pSDEGridBase.resetNavViewMinWidth();
                return true;
            }
            case 79: {
                pSDEGridBase.resetNavViewParam();
                return true;
            }
            case 80: {
                pSDEGridBase.resetNavViewPos();
                return true;
            }
            case 81: {
                pSDEGridBase.resetNavViewShowMode();
                return true;
            }
            case 82: {
                pSDEGridBase.resetNavViewWidth();
                return true;
            }
            case 83: {
                pSDEGridBase.resetNoSort();
                return true;
            }
            case 84: {
                pSDEGridBase.resetOrderValuePSDEFId();
                return true;
            }
            case 85: {
                pSDEGridBase.resetOrderValuePSDEFName();
                return true;
            }
            case 86: {
                pSDEGridBase.resetPagingSize();
                return true;
            }
            case 87: {
                pSDEGridBase.resetPSACHandlerId();
                return true;
            }
            case 88: {
                pSDEGridBase.resetPSACHandlerName();
                return true;
            }
            case 89: {
                pSDEGridBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 90: {
                pSDEGridBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 91: {
                pSDEGridBase.resetPSCtrlMsgId();
                return true;
            }
            case 92: {
                pSDEGridBase.resetPSCtrlMsgName();
                return true;
            }
            case 93: {
                pSDEGridBase.resetPSDEDataSetId();
                return true;
            }
            case 94: {
                pSDEGridBase.resetPSDEDataSetName();
                return true;
            }
            case 95: {
                pSDEGridBase.resetPSDEFInputTipSetId();
                return true;
            }
            case 96: {
                pSDEGridBase.resetPSDEFInputTipSetName();
                return true;
            }
            case 97: {
                pSDEGridBase.resetPSDEGridId();
                return true;
            }
            case 98: {
                pSDEGridBase.resetPSDEGridName();
                return true;
            }
            case 99: {
                pSDEGridBase.resetPSDEId();
                return true;
            }
            case 100: {
                pSDEGridBase.resetPSDEName();
                return true;
            }
            case 101: {
                pSDEGridBase.resetPSDynaInstId();
                return true;
            }
            case 102: {
                pSDEGridBase.resetPSSysCssId();
                return true;
            }
            case 103: {
                pSDEGridBase.resetPSSysCssName();
                return true;
            }
            case 104: {
                pSDEGridBase.resetPSSysDynaModelId();
                return true;
            }
            case 105: {
                pSDEGridBase.resetPSSysDynaModelName();
                return true;
            }
            case 106: {
                pSDEGridBase.resetPSSysPFPluginId();
                return true;
            }
            case 107: {
                pSDEGridBase.resetPSSysPFPluginName();
                return true;
            }
            case 108: {
                pSDEGridBase.resetPSSysReqItemId();
                return true;
            }
            case 109: {
                pSDEGridBase.resetPSSysReqItemName();
                return true;
            }
            case 110: {
                pSDEGridBase.resetPSViewMsgGroupId();
                return true;
            }
            case 111: {
                pSDEGridBase.resetPSViewMsgGroupName();
                return true;
            }
            case 112: {
                pSDEGridBase.resetQuickPSDEToolbarId();
                return true;
            }
            case 113: {
                pSDEGridBase.resetQuickPSDEToolbarName();
                return true;
            }
            case 114: {
                pSDEGridBase.resetRemovePSDEActionId();
                return true;
            }
            case 115: {
                pSDEGridBase.resetRemovePSDEActionName();
                return true;
            }
            case 116: {
                pSDEGridBase.resetShowHeader();
                return true;
            }
            case 117: {
                pSDEGridBase.resetSortMode();
                return true;
            }
            case 118: {
                pSDEGridBase.resetSRFSysPub();
                return true;
            }
            case 119: {
                pSDEGridBase.resetToDoTask();
                return true;
            }
            case 120: {
                pSDEGridBase.resetTreePPSDEFId();
                return true;
            }
            case 121: {
                pSDEGridBase.resetTreePPSDEFName();
                return true;
            }
            case 122: {
                pSDEGridBase.resetUpdateDate();
                return true;
            }
            case 123: {
                pSDEGridBase.resetUpdateMan();
                return true;
            }
            case 124: {
                pSDEGridBase.resetUpdatePSDEActionId();
                return true;
            }
            case 125: {
                pSDEGridBase.resetUpdatePSDEActionName();
                return true;
            }
            case 126: {
                pSDEGridBase.resetUser2PSDEActionId();
                return true;
            }
            case 127: {
                pSDEGridBase.resetUser2PSDEActionName();
                return true;
            }
            case 128: {
                pSDEGridBase.resetUserParams();
                return true;
            }
            case 129: {
                pSDEGridBase.resetUserPSDEActionId();
                return true;
            }
            case 130: {
                pSDEGridBase.resetUserPSDEActionName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandler();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSACHandlerLock;
        synchronized (n) {
            if (this.psachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSACHandlerId(), (Object)this.psachandler.getPSACHandlerId()) != 0L) {
                this.psachandler = null;
            }
            if (this.psachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getGroupPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSCodeList();
        }
        if (this.getGroupPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objGroupPSCodeListLock;
        synchronized (n) {
            if (this.grouppscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSCodeListId(), (Object)this.grouppscodelist.getPSCodeListId()) != 0L) {
                this.grouppscodelist = null;
            }
            if (this.grouppscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getGroupPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.grouppscodelist = pSCodeList;
            }
            return this.grouppscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet((IEntity)pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsg getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgId(), (Object)this.psctrlmsg.getPSCtrlMsgId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsg pSCtrlMsg = new PSCtrlMsg();
                pSCtrlMsg.setPSCtrlMsgId(this.getPSCtrlMsgId());
                PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgService.autoGet((IEntity)pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getAggPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDE();
        }
        if (this.getAggPSDEId() == null) {
            return null;
        }
        Integer n = this.objAggPSDELock;
        synchronized (n) {
            if (this.aggpsde != null && DataTypeHelper.compare((int)25, (Object)this.getAggPSDEId(), (Object)this.aggpsde.getPSDataEntityId()) != 0L) {
                this.aggpsde = null;
            }
            if (this.aggpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getAggPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.aggpsde = pSDataEntity;
            }
            return this.aggpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getAggPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEAction();
        }
        if (this.getAggPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objAggPSDEActionLock;
        synchronized (n) {
            if (this.aggpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getAggPSDEActionId(), (Object)this.aggpsdeaction.getPSDEActionId()) != 0L) {
                this.aggpsdeaction = null;
            }
            if (this.aggpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getAggPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.aggpsdeaction = pSDEAction;
            }
            return this.aggpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getCopyPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCopyPSDEAction();
        }
        if (this.getCopyPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCopyPSDEActionLock;
        synchronized (n) {
            if (this.copypsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCopyPSDEActionId(), (Object)this.copypsdeaction.getPSDEActionId()) != 0L) {
                this.copypsdeaction = null;
            }
            if (this.copypsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCopyPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.copypsdeaction = pSDEAction;
            }
            return this.copypsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getCreatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEAction();
        }
        if (this.getCreatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEActionLock;
        synchronized (n) {
            if (this.createpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEActionId(), (Object)this.createpsdeaction.getPSDEActionId()) != 0L) {
                this.createpsdeaction = null;
            }
            if (this.createpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCreatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.createpsdeaction = pSDEAction;
            }
            return this.createpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getGetDraftPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDraftPSDEAction();
        }
        if (this.getGetDraftPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGetDraftPSDEActionLock;
        synchronized (n) {
            if (this.getdraftpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGetDraftPSDEActionId(), (Object)this.getdraftpsdeaction.getPSDEActionId()) != 0L) {
                this.getdraftpsdeaction = null;
            }
            if (this.getdraftpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGetDraftPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.getdraftpsdeaction = pSDEAction;
            }
            return this.getdraftpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getGetPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetPSDEAction();
        }
        if (this.getGetPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGetPSDEActionLock;
        synchronized (n) {
            if (this.getpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGetPSDEActionId(), (Object)this.getpsdeaction.getPSDEActionId()) != 0L) {
                this.getpsdeaction = null;
            }
            if (this.getpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGetPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.getpsdeaction = pSDEAction;
            }
            return this.getpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getMovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMovePSDEAction();
        }
        if (this.getMovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objMovePSDEActionLock;
        synchronized (n) {
            if (this.movepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getMovePSDEActionId(), (Object)this.movepsdeaction.getPSDEActionId()) != 0L) {
                this.movepsdeaction = null;
            }
            if (this.movepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getMovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.movepsdeaction = pSDEAction;
            }
            return this.movepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getRemovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemovePSDEAction();
        }
        if (this.getRemovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objRemovePSDEActionLock;
        synchronized (n) {
            if (this.removepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getRemovePSDEActionId(), (Object)this.removepsdeaction.getPSDEActionId()) != 0L) {
                this.removepsdeaction = null;
            }
            if (this.removepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getRemovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.removepsdeaction = pSDEAction;
            }
            return this.removepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUpdatePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdatePSDEAction();
        }
        if (this.getUpdatePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUpdatePSDEActionLock;
        synchronized (n) {
            if (this.updatepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUpdatePSDEActionId(), (Object)this.updatepsdeaction.getPSDEActionId()) != 0L) {
                this.updatepsdeaction = null;
            }
            if (this.updatepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUpdatePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.updatepsdeaction = pSDEAction;
            }
            return this.updatepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUser2PSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEAction();
        }
        if (this.getUser2PSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEActionLock;
        synchronized (n) {
            if (this.user2psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEActionId(), (Object)this.user2psdeaction.getPSDEActionId()) != 0L) {
                this.user2psdeaction = null;
            }
            if (this.user2psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUser2PSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.user2psdeaction = pSDEAction;
            }
            return this.user2psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getUserPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEAction();
        }
        if (this.getUserPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEActionLock;
        synchronized (n) {
            if (this.userpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEActionId(), (Object)this.userpsdeaction.getPSDEActionId()) != 0L) {
                this.userpsdeaction = null;
            }
            if (this.userpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getUserPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.userpsdeaction = pSDEAction;
            }
            return this.userpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getAggPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSDEDS();
        }
        if (this.getAggPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objAggPSDEDSLock;
        synchronized (n) {
            if (this.aggpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getAggPSDEDSId(), (Object)this.aggpsdeds.getPSDEDataSetId()) != 0L) {
                this.aggpsdeds = null;
            }
            if (this.aggpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getAggPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.aggpsdeds = pSDEDataSet;
            }
            return this.aggpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getAsyncPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAsyncPSDEDS();
        }
        if (this.getAsyncPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objAsyncPSDEDSLock;
        synchronized (n) {
            if (this.asyncpsdeds != null && DataTypeHelper.compare((int)25, (Object)this.getAsyncPSDEDSId(), (Object)this.asyncpsdeds.getPSDEDataSetId()) != 0L) {
                this.asyncpsdeds = null;
            }
            if (this.asyncpsdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getAsyncPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.asyncpsdeds = pSDEDataSet;
            }
            return this.asyncpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getGroupPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEF();
        }
        if (this.getGroupPSDEFId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDEFLock;
        synchronized (n) {
            if (this.grouppsdef != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEFId(), (Object)this.grouppsdef.getPSDEFieldId()) != 0L) {
                this.grouppsdef = null;
            }
            if (this.grouppsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getGroupPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.grouppsdef = pSDEField;
            }
            return this.grouppsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getGroupTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTextPSDEF();
        }
        if (this.getGroupTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objGroupTextPSDEFLock;
        synchronized (n) {
            if (this.grouptextpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getGroupTextPSDEFId(), (Object)this.grouptextpsdef.getPSDEFieldId()) != 0L) {
                this.grouptextpsdef = null;
            }
            if (this.grouptextpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getGroupTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.grouptextpsdef = pSDEField;
            }
            return this.grouptextpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMinorSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEF();
        }
        if (this.getMinorSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorSortPSDEFLock;
        synchronized (n) {
            if (this.minorsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorSortPSDEFId(), (Object)this.minorsortpsdef.getPSDEFieldId()) != 0L) {
                this.minorsortpsdef = null;
            }
            if (this.minorsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.minorsortpsdef = pSDEField;
            }
            return this.minorsortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getOrderValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValuePSDEF();
        }
        if (this.getOrderValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objOrderValuePSDEFLock;
        synchronized (n) {
            if (this.ordervaluepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getOrderValuePSDEFId(), (Object)this.ordervaluepsdef.getPSDEFieldId()) != 0L) {
                this.ordervaluepsdef = null;
            }
            if (this.ordervaluepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getOrderValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.ordervaluepsdef = pSDEField;
            }
            return this.ordervaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTreePPSEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreePPSEF();
        }
        if (this.getTreePPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTreePPSEFLock;
        synchronized (n) {
            if (this.treeppsef != null && DataTypeHelper.compare((int)25, (Object)this.getTreePPSDEFId(), (Object)this.treeppsef.getPSDEFieldId()) != 0L) {
                this.treeppsef = null;
            }
            if (this.treeppsef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTreePPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.treeppsef = pSDEField;
            }
            return this.treeppsef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFInputTipSet getPSDEFInputTipSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSet();
        }
        if (this.getPSDEFInputTipSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEFInputTipSetLock;
        synchronized (n) {
            if (this.psdefinputtipset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFInputTipSetId(), (Object)this.psdefinputtipset.getPSDEFInputTipSetId()) != 0L) {
                this.psdefinputtipset = null;
            }
            if (this.psdefinputtipset == null) {
                PSDEFInputTipSet pSDEFInputTipSet = new PSDEFInputTipSet();
                pSDEFInputTipSet.setPSDEFInputTipSetId(this.getPSDEFInputTipSetId());
                PSDEFInputTipSetService pSDEFInputTipSetService = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEFInputTipSetService.autoGet((IEntity)pSDEFInputTipSet);
                this.psdefinputtipset = pSDEFInputTipSet;
            }
            return this.psdefinputtipset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getNavPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDER();
        }
        if (this.getNavPSDERId() == null) {
            return null;
        }
        Integer n = this.objNavPSDERLock;
        synchronized (n) {
            if (this.navpsder != null && DataTypeHelper.compare((int)25, (Object)this.getNavPSDERId(), (Object)this.navpsder.getPSDERId()) != 0L) {
                this.navpsder = null;
            }
            if (this.navpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getNavPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.navpsder = pSDER;
            }
            return this.navpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getBatPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBatPSDEToolbar();
        }
        if (this.getBatPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objBatPSDEToolbarLock;
        synchronized (n) {
            if (this.batpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getBatPSDEToolbarId(), (Object)this.batpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.batpsdetoolbar = null;
            }
            if (this.batpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getBatPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.batpsdetoolbar = pSDEToolbar;
            }
            return this.batpsdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getQuickPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEToolbar();
        }
        if (this.getQuickPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objQuickPSDEToolbarLock;
        synchronized (n) {
            if (this.quickpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getQuickPSDEToolbarId(), (Object)this.quickpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.quickpsdetoolbar = null;
            }
            if (this.quickpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getQuickPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet((IEntity)pSDEToolbar);
                this.quickpsdetoolbar = pSDEToolbar;
            }
            return this.quickpsdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getGroupPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEUAGroup();
        }
        if (this.getGroupPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDEUAGroupLock;
        synchronized (n) {
            if (this.grouppsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEUAGroupId(), (Object)this.grouppsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.grouppsdeuagroup = null;
            }
            if (this.grouppsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getGroupPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.grouppsdeuagroup = pSDEUAGroup;
            }
            return this.grouppsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getNavPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNavPSDEViewBase();
        }
        if (this.getNavPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objNavPSDEViewBaseLock;
        synchronized (n) {
            if (this.navpsdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getNavPSDEViewBaseId(), (Object)this.navpsdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.navpsdeviewbase = null;
            }
            if (this.navpsdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getNavPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.navpsdeviewbase = pSDEViewBase;
            }
            return this.navpsdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getEmptyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanRes();
        }
        if (this.getEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objEmptyTextPSLanResLock;
        synchronized (n) {
            if (this.emptytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getEmptyTextPSLanResId(), (Object)this.emptytextpslanres.getPSLanguageResId()) != 0L) {
                this.emptytextpslanres = null;
            }
            if (this.emptytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.emptytextpslanres = pSLanguageRes;
            }
            return this.emptytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getGroupPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysCss();
        }
        if (this.getGroupPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objGroupPSSysCssLock;
        synchronized (n) {
            if (this.grouppssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSSysCssId(), (Object)this.grouppssyscss.getPSSysCssId()) != 0L) {
                this.grouppssyscss = null;
            }
            if (this.grouppssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getGroupPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.grouppssyscss = pSSysCss;
            }
            return this.grouppssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getItemPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysCss();
        }
        if (this.getItemPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objItemPSSysCssLock;
        synchronized (n) {
            if (this.itempssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getItemPSSysCssId(), (Object)this.itempssyscss.getPSSysCssId()) != 0L) {
                this.itempssyscss = null;
            }
            if (this.itempssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getItemPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.itempssyscss = pSSysCss;
            }
            return this.itempssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getGroupPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSSysPFPlugin();
        }
        if (this.getGroupPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGroupPSSysPFPluginLock;
        synchronized (n) {
            if (this.grouppssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSSysPFPluginId(), (Object)this.grouppssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.grouppssyspfplugin = null;
            }
            if (this.grouppssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGroupPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.grouppssyspfplugin = pSSysPFPlugin;
            }
            return this.grouppssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getAggPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggPSSysViewPanel();
        }
        if (this.getAggPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objAggPSSysViewPanelLock;
        synchronized (n) {
            if (this.aggpssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getAggPSSysViewPanelId(), (Object)this.aggpssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.aggpssysviewpanel = null;
            }
            if (this.aggpssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getAggPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.aggpssysviewpanel = pSSysViewPanel;
            }
            return this.aggpssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGEIUpdate> getPSDEGEIUpdates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdates();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGEIUpdatesLock;
        synchronized (n) {
            if (this.psdegeiupdates == null) {
                this.psdegeiupdates = pSDEGridService.isTempData((IEntity)this) ? pSDEGEIUpdateService.selectTempByPSDEGrid(this) : pSDEGEIUpdateService.selectByPSDEGrid(this);
            }
            return this.psdegeiupdates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGridCol> getPSDEGridCols() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridCols();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGridColsLock;
        synchronized (n) {
            if (this.psdegridcols == null) {
                this.psdegridcols = pSDEGridService.isTempData((IEntity)this) ? pSDEGridColService.selectTempByPSDEGrid(this) : pSDEGridColService.selectByPSDEGrid(this);
            }
            return this.psdegridcols;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGridLogic> getPSDEGridLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridLogics();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGridLogicsLock;
        synchronized (n) {
            if (this.psdegridlogics == null) {
                this.psdegridlogics = pSDEGridService.isTempData((IEntity)this) ? pSDEGridLogicService.selectTempByPSDEGrid(this) : pSDEGridLogicService.selectByPSDEGrid(this);
            }
            return this.psdegridlogics;
        }
    }

    private PSDEGridBase getProxyEntity() {
        return this.proxyPSDEGridBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGridBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGridBase) {
            this.proxyPSDEGridBase = (PSDEGridBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGMODE, 0);
        fieldIndexMap.put(FIELD_AGGPSDEACTIONID, 1);
        fieldIndexMap.put(FIELD_AGGPSDEACTIONNAME, 2);
        fieldIndexMap.put(FIELD_AGGPSDEDSID, 3);
        fieldIndexMap.put(FIELD_AGGPSDEDSNAME, 4);
        fieldIndexMap.put(FIELD_AGGPSDEID, 5);
        fieldIndexMap.put(FIELD_AGGPSDENAME, 6);
        fieldIndexMap.put(FIELD_AGGPSSYSVIEWPANELID, 7);
        fieldIndexMap.put(FIELD_AGGPSSYSVIEWPANELNAME, 8);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSID, 9);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSNAME, 10);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARID, 11);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARNAME, 12);
        fieldIndexMap.put(FIELD_BUFFERRENDERERMODE, 13);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 14);
        fieldIndexMap.put(FIELD_CODENAME, 15);
        fieldIndexMap.put(FIELD_COLENABLEFILTER, 16);
        fieldIndexMap.put(FIELD_COLENABLELINK, 17);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONID, 18);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONNAME, 19);
        fieldIndexMap.put(FIELD_CREATEDATE, 20);
        fieldIndexMap.put(FIELD_CREATEMAN, 21);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 22);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 23);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 24);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 25);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 26);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 27);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 28);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 29);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 30);
        fieldIndexMap.put(FIELD_ENABLEEDIT, 31);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 32);
        fieldIndexMap.put(FIELD_ENABLEPAGINGBAR, 33);
        fieldIndexMap.put(FIELD_FORCEFIT, 34);
        fieldIndexMap.put(FIELD_FROZENCOL, 35);
        fieldIndexMap.put(FIELD_FROZENLASTCOL, 36);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONID, 37);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONNAME, 38);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 39);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 40);
        fieldIndexMap.put(FIELD_GRIDMODEL, 41);
        fieldIndexMap.put(FIELD_GRIDSN, 42);
        fieldIndexMap.put(FIELD_GRIDSTYLE, 43);
        fieldIndexMap.put(FIELD_GROUPMODE, 44);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTID, 45);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTNAME, 46);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 47);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 48);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPID, 49);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPNAME, 50);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSID, 51);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSNAME, 52);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINID, 53);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, 54);
        fieldIndexMap.put(FIELD_GROUPSTYLE, 55);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFID, 56);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFNAME, 57);
        fieldIndexMap.put(FIELD_IGNOREDSITEM, 58);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSID, 59);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSNAME, 60);
        fieldIndexMap.put(FIELD_LOCKFLAG, 61);
        fieldIndexMap.put(FIELD_MEMO, 62);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 63);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 64);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 65);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 66);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 67);
        fieldIndexMap.put(FIELD_MULTISELECT, 68);
        fieldIndexMap.put(FIELD_NAVPSDERID, 69);
        fieldIndexMap.put(FIELD_NAVPSDERNAME, 70);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASEID, 71);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASENAME, 72);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 73);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 74);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 75);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 76);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 77);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 78);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 79);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 80);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 81);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 82);
        fieldIndexMap.put(FIELD_NOSORT, 83);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 84);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 85);
        fieldIndexMap.put(FIELD_PAGINGSIZE, 86);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 87);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 88);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 89);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 90);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 91);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 92);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 93);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 94);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETID, 95);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETNAME, 96);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 97);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 98);
        fieldIndexMap.put(FIELD_PSDEID, 99);
        fieldIndexMap.put(FIELD_PSDENAME, 100);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 101);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 102);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 103);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 104);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 105);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 106);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 107);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 108);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 109);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 110);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 111);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARID, 112);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARNAME, 113);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 114);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 115);
        fieldIndexMap.put(FIELD_SHOWHEADER, 116);
        fieldIndexMap.put(FIELD_SORTMODE, 117);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 118);
        fieldIndexMap.put(FIELD_TODOTASK, 119);
        fieldIndexMap.put(FIELD_TREEPPSDEFID, 120);
        fieldIndexMap.put(FIELD_TREEPPSDEFNAME, 121);
        fieldIndexMap.put(FIELD_UPDATEDATE, 122);
        fieldIndexMap.put(FIELD_UPDATEMAN, 123);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 124);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 125);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONID, 126);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONNAME, 127);
        fieldIndexMap.put(FIELD_USERPARAMS, 128);
        fieldIndexMap.put(FIELD_USERPSDEACTIONID, 129);
        fieldIndexMap.put(FIELD_USERPSDEACTIONNAME, 130);
    }
}

