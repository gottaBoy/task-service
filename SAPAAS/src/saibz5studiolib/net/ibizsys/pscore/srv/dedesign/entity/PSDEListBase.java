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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEListBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_APPENDDEITEMS = "APPENDDEITEMS";
    public static final String FIELD_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String FIELD_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String FIELD_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String FIELD_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
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
    public static final String FIELD_ENABLEEDIT = "ENABLEEDIT";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String FIELD_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String FIELD_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String FIELD_GROUPBARCLOSEMODE = "GROUPBARCLOSEMODE";
    public static final String FIELD_GROUPMODE = "GROUPMODE";
    public static final String FIELD_GROUPMOVEPSDEACTIONID = "GROUPMOVEPSDEACTIONID";
    public static final String FIELD_GROUPMOVEPSDEACTIONNAME = "GROUPMOVEPSDEACTIONNAME";
    public static final String FIELD_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String FIELD_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String FIELD_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String FIELD_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String FIELD_GROUPPSDEID = "GROUPPSDEID";
    public static final String FIELD_GROUPPSDENAME = "GROUPPSDENAME";
    public static final String FIELD_GROUPPSDEUAGROUPID = "GROUPPSDEUAGROUPID";
    public static final String FIELD_GROUPPSDEUAGROUPNAME = "GROUPPSDEUAGROUPNAME";
    public static final String FIELD_GROUPPSSYSCSSID = "GROUPPSSYSCSSID";
    public static final String FIELD_GROUPPSSYSCSSNAME = "GROUPPSSYSCSSNAME";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "GROUPPSSYSPFPLUGINID";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "GROUPPSSYSPFPLUGINNAME";
    public static final String FIELD_GROUPSTYLE = "GROUPSTYLE";
    public static final String FIELD_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String FIELD_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";
    public static final String FIELD_ITEMPSSYSCSSID = "ITEMPSSYSCSSID";
    public static final String FIELD_ITEMPSSYSCSSNAME = "ITEMPSSYSCSSNAME";
    public static final String FIELD_ITEMPSSYSPFPLUGINID = "ITEMPSSYSPFPLUGINID";
    public static final String FIELD_ITEMPSSYSPFPLUGINNAME = "ITEMPSSYSPFPLUGINNAME";
    public static final String FIELD_LISTMODEL = "LISTMODEL";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_LVTAG = "LVTAG";
    public static final String FIELD_LVTAG2 = "LVTAG2";
    public static final String FIELD_LVTAG3 = "LVTAG3";
    public static final String FIELD_LVTAG4 = "LVTAG4";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_MOBLISTSTYLE = "MOBLISTSTYLE";
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
    public static final String FIELD_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String FIELD_PAGESIZE = "PAGESIZE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String FIELD_SHOWHEADER = "SHOWHEADER";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SWIMLANEPSCODELISTID = "SWIMLANEPSCODELISTID";
    public static final String FIELD_SWIMLANEPSCODELISTNAME = "SWIMLANEPSCODELISTNAME";
    public static final String FIELD_SWIMLANEPSDEFID = "SWIMLANEPSDEFID";
    public static final String FIELD_SWIMLANEPSDEFNAME = "SWIMLANEPSDEFNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String FIELD_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String FIELD_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String FIELD_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String FIELD_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_ADPSDELOGICID = 0;
    private static final int INDEX_ADPSDELOGICNAME = 1;
    private static final int INDEX_APPENDDEITEMS = 2;
    private static final int INDEX_ASYNCPSDEDSID = 3;
    private static final int INDEX_ASYNCPSDEDSNAME = 4;
    private static final int INDEX_BATPSDETOOLBARID = 5;
    private static final int INDEX_BATPSDETOOLBARNAME = 6;
    private static final int INDEX_BUSYINDICATOR = 7;
    private static final int INDEX_CODENAME = 8;
    private static final int INDEX_COPYPSDEACTIONID = 9;
    private static final int INDEX_COPYPSDEACTIONNAME = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_CREATEPSDEACTIONID = 13;
    private static final int INDEX_CREATEPSDEACTIONNAME = 14;
    private static final int INDEX_CUSTOMCOND = 15;
    private static final int INDEX_CUSTOMTYPE = 16;
    private static final int INDEX_DYNAMODELFLAG = 17;
    private static final int INDEX_EMPTYTEXT = 18;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 19;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 20;
    private static final int INDEX_ENABLEEDIT = 21;
    private static final int INDEX_ENABLEITEMPRIV = 22;
    private static final int INDEX_ENABLEPAGINGBAR = 23;
    private static final int INDEX_GETDRAFTPSDEACTIONID = 24;
    private static final int INDEX_GETDRAFTPSDEACTIONNAME = 25;
    private static final int INDEX_GETPSDEACTIONID = 26;
    private static final int INDEX_GETPSDEACTIONNAME = 27;
    private static final int INDEX_GROUPBARCLOSEMODE = 28;
    private static final int INDEX_GROUPMODE = 29;
    private static final int INDEX_GROUPMOVEPSDEACTIONID = 30;
    private static final int INDEX_GROUPMOVEPSDEACTIONNAME = 31;
    private static final int INDEX_GROUPPSCODELISTID = 32;
    private static final int INDEX_GROUPPSCODELISTNAME = 33;
    private static final int INDEX_GROUPPSDEFID = 34;
    private static final int INDEX_GROUPPSDEFNAME = 35;
    private static final int INDEX_GROUPPSDEID = 36;
    private static final int INDEX_GROUPPSDENAME = 37;
    private static final int INDEX_GROUPPSDEUAGROUPID = 38;
    private static final int INDEX_GROUPPSDEUAGROUPNAME = 39;
    private static final int INDEX_GROUPPSSYSCSSID = 40;
    private static final int INDEX_GROUPPSSYSCSSNAME = 41;
    private static final int INDEX_GROUPPSSYSPFPLUGINID = 42;
    private static final int INDEX_GROUPPSSYSPFPLUGINNAME = 43;
    private static final int INDEX_GROUPSTYLE = 44;
    private static final int INDEX_GROUPTEXTPSDEFID = 45;
    private static final int INDEX_GROUPTEXTPSDEFNAME = 46;
    private static final int INDEX_ITEMPSSYSCSSID = 47;
    private static final int INDEX_ITEMPSSYSCSSNAME = 48;
    private static final int INDEX_ITEMPSSYSPFPLUGINID = 49;
    private static final int INDEX_ITEMPSSYSPFPLUGINNAME = 50;
    private static final int INDEX_LISTMODEL = 51;
    private static final int INDEX_LOCKFLAG = 52;
    private static final int INDEX_LOGICNAME = 53;
    private static final int INDEX_LVTAG = 54;
    private static final int INDEX_LVTAG2 = 55;
    private static final int INDEX_LVTAG3 = 56;
    private static final int INDEX_LVTAG4 = 57;
    private static final int INDEX_MEMO = 58;
    private static final int INDEX_MINORSORTDIR = 59;
    private static final int INDEX_MINORSORTPSDEFID = 60;
    private static final int INDEX_MINORSORTPSDEFNAME = 61;
    private static final int INDEX_MOBLISTSTYLE = 62;
    private static final int INDEX_MOVEPSDEACTIONID = 63;
    private static final int INDEX_MOVEPSDEACTIONNAME = 64;
    private static final int INDEX_MULTISELECT = 65;
    private static final int INDEX_NAVPSDERID = 66;
    private static final int INDEX_NAVPSDERNAME = 67;
    private static final int INDEX_NAVPSDEVIEWBASEID = 68;
    private static final int INDEX_NAVPSDEVIEWBASENAME = 69;
    private static final int INDEX_NAVVIEWFILTER = 70;
    private static final int INDEX_NAVVIEWHEIGHT = 71;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 72;
    private static final int INDEX_NAVVIEWMAXWIDTH = 73;
    private static final int INDEX_NAVVIEWMINHEIGHT = 74;
    private static final int INDEX_NAVVIEWMINWIDTH = 75;
    private static final int INDEX_NAVVIEWPARAM = 76;
    private static final int INDEX_NAVVIEWPOS = 77;
    private static final int INDEX_NAVVIEWSHOWMODE = 78;
    private static final int INDEX_NAVVIEWWIDTH = 79;
    private static final int INDEX_NO2PSDEUAGROUPID = 80;
    private static final int INDEX_NO2PSDEUAGROUPNAME = 81;
    private static final int INDEX_NOSORT = 82;
    private static final int INDEX_ORDERVALUEPSDEFID = 83;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 84;
    private static final int INDEX_PAGESIZE = 85;
    private static final int INDEX_PSACHANDLERID = 86;
    private static final int INDEX_PSACHANDLERNAME = 87;
    private static final int INDEX_PSCTRLLOGICGROUPID = 88;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 89;
    private static final int INDEX_PSCTRLMSGID = 90;
    private static final int INDEX_PSCTRLMSGNAME = 91;
    private static final int INDEX_PSDEDSID = 92;
    private static final int INDEX_PSDEDSNAME = 93;
    private static final int INDEX_PSDEID = 94;
    private static final int INDEX_PSDELISTID = 95;
    private static final int INDEX_PSDELISTNAME = 96;
    private static final int INDEX_PSDENAME = 97;
    private static final int INDEX_PSDEUAGROUPID = 98;
    private static final int INDEX_PSDEUAGROUPNAME = 99;
    private static final int INDEX_PSDYNAINSTID = 100;
    private static final int INDEX_PSSYSCSSID = 101;
    private static final int INDEX_PSSYSCSSNAME = 102;
    private static final int INDEX_PSSYSPFPLUGINID = 103;
    private static final int INDEX_PSSYSPFPLUGINNAME = 104;
    private static final int INDEX_PSSYSREQITEMID = 105;
    private static final int INDEX_PSSYSREQITEMNAME = 106;
    private static final int INDEX_PSSYSVIEWPANELID = 107;
    private static final int INDEX_PSSYSVIEWPANELNAME = 108;
    private static final int INDEX_PSVIEWMSGGROUPID = 109;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 110;
    private static final int INDEX_QUICKPSDETOOLBARID = 111;
    private static final int INDEX_QUICKPSDETOOLBARNAME = 112;
    private static final int INDEX_REMOVEPSDEACTIONID = 113;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 114;
    private static final int INDEX_SHOWHEADER = 115;
    private static final int INDEX_SRFSYSPUB = 116;
    private static final int INDEX_SWIMLANEPSCODELISTID = 117;
    private static final int INDEX_SWIMLANEPSCODELISTNAME = 118;
    private static final int INDEX_SWIMLANEPSDEFID = 119;
    private static final int INDEX_SWIMLANEPSDEFNAME = 120;
    private static final int INDEX_TODOTASK = 121;
    private static final int INDEX_UPDATEDATE = 122;
    private static final int INDEX_UPDATEMAN = 123;
    private static final int INDEX_UPDATEPSDEACTIONID = 124;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 125;
    private static final int INDEX_USER2PSDEACTIONID = 126;
    private static final int INDEX_USER2PSDEACTIONNAME = 127;
    private static final int INDEX_USERPSDEACTIONID = 128;
    private static final int INDEX_USERPSDEACTIONNAME = 129;
    private static final int INDEX_USERTAG = 130;
    private static final int INDEX_USERTAG2 = 131;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEListBase proxyPSDEListBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean appenddeitemsDirtyFlag = false;
    private boolean asyncpsdedsidDirtyFlag = false;
    private boolean asyncpsdedsnameDirtyFlag = false;
    private boolean batpsdetoolbaridDirtyFlag = false;
    private boolean batpsdetoolbarnameDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
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
    private boolean enableeditDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablepagingbarDirtyFlag = false;
    private boolean getdraftpsdeactionidDirtyFlag = false;
    private boolean getdraftpsdeactionnameDirtyFlag = false;
    private boolean getpsdeactionidDirtyFlag = false;
    private boolean getpsdeactionnameDirtyFlag = false;
    private boolean groupbarclosemodeDirtyFlag = false;
    private boolean groupmodeDirtyFlag = false;
    private boolean groupmovepsdeactionidDirtyFlag = false;
    private boolean groupmovepsdeactionnameDirtyFlag = false;
    private boolean grouppscodelistidDirtyFlag = false;
    private boolean grouppscodelistnameDirtyFlag = false;
    private boolean grouppsdefidDirtyFlag = false;
    private boolean grouppsdefnameDirtyFlag = false;
    private boolean grouppsdeidDirtyFlag = false;
    private boolean grouppsdenameDirtyFlag = false;
    private boolean grouppsdeuagroupidDirtyFlag = false;
    private boolean grouppsdeuagroupnameDirtyFlag = false;
    private boolean grouppssyscssidDirtyFlag = false;
    private boolean grouppssyscssnameDirtyFlag = false;
    private boolean grouppssyspfpluginidDirtyFlag = false;
    private boolean grouppssyspfpluginnameDirtyFlag = false;
    private boolean groupstyleDirtyFlag = false;
    private boolean grouptextpsdefidDirtyFlag = false;
    private boolean grouptextpsdefnameDirtyFlag = false;
    private boolean itempssyscssidDirtyFlag = false;
    private boolean itempssyscssnameDirtyFlag = false;
    private boolean itempssyspfpluginidDirtyFlag = false;
    private boolean itempssyspfpluginnameDirtyFlag = false;
    private boolean listmodelDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean lvtagDirtyFlag = false;
    private boolean lvtag2DirtyFlag = false;
    private boolean lvtag3DirtyFlag = false;
    private boolean lvtag4DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean mobliststyleDirtyFlag = false;
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
    private boolean no2psdeuagroupidDirtyFlag = false;
    private boolean no2psdeuagroupnameDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean ordervaluepsdefidDirtyFlag = false;
    private boolean ordervaluepsdefnameDirtyFlag = false;
    private boolean pagesizeDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean quickpsdetoolbaridDirtyFlag = false;
    private boolean quickpsdetoolbarnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
    private boolean showheaderDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean swimlanepscodelistidDirtyFlag = false;
    private boolean swimlanepscodelistnameDirtyFlag = false;
    private boolean swimlanepsdefidDirtyFlag = false;
    private boolean swimlanepsdefnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatepsdeactionidDirtyFlag = false;
    private boolean updatepsdeactionnameDirtyFlag = false;
    private boolean user2psdeactionidDirtyFlag = false;
    private boolean user2psdeactionnameDirtyFlag = false;
    private boolean userpsdeactionidDirtyFlag = false;
    private boolean userpsdeactionnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="appenddeitems")
    private Integer appenddeitems;
    @Column(name="asyncpsdedsid")
    private String asyncpsdedsid;
    @Column(name="asyncpsdedsname")
    private String asyncpsdedsname;
    @Column(name="batpsdetoolbarid")
    private String batpsdetoolbarid;
    @Column(name="batpsdetoolbarname")
    private String batpsdetoolbarname;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
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
    @Column(name="enableedit")
    private Integer enableedit;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enablepagingbar")
    private Integer enablepagingbar;
    @Column(name="getdraftpsdeactionid")
    private String getdraftpsdeactionid;
    @Column(name="getdraftpsdeactionname")
    private String getdraftpsdeactionname;
    @Column(name="getpsdeactionid")
    private String getpsdeactionid;
    @Column(name="getpsdeactionname")
    private String getpsdeactionname;
    @Column(name="groupbarclosemode")
    private Integer groupbarclosemode;
    @Column(name="groupmode")
    private String groupmode;
    @Column(name="groupmovepsdeactionid")
    private String groupmovepsdeactionid;
    @Column(name="groupmovepsdeactionname")
    private String groupmovepsdeactionname;
    @Column(name="grouppscodelistid")
    private String grouppscodelistid;
    @Column(name="grouppscodelistname")
    private String grouppscodelistname;
    @Column(name="grouppsdefid")
    private String grouppsdefid;
    @Column(name="grouppsdefname")
    private String grouppsdefname;
    @Column(name="grouppsdeid")
    private String grouppsdeid;
    @Column(name="grouppsdename")
    private String grouppsdename;
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
    @Column(name="itempssyscssid")
    private String itempssyscssid;
    @Column(name="itempssyscssname")
    private String itempssyscssname;
    @Column(name="itempssyspfpluginid")
    private String itempssyspfpluginid;
    @Column(name="itempssyspfpluginname")
    private String itempssyspfpluginname;
    @Column(name="listmodel")
    private String listmodel;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="lvtag")
    private String lvtag;
    @Column(name="lvtag2")
    private String lvtag2;
    @Column(name="lvtag3")
    private String lvtag3;
    @Column(name="lvtag4")
    private String lvtag4;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
    @Column(name="mobliststyle")
    private String mobliststyle;
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
    @Column(name="no2psdeuagroupid")
    private String no2psdeuagroupid;
    @Column(name="no2psdeuagroupname")
    private String no2psdeuagroupname;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="ordervaluepsdefid")
    private String ordervaluepsdefid;
    @Column(name="ordervaluepsdefname")
    private String ordervaluepsdefname;
    @Column(name="pagesize")
    private Integer pagesize;
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
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
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
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="swimlanepscodelistid")
    private String swimlanepscodelistid;
    @Column(name="swimlanepscodelistname")
    private String swimlanepscodelistname;
    @Column(name="swimlanepsdefid")
    private String swimlanepsdefid;
    @Column(name="swimlanepsdefname")
    private String swimlanepsdefname;
    @Column(name="todotask")
    private String todotask;
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
    @Column(name="userpsdeactionid")
    private String userpsdeactionid;
    @Column(name="userpsdeactionname")
    private String userpsdeactionname;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objGroupPSCodeListLock = new Integer(1);
    private PSCodeList grouppscodelist = null;
    private Integer objSwimlanePSCodeListLock = new Integer(1);
    private PSCodeList swimlanepscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objGroupPSDELock = new Integer(1);
    private PSDataEntity grouppsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objCopyPSDEActionLock = new Integer(1);
    private PSDEAction copypsdeaction = null;
    private Integer objCreatePSDEActionLock = new Integer(1);
    private PSDEAction createpsdeaction = null;
    private Integer objGetDraftPSDEActionLock = new Integer(1);
    private PSDEAction getdraftpsdeaction = null;
    private Integer objGetPSDEActionLock = new Integer(1);
    private PSDEAction getpsdeaction = null;
    private Integer objGroupMovePSDEActionLock = new Integer(1);
    private PSDEAction groupmovepsdeaction = null;
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
    private Integer objAsyncPSDEDSLock = new Integer(1);
    private PSDEDataSet asyncpsdeds = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objGroupPSDEFLock = new Integer(1);
    private PSDEField grouppsdef = null;
    private Integer objGroupTextPSDEFLock = new Integer(1);
    private PSDEField grouptextpsdef = null;
    private Integer objMinorSortPSDEFLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objOrderValuePSDEFLock = new Integer(1);
    private PSDEField ordervaluepsdef = null;
    private Integer objSwimlanePSDEFLock = new Integer(1);
    private PSDEField swimlanepsdef = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objNavPSDERLock = new Integer(1);
    private PSDER navpsder = null;
    private Integer objBatPSDEToolbarLock = new Integer(1);
    private PSDEToolbar batpsdetoolbar = null;
    private Integer objQuickPSDEToolbarLock = new Integer(1);
    private PSDEToolbar quickpsdetoolbar = null;
    private Integer objGroupPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup grouppsdeuagroup = null;
    private Integer objNo2PSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup no2psdeuagroup = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
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
    private Integer objGroupPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin grouppssyspfplugin = null;
    private Integer objItemPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin itempssyspfplugin = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDEListItemsLock = new Integer(1);
    private ArrayList<PSDEListItem> psdelistitems = null;
    private Integer objPSDEListLogicsLock = new Integer(1);
    private ArrayList<PSDEListLogic> psdelistlogics = null;

    public void setADPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicid = string;
        this.adpsdelogicidDirtyFlag = true;
    }

    public String getADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicId();
        }
        return this.adpsdelogicid;
    }

    public boolean isADPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicIdDirty();
        }
        return this.adpsdelogicidDirtyFlag;
    }

    public void resetADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicId();
            return;
        }
        this.adpsdelogicidDirtyFlag = false;
        this.adpsdelogicid = null;
    }

    public void setADPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicname = string;
        this.adpsdelogicnameDirtyFlag = true;
    }

    public String getADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicName();
        }
        return this.adpsdelogicname;
    }

    public boolean isADPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicNameDirty();
        }
        return this.adpsdelogicnameDirtyFlag;
    }

    public void resetADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicName();
            return;
        }
        this.adpsdelogicnameDirtyFlag = false;
        this.adpsdelogicname = null;
    }

    public void setAppendDEItems(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppendDEItems(n);
            return;
        }
        this.appenddeitems = n;
        this.appenddeitemsDirtyFlag = true;
    }

    public Integer getAppendDEItems() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppendDEItems();
        }
        return this.appenddeitems;
    }

    public boolean isAppendDEItemsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppendDEItemsDirty();
        }
        return this.appenddeitemsDirtyFlag;
    }

    public void resetAppendDEItems() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppendDEItems();
            return;
        }
        this.appenddeitemsDirtyFlag = false;
        this.appenddeitems = null;
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

    public void setGroupBarCloseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupBarCloseMode(n);
            return;
        }
        this.groupbarclosemode = n;
        this.groupbarclosemodeDirtyFlag = true;
    }

    public Integer getGroupBarCloseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupBarCloseMode();
        }
        return this.groupbarclosemode;
    }

    public boolean isGroupBarCloseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupBarCloseModeDirty();
        }
        return this.groupbarclosemodeDirtyFlag;
    }

    public void resetGroupBarCloseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupBarCloseMode();
            return;
        }
        this.groupbarclosemodeDirtyFlag = false;
        this.groupbarclosemode = null;
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

    public void setGroupMovePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMovePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmovepsdeactionid = string;
        this.groupmovepsdeactionidDirtyFlag = true;
    }

    public String getGroupMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEActionId();
        }
        return this.groupmovepsdeactionid;
    }

    public boolean isGroupMovePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMovePSDEActionIdDirty();
        }
        return this.groupmovepsdeactionidDirtyFlag;
    }

    public void resetGroupMovePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMovePSDEActionId();
            return;
        }
        this.groupmovepsdeactionidDirtyFlag = false;
        this.groupmovepsdeactionid = null;
    }

    public void setGroupMovePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupMovePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupmovepsdeactionname = string;
        this.groupmovepsdeactionnameDirtyFlag = true;
    }

    public String getGroupMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEActionName();
        }
        return this.groupmovepsdeactionname;
    }

    public boolean isGroupMovePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupMovePSDEActionNameDirty();
        }
        return this.groupmovepsdeactionnameDirtyFlag;
    }

    public void resetGroupMovePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupMovePSDEActionName();
            return;
        }
        this.groupmovepsdeactionnameDirtyFlag = false;
        this.groupmovepsdeactionname = null;
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

    public void setGroupPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdeid = string;
        this.grouppsdeidDirtyFlag = true;
    }

    public String getGroupPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEId();
        }
        return this.grouppsdeid;
    }

    public boolean isGroupPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDEIdDirty();
        }
        return this.grouppsdeidDirtyFlag;
    }

    public void resetGroupPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEId();
            return;
        }
        this.grouppsdeidDirtyFlag = false;
        this.grouppsdeid = null;
    }

    public void setGroupPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouppsdename = string;
        this.grouppsdenameDirtyFlag = true;
    }

    public String getGroupPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDEName();
        }
        return this.grouppsdename;
    }

    public boolean isGroupPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupPSDENameDirty();
        }
        return this.grouppsdenameDirtyFlag;
    }

    public void resetGroupPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupPSDEName();
            return;
        }
        this.grouppsdenameDirtyFlag = false;
        this.grouppsdename = null;
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

    public void setItemPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempssyspfpluginid = string;
        this.itempssyspfpluginidDirtyFlag = true;
    }

    public String getItemPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysPFPluginId();
        }
        return this.itempssyspfpluginid;
    }

    public boolean isItemPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSSysPFPluginIdDirty();
        }
        return this.itempssyspfpluginidDirtyFlag;
    }

    public void resetItemPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSSysPFPluginId();
            return;
        }
        this.itempssyspfpluginidDirtyFlag = false;
        this.itempssyspfpluginid = null;
    }

    public void setItemPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempssyspfpluginname = string;
        this.itempssyspfpluginnameDirtyFlag = true;
    }

    public String getItemPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysPFPluginName();
        }
        return this.itempssyspfpluginname;
    }

    public boolean isItemPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSSysPFPluginNameDirty();
        }
        return this.itempssyspfpluginnameDirtyFlag;
    }

    public void resetItemPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSSysPFPluginName();
            return;
        }
        this.itempssyspfpluginnameDirtyFlag = false;
        this.itempssyspfpluginname = null;
    }

    public void setListModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setListModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.listmodel = string;
        this.listmodelDirtyFlag = true;
    }

    public String getListModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getListModel();
        }
        return this.listmodel;
    }

    public boolean isListModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isListModelDirty();
        }
        return this.listmodelDirtyFlag;
    }

    public void resetListModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetListModel();
            return;
        }
        this.listmodelDirtyFlag = false;
        this.listmodel = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setLVTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLVTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lvtag = string;
        this.lvtagDirtyFlag = true;
    }

    public String getLVTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLVTag();
        }
        return this.lvtag;
    }

    public boolean isLVTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLVTagDirty();
        }
        return this.lvtagDirtyFlag;
    }

    public void resetLVTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLVTag();
            return;
        }
        this.lvtagDirtyFlag = false;
        this.lvtag = null;
    }

    public void setLVTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLVTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lvtag2 = string;
        this.lvtag2DirtyFlag = true;
    }

    public String getLVTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLVTag2();
        }
        return this.lvtag2;
    }

    public boolean isLVTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLVTag2Dirty();
        }
        return this.lvtag2DirtyFlag;
    }

    public void resetLVTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLVTag2();
            return;
        }
        this.lvtag2DirtyFlag = false;
        this.lvtag2 = null;
    }

    public void setLVTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLVTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lvtag3 = string;
        this.lvtag3DirtyFlag = true;
    }

    public String getLVTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLVTag3();
        }
        return this.lvtag3;
    }

    public boolean isLVTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLVTag3Dirty();
        }
        return this.lvtag3DirtyFlag;
    }

    public void resetLVTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLVTag3();
            return;
        }
        this.lvtag3DirtyFlag = false;
        this.lvtag3 = null;
    }

    public void setLVTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLVTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lvtag4 = string;
        this.lvtag4DirtyFlag = true;
    }

    public String getLVTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLVTag4();
        }
        return this.lvtag4;
    }

    public boolean isLVTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLVTag4Dirty();
        }
        return this.lvtag4DirtyFlag;
    }

    public void resetLVTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLVTag4();
            return;
        }
        this.lvtag4DirtyFlag = false;
        this.lvtag4 = null;
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

    public void setMobListStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobListStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobliststyle = string;
        this.mobliststyleDirtyFlag = true;
    }

    public String getMobListStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobListStyle();
        }
        return this.mobliststyle;
    }

    public boolean isMobListStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobListStyleDirty();
        }
        return this.mobliststyleDirtyFlag;
    }

    public void resetMobListStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobListStyle();
            return;
        }
        this.mobliststyleDirtyFlag = false;
        this.mobliststyle = null;
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

    public void setNo2PSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupid = string;
        this.no2psdeuagroupidDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupId();
        }
        return this.no2psdeuagroupid;
    }

    public boolean isNo2PSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupIdDirty();
        }
        return this.no2psdeuagroupidDirtyFlag;
    }

    public void resetNo2PSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupId();
            return;
        }
        this.no2psdeuagroupidDirtyFlag = false;
        this.no2psdeuagroupid = null;
    }

    public void setNo2PSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psdeuagroupname = string;
        this.no2psdeuagroupnameDirtyFlag = true;
    }

    public String getNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroupName();
        }
        return this.no2psdeuagroupname;
    }

    public boolean isNo2PSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSDEUAGroupNameDirty();
        }
        return this.no2psdeuagroupnameDirtyFlag;
    }

    public void resetNo2PSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSDEUAGroupName();
            return;
        }
        this.no2psdeuagroupnameDirtyFlag = false;
        this.no2psdeuagroupname = null;
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

    public void setPageSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageSize(n);
            return;
        }
        this.pagesize = n;
        this.pagesizeDirtyFlag = true;
    }

    public Integer getPageSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageSize();
        }
        return this.pagesize;
    }

    public boolean isPageSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageSizeDirty();
        }
        return this.pagesizeDirtyFlag;
    }

    public void resetPageSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageSize();
            return;
        }
        this.pagesizeDirtyFlag = false;
        this.pagesize = null;
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

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
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

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
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

    public void setSwimlanePSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwimlanePSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swimlanepscodelistid = string;
        this.swimlanepscodelistidDirtyFlag = true;
    }

    public String getSwimlanePSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSCodeListId();
        }
        return this.swimlanepscodelistid;
    }

    public boolean isSwimlanePSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwimlanePSCodeListIdDirty();
        }
        return this.swimlanepscodelistidDirtyFlag;
    }

    public void resetSwimlanePSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwimlanePSCodeListId();
            return;
        }
        this.swimlanepscodelistidDirtyFlag = false;
        this.swimlanepscodelistid = null;
    }

    public void setSwimlanePSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwimlanePSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swimlanepscodelistname = string;
        this.swimlanepscodelistnameDirtyFlag = true;
    }

    public String getSwimlanePSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSCodeListName();
        }
        return this.swimlanepscodelistname;
    }

    public boolean isSwimlanePSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwimlanePSCodeListNameDirty();
        }
        return this.swimlanepscodelistnameDirtyFlag;
    }

    public void resetSwimlanePSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwimlanePSCodeListName();
            return;
        }
        this.swimlanepscodelistnameDirtyFlag = false;
        this.swimlanepscodelistname = null;
    }

    public void setSwimlanePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwimlanePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swimlanepsdefid = string;
        this.swimlanepsdefidDirtyFlag = true;
    }

    public String getSwimlanePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSDEFId();
        }
        return this.swimlanepsdefid;
    }

    public boolean isSwimlanePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwimlanePSDEFIdDirty();
        }
        return this.swimlanepsdefidDirtyFlag;
    }

    public void resetSwimlanePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwimlanePSDEFId();
            return;
        }
        this.swimlanepsdefidDirtyFlag = false;
        this.swimlanepsdefid = null;
    }

    public void setSwimlanePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwimlanePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swimlanepsdefname = string;
        this.swimlanepsdefnameDirtyFlag = true;
    }

    public String getSwimlanePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSDEFName();
        }
        return this.swimlanepsdefname;
    }

    public boolean isSwimlanePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwimlanePSDEFNameDirty();
        }
        return this.swimlanepsdefnameDirtyFlag;
    }

    public void resetSwimlanePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwimlanePSDEFName();
            return;
        }
        this.swimlanepsdefnameDirtyFlag = false;
        this.swimlanepsdefname = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    protected void onReset() {
        PSDEListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEListBase pSDEListBase) {
        pSDEListBase.resetADPSDELogicId();
        pSDEListBase.resetADPSDELogicName();
        pSDEListBase.resetAppendDEItems();
        pSDEListBase.resetAsyncPSDEDSId();
        pSDEListBase.resetAsyncPSDEDSName();
        pSDEListBase.resetBatPSDEToolbarId();
        pSDEListBase.resetBatPSDEToolbarName();
        pSDEListBase.resetBusyIndicator();
        pSDEListBase.resetCodeName();
        pSDEListBase.resetCopyPSDEActionId();
        pSDEListBase.resetCopyPSDEActionName();
        pSDEListBase.resetCreateDate();
        pSDEListBase.resetCreateMan();
        pSDEListBase.resetCreatePSDEActionId();
        pSDEListBase.resetCreatePSDEActionName();
        pSDEListBase.resetCustomCond();
        pSDEListBase.resetCustomType();
        pSDEListBase.resetDynaModelFlag();
        pSDEListBase.resetEmptyText();
        pSDEListBase.resetEmptyTextPSLanResId();
        pSDEListBase.resetEmptyTextPSLanResName();
        pSDEListBase.resetEnableEdit();
        pSDEListBase.resetEnableItemPriv();
        pSDEListBase.resetEnablePagingBar();
        pSDEListBase.resetGetDraftPSDEActionId();
        pSDEListBase.resetGetDraftPSDEActionName();
        pSDEListBase.resetGetPSDEActionId();
        pSDEListBase.resetGetPSDEActionName();
        pSDEListBase.resetGroupBarCloseMode();
        pSDEListBase.resetGroupMode();
        pSDEListBase.resetGroupMovePSDEActionId();
        pSDEListBase.resetGroupMovePSDEActionName();
        pSDEListBase.resetGroupPSCodeListId();
        pSDEListBase.resetGroupPSCodeListName();
        pSDEListBase.resetGroupPSDEFId();
        pSDEListBase.resetGroupPSDEFName();
        pSDEListBase.resetGroupPSDEId();
        pSDEListBase.resetGroupPSDEName();
        pSDEListBase.resetGroupPSDEUAGroupId();
        pSDEListBase.resetGroupPSDEUAGroupName();
        pSDEListBase.resetGroupPSSysCssId();
        pSDEListBase.resetGroupPSSysCssName();
        pSDEListBase.resetGroupPSSysPFPluginId();
        pSDEListBase.resetGroupPSSysPFPluginName();
        pSDEListBase.resetGroupStyle();
        pSDEListBase.resetGroupTextPSDEFId();
        pSDEListBase.resetGroupTextPSDEFName();
        pSDEListBase.resetItemPSSysCssId();
        pSDEListBase.resetItemPSSysCssName();
        pSDEListBase.resetItemPSSysPFPluginId();
        pSDEListBase.resetItemPSSysPFPluginName();
        pSDEListBase.resetListModel();
        pSDEListBase.resetLockFlag();
        pSDEListBase.resetLogicName();
        pSDEListBase.resetLVTag();
        pSDEListBase.resetLVTag2();
        pSDEListBase.resetLVTag3();
        pSDEListBase.resetLVTag4();
        pSDEListBase.resetMemo();
        pSDEListBase.resetMinorSortDir();
        pSDEListBase.resetMinorSortPSDEFId();
        pSDEListBase.resetMinorSortPSDEFName();
        pSDEListBase.resetMobListStyle();
        pSDEListBase.resetMovePSDEActionId();
        pSDEListBase.resetMovePSDEActionName();
        pSDEListBase.resetMultiSelect();
        pSDEListBase.resetNavPSDERId();
        pSDEListBase.resetNavPSDERName();
        pSDEListBase.resetNavPSDEViewBaseId();
        pSDEListBase.resetNavPSDEViewBaseName();
        pSDEListBase.resetNavViewFilter();
        pSDEListBase.resetNavViewHeight();
        pSDEListBase.resetNavViewMaxHeight();
        pSDEListBase.resetNavViewMaxWidth();
        pSDEListBase.resetNavViewMinHeight();
        pSDEListBase.resetNavViewMinWidth();
        pSDEListBase.resetNavViewParam();
        pSDEListBase.resetNavViewPos();
        pSDEListBase.resetNavViewShowMode();
        pSDEListBase.resetNavViewWidth();
        pSDEListBase.resetNo2PSDEUAGroupId();
        pSDEListBase.resetNo2PSDEUAGroupName();
        pSDEListBase.resetNoSort();
        pSDEListBase.resetOrderValuePSDEFId();
        pSDEListBase.resetOrderValuePSDEFName();
        pSDEListBase.resetPageSize();
        pSDEListBase.resetPSACHandlerId();
        pSDEListBase.resetPSACHandlerName();
        pSDEListBase.resetPSCtrlLogicGroupId();
        pSDEListBase.resetPSCtrlLogicGroupName();
        pSDEListBase.resetPSCtrlMsgId();
        pSDEListBase.resetPSCtrlMsgName();
        pSDEListBase.resetPSDEDSId();
        pSDEListBase.resetPSDEDSName();
        pSDEListBase.resetPSDEId();
        pSDEListBase.resetPSDEListId();
        pSDEListBase.resetPSDEListName();
        pSDEListBase.resetPSDEName();
        pSDEListBase.resetPSDEUAGroupId();
        pSDEListBase.resetPSDEUAGroupName();
        pSDEListBase.resetPSDynaInstId();
        pSDEListBase.resetPSSysCssId();
        pSDEListBase.resetPSSysCssName();
        pSDEListBase.resetPSSysPFPluginId();
        pSDEListBase.resetPSSysPFPluginName();
        pSDEListBase.resetPSSysReqItemId();
        pSDEListBase.resetPSSysReqItemName();
        pSDEListBase.resetPSSysViewPanelId();
        pSDEListBase.resetPSSysViewPanelName();
        pSDEListBase.resetPSViewMsgGroupId();
        pSDEListBase.resetPSViewMsgGroupName();
        pSDEListBase.resetQuickPSDEToolbarId();
        pSDEListBase.resetQuickPSDEToolbarName();
        pSDEListBase.resetRemovePSDEActionId();
        pSDEListBase.resetRemovePSDEActionName();
        pSDEListBase.resetShowHeader();
        pSDEListBase.resetSRFSysPub();
        pSDEListBase.resetSwimlanePSCodeListId();
        pSDEListBase.resetSwimlanePSCodeListName();
        pSDEListBase.resetSwimlanePSDEFId();
        pSDEListBase.resetSwimlanePSDEFName();
        pSDEListBase.resetToDoTask();
        pSDEListBase.resetUpdateDate();
        pSDEListBase.resetUpdateMan();
        pSDEListBase.resetUpdatePSDEActionId();
        pSDEListBase.resetUpdatePSDEActionName();
        pSDEListBase.resetUser2PSDEActionId();
        pSDEListBase.resetUser2PSDEActionName();
        pSDEListBase.resetUserPSDEActionId();
        pSDEListBase.resetUserPSDEActionName();
        pSDEListBase.resetUserTag();
        pSDEListBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isAppendDEItemsDirty()) {
            hashMap.put(FIELD_APPENDDEITEMS, this.getAppendDEItems());
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
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isEnableEditDirty()) {
            hashMap.put(FIELD_ENABLEEDIT, this.getEnableEdit());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnablePagingBarDirty()) {
            hashMap.put(FIELD_ENABLEPAGINGBAR, this.getEnablePagingBar());
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
        if (!bl || this.isGroupBarCloseModeDirty()) {
            hashMap.put(FIELD_GROUPBARCLOSEMODE, this.getGroupBarCloseMode());
        }
        if (!bl || this.isGroupModeDirty()) {
            hashMap.put(FIELD_GROUPMODE, this.getGroupMode());
        }
        if (!bl || this.isGroupMovePSDEActionIdDirty()) {
            hashMap.put(FIELD_GROUPMOVEPSDEACTIONID, this.getGroupMovePSDEActionId());
        }
        if (!bl || this.isGroupMovePSDEActionNameDirty()) {
            hashMap.put(FIELD_GROUPMOVEPSDEACTIONNAME, this.getGroupMovePSDEActionName());
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
        if (!bl || this.isGroupPSDEIdDirty()) {
            hashMap.put(FIELD_GROUPPSDEID, this.getGroupPSDEId());
        }
        if (!bl || this.isGroupPSDENameDirty()) {
            hashMap.put(FIELD_GROUPPSDENAME, this.getGroupPSDEName());
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
        if (!bl || this.isItemPSSysCssIdDirty()) {
            hashMap.put(FIELD_ITEMPSSYSCSSID, this.getItemPSSysCssId());
        }
        if (!bl || this.isItemPSSysCssNameDirty()) {
            hashMap.put(FIELD_ITEMPSSYSCSSNAME, this.getItemPSSysCssName());
        }
        if (!bl || this.isItemPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_ITEMPSSYSPFPLUGINID, this.getItemPSSysPFPluginId());
        }
        if (!bl || this.isItemPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_ITEMPSSYSPFPLUGINNAME, this.getItemPSSysPFPluginName());
        }
        if (!bl || this.isListModelDirty()) {
            hashMap.put(FIELD_LISTMODEL, this.getListModel());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isLVTagDirty()) {
            hashMap.put(FIELD_LVTAG, this.getLVTag());
        }
        if (!bl || this.isLVTag2Dirty()) {
            hashMap.put(FIELD_LVTAG2, this.getLVTag2());
        }
        if (!bl || this.isLVTag3Dirty()) {
            hashMap.put(FIELD_LVTAG3, this.getLVTag3());
        }
        if (!bl || this.isLVTag4Dirty()) {
            hashMap.put(FIELD_LVTAG4, this.getLVTag4());
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
        if (!bl || this.isMobListStyleDirty()) {
            hashMap.put(FIELD_MOBLISTSTYLE, this.getMobListStyle());
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
        if (!bl || this.isNo2PSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPID, this.getNo2PSDEUAGroupId());
        }
        if (!bl || this.isNo2PSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_NO2PSDEUAGROUPNAME, this.getNo2PSDEUAGroupName());
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
        if (!bl || this.isPageSizeDirty()) {
            hashMap.put(FIELD_PAGESIZE, this.getPageSize());
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
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
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
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isSwimlanePSCodeListIdDirty()) {
            hashMap.put(FIELD_SWIMLANEPSCODELISTID, this.getSwimlanePSCodeListId());
        }
        if (!bl || this.isSwimlanePSCodeListNameDirty()) {
            hashMap.put(FIELD_SWIMLANEPSCODELISTNAME, this.getSwimlanePSCodeListName());
        }
        if (!bl || this.isSwimlanePSDEFIdDirty()) {
            hashMap.put(FIELD_SWIMLANEPSDEFID, this.getSwimlanePSDEFId());
        }
        if (!bl || this.isSwimlanePSDEFNameDirty()) {
            hashMap.put(FIELD_SWIMLANEPSDEFNAME, this.getSwimlanePSDEFName());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        if (!bl || this.isUserPSDEActionIdDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONID, this.getUserPSDEActionId());
        }
        if (!bl || this.isUserPSDEActionNameDirty()) {
            hashMap.put(FIELD_USERPSDEACTIONNAME, this.getUserPSDEActionName());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDEListBase.get(this, n);
    }

    private static Object get(PSDEListBase pSDEListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListBase.getADPSDELogicId();
            }
            case 1: {
                return pSDEListBase.getADPSDELogicName();
            }
            case 2: {
                return pSDEListBase.getAppendDEItems();
            }
            case 3: {
                return pSDEListBase.getAsyncPSDEDSId();
            }
            case 4: {
                return pSDEListBase.getAsyncPSDEDSName();
            }
            case 5: {
                return pSDEListBase.getBatPSDEToolbarId();
            }
            case 6: {
                return pSDEListBase.getBatPSDEToolbarName();
            }
            case 7: {
                return pSDEListBase.getBusyIndicator();
            }
            case 8: {
                return pSDEListBase.getCodeName();
            }
            case 9: {
                return pSDEListBase.getCopyPSDEActionId();
            }
            case 10: {
                return pSDEListBase.getCopyPSDEActionName();
            }
            case 11: {
                return pSDEListBase.getCreateDate();
            }
            case 12: {
                return pSDEListBase.getCreateMan();
            }
            case 13: {
                return pSDEListBase.getCreatePSDEActionId();
            }
            case 14: {
                return pSDEListBase.getCreatePSDEActionName();
            }
            case 15: {
                return pSDEListBase.getCustomCond();
            }
            case 16: {
                return pSDEListBase.getCustomType();
            }
            case 17: {
                return pSDEListBase.getDynaModelFlag();
            }
            case 18: {
                return pSDEListBase.getEmptyText();
            }
            case 19: {
                return pSDEListBase.getEmptyTextPSLanResId();
            }
            case 20: {
                return pSDEListBase.getEmptyTextPSLanResName();
            }
            case 21: {
                return pSDEListBase.getEnableEdit();
            }
            case 22: {
                return pSDEListBase.getEnableItemPriv();
            }
            case 23: {
                return pSDEListBase.getEnablePagingBar();
            }
            case 24: {
                return pSDEListBase.getGetDraftPSDEActionId();
            }
            case 25: {
                return pSDEListBase.getGetDraftPSDEActionName();
            }
            case 26: {
                return pSDEListBase.getGetPSDEActionId();
            }
            case 27: {
                return pSDEListBase.getGetPSDEActionName();
            }
            case 28: {
                return pSDEListBase.getGroupBarCloseMode();
            }
            case 29: {
                return pSDEListBase.getGroupMode();
            }
            case 30: {
                return pSDEListBase.getGroupMovePSDEActionId();
            }
            case 31: {
                return pSDEListBase.getGroupMovePSDEActionName();
            }
            case 32: {
                return pSDEListBase.getGroupPSCodeListId();
            }
            case 33: {
                return pSDEListBase.getGroupPSCodeListName();
            }
            case 34: {
                return pSDEListBase.getGroupPSDEFId();
            }
            case 35: {
                return pSDEListBase.getGroupPSDEFName();
            }
            case 36: {
                return pSDEListBase.getGroupPSDEId();
            }
            case 37: {
                return pSDEListBase.getGroupPSDEName();
            }
            case 38: {
                return pSDEListBase.getGroupPSDEUAGroupId();
            }
            case 39: {
                return pSDEListBase.getGroupPSDEUAGroupName();
            }
            case 40: {
                return pSDEListBase.getGroupPSSysCssId();
            }
            case 41: {
                return pSDEListBase.getGroupPSSysCssName();
            }
            case 42: {
                return pSDEListBase.getGroupPSSysPFPluginId();
            }
            case 43: {
                return pSDEListBase.getGroupPSSysPFPluginName();
            }
            case 44: {
                return pSDEListBase.getGroupStyle();
            }
            case 45: {
                return pSDEListBase.getGroupTextPSDEFId();
            }
            case 46: {
                return pSDEListBase.getGroupTextPSDEFName();
            }
            case 47: {
                return pSDEListBase.getItemPSSysCssId();
            }
            case 48: {
                return pSDEListBase.getItemPSSysCssName();
            }
            case 49: {
                return pSDEListBase.getItemPSSysPFPluginId();
            }
            case 50: {
                return pSDEListBase.getItemPSSysPFPluginName();
            }
            case 51: {
                return pSDEListBase.getListModel();
            }
            case 52: {
                return pSDEListBase.getLockFlag();
            }
            case 53: {
                return pSDEListBase.getLogicName();
            }
            case 54: {
                return pSDEListBase.getLVTag();
            }
            case 55: {
                return pSDEListBase.getLVTag2();
            }
            case 56: {
                return pSDEListBase.getLVTag3();
            }
            case 57: {
                return pSDEListBase.getLVTag4();
            }
            case 58: {
                return pSDEListBase.getMemo();
            }
            case 59: {
                return pSDEListBase.getMinorSortDir();
            }
            case 60: {
                return pSDEListBase.getMinorSortPSDEFId();
            }
            case 61: {
                return pSDEListBase.getMinorSortPSDEFName();
            }
            case 62: {
                return pSDEListBase.getMobListStyle();
            }
            case 63: {
                return pSDEListBase.getMovePSDEActionId();
            }
            case 64: {
                return pSDEListBase.getMovePSDEActionName();
            }
            case 65: {
                return pSDEListBase.getMultiSelect();
            }
            case 66: {
                return pSDEListBase.getNavPSDERId();
            }
            case 67: {
                return pSDEListBase.getNavPSDERName();
            }
            case 68: {
                return pSDEListBase.getNavPSDEViewBaseId();
            }
            case 69: {
                return pSDEListBase.getNavPSDEViewBaseName();
            }
            case 70: {
                return pSDEListBase.getNavViewFilter();
            }
            case 71: {
                return pSDEListBase.getNavViewHeight();
            }
            case 72: {
                return pSDEListBase.getNavViewMaxHeight();
            }
            case 73: {
                return pSDEListBase.getNavViewMaxWidth();
            }
            case 74: {
                return pSDEListBase.getNavViewMinHeight();
            }
            case 75: {
                return pSDEListBase.getNavViewMinWidth();
            }
            case 76: {
                return pSDEListBase.getNavViewParam();
            }
            case 77: {
                return pSDEListBase.getNavViewPos();
            }
            case 78: {
                return pSDEListBase.getNavViewShowMode();
            }
            case 79: {
                return pSDEListBase.getNavViewWidth();
            }
            case 80: {
                return pSDEListBase.getNo2PSDEUAGroupId();
            }
            case 81: {
                return pSDEListBase.getNo2PSDEUAGroupName();
            }
            case 82: {
                return pSDEListBase.getNoSort();
            }
            case 83: {
                return pSDEListBase.getOrderValuePSDEFId();
            }
            case 84: {
                return pSDEListBase.getOrderValuePSDEFName();
            }
            case 85: {
                return pSDEListBase.getPageSize();
            }
            case 86: {
                return pSDEListBase.getPSACHandlerId();
            }
            case 87: {
                return pSDEListBase.getPSACHandlerName();
            }
            case 88: {
                return pSDEListBase.getPSCtrlLogicGroupId();
            }
            case 89: {
                return pSDEListBase.getPSCtrlLogicGroupName();
            }
            case 90: {
                return pSDEListBase.getPSCtrlMsgId();
            }
            case 91: {
                return pSDEListBase.getPSCtrlMsgName();
            }
            case 92: {
                return pSDEListBase.getPSDEDSId();
            }
            case 93: {
                return pSDEListBase.getPSDEDSName();
            }
            case 94: {
                return pSDEListBase.getPSDEId();
            }
            case 95: {
                return pSDEListBase.getPSDEListId();
            }
            case 96: {
                return pSDEListBase.getPSDEListName();
            }
            case 97: {
                return pSDEListBase.getPSDEName();
            }
            case 98: {
                return pSDEListBase.getPSDEUAGroupId();
            }
            case 99: {
                return pSDEListBase.getPSDEUAGroupName();
            }
            case 100: {
                return pSDEListBase.getPSDynaInstId();
            }
            case 101: {
                return pSDEListBase.getPSSysCssId();
            }
            case 102: {
                return pSDEListBase.getPSSysCssName();
            }
            case 103: {
                return pSDEListBase.getPSSysPFPluginId();
            }
            case 104: {
                return pSDEListBase.getPSSysPFPluginName();
            }
            case 105: {
                return pSDEListBase.getPSSysReqItemId();
            }
            case 106: {
                return pSDEListBase.getPSSysReqItemName();
            }
            case 107: {
                return pSDEListBase.getPSSysViewPanelId();
            }
            case 108: {
                return pSDEListBase.getPSSysViewPanelName();
            }
            case 109: {
                return pSDEListBase.getPSViewMsgGroupId();
            }
            case 110: {
                return pSDEListBase.getPSViewMsgGroupName();
            }
            case 111: {
                return pSDEListBase.getQuickPSDEToolbarId();
            }
            case 112: {
                return pSDEListBase.getQuickPSDEToolbarName();
            }
            case 113: {
                return pSDEListBase.getRemovePSDEActionId();
            }
            case 114: {
                return pSDEListBase.getRemovePSDEActionName();
            }
            case 115: {
                return pSDEListBase.getShowHeader();
            }
            case 116: {
                return pSDEListBase.getSRFSysPub();
            }
            case 117: {
                return pSDEListBase.getSwimlanePSCodeListId();
            }
            case 118: {
                return pSDEListBase.getSwimlanePSCodeListName();
            }
            case 119: {
                return pSDEListBase.getSwimlanePSDEFId();
            }
            case 120: {
                return pSDEListBase.getSwimlanePSDEFName();
            }
            case 121: {
                return pSDEListBase.getToDoTask();
            }
            case 122: {
                return pSDEListBase.getUpdateDate();
            }
            case 123: {
                return pSDEListBase.getUpdateMan();
            }
            case 124: {
                return pSDEListBase.getUpdatePSDEActionId();
            }
            case 125: {
                return pSDEListBase.getUpdatePSDEActionName();
            }
            case 126: {
                return pSDEListBase.getUser2PSDEActionId();
            }
            case 127: {
                return pSDEListBase.getUser2PSDEActionName();
            }
            case 128: {
                return pSDEListBase.getUserPSDEActionId();
            }
            case 129: {
                return pSDEListBase.getUserPSDEActionName();
            }
            case 130: {
                return pSDEListBase.getUserTag();
            }
            case 131: {
                return pSDEListBase.getUserTag2();
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
        PSDEListBase.set(this, n, object);
    }

    private static void set(PSDEListBase pSDEListBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEListBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEListBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEListBase.setAppendDEItems(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEListBase.setAsyncPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEListBase.setAsyncPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEListBase.setBatPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEListBase.setBatPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEListBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEListBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEListBase.setCopyPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEListBase.setCopyPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEListBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDEListBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEListBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEListBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEListBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEListBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEListBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEListBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEListBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEListBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEListBase.setEnableEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEListBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEListBase.setEnablePagingBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEListBase.setGetDraftPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEListBase.setGetDraftPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEListBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEListBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEListBase.setGroupBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEListBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEListBase.setGroupMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEListBase.setGroupMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEListBase.setGroupPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEListBase.setGroupPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEListBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEListBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEListBase.setGroupPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEListBase.setGroupPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEListBase.setGroupPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEListBase.setGroupPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEListBase.setGroupPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEListBase.setGroupPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEListBase.setGroupPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEListBase.setGroupPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEListBase.setGroupStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEListBase.setGroupTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEListBase.setGroupTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEListBase.setItemPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEListBase.setItemPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEListBase.setItemPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEListBase.setItemPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEListBase.setListModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEListBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDEListBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEListBase.setLVTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEListBase.setLVTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEListBase.setLVTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEListBase.setLVTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEListBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEListBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEListBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEListBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEListBase.setMobListStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEListBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEListBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEListBase.setMultiSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSDEListBase.setNavPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEListBase.setNavPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEListBase.setNavPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEListBase.setNavPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEListBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEListBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 72: {
                pSDEListBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 73: {
                pSDEListBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 74: {
                pSDEListBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 75: {
                pSDEListBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 76: {
                pSDEListBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEListBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEListBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSDEListBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 80: {
                pSDEListBase.setNo2PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEListBase.setNo2PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEListBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDEListBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEListBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEListBase.setPageSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 86: {
                pSDEListBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEListBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEListBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEListBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEListBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEListBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEListBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEListBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEListBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEListBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEListBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEListBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEListBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEListBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEListBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEListBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEListBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEListBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEListBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEListBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEListBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEListBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEListBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEListBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEListBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEListBase.setQuickPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEListBase.setQuickPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEListBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEListBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEListBase.setShowHeader(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 116: {
                pSDEListBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEListBase.setSwimlanePSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEListBase.setSwimlanePSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDEListBase.setSwimlanePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEListBase.setSwimlanePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEListBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEListBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 123: {
                pSDEListBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDEListBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEListBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEListBase.setUser2PSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEListBase.setUser2PSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEListBase.setUserPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEListBase.setUserPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEListBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEListBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDEListBase.isNull(this, n);
    }

    private static boolean isNull(PSDEListBase pSDEListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSDEListBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSDEListBase.getAppendDEItems() == null;
            }
            case 3: {
                return pSDEListBase.getAsyncPSDEDSId() == null;
            }
            case 4: {
                return pSDEListBase.getAsyncPSDEDSName() == null;
            }
            case 5: {
                return pSDEListBase.getBatPSDEToolbarId() == null;
            }
            case 6: {
                return pSDEListBase.getBatPSDEToolbarName() == null;
            }
            case 7: {
                return pSDEListBase.getBusyIndicator() == null;
            }
            case 8: {
                return pSDEListBase.getCodeName() == null;
            }
            case 9: {
                return pSDEListBase.getCopyPSDEActionId() == null;
            }
            case 10: {
                return pSDEListBase.getCopyPSDEActionName() == null;
            }
            case 11: {
                return pSDEListBase.getCreateDate() == null;
            }
            case 12: {
                return pSDEListBase.getCreateMan() == null;
            }
            case 13: {
                return pSDEListBase.getCreatePSDEActionId() == null;
            }
            case 14: {
                return pSDEListBase.getCreatePSDEActionName() == null;
            }
            case 15: {
                return pSDEListBase.getCustomCond() == null;
            }
            case 16: {
                return pSDEListBase.getCustomType() == null;
            }
            case 17: {
                return pSDEListBase.getDynaModelFlag() == null;
            }
            case 18: {
                return pSDEListBase.getEmptyText() == null;
            }
            case 19: {
                return pSDEListBase.getEmptyTextPSLanResId() == null;
            }
            case 20: {
                return pSDEListBase.getEmptyTextPSLanResName() == null;
            }
            case 21: {
                return pSDEListBase.getEnableEdit() == null;
            }
            case 22: {
                return pSDEListBase.getEnableItemPriv() == null;
            }
            case 23: {
                return pSDEListBase.getEnablePagingBar() == null;
            }
            case 24: {
                return pSDEListBase.getGetDraftPSDEActionId() == null;
            }
            case 25: {
                return pSDEListBase.getGetDraftPSDEActionName() == null;
            }
            case 26: {
                return pSDEListBase.getGetPSDEActionId() == null;
            }
            case 27: {
                return pSDEListBase.getGetPSDEActionName() == null;
            }
            case 28: {
                return pSDEListBase.getGroupBarCloseMode() == null;
            }
            case 29: {
                return pSDEListBase.getGroupMode() == null;
            }
            case 30: {
                return pSDEListBase.getGroupMovePSDEActionId() == null;
            }
            case 31: {
                return pSDEListBase.getGroupMovePSDEActionName() == null;
            }
            case 32: {
                return pSDEListBase.getGroupPSCodeListId() == null;
            }
            case 33: {
                return pSDEListBase.getGroupPSCodeListName() == null;
            }
            case 34: {
                return pSDEListBase.getGroupPSDEFId() == null;
            }
            case 35: {
                return pSDEListBase.getGroupPSDEFName() == null;
            }
            case 36: {
                return pSDEListBase.getGroupPSDEId() == null;
            }
            case 37: {
                return pSDEListBase.getGroupPSDEName() == null;
            }
            case 38: {
                return pSDEListBase.getGroupPSDEUAGroupId() == null;
            }
            case 39: {
                return pSDEListBase.getGroupPSDEUAGroupName() == null;
            }
            case 40: {
                return pSDEListBase.getGroupPSSysCssId() == null;
            }
            case 41: {
                return pSDEListBase.getGroupPSSysCssName() == null;
            }
            case 42: {
                return pSDEListBase.getGroupPSSysPFPluginId() == null;
            }
            case 43: {
                return pSDEListBase.getGroupPSSysPFPluginName() == null;
            }
            case 44: {
                return pSDEListBase.getGroupStyle() == null;
            }
            case 45: {
                return pSDEListBase.getGroupTextPSDEFId() == null;
            }
            case 46: {
                return pSDEListBase.getGroupTextPSDEFName() == null;
            }
            case 47: {
                return pSDEListBase.getItemPSSysCssId() == null;
            }
            case 48: {
                return pSDEListBase.getItemPSSysCssName() == null;
            }
            case 49: {
                return pSDEListBase.getItemPSSysPFPluginId() == null;
            }
            case 50: {
                return pSDEListBase.getItemPSSysPFPluginName() == null;
            }
            case 51: {
                return pSDEListBase.getListModel() == null;
            }
            case 52: {
                return pSDEListBase.getLockFlag() == null;
            }
            case 53: {
                return pSDEListBase.getLogicName() == null;
            }
            case 54: {
                return pSDEListBase.getLVTag() == null;
            }
            case 55: {
                return pSDEListBase.getLVTag2() == null;
            }
            case 56: {
                return pSDEListBase.getLVTag3() == null;
            }
            case 57: {
                return pSDEListBase.getLVTag4() == null;
            }
            case 58: {
                return pSDEListBase.getMemo() == null;
            }
            case 59: {
                return pSDEListBase.getMinorSortDir() == null;
            }
            case 60: {
                return pSDEListBase.getMinorSortPSDEFId() == null;
            }
            case 61: {
                return pSDEListBase.getMinorSortPSDEFName() == null;
            }
            case 62: {
                return pSDEListBase.getMobListStyle() == null;
            }
            case 63: {
                return pSDEListBase.getMovePSDEActionId() == null;
            }
            case 64: {
                return pSDEListBase.getMovePSDEActionName() == null;
            }
            case 65: {
                return pSDEListBase.getMultiSelect() == null;
            }
            case 66: {
                return pSDEListBase.getNavPSDERId() == null;
            }
            case 67: {
                return pSDEListBase.getNavPSDERName() == null;
            }
            case 68: {
                return pSDEListBase.getNavPSDEViewBaseId() == null;
            }
            case 69: {
                return pSDEListBase.getNavPSDEViewBaseName() == null;
            }
            case 70: {
                return pSDEListBase.getNavViewFilter() == null;
            }
            case 71: {
                return pSDEListBase.getNavViewHeight() == null;
            }
            case 72: {
                return pSDEListBase.getNavViewMaxHeight() == null;
            }
            case 73: {
                return pSDEListBase.getNavViewMaxWidth() == null;
            }
            case 74: {
                return pSDEListBase.getNavViewMinHeight() == null;
            }
            case 75: {
                return pSDEListBase.getNavViewMinWidth() == null;
            }
            case 76: {
                return pSDEListBase.getNavViewParam() == null;
            }
            case 77: {
                return pSDEListBase.getNavViewPos() == null;
            }
            case 78: {
                return pSDEListBase.getNavViewShowMode() == null;
            }
            case 79: {
                return pSDEListBase.getNavViewWidth() == null;
            }
            case 80: {
                return pSDEListBase.getNo2PSDEUAGroupId() == null;
            }
            case 81: {
                return pSDEListBase.getNo2PSDEUAGroupName() == null;
            }
            case 82: {
                return pSDEListBase.getNoSort() == null;
            }
            case 83: {
                return pSDEListBase.getOrderValuePSDEFId() == null;
            }
            case 84: {
                return pSDEListBase.getOrderValuePSDEFName() == null;
            }
            case 85: {
                return pSDEListBase.getPageSize() == null;
            }
            case 86: {
                return pSDEListBase.getPSACHandlerId() == null;
            }
            case 87: {
                return pSDEListBase.getPSACHandlerName() == null;
            }
            case 88: {
                return pSDEListBase.getPSCtrlLogicGroupId() == null;
            }
            case 89: {
                return pSDEListBase.getPSCtrlLogicGroupName() == null;
            }
            case 90: {
                return pSDEListBase.getPSCtrlMsgId() == null;
            }
            case 91: {
                return pSDEListBase.getPSCtrlMsgName() == null;
            }
            case 92: {
                return pSDEListBase.getPSDEDSId() == null;
            }
            case 93: {
                return pSDEListBase.getPSDEDSName() == null;
            }
            case 94: {
                return pSDEListBase.getPSDEId() == null;
            }
            case 95: {
                return pSDEListBase.getPSDEListId() == null;
            }
            case 96: {
                return pSDEListBase.getPSDEListName() == null;
            }
            case 97: {
                return pSDEListBase.getPSDEName() == null;
            }
            case 98: {
                return pSDEListBase.getPSDEUAGroupId() == null;
            }
            case 99: {
                return pSDEListBase.getPSDEUAGroupName() == null;
            }
            case 100: {
                return pSDEListBase.getPSDynaInstId() == null;
            }
            case 101: {
                return pSDEListBase.getPSSysCssId() == null;
            }
            case 102: {
                return pSDEListBase.getPSSysCssName() == null;
            }
            case 103: {
                return pSDEListBase.getPSSysPFPluginId() == null;
            }
            case 104: {
                return pSDEListBase.getPSSysPFPluginName() == null;
            }
            case 105: {
                return pSDEListBase.getPSSysReqItemId() == null;
            }
            case 106: {
                return pSDEListBase.getPSSysReqItemName() == null;
            }
            case 107: {
                return pSDEListBase.getPSSysViewPanelId() == null;
            }
            case 108: {
                return pSDEListBase.getPSSysViewPanelName() == null;
            }
            case 109: {
                return pSDEListBase.getPSViewMsgGroupId() == null;
            }
            case 110: {
                return pSDEListBase.getPSViewMsgGroupName() == null;
            }
            case 111: {
                return pSDEListBase.getQuickPSDEToolbarId() == null;
            }
            case 112: {
                return pSDEListBase.getQuickPSDEToolbarName() == null;
            }
            case 113: {
                return pSDEListBase.getRemovePSDEActionId() == null;
            }
            case 114: {
                return pSDEListBase.getRemovePSDEActionName() == null;
            }
            case 115: {
                return pSDEListBase.getShowHeader() == null;
            }
            case 116: {
                return pSDEListBase.getSRFSysPub() == null;
            }
            case 117: {
                return pSDEListBase.getSwimlanePSCodeListId() == null;
            }
            case 118: {
                return pSDEListBase.getSwimlanePSCodeListName() == null;
            }
            case 119: {
                return pSDEListBase.getSwimlanePSDEFId() == null;
            }
            case 120: {
                return pSDEListBase.getSwimlanePSDEFName() == null;
            }
            case 121: {
                return pSDEListBase.getToDoTask() == null;
            }
            case 122: {
                return pSDEListBase.getUpdateDate() == null;
            }
            case 123: {
                return pSDEListBase.getUpdateMan() == null;
            }
            case 124: {
                return pSDEListBase.getUpdatePSDEActionId() == null;
            }
            case 125: {
                return pSDEListBase.getUpdatePSDEActionName() == null;
            }
            case 126: {
                return pSDEListBase.getUser2PSDEActionId() == null;
            }
            case 127: {
                return pSDEListBase.getUser2PSDEActionName() == null;
            }
            case 128: {
                return pSDEListBase.getUserPSDEActionId() == null;
            }
            case 129: {
                return pSDEListBase.getUserPSDEActionName() == null;
            }
            case 130: {
                return pSDEListBase.getUserTag() == null;
            }
            case 131: {
                return pSDEListBase.getUserTag2() == null;
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
        return PSDEListBase.contains(this, n);
    }

    private static boolean contains(PSDEListBase pSDEListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSDEListBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSDEListBase.isAppendDEItemsDirty();
            }
            case 3: {
                return pSDEListBase.isAsyncPSDEDSIdDirty();
            }
            case 4: {
                return pSDEListBase.isAsyncPSDEDSNameDirty();
            }
            case 5: {
                return pSDEListBase.isBatPSDEToolbarIdDirty();
            }
            case 6: {
                return pSDEListBase.isBatPSDEToolbarNameDirty();
            }
            case 7: {
                return pSDEListBase.isBusyIndicatorDirty();
            }
            case 8: {
                return pSDEListBase.isCodeNameDirty();
            }
            case 9: {
                return pSDEListBase.isCopyPSDEActionIdDirty();
            }
            case 10: {
                return pSDEListBase.isCopyPSDEActionNameDirty();
            }
            case 11: {
                return pSDEListBase.isCreateDateDirty();
            }
            case 12: {
                return pSDEListBase.isCreateManDirty();
            }
            case 13: {
                return pSDEListBase.isCreatePSDEActionIdDirty();
            }
            case 14: {
                return pSDEListBase.isCreatePSDEActionNameDirty();
            }
            case 15: {
                return pSDEListBase.isCustomCondDirty();
            }
            case 16: {
                return pSDEListBase.isCustomTypeDirty();
            }
            case 17: {
                return pSDEListBase.isDynaModelFlagDirty();
            }
            case 18: {
                return pSDEListBase.isEmptyTextDirty();
            }
            case 19: {
                return pSDEListBase.isEmptyTextPSLanResIdDirty();
            }
            case 20: {
                return pSDEListBase.isEmptyTextPSLanResNameDirty();
            }
            case 21: {
                return pSDEListBase.isEnableEditDirty();
            }
            case 22: {
                return pSDEListBase.isEnableItemPrivDirty();
            }
            case 23: {
                return pSDEListBase.isEnablePagingBarDirty();
            }
            case 24: {
                return pSDEListBase.isGetDraftPSDEActionIdDirty();
            }
            case 25: {
                return pSDEListBase.isGetDraftPSDEActionNameDirty();
            }
            case 26: {
                return pSDEListBase.isGetPSDEActionIdDirty();
            }
            case 27: {
                return pSDEListBase.isGetPSDEActionNameDirty();
            }
            case 28: {
                return pSDEListBase.isGroupBarCloseModeDirty();
            }
            case 29: {
                return pSDEListBase.isGroupModeDirty();
            }
            case 30: {
                return pSDEListBase.isGroupMovePSDEActionIdDirty();
            }
            case 31: {
                return pSDEListBase.isGroupMovePSDEActionNameDirty();
            }
            case 32: {
                return pSDEListBase.isGroupPSCodeListIdDirty();
            }
            case 33: {
                return pSDEListBase.isGroupPSCodeListNameDirty();
            }
            case 34: {
                return pSDEListBase.isGroupPSDEFIdDirty();
            }
            case 35: {
                return pSDEListBase.isGroupPSDEFNameDirty();
            }
            case 36: {
                return pSDEListBase.isGroupPSDEIdDirty();
            }
            case 37: {
                return pSDEListBase.isGroupPSDENameDirty();
            }
            case 38: {
                return pSDEListBase.isGroupPSDEUAGroupIdDirty();
            }
            case 39: {
                return pSDEListBase.isGroupPSDEUAGroupNameDirty();
            }
            case 40: {
                return pSDEListBase.isGroupPSSysCssIdDirty();
            }
            case 41: {
                return pSDEListBase.isGroupPSSysCssNameDirty();
            }
            case 42: {
                return pSDEListBase.isGroupPSSysPFPluginIdDirty();
            }
            case 43: {
                return pSDEListBase.isGroupPSSysPFPluginNameDirty();
            }
            case 44: {
                return pSDEListBase.isGroupStyleDirty();
            }
            case 45: {
                return pSDEListBase.isGroupTextPSDEFIdDirty();
            }
            case 46: {
                return pSDEListBase.isGroupTextPSDEFNameDirty();
            }
            case 47: {
                return pSDEListBase.isItemPSSysCssIdDirty();
            }
            case 48: {
                return pSDEListBase.isItemPSSysCssNameDirty();
            }
            case 49: {
                return pSDEListBase.isItemPSSysPFPluginIdDirty();
            }
            case 50: {
                return pSDEListBase.isItemPSSysPFPluginNameDirty();
            }
            case 51: {
                return pSDEListBase.isListModelDirty();
            }
            case 52: {
                return pSDEListBase.isLockFlagDirty();
            }
            case 53: {
                return pSDEListBase.isLogicNameDirty();
            }
            case 54: {
                return pSDEListBase.isLVTagDirty();
            }
            case 55: {
                return pSDEListBase.isLVTag2Dirty();
            }
            case 56: {
                return pSDEListBase.isLVTag3Dirty();
            }
            case 57: {
                return pSDEListBase.isLVTag4Dirty();
            }
            case 58: {
                return pSDEListBase.isMemoDirty();
            }
            case 59: {
                return pSDEListBase.isMinorSortDirDirty();
            }
            case 60: {
                return pSDEListBase.isMinorSortPSDEFIdDirty();
            }
            case 61: {
                return pSDEListBase.isMinorSortPSDEFNameDirty();
            }
            case 62: {
                return pSDEListBase.isMobListStyleDirty();
            }
            case 63: {
                return pSDEListBase.isMovePSDEActionIdDirty();
            }
            case 64: {
                return pSDEListBase.isMovePSDEActionNameDirty();
            }
            case 65: {
                return pSDEListBase.isMultiSelectDirty();
            }
            case 66: {
                return pSDEListBase.isNavPSDERIdDirty();
            }
            case 67: {
                return pSDEListBase.isNavPSDERNameDirty();
            }
            case 68: {
                return pSDEListBase.isNavPSDEViewBaseIdDirty();
            }
            case 69: {
                return pSDEListBase.isNavPSDEViewBaseNameDirty();
            }
            case 70: {
                return pSDEListBase.isNavViewFilterDirty();
            }
            case 71: {
                return pSDEListBase.isNavViewHeightDirty();
            }
            case 72: {
                return pSDEListBase.isNavViewMaxHeightDirty();
            }
            case 73: {
                return pSDEListBase.isNavViewMaxWidthDirty();
            }
            case 74: {
                return pSDEListBase.isNavViewMinHeightDirty();
            }
            case 75: {
                return pSDEListBase.isNavViewMinWidthDirty();
            }
            case 76: {
                return pSDEListBase.isNavViewParamDirty();
            }
            case 77: {
                return pSDEListBase.isNavViewPosDirty();
            }
            case 78: {
                return pSDEListBase.isNavViewShowModeDirty();
            }
            case 79: {
                return pSDEListBase.isNavViewWidthDirty();
            }
            case 80: {
                return pSDEListBase.isNo2PSDEUAGroupIdDirty();
            }
            case 81: {
                return pSDEListBase.isNo2PSDEUAGroupNameDirty();
            }
            case 82: {
                return pSDEListBase.isNoSortDirty();
            }
            case 83: {
                return pSDEListBase.isOrderValuePSDEFIdDirty();
            }
            case 84: {
                return pSDEListBase.isOrderValuePSDEFNameDirty();
            }
            case 85: {
                return pSDEListBase.isPageSizeDirty();
            }
            case 86: {
                return pSDEListBase.isPSACHandlerIdDirty();
            }
            case 87: {
                return pSDEListBase.isPSACHandlerNameDirty();
            }
            case 88: {
                return pSDEListBase.isPSCtrlLogicGroupIdDirty();
            }
            case 89: {
                return pSDEListBase.isPSCtrlLogicGroupNameDirty();
            }
            case 90: {
                return pSDEListBase.isPSCtrlMsgIdDirty();
            }
            case 91: {
                return pSDEListBase.isPSCtrlMsgNameDirty();
            }
            case 92: {
                return pSDEListBase.isPSDEDSIdDirty();
            }
            case 93: {
                return pSDEListBase.isPSDEDSNameDirty();
            }
            case 94: {
                return pSDEListBase.isPSDEIdDirty();
            }
            case 95: {
                return pSDEListBase.isPSDEListIdDirty();
            }
            case 96: {
                return pSDEListBase.isPSDEListNameDirty();
            }
            case 97: {
                return pSDEListBase.isPSDENameDirty();
            }
            case 98: {
                return pSDEListBase.isPSDEUAGroupIdDirty();
            }
            case 99: {
                return pSDEListBase.isPSDEUAGroupNameDirty();
            }
            case 100: {
                return pSDEListBase.isPSDynaInstIdDirty();
            }
            case 101: {
                return pSDEListBase.isPSSysCssIdDirty();
            }
            case 102: {
                return pSDEListBase.isPSSysCssNameDirty();
            }
            case 103: {
                return pSDEListBase.isPSSysPFPluginIdDirty();
            }
            case 104: {
                return pSDEListBase.isPSSysPFPluginNameDirty();
            }
            case 105: {
                return pSDEListBase.isPSSysReqItemIdDirty();
            }
            case 106: {
                return pSDEListBase.isPSSysReqItemNameDirty();
            }
            case 107: {
                return pSDEListBase.isPSSysViewPanelIdDirty();
            }
            case 108: {
                return pSDEListBase.isPSSysViewPanelNameDirty();
            }
            case 109: {
                return pSDEListBase.isPSViewMsgGroupIdDirty();
            }
            case 110: {
                return pSDEListBase.isPSViewMsgGroupNameDirty();
            }
            case 111: {
                return pSDEListBase.isQuickPSDEToolbarIdDirty();
            }
            case 112: {
                return pSDEListBase.isQuickPSDEToolbarNameDirty();
            }
            case 113: {
                return pSDEListBase.isRemovePSDEActionIdDirty();
            }
            case 114: {
                return pSDEListBase.isRemovePSDEActionNameDirty();
            }
            case 115: {
                return pSDEListBase.isShowHeaderDirty();
            }
            case 116: {
                return pSDEListBase.isSRFSysPubDirty();
            }
            case 117: {
                return pSDEListBase.isSwimlanePSCodeListIdDirty();
            }
            case 118: {
                return pSDEListBase.isSwimlanePSCodeListNameDirty();
            }
            case 119: {
                return pSDEListBase.isSwimlanePSDEFIdDirty();
            }
            case 120: {
                return pSDEListBase.isSwimlanePSDEFNameDirty();
            }
            case 121: {
                return pSDEListBase.isToDoTaskDirty();
            }
            case 122: {
                return pSDEListBase.isUpdateDateDirty();
            }
            case 123: {
                return pSDEListBase.isUpdateManDirty();
            }
            case 124: {
                return pSDEListBase.isUpdatePSDEActionIdDirty();
            }
            case 125: {
                return pSDEListBase.isUpdatePSDEActionNameDirty();
            }
            case 126: {
                return pSDEListBase.isUser2PSDEActionIdDirty();
            }
            case 127: {
                return pSDEListBase.isUser2PSDEActionNameDirty();
            }
            case 128: {
                return pSDEListBase.isUserPSDEActionIdDirty();
            }
            case 129: {
                return pSDEListBase.isUserPSDEActionNameDirty();
            }
            case 130: {
                return pSDEListBase.isUserTagDirty();
            }
            case 131: {
                return pSDEListBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEListBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEListBase pSDEListBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEListBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEListBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEListBase.getAppendDEItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appenddeitems", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getAppendDEItems()), (boolean)false);
        }
        if (bl || pSDEListBase.getAsyncPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getAsyncPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEListBase.getAsyncPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getAsyncPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEListBase.getBatPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getBatPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEListBase.getBatPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getBatPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEListBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEListBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEListBase.getCopyPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCopyPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getCopyPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCopyPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEListBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEListBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEListBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEListBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEListBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDEListBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEListBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEListBase.getEnableEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableedit", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEnableEdit()), (boolean)false);
        }
        if (bl || pSDEListBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEListBase.getEnablePagingBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepagingbar", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getEnablePagingBar()), (boolean)false);
        }
        if (bl || pSDEListBase.getGetDraftPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGetDraftPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGetDraftPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGetDraftPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupbarclosemode", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupBarCloseMode()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdename", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupstyle", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupStyle()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupTextPSDEFId()), (boolean)false);
        }
        if (bl || pSDEListBase.getGroupTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getGroupTextPSDEFName()), (boolean)false);
        }
        if (bl || pSDEListBase.getItemPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getItemPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEListBase.getItemPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getItemPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEListBase.getItemPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyspfpluginid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getItemPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEListBase.getItemPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyspfpluginname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getItemPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEListBase.getListModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"listmodel", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getListModel()), (boolean)false);
        }
        if (bl || pSDEListBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEListBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEListBase.getLVTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lvtag", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLVTag()), (boolean)false);
        }
        if (bl || pSDEListBase.getLVTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lvtag2", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLVTag2()), (boolean)false);
        }
        if (bl || pSDEListBase.getLVTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lvtag3", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLVTag3()), (boolean)false);
        }
        if (bl || pSDEListBase.getLVTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lvtag4", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getLVTag4()), (boolean)false);
        }
        if (bl || pSDEListBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEListBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEListBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEListBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEListBase.getMobListStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobliststyle", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMobListStyle()), (boolean)false);
        }
        if (bl || pSDEListBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getMultiSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiselect", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getMultiSelect()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsderid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavPSDERId()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdername", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavPSDERName()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbaseid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbasename", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSDEListBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSDEListBase.getNo2PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNo2PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEListBase.getNo2PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNo2PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEListBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEListBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEListBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPageSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagesize", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPageSize()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEListBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEListBase.getQuickPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getQuickPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEListBase.getQuickPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getQuickPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEListBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getShowHeader() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showheader", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getShowHeader()), (boolean)false);
        }
        if (bl || pSDEListBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEListBase.getSwimlanePSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepscodelistid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getSwimlanePSCodeListId()), (boolean)false);
        }
        if (bl || pSDEListBase.getSwimlanePSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepscodelistname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getSwimlanePSCodeListName()), (boolean)false);
        }
        if (bl || pSDEListBase.getSwimlanePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepsdefid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getSwimlanePSDEFId()), (boolean)false);
        }
        if (bl || pSDEListBase.getSwimlanePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepsdefname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getSwimlanePSDEFName()), (boolean)false);
        }
        if (bl || pSDEListBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEListBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEListBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEListBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getUser2PSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUser2PSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getUser2PSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUser2PSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getUserPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionid", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUserPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEListBase.getUserPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionname", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUserPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEListBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEListBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEListBase.getJSONValue((Object)pSDEListBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEListBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEListBase pSDEListBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEListBase.getADPSDELogicId() != null) {
            object = pSDEListBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEListBase.getADPSDELogicName() != null) {
            object = pSDEListBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getAppendDEItems() != null) {
            object = pSDEListBase.getAppendDEItems();
            xmlNode.setAttribute(FIELD_APPENDDEITEMS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getAsyncPSDEDSId() != null) {
            object = pSDEListBase.getAsyncPSDEDSId();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getAsyncPSDEDSName() != null) {
            object = pSDEListBase.getAsyncPSDEDSName();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getBatPSDEToolbarId() != null) {
            object = pSDEListBase.getBatPSDEToolbarId();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getBatPSDEToolbarName() != null) {
            object = pSDEListBase.getBatPSDEToolbarName();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getBusyIndicator() != null) {
            object = pSDEListBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getCodeName() != null) {
            object = pSDEListBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCopyPSDEActionId() != null) {
            object = pSDEListBase.getCopyPSDEActionId();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCopyPSDEActionName() != null) {
            object = pSDEListBase.getCopyPSDEActionName();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCreateDate() != null) {
            object = pSDEListBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListBase.getCreateMan() != null) {
            object = pSDEListBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCreatePSDEActionId() != null) {
            object = pSDEListBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCreatePSDEActionName() != null) {
            object = pSDEListBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCustomCond() != null) {
            object = pSDEListBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getCustomType() != null) {
            object = pSDEListBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getDynaModelFlag() != null) {
            object = pSDEListBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getEmptyText() != null) {
            object = pSDEListBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getEmptyTextPSLanResId() != null) {
            object = pSDEListBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getEmptyTextPSLanResName() != null) {
            object = pSDEListBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getEnableEdit() != null) {
            object = pSDEListBase.getEnableEdit();
            xmlNode.setAttribute(FIELD_ENABLEEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getEnableItemPriv() != null) {
            object = pSDEListBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getEnablePagingBar() != null) {
            object = pSDEListBase.getEnablePagingBar();
            xmlNode.setAttribute(FIELD_ENABLEPAGINGBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getGetDraftPSDEActionId() != null) {
            object = pSDEListBase.getGetDraftPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGetDraftPSDEActionName() != null) {
            object = pSDEListBase.getGetDraftPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGetPSDEActionId() != null) {
            object = pSDEListBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGetPSDEActionName() != null) {
            object = pSDEListBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupBarCloseMode() != null) {
            object = pSDEListBase.getGroupBarCloseMode();
            xmlNode.setAttribute(FIELD_GROUPBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getGroupMode() != null) {
            object = pSDEListBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupMovePSDEActionId() != null) {
            object = pSDEListBase.getGroupMovePSDEActionId();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupMovePSDEActionName() != null) {
            object = pSDEListBase.getGroupMovePSDEActionName();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSCodeListId() != null) {
            object = pSDEListBase.getGroupPSCodeListId();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSCodeListName() != null) {
            object = pSDEListBase.getGroupPSCodeListName();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEFId() != null) {
            object = pSDEListBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEFName() != null) {
            object = pSDEListBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEId() != null) {
            object = pSDEListBase.getGroupPSDEId();
            xmlNode.setAttribute(FIELD_GROUPPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEName() != null) {
            object = pSDEListBase.getGroupPSDEName();
            xmlNode.setAttribute(FIELD_GROUPPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEUAGroupId() != null) {
            object = pSDEListBase.getGroupPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSDEUAGroupName() != null) {
            object = pSDEListBase.getGroupPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSSysCssId() != null) {
            object = pSDEListBase.getGroupPSSysCssId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSSysCssName() != null) {
            object = pSDEListBase.getGroupPSSysCssName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSSysPFPluginId() != null) {
            object = pSDEListBase.getGroupPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupPSSysPFPluginName() != null) {
            object = pSDEListBase.getGroupPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupStyle() != null) {
            object = pSDEListBase.getGroupStyle();
            xmlNode.setAttribute(FIELD_GROUPSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupTextPSDEFId() != null) {
            object = pSDEListBase.getGroupTextPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getGroupTextPSDEFName() != null) {
            object = pSDEListBase.getGroupTextPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getItemPSSysCssId() != null) {
            object = pSDEListBase.getItemPSSysCssId();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getItemPSSysCssName() != null) {
            object = pSDEListBase.getItemPSSysCssName();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getItemPSSysPFPluginId() != null) {
            object = pSDEListBase.getItemPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_ITEMPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getItemPSSysPFPluginName() != null) {
            object = pSDEListBase.getItemPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_ITEMPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getListModel() != null) {
            object = pSDEListBase.getListModel();
            xmlNode.setAttribute(FIELD_LISTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getLockFlag() != null) {
            object = pSDEListBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getLogicName() != null) {
            object = pSDEListBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getLVTag() != null) {
            object = pSDEListBase.getLVTag();
            xmlNode.setAttribute(FIELD_LVTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getLVTag2() != null) {
            object = pSDEListBase.getLVTag2();
            xmlNode.setAttribute(FIELD_LVTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getLVTag3() != null) {
            object = pSDEListBase.getLVTag3();
            xmlNode.setAttribute(FIELD_LVTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getLVTag4() != null) {
            object = pSDEListBase.getLVTag4();
            xmlNode.setAttribute(FIELD_LVTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMemo() != null) {
            object = pSDEListBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMinorSortDir() != null) {
            object = pSDEListBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMinorSortPSDEFId() != null) {
            object = pSDEListBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMinorSortPSDEFName() != null) {
            object = pSDEListBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMobListStyle() != null) {
            object = pSDEListBase.getMobListStyle();
            xmlNode.setAttribute(FIELD_MOBLISTSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMovePSDEActionId() != null) {
            object = pSDEListBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMovePSDEActionName() != null) {
            object = pSDEListBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getMultiSelect() != null) {
            object = pSDEListBase.getMultiSelect();
            xmlNode.setAttribute(FIELD_MULTISELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavPSDERId() != null) {
            object = pSDEListBase.getNavPSDERId();
            xmlNode.setAttribute(FIELD_NAVPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavPSDERName() != null) {
            object = pSDEListBase.getNavPSDERName();
            xmlNode.setAttribute(FIELD_NAVPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavPSDEViewBaseId() != null) {
            object = pSDEListBase.getNavPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavPSDEViewBaseName() != null) {
            object = pSDEListBase.getNavPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavViewFilter() != null) {
            object = pSDEListBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavViewHeight() != null) {
            object = pSDEListBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewMaxHeight() != null) {
            object = pSDEListBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewMaxWidth() != null) {
            object = pSDEListBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewMinHeight() != null) {
            object = pSDEListBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewMinWidth() != null) {
            object = pSDEListBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewParam() != null) {
            object = pSDEListBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavViewPos() != null) {
            object = pSDEListBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNavViewShowMode() != null) {
            object = pSDEListBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNavViewWidth() != null) {
            object = pSDEListBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getNo2PSDEUAGroupId() != null) {
            object = pSDEListBase.getNo2PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNo2PSDEUAGroupName() != null) {
            object = pSDEListBase.getNo2PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getNoSort() != null) {
            object = pSDEListBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getOrderValuePSDEFId() != null) {
            object = pSDEListBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getOrderValuePSDEFName() != null) {
            object = pSDEListBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPageSize() != null) {
            object = pSDEListBase.getPageSize();
            xmlNode.setAttribute(FIELD_PAGESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getPSACHandlerId() != null) {
            object = pSDEListBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSACHandlerName() != null) {
            object = pSDEListBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEListBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEListBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSCtrlMsgId() != null) {
            object = pSDEListBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSCtrlMsgName() != null) {
            object = pSDEListBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEDSId() != null) {
            object = pSDEListBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEDSName() != null) {
            object = pSDEListBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEId() != null) {
            object = pSDEListBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEListId() != null) {
            object = pSDEListBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEListName() != null) {
            object = pSDEListBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEName() != null) {
            object = pSDEListBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEUAGroupId() != null) {
            object = pSDEListBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDEUAGroupName() != null) {
            object = pSDEListBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSDynaInstId() != null) {
            object = pSDEListBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysCssId() != null) {
            object = pSDEListBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysCssName() != null) {
            object = pSDEListBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysPFPluginId() != null) {
            object = pSDEListBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysPFPluginName() != null) {
            object = pSDEListBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysReqItemId() != null) {
            object = pSDEListBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysReqItemName() != null) {
            object = pSDEListBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysViewPanelId() != null) {
            object = pSDEListBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSSysViewPanelName() != null) {
            object = pSDEListBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSViewMsgGroupId() != null) {
            object = pSDEListBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getPSViewMsgGroupName() != null) {
            object = pSDEListBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getQuickPSDEToolbarId() != null) {
            object = pSDEListBase.getQuickPSDEToolbarId();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getQuickPSDEToolbarName() != null) {
            object = pSDEListBase.getQuickPSDEToolbarName();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getRemovePSDEActionId() != null) {
            object = pSDEListBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getRemovePSDEActionName() != null) {
            object = pSDEListBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getShowHeader() != null) {
            object = pSDEListBase.getShowHeader();
            xmlNode.setAttribute(FIELD_SHOWHEADER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getSRFSysPub() != null) {
            object = pSDEListBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListBase.getSwimlanePSCodeListId() != null) {
            object = pSDEListBase.getSwimlanePSCodeListId();
            xmlNode.setAttribute(FIELD_SWIMLANEPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getSwimlanePSCodeListName() != null) {
            object = pSDEListBase.getSwimlanePSCodeListName();
            xmlNode.setAttribute(FIELD_SWIMLANEPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getSwimlanePSDEFId() != null) {
            object = pSDEListBase.getSwimlanePSDEFId();
            xmlNode.setAttribute(FIELD_SWIMLANEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getSwimlanePSDEFName() != null) {
            object = pSDEListBase.getSwimlanePSDEFName();
            xmlNode.setAttribute(FIELD_SWIMLANEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getToDoTask() != null) {
            object = pSDEListBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUpdateDate() != null) {
            object = pSDEListBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListBase.getUpdateMan() != null) {
            object = pSDEListBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUpdatePSDEActionId() != null) {
            object = pSDEListBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUpdatePSDEActionName() != null) {
            object = pSDEListBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUser2PSDEActionId() != null) {
            object = pSDEListBase.getUser2PSDEActionId();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUser2PSDEActionName() != null) {
            object = pSDEListBase.getUser2PSDEActionName();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUserPSDEActionId() != null) {
            object = pSDEListBase.getUserPSDEActionId();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUserPSDEActionName() != null) {
            object = pSDEListBase.getUserPSDEActionName();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUserTag() != null) {
            object = pSDEListBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEListBase.getUserTag2() != null) {
            object = pSDEListBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEListBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEListBase pSDEListBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEListBase.isADPSDELogicIdDirty() && (bl || pSDEListBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEListBase.getADPSDELogicId());
        }
        if (pSDEListBase.isADPSDELogicNameDirty() && (bl || pSDEListBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEListBase.getADPSDELogicName());
        }
        if (pSDEListBase.isAppendDEItemsDirty() && (bl || pSDEListBase.getAppendDEItems() != null)) {
            iDataObject.set(FIELD_APPENDDEITEMS, (Object)pSDEListBase.getAppendDEItems());
        }
        if (pSDEListBase.isAsyncPSDEDSIdDirty() && (bl || pSDEListBase.getAsyncPSDEDSId() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSID, (Object)pSDEListBase.getAsyncPSDEDSId());
        }
        if (pSDEListBase.isAsyncPSDEDSNameDirty() && (bl || pSDEListBase.getAsyncPSDEDSName() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSNAME, (Object)pSDEListBase.getAsyncPSDEDSName());
        }
        if (pSDEListBase.isBatPSDEToolbarIdDirty() && (bl || pSDEListBase.getBatPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARID, (Object)pSDEListBase.getBatPSDEToolbarId());
        }
        if (pSDEListBase.isBatPSDEToolbarNameDirty() && (bl || pSDEListBase.getBatPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARNAME, (Object)pSDEListBase.getBatPSDEToolbarName());
        }
        if (pSDEListBase.isBusyIndicatorDirty() && (bl || pSDEListBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEListBase.getBusyIndicator());
        }
        if (pSDEListBase.isCodeNameDirty() && (bl || pSDEListBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEListBase.getCodeName());
        }
        if (pSDEListBase.isCopyPSDEActionIdDirty() && (bl || pSDEListBase.getCopyPSDEActionId() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONID, (Object)pSDEListBase.getCopyPSDEActionId());
        }
        if (pSDEListBase.isCopyPSDEActionNameDirty() && (bl || pSDEListBase.getCopyPSDEActionName() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONNAME, (Object)pSDEListBase.getCopyPSDEActionName());
        }
        if (pSDEListBase.isCreateDateDirty() && (bl || pSDEListBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEListBase.getCreateDate());
        }
        if (pSDEListBase.isCreateManDirty() && (bl || pSDEListBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEListBase.getCreateMan());
        }
        if (pSDEListBase.isCreatePSDEActionIdDirty() && (bl || pSDEListBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSDEListBase.getCreatePSDEActionId());
        }
        if (pSDEListBase.isCreatePSDEActionNameDirty() && (bl || pSDEListBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSDEListBase.getCreatePSDEActionName());
        }
        if (pSDEListBase.isCustomCondDirty() && (bl || pSDEListBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEListBase.getCustomCond());
        }
        if (pSDEListBase.isCustomTypeDirty() && (bl || pSDEListBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEListBase.getCustomType());
        }
        if (pSDEListBase.isDynaModelFlagDirty() && (bl || pSDEListBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEListBase.getDynaModelFlag());
        }
        if (pSDEListBase.isEmptyTextDirty() && (bl || pSDEListBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDEListBase.getEmptyText());
        }
        if (pSDEListBase.isEmptyTextPSLanResIdDirty() && (bl || pSDEListBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDEListBase.getEmptyTextPSLanResId());
        }
        if (pSDEListBase.isEmptyTextPSLanResNameDirty() && (bl || pSDEListBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDEListBase.getEmptyTextPSLanResName());
        }
        if (pSDEListBase.isEnableEditDirty() && (bl || pSDEListBase.getEnableEdit() != null)) {
            iDataObject.set(FIELD_ENABLEEDIT, (Object)pSDEListBase.getEnableEdit());
        }
        if (pSDEListBase.isEnableItemPrivDirty() && (bl || pSDEListBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEListBase.getEnableItemPriv());
        }
        if (pSDEListBase.isEnablePagingBarDirty() && (bl || pSDEListBase.getEnablePagingBar() != null)) {
            iDataObject.set(FIELD_ENABLEPAGINGBAR, (Object)pSDEListBase.getEnablePagingBar());
        }
        if (pSDEListBase.isGetDraftPSDEActionIdDirty() && (bl || pSDEListBase.getGetDraftPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONID, (Object)pSDEListBase.getGetDraftPSDEActionId());
        }
        if (pSDEListBase.isGetDraftPSDEActionNameDirty() && (bl || pSDEListBase.getGetDraftPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONNAME, (Object)pSDEListBase.getGetDraftPSDEActionName());
        }
        if (pSDEListBase.isGetPSDEActionIdDirty() && (bl || pSDEListBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSDEListBase.getGetPSDEActionId());
        }
        if (pSDEListBase.isGetPSDEActionNameDirty() && (bl || pSDEListBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSDEListBase.getGetPSDEActionName());
        }
        if (pSDEListBase.isGroupBarCloseModeDirty() && (bl || pSDEListBase.getGroupBarCloseMode() != null)) {
            iDataObject.set(FIELD_GROUPBARCLOSEMODE, (Object)pSDEListBase.getGroupBarCloseMode());
        }
        if (pSDEListBase.isGroupModeDirty() && (bl || pSDEListBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSDEListBase.getGroupMode());
        }
        if (pSDEListBase.isGroupMovePSDEActionIdDirty() && (bl || pSDEListBase.getGroupMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONID, (Object)pSDEListBase.getGroupMovePSDEActionId());
        }
        if (pSDEListBase.isGroupMovePSDEActionNameDirty() && (bl || pSDEListBase.getGroupMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONNAME, (Object)pSDEListBase.getGroupMovePSDEActionName());
        }
        if (pSDEListBase.isGroupPSCodeListIdDirty() && (bl || pSDEListBase.getGroupPSCodeListId() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTID, (Object)pSDEListBase.getGroupPSCodeListId());
        }
        if (pSDEListBase.isGroupPSCodeListNameDirty() && (bl || pSDEListBase.getGroupPSCodeListName() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTNAME, (Object)pSDEListBase.getGroupPSCodeListName());
        }
        if (pSDEListBase.isGroupPSDEFIdDirty() && (bl || pSDEListBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSDEListBase.getGroupPSDEFId());
        }
        if (pSDEListBase.isGroupPSDEFNameDirty() && (bl || pSDEListBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSDEListBase.getGroupPSDEFName());
        }
        if (pSDEListBase.isGroupPSDEIdDirty() && (bl || pSDEListBase.getGroupPSDEId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEID, (Object)pSDEListBase.getGroupPSDEId());
        }
        if (pSDEListBase.isGroupPSDENameDirty() && (bl || pSDEListBase.getGroupPSDEName() != null)) {
            iDataObject.set(FIELD_GROUPPSDENAME, (Object)pSDEListBase.getGroupPSDEName());
        }
        if (pSDEListBase.isGroupPSDEUAGroupIdDirty() && (bl || pSDEListBase.getGroupPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPID, (Object)pSDEListBase.getGroupPSDEUAGroupId());
        }
        if (pSDEListBase.isGroupPSDEUAGroupNameDirty() && (bl || pSDEListBase.getGroupPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPNAME, (Object)pSDEListBase.getGroupPSDEUAGroupName());
        }
        if (pSDEListBase.isGroupPSSysCssIdDirty() && (bl || pSDEListBase.getGroupPSSysCssId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSID, (Object)pSDEListBase.getGroupPSSysCssId());
        }
        if (pSDEListBase.isGroupPSSysCssNameDirty() && (bl || pSDEListBase.getGroupPSSysCssName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSNAME, (Object)pSDEListBase.getGroupPSSysCssName());
        }
        if (pSDEListBase.isGroupPSSysPFPluginIdDirty() && (bl || pSDEListBase.getGroupPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINID, (Object)pSDEListBase.getGroupPSSysPFPluginId());
        }
        if (pSDEListBase.isGroupPSSysPFPluginNameDirty() && (bl || pSDEListBase.getGroupPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINNAME, (Object)pSDEListBase.getGroupPSSysPFPluginName());
        }
        if (pSDEListBase.isGroupStyleDirty() && (bl || pSDEListBase.getGroupStyle() != null)) {
            iDataObject.set(FIELD_GROUPSTYLE, (Object)pSDEListBase.getGroupStyle());
        }
        if (pSDEListBase.isGroupTextPSDEFIdDirty() && (bl || pSDEListBase.getGroupTextPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFID, (Object)pSDEListBase.getGroupTextPSDEFId());
        }
        if (pSDEListBase.isGroupTextPSDEFNameDirty() && (bl || pSDEListBase.getGroupTextPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFNAME, (Object)pSDEListBase.getGroupTextPSDEFName());
        }
        if (pSDEListBase.isItemPSSysCssIdDirty() && (bl || pSDEListBase.getItemPSSysCssId() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSID, (Object)pSDEListBase.getItemPSSysCssId());
        }
        if (pSDEListBase.isItemPSSysCssNameDirty() && (bl || pSDEListBase.getItemPSSysCssName() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSNAME, (Object)pSDEListBase.getItemPSSysCssName());
        }
        if (pSDEListBase.isItemPSSysPFPluginIdDirty() && (bl || pSDEListBase.getItemPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSPFPLUGINID, (Object)pSDEListBase.getItemPSSysPFPluginId());
        }
        if (pSDEListBase.isItemPSSysPFPluginNameDirty() && (bl || pSDEListBase.getItemPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSPFPLUGINNAME, (Object)pSDEListBase.getItemPSSysPFPluginName());
        }
        if (pSDEListBase.isListModelDirty() && (bl || pSDEListBase.getListModel() != null)) {
            iDataObject.set(FIELD_LISTMODEL, (Object)pSDEListBase.getListModel());
        }
        if (pSDEListBase.isLockFlagDirty() && (bl || pSDEListBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEListBase.getLockFlag());
        }
        if (pSDEListBase.isLogicNameDirty() && (bl || pSDEListBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEListBase.getLogicName());
        }
        if (pSDEListBase.isLVTagDirty() && (bl || pSDEListBase.getLVTag() != null)) {
            iDataObject.set(FIELD_LVTAG, (Object)pSDEListBase.getLVTag());
        }
        if (pSDEListBase.isLVTag2Dirty() && (bl || pSDEListBase.getLVTag2() != null)) {
            iDataObject.set(FIELD_LVTAG2, (Object)pSDEListBase.getLVTag2());
        }
        if (pSDEListBase.isLVTag3Dirty() && (bl || pSDEListBase.getLVTag3() != null)) {
            iDataObject.set(FIELD_LVTAG3, (Object)pSDEListBase.getLVTag3());
        }
        if (pSDEListBase.isLVTag4Dirty() && (bl || pSDEListBase.getLVTag4() != null)) {
            iDataObject.set(FIELD_LVTAG4, (Object)pSDEListBase.getLVTag4());
        }
        if (pSDEListBase.isMemoDirty() && (bl || pSDEListBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEListBase.getMemo());
        }
        if (pSDEListBase.isMinorSortDirDirty() && (bl || pSDEListBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEListBase.getMinorSortDir());
        }
        if (pSDEListBase.isMinorSortPSDEFIdDirty() && (bl || pSDEListBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEListBase.getMinorSortPSDEFId());
        }
        if (pSDEListBase.isMinorSortPSDEFNameDirty() && (bl || pSDEListBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEListBase.getMinorSortPSDEFName());
        }
        if (pSDEListBase.isMobListStyleDirty() && (bl || pSDEListBase.getMobListStyle() != null)) {
            iDataObject.set(FIELD_MOBLISTSTYLE, (Object)pSDEListBase.getMobListStyle());
        }
        if (pSDEListBase.isMovePSDEActionIdDirty() && (bl || pSDEListBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSDEListBase.getMovePSDEActionId());
        }
        if (pSDEListBase.isMovePSDEActionNameDirty() && (bl || pSDEListBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSDEListBase.getMovePSDEActionName());
        }
        if (pSDEListBase.isMultiSelectDirty() && (bl || pSDEListBase.getMultiSelect() != null)) {
            iDataObject.set(FIELD_MULTISELECT, (Object)pSDEListBase.getMultiSelect());
        }
        if (pSDEListBase.isNavPSDERIdDirty() && (bl || pSDEListBase.getNavPSDERId() != null)) {
            iDataObject.set(FIELD_NAVPSDERID, (Object)pSDEListBase.getNavPSDERId());
        }
        if (pSDEListBase.isNavPSDERNameDirty() && (bl || pSDEListBase.getNavPSDERName() != null)) {
            iDataObject.set(FIELD_NAVPSDERNAME, (Object)pSDEListBase.getNavPSDERName());
        }
        if (pSDEListBase.isNavPSDEViewBaseIdDirty() && (bl || pSDEListBase.getNavPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASEID, (Object)pSDEListBase.getNavPSDEViewBaseId());
        }
        if (pSDEListBase.isNavPSDEViewBaseNameDirty() && (bl || pSDEListBase.getNavPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASENAME, (Object)pSDEListBase.getNavPSDEViewBaseName());
        }
        if (pSDEListBase.isNavViewFilterDirty() && (bl || pSDEListBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEListBase.getNavViewFilter());
        }
        if (pSDEListBase.isNavViewHeightDirty() && (bl || pSDEListBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSDEListBase.getNavViewHeight());
        }
        if (pSDEListBase.isNavViewMaxHeightDirty() && (bl || pSDEListBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSDEListBase.getNavViewMaxHeight());
        }
        if (pSDEListBase.isNavViewMaxWidthDirty() && (bl || pSDEListBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSDEListBase.getNavViewMaxWidth());
        }
        if (pSDEListBase.isNavViewMinHeightDirty() && (bl || pSDEListBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSDEListBase.getNavViewMinHeight());
        }
        if (pSDEListBase.isNavViewMinWidthDirty() && (bl || pSDEListBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSDEListBase.getNavViewMinWidth());
        }
        if (pSDEListBase.isNavViewParamDirty() && (bl || pSDEListBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSDEListBase.getNavViewParam());
        }
        if (pSDEListBase.isNavViewPosDirty() && (bl || pSDEListBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSDEListBase.getNavViewPos());
        }
        if (pSDEListBase.isNavViewShowModeDirty() && (bl || pSDEListBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSDEListBase.getNavViewShowMode());
        }
        if (pSDEListBase.isNavViewWidthDirty() && (bl || pSDEListBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSDEListBase.getNavViewWidth());
        }
        if (pSDEListBase.isNo2PSDEUAGroupIdDirty() && (bl || pSDEListBase.getNo2PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPID, (Object)pSDEListBase.getNo2PSDEUAGroupId());
        }
        if (pSDEListBase.isNo2PSDEUAGroupNameDirty() && (bl || pSDEListBase.getNo2PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPNAME, (Object)pSDEListBase.getNo2PSDEUAGroupName());
        }
        if (pSDEListBase.isNoSortDirty() && (bl || pSDEListBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEListBase.getNoSort());
        }
        if (pSDEListBase.isOrderValuePSDEFIdDirty() && (bl || pSDEListBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSDEListBase.getOrderValuePSDEFId());
        }
        if (pSDEListBase.isOrderValuePSDEFNameDirty() && (bl || pSDEListBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSDEListBase.getOrderValuePSDEFName());
        }
        if (pSDEListBase.isPageSizeDirty() && (bl || pSDEListBase.getPageSize() != null)) {
            iDataObject.set(FIELD_PAGESIZE, (Object)pSDEListBase.getPageSize());
        }
        if (pSDEListBase.isPSACHandlerIdDirty() && (bl || pSDEListBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEListBase.getPSACHandlerId());
        }
        if (pSDEListBase.isPSACHandlerNameDirty() && (bl || pSDEListBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEListBase.getPSACHandlerName());
        }
        if (pSDEListBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEListBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEListBase.getPSCtrlLogicGroupId());
        }
        if (pSDEListBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEListBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEListBase.getPSCtrlLogicGroupName());
        }
        if (pSDEListBase.isPSCtrlMsgIdDirty() && (bl || pSDEListBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEListBase.getPSCtrlMsgId());
        }
        if (pSDEListBase.isPSCtrlMsgNameDirty() && (bl || pSDEListBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEListBase.getPSCtrlMsgName());
        }
        if (pSDEListBase.isPSDEDSIdDirty() && (bl || pSDEListBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEListBase.getPSDEDSId());
        }
        if (pSDEListBase.isPSDEDSNameDirty() && (bl || pSDEListBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEListBase.getPSDEDSName());
        }
        if (pSDEListBase.isPSDEIdDirty() && (bl || pSDEListBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEListBase.getPSDEId());
        }
        if (pSDEListBase.isPSDEListIdDirty() && (bl || pSDEListBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSDEListBase.getPSDEListId());
        }
        if (pSDEListBase.isPSDEListNameDirty() && (bl || pSDEListBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSDEListBase.getPSDEListName());
        }
        if (pSDEListBase.isPSDENameDirty() && (bl || pSDEListBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEListBase.getPSDEName());
        }
        if (pSDEListBase.isPSDEUAGroupIdDirty() && (bl || pSDEListBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEListBase.getPSDEUAGroupId());
        }
        if (pSDEListBase.isPSDEUAGroupNameDirty() && (bl || pSDEListBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEListBase.getPSDEUAGroupName());
        }
        if (pSDEListBase.isPSDynaInstIdDirty() && (bl || pSDEListBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEListBase.getPSDynaInstId());
        }
        if (pSDEListBase.isPSSysCssIdDirty() && (bl || pSDEListBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEListBase.getPSSysCssId());
        }
        if (pSDEListBase.isPSSysCssNameDirty() && (bl || pSDEListBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEListBase.getPSSysCssName());
        }
        if (pSDEListBase.isPSSysPFPluginIdDirty() && (bl || pSDEListBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEListBase.getPSSysPFPluginId());
        }
        if (pSDEListBase.isPSSysPFPluginNameDirty() && (bl || pSDEListBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEListBase.getPSSysPFPluginName());
        }
        if (pSDEListBase.isPSSysReqItemIdDirty() && (bl || pSDEListBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEListBase.getPSSysReqItemId());
        }
        if (pSDEListBase.isPSSysReqItemNameDirty() && (bl || pSDEListBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEListBase.getPSSysReqItemName());
        }
        if (pSDEListBase.isPSSysViewPanelIdDirty() && (bl || pSDEListBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEListBase.getPSSysViewPanelId());
        }
        if (pSDEListBase.isPSSysViewPanelNameDirty() && (bl || pSDEListBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEListBase.getPSSysViewPanelName());
        }
        if (pSDEListBase.isPSViewMsgGroupIdDirty() && (bl || pSDEListBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEListBase.getPSViewMsgGroupId());
        }
        if (pSDEListBase.isPSViewMsgGroupNameDirty() && (bl || pSDEListBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEListBase.getPSViewMsgGroupName());
        }
        if (pSDEListBase.isQuickPSDEToolbarIdDirty() && (bl || pSDEListBase.getQuickPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARID, (Object)pSDEListBase.getQuickPSDEToolbarId());
        }
        if (pSDEListBase.isQuickPSDEToolbarNameDirty() && (bl || pSDEListBase.getQuickPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARNAME, (Object)pSDEListBase.getQuickPSDEToolbarName());
        }
        if (pSDEListBase.isRemovePSDEActionIdDirty() && (bl || pSDEListBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSDEListBase.getRemovePSDEActionId());
        }
        if (pSDEListBase.isRemovePSDEActionNameDirty() && (bl || pSDEListBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSDEListBase.getRemovePSDEActionName());
        }
        if (pSDEListBase.isShowHeaderDirty() && (bl || pSDEListBase.getShowHeader() != null)) {
            iDataObject.set(FIELD_SHOWHEADER, (Object)pSDEListBase.getShowHeader());
        }
        if (pSDEListBase.isSRFSysPubDirty() && (bl || pSDEListBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEListBase.getSRFSysPub());
        }
        if (pSDEListBase.isSwimlanePSCodeListIdDirty() && (bl || pSDEListBase.getSwimlanePSCodeListId() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSCODELISTID, (Object)pSDEListBase.getSwimlanePSCodeListId());
        }
        if (pSDEListBase.isSwimlanePSCodeListNameDirty() && (bl || pSDEListBase.getSwimlanePSCodeListName() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSCODELISTNAME, (Object)pSDEListBase.getSwimlanePSCodeListName());
        }
        if (pSDEListBase.isSwimlanePSDEFIdDirty() && (bl || pSDEListBase.getSwimlanePSDEFId() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSDEFID, (Object)pSDEListBase.getSwimlanePSDEFId());
        }
        if (pSDEListBase.isSwimlanePSDEFNameDirty() && (bl || pSDEListBase.getSwimlanePSDEFName() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSDEFNAME, (Object)pSDEListBase.getSwimlanePSDEFName());
        }
        if (pSDEListBase.isToDoTaskDirty() && (bl || pSDEListBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEListBase.getToDoTask());
        }
        if (pSDEListBase.isUpdateDateDirty() && (bl || pSDEListBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEListBase.getUpdateDate());
        }
        if (pSDEListBase.isUpdateManDirty() && (bl || pSDEListBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEListBase.getUpdateMan());
        }
        if (pSDEListBase.isUpdatePSDEActionIdDirty() && (bl || pSDEListBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDEListBase.getUpdatePSDEActionId());
        }
        if (pSDEListBase.isUpdatePSDEActionNameDirty() && (bl || pSDEListBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDEListBase.getUpdatePSDEActionName());
        }
        if (pSDEListBase.isUser2PSDEActionIdDirty() && (bl || pSDEListBase.getUser2PSDEActionId() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONID, (Object)pSDEListBase.getUser2PSDEActionId());
        }
        if (pSDEListBase.isUser2PSDEActionNameDirty() && (bl || pSDEListBase.getUser2PSDEActionName() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONNAME, (Object)pSDEListBase.getUser2PSDEActionName());
        }
        if (pSDEListBase.isUserPSDEActionIdDirty() && (bl || pSDEListBase.getUserPSDEActionId() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONID, (Object)pSDEListBase.getUserPSDEActionId());
        }
        if (pSDEListBase.isUserPSDEActionNameDirty() && (bl || pSDEListBase.getUserPSDEActionName() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONNAME, (Object)pSDEListBase.getUserPSDEActionName());
        }
        if (pSDEListBase.isUserTagDirty() && (bl || pSDEListBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEListBase.getUserTag());
        }
        if (pSDEListBase.isUserTag2Dirty() && (bl || pSDEListBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEListBase.getUserTag2());
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
        return PSDEListBase.remove(this, n);
    }

    private static boolean remove(PSDEListBase pSDEListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEListBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSDEListBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSDEListBase.resetAppendDEItems();
                return true;
            }
            case 3: {
                pSDEListBase.resetAsyncPSDEDSId();
                return true;
            }
            case 4: {
                pSDEListBase.resetAsyncPSDEDSName();
                return true;
            }
            case 5: {
                pSDEListBase.resetBatPSDEToolbarId();
                return true;
            }
            case 6: {
                pSDEListBase.resetBatPSDEToolbarName();
                return true;
            }
            case 7: {
                pSDEListBase.resetBusyIndicator();
                return true;
            }
            case 8: {
                pSDEListBase.resetCodeName();
                return true;
            }
            case 9: {
                pSDEListBase.resetCopyPSDEActionId();
                return true;
            }
            case 10: {
                pSDEListBase.resetCopyPSDEActionName();
                return true;
            }
            case 11: {
                pSDEListBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSDEListBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSDEListBase.resetCreatePSDEActionId();
                return true;
            }
            case 14: {
                pSDEListBase.resetCreatePSDEActionName();
                return true;
            }
            case 15: {
                pSDEListBase.resetCustomCond();
                return true;
            }
            case 16: {
                pSDEListBase.resetCustomType();
                return true;
            }
            case 17: {
                pSDEListBase.resetDynaModelFlag();
                return true;
            }
            case 18: {
                pSDEListBase.resetEmptyText();
                return true;
            }
            case 19: {
                pSDEListBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 20: {
                pSDEListBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 21: {
                pSDEListBase.resetEnableEdit();
                return true;
            }
            case 22: {
                pSDEListBase.resetEnableItemPriv();
                return true;
            }
            case 23: {
                pSDEListBase.resetEnablePagingBar();
                return true;
            }
            case 24: {
                pSDEListBase.resetGetDraftPSDEActionId();
                return true;
            }
            case 25: {
                pSDEListBase.resetGetDraftPSDEActionName();
                return true;
            }
            case 26: {
                pSDEListBase.resetGetPSDEActionId();
                return true;
            }
            case 27: {
                pSDEListBase.resetGetPSDEActionName();
                return true;
            }
            case 28: {
                pSDEListBase.resetGroupBarCloseMode();
                return true;
            }
            case 29: {
                pSDEListBase.resetGroupMode();
                return true;
            }
            case 30: {
                pSDEListBase.resetGroupMovePSDEActionId();
                return true;
            }
            case 31: {
                pSDEListBase.resetGroupMovePSDEActionName();
                return true;
            }
            case 32: {
                pSDEListBase.resetGroupPSCodeListId();
                return true;
            }
            case 33: {
                pSDEListBase.resetGroupPSCodeListName();
                return true;
            }
            case 34: {
                pSDEListBase.resetGroupPSDEFId();
                return true;
            }
            case 35: {
                pSDEListBase.resetGroupPSDEFName();
                return true;
            }
            case 36: {
                pSDEListBase.resetGroupPSDEId();
                return true;
            }
            case 37: {
                pSDEListBase.resetGroupPSDEName();
                return true;
            }
            case 38: {
                pSDEListBase.resetGroupPSDEUAGroupId();
                return true;
            }
            case 39: {
                pSDEListBase.resetGroupPSDEUAGroupName();
                return true;
            }
            case 40: {
                pSDEListBase.resetGroupPSSysCssId();
                return true;
            }
            case 41: {
                pSDEListBase.resetGroupPSSysCssName();
                return true;
            }
            case 42: {
                pSDEListBase.resetGroupPSSysPFPluginId();
                return true;
            }
            case 43: {
                pSDEListBase.resetGroupPSSysPFPluginName();
                return true;
            }
            case 44: {
                pSDEListBase.resetGroupStyle();
                return true;
            }
            case 45: {
                pSDEListBase.resetGroupTextPSDEFId();
                return true;
            }
            case 46: {
                pSDEListBase.resetGroupTextPSDEFName();
                return true;
            }
            case 47: {
                pSDEListBase.resetItemPSSysCssId();
                return true;
            }
            case 48: {
                pSDEListBase.resetItemPSSysCssName();
                return true;
            }
            case 49: {
                pSDEListBase.resetItemPSSysPFPluginId();
                return true;
            }
            case 50: {
                pSDEListBase.resetItemPSSysPFPluginName();
                return true;
            }
            case 51: {
                pSDEListBase.resetListModel();
                return true;
            }
            case 52: {
                pSDEListBase.resetLockFlag();
                return true;
            }
            case 53: {
                pSDEListBase.resetLogicName();
                return true;
            }
            case 54: {
                pSDEListBase.resetLVTag();
                return true;
            }
            case 55: {
                pSDEListBase.resetLVTag2();
                return true;
            }
            case 56: {
                pSDEListBase.resetLVTag3();
                return true;
            }
            case 57: {
                pSDEListBase.resetLVTag4();
                return true;
            }
            case 58: {
                pSDEListBase.resetMemo();
                return true;
            }
            case 59: {
                pSDEListBase.resetMinorSortDir();
                return true;
            }
            case 60: {
                pSDEListBase.resetMinorSortPSDEFId();
                return true;
            }
            case 61: {
                pSDEListBase.resetMinorSortPSDEFName();
                return true;
            }
            case 62: {
                pSDEListBase.resetMobListStyle();
                return true;
            }
            case 63: {
                pSDEListBase.resetMovePSDEActionId();
                return true;
            }
            case 64: {
                pSDEListBase.resetMovePSDEActionName();
                return true;
            }
            case 65: {
                pSDEListBase.resetMultiSelect();
                return true;
            }
            case 66: {
                pSDEListBase.resetNavPSDERId();
                return true;
            }
            case 67: {
                pSDEListBase.resetNavPSDERName();
                return true;
            }
            case 68: {
                pSDEListBase.resetNavPSDEViewBaseId();
                return true;
            }
            case 69: {
                pSDEListBase.resetNavPSDEViewBaseName();
                return true;
            }
            case 70: {
                pSDEListBase.resetNavViewFilter();
                return true;
            }
            case 71: {
                pSDEListBase.resetNavViewHeight();
                return true;
            }
            case 72: {
                pSDEListBase.resetNavViewMaxHeight();
                return true;
            }
            case 73: {
                pSDEListBase.resetNavViewMaxWidth();
                return true;
            }
            case 74: {
                pSDEListBase.resetNavViewMinHeight();
                return true;
            }
            case 75: {
                pSDEListBase.resetNavViewMinWidth();
                return true;
            }
            case 76: {
                pSDEListBase.resetNavViewParam();
                return true;
            }
            case 77: {
                pSDEListBase.resetNavViewPos();
                return true;
            }
            case 78: {
                pSDEListBase.resetNavViewShowMode();
                return true;
            }
            case 79: {
                pSDEListBase.resetNavViewWidth();
                return true;
            }
            case 80: {
                pSDEListBase.resetNo2PSDEUAGroupId();
                return true;
            }
            case 81: {
                pSDEListBase.resetNo2PSDEUAGroupName();
                return true;
            }
            case 82: {
                pSDEListBase.resetNoSort();
                return true;
            }
            case 83: {
                pSDEListBase.resetOrderValuePSDEFId();
                return true;
            }
            case 84: {
                pSDEListBase.resetOrderValuePSDEFName();
                return true;
            }
            case 85: {
                pSDEListBase.resetPageSize();
                return true;
            }
            case 86: {
                pSDEListBase.resetPSACHandlerId();
                return true;
            }
            case 87: {
                pSDEListBase.resetPSACHandlerName();
                return true;
            }
            case 88: {
                pSDEListBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 89: {
                pSDEListBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 90: {
                pSDEListBase.resetPSCtrlMsgId();
                return true;
            }
            case 91: {
                pSDEListBase.resetPSCtrlMsgName();
                return true;
            }
            case 92: {
                pSDEListBase.resetPSDEDSId();
                return true;
            }
            case 93: {
                pSDEListBase.resetPSDEDSName();
                return true;
            }
            case 94: {
                pSDEListBase.resetPSDEId();
                return true;
            }
            case 95: {
                pSDEListBase.resetPSDEListId();
                return true;
            }
            case 96: {
                pSDEListBase.resetPSDEListName();
                return true;
            }
            case 97: {
                pSDEListBase.resetPSDEName();
                return true;
            }
            case 98: {
                pSDEListBase.resetPSDEUAGroupId();
                return true;
            }
            case 99: {
                pSDEListBase.resetPSDEUAGroupName();
                return true;
            }
            case 100: {
                pSDEListBase.resetPSDynaInstId();
                return true;
            }
            case 101: {
                pSDEListBase.resetPSSysCssId();
                return true;
            }
            case 102: {
                pSDEListBase.resetPSSysCssName();
                return true;
            }
            case 103: {
                pSDEListBase.resetPSSysPFPluginId();
                return true;
            }
            case 104: {
                pSDEListBase.resetPSSysPFPluginName();
                return true;
            }
            case 105: {
                pSDEListBase.resetPSSysReqItemId();
                return true;
            }
            case 106: {
                pSDEListBase.resetPSSysReqItemName();
                return true;
            }
            case 107: {
                pSDEListBase.resetPSSysViewPanelId();
                return true;
            }
            case 108: {
                pSDEListBase.resetPSSysViewPanelName();
                return true;
            }
            case 109: {
                pSDEListBase.resetPSViewMsgGroupId();
                return true;
            }
            case 110: {
                pSDEListBase.resetPSViewMsgGroupName();
                return true;
            }
            case 111: {
                pSDEListBase.resetQuickPSDEToolbarId();
                return true;
            }
            case 112: {
                pSDEListBase.resetQuickPSDEToolbarName();
                return true;
            }
            case 113: {
                pSDEListBase.resetRemovePSDEActionId();
                return true;
            }
            case 114: {
                pSDEListBase.resetRemovePSDEActionName();
                return true;
            }
            case 115: {
                pSDEListBase.resetShowHeader();
                return true;
            }
            case 116: {
                pSDEListBase.resetSRFSysPub();
                return true;
            }
            case 117: {
                pSDEListBase.resetSwimlanePSCodeListId();
                return true;
            }
            case 118: {
                pSDEListBase.resetSwimlanePSCodeListName();
                return true;
            }
            case 119: {
                pSDEListBase.resetSwimlanePSDEFId();
                return true;
            }
            case 120: {
                pSDEListBase.resetSwimlanePSDEFName();
                return true;
            }
            case 121: {
                pSDEListBase.resetToDoTask();
                return true;
            }
            case 122: {
                pSDEListBase.resetUpdateDate();
                return true;
            }
            case 123: {
                pSDEListBase.resetUpdateMan();
                return true;
            }
            case 124: {
                pSDEListBase.resetUpdatePSDEActionId();
                return true;
            }
            case 125: {
                pSDEListBase.resetUpdatePSDEActionName();
                return true;
            }
            case 126: {
                pSDEListBase.resetUser2PSDEActionId();
                return true;
            }
            case 127: {
                pSDEListBase.resetUser2PSDEActionName();
                return true;
            }
            case 128: {
                pSDEListBase.resetUserPSDEActionId();
                return true;
            }
            case 129: {
                pSDEListBase.resetUserPSDEActionName();
                return true;
            }
            case 130: {
                pSDEListBase.resetUserTag();
                return true;
            }
            case 131: {
                pSDEListBase.resetUserTag2();
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
                pSACHandlerService.autoGet(pSACHandler);
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
                pSCodeListService.autoGet(pSCodeList);
                this.grouppscodelist = pSCodeList;
            }
            return this.grouppscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getSwimlanePSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSCodeList();
        }
        if (this.getSwimlanePSCodeListId() == null) {
            return null;
        }
        Integer n = this.objSwimlanePSCodeListLock;
        synchronized (n) {
            if (this.swimlanepscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getSwimlanePSCodeListId(), (Object)this.swimlanepscodelist.getPSCodeListId()) != 0L) {
                this.swimlanepscodelist = null;
            }
            if (this.swimlanepscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getSwimlanePSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.swimlanepscodelist = pSCodeList;
            }
            return this.swimlanepscodelist;
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
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
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
                pSCtrlMsgService.autoGet(pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getGroupPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupPSDE();
        }
        if (this.getGroupPSDEId() == null) {
            return null;
        }
        Integer n = this.objGroupPSDELock;
        synchronized (n) {
            if (this.grouppsde != null && DataTypeHelper.compare((int)25, (Object)this.getGroupPSDEId(), (Object)this.grouppsde.getPSDataEntityId()) != 0L) {
                this.grouppsde = null;
            }
            if (this.grouppsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getGroupPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.grouppsde = pSDataEntity;
            }
            return this.grouppsde;
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
                this.getpsdeaction = pSDEAction;
            }
            return this.getpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getGroupMovePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupMovePSDEAction();
        }
        if (this.getGroupMovePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGroupMovePSDEActionLock;
        synchronized (n) {
            if (this.groupmovepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGroupMovePSDEActionId(), (Object)this.groupmovepsdeaction.getPSDEActionId()) != 0L) {
                this.groupmovepsdeaction = null;
            }
            if (this.groupmovepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGroupMovePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.groupmovepsdeaction = pSDEAction;
            }
            return this.groupmovepsdeaction;
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
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
                pSDEActionService.autoGet(pSDEAction);
                this.userpsdeaction = pSDEAction;
            }
            return this.userpsdeaction;
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.asyncpsdeds = pSDEDataSet;
            }
            return this.asyncpsdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
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
                pSDEFieldService.autoGet(pSDEField);
                this.ordervaluepsdef = pSDEField;
            }
            return this.ordervaluepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSwimlanePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwimlanePSDEF();
        }
        if (this.getSwimlanePSDEFId() == null) {
            return null;
        }
        Integer n = this.objSwimlanePSDEFLock;
        synchronized (n) {
            if (this.swimlanepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSwimlanePSDEFId(), (Object)this.swimlanepsdef.getPSDEFieldId()) != 0L) {
                this.swimlanepsdef = null;
            }
            if (this.swimlanepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSwimlanePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.swimlanepsdef = pSDEField;
            }
            return this.swimlanepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getADPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogic();
        }
        if (this.getADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objADPSDELogicLock;
        synchronized (n) {
            if (this.adpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getADPSDELogicId(), (Object)this.adpsdelogic.getPSDELogicId()) != 0L) {
                this.adpsdelogic = null;
            }
            if (this.adpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
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
                pSDERService.autoGet(pSDER);
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
                pSDEToolbarService.autoGet(pSDEToolbar);
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
                pSDEToolbarService.autoGet(pSDEToolbar);
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
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.grouppsdeuagroup = pSDEUAGroup;
            }
            return this.grouppsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getNo2PSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSDEUAGroup();
        }
        if (this.getNo2PSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objNo2PSDEUAGroupLock;
        synchronized (n) {
            if (this.no2psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSDEUAGroupId(), (Object)this.no2psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.no2psdeuagroup = null;
            }
            if (this.no2psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getNo2PSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.no2psdeuagroup = pSDEUAGroup;
            }
            return this.no2psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
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
                pSLanguageResService.autoGet(pSLanguageRes);
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
                pSSysCssService.autoGet(pSSysCss);
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
                pSSysCssService.autoGet(pSSysCss);
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
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.grouppssyspfplugin = pSSysPFPlugin;
            }
            return this.grouppssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getItemPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSSysPFPlugin();
        }
        if (this.getItemPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objItemPSSysPFPluginLock;
        synchronized (n) {
            if (this.itempssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getItemPSSysPFPluginId(), (Object)this.itempssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.itempssyspfplugin = null;
            }
            if (this.itempssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getItemPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.itempssyspfplugin = pSSysPFPlugin;
            }
            return this.itempssyspfplugin;
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
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
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
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
                pSViewMsgGroupService.autoGet(pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEListItem> getPSDEListItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItems();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEListItemsLock;
        synchronized (n) {
            if (this.psdelistitems == null) {
                this.psdelistitems = pSDEListService.isTempData(this) ? pSDEListItemService.selectTempByPSDEList(this) : pSDEListItemService.selectByPSDEList(this);
            }
            return this.psdelistitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEListLogic> getPSDEListLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListLogics();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        PSDEListLogicService pSDEListLogicService = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEListLogicsLock;
        synchronized (n) {
            if (this.psdelistlogics == null) {
                this.psdelistlogics = pSDEListService.isTempData(this) ? pSDEListLogicService.selectTempByPSDEList(this) : pSDEListLogicService.selectByPSDEList(this);
            }
            return this.psdelistlogics;
        }
    }

    private PSDEListBase getProxyEntity() {
        return this.proxyPSDEListBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEListBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEListBase) {
            this.proxyPSDEListBase = (PSDEListBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 1);
        fieldIndexMap.put(FIELD_APPENDDEITEMS, 2);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSID, 3);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSNAME, 4);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARID, 5);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARNAME, 6);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 7);
        fieldIndexMap.put(FIELD_CODENAME, 8);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONID, 9);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONNAME, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 13);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 14);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 15);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 16);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 17);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 18);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 19);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 20);
        fieldIndexMap.put(FIELD_ENABLEEDIT, 21);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 22);
        fieldIndexMap.put(FIELD_ENABLEPAGINGBAR, 23);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONID, 24);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONNAME, 25);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 26);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 27);
        fieldIndexMap.put(FIELD_GROUPBARCLOSEMODE, 28);
        fieldIndexMap.put(FIELD_GROUPMODE, 29);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONID, 30);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONNAME, 31);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTID, 32);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTNAME, 33);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 34);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 35);
        fieldIndexMap.put(FIELD_GROUPPSDEID, 36);
        fieldIndexMap.put(FIELD_GROUPPSDENAME, 37);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPID, 38);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPNAME, 39);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSID, 40);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSNAME, 41);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINID, 42);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, 43);
        fieldIndexMap.put(FIELD_GROUPSTYLE, 44);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFID, 45);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFNAME, 46);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSID, 47);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSNAME, 48);
        fieldIndexMap.put(FIELD_ITEMPSSYSPFPLUGINID, 49);
        fieldIndexMap.put(FIELD_ITEMPSSYSPFPLUGINNAME, 50);
        fieldIndexMap.put(FIELD_LISTMODEL, 51);
        fieldIndexMap.put(FIELD_LOCKFLAG, 52);
        fieldIndexMap.put(FIELD_LOGICNAME, 53);
        fieldIndexMap.put(FIELD_LVTAG, 54);
        fieldIndexMap.put(FIELD_LVTAG2, 55);
        fieldIndexMap.put(FIELD_LVTAG3, 56);
        fieldIndexMap.put(FIELD_LVTAG4, 57);
        fieldIndexMap.put(FIELD_MEMO, 58);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 59);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 60);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 61);
        fieldIndexMap.put(FIELD_MOBLISTSTYLE, 62);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 63);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 64);
        fieldIndexMap.put(FIELD_MULTISELECT, 65);
        fieldIndexMap.put(FIELD_NAVPSDERID, 66);
        fieldIndexMap.put(FIELD_NAVPSDERNAME, 67);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASEID, 68);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASENAME, 69);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 70);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 71);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 72);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 73);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 74);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 75);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 76);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 77);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 78);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 79);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPID, 80);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPNAME, 81);
        fieldIndexMap.put(FIELD_NOSORT, 82);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 83);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 84);
        fieldIndexMap.put(FIELD_PAGESIZE, 85);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 86);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 87);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 88);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 89);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 90);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 91);
        fieldIndexMap.put(FIELD_PSDEDSID, 92);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 93);
        fieldIndexMap.put(FIELD_PSDEID, 94);
        fieldIndexMap.put(FIELD_PSDELISTID, 95);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 96);
        fieldIndexMap.put(FIELD_PSDENAME, 97);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 98);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 99);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 100);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 101);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 102);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 103);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 104);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 105);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 106);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 107);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 108);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 109);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 110);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARID, 111);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARNAME, 112);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 113);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 114);
        fieldIndexMap.put(FIELD_SHOWHEADER, 115);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 116);
        fieldIndexMap.put(FIELD_SWIMLANEPSCODELISTID, 117);
        fieldIndexMap.put(FIELD_SWIMLANEPSCODELISTNAME, 118);
        fieldIndexMap.put(FIELD_SWIMLANEPSDEFID, 119);
        fieldIndexMap.put(FIELD_SWIMLANEPSDEFNAME, 120);
        fieldIndexMap.put(FIELD_TODOTASK, 121);
        fieldIndexMap.put(FIELD_UPDATEDATE, 122);
        fieldIndexMap.put(FIELD_UPDATEMAN, 123);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 124);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 125);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONID, 126);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONNAME, 127);
        fieldIndexMap.put(FIELD_USERPSDEACTIONID, 128);
        fieldIndexMap.put(FIELD_USERPSDEACTIONNAME, 129);
        fieldIndexMap.put(FIELD_USERTAG, 130);
        fieldIndexMap.put(FIELD_USERTAG2, 131);
    }
}

