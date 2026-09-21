/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  javax.servlet.ServletContext
 *  net.ibizsys.paas.Version
 *  net.ibizsys.paas.controller.IViewControllerGlobalPlugin
 *  net.ibizsys.paas.controller.ViewControllerGlobal
 *  net.ibizsys.paas.ctrlhandler.CounterGlobal
 *  net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin
 *  net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModelGlobalPlugin
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectFilter
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectFieldFilter
 *  net.ibizsys.paas.db.SelectGroupFilter
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.MySQL5DialectImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListGlobalPlugin
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.sysmodel.ISystemPlugin
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.pscore.srv.PSCoreSysModel
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevSlnSysTS
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerLog
 *  net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDevSlnSysTSService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin
 *  net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl
 *  net.ibizsys.pscore.srv.util.kafka.IPSKafkaPlugin
 *  net.ibizsys.pscore.srv.util.kafka.PSKafkaPluginImpl
 *  net.ibizsys.psrt.srv.PSRuntimeSysModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.cfg.Configuration
 *  org.springframework.web.context.WebApplicationContext
 *  org.springframework.web.context.support.WebApplicationContextUtils
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.App.PSAppTypeGlobalModel;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtilType;
import SA.SRFDA.PS.Core.App.Util.PSAppUtilTypeGlobalModel;
import SA.SRFDA.PS.Core.BackService.IPSBackService;
import SA.SRFDA.PS.Core.BackService.PSBackServiceGlobalModel;
import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.CodeSnippet.PSCodeSnippetTypeGlobalModel;
import SA.SRFDA.PS.Core.CodeSnippet.PSDCCodeSnippetGlobalModel;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.PSCounterGlobalModel;
import SA.SRFDA.PS.Core.Control.Counter.PSCounterTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Form.IPSFDLogicType;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.IPSFormType;
import SA.SRFDA.PS.Core.Control.Form.PSFDLogicTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Form.PSFormDetailTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Form.PSFormTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridColumnTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.PSControlTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.PSEditorTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogicType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCondType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeType;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelDetailTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelItemLogicTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkCondTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicLinkTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelLogicNodeTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.Control.Toolbar.PSToolbarItemTypeGlobalModel;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeType;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeTypeGlobalModel;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.PSDEFieldTypeGlobalModel;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionType;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERType;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDRItemType;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDRItemTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQPDCondType;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEJoinType;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQPDCondTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEJoinTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkCondTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeTypeGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionType;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionTypeGlobalModel;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcType;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSDBValueOP;
import SA.SRFDA.PS.Core.Database.PSDBDevInstGlobal;
import SA.SRFDA.PS.Core.Database.PSDBSysProcTypeGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDBTypeGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDBValueFuncGlobalModel;
import SA.SRFDA.PS.Core.Database.PSDBValueOPGlobalModel;
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
import SA.SRFDA.PS.Core.Deploy.PSASGroupGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSAppServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSAppServerTypeGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDBDevInstGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDBServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDCClusterGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPlatformGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSysTypeGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSysVerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDeployCenterGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDeployServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDevServerTypeGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAPIGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAppGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSGitUserGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSMQInstGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSMSPlatformGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSMavenServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSMavenServerTypeGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSMobAppPackServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSSVNServerGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSWorkshopServerGlobalModel;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskGlobal;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBTTypeGlobalModel;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterGlobalModel;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalInfo;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskGlobal;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBTTypeGlobalModel;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.Help.PSHelpArticleTemplGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpArticleTypeGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpPrjTemplGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpPrjTypeGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTemplGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTypeGlobalModel;
import SA.SRFDA.PS.Core.IPSDepSlnPrd;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.IPSObjectRuntime;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.Issue.IPSSysIssueEngine;
import SA.SRFDA.PS.Core.Issue.PSSysIssueEngineGlobalModel;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITViewControllerGlobalPlugin;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.PSJITCounterGlobalPlugin;
import SA.SRFDA.PS.Core.JIT.CtrlModel.PSJITAppMenuModelGlobalPlugin;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITCodeListGlobalPlugin;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PF.PSPFCDNGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPluginTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFPluginTypeGlobalModel;
import SA.SRFDA.PS.Core.PSDepSlnPrdGlobalModel;
import SA.SRFDA.PS.Core.PSDevSlnSysDynaInstGlobalModel;
import SA.SRFDA.PS.Core.PSDevSlnSysGlobalModel;
import SA.SRFDA.PS.Core.PSModelGlobalModel;
import SA.SRFDA.PS.Core.PSModelInitGlobalModel;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSysEngineConfigGlobalModel;
import SA.SRFDA.PS.Core.PSSystemGlobalModel;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.Res.PSPortletTypeGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysUtilTypeGlobalModel;
import SA.SRFDA.PS.Core.Res.PSUIEngineTypeGlobalModel;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResBooking.PSASBookingDispatcher;
import SA.SRFDA.PS.Core.ResBooking.PSBookingResTypeGlobalModel;
import SA.SRFDA.PS.Core.ResBooking.PSDSBookingDispatcher;
import SA.SRFDA.PS.Core.ResBooking.PSWorkspaceBookingDispatcher;
import SA.SRFDA.PS.Core.ResMgr.IPSUserMgrAPI;
import SA.SRFDA.PS.Core.ResMgr.PSPFPreviewNodeGlobal;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotGlobalModel;
import SA.SRFDA.PS.Core.Robot.PSRobotWorkTypeGlobalModel;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFPluginTemplGlobalModel;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModel;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysHelper;
import SA.SRFDA.PS.Core.Util.PSModelSchemeHelper;
import SA.SRFDA.PS.Core.Util.ThreadLockChecker;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.PSViewEngineGlobalModel;
import SA.SRFDA.PS.Core.View.PSViewLogicTypeGlobalModel;
import SA.SRFDA.PS.Core.View.PSViewTypeGlobalModel;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCondType;
import SA.SRFDA.PS.Core.WF.IPSWFLinkType;
import SA.SRFDA.PS.Core.WF.IPSWFProcessType;
import SA.SRFDA.PS.Core.WF.PSWFLinkCondTypeGlobalModel;
import SA.SRFDA.PS.Core.WF.PSWFLinkTypeGlobalModel;
import SA.SRFDA.PS.Core.WF.PSWFProcessTypeGlobalModel;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Core.Workspace.PSDCWorkspaceGlobalModel;
import SA.SRFDA.PS.Core.Workspace.PSWorkspaceTypeGlobalModel;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.PSDAModels;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSysModelInst;
import SA.SRFDA.PS.Data.PSTaskServer;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContext;
import net.ibizsys.paas.controller.IViewControllerGlobalPlugin;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.ICounterGlobalPlugin;
import net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModelGlobalPlugin;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.MySQL5DialectImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListGlobalPlugin;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevSlnSysTS;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevSlnSysTSService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import net.ibizsys.pscore.srv.util.kafka.IPSKafkaPlugin;
import net.ibizsys.pscore.srv.util.kafka.PSKafkaPluginImpl;
import net.ibizsys.psrt.srv.PSRuntimeSysModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class PSModelStorageImpl
implements IPSModelStorage {
    private static final Log log = LogFactory.getLog(PSModelStorageImpl.class);
    private final PSDEFieldTypeGlobalModel psDEFieldTypeGlobalModel = new PSDEFieldTypeGlobalModel();
    private final PSSystemGlobalModel psSystemGlobalModel = new PSSystemGlobalModel();
    private final PSModelInitGlobalModel psModelInitGlobalModel = new PSModelInitGlobalModel();
    private final PSDBTypeGlobalModel psDBTypeGlobalModel = new PSDBTypeGlobalModel();
    private final PSViewTypeGlobalModel psViewTypeGlobalModel = new PSViewTypeGlobalModel();
    private final PSViewEngineGlobalModel psViewEngineGlobalModel = new PSViewEngineGlobalModel();
    private final PSViewLogicTypeGlobalModel psViewLogicTypeGlobalModel = new PSViewLogicTypeGlobalModel();
    private final PSControlTypeGlobalModel psControlTypeGlobalModel = new PSControlTypeGlobalModel();
    private final PSAppTypeGlobalModel psAppTypeGlobalModel = new PSAppTypeGlobalModel();
    private final PSPFCDNGlobalModel psPFCDNGlobalModel = new PSPFCDNGlobalModel();
    private final PSPFGlobalModel psPFGlobalModel = new PSPFGlobalModel();
    private final PSDEUIActionTypeGlobalModel psDEUIActionTypeGlobalModel = new PSDEUIActionTypeGlobalModel();
    private final PSDEGridColumnTypeGlobalModel psDEGridColumnTypeGlobalModel = new PSDEGridColumnTypeGlobalModel();
    private final PSDERTypeGlobalModel psDERTypeGlobalModel = new PSDERTypeGlobalModel();
    private final PSToolbarItemTypeGlobalModel psToolbarItemTypeGlobalModel = new PSToolbarItemTypeGlobalModel();
    private final PSAppMenuItemTypeGlobalModel psAppMenuItemTypeGlobalModel = new PSAppMenuItemTypeGlobalModel();
    private final PSFormTypeGlobalModel psFormTypeGlobalModel = new PSFormTypeGlobalModel();
    private final PSFormDetailTypeGlobalModel psFormDetailTypeGlobalModel = new PSFormDetailTypeGlobalModel();
    private final PSFDLogicTypeGlobalModel psFDLogicTypeGlobalModel = new PSFDLogicTypeGlobalModel();
    private final PSDBValueFuncGlobalModel psDBValueFuncGlobalModel = new PSDBValueFuncGlobalModel();
    private final PSDEJoinTypeGlobalModel psDEJoinTypeGlobalModel = new PSDEJoinTypeGlobalModel();
    private final PSSFGlobalModel psSFGlobalModel = new PSSFGlobalModel();
    private final PSDBDevInstGlobalModel psDBDevInstGlobalModel = new PSDBDevInstGlobalModel();
    private final PSAppServerGlobalModel psAppServerGlobalModel = new PSAppServerGlobalModel();
    private final PSDBServerGlobalModel psDBServerGlobalModel = new PSDBServerGlobalModel();
    private final PSMobAppPackServerGlobalModel psMobAppPackServerGlobalModel = new PSMobAppPackServerGlobalModel();
    private final PSMQInstGlobalModel psMQInstGlobalModel = new PSMQInstGlobalModel();
    private final PSASGroupGlobalModel psASGroupGlobalModel = new PSASGroupGlobalModel();
    private final PSDEActionTypeGlobalModel psDEActionTypeGlobalModel = new PSDEActionTypeGlobalModel();
    private final PSDEFValueRuleTypeGlobalModel psDEFValueRuleTypeGlobalModel = new PSDEFValueRuleTypeGlobalModel();
    private final PSDBValueOPGlobalModel psDBValueOPGlobalModel = new PSDBValueOPGlobalModel();
    private final PSDRItemTypeGlobalModel psDRItemTypeGlobalModel = new PSDRItemTypeGlobalModel();
    private final PSDBSysProcTypeGlobalModel psDBSysProcTypeGlobalModel = new PSDBSysProcTypeGlobalModel();
    private final PSEditorTypeGlobalModel psEditorTypeGlobalModel = new PSEditorTypeGlobalModel();
    private final PSDELogicLinkCondTypeGlobalModel psDELogicLinkCondTypeGlobalModel = new PSDELogicLinkCondTypeGlobalModel();
    private final PSDELogicLinkTypeGlobalModel psDELogicLinkTypeGlobalModel = new PSDELogicLinkTypeGlobalModel();
    private final PSDELogicNodeTypeGlobalModel psDELogicNodeTypeGlobalModel = new PSDELogicNodeTypeGlobalModel();
    private final PSWFLinkCondTypeGlobalModel psWFLinkCondTypeGlobalModel = new PSWFLinkCondTypeGlobalModel();
    private final PSWFLinkTypeGlobalModel psWFLinkTypeGlobalModel = new PSWFLinkTypeGlobalModel();
    private final PSWFProcessTypeGlobalModel psWFProcessTypeGlobalModel = new PSWFProcessTypeGlobalModel();
    private final PSPortletTypeGlobalModel psPortletTypeGlobalModel = new PSPortletTypeGlobalModel();
    private final HashMap<String, PSDevSlnSysGlobalModel> psDevSlnSysGlobalModelMap = new HashMap();
    private final HashMap<String, PSDevSlnSysDynaInstGlobalModel> psDevSlnSysDynaInstGlobalModelMap = new HashMap();
    private final PSSysDevBTTypeGlobalModel psSysDevBTTypeGlobalModel = new PSSysDevBTTypeGlobalModel();
    private final PSAppServerTypeGlobalModel psAppServerTypeGlobalModel = new PSAppServerTypeGlobalModel();
    private final PSMavenServerTypeGlobalModel psMavenServerTypeGlobalModel = new PSMavenServerTypeGlobalModel();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected PSCoreSysModel psCoreSysModel = null;
    private final PSSysDevBKTaskGlobal psSysDevBKTaskGlobal = new PSSysDevBKTaskGlobal();
    private final PSSubSysGlobalModel psSubSysGlobalModel = new PSSubSysGlobalModel();
    private final PSDEDQPDCondTypeGlobalModel psDEDQPDCondTypeGlobalModel = new PSDEDQPDCondTypeGlobalModel();
    private final PSPFPluginTypeGlobalModel psPFPluginTypeGlobalModel = new PSPFPluginTypeGlobalModel();
    private final PSDETreeNodeTypeGlobalModel psDETreeNodeTypeGlobalModel = new PSDETreeNodeTypeGlobalModel();
    private final PSCounterTypeGlobalModel psCounterTypeGlobalModel = new PSCounterTypeGlobalModel();
    private final PSCounterGlobalModel psCounterGlobalModel = new PSCounterGlobalModel();
    private final PSBackServiceGlobalModel psBackServiceGlobalModel = new PSBackServiceGlobalModel();
    private final PSDepSlnPrdGlobalModel psDepSlnPrdGlobalModel = new PSDepSlnPrdGlobalModel();
    private final PSSysIssueEngineGlobalModel psSysIssueEngineGlobalModel = new PSSysIssueEngineGlobalModel();
    private final PSDevCenterGlobalModel psDevCenterGlobalModel = new PSDevCenterGlobalModel();
    private final PSModelGlobalModel psModelGlobalModel = new PSModelGlobalModel();
    private final PSDevCenterBTTypeGlobalModel psDevCenterBTTypeGlobalModel = new PSDevCenterBTTypeGlobalModel();
    private final PSDevCenterBKTaskGlobal psDevCenterBKTaskGlobal = new PSDevCenterBKTaskGlobal();
    private final PSRobotWorkTypeGlobalModel psRobotWorkTypeGlobalModel = new PSRobotWorkTypeGlobalModel();
    private final PSBookingResTypeGlobalModel psBookingResTypeGlobalModel = new PSBookingResTypeGlobalModel();
    private final PSDeployServerGlobalModel psDeployServerGlobalModel = new PSDeployServerGlobalModel();
    private final PSSFPluginTemplGlobalModel psSFPluginTemplGlobalModel = new PSSFPluginTemplGlobalModel();
    private final PSPFPluginTemplGlobalModel psPFPluginTemplGlobalModel = new PSPFPluginTemplGlobalModel();
    private final PSDCCodeSnippetGlobalModel psDCCodeSnippetGlobalModel = new PSDCCodeSnippetGlobalModel();
    private final PSCodeSnippetTypeGlobalModel psCodeSnippetTypeGlobalModel = new PSCodeSnippetTypeGlobalModel();
    private final PSDeployCenterGlobalModel psDeployCenterGlobalModel = new PSDeployCenterGlobalModel();
    private final PSWorkshopServerGlobalModel psWorkshopServerGlobalModel = new PSWorkshopServerGlobalModel();
    private final PSMSPlatformGlobalModel psMSPlatformGlobalModel = new PSMSPlatformGlobalModel();
    private final PSDevSlnMSDepAppGlobalModel psDevSlnMSDepAppGlobalModel = new PSDevSlnMSDepAppGlobalModel();
    private final PSDevSlnMSDepAPIGlobalModel psDevSlnMSDepAPIGlobalModel = new PSDevSlnMSDepAPIGlobalModel();
    private final PSDevSlnMSDepFuncGlobalModel psDevSlnMSDepFuncGlobalModel = new PSDevSlnMSDepFuncGlobalModel();
    private final PSDCMSPlatformGlobalModel psDCMSPlatformGlobalModel = new PSDCMSPlatformGlobalModel();
    private final PSSVNServerGlobalModel psSVNServerGlobalModel = new PSSVNServerGlobalModel();
    private final PSMavenServerGlobalModel psMavenServerGlobalModel = new PSMavenServerGlobalModel();
    private final PSPanelDetailTypeGlobalModel psPanelDetailTypeGlobalModel = new PSPanelDetailTypeGlobalModel();
    private final PSPanelItemLogicTypeGlobalModel psPanelItemLogicTypeGlobalModel = new PSPanelItemLogicTypeGlobalModel();
    private final PSPanelLogicLinkCondTypeGlobalModel psPanelLogicLinkCondTypeGlobalModel = new PSPanelLogicLinkCondTypeGlobalModel();
    private final PSSysUtilTypeGlobalModel psSysUtilTypeGlobalModel = new PSSysUtilTypeGlobalModel();
    private final PSUIEngineTypeGlobalModel psUIEngineTypeGlobalModel = new PSUIEngineTypeGlobalModel();
    private final PSAppUtilTypeGlobalModel psAppUtilTypeGlobalModel = new PSAppUtilTypeGlobalModel();
    private final PSWorkspaceTypeGlobalModel psWorkspaceTypeGlobalModel = new PSWorkspaceTypeGlobalModel();
    private final PSDCWorkspaceGlobalModel psDCWorkspaceGlobalModel = new PSDCWorkspaceGlobalModel();
    private final PSDCClusterGlobalModel psDCClusterGlobalModel = new PSDCClusterGlobalModel();
    private IPSUserMgrAPI iPSUserMgrAPI = null;
    private String strPSTaskServerId = null;
    private boolean bLoaded = false;
    private net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer psTaskServer = null;
    private ScheduledExecutorService scheduledThreadPool = null;
    private ScheduledExecutorService scheduledThreadPool2 = null;
    private ScheduledExecutorService scheduledThreadPool3 = null;
    private int nTaskSessionCount = 4;
    private int nDCTaskSessionCount = 10;
    private final PSJITCodeListGlobalPlugin psJITCodeListGlobalPlugin = new PSJITCodeListGlobalPlugin();
    private final PSJITViewControllerGlobalPlugin psJITViewControllerGlobalPlugin = new PSJITViewControllerGlobalPlugin();
    private final PSJITCounterGlobalPlugin psJITCounterGlobalPlugin = new PSJITCounterGlobalPlugin();
    private final PSJITAppMenuModelGlobalPlugin psJITAppMenuModelGlobalPlugin = new PSJITAppMenuModelGlobalPlugin();
    private final PSHelpArticleTypeGlobalModel psHelpArticleTypeGlobalModel = new PSHelpArticleTypeGlobalModel();
    private final PSHelpSectionTypeGlobalModel psHelpSectionTypeGlobalModel = new PSHelpSectionTypeGlobalModel();
    private final PSHelpPrjTypeGlobalModel psHelpPrjTypeGlobalModel = new PSHelpPrjTypeGlobalModel();
    private final PSHelpArticleTemplGlobalModel psHelpArticleTemplGlobalModel = new PSHelpArticleTemplGlobalModel();
    private final PSHelpSectionTemplGlobalModel psHelpSectionTemplGlobalModel = new PSHelpSectionTemplGlobalModel();
    private final PSHelpPrjTemplGlobalModel psHelpPrjTemplGlobalModel = new PSHelpPrjTemplGlobalModel();
    private final PSDepSysTypeGlobalModel psDepSysTypeGlobalModel = new PSDepSysTypeGlobalModel();
    private final PSSysEngineConfigGlobalModel psSysEngineConfigGlobalModel = new PSSysEngineConfigGlobalModel();
    private final HashMap<String, PSDepSysVerGlobalModel> psDepSysVerGlobalModelMap = new HashMap();
    private final PSRobotGlobalModel psRobotGlobalModel = new PSRobotGlobalModel();
    private final PSGitUserGlobalModel psGitUserGlobalModel = new PSGitUserGlobalModel();
    private final PSDevServerTypeGlobalModel psDevServerTypeGlobalModel = new PSDevServerTypeGlobalModel();
    private final PSPanelLogicLinkTypeGlobalModel psPanelLogicLinkTypeGlobalModel = new PSPanelLogicLinkTypeGlobalModel();
    private final PSPanelLogicNodeTypeGlobalModel psPanelLogicNodeTypeGlobalModel = new PSPanelLogicNodeTypeGlobalModel();
    private String[] plugins = null;
    private IPSTaskServerEnv iPSTaskServerEnv = null;
    private PSTaskServerLogService psTaskServerLogService = null;
    private int nPSDevSlnSysExpiredTime = 60000;
    private int nPSDevSlnSysDynaInstExpiredTime = 60000;
    private PSASBookingDispatcher psASBookingDispatcher = null;
    private PSDSBookingDispatcher psDSBookingDispatcher = null;
    private PSWorkspaceBookingDispatcher psWSBookingDispatcher = null;
    private long nLastLogTime = 0L;
    private String lock_psDevSlnSysGlobalModelMap = null;
    private String lock_psDevSlnSysDynaInstGlobalModelMap = null;
    private PSPFPreviewNodeGlobal psPFPreviewNodeGlobal = new PSPFPreviewNodeGlobal();
    private int nGlobalConfigVer = -1;
    private static Random random = new Random();
    private String strErrorInfo = null;
    private boolean bAPIOnly = false;
    private boolean bCloudMode = false;
    private String strInitDataFolder = "";
    private String strSqlFolder = "";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        try {
            String strPlugins;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.nLastLogTime = System.currentTimeMillis();
            log.info((Object)StringHelper.Format((String)"\u4efb\u52a1\u670d\u52a1\u5668\u5f00\u59cb\u542f\u52a8\uff0cbase[%1$s],studio[%2$s]", (Object)net.ibizsys.paas.Version.toVersionString(), (Object)Version.toVersionString2()));
            this.strPSTaskServerId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKSERVERID", "LITE");
            if (StringHelper.IsNullOrEmpty((String)this.strPSTaskServerId)) {
                this.strPSTaskServerId = "LITE";
            }
            boolean bl = this.bCloudMode = this.strPSTaskServerId.indexOf("LITE") == 0 || this.strPSTaskServerId.indexOf("CLOUD") == 0;
            if (this.bCloudMode) {
                PSObjectFactory.setUseDAOOnly(true);
            }
            this.bAPIOnly = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "APIONLY", this.isCloudMode());
            this.strInitDataFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "INITDATAFOLDER", "");
            this.strSqlFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "SQLFOLDER", "");
            PSCoreEntityKeeperGlobal.initAll();
            this.lock_psDevSlnSysGlobalModelMap = StringHelper.Format((String)"psDevSlnSysGlobalModelMap@%1$s", (Object)this);
            this.lock_psDevSlnSysDynaInstGlobalModelMap = StringHelper.Format((String)"psDevSlnSysDynaInstGlobalModelMap@%1$s", (Object)this);
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    log.error((Object)"\u5168\u5c40\u7ebf\u7a0b\u5f02\u5e38", e);
                    if (e instanceof OutOfMemoryError && PSTaskServerEnvImpl.getCurrent() != null) {
                        PSTaskServerEnvImpl.getCurrent().restart(e);
                    }
                }
            });
            CodeListGlobal.setPlugin((ICodeListGlobalPlugin)this.psJITCodeListGlobalPlugin);
            ViewControllerGlobal.setPlugin((IViewControllerGlobalPlugin)this.psJITViewControllerGlobalPlugin);
            CounterGlobal.setPlugin((ICounterGlobalPlugin)this.psJITCounterGlobalPlugin);
            AppMenuModelGlobal.setPlugin((IAppMenuModelGlobalPlugin)this.psJITAppMenuModelGlobalPlugin);
            this.nTaskSessionCount = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKSESSIONCOUNT", this.nTaskSessionCount);
            if (this.nTaskSessionCount <= 0) {
                this.nTaskSessionCount = 4;
            }
            if (this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "MODELINSTPROXYMODE", false)) {
                PSSysModelInstGlobal.setEnableProxyMode((boolean)true);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strPlugins = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PLUGINS", "")))) {
                this.plugins = strPlugins.split("[;]");
            }
            this.psDBTypeGlobalModel.Init(iDAGlobalHelper);
            this.psModelGlobalModel.Init(iDAGlobalHelper);
            this.prepareV5Lib();
            this.preparePSTaskServerEnv();
            this.psPFPreviewNodeGlobal.init(this.strPSTaskServerId);
            PSPFPreviewNodeGlobal.setCurrent(this.psPFPreviewNodeGlobal);
            this.psRobotWorkTypeGlobalModel.Init(iDAGlobalHelper);
            this.psBookingResTypeGlobalModel.Init(iDAGlobalHelper);
            this.psRobotGlobalModel.Init(iDAGlobalHelper);
            this.psDevCenterGlobalModel.Init(iDAGlobalHelper);
            this.psGitUserGlobalModel.Init(iDAGlobalHelper);
            this.prepareUserMgrAPI();
            this.psMavenServerGlobalModel.Init(iDAGlobalHelper);
            this.psSVNServerGlobalModel.Init(iDAGlobalHelper);
            this.psSysEngineConfigGlobalModel.Init(iDAGlobalHelper);
            this.psAppTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPFCDNGlobalModel.Init(iDAGlobalHelper);
            this.psPFGlobalModel.Init(iDAGlobalHelper);
            this.psSFGlobalModel.Init(iDAGlobalHelper);
            this.psSFPluginTemplGlobalModel.Init(iDAGlobalHelper);
            this.psPFPluginTemplGlobalModel.Init(iDAGlobalHelper);
            this.psSysDevBTTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDevCenterBTTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDepSysTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDEDQPDCondTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDEFieldTypeGlobalModel.Init(iDAGlobalHelper);
            this.psSysIssueEngineGlobalModel.Init(iDAGlobalHelper);
            this.psViewTypeGlobalModel.Init(iDAGlobalHelper);
            this.psViewEngineGlobalModel.Init(iDAGlobalHelper);
            this.psControlTypeGlobalModel.Init(iDAGlobalHelper);
            this.psHelpArticleTemplGlobalModel.Init(iDAGlobalHelper);
            this.psHelpSectionTemplGlobalModel.Init(iDAGlobalHelper);
            this.psHelpPrjTemplGlobalModel.Init(iDAGlobalHelper);
            this.psHelpArticleTypeGlobalModel.Init(iDAGlobalHelper);
            this.psHelpSectionTypeGlobalModel.Init(iDAGlobalHelper);
            this.psHelpPrjTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDepSlnPrdGlobalModel.Init(iDAGlobalHelper);
            this.psDEGridColumnTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDETreeNodeTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPFPluginTypeGlobalModel.Init(iDAGlobalHelper);
            this.psBackServiceGlobalModel.Init(iDAGlobalHelper);
            this.psSystemGlobalModel.Init(iDAGlobalHelper);
            this.psSubSysGlobalModel.Init(iDAGlobalHelper);
            this.psModelInitGlobalModel.Init(iDAGlobalHelper);
            this.psCounterTypeGlobalModel.Init(iDAGlobalHelper);
            this.psCounterGlobalModel.Init(iDAGlobalHelper);
            this.psDEUIActionTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDELogicLinkTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDELogicNodeTypeGlobalModel.Init(iDAGlobalHelper);
            this.psUIEngineTypeGlobalModel.Init(iDAGlobalHelper);
            this.psSysUtilTypeGlobalModel.Init(iDAGlobalHelper);
            this.psAppUtilTypeGlobalModel.Init(iDAGlobalHelper);
            this.psWFLinkCondTypeGlobalModel.Init(iDAGlobalHelper);
            this.psWFLinkTypeGlobalModel.Init(iDAGlobalHelper);
            this.psWFProcessTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPortletTypeGlobalModel.Init(iDAGlobalHelper);
            this.psAppServerTypeGlobalModel.Init(iDAGlobalHelper);
            this.psMavenServerTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDevServerTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDERTypeGlobalModel.Init(iDAGlobalHelper);
            this.psToolbarItemTypeGlobalModel.Init(iDAGlobalHelper);
            this.psFormTypeGlobalModel.Init(iDAGlobalHelper);
            this.psFDLogicTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPanelItemLogicTypeGlobalModel.Init(iDAGlobalHelper);
            this.psFormDetailTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPanelDetailTypeGlobalModel.Init(iDAGlobalHelper);
            this.psAppMenuItemTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDBValueFuncGlobalModel.Init(iDAGlobalHelper);
            this.psDEJoinTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDBDevInstGlobalModel.Init(iDAGlobalHelper);
            this.psMobAppPackServerGlobalModel.Init(iDAGlobalHelper);
            this.psDeployServerGlobalModel.Init(iDAGlobalHelper);
            this.psWorkshopServerGlobalModel.Init(iDAGlobalHelper);
            this.psDeployCenterGlobalModel.Init(iDAGlobalHelper);
            this.psAppServerGlobalModel.Init(iDAGlobalHelper);
            this.psDBServerGlobalModel.Init(iDAGlobalHelper);
            this.psMQInstGlobalModel.Init(iDAGlobalHelper);
            this.psASGroupGlobalModel.Init(iDAGlobalHelper);
            this.psDEActionTypeGlobalModel.Init(iDAGlobalHelper);
            this.psViewLogicTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDEFValueRuleTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDBValueOPGlobalModel.Init(iDAGlobalHelper);
            this.psDRItemTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDBSysProcTypeGlobalModel.Init(iDAGlobalHelper);
            this.psEditorTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDELogicLinkCondTypeGlobalModel.Init(iDAGlobalHelper);
            this.psCodeSnippetTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDCCodeSnippetGlobalModel.Init(iDAGlobalHelper);
            this.psMSPlatformGlobalModel.Init(iDAGlobalHelper);
            this.psDCMSPlatformGlobalModel.Init(iDAGlobalHelper);
            this.psDevSlnMSDepAppGlobalModel.Init(iDAGlobalHelper);
            this.psDevSlnMSDepAPIGlobalModel.Init(iDAGlobalHelper);
            this.psDevSlnMSDepFuncGlobalModel.Init(iDAGlobalHelper);
            this.psPanelLogicLinkTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPanelLogicNodeTypeGlobalModel.Init(iDAGlobalHelper);
            this.psPanelLogicLinkCondTypeGlobalModel.Init(iDAGlobalHelper);
            this.psWorkspaceTypeGlobalModel.Init(iDAGlobalHelper);
            this.psDCWorkspaceGlobalModel.Init(iDAGlobalHelper);
            this.psDCClusterGlobalModel.Init(iDAGlobalHelper);
            this.isCloudMode();
            this.nPSDevSlnSysExpiredTime = this.getPSTaskServerEnv().getDevSlnSysExpiredTime();
            ThreadLockChecker.getInstance().setEnabled(this.getPSTaskServerEnv().isEnableThreadLockCheck());
            this.psSysDevBKTaskGlobal.init(iDAGlobalHelper, this.nTaskSessionCount, this.nPSDevSlnSysExpiredTime);
            this.psDevCenterBKTaskGlobal.init(iDAGlobalHelper, this.nDCTaskSessionCount, this.nPSDevSlnSysExpiredTime + 600000);
            this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

                @Override
                public void run() {
                    PSModelStorageImpl.this.logModelStorageInfo();
                }
            }, 30L, 60L, TimeUnit.SECONDS);
            this.scheduledThreadPool2 = Executors.newScheduledThreadPool(1);
            this.scheduledThreadPool2.scheduleAtFixedRate(new Runnable(){

                @Override
                public void run() {
                    PSModelStorageImpl.this.clearModelStorage();
                    PSModelStorageImpl.this.offlinePSDevSlnSys();
                }
            }, 60L, 60L, TimeUnit.SECONDS);
            this.scheduledThreadPool3 = Executors.newScheduledThreadPool(1);
            this.scheduledThreadPool3.scheduleAtFixedRate(new Runnable(){

                @Override
                public void run() {
                    PSModelStorageImpl.this.checkThreadLock();
                }
            }, 45L, 45L, TimeUnit.SECONDS);
            if (this.getPSTaskServerEnv().isStartASBookingDisp()) {
                this.psASBookingDispatcher = new PSASBookingDispatcher();
                this.psASBookingDispatcher.init(this.iDAGlobalHelper);
                this.psASBookingDispatcher.start();
            }
            if (this.getPSTaskServerEnv().isStartDSBookingDisp()) {
                this.psDSBookingDispatcher = new PSDSBookingDispatcher();
                this.psDSBookingDispatcher.init(this.iDAGlobalHelper);
                this.psDSBookingDispatcher.start();
            }
            if (this.getPSTaskServerEnv().isStartWSBookingDisp()) {
                this.psWSBookingDispatcher = new PSWorkspaceBookingDispatcher();
                this.psWSBookingDispatcher.init(this.iDAGlobalHelper);
                this.psWSBookingDispatcher.start();
            }
            for (String strDEId : PSDAModels.deNameMap.keySet()) {
                this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            }
            log.info((Object)StringHelper.Format((String)StringHelper.Format((String)"\u4efb\u52a1\u670d\u52a1\u5668[%1$s]\u542f\u52a8\u5b8c\u6210", (Object)(this.psTaskServer == null ? "\u672a\u77e5" : this.psTaskServer.getPSTaskServerName()))));
            this.bLoaded = true;
        }
        catch (Exception ex) {
            this.strErrorInfo = StringHelper.Format((String)StringHelper.Format((String)"\u6a21\u578b\u4f5c\u4e1a\u5bb9\u5668\u542f\u52a8\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
            String strErrorInfo2 = StringHelper.Format((String)StringHelper.Format((String)"\u4efb\u52a1\u670d\u52a1\u5668[%1$s]\u542f\u52a8\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)(this.psTaskServer == null ? "\u672a\u77e5" : this.psTaskServer.getPSTaskServerName()), (Object)ex.getMessage()));
            log.error((Object)strErrorInfo2, (Throwable)ex);
            this.bLoaded = true;
        }
    }

    public boolean isAPIOnly() {
        return this.bAPIOnly;
    }

    @Override
    public final boolean isCloudMode() {
        return this.bCloudMode;
    }

    @Override
    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    protected final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null);
    }

    protected void prepareUserMgrAPI() throws Exception {
        String strUserMgrObj = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "USERMGRAPI", "");
        if (StringHelper.IsNullOrEmpty((String)strUserMgrObj)) {
            return;
        }
        this.iPSUserMgrAPI = (IPSUserMgrAPI)ObjectHelper.Create((String)strUserMgrObj);
    }

    @Override
    public IPSSystem getPSSystem(String strPSSystemId) throws Exception {
        if (!this.isLoaded()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u7cfb\u7edf\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5!"));
        }
        return (IPSSystem)this.psSystemGlobalModel.FindModelHelper(strPSSystemId);
    }

    @Override
    public void resetPSSystem(String strPSSystemId) {
        this.psSystemGlobalModel.ResetModel(strPSSystemId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDevSlnSys getPSDevSlnSys(String strPSDevSlnSysId) throws Exception {
        if (!this.isLoaded()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u7cfb\u7edf\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5!"));
        }
        PSDevSlnSysGlobalModel psDevSlnSysGlobalModel = this.psDevSlnSysGlobalModelMap.get(strPSDevSlnSysId);
        if (psDevSlnSysGlobalModel == null) {
            psDevSlnSysGlobalModel = new PSDevSlnSysGlobalModel();
            psDevSlnSysGlobalModel.Init(this.iDAGlobalHelper);
            this.waitLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            HashMap<String, PSDevSlnSysGlobalModel> hashMap = this.psDevSlnSysGlobalModelMap;
            synchronized (hashMap) {
                this.enterLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
                PSDevSlnSysGlobalModel psDevSlnSysGlobalModel2 = this.psDevSlnSysGlobalModelMap.get(strPSDevSlnSysId);
                if (psDevSlnSysGlobalModel2 == null) {
                    this.psDevSlnSysGlobalModelMap.put(strPSDevSlnSysId, psDevSlnSysGlobalModel);
                } else {
                    psDevSlnSysGlobalModel = psDevSlnSysGlobalModel2;
                }
                this.leaveLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            }
        }
        boolean bExists = psDevSlnSysGlobalModel.containsModel(strPSDevSlnSysId);
        final IPSDevSlnSys iPSDevSlnSys = (IPSDevSlnSys)psDevSlnSysGlobalModel.FindModelHelper(strPSDevSlnSysId);
        if (!bExists && iPSDevSlnSys != null) {
            try {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                    @Override
                    public void execute(Object obj) throws Exception {
                        PSDevSlnSysTS psDevSlnSysTS = new PSDevSlnSysTS();
                        psDevSlnSysTS.setPSDevSlnSysId(iPSDevSlnSys.getId());
                        psDevSlnSysTS.setPSDevSlnSysName(iPSDevSlnSys.getName());
                        psDevSlnSysTS.setPSTaskServerId(PSModelStorageImpl.this.getPSTaskServerEnv().getId());
                        psDevSlnSysTS.setPSTaskServerName(PSModelStorageImpl.this.getPSTaskServerEnv().getName());
                        psDevSlnSysTS.setLoadTime(new Timestamp(new Date().getTime()));
                        psDevSlnSysTS.setPSDevSlnSysTSName("\u7cfb\u7edf\u52a0\u8f7d\u65e5\u5fd7");
                        PSDevSlnSysTSService psDevSlnSysTSService = (PSDevSlnSysTSService)ServiceGlobal.getService(PSDevSlnSysTSService.class);
                        psDevSlnSysTSService.create((IEntity)psDevSlnSysTS);
                        ((IPSObjectRuntime)((Object)iPSDevSlnSys)).setRTAttribute("PSDEVSLNSYSTS", psDevSlnSysTS);
                    }
                });
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf\u52a0\u8f7d\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        return iPSDevSlnSys;
    }

    @Override
    public IPSDevSlnSys getCachePSDevSlnSys(String strPSDevSlnSysId) throws Exception {
        if (!this.isLoaded()) {
            return null;
        }
        PSDevSlnSysGlobalModel psDevSlnSysGlobalModel = this.psDevSlnSysGlobalModelMap.get(strPSDevSlnSysId);
        if (psDevSlnSysGlobalModel == null) {
            return null;
        }
        boolean bExists = psDevSlnSysGlobalModel.containsModel(strPSDevSlnSysId);
        if (!bExists) {
            return null;
        }
        IPSDevSlnSys iPSDevSlnSys = (IPSDevSlnSys)psDevSlnSysGlobalModel.FindModelHelper(strPSDevSlnSysId);
        return iPSDevSlnSys;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDevSlnSys(String strPSDevSlnSysId) {
        PSDevSlnSysTS lastPSDevSlnSysTS = null;
        try {
            IPSDevSlnSys iPSDevSlnSys = this.getCachePSDevSlnSys(strPSDevSlnSysId);
            if (iPSDevSlnSys != null) {
                lastPSDevSlnSysTS = (PSDevSlnSysTS)((IPSObjectRuntime)((Object)iPSDevSlnSys)).getRTAttribute("PSDEVSLNSYSTS");
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7f13\u5b58\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDevSlnSysId, (Object)ex.getMessage()), (Throwable)ex);
        }
        PSDevSlnSysGlobalModel psDevSlnSysGlobalModel = null;
        this.waitLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSDevSlnSysGlobalModel> hashMap = this.psDevSlnSysGlobalModelMap;
        synchronized (hashMap) {
            psDevSlnSysGlobalModel = this.psDevSlnSysGlobalModelMap.remove(strPSDevSlnSysId);
            this.enterAndLeaveLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
        }
        if (psDevSlnSysGlobalModel == null) {
            return;
        }
        psDevSlnSysGlobalModel.ResetModel(strPSDevSlnSysId);
        psDevSlnSysGlobalModel.clearGlobalModel();
        if (lastPSDevSlnSysTS != null) {
            final String strPSDevSlnSysTSId = lastPSDevSlnSysTS.getPSDevSlnSysTSId();
            try {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                    @Override
                    public void execute(Object obj) throws Exception {
                        PSDevSlnSysTS psDevSlnSysTS = new PSDevSlnSysTS();
                        psDevSlnSysTS.setPSDevSlnSysTSId(strPSDevSlnSysTSId);
                        psDevSlnSysTS.setUnloadTime(new Timestamp(new Date().getTime()));
                        PSDevSlnSysTSService psDevSlnSysTSService = (PSDevSlnSysTSService)ServiceGlobal.getService(PSDevSlnSysTSService.class);
                        psDevSlnSysTSService.update((IEntity)psDevSlnSysTS, false);
                    }
                });
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u65b9\u6848\u7cfb\u7edf\u5378\u8f7d\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDevSlnSysDynaInst getPSDevSlnSysDynaInst(String strPSDevSlnSysDynaInstId) throws Exception {
        if (!this.isLoaded()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u7cfb\u7edf\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5!"));
        }
        PSDevSlnSysDynaInstGlobalModel psDevSlnSysDynaInstGlobalModel = this.psDevSlnSysDynaInstGlobalModelMap.get(strPSDevSlnSysDynaInstId);
        if (psDevSlnSysDynaInstGlobalModel == null) {
            psDevSlnSysDynaInstGlobalModel = new PSDevSlnSysDynaInstGlobalModel();
            psDevSlnSysDynaInstGlobalModel.Init(this.iDAGlobalHelper);
            this.waitLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
            HashMap<String, PSDevSlnSysDynaInstGlobalModel> hashMap = this.psDevSlnSysDynaInstGlobalModelMap;
            synchronized (hashMap) {
                this.enterLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
                PSDevSlnSysDynaInstGlobalModel psDevSlnSysDynaInstGlobalModel2 = this.psDevSlnSysDynaInstGlobalModelMap.get(strPSDevSlnSysDynaInstId);
                if (psDevSlnSysDynaInstGlobalModel2 == null) {
                    this.psDevSlnSysDynaInstGlobalModelMap.put(strPSDevSlnSysDynaInstId, psDevSlnSysDynaInstGlobalModel);
                } else {
                    psDevSlnSysDynaInstGlobalModel = psDevSlnSysDynaInstGlobalModel2;
                }
                this.leaveLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
            }
        }
        boolean bExists = psDevSlnSysDynaInstGlobalModel.containsModel(strPSDevSlnSysDynaInstId);
        IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = (IPSDevSlnSysDynaInst)psDevSlnSysDynaInstGlobalModel.FindModelHelper(strPSDevSlnSysDynaInstId);
        if (!bExists && iPSDevSlnSysDynaInst != null) {
            try {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                    @Override
                    public void execute(Object obj) throws Exception {
                    }
                });
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b\u52a0\u8f7d\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        return iPSDevSlnSysDynaInst;
    }

    @Override
    public IPSDevSlnSysDynaInst getCachePSDevSlnSysDynaInst(String strPSDevSlnSysDynaInstId) throws Exception {
        if (!this.isLoaded()) {
            return null;
        }
        PSDevSlnSysDynaInstGlobalModel psDevSlnSysDynaInstGlobalModel = this.psDevSlnSysDynaInstGlobalModelMap.get(strPSDevSlnSysDynaInstId);
        if (psDevSlnSysDynaInstGlobalModel == null) {
            return null;
        }
        boolean bExists = psDevSlnSysDynaInstGlobalModel.containsModel(strPSDevSlnSysDynaInstId);
        if (!bExists) {
            return null;
        }
        IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = (IPSDevSlnSysDynaInst)psDevSlnSysDynaInstGlobalModel.FindModelHelper(strPSDevSlnSysDynaInstId);
        return iPSDevSlnSysDynaInst;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDevSlnSysDynaInst(String strPSDevSlnSysDynaInstId) {
        PSDevSlnSysTS lastPSDevSlnSysTS = null;
        try {
            IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = this.getCachePSDevSlnSysDynaInst(strPSDevSlnSysDynaInstId);
            if (iPSDevSlnSysDynaInst != null) {
                lastPSDevSlnSysTS = (PSDevSlnSysTS)((IPSObjectRuntime)((Object)iPSDevSlnSysDynaInst)).getRTAttribute("PSDEVSLNSYSTS");
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7f13\u5b58\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDevSlnSysDynaInstId, (Object)ex.getMessage()), (Throwable)ex);
        }
        PSDevSlnSysDynaInstGlobalModel psDevSlnSysDynaInstGlobalModel = null;
        this.waitLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSDevSlnSysDynaInstGlobalModel> hashMap = this.psDevSlnSysDynaInstGlobalModelMap;
        synchronized (hashMap) {
            psDevSlnSysDynaInstGlobalModel = this.psDevSlnSysDynaInstGlobalModelMap.remove(strPSDevSlnSysDynaInstId);
            this.enterAndLeaveLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
        }
        if (psDevSlnSysDynaInstGlobalModel == null) {
            return;
        }
        psDevSlnSysDynaInstGlobalModel.ResetModel(strPSDevSlnSysDynaInstId);
        psDevSlnSysDynaInstGlobalModel.clearGlobalModel();
        if (lastPSDevSlnSysTS != null) {
            final String strPSDevSlnSysTSId = lastPSDevSlnSysTS.getPSDevSlnSysTSId();
            try {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                    @Override
                    public void execute(Object obj) throws Exception {
                        PSDevSlnSysTS psDevSlnSysTS = new PSDevSlnSysTS();
                        psDevSlnSysTS.setPSDevSlnSysTSId(strPSDevSlnSysTSId);
                        psDevSlnSysTS.setUnloadTime(new Timestamp(new Date().getTime()));
                        PSDevSlnSysTSService psDevSlnSysTSService = (PSDevSlnSysTSService)ServiceGlobal.getService(PSDevSlnSysTSService.class);
                        psDevSlnSysTSService.update((IEntity)psDevSlnSysTS, false);
                    }
                });
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b\u5378\u8f7d\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    @Override
    public IPSDepSlnPrd getPSDepSlnPrd(String strPSDepSlnPrdId) throws Exception {
        return (IPSDepSlnPrd)this.psDepSlnPrdGlobalModel.FindModelHelper(strPSDepSlnPrdId);
    }

    @Override
    public void resetPSDepSlnPrd(String strPSDepSlnPrdId) {
        this.psDepSlnPrdGlobalModel.ResetModel(strPSDepSlnPrdId);
    }

    @Override
    public IPSModelInit getPSModelInit(String strPSModelInitId, boolean bTryMode) throws Exception {
        return (IPSModelInit)this.psModelInitGlobalModel.FindModelHelper(strPSModelInitId, bTryMode);
    }

    @Override
    public void resetPSModelInit(String strPSModelInitId) {
        this.psModelInitGlobalModel.ResetModel(strPSModelInitId);
    }

    @Override
    public IPSDBType getPSDBType(String strPSDBTypeId) throws Exception {
        return (IPSDBType)this.psDBTypeGlobalModel.FindModelHelper(strPSDBTypeId);
    }

    @Override
    public IPSDBType getPSDBType(String strPSDBTypeId, boolean bTryMode) throws Exception {
        return (IPSDBType)this.psDBTypeGlobalModel.FindModelHelper(strPSDBTypeId, true);
    }

    @Override
    public void resetPSDBType(String strPSDBTypeId) {
        this.psDBTypeGlobalModel.ResetModel(strPSDBTypeId);
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField psDEField) throws Exception {
        String strDataType = psDEField.getPSDATATYPEID();
        String strDERType = PSDEField.toDEFTypeString(psDEField.getDEFTYPE());
        boolean bMatchName = true;
        if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            bMatchName = false;
        }
        if (bMatchName && (psDEField.getDEFTYPE() == 2 || psDEField.getDEFTYPE() == 3)) {
            bMatchName = false;
        }
        String strTag = StringHelper.Format((String)"[*:%1$s]", (Object)psDEField.getPSDEFIELDNAME());
        IPSDEFieldType iPSDEFieldType = null;
        if (bMatchName && (iPSDEFieldType = this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strTag)) != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"%1$s:%2$s", (Object)strDERType, (Object)strDataType);
        iPSDEFieldType = this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"%1$s:*", (Object)strDERType);
        iPSDEFieldType = this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"*:%1$s", (Object)strDataType);
        iPSDEFieldType = this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"*");
        iPSDEFieldType = this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        return null;
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByTag(String strDEFieldTag) throws Exception {
        return this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strDEFieldTag);
    }

    @Override
    public IPSDEFieldType getPSDEFieldType(String strPSDEFieldTypeId) throws Exception {
        return (IPSDEFieldType)this.psDEFieldTypeGlobalModel.FindModelHelper(strPSDEFieldTypeId);
    }

    @Override
    public void resetAllPSDEFieldTypes() {
        this.psDEFieldTypeGlobalModel.ResetAll();
    }

    @Override
    public IPSViewType getPSViewType(String strPSViewTypeId) throws Exception {
        return (IPSViewType)this.psViewTypeGlobalModel.FindModelHelper(strPSViewTypeId);
    }

    @Override
    public IPSViewType getPSViewType(String strPSViewTypeId, boolean bTryMode) throws Exception {
        return (IPSViewType)this.psViewTypeGlobalModel.FindModelHelper(strPSViewTypeId, bTryMode);
    }

    @Override
    public void resetPSViewType(String strPSViewTypeId) {
        this.psViewTypeGlobalModel.ResetModel(strPSViewTypeId);
    }

    @Override
    public IPSViewEngine getPSViewEngine(String strPSViewEngineId) throws Exception {
        return (IPSViewEngine)this.psViewEngineGlobalModel.FindModelHelper(strPSViewEngineId);
    }

    @Override
    public void resetPSViewEngine(String strPSViewEngineId) {
        this.psViewEngineGlobalModel.ResetModel(strPSViewEngineId);
    }

    @Override
    public IPSControlType getPSControlType(String strPSControlTypeId) throws Exception {
        return (IPSControlType)this.psControlTypeGlobalModel.FindModelHelper(strPSControlTypeId);
    }

    @Override
    public void resetPSControlType(String strPSControlTypeId) {
        this.psControlTypeGlobalModel.ResetModel(strPSControlTypeId);
    }

    @Override
    public IPSPF getPSPF(String strPSPFId) throws Exception {
        return (IPSPF)this.psPFGlobalModel.FindModelHelper(strPSPFId);
    }

    @Override
    public IPSPF getPSPF(String strPSPFId, boolean bTryMode) throws Exception {
        return (IPSPF)this.psPFGlobalModel.FindModelHelper(strPSPFId, bTryMode);
    }

    @Override
    public void resetPSPF(String strPSPFId) {
        this.psPFGlobalModel.ResetModel(strPSPFId);
    }

    @Override
    public IPSDEUIActionType getPSDEUIActionType(String strPSDEUIActionTypeId) throws Exception {
        return (IPSDEUIActionType)this.psDEUIActionTypeGlobalModel.FindModelHelper(strPSDEUIActionTypeId);
    }

    @Override
    public void resetPSDEUIActionType(String strPSDEUIActionTypeId) {
        this.psDEUIActionTypeGlobalModel.ResetModel(strPSDEUIActionTypeId);
    }

    @Override
    public IPSDEGridColumnType getPSDEGridColumnType(String strPSDEGridColumnTypeId) throws Exception {
        return (IPSDEGridColumnType)this.psDEGridColumnTypeGlobalModel.FindModelHelper(strPSDEGridColumnTypeId);
    }

    @Override
    public void resetPSDEGridColumnType(String strPSDEGridColumnTypeId) {
        this.psDEGridColumnTypeGlobalModel.ResetModel(strPSDEGridColumnTypeId);
    }

    @Override
    public IPSDERType getPSDERType(String strPSDERTypeId) throws Exception {
        return (IPSDERType)this.psDERTypeGlobalModel.FindModelHelper(strPSDERTypeId);
    }

    @Override
    public void resetPSDERType(String strPSDERTypeId) {
        this.psDERTypeGlobalModel.ResetModel(strPSDERTypeId);
    }

    @Override
    public IPSToolbarItemType getPSToolbarItemType(String strPSToolbarItemTypeId) throws Exception {
        return (IPSToolbarItemType)this.psToolbarItemTypeGlobalModel.FindModelHelper(strPSToolbarItemTypeId);
    }

    @Override
    public void resetPSToolbarItemType(String strPSToolbarItemTypeId) {
        this.psToolbarItemTypeGlobalModel.ResetModel(strPSToolbarItemTypeId);
    }

    @Override
    public IPSFormType getPSFormType(String strPSFormTypeId) throws Exception {
        return (IPSFormType)this.psFormTypeGlobalModel.FindModelHelper(strPSFormTypeId);
    }

    @Override
    public void resetPSFormType(String strPSFormTypeId) {
        this.psFormTypeGlobalModel.ResetModel(strPSFormTypeId);
    }

    @Override
    public IPSFormDetailType getPSFormDetailType(String strPSFormDetailTypeId) throws Exception {
        return (IPSFormDetailType)this.psFormDetailTypeGlobalModel.FindModelHelper(strPSFormDetailTypeId);
    }

    @Override
    public void resetPSFormDetailType(String strPSFormDetailTypeId) {
        this.psFormDetailTypeGlobalModel.ResetModel(strPSFormDetailTypeId);
    }

    @Override
    public IPSAppMenuItemType getPSAppMenuItemType(String strPSAppMenuItemTypeId) throws Exception {
        return (IPSAppMenuItemType)this.psAppMenuItemTypeGlobalModel.FindModelHelper(strPSAppMenuItemTypeId);
    }

    @Override
    public void resetPSAppMenuItemType(String strPSAppMenuItemTypeId) {
        this.psAppMenuItemTypeGlobalModel.ResetModel(strPSAppMenuItemTypeId);
    }

    @Override
    public IPSDBValueFunc getPSDBValueFunc(String strPSDBValueFuncId) throws Exception {
        return (IPSDBValueFunc)this.psDBValueFuncGlobalModel.FindModelHelper(strPSDBValueFuncId);
    }

    @Override
    public void resetPSDBValueFunc(String strPSDBValueFuncId) {
        this.psDBValueFuncGlobalModel.ResetModel(strPSDBValueFuncId);
    }

    @Override
    public IPSDEJoinType getPSDEJoinType(String strPSDEJoinTypeId) throws Exception {
        return (IPSDEJoinType)this.psDEJoinTypeGlobalModel.FindModelHelper(strPSDEJoinTypeId);
    }

    @Override
    public void resetPSDEJoinType(String strPSDEJoinTypeId) {
        this.psDEJoinTypeGlobalModel.ResetModel(strPSDEJoinTypeId);
    }

    @Override
    public IPSDataEntity getPSDataEntity(String strPSDEId, boolean bCheckVersion) throws Exception {
        PSDataEntity psDataEntity = new PSDataEntity();
        CallResult callResult = this.getPSModelHelper().getPSDataEntity(strPSDEId, psDataEntity);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IPSSystem iPSSystem = this.getPSSystem(psDataEntity.getPSSYSTEMID());
        IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity2(strPSDEId);
        if (bCheckVersion && iPSDataEntity.getVersion() != psDataEntity.getMODELVER()) {
            iPSSystem.resetPSDataEntity(psDataEntity.getPSDATAENTITYNAME());
            iPSDataEntity = iPSSystem.getPSDataEntity2(strPSDEId);
        }
        return iPSDataEntity;
    }

    @Override
    public IPSDataEntity getPSDataEntity(String strPSDEId) throws Exception {
        return this.getPSDataEntity(strPSDEId, false);
    }

    @Override
    public IPSSF getPSSF(String strPSSFId) throws Exception {
        return (IPSSF)this.psSFGlobalModel.FindModelHelper(strPSSFId);
    }

    @Override
    public IPSSF getPSSF(String strPSSFId, boolean bTryMode) throws Exception {
        return (IPSSF)this.psSFGlobalModel.FindModelHelper(strPSSFId, bTryMode);
    }

    @Override
    public void resetPSSF(String strPSSFId) {
        this.psSFGlobalModel.ResetModel(strPSSFId);
    }

    @Override
    public IPSDBDevInst getPSDBDevInst(String strPSDBDevInstId) throws Exception {
        return (IPSDBDevInst)this.psDBDevInstGlobalModel.FindModelHelper(strPSDBDevInstId);
    }

    @Override
    public void resetPSDBDevInst(String strPSDBDevInstId) {
        this.psDBDevInstGlobalModel.ResetModel(strPSDBDevInstId);
    }

    @Override
    public void activePSDBDevInst(String strPSDBDevInstId) {
        this.psDBDevInstGlobalModel.active(strPSDBDevInstId);
    }

    @Override
    public IPSDEActionType getPSDEActionType(String strPSDEActionTypeId) throws Exception {
        return (IPSDEActionType)this.psDEActionTypeGlobalModel.FindModelHelper(strPSDEActionTypeId);
    }

    @Override
    public void resetPSDEActionType(String strPSDEActionTypeId) {
        this.psDEActionTypeGlobalModel.ResetModel(strPSDEActionTypeId);
    }

    @Override
    public IPSViewLogicType getPSViewLogicType(String strPSViewLogicTypeId) throws Exception {
        return (IPSViewLogicType)this.psViewLogicTypeGlobalModel.FindModelHelper(strPSViewLogicTypeId);
    }

    @Override
    public void resetPSViewLogicType(String strPSViewLogicTypeId) {
        this.psViewLogicTypeGlobalModel.ResetModel(strPSViewLogicTypeId);
    }

    @Override
    public IPSDEFValueRuleType getPSDEFValueRuleType(String strPSDEFValueRuleTypeId) throws Exception {
        return (IPSDEFValueRuleType)this.psDEFValueRuleTypeGlobalModel.FindModelHelper(strPSDEFValueRuleTypeId);
    }

    @Override
    public void resetPSDEFValueRuleType(String strPSDEFValueRuleTypeId) {
        this.psDEFValueRuleTypeGlobalModel.ResetModel(strPSDEFValueRuleTypeId);
    }

    @Override
    public IPSDBValueOP getPSDBValueOP(String strPSDBValueOPId) throws Exception {
        return (IPSDBValueOP)this.psDBValueOPGlobalModel.FindModelHelper(strPSDBValueOPId);
    }

    @Override
    public void resetPSDBValueOP(String strPSDBValueOPId) {
        this.psDBValueOPGlobalModel.ResetModel(strPSDBValueOPId);
    }

    @Override
    public IPSDRItemType getPSDRItemType(String strPSDRItemTypeId) throws Exception {
        return (IPSDRItemType)this.psDRItemTypeGlobalModel.FindModelHelper(strPSDRItemTypeId);
    }

    @Override
    public void resetPSDRItemType(String strPSDRItemTypeId) {
        this.psDRItemTypeGlobalModel.ResetModel(strPSDRItemTypeId);
    }

    @Override
    public IPSDBSysProcType getPSDBSysProcType(String strPSDBSysProcTypeId) throws Exception {
        return (IPSDBSysProcType)this.psDBSysProcTypeGlobalModel.FindModelHelper(strPSDBSysProcTypeId);
    }

    @Override
    public void resetPSDBSysProcType(String strPSDBSysProcTypeId) {
        this.psDBSysProcTypeGlobalModel.ResetModel(strPSDBSysProcTypeId);
    }

    @Override
    public IPSEditorType getPSEditorType(String strPSEditorTypeId) throws Exception {
        return (IPSEditorType)this.psEditorTypeGlobalModel.FindModelHelper(strPSEditorTypeId);
    }

    @Override
    public void resetPSEditorType(String strPSEditorTypeId) {
        this.psEditorTypeGlobalModel.ResetModel(strPSEditorTypeId);
    }

    @Override
    public void resetAllPSEditorType() {
        this.psEditorTypeGlobalModel.ResetAll();
    }

    @Override
    public IPSFDLogicType getPSFDLogicType(String strPSFDLogicTypeId) throws Exception {
        return (IPSFDLogicType)this.psFDLogicTypeGlobalModel.FindModelHelper(strPSFDLogicTypeId);
    }

    @Override
    public void resetPSFDLogicType(String strPSFDLogicTypeId) {
        this.psFDLogicTypeGlobalModel.ResetModel(strPSFDLogicTypeId);
    }

    @Override
    public IPSDELogicLinkCondType getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) throws Exception {
        return (IPSDELogicLinkCondType)this.psDELogicLinkCondTypeGlobalModel.FindModelHelper(strPSDELogicLinkCondTypeId);
    }

    @Override
    public void resetPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) {
        this.psDELogicLinkCondTypeGlobalModel.ResetModel(strPSDELogicLinkCondTypeId);
    }

    @Override
    public IPSDELogicLinkType getPSDELogicLinkType(String strPSDELogicLinkTypeId) throws Exception {
        return (IPSDELogicLinkType)this.psDELogicLinkTypeGlobalModel.FindModelHelper(strPSDELogicLinkTypeId);
    }

    @Override
    public void resetPSDELogicLinkType(String strPSDELogicLinkTypeId) {
        this.psDELogicLinkTypeGlobalModel.ResetModel(strPSDELogicLinkTypeId);
    }

    @Override
    public IPSDELogicNodeType getPSDELogicNodeType(String strPSDELogicNodeTypeId) throws Exception {
        return (IPSDELogicNodeType)this.psDELogicNodeTypeGlobalModel.FindModelHelper(strPSDELogicNodeTypeId);
    }

    @Override
    public void resetPSDELogicNodeType(String strPSDELogicNodeTypeId) {
        this.psDELogicNodeTypeGlobalModel.ResetModel(strPSDELogicNodeTypeId);
    }

    @Override
    public IPSWFLinkCondType getPSWFLinkCondType(String strPSWFLinkCondTypeId) throws Exception {
        return (IPSWFLinkCondType)this.psWFLinkCondTypeGlobalModel.FindModelHelper(strPSWFLinkCondTypeId);
    }

    @Override
    public void resetPSWFLinkCondType(String strPSWFLinkCondTypeId) {
        this.psWFLinkCondTypeGlobalModel.ResetModel(strPSWFLinkCondTypeId);
    }

    @Override
    public IPSWFLinkType getPSWFLinkType(String strPSWFLinkTypeId) throws Exception {
        return (IPSWFLinkType)this.psWFLinkTypeGlobalModel.FindModelHelper(strPSWFLinkTypeId);
    }

    @Override
    public void resetPSWFLinkType(String strPSWFLinkTypeId) {
        this.psWFLinkTypeGlobalModel.ResetModel(strPSWFLinkTypeId);
    }

    @Override
    public IPSWFProcessType getPSWFProcessType(String strPSWFProcessTypeId) throws Exception {
        return (IPSWFProcessType)this.psWFProcessTypeGlobalModel.FindModelHelper(strPSWFProcessTypeId);
    }

    @Override
    public void resetPSWFProcessType(String strPSWFProcessTypeId) {
        this.psWFProcessTypeGlobalModel.ResetModel(strPSWFProcessTypeId);
    }

    @Override
    public IPSPortletType getPSPortletType(String strPSPortletTypeId) throws Exception {
        return (IPSPortletType)this.psPortletTypeGlobalModel.FindModelHelper(strPSPortletTypeId);
    }

    @Override
    public void resetPSPortletType(String strPSPortletTypeId) {
        this.psPortletTypeGlobalModel.ResetModel(strPSPortletTypeId);
    }

    @Override
    public IPSSysDevBTType getPSSysDevBTType(String strPSSysDevBTTypeId) throws Exception {
        return (IPSSysDevBTType)this.psSysDevBTTypeGlobalModel.FindModelHelper(strPSSysDevBTTypeId);
    }

    @Override
    public void resetPSSysDevBTType(String strPSSysDevBTTypeId) {
        this.psSysDevBTTypeGlobalModel.ResetModel(strPSSysDevBTTypeId);
    }

    @Override
    public PSSysDevBKTaskGlobal getPSSysDevBKTaskGlobal() {
        return this.psSysDevBKTaskGlobal;
    }

    @Override
    public IPSAppServerType getPSAppServerType(String strPSAppServerTypeId) throws Exception {
        return (IPSAppServerType)this.psAppServerTypeGlobalModel.FindModelHelper(strPSAppServerTypeId);
    }

    @Override
    public void resetPSAppServerType(String strPSAppServerTypeId) {
        this.psAppServerTypeGlobalModel.ResetModel(strPSAppServerTypeId);
    }

    protected PSSysModelInst getPSSysModelInst() throws Exception {
        PSSysModelInst psSysModelInst = new PSSysModelInst();
        if (this.isAPIOnly()) {
            Properties apiModeCfg = new Properties();
            apiModeCfg.load(this.getClass().getClassLoader().getResourceAsStream("saps-apimode.properties"));
            String strJdbcDriver = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.driver", null);
            String strJdbcUserName = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.username", null);
            String strJdbcPassword = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.password", null);
            String strJdbcUrl = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.url", null);
            String strJdbcDBType = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.dbtype", (String)"MYSQL5");
            String strJdbcDBName = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.dbname", null);
            String strJdbcAutoCreate = PropertiesHelper.getProperty((Properties)apiModeCfg, (String)"jdbc.autocreate", null);
            psSysModelInst.setCONNSTR(strJdbcUrl);
            psSysModelInst.setUSERNAME(strJdbcUserName);
            psSysModelInst.setPASSWD(strJdbcPassword);
            psSysModelInst.setDBTYPE(strJdbcDBType);
            psSysModelInst.setDBNAME(strJdbcDBName);
            psSysModelInst.set("AUTOCREATE", strJdbcAutoCreate);
        } else {
            IDEDataCtrl psSysModelInstDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE1895", "SYSTEM", null);
            String strCoreSysModelInstId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CORESYSMODELINSTID", "UID_2015821546416900314232818");
            psSysModelInst.setPSSYSMODELINSTID(strCoreSysModelInstId);
            CallResult callResult = psSysModelInstDataCtrl.Get((BaseDataEntity)psSysModelInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u9ed8\u8ba4\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        return psSysModelInst;
    }

    protected void prepareV5Lib() throws Exception {
        PSCoreSysModel.setSimpleMode((boolean)true);
        PSCoreSysServiceBase.setCloudMode((boolean)this.isCloudMode());
        PSDevSlnSysHelper.setCloudMode(this.isCloudMode());
        if (PSCoreSysServiceBase.isCloudMode()) {
            PSCoreSysModel.setStudioVer((String)"S0600");
        }
        PSSysModelInst psSysModelInst = this.getPSSysModelInst();
        SessionFactory SessionFactory2 = this.getSessionFactory(psSysModelInst);
        MySQL5DialectImpl iDBDialect = null;
        if (this.isAPIOnly()) {
            iDBDialect = new MySQL5DialectImpl();
        } else {
            IPSDBType iDBType = this.getPSDBType(psSysModelInst.getDBTYPE());
            iDBDialect = (IDBDialect)ObjectHelper.Create((String)iDBType.getJdbcDialect());
        }
        this.psCoreSysModel = new PSCoreSysModel();
        this.psCoreSysModel.setSessionFactory(SessionFactory2);
        this.psCoreSysModel.setDBDialect((IDBDialect)iDBDialect);
        if (!this.isCloudMode()) {
            PSRuntimeSysModel _rtSysModel = new PSRuntimeSysModel();
            _rtSysModel.setSessionFactory(SessionFactory2);
            _rtSysModel.setDBDialect((IDBDialect)iDBDialect);
            _rtSysModel.install();
        }
        if (this.plugins != null) {
            String[] stringArray = this.plugins;
            int n = this.plugins.length;
            int n2 = 0;
            while (n2 < n) {
                String strPlugin = stringArray[n2];
                if (!StringHelper.IsNullOrEmpty((String)(strPlugin = strPlugin.trim()))) {
                    log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u6ce8\u518c\u7cfb\u7edf\u63d2\u4ef6[%1$s]", (Object)strPlugin));
                    ISystemPlugin iSystemPlugin = (ISystemPlugin)ObjectHelper.Create((String)strPlugin);
                    iSystemPlugin.init((ISystemModel)this.psCoreSysModel, "");
                    this.psCoreSysModel.setSystemPlugin(iSystemPlugin);
                }
                ++n2;
            }
        }
        long nTime = System.currentTimeMillis();
        log.debug((Object)String.format("\u5f00\u59cb\u5b89\u88c5\u6838\u5fc3\u6a21\u578b", new Object[0]));
        this.psCoreSysModel.install();
        log.debug((Object)String.format("\u7ed3\u675f\u5b89\u88c5\u6838\u5fc3\u6a21\u578b\uff0c\u8017\u65f6[%1$s]ms", System.currentTimeMillis() - nTime));
        String stAutoCreate = psSysModelInst.getParamStringValue("AUTOCREATE", "");
        if (StringHelper.Compare((String)stAutoCreate, (String)"TRUE", (boolean)true) == 0) {
            String strDBName = psSysModelInst.getDBNAME();
            if (StringHelper.IsNullOrEmpty((String)strDBName)) {
                log.warn((Object)String.format("\u672a\u6307\u5b9a\u6570\u636e\u5e93\u540d\u79f0\uff0c\u5ffd\u7565\u81ea\u52a8\u540c\u6b65\u6570\u636e\u6a21\u578b", new Object[0]));
            } else {
                PSModelSchemeHelper psModelSchemeHelper = new PSModelSchemeHelper();
                psModelSchemeHelper.init((ISystemModel)this.psCoreSysModel, psSysModelInst);
                psModelSchemeHelper.syncDEModels(this.strSqlFolder);
                if (this.isCloudMode()) {
                    psModelSchemeHelper.initCloudMode("", this.strInitDataFolder);
                }
            }
        }
    }

    protected SessionFactory getSessionFactory(PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = null;
        Properties hibernateProperties = new Properties();
        IPSDBType iDBType = null;
        if (!this.isAPIOnly()) {
            iDBType = this.getPSDBType(psSysModelInst.getDBTYPE());
        }
        hibernateProperties.put("hibernate.show_sql", "true");
        if (iDBType != null) {
            hibernateProperties.put("jdbc.driverClassName", iDBType.getDriverName());
        } else {
            hibernateProperties.put("jdbc.driverClassName", "com.mysql.jdbc.Driver");
        }
        hibernateProperties.put("jdbc.url", psSysModelInst.getCONNSTR());
        hibernateProperties.put("jdbc.user", psSysModelInst.getUSERNAME());
        hibernateProperties.put("jdbc.pass", psSysModelInst.getPASSWD());
        int nInitPoolSize = psSysModelInst.getINITPOOLSIZE();
        int nMaxPoolSize = psSysModelInst.getMAXPOOLSIZE();
        int nMinPoolSize = psSysModelInst.getMINPOOLSIZE();
        if (nInitPoolSize <= 0 || nInitPoolSize > 20) {
            nInitPoolSize = 4;
        }
        if (nMaxPoolSize <= 0 || nMaxPoolSize > 200) {
            nMaxPoolSize = 100;
        }
        if (nMinPoolSize <= 0 || nMinPoolSize > 20) {
            nMinPoolSize = 4;
        }
        hibernateProperties.put("jdbc.initialPoolSize", String.format("%1$s", nInitPoolSize));
        hibernateProperties.put("jdbc.maxPoolSize", String.format("%1$s", nMaxPoolSize));
        hibernateProperties.put("jdbc.minPoolSize", String.format("%1$s", nMinPoolSize));
        hibernateProperties.put("jdbc.maxIdleTime", "120");
        hibernateProperties.put("jdbc.maxStatements", "50");
        if (iDBType != null) {
            hibernateProperties.put("hibernate.connection.driver_class", iDBType.getDriverName());
        } else {
            hibernateProperties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        }
        hibernateProperties.put("hibernate.connection.url", psSysModelInst.getCONNSTR());
        if (iDBType != null) {
            hibernateProperties.put("hibernate.dialect", iDBType.getHibernateDialect());
        } else {
            hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }
        hibernateProperties.put("hibernate.connection.username", psSysModelInst.getUSERNAME());
        hibernateProperties.put("hibernate.connection.password", psSysModelInst.getPASSWD());
        hibernateProperties.put("hibernate.c3p0.min_size", String.format("%1$s", nMinPoolSize));
        hibernateProperties.put("hibernate.c3p0.max_size", String.format("%1$s", nMaxPoolSize));
        hibernateProperties.put("hibernate.c3p0.timeout", "120");
        hibernateProperties.put("hibernate.c3p0.max_statements", "50");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        Configuration cfg = new Configuration();
        cfg.setProperties(hibernateProperties);
        sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }

    @Override
    public IPSSubSys getPSSubSys(String strPSSubSysId) throws Exception {
        return (IPSSubSys)this.psSubSysGlobalModel.FindModelHelper(strPSSubSysId);
    }

    @Override
    public void resetPSSubSys(String strPSSubSysId) {
        this.psSubSysGlobalModel.ResetModel(strPSSubSysId);
    }

    @Override
    public IPSDEDQPDCondType getPSDEDQPDCondType(String strPSDEDQPDCondId) throws Exception {
        return (IPSDEDQPDCondType)this.psDEDQPDCondTypeGlobalModel.FindModelHelper(strPSDEDQPDCondId);
    }

    @Override
    public void resetPSDEDQPDCondType(String strPSDEDQPDCondId) {
        this.psDEDQPDCondTypeGlobalModel.ResetModel(strPSDEDQPDCondId);
    }

    @Override
    public IPSPFPluginType getPSPFPluginType(String strPSPFPluginTypeId) throws Exception {
        return (IPSPFPluginType)this.psPFPluginTypeGlobalModel.FindModelHelper(strPSPFPluginTypeId);
    }

    @Override
    public void resetPSPFPluginType(String strPSPFPluginTypeId) {
        this.psPFPluginTypeGlobalModel.ResetModel(strPSPFPluginTypeId);
    }

    @Override
    public IPSDETreeNodeType getPSDETreeNodeType(String strPSDETreeNodeTypeId) throws Exception {
        return (IPSDETreeNodeType)this.psDETreeNodeTypeGlobalModel.FindModelHelper(strPSDETreeNodeTypeId);
    }

    @Override
    public void resetPSDETreeNodeType(String strPSDETreeNodeTypeId) {
        this.psDETreeNodeTypeGlobalModel.ResetModel(strPSDETreeNodeTypeId);
    }

    @Override
    public IPSCounterType getPSCounterType(String strPSCounterTypeId) throws Exception {
        return (IPSCounterType)this.psCounterTypeGlobalModel.FindModelHelper(strPSCounterTypeId);
    }

    @Override
    public void resetPSCounterType(String strPSCounterTypeId) {
        this.psCounterTypeGlobalModel.ResetModel(strPSCounterTypeId);
    }

    @Override
    public IPSCounter getPSCounter(String strPSCounterId) throws Exception {
        return (IPSCounter)this.psCounterGlobalModel.FindModelHelper(strPSCounterId);
    }

    @Override
    public void resetPSCounter(String strPSCounterId) {
        this.psCounterGlobalModel.ResetModel(strPSCounterId);
    }

    @Override
    public IPSBackService getPSBackService(String strPSBackServiceId) throws Exception {
        return (IPSBackService)this.psBackServiceGlobalModel.FindModelHelper(strPSBackServiceId);
    }

    @Override
    public void resetPSBackService(String strPSBackServiceId) {
        this.psBackServiceGlobalModel.ResetModel(strPSBackServiceId);
    }

    @Override
    public IPSUserMgrAPI getPSUserMgrAPI() {
        return this.iPSUserMgrAPI;
    }

    @Override
    public void resetAllPSSysIssueEngines() {
        this.psSysIssueEngineGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSSysIssueEngine> getAllPSSysIssueEngines() throws Exception {
        return this.psSysIssueEngineGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppType getPSAppType(String strPSAppTypeId) throws Exception {
        return (IPSAppType)this.psAppTypeGlobalModel.FindModelHelper(strPSAppTypeId);
    }

    @Override
    public void resetPSAppType(String strPSAppTypeId) {
        this.psAppTypeGlobalModel.ResetModel(strPSAppTypeId);
    }

    @Override
    public IPSDevCenter getPSDevCenter(String strPSDevCenterId) throws Exception {
        return (IPSDevCenter)this.psDevCenterGlobalModel.FindModelHelper(strPSDevCenterId);
    }

    @Override
    public void resetPSDevCenter(String strPSDevCenterId) {
        this.psDevCenterGlobalModel.ResetModel(strPSDevCenterId);
    }

    @Override
    public IPSDevCenterBTType getPSDevCenterBTType(String strPSDevCenterBTTypeId) throws Exception {
        return (IPSDevCenterBTType)this.psDevCenterBTTypeGlobalModel.FindModelHelper(strPSDevCenterBTTypeId);
    }

    @Override
    public void resetPSDevCenterBTType(String strPSDevCenterBTTypeId) {
        this.psDevCenterBTTypeGlobalModel.ResetModel(strPSDevCenterBTTypeId);
    }

    @Override
    public PSDevCenterBKTaskGlobal getPSDevCenterBKTaskGlobal() {
        return this.psDevCenterBKTaskGlobal;
    }

    protected void preparePSTaskServerEnv() throws Exception {
        String strKafkaPlugin;
        String strGitLabPlugin;
        if (StringHelper.IsNullOrEmpty((String)this.strPSTaskServerId)) {
            throw new Exception("\u4efb\u52a1\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a\u4efb\u52a1\u7cfb\u7edf\u6807\u8bc6");
        }
        PSTaskServerService psTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class);
        this.psTaskServer = new net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer();
        this.psTaskServer.setPSTaskServerId(this.strPSTaskServerId);
        psTaskServerService.get((IEntity)this.psTaskServer);
        PSTaskServer psTaskServer2 = new PSTaskServer();
        PSDEDataCtrl.convertEntity((IEntity)this.psTaskServer, psTaskServer2);
        PSTaskServerEnvImpl psTaskServerEnvImpl = new PSTaskServerEnvImpl();
        psTaskServerEnvImpl.init(this.iDAGlobalHelper, psTaskServer2);
        PSTaskServerEnvImpl.setCurrent(psTaskServerEnvImpl);
        this.iPSTaskServerEnv = psTaskServerEnvImpl;
        if (this.getPSTaskServerEnv().isThrowExceptionWhenTemplError()) {
            PSTemplHelper.setExceptionWhenError(true);
        }
        if (psTaskServerEnvImpl.isEnableConsoleServer()) {
            PSStudioConsoleHelper psStudioConsoleHelper = new PSStudioConsoleHelper(this.strPSTaskServerId, psTaskServerEnvImpl.getConsoleServerUrl());
            PSStudioConsoleHelper.setCurrent((PSStudioConsoleHelper)psStudioConsoleHelper);
            PSCoreSysServiceBase.setEnableStateInformDefault((boolean)true);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strGitLabPlugin = psTaskServerEnvImpl.getGitLabPlugin())) && StringHelper.Compare((String)strGitLabPlugin, (String)"FALSE", (boolean)true) != 0) {
            if (StringHelper.Compare((String)strGitLabPlugin, (String)"TRUE", (boolean)true) == 0) {
                PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
                PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl());
            } else {
                try {
                    Object objItem = ObjectHelper.Create((String)strGitLabPlugin);
                    if (!(objItem instanceof IPSGitLabPlugin)) {
                        throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e"));
                    }
                    PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
                    PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)((IPSGitLabPlugin)objItem));
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acbGitLab\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strGitLabPlugin, (Object)ex.getMessage()), (Throwable)ex);
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strKafkaPlugin = psTaskServerEnvImpl.getKafkaPlugin())) && StringHelper.Compare((String)strKafkaPlugin, (String)"FALSE", (boolean)true) != 0) {
            if (StringHelper.Compare((String)strKafkaPlugin, (String)"TRUE", (boolean)true) == 0) {
                PSCoreSysServiceBase.setEnableKafkaPlugin((boolean)true);
                PSCoreSysServiceBase.setPSKafkaPlugin((IPSKafkaPlugin)new PSKafkaPluginImpl());
            } else {
                try {
                    Object objItem = ObjectHelper.Create((String)strKafkaPlugin);
                    if (!(objItem instanceof IPSKafkaPlugin)) {
                        throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e"));
                    }
                    PSCoreSysServiceBase.setEnableKafkaPlugin((boolean)true);
                    PSCoreSysServiceBase.setPSKafkaPlugin((IPSKafkaPlugin)((IPSKafkaPlugin)objItem));
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acbKafka\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strKafkaPlugin, (Object)ex.getMessage()), (Throwable)ex);
                }
            }
        }
        if (psTaskServerEnvImpl.isEnableGitBranch()) {
            PSCoreSysServiceBase.setEnableGitBranch((boolean)true);
        }
        if (!StringHelper.IsNullOrEmpty((String)psTaskServerEnvImpl.getModelFormat())) {
            PSCoreSysServiceBase.setModelFormat((String)psTaskServerEnvImpl.getModelFormat());
        }
        if (psTaskServerEnvImpl.getImportBatchSize() > 0) {
            PSModelV2Helper.setBatchSize((int)psTaskServerEnvImpl.getImportBatchSize());
        }
        this.nGlobalConfigVer = this.iPSTaskServerEnv.getGlobalConfigVer();
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSModelStorageImpl.this.createDefaultPSTaskServerLog();
                PSModelStorageImpl.this.createPSTaskServerLog(true);
                PSModelStorageImpl.this.cancelPSTaskServerBKTasks();
            }
        });
    }

    @Override
    public boolean isLoaded() throws Exception {
        if (this.bLoaded && !StringHelper.IsNullOrEmpty((String)this.getErrorInfo())) {
            throw new Exception(this.getErrorInfo());
        }
        return this.bLoaded;
    }

    protected void logModelStorageInfo() {
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSModelStorageImpl.this.createPSTaskServerLog(false);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void clearModelStorage() {
        ArrayList<String> psDevSlnSysIdList = new ArrayList<String>();
        this.waitLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSDevSlnSysGlobalModel> hashMap = this.psDevSlnSysGlobalModelMap;
        synchronized (hashMap) {
            psDevSlnSysIdList.addAll(this.psDevSlnSysGlobalModelMap.keySet());
            this.enterAndLeaveLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
        }
        for (String string : psDevSlnSysIdList) {
            try {
                IPSDevSlnSys iPSDevSlnSys = this.getCachePSDevSlnSys(string);
                if (iPSDevSlnSys == null || iPSDevSlnSys.getLastActiveTime() + (long)this.nPSDevSlnSysExpiredTime >= System.currentTimeMillis()) continue;
                log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s]", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getName()));
                if (this.getPSSysDevBKTaskGlobal().isPSBKTaskSessionBusy(string, true)) {
                    log.debug((Object)StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s]\u8fd8\u5904\u4e8e\u5fd9\u72b6\u6001\uff0c\u5ffd\u7565\u5378\u8f7d", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getName()));
                    continue;
                }
                this.getPSSysDevBKTaskGlobal().resetPSBKTaskSession(string);
                this.resetPSDevSlnSys(string);
                log.debug((Object)StringHelper.Format((String)"\u7ed3\u675f\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s]", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getName()));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        ArrayList<String> psDevSlnSysDynaInstIdList = new ArrayList<String>();
        this.waitLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSDevSlnSysDynaInstGlobalModel> hashMap2 = this.psDevSlnSysDynaInstGlobalModelMap;
        synchronized (hashMap2) {
            psDevSlnSysDynaInstIdList.addAll(this.psDevSlnSysDynaInstGlobalModelMap.keySet());
            this.enterAndLeaveLock(this.lock_psDevSlnSysDynaInstGlobalModelMap, ThreadLockChecker.getCodeInfo());
        }
        for (String string : psDevSlnSysDynaInstIdList) {
            try {
                IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = this.getCachePSDevSlnSysDynaInst(string);
                if (iPSDevSlnSysDynaInst == null || iPSDevSlnSysDynaInst.getPSDevSlnSys().getLastActiveTime() + (long)this.nPSDevSlnSysDynaInstExpiredTime >= System.currentTimeMillis()) continue;
                log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s][%2$s]", (Object)iPSDevSlnSysDynaInst.getId(), (Object)iPSDevSlnSysDynaInst.getName()));
                if (this.getPSSysDevBKTaskGlobal().isPSBKTaskSessionBusy(string, true)) {
                    log.debug((Object)StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s][%2$s]\u8fd8\u5904\u4e8e\u5fd9\u72b6\u6001\uff0c\u5ffd\u7565\u5378\u8f7d", (Object)iPSDevSlnSysDynaInst.getId(), (Object)iPSDevSlnSysDynaInst.getName()));
                    continue;
                }
                this.getPSSysDevBKTaskGlobal().resetPSBKTaskSession(string);
                this.resetPSDevSlnSysDynaInst(string);
                log.debug((Object)StringHelper.Format((String)"\u7ed3\u675f\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s][%2$s]", (Object)iPSDevSlnSysDynaInst.getId(), (Object)iPSDevSlnSysDynaInst.getName()));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5378\u8f7d\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        this.psDBDevInstGlobalModel.close(this.nPSDevSlnSysExpiredTime + 60000);
        this.psDBDevInstGlobalModel.remove(this.nPSDevSlnSysExpiredTime + 120000);
        PSDBDevInstGlobal.remove(this.nPSDevSlnSysExpiredTime + 120000);
        PSObjectFactory.removePSModelHelper(this.nPSDevSlnSysExpiredTime + 90000);
        PSSysModelInstGlobal.remove((long)(this.nPSDevSlnSysExpiredTime + 120000));
        String[] devcenterids = this.psDevCenterGlobalModel.remove(this.nPSDevSlnSysExpiredTime + 120000);
        if (devcenterids != null) {
            String[] stringArray = devcenterids;
            int n = devcenterids.length;
            int n2 = 0;
            while (n2 < n) {
                String string = stringArray[n2];
                try {
                    this.getPSDevCenterBKTaskGlobal().resetPSBKTaskSession(string);
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u5378\u8f7d\u5e94\u7528\u4e2d\u5fc3[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)ex.getMessage()), (Throwable)ex);
                }
                ++n2;
            }
        }
    }

    protected void offlinePSDevSlnSys() {
        if (!this.iPSTaskServerEnv.isEnableOfflineDevSlnSys()) {
            return;
        }
        try {
            final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            String strSQL = "SELECT T1.PSDEVSLNSYSID FROM T_SRFPSDEVSLNSYS T1\r\n\t\t\tINNER JOIN T_SRFPSDEVSLN T2 ON T1.PSDEVSLNID = T2.PSDEVSLNID\r\n\t\t\tINNER JOIN T_SRFPSDEVCENTER T3 ON T2.PSDEVCENTERID = T3.PSDEVCENTERID\r\n\t\t\tWHERE T3.PSSVRDOMAINID=? AND T1.DEVSYSSTATE = 30 AND T1.OFFLINETIME IS NOT NULL AND T1.OFFLINETIME< ?";
            Timestamp time = new Timestamp(System.currentTimeMillis() - 60000L);
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.addString(this.iPSTaskServerEnv.getPSSvrDomainId());
            sqlParamList.addDateTime((Object)time);
            IEntity iEntity = null;
            ArrayList list = psDevSlnSysService.selectRaw(strSQL, sqlParamList);
            if (list.size() == 1) {
                iEntity = (IEntity)list.get(0);
            } else if (list.size() > 1) {
                iEntity = (IEntity)list.get(random.nextInt(999999) % list.size());
            }
            if (iEntity != null) {
                final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                iEntity.copyTo((IDataObject)psDevSlnSys, false);
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

                    @Override
                    public void execute(Object obj) {
                        try {
                            psDevSlnSysService.offline(psDevSlnSys);
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.Format((String)"\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                        }
                    }
                });
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected void checkThreadLock() {
        long nMaxTime = ThreadLockChecker.getInstance().checkDeadLock();
        long nLogIdleTime = System.currentTimeMillis() - this.nLastLogTime;
        if (nLogIdleTime >= 100000L) {
            log.error((Object)StringHelper.Format((String)"****************** \u7ebf\u7a0b\u7b49\u5f85\u8d85\u8fc7[%1$s]\uff0c\u65e5\u5fd7\u7a7a\u95f2\u8d85\u8fc7[%2$s]\uff0c\u6267\u884c\u670d\u52a1\u5668\u91cd\u542f *********************", (Object)nMaxTime, (Object)nLogIdleTime));
            String strRestartCmd = this.getPSTaskServerEnv().getRestartCmd();
            if (!StringHelper.IsNullOrEmpty((String)strRestartCmd)) {
                try {
                    Runtime.getRuntime().exec(strRestartCmd);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        }
    }

    @Override
    public IPSModel getPSModel(String strPSModelId, boolean bTryMode) throws Exception {
        return (IPSModel)this.psModelGlobalModel.FindModelHelper(strPSModelId, bTryMode);
    }

    @Override
    public void resetPSModel(String strPSModelId) {
        this.psModelGlobalModel.ResetModel(strPSModelId);
    }

    @Override
    public IPSHelpArticleType getPSHelpArticleType(String strPSHelpArticleTypeId) throws Exception {
        return (IPSHelpArticleType)this.psHelpArticleTypeGlobalModel.FindModelHelper(strPSHelpArticleTypeId);
    }

    @Override
    public void resetPSHelpArticleType(String strPSHelpArticleTypeId) {
        this.psHelpArticleTypeGlobalModel.ResetModel(strPSHelpArticleTypeId);
    }

    @Override
    public IPSHelpSectionType getPSHelpSectionType(String strPSHelpSectionTypeId) throws Exception {
        return (IPSHelpSectionType)this.psHelpSectionTypeGlobalModel.FindModelHelper(strPSHelpSectionTypeId);
    }

    @Override
    public void resetPSHelpSectionType(String strPSHelpSectionTypeId) {
        this.psHelpSectionTypeGlobalModel.ResetModel(strPSHelpSectionTypeId);
    }

    @Override
    public IPSHelpPrjType getPSHelpPrjType(String strPSHelpPrjTypeId) throws Exception {
        return (IPSHelpPrjType)this.psHelpPrjTypeGlobalModel.FindModelHelper(strPSHelpPrjTypeId);
    }

    @Override
    public void resetPSHelpPrjType(String strPSHelpPrjTypeId) {
        this.psHelpPrjTypeGlobalModel.ResetModel(strPSHelpPrjTypeId);
    }

    @Override
    public IPSHelpArticleTempl getPSHelpArticleTempl(String strPSHelpArticleTemplId) throws Exception {
        return (IPSHelpArticleTempl)this.psHelpArticleTemplGlobalModel.FindModelHelper(strPSHelpArticleTemplId);
    }

    @Override
    public void resetPSHelpArticleTempl(String strPSHelpArticleTemplId) {
        this.psHelpArticleTemplGlobalModel.ResetModel(strPSHelpArticleTemplId);
    }

    @Override
    public IPSHelpSectionTempl getPSHelpSectionTempl(String strPSHelpSectionTemplId) throws Exception {
        return (IPSHelpSectionTempl)this.psHelpSectionTemplGlobalModel.FindModelHelper(strPSHelpSectionTemplId);
    }

    @Override
    public void resetPSHelpSectionTempl(String strPSHelpSectionTemplId) {
        this.psHelpSectionTemplGlobalModel.ResetModel(strPSHelpSectionTemplId);
    }

    @Override
    public IPSHelpPrjTempl getPSHelpPrjTempl(String strPSHelpPrjTemplId) throws Exception {
        return (IPSHelpPrjTempl)this.psHelpPrjTemplGlobalModel.FindModelHelper(strPSHelpPrjTemplId);
    }

    @Override
    public void resetPSHelpPrjTempl(String strPSHelpPrjTemplId) {
        this.psHelpPrjTemplGlobalModel.ResetModel(strPSHelpPrjTemplId);
    }

    @Override
    public IPSPFCDN getPSPFCDN(String strPSPFCDNId) throws Exception {
        return (IPSPFCDN)this.psPFCDNGlobalModel.FindModelHelper(strPSPFCDNId);
    }

    @Override
    public void resetPSPFCDN(String strPSPFCDNId) {
        this.psPFCDNGlobalModel.ResetModel(strPSPFCDNId);
    }

    @Override
    public IPSASGroup getPSASGroup(String strPSASGroupId) throws Exception {
        return (IPSASGroup)this.psASGroupGlobalModel.FindModelHelper(strPSASGroupId);
    }

    @Override
    public void resetPSASGroup(String strPSASGroupId) {
        this.psASGroupGlobalModel.ResetModel(strPSASGroupId);
    }

    @Override
    public IPSAppServer getPSAppServer(String strPSAppServerId) throws Exception {
        return (IPSAppServer)this.psAppServerGlobalModel.FindModelHelper(strPSAppServerId);
    }

    @Override
    public void resetPSAppServer(String strPSAppServerId) {
        this.psAppServerGlobalModel.ResetModel(strPSAppServerId);
    }

    @Override
    public IPSMQInst getPSMQInst(String strPSMQInstId) throws Exception {
        return (IPSMQInst)this.psMQInstGlobalModel.FindModelHelper(strPSMQInstId);
    }

    @Override
    public void resetPSMQInst(String strPSMQInstId) {
        this.psMQInstGlobalModel.ResetModel(strPSMQInstId);
    }

    @Override
    public IPSDepSysType getPSDepSysType(String strPSDepSysTypeId) throws Exception {
        return (IPSDepSysType)this.psDepSysTypeGlobalModel.FindModelHelper(strPSDepSysTypeId);
    }

    @Override
    public void resetPSDepSysType(String strPSDepSysTypeId) {
        this.psDepSysTypeGlobalModel.ResetModel(strPSDepSysTypeId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDepSysVer getPSDepSysVer(String strPSDepSysVerId) throws Exception {
        if (!this.isLoaded()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5!"));
        }
        PSDepSysVerGlobalModel psDepSysVerGlobalModel = null;
        HashMap<String, PSDepSysVerGlobalModel> hashMap = this.psDepSysVerGlobalModelMap;
        synchronized (hashMap) {
            psDepSysVerGlobalModel = this.psDepSysVerGlobalModelMap.get(strPSDepSysVerId);
            if (psDepSysVerGlobalModel == null) {
                psDepSysVerGlobalModel = new PSDepSysVerGlobalModel();
                psDepSysVerGlobalModel.Init(this.iDAGlobalHelper);
                this.psDepSysVerGlobalModelMap.put(strPSDepSysVerId, psDepSysVerGlobalModel);
            }
        }
        boolean bExists = psDepSysVerGlobalModel.containsModel(strPSDepSysVerId);
        IPSDepSysVer iPSDepSysVer = (IPSDepSysVer)psDepSysVerGlobalModel.FindModelHelper(strPSDepSysVerId);
        return iPSDepSysVer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public IPSDepSysVer getCachePSDepSysVer(String strPSDepSysVerId) throws Exception {
        if (!this.isLoaded()) {
            return null;
        }
        PSDepSysVerGlobalModel psDepSysVerGlobalModel = null;
        HashMap<String, PSDepSysVerGlobalModel> hashMap = this.psDepSysVerGlobalModelMap;
        synchronized (hashMap) {
            psDepSysVerGlobalModel = this.psDepSysVerGlobalModelMap.get(strPSDepSysVerId);
            if (psDepSysVerGlobalModel == null) {
                return null;
            }
        }
        boolean bExists = psDepSysVerGlobalModel.containsModel(strPSDepSysVerId);
        if (bExists) return (IPSDepSysVer)psDepSysVerGlobalModel.FindModelHelper(strPSDepSysVerId);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDepSysVer(String strPSDepSysVerId) {
        PSDepSysVerGlobalModel psDepSysVerGlobalModel = null;
        HashMap<String, PSDepSysVerGlobalModel> hashMap = this.psDepSysVerGlobalModelMap;
        synchronized (hashMap) {
            psDepSysVerGlobalModel = this.psDepSysVerGlobalModelMap.remove(strPSDepSysVerId);
        }
        if (psDepSysVerGlobalModel == null) {
            return;
        }
        boolean bExists = psDepSysVerGlobalModel.containsModel(strPSDepSysVerId);
        if (bExists) {
            try {
                IPSDepSysVer iPSDepSysVer = (IPSDepSysVer)psDepSysVerGlobalModel.FindModelHelper(strPSDepSysVerId);
                PSObjectFactory.resetPSModelHelper(iPSDepSysVer.getPSSysModelInstId());
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u53ef\u90e8\u7f72\u7cfb\u7edf\u7248\u672c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            }
        }
        psDepSysVerGlobalModel.ResetModel(strPSDepSysVerId);
    }

    @Override
    public IPSSysEngineConfig getPSSysEngineConfig(String strPSSysEngineConfigId) throws Exception {
        return (IPSSysEngineConfig)this.psSysEngineConfigGlobalModel.FindModelHelper(strPSSysEngineConfigId);
    }

    @Override
    public void resetPSSysEngineConfig(String strPSSysEngineConfigId) {
        this.psSysEngineConfigGlobalModel.ResetModel(strPSSysEngineConfigId);
    }

    @Override
    public IPSRobot getPSRobot(String strPSRobotId) throws Exception {
        return (IPSRobot)this.psRobotGlobalModel.FindModelHelper(strPSRobotId);
    }

    @Override
    public void resetPSRobot(String strPSRobotId) {
        this.psRobotGlobalModel.ResetModel(strPSRobotId);
    }

    @Override
    public String getPSTaskServerId() {
        return this.strPSTaskServerId;
    }

    @Override
    public IPSRobotWorkType getPSRobotWorkType(String strPSRobotWorkTypeId, boolean bTryMode) throws Exception {
        return (IPSRobotWorkType)this.psRobotWorkTypeGlobalModel.FindModelHelper(strPSRobotWorkTypeId);
    }

    @Override
    public void resetPSRobotWorkType(String strPSRobotWorkTypeId) {
        this.psRobotWorkTypeGlobalModel.ResetModel(strPSRobotWorkTypeId);
    }

    @Override
    public void resetAllPSRobotWorkType() {
        this.psRobotWorkTypeGlobalModel.ResetAll();
    }

    @Override
    public IPSBookingResType getPSBookingResType(String strPSBookingResTypeId, boolean bTryMode) throws Exception {
        return (IPSBookingResType)this.psBookingResTypeGlobalModel.FindModelHelper(strPSBookingResTypeId);
    }

    @Override
    public void resetPSBookingResType(String strPSBookingResTypeId) {
        this.psBookingResTypeGlobalModel.ResetModel(strPSBookingResTypeId);
    }

    @Override
    public void resetAllPSBookingResType() {
        this.psBookingResTypeGlobalModel.ResetAll();
    }

    @Override
    public IPSGitUser getPSGitUser(String strPSGitUserId) throws Exception {
        return (IPSGitUser)this.psGitUserGlobalModel.FindModelHelper(strPSGitUserId);
    }

    @Override
    public void resetPSGitUser(String strPSGitUserId) {
        this.psGitUserGlobalModel.ResetModel(strPSGitUserId);
    }

    @Override
    public IPSDevServerType getPSDevServerType(String strPSDevServerTypeId) throws Exception {
        return (IPSDevServerType)this.psDevServerTypeGlobalModel.FindModelHelper(strPSDevServerTypeId);
    }

    @Override
    public void resetPSDevServerType(String strPSDevServerTypeId) {
        this.psDevServerTypeGlobalModel.ResetModel(strPSDevServerTypeId);
    }

    @Override
    public IPSMobAppPackServer getPSMobAppPackServer(String strPSMobAppPackServerId) throws Exception {
        return (IPSMobAppPackServer)this.psMobAppPackServerGlobalModel.FindModelHelper(strPSMobAppPackServerId);
    }

    @Override
    public void resetPSMobAppPackServer(String strPSMobAppPackServerId) {
        this.psMobAppPackServerGlobalModel.ResetModel(strPSMobAppPackServerId);
    }

    @Override
    public IPSDeployServer getPSDeployServer(String strPSDeployServerId) throws Exception {
        return (IPSDeployServer)this.psDeployServerGlobalModel.FindModelHelper(strPSDeployServerId);
    }

    @Override
    public void resetPSDeployServer(String strPSDeployServerId) {
        this.psDeployServerGlobalModel.ResetModel(strPSDeployServerId);
    }

    @Override
    public IPSSFPluginTempl getPSSFPluginTempl(String strPSSFPluginTemplId) throws Exception {
        return (IPSSFPluginTempl)this.psSFPluginTemplGlobalModel.FindModelHelper(strPSSFPluginTemplId);
    }

    @Override
    public IPSSFPluginTempl getPSSFPluginTempl(String strPSSFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSSFPluginTempl)this.psSFPluginTemplGlobalModel.FindModelHelper(strPSSFPluginTemplId, bTryMode);
    }

    @Override
    public void resetPSSFPluginTempl(String strPSSFPluginTemplId) {
        this.psSFPluginTemplGlobalModel.ResetModel(strPSSFPluginTemplId);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFPluginTemplId) throws Exception {
        return (IPSPFPluginTempl)this.psPFPluginTemplGlobalModel.FindModelHelper(strPSPFPluginTemplId);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSPFPluginTempl)this.psPFPluginTemplGlobalModel.FindModelHelper(strPSPFPluginTemplId, bTryMode);
    }

    @Override
    public void resetPSPFPluginTempl(String strPSPFPluginTemplId) {
        this.psPFPluginTemplGlobalModel.ResetModel(strPSPFPluginTemplId);
    }

    @Override
    public IPSDCCodeSnippet getPSDCCodeSnippet(String strPSDCCodeSnippetId) throws Exception {
        return (IPSDCCodeSnippet)this.psDCCodeSnippetGlobalModel.FindModelHelper(strPSDCCodeSnippetId);
    }

    @Override
    public void resetPSDCCodeSnippet(String strPSDCCodeSnippetId) {
        this.psDCCodeSnippetGlobalModel.ResetModel(strPSDCCodeSnippetId);
    }

    @Override
    public IPSCodeSnippetType getPSCodeSnippetType(String strPSCodeSnippetTypeId) throws Exception {
        return (IPSCodeSnippetType)this.psCodeSnippetTypeGlobalModel.FindModelHelper(strPSCodeSnippetTypeId);
    }

    @Override
    public void resetPSCodeSnippetType(String strPSCodeSnippetTypeId) {
        this.psCodeSnippetTypeGlobalModel.ResetModel(strPSCodeSnippetTypeId);
    }

    @Override
    public IPSTaskServerEnv getPSTaskServerEnv() {
        return this.iPSTaskServerEnv;
    }

    @Override
    public IPSDeployCenter getPSDeployCenter(String strPSDeployCenterId) throws Exception {
        return (IPSDeployCenter)this.psDeployCenterGlobalModel.FindModelHelper(strPSDeployCenterId);
    }

    @Override
    public void resetPSDeployCenter(String strPSDeployCenterId) {
        this.psDeployCenterGlobalModel.ResetModel(strPSDeployCenterId);
    }

    @Override
    public IPSWorkshopServer getPSWorkshopServer(String strPSWorkshopServerId) throws Exception {
        return (IPSWorkshopServer)this.psWorkshopServerGlobalModel.FindModelHelper(strPSWorkshopServerId);
    }

    @Override
    public void resetPSWorkshopServer(String strPSWorkshopServerId) {
        this.psWorkshopServerGlobalModel.ResetModel(strPSWorkshopServerId);
    }

    @Override
    public IPSMSPlatform getPSMSPlatform(String strPSMSPlatformId) throws Exception {
        return (IPSMSPlatform)this.psMSPlatformGlobalModel.FindModelHelper(strPSMSPlatformId);
    }

    @Override
    public void resetPSMSPlatform(String strPSMSPlatformId) {
        this.psMSPlatformGlobalModel.ResetModel(strPSMSPlatformId);
    }

    @Override
    public IPSDCMSPlatform getPSDCMSPlatform(String strPSDCMSPlatformId) throws Exception {
        this.psDCMSPlatformGlobalModel.ResetModelAlways(strPSDCMSPlatformId);
        return (IPSDCMSPlatform)this.psDCMSPlatformGlobalModel.FindModelHelper(strPSDCMSPlatformId);
    }

    @Override
    public void resetPSDCMSPlatform(String strPSDCMSPlatformId) {
        this.psDCMSPlatformGlobalModel.ResetModel(strPSDCMSPlatformId);
    }

    @Override
    public IPSDCCluster getPSDCCluster(String strPSDCClusterId) throws Exception {
        this.psDCClusterGlobalModel.ResetModelAlways(strPSDCClusterId);
        return (IPSDCCluster)this.psDCClusterGlobalModel.FindModelHelper(strPSDCClusterId);
    }

    @Override
    public void resetPSDCCluster(String strPSDCClusterId) {
        this.psDCClusterGlobalModel.ResetModel(strPSDCClusterId);
    }

    @Override
    public IPSDevSlnMSDepApp getPSDevSlnMSDepApp(String strPSDevSlnMSDepAppId) throws Exception {
        this.psDevSlnMSDepAppGlobalModel.ResetModelAlways(strPSDevSlnMSDepAppId);
        return (IPSDevSlnMSDepApp)this.psDevSlnMSDepAppGlobalModel.FindModelHelper(strPSDevSlnMSDepAppId);
    }

    @Override
    public void resetPSDevSlnMSDepApp(String strPSDevSlnMSDepAppId) {
        this.psDevSlnMSDepAppGlobalModel.ResetModel(strPSDevSlnMSDepAppId);
    }

    @Override
    public IPSDevSlnMSDepAPI getPSDevSlnMSDepAPI(String strPSDevSlnMSDepAPIId) throws Exception {
        this.psDevSlnMSDepAPIGlobalModel.ResetModelAlways(strPSDevSlnMSDepAPIId);
        return (IPSDevSlnMSDepAPI)this.psDevSlnMSDepAPIGlobalModel.FindModelHelper(strPSDevSlnMSDepAPIId);
    }

    @Override
    public void resetPSDevSlnMSDepAPI(String strPSDevSlnMSDepAPIId) {
        this.psDevSlnMSDepAPIGlobalModel.ResetModel(strPSDevSlnMSDepAPIId);
    }

    @Override
    public IPSSVNServer getPSSVNServer(String strPSSVNServerId) throws Exception {
        return (IPSSVNServer)this.psSVNServerGlobalModel.FindModelHelper(strPSSVNServerId);
    }

    @Override
    public void resetPSSVNServer(String strPSSVNServerId) {
        this.psSVNServerGlobalModel.ResetModel(strPSSVNServerId);
    }

    @Override
    public IPSDBServer getPSDBServer(String strPSDBServerId) throws Exception {
        return (IPSDBServer)this.psDBServerGlobalModel.FindModelHelper(strPSDBServerId);
    }

    @Override
    public void resetPSDBServer(String strPSDBServerId) {
        this.psDBServerGlobalModel.ResetModel(strPSDBServerId);
    }

    @Override
    public IPSMavenServer getPSMavenServer(String strPSMavenServerId) throws Exception {
        return (IPSMavenServer)this.psMavenServerGlobalModel.FindModelHelper(strPSMavenServerId);
    }

    @Override
    public void resetPSMavenServer(String strPSMavenServerId) {
        this.psMavenServerGlobalModel.ResetModel(strPSMavenServerId);
    }

    @Override
    public IPSMavenServerType getPSMavenServerType(String strPSMavenServerTypeId) throws Exception {
        return (IPSMavenServerType)this.psMavenServerTypeGlobalModel.FindModelHelper(strPSMavenServerTypeId);
    }

    @Override
    public void resetPSMavenServerType(String strPSMavenServerTypeId) {
        this.psMavenServerTypeGlobalModel.ResetModel(strPSMavenServerTypeId);
    }

    @Override
    public IPSPanelDetailType getPSPanelDetailType(String strPSPanelDetailTypeId) throws Exception {
        return (IPSPanelDetailType)this.psPanelDetailTypeGlobalModel.FindModelHelper(strPSPanelDetailTypeId);
    }

    @Override
    public void resetPSPanelDetailType(String strPSPanelDetailTypeId) {
        this.psPanelDetailTypeGlobalModel.ResetModel(strPSPanelDetailTypeId);
    }

    @Override
    public IPSPanelItemLogicType getPSPanelItemLogicType(String strPSPanelItemLogicTypeId) throws Exception {
        return (IPSPanelItemLogicType)this.psPanelItemLogicTypeGlobalModel.FindModelHelper(strPSPanelItemLogicTypeId);
    }

    @Override
    public void resetPSPanelItemLogicType(String strPSPanelItemLogicTypeId) {
        this.psPanelItemLogicTypeGlobalModel.ResetModel(strPSPanelItemLogicTypeId);
    }

    @Override
    public IPSPanelLogicLinkType getPSPanelLogicLinkType(String strPSPanelLogicLinkTypeId) throws Exception {
        return (IPSPanelLogicLinkType)this.psPanelLogicLinkTypeGlobalModel.FindModelHelper(strPSPanelLogicLinkTypeId);
    }

    @Override
    public void resetPSPanelLogicLinkType(String strPSPanelLogicLinkTypeId) {
        this.psPanelLogicLinkTypeGlobalModel.ResetModel(strPSPanelLogicLinkTypeId);
    }

    @Override
    public IPSPanelLogicNodeType getPSPanelLogicNodeType(String strPSPanelLogicNodeTypeId) throws Exception {
        return (IPSPanelLogicNodeType)this.psPanelLogicNodeTypeGlobalModel.FindModelHelper(strPSPanelLogicNodeTypeId);
    }

    @Override
    public void resetPSPanelLogicNodeType(String strPSPanelLogicNodeTypeId) {
        this.psPanelLogicNodeTypeGlobalModel.ResetModel(strPSPanelLogicNodeTypeId);
    }

    @Override
    public IPSPanelLogicLinkCondType getPSPanelLogicLinkCondType(String strPSPanelLogicLinkCondTypeId) throws Exception {
        return (IPSPanelLogicLinkCondType)this.psPanelLogicLinkCondTypeGlobalModel.FindModelHelper(strPSPanelLogicLinkCondTypeId);
    }

    @Override
    public void resetPSPanelLogicLinkCondType(String strPSPanelLogicLinkCondTypeId) {
        this.psPanelLogicLinkCondTypeGlobalModel.ResetModel(strPSPanelLogicLinkCondTypeId);
    }

    @Override
    public IPSSysUtilType getPSSysUtilType(String strPSSysUtilTypeId) throws Exception {
        return (IPSSysUtilType)this.psSysUtilTypeGlobalModel.FindModelHelper(strPSSysUtilTypeId);
    }

    @Override
    public void resetPSSysUtilType(String strPSSysUtilTypeId) {
        this.psSysUtilTypeGlobalModel.ResetModel(strPSSysUtilTypeId);
    }

    @Override
    public IPSAppUtilType getPSAppUtilType(String strPSAppUtilTypeId) throws Exception {
        return (IPSAppUtilType)this.psAppUtilTypeGlobalModel.FindModelHelper(strPSAppUtilTypeId);
    }

    @Override
    public void resetPSAppUtilType(String strPSAppUtilTypeId) {
        this.psAppUtilTypeGlobalModel.ResetModel(strPSAppUtilTypeId);
    }

    @Override
    public IPSWorkspaceType getPSWorkspaceType(String strPSWorkspaceTypeId) throws Exception {
        return (IPSWorkspaceType)this.psWorkspaceTypeGlobalModel.FindModelHelper(strPSWorkspaceTypeId);
    }

    @Override
    public IPSWorkspaceType getPSWorkspaceType(String strPSWorkspaceTypeId, boolean bTryMode) throws Exception {
        return (IPSWorkspaceType)this.psWorkspaceTypeGlobalModel.FindModelHelper(strPSWorkspaceTypeId, bTryMode);
    }

    @Override
    public void resetPSWorkspaceType(String strPSWorkspaceTypeId) {
        this.psWorkspaceTypeGlobalModel.ResetModel(strPSWorkspaceTypeId);
    }

    @Override
    public IPSDCWorkspace getPSDCWorkspace(String strPSDCWorkspaceId) throws Exception {
        return this.getPSDCWorkspace(strPSDCWorkspaceId, false);
    }

    @Override
    public IPSDCWorkspace getPSDCWorkspace(String strPSDCWorkspaceId, boolean bTryMode) throws Exception {
        IPSDCWorkspace iPSDCWorkspace = (IPSDCWorkspace)this.psDCWorkspaceGlobalModel.FindModelHelper(strPSDCWorkspaceId, bTryMode);
        if (iPSDCWorkspace != null) {
            this.psDCWorkspaceGlobalModel.ResetModelAlways(strPSDCWorkspaceId);
        }
        return iPSDCWorkspace;
    }

    @Override
    public void resetPSDCWorkspace(String strPSDCWorkspaceId) {
        this.psDCWorkspaceGlobalModel.ResetModel(strPSDCWorkspaceId);
    }

    @Override
    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc(String strPSDevSlnMSDepFuncId) throws Exception {
        this.psDevSlnMSDepFuncGlobalModel.ResetModelAlways(strPSDevSlnMSDepFuncId);
        return (IPSDevSlnMSDepFunc)this.psDevSlnMSDepFuncGlobalModel.FindModelHelper(strPSDevSlnMSDepFuncId);
    }

    @Override
    public void resetPSDevSlnMSDepFunc(String strPSDevSlnMSDepFuncId) {
        this.psDevSlnMSDepFuncGlobalModel.ResetModel(strPSDevSlnMSDepFuncId);
    }

    @Override
    public IPSUIEngineType getPSUIEngineType(String strPSUIEngineTypeId) throws Exception {
        return (IPSUIEngineType)this.psUIEngineTypeGlobalModel.FindModelHelper(strPSUIEngineTypeId);
    }

    @Override
    public void resetPSUIEngineType(String strPSUIEngineTypeId) {
        this.psUIEngineTypeGlobalModel.ResetModel(strPSUIEngineTypeId);
    }

    @Override
    public IPSUIEngineType getPSUIEngineType(String strPSUIEngineTypeId, boolean bTryMode) throws Exception {
        return (IPSUIEngineType)this.psUIEngineTypeGlobalModel.FindModelHelper(strPSUIEngineTypeId, bTryMode);
    }

    protected void cancelPSTaskServerBKTasks() {
        try {
            PSBKTaskLogService psBKTaskLogService = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class);
            SelectContext selectContext = new SelectContext();
            SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
            selectGroupFilter.setCondOp("OR");
            SelectFieldFilter selectFieldFilter1 = new SelectFieldFilter();
            selectFieldFilter1.setDEFName("TASKSTATE");
            selectFieldFilter1.setCondOp("EQ");
            selectFieldFilter1.setCondObjectValue((Object)10);
            selectGroupFilter.getSelectFilterList(true).add(selectFieldFilter1);
            SelectFieldFilter selectFieldFilter2 = new SelectFieldFilter();
            selectFieldFilter2.setDEFName("TASKSTATE");
            selectFieldFilter2.setCondOp("EQ");
            selectFieldFilter2.setCondObjectValue((Object)20);
            selectGroupFilter.getSelectFilterList(true).add(selectFieldFilter2);
            selectContext.setSelectFilter((ISelectFilter)selectGroupFilter);
            selectContext.setConditon("PSTASKSERVERID", (Object)PSTaskServerEnvImpl.getCurrent().getId());
            selectContext.setOrderInfo("ORDER BY CREATEDATE DESC");
            selectContext.setMaxRowCount(100);
            HashMap<String, PSDevSlnSys> psDevSlnSysMap = new HashMap<String, PSDevSlnSys>();
            String strCancelInfo = "\u4efb\u52a1\u670d\u52a1\u5668\u91cd\u65b0\u8c03\u5ea6\u53d6\u6d88\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            ArrayList psBKTaskLogList = psBKTaskLogService.selectEx((ISelectContext)selectContext);
            for (PSBKTaskLog psBKTaskLog : psBKTaskLogList) {
                try {
                    if (StringHelper.Compare((String)"PSSYSDEVBKTASK", (String)psBKTaskLog.getTaskCat(), (boolean)true) == 0) {
                        if (StringHelper.IsNullOrEmpty((String)psBKTaskLog.getPSDevSlnSysId())) continue;
                        PSDevSlnSys psDevSlnSys = (PSDevSlnSys)psDevSlnSysMap.get(psBKTaskLog.getPSDevSlnSysId());
                        if (psDevSlnSys == null) {
                            psDevSlnSys = new PSDevSlnSys();
                            psDevSlnSys.setPSDevSlnSysId(psBKTaskLog.getPSDevSlnSysId());
                            if (!psDevSlnSys.get(true)) continue;
                            psDevSlnSysMap.put(psBKTaskLog.getPSDevSlnSysId(), psDevSlnSys);
                        }
                        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) continue;
                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst)psDevSlnSys.getPSSysModelInst());
                        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                        psSysDevBKTask.setSessionFactory(sessionFactory);
                        psSysDevBKTask.setPSSysDevBKTaskId(psBKTaskLog.getPSBKTaskLogId());
                        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                        psSysDevBKTask.setResultInfo(strCancelInfo);
                        psSysDevBKTask.update();
                        continue;
                    }
                    if (StringHelper.Compare((String)"PSDCBKTASK", (String)psBKTaskLog.getTaskCat(), (boolean)true) != 0) continue;
                    PSDCBKTask psDCBKTask = new PSDCBKTask();
                    psDCBKTask.setPSDCBKTaskId(psBKTaskLog.getPSBKTaskLogId());
                    psDCBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                    psDCBKTask.setResultInfo(strCancelInfo);
                    psDCBKTask.update();
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u4efb\u52a1\u670d\u52a1\u5668\u6700\u540e\u8fd0\u884c\u4efb\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psBKTaskLog.getPSBKTaskLogId(), (Object)ex.getMessage()), (Throwable)ex);
                    try {
                        PSBKTaskLog psBKTaskLog2 = new PSBKTaskLog();
                        psBKTaskLog2.setPSBKTaskLogId(psBKTaskLog.getPSBKTaskLogId());
                        psBKTaskLog2.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                        psBKTaskLog2.setResultInfo(strCancelInfo);
                        psBKTaskLog2.update();
                    }
                    catch (Exception ex2) {
                        log.error((Object)StringHelper.Format((String)"\u76f4\u63a5\u53d6\u6d88\u4efb\u52a1\u670d\u52a1\u5668\u6700\u540e\u8fd0\u884c\u4efb\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psBKTaskLog.getPSBKTaskLogId(), (Object)ex.getMessage()), (Throwable)ex);
                    }
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d6\u6d88\u4efb\u52a1\u670d\u52a1\u5668\u6700\u540e\u8fd0\u884c\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected void createDefaultPSTaskServerLog() {
        try {
            this.psTaskServerLogService = (PSTaskServerLogService)ServiceGlobal.getService(PSTaskServerLogService.class);
            PSTaskServerLog psTaskServerLog = new PSTaskServerLog();
            psTaskServerLog.setPSTaskServerLogId(this.psTaskServer.getPSTaskServerId());
            if (this.psTaskServerLogService.checkKey((IEntity)psTaskServerLog) == 0) {
                psTaskServerLog.setDefaultFlag(Integer.valueOf(1));
                psTaskServerLog.setPSTaskServerLogName(StringHelper.Format((String)"[%1$s]\u9ed8\u8ba4\u65e5\u5fd7", (Object)this.psTaskServer.getPSTaskServerName()));
                psTaskServerLog.setPSTaskServerId(this.psTaskServer.getPSTaskServerId());
                psTaskServerLog.setPSTaskServerName(this.psTaskServer.getPSTaskServerName());
                this.psTaskServerLogService.create((IEntity)psTaskServerLog);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acbTask\u670d\u52a1\u5668\u9ed8\u8ba4\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void createPSTaskServerLog(boolean bStartup) {
        this.checkGlobalConfigVer();
        try {
            PSBKTaskGlobalInfo sysBKTaskGlobalInfo;
            PSBKTaskGlobalInfo dcBKTaskGlobalInfo = this.getPSDevCenterBKTaskGlobal().getPSBKTaskGlobalInfo();
            String strInfo = dcBKTaskGlobalInfo.getInfo();
            if (!StringHelper.IsNullOrEmpty((String)strInfo)) {
                log.info((Object)("\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1:\r\n" + strInfo));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strInfo = (sysBKTaskGlobalInfo = this.getPSSysDevBKTaskGlobal().getPSBKTaskGlobalInfo()).getInfo()))) {
                log.info((Object)("\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1:\r\n" + strInfo));
            }
            this.nLastLogTime = System.currentTimeMillis();
            PSTaskServerLog psTaskServerLog = new PSTaskServerLog();
            psTaskServerLog.setDefaultFlag(Integer.valueOf(0));
            if (bStartup) {
                psTaskServerLog.setPSTaskServerLogName(StringHelper.Format((String)"***********>> \u7cfb\u7edf\u542f\u52a8 @[%1$s] ", (Object)this.psTaskServer.getPSTaskServerName()));
            } else {
                psTaskServerLog.setPSTaskServerLogName(StringHelper.Format((String)">> \u7cfb\u7edf\u8fd0\u884c @[%1$s] ", (Object)this.psTaskServer.getPSTaskServerName()));
            }
            psTaskServerLog.setPSTaskServerId(this.psTaskServer.getPSTaskServerId());
            psTaskServerLog.setPSTaskServerName(this.psTaskServer.getPSTaskServerName());
            Runtime runtime = Runtime.getRuntime();
            psTaskServerLog.setTotalMemory(Integer.valueOf((int)(runtime.totalMemory() / 0x100000L)));
            psTaskServerLog.setFreeMemory(Integer.valueOf((int)(runtime.freeMemory() / 0x100000L)));
            psTaskServerLog.setMaxMemory(Integer.valueOf((int)(runtime.maxMemory() / 0x100000L)));
            psTaskServerLog.setSysModelInstCnt(Integer.valueOf(PSSysModelInstGlobal.getSessionFactoryCount()));
            psTaskServerLog.setDCCnt(Integer.valueOf(this.psDevCenterGlobalModel.getModelCount()));
            psTaskServerLog.setSysModelCnt(Integer.valueOf(this.psDevSlnSysGlobalModelMap.size()));
            psTaskServerLog.setDBDevInstCnt(Integer.valueOf(PSDBDevInstGlobal.getSessionFactoryCount() + this.psDBDevInstGlobalModel.getModelCount()));
            psTaskServerLog.setRobotCnt(Integer.valueOf(this.psRobotGlobalModel.getModelCount()));
            psTaskServerLog.setDCTaskQueueCnt(Integer.valueOf(dcBKTaskGlobalInfo.getSessionCount()));
            psTaskServerLog.setDCTaskQueueCnt2(Integer.valueOf(dcBKTaskGlobalInfo.getRunningCount()));
            psTaskServerLog.setDCTaskQueueCnt3(Integer.valueOf(dcBKTaskGlobalInfo.getQueueCount()));
            psTaskServerLog.setSysTaskQueueCnt(Integer.valueOf(sysBKTaskGlobalInfo.getSessionCount()));
            psTaskServerLog.setSysTaskQueueCnt2(Integer.valueOf(sysBKTaskGlobalInfo.getRunningCount()));
            psTaskServerLog.setSysTaskQueueCnt3(Integer.valueOf(sysBKTaskGlobalInfo.getQueueCount()));
            psTaskServerLog.setSysModelHelperCnt(Integer.valueOf(PSObjectFactory.getPSModelHelperCount()));
            if (this.psASBookingDispatcher != null) {
                PSBKTaskGlobalInfo psASBookingDispatcherInfo = this.psASBookingDispatcher.getPSBKTaskGlobalInfo();
                psTaskServerLog.setASBookingQueueCnt(Integer.valueOf(psASBookingDispatcherInfo.getSessionCount()));
                psTaskServerLog.setASBookingQueueCnt2(Integer.valueOf(psASBookingDispatcherInfo.getRunningCount()));
            }
            if (this.psDSBookingDispatcher != null) {
                PSBKTaskGlobalInfo psDSBookingDispatcherInfo = this.psDSBookingDispatcher.getPSBKTaskGlobalInfo();
                psTaskServerLog.setDSBookingQueueCnt(Integer.valueOf(psDSBookingDispatcherInfo.getSessionCount()));
                psTaskServerLog.setDSBookingQueueCnt2(Integer.valueOf(psDSBookingDispatcherInfo.getRunningCount()));
            }
            ArrayList<String> psDevSlnSysIdList = new ArrayList<String>();
            this.waitLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            HashMap<String, PSDevSlnSysGlobalModel> hashMap = this.psDevSlnSysGlobalModelMap;
            synchronized (hashMap) {
                psDevSlnSysIdList.addAll(this.psDevSlnSysGlobalModelMap.keySet());
                this.enterAndLeaveLock(this.lock_psDevSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            }
            int nJITCount = 0;
            for (String strPSDevSlnSysId : psDevSlnSysIdList) {
                try {
                    IPSDevSlnSys iPSDevSlnSys = this.getCachePSDevSlnSys(strPSDevSlnSysId);
                    if (iPSDevSlnSys == null || !((IPSSystemUtil)((Object)iPSDevSlnSys)).hasPSJITSystemModel()) continue;
                    ++nJITCount;
                }
                catch (Exception e) {
                    log.error((Object)e);
                }
            }
            psTaskServerLog.setJITSysCnt(Integer.valueOf(nJITCount));
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            int nThreadCount = threadMXBean.getThreadCount();
            psTaskServerLog.setThreadCnt(Integer.valueOf(nThreadCount));
            psTaskServerLog.setLogTime(new Timestamp(System.currentTimeMillis()));
            this.psTaskServerLogService.create((IEntity)psTaskServerLog, false);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acbTask\u670d\u52a1\u5668\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected final void waitLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().wait(objLock, strLockInfo);
    }

    protected final void enterLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enter(objLock, strLockInfo);
    }

    protected final void leaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().leave(objLock, strLockInfo);
    }

    protected final void enterAndLeaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enterAndLeave(objLock, strLockInfo);
    }

    protected Object getBean(String strName) {
        if (this.getDAGlobalHelper() instanceof GlobalHelperEx) {
            GlobalHelperEx globalHelperEx = (GlobalHelperEx)this.getDAGlobalHelper();
            WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)globalHelperEx.getServletContext());
            return ctx.getBean(strName);
        }
        return null;
    }

    protected void checkGlobalConfigVer() {
        int nCurGlobalConfigVer;
        if (this.iPSTaskServerEnv != null && (nCurGlobalConfigVer = this.iPSTaskServerEnv.getGlobalConfigVer()) != this.nGlobalConfigVer) {
            log.info((Object)StringHelper.Format((String)"\u4efb\u52a1\u670d\u52a1\u5668[%1$s]\u914d\u7f6e\u7248\u672c[%2$s]\u4e0e\u5168\u5c40\u7248\u672c[%3$s]\u4e0d\u4e00\u81f4\uff0c\u6267\u884c\u914d\u7f6e\u5237\u65b0", (Object)this.iPSTaskServerEnv.getId(), (Object)this.nGlobalConfigVer, (Object)nCurGlobalConfigVer));
            try {
                this.psPFPreviewNodeGlobal.reload();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u91cd\u65b0\u52a0\u8f7d\u9884\u89c8\u8282\u70b9\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            this.psRobotWorkTypeGlobalModel.ResetAll();
            this.psBookingResTypeGlobalModel.ResetAll();
            this.psRobotGlobalModel.ResetAll();
            this.psDevCenterGlobalModel.ResetAll();
            this.psGitUserGlobalModel.ResetAll();
            this.psMavenServerGlobalModel.ResetAll();
            this.psSVNServerGlobalModel.ResetAll();
            this.psSysEngineConfigGlobalModel.ResetAll();
            this.psAppTypeGlobalModel.ResetAll();
            this.psPFCDNGlobalModel.ResetAll();
            this.psPFGlobalModel.ResetAll();
            this.psSFGlobalModel.ResetAll();
            this.psSFPluginTemplGlobalModel.ResetAll();
            this.psPFPluginTemplGlobalModel.ResetAll();
            this.psSysDevBTTypeGlobalModel.ResetAll();
            this.psDevCenterBTTypeGlobalModel.ResetAll();
            this.psDepSysTypeGlobalModel.ResetAll();
            this.psDEDQPDCondTypeGlobalModel.ResetAll();
            this.psDEFieldTypeGlobalModel.ResetAll();
            this.psSysIssueEngineGlobalModel.ResetAll();
            this.psViewTypeGlobalModel.ResetAll();
            this.psViewEngineGlobalModel.ResetAll();
            this.psControlTypeGlobalModel.ResetAll();
            this.psHelpArticleTemplGlobalModel.ResetAll();
            this.psHelpSectionTemplGlobalModel.ResetAll();
            this.psHelpPrjTemplGlobalModel.ResetAll();
            this.psHelpArticleTypeGlobalModel.ResetAll();
            this.psHelpSectionTypeGlobalModel.ResetAll();
            this.psHelpPrjTypeGlobalModel.ResetAll();
            this.psDepSlnPrdGlobalModel.ResetAll();
            this.psDEGridColumnTypeGlobalModel.ResetAll();
            this.psDETreeNodeTypeGlobalModel.ResetAll();
            this.psPFPluginTypeGlobalModel.ResetAll();
            this.psBackServiceGlobalModel.ResetAll();
            this.psSubSysGlobalModel.ResetAll();
            this.psModelInitGlobalModel.ResetAll();
            this.psCounterTypeGlobalModel.ResetAll();
            this.psCounterGlobalModel.ResetAll();
            this.psDEUIActionTypeGlobalModel.ResetAll();
            this.psDELogicLinkTypeGlobalModel.ResetAll();
            this.psDELogicNodeTypeGlobalModel.ResetAll();
            this.psUIEngineTypeGlobalModel.ResetAll();
            this.psSysUtilTypeGlobalModel.ResetAll();
            this.psAppUtilTypeGlobalModel.ResetAll();
            this.psWFLinkCondTypeGlobalModel.ResetAll();
            this.psWFLinkTypeGlobalModel.ResetAll();
            this.psWFProcessTypeGlobalModel.ResetAll();
            this.psPortletTypeGlobalModel.ResetAll();
            this.psAppServerTypeGlobalModel.ResetAll();
            this.psMavenServerTypeGlobalModel.ResetAll();
            this.psDevServerTypeGlobalModel.ResetAll();
            this.psDERTypeGlobalModel.ResetAll();
            this.psToolbarItemTypeGlobalModel.ResetAll();
            this.psFormTypeGlobalModel.ResetAll();
            this.psFDLogicTypeGlobalModel.ResetAll();
            this.psPanelItemLogicTypeGlobalModel.ResetAll();
            this.psFormDetailTypeGlobalModel.ResetAll();
            this.psPanelDetailTypeGlobalModel.ResetAll();
            this.psAppMenuItemTypeGlobalModel.ResetAll();
            this.psDBValueFuncGlobalModel.ResetAll();
            this.psDEJoinTypeGlobalModel.ResetAll();
            this.psDBDevInstGlobalModel.ResetAll();
            this.psMobAppPackServerGlobalModel.ResetAll();
            this.psDeployServerGlobalModel.ResetAll();
            this.psWorkshopServerGlobalModel.ResetAll();
            this.psDeployCenterGlobalModel.ResetAll();
            this.psAppServerGlobalModel.ResetAll();
            this.psDBServerGlobalModel.ResetAll();
            this.psMQInstGlobalModel.ResetAll();
            this.psASGroupGlobalModel.ResetAll();
            this.psDEActionTypeGlobalModel.ResetAll();
            this.psViewLogicTypeGlobalModel.ResetAll();
            this.psDEFValueRuleTypeGlobalModel.ResetAll();
            this.psDBValueOPGlobalModel.ResetAll();
            this.psDRItemTypeGlobalModel.ResetAll();
            this.psDBSysProcTypeGlobalModel.ResetAll();
            this.psEditorTypeGlobalModel.ResetAll();
            this.psDELogicLinkCondTypeGlobalModel.ResetAll();
            this.psCodeSnippetTypeGlobalModel.ResetAll();
            this.psDCCodeSnippetGlobalModel.ResetAll();
            this.psMSPlatformGlobalModel.ResetAll();
            this.psDCMSPlatformGlobalModel.ResetAll();
            this.psDevSlnMSDepAppGlobalModel.ResetAll();
            this.psDevSlnMSDepAPIGlobalModel.ResetAll();
            this.psDevSlnMSDepFuncGlobalModel.ResetAll();
            this.psPanelLogicLinkTypeGlobalModel.ResetAll();
            this.psPanelLogicNodeTypeGlobalModel.ResetAll();
            this.psPanelLogicLinkCondTypeGlobalModel.ResetAll();
            this.psWorkspaceTypeGlobalModel.ResetAll();
            this.psDCWorkspaceGlobalModel.ResetAll();
            this.psDCClusterGlobalModel.ResetAll();
            this.nGlobalConfigVer = nCurGlobalConfigVer;
        }
    }

    protected void checkGlobalConfig() throws Exception {
        this.psDBTypeGlobalModel.FindModelHelper("TEST", true);
        this.psModelGlobalModel.FindModelHelper("TEST", true);
        this.psRobotWorkTypeGlobalModel.FindModelHelper("TEST", true);
        this.psBookingResTypeGlobalModel.FindModelHelper("TEST", true);
        this.psRobotGlobalModel.FindModelHelper("TEST", true);
        this.psDevCenterGlobalModel.FindModelHelper("TEST", true);
        this.psGitUserGlobalModel.FindModelHelper("TEST", true);
        this.psMavenServerGlobalModel.FindModelHelper("TEST", true);
        this.psSVNServerGlobalModel.FindModelHelper("TEST", true);
        this.psSysEngineConfigGlobalModel.FindModelHelper("TEST", true);
        this.psAppTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPFCDNGlobalModel.FindModelHelper("TEST", true);
        this.psPFGlobalModel.FindModelHelper("TEST", true);
        this.psSFGlobalModel.FindModelHelper("TEST", true);
        this.psSFPluginTemplGlobalModel.FindModelHelper("TEST", true);
        this.psPFPluginTemplGlobalModel.FindModelHelper("TEST", true);
        this.psSysDevBTTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDevCenterBTTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDepSysTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDEDQPDCondTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDEFieldTypeGlobalModel.FindModelHelper("TEST", true);
        this.psSysIssueEngineGlobalModel.FindModelHelper("TEST", true);
        this.psViewTypeGlobalModel.FindModelHelper("TEST", true);
        this.psViewEngineGlobalModel.FindModelHelper("TEST", true);
        this.psControlTypeGlobalModel.FindModelHelper("TEST", true);
        this.psHelpArticleTemplGlobalModel.FindModelHelper("TEST", true);
        this.psHelpSectionTemplGlobalModel.FindModelHelper("TEST", true);
        this.psHelpPrjTemplGlobalModel.FindModelHelper("TEST", true);
        this.psHelpArticleTypeGlobalModel.FindModelHelper("TEST", true);
        this.psHelpSectionTypeGlobalModel.FindModelHelper("TEST", true);
        this.psHelpPrjTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDepSlnPrdGlobalModel.FindModelHelper("TEST", true);
        this.psDEGridColumnTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDETreeNodeTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPFPluginTypeGlobalModel.FindModelHelper("TEST", true);
        this.psBackServiceGlobalModel.FindModelHelper("TEST", true);
        this.psSystemGlobalModel.FindModelHelper("TEST", true);
        this.psSubSysGlobalModel.FindModelHelper("TEST", true);
        this.psModelInitGlobalModel.FindModelHelper("TEST", true);
        this.psCounterTypeGlobalModel.FindModelHelper("TEST", true);
        this.psCounterGlobalModel.FindModelHelper("TEST", true);
        this.psDEUIActionTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDELogicLinkTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDELogicNodeTypeGlobalModel.FindModelHelper("TEST", true);
        this.psUIEngineTypeGlobalModel.FindModelHelper("TEST", true);
        this.psSysUtilTypeGlobalModel.FindModelHelper("TEST", true);
        this.psAppUtilTypeGlobalModel.FindModelHelper("TEST", true);
        this.psWFLinkCondTypeGlobalModel.FindModelHelper("TEST", true);
        this.psWFLinkTypeGlobalModel.FindModelHelper("TEST", true);
        this.psWFProcessTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPortletTypeGlobalModel.FindModelHelper("TEST", true);
        this.psAppServerTypeGlobalModel.FindModelHelper("TEST", true);
        this.psMavenServerTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDevServerTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDERTypeGlobalModel.FindModelHelper("TEST", true);
        this.psToolbarItemTypeGlobalModel.FindModelHelper("TEST", true);
        this.psFormTypeGlobalModel.FindModelHelper("TEST", true);
        this.psFDLogicTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPanelItemLogicTypeGlobalModel.FindModelHelper("TEST", true);
        this.psFormDetailTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPanelDetailTypeGlobalModel.FindModelHelper("TEST", true);
        this.psAppMenuItemTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDBValueFuncGlobalModel.FindModelHelper("TEST", true);
        this.psDEJoinTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDBDevInstGlobalModel.FindModelHelper("TEST", true);
        this.psMobAppPackServerGlobalModel.FindModelHelper("TEST", true);
        this.psDeployServerGlobalModel.FindModelHelper("TEST", true);
        this.psWorkshopServerGlobalModel.FindModelHelper("TEST", true);
        this.psDeployCenterGlobalModel.FindModelHelper("TEST", true);
        this.psAppServerGlobalModel.FindModelHelper("TEST", true);
        this.psDBServerGlobalModel.FindModelHelper("TEST", true);
        this.psMQInstGlobalModel.FindModelHelper("TEST", true);
        this.psASGroupGlobalModel.FindModelHelper("TEST", true);
        this.psDEActionTypeGlobalModel.FindModelHelper("TEST", true);
        this.psViewLogicTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDEFValueRuleTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDBValueOPGlobalModel.FindModelHelper("TEST", true);
        this.psDRItemTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDBSysProcTypeGlobalModel.FindModelHelper("TEST", true);
        this.psEditorTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDELogicLinkCondTypeGlobalModel.FindModelHelper("TEST", true);
        this.psCodeSnippetTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDCCodeSnippetGlobalModel.FindModelHelper("TEST", true);
        this.psMSPlatformGlobalModel.FindModelHelper("TEST", true);
        this.psDCMSPlatformGlobalModel.FindModelHelper("TEST", true);
        this.psDevSlnMSDepAppGlobalModel.FindModelHelper("TEST", true);
        this.psDevSlnMSDepAPIGlobalModel.FindModelHelper("TEST", true);
        this.psDevSlnMSDepFuncGlobalModel.FindModelHelper("TEST", true);
        this.psPanelLogicLinkTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPanelLogicNodeTypeGlobalModel.FindModelHelper("TEST", true);
        this.psPanelLogicLinkCondTypeGlobalModel.FindModelHelper("TEST", true);
        this.psWorkspaceTypeGlobalModel.FindModelHelper("TEST", true);
        this.psDCWorkspaceGlobalModel.FindModelHelper("TEST", true);
        this.psDCClusterGlobalModel.FindModelHelper("TEST", true);
    }
}

