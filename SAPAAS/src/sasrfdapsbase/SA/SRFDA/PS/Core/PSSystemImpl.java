/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLoadLog
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryGlobalModel;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModel;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeGlobalModel;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeGlobalModel;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.BackService.PSSysBackServiceGlobalModel;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.CodeList.PSCodeListGlobalModel;
import SA.SRFDA.PS.Core.CodeList.PSThresholdGroupGlobalModel;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.Control.Ajax.PSSysAjaxControlHandlerGlobalModel;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterGlobalModel;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSSysDEFType;
import SA.SRFDA.PS.Core.DEField.PSSysDEFTypeGlobalModel;
import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DTS.PSSysDTSQueueGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionTemplGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.PSSysDERGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityRuntime;
import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityImpl;
import SA.SRFDA.PS.Core.DataEntity.PSSysDEGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSSysDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSSysDEOPPrivGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSSysDEUIActionGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSSysDEUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSSysDMItem;
import SA.SRFDA.PS.Core.Database.IPSSysDMVer;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.PSDBDevInstGlobal;
import SA.SRFDA.PS.Core.Database.PSSysDBSchemeGlobalModel;
import SA.SRFDA.PS.Core.Database.PSSysDBValueFuncGlobalModel;
import SA.SRFDA.PS.Core.Database.PSSysDMItemGlobalModel;
import SA.SRFDA.PS.Core.Database.PSSysDMVerGlobalModel;
import SA.SRFDA.PS.Core.Database.PSSystemDBConfigGlobalModel;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.Deploy.IPSSystemAS;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSSystemASGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSSystemDeployGlobalModel;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelGlobalModel;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.DynaSys.PSDynaDETemplGlobalModel;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeGlobalModel;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.ER.PSSysERMapGlobalModel;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.Help.PSHelpArticleGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpPrjGlobalModel;
import SA.SRFDA.PS.Core.Help.PSHelpResourceGlobalModel;
import SA.SRFDA.PS.Core.IPSDepSlnPrd;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSJITSystem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemContainer;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Issue.IPSSysIssueEngine;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFDA.PS.Core.Log.PSLogItemImpl;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.Msg.PSSysMsgQueueGlobalModel;
import SA.SRFDA.PS.Core.Msg.PSSysMsgTargetGlobalModel;
import SA.SRFDA.PS.Core.Msg.PSSysMsgTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSModelHelperImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemException;
import SA.SRFDA.PS.Core.PSSystemSettingProxy;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubGlobalModel;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Requirement.PSSysReqItemGlobalModel;
import SA.SRFDA.PS.Core.Requirement.PSSysReqModuleGlobalModel;
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
import SA.SRFDA.PS.Core.Res.PSCtrlMsgGlobalModel;
import SA.SRFDA.PS.Core.Res.PSDEFInputTipSetGlobalModel;
import SA.SRFDA.PS.Core.Res.PSLanguageItemGlobalModel;
import SA.SRFDA.PS.Core.Res.PSLanguageResGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSubViewTypeGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysChartThemeGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysContentCatGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysCssGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysDEFInputTipGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysDataSyncAgentGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysDictCatGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysEditorStyleGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysFileGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysI18NImpl;
import SA.SRFDA.PS.Core.Res.PSSysImageGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysLanGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysLogicGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysPDTViewGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysPFPluginGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysPFPluginTemplGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysPortletCatGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysPortletGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysResourceGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysSFPluginGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysSFPluginTemplGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysSampleValueGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysSequenceGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysTranslatorGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysUniStateGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysUnitGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysUtilGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysViewLogicGlobalModel;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleUtil;
import SA.SRFDA.PS.Core.SF.PSSFImpl;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeGlobalModel;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.PSSysUniResGlobalModel;
import SA.SRFDA.PS.Core.Security.PSSysUserDRGlobalModel;
import SA.SRFDA.PS.Core.Security.PSSysUserModeGlobalModel;
import SA.SRFDA.PS.Core.Security.PSSysUserRoleGlobalModel;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIGlobalModel;
import SA.SRFDA.PS.Core.Service.PSSysMethodDTOImpl;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIGlobalModel;
import SA.SRFDA.PS.Core.Service.PSSysServiceAPIHandlerGlobalModel;
import SA.SRFDA.PS.Core.System.IPSSubSysRef;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.System.PSSubSysRefGlobalModel;
import SA.SRFDA.PS.Core.System.PSSysModelGroupGlobalModel;
import SA.SRFDA.PS.Core.System.PSSysRefGlobalModel;
import SA.SRFDA.PS.Core.System.PSSystemModuleGlobalModel;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Testing.PSSysTestCaseGlobalModel;
import SA.SRFDA.PS.Core.Testing.PSSysTestDataGlobalModel;
import SA.SRFDA.PS.Core.Testing.PSSysTestPrjGlobalModel;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.PSSysActorGlobalModel;
import SA.SRFDA.PS.Core.UML.PSSysUCMapGlobalModel;
import SA.SRFDA.PS.Core.UML.PSSysUseCaseGlobalModel;
import SA.SRFDA.PS.Core.UML.PSSysUseCaseRSGlobalModel;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.ValueRule.PSSysValueRuleGlobalModel;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.PSViewMsgGlobalModel;
import SA.SRFDA.PS.Core.View.PSViewMsgGroupGlobalModel;
import SA.SRFDA.PS.Core.WF.IPSSysWFSetting;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.PSSysWFSettingImpl;
import SA.SRFDA.PS.Core.WF.PSWFRoleGlobalModel;
import SA.SRFDA.PS.Core.WF.PSWFWorkTimeGlobalModel;
import SA.SRFDA.PS.Core.WF.PSWorkflowGlobalModel;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.PSWXAccountGlobalModel;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.PS.Data.PSSysWFSetting;
import SA.SRFDA.PS.Version;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLoadLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSystemImpl
extends PSObjectImpl
implements IPSSystem,
IPSSystemUtil,
IPSSystemSetting,
IPSSystemRuntime,
IPSJITSystem,
IPSSFPubSupportable,
IPSDynaInstSupportable {
    private static final Log log = LogFactory.getLog(PSSystemImpl.class);
    public static final String MODELGROUP_REQ = "\u9700\u6c42&\u7528\u4f8b";
    public static final String MODELGROUP_MODEL = "\u6570\u636e\u6a21\u578b";
    public static final String MODELGROUP_PFSF = "\u524d\u7aef&\u540e\u53f0";
    public static final String MODELGROUP_DB = "\u6570\u636e\u5e93\u5b58\u50a8";
    public static final String MODELGROUP_WF = "\u5de5\u4f5c\u6d41";
    public static final String MODELGROUP_ADVUTIL = "\u9ad8\u7ea7\u7ec4\u4ef6";
    public static final String MODELGROUP_MSG = "\u6d88\u606f";
    public static final String MODELGROUP_ACCCTRL = "\u8bbf\u95ee\u63a7\u5236";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String MODELGROUP_ADVMODEL = "\u6a21\u578b\u9ad8\u7ea7";
    public static final String MODELGROUP_LOGIC = "\u5904\u7406\u903b\u8f91";
    public static final String MODELGROUP_PFSFPLUGIN = "\u6a21\u677f\u6269\u5c55";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u9700\u6c42&\u7528\u4f8b", "\u6570\u636e\u6a21\u578b", "\u524d\u7aef&\u540e\u53f0", "\u6570\u636e\u5e93\u5b58\u50a8", "\u5de5\u4f5c\u6d41", "\u9ad8\u7ea7\u7ec4\u4ef6", "\u6d88\u606f", "\u8bbf\u95ee\u63a7\u5236", "\u6d4b\u8bd5", "\u6a21\u578b\u9ad8\u7ea7", "\u5904\u7406\u903b\u8f91", "\u6a21\u677f\u6269\u5c55", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_REQ = 150;
    public static final int MODELORDER_MODEL = 180;
    public static final int MODELORDER_PFSF = 210;
    public static final int MODELORDER_DB = 250;
    public static final int MODELORDER_API = 280;
    public static final int MODELORDER_WF = 310;
    public static final int MODELORDER_ADVUTIL = 340;
    public static final int MODELORDER_MSG = 370;
    public static final int MODELORDER_ACCCTRL = 400;
    public static final int MODELORDER_TEST = 430;
    public static final int MODELORDER_ADVMODEL = 460;
    public static final int MODELORDER_LOGIC = 490;
    public static final int MODELORDER_PFSFPLUGIN = 520;
    protected SA.SRFDA.PS.Data.PSSystem psSystem = null;
    protected PSCodeListGlobalModel psCodeListGlobalModel = new PSCodeListGlobalModel();
    protected PSThresholdGroupGlobalModel psThresholdGroupGlobalModel = new PSThresholdGroupGlobalModel();
    protected PSSysImageGlobalModel psSysImageGlobalModel = new PSSysImageGlobalModel();
    protected PSSysCssGlobalModel psSysCssGlobalModel = new PSSysCssGlobalModel();
    protected PSSysChartThemeGlobalModel psSysChartThemeGlobalModel = new PSSysChartThemeGlobalModel();
    protected PSCtrlMsgGlobalModel psCtrlMsgGlobalModel = new PSCtrlMsgGlobalModel();
    protected PSSysUnitGlobalModel psSysUnitGlobalModel = new PSSysUnitGlobalModel();
    protected PSSysFileGlobalModel psSysFileGlobalModel = new PSSysFileGlobalModel();
    protected PSSysDEFTypeGlobalModel psSysDEFTypeGlobalModel = new PSSysDEFTypeGlobalModel();
    protected PSSysLanGlobalModel psSysLanGlobalModel = new PSSysLanGlobalModel();
    protected PSLanguageResGlobalModel psLanguageResGlobalModel = new PSLanguageResGlobalModel();
    protected PSLanguageItemGlobalModel psLanguageItemGlobalModel = new PSLanguageItemGlobalModel();
    protected PSSysValueRuleGlobalModel psSysValueRuleGlobalModel = new PSSysValueRuleGlobalModel();
    protected PSSysPortletGlobalModel psSysPortletGlobalModel = new PSSysPortletGlobalModel();
    protected PSSysPDTViewGlobalModel psSysPDTViewGlobalModel = new PSSysPDTViewGlobalModel();
    protected PSSysViewLogicGlobalModel psSysViewLogicGlobalModel = new PSSysViewLogicGlobalModel();
    protected PSApplicationGlobalModel psSystemApplicationGlobalModel = new PSApplicationGlobalModel();
    protected PSApplicationGlobalModel gitPSSystemApplicationGlobalModel = new PSApplicationGlobalModel();
    protected PSSystemDBConfigGlobalModel psSystemDBConfigGlobalModel = new PSSystemDBConfigGlobalModel();
    protected PSSysDMVerGlobalModel psSysDMVerGlobalModel = new PSSysDMVerGlobalModel();
    protected PSSysDMItemGlobalModel psSysDMItemGlobalModel = new PSSysDMItemGlobalModel();
    protected PSSystemDeployGlobalModel psSystemDeployGlobalModel = new PSSystemDeployGlobalModel();
    protected PSSysDEUIActionGlobalModel psSysDEUIActionGlobalModel = new PSSysDEUIActionGlobalModel();
    protected PSSysDEUIActionGroupGlobalModel psSysDEUIActionGroupGlobalModel = new PSSysDEUIActionGroupGlobalModel();
    protected PSSysAjaxControlHandlerGlobalModel psSysAjaxControlHandlerGlobalModel = new PSSysAjaxControlHandlerGlobalModel();
    protected PSSystemModuleGlobalModel psSystemModuleGlobalModel = new PSSystemModuleGlobalModel();
    protected PSSysRefGlobalModel psSysRefGlobalModel = new PSSysRefGlobalModel();
    protected PSWorkflowGlobalModel psWorkflowGlobalModel = new PSWorkflowGlobalModel();
    protected PSWFRoleGlobalModel psWFRoleGlobalModel = new PSWFRoleGlobalModel();
    protected PSWFWorkTimeGlobalModel psWFWorkTimeGlobalModel = new PSWFWorkTimeGlobalModel();
    protected PSSystemASGlobalModel psSystemASGlobalModel = new PSSystemASGlobalModel();
    protected PSSubSysRefGlobalModel psSubSysRefGlobalModel = new PSSubSysRefGlobalModel();
    protected PSSysDictCatGlobalModel psSysDictCatGlobalModel = new PSSysDictCatGlobalModel();
    protected PSSubViewTypeGlobalModel psSubViewTypeGlobalModel = new PSSubViewTypeGlobalModel();
    protected PSSysUniResGlobalModel psSysUniResGlobalModel = new PSSysUniResGlobalModel();
    protected PSSysMsgTemplGlobalModel psSysMsgTemplGlobalModel = new PSSysMsgTemplGlobalModel();
    protected PSSysPFPluginGlobalModel psSysPFPluginGlobalModel = new PSSysPFPluginGlobalModel();
    protected PSSysPFPluginTemplGlobalModel psSysPFPluginTemplGlobalModel = new PSSysPFPluginTemplGlobalModel();
    protected PSSysCounterGlobalModel psSysCounterGlobalModel = new PSSysCounterGlobalModel();
    protected PSSysEditorStyleGlobalModel psSysEditorStyleGlobalModel = new PSSysEditorStyleGlobalModel();
    private final Hashtable<String, IPSDataEntity> psDataEntityMap = new Hashtable();
    private final Hashtable<String, Long> psDataEntityRenewMap = new Hashtable();
    protected PSSysDEOPPrivGlobalModel psDEOPPrivGlobalModel = new PSSysDEOPPrivGlobalModel();
    protected ArrayList<String> supportDBTypeList = new ArrayList();
    private PSDERGlobalModel psDERGlobalModel = new PSDERGlobalModel();
    private PSSysDBValueFuncGlobalModel psSysDBValueFuncGlobalModel = new PSSysDBValueFuncGlobalModel();
    private PSSysBackServiceGlobalModel psSysBackServiceGlobalModel = new PSSysBackServiceGlobalModel();
    private PSSysActorGlobalModel psSysActorGlobalModel = new PSSysActorGlobalModel();
    private PSSysUseCaseGlobalModel psSysUseCaseGlobalModel = new PSSysUseCaseGlobalModel();
    private PSSysUseCaseRSGlobalModel psSysUseCaseRSGlobalModel = new PSSysUseCaseRSGlobalModel();
    private PSSysTestPrjGlobalModel psSysTestPrjGlobalModel = new PSSysTestPrjGlobalModel();
    private PSSysTestCaseGlobalModel psSysTestCaseGlobalModel = new PSSysTestCaseGlobalModel();
    private PSSysTestDataGlobalModel psSysTestDataGlobalModel = new PSSysTestDataGlobalModel();
    private PSSysSampleValueGlobalModel psSysSampleValueGlobalModel = new PSSysSampleValueGlobalModel();
    protected PSSysUserModeGlobalModel psSysUserModeGlobalModel = new PSSysUserModeGlobalModel();
    protected PSSysUserDRGlobalModel psSysUserDRGlobalModel = new PSSysUserDRGlobalModel();
    private PSSysERMapGlobalModel psSysERMapGlobalModel = new PSSysERMapGlobalModel();
    private PSSysUCMapGlobalModel psSysUCMapGlobalModel = new PSSysUCMapGlobalModel();
    private PSSysSFPubGlobalModel psSysSFPubGlobalModel = new PSSysSFPubGlobalModel();
    protected PSSysDataSyncAgentGlobalModel psSysDataSyncAgentGlobalModel = new PSSysDataSyncAgentGlobalModel();
    protected PSSysBDSchemeGlobalModel psSysBDSchemeGlobalModel = new PSSysBDSchemeGlobalModel();
    protected PSSysDEFInputTipGlobalModel psSysDEFInputTipGlobalModel = new PSSysDEFInputTipGlobalModel();
    protected PSViewMsgGroupGlobalModel psViewMsgGroupGlobalModel = new PSViewMsgGroupGlobalModel();
    protected PSViewMsgGlobalModel psViewMsgGlobalModel = new PSViewMsgGlobalModel();
    protected PSDEFInputTipSetGlobalModel psDEFInputTipSetGlobalModel = new PSDEFInputTipSetGlobalModel();
    protected PSWXAccountGlobalModel psWXAccountGlobalModel = new PSWXAccountGlobalModel();
    protected PSHelpArticleGlobalModel psHelpArticleGlobalModel = new PSHelpArticleGlobalModel();
    protected PSHelpPrjGlobalModel psHelpPrjGlobalModel = new PSHelpPrjGlobalModel();
    protected PSHelpResourceGlobalModel psHelpResourceGlobalModel = new PSHelpResourceGlobalModel();
    protected PSSysUniStateGlobalModel psSysUniStateGlobalModel = new PSSysUniStateGlobalModel();
    protected PSSysLogicGlobalModel psSysLogicGlobalModel = new PSSysLogicGlobalModel();
    private PSSysServiceAPIHandlerGlobalModel psSysServiceAPIHandlerGlobalModel = new PSSysServiceAPIHandlerGlobalModel();
    private PSSysServiceAPIGlobalModel psSysServiceAPIGlobalModel = new PSSysServiceAPIGlobalModel();
    private PSSubSysServiceAPIGlobalModel psSubSysServiceAPIGlobalModel = new PSSubSysServiceAPIGlobalModel();
    protected PSSysDTSQueueGlobalModel psSysDTSQueueGlobalModel = new PSSysDTSQueueGlobalModel();
    protected PSSysUserRoleGlobalModel psSysUserRoleGlobalModel = new PSSysUserRoleGlobalModel();
    protected PSSysSFPluginGlobalModel psSysSFPluginGlobalModel = new PSSysSFPluginGlobalModel();
    protected PSSysSFPluginTemplGlobalModel psSysSFPluginTemplGlobalModel = new PSSysSFPluginTemplGlobalModel();
    protected ArrayList<IPSDataEntity> allPSDataEntityList = null;
    private Map<String, IPSSysEditorStyle> defaultPSSysEditorStyleMap = new LinkedHashMap<String, IPSSysEditorStyle>();
    protected PSSysUtilGlobalModel psSysUtilGlobalModel = new PSSysUtilGlobalModel();
    protected PSSysDynaModelGlobalModel psSysDynaModelGlobalModel = new PSSysDynaModelGlobalModel();
    protected PSDEActionTemplGlobalModel psDEActionTemplGlobalModel = new PSDEActionTemplGlobalModel();
    protected PSDynaDETemplGlobalModel psDynaDETemplGlobalModel = new PSDynaDETemplGlobalModel();
    protected PSSysDBSchemeGlobalModel psSysDBSchemeGlobalModel = new PSSysDBSchemeGlobalModel();
    private PSSysResourceGlobalModel psSysResourceGlobalModel = new PSSysResourceGlobalModel();
    private PSSysContentCatGlobalModel psSysContentCatGlobalModel = new PSSysContentCatGlobalModel();
    private PSSysDEGroupGlobalModel psSysDEGroupGlobalModel = new PSSysDEGroupGlobalModel();
    private PSSysDERGroupGlobalModel psSysDERGroupGlobalModel = new PSSysDERGroupGlobalModel();
    private PSSysReqModuleGlobalModel psSysReqModuleGlobalModel = new PSSysReqModuleGlobalModel();
    private PSSysReqItemGlobalModel psSysReqItemGlobalModel = new PSSysReqItemGlobalModel();
    private PSSysModelGroupGlobalModel psSysModelGroupGlobalModel = new PSSysModelGroupGlobalModel();
    private PSSysSearchSchemeGlobalModel psSysSearchSchemeGlobalModel = new PSSysSearchSchemeGlobalModel();
    private PSSysEAISchemeGlobalModel psSysEAISchemeGlobalModel = new PSSysEAISchemeGlobalModel();
    private PSSysBISchemeGlobalModel psSysBISchemeGlobalModel = new PSSysBISchemeGlobalModel();
    private PSSysPortletCatGlobalModel psSysPortletCatGlobalModel = new PSSysPortletCatGlobalModel();
    private PSSysSequenceGlobalModel psSysSequenceGlobalModel = new PSSysSequenceGlobalModel();
    private PSSysTranslatorGlobalModel psSysTranslatorGlobalModel = new PSSysTranslatorGlobalModel();
    private PSSysMsgQueueGlobalModel psSysMsgQueueGlobalModel = new PSSysMsgQueueGlobalModel();
    private PSSysMsgTargetGlobalModel psSysMsgTargetGlobalModel = new PSSysMsgTargetGlobalModel();
    private PSSysAIFactoryGlobalModel psSysAIFactoryGlobalModel = new PSSysAIFactoryGlobalModel();
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private IPSDevSlnSysRuntime iPSDevSlnSysRuntime = null;
    private String strPubSystemId = null;
    private String strVCName = null;
    private String strCodeName = "";
    private IPSSysWFSetting iPSSysWFSetting = null;
    private IPSDepSlnPrd iPSDepSlnPrd = null;
    private IPSSystemUtil iPSSystemUtil = null;
    private int nEngineVer = Version.FUNC;
    private IPSJITSystemModel iPSJITSystemModel = null;
    private Object objPSJITSystemModelLock = new Object();
    private Map<String, ArrayList<PSSysSFCode>> psModelSFCodeListMap = new LinkedHashMap<String, ArrayList<PSSysSFCode>>();
    private Map<String, ArrayList<PSAppViewCode>> psModelPFCodeListMap = new LinkedHashMap<String, ArrayList<PSAppViewCode>>();
    private Map<String, ArrayList<IPSObject>> psModelListMap = new LinkedHashMap<String, ArrayList<IPSObject>>();
    private String strSystemLogFilePath = "";
    private File sysLogFile = null;
    private String strDEFieldSortMode = "NAME";
    private boolean bEnableMultiLan = false;
    private String strDefaultLanguageId = "ZH_CN";
    private String strCLEmptyText = null;
    private String strCLEmptyTextPSLanguageResId = null;
    private IPSSysEngineConfig iPSSysEngineConfig = null;
    private int nDEDataExpMaxRowCount = 1000;
    private int nDEDataSetMaxRowCount = -1;
    private IPSDBDevInst jitPSDBDevInst = null;
    private long nLastActiveTime = 0L;
    private long nLastDBActiveTime = 0L;
    private int nCheckModelVer = 0;
    private boolean bChecking = false;
    private PSSysIssueService psSysIssueService = null;
    private boolean bNoViewMode = false;
    private ArrayList<IPSLogItem> psLogItemList = new ArrayList();
    private boolean bLoading = false;
    private int nServiceAPIMode = 0;
    private int nDataAccCtrlArch = 1;
    private int nEngineBugFixs = 0;
    private int nDEFSFItemWidth = -1;
    private String strDefaultValueFormat = "%1$s";
    private boolean bPubDBModel = true;
    private PSSystemSettingProxy psSystemSettingProxy = null;
    private boolean bEnableDBValueInsertUpdateMode = false;
    private int nDBVersion = 0;
    private boolean bEnableDynaSys = false;
    private int nDynaSysMode = IPSSystem.DYNASYSMODE_NOTSUPPORTED;
    private int nSaaSMode = IPSSystem.SAASMODE_NOTSUPPORTED;
    private ArrayList<PSDevSlnTempl> psDevSlnTemplList = null;
    private ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = null;
    private boolean bEnableLanResDefaultContent = true;
    private boolean bEnableDEDataVer = false;
    private int nDEMSActionLogicMode = 0;
    private int nSubSysDEMSActionLogicMode = 0;
    private int nSampleDataId = 0;
    private IPSModelObjectLogger iPSModelObjectLogger = null;
    private IPSSFPubHelp iPSSFPubHelp = null;
    private boolean bEnableDERFKey = true;
    private boolean bAppendCtrlDEItems = false;
    private boolean bAutoCalcDER1NExtRestrict = false;
    private boolean bEnableDEFieldRestrictedUI = false;
    private Boolean bPanelItemAutoShowCaption = null;
    private Map<String, PSDELogic> psDELogicMap = new HashMap<String, PSDELogic>();
    private Map<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
    private Map<String, PSCtrlLogicGroup> psCtrlLogicGroupMap = new HashMap<String, PSCtrlLogicGroup>();
    private Map<String, IPSSysMethodDTO> psSysMethodDTOMap = new TreeMap<String, IPSSysMethodDTO>();
    private List<IPSSysI18N> psSysI18NList = new ArrayList<IPSSysI18N>();
    private Map<String, Object> attributeMap = new HashMap<String, Object>();
    private PSSysI18NImpl psSysI18NImpl = new PSSysI18NImpl();
    private boolean bQuickCheck = false;
    private IPSSystemUtil.IPSSysConsole iPSSysConsole = new IPSSystemUtil.IPSSysConsole(){

        @Override
        public void log(String strName, String strLogInfo) {
            PSSystemImpl.this.logSysConsole("INFO", strName, strLogInfo);
        }

        @Override
        public void warn(String strName, String strLogInfo) {
            PSSystemImpl.this.logSysConsole("WARN", strName, strLogInfo);
        }

        @Override
        public void error(String strName, String strLogInfo) {
            PSSystemImpl.this.logSysConsole("ERROR", strName, strLogInfo);
        }

        @Override
        public void warn(String strName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
            PSSystemImpl.this.logSysConsole("WARN", strName, strLogInfo, strFixDEName, strFixDEAction, strFixDataKey);
        }

        @Override
        public void error(String strName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
            PSSystemImpl.this.logSysConsole("ERROR", strName, strLogInfo, strFixDEName, strFixDEAction, strFixDataKey);
        }
    };
    private Map<String, List<String>> modelLogListMap = new HashMap<String, List<String>>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystemContainer iPSSystemContainer, SA.SRFDA.PS.Data.PSSystem psSystem) throws Exception {
        String strCodeFolder;
        String[] dbTypes;
        if (iPSSystemContainer instanceof IPSDevSlnSys) {
            this.iPSDevSlnSys = (IPSDevSlnSys)iPSSystemContainer;
            if (this.iPSDevSlnSys instanceof IPSDevSlnSysRuntime) {
                this.iPSDevSlnSysRuntime = (IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys);
            }
        } else if (iPSSystemContainer instanceof IPSDepSlnPrd) {
            this.iPSDepSlnPrd = (IPSDepSlnPrd)iPSSystemContainer;
        }
        this.psSystem = psSystem;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSystem.getPSSYSTEMID());
        this.setName(psSystem.getPSSYSTEMNAME());
        this.setVersion(psSystem.getMODELVER());
        if (StringHelper.IsNullOrEmpty((String)this.getId()) && this.iPSDevSlnSys != null) {
            this.setId(this.iPSDevSlnSys.getPSSystemId());
        }
        if (StringHelper.IsNullOrEmpty((String)this.getName()) && this.iPSDevSlnSys != null) {
            this.setName(this.iPSDevSlnSys.getPSSystemName());
        }
        if (!this.psSystem.isDBVERSIONNull()) {
            this.nDBVersion = this.psSystem.getDBVERSION();
        }
        if (!this.psSystem.isCHECKMODELVERNull()) {
            this.nCheckModelVer = this.psSystem.getCHECKMODELVER();
        }
        this.setPSObjectData(this.psSystem);
        if (this.iPSDevSlnSys != null) {
            this.iPSSystemUtil = (IPSSystemUtil)((Object)this.iPSDevSlnSys);
        }
        this.psSystemSettingProxy = new PSSystemSettingProxy(this);
        PSSysWFSetting psSysWFSetting = new PSSysWFSetting();
        CallResult callResult = this.getPSModelHelper().getPSSysWFSetting(psSystem.getPSSYSTEMID(), psSysWFSetting);
        if (callResult.isOk()) {
            this.iPSSysWFSetting = new PSSysWFSettingImpl();
            this.iPSSysWFSetting.init(iDAGlobalHelper, this, psSysWFSetting);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSystem.getPSSYSENGINECFGID())) {
            this.iPSSysEngineConfig = this.getPSModelStorage().getPSSysEngineConfig(this.psSystem.getPSSYSENGINECFGID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSystem.getDEFSORTMODE())) {
            this.strDEFieldSortMode = this.psSystem.getDEFSORTMODE();
        }
        if (!this.psSystem.isDEEXPMAXROWCNTNull()) {
            this.nDEDataExpMaxRowCount = this.psSystem.getDEEXPMAXROWCNT();
            if (this.nDEDataExpMaxRowCount <= 0) {
                this.nDEDataExpMaxRowCount = 1000;
            }
        }
        if (!this.psSystem.isDEDSMAXROWCNTNull()) {
            this.nDEDataSetMaxRowCount = this.psSystem.getDEDSMAXROWCNT();
            if (this.nDEDataSetMaxRowCount <= 0) {
                this.nDEDataSetMaxRowCount = -1;
            }
        }
        if (!this.psSystem.isNOVIEWMODENull()) {
            this.bNoViewMode = this.psSystem.getNOVIEWMODE();
        }
        if (!this.psSystem.isACCCTRLARCHNull()) {
            this.nDataAccCtrlArch = this.psSystem.getACCCTRLARCH();
        }
        if (!this.psSystem.isBUGFIXSNull()) {
            this.nEngineBugFixs = this.psSystem.getBUGFIXS();
        }
        if (!this.psSystem.isDEFSFITEMWIDTHNull()) {
            this.nDEFSFItemWidth = this.psSystem.getDEFSFITEMWIDTH();
        }
        if (!this.psSystem.isPUBDBMODELFLAGNull()) {
            this.bPubDBModel = this.psSystem.getPUBDBMODELFLAG();
        }
        if (!this.psSystem.isENABLEDBVALUEMODENull()) {
            this.bEnableDBValueInsertUpdateMode = this.psSystem.getENABLEDBVALUEMODE();
        }
        if (!this.psSystem.isENABLEDYNASYSNull()) {
            this.bEnableDynaSys = this.psSystem.getENABLEDYNASYS() > 0;
            this.nDynaSysMode = this.psSystem.getENABLEDYNASYS();
        }
        if (!this.psSystem.isSAASMODENull()) {
            this.nSaaSMode = this.psSystem.getSAASMODE();
        }
        if (!this.psSystem.isENADEFLANRESCONTENTNull()) {
            this.bEnableLanResDefaultContent = this.psSystem.getENADEFLANRESCONTENT();
        }
        if (!this.psSystem.isENABLEDEDATAVERNull()) {
            this.bEnableDEDataVer = this.psSystem.getENABLEDEDATAVER();
        }
        if (!this.psSystem.isENABLEDERFKEYNull()) {
            this.bEnableDERFKey = this.psSystem.getENABLEDERFKEY();
        }
        if (!this.psSystem.isDEMSACTIONLOGICFLAGNull()) {
            this.nDEMSActionLogicMode = this.psSystem.getDEMSACTIONLOGICFLAG();
        }
        if (!this.psSystem.isSSDEMSACTIONLOGICFLAGNull()) {
            this.nSubSysDEMSActionLogicMode = this.psSystem.getSSDEMSACTIONLOGICFLAG();
        }
        if (!this.psSystem.isCTRLAPPENDDEITEMSNull()) {
            this.bAppendCtrlDEItems = this.psSystem.getCTRLAPPENDDEITEMS();
        }
        if (!this.psSystem.isAUTOCALCDERERNull()) {
            this.bAutoCalcDER1NExtRestrict = this.psSystem.getAUTOCALCDERER();
        }
        if (!this.psSystem.isENABLEDEFRESTRICTEDUINull()) {
            this.bEnableDEFieldRestrictedUI = this.psSystem.getENABLEDEFRESTRICTEDUI();
        }
        if (!this.psSystem.isPIAUTOSHOWCAPTIONNull()) {
            this.bPanelItemAutoShowCaption = this.psSystem.getPIAUTOSHOWCAPTION();
        }
        this.strPubSystemId = this.getPSDevSlnSysId();
        if (StringHelper.IsNullOrEmpty((String)this.getPSDevSlnSysId())) {
            this.strPubSystemId = this.getId();
        }
        if (this.iPSDevSlnSys == null) {
            this.strVCName = "TRUNK";
        } else {
            if (StringHelper.Compare((String)this.iPSDevSlnSys.getVCType(), (String)"TRUNK", (boolean)true) == 0) {
                this.strVCName = "TRUNK";
            } else if (StringHelper.Compare((String)this.iPSDevSlnSys.getVCType(), (String)"BRANCH", (boolean)true) == 0) {
                this.strVCName = StringHelper.Format((String)"B_%1$s", (Object)this.iPSDevSlnSys.getSysVersion());
            } else if (StringHelper.Compare((String)this.iPSDevSlnSys.getVCType(), (String)"TAG", (boolean)true) == 0) {
                this.strVCName = StringHelper.Format((String)"T_%1$s", (Object)this.iPSDevSlnSys.getSysVersion());
            }
            if (((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDevSlnTemplList() != null) {
                this.psDevSlnTemplList = new ArrayList();
                this.psDevSlnTemplList.addAll(((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDevSlnTemplList());
            }
            if (((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDevSlnSysDynaInstList() != null) {
                this.psDevSlnSysDynaInstList = new ArrayList();
                this.psDevSlnSysDynaInstList.addAll(((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDevSlnSysDynaInstList());
            }
        }
        this.strVCName = this.strVCName.toLowerCase();
        this.psSysDynaModelGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysModelGroupGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUniStateGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUtilGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDTSQueueGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysLanGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysBackServiceGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDictCatGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysPortletCatGlobalModel.Init(iDAGlobalHelper, this);
        this.psViewMsgGlobalModel.Init(iDAGlobalHelper, this);
        this.psViewMsgGroupGlobalModel.Init(iDAGlobalHelper, this);
        this.psDEFInputTipSetGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDEFInputTipGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysPFPluginGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysPFPluginTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysSFPluginGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysSFPluginTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysEditorStyleGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubViewTypeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUniResGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUserRoleGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUserModeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUserDRGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysMsgTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psCodeListGlobalModel.Init(iDAGlobalHelper, this);
        this.psThresholdGroupGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysImageGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysCssGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysChartThemeGlobalModel.Init(iDAGlobalHelper, this);
        this.psCtrlMsgGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysFileGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUnitGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysLogicGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDEFTypeGlobalModel.Init(iDAGlobalHelper, this);
        this.psLanguageResGlobalModel.Init(iDAGlobalHelper, this);
        this.psLanguageItemGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysValueRuleGlobalModel.Init(iDAGlobalHelper, this);
        this.psSystemApplicationGlobalModel.Init(iDAGlobalHelper, this);
        this.gitPSSystemApplicationGlobalModel.Init(iDAGlobalHelper, this);
        this.psSystemDBConfigGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDMVerGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDMItemGlobalModel.Init(iDAGlobalHelper, this);
        this.psSystemDeployGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDEUIActionGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDEUIActionGroupGlobalModel.Init(iDAGlobalHelper, this);
        this.psDERGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDBValueFuncGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysAjaxControlHandlerGlobalModel.Init(iDAGlobalHelper, this);
        this.psSystemModuleGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysSampleValueGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysTestDataGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysActorGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUseCaseGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUseCaseRSGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysTestPrjGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysTestCaseGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysERMapGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysUCMapGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysSearchSchemeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysEAISchemeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysBISchemeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysAIFactoryGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysRefGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubSysRefGlobalModel.Init(iDAGlobalHelper, this);
        this.psWorkflowGlobalModel.Init(iDAGlobalHelper, this);
        this.psWFRoleGlobalModel.Init(iDAGlobalHelper, this);
        this.psWFWorkTimeGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysPortletGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysPDTViewGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysViewLogicGlobalModel.Init(iDAGlobalHelper, this);
        this.psSystemASGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysCounterGlobalModel.Init(iDAGlobalHelper, this);
        this.psDEOPPrivGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysSFPubGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysDataSyncAgentGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysBDSchemeGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psWXAccountGlobalModel.Init(iDAGlobalHelper, this);
        this.psHelpResourceGlobalModel.Init(iDAGlobalHelper, this);
        this.psHelpArticleGlobalModel.Init(iDAGlobalHelper, this);
        this.psHelpPrjGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysServiceAPIHandlerGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysServiceAPIGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubSysServiceAPIGlobalModel.Init(iDAGlobalHelper, this);
        this.psDEActionTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psDynaDETemplGlobalModel.Init(iDAGlobalHelper, this);
        this.psSysDBSchemeGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysResourceGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysContentCatGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysReqModuleGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysReqItemGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysDEGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysDERGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysSequenceGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysTranslatorGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysMsgQueueGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSysMsgTargetGlobalModel.Init(this.getDAGlobalHelper(), this);
        String strDBTypes = this.psSystem.getDBTYPES();
        String[] stringArray = dbTypes = strDBTypes.split("[;]");
        int n = dbTypes.length;
        int n2 = 0;
        while (n2 < n) {
            String strDBType = stringArray[n2];
            if (!StringHelper.IsNullOrEmpty((String)(strDBType = strDBType.trim()))) {
                this.supportDBTypeList.add(strDBType);
            }
            ++n2;
        }
        this.strCodeName = this.psSystem.getCODENAME();
        if (StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getName();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null)))) {
            strCodeFolder = StringHelper.IsNullOrEmpty((String)this.getPSDevSlnSysId()) ? StringHelper.Format((String)"%1$s/_SYSLOG/%2$s", (Object)strCodeFolder, (Object)this.getId()) : StringHelper.Format((String)"%1$s/_SYSLOG/%2$s", (Object)strCodeFolder, (Object)this.getPSDevSlnSysId());
            File dir = new File(strCodeFolder);
            dir.mkdirs();
            String strSystemLogFilePath2 = StringHelper.Format((String)"%2$s/%1$tY%1$tm%1$td%1$tH%1$tM%1$tS.log", (Object)new Date(), (Object)strCodeFolder);
            this.strSystemLogFilePath = StringHelper.Format((String)"%2$s/active.log", (Object)new Date(), (Object)strCodeFolder);
            this.sysLogFile = new File(this.strSystemLogFilePath);
            if (!this.sysLogFile.exists()) {
                this.sysLogFile.createNewFile();
            } else {
                this.sysLogFile.renameTo(new File(strSystemLogFilePath2));
            }
            this.log(0, this, "\u5efa\u7acb\u5bf9\u8c61");
        }
        if (!this.psSystem.isENABLEMULTILANNull()) {
            this.bEnableMultiLan = this.psSystem.getENABLEMULTILAN();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSystem.getPSLANGUAGEID())) {
            this.strDefaultLanguageId = this.psSystem.getPSLANGUAGEID();
        }
        this.strCLEmptyText = this.psSystem.getCLEMPTYTEXT();
        this.strCLEmptyTextPSLanguageResId = this.psSystem.getCLEMPTYTEXTPSLANRESID();
        if (!this.psSystem.isSERVICEAPIFLAGNull()) {
            this.nServiceAPIMode = this.psSystem.getSERVICEAPIFLAG();
        }
        this.strDefaultValueFormat = PSSFImpl.getDefaultValueFormat(this.getPSSFId());
        this.psSysI18NImpl.init(this.getDAGlobalHelper(), this);
        this.psSysI18NList.add(this.psSysI18NImpl);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSSystemDeploy getDefaultPSSystemDeploy() throws Exception {
        return (IPSSystemDeploy)this.psSystemDeployGlobalModel.FindModelHelper(this.psSystem.getDEFPSSYSDEPLOYID());
    }

    @Override
    public IPSCodeList getPSCodeList(String strCodeListId) throws Exception {
        IPSCodeList iPSCodeList = (IPSCodeList)this.psCodeListGlobalModel.FindModelHelper(strCodeListId);
        if (iPSCodeList != null) {
            iPSCodeList.markSysRef(null, null);
        }
        return iPSCodeList;
    }

    @Override
    public IPSCodeList getPSCodeList(String strCodeListId, boolean bTryMode) throws Exception {
        IPSCodeList iPSCodeList = (IPSCodeList)this.psCodeListGlobalModel.FindModelHelper(strCodeListId, bTryMode);
        if (iPSCodeList != null) {
            iPSCodeList.markSysRef(null, null);
        }
        return iPSCodeList;
    }

    @Override
    public void resetPSCodeList(String strCodeListId) throws Exception {
        this.psCodeListGlobalModel.ResetModel(strCodeListId);
    }

    @Override
    public void resetAllPSCodeLists() {
        this.psCodeListGlobalModel.ResetAll();
    }

    @Override
    public IPSCodeList getPSCodeListByTempl(String strCodeListTemplId) throws Exception {
        try {
            return (IPSCodeList)this.psCodeListGlobalModel.FindModelHelper(Helper.GenUniqueId((String)this.getId(), (String)strCodeListTemplId));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9884\u7f6e\u4ee3\u7801\u8868[%1$s]", (Object)strCodeListTemplId));
            throw ex;
        }
    }

    @Override
    public final IPSDataEntity getPSDataEntity2(String strDEName) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSDataEntity(strDEName);
        if (iPSDataEntity == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6a21\u578b\u5bf9\u8c61", (Object)strDEName));
        }
        return iPSDataEntity;
    }

    @Override
    public final IPSDataEntity getPSDataEntity2(String strDEName, boolean bTryMode) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSDataEntity(strDEName);
        if (iPSDataEntity == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6a21\u578b\u5bf9\u8c61", (Object)strDEName));
        }
        return iPSDataEntity;
    }

    @Override
    public IPSDataEntity getPSDataEntity(String strDEName) throws Exception {
        return this.getPSDataEntity(strDEName, true);
    }

    @Override
    public IPSDataEntity getPSDataEntity(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity iPSDataEntity = this.internalGetPSDataEntity(strDEName, bCache);
        if (iPSDataEntity != null && !iPSDataEntity.isInit()) {
            iPSDataEntity.init();
        }
        return iPSDataEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IPSDataEntity internalGetPSDataEntity(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity lastPSDataEntity;
        block25: {
            String strOriginDEID = strDEName;
            strDEName = strDEName.toUpperCase();
            Long curTime = new Date().getTime();
            lastPSDataEntity = null;
            Hashtable<String, IPSDataEntity> hashtable = this.psDataEntityMap;
            synchronized (hashtable) {
                if (this.psDataEntityMap.containsKey(strDEName)) {
                    lastPSDataEntity = this.psDataEntityMap.get(strDEName);
                    if (bCache) {
                        return lastPSDataEntity;
                    }
                }
            }
            PSDataEntity psDataEntity = new PSDataEntity();
            CallResult callResult = this.getPSModelHelper().getPSDataEntity(this.getId(), strOriginDEID, psDataEntity);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)strOriginDEID));
                return null;
            }
            if (StringHelper.IsNullOrEmpty((String)psDataEntity.getPSDATAENTITYNAME())) {
                throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u6307\u5b9a\u5b9e\u4f53\u540d\u79f0", strOriginDEID));
            }
            if (psDataEntity.GetParamIntValue("VALIDFLAG", 1) == 0) {
                throw new PSSystemException(this, 10002, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u5b9e\u4f53[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)this.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
            }
            if (lastPSDataEntity != null) {
                if (lastPSDataEntity.getVersion() == psDataEntity.getMODELVER()) {
                    return lastPSDataEntity;
                }
                lastPSDataEntity = null;
            }
            if ((lastPSDataEntity = this.getPSDataEntity(psDataEntity)) == null) {
                return lastPSDataEntity;
            }
            Hashtable<String, IPSDataEntity> hashtable2 = this.psDataEntityMap;
            synchronized (hashtable2) {
                this.psDataEntityMap.put(lastPSDataEntity.getId().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getId().toUpperCase(), new Date().getTime());
                this.psDataEntityMap.put(lastPSDataEntity.getName().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getName().toUpperCase(), new Date().getTime());
            }
            try {
                if (!lastPSDataEntity.isInit()) {
                    lastPSDataEntity.init();
                }
            }
            catch (Exception ex) {
                this.psDataEntityMap.put(lastPSDataEntity.getId().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getId().toUpperCase(), new Date().getTime());
                this.psDataEntityMap.put(lastPSDataEntity.getName().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getName().toUpperCase(), new Date().getTime());
                throw ex;
            }
            try {
                if (lastPSDataEntity.preparePSDEFields(true)) break block25;
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u51c6\u5907\u5c5e\u6027\u5931\u8d25", (Object)strOriginDEID));
                Hashtable<String, IPSDataEntity> ex = this.psDataEntityMap;
                synchronized (ex) {
                    this.psDataEntityMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityMap.remove(lastPSDataEntity.getName().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getName().toUpperCase());
                }
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u51c6\u5907\u5c5e\u6027\u5931\u8d25", (Object)strOriginDEID), (Throwable)ex);
                Hashtable<String, IPSDataEntity> hashtable3 = this.psDataEntityMap;
                synchronized (hashtable3) {
                    this.psDataEntityMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityMap.remove(lastPSDataEntity.getName().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getName().toUpperCase());
                }
                return null;
            }
        }
        return lastPSDataEntity;
    }

    private final IPSDataEntity getPSDataEntity(PSDataEntity psDataEntity) throws Exception {
        PSDataEntityImpl iPSDataEntity = new PSDataEntityImpl();
        iPSDataEntity.setInitParam(this.getDAGlobalHelper(), this, psDataEntity);
        return iPSDataEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDataEntity(String strDEName) {
        Hashtable<String, IPSDataEntity> hashtable = this.psDataEntityMap;
        synchronized (hashtable) {
            IPSDataEntity iPSDataEntity = this.psDataEntityMap.get(strDEName.toUpperCase());
            if (iPSDataEntity != null) {
                this.psDataEntityMap.remove(iPSDataEntity.getId().toUpperCase());
                this.psDataEntityRenewMap.remove(iPSDataEntity.getId().toUpperCase());
                this.psDataEntityMap.remove(iPSDataEntity.getName().toUpperCase());
                this.psDataEntityRenewMap.remove(iPSDataEntity.getName().toUpperCase());
                this.allPSDataEntityList = null;
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5e93\u7c7b\u578b", outputdoc="false")
    public Iterator<String> getSupportDBTypes() {
        return this.supportDBTypeList.iterator();
    }

    @Override
    public IPSSystemDBConfig getPSSystemDBConfig(String strDBType) throws Exception {
        return (IPSSystemDBConfig)this.psSystemDBConfigGlobalModel.FindModelHelper(strDBType);
    }

    @Override
    public IPSSystemDBConfig getPSSystemDBConfig(String strDBType, boolean bTryMode) throws Exception {
        return (IPSSystemDBConfig)this.psSystemDBConfigGlobalModel.FindModelHelper(strDBType, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u914d\u7f6e\u96c6\u5408", child=true, dumpref=true, rtname="getDBConfigs", ignorert=3, dynamodelmode=8, group="\u6570\u636e\u5e93\u5b58\u50a8", order=260)
    public Iterator<IPSSystemDBConfig> getAllPSSystemDBConfigs() throws Exception {
        return this.psSystemDBConfigGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSApplication getPSApplication(String strSystemApplicationId) throws Exception {
        this.active();
        return (IPSApplication)this.psSystemApplicationGlobalModel.FindModelHelper(strSystemApplicationId);
    }

    @Override
    public void resetPSApplication(String strSystemApplicationId) {
        this.psSystemApplicationGlobalModel.ResetModel(strSystemApplicationId);
    }

    @Override
    public IPSApplication getPSJITApplication(String strSystemApplicationId) throws Exception {
        this.active();
        return (IPSApplication)this.gitPSSystemApplicationGlobalModel.FindModelHelper(strSystemApplicationId);
    }

    @Override
    public void resetPSJITApplication(String strSystemApplicationId) {
        this.gitPSSystemApplicationGlobalModel.ResetModel(strSystemApplicationId);
    }

    @Override
    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId) throws Exception {
        return (IPSDEUIAction)this.psSysDEUIActionGlobalModel.FindModelHelper(strDEUIActionId);
    }

    @Override
    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSDEUIAction)this.psSysDEUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode);
    }

    @Override
    public void resetPSDEUIAction(String strDEUIActionId) {
        this.psSysDEUIActionGlobalModel.ResetModel(strDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception {
        return this.psSysDEUIActionGlobalModel.getAllModelHelpers();
    }

    public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
        return this.getPSDataEntity(strDataEntityId);
    }

    @Override
    public IPSDERBase getPSDER(String strPSDERId) throws Exception {
        return (IPSDERBase)this.psDERGlobalModel.FindModelHelper(strPSDERId);
    }

    @Override
    public IPSDER1N getPSDER1N(String strPSDERId) throws Exception {
        IPSDERBase iPSDERBase = this.getPSDER(strPSDERId);
        if (iPSDERBase instanceof IPSDER1N) {
            return (IPSDER1N)iPSDERBase;
        }
        throw new Exception(StringHelper.Format((String)"\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)iPSDERBase.getName()));
    }

    @Override
    public void resetPSDER(String strPSDERId) {
        this.psDERGlobalModel.ResetModel(strPSDERId);
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u5904\u7406\u903b\u8f91", order=517)
    public Iterator<IPSSysDBValueFunc> getAllPSSysDBValueFuncs() throws Exception {
        return this.psSysDBValueFuncGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDBValueFunc getPSSysDBValueFunc(String strPSSysDBValueFuncId) throws Exception {
        return (IPSSysDBValueFunc)this.psSysDBValueFuncGlobalModel.FindModelHelper(strPSSysDBValueFuncId);
    }

    @Override
    public void resetPSSysDBValueFunc(String strPSSysDBValueFuncId) {
        this.psSysDBValueFuncGlobalModel.ResetModel(strPSSysDBValueFuncId);
    }

    public IDERBase getDER(String strDERId) throws Exception {
        return this.getPSDER(strDERId);
    }

    @Override
    public String getSFType() {
        return this.psSystem.getPSSFID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u96c6\u5408", child=true, dumpref=true, rtdump=0, modelreftype="SYSTEM", group="\u6570\u636e\u6a21\u578b", order=195)
    public Iterator<IPSDataEntity> getAllPSDataEntities() throws Exception {
        Iterator<String> entities;
        ArrayList<IPSDataEntity> allPSDataEntityList = this.allPSDataEntityList;
        if (allPSDataEntityList != null) {
            return allPSDataEntityList.iterator();
        }
        Vector<PSDataEntity> psDataEntityList = new Vector<PSDataEntity>();
        CallResult callResult = this.getPSModelHelper().getAllPSDataEntities(this.getId(), psDataEntityList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, String> allowEntityMap = null;
        if (this.getPSWorkspace() != null && (entities = this.getPSWorkspace().getEntities()) != null) {
            allowEntityMap = new LinkedHashMap<String, String>();
            while (entities.hasNext()) {
                allowEntityMap.put(entities.next(), "");
            }
        }
        int nTotalCount = 0;
        for (PSDataEntity psDataEntity : psDataEntityList) {
            String strItem;
            if (psDataEntity.GetParamIntValue("VALIDFLAG", 1) != 1 || allowEntityMap != null && !StringHelper.IsNullOrEmpty((String)(strItem = (String)allowEntityMap.remove(psDataEntity.getPSDATAENTITYNAME().toUpperCase())))) continue;
            ++nTotalCount;
        }
        this.testPSModelLimit(this, "PSDATAENTITY", nTotalCount);
        for (PSDataEntity psDataEntity : psDataEntityList) {
            if (psDataEntity.GetParamIntValue("VALIDFLAG", 1) != 1) continue;
            this.getPSDataEntity(psDataEntity.getPSDATAENTITYID());
        }
        Hashtable<String, IPSDataEntity> hashtable = this.psDataEntityMap;
        synchronized (hashtable) {
            allPSDataEntityList = new ArrayList();
            LinkedHashMap<String, IPSDataEntity> tempMap = new LinkedHashMap<String, IPSDataEntity>();
            for (IPSDataEntity iPSDataEntity : this.psDataEntityMap.values()) {
                tempMap.put(iPSDataEntity.getId(), iPSDataEntity);
            }
            allPSDataEntityList.addAll(tempMap.values());
            PSModelUtil.sort(allPSDataEntityList);
            if (this.allPSDataEntityList == null) {
                this.allPSDataEntityList = allPSDataEntityList;
            }
        }
        return allPSDataEntityList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u96c6\u5408", child=true, dumpref=true, ignorert=3, group="\u524d\u7aef&\u540e\u53f0", order=224)
    public Iterator<IPSApplication> getAllPSApps() throws Exception {
        this.active();
        return this.psSystemApplicationGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u96c6\u5408", child=true, rtname="getModules", group="\u57fa\u672c", order=130)
    public Iterator<IPSSystemModule> getAllPSSystemModules() throws Exception {
        return this.psSystemModuleGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u96c6\u5408", child=true, dumpref=true, group="\u5de5\u4f5c\u6d41", order=325)
    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception {
        return this.psWorkflowGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u96c6\u5408", child=true, dumpref=true, group="\u5de5\u4f5c\u6d41", order=327)
    public Iterator<IPSWFRole> getAllPSWFRoles() throws Exception {
        return this.psWFRoleGlobalModel.getAllModelHelpers();
    }

    @Override
    public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId, boolean bTryMode) throws Exception {
        PSACHandler psACHandler = this.psSysAjaxControlHandlerGlobalModel.FindModel(strAjaxControlHandlerId);
        if (psACHandler == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strAjaxControlHandlerId));
            }
            return psACHandler;
        }
        return psACHandler;
    }

    @Override
    public void resetPSAjaxControlHandlerData(String strAjaxControlHandlerId) {
        this.psSysAjaxControlHandlerGlobalModel.ResetModel(strAjaxControlHandlerId);
    }

    public ICodeList getCodeList(String strCodeListId) throws Exception {
        return this.getPSCodeList(strCodeListId);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u96c6\u5408", child=true, dumpref=true, group="\u6570\u636e\u6a21\u578b", order=200)
    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception {
        return this.psCodeListGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u96c6\u5408", group="\u6a21\u578b\u9ad8\u7ea7", order=475)
    public Iterator<IPSDERBase> getAllPSDERs() throws Exception {
        return this.psDERGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSystemModule getPSSystemModule(String strSystemModuleId) throws Exception {
        return (IPSSystemModule)this.psSystemModuleGlobalModel.FindModelHelper(strSystemModuleId);
    }

    @Override
    public void resetPSSystemModule(String strSystemModuleId) {
        this.psSystemModuleGlobalModel.ResetModel(strSystemModuleId);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5f15\u7528\u96c6\u5408", child=true, rtname="getSysRefs", dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=472)
    public Iterator<IPSSysRef> getAllPSSysRefs() throws Exception {
        return this.psSysRefGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysRef getPSSysRef(String strSysRefId) throws Exception {
        return (IPSSysRef)this.psSysRefGlobalModel.FindModelHelper(strSysRefId);
    }

    @Override
    public void resetPSSysRef(String strSysRefId) {
        this.psSysRefGlobalModel.ResetModel(strSysRefId);
    }

    @Override
    public IPSWorkflow getPSWorkflow(String strWorkflowId) throws Exception {
        return (IPSWorkflow)this.psWorkflowGlobalModel.FindModelHelper(strWorkflowId);
    }

    @Override
    public IPSWorkflow getPSWorkflow(String strWorkflowId, boolean bTryMode) throws Exception {
        return (IPSWorkflow)this.psWorkflowGlobalModel.FindModelHelper(strWorkflowId, bTryMode);
    }

    @Override
    public void resetPSWorkflow(String strWorkflowId) {
        this.psWorkflowGlobalModel.ResetModel(strWorkflowId);
    }

    @Override
    public IPSWFRole getPSWFRole(String strWFRoleId) throws Exception {
        return (IPSWFRole)this.psWFRoleGlobalModel.FindModelHelper(strWFRoleId);
    }

    @Override
    public IPSWFRole getPSWFRole(String strWFRoleId, boolean bTryMode) throws Exception {
        return (IPSWFRole)this.psWFRoleGlobalModel.FindModelHelper(strWFRoleId, bTryMode);
    }

    @Override
    public void resetPSWFRole(String strWFRoleId) {
        this.psWFRoleGlobalModel.ResetModel(strWFRoleId);
    }

    @Override
    public synchronized void load(int nLoadLevel) throws Exception {
        try {
            IPSDataEntity iPSDataEntity;
            if (nLoadLevel <= this.nLoadedLevel) {
                return;
            }
            if (this.isLoading()) {
                throw new Exception("\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u65e0\u6cd5\u91cd\u590d\u52a0\u8f7d");
            }
            this.bLoading = true;
            this.psLogItemList.clear();
            this.nLoadingLevel = nLoadLevel;
            this.psDELogicMap.clear();
            Vector<PSDELogic> psDELogicList = new Vector<PSDELogic>();
            CallResult callResult = this.getPSModelHelper().getAllPSDELogics(this.getId(), psDELogicList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5168\u90e8\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            for (PSDELogic psDELogic : psDELogicList) {
                this.psDELogicMap.put(psDELogic.getPSDELOGICID(), psDELogic);
            }
            this.psDEUIActionMap.clear();
            Vector<PSDEUIAction> psDEUIActionList = new Vector<PSDEUIAction>();
            callResult = this.getPSModelHelper().getAllPSDEUIActions(this.getId(), psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5168\u90e8\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            for (PSDEUIAction psDEUIAction : psDEUIActionList) {
                this.psDEUIActionMap.put(psDEUIAction.getPSDEUIACTIONID(), psDEUIAction);
            }
            this.psCtrlLogicGroupMap.clear();
            Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = new Vector<PSCtrlLogicGroup>();
            callResult = this.getPSModelHelper().getAllPSCtrlLogicGroups(this.getId(), psCtrlLogicGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5168\u90e8\u754c\u9762\u903b\u8f91\u7ec4\u4e3a\u96c6\u5408\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
            }
            for (PSCtrlLogicGroup psCtrlLogicGroup : psCtrlLogicGroupList) {
                this.psCtrlLogicGroupMap.put(psCtrlLogicGroup.getPSCTRLLOGICGROUPID(), psCtrlLogicGroup);
            }
            this.getAllPSSysModelGroups();
            this.getAllPSSysSFPubs();
            this.getAllPSSysDynaModels();
            this.getAllPSSysDMVers();
            this.getAllPSSysDEFTypes();
            this.getAllPSSysLans();
            this.getAllPSLanguageReses();
            this.getAllPSLanguageItems();
            this.getAllPSSysActors();
            this.getAllPSSysUseCases();
            this.getAllPSSysUseCaseRSs();
            this.getAllPSSysReqModules();
            this.getAllPSSysReqItems();
            this.getAllPSSysSampleValues();
            this.getAllPSSysUserModes();
            this.getAllPSSysUniReses();
            this.getAllPSSysUserRoles();
            this.getAllPSSysDEFInputTips();
            this.getAllPSSysPortletCats();
            this.getAllPSSysDictCats();
            this.getAllPSSysMsgTemples();
            this.getAllPSSysPFPluginTempls();
            this.getAllPSSysPFPlugins();
            this.getAllPSSysSFPluginTempls();
            this.getAllPSSysSFPlugins();
            this.getAllPSDEActionTempls();
            this.getAllPSSubSysRefs();
            this.getAllPSCodeLists();
            this.getAllPSThresholdGroups();
            this.getAllPSSysImages();
            this.getAllPSSysCsses();
            this.getAllPSSysChartThemes();
            this.getAllPSCtrlMsgs();
            this.getAllPSSysUnits();
            this.getAllPSSysLogics();
            this.getAllPSSysValueRules();
            this.getAllPSDynaDETempls();
            this.getAllPSDataEntities();
            this.getAllPSSubViewTypes();
            this.getAllPSDEOPPrivs();
            this.getAllPSSysPDTViews();
            this.getAllPSSysDataSyncAgents();
            this.getAllPSSysUserModes();
            this.getAllPSSysUserDRs();
            this.getAllPSSysResources();
            this.getAllPSSysContentCats();
            this.getAllPSSysSearchSchemes();
            this.getAllPSSysEAISchemes();
            this.getAllPSSysBISchemes();
            this.getAllPSSysAIFactories();
            this.getAllPSSysRefs();
            this.getAllPSSystemModules();
            this.getAllPSSysSequences();
            this.getAllPSSysTranslators();
            this.getAllPSSysMsgQueues();
            this.getAllPSSysMsgTargets();
            this.getAllPSSysDBValueFuncs();
            Iterator<IPSSysEditorStyle> psSysEditorStyles = this.getAllPSSysEditorStyles();
            while (psSysEditorStyles.hasNext()) {
                IPSSysEditorStyle iPSSysEditorStyle = psSysEditorStyles.next();
                if (!iPSSysEditorStyle.isReplaceDefault()) continue;
                if (StringHelper.IsNullOrEmpty((String)iPSSysEditorStyle.getContainerType())) {
                    this.defaultPSSysEditorStyleMap.put(iPSSysEditorStyle.getPSEditorTypeId(), iPSSysEditorStyle);
                    continue;
                }
                this.defaultPSSysEditorStyleMap.put(StringHelper.Format((String)"%1$s#%2$s", (Object)iPSSysEditorStyle.getPSEditorTypeId(), (Object)iPSSysEditorStyle.getContainerType()), iPSSysEditorStyle);
            }
            LinkedHashMap<String, IPSDER1N> fKeyMap = new LinkedHashMap<String, IPSDER1N>();
            Iterator<IPSDERBase> psDERBases = this.getAllPSDERs();
            while (psDERBases.hasNext()) {
                IPSDERBase iPSDERBase = psDERBases.next();
                if (!(iPSDERBase instanceof IPSDER1N)) continue;
                IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                if (fKeyMap.containsKey(iPSDER1N.getFKeyName())) {
                    throw new Exception(StringHelper.Format((String)"\u5173\u7cfb[%1$s]\u4e0e[%2$s]\u5916\u952e\u540d\u79f0[%3$s]\u4e00\u81f4", (Object)iPSDER1N.getName(), (Object)((IPSDER1N)fKeyMap.get(iPSDER1N.getFKeyName())).getName(), (Object)iPSDER1N.getFKeyName()));
                }
                fKeyMap.put(iPSDER1N.getFKeyName(), iPSDER1N);
            }
            Vector<PSDataEntity> psDataEntityList = new Vector<PSDataEntity>();
            CallResult callResult2 = this.getPSModelHelper().getAllPSDataEntities(this.getId(), psDataEntityList);
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            for (PSDataEntity psDataEntity : psDataEntityList) {
                IPSDataEntity iPSDataEntity2;
                if (psDataEntity.GetParamIntValue("VALIDFLAG", 1) != 1 || (iPSDataEntity2 = this.getPSDataEntity(psDataEntity.getPSDATAENTITYID())) != null) continue;
                iPSDataEntity2 = this.getPSDataEntity(psDataEntity);
                if (iPSDataEntity2 == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u52a0\u8f7d\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDataEntity.getPSDATAENTITYNAME()));
                }
                if (iPSDataEntity2 instanceof IPSDataEntityRuntime) {
                    ((IPSDataEntityRuntime)((Object)iPSDataEntity2)).tryLoad();
                }
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u52a0\u8f7d\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDataEntity.getPSDATAENTITYNAME()));
            }
            Iterator<IPSDataEntity> psDataEntities = this.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                iPSDataEntity.loadAll();
            }
            psDataEntities = this.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                iPSDataEntity.checkDataEntity();
            }
            this.getAllPSSysCounters();
            this.getAllPSSysServiceAPIHandlers();
            Iterator<IPSSysServiceAPI> psSysServiceAPIs = this.getAllPSSysServiceAPIs();
            this.testPSModelLimit(this, "PSSYSSERVICEAPI", this.psSysServiceAPIGlobalModel.getAllModelHelperCount());
            if (psSysServiceAPIs != null) {
                while (psSysServiceAPIs.hasNext()) {
                    IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
                    iPSSysServiceAPI.loadAll();
                }
            }
            Iterator<IPSSubSysServiceAPI> psSubSysServiceAPIs = this.getAllPSSubSysServiceAPIs();
            this.testPSModelLimit(this, "PSSUBSYSSERVICEAPI", this.psSubSysServiceAPIGlobalModel.getAllModelHelperCount());
            if (psSubSysServiceAPIs != null) {
                while (psSubSysServiceAPIs.hasNext()) {
                    IPSSubSysServiceAPI iPSSubSysServiceAPI = psSubSysServiceAPIs.next();
                    iPSSubSysServiceAPI.loadAll();
                }
            }
            this.getAllPSWXAccounts();
            this.getAllPSWFRoles();
            this.getAllPSWFWorkTimes();
            Iterator<IPSWorkflow> psWorkflows = this.getAllPSWorkflows();
            this.testPSModelLimit(this, "PSWORKFLOW", this.psWorkflowGlobalModel.getAllModelHelperCount());
            while (psWorkflows.hasNext()) {
                IPSWorkflow iPSWorkflow = psWorkflows.next();
                iPSWorkflow.loadAll();
            }
            Iterator<IPSSysBDScheme> psSysBDSchemes = this.getAllPSSysBDSchemes();
            while (psSysBDSchemes.hasNext()) {
                IPSSysBDScheme iPSSysBDScheme = psSysBDSchemes.next();
                iPSSysBDScheme.load(nLoadLevel);
            }
            Iterator<IPSSysDBScheme> psSysDBSchemes = this.getAllPSSysDBSchemes();
            while (psSysDBSchemes.hasNext()) {
                IPSSysDBScheme iPSSysDBScheme = psSysDBSchemes.next();
                iPSSysDBScheme.load(nLoadLevel);
            }
            this.getAllPSSysTestDatas();
            this.getAllPSSysTestCases();
            this.getAllPSSysTestPrjs();
            this.getAllPSSysERMaps();
            this.getAllPSSysUCMaps();
            this.getAllPSSysPortlets();
            this.getAllPSSysViewLogics();
            this.getAllPSViewMsgs();
            this.getAllPSViewMsgGroups();
            this.getAllPSDEUIActions();
            this.getAllPSDEUIActionGroups();
            this.getAllPSDEGroups();
            this.getAllPSDERGroups();
            this.getAllPSSysBackServices();
            this.getAllPSSysUtils();
            this.getAllPSSysDTSQueues();
            this.getAllPSSysUniStates();
            this.getAllPSApps();
            psDataEntities = this.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity3 = psDataEntities.next();
                iPSDataEntity3.check();
            }
            this.testPSModelLimit(this, "PSSYSAPP", this.psSystemApplicationGlobalModel.getAllModelHelperCount());
            this.psDEOPPrivGlobalModel.getAllModelHelpers();
            this.logPSModelLoadLog(0, null, null);
            this.nLoadedLevel = nLoadLevel;
            this.bLoading = false;
            this.active();
        }
        catch (Exception ex) {
            this.logPSModelLoadLog(1, null, ex);
            this.log(1, this, ex.getMessage());
            this.bLoading = false;
            this.nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
            this.nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
            throw ex;
        }
    }

    @Override
    public synchronized int getLoadingLevel() {
        return this.nLoadingLevel;
    }

    @Override
    public synchronized int getLoadedLevel() {
        return this.nLoadedLevel;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysImage> getAllPSSysImages() throws Exception {
        return this.psSysImageGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysImage getPSSysImage(String strSysImageId) throws Exception {
        return (IPSSysImage)this.psSysImageGlobalModel.FindModelHelper(strSysImageId);
    }

    @Override
    public IPSSysImage getPSSysImage(String strSysImageId, boolean bTryMode) throws Exception {
        return (IPSSysImage)this.psSysImageGlobalModel.FindModelHelper(strSysImageId, bTryMode);
    }

    @Override
    public void resetPSSysImage(String strSysImageId) throws Exception {
        this.psSysImageGlobalModel.ResetModel(strSysImageId);
    }

    @Override
    public void resetAllPSSysImages() {
        this.psSysImageGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u6837\u5f0f\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysCss> getAllPSSysCsses() throws Exception {
        return this.psSysCssGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysCss getPSSysCss(String strSysCssId) throws Exception {
        return (IPSSysCss)this.psSysCssGlobalModel.FindModelHelper(strSysCssId);
    }

    @Override
    public IPSSysCss getPSSysCss(String strSysCssId, boolean bTryMode) throws Exception {
        return (IPSSysCss)this.psSysCssGlobalModel.FindModelHelper(strSysCssId, bTryMode);
    }

    @Override
    public void resetPSSysCss(String strSysCssId) throws Exception {
        this.psSysCssGlobalModel.ResetModel(strSysCssId);
    }

    @Override
    public void resetAllPSSysCsses() {
        this.psSysCssGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysPortlet> getAllPSSysPortlets() throws Exception {
        return this.psSysPortletGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysPortlet getPSSysPortlet(String strSysPortletId) throws Exception {
        return (IPSSysPortlet)this.psSysPortletGlobalModel.FindModelHelper(strSysPortletId);
    }

    @Override
    public void resetPSSysPortlet(String strSysPortletId) throws Exception {
        this.psSysPortletGlobalModel.ResetModel(strSysPortletId);
    }

    @Override
    public void resetAllPSSysPortlets() {
        this.psSysPortletGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u8bcd\u5178\u5206\u7c7b\u96c6\u5408")
    public Iterator<IPSSysDictCat> getAllPSSysDictCats() throws Exception {
        return this.psSysDictCatGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDictCat getPSSysDictCat(String strSysDictCatId) throws Exception {
        return (IPSSysDictCat)this.psSysDictCatGlobalModel.FindModelHelper(strSysDictCatId);
    }

    @Override
    public IPSSysDictCat getPSSysDictCat(String strSysDictCatId, boolean bTryMode) throws Exception {
        return (IPSSysDictCat)this.psSysDictCatGlobalModel.FindModelHelper(strSysDictCatId, bTryMode);
    }

    @Override
    public void resetPSSysDictCat(String strSysDictCatId) throws Exception {
        this.psSysDictCatGlobalModel.ResetModel(strSysDictCatId);
    }

    @Override
    public void resetAllPSSysDictCats() {
        this.psSysDictCatGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u96c6\u5408", child=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=515)
    public Iterator<IPSSysValueRule> getAllPSSysValueRules() throws Exception {
        return this.psSysValueRuleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysValueRule getPSSysValueRule(String strSysValueRuleId) throws Exception {
        return (IPSSysValueRule)this.psSysValueRuleGlobalModel.FindModelHelper(strSysValueRuleId);
    }

    @Override
    public IPSSysValueRule getPSSysValueRule(String strSysValueRuleId, boolean bTryMode) throws Exception {
        return (IPSSysValueRule)this.psSysValueRuleGlobalModel.FindModelHelper(strSysValueRuleId, bTryMode);
    }

    @Override
    public void resetPSSysValueRule(String strSysValueRuleId) throws Exception {
        this.psSysValueRuleGlobalModel.ResetModel(strSysValueRuleId);
    }

    @Override
    public void resetAllPSSysValueRules() {
        this.psSysValueRuleGlobalModel.ResetAll();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSSysModelInstId();
        }
        return null;
    }

    @Override
    public String getPSDevSlnSysId() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getId();
        }
        return null;
    }

    @Override
    public String getPSDepSlnPrdId() {
        if (this.iPSDepSlnPrd != null) {
            return this.iPSDepSlnPrd.getId();
        }
        return null;
    }

    @Override
    public String getPSDevCenterDomain() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevCenterDomain();
        }
        return this.psSystem.getDOMAINNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4e2d\u5fc3\u6807\u8bc6", dump=false, outputdoc="false")
    public String getPSDevCenterId() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevCenterId();
        }
        return this.psSystem.getPSDEVCENTERID();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4e2d\u5fc3\u540d\u79f0", dump=false, outputdoc="false")
    public String getPSDevCenterName() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevCenterName();
        }
        return this.psSystem.getPSDEVCENTERNAME();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u7cfb\u7edf\u6807\u8bc6", dump=false, outputdoc="false")
    public String getPubSystemId() {
        return this.strPubSystemId;
    }

    @Override
    public String getPSSFId() {
        return this.psSystem.getPSSFID();
    }

    @Override
    public String getPSSFName() {
        return this.psSystem.getPSSFNAME();
    }

    @Override
    public IPSSystemAS getPSSystemAS(String strSystemASId) throws Exception {
        return (IPSSystemAS)this.psSystemASGlobalModel.FindModelHelper(strSystemASId);
    }

    @Override
    public void resetPSSystemAS(String strSystemASId) {
        this.psSystemASGlobalModel.ResetModel(strSystemASId);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u7248\u672c\u5e93", outputdoc="false")
    public IPSSVNInstRepo getPSSVNInstRepo() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSSVNInstRepo();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u7248\u672c\u5e93\uff08\u53ea\u8bfb\uff09", outputdoc="false")
    public IPSSVNInstRepo getReadOnlyPSSVNInstRepo() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getReadOnlyPSSVNInstRepo();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u653e\u4ee3\u7801\u7248\u672c\u5e93", outputdoc="false")
    public IPSSVNInstRepo getOpenPSSVNInstRepo() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getOpenPSSVNInstRepo();
        }
        return null;
    }

    @Override
    public IPSSVNInstRepo getRTPSSVNInstRepo() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getRTPSSVNInstRepo();
        }
        return null;
    }

    @Override
    public IPSSVNInstRepo getDocPSSVNInstRepo() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getDocPSSVNInstRepo();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5e72\u7cfb\u7edf\u540d\u79f0", dump=false)
    public String getTrunkSysName() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getMainPSDevSlnSysName();
        }
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u540d\u79f0")
    public String getVCName() {
        return this.strVCName;
    }

    @Override
    public String getPSDevSlnCodeName() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevSlnCodeName();
        }
        return this.getName();
    }

    @Override
    public IPSSubSysRef getPSSubSysRef(String strSubSysRefId) throws Exception {
        return (IPSSubSysRef)this.psSubSysRefGlobalModel.FindModelHelper(strSubSysRefId);
    }

    @Override
    public void resetPSSubSysRef(String strSubSysRefId) {
        this.psSubSysRefGlobalModel.ResetModel(strSubSysRefId);
    }

    @Override
    public Iterator<IPSSubSysRef> getAllPSSubSysRefs() throws Exception {
        return this.psSubSysRefGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u89c6\u56fe\u96c6\u5408", child=true, ignorert=3, dynamodelmode=8, group="\u6a21\u677f\u6269\u5c55", order=540)
    public Iterator<IPSSysPDTView> getAllPSSysPDTViews() throws Exception {
        return this.psSysPDTViewGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysPDTView getPSSysPDTView(String strSysPDTViewId) throws Exception {
        return (IPSSysPDTView)this.psSysPDTViewGlobalModel.FindModelHelper(strSysPDTViewId);
    }

    @Override
    public IPSSysPDTView getPSSysPDTView(String strSysPDTViewId, boolean bTryMode) throws Exception {
        return (IPSSysPDTView)this.psSysPDTViewGlobalModel.FindModelHelper(strSysPDTViewId, bTryMode);
    }

    @Override
    public void resetPSSysPDTView(String strSysPDTViewId) throws Exception {
        this.psSysPDTViewGlobalModel.ResetModel(strSysPDTViewId);
    }

    @Override
    public void resetAllPSSysPDTViews() {
        this.psSysPDTViewGlobalModel.ResetAll();
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin(String strSysPFPluginId) throws Exception {
        return (IPSSysPFPlugin)this.psSysPFPluginGlobalModel.FindModelHelper(strSysPFPluginId);
    }

    @Override
    public void resetPSSysPFPlugin(String strSysPFPluginId) {
        this.psSysPFPluginGlobalModel.ResetModel(strSysPFPluginId);
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u96c6\u5408", group="\u6a21\u677f\u6269\u5c55", order=528)
    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins() throws Exception {
        return this.psSysPFPluginGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysPFPluginTempl getPSSysPFPluginTempl(String strSysPFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSSysPFPluginTempl)this.psSysPFPluginTemplGlobalModel.FindModelHelper(strSysPFPluginTemplId, bTryMode);
    }

    @Override
    public void resetPSSysPFPluginTempl(String strSysPFPluginTemplId) {
        this.psSysPFPluginTemplGlobalModel.ResetModel(strSysPFPluginTemplId);
    }

    @Override
    public Iterator<IPSSysPFPluginTempl> getAllPSSysPFPluginTempls() throws Exception {
        return this.psSysPFPluginTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysCounter getPSSysCounter(String strSysCounterId) throws Exception {
        return (IPSSysCounter)this.psSysCounterGlobalModel.FindModelHelper(strSysCounterId);
    }

    @Override
    public IPSSysCounter getPSSysCounter(String strSysCounterId, boolean bTryMode) throws Exception {
        return (IPSSysCounter)this.psSysCounterGlobalModel.FindModelHelper(strSysCounterId, bTryMode);
    }

    @Override
    public void resetPSSysCounter(String strSysCounterId) {
        this.psSysCounterGlobalModel.ResetModel(strSysCounterId);
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u96c6\u5408", outputdoc="false", child=true, dynamodelmode=4)
    public Iterator<IPSSysCounter> getAllPSSysCounters() throws Exception {
        return this.psSysCounterGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSSubViewType> getAllPSSubViewTypes() throws Exception {
        return this.psSubViewTypeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSubViewType getPSSubViewType(String strSubViewTypeId) throws Exception {
        return (IPSSubViewType)this.psSubViewTypeGlobalModel.FindModelHelper(strSubViewTypeId);
    }

    @Override
    public IPSSubViewType getPSSubViewType(String strSubViewTypeId, boolean bTryMode) throws Exception {
        return (IPSSubViewType)this.psSubViewTypeGlobalModel.FindModelHelper(strSubViewTypeId, bTryMode);
    }

    @Override
    public void resetPSSubViewType(String strSubViewTypeId) throws Exception {
        this.psSubViewTypeGlobalModel.ResetModel(strSubViewTypeId);
    }

    @Override
    public void resetAllPSSubViewTypes() {
        this.psSubViewTypeGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u8d44\u6e90\u96c6\u5408", child=true, dynamodelmode=5, group="\u8bbf\u95ee\u63a7\u5236", order=410)
    public Iterator<IPSSysUniRes> getAllPSSysUniReses() throws Exception {
        return this.psSysUniResGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUniRes getPSSysUniRes(String strSysUniResId) throws Exception {
        return (IPSSysUniRes)this.psSysUniResGlobalModel.FindModelHelper(strSysUniResId);
    }

    @Override
    public IPSSysUniRes getPSSysUniRes(String strSysUniResId, boolean bTryMode) throws Exception {
        return (IPSSysUniRes)this.psSysUniResGlobalModel.FindModelHelper(strSysUniResId, bTryMode);
    }

    @Override
    public void resetPSSysUniRes(String strSysUniResId) throws Exception {
        this.psSysUniResGlobalModel.ResetModel(strSysUniResId);
    }

    @Override
    public void resetAllPSSysUniReses() {
        this.psSysUniResGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSSysMsgTempl> getAllPSSysMsgTemples() throws Exception {
        return this.psSysMsgTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u96c6\u5408", child=true, dynamodelmode=5, group="\u6d88\u606f", order=378)
    public Iterator<IPSSysMsgTempl> getAllPSSysMsgTempls() throws Exception {
        return this.psSysMsgTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysMsgTempl getPSSysMsgTempl(String strSysMsgTemplId) throws Exception {
        return (IPSSysMsgTempl)this.psSysMsgTemplGlobalModel.FindModelHelper(strSysMsgTemplId);
    }

    @Override
    public IPSSysMsgTempl getPSSysMsgTempl(String strSysMsgTemplId, boolean bTryMode) throws Exception {
        return (IPSSysMsgTempl)this.psSysMsgTemplGlobalModel.FindModelHelper(strSysMsgTemplId, bTryMode);
    }

    @Override
    public void resetPSSysMsgTempl(String strSysMsgTemplId) throws Exception {
        this.psSysMsgTemplGlobalModel.ResetModel(strSysMsgTemplId);
    }

    @Override
    public void resetAllPSSysMsgTemples() {
        this.psSysMsgTemplGlobalModel.ResetAll();
    }

    @Override
    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception {
        return (IPSDEOPPriv)this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId);
    }

    @Override
    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId, boolean bTryMode) throws Exception {
        return (IPSDEOPPriv)this.psDEOPPrivGlobalModel.FindModelHelper(strDEOPPrivId, bTryMode);
    }

    @Override
    public void resetPSDEOPPriv(String strDEOPPrivId) throws Exception {
        this.psDEOPPrivGlobalModel.ResetModel(strDEOPPrivId);
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u4f5c\u4e1a\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=352)
    public Iterator<IPSSysBackService> getAllPSSysBackServices() throws Exception {
        return this.psSysBackServiceGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBackService getPSSysBackService(String strSysBackServiceId) throws Exception {
        return (IPSSysBackService)this.psSysBackServiceGlobalModel.FindModelHelper(strSysBackServiceId);
    }

    @Override
    public IPSSysBackService getPSSysBackService(String strSysBackServiceId, boolean bTryMode) throws Exception {
        return (IPSSysBackService)this.psSysBackServiceGlobalModel.FindModelHelper(strSysBackServiceId, bTryMode);
    }

    @Override
    public void resetPSSysBackService(String strSysBackServiceId) throws Exception {
        this.psSysBackServiceGlobalModel.ResetModel(strSysBackServiceId);
    }

    @Override
    public void resetAllPSSysBackServices() {
        this.psSysBackServiceGlobalModel.ResetAll();
    }

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle(String strSysEditorStyleId) throws Exception {
        return (IPSSysEditorStyle)this.psSysEditorStyleGlobalModel.FindModelHelper(strSysEditorStyleId);
    }

    @Override
    public void resetPSSysEditorStyle(String strSysEditorStyleId) {
        this.psSysEditorStyleGlobalModel.ResetModel(strSysEditorStyleId);
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f\u96c6\u5408", child=true, ignorert=3, dynamodelmode=4, group="\u6a21\u677f\u6269\u5c55", order=532)
    public Iterator<IPSSysEditorStyle> getAllPSSysEditorStyles() throws Exception {
        return this.psSysEditorStyleGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u8bbe\u7f6e")
    public IPSSysWFSetting getPSSysWFSetting() {
        return this.iPSSysWFSetting;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=425)
    public Iterator<IPSSysDEOPPriv> getAllPSDEOPPrivs() throws Exception {
        return this.psDEOPPrivGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSSysViewLogic> getAllPSSysViewLogics() throws Exception {
        return this.psSysViewLogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysViewLogic getPSSysViewLogic(String strSysViewLogicId) throws Exception {
        return (IPSSysViewLogic)this.psSysViewLogicGlobalModel.FindModelHelper(strSysViewLogicId);
    }

    @Override
    public IPSSysViewLogic getPSSysViewLogic(String strSysViewLogicId, boolean bTryMode) throws Exception {
        return (IPSSysViewLogic)this.psSysViewLogicGlobalModel.FindModelHelper(strSysViewLogicId, bTryMode);
    }

    @Override
    public void resetPSSysViewLogic(String strSysViewLogicId) throws Exception {
        this.psSysViewLogicGlobalModel.ResetModel(strSysViewLogicId);
    }

    @Override
    public void resetAllPSSysViewLogics() {
        this.psSysViewLogicGlobalModel.ResetAll();
    }

    @Override
    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId) {
        return this.defaultPSSysEditorStyleMap.get(strPSEditorTypeId);
    }

    @Override
    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId, String strContainerType) {
        IPSSysEditorStyle iPSSysEditorStyle;
        if (!StringHelper.IsNullOrEmpty((String)strContainerType) && (iPSSysEditorStyle = this.defaultPSSysEditorStyleMap.get(StringHelper.Format((String)"%1$s#%2$s", (Object)strPSEditorTypeId, (Object)strContainerType))) != null) {
            return iPSSysEditorStyle;
        }
        return this.defaultPSSysEditorStyleMap.get(strPSEditorTypeId);
    }

    @Override
    public int check(int nLevel) throws Exception {
        if (this.getLoadedLevel() <= IPSSystem.LOADLEVEL_NONE) {
            throw new Exception("\u7cfb\u7edf\u8fd8\u672a\u52a0\u8f7d");
        }
        try {
            IPSSysIssueEngine iPSSysIssueEngine;
            Iterator<IPSSysIssueEngine> psSysIssueEngines;
            this.bChecking = true;
            if (this.psSysIssueService == null) {
                this.psSysIssueService = (PSSysIssueService)ServiceGlobal.getService(PSSysIssueService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getRuntimePSSysModelInstId()));
            }
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId(this.getId());
            if (nLevel == 0) {
                boolean bLoop;
                this.psSysIssueService.removeByPSSystem(psSystem);
                psSysIssueEngines = this.getPSModelStorage().getAllPSSysIssueEngines();
                while (psSysIssueEngines.hasNext()) {
                    iPSSysIssueEngine = psSysIssueEngines.next();
                    if (iPSSysIssueEngine.getCheckLevel() != nLevel) continue;
                    iPSSysIssueEngine.checkPSSystem(this);
                }
                super.check();
                if (this.getDefaultPSSysSFPub() == null) {
                    throw new Exception("\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u9ed8\u8ba4\u7684\u540e\u53f0\u670d\u52a1\u4f53\u7cfb");
                }
                this.psSysUniStateGlobalModel.checkAll();
                this.psSysUtilGlobalModel.checkAll();
                this.psSysDTSQueueGlobalModel.checkAll();
                this.psSysSampleValueGlobalModel.checkAll();
                this.psSysUserModeGlobalModel.checkAll();
                this.psSysReqItemGlobalModel.checkAll();
                this.psSysReqModuleGlobalModel.checkAll();
                this.psSysActorGlobalModel.checkAll();
                this.psSysUseCaseGlobalModel.checkAll();
                this.psSysUseCaseRSGlobalModel.checkAll();
                this.psSysUniResGlobalModel.checkAll();
                this.psDEFInputTipSetGlobalModel.checkAll();
                this.psSysDEFInputTipGlobalModel.checkAll();
                this.psViewMsgGlobalModel.checkAll();
                this.psViewMsgGroupGlobalModel.checkAll();
                this.psSysMsgTemplGlobalModel.checkAll();
                this.psSysPFPluginTemplGlobalModel.checkAll();
                this.psSysPFPluginGlobalModel.checkAll();
                this.psSysDEUIActionGroupGlobalModel.checkAll();
                this.psSubSysRefGlobalModel.checkAll();
                this.psCodeListGlobalModel.checkAll();
                this.psSysImageGlobalModel.checkAll();
                this.psSysCssGlobalModel.checkAll();
                this.psSysValueRuleGlobalModel.checkAll();
                this.psSubViewTypeGlobalModel.checkAll();
                this.psDEOPPrivGlobalModel.checkAll();
                this.psSysPDTViewGlobalModel.checkAll();
                this.psSysDataSyncAgentGlobalModel.checkAll();
                this.psSysUserModeGlobalModel.checkAll();
                this.psSysUserDRGlobalModel.checkAll();
                this.psSysBDSchemeGlobalModel.checkAll();
                this.psSysDBSchemeGlobalModel.checkAll();
                this.psSysResourceGlobalModel.checkAll();
                this.psSysContentCatGlobalModel.checkAll();
                this.psSysDEGroupGlobalModel.checkAll();
                this.psSysDERGroupGlobalModel.checkAll();
                this.psSubSysServiceAPIGlobalModel.checkAll();
                this.psSysSearchSchemeGlobalModel.checkAll();
                this.psSysEAISchemeGlobalModel.checkAll();
                this.psSysBISchemeGlobalModel.checkAll();
                this.psSysAIFactoryGlobalModel.checkAll();
                this.psSysSequenceGlobalModel.checkAll();
                this.psSysTranslatorGlobalModel.checkAll();
                this.psSysMsgQueueGlobalModel.checkAll();
                this.psSysMsgTargetGlobalModel.checkAll();
                Iterator<IPSDERBase> psDERBases = this.getAllPSDERs();
                while (psDERBases.hasNext()) {
                    IPSDERBase iPSDERBase = psDERBases.next();
                    iPSDERBase.check();
                }
                Iterator<IPSDataEntity> psDataEntities = this.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    IPSDataEntity iPSDataEntity = psDataEntities.next();
                    iPSDataEntity.check();
                }
                HashMap<String, IPSSysMethodDTO> psSysMethodDTOMap = new HashMap<String, IPSSysMethodDTO>();
                do {
                    ArrayList<IPSSysMethodDTO> list = new ArrayList<IPSSysMethodDTO>();
                    Iterator<IPSSysMethodDTO> psSysMethodDTOs = this.getAllPSSysMethodDTOs();
                    if (psSysMethodDTOs != null) {
                        while (psSysMethodDTOs.hasNext()) {
                            IPSSysMethodDTO iPSSysMethodDTO = psSysMethodDTOs.next();
                            list.add(iPSSysMethodDTO);
                        }
                    }
                    bLoop = false;
                    for (IPSSysMethodDTO iPSSysMethodDTO : list) {
                        if (psSysMethodDTOMap.containsKey(iPSSysMethodDTO.getCodeName())) continue;
                        iPSSysMethodDTO.check();
                        psSysMethodDTOMap.put(iPSSysMethodDTO.getCodeName(), iPSSysMethodDTO);
                        bLoop = true;
                    }
                } while (bLoop);
                this.psSysCounterGlobalModel.checkAll();
                this.psSysServiceAPIGlobalModel.checkAll();
                this.psWFRoleGlobalModel.checkAll();
                this.psWorkflowGlobalModel.checkAll();
                this.psSysERMapGlobalModel.checkAll();
                this.psSysViewLogicGlobalModel.checkAll();
                this.psSysTestDataGlobalModel.checkAll();
                this.psSysTestCaseGlobalModel.checkAll();
                this.psSysTestPrjGlobalModel.checkAll();
                ObjectNode objNode = JsonNodeHelper.createObjectNode();
                objNode.put(String.format("%1$s_cnt", "PSDATAENTITY").toLowerCase(), this.allPSDataEntityList == null ? 0 : this.allPSDataEntityList.size());
                objNode.put(String.format("%1$s_cnt", "PSMODULE").toLowerCase(), this.psSystemModuleGlobalModel.getAllModelHelperCount());
                objNode.put(String.format("%1$s_cnt", "PSSYSAPP").toLowerCase(), this.psSystemApplicationGlobalModel.getAllModelHelperCount());
                objNode.put(String.format("%1$s_cnt", "PSSYSSERVICEAPI").toLowerCase(), this.psSysServiceAPIGlobalModel.getAllModelHelperCount());
                objNode.put(String.format("%1$s_cnt", "PSWORKFLOW").toLowerCase(), this.psWorkflowGlobalModel.getAllModelHelperCount());
                this.info("\u6a21\u578b\u8ba1\u6570", null, objNode);
            }
            if (nLevel == 1) {
                psSysIssueEngines = this.getPSModelStorage().getAllPSSysIssueEngines();
                while (psSysIssueEngines.hasNext()) {
                    iPSSysIssueEngine = psSysIssueEngines.next();
                    if (iPSSysIssueEngine.getCheckLevel() != nLevel) continue;
                    iPSSysIssueEngine.checkPSSystem(this);
                }
                Iterator<IPSApplication> psApplications = this.getAllPSApps();
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    iPSApplication.check();
                }
                this.bQuickCheck = true;
            }
            this.bChecking = false;
            String strSQL = "SELECT COUNT(*) AS CNT FROM T_SRFPSSYSISSUE WHERE PSSYSTEMID=? AND ISSUETYPE='ERROR'";
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.addString(psSystem.getPSSystemId());
            ArrayList list = this.psSysIssueService.selectRaw(strSQL, sqlParamList);
            PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getRuntimePSSysModelInstId()));
            psSystemService.mergeChild("DER1N", "DER1N_PSSYSISSUE_PSSYSTEM_PSSYSTEMID", (Object)this.getId());
            this.psSysIssueService = null;
            int nCount = DataObject.getIntegerValue((Object)((IEntity)list.get(0)).get("CNT"), (Integer)0);
            return nCount;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u68c0\u67e5\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            try {
                PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getRuntimePSSysModelInstId()));
                psSystemService.mergeChild("DER1N", "DER1N_PSSYSISSUE_PSSYSTEM_PSSYSTEMID", (Object)this.getId());
            }
            catch (Exception ex2) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u95ee\u9898\u8ba1\u6570\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex2.getMessage()), (Throwable)ex2);
            }
            this.bChecking = false;
            this.psSysIssueService = null;
            throw ex;
        }
    }

    @Override
    public void quickCheck() throws Exception {
        if (this.bQuickCheck) {
            return;
        }
        this.onQuickCheck();
        this.bQuickCheck = true;
    }

    protected void onQuickCheck() throws Exception {
        boolean bLoop;
        this.psSysUniStateGlobalModel.checkAll();
        this.psSysUtilGlobalModel.checkAll();
        this.psSysDTSQueueGlobalModel.checkAll();
        this.psSysSampleValueGlobalModel.checkAll();
        this.psSysUserModeGlobalModel.checkAll();
        this.psSysReqItemGlobalModel.checkAll();
        this.psSysReqModuleGlobalModel.checkAll();
        this.psSysActorGlobalModel.checkAll();
        this.psSysUseCaseGlobalModel.checkAll();
        this.psSysUseCaseRSGlobalModel.checkAll();
        this.psSysUniResGlobalModel.checkAll();
        this.psDEFInputTipSetGlobalModel.checkAll();
        this.psSysDEFInputTipGlobalModel.checkAll();
        this.psViewMsgGlobalModel.checkAll();
        this.psViewMsgGroupGlobalModel.checkAll();
        this.psSysMsgTemplGlobalModel.checkAll();
        this.psSysPFPluginTemplGlobalModel.checkAll();
        this.psSysPFPluginGlobalModel.checkAll();
        this.psSysDEUIActionGroupGlobalModel.checkAll();
        this.psSubSysRefGlobalModel.checkAll();
        this.psCodeListGlobalModel.checkAll();
        this.psSysImageGlobalModel.checkAll();
        this.psSysCssGlobalModel.checkAll();
        this.psSysValueRuleGlobalModel.checkAll();
        this.psSubViewTypeGlobalModel.checkAll();
        this.psDEOPPrivGlobalModel.checkAll();
        this.psSysPDTViewGlobalModel.checkAll();
        this.psSysDataSyncAgentGlobalModel.checkAll();
        this.psSysUserModeGlobalModel.checkAll();
        this.psSysUserDRGlobalModel.checkAll();
        this.psSysBDSchemeGlobalModel.checkAll();
        this.psSysDBSchemeGlobalModel.checkAll();
        this.psSysResourceGlobalModel.checkAll();
        this.psSysContentCatGlobalModel.checkAll();
        this.psSysDEGroupGlobalModel.checkAll();
        this.psSysDERGroupGlobalModel.checkAll();
        this.psSubSysServiceAPIGlobalModel.checkAll();
        this.psSysSearchSchemeGlobalModel.checkAll();
        this.psSysEAISchemeGlobalModel.checkAll();
        this.psSysBISchemeGlobalModel.checkAll();
        this.psSysAIFactoryGlobalModel.checkAll();
        this.psSysSequenceGlobalModel.checkAll();
        this.psSysTranslatorGlobalModel.checkAll();
        this.psSysMsgQueueGlobalModel.checkAll();
        this.psSysMsgTargetGlobalModel.checkAll();
        Iterator<IPSDERBase> psDERBases = this.getAllPSDERs();
        while (psDERBases.hasNext()) {
            IPSDERBase iPSDERBase = psDERBases.next();
            iPSDERBase.check();
        }
        Iterator<IPSDataEntity> psDataEntities = this.getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            IPSDataEntity iPSDataEntity = psDataEntities.next();
            iPSDataEntity.check();
        }
        HashMap<String, IPSSysMethodDTO> psSysMethodDTOMap = new HashMap<String, IPSSysMethodDTO>();
        do {
            ArrayList<IPSSysMethodDTO> list = new ArrayList<IPSSysMethodDTO>();
            Iterator<IPSSysMethodDTO> psSysMethodDTOs = this.getAllPSSysMethodDTOs();
            if (psSysMethodDTOs != null) {
                while (psSysMethodDTOs.hasNext()) {
                    IPSSysMethodDTO iPSSysMethodDTO = psSysMethodDTOs.next();
                    list.add(iPSSysMethodDTO);
                }
            }
            bLoop = false;
            for (IPSSysMethodDTO iPSSysMethodDTO : list) {
                if (psSysMethodDTOMap.containsKey(iPSSysMethodDTO.getCodeName())) continue;
                iPSSysMethodDTO.check();
                psSysMethodDTOMap.put(iPSSysMethodDTO.getCodeName(), iPSSysMethodDTO);
                bLoop = true;
            }
        } while (bLoop);
        this.psSysCounterGlobalModel.checkAll();
        this.psSysServiceAPIGlobalModel.checkAll();
        this.psWFRoleGlobalModel.checkAll();
        this.psWorkflowGlobalModel.checkAll();
        this.psSysERMapGlobalModel.checkAll();
        this.psSysViewLogicGlobalModel.checkAll();
        this.psSysTestDataGlobalModel.checkAll();
        this.psSysTestCaseGlobalModel.checkAll();
        this.psSysTestPrjGlobalModel.checkAll();
        Iterator<IPSApplication> psApplications = this.getAllPSApps();
        while (psApplications.hasNext()) {
            IPSApplication iPSApplication = psApplications.next();
            iPSApplication.check();
        }
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception {
        return (IPSDEUIActionGroup)this.psSysDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return (IPSDEUIActionGroup)this.psSysDEUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
    }

    @Override
    public void resetPSDEUIActionGroup(String strDEUIActionGroupId) {
        this.psSysDEUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEUIActionGroup> getAllPSDEUIActionGroups() throws Exception {
        return this.psSysDEUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSystem.getLOGICNAME();
    }

    @Override
    public Iterator<IPSSysDMItem> getAllPSSysDMItems() throws Exception {
        return this.psSysDMItemGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSSysDMItem> getPSSysDMItems(String strDBType) throws Exception {
        return this.psSysDMItemGlobalModel.getPSSysDMItemList(strDBType);
    }

    @Override
    public IPSSysDMItem getLastTestPSSysDMItem(String strDBType) throws Exception {
        return this.psSysDMItemGlobalModel.getLastTestPSSysDMItem(strDBType);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u64cd\u4f5c\u8005\u96c6\u5408", group="\u9700\u6c42&\u7528\u4f8b", order=160, child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysActor> getAllPSSysActors() throws Exception {
        return this.psSysActorGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysActor getPSSysActor(String strSysActorId) throws Exception {
        return (IPSSysActor)this.psSysActorGlobalModel.FindModelHelper(strSysActorId);
    }

    @Override
    public IPSSysActor getPSSysActor(String strSysActorId, boolean bTryMode) throws Exception {
        return (IPSSysActor)this.psSysActorGlobalModel.FindModelHelper(strSysActorId, bTryMode);
    }

    @Override
    public void resetPSSysActor(String strSysActorId) {
        this.psSysActorGlobalModel.ResetModel(strSysActorId);
    }

    @Override
    public void resetAllPSSysActors() {
        this.psSysActorGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7528\u4f8b\u96c6\u5408", group="\u9700\u6c42&\u7528\u4f8b", order=162, child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysUseCase> getAllPSSysUseCases() throws Exception {
        return this.psSysUseCaseGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUseCase getPSSysUseCase(String strSysUseCaseId) throws Exception {
        return (IPSSysUseCase)this.psSysUseCaseGlobalModel.FindModelHelper(strSysUseCaseId);
    }

    @Override
    public IPSSysUseCase getPSSysUseCase(String strSysUseCaseId, boolean bTryMode) throws Exception {
        return (IPSSysUseCase)this.psSysUseCaseGlobalModel.FindModelHelper(strSysUseCaseId, bTryMode);
    }

    @Override
    public void resetPSSysUseCase(String strSysUseCaseId) {
        this.psSysUseCaseGlobalModel.ResetModel(strSysUseCaseId);
    }

    @Override
    public void resetAllPSSysUseCases() {
        this.psSysUseCaseGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7528\u4f8b\u5173\u7cfb\u96c6\u5408", order=19, outputdoc="false")
    public Iterator<IPSSysUseCaseRS> getAllPSSysUseCaseRSs() throws Exception {
        return this.psSysUseCaseRSGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUseCaseRS getPSSysUseCaseRS(String strSysUseCaseRSId) throws Exception {
        return (IPSSysUseCaseRS)this.psSysUseCaseRSGlobalModel.FindModelHelper(strSysUseCaseRSId);
    }

    @Override
    public IPSSysUseCaseRS getPSSysUseCaseRS(String strSysUseCaseRSId, boolean bTryMode) throws Exception {
        return (IPSSysUseCaseRS)this.psSysUseCaseRSGlobalModel.FindModelHelper(strSysUseCaseRSId, bTryMode);
    }

    @Override
    public void resetPSSysUseCaseRS(String strSysUseCaseRSId) {
        this.psSysUseCaseRSGlobalModel.ResetModel(strSysUseCaseRSId);
    }

    @Override
    public void resetAllPSSysUseCaseRSs() {
        this.psSysUseCaseRSGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u96c6\u5408", hideempty2=true, group="\u6d4b\u8bd5", order=443, outputdoc="false")
    public Iterator<IPSSysTestCase> getAllPSSysTestCases() throws Exception {
        return this.psSysTestCaseGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysTestCase getPSSysTestCase(String strSysTestCaseId) throws Exception {
        return (IPSSysTestCase)this.psSysTestCaseGlobalModel.FindModelHelper(strSysTestCaseId);
    }

    @Override
    public IPSSysTestCase getPSSysTestCase(String strSysTestCaseId, boolean bTryMode) throws Exception {
        return (IPSSysTestCase)this.psSysTestCaseGlobalModel.FindModelHelper(strSysTestCaseId, bTryMode);
    }

    @Override
    public void resetPSSysTestCase(String strSysTestCaseId) {
        this.psSysTestCaseGlobalModel.ResetModel(strSysTestCaseId);
    }

    @Override
    public void resetAllPSSysTestCases() {
        this.psSysTestCaseGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u6570\u636e\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, hideempty2=true, group="\u6d4b\u8bd5", order=445)
    public Iterator<IPSSysTestData> getAllPSSysTestDatas() throws Exception {
        return this.psSysTestDataGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysTestData getPSSysTestData(String strSysTestDataId) throws Exception {
        return (IPSSysTestData)this.psSysTestDataGlobalModel.FindModelHelper(strSysTestDataId);
    }

    @Override
    public IPSSysTestData getPSSysTestData(String strSysTestDataId, boolean bTryMode) throws Exception {
        return (IPSSysTestData)this.psSysTestDataGlobalModel.FindModelHelper(strSysTestDataId, bTryMode);
    }

    @Override
    public void resetPSSysTestData(String strSysTestDataId) {
        this.psSysTestDataGlobalModel.ResetModel(strSysTestDataId);
    }

    @Override
    public void resetAllPSSysTestDatas() {
        this.psSysTestDataGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u503c\u96c6\u5408", child=true, dumpref=true, dynamodelmode=8, group="\u5904\u7406\u903b\u8f91", order=516)
    public Iterator<IPSSysSampleValue> getAllPSSysSampleValues() throws Exception {
        return this.psSysSampleValueGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysSampleValue getPSSysSampleValue(String strSysSampleValueId) throws Exception {
        return (IPSSysSampleValue)this.psSysSampleValueGlobalModel.FindModelHelper(strSysSampleValueId);
    }

    @Override
    public IPSSysSampleValue getPSSysSampleValue(String strSysSampleValueId, boolean bTryMode) throws Exception {
        return (IPSSysSampleValue)this.psSysSampleValueGlobalModel.FindModelHelper(strSysSampleValueId, bTryMode);
    }

    @Override
    public void resetPSSysSampleValue(String strSysSampleValueId) {
        this.psSysSampleValueGlobalModel.ResetModel(strSysSampleValueId);
    }

    @Override
    public void resetAllPSSysSampleValues() {
        this.psSysSampleValueGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u5f0f\u96c6\u5408", child=true, dynamodelmode=8, group="\u8bbf\u95ee\u63a7\u5236", order=418)
    public Iterator<IPSSysUserMode> getAllPSSysUserModes() throws Exception {
        return this.psSysUserModeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUserMode getPSSysUserMode(String strSysUserModeId) throws Exception {
        return (IPSSysUserMode)this.psSysUserModeGlobalModel.FindModelHelper(strSysUserModeId);
    }

    @Override
    public IPSSysUserMode getPSSysUserMode(String strSysUserModeId, boolean bTryMode) throws Exception {
        return (IPSSysUserMode)this.psSysUserModeGlobalModel.FindModelHelper(strSysUserModeId, bTryMode);
    }

    @Override
    public void resetPSSysUserMode(String strSysUserModeId) throws Exception {
        this.psSysUserModeGlobalModel.ResetModel(strSysUserModeId);
    }

    @Override
    public void resetAllPSSysUserModes() {
        this.psSysUserModeGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u96c6\u5408", child=true, dynamodelmode=4, group="\u8bbf\u95ee\u63a7\u5236", order=420)
    public Iterator<IPSSysUserDR> getAllPSSysUserDRs() throws Exception {
        return this.psSysUserDRGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUserDR getPSSysUserDR(String strSysUserDRId) throws Exception {
        return (IPSSysUserDR)this.psSysUserDRGlobalModel.FindModelHelper(strSysUserDRId);
    }

    @Override
    public IPSSysUserDR getPSSysUserDR(String strSysUserDRId, boolean bTryMode) throws Exception {
        return (IPSSysUserDR)this.psSysUserDRGlobalModel.FindModelHelper(strSysUserDRId, bTryMode);
    }

    @Override
    public void resetPSSysUserDR(String strSysUserDRId) throws Exception {
        this.psSysUserDRGlobalModel.ResetModel(strSysUserDRId);
    }

    @Override
    public void resetAllPSSysUserDRs() {
        this.psSysUserDRGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="ER\u56fe\u96c6\u5408", group="\u6570\u636e\u6a21\u578b", order=193, child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysERMap> getAllPSSysERMaps() throws Exception {
        return this.psSysERMapGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysERMap getPSSysERMap(String strSysERMapId) throws Exception {
        return (IPSSysERMap)this.psSysERMapGlobalModel.FindModelHelper(strSysERMapId);
    }

    @Override
    public IPSSysERMap getPSSysERMap(String strSysERMapId, boolean bTryMode) throws Exception {
        return (IPSSysERMap)this.psSysERMapGlobalModel.FindModelHelper(strSysERMapId, bTryMode);
    }

    @Override
    public void resetPSSysERMap(String strSysERMapId) {
        this.psSysERMapGlobalModel.ResetModel(strSysERMapId);
    }

    @Override
    public void resetAllPSSysERMaps() {
        this.psSysERMapGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="UC\u56fe\u96c6\u5408", group="\u9700\u6c42&\u7528\u4f8b", order=163, child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysUCMap> getAllPSSysUCMaps() throws Exception {
        return this.psSysUCMapGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUCMap getPSSysUCMap(String strSysUCMapId) throws Exception {
        return (IPSSysUCMap)this.psSysUCMapGlobalModel.FindModelHelper(strSysUCMapId);
    }

    @Override
    public IPSSysUCMap getPSSysUCMap(String strSysUCMapId, boolean bTryMode) throws Exception {
        return (IPSSysUCMap)this.psSysUCMapGlobalModel.FindModelHelper(strSysUCMapId, bTryMode);
    }

    @Override
    public void resetPSSysUCMap(String strSysUCMapId) {
        this.psSysUCMapGlobalModel.ResetModel(strSysUCMapId);
    }

    @Override
    public void resetAllPSSysUCMaps() {
        this.psSysUCMapGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u53d1\u5e03\u96c6\u5408", child=true, dumpref=true, dynamodelmode=8, group="\u524d\u7aef&\u540e\u53f0", order=235)
    public Iterator<IPSSysSFPub> getAllPSSysSFPubs() throws Exception {
        this.active();
        return this.psSysSFPubGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysSFPub getPSSysSFPub(String strSysSFPubId) throws Exception {
        this.active();
        return (IPSSysSFPub)this.psSysSFPubGlobalModel.FindModelHelper(strSysSFPubId);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7cfb\u7edf\u540e\u53f0\u53d1\u5e03", child=true, dynamodelmode=4, ignorert=3)
    public IPSSysSFPub getDefaultPSSysSFPub() {
        this.active();
        return this.psSysSFPubGlobalModel.getDefaultPSSysSFPub();
    }

    @Override
    public void resetPSSysSFPub(String strSysSFPubId) {
        this.psSysSFPubGlobalModel.ResetModel(strSysSFPubId);
    }

    @Override
    public void resetAllPSSysSFPubs() {
        this.psSysSFPubGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5904\u7406\u5bf9\u8c61\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysServiceAPIHandler> getAllPSSysServiceAPIHandlers() throws Exception {
        this.active();
        return this.psSysServiceAPIHandlerGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysServiceAPIHandler getPSSysServiceAPIHandler(String strSysServiceAPIHandlerId) throws Exception {
        this.active();
        return (IPSSysServiceAPIHandler)this.psSysServiceAPIHandlerGlobalModel.FindModelHelper(strSysServiceAPIHandlerId);
    }

    @Override
    public IPSSysServiceAPIHandler getPSSysServiceAPIHandler(String strSysServiceAPIHandlerId, boolean bTryMode) throws Exception {
        this.active();
        return (IPSSysServiceAPIHandler)this.psSysServiceAPIHandlerGlobalModel.FindModelHelper(strSysServiceAPIHandlerId, bTryMode);
    }

    @Override
    public IPSSysServiceAPIHandler getPSSysServiceAPIHandlerByPredefinedType(String strPredefinedType, boolean bTryMode) throws Exception {
        this.active();
        String strSysServiceAPIHandlerId = KeyValueHelper.genUniqueId((String)(String.valueOf(strPredefinedType) + "HANDLER"), (String)this.getPSSFId());
        strSysServiceAPIHandlerId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strSysServiceAPIHandlerId);
        IPSSysServiceAPIHandler iPSSysServiceAPIHandler = (IPSSysServiceAPIHandler)this.psSysServiceAPIHandlerGlobalModel.FindModelHelper(strSysServiceAPIHandlerId, true);
        if (iPSSysServiceAPIHandler != null) {
            return iPSSysServiceAPIHandler;
        }
        return (IPSSysServiceAPIHandler)this.psSysServiceAPIHandlerGlobalModel.FindModelHelper(strPredefinedType, bTryMode);
    }

    @Override
    public void resetPSSysServiceAPIHandler(String strSysServiceAPIHandlerId) {
        this.psSysServiceAPIHandlerGlobalModel.ResetModel(strSysServiceAPIHandlerId);
    }

    @Override
    public void resetAllPSSysServiceAPIHandlers() {
        this.psSysServiceAPIHandlerGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u524d\u7aef&\u540e\u53f0", order=226)
    public Iterator<IPSSysServiceAPI> getAllPSSysServiceAPIs() throws Exception {
        this.active();
        return this.psSysServiceAPIGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysServiceAPI getPSSysServiceAPI(String strSysServiceAPIId) throws Exception {
        this.active();
        return (IPSSysServiceAPI)this.psSysServiceAPIGlobalModel.FindModelHelper(strSysServiceAPIId);
    }

    @Override
    public IPSSysServiceAPI getPSSysServiceAPI(String strSysServiceAPIId, boolean bTryMode) throws Exception {
        this.active();
        return (IPSSysServiceAPI)this.psSysServiceAPIGlobalModel.FindModelHelper(strSysServiceAPIId, bTryMode);
    }

    @Override
    public void resetPSSysServiceAPI(String strSysServiceAPIId) {
        this.psSysServiceAPIGlobalModel.ResetModel(strSysServiceAPIId);
    }

    @Override
    public void resetAllPSSysServiceAPIs() {
        this.psSysServiceAPIGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=350)
    public Iterator<IPSSubSysServiceAPI> getAllPSSubSysServiceAPIs() throws Exception {
        this.active();
        return this.psSubSysServiceAPIGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSubSysServiceAPI getPSSubSysServiceAPI(String strSubSysServiceAPIId) throws Exception {
        this.active();
        return (IPSSubSysServiceAPI)this.psSubSysServiceAPIGlobalModel.FindModelHelper(strSubSysServiceAPIId);
    }

    @Override
    public IPSSubSysServiceAPI getPSSubSysServiceAPI(String strSubSysServiceAPIId, boolean bTryMode) throws Exception {
        this.active();
        return (IPSSubSysServiceAPI)this.psSubSysServiceAPIGlobalModel.FindModelHelper(strSubSysServiceAPIId, bTryMode);
    }

    @Override
    public void resetPSSubSysServiceAPI(String strSubSysServiceAPIId) {
        this.psSubSysServiceAPIGlobalModel.ResetModel(strSubSysServiceAPIId);
    }

    @Override
    public void resetAllPSSubSysServiceAPIs() {
        this.psSubSysServiceAPIGlobalModel.ResetAll();
    }

    @Override
    public void writeFile(String strFullPath, String strCode, Object strTag) throws Exception {
        IPSJITWebContext iPSJITWebContext = PSJITWebContext.getInstance();
        if (iPSJITWebContext != null) {
            iPSJITWebContext.writeFile(strFullPath, strCode, strTag);
            return;
        }
        if (this.iPSSystemUtil != null) {
            this.iPSSystemUtil.writeFile(strFullPath, strCode, strTag);
        } else {
            FileWriterHelper.write(strFullPath, strCode);
        }
    }

    @Override
    public boolean writeFile2(String strFullPath, String strCode, Object strTag) throws Exception {
        IPSJITWebContext iPSJITWebContext = PSJITWebContext.getInstance();
        if (iPSJITWebContext != null) {
            iPSJITWebContext.writeFile(strFullPath, strCode, strTag);
            return false;
        }
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.writeFile2(strFullPath, strCode, strTag);
        }
        return FileWriterHelper.write2(strFullPath, strCode);
    }

    @Override
    public void resetFileCache() {
        if (this.iPSSystemUtil != null) {
            this.iPSSystemUtil.resetFileCache();
        }
    }

    @Override
    public IPSSysDataSyncAgent getPSSysDataSyncAgent(String strSysDataSyncAgentId) throws Exception {
        return (IPSSysDataSyncAgent)this.psSysDataSyncAgentGlobalModel.FindModelHelper(strSysDataSyncAgentId);
    }

    @Override
    public IPSSysDataSyncAgent getPSSysDataSyncAgent(String strPSSysDataSyncAgentId, boolean bTryMode) throws Exception {
        return (IPSSysDataSyncAgent)this.psSysDataSyncAgentGlobalModel.FindModelHelper(strPSSysDataSyncAgentId, bTryMode);
    }

    @Override
    public void resetPSSysDataSyncAgent(String strSysDataSyncAgentId) {
        this.psSysDataSyncAgentGlobalModel.ResetModel(strSysDataSyncAgentId);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u540c\u6b65\u4ee3\u7406\u96c6\u5408", child=true, dynamodelmode=5, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=350)
    public Iterator<IPSSysDataSyncAgent> getAllPSSysDataSyncAgents() throws Exception {
        return this.psSysDataSyncAgentGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u4f53\u7cfb\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=355)
    public Iterator<IPSSysBDScheme> getAllPSSysBDSchemes() throws Exception {
        return this.psSysBDSchemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDScheme getPSSysBDScheme(String strSysBDSchemeId) throws Exception {
        return (IPSSysBDScheme)this.psSysBDSchemeGlobalModel.FindModelHelper(strSysBDSchemeId);
    }

    @Override
    public IPSSysBDScheme getPSSysBDScheme(String strSysBDSchemeId, boolean bTryMode) throws Exception {
        return (IPSSysBDScheme)this.psSysBDSchemeGlobalModel.FindModelHelper(strSysBDSchemeId, bTryMode);
    }

    @Override
    public void resetPSSysBDScheme(String strSysBDSchemeId) throws Exception {
        this.psSysBDSchemeGlobalModel.ResetModel(strSysBDSchemeId);
    }

    @Override
    public void resetAllPSSysBDSchemes() {
        this.psSysBDSchemeGlobalModel.ResetAll();
    }

    @Override
    public String getModelType() {
        return "PSSYSTEM";
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5f15\u64ce\u7248\u672c")
    public int getEngineVer() {
        return this.nEngineVer;
    }

    @Override
    public boolean testEngineVer(int nVer) {
        return this.getEngineVer() >= nVer;
    }

    @Override
    public boolean hasPSJITSystemModel() throws Exception {
        return this.iPSJITSystemModel != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSJITSystemModel getPSJITSystemModel(boolean bPreviewMode) throws Exception {
        Object object = this.objPSJITSystemModelLock;
        synchronized (object) {
            PSJITSystemModel psJITSystemModel;
            block6: {
                if (this.iPSJITSystemModel != null) {
                    return this.iPSJITSystemModel;
                }
                psJITSystemModel = new PSJITSystemModel();
                IPSDBDevInst jitPSDBDevInst = this.getJITPSDBDevInst();
                if (jitPSDBDevInst == null) {
                    throw new Exception("\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
                }
                IPSDBType iDBType = this.getPSModelStorage().getPSDBType(jitPSDBDevInst.getDBType());
                SessionFactory SessionFactory2 = PSDBDevInstGlobal.getSessionFactory(jitPSDBDevInst.getId());
                IDBDialect iDBDialect = (IDBDialect)ObjectHelper.Create((String)iDBType.getJdbcDialect());
                psJITSystemModel.setDBDialect(iDBDialect);
                psJITSystemModel.setSessionFactory(SessionFactory2);
                if (psJITSystemModel.init(this.getDAGlobalHelper(), this, bPreviewMode)) break block6;
                return null;
            }
            this.iPSJITSystemModel = psJITSystemModel;
            return this.iPSJITSystemModel;
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u6e90\u914d\u7f6e", group="\u6570\u636e\u5e93\u5b58\u50a8", order=252)
    public IPSSystemDBConfig getDefaultPSSystemDBConfig() {
        return this.psSystemDBConfigGlobalModel.getDefaultPSSystemDBConfig();
    }

    @Override
    public Iterator<IPSSysDEFInputTip> getAllPSSysDEFInputTips() throws Exception {
        return this.psSysDEFInputTipGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDEFInputTip getPSSysDEFInputTip(String strSysDEFInputTipId) throws Exception {
        return (IPSSysDEFInputTip)this.psSysDEFInputTipGlobalModel.FindModelHelper(strSysDEFInputTipId);
    }

    @Override
    public IPSSysDEFInputTip getPSSysDEFInputTip(String strSysDEFInputTipId, boolean bTryMode) throws Exception {
        return (IPSSysDEFInputTip)this.psSysDEFInputTipGlobalModel.FindModelHelper(strSysDEFInputTipId, bTryMode);
    }

    @Override
    public void resetPSSysDEFInputTip(String strSysDEFInputTipId) throws Exception {
        this.psSysDEFInputTipGlobalModel.ResetModel(strSysDEFInputTipId);
    }

    @Override
    public void resetAllPSSysDEFInputTips() {
        this.psSysDEFInputTipGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u7ec4\u96c6\u5408", outputdoc="false")
    public Iterator<IPSViewMsgGroup> getAllPSViewMsgGroups() throws Exception {
        return this.psViewMsgGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup(String strViewMsgGroupId) throws Exception {
        return (IPSViewMsgGroup)this.psViewMsgGroupGlobalModel.FindModelHelper(strViewMsgGroupId);
    }

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup(String strViewMsgGroupId, boolean bTryMode) throws Exception {
        return (IPSViewMsgGroup)this.psViewMsgGroupGlobalModel.FindModelHelper(strViewMsgGroupId, bTryMode);
    }

    @Override
    public void resetPSViewMsgGroup(String strViewMsgGroupId) throws Exception {
        this.psViewMsgGroupGlobalModel.ResetModel(strViewMsgGroupId);
    }

    @Override
    public void resetAllPSViewMsgGroups() {
        this.psViewMsgGroupGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u96c6\u5408", outputdoc="false")
    public Iterator<IPSViewMsg> getAllPSViewMsgs() throws Exception {
        return this.psViewMsgGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSViewMsg getPSViewMsg(String strViewMsgId) throws Exception {
        return (IPSViewMsg)this.psViewMsgGlobalModel.FindModelHelper(strViewMsgId);
    }

    @Override
    public IPSViewMsg getPSViewMsg(String strViewMsgId, boolean bTryMode) throws Exception {
        return (IPSViewMsg)this.psViewMsgGlobalModel.FindModelHelper(strViewMsgId, bTryMode);
    }

    @Override
    public void resetPSViewMsg(String strViewMsgId) throws Exception {
        this.psViewMsgGlobalModel.ResetModel(strViewMsgId);
    }

    @Override
    public void resetAllPSViewMsgs() {
        this.psViewMsgGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDEFInputTipSet> getAllPSDEFInputTipSets() throws Exception {
        return this.psDEFInputTipSetGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEFInputTipSet getPSDEFInputTipSet(String strDEFInputTipSetId) throws Exception {
        return (IPSDEFInputTipSet)this.psDEFInputTipSetGlobalModel.FindModelHelper(strDEFInputTipSetId);
    }

    @Override
    public IPSDEFInputTipSet getPSDEFInputTipSet(String strDEFInputTipSetId, boolean bTryMode) throws Exception {
        return (IPSDEFInputTipSet)this.psDEFInputTipSetGlobalModel.FindModelHelper(strDEFInputTipSetId, bTryMode);
    }

    @Override
    public void resetPSDEFInputTipSet(String strDEFInputTipSetId) throws Exception {
        this.psDEFInputTipSetGlobalModel.ResetModel(strDEFInputTipSetId);
    }

    @Override
    public void resetAllPSDEFInputTipSets() {
        this.psDEFInputTipSetGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u72b6\u6001\u96c6\u5408", child=true)
    public Iterator<IPSSysUniState> getAllPSSysUniStates() throws Exception {
        return this.psSysUniStateGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUniState getPSSysUniState(String strSysUniStateId) throws Exception {
        return (IPSSysUniState)this.psSysUniStateGlobalModel.FindModelHelper(strSysUniStateId);
    }

    @Override
    public IPSSysUniState getPSSysUniState(String strSysUniStateId, boolean bTryMode) throws Exception {
        return (IPSSysUniState)this.psSysUniStateGlobalModel.FindModelHelper(strSysUniStateId, bTryMode);
    }

    @Override
    public void resetPSSysUniState(String strSysUniStateId) throws Exception {
        this.psSysUniStateGlobalModel.ResetModel(strSysUniStateId);
    }

    @Override
    public void resetAllPSSysUniStates() {
        this.psSysUniStateGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406\u961f\u5217\u96c6\u5408", child=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=351)
    public Iterator<IPSSysDTSQueue> getAllPSSysDTSQueues() throws Exception {
        return this.psSysDTSQueueGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDTSQueue getPSSysDTSQueue(String strSysDTSQueueId) throws Exception {
        return (IPSSysDTSQueue)this.psSysDTSQueueGlobalModel.FindModelHelper(strSysDTSQueueId);
    }

    @Override
    public IPSSysDTSQueue getPSSysDTSQueue(String strSysDTSQueueId, boolean bTryMode) throws Exception {
        return (IPSSysDTSQueue)this.psSysDTSQueueGlobalModel.FindModelHelper(strSysDTSQueueId, bTryMode);
    }

    @Override
    public void resetPSSysDTSQueue(String strSysDTSQueueId) throws Exception {
        this.psSysDTSQueueGlobalModel.ResetModel(strSysDTSQueueId);
    }

    @Override
    public void resetAllPSSysDTSQueues() {
        this.psSysDTSQueueGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u516c\u4f17\u53f7\u96c6\u5408", child=true, dumpref=true, outputdoc="false")
    public Iterator<IPSWXAccount> getAllPSWXAccounts() throws Exception {
        return this.psWXAccountGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSWXAccount getPSWXAccount(String strWXAccountId) throws Exception {
        return (IPSWXAccount)this.psWXAccountGlobalModel.FindModelHelper(strWXAccountId);
    }

    @Override
    public IPSWXAccount getPSWXAccount(String strWXAccountId, boolean bTryMode) throws Exception {
        return (IPSWXAccount)this.psWXAccountGlobalModel.FindModelHelper(strWXAccountId, bTryMode);
    }

    @Override
    public void resetPSWXAccount(String strWXAccountId) throws Exception {
        this.psWXAccountGlobalModel.ResetModel(strWXAccountId);
    }

    @Override
    public void resetAllPSWXAccounts() {
        this.psWXAccountGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6d88\u606f\u96c6\u5408")
    public Iterator<IPSCtrlMsg> getAllPSCtrlMsgs() throws Exception {
        return this.psCtrlMsgGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSCtrlMsg getPSCtrlMsg(String strCtrlMsgId) throws Exception {
        return (IPSCtrlMsg)this.psCtrlMsgGlobalModel.FindModelHelper(strCtrlMsgId);
    }

    @Override
    public IPSCtrlMsg getPSCtrlMsg(String strCtrlMsgId, boolean bTryMode) throws Exception {
        return (IPSCtrlMsg)this.psCtrlMsgGlobalModel.FindModelHelper(strCtrlMsgId, bTryMode);
    }

    @Override
    public void resetPSCtrlMsg(String strCtrlMsgId) throws Exception {
        this.psCtrlMsgGlobalModel.ResetModel(strCtrlMsgId);
    }

    @Override
    public void resetAllPSCtrlMsgs() {
        this.psCtrlMsgGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u96c6\u5408")
    public Iterator<IPSSysUnit> getAllPSSysUnits() throws Exception {
        return this.psSysUnitGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUnit getPSSysUnit(String strSysUnitId) throws Exception {
        return (IPSSysUnit)this.psSysUnitGlobalModel.FindModelHelper(strSysUnitId);
    }

    @Override
    public IPSSysUnit getPSSysUnit(String strSysUnitId, boolean bTryMode) throws Exception {
        return (IPSSysUnit)this.psSysUnitGlobalModel.FindModelHelper(strSysUnitId, bTryMode);
    }

    @Override
    public void resetPSSysUnit(String strSysUnitId) throws Exception {
        this.psSysUnitGlobalModel.ResetModel(strSysUnitId);
    }

    @Override
    public void resetAllPSSysUnits() {
        this.psSysUnitGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6587\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysFile> getAllPSSysFiles() throws Exception {
        return this.psSysFileGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysFile getPSSysFile(String strSysFileId) throws Exception {
        return (IPSSysFile)this.psSysFileGlobalModel.FindModelHelper(strSysFileId);
    }

    @Override
    public void resetPSSysFile(String strSysFileId) throws Exception {
        this.psSysFileGlobalModel.ResetModel(strSysFileId);
    }

    @Override
    public void resetAllPSSysFiles() {
        this.psSysFileGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSLanguageRes> getAllPSLanguageReses() throws Exception {
        return this.psLanguageResGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSLanguageRes getPSLanguageRes(String strLanguageResId) throws Exception {
        IPSLanguageRes iPSLanguageRes = (IPSLanguageRes)this.psLanguageResGlobalModel.FindModelHelper(strLanguageResId);
        iPSLanguageRes.markSysRef();
        return iPSLanguageRes;
    }

    @Override
    public void resetPSLanguageRes(String strLanguageResId) throws Exception {
        this.psLanguageResGlobalModel.ResetModel(strLanguageResId);
    }

    @Override
    public void resetAllPSLanguageReses() {
        this.psLanguageResGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSLanguageItem> getAllPSLanguageItems() throws Exception {
        return this.psLanguageItemGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSLanguageItem getPSLanguageItem(String strLanguageItemId, boolean bTryMode) throws Exception {
        return (IPSLanguageItem)this.psLanguageItemGlobalModel.FindModelHelper(strLanguageItemId, bTryMode);
    }

    @Override
    public void resetPSLanguageItem(String strLanguageItemId) throws Exception {
        this.psLanguageItemGlobalModel.ResetModel(strLanguageItemId);
    }

    @Override
    public void resetAllPSLanguageItems() {
        this.psLanguageItemGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5e2e\u52a9\u6587\u7ae0\u96c6\u5408", dump=false, outputdoc="false")
    public Iterator<IPSHelpArticle> getAllPSHelpArticles() throws Exception {
        return this.psHelpArticleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSHelpArticle getPSHelpArticle(String strHelpArticleId) throws Exception {
        return (IPSHelpArticle)this.psHelpArticleGlobalModel.FindModelHelper(strHelpArticleId);
    }

    @Override
    public void resetPSHelpArticle(String strHelpArticleId) throws Exception {
        this.psHelpArticleGlobalModel.ResetModel(strHelpArticleId);
    }

    @Override
    public void resetAllPSHelpArticles() {
        this.psHelpArticleGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5e2e\u52a9\u9879\u76ee\u96c6\u5408", dump=false, outputdoc="false")
    public Iterator<IPSHelpPrj> getAllPSHelpPrjs() throws Exception {
        return this.psHelpPrjGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSHelpPrj getPSHelpPrj(String strHelpPrjId) throws Exception {
        return (IPSHelpPrj)this.psHelpPrjGlobalModel.FindModelHelper(strHelpPrjId);
    }

    @Override
    public void resetPSHelpPrj(String strHelpPrjId) throws Exception {
        this.psHelpPrjGlobalModel.ResetModel(strHelpPrjId);
    }

    @Override
    public void resetAllPSHelpPrjs() {
        this.psHelpPrjGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5e2e\u52a9\u8d44\u6e90\u96c6\u5408", dump=false, outputdoc="false")
    public Iterator<IPSHelpResource> getAllPSHelpResources() throws Exception {
        return this.psHelpResourceGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSHelpResource getPSHelpResource(String strHelpResourceId) throws Exception {
        return (IPSHelpResource)this.psHelpResourceGlobalModel.FindModelHelper(strHelpResourceId);
    }

    @Override
    public void resetPSHelpResource(String strHelpResourceId) throws Exception {
        this.psHelpResourceGlobalModel.ResetModel(strHelpResourceId);
    }

    @Override
    public void resetAllPSHelpResources() {
        this.psHelpResourceGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception {
        return this.psSysLanGlobalModel.getAllModelHelpers();
    }

    @Override
    public void resetAllPSSysLans() {
        this.psSysLanGlobalModel.ResetAll();
    }

    @Override
    public ArrayList<IPSObject> getPSModels(String strModelType, String strModelId) throws Exception {
        String strModelTag = StringHelper.Format((String)"%1$s|%2$s", (Object)strModelType, (Object)strModelId);
        ArrayList<IPSObject> psModelList = null;
        psModelList = this.psModelListMap.get(strModelTag);
        if (psModelList != null) {
            return psModelList;
        }
        psModelList = PSModels.getPSModels(this, strModelType, strModelId);
        this.psModelListMap.put(strModelTag, psModelList);
        return psModelList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<PSSysSFCode> getPSModelSFCodes(String strModelType, String strModelId) throws Exception {
        String strModelTag = StringHelper.Format((String)"%1$s|%2$s", (Object)strModelType, (Object)strModelId);
        ArrayList<PSSysSFCode> psSysSFCodeList = null;
        Map<String, ArrayList<PSSysSFCode>> map = this.psModelSFCodeListMap;
        synchronized (map) {
            psSysSFCodeList = this.psModelSFCodeListMap.get(strModelTag);
        }
        if (psSysSFCodeList != null) {
            return psSysSFCodeList.iterator();
        }
        ArrayList<PSSysSFCode> psSysSFCodeList2 = new ArrayList<PSSysSFCode>();
        ArrayList<IPSObject> psObjects = this.iPSSystemUtil.getPSModels(strModelType, strModelId);
        for (IPSObject iPSObject : psObjects) {
            if (iPSObject instanceof IPSSysSFPub) {
                IPSSysSFPub iPSSysSFPub = (IPSSysSFPub)iPSObject;
                IPSSFStyleUtil iPSSFStyleUtil = (IPSSFStyleUtil)((Object)this.getPSModelStorage().getPSSF(this.getSFType()).getPSSFStyle(iPSSysSFPub.getSFStyle()));
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
                ArrayList<PSSysSFCode> psSysSFCodeList3 = iPSSFStyleUtil.generateCode(psPublishContextImpl, iPSSysSFPub, "PSSYSTEM", this);
                psSysSFCodeList2.addAll(psSysSFCodeList3);
                continue;
            }
            Iterator<IPSSysSFPub> psSysSFPubs = this.getAllPSSysSFPubs();
            while (psSysSFPubs.hasNext()) {
                IPSSysSFPub iPSSysSFPub = psSysSFPubs.next();
                IPSSFStyleUtil iPSSFStyleUtil = (IPSSFStyleUtil)((Object)this.getPSModelStorage().getPSSF(this.getSFType()).getPSSFStyle(iPSSysSFPub.getSFStyle()));
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
                ArrayList<PSSysSFCode> psSysSFCodeList3 = iPSSFStyleUtil.generateCode(psPublishContextImpl, iPSSysSFPub, strModelType, iPSObject);
                psSysSFCodeList2.addAll(psSysSFCodeList3);
            }
        }
        Map<String, ArrayList<PSSysSFCode>> map2 = this.psModelSFCodeListMap;
        synchronized (map2) {
            if (this.psModelSFCodeListMap.size() > 5) {
                this.psModelSFCodeListMap.clear();
            }
            this.psModelSFCodeListMap.put(strModelTag, psSysSFCodeList2);
        }
        return psSysSFCodeList2.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<PSAppViewCode> getPSModelPFCodes(String strModelType, String strModelId) throws Exception {
        String strModelTag = StringHelper.Format((String)"%1$s|%2$s", (Object)strModelType, (Object)strModelId);
        ArrayList<PSAppViewCode> psAppViewCodeList = null;
        Map<String, ArrayList<PSAppViewCode>> map = this.psModelPFCodeListMap;
        synchronized (map) {
            psAppViewCodeList = this.psModelPFCodeListMap.get(strModelTag);
        }
        if (psAppViewCodeList != null) {
            return psAppViewCodeList.iterator();
        }
        ArrayList<IPSObject> psObjects = this.iPSSystemUtil.getPSModels(strModelType, strModelId);
        ArrayList<PSAppViewCode> psAppViewCodeList2 = new ArrayList<PSAppViewCode>();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
        for (IPSObject iPSObject : psObjects) {
            if (iPSObject instanceof IPSAppView) {
                boolean bPubViewCtrl;
                IPSAppView iPSAppView = (IPSAppView)iPSObject;
                Iterator<IPSPFViewTempl> psPFViewTempls = iPSAppView.getPSPFStyle().getPSPFViewTempls(iPSAppView);
                while (psPFViewTempls.hasNext()) {
                    PSAppViewCode psAppViewCode = new PSAppViewCode();
                    psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                    IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
                    IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                    iPSPFViewCodePublisher.generateCode2(psPublishContextImpl, iPSAppView, null);
                    iPSPFViewCodePublisher.close();
                    psAppViewCodeList2.add(psAppViewCode);
                }
                boolean bl = bPubViewCtrl = iPSAppView.getPSPFStyle().getPSPFPubCodes("VIEWCTRL", true) != null;
                if (!bPubViewCtrl) continue;
                ArrayList<IPSControl> psControls = iPSAppView.getAllPSControls();
                for (IPSControl iPSControl : psControls) {
                    Iterator<IPSPFCtrlTempl> psPFCtrlTempls = iPSAppView.getPSPFStyle().getPSPFCtrlTempls(iPSControl);
                    while (psPFCtrlTempls.hasNext()) {
                        PSAppViewCode psAppViewCode = new PSAppViewCode();
                        psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                        IPSPFCtrlTempl iPSPFCtrlTempl = psPFCtrlTempls.next();
                        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                        if (iPSPFCtrlCodePublisher instanceof IPSPFCtrlCodePublisher2) {
                            ((IPSPFCtrlCodePublisher2)((Object)iPSPFCtrlCodePublisher)).generateCode2(psPublishContextImpl, iPSControl);
                        }
                        iPSPFCtrlCodePublisher.close();
                        psAppViewCodeList2.add(psAppViewCode);
                    }
                }
                continue;
            }
            if (!(iPSObject instanceof IPSApplication)) continue;
        }
        Map<String, ArrayList<PSAppViewCode>> map2 = this.psModelPFCodeListMap;
        synchronized (map2) {
            if (this.psModelPFCodeListMap.size() > 5) {
                this.psModelPFCodeListMap.clear();
            }
            this.psModelPFCodeListMap.put(strModelTag, psAppViewCodeList2);
        }
        return psAppViewCodeList2.iterator();
    }

    @Override
    public IPSGenerateCodeResult getPSModelCodeSnippet(String strModelType, String strModelId, String strPSDCCodeSnippetId) throws Exception {
        ArrayList<IPSObject> psObjects = this.iPSSystemUtil.getPSModels(strModelType, strModelId);
        if (psObjects == null || psObjects.size() != 1) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s]", (Object)strModelType, (Object)strModelId));
        }
        IPSDCCodeSnippet iPSDCCodeSnippet = this.getPSModelStorage().getPSDCCodeSnippet(strPSDCCodeSnippetId);
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (params.size() > 0) {
            psPublishContextImpl.setPubParams(params);
        }
        IPSCodeSnippetPublisher iPSCodeSnippetPublisher = iPSDCCodeSnippet.getPSCodeSnippetPublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSCodeSnippetPublisher.generateCode(psPublishContextImpl, psObjects.get(0));
        iPSCodeSnippetPublisher.close();
        return iPSGenerateCodeResult;
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        if (!this.isLoading() && this.iPSSystemUtil != null) {
            this.iPSSystemUtil.log(nLogLevel, iPSModelObject, strInfo, strUserData, strUserData2);
        } else {
            PSLogItemImpl psLogItemImpl = new PSLogItemImpl();
            psLogItemImpl.setLogLevel(nLogLevel);
            psLogItemImpl.setLogInfo(strInfo);
            psLogItemImpl.setPSObject(iPSModelObject);
            psLogItemImpl.setUserData(strUserData);
            psLogItemImpl.setUserData2(strUserData2);
            this.psLogItemList.add(psLogItemImpl);
        }
    }

    @Override
    public String getDEFieldSortMode() {
        return this.strDEFieldSortMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u8bed\u8a00")
    public String getDefaultLanguage() {
        return this.strDefaultLanguageId;
    }

    @Override
    public String getCLEmptyText() {
        return this.strCLEmptyText;
    }

    @Override
    public boolean isEnableMultiLan() {
        return this.bEnableMultiLan;
    }

    @Override
    public String getCLEmptyTextPSLanguageResId() {
        return this.strCLEmptyTextPSLanguageResId;
    }

    @Override
    public IPSSysEngineConfig getPSSysEngineConfig() {
        return this.iPSSysEngineConfig;
    }

    @Override
    public int getDEDataExportMaxRowCount() {
        return this.nDEDataExpMaxRowCount;
    }

    @Override
    public int getDEDataSetMaxRowCount() {
        return this.nDEDataSetMaxRowCount;
    }

    @Override
    public IPSDBDevInst getJITPSDBDevInst() throws Exception {
        if (this.jitPSDBDevInst == null) {
            IPSSystemDBConfig iPSSystemDBConfig;
            String strJITPSDBDevInstId = null;
            if (this.iPSDevSlnSys != null) {
                strJITPSDBDevInstId = this.iPSDevSlnSys.getJITPSDBDevInstId();
            }
            if (StringHelper.IsNullOrEmpty(strJITPSDBDevInstId) && (iPSSystemDBConfig = this.getDefaultPSSystemDBConfig()) != null) {
                strJITPSDBDevInstId = iPSSystemDBConfig.getPSDBDevInstId();
            }
            if (!StringHelper.IsNullOrEmpty((String)strJITPSDBDevInstId)) {
                this.jitPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(strJITPSDBDevInstId);
            }
        }
        if (this.jitPSDBDevInst != null && this.jitPSDBDevInst.isLocalRes()) {
            return this.jitPSDBDevInst;
        }
        return null;
    }

    @Override
    public void pubPFCode(IPSSysPubRuntime iPSSysPubRuntime, IPSApplication iPSApplication, String strCodeType, String strFullPath, String strCode, Object strTag) throws Exception {
        IPSJITWebContext iPSJITWebContext = PSJITWebContext.getInstance();
        if (iPSJITWebContext != null) {
            iPSJITWebContext.writeFile(strFullPath, strCode, strTag);
            return;
        }
        boolean bSame = false;
        bSame = this.iPSSystemUtil != null ? this.iPSSystemUtil.writeFile2(strFullPath, strCode, strTag) : FileWriterHelper.write2(strFullPath, strCode);
        iPSSysPubRuntime.registerPFPubCode(iPSApplication, strCodeType, strFullPath, bSame);
    }

    @Override
    public void pubSFCode(IPSSysPubRuntime iPSSysPubRuntime, IPSSysSFPub iPSSysSFPub, String strCodeType, String strFullPath, String strCode, Object strTag) throws Exception {
        IPSJITWebContext iPSJITWebContext = PSJITWebContext.getInstance();
        if (iPSJITWebContext != null) {
            iPSJITWebContext.writeFile(strFullPath, strCode, strTag);
            return;
        }
        boolean bSame = false;
        bSame = this.iPSSystemUtil != null ? this.iPSSystemUtil.writeFile2(strFullPath, strCode, strTag) : FileWriterHelper.write2(strFullPath, strCode);
        iPSSysPubRuntime.registerSFPubCode(iPSSysSFPub, strCodeType, strFullPath, bSame);
    }

    @Override
    public void active(boolean bSystemOnly) {
        if (this.iPSSystemUtil == null || bSystemOnly) {
            this.nLastActiveTime = System.currentTimeMillis();
            if (this.nLastDBActiveTime + 20000L < this.nLastActiveTime) {
                this.nLastDBActiveTime = this.nLastActiveTime;
                try {
                    if (this.getJITPSDBDevInst() != null) {
                        PSDBDevInstGlobal.active(this.getJITPSDBDevInst().getId());
                        this.getPSModelStorage().activePSDBDevInst(this.getJITPSDBDevInst().getId());
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                try {
                    Iterator<IPSSystemDBConfig> psSystemDBConfigs = this.getAllPSSystemDBConfigs();
                    while (psSystemDBConfigs.hasNext()) {
                        try {
                            IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                            String strPSDBDevInstId = iPSSystemDBConfig.getPSDBDevInstId();
                            if (StringHelper.IsNullOrEmpty((String)strPSDBDevInstId)) continue;
                            PSDBDevInstGlobal.active(strPSDBDevInstId);
                            this.getPSModelStorage().activePSDBDevInst(strPSDBDevInstId);
                        }
                        catch (Exception ex) {
                            log.error((Object)ex);
                        }
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        } else {
            this.iPSSystemUtil.active();
        }
    }

    @Override
    public void active() {
        if (this.iPSSystemUtil != null) {
            this.iPSSystemUtil.active();
        } else {
            this.active(true);
        }
    }

    @Override
    public int getCheckModelVer() {
        return this.nCheckModelVer;
    }

    @Override
    public void logPSSysIssue(IPSModelObject iPSModelObject, SA.SRFDA.PS.Data.PSSysIssue psSysIssueV3) throws Exception {
        if (!this.bChecking) {
            return;
        }
        final PSSysIssueService psSysIssueService = this.psSysIssueService;
        if (psSysIssueService == null) {
            return;
        }
        final PSSysIssue psSysIssue = new PSSysIssue();
        PSDEDataCtrl.convertEntity2(psSysIssueV3, (IEntity)psSysIssue);
        psSysIssue.setPSSystemId(this.getId());
        psSysIssue.setPSSystemName(this.getName());
        if (StringHelper.IsNullOrEmpty((String)psSysIssue.getPSSysIssueName())) {
            psSysIssue.setPSSysIssueName(psSysIssue.getPSSysIssueTypeName());
        }
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                psSysIssueService.logPSSysIssue(psSysIssue);
            }
        });
    }

    @Override
    public Iterator<IPSSysDEFType> getAllPSSysDEFTypes() throws Exception {
        return this.psSysDEFTypeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField psDEField) throws Exception {
        String strDataType = psDEField.getPSDATATYPEID();
        String strDEFType = PSDEField.toDEFTypeString(psDEField.getDEFTYPE());
        boolean bMatchName = true;
        if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            bMatchName = false;
        }
        if (bMatchName && (psDEField.getDEFTYPE() == 2 || psDEField.getDEFTYPE() == 3)) {
            bMatchName = false;
        }
        String strTag = StringHelper.Format((String)"[*:%1$s]", (Object)psDEField.getPSDEFIELDNAME());
        IPSDEFieldType iPSDEFieldType = null;
        if (bMatchName && (iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag)) != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"%1$s:%2$s", (Object)strDEFType, (Object)strDataType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"%1$s:*", (Object)strDEFType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"*:%1$s", (Object)strDataType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.Format((String)"*");
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7ec4\u4ef6\u96c6\u5408", child=true, dynamodelmode=5, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=353)
    public Iterator<IPSSysLogic> getAllPSSysLogics() throws Exception {
        return this.psSysLogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysLogic getPSSysLogic(String strSysLogicId) throws Exception {
        return (IPSSysLogic)this.psSysLogicGlobalModel.FindModelHelper(strSysLogicId);
    }

    @Override
    public void resetPSSysLogic(String strSysLogicId) throws Exception {
        this.psSysLogicGlobalModel.ResetModel(strSysLogicId);
    }

    @Override
    public void resetAllPSSysLogics() {
        this.psSysLogicGlobalModel.ResetAll();
    }

    @Override
    public boolean isNoViewMode() {
        return this.bNoViewMode;
    }

    @Override
    public boolean isLoading() {
        return this.bLoading;
    }

    protected void logPSModelLoadLog(int nLogLevel, String strInfo, Exception exception) {
        try {
            final StringBuilderEx sb = new StringBuilderEx();
            for (IPSLogItem iPSLogItem : this.psLogItemList) {
                sb.append("%1$s\r\n", (Object)PSLogItemImpl.toString(iPSLogItem));
                if (iPSLogItem.getLogLevel() <= nLogLevel) continue;
                nLogLevel = iPSLogItem.getLogLevel();
            }
            final int nLogLevel2 = nLogLevel;
            final StringBuilderEx sb2 = new StringBuilderEx();
            if (!StringHelper.IsNullOrEmpty((String)strInfo)) {
                sb2.append("%1$s\r\n", (Object)strInfo);
            }
            if (exception != null) {
                sb2.append("\u6a21\u578b\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff1a");
                exception.printStackTrace(new PrintWriter(sb2.getWriter()));
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSysModelLoadLog psSysModelLoadLog = new PSSysModelLoadLog();
                    PSSysModelLoadLogService psSysModelLoadLogService = (PSSysModelLoadLogService)ServiceGlobal.getService(PSSysModelLoadLogService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)PSSystemImpl.this.getRuntimePSSysModelInstId()));
                    psSysModelLoadLog.setPSObjType("PSSYSTEM");
                    psSysModelLoadLog.setPSSystemId(PSSystemImpl.this.getId());
                    psSysModelLoadLog.setPSSystemName(PSSystemImpl.this.getName());
                    psSysModelLoadLog.setPSObjId(PSSystemImpl.this.getId());
                    psSysModelLoadLog.setPSObjName(PSSystemImpl.this.getName());
                    psSysModelLoadLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                    psSysModelLoadLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
                    psSysModelLoadLog.setPSDynaInstId(PSSystemImpl.this.getPSDynaInstId());
                    switch (nLogLevel2) {
                        case 0: {
                            psSysModelLoadLog.setLogLevel("OK");
                            break;
                        }
                        case 4: {
                            psSysModelLoadLog.setLogLevel("WARN");
                            break;
                        }
                        case 1: {
                            psSysModelLoadLog.setLogLevel("ERROR");
                        }
                    }
                    psSysModelLoadLog.setPSSysModelLoadLogName(StringHelper.Format((String)"[%1$s]\u52a0\u8f7d\u65e5\u5fd7", (Object)PSSystemImpl.this.getName()));
                    psSysModelLoadLog.setLogInfo(sb.toString());
                    psSysModelLoadLog.setExceptionInfo(sb2.toString());
                    psSysModelLoadLogService.save(psSysModelLoadLog);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f", codelist="SysServiceApiMode", dump=false)
    public int getServiceAPIMode() {
        return this.nServiceAPIMode;
    }

    @Override
    @PSModelRTMeta(description="\u8fdc\u7a0b\u6253\u5305", dump=false)
    public boolean isRemotePack() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDeployCenter() != null;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u8fdc\u7a0b\u90e8\u7f72", dump=false)
    public boolean isRemoteDeploy() {
        return this.getPSDeployCenter() != null;
    }

    @Override
    public IPSDeployServer getPSDeployServer() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDCDeployServer();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u89d2\u8272\u96c6\u5408", child=true, dynamodelmode=5, group="\u8bbf\u95ee\u63a7\u5236", order=415)
    public Iterator<IPSSysUserRole> getAllPSSysUserRoles() throws Exception {
        return this.psSysUserRoleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUserRole getPSSysUserRole(String strSysUserRoleId) throws Exception {
        return (IPSSysUserRole)this.psSysUserRoleGlobalModel.FindModelHelper(strSysUserRoleId);
    }

    @Override
    public IPSSysUserRole getPSSysUserRole(String strSysUserRoleId, boolean bTryMode) throws Exception {
        return (IPSSysUserRole)this.psSysUserRoleGlobalModel.FindModelHelper(strSysUserRoleId, bTryMode);
    }

    @Override
    public void resetPSSysUserRole(String strSysUserRoleId) throws Exception {
        this.psSysUserRoleGlobalModel.ResetModel(strSysUserRoleId);
    }

    @Override
    public void resetAllPSSysUserRoles() {
        this.psSysUserRoleGlobalModel.ResetAll();
    }

    @Override
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    @Override
    public IPSSysSFPlugin getPSSysSFPlugin(String strSysSFPluginId) throws Exception {
        return (IPSSysSFPlugin)this.psSysSFPluginGlobalModel.FindModelHelper(strSysSFPluginId);
    }

    @Override
    public void resetPSSysSFPlugin(String strSysSFPluginId) {
        this.psSysSFPluginGlobalModel.ResetModel(strSysSFPluginId);
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6a21\u677f\u63d2\u4ef6\u96c6\u5408", child=true, dynamodelmode=4, group="\u6a21\u677f\u6269\u5c55", order=530)
    public Iterator<IPSSysSFPlugin> getAllPSSysSFPlugins() throws Exception {
        return this.psSysSFPluginGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysSFPluginTempl getPSSysSFPluginTempl(String strSysSFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSSysSFPluginTempl)this.psSysSFPluginTemplGlobalModel.FindModelHelper(strSysSFPluginTemplId, bTryMode);
    }

    @Override
    public void resetPSSysSFPluginTempl(String strSysSFPluginTemplId) {
        this.psSysSFPluginTemplGlobalModel.ResetModel(strSysSFPluginTemplId);
    }

    @Override
    public Iterator<IPSSysSFPluginTempl> getAllPSSysSFPluginTempls() throws Exception {
        return this.psSysSFPluginTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7ec4\u4ef6\u96c6\u5408", child=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=353)
    public Iterator<IPSSysUtil> getAllPSSysUtils() throws Exception {
        return this.psSysUtilGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysUtil getPSSysUtil(String strSysUtilId) throws Exception {
        return (IPSSysUtil)this.psSysUtilGlobalModel.FindModelHelper(strSysUtilId);
    }

    @Override
    public IPSSysUtil getPSSysUtil(String strSysUtilId, boolean bTryMode) throws Exception {
        return (IPSSysUtil)this.psSysUtilGlobalModel.FindModelHelper(strSysUtilId, bTryMode);
    }

    @Override
    public void resetPSSysUtil(String strSysUtilId) throws Exception {
        this.psSysUtilGlobalModel.ResetModel(strSysUtilId);
    }

    @Override
    public void resetAllPSSysUtils() {
        this.psSysUtilGlobalModel.ResetAll();
    }

    @Override
    public int getEngineBugFixs() {
        return this.nEngineBugFixs;
    }

    @Override
    public int getDEFSFItemWidth() {
        return this.nDEFSFItemWidth;
    }

    @Override
    public String getVCType() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getVCType();
        }
        return null;
    }

    @Override
    public String getSysVersion() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getSysVersion();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u5f15\u64ce\u7248\u672c", dump=false)
    public String getTemplEngineVer() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getTemplEngineVer();
        }
        return null;
    }

    @Override
    public IPSSystem getSourcePSSystem() throws Exception {
        if (this.iPSDevSlnSys != null) {
            IPSDevSlnSys sourcePSDevSlnSys = this.iPSDevSlnSys.getSourcePSDevSlnSys();
            if (sourcePSDevSlnSys != null) {
                return sourcePSDevSlnSys.getPSSystem();
            }
            sourcePSDevSlnSys = this.iPSDevSlnSys.getMainPSDevSlnSys();
            if (sourcePSDevSlnSys != null) {
                return sourcePSDevSlnSys.getPSSystem();
            }
        }
        return null;
    }

    @Override
    public String getValueFormat() {
        return this.strDefaultValueFormat;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u4e2d\u5fc3", debugmode=true, outputdoc="false")
    public IPSDeployCenter getPSDeployCenter() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDeployCenter();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668", debugmode=true, outputdoc="false")
    public IPSWorkshopServer getPSWorkshopServer() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSWorkshopServer();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4f7f\u7528\u5de5\u7a0b\u670d\u52a1\u5668", debugmode=true, dump=false, outputdoc="false")
    public boolean isUseWorkshopServer() {
        return this.getPSWorkshopServer() != null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5fae\u670d\u52a1\u63a5\u53e3\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDevSlnMSDepAPI> getAllPSDevSlnMSDepAPIs() throws Exception {
        return this.getPSDevSlnMSDepAPIs();
    }

    @Override
    public Iterator<IPSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevSlnMSDepAPIs();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5fae\u670d\u52a1\u5e94\u7528\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDevSlnMSDepApp> getAllPSDevSlnMSDepApps() throws Exception {
        return this.getPSDevSlnMSDepApps();
    }

    @Override
    public Iterator<IPSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevSlnMSDepApps();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5fae\u670d\u52a1\u529f\u80fd\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDevSlnMSDepFunc> getAllPSDevSlnMSDepFuncs() throws Exception {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getPSDevSlnMSDepFuncs();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668Git\u914d\u7f6e", debugmode=true)
    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSDevSlnSysWSGit();
        }
        return null;
    }

    @Override
    public boolean hasPSWFEngineType(String strEngineType) throws Exception {
        Iterator<IPSWorkflow> psWorkflows = this.getAllPSWorkflows();
        while (psWorkflows.hasNext()) {
            IPSWorkflow iPSWorkflow = psWorkflows.next();
            if (StringHelper.Compare((String)iPSWorkflow.getWFEngineType(), (String)strEngineType, (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=486)
    public Iterator<IPSSysDynaModel> getAllPSSysDynaModels() throws Exception {
        return this.psSysDynaModelGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDynaModel getPSSysDynaModel(String strSysDynaModelId) throws Exception {
        return (IPSSysDynaModel)this.psSysDynaModelGlobalModel.FindModelHelper(strSysDynaModelId);
    }

    @Override
    public void resetPSSysDynaModel(String strSysDynaModelId) throws Exception {
        this.psSysDynaModelGlobalModel.ResetModel(strSysDynaModelId);
    }

    @Override
    public void resetAllPSSysDynaModels() {
        this.psSysDynaModelGlobalModel.ResetAll();
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f\u96c6\u5408", dump=false, outputdoc="false")
    public Iterator<IPSDEActionTempl> getAllPSDEActionTempls() throws Exception {
        return this.psDEActionTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEActionTempl getPSDEActionTempl(String strDEActionTemplId) throws Exception {
        return (IPSDEActionTempl)this.psDEActionTemplGlobalModel.FindModelHelper(strDEActionTemplId);
    }

    @Override
    public IPSDEActionTempl getPSDEActionTempl(String strDEActionTemplId, boolean bTryMode) throws Exception {
        return (IPSDEActionTempl)this.psDEActionTemplGlobalModel.FindModelHelper(strDEActionTemplId, bTryMode);
    }

    @Override
    public void resetPSDEActionTempl(String strDEActionTemplId) throws Exception {
        this.psDEActionTemplGlobalModel.ResetModel(strDEActionTemplId);
    }

    @Override
    public void resetAllPSDEActionTempls() {
        this.psDEActionTemplGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u5bf9\u8c61")
    public IPSDynaModel getPSDynaModel() {
        return this.psSysDynaModelGlobalModel.getSystemPSSysDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9ed8\u8ba4\u8bbe\u7f6e")
    public IPSSystemSetting getPSSystemSetting() {
        return this.psSystemSettingProxy;
    }

    @PSModelRTMeta(description="\u4efb\u52a1\u670d\u52a1\u5668", debugmode=true, hidemethod=true, order=5, outputdoc="false")
    public String hA101() {
        return PSTaskServerEnvImpl.getCurrent().getName();
    }

    @PSModelRTMeta(description="\u4efb\u52a1\u670d\u52a1\u5668\u5730\u5740", debugmode=true, hidemethod=true, order=6, outputdoc="false")
    public String hA102() {
        return PSTaskServerEnvImpl.getCurrent().getRemoteAddr();
    }

    @Override
    public final IPSSystemUtil.IPSSysConsole getPSSysConsole() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getPSSysConsole();
        }
        return this.iPSSysConsole;
    }

    protected final void logSysConsole(String strLogType, String strLogName, String strLogInfo) {
        this.logSysConsole(strLogType, strLogName, strLogInfo, null, null, null);
    }

    protected final void logSysConsole(String strLogType, String strLogName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
        try {
            if (PSTemplHelper.isBusy()) {
                return;
            }
            final PSSysConsole psSysConsole = new PSSysConsole();
            if (StringHelper.IsNullOrEmpty((String)strLogName)) {
                strLogName = this.getLogicName();
            }
            if (StringHelper.Length((String)strLogInfo) > 4000) {
                strLogInfo = String.valueOf(strLogInfo.substring(0, 3920)) + "...";
            }
            if (StringHelper.Compare((String)strLogType, (String)"INFO", (boolean)false) == 0) {
                log.info((Object)StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            } else if (StringHelper.Compare((String)strLogType, (String)"WARN", (boolean)false) == 0) {
                log.warn((Object)StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            } else if (StringHelper.Compare((String)strLogType, (String)"ERROR", (boolean)false) == 0) {
                log.error((Object)StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            }
            if (PSStudioConsoleHelper.getCurrent() != null && !StringHelper.IsNullOrEmpty((String)this.getPSDevSlnSysId())) {
                String strContent;
                if (StringHelper.Compare((String)strLogType, (String)"ERROR", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)StringHelper.Format((String)"%1$s: %2$s", (Object)strLogName, (Object)strLogInfo), (int)31, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDevSlnSysId(), strContent, null);
                } else if (StringHelper.Compare((String)strLogType, (String)"WARN", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)StringHelper.Format((String)"%1$s: %2$s", (Object)strLogName, (Object)strLogInfo), (int)33, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDevSlnSysId(), strContent, null);
                }
            }
            psSysConsole.setLogTime(new Timestamp(System.currentTimeMillis()));
            psSysConsole.setPSSysConsoleName(strLogName);
            psSysConsole.setLogLevel(strLogType);
            psSysConsole.setLogInfo(strLogInfo);
            psSysConsole.setPSSystemId(this.getId());
            psSysConsole.setPSSystemName(this.getName());
            if (!StringHelper.IsNullOrEmpty((String)strFixDEName)) {
                psSysConsole.setFixState(SysConsoleFixStateCodeListModel.SUPPORT);
                psSysConsole.setFixDEName(strFixDEName);
                psSysConsole.setFixDEAction(strFixDEAction);
                psSysConsole.setFixDataKey(strFixDataKey);
            }
            final PSSysConsoleService psSysConsoleService = (PSSysConsoleService)ServiceGlobal.getService(PSSysConsoleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getRuntimePSSysModelInstId()));
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    psSysConsoleService.create(psSysConsole, false);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public boolean isPubDBModel() {
        return this.bPubDBModel;
    }

    public boolean isEnableDBValueInsertUpdateMode() {
        return this.bEnableDBValueInsertUpdateMode;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5b9e\u4f8b\u7248\u672c", debugmode=true, hidemethod=true, order=8)
    public int getModelInstVer() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getModelInstVer();
        }
        return PSModelHelperImpl.MAXMODELINSTVER;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysDMVer> getAllPSSysDMVers() throws Exception {
        return this.psSysDMVerGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDMVer getPSSysDMVer(String strPSSysDMVerId) throws Exception {
        return (IPSSysDMVer)this.psSysDMVerGlobalModel.FindModelHelper(strPSSysDMVerId);
    }

    @Override
    public IPSSysDMVer getPSSysDMVer(String strPSSysDMVerId, boolean bTryMode) throws Exception {
        return (IPSSysDMVer)this.psSysDMVerGlobalModel.FindModelHelper(strPSSysDMVerId, bTryMode);
    }

    @Override
    public IPSSysDMVer getActivePSSysDMVer() throws Exception {
        return this.psSysDMVerGlobalModel.getActivePSSysDMVer();
    }

    @Override
    public Iterator<IPSDynaDETempl> getAllPSDynaDETempls() throws Exception {
        return this.psDynaDETemplGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDynaDETempl getPSDynaDETempl(String strDynaDETemplId) throws Exception {
        return (IPSDynaDETempl)this.psDynaDETemplGlobalModel.FindModelHelper(strDynaDETemplId);
    }

    @Override
    public void resetPSDynaDETempl(String strDynaDETemplId) throws Exception {
        this.psDynaDETemplGlobalModel.ResetModel(strDynaDETemplId);
    }

    @Override
    public void resetAllPSDynaDETempls() {
        this.psDynaDETemplGlobalModel.ResetAll();
    }

    @Override
    public int getDBVersion() {
        return this.nDBVersion;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u7cfb\u7edf", dump=false)
    public boolean isEnableDynaSys() {
        if (this.isDynaInstMode()) {
            return true;
        }
        if (PSSystemImpl.isDynaModelCodeGenMode()) {
            return true;
        }
        return this.bEnableDynaSys;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysTypes", dump=false)
    public int getDynaSysMode() {
        return this.nDynaSysMode;
    }

    @Override
    public IPSMavenRepo getDeployPSMavenRepo() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getDeployPSMavenRepo();
        }
        return null;
    }

    @Override
    public IPSMavenRepo getDCDeployPSMavenRepo() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getDCDeployPSMavenRepo();
        }
        return null;
    }

    @Override
    public int getSaaSMode() {
        return this.nSaaSMode;
    }

    @Override
    public IPSSystemModule getDefaultPSSystemModule() {
        return this.psSystemModuleGlobalModel.getDefaultPSSystemModule();
    }

    @Override
    public ArrayList<PSDevSlnTempl> getPSDevSlnTemplList() {
        return this.psDevSlnTemplList;
    }

    @Override
    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInstList() {
        return this.psDevSlnSysDynaInstList;
    }

    @Override
    public IPSSysDynaModel getDefaultPSSysDynaModelByModule(String strPSModuleId) {
        return this.psSysDynaModelGlobalModel.getModulePSSysDynaModel(strPSModuleId);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u67b6\u6784\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=265)
    public Iterator<IPSSysDBScheme> getAllPSSysDBSchemes() throws Exception {
        return this.psSysDBSchemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDBScheme getPSSysDBScheme(String strSysDBSchemeId) throws Exception {
        return (IPSSysDBScheme)this.psSysDBSchemeGlobalModel.FindModelHelper(strSysDBSchemeId);
    }

    @Override
    public IPSSysDBScheme getPSSysDBScheme(String strSysDBSchemeId, boolean bTryMode) throws Exception {
        return (IPSSysDBScheme)this.psSysDBSchemeGlobalModel.FindModelHelper(strSysDBSchemeId, bTryMode);
    }

    @Override
    public IPSSysDBScheme getPSSysDBScheme(String strPSSysModelGroupId, String strDSLink, boolean bTryMode) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strPSSysModelGroupId)) {
            return this.getPSSysDBScheme(strDSLink, bTryMode);
        }
        String strRealId = KeyValueHelper.genUniqueId((String)strPSSysModelGroupId, (String)strDSLink).toUpperCase();
        return this.getPSSysDBScheme(strRealId, bTryMode);
    }

    @Override
    public void resetPSSysDBScheme(String strSysDBSchemeId) throws Exception {
        this.psSysDBSchemeGlobalModel.ResetModel(strSysDBSchemeId);
    }

    @Override
    public void resetAllPSSysDBSchemes() {
        this.psSysDBSchemeGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u8d44\u6e90\u96c6\u5408", child=true, dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=485)
    public Iterator<IPSSysResource> getAllPSSysResources() throws Exception {
        return this.psSysResourceGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysResource getPSSysResource(String strSysResourceId) throws Exception {
        return (IPSSysResource)this.psSysResourceGlobalModel.FindModelHelper(strSysResourceId);
    }

    @Override
    public IPSSysResource getPSSysResource(String strSysResourceId, boolean bTryMode) throws Exception {
        return (IPSSysResource)this.psSysResourceGlobalModel.FindModelHelper(strSysResourceId, bTryMode);
    }

    @Override
    public void resetPSSysResource(String strSysResourceId) {
        this.psSysResourceGlobalModel.ResetModel(strSysResourceId);
    }

    @Override
    public void resetAllPSSysResources() {
        this.psSysResourceGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5185\u5bb9\u5206\u7c7b\u96c6\u5408", outputdoc="false", child=true, dumpref=true, dynamodelmode=4)
    public Iterator<IPSSysContentCat> getAllPSSysContentCats() throws Exception {
        return this.psSysContentCatGlobalModel.getAllPSSysContentCats();
    }

    @Override
    @PSModelRTMeta(description="\u6839\u5185\u5bb9\u5206\u7c7b\u96c6\u5408")
    public Iterator<IPSSysContentCat> getRootPSSysContentCats() throws Exception {
        return this.psSysContentCatGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysContentCat getPSSysContentCat(String strSysContentCatId) throws Exception {
        return (IPSSysContentCat)this.psSysContentCatGlobalModel.FindModelHelper(strSysContentCatId);
    }

    @Override
    public IPSSysContentCat getPSSysContentCat(String strSysContentCatId, boolean bTryMode) throws Exception {
        return (IPSSysContentCat)this.psSysContentCatGlobalModel.FindModelHelper(strSysContentCatId, bTryMode);
    }

    @Override
    public void resetPSSysContentCat(String strSysContentCatId) {
        this.psSysContentCatGlobalModel.ResetModel(strSysContentCatId);
    }

    @Override
    public void resetAllPSSysContentCats() {
        this.psSysContentCatGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSSysContentCat> getAllPSSysContentCats2() throws Exception {
        return this.psSysContentCatGlobalModel.getAllPSSysContentCats();
    }

    @Override
    public boolean isEnableLanResDefaultContent() {
        return this.bEnableLanResDefaultContent;
    }

    @Override
    public boolean isEnableDEDataVer() {
        return this.bEnableDEDataVer;
    }

    @Override
    public IPSSysDEGroup getPSDEGroup(String strDEGroupId) throws Exception {
        return (IPSSysDEGroup)this.psSysDEGroupGlobalModel.FindModelHelper(strDEGroupId);
    }

    @Override
    public IPSSysDEGroup getPSDEGroup(String strDEGroupId, boolean bTryMode) throws Exception {
        return (IPSSysDEGroup)this.psSysDEGroupGlobalModel.FindModelHelper(strDEGroupId, bTryMode);
    }

    @Override
    public void resetPSDEGroup(String strDEGroupId) {
        this.psSysDEGroupGlobalModel.ResetModel(strDEGroupId);
    }

    @Override
    public Iterator<IPSSysDEGroup> getAllPSDEGroups() throws Exception {
        return this.psSysDEGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ec4\u96c6\u5408", child=true, dynamodelmode=5, ignorepf=true, group="\u6a21\u578b\u9ad8\u7ea7", order=480)
    public Iterator<IPSSysDEGroup> getAllPSSysDEGroups() throws Exception {
        return this.psSysDEGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysDERGroup getPSDERGroup(String strDERGroupId) throws Exception {
        return (IPSSysDERGroup)this.psSysDERGroupGlobalModel.FindModelHelper(strDERGroupId);
    }

    @Override
    public IPSSysDERGroup getPSDERGroup(String strDERGroupId, boolean bTryMode) throws Exception {
        return (IPSSysDERGroup)this.psSysDERGroupGlobalModel.FindModelHelper(strDERGroupId, bTryMode);
    }

    @Override
    public void resetPSDERGroup(String strDERGroupId) {
        this.psSysDERGroupGlobalModel.ResetModel(strDERGroupId);
    }

    @Override
    public Iterator<IPSSysDERGroup> getAllPSDERGroups() throws Exception {
        return this.psSysDERGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=481)
    public Iterator<IPSSysDERGroup> getAllPSSysDERGroups() throws Exception {
        return this.psSysDERGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u9879\u76ee\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, hideempty2=true, group="\u6d4b\u8bd5", order=440)
    public Iterator<IPSSysTestPrj> getAllPSSysTestPrjs() throws Exception {
        return this.psSysTestPrjGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysTestPrj getPSSysTestPrj(String strSysTestPrjId) throws Exception {
        return (IPSSysTestPrj)this.psSysTestPrjGlobalModel.FindModelHelper(strSysTestPrjId);
    }

    @Override
    public IPSSysTestPrj getPSSysTestPrj(String strSysTestPrjId, boolean bTryMode) throws Exception {
        return (IPSSysTestPrj)this.psSysTestPrjGlobalModel.FindModelHelper(strSysTestPrjId, bTryMode);
    }

    @Override
    public void resetPSSysTestPrj(String strSysTestPrjId) {
        this.psSysTestPrjGlobalModel.ResetModel(strSysTestPrjId);
    }

    @Override
    public void resetAllPSSysTestPrjs() {
        this.psSysTestPrjGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u9700\u6c42\u6a21\u5757\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysReqModule> getAllPSSysReqModules() throws Exception {
        return this.psSysReqModuleGlobalModel.getAllPSSysReqModules();
    }

    @Override
    @PSModelRTMeta(description="\u6839\u9700\u6c42\u6a21\u5757\u96c6\u5408", group="\u9700\u6c42&\u7528\u4f8b", order=164, child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysReqModule> getRootPSSysReqModules() throws Exception {
        Iterator<IPSSysReqModule> psSysReqModules = this.getAllPSSysReqModules();
        if (psSysReqModules != null) {
            ArrayList<IPSSysReqModule> list = new ArrayList<IPSSysReqModule>();
            while (psSysReqModules.hasNext()) {
                IPSSysReqModule iPSSysReqModule = psSysReqModules.next();
                if (iPSSysReqModule.getParentPSSysReqModule() != null) continue;
                list.add(iPSSysReqModule);
            }
            if (list.size() > 0) {
                return list.iterator();
            }
        }
        return null;
    }

    @Override
    public IPSSysReqModule getPSSysReqModule(String strSysReqModuleId) throws Exception {
        return this.getPSSysReqModule(strSysReqModuleId, false);
    }

    @Override
    public IPSSysReqModule getPSSysReqModule(String strSysReqModuleId, boolean bTryMode) throws Exception {
        Iterator<IPSSysReqModule> psSysReqModules = this.getAllPSSysReqModules();
        if (psSysReqModules != null) {
            while (psSysReqModules.hasNext()) {
                IPSSysReqModule iPSSysReqModule = psSysReqModules.next();
                if (StringHelper.Compare((String)strSysReqModuleId, (String)iPSSysReqModule.getId(), (boolean)false) != 0) continue;
                return iPSSysReqModule;
            }
        }
        return (IPSSysReqModule)this.psSysReqModuleGlobalModel.FindModelHelper(strSysReqModuleId, bTryMode);
    }

    @Override
    public void resetPSSysReqModule(String strSysReqModuleId) {
        this.psSysReqModuleGlobalModel.ResetModel(strSysReqModuleId);
    }

    @Override
    public void resetAllPSSysReqModules() {
        this.psSysReqModuleGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSSysReqModule> getAllPSSysReqModules2() throws Exception {
        return this.psSysReqModuleGlobalModel.getAllPSSysReqModules();
    }

    @Override
    @PSModelRTMeta(description="\u9700\u6c42\u9879\u96c6\u5408", outputdoc="false", child=true, dumpref=true, ignorert=3, dynamodelmode=8)
    public Iterator<IPSSysReqItem> getAllPSSysReqItems() throws Exception {
        return this.psSysReqItemGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u6839\u9700\u6c42\u9879\u96c6\u5408", group="\u9700\u6c42&\u7528\u4f8b", order=165)
    public Iterator<IPSSysReqItem> getRootPSSysReqItems() throws Exception {
        Iterator<IPSSysReqItem> psSysReqItems = this.getAllPSSysReqItems();
        if (psSysReqItems != null) {
            ArrayList<IPSSysReqItem> list = new ArrayList<IPSSysReqItem>();
            while (psSysReqItems.hasNext()) {
                IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
                if (iPSSysReqItem.getPSSysReqModule() != null) continue;
                list.add(iPSSysReqItem);
            }
            if (list.size() > 0) {
                return list.iterator();
            }
        }
        return null;
    }

    @Override
    public IPSSysReqItem getPSSysReqItem(String strSysReqItemId) throws Exception {
        return (IPSSysReqItem)this.psSysReqItemGlobalModel.FindModelHelper(strSysReqItemId);
    }

    @Override
    public IPSSysReqItem getPSSysReqItem(String strSysReqItemId, boolean bTryMode) throws Exception {
        return (IPSSysReqItem)this.psSysReqItemGlobalModel.FindModelHelper(strSysReqItemId, bTryMode);
    }

    @Override
    public void resetPSSysReqItem(String strSysReqItemId) {
        this.psSysReqItemGlobalModel.ResetModel(strSysReqItemId);
    }

    @Override
    public void resetAllPSSysReqItems() {
        this.psSysReqItemGlobalModel.ResetAll();
    }

    @Override
    public synchronized int getSampleDataId() {
        ++this.nSampleDataId;
        return this.nSampleDataId;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4\u96c6\u5408", child=true, dynamodelmode=4, group="\u6a21\u578b\u9ad8\u7ea7", order=470)
    public Iterator<IPSSysModelGroup> getAllPSSysModelGroups() throws Exception {
        return this.psSysModelGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysModelGroup getPSSysModelGroup(String strSysModelGroupId) throws Exception {
        return (IPSSysModelGroup)this.psSysModelGroupGlobalModel.FindModelHelper(strSysModelGroupId);
    }

    @Override
    public void resetPSSysModelGroup(String strSysModelGroupId) {
        this.psSysModelGroupGlobalModel.ResetModel(strSysModelGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u4f53\u7cfb\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=354)
    public Iterator<IPSSysSearchScheme> getAllPSSysSearchSchemes() throws Exception {
        return this.psSysSearchSchemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysSearchScheme getPSSysSearchScheme(String strSysSearchSchemeId) throws Exception {
        return (IPSSysSearchScheme)this.psSysSearchSchemeGlobalModel.FindModelHelper(strSysSearchSchemeId);
    }

    @Override
    public IPSSysSearchScheme getPSSysSearchScheme(String strSysSearchSchemeId, boolean bTryMode) throws Exception {
        return (IPSSysSearchScheme)this.psSysSearchSchemeGlobalModel.FindModelHelper(strSysSearchSchemeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u96c6\u6210\u4f53\u7cfb\u96c6\u5408", group="\u9ad8\u7ea7\u7ec4\u4ef6", order=359)
    public Iterator<IPSSysEAIScheme> getAllPSSysEAISchemes() throws Exception {
        return this.psSysEAISchemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysEAIScheme getPSSysEAIScheme(String strSysEAISchemeId) throws Exception {
        return (IPSSysEAIScheme)this.psSysEAISchemeGlobalModel.FindModelHelper(strSysEAISchemeId);
    }

    @Override
    public IPSSysEAIScheme getPSSysEAIScheme(String strSysEAISchemeId, boolean bTryMode) throws Exception {
        return (IPSSysEAIScheme)this.psSysEAISchemeGlobalModel.FindModelHelper(strSysEAISchemeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=356)
    public Iterator<IPSSysBIScheme> getAllPSSysBISchemes() throws Exception {
        return this.psSysBISchemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBIScheme getPSSysBIScheme(String strSysBISchemeId) throws Exception {
        return (IPSSysBIScheme)this.psSysBISchemeGlobalModel.FindModelHelper(strSysBISchemeId);
    }

    @Override
    public IPSSysBIScheme getPSSysBIScheme(String strSysBISchemeId, boolean bTryMode) throws Exception {
        return (IPSSysBIScheme)this.psSysBISchemeGlobalModel.FindModelHelper(strSysBISchemeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u5382\u96c6\u5408", child=true, dumpref=true, dynamodelmode=4, group="\u9ad8\u7ea7\u7ec4\u4ef6", order=357)
    public Iterator<IPSSysAIFactory> getAllPSSysAIFactories() throws Exception {
        return this.psSysAIFactoryGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysAIFactory getPSSysAIFactory(String strSysAIFactoryId) throws Exception {
        return (IPSSysAIFactory)this.psSysAIFactoryGlobalModel.FindModelHelper(strSysAIFactoryId);
    }

    @Override
    public IPSSysAIFactory getPSSysAIFactory(String strSysAIFactoryId, boolean bTryMode) throws Exception {
        return (IPSSysAIFactory)this.psSysAIFactoryGlobalModel.FindModelHelper(strSysAIFactoryId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysPortletCat> getAllPSSysPortletCats() throws Exception {
        return this.psSysPortletCatGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysPortletCat getPSSysPortletCat(String strSysPortletCatId) throws Exception {
        return (IPSSysPortletCat)this.psSysPortletCatGlobalModel.FindModelHelper(strSysPortletCatId);
    }

    @Override
    public IPSSysPortletCat getPSSysPortletCat(String strSysPortletCatId, boolean bTryMode) throws Exception {
        return (IPSSysPortletCat)this.psSysPortletCatGlobalModel.FindModelHelper(strSysPortletCatId, bTryMode);
    }

    @Override
    public void resetPSSysPortletCat(String strSysPortletCatId) throws Exception {
        this.psSysPortletCatGlobalModel.ResetModel(strSysPortletCatId);
    }

    @Override
    public void resetAllPSSysPortletCats() {
        this.psSysPortletCatGlobalModel.ResetAll();
    }

    @Override
    public boolean isDebugMode() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.isDebugMode();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u6807\u8bc6")
    public String getDeploySysId() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysId();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u6807\u8bb0")
    public String getDeploySysTag() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysTag();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u6807\u8bb02")
    public String getDeploySysTag2() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysTag2();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u7c7b\u578b", codelist="DeploySysType")
    public String getDeploySysType() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysType();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u673a\u6784\u6807\u8bc6", hideempty2=true)
    public String getDeploySysOrgId() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysOrgId();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u7cfb\u7edf\u673a\u6784\u90e8\u95e8\u6807\u8bc6", hideempty2=true)
    public String getDeploySysOrgSectorId() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getDeploySysOrgSectorId();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bb0")
    public String getSysTag() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getSysTag();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bb02")
    public String getSysTag2() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getSysTag2();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bb03")
    public String getSysTag3() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getSysTag3();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bb04")
    public String getSysTag4() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getSysTag4();
        }
        return "";
    }

    @Override
    public String getDeployId() {
        if (!StringHelper.IsNullOrEmpty((String)this.getDeploySysId())) {
            return this.getDeploySysId();
        }
        return super.getDeployId();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u53d1\u65b9\u6848\u6807\u8bc6", dump=false, outputdoc="false")
    public String getPSDevSlnId() {
        if (this.iPSSystemUtil != null) {
            return this.iPSSystemUtil.getPSDevSlnId();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u5fc3\u751f\u4ea7\u7ebf", hideempty=true, outputdoc="false")
    public IPSWorkspace getPSWorkspace() {
        if (this.iPSDevSlnSys != null) {
            return ((IPSDevSlnSysRuntime)((Object)this.iPSDevSlnSys)).getPSWorkspace();
        }
        return null;
    }

    @Override
    public void testPSModelLimit(IPSModelObject ownerPSModelObject, String strPSModelType, int nCount) throws Exception {
        if (this.iPSDevSlnSys != null) {
            ((IPSSystemUtil)((Object)this.iPSDevSlnSys)).testPSModelLimit(ownerPSModelObject, strPSModelType, nCount);
        }
    }

    @Override
    public IPSModelObjectLogger getPSModelObjectLogger() {
        return this.iPSModelObjectLogger;
    }

    @Override
    public void setPSModelObjectLogger(IPSModelObjectLogger iPSModelObjectLogger) {
        this.iPSModelObjectLogger = iPSModelObjectLogger;
    }

    @Override
    @PSModelRTMeta(name="[H]\u540e\u53f0\u6a21\u677f\u53d1\u5e03\u5e2e\u52a9", hideempty=true)
    public IPSSFPubHelp getPSSFPubHelp() {
        block4: {
            try {
                if (!PSTemplHelper.isBusy()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.iPSSFPubHelp != null) {
            return this.iPSSFPubHelp;
        }
        try {
            HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
            this.fillPSSFCodePublisherParams(publisherParamMap);
            this.iPSSFPubHelp = PSSFPubHelpImpl.createPSSFPubHelp(this.getPSSFPubObjTarget(), this, this, publisherParamMap);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return null;
        }
        return this.iPSSFPubHelp;
    }

    protected void fillPSSFCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSSFPubObjTarget() {
        return this.getModelType();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5de5\u4f5c\u65f6\u95f4\u96c6\u5408", child=true, dumpref=true, group="\u5de5\u4f5c\u6d41", order=330)
    public Iterator<IPSWFWorkTime> getAllPSWFWorkTimes() throws Exception {
        return this.psWFWorkTimeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSWFWorkTime getPSWFWorkTime(String strWFWorkTimeId) throws Exception {
        return (IPSWFWorkTime)this.psWFWorkTimeGlobalModel.FindModelHelper(strWFWorkTimeId);
    }

    @Override
    public IPSWFWorkTime getPSWFWorkTime(String strWFWorkTimeId, boolean bTryMode) throws Exception {
        return (IPSWFWorkTime)this.psWFWorkTimeGlobalModel.FindModelHelper(strWFWorkTimeId, bTryMode);
    }

    @Override
    public void resetPSWFWorkTime(String strWFWorkTimeId) {
        this.psWFWorkTimeGlobalModel.ResetModel(strWFWorkTimeId);
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u96c6\u5408", child=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=503)
    public Iterator<IPSSysSequence> getAllPSSysSequences() throws Exception {
        return this.psSysSequenceGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysSequence getPSSysSequence(String strSysSequenceId) throws Exception {
        return (IPSSysSequence)this.psSysSequenceGlobalModel.FindModelHelper(strSysSequenceId);
    }

    @Override
    public IPSSysSequence getPSSysSequence(String strSysSequenceId, boolean bTryMode) throws Exception {
        return (IPSSysSequence)this.psSysSequenceGlobalModel.FindModelHelper(strSysSequenceId, bTryMode);
    }

    @Override
    public void resetPSSysSequence(String strSysSequenceId) {
        this.psSysSequenceGlobalModel.ResetModel(strSysSequenceId);
    }

    @Override
    public void resetAllPSSysSequences() {
        this.psSysSequenceGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u96c6\u5408", child=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=505)
    public Iterator<IPSSysTranslator> getAllPSSysTranslators() throws Exception {
        return this.psSysTranslatorGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysTranslator getPSSysTranslator(String strSysTranslatorId) throws Exception {
        return (IPSSysTranslator)this.psSysTranslatorGlobalModel.FindModelHelper(strSysTranslatorId);
    }

    @Override
    public IPSSysTranslator getPSSysTranslator(String strSysTranslatorId, boolean bTryMode) throws Exception {
        return (IPSSysTranslator)this.psSysTranslatorGlobalModel.FindModelHelper(strSysTranslatorId, bTryMode);
    }

    @Override
    public void resetPSSysTranslator(String strSysTranslatorId) {
        this.psSysTranslatorGlobalModel.ResetModel(strSysTranslatorId);
    }

    @Override
    public void resetAllPSSysTranslators() {
        this.psSysTranslatorGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u76ee\u6807\u96c6\u5408", child=true, dynamodelmode=5, group="\u6d88\u606f", order=382)
    public Iterator<IPSSysMsgTarget> getAllPSSysMsgTargets() throws Exception {
        return this.psSysMsgTargetGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysMsgTarget getPSSysMsgTarget(String strSysMsgTargetId) throws Exception {
        return (IPSSysMsgTarget)this.psSysMsgTargetGlobalModel.FindModelHelper(strSysMsgTargetId);
    }

    @Override
    public IPSSysMsgTarget getPSSysMsgTarget(String strSysMsgTargetId, boolean bTryMode) throws Exception {
        return (IPSSysMsgTarget)this.psSysMsgTargetGlobalModel.FindModelHelper(strSysMsgTargetId, bTryMode);
    }

    @Override
    public void resetPSSysMsgTarget(String strSysMsgTargetId) {
        this.psSysMsgTargetGlobalModel.ResetModel(strSysMsgTargetId);
    }

    @Override
    public void resetAllPSSysMsgTargets() {
        this.psSysMsgTargetGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u961f\u5217\u96c6\u5408", child=true, dynamodelmode=5, group="\u6d88\u606f", order=380)
    public Iterator<IPSSysMsgQueue> getAllPSSysMsgQueues() throws Exception {
        return this.psSysMsgQueueGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysMsgQueue getPSSysMsgQueue(String strSysMsgQueueId) throws Exception {
        return (IPSSysMsgQueue)this.psSysMsgQueueGlobalModel.FindModelHelper(strSysMsgQueueId);
    }

    @Override
    public IPSSysMsgQueue getPSSysMsgQueue(String strSysMsgQueueId, boolean bTryMode) throws Exception {
        return (IPSSysMsgQueue)this.psSysMsgQueueGlobalModel.FindModelHelper(strSysMsgQueueId, bTryMode);
    }

    @Override
    public void resetPSSysMsgQueue(String strSysMsgQueueId) {
        this.psSysMsgQueueGlobalModel.ResetModel(strSysMsgQueueId);
    }

    @Override
    public void resetAllPSSysMsgQueues() {
        this.psSysMsgQueueGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u8868\u4e3b\u9898\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysChartTheme> getAllPSSysChartThemes() throws Exception {
        return this.psSysChartThemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysChartTheme getPSSysChartTheme(String strSysChartThemeId) throws Exception {
        return (IPSSysChartTheme)this.psSysChartThemeGlobalModel.FindModelHelper(strSysChartThemeId);
    }

    @Override
    public IPSSysChartTheme getPSSysChartTheme(String strSysChartThemeId, boolean bTryMode) throws Exception {
        return (IPSSysChartTheme)this.psSysChartThemeGlobalModel.FindModelHelper(strSysChartThemeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7cfb\u7edf\u56fe\u8868\u4e3b\u9898", outputdoc="false")
    public IPSSysChartTheme getDefaultPSSysChartTheme() {
        return this.psSysChartThemeGlobalModel.getDefaultPSSysChartTheme();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9608\u503c\u7ec4\u96c6\u5408", outputdoc="false")
    public Iterator<IPSThresholdGroup> getAllPSThresholdGroups() throws Exception {
        return this.psThresholdGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSThresholdGroup getPSThresholdGroup(String strThresholdGroupId) throws Exception {
        return (IPSThresholdGroup)this.psThresholdGroupGlobalModel.FindModelHelper(strThresholdGroupId);
    }

    @Override
    public IPSThresholdGroup getPSThresholdGroup(String strThresholdGroupId, boolean bTryMode) throws Exception {
        return (IPSThresholdGroup)this.psThresholdGroupGlobalModel.FindModelHelper(strThresholdGroupId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u521d\u59cb\u5316\u5185\u5bb9\u96c6\u5408", hideempty=true, child=true, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSSysContent> getInitPSSysContents() throws Exception {
        IPSSysContentCat initDataPSSysContentCat = this.getPSSysContentCat("INITDATA", true);
        if (initDataPSSysContentCat == null) {
            return null;
        }
        return initDataPSSysContentCat.getPSSysContents();
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u5185\u5bb9\u96c6\u5408", hideempty=true, child=true, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSSysContent> getSamplePSSysContents() throws Exception {
        IPSSysContentCat sampleDataPSSysContentCat = this.getPSSysContentCat("SAMPLEDATA", true);
        if (sampleDataPSSysContentCat == null) {
            return null;
        }
        return sampleDataPSSysContentCat.getPSSysContents();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u5185\u5bb9\u96c6\u5408", hideempty=true, child=true, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSSysContent> getTestPSSysContents() throws Exception {
        IPSSysContentCat testDataPSSysContentCat = this.getPSSysContentCat("TESTDATA", true);
        if (testDataPSSysContentCat == null) {
            return null;
        }
        return testDataPSSysContentCat.getPSSysContents();
    }

    @Override
    public int getDEMSActionLogicMode() {
        return this.nDEMSActionLogicMode;
    }

    @Override
    public int getSubSysDEMSActionLogicMode() {
        return this.nSubSysDEMSActionLogicMode;
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPSDynaInstId();
        }
        return null;
    }

    @Override
    public String getPPSDynaInstId() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPPSDynaInstId();
        }
        return null;
    }

    @Override
    public String getPSDynaInstName() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPSDynaInstName();
        }
        return null;
    }

    @Override
    public String getPSDynaInstLogicName() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPSDynaInstLogicName();
        }
        return null;
    }

    @Override
    public boolean isDynaInstMode() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.isDynaInstMode();
        }
        return false;
    }

    @Override
    public int getDynaInstMode() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getDynaInstMode();
        }
        return super.getDynaInstMode();
    }

    @Override
    public String getDynaInstTag() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getDynaInstTag();
        }
        return super.getDynaInstTag();
    }

    @Override
    public String getDynaInstTag2() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getDynaInstTag2();
        }
        return super.getDynaInstTag2();
    }

    @Override
    public String getRuntimePSSysModelInstId() {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getRuntimePSSysModelInstId();
        }
        return this.getPSSysModelInstId();
    }

    @Override
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return "PSSYSTEM.json";
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        Iterator<IPSDataEntity> psDataEntities;
        ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList;
        if (this.iPSDevSlnSysRuntime != null && this.iPSDevSlnSysRuntime.getDynaInstMode() == 2) {
            if (!StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId())) {
                objectNode.put("getPSDynaInstId", this.getPSDynaInstId());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPPSDynaInstId())) {
                objectNode.put("getPPSDynaInstId", this.getPPSDynaInstId());
            }
            objectNode.put("dynaInstMode", this.iPSDevSlnSysRuntime.getDynaInstMode());
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDevSlnSysRuntime.getDynaInstTag())) {
                objectNode.put("dynaInstTag", this.iPSDevSlnSysRuntime.getDynaInstTag());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDevSlnSysRuntime.getDynaInstTag2())) {
                objectNode.put("dynaInstTag2", this.iPSDevSlnSysRuntime.getDynaInstTag2());
            }
            ArrayNode arrayNode = objectNode.putArray("getAllPSSystemModules");
            Iterator<IPSSystemModule> psModules = this.getAllPSSystemModules();
            if (psModules != null) {
                while (psModules.hasNext()) {
                    IPSSystemModule iPSSystemModule = psModules.next();
                    if (iPSSystemModule.getDynaInstMode() != 2 || StringHelper.Compare((String)this.iPSDevSlnSysRuntime.getDynaInstTag(), (String)iPSSystemModule.getDynaInstTag(), (boolean)false) != 0) continue;
                    arrayNode.add((JsonNode)iPSSystemModule.getModel());
                }
            }
            return;
        }
        super.onFillModelNode(objectNode, strModelType);
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId())) {
            objectNode.put("getPSDynaInstId", this.getPSDynaInstId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPPSDynaInstId())) {
            objectNode.put("getPPSDynaInstId", this.getPPSDynaInstId());
        }
        if ((psDevSlnSysDynaInstList = this.getPSDevSlnSysDynaInstList()) != null && psDevSlnSysDynaInstList.size() > 0) {
            ArrayNode arrayNode = objectNode.putArray("getPSDynaInsts");
            for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                ObjectNode instNode = JsonNodeHelper.createObjectNode();
                instNode.put("id", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                instNode.put("name", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME());
                if (!StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getLOGICNAME())) {
                    instNode.put("logicName", psDevSlnSysDynaInst.getLOGICNAME());
                }
                if (!StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTYPE())) {
                    instNode.put("instType", psDevSlnSysDynaInst.getINSTTYPE());
                }
                if (!StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTAG())) {
                    instNode.put("instTag", psDevSlnSysDynaInst.getINSTTAG());
                }
                if (!StringHelper.IsNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTAG2())) {
                    instNode.put("instTag2", psDevSlnSysDynaInst.getINSTTAG2());
                }
                arrayNode.add((JsonNode)instNode);
            }
        }
        if (this.iPSDevSlnSysRuntime != null && this.iPSDevSlnSysRuntime.getDynaInstMode() == 1 && (psDataEntities = this.getAllPSDataEntities()) != null) {
            LinkedHashMap<String, IPSDataEntity> preloadPSDataEntityMap = new LinkedHashMap<String, IPSDataEntity>();
            while (psDataEntities.hasNext()) {
                Iterator<IPSDENotify> psDENotifies;
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                boolean bPreload = false;
                Iterator<IPSDEDataSync> psDEDataSyncs = iPSDataEntity.getAllPSDEDataSyncs();
                if (psDEDataSyncs != null) {
                    while (psDEDataSyncs.hasNext()) {
                        IPSDEDataSync iPSDEDataSync = psDEDataSyncs.next();
                        if (!"IN".equals(iPSDEDataSync.getSyncDir())) continue;
                        bPreload = true;
                        break;
                    }
                }
                if (!bPreload && (psDENotifies = iPSDataEntity.getAllPSDENotifies()) != null) {
                    while (psDENotifies.hasNext()) {
                        IPSDENotify iPSDENotify = psDENotifies.next();
                        if (!iPSDENotify.isTimerMode()) continue;
                        bPreload = true;
                        break;
                    }
                }
                if (!bPreload) continue;
                preloadPSDataEntityMap.put(iPSDataEntity.getDynaModelFilePath(), iPSDataEntity);
            }
            if (preloadPSDataEntityMap.size() > 0) {
                ArrayNode arrayNode = objectNode.putArray("preloadDEs");
                for (Map.Entry entry : preloadPSDataEntityMap.entrySet()) {
                    arrayNode.add((String)entry.getKey());
                }
            }
        }
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return this.isEnableDynaSys();
    }

    @Override
    public boolean isEnableDERFKey() {
        return this.bEnableDERFKey;
    }

    @Override
    public boolean isAppendCtrlDEItems() {
        return this.bAppendCtrlDEItems;
    }

    @Override
    public boolean isAutoCalcDER1NExtRestrict() {
        return this.bAutoCalcDER1NExtRestrict;
    }

    @Override
    public boolean isEnableDEFieldRestrictedUI() {
        return this.bEnableDEFieldRestrictedUI;
    }

    public IPSViewType getPSViewType(String strPSViewTypeId, boolean bTryMode) throws Exception {
        return this.getPSModelStorage().getPSViewType(strPSViewTypeId, bTryMode);
    }

    @Override
    public boolean isPanelItemAutoShowCaption() {
        if (this.bPanelItemAutoShowCaption == null) {
            return this.isEnableModelRT();
        }
        return this.bPanelItemAutoShowCaption;
    }

    @Override
    public boolean isEnableDEFieldAudit() {
        return StringHelper.Compare((String)this.getTemplEngineVer(), (String)"V2", (boolean)true) == 0;
    }

    @Override
    public boolean isEnableModelRT() {
        if (this.getDefaultPSSysSFPub() != null && this.getDefaultPSSysSFPub().isEnableModelRT()) {
            return true;
        }
        return StringHelper.Compare((String)this.getTemplEngineVer(), (String)"V2", (boolean)true) == 0 && (this.getEngineBugFixs() & 0x80) != 0;
    }

    @Override
    public boolean isEnableServiceAPIModelEx() {
        return (this.getEngineBugFixs() & 0x100) != 0;
    }

    @Override
    public boolean isEnableDEFSearchModeModelEx() {
        return (this.getEngineBugFixs() & 0x200) != 0;
    }

    @Override
    public boolean isEnableUIModelEx() {
        return (this.getEngineBugFixs() & 0x400) != 0;
    }

    @Override
    public boolean isFixCodeNameAutoCapitalize() {
        return (this.getEngineBugFixs() & 0x800) != 0;
    }

    @Override
    public boolean isEnableDESaveActionModelEx() {
        return (this.getEngineBugFixs() & 0x2000) != 0;
    }

    @Override
    public boolean isEnableDEInheritModelEx() {
        return (this.getEngineBugFixs() & 0x4000) != 0;
    }

    @Override
    public boolean isEnableDEGetDraftActionModelEx() {
        return (this.getEngineBugFixs() & 0x8000) != 0;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7c7b\u578b", codelist="DevSysType", ignoredumpvalues="DEVSYS")
    public String getSysType() {
        if (this.iPSDevSlnSys != null) {
            return this.iPSDevSlnSys.getSysType();
        }
        return null;
    }

    @Override
    public IPSSFStyle getPSSFStyle(String strPSSFId, String strPSSFStyleId, String strTag) throws Exception {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPSSFStyle(strPSSFId, strPSSFStyleId, strTag);
        }
        return this.getPSModelStorage().getPSSF(strPSSFId).getPSSFStyle(strPSSFStyleId);
    }

    @Override
    public IPSPFStyle getPSPFStyle(String strPSPFId, String strPSPFStyleId, String strTag) throws Exception {
        if (this.iPSDevSlnSysRuntime != null) {
            return this.iPSDevSlnSysRuntime.getPSPFStyle(strPSPFId, strPSPFStyleId, strTag);
        }
        return this.getPSModelStorage().getPSPF(strPSPFId).getPSPFStyle(strPSPFStyleId);
    }

    @Override
    public PSDELogic getPSDELogicData(String strPSDELogicId, boolean bTryMode) throws Exception {
        PSDELogic psDELogic = this.psDELogicMap.get(strPSDELogicId);
        if (psDELogic != null || bTryMode) {
            return psDELogic;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5904\u7406[%1$s]", strPSDELogicId));
    }

    @Override
    public PSDEUIAction getPSDEUIActionData(String strPSDEUIActionId, boolean bTryMode) throws Exception {
        PSDEUIAction psDEUIAction = this.psDEUIActionMap.get(strPSDEUIActionId);
        if (psDEUIAction != null || bTryMode) {
            return psDEUIAction;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", strPSDEUIActionId));
    }

    @Override
    public PSCtrlLogicGroup getPSCtrlLogicGroupData(String strPSCtrlLogicGroupId, boolean bTryMode) throws Exception {
        PSCtrlLogicGroup psCtrlLogicGroup = this.psCtrlLogicGroupMap.get(strPSCtrlLogicGroupId);
        if (psCtrlLogicGroup != null || bTryMode) {
            return psCtrlLogicGroup;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u754c\u9762\u903b\u8f91\u7ec4[%1$s]", strPSCtrlLogicGroupId));
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7cfb\u7edf\u56fd\u9645\u5316", dumpref=true, dynamodelmode=4)
    public IPSSysI18N getDefaultPSSysI18N() {
        return this.psSysI18NImpl;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fd\u9645\u5316", dumpref=true, child=true, dynamodelmode=4)
    public Iterator<IPSSysI18N> getAllPSSysI18Ns() throws Exception {
        return this.psSysI18NList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61", hideempty=true)
    public String getRTObjectName() {
        try {
            Iterator<IPSSysSFPlugin> psSysSFPlugins = this.getAllPSSysSFPlugins();
            if (psSysSFPlugins != null) {
                while (psSysSFPlugins.hasNext()) {
                    IPSSysSFPlugin iPSSysSFPlugin = psSysSFPlugins.next();
                    if (!"GLOBAL_SYSTEMRUNTIME".equalsIgnoreCase(iPSSysSFPlugin.getPluginCode()) || !iPSSysSFPlugin.isRuntimeObject()) continue;
                    return iPSSysSFPlugin.getRTObjectName();
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u65b9\u6cd5DTO\u96c6\u5408", child=true, ignorepf=true, group="\u5904\u7406\u903b\u8f91", order=516)
    public Iterator<IPSSysMethodDTO> getAllPSSysMethodDTOs() throws Exception {
        if (this.psSysMethodDTOMap == null || this.psSysMethodDTOMap.size() == 0) {
            return null;
        }
        return this.psSysMethodDTOMap.values().iterator();
    }

    @Override
    public IPSSysMethodDTO getPSSysMethodDTO(IPSSysDynaModel iPSSysDynaModel) throws Exception {
        for (Map.Entry<String, IPSSysMethodDTO> entry : this.psSysMethodDTOMap.entrySet()) {
            if (StringHelper.Compare((String)entry.getValue().getType(), (String)"DEFAULT", (boolean)true) != 0 || entry.getValue().getSrcPSSysDynaModel() == null || StringHelper.Compare((String)entry.getValue().getSrcPSSysDynaModel().getId(), (String)iPSSysDynaModel.getId(), (boolean)false) != 0) continue;
            return entry.getValue();
        }
        PSSysMethodDTOImpl psSysMethodDTOImpl = new PSSysMethodDTOImpl();
        psSysMethodDTOImpl.initFromDynaModel(this.getDAGlobalHelper(), iPSSysDynaModel);
        if (this.psSysMethodDTOMap.containsKey(psSysMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u7cfb\u7edf\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psSysMethodDTOImpl.getCodeName()));
        }
        this.psSysMethodDTOMap.put(psSysMethodDTOImpl.getCodeName(), psSysMethodDTOImpl);
        return psSysMethodDTOImpl;
    }

    @Override
    public String getSysMethodDTOCodeName(IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
        String strCodeName = this.calcSysMethodDTOCodeName(iPSSysMethodDTO);
        if (StringHelper.IsNullOrEmpty((String)strCodeName)) {
            throw new Exception(String.format("\u65e0\u6cd5\u8ba1\u7b97\u7cfb\u7edf\u65b9\u6cd5DTO\u4ee3\u7801\u6807\u8bc6", new Object[0]));
        }
        String strDTOFormat = this.getDTOCodeNameFormat();
        if (!StringHelper.IsNullOrEmpty((String)strDTOFormat)) {
            return String.format(strDTOFormat, strCodeName);
        }
        return strCodeName;
    }

    protected String calcSysMethodDTOCodeName(IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
        if (StringHelper.Compare((String)iPSSysMethodDTO.getType(), (String)"DEFAULT", (boolean)false) == 0) {
            if (iPSSysMethodDTO.getSrcPSSysDynaModel() != null) {
                return String.format("%1$s", iPSSysMethodDTO.getSrcPSSysDynaModel().getCodeName());
            }
            return this.getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="DTO\u4ee3\u7801\u6807\u8bc6\u683c\u5f0f\u5316", dump=false)
    public String getDTOCodeNameFormat() {
        if (StringHelper.IsNullOrEmpty((String)this.psSystem.getDTOFORMAT())) {
            return "%1$sDTO";
        }
        return this.psSystem.getDTOFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u811a\u672c\u5f15\u64ce", fields={"SCRIPTENGINE"})
    public String getDefaultScriptEngine() {
        if (StringHelper.IsNullOrEmpty((String)this.psSystem.getSCRIPTENGINE()) && this.getDefaultPSSysSFPub() != null) {
            return this.getDefaultPSSysSFPub().getScriptEngine();
        }
        return this.psSystem.getSCRIPTENGINE();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"}, dump=false)
    public String getAPICodeNameMode() {
        if (StringHelper.IsNullOrEmpty((String)this.psSystem.getCODENAMEMODE()) && this.getDefaultPSSysSFPub() != null) {
            return this.getDefaultPSSysSFPub().getAPICodeNameMode();
        }
        return this.psSystem.getCODENAMEMODE();
    }

    @Override
    protected String onGetMOSFolder() {
        return "";
    }

    @Override
    public String getMOSFilePath() {
        return null;
    }

    @Override
    protected String onGetRTMOSFolder() {
        return "";
    }

    @Override
    public String getRTMOSFilePath() {
        return null;
    }

    @Override
    public Object getAttribute(String strName) {
        if (this.attributeMap == null) {
            return null;
        }
        return this.attributeMap.get(strName.toUpperCase());
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        if (objValue == null) {
            if (this.attributeMap != null) {
                this.attributeMap.remove(strName.toUpperCase());
            }
        } else {
            if (this.attributeMap == null) {
                this.attributeMap = new HashMap<String, Object>();
            }
            this.attributeMap.put(strName.toUpperCase(), objValue);
        }
    }

    @Override
    public String getAPICodeName(String strPrefix, String strCodeName, String strSuffix) {
        return PSModelCodeNameUtils.to(this.getAPICodeNameMode(), strPrefix, strCodeName, strSuffix);
    }

    @Override
    @PSModelRTMeta(description="DTO\u4f7f\u7528\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dump=false)
    public boolean isDTOUseServiceCodeName() {
        return !StringHelper.IsNullOrEmpty((String)this.getAPICodeNameMode()) && !"NONE".equalsIgnoreCase(this.getAPICodeNameMode());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528PQL", dump=false, ignoredumpvalues="false", fields={"ENABLEPQL"})
    public boolean isEnablePQL() {
        if (!this.psSystem.isENABLEPQLNull()) {
            return this.psSystem.getENABLEPQL();
        }
        return false;
    }
}
