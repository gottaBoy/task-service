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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionTempl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGroup;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionTemplService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewGroupService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelMemo;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvas;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysChartTheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCodeSnippet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEngineCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysFile;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgQueue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOUType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTitleBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUseCaseCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemMQ;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemRun;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelMemoService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCodeSnippetService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEngineCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysFileService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUseCaseCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemMQService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSystemBase.class);
    public static final String FIELD_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String FIELD_AUTOCALCDERER = "AUTOCALCDERER";
    public static final String FIELD_BUGFIXS = "BUGFIXS";
    public static final String FIELD_CHECKMODELVER = "CHECKMODELVER";
    public static final String FIELD_CLEMPTYTEXT = "CLEMPTYTEXT";
    public static final String FIELD_CLEMPTYTEXTPSLANRESID = "CLEMPTYTEXTPSLANRESID";
    public static final String FIELD_CLEMPTYTEXTPSLANRESNAME = "CLEMPTYTEXTPSLANRESNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLAPPENDDEITEMS = "CTRLAPPENDDEITEMS";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DBTYPES = "DBTYPES";
    public static final String FIELD_DBVERSION = "DBVERSION";
    public static final String FIELD_DEDSMAXROWCNT = "DEDSMAXROWCNT";
    public static final String FIELD_DEEXPMAXROWCNT = "DEEXPMAXROWCNT";
    public static final String FIELD_DEFPSSYSDEPLOYID = "DEFPSSYSDEPLOYID";
    public static final String FIELD_DEFSFITEMWIDTH = "DEFSFITEMWIDTH";
    public static final String FIELD_DEFSORTMODE = "DEFSORTMODE";
    public static final String FIELD_DEMSACTIONLOGICFLAG = "DEMSACTIONLOGICFLAG";
    public static final String FIELD_DOMAINNAME = "DOMAINNAME";
    public static final String FIELD_DTOFORMAT = "DTOFORMAT";
    public static final String FIELD_ENABLEDBVALUEMODE = "ENABLEDBVALUEMODE";
    public static final String FIELD_ENABLEDEDATAVER = "ENABLEDEDATAVER";
    public static final String FIELD_ENABLEDEFRESTRICTEDUI = "ENABLEDEFRESTRICTEDUI";
    public static final String FIELD_ENABLEDERFKEY = "ENABLEDERFKEY";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_ENABLEFOLDERKEY = "ENABLEFOLDERKEY";
    public static final String FIELD_ENABLEMULTILAN = "ENABLEMULTILAN";
    public static final String FIELD_ENABLEOPNAMEMODEL = "ENABLEOPNAMEMODEL";
    public static final String FIELD_ENABLEPQL = "ENABLEPQL";
    public static final String FIELD_ENADEFLANRESCONTENT = "ENADEFLANRESCONTENT";
    public static final String FIELD_ENTITYCNT = "ENTITYCNT";
    public static final String FIELD_EXTRACTDEFAULT = "EXTRACTDEFAULT";
    public static final String FIELD_INITDEDEFAULT = "INITDEDEFAULT";
    public static final String FIELD_LANRESMAXTAG = "LANRESMAXTAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_LOWCODEMODE = "LOWCODEMODE";
    public static final String FIELD_LOWCODEOPTION = "LOWCODEOPTION";
    public static final String FIELD_MAXENTITYCNT = "MAXENTITYCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBPSAPPSCNT = "MOBPSAPPSCNT";
    public static final String FIELD_MODELV2EXPMODE = "MODELV2EXPMODE";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_NOVIEWMODE = "NOVIEWMODE";
    public static final String FIELD_PIAUTOSHOWCAPTION = "PIAUTOSHOWCAPTION";
    public static final String FIELD_PSDEPSLNPRDID = "PSDEPSLNPRDID";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERTSID = "PSDEVCENTERTSID";
    public static final String FIELD_PSDEVCENTERTSNAME = "PSDEVCENTERTSNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String FIELD_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPUBSCNT = "PSSFPUBSCNT";
    public static final String FIELD_PSSYSDEVBKTASKSCNT = "PSSYSDEVBKTASKSCNT";
    public static final String FIELD_PSSYSENGINECFGID = "PSSYSENGINECFGID";
    public static final String FIELD_PSSYSENGINECFGNAME = "PSSYSENGINECFGNAME";
    public static final String FIELD_PSSYSISSUESCNT = "PSSYSISSUESCNT";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSTASKSCNT = "PSSYSTASKSCNT";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFSCNT = "PSWFSCNT";
    public static final String FIELD_PUBDBMODELFLAG = "PUBDBMODELFLAG";
    public static final String FIELD_SAASMODE = "SAASMODE";
    public static final String FIELD_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String FIELD_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String FIELD_SIMACTIONLOGICS = "SIMACTIONLOGICS";
    public static final String FIELD_SRCPSSYSTEMID = "SRCPSSYSTEMID";
    public static final String FIELD_SRCPSSYSTEMNAME = "SRCPSSYSTEMNAME";
    public static final String FIELD_SSDEMSACTIONLOGICFLAG = "SSDEMSACTIONLOGICFLAG";
    public static final String FIELD_SYSFOLDER = "SYSFOLDER";
    public static final String FIELD_SYSROWKEY = "SYSROWKEY";
    public static final String FIELD_SYSTYPE = "SYSTYPE";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_TEMPLENGINE = "TEMPLENGINE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VIEWUAREGMODE = "VIEWUAREGMODE";
    public static final String FIELD_WEBPSAPPSCNT = "WEBPSAPPSCNT";
    private static final int INDEX_ACCCTRLARCH = 0;
    private static final int INDEX_AUTOCALCDERER = 1;
    private static final int INDEX_BUGFIXS = 2;
    private static final int INDEX_CHECKMODELVER = 3;
    private static final int INDEX_CLEMPTYTEXT = 4;
    private static final int INDEX_CLEMPTYTEXTPSLANRESID = 5;
    private static final int INDEX_CLEMPTYTEXTPSLANRESNAME = 6;
    private static final int INDEX_CODENAME = 7;
    private static final int INDEX_CODENAMEMODE = 8;
    private static final int INDEX_CREATEDATE = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_CTRLAPPENDDEITEMS = 11;
    private static final int INDEX_CUSTOMCODE = 12;
    private static final int INDEX_CUSTOMMODE = 13;
    private static final int INDEX_DBTYPES = 14;
    private static final int INDEX_DBVERSION = 15;
    private static final int INDEX_DEDSMAXROWCNT = 16;
    private static final int INDEX_DEEXPMAXROWCNT = 17;
    private static final int INDEX_DEFPSSYSDEPLOYID = 18;
    private static final int INDEX_DEFSFITEMWIDTH = 19;
    private static final int INDEX_DEFSORTMODE = 20;
    private static final int INDEX_DEMSACTIONLOGICFLAG = 21;
    private static final int INDEX_DOMAINNAME = 22;
    private static final int INDEX_DTOFORMAT = 23;
    private static final int INDEX_ENABLEDBVALUEMODE = 24;
    private static final int INDEX_ENABLEDEDATAVER = 25;
    private static final int INDEX_ENABLEDEFRESTRICTEDUI = 26;
    private static final int INDEX_ENABLEDERFKEY = 27;
    private static final int INDEX_ENABLEDYNASYS = 28;
    private static final int INDEX_ENABLEFOLDERKEY = 29;
    private static final int INDEX_ENABLEMULTILAN = 30;
    private static final int INDEX_ENABLEOPNAMEMODEL = 31;
    private static final int INDEX_ENABLEPQL = 32;
    private static final int INDEX_ENADEFLANRESCONTENT = 33;
    private static final int INDEX_ENTITYCNT = 34;
    private static final int INDEX_EXTRACTDEFAULT = 35;
    private static final int INDEX_INITDEDEFAULT = 36;
    private static final int INDEX_LANRESMAXTAG = 37;
    private static final int INDEX_LOGICNAME = 38;
    private static final int INDEX_LOWCODEMODE = 39;
    private static final int INDEX_LOWCODEOPTION = 40;
    private static final int INDEX_MAXENTITYCNT = 41;
    private static final int INDEX_MEMO = 42;
    private static final int INDEX_MOBPSAPPSCNT = 43;
    private static final int INDEX_MODELV2EXPMODE = 44;
    private static final int INDEX_MODELVER = 45;
    private static final int INDEX_NOVIEWMODE = 46;
    private static final int INDEX_PIAUTOSHOWCAPTION = 47;
    private static final int INDEX_PSDEPSLNPRDID = 48;
    private static final int INDEX_PSDEVCENTERID = 49;
    private static final int INDEX_PSDEVCENTERNAME = 50;
    private static final int INDEX_PSDEVCENTERTSID = 51;
    private static final int INDEX_PSDEVCENTERTSNAME = 52;
    private static final int INDEX_PSDEVSLNID = 53;
    private static final int INDEX_PSDEVSLNNAME = 54;
    private static final int INDEX_PSDEVSLNSYSID = 55;
    private static final int INDEX_PSLANGUAGEID = 56;
    private static final int INDEX_PSLANGUAGENAME = 57;
    private static final int INDEX_PSSFID = 58;
    private static final int INDEX_PSSFNAME = 59;
    private static final int INDEX_PSSFPUBSCNT = 60;
    private static final int INDEX_PSSYSDEVBKTASKSCNT = 61;
    private static final int INDEX_PSSYSENGINECFGID = 62;
    private static final int INDEX_PSSYSENGINECFGNAME = 63;
    private static final int INDEX_PSSYSISSUESCNT = 64;
    private static final int INDEX_PSSYSMODELINSTID = 65;
    private static final int INDEX_PSSYSTASKSCNT = 66;
    private static final int INDEX_PSSYSTEMID = 67;
    private static final int INDEX_PSSYSTEMNAME = 68;
    private static final int INDEX_PSWFSCNT = 69;
    private static final int INDEX_PUBDBMODELFLAG = 70;
    private static final int INDEX_SAASMODE = 71;
    private static final int INDEX_SCRIPTENGINE = 72;
    private static final int INDEX_SERVICEAPIFLAG = 73;
    private static final int INDEX_SIMACTIONLOGICS = 74;
    private static final int INDEX_SRCPSSYSTEMID = 75;
    private static final int INDEX_SRCPSSYSTEMNAME = 76;
    private static final int INDEX_SSDEMSACTIONLOGICFLAG = 77;
    private static final int INDEX_SYSFOLDER = 78;
    private static final int INDEX_SYSROWKEY = 79;
    private static final int INDEX_SYSTYPE = 80;
    private static final int INDEX_SYSVER = 81;
    private static final int INDEX_TAGS = 82;
    private static final int INDEX_TEMPLENGINE = 83;
    private static final int INDEX_UPDATEDATE = 84;
    private static final int INDEX_UPDATEMAN = 85;
    private static final int INDEX_USERPARAMS = 86;
    private static final int INDEX_VIEWUAREGMODE = 87;
    private static final int INDEX_WEBPSAPPSCNT = 88;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSystemBase proxyPSSystemBase = null;
    private boolean accctrlarchDirtyFlag = false;
    private boolean autocalcdererDirtyFlag = false;
    private boolean bugfixsDirtyFlag = false;
    private boolean checkmodelverDirtyFlag = false;
    private boolean clemptytextDirtyFlag = false;
    private boolean clemptytextpslanresidDirtyFlag = false;
    private boolean clemptytextpslanresnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlappenddeitemsDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dbtypesDirtyFlag = false;
    private boolean dbversionDirtyFlag = false;
    private boolean dedsmaxrowcntDirtyFlag = false;
    private boolean deexpmaxrowcntDirtyFlag = false;
    private boolean defpssysdeployidDirtyFlag = false;
    private boolean defsfitemwidthDirtyFlag = false;
    private boolean defsortmodeDirtyFlag = false;
    private boolean demsactionlogicflagDirtyFlag = false;
    private boolean domainnameDirtyFlag = false;
    private boolean dtoformatDirtyFlag = false;
    private boolean enabledbvaluemodeDirtyFlag = false;
    private boolean enablededataverDirtyFlag = false;
    private boolean enabledefrestricteduiDirtyFlag = false;
    private boolean enablederfkeyDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean enablefolderkeyDirtyFlag = false;
    private boolean enablemultilanDirtyFlag = false;
    private boolean enableopnamemodelDirtyFlag = false;
    private boolean enablepqlDirtyFlag = false;
    private boolean enadeflanrescontentDirtyFlag = false;
    private boolean entitycntDirtyFlag = false;
    private boolean extractdefaultDirtyFlag = false;
    private boolean initdedefaultDirtyFlag = false;
    private boolean lanresmaxtagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean lowcodemodeDirtyFlag = false;
    private boolean lowcodeoptionDirtyFlag = false;
    private boolean maxentitycntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobpsappscntDirtyFlag = false;
    private boolean modelv2expmodeDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean noviewmodeDirtyFlag = false;
    private boolean piautoshowcaptionDirtyFlag = false;
    private boolean psdepslnprdidDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentertsidDirtyFlag = false;
    private boolean psdevcentertsnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean pslanguageidDirtyFlag = false;
    private boolean pslanguagenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpubscntDirtyFlag = false;
    private boolean pssysdevbktaskscntDirtyFlag = false;
    private boolean pssysenginecfgidDirtyFlag = false;
    private boolean pssysenginecfgnameDirtyFlag = false;
    private boolean pssysissuescntDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssystaskscntDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfscntDirtyFlag = false;
    private boolean pubdbmodelflagDirtyFlag = false;
    private boolean saasmodeDirtyFlag = false;
    private boolean scriptengineDirtyFlag = false;
    private boolean serviceapiflagDirtyFlag = false;
    private boolean simactionlogicsDirtyFlag = false;
    private boolean srcpssystemidDirtyFlag = false;
    private boolean srcpssystemnameDirtyFlag = false;
    private boolean ssdemsactionlogicflagDirtyFlag = false;
    private boolean sysfolderDirtyFlag = false;
    private boolean sysrowkeyDirtyFlag = false;
    private boolean systypeDirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean templengineDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean viewuaregmodeDirtyFlag = false;
    private boolean webpsappscntDirtyFlag = false;
    @Column(name="accctrlarch")
    private Integer accctrlarch;
    @Column(name="autocalcderer")
    private Integer autocalcderer;
    @Column(name="bugfixs")
    private Integer bugfixs;
    @Column(name="checkmodelver")
    private Integer checkmodelver;
    @Column(name="clemptytext")
    private String clemptytext;
    @Column(name="clemptytextpslanresid")
    private String clemptytextpslanresid;
    @Column(name="clemptytextpslanresname")
    private String clemptytextpslanresname;
    @Column(name="codename")
    private String codename;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlappenddeitems")
    private Integer ctrlappenddeitems;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dbtypes")
    private String dbtypes;
    @Column(name="dbversion")
    private Integer dbversion;
    @Column(name="dedsmaxrowcnt")
    private Integer dedsmaxrowcnt;
    @Column(name="deexpmaxrowcnt")
    private Integer deexpmaxrowcnt;
    @Column(name="defpssysdeployid")
    private String defpssysdeployid;
    @Column(name="defsfitemwidth")
    private Integer defsfitemwidth;
    @Column(name="defsortmode")
    private String defsortmode;
    @Column(name="demsactionlogicflag")
    private Integer demsactionlogicflag;
    @Column(name="domainname")
    private String domainname;
    @Column(name="dtoformat")
    private String dtoformat;
    @Column(name="enabledbvaluemode")
    private Integer enabledbvaluemode;
    @Column(name="enablededataver")
    private Integer enablededataver;
    @Column(name="enabledefrestrictedui")
    private Integer enabledefrestrictedui;
    @Column(name="enablederfkey")
    private Integer enablederfkey;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="enablefolderkey")
    private Integer enablefolderkey;
    @Column(name="enablemultilan")
    private Integer enablemultilan;
    @Column(name="enableopnamemodel")
    private Integer enableopnamemodel;
    @Column(name="enablepql")
    private Integer enablepql;
    @Column(name="enadeflanrescontent")
    private Integer enadeflanrescontent;
    @Column(name="entitycnt")
    private Integer entitycnt;
    @Column(name="extractdefault")
    private Integer extractdefault;
    @Column(name="initdedefault")
    private Integer initdedefault;
    @Column(name="lanresmaxtag")
    private Integer lanresmaxtag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="lowcodemode")
    private Integer lowcodemode;
    @Column(name="lowcodeoption")
    private String lowcodeoption;
    @Column(name="maxentitycnt")
    private Integer maxentitycnt;
    @Column(name="memo")
    private String memo;
    @Column(name="mobpsappscnt")
    private Integer mobpsappscnt;
    @Column(name="modelv2expmode")
    private Integer modelv2expmode;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="noviewmode")
    private Integer noviewmode;
    @Column(name="piautoshowcaption")
    private Integer piautoshowcaption;
    @Column(name="psdepslnprdid")
    private String psdepslnprdid;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentertsid")
    private String psdevcentertsid;
    @Column(name="psdevcentertsname")
    private String psdevcentertsname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="pslanguageid")
    private String pslanguageid;
    @Column(name="pslanguagename")
    private String pslanguagename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpubscnt")
    private Integer pssfpubscnt;
    @Column(name="pssysdevbktaskscnt")
    private Integer pssysdevbktaskscnt;
    @Column(name="pssysenginecfgid")
    private String pssysenginecfgid;
    @Column(name="pssysenginecfgname")
    private String pssysenginecfgname;
    @Column(name="pssysissuescnt")
    private Integer pssysissuescnt;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssystaskscnt")
    private Integer pssystaskscnt;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfscnt")
    private Integer pswfscnt;
    @Column(name="pubdbmodelflag")
    private Integer pubdbmodelflag;
    @Column(name="saasmode")
    private Integer saasmode;
    @Column(name="scriptengine")
    private String scriptengine;
    @Column(name="serviceapiflag")
    private Integer serviceapiflag;
    @Column(name="simactionlogics")
    private Integer simactionlogics;
    @Column(name="srcpssystemid")
    private String srcpssystemid;
    @Column(name="srcpssystemname")
    private String srcpssystemname;
    @Column(name="ssdemsactionlogicflag")
    private Integer ssdemsactionlogicflag;
    @Column(name="sysfolder")
    private String sysfolder;
    @Column(name="sysrowkey")
    private String sysrowkey;
    @Column(name="systype")
    private String systype;
    @Column(name="sysver")
    private String sysver;
    @Column(name="tags")
    private String tags;
    @Column(name="templengine")
    private String templengine;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="viewuaregmode")
    private Integer viewuaregmode;
    @Column(name="webpsappscnt")
    private Integer webpsappscnt;
    private Integer objPSDevCenterTSLock = new Integer(1);
    private PSDevCenterTS psdevcenterts = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objCLEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes clemptytextpslanres = null;
    private Integer objPSLanguageLock = new Integer(1);
    private PSLanguage pslanguage = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSysEngineCfgLock = new Integer(1);
    private PSSysEngineCfg pssysenginecfg = null;
    private Integer objSrcPSSystemLock = new Integer(1);
    private PSSystem srcpssystem = null;
    private Integer objPSDEActionTemplsLock = new Integer(1);
    private ArrayList<PSDEActionTempl> psdeactiontempls = null;
    private Integer objPSDEGroupsLock = new Integer(1);
    private ArrayList<PSDEGroup> psdegroups = null;
    private Integer objPSDERGroupsLock = new Integer(1);
    private ArrayList<PSDERGroup> psdergroups = null;
    private Integer objPSDEViewGroupsLock = new Integer(1);
    private ArrayList<PSDEViewGroup> psdeviewgroups = null;
    private Integer objPSDynaDETemplsLock = new Integer(1);
    private ArrayList<PSDynaDETempl> psdynadetempls = null;
    private Integer objPSModelMemosLock = new Integer(1);
    private ArrayList<PSModelMemo> psmodelmemos = null;
    private Integer objPSModulesLock = new Integer(1);
    private ArrayList<PSModule> psmodules = null;
    private Integer objPSSubSysServiceAPIsLock = new Integer(1);
    private ArrayList<PSSubSysServiceAPI> pssubsysserviceapis = null;
    private Integer objPSSysAIFactoriesLock = new Integer(1);
    private ArrayList<PSSysAIFactory> pssysaifactories = null;
    private Integer objPSSysAppsLock = new Integer(1);
    private ArrayList<PSSysApp> pssysapps = null;
    private Integer objPSSysBISchemesLock = new Integer(1);
    private ArrayList<PSSysBIScheme> pssysbischemes = null;
    private Integer objPSSysCanvasesLock = new Integer(1);
    private ArrayList<PSSysCanvas> pssyscanvases = null;
    private Integer objPSSysChartThemesLock = new Integer(1);
    private ArrayList<PSSysChartTheme> pssyschartthemes = null;
    private Integer objPSSysCodeSnippetsLock = new Integer(1);
    private ArrayList<PSSysCodeSnippet> pssyscodesnippets = null;
    private Integer objPSSysContentCatsLock = new Integer(1);
    private ArrayList<PSSysContentCat> pssyscontentcats = null;
    private Integer objPSSysContentsLock = new Integer(1);
    private ArrayList<PSSysContent> pssyscontents = null;
    private Integer objPSSysDashboardsLock = new Integer(1);
    private ArrayList<PSSysDashboard> pssysdashboards = null;
    private Integer objPSSysDBSchemesLock = new Integer(1);
    private ArrayList<PSSysDBScheme> pssysdbschemes = null;
    private Integer objPSSysDBVFsLock = new Integer(1);
    private ArrayList<PSSysDBVF> pssysdbvfs = null;
    private Integer objPSSysDevBKTasksLock = new Integer(1);
    private ArrayList<PSSysDevBKTask> pssysdevbktasks = null;
    private Integer objPSSysDMVersLock = new Integer(1);
    private ArrayList<PSSysDMVer> pssysdmvers = null;
    private Integer objPSSysEAISchemesLock = new Integer(1);
    private ArrayList<PSSysEAIScheme> pssyseaischemes = null;
    private Integer objPSSysFilesLock = new Integer(1);
    private ArrayList<PSSysFile> pssysfiles = null;
    private Integer objPSSysIssuesLock = new Integer(1);
    private ArrayList<PSSysIssue> pssysissues = null;
    private Integer objPSSysMapViewsLock = new Integer(1);
    private ArrayList<PSSysMapView> pssysmapviews = null;
    private Integer objPSSysModelGroupsLock = new Integer(1);
    private ArrayList<PSSysModelGroup> pssysmodelgroups = null;
    private Integer objPSSysMsgQueuesLock = new Integer(1);
    private ArrayList<PSSysMsgQueue> pssysmsgqueues = null;
    private Integer objPSSysOUTypesLock = new Integer(1);
    private ArrayList<PSSysOUType> pssysoutypes = null;
    private Integer objPSSysPortletCatsLock = new Integer(1);
    private ArrayList<PSSysPortletCat> pssysportletcats = null;
    private Integer objPSSysProjectsLock = new Integer(1);
    private ArrayList<PSSysProject> pssysprojects = null;
    private Integer objPSSysResourcesLock = new Integer(1);
    private ArrayList<PSSysResource> pssysresources = null;
    private Integer objPSSysSampleValuesLock = new Integer(1);
    private ArrayList<PSSysSampleValue> pssyssamplevalues = null;
    private Integer objPSSysSearchSchemesLock = new Integer(1);
    private ArrayList<PSSysSearchScheme> pssyssearchschemes = null;
    private Integer objPSSysSequencesLock = new Integer(1);
    private ArrayList<PSSysSequence> pssyssequences = null;
    private Integer objPSSysServiceAPIsLock = new Integer(1);
    private ArrayList<PSSysServiceAPI> pssysserviceapis = null;
    private Integer objPSSysSFPubsLock = new Integer(1);
    private ArrayList<PSSysSFPub> pssyssfpubs = null;
    private Integer objPSSysSqlCmdsLock = new Integer(1);
    private ArrayList<PSSysSQLCmd> pssyssqlcmds = null;
    private Integer objPSSysTasksLock = new Integer(1);
    private ArrayList<PSSysTask> pssystasks = null;
    private Integer objPSSystemMQLock = new Integer(1);
    private ArrayList<PSSystemMQ> pssystemmq = null;
    private Integer objPSSystemRunsLock = new Integer(1);
    private ArrayList<PSSystemRun> pssystemruns = null;
    private Integer objPSSysTestPrjsLock = new Integer(1);
    private ArrayList<PSSysTestPrj> pssystestprjs = null;
    private Integer objPSSysTitleBarsLock = new Integer(1);
    private ArrayList<PSSysTitleBar> pssystitlebars = null;
    private Integer objPSSysTranslatorsLock = new Integer(1);
    private ArrayList<PSSysTranslator> pssystranslators = null;
    private Integer objPSSysUCMapsLock = new Integer(1);
    private ArrayList<PSSysUCMap> pssysucmaps = null;
    private Integer objPSSysUniResesLock = new Integer(1);
    private ArrayList<PSSysUniRes> pssysunireses = null;
    private Integer objPSSysUniStatesLock = new Integer(1);
    private ArrayList<PSSysUniState> pssysunistates = null;
    private Integer objPSSysUnitsLock = new Integer(1);
    private ArrayList<PSSysUnit> pssysunits = null;
    private Integer objPSSysUseCaseCatsLock = new Integer(1);
    private ArrayList<PSSysUseCaseCat> pssysusecasecats = null;
    private Integer objPSSysUserCaseRSsLock = new Integer(1);
    private ArrayList<PSSysUserCaseRS> pssysusercaserss = null;
    private Integer objPSSysUserDRsLock = new Integer(1);
    private ArrayList<PSSysUserDR> pssysuserdrs = null;
    private Integer objPSSysUtilDEsLock = new Integer(1);
    private ArrayList<PSSysUtilDE> pssysutildes = null;
    private Integer objPSSysViewPanelsLock = new Integer(1);
    private ArrayList<PSSysViewPanel> pssysviewpanels = null;
    private Integer objPSSysWFCatsLock = new Integer(1);
    private ArrayList<PSSysWFCat> pssyswfcats = null;
    private Integer objPSThresholdGroupsLock = new Integer(1);
    private ArrayList<PSThresholdGroup> psthresholdgroups = null;
    private Integer objPSWorkflowsLock = new Integer(1);
    private ArrayList<PSWorkflow> psworkflows = null;

    public void setAccCtrlArch(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccCtrlArch(n);
            return;
        }
        this.accctrlarch = n;
        this.accctrlarchDirtyFlag = true;
    }

    public Integer getAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccCtrlArch();
        }
        return this.accctrlarch;
    }

    public boolean isAccCtrlArchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccCtrlArchDirty();
        }
        return this.accctrlarchDirtyFlag;
    }

    public void resetAccCtrlArch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccCtrlArch();
            return;
        }
        this.accctrlarchDirtyFlag = false;
        this.accctrlarch = null;
    }

    public void setAutoCalcDERER(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoCalcDERER(n);
            return;
        }
        this.autocalcderer = n;
        this.autocalcdererDirtyFlag = true;
    }

    public Integer getAutoCalcDERER() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoCalcDERER();
        }
        return this.autocalcderer;
    }

    public boolean isAutoCalcDERERDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoCalcDERERDirty();
        }
        return this.autocalcdererDirtyFlag;
    }

    public void resetAutoCalcDERER() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoCalcDERER();
            return;
        }
        this.autocalcdererDirtyFlag = false;
        this.autocalcderer = null;
    }

    public void setBugFixs(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBugFixs(n);
            return;
        }
        this.bugfixs = n;
        this.bugfixsDirtyFlag = true;
    }

    public Integer getBugFixs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBugFixs();
        }
        return this.bugfixs;
    }

    public boolean isBugFixsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBugFixsDirty();
        }
        return this.bugfixsDirtyFlag;
    }

    public void resetBugFixs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBugFixs();
            return;
        }
        this.bugfixsDirtyFlag = false;
        this.bugfixs = null;
    }

    public void setCheckModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckModelVer(n);
            return;
        }
        this.checkmodelver = n;
        this.checkmodelverDirtyFlag = true;
    }

    public Integer getCheckModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckModelVer();
        }
        return this.checkmodelver;
    }

    public boolean isCheckModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckModelVerDirty();
        }
        return this.checkmodelverDirtyFlag;
    }

    public void resetCheckModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckModelVer();
            return;
        }
        this.checkmodelverDirtyFlag = false;
        this.checkmodelver = null;
    }

    public void setCLEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clemptytext = string;
        this.clemptytextDirtyFlag = true;
    }

    public String getCLEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLEmptyText();
        }
        return this.clemptytext;
    }

    public boolean isCLEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLEmptyTextDirty();
        }
        return this.clemptytextDirtyFlag;
    }

    public void resetCLEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLEmptyText();
            return;
        }
        this.clemptytextDirtyFlag = false;
        this.clemptytext = null;
    }

    public void setCLEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clemptytextpslanresid = string;
        this.clemptytextpslanresidDirtyFlag = true;
    }

    public String getCLEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLEmptyTextPSLanResId();
        }
        return this.clemptytextpslanresid;
    }

    public boolean isCLEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLEmptyTextPSLanResIdDirty();
        }
        return this.clemptytextpslanresidDirtyFlag;
    }

    public void resetCLEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLEmptyTextPSLanResId();
            return;
        }
        this.clemptytextpslanresidDirtyFlag = false;
        this.clemptytextpslanresid = null;
    }

    public void setCLEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clemptytextpslanresname = string;
        this.clemptytextpslanresnameDirtyFlag = true;
    }

    public String getCLEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLEmptyTextPSLanResName();
        }
        return this.clemptytextpslanresname;
    }

    public boolean isCLEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLEmptyTextPSLanResNameDirty();
        }
        return this.clemptytextpslanresnameDirtyFlag;
    }

    public void resetCLEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLEmptyTextPSLanResName();
            return;
        }
        this.clemptytextpslanresnameDirtyFlag = false;
        this.clemptytextpslanresname = null;
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

    public void setCtrlAppendDEItems(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlAppendDEItems(n);
            return;
        }
        this.ctrlappenddeitems = n;
        this.ctrlappenddeitemsDirtyFlag = true;
    }

    public Integer getCtrlAppendDEItems() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlAppendDEItems();
        }
        return this.ctrlappenddeitems;
    }

    public boolean isCtrlAppendDEItemsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlAppendDEItemsDirty();
        }
        return this.ctrlappenddeitemsDirtyFlag;
    }

    public void resetCtrlAppendDEItems() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlAppendDEItems();
            return;
        }
        this.ctrlappenddeitemsDirtyFlag = false;
        this.ctrlappenddeitems = null;
    }

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDBTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtypes = string;
        this.dbtypesDirtyFlag = true;
    }

    public String getDBTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBTypes();
        }
        return this.dbtypes;
    }

    public boolean isDBTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypesDirty();
        }
        return this.dbtypesDirtyFlag;
    }

    public void resetDBTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBTypes();
            return;
        }
        this.dbtypesDirtyFlag = false;
        this.dbtypes = null;
    }

    public void setDBVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVersion(n);
            return;
        }
        this.dbversion = n;
        this.dbversionDirtyFlag = true;
    }

    public Integer getDBVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVersion();
        }
        return this.dbversion;
    }

    public boolean isDBVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVersionDirty();
        }
        return this.dbversionDirtyFlag;
    }

    public void resetDBVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVersion();
            return;
        }
        this.dbversionDirtyFlag = false;
        this.dbversion = null;
    }

    public void setDEDSMaxRowCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDSMaxRowCnt(n);
            return;
        }
        this.dedsmaxrowcnt = n;
        this.dedsmaxrowcntDirtyFlag = true;
    }

    public Integer getDEDSMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDSMaxRowCnt();
        }
        return this.dedsmaxrowcnt;
    }

    public boolean isDEDSMaxRowCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDSMaxRowCntDirty();
        }
        return this.dedsmaxrowcntDirtyFlag;
    }

    public void resetDEDSMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDSMaxRowCnt();
            return;
        }
        this.dedsmaxrowcntDirtyFlag = false;
        this.dedsmaxrowcnt = null;
    }

    public void setDEExpMaxRowCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEExpMaxRowCnt(n);
            return;
        }
        this.deexpmaxrowcnt = n;
        this.deexpmaxrowcntDirtyFlag = true;
    }

    public Integer getDEExpMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEExpMaxRowCnt();
        }
        return this.deexpmaxrowcnt;
    }

    public boolean isDEExpMaxRowCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEExpMaxRowCntDirty();
        }
        return this.deexpmaxrowcntDirtyFlag;
    }

    public void resetDEExpMaxRowCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEExpMaxRowCnt();
            return;
        }
        this.deexpmaxrowcntDirtyFlag = false;
        this.deexpmaxrowcnt = null;
    }

    public void setDEFPSSysDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFPSSysDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpssysdeployid = string;
        this.defpssysdeployidDirtyFlag = true;
    }

    public String getDEFPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysDeployId();
        }
        return this.defpssysdeployid;
    }

    public boolean isDEFPSSysDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFPSSysDeployIdDirty();
        }
        return this.defpssysdeployidDirtyFlag;
    }

    public void resetDEFPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFPSSysDeployId();
            return;
        }
        this.defpssysdeployidDirtyFlag = false;
        this.defpssysdeployid = null;
    }

    public void setDEFSFItemWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFSFItemWidth(n);
            return;
        }
        this.defsfitemwidth = n;
        this.defsfitemwidthDirtyFlag = true;
    }

    public Integer getDEFSFItemWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFSFItemWidth();
        }
        return this.defsfitemwidth;
    }

    public boolean isDEFSFItemWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFSFItemWidthDirty();
        }
        return this.defsfitemwidthDirtyFlag;
    }

    public void resetDEFSFItemWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFSFItemWidth();
            return;
        }
        this.defsfitemwidthDirtyFlag = false;
        this.defsfitemwidth = null;
    }

    public void setDEFSortMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFSortMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defsortmode = string;
        this.defsortmodeDirtyFlag = true;
    }

    public String getDEFSortMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFSortMode();
        }
        return this.defsortmode;
    }

    public boolean isDEFSortModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFSortModeDirty();
        }
        return this.defsortmodeDirtyFlag;
    }

    public void resetDEFSortMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFSortMode();
            return;
        }
        this.defsortmodeDirtyFlag = false;
        this.defsortmode = null;
    }

    public void setDEMSActionLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEMSActionLogicFlag(n);
            return;
        }
        this.demsactionlogicflag = n;
        this.demsactionlogicflagDirtyFlag = true;
    }

    public Integer getDEMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEMSActionLogicFlag();
        }
        return this.demsactionlogicflag;
    }

    public boolean isDEMSActionLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEMSActionLogicFlagDirty();
        }
        return this.demsactionlogicflagDirtyFlag;
    }

    public void resetDEMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEMSActionLogicFlag();
            return;
        }
        this.demsactionlogicflagDirtyFlag = false;
        this.demsactionlogicflag = null;
    }

    public void setDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainname = string;
        this.domainnameDirtyFlag = true;
    }

    public String getDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainName();
        }
        return this.domainname;
    }

    public boolean isDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainNameDirty();
        }
        return this.domainnameDirtyFlag;
    }

    public void resetDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainName();
            return;
        }
        this.domainnameDirtyFlag = false;
        this.domainname = null;
    }

    public void setDTOFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDTOFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dtoformat = string;
        this.dtoformatDirtyFlag = true;
    }

    public String getDTOFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDTOFormat();
        }
        return this.dtoformat;
    }

    public boolean isDTOFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDTOFormatDirty();
        }
        return this.dtoformatDirtyFlag;
    }

    public void resetDTOFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDTOFormat();
            return;
        }
        this.dtoformatDirtyFlag = false;
        this.dtoformat = null;
    }

    public void setEnableDBValueMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDBValueMode(n);
            return;
        }
        this.enabledbvaluemode = n;
        this.enabledbvaluemodeDirtyFlag = true;
    }

    public Integer getEnableDBValueMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDBValueMode();
        }
        return this.enabledbvaluemode;
    }

    public boolean isEnableDBValueModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDBValueModeDirty();
        }
        return this.enabledbvaluemodeDirtyFlag;
    }

    public void resetEnableDBValueMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDBValueMode();
            return;
        }
        this.enabledbvaluemodeDirtyFlag = false;
        this.enabledbvaluemode = null;
    }

    public void setEnableDEDataVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEDataVer(n);
            return;
        }
        this.enablededataver = n;
        this.enablededataverDirtyFlag = true;
    }

    public Integer getEnableDEDataVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEDataVer();
        }
        return this.enablededataver;
    }

    public boolean isEnableDEDataVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEDataVerDirty();
        }
        return this.enablededataverDirtyFlag;
    }

    public void resetEnableDEDataVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEDataVer();
            return;
        }
        this.enablededataverDirtyFlag = false;
        this.enablededataver = null;
    }

    public void setEnableDEFRestrictedUI(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDEFRestrictedUI(n);
            return;
        }
        this.enabledefrestrictedui = n;
        this.enabledefrestricteduiDirtyFlag = true;
    }

    public Integer getEnableDEFRestrictedUI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDEFRestrictedUI();
        }
        return this.enabledefrestrictedui;
    }

    public boolean isEnableDEFRestrictedUIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDEFRestrictedUIDirty();
        }
        return this.enabledefrestricteduiDirtyFlag;
    }

    public void resetEnableDEFRestrictedUI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDEFRestrictedUI();
            return;
        }
        this.enabledefrestricteduiDirtyFlag = false;
        this.enabledefrestrictedui = null;
    }

    public void setEnableDERFKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDERFKey(n);
            return;
        }
        this.enablederfkey = n;
        this.enablederfkeyDirtyFlag = true;
    }

    public Integer getEnableDERFKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDERFKey();
        }
        return this.enablederfkey;
    }

    public boolean isEnableDERFKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDERFKeyDirty();
        }
        return this.enablederfkeyDirtyFlag;
    }

    public void resetEnableDERFKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDERFKey();
            return;
        }
        this.enablederfkeyDirtyFlag = false;
        this.enablederfkey = null;
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

    public void setEnableFolderKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableFolderKey(n);
            return;
        }
        this.enablefolderkey = n;
        this.enablefolderkeyDirtyFlag = true;
    }

    public Integer getEnableFolderKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableFolderKey();
        }
        return this.enablefolderkey;
    }

    public boolean isEnableFolderKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableFolderKeyDirty();
        }
        return this.enablefolderkeyDirtyFlag;
    }

    public void resetEnableFolderKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableFolderKey();
            return;
        }
        this.enablefolderkeyDirtyFlag = false;
        this.enablefolderkey = null;
    }

    public void setEnableMultiLan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMultiLan(n);
            return;
        }
        this.enablemultilan = n;
        this.enablemultilanDirtyFlag = true;
    }

    public Integer getEnableMultiLan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMultiLan();
        }
        return this.enablemultilan;
    }

    public boolean isEnableMultiLanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMultiLanDirty();
        }
        return this.enablemultilanDirtyFlag;
    }

    public void resetEnableMultiLan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMultiLan();
            return;
        }
        this.enablemultilanDirtyFlag = false;
        this.enablemultilan = null;
    }

    public void setEnableOPNameModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableOPNameModel(n);
            return;
        }
        this.enableopnamemodel = n;
        this.enableopnamemodelDirtyFlag = true;
    }

    public Integer getEnableOPNameModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableOPNameModel();
        }
        return this.enableopnamemodel;
    }

    public boolean isEnableOPNameModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableOPNameModelDirty();
        }
        return this.enableopnamemodelDirtyFlag;
    }

    public void resetEnableOPNameModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableOPNameModel();
            return;
        }
        this.enableopnamemodelDirtyFlag = false;
        this.enableopnamemodel = null;
    }

    public void setEnablePQL(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePQL(n);
            return;
        }
        this.enablepql = n;
        this.enablepqlDirtyFlag = true;
    }

    public Integer getEnablePQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePQL();
        }
        return this.enablepql;
    }

    public boolean isEnablePQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePQLDirty();
        }
        return this.enablepqlDirtyFlag;
    }

    public void resetEnablePQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePQL();
            return;
        }
        this.enablepqlDirtyFlag = false;
        this.enablepql = null;
    }

    public void setEnaDefLanResContent(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaDefLanResContent(n);
            return;
        }
        this.enadeflanrescontent = n;
        this.enadeflanrescontentDirtyFlag = true;
    }

    public Integer getEnaDefLanResContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaDefLanResContent();
        }
        return this.enadeflanrescontent;
    }

    public boolean isEnaDefLanResContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaDefLanResContentDirty();
        }
        return this.enadeflanrescontentDirtyFlag;
    }

    public void resetEnaDefLanResContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaDefLanResContent();
            return;
        }
        this.enadeflanrescontentDirtyFlag = false;
        this.enadeflanrescontent = null;
    }

    public void setEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEntityCnt(n);
            return;
        }
        this.entitycnt = n;
        this.entitycntDirtyFlag = true;
    }

    public Integer getEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEntityCnt();
        }
        return this.entitycnt;
    }

    public boolean isEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEntityCntDirty();
        }
        return this.entitycntDirtyFlag;
    }

    public void resetEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEntityCnt();
            return;
        }
        this.entitycntDirtyFlag = false;
        this.entitycnt = null;
    }

    public void setExtractDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtractDefault(n);
            return;
        }
        this.extractdefault = n;
        this.extractdefaultDirtyFlag = true;
    }

    public Integer getExtractDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtractDefault();
        }
        return this.extractdefault;
    }

    public boolean isExtractDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtractDefaultDirty();
        }
        return this.extractdefaultDirtyFlag;
    }

    public void resetExtractDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtractDefault();
            return;
        }
        this.extractdefaultDirtyFlag = false;
        this.extractdefault = null;
    }

    public void setInitDEDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitDEDefault(n);
            return;
        }
        this.initdedefault = n;
        this.initdedefaultDirtyFlag = true;
    }

    public Integer getInitDEDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitDEDefault();
        }
        return this.initdedefault;
    }

    public boolean isInitDEDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitDEDefaultDirty();
        }
        return this.initdedefaultDirtyFlag;
    }

    public void resetInitDEDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitDEDefault();
            return;
        }
        this.initdedefaultDirtyFlag = false;
        this.initdedefault = null;
    }

    public void setLanResMaxTag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResMaxTag(n);
            return;
        }
        this.lanresmaxtag = n;
        this.lanresmaxtagDirtyFlag = true;
    }

    public Integer getLanResMaxTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResMaxTag();
        }
        return this.lanresmaxtag;
    }

    public boolean isLanResMaxTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResMaxTagDirty();
        }
        return this.lanresmaxtagDirtyFlag;
    }

    public void resetLanResMaxTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResMaxTag();
            return;
        }
        this.lanresmaxtagDirtyFlag = false;
        this.lanresmaxtag = null;
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

    public void setLowCodeMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLowCodeMode(n);
            return;
        }
        this.lowcodemode = n;
        this.lowcodemodeDirtyFlag = true;
    }

    public Integer getLowCodeMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLowCodeMode();
        }
        return this.lowcodemode;
    }

    public boolean isLowCodeModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLowCodeModeDirty();
        }
        return this.lowcodemodeDirtyFlag;
    }

    public void resetLowCodeMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLowCodeMode();
            return;
        }
        this.lowcodemodeDirtyFlag = false;
        this.lowcodemode = null;
    }

    public void setLowCodeOption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLowCodeOption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lowcodeoption = string;
        this.lowcodeoptionDirtyFlag = true;
    }

    public String getLowCodeOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLowCodeOption();
        }
        return this.lowcodeoption;
    }

    public boolean isLowCodeOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLowCodeOptionDirty();
        }
        return this.lowcodeoptionDirtyFlag;
    }

    public void resetLowCodeOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLowCodeOption();
            return;
        }
        this.lowcodeoptionDirtyFlag = false;
        this.lowcodeoption = null;
    }

    public void setMaxEntityCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEntityCnt(n);
            return;
        }
        this.maxentitycnt = n;
        this.maxentitycntDirtyFlag = true;
    }

    public Integer getMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEntityCnt();
        }
        return this.maxentitycnt;
    }

    public boolean isMaxEntityCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEntityCntDirty();
        }
        return this.maxentitycntDirtyFlag;
    }

    public void resetMaxEntityCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEntityCnt();
            return;
        }
        this.maxentitycntDirtyFlag = false;
        this.maxentitycnt = null;
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

    public void setMobPSAppsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSAppsCnt(n);
            return;
        }
        this.mobpsappscnt = n;
        this.mobpsappscntDirtyFlag = true;
    }

    public Integer getMobPSAppsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSAppsCnt();
        }
        return this.mobpsappscnt;
    }

    public boolean isMobPSAppsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSAppsCntDirty();
        }
        return this.mobpsappscntDirtyFlag;
    }

    public void resetMobPSAppsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSAppsCnt();
            return;
        }
        this.mobpsappscntDirtyFlag = false;
        this.mobpsappscnt = null;
    }

    public void setModelV2ExpMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelV2ExpMode(n);
            return;
        }
        this.modelv2expmode = n;
        this.modelv2expmodeDirtyFlag = true;
    }

    public Integer getModelV2ExpMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelV2ExpMode();
        }
        return this.modelv2expmode;
    }

    public boolean isModelV2ExpModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelV2ExpModeDirty();
        }
        return this.modelv2expmodeDirtyFlag;
    }

    public void resetModelV2ExpMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelV2ExpMode();
            return;
        }
        this.modelv2expmodeDirtyFlag = false;
        this.modelv2expmode = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setNoViewMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoViewMode(n);
            return;
        }
        this.noviewmode = n;
        this.noviewmodeDirtyFlag = true;
    }

    public Integer getNoViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoViewMode();
        }
        return this.noviewmode;
    }

    public boolean isNoViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoViewModeDirty();
        }
        return this.noviewmodeDirtyFlag;
    }

    public void resetNoViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoViewMode();
            return;
        }
        this.noviewmodeDirtyFlag = false;
        this.noviewmode = null;
    }

    public void setPIAutoShowCaption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPIAutoShowCaption(n);
            return;
        }
        this.piautoshowcaption = n;
        this.piautoshowcaptionDirtyFlag = true;
    }

    public Integer getPIAutoShowCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPIAutoShowCaption();
        }
        return this.piautoshowcaption;
    }

    public boolean isPIAutoShowCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPIAutoShowCaptionDirty();
        }
        return this.piautoshowcaptionDirtyFlag;
    }

    public void resetPIAutoShowCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPIAutoShowCaption();
            return;
        }
        this.piautoshowcaptionDirtyFlag = false;
        this.piautoshowcaption = null;
    }

    public void setPSDepSlnPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnprdid = string;
        this.psdepslnprdidDirtyFlag = true;
    }

    public String getPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPrdId();
        }
        return this.psdepslnprdid;
    }

    public boolean isPSDepSlnPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPrdIdDirty();
        }
        return this.psdepslnprdidDirtyFlag;
    }

    public void resetPSDepSlnPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPrdId();
            return;
        }
        this.psdepslnprdidDirtyFlag = false;
        this.psdepslnprdid = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevCenterTSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsid = string;
        this.psdevcentertsidDirtyFlag = true;
    }

    public String getPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSId();
        }
        return this.psdevcentertsid;
    }

    public boolean isPSDevCenterTSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSIdDirty();
        }
        return this.psdevcentertsidDirtyFlag;
    }

    public void resetPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSId();
            return;
        }
        this.psdevcentertsidDirtyFlag = false;
        this.psdevcentertsid = null;
    }

    public void setPSDevCenterTSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsname = string;
        this.psdevcentertsnameDirtyFlag = true;
    }

    public String getPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSName();
        }
        return this.psdevcentertsname;
    }

    public boolean isPSDevCenterTSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSNameDirty();
        }
        return this.psdevcentertsnameDirtyFlag;
    }

    public void resetPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSName();
            return;
        }
        this.psdevcentertsnameDirtyFlag = false;
        this.psdevcentertsname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSLanguageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageid = string;
        this.pslanguageidDirtyFlag = true;
    }

    public String getPSLanguageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageId();
        }
        return this.pslanguageid;
    }

    public boolean isPSLanguageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageIdDirty();
        }
        return this.pslanguageidDirtyFlag;
    }

    public void resetPSLanguageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageId();
            return;
        }
        this.pslanguageidDirtyFlag = false;
        this.pslanguageid = null;
    }

    public void setPSLanguageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguagename = string;
        this.pslanguagenameDirtyFlag = true;
    }

    public String getPSLanguageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageName();
        }
        return this.pslanguagename;
    }

    public boolean isPSLanguageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageNameDirty();
        }
        return this.pslanguagenameDirtyFlag;
    }

    public void resetPSLanguageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageName();
            return;
        }
        this.pslanguagenameDirtyFlag = false;
        this.pslanguagename = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFPubsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPubsCnt(n);
            return;
        }
        this.pssfpubscnt = n;
        this.pssfpubscntDirtyFlag = true;
    }

    public Integer getPSSFPubsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPubsCnt();
        }
        return this.pssfpubscnt;
    }

    public boolean isPSSFPubsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPubsCntDirty();
        }
        return this.pssfpubscntDirtyFlag;
    }

    public void resetPSSFPubsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPubsCnt();
            return;
        }
        this.pssfpubscntDirtyFlag = false;
        this.pssfpubscnt = null;
    }

    public void setPSSysDevBKTasksCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevBKTasksCnt(n);
            return;
        }
        this.pssysdevbktaskscnt = n;
        this.pssysdevbktaskscntDirtyFlag = true;
    }

    public Integer getPSSysDevBKTasksCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBKTasksCnt();
        }
        return this.pssysdevbktaskscnt;
    }

    public boolean isPSSysDevBKTasksCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevBKTasksCntDirty();
        }
        return this.pssysdevbktaskscntDirtyFlag;
    }

    public void resetPSSysDevBKTasksCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevBKTasksCnt();
            return;
        }
        this.pssysdevbktaskscntDirtyFlag = false;
        this.pssysdevbktaskscnt = null;
    }

    public void setPSSysEngineCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEngineCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysenginecfgid = string;
        this.pssysenginecfgidDirtyFlag = true;
    }

    public String getPSSysEngineCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEngineCfgId();
        }
        return this.pssysenginecfgid;
    }

    public boolean isPSSysEngineCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEngineCfgIdDirty();
        }
        return this.pssysenginecfgidDirtyFlag;
    }

    public void resetPSSysEngineCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEngineCfgId();
            return;
        }
        this.pssysenginecfgidDirtyFlag = false;
        this.pssysenginecfgid = null;
    }

    public void setPSSysEngineCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEngineCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysenginecfgname = string;
        this.pssysenginecfgnameDirtyFlag = true;
    }

    public String getPSSysEngineCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEngineCfgName();
        }
        return this.pssysenginecfgname;
    }

    public boolean isPSSysEngineCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEngineCfgNameDirty();
        }
        return this.pssysenginecfgnameDirtyFlag;
    }

    public void resetPSSysEngineCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEngineCfgName();
            return;
        }
        this.pssysenginecfgnameDirtyFlag = false;
        this.pssysenginecfgname = null;
    }

    public void setPSSysIssuesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssuesCnt(n);
            return;
        }
        this.pssysissuescnt = n;
        this.pssysissuescntDirtyFlag = true;
    }

    public Integer getPSSysIssuesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssuesCnt();
        }
        return this.pssysissuescnt;
    }

    public boolean isPSSysIssuesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssuesCntDirty();
        }
        return this.pssysissuescntDirtyFlag;
    }

    public void resetPSSysIssuesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssuesCnt();
            return;
        }
        this.pssysissuescntDirtyFlag = false;
        this.pssysissuescnt = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
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

    public void setPSWFsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFsCnt(n);
            return;
        }
        this.pswfscnt = n;
        this.pswfscntDirtyFlag = true;
    }

    public Integer getPSWFsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFsCnt();
        }
        return this.pswfscnt;
    }

    public boolean isPSWFsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFsCntDirty();
        }
        return this.pswfscntDirtyFlag;
    }

    public void resetPSWFsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFsCnt();
            return;
        }
        this.pswfscntDirtyFlag = false;
        this.pswfscnt = null;
    }

    public void setPubDBModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubDBModelFlag(n);
            return;
        }
        this.pubdbmodelflag = n;
        this.pubdbmodelflagDirtyFlag = true;
    }

    public Integer getPubDBModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubDBModelFlag();
        }
        return this.pubdbmodelflag;
    }

    public boolean isPubDBModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubDBModelFlagDirty();
        }
        return this.pubdbmodelflagDirtyFlag;
    }

    public void resetPubDBModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubDBModelFlag();
            return;
        }
        this.pubdbmodelflagDirtyFlag = false;
        this.pubdbmodelflag = null;
    }

    public void setSaaSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSaaSMode(n);
            return;
        }
        this.saasmode = n;
        this.saasmodeDirtyFlag = true;
    }

    public Integer getSaaSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSaaSMode();
        }
        return this.saasmode;
    }

    public boolean isSaaSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSaaSModeDirty();
        }
        return this.saasmodeDirtyFlag;
    }

    public void resetSaaSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSaaSMode();
            return;
        }
        this.saasmodeDirtyFlag = false;
        this.saasmode = null;
    }

    public void setScriptEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScriptEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.scriptengine = string;
        this.scriptengineDirtyFlag = true;
    }

    public String getScriptEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScriptEngine();
        }
        return this.scriptengine;
    }

    public boolean isScriptEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScriptEngineDirty();
        }
        return this.scriptengineDirtyFlag;
    }

    public void resetScriptEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScriptEngine();
            return;
        }
        this.scriptengineDirtyFlag = false;
        this.scriptengine = null;
    }

    public void setServiceAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceAPIFlag(n);
            return;
        }
        this.serviceapiflag = n;
        this.serviceapiflagDirtyFlag = true;
    }

    public Integer getServiceAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceAPIFlag();
        }
        return this.serviceapiflag;
    }

    public boolean isServiceAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceAPIFlagDirty();
        }
        return this.serviceapiflagDirtyFlag;
    }

    public void resetServiceAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceAPIFlag();
            return;
        }
        this.serviceapiflagDirtyFlag = false;
        this.serviceapiflag = null;
    }

    public void setSimActionLogics(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSimActionLogics(n);
            return;
        }
        this.simactionlogics = n;
        this.simactionlogicsDirtyFlag = true;
    }

    public Integer getSimActionLogics() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSimActionLogics();
        }
        return this.simactionlogics;
    }

    public boolean isSimActionLogicsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSimActionLogicsDirty();
        }
        return this.simactionlogicsDirtyFlag;
    }

    public void resetSimActionLogics() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSimActionLogics();
            return;
        }
        this.simactionlogicsDirtyFlag = false;
        this.simactionlogics = null;
    }

    public void setSrcPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssystemid = string;
        this.srcpssystemidDirtyFlag = true;
    }

    public String getSrcPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSystemId();
        }
        return this.srcpssystemid;
    }

    public boolean isSrcPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSystemIdDirty();
        }
        return this.srcpssystemidDirtyFlag;
    }

    public void resetSrcPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSystemId();
            return;
        }
        this.srcpssystemidDirtyFlag = false;
        this.srcpssystemid = null;
    }

    public void setSrcPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpssystemname = string;
        this.srcpssystemnameDirtyFlag = true;
    }

    public String getSrcPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSystemName();
        }
        return this.srcpssystemname;
    }

    public boolean isSrcPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSSystemNameDirty();
        }
        return this.srcpssystemnameDirtyFlag;
    }

    public void resetSrcPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSSystemName();
            return;
        }
        this.srcpssystemnameDirtyFlag = false;
        this.srcpssystemname = null;
    }

    public void setSSDEMSActionLogicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSDEMSActionLogicFlag(n);
            return;
        }
        this.ssdemsactionlogicflag = n;
        this.ssdemsactionlogicflagDirtyFlag = true;
    }

    public Integer getSSDEMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSDEMSActionLogicFlag();
        }
        return this.ssdemsactionlogicflag;
    }

    public boolean isSSDEMSActionLogicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSDEMSActionLogicFlagDirty();
        }
        return this.ssdemsactionlogicflagDirtyFlag;
    }

    public void resetSSDEMSActionLogicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSDEMSActionLogicFlag();
            return;
        }
        this.ssdemsactionlogicflagDirtyFlag = false;
        this.ssdemsactionlogicflag = null;
    }

    public void setSysFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysfolder = string;
        this.sysfolderDirtyFlag = true;
    }

    public String getSysFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysFolder();
        }
        return this.sysfolder;
    }

    public boolean isSysFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysFolderDirty();
        }
        return this.sysfolderDirtyFlag;
    }

    public void resetSysFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysFolder();
            return;
        }
        this.sysfolderDirtyFlag = false;
        this.sysfolder = null;
    }

    public void setSysRowKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRowKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysrowkey = string;
        this.sysrowkeyDirtyFlag = true;
    }

    public String getSysRowKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRowKey();
        }
        return this.sysrowkey;
    }

    public boolean isSysRowKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRowKeyDirty();
        }
        return this.sysrowkeyDirtyFlag;
    }

    public void resetSysRowKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRowKey();
            return;
        }
        this.sysrowkeyDirtyFlag = false;
        this.sysrowkey = null;
    }

    public void setSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systype = string;
        this.systypeDirtyFlag = true;
    }

    public String getSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysType();
        }
        return this.systype;
    }

    public boolean isSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTypeDirty();
        }
        return this.systypeDirtyFlag;
    }

    public void resetSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysType();
            return;
        }
        this.systypeDirtyFlag = false;
        this.systype = null;
    }

    public void setSysVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysver = string;
        this.sysverDirtyFlag = true;
    }

    public String getSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVer();
        }
        return this.sysver;
    }

    public boolean isSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerDirty();
        }
        return this.sysverDirtyFlag;
    }

    public void resetSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVer();
            return;
        }
        this.sysverDirtyFlag = false;
        this.sysver = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
    }

    public void setTemplEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templengine = string;
        this.templengineDirtyFlag = true;
    }

    public String getTemplEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplEngine();
        }
        return this.templengine;
    }

    public boolean isTemplEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplEngineDirty();
        }
        return this.templengineDirtyFlag;
    }

    public void resetTemplEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplEngine();
            return;
        }
        this.templengineDirtyFlag = false;
        this.templengine = null;
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

    public void setViewUARegMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewUARegMode(n);
            return;
        }
        this.viewuaregmode = n;
        this.viewuaregmodeDirtyFlag = true;
    }

    public Integer getViewUARegMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewUARegMode();
        }
        return this.viewuaregmode;
    }

    public boolean isViewUARegModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewUARegModeDirty();
        }
        return this.viewuaregmodeDirtyFlag;
    }

    public void resetViewUARegMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewUARegMode();
            return;
        }
        this.viewuaregmodeDirtyFlag = false;
        this.viewuaregmode = null;
    }

    public void setWebPSAppsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebPSAppsCnt(n);
            return;
        }
        this.webpsappscnt = n;
        this.webpsappscntDirtyFlag = true;
    }

    public Integer getWebPSAppsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebPSAppsCnt();
        }
        return this.webpsappscnt;
    }

    public boolean isWebPSAppsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebPSAppsCntDirty();
        }
        return this.webpsappscntDirtyFlag;
    }

    public void resetWebPSAppsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebPSAppsCnt();
            return;
        }
        this.webpsappscntDirtyFlag = false;
        this.webpsappscnt = null;
    }

    protected void onReset() {
        PSSystemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSystemBase pSSystemBase) {
        pSSystemBase.resetAccCtrlArch();
        pSSystemBase.resetAutoCalcDERER();
        pSSystemBase.resetBugFixs();
        pSSystemBase.resetCheckModelVer();
        pSSystemBase.resetCLEmptyText();
        pSSystemBase.resetCLEmptyTextPSLanResId();
        pSSystemBase.resetCLEmptyTextPSLanResName();
        pSSystemBase.resetCodeName();
        pSSystemBase.resetCodeNameMode();
        pSSystemBase.resetCreateDate();
        pSSystemBase.resetCreateMan();
        pSSystemBase.resetCtrlAppendDEItems();
        pSSystemBase.resetCustomCode();
        pSSystemBase.resetCustomMode();
        pSSystemBase.resetDBTypes();
        pSSystemBase.resetDBVersion();
        pSSystemBase.resetDEDSMaxRowCnt();
        pSSystemBase.resetDEExpMaxRowCnt();
        pSSystemBase.resetDEFPSSysDeployId();
        pSSystemBase.resetDEFSFItemWidth();
        pSSystemBase.resetDEFSortMode();
        pSSystemBase.resetDEMSActionLogicFlag();
        pSSystemBase.resetDomainName();
        pSSystemBase.resetDTOFormat();
        pSSystemBase.resetEnableDBValueMode();
        pSSystemBase.resetEnableDEDataVer();
        pSSystemBase.resetEnableDEFRestrictedUI();
        pSSystemBase.resetEnableDERFKey();
        pSSystemBase.resetEnableDynaSys();
        pSSystemBase.resetEnableFolderKey();
        pSSystemBase.resetEnableMultiLan();
        pSSystemBase.resetEnableOPNameModel();
        pSSystemBase.resetEnablePQL();
        pSSystemBase.resetEnaDefLanResContent();
        pSSystemBase.resetEntityCnt();
        pSSystemBase.resetExtractDefault();
        pSSystemBase.resetInitDEDefault();
        pSSystemBase.resetLanResMaxTag();
        pSSystemBase.resetLogicName();
        pSSystemBase.resetLowCodeMode();
        pSSystemBase.resetLowCodeOption();
        pSSystemBase.resetMaxEntityCnt();
        pSSystemBase.resetMemo();
        pSSystemBase.resetMobPSAppsCnt();
        pSSystemBase.resetModelV2ExpMode();
        pSSystemBase.resetModelVer();
        pSSystemBase.resetNoViewMode();
        pSSystemBase.resetPIAutoShowCaption();
        pSSystemBase.resetPSDepSlnPrdId();
        pSSystemBase.resetPSDevCenterId();
        pSSystemBase.resetPSDevCenterName();
        pSSystemBase.resetPSDevCenterTSId();
        pSSystemBase.resetPSDevCenterTSName();
        pSSystemBase.resetPSDevSlnId();
        pSSystemBase.resetPSDevSlnName();
        pSSystemBase.resetPSDevSlnSysId();
        pSSystemBase.resetPSLanguageId();
        pSSystemBase.resetPSLanguageName();
        pSSystemBase.resetPSSFId();
        pSSystemBase.resetPSSFName();
        pSSystemBase.resetPSSFPubsCnt();
        pSSystemBase.resetPSSysDevBKTasksCnt();
        pSSystemBase.resetPSSysEngineCfgId();
        pSSystemBase.resetPSSysEngineCfgName();
        pSSystemBase.resetPSSysIssuesCnt();
        pSSystemBase.resetPSSysModelInstId();
        pSSystemBase.resetPSSysTasksCnt();
        pSSystemBase.resetPSSystemId();
        pSSystemBase.resetPSSystemName();
        pSSystemBase.resetPSWFsCnt();
        pSSystemBase.resetPubDBModelFlag();
        pSSystemBase.resetSaaSMode();
        pSSystemBase.resetScriptEngine();
        pSSystemBase.resetServiceAPIFlag();
        pSSystemBase.resetSimActionLogics();
        pSSystemBase.resetSrcPSSystemId();
        pSSystemBase.resetSrcPSSystemName();
        pSSystemBase.resetSSDEMSActionLogicFlag();
        pSSystemBase.resetSysFolder();
        pSSystemBase.resetSysRowKey();
        pSSystemBase.resetSysType();
        pSSystemBase.resetSysVer();
        pSSystemBase.resetTags();
        pSSystemBase.resetTemplEngine();
        pSSystemBase.resetUpdateDate();
        pSSystemBase.resetUpdateMan();
        pSSystemBase.resetUserParams();
        pSSystemBase.resetViewUARegMode();
        pSSystemBase.resetWebPSAppsCnt();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAccCtrlArchDirty()) {
            hashMap.put(FIELD_ACCCTRLARCH, this.getAccCtrlArch());
        }
        if (!bl || this.isAutoCalcDERERDirty()) {
            hashMap.put(FIELD_AUTOCALCDERER, this.getAutoCalcDERER());
        }
        if (!bl || this.isBugFixsDirty()) {
            hashMap.put(FIELD_BUGFIXS, this.getBugFixs());
        }
        if (!bl || this.isCheckModelVerDirty()) {
            hashMap.put(FIELD_CHECKMODELVER, this.getCheckModelVer());
        }
        if (!bl || this.isCLEmptyTextDirty()) {
            hashMap.put(FIELD_CLEMPTYTEXT, this.getCLEmptyText());
        }
        if (!bl || this.isCLEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_CLEMPTYTEXTPSLANRESID, this.getCLEmptyTextPSLanResId());
        }
        if (!bl || this.isCLEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_CLEMPTYTEXTPSLANRESNAME, this.getCLEmptyTextPSLanResName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isCtrlAppendDEItemsDirty()) {
            hashMap.put(FIELD_CTRLAPPENDDEITEMS, this.getCtrlAppendDEItems());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDBTypesDirty()) {
            hashMap.put(FIELD_DBTYPES, this.getDBTypes());
        }
        if (!bl || this.isDBVersionDirty()) {
            hashMap.put(FIELD_DBVERSION, this.getDBVersion());
        }
        if (!bl || this.isDEDSMaxRowCntDirty()) {
            hashMap.put(FIELD_DEDSMAXROWCNT, this.getDEDSMaxRowCnt());
        }
        if (!bl || this.isDEExpMaxRowCntDirty()) {
            hashMap.put(FIELD_DEEXPMAXROWCNT, this.getDEExpMaxRowCnt());
        }
        if (!bl || this.isDEFPSSysDeployIdDirty()) {
            hashMap.put(FIELD_DEFPSSYSDEPLOYID, this.getDEFPSSysDeployId());
        }
        if (!bl || this.isDEFSFItemWidthDirty()) {
            hashMap.put(FIELD_DEFSFITEMWIDTH, this.getDEFSFItemWidth());
        }
        if (!bl || this.isDEFSortModeDirty()) {
            hashMap.put(FIELD_DEFSORTMODE, this.getDEFSortMode());
        }
        if (!bl || this.isDEMSActionLogicFlagDirty()) {
            hashMap.put(FIELD_DEMSACTIONLOGICFLAG, this.getDEMSActionLogicFlag());
        }
        if (!bl || this.isDomainNameDirty()) {
            hashMap.put(FIELD_DOMAINNAME, this.getDomainName());
        }
        if (!bl || this.isDTOFormatDirty()) {
            hashMap.put(FIELD_DTOFORMAT, this.getDTOFormat());
        }
        if (!bl || this.isEnableDBValueModeDirty()) {
            hashMap.put(FIELD_ENABLEDBVALUEMODE, this.getEnableDBValueMode());
        }
        if (!bl || this.isEnableDEDataVerDirty()) {
            hashMap.put(FIELD_ENABLEDEDATAVER, this.getEnableDEDataVer());
        }
        if (!bl || this.isEnableDEFRestrictedUIDirty()) {
            hashMap.put(FIELD_ENABLEDEFRESTRICTEDUI, this.getEnableDEFRestrictedUI());
        }
        if (!bl || this.isEnableDERFKeyDirty()) {
            hashMap.put(FIELD_ENABLEDERFKEY, this.getEnableDERFKey());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isEnableFolderKeyDirty()) {
            hashMap.put(FIELD_ENABLEFOLDERKEY, this.getEnableFolderKey());
        }
        if (!bl || this.isEnableMultiLanDirty()) {
            hashMap.put(FIELD_ENABLEMULTILAN, this.getEnableMultiLan());
        }
        if (!bl || this.isEnableOPNameModelDirty()) {
            hashMap.put(FIELD_ENABLEOPNAMEMODEL, this.getEnableOPNameModel());
        }
        if (!bl || this.isEnablePQLDirty()) {
            hashMap.put(FIELD_ENABLEPQL, this.getEnablePQL());
        }
        if (!bl || this.isEnaDefLanResContentDirty()) {
            hashMap.put(FIELD_ENADEFLANRESCONTENT, this.getEnaDefLanResContent());
        }
        if (!bl || this.isEntityCntDirty()) {
            hashMap.put(FIELD_ENTITYCNT, this.getEntityCnt());
        }
        if (!bl || this.isExtractDefaultDirty()) {
            hashMap.put(FIELD_EXTRACTDEFAULT, this.getExtractDefault());
        }
        if (!bl || this.isInitDEDefaultDirty()) {
            hashMap.put(FIELD_INITDEDEFAULT, this.getInitDEDefault());
        }
        if (!bl || this.isLanResMaxTagDirty()) {
            hashMap.put(FIELD_LANRESMAXTAG, this.getLanResMaxTag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isLowCodeModeDirty()) {
            hashMap.put(FIELD_LOWCODEMODE, this.getLowCodeMode());
        }
        if (!bl || this.isLowCodeOptionDirty()) {
            hashMap.put(FIELD_LOWCODEOPTION, this.getLowCodeOption());
        }
        if (!bl || this.isMaxEntityCntDirty()) {
            hashMap.put(FIELD_MAXENTITYCNT, this.getMaxEntityCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobPSAppsCntDirty()) {
            hashMap.put(FIELD_MOBPSAPPSCNT, this.getMobPSAppsCnt());
        }
        if (!bl || this.isModelV2ExpModeDirty()) {
            hashMap.put(FIELD_MODELV2EXPMODE, this.getModelV2ExpMode());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isNoViewModeDirty()) {
            hashMap.put(FIELD_NOVIEWMODE, this.getNoViewMode());
        }
        if (!bl || this.isPIAutoShowCaptionDirty()) {
            hashMap.put(FIELD_PIAUTOSHOWCAPTION, this.getPIAutoShowCaption());
        }
        if (!bl || this.isPSDepSlnPrdIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPRDID, this.getPSDepSlnPrdId());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterTSIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSID, this.getPSDevCenterTSId());
        }
        if (!bl || this.isPSDevCenterTSNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSNAME, this.getPSDevCenterTSName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSLanguageIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGEID, this.getPSLanguageId());
        }
        if (!bl || this.isPSLanguageNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGENAME, this.getPSLanguageName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPubsCntDirty()) {
            hashMap.put(FIELD_PSSFPUBSCNT, this.getPSSFPubsCnt());
        }
        if (!bl || this.isPSSysDevBKTasksCntDirty()) {
            hashMap.put(FIELD_PSSYSDEVBKTASKSCNT, this.getPSSysDevBKTasksCnt());
        }
        if (!bl || this.isPSSysEngineCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSENGINECFGID, this.getPSSysEngineCfgId());
        }
        if (!bl || this.isPSSysEngineCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSENGINECFGNAME, this.getPSSysEngineCfgName());
        }
        if (!bl || this.isPSSysIssuesCntDirty()) {
            hashMap.put(FIELD_PSSYSISSUESCNT, this.getPSSysIssuesCnt());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
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
        if (!bl || this.isPSWFsCntDirty()) {
            hashMap.put(FIELD_PSWFSCNT, this.getPSWFsCnt());
        }
        if (!bl || this.isPubDBModelFlagDirty()) {
            hashMap.put(FIELD_PUBDBMODELFLAG, this.getPubDBModelFlag());
        }
        if (!bl || this.isSaaSModeDirty()) {
            hashMap.put(FIELD_SAASMODE, this.getSaaSMode());
        }
        if (!bl || this.isScriptEngineDirty()) {
            hashMap.put(FIELD_SCRIPTENGINE, this.getScriptEngine());
        }
        if (!bl || this.isServiceAPIFlagDirty()) {
            hashMap.put(FIELD_SERVICEAPIFLAG, this.getServiceAPIFlag());
        }
        if (!bl || this.isSimActionLogicsDirty()) {
            hashMap.put(FIELD_SIMACTIONLOGICS, this.getSimActionLogics());
        }
        if (!bl || this.isSrcPSSystemIdDirty()) {
            hashMap.put(FIELD_SRCPSSYSTEMID, this.getSrcPSSystemId());
        }
        if (!bl || this.isSrcPSSystemNameDirty()) {
            hashMap.put(FIELD_SRCPSSYSTEMNAME, this.getSrcPSSystemName());
        }
        if (!bl || this.isSSDEMSActionLogicFlagDirty()) {
            hashMap.put(FIELD_SSDEMSACTIONLOGICFLAG, this.getSSDEMSActionLogicFlag());
        }
        if (!bl || this.isSysFolderDirty()) {
            hashMap.put(FIELD_SYSFOLDER, this.getSysFolder());
        }
        if (!bl || this.isSysRowKeyDirty()) {
            hashMap.put(FIELD_SYSROWKEY, this.getSysRowKey());
        }
        if (!bl || this.isSysTypeDirty()) {
            hashMap.put(FIELD_SYSTYPE, this.getSysType());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isTemplEngineDirty()) {
            hashMap.put(FIELD_TEMPLENGINE, this.getTemplEngine());
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
        if (!bl || this.isViewUARegModeDirty()) {
            hashMap.put(FIELD_VIEWUAREGMODE, this.getViewUARegMode());
        }
        if (!bl || this.isWebPSAppsCntDirty()) {
            hashMap.put(FIELD_WEBPSAPPSCNT, this.getWebPSAppsCnt());
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
        return PSSystemBase.get(this, n);
    }

    private static Object get(PSSystemBase pSSystemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemBase.getAccCtrlArch();
            }
            case 1: {
                return pSSystemBase.getAutoCalcDERER();
            }
            case 2: {
                return pSSystemBase.getBugFixs();
            }
            case 3: {
                return pSSystemBase.getCheckModelVer();
            }
            case 4: {
                return pSSystemBase.getCLEmptyText();
            }
            case 5: {
                return pSSystemBase.getCLEmptyTextPSLanResId();
            }
            case 6: {
                return pSSystemBase.getCLEmptyTextPSLanResName();
            }
            case 7: {
                return pSSystemBase.getCodeName();
            }
            case 8: {
                return pSSystemBase.getCodeNameMode();
            }
            case 9: {
                return pSSystemBase.getCreateDate();
            }
            case 10: {
                return pSSystemBase.getCreateMan();
            }
            case 11: {
                return pSSystemBase.getCtrlAppendDEItems();
            }
            case 12: {
                return pSSystemBase.getCustomCode();
            }
            case 13: {
                return pSSystemBase.getCustomMode();
            }
            case 14: {
                return pSSystemBase.getDBTypes();
            }
            case 15: {
                return pSSystemBase.getDBVersion();
            }
            case 16: {
                return pSSystemBase.getDEDSMaxRowCnt();
            }
            case 17: {
                return pSSystemBase.getDEExpMaxRowCnt();
            }
            case 18: {
                return pSSystemBase.getDEFPSSysDeployId();
            }
            case 19: {
                return pSSystemBase.getDEFSFItemWidth();
            }
            case 20: {
                return pSSystemBase.getDEFSortMode();
            }
            case 21: {
                return pSSystemBase.getDEMSActionLogicFlag();
            }
            case 22: {
                return pSSystemBase.getDomainName();
            }
            case 23: {
                return pSSystemBase.getDTOFormat();
            }
            case 24: {
                return pSSystemBase.getEnableDBValueMode();
            }
            case 25: {
                return pSSystemBase.getEnableDEDataVer();
            }
            case 26: {
                return pSSystemBase.getEnableDEFRestrictedUI();
            }
            case 27: {
                return pSSystemBase.getEnableDERFKey();
            }
            case 28: {
                return pSSystemBase.getEnableDynaSys();
            }
            case 29: {
                return pSSystemBase.getEnableFolderKey();
            }
            case 30: {
                return pSSystemBase.getEnableMultiLan();
            }
            case 31: {
                return pSSystemBase.getEnableOPNameModel();
            }
            case 32: {
                return pSSystemBase.getEnablePQL();
            }
            case 33: {
                return pSSystemBase.getEnaDefLanResContent();
            }
            case 34: {
                return pSSystemBase.getEntityCnt();
            }
            case 35: {
                return pSSystemBase.getExtractDefault();
            }
            case 36: {
                return pSSystemBase.getInitDEDefault();
            }
            case 37: {
                return pSSystemBase.getLanResMaxTag();
            }
            case 38: {
                return pSSystemBase.getLogicName();
            }
            case 39: {
                return pSSystemBase.getLowCodeMode();
            }
            case 40: {
                return pSSystemBase.getLowCodeOption();
            }
            case 41: {
                return pSSystemBase.getMaxEntityCnt();
            }
            case 42: {
                return pSSystemBase.getMemo();
            }
            case 43: {
                return pSSystemBase.getMobPSAppsCnt();
            }
            case 44: {
                return pSSystemBase.getModelV2ExpMode();
            }
            case 45: {
                return pSSystemBase.getModelVer();
            }
            case 46: {
                return pSSystemBase.getNoViewMode();
            }
            case 47: {
                return pSSystemBase.getPIAutoShowCaption();
            }
            case 48: {
                return pSSystemBase.getPSDepSlnPrdId();
            }
            case 49: {
                return pSSystemBase.getPSDevCenterId();
            }
            case 50: {
                return pSSystemBase.getPSDevCenterName();
            }
            case 51: {
                return pSSystemBase.getPSDevCenterTSId();
            }
            case 52: {
                return pSSystemBase.getPSDevCenterTSName();
            }
            case 53: {
                return pSSystemBase.getPSDevSlnId();
            }
            case 54: {
                return pSSystemBase.getPSDevSlnName();
            }
            case 55: {
                return pSSystemBase.getPSDevSlnSysId();
            }
            case 56: {
                return pSSystemBase.getPSLanguageId();
            }
            case 57: {
                return pSSystemBase.getPSLanguageName();
            }
            case 58: {
                return pSSystemBase.getPSSFId();
            }
            case 59: {
                return pSSystemBase.getPSSFName();
            }
            case 60: {
                return pSSystemBase.getPSSFPubsCnt();
            }
            case 61: {
                return pSSystemBase.getPSSysDevBKTasksCnt();
            }
            case 62: {
                return pSSystemBase.getPSSysEngineCfgId();
            }
            case 63: {
                return pSSystemBase.getPSSysEngineCfgName();
            }
            case 64: {
                return pSSystemBase.getPSSysIssuesCnt();
            }
            case 65: {
                return pSSystemBase.getPSSysModelInstId();
            }
            case 66: {
                return pSSystemBase.getPSSysTasksCnt();
            }
            case 67: {
                return pSSystemBase.getPSSystemId();
            }
            case 68: {
                return pSSystemBase.getPSSystemName();
            }
            case 69: {
                return pSSystemBase.getPSWFsCnt();
            }
            case 70: {
                return pSSystemBase.getPubDBModelFlag();
            }
            case 71: {
                return pSSystemBase.getSaaSMode();
            }
            case 72: {
                return pSSystemBase.getScriptEngine();
            }
            case 73: {
                return pSSystemBase.getServiceAPIFlag();
            }
            case 74: {
                return pSSystemBase.getSimActionLogics();
            }
            case 75: {
                return pSSystemBase.getSrcPSSystemId();
            }
            case 76: {
                return pSSystemBase.getSrcPSSystemName();
            }
            case 77: {
                return pSSystemBase.getSSDEMSActionLogicFlag();
            }
            case 78: {
                return pSSystemBase.getSysFolder();
            }
            case 79: {
                return pSSystemBase.getSysRowKey();
            }
            case 80: {
                return pSSystemBase.getSysType();
            }
            case 81: {
                return pSSystemBase.getSysVer();
            }
            case 82: {
                return pSSystemBase.getTags();
            }
            case 83: {
                return pSSystemBase.getTemplEngine();
            }
            case 84: {
                return pSSystemBase.getUpdateDate();
            }
            case 85: {
                return pSSystemBase.getUpdateMan();
            }
            case 86: {
                return pSSystemBase.getUserParams();
            }
            case 87: {
                return pSSystemBase.getViewUARegMode();
            }
            case 88: {
                return pSSystemBase.getWebPSAppsCnt();
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
        PSSystemBase.set(this, n, object);
    }

    private static void set(PSSystemBase pSSystemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSystemBase.setAccCtrlArch(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSystemBase.setAutoCalcDERER(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSystemBase.setBugFixs(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSystemBase.setCheckModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSystemBase.setCLEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSystemBase.setCLEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSystemBase.setCLEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSystemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSystemBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSystemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSystemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSystemBase.setCtrlAppendDEItems(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSystemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSystemBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSystemBase.setDBTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSystemBase.setDBVersion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSystemBase.setDEDSMaxRowCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSystemBase.setDEExpMaxRowCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSystemBase.setDEFPSSysDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSystemBase.setDEFSFItemWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSystemBase.setDEFSortMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSystemBase.setDEMSActionLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSystemBase.setDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSystemBase.setDTOFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSystemBase.setEnableDBValueMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSystemBase.setEnableDEDataVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSystemBase.setEnableDEFRestrictedUI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSystemBase.setEnableDERFKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSystemBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSystemBase.setEnableFolderKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSystemBase.setEnableMultiLan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSystemBase.setEnableOPNameModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSystemBase.setEnablePQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSystemBase.setEnaDefLanResContent(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSystemBase.setEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSystemBase.setExtractDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSystemBase.setInitDEDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSystemBase.setLanResMaxTag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSystemBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSystemBase.setLowCodeMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSSystemBase.setLowCodeOption(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSystemBase.setMaxEntityCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSSystemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSystemBase.setMobPSAppsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSystemBase.setModelV2ExpMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSSystemBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSSystemBase.setNoViewMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSSystemBase.setPIAutoShowCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSSystemBase.setPSDepSlnPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSystemBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSystemBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSystemBase.setPSDevCenterTSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSystemBase.setPSDevCenterTSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSystemBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSystemBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSSystemBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSystemBase.setPSLanguageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSystemBase.setPSLanguageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSystemBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSSystemBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSystemBase.setPSSFPubsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSSystemBase.setPSSysDevBKTasksCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 62: {
                pSSystemBase.setPSSysEngineCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSSystemBase.setPSSysEngineCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSystemBase.setPSSysIssuesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSSystemBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSystemBase.setPSSysTasksCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSSystemBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSystemBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSystemBase.setPSWFsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSSystemBase.setPubDBModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSSystemBase.setSaaSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSSystemBase.setScriptEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSystemBase.setServiceAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 74: {
                pSSystemBase.setSimActionLogics(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSSystemBase.setSrcPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSystemBase.setSrcPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSSystemBase.setSSDEMSActionLogicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSSystemBase.setSysFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSSystemBase.setSysRowKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSystemBase.setSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSystemBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSystemBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSSystemBase.setTemplEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSSystemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 85: {
                pSSystemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSSystemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSSystemBase.setViewUARegMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSSystemBase.setWebPSAppsCnt(DataObject.getIntegerValue((Object)object));
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
        return PSSystemBase.isNull(this, n);
    }

    private static boolean isNull(PSSystemBase pSSystemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemBase.getAccCtrlArch() == null;
            }
            case 1: {
                return pSSystemBase.getAutoCalcDERER() == null;
            }
            case 2: {
                return pSSystemBase.getBugFixs() == null;
            }
            case 3: {
                return pSSystemBase.getCheckModelVer() == null;
            }
            case 4: {
                return pSSystemBase.getCLEmptyText() == null;
            }
            case 5: {
                return pSSystemBase.getCLEmptyTextPSLanResId() == null;
            }
            case 6: {
                return pSSystemBase.getCLEmptyTextPSLanResName() == null;
            }
            case 7: {
                return pSSystemBase.getCodeName() == null;
            }
            case 8: {
                return pSSystemBase.getCodeNameMode() == null;
            }
            case 9: {
                return pSSystemBase.getCreateDate() == null;
            }
            case 10: {
                return pSSystemBase.getCreateMan() == null;
            }
            case 11: {
                return pSSystemBase.getCtrlAppendDEItems() == null;
            }
            case 12: {
                return pSSystemBase.getCustomCode() == null;
            }
            case 13: {
                return pSSystemBase.getCustomMode() == null;
            }
            case 14: {
                return pSSystemBase.getDBTypes() == null;
            }
            case 15: {
                return pSSystemBase.getDBVersion() == null;
            }
            case 16: {
                return pSSystemBase.getDEDSMaxRowCnt() == null;
            }
            case 17: {
                return pSSystemBase.getDEExpMaxRowCnt() == null;
            }
            case 18: {
                return pSSystemBase.getDEFPSSysDeployId() == null;
            }
            case 19: {
                return pSSystemBase.getDEFSFItemWidth() == null;
            }
            case 20: {
                return pSSystemBase.getDEFSortMode() == null;
            }
            case 21: {
                return pSSystemBase.getDEMSActionLogicFlag() == null;
            }
            case 22: {
                return pSSystemBase.getDomainName() == null;
            }
            case 23: {
                return pSSystemBase.getDTOFormat() == null;
            }
            case 24: {
                return pSSystemBase.getEnableDBValueMode() == null;
            }
            case 25: {
                return pSSystemBase.getEnableDEDataVer() == null;
            }
            case 26: {
                return pSSystemBase.getEnableDEFRestrictedUI() == null;
            }
            case 27: {
                return pSSystemBase.getEnableDERFKey() == null;
            }
            case 28: {
                return pSSystemBase.getEnableDynaSys() == null;
            }
            case 29: {
                return pSSystemBase.getEnableFolderKey() == null;
            }
            case 30: {
                return pSSystemBase.getEnableMultiLan() == null;
            }
            case 31: {
                return pSSystemBase.getEnableOPNameModel() == null;
            }
            case 32: {
                return pSSystemBase.getEnablePQL() == null;
            }
            case 33: {
                return pSSystemBase.getEnaDefLanResContent() == null;
            }
            case 34: {
                return pSSystemBase.getEntityCnt() == null;
            }
            case 35: {
                return pSSystemBase.getExtractDefault() == null;
            }
            case 36: {
                return pSSystemBase.getInitDEDefault() == null;
            }
            case 37: {
                return pSSystemBase.getLanResMaxTag() == null;
            }
            case 38: {
                return pSSystemBase.getLogicName() == null;
            }
            case 39: {
                return pSSystemBase.getLowCodeMode() == null;
            }
            case 40: {
                return pSSystemBase.getLowCodeOption() == null;
            }
            case 41: {
                return pSSystemBase.getMaxEntityCnt() == null;
            }
            case 42: {
                return pSSystemBase.getMemo() == null;
            }
            case 43: {
                return pSSystemBase.getMobPSAppsCnt() == null;
            }
            case 44: {
                return pSSystemBase.getModelV2ExpMode() == null;
            }
            case 45: {
                return pSSystemBase.getModelVer() == null;
            }
            case 46: {
                return pSSystemBase.getNoViewMode() == null;
            }
            case 47: {
                return pSSystemBase.getPIAutoShowCaption() == null;
            }
            case 48: {
                return pSSystemBase.getPSDepSlnPrdId() == null;
            }
            case 49: {
                return pSSystemBase.getPSDevCenterId() == null;
            }
            case 50: {
                return pSSystemBase.getPSDevCenterName() == null;
            }
            case 51: {
                return pSSystemBase.getPSDevCenterTSId() == null;
            }
            case 52: {
                return pSSystemBase.getPSDevCenterTSName() == null;
            }
            case 53: {
                return pSSystemBase.getPSDevSlnId() == null;
            }
            case 54: {
                return pSSystemBase.getPSDevSlnName() == null;
            }
            case 55: {
                return pSSystemBase.getPSDevSlnSysId() == null;
            }
            case 56: {
                return pSSystemBase.getPSLanguageId() == null;
            }
            case 57: {
                return pSSystemBase.getPSLanguageName() == null;
            }
            case 58: {
                return pSSystemBase.getPSSFId() == null;
            }
            case 59: {
                return pSSystemBase.getPSSFName() == null;
            }
            case 60: {
                return pSSystemBase.getPSSFPubsCnt() == null;
            }
            case 61: {
                return pSSystemBase.getPSSysDevBKTasksCnt() == null;
            }
            case 62: {
                return pSSystemBase.getPSSysEngineCfgId() == null;
            }
            case 63: {
                return pSSystemBase.getPSSysEngineCfgName() == null;
            }
            case 64: {
                return pSSystemBase.getPSSysIssuesCnt() == null;
            }
            case 65: {
                return pSSystemBase.getPSSysModelInstId() == null;
            }
            case 66: {
                return pSSystemBase.getPSSysTasksCnt() == null;
            }
            case 67: {
                return pSSystemBase.getPSSystemId() == null;
            }
            case 68: {
                return pSSystemBase.getPSSystemName() == null;
            }
            case 69: {
                return pSSystemBase.getPSWFsCnt() == null;
            }
            case 70: {
                return pSSystemBase.getPubDBModelFlag() == null;
            }
            case 71: {
                return pSSystemBase.getSaaSMode() == null;
            }
            case 72: {
                return pSSystemBase.getScriptEngine() == null;
            }
            case 73: {
                return pSSystemBase.getServiceAPIFlag() == null;
            }
            case 74: {
                return pSSystemBase.getSimActionLogics() == null;
            }
            case 75: {
                return pSSystemBase.getSrcPSSystemId() == null;
            }
            case 76: {
                return pSSystemBase.getSrcPSSystemName() == null;
            }
            case 77: {
                return pSSystemBase.getSSDEMSActionLogicFlag() == null;
            }
            case 78: {
                return pSSystemBase.getSysFolder() == null;
            }
            case 79: {
                return pSSystemBase.getSysRowKey() == null;
            }
            case 80: {
                return pSSystemBase.getSysType() == null;
            }
            case 81: {
                return pSSystemBase.getSysVer() == null;
            }
            case 82: {
                return pSSystemBase.getTags() == null;
            }
            case 83: {
                return pSSystemBase.getTemplEngine() == null;
            }
            case 84: {
                return pSSystemBase.getUpdateDate() == null;
            }
            case 85: {
                return pSSystemBase.getUpdateMan() == null;
            }
            case 86: {
                return pSSystemBase.getUserParams() == null;
            }
            case 87: {
                return pSSystemBase.getViewUARegMode() == null;
            }
            case 88: {
                return pSSystemBase.getWebPSAppsCnt() == null;
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
        return PSSystemBase.contains(this, n);
    }

    private static boolean contains(PSSystemBase pSSystemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSystemBase.isAccCtrlArchDirty();
            }
            case 1: {
                return pSSystemBase.isAutoCalcDERERDirty();
            }
            case 2: {
                return pSSystemBase.isBugFixsDirty();
            }
            case 3: {
                return pSSystemBase.isCheckModelVerDirty();
            }
            case 4: {
                return pSSystemBase.isCLEmptyTextDirty();
            }
            case 5: {
                return pSSystemBase.isCLEmptyTextPSLanResIdDirty();
            }
            case 6: {
                return pSSystemBase.isCLEmptyTextPSLanResNameDirty();
            }
            case 7: {
                return pSSystemBase.isCodeNameDirty();
            }
            case 8: {
                return pSSystemBase.isCodeNameModeDirty();
            }
            case 9: {
                return pSSystemBase.isCreateDateDirty();
            }
            case 10: {
                return pSSystemBase.isCreateManDirty();
            }
            case 11: {
                return pSSystemBase.isCtrlAppendDEItemsDirty();
            }
            case 12: {
                return pSSystemBase.isCustomCodeDirty();
            }
            case 13: {
                return pSSystemBase.isCustomModeDirty();
            }
            case 14: {
                return pSSystemBase.isDBTypesDirty();
            }
            case 15: {
                return pSSystemBase.isDBVersionDirty();
            }
            case 16: {
                return pSSystemBase.isDEDSMaxRowCntDirty();
            }
            case 17: {
                return pSSystemBase.isDEExpMaxRowCntDirty();
            }
            case 18: {
                return pSSystemBase.isDEFPSSysDeployIdDirty();
            }
            case 19: {
                return pSSystemBase.isDEFSFItemWidthDirty();
            }
            case 20: {
                return pSSystemBase.isDEFSortModeDirty();
            }
            case 21: {
                return pSSystemBase.isDEMSActionLogicFlagDirty();
            }
            case 22: {
                return pSSystemBase.isDomainNameDirty();
            }
            case 23: {
                return pSSystemBase.isDTOFormatDirty();
            }
            case 24: {
                return pSSystemBase.isEnableDBValueModeDirty();
            }
            case 25: {
                return pSSystemBase.isEnableDEDataVerDirty();
            }
            case 26: {
                return pSSystemBase.isEnableDEFRestrictedUIDirty();
            }
            case 27: {
                return pSSystemBase.isEnableDERFKeyDirty();
            }
            case 28: {
                return pSSystemBase.isEnableDynaSysDirty();
            }
            case 29: {
                return pSSystemBase.isEnableFolderKeyDirty();
            }
            case 30: {
                return pSSystemBase.isEnableMultiLanDirty();
            }
            case 31: {
                return pSSystemBase.isEnableOPNameModelDirty();
            }
            case 32: {
                return pSSystemBase.isEnablePQLDirty();
            }
            case 33: {
                return pSSystemBase.isEnaDefLanResContentDirty();
            }
            case 34: {
                return pSSystemBase.isEntityCntDirty();
            }
            case 35: {
                return pSSystemBase.isExtractDefaultDirty();
            }
            case 36: {
                return pSSystemBase.isInitDEDefaultDirty();
            }
            case 37: {
                return pSSystemBase.isLanResMaxTagDirty();
            }
            case 38: {
                return pSSystemBase.isLogicNameDirty();
            }
            case 39: {
                return pSSystemBase.isLowCodeModeDirty();
            }
            case 40: {
                return pSSystemBase.isLowCodeOptionDirty();
            }
            case 41: {
                return pSSystemBase.isMaxEntityCntDirty();
            }
            case 42: {
                return pSSystemBase.isMemoDirty();
            }
            case 43: {
                return pSSystemBase.isMobPSAppsCntDirty();
            }
            case 44: {
                return pSSystemBase.isModelV2ExpModeDirty();
            }
            case 45: {
                return pSSystemBase.isModelVerDirty();
            }
            case 46: {
                return pSSystemBase.isNoViewModeDirty();
            }
            case 47: {
                return pSSystemBase.isPIAutoShowCaptionDirty();
            }
            case 48: {
                return pSSystemBase.isPSDepSlnPrdIdDirty();
            }
            case 49: {
                return pSSystemBase.isPSDevCenterIdDirty();
            }
            case 50: {
                return pSSystemBase.isPSDevCenterNameDirty();
            }
            case 51: {
                return pSSystemBase.isPSDevCenterTSIdDirty();
            }
            case 52: {
                return pSSystemBase.isPSDevCenterTSNameDirty();
            }
            case 53: {
                return pSSystemBase.isPSDevSlnIdDirty();
            }
            case 54: {
                return pSSystemBase.isPSDevSlnNameDirty();
            }
            case 55: {
                return pSSystemBase.isPSDevSlnSysIdDirty();
            }
            case 56: {
                return pSSystemBase.isPSLanguageIdDirty();
            }
            case 57: {
                return pSSystemBase.isPSLanguageNameDirty();
            }
            case 58: {
                return pSSystemBase.isPSSFIdDirty();
            }
            case 59: {
                return pSSystemBase.isPSSFNameDirty();
            }
            case 60: {
                return pSSystemBase.isPSSFPubsCntDirty();
            }
            case 61: {
                return pSSystemBase.isPSSysDevBKTasksCntDirty();
            }
            case 62: {
                return pSSystemBase.isPSSysEngineCfgIdDirty();
            }
            case 63: {
                return pSSystemBase.isPSSysEngineCfgNameDirty();
            }
            case 64: {
                return pSSystemBase.isPSSysIssuesCntDirty();
            }
            case 65: {
                return pSSystemBase.isPSSysModelInstIdDirty();
            }
            case 66: {
                return pSSystemBase.isPSSysTasksCntDirty();
            }
            case 67: {
                return pSSystemBase.isPSSystemIdDirty();
            }
            case 68: {
                return pSSystemBase.isPSSystemNameDirty();
            }
            case 69: {
                return pSSystemBase.isPSWFsCntDirty();
            }
            case 70: {
                return pSSystemBase.isPubDBModelFlagDirty();
            }
            case 71: {
                return pSSystemBase.isSaaSModeDirty();
            }
            case 72: {
                return pSSystemBase.isScriptEngineDirty();
            }
            case 73: {
                return pSSystemBase.isServiceAPIFlagDirty();
            }
            case 74: {
                return pSSystemBase.isSimActionLogicsDirty();
            }
            case 75: {
                return pSSystemBase.isSrcPSSystemIdDirty();
            }
            case 76: {
                return pSSystemBase.isSrcPSSystemNameDirty();
            }
            case 77: {
                return pSSystemBase.isSSDEMSActionLogicFlagDirty();
            }
            case 78: {
                return pSSystemBase.isSysFolderDirty();
            }
            case 79: {
                return pSSystemBase.isSysRowKeyDirty();
            }
            case 80: {
                return pSSystemBase.isSysTypeDirty();
            }
            case 81: {
                return pSSystemBase.isSysVerDirty();
            }
            case 82: {
                return pSSystemBase.isTagsDirty();
            }
            case 83: {
                return pSSystemBase.isTemplEngineDirty();
            }
            case 84: {
                return pSSystemBase.isUpdateDateDirty();
            }
            case 85: {
                return pSSystemBase.isUpdateManDirty();
            }
            case 86: {
                return pSSystemBase.isUserParamsDirty();
            }
            case 87: {
                return pSSystemBase.isViewUARegModeDirty();
            }
            case 88: {
                return pSSystemBase.isWebPSAppsCntDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSystemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSystemBase pSSystemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSystemBase.getAccCtrlArch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"accctrlarch", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getAccCtrlArch()), (boolean)false);
        }
        if (bl || pSSystemBase.getAutoCalcDERER() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autocalcderer", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getAutoCalcDERER()), (boolean)false);
        }
        if (bl || pSSystemBase.getBugFixs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bugfixs", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getBugFixs()), (boolean)false);
        }
        if (bl || pSSystemBase.getCheckModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkmodelver", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCheckModelVer()), (boolean)false);
        }
        if (bl || pSSystemBase.getCLEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clemptytext", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCLEmptyText()), (boolean)false);
        }
        if (bl || pSSystemBase.getCLEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clemptytextpslanresid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCLEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSSystemBase.getCLEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clemptytextpslanresname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCLEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSSystemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSystemBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSystemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSystemBase.getCtrlAppendDEItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlappenddeitems", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCtrlAppendDEItems()), (boolean)false);
        }
        if (bl || pSSystemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSystemBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getDBTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtypes", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDBTypes()), (boolean)false);
        }
        if (bl || pSSystemBase.getDBVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbversion", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDBVersion()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEDSMaxRowCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedsmaxrowcnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEDSMaxRowCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEExpMaxRowCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deexpmaxrowcnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEExpMaxRowCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEFPSSysDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpssysdeployid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEFPSSysDeployId()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEFSFItemWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defsfitemwidth", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEFSFItemWidth()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEFSortMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defsortmode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEFSortMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getDEMSActionLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demsactionlogicflag", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDEMSActionLogicFlag()), (boolean)false);
        }
        if (bl || pSSystemBase.getDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDomainName()), (boolean)false);
        }
        if (bl || pSSystemBase.getDTOFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dtoformat", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getDTOFormat()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableDBValueMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledbvaluemode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableDBValueMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableDEDataVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablededataver", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableDEDataVer()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableDEFRestrictedUI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledefrestrictedui", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableDEFRestrictedUI()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableDERFKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablederfkey", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableDERFKey()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableFolderKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablefolderkey", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableFolderKey()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableMultiLan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemultilan", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableMultiLan()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnableOPNameModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableopnamemodel", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnableOPNameModel()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnablePQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepql", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnablePQL()), (boolean)false);
        }
        if (bl || pSSystemBase.getEnaDefLanResContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enadeflanrescontent", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEnaDefLanResContent()), (boolean)false);
        }
        if (bl || pSSystemBase.getEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"entitycnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getEntityCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getExtractDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extractdefault", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getExtractDefault()), (boolean)false);
        }
        if (bl || pSSystemBase.getInitDEDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initdedefault", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getInitDEDefault()), (boolean)false);
        }
        if (bl || pSSystemBase.getLanResMaxTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanresmaxtag", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getLanResMaxTag()), (boolean)false);
        }
        if (bl || pSSystemBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSystemBase.getLowCodeMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lowcodemode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getLowCodeMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getLowCodeOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lowcodeoption", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getLowCodeOption()), (boolean)false);
        }
        if (bl || pSSystemBase.getMaxEntityCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxentitycnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getMaxEntityCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSystemBase.getMobPSAppsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsappscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getMobPSAppsCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getModelV2ExpMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelv2expmode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getModelV2ExpMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getModelVer()), (boolean)false);
        }
        if (bl || pSSystemBase.getNoViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noviewmode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getNoViewMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getPIAutoShowCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"piautoshowcaption", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPIAutoShowCaption()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDepSlnPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnprdid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDepSlnPrdId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevCenterTSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevCenterTSId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevCenterTSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevCenterTSName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSLanguageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSLanguageId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSLanguageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguagename", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSLanguageName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSFPubsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpubscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSFPubsCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysDevBKTasksCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevbktaskscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysDevBKTasksCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysEngineCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysenginecfgid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysEngineCfgId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysEngineCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysenginecfgname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysEngineCfgName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysIssuesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuescnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysIssuesCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSysTasksCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSysTasksCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemBase.getPSWFsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPSWFsCnt()), (boolean)false);
        }
        if (bl || pSSystemBase.getPubDBModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubdbmodelflag", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getPubDBModelFlag()), (boolean)false);
        }
        if (bl || pSSystemBase.getSaaSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"saasmode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSaaSMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getScriptEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"scriptengine", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getScriptEngine()), (boolean)false);
        }
        if (bl || pSSystemBase.getServiceAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceapiflag", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getServiceAPIFlag()), (boolean)false);
        }
        if (bl || pSSystemBase.getSimActionLogics() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"simactionlogics", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSimActionLogics()), (boolean)false);
        }
        if (bl || pSSystemBase.getSrcPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssystemid", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSrcPSSystemId()), (boolean)false);
        }
        if (bl || pSSystemBase.getSrcPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpssystemname", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSrcPSSystemName()), (boolean)false);
        }
        if (bl || pSSystemBase.getSSDEMSActionLogicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ssdemsactionlogicflag", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSSDEMSActionLogicFlag()), (boolean)false);
        }
        if (bl || pSSystemBase.getSysFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysfolder", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSysFolder()), (boolean)false);
        }
        if (bl || pSSystemBase.getSysRowKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrowkey", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSysRowKey()), (boolean)false);
        }
        if (bl || pSSystemBase.getSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systype", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSysType()), (boolean)false);
        }
        if (bl || pSSystemBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getSysVer()), (boolean)false);
        }
        if (bl || pSSystemBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getTags()), (boolean)false);
        }
        if (bl || pSSystemBase.getTemplEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templengine", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getTemplEngine()), (boolean)false);
        }
        if (bl || pSSystemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSystemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSystemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSystemBase.getViewUARegMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewuaregmode", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getViewUARegMode()), (boolean)false);
        }
        if (bl || pSSystemBase.getWebPSAppsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webpsappscnt", (Object)PSSystemBase.getJSONValue((Object)pSSystemBase.getWebPSAppsCnt()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSystemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSystemBase pSSystemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSystemBase.getAccCtrlArch() != null) {
            object = pSSystemBase.getAccCtrlArch();
            xmlNode.setAttribute(FIELD_ACCCTRLARCH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getAutoCalcDERER() != null) {
            object = pSSystemBase.getAutoCalcDERER();
            xmlNode.setAttribute(FIELD_AUTOCALCDERER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getBugFixs() != null) {
            object = pSSystemBase.getBugFixs();
            xmlNode.setAttribute(FIELD_BUGFIXS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getCheckModelVer() != null) {
            object = pSSystemBase.getCheckModelVer();
            xmlNode.setAttribute(FIELD_CHECKMODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getCLEmptyText() != null) {
            object = pSSystemBase.getCLEmptyText();
            xmlNode.setAttribute(FIELD_CLEMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCLEmptyTextPSLanResId() != null) {
            object = pSSystemBase.getCLEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_CLEMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCLEmptyTextPSLanResName() != null) {
            object = pSSystemBase.getCLEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_CLEMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCodeName() != null) {
            object = pSSystemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCodeNameMode() != null) {
            object = pSSystemBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCreateDate() != null) {
            object = pSSystemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemBase.getCreateMan() != null) {
            object = pSSystemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCtrlAppendDEItems() != null) {
            object = pSSystemBase.getCtrlAppendDEItems();
            xmlNode.setAttribute(FIELD_CTRLAPPENDDEITEMS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getCustomCode() != null) {
            object = pSSystemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getCustomMode() != null) {
            object = pSSystemBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDBTypes() != null) {
            object = pSSystemBase.getDBTypes();
            xmlNode.setAttribute(FIELD_DBTYPES, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getDBVersion() != null) {
            object = pSSystemBase.getDBVersion();
            xmlNode.setAttribute(FIELD_DBVERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDEDSMaxRowCnt() != null) {
            object = pSSystemBase.getDEDSMaxRowCnt();
            xmlNode.setAttribute(FIELD_DEDSMAXROWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDEExpMaxRowCnt() != null) {
            object = pSSystemBase.getDEExpMaxRowCnt();
            xmlNode.setAttribute(FIELD_DEEXPMAXROWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDEFPSSysDeployId() != null) {
            object = pSSystemBase.getDEFPSSysDeployId();
            xmlNode.setAttribute(FIELD_DEFPSSYSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getDEFSFItemWidth() != null) {
            object = pSSystemBase.getDEFSFItemWidth();
            xmlNode.setAttribute(FIELD_DEFSFITEMWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDEFSortMode() != null) {
            object = pSSystemBase.getDEFSortMode();
            xmlNode.setAttribute(FIELD_DEFSORTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getDEMSActionLogicFlag() != null) {
            object = pSSystemBase.getDEMSActionLogicFlag();
            xmlNode.setAttribute(FIELD_DEMSACTIONLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getDomainName() != null) {
            object = pSSystemBase.getDomainName();
            xmlNode.setAttribute(FIELD_DOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getDTOFormat() != null) {
            object = pSSystemBase.getDTOFormat();
            xmlNode.setAttribute(FIELD_DTOFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getEnableDBValueMode() != null) {
            object = pSSystemBase.getEnableDBValueMode();
            xmlNode.setAttribute(FIELD_ENABLEDBVALUEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableDEDataVer() != null) {
            object = pSSystemBase.getEnableDEDataVer();
            xmlNode.setAttribute(FIELD_ENABLEDEDATAVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableDEFRestrictedUI() != null) {
            object = pSSystemBase.getEnableDEFRestrictedUI();
            xmlNode.setAttribute(FIELD_ENABLEDEFRESTRICTEDUI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableDERFKey() != null) {
            object = pSSystemBase.getEnableDERFKey();
            xmlNode.setAttribute(FIELD_ENABLEDERFKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableDynaSys() != null) {
            object = pSSystemBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableFolderKey() != null) {
            object = pSSystemBase.getEnableFolderKey();
            xmlNode.setAttribute(FIELD_ENABLEFOLDERKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableMultiLan() != null) {
            object = pSSystemBase.getEnableMultiLan();
            xmlNode.setAttribute(FIELD_ENABLEMULTILAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnableOPNameModel() != null) {
            object = pSSystemBase.getEnableOPNameModel();
            xmlNode.setAttribute(FIELD_ENABLEOPNAMEMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnablePQL() != null) {
            object = pSSystemBase.getEnablePQL();
            xmlNode.setAttribute(FIELD_ENABLEPQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEnaDefLanResContent() != null) {
            object = pSSystemBase.getEnaDefLanResContent();
            xmlNode.setAttribute(FIELD_ENADEFLANRESCONTENT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getEntityCnt() != null) {
            object = pSSystemBase.getEntityCnt();
            xmlNode.setAttribute(FIELD_ENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getExtractDefault() != null) {
            object = pSSystemBase.getExtractDefault();
            xmlNode.setAttribute(FIELD_EXTRACTDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getInitDEDefault() != null) {
            object = pSSystemBase.getInitDEDefault();
            xmlNode.setAttribute(FIELD_INITDEDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getLanResMaxTag() != null) {
            object = pSSystemBase.getLanResMaxTag();
            xmlNode.setAttribute(FIELD_LANRESMAXTAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getLogicName() != null) {
            object = pSSystemBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getLowCodeMode() != null) {
            object = pSSystemBase.getLowCodeMode();
            xmlNode.setAttribute(FIELD_LOWCODEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getLowCodeOption() != null) {
            object = pSSystemBase.getLowCodeOption();
            xmlNode.setAttribute(FIELD_LOWCODEOPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getMaxEntityCnt() != null) {
            object = pSSystemBase.getMaxEntityCnt();
            xmlNode.setAttribute(FIELD_MAXENTITYCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getMemo() != null) {
            object = pSSystemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getMobPSAppsCnt() != null) {
            object = pSSystemBase.getMobPSAppsCnt();
            xmlNode.setAttribute(FIELD_MOBPSAPPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getModelV2ExpMode() != null) {
            object = pSSystemBase.getModelV2ExpMode();
            xmlNode.setAttribute(FIELD_MODELV2EXPMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getModelVer() != null) {
            object = pSSystemBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getNoViewMode() != null) {
            object = pSSystemBase.getNoViewMode();
            xmlNode.setAttribute(FIELD_NOVIEWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPIAutoShowCaption() != null) {
            object = pSSystemBase.getPIAutoShowCaption();
            xmlNode.setAttribute(FIELD_PIAUTOSHOWCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPSDepSlnPrdId() != null) {
            object = pSSystemBase.getPSDepSlnPrdId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevCenterId() != null) {
            object = pSSystemBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevCenterName() != null) {
            object = pSSystemBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevCenterTSId() != null) {
            object = pSSystemBase.getPSDevCenterTSId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevCenterTSName() != null) {
            object = pSSystemBase.getPSDevCenterTSName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevSlnId() != null) {
            object = pSSystemBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevSlnName() != null) {
            object = pSSystemBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSDevSlnSysId() != null) {
            object = pSSystemBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSLanguageId() != null) {
            object = pSSystemBase.getPSLanguageId();
            xmlNode.setAttribute(FIELD_PSLANGUAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSLanguageName() != null) {
            object = pSSystemBase.getPSLanguageName();
            xmlNode.setAttribute(FIELD_PSLANGUAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSFId() != null) {
            object = pSSystemBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSFName() != null) {
            object = pSSystemBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSFPubsCnt() != null) {
            object = pSSystemBase.getPSSFPubsCnt();
            xmlNode.setAttribute(FIELD_PSSFPUBSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPSSysDevBKTasksCnt() != null) {
            object = pSSystemBase.getPSSysDevBKTasksCnt();
            xmlNode.setAttribute(FIELD_PSSYSDEVBKTASKSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPSSysEngineCfgId() != null) {
            object = pSSystemBase.getPSSysEngineCfgId();
            xmlNode.setAttribute(FIELD_PSSYSENGINECFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSysEngineCfgName() != null) {
            object = pSSystemBase.getPSSysEngineCfgName();
            xmlNode.setAttribute(FIELD_PSSYSENGINECFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSysIssuesCnt() != null) {
            object = pSSystemBase.getPSSysIssuesCnt();
            xmlNode.setAttribute(FIELD_PSSYSISSUESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPSSysModelInstId() != null) {
            object = pSSystemBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSysTasksCnt() != null) {
            object = pSSystemBase.getPSSysTasksCnt();
            xmlNode.setAttribute(FIELD_PSSYSTASKSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPSSystemId() != null) {
            object = pSSystemBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSSystemName() != null) {
            object = pSSystemBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getPSWFsCnt() != null) {
            object = pSSystemBase.getPSWFsCnt();
            xmlNode.setAttribute(FIELD_PSWFSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getPubDBModelFlag() != null) {
            object = pSSystemBase.getPubDBModelFlag();
            xmlNode.setAttribute(FIELD_PUBDBMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getSaaSMode() != null) {
            object = pSSystemBase.getSaaSMode();
            xmlNode.setAttribute(FIELD_SAASMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getScriptEngine() != null) {
            object = pSSystemBase.getScriptEngine();
            xmlNode.setAttribute(FIELD_SCRIPTENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getServiceAPIFlag() != null) {
            object = pSSystemBase.getServiceAPIFlag();
            xmlNode.setAttribute(FIELD_SERVICEAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getSimActionLogics() != null) {
            object = pSSystemBase.getSimActionLogics();
            xmlNode.setAttribute(FIELD_SIMACTIONLOGICS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getSrcPSSystemId() != null) {
            object = pSSystemBase.getSrcPSSystemId();
            xmlNode.setAttribute(FIELD_SRCPSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getSrcPSSystemName() != null) {
            object = pSSystemBase.getSrcPSSystemName();
            xmlNode.setAttribute(FIELD_SRCPSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getSSDEMSActionLogicFlag() != null) {
            object = pSSystemBase.getSSDEMSActionLogicFlag();
            xmlNode.setAttribute(FIELD_SSDEMSACTIONLOGICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getSysFolder() != null) {
            object = pSSystemBase.getSysFolder();
            xmlNode.setAttribute(FIELD_SYSFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getSysRowKey() != null) {
            object = pSSystemBase.getSysRowKey();
            xmlNode.setAttribute(FIELD_SYSROWKEY, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getSysType() != null) {
            object = pSSystemBase.getSysType();
            xmlNode.setAttribute(FIELD_SYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getSysVer() != null) {
            object = pSSystemBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getTags() != null) {
            object = pSSystemBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getTemplEngine() != null) {
            object = pSSystemBase.getTemplEngine();
            xmlNode.setAttribute(FIELD_TEMPLENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getUpdateDate() != null) {
            object = pSSystemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSystemBase.getUpdateMan() != null) {
            object = pSSystemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getUserParams() != null) {
            object = pSSystemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSystemBase.getViewUARegMode() != null) {
            object = pSSystemBase.getViewUARegMode();
            xmlNode.setAttribute(FIELD_VIEWUAREGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSystemBase.getWebPSAppsCnt() != null) {
            object = pSSystemBase.getWebPSAppsCnt();
            xmlNode.setAttribute(FIELD_WEBPSAPPSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSystemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSystemBase pSSystemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSystemBase.isAccCtrlArchDirty() && (bl || pSSystemBase.getAccCtrlArch() != null)) {
            iDataObject.set(FIELD_ACCCTRLARCH, (Object)pSSystemBase.getAccCtrlArch());
        }
        if (pSSystemBase.isAutoCalcDERERDirty() && (bl || pSSystemBase.getAutoCalcDERER() != null)) {
            iDataObject.set(FIELD_AUTOCALCDERER, (Object)pSSystemBase.getAutoCalcDERER());
        }
        if (pSSystemBase.isBugFixsDirty() && (bl || pSSystemBase.getBugFixs() != null)) {
            iDataObject.set(FIELD_BUGFIXS, (Object)pSSystemBase.getBugFixs());
        }
        if (pSSystemBase.isCheckModelVerDirty() && (bl || pSSystemBase.getCheckModelVer() != null)) {
            iDataObject.set(FIELD_CHECKMODELVER, (Object)pSSystemBase.getCheckModelVer());
        }
        if (pSSystemBase.isCLEmptyTextDirty() && (bl || pSSystemBase.getCLEmptyText() != null)) {
            iDataObject.set(FIELD_CLEMPTYTEXT, (Object)pSSystemBase.getCLEmptyText());
        }
        if (pSSystemBase.isCLEmptyTextPSLanResIdDirty() && (bl || pSSystemBase.getCLEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_CLEMPTYTEXTPSLANRESID, (Object)pSSystemBase.getCLEmptyTextPSLanResId());
        }
        if (pSSystemBase.isCLEmptyTextPSLanResNameDirty() && (bl || pSSystemBase.getCLEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_CLEMPTYTEXTPSLANRESNAME, (Object)pSSystemBase.getCLEmptyTextPSLanResName());
        }
        if (pSSystemBase.isCodeNameDirty() && (bl || pSSystemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSystemBase.getCodeName());
        }
        if (pSSystemBase.isCodeNameModeDirty() && (bl || pSSystemBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSSystemBase.getCodeNameMode());
        }
        if (pSSystemBase.isCreateDateDirty() && (bl || pSSystemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSystemBase.getCreateDate());
        }
        if (pSSystemBase.isCreateManDirty() && (bl || pSSystemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSystemBase.getCreateMan());
        }
        if (pSSystemBase.isCtrlAppendDEItemsDirty() && (bl || pSSystemBase.getCtrlAppendDEItems() != null)) {
            iDataObject.set(FIELD_CTRLAPPENDDEITEMS, (Object)pSSystemBase.getCtrlAppendDEItems());
        }
        if (pSSystemBase.isCustomCodeDirty() && (bl || pSSystemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSystemBase.getCustomCode());
        }
        if (pSSystemBase.isCustomModeDirty() && (bl || pSSystemBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSystemBase.getCustomMode());
        }
        if (pSSystemBase.isDBTypesDirty() && (bl || pSSystemBase.getDBTypes() != null)) {
            iDataObject.set(FIELD_DBTYPES, (Object)pSSystemBase.getDBTypes());
        }
        if (pSSystemBase.isDBVersionDirty() && (bl || pSSystemBase.getDBVersion() != null)) {
            iDataObject.set(FIELD_DBVERSION, (Object)pSSystemBase.getDBVersion());
        }
        if (pSSystemBase.isDEDSMaxRowCntDirty() && (bl || pSSystemBase.getDEDSMaxRowCnt() != null)) {
            iDataObject.set(FIELD_DEDSMAXROWCNT, (Object)pSSystemBase.getDEDSMaxRowCnt());
        }
        if (pSSystemBase.isDEExpMaxRowCntDirty() && (bl || pSSystemBase.getDEExpMaxRowCnt() != null)) {
            iDataObject.set(FIELD_DEEXPMAXROWCNT, (Object)pSSystemBase.getDEExpMaxRowCnt());
        }
        if (pSSystemBase.isDEFPSSysDeployIdDirty() && (bl || pSSystemBase.getDEFPSSysDeployId() != null)) {
            iDataObject.set(FIELD_DEFPSSYSDEPLOYID, (Object)pSSystemBase.getDEFPSSysDeployId());
        }
        if (pSSystemBase.isDEFSFItemWidthDirty() && (bl || pSSystemBase.getDEFSFItemWidth() != null)) {
            iDataObject.set(FIELD_DEFSFITEMWIDTH, (Object)pSSystemBase.getDEFSFItemWidth());
        }
        if (pSSystemBase.isDEFSortModeDirty() && (bl || pSSystemBase.getDEFSortMode() != null)) {
            iDataObject.set(FIELD_DEFSORTMODE, (Object)pSSystemBase.getDEFSortMode());
        }
        if (pSSystemBase.isDEMSActionLogicFlagDirty() && (bl || pSSystemBase.getDEMSActionLogicFlag() != null)) {
            iDataObject.set(FIELD_DEMSACTIONLOGICFLAG, (Object)pSSystemBase.getDEMSActionLogicFlag());
        }
        if (pSSystemBase.isDomainNameDirty() && (bl || pSSystemBase.getDomainName() != null)) {
            iDataObject.set(FIELD_DOMAINNAME, (Object)pSSystemBase.getDomainName());
        }
        if (pSSystemBase.isDTOFormatDirty() && (bl || pSSystemBase.getDTOFormat() != null)) {
            iDataObject.set(FIELD_DTOFORMAT, (Object)pSSystemBase.getDTOFormat());
        }
        if (pSSystemBase.isEnableDBValueModeDirty() && (bl || pSSystemBase.getEnableDBValueMode() != null)) {
            iDataObject.set(FIELD_ENABLEDBVALUEMODE, (Object)pSSystemBase.getEnableDBValueMode());
        }
        if (pSSystemBase.isEnableDEDataVerDirty() && (bl || pSSystemBase.getEnableDEDataVer() != null)) {
            iDataObject.set(FIELD_ENABLEDEDATAVER, (Object)pSSystemBase.getEnableDEDataVer());
        }
        if (pSSystemBase.isEnableDEFRestrictedUIDirty() && (bl || pSSystemBase.getEnableDEFRestrictedUI() != null)) {
            iDataObject.set(FIELD_ENABLEDEFRESTRICTEDUI, (Object)pSSystemBase.getEnableDEFRestrictedUI());
        }
        if (pSSystemBase.isEnableDERFKeyDirty() && (bl || pSSystemBase.getEnableDERFKey() != null)) {
            iDataObject.set(FIELD_ENABLEDERFKEY, (Object)pSSystemBase.getEnableDERFKey());
        }
        if (pSSystemBase.isEnableDynaSysDirty() && (bl || pSSystemBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSSystemBase.getEnableDynaSys());
        }
        if (pSSystemBase.isEnableFolderKeyDirty() && (bl || pSSystemBase.getEnableFolderKey() != null)) {
            iDataObject.set(FIELD_ENABLEFOLDERKEY, (Object)pSSystemBase.getEnableFolderKey());
        }
        if (pSSystemBase.isEnableMultiLanDirty() && (bl || pSSystemBase.getEnableMultiLan() != null)) {
            iDataObject.set(FIELD_ENABLEMULTILAN, (Object)pSSystemBase.getEnableMultiLan());
        }
        if (pSSystemBase.isEnableOPNameModelDirty() && (bl || pSSystemBase.getEnableOPNameModel() != null)) {
            iDataObject.set(FIELD_ENABLEOPNAMEMODEL, (Object)pSSystemBase.getEnableOPNameModel());
        }
        if (pSSystemBase.isEnablePQLDirty() && (bl || pSSystemBase.getEnablePQL() != null)) {
            iDataObject.set(FIELD_ENABLEPQL, (Object)pSSystemBase.getEnablePQL());
        }
        if (pSSystemBase.isEnaDefLanResContentDirty() && (bl || pSSystemBase.getEnaDefLanResContent() != null)) {
            iDataObject.set(FIELD_ENADEFLANRESCONTENT, (Object)pSSystemBase.getEnaDefLanResContent());
        }
        if (pSSystemBase.isEntityCntDirty() && (bl || pSSystemBase.getEntityCnt() != null)) {
            iDataObject.set(FIELD_ENTITYCNT, (Object)pSSystemBase.getEntityCnt());
        }
        if (pSSystemBase.isExtractDefaultDirty() && (bl || pSSystemBase.getExtractDefault() != null)) {
            iDataObject.set(FIELD_EXTRACTDEFAULT, (Object)pSSystemBase.getExtractDefault());
        }
        if (pSSystemBase.isInitDEDefaultDirty() && (bl || pSSystemBase.getInitDEDefault() != null)) {
            iDataObject.set(FIELD_INITDEDEFAULT, (Object)pSSystemBase.getInitDEDefault());
        }
        if (pSSystemBase.isLanResMaxTagDirty() && (bl || pSSystemBase.getLanResMaxTag() != null)) {
            iDataObject.set(FIELD_LANRESMAXTAG, (Object)pSSystemBase.getLanResMaxTag());
        }
        if (pSSystemBase.isLogicNameDirty() && (bl || pSSystemBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSystemBase.getLogicName());
        }
        if (pSSystemBase.isLowCodeModeDirty() && (bl || pSSystemBase.getLowCodeMode() != null)) {
            iDataObject.set(FIELD_LOWCODEMODE, (Object)pSSystemBase.getLowCodeMode());
        }
        if (pSSystemBase.isLowCodeOptionDirty() && (bl || pSSystemBase.getLowCodeOption() != null)) {
            iDataObject.set(FIELD_LOWCODEOPTION, (Object)pSSystemBase.getLowCodeOption());
        }
        if (pSSystemBase.isMaxEntityCntDirty() && (bl || pSSystemBase.getMaxEntityCnt() != null)) {
            iDataObject.set(FIELD_MAXENTITYCNT, (Object)pSSystemBase.getMaxEntityCnt());
        }
        if (pSSystemBase.isMemoDirty() && (bl || pSSystemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSystemBase.getMemo());
        }
        if (pSSystemBase.isMobPSAppsCntDirty() && (bl || pSSystemBase.getMobPSAppsCnt() != null)) {
            iDataObject.set(FIELD_MOBPSAPPSCNT, (Object)pSSystemBase.getMobPSAppsCnt());
        }
        if (pSSystemBase.isModelV2ExpModeDirty() && (bl || pSSystemBase.getModelV2ExpMode() != null)) {
            iDataObject.set(FIELD_MODELV2EXPMODE, (Object)pSSystemBase.getModelV2ExpMode());
        }
        if (pSSystemBase.isModelVerDirty() && (bl || pSSystemBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSSystemBase.getModelVer());
        }
        if (pSSystemBase.isNoViewModeDirty() && (bl || pSSystemBase.getNoViewMode() != null)) {
            iDataObject.set(FIELD_NOVIEWMODE, (Object)pSSystemBase.getNoViewMode());
        }
        if (pSSystemBase.isPIAutoShowCaptionDirty() && (bl || pSSystemBase.getPIAutoShowCaption() != null)) {
            iDataObject.set(FIELD_PIAUTOSHOWCAPTION, (Object)pSSystemBase.getPIAutoShowCaption());
        }
        if (pSSystemBase.isPSDepSlnPrdIdDirty() && (bl || pSSystemBase.getPSDepSlnPrdId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPRDID, (Object)pSSystemBase.getPSDepSlnPrdId());
        }
        if (pSSystemBase.isPSDevCenterIdDirty() && (bl || pSSystemBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSystemBase.getPSDevCenterId());
        }
        if (pSSystemBase.isPSDevCenterNameDirty() && (bl || pSSystemBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSystemBase.getPSDevCenterName());
        }
        if (pSSystemBase.isPSDevCenterTSIdDirty() && (bl || pSSystemBase.getPSDevCenterTSId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSID, (Object)pSSystemBase.getPSDevCenterTSId());
        }
        if (pSSystemBase.isPSDevCenterTSNameDirty() && (bl || pSSystemBase.getPSDevCenterTSName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSNAME, (Object)pSSystemBase.getPSDevCenterTSName());
        }
        if (pSSystemBase.isPSDevSlnIdDirty() && (bl || pSSystemBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSSystemBase.getPSDevSlnId());
        }
        if (pSSystemBase.isPSDevSlnNameDirty() && (bl || pSSystemBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSSystemBase.getPSDevSlnName());
        }
        if (pSSystemBase.isPSDevSlnSysIdDirty() && (bl || pSSystemBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSystemBase.getPSDevSlnSysId());
        }
        if (pSSystemBase.isPSLanguageIdDirty() && (bl || pSSystemBase.getPSLanguageId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEID, (Object)pSSystemBase.getPSLanguageId());
        }
        if (pSSystemBase.isPSLanguageNameDirty() && (bl || pSSystemBase.getPSLanguageName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGENAME, (Object)pSSystemBase.getPSLanguageName());
        }
        if (pSSystemBase.isPSSFIdDirty() && (bl || pSSystemBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSystemBase.getPSSFId());
        }
        if (pSSystemBase.isPSSFNameDirty() && (bl || pSSystemBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSystemBase.getPSSFName());
        }
        if (pSSystemBase.isPSSFPubsCntDirty() && (bl || pSSystemBase.getPSSFPubsCnt() != null)) {
            iDataObject.set(FIELD_PSSFPUBSCNT, (Object)pSSystemBase.getPSSFPubsCnt());
        }
        if (pSSystemBase.isPSSysDevBKTasksCntDirty() && (bl || pSSystemBase.getPSSysDevBKTasksCnt() != null)) {
            iDataObject.set(FIELD_PSSYSDEVBKTASKSCNT, (Object)pSSystemBase.getPSSysDevBKTasksCnt());
        }
        if (pSSystemBase.isPSSysEngineCfgIdDirty() && (bl || pSSystemBase.getPSSysEngineCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSENGINECFGID, (Object)pSSystemBase.getPSSysEngineCfgId());
        }
        if (pSSystemBase.isPSSysEngineCfgNameDirty() && (bl || pSSystemBase.getPSSysEngineCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSENGINECFGNAME, (Object)pSSystemBase.getPSSysEngineCfgName());
        }
        if (pSSystemBase.isPSSysIssuesCntDirty() && (bl || pSSystemBase.getPSSysIssuesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSISSUESCNT, (Object)pSSystemBase.getPSSysIssuesCnt());
        }
        if (pSSystemBase.isPSSysModelInstIdDirty() && (bl || pSSystemBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSystemBase.getPSSysModelInstId());
        }
        if (pSSystemBase.isPSSysTasksCntDirty() && (bl || pSSystemBase.getPSSysTasksCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTASKSCNT, (Object)pSSystemBase.getPSSysTasksCnt());
        }
        if (pSSystemBase.isPSSystemIdDirty() && (bl || pSSystemBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSystemBase.getPSSystemId());
        }
        if (pSSystemBase.isPSSystemNameDirty() && (bl || pSSystemBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSystemBase.getPSSystemName());
        }
        if (pSSystemBase.isPSWFsCntDirty() && (bl || pSSystemBase.getPSWFsCnt() != null)) {
            iDataObject.set(FIELD_PSWFSCNT, (Object)pSSystemBase.getPSWFsCnt());
        }
        if (pSSystemBase.isPubDBModelFlagDirty() && (bl || pSSystemBase.getPubDBModelFlag() != null)) {
            iDataObject.set(FIELD_PUBDBMODELFLAG, (Object)pSSystemBase.getPubDBModelFlag());
        }
        if (pSSystemBase.isSaaSModeDirty() && (bl || pSSystemBase.getSaaSMode() != null)) {
            iDataObject.set(FIELD_SAASMODE, (Object)pSSystemBase.getSaaSMode());
        }
        if (pSSystemBase.isScriptEngineDirty() && (bl || pSSystemBase.getScriptEngine() != null)) {
            iDataObject.set(FIELD_SCRIPTENGINE, (Object)pSSystemBase.getScriptEngine());
        }
        if (pSSystemBase.isServiceAPIFlagDirty() && (bl || pSSystemBase.getServiceAPIFlag() != null)) {
            iDataObject.set(FIELD_SERVICEAPIFLAG, (Object)pSSystemBase.getServiceAPIFlag());
        }
        if (pSSystemBase.isSimActionLogicsDirty() && (bl || pSSystemBase.getSimActionLogics() != null)) {
            iDataObject.set(FIELD_SIMACTIONLOGICS, (Object)pSSystemBase.getSimActionLogics());
        }
        if (pSSystemBase.isSrcPSSystemIdDirty() && (bl || pSSystemBase.getSrcPSSystemId() != null)) {
            iDataObject.set(FIELD_SRCPSSYSTEMID, (Object)pSSystemBase.getSrcPSSystemId());
        }
        if (pSSystemBase.isSrcPSSystemNameDirty() && (bl || pSSystemBase.getSrcPSSystemName() != null)) {
            iDataObject.set(FIELD_SRCPSSYSTEMNAME, (Object)pSSystemBase.getSrcPSSystemName());
        }
        if (pSSystemBase.isSSDEMSActionLogicFlagDirty() && (bl || pSSystemBase.getSSDEMSActionLogicFlag() != null)) {
            iDataObject.set(FIELD_SSDEMSACTIONLOGICFLAG, (Object)pSSystemBase.getSSDEMSActionLogicFlag());
        }
        if (pSSystemBase.isSysFolderDirty() && (bl || pSSystemBase.getSysFolder() != null)) {
            iDataObject.set(FIELD_SYSFOLDER, (Object)pSSystemBase.getSysFolder());
        }
        if (pSSystemBase.isSysRowKeyDirty() && (bl || pSSystemBase.getSysRowKey() != null)) {
            iDataObject.set(FIELD_SYSROWKEY, (Object)pSSystemBase.getSysRowKey());
        }
        if (pSSystemBase.isSysTypeDirty() && (bl || pSSystemBase.getSysType() != null)) {
            iDataObject.set(FIELD_SYSTYPE, (Object)pSSystemBase.getSysType());
        }
        if (pSSystemBase.isSysVerDirty() && (bl || pSSystemBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSSystemBase.getSysVer());
        }
        if (pSSystemBase.isTagsDirty() && (bl || pSSystemBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSystemBase.getTags());
        }
        if (pSSystemBase.isTemplEngineDirty() && (bl || pSSystemBase.getTemplEngine() != null)) {
            iDataObject.set(FIELD_TEMPLENGINE, (Object)pSSystemBase.getTemplEngine());
        }
        if (pSSystemBase.isUpdateDateDirty() && (bl || pSSystemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSystemBase.getUpdateDate());
        }
        if (pSSystemBase.isUpdateManDirty() && (bl || pSSystemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSystemBase.getUpdateMan());
        }
        if (pSSystemBase.isUserParamsDirty() && (bl || pSSystemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSystemBase.getUserParams());
        }
        if (pSSystemBase.isViewUARegModeDirty() && (bl || pSSystemBase.getViewUARegMode() != null)) {
            iDataObject.set(FIELD_VIEWUAREGMODE, (Object)pSSystemBase.getViewUARegMode());
        }
        if (pSSystemBase.isWebPSAppsCntDirty() && (bl || pSSystemBase.getWebPSAppsCnt() != null)) {
            iDataObject.set(FIELD_WEBPSAPPSCNT, (Object)pSSystemBase.getWebPSAppsCnt());
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
        return PSSystemBase.remove(this, n);
    }

    private static boolean remove(PSSystemBase pSSystemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSystemBase.resetAccCtrlArch();
                return true;
            }
            case 1: {
                pSSystemBase.resetAutoCalcDERER();
                return true;
            }
            case 2: {
                pSSystemBase.resetBugFixs();
                return true;
            }
            case 3: {
                pSSystemBase.resetCheckModelVer();
                return true;
            }
            case 4: {
                pSSystemBase.resetCLEmptyText();
                return true;
            }
            case 5: {
                pSSystemBase.resetCLEmptyTextPSLanResId();
                return true;
            }
            case 6: {
                pSSystemBase.resetCLEmptyTextPSLanResName();
                return true;
            }
            case 7: {
                pSSystemBase.resetCodeName();
                return true;
            }
            case 8: {
                pSSystemBase.resetCodeNameMode();
                return true;
            }
            case 9: {
                pSSystemBase.resetCreateDate();
                return true;
            }
            case 10: {
                pSSystemBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSSystemBase.resetCtrlAppendDEItems();
                return true;
            }
            case 12: {
                pSSystemBase.resetCustomCode();
                return true;
            }
            case 13: {
                pSSystemBase.resetCustomMode();
                return true;
            }
            case 14: {
                pSSystemBase.resetDBTypes();
                return true;
            }
            case 15: {
                pSSystemBase.resetDBVersion();
                return true;
            }
            case 16: {
                pSSystemBase.resetDEDSMaxRowCnt();
                return true;
            }
            case 17: {
                pSSystemBase.resetDEExpMaxRowCnt();
                return true;
            }
            case 18: {
                pSSystemBase.resetDEFPSSysDeployId();
                return true;
            }
            case 19: {
                pSSystemBase.resetDEFSFItemWidth();
                return true;
            }
            case 20: {
                pSSystemBase.resetDEFSortMode();
                return true;
            }
            case 21: {
                pSSystemBase.resetDEMSActionLogicFlag();
                return true;
            }
            case 22: {
                pSSystemBase.resetDomainName();
                return true;
            }
            case 23: {
                pSSystemBase.resetDTOFormat();
                return true;
            }
            case 24: {
                pSSystemBase.resetEnableDBValueMode();
                return true;
            }
            case 25: {
                pSSystemBase.resetEnableDEDataVer();
                return true;
            }
            case 26: {
                pSSystemBase.resetEnableDEFRestrictedUI();
                return true;
            }
            case 27: {
                pSSystemBase.resetEnableDERFKey();
                return true;
            }
            case 28: {
                pSSystemBase.resetEnableDynaSys();
                return true;
            }
            case 29: {
                pSSystemBase.resetEnableFolderKey();
                return true;
            }
            case 30: {
                pSSystemBase.resetEnableMultiLan();
                return true;
            }
            case 31: {
                pSSystemBase.resetEnableOPNameModel();
                return true;
            }
            case 32: {
                pSSystemBase.resetEnablePQL();
                return true;
            }
            case 33: {
                pSSystemBase.resetEnaDefLanResContent();
                return true;
            }
            case 34: {
                pSSystemBase.resetEntityCnt();
                return true;
            }
            case 35: {
                pSSystemBase.resetExtractDefault();
                return true;
            }
            case 36: {
                pSSystemBase.resetInitDEDefault();
                return true;
            }
            case 37: {
                pSSystemBase.resetLanResMaxTag();
                return true;
            }
            case 38: {
                pSSystemBase.resetLogicName();
                return true;
            }
            case 39: {
                pSSystemBase.resetLowCodeMode();
                return true;
            }
            case 40: {
                pSSystemBase.resetLowCodeOption();
                return true;
            }
            case 41: {
                pSSystemBase.resetMaxEntityCnt();
                return true;
            }
            case 42: {
                pSSystemBase.resetMemo();
                return true;
            }
            case 43: {
                pSSystemBase.resetMobPSAppsCnt();
                return true;
            }
            case 44: {
                pSSystemBase.resetModelV2ExpMode();
                return true;
            }
            case 45: {
                pSSystemBase.resetModelVer();
                return true;
            }
            case 46: {
                pSSystemBase.resetNoViewMode();
                return true;
            }
            case 47: {
                pSSystemBase.resetPIAutoShowCaption();
                return true;
            }
            case 48: {
                pSSystemBase.resetPSDepSlnPrdId();
                return true;
            }
            case 49: {
                pSSystemBase.resetPSDevCenterId();
                return true;
            }
            case 50: {
                pSSystemBase.resetPSDevCenterName();
                return true;
            }
            case 51: {
                pSSystemBase.resetPSDevCenterTSId();
                return true;
            }
            case 52: {
                pSSystemBase.resetPSDevCenterTSName();
                return true;
            }
            case 53: {
                pSSystemBase.resetPSDevSlnId();
                return true;
            }
            case 54: {
                pSSystemBase.resetPSDevSlnName();
                return true;
            }
            case 55: {
                pSSystemBase.resetPSDevSlnSysId();
                return true;
            }
            case 56: {
                pSSystemBase.resetPSLanguageId();
                return true;
            }
            case 57: {
                pSSystemBase.resetPSLanguageName();
                return true;
            }
            case 58: {
                pSSystemBase.resetPSSFId();
                return true;
            }
            case 59: {
                pSSystemBase.resetPSSFName();
                return true;
            }
            case 60: {
                pSSystemBase.resetPSSFPubsCnt();
                return true;
            }
            case 61: {
                pSSystemBase.resetPSSysDevBKTasksCnt();
                return true;
            }
            case 62: {
                pSSystemBase.resetPSSysEngineCfgId();
                return true;
            }
            case 63: {
                pSSystemBase.resetPSSysEngineCfgName();
                return true;
            }
            case 64: {
                pSSystemBase.resetPSSysIssuesCnt();
                return true;
            }
            case 65: {
                pSSystemBase.resetPSSysModelInstId();
                return true;
            }
            case 66: {
                pSSystemBase.resetPSSysTasksCnt();
                return true;
            }
            case 67: {
                pSSystemBase.resetPSSystemId();
                return true;
            }
            case 68: {
                pSSystemBase.resetPSSystemName();
                return true;
            }
            case 69: {
                pSSystemBase.resetPSWFsCnt();
                return true;
            }
            case 70: {
                pSSystemBase.resetPubDBModelFlag();
                return true;
            }
            case 71: {
                pSSystemBase.resetSaaSMode();
                return true;
            }
            case 72: {
                pSSystemBase.resetScriptEngine();
                return true;
            }
            case 73: {
                pSSystemBase.resetServiceAPIFlag();
                return true;
            }
            case 74: {
                pSSystemBase.resetSimActionLogics();
                return true;
            }
            case 75: {
                pSSystemBase.resetSrcPSSystemId();
                return true;
            }
            case 76: {
                pSSystemBase.resetSrcPSSystemName();
                return true;
            }
            case 77: {
                pSSystemBase.resetSSDEMSActionLogicFlag();
                return true;
            }
            case 78: {
                pSSystemBase.resetSysFolder();
                return true;
            }
            case 79: {
                pSSystemBase.resetSysRowKey();
                return true;
            }
            case 80: {
                pSSystemBase.resetSysType();
                return true;
            }
            case 81: {
                pSSystemBase.resetSysVer();
                return true;
            }
            case 82: {
                pSSystemBase.resetTags();
                return true;
            }
            case 83: {
                pSSystemBase.resetTemplEngine();
                return true;
            }
            case 84: {
                pSSystemBase.resetUpdateDate();
                return true;
            }
            case 85: {
                pSSystemBase.resetUpdateMan();
                return true;
            }
            case 86: {
                pSSystemBase.resetUserParams();
                return true;
            }
            case 87: {
                pSSystemBase.resetViewUARegMode();
                return true;
            }
            case 88: {
                pSSystemBase.resetWebPSAppsCnt();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterTS getPSDevCenterTS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTS();
        }
        if (this.getPSDevCenterTSId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterTSLock;
        synchronized (n) {
            if (this.psdevcenterts != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterTSId(), (Object)this.psdevcenterts.getPSDevCenterTSId()) != 0L) {
                this.psdevcenterts = null;
            }
            if (this.psdevcenterts == null) {
                PSDevCenterTS pSDevCenterTS = new PSDevCenterTS();
                pSDevCenterTS.setPSDevCenterTSId(this.getPSDevCenterTSId());
                PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterTSService.autoGet(pSDevCenterTS);
                this.psdevcenterts = pSDevCenterTS;
            }
            return this.psdevcenterts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCLEmptyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLEmptyTextPSLanRes();
        }
        if (this.getCLEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCLEmptyTextPSLanResLock;
        synchronized (n) {
            if (this.clemptytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCLEmptyTextPSLanResId(), (Object)this.clemptytextpslanres.getPSLanguageResId()) != 0L) {
                this.clemptytextpslanres = null;
            }
            if (this.clemptytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCLEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.clemptytextpslanres = pSLanguageRes;
            }
            return this.clemptytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguage getPSLanguage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguage();
        }
        if (this.getPSLanguageId() == null) {
            return null;
        }
        Integer n = this.objPSLanguageLock;
        synchronized (n) {
            if (this.pslanguage != null && DataTypeHelper.compare((int)25, (Object)this.getPSLanguageId(), (Object)this.pslanguage.getPSLanguageId()) != 0L) {
                this.pslanguage = null;
            }
            if (this.pslanguage == null) {
                PSLanguage pSLanguage = new PSLanguage();
                pSLanguage.setPSLanguageId(this.getPSLanguageId());
                PSLanguageService pSLanguageService = (PSLanguageService)ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageService.autoGet(pSLanguage);
                this.pslanguage = pSLanguage;
            }
            return this.pslanguage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEngineCfg getPSSysEngineCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEngineCfg();
        }
        if (this.getPSSysEngineCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSysEngineCfgLock;
        synchronized (n) {
            if (this.pssysenginecfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEngineCfgId(), (Object)this.pssysenginecfg.getPSSysEngineCfgId()) != 0L) {
                this.pssysenginecfg = null;
            }
            if (this.pssysenginecfg == null) {
                PSSysEngineCfg pSSysEngineCfg = new PSSysEngineCfg();
                pSSysEngineCfg.setPSSysEngineCfgId(this.getPSSysEngineCfgId());
                PSSysEngineCfgService pSSysEngineCfgService = (PSSysEngineCfgService)ServiceGlobal.getService(PSSysEngineCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSysEngineCfgService.autoGet(pSSysEngineCfg);
                this.pssysenginecfg = pSSysEngineCfg;
            }
            return this.pssysenginecfg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getSrcPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSSystem();
        }
        if (this.getSrcPSSystemId() == null) {
            return null;
        }
        Integer n = this.objSrcPSSystemLock;
        synchronized (n) {
            if (this.srcpssystem != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSSystemId(), (Object)this.srcpssystem.getPSSystemId()) != 0L) {
                this.srcpssystem = null;
            }
            if (this.srcpssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getSrcPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.srcpssystem = pSSystem;
            }
            return this.srcpssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionTempl> getPSDEActionTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTempls();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSDEActionTemplService pSDEActionTemplService = (PSDEActionTemplService)ServiceGlobal.getService(PSDEActionTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionTemplsLock;
        synchronized (n) {
            if (this.psdeactiontempls == null) {
                this.psdeactiontempls = pSDEActionTemplService.selectByPSSystem(this);
            }
            return this.psdeactiontempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGroup> getPSDEGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroups();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGroupsLock;
        synchronized (n) {
            if (this.psdegroups == null) {
                this.psdegroups = pSDEGroupService.selectByPSSystem(this);
            }
            return this.psdegroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDERGroup> getPSDERGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroups();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERGroupsLock;
        synchronized (n) {
            if (this.psdergroups == null) {
                this.psdergroups = pSDERGroupService.selectByPSSystem(this);
            }
            return this.psdergroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewGroup> getPSDEViewGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroups();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSDEViewGroupService pSDEViewGroupService = (PSDEViewGroupService)ServiceGlobal.getService(PSDEViewGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewGroupsLock;
        synchronized (n) {
            if (this.psdeviewgroups == null) {
                this.psdeviewgroups = pSDEViewGroupService.selectByPSSystem(this);
            }
            return this.psdeviewgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDETempl> getPSDynaDETempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDETempls();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSDynaDETemplService pSDynaDETemplService = (PSDynaDETemplService)ServiceGlobal.getService(PSDynaDETemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDETemplsLock;
        synchronized (n) {
            if (this.psdynadetempls == null) {
                this.psdynadetempls = pSDynaDETemplService.selectByPSSystem(this);
            }
            return this.psdynadetempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelMemo> getPSModelMemos() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelMemos();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSModelMemoService pSModelMemoService = (PSModelMemoService)ServiceGlobal.getService(PSModelMemoService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelMemosLock;
        synchronized (n) {
            if (this.psmodelmemos == null) {
                this.psmodelmemos = pSModelMemoService.selectByPSSystem(this);
            }
            return this.psmodelmemos;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModule> getPSModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModules();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModulesLock;
        synchronized (n) {
            if (this.psmodules == null) {
                this.psmodules = pSModuleService.selectByPSSystem(this);
            }
            return this.psmodules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysServiceAPI> getPSSubSysServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysServiceAPIsLock;
        synchronized (n) {
            if (this.pssubsysserviceapis == null) {
                this.pssubsysserviceapis = pSSubSysServiceAPIService.selectByPSSystem(this);
            }
            return this.pssubsysserviceapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysAIFactory> getPSSysAIFactories() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactories();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysAIFactoryService pSSysAIFactoryService = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIFactoriesLock;
        synchronized (n) {
            if (this.pssysaifactories == null) {
                this.pssysaifactories = pSSysAIFactoryService.selectByPSSystem(this);
            }
            return this.pssysaifactories;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysApp> getPSSysApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApps();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAppsLock;
        synchronized (n) {
            if (this.pssysapps == null) {
                this.pssysapps = pSSysAppService.selectByPSSystem(this);
            }
            return this.pssysapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBIScheme> getPSSysBISchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBISchemesLock;
        synchronized (n) {
            if (this.pssysbischemes == null) {
                this.pssysbischemes = pSSysBISchemeService.selectByPSSystem(this);
            }
            return this.pssysbischemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCanvas> getPSSysCanvases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvases();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysCanvasService pSSysCanvasService = (PSSysCanvasService)ServiceGlobal.getService(PSSysCanvasService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCanvasesLock;
        synchronized (n) {
            if (this.pssyscanvases == null) {
                this.pssyscanvases = pSSysCanvasService.selectByPSSystem(this);
            }
            return this.pssyscanvases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysChartTheme> getPSSysChartThemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysChartThemes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysChartThemeService pSSysChartThemeService = (PSSysChartThemeService)ServiceGlobal.getService(PSSysChartThemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysChartThemesLock;
        synchronized (n) {
            if (this.pssyschartthemes == null) {
                this.pssyschartthemes = pSSysChartThemeService.selectByPSSystem(this);
            }
            return this.pssyschartthemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCodeSnippet> getPSSysCodeSnippets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCodeSnippets();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysCodeSnippetService pSSysCodeSnippetService = (PSSysCodeSnippetService)ServiceGlobal.getService(PSSysCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCodeSnippetsLock;
        synchronized (n) {
            if (this.pssyscodesnippets == null) {
                this.pssyscodesnippets = pSSysCodeSnippetService.selectByPSSystem(this);
            }
            return this.pssyscodesnippets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysContentCat> getPSSysContentCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCats();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysContentCatService pSSysContentCatService = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysContentCatsLock;
        synchronized (n) {
            if (this.pssyscontentcats == null) {
                this.pssyscontentcats = pSSysContentCatService.selectByPSSystem(this);
            }
            return this.pssyscontentcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysContent> getPSSysContents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContents();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysContentService pSSysContentService = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysContentsLock;
        synchronized (n) {
            if (this.pssyscontents == null) {
                this.pssyscontents = pSSysContentService.selectByPSSystem(this);
            }
            return this.pssyscontents;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDashboard> getPSSysDashboards() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboards();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDashboardsLock;
        synchronized (n) {
            if (this.pssysdashboards == null) {
                this.pssysdashboards = pSSysDashboardService.selectByPSSystem(this);
            }
            return this.pssysdashboards;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBScheme> getPSSysDBSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBSchemesLock;
        synchronized (n) {
            if (this.pssysdbschemes == null) {
                this.pssysdbschemes = pSSysDBSchemeService.selectByPSSystem(this);
            }
            return this.pssysdbschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBVF> getPSSysDBVFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBVFsLock;
        synchronized (n) {
            if (this.pssysdbvfs == null) {
                this.pssysdbvfs = pSSysDBVFService.selectByPSSystem(this);
            }
            return this.pssysdbvfs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDevBKTask> getPSSysDevBKTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBKTasks();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysDevBKTaskService pSSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDevBKTasksLock;
        synchronized (n) {
            if (this.pssysdevbktasks == null) {
                this.pssysdevbktasks = pSSysDevBKTaskService.selectByPSSystem(this);
            }
            return this.pssysdevbktasks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDMVer> getPSSysDMVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVers();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysDMVerService pSSysDMVerService = (PSSysDMVerService)ServiceGlobal.getService(PSSysDMVerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDMVersLock;
        synchronized (n) {
            if (this.pssysdmvers == null) {
                this.pssysdmvers = pSSysDMVerService.selectByPSSystem(this);
            }
            return this.pssysdmvers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIScheme> getPSSysEAISchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAISchemesLock;
        synchronized (n) {
            if (this.pssyseaischemes == null) {
                this.pssyseaischemes = pSSysEAISchemeService.selectByPSSystem(this);
            }
            return this.pssyseaischemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysFile> getPSSysFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFiles();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysFileService pSSysFileService = (PSSysFileService)ServiceGlobal.getService(PSSysFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysFilesLock;
        synchronized (n) {
            if (this.pssysfiles == null) {
                this.pssysfiles = pSSysFileService.selectByPSSystem(this);
            }
            return this.pssysfiles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysIssue> getPSSysIssues() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssues();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysIssueService pSSysIssueService = (PSSysIssueService)ServiceGlobal.getService(PSSysIssueService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysIssuesLock;
        synchronized (n) {
            if (this.pssysissues == null) {
                this.pssysissues = pSSysIssueService.selectByPSSystem(this);
            }
            return this.pssysissues;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysMapView> getPSSysMapViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViews();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMapViewsLock;
        synchronized (n) {
            if (this.pssysmapviews == null) {
                this.pssysmapviews = pSSysMapViewService.selectByPSSystem(this);
            }
            return this.pssysmapviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysModelGroup> getPSSysModelGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroups();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysModelGroupService pSSysModelGroupService = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysModelGroupsLock;
        synchronized (n) {
            if (this.pssysmodelgroups == null) {
                this.pssysmodelgroups = pSSysModelGroupService.selectByPSSystem(this);
            }
            return this.pssysmodelgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysMsgQueue> getPSSysMsgQueues() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueues();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysMsgQueueService pSSysMsgQueueService = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMsgQueuesLock;
        synchronized (n) {
            if (this.pssysmsgqueues == null) {
                this.pssysmsgqueues = pSSysMsgQueueService.selectByPSSystem(this);
            }
            return this.pssysmsgqueues;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysOUType> getPSSysOUTypes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOUTypes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysOUTypeService pSSysOUTypeService = (PSSysOUTypeService)ServiceGlobal.getService(PSSysOUTypeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysOUTypesLock;
        synchronized (n) {
            if (this.pssysoutypes == null) {
                this.pssysoutypes = pSSysOUTypeService.selectByPSSystem(this);
            }
            return this.pssysoutypes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPortletCat> getPSSysPortletCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCats();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysPortletCatService pSSysPortletCatService = (PSSysPortletCatService)ServiceGlobal.getService(PSSysPortletCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPortletCatsLock;
        synchronized (n) {
            if (this.pssysportletcats == null) {
                this.pssysportletcats = pSSysPortletCatService.selectByPSSystem(this);
            }
            return this.pssysportletcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysProject> getPSSysProjects() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProjects();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysProjectsLock;
        synchronized (n) {
            if (this.pssysprojects == null) {
                this.pssysprojects = pSSysProjectService.selectByPSSystem(this);
            }
            return this.pssysprojects;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysResource> getPSSysResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResources();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysResourcesLock;
        synchronized (n) {
            if (this.pssysresources == null) {
                this.pssysresources = pSSysResourceService.selectByPSSystem(this);
            }
            return this.pssysresources;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSampleValue> getPSSysSampleValues() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValues();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSampleValuesLock;
        synchronized (n) {
            if (this.pssyssamplevalues == null) {
                this.pssyssamplevalues = pSSysSampleValueService.selectByPSSystem(this);
            }
            return this.pssyssamplevalues;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchScheme> getPSSysSearchSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemes();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchSchemesLock;
        synchronized (n) {
            if (this.pssyssearchschemes == null) {
                this.pssyssearchschemes = pSSysSearchSchemeService.selectByPSSystem(this);
            }
            return this.pssyssearchschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSequence> getPSSysSequences() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequences();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysSequenceService pSSysSequenceService = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSequencesLock;
        synchronized (n) {
            if (this.pssyssequences == null) {
                this.pssyssequences = pSSysSequenceService.selectByPSSystem(this);
            }
            return this.pssyssequences;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysServiceAPI> getPSSysServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysServiceAPIsLock;
        synchronized (n) {
            if (this.pssysserviceapis == null) {
                this.pssysserviceapis = pSSysServiceAPIService.selectByPSSystem(this);
            }
            return this.pssysserviceapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFPub> getPSSysSFPubs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFPubsLock;
        synchronized (n) {
            if (this.pssyssfpubs == null) {
                this.pssyssfpubs = pSSysSFPubService.selectByPSSystem(this);
            }
            return this.pssyssfpubs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSQLCmd> getPSSysSqlCmds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSqlCmds();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysSQLCmdService pSSysSQLCmdService = (PSSysSQLCmdService)ServiceGlobal.getService(PSSysSQLCmdService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSqlCmdsLock;
        synchronized (n) {
            if (this.pssyssqlcmds == null) {
                this.pssyssqlcmds = pSSysSQLCmdService.selectByPSSystem(this);
            }
            return this.pssyssqlcmds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTask> getPSSysTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasks();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTasksLock;
        synchronized (n) {
            if (this.pssystasks == null) {
                this.pssystasks = pSSysTaskService.selectByPSSystem(this);
            }
            return this.pssystasks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSystemMQ> getPSSystemMQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemMQ();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSystemMQService pSSystemMQService = (PSSystemMQService)ServiceGlobal.getService(PSSystemMQService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSystemMQLock;
        synchronized (n) {
            if (this.pssystemmq == null) {
                this.pssystemmq = pSSystemMQService.selectByPSSystem(this);
            }
            return this.pssystemmq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSystemRun> getPSSystemRuns() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemRuns();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSystemRunService pSSystemRunService = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSystemRunsLock;
        synchronized (n) {
            if (this.pssystemruns == null) {
                this.pssystemruns = pSSystemRunService.selectByPSSystem(this);
            }
            return this.pssystemruns;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestPrj> getPSSysTestPrjs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysTestPrjService pSSysTestPrjService = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestPrjsLock;
        synchronized (n) {
            if (this.pssystestprjs == null) {
                this.pssystestprjs = pSSysTestPrjService.selectByPSSystem(this);
            }
            return this.pssystestprjs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTitleBar> getPSSysTitleBars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTitleBars();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysTitleBarService pSSysTitleBarService = (PSSysTitleBarService)ServiceGlobal.getService(PSSysTitleBarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTitleBarsLock;
        synchronized (n) {
            if (this.pssystitlebars == null) {
                this.pssystitlebars = pSSysTitleBarService.selectByPSSystem(this);
            }
            return this.pssystitlebars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTranslator> getPSSysTranslators() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslators();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTranslatorsLock;
        synchronized (n) {
            if (this.pssystranslators == null) {
                this.pssystranslators = pSSysTranslatorService.selectByPSSystem(this);
            }
            return this.pssystranslators;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUCMap> getPSSysUCMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMaps();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUCMapService pSSysUCMapService = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUCMapsLock;
        synchronized (n) {
            if (this.pssysucmaps == null) {
                this.pssysucmaps = pSSysUCMapService.selectByPSSystem(this);
            }
            return this.pssysucmaps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUniRes> getPSSysUniReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniReses();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUniResesLock;
        synchronized (n) {
            if (this.pssysunireses == null) {
                this.pssysunireses = pSSysUniResService.selectByPSSystem(this);
            }
            return this.pssysunireses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUniState> getPSSysUniStates() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStates();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUniStateService pSSysUniStateService = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUniStatesLock;
        synchronized (n) {
            if (this.pssysunistates == null) {
                this.pssysunistates = pSSysUniStateService.selectByPSSystem(this);
            }
            return this.pssysunistates;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUnit> getPSSysUnits() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnits();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUnitService pSSysUnitService = (PSSysUnitService)ServiceGlobal.getService(PSSysUnitService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUnitsLock;
        synchronized (n) {
            if (this.pssysunits == null) {
                this.pssysunits = pSSysUnitService.selectByPSSystem(this);
            }
            return this.pssysunits;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUseCaseCat> getPSSysUseCaseCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCats();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUseCaseCatService pSSysUseCaseCatService = (PSSysUseCaseCatService)ServiceGlobal.getService(PSSysUseCaseCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUseCaseCatsLock;
        synchronized (n) {
            if (this.pssysusecasecats == null) {
                this.pssysusecasecats = pSSysUseCaseCatService.selectByPSSystem(this);
            }
            return this.pssysusecasecats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserCaseRS> getPSSysUserCaseRSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseRSs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUserCaseRSService pSSysUserCaseRSService = (PSSysUserCaseRSService)ServiceGlobal.getService(PSSysUserCaseRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserCaseRSsLock;
        synchronized (n) {
            if (this.pssysusercaserss == null) {
                this.pssysusercaserss = pSSysUserCaseRSService.selectByPSSystem(this);
            }
            return this.pssysusercaserss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserDR> getPSSysUserDRs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserDRsLock;
        synchronized (n) {
            if (this.pssysuserdrs == null) {
                this.pssysuserdrs = pSSysUserDRService.selectByPSSystem(this);
            }
            return this.pssysuserdrs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUtilDE> getPSSysUtilDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEs();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUtilDEsLock;
        synchronized (n) {
            if (this.pssysutildes == null) {
                this.pssysutildes = pSSysUtilDEService.selectByPSSystem(this);
            }
            return this.pssysutildes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanel> getPSSysViewPanels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanels();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelsLock;
        synchronized (n) {
            if (this.pssysviewpanels == null) {
                this.pssysviewpanels = pSSysViewPanelService.selectByPSSystem(this);
            }
            return this.pssysviewpanels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysWFCat> getPSSysWFCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFCats();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSSysWFCatService pSSysWFCatService = (PSSysWFCatService)ServiceGlobal.getService(PSSysWFCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysWFCatsLock;
        synchronized (n) {
            if (this.pssyswfcats == null) {
                this.pssyswfcats = pSSysWFCatService.selectByPSSystem(this);
            }
            return this.pssyswfcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSThresholdGroup> getPSThresholdGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroups();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSThresholdGroupService pSThresholdGroupService = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSThresholdGroupsLock;
        synchronized (n) {
            if (this.psthresholdgroups == null) {
                this.psthresholdgroups = pSThresholdGroupService.selectByPSSystem(this);
            }
            return this.psthresholdgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWorkflow> getPSWorkflows() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflows();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWorkflowsLock;
        synchronized (n) {
            if (this.psworkflows == null) {
                this.psworkflows = pSWorkflowService.selectByPSSystem(this);
            }
            return this.psworkflows;
        }
    }

    private PSSystemBase getProxyEntity() {
        return this.proxyPSSystemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSystemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSystemBase) {
            this.proxyPSSystemBase = (PSSystemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACCCTRLARCH, 0);
        fieldIndexMap.put(FIELD_AUTOCALCDERER, 1);
        fieldIndexMap.put(FIELD_BUGFIXS, 2);
        fieldIndexMap.put(FIELD_CHECKMODELVER, 3);
        fieldIndexMap.put(FIELD_CLEMPTYTEXT, 4);
        fieldIndexMap.put(FIELD_CLEMPTYTEXTPSLANRESID, 5);
        fieldIndexMap.put(FIELD_CLEMPTYTEXTPSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_CODENAME, 7);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_CTRLAPPENDDEITEMS, 11);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 12);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 13);
        fieldIndexMap.put(FIELD_DBTYPES, 14);
        fieldIndexMap.put(FIELD_DBVERSION, 15);
        fieldIndexMap.put(FIELD_DEDSMAXROWCNT, 16);
        fieldIndexMap.put(FIELD_DEEXPMAXROWCNT, 17);
        fieldIndexMap.put(FIELD_DEFPSSYSDEPLOYID, 18);
        fieldIndexMap.put(FIELD_DEFSFITEMWIDTH, 19);
        fieldIndexMap.put(FIELD_DEFSORTMODE, 20);
        fieldIndexMap.put(FIELD_DEMSACTIONLOGICFLAG, 21);
        fieldIndexMap.put(FIELD_DOMAINNAME, 22);
        fieldIndexMap.put(FIELD_DTOFORMAT, 23);
        fieldIndexMap.put(FIELD_ENABLEDBVALUEMODE, 24);
        fieldIndexMap.put(FIELD_ENABLEDEDATAVER, 25);
        fieldIndexMap.put(FIELD_ENABLEDEFRESTRICTEDUI, 26);
        fieldIndexMap.put(FIELD_ENABLEDERFKEY, 27);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 28);
        fieldIndexMap.put(FIELD_ENABLEFOLDERKEY, 29);
        fieldIndexMap.put(FIELD_ENABLEMULTILAN, 30);
        fieldIndexMap.put(FIELD_ENABLEOPNAMEMODEL, 31);
        fieldIndexMap.put(FIELD_ENABLEPQL, 32);
        fieldIndexMap.put(FIELD_ENADEFLANRESCONTENT, 33);
        fieldIndexMap.put(FIELD_ENTITYCNT, 34);
        fieldIndexMap.put(FIELD_EXTRACTDEFAULT, 35);
        fieldIndexMap.put(FIELD_INITDEDEFAULT, 36);
        fieldIndexMap.put(FIELD_LANRESMAXTAG, 37);
        fieldIndexMap.put(FIELD_LOGICNAME, 38);
        fieldIndexMap.put(FIELD_LOWCODEMODE, 39);
        fieldIndexMap.put(FIELD_LOWCODEOPTION, 40);
        fieldIndexMap.put(FIELD_MAXENTITYCNT, 41);
        fieldIndexMap.put(FIELD_MEMO, 42);
        fieldIndexMap.put(FIELD_MOBPSAPPSCNT, 43);
        fieldIndexMap.put(FIELD_MODELV2EXPMODE, 44);
        fieldIndexMap.put(FIELD_MODELVER, 45);
        fieldIndexMap.put(FIELD_NOVIEWMODE, 46);
        fieldIndexMap.put(FIELD_PIAUTOSHOWCAPTION, 47);
        fieldIndexMap.put(FIELD_PSDEPSLNPRDID, 48);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 49);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 50);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSID, 51);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSNAME, 52);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 53);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 54);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 55);
        fieldIndexMap.put(FIELD_PSLANGUAGEID, 56);
        fieldIndexMap.put(FIELD_PSLANGUAGENAME, 57);
        fieldIndexMap.put(FIELD_PSSFID, 58);
        fieldIndexMap.put(FIELD_PSSFNAME, 59);
        fieldIndexMap.put(FIELD_PSSFPUBSCNT, 60);
        fieldIndexMap.put(FIELD_PSSYSDEVBKTASKSCNT, 61);
        fieldIndexMap.put(FIELD_PSSYSENGINECFGID, 62);
        fieldIndexMap.put(FIELD_PSSYSENGINECFGNAME, 63);
        fieldIndexMap.put(FIELD_PSSYSISSUESCNT, 64);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 65);
        fieldIndexMap.put(FIELD_PSSYSTASKSCNT, 66);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 67);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 68);
        fieldIndexMap.put(FIELD_PSWFSCNT, 69);
        fieldIndexMap.put(FIELD_PUBDBMODELFLAG, 70);
        fieldIndexMap.put(FIELD_SAASMODE, 71);
        fieldIndexMap.put(FIELD_SCRIPTENGINE, 72);
        fieldIndexMap.put(FIELD_SERVICEAPIFLAG, 73);
        fieldIndexMap.put(FIELD_SIMACTIONLOGICS, 74);
        fieldIndexMap.put(FIELD_SRCPSSYSTEMID, 75);
        fieldIndexMap.put(FIELD_SRCPSSYSTEMNAME, 76);
        fieldIndexMap.put(FIELD_SSDEMSACTIONLOGICFLAG, 77);
        fieldIndexMap.put(FIELD_SYSFOLDER, 78);
        fieldIndexMap.put(FIELD_SYSROWKEY, 79);
        fieldIndexMap.put(FIELD_SYSTYPE, 80);
        fieldIndexMap.put(FIELD_SYSVER, 81);
        fieldIndexMap.put(FIELD_TAGS, 82);
        fieldIndexMap.put(FIELD_TEMPLENGINE, 83);
        fieldIndexMap.put(FIELD_UPDATEDATE, 84);
        fieldIndexMap.put(FIELD_UPDATEMAN, 85);
        fieldIndexMap.put(FIELD_USERPARAMS, 86);
        fieldIndexMap.put(FIELD_VIEWUAREGMODE, 87);
        fieldIndexMap.put(FIELD_WEBPSAPPSCNT, 88);
    }
}

