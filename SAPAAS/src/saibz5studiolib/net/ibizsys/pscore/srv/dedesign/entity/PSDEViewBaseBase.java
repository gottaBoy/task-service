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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSVTStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSVTStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewEngineService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewBaseBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewBaseBase.class);
    public static final String FIELD_ACCUSERMODE = "ACCUSERMODE";
    public static final String FIELD_BOTTOMINFO = "BOTTOMINFO";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVIEWTAG = "DEVIEWTAG";
    public static final String FIELD_DEVIEWTAG2 = "DEVIEWTAG2";
    public static final String FIELD_DEVIEWTAG3 = "DEVIEWTAG3";
    public static final String FIELD_DEVIEWTAG4 = "DEVIEWTAG4";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNCMODE = "DYNCMODE";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String FIELD_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String FIELD_HEADERINFO = "HEADERINFO";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_LAYOUTPANELMODE = "LAYOUTPANELMODE";
    public static final String FIELD_LOADDEFAULT = "LOADDEFAULT";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_OPENMODE = "OPENMODE";
    public static final String FIELD_PDTPARAMPRE = "PDTPARAMPRE";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEVIEWTYPE";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSAPPVIEWCNT = "PSAPPVIEWCNT";
    public static final String FIELD_PSAPPVIEWSCNT = "PSAPPVIEWSCNT";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEAWGROUPID = "PSDEAWGROUPID";
    public static final String FIELD_PSDEAWGROUPNAME = "PSDEAWGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWBASETYPE = "PSDEVIEWBASETYPE";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String FIELD_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String FIELD_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String FIELD_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String FIELD_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String FIELD_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PSVTSTYLEID = "PSVTSTYLEID";
    public static final String FIELD_PSVTSTYLENAME = "PSVTSTYLENAME";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SUBCAPPSLANRESID = "SUBCAPPSLANRESID";
    public static final String FIELD_SUBCAPPSLANRESNAME = "SUBCAPPSLANRESNAME";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_TEMPMODE = "TEMPMODE";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    public static final String FIELD_VIEWMODEL = "VIEWMODEL";
    public static final String FIELD_VIEWPARAM = "VIEWPARAM";
    public static final String FIELD_VIEWPARAM10 = "VIEWPARAM10";
    public static final String FIELD_VIEWPARAM11 = "VIEWPARAM11";
    public static final String FIELD_VIEWPARAM12 = "VIEWPARAM12";
    public static final String FIELD_VIEWPARAM13 = "VIEWPARAM13";
    public static final String FIELD_VIEWPARAM14 = "VIEWPARAM14";
    public static final String FIELD_VIEWPARAM15 = "VIEWPARAM15";
    public static final String FIELD_VIEWPARAM16 = "VIEWPARAM16";
    public static final String FIELD_VIEWPARAM17 = "VIEWPARAM17";
    public static final String FIELD_VIEWPARAM18 = "VIEWPARAM18";
    public static final String FIELD_VIEWPARAM2 = "VIEWPARAM2";
    public static final String FIELD_VIEWPARAM3 = "VIEWPARAM3";
    public static final String FIELD_VIEWPARAM4 = "VIEWPARAM4";
    public static final String FIELD_VIEWPARAM5 = "VIEWPARAM5";
    public static final String FIELD_VIEWPARAM6 = "VIEWPARAM6";
    public static final String FIELD_VIEWPARAM7 = "VIEWPARAM7";
    public static final String FIELD_VIEWPARAM8 = "VIEWPARAM8";
    public static final String FIELD_VIEWPARAM9 = "VIEWPARAM9";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    public static final String FIELD_VIEWSN = "VIEWSN";
    public static final String FIELD_WFVIEWPARAM = "WFVIEWPARAM";
    public static final String FIELD_WFVIEWPARAM2 = "WFVIEWPARAM2";
    public static final String FIELD_WFVIEWPARAM3 = "WFVIEWPARAM3";
    public static final String FIELD_WFVIEWPARAM4 = "WFVIEWPARAM4";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ACCUSERMODE = 0;
    private static final int INDEX_BOTTOMINFO = 1;
    private static final int INDEX_CAPPSLANRESID = 2;
    private static final int INDEX_CAPPSLANRESNAME = 3;
    private static final int INDEX_CAPTION = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DEVIEWTAG = 8;
    private static final int INDEX_DEVIEWTAG2 = 9;
    private static final int INDEX_DEVIEWTAG3 = 10;
    private static final int INDEX_DEVIEWTAG4 = 11;
    private static final int INDEX_DYNAMODELFLAG = 12;
    private static final int INDEX_DYNCMODE = 13;
    private static final int INDEX_ENABLEVIEWACTIONS = 14;
    private static final int INDEX_GROUPPSCODELISTID = 15;
    private static final int INDEX_GROUPPSCODELISTNAME = 16;
    private static final int INDEX_HEADERINFO = 17;
    private static final int INDEX_HEIGHT = 18;
    private static final int INDEX_LAYOUTPANELMODE = 19;
    private static final int INDEX_LOADDEFAULT = 20;
    private static final int INDEX_LOCKFLAG = 21;
    private static final int INDEX_MEMO = 22;
    private static final int INDEX_MODELSTATE = 23;
    private static final int INDEX_OPENMODE = 24;
    private static final int INDEX_PDTPARAMPRE = 25;
    private static final int INDEX_PDVTPARAM = 26;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 27;
    private static final int INDEX_PSACHANDLERID = 28;
    private static final int INDEX_PSACHANDLERNAME = 29;
    private static final int INDEX_PSAPPVIEWCNT = 30;
    private static final int INDEX_PSAPPVIEWSCNT = 31;
    private static final int INDEX_PSCTRLLOGICGROUPID = 32;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 33;
    private static final int INDEX_PSDEAWGROUPID = 34;
    private static final int INDEX_PSDEAWGROUPNAME = 35;
    private static final int INDEX_PSDEID = 36;
    private static final int INDEX_PSDEMAINSTATEID = 37;
    private static final int INDEX_PSDEMAINSTATENAME = 38;
    private static final int INDEX_PSDENAME = 39;
    private static final int INDEX_PSDERID = 40;
    private static final int INDEX_PSDERNAME = 41;
    private static final int INDEX_PSDEVIEWBASEID = 42;
    private static final int INDEX_PSDEVIEWBASENAME = 43;
    private static final int INDEX_PSDEVIEWBASETYPE = 44;
    private static final int INDEX_PSDYNADEVIEWTEMPLID = 45;
    private static final int INDEX_PSDYNADEVIEWTEMPLNAME = 46;
    private static final int INDEX_PSDYNAINSTID = 47;
    private static final int INDEX_PSHELPMODULEID = 48;
    private static final int INDEX_PSHELPMODULENAME = 49;
    private static final int INDEX_PSSUBVIEWTYPEID = 50;
    private static final int INDEX_PSSUBVIEWTYPENAME = 51;
    private static final int INDEX_PSSYSCOUNTERID = 52;
    private static final int INDEX_PSSYSCOUNTERNAME = 53;
    private static final int INDEX_PSSYSCSSID = 54;
    private static final int INDEX_PSSYSCSSNAME = 55;
    private static final int INDEX_PSSYSDYNAMODELID = 56;
    private static final int INDEX_PSSYSDYNAMODELNAME = 57;
    private static final int INDEX_PSSYSIMAGEID = 58;
    private static final int INDEX_PSSYSIMAGENAME = 59;
    private static final int INDEX_PSSYSPFPLUGINID = 60;
    private static final int INDEX_PSSYSPFPLUGINNAME = 61;
    private static final int INDEX_PSSYSREQITEMID = 62;
    private static final int INDEX_PSSYSREQITEMNAME = 63;
    private static final int INDEX_PSSYSTEMID = 64;
    private static final int INDEX_PSSYSTEMNAME = 65;
    private static final int INDEX_PSSYSUNIRESID = 66;
    private static final int INDEX_PSSYSUNIRESNAME = 67;
    private static final int INDEX_PSSYSVIEWPANELID = 68;
    private static final int INDEX_PSSYSVIEWPANELNAME = 69;
    private static final int INDEX_PSVIEWENGINEID = 70;
    private static final int INDEX_PSVIEWENGINENAME = 71;
    private static final int INDEX_PSVIEWMSGGROUPID = 72;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 73;
    private static final int INDEX_PSVTSTYLEID = 74;
    private static final int INDEX_PSVTSTYLENAME = 75;
    private static final int INDEX_PSWFDEID = 76;
    private static final int INDEX_PSWFDENAME = 77;
    private static final int INDEX_PSWFID = 78;
    private static final int INDEX_PSWFVERSIONID = 79;
    private static final int INDEX_PSWFVERSIONNAME = 80;
    private static final int INDEX_READONLYMODE = 81;
    private static final int INDEX_SHOWCAPTIONBAR = 82;
    private static final int INDEX_SRFSYSPUB = 83;
    private static final int INDEX_SUBCAPPSLANRESID = 84;
    private static final int INDEX_SUBCAPPSLANRESNAME = 85;
    private static final int INDEX_SUBCAPTION = 86;
    private static final int INDEX_TEMPMODE = 87;
    private static final int INDEX_TITLE = 88;
    private static final int INDEX_TITLEPSLANRESID = 89;
    private static final int INDEX_TITLEPSLANRESNAME = 90;
    private static final int INDEX_TODOTASK = 91;
    private static final int INDEX_UPDATEDATE = 92;
    private static final int INDEX_UPDATEMAN = 93;
    private static final int INDEX_USERDATA = 94;
    private static final int INDEX_USERDATA2 = 95;
    private static final int INDEX_USERPARAMS = 96;
    private static final int INDEX_VIEWACTIONS = 97;
    private static final int INDEX_VIEWMODEL = 98;
    private static final int INDEX_VIEWPARAM = 99;
    private static final int INDEX_VIEWPARAM10 = 100;
    private static final int INDEX_VIEWPARAM11 = 101;
    private static final int INDEX_VIEWPARAM12 = 102;
    private static final int INDEX_VIEWPARAM13 = 103;
    private static final int INDEX_VIEWPARAM14 = 104;
    private static final int INDEX_VIEWPARAM15 = 105;
    private static final int INDEX_VIEWPARAM16 = 106;
    private static final int INDEX_VIEWPARAM17 = 107;
    private static final int INDEX_VIEWPARAM18 = 108;
    private static final int INDEX_VIEWPARAM2 = 109;
    private static final int INDEX_VIEWPARAM3 = 110;
    private static final int INDEX_VIEWPARAM4 = 111;
    private static final int INDEX_VIEWPARAM5 = 112;
    private static final int INDEX_VIEWPARAM6 = 113;
    private static final int INDEX_VIEWPARAM7 = 114;
    private static final int INDEX_VIEWPARAM8 = 115;
    private static final int INDEX_VIEWPARAM9 = 116;
    private static final int INDEX_VIEWPARAMS = 117;
    private static final int INDEX_VIEWSN = 118;
    private static final int INDEX_WFVIEWPARAM = 119;
    private static final int INDEX_WFVIEWPARAM2 = 120;
    private static final int INDEX_WFVIEWPARAM3 = 121;
    private static final int INDEX_WFVIEWPARAM4 = 122;
    private static final int INDEX_WIDTH = 123;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewBaseBase proxyPSDEViewBaseBase = null;
    private boolean accusermodeDirtyFlag = false;
    private boolean bottominfoDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deviewtagDirtyFlag = false;
    private boolean deviewtag2DirtyFlag = false;
    private boolean deviewtag3DirtyFlag = false;
    private boolean deviewtag4DirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dyncmodeDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean grouppscodelistidDirtyFlag = false;
    private boolean grouppscodelistnameDirtyFlag = false;
    private boolean headerinfoDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean layoutpanelmodeDirtyFlag = false;
    private boolean loaddefaultDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean openmodeDirtyFlag = false;
    private boolean pdtparampreDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psappviewcntDirtyFlag = false;
    private boolean psappviewscntDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdeawgroupidDirtyFlag = false;
    private boolean psdeawgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewbasetypeDirtyFlag = false;
    private boolean psdynadeviewtemplidDirtyFlag = false;
    private boolean psdynadeviewtemplnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pshelpmoduleidDirtyFlag = false;
    private boolean pshelpmodulenameDirtyFlag = false;
    private boolean pssubviewtypeidDirtyFlag = false;
    private boolean pssubviewtypenameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewengineidDirtyFlag = false;
    private boolean psviewenginenameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean psvtstyleidDirtyFlag = false;
    private boolean psvtstylenameDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean showcaptionbarDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean subcappslanresidDirtyFlag = false;
    private boolean subcappslanresnameDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean tempmodeDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    private boolean viewmodelDirtyFlag = false;
    private boolean viewparamDirtyFlag = false;
    private boolean viewparam10DirtyFlag = false;
    private boolean viewparam11DirtyFlag = false;
    private boolean viewparam12DirtyFlag = false;
    private boolean viewparam13DirtyFlag = false;
    private boolean viewparam14DirtyFlag = false;
    private boolean viewparam15DirtyFlag = false;
    private boolean viewparam16DirtyFlag = false;
    private boolean viewparam17DirtyFlag = false;
    private boolean viewparam18DirtyFlag = false;
    private boolean viewparam2DirtyFlag = false;
    private boolean viewparam3DirtyFlag = false;
    private boolean viewparam4DirtyFlag = false;
    private boolean viewparam5DirtyFlag = false;
    private boolean viewparam6DirtyFlag = false;
    private boolean viewparam7DirtyFlag = false;
    private boolean viewparam8DirtyFlag = false;
    private boolean viewparam9DirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    private boolean viewsnDirtyFlag = false;
    private boolean wfviewparamDirtyFlag = false;
    private boolean wfviewparam2DirtyFlag = false;
    private boolean wfviewparam3DirtyFlag = false;
    private boolean wfviewparam4DirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="accusermode")
    private String accusermode;
    @Column(name="bottominfo")
    private String bottominfo;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deviewtag")
    private String deviewtag;
    @Column(name="deviewtag2")
    private String deviewtag2;
    @Column(name="deviewtag3")
    private String deviewtag3;
    @Column(name="deviewtag4")
    private String deviewtag4;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dyncmode")
    private Integer dyncmode;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="grouppscodelistid")
    private String grouppscodelistid;
    @Column(name="grouppscodelistname")
    private String grouppscodelistname;
    @Column(name="headerinfo")
    private String headerinfo;
    @Column(name="height")
    private Integer height;
    @Column(name="layoutpanelmode")
    private Integer layoutpanelmode;
    @Column(name="loaddefault")
    private Integer loaddefault;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="openmode")
    private String openmode;
    @Column(name="pdtparampre")
    private String pdtparampre;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psappviewcnt")
    private Integer psappviewcnt;
    @Column(name="psappviewscnt")
    private Integer psappviewscnt;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdeawgroupid")
    private String psdeawgroupid;
    @Column(name="psdeawgroupname")
    private String psdeawgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewbasetype")
    private String psdeviewbasetype;
    @Column(name="psdynadeviewtemplid")
    private String psdynadeviewtemplid;
    @Column(name="psdynadeviewtemplname")
    private String psdynadeviewtemplname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pshelpmoduleid")
    private String pshelpmoduleid;
    @Column(name="pshelpmodulename")
    private String pshelpmodulename;
    @Column(name="pssubviewtypeid")
    private String pssubviewtypeid;
    @Column(name="pssubviewtypename")
    private String pssubviewtypename;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewengineid")
    private String psviewengineid;
    @Column(name="psviewenginename")
    private String psviewenginename;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="psvtstyleid")
    private String psvtstyleid;
    @Column(name="psvtstylename")
    private String psvtstylename;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="showcaptionbar")
    private Integer showcaptionbar;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="subcappslanresid")
    private String subcappslanresid;
    @Column(name="subcappslanresname")
    private String subcappslanresname;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="tempmode")
    private Integer tempmode;
    @Column(name="title")
    private String title;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userparams")
    private String userparams;
    @Column(name="viewactions")
    private Integer viewactions;
    @Column(name="viewmodel")
    private String viewmodel;
    @Column(name="viewparam")
    private String viewparam;
    @Column(name="viewparam10")
    private Integer viewparam10;
    @Column(name="viewparam11")
    private Integer viewparam11;
    @Column(name="viewparam12")
    private Integer viewparam12;
    @Column(name="viewparam13")
    private String viewparam13;
    @Column(name="viewparam14")
    private String viewparam14;
    @Column(name="viewparam15")
    private String viewparam15;
    @Column(name="viewparam16")
    private String viewparam16;
    @Column(name="viewparam17")
    private Integer viewparam17;
    @Column(name="viewparam18")
    private Integer viewparam18;
    @Column(name="viewparam2")
    private String viewparam2;
    @Column(name="viewparam3")
    private Integer viewparam3;
    @Column(name="viewparam4")
    private Integer viewparam4;
    @Column(name="viewparam5")
    private Integer viewparam5;
    @Column(name="viewparam6")
    private Integer viewparam6;
    @Column(name="viewparam7")
    private String viewparam7;
    @Column(name="viewparam8")
    private String viewparam8;
    @Column(name="viewparam9")
    private Integer viewparam9;
    @Column(name="viewparams")
    private String viewparams;
    @Column(name="viewsn")
    private String viewsn;
    @Column(name="wfviewparam")
    private Integer wfviewparam;
    @Column(name="wfviewparam2")
    private Integer wfviewparam2;
    @Column(name="wfviewparam3")
    private String wfviewparam3;
    @Column(name="wfviewparam4")
    private String wfviewparam4;
    @Column(name="width")
    private Integer width;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objGroupPSCodeListLock = new Integer(1);
    private PSCodeList grouppscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEAWGroupLock = new Integer(1);
    private PSDEAWGroup psdeawgroup = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSDynaDEViewTemplLock = new Integer(1);
    private PSDynaDEViewTempl psdynadeviewtempl = null;
    private Integer objPSHelpModuleLock = new Integer(1);
    private PSHelpModule pshelpmodule = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objSubCapPSLanResLock = new Integer(1);
    private PSLanguageRes subcappslanres = null;
    private Integer objTitlePSLanResLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;
    private Integer objPSSubViewTypeLock = new Integer(1);
    private PSSubViewType pssubviewtype = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewEngineLock = new Integer(1);
    private PSViewEngine psviewengine = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSVTStyleLock = new Integer(1);
    private PSVTStyle psvtstyle = null;
    private Integer objPSWFDELock = new Integer(1);
    private PSWFDE pswfde = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSAppViewsLock = new Integer(1);
    private ArrayList<PSAppView> psappviews = null;
    private Integer objPSDEViewCtrlsLock = new Integer(1);
    private ArrayList<PSDEViewCtrl> psdeviewctrls = null;
    private Integer objPSDEViewEnginesLock = new Integer(1);
    private ArrayList<PSDEViewEngine> psdeviewengines = null;
    private Integer objPSDEViewServicesLock = new Integer(1);
    private ArrayList<PSDEViewService> psdeviewservices = null;

    public void setAccUserMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccUserMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.accusermode = string;
        this.accusermodeDirtyFlag = true;
    }

    public String getAccUserMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccUserMode();
        }
        return this.accusermode;
    }

    public boolean isAccUserModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccUserModeDirty();
        }
        return this.accusermodeDirtyFlag;
    }

    public void resetAccUserMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccUserMode();
            return;
        }
        this.accusermodeDirtyFlag = false;
        this.accusermode = null;
    }

    public void setBottomInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottominfo = string;
        this.bottominfoDirtyFlag = true;
    }

    public String getBottomInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomInfo();
        }
        return this.bottominfo;
    }

    public boolean isBottomInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomInfoDirty();
        }
        return this.bottominfoDirtyFlag;
    }

    public void resetBottomInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomInfo();
            return;
        }
        this.bottominfoDirtyFlag = false;
        this.bottominfo = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setDEViewTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewtag = string;
        this.deviewtagDirtyFlag = true;
    }

    public String getDEViewTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewTag();
        }
        return this.deviewtag;
    }

    public boolean isDEViewTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewTagDirty();
        }
        return this.deviewtagDirtyFlag;
    }

    public void resetDEViewTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewTag();
            return;
        }
        this.deviewtagDirtyFlag = false;
        this.deviewtag = null;
    }

    public void setDEViewTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewtag2 = string;
        this.deviewtag2DirtyFlag = true;
    }

    public String getDEViewTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewTag2();
        }
        return this.deviewtag2;
    }

    public boolean isDEViewTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewTag2Dirty();
        }
        return this.deviewtag2DirtyFlag;
    }

    public void resetDEViewTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewTag2();
            return;
        }
        this.deviewtag2DirtyFlag = false;
        this.deviewtag2 = null;
    }

    public void setDEViewTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewtag3 = string;
        this.deviewtag3DirtyFlag = true;
    }

    public String getDEViewTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewTag3();
        }
        return this.deviewtag3;
    }

    public boolean isDEViewTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewTag3Dirty();
        }
        return this.deviewtag3DirtyFlag;
    }

    public void resetDEViewTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewTag3();
            return;
        }
        this.deviewtag3DirtyFlag = false;
        this.deviewtag3 = null;
    }

    public void setDEViewTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewtag4 = string;
        this.deviewtag4DirtyFlag = true;
    }

    public String getDEViewTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewTag4();
        }
        return this.deviewtag4;
    }

    public boolean isDEViewTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewTag4Dirty();
        }
        return this.deviewtag4DirtyFlag;
    }

    public void resetDEViewTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewTag4();
            return;
        }
        this.deviewtag4DirtyFlag = false;
        this.deviewtag4 = null;
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

    public void setDyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDyncMode(n);
            return;
        }
        this.dyncmode = n;
        this.dyncmodeDirtyFlag = true;
    }

    public Integer getDyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDyncMode();
        }
        return this.dyncmode;
    }

    public boolean isDyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDyncModeDirty();
        }
        return this.dyncmodeDirtyFlag;
    }

    public void resetDyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDyncMode();
            return;
        }
        this.dyncmodeDirtyFlag = false;
        this.dyncmode = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
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

    public void setHeaderInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerinfo = string;
        this.headerinfoDirtyFlag = true;
    }

    public String getHeaderInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderInfo();
        }
        return this.headerinfo;
    }

    public boolean isHeaderInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderInfoDirty();
        }
        return this.headerinfoDirtyFlag;
    }

    public void resetHeaderInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderInfo();
            return;
        }
        this.headerinfoDirtyFlag = false;
        this.headerinfo = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setLayoutPanelMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutPanelMode(n);
            return;
        }
        this.layoutpanelmode = n;
        this.layoutpanelmodeDirtyFlag = true;
    }

    public Integer getLayoutPanelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutPanelMode();
        }
        return this.layoutpanelmode;
    }

    public boolean isLayoutPanelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutPanelModeDirty();
        }
        return this.layoutpanelmodeDirtyFlag;
    }

    public void resetLayoutPanelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutPanelMode();
            return;
        }
        this.layoutpanelmodeDirtyFlag = false;
        this.layoutpanelmode = null;
    }

    public void setLoadDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadDefault(n);
            return;
        }
        this.loaddefault = n;
        this.loaddefaultDirtyFlag = true;
    }

    public Integer getLoadDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadDefault();
        }
        return this.loaddefault;
    }

    public boolean isLoadDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadDefaultDirty();
        }
        return this.loaddefaultDirtyFlag;
    }

    public void resetLoadDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadDefault();
            return;
        }
        this.loaddefaultDirtyFlag = false;
        this.loaddefault = null;
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

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
    }

    public void setOpenMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openmode = string;
        this.openmodeDirtyFlag = true;
    }

    public String getOpenMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenMode();
        }
        return this.openmode;
    }

    public boolean isOpenModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenModeDirty();
        }
        return this.openmodeDirtyFlag;
    }

    public void resetOpenMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenMode();
            return;
        }
        this.openmodeDirtyFlag = false;
        this.openmode = null;
    }

    public void setPDTParamPre(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDTParamPre(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdtparampre = string;
        this.pdtparampreDirtyFlag = true;
    }

    public String getPDTParamPre() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDTParamPre();
        }
        return this.pdtparampre;
    }

    public boolean isPDTParamPreDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDTParamPreDirty();
        }
        return this.pdtparampreDirtyFlag;
    }

    public void resetPDTParamPre() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDTParamPre();
            return;
        }
        this.pdtparampreDirtyFlag = false;
        this.pdtparampre = null;
    }

    public void setPDVTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdvtparam = string;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPredefinedViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedviewtype = string;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
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

    public void setPSAppViewCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewCnt(n);
            return;
        }
        this.psappviewcnt = n;
        this.psappviewcntDirtyFlag = true;
    }

    public Integer getPSAppViewCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCnt();
        }
        return this.psappviewcnt;
    }

    public boolean isPSAppViewCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewCntDirty();
        }
        return this.psappviewcntDirtyFlag;
    }

    public void resetPSAppViewCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewCnt();
            return;
        }
        this.psappviewcntDirtyFlag = false;
        this.psappviewcnt = null;
    }

    public void setPSAppViewsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewsCnt(n);
            return;
        }
        this.psappviewscnt = n;
        this.psappviewscntDirtyFlag = true;
    }

    public Integer getPSAppViewsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewsCnt();
        }
        return this.psappviewscnt;
    }

    public boolean isPSAppViewsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewsCntDirty();
        }
        return this.psappviewscntDirtyFlag;
    }

    public void resetPSAppViewsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewsCnt();
            return;
        }
        this.psappviewscntDirtyFlag = false;
        this.psappviewscnt = null;
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

    public void setPSDEAWGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupid = string;
        this.psdeawgroupidDirtyFlag = true;
    }

    public String getPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupId();
        }
        return this.psdeawgroupid;
    }

    public boolean isPSDEAWGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupIdDirty();
        }
        return this.psdeawgroupidDirtyFlag;
    }

    public void resetPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupId();
            return;
        }
        this.psdeawgroupidDirtyFlag = false;
        this.psdeawgroupid = null;
    }

    public void setPSDEAWGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupname = string;
        this.psdeawgroupnameDirtyFlag = true;
    }

    public String getPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupName();
        }
        return this.psdeawgroupname;
    }

    public boolean isPSDEAWGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupNameDirty();
        }
        return this.psdeawgroupnameDirtyFlag;
    }

    public void resetPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupName();
            return;
        }
        this.psdeawgroupnameDirtyFlag = false;
        this.psdeawgroupname = null;
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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
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

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDEViewBaseType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasetype = string;
        this.psdeviewbasetypeDirtyFlag = true;
    }

    public String getPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseType();
        }
        return this.psdeviewbasetype;
    }

    public boolean isPSDEViewBaseTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseTypeDirty();
        }
        return this.psdeviewbasetypeDirtyFlag;
    }

    public void resetPSDEViewBaseType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseType();
            return;
        }
        this.psdeviewbasetypeDirtyFlag = false;
        this.psdeviewbasetype = null;
    }

    public void setPSDynaDEViewTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtemplid = string;
        this.psdynadeviewtemplidDirtyFlag = true;
    }

    public String getPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTemplId();
        }
        return this.psdynadeviewtemplid;
    }

    public boolean isPSDynaDEViewTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTemplIdDirty();
        }
        return this.psdynadeviewtemplidDirtyFlag;
    }

    public void resetPSDynaDEViewTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewTemplId();
            return;
        }
        this.psdynadeviewtemplidDirtyFlag = false;
        this.psdynadeviewtemplid = null;
    }

    public void setPSDynaDEViewTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtemplname = string;
        this.psdynadeviewtemplnameDirtyFlag = true;
    }

    public String getPSDynaDEViewTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTemplName();
        }
        return this.psdynadeviewtemplname;
    }

    public boolean isPSDynaDEViewTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTemplNameDirty();
        }
        return this.psdynadeviewtemplnameDirtyFlag;
    }

    public void resetPSDynaDEViewTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewTemplName();
            return;
        }
        this.psdynadeviewtemplnameDirtyFlag = false;
        this.psdynadeviewtemplname = null;
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

    public void setPSHelpModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmoduleid = string;
        this.pshelpmoduleidDirtyFlag = true;
    }

    public String getPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleId();
        }
        return this.pshelpmoduleid;
    }

    public boolean isPSHelpModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleIdDirty();
        }
        return this.pshelpmoduleidDirtyFlag;
    }

    public void resetPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleId();
            return;
        }
        this.pshelpmoduleidDirtyFlag = false;
        this.pshelpmoduleid = null;
    }

    public void setPSHelpModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmodulename = string;
        this.pshelpmodulenameDirtyFlag = true;
    }

    public String getPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleName();
        }
        return this.pshelpmodulename;
    }

    public boolean isPSHelpModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleNameDirty();
        }
        return this.pshelpmodulenameDirtyFlag;
    }

    public void resetPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleName();
            return;
        }
        this.pshelpmodulenameDirtyFlag = false;
        this.pshelpmodulename = null;
    }

    public void setPSSubViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubviewtypeid = string;
        this.pssubviewtypeidDirtyFlag = true;
    }

    public String getPSSubViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewTypeId();
        }
        return this.pssubviewtypeid;
    }

    public boolean isPSSubViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubViewTypeIdDirty();
        }
        return this.pssubviewtypeidDirtyFlag;
    }

    public void resetPSSubViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubViewTypeId();
            return;
        }
        this.pssubviewtypeidDirtyFlag = false;
        this.pssubviewtypeid = null;
    }

    public void setPSSubViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubviewtypename = string;
        this.pssubviewtypenameDirtyFlag = true;
    }

    public String getPSSubViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewTypeName();
        }
        return this.pssubviewtypename;
    }

    public boolean isPSSubViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubViewTypeNameDirty();
        }
        return this.pssubviewtypenameDirtyFlag;
    }

    public void resetPSSubViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubViewTypeName();
            return;
        }
        this.pssubviewtypenameDirtyFlag = false;
        this.pssubviewtypename = null;
    }

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
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

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
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

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
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

    public void setPSViewEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewengineid = string;
        this.psviewengineidDirtyFlag = true;
    }

    public String getPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineId();
        }
        return this.psviewengineid;
    }

    public boolean isPSViewEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineIdDirty();
        }
        return this.psviewengineidDirtyFlag;
    }

    public void resetPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineId();
            return;
        }
        this.psviewengineidDirtyFlag = false;
        this.psviewengineid = null;
    }

    public void setPSViewEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewenginename = string;
        this.psviewenginenameDirtyFlag = true;
    }

    public String getPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineName();
        }
        return this.psviewenginename;
    }

    public boolean isPSViewEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineNameDirty();
        }
        return this.psviewenginenameDirtyFlag;
    }

    public void resetPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineName();
            return;
        }
        this.psviewenginenameDirtyFlag = false;
        this.psviewenginename = null;
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

    public void setPSVTStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtstyleid = string;
        this.psvtstyleidDirtyFlag = true;
    }

    public String getPSVTStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTStyleId();
        }
        return this.psvtstyleid;
    }

    public boolean isPSVTStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTStyleIdDirty();
        }
        return this.psvtstyleidDirtyFlag;
    }

    public void resetPSVTStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTStyleId();
            return;
        }
        this.psvtstyleidDirtyFlag = false;
        this.psvtstyleid = null;
    }

    public void setPSVTStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtstylename = string;
        this.psvtstylenameDirtyFlag = true;
    }

    public String getPSVTStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTStyleName();
        }
        return this.psvtstylename;
    }

    public boolean isPSVTStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTStyleNameDirty();
        }
        return this.psvtstylenameDirtyFlag;
    }

    public void resetPSVTStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTStyleName();
            return;
        }
        this.psvtstylenameDirtyFlag = false;
        this.psvtstylename = null;
    }

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdename = string;
        this.pswfdenameDirtyFlag = true;
    }

    public String getPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEName();
        }
        return this.pswfdename;
    }

    public boolean isPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDENameDirty();
        }
        return this.pswfdenameDirtyFlag;
    }

    public void resetPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEName();
            return;
        }
        this.pswfdenameDirtyFlag = false;
        this.pswfdename = null;
    }

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setShowCaptionBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowCaptionBar(n);
            return;
        }
        this.showcaptionbar = n;
        this.showcaptionbarDirtyFlag = true;
    }

    public Integer getShowCaptionBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowCaptionBar();
        }
        return this.showcaptionbar;
    }

    public boolean isShowCaptionBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowCaptionBarDirty();
        }
        return this.showcaptionbarDirtyFlag;
    }

    public void resetShowCaptionBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowCaptionBar();
            return;
        }
        this.showcaptionbarDirtyFlag = false;
        this.showcaptionbar = null;
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

    public void setSubCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcappslanresid = string;
        this.subcappslanresidDirtyFlag = true;
    }

    public String getSubCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCapPSLanResId();
        }
        return this.subcappslanresid;
    }

    public boolean isSubCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCapPSLanResIdDirty();
        }
        return this.subcappslanresidDirtyFlag;
    }

    public void resetSubCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCapPSLanResId();
            return;
        }
        this.subcappslanresidDirtyFlag = false;
        this.subcappslanresid = null;
    }

    public void setSubCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcappslanresname = string;
        this.subcappslanresnameDirtyFlag = true;
    }

    public String getSubCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCapPSLanResName();
        }
        return this.subcappslanresname;
    }

    public boolean isSubCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCapPSLanResNameDirty();
        }
        return this.subcappslanresnameDirtyFlag;
    }

    public void resetSubCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCapPSLanResName();
            return;
        }
        this.subcappslanresnameDirtyFlag = false;
        this.subcappslanresname = null;
    }

    public void setSubCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcaption = string;
        this.subcaptionDirtyFlag = true;
    }

    public String getSubCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCaption();
        }
        return this.subcaption;
    }

    public boolean isSubCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCaptionDirty();
        }
        return this.subcaptionDirtyFlag;
    }

    public void resetSubCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCaption();
            return;
        }
        this.subcaptionDirtyFlag = false;
        this.subcaption = null;
    }

    public void setTempMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempMode(n);
            return;
        }
        this.tempmode = n;
        this.tempmodeDirtyFlag = true;
    }

    public Integer getTempMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempMode();
        }
        return this.tempmode;
    }

    public boolean isTempModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempModeDirty();
        }
        return this.tempmodeDirtyFlag;
    }

    public void resetTempMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempMode();
            return;
        }
        this.tempmodeDirtyFlag = false;
        this.tempmode = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
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

    public void setViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam = string;
        this.viewparamDirtyFlag = true;
    }

    public String getViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam();
        }
        return this.viewparam;
    }

    public boolean isViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamDirty();
        }
        return this.viewparamDirtyFlag;
    }

    public void resetViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam();
            return;
        }
        this.viewparamDirtyFlag = false;
        this.viewparam = null;
    }

    public void setViewParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam10(n);
            return;
        }
        this.viewparam10 = n;
        this.viewparam10DirtyFlag = true;
    }

    public Integer getViewParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam10();
        }
        return this.viewparam10;
    }

    public boolean isViewParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam10Dirty();
        }
        return this.viewparam10DirtyFlag;
    }

    public void resetViewParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam10();
            return;
        }
        this.viewparam10DirtyFlag = false;
        this.viewparam10 = null;
    }

    public void setViewParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam11(n);
            return;
        }
        this.viewparam11 = n;
        this.viewparam11DirtyFlag = true;
    }

    public Integer getViewParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam11();
        }
        return this.viewparam11;
    }

    public boolean isViewParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam11Dirty();
        }
        return this.viewparam11DirtyFlag;
    }

    public void resetViewParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam11();
            return;
        }
        this.viewparam11DirtyFlag = false;
        this.viewparam11 = null;
    }

    public void setViewParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam12(n);
            return;
        }
        this.viewparam12 = n;
        this.viewparam12DirtyFlag = true;
    }

    public Integer getViewParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam12();
        }
        return this.viewparam12;
    }

    public boolean isViewParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam12Dirty();
        }
        return this.viewparam12DirtyFlag;
    }

    public void resetViewParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam12();
            return;
        }
        this.viewparam12DirtyFlag = false;
        this.viewparam12 = null;
    }

    public void setViewParam13(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam13(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam13 = string;
        this.viewparam13DirtyFlag = true;
    }

    public String getViewParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam13();
        }
        return this.viewparam13;
    }

    public boolean isViewParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam13Dirty();
        }
        return this.viewparam13DirtyFlag;
    }

    public void resetViewParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam13();
            return;
        }
        this.viewparam13DirtyFlag = false;
        this.viewparam13 = null;
    }

    public void setViewParam14(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam14(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam14 = string;
        this.viewparam14DirtyFlag = true;
    }

    public String getViewParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam14();
        }
        return this.viewparam14;
    }

    public boolean isViewParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam14Dirty();
        }
        return this.viewparam14DirtyFlag;
    }

    public void resetViewParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam14();
            return;
        }
        this.viewparam14DirtyFlag = false;
        this.viewparam14 = null;
    }

    public void setViewParam15(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam15(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam15 = string;
        this.viewparam15DirtyFlag = true;
    }

    public String getViewParam15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam15();
        }
        return this.viewparam15;
    }

    public boolean isViewParam15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam15Dirty();
        }
        return this.viewparam15DirtyFlag;
    }

    public void resetViewParam15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam15();
            return;
        }
        this.viewparam15DirtyFlag = false;
        this.viewparam15 = null;
    }

    public void setViewParam16(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam16(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam16 = string;
        this.viewparam16DirtyFlag = true;
    }

    public String getViewParam16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam16();
        }
        return this.viewparam16;
    }

    public boolean isViewParam16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam16Dirty();
        }
        return this.viewparam16DirtyFlag;
    }

    public void resetViewParam16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam16();
            return;
        }
        this.viewparam16DirtyFlag = false;
        this.viewparam16 = null;
    }

    public void setViewParam17(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam17(n);
            return;
        }
        this.viewparam17 = n;
        this.viewparam17DirtyFlag = true;
    }

    public Integer getViewParam17() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam17();
        }
        return this.viewparam17;
    }

    public boolean isViewParam17Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam17Dirty();
        }
        return this.viewparam17DirtyFlag;
    }

    public void resetViewParam17() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam17();
            return;
        }
        this.viewparam17DirtyFlag = false;
        this.viewparam17 = null;
    }

    public void setViewParam18(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam18(n);
            return;
        }
        this.viewparam18 = n;
        this.viewparam18DirtyFlag = true;
    }

    public Integer getViewParam18() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam18();
        }
        return this.viewparam18;
    }

    public boolean isViewParam18Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam18Dirty();
        }
        return this.viewparam18DirtyFlag;
    }

    public void resetViewParam18() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam18();
            return;
        }
        this.viewparam18DirtyFlag = false;
        this.viewparam18 = null;
    }

    public void setViewParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam2 = string;
        this.viewparam2DirtyFlag = true;
    }

    public String getViewParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam2();
        }
        return this.viewparam2;
    }

    public boolean isViewParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam2Dirty();
        }
        return this.viewparam2DirtyFlag;
    }

    public void resetViewParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam2();
            return;
        }
        this.viewparam2DirtyFlag = false;
        this.viewparam2 = null;
    }

    public void setViewParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam3(n);
            return;
        }
        this.viewparam3 = n;
        this.viewparam3DirtyFlag = true;
    }

    public Integer getViewParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam3();
        }
        return this.viewparam3;
    }

    public boolean isViewParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam3Dirty();
        }
        return this.viewparam3DirtyFlag;
    }

    public void resetViewParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam3();
            return;
        }
        this.viewparam3DirtyFlag = false;
        this.viewparam3 = null;
    }

    public void setViewParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam4(n);
            return;
        }
        this.viewparam4 = n;
        this.viewparam4DirtyFlag = true;
    }

    public Integer getViewParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam4();
        }
        return this.viewparam4;
    }

    public boolean isViewParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam4Dirty();
        }
        return this.viewparam4DirtyFlag;
    }

    public void resetViewParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam4();
            return;
        }
        this.viewparam4DirtyFlag = false;
        this.viewparam4 = null;
    }

    public void setViewParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam5(n);
            return;
        }
        this.viewparam5 = n;
        this.viewparam5DirtyFlag = true;
    }

    public Integer getViewParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam5();
        }
        return this.viewparam5;
    }

    public boolean isViewParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam5Dirty();
        }
        return this.viewparam5DirtyFlag;
    }

    public void resetViewParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam5();
            return;
        }
        this.viewparam5DirtyFlag = false;
        this.viewparam5 = null;
    }

    public void setViewParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam6(n);
            return;
        }
        this.viewparam6 = n;
        this.viewparam6DirtyFlag = true;
    }

    public Integer getViewParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam6();
        }
        return this.viewparam6;
    }

    public boolean isViewParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam6Dirty();
        }
        return this.viewparam6DirtyFlag;
    }

    public void resetViewParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam6();
            return;
        }
        this.viewparam6DirtyFlag = false;
        this.viewparam6 = null;
    }

    public void setViewParam7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam7 = string;
        this.viewparam7DirtyFlag = true;
    }

    public String getViewParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam7();
        }
        return this.viewparam7;
    }

    public boolean isViewParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam7Dirty();
        }
        return this.viewparam7DirtyFlag;
    }

    public void resetViewParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam7();
            return;
        }
        this.viewparam7DirtyFlag = false;
        this.viewparam7 = null;
    }

    public void setViewParam8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparam8 = string;
        this.viewparam8DirtyFlag = true;
    }

    public String getViewParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam8();
        }
        return this.viewparam8;
    }

    public boolean isViewParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam8Dirty();
        }
        return this.viewparam8DirtyFlag;
    }

    public void resetViewParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam8();
            return;
        }
        this.viewparam8DirtyFlag = false;
        this.viewparam8 = null;
    }

    public void setViewParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParam9(n);
            return;
        }
        this.viewparam9 = n;
        this.viewparam9DirtyFlag = true;
    }

    public Integer getViewParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParam9();
        }
        return this.viewparam9;
    }

    public boolean isViewParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParam9Dirty();
        }
        return this.viewparam9DirtyFlag;
    }

    public void resetViewParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParam9();
            return;
        }
        this.viewparam9DirtyFlag = false;
        this.viewparam9 = null;
    }

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    public void setViewSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewsn = string;
        this.viewsnDirtyFlag = true;
    }

    public String getViewSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewSN();
        }
        return this.viewsn;
    }

    public boolean isViewSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewSNDirty();
        }
        return this.viewsnDirtyFlag;
    }

    public void resetViewSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewSN();
            return;
        }
        this.viewsnDirtyFlag = false;
        this.viewsn = null;
    }

    public void setWFViewParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam(n);
            return;
        }
        this.wfviewparam = n;
        this.wfviewparamDirtyFlag = true;
    }

    public Integer getWFViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam();
        }
        return this.wfviewparam;
    }

    public boolean isWFViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParamDirty();
        }
        return this.wfviewparamDirtyFlag;
    }

    public void resetWFViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam();
            return;
        }
        this.wfviewparamDirtyFlag = false;
        this.wfviewparam = null;
    }

    public void setWFViewParam2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam2(n);
            return;
        }
        this.wfviewparam2 = n;
        this.wfviewparam2DirtyFlag = true;
    }

    public Integer getWFViewParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam2();
        }
        return this.wfviewparam2;
    }

    public boolean isWFViewParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam2Dirty();
        }
        return this.wfviewparam2DirtyFlag;
    }

    public void resetWFViewParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam2();
            return;
        }
        this.wfviewparam2DirtyFlag = false;
        this.wfviewparam2 = null;
    }

    public void setWFViewParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfviewparam3 = string;
        this.wfviewparam3DirtyFlag = true;
    }

    public String getWFViewParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam3();
        }
        return this.wfviewparam3;
    }

    public boolean isWFViewParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam3Dirty();
        }
        return this.wfviewparam3DirtyFlag;
    }

    public void resetWFViewParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam3();
            return;
        }
        this.wfviewparam3DirtyFlag = false;
        this.wfviewparam3 = null;
    }

    public void setWFViewParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFViewParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfviewparam4 = string;
        this.wfviewparam4DirtyFlag = true;
    }

    public String getWFViewParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFViewParam4();
        }
        return this.wfviewparam4;
    }

    public boolean isWFViewParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFViewParam4Dirty();
        }
        return this.wfviewparam4DirtyFlag;
    }

    public void resetWFViewParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFViewParam4();
            return;
        }
        this.wfviewparam4DirtyFlag = false;
        this.wfviewparam4 = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSDEViewBaseBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewBaseBase pSDEViewBaseBase) {
        pSDEViewBaseBase.resetAccUserMode();
        pSDEViewBaseBase.resetBottomInfo();
        pSDEViewBaseBase.resetCapPSLanResId();
        pSDEViewBaseBase.resetCapPSLanResName();
        pSDEViewBaseBase.resetCaption();
        pSDEViewBaseBase.resetCodeName();
        pSDEViewBaseBase.resetCreateDate();
        pSDEViewBaseBase.resetCreateMan();
        pSDEViewBaseBase.resetDEViewTag();
        pSDEViewBaseBase.resetDEViewTag2();
        pSDEViewBaseBase.resetDEViewTag3();
        pSDEViewBaseBase.resetDEViewTag4();
        pSDEViewBaseBase.resetDynaModelFlag();
        pSDEViewBaseBase.resetDyncMode();
        pSDEViewBaseBase.resetEnableViewActions();
        pSDEViewBaseBase.resetGroupPSCodeListId();
        pSDEViewBaseBase.resetGroupPSCodeListName();
        pSDEViewBaseBase.resetHeaderInfo();
        pSDEViewBaseBase.resetHeight();
        pSDEViewBaseBase.resetLayoutPanelMode();
        pSDEViewBaseBase.resetLoadDefault();
        pSDEViewBaseBase.resetLockFlag();
        pSDEViewBaseBase.resetMemo();
        pSDEViewBaseBase.resetModelState();
        pSDEViewBaseBase.resetOpenMode();
        pSDEViewBaseBase.resetPDTParamPre();
        pSDEViewBaseBase.resetPDVTParam();
        pSDEViewBaseBase.resetPredefinedViewType();
        pSDEViewBaseBase.resetPSACHandlerId();
        pSDEViewBaseBase.resetPSACHandlerName();
        pSDEViewBaseBase.resetPSAppViewCnt();
        pSDEViewBaseBase.resetPSAppViewsCnt();
        pSDEViewBaseBase.resetPSCtrlLogicGroupId();
        pSDEViewBaseBase.resetPSCtrlLogicGroupName();
        pSDEViewBaseBase.resetPSDEAWGroupId();
        pSDEViewBaseBase.resetPSDEAWGroupName();
        pSDEViewBaseBase.resetPSDEId();
        pSDEViewBaseBase.resetPSDEMainStateId();
        pSDEViewBaseBase.resetPSDEMainStateName();
        pSDEViewBaseBase.resetPSDEName();
        pSDEViewBaseBase.resetPSDERId();
        pSDEViewBaseBase.resetPSDERName();
        pSDEViewBaseBase.resetPSDEViewBaseId();
        pSDEViewBaseBase.resetPSDEViewBaseName();
        pSDEViewBaseBase.resetPSDEViewBaseType();
        pSDEViewBaseBase.resetPSDynaDEViewTemplId();
        pSDEViewBaseBase.resetPSDynaDEViewTemplName();
        pSDEViewBaseBase.resetPSDynaInstId();
        pSDEViewBaseBase.resetPSHelpModuleId();
        pSDEViewBaseBase.resetPSHelpModuleName();
        pSDEViewBaseBase.resetPSSubViewTypeId();
        pSDEViewBaseBase.resetPSSubViewTypeName();
        pSDEViewBaseBase.resetPSSysCounterId();
        pSDEViewBaseBase.resetPSSysCounterName();
        pSDEViewBaseBase.resetPSSysCssId();
        pSDEViewBaseBase.resetPSSysCssName();
        pSDEViewBaseBase.resetPSSysDynaModelId();
        pSDEViewBaseBase.resetPSSysDynaModelName();
        pSDEViewBaseBase.resetPSSysImageId();
        pSDEViewBaseBase.resetPSSysImageName();
        pSDEViewBaseBase.resetPSSysPFPluginId();
        pSDEViewBaseBase.resetPSSysPFPluginName();
        pSDEViewBaseBase.resetPSSysReqItemId();
        pSDEViewBaseBase.resetPSSysReqItemName();
        pSDEViewBaseBase.resetPSSystemId();
        pSDEViewBaseBase.resetPSSystemName();
        pSDEViewBaseBase.resetPSSysUniResId();
        pSDEViewBaseBase.resetPSSysUniResName();
        pSDEViewBaseBase.resetPSSysViewPanelId();
        pSDEViewBaseBase.resetPSSysViewPanelName();
        pSDEViewBaseBase.resetPSViewEngineId();
        pSDEViewBaseBase.resetPSViewEngineName();
        pSDEViewBaseBase.resetPSViewMsgGroupId();
        pSDEViewBaseBase.resetPSViewMsgGroupName();
        pSDEViewBaseBase.resetPSVTStyleId();
        pSDEViewBaseBase.resetPSVTStyleName();
        pSDEViewBaseBase.resetPSWFDEId();
        pSDEViewBaseBase.resetPSWFDEName();
        pSDEViewBaseBase.resetPSWFId();
        pSDEViewBaseBase.resetPSWFVersionId();
        pSDEViewBaseBase.resetPSWFVersionName();
        pSDEViewBaseBase.resetReadOnlyMode();
        pSDEViewBaseBase.resetShowCaptionBar();
        pSDEViewBaseBase.resetSRFSysPub();
        pSDEViewBaseBase.resetSubCapPSLanResId();
        pSDEViewBaseBase.resetSubCapPSLanResName();
        pSDEViewBaseBase.resetSubCaption();
        pSDEViewBaseBase.resetTempMode();
        pSDEViewBaseBase.resetTitle();
        pSDEViewBaseBase.resetTitlePSLanResId();
        pSDEViewBaseBase.resetTitlePSLanResName();
        pSDEViewBaseBase.resetToDoTask();
        pSDEViewBaseBase.resetUpdateDate();
        pSDEViewBaseBase.resetUpdateMan();
        pSDEViewBaseBase.resetUserData();
        pSDEViewBaseBase.resetUserData2();
        pSDEViewBaseBase.resetUserParams();
        pSDEViewBaseBase.resetViewActions();
        pSDEViewBaseBase.resetViewModel();
        pSDEViewBaseBase.resetViewParam();
        pSDEViewBaseBase.resetViewParam10();
        pSDEViewBaseBase.resetViewParam11();
        pSDEViewBaseBase.resetViewParam12();
        pSDEViewBaseBase.resetViewParam13();
        pSDEViewBaseBase.resetViewParam14();
        pSDEViewBaseBase.resetViewParam15();
        pSDEViewBaseBase.resetViewParam16();
        pSDEViewBaseBase.resetViewParam17();
        pSDEViewBaseBase.resetViewParam18();
        pSDEViewBaseBase.resetViewParam2();
        pSDEViewBaseBase.resetViewParam3();
        pSDEViewBaseBase.resetViewParam4();
        pSDEViewBaseBase.resetViewParam5();
        pSDEViewBaseBase.resetViewParam6();
        pSDEViewBaseBase.resetViewParam7();
        pSDEViewBaseBase.resetViewParam8();
        pSDEViewBaseBase.resetViewParam9();
        pSDEViewBaseBase.resetViewParams();
        pSDEViewBaseBase.resetViewSN();
        pSDEViewBaseBase.resetWFViewParam();
        pSDEViewBaseBase.resetWFViewParam2();
        pSDEViewBaseBase.resetWFViewParam3();
        pSDEViewBaseBase.resetWFViewParam4();
        pSDEViewBaseBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccUserModeDirty()) {
            hashMap.put(FIELD_ACCUSERMODE, this.getAccUserMode());
        }
        if (!bl || this.isBottomInfoDirty()) {
            hashMap.put(FIELD_BOTTOMINFO, this.getBottomInfo());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEViewTagDirty()) {
            hashMap.put(FIELD_DEVIEWTAG, this.getDEViewTag());
        }
        if (!bl || this.isDEViewTag2Dirty()) {
            hashMap.put(FIELD_DEVIEWTAG2, this.getDEViewTag2());
        }
        if (!bl || this.isDEViewTag3Dirty()) {
            hashMap.put(FIELD_DEVIEWTAG3, this.getDEViewTag3());
        }
        if (!bl || this.isDEViewTag4Dirty()) {
            hashMap.put(FIELD_DEVIEWTAG4, this.getDEViewTag4());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDyncModeDirty()) {
            hashMap.put(FIELD_DYNCMODE, this.getDyncMode());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isGroupPSCodeListIdDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTID, this.getGroupPSCodeListId());
        }
        if (!bl || this.isGroupPSCodeListNameDirty()) {
            hashMap.put(FIELD_GROUPPSCODELISTNAME, this.getGroupPSCodeListName());
        }
        if (!bl || this.isHeaderInfoDirty()) {
            hashMap.put(FIELD_HEADERINFO, this.getHeaderInfo());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isLayoutPanelModeDirty()) {
            hashMap.put(FIELD_LAYOUTPANELMODE, this.getLayoutPanelMode());
        }
        if (!bl || this.isLoadDefaultDirty()) {
            hashMap.put(FIELD_LOADDEFAULT, this.getLoadDefault());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isOpenModeDirty()) {
            hashMap.put(FIELD_OPENMODE, this.getOpenMode());
        }
        if (!bl || this.isPDTParamPreDirty()) {
            hashMap.put(FIELD_PDTPARAMPRE, this.getPDTParamPre());
        }
        if (!bl || this.isPDVTParamDirty()) {
            hashMap.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bl || this.isPredefinedViewTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSAppViewCntDirty()) {
            hashMap.put(FIELD_PSAPPVIEWCNT, this.getPSAppViewCnt());
        }
        if (!bl || this.isPSAppViewsCntDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSCNT, this.getPSAppViewsCnt());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSDEAWGroupIdDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPID, this.getPSDEAWGroupId());
        }
        if (!bl || this.isPSDEAWGroupNameDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPNAME, this.getPSDEAWGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewBaseTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASETYPE, this.getPSDEViewBaseType());
        }
        if (!bl || this.isPSDynaDEViewTemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLID, this.getPSDynaDEViewTemplId());
        }
        if (!bl || this.isPSDynaDEViewTemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, this.getPSDynaDEViewTemplName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSHelpModuleIdDirty()) {
            hashMap.put(FIELD_PSHELPMODULEID, this.getPSHelpModuleId());
        }
        if (!bl || this.isPSHelpModuleNameDirty()) {
            hashMap.put(FIELD_PSHELPMODULENAME, this.getPSHelpModuleName());
        }
        if (!bl || this.isPSSubViewTypeIdDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPEID, this.getPSSubViewTypeId());
        }
        if (!bl || this.isPSSubViewTypeNameDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPENAME, this.getPSSubViewTypeName());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
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
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isPSViewEngineIdDirty()) {
            hashMap.put(FIELD_PSVIEWENGINEID, this.getPSViewEngineId());
        }
        if (!bl || this.isPSViewEngineNameDirty()) {
            hashMap.put(FIELD_PSVIEWENGINENAME, this.getPSViewEngineName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isPSVTStyleIdDirty()) {
            hashMap.put(FIELD_PSVTSTYLEID, this.getPSVTStyleId());
        }
        if (!bl || this.isPSVTStyleNameDirty()) {
            hashMap.put(FIELD_PSVTSTYLENAME, this.getPSVTStyleName());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFDENameDirty()) {
            hashMap.put(FIELD_PSWFDENAME, this.getPSWFDEName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isShowCaptionBarDirty()) {
            hashMap.put(FIELD_SHOWCAPTIONBAR, this.getShowCaptionBar());
        }
        if (!bl || this.isSRFSysPubDirty()) {
            hashMap.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bl || this.isSubCapPSLanResIdDirty()) {
            hashMap.put(FIELD_SUBCAPPSLANRESID, this.getSubCapPSLanResId());
        }
        if (!bl || this.isSubCapPSLanResNameDirty()) {
            hashMap.put(FIELD_SUBCAPPSLANRESNAME, this.getSubCapPSLanResName());
        }
        if (!bl || this.isSubCaptionDirty()) {
            hashMap.put(FIELD_SUBCAPTION, this.getSubCaption());
        }
        if (!bl || this.isTempModeDirty()) {
            hashMap.put(FIELD_TEMPMODE, this.getTempMode());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
        }
        if (!bl || this.isViewModelDirty()) {
            hashMap.put(FIELD_VIEWMODEL, this.getViewModel());
        }
        if (!bl || this.isViewParamDirty()) {
            hashMap.put(FIELD_VIEWPARAM, this.getViewParam());
        }
        if (!bl || this.isViewParam10Dirty()) {
            hashMap.put(FIELD_VIEWPARAM10, this.getViewParam10());
        }
        if (!bl || this.isViewParam11Dirty()) {
            hashMap.put(FIELD_VIEWPARAM11, this.getViewParam11());
        }
        if (!bl || this.isViewParam12Dirty()) {
            hashMap.put(FIELD_VIEWPARAM12, this.getViewParam12());
        }
        if (!bl || this.isViewParam13Dirty()) {
            hashMap.put(FIELD_VIEWPARAM13, this.getViewParam13());
        }
        if (!bl || this.isViewParam14Dirty()) {
            hashMap.put(FIELD_VIEWPARAM14, this.getViewParam14());
        }
        if (!bl || this.isViewParam15Dirty()) {
            hashMap.put(FIELD_VIEWPARAM15, this.getViewParam15());
        }
        if (!bl || this.isViewParam16Dirty()) {
            hashMap.put(FIELD_VIEWPARAM16, this.getViewParam16());
        }
        if (!bl || this.isViewParam17Dirty()) {
            hashMap.put(FIELD_VIEWPARAM17, this.getViewParam17());
        }
        if (!bl || this.isViewParam18Dirty()) {
            hashMap.put(FIELD_VIEWPARAM18, this.getViewParam18());
        }
        if (!bl || this.isViewParam2Dirty()) {
            hashMap.put(FIELD_VIEWPARAM2, this.getViewParam2());
        }
        if (!bl || this.isViewParam3Dirty()) {
            hashMap.put(FIELD_VIEWPARAM3, this.getViewParam3());
        }
        if (!bl || this.isViewParam4Dirty()) {
            hashMap.put(FIELD_VIEWPARAM4, this.getViewParam4());
        }
        if (!bl || this.isViewParam5Dirty()) {
            hashMap.put(FIELD_VIEWPARAM5, this.getViewParam5());
        }
        if (!bl || this.isViewParam6Dirty()) {
            hashMap.put(FIELD_VIEWPARAM6, this.getViewParam6());
        }
        if (!bl || this.isViewParam7Dirty()) {
            hashMap.put(FIELD_VIEWPARAM7, this.getViewParam7());
        }
        if (!bl || this.isViewParam8Dirty()) {
            hashMap.put(FIELD_VIEWPARAM8, this.getViewParam8());
        }
        if (!bl || this.isViewParam9Dirty()) {
            hashMap.put(FIELD_VIEWPARAM9, this.getViewParam9());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
        }
        if (!bl || this.isViewSNDirty()) {
            hashMap.put(FIELD_VIEWSN, this.getViewSN());
        }
        if (!bl || this.isWFViewParamDirty()) {
            hashMap.put(FIELD_WFVIEWPARAM, this.getWFViewParam());
        }
        if (!bl || this.isWFViewParam2Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM2, this.getWFViewParam2());
        }
        if (!bl || this.isWFViewParam3Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM3, this.getWFViewParam3());
        }
        if (!bl || this.isWFViewParam4Dirty()) {
            hashMap.put(FIELD_WFVIEWPARAM4, this.getWFViewParam4());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSDEViewBaseBase.get(this, n);
    }

    private static Object get(PSDEViewBaseBase pSDEViewBaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseBase.getAccUserMode();
            }
            case 1: {
                return pSDEViewBaseBase.getBottomInfo();
            }
            case 2: {
                return pSDEViewBaseBase.getCapPSLanResId();
            }
            case 3: {
                return pSDEViewBaseBase.getCapPSLanResName();
            }
            case 4: {
                return pSDEViewBaseBase.getCaption();
            }
            case 5: {
                return pSDEViewBaseBase.getCodeName();
            }
            case 6: {
                return pSDEViewBaseBase.getCreateDate();
            }
            case 7: {
                return pSDEViewBaseBase.getCreateMan();
            }
            case 8: {
                return pSDEViewBaseBase.getDEViewTag();
            }
            case 9: {
                return pSDEViewBaseBase.getDEViewTag2();
            }
            case 10: {
                return pSDEViewBaseBase.getDEViewTag3();
            }
            case 11: {
                return pSDEViewBaseBase.getDEViewTag4();
            }
            case 12: {
                return pSDEViewBaseBase.getDynaModelFlag();
            }
            case 13: {
                return pSDEViewBaseBase.getDyncMode();
            }
            case 14: {
                return pSDEViewBaseBase.getEnableViewActions();
            }
            case 15: {
                return pSDEViewBaseBase.getGroupPSCodeListId();
            }
            case 16: {
                return pSDEViewBaseBase.getGroupPSCodeListName();
            }
            case 17: {
                return pSDEViewBaseBase.getHeaderInfo();
            }
            case 18: {
                return pSDEViewBaseBase.getHeight();
            }
            case 19: {
                return pSDEViewBaseBase.getLayoutPanelMode();
            }
            case 20: {
                return pSDEViewBaseBase.getLoadDefault();
            }
            case 21: {
                return pSDEViewBaseBase.getLockFlag();
            }
            case 22: {
                return pSDEViewBaseBase.getMemo();
            }
            case 23: {
                return pSDEViewBaseBase.getModelState();
            }
            case 24: {
                return pSDEViewBaseBase.getOpenMode();
            }
            case 25: {
                return pSDEViewBaseBase.getPDTParamPre();
            }
            case 26: {
                return pSDEViewBaseBase.getPDVTParam();
            }
            case 27: {
                return pSDEViewBaseBase.getPredefinedViewType();
            }
            case 28: {
                return pSDEViewBaseBase.getPSACHandlerId();
            }
            case 29: {
                return pSDEViewBaseBase.getPSACHandlerName();
            }
            case 30: {
                return pSDEViewBaseBase.getPSAppViewCnt();
            }
            case 31: {
                return pSDEViewBaseBase.getPSAppViewsCnt();
            }
            case 32: {
                return pSDEViewBaseBase.getPSCtrlLogicGroupId();
            }
            case 33: {
                return pSDEViewBaseBase.getPSCtrlLogicGroupName();
            }
            case 34: {
                return pSDEViewBaseBase.getPSDEAWGroupId();
            }
            case 35: {
                return pSDEViewBaseBase.getPSDEAWGroupName();
            }
            case 36: {
                return pSDEViewBaseBase.getPSDEId();
            }
            case 37: {
                return pSDEViewBaseBase.getPSDEMainStateId();
            }
            case 38: {
                return pSDEViewBaseBase.getPSDEMainStateName();
            }
            case 39: {
                return pSDEViewBaseBase.getPSDEName();
            }
            case 40: {
                return pSDEViewBaseBase.getPSDERId();
            }
            case 41: {
                return pSDEViewBaseBase.getPSDERName();
            }
            case 42: {
                return pSDEViewBaseBase.getPSDEViewBaseId();
            }
            case 43: {
                return pSDEViewBaseBase.getPSDEViewBaseName();
            }
            case 44: {
                return pSDEViewBaseBase.getPSDEViewBaseType();
            }
            case 45: {
                return pSDEViewBaseBase.getPSDynaDEViewTemplId();
            }
            case 46: {
                return pSDEViewBaseBase.getPSDynaDEViewTemplName();
            }
            case 47: {
                return pSDEViewBaseBase.getPSDynaInstId();
            }
            case 48: {
                return pSDEViewBaseBase.getPSHelpModuleId();
            }
            case 49: {
                return pSDEViewBaseBase.getPSHelpModuleName();
            }
            case 50: {
                return pSDEViewBaseBase.getPSSubViewTypeId();
            }
            case 51: {
                return pSDEViewBaseBase.getPSSubViewTypeName();
            }
            case 52: {
                return pSDEViewBaseBase.getPSSysCounterId();
            }
            case 53: {
                return pSDEViewBaseBase.getPSSysCounterName();
            }
            case 54: {
                return pSDEViewBaseBase.getPSSysCssId();
            }
            case 55: {
                return pSDEViewBaseBase.getPSSysCssName();
            }
            case 56: {
                return pSDEViewBaseBase.getPSSysDynaModelId();
            }
            case 57: {
                return pSDEViewBaseBase.getPSSysDynaModelName();
            }
            case 58: {
                return pSDEViewBaseBase.getPSSysImageId();
            }
            case 59: {
                return pSDEViewBaseBase.getPSSysImageName();
            }
            case 60: {
                return pSDEViewBaseBase.getPSSysPFPluginId();
            }
            case 61: {
                return pSDEViewBaseBase.getPSSysPFPluginName();
            }
            case 62: {
                return pSDEViewBaseBase.getPSSysReqItemId();
            }
            case 63: {
                return pSDEViewBaseBase.getPSSysReqItemName();
            }
            case 64: {
                return pSDEViewBaseBase.getPSSystemId();
            }
            case 65: {
                return pSDEViewBaseBase.getPSSystemName();
            }
            case 66: {
                return pSDEViewBaseBase.getPSSysUniResId();
            }
            case 67: {
                return pSDEViewBaseBase.getPSSysUniResName();
            }
            case 68: {
                return pSDEViewBaseBase.getPSSysViewPanelId();
            }
            case 69: {
                return pSDEViewBaseBase.getPSSysViewPanelName();
            }
            case 70: {
                return pSDEViewBaseBase.getPSViewEngineId();
            }
            case 71: {
                return pSDEViewBaseBase.getPSViewEngineName();
            }
            case 72: {
                return pSDEViewBaseBase.getPSViewMsgGroupId();
            }
            case 73: {
                return pSDEViewBaseBase.getPSViewMsgGroupName();
            }
            case 74: {
                return pSDEViewBaseBase.getPSVTStyleId();
            }
            case 75: {
                return pSDEViewBaseBase.getPSVTStyleName();
            }
            case 76: {
                return pSDEViewBaseBase.getPSWFDEId();
            }
            case 77: {
                return pSDEViewBaseBase.getPSWFDEName();
            }
            case 78: {
                return pSDEViewBaseBase.getPSWFId();
            }
            case 79: {
                return pSDEViewBaseBase.getPSWFVersionId();
            }
            case 80: {
                return pSDEViewBaseBase.getPSWFVersionName();
            }
            case 81: {
                return pSDEViewBaseBase.getReadOnlyMode();
            }
            case 82: {
                return pSDEViewBaseBase.getShowCaptionBar();
            }
            case 83: {
                return pSDEViewBaseBase.getSRFSysPub();
            }
            case 84: {
                return pSDEViewBaseBase.getSubCapPSLanResId();
            }
            case 85: {
                return pSDEViewBaseBase.getSubCapPSLanResName();
            }
            case 86: {
                return pSDEViewBaseBase.getSubCaption();
            }
            case 87: {
                return pSDEViewBaseBase.getTempMode();
            }
            case 88: {
                return pSDEViewBaseBase.getTitle();
            }
            case 89: {
                return pSDEViewBaseBase.getTitlePSLanResId();
            }
            case 90: {
                return pSDEViewBaseBase.getTitlePSLanResName();
            }
            case 91: {
                return pSDEViewBaseBase.getToDoTask();
            }
            case 92: {
                return pSDEViewBaseBase.getUpdateDate();
            }
            case 93: {
                return pSDEViewBaseBase.getUpdateMan();
            }
            case 94: {
                return pSDEViewBaseBase.getUserData();
            }
            case 95: {
                return pSDEViewBaseBase.getUserData2();
            }
            case 96: {
                return pSDEViewBaseBase.getUserParams();
            }
            case 97: {
                return pSDEViewBaseBase.getViewActions();
            }
            case 98: {
                return pSDEViewBaseBase.getViewModel();
            }
            case 99: {
                return pSDEViewBaseBase.getViewParam();
            }
            case 100: {
                return pSDEViewBaseBase.getViewParam10();
            }
            case 101: {
                return pSDEViewBaseBase.getViewParam11();
            }
            case 102: {
                return pSDEViewBaseBase.getViewParam12();
            }
            case 103: {
                return pSDEViewBaseBase.getViewParam13();
            }
            case 104: {
                return pSDEViewBaseBase.getViewParam14();
            }
            case 105: {
                return pSDEViewBaseBase.getViewParam15();
            }
            case 106: {
                return pSDEViewBaseBase.getViewParam16();
            }
            case 107: {
                return pSDEViewBaseBase.getViewParam17();
            }
            case 108: {
                return pSDEViewBaseBase.getViewParam18();
            }
            case 109: {
                return pSDEViewBaseBase.getViewParam2();
            }
            case 110: {
                return pSDEViewBaseBase.getViewParam3();
            }
            case 111: {
                return pSDEViewBaseBase.getViewParam4();
            }
            case 112: {
                return pSDEViewBaseBase.getViewParam5();
            }
            case 113: {
                return pSDEViewBaseBase.getViewParam6();
            }
            case 114: {
                return pSDEViewBaseBase.getViewParam7();
            }
            case 115: {
                return pSDEViewBaseBase.getViewParam8();
            }
            case 116: {
                return pSDEViewBaseBase.getViewParam9();
            }
            case 117: {
                return pSDEViewBaseBase.getViewParams();
            }
            case 118: {
                return pSDEViewBaseBase.getViewSN();
            }
            case 119: {
                return pSDEViewBaseBase.getWFViewParam();
            }
            case 120: {
                return pSDEViewBaseBase.getWFViewParam2();
            }
            case 121: {
                return pSDEViewBaseBase.getWFViewParam3();
            }
            case 122: {
                return pSDEViewBaseBase.getWFViewParam4();
            }
            case 123: {
                return pSDEViewBaseBase.getWidth();
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
        PSDEViewBaseBase.set(this, n, object);
    }

    private static void set(PSDEViewBaseBase pSDEViewBaseBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewBaseBase.setAccUserMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewBaseBase.setBottomInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewBaseBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewBaseBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewBaseBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewBaseBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewBaseBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewBaseBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewBaseBase.setDEViewTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewBaseBase.setDEViewTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewBaseBase.setDEViewTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewBaseBase.setDEViewTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewBaseBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewBaseBase.setDyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewBaseBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEViewBaseBase.setGroupPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEViewBaseBase.setGroupPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEViewBaseBase.setHeaderInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEViewBaseBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEViewBaseBase.setLayoutPanelMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEViewBaseBase.setLoadDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEViewBaseBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEViewBaseBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEViewBaseBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEViewBaseBase.setOpenMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEViewBaseBase.setPDTParamPre(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEViewBaseBase.setPDVTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEViewBaseBase.setPredefinedViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEViewBaseBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEViewBaseBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEViewBaseBase.setPSAppViewCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEViewBaseBase.setPSAppViewsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEViewBaseBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEViewBaseBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEViewBaseBase.setPSDEAWGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEViewBaseBase.setPSDEAWGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEViewBaseBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEViewBaseBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEViewBaseBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEViewBaseBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEViewBaseBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEViewBaseBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEViewBaseBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEViewBaseBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEViewBaseBase.setPSDEViewBaseType(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEViewBaseBase.setPSDynaDEViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEViewBaseBase.setPSDynaDEViewTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEViewBaseBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEViewBaseBase.setPSHelpModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEViewBaseBase.setPSHelpModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEViewBaseBase.setPSSubViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEViewBaseBase.setPSSubViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEViewBaseBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEViewBaseBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEViewBaseBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEViewBaseBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEViewBaseBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEViewBaseBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEViewBaseBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEViewBaseBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEViewBaseBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEViewBaseBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEViewBaseBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEViewBaseBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEViewBaseBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEViewBaseBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEViewBaseBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEViewBaseBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEViewBaseBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEViewBaseBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEViewBaseBase.setPSViewEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEViewBaseBase.setPSViewEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEViewBaseBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEViewBaseBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEViewBaseBase.setPSVTStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEViewBaseBase.setPSVTStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEViewBaseBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEViewBaseBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEViewBaseBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEViewBaseBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEViewBaseBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEViewBaseBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSDEViewBaseBase.setShowCaptionBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDEViewBaseBase.setSRFSysPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDEViewBaseBase.setSubCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDEViewBaseBase.setSubCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEViewBaseBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEViewBaseBase.setTempMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSDEViewBaseBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEViewBaseBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEViewBaseBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEViewBaseBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDEViewBaseBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 93: {
                pSDEViewBaseBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEViewBaseBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDEViewBaseBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEViewBaseBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEViewBaseBase.setViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 98: {
                pSDEViewBaseBase.setViewModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEViewBaseBase.setViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEViewBaseBase.setViewParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSDEViewBaseBase.setViewParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 102: {
                pSDEViewBaseBase.setViewParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 103: {
                pSDEViewBaseBase.setViewParam13(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEViewBaseBase.setViewParam14(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEViewBaseBase.setViewParam15(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEViewBaseBase.setViewParam16(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEViewBaseBase.setViewParam17(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 108: {
                pSDEViewBaseBase.setViewParam18(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 109: {
                pSDEViewBaseBase.setViewParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEViewBaseBase.setViewParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 111: {
                pSDEViewBaseBase.setViewParam4(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 112: {
                pSDEViewBaseBase.setViewParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 113: {
                pSDEViewBaseBase.setViewParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 114: {
                pSDEViewBaseBase.setViewParam7(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEViewBaseBase.setViewParam8(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDEViewBaseBase.setViewParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEViewBaseBase.setViewParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDEViewBaseBase.setViewSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDEViewBaseBase.setWFViewParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 120: {
                pSDEViewBaseBase.setWFViewParam2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 121: {
                pSDEViewBaseBase.setWFViewParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEViewBaseBase.setWFViewParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDEViewBaseBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSDEViewBaseBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewBaseBase pSDEViewBaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseBase.getAccUserMode() == null;
            }
            case 1: {
                return pSDEViewBaseBase.getBottomInfo() == null;
            }
            case 2: {
                return pSDEViewBaseBase.getCapPSLanResId() == null;
            }
            case 3: {
                return pSDEViewBaseBase.getCapPSLanResName() == null;
            }
            case 4: {
                return pSDEViewBaseBase.getCaption() == null;
            }
            case 5: {
                return pSDEViewBaseBase.getCodeName() == null;
            }
            case 6: {
                return pSDEViewBaseBase.getCreateDate() == null;
            }
            case 7: {
                return pSDEViewBaseBase.getCreateMan() == null;
            }
            case 8: {
                return pSDEViewBaseBase.getDEViewTag() == null;
            }
            case 9: {
                return pSDEViewBaseBase.getDEViewTag2() == null;
            }
            case 10: {
                return pSDEViewBaseBase.getDEViewTag3() == null;
            }
            case 11: {
                return pSDEViewBaseBase.getDEViewTag4() == null;
            }
            case 12: {
                return pSDEViewBaseBase.getDynaModelFlag() == null;
            }
            case 13: {
                return pSDEViewBaseBase.getDyncMode() == null;
            }
            case 14: {
                return pSDEViewBaseBase.getEnableViewActions() == null;
            }
            case 15: {
                return pSDEViewBaseBase.getGroupPSCodeListId() == null;
            }
            case 16: {
                return pSDEViewBaseBase.getGroupPSCodeListName() == null;
            }
            case 17: {
                return pSDEViewBaseBase.getHeaderInfo() == null;
            }
            case 18: {
                return pSDEViewBaseBase.getHeight() == null;
            }
            case 19: {
                return pSDEViewBaseBase.getLayoutPanelMode() == null;
            }
            case 20: {
                return pSDEViewBaseBase.getLoadDefault() == null;
            }
            case 21: {
                return pSDEViewBaseBase.getLockFlag() == null;
            }
            case 22: {
                return pSDEViewBaseBase.getMemo() == null;
            }
            case 23: {
                return pSDEViewBaseBase.getModelState() == null;
            }
            case 24: {
                return pSDEViewBaseBase.getOpenMode() == null;
            }
            case 25: {
                return pSDEViewBaseBase.getPDTParamPre() == null;
            }
            case 26: {
                return pSDEViewBaseBase.getPDVTParam() == null;
            }
            case 27: {
                return pSDEViewBaseBase.getPredefinedViewType() == null;
            }
            case 28: {
                return pSDEViewBaseBase.getPSACHandlerId() == null;
            }
            case 29: {
                return pSDEViewBaseBase.getPSACHandlerName() == null;
            }
            case 30: {
                return pSDEViewBaseBase.getPSAppViewCnt() == null;
            }
            case 31: {
                return pSDEViewBaseBase.getPSAppViewsCnt() == null;
            }
            case 32: {
                return pSDEViewBaseBase.getPSCtrlLogicGroupId() == null;
            }
            case 33: {
                return pSDEViewBaseBase.getPSCtrlLogicGroupName() == null;
            }
            case 34: {
                return pSDEViewBaseBase.getPSDEAWGroupId() == null;
            }
            case 35: {
                return pSDEViewBaseBase.getPSDEAWGroupName() == null;
            }
            case 36: {
                return pSDEViewBaseBase.getPSDEId() == null;
            }
            case 37: {
                return pSDEViewBaseBase.getPSDEMainStateId() == null;
            }
            case 38: {
                return pSDEViewBaseBase.getPSDEMainStateName() == null;
            }
            case 39: {
                return pSDEViewBaseBase.getPSDEName() == null;
            }
            case 40: {
                return pSDEViewBaseBase.getPSDERId() == null;
            }
            case 41: {
                return pSDEViewBaseBase.getPSDERName() == null;
            }
            case 42: {
                return pSDEViewBaseBase.getPSDEViewBaseId() == null;
            }
            case 43: {
                return pSDEViewBaseBase.getPSDEViewBaseName() == null;
            }
            case 44: {
                return pSDEViewBaseBase.getPSDEViewBaseType() == null;
            }
            case 45: {
                return pSDEViewBaseBase.getPSDynaDEViewTemplId() == null;
            }
            case 46: {
                return pSDEViewBaseBase.getPSDynaDEViewTemplName() == null;
            }
            case 47: {
                return pSDEViewBaseBase.getPSDynaInstId() == null;
            }
            case 48: {
                return pSDEViewBaseBase.getPSHelpModuleId() == null;
            }
            case 49: {
                return pSDEViewBaseBase.getPSHelpModuleName() == null;
            }
            case 50: {
                return pSDEViewBaseBase.getPSSubViewTypeId() == null;
            }
            case 51: {
                return pSDEViewBaseBase.getPSSubViewTypeName() == null;
            }
            case 52: {
                return pSDEViewBaseBase.getPSSysCounterId() == null;
            }
            case 53: {
                return pSDEViewBaseBase.getPSSysCounterName() == null;
            }
            case 54: {
                return pSDEViewBaseBase.getPSSysCssId() == null;
            }
            case 55: {
                return pSDEViewBaseBase.getPSSysCssName() == null;
            }
            case 56: {
                return pSDEViewBaseBase.getPSSysDynaModelId() == null;
            }
            case 57: {
                return pSDEViewBaseBase.getPSSysDynaModelName() == null;
            }
            case 58: {
                return pSDEViewBaseBase.getPSSysImageId() == null;
            }
            case 59: {
                return pSDEViewBaseBase.getPSSysImageName() == null;
            }
            case 60: {
                return pSDEViewBaseBase.getPSSysPFPluginId() == null;
            }
            case 61: {
                return pSDEViewBaseBase.getPSSysPFPluginName() == null;
            }
            case 62: {
                return pSDEViewBaseBase.getPSSysReqItemId() == null;
            }
            case 63: {
                return pSDEViewBaseBase.getPSSysReqItemName() == null;
            }
            case 64: {
                return pSDEViewBaseBase.getPSSystemId() == null;
            }
            case 65: {
                return pSDEViewBaseBase.getPSSystemName() == null;
            }
            case 66: {
                return pSDEViewBaseBase.getPSSysUniResId() == null;
            }
            case 67: {
                return pSDEViewBaseBase.getPSSysUniResName() == null;
            }
            case 68: {
                return pSDEViewBaseBase.getPSSysViewPanelId() == null;
            }
            case 69: {
                return pSDEViewBaseBase.getPSSysViewPanelName() == null;
            }
            case 70: {
                return pSDEViewBaseBase.getPSViewEngineId() == null;
            }
            case 71: {
                return pSDEViewBaseBase.getPSViewEngineName() == null;
            }
            case 72: {
                return pSDEViewBaseBase.getPSViewMsgGroupId() == null;
            }
            case 73: {
                return pSDEViewBaseBase.getPSViewMsgGroupName() == null;
            }
            case 74: {
                return pSDEViewBaseBase.getPSVTStyleId() == null;
            }
            case 75: {
                return pSDEViewBaseBase.getPSVTStyleName() == null;
            }
            case 76: {
                return pSDEViewBaseBase.getPSWFDEId() == null;
            }
            case 77: {
                return pSDEViewBaseBase.getPSWFDEName() == null;
            }
            case 78: {
                return pSDEViewBaseBase.getPSWFId() == null;
            }
            case 79: {
                return pSDEViewBaseBase.getPSWFVersionId() == null;
            }
            case 80: {
                return pSDEViewBaseBase.getPSWFVersionName() == null;
            }
            case 81: {
                return pSDEViewBaseBase.getReadOnlyMode() == null;
            }
            case 82: {
                return pSDEViewBaseBase.getShowCaptionBar() == null;
            }
            case 83: {
                return pSDEViewBaseBase.getSRFSysPub() == null;
            }
            case 84: {
                return pSDEViewBaseBase.getSubCapPSLanResId() == null;
            }
            case 85: {
                return pSDEViewBaseBase.getSubCapPSLanResName() == null;
            }
            case 86: {
                return pSDEViewBaseBase.getSubCaption() == null;
            }
            case 87: {
                return pSDEViewBaseBase.getTempMode() == null;
            }
            case 88: {
                return pSDEViewBaseBase.getTitle() == null;
            }
            case 89: {
                return pSDEViewBaseBase.getTitlePSLanResId() == null;
            }
            case 90: {
                return pSDEViewBaseBase.getTitlePSLanResName() == null;
            }
            case 91: {
                return pSDEViewBaseBase.getToDoTask() == null;
            }
            case 92: {
                return pSDEViewBaseBase.getUpdateDate() == null;
            }
            case 93: {
                return pSDEViewBaseBase.getUpdateMan() == null;
            }
            case 94: {
                return pSDEViewBaseBase.getUserData() == null;
            }
            case 95: {
                return pSDEViewBaseBase.getUserData2() == null;
            }
            case 96: {
                return pSDEViewBaseBase.getUserParams() == null;
            }
            case 97: {
                return pSDEViewBaseBase.getViewActions() == null;
            }
            case 98: {
                return pSDEViewBaseBase.getViewModel() == null;
            }
            case 99: {
                return pSDEViewBaseBase.getViewParam() == null;
            }
            case 100: {
                return pSDEViewBaseBase.getViewParam10() == null;
            }
            case 101: {
                return pSDEViewBaseBase.getViewParam11() == null;
            }
            case 102: {
                return pSDEViewBaseBase.getViewParam12() == null;
            }
            case 103: {
                return pSDEViewBaseBase.getViewParam13() == null;
            }
            case 104: {
                return pSDEViewBaseBase.getViewParam14() == null;
            }
            case 105: {
                return pSDEViewBaseBase.getViewParam15() == null;
            }
            case 106: {
                return pSDEViewBaseBase.getViewParam16() == null;
            }
            case 107: {
                return pSDEViewBaseBase.getViewParam17() == null;
            }
            case 108: {
                return pSDEViewBaseBase.getViewParam18() == null;
            }
            case 109: {
                return pSDEViewBaseBase.getViewParam2() == null;
            }
            case 110: {
                return pSDEViewBaseBase.getViewParam3() == null;
            }
            case 111: {
                return pSDEViewBaseBase.getViewParam4() == null;
            }
            case 112: {
                return pSDEViewBaseBase.getViewParam5() == null;
            }
            case 113: {
                return pSDEViewBaseBase.getViewParam6() == null;
            }
            case 114: {
                return pSDEViewBaseBase.getViewParam7() == null;
            }
            case 115: {
                return pSDEViewBaseBase.getViewParam8() == null;
            }
            case 116: {
                return pSDEViewBaseBase.getViewParam9() == null;
            }
            case 117: {
                return pSDEViewBaseBase.getViewParams() == null;
            }
            case 118: {
                return pSDEViewBaseBase.getViewSN() == null;
            }
            case 119: {
                return pSDEViewBaseBase.getWFViewParam() == null;
            }
            case 120: {
                return pSDEViewBaseBase.getWFViewParam2() == null;
            }
            case 121: {
                return pSDEViewBaseBase.getWFViewParam3() == null;
            }
            case 122: {
                return pSDEViewBaseBase.getWFViewParam4() == null;
            }
            case 123: {
                return pSDEViewBaseBase.getWidth() == null;
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
        return PSDEViewBaseBase.contains(this, n);
    }

    private static boolean contains(PSDEViewBaseBase pSDEViewBaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewBaseBase.isAccUserModeDirty();
            }
            case 1: {
                return pSDEViewBaseBase.isBottomInfoDirty();
            }
            case 2: {
                return pSDEViewBaseBase.isCapPSLanResIdDirty();
            }
            case 3: {
                return pSDEViewBaseBase.isCapPSLanResNameDirty();
            }
            case 4: {
                return pSDEViewBaseBase.isCaptionDirty();
            }
            case 5: {
                return pSDEViewBaseBase.isCodeNameDirty();
            }
            case 6: {
                return pSDEViewBaseBase.isCreateDateDirty();
            }
            case 7: {
                return pSDEViewBaseBase.isCreateManDirty();
            }
            case 8: {
                return pSDEViewBaseBase.isDEViewTagDirty();
            }
            case 9: {
                return pSDEViewBaseBase.isDEViewTag2Dirty();
            }
            case 10: {
                return pSDEViewBaseBase.isDEViewTag3Dirty();
            }
            case 11: {
                return pSDEViewBaseBase.isDEViewTag4Dirty();
            }
            case 12: {
                return pSDEViewBaseBase.isDynaModelFlagDirty();
            }
            case 13: {
                return pSDEViewBaseBase.isDyncModeDirty();
            }
            case 14: {
                return pSDEViewBaseBase.isEnableViewActionsDirty();
            }
            case 15: {
                return pSDEViewBaseBase.isGroupPSCodeListIdDirty();
            }
            case 16: {
                return pSDEViewBaseBase.isGroupPSCodeListNameDirty();
            }
            case 17: {
                return pSDEViewBaseBase.isHeaderInfoDirty();
            }
            case 18: {
                return pSDEViewBaseBase.isHeightDirty();
            }
            case 19: {
                return pSDEViewBaseBase.isLayoutPanelModeDirty();
            }
            case 20: {
                return pSDEViewBaseBase.isLoadDefaultDirty();
            }
            case 21: {
                return pSDEViewBaseBase.isLockFlagDirty();
            }
            case 22: {
                return pSDEViewBaseBase.isMemoDirty();
            }
            case 23: {
                return pSDEViewBaseBase.isModelStateDirty();
            }
            case 24: {
                return pSDEViewBaseBase.isOpenModeDirty();
            }
            case 25: {
                return pSDEViewBaseBase.isPDTParamPreDirty();
            }
            case 26: {
                return pSDEViewBaseBase.isPDVTParamDirty();
            }
            case 27: {
                return pSDEViewBaseBase.isPredefinedViewTypeDirty();
            }
            case 28: {
                return pSDEViewBaseBase.isPSACHandlerIdDirty();
            }
            case 29: {
                return pSDEViewBaseBase.isPSACHandlerNameDirty();
            }
            case 30: {
                return pSDEViewBaseBase.isPSAppViewCntDirty();
            }
            case 31: {
                return pSDEViewBaseBase.isPSAppViewsCntDirty();
            }
            case 32: {
                return pSDEViewBaseBase.isPSCtrlLogicGroupIdDirty();
            }
            case 33: {
                return pSDEViewBaseBase.isPSCtrlLogicGroupNameDirty();
            }
            case 34: {
                return pSDEViewBaseBase.isPSDEAWGroupIdDirty();
            }
            case 35: {
                return pSDEViewBaseBase.isPSDEAWGroupNameDirty();
            }
            case 36: {
                return pSDEViewBaseBase.isPSDEIdDirty();
            }
            case 37: {
                return pSDEViewBaseBase.isPSDEMainStateIdDirty();
            }
            case 38: {
                return pSDEViewBaseBase.isPSDEMainStateNameDirty();
            }
            case 39: {
                return pSDEViewBaseBase.isPSDENameDirty();
            }
            case 40: {
                return pSDEViewBaseBase.isPSDERIdDirty();
            }
            case 41: {
                return pSDEViewBaseBase.isPSDERNameDirty();
            }
            case 42: {
                return pSDEViewBaseBase.isPSDEViewBaseIdDirty();
            }
            case 43: {
                return pSDEViewBaseBase.isPSDEViewBaseNameDirty();
            }
            case 44: {
                return pSDEViewBaseBase.isPSDEViewBaseTypeDirty();
            }
            case 45: {
                return pSDEViewBaseBase.isPSDynaDEViewTemplIdDirty();
            }
            case 46: {
                return pSDEViewBaseBase.isPSDynaDEViewTemplNameDirty();
            }
            case 47: {
                return pSDEViewBaseBase.isPSDynaInstIdDirty();
            }
            case 48: {
                return pSDEViewBaseBase.isPSHelpModuleIdDirty();
            }
            case 49: {
                return pSDEViewBaseBase.isPSHelpModuleNameDirty();
            }
            case 50: {
                return pSDEViewBaseBase.isPSSubViewTypeIdDirty();
            }
            case 51: {
                return pSDEViewBaseBase.isPSSubViewTypeNameDirty();
            }
            case 52: {
                return pSDEViewBaseBase.isPSSysCounterIdDirty();
            }
            case 53: {
                return pSDEViewBaseBase.isPSSysCounterNameDirty();
            }
            case 54: {
                return pSDEViewBaseBase.isPSSysCssIdDirty();
            }
            case 55: {
                return pSDEViewBaseBase.isPSSysCssNameDirty();
            }
            case 56: {
                return pSDEViewBaseBase.isPSSysDynaModelIdDirty();
            }
            case 57: {
                return pSDEViewBaseBase.isPSSysDynaModelNameDirty();
            }
            case 58: {
                return pSDEViewBaseBase.isPSSysImageIdDirty();
            }
            case 59: {
                return pSDEViewBaseBase.isPSSysImageNameDirty();
            }
            case 60: {
                return pSDEViewBaseBase.isPSSysPFPluginIdDirty();
            }
            case 61: {
                return pSDEViewBaseBase.isPSSysPFPluginNameDirty();
            }
            case 62: {
                return pSDEViewBaseBase.isPSSysReqItemIdDirty();
            }
            case 63: {
                return pSDEViewBaseBase.isPSSysReqItemNameDirty();
            }
            case 64: {
                return pSDEViewBaseBase.isPSSystemIdDirty();
            }
            case 65: {
                return pSDEViewBaseBase.isPSSystemNameDirty();
            }
            case 66: {
                return pSDEViewBaseBase.isPSSysUniResIdDirty();
            }
            case 67: {
                return pSDEViewBaseBase.isPSSysUniResNameDirty();
            }
            case 68: {
                return pSDEViewBaseBase.isPSSysViewPanelIdDirty();
            }
            case 69: {
                return pSDEViewBaseBase.isPSSysViewPanelNameDirty();
            }
            case 70: {
                return pSDEViewBaseBase.isPSViewEngineIdDirty();
            }
            case 71: {
                return pSDEViewBaseBase.isPSViewEngineNameDirty();
            }
            case 72: {
                return pSDEViewBaseBase.isPSViewMsgGroupIdDirty();
            }
            case 73: {
                return pSDEViewBaseBase.isPSViewMsgGroupNameDirty();
            }
            case 74: {
                return pSDEViewBaseBase.isPSVTStyleIdDirty();
            }
            case 75: {
                return pSDEViewBaseBase.isPSVTStyleNameDirty();
            }
            case 76: {
                return pSDEViewBaseBase.isPSWFDEIdDirty();
            }
            case 77: {
                return pSDEViewBaseBase.isPSWFDENameDirty();
            }
            case 78: {
                return pSDEViewBaseBase.isPSWFIdDirty();
            }
            case 79: {
                return pSDEViewBaseBase.isPSWFVersionIdDirty();
            }
            case 80: {
                return pSDEViewBaseBase.isPSWFVersionNameDirty();
            }
            case 81: {
                return pSDEViewBaseBase.isReadOnlyModeDirty();
            }
            case 82: {
                return pSDEViewBaseBase.isShowCaptionBarDirty();
            }
            case 83: {
                return pSDEViewBaseBase.isSRFSysPubDirty();
            }
            case 84: {
                return pSDEViewBaseBase.isSubCapPSLanResIdDirty();
            }
            case 85: {
                return pSDEViewBaseBase.isSubCapPSLanResNameDirty();
            }
            case 86: {
                return pSDEViewBaseBase.isSubCaptionDirty();
            }
            case 87: {
                return pSDEViewBaseBase.isTempModeDirty();
            }
            case 88: {
                return pSDEViewBaseBase.isTitleDirty();
            }
            case 89: {
                return pSDEViewBaseBase.isTitlePSLanResIdDirty();
            }
            case 90: {
                return pSDEViewBaseBase.isTitlePSLanResNameDirty();
            }
            case 91: {
                return pSDEViewBaseBase.isToDoTaskDirty();
            }
            case 92: {
                return pSDEViewBaseBase.isUpdateDateDirty();
            }
            case 93: {
                return pSDEViewBaseBase.isUpdateManDirty();
            }
            case 94: {
                return pSDEViewBaseBase.isUserDataDirty();
            }
            case 95: {
                return pSDEViewBaseBase.isUserData2Dirty();
            }
            case 96: {
                return pSDEViewBaseBase.isUserParamsDirty();
            }
            case 97: {
                return pSDEViewBaseBase.isViewActionsDirty();
            }
            case 98: {
                return pSDEViewBaseBase.isViewModelDirty();
            }
            case 99: {
                return pSDEViewBaseBase.isViewParamDirty();
            }
            case 100: {
                return pSDEViewBaseBase.isViewParam10Dirty();
            }
            case 101: {
                return pSDEViewBaseBase.isViewParam11Dirty();
            }
            case 102: {
                return pSDEViewBaseBase.isViewParam12Dirty();
            }
            case 103: {
                return pSDEViewBaseBase.isViewParam13Dirty();
            }
            case 104: {
                return pSDEViewBaseBase.isViewParam14Dirty();
            }
            case 105: {
                return pSDEViewBaseBase.isViewParam15Dirty();
            }
            case 106: {
                return pSDEViewBaseBase.isViewParam16Dirty();
            }
            case 107: {
                return pSDEViewBaseBase.isViewParam17Dirty();
            }
            case 108: {
                return pSDEViewBaseBase.isViewParam18Dirty();
            }
            case 109: {
                return pSDEViewBaseBase.isViewParam2Dirty();
            }
            case 110: {
                return pSDEViewBaseBase.isViewParam3Dirty();
            }
            case 111: {
                return pSDEViewBaseBase.isViewParam4Dirty();
            }
            case 112: {
                return pSDEViewBaseBase.isViewParam5Dirty();
            }
            case 113: {
                return pSDEViewBaseBase.isViewParam6Dirty();
            }
            case 114: {
                return pSDEViewBaseBase.isViewParam7Dirty();
            }
            case 115: {
                return pSDEViewBaseBase.isViewParam8Dirty();
            }
            case 116: {
                return pSDEViewBaseBase.isViewParam9Dirty();
            }
            case 117: {
                return pSDEViewBaseBase.isViewParamsDirty();
            }
            case 118: {
                return pSDEViewBaseBase.isViewSNDirty();
            }
            case 119: {
                return pSDEViewBaseBase.isWFViewParamDirty();
            }
            case 120: {
                return pSDEViewBaseBase.isWFViewParam2Dirty();
            }
            case 121: {
                return pSDEViewBaseBase.isWFViewParam3Dirty();
            }
            case 122: {
                return pSDEViewBaseBase.isWFViewParam4Dirty();
            }
            case 123: {
                return pSDEViewBaseBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewBaseBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewBaseBase pSDEViewBaseBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewBaseBase.getAccUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accusermode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getAccUserMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getBottomInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottominfo", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getBottomInfo()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewtag", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDEViewTag()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewtag2", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDEViewTag2()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewtag3", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDEViewTag3()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewtag4", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDEViewTag4()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getDyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dyncmode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getDyncMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getGroupPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getGroupPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getGroupPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouppscodelistname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getGroupPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getHeaderInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerinfo", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getHeaderInfo()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getLayoutPanelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpanelmode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getLayoutPanelMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getLoadDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loaddefault", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getLoadDefault()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getOpenMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openmode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getOpenMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPDTParamPre() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdtparampre", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPDTParamPre()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdvtparam", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPDVTParam()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefineviewtype", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPredefinedViewType()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSAppViewCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewcnt", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSAppViewCnt()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSAppViewsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewscnt", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSAppViewsCnt()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEAWGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEAWGroupId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEAWGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEAWGroupName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasetype", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDEViewBaseType()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDynaDEViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDynaDEViewTemplId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDynaDEViewTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDynaDEViewTemplName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSHelpModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmoduleid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSHelpModuleId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSHelpModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmodulename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSHelpModuleName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSubViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypeid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSubViewTypeId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSubViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSubViewTypeName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSViewEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewengineid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSViewEngineId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSViewEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewenginename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSViewEngineName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSVTStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtstyleid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSVTStyleId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSVTStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtstylename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSVTStyleName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getShowCaptionBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showcaptionbar", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getShowCaptionBar()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getSRFSysPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfsyspub", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getSRFSysPub()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getSubCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcappslanresid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getSubCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getSubCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcappslanresname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getSubCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getTempMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tempmode", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getTempMode()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getTitle()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getUserData()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getUserData2()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewActions()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmodel", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewModel()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam10", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam10()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam11", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam11()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam12", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam12()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam13", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam13()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam14", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam14()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam15() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam15", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam15()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam16() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam16", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam16()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam17() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam17", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam17()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam18() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam18", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam18()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam2", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam2()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam3", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam3()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam4", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam4()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam5", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam5()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam6", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam6()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam7", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam7()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam8", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam8()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparam9", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParam9()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewParams()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getViewSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewsn", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getViewSN()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getWFViewParam()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam2", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getWFViewParam2()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam3", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getWFViewParam3()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfviewparam4", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getWFViewParam4()), (boolean)false);
        }
        if (bl || pSDEViewBaseBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEViewBaseBase.getJSONValue((Object)pSDEViewBaseBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewBaseBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewBaseBase pSDEViewBaseBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewBaseBase.getAccUserMode() != null) {
            object = pSDEViewBaseBase.getAccUserMode();
            xmlNode.setAttribute(FIELD_ACCUSERMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseBase.getBottomInfo() != null) {
            object = pSDEViewBaseBase.getBottomInfo();
            xmlNode.setAttribute(FIELD_BOTTOMINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseBase.getCapPSLanResId() != null) {
            object = pSDEViewBaseBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseBase.getCapPSLanResName() != null) {
            object = pSDEViewBaseBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseBase.getCaption() != null) {
            object = pSDEViewBaseBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDEViewBaseBase.getCodeName() != null) {
            object = pSDEViewBaseBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getCreateDate() != null) {
            object = pSDEViewBaseBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getCreateMan() != null) {
            object = pSDEViewBaseBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag() != null) {
            object = pSDEViewBaseBase.getDEViewTag();
            xmlNode.setAttribute(FIELD_DEVIEWTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag2() != null) {
            object = pSDEViewBaseBase.getDEViewTag2();
            xmlNode.setAttribute(FIELD_DEVIEWTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag3() != null) {
            object = pSDEViewBaseBase.getDEViewTag3();
            xmlNode.setAttribute(FIELD_DEVIEWTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getDEViewTag4() != null) {
            object = pSDEViewBaseBase.getDEViewTag4();
            xmlNode.setAttribute(FIELD_DEVIEWTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getDynaModelFlag() != null) {
            object = pSDEViewBaseBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getDyncMode() != null) {
            object = pSDEViewBaseBase.getDyncMode();
            xmlNode.setAttribute(FIELD_DYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getEnableViewActions() != null) {
            object = pSDEViewBaseBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getGroupPSCodeListId() != null) {
            object = pSDEViewBaseBase.getGroupPSCodeListId();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getGroupPSCodeListName() != null) {
            object = pSDEViewBaseBase.getGroupPSCodeListName();
            xmlNode.setAttribute(FIELD_GROUPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getHeaderInfo() != null) {
            object = pSDEViewBaseBase.getHeaderInfo();
            xmlNode.setAttribute(FIELD_HEADERINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getHeight() != null) {
            object = pSDEViewBaseBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getLayoutPanelMode() != null) {
            object = pSDEViewBaseBase.getLayoutPanelMode();
            xmlNode.setAttribute(FIELD_LAYOUTPANELMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getLoadDefault() != null) {
            object = pSDEViewBaseBase.getLoadDefault();
            xmlNode.setAttribute(FIELD_LOADDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getLockFlag() != null) {
            object = pSDEViewBaseBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getMemo() != null) {
            object = pSDEViewBaseBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getModelState() != null) {
            object = pSDEViewBaseBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getOpenMode() != null) {
            object = pSDEViewBaseBase.getOpenMode();
            xmlNode.setAttribute(FIELD_OPENMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPDTParamPre() != null) {
            object = pSDEViewBaseBase.getPDTParamPre();
            xmlNode.setAttribute(FIELD_PDTPARAMPRE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPDVTParam() != null) {
            object = pSDEViewBaseBase.getPDVTParam();
            xmlNode.setAttribute(FIELD_PDVTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPredefinedViewType() != null) {
            object = pSDEViewBaseBase.getPredefinedViewType();
            xmlNode.setAttribute("PREDEFINEDVIEWTYPE", object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSACHandlerId() != null) {
            object = pSDEViewBaseBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSACHandlerName() != null) {
            object = pSDEViewBaseBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSAppViewCnt() != null) {
            object = pSDEViewBaseBase.getPSAppViewCnt();
            xmlNode.setAttribute(FIELD_PSAPPVIEWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getPSAppViewsCnt() != null) {
            object = pSDEViewBaseBase.getPSAppViewsCnt();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEViewBaseBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEViewBaseBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEAWGroupId() != null) {
            object = pSDEViewBaseBase.getPSDEAWGroupId();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEAWGroupName() != null) {
            object = pSDEViewBaseBase.getPSDEAWGroupName();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEId() != null) {
            object = pSDEViewBaseBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEMainStateId() != null) {
            object = pSDEViewBaseBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEMainStateName() != null) {
            object = pSDEViewBaseBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEName() != null) {
            object = pSDEViewBaseBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDERId() != null) {
            object = pSDEViewBaseBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDERName() != null) {
            object = pSDEViewBaseBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseId() != null) {
            object = pSDEViewBaseBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseName() != null) {
            object = pSDEViewBaseBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDEViewBaseType() != null) {
            object = pSDEViewBaseBase.getPSDEViewBaseType();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDynaDEViewTemplId() != null) {
            object = pSDEViewBaseBase.getPSDynaDEViewTemplId();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDynaDEViewTemplName() != null) {
            object = pSDEViewBaseBase.getPSDynaDEViewTemplName();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSDynaInstId() != null) {
            object = pSDEViewBaseBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSHelpModuleId() != null) {
            object = pSDEViewBaseBase.getPSHelpModuleId();
            xmlNode.setAttribute(FIELD_PSHELPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSHelpModuleName() != null) {
            object = pSDEViewBaseBase.getPSHelpModuleName();
            xmlNode.setAttribute(FIELD_PSHELPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSubViewTypeId() != null) {
            object = pSDEViewBaseBase.getPSSubViewTypeId();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSubViewTypeName() != null) {
            object = pSDEViewBaseBase.getPSSubViewTypeName();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysCounterId() != null) {
            object = pSDEViewBaseBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysCounterName() != null) {
            object = pSDEViewBaseBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysCssId() != null) {
            object = pSDEViewBaseBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysCssName() != null) {
            object = pSDEViewBaseBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysDynaModelId() != null) {
            object = pSDEViewBaseBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysDynaModelName() != null) {
            object = pSDEViewBaseBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysImageId() != null) {
            object = pSDEViewBaseBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysImageName() != null) {
            object = pSDEViewBaseBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysPFPluginId() != null) {
            object = pSDEViewBaseBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysPFPluginName() != null) {
            object = pSDEViewBaseBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysReqItemId() != null) {
            object = pSDEViewBaseBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysReqItemName() != null) {
            object = pSDEViewBaseBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSystemId() != null) {
            object = pSDEViewBaseBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSystemName() != null) {
            object = pSDEViewBaseBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysUniResId() != null) {
            object = pSDEViewBaseBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysUniResName() != null) {
            object = pSDEViewBaseBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysViewPanelId() != null) {
            object = pSDEViewBaseBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSSysViewPanelName() != null) {
            object = pSDEViewBaseBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSViewEngineId() != null) {
            object = pSDEViewBaseBase.getPSViewEngineId();
            xmlNode.setAttribute(FIELD_PSVIEWENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSViewEngineName() != null) {
            object = pSDEViewBaseBase.getPSViewEngineName();
            xmlNode.setAttribute(FIELD_PSVIEWENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSViewMsgGroupId() != null) {
            object = pSDEViewBaseBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSViewMsgGroupName() != null) {
            object = pSDEViewBaseBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSVTStyleId() != null) {
            object = pSDEViewBaseBase.getPSVTStyleId();
            xmlNode.setAttribute(FIELD_PSVTSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSVTStyleName() != null) {
            object = pSDEViewBaseBase.getPSVTStyleName();
            xmlNode.setAttribute(FIELD_PSVTSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSWFDEId() != null) {
            object = pSDEViewBaseBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSWFDEName() != null) {
            object = pSDEViewBaseBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSWFId() != null) {
            object = pSDEViewBaseBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSWFVersionId() != null) {
            object = pSDEViewBaseBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getPSWFVersionName() != null) {
            object = pSDEViewBaseBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getReadOnlyMode() != null) {
            object = pSDEViewBaseBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getShowCaptionBar() != null) {
            object = pSDEViewBaseBase.getShowCaptionBar();
            xmlNode.setAttribute(FIELD_SHOWCAPTIONBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getSRFSysPub() != null) {
            object = pSDEViewBaseBase.getSRFSysPub();
            xmlNode.setAttribute(FIELD_SRFSYSPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getSubCapPSLanResId() != null) {
            object = pSDEViewBaseBase.getSubCapPSLanResId();
            xmlNode.setAttribute(FIELD_SUBCAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getSubCapPSLanResName() != null) {
            object = pSDEViewBaseBase.getSubCapPSLanResName();
            xmlNode.setAttribute(FIELD_SUBCAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getSubCaption() != null) {
            object = pSDEViewBaseBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getTempMode() != null) {
            object = pSDEViewBaseBase.getTempMode();
            xmlNode.setAttribute(FIELD_TEMPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getTitle() != null) {
            object = pSDEViewBaseBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getTitlePSLanResId() != null) {
            object = pSDEViewBaseBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getTitlePSLanResName() != null) {
            object = pSDEViewBaseBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getToDoTask() != null) {
            object = pSDEViewBaseBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getUpdateDate() != null) {
            object = pSDEViewBaseBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getUpdateMan() != null) {
            object = pSDEViewBaseBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getUserData() != null) {
            object = pSDEViewBaseBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getUserData2() != null) {
            object = pSDEViewBaseBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getUserParams() != null) {
            object = pSDEViewBaseBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewActions() != null) {
            object = pSDEViewBaseBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewModel() != null) {
            object = pSDEViewBaseBase.getViewModel();
            xmlNode.setAttribute(FIELD_VIEWMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam() != null) {
            object = pSDEViewBaseBase.getViewParam();
            xmlNode.setAttribute(FIELD_VIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam10() != null) {
            object = pSDEViewBaseBase.getViewParam10();
            xmlNode.setAttribute(FIELD_VIEWPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam11() != null) {
            object = pSDEViewBaseBase.getViewParam11();
            xmlNode.setAttribute(FIELD_VIEWPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam12() != null) {
            object = pSDEViewBaseBase.getViewParam12();
            xmlNode.setAttribute(FIELD_VIEWPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam13() != null) {
            object = pSDEViewBaseBase.getViewParam13();
            xmlNode.setAttribute(FIELD_VIEWPARAM13, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam14() != null) {
            object = pSDEViewBaseBase.getViewParam14();
            xmlNode.setAttribute(FIELD_VIEWPARAM14, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam15() != null) {
            object = pSDEViewBaseBase.getViewParam15();
            xmlNode.setAttribute(FIELD_VIEWPARAM15, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam16() != null) {
            object = pSDEViewBaseBase.getViewParam16();
            xmlNode.setAttribute(FIELD_VIEWPARAM16, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam17() != null) {
            object = pSDEViewBaseBase.getViewParam17();
            xmlNode.setAttribute(FIELD_VIEWPARAM17, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam18() != null) {
            object = pSDEViewBaseBase.getViewParam18();
            xmlNode.setAttribute(FIELD_VIEWPARAM18, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam2() != null) {
            object = pSDEViewBaseBase.getViewParam2();
            xmlNode.setAttribute(FIELD_VIEWPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam3() != null) {
            object = pSDEViewBaseBase.getViewParam3();
            xmlNode.setAttribute(FIELD_VIEWPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam4() != null) {
            object = pSDEViewBaseBase.getViewParam4();
            xmlNode.setAttribute(FIELD_VIEWPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam5() != null) {
            object = pSDEViewBaseBase.getViewParam5();
            xmlNode.setAttribute(FIELD_VIEWPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam6() != null) {
            object = pSDEViewBaseBase.getViewParam6();
            xmlNode.setAttribute(FIELD_VIEWPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParam7() != null) {
            object = pSDEViewBaseBase.getViewParam7();
            xmlNode.setAttribute(FIELD_VIEWPARAM7, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam8() != null) {
            object = pSDEViewBaseBase.getViewParam8();
            xmlNode.setAttribute(FIELD_VIEWPARAM8, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewParam9() != null) {
            object = pSDEViewBaseBase.getViewParam9();
            xmlNode.setAttribute(FIELD_VIEWPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getViewParams() != null) {
            object = pSDEViewBaseBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getViewSN() != null) {
            object = pSDEViewBaseBase.getViewSN();
            xmlNode.setAttribute(FIELD_VIEWSN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam() != null) {
            object = pSDEViewBaseBase.getWFViewParam();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getWFViewParam2() != null) {
            object = pSDEViewBaseBase.getWFViewParam2();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewBaseBase.getWFViewParam3() != null) {
            object = pSDEViewBaseBase.getWFViewParam3();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getWFViewParam4() != null) {
            object = pSDEViewBaseBase.getWFViewParam4();
            xmlNode.setAttribute(FIELD_WFVIEWPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewBaseBase.getWidth() != null) {
            object = pSDEViewBaseBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewBaseBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewBaseBase pSDEViewBaseBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewBaseBase.isAccUserModeDirty() && (bl || pSDEViewBaseBase.getAccUserMode() != null)) {
            iDataObject.set(FIELD_ACCUSERMODE, (Object)pSDEViewBaseBase.getAccUserMode());
        }
        if (pSDEViewBaseBase.isBottomInfoDirty() && (bl || pSDEViewBaseBase.getBottomInfo() != null)) {
            iDataObject.set(FIELD_BOTTOMINFO, (Object)pSDEViewBaseBase.getBottomInfo());
        }
        if (pSDEViewBaseBase.isCapPSLanResIdDirty() && (bl || pSDEViewBaseBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEViewBaseBase.getCapPSLanResId());
        }
        if (pSDEViewBaseBase.isCapPSLanResNameDirty() && (bl || pSDEViewBaseBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEViewBaseBase.getCapPSLanResName());
        }
        if (pSDEViewBaseBase.isCaptionDirty() && (bl || pSDEViewBaseBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEViewBaseBase.getCaption());
        }
        if (pSDEViewBaseBase.isCodeNameDirty() && (bl || pSDEViewBaseBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEViewBaseBase.getCodeName());
        }
        if (pSDEViewBaseBase.isCreateDateDirty() && (bl || pSDEViewBaseBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewBaseBase.getCreateDate());
        }
        if (pSDEViewBaseBase.isCreateManDirty() && (bl || pSDEViewBaseBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewBaseBase.getCreateMan());
        }
        if (pSDEViewBaseBase.isDEViewTagDirty() && (bl || pSDEViewBaseBase.getDEViewTag() != null)) {
            iDataObject.set(FIELD_DEVIEWTAG, (Object)pSDEViewBaseBase.getDEViewTag());
        }
        if (pSDEViewBaseBase.isDEViewTag2Dirty() && (bl || pSDEViewBaseBase.getDEViewTag2() != null)) {
            iDataObject.set(FIELD_DEVIEWTAG2, (Object)pSDEViewBaseBase.getDEViewTag2());
        }
        if (pSDEViewBaseBase.isDEViewTag3Dirty() && (bl || pSDEViewBaseBase.getDEViewTag3() != null)) {
            iDataObject.set(FIELD_DEVIEWTAG3, (Object)pSDEViewBaseBase.getDEViewTag3());
        }
        if (pSDEViewBaseBase.isDEViewTag4Dirty() && (bl || pSDEViewBaseBase.getDEViewTag4() != null)) {
            iDataObject.set(FIELD_DEVIEWTAG4, (Object)pSDEViewBaseBase.getDEViewTag4());
        }
        if (pSDEViewBaseBase.isDynaModelFlagDirty() && (bl || pSDEViewBaseBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEViewBaseBase.getDynaModelFlag());
        }
        if (pSDEViewBaseBase.isDyncModeDirty() && (bl || pSDEViewBaseBase.getDyncMode() != null)) {
            iDataObject.set(FIELD_DYNCMODE, (Object)pSDEViewBaseBase.getDyncMode());
        }
        if (pSDEViewBaseBase.isEnableViewActionsDirty() && (bl || pSDEViewBaseBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDEViewBaseBase.getEnableViewActions());
        }
        if (pSDEViewBaseBase.isGroupPSCodeListIdDirty() && (bl || pSDEViewBaseBase.getGroupPSCodeListId() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTID, (Object)pSDEViewBaseBase.getGroupPSCodeListId());
        }
        if (pSDEViewBaseBase.isGroupPSCodeListNameDirty() && (bl || pSDEViewBaseBase.getGroupPSCodeListName() != null)) {
            iDataObject.set(FIELD_GROUPPSCODELISTNAME, (Object)pSDEViewBaseBase.getGroupPSCodeListName());
        }
        if (pSDEViewBaseBase.isHeaderInfoDirty() && (bl || pSDEViewBaseBase.getHeaderInfo() != null)) {
            iDataObject.set(FIELD_HEADERINFO, (Object)pSDEViewBaseBase.getHeaderInfo());
        }
        if (pSDEViewBaseBase.isHeightDirty() && (bl || pSDEViewBaseBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEViewBaseBase.getHeight());
        }
        if (pSDEViewBaseBase.isLayoutPanelModeDirty() && (bl || pSDEViewBaseBase.getLayoutPanelMode() != null)) {
            iDataObject.set(FIELD_LAYOUTPANELMODE, (Object)pSDEViewBaseBase.getLayoutPanelMode());
        }
        if (pSDEViewBaseBase.isLoadDefaultDirty() && (bl || pSDEViewBaseBase.getLoadDefault() != null)) {
            iDataObject.set(FIELD_LOADDEFAULT, (Object)pSDEViewBaseBase.getLoadDefault());
        }
        if (pSDEViewBaseBase.isLockFlagDirty() && (bl || pSDEViewBaseBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEViewBaseBase.getLockFlag());
        }
        if (pSDEViewBaseBase.isMemoDirty() && (bl || pSDEViewBaseBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewBaseBase.getMemo());
        }
        if (pSDEViewBaseBase.isModelStateDirty() && (bl || pSDEViewBaseBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEViewBaseBase.getModelState());
        }
        if (pSDEViewBaseBase.isOpenModeDirty() && (bl || pSDEViewBaseBase.getOpenMode() != null)) {
            iDataObject.set(FIELD_OPENMODE, (Object)pSDEViewBaseBase.getOpenMode());
        }
        if (pSDEViewBaseBase.isPDTParamPreDirty() && (bl || pSDEViewBaseBase.getPDTParamPre() != null)) {
            iDataObject.set(FIELD_PDTPARAMPRE, (Object)pSDEViewBaseBase.getPDTParamPre());
        }
        if (pSDEViewBaseBase.isPDVTParamDirty() && (bl || pSDEViewBaseBase.getPDVTParam() != null)) {
            iDataObject.set(FIELD_PDVTPARAM, (Object)pSDEViewBaseBase.getPDVTParam());
        }
        if (pSDEViewBaseBase.isPredefinedViewTypeDirty() && (bl || pSDEViewBaseBase.getPredefinedViewType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDVIEWTYPE, (Object)pSDEViewBaseBase.getPredefinedViewType());
        }
        if (pSDEViewBaseBase.isPSACHandlerIdDirty() && (bl || pSDEViewBaseBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSDEViewBaseBase.getPSACHandlerId());
        }
        if (pSDEViewBaseBase.isPSACHandlerNameDirty() && (bl || pSDEViewBaseBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSDEViewBaseBase.getPSACHandlerName());
        }
        if (pSDEViewBaseBase.isPSAppViewCntDirty() && (bl || pSDEViewBaseBase.getPSAppViewCnt() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWCNT, (Object)pSDEViewBaseBase.getPSAppViewCnt());
        }
        if (pSDEViewBaseBase.isPSAppViewsCntDirty() && (bl || pSDEViewBaseBase.getPSAppViewsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSCNT, (Object)pSDEViewBaseBase.getPSAppViewsCnt());
        }
        if (pSDEViewBaseBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEViewBaseBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEViewBaseBase.getPSCtrlLogicGroupId());
        }
        if (pSDEViewBaseBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEViewBaseBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEViewBaseBase.getPSCtrlLogicGroupName());
        }
        if (pSDEViewBaseBase.isPSDEAWGroupIdDirty() && (bl || pSDEViewBaseBase.getPSDEAWGroupId() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPID, (Object)pSDEViewBaseBase.getPSDEAWGroupId());
        }
        if (pSDEViewBaseBase.isPSDEAWGroupNameDirty() && (bl || pSDEViewBaseBase.getPSDEAWGroupName() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPNAME, (Object)pSDEViewBaseBase.getPSDEAWGroupName());
        }
        if (pSDEViewBaseBase.isPSDEIdDirty() && (bl || pSDEViewBaseBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEViewBaseBase.getPSDEId());
        }
        if (pSDEViewBaseBase.isPSDEMainStateIdDirty() && (bl || pSDEViewBaseBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDEViewBaseBase.getPSDEMainStateId());
        }
        if (pSDEViewBaseBase.isPSDEMainStateNameDirty() && (bl || pSDEViewBaseBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDEViewBaseBase.getPSDEMainStateName());
        }
        if (pSDEViewBaseBase.isPSDENameDirty() && (bl || pSDEViewBaseBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEViewBaseBase.getPSDEName());
        }
        if (pSDEViewBaseBase.isPSDERIdDirty() && (bl || pSDEViewBaseBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEViewBaseBase.getPSDERId());
        }
        if (pSDEViewBaseBase.isPSDERNameDirty() && (bl || pSDEViewBaseBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEViewBaseBase.getPSDERName());
        }
        if (pSDEViewBaseBase.isPSDEViewBaseIdDirty() && (bl || pSDEViewBaseBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        }
        if (pSDEViewBaseBase.isPSDEViewBaseNameDirty() && (bl || pSDEViewBaseBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDEViewBaseBase.getPSDEViewBaseName());
        }
        if (pSDEViewBaseBase.isPSDEViewBaseTypeDirty() && (bl || pSDEViewBaseBase.getPSDEViewBaseType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASETYPE, (Object)pSDEViewBaseBase.getPSDEViewBaseType());
        }
        if (pSDEViewBaseBase.isPSDynaDEViewTemplIdDirty() && (bl || pSDEViewBaseBase.getPSDynaDEViewTemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLID, (Object)pSDEViewBaseBase.getPSDynaDEViewTemplId());
        }
        if (pSDEViewBaseBase.isPSDynaDEViewTemplNameDirty() && (bl || pSDEViewBaseBase.getPSDynaDEViewTemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLNAME, (Object)pSDEViewBaseBase.getPSDynaDEViewTemplName());
        }
        if (pSDEViewBaseBase.isPSDynaInstIdDirty() && (bl || pSDEViewBaseBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEViewBaseBase.getPSDynaInstId());
        }
        if (pSDEViewBaseBase.isPSHelpModuleIdDirty() && (bl || pSDEViewBaseBase.getPSHelpModuleId() != null)) {
            iDataObject.set(FIELD_PSHELPMODULEID, (Object)pSDEViewBaseBase.getPSHelpModuleId());
        }
        if (pSDEViewBaseBase.isPSHelpModuleNameDirty() && (bl || pSDEViewBaseBase.getPSHelpModuleName() != null)) {
            iDataObject.set(FIELD_PSHELPMODULENAME, (Object)pSDEViewBaseBase.getPSHelpModuleName());
        }
        if (pSDEViewBaseBase.isPSSubViewTypeIdDirty() && (bl || pSDEViewBaseBase.getPSSubViewTypeId() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPEID, (Object)pSDEViewBaseBase.getPSSubViewTypeId());
        }
        if (pSDEViewBaseBase.isPSSubViewTypeNameDirty() && (bl || pSDEViewBaseBase.getPSSubViewTypeName() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPENAME, (Object)pSDEViewBaseBase.getPSSubViewTypeName());
        }
        if (pSDEViewBaseBase.isPSSysCounterIdDirty() && (bl || pSDEViewBaseBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEViewBaseBase.getPSSysCounterId());
        }
        if (pSDEViewBaseBase.isPSSysCounterNameDirty() && (bl || pSDEViewBaseBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEViewBaseBase.getPSSysCounterName());
        }
        if (pSDEViewBaseBase.isPSSysCssIdDirty() && (bl || pSDEViewBaseBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEViewBaseBase.getPSSysCssId());
        }
        if (pSDEViewBaseBase.isPSSysCssNameDirty() && (bl || pSDEViewBaseBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEViewBaseBase.getPSSysCssName());
        }
        if (pSDEViewBaseBase.isPSSysDynaModelIdDirty() && (bl || pSDEViewBaseBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEViewBaseBase.getPSSysDynaModelId());
        }
        if (pSDEViewBaseBase.isPSSysDynaModelNameDirty() && (bl || pSDEViewBaseBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEViewBaseBase.getPSSysDynaModelName());
        }
        if (pSDEViewBaseBase.isPSSysImageIdDirty() && (bl || pSDEViewBaseBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEViewBaseBase.getPSSysImageId());
        }
        if (pSDEViewBaseBase.isPSSysImageNameDirty() && (bl || pSDEViewBaseBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEViewBaseBase.getPSSysImageName());
        }
        if (pSDEViewBaseBase.isPSSysPFPluginIdDirty() && (bl || pSDEViewBaseBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEViewBaseBase.getPSSysPFPluginId());
        }
        if (pSDEViewBaseBase.isPSSysPFPluginNameDirty() && (bl || pSDEViewBaseBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEViewBaseBase.getPSSysPFPluginName());
        }
        if (pSDEViewBaseBase.isPSSysReqItemIdDirty() && (bl || pSDEViewBaseBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEViewBaseBase.getPSSysReqItemId());
        }
        if (pSDEViewBaseBase.isPSSysReqItemNameDirty() && (bl || pSDEViewBaseBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEViewBaseBase.getPSSysReqItemName());
        }
        if (pSDEViewBaseBase.isPSSystemIdDirty() && (bl || pSDEViewBaseBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEViewBaseBase.getPSSystemId());
        }
        if (pSDEViewBaseBase.isPSSystemNameDirty() && (bl || pSDEViewBaseBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEViewBaseBase.getPSSystemName());
        }
        if (pSDEViewBaseBase.isPSSysUniResIdDirty() && (bl || pSDEViewBaseBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEViewBaseBase.getPSSysUniResId());
        }
        if (pSDEViewBaseBase.isPSSysUniResNameDirty() && (bl || pSDEViewBaseBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEViewBaseBase.getPSSysUniResName());
        }
        if (pSDEViewBaseBase.isPSSysViewPanelIdDirty() && (bl || pSDEViewBaseBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEViewBaseBase.getPSSysViewPanelId());
        }
        if (pSDEViewBaseBase.isPSSysViewPanelNameDirty() && (bl || pSDEViewBaseBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEViewBaseBase.getPSSysViewPanelName());
        }
        if (pSDEViewBaseBase.isPSViewEngineIdDirty() && (bl || pSDEViewBaseBase.getPSViewEngineId() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINEID, (Object)pSDEViewBaseBase.getPSViewEngineId());
        }
        if (pSDEViewBaseBase.isPSViewEngineNameDirty() && (bl || pSDEViewBaseBase.getPSViewEngineName() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINENAME, (Object)pSDEViewBaseBase.getPSViewEngineName());
        }
        if (pSDEViewBaseBase.isPSViewMsgGroupIdDirty() && (bl || pSDEViewBaseBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEViewBaseBase.getPSViewMsgGroupId());
        }
        if (pSDEViewBaseBase.isPSViewMsgGroupNameDirty() && (bl || pSDEViewBaseBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEViewBaseBase.getPSViewMsgGroupName());
        }
        if (pSDEViewBaseBase.isPSVTStyleIdDirty() && (bl || pSDEViewBaseBase.getPSVTStyleId() != null)) {
            iDataObject.set(FIELD_PSVTSTYLEID, (Object)pSDEViewBaseBase.getPSVTStyleId());
        }
        if (pSDEViewBaseBase.isPSVTStyleNameDirty() && (bl || pSDEViewBaseBase.getPSVTStyleName() != null)) {
            iDataObject.set(FIELD_PSVTSTYLENAME, (Object)pSDEViewBaseBase.getPSVTStyleName());
        }
        if (pSDEViewBaseBase.isPSWFDEIdDirty() && (bl || pSDEViewBaseBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSDEViewBaseBase.getPSWFDEId());
        }
        if (pSDEViewBaseBase.isPSWFDENameDirty() && (bl || pSDEViewBaseBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSDEViewBaseBase.getPSWFDEName());
        }
        if (pSDEViewBaseBase.isPSWFIdDirty() && (bl || pSDEViewBaseBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSDEViewBaseBase.getPSWFId());
        }
        if (pSDEViewBaseBase.isPSWFVersionIdDirty() && (bl || pSDEViewBaseBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSDEViewBaseBase.getPSWFVersionId());
        }
        if (pSDEViewBaseBase.isPSWFVersionNameDirty() && (bl || pSDEViewBaseBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSDEViewBaseBase.getPSWFVersionName());
        }
        if (pSDEViewBaseBase.isReadOnlyModeDirty() && (bl || pSDEViewBaseBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSDEViewBaseBase.getReadOnlyMode());
        }
        if (pSDEViewBaseBase.isShowCaptionBarDirty() && (bl || pSDEViewBaseBase.getShowCaptionBar() != null)) {
            iDataObject.set(FIELD_SHOWCAPTIONBAR, (Object)pSDEViewBaseBase.getShowCaptionBar());
        }
        if (pSDEViewBaseBase.isSRFSysPubDirty() && (bl || pSDEViewBaseBase.getSRFSysPub() != null)) {
            iDataObject.set(FIELD_SRFSYSPUB, (Object)pSDEViewBaseBase.getSRFSysPub());
        }
        if (pSDEViewBaseBase.isSubCapPSLanResIdDirty() && (bl || pSDEViewBaseBase.getSubCapPSLanResId() != null)) {
            iDataObject.set(FIELD_SUBCAPPSLANRESID, (Object)pSDEViewBaseBase.getSubCapPSLanResId());
        }
        if (pSDEViewBaseBase.isSubCapPSLanResNameDirty() && (bl || pSDEViewBaseBase.getSubCapPSLanResName() != null)) {
            iDataObject.set(FIELD_SUBCAPPSLANRESNAME, (Object)pSDEViewBaseBase.getSubCapPSLanResName());
        }
        if (pSDEViewBaseBase.isSubCaptionDirty() && (bl || pSDEViewBaseBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSDEViewBaseBase.getSubCaption());
        }
        if (pSDEViewBaseBase.isTempModeDirty() && (bl || pSDEViewBaseBase.getTempMode() != null)) {
            iDataObject.set(FIELD_TEMPMODE, (Object)pSDEViewBaseBase.getTempMode());
        }
        if (pSDEViewBaseBase.isTitleDirty() && (bl || pSDEViewBaseBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSDEViewBaseBase.getTitle());
        }
        if (pSDEViewBaseBase.isTitlePSLanResIdDirty() && (bl || pSDEViewBaseBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSDEViewBaseBase.getTitlePSLanResId());
        }
        if (pSDEViewBaseBase.isTitlePSLanResNameDirty() && (bl || pSDEViewBaseBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSDEViewBaseBase.getTitlePSLanResName());
        }
        if (pSDEViewBaseBase.isToDoTaskDirty() && (bl || pSDEViewBaseBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEViewBaseBase.getToDoTask());
        }
        if (pSDEViewBaseBase.isUpdateDateDirty() && (bl || pSDEViewBaseBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewBaseBase.getUpdateDate());
        }
        if (pSDEViewBaseBase.isUpdateManDirty() && (bl || pSDEViewBaseBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewBaseBase.getUpdateMan());
        }
        if (pSDEViewBaseBase.isUserDataDirty() && (bl || pSDEViewBaseBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSDEViewBaseBase.getUserData());
        }
        if (pSDEViewBaseBase.isUserData2Dirty() && (bl || pSDEViewBaseBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSDEViewBaseBase.getUserData2());
        }
        if (pSDEViewBaseBase.isUserParamsDirty() && (bl || pSDEViewBaseBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEViewBaseBase.getUserParams());
        }
        if (pSDEViewBaseBase.isViewActionsDirty() && (bl || pSDEViewBaseBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDEViewBaseBase.getViewActions());
        }
        if (pSDEViewBaseBase.isViewModelDirty() && (bl || pSDEViewBaseBase.getViewModel() != null)) {
            iDataObject.set(FIELD_VIEWMODEL, (Object)pSDEViewBaseBase.getViewModel());
        }
        if (pSDEViewBaseBase.isViewParamDirty() && (bl || pSDEViewBaseBase.getViewParam() != null)) {
            iDataObject.set(FIELD_VIEWPARAM, (Object)pSDEViewBaseBase.getViewParam());
        }
        if (pSDEViewBaseBase.isViewParam10Dirty() && (bl || pSDEViewBaseBase.getViewParam10() != null)) {
            iDataObject.set(FIELD_VIEWPARAM10, (Object)pSDEViewBaseBase.getViewParam10());
        }
        if (pSDEViewBaseBase.isViewParam11Dirty() && (bl || pSDEViewBaseBase.getViewParam11() != null)) {
            iDataObject.set(FIELD_VIEWPARAM11, (Object)pSDEViewBaseBase.getViewParam11());
        }
        if (pSDEViewBaseBase.isViewParam12Dirty() && (bl || pSDEViewBaseBase.getViewParam12() != null)) {
            iDataObject.set(FIELD_VIEWPARAM12, (Object)pSDEViewBaseBase.getViewParam12());
        }
        if (pSDEViewBaseBase.isViewParam13Dirty() && (bl || pSDEViewBaseBase.getViewParam13() != null)) {
            iDataObject.set(FIELD_VIEWPARAM13, (Object)pSDEViewBaseBase.getViewParam13());
        }
        if (pSDEViewBaseBase.isViewParam14Dirty() && (bl || pSDEViewBaseBase.getViewParam14() != null)) {
            iDataObject.set(FIELD_VIEWPARAM14, (Object)pSDEViewBaseBase.getViewParam14());
        }
        if (pSDEViewBaseBase.isViewParam15Dirty() && (bl || pSDEViewBaseBase.getViewParam15() != null)) {
            iDataObject.set(FIELD_VIEWPARAM15, (Object)pSDEViewBaseBase.getViewParam15());
        }
        if (pSDEViewBaseBase.isViewParam16Dirty() && (bl || pSDEViewBaseBase.getViewParam16() != null)) {
            iDataObject.set(FIELD_VIEWPARAM16, (Object)pSDEViewBaseBase.getViewParam16());
        }
        if (pSDEViewBaseBase.isViewParam17Dirty() && (bl || pSDEViewBaseBase.getViewParam17() != null)) {
            iDataObject.set(FIELD_VIEWPARAM17, (Object)pSDEViewBaseBase.getViewParam17());
        }
        if (pSDEViewBaseBase.isViewParam18Dirty() && (bl || pSDEViewBaseBase.getViewParam18() != null)) {
            iDataObject.set(FIELD_VIEWPARAM18, (Object)pSDEViewBaseBase.getViewParam18());
        }
        if (pSDEViewBaseBase.isViewParam2Dirty() && (bl || pSDEViewBaseBase.getViewParam2() != null)) {
            iDataObject.set(FIELD_VIEWPARAM2, (Object)pSDEViewBaseBase.getViewParam2());
        }
        if (pSDEViewBaseBase.isViewParam3Dirty() && (bl || pSDEViewBaseBase.getViewParam3() != null)) {
            iDataObject.set(FIELD_VIEWPARAM3, (Object)pSDEViewBaseBase.getViewParam3());
        }
        if (pSDEViewBaseBase.isViewParam4Dirty() && (bl || pSDEViewBaseBase.getViewParam4() != null)) {
            iDataObject.set(FIELD_VIEWPARAM4, (Object)pSDEViewBaseBase.getViewParam4());
        }
        if (pSDEViewBaseBase.isViewParam5Dirty() && (bl || pSDEViewBaseBase.getViewParam5() != null)) {
            iDataObject.set(FIELD_VIEWPARAM5, (Object)pSDEViewBaseBase.getViewParam5());
        }
        if (pSDEViewBaseBase.isViewParam6Dirty() && (bl || pSDEViewBaseBase.getViewParam6() != null)) {
            iDataObject.set(FIELD_VIEWPARAM6, (Object)pSDEViewBaseBase.getViewParam6());
        }
        if (pSDEViewBaseBase.isViewParam7Dirty() && (bl || pSDEViewBaseBase.getViewParam7() != null)) {
            iDataObject.set(FIELD_VIEWPARAM7, (Object)pSDEViewBaseBase.getViewParam7());
        }
        if (pSDEViewBaseBase.isViewParam8Dirty() && (bl || pSDEViewBaseBase.getViewParam8() != null)) {
            iDataObject.set(FIELD_VIEWPARAM8, (Object)pSDEViewBaseBase.getViewParam8());
        }
        if (pSDEViewBaseBase.isViewParam9Dirty() && (bl || pSDEViewBaseBase.getViewParam9() != null)) {
            iDataObject.set(FIELD_VIEWPARAM9, (Object)pSDEViewBaseBase.getViewParam9());
        }
        if (pSDEViewBaseBase.isViewParamsDirty() && (bl || pSDEViewBaseBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSDEViewBaseBase.getViewParams());
        }
        if (pSDEViewBaseBase.isViewSNDirty() && (bl || pSDEViewBaseBase.getViewSN() != null)) {
            iDataObject.set(FIELD_VIEWSN, (Object)pSDEViewBaseBase.getViewSN());
        }
        if (pSDEViewBaseBase.isWFViewParamDirty() && (bl || pSDEViewBaseBase.getWFViewParam() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM, (Object)pSDEViewBaseBase.getWFViewParam());
        }
        if (pSDEViewBaseBase.isWFViewParam2Dirty() && (bl || pSDEViewBaseBase.getWFViewParam2() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM2, (Object)pSDEViewBaseBase.getWFViewParam2());
        }
        if (pSDEViewBaseBase.isWFViewParam3Dirty() && (bl || pSDEViewBaseBase.getWFViewParam3() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM3, (Object)pSDEViewBaseBase.getWFViewParam3());
        }
        if (pSDEViewBaseBase.isWFViewParam4Dirty() && (bl || pSDEViewBaseBase.getWFViewParam4() != null)) {
            iDataObject.set(FIELD_WFVIEWPARAM4, (Object)pSDEViewBaseBase.getWFViewParam4());
        }
        if (pSDEViewBaseBase.isWidthDirty() && (bl || pSDEViewBaseBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEViewBaseBase.getWidth());
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
        return PSDEViewBaseBase.remove(this, n);
    }

    private static boolean remove(PSDEViewBaseBase pSDEViewBaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewBaseBase.resetAccUserMode();
                return true;
            }
            case 1: {
                pSDEViewBaseBase.resetBottomInfo();
                return true;
            }
            case 2: {
                pSDEViewBaseBase.resetCapPSLanResId();
                return true;
            }
            case 3: {
                pSDEViewBaseBase.resetCapPSLanResName();
                return true;
            }
            case 4: {
                pSDEViewBaseBase.resetCaption();
                return true;
            }
            case 5: {
                pSDEViewBaseBase.resetCodeName();
                return true;
            }
            case 6: {
                pSDEViewBaseBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDEViewBaseBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDEViewBaseBase.resetDEViewTag();
                return true;
            }
            case 9: {
                pSDEViewBaseBase.resetDEViewTag2();
                return true;
            }
            case 10: {
                pSDEViewBaseBase.resetDEViewTag3();
                return true;
            }
            case 11: {
                pSDEViewBaseBase.resetDEViewTag4();
                return true;
            }
            case 12: {
                pSDEViewBaseBase.resetDynaModelFlag();
                return true;
            }
            case 13: {
                pSDEViewBaseBase.resetDyncMode();
                return true;
            }
            case 14: {
                pSDEViewBaseBase.resetEnableViewActions();
                return true;
            }
            case 15: {
                pSDEViewBaseBase.resetGroupPSCodeListId();
                return true;
            }
            case 16: {
                pSDEViewBaseBase.resetGroupPSCodeListName();
                return true;
            }
            case 17: {
                pSDEViewBaseBase.resetHeaderInfo();
                return true;
            }
            case 18: {
                pSDEViewBaseBase.resetHeight();
                return true;
            }
            case 19: {
                pSDEViewBaseBase.resetLayoutPanelMode();
                return true;
            }
            case 20: {
                pSDEViewBaseBase.resetLoadDefault();
                return true;
            }
            case 21: {
                pSDEViewBaseBase.resetLockFlag();
                return true;
            }
            case 22: {
                pSDEViewBaseBase.resetMemo();
                return true;
            }
            case 23: {
                pSDEViewBaseBase.resetModelState();
                return true;
            }
            case 24: {
                pSDEViewBaseBase.resetOpenMode();
                return true;
            }
            case 25: {
                pSDEViewBaseBase.resetPDTParamPre();
                return true;
            }
            case 26: {
                pSDEViewBaseBase.resetPDVTParam();
                return true;
            }
            case 27: {
                pSDEViewBaseBase.resetPredefinedViewType();
                return true;
            }
            case 28: {
                pSDEViewBaseBase.resetPSACHandlerId();
                return true;
            }
            case 29: {
                pSDEViewBaseBase.resetPSACHandlerName();
                return true;
            }
            case 30: {
                pSDEViewBaseBase.resetPSAppViewCnt();
                return true;
            }
            case 31: {
                pSDEViewBaseBase.resetPSAppViewsCnt();
                return true;
            }
            case 32: {
                pSDEViewBaseBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 33: {
                pSDEViewBaseBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 34: {
                pSDEViewBaseBase.resetPSDEAWGroupId();
                return true;
            }
            case 35: {
                pSDEViewBaseBase.resetPSDEAWGroupName();
                return true;
            }
            case 36: {
                pSDEViewBaseBase.resetPSDEId();
                return true;
            }
            case 37: {
                pSDEViewBaseBase.resetPSDEMainStateId();
                return true;
            }
            case 38: {
                pSDEViewBaseBase.resetPSDEMainStateName();
                return true;
            }
            case 39: {
                pSDEViewBaseBase.resetPSDEName();
                return true;
            }
            case 40: {
                pSDEViewBaseBase.resetPSDERId();
                return true;
            }
            case 41: {
                pSDEViewBaseBase.resetPSDERName();
                return true;
            }
            case 42: {
                pSDEViewBaseBase.resetPSDEViewBaseId();
                return true;
            }
            case 43: {
                pSDEViewBaseBase.resetPSDEViewBaseName();
                return true;
            }
            case 44: {
                pSDEViewBaseBase.resetPSDEViewBaseType();
                return true;
            }
            case 45: {
                pSDEViewBaseBase.resetPSDynaDEViewTemplId();
                return true;
            }
            case 46: {
                pSDEViewBaseBase.resetPSDynaDEViewTemplName();
                return true;
            }
            case 47: {
                pSDEViewBaseBase.resetPSDynaInstId();
                return true;
            }
            case 48: {
                pSDEViewBaseBase.resetPSHelpModuleId();
                return true;
            }
            case 49: {
                pSDEViewBaseBase.resetPSHelpModuleName();
                return true;
            }
            case 50: {
                pSDEViewBaseBase.resetPSSubViewTypeId();
                return true;
            }
            case 51: {
                pSDEViewBaseBase.resetPSSubViewTypeName();
                return true;
            }
            case 52: {
                pSDEViewBaseBase.resetPSSysCounterId();
                return true;
            }
            case 53: {
                pSDEViewBaseBase.resetPSSysCounterName();
                return true;
            }
            case 54: {
                pSDEViewBaseBase.resetPSSysCssId();
                return true;
            }
            case 55: {
                pSDEViewBaseBase.resetPSSysCssName();
                return true;
            }
            case 56: {
                pSDEViewBaseBase.resetPSSysDynaModelId();
                return true;
            }
            case 57: {
                pSDEViewBaseBase.resetPSSysDynaModelName();
                return true;
            }
            case 58: {
                pSDEViewBaseBase.resetPSSysImageId();
                return true;
            }
            case 59: {
                pSDEViewBaseBase.resetPSSysImageName();
                return true;
            }
            case 60: {
                pSDEViewBaseBase.resetPSSysPFPluginId();
                return true;
            }
            case 61: {
                pSDEViewBaseBase.resetPSSysPFPluginName();
                return true;
            }
            case 62: {
                pSDEViewBaseBase.resetPSSysReqItemId();
                return true;
            }
            case 63: {
                pSDEViewBaseBase.resetPSSysReqItemName();
                return true;
            }
            case 64: {
                pSDEViewBaseBase.resetPSSystemId();
                return true;
            }
            case 65: {
                pSDEViewBaseBase.resetPSSystemName();
                return true;
            }
            case 66: {
                pSDEViewBaseBase.resetPSSysUniResId();
                return true;
            }
            case 67: {
                pSDEViewBaseBase.resetPSSysUniResName();
                return true;
            }
            case 68: {
                pSDEViewBaseBase.resetPSSysViewPanelId();
                return true;
            }
            case 69: {
                pSDEViewBaseBase.resetPSSysViewPanelName();
                return true;
            }
            case 70: {
                pSDEViewBaseBase.resetPSViewEngineId();
                return true;
            }
            case 71: {
                pSDEViewBaseBase.resetPSViewEngineName();
                return true;
            }
            case 72: {
                pSDEViewBaseBase.resetPSViewMsgGroupId();
                return true;
            }
            case 73: {
                pSDEViewBaseBase.resetPSViewMsgGroupName();
                return true;
            }
            case 74: {
                pSDEViewBaseBase.resetPSVTStyleId();
                return true;
            }
            case 75: {
                pSDEViewBaseBase.resetPSVTStyleName();
                return true;
            }
            case 76: {
                pSDEViewBaseBase.resetPSWFDEId();
                return true;
            }
            case 77: {
                pSDEViewBaseBase.resetPSWFDEName();
                return true;
            }
            case 78: {
                pSDEViewBaseBase.resetPSWFId();
                return true;
            }
            case 79: {
                pSDEViewBaseBase.resetPSWFVersionId();
                return true;
            }
            case 80: {
                pSDEViewBaseBase.resetPSWFVersionName();
                return true;
            }
            case 81: {
                pSDEViewBaseBase.resetReadOnlyMode();
                return true;
            }
            case 82: {
                pSDEViewBaseBase.resetShowCaptionBar();
                return true;
            }
            case 83: {
                pSDEViewBaseBase.resetSRFSysPub();
                return true;
            }
            case 84: {
                pSDEViewBaseBase.resetSubCapPSLanResId();
                return true;
            }
            case 85: {
                pSDEViewBaseBase.resetSubCapPSLanResName();
                return true;
            }
            case 86: {
                pSDEViewBaseBase.resetSubCaption();
                return true;
            }
            case 87: {
                pSDEViewBaseBase.resetTempMode();
                return true;
            }
            case 88: {
                pSDEViewBaseBase.resetTitle();
                return true;
            }
            case 89: {
                pSDEViewBaseBase.resetTitlePSLanResId();
                return true;
            }
            case 90: {
                pSDEViewBaseBase.resetTitlePSLanResName();
                return true;
            }
            case 91: {
                pSDEViewBaseBase.resetToDoTask();
                return true;
            }
            case 92: {
                pSDEViewBaseBase.resetUpdateDate();
                return true;
            }
            case 93: {
                pSDEViewBaseBase.resetUpdateMan();
                return true;
            }
            case 94: {
                pSDEViewBaseBase.resetUserData();
                return true;
            }
            case 95: {
                pSDEViewBaseBase.resetUserData2();
                return true;
            }
            case 96: {
                pSDEViewBaseBase.resetUserParams();
                return true;
            }
            case 97: {
                pSDEViewBaseBase.resetViewActions();
                return true;
            }
            case 98: {
                pSDEViewBaseBase.resetViewModel();
                return true;
            }
            case 99: {
                pSDEViewBaseBase.resetViewParam();
                return true;
            }
            case 100: {
                pSDEViewBaseBase.resetViewParam10();
                return true;
            }
            case 101: {
                pSDEViewBaseBase.resetViewParam11();
                return true;
            }
            case 102: {
                pSDEViewBaseBase.resetViewParam12();
                return true;
            }
            case 103: {
                pSDEViewBaseBase.resetViewParam13();
                return true;
            }
            case 104: {
                pSDEViewBaseBase.resetViewParam14();
                return true;
            }
            case 105: {
                pSDEViewBaseBase.resetViewParam15();
                return true;
            }
            case 106: {
                pSDEViewBaseBase.resetViewParam16();
                return true;
            }
            case 107: {
                pSDEViewBaseBase.resetViewParam17();
                return true;
            }
            case 108: {
                pSDEViewBaseBase.resetViewParam18();
                return true;
            }
            case 109: {
                pSDEViewBaseBase.resetViewParam2();
                return true;
            }
            case 110: {
                pSDEViewBaseBase.resetViewParam3();
                return true;
            }
            case 111: {
                pSDEViewBaseBase.resetViewParam4();
                return true;
            }
            case 112: {
                pSDEViewBaseBase.resetViewParam5();
                return true;
            }
            case 113: {
                pSDEViewBaseBase.resetViewParam6();
                return true;
            }
            case 114: {
                pSDEViewBaseBase.resetViewParam7();
                return true;
            }
            case 115: {
                pSDEViewBaseBase.resetViewParam8();
                return true;
            }
            case 116: {
                pSDEViewBaseBase.resetViewParam9();
                return true;
            }
            case 117: {
                pSDEViewBaseBase.resetViewParams();
                return true;
            }
            case 118: {
                pSDEViewBaseBase.resetViewSN();
                return true;
            }
            case 119: {
                pSDEViewBaseBase.resetWFViewParam();
                return true;
            }
            case 120: {
                pSDEViewBaseBase.resetWFViewParam2();
                return true;
            }
            case 121: {
                pSDEViewBaseBase.resetWFViewParam3();
                return true;
            }
            case 122: {
                pSDEViewBaseBase.resetWFViewParam4();
                return true;
            }
            case 123: {
                pSDEViewBaseBase.resetWidth();
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
    public PSDEAWGroup getPSDEAWGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroup();
        }
        if (this.getPSDEAWGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEAWGroupLock;
        synchronized (n) {
            if (this.psdeawgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEAWGroupId(), (Object)this.psdeawgroup.getPSDEAWGroupId()) != 0L) {
                this.psdeawgroup = null;
            }
            if (this.psdeawgroup == null) {
                PSDEAWGroup pSDEAWGroup = new PSDEAWGroup();
                pSDEAWGroup.setPSDEAWGroupId(this.getPSDEAWGroupId());
                PSDEAWGroupService pSDEAWGroupService = (PSDEAWGroupService)ServiceGlobal.getService(PSDEAWGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEAWGroupService.autoGet(pSDEAWGroup);
                this.psdeawgroup = pSDEAWGroup;
            }
            return this.psdeawgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaDEViewTempl getPSDynaDEViewTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewTempl();
        }
        if (this.getPSDynaDEViewTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDynaDEViewTemplLock;
        synchronized (n) {
            if (this.psdynadeviewtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaDEViewTemplId(), (Object)this.psdynadeviewtempl.getPSDynaDEViewTemplId()) != 0L) {
                this.psdynadeviewtempl = null;
            }
            if (this.psdynadeviewtempl == null) {
                PSDynaDEViewTempl pSDynaDEViewTempl = new PSDynaDEViewTempl();
                pSDynaDEViewTempl.setPSDynaDEViewTemplId(this.getPSDynaDEViewTemplId());
                PSDynaDEViewTemplService pSDynaDEViewTemplService = (PSDynaDEViewTemplService)ServiceGlobal.getService(PSDynaDEViewTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDynaDEViewTemplService.autoGet(pSDynaDEViewTempl);
                this.psdynadeviewtempl = pSDynaDEViewTempl;
            }
            return this.psdynadeviewtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpModule getPSHelpModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModule();
        }
        if (this.getPSHelpModuleId() == null) {
            return null;
        }
        Integer n = this.objPSHelpModuleLock;
        synchronized (n) {
            if (this.pshelpmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpModuleId(), (Object)this.pshelpmodule.getPSHelpModuleId()) != 0L) {
                this.pshelpmodule = null;
            }
            if (this.pshelpmodule == null) {
                PSHelpModule pSHelpModule = new PSHelpModule();
                pSHelpModule.setPSHelpModuleId(this.getPSHelpModuleId());
                PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpModuleService.autoGet(pSHelpModule);
                this.pshelpmodule = pSHelpModule;
            }
            return this.pshelpmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getSubCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCapPSLanRes();
        }
        if (this.getSubCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objSubCapPSLanResLock;
        synchronized (n) {
            if (this.subcappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getSubCapPSLanResId(), (Object)this.subcappslanres.getPSLanguageResId()) != 0L) {
                this.subcappslanres = null;
            }
            if (this.subcappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getSubCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.subcappslanres = pSLanguageRes;
            }
            return this.subcappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanRes();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanResLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubViewType getPSSubViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewType();
        }
        if (this.getPSSubViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSSubViewTypeLock;
        synchronized (n) {
            if (this.pssubviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubViewTypeId(), (Object)this.pssubviewtype.getPSSubViewTypeId()) != 0L) {
                this.pssubviewtype = null;
            }
            if (this.pssubviewtype == null) {
                PSSubViewType pSSubViewType = new PSSubViewType();
                pSSubViewType.setPSSubViewTypeId(this.getPSSubViewTypeId());
                PSSubViewTypeService pSSubViewTypeService = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSubViewTypeService.autoGet(pSSubViewType);
                this.pssubviewtype = pSSubViewType;
            }
            return this.pssubviewtype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet(pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
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
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
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
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
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
    public PSViewEngine getPSViewEngine() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngine();
        }
        if (this.getPSViewEngineId() == null) {
            return null;
        }
        Integer n = this.objPSViewEngineLock;
        synchronized (n) {
            if (this.psviewengine != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewEngineId(), (Object)this.psviewengine.getPSViewEngineId()) != 0L) {
                this.psviewengine = null;
            }
            if (this.psviewengine == null) {
                PSViewEngine pSViewEngine = new PSViewEngine();
                pSViewEngine.setPSViewEngineId(this.getPSViewEngineId());
                PSViewEngineService pSViewEngineService = (PSViewEngineService)ServiceGlobal.getService(PSViewEngineService.class, (SessionFactory)this.getSessionFactory());
                pSViewEngineService.autoGet(pSViewEngine);
                this.psviewengine = pSViewEngine;
            }
            return this.psviewengine;
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
    public PSVTStyle getPSVTStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTStyle();
        }
        if (this.getPSVTStyleId() == null) {
            return null;
        }
        Integer n = this.objPSVTStyleLock;
        synchronized (n) {
            if (this.psvtstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSVTStyleId(), (Object)this.psvtstyle.getPSVTStyleId()) != 0L) {
                this.psvtstyle = null;
            }
            if (this.psvtstyle == null) {
                PSVTStyle pSVTStyle = new PSVTStyle();
                pSVTStyle.setPSVTStyleId(this.getPSVTStyleId());
                PSVTStyleService pSVTStyleService = (PSVTStyleService)ServiceGlobal.getService(PSVTStyleService.class, (SessionFactory)this.getSessionFactory());
                pSVTStyleService.autoGet(pSVTStyle);
                this.psvtstyle = pSVTStyle;
            }
            return this.psvtstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getPSWFDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDE();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFDELock;
        synchronized (n) {
            if (this.pswfde != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswfde.getPSWFDEId()) != 0L) {
                this.pswfde = null;
            }
            if (this.pswfde == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet(pSWFDE);
                this.pswfde = pSWFDE;
            }
            return this.pswfde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet(pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppView> getPSAppViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViews();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppViewsLock;
        synchronized (n) {
            if (this.psappviews == null) {
                this.psappviews = pSAppViewService.selectByPSDEViewBase(this);
            }
            return this.psappviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewCtrl> getPSDEViewCtrls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrls();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewCtrlsLock;
        synchronized (n) {
            if (this.psdeviewctrls == null) {
                this.psdeviewctrls = pSDEViewBaseService.isTempData(this) ? pSDEViewCtrlService.selectTempByPSDEViewBase(this) : pSDEViewCtrlService.selectByPSDEViewBase(this);
            }
            return this.psdeviewctrls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewEngine> getPSDEViewEngines() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewEngines();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewEnginesLock;
        synchronized (n) {
            if (this.psdeviewengines == null) {
                this.psdeviewengines = pSDEViewBaseService.isTempData(this) ? pSDEViewEngineService.selectTempByPSDEViewBase(this) : pSDEViewEngineService.selectByPSDEViewBase(this);
            }
            return this.psdeviewengines;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewService> getPSDEViewServices() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewServices();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        PSDEViewServiceService pSDEViewServiceService = (PSDEViewServiceService)ServiceGlobal.getService(PSDEViewServiceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewServicesLock;
        synchronized (n) {
            if (this.psdeviewservices == null) {
                this.psdeviewservices = pSDEViewServiceService.selectByPSDEViewBase(this);
            }
            return this.psdeviewservices;
        }
    }

    private PSDEViewBaseBase getProxyEntity() {
        return this.proxyPSDEViewBaseBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewBaseBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewBaseBase) {
            this.proxyPSDEViewBaseBase = (PSDEViewBaseBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCUSERMODE, 0);
        fieldIndexMap.put(FIELD_BOTTOMINFO, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 2);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 3);
        fieldIndexMap.put(FIELD_CAPTION, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DEVIEWTAG, 8);
        fieldIndexMap.put(FIELD_DEVIEWTAG2, 9);
        fieldIndexMap.put(FIELD_DEVIEWTAG3, 10);
        fieldIndexMap.put(FIELD_DEVIEWTAG4, 11);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 12);
        fieldIndexMap.put(FIELD_DYNCMODE, 13);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 14);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTID, 15);
        fieldIndexMap.put(FIELD_GROUPPSCODELISTNAME, 16);
        fieldIndexMap.put(FIELD_HEADERINFO, 17);
        fieldIndexMap.put(FIELD_HEIGHT, 18);
        fieldIndexMap.put(FIELD_LAYOUTPANELMODE, 19);
        fieldIndexMap.put(FIELD_LOADDEFAULT, 20);
        fieldIndexMap.put(FIELD_LOCKFLAG, 21);
        fieldIndexMap.put(FIELD_MEMO, 22);
        fieldIndexMap.put(FIELD_MODELSTATE, 23);
        fieldIndexMap.put(FIELD_OPENMODE, 24);
        fieldIndexMap.put(FIELD_PDTPARAMPRE, 25);
        fieldIndexMap.put(FIELD_PDVTPARAM, 26);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 27);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 28);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 29);
        fieldIndexMap.put(FIELD_PSAPPVIEWCNT, 30);
        fieldIndexMap.put(FIELD_PSAPPVIEWSCNT, 31);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 32);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 33);
        fieldIndexMap.put(FIELD_PSDEAWGROUPID, 34);
        fieldIndexMap.put(FIELD_PSDEAWGROUPNAME, 35);
        fieldIndexMap.put(FIELD_PSDEID, 36);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 37);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 38);
        fieldIndexMap.put(FIELD_PSDENAME, 39);
        fieldIndexMap.put(FIELD_PSDERID, 40);
        fieldIndexMap.put(FIELD_PSDERNAME, 41);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 42);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 43);
        fieldIndexMap.put(FIELD_PSDEVIEWBASETYPE, 44);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLID, 45);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, 46);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 47);
        fieldIndexMap.put(FIELD_PSHELPMODULEID, 48);
        fieldIndexMap.put(FIELD_PSHELPMODULENAME, 49);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPEID, 50);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPENAME, 51);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 52);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 53);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 54);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 55);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 56);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 57);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 58);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 59);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 60);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 61);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 62);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 63);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 64);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 65);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 66);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 67);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 68);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 69);
        fieldIndexMap.put(FIELD_PSVIEWENGINEID, 70);
        fieldIndexMap.put(FIELD_PSVIEWENGINENAME, 71);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 72);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 73);
        fieldIndexMap.put(FIELD_PSVTSTYLEID, 74);
        fieldIndexMap.put(FIELD_PSVTSTYLENAME, 75);
        fieldIndexMap.put(FIELD_PSWFDEID, 76);
        fieldIndexMap.put(FIELD_PSWFDENAME, 77);
        fieldIndexMap.put(FIELD_PSWFID, 78);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 79);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 80);
        fieldIndexMap.put(FIELD_READONLYMODE, 81);
        fieldIndexMap.put(FIELD_SHOWCAPTIONBAR, 82);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 83);
        fieldIndexMap.put(FIELD_SUBCAPPSLANRESID, 84);
        fieldIndexMap.put(FIELD_SUBCAPPSLANRESNAME, 85);
        fieldIndexMap.put(FIELD_SUBCAPTION, 86);
        fieldIndexMap.put(FIELD_TEMPMODE, 87);
        fieldIndexMap.put(FIELD_TITLE, 88);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 89);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 90);
        fieldIndexMap.put(FIELD_TODOTASK, 91);
        fieldIndexMap.put(FIELD_UPDATEDATE, 92);
        fieldIndexMap.put(FIELD_UPDATEMAN, 93);
        fieldIndexMap.put(FIELD_USERDATA, 94);
        fieldIndexMap.put(FIELD_USERDATA2, 95);
        fieldIndexMap.put(FIELD_USERPARAMS, 96);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 97);
        fieldIndexMap.put(FIELD_VIEWMODEL, 98);
        fieldIndexMap.put(FIELD_VIEWPARAM, 99);
        fieldIndexMap.put(FIELD_VIEWPARAM10, 100);
        fieldIndexMap.put(FIELD_VIEWPARAM11, 101);
        fieldIndexMap.put(FIELD_VIEWPARAM12, 102);
        fieldIndexMap.put(FIELD_VIEWPARAM13, 103);
        fieldIndexMap.put(FIELD_VIEWPARAM14, 104);
        fieldIndexMap.put(FIELD_VIEWPARAM15, 105);
        fieldIndexMap.put(FIELD_VIEWPARAM16, 106);
        fieldIndexMap.put(FIELD_VIEWPARAM17, 107);
        fieldIndexMap.put(FIELD_VIEWPARAM18, 108);
        fieldIndexMap.put(FIELD_VIEWPARAM2, 109);
        fieldIndexMap.put(FIELD_VIEWPARAM3, 110);
        fieldIndexMap.put(FIELD_VIEWPARAM4, 111);
        fieldIndexMap.put(FIELD_VIEWPARAM5, 112);
        fieldIndexMap.put(FIELD_VIEWPARAM6, 113);
        fieldIndexMap.put(FIELD_VIEWPARAM7, 114);
        fieldIndexMap.put(FIELD_VIEWPARAM8, 115);
        fieldIndexMap.put(FIELD_VIEWPARAM9, 116);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 117);
        fieldIndexMap.put(FIELD_VIEWSN, 118);
        fieldIndexMap.put(FIELD_WFVIEWPARAM, 119);
        fieldIndexMap.put(FIELD_WFVIEWPARAM2, 120);
        fieldIndexMap.put(FIELD_WFVIEWPARAM3, 121);
        fieldIndexMap.put(FIELD_WFVIEWPARAM4, 122);
        fieldIndexMap.put(FIELD_WIDTH, 123);
    }
}

