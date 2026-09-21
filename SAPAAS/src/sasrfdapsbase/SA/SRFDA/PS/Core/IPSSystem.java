/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.ISystem
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSSysDEFType;
import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSSysDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSSysDMItem;
import SA.SRFDA.PS.Core.Database.IPSSysDMVer;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.Deploy.IPSSystemAS;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemContainer;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysChartTheme;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysDEFInputTip;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysFile;
import SA.SRFDA.PS.Core.Res.IPSSysI18N;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.System.IPSSubSysRef;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.WF.IPSSysWFSetting;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.ISystem;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSystem", description="\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61\u662f\u7cfb\u7edf\u6a21\u578b\u7684\u6839\u5bf9\u8c61")
public interface IPSSystem
extends IPSModelObject,
ISystem {
    public static final Integer DYNASYSMODE_NOTSUPPORTED = 0;
    public static final Integer DYNASYSMODE_DYNAINST = 1;
    public static final Integer DYNASYSMODE_DYNASYS = 2;
    public static final Integer LOADLEVEL_NONE = 0;
    public static final Integer LOADLEVEL_PREVIEW = 10;
    public static final Integer LOADLEVEL_JIT = 30;
    public static final Integer LOADLEVEL_STARTUP = 50;
    public static final Integer LOADLEVEL_CODE = 60;
    public static final Integer LOADLEVEL_DIFF = 70;
    public static final Integer LOADLEVEL_DOC = 80;
    public static final Integer LOADLEVEL_ALL = 99;
    public static final Integer SAASMODE_NOTSUPPORTED = 0;
    public static final Integer SAASMODE_STANDARD = 1;
    public static final Integer SAASMODE_STANDARD2 = 2;
    public static final Integer SAASMODE_STANDARD3 = 3;
    public static final Integer SAASMODE_STANDARD4 = 4;
    public static final String GLOBALPLUGIN_SYSTEMRUNTIME = "GLOBAL_SYSTEMRUNTIME";

    public void init(ISRFDAGlobalHelper var1, IPSSystemContainer var2, PSSystem var3) throws Exception;

    public IPSSystemDeploy getDefaultPSSystemDeploy() throws Exception;

    @Deprecated
    public IPSDataEntity getPSDataEntity(String var1) throws Exception;

    @Deprecated
    public IPSDataEntity getPSDataEntity(String var1, boolean var2) throws Exception;

    public IPSDataEntity getPSDataEntity2(String var1) throws Exception;

    public IPSDataEntity getPSDataEntity2(String var1, boolean var2) throws Exception;

    public void resetPSDataEntity(String var1);

    public Iterator<IPSDataEntity> getAllPSDataEntities() throws Exception;

    public IPSCodeList getPSCodeList(String var1) throws Exception;

    public IPSCodeList getPSCodeList(String var1, boolean var2) throws Exception;

    public void resetPSCodeList(String var1) throws Exception;

    public IPSCodeList getPSCodeListByTempl(String var1) throws Exception;

    public void resetAllPSCodeLists();

    public Iterator<String> getSupportDBTypes();

    public IPSSystemDBConfig getPSSystemDBConfig(String var1) throws Exception;

    public IPSSystemDBConfig getPSSystemDBConfig(String var1, boolean var2) throws Exception;

    public IPSApplication getPSApplication(String var1) throws Exception;

    public void resetPSApplication(String var1);

    public IPSDEUIAction getPSDEUIAction(String var1) throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1, boolean var2) throws Exception;

    public void resetPSDEUIAction(String var1);

    public Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception;

    public IPSDERBase getPSDER(String var1) throws Exception;

    public IPSDER1N getPSDER1N(String var1) throws Exception;

    public void resetPSDER(String var1);

    public Iterator<IPSSysDBValueFunc> getAllPSSysDBValueFuncs() throws Exception;

    public IPSSysDBValueFunc getPSSysDBValueFunc(String var1) throws Exception;

    public void resetPSSysDBValueFunc(String var1);

    public String getSFType();

    public Iterator<IPSApplication> getAllPSApps() throws Exception;

    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception;

    public Iterator<IPSWFRole> getAllPSWFRoles() throws Exception;

    public Iterator<IPSWFWorkTime> getAllPSWFWorkTimes() throws Exception;

    public PSACHandler getPSAjaxControlHandlerData(String var1, boolean var2) throws Exception;

    public void resetPSAjaxControlHandlerData(String var1);

    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception;

    public Iterator<IPSDERBase> getAllPSDERs() throws Exception;

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule(String var1) throws Exception;

    public void resetPSSystemModule(String var1);

    public Iterator<IPSSystemModule> getAllPSSystemModules() throws Exception;

    public Iterator<IPSSysRef> getAllPSSysRefs() throws Exception;

    public IPSSysRef getPSSysRef(String var1) throws Exception;

    public void resetPSSysRef(String var1);

    public IPSWorkflow getPSWorkflow(String var1) throws Exception;

    public IPSWorkflow getPSWorkflow(String var1, boolean var2) throws Exception;

    public void resetPSWorkflow(String var1);

    public IPSWFRole getPSWFRole(String var1) throws Exception;

    public IPSWFRole getPSWFRole(String var1, boolean var2) throws Exception;

    public void resetPSWFRole(String var1);

    public int getLoadingLevel();

    public int getLoadedLevel();

    public void load(int var1) throws Exception;

    public boolean isLoading();

    public Iterator<IPSSysImage> getAllPSSysImages() throws Exception;

    public IPSSysImage getPSSysImage(String var1) throws Exception;

    public IPSSysImage getPSSysImage(String var1, boolean var2) throws Exception;

    public void resetPSSysImage(String var1) throws Exception;

    public void resetAllPSSysImages();

    public Iterator<IPSSysCss> getAllPSSysCsses() throws Exception;

    public IPSSysCss getPSSysCss(String var1) throws Exception;

    public IPSSysCss getPSSysCss(String var1, boolean var2) throws Exception;

    public void resetPSSysCss(String var1) throws Exception;

    public void resetAllPSSysCsses();

    public Iterator<IPSCtrlMsg> getAllPSCtrlMsgs() throws Exception;

    public IPSCtrlMsg getPSCtrlMsg(String var1) throws Exception;

    public IPSCtrlMsg getPSCtrlMsg(String var1, boolean var2) throws Exception;

    public void resetPSCtrlMsg(String var1) throws Exception;

    public void resetAllPSCtrlMsgs();

    public Iterator<IPSSysPortlet> getAllPSSysPortlets() throws Exception;

    public IPSSysPortlet getPSSysPortlet(String var1) throws Exception;

    public void resetPSSysPortlet(String var1) throws Exception;

    public void resetAllPSSysPortlets();

    public Iterator<IPSSysDictCat> getAllPSSysDictCats() throws Exception;

    public IPSSysDictCat getPSSysDictCat(String var1) throws Exception;

    public IPSSysDictCat getPSSysDictCat(String var1, boolean var2) throws Exception;

    public void resetPSSysDictCat(String var1) throws Exception;

    public void resetAllPSSysDictCats();

    public Iterator<IPSSysPDTView> getAllPSSysPDTViews() throws Exception;

    public IPSSysPDTView getPSSysPDTView(String var1) throws Exception;

    public IPSSysPDTView getPSSysPDTView(String var1, boolean var2) throws Exception;

    public void resetPSSysPDTView(String var1) throws Exception;

    public void resetAllPSSysPDTViews();

    public Iterator<IPSSysValueRule> getAllPSSysValueRules() throws Exception;

    public IPSSysValueRule getPSSysValueRule(String var1) throws Exception;

    public IPSSysValueRule getPSSysValueRule(String var1, boolean var2) throws Exception;

    public void resetPSSysValueRule(String var1) throws Exception;

    public void resetAllPSSysValueRules();

    public Iterator<IPSSystemDBConfig> getAllPSSystemDBConfigs() throws Exception;

    public IPSSystemDBConfig getDefaultPSSystemDBConfig();

    @Override
    public String getPSSysModelInstId();

    public String getPSDevSlnSysId();

    public String getPSDepSlnPrdId();

    public String getPSDevCenterDomain();

    public String getPSDevCenterId();

    public String getPSDevCenterName();

    public String getPubSystemId();

    public String getPSSFId();

    public String getPSSFName();

    public IPSSystemAS getPSSystemAS(String var1) throws Exception;

    public void resetPSSystemAS(String var1);

    public IPSSVNInstRepo getPSSVNInstRepo();

    public IPSSVNInstRepo getReadOnlyPSSVNInstRepo();

    public IPSSVNInstRepo getRTPSSVNInstRepo();

    public IPSSVNInstRepo getDocPSSVNInstRepo();

    public IPSSVNInstRepo getOpenPSSVNInstRepo();

    public String getVCName();

    public String getTrunkSysName();

    public String getPSDevSlnCodeName();

    public IPSSubSysRef getPSSubSysRef(String var1) throws Exception;

    public void resetPSSubSysRef(String var1);

    public Iterator<IPSSubSysRef> getAllPSSubSysRefs() throws Exception;

    public IPSSysPFPlugin getPSSysPFPlugin(String var1) throws Exception;

    public void resetPSSysPFPlugin(String var1);

    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins() throws Exception;

    public IPSSysPFPluginTempl getPSSysPFPluginTempl(String var1, boolean var2) throws Exception;

    public void resetPSSysPFPluginTempl(String var1);

    public Iterator<IPSSysPFPluginTempl> getAllPSSysPFPluginTempls() throws Exception;

    public IPSSysCounter getPSSysCounter(String var1) throws Exception;

    public IPSSysCounter getPSSysCounter(String var1, boolean var2) throws Exception;

    public void resetPSSysCounter(String var1);

    public Iterator<IPSSysCounter> getAllPSSysCounters() throws Exception;

    public Iterator<IPSSubViewType> getAllPSSubViewTypes() throws Exception;

    public IPSSubViewType getPSSubViewType(String var1) throws Exception;

    public IPSSubViewType getPSSubViewType(String var1, boolean var2) throws Exception;

    public void resetPSSubViewType(String var1) throws Exception;

    public void resetAllPSSubViewTypes();

    public Iterator<IPSSysUniRes> getAllPSSysUniReses() throws Exception;

    public IPSSysUniRes getPSSysUniRes(String var1) throws Exception;

    public IPSSysUniRes getPSSysUniRes(String var1, boolean var2) throws Exception;

    public void resetPSSysUniRes(String var1) throws Exception;

    public void resetAllPSSysUniReses();

    public Iterator<IPSSysMsgTempl> getAllPSSysMsgTempls() throws Exception;

    @Deprecated
    public Iterator<IPSSysMsgTempl> getAllPSSysMsgTemples() throws Exception;

    public IPSSysMsgTempl getPSSysMsgTempl(String var1) throws Exception;

    public IPSSysMsgTempl getPSSysMsgTempl(String var1, boolean var2) throws Exception;

    public void resetPSSysMsgTempl(String var1) throws Exception;

    public void resetAllPSSysMsgTemples();

    public IPSDEOPPriv getPSDEOPPriv(String var1) throws Exception;

    public IPSDEOPPriv getPSDEOPPriv(String var1, boolean var2) throws Exception;

    public void resetPSDEOPPriv(String var1) throws Exception;

    public Iterator<IPSSysDEOPPriv> getAllPSDEOPPrivs() throws Exception;

    public Iterator<IPSSysBackService> getAllPSSysBackServices() throws Exception;

    public IPSSysBackService getPSSysBackService(String var1) throws Exception;

    public IPSSysBackService getPSSysBackService(String var1, boolean var2) throws Exception;

    public void resetPSSysBackService(String var1) throws Exception;

    public void resetAllPSSysBackServices();

    public IPSSysEditorStyle getPSSysEditorStyle(String var1) throws Exception;

    public void resetPSSysEditorStyle(String var1);

    public Iterator<IPSSysEditorStyle> getAllPSSysEditorStyles() throws Exception;

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String var1);

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String var1, String var2);

    public IPSSysWFSetting getPSSysWFSetting();

    public Iterator<IPSSysViewLogic> getAllPSSysViewLogics() throws Exception;

    public IPSSysViewLogic getPSSysViewLogic(String var1) throws Exception;

    public IPSSysViewLogic getPSSysViewLogic(String var1, boolean var2) throws Exception;

    public void resetPSSysViewLogic(String var1) throws Exception;

    public void resetAllPSSysViewLogics();

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEUIActionGroup(String var1);

    public Iterator<IPSDEUIActionGroup> getAllPSDEUIActionGroups() throws Exception;

    @Override
    public int check() throws Exception;

    public int check(int var1) throws Exception;

    public void quickCheck() throws Exception;

    public String getLogicName();

    public Iterator<IPSSysDMItem> getAllPSSysDMItems() throws Exception;

    public Iterator<IPSSysDMItem> getPSSysDMItems(String var1) throws Exception;

    public IPSSysDMItem getLastTestPSSysDMItem(String var1) throws Exception;

    public Iterator<IPSSysActor> getAllPSSysActors() throws Exception;

    public IPSSysActor getPSSysActor(String var1) throws Exception;

    public IPSSysActor getPSSysActor(String var1, boolean var2) throws Exception;

    public void resetPSSysActor(String var1) throws Exception;

    public void resetAllPSSysActors();

    public Iterator<IPSSysUseCase> getAllPSSysUseCases() throws Exception;

    public IPSSysUseCase getPSSysUseCase(String var1) throws Exception;

    public IPSSysUseCase getPSSysUseCase(String var1, boolean var2) throws Exception;

    public void resetPSSysUseCase(String var1) throws Exception;

    public void resetAllPSSysUseCases();

    public Iterator<IPSSysUseCaseRS> getAllPSSysUseCaseRSs() throws Exception;

    public IPSSysUseCaseRS getPSSysUseCaseRS(String var1) throws Exception;

    public IPSSysUseCaseRS getPSSysUseCaseRS(String var1, boolean var2) throws Exception;

    public void resetPSSysUseCaseRS(String var1) throws Exception;

    public void resetAllPSSysUseCaseRSs();

    public Iterator<IPSSysTestCase> getAllPSSysTestCases() throws Exception;

    public IPSSysTestCase getPSSysTestCase(String var1) throws Exception;

    public IPSSysTestCase getPSSysTestCase(String var1, boolean var2) throws Exception;

    public void resetPSSysTestCase(String var1) throws Exception;

    public void resetAllPSSysTestCases();

    public Iterator<IPSSysTestData> getAllPSSysTestDatas() throws Exception;

    public IPSSysTestData getPSSysTestData(String var1) throws Exception;

    public IPSSysTestData getPSSysTestData(String var1, boolean var2) throws Exception;

    public void resetPSSysTestData(String var1) throws Exception;

    public void resetAllPSSysTestDatas();

    public Iterator<IPSSysSampleValue> getAllPSSysSampleValues() throws Exception;

    public IPSSysSampleValue getPSSysSampleValue(String var1) throws Exception;

    public IPSSysSampleValue getPSSysSampleValue(String var1, boolean var2) throws Exception;

    public void resetPSSysSampleValue(String var1) throws Exception;

    public void resetAllPSSysSampleValues();

    public Iterator<IPSSysUserMode> getAllPSSysUserModes() throws Exception;

    public IPSSysUserMode getPSSysUserMode(String var1) throws Exception;

    public IPSSysUserMode getPSSysUserMode(String var1, boolean var2) throws Exception;

    public void resetPSSysUserMode(String var1) throws Exception;

    public void resetAllPSSysUserModes();

    public Iterator<IPSSysERMap> getAllPSSysERMaps() throws Exception;

    public IPSSysERMap getPSSysERMap(String var1) throws Exception;

    public IPSSysERMap getPSSysERMap(String var1, boolean var2) throws Exception;

    public void resetPSSysERMap(String var1) throws Exception;

    public void resetAllPSSysERMaps();

    public Iterator<IPSSysUCMap> getAllPSSysUCMaps() throws Exception;

    public IPSSysUCMap getPSSysUCMap(String var1) throws Exception;

    public IPSSysUCMap getPSSysUCMap(String var1, boolean var2) throws Exception;

    public void resetPSSysUCMap(String var1) throws Exception;

    public void resetAllPSSysUCMaps();

    public IPSSysSFPub getPSSysSFPub(String var1) throws Exception;

    public IPSSysSFPub getDefaultPSSysSFPub();

    public void resetPSSysSFPub(String var1);

    public Iterator<IPSSysSFPub> getAllPSSysSFPubs() throws Exception;

    public void resetAllPSSysSFPubs();

    public IPSSysDataSyncAgent getPSSysDataSyncAgent(String var1) throws Exception;

    public IPSSysDataSyncAgent getPSSysDataSyncAgent(String var1, boolean var2) throws Exception;

    public void resetPSSysDataSyncAgent(String var1);

    public Iterator<IPSSysDataSyncAgent> getAllPSSysDataSyncAgents() throws Exception;

    public int getEngineVer();

    public boolean testEngineVer(int var1);

    public Iterator<IPSSysUserDR> getAllPSSysUserDRs() throws Exception;

    public IPSSysUserDR getPSSysUserDR(String var1) throws Exception;

    public IPSSysUserDR getPSSysUserDR(String var1, boolean var2) throws Exception;

    public void resetPSSysUserDR(String var1) throws Exception;

    public void resetAllPSSysUserDRs();

    public Iterator<IPSSysBDScheme> getAllPSSysBDSchemes() throws Exception;

    public IPSSysBDScheme getPSSysBDScheme(String var1) throws Exception;

    public IPSSysBDScheme getPSSysBDScheme(String var1, boolean var2) throws Exception;

    public void resetPSSysBDScheme(String var1) throws Exception;

    public void resetAllPSSysBDSchemes();

    public Iterator<IPSSysDEFInputTip> getAllPSSysDEFInputTips() throws Exception;

    public IPSSysDEFInputTip getPSSysDEFInputTip(String var1) throws Exception;

    public IPSSysDEFInputTip getPSSysDEFInputTip(String var1, boolean var2) throws Exception;

    public void resetPSSysDEFInputTip(String var1) throws Exception;

    public void resetAllPSSysDEFInputTips();

    public Iterator<IPSViewMsgGroup> getAllPSViewMsgGroups() throws Exception;

    public IPSViewMsgGroup getPSViewMsgGroup(String var1) throws Exception;

    public IPSViewMsgGroup getPSViewMsgGroup(String var1, boolean var2) throws Exception;

    public void resetPSViewMsgGroup(String var1) throws Exception;

    public void resetAllPSViewMsgGroups();

    public Iterator<IPSViewMsg> getAllPSViewMsgs() throws Exception;

    public IPSViewMsg getPSViewMsg(String var1) throws Exception;

    public IPSViewMsg getPSViewMsg(String var1, boolean var2) throws Exception;

    public void resetPSViewMsg(String var1) throws Exception;

    public void resetAllPSViewMsgs();

    public Iterator<IPSWXAccount> getAllPSWXAccounts() throws Exception;

    public IPSWXAccount getPSWXAccount(String var1) throws Exception;

    public IPSWXAccount getPSWXAccount(String var1, boolean var2) throws Exception;

    public void resetPSWXAccount(String var1) throws Exception;

    public void resetAllPSWXAccounts();

    public Iterator<IPSSysUnit> getAllPSSysUnits() throws Exception;

    public IPSSysUnit getPSSysUnit(String var1) throws Exception;

    public IPSSysUnit getPSSysUnit(String var1, boolean var2) throws Exception;

    public void resetPSSysUnit(String var1) throws Exception;

    public void resetAllPSSysUnits();

    public Iterator<IPSSysFile> getAllPSSysFiles() throws Exception;

    public IPSSysFile getPSSysFile(String var1) throws Exception;

    public void resetPSSysFile(String var1) throws Exception;

    public void resetAllPSSysFiles();

    public Iterator<IPSLanguageRes> getAllPSLanguageReses() throws Exception;

    public IPSLanguageRes getPSLanguageRes(String var1) throws Exception;

    public void resetPSLanguageRes(String var1) throws Exception;

    public void resetAllPSLanguageReses();

    public Iterator<IPSLanguageItem> getAllPSLanguageItems() throws Exception;

    public IPSLanguageItem getPSLanguageItem(String var1, boolean var2) throws Exception;

    public void resetPSLanguageItem(String var1) throws Exception;

    public void resetAllPSLanguageItems();

    public Iterator<IPSHelpArticle> getAllPSHelpArticles() throws Exception;

    public IPSHelpArticle getPSHelpArticle(String var1) throws Exception;

    public void resetPSHelpArticle(String var1) throws Exception;

    public void resetAllPSHelpArticles();

    public Iterator<IPSHelpPrj> getAllPSHelpPrjs() throws Exception;

    public IPSHelpPrj getPSHelpPrj(String var1) throws Exception;

    public void resetPSHelpPrj(String var1) throws Exception;

    public void resetAllPSHelpPrjs();

    public Iterator<IPSHelpResource> getAllPSHelpResources() throws Exception;

    public IPSHelpResource getPSHelpResource(String var1) throws Exception;

    public void resetPSHelpResource(String var1) throws Exception;

    public void resetAllPSHelpResources();

    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception;

    public void resetAllPSSysLans();

    public String getDefaultLanguage();

    public boolean isEnableMultiLan();

    public Iterator<IPSDEFInputTipSet> getAllPSDEFInputTipSets() throws Exception;

    public IPSDEFInputTipSet getPSDEFInputTipSet(String var1) throws Exception;

    public IPSDEFInputTipSet getPSDEFInputTipSet(String var1, boolean var2) throws Exception;

    public void resetPSDEFInputTipSet(String var1) throws Exception;

    public void resetAllPSDEFInputTipSets();

    public Iterator<IPSSysUniState> getAllPSSysUniStates() throws Exception;

    public IPSSysUniState getPSSysUniState(String var1) throws Exception;

    public IPSSysUniState getPSSysUniState(String var1, boolean var2) throws Exception;

    public void resetPSSysUniState(String var1) throws Exception;

    public void resetAllPSSysUniStates();

    public IPSDBDevInst getJITPSDBDevInst() throws Exception;

    public void active();

    public void active(boolean var1);

    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField var1) throws Exception;

    public Iterator<IPSSysDEFType> getAllPSSysDEFTypes() throws Exception;

    public Iterator<IPSSysLogic> getAllPSSysLogics() throws Exception;

    public IPSSysLogic getPSSysLogic(String var1) throws Exception;

    public void resetPSSysLogic(String var1) throws Exception;

    public void resetAllPSSysLogics();

    public boolean isNoViewMode();

    public IPSSysServiceAPIHandler getPSSysServiceAPIHandler(String var1) throws Exception;

    public IPSSysServiceAPIHandler getPSSysServiceAPIHandler(String var1, boolean var2) throws Exception;

    public void resetPSSysServiceAPIHandler(String var1);

    public void resetAllPSSysServiceAPIHandlers();

    public Iterator<IPSSysServiceAPIHandler> getAllPSSysServiceAPIHandlers() throws Exception;

    public IPSSysServiceAPIHandler getPSSysServiceAPIHandlerByPredefinedType(String var1, boolean var2) throws Exception;

    public IPSSysServiceAPI getPSSysServiceAPI(String var1) throws Exception;

    public IPSSysServiceAPI getPSSysServiceAPI(String var1, boolean var2) throws Exception;

    public void resetPSSysServiceAPI(String var1);

    public void resetAllPSSysServiceAPIs();

    public Iterator<IPSSysServiceAPI> getAllPSSysServiceAPIs() throws Exception;

    public Iterator<IPSSysDTSQueue> getAllPSSysDTSQueues() throws Exception;

    public IPSSysDTSQueue getPSSysDTSQueue(String var1) throws Exception;

    public IPSSysDTSQueue getPSSysDTSQueue(String var1, boolean var2) throws Exception;

    public void resetPSSysDTSQueue(String var1) throws Exception;

    public void resetAllPSSysDTSQueues();

    public IPSSubSysServiceAPI getPSSubSysServiceAPI(String var1) throws Exception;

    public IPSSubSysServiceAPI getPSSubSysServiceAPI(String var1, boolean var2) throws Exception;

    public void resetPSSubSysServiceAPI(String var1);

    public void resetAllPSSubSysServiceAPIs();

    public Iterator<IPSSubSysServiceAPI> getAllPSSubSysServiceAPIs() throws Exception;

    public Iterator<IPSSysUserRole> getAllPSSysUserRoles() throws Exception;

    public IPSSysUserRole getPSSysUserRole(String var1) throws Exception;

    public IPSSysUserRole getPSSysUserRole(String var1, boolean var2) throws Exception;

    public void resetPSSysUserRole(String var1) throws Exception;

    public void resetAllPSSysUserRoles();

    public IPSSysSFPlugin getPSSysSFPlugin(String var1) throws Exception;

    public void resetPSSysSFPlugin(String var1);

    public Iterator<IPSSysSFPlugin> getAllPSSysSFPlugins() throws Exception;

    public IPSSysSFPluginTempl getPSSysSFPluginTempl(String var1, boolean var2) throws Exception;

    public void resetPSSysSFPluginTempl(String var1);

    public Iterator<IPSSysSFPluginTempl> getAllPSSysSFPluginTempls() throws Exception;

    public Iterator<IPSSysUtil> getAllPSSysUtils() throws Exception;

    public IPSSysUtil getPSSysUtil(String var1) throws Exception;

    public IPSSysUtil getPSSysUtil(String var1, boolean var2) throws Exception;

    public void resetPSSysUtil(String var1) throws Exception;

    public void resetAllPSSysUtils();

    public String getVCType();

    public String getSysVersion();

    public IPSSystem getSourcePSSystem() throws Exception;

    public Iterator<IPSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception;

    public Iterator<IPSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception;

    public Iterator<IPSDevSlnMSDepAPI> getAllPSDevSlnMSDepAPIs() throws Exception;

    public Iterator<IPSDevSlnMSDepApp> getAllPSDevSlnMSDepApps() throws Exception;

    public Iterator<IPSDevSlnMSDepFunc> getAllPSDevSlnMSDepFuncs() throws Exception;

    public boolean hasPSWFEngineType(String var1) throws Exception;

    public Iterator<IPSSysDynaModel> getAllPSSysDynaModels() throws Exception;

    public IPSSysDynaModel getPSSysDynaModel(String var1) throws Exception;

    public void resetPSSysDynaModel(String var1) throws Exception;

    public void resetAllPSSysDynaModels();

    public IPSSystemSetting getPSSystemSetting();

    public Iterator<IPSSysDMVer> getAllPSSysDMVers() throws Exception;

    public IPSSysDMVer getPSSysDMVer(String var1) throws Exception;

    public IPSSysDMVer getPSSysDMVer(String var1, boolean var2) throws Exception;

    public IPSSysDMVer getActivePSSysDMVer() throws Exception;

    public Iterator<IPSDEActionTempl> getAllPSDEActionTempls() throws Exception;

    public IPSDEActionTempl getPSDEActionTempl(String var1) throws Exception;

    public IPSDEActionTempl getPSDEActionTempl(String var1, boolean var2) throws Exception;

    public void resetPSDEActionTempl(String var1) throws Exception;

    public void resetAllPSDEActionTempls();

    public Iterator<IPSDynaDETempl> getAllPSDynaDETempls() throws Exception;

    public IPSDynaDETempl getPSDynaDETempl(String var1) throws Exception;

    public void resetPSDynaDETempl(String var1) throws Exception;

    public void resetAllPSDynaDETempls();

    public int getDBVersion();

    public boolean isEnableDynaSys();

    public int getDynaSysMode();

    public int getSaaSMode();

    public IPSSystemModule getDefaultPSSystemModule();

    public IPSSysDynaModel getDefaultPSSysDynaModelByModule(String var1);

    public Iterator<IPSSysDBScheme> getAllPSSysDBSchemes() throws Exception;

    public IPSSysDBScheme getPSSysDBScheme(String var1) throws Exception;

    public IPSSysDBScheme getPSSysDBScheme(String var1, boolean var2) throws Exception;

    public IPSSysDBScheme getPSSysDBScheme(String var1, String var2, boolean var3) throws Exception;

    public void resetPSSysDBScheme(String var1) throws Exception;

    public void resetAllPSSysDBSchemes();

    public Iterator<IPSSysResource> getAllPSSysResources() throws Exception;

    public IPSSysResource getPSSysResource(String var1) throws Exception;

    public IPSSysResource getPSSysResource(String var1, boolean var2) throws Exception;

    public void resetPSSysResource(String var1) throws Exception;

    public void resetAllPSSysResources();

    public Iterator<IPSSysContentCat> getAllPSSysContentCats() throws Exception;

    public Iterator<IPSSysContentCat> getRootPSSysContentCats() throws Exception;

    public IPSSysContentCat getPSSysContentCat(String var1) throws Exception;

    public IPSSysContentCat getPSSysContentCat(String var1, boolean var2) throws Exception;

    public void resetPSSysContentCat(String var1) throws Exception;

    public void resetAllPSSysContentCats();

    public Iterator<IPSSysContentCat> getAllPSSysContentCats2() throws Exception;

    public IPSSysDEGroup getPSDEGroup(String var1) throws Exception;

    public IPSSysDEGroup getPSDEGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEGroup(String var1);

    public Iterator<IPSSysDEGroup> getAllPSDEGroups() throws Exception;

    public Iterator<IPSSysDEGroup> getAllPSSysDEGroups() throws Exception;

    public IPSSysDERGroup getPSDERGroup(String var1) throws Exception;

    public IPSSysDERGroup getPSDERGroup(String var1, boolean var2) throws Exception;

    public void resetPSDERGroup(String var1);

    public Iterator<IPSSysDERGroup> getAllPSDERGroups() throws Exception;

    public Iterator<IPSSysDERGroup> getAllPSSysDERGroups() throws Exception;

    public Iterator<IPSSysTestPrj> getAllPSSysTestPrjs() throws Exception;

    public IPSSysTestPrj getPSSysTestPrj(String var1) throws Exception;

    public IPSSysTestPrj getPSSysTestPrj(String var1, boolean var2) throws Exception;

    public void resetPSSysTestPrj(String var1) throws Exception;

    public void resetAllPSSysTestPrjs();

    public Iterator<IPSSysReqModule> getAllPSSysReqModules() throws Exception;

    public Iterator<IPSSysReqModule> getRootPSSysReqModules() throws Exception;

    public IPSSysReqModule getPSSysReqModule(String var1) throws Exception;

    public IPSSysReqModule getPSSysReqModule(String var1, boolean var2) throws Exception;

    public void resetPSSysReqModule(String var1) throws Exception;

    public void resetAllPSSysReqModules();

    public Iterator<IPSSysReqModule> getAllPSSysReqModules2() throws Exception;

    public Iterator<IPSSysReqItem> getAllPSSysReqItems() throws Exception;

    public Iterator<IPSSysReqItem> getRootPSSysReqItems() throws Exception;

    public IPSSysReqItem getPSSysReqItem(String var1) throws Exception;

    public IPSSysReqItem getPSSysReqItem(String var1, boolean var2) throws Exception;

    public void resetPSSysReqItem(String var1) throws Exception;

    public void resetAllPSSysReqItems();

    public IPSSysModelGroup getPSSysModelGroup(String var1) throws Exception;

    public void resetPSSysModelGroup(String var1);

    public Iterator<IPSSysModelGroup> getAllPSSysModelGroups() throws Exception;

    public Iterator<IPSSysSearchScheme> getAllPSSysSearchSchemes() throws Exception;

    public IPSSysSearchScheme getPSSysSearchScheme(String var1) throws Exception;

    public IPSSysSearchScheme getPSSysSearchScheme(String var1, boolean var2) throws Exception;

    public Iterator<IPSSysPortletCat> getAllPSSysPortletCats() throws Exception;

    public IPSSysPortletCat getPSSysPortletCat(String var1) throws Exception;

    public IPSSysPortletCat getPSSysPortletCat(String var1, boolean var2) throws Exception;

    public void resetPSSysPortletCat(String var1) throws Exception;

    public void resetAllPSSysPortletCats();

    public IPSWFWorkTime getPSWFWorkTime(String var1) throws Exception;

    public IPSWFWorkTime getPSWFWorkTime(String var1, boolean var2) throws Exception;

    public void resetPSWFWorkTime(String var1);

    public Iterator<IPSSysSequence> getAllPSSysSequences() throws Exception;

    public IPSSysSequence getPSSysSequence(String var1) throws Exception;

    public IPSSysSequence getPSSysSequence(String var1, boolean var2) throws Exception;

    public void resetPSSysSequence(String var1) throws Exception;

    public void resetAllPSSysSequences();

    public Iterator<IPSSysTranslator> getAllPSSysTranslators() throws Exception;

    public IPSSysTranslator getPSSysTranslator(String var1) throws Exception;

    public IPSSysTranslator getPSSysTranslator(String var1, boolean var2) throws Exception;

    public void resetPSSysTranslator(String var1) throws Exception;

    public void resetAllPSSysTranslators();

    public Iterator<IPSSysMsgQueue> getAllPSSysMsgQueues() throws Exception;

    public IPSSysMsgQueue getPSSysMsgQueue(String var1) throws Exception;

    public IPSSysMsgQueue getPSSysMsgQueue(String var1, boolean var2) throws Exception;

    public void resetPSSysMsgQueue(String var1) throws Exception;

    public void resetAllPSSysMsgQueues();

    public Iterator<IPSSysMsgTarget> getAllPSSysMsgTargets() throws Exception;

    public IPSSysMsgTarget getPSSysMsgTarget(String var1) throws Exception;

    public IPSSysMsgTarget getPSSysMsgTarget(String var1, boolean var2) throws Exception;

    public void resetPSSysMsgTarget(String var1) throws Exception;

    public void resetAllPSSysMsgTargets();

    public Iterator<IPSSysEAIScheme> getAllPSSysEAISchemes() throws Exception;

    public IPSSysEAIScheme getPSSysEAIScheme(String var1) throws Exception;

    public IPSSysEAIScheme getPSSysEAIScheme(String var1, boolean var2) throws Exception;

    public Iterator<IPSSysBIScheme> getAllPSSysBISchemes() throws Exception;

    public IPSSysBIScheme getPSSysBIScheme(String var1) throws Exception;

    public IPSSysBIScheme getPSSysBIScheme(String var1, boolean var2) throws Exception;

    public Iterator<IPSThresholdGroup> getAllPSThresholdGroups() throws Exception;

    public IPSThresholdGroup getPSThresholdGroup(String var1) throws Exception;

    public IPSThresholdGroup getPSThresholdGroup(String var1, boolean var2) throws Exception;

    public Iterator<IPSSysChartTheme> getAllPSSysChartThemes() throws Exception;

    public IPSSysChartTheme getPSSysChartTheme(String var1) throws Exception;

    public IPSSysChartTheme getPSSysChartTheme(String var1, boolean var2) throws Exception;

    public IPSSysChartTheme getDefaultPSSysChartTheme();

    public Iterator<IPSSysContent> getInitPSSysContents() throws Exception;

    public Iterator<IPSSysContent> getSamplePSSysContents() throws Exception;

    public Iterator<IPSSysContent> getTestPSSysContents() throws Exception;

    public boolean isEnableModelRT();

    public String getSysType();

    public String getDeploySysId();

    public String getDeploySysTag();

    public String getDeploySysTag2();

    public String getDeploySysType();

    public String getDeploySysOrgId();

    public String getDeploySysOrgSectorId();

    public String getRTObjectName();

    public boolean isDynaInstMode();

    @Override
    public String getPSDynaInstId();

    public PSDELogic getPSDELogicData(String var1, boolean var2) throws Exception;

    public PSDEUIAction getPSDEUIActionData(String var1, boolean var2) throws Exception;

    public PSCtrlLogicGroup getPSCtrlLogicGroupData(String var1, boolean var2) throws Exception;

    public String getSysTag();

    public String getSysTag2();

    public String getSysTag3();

    public String getSysTag4();

    public Iterator<IPSSysI18N> getAllPSSysI18Ns() throws Exception;

    public IPSSysI18N getDefaultPSSysI18N();

    public Iterator<IPSSysMethodDTO> getAllPSSysMethodDTOs() throws Exception;

    public IPSSysMethodDTO getPSSysMethodDTO(IPSSysDynaModel var1) throws Exception;

    public String getSysMethodDTOCodeName(IPSSysMethodDTO var1) throws Exception;

    public String getDTOCodeNameFormat();

    public String getDefaultScriptEngine();

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);

    public String getAPICodeNameMode();

    public String getAPICodeName(String var1, String var2, String var3);

    public boolean isDTOUseServiceCodeName();

    public boolean isEnablePQL();

    public Iterator<IPSSysAIFactory> getAllPSSysAIFactories() throws Exception;

    public IPSSysAIFactory getPSSysAIFactory(String var1) throws Exception;

    public IPSSysAIFactory getPSSysAIFactory(String var1, boolean var2) throws Exception;
}

