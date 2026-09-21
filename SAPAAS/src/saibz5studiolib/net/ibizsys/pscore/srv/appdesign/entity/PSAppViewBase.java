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
package net.ibizsys.pscore.srv.appdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBar;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyle;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewEngineService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewWizardGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewBase.class);
    public static final String FIELD_ACCUSERMODE = "ACCUSERMODE";
    public static final String FIELD_APPVIEWSN = "APPVIEWSN";
    public static final String FIELD_APPVIEWSTATE = "APPVIEWSTATE";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_DYNCMODE = "DYNCMODE";
    public static final String FIELD_ENABLEVIEWSTYLE = "ENABLEVIEWSTYLE";
    public static final String FIELD_LAYOUTPANELMODE = "LAYOUTPANELMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODCOLOR = "MODCOLOR";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSAPPTITLEBARID = "PSAPPTITLEBARID";
    public static final String FIELD_PSAPPTITLEBARNAME = "PSAPPTITLEBARNAME";
    public static final String FIELD_PSAPPUTILVIEWTYPE = "PSAPPUTILVIEWTYPE";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSAPPVIEWSTYLEID = "PSAPPVIEWSTYLEID";
    public static final String FIELD_PSAPPVIEWSTYLENAME = "PSAPPVIEWSTYLENAME";
    public static final String FIELD_PSAPPVIEWTYPE = "PSAPPVIEWTYPE";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEVIEWTYPE = "PSDEVIEWTYPE";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String FIELD_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String FIELD_PSDYNADEVIEWTYPE = "PSDYNADEVIEWTYPE";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String FIELD_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String FIELD_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String FIELD_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PSVIEWWIZARDGROUPID = "PSVIEWWIZARDGROUPID";
    public static final String FIELD_PSVIEWWIZARDGROUPNAME = "PSVIEWWIZARDGROUPNAME";
    public static final String FIELD_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String FIELD_SUBCAPPSLANRESID = "SUBCAPPSLANRESID";
    public static final String FIELD_SUBCAPPSLANRESNAME = "SUBCAPPSLANRESNAME";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_SYNCCODENAME = "SYNCCODENAME";
    public static final String FIELD_SYSREFFLAG = "SYSREFFLAG";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UISTYLE = "UISTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERREFFLAG = "USERREFFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ACCUSERMODE = 0;
    private static final int INDEX_APPVIEWSN = 1;
    private static final int INDEX_APPVIEWSTATE = 2;
    private static final int INDEX_CAPPSLANRESID = 3;
    private static final int INDEX_CAPPSLANRESNAME = 4;
    private static final int INDEX_CAPTION = 5;
    private static final int INDEX_COLOR = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_DYNAMODELFLAG = 9;
    private static final int INDEX_DYNCMODE = 10;
    private static final int INDEX_ENABLEVIEWSTYLE = 11;
    private static final int INDEX_LAYOUTPANELMODE = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MODCOLOR = 14;
    private static final int INDEX_PREVENTXSS = 15;
    private static final int INDEX_PSACHANDLERID = 16;
    private static final int INDEX_PSACHANDLERNAME = 17;
    private static final int INDEX_PSAPPLOCALDEID = 18;
    private static final int INDEX_PSAPPLOCALDENAME = 19;
    private static final int INDEX_PSAPPMODULEID = 20;
    private static final int INDEX_PSAPPMODULENAME = 21;
    private static final int INDEX_PSAPPTITLEBARID = 22;
    private static final int INDEX_PSAPPTITLEBARNAME = 23;
    private static final int INDEX_PSAPPUTILVIEWTYPE = 24;
    private static final int INDEX_PSAPPVIEWID = 25;
    private static final int INDEX_PSAPPVIEWNAME = 26;
    private static final int INDEX_PSAPPVIEWSTYLEID = 27;
    private static final int INDEX_PSAPPVIEWSTYLENAME = 28;
    private static final int INDEX_PSAPPVIEWTYPE = 29;
    private static final int INDEX_PSCTRLLOGICGROUPID = 30;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 31;
    private static final int INDEX_PSDEVIEWBASEID = 32;
    private static final int INDEX_PSDEVIEWBASENAME = 33;
    private static final int INDEX_PSDEVIEWTYPE = 34;
    private static final int INDEX_PSDYNADEVIEWTEMPLID = 35;
    private static final int INDEX_PSDYNADEVIEWTEMPLNAME = 36;
    private static final int INDEX_PSDYNADEVIEWTYPE = 37;
    private static final int INDEX_PSDYNAINSTID = 38;
    private static final int INDEX_PSHELPMODULEID = 39;
    private static final int INDEX_PSHELPMODULENAME = 40;
    private static final int INDEX_PSPFID = 41;
    private static final int INDEX_PSPFSTYLEID = 42;
    private static final int INDEX_PSPFSTYLENAME = 43;
    private static final int INDEX_PSSUBVIEWTYPEID = 44;
    private static final int INDEX_PSSUBVIEWTYPENAME = 45;
    private static final int INDEX_PSSYSAPPID = 46;
    private static final int INDEX_PSSYSAPPNAME = 47;
    private static final int INDEX_PSSYSCSSID = 48;
    private static final int INDEX_PSSYSCSSNAME = 49;
    private static final int INDEX_PSSYSDYNAMODELID = 50;
    private static final int INDEX_PSSYSDYNAMODELNAME = 51;
    private static final int INDEX_PSSYSIMAGEID = 52;
    private static final int INDEX_PSSYSIMAGENAME = 53;
    private static final int INDEX_PSSYSREQITEMID = 54;
    private static final int INDEX_PSSYSREQITEMNAME = 55;
    private static final int INDEX_PSSYSTEMID = 56;
    private static final int INDEX_PSSYSUNIRESID = 57;
    private static final int INDEX_PSSYSUNIRESNAME = 58;
    private static final int INDEX_PSSYSVIEWPANELID = 59;
    private static final int INDEX_PSSYSVIEWPANELNAME = 60;
    private static final int INDEX_PSVIEWENGINEID = 61;
    private static final int INDEX_PSVIEWENGINENAME = 62;
    private static final int INDEX_PSVIEWMSGGROUPID = 63;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 64;
    private static final int INDEX_PSVIEWWIZARDGROUPID = 65;
    private static final int INDEX_PSVIEWWIZARDGROUPNAME = 66;
    private static final int INDEX_SHOWCAPTIONBAR = 67;
    private static final int INDEX_SUBCAPPSLANRESID = 68;
    private static final int INDEX_SUBCAPPSLANRESNAME = 69;
    private static final int INDEX_SUBCAPTION = 70;
    private static final int INDEX_SYNCCODENAME = 71;
    private static final int INDEX_SYSREFFLAG = 72;
    private static final int INDEX_TITLE = 73;
    private static final int INDEX_TITLEPSLANRESID = 74;
    private static final int INDEX_TITLEPSLANRESNAME = 75;
    private static final int INDEX_TODOTASK = 76;
    private static final int INDEX_UISTYLE = 77;
    private static final int INDEX_UPDATEDATE = 78;
    private static final int INDEX_UPDATEMAN = 79;
    private static final int INDEX_USERPARAMS = 80;
    private static final int INDEX_USERREFFLAG = 81;
    private static final int INDEX_USERTAG = 82;
    private static final int INDEX_USERTAG2 = 83;
    private static final int INDEX_USERTAG3 = 84;
    private static final int INDEX_USERTAG4 = 85;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewBase proxyPSAppViewBase = null;
    private boolean accusermodeDirtyFlag = false;
    private boolean appviewsnDirtyFlag = false;
    private boolean appviewstateDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean dyncmodeDirtyFlag = false;
    private boolean enableviewstyleDirtyFlag = false;
    private boolean layoutpanelmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modcolorDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psapptitlebaridDirtyFlag = false;
    private boolean psapptitlebarnameDirtyFlag = false;
    private boolean psapputilviewtypeDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psappviewstyleidDirtyFlag = false;
    private boolean psappviewstylenameDirtyFlag = false;
    private boolean psappviewtypeDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdeviewtypeDirtyFlag = false;
    private boolean psdynadeviewtemplidDirtyFlag = false;
    private boolean psdynadeviewtemplnameDirtyFlag = false;
    private boolean psdynadeviewtypeDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pshelpmoduleidDirtyFlag = false;
    private boolean pshelpmodulenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssubviewtypeidDirtyFlag = false;
    private boolean pssubviewtypenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewengineidDirtyFlag = false;
    private boolean psviewenginenameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean psviewwizardgroupidDirtyFlag = false;
    private boolean psviewwizardgroupnameDirtyFlag = false;
    private boolean showcaptionbarDirtyFlag = false;
    private boolean subcappslanresidDirtyFlag = false;
    private boolean subcappslanresnameDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean synccodenameDirtyFlag = false;
    private boolean sysrefflagDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean uistyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean userrefflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="accusermode")
    private String accusermode;
    @Column(name="appviewsn")
    private String appviewsn;
    @Column(name="appviewstate")
    private Integer appviewstate;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="dyncmode")
    private Integer dyncmode;
    @Column(name="enableviewstyle")
    private Integer enableviewstyle;
    @Column(name="layoutpanelmode")
    private Integer layoutpanelmode;
    @Column(name="memo")
    private String memo;
    @Column(name="modcolor")
    private String modcolor;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psapptitlebarid")
    private String psapptitlebarid;
    @Column(name="psapptitlebarname")
    private String psapptitlebarname;
    @Column(name="psapputilviewtype")
    private String psapputilviewtype;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psappviewstyleid")
    private String psappviewstyleid;
    @Column(name="psappviewstylename")
    private String psappviewstylename;
    @Column(name="psappviewtype")
    private String psappviewtype;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdeviewtype")
    private String psdeviewtype;
    @Column(name="psdynadeviewtemplid")
    private String psdynadeviewtemplid;
    @Column(name="psdynadeviewtemplname")
    private String psdynadeviewtemplname;
    @Column(name="psdynadeviewtype")
    private String psdynadeviewtype;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pshelpmoduleid")
    private String pshelpmoduleid;
    @Column(name="pshelpmodulename")
    private String pshelpmodulename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssubviewtypeid")
    private String pssubviewtypeid;
    @Column(name="pssubviewtypename")
    private String pssubviewtypename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
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
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
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
    @Column(name="psviewwizardgroupid")
    private String psviewwizardgroupid;
    @Column(name="psviewwizardgroupname")
    private String psviewwizardgroupname;
    @Column(name="showcaptionbar")
    private Integer showcaptionbar;
    @Column(name="subcappslanresid")
    private String subcappslanresid;
    @Column(name="subcappslanresname")
    private String subcappslanresname;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="synccodename")
    private Integer synccodename;
    @Column(name="sysrefflag")
    private Integer sysrefflag;
    @Column(name="title")
    private String title;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="uistyle")
    private String uistyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="userrefflag")
    private Integer userrefflag;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE psapplocalde = null;
    private Integer objPSAppModuleLock = new Integer(1);
    private PSAppModule psappmodule = null;
    private Integer objPSAppTitleBarLock = new Integer(1);
    private PSAppTitleBar psapptitlebar = null;
    private Integer objPSAppViewStyleLock = new Integer(1);
    private PSAppViewStyle psappviewstyle = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
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
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSSubViewTypeLock = new Integer(1);
    private PSSubViewType pssubviewtype = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewEngineLock = new Integer(1);
    private PSViewEngine psviewengine = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSViewWizardGroupLock = new Integer(1);
    private PSViewWizardGroup psviewwizardgroup = null;

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

    public void setAppViewSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppViewSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appviewsn = string;
        this.appviewsnDirtyFlag = true;
    }

    public String getAppViewSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppViewSN();
        }
        return this.appviewsn;
    }

    public boolean isAppViewSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppViewSNDirty();
        }
        return this.appviewsnDirtyFlag;
    }

    public void resetAppViewSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppViewSN();
            return;
        }
        this.appviewsnDirtyFlag = false;
        this.appviewsn = null;
    }

    public void setAppViewState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppViewState(n);
            return;
        }
        this.appviewstate = n;
        this.appviewstateDirtyFlag = true;
    }

    public Integer getAppViewState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppViewState();
        }
        return this.appviewstate;
    }

    public boolean isAppViewStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppViewStateDirty();
        }
        return this.appviewstateDirtyFlag;
    }

    public void resetAppViewState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppViewState();
            return;
        }
        this.appviewstateDirtyFlag = false;
        this.appviewstate = null;
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

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setEnableViewStyle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewStyle(n);
            return;
        }
        this.enableviewstyle = n;
        this.enableviewstyleDirtyFlag = true;
    }

    public Integer getEnableViewStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewStyle();
        }
        return this.enableviewstyle;
    }

    public boolean isEnableViewStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewStyleDirty();
        }
        return this.enableviewstyleDirtyFlag;
    }

    public void resetEnableViewStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewStyle();
            return;
        }
        this.enableviewstyleDirtyFlag = false;
        this.enableviewstyle = null;
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

    public void setModColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modcolor = string;
        this.modcolorDirtyFlag = true;
    }

    public String getModColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModColor();
        }
        return this.modcolor;
    }

    public boolean isModColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModColorDirty();
        }
        return this.modcolorDirtyFlag;
    }

    public void resetModColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModColor();
            return;
        }
        this.modcolorDirtyFlag = false;
        this.modcolor = null;
    }

    public void setPreventXSS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreventXSS(n);
            return;
        }
        this.preventxss = n;
        this.preventxssDirtyFlag = true;
    }

    public Integer getPreventXSS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreventXSS();
        }
        return this.preventxss;
    }

    public boolean isPreventXSSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreventXSSDirty();
        }
        return this.preventxssDirtyFlag;
    }

    public void resetPreventXSS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreventXSS();
            return;
        }
        this.preventxssDirtyFlag = false;
        this.preventxss = null;
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

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
    }

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSAppTitleBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTitleBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptitlebarid = string;
        this.psapptitlebaridDirtyFlag = true;
    }

    public String getPSAppTitleBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBarId();
        }
        return this.psapptitlebarid;
    }

    public boolean isPSAppTitleBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTitleBarIdDirty();
        }
        return this.psapptitlebaridDirtyFlag;
    }

    public void resetPSAppTitleBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTitleBarId();
            return;
        }
        this.psapptitlebaridDirtyFlag = false;
        this.psapptitlebarid = null;
    }

    public void setPSAppTitleBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTitleBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptitlebarname = string;
        this.psapptitlebarnameDirtyFlag = true;
    }

    public String getPSAppTitleBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBarName();
        }
        return this.psapptitlebarname;
    }

    public boolean isPSAppTitleBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTitleBarNameDirty();
        }
        return this.psapptitlebarnameDirtyFlag;
    }

    public void resetPSAppTitleBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTitleBarName();
            return;
        }
        this.psapptitlebarnameDirtyFlag = false;
        this.psapptitlebarname = null;
    }

    public void setPSAppUtilViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilviewtype = string;
        this.psapputilviewtypeDirtyFlag = true;
    }

    public String getPSAppUtilViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilViewType();
        }
        return this.psapputilviewtype;
    }

    public boolean isPSAppUtilViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilViewTypeDirty();
        }
        return this.psapputilviewtypeDirtyFlag;
    }

    public void resetPSAppUtilViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilViewType();
            return;
        }
        this.psapputilviewtypeDirtyFlag = false;
        this.psapputilviewtype = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSAppViewStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstyleid = string;
        this.psappviewstyleidDirtyFlag = true;
    }

    public String getPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleId();
        }
        return this.psappviewstyleid;
    }

    public boolean isPSAppViewStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleIdDirty();
        }
        return this.psappviewstyleidDirtyFlag;
    }

    public void resetPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleId();
            return;
        }
        this.psappviewstyleidDirtyFlag = false;
        this.psappviewstyleid = null;
    }

    public void setPSAppViewStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstylename = string;
        this.psappviewstylenameDirtyFlag = true;
    }

    public String getPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleName();
        }
        return this.psappviewstylename;
    }

    public boolean isPSAppViewStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleNameDirty();
        }
        return this.psappviewstylenameDirtyFlag;
    }

    public void resetPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleName();
            return;
        }
        this.psappviewstylenameDirtyFlag = false;
        this.psappviewstylename = null;
    }

    public void setPSAppViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewtype = string;
        this.psappviewtypeDirtyFlag = true;
    }

    public String getPSAppViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewType();
        }
        return this.psappviewtype;
    }

    public boolean isPSAppViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewTypeDirty();
        }
        return this.psappviewtypeDirtyFlag;
    }

    public void resetPSAppViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewType();
            return;
        }
        this.psappviewtypeDirtyFlag = false;
        this.psappviewtype = null;
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

    public void setPSDEViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewtype = string;
        this.psdeviewtypeDirtyFlag = true;
    }

    public String getPSDEViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewType();
        }
        return this.psdeviewtype;
    }

    public boolean isPSDEViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewTypeDirty();
        }
        return this.psdeviewtypeDirtyFlag;
    }

    public void resetPSDEViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewType();
            return;
        }
        this.psdeviewtypeDirtyFlag = false;
        this.psdeviewtype = null;
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

    public void setPSDynaDEViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeviewtype = string;
        this.psdynadeviewtypeDirtyFlag = true;
    }

    public String getPSDynaDEViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEViewType();
        }
        return this.psdynadeviewtype;
    }

    public boolean isPSDynaDEViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEViewTypeDirty();
        }
        return this.psdynadeviewtypeDirtyFlag;
    }

    public void resetPSDynaDEViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEViewType();
            return;
        }
        this.psdynadeviewtypeDirtyFlag = false;
        this.psdynadeviewtype = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSViewWizardGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewWizardGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewwizardgroupid = string;
        this.psviewwizardgroupidDirtyFlag = true;
    }

    public String getPSViewWizardGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroupId();
        }
        return this.psviewwizardgroupid;
    }

    public boolean isPSViewWizardGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewWizardGroupIdDirty();
        }
        return this.psviewwizardgroupidDirtyFlag;
    }

    public void resetPSViewWizardGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewWizardGroupId();
            return;
        }
        this.psviewwizardgroupidDirtyFlag = false;
        this.psviewwizardgroupid = null;
    }

    public void setPSViewWizardGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewWizardGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewwizardgroupname = string;
        this.psviewwizardgroupnameDirtyFlag = true;
    }

    public String getPSViewWizardGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroupName();
        }
        return this.psviewwizardgroupname;
    }

    public boolean isPSViewWizardGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewWizardGroupNameDirty();
        }
        return this.psviewwizardgroupnameDirtyFlag;
    }

    public void resetPSViewWizardGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewWizardGroupName();
            return;
        }
        this.psviewwizardgroupnameDirtyFlag = false;
        this.psviewwizardgroupname = null;
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

    public void setSyncCodeName(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncCodeName(n);
            return;
        }
        this.synccodename = n;
        this.synccodenameDirtyFlag = true;
    }

    public Integer getSyncCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncCodeName();
        }
        return this.synccodename;
    }

    public boolean isSyncCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncCodeNameDirty();
        }
        return this.synccodenameDirtyFlag;
    }

    public void resetSyncCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncCodeName();
            return;
        }
        this.synccodenameDirtyFlag = false;
        this.synccodename = null;
    }

    public void setSysRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRefFlag(n);
            return;
        }
        this.sysrefflag = n;
        this.sysrefflagDirtyFlag = true;
    }

    public Integer getSysRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRefFlag();
        }
        return this.sysrefflag;
    }

    public boolean isSysRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRefFlagDirty();
        }
        return this.sysrefflagDirtyFlag;
    }

    public void resetSysRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRefFlag();
            return;
        }
        this.sysrefflagDirtyFlag = false;
        this.sysrefflag = null;
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

    public void setUIStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uistyle = string;
        this.uistyleDirtyFlag = true;
    }

    public String getUIStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIStyle();
        }
        return this.uistyle;
    }

    public boolean isUIStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIStyleDirty();
        }
        return this.uistyleDirtyFlag;
    }

    public void resetUIStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIStyle();
            return;
        }
        this.uistyleDirtyFlag = false;
        this.uistyle = null;
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

    public void setUserRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRefFlag(n);
            return;
        }
        this.userrefflag = n;
        this.userrefflagDirtyFlag = true;
    }

    public Integer getUserRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRefFlag();
        }
        return this.userrefflag;
    }

    public boolean isUserRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRefFlagDirty();
        }
        return this.userrefflagDirtyFlag;
    }

    public void resetUserRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRefFlag();
            return;
        }
        this.userrefflagDirtyFlag = false;
        this.userrefflag = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSAppViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewBase pSAppViewBase) {
        pSAppViewBase.resetAccUserMode();
        pSAppViewBase.resetAppViewSN();
        pSAppViewBase.resetAppViewState();
        pSAppViewBase.resetCapPSLanResId();
        pSAppViewBase.resetCapPSLanResName();
        pSAppViewBase.resetCaption();
        pSAppViewBase.resetColor();
        pSAppViewBase.resetCreateDate();
        pSAppViewBase.resetCreateMan();
        pSAppViewBase.resetDynaModelFlag();
        pSAppViewBase.resetDyncMode();
        pSAppViewBase.resetEnableViewStyle();
        pSAppViewBase.resetLayoutPanelMode();
        pSAppViewBase.resetMemo();
        pSAppViewBase.resetModColor();
        pSAppViewBase.resetPreventXSS();
        pSAppViewBase.resetPSACHandlerId();
        pSAppViewBase.resetPSACHandlerName();
        pSAppViewBase.resetPSAppLocalDEId();
        pSAppViewBase.resetPSAppLocalDEName();
        pSAppViewBase.resetPSAppModuleId();
        pSAppViewBase.resetPSAppModuleName();
        pSAppViewBase.resetPSAppTitleBarId();
        pSAppViewBase.resetPSAppTitleBarName();
        pSAppViewBase.resetPSAppUtilViewType();
        pSAppViewBase.resetPSAppViewId();
        pSAppViewBase.resetPSAppViewName();
        pSAppViewBase.resetPSAppViewStyleId();
        pSAppViewBase.resetPSAppViewStyleName();
        pSAppViewBase.resetPSAppViewType();
        pSAppViewBase.resetPSCtrlLogicGroupId();
        pSAppViewBase.resetPSCtrlLogicGroupName();
        pSAppViewBase.resetPSDEViewBaseId();
        pSAppViewBase.resetPSDEViewBaseName();
        pSAppViewBase.resetPSDEViewType();
        pSAppViewBase.resetPSDynaDEViewTemplId();
        pSAppViewBase.resetPSDynaDEViewTemplName();
        pSAppViewBase.resetPSDynaDEViewType();
        pSAppViewBase.resetPSDynaInstId();
        pSAppViewBase.resetPSHelpModuleId();
        pSAppViewBase.resetPSHelpModuleName();
        pSAppViewBase.resetPSPFId();
        pSAppViewBase.resetPSPFStyleId();
        pSAppViewBase.resetPSPFStyleName();
        pSAppViewBase.resetPSSubViewTypeId();
        pSAppViewBase.resetPSSubViewTypeName();
        pSAppViewBase.resetPSSysAppId();
        pSAppViewBase.resetPSSysAppName();
        pSAppViewBase.resetPSSysCssId();
        pSAppViewBase.resetPSSysCssName();
        pSAppViewBase.resetPSSysDynaModelId();
        pSAppViewBase.resetPSSysDynaModelName();
        pSAppViewBase.resetPSSysImageId();
        pSAppViewBase.resetPSSysImageName();
        pSAppViewBase.resetPSSysReqItemId();
        pSAppViewBase.resetPSSysReqItemName();
        pSAppViewBase.resetPSSystemId();
        pSAppViewBase.resetPSSysUniResId();
        pSAppViewBase.resetPSSysUniResName();
        pSAppViewBase.resetPSSysViewPanelId();
        pSAppViewBase.resetPSSysViewPanelName();
        pSAppViewBase.resetPSViewEngineId();
        pSAppViewBase.resetPSViewEngineName();
        pSAppViewBase.resetPSViewMsgGroupId();
        pSAppViewBase.resetPSViewMsgGroupName();
        pSAppViewBase.resetPSViewWizardGroupId();
        pSAppViewBase.resetPSViewWizardGroupName();
        pSAppViewBase.resetShowCaptionBar();
        pSAppViewBase.resetSubCapPSLanResId();
        pSAppViewBase.resetSubCapPSLanResName();
        pSAppViewBase.resetSubCaption();
        pSAppViewBase.resetSyncCodeName();
        pSAppViewBase.resetSysRefFlag();
        pSAppViewBase.resetTitle();
        pSAppViewBase.resetTitlePSLanResId();
        pSAppViewBase.resetTitlePSLanResName();
        pSAppViewBase.resetToDoTask();
        pSAppViewBase.resetUIStyle();
        pSAppViewBase.resetUpdateDate();
        pSAppViewBase.resetUpdateMan();
        pSAppViewBase.resetUserParams();
        pSAppViewBase.resetUserRefFlag();
        pSAppViewBase.resetUserTag();
        pSAppViewBase.resetUserTag2();
        pSAppViewBase.resetUserTag3();
        pSAppViewBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccUserModeDirty()) {
            hashMap.put(FIELD_ACCUSERMODE, this.getAccUserMode());
        }
        if (!bl || this.isAppViewSNDirty()) {
            hashMap.put(FIELD_APPVIEWSN, this.getAppViewSN());
        }
        if (!bl || this.isAppViewStateDirty()) {
            hashMap.put(FIELD_APPVIEWSTATE, this.getAppViewState());
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
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isDyncModeDirty()) {
            hashMap.put(FIELD_DYNCMODE, this.getDyncMode());
        }
        if (!bl || this.isEnableViewStyleDirty()) {
            hashMap.put(FIELD_ENABLEVIEWSTYLE, this.getEnableViewStyle());
        }
        if (!bl || this.isLayoutPanelModeDirty()) {
            hashMap.put(FIELD_LAYOUTPANELMODE, this.getLayoutPanelMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModColorDirty()) {
            hashMap.put(FIELD_MODCOLOR, this.getModColor());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSAppTitleBarIdDirty()) {
            hashMap.put(FIELD_PSAPPTITLEBARID, this.getPSAppTitleBarId());
        }
        if (!bl || this.isPSAppTitleBarNameDirty()) {
            hashMap.put(FIELD_PSAPPTITLEBARNAME, this.getPSAppTitleBarName());
        }
        if (!bl || this.isPSAppUtilViewTypeDirty()) {
            hashMap.put(FIELD_PSAPPUTILVIEWTYPE, this.getPSAppUtilViewType());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSAppViewStyleIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLEID, this.getPSAppViewStyleId());
        }
        if (!bl || this.isPSAppViewStyleNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLENAME, this.getPSAppViewStyleName());
        }
        if (!bl || this.isPSAppViewTypeDirty()) {
            hashMap.put(FIELD_PSAPPVIEWTYPE, this.getPSAppViewType());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEViewTypeDirty()) {
            hashMap.put(FIELD_PSDEVIEWTYPE, this.getPSDEViewType());
        }
        if (!bl || this.isPSDynaDEViewTemplIdDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLID, this.getPSDynaDEViewTemplId());
        }
        if (!bl || this.isPSDynaDEViewTemplNameDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, this.getPSDynaDEViewTemplName());
        }
        if (!bl || this.isPSDynaDEViewTypeDirty()) {
            hashMap.put(FIELD_PSDYNADEVIEWTYPE, this.getPSDynaDEViewType());
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSubViewTypeIdDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPEID, this.getPSSubViewTypeId());
        }
        if (!bl || this.isPSSubViewTypeNameDirty()) {
            hashMap.put(FIELD_PSSUBVIEWTYPENAME, this.getPSSubViewTypeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
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
        if (!bl || this.isPSViewWizardGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWWIZARDGROUPID, this.getPSViewWizardGroupId());
        }
        if (!bl || this.isPSViewWizardGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWWIZARDGROUPNAME, this.getPSViewWizardGroupName());
        }
        if (!bl || this.isShowCaptionBarDirty()) {
            hashMap.put(FIELD_SHOWCAPTIONBAR, this.getShowCaptionBar());
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
        if (!bl || this.isSyncCodeNameDirty()) {
            hashMap.put(FIELD_SYNCCODENAME, this.getSyncCodeName());
        }
        if (!bl || this.isSysRefFlagDirty()) {
            hashMap.put(FIELD_SYSREFFLAG, this.getSysRefFlag());
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
        if (!bl || this.isUIStyleDirty()) {
            hashMap.put(FIELD_UISTYLE, this.getUIStyle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserRefFlagDirty()) {
            hashMap.put(FIELD_USERREFFLAG, this.getUserRefFlag());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSAppViewBase.get(this, n);
    }

    private static Object get(PSAppViewBase pSAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewBase.getAccUserMode();
            }
            case 1: {
                return pSAppViewBase.getAppViewSN();
            }
            case 2: {
                return pSAppViewBase.getAppViewState();
            }
            case 3: {
                return pSAppViewBase.getCapPSLanResId();
            }
            case 4: {
                return pSAppViewBase.getCapPSLanResName();
            }
            case 5: {
                return pSAppViewBase.getCaption();
            }
            case 6: {
                return pSAppViewBase.getColor();
            }
            case 7: {
                return pSAppViewBase.getCreateDate();
            }
            case 8: {
                return pSAppViewBase.getCreateMan();
            }
            case 9: {
                return pSAppViewBase.getDynaModelFlag();
            }
            case 10: {
                return pSAppViewBase.getDyncMode();
            }
            case 11: {
                return pSAppViewBase.getEnableViewStyle();
            }
            case 12: {
                return pSAppViewBase.getLayoutPanelMode();
            }
            case 13: {
                return pSAppViewBase.getMemo();
            }
            case 14: {
                return pSAppViewBase.getModColor();
            }
            case 15: {
                return pSAppViewBase.getPreventXSS();
            }
            case 16: {
                return pSAppViewBase.getPSACHandlerId();
            }
            case 17: {
                return pSAppViewBase.getPSACHandlerName();
            }
            case 18: {
                return pSAppViewBase.getPSAppLocalDEId();
            }
            case 19: {
                return pSAppViewBase.getPSAppLocalDEName();
            }
            case 20: {
                return pSAppViewBase.getPSAppModuleId();
            }
            case 21: {
                return pSAppViewBase.getPSAppModuleName();
            }
            case 22: {
                return pSAppViewBase.getPSAppTitleBarId();
            }
            case 23: {
                return pSAppViewBase.getPSAppTitleBarName();
            }
            case 24: {
                return pSAppViewBase.getPSAppUtilViewType();
            }
            case 25: {
                return pSAppViewBase.getPSAppViewId();
            }
            case 26: {
                return pSAppViewBase.getPSAppViewName();
            }
            case 27: {
                return pSAppViewBase.getPSAppViewStyleId();
            }
            case 28: {
                return pSAppViewBase.getPSAppViewStyleName();
            }
            case 29: {
                return pSAppViewBase.getPSAppViewType();
            }
            case 30: {
                return pSAppViewBase.getPSCtrlLogicGroupId();
            }
            case 31: {
                return pSAppViewBase.getPSCtrlLogicGroupName();
            }
            case 32: {
                return pSAppViewBase.getPSDEViewBaseId();
            }
            case 33: {
                return pSAppViewBase.getPSDEViewBaseName();
            }
            case 34: {
                return pSAppViewBase.getPSDEViewType();
            }
            case 35: {
                return pSAppViewBase.getPSDynaDEViewTemplId();
            }
            case 36: {
                return pSAppViewBase.getPSDynaDEViewTemplName();
            }
            case 37: {
                return pSAppViewBase.getPSDynaDEViewType();
            }
            case 38: {
                return pSAppViewBase.getPSDynaInstId();
            }
            case 39: {
                return pSAppViewBase.getPSHelpModuleId();
            }
            case 40: {
                return pSAppViewBase.getPSHelpModuleName();
            }
            case 41: {
                return pSAppViewBase.getPSPFId();
            }
            case 42: {
                return pSAppViewBase.getPSPFStyleId();
            }
            case 43: {
                return pSAppViewBase.getPSPFStyleName();
            }
            case 44: {
                return pSAppViewBase.getPSSubViewTypeId();
            }
            case 45: {
                return pSAppViewBase.getPSSubViewTypeName();
            }
            case 46: {
                return pSAppViewBase.getPSSysAppId();
            }
            case 47: {
                return pSAppViewBase.getPSSysAppName();
            }
            case 48: {
                return pSAppViewBase.getPSSysCssId();
            }
            case 49: {
                return pSAppViewBase.getPSSysCssName();
            }
            case 50: {
                return pSAppViewBase.getPSSysDynaModelId();
            }
            case 51: {
                return pSAppViewBase.getPSSysDynaModelName();
            }
            case 52: {
                return pSAppViewBase.getPSSysImageId();
            }
            case 53: {
                return pSAppViewBase.getPSSysImageName();
            }
            case 54: {
                return pSAppViewBase.getPSSysReqItemId();
            }
            case 55: {
                return pSAppViewBase.getPSSysReqItemName();
            }
            case 56: {
                return pSAppViewBase.getPSSystemId();
            }
            case 57: {
                return pSAppViewBase.getPSSysUniResId();
            }
            case 58: {
                return pSAppViewBase.getPSSysUniResName();
            }
            case 59: {
                return pSAppViewBase.getPSSysViewPanelId();
            }
            case 60: {
                return pSAppViewBase.getPSSysViewPanelName();
            }
            case 61: {
                return pSAppViewBase.getPSViewEngineId();
            }
            case 62: {
                return pSAppViewBase.getPSViewEngineName();
            }
            case 63: {
                return pSAppViewBase.getPSViewMsgGroupId();
            }
            case 64: {
                return pSAppViewBase.getPSViewMsgGroupName();
            }
            case 65: {
                return pSAppViewBase.getPSViewWizardGroupId();
            }
            case 66: {
                return pSAppViewBase.getPSViewWizardGroupName();
            }
            case 67: {
                return pSAppViewBase.getShowCaptionBar();
            }
            case 68: {
                return pSAppViewBase.getSubCapPSLanResId();
            }
            case 69: {
                return pSAppViewBase.getSubCapPSLanResName();
            }
            case 70: {
                return pSAppViewBase.getSubCaption();
            }
            case 71: {
                return pSAppViewBase.getSyncCodeName();
            }
            case 72: {
                return pSAppViewBase.getSysRefFlag();
            }
            case 73: {
                return pSAppViewBase.getTitle();
            }
            case 74: {
                return pSAppViewBase.getTitlePSLanResId();
            }
            case 75: {
                return pSAppViewBase.getTitlePSLanResName();
            }
            case 76: {
                return pSAppViewBase.getToDoTask();
            }
            case 77: {
                return pSAppViewBase.getUIStyle();
            }
            case 78: {
                return pSAppViewBase.getUpdateDate();
            }
            case 79: {
                return pSAppViewBase.getUpdateMan();
            }
            case 80: {
                return pSAppViewBase.getUserParams();
            }
            case 81: {
                return pSAppViewBase.getUserRefFlag();
            }
            case 82: {
                return pSAppViewBase.getUserTag();
            }
            case 83: {
                return pSAppViewBase.getUserTag2();
            }
            case 84: {
                return pSAppViewBase.getUserTag3();
            }
            case 85: {
                return pSAppViewBase.getUserTag4();
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
        PSAppViewBase.set(this, n, object);
    }

    private static void set(PSAppViewBase pSAppViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewBase.setAccUserMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewBase.setAppViewSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewBase.setAppViewState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSAppViewBase.setDyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSAppViewBase.setEnableViewStyle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSAppViewBase.setLayoutPanelMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSAppViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppViewBase.setModColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppViewBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSAppViewBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppViewBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppViewBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppViewBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppViewBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppViewBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppViewBase.setPSAppTitleBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppViewBase.setPSAppTitleBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppViewBase.setPSAppUtilViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppViewBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppViewBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppViewBase.setPSAppViewStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppViewBase.setPSAppViewStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppViewBase.setPSAppViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppViewBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppViewBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppViewBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppViewBase.setPSDEViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppViewBase.setPSDynaDEViewTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppViewBase.setPSDynaDEViewTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppViewBase.setPSDynaDEViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppViewBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppViewBase.setPSHelpModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppViewBase.setPSHelpModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppViewBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppViewBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppViewBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSAppViewBase.setPSSubViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppViewBase.setPSSubViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppViewBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppViewBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSAppViewBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppViewBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppViewBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSAppViewBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSAppViewBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppViewBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSAppViewBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSAppViewBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSAppViewBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSAppViewBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSAppViewBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSAppViewBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSAppViewBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSAppViewBase.setPSViewEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSAppViewBase.setPSViewEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSAppViewBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSAppViewBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSAppViewBase.setPSViewWizardGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSAppViewBase.setPSViewWizardGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSAppViewBase.setShowCaptionBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSAppViewBase.setSubCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSAppViewBase.setSubCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSAppViewBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSAppViewBase.setSyncCodeName(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSAppViewBase.setSysRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 73: {
                pSAppViewBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSAppViewBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSAppViewBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSAppViewBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSAppViewBase.setUIStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSAppViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 79: {
                pSAppViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSAppViewBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSAppViewBase.setUserRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 82: {
                pSAppViewBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSAppViewBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSAppViewBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSAppViewBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewBase pSAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewBase.getAccUserMode() == null;
            }
            case 1: {
                return pSAppViewBase.getAppViewSN() == null;
            }
            case 2: {
                return pSAppViewBase.getAppViewState() == null;
            }
            case 3: {
                return pSAppViewBase.getCapPSLanResId() == null;
            }
            case 4: {
                return pSAppViewBase.getCapPSLanResName() == null;
            }
            case 5: {
                return pSAppViewBase.getCaption() == null;
            }
            case 6: {
                return pSAppViewBase.getColor() == null;
            }
            case 7: {
                return pSAppViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppViewBase.getCreateMan() == null;
            }
            case 9: {
                return pSAppViewBase.getDynaModelFlag() == null;
            }
            case 10: {
                return pSAppViewBase.getDyncMode() == null;
            }
            case 11: {
                return pSAppViewBase.getEnableViewStyle() == null;
            }
            case 12: {
                return pSAppViewBase.getLayoutPanelMode() == null;
            }
            case 13: {
                return pSAppViewBase.getMemo() == null;
            }
            case 14: {
                return pSAppViewBase.getModColor() == null;
            }
            case 15: {
                return pSAppViewBase.getPreventXSS() == null;
            }
            case 16: {
                return pSAppViewBase.getPSACHandlerId() == null;
            }
            case 17: {
                return pSAppViewBase.getPSACHandlerName() == null;
            }
            case 18: {
                return pSAppViewBase.getPSAppLocalDEId() == null;
            }
            case 19: {
                return pSAppViewBase.getPSAppLocalDEName() == null;
            }
            case 20: {
                return pSAppViewBase.getPSAppModuleId() == null;
            }
            case 21: {
                return pSAppViewBase.getPSAppModuleName() == null;
            }
            case 22: {
                return pSAppViewBase.getPSAppTitleBarId() == null;
            }
            case 23: {
                return pSAppViewBase.getPSAppTitleBarName() == null;
            }
            case 24: {
                return pSAppViewBase.getPSAppUtilViewType() == null;
            }
            case 25: {
                return pSAppViewBase.getPSAppViewId() == null;
            }
            case 26: {
                return pSAppViewBase.getPSAppViewName() == null;
            }
            case 27: {
                return pSAppViewBase.getPSAppViewStyleId() == null;
            }
            case 28: {
                return pSAppViewBase.getPSAppViewStyleName() == null;
            }
            case 29: {
                return pSAppViewBase.getPSAppViewType() == null;
            }
            case 30: {
                return pSAppViewBase.getPSCtrlLogicGroupId() == null;
            }
            case 31: {
                return pSAppViewBase.getPSCtrlLogicGroupName() == null;
            }
            case 32: {
                return pSAppViewBase.getPSDEViewBaseId() == null;
            }
            case 33: {
                return pSAppViewBase.getPSDEViewBaseName() == null;
            }
            case 34: {
                return pSAppViewBase.getPSDEViewType() == null;
            }
            case 35: {
                return pSAppViewBase.getPSDynaDEViewTemplId() == null;
            }
            case 36: {
                return pSAppViewBase.getPSDynaDEViewTemplName() == null;
            }
            case 37: {
                return pSAppViewBase.getPSDynaDEViewType() == null;
            }
            case 38: {
                return pSAppViewBase.getPSDynaInstId() == null;
            }
            case 39: {
                return pSAppViewBase.getPSHelpModuleId() == null;
            }
            case 40: {
                return pSAppViewBase.getPSHelpModuleName() == null;
            }
            case 41: {
                return pSAppViewBase.getPSPFId() == null;
            }
            case 42: {
                return pSAppViewBase.getPSPFStyleId() == null;
            }
            case 43: {
                return pSAppViewBase.getPSPFStyleName() == null;
            }
            case 44: {
                return pSAppViewBase.getPSSubViewTypeId() == null;
            }
            case 45: {
                return pSAppViewBase.getPSSubViewTypeName() == null;
            }
            case 46: {
                return pSAppViewBase.getPSSysAppId() == null;
            }
            case 47: {
                return pSAppViewBase.getPSSysAppName() == null;
            }
            case 48: {
                return pSAppViewBase.getPSSysCssId() == null;
            }
            case 49: {
                return pSAppViewBase.getPSSysCssName() == null;
            }
            case 50: {
                return pSAppViewBase.getPSSysDynaModelId() == null;
            }
            case 51: {
                return pSAppViewBase.getPSSysDynaModelName() == null;
            }
            case 52: {
                return pSAppViewBase.getPSSysImageId() == null;
            }
            case 53: {
                return pSAppViewBase.getPSSysImageName() == null;
            }
            case 54: {
                return pSAppViewBase.getPSSysReqItemId() == null;
            }
            case 55: {
                return pSAppViewBase.getPSSysReqItemName() == null;
            }
            case 56: {
                return pSAppViewBase.getPSSystemId() == null;
            }
            case 57: {
                return pSAppViewBase.getPSSysUniResId() == null;
            }
            case 58: {
                return pSAppViewBase.getPSSysUniResName() == null;
            }
            case 59: {
                return pSAppViewBase.getPSSysViewPanelId() == null;
            }
            case 60: {
                return pSAppViewBase.getPSSysViewPanelName() == null;
            }
            case 61: {
                return pSAppViewBase.getPSViewEngineId() == null;
            }
            case 62: {
                return pSAppViewBase.getPSViewEngineName() == null;
            }
            case 63: {
                return pSAppViewBase.getPSViewMsgGroupId() == null;
            }
            case 64: {
                return pSAppViewBase.getPSViewMsgGroupName() == null;
            }
            case 65: {
                return pSAppViewBase.getPSViewWizardGroupId() == null;
            }
            case 66: {
                return pSAppViewBase.getPSViewWizardGroupName() == null;
            }
            case 67: {
                return pSAppViewBase.getShowCaptionBar() == null;
            }
            case 68: {
                return pSAppViewBase.getSubCapPSLanResId() == null;
            }
            case 69: {
                return pSAppViewBase.getSubCapPSLanResName() == null;
            }
            case 70: {
                return pSAppViewBase.getSubCaption() == null;
            }
            case 71: {
                return pSAppViewBase.getSyncCodeName() == null;
            }
            case 72: {
                return pSAppViewBase.getSysRefFlag() == null;
            }
            case 73: {
                return pSAppViewBase.getTitle() == null;
            }
            case 74: {
                return pSAppViewBase.getTitlePSLanResId() == null;
            }
            case 75: {
                return pSAppViewBase.getTitlePSLanResName() == null;
            }
            case 76: {
                return pSAppViewBase.getToDoTask() == null;
            }
            case 77: {
                return pSAppViewBase.getUIStyle() == null;
            }
            case 78: {
                return pSAppViewBase.getUpdateDate() == null;
            }
            case 79: {
                return pSAppViewBase.getUpdateMan() == null;
            }
            case 80: {
                return pSAppViewBase.getUserParams() == null;
            }
            case 81: {
                return pSAppViewBase.getUserRefFlag() == null;
            }
            case 82: {
                return pSAppViewBase.getUserTag() == null;
            }
            case 83: {
                return pSAppViewBase.getUserTag2() == null;
            }
            case 84: {
                return pSAppViewBase.getUserTag3() == null;
            }
            case 85: {
                return pSAppViewBase.getUserTag4() == null;
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
        return PSAppViewBase.contains(this, n);
    }

    private static boolean contains(PSAppViewBase pSAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewBase.isAccUserModeDirty();
            }
            case 1: {
                return pSAppViewBase.isAppViewSNDirty();
            }
            case 2: {
                return pSAppViewBase.isAppViewStateDirty();
            }
            case 3: {
                return pSAppViewBase.isCapPSLanResIdDirty();
            }
            case 4: {
                return pSAppViewBase.isCapPSLanResNameDirty();
            }
            case 5: {
                return pSAppViewBase.isCaptionDirty();
            }
            case 6: {
                return pSAppViewBase.isColorDirty();
            }
            case 7: {
                return pSAppViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppViewBase.isCreateManDirty();
            }
            case 9: {
                return pSAppViewBase.isDynaModelFlagDirty();
            }
            case 10: {
                return pSAppViewBase.isDyncModeDirty();
            }
            case 11: {
                return pSAppViewBase.isEnableViewStyleDirty();
            }
            case 12: {
                return pSAppViewBase.isLayoutPanelModeDirty();
            }
            case 13: {
                return pSAppViewBase.isMemoDirty();
            }
            case 14: {
                return pSAppViewBase.isModColorDirty();
            }
            case 15: {
                return pSAppViewBase.isPreventXSSDirty();
            }
            case 16: {
                return pSAppViewBase.isPSACHandlerIdDirty();
            }
            case 17: {
                return pSAppViewBase.isPSACHandlerNameDirty();
            }
            case 18: {
                return pSAppViewBase.isPSAppLocalDEIdDirty();
            }
            case 19: {
                return pSAppViewBase.isPSAppLocalDENameDirty();
            }
            case 20: {
                return pSAppViewBase.isPSAppModuleIdDirty();
            }
            case 21: {
                return pSAppViewBase.isPSAppModuleNameDirty();
            }
            case 22: {
                return pSAppViewBase.isPSAppTitleBarIdDirty();
            }
            case 23: {
                return pSAppViewBase.isPSAppTitleBarNameDirty();
            }
            case 24: {
                return pSAppViewBase.isPSAppUtilViewTypeDirty();
            }
            case 25: {
                return pSAppViewBase.isPSAppViewIdDirty();
            }
            case 26: {
                return pSAppViewBase.isPSAppViewNameDirty();
            }
            case 27: {
                return pSAppViewBase.isPSAppViewStyleIdDirty();
            }
            case 28: {
                return pSAppViewBase.isPSAppViewStyleNameDirty();
            }
            case 29: {
                return pSAppViewBase.isPSAppViewTypeDirty();
            }
            case 30: {
                return pSAppViewBase.isPSCtrlLogicGroupIdDirty();
            }
            case 31: {
                return pSAppViewBase.isPSCtrlLogicGroupNameDirty();
            }
            case 32: {
                return pSAppViewBase.isPSDEViewBaseIdDirty();
            }
            case 33: {
                return pSAppViewBase.isPSDEViewBaseNameDirty();
            }
            case 34: {
                return pSAppViewBase.isPSDEViewTypeDirty();
            }
            case 35: {
                return pSAppViewBase.isPSDynaDEViewTemplIdDirty();
            }
            case 36: {
                return pSAppViewBase.isPSDynaDEViewTemplNameDirty();
            }
            case 37: {
                return pSAppViewBase.isPSDynaDEViewTypeDirty();
            }
            case 38: {
                return pSAppViewBase.isPSDynaInstIdDirty();
            }
            case 39: {
                return pSAppViewBase.isPSHelpModuleIdDirty();
            }
            case 40: {
                return pSAppViewBase.isPSHelpModuleNameDirty();
            }
            case 41: {
                return pSAppViewBase.isPSPFIdDirty();
            }
            case 42: {
                return pSAppViewBase.isPSPFStyleIdDirty();
            }
            case 43: {
                return pSAppViewBase.isPSPFStyleNameDirty();
            }
            case 44: {
                return pSAppViewBase.isPSSubViewTypeIdDirty();
            }
            case 45: {
                return pSAppViewBase.isPSSubViewTypeNameDirty();
            }
            case 46: {
                return pSAppViewBase.isPSSysAppIdDirty();
            }
            case 47: {
                return pSAppViewBase.isPSSysAppNameDirty();
            }
            case 48: {
                return pSAppViewBase.isPSSysCssIdDirty();
            }
            case 49: {
                return pSAppViewBase.isPSSysCssNameDirty();
            }
            case 50: {
                return pSAppViewBase.isPSSysDynaModelIdDirty();
            }
            case 51: {
                return pSAppViewBase.isPSSysDynaModelNameDirty();
            }
            case 52: {
                return pSAppViewBase.isPSSysImageIdDirty();
            }
            case 53: {
                return pSAppViewBase.isPSSysImageNameDirty();
            }
            case 54: {
                return pSAppViewBase.isPSSysReqItemIdDirty();
            }
            case 55: {
                return pSAppViewBase.isPSSysReqItemNameDirty();
            }
            case 56: {
                return pSAppViewBase.isPSSystemIdDirty();
            }
            case 57: {
                return pSAppViewBase.isPSSysUniResIdDirty();
            }
            case 58: {
                return pSAppViewBase.isPSSysUniResNameDirty();
            }
            case 59: {
                return pSAppViewBase.isPSSysViewPanelIdDirty();
            }
            case 60: {
                return pSAppViewBase.isPSSysViewPanelNameDirty();
            }
            case 61: {
                return pSAppViewBase.isPSViewEngineIdDirty();
            }
            case 62: {
                return pSAppViewBase.isPSViewEngineNameDirty();
            }
            case 63: {
                return pSAppViewBase.isPSViewMsgGroupIdDirty();
            }
            case 64: {
                return pSAppViewBase.isPSViewMsgGroupNameDirty();
            }
            case 65: {
                return pSAppViewBase.isPSViewWizardGroupIdDirty();
            }
            case 66: {
                return pSAppViewBase.isPSViewWizardGroupNameDirty();
            }
            case 67: {
                return pSAppViewBase.isShowCaptionBarDirty();
            }
            case 68: {
                return pSAppViewBase.isSubCapPSLanResIdDirty();
            }
            case 69: {
                return pSAppViewBase.isSubCapPSLanResNameDirty();
            }
            case 70: {
                return pSAppViewBase.isSubCaptionDirty();
            }
            case 71: {
                return pSAppViewBase.isSyncCodeNameDirty();
            }
            case 72: {
                return pSAppViewBase.isSysRefFlagDirty();
            }
            case 73: {
                return pSAppViewBase.isTitleDirty();
            }
            case 74: {
                return pSAppViewBase.isTitlePSLanResIdDirty();
            }
            case 75: {
                return pSAppViewBase.isTitlePSLanResNameDirty();
            }
            case 76: {
                return pSAppViewBase.isToDoTaskDirty();
            }
            case 77: {
                return pSAppViewBase.isUIStyleDirty();
            }
            case 78: {
                return pSAppViewBase.isUpdateDateDirty();
            }
            case 79: {
                return pSAppViewBase.isUpdateManDirty();
            }
            case 80: {
                return pSAppViewBase.isUserParamsDirty();
            }
            case 81: {
                return pSAppViewBase.isUserRefFlagDirty();
            }
            case 82: {
                return pSAppViewBase.isUserTagDirty();
            }
            case 83: {
                return pSAppViewBase.isUserTag2Dirty();
            }
            case 84: {
                return pSAppViewBase.isUserTag3Dirty();
            }
            case 85: {
                return pSAppViewBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewBase pSAppViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewBase.getAccUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accusermode", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getAccUserMode()), (boolean)false);
        }
        if (bl || pSAppViewBase.getAppViewSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewsn", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getAppViewSN()), (boolean)false);
        }
        if (bl || pSAppViewBase.getAppViewState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewstate", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getAppViewState()), (boolean)false);
        }
        if (bl || pSAppViewBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getCaption()), (boolean)false);
        }
        if (bl || pSAppViewBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getColor()), (boolean)false);
        }
        if (bl || pSAppViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSAppViewBase.getDyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dyncmode", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getDyncMode()), (boolean)false);
        }
        if (bl || pSAppViewBase.getEnableViewStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewstyle", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getEnableViewStyle()), (boolean)false);
        }
        if (bl || pSAppViewBase.getLayoutPanelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpanelmode", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getLayoutPanelMode()), (boolean)false);
        }
        if (bl || pSAppViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewBase.getModColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modcolor", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getModColor()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppTitleBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptitlebarid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppTitleBarId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppTitleBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptitlebarname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppTitleBarName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppUtilViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilviewtype", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppUtilViewType()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppViewStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstyleid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppViewStyleId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppViewStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstylename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppViewStyleName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSAppViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewtype", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSAppViewType()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDEViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewtype", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDEViewType()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDynaDEViewTemplId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtemplname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDynaDEViewTemplName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeviewtype", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDynaDEViewType()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSHelpModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmoduleid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSHelpModuleId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSHelpModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmodulename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSHelpModuleName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSubViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypeid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSubViewTypeId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSubViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubviewtypename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSubViewTypeName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewengineid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewEngineId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewenginename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewEngineName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewWizardGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewwizardgroupid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewWizardGroupId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getPSViewWizardGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewwizardgroupname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getPSViewWizardGroupName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getShowCaptionBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showcaptionbar", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getShowCaptionBar()), (boolean)false);
        }
        if (bl || pSAppViewBase.getSubCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcappslanresid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getSubCapPSLanResId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getSubCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcappslanresname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getSubCapPSLanResName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSAppViewBase.getSyncCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"synccodename", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getSyncCodeName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getSysRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrefflag", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getSysRefFlag()), (boolean)false);
        }
        if (bl || pSAppViewBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getTitle()), (boolean)false);
        }
        if (bl || pSAppViewBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSAppViewBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSAppViewBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUIStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uistyle", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUIStyle()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userrefflag", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserRefFlag()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppViewBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppViewBase.getJSONValue((Object)pSAppViewBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewBase pSAppViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewBase.getAccUserMode() != null) {
            object = pSAppViewBase.getAccUserMode();
            xmlNode.setAttribute(FIELD_ACCUSERMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSAppViewBase.getAppViewSN() != null) {
            object = pSAppViewBase.getAppViewSN();
            xmlNode.setAttribute(FIELD_APPVIEWSN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getAppViewState() != null) {
            object = pSAppViewBase.getAppViewState();
            xmlNode.setAttribute(FIELD_APPVIEWSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getCapPSLanResId() != null) {
            object = pSAppViewBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getCapPSLanResName() != null) {
            object = pSAppViewBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getCaption() != null) {
            object = pSAppViewBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getColor() != null) {
            object = pSAppViewBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getCreateDate() != null) {
            object = pSAppViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewBase.getCreateMan() != null) {
            object = pSAppViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getDynaModelFlag() != null) {
            object = pSAppViewBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getDyncMode() != null) {
            object = pSAppViewBase.getDyncMode();
            xmlNode.setAttribute(FIELD_DYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getEnableViewStyle() != null) {
            object = pSAppViewBase.getEnableViewStyle();
            xmlNode.setAttribute(FIELD_ENABLEVIEWSTYLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getLayoutPanelMode() != null) {
            object = pSAppViewBase.getLayoutPanelMode();
            xmlNode.setAttribute(FIELD_LAYOUTPANELMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getMemo() != null) {
            object = pSAppViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getModColor() != null) {
            object = pSAppViewBase.getModColor();
            xmlNode.setAttribute(FIELD_MODCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPreventXSS() != null) {
            object = pSAppViewBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getPSACHandlerId() != null) {
            object = pSAppViewBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSACHandlerName() != null) {
            object = pSAppViewBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppLocalDEId() != null) {
            object = pSAppViewBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppLocalDEName() != null) {
            object = pSAppViewBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppModuleId() != null) {
            object = pSAppViewBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppModuleName() != null) {
            object = pSAppViewBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppTitleBarId() != null) {
            object = pSAppViewBase.getPSAppTitleBarId();
            xmlNode.setAttribute(FIELD_PSAPPTITLEBARID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppTitleBarName() != null) {
            object = pSAppViewBase.getPSAppTitleBarName();
            xmlNode.setAttribute(FIELD_PSAPPTITLEBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppUtilViewType() != null) {
            object = pSAppViewBase.getPSAppUtilViewType();
            xmlNode.setAttribute(FIELD_PSAPPUTILVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppViewId() != null) {
            object = pSAppViewBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppViewName() != null) {
            object = pSAppViewBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppViewStyleId() != null) {
            object = pSAppViewBase.getPSAppViewStyleId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppViewStyleName() != null) {
            object = pSAppViewBase.getPSAppViewStyleName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSAppViewType() != null) {
            object = pSAppViewBase.getPSAppViewType();
            xmlNode.setAttribute(FIELD_PSAPPVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSCtrlLogicGroupId() != null) {
            object = pSAppViewBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSCtrlLogicGroupName() != null) {
            object = pSAppViewBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDEViewBaseId() != null) {
            object = pSAppViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDEViewBaseName() != null) {
            object = pSAppViewBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDEViewType() != null) {
            object = pSAppViewBase.getPSDEViewType();
            xmlNode.setAttribute(FIELD_PSDEVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewTemplId() != null) {
            object = pSAppViewBase.getPSDynaDEViewTemplId();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewTemplName() != null) {
            object = pSAppViewBase.getPSDynaDEViewTemplName();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDynaDEViewType() != null) {
            object = pSAppViewBase.getPSDynaDEViewType();
            xmlNode.setAttribute(FIELD_PSDYNADEVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSDynaInstId() != null) {
            object = pSAppViewBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSHelpModuleId() != null) {
            object = pSAppViewBase.getPSHelpModuleId();
            xmlNode.setAttribute(FIELD_PSHELPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSHelpModuleName() != null) {
            object = pSAppViewBase.getPSHelpModuleName();
            xmlNode.setAttribute(FIELD_PSHELPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSPFId() != null) {
            object = pSAppViewBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSPFStyleId() != null) {
            object = pSAppViewBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSPFStyleName() != null) {
            object = pSAppViewBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSubViewTypeId() != null) {
            object = pSAppViewBase.getPSSubViewTypeId();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSubViewTypeName() != null) {
            object = pSAppViewBase.getPSSubViewTypeName();
            xmlNode.setAttribute(FIELD_PSSUBVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysAppId() != null) {
            object = pSAppViewBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysAppName() != null) {
            object = pSAppViewBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysCssId() != null) {
            object = pSAppViewBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysCssName() != null) {
            object = pSAppViewBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysDynaModelId() != null) {
            object = pSAppViewBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysDynaModelName() != null) {
            object = pSAppViewBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysImageId() != null) {
            object = pSAppViewBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysImageName() != null) {
            object = pSAppViewBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysReqItemId() != null) {
            object = pSAppViewBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysReqItemName() != null) {
            object = pSAppViewBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSystemId() != null) {
            object = pSAppViewBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysUniResId() != null) {
            object = pSAppViewBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysUniResName() != null) {
            object = pSAppViewBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysViewPanelId() != null) {
            object = pSAppViewBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSSysViewPanelName() != null) {
            object = pSAppViewBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewEngineId() != null) {
            object = pSAppViewBase.getPSViewEngineId();
            xmlNode.setAttribute(FIELD_PSVIEWENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewEngineName() != null) {
            object = pSAppViewBase.getPSViewEngineName();
            xmlNode.setAttribute(FIELD_PSVIEWENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewMsgGroupId() != null) {
            object = pSAppViewBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewMsgGroupName() != null) {
            object = pSAppViewBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewWizardGroupId() != null) {
            object = pSAppViewBase.getPSViewWizardGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWWIZARDGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getPSViewWizardGroupName() != null) {
            object = pSAppViewBase.getPSViewWizardGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWWIZARDGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getShowCaptionBar() != null) {
            object = pSAppViewBase.getShowCaptionBar();
            xmlNode.setAttribute(FIELD_SHOWCAPTIONBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getSubCapPSLanResId() != null) {
            object = pSAppViewBase.getSubCapPSLanResId();
            xmlNode.setAttribute(FIELD_SUBCAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getSubCapPSLanResName() != null) {
            object = pSAppViewBase.getSubCapPSLanResName();
            xmlNode.setAttribute(FIELD_SUBCAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getSubCaption() != null) {
            object = pSAppViewBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getSyncCodeName() != null) {
            object = pSAppViewBase.getSyncCodeName();
            xmlNode.setAttribute(FIELD_SYNCCODENAME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getSysRefFlag() != null) {
            object = pSAppViewBase.getSysRefFlag();
            xmlNode.setAttribute(FIELD_SYSREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getTitle() != null) {
            object = pSAppViewBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getTitlePSLanResId() != null) {
            object = pSAppViewBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getTitlePSLanResName() != null) {
            object = pSAppViewBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getToDoTask() != null) {
            object = pSAppViewBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUIStyle() != null) {
            object = pSAppViewBase.getUIStyle();
            xmlNode.setAttribute(FIELD_UISTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUpdateDate() != null) {
            object = pSAppViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewBase.getUpdateMan() != null) {
            object = pSAppViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUserParams() != null) {
            object = pSAppViewBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUserRefFlag() != null) {
            object = pSAppViewBase.getUserRefFlag();
            xmlNode.setAttribute(FIELD_USERREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppViewBase.getUserTag() != null) {
            object = pSAppViewBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUserTag2() != null) {
            object = pSAppViewBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUserTag3() != null) {
            object = pSAppViewBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewBase.getUserTag4() != null) {
            object = pSAppViewBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewBase pSAppViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewBase.isAccUserModeDirty() && (bl || pSAppViewBase.getAccUserMode() != null)) {
            iDataObject.set(FIELD_ACCUSERMODE, (Object)pSAppViewBase.getAccUserMode());
        }
        if (pSAppViewBase.isAppViewSNDirty() && (bl || pSAppViewBase.getAppViewSN() != null)) {
            iDataObject.set(FIELD_APPVIEWSN, (Object)pSAppViewBase.getAppViewSN());
        }
        if (pSAppViewBase.isAppViewStateDirty() && (bl || pSAppViewBase.getAppViewState() != null)) {
            iDataObject.set(FIELD_APPVIEWSTATE, (Object)pSAppViewBase.getAppViewState());
        }
        if (pSAppViewBase.isCapPSLanResIdDirty() && (bl || pSAppViewBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSAppViewBase.getCapPSLanResId());
        }
        if (pSAppViewBase.isCapPSLanResNameDirty() && (bl || pSAppViewBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSAppViewBase.getCapPSLanResName());
        }
        if (pSAppViewBase.isCaptionDirty() && (bl || pSAppViewBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSAppViewBase.getCaption());
        }
        if (pSAppViewBase.isColorDirty() && (bl || pSAppViewBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSAppViewBase.getColor());
        }
        if (pSAppViewBase.isCreateDateDirty() && (bl || pSAppViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewBase.getCreateDate());
        }
        if (pSAppViewBase.isCreateManDirty() && (bl || pSAppViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewBase.getCreateMan());
        }
        if (pSAppViewBase.isDynaModelFlagDirty() && (bl || pSAppViewBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSAppViewBase.getDynaModelFlag());
        }
        if (pSAppViewBase.isDyncModeDirty() && (bl || pSAppViewBase.getDyncMode() != null)) {
            iDataObject.set(FIELD_DYNCMODE, (Object)pSAppViewBase.getDyncMode());
        }
        if (pSAppViewBase.isEnableViewStyleDirty() && (bl || pSAppViewBase.getEnableViewStyle() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWSTYLE, (Object)pSAppViewBase.getEnableViewStyle());
        }
        if (pSAppViewBase.isLayoutPanelModeDirty() && (bl || pSAppViewBase.getLayoutPanelMode() != null)) {
            iDataObject.set(FIELD_LAYOUTPANELMODE, (Object)pSAppViewBase.getLayoutPanelMode());
        }
        if (pSAppViewBase.isMemoDirty() && (bl || pSAppViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewBase.getMemo());
        }
        if (pSAppViewBase.isModColorDirty() && (bl || pSAppViewBase.getModColor() != null)) {
            iDataObject.set(FIELD_MODCOLOR, (Object)pSAppViewBase.getModColor());
        }
        if (pSAppViewBase.isPreventXSSDirty() && (bl || pSAppViewBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSAppViewBase.getPreventXSS());
        }
        if (pSAppViewBase.isPSACHandlerIdDirty() && (bl || pSAppViewBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSAppViewBase.getPSACHandlerId());
        }
        if (pSAppViewBase.isPSACHandlerNameDirty() && (bl || pSAppViewBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSAppViewBase.getPSACHandlerName());
        }
        if (pSAppViewBase.isPSAppLocalDEIdDirty() && (bl || pSAppViewBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSAppViewBase.getPSAppLocalDEId());
        }
        if (pSAppViewBase.isPSAppLocalDENameDirty() && (bl || pSAppViewBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSAppViewBase.getPSAppLocalDEName());
        }
        if (pSAppViewBase.isPSAppModuleIdDirty() && (bl || pSAppViewBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSAppViewBase.getPSAppModuleId());
        }
        if (pSAppViewBase.isPSAppModuleNameDirty() && (bl || pSAppViewBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSAppViewBase.getPSAppModuleName());
        }
        if (pSAppViewBase.isPSAppTitleBarIdDirty() && (bl || pSAppViewBase.getPSAppTitleBarId() != null)) {
            iDataObject.set(FIELD_PSAPPTITLEBARID, (Object)pSAppViewBase.getPSAppTitleBarId());
        }
        if (pSAppViewBase.isPSAppTitleBarNameDirty() && (bl || pSAppViewBase.getPSAppTitleBarName() != null)) {
            iDataObject.set(FIELD_PSAPPTITLEBARNAME, (Object)pSAppViewBase.getPSAppTitleBarName());
        }
        if (pSAppViewBase.isPSAppUtilViewTypeDirty() && (bl || pSAppViewBase.getPSAppUtilViewType() != null)) {
            iDataObject.set(FIELD_PSAPPUTILVIEWTYPE, (Object)pSAppViewBase.getPSAppUtilViewType());
        }
        if (pSAppViewBase.isPSAppViewIdDirty() && (bl || pSAppViewBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppViewBase.getPSAppViewId());
        }
        if (pSAppViewBase.isPSAppViewNameDirty() && (bl || pSAppViewBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppViewBase.getPSAppViewName());
        }
        if (pSAppViewBase.isPSAppViewStyleIdDirty() && (bl || pSAppViewBase.getPSAppViewStyleId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLEID, (Object)pSAppViewBase.getPSAppViewStyleId());
        }
        if (pSAppViewBase.isPSAppViewStyleNameDirty() && (bl || pSAppViewBase.getPSAppViewStyleName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLENAME, (Object)pSAppViewBase.getPSAppViewStyleName());
        }
        if (pSAppViewBase.isPSAppViewTypeDirty() && (bl || pSAppViewBase.getPSAppViewType() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWTYPE, (Object)pSAppViewBase.getPSAppViewType());
        }
        if (pSAppViewBase.isPSCtrlLogicGroupIdDirty() && (bl || pSAppViewBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSAppViewBase.getPSCtrlLogicGroupId());
        }
        if (pSAppViewBase.isPSCtrlLogicGroupNameDirty() && (bl || pSAppViewBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSAppViewBase.getPSCtrlLogicGroupName());
        }
        if (pSAppViewBase.isPSDEViewBaseIdDirty() && (bl || pSAppViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSAppViewBase.getPSDEViewBaseId());
        }
        if (pSAppViewBase.isPSDEViewBaseNameDirty() && (bl || pSAppViewBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSAppViewBase.getPSDEViewBaseName());
        }
        if (pSAppViewBase.isPSDEViewTypeDirty() && (bl || pSAppViewBase.getPSDEViewType() != null)) {
            iDataObject.set(FIELD_PSDEVIEWTYPE, (Object)pSAppViewBase.getPSDEViewType());
        }
        if (pSAppViewBase.isPSDynaDEViewTemplIdDirty() && (bl || pSAppViewBase.getPSDynaDEViewTemplId() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLID, (Object)pSAppViewBase.getPSDynaDEViewTemplId());
        }
        if (pSAppViewBase.isPSDynaDEViewTemplNameDirty() && (bl || pSAppViewBase.getPSDynaDEViewTemplName() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTEMPLNAME, (Object)pSAppViewBase.getPSDynaDEViewTemplName());
        }
        if (pSAppViewBase.isPSDynaDEViewTypeDirty() && (bl || pSAppViewBase.getPSDynaDEViewType() != null)) {
            iDataObject.set(FIELD_PSDYNADEVIEWTYPE, (Object)pSAppViewBase.getPSDynaDEViewType());
        }
        if (pSAppViewBase.isPSDynaInstIdDirty() && (bl || pSAppViewBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSAppViewBase.getPSDynaInstId());
        }
        if (pSAppViewBase.isPSHelpModuleIdDirty() && (bl || pSAppViewBase.getPSHelpModuleId() != null)) {
            iDataObject.set(FIELD_PSHELPMODULEID, (Object)pSAppViewBase.getPSHelpModuleId());
        }
        if (pSAppViewBase.isPSHelpModuleNameDirty() && (bl || pSAppViewBase.getPSHelpModuleName() != null)) {
            iDataObject.set(FIELD_PSHELPMODULENAME, (Object)pSAppViewBase.getPSHelpModuleName());
        }
        if (pSAppViewBase.isPSPFIdDirty() && (bl || pSAppViewBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSAppViewBase.getPSPFId());
        }
        if (pSAppViewBase.isPSPFStyleIdDirty() && (bl || pSAppViewBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSAppViewBase.getPSPFStyleId());
        }
        if (pSAppViewBase.isPSPFStyleNameDirty() && (bl || pSAppViewBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSAppViewBase.getPSPFStyleName());
        }
        if (pSAppViewBase.isPSSubViewTypeIdDirty() && (bl || pSAppViewBase.getPSSubViewTypeId() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPEID, (Object)pSAppViewBase.getPSSubViewTypeId());
        }
        if (pSAppViewBase.isPSSubViewTypeNameDirty() && (bl || pSAppViewBase.getPSSubViewTypeName() != null)) {
            iDataObject.set(FIELD_PSSUBVIEWTYPENAME, (Object)pSAppViewBase.getPSSubViewTypeName());
        }
        if (pSAppViewBase.isPSSysAppIdDirty() && (bl || pSAppViewBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppViewBase.getPSSysAppId());
        }
        if (pSAppViewBase.isPSSysAppNameDirty() && (bl || pSAppViewBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppViewBase.getPSSysAppName());
        }
        if (pSAppViewBase.isPSSysCssIdDirty() && (bl || pSAppViewBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSAppViewBase.getPSSysCssId());
        }
        if (pSAppViewBase.isPSSysCssNameDirty() && (bl || pSAppViewBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSAppViewBase.getPSSysCssName());
        }
        if (pSAppViewBase.isPSSysDynaModelIdDirty() && (bl || pSAppViewBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSAppViewBase.getPSSysDynaModelId());
        }
        if (pSAppViewBase.isPSSysDynaModelNameDirty() && (bl || pSAppViewBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSAppViewBase.getPSSysDynaModelName());
        }
        if (pSAppViewBase.isPSSysImageIdDirty() && (bl || pSAppViewBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSAppViewBase.getPSSysImageId());
        }
        if (pSAppViewBase.isPSSysImageNameDirty() && (bl || pSAppViewBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSAppViewBase.getPSSysImageName());
        }
        if (pSAppViewBase.isPSSysReqItemIdDirty() && (bl || pSAppViewBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppViewBase.getPSSysReqItemId());
        }
        if (pSAppViewBase.isPSSysReqItemNameDirty() && (bl || pSAppViewBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppViewBase.getPSSysReqItemName());
        }
        if (pSAppViewBase.isPSSystemIdDirty() && (bl || pSAppViewBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSAppViewBase.getPSSystemId());
        }
        if (pSAppViewBase.isPSSysUniResIdDirty() && (bl || pSAppViewBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSAppViewBase.getPSSysUniResId());
        }
        if (pSAppViewBase.isPSSysUniResNameDirty() && (bl || pSAppViewBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSAppViewBase.getPSSysUniResName());
        }
        if (pSAppViewBase.isPSSysViewPanelIdDirty() && (bl || pSAppViewBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSAppViewBase.getPSSysViewPanelId());
        }
        if (pSAppViewBase.isPSSysViewPanelNameDirty() && (bl || pSAppViewBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSAppViewBase.getPSSysViewPanelName());
        }
        if (pSAppViewBase.isPSViewEngineIdDirty() && (bl || pSAppViewBase.getPSViewEngineId() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINEID, (Object)pSAppViewBase.getPSViewEngineId());
        }
        if (pSAppViewBase.isPSViewEngineNameDirty() && (bl || pSAppViewBase.getPSViewEngineName() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINENAME, (Object)pSAppViewBase.getPSViewEngineName());
        }
        if (pSAppViewBase.isPSViewMsgGroupIdDirty() && (bl || pSAppViewBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSAppViewBase.getPSViewMsgGroupId());
        }
        if (pSAppViewBase.isPSViewMsgGroupNameDirty() && (bl || pSAppViewBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSAppViewBase.getPSViewMsgGroupName());
        }
        if (pSAppViewBase.isPSViewWizardGroupIdDirty() && (bl || pSAppViewBase.getPSViewWizardGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWWIZARDGROUPID, (Object)pSAppViewBase.getPSViewWizardGroupId());
        }
        if (pSAppViewBase.isPSViewWizardGroupNameDirty() && (bl || pSAppViewBase.getPSViewWizardGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWWIZARDGROUPNAME, (Object)pSAppViewBase.getPSViewWizardGroupName());
        }
        if (pSAppViewBase.isShowCaptionBarDirty() && (bl || pSAppViewBase.getShowCaptionBar() != null)) {
            iDataObject.set(FIELD_SHOWCAPTIONBAR, (Object)pSAppViewBase.getShowCaptionBar());
        }
        if (pSAppViewBase.isSubCapPSLanResIdDirty() && (bl || pSAppViewBase.getSubCapPSLanResId() != null)) {
            iDataObject.set(FIELD_SUBCAPPSLANRESID, (Object)pSAppViewBase.getSubCapPSLanResId());
        }
        if (pSAppViewBase.isSubCapPSLanResNameDirty() && (bl || pSAppViewBase.getSubCapPSLanResName() != null)) {
            iDataObject.set(FIELD_SUBCAPPSLANRESNAME, (Object)pSAppViewBase.getSubCapPSLanResName());
        }
        if (pSAppViewBase.isSubCaptionDirty() && (bl || pSAppViewBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSAppViewBase.getSubCaption());
        }
        if (pSAppViewBase.isSyncCodeNameDirty() && (bl || pSAppViewBase.getSyncCodeName() != null)) {
            iDataObject.set(FIELD_SYNCCODENAME, (Object)pSAppViewBase.getSyncCodeName());
        }
        if (pSAppViewBase.isSysRefFlagDirty() && (bl || pSAppViewBase.getSysRefFlag() != null)) {
            iDataObject.set(FIELD_SYSREFFLAG, (Object)pSAppViewBase.getSysRefFlag());
        }
        if (pSAppViewBase.isTitleDirty() && (bl || pSAppViewBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSAppViewBase.getTitle());
        }
        if (pSAppViewBase.isTitlePSLanResIdDirty() && (bl || pSAppViewBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSAppViewBase.getTitlePSLanResId());
        }
        if (pSAppViewBase.isTitlePSLanResNameDirty() && (bl || pSAppViewBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSAppViewBase.getTitlePSLanResName());
        }
        if (pSAppViewBase.isToDoTaskDirty() && (bl || pSAppViewBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSAppViewBase.getToDoTask());
        }
        if (pSAppViewBase.isUIStyleDirty() && (bl || pSAppViewBase.getUIStyle() != null)) {
            iDataObject.set(FIELD_UISTYLE, (Object)pSAppViewBase.getUIStyle());
        }
        if (pSAppViewBase.isUpdateDateDirty() && (bl || pSAppViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewBase.getUpdateDate());
        }
        if (pSAppViewBase.isUpdateManDirty() && (bl || pSAppViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewBase.getUpdateMan());
        }
        if (pSAppViewBase.isUserParamsDirty() && (bl || pSAppViewBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppViewBase.getUserParams());
        }
        if (pSAppViewBase.isUserRefFlagDirty() && (bl || pSAppViewBase.getUserRefFlag() != null)) {
            iDataObject.set(FIELD_USERREFFLAG, (Object)pSAppViewBase.getUserRefFlag());
        }
        if (pSAppViewBase.isUserTagDirty() && (bl || pSAppViewBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppViewBase.getUserTag());
        }
        if (pSAppViewBase.isUserTag2Dirty() && (bl || pSAppViewBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppViewBase.getUserTag2());
        }
        if (pSAppViewBase.isUserTag3Dirty() && (bl || pSAppViewBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppViewBase.getUserTag3());
        }
        if (pSAppViewBase.isUserTag4Dirty() && (bl || pSAppViewBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppViewBase.getUserTag4());
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
        return PSAppViewBase.remove(this, n);
    }

    private static boolean remove(PSAppViewBase pSAppViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewBase.resetAccUserMode();
                return true;
            }
            case 1: {
                pSAppViewBase.resetAppViewSN();
                return true;
            }
            case 2: {
                pSAppViewBase.resetAppViewState();
                return true;
            }
            case 3: {
                pSAppViewBase.resetCapPSLanResId();
                return true;
            }
            case 4: {
                pSAppViewBase.resetCapPSLanResName();
                return true;
            }
            case 5: {
                pSAppViewBase.resetCaption();
                return true;
            }
            case 6: {
                pSAppViewBase.resetColor();
                return true;
            }
            case 7: {
                pSAppViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppViewBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSAppViewBase.resetDynaModelFlag();
                return true;
            }
            case 10: {
                pSAppViewBase.resetDyncMode();
                return true;
            }
            case 11: {
                pSAppViewBase.resetEnableViewStyle();
                return true;
            }
            case 12: {
                pSAppViewBase.resetLayoutPanelMode();
                return true;
            }
            case 13: {
                pSAppViewBase.resetMemo();
                return true;
            }
            case 14: {
                pSAppViewBase.resetModColor();
                return true;
            }
            case 15: {
                pSAppViewBase.resetPreventXSS();
                return true;
            }
            case 16: {
                pSAppViewBase.resetPSACHandlerId();
                return true;
            }
            case 17: {
                pSAppViewBase.resetPSACHandlerName();
                return true;
            }
            case 18: {
                pSAppViewBase.resetPSAppLocalDEId();
                return true;
            }
            case 19: {
                pSAppViewBase.resetPSAppLocalDEName();
                return true;
            }
            case 20: {
                pSAppViewBase.resetPSAppModuleId();
                return true;
            }
            case 21: {
                pSAppViewBase.resetPSAppModuleName();
                return true;
            }
            case 22: {
                pSAppViewBase.resetPSAppTitleBarId();
                return true;
            }
            case 23: {
                pSAppViewBase.resetPSAppTitleBarName();
                return true;
            }
            case 24: {
                pSAppViewBase.resetPSAppUtilViewType();
                return true;
            }
            case 25: {
                pSAppViewBase.resetPSAppViewId();
                return true;
            }
            case 26: {
                pSAppViewBase.resetPSAppViewName();
                return true;
            }
            case 27: {
                pSAppViewBase.resetPSAppViewStyleId();
                return true;
            }
            case 28: {
                pSAppViewBase.resetPSAppViewStyleName();
                return true;
            }
            case 29: {
                pSAppViewBase.resetPSAppViewType();
                return true;
            }
            case 30: {
                pSAppViewBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 31: {
                pSAppViewBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 32: {
                pSAppViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 33: {
                pSAppViewBase.resetPSDEViewBaseName();
                return true;
            }
            case 34: {
                pSAppViewBase.resetPSDEViewType();
                return true;
            }
            case 35: {
                pSAppViewBase.resetPSDynaDEViewTemplId();
                return true;
            }
            case 36: {
                pSAppViewBase.resetPSDynaDEViewTemplName();
                return true;
            }
            case 37: {
                pSAppViewBase.resetPSDynaDEViewType();
                return true;
            }
            case 38: {
                pSAppViewBase.resetPSDynaInstId();
                return true;
            }
            case 39: {
                pSAppViewBase.resetPSHelpModuleId();
                return true;
            }
            case 40: {
                pSAppViewBase.resetPSHelpModuleName();
                return true;
            }
            case 41: {
                pSAppViewBase.resetPSPFId();
                return true;
            }
            case 42: {
                pSAppViewBase.resetPSPFStyleId();
                return true;
            }
            case 43: {
                pSAppViewBase.resetPSPFStyleName();
                return true;
            }
            case 44: {
                pSAppViewBase.resetPSSubViewTypeId();
                return true;
            }
            case 45: {
                pSAppViewBase.resetPSSubViewTypeName();
                return true;
            }
            case 46: {
                pSAppViewBase.resetPSSysAppId();
                return true;
            }
            case 47: {
                pSAppViewBase.resetPSSysAppName();
                return true;
            }
            case 48: {
                pSAppViewBase.resetPSSysCssId();
                return true;
            }
            case 49: {
                pSAppViewBase.resetPSSysCssName();
                return true;
            }
            case 50: {
                pSAppViewBase.resetPSSysDynaModelId();
                return true;
            }
            case 51: {
                pSAppViewBase.resetPSSysDynaModelName();
                return true;
            }
            case 52: {
                pSAppViewBase.resetPSSysImageId();
                return true;
            }
            case 53: {
                pSAppViewBase.resetPSSysImageName();
                return true;
            }
            case 54: {
                pSAppViewBase.resetPSSysReqItemId();
                return true;
            }
            case 55: {
                pSAppViewBase.resetPSSysReqItemName();
                return true;
            }
            case 56: {
                pSAppViewBase.resetPSSystemId();
                return true;
            }
            case 57: {
                pSAppViewBase.resetPSSysUniResId();
                return true;
            }
            case 58: {
                pSAppViewBase.resetPSSysUniResName();
                return true;
            }
            case 59: {
                pSAppViewBase.resetPSSysViewPanelId();
                return true;
            }
            case 60: {
                pSAppViewBase.resetPSSysViewPanelName();
                return true;
            }
            case 61: {
                pSAppViewBase.resetPSViewEngineId();
                return true;
            }
            case 62: {
                pSAppViewBase.resetPSViewEngineName();
                return true;
            }
            case 63: {
                pSAppViewBase.resetPSViewMsgGroupId();
                return true;
            }
            case 64: {
                pSAppViewBase.resetPSViewMsgGroupName();
                return true;
            }
            case 65: {
                pSAppViewBase.resetPSViewWizardGroupId();
                return true;
            }
            case 66: {
                pSAppViewBase.resetPSViewWizardGroupName();
                return true;
            }
            case 67: {
                pSAppViewBase.resetShowCaptionBar();
                return true;
            }
            case 68: {
                pSAppViewBase.resetSubCapPSLanResId();
                return true;
            }
            case 69: {
                pSAppViewBase.resetSubCapPSLanResName();
                return true;
            }
            case 70: {
                pSAppViewBase.resetSubCaption();
                return true;
            }
            case 71: {
                pSAppViewBase.resetSyncCodeName();
                return true;
            }
            case 72: {
                pSAppViewBase.resetSysRefFlag();
                return true;
            }
            case 73: {
                pSAppViewBase.resetTitle();
                return true;
            }
            case 74: {
                pSAppViewBase.resetTitlePSLanResId();
                return true;
            }
            case 75: {
                pSAppViewBase.resetTitlePSLanResName();
                return true;
            }
            case 76: {
                pSAppViewBase.resetToDoTask();
                return true;
            }
            case 77: {
                pSAppViewBase.resetUIStyle();
                return true;
            }
            case 78: {
                pSAppViewBase.resetUpdateDate();
                return true;
            }
            case 79: {
                pSAppViewBase.resetUpdateMan();
                return true;
            }
            case 80: {
                pSAppViewBase.resetUserParams();
                return true;
            }
            case 81: {
                pSAppViewBase.resetUserRefFlag();
                return true;
            }
            case 82: {
                pSAppViewBase.resetUserTag();
                return true;
            }
            case 83: {
                pSAppViewBase.resetUserTag2();
                return true;
            }
            case 84: {
                pSAppViewBase.resetUserTag3();
                return true;
            }
            case 85: {
                pSAppViewBase.resetUserTag4();
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
    public PSAppLocalDE getPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDE();
        }
        if (this.getPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppLocalDELock;
        synchronized (n) {
            if (this.psapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppLocalDEId(), (Object)this.psapplocalde.getPSAppLocalDEId()) != 0L) {
                this.psapplocalde = null;
            }
            if (this.psapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet((IEntity)pSAppLocalDE);
                this.psapplocalde = pSAppLocalDE;
            }
            return this.psapplocalde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppModule getPSAppModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModule();
        }
        if (this.getPSAppModuleId() == null) {
            return null;
        }
        Integer n = this.objPSAppModuleLock;
        synchronized (n) {
            if (this.psappmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppModuleId(), (Object)this.psappmodule.getPSAppModuleId()) != 0L) {
                this.psappmodule = null;
            }
            if (this.psappmodule == null) {
                PSAppModule pSAppModule = new PSAppModule();
                pSAppModule.setPSAppModuleId(this.getPSAppModuleId());
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                pSAppModuleService.autoGet((IEntity)pSAppModule);
                this.psappmodule = pSAppModule;
            }
            return this.psappmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppTitleBar getPSAppTitleBar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBar();
        }
        if (this.getPSAppTitleBarId() == null) {
            return null;
        }
        Integer n = this.objPSAppTitleBarLock;
        synchronized (n) {
            if (this.psapptitlebar != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTitleBarId(), (Object)this.psapptitlebar.getPSAppTitleBarId()) != 0L) {
                this.psapptitlebar = null;
            }
            if (this.psapptitlebar == null) {
                PSAppTitleBar pSAppTitleBar = new PSAppTitleBar();
                pSAppTitleBar.setPSAppTitleBarId(this.getPSAppTitleBarId());
                PSAppTitleBarService pSAppTitleBarService = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
                pSAppTitleBarService.autoGet((IEntity)pSAppTitleBar);
                this.psapptitlebar = pSAppTitleBar;
            }
            return this.psapptitlebar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppViewStyle getPSAppViewStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyle();
        }
        if (this.getPSAppViewStyleId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewStyleLock;
        synchronized (n) {
            if (this.psappviewstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewStyleId(), (Object)this.psappviewstyle.getPSAppViewStyleId()) != 0L) {
                this.psappviewstyle = null;
            }
            if (this.psappviewstyle == null) {
                PSAppViewStyle pSAppViewStyle = new PSAppViewStyle();
                pSAppViewStyle.setPSAppViewStyleId(this.getPSAppViewStyleId());
                PSAppViewStyleService pSAppViewStyleService = (PSAppViewStyleService)ServiceGlobal.getService(PSAppViewStyleService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewStyleService.autoGet((IEntity)pSAppViewStyle);
                this.psappviewstyle = pSAppViewStyle;
            }
            return this.psappviewstyle;
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
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
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
                pSDynaDEViewTemplService.autoGet((IEntity)pSDynaDEViewTempl);
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
                pSHelpModuleService.autoGet((IEntity)pSHelpModule);
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
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
                pSSubViewTypeService.autoGet((IEntity)pSSubViewType);
                this.pssubviewtype = pSSubViewType;
            }
            return this.pssubviewtype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
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
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
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
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
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
                pSViewEngineService.autoGet((IEntity)pSViewEngine);
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
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewWizardGroup getPSViewWizardGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroup();
        }
        if (this.getPSViewWizardGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewWizardGroupLock;
        synchronized (n) {
            if (this.psviewwizardgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewWizardGroupId(), (Object)this.psviewwizardgroup.getPSViewWizardGroupId()) != 0L) {
                this.psviewwizardgroup = null;
            }
            if (this.psviewwizardgroup == null) {
                PSViewWizardGroup pSViewWizardGroup = new PSViewWizardGroup();
                pSViewWizardGroup.setPSViewWizardGroupId(this.getPSViewWizardGroupId());
                PSViewWizardGroupService pSViewWizardGroupService = (PSViewWizardGroupService)ServiceGlobal.getService(PSViewWizardGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewWizardGroupService.autoGet((IEntity)pSViewWizardGroup);
                this.psviewwizardgroup = pSViewWizardGroup;
            }
            return this.psviewwizardgroup;
        }
    }

    private PSAppViewBase getProxyEntity() {
        return this.proxyPSAppViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewBase) {
            this.proxyPSAppViewBase = (PSAppViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCUSERMODE, 0);
        fieldIndexMap.put(FIELD_APPVIEWSN, 1);
        fieldIndexMap.put(FIELD_APPVIEWSTATE, 2);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 3);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 4);
        fieldIndexMap.put(FIELD_CAPTION, 5);
        fieldIndexMap.put(FIELD_COLOR, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 9);
        fieldIndexMap.put(FIELD_DYNCMODE, 10);
        fieldIndexMap.put(FIELD_ENABLEVIEWSTYLE, 11);
        fieldIndexMap.put(FIELD_LAYOUTPANELMODE, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MODCOLOR, 14);
        fieldIndexMap.put(FIELD_PREVENTXSS, 15);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 16);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 17);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 18);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 19);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 20);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 21);
        fieldIndexMap.put(FIELD_PSAPPTITLEBARID, 22);
        fieldIndexMap.put(FIELD_PSAPPTITLEBARNAME, 23);
        fieldIndexMap.put(FIELD_PSAPPUTILVIEWTYPE, 24);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 25);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 26);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLEID, 27);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLENAME, 28);
        fieldIndexMap.put(FIELD_PSAPPVIEWTYPE, 29);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 30);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 31);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 32);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 33);
        fieldIndexMap.put(FIELD_PSDEVIEWTYPE, 34);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLID, 35);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTEMPLNAME, 36);
        fieldIndexMap.put(FIELD_PSDYNADEVIEWTYPE, 37);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 38);
        fieldIndexMap.put(FIELD_PSHELPMODULEID, 39);
        fieldIndexMap.put(FIELD_PSHELPMODULENAME, 40);
        fieldIndexMap.put(FIELD_PSPFID, 41);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 42);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 43);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPEID, 44);
        fieldIndexMap.put(FIELD_PSSUBVIEWTYPENAME, 45);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 46);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 47);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 48);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 49);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 50);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 52);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 53);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 54);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 55);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 56);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 57);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 58);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 59);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 60);
        fieldIndexMap.put(FIELD_PSVIEWENGINEID, 61);
        fieldIndexMap.put(FIELD_PSVIEWENGINENAME, 62);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 63);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 64);
        fieldIndexMap.put(FIELD_PSVIEWWIZARDGROUPID, 65);
        fieldIndexMap.put(FIELD_PSVIEWWIZARDGROUPNAME, 66);
        fieldIndexMap.put(FIELD_SHOWCAPTIONBAR, 67);
        fieldIndexMap.put(FIELD_SUBCAPPSLANRESID, 68);
        fieldIndexMap.put(FIELD_SUBCAPPSLANRESNAME, 69);
        fieldIndexMap.put(FIELD_SUBCAPTION, 70);
        fieldIndexMap.put(FIELD_SYNCCODENAME, 71);
        fieldIndexMap.put(FIELD_SYSREFFLAG, 72);
        fieldIndexMap.put(FIELD_TITLE, 73);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 74);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 75);
        fieldIndexMap.put(FIELD_TODOTASK, 76);
        fieldIndexMap.put(FIELD_UISTYLE, 77);
        fieldIndexMap.put(FIELD_UPDATEDATE, 78);
        fieldIndexMap.put(FIELD_UPDATEMAN, 79);
        fieldIndexMap.put(FIELD_USERPARAMS, 80);
        fieldIndexMap.put(FIELD_USERREFFLAG, 81);
        fieldIndexMap.put(FIELD_USERTAG, 82);
        fieldIndexMap.put(FIELD_USERTAG2, 83);
        fieldIndexMap.put(FIELD_USERTAG3, 84);
        fieldIndexMap.put(FIELD_USERTAG4, 85);
    }
}

