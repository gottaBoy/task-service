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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionTempl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionTemplService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpPrj;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResource;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpPrjService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvas;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysChartTheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysFile;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOrgType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUseCaseCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserMode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewWizardGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysChartThemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysFileService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOrgTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUseCaseCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFMode;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTime;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFModeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModuleBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAMEMODE = "CODENAMEMODE";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DSLINK = "DSLINK";
    public static final String FIELD_DTOFORMAT = "DTOFORMAT";
    public static final String FIELD_DYNAINSTMODE = "DYNAINSTMODE";
    public static final String FIELD_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String FIELD_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String FIELD_ENABLEPQL = "ENABLEPQL";
    public static final String FIELD_LANRESTAG = "LANRESTAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODTAG = "MODTAG";
    public static final String FIELD_MODTAG2 = "MODTAG2";
    public static final String FIELD_MODTAG3 = "MODTAG3";
    public static final String FIELD_MODTAG4 = "MODTAG4";
    public static final String FIELD_MODULESN = "MODULESN";
    public static final String FIELD_NOVIEWMODE = "NOVIEWMODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKGCODENAME = "PKGCODENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSREFID = "PSSYSREFID";
    public static final String FIELD_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_REQMODULE = "REQMODULE";
    public static final String FIELD_RUNTIMETYPE = "RUNTIMETYPE";
    public static final String FIELD_SERVICEAPIFLAG = "SERVICEAPIFLAG";
    public static final String FIELD_SHORTTAG = "SHORTTAG";
    public static final String FIELD_SUBSYSMODULE = "SUBSYSMODULE";
    public static final String FIELD_SYSREFTYPE = "SYSREFTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILTAG = "UTILTAG";
    public static final String FIELD_UTILTYPE = "UTILTYPE";
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAMEMODE = 2;
    private static final int INDEX_COLOR = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTFLAG = 6;
    private static final int INDEX_DSLINK = 7;
    private static final int INDEX_DTOFORMAT = 8;
    private static final int INDEX_DYNAINSTMODE = 9;
    private static final int INDEX_DYNAINSTTAG = 10;
    private static final int INDEX_DYNAINSTTAG2 = 11;
    private static final int INDEX_ENABLEPQL = 12;
    private static final int INDEX_LANRESTAG = 13;
    private static final int INDEX_LOCKFLAG = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MODTAG = 16;
    private static final int INDEX_MODTAG2 = 17;
    private static final int INDEX_MODTAG3 = 18;
    private static final int INDEX_MODTAG4 = 19;
    private static final int INDEX_MODULESN = 20;
    private static final int INDEX_NOVIEWMODE = 21;
    private static final int INDEX_ORDERVALUE = 22;
    private static final int INDEX_PKGCODENAME = 23;
    private static final int INDEX_PSMODULEID = 24;
    private static final int INDEX_PSMODULENAME = 25;
    private static final int INDEX_PSSYSMODELGROUPID = 26;
    private static final int INDEX_PSSYSMODELGROUPNAME = 27;
    private static final int INDEX_PSSYSREFID = 28;
    private static final int INDEX_PSSYSREFNAME = 29;
    private static final int INDEX_PSSYSSFPUBID = 30;
    private static final int INDEX_PSSYSSFPUBNAME = 31;
    private static final int INDEX_PSSYSTEMID = 32;
    private static final int INDEX_PSSYSTEMNAME = 33;
    private static final int INDEX_REQMODULE = 34;
    private static final int INDEX_RUNTIMETYPE = 35;
    private static final int INDEX_SERVICEAPIFLAG = 36;
    private static final int INDEX_SHORTTAG = 37;
    private static final int INDEX_SUBSYSMODULE = 38;
    private static final int INDEX_SYSREFTYPE = 39;
    private static final int INDEX_UPDATEDATE = 40;
    private static final int INDEX_UPDATEMAN = 41;
    private static final int INDEX_USERCAT = 42;
    private static final int INDEX_USERPARAMS = 43;
    private static final int INDEX_USERTAG = 44;
    private static final int INDEX_USERTAG2 = 45;
    private static final int INDEX_USERTAG3 = 46;
    private static final int INDEX_USERTAG4 = 47;
    private static final int INDEX_UTILPARAMS = 48;
    private static final int INDEX_UTILTAG = 49;
    private static final int INDEX_UTILTYPE = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModuleBase proxyPSModuleBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codenamemodeDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dslinkDirtyFlag = false;
    private boolean dtoformatDirtyFlag = false;
    private boolean dynainstmodeDirtyFlag = false;
    private boolean dynainsttagDirtyFlag = false;
    private boolean dynainsttag2DirtyFlag = false;
    private boolean enablepqlDirtyFlag = false;
    private boolean lanrestagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modtagDirtyFlag = false;
    private boolean modtag2DirtyFlag = false;
    private boolean modtag3DirtyFlag = false;
    private boolean modtag4DirtyFlag = false;
    private boolean modulesnDirtyFlag = false;
    private boolean noviewmodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkgcodenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssysrefidDirtyFlag = false;
    private boolean pssysrefnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean reqmoduleDirtyFlag = false;
    private boolean runtimetypeDirtyFlag = false;
    private boolean serviceapiflagDirtyFlag = false;
    private boolean shorttagDirtyFlag = false;
    private boolean subsysmoduleDirtyFlag = false;
    private boolean sysreftypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utiltagDirtyFlag = false;
    private boolean utiltypeDirtyFlag = false;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="codename")
    private String codename;
    @Column(name="codenamemode")
    private String codenamemode;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dslink")
    private String dslink;
    @Column(name="dtoformat")
    private String dtoformat;
    @Column(name="dynainstmode")
    private Integer dynainstmode;
    @Column(name="dynainsttag")
    private String dynainsttag;
    @Column(name="dynainsttag2")
    private String dynainsttag2;
    @Column(name="enablepql")
    private Integer enablepql;
    @Column(name="lanrestag")
    private String lanrestag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modtag")
    private String modtag;
    @Column(name="modtag2")
    private String modtag2;
    @Column(name="modtag3")
    private String modtag3;
    @Column(name="modtag4")
    private String modtag4;
    @Column(name="modulesn")
    private String modulesn;
    @Column(name="noviewmode")
    private Integer noviewmode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pkgcodename")
    private String pkgcodename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
    @Column(name="pssysrefid")
    private String pssysrefid;
    @Column(name="pssysrefname")
    private String pssysrefname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="reqmodule")
    private Integer reqmodule;
    @Column(name="runtimetype")
    private String runtimetype;
    @Column(name="serviceapiflag")
    private Integer serviceapiflag;
    @Column(name="shorttag")
    private String shorttag;
    @Column(name="subsysmodule")
    private Integer subsysmodule;
    @Column(name="sysreftype")
    private String sysreftype;
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
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="utiltag")
    private String utiltag;
    @Column(name="utiltype")
    private String utiltype;
    private Integer objPSSysModelGroupLock = new Integer(1);
    private PSSysModelGroup pssysmodelgroup = null;
    private Integer objPSSysRefLock = new Integer(1);
    private PSSysRef pssysref = null;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSACHandlersLock = new Integer(1);
    private ArrayList<PSACHandler> psachandlers = null;
    private Integer objPSCodeListsLock = new Integer(1);
    private ArrayList<PSCodeList> pscodelists = null;
    private Integer objPSCtrlLogicGroupsLock = new Integer(1);
    private ArrayList<PSCtrlLogicGroup> psctrllogicgroups = null;
    private Integer objPSCtrlMsgsLock = new Integer(1);
    private ArrayList<PSCtrlMsg> psctrlmsgs = null;
    private Integer objPSDataEntitiesLock = new Integer(1);
    private ArrayList<PSDataEntity> psdataentities = null;
    private Integer objPSDEActionTemplsLock = new Integer(1);
    private ArrayList<PSDEActionTempl> psdeactiontempls = null;
    private Integer objPSDEFInputSetsLock = new Integer(1);
    private ArrayList<PSDEFInputTipSet> psdefinputsets = null;
    private Integer objPSDEFInputTipsLock = new Integer(1);
    private ArrayList<PSDEFInputTip> psdefinputtips = null;
    private Integer objPSDEGroupsLock = new Integer(1);
    private ArrayList<PSDEGroup> psdegroups = null;
    private Integer objPSDEOPPrivsLock = new Integer(1);
    private ArrayList<PSDEOPPriv> psdeopprivs = null;
    private Integer objPSDERGroupsLock = new Integer(1);
    private ArrayList<PSDERGroup> psdergroups = null;
    private Integer objPSDEToolbarsLock = new Integer(1);
    private ArrayList<PSDEToolbar> psdetoolbars = null;
    private Integer objPSDEUAGroupsLock = new Integer(1);
    private ArrayList<PSDEUAGroup> psdeuagroups = null;
    private Integer objPSDEUIActionsLock = new Integer(1);
    private ArrayList<PSDEUIAction> psdeuiactions = null;
    private Integer objPSHelpArticlesLock = new Integer(1);
    private ArrayList<PSHelpArticle> pshelparticles = null;
    private Integer objPSHelpPrjsLock = new Integer(1);
    private ArrayList<PSHelpPrj> pshelpprjs = null;
    private Integer objPSHelpResourcesLock = new Integer(1);
    private ArrayList<PSHelpResource> pshelpresources = null;
    private Integer objPSLanguageResesLock = new Integer(1);
    private ArrayList<PSLanguageRes> pslanguagereses = null;
    private Integer objPSSubSysServiceAPIsLock = new Integer(1);
    private ArrayList<PSSubSysServiceAPI> pssubsysserviceapis = null;
    private Integer objPSSubViewTypesLock = new Integer(1);
    private ArrayList<PSSubViewType> pssubviewtypes = null;
    private Integer objPSSysActorsLock = new Integer(1);
    private ArrayList<PSSysActor> pssysactors = null;
    private Integer objPSSysAIFactoriesLock = new Integer(1);
    private ArrayList<PSSysAIFactory> pssysaifactories = null;
    private Integer objPSSysAppsLock = new Integer(1);
    private ArrayList<PSSysApp> pssysapps = null;
    private Integer objPSSysBDSchemesLock = new Integer(1);
    private ArrayList<PSSysBDScheme> pssysbdschemes = null;
    private Integer objPSSysBISchemesLock = new Integer(1);
    private ArrayList<PSSysBIScheme> pssysbischemes = null;
    private Integer objPSSysCanvasesLock = new Integer(1);
    private ArrayList<PSSysCanvas> pssyscanvases = null;
    private Integer objPSSysChartThemesLock = new Integer(1);
    private ArrayList<PSSysChartTheme> pssyschartthemes = null;
    private Integer objPSSysContentsLock = new Integer(1);
    private ArrayList<PSSysContent> pssyscontents = null;
    private Integer objPSSysCountersLock = new Integer(1);
    private ArrayList<PSSysCounter> pssyscounters = null;
    private Integer objPSSysCssCatsLock = new Integer(1);
    private ArrayList<PSSysCssCat> pssyscsscats = null;
    private Integer objPSSysCssesLock = new Integer(1);
    private ArrayList<PSSysCss> pssyscsses = null;
    private Integer objPSSydDashboardsLock = new Integer(1);
    private ArrayList<PSSysDashboard> pssyddashboards = null;
    private Integer objPSSysDataSyncAgentsLock = new Integer(1);
    private ArrayList<PSSysDataSyncAgent> pssysdatasyncagents = null;
    private Integer objPSSysDBVFsLock = new Integer(1);
    private ArrayList<PSSysDBVF> pssysdbvfs = null;
    private Integer objPSSysDELogicNodesLock = new Integer(1);
    private ArrayList<PSSysDELogicNode> pssysdelogicnodes = null;
    private Integer objPSSysDictCatsLock = new Integer(1);
    private ArrayList<PSSysDictCat> pssysdictcats = null;
    private Integer objPSSysDynaModelsLock = new Integer(1);
    private ArrayList<PSSysDynaModel> pssysdynamodels = null;
    private Integer objPSSysEAISchemesLock = new Integer(1);
    private ArrayList<PSSysEAIScheme> pssyseaischemes = null;
    private Integer objPSSysEditorStylesLock = new Integer(1);
    private ArrayList<PSSysEditorStyle> pssyseditorstyles = null;
    private Integer objPSSysERMapsLock = new Integer(1);
    private ArrayList<PSSysERMap> pssysermaps = null;
    private Integer objPSSysFilesLock = new Integer(1);
    private ArrayList<PSSysFile> pssysfiles = null;
    private Integer objPSSysImagesLock = new Integer(1);
    private ArrayList<PSSysImage> pssysimages = null;
    private Integer objPSSysMsgTemplsLock = new Integer(1);
    private ArrayList<PSSysMsgTempl> pssysmsgtempls = null;
    private Integer objPSSysOPPrivsLock = new Integer(1);
    private ArrayList<PSSysOPPriv> pssysopprivs = null;
    private Integer objPSSysOrgTypesLock = new Integer(1);
    private ArrayList<PSSysOrgType> pssysorgtypes = null;
    private Integer objPSSysPDTViewsLock = new Integer(1);
    private ArrayList<PSSysPDTView> pssyspdtviews = null;
    private Integer objPSSysPFPluginsLock = new Integer(1);
    private ArrayList<PSSysPFPlugin> pssyspfplugins = null;
    private Integer objPSSysPortletCatsLock = new Integer(1);
    private ArrayList<PSSysPortletCat> pssysportletcats = null;
    private Integer objPSSysPortletsLock = new Integer(1);
    private ArrayList<PSSysPortlet> pssysportlets = null;
    private Integer objPSSysResourcesLock = new Integer(1);
    private ArrayList<PSSysResource> pssysresources = null;
    private Integer objPSSysSampleValuesLock = new Integer(1);
    private ArrayList<PSSysSampleValue> pssyssamplevalues = null;
    private Integer objPSSysSearchBarsLock = new Integer(1);
    private ArrayList<PSSysSearchBar> pssyssearchbars = null;
    private Integer objPSSysSearchSchemesLock = new Integer(1);
    private ArrayList<PSSysSearchScheme> pssyssearchschemes = null;
    private Integer objPSSysSequencesLock = new Integer(1);
    private ArrayList<PSSysSequence> pssyssequences = null;
    private Integer objPSSysServiceAPIsLock = new Integer(1);
    private ArrayList<PSSysServiceAPI> pssysserviceapis = null;
    private Integer objPSSysSFPluginsLock = new Integer(1);
    private ArrayList<PSSysSFPlugin> pssyssfplugins = null;
    private Integer objPSSysTasksLock = new Integer(1);
    private ArrayList<PSSysTask> pssystasks = null;
    private Integer objPSSysTestDatasLock = new Integer(1);
    private ArrayList<PSSysTestData> pssystestdatas = null;
    private Integer objPSSysTestPrjsLock = new Integer(1);
    private ArrayList<PSSysTestPrj> pssystestprjs = null;
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
    private Integer objPSSysUserCasesLock = new Integer(1);
    private ArrayList<PSSysUserCase> pssysusercases = null;
    private Integer objPSSysUserDRsLock = new Integer(1);
    private ArrayList<PSSysUserDR> pssysuserdrs = null;
    private Integer objPSSysUserModesLock = new Integer(1);
    private ArrayList<PSSysUserMode> pssysusermodes = null;
    private Integer objPSSysUtilDEsLock = new Integer(1);
    private ArrayList<PSSysUtilDE> pssysutildes = null;
    private Integer objPSSysValueRulesLock = new Integer(1);
    private ArrayList<PSSysValueRule> pssysvaluerules = null;
    private Integer objPSSysViewLogicsLock = new Integer(1);
    private ArrayList<PSSysViewLogic> pssysviewlogics = null;
    private Integer objPSSysViewPanelsLock = new Integer(1);
    private ArrayList<PSSysViewPanel> pssysviewpanels = null;
    private Integer objPSSysWFCatsLock = new Integer(1);
    private ArrayList<PSSysWFCat> pssyswfcats = null;
    private Integer objPSSysWFModesLock = new Integer(1);
    private ArrayList<PSSysWFMode> pssyswfmodes = null;
    private Integer objPSThresholdGroupsLock = new Integer(1);
    private ArrayList<PSThresholdGroup> psthresholdgroups = null;
    private Integer objPSViewMsgGroupsLock = new Integer(1);
    private ArrayList<PSViewMsgGroup> psviewmsggroups = null;
    private Integer objPSViewMsgLock = new Integer(1);
    private ArrayList<PSViewMsg> psviewmsg = null;
    private Integer objPSViewWizardGroupsLock = new Integer(1);
    private ArrayList<PSViewWizardGroup> psviewwizardgroups = null;
    private Integer objPSWFRolesLock = new Integer(1);
    private ArrayList<PSWFRole> pswfroles = null;
    private Integer objPSWFWorkTimesLock = new Integer(1);
    private ArrayList<PSWFWorkTime> pswfworktimes = null;
    private Integer objPSWorkflowsLock = new Integer(1);
    private ArrayList<PSWorkflow> psworkflows = null;
    private Integer objPSWXAccountsLock = new Integer(1);
    private ArrayList<PSWXAccount> pswxaccounts = null;

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDSLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dslink = string;
        this.dslinkDirtyFlag = true;
    }

    public String getDSLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSLink();
        }
        return this.dslink;
    }

    public boolean isDSLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSLinkDirty();
        }
        return this.dslinkDirtyFlag;
    }

    public void resetDSLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSLink();
            return;
        }
        this.dslinkDirtyFlag = false;
        this.dslink = null;
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

    public void setDynaInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstMode(n);
            return;
        }
        this.dynainstmode = n;
        this.dynainstmodeDirtyFlag = true;
    }

    public Integer getDynaInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstMode();
        }
        return this.dynainstmode;
    }

    public boolean isDynaInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstModeDirty();
        }
        return this.dynainstmodeDirtyFlag;
    }

    public void resetDynaInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstMode();
            return;
        }
        this.dynainstmodeDirtyFlag = false;
        this.dynainstmode = null;
    }

    public void setDynaInstTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag = string;
        this.dynainsttagDirtyFlag = true;
    }

    public String getDynaInstTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag();
        }
        return this.dynainsttag;
    }

    public boolean isDynaInstTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTagDirty();
        }
        return this.dynainsttagDirtyFlag;
    }

    public void resetDynaInstTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag();
            return;
        }
        this.dynainsttagDirtyFlag = false;
        this.dynainsttag = null;
    }

    public void setDynaInstTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag2 = string;
        this.dynainsttag2DirtyFlag = true;
    }

    public String getDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag2();
        }
        return this.dynainsttag2;
    }

    public boolean isDynaInstTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTag2Dirty();
        }
        return this.dynainsttag2DirtyFlag;
    }

    public void resetDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag2();
            return;
        }
        this.dynainsttag2DirtyFlag = false;
        this.dynainsttag2 = null;
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

    public void setLanResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanrestag = string;
        this.lanrestagDirtyFlag = true;
    }

    public String getLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResTag();
        }
        return this.lanrestag;
    }

    public boolean isLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResTagDirty();
        }
        return this.lanrestagDirtyFlag;
    }

    public void resetLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResTag();
            return;
        }
        this.lanrestagDirtyFlag = false;
        this.lanrestag = null;
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

    public void setModTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modtag = string;
        this.modtagDirtyFlag = true;
    }

    public String getModTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModTag();
        }
        return this.modtag;
    }

    public boolean isModTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModTagDirty();
        }
        return this.modtagDirtyFlag;
    }

    public void resetModTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModTag();
            return;
        }
        this.modtagDirtyFlag = false;
        this.modtag = null;
    }

    public void setModTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modtag2 = string;
        this.modtag2DirtyFlag = true;
    }

    public String getModTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModTag2();
        }
        return this.modtag2;
    }

    public boolean isModTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModTag2Dirty();
        }
        return this.modtag2DirtyFlag;
    }

    public void resetModTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModTag2();
            return;
        }
        this.modtag2DirtyFlag = false;
        this.modtag2 = null;
    }

    public void setModTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modtag3 = string;
        this.modtag3DirtyFlag = true;
    }

    public String getModTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModTag3();
        }
        return this.modtag3;
    }

    public boolean isModTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModTag3Dirty();
        }
        return this.modtag3DirtyFlag;
    }

    public void resetModTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModTag3();
            return;
        }
        this.modtag3DirtyFlag = false;
        this.modtag3 = null;
    }

    public void setModTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modtag4 = string;
        this.modtag4DirtyFlag = true;
    }

    public String getModTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModTag4();
        }
        return this.modtag4;
    }

    public boolean isModTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModTag4Dirty();
        }
        return this.modtag4DirtyFlag;
    }

    public void resetModTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModTag4();
            return;
        }
        this.modtag4DirtyFlag = false;
        this.modtag4 = null;
    }

    public void setModuleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulesn = string;
        this.modulesnDirtyFlag = true;
    }

    public String getModuleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleSN();
        }
        return this.modulesn;
    }

    public boolean isModuleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleSNDirty();
        }
        return this.modulesnDirtyFlag;
    }

    public void resetModuleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleSN();
            return;
        }
        this.modulesnDirtyFlag = false;
        this.modulesn = null;
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

    public void setPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgcodename = string;
        this.pkgcodenameDirtyFlag = true;
    }

    public String getPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGCodeName();
        }
        return this.pkgcodename;
    }

    public boolean isPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGCodeNameDirty();
        }
        return this.pkgcodenameDirtyFlag;
    }

    public void resetPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGCodeName();
            return;
        }
        this.pkgcodenameDirtyFlag = false;
        this.pkgcodename = null;
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

    public void setPSSysModelGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupid = string;
        this.pssysmodelgroupidDirtyFlag = true;
    }

    public String getPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupId();
        }
        return this.pssysmodelgroupid;
    }

    public boolean isPSSysModelGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupIdDirty();
        }
        return this.pssysmodelgroupidDirtyFlag;
    }

    public void resetPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupId();
            return;
        }
        this.pssysmodelgroupidDirtyFlag = false;
        this.pssysmodelgroupid = null;
    }

    public void setPSSysModelGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupname = string;
        this.pssysmodelgroupnameDirtyFlag = true;
    }

    public String getPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupName();
        }
        return this.pssysmodelgroupname;
    }

    public boolean isPSSysModelGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupNameDirty();
        }
        return this.pssysmodelgroupnameDirtyFlag;
    }

    public void resetPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupName();
            return;
        }
        this.pssysmodelgroupnameDirtyFlag = false;
        this.pssysmodelgroupname = null;
    }

    public void setPSSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefid = string;
        this.pssysrefidDirtyFlag = true;
    }

    public String getPSSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefId();
        }
        return this.pssysrefid;
    }

    public boolean isPSSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefIdDirty();
        }
        return this.pssysrefidDirtyFlag;
    }

    public void resetPSSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefId();
            return;
        }
        this.pssysrefidDirtyFlag = false;
        this.pssysrefid = null;
    }

    public void setPSSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefname = string;
        this.pssysrefnameDirtyFlag = true;
    }

    public String getPSSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefName();
        }
        return this.pssysrefname;
    }

    public boolean isPSSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefNameDirty();
        }
        return this.pssysrefnameDirtyFlag;
    }

    public void resetPSSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefName();
            return;
        }
        this.pssysrefnameDirtyFlag = false;
        this.pssysrefname = null;
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

    public void setReqModule(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqModule(n);
            return;
        }
        this.reqmodule = n;
        this.reqmoduleDirtyFlag = true;
    }

    public Integer getReqModule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqModule();
        }
        return this.reqmodule;
    }

    public boolean isReqModuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqModuleDirty();
        }
        return this.reqmoduleDirtyFlag;
    }

    public void resetReqModule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqModule();
            return;
        }
        this.reqmoduleDirtyFlag = false;
        this.reqmodule = null;
    }

    public void setRuntimeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuntimeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runtimetype = string;
        this.runtimetypeDirtyFlag = true;
    }

    public String getRuntimeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuntimeType();
        }
        return this.runtimetype;
    }

    public boolean isRuntimeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuntimeTypeDirty();
        }
        return this.runtimetypeDirtyFlag;
    }

    public void resetRuntimeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuntimeType();
            return;
        }
        this.runtimetypeDirtyFlag = false;
        this.runtimetype = null;
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

    public void setShortTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShortTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shorttag = string;
        this.shorttagDirtyFlag = true;
    }

    public String getShortTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShortTag();
        }
        return this.shorttag;
    }

    public boolean isShortTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShortTagDirty();
        }
        return this.shorttagDirtyFlag;
    }

    public void resetShortTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShortTag();
            return;
        }
        this.shorttagDirtyFlag = false;
        this.shorttag = null;
    }

    public void setSubSysModule(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysModule(n);
            return;
        }
        this.subsysmodule = n;
        this.subsysmoduleDirtyFlag = true;
    }

    public Integer getSubSysModule() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysModule();
        }
        return this.subsysmodule;
    }

    public boolean isSubSysModuleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysModuleDirty();
        }
        return this.subsysmoduleDirtyFlag;
    }

    public void resetSubSysModule() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysModule();
            return;
        }
        this.subsysmoduleDirtyFlag = false;
        this.subsysmodule = null;
    }

    public void setSysRefType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRefType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysreftype = string;
        this.sysreftypeDirtyFlag = true;
    }

    public String getSysRefType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRefType();
        }
        return this.sysreftype;
    }

    public boolean isSysRefTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRefTypeDirty();
        }
        return this.sysreftypeDirtyFlag;
    }

    public void resetSysRefType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRefType();
            return;
        }
        this.sysreftypeDirtyFlag = false;
        this.sysreftype = null;
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

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setUtilTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag = string;
        this.utiltagDirtyFlag = true;
    }

    public String getUtilTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag();
        }
        return this.utiltag;
    }

    public boolean isUtilTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTagDirty();
        }
        return this.utiltagDirtyFlag;
    }

    public void resetUtilTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag();
            return;
        }
        this.utiltagDirtyFlag = false;
        this.utiltag = null;
    }

    public void setUtilType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltype = string;
        this.utiltypeDirtyFlag = true;
    }

    public String getUtilType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilType();
        }
        return this.utiltype;
    }

    public boolean isUtilTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTypeDirty();
        }
        return this.utiltypeDirtyFlag;
    }

    public void resetUtilType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilType();
            return;
        }
        this.utiltypeDirtyFlag = false;
        this.utiltype = null;
    }

    protected void onReset() {
        PSModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModuleBase pSModuleBase) {
        pSModuleBase.resetClsPkgParams();
        pSModuleBase.resetCodeName();
        pSModuleBase.resetCodeNameMode();
        pSModuleBase.resetColor();
        pSModuleBase.resetCreateDate();
        pSModuleBase.resetCreateMan();
        pSModuleBase.resetDefaultFlag();
        pSModuleBase.resetDSLink();
        pSModuleBase.resetDTOFormat();
        pSModuleBase.resetDynaInstMode();
        pSModuleBase.resetDynaInstTag();
        pSModuleBase.resetDynaInstTag2();
        pSModuleBase.resetEnablePQL();
        pSModuleBase.resetLanResTag();
        pSModuleBase.resetLockFlag();
        pSModuleBase.resetMemo();
        pSModuleBase.resetModTag();
        pSModuleBase.resetModTag2();
        pSModuleBase.resetModTag3();
        pSModuleBase.resetModTag4();
        pSModuleBase.resetModuleSN();
        pSModuleBase.resetNoViewMode();
        pSModuleBase.resetOrderValue();
        pSModuleBase.resetPKGCodeName();
        pSModuleBase.resetPSModuleId();
        pSModuleBase.resetPSModuleName();
        pSModuleBase.resetPSSysModelGroupId();
        pSModuleBase.resetPSSysModelGroupName();
        pSModuleBase.resetPSSysRefId();
        pSModuleBase.resetPSSysRefName();
        pSModuleBase.resetPSSysSFPubId();
        pSModuleBase.resetPSSysSFPubName();
        pSModuleBase.resetPSSystemId();
        pSModuleBase.resetPSSystemName();
        pSModuleBase.resetReqModule();
        pSModuleBase.resetRuntimeType();
        pSModuleBase.resetServiceAPIFlag();
        pSModuleBase.resetShortTag();
        pSModuleBase.resetSubSysModule();
        pSModuleBase.resetSysRefType();
        pSModuleBase.resetUpdateDate();
        pSModuleBase.resetUpdateMan();
        pSModuleBase.resetUserCat();
        pSModuleBase.resetUserParams();
        pSModuleBase.resetUserTag();
        pSModuleBase.resetUserTag2();
        pSModuleBase.resetUserTag3();
        pSModuleBase.resetUserTag4();
        pSModuleBase.resetUtilParams();
        pSModuleBase.resetUtilTag();
        pSModuleBase.resetUtilType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeNameModeDirty()) {
            hashMap.put(FIELD_CODENAMEMODE, this.getCodeNameMode());
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDSLinkDirty()) {
            hashMap.put(FIELD_DSLINK, this.getDSLink());
        }
        if (!bl || this.isDTOFormatDirty()) {
            hashMap.put(FIELD_DTOFORMAT, this.getDTOFormat());
        }
        if (!bl || this.isDynaInstModeDirty()) {
            hashMap.put(FIELD_DYNAINSTMODE, this.getDynaInstMode());
        }
        if (!bl || this.isDynaInstTagDirty()) {
            hashMap.put(FIELD_DYNAINSTTAG, this.getDynaInstTag());
        }
        if (!bl || this.isDynaInstTag2Dirty()) {
            hashMap.put(FIELD_DYNAINSTTAG2, this.getDynaInstTag2());
        }
        if (!bl || this.isEnablePQLDirty()) {
            hashMap.put(FIELD_ENABLEPQL, this.getEnablePQL());
        }
        if (!bl || this.isLanResTagDirty()) {
            hashMap.put(FIELD_LANRESTAG, this.getLanResTag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModTagDirty()) {
            hashMap.put(FIELD_MODTAG, this.getModTag());
        }
        if (!bl || this.isModTag2Dirty()) {
            hashMap.put(FIELD_MODTAG2, this.getModTag2());
        }
        if (!bl || this.isModTag3Dirty()) {
            hashMap.put(FIELD_MODTAG3, this.getModTag3());
        }
        if (!bl || this.isModTag4Dirty()) {
            hashMap.put(FIELD_MODTAG4, this.getModTag4());
        }
        if (!bl || this.isModuleSNDirty()) {
            hashMap.put(FIELD_MODULESN, this.getModuleSN());
        }
        if (!bl || this.isNoViewModeDirty()) {
            hashMap.put(FIELD_NOVIEWMODE, this.getNoViewMode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPKGCodeNameDirty()) {
            hashMap.put(FIELD_PKGCODENAME, this.getPKGCodeName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysModelGroupIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPID, this.getPSSysModelGroupId());
        }
        if (!bl || this.isPSSysModelGroupNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPNAME, this.getPSSysModelGroupName());
        }
        if (!bl || this.isPSSysRefIdDirty()) {
            hashMap.put(FIELD_PSSYSREFID, this.getPSSysRefId());
        }
        if (!bl || this.isPSSysRefNameDirty()) {
            hashMap.put(FIELD_PSSYSREFNAME, this.getPSSysRefName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isReqModuleDirty()) {
            hashMap.put(FIELD_REQMODULE, this.getReqModule());
        }
        if (!bl || this.isRuntimeTypeDirty()) {
            hashMap.put(FIELD_RUNTIMETYPE, this.getRuntimeType());
        }
        if (!bl || this.isServiceAPIFlagDirty()) {
            hashMap.put(FIELD_SERVICEAPIFLAG, this.getServiceAPIFlag());
        }
        if (!bl || this.isShortTagDirty()) {
            hashMap.put(FIELD_SHORTTAG, this.getShortTag());
        }
        if (!bl || this.isSubSysModuleDirty()) {
            hashMap.put(FIELD_SUBSYSMODULE, this.getSubSysModule());
        }
        if (!bl || this.isSysRefTypeDirty()) {
            hashMap.put(FIELD_SYSREFTYPE, this.getSysRefType());
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
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isUtilTagDirty()) {
            hashMap.put(FIELD_UTILTAG, this.getUtilTag());
        }
        if (!bl || this.isUtilTypeDirty()) {
            hashMap.put(FIELD_UTILTYPE, this.getUtilType());
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
        return PSModuleBase.get(this, n);
    }

    private static Object get(PSModuleBase pSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModuleBase.getClsPkgParams();
            }
            case 1: {
                return pSModuleBase.getCodeName();
            }
            case 2: {
                return pSModuleBase.getCodeNameMode();
            }
            case 3: {
                return pSModuleBase.getColor();
            }
            case 4: {
                return pSModuleBase.getCreateDate();
            }
            case 5: {
                return pSModuleBase.getCreateMan();
            }
            case 6: {
                return pSModuleBase.getDefaultFlag();
            }
            case 7: {
                return pSModuleBase.getDSLink();
            }
            case 8: {
                return pSModuleBase.getDTOFormat();
            }
            case 9: {
                return pSModuleBase.getDynaInstMode();
            }
            case 10: {
                return pSModuleBase.getDynaInstTag();
            }
            case 11: {
                return pSModuleBase.getDynaInstTag2();
            }
            case 12: {
                return pSModuleBase.getEnablePQL();
            }
            case 13: {
                return pSModuleBase.getLanResTag();
            }
            case 14: {
                return pSModuleBase.getLockFlag();
            }
            case 15: {
                return pSModuleBase.getMemo();
            }
            case 16: {
                return pSModuleBase.getModTag();
            }
            case 17: {
                return pSModuleBase.getModTag2();
            }
            case 18: {
                return pSModuleBase.getModTag3();
            }
            case 19: {
                return pSModuleBase.getModTag4();
            }
            case 20: {
                return pSModuleBase.getModuleSN();
            }
            case 21: {
                return pSModuleBase.getNoViewMode();
            }
            case 22: {
                return pSModuleBase.getOrderValue();
            }
            case 23: {
                return pSModuleBase.getPKGCodeName();
            }
            case 24: {
                return pSModuleBase.getPSModuleId();
            }
            case 25: {
                return pSModuleBase.getPSModuleName();
            }
            case 26: {
                return pSModuleBase.getPSSysModelGroupId();
            }
            case 27: {
                return pSModuleBase.getPSSysModelGroupName();
            }
            case 28: {
                return pSModuleBase.getPSSysRefId();
            }
            case 29: {
                return pSModuleBase.getPSSysRefName();
            }
            case 30: {
                return pSModuleBase.getPSSysSFPubId();
            }
            case 31: {
                return pSModuleBase.getPSSysSFPubName();
            }
            case 32: {
                return pSModuleBase.getPSSystemId();
            }
            case 33: {
                return pSModuleBase.getPSSystemName();
            }
            case 34: {
                return pSModuleBase.getReqModule();
            }
            case 35: {
                return pSModuleBase.getRuntimeType();
            }
            case 36: {
                return pSModuleBase.getServiceAPIFlag();
            }
            case 37: {
                return pSModuleBase.getShortTag();
            }
            case 38: {
                return pSModuleBase.getSubSysModule();
            }
            case 39: {
                return pSModuleBase.getSysRefType();
            }
            case 40: {
                return pSModuleBase.getUpdateDate();
            }
            case 41: {
                return pSModuleBase.getUpdateMan();
            }
            case 42: {
                return pSModuleBase.getUserCat();
            }
            case 43: {
                return pSModuleBase.getUserParams();
            }
            case 44: {
                return pSModuleBase.getUserTag();
            }
            case 45: {
                return pSModuleBase.getUserTag2();
            }
            case 46: {
                return pSModuleBase.getUserTag3();
            }
            case 47: {
                return pSModuleBase.getUserTag4();
            }
            case 48: {
                return pSModuleBase.getUtilParams();
            }
            case 49: {
                return pSModuleBase.getUtilTag();
            }
            case 50: {
                return pSModuleBase.getUtilType();
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
        PSModuleBase.set(this, n, object);
    }

    private static void set(PSModuleBase pSModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModuleBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModuleBase.setCodeNameMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModuleBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModuleBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModuleBase.setDSLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModuleBase.setDTOFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModuleBase.setDynaInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSModuleBase.setDynaInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModuleBase.setDynaInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModuleBase.setEnablePQL(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSModuleBase.setLanResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModuleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModuleBase.setModTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModuleBase.setModTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModuleBase.setModTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModuleBase.setModTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSModuleBase.setModuleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModuleBase.setNoViewMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSModuleBase.setPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSModuleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSModuleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSModuleBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSModuleBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSModuleBase.setPSSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSModuleBase.setPSSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSModuleBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSModuleBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSModuleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSModuleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSModuleBase.setReqModule(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSModuleBase.setRuntimeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSModuleBase.setServiceAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSModuleBase.setShortTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSModuleBase.setSubSysModule(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSModuleBase.setSysRefType(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSModuleBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSModuleBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSModuleBase.setUtilTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSModuleBase.setUtilType(DataObject.getStringValue((Object)object));
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
        return PSModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSModuleBase pSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModuleBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSModuleBase.getCodeName() == null;
            }
            case 2: {
                return pSModuleBase.getCodeNameMode() == null;
            }
            case 3: {
                return pSModuleBase.getColor() == null;
            }
            case 4: {
                return pSModuleBase.getCreateDate() == null;
            }
            case 5: {
                return pSModuleBase.getCreateMan() == null;
            }
            case 6: {
                return pSModuleBase.getDefaultFlag() == null;
            }
            case 7: {
                return pSModuleBase.getDSLink() == null;
            }
            case 8: {
                return pSModuleBase.getDTOFormat() == null;
            }
            case 9: {
                return pSModuleBase.getDynaInstMode() == null;
            }
            case 10: {
                return pSModuleBase.getDynaInstTag() == null;
            }
            case 11: {
                return pSModuleBase.getDynaInstTag2() == null;
            }
            case 12: {
                return pSModuleBase.getEnablePQL() == null;
            }
            case 13: {
                return pSModuleBase.getLanResTag() == null;
            }
            case 14: {
                return pSModuleBase.getLockFlag() == null;
            }
            case 15: {
                return pSModuleBase.getMemo() == null;
            }
            case 16: {
                return pSModuleBase.getModTag() == null;
            }
            case 17: {
                return pSModuleBase.getModTag2() == null;
            }
            case 18: {
                return pSModuleBase.getModTag3() == null;
            }
            case 19: {
                return pSModuleBase.getModTag4() == null;
            }
            case 20: {
                return pSModuleBase.getModuleSN() == null;
            }
            case 21: {
                return pSModuleBase.getNoViewMode() == null;
            }
            case 22: {
                return pSModuleBase.getOrderValue() == null;
            }
            case 23: {
                return pSModuleBase.getPKGCodeName() == null;
            }
            case 24: {
                return pSModuleBase.getPSModuleId() == null;
            }
            case 25: {
                return pSModuleBase.getPSModuleName() == null;
            }
            case 26: {
                return pSModuleBase.getPSSysModelGroupId() == null;
            }
            case 27: {
                return pSModuleBase.getPSSysModelGroupName() == null;
            }
            case 28: {
                return pSModuleBase.getPSSysRefId() == null;
            }
            case 29: {
                return pSModuleBase.getPSSysRefName() == null;
            }
            case 30: {
                return pSModuleBase.getPSSysSFPubId() == null;
            }
            case 31: {
                return pSModuleBase.getPSSysSFPubName() == null;
            }
            case 32: {
                return pSModuleBase.getPSSystemId() == null;
            }
            case 33: {
                return pSModuleBase.getPSSystemName() == null;
            }
            case 34: {
                return pSModuleBase.getReqModule() == null;
            }
            case 35: {
                return pSModuleBase.getRuntimeType() == null;
            }
            case 36: {
                return pSModuleBase.getServiceAPIFlag() == null;
            }
            case 37: {
                return pSModuleBase.getShortTag() == null;
            }
            case 38: {
                return pSModuleBase.getSubSysModule() == null;
            }
            case 39: {
                return pSModuleBase.getSysRefType() == null;
            }
            case 40: {
                return pSModuleBase.getUpdateDate() == null;
            }
            case 41: {
                return pSModuleBase.getUpdateMan() == null;
            }
            case 42: {
                return pSModuleBase.getUserCat() == null;
            }
            case 43: {
                return pSModuleBase.getUserParams() == null;
            }
            case 44: {
                return pSModuleBase.getUserTag() == null;
            }
            case 45: {
                return pSModuleBase.getUserTag2() == null;
            }
            case 46: {
                return pSModuleBase.getUserTag3() == null;
            }
            case 47: {
                return pSModuleBase.getUserTag4() == null;
            }
            case 48: {
                return pSModuleBase.getUtilParams() == null;
            }
            case 49: {
                return pSModuleBase.getUtilTag() == null;
            }
            case 50: {
                return pSModuleBase.getUtilType() == null;
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
        return PSModuleBase.contains(this, n);
    }

    private static boolean contains(PSModuleBase pSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModuleBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSModuleBase.isCodeNameDirty();
            }
            case 2: {
                return pSModuleBase.isCodeNameModeDirty();
            }
            case 3: {
                return pSModuleBase.isColorDirty();
            }
            case 4: {
                return pSModuleBase.isCreateDateDirty();
            }
            case 5: {
                return pSModuleBase.isCreateManDirty();
            }
            case 6: {
                return pSModuleBase.isDefaultFlagDirty();
            }
            case 7: {
                return pSModuleBase.isDSLinkDirty();
            }
            case 8: {
                return pSModuleBase.isDTOFormatDirty();
            }
            case 9: {
                return pSModuleBase.isDynaInstModeDirty();
            }
            case 10: {
                return pSModuleBase.isDynaInstTagDirty();
            }
            case 11: {
                return pSModuleBase.isDynaInstTag2Dirty();
            }
            case 12: {
                return pSModuleBase.isEnablePQLDirty();
            }
            case 13: {
                return pSModuleBase.isLanResTagDirty();
            }
            case 14: {
                return pSModuleBase.isLockFlagDirty();
            }
            case 15: {
                return pSModuleBase.isMemoDirty();
            }
            case 16: {
                return pSModuleBase.isModTagDirty();
            }
            case 17: {
                return pSModuleBase.isModTag2Dirty();
            }
            case 18: {
                return pSModuleBase.isModTag3Dirty();
            }
            case 19: {
                return pSModuleBase.isModTag4Dirty();
            }
            case 20: {
                return pSModuleBase.isModuleSNDirty();
            }
            case 21: {
                return pSModuleBase.isNoViewModeDirty();
            }
            case 22: {
                return pSModuleBase.isOrderValueDirty();
            }
            case 23: {
                return pSModuleBase.isPKGCodeNameDirty();
            }
            case 24: {
                return pSModuleBase.isPSModuleIdDirty();
            }
            case 25: {
                return pSModuleBase.isPSModuleNameDirty();
            }
            case 26: {
                return pSModuleBase.isPSSysModelGroupIdDirty();
            }
            case 27: {
                return pSModuleBase.isPSSysModelGroupNameDirty();
            }
            case 28: {
                return pSModuleBase.isPSSysRefIdDirty();
            }
            case 29: {
                return pSModuleBase.isPSSysRefNameDirty();
            }
            case 30: {
                return pSModuleBase.isPSSysSFPubIdDirty();
            }
            case 31: {
                return pSModuleBase.isPSSysSFPubNameDirty();
            }
            case 32: {
                return pSModuleBase.isPSSystemIdDirty();
            }
            case 33: {
                return pSModuleBase.isPSSystemNameDirty();
            }
            case 34: {
                return pSModuleBase.isReqModuleDirty();
            }
            case 35: {
                return pSModuleBase.isRuntimeTypeDirty();
            }
            case 36: {
                return pSModuleBase.isServiceAPIFlagDirty();
            }
            case 37: {
                return pSModuleBase.isShortTagDirty();
            }
            case 38: {
                return pSModuleBase.isSubSysModuleDirty();
            }
            case 39: {
                return pSModuleBase.isSysRefTypeDirty();
            }
            case 40: {
                return pSModuleBase.isUpdateDateDirty();
            }
            case 41: {
                return pSModuleBase.isUpdateManDirty();
            }
            case 42: {
                return pSModuleBase.isUserCatDirty();
            }
            case 43: {
                return pSModuleBase.isUserParamsDirty();
            }
            case 44: {
                return pSModuleBase.isUserTagDirty();
            }
            case 45: {
                return pSModuleBase.isUserTag2Dirty();
            }
            case 46: {
                return pSModuleBase.isUserTag3Dirty();
            }
            case 47: {
                return pSModuleBase.isUserTag4Dirty();
            }
            case 48: {
                return pSModuleBase.isUtilParamsDirty();
            }
            case 49: {
                return pSModuleBase.isUtilTagDirty();
            }
            case 50: {
                return pSModuleBase.isUtilTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModuleBase pSModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModuleBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSModuleBase.getCodeNameMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codenamemode", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getCodeNameMode()), (boolean)false);
        }
        if (bl || pSModuleBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getColor()), (boolean)false);
        }
        if (bl || pSModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModuleBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSModuleBase.getDSLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dslink", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDSLink()), (boolean)false);
        }
        if (bl || pSModuleBase.getDTOFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dtoformat", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDTOFormat()), (boolean)false);
        }
        if (bl || pSModuleBase.getDynaInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainstmode", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDynaInstMode()), (boolean)false);
        }
        if (bl || pSModuleBase.getDynaInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDynaInstTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getDynaInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag2", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getDynaInstTag2()), (boolean)false);
        }
        if (bl || pSModuleBase.getEnablePQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepql", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getEnablePQL()), (boolean)false);
        }
        if (bl || pSModuleBase.getLanResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanrestag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getLanResTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSModuleBase.getModTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modtag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getModTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getModTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modtag2", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getModTag2()), (boolean)false);
        }
        if (bl || pSModuleBase.getModTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modtag3", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getModTag3()), (boolean)false);
        }
        if (bl || pSModuleBase.getModTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modtag4", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getModTag4()), (boolean)false);
        }
        if (bl || pSModuleBase.getModuleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulesn", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getModuleSN()), (boolean)false);
        }
        if (bl || pSModuleBase.getNoViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noviewmode", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getNoViewMode()), (boolean)false);
        }
        if (bl || pSModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModuleBase.getPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgcodename", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPKGCodeName()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefid", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysRefId()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefname", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysRefName()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModuleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSModuleBase.getReqModule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqmodule", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getReqModule()), (boolean)false);
        }
        if (bl || pSModuleBase.getRuntimeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runtimetype", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getRuntimeType()), (boolean)false);
        }
        if (bl || pSModuleBase.getServiceAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceapiflag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getServiceAPIFlag()), (boolean)false);
        }
        if (bl || pSModuleBase.getShortTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shorttag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getShortTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getSubSysModule() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysmodule", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getSubSysModule()), (boolean)false);
        }
        if (bl || pSModuleBase.getSysRefType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysreftype", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getSysRefType()), (boolean)false);
        }
        if (bl || pSModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserParams()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSModuleBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSModuleBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUtilTag()), (boolean)false);
        }
        if (bl || pSModuleBase.getUtilType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltype", (Object)PSModuleBase.getJSONValue((Object)pSModuleBase.getUtilType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModuleBase pSModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModuleBase.getClsPkgParams() != null) {
            object = pSModuleBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSModuleBase.getCodeName() != null) {
            object = pSModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSModuleBase.getCodeNameMode() != null) {
            object = pSModuleBase.getCodeNameMode();
            xmlNode.setAttribute(FIELD_CODENAMEMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSModuleBase.getColor() != null) {
            object = pSModuleBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getCreateDate() != null) {
            object = pSModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModuleBase.getCreateMan() != null) {
            object = pSModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getDefaultFlag() != null) {
            object = pSModuleBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getDSLink() != null) {
            object = pSModuleBase.getDSLink();
            xmlNode.setAttribute(FIELD_DSLINK, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getDTOFormat() != null) {
            object = pSModuleBase.getDTOFormat();
            xmlNode.setAttribute(FIELD_DTOFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getDynaInstMode() != null) {
            object = pSModuleBase.getDynaInstMode();
            xmlNode.setAttribute(FIELD_DYNAINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getDynaInstTag() != null) {
            object = pSModuleBase.getDynaInstTag();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getDynaInstTag2() != null) {
            object = pSModuleBase.getDynaInstTag2();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getEnablePQL() != null) {
            object = pSModuleBase.getEnablePQL();
            xmlNode.setAttribute(FIELD_ENABLEPQL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getLanResTag() != null) {
            object = pSModuleBase.getLanResTag();
            xmlNode.setAttribute(FIELD_LANRESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getLockFlag() != null) {
            object = pSModuleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getMemo() != null) {
            object = pSModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getModTag() != null) {
            object = pSModuleBase.getModTag();
            xmlNode.setAttribute(FIELD_MODTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getModTag2() != null) {
            object = pSModuleBase.getModTag2();
            xmlNode.setAttribute(FIELD_MODTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getModTag3() != null) {
            object = pSModuleBase.getModTag3();
            xmlNode.setAttribute(FIELD_MODTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getModTag4() != null) {
            object = pSModuleBase.getModTag4();
            xmlNode.setAttribute(FIELD_MODTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getModuleSN() != null) {
            object = pSModuleBase.getModuleSN();
            xmlNode.setAttribute(FIELD_MODULESN, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getNoViewMode() != null) {
            object = pSModuleBase.getNoViewMode();
            xmlNode.setAttribute(FIELD_NOVIEWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getOrderValue() != null) {
            object = pSModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getPKGCodeName() != null) {
            object = pSModuleBase.getPKGCodeName();
            xmlNode.setAttribute(FIELD_PKGCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSModuleId() != null) {
            object = pSModuleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSModuleName() != null) {
            object = pSModuleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysModelGroupId() != null) {
            object = pSModuleBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysModelGroupName() != null) {
            object = pSModuleBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysRefId() != null) {
            object = pSModuleBase.getPSSysRefId();
            xmlNode.setAttribute(FIELD_PSSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysRefName() != null) {
            object = pSModuleBase.getPSSysRefName();
            xmlNode.setAttribute(FIELD_PSSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysSFPubId() != null) {
            object = pSModuleBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSysSFPubName() != null) {
            object = pSModuleBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSystemId() != null) {
            object = pSModuleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getPSSystemName() != null) {
            object = pSModuleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getReqModule() != null) {
            object = pSModuleBase.getReqModule();
            xmlNode.setAttribute(FIELD_REQMODULE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getRuntimeType() != null) {
            object = pSModuleBase.getRuntimeType();
            xmlNode.setAttribute(FIELD_RUNTIMETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getServiceAPIFlag() != null) {
            object = pSModuleBase.getServiceAPIFlag();
            xmlNode.setAttribute(FIELD_SERVICEAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getShortTag() != null) {
            object = pSModuleBase.getShortTag();
            xmlNode.setAttribute(FIELD_SHORTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getSubSysModule() != null) {
            object = pSModuleBase.getSubSysModule();
            xmlNode.setAttribute(FIELD_SUBSYSMODULE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModuleBase.getSysRefType() != null) {
            object = pSModuleBase.getSysRefType();
            xmlNode.setAttribute(FIELD_SYSREFTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUpdateDate() != null) {
            object = pSModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModuleBase.getUpdateMan() != null) {
            object = pSModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserCat() != null) {
            object = pSModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserParams() != null) {
            object = pSModuleBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserTag() != null) {
            object = pSModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserTag2() != null) {
            object = pSModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserTag3() != null) {
            object = pSModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUserTag4() != null) {
            object = pSModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUtilParams() != null) {
            object = pSModuleBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUtilTag() != null) {
            object = pSModuleBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModuleBase.getUtilType() != null) {
            object = pSModuleBase.getUtilType();
            xmlNode.setAttribute(FIELD_UTILTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModuleBase pSModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModuleBase.isClsPkgParamsDirty() && (bl || pSModuleBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSModuleBase.getClsPkgParams());
        }
        if (pSModuleBase.isCodeNameDirty() && (bl || pSModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSModuleBase.getCodeName());
        }
        if (pSModuleBase.isCodeNameModeDirty() && (bl || pSModuleBase.getCodeNameMode() != null)) {
            iDataObject.set(FIELD_CODENAMEMODE, (Object)pSModuleBase.getCodeNameMode());
        }
        if (pSModuleBase.isColorDirty() && (bl || pSModuleBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSModuleBase.getColor());
        }
        if (pSModuleBase.isCreateDateDirty() && (bl || pSModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModuleBase.getCreateDate());
        }
        if (pSModuleBase.isCreateManDirty() && (bl || pSModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModuleBase.getCreateMan());
        }
        if (pSModuleBase.isDefaultFlagDirty() && (bl || pSModuleBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSModuleBase.getDefaultFlag());
        }
        if (pSModuleBase.isDSLinkDirty() && (bl || pSModuleBase.getDSLink() != null)) {
            iDataObject.set(FIELD_DSLINK, (Object)pSModuleBase.getDSLink());
        }
        if (pSModuleBase.isDTOFormatDirty() && (bl || pSModuleBase.getDTOFormat() != null)) {
            iDataObject.set(FIELD_DTOFORMAT, (Object)pSModuleBase.getDTOFormat());
        }
        if (pSModuleBase.isDynaInstModeDirty() && (bl || pSModuleBase.getDynaInstMode() != null)) {
            iDataObject.set(FIELD_DYNAINSTMODE, (Object)pSModuleBase.getDynaInstMode());
        }
        if (pSModuleBase.isDynaInstTagDirty() && (bl || pSModuleBase.getDynaInstTag() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG, (Object)pSModuleBase.getDynaInstTag());
        }
        if (pSModuleBase.isDynaInstTag2Dirty() && (bl || pSModuleBase.getDynaInstTag2() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG2, (Object)pSModuleBase.getDynaInstTag2());
        }
        if (pSModuleBase.isEnablePQLDirty() && (bl || pSModuleBase.getEnablePQL() != null)) {
            iDataObject.set(FIELD_ENABLEPQL, (Object)pSModuleBase.getEnablePQL());
        }
        if (pSModuleBase.isLanResTagDirty() && (bl || pSModuleBase.getLanResTag() != null)) {
            iDataObject.set(FIELD_LANRESTAG, (Object)pSModuleBase.getLanResTag());
        }
        if (pSModuleBase.isLockFlagDirty() && (bl || pSModuleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSModuleBase.getLockFlag());
        }
        if (pSModuleBase.isMemoDirty() && (bl || pSModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModuleBase.getMemo());
        }
        if (pSModuleBase.isModTagDirty() && (bl || pSModuleBase.getModTag() != null)) {
            iDataObject.set(FIELD_MODTAG, (Object)pSModuleBase.getModTag());
        }
        if (pSModuleBase.isModTag2Dirty() && (bl || pSModuleBase.getModTag2() != null)) {
            iDataObject.set(FIELD_MODTAG2, (Object)pSModuleBase.getModTag2());
        }
        if (pSModuleBase.isModTag3Dirty() && (bl || pSModuleBase.getModTag3() != null)) {
            iDataObject.set(FIELD_MODTAG3, (Object)pSModuleBase.getModTag3());
        }
        if (pSModuleBase.isModTag4Dirty() && (bl || pSModuleBase.getModTag4() != null)) {
            iDataObject.set(FIELD_MODTAG4, (Object)pSModuleBase.getModTag4());
        }
        if (pSModuleBase.isModuleSNDirty() && (bl || pSModuleBase.getModuleSN() != null)) {
            iDataObject.set(FIELD_MODULESN, (Object)pSModuleBase.getModuleSN());
        }
        if (pSModuleBase.isNoViewModeDirty() && (bl || pSModuleBase.getNoViewMode() != null)) {
            iDataObject.set(FIELD_NOVIEWMODE, (Object)pSModuleBase.getNoViewMode());
        }
        if (pSModuleBase.isOrderValueDirty() && (bl || pSModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModuleBase.getOrderValue());
        }
        if (pSModuleBase.isPKGCodeNameDirty() && (bl || pSModuleBase.getPKGCodeName() != null)) {
            iDataObject.set(FIELD_PKGCODENAME, (Object)pSModuleBase.getPKGCodeName());
        }
        if (pSModuleBase.isPSModuleIdDirty() && (bl || pSModuleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSModuleBase.getPSModuleId());
        }
        if (pSModuleBase.isPSModuleNameDirty() && (bl || pSModuleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSModuleBase.getPSModuleName());
        }
        if (pSModuleBase.isPSSysModelGroupIdDirty() && (bl || pSModuleBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSModuleBase.getPSSysModelGroupId());
        }
        if (pSModuleBase.isPSSysModelGroupNameDirty() && (bl || pSModuleBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSModuleBase.getPSSysModelGroupName());
        }
        if (pSModuleBase.isPSSysRefIdDirty() && (bl || pSModuleBase.getPSSysRefId() != null)) {
            iDataObject.set(FIELD_PSSYSREFID, (Object)pSModuleBase.getPSSysRefId());
        }
        if (pSModuleBase.isPSSysRefNameDirty() && (bl || pSModuleBase.getPSSysRefName() != null)) {
            iDataObject.set(FIELD_PSSYSREFNAME, (Object)pSModuleBase.getPSSysRefName());
        }
        if (pSModuleBase.isPSSysSFPubIdDirty() && (bl || pSModuleBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSModuleBase.getPSSysSFPubId());
        }
        if (pSModuleBase.isPSSysSFPubNameDirty() && (bl || pSModuleBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSModuleBase.getPSSysSFPubName());
        }
        if (pSModuleBase.isPSSystemIdDirty() && (bl || pSModuleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModuleBase.getPSSystemId());
        }
        if (pSModuleBase.isPSSystemNameDirty() && (bl || pSModuleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSModuleBase.getPSSystemName());
        }
        if (pSModuleBase.isReqModuleDirty() && (bl || pSModuleBase.getReqModule() != null)) {
            iDataObject.set(FIELD_REQMODULE, (Object)pSModuleBase.getReqModule());
        }
        if (pSModuleBase.isRuntimeTypeDirty() && (bl || pSModuleBase.getRuntimeType() != null)) {
            iDataObject.set(FIELD_RUNTIMETYPE, (Object)pSModuleBase.getRuntimeType());
        }
        if (pSModuleBase.isServiceAPIFlagDirty() && (bl || pSModuleBase.getServiceAPIFlag() != null)) {
            iDataObject.set(FIELD_SERVICEAPIFLAG, (Object)pSModuleBase.getServiceAPIFlag());
        }
        if (pSModuleBase.isShortTagDirty() && (bl || pSModuleBase.getShortTag() != null)) {
            iDataObject.set(FIELD_SHORTTAG, (Object)pSModuleBase.getShortTag());
        }
        if (pSModuleBase.isSubSysModuleDirty() && (bl || pSModuleBase.getSubSysModule() != null)) {
            iDataObject.set(FIELD_SUBSYSMODULE, (Object)pSModuleBase.getSubSysModule());
        }
        if (pSModuleBase.isSysRefTypeDirty() && (bl || pSModuleBase.getSysRefType() != null)) {
            iDataObject.set(FIELD_SYSREFTYPE, (Object)pSModuleBase.getSysRefType());
        }
        if (pSModuleBase.isUpdateDateDirty() && (bl || pSModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModuleBase.getUpdateDate());
        }
        if (pSModuleBase.isUpdateManDirty() && (bl || pSModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModuleBase.getUpdateMan());
        }
        if (pSModuleBase.isUserCatDirty() && (bl || pSModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSModuleBase.getUserCat());
        }
        if (pSModuleBase.isUserParamsDirty() && (bl || pSModuleBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSModuleBase.getUserParams());
        }
        if (pSModuleBase.isUserTagDirty() && (bl || pSModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSModuleBase.getUserTag());
        }
        if (pSModuleBase.isUserTag2Dirty() && (bl || pSModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSModuleBase.getUserTag2());
        }
        if (pSModuleBase.isUserTag3Dirty() && (bl || pSModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSModuleBase.getUserTag3());
        }
        if (pSModuleBase.isUserTag4Dirty() && (bl || pSModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSModuleBase.getUserTag4());
        }
        if (pSModuleBase.isUtilParamsDirty() && (bl || pSModuleBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSModuleBase.getUtilParams());
        }
        if (pSModuleBase.isUtilTagDirty() && (bl || pSModuleBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSModuleBase.getUtilTag());
        }
        if (pSModuleBase.isUtilTypeDirty() && (bl || pSModuleBase.getUtilType() != null)) {
            iDataObject.set(FIELD_UTILTYPE, (Object)pSModuleBase.getUtilType());
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
        return PSModuleBase.remove(this, n);
    }

    private static boolean remove(PSModuleBase pSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModuleBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSModuleBase.resetCodeName();
                return true;
            }
            case 2: {
                pSModuleBase.resetCodeNameMode();
                return true;
            }
            case 3: {
                pSModuleBase.resetColor();
                return true;
            }
            case 4: {
                pSModuleBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSModuleBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSModuleBase.resetDefaultFlag();
                return true;
            }
            case 7: {
                pSModuleBase.resetDSLink();
                return true;
            }
            case 8: {
                pSModuleBase.resetDTOFormat();
                return true;
            }
            case 9: {
                pSModuleBase.resetDynaInstMode();
                return true;
            }
            case 10: {
                pSModuleBase.resetDynaInstTag();
                return true;
            }
            case 11: {
                pSModuleBase.resetDynaInstTag2();
                return true;
            }
            case 12: {
                pSModuleBase.resetEnablePQL();
                return true;
            }
            case 13: {
                pSModuleBase.resetLanResTag();
                return true;
            }
            case 14: {
                pSModuleBase.resetLockFlag();
                return true;
            }
            case 15: {
                pSModuleBase.resetMemo();
                return true;
            }
            case 16: {
                pSModuleBase.resetModTag();
                return true;
            }
            case 17: {
                pSModuleBase.resetModTag2();
                return true;
            }
            case 18: {
                pSModuleBase.resetModTag3();
                return true;
            }
            case 19: {
                pSModuleBase.resetModTag4();
                return true;
            }
            case 20: {
                pSModuleBase.resetModuleSN();
                return true;
            }
            case 21: {
                pSModuleBase.resetNoViewMode();
                return true;
            }
            case 22: {
                pSModuleBase.resetOrderValue();
                return true;
            }
            case 23: {
                pSModuleBase.resetPKGCodeName();
                return true;
            }
            case 24: {
                pSModuleBase.resetPSModuleId();
                return true;
            }
            case 25: {
                pSModuleBase.resetPSModuleName();
                return true;
            }
            case 26: {
                pSModuleBase.resetPSSysModelGroupId();
                return true;
            }
            case 27: {
                pSModuleBase.resetPSSysModelGroupName();
                return true;
            }
            case 28: {
                pSModuleBase.resetPSSysRefId();
                return true;
            }
            case 29: {
                pSModuleBase.resetPSSysRefName();
                return true;
            }
            case 30: {
                pSModuleBase.resetPSSysSFPubId();
                return true;
            }
            case 31: {
                pSModuleBase.resetPSSysSFPubName();
                return true;
            }
            case 32: {
                pSModuleBase.resetPSSystemId();
                return true;
            }
            case 33: {
                pSModuleBase.resetPSSystemName();
                return true;
            }
            case 34: {
                pSModuleBase.resetReqModule();
                return true;
            }
            case 35: {
                pSModuleBase.resetRuntimeType();
                return true;
            }
            case 36: {
                pSModuleBase.resetServiceAPIFlag();
                return true;
            }
            case 37: {
                pSModuleBase.resetShortTag();
                return true;
            }
            case 38: {
                pSModuleBase.resetSubSysModule();
                return true;
            }
            case 39: {
                pSModuleBase.resetSysRefType();
                return true;
            }
            case 40: {
                pSModuleBase.resetUpdateDate();
                return true;
            }
            case 41: {
                pSModuleBase.resetUpdateMan();
                return true;
            }
            case 42: {
                pSModuleBase.resetUserCat();
                return true;
            }
            case 43: {
                pSModuleBase.resetUserParams();
                return true;
            }
            case 44: {
                pSModuleBase.resetUserTag();
                return true;
            }
            case 45: {
                pSModuleBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSModuleBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSModuleBase.resetUserTag4();
                return true;
            }
            case 48: {
                pSModuleBase.resetUtilParams();
                return true;
            }
            case 49: {
                pSModuleBase.resetUtilTag();
                return true;
            }
            case 50: {
                pSModuleBase.resetUtilType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelGroup getPSSysModelGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroup();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelGroupLock;
        synchronized (n) {
            if (this.pssysmodelgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelGroupId(), (Object)this.pssysmodelgroup.getPSSysModelGroupId()) != 0L) {
                this.pssysmodelgroup = null;
            }
            if (this.pssysmodelgroup == null) {
                PSSysModelGroup pSSysModelGroup = new PSSysModelGroup();
                pSSysModelGroup.setPSSysModelGroupId(this.getPSSysModelGroupId());
                PSSysModelGroupService pSSysModelGroupService = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelGroupService.autoGet(pSSysModelGroup);
                this.pssysmodelgroup = pSSysModelGroup;
            }
            return this.pssysmodelgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysRef getPSSysRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRef();
        }
        if (this.getPSSysRefId() == null) {
            return null;
        }
        Integer n = this.objPSSysRefLock;
        synchronized (n) {
            if (this.pssysref != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysRefId(), (Object)this.pssysref.getPSSysRefId()) != 0L) {
                this.pssysref = null;
            }
            if (this.pssysref == null) {
                PSSysRef pSSysRef = new PSSysRef();
                pSSysRef.setPSSysRefId(this.getPSSysRefId());
                PSSysRefService pSSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
                pSSysRefService.autoGet(pSSysRef);
                this.pssysref = pSSysRef;
            }
            return this.pssysref;
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
    public ArrayList<PSACHandler> getPSACHandlers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlers();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSACHandlersLock;
        synchronized (n) {
            if (this.psachandlers == null) {
                this.psachandlers = pSACHandlerService.selectByPSModule(this);
            }
            return this.psachandlers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCodeList> getPSCodeLists() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeLists();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCodeListsLock;
        synchronized (n) {
            if (this.pscodelists == null) {
                this.pscodelists = pSCodeListService.selectByPSModule(this);
            }
            return this.pscodelists;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlLogicGroup> getPSCtrlLogicGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlLogicGroupsLock;
        synchronized (n) {
            if (this.psctrllogicgroups == null) {
                this.psctrllogicgroups = pSCtrlLogicGroupService.selectByPSModule(this);
            }
            return this.psctrllogicgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlMsg> getPSCtrlMsgs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlMsgsLock;
        synchronized (n) {
            if (this.psctrlmsgs == null) {
                this.psctrlmsgs = pSCtrlMsgService.selectByPSModule(this);
            }
            return this.psctrlmsgs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDataEntity> getPSDataEntities() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntities();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDataEntitiesLock;
        synchronized (n) {
            if (this.psdataentities == null) {
                this.psdataentities = pSDataEntityService.selectByPSModule(this);
            }
            return this.psdataentities;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEActionTempl> getPSDEActionTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTempls();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEActionTemplService pSDEActionTemplService = (PSDEActionTemplService)ServiceGlobal.getService(PSDEActionTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEActionTemplsLock;
        synchronized (n) {
            if (this.psdeactiontempls == null) {
                this.psdeactiontempls = pSDEActionTemplService.selectByPSModule(this);
            }
            return this.psdeactiontempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFInputTipSet> getPSDEFInputSets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputSets();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEFInputTipSetService pSDEFInputTipSetService = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFInputSetsLock;
        synchronized (n) {
            if (this.psdefinputsets == null) {
                this.psdefinputsets = pSDEFInputTipSetService.selectByPSModule(this);
            }
            return this.psdefinputsets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFInputTip> getPSDEFInputTips() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTips();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEFInputTipService pSDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFInputTipsLock;
        synchronized (n) {
            if (this.psdefinputtips == null) {
                this.psdefinputtips = pSDEFInputTipService.selectByPSModule(this);
            }
            return this.psdefinputtips;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEGroup> getPSDEGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEGroupService pSDEGroupService = (PSDEGroupService)ServiceGlobal.getService(PSDEGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEGroupsLock;
        synchronized (n) {
            if (this.psdegroups == null) {
                this.psdegroups = pSDEGroupService.selectByPSModule(this);
            }
            return this.psdegroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEOPPriv> getPSDEOPPrivs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEOPPrivsLock;
        synchronized (n) {
            if (this.psdeopprivs == null) {
                this.psdeopprivs = pSDEOPPrivService.selectByPSModule(this);
            }
            return this.psdeopprivs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDERGroup> getPSDERGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDERGroupService pSDERGroupService = (PSDERGroupService)ServiceGlobal.getService(PSDERGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDERGroupsLock;
        synchronized (n) {
            if (this.psdergroups == null) {
                this.psdergroups = pSDERGroupService.selectByPSModule(this);
            }
            return this.psdergroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEToolbar> getPSDEToolbars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbars();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEToolbarsLock;
        synchronized (n) {
            if (this.psdetoolbars == null) {
                this.psdetoolbars = pSDEToolbarService.selectByPSModule(this);
            }
            return this.psdetoolbars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUAGroup> getPSDEUAGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUAGroupsLock;
        synchronized (n) {
            if (this.psdeuagroups == null) {
                this.psdeuagroups = pSDEUAGroupService.selectByPSModule(this);
            }
            return this.psdeuagroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUIAction> getPSDEUIActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActions();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUIActionsLock;
        synchronized (n) {
            if (this.psdeuiactions == null) {
                this.psdeuiactions = pSDEUIActionService.selectByPSModule(this);
            }
            return this.psdeuiactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpArticle> getPSHelpArticles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticles();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSHelpArticleService pSHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpArticlesLock;
        synchronized (n) {
            if (this.pshelparticles == null) {
                this.pshelparticles = pSHelpArticleService.selectByPSModule(this);
            }
            return this.pshelparticles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpPrj> getPSHelpPrjs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSHelpPrjService pSHelpPrjService = (PSHelpPrjService)ServiceGlobal.getService(PSHelpPrjService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpPrjsLock;
        synchronized (n) {
            if (this.pshelpprjs == null) {
                this.pshelpprjs = pSHelpPrjService.selectByPSModule(this);
            }
            return this.pshelpprjs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpResource> getPSHelpResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpResources();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSHelpResourceService pSHelpResourceService = (PSHelpResourceService)ServiceGlobal.getService(PSHelpResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpResourcesLock;
        synchronized (n) {
            if (this.pshelpresources == null) {
                this.pshelpresources = pSHelpResourceService.selectByPSModule(this);
            }
            return this.pshelpresources;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSLanguageRes> getPSLanguageReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageReses();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSLanguageResesLock;
        synchronized (n) {
            if (this.pslanguagereses == null) {
                this.pslanguagereses = pSLanguageResService.selectByPSModule(this);
            }
            return this.pslanguagereses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubSysServiceAPI> getPSSubSysServiceAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubSysServiceAPIsLock;
        synchronized (n) {
            if (this.pssubsysserviceapis == null) {
                this.pssubsysserviceapis = pSSubSysServiceAPIService.selectByPSModule(this);
            }
            return this.pssubsysserviceapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSubViewType> getPSSubViewTypes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubViewTypes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSubViewTypeService pSSubViewTypeService = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSubViewTypesLock;
        synchronized (n) {
            if (this.pssubviewtypes == null) {
                this.pssubviewtypes = pSSubViewTypeService.selectByPSModule(this);
            }
            return this.pssubviewtypes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysActor> getPSSysActors() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActors();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysActorService pSSysActorService = (PSSysActorService)ServiceGlobal.getService(PSSysActorService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysActorsLock;
        synchronized (n) {
            if (this.pssysactors == null) {
                this.pssysactors = pSSysActorService.selectByPSModule(this);
            }
            return this.pssysactors;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysAIFactory> getPSSysAIFactories() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactories();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysAIFactoryService pSSysAIFactoryService = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIFactoriesLock;
        synchronized (n) {
            if (this.pssysaifactories == null) {
                this.pssysaifactories = pSSysAIFactoryService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAppsLock;
        synchronized (n) {
            if (this.pssysapps == null) {
                this.pssysapps = pSSysAppService.selectByPSModule(this);
            }
            return this.pssysapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDScheme> getPSSysBDSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDSchemesLock;
        synchronized (n) {
            if (this.pssysbdschemes == null) {
                this.pssysbdschemes = pSSysBDSchemeService.selectByPSModule(this);
            }
            return this.pssysbdschemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBIScheme> getPSSysBISchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBISchemesLock;
        synchronized (n) {
            if (this.pssysbischemes == null) {
                this.pssysbischemes = pSSysBISchemeService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysCanvasService pSSysCanvasService = (PSSysCanvasService)ServiceGlobal.getService(PSSysCanvasService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCanvasesLock;
        synchronized (n) {
            if (this.pssyscanvases == null) {
                this.pssyscanvases = pSSysCanvasService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysChartThemeService pSSysChartThemeService = (PSSysChartThemeService)ServiceGlobal.getService(PSSysChartThemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysChartThemesLock;
        synchronized (n) {
            if (this.pssyschartthemes == null) {
                this.pssyschartthemes = pSSysChartThemeService.selectByPSModule(this);
            }
            return this.pssyschartthemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysContent> getPSSysContents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContents();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysContentService pSSysContentService = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysContentsLock;
        synchronized (n) {
            if (this.pssyscontents == null) {
                this.pssyscontents = pSSysContentService.selectByPSModule(this);
            }
            return this.pssyscontents;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCounter> getPSSysCounters() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounters();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCountersLock;
        synchronized (n) {
            if (this.pssyscounters == null) {
                this.pssyscounters = pSSysCounterService.selectByPSModule(this);
            }
            return this.pssyscounters;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCssCat> getPSSysCssCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCats();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysCssCatService pSSysCssCatService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCssCatsLock;
        synchronized (n) {
            if (this.pssyscsscats == null) {
                this.pssyscsscats = pSSysCssCatService.selectByPSModule(this);
            }
            return this.pssyscsscats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCss> getPSSysCsses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCsses();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCssesLock;
        synchronized (n) {
            if (this.pssyscsses == null) {
                this.pssyscsses = pSSysCssService.selectByPSModule(this);
            }
            return this.pssyscsses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDashboard> getPSSydDashboards() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSydDashboards();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSydDashboardsLock;
        synchronized (n) {
            if (this.pssyddashboards == null) {
                this.pssyddashboards = pSSysDashboardService.selectByPSModule(this);
            }
            return this.pssyddashboards;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDataSyncAgent> getPSSysDataSyncAgents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDataSyncAgents();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDataSyncAgentsLock;
        synchronized (n) {
            if (this.pssysdatasyncagents == null) {
                this.pssysdatasyncagents = pSSysDataSyncAgentService.selectByPSModule(this);
            }
            return this.pssysdatasyncagents;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBVF> getPSSysDBVFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBVFsLock;
        synchronized (n) {
            if (this.pssysdbvfs == null) {
                this.pssysdbvfs = pSSysDBVFService.selectByPSModule(this);
            }
            return this.pssysdbvfs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDELogicNode> getPSSysDELogicNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDELogicNodeService pSSysDELogicNodeService = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDELogicNodesLock;
        synchronized (n) {
            if (this.pssysdelogicnodes == null) {
                this.pssysdelogicnodes = pSSysDELogicNodeService.selectByPSModule(this);
            }
            return this.pssysdelogicnodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDictCat> getPSSysDictCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCats();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDictCatService pSSysDictCatService = (PSSysDictCatService)ServiceGlobal.getService(PSSysDictCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDictCatsLock;
        synchronized (n) {
            if (this.pssysdictcats == null) {
                this.pssysdictcats = pSSysDictCatService.selectByPSModule(this);
            }
            return this.pssysdictcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDynaModel> getPSSysDynaModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModels();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDynaModelsLock;
        synchronized (n) {
            if (this.pssysdynamodels == null) {
                this.pssysdynamodels = pSSysDynaModelService.selectByPSModule(this);
            }
            return this.pssysdynamodels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIScheme> getPSSysEAISchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAISchemesLock;
        synchronized (n) {
            if (this.pssyseaischemes == null) {
                this.pssyseaischemes = pSSysEAISchemeService.selectByPSModule(this);
            }
            return this.pssyseaischemes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEditorStyle> getPSSysEditorStyles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyles();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysEditorStyleService pSSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEditorStylesLock;
        synchronized (n) {
            if (this.pssyseditorstyles == null) {
                this.pssyseditorstyles = pSSysEditorStyleService.selectByPSModule(this);
            }
            return this.pssyseditorstyles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysERMap> getPSSysERMaps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysERMaps();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysERMapService pSSysERMapService = (PSSysERMapService)ServiceGlobal.getService(PSSysERMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysERMapsLock;
        synchronized (n) {
            if (this.pssysermaps == null) {
                this.pssysermaps = pSSysERMapService.selectByPSModule(this);
            }
            return this.pssysermaps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysFile> getPSSysFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFiles();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysFileService pSSysFileService = (PSSysFileService)ServiceGlobal.getService(PSSysFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysFilesLock;
        synchronized (n) {
            if (this.pssysfiles == null) {
                this.pssysfiles = pSSysFileService.selectByPSModule(this);
            }
            return this.pssysfiles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysImage> getPSSysImages() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImages();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysImagesLock;
        synchronized (n) {
            if (this.pssysimages == null) {
                this.pssysimages = pSSysImageService.selectByPSModule(this);
            }
            return this.pssysimages;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysMsgTempl> getPSSysMsgTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempls();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysMsgTemplsLock;
        synchronized (n) {
            if (this.pssysmsgtempls == null) {
                this.pssysmsgtempls = pSSysMsgTemplService.selectByPSModule(this);
            }
            return this.pssysmsgtempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysOPPriv> getPSSysOPPrivs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysOPPrivService pSSysOPPrivService = (PSSysOPPrivService)ServiceGlobal.getService(PSSysOPPrivService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysOPPrivsLock;
        synchronized (n) {
            if (this.pssysopprivs == null) {
                this.pssysopprivs = pSSysOPPrivService.selectByPSModule(this);
            }
            return this.pssysopprivs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysOrgType> getPSSysOrgTypes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOrgTypes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysOrgTypeService pSSysOrgTypeService = (PSSysOrgTypeService)ServiceGlobal.getService(PSSysOrgTypeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysOrgTypesLock;
        synchronized (n) {
            if (this.pssysorgtypes == null) {
                this.pssysorgtypes = pSSysOrgTypeService.selectByPSModule(this);
            }
            return this.pssysorgtypes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPDTView> getPSSysPDTViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPDTViews();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPDTViewsLock;
        synchronized (n) {
            if (this.pssyspdtviews == null) {
                this.pssyspdtviews = pSSysPDTViewService.selectByPSModule(this);
            }
            return this.pssyspdtviews;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPFPlugin> getPSSysPFPlugins() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugins();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPFPluginsLock;
        synchronized (n) {
            if (this.pssyspfplugins == null) {
                this.pssyspfplugins = pSSysPFPluginService.selectByPSModule(this);
            }
            return this.pssyspfplugins;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPortletCat> getPSSysPortletCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletCats();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysPortletCatService pSSysPortletCatService = (PSSysPortletCatService)ServiceGlobal.getService(PSSysPortletCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPortletCatsLock;
        synchronized (n) {
            if (this.pssysportletcats == null) {
                this.pssysportletcats = pSSysPortletCatService.selectByPSModule(this);
            }
            return this.pssysportletcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPortlet> getPSSysPortlets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortlets();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPortletsLock;
        synchronized (n) {
            if (this.pssysportlets == null) {
                this.pssysportlets = pSSysPortletService.selectByPSModule(this);
            }
            return this.pssysportlets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysResource> getPSSysResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResources();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysResourcesLock;
        synchronized (n) {
            if (this.pssysresources == null) {
                this.pssysresources = pSSysResourceService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSampleValuesLock;
        synchronized (n) {
            if (this.pssyssamplevalues == null) {
                this.pssyssamplevalues = pSSysSampleValueService.selectByPSModule(this);
            }
            return this.pssyssamplevalues;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchBar> getPSSysSearchBars() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBars();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchBarsLock;
        synchronized (n) {
            if (this.pssyssearchbars == null) {
                this.pssyssearchbars = pSSysSearchBarService.selectByPSModule(this);
            }
            return this.pssyssearchbars;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchScheme> getPSSysSearchSchemes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchSchemesLock;
        synchronized (n) {
            if (this.pssyssearchschemes == null) {
                this.pssyssearchschemes = pSSysSearchSchemeService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysSequenceService pSSysSequenceService = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSequencesLock;
        synchronized (n) {
            if (this.pssyssequences == null) {
                this.pssyssequences = pSSysSequenceService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysServiceAPIsLock;
        synchronized (n) {
            if (this.pssysserviceapis == null) {
                this.pssysserviceapis = pSSysServiceAPIService.selectByPSModule(this);
            }
            return this.pssysserviceapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFPlugin> getPSSysSFPlugins() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugins();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFPluginsLock;
        synchronized (n) {
            if (this.pssyssfplugins == null) {
                this.pssyssfplugins = pSSysSFPluginService.selectByPSModule(this);
            }
            return this.pssyssfplugins;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTask> getPSSysTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasks();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTasksLock;
        synchronized (n) {
            if (this.pssystasks == null) {
                this.pssystasks = pSSysTaskService.selectByPSModule(this);
            }
            return this.pssystasks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestData> getPSSysTestDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDatas();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestDatasLock;
        synchronized (n) {
            if (this.pssystestdatas == null) {
                this.pssystestdatas = pSSysTestDataService.selectByPSModule(this);
            }
            return this.pssystestdatas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestPrj> getPSSysTestPrjs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysTestPrjService pSSysTestPrjService = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestPrjsLock;
        synchronized (n) {
            if (this.pssystestprjs == null) {
                this.pssystestprjs = pSSysTestPrjService.selectByPSModule(this);
            }
            return this.pssystestprjs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTranslator> getPSSysTranslators() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslators();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTranslatorsLock;
        synchronized (n) {
            if (this.pssystranslators == null) {
                this.pssystranslators = pSSysTranslatorService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUCMapService pSSysUCMapService = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUCMapsLock;
        synchronized (n) {
            if (this.pssysucmaps == null) {
                this.pssysucmaps = pSSysUCMapService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUniResesLock;
        synchronized (n) {
            if (this.pssysunireses == null) {
                this.pssysunireses = pSSysUniResService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUniStateService pSSysUniStateService = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUniStatesLock;
        synchronized (n) {
            if (this.pssysunistates == null) {
                this.pssysunistates = pSSysUniStateService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUnitService pSSysUnitService = (PSSysUnitService)ServiceGlobal.getService(PSSysUnitService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUnitsLock;
        synchronized (n) {
            if (this.pssysunits == null) {
                this.pssysunits = pSSysUnitService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUseCaseCatService pSSysUseCaseCatService = (PSSysUseCaseCatService)ServiceGlobal.getService(PSSysUseCaseCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUseCaseCatsLock;
        synchronized (n) {
            if (this.pssysusecasecats == null) {
                this.pssysusecasecats = pSSysUseCaseCatService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUserCaseRSService pSSysUserCaseRSService = (PSSysUserCaseRSService)ServiceGlobal.getService(PSSysUserCaseRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserCaseRSsLock;
        synchronized (n) {
            if (this.pssysusercaserss == null) {
                this.pssysusercaserss = pSSysUserCaseRSService.selectByPSModule(this);
            }
            return this.pssysusercaserss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserCase> getPSSysUserCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCases();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserCasesLock;
        synchronized (n) {
            if (this.pssysusercases == null) {
                this.pssysusercases = pSSysUserCaseService.selectByPSModule(this);
            }
            return this.pssysusercases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserDR> getPSSysUserDRs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUserDRService pSSysUserDRService = (PSSysUserDRService)ServiceGlobal.getService(PSSysUserDRService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserDRsLock;
        synchronized (n) {
            if (this.pssysuserdrs == null) {
                this.pssysuserdrs = pSSysUserDRService.selectByPSModule(this);
            }
            return this.pssysuserdrs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserMode> getPSSysUserModes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserModes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUserModeService pSSysUserModeService = (PSSysUserModeService)ServiceGlobal.getService(PSSysUserModeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserModesLock;
        synchronized (n) {
            if (this.pssysusermodes == null) {
                this.pssysusermodes = pSSysUserModeService.selectByPSModule(this);
            }
            return this.pssysusermodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUtilDE> getPSSysUtilDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEs();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUtilDEsLock;
        synchronized (n) {
            if (this.pssysutildes == null) {
                this.pssysutildes = pSSysUtilDEService.selectByPSModule(this);
            }
            return this.pssysutildes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysValueRule> getPSSysValueRules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRules();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysValueRulesLock;
        synchronized (n) {
            if (this.pssysvaluerules == null) {
                this.pssysvaluerules = pSSysValueRuleService.selectByPSModule(this);
            }
            return this.pssysvaluerules;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewLogic> getPSSysViewLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogics();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewLogicsLock;
        synchronized (n) {
            if (this.pssysviewlogics == null) {
                this.pssysviewlogics = pSSysViewLogicService.selectByPSModule(this);
            }
            return this.pssysviewlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanel> getPSSysViewPanels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanels();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelsLock;
        synchronized (n) {
            if (this.pssysviewpanels == null) {
                this.pssysviewpanels = pSSysViewPanelService.selectByPSModule(this);
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
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysWFCatService pSSysWFCatService = (PSSysWFCatService)ServiceGlobal.getService(PSSysWFCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysWFCatsLock;
        synchronized (n) {
            if (this.pssyswfcats == null) {
                this.pssyswfcats = pSSysWFCatService.selectByPSModule(this);
            }
            return this.pssyswfcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysWFMode> getPSSysWFModes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFModes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSSysWFModeService pSSysWFModeService = (PSSysWFModeService)ServiceGlobal.getService(PSSysWFModeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysWFModesLock;
        synchronized (n) {
            if (this.pssyswfmodes == null) {
                this.pssyswfmodes = pSSysWFModeService.selectByPSModule(this);
            }
            return this.pssyswfmodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSThresholdGroup> getPSThresholdGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSThresholdGroupService pSThresholdGroupService = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSThresholdGroupsLock;
        synchronized (n) {
            if (this.psthresholdgroups == null) {
                this.psthresholdgroups = pSThresholdGroupService.selectByPSModule(this);
            }
            return this.psthresholdgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewMsgGroup> getPSViewMsgGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewMsgGroupsLock;
        synchronized (n) {
            if (this.psviewmsggroups == null) {
                this.psviewmsggroups = pSViewMsgGroupService.selectByPSModule(this);
            }
            return this.psviewmsggroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewMsg> getPSViewMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsg();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSViewMsgService pSViewMsgService = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewMsgLock;
        synchronized (n) {
            if (this.psviewmsg == null) {
                this.psviewmsg = pSViewMsgService.selectByPSModule(this);
            }
            return this.psviewmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewWizardGroup> getPSViewWizardGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroups();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSViewWizardGroupService pSViewWizardGroupService = (PSViewWizardGroupService)ServiceGlobal.getService(PSViewWizardGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewWizardGroupsLock;
        synchronized (n) {
            if (this.psviewwizardgroups == null) {
                this.psviewwizardgroups = pSViewWizardGroupService.selectByPSModule(this);
            }
            return this.psviewwizardgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFRole> getPSWFRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoles();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSWFRoleService pSWFRoleService = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFRolesLock;
        synchronized (n) {
            if (this.pswfroles == null) {
                this.pswfroles = pSWFRoleService.selectByPSModule(this);
            }
            return this.pswfroles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFWorkTime> getPSWFWorkTimes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorkTimes();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSWFWorkTimeService pSWFWorkTimeService = (PSWFWorkTimeService)ServiceGlobal.getService(PSWFWorkTimeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFWorkTimesLock;
        synchronized (n) {
            if (this.pswfworktimes == null) {
                this.pswfworktimes = pSWFWorkTimeService.selectByPSModule(this);
            }
            return this.pswfworktimes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWorkflow> getPSWorkflows() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflows();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWorkflowsLock;
        synchronized (n) {
            if (this.psworkflows == null) {
                this.psworkflows = pSWorkflowService.selectByPSModule(this);
            }
            return this.psworkflows;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWXAccount> getPSWXAccounts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccounts();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        PSWXAccountService pSWXAccountService = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWXAccountsLock;
        synchronized (n) {
            if (this.pswxaccounts == null) {
                this.pswxaccounts = pSWXAccountService.selectByPSModule(this);
            }
            return this.pswxaccounts;
        }
    }

    private PSModuleBase getProxyEntity() {
        return this.proxyPSModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSModuleBase) {
            this.proxyPSModuleBase = (PSModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAMEMODE, 2);
        fieldIndexMap.put(FIELD_COLOR, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 6);
        fieldIndexMap.put(FIELD_DSLINK, 7);
        fieldIndexMap.put(FIELD_DTOFORMAT, 8);
        fieldIndexMap.put(FIELD_DYNAINSTMODE, 9);
        fieldIndexMap.put(FIELD_DYNAINSTTAG, 10);
        fieldIndexMap.put(FIELD_DYNAINSTTAG2, 11);
        fieldIndexMap.put(FIELD_ENABLEPQL, 12);
        fieldIndexMap.put(FIELD_LANRESTAG, 13);
        fieldIndexMap.put(FIELD_LOCKFLAG, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MODTAG, 16);
        fieldIndexMap.put(FIELD_MODTAG2, 17);
        fieldIndexMap.put(FIELD_MODTAG3, 18);
        fieldIndexMap.put(FIELD_MODTAG4, 19);
        fieldIndexMap.put(FIELD_MODULESN, 20);
        fieldIndexMap.put(FIELD_NOVIEWMODE, 21);
        fieldIndexMap.put(FIELD_ORDERVALUE, 22);
        fieldIndexMap.put(FIELD_PKGCODENAME, 23);
        fieldIndexMap.put(FIELD_PSMODULEID, 24);
        fieldIndexMap.put(FIELD_PSMODULENAME, 25);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 26);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSREFID, 28);
        fieldIndexMap.put(FIELD_PSSYSREFNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 30);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 33);
        fieldIndexMap.put(FIELD_REQMODULE, 34);
        fieldIndexMap.put(FIELD_RUNTIMETYPE, 35);
        fieldIndexMap.put(FIELD_SERVICEAPIFLAG, 36);
        fieldIndexMap.put(FIELD_SHORTTAG, 37);
        fieldIndexMap.put(FIELD_SUBSYSMODULE, 38);
        fieldIndexMap.put(FIELD_SYSREFTYPE, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 40);
        fieldIndexMap.put(FIELD_UPDATEMAN, 41);
        fieldIndexMap.put(FIELD_USERCAT, 42);
        fieldIndexMap.put(FIELD_USERPARAMS, 43);
        fieldIndexMap.put(FIELD_USERTAG, 44);
        fieldIndexMap.put(FIELD_USERTAG2, 45);
        fieldIndexMap.put(FIELD_USERTAG3, 46);
        fieldIndexMap.put(FIELD_USERTAG4, 47);
        fieldIndexMap.put(FIELD_UTILPARAMS, 48);
        fieldIndexMap.put(FIELD_UTILTAG, 49);
        fieldIndexMap.put(FIELD_UTILTYPE, 50);
    }
}

