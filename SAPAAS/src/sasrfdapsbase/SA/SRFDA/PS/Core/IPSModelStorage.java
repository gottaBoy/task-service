/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtilType;
import SA.SRFDA.PS.Core.BackService.IPSBackService;
import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Form.IPSFDLogicType;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.IPSFormType;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogicType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCondType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeType;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeType;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionType;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERType;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDRItemType;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQPDCondType;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEJoinType;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionType;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcType;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSDBValueOP;
import SA.SRFDA.PS.Core.Deploy.IPSASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCCluster;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysType;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServerType;
import SA.SRFDA.PS.Core.Deploy.IPSMobAppPackServer;
import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskGlobal;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskGlobal;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.IPSDepSlnPrd;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.Issue.IPSSysIssueEngine;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResMgr.IPSUserMgrAPI;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCondType;
import SA.SRFDA.PS.Core.WF.IPSWFLinkType;
import SA.SRFDA.PS.Core.WF.IPSWFProcessType;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Data.PSDEField;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSModelStorage {
    public boolean isLoaded() throws Exception;

    public String getErrorInfo();

    public IPSSystem getPSSystem(String var1) throws Exception;

    public void resetPSSystem(String var1);

    public IPSModelInit getPSModelInit(String var1, boolean var2) throws Exception;

    public void resetPSModelInit(String var1);

    public IPSDBType getPSDBType(String var1) throws Exception;

    public IPSDBType getPSDBType(String var1, boolean var2) throws Exception;

    public void resetPSDBType(String var1);

    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField var1) throws Exception;

    public IPSDEFieldType getPSDEFieldType(String var1) throws Exception;

    public IPSDEFieldType getPSDEFieldTypeByTag(String var1) throws Exception;

    public void resetAllPSDEFieldTypes();

    public IPSViewType getPSViewType(String var1, boolean var2) throws Exception;

    public IPSViewType getPSViewType(String var1) throws Exception;

    public void resetPSViewType(String var1);

    public IPSControlType getPSControlType(String var1) throws Exception;

    public void resetPSControlType(String var1);

    public IPSPF getPSPF(String var1) throws Exception;

    public IPSPF getPSPF(String var1, boolean var2) throws Exception;

    public void resetPSPF(String var1);

    public IPSDEUIActionType getPSDEUIActionType(String var1) throws Exception;

    public void resetPSDEUIActionType(String var1);

    public IPSDEGridColumnType getPSDEGridColumnType(String var1) throws Exception;

    public void resetPSDEGridColumnType(String var1);

    public IPSDERType getPSDERType(String var1) throws Exception;

    public void resetPSDERType(String var1);

    public IPSToolbarItemType getPSToolbarItemType(String var1) throws Exception;

    public void resetPSToolbarItemType(String var1);

    public IPSFormType getPSFormType(String var1) throws Exception;

    public void resetPSFormType(String var1);

    public IPSFormDetailType getPSFormDetailType(String var1) throws Exception;

    public void resetPSFormDetailType(String var1);

    public IPSAppMenuItemType getPSAppMenuItemType(String var1) throws Exception;

    public void resetPSAppMenuItemType(String var1);

    public IPSDBValueFunc getPSDBValueFunc(String var1) throws Exception;

    public void resetPSDBValueFunc(String var1);

    public IPSDEJoinType getPSDEJoinType(String var1) throws Exception;

    public void resetPSDEJoinType(String var1);

    public IPSDataEntity getPSDataEntity(String var1) throws Exception;

    public IPSDataEntity getPSDataEntity(String var1, boolean var2) throws Exception;

    public IPSSF getPSSF(String var1) throws Exception;

    public IPSSF getPSSF(String var1, boolean var2) throws Exception;

    public void resetPSSF(String var1);

    public IPSDBDevInst getPSDBDevInst(String var1) throws Exception;

    public void resetPSDBDevInst(String var1);

    public void activePSDBDevInst(String var1);

    public IPSDEActionType getPSDEActionType(String var1) throws Exception;

    public void resetPSDEActionType(String var1);

    public IPSViewLogicType getPSViewLogicType(String var1) throws Exception;

    public void resetPSViewLogicType(String var1);

    public IPSDEFValueRuleType getPSDEFValueRuleType(String var1) throws Exception;

    public void resetPSDEFValueRuleType(String var1);

    public IPSDBValueOP getPSDBValueOP(String var1) throws Exception;

    public void resetPSDBValueOP(String var1);

    public IPSDRItemType getPSDRItemType(String var1) throws Exception;

    public void resetPSDRItemType(String var1);

    public IPSDBSysProcType getPSDBSysProcType(String var1) throws Exception;

    public void resetPSDBSysProcType(String var1);

    public IPSEditorType getPSEditorType(String var1) throws Exception;

    public void resetPSEditorType(String var1);

    public void resetAllPSEditorType();

    public IPSFDLogicType getPSFDLogicType(String var1) throws Exception;

    public void resetPSFDLogicType(String var1);

    public IPSDELogicLinkCondType getPSDELogicLinkCondType(String var1) throws Exception;

    public void resetPSDELogicLinkCondType(String var1);

    public IPSDELogicNodeType getPSDELogicNodeType(String var1) throws Exception;

    public void resetPSDELogicNodeType(String var1);

    public IPSDELogicLinkType getPSDELogicLinkType(String var1) throws Exception;

    public void resetPSDELogicLinkType(String var1);

    public IPSWFLinkCondType getPSWFLinkCondType(String var1) throws Exception;

    public void resetPSWFLinkCondType(String var1);

    public IPSWFProcessType getPSWFProcessType(String var1) throws Exception;

    public void resetPSWFProcessType(String var1);

    public IPSWFLinkType getPSWFLinkType(String var1) throws Exception;

    public void resetPSWFLinkType(String var1);

    public IPSPortletType getPSPortletType(String var1) throws Exception;

    public void resetPSPortletType(String var1);

    public IPSDevSlnSys getPSDevSlnSys(String var1) throws Exception;

    public void resetPSDevSlnSys(String var1);

    public IPSDevSlnSys getCachePSDevSlnSys(String var1) throws Exception;

    public IPSSysDevBTType getPSSysDevBTType(String var1) throws Exception;

    public void resetPSSysDevBTType(String var1);

    public PSSysDevBKTaskGlobal getPSSysDevBKTaskGlobal();

    public IPSAppServerType getPSAppServerType(String var1) throws Exception;

    public void resetPSAppServerType(String var1);

    public IPSSubSys getPSSubSys(String var1) throws Exception;

    public void resetPSSubSys(String var1);

    public IPSDEDQPDCondType getPSDEDQPDCondType(String var1) throws Exception;

    public void resetPSDEDQPDCondType(String var1);

    public IPSPFPluginType getPSPFPluginType(String var1) throws Exception;

    public void resetPSPFPluginType(String var1);

    public IPSDETreeNodeType getPSDETreeNodeType(String var1) throws Exception;

    public void resetPSDETreeNodeType(String var1);

    public IPSCounterType getPSCounterType(String var1) throws Exception;

    public void resetPSCounterType(String var1);

    public IPSCounter getPSCounter(String var1) throws Exception;

    public void resetPSCounter(String var1);

    public IPSBackService getPSBackService(String var1) throws Exception;

    public void resetPSBackService(String var1);

    public IPSDepSlnPrd getPSDepSlnPrd(String var1) throws Exception;

    public void resetPSDepSlnPrd(String var1);

    public IPSUserMgrAPI getPSUserMgrAPI();

    public void resetAllPSSysIssueEngines();

    public Iterator<IPSSysIssueEngine> getAllPSSysIssueEngines() throws Exception;

    public IPSAppType getPSAppType(String var1) throws Exception;

    public void resetPSAppType(String var1);

    public IPSDevCenter getPSDevCenter(String var1) throws Exception;

    public void resetPSDevCenter(String var1);

    public IPSModel getPSModel(String var1, boolean var2) throws Exception;

    public void resetPSModel(String var1);

    public IPSDevCenterBTType getPSDevCenterBTType(String var1) throws Exception;

    public void resetPSDevCenterBTType(String var1);

    public PSDevCenterBKTaskGlobal getPSDevCenterBKTaskGlobal();

    public IPSHelpPrjType getPSHelpPrjType(String var1) throws Exception;

    public void resetPSHelpPrjType(String var1);

    public IPSHelpArticleType getPSHelpArticleType(String var1) throws Exception;

    public void resetPSHelpArticleType(String var1);

    public IPSHelpSectionType getPSHelpSectionType(String var1) throws Exception;

    public void resetPSHelpSectionType(String var1);

    public IPSHelpPrjTempl getPSHelpPrjTempl(String var1) throws Exception;

    public void resetPSHelpPrjTempl(String var1);

    public IPSHelpArticleTempl getPSHelpArticleTempl(String var1) throws Exception;

    public void resetPSHelpArticleTempl(String var1);

    public IPSHelpSectionTempl getPSHelpSectionTempl(String var1) throws Exception;

    public void resetPSHelpSectionTempl(String var1);

    public IPSPFCDN getPSPFCDN(String var1) throws Exception;

    public void resetPSPFCDN(String var1);

    public IPSASGroup getPSASGroup(String var1) throws Exception;

    public void resetPSASGroup(String var1);

    public IPSAppServer getPSAppServer(String var1) throws Exception;

    public void resetPSAppServer(String var1);

    public IPSMQInst getPSMQInst(String var1) throws Exception;

    public void resetPSMQInst(String var1);

    public IPSDepSysType getPSDepSysType(String var1) throws Exception;

    public void resetPSDepSysType(String var1);

    public IPSDepSysVer getPSDepSysVer(String var1) throws Exception;

    public void resetPSDepSysVer(String var1);

    public IPSSysEngineConfig getPSSysEngineConfig(String var1) throws Exception;

    public void resetPSSysEngineConfig(String var1);

    public IPSRobot getPSRobot(String var1) throws Exception;

    public void resetPSRobot(String var1);

    public String getPSTaskServerId();

    public IPSRobotWorkType getPSRobotWorkType(String var1, boolean var2) throws Exception;

    public void resetPSRobotWorkType(String var1);

    public void resetAllPSRobotWorkType();

    public IPSGitUser getPSGitUser(String var1) throws Exception;

    public void resetPSGitUser(String var1);

    public IPSTaskServerEnv getPSTaskServerEnv();

    public IPSBookingResType getPSBookingResType(String var1, boolean var2) throws Exception;

    public void resetPSBookingResType(String var1);

    public void resetAllPSBookingResType();

    public IPSDevServerType getPSDevServerType(String var1) throws Exception;

    public void resetPSDevServerType(String var1);

    public IPSMobAppPackServer getPSMobAppPackServer(String var1) throws Exception;

    public void resetPSMobAppPackServer(String var1);

    public IPSDeployServer getPSDeployServer(String var1) throws Exception;

    public void resetPSDeployServer(String var1);

    public IPSViewEngine getPSViewEngine(String var1) throws Exception;

    public void resetPSViewEngine(String var1);

    public IPSSFPluginTempl getPSSFPluginTempl(String var1) throws Exception;

    public IPSSFPluginTempl getPSSFPluginTempl(String var1, boolean var2) throws Exception;

    public void resetPSSFPluginTempl(String var1);

    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    public IPSPFPluginTempl getPSPFPluginTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFPluginTempl(String var1);

    public IPSDCCodeSnippet getPSDCCodeSnippet(String var1) throws Exception;

    public void resetPSDCCodeSnippet(String var1);

    public IPSCodeSnippetType getPSCodeSnippetType(String var1) throws Exception;

    public void resetPSCodeSnippetType(String var1);

    public IPSDeployCenter getPSDeployCenter(String var1) throws Exception;

    public void resetPSDeployCenter(String var1);

    public IPSWorkshopServer getPSWorkshopServer(String var1) throws Exception;

    public void resetPSWorkshopServer(String var1);

    public IPSMSPlatform getPSMSPlatform(String var1) throws Exception;

    public void resetPSMSPlatform(String var1);

    public IPSDevSlnMSDepApp getPSDevSlnMSDepApp(String var1) throws Exception;

    public void resetPSDevSlnMSDepApp(String var1);

    public IPSDevSlnMSDepAPI getPSDevSlnMSDepAPI(String var1) throws Exception;

    public void resetPSDevSlnMSDepAPI(String var1);

    public IPSDCMSPlatform getPSDCMSPlatform(String var1) throws Exception;

    public void resetPSDCMSPlatform(String var1);

    public IPSDCCluster getPSDCCluster(String var1) throws Exception;

    public void resetPSDCCluster(String var1);

    public IPSSVNServer getPSSVNServer(String var1) throws Exception;

    public void resetPSSVNServer(String var1);

    public IPSDBServer getPSDBServer(String var1) throws Exception;

    public void resetPSDBServer(String var1);

    public IPSMavenServer getPSMavenServer(String var1) throws Exception;

    public void resetPSMavenServer(String var1);

    public IPSMavenServerType getPSMavenServerType(String var1) throws Exception;

    public void resetPSMavenServerType(String var1);

    public IPSPanelDetailType getPSPanelDetailType(String var1) throws Exception;

    public void resetPSPanelDetailType(String var1);

    public IPSPanelItemLogicType getPSPanelItemLogicType(String var1) throws Exception;

    public void resetPSPanelItemLogicType(String var1);

    public IPSPanelLogicNodeType getPSPanelLogicNodeType(String var1) throws Exception;

    public void resetPSPanelLogicNodeType(String var1);

    public IPSPanelLogicLinkType getPSPanelLogicLinkType(String var1) throws Exception;

    public void resetPSPanelLogicLinkType(String var1);

    public IPSPanelLogicLinkCondType getPSPanelLogicLinkCondType(String var1) throws Exception;

    public void resetPSPanelLogicLinkCondType(String var1);

    public IPSSysUtilType getPSSysUtilType(String var1) throws Exception;

    public void resetPSSysUtilType(String var1);

    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc(String var1) throws Exception;

    public void resetPSDevSlnMSDepFunc(String var1);

    public IPSUIEngineType getPSUIEngineType(String var1) throws Exception;

    public IPSUIEngineType getPSUIEngineType(String var1, boolean var2) throws Exception;

    public void resetPSUIEngineType(String var1);

    public IPSAppUtilType getPSAppUtilType(String var1) throws Exception;

    public void resetPSAppUtilType(String var1);

    public IPSWorkspaceType getPSWorkspaceType(String var1) throws Exception;

    public IPSWorkspaceType getPSWorkspaceType(String var1, boolean var2) throws Exception;

    public void resetPSWorkspaceType(String var1);

    public IPSDCWorkspace getPSDCWorkspace(String var1) throws Exception;

    public IPSDCWorkspace getPSDCWorkspace(String var1, boolean var2) throws Exception;

    public void resetPSDCWorkspace(String var1);

    public IPSDevSlnSysDynaInst getPSDevSlnSysDynaInst(String var1) throws Exception;

    public void resetPSDevSlnSysDynaInst(String var1);

    public IPSDevSlnSysDynaInst getCachePSDevSlnSysDynaInst(String var1) throws Exception;

    public boolean isCloudMode();
}

