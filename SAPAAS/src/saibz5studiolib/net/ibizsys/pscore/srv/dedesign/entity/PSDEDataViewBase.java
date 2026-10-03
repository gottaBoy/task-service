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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataViewBase.class);
    public static final String FIELD_APPENDDEITEMS = "APPENDDEITEMS";
    public static final String FIELD_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String FIELD_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String FIELD_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String FIELD_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CARDHEIGHT = "CARDHEIGHT";
    public static final String FIELD_CARDWIDTH = "CARDWIDTH";
    public static final String FIELD_CARD_COL_LG = "CARD_COL_LG";
    public static final String FIELD_CARD_COL_MD = "CARD_COL_MD";
    public static final String FIELD_CARD_COL_SM = "CARD_COL_SM";
    public static final String FIELD_CARD_COL_XS = "CARD_COL_XS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String FIELD_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String FIELD_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_DATAVIEWSN = "DATAVIEWSN";
    public static final String FIELD_DATAVIEWSTYLE = "DATAVIEWSTYLE";
    public static final String FIELD_DVTAG = "DVTAG";
    public static final String FIELD_DVTAG2 = "DVTAG2";
    public static final String FIELD_DVTAG3 = "DVTAG3";
    public static final String FIELD_DVTAG4 = "DVTAG4";
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
    public static final String FIELD_GROUPHEIGHT = "GROUPHEIGHT";
    public static final String FIELD_GROUPLAYOUT = "GROUPLAYOUT";
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
    public static final String FIELD_GROUPQUICKPSDETBID = "GROUPQUICKPSDETBID";
    public static final String FIELD_GROUPQUICKPSDETBNAME = "GROUPQUICKPSDETBNAME";
    public static final String FIELD_GROUPSTYLE = "GROUPSTYLE";
    public static final String FIELD_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String FIELD_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";
    public static final String FIELD_GROUPWIDTH = "GROUPWIDTH";
    public static final String FIELD_GROUP_COL_LG = "GROUP_COL_LG";
    public static final String FIELD_GROUP_COL_MD = "GROUP_COL_MD";
    public static final String FIELD_GROUP_COL_SM = "GROUP_COL_SM";
    public static final String FIELD_GROUP_COL_XS = "GROUP_COL_XS";
    public static final String FIELD_ITEMPSSYSCSSID = "ITEMPSSYSCSSID";
    public static final String FIELD_ITEMPSSYSCSSNAME = "ITEMPSSYSCSSNAME";
    public static final String FIELD_ITEMPSSYSPFPLUGINID = "ITEMPSSYSPFPLUGINID";
    public static final String FIELD_ITEMPSSYSPFPLUGINNAME = "ITEMPSSYSPFPLUGINNAME";
    public static final String FIELD_KANBANFLAG = "KANBANFLAG";
    public static final String FIELD_LAYOUTITEMTYPE = "LAYOUTITEMTYPE";
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
    public static final String FIELD_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
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
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String FIELD_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
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
    public static final String FIELD_VIEWMODEL = "VIEWMODEL";
    private static final int INDEX_APPENDDEITEMS = 0;
    private static final int INDEX_ASYNCPSDEDSID = 1;
    private static final int INDEX_ASYNCPSDEDSNAME = 2;
    private static final int INDEX_BATPSDETOOLBARID = 3;
    private static final int INDEX_BATPSDETOOLBARNAME = 4;
    private static final int INDEX_BUSYINDICATOR = 5;
    private static final int INDEX_CARDHEIGHT = 6;
    private static final int INDEX_CARDWIDTH = 7;
    private static final int INDEX_CARD_COL_LG = 8;
    private static final int INDEX_CARD_COL_MD = 9;
    private static final int INDEX_CARD_COL_SM = 10;
    private static final int INDEX_CARD_COL_XS = 11;
    private static final int INDEX_CODENAME = 12;
    private static final int INDEX_COPYPSDEACTIONID = 13;
    private static final int INDEX_COPYPSDEACTIONNAME = 14;
    private static final int INDEX_CREATEDATE = 15;
    private static final int INDEX_CREATEMAN = 16;
    private static final int INDEX_CREATEPSDEACTIONID = 17;
    private static final int INDEX_CREATEPSDEACTIONNAME = 18;
    private static final int INDEX_CUSTOMCOND = 19;
    private static final int INDEX_CUSTOMTYPE = 20;
    private static final int INDEX_DATAVIEWSN = 21;
    private static final int INDEX_DATAVIEWSTYLE = 22;
    private static final int INDEX_DVTAG = 23;
    private static final int INDEX_DVTAG2 = 24;
    private static final int INDEX_DVTAG3 = 25;
    private static final int INDEX_DVTAG4 = 26;
    private static final int INDEX_DYNAMODELFLAG = 27;
    private static final int INDEX_EMPTYTEXT = 28;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 29;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 30;
    private static final int INDEX_ENABLEEDIT = 31;
    private static final int INDEX_ENABLEITEMPRIV = 32;
    private static final int INDEX_ENABLEPAGINGBAR = 33;
    private static final int INDEX_GETDRAFTPSDEACTIONID = 34;
    private static final int INDEX_GETDRAFTPSDEACTIONNAME = 35;
    private static final int INDEX_GETPSDEACTIONID = 36;
    private static final int INDEX_GETPSDEACTIONNAME = 37;
    private static final int INDEX_GROUPBARCLOSEMODE = 38;
    private static final int INDEX_GROUPHEIGHT = 39;
    private static final int INDEX_GROUPLAYOUT = 40;
    private static final int INDEX_GROUPMODE = 41;
    private static final int INDEX_GROUPMOVEPSDEACTIONID = 42;
    private static final int INDEX_GROUPMOVEPSDEACTIONNAME = 43;
    private static final int INDEX_GROUPPSCODELISTID = 44;
    private static final int INDEX_GROUPPSCODELISTNAME = 45;
    private static final int INDEX_GROUPPSDEFID = 46;
    private static final int INDEX_GROUPPSDEFNAME = 47;
    private static final int INDEX_GROUPPSDEID = 48;
    private static final int INDEX_GROUPPSDENAME = 49;
    private static final int INDEX_GROUPPSDEUAGROUPID = 50;
    private static final int INDEX_GROUPPSDEUAGROUPNAME = 51;
    private static final int INDEX_GROUPPSSYSCSSID = 52;
    private static final int INDEX_GROUPPSSYSCSSNAME = 53;
    private static final int INDEX_GROUPPSSYSPFPLUGINID = 54;
    private static final int INDEX_GROUPPSSYSPFPLUGINNAME = 55;
    private static final int INDEX_GROUPQUICKPSDETBID = 56;
    private static final int INDEX_GROUPQUICKPSDETBNAME = 57;
    private static final int INDEX_GROUPSTYLE = 58;
    private static final int INDEX_GROUPTEXTPSDEFID = 59;
    private static final int INDEX_GROUPTEXTPSDEFNAME = 60;
    private static final int INDEX_GROUPWIDTH = 61;
    private static final int INDEX_GROUP_COL_LG = 62;
    private static final int INDEX_GROUP_COL_MD = 63;
    private static final int INDEX_GROUP_COL_SM = 64;
    private static final int INDEX_GROUP_COL_XS = 65;
    private static final int INDEX_ITEMPSSYSCSSID = 66;
    private static final int INDEX_ITEMPSSYSCSSNAME = 67;
    private static final int INDEX_ITEMPSSYSPFPLUGINID = 68;
    private static final int INDEX_ITEMPSSYSPFPLUGINNAME = 69;
    private static final int INDEX_KANBANFLAG = 70;
    private static final int INDEX_LAYOUTITEMTYPE = 71;
    private static final int INDEX_LOCKFLAG = 72;
    private static final int INDEX_MEMO = 73;
    private static final int INDEX_MINORSORTDIR = 74;
    private static final int INDEX_MINORSORTPSDEFID = 75;
    private static final int INDEX_MINORSORTPSDEFNAME = 76;
    private static final int INDEX_MOVEPSDEACTIONID = 77;
    private static final int INDEX_MOVEPSDEACTIONNAME = 78;
    private static final int INDEX_MULTISELECT = 79;
    private static final int INDEX_NAVPSDERID = 80;
    private static final int INDEX_NAVPSDERNAME = 81;
    private static final int INDEX_NAVPSDEVIEWBASEID = 82;
    private static final int INDEX_NAVPSDEVIEWBASENAME = 83;
    private static final int INDEX_NAVVIEWFILTER = 84;
    private static final int INDEX_NAVVIEWHEIGHT = 85;
    private static final int INDEX_NAVVIEWMAXHEIGHT = 86;
    private static final int INDEX_NAVVIEWMAXWIDTH = 87;
    private static final int INDEX_NAVVIEWMINHEIGHT = 88;
    private static final int INDEX_NAVVIEWMINWIDTH = 89;
    private static final int INDEX_NAVVIEWPARAM = 90;
    private static final int INDEX_NAVVIEWPOS = 91;
    private static final int INDEX_NAVVIEWSHOWMODE = 92;
    private static final int INDEX_NAVVIEWWIDTH = 93;
    private static final int INDEX_NO2PSDEUAGROUPID = 94;
    private static final int INDEX_NO2PSDEUAGROUPNAME = 95;
    private static final int INDEX_NOSORT = 96;
    private static final int INDEX_ORDERVALUEPSDEFID = 97;
    private static final int INDEX_ORDERVALUEPSDEFNAME = 98;
    private static final int INDEX_PAGINGSIZE = 99;
    private static final int INDEX_PSACHANDLERID = 100;
    private static final int INDEX_PSACHANDLERNAME = 101;
    private static final int INDEX_PSCTRLLOGICGROUPID = 102;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 103;
    private static final int INDEX_PSCTRLMSGID = 104;
    private static final int INDEX_PSCTRLMSGNAME = 105;
    private static final int INDEX_PSDEDATASETID = 106;
    private static final int INDEX_PSDEDATASETNAME = 107;
    private static final int INDEX_PSDEDATAVIEWID = 108;
    private static final int INDEX_PSDEDATAVIEWNAME = 109;
    private static final int INDEX_PSDEFORMID = 110;
    private static final int INDEX_PSDEFORMNAME = 111;
    private static final int INDEX_PSDEID = 112;
    private static final int INDEX_PSDENAME = 113;
    private static final int INDEX_PSDEUAGROUPID = 114;
    private static final int INDEX_PSDEUAGROUPNAME = 115;
    private static final int INDEX_PSDYNAINSTID = 116;
    private static final int INDEX_PSSYSCSSID = 117;
    private static final int INDEX_PSSYSCSSNAME = 118;
    private static final int INDEX_PSSYSPFPLUGINID = 119;
    private static final int INDEX_PSSYSPFPLUGINNAME = 120;
    private static final int INDEX_PSSYSVIEWPANELID = 121;
    private static final int INDEX_PSSYSVIEWPANELNAME = 122;
    private static final int INDEX_PSVIEWMSGGROUPID = 123;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 124;
    private static final int INDEX_QUICKPSDETOOLBARID = 125;
    private static final int INDEX_QUICKPSDETOOLBARNAME = 126;
    private static final int INDEX_REMOVEPSDEACTIONID = 127;
    private static final int INDEX_REMOVEPSDEACTIONNAME = 128;
    private static final int INDEX_SRFSYSPUB = 129;
    private static final int INDEX_SWIMLANEPSCODELISTID = 130;
    private static final int INDEX_SWIMLANEPSCODELISTNAME = 131;
    private static final int INDEX_SWIMLANEPSDEFID = 132;
    private static final int INDEX_SWIMLANEPSDEFNAME = 133;
    private static final int INDEX_TODOTASK = 134;
    private static final int INDEX_UPDATEDATE = 135;
    private static final int INDEX_UPDATEMAN = 136;
    private static final int INDEX_UPDATEPSDEACTIONID = 137;
    private static final int INDEX_UPDATEPSDEACTIONNAME = 138;
    private static final int INDEX_USER2PSDEACTIONID = 139;
    private static final int INDEX_USER2PSDEACTIONNAME = 140;
    private static final int INDEX_USERPSDEACTIONID = 141;
    private static final int INDEX_USERPSDEACTIONNAME = 142;
    private static final int INDEX_VIEWMODEL = 143;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataViewBase proxyPSDEDataViewBase = null;
    private boolean appenddeitemsDirtyFlag = false;
    private boolean asyncpsdedsidDirtyFlag = false;
    private boolean asyncpsdedsnameDirtyFlag = false;
    private boolean batpsdetoolbaridDirtyFlag = false;
    private boolean batpsdetoolbarnameDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean cardheightDirtyFlag = false;
    private boolean cardwidthDirtyFlag = false;
    private boolean card_col_lgDirtyFlag = false;
    private boolean card_col_mdDirtyFlag = false;
    private boolean card_col_smDirtyFlag = false;
    private boolean card_col_xsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean copypsdeactionidDirtyFlag = false;
    private boolean copypsdeactionnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeactionidDirtyFlag = false;
    private boolean createpsdeactionnameDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean dataviewsnDirtyFlag = false;
    private boolean dataviewstyleDirtyFlag = false;
    private boolean dvtagDirtyFlag = false;
    private boolean dvtag2DirtyFlag = false;
    private boolean dvtag3DirtyFlag = false;
    private boolean dvtag4DirtyFlag = false;
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
    private boolean groupheightDirtyFlag = false;
    private boolean grouplayoutDirtyFlag = false;
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
    private boolean groupquickpsdetbidDirtyFlag = false;
    private boolean groupquickpsdetbnameDirtyFlag = false;
    private boolean groupstyleDirtyFlag = false;
    private boolean grouptextpsdefidDirtyFlag = false;
    private boolean grouptextpsdefnameDirtyFlag = false;
    private boolean groupwidthDirtyFlag = false;
    private boolean group_col_lgDirtyFlag = false;
    private boolean group_col_mdDirtyFlag = false;
    private boolean group_col_smDirtyFlag = false;
    private boolean group_col_xsDirtyFlag = false;
    private boolean itempssyscssidDirtyFlag = false;
    private boolean itempssyscssnameDirtyFlag = false;
    private boolean itempssyspfpluginidDirtyFlag = false;
    private boolean itempssyspfpluginnameDirtyFlag = false;
    private boolean kanbanflagDirtyFlag = false;
    private boolean layoutitemtypeDirtyFlag = false;
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
    private boolean no2psdeuagroupidDirtyFlag = false;
    private boolean no2psdeuagroupnameDirtyFlag = false;
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
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean quickpsdetoolbaridDirtyFlag = false;
    private boolean quickpsdetoolbarnameDirtyFlag = false;
    private boolean removepsdeactionidDirtyFlag = false;
    private boolean removepsdeactionnameDirtyFlag = false;
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
    private boolean viewmodelDirtyFlag = false;
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
    @Column(name="cardheight")
    private Integer cardheight;
    @Column(name="cardwidth")
    private Integer cardwidth;
    @Column(name="card_col_lg")
    private Integer card_col_lg;
    @Column(name="card_col_md")
    private Integer card_col_md;
    @Column(name="card_col_sm")
    private Integer card_col_sm;
    @Column(name="card_col_xs")
    private Integer card_col_xs;
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
    @Column(name="dataviewsn")
    private String dataviewsn;
    @Column(name="dataviewstyle")
    private String dataviewstyle;
    @Column(name="dvtag")
    private String dvtag;
    @Column(name="dvtag2")
    private String dvtag2;
    @Column(name="dvtag3")
    private String dvtag3;
    @Column(name="dvtag4")
    private String dvtag4;
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
    @Column(name="groupheight")
    private Integer groupheight;
    @Column(name="grouplayout")
    private String grouplayout;
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
    @Column(name="groupquickpsdetbid")
    private String groupquickpsdetbid;
    @Column(name="groupquickpsdetbname")
    private String groupquickpsdetbname;
    @Column(name="groupstyle")
    private String groupstyle;
    @Column(name="grouptextpsdefid")
    private String grouptextpsdefid;
    @Column(name="grouptextpsdefname")
    private String grouptextpsdefname;
    @Column(name="groupwidth")
    private Integer groupwidth;
    @Column(name="group_col_lg")
    private Integer group_col_lg;
    @Column(name="group_col_md")
    private Integer group_col_md;
    @Column(name="group_col_sm")
    private Integer group_col_sm;
    @Column(name="group_col_xs")
    private Integer group_col_xs;
    @Column(name="itempssyscssid")
    private String itempssyscssid;
    @Column(name="itempssyscssname")
    private String itempssyscssname;
    @Column(name="itempssyspfpluginid")
    private String itempssyspfpluginid;
    @Column(name="itempssyspfpluginname")
    private String itempssyspfpluginname;
    @Column(name="kanbanflag")
    private Integer kanbanflag;
    @Column(name="layoutitemtype")
    private String layoutitemtype;
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
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
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
    @Column(name="viewmodel")
    private String viewmodel;
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
    private Integer objSwimlanePSDEFLock = new Integer(1);
    private PSDEField swimlanepsdef = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objNavPSDERLock = new Integer(1);
    private PSDER navpsder = null;
    private Integer objBatPSDEToolbarLock = new Integer(1);
    private PSDEToolbar batpsdetoolbar = null;
    private Integer objGroupQuickPSDEToolbarLock = new Integer(1);
    private PSDEToolbar groupquickpsdetoolbar = null;
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
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDEDataViewLogicsLock = new Integer(1);
    private ArrayList<PSDEDataViewLogic> psdedataviewlogics = null;
    private Integer objPSDEListItemLock = new Integer(1);
    private ArrayList<PSDEListItem> psdelistitem = null;

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

    public void setCardHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCardHeight(n);
            return;
        }
        this.cardheight = n;
        this.cardheightDirtyFlag = true;
    }

    public Integer getCardHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCardHeight();
        }
        return this.cardheight;
    }

    public boolean isCardHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCardHeightDirty();
        }
        return this.cardheightDirtyFlag;
    }

    public void resetCardHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCardHeight();
            return;
        }
        this.cardheightDirtyFlag = false;
        this.cardheight = null;
    }

    public void setCardWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCardWidth(n);
            return;
        }
        this.cardwidth = n;
        this.cardwidthDirtyFlag = true;
    }

    public Integer getCardWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCardWidth();
        }
        return this.cardwidth;
    }

    public boolean isCardWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCardWidthDirty();
        }
        return this.cardwidthDirtyFlag;
    }

    public void resetCardWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCardWidth();
            return;
        }
        this.cardwidthDirtyFlag = false;
        this.cardwidth = null;
    }

    public void setCard_Col_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCard_Col_LG(n);
            return;
        }
        this.card_col_lg = n;
        this.card_col_lgDirtyFlag = true;
    }

    public Integer getCard_Col_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCard_Col_LG();
        }
        return this.card_col_lg;
    }

    public boolean isCard_Col_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCard_Col_LGDirty();
        }
        return this.card_col_lgDirtyFlag;
    }

    public void resetCard_Col_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCard_Col_LG();
            return;
        }
        this.card_col_lgDirtyFlag = false;
        this.card_col_lg = null;
    }

    public void setCard_Col_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCard_Col_MD(n);
            return;
        }
        this.card_col_md = n;
        this.card_col_mdDirtyFlag = true;
    }

    public Integer getCard_Col_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCard_Col_MD();
        }
        return this.card_col_md;
    }

    public boolean isCard_Col_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCard_Col_MDDirty();
        }
        return this.card_col_mdDirtyFlag;
    }

    public void resetCard_Col_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCard_Col_MD();
            return;
        }
        this.card_col_mdDirtyFlag = false;
        this.card_col_md = null;
    }

    public void setCard_Col_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCard_Col_SM(n);
            return;
        }
        this.card_col_sm = n;
        this.card_col_smDirtyFlag = true;
    }

    public Integer getCard_Col_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCard_Col_SM();
        }
        return this.card_col_sm;
    }

    public boolean isCard_Col_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCard_Col_SMDirty();
        }
        return this.card_col_smDirtyFlag;
    }

    public void resetCard_Col_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCard_Col_SM();
            return;
        }
        this.card_col_smDirtyFlag = false;
        this.card_col_sm = null;
    }

    public void setCard_Col_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCard_Col_XS(n);
            return;
        }
        this.card_col_xs = n;
        this.card_col_xsDirtyFlag = true;
    }

    public Integer getCard_Col_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCard_Col_XS();
        }
        return this.card_col_xs;
    }

    public boolean isCard_Col_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCard_Col_XSDirty();
        }
        return this.card_col_xsDirtyFlag;
    }

    public void resetCard_Col_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCard_Col_XS();
            return;
        }
        this.card_col_xsDirtyFlag = false;
        this.card_col_xs = null;
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

    public void setDataViewSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataViewSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataviewsn = string;
        this.dataviewsnDirtyFlag = true;
    }

    public String getDataViewSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataViewSN();
        }
        return this.dataviewsn;
    }

    public boolean isDataViewSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataViewSNDirty();
        }
        return this.dataviewsnDirtyFlag;
    }

    public void resetDataViewSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataViewSN();
            return;
        }
        this.dataviewsnDirtyFlag = false;
        this.dataviewsn = null;
    }

    public void setDataViewStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataViewStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataviewstyle = string;
        this.dataviewstyleDirtyFlag = true;
    }

    public String getDataViewStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataViewStyle();
        }
        return this.dataviewstyle;
    }

    public boolean isDataViewStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataViewStyleDirty();
        }
        return this.dataviewstyleDirtyFlag;
    }

    public void resetDataViewStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataViewStyle();
            return;
        }
        this.dataviewstyleDirtyFlag = false;
        this.dataviewstyle = null;
    }

    public void setDVTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDVTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dvtag = string;
        this.dvtagDirtyFlag = true;
    }

    public String getDVTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDVTag();
        }
        return this.dvtag;
    }

    public boolean isDVTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDVTagDirty();
        }
        return this.dvtagDirtyFlag;
    }

    public void resetDVTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDVTag();
            return;
        }
        this.dvtagDirtyFlag = false;
        this.dvtag = null;
    }

    public void setDVTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDVTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dvtag2 = string;
        this.dvtag2DirtyFlag = true;
    }

    public String getDVTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDVTag2();
        }
        return this.dvtag2;
    }

    public boolean isDVTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDVTag2Dirty();
        }
        return this.dvtag2DirtyFlag;
    }

    public void resetDVTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDVTag2();
            return;
        }
        this.dvtag2DirtyFlag = false;
        this.dvtag2 = null;
    }

    public void setDVTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDVTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dvtag3 = string;
        this.dvtag3DirtyFlag = true;
    }

    public String getDVTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDVTag3();
        }
        return this.dvtag3;
    }

    public boolean isDVTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDVTag3Dirty();
        }
        return this.dvtag3DirtyFlag;
    }

    public void resetDVTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDVTag3();
            return;
        }
        this.dvtag3DirtyFlag = false;
        this.dvtag3 = null;
    }

    public void setDVTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDVTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dvtag4 = string;
        this.dvtag4DirtyFlag = true;
    }

    public String getDVTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDVTag4();
        }
        return this.dvtag4;
    }

    public boolean isDVTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDVTag4Dirty();
        }
        return this.dvtag4DirtyFlag;
    }

    public void resetDVTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDVTag4();
            return;
        }
        this.dvtag4DirtyFlag = false;
        this.dvtag4 = null;
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

    public void setGroupHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupHeight(n);
            return;
        }
        this.groupheight = n;
        this.groupheightDirtyFlag = true;
    }

    public Integer getGroupHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupHeight();
        }
        return this.groupheight;
    }

    public boolean isGroupHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupHeightDirty();
        }
        return this.groupheightDirtyFlag;
    }

    public void resetGroupHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupHeight();
            return;
        }
        this.groupheightDirtyFlag = false;
        this.groupheight = null;
    }

    public void setGroupLayout(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupLayout(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouplayout = string;
        this.grouplayoutDirtyFlag = true;
    }

    public String getGroupLayout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupLayout();
        }
        return this.grouplayout;
    }

    public boolean isGroupLayoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupLayoutDirty();
        }
        return this.grouplayoutDirtyFlag;
    }

    public void resetGroupLayout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupLayout();
            return;
        }
        this.grouplayoutDirtyFlag = false;
        this.grouplayout = null;
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

    public void setGroupQuickPSDETBId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupQuickPSDETBId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupquickpsdetbid = string;
        this.groupquickpsdetbidDirtyFlag = true;
    }

    public String getGroupQuickPSDETBId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupQuickPSDETBId();
        }
        return this.groupquickpsdetbid;
    }

    public boolean isGroupQuickPSDETBIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupQuickPSDETBIdDirty();
        }
        return this.groupquickpsdetbidDirtyFlag;
    }

    public void resetGroupQuickPSDETBId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupQuickPSDETBId();
            return;
        }
        this.groupquickpsdetbidDirtyFlag = false;
        this.groupquickpsdetbid = null;
    }

    public void setGroupQuickPSDETBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupQuickPSDETBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupquickpsdetbname = string;
        this.groupquickpsdetbnameDirtyFlag = true;
    }

    public String getGroupQuickPSDETBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupQuickPSDETBName();
        }
        return this.groupquickpsdetbname;
    }

    public boolean isGroupQuickPSDETBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupQuickPSDETBNameDirty();
        }
        return this.groupquickpsdetbnameDirtyFlag;
    }

    public void resetGroupQuickPSDETBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupQuickPSDETBName();
            return;
        }
        this.groupquickpsdetbnameDirtyFlag = false;
        this.groupquickpsdetbname = null;
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

    public void setGroupWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupWidth(n);
            return;
        }
        this.groupwidth = n;
        this.groupwidthDirtyFlag = true;
    }

    public Integer getGroupWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupWidth();
        }
        return this.groupwidth;
    }

    public boolean isGroupWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupWidthDirty();
        }
        return this.groupwidthDirtyFlag;
    }

    public void resetGroupWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupWidth();
            return;
        }
        this.groupwidthDirtyFlag = false;
        this.groupwidth = null;
    }

    public void setGroup_Col_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroup_Col_LG(n);
            return;
        }
        this.group_col_lg = n;
        this.group_col_lgDirtyFlag = true;
    }

    public Integer getGroup_Col_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroup_Col_LG();
        }
        return this.group_col_lg;
    }

    public boolean isGroup_Col_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroup_Col_LGDirty();
        }
        return this.group_col_lgDirtyFlag;
    }

    public void resetGroup_Col_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroup_Col_LG();
            return;
        }
        this.group_col_lgDirtyFlag = false;
        this.group_col_lg = null;
    }

    public void setGroup_Col_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroup_Col_MD(n);
            return;
        }
        this.group_col_md = n;
        this.group_col_mdDirtyFlag = true;
    }

    public Integer getGroup_Col_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroup_Col_MD();
        }
        return this.group_col_md;
    }

    public boolean isGroup_Col_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroup_Col_MDDirty();
        }
        return this.group_col_mdDirtyFlag;
    }

    public void resetGroup_Col_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroup_Col_MD();
            return;
        }
        this.group_col_mdDirtyFlag = false;
        this.group_col_md = null;
    }

    public void setGroup_Col_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroup_Col_SM(n);
            return;
        }
        this.group_col_sm = n;
        this.group_col_smDirtyFlag = true;
    }

    public Integer getGroup_Col_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroup_Col_SM();
        }
        return this.group_col_sm;
    }

    public boolean isGroup_Col_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroup_Col_SMDirty();
        }
        return this.group_col_smDirtyFlag;
    }

    public void resetGroup_Col_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroup_Col_SM();
            return;
        }
        this.group_col_smDirtyFlag = false;
        this.group_col_sm = null;
    }

    public void setGroup_Col_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroup_Col_XS(n);
            return;
        }
        this.group_col_xs = n;
        this.group_col_xsDirtyFlag = true;
    }

    public Integer getGroup_Col_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroup_Col_XS();
        }
        return this.group_col_xs;
    }

    public boolean isGroup_Col_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroup_Col_XSDirty();
        }
        return this.group_col_xsDirtyFlag;
    }

    public void resetGroup_Col_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroup_Col_XS();
            return;
        }
        this.group_col_xsDirtyFlag = false;
        this.group_col_xs = null;
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

    public void setKanbanFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKanbanFlag(n);
            return;
        }
        this.kanbanflag = n;
        this.kanbanflagDirtyFlag = true;
    }

    public Integer getKanbanFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKanbanFlag();
        }
        return this.kanbanflag;
    }

    public boolean isKanbanFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKanbanFlagDirty();
        }
        return this.kanbanflagDirtyFlag;
    }

    public void resetKanbanFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKanbanFlag();
            return;
        }
        this.kanbanflagDirtyFlag = false;
        this.kanbanflag = null;
    }

    public void setLayoutItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutitemtype = string;
        this.layoutitemtypeDirtyFlag = true;
    }

    public String getLayoutItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutItemType();
        }
        return this.layoutitemtype;
    }

    public boolean isLayoutItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutItemTypeDirty();
        }
        return this.layoutitemtypeDirtyFlag;
    }

    public void resetLayoutItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutItemType();
            return;
        }
        this.layoutitemtypeDirtyFlag = false;
        this.layoutitemtype = null;
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

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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

    public void setViewModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewmodel = string;
        this.viewmodelDirtyFlag = true;
    }

    public String getViewModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewModel();
        }
        return this.viewmodel;
    }

    public boolean isViewModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewModelDirty();
        }
        return this.viewmodelDirtyFlag;
    }

    public void resetViewModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewModel();
            return;
        }
        this.viewmodelDirtyFlag = false;
        this.viewmodel = null;
    }

    protected void onReset() {
        PSDEDataViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataViewBase pSDEDataViewBase) {
        pSDEDataViewBase.resetAppendDEItems();
        pSDEDataViewBase.resetAsyncPSDEDSId();
        pSDEDataViewBase.resetAsyncPSDEDSName();
        pSDEDataViewBase.resetBatPSDEToolbarId();
        pSDEDataViewBase.resetBatPSDEToolbarName();
        pSDEDataViewBase.resetBusyIndicator();
        pSDEDataViewBase.resetCardHeight();
        pSDEDataViewBase.resetCardWidth();
        pSDEDataViewBase.resetCard_Col_LG();
        pSDEDataViewBase.resetCard_Col_MD();
        pSDEDataViewBase.resetCard_Col_SM();
        pSDEDataViewBase.resetCard_Col_XS();
        pSDEDataViewBase.resetCodeName();
        pSDEDataViewBase.resetCopyPSDEActionId();
        pSDEDataViewBase.resetCopyPSDEActionName();
        pSDEDataViewBase.resetCreateDate();
        pSDEDataViewBase.resetCreateMan();
        pSDEDataViewBase.resetCreatePSDEActionId();
        pSDEDataViewBase.resetCreatePSDEActionName();
        pSDEDataViewBase.resetCustomCond();
        pSDEDataViewBase.resetCustomType();
        pSDEDataViewBase.resetDataViewSN();
        pSDEDataViewBase.resetDataViewStyle();
        pSDEDataViewBase.resetDVTag();
        pSDEDataViewBase.resetDVTag2();
        pSDEDataViewBase.resetDVTag3();
        pSDEDataViewBase.resetDVTag4();
        pSDEDataViewBase.resetDynaModelFlag();
        pSDEDataViewBase.resetEmptyText();
        pSDEDataViewBase.resetEmptyTextPSLanResId();
        pSDEDataViewBase.resetEmptyTextPSLanResName();
        pSDEDataViewBase.resetEnableEdit();
        pSDEDataViewBase.resetEnableItemPriv();
        pSDEDataViewBase.resetEnablePagingBar();
        pSDEDataViewBase.resetGetDraftPSDEActionId();
        pSDEDataViewBase.resetGetDraftPSDEActionName();
        pSDEDataViewBase.resetGetPSDEActionId();
        pSDEDataViewBase.resetGetPSDEActionName();
        pSDEDataViewBase.resetGroupBarCloseMode();
        pSDEDataViewBase.resetGroupHeight();
        pSDEDataViewBase.resetGroupLayout();
        pSDEDataViewBase.resetGroupMode();
        pSDEDataViewBase.resetGroupMovePSDEActionId();
        pSDEDataViewBase.resetGroupMovePSDEActionName();
        pSDEDataViewBase.resetGroupPSCodeListId();
        pSDEDataViewBase.resetGroupPSCodeListName();
        pSDEDataViewBase.resetGroupPSDEFId();
        pSDEDataViewBase.resetGroupPSDEFName();
        pSDEDataViewBase.resetGroupPSDEId();
        pSDEDataViewBase.resetGroupPSDEName();
        pSDEDataViewBase.resetGroupPSDEUAGroupId();
        pSDEDataViewBase.resetGroupPSDEUAGroupName();
        pSDEDataViewBase.resetGroupPSSysCssId();
        pSDEDataViewBase.resetGroupPSSysCssName();
        pSDEDataViewBase.resetGroupPSSysPFPluginId();
        pSDEDataViewBase.resetGroupPSSysPFPluginName();
        pSDEDataViewBase.resetGroupQuickPSDETBId();
        pSDEDataViewBase.resetGroupQuickPSDETBName();
        pSDEDataViewBase.resetGroupStyle();
        pSDEDataViewBase.resetGroupTextPSDEFId();
        pSDEDataViewBase.resetGroupTextPSDEFName();
        pSDEDataViewBase.resetGroupWidth();
        pSDEDataViewBase.resetGroup_Col_LG();
        pSDEDataViewBase.resetGroup_Col_MD();
        pSDEDataViewBase.resetGroup_Col_SM();
        pSDEDataViewBase.resetGroup_Col_XS();
        pSDEDataViewBase.resetItemPSSysCssId();
        pSDEDataViewBase.resetItemPSSysCssName();
        pSDEDataViewBase.resetItemPSSysPFPluginId();
        pSDEDataViewBase.resetItemPSSysPFPluginName();
        pSDEDataViewBase.resetKanbanFlag();
        pSDEDataViewBase.resetLayoutItemType();
        pSDEDataViewBase.resetLockFlag();
        pSDEDataViewBase.resetMemo();
        pSDEDataViewBase.resetMinorSortDir();
        pSDEDataViewBase.resetMinorSortPSDEFId();
        pSDEDataViewBase.resetMinorSortPSDEFName();
        pSDEDataViewBase.resetMovePSDEActionId();
        pSDEDataViewBase.resetMovePSDEActionName();
        pSDEDataViewBase.resetMultiSelect();
        pSDEDataViewBase.resetNavPSDERId();
        pSDEDataViewBase.resetNavPSDERName();
        pSDEDataViewBase.resetNavPSDEViewBaseId();
        pSDEDataViewBase.resetNavPSDEViewBaseName();
        pSDEDataViewBase.resetNavViewFilter();
        pSDEDataViewBase.resetNavViewHeight();
        pSDEDataViewBase.resetNavViewMaxHeight();
        pSDEDataViewBase.resetNavViewMaxWidth();
        pSDEDataViewBase.resetNavViewMinHeight();
        pSDEDataViewBase.resetNavViewMinWidth();
        pSDEDataViewBase.resetNavViewParam();
        pSDEDataViewBase.resetNavViewPos();
        pSDEDataViewBase.resetNavViewShowMode();
        pSDEDataViewBase.resetNavViewWidth();
        pSDEDataViewBase.resetNo2PSDEUAGroupId();
        pSDEDataViewBase.resetNo2PSDEUAGroupName();
        pSDEDataViewBase.resetNoSort();
        pSDEDataViewBase.resetOrderValuePSDEFId();
        pSDEDataViewBase.resetOrderValuePSDEFName();
        pSDEDataViewBase.resetPagingSize();
        pSDEDataViewBase.resetPSACHandlerId();
        pSDEDataViewBase.resetPSACHandlerName();
        pSDEDataViewBase.resetPSCtrlLogicGroupId();
        pSDEDataViewBase.resetPSCtrlLogicGroupName();
        pSDEDataViewBase.resetPSCtrlMsgId();
        pSDEDataViewBase.resetPSCtrlMsgName();
        pSDEDataViewBase.resetPSDEDataSetId();
        pSDEDataViewBase.resetPSDEDataSetName();
        pSDEDataViewBase.resetPSDEDataViewId();
        pSDEDataViewBase.resetPSDEDataViewName();
        pSDEDataViewBase.resetPSDEFormId();
        pSDEDataViewBase.resetPSDEFormName();
        pSDEDataViewBase.resetPSDEId();
        pSDEDataViewBase.resetPSDEName();
        pSDEDataViewBase.resetPSDEUAGroupId();
        pSDEDataViewBase.resetPSDEUAGroupName();
        pSDEDataViewBase.resetPSDynaInstId();
        pSDEDataViewBase.resetPSSysCssId();
        pSDEDataViewBase.resetPSSysCssName();
        pSDEDataViewBase.resetPSSysPFPluginId();
        pSDEDataViewBase.resetPSSysPFPluginName();
        pSDEDataViewBase.resetPSSysViewPanelId();
        pSDEDataViewBase.resetPSSysViewPanelName();
        pSDEDataViewBase.resetPSViewMsgGroupId();
        pSDEDataViewBase.resetPSViewMsgGroupName();
        pSDEDataViewBase.resetQuickPSDEToolbarId();
        pSDEDataViewBase.resetQuickPSDEToolbarName();
        pSDEDataViewBase.resetRemovePSDEActionId();
        pSDEDataViewBase.resetRemovePSDEActionName();
        pSDEDataViewBase.resetSRFSysPub();
        pSDEDataViewBase.resetSwimlanePSCodeListId();
        pSDEDataViewBase.resetSwimlanePSCodeListName();
        pSDEDataViewBase.resetSwimlanePSDEFId();
        pSDEDataViewBase.resetSwimlanePSDEFName();
        pSDEDataViewBase.resetToDoTask();
        pSDEDataViewBase.resetUpdateDate();
        pSDEDataViewBase.resetUpdateMan();
        pSDEDataViewBase.resetUpdatePSDEActionId();
        pSDEDataViewBase.resetUpdatePSDEActionName();
        pSDEDataViewBase.resetUser2PSDEActionId();
        pSDEDataViewBase.resetUser2PSDEActionName();
        pSDEDataViewBase.resetUserPSDEActionId();
        pSDEDataViewBase.resetUserPSDEActionName();
        pSDEDataViewBase.resetViewModel();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isCardHeightDirty()) {
            hashMap.put(FIELD_CARDHEIGHT, this.getCardHeight());
        }
        if (!bl || this.isCardWidthDirty()) {
            hashMap.put(FIELD_CARDWIDTH, this.getCardWidth());
        }
        if (!bl || this.isCard_Col_LGDirty()) {
            hashMap.put(FIELD_CARD_COL_LG, this.getCard_Col_LG());
        }
        if (!bl || this.isCard_Col_MDDirty()) {
            hashMap.put(FIELD_CARD_COL_MD, this.getCard_Col_MD());
        }
        if (!bl || this.isCard_Col_SMDirty()) {
            hashMap.put(FIELD_CARD_COL_SM, this.getCard_Col_SM());
        }
        if (!bl || this.isCard_Col_XSDirty()) {
            hashMap.put(FIELD_CARD_COL_XS, this.getCard_Col_XS());
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
        if (!bl || this.isDataViewSNDirty()) {
            hashMap.put(FIELD_DATAVIEWSN, this.getDataViewSN());
        }
        if (!bl || this.isDataViewStyleDirty()) {
            hashMap.put(FIELD_DATAVIEWSTYLE, this.getDataViewStyle());
        }
        if (!bl || this.isDVTagDirty()) {
            hashMap.put(FIELD_DVTAG, this.getDVTag());
        }
        if (!bl || this.isDVTag2Dirty()) {
            hashMap.put(FIELD_DVTAG2, this.getDVTag2());
        }
        if (!bl || this.isDVTag3Dirty()) {
            hashMap.put(FIELD_DVTAG3, this.getDVTag3());
        }
        if (!bl || this.isDVTag4Dirty()) {
            hashMap.put(FIELD_DVTAG4, this.getDVTag4());
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
        if (!bl || this.isGroupHeightDirty()) {
            hashMap.put(FIELD_GROUPHEIGHT, this.getGroupHeight());
        }
        if (!bl || this.isGroupLayoutDirty()) {
            hashMap.put(FIELD_GROUPLAYOUT, this.getGroupLayout());
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
        if (!bl || this.isGroupQuickPSDETBIdDirty()) {
            hashMap.put(FIELD_GROUPQUICKPSDETBID, this.getGroupQuickPSDETBId());
        }
        if (!bl || this.isGroupQuickPSDETBNameDirty()) {
            hashMap.put(FIELD_GROUPQUICKPSDETBNAME, this.getGroupQuickPSDETBName());
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
        if (!bl || this.isGroupWidthDirty()) {
            hashMap.put(FIELD_GROUPWIDTH, this.getGroupWidth());
        }
        if (!bl || this.isGroup_Col_LGDirty()) {
            hashMap.put(FIELD_GROUP_COL_LG, this.getGroup_Col_LG());
        }
        if (!bl || this.isGroup_Col_MDDirty()) {
            hashMap.put(FIELD_GROUP_COL_MD, this.getGroup_Col_MD());
        }
        if (!bl || this.isGroup_Col_SMDirty()) {
            hashMap.put(FIELD_GROUP_COL_SM, this.getGroup_Col_SM());
        }
        if (!bl || this.isGroup_Col_XSDirty()) {
            hashMap.put(FIELD_GROUP_COL_XS, this.getGroup_Col_XS());
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
        if (!bl || this.isKanbanFlagDirty()) {
            hashMap.put(FIELD_KANBANFLAG, this.getKanbanFlag());
        }
        if (!bl || this.isLayoutItemTypeDirty()) {
            hashMap.put(FIELD_LAYOUTITEMTYPE, this.getLayoutItemType());
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
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        if (!bl || this.isViewModelDirty()) {
            hashMap.put(FIELD_VIEWMODEL, this.getViewModel());
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
        return PSDEDataViewBase.get(this, n);
    }

    private static Object get(PSDEDataViewBase pSDEDataViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewBase.getAppendDEItems();
            }
            case 1: {
                return pSDEDataViewBase.getAsyncPSDEDSId();
            }
            case 2: {
                return pSDEDataViewBase.getAsyncPSDEDSName();
            }
            case 3: {
                return pSDEDataViewBase.getBatPSDEToolbarId();
            }
            case 4: {
                return pSDEDataViewBase.getBatPSDEToolbarName();
            }
            case 5: {
                return pSDEDataViewBase.getBusyIndicator();
            }
            case 6: {
                return pSDEDataViewBase.getCardHeight();
            }
            case 7: {
                return pSDEDataViewBase.getCardWidth();
            }
            case 8: {
                return pSDEDataViewBase.getCard_Col_LG();
            }
            case 9: {
                return pSDEDataViewBase.getCard_Col_MD();
            }
            case 10: {
                return pSDEDataViewBase.getCard_Col_SM();
            }
            case 11: {
                return pSDEDataViewBase.getCard_Col_XS();
            }
            case 12: {
                return pSDEDataViewBase.getCodeName();
            }
            case 13: {
                return pSDEDataViewBase.getCopyPSDEActionId();
            }
            case 14: {
                return pSDEDataViewBase.getCopyPSDEActionName();
            }
            case 15: {
                return pSDEDataViewBase.getCreateDate();
            }
            case 16: {
                return pSDEDataViewBase.getCreateMan();
            }
            case 17: {
                return pSDEDataViewBase.getCreatePSDEActionId();
            }
            case 18: {
                return pSDEDataViewBase.getCreatePSDEActionName();
            }
            case 19: {
                return pSDEDataViewBase.getCustomCond();
            }
            case 20: {
                return pSDEDataViewBase.getCustomType();
            }
            case 21: {
                return pSDEDataViewBase.getDataViewSN();
            }
            case 22: {
                return pSDEDataViewBase.getDataViewStyle();
            }
            case 23: {
                return pSDEDataViewBase.getDVTag();
            }
            case 24: {
                return pSDEDataViewBase.getDVTag2();
            }
            case 25: {
                return pSDEDataViewBase.getDVTag3();
            }
            case 26: {
                return pSDEDataViewBase.getDVTag4();
            }
            case 27: {
                return pSDEDataViewBase.getDynaModelFlag();
            }
            case 28: {
                return pSDEDataViewBase.getEmptyText();
            }
            case 29: {
                return pSDEDataViewBase.getEmptyTextPSLanResId();
            }
            case 30: {
                return pSDEDataViewBase.getEmptyTextPSLanResName();
            }
            case 31: {
                return pSDEDataViewBase.getEnableEdit();
            }
            case 32: {
                return pSDEDataViewBase.getEnableItemPriv();
            }
            case 33: {
                return pSDEDataViewBase.getEnablePagingBar();
            }
            case 34: {
                return pSDEDataViewBase.getGetDraftPSDEActionId();
            }
            case 35: {
                return pSDEDataViewBase.getGetDraftPSDEActionName();
            }
            case 36: {
                return pSDEDataViewBase.getGetPSDEActionId();
            }
            case 37: {
                return pSDEDataViewBase.getGetPSDEActionName();
            }
            case 38: {
                return pSDEDataViewBase.getGroupBarCloseMode();
            }
            case 39: {
                return pSDEDataViewBase.getGroupHeight();
            }
            case 40: {
                return pSDEDataViewBase.getGroupLayout();
            }
            case 41: {
                return pSDEDataViewBase.getGroupMode();
            }
            case 42: {
                return pSDEDataViewBase.getGroupMovePSDEActionId();
            }
            case 43: {
                return pSDEDataViewBase.getGroupMovePSDEActionName();
            }
            case 44: {
                return pSDEDataViewBase.getGroupPSCodeListId();
            }
            case 45: {
                return pSDEDataViewBase.getGroupPSCodeListName();
            }
            case 46: {
                return pSDEDataViewBase.getGroupPSDEFId();
            }
            case 47: {
                return pSDEDataViewBase.getGroupPSDEFName();
            }
            case 48: {
                return pSDEDataViewBase.getGroupPSDEId();
            }
            case 49: {
                return pSDEDataViewBase.getGroupPSDEName();
            }
            case 50: {
                return pSDEDataViewBase.getGroupPSDEUAGroupId();
            }
            case 51: {
                return pSDEDataViewBase.getGroupPSDEUAGroupName();
            }
            case 52: {
                return pSDEDataViewBase.getGroupPSSysCssId();
            }
            case 53: {
                return pSDEDataViewBase.getGroupPSSysCssName();
            }
            case 54: {
                return pSDEDataViewBase.getGroupPSSysPFPluginId();
            }
            case 55: {
                return pSDEDataViewBase.getGroupPSSysPFPluginName();
            }
            case 56: {
                return pSDEDataViewBase.getGroupQuickPSDETBId();
            }
            case 57: {
                return pSDEDataViewBase.getGroupQuickPSDETBName();
            }
            case 58: {
                return pSDEDataViewBase.getGroupStyle();
            }
            case 59: {
                return pSDEDataViewBase.getGroupTextPSDEFId();
            }
            case 60: {
                return pSDEDataViewBase.getGroupTextPSDEFName();
            }
            case 61: {
                return pSDEDataViewBase.getGroupWidth();
            }
            case 62: {
                return pSDEDataViewBase.getGroup_Col_LG();
            }
            case 63: {
                return pSDEDataViewBase.getGroup_Col_MD();
            }
            case 64: {
                return pSDEDataViewBase.getGroup_Col_SM();
            }
            case 65: {
                return pSDEDataViewBase.getGroup_Col_XS();
            }
            case 66: {
                return pSDEDataViewBase.getItemPSSysCssId();
            }
            case 67: {
                return pSDEDataViewBase.getItemPSSysCssName();
            }
            case 68: {
                return pSDEDataViewBase.getItemPSSysPFPluginId();
            }
            case 69: {
                return pSDEDataViewBase.getItemPSSysPFPluginName();
            }
            case 70: {
                return pSDEDataViewBase.getKanbanFlag();
            }
            case 71: {
                return pSDEDataViewBase.getLayoutItemType();
            }
            case 72: {
                return pSDEDataViewBase.getLockFlag();
            }
            case 73: {
                return pSDEDataViewBase.getMemo();
            }
            case 74: {
                return pSDEDataViewBase.getMinorSortDir();
            }
            case 75: {
                return pSDEDataViewBase.getMinorSortPSDEFId();
            }
            case 76: {
                return pSDEDataViewBase.getMinorSortPSDEFName();
            }
            case 77: {
                return pSDEDataViewBase.getMovePSDEActionId();
            }
            case 78: {
                return pSDEDataViewBase.getMovePSDEActionName();
            }
            case 79: {
                return pSDEDataViewBase.getMultiSelect();
            }
            case 80: {
                return pSDEDataViewBase.getNavPSDERId();
            }
            case 81: {
                return pSDEDataViewBase.getNavPSDERName();
            }
            case 82: {
                return pSDEDataViewBase.getNavPSDEViewBaseId();
            }
            case 83: {
                return pSDEDataViewBase.getNavPSDEViewBaseName();
            }
            case 84: {
                return pSDEDataViewBase.getNavViewFilter();
            }
            case 85: {
                return pSDEDataViewBase.getNavViewHeight();
            }
            case 86: {
                return pSDEDataViewBase.getNavViewMaxHeight();
            }
            case 87: {
                return pSDEDataViewBase.getNavViewMaxWidth();
            }
            case 88: {
                return pSDEDataViewBase.getNavViewMinHeight();
            }
            case 89: {
                return pSDEDataViewBase.getNavViewMinWidth();
            }
            case 90: {
                return pSDEDataViewBase.getNavViewParam();
            }
            case 91: {
                return pSDEDataViewBase.getNavViewPos();
            }
            case 92: {
                return pSDEDataViewBase.getNavViewShowMode();
            }
            case 93: {
                return pSDEDataViewBase.getNavViewWidth();
            }
            case 94: {
                return pSDEDataViewBase.getNo2PSDEUAGroupId();
            }
            case 95: {
                return pSDEDataViewBase.getNo2PSDEUAGroupName();
            }
            case 96: {
                return pSDEDataViewBase.getNoSort();
            }
            case 97: {
                return pSDEDataViewBase.getOrderValuePSDEFId();
            }
            case 98: {
                return pSDEDataViewBase.getOrderValuePSDEFName();
            }
            case 99: {
                return pSDEDataViewBase.getPagingSize();
            }
            case 100: {
                return pSDEDataViewBase.getPSACHandlerId();
            }
            case 101: {
                return pSDEDataViewBase.getPSACHandlerName();
            }
            case 102: {
                return pSDEDataViewBase.getPSCtrlLogicGroupId();
            }
            case 103: {
                return pSDEDataViewBase.getPSCtrlLogicGroupName();
            }
            case 104: {
                return pSDEDataViewBase.getPSCtrlMsgId();
            }
            case 105: {
                return pSDEDataViewBase.getPSCtrlMsgName();
            }
            case 106: {
                return pSDEDataViewBase.getPSDEDataSetId();
            }
            case 107: {
                return pSDEDataViewBase.getPSDEDataSetName();
            }
            case 108: {
                return pSDEDataViewBase.getPSDEDataViewId();
            }
            case 109: {
                return pSDEDataViewBase.getPSDEDataViewName();
            }
            case 110: {
                return pSDEDataViewBase.getPSDEFormId();
            }
            case 111: {
                return pSDEDataViewBase.getPSDEFormName();
            }
            case 112: {
                return pSDEDataViewBase.getPSDEId();
            }
            case 113: {
                return pSDEDataViewBase.getPSDEName();
            }
            case 114: {
                return pSDEDataViewBase.getPSDEUAGroupId();
            }
            case 115: {
                return pSDEDataViewBase.getPSDEUAGroupName();
            }
            case 116: {
                return pSDEDataViewBase.getPSDynaInstId();
            }
            case 117: {
                return pSDEDataViewBase.getPSSysCssId();
            }
            case 118: {
                return pSDEDataViewBase.getPSSysCssName();
            }
            case 119: {
                return pSDEDataViewBase.getPSSysPFPluginId();
            }
            case 120: {
                return pSDEDataViewBase.getPSSysPFPluginName();
            }
            case 121: {
                return pSDEDataViewBase.getPSSysViewPanelId();
            }
            case 122: {
                return pSDEDataViewBase.getPSSysViewPanelName();
            }
            case 123: {
                return pSDEDataViewBase.getPSViewMsgGroupId();
            }
            case 124: {
                return pSDEDataViewBase.getPSViewMsgGroupName();
            }
            case 125: {
                return pSDEDataViewBase.getQuickPSDEToolbarId();
            }
            case 126: {
                return pSDEDataViewBase.getQuickPSDEToolbarName();
            }
            case 127: {
                return pSDEDataViewBase.getRemovePSDEActionId();
            }
            case 128: {
                return pSDEDataViewBase.getRemovePSDEActionName();
            }
            case 129: {
                return pSDEDataViewBase.getSRFSysPub();
            }
            case 130: {
                return pSDEDataViewBase.getSwimlanePSCodeListId();
            }
            case 131: {
                return pSDEDataViewBase.getSwimlanePSCodeListName();
            }
            case 132: {
                return pSDEDataViewBase.getSwimlanePSDEFId();
            }
            case 133: {
                return pSDEDataViewBase.getSwimlanePSDEFName();
            }
            case 134: {
                return pSDEDataViewBase.getToDoTask();
            }
            case 135: {
                return pSDEDataViewBase.getUpdateDate();
            }
            case 136: {
                return pSDEDataViewBase.getUpdateMan();
            }
            case 137: {
                return pSDEDataViewBase.getUpdatePSDEActionId();
            }
            case 138: {
                return pSDEDataViewBase.getUpdatePSDEActionName();
            }
            case 139: {
                return pSDEDataViewBase.getUser2PSDEActionId();
            }
            case 140: {
                return pSDEDataViewBase.getUser2PSDEActionName();
            }
            case 141: {
                return pSDEDataViewBase.getUserPSDEActionId();
            }
            case 142: {
                return pSDEDataViewBase.getUserPSDEActionName();
            }
            case 143: {
                return pSDEDataViewBase.getViewModel();
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
        PSDEDataViewBase.set(this, n, object);
    }

    private static void set(PSDEDataViewBase pSDEDataViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataViewBase.setAppendDEItems(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataViewBase.setAsyncPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataViewBase.setAsyncPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataViewBase.setBatPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataViewBase.setBatPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataViewBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataViewBase.setCardHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataViewBase.setCardWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataViewBase.setCard_Col_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataViewBase.setCard_Col_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataViewBase.setCard_Col_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataViewBase.setCard_Col_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataViewBase.setCopyPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataViewBase.setCopyPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataViewBase.setCreatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataViewBase.setCreatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataViewBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataViewBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataViewBase.setDataViewSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataViewBase.setDataViewStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataViewBase.setDVTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataViewBase.setDVTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataViewBase.setDVTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataViewBase.setDVTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataViewBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataViewBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataViewBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataViewBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataViewBase.setEnableEdit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataViewBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataViewBase.setEnablePagingBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataViewBase.setGetDraftPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataViewBase.setGetDraftPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataViewBase.setGetPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataViewBase.setGetPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataViewBase.setGroupBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataViewBase.setGroupHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataViewBase.setGroupLayout(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataViewBase.setGroupMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataViewBase.setGroupMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDataViewBase.setGroupMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEDataViewBase.setGroupPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDataViewBase.setGroupPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEDataViewBase.setGroupPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDataViewBase.setGroupPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDataViewBase.setGroupPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDataViewBase.setGroupPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDataViewBase.setGroupPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEDataViewBase.setGroupPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEDataViewBase.setGroupPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEDataViewBase.setGroupPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEDataViewBase.setGroupPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEDataViewBase.setGroupPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEDataViewBase.setGroupQuickPSDETBId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEDataViewBase.setGroupQuickPSDETBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEDataViewBase.setGroupStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEDataViewBase.setGroupTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEDataViewBase.setGroupTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEDataViewBase.setGroupWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSDEDataViewBase.setGroup_Col_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSDEDataViewBase.setGroup_Col_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 64: {
                pSDEDataViewBase.setGroup_Col_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSDEDataViewBase.setGroup_Col_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSDEDataViewBase.setItemPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEDataViewBase.setItemPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEDataViewBase.setItemPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEDataViewBase.setItemPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEDataViewBase.setKanbanFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSDEDataViewBase.setLayoutItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEDataViewBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSDEDataViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEDataViewBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEDataViewBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEDataViewBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEDataViewBase.setMovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEDataViewBase.setMovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEDataViewBase.setMultiSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSDEDataViewBase.setNavPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEDataViewBase.setNavPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEDataViewBase.setNavPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDEDataViewBase.setNavPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDEDataViewBase.setNavViewFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEDataViewBase.setNavViewHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 86: {
                pSDEDataViewBase.setNavViewMaxHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 87: {
                pSDEDataViewBase.setNavViewMaxWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 88: {
                pSDEDataViewBase.setNavViewMinHeight(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 89: {
                pSDEDataViewBase.setNavViewMinWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 90: {
                pSDEDataViewBase.setNavViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEDataViewBase.setNavViewPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEDataViewBase.setNavViewShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 93: {
                pSDEDataViewBase.setNavViewWidth(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 94: {
                pSDEDataViewBase.setNo2PSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEDataViewBase.setNo2PSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEDataViewBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 97: {
                pSDEDataViewBase.setOrderValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEDataViewBase.setOrderValuePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEDataViewBase.setPagingSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 100: {
                pSDEDataViewBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDEDataViewBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEDataViewBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEDataViewBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEDataViewBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEDataViewBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEDataViewBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEDataViewBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEDataViewBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEDataViewBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEDataViewBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEDataViewBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEDataViewBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEDataViewBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEDataViewBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEDataViewBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEDataViewBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDEDataViewBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEDataViewBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDEDataViewBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEDataViewBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEDataViewBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEDataViewBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDEDataViewBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDEDataViewBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEDataViewBase.setQuickPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEDataViewBase.setQuickPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEDataViewBase.setRemovePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEDataViewBase.setRemovePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEDataViewBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 130: {
                pSDEDataViewBase.setSwimlanePSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEDataViewBase.setSwimlanePSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDEDataViewBase.setSwimlanePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDEDataViewBase.setSwimlanePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDEDataViewBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDEDataViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 136: {
                pSDEDataViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDEDataViewBase.setUpdatePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDEDataViewBase.setUpdatePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDEDataViewBase.setUser2PSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDEDataViewBase.setUser2PSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDEDataViewBase.setUserPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDEDataViewBase.setUserPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDEDataViewBase.setViewModel(DataObject.getStringValue((Object)object));
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
        return PSDEDataViewBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataViewBase pSDEDataViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewBase.getAppendDEItems() == null;
            }
            case 1: {
                return pSDEDataViewBase.getAsyncPSDEDSId() == null;
            }
            case 2: {
                return pSDEDataViewBase.getAsyncPSDEDSName() == null;
            }
            case 3: {
                return pSDEDataViewBase.getBatPSDEToolbarId() == null;
            }
            case 4: {
                return pSDEDataViewBase.getBatPSDEToolbarName() == null;
            }
            case 5: {
                return pSDEDataViewBase.getBusyIndicator() == null;
            }
            case 6: {
                return pSDEDataViewBase.getCardHeight() == null;
            }
            case 7: {
                return pSDEDataViewBase.getCardWidth() == null;
            }
            case 8: {
                return pSDEDataViewBase.getCard_Col_LG() == null;
            }
            case 9: {
                return pSDEDataViewBase.getCard_Col_MD() == null;
            }
            case 10: {
                return pSDEDataViewBase.getCard_Col_SM() == null;
            }
            case 11: {
                return pSDEDataViewBase.getCard_Col_XS() == null;
            }
            case 12: {
                return pSDEDataViewBase.getCodeName() == null;
            }
            case 13: {
                return pSDEDataViewBase.getCopyPSDEActionId() == null;
            }
            case 14: {
                return pSDEDataViewBase.getCopyPSDEActionName() == null;
            }
            case 15: {
                return pSDEDataViewBase.getCreateDate() == null;
            }
            case 16: {
                return pSDEDataViewBase.getCreateMan() == null;
            }
            case 17: {
                return pSDEDataViewBase.getCreatePSDEActionId() == null;
            }
            case 18: {
                return pSDEDataViewBase.getCreatePSDEActionName() == null;
            }
            case 19: {
                return pSDEDataViewBase.getCustomCond() == null;
            }
            case 20: {
                return pSDEDataViewBase.getCustomType() == null;
            }
            case 21: {
                return pSDEDataViewBase.getDataViewSN() == null;
            }
            case 22: {
                return pSDEDataViewBase.getDataViewStyle() == null;
            }
            case 23: {
                return pSDEDataViewBase.getDVTag() == null;
            }
            case 24: {
                return pSDEDataViewBase.getDVTag2() == null;
            }
            case 25: {
                return pSDEDataViewBase.getDVTag3() == null;
            }
            case 26: {
                return pSDEDataViewBase.getDVTag4() == null;
            }
            case 27: {
                return pSDEDataViewBase.getDynaModelFlag() == null;
            }
            case 28: {
                return pSDEDataViewBase.getEmptyText() == null;
            }
            case 29: {
                return pSDEDataViewBase.getEmptyTextPSLanResId() == null;
            }
            case 30: {
                return pSDEDataViewBase.getEmptyTextPSLanResName() == null;
            }
            case 31: {
                return pSDEDataViewBase.getEnableEdit() == null;
            }
            case 32: {
                return pSDEDataViewBase.getEnableItemPriv() == null;
            }
            case 33: {
                return pSDEDataViewBase.getEnablePagingBar() == null;
            }
            case 34: {
                return pSDEDataViewBase.getGetDraftPSDEActionId() == null;
            }
            case 35: {
                return pSDEDataViewBase.getGetDraftPSDEActionName() == null;
            }
            case 36: {
                return pSDEDataViewBase.getGetPSDEActionId() == null;
            }
            case 37: {
                return pSDEDataViewBase.getGetPSDEActionName() == null;
            }
            case 38: {
                return pSDEDataViewBase.getGroupBarCloseMode() == null;
            }
            case 39: {
                return pSDEDataViewBase.getGroupHeight() == null;
            }
            case 40: {
                return pSDEDataViewBase.getGroupLayout() == null;
            }
            case 41: {
                return pSDEDataViewBase.getGroupMode() == null;
            }
            case 42: {
                return pSDEDataViewBase.getGroupMovePSDEActionId() == null;
            }
            case 43: {
                return pSDEDataViewBase.getGroupMovePSDEActionName() == null;
            }
            case 44: {
                return pSDEDataViewBase.getGroupPSCodeListId() == null;
            }
            case 45: {
                return pSDEDataViewBase.getGroupPSCodeListName() == null;
            }
            case 46: {
                return pSDEDataViewBase.getGroupPSDEFId() == null;
            }
            case 47: {
                return pSDEDataViewBase.getGroupPSDEFName() == null;
            }
            case 48: {
                return pSDEDataViewBase.getGroupPSDEId() == null;
            }
            case 49: {
                return pSDEDataViewBase.getGroupPSDEName() == null;
            }
            case 50: {
                return pSDEDataViewBase.getGroupPSDEUAGroupId() == null;
            }
            case 51: {
                return pSDEDataViewBase.getGroupPSDEUAGroupName() == null;
            }
            case 52: {
                return pSDEDataViewBase.getGroupPSSysCssId() == null;
            }
            case 53: {
                return pSDEDataViewBase.getGroupPSSysCssName() == null;
            }
            case 54: {
                return pSDEDataViewBase.getGroupPSSysPFPluginId() == null;
            }
            case 55: {
                return pSDEDataViewBase.getGroupPSSysPFPluginName() == null;
            }
            case 56: {
                return pSDEDataViewBase.getGroupQuickPSDETBId() == null;
            }
            case 57: {
                return pSDEDataViewBase.getGroupQuickPSDETBName() == null;
            }
            case 58: {
                return pSDEDataViewBase.getGroupStyle() == null;
            }
            case 59: {
                return pSDEDataViewBase.getGroupTextPSDEFId() == null;
            }
            case 60: {
                return pSDEDataViewBase.getGroupTextPSDEFName() == null;
            }
            case 61: {
                return pSDEDataViewBase.getGroupWidth() == null;
            }
            case 62: {
                return pSDEDataViewBase.getGroup_Col_LG() == null;
            }
            case 63: {
                return pSDEDataViewBase.getGroup_Col_MD() == null;
            }
            case 64: {
                return pSDEDataViewBase.getGroup_Col_SM() == null;
            }
            case 65: {
                return pSDEDataViewBase.getGroup_Col_XS() == null;
            }
            case 66: {
                return pSDEDataViewBase.getItemPSSysCssId() == null;
            }
            case 67: {
                return pSDEDataViewBase.getItemPSSysCssName() == null;
            }
            case 68: {
                return pSDEDataViewBase.getItemPSSysPFPluginId() == null;
            }
            case 69: {
                return pSDEDataViewBase.getItemPSSysPFPluginName() == null;
            }
            case 70: {
                return pSDEDataViewBase.getKanbanFlag() == null;
            }
            case 71: {
                return pSDEDataViewBase.getLayoutItemType() == null;
            }
            case 72: {
                return pSDEDataViewBase.getLockFlag() == null;
            }
            case 73: {
                return pSDEDataViewBase.getMemo() == null;
            }
            case 74: {
                return pSDEDataViewBase.getMinorSortDir() == null;
            }
            case 75: {
                return pSDEDataViewBase.getMinorSortPSDEFId() == null;
            }
            case 76: {
                return pSDEDataViewBase.getMinorSortPSDEFName() == null;
            }
            case 77: {
                return pSDEDataViewBase.getMovePSDEActionId() == null;
            }
            case 78: {
                return pSDEDataViewBase.getMovePSDEActionName() == null;
            }
            case 79: {
                return pSDEDataViewBase.getMultiSelect() == null;
            }
            case 80: {
                return pSDEDataViewBase.getNavPSDERId() == null;
            }
            case 81: {
                return pSDEDataViewBase.getNavPSDERName() == null;
            }
            case 82: {
                return pSDEDataViewBase.getNavPSDEViewBaseId() == null;
            }
            case 83: {
                return pSDEDataViewBase.getNavPSDEViewBaseName() == null;
            }
            case 84: {
                return pSDEDataViewBase.getNavViewFilter() == null;
            }
            case 85: {
                return pSDEDataViewBase.getNavViewHeight() == null;
            }
            case 86: {
                return pSDEDataViewBase.getNavViewMaxHeight() == null;
            }
            case 87: {
                return pSDEDataViewBase.getNavViewMaxWidth() == null;
            }
            case 88: {
                return pSDEDataViewBase.getNavViewMinHeight() == null;
            }
            case 89: {
                return pSDEDataViewBase.getNavViewMinWidth() == null;
            }
            case 90: {
                return pSDEDataViewBase.getNavViewParam() == null;
            }
            case 91: {
                return pSDEDataViewBase.getNavViewPos() == null;
            }
            case 92: {
                return pSDEDataViewBase.getNavViewShowMode() == null;
            }
            case 93: {
                return pSDEDataViewBase.getNavViewWidth() == null;
            }
            case 94: {
                return pSDEDataViewBase.getNo2PSDEUAGroupId() == null;
            }
            case 95: {
                return pSDEDataViewBase.getNo2PSDEUAGroupName() == null;
            }
            case 96: {
                return pSDEDataViewBase.getNoSort() == null;
            }
            case 97: {
                return pSDEDataViewBase.getOrderValuePSDEFId() == null;
            }
            case 98: {
                return pSDEDataViewBase.getOrderValuePSDEFName() == null;
            }
            case 99: {
                return pSDEDataViewBase.getPagingSize() == null;
            }
            case 100: {
                return pSDEDataViewBase.getPSACHandlerId() == null;
            }
            case 101: {
                return pSDEDataViewBase.getPSACHandlerName() == null;
            }
            case 102: {
                return pSDEDataViewBase.getPSCtrlLogicGroupId() == null;
            }
            case 103: {
                return pSDEDataViewBase.getPSCtrlLogicGroupName() == null;
            }
            case 104: {
                return pSDEDataViewBase.getPSCtrlMsgId() == null;
            }
            case 105: {
                return pSDEDataViewBase.getPSCtrlMsgName() == null;
            }
            case 106: {
                return pSDEDataViewBase.getPSDEDataSetId() == null;
            }
            case 107: {
                return pSDEDataViewBase.getPSDEDataSetName() == null;
            }
            case 108: {
                return pSDEDataViewBase.getPSDEDataViewId() == null;
            }
            case 109: {
                return pSDEDataViewBase.getPSDEDataViewName() == null;
            }
            case 110: {
                return pSDEDataViewBase.getPSDEFormId() == null;
            }
            case 111: {
                return pSDEDataViewBase.getPSDEFormName() == null;
            }
            case 112: {
                return pSDEDataViewBase.getPSDEId() == null;
            }
            case 113: {
                return pSDEDataViewBase.getPSDEName() == null;
            }
            case 114: {
                return pSDEDataViewBase.getPSDEUAGroupId() == null;
            }
            case 115: {
                return pSDEDataViewBase.getPSDEUAGroupName() == null;
            }
            case 116: {
                return pSDEDataViewBase.getPSDynaInstId() == null;
            }
            case 117: {
                return pSDEDataViewBase.getPSSysCssId() == null;
            }
            case 118: {
                return pSDEDataViewBase.getPSSysCssName() == null;
            }
            case 119: {
                return pSDEDataViewBase.getPSSysPFPluginId() == null;
            }
            case 120: {
                return pSDEDataViewBase.getPSSysPFPluginName() == null;
            }
            case 121: {
                return pSDEDataViewBase.getPSSysViewPanelId() == null;
            }
            case 122: {
                return pSDEDataViewBase.getPSSysViewPanelName() == null;
            }
            case 123: {
                return pSDEDataViewBase.getPSViewMsgGroupId() == null;
            }
            case 124: {
                return pSDEDataViewBase.getPSViewMsgGroupName() == null;
            }
            case 125: {
                return pSDEDataViewBase.getQuickPSDEToolbarId() == null;
            }
            case 126: {
                return pSDEDataViewBase.getQuickPSDEToolbarName() == null;
            }
            case 127: {
                return pSDEDataViewBase.getRemovePSDEActionId() == null;
            }
            case 128: {
                return pSDEDataViewBase.getRemovePSDEActionName() == null;
            }
            case 129: {
                return pSDEDataViewBase.getSRFSysPub() == null;
            }
            case 130: {
                return pSDEDataViewBase.getSwimlanePSCodeListId() == null;
            }
            case 131: {
                return pSDEDataViewBase.getSwimlanePSCodeListName() == null;
            }
            case 132: {
                return pSDEDataViewBase.getSwimlanePSDEFId() == null;
            }
            case 133: {
                return pSDEDataViewBase.getSwimlanePSDEFName() == null;
            }
            case 134: {
                return pSDEDataViewBase.getToDoTask() == null;
            }
            case 135: {
                return pSDEDataViewBase.getUpdateDate() == null;
            }
            case 136: {
                return pSDEDataViewBase.getUpdateMan() == null;
            }
            case 137: {
                return pSDEDataViewBase.getUpdatePSDEActionId() == null;
            }
            case 138: {
                return pSDEDataViewBase.getUpdatePSDEActionName() == null;
            }
            case 139: {
                return pSDEDataViewBase.getUser2PSDEActionId() == null;
            }
            case 140: {
                return pSDEDataViewBase.getUser2PSDEActionName() == null;
            }
            case 141: {
                return pSDEDataViewBase.getUserPSDEActionId() == null;
            }
            case 142: {
                return pSDEDataViewBase.getUserPSDEActionName() == null;
            }
            case 143: {
                return pSDEDataViewBase.getViewModel() == null;
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
        return PSDEDataViewBase.contains(this, n);
    }

    private static boolean contains(PSDEDataViewBase pSDEDataViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataViewBase.isAppendDEItemsDirty();
            }
            case 1: {
                return pSDEDataViewBase.isAsyncPSDEDSIdDirty();
            }
            case 2: {
                return pSDEDataViewBase.isAsyncPSDEDSNameDirty();
            }
            case 3: {
                return pSDEDataViewBase.isBatPSDEToolbarIdDirty();
            }
            case 4: {
                return pSDEDataViewBase.isBatPSDEToolbarNameDirty();
            }
            case 5: {
                return pSDEDataViewBase.isBusyIndicatorDirty();
            }
            case 6: {
                return pSDEDataViewBase.isCardHeightDirty();
            }
            case 7: {
                return pSDEDataViewBase.isCardWidthDirty();
            }
            case 8: {
                return pSDEDataViewBase.isCard_Col_LGDirty();
            }
            case 9: {
                return pSDEDataViewBase.isCard_Col_MDDirty();
            }
            case 10: {
                return pSDEDataViewBase.isCard_Col_SMDirty();
            }
            case 11: {
                return pSDEDataViewBase.isCard_Col_XSDirty();
            }
            case 12: {
                return pSDEDataViewBase.isCodeNameDirty();
            }
            case 13: {
                return pSDEDataViewBase.isCopyPSDEActionIdDirty();
            }
            case 14: {
                return pSDEDataViewBase.isCopyPSDEActionNameDirty();
            }
            case 15: {
                return pSDEDataViewBase.isCreateDateDirty();
            }
            case 16: {
                return pSDEDataViewBase.isCreateManDirty();
            }
            case 17: {
                return pSDEDataViewBase.isCreatePSDEActionIdDirty();
            }
            case 18: {
                return pSDEDataViewBase.isCreatePSDEActionNameDirty();
            }
            case 19: {
                return pSDEDataViewBase.isCustomCondDirty();
            }
            case 20: {
                return pSDEDataViewBase.isCustomTypeDirty();
            }
            case 21: {
                return pSDEDataViewBase.isDataViewSNDirty();
            }
            case 22: {
                return pSDEDataViewBase.isDataViewStyleDirty();
            }
            case 23: {
                return pSDEDataViewBase.isDVTagDirty();
            }
            case 24: {
                return pSDEDataViewBase.isDVTag2Dirty();
            }
            case 25: {
                return pSDEDataViewBase.isDVTag3Dirty();
            }
            case 26: {
                return pSDEDataViewBase.isDVTag4Dirty();
            }
            case 27: {
                return pSDEDataViewBase.isDynaModelFlagDirty();
            }
            case 28: {
                return pSDEDataViewBase.isEmptyTextDirty();
            }
            case 29: {
                return pSDEDataViewBase.isEmptyTextPSLanResIdDirty();
            }
            case 30: {
                return pSDEDataViewBase.isEmptyTextPSLanResNameDirty();
            }
            case 31: {
                return pSDEDataViewBase.isEnableEditDirty();
            }
            case 32: {
                return pSDEDataViewBase.isEnableItemPrivDirty();
            }
            case 33: {
                return pSDEDataViewBase.isEnablePagingBarDirty();
            }
            case 34: {
                return pSDEDataViewBase.isGetDraftPSDEActionIdDirty();
            }
            case 35: {
                return pSDEDataViewBase.isGetDraftPSDEActionNameDirty();
            }
            case 36: {
                return pSDEDataViewBase.isGetPSDEActionIdDirty();
            }
            case 37: {
                return pSDEDataViewBase.isGetPSDEActionNameDirty();
            }
            case 38: {
                return pSDEDataViewBase.isGroupBarCloseModeDirty();
            }
            case 39: {
                return pSDEDataViewBase.isGroupHeightDirty();
            }
            case 40: {
                return pSDEDataViewBase.isGroupLayoutDirty();
            }
            case 41: {
                return pSDEDataViewBase.isGroupModeDirty();
            }
            case 42: {
                return pSDEDataViewBase.isGroupMovePSDEActionIdDirty();
            }
            case 43: {
                return pSDEDataViewBase.isGroupMovePSDEActionNameDirty();
            }
            case 44: {
                return pSDEDataViewBase.isGroupPSCodeListIdDirty();
            }
            case 45: {
                return pSDEDataViewBase.isGroupPSCodeListNameDirty();
            }
            case 46: {
                return pSDEDataViewBase.isGroupPSDEFIdDirty();
            }
            case 47: {
                return pSDEDataViewBase.isGroupPSDEFNameDirty();
            }
            case 48: {
                return pSDEDataViewBase.isGroupPSDEIdDirty();
            }
            case 49: {
                return pSDEDataViewBase.isGroupPSDENameDirty();
            }
            case 50: {
                return pSDEDataViewBase.isGroupPSDEUAGroupIdDirty();
            }
            case 51: {
                return pSDEDataViewBase.isGroupPSDEUAGroupNameDirty();
            }
            case 52: {
                return pSDEDataViewBase.isGroupPSSysCssIdDirty();
            }
            case 53: {
                return pSDEDataViewBase.isGroupPSSysCssNameDirty();
            }
            case 54: {
                return pSDEDataViewBase.isGroupPSSysPFPluginIdDirty();
            }
            case 55: {
                return pSDEDataViewBase.isGroupPSSysPFPluginNameDirty();
            }
            case 56: {
                return pSDEDataViewBase.isGroupQuickPSDETBIdDirty();
            }
            case 57: {
                return pSDEDataViewBase.isGroupQuickPSDETBNameDirty();
            }
            case 58: {
                return pSDEDataViewBase.isGroupStyleDirty();
            }
            case 59: {
                return pSDEDataViewBase.isGroupTextPSDEFIdDirty();
            }
            case 60: {
                return pSDEDataViewBase.isGroupTextPSDEFNameDirty();
            }
            case 61: {
                return pSDEDataViewBase.isGroupWidthDirty();
            }
            case 62: {
                return pSDEDataViewBase.isGroup_Col_LGDirty();
            }
            case 63: {
                return pSDEDataViewBase.isGroup_Col_MDDirty();
            }
            case 64: {
                return pSDEDataViewBase.isGroup_Col_SMDirty();
            }
            case 65: {
                return pSDEDataViewBase.isGroup_Col_XSDirty();
            }
            case 66: {
                return pSDEDataViewBase.isItemPSSysCssIdDirty();
            }
            case 67: {
                return pSDEDataViewBase.isItemPSSysCssNameDirty();
            }
            case 68: {
                return pSDEDataViewBase.isItemPSSysPFPluginIdDirty();
            }
            case 69: {
                return pSDEDataViewBase.isItemPSSysPFPluginNameDirty();
            }
            case 70: {
                return pSDEDataViewBase.isKanbanFlagDirty();
            }
            case 71: {
                return pSDEDataViewBase.isLayoutItemTypeDirty();
            }
            case 72: {
                return pSDEDataViewBase.isLockFlagDirty();
            }
            case 73: {
                return pSDEDataViewBase.isMemoDirty();
            }
            case 74: {
                return pSDEDataViewBase.isMinorSortDirDirty();
            }
            case 75: {
                return pSDEDataViewBase.isMinorSortPSDEFIdDirty();
            }
            case 76: {
                return pSDEDataViewBase.isMinorSortPSDEFNameDirty();
            }
            case 77: {
                return pSDEDataViewBase.isMovePSDEActionIdDirty();
            }
            case 78: {
                return pSDEDataViewBase.isMovePSDEActionNameDirty();
            }
            case 79: {
                return pSDEDataViewBase.isMultiSelectDirty();
            }
            case 80: {
                return pSDEDataViewBase.isNavPSDERIdDirty();
            }
            case 81: {
                return pSDEDataViewBase.isNavPSDERNameDirty();
            }
            case 82: {
                return pSDEDataViewBase.isNavPSDEViewBaseIdDirty();
            }
            case 83: {
                return pSDEDataViewBase.isNavPSDEViewBaseNameDirty();
            }
            case 84: {
                return pSDEDataViewBase.isNavViewFilterDirty();
            }
            case 85: {
                return pSDEDataViewBase.isNavViewHeightDirty();
            }
            case 86: {
                return pSDEDataViewBase.isNavViewMaxHeightDirty();
            }
            case 87: {
                return pSDEDataViewBase.isNavViewMaxWidthDirty();
            }
            case 88: {
                return pSDEDataViewBase.isNavViewMinHeightDirty();
            }
            case 89: {
                return pSDEDataViewBase.isNavViewMinWidthDirty();
            }
            case 90: {
                return pSDEDataViewBase.isNavViewParamDirty();
            }
            case 91: {
                return pSDEDataViewBase.isNavViewPosDirty();
            }
            case 92: {
                return pSDEDataViewBase.isNavViewShowModeDirty();
            }
            case 93: {
                return pSDEDataViewBase.isNavViewWidthDirty();
            }
            case 94: {
                return pSDEDataViewBase.isNo2PSDEUAGroupIdDirty();
            }
            case 95: {
                return pSDEDataViewBase.isNo2PSDEUAGroupNameDirty();
            }
            case 96: {
                return pSDEDataViewBase.isNoSortDirty();
            }
            case 97: {
                return pSDEDataViewBase.isOrderValuePSDEFIdDirty();
            }
            case 98: {
                return pSDEDataViewBase.isOrderValuePSDEFNameDirty();
            }
            case 99: {
                return pSDEDataViewBase.isPagingSizeDirty();
            }
            case 100: {
                return pSDEDataViewBase.isPSACHandlerIdDirty();
            }
            case 101: {
                return pSDEDataViewBase.isPSACHandlerNameDirty();
            }
            case 102: {
                return pSDEDataViewBase.isPSCtrlLogicGroupIdDirty();
            }
            case 103: {
                return pSDEDataViewBase.isPSCtrlLogicGroupNameDirty();
            }
            case 104: {
                return pSDEDataViewBase.isPSCtrlMsgIdDirty();
            }
            case 105: {
                return pSDEDataViewBase.isPSCtrlMsgNameDirty();
            }
            case 106: {
                return pSDEDataViewBase.isPSDEDataSetIdDirty();
            }
            case 107: {
                return pSDEDataViewBase.isPSDEDataSetNameDirty();
            }
            case 108: {
                return pSDEDataViewBase.isPSDEDataViewIdDirty();
            }
            case 109: {
                return pSDEDataViewBase.isPSDEDataViewNameDirty();
            }
            case 110: {
                return pSDEDataViewBase.isPSDEFormIdDirty();
            }
            case 111: {
                return pSDEDataViewBase.isPSDEFormNameDirty();
            }
            case 112: {
                return pSDEDataViewBase.isPSDEIdDirty();
            }
            case 113: {
                return pSDEDataViewBase.isPSDENameDirty();
            }
            case 114: {
                return pSDEDataViewBase.isPSDEUAGroupIdDirty();
            }
            case 115: {
                return pSDEDataViewBase.isPSDEUAGroupNameDirty();
            }
            case 116: {
                return pSDEDataViewBase.isPSDynaInstIdDirty();
            }
            case 117: {
                return pSDEDataViewBase.isPSSysCssIdDirty();
            }
            case 118: {
                return pSDEDataViewBase.isPSSysCssNameDirty();
            }
            case 119: {
                return pSDEDataViewBase.isPSSysPFPluginIdDirty();
            }
            case 120: {
                return pSDEDataViewBase.isPSSysPFPluginNameDirty();
            }
            case 121: {
                return pSDEDataViewBase.isPSSysViewPanelIdDirty();
            }
            case 122: {
                return pSDEDataViewBase.isPSSysViewPanelNameDirty();
            }
            case 123: {
                return pSDEDataViewBase.isPSViewMsgGroupIdDirty();
            }
            case 124: {
                return pSDEDataViewBase.isPSViewMsgGroupNameDirty();
            }
            case 125: {
                return pSDEDataViewBase.isQuickPSDEToolbarIdDirty();
            }
            case 126: {
                return pSDEDataViewBase.isQuickPSDEToolbarNameDirty();
            }
            case 127: {
                return pSDEDataViewBase.isRemovePSDEActionIdDirty();
            }
            case 128: {
                return pSDEDataViewBase.isRemovePSDEActionNameDirty();
            }
            case 129: {
                return pSDEDataViewBase.isSRFSysPubDirty();
            }
            case 130: {
                return pSDEDataViewBase.isSwimlanePSCodeListIdDirty();
            }
            case 131: {
                return pSDEDataViewBase.isSwimlanePSCodeListNameDirty();
            }
            case 132: {
                return pSDEDataViewBase.isSwimlanePSDEFIdDirty();
            }
            case 133: {
                return pSDEDataViewBase.isSwimlanePSDEFNameDirty();
            }
            case 134: {
                return pSDEDataViewBase.isToDoTaskDirty();
            }
            case 135: {
                return pSDEDataViewBase.isUpdateDateDirty();
            }
            case 136: {
                return pSDEDataViewBase.isUpdateManDirty();
            }
            case 137: {
                return pSDEDataViewBase.isUpdatePSDEActionIdDirty();
            }
            case 138: {
                return pSDEDataViewBase.isUpdatePSDEActionNameDirty();
            }
            case 139: {
                return pSDEDataViewBase.isUser2PSDEActionIdDirty();
            }
            case 140: {
                return pSDEDataViewBase.isUser2PSDEActionNameDirty();
            }
            case 141: {
                return pSDEDataViewBase.isUserPSDEActionIdDirty();
            }
            case 142: {
                return pSDEDataViewBase.isUserPSDEActionNameDirty();
            }
            case 143: {
                return pSDEDataViewBase.isViewModelDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataViewBase pSDEDataViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataViewBase.getAppendDEItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appenddeitems", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getAppendDEItems()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getAsyncPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getAsyncPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getAsyncPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"asyncpsdedsname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getAsyncPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getBatPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getBatPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getBatPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"batpsdetoolbarname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getBatPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCardHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cardheight", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCardHeight()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCardWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cardwidth", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCardWidth()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCard_Col_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"card_col_lg", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCard_Col_LG()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCard_Col_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"card_col_md", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCard_Col_MD()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCard_Col_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"card_col_sm", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCard_Col_SM()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCard_Col_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"card_col_xs", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCard_Col_XS()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCopyPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCopyPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCopyPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"copypsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCopyPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCreatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCreatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCreatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCreatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDataViewSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataviewsn", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDataViewSN()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDataViewStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataviewstyle", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDataViewStyle()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDVTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvtag", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDVTag()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDVTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvtag2", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDVTag2()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDVTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvtag3", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDVTag3()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDVTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvtag4", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDVTag4()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEnableEdit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableedit", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEnableEdit()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getEnablePagingBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepagingbar", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getEnablePagingBar()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGetDraftPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGetDraftPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGetDraftPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdraftpsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGetDraftPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGetPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGetPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGetPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getpsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGetPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupbarclosemode", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupBarCloseMode()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupheight", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupHeight()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupLayout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouplayout", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupLayout()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmode", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupMode()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupmovepsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdefname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdename", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppsdeuagroupname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyscssname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppssyspfpluginname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupQuickPSDETBId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupquickpsdetbid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupQuickPSDETBId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupQuickPSDETBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupquickpsdetbname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupQuickPSDETBName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupstyle", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupStyle()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupTextPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptextpsdefname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupTextPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroupWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupwidth", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroupWidth()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroup_Col_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"group_col_lg", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroup_Col_LG()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroup_Col_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"group_col_md", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroup_Col_MD()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroup_Col_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"group_col_sm", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroup_Col_SM()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getGroup_Col_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"group_col_xs", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getGroup_Col_XS()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getItemPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getItemPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getItemPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyscssname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getItemPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getItemPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyspfpluginid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getItemPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getItemPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempssyspfpluginname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getItemPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getKanbanFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"kanbanflag", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getKanbanFlag()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getLayoutItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutitemtype", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getLayoutItemType()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"movepsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getMultiSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multiselect", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getMultiSelect()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsderid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavPSDERId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdername", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavPSDERName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbaseid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navpsdeviewbasename", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewfilter", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewFilter()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewheight", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewHeight()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewMaxHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxheight", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewMaxHeight()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewMaxWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewmaxwidth", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewMaxWidth()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewMinHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminheight", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewMinHeight()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewMinWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewminwidth", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewMinWidth()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewparam", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewParam()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewpos", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewPos()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewshowmode", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewShowMode()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNavViewWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"navviewwidth", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNavViewWidth()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNo2PSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNo2PSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNo2PSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psdeuagroupname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNo2PSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getOrderValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getOrderValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getOrderValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervaluepsdefname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getOrderValuePSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPagingSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagingsize", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPagingSize()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getQuickPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getQuickPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getQuickPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdetoolbarname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getQuickPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getRemovePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getRemovePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getRemovePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removepsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getRemovePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepscodelistid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getSwimlanePSCodeListId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepscodelistname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getSwimlanePSCodeListName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepsdefid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getSwimlanePSDEFId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swimlanepsdefname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getSwimlanePSDEFName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUpdatePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUpdatePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUpdatePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatepsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUpdatePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUser2PSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUser2PSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUser2PSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUser2PSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUserPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionid", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUserPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getUserPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdeactionname", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getUserPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataViewBase.getViewModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmodel", (Object)PSDEDataViewBase.getJSONValue((Object)pSDEDataViewBase.getViewModel()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataViewBase pSDEDataViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataViewBase.getAppendDEItems() != null) {
            object = pSDEDataViewBase.getAppendDEItems();
            xmlNode.setAttribute(FIELD_APPENDDEITEMS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getAsyncPSDEDSId() != null) {
            object = pSDEDataViewBase.getAsyncPSDEDSId();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getAsyncPSDEDSName() != null) {
            object = pSDEDataViewBase.getAsyncPSDEDSName();
            xmlNode.setAttribute(FIELD_ASYNCPSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getBatPSDEToolbarId() != null) {
            object = pSDEDataViewBase.getBatPSDEToolbarId();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getBatPSDEToolbarName() != null) {
            object = pSDEDataViewBase.getBatPSDEToolbarName();
            xmlNode.setAttribute(FIELD_BATPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getBusyIndicator() != null) {
            object = pSDEDataViewBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCardHeight() != null) {
            object = pSDEDataViewBase.getCardHeight();
            xmlNode.setAttribute(FIELD_CARDHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCardWidth() != null) {
            object = pSDEDataViewBase.getCardWidth();
            xmlNode.setAttribute(FIELD_CARDWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCard_Col_LG() != null) {
            object = pSDEDataViewBase.getCard_Col_LG();
            xmlNode.setAttribute(FIELD_CARD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCard_Col_MD() != null) {
            object = pSDEDataViewBase.getCard_Col_MD();
            xmlNode.setAttribute(FIELD_CARD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCard_Col_SM() != null) {
            object = pSDEDataViewBase.getCard_Col_SM();
            xmlNode.setAttribute(FIELD_CARD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCard_Col_XS() != null) {
            object = pSDEDataViewBase.getCard_Col_XS();
            xmlNode.setAttribute(FIELD_CARD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCodeName() != null) {
            object = pSDEDataViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCopyPSDEActionId() != null) {
            object = pSDEDataViewBase.getCopyPSDEActionId();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCopyPSDEActionName() != null) {
            object = pSDEDataViewBase.getCopyPSDEActionName();
            xmlNode.setAttribute(FIELD_COPYPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCreateDate() != null) {
            object = pSDEDataViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataViewBase.getCreateMan() != null) {
            object = pSDEDataViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCreatePSDEActionId() != null) {
            object = pSDEDataViewBase.getCreatePSDEActionId();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCreatePSDEActionName() != null) {
            object = pSDEDataViewBase.getCreatePSDEActionName();
            xmlNode.setAttribute(FIELD_CREATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCustomCond() != null) {
            object = pSDEDataViewBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getCustomType() != null) {
            object = pSDEDataViewBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDataViewSN() != null) {
            object = pSDEDataViewBase.getDataViewSN();
            xmlNode.setAttribute(FIELD_DATAVIEWSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDataViewStyle() != null) {
            object = pSDEDataViewBase.getDataViewStyle();
            xmlNode.setAttribute(FIELD_DATAVIEWSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDVTag() != null) {
            object = pSDEDataViewBase.getDVTag();
            xmlNode.setAttribute(FIELD_DVTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDVTag2() != null) {
            object = pSDEDataViewBase.getDVTag2();
            xmlNode.setAttribute(FIELD_DVTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDVTag3() != null) {
            object = pSDEDataViewBase.getDVTag3();
            xmlNode.setAttribute(FIELD_DVTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDVTag4() != null) {
            object = pSDEDataViewBase.getDVTag4();
            xmlNode.setAttribute(FIELD_DVTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getDynaModelFlag() != null) {
            object = pSDEDataViewBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getEmptyText() != null) {
            object = pSDEDataViewBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getEmptyTextPSLanResId() != null) {
            object = pSDEDataViewBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getEmptyTextPSLanResName() != null) {
            object = pSDEDataViewBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getEnableEdit() != null) {
            object = pSDEDataViewBase.getEnableEdit();
            xmlNode.setAttribute(FIELD_ENABLEEDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getEnableItemPriv() != null) {
            object = pSDEDataViewBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getEnablePagingBar() != null) {
            object = pSDEDataViewBase.getEnablePagingBar();
            xmlNode.setAttribute(FIELD_ENABLEPAGINGBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGetDraftPSDEActionId() != null) {
            object = pSDEDataViewBase.getGetDraftPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGetDraftPSDEActionName() != null) {
            object = pSDEDataViewBase.getGetDraftPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDRAFTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGetPSDEActionId() != null) {
            object = pSDEDataViewBase.getGetPSDEActionId();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGetPSDEActionName() != null) {
            object = pSDEDataViewBase.getGetPSDEActionName();
            xmlNode.setAttribute(FIELD_GETPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupBarCloseMode() != null) {
            object = pSDEDataViewBase.getGroupBarCloseMode();
            xmlNode.setAttribute(FIELD_GROUPBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroupHeight() != null) {
            object = pSDEDataViewBase.getGroupHeight();
            xmlNode.setAttribute(FIELD_GROUPHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroupLayout() != null) {
            object = pSDEDataViewBase.getGroupLayout();
            xmlNode.setAttribute(FIELD_GROUPLAYOUT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupMode() != null) {
            object = pSDEDataViewBase.getGroupMode();
            xmlNode.setAttribute(FIELD_GROUPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupMovePSDEActionId() != null) {
            object = pSDEDataViewBase.getGroupMovePSDEActionId();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupMovePSDEActionName() != null) {
            object = pSDEDataViewBase.getGroupMovePSDEActionName();
            xmlNode.setAttribute(FIELD_GROUPMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSCodeListId() != null) {
            object = pSDEDataViewBase.getGroupPSCodeListId();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSCodeListName() != null) {
            object = pSDEDataViewBase.getGroupPSCodeListName();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEFId() != null) {
            object = pSDEDataViewBase.getGroupPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEFName() != null) {
            object = pSDEDataViewBase.getGroupPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEId() != null) {
            object = pSDEDataViewBase.getGroupPSDEId();
            xmlNode.setAttribute(FIELD_GROUPPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEName() != null) {
            object = pSDEDataViewBase.getGroupPSDEName();
            xmlNode.setAttribute(FIELD_GROUPPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEUAGroupId() != null) {
            object = pSDEDataViewBase.getGroupPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSDEUAGroupName() != null) {
            object = pSDEDataViewBase.getGroupPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_GROUPPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysCssId() != null) {
            object = pSDEDataViewBase.getGroupPSSysCssId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysCssName() != null) {
            object = pSDEDataViewBase.getGroupPSSysCssName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysPFPluginId() != null) {
            object = pSDEDataViewBase.getGroupPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupPSSysPFPluginName() != null) {
            object = pSDEDataViewBase.getGroupPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GROUPPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupQuickPSDETBId() != null) {
            object = pSDEDataViewBase.getGroupQuickPSDETBId();
            xmlNode.setAttribute(FIELD_GROUPQUICKPSDETBID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupQuickPSDETBName() != null) {
            object = pSDEDataViewBase.getGroupQuickPSDETBName();
            xmlNode.setAttribute(FIELD_GROUPQUICKPSDETBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupStyle() != null) {
            object = pSDEDataViewBase.getGroupStyle();
            xmlNode.setAttribute(FIELD_GROUPSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupTextPSDEFId() != null) {
            object = pSDEDataViewBase.getGroupTextPSDEFId();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupTextPSDEFName() != null) {
            object = pSDEDataViewBase.getGroupTextPSDEFName();
            xmlNode.setAttribute(FIELD_GROUPTEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getGroupWidth() != null) {
            object = pSDEDataViewBase.getGroupWidth();
            xmlNode.setAttribute(FIELD_GROUPWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroup_Col_LG() != null) {
            object = pSDEDataViewBase.getGroup_Col_LG();
            xmlNode.setAttribute(FIELD_GROUP_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroup_Col_MD() != null) {
            object = pSDEDataViewBase.getGroup_Col_MD();
            xmlNode.setAttribute(FIELD_GROUP_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroup_Col_SM() != null) {
            object = pSDEDataViewBase.getGroup_Col_SM();
            xmlNode.setAttribute(FIELD_GROUP_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getGroup_Col_XS() != null) {
            object = pSDEDataViewBase.getGroup_Col_XS();
            xmlNode.setAttribute(FIELD_GROUP_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getItemPSSysCssId() != null) {
            object = pSDEDataViewBase.getItemPSSysCssId();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getItemPSSysCssName() != null) {
            object = pSDEDataViewBase.getItemPSSysCssName();
            xmlNode.setAttribute(FIELD_ITEMPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getItemPSSysPFPluginId() != null) {
            object = pSDEDataViewBase.getItemPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_ITEMPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getItemPSSysPFPluginName() != null) {
            object = pSDEDataViewBase.getItemPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_ITEMPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getKanbanFlag() != null) {
            object = pSDEDataViewBase.getKanbanFlag();
            xmlNode.setAttribute(FIELD_KANBANFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getLayoutItemType() != null) {
            object = pSDEDataViewBase.getLayoutItemType();
            xmlNode.setAttribute(FIELD_LAYOUTITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getLockFlag() != null) {
            object = pSDEDataViewBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getMemo() != null) {
            object = pSDEDataViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMinorSortDir() != null) {
            object = pSDEDataViewBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMinorSortPSDEFId() != null) {
            object = pSDEDataViewBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMinorSortPSDEFName() != null) {
            object = pSDEDataViewBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMovePSDEActionId() != null) {
            object = pSDEDataViewBase.getMovePSDEActionId();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMovePSDEActionName() != null) {
            object = pSDEDataViewBase.getMovePSDEActionName();
            xmlNode.setAttribute(FIELD_MOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getMultiSelect() != null) {
            object = pSDEDataViewBase.getMultiSelect();
            xmlNode.setAttribute(FIELD_MULTISELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavPSDERId() != null) {
            object = pSDEDataViewBase.getNavPSDERId();
            xmlNode.setAttribute(FIELD_NAVPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavPSDERName() != null) {
            object = pSDEDataViewBase.getNavPSDERName();
            xmlNode.setAttribute(FIELD_NAVPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavPSDEViewBaseId() != null) {
            object = pSDEDataViewBase.getNavPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavPSDEViewBaseName() != null) {
            object = pSDEDataViewBase.getNavPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_NAVPSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavViewFilter() != null) {
            object = pSDEDataViewBase.getNavViewFilter();
            xmlNode.setAttribute(FIELD_NAVVIEWFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavViewHeight() != null) {
            object = pSDEDataViewBase.getNavViewHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewMaxHeight() != null) {
            object = pSDEDataViewBase.getNavViewMaxHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewMaxWidth() != null) {
            object = pSDEDataViewBase.getNavViewMaxWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMAXWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewMinHeight() != null) {
            object = pSDEDataViewBase.getNavViewMinHeight();
            xmlNode.setAttribute(FIELD_NAVVIEWMINHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewMinWidth() != null) {
            object = pSDEDataViewBase.getNavViewMinWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWMINWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewParam() != null) {
            object = pSDEDataViewBase.getNavViewParam();
            xmlNode.setAttribute(FIELD_NAVVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavViewPos() != null) {
            object = pSDEDataViewBase.getNavViewPos();
            xmlNode.setAttribute(FIELD_NAVVIEWPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNavViewShowMode() != null) {
            object = pSDEDataViewBase.getNavViewShowMode();
            xmlNode.setAttribute(FIELD_NAVVIEWSHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNavViewWidth() != null) {
            object = pSDEDataViewBase.getNavViewWidth();
            xmlNode.setAttribute(FIELD_NAVVIEWWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getNo2PSDEUAGroupId() != null) {
            object = pSDEDataViewBase.getNo2PSDEUAGroupId();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNo2PSDEUAGroupName() != null) {
            object = pSDEDataViewBase.getNo2PSDEUAGroupName();
            xmlNode.setAttribute(FIELD_NO2PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getNoSort() != null) {
            object = pSDEDataViewBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getOrderValuePSDEFId() != null) {
            object = pSDEDataViewBase.getOrderValuePSDEFId();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getOrderValuePSDEFName() != null) {
            object = pSDEDataViewBase.getOrderValuePSDEFName();
            xmlNode.setAttribute(FIELD_ORDERVALUEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPagingSize() != null) {
            object = pSDEDataViewBase.getPagingSize();
            xmlNode.setAttribute(FIELD_PAGINGSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getPSACHandlerId() != null) {
            object = pSDEDataViewBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSACHandlerName() != null) {
            object = pSDEDataViewBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEDataViewBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEDataViewBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSCtrlMsgId() != null) {
            object = pSDEDataViewBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSCtrlMsgName() != null) {
            object = pSDEDataViewBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEDataSetId() != null) {
            object = pSDEDataViewBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEDataSetName() != null) {
            object = pSDEDataViewBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEDataViewId() != null) {
            object = pSDEDataViewBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEDataViewName() != null) {
            object = pSDEDataViewBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEFormId() != null) {
            object = pSDEDataViewBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEFormName() != null) {
            object = pSDEDataViewBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEId() != null) {
            object = pSDEDataViewBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEName() != null) {
            object = pSDEDataViewBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEUAGroupId() != null) {
            object = pSDEDataViewBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDEUAGroupName() != null) {
            object = pSDEDataViewBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSDynaInstId() != null) {
            object = pSDEDataViewBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysCssId() != null) {
            object = pSDEDataViewBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysCssName() != null) {
            object = pSDEDataViewBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysPFPluginId() != null) {
            object = pSDEDataViewBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysPFPluginName() != null) {
            object = pSDEDataViewBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysViewPanelId() != null) {
            object = pSDEDataViewBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSSysViewPanelName() != null) {
            object = pSDEDataViewBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSViewMsgGroupId() != null) {
            object = pSDEDataViewBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getPSViewMsgGroupName() != null) {
            object = pSDEDataViewBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getQuickPSDEToolbarId() != null) {
            object = pSDEDataViewBase.getQuickPSDEToolbarId();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getQuickPSDEToolbarName() != null) {
            object = pSDEDataViewBase.getQuickPSDEToolbarName();
            xmlNode.setAttribute(FIELD_QUICKPSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getRemovePSDEActionId() != null) {
            object = pSDEDataViewBase.getRemovePSDEActionId();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getRemovePSDEActionName() != null) {
            object = pSDEDataViewBase.getRemovePSDEActionName();
            xmlNode.setAttribute(FIELD_REMOVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getSRFSysPub() != null) {
            object = pSDEDataViewBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataViewBase.getSwimlanePSCodeListId() != null) {
            object = pSDEDataViewBase.getSwimlanePSCodeListId();
            xmlNode.setAttribute(FIELD_SWIMLANEPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSCodeListName() != null) {
            object = pSDEDataViewBase.getSwimlanePSCodeListName();
            xmlNode.setAttribute(FIELD_SWIMLANEPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSDEFId() != null) {
            object = pSDEDataViewBase.getSwimlanePSDEFId();
            xmlNode.setAttribute(FIELD_SWIMLANEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getSwimlanePSDEFName() != null) {
            object = pSDEDataViewBase.getSwimlanePSDEFName();
            xmlNode.setAttribute(FIELD_SWIMLANEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getToDoTask() != null) {
            object = pSDEDataViewBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUpdateDate() != null) {
            object = pSDEDataViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataViewBase.getUpdateMan() != null) {
            object = pSDEDataViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUpdatePSDEActionId() != null) {
            object = pSDEDataViewBase.getUpdatePSDEActionId();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUpdatePSDEActionName() != null) {
            object = pSDEDataViewBase.getUpdatePSDEActionName();
            xmlNode.setAttribute(FIELD_UPDATEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUser2PSDEActionId() != null) {
            object = pSDEDataViewBase.getUser2PSDEActionId();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUser2PSDEActionName() != null) {
            object = pSDEDataViewBase.getUser2PSDEActionName();
            xmlNode.setAttribute(FIELD_USER2PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUserPSDEActionId() != null) {
            object = pSDEDataViewBase.getUserPSDEActionId();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getUserPSDEActionName() != null) {
            object = pSDEDataViewBase.getUserPSDEActionName();
            xmlNode.setAttribute(FIELD_USERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataViewBase.getViewModel() != null) {
            object = pSDEDataViewBase.getViewModel();
            xmlNode.setAttribute(FIELD_VIEWMODEL, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataViewBase pSDEDataViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataViewBase.isAppendDEItemsDirty() && (bl || pSDEDataViewBase.getAppendDEItems() != null)) {
            iDataObject.set(FIELD_APPENDDEITEMS, (Object)pSDEDataViewBase.getAppendDEItems());
        }
        if (pSDEDataViewBase.isAsyncPSDEDSIdDirty() && (bl || pSDEDataViewBase.getAsyncPSDEDSId() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSID, (Object)pSDEDataViewBase.getAsyncPSDEDSId());
        }
        if (pSDEDataViewBase.isAsyncPSDEDSNameDirty() && (bl || pSDEDataViewBase.getAsyncPSDEDSName() != null)) {
            iDataObject.set(FIELD_ASYNCPSDEDSNAME, (Object)pSDEDataViewBase.getAsyncPSDEDSName());
        }
        if (pSDEDataViewBase.isBatPSDEToolbarIdDirty() && (bl || pSDEDataViewBase.getBatPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARID, (Object)pSDEDataViewBase.getBatPSDEToolbarId());
        }
        if (pSDEDataViewBase.isBatPSDEToolbarNameDirty() && (bl || pSDEDataViewBase.getBatPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_BATPSDETOOLBARNAME, (Object)pSDEDataViewBase.getBatPSDEToolbarName());
        }
        if (pSDEDataViewBase.isBusyIndicatorDirty() && (bl || pSDEDataViewBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEDataViewBase.getBusyIndicator());
        }
        if (pSDEDataViewBase.isCardHeightDirty() && (bl || pSDEDataViewBase.getCardHeight() != null)) {
            iDataObject.set(FIELD_CARDHEIGHT, (Object)pSDEDataViewBase.getCardHeight());
        }
        if (pSDEDataViewBase.isCardWidthDirty() && (bl || pSDEDataViewBase.getCardWidth() != null)) {
            iDataObject.set(FIELD_CARDWIDTH, (Object)pSDEDataViewBase.getCardWidth());
        }
        if (pSDEDataViewBase.isCard_Col_LGDirty() && (bl || pSDEDataViewBase.getCard_Col_LG() != null)) {
            iDataObject.set(FIELD_CARD_COL_LG, (Object)pSDEDataViewBase.getCard_Col_LG());
        }
        if (pSDEDataViewBase.isCard_Col_MDDirty() && (bl || pSDEDataViewBase.getCard_Col_MD() != null)) {
            iDataObject.set(FIELD_CARD_COL_MD, (Object)pSDEDataViewBase.getCard_Col_MD());
        }
        if (pSDEDataViewBase.isCard_Col_SMDirty() && (bl || pSDEDataViewBase.getCard_Col_SM() != null)) {
            iDataObject.set(FIELD_CARD_COL_SM, (Object)pSDEDataViewBase.getCard_Col_SM());
        }
        if (pSDEDataViewBase.isCard_Col_XSDirty() && (bl || pSDEDataViewBase.getCard_Col_XS() != null)) {
            iDataObject.set(FIELD_CARD_COL_XS, (Object)pSDEDataViewBase.getCard_Col_XS());
        }
        if (pSDEDataViewBase.isCodeNameDirty() && (bl || pSDEDataViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataViewBase.getCodeName());
        }
        if (pSDEDataViewBase.isCopyPSDEActionIdDirty() && (bl || pSDEDataViewBase.getCopyPSDEActionId() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONID, (Object)pSDEDataViewBase.getCopyPSDEActionId());
        }
        if (pSDEDataViewBase.isCopyPSDEActionNameDirty() && (bl || pSDEDataViewBase.getCopyPSDEActionName() != null)) {
            iDataObject.set(FIELD_COPYPSDEACTIONNAME, (Object)pSDEDataViewBase.getCopyPSDEActionName());
        }
        if (pSDEDataViewBase.isCreateDateDirty() && (bl || pSDEDataViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataViewBase.getCreateDate());
        }
        if (pSDEDataViewBase.isCreateManDirty() && (bl || pSDEDataViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataViewBase.getCreateMan());
        }
        if (pSDEDataViewBase.isCreatePSDEActionIdDirty() && (bl || pSDEDataViewBase.getCreatePSDEActionId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONID, (Object)pSDEDataViewBase.getCreatePSDEActionId());
        }
        if (pSDEDataViewBase.isCreatePSDEActionNameDirty() && (bl || pSDEDataViewBase.getCreatePSDEActionName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEACTIONNAME, (Object)pSDEDataViewBase.getCreatePSDEActionName());
        }
        if (pSDEDataViewBase.isCustomCondDirty() && (bl || pSDEDataViewBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDEDataViewBase.getCustomCond());
        }
        if (pSDEDataViewBase.isCustomTypeDirty() && (bl || pSDEDataViewBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDEDataViewBase.getCustomType());
        }
        if (pSDEDataViewBase.isDataViewSNDirty() && (bl || pSDEDataViewBase.getDataViewSN() != null)) {
            iDataObject.set(FIELD_DATAVIEWSN, (Object)pSDEDataViewBase.getDataViewSN());
        }
        if (pSDEDataViewBase.isDataViewStyleDirty() && (bl || pSDEDataViewBase.getDataViewStyle() != null)) {
            iDataObject.set(FIELD_DATAVIEWSTYLE, (Object)pSDEDataViewBase.getDataViewStyle());
        }
        if (pSDEDataViewBase.isDVTagDirty() && (bl || pSDEDataViewBase.getDVTag() != null)) {
            iDataObject.set(FIELD_DVTAG, (Object)pSDEDataViewBase.getDVTag());
        }
        if (pSDEDataViewBase.isDVTag2Dirty() && (bl || pSDEDataViewBase.getDVTag2() != null)) {
            iDataObject.set(FIELD_DVTAG2, (Object)pSDEDataViewBase.getDVTag2());
        }
        if (pSDEDataViewBase.isDVTag3Dirty() && (bl || pSDEDataViewBase.getDVTag3() != null)) {
            iDataObject.set(FIELD_DVTAG3, (Object)pSDEDataViewBase.getDVTag3());
        }
        if (pSDEDataViewBase.isDVTag4Dirty() && (bl || pSDEDataViewBase.getDVTag4() != null)) {
            iDataObject.set(FIELD_DVTAG4, (Object)pSDEDataViewBase.getDVTag4());
        }
        if (pSDEDataViewBase.isDynaModelFlagDirty() && (bl || pSDEDataViewBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataViewBase.getDynaModelFlag());
        }
        if (pSDEDataViewBase.isEmptyTextDirty() && (bl || pSDEDataViewBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDEDataViewBase.getEmptyText());
        }
        if (pSDEDataViewBase.isEmptyTextPSLanResIdDirty() && (bl || pSDEDataViewBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDEDataViewBase.getEmptyTextPSLanResId());
        }
        if (pSDEDataViewBase.isEmptyTextPSLanResNameDirty() && (bl || pSDEDataViewBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDEDataViewBase.getEmptyTextPSLanResName());
        }
        if (pSDEDataViewBase.isEnableEditDirty() && (bl || pSDEDataViewBase.getEnableEdit() != null)) {
            iDataObject.set(FIELD_ENABLEEDIT, (Object)pSDEDataViewBase.getEnableEdit());
        }
        if (pSDEDataViewBase.isEnableItemPrivDirty() && (bl || pSDEDataViewBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEDataViewBase.getEnableItemPriv());
        }
        if (pSDEDataViewBase.isEnablePagingBarDirty() && (bl || pSDEDataViewBase.getEnablePagingBar() != null)) {
            iDataObject.set(FIELD_ENABLEPAGINGBAR, (Object)pSDEDataViewBase.getEnablePagingBar());
        }
        if (pSDEDataViewBase.isGetDraftPSDEActionIdDirty() && (bl || pSDEDataViewBase.getGetDraftPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONID, (Object)pSDEDataViewBase.getGetDraftPSDEActionId());
        }
        if (pSDEDataViewBase.isGetDraftPSDEActionNameDirty() && (bl || pSDEDataViewBase.getGetDraftPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDRAFTPSDEACTIONNAME, (Object)pSDEDataViewBase.getGetDraftPSDEActionName());
        }
        if (pSDEDataViewBase.isGetPSDEActionIdDirty() && (bl || pSDEDataViewBase.getGetPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONID, (Object)pSDEDataViewBase.getGetPSDEActionId());
        }
        if (pSDEDataViewBase.isGetPSDEActionNameDirty() && (bl || pSDEDataViewBase.getGetPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETPSDEACTIONNAME, (Object)pSDEDataViewBase.getGetPSDEActionName());
        }
        if (pSDEDataViewBase.isGroupBarCloseModeDirty() && (bl || pSDEDataViewBase.getGroupBarCloseMode() != null)) {
            iDataObject.set(FIELD_GROUPBARCLOSEMODE, (Object)pSDEDataViewBase.getGroupBarCloseMode());
        }
        if (pSDEDataViewBase.isGroupHeightDirty() && (bl || pSDEDataViewBase.getGroupHeight() != null)) {
            iDataObject.set(FIELD_GROUPHEIGHT, (Object)pSDEDataViewBase.getGroupHeight());
        }
        if (pSDEDataViewBase.isGroupLayoutDirty() && (bl || pSDEDataViewBase.getGroupLayout() != null)) {
            iDataObject.set(FIELD_GROUPLAYOUT, (Object)pSDEDataViewBase.getGroupLayout());
        }
        if (pSDEDataViewBase.isGroupModeDirty() && (bl || pSDEDataViewBase.getGroupMode() != null)) {
            iDataObject.set(FIELD_GROUPMODE, (Object)pSDEDataViewBase.getGroupMode());
        }
        if (pSDEDataViewBase.isGroupMovePSDEActionIdDirty() && (bl || pSDEDataViewBase.getGroupMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONID, (Object)pSDEDataViewBase.getGroupMovePSDEActionId());
        }
        if (pSDEDataViewBase.isGroupMovePSDEActionNameDirty() && (bl || pSDEDataViewBase.getGroupMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_GROUPMOVEPSDEACTIONNAME, (Object)pSDEDataViewBase.getGroupMovePSDEActionName());
        }
        if (pSDEDataViewBase.isGroupPSCodeListIdDirty() && (bl || pSDEDataViewBase.getGroupPSCodeListId() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTID, (Object)pSDEDataViewBase.getGroupPSCodeListId());
        }
        if (pSDEDataViewBase.isGroupPSCodeListNameDirty() && (bl || pSDEDataViewBase.getGroupPSCodeListName() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTNAME, (Object)pSDEDataViewBase.getGroupPSCodeListName());
        }
        if (pSDEDataViewBase.isGroupPSDEFIdDirty() && (bl || pSDEDataViewBase.getGroupPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFID, (Object)pSDEDataViewBase.getGroupPSDEFId());
        }
        if (pSDEDataViewBase.isGroupPSDEFNameDirty() && (bl || pSDEDataViewBase.getGroupPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEFNAME, (Object)pSDEDataViewBase.getGroupPSDEFName());
        }
        if (pSDEDataViewBase.isGroupPSDEIdDirty() && (bl || pSDEDataViewBase.getGroupPSDEId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEID, (Object)pSDEDataViewBase.getGroupPSDEId());
        }
        if (pSDEDataViewBase.isGroupPSDENameDirty() && (bl || pSDEDataViewBase.getGroupPSDEName() != null)) {
            iDataObject.set(FIELD_GROUPPSDENAME, (Object)pSDEDataViewBase.getGroupPSDEName());
        }
        if (pSDEDataViewBase.isGroupPSDEUAGroupIdDirty() && (bl || pSDEDataViewBase.getGroupPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPID, (Object)pSDEDataViewBase.getGroupPSDEUAGroupId());
        }
        if (pSDEDataViewBase.isGroupPSDEUAGroupNameDirty() && (bl || pSDEDataViewBase.getGroupPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_GROUPPSDEUAGROUPNAME, (Object)pSDEDataViewBase.getGroupPSDEUAGroupName());
        }
        if (pSDEDataViewBase.isGroupPSSysCssIdDirty() && (bl || pSDEDataViewBase.getGroupPSSysCssId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSID, (Object)pSDEDataViewBase.getGroupPSSysCssId());
        }
        if (pSDEDataViewBase.isGroupPSSysCssNameDirty() && (bl || pSDEDataViewBase.getGroupPSSysCssName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSCSSNAME, (Object)pSDEDataViewBase.getGroupPSSysCssName());
        }
        if (pSDEDataViewBase.isGroupPSSysPFPluginIdDirty() && (bl || pSDEDataViewBase.getGroupPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINID, (Object)pSDEDataViewBase.getGroupPSSysPFPluginId());
        }
        if (pSDEDataViewBase.isGroupPSSysPFPluginNameDirty() && (bl || pSDEDataViewBase.getGroupPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GROUPPSSYSPFPLUGINNAME, (Object)pSDEDataViewBase.getGroupPSSysPFPluginName());
        }
        if (pSDEDataViewBase.isGroupQuickPSDETBIdDirty() && (bl || pSDEDataViewBase.getGroupQuickPSDETBId() != null)) {
            iDataObject.set(FIELD_GROUPQUICKPSDETBID, (Object)pSDEDataViewBase.getGroupQuickPSDETBId());
        }
        if (pSDEDataViewBase.isGroupQuickPSDETBNameDirty() && (bl || pSDEDataViewBase.getGroupQuickPSDETBName() != null)) {
            iDataObject.set(FIELD_GROUPQUICKPSDETBNAME, (Object)pSDEDataViewBase.getGroupQuickPSDETBName());
        }
        if (pSDEDataViewBase.isGroupStyleDirty() && (bl || pSDEDataViewBase.getGroupStyle() != null)) {
            iDataObject.set(FIELD_GROUPSTYLE, (Object)pSDEDataViewBase.getGroupStyle());
        }
        if (pSDEDataViewBase.isGroupTextPSDEFIdDirty() && (bl || pSDEDataViewBase.getGroupTextPSDEFId() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFID, (Object)pSDEDataViewBase.getGroupTextPSDEFId());
        }
        if (pSDEDataViewBase.isGroupTextPSDEFNameDirty() && (bl || pSDEDataViewBase.getGroupTextPSDEFName() != null)) {
            iDataObject.set(FIELD_GROUPTEXTPSDEFNAME, (Object)pSDEDataViewBase.getGroupTextPSDEFName());
        }
        if (pSDEDataViewBase.isGroupWidthDirty() && (bl || pSDEDataViewBase.getGroupWidth() != null)) {
            iDataObject.set(FIELD_GROUPWIDTH, (Object)pSDEDataViewBase.getGroupWidth());
        }
        if (pSDEDataViewBase.isGroup_Col_LGDirty() && (bl || pSDEDataViewBase.getGroup_Col_LG() != null)) {
            iDataObject.set(FIELD_GROUP_COL_LG, (Object)pSDEDataViewBase.getGroup_Col_LG());
        }
        if (pSDEDataViewBase.isGroup_Col_MDDirty() && (bl || pSDEDataViewBase.getGroup_Col_MD() != null)) {
            iDataObject.set(FIELD_GROUP_COL_MD, (Object)pSDEDataViewBase.getGroup_Col_MD());
        }
        if (pSDEDataViewBase.isGroup_Col_SMDirty() && (bl || pSDEDataViewBase.getGroup_Col_SM() != null)) {
            iDataObject.set(FIELD_GROUP_COL_SM, (Object)pSDEDataViewBase.getGroup_Col_SM());
        }
        if (pSDEDataViewBase.isGroup_Col_XSDirty() && (bl || pSDEDataViewBase.getGroup_Col_XS() != null)) {
            iDataObject.set(FIELD_GROUP_COL_XS, (Object)pSDEDataViewBase.getGroup_Col_XS());
        }
        if (pSDEDataViewBase.isItemPSSysCssIdDirty() && (bl || pSDEDataViewBase.getItemPSSysCssId() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSID, (Object)pSDEDataViewBase.getItemPSSysCssId());
        }
        if (pSDEDataViewBase.isItemPSSysCssNameDirty() && (bl || pSDEDataViewBase.getItemPSSysCssName() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSCSSNAME, (Object)pSDEDataViewBase.getItemPSSysCssName());
        }
        if (pSDEDataViewBase.isItemPSSysPFPluginIdDirty() && (bl || pSDEDataViewBase.getItemPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSPFPLUGINID, (Object)pSDEDataViewBase.getItemPSSysPFPluginId());
        }
        if (pSDEDataViewBase.isItemPSSysPFPluginNameDirty() && (bl || pSDEDataViewBase.getItemPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_ITEMPSSYSPFPLUGINNAME, (Object)pSDEDataViewBase.getItemPSSysPFPluginName());
        }
        if (pSDEDataViewBase.isKanbanFlagDirty() && (bl || pSDEDataViewBase.getKanbanFlag() != null)) {
            iDataObject.set(FIELD_KANBANFLAG, (Object)pSDEDataViewBase.getKanbanFlag());
        }
        if (pSDEDataViewBase.isLayoutItemTypeDirty() && (bl || pSDEDataViewBase.getLayoutItemType() != null)) {
            iDataObject.set(FIELD_LAYOUTITEMTYPE, (Object)pSDEDataViewBase.getLayoutItemType());
        }
        if (pSDEDataViewBase.isLockFlagDirty() && (bl || pSDEDataViewBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataViewBase.getLockFlag());
        }
        if (pSDEDataViewBase.isMemoDirty() && (bl || pSDEDataViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataViewBase.getMemo());
        }
        if (pSDEDataViewBase.isMinorSortDirDirty() && (bl || pSDEDataViewBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEDataViewBase.getMinorSortDir());
        }
        if (pSDEDataViewBase.isMinorSortPSDEFIdDirty() && (bl || pSDEDataViewBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEDataViewBase.getMinorSortPSDEFId());
        }
        if (pSDEDataViewBase.isMinorSortPSDEFNameDirty() && (bl || pSDEDataViewBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEDataViewBase.getMinorSortPSDEFName());
        }
        if (pSDEDataViewBase.isMovePSDEActionIdDirty() && (bl || pSDEDataViewBase.getMovePSDEActionId() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONID, (Object)pSDEDataViewBase.getMovePSDEActionId());
        }
        if (pSDEDataViewBase.isMovePSDEActionNameDirty() && (bl || pSDEDataViewBase.getMovePSDEActionName() != null)) {
            iDataObject.set(FIELD_MOVEPSDEACTIONNAME, (Object)pSDEDataViewBase.getMovePSDEActionName());
        }
        if (pSDEDataViewBase.isMultiSelectDirty() && (bl || pSDEDataViewBase.getMultiSelect() != null)) {
            iDataObject.set(FIELD_MULTISELECT, (Object)pSDEDataViewBase.getMultiSelect());
        }
        if (pSDEDataViewBase.isNavPSDERIdDirty() && (bl || pSDEDataViewBase.getNavPSDERId() != null)) {
            iDataObject.set(FIELD_NAVPSDERID, (Object)pSDEDataViewBase.getNavPSDERId());
        }
        if (pSDEDataViewBase.isNavPSDERNameDirty() && (bl || pSDEDataViewBase.getNavPSDERName() != null)) {
            iDataObject.set(FIELD_NAVPSDERNAME, (Object)pSDEDataViewBase.getNavPSDERName());
        }
        if (pSDEDataViewBase.isNavPSDEViewBaseIdDirty() && (bl || pSDEDataViewBase.getNavPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASEID, (Object)pSDEDataViewBase.getNavPSDEViewBaseId());
        }
        if (pSDEDataViewBase.isNavPSDEViewBaseNameDirty() && (bl || pSDEDataViewBase.getNavPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_NAVPSDEVIEWBASENAME, (Object)pSDEDataViewBase.getNavPSDEViewBaseName());
        }
        if (pSDEDataViewBase.isNavViewFilterDirty() && (bl || pSDEDataViewBase.getNavViewFilter() != null)) {
            iDataObject.set(FIELD_NAVVIEWFILTER, (Object)pSDEDataViewBase.getNavViewFilter());
        }
        if (pSDEDataViewBase.isNavViewHeightDirty() && (bl || pSDEDataViewBase.getNavViewHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWHEIGHT, (Object)pSDEDataViewBase.getNavViewHeight());
        }
        if (pSDEDataViewBase.isNavViewMaxHeightDirty() && (bl || pSDEDataViewBase.getNavViewMaxHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXHEIGHT, (Object)pSDEDataViewBase.getNavViewMaxHeight());
        }
        if (pSDEDataViewBase.isNavViewMaxWidthDirty() && (bl || pSDEDataViewBase.getNavViewMaxWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMAXWIDTH, (Object)pSDEDataViewBase.getNavViewMaxWidth());
        }
        if (pSDEDataViewBase.isNavViewMinHeightDirty() && (bl || pSDEDataViewBase.getNavViewMinHeight() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINHEIGHT, (Object)pSDEDataViewBase.getNavViewMinHeight());
        }
        if (pSDEDataViewBase.isNavViewMinWidthDirty() && (bl || pSDEDataViewBase.getNavViewMinWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWMINWIDTH, (Object)pSDEDataViewBase.getNavViewMinWidth());
        }
        if (pSDEDataViewBase.isNavViewParamDirty() && (bl || pSDEDataViewBase.getNavViewParam() != null)) {
            iDataObject.set(FIELD_NAVVIEWPARAM, (Object)pSDEDataViewBase.getNavViewParam());
        }
        if (pSDEDataViewBase.isNavViewPosDirty() && (bl || pSDEDataViewBase.getNavViewPos() != null)) {
            iDataObject.set(FIELD_NAVVIEWPOS, (Object)pSDEDataViewBase.getNavViewPos());
        }
        if (pSDEDataViewBase.isNavViewShowModeDirty() && (bl || pSDEDataViewBase.getNavViewShowMode() != null)) {
            iDataObject.set(FIELD_NAVVIEWSHOWMODE, (Object)pSDEDataViewBase.getNavViewShowMode());
        }
        if (pSDEDataViewBase.isNavViewWidthDirty() && (bl || pSDEDataViewBase.getNavViewWidth() != null)) {
            iDataObject.set(FIELD_NAVVIEWWIDTH, (Object)pSDEDataViewBase.getNavViewWidth());
        }
        if (pSDEDataViewBase.isNo2PSDEUAGroupIdDirty() && (bl || pSDEDataViewBase.getNo2PSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPID, (Object)pSDEDataViewBase.getNo2PSDEUAGroupId());
        }
        if (pSDEDataViewBase.isNo2PSDEUAGroupNameDirty() && (bl || pSDEDataViewBase.getNo2PSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_NO2PSDEUAGROUPNAME, (Object)pSDEDataViewBase.getNo2PSDEUAGroupName());
        }
        if (pSDEDataViewBase.isNoSortDirty() && (bl || pSDEDataViewBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEDataViewBase.getNoSort());
        }
        if (pSDEDataViewBase.isOrderValuePSDEFIdDirty() && (bl || pSDEDataViewBase.getOrderValuePSDEFId() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFID, (Object)pSDEDataViewBase.getOrderValuePSDEFId());
        }
        if (pSDEDataViewBase.isOrderValuePSDEFNameDirty() && (bl || pSDEDataViewBase.getOrderValuePSDEFName() != null)) {
            iDataObject.set(FIELD_ORDERVALUEPSDEFNAME, (Object)pSDEDataViewBase.getOrderValuePSDEFName());
        }
        if (pSDEDataViewBase.isPagingSizeDirty() && (bl || pSDEDataViewBase.getPagingSize() != null)) {
            iDataObject.set(FIELD_PAGINGSIZE, (Object)pSDEDataViewBase.getPagingSize());
        }
        if (pSDEDataViewBase.isPSACHandlerIdDirty() && (bl || pSDEDataViewBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEDataViewBase.getPSACHandlerId());
        }
        if (pSDEDataViewBase.isPSACHandlerNameDirty() && (bl || pSDEDataViewBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEDataViewBase.getPSACHandlerName());
        }
        if (pSDEDataViewBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEDataViewBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEDataViewBase.getPSCtrlLogicGroupId());
        }
        if (pSDEDataViewBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEDataViewBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEDataViewBase.getPSCtrlLogicGroupName());
        }
        if (pSDEDataViewBase.isPSCtrlMsgIdDirty() && (bl || pSDEDataViewBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEDataViewBase.getPSCtrlMsgId());
        }
        if (pSDEDataViewBase.isPSCtrlMsgNameDirty() && (bl || pSDEDataViewBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEDataViewBase.getPSCtrlMsgName());
        }
        if (pSDEDataViewBase.isPSDEDataSetIdDirty() && (bl || pSDEDataViewBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEDataViewBase.getPSDEDataSetId());
        }
        if (pSDEDataViewBase.isPSDEDataSetNameDirty() && (bl || pSDEDataViewBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEDataViewBase.getPSDEDataSetName());
        }
        if (pSDEDataViewBase.isPSDEDataViewIdDirty() && (bl || pSDEDataViewBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSDEDataViewBase.getPSDEDataViewId());
        }
        if (pSDEDataViewBase.isPSDEDataViewNameDirty() && (bl || pSDEDataViewBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSDEDataViewBase.getPSDEDataViewName());
        }
        if (pSDEDataViewBase.isPSDEFormIdDirty() && (bl || pSDEDataViewBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEDataViewBase.getPSDEFormId());
        }
        if (pSDEDataViewBase.isPSDEFormNameDirty() && (bl || pSDEDataViewBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEDataViewBase.getPSDEFormName());
        }
        if (pSDEDataViewBase.isPSDEIdDirty() && (bl || pSDEDataViewBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataViewBase.getPSDEId());
        }
        if (pSDEDataViewBase.isPSDENameDirty() && (bl || pSDEDataViewBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataViewBase.getPSDEName());
        }
        if (pSDEDataViewBase.isPSDEUAGroupIdDirty() && (bl || pSDEDataViewBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEDataViewBase.getPSDEUAGroupId());
        }
        if (pSDEDataViewBase.isPSDEUAGroupNameDirty() && (bl || pSDEDataViewBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEDataViewBase.getPSDEUAGroupName());
        }
        if (pSDEDataViewBase.isPSDynaInstIdDirty() && (bl || pSDEDataViewBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataViewBase.getPSDynaInstId());
        }
        if (pSDEDataViewBase.isPSSysCssIdDirty() && (bl || pSDEDataViewBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEDataViewBase.getPSSysCssId());
        }
        if (pSDEDataViewBase.isPSSysCssNameDirty() && (bl || pSDEDataViewBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEDataViewBase.getPSSysCssName());
        }
        if (pSDEDataViewBase.isPSSysPFPluginIdDirty() && (bl || pSDEDataViewBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEDataViewBase.getPSSysPFPluginId());
        }
        if (pSDEDataViewBase.isPSSysPFPluginNameDirty() && (bl || pSDEDataViewBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEDataViewBase.getPSSysPFPluginName());
        }
        if (pSDEDataViewBase.isPSSysViewPanelIdDirty() && (bl || pSDEDataViewBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEDataViewBase.getPSSysViewPanelId());
        }
        if (pSDEDataViewBase.isPSSysViewPanelNameDirty() && (bl || pSDEDataViewBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEDataViewBase.getPSSysViewPanelName());
        }
        if (pSDEDataViewBase.isPSViewMsgGroupIdDirty() && (bl || pSDEDataViewBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEDataViewBase.getPSViewMsgGroupId());
        }
        if (pSDEDataViewBase.isPSViewMsgGroupNameDirty() && (bl || pSDEDataViewBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEDataViewBase.getPSViewMsgGroupName());
        }
        if (pSDEDataViewBase.isQuickPSDEToolbarIdDirty() && (bl || pSDEDataViewBase.getQuickPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARID, (Object)pSDEDataViewBase.getQuickPSDEToolbarId());
        }
        if (pSDEDataViewBase.isQuickPSDEToolbarNameDirty() && (bl || pSDEDataViewBase.getQuickPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_QUICKPSDETOOLBARNAME, (Object)pSDEDataViewBase.getQuickPSDEToolbarName());
        }
        if (pSDEDataViewBase.isRemovePSDEActionIdDirty() && (bl || pSDEDataViewBase.getRemovePSDEActionId() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONID, (Object)pSDEDataViewBase.getRemovePSDEActionId());
        }
        if (pSDEDataViewBase.isRemovePSDEActionNameDirty() && (bl || pSDEDataViewBase.getRemovePSDEActionName() != null)) {
            iDataObject.set(FIELD_REMOVEPSDEACTIONNAME, (Object)pSDEDataViewBase.getRemovePSDEActionName());
        }
        if (pSDEDataViewBase.isSRFSysPubDirty() && (bl || pSDEDataViewBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEDataViewBase.getSRFSysPub());
        }
        if (pSDEDataViewBase.isSwimlanePSCodeListIdDirty() && (bl || pSDEDataViewBase.getSwimlanePSCodeListId() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSCODELISTID, (Object)pSDEDataViewBase.getSwimlanePSCodeListId());
        }
        if (pSDEDataViewBase.isSwimlanePSCodeListNameDirty() && (bl || pSDEDataViewBase.getSwimlanePSCodeListName() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSCODELISTNAME, (Object)pSDEDataViewBase.getSwimlanePSCodeListName());
        }
        if (pSDEDataViewBase.isSwimlanePSDEFIdDirty() && (bl || pSDEDataViewBase.getSwimlanePSDEFId() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSDEFID, (Object)pSDEDataViewBase.getSwimlanePSDEFId());
        }
        if (pSDEDataViewBase.isSwimlanePSDEFNameDirty() && (bl || pSDEDataViewBase.getSwimlanePSDEFName() != null)) {
            iDataObject.set(FIELD_SWIMLANEPSDEFNAME, (Object)pSDEDataViewBase.getSwimlanePSDEFName());
        }
        if (pSDEDataViewBase.isToDoTaskDirty() && (bl || pSDEDataViewBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataViewBase.getToDoTask());
        }
        if (pSDEDataViewBase.isUpdateDateDirty() && (bl || pSDEDataViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataViewBase.getUpdateDate());
        }
        if (pSDEDataViewBase.isUpdateManDirty() && (bl || pSDEDataViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataViewBase.getUpdateMan());
        }
        if (pSDEDataViewBase.isUpdatePSDEActionIdDirty() && (bl || pSDEDataViewBase.getUpdatePSDEActionId() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONID, (Object)pSDEDataViewBase.getUpdatePSDEActionId());
        }
        if (pSDEDataViewBase.isUpdatePSDEActionNameDirty() && (bl || pSDEDataViewBase.getUpdatePSDEActionName() != null)) {
            iDataObject.set(FIELD_UPDATEPSDEACTIONNAME, (Object)pSDEDataViewBase.getUpdatePSDEActionName());
        }
        if (pSDEDataViewBase.isUser2PSDEActionIdDirty() && (bl || pSDEDataViewBase.getUser2PSDEActionId() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONID, (Object)pSDEDataViewBase.getUser2PSDEActionId());
        }
        if (pSDEDataViewBase.isUser2PSDEActionNameDirty() && (bl || pSDEDataViewBase.getUser2PSDEActionName() != null)) {
            iDataObject.set(FIELD_USER2PSDEACTIONNAME, (Object)pSDEDataViewBase.getUser2PSDEActionName());
        }
        if (pSDEDataViewBase.isUserPSDEActionIdDirty() && (bl || pSDEDataViewBase.getUserPSDEActionId() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONID, (Object)pSDEDataViewBase.getUserPSDEActionId());
        }
        if (pSDEDataViewBase.isUserPSDEActionNameDirty() && (bl || pSDEDataViewBase.getUserPSDEActionName() != null)) {
            iDataObject.set(FIELD_USERPSDEACTIONNAME, (Object)pSDEDataViewBase.getUserPSDEActionName());
        }
        if (pSDEDataViewBase.isViewModelDirty() && (bl || pSDEDataViewBase.getViewModel() != null)) {
            iDataObject.set(FIELD_VIEWMODEL, (Object)pSDEDataViewBase.getViewModel());
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
        return PSDEDataViewBase.remove(this, n);
    }

    private static boolean remove(PSDEDataViewBase pSDEDataViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataViewBase.resetAppendDEItems();
                return true;
            }
            case 1: {
                pSDEDataViewBase.resetAsyncPSDEDSId();
                return true;
            }
            case 2: {
                pSDEDataViewBase.resetAsyncPSDEDSName();
                return true;
            }
            case 3: {
                pSDEDataViewBase.resetBatPSDEToolbarId();
                return true;
            }
            case 4: {
                pSDEDataViewBase.resetBatPSDEToolbarName();
                return true;
            }
            case 5: {
                pSDEDataViewBase.resetBusyIndicator();
                return true;
            }
            case 6: {
                pSDEDataViewBase.resetCardHeight();
                return true;
            }
            case 7: {
                pSDEDataViewBase.resetCardWidth();
                return true;
            }
            case 8: {
                pSDEDataViewBase.resetCard_Col_LG();
                return true;
            }
            case 9: {
                pSDEDataViewBase.resetCard_Col_MD();
                return true;
            }
            case 10: {
                pSDEDataViewBase.resetCard_Col_SM();
                return true;
            }
            case 11: {
                pSDEDataViewBase.resetCard_Col_XS();
                return true;
            }
            case 12: {
                pSDEDataViewBase.resetCodeName();
                return true;
            }
            case 13: {
                pSDEDataViewBase.resetCopyPSDEActionId();
                return true;
            }
            case 14: {
                pSDEDataViewBase.resetCopyPSDEActionName();
                return true;
            }
            case 15: {
                pSDEDataViewBase.resetCreateDate();
                return true;
            }
            case 16: {
                pSDEDataViewBase.resetCreateMan();
                return true;
            }
            case 17: {
                pSDEDataViewBase.resetCreatePSDEActionId();
                return true;
            }
            case 18: {
                pSDEDataViewBase.resetCreatePSDEActionName();
                return true;
            }
            case 19: {
                pSDEDataViewBase.resetCustomCond();
                return true;
            }
            case 20: {
                pSDEDataViewBase.resetCustomType();
                return true;
            }
            case 21: {
                pSDEDataViewBase.resetDataViewSN();
                return true;
            }
            case 22: {
                pSDEDataViewBase.resetDataViewStyle();
                return true;
            }
            case 23: {
                pSDEDataViewBase.resetDVTag();
                return true;
            }
            case 24: {
                pSDEDataViewBase.resetDVTag2();
                return true;
            }
            case 25: {
                pSDEDataViewBase.resetDVTag3();
                return true;
            }
            case 26: {
                pSDEDataViewBase.resetDVTag4();
                return true;
            }
            case 27: {
                pSDEDataViewBase.resetDynaModelFlag();
                return true;
            }
            case 28: {
                pSDEDataViewBase.resetEmptyText();
                return true;
            }
            case 29: {
                pSDEDataViewBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 30: {
                pSDEDataViewBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 31: {
                pSDEDataViewBase.resetEnableEdit();
                return true;
            }
            case 32: {
                pSDEDataViewBase.resetEnableItemPriv();
                return true;
            }
            case 33: {
                pSDEDataViewBase.resetEnablePagingBar();
                return true;
            }
            case 34: {
                pSDEDataViewBase.resetGetDraftPSDEActionId();
                return true;
            }
            case 35: {
                pSDEDataViewBase.resetGetDraftPSDEActionName();
                return true;
            }
            case 36: {
                pSDEDataViewBase.resetGetPSDEActionId();
                return true;
            }
            case 37: {
                pSDEDataViewBase.resetGetPSDEActionName();
                return true;
            }
            case 38: {
                pSDEDataViewBase.resetGroupBarCloseMode();
                return true;
            }
            case 39: {
                pSDEDataViewBase.resetGroupHeight();
                return true;
            }
            case 40: {
                pSDEDataViewBase.resetGroupLayout();
                return true;
            }
            case 41: {
                pSDEDataViewBase.resetGroupMode();
                return true;
            }
            case 42: {
                pSDEDataViewBase.resetGroupMovePSDEActionId();
                return true;
            }
            case 43: {
                pSDEDataViewBase.resetGroupMovePSDEActionName();
                return true;
            }
            case 44: {
                pSDEDataViewBase.resetGroupPSCodeListId();
                return true;
            }
            case 45: {
                pSDEDataViewBase.resetGroupPSCodeListName();
                return true;
            }
            case 46: {
                pSDEDataViewBase.resetGroupPSDEFId();
                return true;
            }
            case 47: {
                pSDEDataViewBase.resetGroupPSDEFName();
                return true;
            }
            case 48: {
                pSDEDataViewBase.resetGroupPSDEId();
                return true;
            }
            case 49: {
                pSDEDataViewBase.resetGroupPSDEName();
                return true;
            }
            case 50: {
                pSDEDataViewBase.resetGroupPSDEUAGroupId();
                return true;
            }
            case 51: {
                pSDEDataViewBase.resetGroupPSDEUAGroupName();
                return true;
            }
            case 52: {
                pSDEDataViewBase.resetGroupPSSysCssId();
                return true;
            }
            case 53: {
                pSDEDataViewBase.resetGroupPSSysCssName();
                return true;
            }
            case 54: {
                pSDEDataViewBase.resetGroupPSSysPFPluginId();
                return true;
            }
            case 55: {
                pSDEDataViewBase.resetGroupPSSysPFPluginName();
                return true;
            }
            case 56: {
                pSDEDataViewBase.resetGroupQuickPSDETBId();
                return true;
            }
            case 57: {
                pSDEDataViewBase.resetGroupQuickPSDETBName();
                return true;
            }
            case 58: {
                pSDEDataViewBase.resetGroupStyle();
                return true;
            }
            case 59: {
                pSDEDataViewBase.resetGroupTextPSDEFId();
                return true;
            }
            case 60: {
                pSDEDataViewBase.resetGroupTextPSDEFName();
                return true;
            }
            case 61: {
                pSDEDataViewBase.resetGroupWidth();
                return true;
            }
            case 62: {
                pSDEDataViewBase.resetGroup_Col_LG();
                return true;
            }
            case 63: {
                pSDEDataViewBase.resetGroup_Col_MD();
                return true;
            }
            case 64: {
                pSDEDataViewBase.resetGroup_Col_SM();
                return true;
            }
            case 65: {
                pSDEDataViewBase.resetGroup_Col_XS();
                return true;
            }
            case 66: {
                pSDEDataViewBase.resetItemPSSysCssId();
                return true;
            }
            case 67: {
                pSDEDataViewBase.resetItemPSSysCssName();
                return true;
            }
            case 68: {
                pSDEDataViewBase.resetItemPSSysPFPluginId();
                return true;
            }
            case 69: {
                pSDEDataViewBase.resetItemPSSysPFPluginName();
                return true;
            }
            case 70: {
                pSDEDataViewBase.resetKanbanFlag();
                return true;
            }
            case 71: {
                pSDEDataViewBase.resetLayoutItemType();
                return true;
            }
            case 72: {
                pSDEDataViewBase.resetLockFlag();
                return true;
            }
            case 73: {
                pSDEDataViewBase.resetMemo();
                return true;
            }
            case 74: {
                pSDEDataViewBase.resetMinorSortDir();
                return true;
            }
            case 75: {
                pSDEDataViewBase.resetMinorSortPSDEFId();
                return true;
            }
            case 76: {
                pSDEDataViewBase.resetMinorSortPSDEFName();
                return true;
            }
            case 77: {
                pSDEDataViewBase.resetMovePSDEActionId();
                return true;
            }
            case 78: {
                pSDEDataViewBase.resetMovePSDEActionName();
                return true;
            }
            case 79: {
                pSDEDataViewBase.resetMultiSelect();
                return true;
            }
            case 80: {
                pSDEDataViewBase.resetNavPSDERId();
                return true;
            }
            case 81: {
                pSDEDataViewBase.resetNavPSDERName();
                return true;
            }
            case 82: {
                pSDEDataViewBase.resetNavPSDEViewBaseId();
                return true;
            }
            case 83: {
                pSDEDataViewBase.resetNavPSDEViewBaseName();
                return true;
            }
            case 84: {
                pSDEDataViewBase.resetNavViewFilter();
                return true;
            }
            case 85: {
                pSDEDataViewBase.resetNavViewHeight();
                return true;
            }
            case 86: {
                pSDEDataViewBase.resetNavViewMaxHeight();
                return true;
            }
            case 87: {
                pSDEDataViewBase.resetNavViewMaxWidth();
                return true;
            }
            case 88: {
                pSDEDataViewBase.resetNavViewMinHeight();
                return true;
            }
            case 89: {
                pSDEDataViewBase.resetNavViewMinWidth();
                return true;
            }
            case 90: {
                pSDEDataViewBase.resetNavViewParam();
                return true;
            }
            case 91: {
                pSDEDataViewBase.resetNavViewPos();
                return true;
            }
            case 92: {
                pSDEDataViewBase.resetNavViewShowMode();
                return true;
            }
            case 93: {
                pSDEDataViewBase.resetNavViewWidth();
                return true;
            }
            case 94: {
                pSDEDataViewBase.resetNo2PSDEUAGroupId();
                return true;
            }
            case 95: {
                pSDEDataViewBase.resetNo2PSDEUAGroupName();
                return true;
            }
            case 96: {
                pSDEDataViewBase.resetNoSort();
                return true;
            }
            case 97: {
                pSDEDataViewBase.resetOrderValuePSDEFId();
                return true;
            }
            case 98: {
                pSDEDataViewBase.resetOrderValuePSDEFName();
                return true;
            }
            case 99: {
                pSDEDataViewBase.resetPagingSize();
                return true;
            }
            case 100: {
                pSDEDataViewBase.resetPSACHandlerId();
                return true;
            }
            case 101: {
                pSDEDataViewBase.resetPSACHandlerName();
                return true;
            }
            case 102: {
                pSDEDataViewBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 103: {
                pSDEDataViewBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 104: {
                pSDEDataViewBase.resetPSCtrlMsgId();
                return true;
            }
            case 105: {
                pSDEDataViewBase.resetPSCtrlMsgName();
                return true;
            }
            case 106: {
                pSDEDataViewBase.resetPSDEDataSetId();
                return true;
            }
            case 107: {
                pSDEDataViewBase.resetPSDEDataSetName();
                return true;
            }
            case 108: {
                pSDEDataViewBase.resetPSDEDataViewId();
                return true;
            }
            case 109: {
                pSDEDataViewBase.resetPSDEDataViewName();
                return true;
            }
            case 110: {
                pSDEDataViewBase.resetPSDEFormId();
                return true;
            }
            case 111: {
                pSDEDataViewBase.resetPSDEFormName();
                return true;
            }
            case 112: {
                pSDEDataViewBase.resetPSDEId();
                return true;
            }
            case 113: {
                pSDEDataViewBase.resetPSDEName();
                return true;
            }
            case 114: {
                pSDEDataViewBase.resetPSDEUAGroupId();
                return true;
            }
            case 115: {
                pSDEDataViewBase.resetPSDEUAGroupName();
                return true;
            }
            case 116: {
                pSDEDataViewBase.resetPSDynaInstId();
                return true;
            }
            case 117: {
                pSDEDataViewBase.resetPSSysCssId();
                return true;
            }
            case 118: {
                pSDEDataViewBase.resetPSSysCssName();
                return true;
            }
            case 119: {
                pSDEDataViewBase.resetPSSysPFPluginId();
                return true;
            }
            case 120: {
                pSDEDataViewBase.resetPSSysPFPluginName();
                return true;
            }
            case 121: {
                pSDEDataViewBase.resetPSSysViewPanelId();
                return true;
            }
            case 122: {
                pSDEDataViewBase.resetPSSysViewPanelName();
                return true;
            }
            case 123: {
                pSDEDataViewBase.resetPSViewMsgGroupId();
                return true;
            }
            case 124: {
                pSDEDataViewBase.resetPSViewMsgGroupName();
                return true;
            }
            case 125: {
                pSDEDataViewBase.resetQuickPSDEToolbarId();
                return true;
            }
            case 126: {
                pSDEDataViewBase.resetQuickPSDEToolbarName();
                return true;
            }
            case 127: {
                pSDEDataViewBase.resetRemovePSDEActionId();
                return true;
            }
            case 128: {
                pSDEDataViewBase.resetRemovePSDEActionName();
                return true;
            }
            case 129: {
                pSDEDataViewBase.resetSRFSysPub();
                return true;
            }
            case 130: {
                pSDEDataViewBase.resetSwimlanePSCodeListId();
                return true;
            }
            case 131: {
                pSDEDataViewBase.resetSwimlanePSCodeListName();
                return true;
            }
            case 132: {
                pSDEDataViewBase.resetSwimlanePSDEFId();
                return true;
            }
            case 133: {
                pSDEDataViewBase.resetSwimlanePSDEFName();
                return true;
            }
            case 134: {
                pSDEDataViewBase.resetToDoTask();
                return true;
            }
            case 135: {
                pSDEDataViewBase.resetUpdateDate();
                return true;
            }
            case 136: {
                pSDEDataViewBase.resetUpdateMan();
                return true;
            }
            case 137: {
                pSDEDataViewBase.resetUpdatePSDEActionId();
                return true;
            }
            case 138: {
                pSDEDataViewBase.resetUpdatePSDEActionName();
                return true;
            }
            case 139: {
                pSDEDataViewBase.resetUser2PSDEActionId();
                return true;
            }
            case 140: {
                pSDEDataViewBase.resetUser2PSDEActionName();
                return true;
            }
            case 141: {
                pSDEDataViewBase.resetUserPSDEActionId();
                return true;
            }
            case 142: {
                pSDEDataViewBase.resetUserPSDEActionName();
                return true;
            }
            case 143: {
                pSDEDataViewBase.resetViewModel();
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
                pSDEDataSetService.autoGet(pSDEDataSet);
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
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
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
    public PSDEToolbar getGroupQuickPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupQuickPSDEToolbar();
        }
        if (this.getGroupQuickPSDETBId() == null) {
            return null;
        }
        Integer n = this.objGroupQuickPSDEToolbarLock;
        synchronized (n) {
            if (this.groupquickpsdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getGroupQuickPSDETBId(), (Object)this.groupquickpsdetoolbar.getPSDEToolbarId()) != 0L) {
                this.groupquickpsdetoolbar = null;
            }
            if (this.groupquickpsdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getGroupQuickPSDETBId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet(pSDEToolbar);
                this.groupquickpsdetoolbar = pSDEToolbar;
            }
            return this.groupquickpsdetoolbar;
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
    public ArrayList<PSDEDataViewLogic> getPSDEDataViewLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewLogics();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEDataViewLogicsLock;
        synchronized (n) {
            if (this.psdedataviewlogics == null) {
                this.psdedataviewlogics = pSDEDataViewService.isTempData(this) ? pSDEDataViewLogicService.selectTempByPSDEDataView(this) : pSDEDataViewLogicService.selectByPSDEDataView(this);
            }
            return this.psdedataviewlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEListItem> getPSDEListItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItem();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEListItemLock;
        synchronized (n) {
            if (this.psdelistitem == null) {
                this.psdelistitem = pSDEDataViewService.isTempData(this) ? pSDEListItemService.selectTempByPSDEDataView(this) : pSDEListItemService.selectByPSDEDataView(this);
            }
            return this.psdelistitem;
        }
    }

    private PSDEDataViewBase getProxyEntity() {
        return this.proxyPSDEDataViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataViewBase) {
            this.proxyPSDEDataViewBase = (PSDEDataViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPENDDEITEMS, 0);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSID, 1);
        fieldIndexMap.put(FIELD_ASYNCPSDEDSNAME, 2);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARID, 3);
        fieldIndexMap.put(FIELD_BATPSDETOOLBARNAME, 4);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 5);
        fieldIndexMap.put(FIELD_CARDHEIGHT, 6);
        fieldIndexMap.put(FIELD_CARDWIDTH, 7);
        fieldIndexMap.put(FIELD_CARD_COL_LG, 8);
        fieldIndexMap.put(FIELD_CARD_COL_MD, 9);
        fieldIndexMap.put(FIELD_CARD_COL_SM, 10);
        fieldIndexMap.put(FIELD_CARD_COL_XS, 11);
        fieldIndexMap.put(FIELD_CODENAME, 12);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONID, 13);
        fieldIndexMap.put(FIELD_COPYPSDEACTIONNAME, 14);
        fieldIndexMap.put(FIELD_CREATEDATE, 15);
        fieldIndexMap.put(FIELD_CREATEMAN, 16);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONID, 17);
        fieldIndexMap.put(FIELD_CREATEPSDEACTIONNAME, 18);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 19);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 20);
        fieldIndexMap.put(FIELD_DATAVIEWSN, 21);
        fieldIndexMap.put(FIELD_DATAVIEWSTYLE, 22);
        fieldIndexMap.put(FIELD_DVTAG, 23);
        fieldIndexMap.put(FIELD_DVTAG2, 24);
        fieldIndexMap.put(FIELD_DVTAG3, 25);
        fieldIndexMap.put(FIELD_DVTAG4, 26);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 27);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 28);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 29);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 30);
        fieldIndexMap.put(FIELD_ENABLEEDIT, 31);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 32);
        fieldIndexMap.put(FIELD_ENABLEPAGINGBAR, 33);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONID, 34);
        fieldIndexMap.put(FIELD_GETDRAFTPSDEACTIONNAME, 35);
        fieldIndexMap.put(FIELD_GETPSDEACTIONID, 36);
        fieldIndexMap.put(FIELD_GETPSDEACTIONNAME, 37);
        fieldIndexMap.put(FIELD_GROUPBARCLOSEMODE, 38);
        fieldIndexMap.put(FIELD_GROUPHEIGHT, 39);
        fieldIndexMap.put(FIELD_GROUPLAYOUT, 40);
        fieldIndexMap.put(FIELD_GROUPMODE, 41);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONID, 42);
        fieldIndexMap.put(FIELD_GROUPMOVEPSDEACTIONNAME, 43);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTID, 44);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTNAME, 45);
        fieldIndexMap.put(FIELD_GROUPPSDEFID, 46);
        fieldIndexMap.put(FIELD_GROUPPSDEFNAME, 47);
        fieldIndexMap.put(FIELD_GROUPPSDEID, 48);
        fieldIndexMap.put(FIELD_GROUPPSDENAME, 49);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPID, 50);
        fieldIndexMap.put(FIELD_GROUPPSDEUAGROUPNAME, 51);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSID, 52);
        fieldIndexMap.put(FIELD_GROUPPSSYSCSSNAME, 53);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINID, 54);
        fieldIndexMap.put(FIELD_GROUPPSSYSPFPLUGINNAME, 55);
        fieldIndexMap.put(FIELD_GROUPQUICKPSDETBID, 56);
        fieldIndexMap.put(FIELD_GROUPQUICKPSDETBNAME, 57);
        fieldIndexMap.put(FIELD_GROUPSTYLE, 58);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFID, 59);
        fieldIndexMap.put(FIELD_GROUPTEXTPSDEFNAME, 60);
        fieldIndexMap.put(FIELD_GROUPWIDTH, 61);
        fieldIndexMap.put(FIELD_GROUP_COL_LG, 62);
        fieldIndexMap.put(FIELD_GROUP_COL_MD, 63);
        fieldIndexMap.put(FIELD_GROUP_COL_SM, 64);
        fieldIndexMap.put(FIELD_GROUP_COL_XS, 65);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSID, 66);
        fieldIndexMap.put(FIELD_ITEMPSSYSCSSNAME, 67);
        fieldIndexMap.put(FIELD_ITEMPSSYSPFPLUGINID, 68);
        fieldIndexMap.put(FIELD_ITEMPSSYSPFPLUGINNAME, 69);
        fieldIndexMap.put(FIELD_KANBANFLAG, 70);
        fieldIndexMap.put(FIELD_LAYOUTITEMTYPE, 71);
        fieldIndexMap.put(FIELD_LOCKFLAG, 72);
        fieldIndexMap.put(FIELD_MEMO, 73);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 74);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 75);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 76);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONID, 77);
        fieldIndexMap.put(FIELD_MOVEPSDEACTIONNAME, 78);
        fieldIndexMap.put(FIELD_MULTISELECT, 79);
        fieldIndexMap.put(FIELD_NAVPSDERID, 80);
        fieldIndexMap.put(FIELD_NAVPSDERNAME, 81);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASEID, 82);
        fieldIndexMap.put(FIELD_NAVPSDEVIEWBASENAME, 83);
        fieldIndexMap.put(FIELD_NAVVIEWFILTER, 84);
        fieldIndexMap.put(FIELD_NAVVIEWHEIGHT, 85);
        fieldIndexMap.put(FIELD_NAVVIEWMAXHEIGHT, 86);
        fieldIndexMap.put(FIELD_NAVVIEWMAXWIDTH, 87);
        fieldIndexMap.put(FIELD_NAVVIEWMINHEIGHT, 88);
        fieldIndexMap.put(FIELD_NAVVIEWMINWIDTH, 89);
        fieldIndexMap.put(FIELD_NAVVIEWPARAM, 90);
        fieldIndexMap.put(FIELD_NAVVIEWPOS, 91);
        fieldIndexMap.put(FIELD_NAVVIEWSHOWMODE, 92);
        fieldIndexMap.put(FIELD_NAVVIEWWIDTH, 93);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPID, 94);
        fieldIndexMap.put(FIELD_NO2PSDEUAGROUPNAME, 95);
        fieldIndexMap.put(FIELD_NOSORT, 96);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFID, 97);
        fieldIndexMap.put(FIELD_ORDERVALUEPSDEFNAME, 98);
        fieldIndexMap.put(FIELD_PAGINGSIZE, 99);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 100);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 101);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 102);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 103);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 104);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 105);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 106);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 107);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 108);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 109);
        fieldIndexMap.put(FIELD_PSDEFORMID, 110);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 111);
        fieldIndexMap.put(FIELD_PSDEID, 112);
        fieldIndexMap.put(FIELD_PSDENAME, 113);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 114);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 115);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 116);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 117);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 118);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 119);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 120);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 121);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 122);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 123);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 124);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARID, 125);
        fieldIndexMap.put(FIELD_QUICKPSDETOOLBARNAME, 126);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONID, 127);
        fieldIndexMap.put(FIELD_REMOVEPSDEACTIONNAME, 128);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 129);
        fieldIndexMap.put(FIELD_SWIMLANEPSCODELISTID, 130);
        fieldIndexMap.put(FIELD_SWIMLANEPSCODELISTNAME, 131);
        fieldIndexMap.put(FIELD_SWIMLANEPSDEFID, 132);
        fieldIndexMap.put(FIELD_SWIMLANEPSDEFNAME, 133);
        fieldIndexMap.put(FIELD_TODOTASK, 134);
        fieldIndexMap.put(FIELD_UPDATEDATE, 135);
        fieldIndexMap.put(FIELD_UPDATEMAN, 136);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONID, 137);
        fieldIndexMap.put(FIELD_UPDATEPSDEACTIONNAME, 138);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONID, 139);
        fieldIndexMap.put(FIELD_USER2PSDEACTIONNAME, 140);
        fieldIndexMap.put(FIELD_USERPSDEACTIONID, 141);
        fieldIndexMap.put(FIELD_USERPSDEACTIONNAME, 142);
        fieldIndexMap.put(FIELD_VIEWMODEL, 143);
    }
}

