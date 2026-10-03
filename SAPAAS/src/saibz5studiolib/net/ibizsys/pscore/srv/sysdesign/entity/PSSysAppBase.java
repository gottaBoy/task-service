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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEViewRef;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppEditorTempl;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLan;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLogic;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPDTView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPFPlugin;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortlet;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppResource;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBar;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUITheme;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUserMode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtil;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilPage;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewCode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppStartPage;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppResourceService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageService;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFCDN;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFCDNService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAppBase.class);
    public static final String FIELD_ACMINCHARS = "ACMINCHARS";
    public static final String FIELD_APPFOLDER = "APPFOLDER";
    public static final String FIELD_APPMODE = "APPMODE";
    public static final String FIELD_APPPKGNAME = "APPPKGNAME";
    public static final String FIELD_APPSN = "APPSN";
    public static final String FIELD_APPTAG = "APPTAG";
    public static final String FIELD_APPTAG2 = "APPTAG2";
    public static final String FIELD_APPTAG3 = "APPTAG3";
    public static final String FIELD_APPTAG4 = "APPTAG4";
    public static final String FIELD_APPVERSION = "APPVERSION";
    public static final String FIELD_APPVIEWPRIORITY = "APPVIEWPRIORITY";
    public static final String FIELD_AUTOADDAPPVIEW = "AUTOADDAPPVIEW";
    public static final String FIELD_BOTTOMINFO = "BOTTOMINFO";
    public static final String FIELD_BTNNOPRIVDM = "BTNNOPRIVDM";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODEFOLDER = "CODEFOLDER";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTPORT = "DEFAULTPORT";
    public static final String FIELD_DEFAULTPUB = "DEFAULTPUB";
    public static final String FIELD_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String FIELD_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String FIELD_ENABLEC12TOC24 = "ENABLEC12TOC24";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLESTORYBOARD = "ENABLESTORYBOARD";
    public static final String FIELD_ENABLEUIMODELEX = "ENABLEUIMODELEX";
    public static final String FIELD_ENALOCALSERVICE = "ENALOCALSERVICE";
    public static final String FIELD_FIEMPTYTEXT = "FIEMPTYTEXT";
    public static final String FIELD_FINOPRIVDM = "FINOPRIVDM";
    public static final String FIELD_FIUPDATEPRIVTAG = "FIUPDATEPRIVTAG";
    public static final String FIELD_GCNOPRIVDM = "GCNOPRIVDM";
    public static final String FIELD_GRIDCOLENABLEFILTER = "GRIDCOLENABLEFILTER";
    public static final String FIELD_GRIDCOLENABLELINK = "GRIDCOLENABLELINK";
    public static final String FIELD_GRIDENABLECUSTOMIZED = "GRIDENABLECUSTOMIZED";
    public static final String FIELD_GRIDFORCEFIT = "GRIDFORCEFIT";
    public static final String FIELD_GRIDROWACTIVEMODE = "GRIDROWACTIVEMODE";
    public static final String FIELD_HEADERINFO = "HEADERINFO";
    public static final String FIELD_ICONFILE = "ICONFILE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String FIELD_MDCTRLEMPTYTEXT = "MDCTRLEMPTYTEXT";
    public static final String FIELD_MDCTRLEMPTYTEXTPSLANRESID = "MDCTRLEMPTYTEXTPSLANRESID";
    public static final String FIELD_MDCTRLEMPTYTEXTPSLANRESNAME = "MDCTRLEMPTYTEXTPSLANRESNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORIENTATIONMODE = "ORIENTATIONMODE";
    public static final String FIELD_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PSAPPEDITORTEMPLSCNT = "PSAPPEDITORTEMPLSCNT";
    public static final String FIELD_PSAPPFUNCSCNT = "PSAPPFUNCSCNT";
    public static final String FIELD_PSAPPMENUSCNT = "PSAPPMENUSCNT";
    public static final String FIELD_PSAPPMODULESCNT = "PSAPPMODULESCNT";
    public static final String FIELD_PSAPPPKGSCNT = "PSAPPPKGSCNT";
    public static final String FIELD_PSAPPTITLEBARSCNT = "PSAPPTITLEBARSCNT";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSAPPUITHEMESCNT = "PSAPPUITHEMESCNT";
    public static final String FIELD_PSAPPUSERMODESCNT = "PSAPPUSERMODESCNT";
    public static final String FIELD_PSAPPUTILPAGESCNT = "PSAPPUTILPAGESCNT";
    public static final String FIELD_PSAPPVIEWCODESCNT = "PSAPPVIEWCODESCNT";
    public static final String FIELD_PSAPPVIEWSCNT = "PSAPPVIEWSCNT";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSPFCDNID = "PSPFCDNID";
    public static final String FIELD_PSPFCDNNAME = "PSPFCDNNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSTUDIOTHEMEID = "PSSTUDIOTHEMEID";
    public static final String FIELD_PSSTUDIOTHEMENAME = "PSSTUDIOTHEMENAME";
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
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTASKSCNT = "PSSYSTASKSCNT";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_PUBREFVIEWONLY = "PUBREFVIEWONLY";
    public static final String FIELD_PUBSYSREFVIEWONLY = "PUBSYSREFVIEWONLY";
    public static final String FIELD_REMOVEFLAG = "REMOVEFLAG";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_STARTPAGEFILE = "STARTPAGEFILE";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UACLOGIN = "UACLOGIN";
    public static final String FIELD_UISTYLE = "UISTYLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACMINCHARS = 0;
    private static final int INDEX_APPFOLDER = 1;
    private static final int INDEX_APPMODE = 2;
    private static final int INDEX_APPPKGNAME = 3;
    private static final int INDEX_APPSN = 4;
    private static final int INDEX_APPTAG = 5;
    private static final int INDEX_APPTAG2 = 6;
    private static final int INDEX_APPTAG3 = 7;
    private static final int INDEX_APPTAG4 = 8;
    private static final int INDEX_APPVERSION = 9;
    private static final int INDEX_APPVIEWPRIORITY = 10;
    private static final int INDEX_AUTOADDAPPVIEW = 11;
    private static final int INDEX_BOTTOMINFO = 12;
    private static final int INDEX_BTNNOPRIVDM = 13;
    private static final int INDEX_CAPTION = 14;
    private static final int INDEX_CODEFOLDER = 15;
    private static final int INDEX_CODENAMEMODE = 16;
    private static final int INDEX_CREATEDATE = 17;
    private static final int INDEX_CREATEMAN = 18;
    private static final int INDEX_DEFAULTPORT = 19;
    private static final int INDEX_DEFAULTPUB = 20;
    private static final int INDEX_DEPSSYSSFPLUGINID = 21;
    private static final int INDEX_DEPSSYSSFPLUGINNAME = 22;
    private static final int INDEX_ENABLEC12TOC24 = 23;
    private static final int INDEX_ENABLEDYNASYS = 24;
    private static final int INDEX_ENABLESTORYBOARD = 25;
    private static final int INDEX_ENABLEUIMODELEX = 26;
    private static final int INDEX_ENALOCALSERVICE = 27;
    private static final int INDEX_FIEMPTYTEXT = 28;
    private static final int INDEX_FINOPRIVDM = 29;
    private static final int INDEX_FIUPDATEPRIVTAG = 30;
    private static final int INDEX_GCNOPRIVDM = 31;
    private static final int INDEX_GRIDCOLENABLEFILTER = 32;
    private static final int INDEX_GRIDCOLENABLELINK = 33;
    private static final int INDEX_GRIDENABLECUSTOMIZED = 34;
    private static final int INDEX_GRIDFORCEFIT = 35;
    private static final int INDEX_GRIDROWACTIVEMODE = 36;
    private static final int INDEX_HEADERINFO = 37;
    private static final int INDEX_ICONFILE = 38;
    private static final int INDEX_LOGICNAME = 39;
    private static final int INDEX_MAINMENUSIDE = 40;
    private static final int INDEX_MDCTRLEMPTYTEXT = 41;
    private static final int INDEX_MDCTRLEMPTYTEXTPSLANRESID = 42;
    private static final int INDEX_MDCTRLEMPTYTEXTPSLANRESNAME = 43;
    private static final int INDEX_MEMO = 44;
    private static final int INDEX_ORDERVALUE = 45;
    private static final int INDEX_ORIENTATIONMODE = 46;
    private static final int INDEX_PFSTYLEPARAM = 47;
    private static final int INDEX_PREVENTXSS = 48;
    private static final int INDEX_PSAPPEDITORTEMPLSCNT = 49;
    private static final int INDEX_PSAPPFUNCSCNT = 50;
    private static final int INDEX_PSAPPMENUSCNT = 51;
    private static final int INDEX_PSAPPMODULESCNT = 52;
    private static final int INDEX_PSAPPPKGSCNT = 53;
    private static final int INDEX_PSAPPTITLEBARSCNT = 54;
    private static final int INDEX_PSAPPTYPEID = 55;
    private static final int INDEX_PSAPPTYPENAME = 56;
    private static final int INDEX_PSAPPUITHEMESCNT = 57;
    private static final int INDEX_PSAPPUSERMODESCNT = 58;
    private static final int INDEX_PSAPPUTILPAGESCNT = 59;
    private static final int INDEX_PSAPPVIEWCODESCNT = 60;
    private static final int INDEX_PSAPPVIEWSCNT = 61;
    private static final int INDEX_PSCTRLLOGICGROUPID = 62;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 63;
    private static final int INDEX_PSDEVSLNSYSAPPID = 64;
    private static final int INDEX_PSMODULEID = 65;
    private static final int INDEX_PSMODULENAME = 66;
    private static final int INDEX_PSPFCDNID = 67;
    private static final int INDEX_PSPFCDNNAME = 68;
    private static final int INDEX_PSPFID = 69;
    private static final int INDEX_PSPFNAME = 70;
    private static final int INDEX_PSPFSTYLEID = 71;
    private static final int INDEX_PSPFSTYLENAME = 72;
    private static final int INDEX_PSSTUDIOTHEMEID = 73;
    private static final int INDEX_PSSTUDIOTHEMENAME = 74;
    private static final int INDEX_PSSYSAPPID = 75;
    private static final int INDEX_PSSYSAPPNAME = 76;
    private static final int INDEX_PSSYSCSSID = 77;
    private static final int INDEX_PSSYSCSSNAME = 78;
    private static final int INDEX_PSSYSDYNAMODELID = 79;
    private static final int INDEX_PSSYSDYNAMODELNAME = 80;
    private static final int INDEX_PSSYSIMAGEID = 81;
    private static final int INDEX_PSSYSIMAGENAME = 82;
    private static final int INDEX_PSSYSREQITEMID = 83;
    private static final int INDEX_PSSYSREQITEMNAME = 84;
    private static final int INDEX_PSSYSRESOURCEID = 85;
    private static final int INDEX_PSSYSRESOURCENAME = 86;
    private static final int INDEX_PSSYSSERVICEAPIID = 87;
    private static final int INDEX_PSSYSSERVICEAPINAME = 88;
    private static final int INDEX_PSSYSSFPLUGINID = 89;
    private static final int INDEX_PSSYSSFPLUGINNAME = 90;
    private static final int INDEX_PSSYSSFPUBID = 91;
    private static final int INDEX_PSSYSSFPUBNAME = 92;
    private static final int INDEX_PSSYSTASKSCNT = 93;
    private static final int INDEX_PSSYSTEMID = 94;
    private static final int INDEX_PSSYSTEMNAME = 95;
    private static final int INDEX_PSVIEWMSGGROUPID = 96;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 97;
    private static final int INDEX_PUBREFVIEWONLY = 98;
    private static final int INDEX_PUBSYSREFVIEWONLY = 99;
    private static final int INDEX_REMOVEFLAG = 100;
    private static final int INDEX_SERVICECODENAME = 101;
    private static final int INDEX_STARTPAGEFILE = 102;
    private static final int INDEX_SUBCAPTION = 103;
    private static final int INDEX_TITLE = 104;
    private static final int INDEX_UACLOGIN = 105;
    private static final int INDEX_UISTYLE = 106;
    private static final int INDEX_UPDATEDATE = 107;
    private static final int INDEX_UPDATEMAN = 108;
    private static final int INDEX_USERCAT = 109;
    private static final int INDEX_USERPARAMS = 110;
    private static final int INDEX_USERTAG = 111;
    private static final int INDEX_USERTAG2 = 112;
    private static final int INDEX_USERTAG3 = 113;
    private static final int INDEX_USERTAG4 = 114;
    private static final int INDEX_VALIDFLAG = 115;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAppBase proxyPSSysAppBase = null;
    private boolean acmincharsDirtyFlag = false;
    private boolean appfolderDirtyFlag = false;
    private boolean appmodeDirtyFlag = false;
    private boolean apppkgnameDirtyFlag = false;
    private boolean appsnDirtyFlag = false;
    private boolean apptagDirtyFlag = false;
    private boolean apptag2DirtyFlag = false;
    private boolean apptag3DirtyFlag = false;
    private boolean apptag4DirtyFlag = false;
    private boolean appversionDirtyFlag = false;
    private boolean appviewpriorityDirtyFlag = false;
    private boolean autoaddappviewDirtyFlag = false;
    private boolean bottominfoDirtyFlag = false;
    private boolean btnnoprivdmDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codefolderDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultportDirtyFlag = false;
    private boolean defaultpubDirtyFlag = false;
    private boolean depssyssfpluginidDirtyFlag = false;
    private boolean depssyssfpluginnameDirtyFlag = false;
    private boolean enablec12toc24DirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enablestoryboardDirtyFlag = false;
    private boolean enableuimodelexDirtyFlag = false;
    private boolean enalocalserviceDirtyFlag = false;
    private boolean fiemptytextDirtyFlag = false;
    private boolean finoprivdmDirtyFlag = false;
    private boolean fiupdateprivtagDirtyFlag = false;
    private boolean gcnoprivdmDirtyFlag = false;
    private boolean gridcolenablefilterDirtyFlag = false;
    private boolean gridcolenablelinkDirtyFlag = false;
    private boolean gridenablecustomizedDirtyFlag = false;
    private boolean gridforcefitDirtyFlag = false;
    private boolean gridrowactivemodeDirtyFlag = false;
    private boolean headerinfoDirtyFlag = false;
    private boolean iconfileDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean mainmenusideDirtyFlag = false;
    private boolean mdctrlemptytextDirtyFlag = false;
    private boolean mdctrlemptytextpslanresidDirtyFlag = false;
    private boolean mdctrlemptytextpslanresnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean orientationmodeDirtyFlag = false;
    private boolean pfstyleparamDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean psappeditortemplscntDirtyFlag = false;
    private boolean psappfuncscntDirtyFlag = false;
    private boolean psappmenuscntDirtyFlag = false;
    private boolean psappmodulescntDirtyFlag = false;
    private boolean psapppkgscntDirtyFlag = false;
    private boolean psapptitlebarscntDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean psappuithemescntDirtyFlag = false;
    private boolean psappusermodescntDirtyFlag = false;
    private boolean psapputilpagescntDirtyFlag = false;
    private boolean psappviewcodescntDirtyFlag = false;
    private boolean psappviewscntDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pspfcdnidDirtyFlag = false;
    private boolean pspfcdnnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean psstudiothemeidDirtyFlag = false;
    private boolean psstudiothemenameDirtyFlag = false;
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
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystaskscntDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean pubrefviewonlyDirtyFlag = false;
    private boolean pubsysrefviewonlyDirtyFlag = false;
    private boolean removeflagDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean startpagefileDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean uacloginDirtyFlag = false;
    private boolean uistyleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="acminchars")
    private Integer acminchars;
    @Column(name="appfolder")
    private String appfolder;
    @Column(name="appmode")
    private String appmode;
    @Column(name="apppkgname")
    private String apppkgname;
    @Column(name="appsn")
    private String appsn;
    @Column(name="apptag")
    private String apptag;
    @Column(name="apptag2")
    private String apptag2;
    @Column(name="apptag3")
    private String apptag3;
    @Column(name="apptag4")
    private String apptag4;
    @Column(name="appversion")
    private String appversion;
    @Column(name="appviewpriority")
    private Integer appviewpriority;
    @Column(name="autoaddappview")
    private Integer autoaddappview;
    @Column(name="bottominfo")
    private String bottominfo;
    @Column(name="btnnoprivdm")
    private Integer btnnoprivdm;
    @Column(name="caption")
    private String caption;
    @Column(name="codefolder")
    private String codefolder;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultport")
    private Integer defaultport;
    @Column(name="defaultpub")
    private Integer defaultpub;
    @Column(name="depssyssfpluginid")
    private String depssyssfpluginid;
    @Column(name="depssyssfpluginname")
    private String depssyssfpluginname;
    @Column(name="enablec12toc24")
    private Integer enablec12toc24;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enablestoryboard")
    private Integer enablestoryboard;
    @Column(name="enableuimodelex")
    private Integer enableuimodelex;
    @Column(name="enalocalservice")
    private Integer enalocalservice;
    @Column(name="fiemptytext")
    private String fiemptytext;
    @Column(name="finoprivdm")
    private Integer finoprivdm;
    @Column(name="fiupdateprivtag")
    private Integer fiupdateprivtag;
    @Column(name="gcnoprivdm")
    private Integer gcnoprivdm;
    @Column(name="gridcolenablefilter")
    private Integer gridcolenablefilter;
    @Column(name="gridcolenablelink")
    private Integer gridcolenablelink;
    @Column(name="gridenablecustomized")
    private Integer gridenablecustomized;
    @Column(name="gridforcefit")
    private Integer gridforcefit;
    @Column(name="gridrowactivemode")
    private Integer gridrowactivemode;
    @Column(name="headerinfo")
    private String headerinfo;
    @Column(name="iconfile")
    private String iconfile;
    @Column(name="logicname")
    private String logicname;
    @Column(name="mainmenuside")
    private String mainmenuside;
    @Column(name="mdctrlemptytext")
    private String mdctrlemptytext;
    @Column(name="mdctrlemptytextpslanresid")
    private String mdctrlemptytextpslanresid;
    @Column(name="mdctrlemptytextpslanresname")
    private String mdctrlemptytextpslanresname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="orientationmode")
    private String orientationmode;
    @Column(name="pfstyleparam")
    private String pfstyleparam;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="psappeditortemplscnt")
    private Integer psappeditortemplscnt;
    @Column(name="psappfuncscnt")
    private Integer psappfuncscnt;
    @Column(name="psappmenuscnt")
    private Integer psappmenuscnt;
    @Column(name="psappmodulescnt")
    private Integer psappmodulescnt;
    @Column(name="psapppkgscnt")
    private Integer psapppkgscnt;
    @Column(name="psapptitlebarscnt")
    private Integer psapptitlebarscnt;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
    @Column(name="psappuithemescnt")
    private Integer psappuithemescnt;
    @Column(name="psappusermodescnt")
    private Integer psappusermodescnt;
    @Column(name="psapputilpagescnt")
    private Integer psapputilpagescnt;
    @Column(name="psappviewcodescnt")
    private Integer psappviewcodescnt;
    @Column(name="psappviewscnt")
    private Integer psappviewscnt;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pspfcdnid")
    private String pspfcdnid;
    @Column(name="pspfcdnname")
    private String pspfcdnname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="psstudiothemeid")
    private String psstudiothemeid;
    @Column(name="psstudiothemename")
    private String psstudiothemename;
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
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystaskscnt")
    private Integer pssystaskscnt;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="pubrefviewonly")
    private Integer pubrefviewonly;
    @Column(name="pubsysrefviewonly")
    private Integer pubsysrefviewonly;
    @Column(name="removeflag")
    private Integer removeflag;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="startpagefile")
    private String startpagefile;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="title")
    private String title;
    @Column(name="uaclogin")
    private Integer uaclogin;
    @Column(name="uistyle")
    private String uistyle;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objMDCtrlEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes mdctrlemptytextpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSPFCDNLock = new Integer(1);
    private PSPFCDN pspfcdn = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSStudioThemeLock = new Integer(1);
    private PSStudioTheme psstudiotheme = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objDEPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin depssyssfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSAppDERSsLock = new Integer(1);
    private ArrayList<PSAppDERS> psappderss = null;
    private Integer objPSAppDEViewRefsLock = new Integer(1);
    private ArrayList<PSAppDEViewRef> psappdeviewrefs = null;
    private Integer objPSAppEditorTemplsLock = new Integer(1);
    private ArrayList<PSAppEditorTempl> psappeditortempls = null;
    private Integer objPSAppFuncsLock = new Integer(1);
    private ArrayList<PSAppFunc> psappfuncs = null;
    private Integer objPSAppLansLock = new Integer(1);
    private ArrayList<PSAppLan> psapplans = null;
    private Integer objPSAppLocalDEsLock = new Integer(1);
    private ArrayList<PSAppLocalDE> psapplocaldes = null;
    private Integer objPSAppLogicsLock = new Integer(1);
    private ArrayList<PSAppLogic> psapplogics = null;
    private Integer objPSAppMenusLock = new Integer(1);
    private ArrayList<PSAppMenu> psappmenus = null;
    private Integer objPSAppModulesLock = new Integer(1);
    private ArrayList<PSAppModule> psappmodules = null;
    private Integer objPSAppPDTViewsLock = new Integer(1);
    private ArrayList<PSAppPDTView> psapppdtviews = null;
    private Integer objPSAppPFPluginsLock = new Integer(1);
    private ArrayList<PSAppPFPlugin> psapppfplugins = null;
    private Integer objPSAppPortletsLock = new Integer(1);
    private ArrayList<PSAppPortlet> psappportlets = null;
    private Integer objPSAppResourcesLock = new Integer(1);
    private ArrayList<PSAppResource> psappresources = null;
    private Integer objPSAppStoryBoardsLock = new Integer(1);
    private ArrayList<PSAppStoryBoard> psappstoryboards = null;
    private Integer objPSAppTitleBarsLock = new Integer(1);
    private ArrayList<PSAppTitleBar> psapptitlebars = null;
    private Integer objPSAppUIStylesLock = new Integer(1);
    private ArrayList<PSAppUIStyle> psappuistyles = null;
    private Integer objPSAppUIThemesLock = new Integer(1);
    private ArrayList<PSAppUITheme> psappuithemes = null;
    private Integer objPSAppUserModesLock = new Integer(1);
    private ArrayList<PSAppUserMode> psappusermodes = null;
    private Integer objPSAppUtilPagesLock = new Integer(1);
    private ArrayList<PSAppUtilPage> psapputilpages = null;
    private Integer objPSAppUtilsLock = new Integer(1);
    private ArrayList<PSAppUtil> psapputils = null;
    private Integer objPSAppViewCodesLock = new Integer(1);
    private ArrayList<PSAppViewCode> psappviewcodes = null;
    private Integer objPSAppViewsLock = new Integer(1);
    private ArrayList<PSAppView> psappviews = null;
    private Integer objPSAppWFsLock = new Integer(1);
    private ArrayList<PSAppWF> psappwfs = null;
    private Integer objPSMobAppStartPagesLock = new Integer(1);
    private ArrayList<PSMobAppStartPage> psmobappstartpages = null;
    private Integer objPSSysProjectsLock = new Integer(1);
    private ArrayList<PSSysProject> pssysprojects = null;
    private Integer objPSSysTasksLock = new Integer(1);
    private ArrayList<PSSysTask> pssystasks = null;
    private Integer objPSSysUCMapsLock = new Integer(1);
    private ArrayList<PSSysUCMap> pssysucmaps = null;

    public void setACMinChars(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACMinChars(n);
            return;
        }
        this.acminchars = n;
        this.acmincharsDirtyFlag = true;
    }

    public Integer getACMinChars() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACMinChars();
        }
        return this.acminchars;
    }

    public boolean isACMinCharsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACMinCharsDirty();
        }
        return this.acmincharsDirtyFlag;
    }

    public void resetACMinChars() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACMinChars();
            return;
        }
        this.acmincharsDirtyFlag = false;
        this.acminchars = null;
    }

    public void setAppFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appfolder = string;
        this.appfolderDirtyFlag = true;
    }

    public String getAppFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppFolder();
        }
        return this.appfolder;
    }

    public boolean isAppFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppFolderDirty();
        }
        return this.appfolderDirtyFlag;
    }

    public void resetAppFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppFolder();
            return;
        }
        this.appfolderDirtyFlag = false;
        this.appfolder = null;
    }

    public void setAppMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appmode = string;
        this.appmodeDirtyFlag = true;
    }

    public String getAppMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppMode();
        }
        return this.appmode;
    }

    public boolean isAppModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppModeDirty();
        }
        return this.appmodeDirtyFlag;
    }

    public void resetAppMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppMode();
            return;
        }
        this.appmodeDirtyFlag = false;
        this.appmode = null;
    }

    public void setAppPKGName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppPKGName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apppkgname = string;
        this.apppkgnameDirtyFlag = true;
    }

    public String getAppPKGName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppPKGName();
        }
        return this.apppkgname;
    }

    public boolean isAppPKGNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppPKGNameDirty();
        }
        return this.apppkgnameDirtyFlag;
    }

    public void resetAppPKGName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppPKGName();
            return;
        }
        this.apppkgnameDirtyFlag = false;
        this.apppkgname = null;
    }

    public void setAppSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appsn = string;
        this.appsnDirtyFlag = true;
    }

    public String getAppSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppSN();
        }
        return this.appsn;
    }

    public boolean isAppSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppSNDirty();
        }
        return this.appsnDirtyFlag;
    }

    public void resetAppSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppSN();
            return;
        }
        this.appsnDirtyFlag = false;
        this.appsn = null;
    }

    public void setAppTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag = string;
        this.apptagDirtyFlag = true;
    }

    public String getAppTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag();
        }
        return this.apptag;
    }

    public boolean isAppTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTagDirty();
        }
        return this.apptagDirtyFlag;
    }

    public void resetAppTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag();
            return;
        }
        this.apptagDirtyFlag = false;
        this.apptag = null;
    }

    public void setAppTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag2 = string;
        this.apptag2DirtyFlag = true;
    }

    public String getAppTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag2();
        }
        return this.apptag2;
    }

    public boolean isAppTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag2Dirty();
        }
        return this.apptag2DirtyFlag;
    }

    public void resetAppTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag2();
            return;
        }
        this.apptag2DirtyFlag = false;
        this.apptag2 = null;
    }

    public void setAppTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag3 = string;
        this.apptag3DirtyFlag = true;
    }

    public String getAppTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag3();
        }
        return this.apptag3;
    }

    public boolean isAppTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag3Dirty();
        }
        return this.apptag3DirtyFlag;
    }

    public void resetAppTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag3();
            return;
        }
        this.apptag3DirtyFlag = false;
        this.apptag3 = null;
    }

    public void setAppTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag4 = string;
        this.apptag4DirtyFlag = true;
    }

    public String getAppTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag4();
        }
        return this.apptag4;
    }

    public boolean isAppTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag4Dirty();
        }
        return this.apptag4DirtyFlag;
    }

    public void resetAppTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag4();
            return;
        }
        this.apptag4DirtyFlag = false;
        this.apptag4 = null;
    }

    public void setAppVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appversion = string;
        this.appversionDirtyFlag = true;
    }

    public String getAppVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppVersion();
        }
        return this.appversion;
    }

    public boolean isAppVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppVersionDirty();
        }
        return this.appversionDirtyFlag;
    }

    public void resetAppVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppVersion();
            return;
        }
        this.appversionDirtyFlag = false;
        this.appversion = null;
    }

    public void setAppViewPriority(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppViewPriority(n);
            return;
        }
        this.appviewpriority = n;
        this.appviewpriorityDirtyFlag = true;
    }

    public Integer getAppViewPriority() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppViewPriority();
        }
        return this.appviewpriority;
    }

    public boolean isAppViewPriorityDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppViewPriorityDirty();
        }
        return this.appviewpriorityDirtyFlag;
    }

    public void resetAppViewPriority() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppViewPriority();
            return;
        }
        this.appviewpriorityDirtyFlag = false;
        this.appviewpriority = null;
    }

    public void setAutoAddAppView(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoAddAppView(n);
            return;
        }
        this.autoaddappview = n;
        this.autoaddappviewDirtyFlag = true;
    }

    public Integer getAutoAddAppView() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoAddAppView();
        }
        return this.autoaddappview;
    }

    public boolean isAutoAddAppViewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoAddAppViewDirty();
        }
        return this.autoaddappviewDirtyFlag;
    }

    public void resetAutoAddAppView() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoAddAppView();
            return;
        }
        this.autoaddappviewDirtyFlag = false;
        this.autoaddappview = null;
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

    public void setBtnNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBtnNoPrivDM(n);
            return;
        }
        this.btnnoprivdm = n;
        this.btnnoprivdmDirtyFlag = true;
    }

    public Integer getBtnNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBtnNoPrivDM();
        }
        return this.btnnoprivdm;
    }

    public boolean isBtnNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBtnNoPrivDMDirty();
        }
        return this.btnnoprivdmDirtyFlag;
    }

    public void resetBtnNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBtnNoPrivDM();
            return;
        }
        this.btnnoprivdmDirtyFlag = false;
        this.btnnoprivdm = null;
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

    public void setCodeFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codefolder = string;
        this.codefolderDirtyFlag = true;
    }

    public String getCodeFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeFolder();
        }
        return this.codefolder;
    }

    public boolean isCodeFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeFolderDirty();
        }
        return this.codefolderDirtyFlag;
    }

    public void resetCodeFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeFolder();
            return;
        }
        this.codefolderDirtyFlag = false;
        this.codefolder = null;
    }

    public void setCodeNameMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeNameMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codenamemode = string;
        this.codenamemodeDirtyFlag = true;
    }

    public String getCodeNameMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeNameMode();
        }
        return this.codenamemode;
    }

    public boolean isCodeNameModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameModeDirty();
        }
        return this.codenamemodeDirtyFlag;
    }

    public void resetCodeNameMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeNameMode();
            return;
        }
        this.codenamemodeDirtyFlag = false;
        this.codenamemode = null;
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

    public void setDefaultPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPort(n);
            return;
        }
        this.defaultport = n;
        this.defaultportDirtyFlag = true;
    }

    public Integer getDefaultPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPort();
        }
        return this.defaultport;
    }

    public boolean isDefaultPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPortDirty();
        }
        return this.defaultportDirtyFlag;
    }

    public void resetDefaultPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPort();
            return;
        }
        this.defaultportDirtyFlag = false;
        this.defaultport = null;
    }

    public void setDefaultPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPub(n);
            return;
        }
        this.defaultpub = n;
        this.defaultpubDirtyFlag = true;
    }

    public Integer getDefaultPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPub();
        }
        return this.defaultpub;
    }

    public boolean isDefaultPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPubDirty();
        }
        return this.defaultpubDirtyFlag;
    }

    public void resetDefaultPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPub();
            return;
        }
        this.defaultpubDirtyFlag = false;
        this.defaultpub = null;
    }

    public void setDEPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depssyssfpluginid = string;
        this.depssyssfpluginidDirtyFlag = true;
    }

    public String getDEPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPluginId();
        }
        return this.depssyssfpluginid;
    }

    public boolean isDEPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPSSysSFPluginIdDirty();
        }
        return this.depssyssfpluginidDirtyFlag;
    }

    public void resetDEPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPSSysSFPluginId();
            return;
        }
        this.depssyssfpluginidDirtyFlag = false;
        this.depssyssfpluginid = null;
    }

    public void setDEPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depssyssfpluginname = string;
        this.depssyssfpluginnameDirtyFlag = true;
    }

    public String getDEPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPluginName();
        }
        return this.depssyssfpluginname;
    }

    public boolean isDEPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPSSysSFPluginNameDirty();
        }
        return this.depssyssfpluginnameDirtyFlag;
    }

    public void resetDEPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPSSysSFPluginName();
            return;
        }
        this.depssyssfpluginnameDirtyFlag = false;
        this.depssyssfpluginname = null;
    }

    public void setEnableC12ToC24(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableC12ToC24(n);
            return;
        }
        this.enablec12toc24 = n;
        this.enablec12toc24DirtyFlag = true;
    }

    public Integer getEnableC12ToC24() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableC12ToC24();
        }
        return this.enablec12toc24;
    }

    public boolean isEnableC12ToC24Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableC12ToC24Dirty();
        }
        return this.enablec12toc24DirtyFlag;
    }

    public void resetEnableC12ToC24() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableC12ToC24();
            return;
        }
        this.enablec12toc24DirtyFlag = false;
        this.enablec12toc24 = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setEnableStoryBoard(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableStoryBoard(n);
            return;
        }
        this.enablestoryboard = n;
        this.enablestoryboardDirtyFlag = true;
    }

    public Integer getEnableStoryBoard() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableStoryBoard();
        }
        return this.enablestoryboard;
    }

    public boolean isEnableStoryBoardDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableStoryBoardDirty();
        }
        return this.enablestoryboardDirtyFlag;
    }

    public void resetEnableStoryBoard() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableStoryBoard();
            return;
        }
        this.enablestoryboardDirtyFlag = false;
        this.enablestoryboard = null;
    }

    public void setEnableUIModelEx(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableUIModelEx(n);
            return;
        }
        this.enableuimodelex = n;
        this.enableuimodelexDirtyFlag = true;
    }

    public Integer getEnableUIModelEx() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableUIModelEx();
        }
        return this.enableuimodelex;
    }

    public boolean isEnableUIModelExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableUIModelExDirty();
        }
        return this.enableuimodelexDirtyFlag;
    }

    public void resetEnableUIModelEx() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableUIModelEx();
            return;
        }
        this.enableuimodelexDirtyFlag = false;
        this.enableuimodelex = null;
    }

    public void setEnaLocalService(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaLocalService(n);
            return;
        }
        this.enalocalservice = n;
        this.enalocalserviceDirtyFlag = true;
    }

    public Integer getEnaLocalService() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaLocalService();
        }
        return this.enalocalservice;
    }

    public boolean isEnaLocalServiceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaLocalServiceDirty();
        }
        return this.enalocalserviceDirtyFlag;
    }

    public void resetEnaLocalService() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaLocalService();
            return;
        }
        this.enalocalserviceDirtyFlag = false;
        this.enalocalservice = null;
    }

    public void setFIEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFIEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fiemptytext = string;
        this.fiemptytextDirtyFlag = true;
    }

    public String getFIEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFIEmptyText();
        }
        return this.fiemptytext;
    }

    public boolean isFIEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFIEmptyTextDirty();
        }
        return this.fiemptytextDirtyFlag;
    }

    public void resetFIEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFIEmptyText();
            return;
        }
        this.fiemptytextDirtyFlag = false;
        this.fiemptytext = null;
    }

    public void setFINoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFINoPrivDM(n);
            return;
        }
        this.finoprivdm = n;
        this.finoprivdmDirtyFlag = true;
    }

    public Integer getFINoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFINoPrivDM();
        }
        return this.finoprivdm;
    }

    public boolean isFINoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFINoPrivDMDirty();
        }
        return this.finoprivdmDirtyFlag;
    }

    public void resetFINoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFINoPrivDM();
            return;
        }
        this.finoprivdmDirtyFlag = false;
        this.finoprivdm = null;
    }

    public void setFIUpdatePrivTag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFIUpdatePrivTag(n);
            return;
        }
        this.fiupdateprivtag = n;
        this.fiupdateprivtagDirtyFlag = true;
    }

    public Integer getFIUpdatePrivTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFIUpdatePrivTag();
        }
        return this.fiupdateprivtag;
    }

    public boolean isFIUpdatePrivTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFIUpdatePrivTagDirty();
        }
        return this.fiupdateprivtagDirtyFlag;
    }

    public void resetFIUpdatePrivTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFIUpdatePrivTag();
            return;
        }
        this.fiupdateprivtagDirtyFlag = false;
        this.fiupdateprivtag = null;
    }

    public void setGCNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCNoPrivDM(n);
            return;
        }
        this.gcnoprivdm = n;
        this.gcnoprivdmDirtyFlag = true;
    }

    public Integer getGCNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCNoPrivDM();
        }
        return this.gcnoprivdm;
    }

    public boolean isGCNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCNoPrivDMDirty();
        }
        return this.gcnoprivdmDirtyFlag;
    }

    public void resetGCNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCNoPrivDM();
            return;
        }
        this.gcnoprivdmDirtyFlag = false;
        this.gcnoprivdm = null;
    }

    public void setGridColEnableFilter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColEnableFilter(n);
            return;
        }
        this.gridcolenablefilter = n;
        this.gridcolenablefilterDirtyFlag = true;
    }

    public Integer getGridColEnableFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColEnableFilter();
        }
        return this.gridcolenablefilter;
    }

    public boolean isGridColEnableFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColEnableFilterDirty();
        }
        return this.gridcolenablefilterDirtyFlag;
    }

    public void resetGridColEnableFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColEnableFilter();
            return;
        }
        this.gridcolenablefilterDirtyFlag = false;
        this.gridcolenablefilter = null;
    }

    public void setGridColEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColEnableLink(n);
            return;
        }
        this.gridcolenablelink = n;
        this.gridcolenablelinkDirtyFlag = true;
    }

    public Integer getGridColEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColEnableLink();
        }
        return this.gridcolenablelink;
    }

    public boolean isGridColEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColEnableLinkDirty();
        }
        return this.gridcolenablelinkDirtyFlag;
    }

    public void resetGridColEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColEnableLink();
            return;
        }
        this.gridcolenablelinkDirtyFlag = false;
        this.gridcolenablelink = null;
    }

    public void setGridEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridEnableCustomized(n);
            return;
        }
        this.gridenablecustomized = n;
        this.gridenablecustomizedDirtyFlag = true;
    }

    public Integer getGridEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridEnableCustomized();
        }
        return this.gridenablecustomized;
    }

    public boolean isGridEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridEnableCustomizedDirty();
        }
        return this.gridenablecustomizedDirtyFlag;
    }

    public void resetGridEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridEnableCustomized();
            return;
        }
        this.gridenablecustomizedDirtyFlag = false;
        this.gridenablecustomized = null;
    }

    public void setGridForceFit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridForceFit(n);
            return;
        }
        this.gridforcefit = n;
        this.gridforcefitDirtyFlag = true;
    }

    public Integer getGridForceFit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridForceFit();
        }
        return this.gridforcefit;
    }

    public boolean isGridForceFitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridForceFitDirty();
        }
        return this.gridforcefitDirtyFlag;
    }

    public void resetGridForceFit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridForceFit();
            return;
        }
        this.gridforcefitDirtyFlag = false;
        this.gridforcefit = null;
    }

    public void setGridRowActiveMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridRowActiveMode(n);
            return;
        }
        this.gridrowactivemode = n;
        this.gridrowactivemodeDirtyFlag = true;
    }

    public Integer getGridRowActiveMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridRowActiveMode();
        }
        return this.gridrowactivemode;
    }

    public boolean isGridRowActiveModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridRowActiveModeDirty();
        }
        return this.gridrowactivemodeDirtyFlag;
    }

    public void resetGridRowActiveMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridRowActiveMode();
            return;
        }
        this.gridrowactivemodeDirtyFlag = false;
        this.gridrowactivemode = null;
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

    public void setIconFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconfile = string;
        this.iconfileDirtyFlag = true;
    }

    public String getIconFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconFile();
        }
        return this.iconfile;
    }

    public boolean isIconFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconFileDirty();
        }
        return this.iconfileDirtyFlag;
    }

    public void resetIconFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconFile();
            return;
        }
        this.iconfileDirtyFlag = false;
        this.iconfile = null;
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

    public void setMainMenuSide(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainMenuSide(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainmenuside = string;
        this.mainmenusideDirtyFlag = true;
    }

    public String getMainMenuSide() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainMenuSide();
        }
        return this.mainmenuside;
    }

    public boolean isMainMenuSideDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainMenuSideDirty();
        }
        return this.mainmenusideDirtyFlag;
    }

    public void resetMainMenuSide() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainMenuSide();
            return;
        }
        this.mainmenusideDirtyFlag = false;
        this.mainmenuside = null;
    }

    public void setMDCtrlEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDCtrlEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdctrlemptytext = string;
        this.mdctrlemptytextDirtyFlag = true;
    }

    public String getMDCtrlEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlEmptyText();
        }
        return this.mdctrlemptytext;
    }

    public boolean isMDCtrlEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDCtrlEmptyTextDirty();
        }
        return this.mdctrlemptytextDirtyFlag;
    }

    public void resetMDCtrlEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDCtrlEmptyText();
            return;
        }
        this.mdctrlemptytextDirtyFlag = false;
        this.mdctrlemptytext = null;
    }

    public void setMDCtrlEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDCtrlEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdctrlemptytextpslanresid = string;
        this.mdctrlemptytextpslanresidDirtyFlag = true;
    }

    public String getMDCtrlEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlEmptyTextPSLanResId();
        }
        return this.mdctrlemptytextpslanresid;
    }

    public boolean isMDCtrlEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDCtrlEmptyTextPSLanResIdDirty();
        }
        return this.mdctrlemptytextpslanresidDirtyFlag;
    }

    public void resetMDCtrlEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDCtrlEmptyTextPSLanResId();
            return;
        }
        this.mdctrlemptytextpslanresidDirtyFlag = false;
        this.mdctrlemptytextpslanresid = null;
    }

    public void setMDCtrlEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDCtrlEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdctrlemptytextpslanresname = string;
        this.mdctrlemptytextpslanresnameDirtyFlag = true;
    }

    public String getMDCtrlEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlEmptyTextPSLanResName();
        }
        return this.mdctrlemptytextpslanresname;
    }

    public boolean isMDCtrlEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDCtrlEmptyTextPSLanResNameDirty();
        }
        return this.mdctrlemptytextpslanresnameDirtyFlag;
    }

    public void resetMDCtrlEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDCtrlEmptyTextPSLanResName();
            return;
        }
        this.mdctrlemptytextpslanresnameDirtyFlag = false;
        this.mdctrlemptytextpslanresname = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setOrientationMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrientationMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orientationmode = string;
        this.orientationmodeDirtyFlag = true;
    }

    public String getOrientationMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrientationMode();
        }
        return this.orientationmode;
    }

    public boolean isOrientationModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrientationModeDirty();
        }
        return this.orientationmodeDirtyFlag;
    }

    public void resetOrientationMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrientationMode();
            return;
        }
        this.orientationmodeDirtyFlag = false;
        this.orientationmode = null;
    }

    public void setPFStyleParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPFStyleParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pfstyleparam = string;
        this.pfstyleparamDirtyFlag = true;
    }

    public String getPFStyleParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPFStyleParam();
        }
        return this.pfstyleparam;
    }

    public boolean isPFStyleParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPFStyleParamDirty();
        }
        return this.pfstyleparamDirtyFlag;
    }

    public void resetPFStyleParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPFStyleParam();
            return;
        }
        this.pfstyleparamDirtyFlag = false;
        this.pfstyleparam = null;
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

    public void setPSAppEditorTemplsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppEditorTemplsCnt(n);
            return;
        }
        this.psappeditortemplscnt = n;
        this.psappeditortemplscntDirtyFlag = true;
    }

    public Integer getPSAppEditorTemplsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppEditorTemplsCnt();
        }
        return this.psappeditortemplscnt;
    }

    public boolean isPSAppEditorTemplsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppEditorTemplsCntDirty();
        }
        return this.psappeditortemplscntDirtyFlag;
    }

    public void resetPSAppEditorTemplsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppEditorTemplsCnt();
            return;
        }
        this.psappeditortemplscntDirtyFlag = false;
        this.psappeditortemplscnt = null;
    }

    public void setPSAppFuncsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncsCnt(n);
            return;
        }
        this.psappfuncscnt = n;
        this.psappfuncscntDirtyFlag = true;
    }

    public Integer getPSAppFuncsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncsCnt();
        }
        return this.psappfuncscnt;
    }

    public boolean isPSAppFuncsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncsCntDirty();
        }
        return this.psappfuncscntDirtyFlag;
    }

    public void resetPSAppFuncsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncsCnt();
            return;
        }
        this.psappfuncscntDirtyFlag = false;
        this.psappfuncscnt = null;
    }

    public void setPSAppMenusCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenusCnt(n);
            return;
        }
        this.psappmenuscnt = n;
        this.psappmenuscntDirtyFlag = true;
    }

    public Integer getPSAppMenusCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenusCnt();
        }
        return this.psappmenuscnt;
    }

    public boolean isPSAppMenusCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenusCntDirty();
        }
        return this.psappmenuscntDirtyFlag;
    }

    public void resetPSAppMenusCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenusCnt();
            return;
        }
        this.psappmenuscntDirtyFlag = false;
        this.psappmenuscnt = null;
    }

    public void setPSAppModulesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModulesCnt(n);
            return;
        }
        this.psappmodulescnt = n;
        this.psappmodulescntDirtyFlag = true;
    }

    public Integer getPSAppModulesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModulesCnt();
        }
        return this.psappmodulescnt;
    }

    public boolean isPSAppModulesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModulesCntDirty();
        }
        return this.psappmodulescntDirtyFlag;
    }

    public void resetPSAppModulesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModulesCnt();
            return;
        }
        this.psappmodulescntDirtyFlag = false;
        this.psappmodulescnt = null;
    }

    public void setPSAppPkgsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPkgsCnt(n);
            return;
        }
        this.psapppkgscnt = n;
        this.psapppkgscntDirtyFlag = true;
    }

    public Integer getPSAppPkgsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPkgsCnt();
        }
        return this.psapppkgscnt;
    }

    public boolean isPSAppPkgsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPkgsCntDirty();
        }
        return this.psapppkgscntDirtyFlag;
    }

    public void resetPSAppPkgsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPkgsCnt();
            return;
        }
        this.psapppkgscntDirtyFlag = false;
        this.psapppkgscnt = null;
    }

    public void setPSAppTitleBarsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTitleBarsCnt(n);
            return;
        }
        this.psapptitlebarscnt = n;
        this.psapptitlebarscntDirtyFlag = true;
    }

    public Integer getPSAppTitleBarsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBarsCnt();
        }
        return this.psapptitlebarscnt;
    }

    public boolean isPSAppTitleBarsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTitleBarsCntDirty();
        }
        return this.psapptitlebarscntDirtyFlag;
    }

    public void resetPSAppTitleBarsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTitleBarsCnt();
            return;
        }
        this.psapptitlebarscntDirtyFlag = false;
        this.psapptitlebarscnt = null;
    }

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
    }

    public void setPSAppUIThemesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUIThemesCnt(n);
            return;
        }
        this.psappuithemescnt = n;
        this.psappuithemescntDirtyFlag = true;
    }

    public Integer getPSAppUIThemesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIThemesCnt();
        }
        return this.psappuithemescnt;
    }

    public boolean isPSAppUIThemesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUIThemesCntDirty();
        }
        return this.psappuithemescntDirtyFlag;
    }

    public void resetPSAppUIThemesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUIThemesCnt();
            return;
        }
        this.psappuithemescntDirtyFlag = false;
        this.psappuithemescnt = null;
    }

    public void setPSAppUserModesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUserModesCnt(n);
            return;
        }
        this.psappusermodescnt = n;
        this.psappusermodescntDirtyFlag = true;
    }

    public Integer getPSAppUserModesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUserModesCnt();
        }
        return this.psappusermodescnt;
    }

    public boolean isPSAppUserModesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUserModesCntDirty();
        }
        return this.psappusermodescntDirtyFlag;
    }

    public void resetPSAppUserModesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUserModesCnt();
            return;
        }
        this.psappusermodescntDirtyFlag = false;
        this.psappusermodescnt = null;
    }

    public void setPSAppUtilPagesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilPagesCnt(n);
            return;
        }
        this.psapputilpagescnt = n;
        this.psapputilpagescntDirtyFlag = true;
    }

    public Integer getPSAppUtilPagesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilPagesCnt();
        }
        return this.psapputilpagescnt;
    }

    public boolean isPSAppUtilPagesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilPagesCntDirty();
        }
        return this.psapputilpagescntDirtyFlag;
    }

    public void resetPSAppUtilPagesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilPagesCnt();
            return;
        }
        this.psapputilpagescntDirtyFlag = false;
        this.psapputilpagescnt = null;
    }

    public void setPSAppViewCodesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewCodesCnt(n);
            return;
        }
        this.psappviewcodescnt = n;
        this.psappviewcodescntDirtyFlag = true;
    }

    public Integer getPSAppViewCodesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCodesCnt();
        }
        return this.psappviewcodescnt;
    }

    public boolean isPSAppViewCodesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewCodesCntDirty();
        }
        return this.psappviewcodescntDirtyFlag;
    }

    public void resetPSAppViewCodesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewCodesCnt();
            return;
        }
        this.psappviewcodescntDirtyFlag = false;
        this.psappviewcodescnt = null;
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

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSPFCDNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnid = string;
        this.pspfcdnidDirtyFlag = true;
    }

    public String getPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNId();
        }
        return this.pspfcdnid;
    }

    public boolean isPSPFCDNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNIdDirty();
        }
        return this.pspfcdnidDirtyFlag;
    }

    public void resetPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNId();
            return;
        }
        this.pspfcdnidDirtyFlag = false;
        this.pspfcdnid = null;
    }

    public void setPSPFCDNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnname = string;
        this.pspfcdnnameDirtyFlag = true;
    }

    public String getPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNName();
        }
        return this.pspfcdnname;
    }

    public boolean isPSPFCDNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNNameDirty();
        }
        return this.pspfcdnnameDirtyFlag;
    }

    public void resetPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNName();
            return;
        }
        this.pspfcdnnameDirtyFlag = false;
        this.pspfcdnname = null;
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

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
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

    public void setPSStudioThemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemeid = string;
        this.psstudiothemeidDirtyFlag = true;
    }

    public String getPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeId();
        }
        return this.psstudiothemeid;
    }

    public boolean isPSStudioThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeIdDirty();
        }
        return this.psstudiothemeidDirtyFlag;
    }

    public void resetPSStudioThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeId();
            return;
        }
        this.psstudiothemeidDirtyFlag = false;
        this.psstudiothemeid = null;
    }

    public void setPSStudioThemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioThemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudiothemename = string;
        this.psstudiothemenameDirtyFlag = true;
    }

    public String getPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioThemeName();
        }
        return this.psstudiothemename;
    }

    public boolean isPSStudioThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioThemeNameDirty();
        }
        return this.psstudiothemenameDirtyFlag;
    }

    public void resetPSStudioThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioThemeName();
            return;
        }
        this.psstudiothemenameDirtyFlag = false;
        this.psstudiothemename = null;
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

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
    }

    public void setPSSysTasksCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTasksCnt(n);
            return;
        }
        this.pssystaskscnt = n;
        this.pssystaskscntDirtyFlag = true;
    }

    public Integer getPSSysTasksCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasksCnt();
        }
        return this.pssystaskscnt;
    }

    public boolean isPSSysTasksCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTasksCntDirty();
        }
        return this.pssystaskscntDirtyFlag;
    }

    public void resetPSSysTasksCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTasksCnt();
            return;
        }
        this.pssystaskscntDirtyFlag = false;
        this.pssystaskscnt = null;
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

    public void setPubRefViewOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubRefViewOnly(n);
            return;
        }
        this.pubrefviewonly = n;
        this.pubrefviewonlyDirtyFlag = true;
    }

    public Integer getPubRefViewOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubRefViewOnly();
        }
        return this.pubrefviewonly;
    }

    public boolean isPubRefViewOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubRefViewOnlyDirty();
        }
        return this.pubrefviewonlyDirtyFlag;
    }

    public void resetPubRefViewOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubRefViewOnly();
            return;
        }
        this.pubrefviewonlyDirtyFlag = false;
        this.pubrefviewonly = null;
    }

    public void setPubSysRefViewOnly(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubSysRefViewOnly(n);
            return;
        }
        this.pubsysrefviewonly = n;
        this.pubsysrefviewonlyDirtyFlag = true;
    }

    public Integer getPubSysRefViewOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubSysRefViewOnly();
        }
        return this.pubsysrefviewonly;
    }

    public boolean isPubSysRefViewOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubSysRefViewOnlyDirty();
        }
        return this.pubsysrefviewonlyDirtyFlag;
    }

    public void resetPubSysRefViewOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubSysRefViewOnly();
            return;
        }
        this.pubsysrefviewonlyDirtyFlag = false;
        this.pubsysrefviewonly = null;
    }

    public void setRemoveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveFlag(n);
            return;
        }
        this.removeflag = n;
        this.removeflagDirtyFlag = true;
    }

    public Integer getRemoveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveFlag();
        }
        return this.removeflag;
    }

    public boolean isRemoveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveFlagDirty();
        }
        return this.removeflagDirtyFlag;
    }

    public void resetRemoveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveFlag();
            return;
        }
        this.removeflagDirtyFlag = false;
        this.removeflag = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setStartPageFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartPageFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startpagefile = string;
        this.startpagefileDirtyFlag = true;
    }

    public String getStartPageFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartPageFile();
        }
        return this.startpagefile;
    }

    public boolean isStartPageFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartPageFileDirty();
        }
        return this.startpagefileDirtyFlag;
    }

    public void resetStartPageFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartPageFile();
            return;
        }
        this.startpagefileDirtyFlag = false;
        this.startpagefile = null;
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

    public void setUACLogin(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUACLogin(n);
            return;
        }
        this.uaclogin = n;
        this.uacloginDirtyFlag = true;
    }

    public Integer getUACLogin() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUACLogin();
        }
        return this.uaclogin;
    }

    public boolean isUACLoginDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUACLoginDirty();
        }
        return this.uacloginDirtyFlag;
    }

    public void resetUACLogin() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUACLogin();
            return;
        }
        this.uacloginDirtyFlag = false;
        this.uaclogin = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAppBase pSSysAppBase) {
        pSSysAppBase.resetACMinChars();
        pSSysAppBase.resetAppFolder();
        pSSysAppBase.resetAppMode();
        pSSysAppBase.resetAppPKGName();
        pSSysAppBase.resetAppSN();
        pSSysAppBase.resetAppTag();
        pSSysAppBase.resetAppTag2();
        pSSysAppBase.resetAppTag3();
        pSSysAppBase.resetAppTag4();
        pSSysAppBase.resetAppVersion();
        pSSysAppBase.resetAppViewPriority();
        pSSysAppBase.resetAutoAddAppView();
        pSSysAppBase.resetBottomInfo();
        pSSysAppBase.resetBtnNoPrivDM();
        pSSysAppBase.resetCaption();
        pSSysAppBase.resetCodeFolder();
        pSSysAppBase.resetCodeNameMode();
        pSSysAppBase.resetCreateDate();
        pSSysAppBase.resetCreateMan();
        pSSysAppBase.resetDefaultPort();
        pSSysAppBase.resetDefaultPub();
        pSSysAppBase.resetDEPSSysSFPluginId();
        pSSysAppBase.resetDEPSSysSFPluginName();
        pSSysAppBase.resetEnableC12ToC24();
        pSSysAppBase.resetEnableDynaSys();
        pSSysAppBase.resetEnableStoryBoard();
        pSSysAppBase.resetEnableUIModelEx();
        pSSysAppBase.resetEnaLocalService();
        pSSysAppBase.resetFIEmptyText();
        pSSysAppBase.resetFINoPrivDM();
        pSSysAppBase.resetFIUpdatePrivTag();
        pSSysAppBase.resetGCNoPrivDM();
        pSSysAppBase.resetGridColEnableFilter();
        pSSysAppBase.resetGridColEnableLink();
        pSSysAppBase.resetGridEnableCustomized();
        pSSysAppBase.resetGridForceFit();
        pSSysAppBase.resetGridRowActiveMode();
        pSSysAppBase.resetHeaderInfo();
        pSSysAppBase.resetIconFile();
        pSSysAppBase.resetLogicName();
        pSSysAppBase.resetMainMenuSide();
        pSSysAppBase.resetMDCtrlEmptyText();
        pSSysAppBase.resetMDCtrlEmptyTextPSLanResId();
        pSSysAppBase.resetMDCtrlEmptyTextPSLanResName();
        pSSysAppBase.resetMemo();
        pSSysAppBase.resetOrderValue();
        pSSysAppBase.resetOrientationMode();
        pSSysAppBase.resetPFStyleParam();
        pSSysAppBase.resetPreventXSS();
        pSSysAppBase.resetPSAppEditorTemplsCnt();
        pSSysAppBase.resetPSAppFuncsCnt();
        pSSysAppBase.resetPSAppMenusCnt();
        pSSysAppBase.resetPSAppModulesCnt();
        pSSysAppBase.resetPSAppPkgsCnt();
        pSSysAppBase.resetPSAppTitleBarsCnt();
        pSSysAppBase.resetPSAppTypeId();
        pSSysAppBase.resetPSAppTypeName();
        pSSysAppBase.resetPSAppUIThemesCnt();
        pSSysAppBase.resetPSAppUserModesCnt();
        pSSysAppBase.resetPSAppUtilPagesCnt();
        pSSysAppBase.resetPSAppViewCodesCnt();
        pSSysAppBase.resetPSAppViewsCnt();
        pSSysAppBase.resetPSCtrlLogicGroupId();
        pSSysAppBase.resetPSCtrlLogicGroupName();
        pSSysAppBase.resetPSDevSlnSysAppId();
        pSSysAppBase.resetPSModuleId();
        pSSysAppBase.resetPSModuleName();
        pSSysAppBase.resetPSPFCDNId();
        pSSysAppBase.resetPSPFCDNName();
        pSSysAppBase.resetPSPFId();
        pSSysAppBase.resetPSPFName();
        pSSysAppBase.resetPSPFStyleId();
        pSSysAppBase.resetPSPFStyleName();
        pSSysAppBase.resetPSStudioThemeId();
        pSSysAppBase.resetPSStudioThemeName();
        pSSysAppBase.resetPSSysAppId();
        pSSysAppBase.resetPSSysAppName();
        pSSysAppBase.resetPSSysCssId();
        pSSysAppBase.resetPSSysCssName();
        pSSysAppBase.resetPSSysDynaModelId();
        pSSysAppBase.resetPSSysDynaModelName();
        pSSysAppBase.resetPSSysImageId();
        pSSysAppBase.resetPSSysImageName();
        pSSysAppBase.resetPSSysReqItemId();
        pSSysAppBase.resetPSSysReqItemName();
        pSSysAppBase.resetPSSysResourceId();
        pSSysAppBase.resetPSSysResourceName();
        pSSysAppBase.resetPSSysServiceAPIId();
        pSSysAppBase.resetPSSysServiceAPIName();
        pSSysAppBase.resetPSSysSFPluginId();
        pSSysAppBase.resetPSSysSFPluginName();
        pSSysAppBase.resetPSSysSFPubId();
        pSSysAppBase.resetPSSysSFPubName();
        pSSysAppBase.resetPSSysTasksCnt();
        pSSysAppBase.resetPSSystemId();
        pSSysAppBase.resetPSSystemName();
        pSSysAppBase.resetPSViewMsgGroupId();
        pSSysAppBase.resetPSViewMsgGroupName();
        pSSysAppBase.resetPubRefViewOnly();
        pSSysAppBase.resetPubSysRefViewOnly();
        pSSysAppBase.resetRemoveFlag();
        pSSysAppBase.resetServiceCodeName();
        pSSysAppBase.resetStartPageFile();
        pSSysAppBase.resetSubCaption();
        pSSysAppBase.resetTitle();
        pSSysAppBase.resetUACLogin();
        pSSysAppBase.resetUIStyle();
        pSSysAppBase.resetUpdateDate();
        pSSysAppBase.resetUpdateMan();
        pSSysAppBase.resetUserCat();
        pSSysAppBase.resetUserParams();
        pSSysAppBase.resetUserTag();
        pSSysAppBase.resetUserTag2();
        pSSysAppBase.resetUserTag3();
        pSSysAppBase.resetUserTag4();
        pSSysAppBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isACMinCharsDirty()) {
            hashMap.put(FIELD_ACMINCHARS, this.getACMinChars());
        }
        if (!bl || this.isAppFolderDirty()) {
            hashMap.put(FIELD_APPFOLDER, this.getAppFolder());
        }
        if (!bl || this.isAppModeDirty()) {
            hashMap.put(FIELD_APPMODE, this.getAppMode());
        }
        if (!bl || this.isAppPKGNameDirty()) {
            hashMap.put(FIELD_APPPKGNAME, this.getAppPKGName());
        }
        if (!bl || this.isAppSNDirty()) {
            hashMap.put(FIELD_APPSN, this.getAppSN());
        }
        if (!bl || this.isAppTagDirty()) {
            hashMap.put(FIELD_APPTAG, this.getAppTag());
        }
        if (!bl || this.isAppTag2Dirty()) {
            hashMap.put(FIELD_APPTAG2, this.getAppTag2());
        }
        if (!bl || this.isAppTag3Dirty()) {
            hashMap.put(FIELD_APPTAG3, this.getAppTag3());
        }
        if (!bl || this.isAppTag4Dirty()) {
            hashMap.put(FIELD_APPTAG4, this.getAppTag4());
        }
        if (!bl || this.isAppVersionDirty()) {
            hashMap.put(FIELD_APPVERSION, this.getAppVersion());
        }
        if (!bl || this.isAppViewPriorityDirty()) {
            hashMap.put(FIELD_APPVIEWPRIORITY, this.getAppViewPriority());
        }
        if (!bl || this.isAutoAddAppViewDirty()) {
            hashMap.put(FIELD_AUTOADDAPPVIEW, this.getAutoAddAppView());
        }
        if (!bl || this.isBottomInfoDirty()) {
            hashMap.put(FIELD_BOTTOMINFO, this.getBottomInfo());
        }
        if (!bl || this.isBtnNoPrivDMDirty()) {
            hashMap.put(FIELD_BTNNOPRIVDM, this.getBtnNoPrivDM());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCodeFolderDirty()) {
            hashMap.put(FIELD_CODEFOLDER, this.getCodeFolder());
        }
        if (!bl || this.isCodeNameModeDirty()) {
            hashMap.put(FIELD_CODENAMEMODE, this.getCodeNameMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultPortDirty()) {
            hashMap.put(FIELD_DEFAULTPORT, this.getDefaultPort());
        }
        if (!bl || this.isDefaultPubDirty()) {
            hashMap.put(FIELD_DEFAULTPUB, this.getDefaultPub());
        }
        if (!bl || this.isDEPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_DEPSSYSSFPLUGINID, this.getDEPSSysSFPluginId());
        }
        if (!bl || this.isDEPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_DEPSSYSSFPLUGINNAME, this.getDEPSSysSFPluginName());
        }
        if (!bl || this.isEnableC12ToC24Dirty()) {
            hashMap.put(FIELD_ENABLEC12TOC24, this.getEnableC12ToC24());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableStoryBoardDirty()) {
            hashMap.put(FIELD_ENABLESTORYBOARD, this.getEnableStoryBoard());
        }
        if (!bl || this.isEnableUIModelExDirty()) {
            hashMap.put(FIELD_ENABLEUIMODELEX, this.getEnableUIModelEx());
        }
        if (!bl || this.isEnaLocalServiceDirty()) {
            hashMap.put(FIELD_ENALOCALSERVICE, this.getEnaLocalService());
        }
        if (!bl || this.isFIEmptyTextDirty()) {
            hashMap.put(FIELD_FIEMPTYTEXT, this.getFIEmptyText());
        }
        if (!bl || this.isFINoPrivDMDirty()) {
            hashMap.put(FIELD_FINOPRIVDM, this.getFINoPrivDM());
        }
        if (!bl || this.isFIUpdatePrivTagDirty()) {
            hashMap.put(FIELD_FIUPDATEPRIVTAG, this.getFIUpdatePrivTag());
        }
        if (!bl || this.isGCNoPrivDMDirty()) {
            hashMap.put(FIELD_GCNOPRIVDM, this.getGCNoPrivDM());
        }
        if (!bl || this.isGridColEnableFilterDirty()) {
            hashMap.put(FIELD_GRIDCOLENABLEFILTER, this.getGridColEnableFilter());
        }
        if (!bl || this.isGridColEnableLinkDirty()) {
            hashMap.put(FIELD_GRIDCOLENABLELINK, this.getGridColEnableLink());
        }
        if (!bl || this.isGridEnableCustomizedDirty()) {
            hashMap.put(FIELD_GRIDENABLECUSTOMIZED, this.getGridEnableCustomized());
        }
        if (!bl || this.isGridForceFitDirty()) {
            hashMap.put(FIELD_GRIDFORCEFIT, this.getGridForceFit());
        }
        if (!bl || this.isGridRowActiveModeDirty()) {
            hashMap.put(FIELD_GRIDROWACTIVEMODE, this.getGridRowActiveMode());
        }
        if (!bl || this.isHeaderInfoDirty()) {
            hashMap.put(FIELD_HEADERINFO, this.getHeaderInfo());
        }
        if (!bl || this.isIconFileDirty()) {
            hashMap.put(FIELD_ICONFILE, this.getIconFile());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMainMenuSideDirty()) {
            hashMap.put(FIELD_MAINMENUSIDE, this.getMainMenuSide());
        }
        if (!bl || this.isMDCtrlEmptyTextDirty()) {
            hashMap.put(FIELD_MDCTRLEMPTYTEXT, this.getMDCtrlEmptyText());
        }
        if (!bl || this.isMDCtrlEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_MDCTRLEMPTYTEXTPSLANRESID, this.getMDCtrlEmptyTextPSLanResId());
        }
        if (!bl || this.isMDCtrlEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME, this.getMDCtrlEmptyTextPSLanResName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOrientationModeDirty()) {
            hashMap.put(FIELD_ORIENTATIONMODE, this.getOrientationMode());
        }
        if (!bl || this.isPFStyleParamDirty()) {
            hashMap.put(FIELD_PFSTYLEPARAM, this.getPFStyleParam());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPSAppEditorTemplsCntDirty()) {
            hashMap.put(FIELD_PSAPPEDITORTEMPLSCNT, this.getPSAppEditorTemplsCnt());
        }
        if (!bl || this.isPSAppFuncsCntDirty()) {
            hashMap.put(FIELD_PSAPPFUNCSCNT, this.getPSAppFuncsCnt());
        }
        if (!bl || this.isPSAppMenusCntDirty()) {
            hashMap.put(FIELD_PSAPPMENUSCNT, this.getPSAppMenusCnt());
        }
        if (!bl || this.isPSAppModulesCntDirty()) {
            hashMap.put(FIELD_PSAPPMODULESCNT, this.getPSAppModulesCnt());
        }
        if (!bl || this.isPSAppPkgsCntDirty()) {
            hashMap.put(FIELD_PSAPPPKGSCNT, this.getPSAppPkgsCnt());
        }
        if (!bl || this.isPSAppTitleBarsCntDirty()) {
            hashMap.put(FIELD_PSAPPTITLEBARSCNT, this.getPSAppTitleBarsCnt());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
        }
        if (!bl || this.isPSAppUIThemesCntDirty()) {
            hashMap.put(FIELD_PSAPPUITHEMESCNT, this.getPSAppUIThemesCnt());
        }
        if (!bl || this.isPSAppUserModesCntDirty()) {
            hashMap.put(FIELD_PSAPPUSERMODESCNT, this.getPSAppUserModesCnt());
        }
        if (!bl || this.isPSAppUtilPagesCntDirty()) {
            hashMap.put(FIELD_PSAPPUTILPAGESCNT, this.getPSAppUtilPagesCnt());
        }
        if (!bl || this.isPSAppViewCodesCntDirty()) {
            hashMap.put(FIELD_PSAPPVIEWCODESCNT, this.getPSAppViewCodesCnt());
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
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSPFCDNIdDirty()) {
            hashMap.put(FIELD_PSPFCDNID, this.getPSPFCDNId());
        }
        if (!bl || this.isPSPFCDNNameDirty()) {
            hashMap.put(FIELD_PSPFCDNNAME, this.getPSPFCDNName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSStudioThemeIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMEID, this.getPSStudioThemeId());
        }
        if (!bl || this.isPSStudioThemeNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOTHEMENAME, this.getPSStudioThemeName());
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
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSysTasksCntDirty()) {
            hashMap.put(FIELD_PSSYSTASKSCNT, this.getPSSysTasksCnt());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isPubRefViewOnlyDirty()) {
            hashMap.put(FIELD_PUBREFVIEWONLY, this.getPubRefViewOnly());
        }
        if (!bl || this.isPubSysRefViewOnlyDirty()) {
            hashMap.put(FIELD_PUBSYSREFVIEWONLY, this.getPubSysRefViewOnly());
        }
        if (!bl || this.isRemoveFlagDirty()) {
            hashMap.put(FIELD_REMOVEFLAG, this.getRemoveFlag());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isStartPageFileDirty()) {
            hashMap.put(FIELD_STARTPAGEFILE, this.getStartPageFile());
        }
        if (!bl || this.isSubCaptionDirty()) {
            hashMap.put(FIELD_SUBCAPTION, this.getSubCaption());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isUACLoginDirty()) {
            hashMap.put(FIELD_UACLOGIN, this.getUACLogin());
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
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSSysAppBase.get(this, n);
    }

    private static Object get(PSSysAppBase pSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAppBase.getACMinChars();
            }
            case 1: {
                return pSSysAppBase.getAppFolder();
            }
            case 2: {
                return pSSysAppBase.getAppMode();
            }
            case 3: {
                return pSSysAppBase.getAppPKGName();
            }
            case 4: {
                return pSSysAppBase.getAppSN();
            }
            case 5: {
                return pSSysAppBase.getAppTag();
            }
            case 6: {
                return pSSysAppBase.getAppTag2();
            }
            case 7: {
                return pSSysAppBase.getAppTag3();
            }
            case 8: {
                return pSSysAppBase.getAppTag4();
            }
            case 9: {
                return pSSysAppBase.getAppVersion();
            }
            case 10: {
                return pSSysAppBase.getAppViewPriority();
            }
            case 11: {
                return pSSysAppBase.getAutoAddAppView();
            }
            case 12: {
                return pSSysAppBase.getBottomInfo();
            }
            case 13: {
                return pSSysAppBase.getBtnNoPrivDM();
            }
            case 14: {
                return pSSysAppBase.getCaption();
            }
            case 15: {
                return pSSysAppBase.getCodeFolder();
            }
            case 16: {
                return pSSysAppBase.getCodeNameMode();
            }
            case 17: {
                return pSSysAppBase.getCreateDate();
            }
            case 18: {
                return pSSysAppBase.getCreateMan();
            }
            case 19: {
                return pSSysAppBase.getDefaultPort();
            }
            case 20: {
                return pSSysAppBase.getDefaultPub();
            }
            case 21: {
                return pSSysAppBase.getDEPSSysSFPluginId();
            }
            case 22: {
                return pSSysAppBase.getDEPSSysSFPluginName();
            }
            case 23: {
                return pSSysAppBase.getEnableC12ToC24();
            }
            case 24: {
                return pSSysAppBase.getEnableDynaSys();
            }
            case 25: {
                return pSSysAppBase.getEnableStoryBoard();
            }
            case 26: {
                return pSSysAppBase.getEnableUIModelEx();
            }
            case 27: {
                return pSSysAppBase.getEnaLocalService();
            }
            case 28: {
                return pSSysAppBase.getFIEmptyText();
            }
            case 29: {
                return pSSysAppBase.getFINoPrivDM();
            }
            case 30: {
                return pSSysAppBase.getFIUpdatePrivTag();
            }
            case 31: {
                return pSSysAppBase.getGCNoPrivDM();
            }
            case 32: {
                return pSSysAppBase.getGridColEnableFilter();
            }
            case 33: {
                return pSSysAppBase.getGridColEnableLink();
            }
            case 34: {
                return pSSysAppBase.getGridEnableCustomized();
            }
            case 35: {
                return pSSysAppBase.getGridForceFit();
            }
            case 36: {
                return pSSysAppBase.getGridRowActiveMode();
            }
            case 37: {
                return pSSysAppBase.getHeaderInfo();
            }
            case 38: {
                return pSSysAppBase.getIconFile();
            }
            case 39: {
                return pSSysAppBase.getLogicName();
            }
            case 40: {
                return pSSysAppBase.getMainMenuSide();
            }
            case 41: {
                return pSSysAppBase.getMDCtrlEmptyText();
            }
            case 42: {
                return pSSysAppBase.getMDCtrlEmptyTextPSLanResId();
            }
            case 43: {
                return pSSysAppBase.getMDCtrlEmptyTextPSLanResName();
            }
            case 44: {
                return pSSysAppBase.getMemo();
            }
            case 45: {
                return pSSysAppBase.getOrderValue();
            }
            case 46: {
                return pSSysAppBase.getOrientationMode();
            }
            case 47: {
                return pSSysAppBase.getPFStyleParam();
            }
            case 48: {
                return pSSysAppBase.getPreventXSS();
            }
            case 49: {
                return pSSysAppBase.getPSAppEditorTemplsCnt();
            }
            case 50: {
                return pSSysAppBase.getPSAppFuncsCnt();
            }
            case 51: {
                return pSSysAppBase.getPSAppMenusCnt();
            }
            case 52: {
                return pSSysAppBase.getPSAppModulesCnt();
            }
            case 53: {
                return pSSysAppBase.getPSAppPkgsCnt();
            }
            case 54: {
                return pSSysAppBase.getPSAppTitleBarsCnt();
            }
            case 55: {
                return pSSysAppBase.getPSAppTypeId();
            }
            case 56: {
                return pSSysAppBase.getPSAppTypeName();
            }
            case 57: {
                return pSSysAppBase.getPSAppUIThemesCnt();
            }
            case 58: {
                return pSSysAppBase.getPSAppUserModesCnt();
            }
            case 59: {
                return pSSysAppBase.getPSAppUtilPagesCnt();
            }
            case 60: {
                return pSSysAppBase.getPSAppViewCodesCnt();
            }
            case 61: {
                return pSSysAppBase.getPSAppViewsCnt();
            }
            case 62: {
                return pSSysAppBase.getPSCtrlLogicGroupId();
            }
            case 63: {
                return pSSysAppBase.getPSCtrlLogicGroupName();
            }
            case 64: {
                return pSSysAppBase.getPSDevSlnSysAppId();
            }
            case 65: {
                return pSSysAppBase.getPSModuleId();
            }
            case 66: {
                return pSSysAppBase.getPSModuleName();
            }
            case 67: {
                return pSSysAppBase.getPSPFCDNId();
            }
            case 68: {
                return pSSysAppBase.getPSPFCDNName();
            }
            case 69: {
                return pSSysAppBase.getPSPFId();
            }
            case 70: {
                return pSSysAppBase.getPSPFName();
            }
            case 71: {
                return pSSysAppBase.getPSPFStyleId();
            }
            case 72: {
                return pSSysAppBase.getPSPFStyleName();
            }
            case 73: {
                return pSSysAppBase.getPSStudioThemeId();
            }
            case 74: {
                return pSSysAppBase.getPSStudioThemeName();
            }
            case 75: {
                return pSSysAppBase.getPSSysAppId();
            }
            case 76: {
                return pSSysAppBase.getPSSysAppName();
            }
            case 77: {
                return pSSysAppBase.getPSSysCssId();
            }
            case 78: {
                return pSSysAppBase.getPSSysCssName();
            }
            case 79: {
                return pSSysAppBase.getPSSysDynaModelId();
            }
            case 80: {
                return pSSysAppBase.getPSSysDynaModelName();
            }
            case 81: {
                return pSSysAppBase.getPSSysImageId();
            }
            case 82: {
                return pSSysAppBase.getPSSysImageName();
            }
            case 83: {
                return pSSysAppBase.getPSSysReqItemId();
            }
            case 84: {
                return pSSysAppBase.getPSSysReqItemName();
            }
            case 85: {
                return pSSysAppBase.getPSSysResourceId();
            }
            case 86: {
                return pSSysAppBase.getPSSysResourceName();
            }
            case 87: {
                return pSSysAppBase.getPSSysServiceAPIId();
            }
            case 88: {
                return pSSysAppBase.getPSSysServiceAPIName();
            }
            case 89: {
                return pSSysAppBase.getPSSysSFPluginId();
            }
            case 90: {
                return pSSysAppBase.getPSSysSFPluginName();
            }
            case 91: {
                return pSSysAppBase.getPSSysSFPubId();
            }
            case 92: {
                return pSSysAppBase.getPSSysSFPubName();
            }
            case 93: {
                return pSSysAppBase.getPSSysTasksCnt();
            }
            case 94: {
                return pSSysAppBase.getPSSystemId();
            }
            case 95: {
                return pSSysAppBase.getPSSystemName();
            }
            case 96: {
                return pSSysAppBase.getPSViewMsgGroupId();
            }
            case 97: {
                return pSSysAppBase.getPSViewMsgGroupName();
            }
            case 98: {
                return pSSysAppBase.getPubRefViewOnly();
            }
            case 99: {
                return pSSysAppBase.getPubSysRefViewOnly();
            }
            case 100: {
                return pSSysAppBase.getRemoveFlag();
            }
            case 101: {
                return pSSysAppBase.getServiceCodeName();
            }
            case 102: {
                return pSSysAppBase.getStartPageFile();
            }
            case 103: {
                return pSSysAppBase.getSubCaption();
            }
            case 104: {
                return pSSysAppBase.getTitle();
            }
            case 105: {
                return pSSysAppBase.getUACLogin();
            }
            case 106: {
                return pSSysAppBase.getUIStyle();
            }
            case 107: {
                return pSSysAppBase.getUpdateDate();
            }
            case 108: {
                return pSSysAppBase.getUpdateMan();
            }
            case 109: {
                return pSSysAppBase.getUserCat();
            }
            case 110: {
                return pSSysAppBase.getUserParams();
            }
            case 111: {
                return pSSysAppBase.getUserTag();
            }
            case 112: {
                return pSSysAppBase.getUserTag2();
            }
            case 113: {
                return pSSysAppBase.getUserTag3();
            }
            case 114: {
                return pSSysAppBase.getUserTag4();
            }
            case 115: {
                return pSSysAppBase.getValidFlag();
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
        PSSysAppBase.set(this, n, object);
    }

    private static void set(PSSysAppBase pSSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAppBase.setACMinChars(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysAppBase.setAppFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAppBase.setAppMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAppBase.setAppPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAppBase.setAppSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAppBase.setAppTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAppBase.setAppTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAppBase.setAppTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysAppBase.setAppTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAppBase.setAppVersion(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAppBase.setAppViewPriority(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysAppBase.setAutoAddAppView(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysAppBase.setBottomInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAppBase.setBtnNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysAppBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAppBase.setCodeFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAppBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAppBase.setDefaultPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysAppBase.setDefaultPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysAppBase.setDEPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysAppBase.setDEPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAppBase.setEnableC12ToC24(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysAppBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysAppBase.setEnableStoryBoard(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysAppBase.setEnableUIModelEx(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysAppBase.setEnaLocalService(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysAppBase.setFIEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysAppBase.setFINoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSysAppBase.setFIUpdatePrivTag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysAppBase.setGCNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysAppBase.setGridColEnableFilter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSysAppBase.setGridColEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSysAppBase.setGridEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysAppBase.setGridForceFit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysAppBase.setGridRowActiveMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSysAppBase.setHeaderInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysAppBase.setIconFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysAppBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysAppBase.setMainMenuSide(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysAppBase.setMDCtrlEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysAppBase.setMDCtrlEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysAppBase.setMDCtrlEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysAppBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSSysAppBase.setOrientationMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysAppBase.setPFStyleParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysAppBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSSysAppBase.setPSAppEditorTemplsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSSysAppBase.setPSAppFuncsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSSysAppBase.setPSAppMenusCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSSysAppBase.setPSAppModulesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSSysAppBase.setPSAppPkgsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSSysAppBase.setPSAppTitleBarsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSSysAppBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysAppBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysAppBase.setPSAppUIThemesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSSysAppBase.setPSAppUserModesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysAppBase.setPSAppUtilPagesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSSysAppBase.setPSAppViewCodesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSSysAppBase.setPSAppViewsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSSysAppBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSysAppBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysAppBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysAppBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysAppBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSSysAppBase.setPSPFCDNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysAppBase.setPSPFCDNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysAppBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSSysAppBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysAppBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysAppBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysAppBase.setPSStudioThemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysAppBase.setPSStudioThemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSSysAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSysAppBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSSysAppBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSysAppBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysAppBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysAppBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysAppBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSysAppBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSysAppBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSSysAppBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSSysAppBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSysAppBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysAppBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSSysAppBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSSysAppBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSSysAppBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSSysAppBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSSysAppBase.setPSSysTasksCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 94: {
                pSSysAppBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSSysAppBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSSysAppBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSSysAppBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSSysAppBase.setPubRefViewOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 99: {
                pSSysAppBase.setPubSysRefViewOnly(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 100: {
                pSSysAppBase.setRemoveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSSysAppBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSSysAppBase.setStartPageFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSSysAppBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSSysAppBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSSysAppBase.setUACLogin(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 106: {
                pSSysAppBase.setUIStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 108: {
                pSSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSSysAppBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSSysAppBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSSysAppBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSSysAppBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSSysAppBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSSysAppBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSSysAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAppBase pSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAppBase.getACMinChars() == null;
            }
            case 1: {
                return pSSysAppBase.getAppFolder() == null;
            }
            case 2: {
                return pSSysAppBase.getAppMode() == null;
            }
            case 3: {
                return pSSysAppBase.getAppPKGName() == null;
            }
            case 4: {
                return pSSysAppBase.getAppSN() == null;
            }
            case 5: {
                return pSSysAppBase.getAppTag() == null;
            }
            case 6: {
                return pSSysAppBase.getAppTag2() == null;
            }
            case 7: {
                return pSSysAppBase.getAppTag3() == null;
            }
            case 8: {
                return pSSysAppBase.getAppTag4() == null;
            }
            case 9: {
                return pSSysAppBase.getAppVersion() == null;
            }
            case 10: {
                return pSSysAppBase.getAppViewPriority() == null;
            }
            case 11: {
                return pSSysAppBase.getAutoAddAppView() == null;
            }
            case 12: {
                return pSSysAppBase.getBottomInfo() == null;
            }
            case 13: {
                return pSSysAppBase.getBtnNoPrivDM() == null;
            }
            case 14: {
                return pSSysAppBase.getCaption() == null;
            }
            case 15: {
                return pSSysAppBase.getCodeFolder() == null;
            }
            case 16: {
                return pSSysAppBase.getCodeNameMode() == null;
            }
            case 17: {
                return pSSysAppBase.getCreateDate() == null;
            }
            case 18: {
                return pSSysAppBase.getCreateMan() == null;
            }
            case 19: {
                return pSSysAppBase.getDefaultPort() == null;
            }
            case 20: {
                return pSSysAppBase.getDefaultPub() == null;
            }
            case 21: {
                return pSSysAppBase.getDEPSSysSFPluginId() == null;
            }
            case 22: {
                return pSSysAppBase.getDEPSSysSFPluginName() == null;
            }
            case 23: {
                return pSSysAppBase.getEnableC12ToC24() == null;
            }
            case 24: {
                return pSSysAppBase.getEnableDynaSys() == null;
            }
            case 25: {
                return pSSysAppBase.getEnableStoryBoard() == null;
            }
            case 26: {
                return pSSysAppBase.getEnableUIModelEx() == null;
            }
            case 27: {
                return pSSysAppBase.getEnaLocalService() == null;
            }
            case 28: {
                return pSSysAppBase.getFIEmptyText() == null;
            }
            case 29: {
                return pSSysAppBase.getFINoPrivDM() == null;
            }
            case 30: {
                return pSSysAppBase.getFIUpdatePrivTag() == null;
            }
            case 31: {
                return pSSysAppBase.getGCNoPrivDM() == null;
            }
            case 32: {
                return pSSysAppBase.getGridColEnableFilter() == null;
            }
            case 33: {
                return pSSysAppBase.getGridColEnableLink() == null;
            }
            case 34: {
                return pSSysAppBase.getGridEnableCustomized() == null;
            }
            case 35: {
                return pSSysAppBase.getGridForceFit() == null;
            }
            case 36: {
                return pSSysAppBase.getGridRowActiveMode() == null;
            }
            case 37: {
                return pSSysAppBase.getHeaderInfo() == null;
            }
            case 38: {
                return pSSysAppBase.getIconFile() == null;
            }
            case 39: {
                return pSSysAppBase.getLogicName() == null;
            }
            case 40: {
                return pSSysAppBase.getMainMenuSide() == null;
            }
            case 41: {
                return pSSysAppBase.getMDCtrlEmptyText() == null;
            }
            case 42: {
                return pSSysAppBase.getMDCtrlEmptyTextPSLanResId() == null;
            }
            case 43: {
                return pSSysAppBase.getMDCtrlEmptyTextPSLanResName() == null;
            }
            case 44: {
                return pSSysAppBase.getMemo() == null;
            }
            case 45: {
                return pSSysAppBase.getOrderValue() == null;
            }
            case 46: {
                return pSSysAppBase.getOrientationMode() == null;
            }
            case 47: {
                return pSSysAppBase.getPFStyleParam() == null;
            }
            case 48: {
                return pSSysAppBase.getPreventXSS() == null;
            }
            case 49: {
                return pSSysAppBase.getPSAppEditorTemplsCnt() == null;
            }
            case 50: {
                return pSSysAppBase.getPSAppFuncsCnt() == null;
            }
            case 51: {
                return pSSysAppBase.getPSAppMenusCnt() == null;
            }
            case 52: {
                return pSSysAppBase.getPSAppModulesCnt() == null;
            }
            case 53: {
                return pSSysAppBase.getPSAppPkgsCnt() == null;
            }
            case 54: {
                return pSSysAppBase.getPSAppTitleBarsCnt() == null;
            }
            case 55: {
                return pSSysAppBase.getPSAppTypeId() == null;
            }
            case 56: {
                return pSSysAppBase.getPSAppTypeName() == null;
            }
            case 57: {
                return pSSysAppBase.getPSAppUIThemesCnt() == null;
            }
            case 58: {
                return pSSysAppBase.getPSAppUserModesCnt() == null;
            }
            case 59: {
                return pSSysAppBase.getPSAppUtilPagesCnt() == null;
            }
            case 60: {
                return pSSysAppBase.getPSAppViewCodesCnt() == null;
            }
            case 61: {
                return pSSysAppBase.getPSAppViewsCnt() == null;
            }
            case 62: {
                return pSSysAppBase.getPSCtrlLogicGroupId() == null;
            }
            case 63: {
                return pSSysAppBase.getPSCtrlLogicGroupName() == null;
            }
            case 64: {
                return pSSysAppBase.getPSDevSlnSysAppId() == null;
            }
            case 65: {
                return pSSysAppBase.getPSModuleId() == null;
            }
            case 66: {
                return pSSysAppBase.getPSModuleName() == null;
            }
            case 67: {
                return pSSysAppBase.getPSPFCDNId() == null;
            }
            case 68: {
                return pSSysAppBase.getPSPFCDNName() == null;
            }
            case 69: {
                return pSSysAppBase.getPSPFId() == null;
            }
            case 70: {
                return pSSysAppBase.getPSPFName() == null;
            }
            case 71: {
                return pSSysAppBase.getPSPFStyleId() == null;
            }
            case 72: {
                return pSSysAppBase.getPSPFStyleName() == null;
            }
            case 73: {
                return pSSysAppBase.getPSStudioThemeId() == null;
            }
            case 74: {
                return pSSysAppBase.getPSStudioThemeName() == null;
            }
            case 75: {
                return pSSysAppBase.getPSSysAppId() == null;
            }
            case 76: {
                return pSSysAppBase.getPSSysAppName() == null;
            }
            case 77: {
                return pSSysAppBase.getPSSysCssId() == null;
            }
            case 78: {
                return pSSysAppBase.getPSSysCssName() == null;
            }
            case 79: {
                return pSSysAppBase.getPSSysDynaModelId() == null;
            }
            case 80: {
                return pSSysAppBase.getPSSysDynaModelName() == null;
            }
            case 81: {
                return pSSysAppBase.getPSSysImageId() == null;
            }
            case 82: {
                return pSSysAppBase.getPSSysImageName() == null;
            }
            case 83: {
                return pSSysAppBase.getPSSysReqItemId() == null;
            }
            case 84: {
                return pSSysAppBase.getPSSysReqItemName() == null;
            }
            case 85: {
                return pSSysAppBase.getPSSysResourceId() == null;
            }
            case 86: {
                return pSSysAppBase.getPSSysResourceName() == null;
            }
            case 87: {
                return pSSysAppBase.getPSSysServiceAPIId() == null;
            }
            case 88: {
                return pSSysAppBase.getPSSysServiceAPIName() == null;
            }
            case 89: {
                return pSSysAppBase.getPSSysSFPluginId() == null;
            }
            case 90: {
                return pSSysAppBase.getPSSysSFPluginName() == null;
            }
            case 91: {
                return pSSysAppBase.getPSSysSFPubId() == null;
            }
            case 92: {
                return pSSysAppBase.getPSSysSFPubName() == null;
            }
            case 93: {
                return pSSysAppBase.getPSSysTasksCnt() == null;
            }
            case 94: {
                return pSSysAppBase.getPSSystemId() == null;
            }
            case 95: {
                return pSSysAppBase.getPSSystemName() == null;
            }
            case 96: {
                return pSSysAppBase.getPSViewMsgGroupId() == null;
            }
            case 97: {
                return pSSysAppBase.getPSViewMsgGroupName() == null;
            }
            case 98: {
                return pSSysAppBase.getPubRefViewOnly() == null;
            }
            case 99: {
                return pSSysAppBase.getPubSysRefViewOnly() == null;
            }
            case 100: {
                return pSSysAppBase.getRemoveFlag() == null;
            }
            case 101: {
                return pSSysAppBase.getServiceCodeName() == null;
            }
            case 102: {
                return pSSysAppBase.getStartPageFile() == null;
            }
            case 103: {
                return pSSysAppBase.getSubCaption() == null;
            }
            case 104: {
                return pSSysAppBase.getTitle() == null;
            }
            case 105: {
                return pSSysAppBase.getUACLogin() == null;
            }
            case 106: {
                return pSSysAppBase.getUIStyle() == null;
            }
            case 107: {
                return pSSysAppBase.getUpdateDate() == null;
            }
            case 108: {
                return pSSysAppBase.getUpdateMan() == null;
            }
            case 109: {
                return pSSysAppBase.getUserCat() == null;
            }
            case 110: {
                return pSSysAppBase.getUserParams() == null;
            }
            case 111: {
                return pSSysAppBase.getUserTag() == null;
            }
            case 112: {
                return pSSysAppBase.getUserTag2() == null;
            }
            case 113: {
                return pSSysAppBase.getUserTag3() == null;
            }
            case 114: {
                return pSSysAppBase.getUserTag4() == null;
            }
            case 115: {
                return pSSysAppBase.getValidFlag() == null;
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
        return PSSysAppBase.contains(this, n);
    }

    private static boolean contains(PSSysAppBase pSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAppBase.isACMinCharsDirty();
            }
            case 1: {
                return pSSysAppBase.isAppFolderDirty();
            }
            case 2: {
                return pSSysAppBase.isAppModeDirty();
            }
            case 3: {
                return pSSysAppBase.isAppPKGNameDirty();
            }
            case 4: {
                return pSSysAppBase.isAppSNDirty();
            }
            case 5: {
                return pSSysAppBase.isAppTagDirty();
            }
            case 6: {
                return pSSysAppBase.isAppTag2Dirty();
            }
            case 7: {
                return pSSysAppBase.isAppTag3Dirty();
            }
            case 8: {
                return pSSysAppBase.isAppTag4Dirty();
            }
            case 9: {
                return pSSysAppBase.isAppVersionDirty();
            }
            case 10: {
                return pSSysAppBase.isAppViewPriorityDirty();
            }
            case 11: {
                return pSSysAppBase.isAutoAddAppViewDirty();
            }
            case 12: {
                return pSSysAppBase.isBottomInfoDirty();
            }
            case 13: {
                return pSSysAppBase.isBtnNoPrivDMDirty();
            }
            case 14: {
                return pSSysAppBase.isCaptionDirty();
            }
            case 15: {
                return pSSysAppBase.isCodeFolderDirty();
            }
            case 16: {
                return pSSysAppBase.isCodeNameModeDirty();
            }
            case 17: {
                return pSSysAppBase.isCreateDateDirty();
            }
            case 18: {
                return pSSysAppBase.isCreateManDirty();
            }
            case 19: {
                return pSSysAppBase.isDefaultPortDirty();
            }
            case 20: {
                return pSSysAppBase.isDefaultPubDirty();
            }
            case 21: {
                return pSSysAppBase.isDEPSSysSFPluginIdDirty();
            }
            case 22: {
                return pSSysAppBase.isDEPSSysSFPluginNameDirty();
            }
            case 23: {
                return pSSysAppBase.isEnableC12ToC24Dirty();
            }
            case 24: {
                return pSSysAppBase.isEnableDynaSysDirty();
            }
            case 25: {
                return pSSysAppBase.isEnableStoryBoardDirty();
            }
            case 26: {
                return pSSysAppBase.isEnableUIModelExDirty();
            }
            case 27: {
                return pSSysAppBase.isEnaLocalServiceDirty();
            }
            case 28: {
                return pSSysAppBase.isFIEmptyTextDirty();
            }
            case 29: {
                return pSSysAppBase.isFINoPrivDMDirty();
            }
            case 30: {
                return pSSysAppBase.isFIUpdatePrivTagDirty();
            }
            case 31: {
                return pSSysAppBase.isGCNoPrivDMDirty();
            }
            case 32: {
                return pSSysAppBase.isGridColEnableFilterDirty();
            }
            case 33: {
                return pSSysAppBase.isGridColEnableLinkDirty();
            }
            case 34: {
                return pSSysAppBase.isGridEnableCustomizedDirty();
            }
            case 35: {
                return pSSysAppBase.isGridForceFitDirty();
            }
            case 36: {
                return pSSysAppBase.isGridRowActiveModeDirty();
            }
            case 37: {
                return pSSysAppBase.isHeaderInfoDirty();
            }
            case 38: {
                return pSSysAppBase.isIconFileDirty();
            }
            case 39: {
                return pSSysAppBase.isLogicNameDirty();
            }
            case 40: {
                return pSSysAppBase.isMainMenuSideDirty();
            }
            case 41: {
                return pSSysAppBase.isMDCtrlEmptyTextDirty();
            }
            case 42: {
                return pSSysAppBase.isMDCtrlEmptyTextPSLanResIdDirty();
            }
            case 43: {
                return pSSysAppBase.isMDCtrlEmptyTextPSLanResNameDirty();
            }
            case 44: {
                return pSSysAppBase.isMemoDirty();
            }
            case 45: {
                return pSSysAppBase.isOrderValueDirty();
            }
            case 46: {
                return pSSysAppBase.isOrientationModeDirty();
            }
            case 47: {
                return pSSysAppBase.isPFStyleParamDirty();
            }
            case 48: {
                return pSSysAppBase.isPreventXSSDirty();
            }
            case 49: {
                return pSSysAppBase.isPSAppEditorTemplsCntDirty();
            }
            case 50: {
                return pSSysAppBase.isPSAppFuncsCntDirty();
            }
            case 51: {
                return pSSysAppBase.isPSAppMenusCntDirty();
            }
            case 52: {
                return pSSysAppBase.isPSAppModulesCntDirty();
            }
            case 53: {
                return pSSysAppBase.isPSAppPkgsCntDirty();
            }
            case 54: {
                return pSSysAppBase.isPSAppTitleBarsCntDirty();
            }
            case 55: {
                return pSSysAppBase.isPSAppTypeIdDirty();
            }
            case 56: {
                return pSSysAppBase.isPSAppTypeNameDirty();
            }
            case 57: {
                return pSSysAppBase.isPSAppUIThemesCntDirty();
            }
            case 58: {
                return pSSysAppBase.isPSAppUserModesCntDirty();
            }
            case 59: {
                return pSSysAppBase.isPSAppUtilPagesCntDirty();
            }
            case 60: {
                return pSSysAppBase.isPSAppViewCodesCntDirty();
            }
            case 61: {
                return pSSysAppBase.isPSAppViewsCntDirty();
            }
            case 62: {
                return pSSysAppBase.isPSCtrlLogicGroupIdDirty();
            }
            case 63: {
                return pSSysAppBase.isPSCtrlLogicGroupNameDirty();
            }
            case 64: {
                return pSSysAppBase.isPSDevSlnSysAppIdDirty();
            }
            case 65: {
                return pSSysAppBase.isPSModuleIdDirty();
            }
            case 66: {
                return pSSysAppBase.isPSModuleNameDirty();
            }
            case 67: {
                return pSSysAppBase.isPSPFCDNIdDirty();
            }
            case 68: {
                return pSSysAppBase.isPSPFCDNNameDirty();
            }
            case 69: {
                return pSSysAppBase.isPSPFIdDirty();
            }
            case 70: {
                return pSSysAppBase.isPSPFNameDirty();
            }
            case 71: {
                return pSSysAppBase.isPSPFStyleIdDirty();
            }
            case 72: {
                return pSSysAppBase.isPSPFStyleNameDirty();
            }
            case 73: {
                return pSSysAppBase.isPSStudioThemeIdDirty();
            }
            case 74: {
                return pSSysAppBase.isPSStudioThemeNameDirty();
            }
            case 75: {
                return pSSysAppBase.isPSSysAppIdDirty();
            }
            case 76: {
                return pSSysAppBase.isPSSysAppNameDirty();
            }
            case 77: {
                return pSSysAppBase.isPSSysCssIdDirty();
            }
            case 78: {
                return pSSysAppBase.isPSSysCssNameDirty();
            }
            case 79: {
                return pSSysAppBase.isPSSysDynaModelIdDirty();
            }
            case 80: {
                return pSSysAppBase.isPSSysDynaModelNameDirty();
            }
            case 81: {
                return pSSysAppBase.isPSSysImageIdDirty();
            }
            case 82: {
                return pSSysAppBase.isPSSysImageNameDirty();
            }
            case 83: {
                return pSSysAppBase.isPSSysReqItemIdDirty();
            }
            case 84: {
                return pSSysAppBase.isPSSysReqItemNameDirty();
            }
            case 85: {
                return pSSysAppBase.isPSSysResourceIdDirty();
            }
            case 86: {
                return pSSysAppBase.isPSSysResourceNameDirty();
            }
            case 87: {
                return pSSysAppBase.isPSSysServiceAPIIdDirty();
            }
            case 88: {
                return pSSysAppBase.isPSSysServiceAPINameDirty();
            }
            case 89: {
                return pSSysAppBase.isPSSysSFPluginIdDirty();
            }
            case 90: {
                return pSSysAppBase.isPSSysSFPluginNameDirty();
            }
            case 91: {
                return pSSysAppBase.isPSSysSFPubIdDirty();
            }
            case 92: {
                return pSSysAppBase.isPSSysSFPubNameDirty();
            }
            case 93: {
                return pSSysAppBase.isPSSysTasksCntDirty();
            }
            case 94: {
                return pSSysAppBase.isPSSystemIdDirty();
            }
            case 95: {
                return pSSysAppBase.isPSSystemNameDirty();
            }
            case 96: {
                return pSSysAppBase.isPSViewMsgGroupIdDirty();
            }
            case 97: {
                return pSSysAppBase.isPSViewMsgGroupNameDirty();
            }
            case 98: {
                return pSSysAppBase.isPubRefViewOnlyDirty();
            }
            case 99: {
                return pSSysAppBase.isPubSysRefViewOnlyDirty();
            }
            case 100: {
                return pSSysAppBase.isRemoveFlagDirty();
            }
            case 101: {
                return pSSysAppBase.isServiceCodeNameDirty();
            }
            case 102: {
                return pSSysAppBase.isStartPageFileDirty();
            }
            case 103: {
                return pSSysAppBase.isSubCaptionDirty();
            }
            case 104: {
                return pSSysAppBase.isTitleDirty();
            }
            case 105: {
                return pSSysAppBase.isUACLoginDirty();
            }
            case 106: {
                return pSSysAppBase.isUIStyleDirty();
            }
            case 107: {
                return pSSysAppBase.isUpdateDateDirty();
            }
            case 108: {
                return pSSysAppBase.isUpdateManDirty();
            }
            case 109: {
                return pSSysAppBase.isUserCatDirty();
            }
            case 110: {
                return pSSysAppBase.isUserParamsDirty();
            }
            case 111: {
                return pSSysAppBase.isUserTagDirty();
            }
            case 112: {
                return pSSysAppBase.isUserTag2Dirty();
            }
            case 113: {
                return pSSysAppBase.isUserTag3Dirty();
            }
            case 114: {
                return pSSysAppBase.isUserTag4Dirty();
            }
            case 115: {
                return pSSysAppBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAppBase pSSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAppBase.getACMinChars() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"acminchars", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getACMinChars()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfolder", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppFolder()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appmode", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppMode()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppkgname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppPKGName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appsn", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppSN()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppTag()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag2", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppTag2()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag3", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppTag3()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag4", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppTag4()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appversion", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppVersion()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAppViewPriority() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewpriority", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAppViewPriority()), (boolean)false);
        }
        if (bl || pSSysAppBase.getAutoAddAppView() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autoaddappview", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getAutoAddAppView()), (boolean)false);
        }
        if (bl || pSSysAppBase.getBottomInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottominfo", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getBottomInfo()), (boolean)false);
        }
        if (bl || pSSysAppBase.getBtnNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnnoprivdm", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getBtnNoPrivDM()), (boolean)false);
        }
        if (bl || pSSysAppBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysAppBase.getCodeFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codefolder", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getCodeFolder()), (boolean)false);
        }
        if (bl || pSSysAppBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAppBase.getDefaultPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultport", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getDefaultPort()), (boolean)false);
        }
        if (bl || pSSysAppBase.getDefaultPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpub", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getDefaultPub()), (boolean)false);
        }
        if (bl || pSSysAppBase.getDEPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getDEPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getDEPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depssyssfpluginname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getDEPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getEnableC12ToC24() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablec12toc24", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getEnableC12ToC24()), (boolean)false);
        }
        if (bl || pSSysAppBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSSysAppBase.getEnableStoryBoard() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablestoryboard", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getEnableStoryBoard()), (boolean)false);
        }
        if (bl || pSSysAppBase.getEnableUIModelEx() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableuimodelex", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getEnableUIModelEx()), (boolean)false);
        }
        if (bl || pSSysAppBase.getEnaLocalService() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enalocalservice", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getEnaLocalService()), (boolean)false);
        }
        if (bl || pSSysAppBase.getFIEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fiemptytext", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getFIEmptyText()), (boolean)false);
        }
        if (bl || pSSysAppBase.getFINoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finoprivdm", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getFINoPrivDM()), (boolean)false);
        }
        if (bl || pSSysAppBase.getFIUpdatePrivTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fiupdateprivtag", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getFIUpdatePrivTag()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGCNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcnoprivdm", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGCNoPrivDM()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGridColEnableFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolenablefilter", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGridColEnableFilter()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGridColEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolenablelink", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGridColEnableLink()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGridEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridenablecustomized", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGridEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGridForceFit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridforcefit", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGridForceFit()), (boolean)false);
        }
        if (bl || pSSysAppBase.getGridRowActiveMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridrowactivemode", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getGridRowActiveMode()), (boolean)false);
        }
        if (bl || pSSysAppBase.getHeaderInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerinfo", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getHeaderInfo()), (boolean)false);
        }
        if (bl || pSSysAppBase.getIconFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconfile", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getIconFile()), (boolean)false);
        }
        if (bl || pSSysAppBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getMainMenuSide() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainmenuside", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getMainMenuSide()), (boolean)false);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdctrlemptytext", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getMDCtrlEmptyText()), (boolean)false);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdctrlemptytextpslanresid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getMDCtrlEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdctrlemptytextpslanresname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getMDCtrlEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAppBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysAppBase.getOrientationMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orientationmode", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getOrientationMode()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPFStyleParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pfstyleparam", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPFStyleParam()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppEditorTemplsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappeditortemplscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppEditorTemplsCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppFuncsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppFuncsCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppMenusCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppMenusCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppModulesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulescnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppModulesCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppPkgsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppkgscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppPkgsCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppTitleBarsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptitlebarscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppTitleBarsCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppUIThemesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappuithemescnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppUIThemesCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppUserModesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappusermodescnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppUserModesCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppUtilPagesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilpagescnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppUtilPagesCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppViewCodesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewcodescnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppViewCodesCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSAppViewsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSAppViewsCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFCDNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFCDNId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFCDNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFCDNName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSStudioThemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemeid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSStudioThemeId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSStudioThemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudiothemename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSStudioThemeName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSysTasksCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskscnt", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSysTasksCnt()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPubRefViewOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubrefviewonly", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPubRefViewOnly()), (boolean)false);
        }
        if (bl || pSSysAppBase.getPubSysRefViewOnly() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubsysrefviewonly", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getPubSysRefViewOnly()), (boolean)false);
        }
        if (bl || pSSysAppBase.getRemoveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeflag", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getRemoveFlag()), (boolean)false);
        }
        if (bl || pSSysAppBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysAppBase.getStartPageFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startpagefile", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getStartPageFile()), (boolean)false);
        }
        if (bl || pSSysAppBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSSysAppBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getTitle()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUACLogin() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uaclogin", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUACLogin()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUIStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uistyle", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUIStyle()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAppBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAppBase.getJSONValue((Object)pSSysAppBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAppBase pSSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAppBase.getACMinChars() != null) {
            object = pSSysAppBase.getACMinChars();
            xmlNode.setAttribute(FIELD_ACMINCHARS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getAppFolder() != null) {
            object = pSSysAppBase.getAppFolder();
            xmlNode.setAttribute(FIELD_APPFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppMode() != null) {
            object = pSSysAppBase.getAppMode();
            xmlNode.setAttribute(FIELD_APPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppPKGName() != null) {
            object = pSSysAppBase.getAppPKGName();
            xmlNode.setAttribute(FIELD_APPPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppSN() != null) {
            object = pSSysAppBase.getAppSN();
            xmlNode.setAttribute(FIELD_APPSN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppTag() != null) {
            object = pSSysAppBase.getAppTag();
            xmlNode.setAttribute(FIELD_APPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppTag2() != null) {
            object = pSSysAppBase.getAppTag2();
            xmlNode.setAttribute(FIELD_APPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppTag3() != null) {
            object = pSSysAppBase.getAppTag3();
            xmlNode.setAttribute(FIELD_APPTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppTag4() != null) {
            object = pSSysAppBase.getAppTag4();
            xmlNode.setAttribute(FIELD_APPTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppVersion() != null) {
            object = pSSysAppBase.getAppVersion();
            xmlNode.setAttribute(FIELD_APPVERSION, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getAppViewPriority() != null) {
            object = pSSysAppBase.getAppViewPriority();
            xmlNode.setAttribute(FIELD_APPVIEWPRIORITY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getAutoAddAppView() != null) {
            object = pSSysAppBase.getAutoAddAppView();
            xmlNode.setAttribute(FIELD_AUTOADDAPPVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getBottomInfo() != null) {
            object = pSSysAppBase.getBottomInfo();
            xmlNode.setAttribute(FIELD_BOTTOMINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getBtnNoPrivDM() != null) {
            object = pSSysAppBase.getBtnNoPrivDM();
            xmlNode.setAttribute(FIELD_BTNNOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getCaption() != null) {
            object = pSSysAppBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getCodeFolder() != null) {
            object = pSSysAppBase.getCodeFolder();
            xmlNode.setAttribute(FIELD_CODEFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getCodeNameMode() != null) {
            object = pSSysAppBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getCreateDate() != null) {
            object = pSSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAppBase.getCreateMan() != null) {
            object = pSSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getDefaultPort() != null) {
            object = pSSysAppBase.getDefaultPort();
            xmlNode.setAttribute(FIELD_DEFAULTPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getDefaultPub() != null) {
            object = pSSysAppBase.getDefaultPub();
            xmlNode.setAttribute(FIELD_DEFAULTPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getDEPSSysSFPluginId() != null) {
            object = pSSysAppBase.getDEPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getDEPSSysSFPluginName() != null) {
            object = pSSysAppBase.getDEPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_DEPSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getEnableC12ToC24() != null) {
            object = pSSysAppBase.getEnableC12ToC24();
            xmlNode.setAttribute(FIELD_ENABLEC12TOC24, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getEnableDynaSys() != null) {
            object = pSSysAppBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getEnableStoryBoard() != null) {
            object = pSSysAppBase.getEnableStoryBoard();
            xmlNode.setAttribute(FIELD_ENABLESTORYBOARD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getEnableUIModelEx() != null) {
            object = pSSysAppBase.getEnableUIModelEx();
            xmlNode.setAttribute(FIELD_ENABLEUIMODELEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getEnaLocalService() != null) {
            object = pSSysAppBase.getEnaLocalService();
            xmlNode.setAttribute(FIELD_ENALOCALSERVICE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getFIEmptyText() != null) {
            object = pSSysAppBase.getFIEmptyText();
            xmlNode.setAttribute(FIELD_FIEMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getFINoPrivDM() != null) {
            object = pSSysAppBase.getFINoPrivDM();
            xmlNode.setAttribute(FIELD_FINOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getFIUpdatePrivTag() != null) {
            object = pSSysAppBase.getFIUpdatePrivTag();
            xmlNode.setAttribute(FIELD_FIUPDATEPRIVTAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGCNoPrivDM() != null) {
            object = pSSysAppBase.getGCNoPrivDM();
            xmlNode.setAttribute(FIELD_GCNOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGridColEnableFilter() != null) {
            object = pSSysAppBase.getGridColEnableFilter();
            xmlNode.setAttribute(FIELD_GRIDCOLENABLEFILTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGridColEnableLink() != null) {
            object = pSSysAppBase.getGridColEnableLink();
            xmlNode.setAttribute(FIELD_GRIDCOLENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGridEnableCustomized() != null) {
            object = pSSysAppBase.getGridEnableCustomized();
            xmlNode.setAttribute(FIELD_GRIDENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGridForceFit() != null) {
            object = pSSysAppBase.getGridForceFit();
            xmlNode.setAttribute(FIELD_GRIDFORCEFIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getGridRowActiveMode() != null) {
            object = pSSysAppBase.getGridRowActiveMode();
            xmlNode.setAttribute(FIELD_GRIDROWACTIVEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getHeaderInfo() != null) {
            object = pSSysAppBase.getHeaderInfo();
            xmlNode.setAttribute(FIELD_HEADERINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getIconFile() != null) {
            object = pSSysAppBase.getIconFile();
            xmlNode.setAttribute(FIELD_ICONFILE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getLogicName() != null) {
            object = pSSysAppBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getMainMenuSide() != null) {
            object = pSSysAppBase.getMainMenuSide();
            xmlNode.setAttribute(FIELD_MAINMENUSIDE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyText() != null) {
            object = pSSysAppBase.getMDCtrlEmptyText();
            xmlNode.setAttribute(FIELD_MDCTRLEMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResId() != null) {
            object = pSSysAppBase.getMDCtrlEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_MDCTRLEMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResName() != null) {
            object = pSSysAppBase.getMDCtrlEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getMemo() != null) {
            object = pSSysAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getOrderValue() != null) {
            object = pSSysAppBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getOrientationMode() != null) {
            object = pSSysAppBase.getOrientationMode();
            xmlNode.setAttribute(FIELD_ORIENTATIONMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPFStyleParam() != null) {
            object = pSSysAppBase.getPFStyleParam();
            xmlNode.setAttribute(FIELD_PFSTYLEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPreventXSS() != null) {
            object = pSSysAppBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppEditorTemplsCnt() != null) {
            object = pSSysAppBase.getPSAppEditorTemplsCnt();
            xmlNode.setAttribute(FIELD_PSAPPEDITORTEMPLSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppFuncsCnt() != null) {
            object = pSSysAppBase.getPSAppFuncsCnt();
            xmlNode.setAttribute(FIELD_PSAPPFUNCSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppMenusCnt() != null) {
            object = pSSysAppBase.getPSAppMenusCnt();
            xmlNode.setAttribute(FIELD_PSAPPMENUSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppModulesCnt() != null) {
            object = pSSysAppBase.getPSAppModulesCnt();
            xmlNode.setAttribute(FIELD_PSAPPMODULESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppPkgsCnt() != null) {
            object = pSSysAppBase.getPSAppPkgsCnt();
            xmlNode.setAttribute(FIELD_PSAPPPKGSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppTitleBarsCnt() != null) {
            object = pSSysAppBase.getPSAppTitleBarsCnt();
            xmlNode.setAttribute(FIELD_PSAPPTITLEBARSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppTypeId() != null) {
            object = pSSysAppBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSAppTypeName() != null) {
            object = pSSysAppBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSAppUIThemesCnt() != null) {
            object = pSSysAppBase.getPSAppUIThemesCnt();
            xmlNode.setAttribute(FIELD_PSAPPUITHEMESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppUserModesCnt() != null) {
            object = pSSysAppBase.getPSAppUserModesCnt();
            xmlNode.setAttribute(FIELD_PSAPPUSERMODESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppUtilPagesCnt() != null) {
            object = pSSysAppBase.getPSAppUtilPagesCnt();
            xmlNode.setAttribute(FIELD_PSAPPUTILPAGESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppViewCodesCnt() != null) {
            object = pSSysAppBase.getPSAppViewCodesCnt();
            xmlNode.setAttribute(FIELD_PSAPPVIEWCODESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSAppViewsCnt() != null) {
            object = pSSysAppBase.getPSAppViewsCnt();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysAppBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysAppBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSDevSlnSysAppId() != null) {
            object = pSSysAppBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSModuleId() != null) {
            object = pSSysAppBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSModuleName() != null) {
            object = pSSysAppBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFCDNId() != null) {
            object = pSSysAppBase.getPSPFCDNId();
            xmlNode.setAttribute(FIELD_PSPFCDNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFCDNName() != null) {
            object = pSSysAppBase.getPSPFCDNName();
            xmlNode.setAttribute(FIELD_PSPFCDNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFId() != null) {
            object = pSSysAppBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFName() != null) {
            object = pSSysAppBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFStyleId() != null) {
            object = pSSysAppBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSPFStyleName() != null) {
            object = pSSysAppBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSStudioThemeId() != null) {
            object = pSSysAppBase.getPSStudioThemeId();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSStudioThemeName() != null) {
            object = pSSysAppBase.getPSStudioThemeName();
            xmlNode.setAttribute(FIELD_PSSTUDIOTHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysAppId() != null) {
            object = pSSysAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysAppName() != null) {
            object = pSSysAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysCssId() != null) {
            object = pSSysAppBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysCssName() != null) {
            object = pSSysAppBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysDynaModelId() != null) {
            object = pSSysAppBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysDynaModelName() != null) {
            object = pSSysAppBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysImageId() != null) {
            object = pSSysAppBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysImageName() != null) {
            object = pSSysAppBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysReqItemId() != null) {
            object = pSSysAppBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysReqItemName() != null) {
            object = pSSysAppBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysResourceId() != null) {
            object = pSSysAppBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysResourceName() != null) {
            object = pSSysAppBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysServiceAPIId() != null) {
            object = pSSysAppBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysServiceAPIName() != null) {
            object = pSSysAppBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysSFPluginId() != null) {
            object = pSSysAppBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysSFPluginName() != null) {
            object = pSSysAppBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysSFPubId() != null) {
            object = pSSysAppBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysSFPubName() != null) {
            object = pSSysAppBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSysTasksCnt() != null) {
            object = pSSysAppBase.getPSSysTasksCnt();
            xmlNode.setAttribute(FIELD_PSSYSTASKSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPSSystemId() != null) {
            object = pSSysAppBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSSystemName() != null) {
            object = pSSysAppBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSViewMsgGroupId() != null) {
            object = pSSysAppBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPSViewMsgGroupName() != null) {
            object = pSSysAppBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getPubRefViewOnly() != null) {
            object = pSSysAppBase.getPubRefViewOnly();
            xmlNode.setAttribute(FIELD_PUBREFVIEWONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getPubSysRefViewOnly() != null) {
            object = pSSysAppBase.getPubSysRefViewOnly();
            xmlNode.setAttribute(FIELD_PUBSYSREFVIEWONLY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getRemoveFlag() != null) {
            object = pSSysAppBase.getRemoveFlag();
            xmlNode.setAttribute(FIELD_REMOVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getServiceCodeName() != null) {
            object = pSSysAppBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getStartPageFile() != null) {
            object = pSSysAppBase.getStartPageFile();
            xmlNode.setAttribute(FIELD_STARTPAGEFILE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getSubCaption() != null) {
            object = pSSysAppBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getTitle() != null) {
            object = pSSysAppBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUACLogin() != null) {
            object = pSSysAppBase.getUACLogin();
            xmlNode.setAttribute(FIELD_UACLOGIN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAppBase.getUIStyle() != null) {
            object = pSSysAppBase.getUIStyle();
            xmlNode.setAttribute(FIELD_UISTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUpdateDate() != null) {
            object = pSSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAppBase.getUpdateMan() != null) {
            object = pSSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserCat() != null) {
            object = pSSysAppBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserParams() != null) {
            object = pSSysAppBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserTag() != null) {
            object = pSSysAppBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserTag2() != null) {
            object = pSSysAppBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserTag3() != null) {
            object = pSSysAppBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getUserTag4() != null) {
            object = pSSysAppBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAppBase.getValidFlag() != null) {
            object = pSSysAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAppBase pSSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAppBase.isACMinCharsDirty() && (bl || pSSysAppBase.getACMinChars() != null)) {
            iDataObject.set(FIELD_ACMINCHARS, (Object)pSSysAppBase.getACMinChars());
        }
        if (pSSysAppBase.isAppFolderDirty() && (bl || pSSysAppBase.getAppFolder() != null)) {
            iDataObject.set(FIELD_APPFOLDER, (Object)pSSysAppBase.getAppFolder());
        }
        if (pSSysAppBase.isAppModeDirty() && (bl || pSSysAppBase.getAppMode() != null)) {
            iDataObject.set(FIELD_APPMODE, (Object)pSSysAppBase.getAppMode());
        }
        if (pSSysAppBase.isAppPKGNameDirty() && (bl || pSSysAppBase.getAppPKGName() != null)) {
            iDataObject.set(FIELD_APPPKGNAME, (Object)pSSysAppBase.getAppPKGName());
        }
        if (pSSysAppBase.isAppSNDirty() && (bl || pSSysAppBase.getAppSN() != null)) {
            iDataObject.set(FIELD_APPSN, (Object)pSSysAppBase.getAppSN());
        }
        if (pSSysAppBase.isAppTagDirty() && (bl || pSSysAppBase.getAppTag() != null)) {
            iDataObject.set(FIELD_APPTAG, (Object)pSSysAppBase.getAppTag());
        }
        if (pSSysAppBase.isAppTag2Dirty() && (bl || pSSysAppBase.getAppTag2() != null)) {
            iDataObject.set(FIELD_APPTAG2, (Object)pSSysAppBase.getAppTag2());
        }
        if (pSSysAppBase.isAppTag3Dirty() && (bl || pSSysAppBase.getAppTag3() != null)) {
            iDataObject.set(FIELD_APPTAG3, (Object)pSSysAppBase.getAppTag3());
        }
        if (pSSysAppBase.isAppTag4Dirty() && (bl || pSSysAppBase.getAppTag4() != null)) {
            iDataObject.set(FIELD_APPTAG4, (Object)pSSysAppBase.getAppTag4());
        }
        if (pSSysAppBase.isAppVersionDirty() && (bl || pSSysAppBase.getAppVersion() != null)) {
            iDataObject.set(FIELD_APPVERSION, (Object)pSSysAppBase.getAppVersion());
        }
        if (pSSysAppBase.isAppViewPriorityDirty() && (bl || pSSysAppBase.getAppViewPriority() != null)) {
            iDataObject.set(FIELD_APPVIEWPRIORITY, (Object)pSSysAppBase.getAppViewPriority());
        }
        if (pSSysAppBase.isAutoAddAppViewDirty() && (bl || pSSysAppBase.getAutoAddAppView() != null)) {
            iDataObject.set(FIELD_AUTOADDAPPVIEW, (Object)pSSysAppBase.getAutoAddAppView());
        }
        if (pSSysAppBase.isBottomInfoDirty() && (bl || pSSysAppBase.getBottomInfo() != null)) {
            iDataObject.set(FIELD_BOTTOMINFO, (Object)pSSysAppBase.getBottomInfo());
        }
        if (pSSysAppBase.isBtnNoPrivDMDirty() && (bl || pSSysAppBase.getBtnNoPrivDM() != null)) {
            iDataObject.set(FIELD_BTNNOPRIVDM, (Object)pSSysAppBase.getBtnNoPrivDM());
        }
        if (pSSysAppBase.isCaptionDirty() && (bl || pSSysAppBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysAppBase.getCaption());
        }
        if (pSSysAppBase.isCodeFolderDirty() && (bl || pSSysAppBase.getCodeFolder() != null)) {
            iDataObject.set(FIELD_CODEFOLDER, (Object)pSSysAppBase.getCodeFolder());
        }
        if (pSSysAppBase.isCodeNameModeDirty() && (bl || pSSysAppBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSSysAppBase.getCodeNameMode());
        }
        if (pSSysAppBase.isCreateDateDirty() && (bl || pSSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAppBase.getCreateDate());
        }
        if (pSSysAppBase.isCreateManDirty() && (bl || pSSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAppBase.getCreateMan());
        }
        if (pSSysAppBase.isDefaultPortDirty() && (bl || pSSysAppBase.getDefaultPort() != null)) {
            iDataObject.set(FIELD_DEFAULTPORT, (Object)pSSysAppBase.getDefaultPort());
        }
        if (pSSysAppBase.isDefaultPubDirty() && (bl || pSSysAppBase.getDefaultPub() != null)) {
            iDataObject.set(FIELD_DEFAULTPUB, (Object)pSSysAppBase.getDefaultPub());
        }
        if (pSSysAppBase.isDEPSSysSFPluginIdDirty() && (bl || pSSysAppBase.getDEPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINID, (Object)pSSysAppBase.getDEPSSysSFPluginId());
        }
        if (pSSysAppBase.isDEPSSysSFPluginNameDirty() && (bl || pSSysAppBase.getDEPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_DEPSSYSSFPLUGINNAME, (Object)pSSysAppBase.getDEPSSysSFPluginName());
        }
        if (pSSysAppBase.isEnableC12ToC24Dirty() && (bl || pSSysAppBase.getEnableC12ToC24() != null)) {
            iDataObject.set(FIELD_ENABLEC12TOC24, (Object)pSSysAppBase.getEnableC12ToC24());
        }
        if (pSSysAppBase.isEnableDynaSysDirty() && (bl || pSSysAppBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSSysAppBase.getEnableDynaSys());
        }
        if (pSSysAppBase.isEnableStoryBoardDirty() && (bl || pSSysAppBase.getEnableStoryBoard() != null)) {
            iDataObject.set(FIELD_ENABLESTORYBOARD, (Object)pSSysAppBase.getEnableStoryBoard());
        }
        if (pSSysAppBase.isEnableUIModelExDirty() && (bl || pSSysAppBase.getEnableUIModelEx() != null)) {
            iDataObject.set(FIELD_ENABLEUIMODELEX, (Object)pSSysAppBase.getEnableUIModelEx());
        }
        if (pSSysAppBase.isEnaLocalServiceDirty() && (bl || pSSysAppBase.getEnaLocalService() != null)) {
            iDataObject.set(FIELD_ENALOCALSERVICE, (Object)pSSysAppBase.getEnaLocalService());
        }
        if (pSSysAppBase.isFIEmptyTextDirty() && (bl || pSSysAppBase.getFIEmptyText() != null)) {
            iDataObject.set(FIELD_FIEMPTYTEXT, (Object)pSSysAppBase.getFIEmptyText());
        }
        if (pSSysAppBase.isFINoPrivDMDirty() && (bl || pSSysAppBase.getFINoPrivDM() != null)) {
            iDataObject.set(FIELD_FINOPRIVDM, (Object)pSSysAppBase.getFINoPrivDM());
        }
        if (pSSysAppBase.isFIUpdatePrivTagDirty() && (bl || pSSysAppBase.getFIUpdatePrivTag() != null)) {
            iDataObject.set(FIELD_FIUPDATEPRIVTAG, (Object)pSSysAppBase.getFIUpdatePrivTag());
        }
        if (pSSysAppBase.isGCNoPrivDMDirty() && (bl || pSSysAppBase.getGCNoPrivDM() != null)) {
            iDataObject.set(FIELD_GCNOPRIVDM, (Object)pSSysAppBase.getGCNoPrivDM());
        }
        if (pSSysAppBase.isGridColEnableFilterDirty() && (bl || pSSysAppBase.getGridColEnableFilter() != null)) {
            iDataObject.set(FIELD_GRIDCOLENABLEFILTER, (Object)pSSysAppBase.getGridColEnableFilter());
        }
        if (pSSysAppBase.isGridColEnableLinkDirty() && (bl || pSSysAppBase.getGridColEnableLink() != null)) {
            iDataObject.set(FIELD_GRIDCOLENABLELINK, (Object)pSSysAppBase.getGridColEnableLink());
        }
        if (pSSysAppBase.isGridEnableCustomizedDirty() && (bl || pSSysAppBase.getGridEnableCustomized() != null)) {
            iDataObject.set(FIELD_GRIDENABLECUSTOMIZED, (Object)pSSysAppBase.getGridEnableCustomized());
        }
        if (pSSysAppBase.isGridForceFitDirty() && (bl || pSSysAppBase.getGridForceFit() != null)) {
            iDataObject.set(FIELD_GRIDFORCEFIT, (Object)pSSysAppBase.getGridForceFit());
        }
        if (pSSysAppBase.isGridRowActiveModeDirty() && (bl || pSSysAppBase.getGridRowActiveMode() != null)) {
            iDataObject.set(FIELD_GRIDROWACTIVEMODE, (Object)pSSysAppBase.getGridRowActiveMode());
        }
        if (pSSysAppBase.isHeaderInfoDirty() && (bl || pSSysAppBase.getHeaderInfo() != null)) {
            iDataObject.set(FIELD_HEADERINFO, (Object)pSSysAppBase.getHeaderInfo());
        }
        if (pSSysAppBase.isIconFileDirty() && (bl || pSSysAppBase.getIconFile() != null)) {
            iDataObject.set(FIELD_ICONFILE, (Object)pSSysAppBase.getIconFile());
        }
        if (pSSysAppBase.isLogicNameDirty() && (bl || pSSysAppBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysAppBase.getLogicName());
        }
        if (pSSysAppBase.isMainMenuSideDirty() && (bl || pSSysAppBase.getMainMenuSide() != null)) {
            iDataObject.set(FIELD_MAINMENUSIDE, (Object)pSSysAppBase.getMainMenuSide());
        }
        if (pSSysAppBase.isMDCtrlEmptyTextDirty() && (bl || pSSysAppBase.getMDCtrlEmptyText() != null)) {
            iDataObject.set(FIELD_MDCTRLEMPTYTEXT, (Object)pSSysAppBase.getMDCtrlEmptyText());
        }
        if (pSSysAppBase.isMDCtrlEmptyTextPSLanResIdDirty() && (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_MDCTRLEMPTYTEXTPSLANRESID, (Object)pSSysAppBase.getMDCtrlEmptyTextPSLanResId());
        }
        if (pSSysAppBase.isMDCtrlEmptyTextPSLanResNameDirty() && (bl || pSSysAppBase.getMDCtrlEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME, (Object)pSSysAppBase.getMDCtrlEmptyTextPSLanResName());
        }
        if (pSSysAppBase.isMemoDirty() && (bl || pSSysAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAppBase.getMemo());
        }
        if (pSSysAppBase.isOrderValueDirty() && (bl || pSSysAppBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysAppBase.getOrderValue());
        }
        if (pSSysAppBase.isOrientationModeDirty() && (bl || pSSysAppBase.getOrientationMode() != null)) {
            iDataObject.set(FIELD_ORIENTATIONMODE, (Object)pSSysAppBase.getOrientationMode());
        }
        if (pSSysAppBase.isPFStyleParamDirty() && (bl || pSSysAppBase.getPFStyleParam() != null)) {
            iDataObject.set(FIELD_PFSTYLEPARAM, (Object)pSSysAppBase.getPFStyleParam());
        }
        if (pSSysAppBase.isPreventXSSDirty() && (bl || pSSysAppBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSSysAppBase.getPreventXSS());
        }
        if (pSSysAppBase.isPSAppEditorTemplsCntDirty() && (bl || pSSysAppBase.getPSAppEditorTemplsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPEDITORTEMPLSCNT, (Object)pSSysAppBase.getPSAppEditorTemplsCnt());
        }
        if (pSSysAppBase.isPSAppFuncsCntDirty() && (bl || pSSysAppBase.getPSAppFuncsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCSCNT, (Object)pSSysAppBase.getPSAppFuncsCnt());
        }
        if (pSSysAppBase.isPSAppMenusCntDirty() && (bl || pSSysAppBase.getPSAppMenusCnt() != null)) {
            iDataObject.set(FIELD_PSAPPMENUSCNT, (Object)pSSysAppBase.getPSAppMenusCnt());
        }
        if (pSSysAppBase.isPSAppModulesCntDirty() && (bl || pSSysAppBase.getPSAppModulesCnt() != null)) {
            iDataObject.set(FIELD_PSAPPMODULESCNT, (Object)pSSysAppBase.getPSAppModulesCnt());
        }
        if (pSSysAppBase.isPSAppPkgsCntDirty() && (bl || pSSysAppBase.getPSAppPkgsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPPKGSCNT, (Object)pSSysAppBase.getPSAppPkgsCnt());
        }
        if (pSSysAppBase.isPSAppTitleBarsCntDirty() && (bl || pSSysAppBase.getPSAppTitleBarsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPTITLEBARSCNT, (Object)pSSysAppBase.getPSAppTitleBarsCnt());
        }
        if (pSSysAppBase.isPSAppTypeIdDirty() && (bl || pSSysAppBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSSysAppBase.getPSAppTypeId());
        }
        if (pSSysAppBase.isPSAppTypeNameDirty() && (bl || pSSysAppBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSSysAppBase.getPSAppTypeName());
        }
        if (pSSysAppBase.isPSAppUIThemesCntDirty() && (bl || pSSysAppBase.getPSAppUIThemesCnt() != null)) {
            iDataObject.set(FIELD_PSAPPUITHEMESCNT, (Object)pSSysAppBase.getPSAppUIThemesCnt());
        }
        if (pSSysAppBase.isPSAppUserModesCntDirty() && (bl || pSSysAppBase.getPSAppUserModesCnt() != null)) {
            iDataObject.set(FIELD_PSAPPUSERMODESCNT, (Object)pSSysAppBase.getPSAppUserModesCnt());
        }
        if (pSSysAppBase.isPSAppUtilPagesCntDirty() && (bl || pSSysAppBase.getPSAppUtilPagesCnt() != null)) {
            iDataObject.set(FIELD_PSAPPUTILPAGESCNT, (Object)pSSysAppBase.getPSAppUtilPagesCnt());
        }
        if (pSSysAppBase.isPSAppViewCodesCntDirty() && (bl || pSSysAppBase.getPSAppViewCodesCnt() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWCODESCNT, (Object)pSSysAppBase.getPSAppViewCodesCnt());
        }
        if (pSSysAppBase.isPSAppViewsCntDirty() && (bl || pSSysAppBase.getPSAppViewsCnt() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSCNT, (Object)pSSysAppBase.getPSAppViewsCnt());
        }
        if (pSSysAppBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysAppBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysAppBase.getPSCtrlLogicGroupId());
        }
        if (pSSysAppBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysAppBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysAppBase.getPSCtrlLogicGroupName());
        }
        if (pSSysAppBase.isPSDevSlnSysAppIdDirty() && (bl || pSSysAppBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSSysAppBase.getPSDevSlnSysAppId());
        }
        if (pSSysAppBase.isPSModuleIdDirty() && (bl || pSSysAppBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysAppBase.getPSModuleId());
        }
        if (pSSysAppBase.isPSModuleNameDirty() && (bl || pSSysAppBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysAppBase.getPSModuleName());
        }
        if (pSSysAppBase.isPSPFCDNIdDirty() && (bl || pSSysAppBase.getPSPFCDNId() != null)) {
            iDataObject.set(FIELD_PSPFCDNID, (Object)pSSysAppBase.getPSPFCDNId());
        }
        if (pSSysAppBase.isPSPFCDNNameDirty() && (bl || pSSysAppBase.getPSPFCDNName() != null)) {
            iDataObject.set(FIELD_PSPFCDNNAME, (Object)pSSysAppBase.getPSPFCDNName());
        }
        if (pSSysAppBase.isPSPFIdDirty() && (bl || pSSysAppBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSSysAppBase.getPSPFId());
        }
        if (pSSysAppBase.isPSPFNameDirty() && (bl || pSSysAppBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSSysAppBase.getPSPFName());
        }
        if (pSSysAppBase.isPSPFStyleIdDirty() && (bl || pSSysAppBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSSysAppBase.getPSPFStyleId());
        }
        if (pSSysAppBase.isPSPFStyleNameDirty() && (bl || pSSysAppBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSSysAppBase.getPSPFStyleName());
        }
        if (pSSysAppBase.isPSStudioThemeIdDirty() && (bl || pSSysAppBase.getPSStudioThemeId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMEID, (Object)pSSysAppBase.getPSStudioThemeId());
        }
        if (pSSysAppBase.isPSStudioThemeNameDirty() && (bl || pSSysAppBase.getPSStudioThemeName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOTHEMENAME, (Object)pSSysAppBase.getPSStudioThemeName());
        }
        if (pSSysAppBase.isPSSysAppIdDirty() && (bl || pSSysAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysAppBase.getPSSysAppId());
        }
        if (pSSysAppBase.isPSSysAppNameDirty() && (bl || pSSysAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysAppBase.getPSSysAppName());
        }
        if (pSSysAppBase.isPSSysCssIdDirty() && (bl || pSSysAppBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysAppBase.getPSSysCssId());
        }
        if (pSSysAppBase.isPSSysCssNameDirty() && (bl || pSSysAppBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysAppBase.getPSSysCssName());
        }
        if (pSSysAppBase.isPSSysDynaModelIdDirty() && (bl || pSSysAppBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysAppBase.getPSSysDynaModelId());
        }
        if (pSSysAppBase.isPSSysDynaModelNameDirty() && (bl || pSSysAppBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysAppBase.getPSSysDynaModelName());
        }
        if (pSSysAppBase.isPSSysImageIdDirty() && (bl || pSSysAppBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysAppBase.getPSSysImageId());
        }
        if (pSSysAppBase.isPSSysImageNameDirty() && (bl || pSSysAppBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysAppBase.getPSSysImageName());
        }
        if (pSSysAppBase.isPSSysReqItemIdDirty() && (bl || pSSysAppBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysAppBase.getPSSysReqItemId());
        }
        if (pSSysAppBase.isPSSysReqItemNameDirty() && (bl || pSSysAppBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysAppBase.getPSSysReqItemName());
        }
        if (pSSysAppBase.isPSSysResourceIdDirty() && (bl || pSSysAppBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysAppBase.getPSSysResourceId());
        }
        if (pSSysAppBase.isPSSysResourceNameDirty() && (bl || pSSysAppBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysAppBase.getPSSysResourceName());
        }
        if (pSSysAppBase.isPSSysServiceAPIIdDirty() && (bl || pSSysAppBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysAppBase.getPSSysServiceAPIId());
        }
        if (pSSysAppBase.isPSSysServiceAPINameDirty() && (bl || pSSysAppBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysAppBase.getPSSysServiceAPIName());
        }
        if (pSSysAppBase.isPSSysSFPluginIdDirty() && (bl || pSSysAppBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysAppBase.getPSSysSFPluginId());
        }
        if (pSSysAppBase.isPSSysSFPluginNameDirty() && (bl || pSSysAppBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysAppBase.getPSSysSFPluginName());
        }
        if (pSSysAppBase.isPSSysSFPubIdDirty() && (bl || pSSysAppBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysAppBase.getPSSysSFPubId());
        }
        if (pSSysAppBase.isPSSysSFPubNameDirty() && (bl || pSSysAppBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysAppBase.getPSSysSFPubName());
        }
        if (pSSysAppBase.isPSSysTasksCntDirty() && (bl || pSSysAppBase.getPSSysTasksCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTASKSCNT, (Object)pSSysAppBase.getPSSysTasksCnt());
        }
        if (pSSysAppBase.isPSSystemIdDirty() && (bl || pSSysAppBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysAppBase.getPSSystemId());
        }
        if (pSSysAppBase.isPSSystemNameDirty() && (bl || pSSysAppBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysAppBase.getPSSystemName());
        }
        if (pSSysAppBase.isPSViewMsgGroupIdDirty() && (bl || pSSysAppBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysAppBase.getPSViewMsgGroupId());
        }
        if (pSSysAppBase.isPSViewMsgGroupNameDirty() && (bl || pSSysAppBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysAppBase.getPSViewMsgGroupName());
        }
        if (pSSysAppBase.isPubRefViewOnlyDirty() && (bl || pSSysAppBase.getPubRefViewOnly() != null)) {
            iDataObject.set(FIELD_PUBREFVIEWONLY, (Object)pSSysAppBase.getPubRefViewOnly());
        }
        if (pSSysAppBase.isPubSysRefViewOnlyDirty() && (bl || pSSysAppBase.getPubSysRefViewOnly() != null)) {
            iDataObject.set(FIELD_PUBSYSREFVIEWONLY, (Object)pSSysAppBase.getPubSysRefViewOnly());
        }
        if (pSSysAppBase.isRemoveFlagDirty() && (bl || pSSysAppBase.getRemoveFlag() != null)) {
            iDataObject.set(FIELD_REMOVEFLAG, (Object)pSSysAppBase.getRemoveFlag());
        }
        if (pSSysAppBase.isServiceCodeNameDirty() && (bl || pSSysAppBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysAppBase.getServiceCodeName());
        }
        if (pSSysAppBase.isStartPageFileDirty() && (bl || pSSysAppBase.getStartPageFile() != null)) {
            iDataObject.set(FIELD_STARTPAGEFILE, (Object)pSSysAppBase.getStartPageFile());
        }
        if (pSSysAppBase.isSubCaptionDirty() && (bl || pSSysAppBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSSysAppBase.getSubCaption());
        }
        if (pSSysAppBase.isTitleDirty() && (bl || pSSysAppBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSSysAppBase.getTitle());
        }
        if (pSSysAppBase.isUACLoginDirty() && (bl || pSSysAppBase.getUACLogin() != null)) {
            iDataObject.set(FIELD_UACLOGIN, (Object)pSSysAppBase.getUACLogin());
        }
        if (pSSysAppBase.isUIStyleDirty() && (bl || pSSysAppBase.getUIStyle() != null)) {
            iDataObject.set(FIELD_UISTYLE, (Object)pSSysAppBase.getUIStyle());
        }
        if (pSSysAppBase.isUpdateDateDirty() && (bl || pSSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAppBase.getUpdateDate());
        }
        if (pSSysAppBase.isUpdateManDirty() && (bl || pSSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAppBase.getUpdateMan());
        }
        if (pSSysAppBase.isUserCatDirty() && (bl || pSSysAppBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAppBase.getUserCat());
        }
        if (pSSysAppBase.isUserParamsDirty() && (bl || pSSysAppBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysAppBase.getUserParams());
        }
        if (pSSysAppBase.isUserTagDirty() && (bl || pSSysAppBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAppBase.getUserTag());
        }
        if (pSSysAppBase.isUserTag2Dirty() && (bl || pSSysAppBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAppBase.getUserTag2());
        }
        if (pSSysAppBase.isUserTag3Dirty() && (bl || pSSysAppBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAppBase.getUserTag3());
        }
        if (pSSysAppBase.isUserTag4Dirty() && (bl || pSSysAppBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAppBase.getUserTag4());
        }
        if (pSSysAppBase.isValidFlagDirty() && (bl || pSSysAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAppBase.getValidFlag());
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
        return PSSysAppBase.remove(this, n);
    }

    private static boolean remove(PSSysAppBase pSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAppBase.resetACMinChars();
                return true;
            }
            case 1: {
                pSSysAppBase.resetAppFolder();
                return true;
            }
            case 2: {
                pSSysAppBase.resetAppMode();
                return true;
            }
            case 3: {
                pSSysAppBase.resetAppPKGName();
                return true;
            }
            case 4: {
                pSSysAppBase.resetAppSN();
                return true;
            }
            case 5: {
                pSSysAppBase.resetAppTag();
                return true;
            }
            case 6: {
                pSSysAppBase.resetAppTag2();
                return true;
            }
            case 7: {
                pSSysAppBase.resetAppTag3();
                return true;
            }
            case 8: {
                pSSysAppBase.resetAppTag4();
                return true;
            }
            case 9: {
                pSSysAppBase.resetAppVersion();
                return true;
            }
            case 10: {
                pSSysAppBase.resetAppViewPriority();
                return true;
            }
            case 11: {
                pSSysAppBase.resetAutoAddAppView();
                return true;
            }
            case 12: {
                pSSysAppBase.resetBottomInfo();
                return true;
            }
            case 13: {
                pSSysAppBase.resetBtnNoPrivDM();
                return true;
            }
            case 14: {
                pSSysAppBase.resetCaption();
                return true;
            }
            case 15: {
                pSSysAppBase.resetCodeFolder();
                return true;
            }
            case 16: {
                pSSysAppBase.resetCodeNameMode();
                return true;
            }
            case 17: {
                pSSysAppBase.resetCreateDate();
                return true;
            }
            case 18: {
                pSSysAppBase.resetCreateMan();
                return true;
            }
            case 19: {
                pSSysAppBase.resetDefaultPort();
                return true;
            }
            case 20: {
                pSSysAppBase.resetDefaultPub();
                return true;
            }
            case 21: {
                pSSysAppBase.resetDEPSSysSFPluginId();
                return true;
            }
            case 22: {
                pSSysAppBase.resetDEPSSysSFPluginName();
                return true;
            }
            case 23: {
                pSSysAppBase.resetEnableC12ToC24();
                return true;
            }
            case 24: {
                pSSysAppBase.resetEnableDynaSys();
                return true;
            }
            case 25: {
                pSSysAppBase.resetEnableStoryBoard();
                return true;
            }
            case 26: {
                pSSysAppBase.resetEnableUIModelEx();
                return true;
            }
            case 27: {
                pSSysAppBase.resetEnaLocalService();
                return true;
            }
            case 28: {
                pSSysAppBase.resetFIEmptyText();
                return true;
            }
            case 29: {
                pSSysAppBase.resetFINoPrivDM();
                return true;
            }
            case 30: {
                pSSysAppBase.resetFIUpdatePrivTag();
                return true;
            }
            case 31: {
                pSSysAppBase.resetGCNoPrivDM();
                return true;
            }
            case 32: {
                pSSysAppBase.resetGridColEnableFilter();
                return true;
            }
            case 33: {
                pSSysAppBase.resetGridColEnableLink();
                return true;
            }
            case 34: {
                pSSysAppBase.resetGridEnableCustomized();
                return true;
            }
            case 35: {
                pSSysAppBase.resetGridForceFit();
                return true;
            }
            case 36: {
                pSSysAppBase.resetGridRowActiveMode();
                return true;
            }
            case 37: {
                pSSysAppBase.resetHeaderInfo();
                return true;
            }
            case 38: {
                pSSysAppBase.resetIconFile();
                return true;
            }
            case 39: {
                pSSysAppBase.resetLogicName();
                return true;
            }
            case 40: {
                pSSysAppBase.resetMainMenuSide();
                return true;
            }
            case 41: {
                pSSysAppBase.resetMDCtrlEmptyText();
                return true;
            }
            case 42: {
                pSSysAppBase.resetMDCtrlEmptyTextPSLanResId();
                return true;
            }
            case 43: {
                pSSysAppBase.resetMDCtrlEmptyTextPSLanResName();
                return true;
            }
            case 44: {
                pSSysAppBase.resetMemo();
                return true;
            }
            case 45: {
                pSSysAppBase.resetOrderValue();
                return true;
            }
            case 46: {
                pSSysAppBase.resetOrientationMode();
                return true;
            }
            case 47: {
                pSSysAppBase.resetPFStyleParam();
                return true;
            }
            case 48: {
                pSSysAppBase.resetPreventXSS();
                return true;
            }
            case 49: {
                pSSysAppBase.resetPSAppEditorTemplsCnt();
                return true;
            }
            case 50: {
                pSSysAppBase.resetPSAppFuncsCnt();
                return true;
            }
            case 51: {
                pSSysAppBase.resetPSAppMenusCnt();
                return true;
            }
            case 52: {
                pSSysAppBase.resetPSAppModulesCnt();
                return true;
            }
            case 53: {
                pSSysAppBase.resetPSAppPkgsCnt();
                return true;
            }
            case 54: {
                pSSysAppBase.resetPSAppTitleBarsCnt();
                return true;
            }
            case 55: {
                pSSysAppBase.resetPSAppTypeId();
                return true;
            }
            case 56: {
                pSSysAppBase.resetPSAppTypeName();
                return true;
            }
            case 57: {
                pSSysAppBase.resetPSAppUIThemesCnt();
                return true;
            }
            case 58: {
                pSSysAppBase.resetPSAppUserModesCnt();
                return true;
            }
            case 59: {
                pSSysAppBase.resetPSAppUtilPagesCnt();
                return true;
            }
            case 60: {
                pSSysAppBase.resetPSAppViewCodesCnt();
                return true;
            }
            case 61: {
                pSSysAppBase.resetPSAppViewsCnt();
                return true;
            }
            case 62: {
                pSSysAppBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 63: {
                pSSysAppBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 64: {
                pSSysAppBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 65: {
                pSSysAppBase.resetPSModuleId();
                return true;
            }
            case 66: {
                pSSysAppBase.resetPSModuleName();
                return true;
            }
            case 67: {
                pSSysAppBase.resetPSPFCDNId();
                return true;
            }
            case 68: {
                pSSysAppBase.resetPSPFCDNName();
                return true;
            }
            case 69: {
                pSSysAppBase.resetPSPFId();
                return true;
            }
            case 70: {
                pSSysAppBase.resetPSPFName();
                return true;
            }
            case 71: {
                pSSysAppBase.resetPSPFStyleId();
                return true;
            }
            case 72: {
                pSSysAppBase.resetPSPFStyleName();
                return true;
            }
            case 73: {
                pSSysAppBase.resetPSStudioThemeId();
                return true;
            }
            case 74: {
                pSSysAppBase.resetPSStudioThemeName();
                return true;
            }
            case 75: {
                pSSysAppBase.resetPSSysAppId();
                return true;
            }
            case 76: {
                pSSysAppBase.resetPSSysAppName();
                return true;
            }
            case 77: {
                pSSysAppBase.resetPSSysCssId();
                return true;
            }
            case 78: {
                pSSysAppBase.resetPSSysCssName();
                return true;
            }
            case 79: {
                pSSysAppBase.resetPSSysDynaModelId();
                return true;
            }
            case 80: {
                pSSysAppBase.resetPSSysDynaModelName();
                return true;
            }
            case 81: {
                pSSysAppBase.resetPSSysImageId();
                return true;
            }
            case 82: {
                pSSysAppBase.resetPSSysImageName();
                return true;
            }
            case 83: {
                pSSysAppBase.resetPSSysReqItemId();
                return true;
            }
            case 84: {
                pSSysAppBase.resetPSSysReqItemName();
                return true;
            }
            case 85: {
                pSSysAppBase.resetPSSysResourceId();
                return true;
            }
            case 86: {
                pSSysAppBase.resetPSSysResourceName();
                return true;
            }
            case 87: {
                pSSysAppBase.resetPSSysServiceAPIId();
                return true;
            }
            case 88: {
                pSSysAppBase.resetPSSysServiceAPIName();
                return true;
            }
            case 89: {
                pSSysAppBase.resetPSSysSFPluginId();
                return true;
            }
            case 90: {
                pSSysAppBase.resetPSSysSFPluginName();
                return true;
            }
            case 91: {
                pSSysAppBase.resetPSSysSFPubId();
                return true;
            }
            case 92: {
                pSSysAppBase.resetPSSysSFPubName();
                return true;
            }
            case 93: {
                pSSysAppBase.resetPSSysTasksCnt();
                return true;
            }
            case 94: {
                pSSysAppBase.resetPSSystemId();
                return true;
            }
            case 95: {
                pSSysAppBase.resetPSSystemName();
                return true;
            }
            case 96: {
                pSSysAppBase.resetPSViewMsgGroupId();
                return true;
            }
            case 97: {
                pSSysAppBase.resetPSViewMsgGroupName();
                return true;
            }
            case 98: {
                pSSysAppBase.resetPubRefViewOnly();
                return true;
            }
            case 99: {
                pSSysAppBase.resetPubSysRefViewOnly();
                return true;
            }
            case 100: {
                pSSysAppBase.resetRemoveFlag();
                return true;
            }
            case 101: {
                pSSysAppBase.resetServiceCodeName();
                return true;
            }
            case 102: {
                pSSysAppBase.resetStartPageFile();
                return true;
            }
            case 103: {
                pSSysAppBase.resetSubCaption();
                return true;
            }
            case 104: {
                pSSysAppBase.resetTitle();
                return true;
            }
            case 105: {
                pSSysAppBase.resetUACLogin();
                return true;
            }
            case 106: {
                pSSysAppBase.resetUIStyle();
                return true;
            }
            case 107: {
                pSSysAppBase.resetUpdateDate();
                return true;
            }
            case 108: {
                pSSysAppBase.resetUpdateMan();
                return true;
            }
            case 109: {
                pSSysAppBase.resetUserCat();
                return true;
            }
            case 110: {
                pSSysAppBase.resetUserParams();
                return true;
            }
            case 111: {
                pSSysAppBase.resetUserTag();
                return true;
            }
            case 112: {
                pSSysAppBase.resetUserTag2();
                return true;
            }
            case 113: {
                pSSysAppBase.resetUserTag3();
                return true;
            }
            case 114: {
                pSSysAppBase.resetUserTag4();
                return true;
            }
            case 115: {
                pSSysAppBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppType getPSAppType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppType();
        }
        if (this.getPSAppTypeId() == null) {
            return null;
        }
        Integer n = this.objPSAppTypeLock;
        synchronized (n) {
            if (this.psapptype != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTypeId(), (Object)this.psapptype.getPSAppTypeId()) != 0L) {
                this.psapptype = null;
            }
            if (this.psapptype == null) {
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(this.getPSAppTypeId());
                PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
                pSAppTypeService.autoGet(pSAppType);
                this.psapptype = pSAppType;
            }
            return this.psapptype;
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
    public PSLanguageRes getMDCtrlEmptyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlEmptyTextPSLanRes();
        }
        if (this.getMDCtrlEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objMDCtrlEmptyTextPSLanResLock;
        synchronized (n) {
            if (this.mdctrlemptytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getMDCtrlEmptyTextPSLanResId(), (Object)this.mdctrlemptytextpslanres.getPSLanguageResId()) != 0L) {
                this.mdctrlemptytextpslanres = null;
            }
            if (this.mdctrlemptytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getMDCtrlEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.mdctrlemptytextpslanres = pSLanguageRes;
            }
            return this.mdctrlemptytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFCDN getPSPFCDN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDN();
        }
        if (this.getPSPFCDNId() == null) {
            return null;
        }
        Integer n = this.objPSPFCDNLock;
        synchronized (n) {
            if (this.pspfcdn != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFCDNId(), (Object)this.pspfcdn.getPSPFCDNId()) != 0L) {
                this.pspfcdn = null;
            }
            if (this.pspfcdn == null) {
                PSPFCDN pSPFCDN = new PSPFCDN();
                pSPFCDN.setPSPFCDNId(this.getPSPFCDNId());
                PSPFCDNService pSPFCDNService = (PSPFCDNService)ServiceGlobal.getService(PSPFCDNService.class, (SessionFactory)this.getSessionFactory());
                pSPFCDNService.autoGet(pSPFCDN);
                this.pspfcdn = pSPFCDN;
            }
            return this.pspfcdn;
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
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSStudioTheme getPSStudioTheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioTheme();
        }
        if (this.getPSStudioThemeId() == null) {
            return null;
        }
        Integer n = this.objPSStudioThemeLock;
        synchronized (n) {
            if (this.psstudiotheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSStudioThemeId(), (Object)this.psstudiotheme.getPSStudioThemeId()) != 0L) {
                this.psstudiotheme = null;
            }
            if (this.psstudiotheme == null) {
                PSStudioTheme pSStudioTheme = new PSStudioTheme();
                pSStudioTheme.setPSStudioThemeId(this.getPSStudioThemeId());
                PSStudioThemeService pSStudioThemeService = (PSStudioThemeService)ServiceGlobal.getService(PSStudioThemeService.class, (SessionFactory)this.getSessionFactory());
                pSStudioThemeService.autoGet(pSStudioTheme);
                this.psstudiotheme = pSStudioTheme;
            }
            return this.psstudiotheme;
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
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet(pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getDEPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPSSysSFPlugin();
        }
        if (this.getDEPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objDEPSSysSFPluginLock;
        synchronized (n) {
            if (this.depssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getDEPSSysSFPluginId(), (Object)this.depssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.depssyssfplugin = null;
            }
            if (this.depssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getDEPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.depssyssfplugin = pSSysSFPlugin;
            }
            return this.depssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPub();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPubLock;
        synchronized (n) {
            if (this.pssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPubId(), (Object)this.pssyssfpub.getPSSysSFPubId()) != 0L) {
                this.pssyssfpub = null;
            }
            if (this.pssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet(pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
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
    public ArrayList<PSAppDERS> getPSAppDERSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSs();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppDERSService pSAppDERSService = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppDERSsLock;
        synchronized (n) {
            if (this.psappderss == null) {
                this.psappderss = pSAppDERSService.selectByPSSysApp(this);
            }
            return this.psappderss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppDEViewRef> getPSAppDEViewRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewRefs();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppDEViewRefService pSAppDEViewRefService = (PSAppDEViewRefService)ServiceGlobal.getService(PSAppDEViewRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppDEViewRefsLock;
        synchronized (n) {
            if (this.psappdeviewrefs == null) {
                this.psappdeviewrefs = pSAppDEViewRefService.selectByPSSysApp(this);
            }
            return this.psappdeviewrefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppEditorTempl> getPSAppEditorTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppEditorTempls();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppEditorTemplService pSAppEditorTemplService = (PSAppEditorTemplService)ServiceGlobal.getService(PSAppEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppEditorTemplsLock;
        synchronized (n) {
            if (this.psappeditortempls == null) {
                this.psappeditortempls = pSAppEditorTemplService.selectByPSSysApp(this);
            }
            return this.psappeditortempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppFunc> getPSAppFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncs();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppFuncsLock;
        synchronized (n) {
            if (this.psappfuncs == null) {
                this.psappfuncs = pSAppFuncService.selectByPSSysApp(this);
            }
            return this.psappfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppLan> getPSAppLans() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLans();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppLanService pSAppLanService = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppLansLock;
        synchronized (n) {
            if (this.psapplans == null) {
                this.psapplans = pSAppLanService.selectByPSSysApp(this);
            }
            return this.psapplans;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppLocalDE> getPSAppLocalDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEs();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppLocalDEsLock;
        synchronized (n) {
            if (this.psapplocaldes == null) {
                this.psapplocaldes = pSAppLocalDEService.selectByPSSysApp(this);
            }
            return this.psapplocaldes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppLogic> getPSAppLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLogics();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppLogicService pSAppLogicService = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppLogicsLock;
        synchronized (n) {
            if (this.psapplogics == null) {
                this.psapplogics = pSAppLogicService.selectByPSSysApp(this);
            }
            return this.psapplogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppMenu> getPSAppMenus() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenus();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppMenusLock;
        synchronized (n) {
            if (this.psappmenus == null) {
                this.psappmenus = pSAppMenuService.selectByPSSysApp(this);
            }
            return this.psappmenus;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppModule> getPSAppModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModules();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppModulesLock;
        synchronized (n) {
            if (this.psappmodules == null) {
                this.psappmodules = pSAppModuleService.selectByPSSysApp(this);
            }
            return this.psappmodules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppPDTView> getPSAppPDTViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPDTViews();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppPDTViewService pSAppPDTViewService = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppPDTViewsLock;
        synchronized (n) {
            if (this.psapppdtviews == null) {
                this.psapppdtviews = pSAppPDTViewService.selectByPSSysApp(this);
            }
            return this.psapppdtviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppPFPlugin> getPSAppPFPlugins() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPFPlugins();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppPFPluginService pSAppPFPluginService = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppPFPluginsLock;
        synchronized (n) {
            if (this.psapppfplugins == null) {
                this.psapppfplugins = pSAppPFPluginService.selectByPSSysApp(this);
            }
            return this.psapppfplugins;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppPortlet> getPSAppPortlets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortlets();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppPortletService pSAppPortletService = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppPortletsLock;
        synchronized (n) {
            if (this.psappportlets == null) {
                this.psappportlets = pSAppPortletService.selectByPSSysApp(this);
            }
            return this.psappportlets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppResource> getPSAppResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppResources();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppResourceService pSAppResourceService = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppResourcesLock;
        synchronized (n) {
            if (this.psappresources == null) {
                this.psappresources = pSAppResourceService.selectByPSSysApp(this);
            }
            return this.psappresources;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppStoryBoard> getPSAppStoryBoards() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppStoryBoards();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppStoryBoardsLock;
        synchronized (n) {
            if (this.psappstoryboards == null) {
                this.psappstoryboards = pSAppStoryBoardService.selectByPSSysApp(this);
            }
            return this.psappstoryboards;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppTitleBar> getPSAppTitleBars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTitleBars();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppTitleBarService pSAppTitleBarService = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppTitleBarsLock;
        synchronized (n) {
            if (this.psapptitlebars == null) {
                this.psapptitlebars = pSAppTitleBarService.selectByPSSysApp(this);
            }
            return this.psapptitlebars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppUIStyle> getPSAppUIStyles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIStyles();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppUIStyleService pSAppUIStyleService = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppUIStylesLock;
        synchronized (n) {
            if (this.psappuistyles == null) {
                this.psappuistyles = pSAppUIStyleService.selectByPSSysApp(this);
            }
            return this.psappuistyles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppUITheme> getPSAppUIThemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUIThemes();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppUIThemeService pSAppUIThemeService = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppUIThemesLock;
        synchronized (n) {
            if (this.psappuithemes == null) {
                this.psappuithemes = pSAppUIThemeService.selectByPSSysApp(this);
            }
            return this.psappuithemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppUserMode> getPSAppUserModes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUserModes();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppUserModeService pSAppUserModeService = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppUserModesLock;
        synchronized (n) {
            if (this.psappusermodes == null) {
                this.psappusermodes = pSAppUserModeService.selectByPSSysApp(this);
            }
            return this.psappusermodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppUtilPage> getPSAppUtilPages() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilPages();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppUtilPageService pSAppUtilPageService = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppUtilPagesLock;
        synchronized (n) {
            if (this.psapputilpages == null) {
                this.psapputilpages = pSAppUtilPageService.selectByPSSysApp(this);
            }
            return this.psapputilpages;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppUtil> getPSAppUtils() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtils();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppUtilService pSAppUtilService = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppUtilsLock;
        synchronized (n) {
            if (this.psapputils == null) {
                this.psapputils = pSAppUtilService.selectByPSSysApp(this);
            }
            return this.psapputils;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppViewCode> getPSAppViewCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewCodes();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppViewCodeService pSAppViewCodeService = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppViewCodesLock;
        synchronized (n) {
            if (this.psappviewcodes == null) {
                this.psappviewcodes = pSAppViewCodeService.selectByPSSysApp(this);
            }
            return this.psappviewcodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppView> getPSAppViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViews();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppViewsLock;
        synchronized (n) {
            if (this.psappviews == null) {
                this.psappviews = pSAppViewService.selectByPSSysApp(this);
            }
            return this.psappviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSAppWF> getPSAppWFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppWFs();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSAppWFsLock;
        synchronized (n) {
            if (this.psappwfs == null) {
                this.psappwfs = pSAppWFService.selectByPSSysApp(this);
            }
            return this.psappwfs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSMobAppStartPage> getPSMobAppStartPages() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppStartPages();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSMobAppStartPageService pSMobAppStartPageService = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSMobAppStartPagesLock;
        synchronized (n) {
            if (this.psmobappstartpages == null) {
                this.psmobappstartpages = pSMobAppStartPageService.selectByPSSysApp(this);
            }
            return this.psmobappstartpages;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysProject> getPSSysProjects() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProjects();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysProjectsLock;
        synchronized (n) {
            if (this.pssysprojects == null) {
                this.pssysprojects = pSSysProjectService.selectByPSSysApp(this);
            }
            return this.pssysprojects;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTask> getPSSysTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasks();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTasksLock;
        synchronized (n) {
            if (this.pssystasks == null) {
                this.pssystasks = pSSysTaskService.selectByPSSysApp(this);
            }
            return this.pssystasks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUCMap> getPSSysUCMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMaps();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        PSSysUCMapService pSSysUCMapService = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUCMapsLock;
        synchronized (n) {
            if (this.pssysucmaps == null) {
                this.pssysucmaps = pSSysUCMapService.selectByPSSysApp(this);
            }
            return this.pssysucmaps;
        }
    }

    private PSSysAppBase getProxyEntity() {
        return this.proxyPSSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAppBase) {
            this.proxyPSSysAppBase = (PSSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACMINCHARS, 0);
        fieldIndexMap.put(FIELD_APPFOLDER, 1);
        fieldIndexMap.put(FIELD_APPMODE, 2);
        fieldIndexMap.put(FIELD_APPPKGNAME, 3);
        fieldIndexMap.put(FIELD_APPSN, 4);
        fieldIndexMap.put(FIELD_APPTAG, 5);
        fieldIndexMap.put(FIELD_APPTAG2, 6);
        fieldIndexMap.put(FIELD_APPTAG3, 7);
        fieldIndexMap.put(FIELD_APPTAG4, 8);
        fieldIndexMap.put(FIELD_APPVERSION, 9);
        fieldIndexMap.put(FIELD_APPVIEWPRIORITY, 10);
        fieldIndexMap.put(FIELD_AUTOADDAPPVIEW, 11);
        fieldIndexMap.put(FIELD_BOTTOMINFO, 12);
        fieldIndexMap.put(FIELD_BTNNOPRIVDM, 13);
        fieldIndexMap.put(FIELD_CAPTION, 14);
        fieldIndexMap.put(FIELD_CODEFOLDER, 15);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 16);
        fieldIndexMap.put(FIELD_CREATEDATE, 17);
        fieldIndexMap.put(FIELD_CREATEMAN, 18);
        fieldIndexMap.put(FIELD_DEFAULTPORT, 19);
        fieldIndexMap.put(FIELD_DEFAULTPUB, 20);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINID, 21);
        fieldIndexMap.put(FIELD_DEPSSYSSFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_ENABLEC12TOC24, 23);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 24);
        fieldIndexMap.put(FIELD_ENABLESTORYBOARD, 25);
        fieldIndexMap.put(FIELD_ENABLEUIMODELEX, 26);
        fieldIndexMap.put(FIELD_ENALOCALSERVICE, 27);
        fieldIndexMap.put(FIELD_FIEMPTYTEXT, 28);
        fieldIndexMap.put(FIELD_FINOPRIVDM, 29);
        fieldIndexMap.put(FIELD_FIUPDATEPRIVTAG, 30);
        fieldIndexMap.put(FIELD_GCNOPRIVDM, 31);
        fieldIndexMap.put(FIELD_GRIDCOLENABLEFILTER, 32);
        fieldIndexMap.put(FIELD_GRIDCOLENABLELINK, 33);
        fieldIndexMap.put(FIELD_GRIDENABLECUSTOMIZED, 34);
        fieldIndexMap.put(FIELD_GRIDFORCEFIT, 35);
        fieldIndexMap.put(FIELD_GRIDROWACTIVEMODE, 36);
        fieldIndexMap.put(FIELD_HEADERINFO, 37);
        fieldIndexMap.put(FIELD_ICONFILE, 38);
        fieldIndexMap.put(FIELD_LOGICNAME, 39);
        fieldIndexMap.put(FIELD_MAINMENUSIDE, 40);
        fieldIndexMap.put(FIELD_MDCTRLEMPTYTEXT, 41);
        fieldIndexMap.put(FIELD_MDCTRLEMPTYTEXTPSLANRESID, 42);
        fieldIndexMap.put(FIELD_MDCTRLEMPTYTEXTPSLANRESNAME, 43);
        fieldIndexMap.put(FIELD_MEMO, 44);
        fieldIndexMap.put(FIELD_ORDERVALUE, 45);
        fieldIndexMap.put(FIELD_ORIENTATIONMODE, 46);
        fieldIndexMap.put(FIELD_PFSTYLEPARAM, 47);
        fieldIndexMap.put(FIELD_PREVENTXSS, 48);
        fieldIndexMap.put(FIELD_PSAPPEDITORTEMPLSCNT, 49);
        fieldIndexMap.put(FIELD_PSAPPFUNCSCNT, 50);
        fieldIndexMap.put(FIELD_PSAPPMENUSCNT, 51);
        fieldIndexMap.put(FIELD_PSAPPMODULESCNT, 52);
        fieldIndexMap.put(FIELD_PSAPPPKGSCNT, 53);
        fieldIndexMap.put(FIELD_PSAPPTITLEBARSCNT, 54);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 55);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 56);
        fieldIndexMap.put(FIELD_PSAPPUITHEMESCNT, 57);
        fieldIndexMap.put(FIELD_PSAPPUSERMODESCNT, 58);
        fieldIndexMap.put(FIELD_PSAPPUTILPAGESCNT, 59);
        fieldIndexMap.put(FIELD_PSAPPVIEWCODESCNT, 60);
        fieldIndexMap.put(FIELD_PSAPPVIEWSCNT, 61);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 62);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 63);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 64);
        fieldIndexMap.put(FIELD_PSMODULEID, 65);
        fieldIndexMap.put(FIELD_PSMODULENAME, 66);
        fieldIndexMap.put(FIELD_PSPFCDNID, 67);
        fieldIndexMap.put(FIELD_PSPFCDNNAME, 68);
        fieldIndexMap.put(FIELD_PSPFID, 69);
        fieldIndexMap.put(FIELD_PSPFNAME, 70);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 71);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 72);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMEID, 73);
        fieldIndexMap.put(FIELD_PSSTUDIOTHEMENAME, 74);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 75);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 76);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 77);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 78);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 79);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 80);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 81);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 82);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 83);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 84);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 85);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 86);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 87);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 88);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 89);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 90);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 91);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 92);
        fieldIndexMap.put(FIELD_PSSYSTASKSCNT, 93);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 94);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 95);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 96);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 97);
        fieldIndexMap.put(FIELD_PUBREFVIEWONLY, 98);
        fieldIndexMap.put(FIELD_PUBSYSREFVIEWONLY, 99);
        fieldIndexMap.put(FIELD_REMOVEFLAG, 100);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 101);
        fieldIndexMap.put(FIELD_STARTPAGEFILE, 102);
        fieldIndexMap.put(FIELD_SUBCAPTION, 103);
        fieldIndexMap.put(FIELD_TITLE, 104);
        fieldIndexMap.put(FIELD_UACLOGIN, 105);
        fieldIndexMap.put(FIELD_UISTYLE, 106);
        fieldIndexMap.put(FIELD_UPDATEDATE, 107);
        fieldIndexMap.put(FIELD_UPDATEMAN, 108);
        fieldIndexMap.put(FIELD_USERCAT, 109);
        fieldIndexMap.put(FIELD_USERPARAMS, 110);
        fieldIndexMap.put(FIELD_USERTAG, 111);
        fieldIndexMap.put(FIELD_USERTAG2, 112);
        fieldIndexMap.put(FIELD_USERTAG3, 113);
        fieldIndexMap.put(FIELD_USERTAG4, 114);
        fieldIndexMap.put(FIELD_VALIDFLAG, 115);
    }
}

