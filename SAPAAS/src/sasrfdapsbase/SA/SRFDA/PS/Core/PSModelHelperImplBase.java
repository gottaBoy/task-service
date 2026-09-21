/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSModelHelperBase;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSASGroup;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSAppLogic;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppMenuLogic;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFDA.PS.Data.PSAppPanelView;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.PS.Data.PSAppPortalViewPart;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSAppServerType;
import SA.SRFDA.PS.Data.PSAppSubApp;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.PS.Data.PSAppUtilType;
import SA.SRFDA.PS.Data.PSAppUtilView;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSBDType;
import SA.SRFDA.PS.Data.PSBackService;
import SA.SRFDA.PS.Data.PSBookingResType;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSCodeSnippetType;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.PS.Data.PSCounterType;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSCtrlLogicGroupDetail;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.PS.Data.PSDBSPPartTempl;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.PS.Data.PSDBSysProcType;
import SA.SRFDA.PS.Data.PSDBType;
import SA.SRFDA.PS.Data.PSDBValueOP;
import SA.SRFDA.PS.Data.PSDCASGroup;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSDCBKType;
import SA.SRFDA.PS.Data.PSDCCluster;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFDA.PS.Data.PSDCCodeSnippetRef;
import SA.SRFDA.PS.Data.PSDCDeployCenter;
import SA.SRFDA.PS.Data.PSDCDeployServer;
import SA.SRFDA.PS.Data.PSDCMSPlatform;
import SA.SRFDA.PS.Data.PSDCMSPlatformFunc;
import SA.SRFDA.PS.Data.PSDCMSPlatformNode;
import SA.SRFDA.PS.Data.PSDCMavenRepo;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFDA.PS.Data.PSDCMobAppTestDevice;
import SA.SRFDA.PS.Data.PSDCRegistryRepo;
import SA.SRFDA.PS.Data.PSDCRobot;
import SA.SRFDA.PS.Data.PSDCWorkshopServer;
import SA.SRFDA.PS.Data.PSDCWorkspace;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEACModeItem;
import SA.SRFDA.PS.Data.PSDEAGDetail;
import SA.SRFDA.PS.Data.PSDEAWGroup;
import SA.SRFDA.PS.Data.PSDEAWGrpDetail;
import SA.SRFDA.PS.Data.PSDEAWItem;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDEActionGroup;
import SA.SRFDA.PS.Data.PSDEActionLogic;
import SA.SRFDA.PS.Data.PSDEActionParam;
import SA.SRFDA.PS.Data.PSDEActionType;
import SA.SRFDA.PS.Data.PSDEActionVR;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.PS.Data.PSDEChartLogic;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.PS.Data.PSDEDQPDCond;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.PS.Data.PSDEDRGroup;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.PS.Data.PSDEDataImportItem;
import SA.SRFDA.PS.Data.PSDEDataQueryCode;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeCond;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeExp;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFDA.PS.Data.PSDEDataView;
import SA.SRFDA.PS.Data.PSDEDataViewItem;
import SA.SRFDA.PS.Data.PSDEDataViewLogic;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFDA.PS.Data.PSDEFGroupDetail;
import SA.SRFDA.PS.Data.PSDEFIUDetail;
import SA.SRFDA.PS.Data.PSDEFIUpdate;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.PS.Data.PSDEFValueRuleType;
import SA.SRFDA.PS.Data.PSDEFValueRuleTypeDetail;
import SA.SRFDA.PS.Data.PSDEFieldType;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormItemVR;
import SA.SRFDA.PS.Data.PSDEFormLogic;
import SA.SRFDA.PS.Data.PSDEFormRF;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEGridEditItemVR;
import SA.SRFDA.PS.Data.PSDEGridLogic;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFDA.PS.Data.PSDEGroupDetail;
import SA.SRFDA.PS.Data.PSDEList;
import SA.SRFDA.PS.Data.PSDEListItem;
import SA.SRFDA.PS.Data.PSDEListLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicLinkCondType;
import SA.SRFDA.PS.Data.PSDELogicLinkType;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.PS.Data.PSDELogicNodeType;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.PS.Data.PSDEMainState;
import SA.SRFDA.PS.Data.PSDEMainStateAction;
import SA.SRFDA.PS.Data.PSDEMainStateField;
import SA.SRFDA.PS.Data.PSDEMainStateOPPriv;
import SA.SRFDA.PS.Data.PSDEMainStateRS;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFDA.PS.Data.PSDEMapAction;
import SA.SRFDA.PS.Data.PSDEMapDataQuery;
import SA.SRFDA.PS.Data.PSDEMapDataSet;
import SA.SRFDA.PS.Data.PSDEMapDetail;
import SA.SRFDA.PS.Data.PSDENotify;
import SA.SRFDA.PS.Data.PSDENotifyTarget;
import SA.SRFDA.PS.Data.PSDEOPPriv;
import SA.SRFDA.PS.Data.PSDEOPPrivRole;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDERDEFMap;
import SA.SRFDA.PS.Data.PSDERGroup;
import SA.SRFDA.PS.Data.PSDERGroupDetail;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.PS.Data.PSDEReportItem;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.PS.Data.PSDESampleData;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.PS.Data.PSDEToolbarLogic;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.PS.Data.PSDETreeLogic;
import SA.SRFDA.PS.Data.PSDETreeNode;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeRS;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFDA.PS.Data.PSDETreeNodeType;
import SA.SRFDA.PS.Data.PSDETreeView;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFDA.PS.Data.PSDEUtilType;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.PS.Data.PSDEViewLogic;
import SA.SRFDA.PS.Data.PSDEViewView;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFDA.PS.Data.PSDEWizardForm;
import SA.SRFDA.PS.Data.PSDEWizardLogic;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFDA.PS.Data.PSDRItemType;
import SA.SRFDA.PS.Data.PSDepSaaSSysVer;
import SA.SRFDA.PS.Data.PSDepSlnAS;
import SA.SRFDA.PS.Data.PSDepSlnASGrp;
import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFDA.PS.Data.PSDepSlnDBInst;
import SA.SRFDA.PS.Data.PSDepSlnHost;
import SA.SRFDA.PS.Data.PSDepSlnMQInst;
import SA.SRFDA.PS.Data.PSDepSlnPrd;
import SA.SRFDA.PS.Data.PSDepSlnSys;
import SA.SRFDA.PS.Data.PSDepSlnSysAS;
import SA.SRFDA.PS.Data.PSDepSlnSysDB;
import SA.SRFDA.PS.Data.PSDepSlnSysMQ;
import SA.SRFDA.PS.Data.PSDepSlnType;
import SA.SRFDA.PS.Data.PSDepSys;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.PS.Data.PSDepSysType;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFDA.PS.Data.PSDepToolType;
import SA.SRFDA.PS.Data.PSDeployCenter;
import SA.SRFDA.PS.Data.PSDeployServer;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.PS.Data.PSDevCenterAS;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.PS.Data.PSDevCenterMQ;
import SA.SRFDA.PS.Data.PSDevCenterSVN;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.PS.Data.PSDevServerType;
import SA.SRFDA.PS.Data.PSDevSln;
import SA.SRFDA.PS.Data.PSDevSlnMSDepAPI;
import SA.SRFDA.PS.Data.PSDevSlnMSDepApp;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFunc;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFuncItem;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFDA.PS.Data.PSDevSlnSysDepInst;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInstRef;
import SA.SRFDA.PS.Data.PSDevSlnSysRes;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSDevUser;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.PS.Data.PSFDLogicType;
import SA.SRFDA.PS.Data.PSGitUser;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFDA.PS.Data.PSHelpArticleTempl;
import SA.SRFDA.PS.Data.PSHelpArticleType;
import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFDA.PS.Data.PSHelpPrjTempl;
import SA.SRFDA.PS.Data.PSHelpPrjType;
import SA.SRFDA.PS.Data.PSHelpResource;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFDA.PS.Data.PSHelpSectionTempl;
import SA.SRFDA.PS.Data.PSHelpSectionType;
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFDA.PS.Data.PSLanguageRes;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFDA.PS.Data.PSMQType;
import SA.SRFDA.PS.Data.PSMSPlatform;
import SA.SRFDA.PS.Data.PSMSPlatformFunc;
import SA.SRFDA.PS.Data.PSMSPlatformNode;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFDA.PS.Data.PSMavenServerType;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFDA.PS.Data.PSMobAppPackServer;
import SA.SRFDA.PS.Data.PSMobAppPackTD;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFDA.PS.Data.PSModel;
import SA.SRFDA.PS.Data.PSModelInit;
import SA.SRFDA.PS.Data.PSModelInitStep;
import SA.SRFDA.PS.Data.PSModelPlugin;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.PS.Data.PSPFCDN;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFDA.PS.Data.PSPFPluginTempl;
import SA.SRFDA.PS.Data.PSPFPluginType;
import SA.SRFDA.PS.Data.PSPFPubObj;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSPanelDetailType;
import SA.SRFDA.PS.Data.PSPanelEngine;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSPanelItemLogicType;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCondType;
import SA.SRFDA.PS.Data.PSPanelLogicLinkType;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.PS.Data.PSPanelLogicNodeType;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
import SA.SRFDA.PS.Data.PSPortletType;
import SA.SRFDA.PS.Data.PSRegistryRepo;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.PS.Data.PSRobotType;
import SA.SRFDA.PS.Data.PSRobotWorkType;
import SA.SRFDA.PS.Data.PSSFPkg;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFDA.PS.Data.PSSFPubObj;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.PS.Data.PSSubApp;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFDA.PS.Data.PSSubDEView;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFDA.PS.Data.PSSubSysSADetail;
import SA.SRFDA.PS.Data.PSSubSysSF;
import SA.SRFDA.PS.Data.PSSubSysServiceAPI;
import SA.SRFDA.PS.Data.PSSubSysVer;
import SA.SRFDA.PS.Data.PSSubViewType;
import SA.SRFDA.PS.Data.PSSysAIChatAgent;
import SA.SRFDA.PS.Data.PSSysAIFactory;
import SA.SRFDA.PS.Data.PSSysAIPipelineAgent;
import SA.SRFDA.PS.Data.PSSysAIPipelineJob;
import SA.SRFDA.PS.Data.PSSysAIPipelineWorker;
import SA.SRFDA.PS.Data.PSSysAIWorkerAgent;
import SA.SRFDA.PS.Data.PSSysActor;
import SA.SRFDA.PS.Data.PSSysBDColSet;
import SA.SRFDA.PS.Data.PSSysBDColumn;
import SA.SRFDA.PS.Data.PSSysBDModule;
import SA.SRFDA.PS.Data.PSSysBDPart;
import SA.SRFDA.PS.Data.PSSysBDScheme;
import SA.SRFDA.PS.Data.PSSysBDTable;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFDA.PS.Data.PSSysBDTableDER;
import SA.SRFDA.PS.Data.PSSysBDTableRS;
import SA.SRFDA.PS.Data.PSSysBIAggColumn;
import SA.SRFDA.PS.Data.PSSysBIAggTable;
import SA.SRFDA.PS.Data.PSSysBICube;
import SA.SRFDA.PS.Data.PSSysBICubeDimension;
import SA.SRFDA.PS.Data.PSSysBICubeLevel;
import SA.SRFDA.PS.Data.PSSysBICubeMeasure;
import SA.SRFDA.PS.Data.PSSysBIDimension;
import SA.SRFDA.PS.Data.PSSysBIHierarchy;
import SA.SRFDA.PS.Data.PSSysBILevel;
import SA.SRFDA.PS.Data.PSSysBIReport;
import SA.SRFDA.PS.Data.PSSysBIReportItem;
import SA.SRFDA.PS.Data.PSSysBIScheme;
import SA.SRFDA.PS.Data.PSSysBackService;
import SA.SRFDA.PS.Data.PSSysCalendar;
import SA.SRFDA.PS.Data.PSSysCalendarItem;
import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFDA.PS.Data.PSSysCalendarLogic;
import SA.SRFDA.PS.Data.PSSysChartTheme;
import SA.SRFDA.PS.Data.PSSysContent;
import SA.SRFDA.PS.Data.PSSysContentCat;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.PS.Data.PSSysCss;
import SA.SRFDA.PS.Data.PSSysDBColumn;
import SA.SRFDA.PS.Data.PSSysDBScheme;
import SA.SRFDA.PS.Data.PSSysDBTable;
import SA.SRFDA.PS.Data.PSSysDBValueFunc;
import SA.SRFDA.PS.Data.PSSysDBValueOP;
import SA.SRFDA.PS.Data.PSSysDEFType;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFDA.PS.Data.PSSysDTSQueue;
import SA.SRFDA.PS.Data.PSSysDashboard;
import SA.SRFDA.PS.Data.PSSysDashboardLogic;
import SA.SRFDA.PS.Data.PSSysDashboardPart;
import SA.SRFDA.PS.Data.PSSysDataSyncAgent;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFDA.PS.Data.PSSysDevBTType;
import SA.SRFDA.PS.Data.PSSysDictCat;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFDA.PS.Data.PSSysEAIDE;
import SA.SRFDA.PS.Data.PSSysEAIDEField;
import SA.SRFDA.PS.Data.PSSysEAIDER;
import SA.SRFDA.PS.Data.PSSysEAIDataType;
import SA.SRFDA.PS.Data.PSSysEAIDataTypeItem;
import SA.SRFDA.PS.Data.PSSysEAIElement;
import SA.SRFDA.PS.Data.PSSysEAIElementAttr;
import SA.SRFDA.PS.Data.PSSysEAIElementRE;
import SA.SRFDA.PS.Data.PSSysEAIScheme;
import SA.SRFDA.PS.Data.PSSysERMap;
import SA.SRFDA.PS.Data.PSSysERMapNode;
import SA.SRFDA.PS.Data.PSSysEditorStyle;
import SA.SRFDA.PS.Data.PSSysEngineCfg;
import SA.SRFDA.PS.Data.PSSysFile;
import SA.SRFDA.PS.Data.PSSysImage;
import SA.SRFDA.PS.Data.PSSysIssueEngine;
import SA.SRFDA.PS.Data.PSSysLogic;
import SA.SRFDA.PS.Data.PSSysMapItem;
import SA.SRFDA.PS.Data.PSSysMapLogic;
import SA.SRFDA.PS.Data.PSSysMapView;
import SA.SRFDA.PS.Data.PSSysModelGroup;
import SA.SRFDA.PS.Data.PSSysModelLog;
import SA.SRFDA.PS.Data.PSSysMsgQueue;
import SA.SRFDA.PS.Data.PSSysMsgTarget;
import SA.SRFDA.PS.Data.PSSysMsgTempl;
import SA.SRFDA.PS.Data.PSSysPDTView;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSSysPanel;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFDA.PS.Data.PSSysPanelLogic;
import SA.SRFDA.PS.Data.PSSysPanelModel;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFDA.PS.Data.PSSysPortletCat;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFDA.PS.Data.PSSysRefDE;
import SA.SRFDA.PS.Data.PSSysReqItem;
import SA.SRFDA.PS.Data.PSSysReqModule;
import SA.SRFDA.PS.Data.PSSysResource;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.PS.Data.PSSysSFPlugin;
import SA.SRFDA.PS.Data.PSSysSFPluginTempl;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.PS.Data.PSSysSFPubPkg;
import SA.SRFDA.PS.Data.PSSysSampleValue;
import SA.SRFDA.PS.Data.PSSysSearchBar;
import SA.SRFDA.PS.Data.PSSysSearchBarItem;
import SA.SRFDA.PS.Data.PSSysSearchBarLogic;
import SA.SRFDA.PS.Data.PSSysSearchDE;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFDA.PS.Data.PSSysSearchDoc;
import SA.SRFDA.PS.Data.PSSysSearchField;
import SA.SRFDA.PS.Data.PSSysSearchScheme;
import SA.SRFDA.PS.Data.PSSysSequence;
import SA.SRFDA.PS.Data.PSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysServiceAPIHandler;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFDA.PS.Data.PSSysTestCaseAssert;
import SA.SRFDA.PS.Data.PSSysTestCaseInput;
import SA.SRFDA.PS.Data.PSSysTestData;
import SA.SRFDA.PS.Data.PSSysTestDataItem;
import SA.SRFDA.PS.Data.PSSysTestModule;
import SA.SRFDA.PS.Data.PSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysTranslator;
import SA.SRFDA.PS.Data.PSSysUCMap;
import SA.SRFDA.PS.Data.PSSysUCMapNode;
import SA.SRFDA.PS.Data.PSSysUniRes;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFDA.PS.Data.PSSysUnit;
import SA.SRFDA.PS.Data.PSSysUserCase;
import SA.SRFDA.PS.Data.PSSysUserCaseRS;
import SA.SRFDA.PS.Data.PSSysUserDR;
import SA.SRFDA.PS.Data.PSSysUserMode;
import SA.SRFDA.PS.Data.PSSysUserRole;
import SA.SRFDA.PS.Data.PSSysUserRoleData;
import SA.SRFDA.PS.Data.PSSysUserRoleRes;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFDA.PS.Data.PSSysUtilType;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.PS.Data.PSSysViewLogicParam;
import SA.SRFDA.PS.Data.PSSysWFSetting;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSSystemAS;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFDA.PS.Data.PSViewEngine;
import SA.SRFDA.PS.Data.PSViewLogicType;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewTypeCtrl;
import SA.SRFDA.PS.Data.PSViewTypeView;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkCondType;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.PS.Data.PSWFLinkType;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFProcessType;
import SA.SRFDA.PS.Data.PSWFRole;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.PS.Data.PSWFWorkTime;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.PS.Data.PSWorkshopServer;
import SA.SRFDA.PS.Data.PSWorkspaceType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelHelperImplBase
extends PSModelHelperBase
implements IPSModelHelper {
    private static final Log log = LogFactory.getLog(PSModelHelperImplBase.class);

    @Override
    public CallResult getPSSystem(String strPSSystemId, PSSystem psSystem) {
        return this.selectSingle(this.getSQL_getPSSystem(strPSSystemId), psSystem, "SYSTEM");
    }

    @Override
    public CallResult getPSSysWFSetting(String strPSSysWFSettingId, PSSysWFSetting psSysWFSetting) {
        return this.selectSingle(this.getSQL_getPSSysWFSetting(strPSSysWFSettingId), psSysWFSetting, "SYSTEM");
    }

    @Override
    public CallResult getPSDevCenter(String strPSDevCenterId, PSDevCenter psDevCenter) {
        return this.selectSingle(this.getSQL_getPSDevCenter(strPSDevCenterId), psDevCenter, "SYSTEM");
    }

    @Override
    public CallResult getPSDevSln(String strPSDevSlnId, PSDevSln psDevSln) {
        return this.selectSingle(this.getSQL_getPSDevSln(strPSDevSlnId), psDevSln, "SYSTEM");
    }

    @Override
    public CallResult getPSDevSlnSys(String strPSDevSlnSysId, PSDevSlnSys psDevSlnSys) {
        return this.selectSingle(this.getSQL_getPSDevSlnSys(strPSDevSlnSysId), psDevSlnSys, "SYSTEM");
    }

    @Override
    public CallResult getPSDevSlnSysByMajorInst(String strPSSysModelInstId, PSDevSlnSys psDevSlnSys) {
        return this.selectSingle(this.getSQL_getPSDevSlnSysByMajorInst(strPSSysModelInstId), psDevSlnSys, "SYSTEM");
    }

    @Override
    public CallResult getPSModelInit(String strPSModelInitId, PSModelInit psModelInit) {
        return this.selectSingle(this.getSQL_getPSModelInit(strPSModelInitId), psModelInit, "SYSTEM");
    }

    @Override
    public CallResult getPSModelInitSteps(String strPSModelInitId, Vector<PSModelInitStep> psModelInitStepList) {
        return this.selectMulti(this.getSQL_getPSModelInitSteps(strPSModelInitId), psModelInitStepList, PSModelInitStep.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFieldType(String strPSDEFieldTypeId, PSDEFieldType psDEFieldType) {
        return this.selectSingle(this.getSQL_getPSDEFieldType(strPSDEFieldTypeId), psDEFieldType, "SYSTEM");
    }

    @Override
    public CallResult getPSCodeListByTempl(String strPSCodeListTemplId, PSCodeList psCodeList) {
        return this.selectSingle(this.getSQL_getPSCodeListByTempl(strPSCodeListTemplId), psCodeList, "SYSTEM");
    }

    @Override
    public CallResult getPSSystemDeployDBs(String strPSSystemDeployId, Vector<PSSystemDeployDB> psSystemDeployDBList) {
        return this.selectMulti(this.getSQL_getPSSystemDeployDBs(strPSSystemDeployId), psSystemDeployDBList, PSSystemDeployDB.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDBType(String strPSDBTypeId, PSDBType psDBType) {
        return this.selectSingle(this.getSQL_getPSDBType(strPSDBTypeId), psDBType, "SYSTEM");
    }

    @Override
    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> psDEFieldTypes) {
        return this.selectMulti(this.getSQL_getAllPSDEFieldTypes(), psDEFieldTypes, PSDEFieldType.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEM t1 where  t1.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysWFSetting(String strPSSysWFSettingId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSWFSETTING t1 where  t1.PSSYSWFSETTINGID='%1$s'", (Object)strPSSysWFSettingId);
    }

    protected String getSQL_getPSDevCenter(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVCENTER t1 where  t1.PSDEVCENTERID='%1$s'", (Object)strPSDevCenterId);
    }

    protected String getSQL_getPSDEFGroup(String strPSDEFGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFGROUP t1 where  t1.PSDEFGROUPID='%1$s'", (Object)strPSDEFGroupId);
    }

    protected String getSQL_getPSDevSln(String strPSDevSlnId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLN t1 where  t1.PSDEVSLNID='%1$s'", (Object)strPSDevSlnId);
    }

    protected String getSQL_getPSDevSlnSys(String strPSDevSlnSysId) {
        if (this.isUseTableOnly()) {
            return StringHelper.Format((String)"SELECT\r\nt1.ACTIONOWNER,\r\nt1.APIFLAG,\r\nt1.CALLBACKTAG,\r\nt1.CALLBACKURL,\r\nt1.CODENAME,\r\nt1.CREATEDATE,\r\nt1.CREATEMAN,\r\nt1.CURACTION,\r\nt1.DB2PSDCDBINSTID,\r\nt1.DB2PSDCDBINSTNAME,\r\nt1.DBTYPES,\r\nt1.DBVERSION,\r\nt1.DEPLOYSYSID,\r\nt1.DEPLOYSYSORGID,\r\nt1.DEPLOYSYSORGSECTORID,\r\nt1.DEPLOYSYSTAG,\r\nt1.DEPLOYSYSTAG2,\r\nt1.DEPLOYSYSTYPE,\r\nt1.DEVRESSTATE,\r\nt1.DEVSYSSTATE,\r\nt1.DOCPSDEVCENTERSVNID,\r\nt11.PSDEVCENTERSVNNAME AS DOCPSDEVCENTERSVNNAME,\r\nt1.ENABLECALLBACK,\r\nt1.ENABLEDEPLOYCENTER,\r\nt1.ENABLEDM,\r\nt1.ENABLEDYNASYS,\r\nt1.ENABLEFOLDERKEY,\r\nt1.ENABLEHANA,\r\nt1.ENABLEMYSQL5,\r\nt1.ENABLESQLITE,\r\nt1.ENABLEWSSERVER,\r\nt1.ENTITYCNT,\r\nt1.EXPRIEDTIME,\r\nt1.HBASEPSDCBDINSTID,\r\nt21.PSDCBDINSTNAME AS HBASEPSDCBDINSTNAME,\r\nt1.JITPSDBDEVINSTID,\r\nt31.PSDBDEVINSTNAME AS JITPSDBDEVINSTNAME,\r\nt1.JITPSDEVCENTERTSID,\r\nt41.PSDEVCENTERTSNAME AS JITPSDEVCENTERTSNAME,\r\nt1.LASTACTIVETIME,\r\nt1.LOADTIME,\r\nt1.LOGICNAME,\r\nt1.MAINPSDEVSLNSYSID,\r\nt1.MAINPSDEVSLNSYSNAME,\r\nt1.MAXENTITYCNT,\r\nt1.MEMO,\r\nt51.MODELVER AS MODELINSTVER,\r\nt1.MODELPREFIX,\r\nt1.MODELPSDEVCENTERSVNID,\r\nt61.PSDEVCENTERSVNNAME AS MODELPSDEVCENTERSVNNAME,\r\nt1.MSSQLPSDCDBINSTID,\r\nt1.MSSQLPSDCDBINSTNAME,\r\nt1.MYSQLPSDCDBINSTID,\r\nt1.MYSQLPSDCDBINSTNAME,\r\nt1.OFFLINETIME,\r\nt1.ORAPSDCDBINSTID,\r\nt1.ORAPSDCDBINSTNAME,\r\nt1.PGSQLPSDCDBINSTID,\r\nt1.PGSQLPSDCDBINSTNAME,\r\nt1.PPASPSDCDBINSTID,\r\nt1.PPASPSDCDBINSTNAME,\r\nt1.PPSDEVSLNSYSID,\r\nt1.PPSDEVSLNSYSNAME,\r\nt1.PSDCDEPLOYCENTERID,\r\nt71.PSDCDEPLOYCENTERNAME,\r\nt1.PSDCMODELTEMPLID,\r\nt81.PSDCMODELTEMPLNAME,\r\nt1.PSDCROBOTID,\r\nt1.PSDCROBOTNAME,\r\nt1.PSDCSYSLICID,\r\nt91.PSDCSYSLICNAME,\r\nt1.PSDCWORKSPACEID,\r\nt1.PSDEVCENTERASID,\r\nt1.PSDEVCENTERASID2,\r\nt1.PSDEVCENTERASID3,\r\nt1.PSDEVCENTERASID4,\r\nt101.PSDEVCENTERASNAME,\r\nt111.PSDEVCENTERID,\r\nt121.PSDEVCENTERNAME,\r\nt1.PSDEVCENTERSVNID,\r\nt131.PSDEVCENTERSVNNAME,\r\nt1.PSDEVCENTERTSID,\r\nt1.PSDEVCENTERTSNAME,\r\nt1.PSDEVSLNID,\r\nt1.PSDEVSLNNAME,\r\nt1.PSDEVSLNSYSID,\r\nt1.PSDEVSLNSYSNAME,\r\nt1.PSDEVSLNSYSRESID,\r\nt141.PSDEVSLNSYSRESNAME,\r\nt1.PSPFID,\r\nt151.PSPFNAME,\r\nt1.PSSFID,\r\nt1.PSSFNAME,\r\nt1.PSSTUDIOTHEMEID,\r\nt161.PSSTUDIOTHEMENAME,\r\nt1.PSSYSMODELINSTID,\r\nt1.PSSYSMODELINSTNAME,\r\nt1.PSSYSPOLICYID,\r\nt1.PSSYSTEMID,\r\nt1.PSTASKSERVERID,\r\nt1.PSTASKSERVERNAME,\r\nt1.PUBCODE,\r\nt1.RESREADYTIME,\r\nt1.ROPSDEVCENTERSVNID,\r\nt171.PSDEVCENTERSVNNAME AS ROPSDEVCENTERSVNNAME,\r\nt1.RTMODELPSDEVCENTERSVNID,\r\nt181.PSDEVCENTERSVNNAME AS RTMODELPSDEVCENTERSVNNAME,\r\nt1.SAASMODE,\r\nt1.SFPSSUBSYSID,\r\nt1.SFPSSUBSYSNAME,\r\nt1.SHAREFLAG,\r\nt1.STUDIOTAG,\r\nt1.STUDIOTAG2,\r\nt1.STUDIOVER,\r\nt1.SYSMDURL,\r\nt51.SYSROWKEY,\r\nt1.SYSTAG,\r\nt1.SYSTAG2,\r\nt1.SYSTAG3,\r\nt1.SYSTAG4,\r\nt1.SYSTYPE,\r\nt1.SYSVER,\r\nt1.TEMPLENGINE,\r\nt161.CARDCSSSTYLE AS THEMECSSSTYLE,\r\nt1.UNLOADTIME,\r\nt1.UPDATEDATE,\r\nt1.UPDATEMAN,\r\nt1.VALIDFLAG,\r\nt1.VCTYPE\r\nFROM T_SRFPSDEVSLNSYS t1 \r\nLEFT JOIN T_SRFPSDEVCENTERSVN t11 ON t1.DOCPSDEVCENTERSVNID = t11.PSDEVCENTERSVNID \r\nLEFT JOIN T_SRFPSDCBDINST t21 ON t1.HBASEPSDCBDINSTID = t21.PSDCBDINSTID \r\nLEFT JOIN T_SRFPSDBDEVINST t31 ON t1.JITPSDBDEVINSTID = t31.PSDBDEVINSTID \r\nLEFT JOIN T_SRFPSDEVCENTERTS t41 ON t1.JITPSDEVCENTERTSID = t41.PSDEVCENTERTSID \r\nLEFT JOIN T_SRFPSSYSMODELINST t51 ON t1.PSSYSMODELINSTID = t51.PSSYSMODELINSTID \r\nLEFT JOIN T_SRFPSDEVCENTERSVN t61 ON t1.MODELPSDEVCENTERSVNID = t61.PSDEVCENTERSVNID \r\nLEFT JOIN T_SRFPSDCDEPLOYCENTER t71 ON t1.PSDCDEPLOYCENTERID = t71.PSDCDEPLOYCENTERID \r\nLEFT JOIN T_SRFPSDCMODELTEMPL t81 ON t1.PSDCMODELTEMPLID = t81.PSDCMODELTEMPLID \r\nLEFT JOIN T_SRFPSDCSYSLIC t91 ON t1.PSDCSYSLICID = t91.PSDCSYSLICID \r\nLEFT JOIN T_SRFPSDEVCENTERAS t101 ON t1.PSDEVCENTERASID = t101.PSDEVCENTERASID \r\nLEFT JOIN T_SRFPSDEVSLN t111 ON t1.PSDEVSLNID = t111.PSDEVSLNID \r\nLEFT JOIN T_SRFPSDEVCENTER t121 ON t111.PSDEVCENTERID = t121.PSDEVCENTERID \r\nLEFT JOIN T_SRFPSDEVCENTERSVN t131 ON t1.PSDEVCENTERSVNID = t131.PSDEVCENTERSVNID \r\nLEFT JOIN T_SRFPSDEVSLNSYSRES t141 ON t1.PSDEVSLNSYSRESID = t141.PSDEVSLNSYSRESID \r\nLEFT JOIN T_SRFPSPF t151 ON t1.PSPFID = t151.PSPFID \r\nLEFT JOIN T_SRFPSSTUDIOTHEME t161 ON t1.PSSTUDIOTHEMEID = t161.PSSTUDIOTHEMEID \r\nLEFT JOIN T_SRFPSDEVCENTERSVN t171 ON t1.ROPSDEVCENTERSVNID = t171.PSDEVCENTERSVNID \r\nLEFT JOIN T_SRFPSDEVCENTERSVN t181 ON t1.RTMODELPSDEVCENTERSVNID = t181.PSDEVCENTERSVNID where  t1.PSDEVSLNSYSID='%1$s'", (Object)strPSDevSlnSysId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNSYS t1 where  t1.PSDEVSLNSYSID='%1$s'", (Object)strPSDevSlnSysId);
    }

    protected String getSQL_getPSDevSlnSysByMajorInst(String strPSSysModelInstId) {
        return StringHelper.Format((String)"SELECT PSDEVSLNSYSID,PSSYSTEMID FROM T_SRFPSDEVSLNSYS WHERE SHAREFLAG  = 0 AND PSSYSMODELINSTID = '%1$s'", (Object)strPSSysModelInstId);
    }

    protected String getSQL_getPSModelInit(String strPSModelInitId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODELINIT t1 where  t1.PSMODELINITID='%1$s'", (Object)strPSModelInitId);
    }

    protected String getSQL_getPSModelInitSteps(String strPSModelInitId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMIDETAIL t1 where  t1.PSMODELINITID='%1$s' order by ORDERVALUE ", (Object)strPSModelInitId);
    }

    protected String getSQL_getPSDEFieldType(String strPSDEFieldTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFTYPE t1 where  t1.PSDEFTYPEID='%1$s'", (Object)strPSDEFieldTypeId);
    }

    protected String getSQL_getAllPSDEFieldTypes() {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFTYPE t1  order by ORDERVALUE ");
    }

    protected String getSQL_getPSCodeList(String strPSCodeListId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODELIST t1 where t1.PSCODELISTID='%1$s' AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 )", (Object)strPSCodeListId);
    }

    protected String getSQL_getPSCodeListByTempl(String strPSCodeListTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODELIST t1 where  t1.PSCODELISTTEMPLID='%1$s' AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 )", (Object)strPSCodeListTemplId);
    }

    protected String getSQL_getPSSystemDeployDBs(String strPSSystemDeployId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDEPLOYDB t1 where  t1.PSSYSDEPLOYID='%1$s' ", (Object)strPSSystemDeployId);
    }

    protected String getSQL_getPSDBType(String strPSDBTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDBTYPE t1 where  t1.PSDBTYPEID='%1$s'", (Object)strPSDBTypeId);
    }

    protected String getSQL_getPSDEFieldsNoSort(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFIELD t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEFieldsNoSortBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSSYSTEMID from T_SRFPSDEFIELD t1 inner join T_SRFPSDATAENTITY t2 on t1.PSDEID=t2.PSDATAENTITYID  where  t2.PSSYSTEMID ='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEField(String strPSDEFieldId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFIELD t1 where  t1.PSDEFIELDID='%1$s' ", (Object)strPSDEFieldId);
    }

    protected String getSQL_getPSDataEntity(String strPSSystemId, String strPSDataEntityName) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDATAENTITY t1 where t1.PSSYSTEMID='%1$s' and (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) and (t1.PSDATAENTITYID='%2$s' OR t1.PSDATAENTITYNAME='%2$s')", (Object)strPSSystemId, (Object)strPSDataEntityName);
    }

    protected String getSQL_getPSDataEntity(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.PSSYSTEMID,t1.PSDATAENTITYNAME,t1.MODELVER from t_SRFPSDATAENTITY t1 where t1.PSDATAENTITYID='%1$s' and (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEDBConfigs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBCFG t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEDBConfigsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBCFG t1 inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDBConfig(String strPSDataEntityId, String strDBType) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBCFG t1 where t1.PSDEID='%1$s' and t1.PSDEDBCFGNAME='%2$s'", (Object)strPSDataEntityId, (Object)strDBType);
    }

    protected String getSQL_getPSDEFDTColumns(String strPSDataEntityId, String strDBType) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFDTCOL t1 INNER JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID = t2.PSDEFIELDID where t2.PSDEID='%1$s' AND t1.DBTYPE='%2$s' ", (Object)strPSDataEntityId, (Object)strDBType);
    }

    protected String getSQL_getPSSystemDBConfigs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEMDBCFG t1 where  t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSystemDBConfig(String strPSSystemId, String strDBType) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEMDBCFG t1 where t1.PSSYSTEMID='%1$s' and t1.PSSYSTEMDBCFGNAME='%2$s'", (Object)strPSSystemId, (Object)strDBType);
    }

    protected String getSQL_getPSSystemDeploy(String strPSSystemDeployId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDEPLOY t1 where t1.PSSYSDEPLOYID='%1$s' ", (Object)strPSSystemDeployId);
    }

    protected String getSQL_getPSSystemApplication(String strPSSystemApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSAPP t1 where t1.PSSYSAPPID='%1$s' ", (Object)strPSSystemApplicationId);
    }

    protected String getSQL_getAllPSSystemApplications(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSAPP t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSystemModules(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODULE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSystemDBConfigs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEMDBCFG t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSViewType(String strPSViewTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVIEWTYPE t1 where  t1.PSVIEWTYPEID='%1$s'", (Object)strPSViewTypeId);
    }

    protected String getSQL_getPSApplicationView(String strPSApplicationViewId) {
        if (strPSApplicationViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPVIEW_TMP t1 where  t1.PSAPPVIEWID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSApplicationViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPVIEW t1 where  t1.PSAPPVIEWID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSApplicationViewId);
    }

    protected String getSQL_getPSAppIndexView(String strPSAppIndexViewId) {
        if (strPSAppIndexViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPINDEXVIEW_TMP t1 where  t1.PSAPPINDEXVIEWID='%1$s'", (Object)strPSAppIndexViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPINDEXVIEW t1 where  t1.PSAPPINDEXVIEWID='%1$s'", (Object)strPSAppIndexViewId);
    }

    protected String getSQL_getPSAppPortalView(String strPSAppPortalViewId) {
        if (strPSAppPortalViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPPORTALVIEW_TMP t1 where  t1.PSAPPPORTALVIEWID='%1$s' ", (Object)strPSAppPortalViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPPORTALVIEW t1 where  t1.PSAPPPORTALVIEWID='%1$s'", (Object)strPSAppPortalViewId);
    }

    protected String getSQL_getAllPSApplicationViews(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPVIEW t1 where  t1.PSSYSAPPID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSApplicationId);
    }

    protected String getSQL_getAllPSAppUtilPages(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUTILPAGE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getAllPSAppViewCodes(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPVIEWCODE t1 where  t1.PSSYSAPPID='%1$s' AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1)", (Object)strPSApplicationId);
    }

    protected String getSQL_getAllPSAppDEViews(String strPSSysAppId, String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPDEVIEW t1 inner join T_SRFPSDEVIEWBASE t2 on t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID where  t2.PSDEID='%1$s' and t1.PSSYSAPPID='%2$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSDEId, (Object)strPSSysAppId);
    }

    protected String getSQL_getAllPSAppDEViews(String strPSSysAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPDEVIEW t1 inner join T_SRFPSDEVIEWBASE t2 on t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID where  t1.PSSYSAPPID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSSysAppId);
    }

    protected String getSQL_getAllPSDEViewBasesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1  where  t1.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEToolbarsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETOOLBAR t1 where  t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEToolbarItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETBITEM t1  inner join t_SRFPSDETOOLBAR t2 on t1.PSDETOOLBARID=t2.PSDETOOLBARID where  t2.PSSYSTEMID='%1$s' order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFormsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORM t1 inner join t_srfpsdataentity t2 on t1.psdeid=t2.psdataentityid where  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEGridsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGRID t1 inner join t_srfpsdataentity t2 on t1.psdeid=t2.psdataentityid where  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEChartsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHART t1 inner join t_srfpsdataentity t2 on t1.psdeid=t2.psdataentityid where  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFormDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.FORMTYPE from T_SRFPSDEFORMDETAIL t1  inner join t_SRFPSDEFORM t2 on t1.PSDEFORMID=t2.PSDEFORMID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEGridColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGRIDCOL t1  inner join t_SRFPSDEGRID t2 on t1.PSDEGRIDID=t2.PSDEGRIDID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEChartAxesesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTAXES t1  inner join t_SRFPSDECHART t2 on t1.PSDECHARTID=t2.PSDECHARTID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEChartSeriesesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTPARAM t1  inner join t_SRFPSDECHART t2 on t1.PSDECHARTID=t2.PSDECHARTID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSEditorType(String strPSEditorTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSEDITORTYPE t1 where  t1.PSEDITORTYPEID='%1$s'", (Object)strPSEditorTypeId);
    }

    protected String getSQL_getPSAppModule(String strPSAppModuleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMODULE t1 where  t1.PSAPPMODULEID='%1$s'", (Object)strPSAppModuleId);
    }

    protected String getSQL_getAllPSAppModules(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMODULE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppUtilPage(String strPSAppUtilPageId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUTILPAGE t1 where  t1.PSAPPUTILPAGEID='%1$s'", (Object)strPSAppUtilPageId);
    }

    protected String getSQL_getPSAppUIStyle(String strPSAppUIStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUISTYLE t1 where  t1.PSAPPUISTYLEID='%1$s'", (Object)strPSAppUIStyleId);
    }

    protected String getSQL_getPSAppType(String strPSAppTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAppType t1 where  t1.PSAppTypeID='%1$s'", (Object)strPSAppTypeId);
    }

    protected String getSQL_getPSPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFStyle t1 where  t1.PSPFSTYLEID='%1$s'", (Object)strPSPFStyleId);
    }

    protected String getSQL_getPSPFStyleRefreshVersion(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.PSPFSTYLEID,t1.VERSION from T_SRFPSPFStyle t1 where  t1.PSPFSTYLEID='%1$s'", (Object)strPSPFStyleId);
    }

    protected String getSQL_getPSSFStyleRefreshVersion(String strPSSFStyleId) {
        return StringHelper.Format((String)"select t1.PSSFSTYLEID,t1.VERSION from T_SRFPSSFStyle t1 where  t1.PSSFSTYLEID='%1$s'", (Object)strPSSFStyleId);
    }

    protected String getSQL_getPSPFCodeFolder(String strPSPFCodeFolderId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFCodeFolder t1 where  t1.PSPFCodeFolderID='%1$s'", (Object)strPSPFCodeFolderId);
    }

    protected String getSQL_getPSPFPubCodes(String strPSPFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PSPFID='%1$s' ", (Object)strPSPFId);
    }

    protected String getSQL_getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PPSPFPUBCODEID='%1$s' ", (Object)strPSPFPubCodeId);
    }

    protected String getSQL_getPSPFViewTempl(String strPSPFViewTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFVIEWTEMPL t1 where  t1.PSPFVIEWTEMPLID='%1$s'", (Object)strPSPFViewTemplId);
    }

    protected String getSQL_getPSPFViewTemplsByPF(String strPSPFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFVIEWTEMPL t1 where t1.PSPFID='%1$s' ", (Object)strPSPFId);
    }

    protected String getSQL_getPSPFViewTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFVIEWTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    protected String getSQL_getPSPFPubCode(String strPSPFPubCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPUBCODE t1 where  t1.PSPFPUBCODEID='%1$s'", (Object)strPSPFPubCodeId);
    }

    protected String getSQL_getPSDEUIActionType(String strPSDEUIActionTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTIONTYPE t1 where  t1.PSDEUIACTIONTYPEID='%1$s'", (Object)strPSDEUIActionTypeId);
    }

    protected String getSQL_getPSPFCtrlTempl(String strPSPFCtrlTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFCTRLTEMPL t1 where  t1.PSPFCTRLTEMPLID='%1$s'", (Object)strPSPFCtrlTemplId);
    }

    protected String getSQL_getPSDEGridColumnType(String strPSDEGridColumnTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGCTYPE t1 where  t1.PSDEGCTYPEID='%1$s'", (Object)strPSDEGridColumnTypeId);
    }

    protected String getSQL_getPSDEFGridColumns(String strPSDEFieldId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFGRIDCOL t1 where  t1.PSDEFID='%1$s' ", (Object)strPSDEFieldId);
    }

    protected String getSQL_getPSDEGridColumns(String strPSDEGridId) {
        if (strPSDEGridId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEGRIDCOL_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEGridId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGRIDCOL t1 where  t1.PSDEGRIDID='%1$s' order by ORDERVALUE", (Object)strPSDEGridId);
    }

    protected String getSQL_getPSDEChartAxeses(String strPSDEChartId) {
        if (strPSDEChartId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDECHARTAXES_TMP t1 where  t1.PSDECHARTID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEChartId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTAXES t1 where  t1.PSDECHARTID='%1$s' ", (Object)strPSDEChartId);
    }

    protected String getSQL_getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFCTDETAIL t1 where  t1.PSPFCTRLTEMPLID='%1$s'", (Object)strPSPFCtrlTemplId);
    }

    protected String getSQL_getPSDERType(String strPSDERTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDERTYPE t1 where  t1.PSDERTYPEID='%1$s'", (Object)strPSDERTypeId);
    }

    protected String getSQL_getPSToolbarItemType(String strPSToolbarItemTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSTBITEMTYPE t1 where  t1.PSTBITEMTYPEID='%1$s'", (Object)strPSToolbarItemTypeId);
    }

    protected String getSQL_getPSDEToolbarItems(String strPSDEToolbarId) {
        if (strPSDEToolbarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETBITEM_TMP t1 where  t1.PSDETOOLBARID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEToolbarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETBITEM t1 where  t1.PSDETOOLBARID='%1$s' order by ORDERVALUE", (Object)strPSDEToolbarId);
    }

    protected String getSQL_getPSDEUIActionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1  inner join t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid  where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  AND t1.PSWFID IS  NULL ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEUIActions(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSSysDEUIActions(String strPSSystemId) {
        if (this.getModelInstVer() >= 357) {
            return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where (( t1.PSDEID IS NULL ) OR (t1.GLOBALFLAG IS NOT NULL AND t1.GLOBALFLAG = 1)) AND t1.PSWFID IS NULL  AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSDEID IS NULL AND t1.PSWFID IS NULL  AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEUIAction(String strPSDEUIActionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSDEUIACTIONID='%1$s'", (Object)strPSDEUIActionId);
    }

    protected String getSQL_getPSDEUIActionGroup(String strPSDEUIActionGroupId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEUAGROUPID='%1$s'", (Object)strPSDEUIActionGroupId);
    }

    protected String getSQL_getPSAppViewStyle(String strPSAppViewStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPVIEWSTYLE t1 where  t1.PSAPPVIEWSTYLEID='%1$s'", (Object)strPSAppViewStyleId);
    }

    protected String getSQL_getPSFormType(String strPSFormTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSFORMTYPE t1 where  t1.PSFORMTYPEID='%1$s'", (Object)strPSFormTypeId);
    }

    protected String getSQL_getPSDEFormDetails(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFORMDETAIL_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.*,t2.FORMTYPE from T_SRFPSDEFORMDETAIL t1 inner join T_SRFPSDEFORM t2 on t1.PSDEFORMID = t2.PSDEFORMID where  t1.PSDEFORMID='%1$s' order by ORDERVALUE", (Object)strPSDEFormId);
    }

    protected String getSQL_getPSFormDetailType(String strPSFormDetailTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSFORMDETAILTYPE t1 where  t1.PSFORMDETAILTYPEID='%1$s'", (Object)strPSFormDetailTypeId);
    }

    protected String getSQL_getPSDEFGridColumnsByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFGRIDCOL t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    protected String getSQL_getPSDEFGridColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.psdeid from V_SRFPSDEFGRIDCOL t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID  inner join T_SRFPSDATAENTITY t3 on  t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFUIModesByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFFORMITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    protected String getSQL_getPSDEFUIModesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.psdeid from T_SRFPSDEFFORMITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID  inner join T_SRFPSDATAENTITY t3 on  t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFSearchModesByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFSFITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ORDER BY t1.PSDEFSFITEMNAME ", (Object)strPSDEId);
    }

    protected String getSQL_getPSDEFSearchModesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.psdeid from V_SRFPSDEFSFITEM t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID inner join T_SRFPSDATAENTITY t3 on  t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.PSDEFSFITEMNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFDTColumnsByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFDTCOL t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    protected String getSQL_getPSDEFDTColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFDTCOL t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID inner join T_SRFPSDATAENTITY t3 on  t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPFEditorTempl(String strPSPFEditorTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFEDITORTEMPL t1 where  t1.PSPFEDITORTEMPLID='%1$s'", (Object)strPSPFEditorTemplId);
    }

    protected String getSQL_getPSAppEditorTempl(String strPSAppEditorTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPEDITORTEMPL t1 where  t1.PSAPPEDITORTEMPLID='%1$s'", (Object)strPSAppEditorTemplId);
    }

    protected String getSQL_getAllPSAppEditorTempls(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPEDITORTEMPL t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSDERs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDER t1 where t1.MAJORPSDEID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ORDER BY t1.PSDERNAME ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDERsByMinorDEId(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDER t1 where  t1.MINORPSDEID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ORDER BY t1.PSDERNAME", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSAppFunc(String strPSAppFuncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPFUNC t1 where  t1.PSAPPFUNCID='%1$s'", (Object)strPSAppFuncId);
    }

    protected String getSQL_getAllPSAppFuncs(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPFUNC t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppMenuItemsBySysApp(String strPSSysAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENUITEM t1 INNER JOIN T_SRFPSAPPMENU t2 on T1.PSAPPMENUID = t2.PSAPPMENUID where  t2.PSSYSAPPID='%1$s' order by t1.ORDERVALUE", (Object)strPSSysAppId);
    }

    protected String getSQL_getPSAppMenuItems(String strPSAppMenuId) {
        if (strPSAppMenuId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPMENUITEM_TMP t1 where  t1.PSAPPMENUID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSAppMenuId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENUITEM t1 where  t1.PSAPPMENUID='%1$s' order by ORDERVALUE", (Object)strPSAppMenuId);
    }

    protected String getSQL_getPSAppMenuItemType(String strPSAppMenuItemTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAMITEMTYPE t1 where  t1.PSAMITEMTYPEID='%1$s'", (Object)strPSAppMenuItemTypeId);
    }

    protected String getSQL_getPSDER(String strPSDERId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDER t1 where  t1.PSDERID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ", (Object)strPSDERId);
    }

    protected String getSQL_getPSDBValueFunc(String strPSDBValueFuncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBVALUEFUNC t1 where  t1.PSDBVALUEFUNCID='%1$s'", (Object)strPSDBValueFuncId);
    }

    protected String getSQL_getPSSysDBValueFunc(String strPSSystemId, String strPSSysDBValueFuncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDBVF t1 where t1.PSSYSTEMID='%1$s' AND  t1.PSSYSDBVFID='%2$s'", (Object)strPSSystemId, (Object)strPSSysDBValueFuncId);
    }

    protected String getSQL_getPSV3Migrate(String strPSV3MigrateId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSV3MIGRATE t1 where  t1.PSV3MIGRATEID='%1$s'", (Object)strPSV3MigrateId);
    }

    protected String getSQL_getPSDEJoinType(String strPSDEJoinTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEJOINTYPE t1 where  t1.PSDEJOINTYPEID='%1$s'", (Object)strPSDEJoinTypeId);
    }

    protected String getSQL_getPSDEDataQueries(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAQUERY t1 where  t1.PSDEID='%1$s' ORDER BY t1.PSDEDATAQUERYNAME ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEDataQueriesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAQUERY t1  inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ORDER BY t1.PSDEDATAQUERYNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataQuery(String strPSDEDataQueryId) {
        if (strPSDEDataQueryId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDATAQUERY_TMP t1 where  t1.PSDEDATAQUERYID='%1$s'", (Object)strPSDEDataQueryId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAQUERY t1 where t1.PSDEDATAQUERYID='%1$s'", (Object)strPSDEDataQueryId);
    }

    protected String getSQL_getPSDEDataQueryJoins(String strPSDEDataQueryId) {
        if (strPSDEDataQueryId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDQJOIN_TMP t1 where  t1.PSDEDQID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE ", (Object)strPSDEDataQueryId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQJOIN t1 where  t1.PSDEDQID='%1$s'  order by ORDERVALUE ", (Object)strPSDEDataQueryId);
    }

    protected String getSQL_getPSDEDataQueryJoinsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQJOIN t1  inner join t_srfpsdedataquery t2 on t1.PSDEDQID= t2.psdedataqueryid inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataQueryConds(String strPSDEDataQueryId) {
        if (strPSDEDataQueryId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDQCOND_TMP t1 where  t1.PSDEDQID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE ", (Object)strPSDEDataQueryId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQCOND t1 where  t1.PSDEDQID='%1$s' order by ORDERVALUE ", (Object)strPSDEDataQueryId);
    }

    protected String getSQL_getPSDEDataSets(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASET t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEDataSetsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASET t1 inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataSet(String strPSDEDataSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASET t1 where  t1.PSDEDATASETID='%1$s'", (Object)strPSDEDataSetId);
    }

    protected String getSQL_getPSDEDSDQs(String strPSDataSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSDQ t1 where  t1.PSDEDATASETID='%1$s' order by t1.ordervalue ,t1.psdedqname", (Object)strPSDataSetId);
    }

    protected String getSQL_getPSDEDSDQsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSDQ t1  inner join t_srfpsdedataset t2 on t1.PSDEDATASETID=t2.PSDEDATASETID inner join t_srfpsdataentity  t3 on t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ordervalue,t1.psdedqname ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDSGroupParams(String strPSDataSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSGRPPARAM t1 where  t1.PSDEDSID='%1$s' order by t1.SORTORDERVALUE, t1.PSDEDSGRPPARAMNAME ", (Object)strPSDataSetId);
    }

    protected String getSQL_getPSDEDSGroupParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSGRPPARAM t1  inner join t_srfpsdedataset t2 on t1.PSDEDSID=t2.PSDEDATASETID inner join t_srfpsdataentity  t3 on t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.SORTORDERVALUE, t1.PSDEDSGRPPARAMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSF(String strPSSFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSF t1 where  t1.PSSFID='%1$s'", (Object)strPSSFId);
    }

    protected String getSQL_getPSSFStyle(String strPSSFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFStyle t1 where  t1.PSSFStyleID='%1$s'", (Object)strPSSFStyleId);
    }

    protected String getSQL_getPSSFStyleVer(String strPSSFStyleVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFStyleVER t1 where  t1.PSSFStyleVerID='%1$s'", (Object)strPSSFStyleVerId);
    }

    protected String getSQL_getPSSFACHandler(String strPSSFACHandlerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFACHANDLER t1 where  t1.PSSFACHANDLERID='%1$s'", (Object)strPSSFACHandlerId);
    }

    protected String getSQL_getPSSFCodeFolders(String strPSSFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFCODEFOLDER t1 where  t1.PSSFSTYLEID='%1$s' ", (Object)strPSSFStyleId);
    }

    protected String getSQL_getPSSFCodeTempl(String strPSSFCodeTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFCODETEMPL t1 where  t1.PSSFCODETEMPLID='%1$s'", (Object)strPSSFCodeTemplId);
    }

    protected String getSQL_getPSSFCodeTempls(String strPSSFCodeTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFCODETEMPL t1 where  t1.PSSFCODETYPEID='%1$s' ", (Object)strPSSFCodeTypeId);
    }

    protected String getSQL_getPSSFCodeTypes(String strPSSFCodeFolderId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFCODETYPE t1 where  t1.PSSFCODEFOLDERID='%1$s' ", (Object)strPSSFCodeFolderId);
    }

    protected String getSQL_getAllPSDataEntities(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDATAENTITY t1 where  t1.PSSYSTEMID='%1$s' and (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAjaxControlHandlers(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSACHANDLER t1 where  t1.PSDEID IS NULL AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSAjaxControlHandlers(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSACHANDLER t1 where  t1.PSDEID = '%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSACHandlersBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSACHANDLER t1  where  t1.PSSYSTEMID ='%1$s' AND t1.PSDEID IS NOT NULL ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSAjaxControlHandler(String strPSDataEntityId, String strPSAjaxControlHandlerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSACHANDLER t1 where  t1.PSDEID = '%1$s' AND t1.PSACHANDLERID='%2$s'", (Object)strPSDataEntityId, (Object)strPSAjaxControlHandlerId);
    }

    protected String getSQL_getPSDEDataSetCodes(String strPSDEDataSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSCODE t1 where  t1.PSDEDATASETID = '%1$s' ", (Object)strPSDEDataSetId);
    }

    protected String getSQL_getPSDEDataSetCode(String strPSDEDataSetId, String strPSDEDataSetCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSCODE t1 where  t1.PSDEDATASETID = '%1$s' AND t1.PSDEDSCODEID='%2$s'", (Object)strPSDEDataSetId, (Object)strPSDEDataSetCodeId);
    }

    protected String getSQL_getPSDBDevInst(String strPSDBDevInstId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBDEVINST t1 where t1.PSDBDEVINSTID='%1$s' ", (Object)strPSDBDevInstId);
    }

    public CallResult getPSACHandlersBySystem(String strPSSystemId, Vector<PSACHandler> psACHandlerList) {
        return this.selectMulti(this.getSQL_getPSACHandlersBySystem(strPSSystemId), psACHandlerList, PSACHandler.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAjaxControlHandler(String strPSDataEntityId, String strPSAjaxControlHandlerId, PSACHandler psAjaxControlHandler) {
        return this.selectSingle(this.getSQL_getPSAjaxControlHandler(strPSDataEntityId, strPSAjaxControlHandlerId), psAjaxControlHandler, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataSetCodes(String strPSDEDataSetId, Vector<PSDEDataSetCode> psDEDataSetCodeList) {
        return this.selectMulti(this.getSQL_getPSDEDataSetCodes(strPSDEDataSetId), psDEDataSetCodeList, PSDEDataSetCode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataSetCode(String strPSDEDataSetId, String strPSDEDataSetCodeId, PSDEDataSetCode psDEDataSetCode) {
        return this.selectSingle(this.getSQL_getPSDEDataSetCode(strPSDEDataSetId, strPSDEDataSetCodeId), psDEDataSetCode, "SYSTEM");
    }

    @Override
    public CallResult getPSDBDevInst(String strPSDBDevInstId, PSDBDevInst psDBDevInst) {
        return this.selectSingle(this.getSQL_getPSDBDevInst(strPSDBDevInstId), psDBDevInst, "SYSTEM");
    }

    @Override
    public CallResult getPSViewTypeViews(String strPSViewTypeId, Vector<PSViewTypeView> psViewTypeViewList) {
        return this.selectMulti(this.getSQL_getPSViewTypeViews(strPSViewTypeId), psViewTypeViewList, PSViewTypeView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSViewTypeViews(String strPSViewTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVTRV t1 where  t1.PSVIEWTYPEID = '%1$s' ", (Object)strPSViewTypeId);
    }

    @Override
    public CallResult getPSViewTypeCtrls(String strPSViewTypeId, Vector<PSViewTypeCtrl> psViewTypeCtrlList) {
        return this.selectMulti(this.getSQL_getPSViewTypeCtrls(strPSViewTypeId), psViewTypeCtrlList, PSViewTypeCtrl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSViewTypeCtrls(String strPSViewTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVTCTRL t1 where  t1.PSVIEWTYPEID = '%1$s' ", (Object)strPSViewTypeId);
    }

    protected String getSQL_getPSDEViewCtrls(String strPSDEViewId) {
        if (strPSDEViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWCTRL_TMP t1 where  t1.PSDEVIEWBASEID = '%1$s' ", (Object)strPSDEViewId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWCTRL t1 where  t1.PSDEVIEWBASEID = '%1$s' ", (Object)strPSDEViewId);
    }

    public CallResult getPSDEViewCtrlsBySystem(String strPSSystemId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
        return this.selectMulti(this.getSQL_getPSDEViewCtrlsBySystem(strPSSystemId), psDEViewCtrlList, PSDEViewCtrl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEViewCtrlsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWCTRL t1  inner join T_SRFPSDEVIEWBASE t2 on  t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID  where t2.pssystemid = '%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEViewViews(String strPSDEViewId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWRV t1 where  t1.MAJORPSDEVIEWID = '%1$s' ", (Object)strPSDEViewId);
    }

    public CallResult getPSDEViewViewsBySystem(String strPSSystemId, Vector<PSDEViewView> psDEViewViewList) {
        return this.selectMulti(this.getSQL_getPSDEViewViewsBySystem(strPSSystemId), psDEViewViewList, PSDEViewView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEViewViewsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWRV t1  inner join T_SRFPSDEVIEWBASE t2 on t1.MAJORPSDEVIEWID = t2.psdeviewbaseid  where  t2.pssystemid = '%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSAppViewRefs(String strPSAppViewId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPVIEWREF t1 where  t1.MAJORPSAPPVIEWID = '%1$s' ", (Object)strPSAppViewId);
    }

    public CallResult getPSAppViewRefsBySystem(String strPSSystemId, Vector<PSAppViewRef> psAppViewRefList) {
        return this.selectMulti(this.getSQL_getPSAppViewRefsBySystem(strPSSystemId), psAppViewRefList, PSAppViewRef.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSAppViewRefsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPVIEWREF t1  inner join V_SRFPSappview t2 on t2.psappviewid =  t1.MAJORPSAPPVIEWID where t2.pssystemid = '%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEAction(String strPSDEActionId, PSDEAction psDEAction) {
        return this.selectSingle(this.getSQL_getPSDEAction(strPSDEActionId), psDEAction, "SYSTEM");
    }

    protected String getSQL_getPSDEAction(String strPSDEActionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTION t1 where  t1.PSDEACTIONID='%1$s'", (Object)strPSDEActionId);
    }

    @Override
    public CallResult getPSDELogic(String strPSDELogicId, PSDELogic psDELogic) {
        return this.selectSingle(this.getSQL_getPSDELogic(strPSDELogicId), psDELogic, "SYSTEM");
    }

    protected String getSQL_getPSDELogic(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDELOGIC t1 where  t1.PSDELOGICID='%1$s'", (Object)strPSDELogicId);
    }

    public CallResult getPSDEActionsBySystem(String strPSSystemId, Vector<PSDEAction> psDEActionList) {
        return this.selectMulti(this.getSQL_getPSDEActionsBySystem(strPSSystemId), psDEActionList, PSDEAction.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTION t1 inner join t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid  where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionLogics(String strPSDEActionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONLOGIC t1 where  t1.PSDEACTIONID='%1$s' order by t1.ORDERVALUE ", (Object)strPSDEActionId);
    }

    public CallResult getPSDEActionLogicsBySystem(String strPSSystemId, Vector<PSDEActionLogic> psDEActionLogicList) {
        return this.selectMulti(this.getSQL_getPSDEActionLogicsBySystem(strPSSystemId), psDEActionLogicList, PSDEActionLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONLOGIC t1 inner join T_SRFPSDEACTION t2 on t1.PSDEACTIONID= t2.PSDEACTIONID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionParams(String strPSDEActionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONPARAM t1 where  t1.PSDEACTIONID='%1$s' order by t1.ORDERVALUE ", (Object)strPSDEActionId);
    }

    public CallResult getPSDEActionParamsBySystem(String strPSSystemId, Vector<PSDEActionParam> psDEActionParamList) {
        return this.selectMulti(this.getSQL_getPSDEActionParamsBySystem(strPSSystemId), psDEActionParamList, PSDEActionParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONPARAM t1 inner join T_SRFPSDEACTION t2 on t1.PSDEACTIONID= t2.PSDEACTIONID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActions(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEActionType(String strPSDEActionTypeId, PSDEActionType psDEActionType) {
        return this.selectSingle(this.getSQL_getPSDEActionType(strPSDEActionTypeId), psDEActionType, "SYSTEM");
    }

    protected String getSQL_getPSDEActionType(String strPSDEActionTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONTYPE t1 where  t1.PSDEACTIONTYPEID='%1$s'", (Object)strPSDEActionTypeId);
    }

    @Override
    public CallResult getPSDBSPPartTempl(String strPSDBSPPartTemplId, PSDBSPPartTempl psDBSPPartTempl) {
        return this.selectSingle(this.getSQL_getPSDBSPPartTempl(strPSDBSPPartTemplId), psDBSPPartTempl, "SYSTEM");
    }

    protected String getSQL_getPSDBSPPartTempl(String strPSDBSPPartTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDBSPPARTTEMPL t1 where  t1.PSDBSPPARTTEMPLID='%1$s'", (Object)strPSDBSPPartTemplId);
    }

    @Override
    public CallResult getPSDBSysProcTempl(String strPSDBSysProcTemplId, PSDBSysProcTempl psDBSysProcTempl) {
        return this.selectSingle(this.getSQL_getPSDBSysProcTempl(strPSDBSysProcTemplId), psDBSysProcTempl, "SYSTEM");
    }

    protected String getSQL_getPSDBSysProcTempl(String strPSDBSysProcTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDBSYSPROCTEMPL t1 where  t1.PSDBSYSPROCTEMPLID='%1$s'", (Object)strPSDBSysProcTemplId);
    }

    @Override
    public CallResult getPSDEDBSysProcCode(String strPSDEDBSysProcId, PSDEDBSysProcCode psDESysProcCode) {
        return this.selectSingle(this.getSQL_getPSDEDBSysProcCode(strPSDEDBSysProcId), psDESysProcCode, "SYSTEM");
    }

    protected String getSQL_getPSDEDBSysProcCode(String strPSDEDBSysProcId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESPCODE t1 where  t1.PSDESPCODEID='%1$s'", (Object)strPSDEDBSysProcId);
    }

    @Override
    public CallResult getPSDEDBSysProcs(String strPSDataEntityId, Vector<PSDEDBSysProc> psDEDBSysProcList) {
        return this.selectMulti(this.getSQL_getPSDEDBSysProcs(strPSDataEntityId), psDEDBSysProcList, PSDEDBSysProc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDBSysProcs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESYSPROC t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEDBSysProc(String strPSDataEntityId, String strPSDEDBSysProcId, PSDEDBSysProc psDEDBSysProc) {
        return this.selectSingle(this.getSQL_getPSDEDBSysProc(strPSDataEntityId, strPSDEDBSysProcId), psDEDBSysProc, "SYSTEM");
    }

    protected String getSQL_getPSDEDBSysProc(String strPSDataEntityId, String strPSDEDBSysProcId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESYSPROC t1 where t1.PSDEID='%1$s' and t1.PSDESYSPROCID='%2$s'", (Object)strPSDataEntityId, (Object)strPSDEDBSysProcId);
    }

    @Override
    public CallResult getPSDBSysProcParams(String strPSDEDBSysProcCodeId, Vector<PSDBProcParam> psDBProcParamList) {
        return this.selectMulti(this.getSQL_getPSDBSysProcParams(strPSDEDBSysProcCodeId), psDBProcParamList, PSDBProcParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDBSysProcParams(String strPSDEDBSysProcCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBPROCPARAM t1 where  t1.PSDESPCODEID='%1$s' ORDER BY ORDERVALUE", (Object)strPSDEDBSysProcCodeId);
    }

    @Override
    public CallResult getPSPFUIActionTempl(String strPSPFUIActionTemplId, PSPFUIActionTempl psPFUIActionTempl) {
        return this.selectSingle(this.getSQL_getPSPFUIActionTempl(strPSPFUIActionTemplId), psPFUIActionTempl, "SYSTEM");
    }

    protected String getSQL_getPSPFUIActionTempl(String strPSPFUIActionTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFUATEMPL t1 where  t1.PSPFUATEMPLID='%1$s'", (Object)strPSPFUIActionTemplId);
    }

    public CallResult getAllPSCodeLists2(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
        return this.selectMulti(this.getSQL_getAllPSCodeLists(strPSSystemId), psCodeListList, PSCodeList.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSCodeLists(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODELIST t1 where t1.PSSYSTEMID='%1$s' AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSCodeItems(String strPSCodeListId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODEITEM t1 where  t1.PSCODELISTID='%1$s' order by ORDERVALUE,PSCODEITEMNAME", (Object)strPSCodeListId);
    }

    public CallResult getPSCodeItemsBySystem(String strPSSystemId, Vector<PSCodeItem> psCodeItemList) {
        return this.selectMulti(this.getSQL_getPSCodeItemsBySystem(strPSSystemId), psCodeItemList, PSCodeItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSCodeItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODEITEM t1  inner join t_srfpscodelist t2 on t1.pscodelistid=t2.pscodelistid where  t2.PSSYSTEMID='%1$s' AND  ( t2.DYNASYSREFMODE IS NULL  OR  t2.DYNASYSREFMODE <> 2 ) order by ORDERVALUE,PSCODEITEMNAME", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSPFViewLogicTempl(String strPSPFViewLogicTemplId, PSPFViewLogicTempl psPFViewLogicTempl) {
        return this.selectSingle(this.getSQL_getPSPFViewLogicTempl(strPSPFViewLogicTemplId), psPFViewLogicTempl, "SYSTEM");
    }

    protected String getSQL_getPSPFViewLogicTempl(String strPSPFViewLogicTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFVLTEMPL t1 where  t1.PSPFVLTEMPLID='%1$s'", (Object)strPSPFViewLogicTemplId);
    }

    protected String getSQL_getPSAppViewLogics(String strPSAppViewId) {
        return StringHelper.Format((String)"select t2.*,t1.PSAPPVIEWLOGICID,t1.PSAPPVIEWLOGICNAME,t1.PSAPPVIEWID,t1.PUBCODE,t1.USERCODE,t1.INITLOGICMODE,t1.INITORDERVALUE from T_SRFPSAPPVIEWLOGIC t1 LEFT JOIN t_SRFPSDEVIEWLOGIC t2 on t1.PSDEVIEWLOGICID=t2.PSDEVIEWLOGICID  where  t1.PSAPPVIEWID = '%1$s' ORDER BY t1.INITORDERVALUE ", (Object)strPSAppViewId);
    }

    public CallResult getPSAppViewLogicsBySystem(String strPSSystemId, Vector<PSAppViewLogic> psAppViewLogicList) {
        return this.selectMulti(this.getSQL_getPSAppViewLogicsBySystem(strPSSystemId), psAppViewLogicList, PSAppViewLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSAppViewLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t2.*,t1.PSAPPVIEWLOGICID,t1.PSAPPVIEWLOGICNAME,t1.PSAPPVIEWID,t1.PUBCODE,t1.USERCODE,t1.INITLOGICMODE,t1.INITORDERVALUE from T_SRFPSAPPVIEWLOGIC t1 LEFT JOIN t_SRFPSDEVIEWLOGIC t2 on t1.PSDEVIEWLOGICID=t2.PSDEVIEWLOGICID  inner join V_SRFPSAPPVIEW t3 on t3.psappviewid =  t1.PSAPPVIEWID  where t3.pssystemid = '%1$s' ORDER BY t1.INITORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSViewLogicType(String strPSViewLogicTypeId, PSViewLogicType psViewLogicType) {
        return this.selectSingle(this.getSQL_getPSViewLogicType(strPSViewLogicTypeId), psViewLogicType, "SYSTEM");
    }

    protected String getSQL_getPSViewLogicType(String strPSViewLogicTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVIEWLOGICTYPE t1 where  t1.PSVIEWLOGICTYPEID='%1$s'", (Object)strPSViewLogicTypeId);
    }

    protected String getSQL_getPSDEFValueRulesByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFVALUERULE t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where  t2.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEFValueRulesBySystem(String strPSSystemId, Vector<PSDEFValueRule> psDEFValueRuleList) {
        return this.selectMulti(this.getSQL_getPSDEFValueRulesBySystem(strPSSystemId), psDEFValueRuleList, PSDEFValueRule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFValueRulesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.psdeid from T_SRFPSDEFVALUERULE t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID  inner join T_SRFPSDATAENTITY t3 on  t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFValueRuleConds(String strPSDEFValueRuleId) {
        if (strPSDEFValueRuleId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFVRCOND_TMP t1 where  t1.PSDEFVRID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEFValueRuleId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFVRCOND t1 where  t1.PSDEFVRID='%1$s' order by ORDERVALUE", (Object)strPSDEFValueRuleId);
    }

    public CallResult getPSDEFValueRuleCondsBySystem(String strPSSystemId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
        return this.selectMulti(this.getSQL_getPSDEFValueRuleCondsBySystem(strPSSystemId), psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFValueRuleCondsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFVRCOND t1 inner join T_SRFPSDEFVALUERULE t2 on t1.PSDEFVRID= t2.PSDEFVALUERULEID  inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  order by ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEFValueRuleType(String strPSDEFValueRuleTypeId, PSDEFValueRuleType psDEFValueRuleType) {
        return this.selectSingle(this.getSQL_getPSDEFValueRuleType(strPSDEFValueRuleTypeId), psDEFValueRuleType, "SYSTEM");
    }

    protected String getSQL_getPSDEFValueRuleType(String strPSDEFValueRuleTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFVRTYPE t1 where  t1.PSDEFVRTYPEID='%1$s'", (Object)strPSDEFValueRuleTypeId);
    }

    @Override
    public CallResult getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) {
        return this.selectSingle(this.getSQL_getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId), psDEFValueRuleTypeDetail, "SYSTEM");
    }

    protected String getSQL_getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFVRTYPEDETAIL t1 where  t1.PSDEFVRTYPEDETAILID='%1$s'", (Object)strPSDEFValueRuleTypeDetailId);
    }

    @Override
    public CallResult getPSDEACMode(String strPSDEACModeId, PSDEACMode psDEACMode) {
        return this.selectSingle(this.getSQL_getPSDEACMode(strPSDEACModeId), psDEACMode, "SYSTEM");
    }

    protected String getSQL_getPSDEACMode(String strPSDEACModeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACMODE t1 where  t1.PSDEACMODEID='%1$s'", (Object)strPSDEACModeId);
    }

    protected String getSQL_getPSDEACModes(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACMODE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEACModesBySystem(String strPSSystemId, Vector<PSDEACMode> psDEACModeList) {
        return this.selectMulti(this.getSQL_getPSDEACModesBySystem(strPSSystemId), psDEACModeList, PSDEACMode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEACModesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACMODE t1  inner join t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid  where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEACModeItems(String strPSDEACModeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACMODEITEM t1 where  t1.PSDEACMODEID='%1$s'  ", (Object)strPSDEACModeId);
    }

    public CallResult getPSDEACModeItemsBySystem(String strPSSystemId, Vector<PSDEACModeItem> psDEACModeItemList) {
        return this.selectMulti(this.getSQL_getPSDEACModeItemsBySystem(strPSSystemId), psDEACModeItemList, PSDEACModeItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEACModeItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACMODEITEM t1 inner join T_SRFPSDEACMODE t2 on t1.PSDEACMODEID= t2.PSDEACMODEID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDBValueOP(String strPSDBValueOPId, PSDBValueOP psDBValueOP) {
        return this.selectSingle(this.getSQL_getPSDBValueOP(strPSDBValueOPId), psDBValueOP, "SYSTEM");
    }

    protected String getSQL_getPSDBValueOP(String strPSDBValueOPId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBVALUEOP t1 where  t1.PSDBVALUEOPID='%1$s'", (Object)strPSDBValueOPId);
    }

    protected String getSQL_getPSDEDRGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDRGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEDRGroupsBySystem(String strPSSystemId, Vector<PSDEDRGroup> psDEDRGroupList) {
        return this.selectMulti(this.getSQL_getPSDEDRGroupsBySystem(strPSSystemId), psDEDRGroupList, PSDEDRGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDRGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDRGROUP t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDRItemType(String strPSDRItemTypeId, PSDRItemType psDRItemType) {
        return this.selectSingle(this.getSQL_getPSDRItemType(strPSDRItemTypeId), psDRItemType, "SYSTEM");
    }

    protected String getSQL_getPSDRItemType(String strPSDRItemTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDRITEMTYPE t1 where  t1.PSDRITEMTYPEID='%1$s'", (Object)strPSDRItemTypeId);
    }

    protected String getSQL_getPSDEDRItems(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDRITEM t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEDRItemsBySystem(String strPSSystemId, Vector<PSDEDRItem> psDEDRItemList) {
        return this.selectMulti(this.getSQL_getPSDEDRItemsBySystem(strPSSystemId), psDEDRItemList, PSDEDRItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDRItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDRITEM t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDRDetails(String strPSDEDRId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDRDETAIL t1 where  t1.PSDEDRID='%1$s' order by ORDERVALUE", (Object)strPSDEDRId);
    }

    public CallResult getPSDEDRDetailsBySystem(String strPSSystemId, Vector<PSDEDRDetail> psDEDRDetailList) {
        return this.selectMulti(this.getSQL_getPSDEDRDetailsBySystem(strPSSystemId), psDEDRDetailList, PSDEDRDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDRDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEDRDETAIL t1  inner join T_SRFPSDEDATARELATION t2 on t1.PSDEDRID= t2.PSDEDATARELATIONID inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  order by ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getAllPSAppMenus2(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
        return this.selectMulti(this.getSQL_getAllPSAppMenus(strPSApplicationId), psAppMenus, PSAppMenu.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppMenus(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENU t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppMenu(String strPSAppMenuId) {
        if (strPSAppMenuId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPMENU_TMP t1 where  t1.PSAPPMENUID='%1$s' ", (Object)strPSAppMenuId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENU t1 where  t1.PSAPPMENUID='%1$s'", (Object)strPSAppMenuId);
    }

    protected String getSQL_getPSDEGrid(String strPSDEGridId) {
        if (strPSDEGridId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEGRID_TMP t1 where  t1.PSDEGRIDID='%1$s'", (Object)strPSDEGridId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGRID t1 where  t1.PSDEGRIDID='%1$s'", (Object)strPSDEGridId);
    }

    protected String getSQL_getPSDEChart(String strPSDEChartId) {
        if (strPSDEChartId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDECHART_TMP t1 where  t1.PSDECHARTID='%1$s'", (Object)strPSDEChartId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHART t1 where  t1.PSDECHARTID='%1$s'", (Object)strPSDEChartId);
    }

    protected String getSQL_getPSDEReport(String strPSDEReportId) {
        if (strPSDEReportId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEREPORT_TMP t1 where  t1.PSDEREPORTID='%1$s'", (Object)strPSDEReportId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEREPORT t1 where  t1.PSDEREPORTID='%1$s'", (Object)strPSDEReportId);
    }

    protected String getSQL_getPSDEToolbar(String strPSDEToolbarId) {
        if (strPSDEToolbarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETOOLBAR_TMP t1 where  t1.PSDETOOLBARID='%1$s'", (Object)strPSDEToolbarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETOOLBAR t1 where  t1.PSDETOOLBARID='%1$s'", (Object)strPSDEToolbarId);
    }

    protected String getSQL_getPSDEForm(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFORM_TMP t1 where  t1.PSDEFORMID='%1$s'", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORM t1 where  t1.PSDEFORMID='%1$s'", (Object)strPSDEFormId);
    }

    public CallResult getPSDEDataRelationsBySystem(String strPSSystemId, Vector<PSDEDataRelation> psDEDataRelationList) {
        return this.selectMulti(this.getSQL_getPSDEDataRelationsBySystem(strPSSystemId), psDEDataRelationList, PSDEDataRelation.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataRelationsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATARELATION t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    public CallResult getAllPSDERs2(String strPSSystemId, Vector<PSDER> psDataEntityList) {
        return this.selectMulti(this.getSQL_getAllPSDERs(strPSSystemId), psDataEntityList, PSDER.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataRelations(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATARELATION t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    protected String getSQL_getAllPSDERs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDER t1 where  t1.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ORDER BY t1.PSDERNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataQueryCodes(String strPSDEDataQueryId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQCODE t1 where  t1.PSDEDQID = '%1$s' ORDER BY t1.DBTYPE ", (Object)strPSDEDataQueryId);
    }

    public CallResult getPSDEDataQueryCodesBySystem(String strPSSystemId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodesBySystem(strPSSystemId), psDEDataQueryCodeList, PSDEDataQueryCode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataQueryCodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQCODE t1  inner join t_srfpsdedataquery t2 on t1.PSDEDQID = t2.psdedataqueryid  inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID = '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.DBTYPE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDataQueryCode(String strPSDEDataQueryId, String strPSDEDataQueryCodeId, PSDEDataQueryCode psDEDataQueryCode) {
        return this.selectSingle(this.getSQL_getPSDEDataQueryCode(strPSDEDataQueryId, strPSDEDataQueryCodeId), psDEDataQueryCode, "SYSTEM");
    }

    protected String getSQL_getPSDEDataQueryCode(String strPSDEDataQueryId, String strPSDEDataQueryCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQCODE t1 where  t1.PSDEDQID = '%1$s' AND t1.PSDEDQCODEID='%2$s' ORDER BY t1.DBTYPE", (Object)strPSDEDataQueryId, (Object)strPSDEDataQueryCodeId);
    }

    protected String getSQL_getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEDQCODEEXP t1 where  t1.PSDEDQCODEID = '%1$s' order by t1.ordervalue,t1.PSDEDQCODEEXPNAME  ", (Object)strPSDEDataQueryCodeId);
    }

    public CallResult getPSDEDataQueryCodeExpsBySystem(String strPSSystemId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeExpsBySystem(strPSSystemId), psDEDataQueryCodeExpList, PSDEDataQueryCodeExp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataQueryCodeExpsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.PSDEDQCODEEXPID,t1.PSDEDQCODEEXPNAME,t1.PSDEDQCODEID,t1.MEMO,t1.EXPCODE,t1.ORDERVALUE from T_SRFPSDEDQCODEEXP t1  inner join t_SRFPSDEDQCODE t2 on t1.PSDEDQCODEID = t2.PSDEDQCODEID  inner join t_srfpsdedataquery t3 on t2.PSDEDQID = t3.psdedataqueryid  inner join t_srfpsdataentity t4 on t3.psdeid = t4.psdataentityid  where  t4.PSSYSTEMID = '%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0)  order by t1.ordervalue,t1.PSDEDQCODEEXPNAME  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSystemModule(String strPSSystemModuleId, PSSystemModule psSystemModule) {
        return this.selectSingle(this.getSQL_getPSSystemModule(strPSSystemModuleId), psSystemModule, "SYSTEM");
    }

    protected String getSQL_getPSSystemModule(String strPSSystemModuleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODULE t1 where t1.PSMODULEID='%1$s' ", (Object)strPSSystemModuleId);
    }

    @Override
    public CallResult getPSDBSysProcType(String strPSDBSysProcTypeId, PSDBSysProcType psDBSysProcType) {
        return this.selectSingle(this.getSQL_getPSDBSysProcType(strPSDBSysProcTypeId), psDBSysProcType, "SYSTEM");
    }

    protected String getSQL_getPSDBSysProcType(String strPSDBSysProcTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBSYSPROCTYPE t1 where  t1.PSDBSYSPROCTYPEID='%1$s'", (Object)strPSDBSysProcTypeId);
    }

    @Override
    public CallResult getPSFDLogicType(String strPSFDLogicTypeId, PSFDLogicType psFDLogicType) {
        return this.selectSingle(this.getSQL_getPSFDLogicType(strPSFDLogicTypeId), psFDLogicType, "SYSTEM");
    }

    protected String getSQL_getPSFDLogicType(String strPSFDLogicTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSFDLOGICTYPE t1 where  t1.PSFDLOGICTYPEID='%1$s'", (Object)strPSFDLogicTypeId);
    }

    protected String getSQL_getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEDQCODECOND t1 where  t1.PSDEDQCODEID = '%1$s' order by t1.ordervalue  ", (Object)strPSDEDataQueryCodeId);
    }

    public CallResult getPSDEDataQueryCodeCondsBySystem(String strPSSystemId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeCondsSystem(strPSSystemId), psDEDataQueryCodeCondList, PSDEDataQueryCodeCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataQueryCodeCondsSystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEDQCODECOND t1  inner join t_SRFPSDEDQCODE t2 on t1.PSDEDQCODEID = t2.PSDEDQCODEID  inner join t_srfpsdedataquery t3 on t2.PSDEDQID = t3.psdedataqueryid  inner join t_srfpsdataentity t4 on t3.psdeid = t4.psdataentityid  where  t4.PSSYSTEMID = '%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ordervalue  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSPFAppTempl(String strPSPFAppTemplId, PSPFAppTempl psPFAppTempl) {
        return this.selectSingle(this.getSQL_getPSPFAppTempl(strPSPFAppTemplId), psPFAppTempl, "SYSTEM");
    }

    protected String getSQL_getPSPFAppTempl(String strPSPFAppTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFAPPTEMPL t1 where  t1.PSPFAPPTEMPLID='%1$s'", (Object)strPSPFAppTemplId);
    }

    protected String getSQL_getPSDEDataViewItems(String strPSDEDataViewId) {
        if (strPSDEDataViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDELISTITEM_TMP t1 where  t1.PSDEDATAVIEWID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE", (Object)strPSDEDataViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTITEM t1 where  t1.PSDEDATAVIEWID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEDataViewId);
    }

    public CallResult getPSDEDataViewsBySystem(String strPSSystemId, Vector<PSDEDataView> psDEDataViewDataView) {
        return this.selectMulti(this.getSQL_getPSDEDataViewsBySystem(strPSSystemId), psDEDataViewDataView, PSDEDataView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataViewsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAVIEW t1 inner join t_srfpsdataentity t2 on t1.psdeid=t2.psdataentityid where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    public CallResult getPSDEDataViewItemsBySystem(String strPSSystemId, Vector<PSDEDataViewItem> psDEDataViewItemDataView) {
        return this.selectMulti(this.getSQL_getPSDEDataViewItemsBySystem(strPSSystemId), psDEDataViewItemDataView, PSDEDataViewItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataViewItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTITEM t1  inner join t_SRFPSDEDATAVIEW t2 on t1.PSDEDATAVIEWID=t2.PSDEDATAVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEUIActionGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEUIActionGroupsBySystem(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSDEUIActionGroupsBySystem(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUIActionGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where t1.PSSYSTEMID='%1$s' AND t1.PSDEID IS NOT NULL  AND t1.PSWFID IS  NULL", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGRPDETAIL t1 where  t1.PSDEUAGROUPID='%1$s' order by ORDERVALUE", (Object)strPSDEUIActionGroupId);
    }

    public CallResult getPSDEUIActionGroupDetailsBySystem(String strPSSystemId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEUIActionGroupDetailsBySystem(strPSSystemId), psDEUIActionGroupDetailList, PSDEUIActionGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUIActionGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGRPDETAIL t1 INNER JOIN T_SRFPSDEUAGROUP t2 on t1.PSDEUAGROUPID = t2.PSDEUAGROUPID  where  t2.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDELogicNodeType(String strPSDELogicNodeTypeId, PSDELogicNodeType psDELogicNodeType) {
        return this.selectSingle(this.getSQL_getPSDELogicNodeType(strPSDELogicNodeTypeId), psDELogicNodeType, "SYSTEM");
    }

    protected String getSQL_getPSDELogicNodeType(String strPSDELogicNodeTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELNTYPE t1 where  t1.PSDELNTYPEID='%1$s'", (Object)strPSDELogicNodeTypeId);
    }

    @Override
    public CallResult getPSDELogicLinkType(String strPSDELogicLinkTypeId, PSDELogicLinkType psDELogicLinkType) {
        return this.selectSingle(this.getSQL_getPSDELogicLinkType(strPSDELogicLinkTypeId), psDELogicLinkType, "SYSTEM");
    }

    protected String getSQL_getPSDELogicLinkType(String strPSDELogicLinkTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELLTYPE t1 where  t1.PSDELLTYPEID='%1$s'", (Object)strPSDELogicLinkTypeId);
    }

    @Override
    public CallResult getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId, PSDELogicLinkCondType psDELogicLinkCondType) {
        return this.selectSingle(this.getSQL_getPSDELogicLinkCondType(strPSDELogicLinkCondTypeId), psDELogicLinkCondType, "SYSTEM");
    }

    protected String getSQL_getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDELLCONDTYPE t1 where  t1.PSDELLCONDTYPEID='%1$s'", (Object)strPSDELogicLinkCondTypeId);
    }

    protected String getSQL_getPSDELogicLinks(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICLINK t1 where  t1.PSDELOGICID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDELogicId);
    }

    public CallResult getPSDELogicLinksBySystem(String strPSSystemId, Vector<PSDELogicLink> psDELogicLinkList) {
        return this.selectMulti(this.getSQL_getPSDELogicLinksBySystem(strPSSystemId), psDELogicLinkList, PSDELogicLink.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicLinksBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICLINK t1 inner join T_SRFPSDELOGIC t2 on t1.PSDELOGICID= t2.PSDELOGICID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDELogicLinkConds(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELLCOND t1  inner join T_SRFPSDELOGICLINK t2 on t1.PSDELOGICLINKID = t2.PSDELOGICLINKID where t2.PSDELOGICID = '%1$s' order by t1.ORDERVALUE ", (Object)strPSDELogicId);
    }

    public CallResult getPSDELogicLinkCondsBySystem(String strPSSystemId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
        return this.selectMulti(this.getSQL_getPSDELogicLinkCondsBySystem(strPSSystemId), psDELogicLinkCondList, PSDELogicLinkCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicLinkCondsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELLCOND  t1  inner join T_SRFPSDELOGICLINK  t2 on t1.PSDELOGICLINKID = t2.PSDELOGICLINKID  inner join T_SRFPSDELOGIC t3 on t2.PSDELOGICID= t3.PSDELOGICID inner join T_SRFPSDATAENTITY t4 on t3.PSDEID = t4.PSDATAENTITYID  where t4.PSSYSTEMID= '%1$s' and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE, t1.PSDELLCONDNAME  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDELogics(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGIC t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDELogicsBySystem(String strPSSystemId, Vector<PSDELogic> psDELogicList) {
        return this.selectMulti(this.getSQL_getPSDELogicsBySystem(strPSSystemId), psDELogicList, PSDELogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGIC t1  inner join t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid  where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDELogicNodeParams(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELNPARAM  t1  inner join T_SRFPSDELOGICNODE  t2 on t1.PSDELOGICNODEID = t2.PSDELOGICNODEID where t2.PSDELOGICID = '%1$s' order by t1.ORDERVALUE,t1.PSDELNPARAMNAME ", (Object)strPSDELogicId);
    }

    public CallResult getPSDELogicNodeParamsBySystem(String strPSSystemId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
        return this.selectMulti(this.getSQL_getPSDELogicNodeParamsBySystem(strPSSystemId), psDELogicNodeParamList, PSDELogicNodeParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicNodeParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELNPARAM  t1  inner join T_SRFPSDELOGICNODE  t2 on t1.PSDELOGICNODEID = t2.PSDELOGICNODEID  inner join T_SRFPSDELOGIC t3 on t2.PSDELOGICID= t3.PSDELOGICID inner join T_SRFPSDATAENTITY t4 on t3.PSDEID = t4.PSDATAENTITYID  where t4.PSSYSTEMID= '%1$s' and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ,t1.PSDELNPARAMNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDELogicParams(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICPARAM t1 where  t1.PSDELOGICID='%1$s' ", (Object)strPSDELogicId);
    }

    public CallResult getPSDELogicParamsBySystem(String strPSSystemId, Vector<PSDELogicParam> psDELogicParamList) {
        return this.selectMulti(this.getSQL_getPSDELogicParamsBySystem(strPSSystemId), psDELogicParamList, PSDELogicParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICPARAM t1 inner join T_SRFPSDELOGIC t2 on t1.PSDELOGICID= t2.PSDELOGICID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEPredefinedViews(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEID='%1$s' and t1.PREDEFINEVIEWTYPE IS NOT NULL", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEPredefinedViewsBySystem(String strPSSystemId, Vector<PSDEViewBase> psDEViewBaseList) {
        return this.selectMulti(this.getSQL_getPSDEPredefinedViewsBySystem(strPSSystemId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getPSDEPredefinedViewsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 inner join T_SRFPSDATAENTITY t2 on  t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  and t1.PREDEFINEVIEWTYPE IS NOT NULL", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEViews(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEViewsBySystem(String strPSSystemId, Vector<PSDEViewBase> psDEViewBaseList) {
        return this.selectMulti(this.getSQL_getPSDEViewsBySystem(strPSSystemId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getPSDEViewsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 inner join T_SRFPSDATAENTITY t2 on  t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEEditForms(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFORM t1 where t1.FORMTYPE = 'EDITFORM' AND  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEEditFormsBySystem(String strPSSystemId, Vector<PSDEForm> psDEEditFormList) {
        return this.selectMulti(this.getSQL_getPSDEEditFormsBySystem(strPSSystemId), psDEEditFormList, PSDEForm.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getPSDEEditFormsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFORM t1 inner join T_SRFPSDATAENTITY t2 on  t1.psdeid = t2.psdataentityid where t1.FORMTYPE = 'EDITFORM' AND t2.PSSYSTEMID='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFIUpdates(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFIUPDATE_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIUPDATE t1 where  t1.PSDEFORMID='%1$s' ", (Object)strPSDEFormId);
    }

    public CallResult getPSDEFIUpdatesBySystem(String strPSSystemId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
        return this.selectMulti(this.getSQL_getPSDEFIUpdatesBySystem(strPSSystemId), psDEFIUpdateList, PSDEFIUpdate.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFIUpdatesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIUPDATE t1  inner join  t_srfpsdeform t2 on t1.psdeformid = t2.psdeformid inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFIUDetails(String strPSDEFormId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIUDETAIL t1  where t1.PSDEFORMID='%1$s' ", (Object)strPSDEFormId);
    }

    public CallResult getPSDEFIUDetailsBySystem(String strPSSystemId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
        return this.selectMulti(this.getSQL_getPSDEFIUDetailsBySystem(strPSSystemId), psDEFIUDetailList, PSDEFIUDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFIUDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIUDETAIL t1 inner join  t_srfpsdeform t2 on t1.psdeformid = t2.psdeformid inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFormRFs(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFORMRF_TMP t1 where  t1.MAJORPSDEFORMID='%1$s' AND  t1.srfdraftflag = 0", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORMRF t1 where  t1.MAJORPSDEFORMID='%1$s' ", (Object)strPSDEFormId);
    }

    public CallResult getPSDEFormRFsBySystem(String strPSSystemId, Vector<PSDEFormRF> psDEFormRFList) {
        return this.selectMulti(this.getSQL_getPSDEFormRFsBySystem(strPSSystemId), psDEFormRFList, PSDEFormRF.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFormRFsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORMRF t1 inner join t_srfpsdeform t2 on t2.psdeformid =   t1.MAJORPSDEFORMID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFormItemVRs(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFIVR_TMP t1 where  t1.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIVR t1 where  t1.PSDEFORMID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    public CallResult getPSDEFormItemVRsBySystem(String strPSSystemId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
        return this.selectMulti(this.getSQL_getPSDEFormItemVRsBySystem(strPSSystemId), psDEFormItemVRList, PSDEFormItemVR.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFormItemVRsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFIVR t1 inner join t_srfpsdeform t2 on t2.psdeformid =   t1.PSDEFORMID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEMap(String strPSDEMapId, PSDEMap psDEMap) {
        return this.selectSingle(this.getSQL_getPSDEMap(strPSDEMapId), psDEMap, "SYSTEM");
    }

    protected String getSQL_getPSDEMap(String strPSDEMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAP t1 where  t1.PSDEMAPID='%1$s'", (Object)strPSDEMapId);
    }

    protected String getSQL_getPSDEMaps(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEMapsBySystem(String strPSSystemId, Vector<PSDEMap> psDEMapList) {
        return this.selectMulti(this.getSQL_getPSDEMapsBySystem(strPSSystemId), psDEMapList, PSDEMap.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMapsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAP t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMapDetails(String strPSDEMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAPDETAIL t1 where  t1.PSDEMAPID='%1$s' ", (Object)strPSDEMapId);
    }

    public CallResult getPSDEMapDetailsBySystem(String strPSSystemId, Vector<PSDEMapDetail> psDEMapDetailList) {
        return this.selectMulti(this.getSQL_getPSDEMapDetailsBySystem(strPSSystemId), psDEMapDetailList, PSDEMapDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMapDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEMAPDETAIL  t1 inner join T_SRFPSDEMAP t2 on t1.PSDEMAPID= t2.PSDEMAPID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMapActions(String strPSDEMapId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEMAPACTION t1 where  t1.PSDEMAPID='%1$s' ", (Object)strPSDEMapId);
    }

    public CallResult getPSDEMapActionsBySystem(String strPSSystemId, Vector<PSDEMapAction> psDEMapActionList) {
        return this.selectMulti(this.getSQL_getPSDEMapActionsBySystem(strPSSystemId), psDEMapActionList, PSDEMapAction.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMapActionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEMAPACTION  t1 inner join T_SRFPSDEMAP t2 on t1.PSDEMAPID= t2.PSDEMAPID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMapDataQuerys(String strPSDEMapId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEMAPDQ t1 where  t1.PSDEMAPID='%1$s' ", (Object)strPSDEMapId);
    }

    public CallResult getPSDEMapDataQueriesBySystem(String strPSSystemId, Vector<PSDEMapDataQuery> psDEMapDataQueryList) {
        return this.selectMulti(this.getSQL_getPSDEMapDataQueriesBySystem(strPSSystemId), psDEMapDataQueryList, PSDEMapDataQuery.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMapDataQueriesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEMAPDQ  t1 inner join T_SRFPSDEMAP t2 on t1.PSDEMAPID= t2.PSDEMAPID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMapDataSets(String strPSDEMapId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEMAPDS t1 where  t1.PSDEMAPID='%1$s' ", (Object)strPSDEMapId);
    }

    public CallResult getPSDEMapDataSetsBySystem(String strPSSystemId, Vector<PSDEMapDataSet> psDEMapDataSetList) {
        return this.selectMulti(this.getSQL_getPSDEMapDataSetsBySystem(strPSSystemId), psDEMapDataSetList, PSDEMapDataSet.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMapDataSetsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEMAPDS  t1 inner join T_SRFPSDEMAP t2 on t1.PSDEMAPID= t2.PSDEMAPID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysRef(String strPSSysRefId, PSSysRef psSysRef) {
        return this.selectSingle(this.getSQL_getPSSysRef(strPSSysRefId), psSysRef, "SYSTEM");
    }

    protected String getSQL_getPSSysRef(String strPSSysRefId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSREF t1 where t1.PSSYSREFID='%1$s' ", (Object)strPSSysRefId);
    }

    @Override
    public CallResult getPSSysRefDEs(String strPSSysRefId, Vector<PSSysRefDE> psSysRefDEList) {
        return this.selectMulti(this.getSQL_getPSSysRefDEs(strPSSysRefId), psSysRefDEList, PSSysRefDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysRefDEs(String strPSSysRefId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSREFDE t1 where  t1.PSSYSREFID='%1$s' ", (Object)strPSSysRefId);
    }

    public CallResult getAllPSWorkflows2(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
        return this.selectMulti(this.getSQL_getAllPSWorkflows(strPSSystemId), psWorkflowList, PSWorkflow.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSWorkflows(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWORKFLOW t1 where t1.PSSYSTEMID='%1$s' AND t1.ENABLE=1 AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0)", (Object)strPSSystemId);
    }

    protected String getSQL_getPSVersions(String strPSWFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFVERSION t1 where t1.PSWFID='%1$s'  AND t1.ENABLE=1 AND  ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 ) ORDER BY t1.WFVERSION", (Object)strPSWFId);
    }

    public CallResult getPSWFVersionsBySystem(String strPSSystemId, Vector<PSWFVersion> psVersionList) {
        return this.selectMulti(this.getSQL_getPSVersionsBySystem(strPSSystemId), psVersionList, PSWFVersion.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSVersionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFVERSION t1 INNER JOIN T_SRFPSWORKFLOW t2 on t1.PSWFID = t2.PSWORKFLOWID where t2.PSSYSTEMID='%1$s'  AND t1.ENABLE=1 AND ( t1.DYNASYSREFMODE IS NULL  OR  t1.DYNASYSREFMODE <> 2 ) AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ORDER BY t1.WFVERSION", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFProcesses(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFPROCESS t1 where t1.PSWFVERSIONID='%1$s'  AND t1.ENABLE=1 ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFProcessesBySystem(String strPSSystemId, Vector<PSWFProcess> psProcessList) {
        return this.selectMulti(this.getSQL_getPSWFProcessesBySystem(strPSSystemId), psProcessList, PSWFProcess.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFProcessesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFPROCESS t1   INNER JOIN T_SRFPSWFVERSION t2 on t1.PSWFVERSIONID = t2.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t3 on t2.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s' AND t1.ENABLE=1 AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND ( t2.DYNASYSREFMODE IS NULL  OR  t2.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFLinks(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFLINK t1 where t1.PSWFVERSIONID='%1$s' AND t1.ENABLE=1 ORDER BY t1.ORDERVALUE ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFLinksBySystem(String strPSSystemId, Vector<PSWFLink> psLinkList) {
        return this.selectMulti(this.getSQL_getPSWFLinksBySystem(strPSSystemId), psLinkList, PSWFLink.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFLinksBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFLINK t1   INNER JOIN T_SRFPSWFVERSION t2 on t1.PSWFVERSIONID = t2.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t3 on t2.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s'  AND t1.ENABLE=1 AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t2.DYNASYSREFMODE IS NULL  OR  t2.DYNASYSREFMODE <> 2 )  ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFLinkConds(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFLINKCOND t1 inner join T_SRFPSWFLINK t2 on t1.PSWFLINKID = t2.PSWFLINKID  where t2.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFLinkCondsBySystem(String strPSSystemId, Vector<PSWFLinkCond> psLinkCondList) {
        return this.selectMulti(this.getSQL_getPSWFLinkCondsBySystem(strPSSystemId), psLinkCondList, PSWFLinkCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFLinkCondsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSWFVERSIONID from T_SRFPSWFLINKCOND t1  inner join T_SRFPSWFLINK t2 on t1.PSWFLINKID = t2.PSWFLINKID   INNER JOIN T_SRFPSWFVERSION t3 on t2.PSWFVERSIONID = t3.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t4 on t3.PSWFID = t4.PSWORKFLOWID     where t4.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t3.DYNASYSREFMODE IS NULL  OR  t3.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFProcParams(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFPROCPARAM t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFProcParamsBySystem(String strPSSystemId, Vector<PSWFProcParam> psProcParamList) {
        return this.selectMulti(this.getSQL_getPSWFProcParamsBySystem(strPSSystemId), psProcParamList, PSWFProcParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFProcParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSWFVERSIONID from T_SRFPSWFPROCPARAM t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   INNER JOIN T_SRFPSWFVERSION t3 on t2.PSWFVERSIONID = t3.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t4 on t3.PSWFID = t4.PSWORKFLOWID     where t4.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t3.DYNASYSREFMODE IS NULL  OR  t3.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFProcSubWFs(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFPROCSUBWF t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFProcSubWFsBySystem(String strPSSystemId, Vector<PSWFProcSubWF> psProcSubWFList) {
        return this.selectMulti(this.getSQL_getPSWFProcSubWFsBySystem(strPSSystemId), psProcSubWFList, PSWFProcSubWF.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFProcSubWFsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSWFVERSIONID from V_SRFPSWFPROCSUBWF t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID    INNER JOIN T_SRFPSWFVERSION t3 on t2.PSWFVERSIONID = t3.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t4 on t3.PSWFID = t4.PSWORKFLOWID     where t4.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND ( t3.DYNASYSREFMODE IS NULL  OR  t3.DYNASYSREFMODE <> 2 )  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSProcRoles(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFPROCROLE t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    protected String getSQL_getPSLinkRoles(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFLINKROLE t1  left join T_SRFPSWFLINK t2 on t1.PSWFLINKID = t2.PSWFLINKID   where t2.PSWFVERSIONID = '%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFProcRolesBySystem(String strPSSystemId, Vector<PSWFProcRole> psProcRoleList) {
        return this.selectMulti(this.getSQL_getPSProcRolesBySystem(strPSSystemId), psProcRoleList, PSWFProcRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSProcRolesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSWFVERSIONID from T_SRFPSWFPROCROLE t1  left join T_SRFPSWFPROCESS t2 on t1.PSWFPROCESSID = t2.PSWFPROCESSID    INNER JOIN T_SRFPSWFVERSION t3 on t2.PSWFVERSIONID = t3.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t4 on t3.PSWFID = t4.PSWORKFLOWID     where t4.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t3.DYNASYSREFMODE IS NULL  OR  t3.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    public CallResult getPSWFLinkRolesBySystem(String strPSSystemId, Vector<PSWFLinkRole> psLinkRoleList) {
        return this.selectMulti(this.getSQL_getPSLinkRolesBySystem(strPSSystemId), psLinkRoleList, PSWFLinkRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSLinkRolesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSWFVERSIONID from T_SRFPSWFLINKROLE t1  left join T_SRFPSWFLINK t2 on t1.PSWFLINKID = t2.PSWFLINKID    INNER JOIN T_SRFPSWFVERSION t3 on t2.PSWFVERSIONID = t3.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t4 on t3.PSWFID = t4.PSWORKFLOWID     where t4.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t3.DYNASYSREFMODE IS NULL  OR  t3.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSWFProcessType(String strPSWFProcessTypeId, PSWFProcessType psWFProcessType) {
        return this.selectSingle(this.getSQL_getPSWFProcessType(strPSWFProcessTypeId), psWFProcessType, "SYSTEM");
    }

    protected String getSQL_getPSWFProcessType(String strPSWFProcessTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFPROCESSTYPE t1 where  t1.PSWFPROCESSTYPEID='%1$s'", (Object)strPSWFProcessTypeId);
    }

    @Override
    public CallResult getPSWFLinkType(String strPSWFLinkTypeId, PSWFLinkType psWFLinkType) {
        return this.selectSingle(this.getSQL_getPSWFLinkType(strPSWFLinkTypeId), psWFLinkType, "SYSTEM");
    }

    protected String getSQL_getPSWFLinkType(String strPSWFLinkTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFLINKTYPE t1 where  t1.PSWFLINKTYPEID='%1$s'", (Object)strPSWFLinkTypeId);
    }

    @Override
    public CallResult getPSWFLinkCondType(String strPSWFLinkCondTypeId, PSWFLinkCondType psWFLinkCondType) {
        return this.selectSingle(this.getSQL_getPSWFLinkCondType(strPSWFLinkCondTypeId), psWFLinkCondType, "SYSTEM");
    }

    protected String getSQL_getPSWFLinkCondType(String strPSWFLinkCondTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFLINKCONDTYPE t1 where  t1.PSWFLINKCONDTYPEID='%1$s'", (Object)strPSWFLinkCondTypeId);
    }

    protected String getSQL_getPSWFDEs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFDE t1 where  t1.PSDEID='%1$s' AND t1.ENABLE=1 ", (Object)strPSDataEntityId);
    }

    public CallResult getPSWFDEsBySystem(String strPSSystemId, Vector<PSWFDE> psWFDEList) {
        return this.selectMulti(this.getSQL_getPSWFDEsBySystem(strPSSystemId), psWFDEList, PSWFDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFDEsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFDE t1  inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.ENABLE=1", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFDEsByWF(String strPSWFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWFDE t1 where  t1.PSWFID='%1$s' AND t1.ENABLE=1", (Object)strPSWFId);
    }

    protected String getSQL_getPSWFUIActions(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFUIActionsBySystem(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSWFUIActionsBySystem(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFUIActionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1   INNER JOIN T_SRFPSWFVERSION t2 on t1.PSWFVERSIONID = t2.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t3 on t2.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t2.DYNASYSREFMODE IS NULL  OR  t2.DYNASYSREFMODE <> 2 ) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFUIActions2(String strPSWorkflowId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1 where  t1.PSWFID='%1$s' AND t1.PSWFVERSIONID IS NULL", (Object)strPSWorkflowId);
    }

    public CallResult getPSWFUIActions2BySystem(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSWFUIActions2BySystem(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFUIActions2BySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUIACTION t1   INNER JOIN T_SRFPSWORKFLOW t3 on t1.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s' AND t1.PSWFVERSIONID IS NULL AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFUIActionGroups(String strPSWFVersionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSWFVERSIONID='%1$s' ", (Object)strPSWFVersionId);
    }

    public CallResult getPSWFUIActionGroupsBySystem(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSWFUIActionGroupsBySystem(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFUIActionGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1   INNER JOIN T_SRFPSWFVERSION t2 on t1.PSWFVERSIONID = t2.PSWFVERSIONID  INNER JOIN T_SRFPSWORKFLOW t3 on t2.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s' AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) AND  ( t2.DYNASYSREFMODE IS NULL  OR  t2.DYNASYSREFMODE <> 2 )", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWFUIActionGroups2(String strPSWorkflowId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSWFID = '%1$s' AND t1.PSWFVERSIONID IS NULL ", (Object)strPSWorkflowId);
    }

    public CallResult getPSWFUIActionGroups2BySystem(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSWFUIActionGroups2BySystem(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWFUIActionGroups2BySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1   INNER JOIN T_SRFPSWORKFLOW t3 on t1.PSWFID = t3.PSWORKFLOWID     where t3.PSSYSTEMID='%1$s' AND t1.PSWFVERSIONID IS NULL AND (t1.DYNAMODELFLAG IS NULL OR t1.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSWFRoles(String strPSSystemId, Vector<PSWFRole> psWFRoleList) {
        return this.selectMulti(this.getSQL_getAllPSWFRoles(strPSSystemId), psWFRoleList, PSWFRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSWFRoles(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFROLE t1 where t1.PSSYSTEMID='%1$s' AND t1.ENABLE=1 ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSWFWorkTimes(String strPSSystemId, Vector<PSWFWorkTime> psWFWorkTimeList) {
        return this.selectMulti(this.getSQL_getAllPSWFWorkTimes(strPSSystemId), psWFWorkTimeList, PSWFWorkTime.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSWFWorkTimes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFWORKTIME t1 where t1.PSSYSTEMID='%1$s' AND t1.ENABLE=1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEViewBase(String strPSDEViewBaseId) {
        if (strPSDEViewBaseId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE_TMP t1 where  t1.PSDEVIEWBASEID='%1$s'", (Object)strPSDEViewBaseId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVIEWBASE t1 where  t1.PSDEVIEWBASEID='%1$s'", (Object)strPSDEViewBaseId);
    }

    @Override
    public CallResult getPSSysDevBTType(String strPSSysDevBTTypeId, PSSysDevBTType psSysDevBTType) {
        return this.selectSingle(this.getSQL_getPSSysDevBTType(strPSSysDevBTTypeId), psSysDevBTType, "SYSTEM");
    }

    protected String getSQL_getPSSysDevBTType(String strPSSysDevBTTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDEVBTTYPE t1 where  t1.PSSYSDEVBTTYPEID='%1$s'", (Object)strPSSysDevBTTypeId);
    }

    @Override
    public CallResult getPSSysDevBKTasks(String strPSSysDevBKTaskId, Vector<PSSysDevBKTask> psPSSysDevBKTaskList) {
        return this.selectMulti(this.getSQL_getPSSysDevBKTasks(strPSSysDevBKTaskId), psPSSysDevBKTaskList, PSSysDevBKTask.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDevBKTasks(String strPSSysDevBKTaskId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDEVBKTASK t1 where  t1.PPSSYSDEVBKTASKID='%1$s' ORDER BY ORDERVALUE", (Object)strPSSysDevBKTaskId);
    }

    @Override
    public CallResult getPSAppServerType(String strPSAppServerTypeId, PSAppServerType psAppServerType) {
        return this.selectSingle(this.getSQL_getPSAppServerType(strPSAppServerTypeId), psAppServerType, "SYSTEM");
    }

    protected String getSQL_getPSAppServerType(String strPSAppServerTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSASTYPE t1 where  t1.PSASTYPEID='%1$s'", (Object)strPSAppServerTypeId);
    }

    @Override
    public CallResult getPSAppServer(String strPSAppServerId, PSAppServer psAppServer) {
        return this.selectSingle(this.getSQL_getPSAppServer(strPSAppServerId), psAppServer, "SYSTEM");
    }

    protected String getSQL_getPSAppServer(String strPSAppServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPSERVER t1 where  t1.PSAPPSERVERID='%1$s'", (Object)strPSAppServerId);
    }

    @Override
    public CallResult getPSSVNInstRepo(String strPSSVNInstRepoId, PSSVNInstRepo psSVNInstRepo) {
        return this.selectSingle(this.getSQL_getPSSVNInstRepo(strPSSVNInstRepoId), psSVNInstRepo, "SYSTEM");
    }

    protected String getSQL_getPSSVNInstRepo(String strPSSVNInstRepoId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSVNINSTREPO  t1 where  t1.PSSVNINSTREPOID='%1$s'", (Object)strPSSVNInstRepoId);
    }

    @Override
    public CallResult getPSSVNInstRepoByDevCenterSVNId(String strPSDevCenterSVNId, PSSVNInstRepo psSVNInstRepo) {
        return this.selectSingle(this.getSQL_getPSSVNInstRepoByDevCenterSVNId(strPSDevCenterSVNId), psSVNInstRepo, "SYSTEM");
    }

    protected String getSQL_getPSSVNInstRepoByDevCenterSVNId(String strPSDevCenterSVNId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSVNINSTREPO t1 left join t_srfpsdevcentersvn t2 on t1.PSSVNINSTREPOID=t2.PSSVNINSTREPOID where  t2.PSDEVCENTERSVNID='%1$s'", (Object)strPSDevCenterSVNId);
    }

    @Override
    public CallResult getAllPSSubDEs(String strPSSubSysId, Vector<PSSubDE> psSubDEList) {
        return this.selectMulti(this.getSQL_getAllPSSubDEs(strPSSubSysId), psSubDEList, PSSubDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubDEs(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBDE t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubDE(String strPSSubDEId, PSSubDE psSubDE) {
        return this.selectSingle(this.getSQL_getPSSubDE(strPSSubDEId), psSubDE, "SYSTEM");
    }

    protected String getSQL_getPSSubDE(String strPSSubDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBDE t1 where t1.PSSUBDEID='%1$s' ", (Object)strPSSubDEId);
    }

    @Override
    public CallResult getAllPSSubDEViews(String strPSSubSysId, Vector<PSSubDEView> psSubDEViewList) {
        return this.selectMulti(this.getSQL_getAllPSSubDEViews(strPSSubSysId), psSubDEViewList, PSSubDEView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubDEViews(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBDEVIEW t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubDEView(String strPSSubDEViewId, PSSubDEView psSubDEView) {
        return this.selectSingle(this.getSQL_getPSSubDEView(strPSSubDEViewId), psSubDEView, "SYSTEM");
    }

    protected String getSQL_getPSSubDEView(String strPSSubDEViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBDEVIEW t1 where t1.PSSUBDEVIEWID='%1$s' ", (Object)strPSSubDEViewId);
    }

    @Override
    public CallResult getAllPSSubApps(String strPSSubSysId, Vector<PSSubApp> psSubAppList) {
        return this.selectMulti(this.getSQL_getAllPSSubApps(strPSSubSysId), psSubAppList, PSSubApp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubApps(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBAPP t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubApp(String strPSSubAppId, PSSubApp psSubApp) {
        return this.selectSingle(this.getSQL_getPSSubApp(strPSSubAppId), psSubApp, "SYSTEM");
    }

    protected String getSQL_getPSSubApp(String strPSSubAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBAPP t1 where t1.PSSUBAPPID='%1$s' ", (Object)strPSSubAppId);
    }

    @Override
    public CallResult getPSSubSys(String strPSSubSysId, PSSubSys psSubSys) {
        return this.selectSingle(this.getSQL_getPSSubSys(strPSSubSysId), psSubSys, "SYSTEM");
    }

    protected String getSQL_getPSSubSys(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYS t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getAllPSSubSysSFs(String strPSSubSysId, Vector<PSSubSysSF> psSubSysSFList) {
        return this.selectMulti(this.getSQL_getAllPSSubSysSFs(strPSSubSysId), psSubSysSFList, PSSubSysSF.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubSysSFs(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSSF t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubSysSF(String strPSSubSysSFId, PSSubSysSF psSubSysSF) {
        return this.selectSingle(this.getSQL_getPSSubSysSF(strPSSubSysSFId), psSubSysSF, "SYSTEM");
    }

    protected String getSQL_getPSSubSysSF(String strPSSubSysSFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSSF t1 where t1.PSSUBSYSSFID='%1$s' ", (Object)strPSSubSysSFId);
    }

    @Override
    public CallResult getPSAppSubApp(String strPSAppSubAppId, PSAppSubApp psAppSubApp) {
        return this.selectSingle(this.getSQL_getPSAppSubApp(strPSAppSubAppId), psAppSubApp, "SYSTEM");
    }

    protected String getSQL_getPSAppSubApp(String strPSAppSubAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPSUBAPP t1 where t1.PSAPPSUBAPPID='%1$s' ", (Object)strPSAppSubAppId);
    }

    @Override
    public CallResult getAllPSAppSubApps(String strPSApplicationId, Vector<PSAppSubApp> psAppSubAppList) {
        return this.selectMulti(this.getSQL_getAllPSAppSubApps(strPSApplicationId), psAppSubAppList, PSAppSubApp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppSubApps(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPSUBAPP t1 where t1.PSSYSAPPID='%1$s' ", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getAllPSSubAppViews(String strPSSubSysId, Vector<PSSubAppView> psSubAppViewList) {
        return this.selectMulti(this.getSQL_getAllPSSubAppViews(strPSSubSysId), psSubAppViewList, PSSubAppView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubAppViews(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBAPPVIEW t1 where t1.PSSUBAPPID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubAppView(String strPSSubAppViewId, PSSubAppView psSubAppView) {
        return this.selectSingle(this.getSQL_getPSSubAppView(strPSSubAppViewId), psSubAppView, "SYSTEM");
    }

    protected String getSQL_getPSSubAppView(String strPSSubAppViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBAPPVIEW t1 where t1.PSSUBAPPVIEWID='%1$s' ", (Object)strPSSubAppViewId);
    }

    @Override
    public CallResult getAllPSSysRefs(String strPSSystemId, Vector<PSSysRef> psSysRefList) {
        return this.selectMulti(this.getSQL_getAllPSSysRefs(strPSSystemId), psSysRefList, PSSysRef.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysRefs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSREF t1 where t1.PSSYSTEMID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDQPDCond(String strPSDEDQPDCondId, PSDEDQPDCond psDEDQPDCond) {
        return this.selectSingle(this.getSQL_getPSDEDQPDCond(strPSDEDQPDCondId), psDEDQPDCond, "SYSTEM");
    }

    protected String getSQL_getPSDEDQPDCond(String strPSDEDQPDCondId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQPDCOND t1 where  t1.PSDEDQPDCONDID='%1$s'", (Object)strPSDEDQPDCondId);
    }

    protected String getSQL_getAllPSSysImages(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSIMAGE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysImages2(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
        return this.selectMulti(this.getSQL_getAllPSSysImages(strPSSystemId), psSysImageList, PSSysImage.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysImage(String strPSSysImageId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSIMAGE t1 where  t1.PSSYSIMAGEID='%1$s'", (Object)strPSSysImageId);
    }

    public CallResult getAllPSSysCsses2(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
        return this.selectMulti(this.getSQL_getAllPSSysCsses(strPSSystemId), psSysCssList, PSSysCss.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysCsses(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCSS t1 where t1.PSSYSTEMID='%1$s' ORDER BY PSSYSCSSNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCss(String strPSSysCssId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCSS t1 where  t1.PSSYSCSSID='%1$s'", (Object)strPSSysCssId);
    }

    public CallResult getAllPSSubViewTypes2(String strPSSystemId, Vector<PSSubViewType> psSubViewTypeList) {
        return this.selectMulti(this.getSQL_getAllPSSubViewTypes(strPSSystemId), psSubViewTypeList, PSSubViewType.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubViewTypes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBVIEWTYPE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSubViewType(String strPSSubViewTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBVIEWTYPE t1 where  t1.PSSUBVIEWTYPEID='%1$s'", (Object)strPSSubViewTypeId);
    }

    public CallResult getAllPSSysUniReses2(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
        return this.selectMulti(this.getSQL_getAllPSSysUniReses(strPSSystemId), psSysUniResList, PSSysUniRes.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUniReses(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNIRES t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUniRes(String strPSSysUniResId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNIRES t1 where  t1.PSSYSUNIRESID='%1$s'", (Object)strPSSysUniResId);
    }

    public CallResult getAllPSSysBackServices2(String strPSSystemId, Vector<PSSysBackService> psSysBackServiceList) {
        return this.selectMulti(this.getSQL_getAllPSSysBackServices(strPSSystemId), psSysBackServiceList, PSSysBackService.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysBackServices(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBACKSERVICE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBackService(String strPSSysBackServiceId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBACKSERVICE t1 where  t1.PSSYSBACKSERVICEID='%1$s'", (Object)strPSSysBackServiceId);
    }

    public CallResult getAllPSSysMsgTempls2(String strPSSystemId, Vector<PSSysMsgTempl> psSysMsgTemplList) {
        return this.selectMulti(this.getSQL_getAllPSSysMsgTempls(strPSSystemId), psSysMsgTemplList, PSSysMsgTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysMsgTempls(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSMSGTEMPL t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysMsgTempl(String strPSSysMsgTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSMSGTEMPL t1 where  t1.PSSYSMSGTEMPLID='%1$s'", (Object)strPSSysMsgTemplId);
    }

    @Override
    public CallResult getPSPortletType(String strPSPortletTypeId, PSPortletType psPortletType) {
        return this.selectSingle(this.getSQL_getPSPortletType(strPSPortletTypeId), psPortletType, "SYSTEM");
    }

    protected String getSQL_getPSPortletType(String strPSPortletTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPORTLETTYPE t1 where  t1.PSPORTLETTYPEID='%1$s'", (Object)strPSPortletTypeId);
    }

    @Override
    public CallResult getPSAppPortalViewParts(String strPSAppPortalViewId, Vector<PSAppPortalViewPart> psAppPortalViewPartList) {
        return this.selectMulti(this.getSQL_getPSAppPortalViewParts(strPSAppPortalViewId), psAppPortalViewPartList, PSAppPortalViewPart.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSAppPortalViewParts(String strPSAppPortalViewId) {
        if (strPSAppPortalViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPPVPART_TMP t1 where  t1.PSAPPPORTALVIEWID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE,PSAPPPVPARTNAME", (Object)strPSAppPortalViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPPVPART t1 where t1.PSAPPPORTALVIEWID='%1$s' ORDER BY ORDERVALUE,PSAPPPVPARTNAME ", (Object)strPSAppPortalViewId);
    }

    public CallResult getAllPSSysPortlets2(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
        return this.selectMulti(this.getSQL_getAllPSSysPortlets(strPSSystemId), psSysPortletList, PSSysPortlet.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysPortlets(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPORTLET t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPortlet(String strPSSysPortletId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPORTLET t1 where  t1.PSSYSPORTLETID='%1$s'", (Object)strPSSysPortletId);
    }

    protected String getSQL_getPSDEList(String strPSDEListId) {
        if (strPSDEListId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDELIST_TMP t1 where  t1.PSDELISTID='%1$s'", (Object)strPSDEListId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELIST t1 where  t1.PSDELISTID='%1$s'", (Object)strPSDEListId);
    }

    protected String getSQL_getPSDEListItems(String strPSDEListId) {
        if (strPSDEListId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDELISTITEM_TMP t1 where  t1.PSDELISTID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE", (Object)strPSDEListId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTITEM t1 where  t1.PSDELISTID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEListId);
    }

    public CallResult getPSDEListsBySystem(String strPSSystemId, Vector<PSDEList> psDEListList) {
        return this.selectMulti(this.getSQL_getPSDEListsBySystem(strPSSystemId), psDEListList, PSDEList.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEListsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELIST t1 inner join t_srfpsdataentity t2 on t1.psdeid=t2.psdataentityid where  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    public CallResult getPSDEListItemsBySystem(String strPSSystemId, Vector<PSDEListItem> psDEListItemList) {
        return this.selectMulti(this.getSQL_getPSDEListItemsBySystem(strPSSystemId), psDEListItemList, PSDEListItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEListItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTITEM t1  inner join t_SRFPSDELIST t2 on t1.PSDELISTID=t2.PSDELISTID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysValueRules2(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
        return this.selectMulti(this.getSQL_getAllPSSysValueRules(strPSSystemId), psSysValueRuleList, PSSysValueRule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysValueRules(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVALUERULE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysValueRule(String strPSSysValueRuleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVALUERULE t1 where  t1.PSSYSVALUERULEID='%1$s'", (Object)strPSSysValueRuleId);
    }

    @Override
    public CallResult getPSSysRunSession(String strPSSysRunSessionId, PSSysRunSession psSysRunSession) {
        return this.selectSingle(this.getSQL_getPSSysRunSession(strPSSysRunSessionId), psSysRunSession, "SYSTEM");
    }

    protected String getSQL_getPSSysRunSession(String strPSSysRunSessionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSRUNSESSION t1 where  t1.PSSYSRUNSESSIONID='%1$s'", (Object)strPSSysRunSessionId);
    }

    @Override
    public CallResult getPSSystemASes(String strPSSystemId, Vector<PSSystemAS> psSystemASList) {
        return this.selectMulti(this.getSQL_getPSSystemASes(strPSSystemId), psSystemASList, PSSystemAS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSystemASes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEMAS t1 where  t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSystemAS(String strPSSystemASId, PSSystemAS psSystemAS) {
        return this.selectSingle(this.getSQL_getPSSystemAS(strPSSystemASId), psSystemAS, "SYSTEM");
    }

    protected String getSQL_getPSSystemAS(String strPSSystemASId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTEMAS t1 where t1.PSSYSTEMASID='%1$s' ", (Object)strPSSystemASId);
    }

    @Override
    public CallResult getPSDEOPPriv(String strPSDEOPPrivId, PSDEOPPriv psDEOPPriv) {
        return this.selectSingle(this.getSQL_getPSDEOPPriv(strPSDEOPPrivId), psDEOPPriv, "SYSTEM");
    }

    protected String getSQL_getPSDEOPPriv(String strPSDEOPPrivId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIV t1 where  t1.PSDEOPPRIVID='%1$s' ", (Object)strPSDEOPPrivId);
    }

    protected String getSQL_getPSDEMainStates(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAINSTATE t1 where  t1.PSDEID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDEId);
    }

    protected String getSQL_getPSDEMainStateRSs(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from t_SRFPSDEMAINSTATERS t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEId);
    }

    public CallResult getPSDEMainStatesBySystem(String strPSSystemId, Vector<PSDEMainState> psDEMainStateList) {
        return this.selectMulti(this.getSQL_getPSDEMainStatesBySystem(strPSSystemId), psDEMainStateList, PSDEMainState.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMainStatesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMAINSTATE t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getPSDEMainStateRSsBySystem(String strPSSystemId, Vector<PSDEMainStateRS> psDEMainStateRSList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateRSsBySystem(strPSSystemId), psDEMainStateRSList, PSDEMainStateRS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMainStateRSsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEMAINSTATERS t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEOPPrivs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIV t1 where  t1.PSDEID='%1$s' AND  (t1.DEVALIDFLAG IS NULL OR t1.DEVALIDFLAG = 1) AND (t1.DERVALIDFLAG IS NULL OR T1.DERVALIDFLAG = 1) ", (Object)strPSDataEntityId);
    }

    @Override
    public CallResult getPSDEOPPrivsBySystem(String strPSSystemId, Vector<PSDEOPPriv> psDEOPPrivList) {
        return this.selectMulti(this.getSQL_getPSDEOPPrivsBySystem(strPSSystemId), psDEOPPrivList, PSDEOPPriv.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEOPPrivsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIV t1  where  t1.PSSYSTEMID='%1$s' AND t1.PSDEID IS NULL AND  (t1.DEVALIDFLAG IS NULL OR t1.DEVALIDFLAG = 1) AND (t1.DERVALIDFLAG IS NULL OR T1.DERVALIDFLAG = 1) ", (Object)strPSSystemId);
    }

    public CallResult getPSDEOPPrivsBySystem2(String strPSSystemId, Vector<PSDEOPPriv> psDEOPPrivList) {
        return this.selectMulti(this.getSQL_getPSDEOPPrivsBySystem2(strPSSystemId), psDEOPPrivList, PSDEOPPriv.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEOPPrivsBySystem2(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIV t1  where  t1.PSSYSTEMID='%1$s' AND t1.PSDEID IS NOT NULL AND  (t1.DEVALIDFLAG IS NULL OR t1.DEVALIDFLAG = 1) AND (t1.DERVALIDFLAG IS NULL OR T1.DERVALIDFLAG = 1) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMainStateActions(String strPSDEMainStateId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMSACTION t1 where  t1.PSDEMSID='%1$s' ", (Object)strPSDEMainStateId);
    }

    public CallResult getPSDEMainStateActionsBySystem(String strPSSystemId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateActionsBySystem(strPSSystemId), psDEMainStateActionList, PSDEMainStateAction.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMainStateActionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEMSACTION  t1 inner join T_SRFPSDEMAINSTATE t2 on t1.PSDEMSID= t2.PSDEMAINSTATEID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMainStateOPPrivs(String strPSDEMainStateId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMSOPPRIV t1 where  t1.PSDEMAINSTATEID='%1$s' ", (Object)strPSDEMainStateId);
    }

    public CallResult getPSDEMainStateOPPrivsBySystem(String strPSSystemId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateOPPrivsBySystem(strPSSystemId), psDEMainStateOPPrivList, PSDEMainStateOPPriv.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMainStateOPPrivsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEMSOPPRIV  t1 inner join T_SRFPSDEMAINSTATE t2 on t1.PSDEMAINSTATEID= t2.PSDEMAINSTATEID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysPDTViews2(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
        return this.selectMulti(this.getSQL_getAllPSSysPDTViews(strPSSystemId), psSysPDTViewList, PSSysPDTView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysPDTViews(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPDTVIEW t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPDTView(String strPSSysPDTViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPDTVIEW t1 where  t1.PSSYSPDTVIEWID='%1$s'", (Object)strPSSysPDTViewId);
    }

    @Override
    public CallResult getPSPFPluginType(String strPSPFPluginTypeId, PSPFPluginType psPFPluginType) {
        return this.selectSingle(this.getSQL_getPSPFPluginType(strPSPFPluginTypeId), psPFPluginType, "SYSTEM");
    }

    protected String getSQL_getPSPFPluginType(String strPSPFPluginTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPLUGINTYPE t1 where  t1.PSPFPLUGINTYPEID='%1$s'", (Object)strPSPFPluginTypeId);
    }

    public CallResult getAllPSSysPFPlugins2(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
        return this.selectMulti(this.getSQL_getAllPSSysPFPlugins(strPSSystemId), psSysPFPluginList, PSSysPFPlugin.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysPFPlugins(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPFPLUGIN t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPFPlugin(String strPSSysPFPluginId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPFPLUGIN t1 where  t1.PSSYSPFPLUGINID='%1$s'", (Object)strPSSysPFPluginId);
    }

    protected String getSQL_getAllPSSysPFPluginTempls(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPFPITEMPL t1   inner join T_SRFPSSYSPFPLUGIN t2 on t1.PSSYSPFPLUGINID = t2.PSSYSPFPLUGINID   where t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysPFPluginTempls2(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
        return this.selectMulti(this.getSQL_getAllPSSysPFPluginTempls(strPSSystemId), psSysPFPluginTemplList, PSSysPFPluginTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysPFPluginTempl(String strPSSysPFPluginTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSPFPITEMPL t1 where  t1.PSSYSPFPITEMPLID='%1$s'", (Object)strPSSysPFPluginTemplId);
    }

    protected String getSQL_getPSDETreeView(String strPSDETreeViewId) {
        if (strPSDETreeViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREEVIEW_TMP t1 where  t1.PSDETREEVIEWID='%1$s'", (Object)strPSDETreeViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREEVIEW t1 where  t1.PSDETREEVIEWID='%1$s'", (Object)strPSDETreeViewId);
    }

    @Override
    public CallResult getPSDETreeNodeType(String strPSDETreeNodeTypeId, PSDETreeNodeType psDETreeNodeType) {
        return this.selectSingle(this.getSQL_getPSDETreeNodeType(strPSDETreeNodeTypeId), psDETreeNodeType, "SYSTEM");
    }

    protected String getSQL_getPSDETreeNodeType(String strPSDETreeNodeTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSTREENODETYPE t1 where  t1.PSTREENODETYPEID ='%1$s'", (Object)strPSDETreeNodeTypeId);
    }

    public CallResult getPSDETreeNodesBySystem(String strPSSystemId, Vector<PSDETreeNode> psDETreeNodeList) {
        return this.selectMulti(this.getSQL_getPSDETreeNodesBySystem(strPSSystemId), psDETreeNodeList, PSDETreeNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeNodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODE t1  inner join t_SRFPSDETREEVIEW t2 on t1.PSDETREEVIEWID=t2.PSDETREEVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREECOL t1  inner join t_SRFPSDETREEVIEW t2 on t1.PSDETREEVIEWID=t2.PSDETREEVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeColumns(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREECOL_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREECOL t1 where  t1.PSDETREEVIEWID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDETreeId);
    }

    public CallResult getPSDETreeNodeColumnsBySystem(String strPSSystemId, Vector<PSDETreeNodeColumn> psDETreeNodeColumnList) {
        if (this.getModelInstVer() < 363) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeNodeColumnsBySystem(strPSSystemId), psDETreeNodeColumnList, PSDETreeNodeColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeNodeColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODECOL t1  inner join t_SRFPSDETREEVIEW t2 on t1.PSDETREEVIEWID=t2.PSDETREEVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeNodeColumns(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREENODECOL_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODECOL t1 where  t1.PSDETREEVIEWID='%1$s' ", (Object)strPSDETreeId);
    }

    public CallResult getPSDETreeViewsBySystem(String strPSSystemId, Vector<PSDETreeView> psDETreeViewList) {
        return this.selectMulti(this.getSQL_getPSDETreeViewsBySystem(strPSSystemId), psDETreeViewList, PSDETreeView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeViewsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREEVIEW t1 where  t1.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    public CallResult getPSDETreeNodeRSesBySystem(String strPSSystemId, Vector<PSDETreeNodeRS> psDETreeNodeRSList) {
        return this.selectMulti(this.getSQL_getPSDETreeNodeRSesBySystem(strPSSystemId), psDETreeNodeRSList, PSDETreeNodeRS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeNodeRSesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODERS t1  inner join t_SRFPSDETREEVIEW t2 on t1.PSDETREEVIEWID=t2.PSDETREEVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeNodeRSes(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREENODERS_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE ", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODERS t1 where  t1.PSDETREEVIEWID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDETreeId);
    }

    public CallResult getPSDETreeNodeRVsBySystem(String strPSSystemId, Vector<PSDETreeNodeRV> psDETreeNodeRVList) {
        return this.selectMulti(this.getSQL_getPSDETreeNodeRVsBySystem(strPSSystemId), psDETreeNodeRVList, PSDETreeNodeRV.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeNodeRVsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDETREENODERV t1  inner join t_SRFPSDETREEVIEW t2 on t1.PSDETREEVIEWID=t2.PSDETREEVIEWID inner join t_srfpsdataentity t3 on t2.psdeid=t3.psdataentityid where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeNodeRVs(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREENODERV_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND  t1.srfdraftflag = 0  ", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODERV t1 where  t1.PSDETREEVIEWID='%1$s'  ", (Object)strPSDETreeId);
    }

    @Override
    public CallResult getPSCounterType(String strPSCounterTypeId, PSCounterType psCounterType) {
        return this.selectSingle(this.getSQL_getPSCounterType(strPSCounterTypeId), psCounterType, "SYSTEM");
    }

    protected String getSQL_getPSCounterType(String strPSCounterTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSCOUNTERTYPE t1 where  t1.PSCOUNTERTYPEID='%1$s'", (Object)strPSCounterTypeId);
    }

    public CallResult getAllPSSysCounters2(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
        return this.selectMulti(this.getSQL_getAllPSSysCounters(strPSSystemId), psSysCounterList, PSSysCounter.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysCounters(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCOUNTER t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCounter(String strPSSysCounterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCOUNTER t1 where  t1.PSSYSCOUNTERID='%1$s'", (Object)strPSSysCounterId);
    }

    @Override
    public CallResult getPSCounter(String strPSCounterId, PSCounter psCounter) {
        return this.selectSingle(this.getSQL_getPSCounter(strPSCounterId), psCounter, "SYSTEM");
    }

    protected String getSQL_getPSCounter(String strPSCounterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSCOUNTER t1 where  t1.PSCOUNTERID='%1$s'", (Object)strPSCounterId);
    }

    @Override
    public CallResult getPSPFStyleCodes(String strPSPFStyleId, Vector<PSPFStyleCode> psSysCounterList) {
        return this.selectMulti(this.getSQL_getPSPFStyleCodes(strPSPFStyleId), psSysCounterList, PSPFStyleCode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFStyleCodes(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFSTYLECODE t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    public CallResult getAllPSSysDictCats2(String strPSSystemId, Vector<PSSysDictCat> psSysDictCatList) {
        return this.selectMulti(this.getSQL_getAllPSSysDictCats(strPSSystemId), psSysDictCatList, PSSysDictCat.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDictCats(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDICTCAT t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDictCat(String strPSSysDictCatId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDICTCAT t1 where  t1.PSSYSDICTCATID='%1$s'", (Object)strPSSysDictCatId);
    }

    @Override
    public CallResult getPSBackService(String strPSBackServiceId, PSBackService psBackService) {
        return this.selectSingle(this.getSQL_getPSBackService(strPSBackServiceId), psBackService, "SYSTEM");
    }

    protected String getSQL_getPSBackService(String strPSBackServiceId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSBACKSERVICE t1 where  t1.PSBACKSERVICEID='%1$s'", (Object)strPSBackServiceId);
    }

    public CallResult getAllPSSysEditorStyles2(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
        return this.selectMulti(this.getSQL_getAllPSSysEditorStyles(strPSSystemId), psSysEditorStyleList, PSSysEditorStyle.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysEditorStyles(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSEDITORSTYLE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEditorStyle(String strPSSysEditorStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSEDITORSTYLE t1 where  t1.PSSYSEDITORSTYLEID='%1$s'", (Object)strPSSysEditorStyleId);
    }

    protected String getSQL_getPSDEDBIndexs(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBINDEX t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEDBIndexsBySystem(String strPSSystemId, Vector<PSDEDBIndex> psDEDBIndexList) {
        return this.selectMulti(this.getSQL_getPSDEDBIndexsBySystem(strPSSystemId), psDEDBIndexList, PSDEDBIndex.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDBIndexsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBINDEX t1 inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDBIndexFields(String strPSDEDataQueryId) {
        if (strPSDEDataQueryId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDBIDXFIELD_TMP t1 where  t1.PSDEDBINDEXID='%1$s' AND  t1.srfdraftflag = 0 order by  t1.PSDEDBIDXFIELDNAME ", (Object)strPSDEDataQueryId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBIDXFIELD t1 where  t1.PSDEDBINDEXID='%1$s' order by t1.PSDEDBIDXFIELDNAME ", (Object)strPSDEDataQueryId);
    }

    public CallResult getPSDEDBIndexFieldsBySystem(String strPSSystemId, Vector<PSDEDBIndexField> psDEDBIndexFieldList) {
        return this.selectMulti(this.getSQL_getPSDEDBIndexFieldsBySystem(strPSSystemId), psDEDBIndexFieldList, PSDEDBIndexField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDBIndexFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDBIDXFIELD t1 inner join T_SRFPSDEDBINDEX t2 on t1.PSDEDBINDEXID= t2.PSDEDBINDEXID inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  order by t1.PSDEDBIDXFIELDNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEReports(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEREPORT t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEReportsBySystem(String strPSSystemId, Vector<PSDEReport> psDEReportList) {
        return this.selectMulti(this.getSQL_getPSDEReportsBySystem(strPSSystemId), psDEReportList, PSDEReport.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEReportsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEREPORT t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEReportItems(String strPSDEReportId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEREPITEM t1 where  t1.MAJORPSDEREPORTID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEReportId);
    }

    public CallResult getPSDEReportItemsBySystem(String strPSSystemId, Vector<PSDEReportItem> psDEReportItemList) {
        return this.selectMulti(this.getSQL_getPSDEReportItemsBySystem(strPSSystemId), psDEReportItemList, PSDEReportItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEReportItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEREPITEM  t1 inner join T_SRFPSDEREPORT t2 on t1.MAJORPSDEREPORTID= t2.PSDEREPORTID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEPrints(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPRINT t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEPrintsBySystem(String strPSSystemId, Vector<PSDEPrint> psDEPrintList) {
        return this.selectMulti(this.getSQL_getPSDEPrintsBySystem(strPSSystemId), psDEPrintList, PSDEPrint.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEPrintsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPRINT t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDepSlnPrd(String strPSDepSlnPrdId, PSDepSlnPrd psDepSlnPrd) {
        return this.selectSingle(this.getSQL_getPSDepSlnPrd(strPSDepSlnPrdId), psDepSlnPrd, "SYSTEM");
    }

    protected String getSQL_getPSDepSlnPrd(String strPSDepSlnPrdId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSLNPRD t1 where  t1.PSDEPSLNPRDID ='%1$s'", (Object)strPSDepSlnPrdId);
    }

    @Override
    public CallResult getAllPSSysIssueEngines(Vector<PSSysIssueEngine> psDEFieldTypes) {
        return this.selectMulti(this.getSQL_getAllPSSysIssueEngines(), psDEFieldTypes, PSSysIssueEngine.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysIssueEngines() {
        return StringHelper.Format((String)"SELECT t1.* from T_SRFPSSYSISSUEENGINE t1 where t1.VALIDFLAG = 1  order by ORDERVALUE DESC");
    }

    @Override
    public CallResult getPSPF(String strPSPFId, PSPF psPF) {
        return this.selectSingle(this.getSQL_getPSPF(strPSPFId), psPF, "SYSTEM");
    }

    protected String getSQL_getPSPF(String strPSPFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPF t1 where  t1.PSPFID='%1$s'", (Object)strPSPFId);
    }

    public CallResult getAllPSSysViewLogics2(String strPSSystemId, Vector<PSSysViewLogic> psSysViewLogicList) {
        return this.selectMulti(this.getSQL_getAllPSSysViewLogics(strPSSystemId), psSysViewLogicList, PSSysViewLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysViewLogics(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWLOGIC t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEViewLogics(String strPSDEViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVIEWLOGIC t1 where  t1.PSDEVIEWBASEID = '%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEViewId);
    }

    protected String getSQL_getPSDEViewEngines(String strPSDEViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVIEWENGINE t1 where  t1.PSDEVIEWBASEID = '%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEViewId);
    }

    public CallResult getPSDEViewLogicsBySystem(String strPSSystemId, Vector<PSDEViewLogic> psDEViewLogicList) {
        return this.selectMulti(this.getSQL_getPSDEViewLogicsBySystem(strPSSystemId), psDEViewLogicList, PSDEViewLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEViewLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVIEWLOGIC t1  inner join t_srfpsdeviewbase t2 on  t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID  where t2.pssystemid = '%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getPSSysDEUIActionGroups2(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        return this.selectMulti(this.getSQL_getPSSysDEUIActionGroups(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDEUIActionGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUAGROUP t1 where  t1.PSDEID IS NULL AND t1.PSWFID IS NULL AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    public CallResult getPSDEViewEnginesBySystem(String strPSSystemId, Vector<PSDEViewEngine> psDEViewEngineList) {
        return this.selectMulti(this.getSQL_getPSDEViewEnginesBySystem(strPSSystemId), psDEViewEngineList, PSDEViewEngine.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEViewEnginesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVIEWENGINE t1  inner join t_srfpsdeviewbase t2 on  t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID  where t2.pssystemid = '%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFCtrlTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFCtrlTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFCtrlTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFCTRLTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFViewLogicTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFViewLogicTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFViewLogicTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFViewLogicTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFViewLogicTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFVLTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFUIActionTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFUIActionTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFUIActionTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFUIActionTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFUIActionTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFUATEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFAppTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFAppTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFAppTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFAppTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFAppTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFAPPTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFEditorTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFEditorTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFEditorTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFEditorTemplsByPFStyle(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFEDITORTEMPL t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFEditorTemplsByPF(String strPSPFId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        return this.selectMulti(this.getSQL_getPSPFEditorTemplsByPF(strPSPFId), psPFViewTemplList, PSPFEditorTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFEditorTemplsByPF(String strPSPFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFEDITORTEMPL t1 where t1.PSPFID='%1$s' and t1.PSPFSTYLEID IS NULL ", (Object)strPSPFId);
    }

    @Override
    public CallResult getAllPSSubSysVers(String strPSSubSysId, Vector<PSSubSysVer> psSubSysVerList) {
        return this.selectMulti(this.getSQL_getAllPSSubSysVers(strPSSubSysId), psSubSysVerList, PSSubSysVer.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubSysVers(String strPSSubSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSVER t1 where t1.PSSUBSYSID='%1$s' ", (Object)strPSSubSysId);
    }

    @Override
    public CallResult getPSSubSysVer(String strPSSubSysVerId, PSSubSysVer psSubSysVer) {
        return this.selectSingle(this.getSQL_getPSSubSysVer(strPSSubSysVerId), psSubSysVer, "SYSTEM");
    }

    protected String getSQL_getPSSubSysVer(String strPSSubSysVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSVER t1 where t1.PSSUBSYSVERID='%1$s' ", (Object)strPSSubSysVerId);
    }

    @Override
    public CallResult getAllPSSysDMItems(String strPSSystemId, Vector<PSSysDMItem> psSysDMItemList) {
        return this.selectMulti(this.getSQL_getAllPSSysDMItems(strPSSystemId), psSysDMItemList, PSSysDMItem.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getAllPSSysDMItems(String strPSSystemId) {
        return StringHelper.Format((String)"SELECT t1.* FROM T_SRFPSSYSDMITEM t1 inner join T_SRFPSSYSTEMDBCFG t2 on t1.PSSYSTEMDBCFGID=t2.PSSYSTEMDBCFGID where t2.PSSYSTEMID = '%1$s' order by t1.PSSYSDMITEMNAME", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysActors2(String strPSSystemId, Vector<PSSysActor> psSysActorList) {
        return this.selectMulti(this.getSQL_getAllPSSysActors(strPSSystemId), psSysActorList, PSSysActor.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysActors(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSACTOR t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysActor(String strPSSysActorId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSACTOR t1 where  t1.PSSYSACTORID='%1$s'", (Object)strPSSysActorId);
    }

    public CallResult getAllPSSysUserCases2(String strPSSystemId, Vector<PSSysUserCase> psSysUserCaseList) {
        return this.selectMulti(this.getSQL_getAllPSSysUserCases(strPSSystemId), psSysUserCaseList, PSSysUserCase.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUserCases(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERCASE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserCase(String strPSSysUserCaseId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERCASE t1 where  t1.PSSYSUSERCASEID='%1$s'", (Object)strPSSysUserCaseId);
    }

    public CallResult getAllPSSysUserCaseRSs2(String strPSSystemId, Vector<PSSysUserCaseRS> psSysUserCaseRSList) {
        return this.selectMulti(this.getSQL_getAllPSSysUserCaseRSs(strPSSystemId), psSysUserCaseRSList, PSSysUserCaseRS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUserCaseRSs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERCASERS t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSUSERCASERSNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserCaseRS(String strPSSysUserCaseRSId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERCASERS t1 where  t1.PSSYSUSERCASERSID='%1$s'", (Object)strPSSysUserCaseRSId);
    }

    public CallResult getAllPSSysTestCases2(String strPSSystemId, Vector<PSSysTestCase> psSysTestCaseList) {
        return this.selectMulti(this.getSQL_getAllPSSysTestCases(strPSSystemId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTestCases(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTCASE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSysTestCases2(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTCASE t1 where t1.PSSYSTEMID='%1$s' AND t1.PSSYSTESTPRJID IS NULL AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestCase(String strPSSysTestCaseId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTCASE t1 where t1.PSSYSTESTCASEID='%1$s'", (Object)strPSSysTestCaseId);
    }

    public CallResult getPSSysTestCaseAssertsBySystem(String strPSSystemId, Vector<PSSysTestCaseAssert> psSysTestCaseAssertList) {
        return this.selectMulti(this.getSQL_getPSSysTestCaseAssertsBySystem(strPSSystemId), psSysTestCaseAssertList, PSSysTestCaseAssert.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysTestCaseAssertsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSTCASSERT t1  inner join t_srfpssystestcase t2 on t1.pssystestcaseid=t2.pssystestcaseid where  t2.PSSYSTEMID='%1$s' order by ORDERVALUE,PSSYSTCINPUTNAME", (Object)strPSSystemId);
    }

    public CallResult getPSSysTestCaseInputsBySystem(String strPSSystemId, Vector<PSSysTestCaseInput> psSysTestCaseInputList) {
        return this.selectMulti(this.getSQL_getPSSysTestCaseInputsBySystem(strPSSystemId), psSysTestCaseInputList, PSSysTestCaseInput.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysTestCaseInputsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTCINPUT t1  inner join t_srfpssystestcase t2 on t1.pssystestcaseid=t2.pssystestcaseid where  t2.PSSYSTEMID='%1$s' order by ORDERVALUE,PSSYSTCINPUTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestCaseInputs(String strPSSysTestCaseId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTCINPUT t1 where  t1.PSSYSTESTCASEID='%1$s' order by ORDERVALUE,PSSYSTCINPUTNAME", (Object)strPSSysTestCaseId);
    }

    protected String getSQL_getPSSysTestCaseAsserts(String strPSSysTestCaseInputId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTCASSERT t1 where  t1.PSSYSTCINPUTID='%1$s' order by ORDERVALUE,PSSYSTCASSERTNAME", (Object)strPSSysTestCaseInputId);
    }

    public CallResult getAllPSSysTestDatas2(String strPSSystemId, Vector<PSSysTestData> psSysTestDataList) {
        return this.selectMulti(this.getSQL_getAllPSSysTestDatas(strPSSystemId), psSysTestDataList, PSSysTestData.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTestDatas(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTDATA t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestData(String strPSSysTestDataId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTDATA t1 where  t1.PSSYSTESTDATAID='%1$s'", (Object)strPSSysTestDataId);
    }

    public CallResult getPSSysTestDataItemsBySystem(String strPSSystemId, Vector<PSSysTestDataItem> psSysTestDataItemList) {
        return this.selectMulti(this.getSQL_getPSSysTestDataItemsBySystem(strPSSystemId), psSysTestDataItemList, PSSysTestDataItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysTestDataItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTDITEM t1  inner join T_SRFPSSYSTESTDATA t2 on t1.PSSYSTESTDATAID=t2.PSSYSTESTDATAID where  t2.PSSYSTEMID='%1$s' order by PSSYSTDITEMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestDataItems(String strPSSysTestDataId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTDITEM t1 where  t1.PSSYSTESTDATAID='%1$s' order by PSSYSTDITEMNAME", (Object)strPSSysTestDataId);
    }

    public CallResult getAllPSSysSampleValues2(String strPSSystemId, Vector<PSSysSampleValue> psSysSampleValueList) {
        return this.selectMulti(this.getSQL_getAllPSSysSampleValues(strPSSystemId), psSysSampleValueList, PSSysSampleValue.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSampleValues(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSAMPLEVALUE t1 where t1.PSSYSTEMID='%1$s' AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeNodes(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREENODE_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREENODE t1 where  t1.PSDETREEVIEWID='%1$s' ", (Object)strPSDETreeId);
    }

    public CallResult getPSDETreeColumnsBySystem(String strPSSystemId, Vector<PSDETreeColumn> psDETreeColumnList) {
        if (this.getModelInstVer() < 363) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeColumnsBySystem(strPSSystemId), psDETreeColumnList, PSDETreeColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysViewLogic(String strPSSysViewLogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWLOGIC t1 where  t1.PSSYSVIEWLOGICID='%1$s'", (Object)strPSSysViewLogicId);
    }

    protected String getSQL_getPSSysSampleValue(String strPSSysSampleValueId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSAMPLEVALUE t1 where t1.PSSYSSAMPLEVALUEID='%1$s' AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1)", (Object)strPSSysSampleValueId);
    }

    public CallResult getAllPSSysUserModes2(String strPSSystemId, Vector<PSSysUserMode> psSysUserModeList) {
        return this.selectMulti(this.getSQL_getAllPSSysUserModes(strPSSystemId), psSysUserModeList, PSSysUserMode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUserModes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERMODE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserMode(String strPSSysUserModeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERMODE t1 where  t1.PSSYSUSERMODEID='%1$s'", (Object)strPSSysUserModeId);
    }

    @Override
    public CallResult getPSAppUserMode(String strPSAppUserModeId, PSAppUserMode psAppUserMode) {
        return this.selectSingle(this.getSQL_getPSAppUserMode(strPSAppUserModeId), psAppUserMode, "SYSTEM");
    }

    protected String getSQL_getPSAppUserMode(String strPSAppUserModeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUSERMODE t1 where  t1.PSAPPUSERMODEID='%1$s'", (Object)strPSAppUserModeId);
    }

    public CallResult getAllPSAppUserModes2(String strPSApplicationId, Vector<PSAppUserMode> psAppUserModes) {
        return this.selectMulti(this.getSQL_getAllPSAppUserModes(strPSApplicationId), psAppUserModes, PSAppUserMode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppUserModes(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUSERMODE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppUITheme(String strPSAppUIThemeId, PSAppUITheme psAppUITheme) {
        return this.selectSingle(this.getSQL_getPSAppUITheme(strPSAppUIThemeId), psAppUITheme, "SYSTEM");
    }

    protected String getSQL_getPSAppUITheme(String strPSAppUIThemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUITHEME t1 where  t1.PSAPPUITHEMEID='%1$s'", (Object)strPSAppUIThemeId);
    }

    public CallResult getAllPSAppUIThemes2(String strPSApplicationId, Vector<PSAppUITheme> psAppUIThemes) {
        return this.selectMulti(this.getSQL_getAllPSAppUIThemes(strPSApplicationId), psAppUIThemes, PSAppUITheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppUIThemes(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUITHEME t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSSFVerCodeItem(String strPSSFVerCodeItemId, PSSFVerCodeItem psSFVerCodeItem) {
        return this.selectSingle(this.getSQL_getPSSFVerCodeItem(strPSSFVerCodeItemId), psSFVerCodeItem, "SYSTEM");
    }

    protected String getSQL_getPSSFVerCodeItem(String strPSSFVerCodeItemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFVERCODEITEM t1 where  t1.PSSFVERCODEITEMID='%1$s'", (Object)strPSSFVerCodeItemId);
    }

    @Override
    public CallResult getPSSFVerCodes(String strPSSFStyleVerId, Vector<PSSFVerCode> psSFVerCodeList) {
        return this.selectMulti(this.getSQL_getPSSFVerCodes(strPSSFStyleVerId), psSFVerCodeList, PSSFVerCode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSFVerCodes(String strPSSFStyleVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFVERCODE t1 where  t1.PSSFSTYLEVERID='%1$s' ", (Object)strPSSFStyleVerId);
    }

    @Override
    public CallResult getPSSFVerCodeItems(String strPSSFVerCodeId, Vector<PSSFVerCodeItem> psSFVerCodeItemList) {
        return this.selectMulti(this.getSQL_getPSSFVerCodeItems(strPSSFVerCodeId), psSFVerCodeItemList, PSSFVerCodeItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSFVerCodeItems(String strPSSFVerCodeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFVERCODEITEM t1 where  t1.PSSFVERCODEID='%1$s' ", (Object)strPSSFVerCodeId);
    }

    protected String getSQL_getPSDERDEFMaps(String strPSDERId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDERDEFMAP t1 where t1.PSDERID='%1$s' ORDER BY PSDERDEFMAPNAME ", (Object)strPSDERId);
    }

    public CallResult getPSDERDEFMapsBySystem(String strPSSystemId, Vector<PSDERDEFMap> psDERDEFMapList) {
        return this.selectMulti(this.getSQL_getPSDERDEFMapsBySystem(strPSSystemId), psDERDEFMapList, PSDERDEFMap.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDERDEFMapsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDERDEFMAP t1  inner join T_SRFPSDER t2 on t1.PSDERID= t2.PSDERID where t2.pssystemid = '%1$s' AND (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  ORDER BY t1.PSDERDEFMAPNAME ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysERMaps2(String strPSSystemId, Vector<PSSysERMap> psSysERMapList) {
        return this.selectMulti(this.getSQL_getAllPSSysERMaps(strPSSystemId), psSysERMapList, PSSysERMap.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysERMaps(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSERMap t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysERMap(String strPSSysERMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSERMAP t1 where  t1.PSSYSERMAPID='%1$s'", (Object)strPSSysERMapId);
    }

    public CallResult getPSSysERMapNodesBySystem(String strPSSystemId, Vector<PSSysERMapNode> psSysERMapNodeList) {
        return this.selectMulti(this.getSQL_getPSSysERMapNodesBySystem(strPSSystemId), psSysERMapNodeList, PSSysERMapNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysERMapNodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSERMAPNODE t1  inner join t_srfPSSYSERMAP t2 on t1.PSSYSERMAPID=t2.PSSYSERMAPID where  t2.PSSYSTEMID='%1$s' order by PSSYSERMAPNODENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysERMapNodes(String strPSSysERMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSERMAPNODE t1 where  t1.PSSYSERMapID='%1$s' order by PSSYSERMAPNODENAME", (Object)strPSSysERMapId);
    }

    public CallResult getAllPSSysUCMaps2(String strPSSystemId, Vector<PSSysUCMap> psSysUCMapList) {
        return this.selectMulti(this.getSQL_getAllPSSysUCMaps(strPSSystemId), psSysUCMapList, PSSysUCMap.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUCMaps(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUCMap t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUCMap(String strPSSysUCMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUCMAP t1 where  t1.PSSYSUCMAPID='%1$s'", (Object)strPSSysUCMapId);
    }

    public CallResult getPSSysUCMapNodesBySystem(String strPSSystemId, Vector<PSSysUCMapNode> psSysUCMapNodeList) {
        return this.selectMulti(this.getSQL_getPSSysUCMapNodesBySystem(strPSSystemId), psSysUCMapNodeList, PSSysUCMapNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysUCMapNodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUCMAPNODE t1  inner join t_srfPSSYSUCMAP t2 on t1.PSSYSUCMAPID=t2.PSSYSUCMAPID where  t2.PSSYSTEMID='%1$s' order by PSSYSUCMAPNODENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUCMapNodes(String strPSSysUCMapId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUCMAPNODE t1 where  t1.PSSYSUCMapID='%1$s' order by PSSYSUCMAPNODENAME", (Object)strPSSysUCMapId);
    }

    public CallResult getAllPSSysDynaModels2(String strPSSystemId, Vector<PSSysDynaModel> psSysDynaModelList) {
        return this.selectMulti(this.getSQL_getAllPSSysDynaModels(strPSSystemId), psSysDynaModelList, PSSysDynaModel.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDynaModels(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDYNAMODEL t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDynaModel(String strPSSysDynaModelId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDYNAMODEL t1 where  t1.PSSYSDYNAMODELID='%1$s'", (Object)strPSSysDynaModelId);
    }

    public CallResult getPSSysDynaModelAttrsBySystem(String strPSSystemId, Vector<PSSysDynaModelAttr> psSysDynaModelAttrList) {
        return this.selectMulti(this.getSQL_getPSSysDynaModelAttrsBySystem(strPSSystemId), psSysDynaModelAttrList, PSSysDynaModelAttr.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDynaModelAttrsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDYNAMODELATTR t1  inner join T_SRFPSSYSDYNAMODEL t2 on t1.PSSYSDYNAMODELID=t2.PSSYSDYNAMODELID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSDYNAMODELATTRNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDynaModelAttrs(String strPSSysDynaModelId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDYNAMODELATTR t1 where  t1.PSSYSDYNAMODELID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSDYNAMODELATTRNAME", (Object)strPSSysDynaModelId);
    }

    public CallResult getAllPSSysSFPubs2(String strPSSystemId, Vector<PSSysSFPub> psSysSFPubList) {
        return this.selectMulti(this.getSQL_getAllPSSysSFPubs(strPSSystemId), psSysSFPubList, PSSysSFPub.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSFPubs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPUB t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSFPub(String strPSSysSFPubId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPUB t1 where  t1.PSSYSSFPUBID='%1$s'", (Object)strPSSysSFPubId);
    }

    @Override
    public CallResult getPSPFStylePrjs(String strPSPFStyleId, Vector<PSPFStylePrj> psSysCounterList) {
        return this.selectMulti(this.getSQL_getPSPFStylePrjs(strPSPFStyleId), psSysCounterList, PSPFStylePrj.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFStylePrjs(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFSTYLEPRJ t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSSFStylePrjs(String strPSSFStyleId, Vector<PSSFStylePrj> psSysCounterList) {
        return this.selectMulti(this.getSQL_getPSSFStylePrjs(strPSSFStyleId), psSysCounterList, PSSFStylePrj.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSFStylePrjs(String strPSSFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFSTYLEPRJ t1 where t1.PSSFSTYLEID='%1$s' ", (Object)strPSSFStyleId);
    }

    @Override
    public CallResult getPSSFPkg(String strPSSFPkgId, PSSFPkg psSFPkg) {
        return this.selectSingle(this.getSQL_getPSSFPkg(strPSSFPkgId), psSFPkg, "SYSTEM");
    }

    protected String getSQL_getPSSFPkg(String strPSSFPkgId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFPKG t1 where  t1.PSSFPKGID='%1$s'", (Object)strPSSFPkgId);
    }

    @Override
    public CallResult getPSSFPkgVer(String strPSSFPkgVerId, PSSFPkgVer psSFPkgVer) {
        return this.selectSingle(this.getSQL_getPSSFPkgVer(strPSSFPkgVerId), psSFPkgVer, "SYSTEM");
    }

    protected String getSQL_getPSSFPkgVer(String strPSSFPkgVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFPKGVER t1 where  t1.PSSFPKGVERID='%1$s'", (Object)strPSSFPkgVerId);
    }

    @Override
    public CallResult getPSSFStylePkgs(String strPSSFStyleId, Vector<PSSFStylePkg> psSysCounterList) {
        return this.selectMulti(this.getSQL_getPSSFStylePkgs(strPSSFStyleId), psSysCounterList, PSSFStylePkg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSFStylePkgs(String strPSSFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFSTYLEPKG t1 where t1.PSSFSTYLEID='%1$s' ", (Object)strPSSFStyleId);
    }

    protected String getSQL_getPSDEGEIUDetails(String strPSDEGridId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIUDETAIL t1  where t1.PSDEGRIDID='%1$s' ", (Object)strPSDEGridId);
    }

    public CallResult getPSDEGEIUDetailsBySystem(String strPSSystemId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
        return this.selectMulti(this.getSQL_getPSDEGEIUDetailsBySystem(strPSSystemId), psDEGEIUDetailList, PSDEGEIUDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGEIUDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIUDETAIL t1 inner join  t_srfpsdegrid t2 on t1.psdegridid = t2.psdegridid inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEWizard(String strPSDEWizardId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARD t1 where  t1.PSDEWIZARDID='%1$s'", (Object)strPSDEWizardId);
    }

    protected String getSQL_getPSDEWizards(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARD t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEWizardsBySystem(String strPSSystemId, Vector<PSDEWizard> psDEWizardList) {
        return this.selectMulti(this.getSQL_getPSDEWizardsBySystem(strPSSystemId), psDEWizardList, PSDEWizard.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEWizardsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARD t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEWizardStep(String strPSDEWizardStepId, PSDEWizardStep psDEWizardStep) {
        return this.selectSingle(this.getSQL_getPSDEWizardStep(strPSDEWizardStepId), psDEWizardStep, "SYSTEM");
    }

    protected String getSQL_getPSDEWizardStep(String strPSDEWizardStepId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARDSTEP t1 where  t1.PSDEWIZARDSTEPID='%1$s'", (Object)strPSDEWizardStepId);
    }

    protected String getSQL_getPSDEWizardSteps(String strPSDEWizardId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARDSTEP t1 where  t1.PSDEWIZARDID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEWizardId);
    }

    public CallResult getPSDEWizardStepsBySystem(String strPSSystemId, Vector<PSDEWizardStep> psDEWizardStepList) {
        return this.selectMulti(this.getSQL_getPSDEWizardStepsBySystem(strPSSystemId), psDEWizardStepList, PSDEWizardStep.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEWizardStepsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEWIZARDSTEP  t1 inner join T_SRFPSDEWIZARD t2 on t1.PSDEWIZARDID= t2.PSDEWIZARDID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEWizardForms(String strPSDEWizardId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARDFORM t1 where  t1.PSDEWIZARDID='%1$s' ORDER BY t1.STEPORDERVALUE,t1.PSDEWIZARDFORMNAME", (Object)strPSDEWizardId);
    }

    public CallResult getPSDEWizardFormsBySystem(String strPSSystemId, Vector<PSDEWizardForm> psDEWizardFormList) {
        return this.selectMulti(this.getSQL_getPSDEWizardFormsBySystem(strPSSystemId), psDEWizardFormList, PSDEWizardForm.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEWizardFormsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from V_SRFPSDEWIZARDFORM  t1 inner join T_SRFPSDEWIZARD t2 on t1.PSDEWIZARDID= t2.PSDEWIZARDID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.STEPORDERVALUE,t1.PSDEWIZARDFORMNAME", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysDataSyncAgents2(String strPSSystemId, Vector<PSSysDataSyncAgent> psSysDataSyncAgentList) {
        return this.selectMulti(this.getSQL_getAllPSSysDataSyncAgents(strPSSystemId), psSysDataSyncAgentList, PSSysDataSyncAgent.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDataSyncAgents(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDATASYNCAGENT t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDataSyncAgent(String strPSSysDataSyncAgentId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDATASYNCAGENT t1 where  t1.PSSYSDATASYNCAGENTID='%1$s'", (Object)strPSSysDataSyncAgentId);
    }

    @Override
    public CallResult getPSDEDataSync(String strPSDEDataSyncId, PSDEDataSync psDEDataSync) {
        return this.selectSingle(this.getSQL_getPSDEDataSync(strPSDEDataSyncId), psDEDataSync, "SYSTEM");
    }

    protected String getSQL_getPSDEDataSync(String strPSDEDataSyncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASYNC t1 where  t1.PSDEDATASYNCID='%1$s'", (Object)strPSDEDataSyncId);
    }

    protected String getSQL_getPSDEDataSyncs(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASYNC t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEDataSyncsBySystem(String strPSSystemId, Vector<PSDEDataSync> psDEDataSyncList) {
        return this.selectMulti(this.getSQL_getPSDEDataSyncsBySystem(strPSSystemId), psDEDataSyncList, PSDEDataSync.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataSyncsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATASYNC t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDevUser(String strPSDevUserId, PSDevUser psDevUser) {
        return this.selectSingle(this.getSQL_getPSDevUser(strPSDevUserId), psDevUser, "SYSTEM");
    }

    protected String getSQL_getPSDevUser(String strPSDevUserId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVUSER t1 where  t1.PSDEVUSERID='%1$s'", (Object)strPSDevUserId);
    }

    @Override
    public CallResult getPSSysSFCodes(String strPSSysSFPubId, Vector<PSSysSFCode> psSysSFCodeList) {
        return this.selectMulti(this.getSQL_getPSSysSFCodes(strPSSysSFPubId), psSysSFCodeList, PSSysSFCode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSFCodes(String strPSSysSFPubId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFCODE t1 where t1.PSSYSSFPUBID='%1$s' AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1) ", (Object)strPSSysSFPubId);
    }

    public CallResult getAllPSSysUserDRs2(String strPSSystemId, Vector<PSSysUserDR> psSysUserDRList) {
        return this.selectMulti(this.getSQL_getAllPSSysUserDRs(strPSSystemId), psSysUserDRList, PSSysUserDR.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUserDRs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERDR t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserDR(String strPSSysUserDRId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUSERDR t1 where  t1.PSSYSUSERDRID='%1$s'", (Object)strPSSysUserDRId);
    }

    public CallResult getAllPSSysBDSchemes2(String strPSSystemId, Vector<PSSysBDScheme> psSysBDSchemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysBDSchemes(strPSSystemId), psSysBDSchemeList, PSSysBDScheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysBDSchemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDSCHEME t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDScheme(String strPSSysBDSchemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDSCHEME t1 where  t1.PSSYSBDSCHEMEID='%1$s'", (Object)strPSSysBDSchemeId);
    }

    public CallResult getAllPSAppLans2(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
        if (this.getModelInstVer() < 96) {
            return new CallResult();
        }
        return this.selectMultiValid(this.getSQL_getAllPSAppLans(strPSApplicationId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppLans(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLAN t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppLan(String strPSAppLanId, PSAppLan psAppLan) {
        if (this.getModelInstVer() < 96) {
            return CallResult.create((int)3);
        }
        return this.selectSingle(this.getSQL_getPSAppLan(strPSAppLanId), psAppLan, "SYSTEM");
    }

    protected String getSQL_getPSAppLan(String strPSAppLanId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLAN t1 where  t1.PSAPPLANID='%1$s'", (Object)strPSAppLanId);
    }

    @Override
    public CallResult getPSBDType(String strPSBDTypeId, PSBDType psBDType) {
        return this.selectSingle(this.getSQL_getPSBDType(strPSBDTypeId), psBDType, "SYSTEM");
    }

    protected String getSQL_getPSBDType(String strPSBDTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSBDTYPE t1 where  t1.PSBDTYPEID='%1$s'", (Object)strPSBDTypeId);
    }

    public CallResult getPSSysBDModulesBySystem(String strPSSystemId, Vector<PSSysBDModule> psSysBDModuleList) {
        return this.selectMulti(this.getSQL_getPSSysBDModulesBySystem(strPSSystemId), psSysBDModuleList, PSSysBDModule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDModulesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDMODULE t1  INNER JOIN T_SRFPSSYSBDSCHEME t2 on t1.PSSYSBDSCHEMEID=t2.PSSYSBDSCHEMEID WHERE  t2.PSSYSTEMID='%1$s' ORDER BY PSSYSBDMODULENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDPartsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDPART t1  INNER JOIN T_SRFPSSYSBDSCHEME t2 on t1.PSSYSBDSCHEMEID=t2.PSSYSBDSCHEMEID WHERE  t2.PSSYSTEMID='%1$s' ORDER BY PSSYSBDPARTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDModules(String strPSSysBDSchemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDMODULE t1 where  t1.PSSYSBDSCHEMEID='%1$s' order by PSSYSBDMODULENAME", (Object)strPSSysBDSchemeId);
    }

    public CallResult getPSSysBDPartsBySystem(String strPSSystemId, Vector<PSSysBDPart> psSysBDPartList) {
        return this.selectMulti(this.getSQL_getPSSysBDPartsBySystem(strPSSystemId), psSysBDPartList, PSSysBDPart.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDParts(String strPSSysBDSchemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDPART t1 where  t1.PSSYSBDSCHEMEID='%1$s' order by PSSYSBDPARTNAME", (Object)strPSSysBDSchemeId);
    }

    public CallResult getPSSysBDTablesBySystem(String strPSSystemId, Vector<PSSysBDTable> psSysBDTableList) {
        return this.selectMulti(this.getSQL_getPSSysBDTablesBySystem(strPSSystemId), psSysBDTableList, PSSysBDTable.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDTablesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLE t1  INNER JOIN T_SRFPSSYSBDSCHEME t2 on t1.PSSYSBDSCHEMEID=t2.PSSYSBDSCHEMEID WHERE  t2.PSSYSTEMID='%1$s' ORDER BY PSSYSBDTABLENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDTables(String strPSSysBDSchemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLE t1 where  t1.PSSYSBDSCHEMEID='%1$s' order by PSSYSBDTABLENAME", (Object)strPSSysBDSchemeId);
    }

    public CallResult getPSSysBDTableRSesBySystem(String strPSSystemId, Vector<PSSysBDTableRS> psSysBDTableList) {
        return this.selectMultiValid(this.getSQL_getPSSysBDTableRSesBySystem(strPSSystemId), psSysBDTableList, PSSysBDTableRS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDTableRSesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLERS t1  INNER JOIN T_SRFPSSYSBDSCHEME t2 on t1.PSSYSBDSCHEMEID=t2.PSSYSBDSCHEMEID WHERE  t2.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDTableRSes(String strPSSysBDSchemeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLERS t1 where  t1.PSSYSBDSCHEMEID='%1$s' ", (Object)strPSSysBDSchemeId);
    }

    protected String getSQL_getPSSysBDColumns(String strPSSysBDTableId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDCOLUMN t1 where  t1.PSSYSBDTABLEID='%1$s' ORDER BY PSSYSBDCOLUMNNAME ", (Object)strPSSysBDTableId);
    }

    public CallResult getPSSysBDColumnsBySystem(String strPSSystemId, Vector<PSSysBDColumn> psSysBDColumnList) {
        return this.selectMulti(this.getSQL_getPSSysBDColumnsBySystem(strPSSystemId), psSysBDColumnList, PSSysBDColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDCOLUMN t1 LEFT JOIN T_SRFPSSYSBDTABLE t2 on t1.PSSYSBDTABLEID = t2.PSSYSBDTABLEID  LEFT JOIN T_SRFPSSYSBDSCHEME t3 on t2.PSSYSBDSCHEMEID = t3.PSSYSBDSCHEMEID   where  t3.PSSYSTEMID ='%1$s' ORDER BY t1.PSSYSBDCOLUMNNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDColSets(String strPSSysBDTableId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDCOLSET t1 where  t1.PSSYSBDTABLEID='%1$s' ORDER BY PSSYSBDCOLSETNAME ", (Object)strPSSysBDTableId);
    }

    public CallResult getPSSysBDColSetsBySystem(String strPSSystemId, Vector<PSSysBDColSet> psSysBDColSetList) {
        return this.selectMulti(this.getSQL_getPSSysBDColSetsBySystem(strPSSystemId), psSysBDColSetList, PSSysBDColSet.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDColSetsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDCOLSET t1 LEFT JOIN T_SRFPSSYSBDTABLE t2 on t1.PSSYSBDTABLEID = t2.PSSYSBDTABLEID  LEFT JOIN T_SRFPSSYSBDSCHEME t3 on t2.PSSYSBDSCHEMEID = t3.PSSYSBDSCHEMEID   where  t3.PSSYSTEMID ='%1$s' ORDER BY t1.PSSYSBDCOLSETNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDTableDEs(String strPSSysBDTableId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDE t1 where  t1.PSSYSBDTABLEID='%1$s' ORDER BY PSSYSBDTABLEDENAME ", (Object)strPSSysBDTableId);
    }

    public CallResult getPSSysBDTableDEsBySystem(String strPSSystemId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
        return this.selectMulti(this.getSQL_getPSSysBDTableDEsBySystem(strPSSystemId), psSysBDTableDEList, PSSysBDTableDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDTableDEsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDE t1 LEFT JOIN T_SRFPSSYSBDTABLE t2 on t1.PSSYSBDTABLEID = t2.PSSYSBDTABLEID  LEFT JOIN T_SRFPSSYSBDSCHEME t3 on t2.PSSYSBDSCHEMEID = t3.PSSYSBDSCHEMEID   where  t3.PSSYSTEMID ='%1$s' ORDER BY t1.PSSYSBDTABLEDENAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBDTableDERs(String strPSSysBDTableId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDER t1 where  t1.PSSYSBDTABLEID='%1$s' ORDER BY  t1.DERLEVEL,PSSYSBDTABLEDERNAME ", (Object)strPSSysBDTableId);
    }

    public CallResult getPSSysBDTableDERsBySystem(String strPSSystemId, Vector<PSSysBDTableDER> psSysBDTableDERList) {
        return this.selectMulti(this.getSQL_getPSSysBDTableDERsBySystem(strPSSystemId), psSysBDTableDERList, PSSysBDTableDER.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBDTableDERsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDER t1 LEFT JOIN T_SRFPSSYSBDTABLE t2 on t1.PSSYSBDTABLEID = t2.PSSYSBDTABLEID  LEFT JOIN T_SRFPSSYSBDSCHEME t3 on t2.PSSYSBDSCHEMEID = t3.PSSYSBDSCHEMEID   where  t3.PSSYSTEMID ='%1$s' ORDER BY t1.DERLEVEL,  t1.PSSYSBDTABLEDERNAME ", (Object)strPSSystemId);
    }

    public CallResult getPSDEBDTablesBySystem(String strPSSystemId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
        return this.selectMulti(this.getSQL_getPSDEBDTablesBySystem(strPSSystemId), psSysBDTableDEList, PSSysBDTableDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEBDTablesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDE t1  INNER JOIN T_SRFPSDATAENTITY t2 on t1.PSDEID=t2.PSDATAENTITYID  WHERE  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ORDER BY PSSYSBDTABLEDENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEBDTables(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSBDTABLEDE t1 where  t1.PSDEID='%1$s' order by PSSYSBDTABLEDENAME", (Object)strPSDEId);
    }

    @Override
    public CallResult getPSModelPlugin(String strPSModelPluginId, PSModelPlugin psModelPlugin) {
        return this.selectSingle(this.getSQL_getPSModelPlugin(strPSModelPluginId), psModelPlugin, "SYSTEM");
    }

    protected String getSQL_getPSModelPlugin(String strPSModelPluginId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODELPLUGIN t1 where  t1.PSMODELPLUGINID='%1$s'", (Object)strPSModelPluginId);
    }

    @Override
    public CallResult getAllPSModelPlugins(Vector<PSModelPlugin> psModelPluginList) {
        return this.selectMulti(this.getSQL_getAllPSModelPlugins(), psModelPluginList, PSModelPlugin.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSModelPlugins() {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODELPLUGIN t1 ");
    }

    @Override
    public CallResult getPSDevCenterBTType(String strPSDevCenterBTTypeId, PSDCBKType psDevCenterBTType) {
        return this.selectSingle(this.getSQL_getPSDevCenterBTType(strPSDevCenterBTTypeId), psDevCenterBTType, "SYSTEM");
    }

    protected String getSQL_getPSDevCenterBTType(String strPSDevCenterBTTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCBKTYPE t1 where  t1.PSDCBKTYPEID='%1$s'", (Object)strPSDevCenterBTTypeId);
    }

    public CallResult getAllPSViewMsgs2(String strPSSystemId, Vector<PSViewMsg> psViewMsgList) {
        return this.selectMulti(this.getSQL_getAllPSViewMsgs(strPSSystemId), psViewMsgList, PSViewMsg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSViewMsgs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVIEWMSG t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSViewMsg(String strPSViewMsgId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVIEWMSG t1 where  t1.PSVIEWMSGID='%1$s'", (Object)strPSViewMsgId);
    }

    public CallResult getAllPSViewMsgGroups2(String strPSSystemId, Vector<PSViewMsgGroup> psViewMsgGroupList) {
        return this.selectMulti(this.getSQL_getAllPSViewMsgGroups(strPSSystemId), psViewMsgGroupList, PSViewMsgGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSViewMsgGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSVIEWMSGGROUP t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSViewMsgGroup(String strPSViewMsgGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSVIEWMSGGROUP t1 where  t1.PSVIEWMSGGROUPID='%1$s'", (Object)strPSViewMsgGroupId);
    }

    protected String getSQL_getPSViewMsgGroupDetails(String strPSViewMsgGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSVIEWMSGGRPDETAIL t1 where  t1.PSVIEWMSGGROUPID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSViewMsgGroupId);
    }

    public CallResult getPSViewMsgGroupDetailsBySystem(String strPSSystemId, Vector<PSViewMsgGroupDetail> psViewMsgGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSViewMsgGroupDetailsBySystem(strPSSystemId), psViewMsgGroupDetailList, PSViewMsgGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSViewMsgGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSVIEWMSGGRPDETAIL  t1 inner join T_SRFPSVIEWMSGGROUP t2 on t1.PSVIEWMSGGROUPID= t2.PSVIEWMSGGROUPID where t2.PSSYSTEMID= '%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDataExport(String strPSDEDataExportId, PSDEDataExport psDEDataExport) {
        return this.selectSingle(this.getSQL_getPSDEDataExport(strPSDEDataExportId), psDEDataExport, "SYSTEM");
    }

    protected String getSQL_getPSDEDataExport(String strPSDEDataExportId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAEXP t1 where  t1.PSDEDATAEXPID='%1$s'", (Object)strPSDEDataExportId);
    }

    protected String getSQL_getPSDEDataExports(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAEXP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEDataExportsBySystem(String strPSSystemId, Vector<PSDEDataExport> psDEDataExportList) {
        return this.selectMulti(this.getSQL_getPSDEDataExportsBySystem(strPSSystemId), psDEDataExportList, PSDEDataExport.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataExportsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAEXP t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDataImport(String strPSDEDataImportId, PSDEDataImport psDEDataImport) {
        return this.selectSingle(this.getSQL_getPSDEDataImport(strPSDEDataImportId), psDEDataImport, "SYSTEM");
    }

    protected String getSQL_getPSDEDataImport(String strPSDEDataImportId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAIMP t1 where  t1.PSDEDATAIMPID='%1$s'", (Object)strPSDEDataImportId);
    }

    protected String getSQL_getPSDEDataImports(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAIMP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEDataImportsBySystem(String strPSSystemId, Vector<PSDEDataImport> psDEDataImportList) {
        return this.selectMulti(this.getSQL_getPSDEDataImportsBySystem(strPSSystemId), psDEDataImportList, PSDEDataImport.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataImportsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAIMP t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataImportItems(String strPSDEDataImportId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEDATAIMPITEM t1  inner join t_SRFPSDEDATAIMP t2 on t1.PSDEDATAIMPID=t2.PSDEDATAIMPID  where t2.PSDEDATAIMPID='%1$s' and t1.VALIDFLAG = 1 order by t1.ORDERVALUE,t1.PSDEDATAIMPITEMNAME", (Object)strPSDEDataImportId);
    }

    public CallResult getPSDEDataImportItemsBySystem(String strPSSystemId, Vector<PSDEDataImportItem> psDEDataImportItemList) {
        return this.selectMulti(this.getSQL_getPSDEDataImportItemsBySystem(strPSSystemId), psDEDataImportItemList, PSDEDataImportItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataImportItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEDATAIMPITEM t1 inner join t_SRFPSDEDATAIMP t2 on t1.PSDEDATAIMPID=t2.PSDEDATAIMPID  inner join T_SRFPSDATAENTITY t3 on t2.PSDEID=t3.PSDATAENTITYID where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) and t1.VALIDFLAG = 1 order by t1.ORDERVALUE,t1.PSDEDATAIMPITEMNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataExportItems(String strPSDEDataExportId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGRIDCOL t1  inner join t_SRFPSDEGRID t2 on t1.PSDEGRIDID=t2.PSDEGRIDID  inner join t_srfpsdedataexp t3 on t2.psdegridid = t3.psdegridid   where  t3.PSDEDATAEXPID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEDataExportId);
    }

    public CallResult getPSDEDataExportItemsBySystem(String strPSSystemId, Vector<PSDEGridColumn> psDEGridColumnList) {
        return this.selectMulti(this.getSQL_getPSDEDataExportItemsBySystem(strPSSystemId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataExportItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t3.psdedataexpid from T_SRFPSDEGRIDCOL t1  inner join t_SRFPSDEGRID t2 on t1.PSDEGRIDID=t2.PSDEGRIDID  inner join t_srfpsdedataexp t3 on t2.psdegridid = t3.psdegridid  inner join t_srfpsdataentity t4 on t3.psdeid=t4.psdataentityid where  t4.PSSYSTEMID='%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFInputTipsByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFINPUTTIP t1  where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEFInputTipsBySystem2(String strPSSystemId, Vector<PSDEFInputTip> psDEFInputTipList) {
        return this.selectMulti(this.getSQL_getPSDEFInputTipsBySystem2(strPSSystemId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFInputTipsBySystem2(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFINPUTTIP t1   inner join T_SRFPSDATAENTITY t2 on  t1.psdeid = t2.psdataentityid  where  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)", (Object)strPSSystemId);
    }

    public CallResult getPSDEFInputTipsBySystem3(String strPSSystemId, Vector<PSDEFInputTip> psDEFInputTipList) {
        return this.selectMulti(this.getSQL_getPSDEFInputTipsBySystem3(strPSSystemId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFInputTipsBySystem3(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFINPUTTIP t1 where  t1.PSSYSTEMID='%1$s' and t1.PSDEID is null ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSModel(String strPSModelId, PSModel psModel) {
        return this.selectSingle(this.getSQL_getPSModel(strPSModelId), psModel, "SYSTEM");
    }

    protected String getSQL_getPSModel(String strPSModelId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSMODEL t1 where  t1.PSMODELID='%1$s'", (Object)strPSModelId);
    }

    @Override
    public CallResult getPSModelPlugins(String strPSModelId, Vector<PSModelPlugin> psModelPluginList) {
        return this.selectMulti(this.getSQL_getPSModelPlugins(strPSModelId), psModelPluginList, PSModelPlugin.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSModelPlugins(String strPSModelId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMODELPLUGIN t1 where  t1.PSMODELID='%1$s' ", (Object)strPSModelId);
    }

    protected CallResult getPSSysModelLogs(String strPSSystemId, Vector<PSSysModelLog> psSysModelLogList) {
        return this.selectMulti(this.getSQL_getPSSysModelLogs(strPSSystemId), psSysModelLogList, PSSysModelLog.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getPSSysModelLogs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.PSSYSMODELLOGNAME,t1.UPDATEDATE from T_SRFPSSYSMODELLOG t1 where  t1.PSSYSTEMID='%1$s' AND t1.UPDATEDATE IS NOT NULL ORDER BY t1.UPDATEDATE DESC ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEActionWizard(String strPSDEActionWizardId, PSDEActionWizard psDEActionWizard) {
        return this.selectSingle(this.getSQL_getPSDEActionWizard(strPSDEActionWizardId), psDEActionWizard, "SYSTEM");
    }

    protected String getSQL_getPSDEActionWizard(String strPSDEActionWizardId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONWIZARD t1 where  t1.PSDEACTIONWIZARDID='%1$s'", (Object)strPSDEActionWizardId);
    }

    protected String getSQL_getPSDEActionWizards(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONWIZARD t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEActionWizardsBySystem(String strPSSystemId, Vector<PSDEActionWizard> psDEActionWizardList) {
        return this.selectMulti(this.getSQL_getPSDEActionWizardsBySystem(strPSSystemId), psDEActionWizardList, PSDEActionWizard.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionWizardsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONWIZARD t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionWizardItems(String strPSDEActionWizardId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAWITEM t1 where  t1.PSDEACTIONWIZARDID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEActionWizardId);
    }

    public CallResult getPSDEActionWizardItemsBySystem(String strPSSystemId, Vector<PSDEAWItem> psDEActionWizardItemList) {
        return this.selectMulti(this.getSQL_getPSDEActionWizardItemsBySystem(strPSSystemId), psDEActionWizardItemList, PSDEAWItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionWizardItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEAWITEM  t1 inner join T_SRFPSDEACTIONWIZARD t2 on t1.PSDEACTIONWIZARDID= t2.PSDEACTIONWIZARDID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionWizardGroups(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAWGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDEId);
    }

    public CallResult getPSDEActionWizardGroupsBySystem(String strPSSystemId, Vector<PSDEAWGroup> psDEActionWizardGroupList) {
        return this.selectMulti(this.getSQL_getPSDEActionWizardGroupsBySystem(strPSSystemId), psDEActionWizardGroupList, PSDEAWGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionWizardGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAWGROUP t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionWizardGroupDetails(String strPSDEActionWizardGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAWGRPDETAIL t1 where  t1.PSDEAWGROUPID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEActionWizardGroupId);
    }

    public CallResult getPSDEActionWizardGroupDetailsBySystem(String strPSSystemId, Vector<PSDEAWGrpDetail> psDEActionWizardGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEActionWizardGroupDetailsBySystem(strPSSystemId), psDEActionWizardGroupDetailList, PSDEAWGrpDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionWizardGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEAWGRPDETAIL  t1 inner join T_SRFPSDEAWGROUP t2 on t1.PSDEAWGROUPID= t2.PSDEAWGROUPID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getAllPSWXAccounts2(String strPSSystemId, Vector<PSWXAccount> psWXAccountList) {
        return this.selectMulti(this.getSQL_getAllPSWXAccounts(strPSSystemId), psWXAccountList, PSWXAccount.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSWXAccounts(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXACCOUNT t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXAccount(String strPSWXAccountId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXACCOUNT t1 where  t1.PSWXACCOUNTID='%1$s'", (Object)strPSWXAccountId);
    }

    public CallResult getPSWXMenuItemsBySystem(String strPSSystemId, Vector<PSWXMenuItem> psWXMenuItemList) {
        return this.selectMulti(this.getSQL_getPSWXMenuItemsBySystem(strPSSystemId), psWXMenuItemList, PSWXMenuItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWXMenuItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from  T_SRFPSWXMENUITEM t1  inner join T_SRFPSWXMENU t2 ON t1.PSWXMENUID=t2.PSWXMENUID   inner join T_SRFPSWXACCOUNT t3 on t2.PSWXACCOUNTID=t3.PSWXACCOUNTID where  t3.PSSYSTEMID='%1$s' order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXMenuItems(String strPSWXMenuId) {
        if (strPSWXMenuId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENUITEM_TMP t1 where  t1.PSWXMENUID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSWXMenuId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENUITEM t1 where  t1.PSWXMENUID='%1$s' order by ORDERVALUE", (Object)strPSWXMenuId);
    }

    public CallResult getPSWXEntAppsBySystem(String strPSSystemId, Vector<PSWXEntApp> psWXEntAppList) {
        return this.selectMulti(this.getSQL_getPSWXEntAppsBySystem(strPSSystemId), psWXEntAppList, PSWXEntApp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWXEntAppsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXENTAPP t1  inner join T_SRFPSWXACCOUNT t2 on t1.PSWXACCOUNTID=t2.PSWXACCOUNTID where  t2.PSSYSTEMID='%1$s' order by ORDERVALUE,PSWXENTAPPNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXEntApps(String strPSWXAccountId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXENTAPP t1 where  t1.PSWXACCOUNTID='%1$s' order by ORDERVALUE,PSWXENTAPPNAME", (Object)strPSWXAccountId);
    }

    public CallResult getPSWXMenuFuncsBySystem(String strPSSystemId, Vector<PSWXMenuFunc> psWXMenuFuncList) {
        return this.selectMulti(this.getSQL_getPSWXMenuFuncsBySystem(strPSSystemId), psWXMenuFuncList, PSWXMenuFunc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWXMenuFuncsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENUFUNC t1  inner join T_SRFPSWXACCOUNT t2 on t1.PSWXACCOUNTID=t2.PSWXACCOUNTID where  t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXMenuFuncs(String strPSWXAccountId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENUFUNC t1 where  t1.PSWXACCOUNTID='%1$s' AND t1.PSWXENTAPPID IS NULL ", (Object)strPSWXAccountId);
    }

    protected String getSQL_getPSWXMenuFuncsByApp(String strPSWXEntAppId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENUFUNC t1 where  t1.PSWXENTAPPID='%1$s'", (Object)strPSWXEntAppId);
    }

    public CallResult getPSWXLogicsBySystem(String strPSSystemId, Vector<PSWXLogic> psWXLogicList) {
        return this.selectMulti(this.getSQL_getPSWXLogicsBySystem(strPSSystemId), psWXLogicList, PSWXLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWXLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXLOGIC t1  inner join T_SRFPSWXACCOUNT t2 on t1.PSWXACCOUNTID=t2.PSWXACCOUNTID where  t2.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXLogics(String strPSWXAccountId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXLOGIC t1 where  t1.PSWXACCOUNTID='%1$s'  AND t1.PSWXENTAPPID IS NULL ", (Object)strPSWXAccountId);
    }

    protected String getSQL_getPSWXLogicsByApp(String strPSWXEntAppId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXLOGIC t1 where  t1.PSWXENTAPPID='%1$s'  ", (Object)strPSWXEntAppId);
    }

    public CallResult getPSWXMenusBySystem(String strPSSystemId, Vector<PSWXMenu> psWXMenuList) {
        return this.selectMulti(this.getSQL_getPSWXMenusBySystem(strPSSystemId), psWXMenuList, PSWXMenu.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSWXMenusBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENU t1  inner join T_SRFPSWXACCOUNT t2 on t1.PSWXACCOUNTID=t2.PSWXACCOUNTID where  t2.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSWXMenus(String strPSWXAccountId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENU t1 where  t1.PSWXACCOUNTID='%1$s'  AND t1.PSWXENTAPPID IS NULL ", (Object)strPSWXAccountId);
    }

    protected String getSQL_getPSWXMenusByApp(String strPSWXEntAppId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENU t1 where  t1.PSWXENTAPPID='%1$s' ", (Object)strPSWXEntAppId);
    }

    protected String getSQL_getPSWXMenu(String strPSWXMenuId) {
        if (strPSWXMenuId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENU_TMP t1 where  t1.PSWXMENUID='%1$s' ", (Object)strPSWXMenuId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSWXMENU t1 where  t1.PSWXMENUID='%1$s'", (Object)strPSWXMenuId);
    }

    @Override
    public CallResult getPSDevCenterBKTasks(String strPSDevCenterBKTaskId, Vector<PSDCBKTask> psPSDevCenterBKTaskList) {
        return this.selectMulti(this.getSQL_getPSDevCenterBKTasks(strPSDevCenterBKTaskId), psPSDevCenterBKTaskList, PSDCBKTask.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevCenterBKTasks(String strPSDevCenterBKTaskId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCBKTASK t1 where  t1.PPSDCBKTASKID='%1$s' ORDER BY ORDERVALUE", (Object)strPSDevCenterBKTaskId);
    }

    public CallResult getAllPSCtrlMsgs2(String strPSSystemId, Vector<PSCtrlMsg> psCtrlMsgList) {
        return this.selectMulti(this.getSQL_getAllPSCtrlMsgs(strPSSystemId), psCtrlMsgList, PSCtrlMsg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSCtrlMsgs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLMSG t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSCtrlMsg(String strPSCtrlMsgId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLMSG t1 where  t1.PSCTRLMSGID='%1$s'", (Object)strPSCtrlMsgId);
    }

    public CallResult getAllPSSysUnits2(String strPSSystemId, Vector<PSSysUnit> psSysUnitList) {
        return this.selectMulti(this.getSQL_getAllPSSysUnits(strPSSystemId), psSysUnitList, PSSysUnit.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUnits(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUNIT t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUnit(String strPSSysUnitId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUNIT t1 where  t1.PSSYSUNITID='%1$s'", (Object)strPSSysUnitId);
    }

    public CallResult getAllPSLanguageReses2(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
        return this.selectMulti(this.getSQL_getAllPSLanguageReses(strPSSystemId), psLanguageResList, PSLanguageRes.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSLanguageReses(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSLANGUAGERES t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSLanguageRes(String strPSLanguageResId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSLANGUAGERES t1 where  t1.PSLANGUAGERESID='%1$s'", (Object)strPSLanguageResId);
    }

    public CallResult getAllPSLanguageItems2(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
        return this.selectMulti(this.getSQL_getAllPSLanguageItems(strPSSystemId), psLanguageItemList, PSLanguageItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSLanguageItems(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSLANGUAGEITEM t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSLanguageItem(String strPSLanguageItemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSLANGUAGEITEM t1 where  t1.PSLANGUAGEITEMID='%1$s'", (Object)strPSLanguageItemId);
    }

    public CallResult getAllPSAppPkgs2(String strPSApplicationId, Vector<PSAppPkg> psAppPkgs) {
        return this.selectMulti(this.getSQL_getAllPSAppPkgs(strPSApplicationId), psAppPkgs, PSAppPkg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppPkgs(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPKG t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppPkg(String strPSAppPkgId, PSAppPkg psAppPkg) {
        return this.selectSingle(this.getSQL_getPSAppPkg(strPSAppPkgId), psAppPkg, "SYSTEM");
    }

    protected String getSQL_getPSAppPkg(String strPSAppPkgId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPKG t1 where  t1.PSAPPPKGID='%1$s'", (Object)strPSAppPkgId);
    }

    @Override
    public CallResult getPSSysSFPubPkgs(String strPSSysSFPubId, Vector<PSSysSFPubPkg> psSysSFPubPkgList) {
        return this.selectMulti(this.getSQL_getPSSysSFPubPkgs(strPSSysSFPubId), psSysSFPubPkgList, PSSysSFPubPkg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSFPubPkgs(String strPSSysSFPubId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSFPUBPKG t1 where t1.PSSYSSFPUBID='%1$s' ", (Object)strPSSysSFPubId);
    }

    @Override
    public CallResult getPSHelpArticleType(String strPSHelpArticleTypeId, PSHelpArticleType psHelpArticleType) {
        return this.selectSingle(this.getSQL_getPSHelpArticleType(strPSHelpArticleTypeId), psHelpArticleType, "SYSTEM");
    }

    protected String getSQL_getPSHelpArticleType(String strPSHelpArticleTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPARTICLETYPE t1 where  t1.PSHELPARTICLETYPEID='%1$s'", (Object)strPSHelpArticleTypeId);
    }

    @Override
    public CallResult getPSHelpSectionType(String strPSHelpSectionTypeId, PSHelpSectionType psHelpSectionType) {
        return this.selectSingle(this.getSQL_getPSHelpSectionType(strPSHelpSectionTypeId), psHelpSectionType, "SYSTEM");
    }

    protected String getSQL_getPSHelpSectionType(String strPSHelpSectionTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPSECTIONTYPE t1 where  t1.PSHELPSECTIONTYPEID='%1$s'", (Object)strPSHelpSectionTypeId);
    }

    @Override
    public CallResult getAllPSHelpArticles(String strPSSystemId, Vector<PSHelpArticle> psHelpArticleList) {
        return this.selectMulti(this.getSQL_getAllPSHelpArticles(strPSSystemId), psHelpArticleList, PSHelpArticle.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSHelpArticles(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPARTICLE t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSHelpSections(String strPSSystemId, Vector<PSHelpSection> psHelpSectionList) {
        return this.selectMulti(this.getSQL_getAllPSHelpSections(strPSSystemId), psHelpSectionList, PSHelpSection.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSHelpSections(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPSECTION t1 INNER JOIN T_SRFPSHELPARTICLE t2 on t1.PSHELPARTICLEID = t2.PSHELPARTICLEID  where t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1  ORDER BY t1.ORDERVALUE ASC  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSHelpArticleTempls(Vector<PSHelpArticleTempl> psHelpArticleTemplList) {
        return this.selectMulti(this.getSQL_getPSHelpArticleTempls(), psHelpArticleTemplList, PSHelpArticleTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSHelpArticleTempls() {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPARTICLETEMPL t1 ");
    }

    @Override
    public CallResult getPSHelpSectionTempls(Vector<PSHelpSectionTempl> psHelpSectionTemplList) {
        return this.selectMulti(this.getSQL_getPSHelpSectionTempls(), psHelpSectionTemplList, PSHelpSectionTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSHelpSectionTempls() {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPSECTIONTEMPL t1");
    }

    @Override
    public CallResult getPSHelpPrjTempls(Vector<PSHelpPrjTempl> psHelpPrjTemplList) {
        return this.selectMulti(this.getSQL_getPSHelpPrjTempls(), psHelpPrjTemplList, PSHelpPrjTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSHelpPrjTempls() {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPPRJTEMPL t1 ");
    }

    @Override
    public CallResult getAllPSHelpModules(String strPSSystemId, Vector<PSHelpModule> psHelpModuleList) {
        return this.selectMulti(this.getSQL_getAllPSHelpModules(strPSSystemId), psHelpModuleList, PSHelpModule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSHelpModules(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPMODULE t1 INNER JOIN T_SRFPSHELPPRJ t2 on t1.PSHELPPRJID = t2.PSHELPPRJID  where t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1  ORDER BY t1.ORDERVALUE ASC  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getAllPSHelpPrjs(String strPSSystemId, Vector<PSHelpPrj> psHelpPrjList) {
        return this.selectMulti(this.getSQL_getAllPSHelpPrjs(strPSSystemId), psHelpPrjList, PSHelpPrj.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSHelpPrjs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPPRJ t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSHelpPrjType(String strPSHelpPrjTypeId, PSHelpPrjType psHelpPrjType) {
        return this.selectSingle(this.getSQL_getPSHelpPrjType(strPSHelpPrjTypeId), psHelpPrjType, "SYSTEM");
    }

    protected String getSQL_getPSHelpPrjType(String strPSHelpPrjTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPPRJTYPE t1 where  t1.PSHELPPRJTYPEID='%1$s'", (Object)strPSHelpPrjTemplId);
    }

    @Override
    public CallResult getPSHelpPrjTempl(String strPSHelpPrjTemplId, PSHelpPrjTempl psHelpPrjTempl) {
        return this.selectSingle(this.getSQL_getPSHelpPrjTempl(strPSHelpPrjTemplId), psHelpPrjTempl, "SYSTEM");
    }

    protected String getSQL_getPSHelpPrjTempl(String strPSHelpPrjTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPPRJTEMPL t1 where  t1.PSHELPPRJTEMPLID='%1$s'", (Object)strPSHelpPrjTemplId);
    }

    @Override
    public CallResult getPSHelpArticleTempl(String strPSHelpArticleTemplId, PSHelpArticleTempl psHelpArticleTempl) {
        return this.selectSingle(this.getSQL_getPSHelpArticleTempl(strPSHelpArticleTemplId), psHelpArticleTempl, "SYSTEM");
    }

    protected String getSQL_getPSHelpArticleTempl(String strPSHelpArticleTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPARTICLETEMPL t1 where  t1.PSHELPARTICLETEMPLID='%1$s'", (Object)strPSHelpArticleTemplId);
    }

    @Override
    public CallResult getPSHelpSectionTempl(String strPSHelpSectionTemplId, PSHelpSectionTempl psHelpSectionTempl) {
        return this.selectSingle(this.getSQL_getPSHelpSectionTempl(strPSHelpSectionTemplId), psHelpSectionTempl, "SYSTEM");
    }

    protected String getSQL_getPSHelpSectionTempl(String strPSHelpSectionTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPSECTIONTEMPL t1 where  t1.PSHELPSECTIONTEMPLID='%1$s'", (Object)strPSHelpSectionTemplId);
    }

    @Override
    public CallResult getAllPSHelpResources(String strPSSystemId, Vector<PSHelpResource> psHelpResourceList) {
        return this.selectMulti(this.getSQL_getAllPSHelpResources(strPSSystemId), psHelpResourceList, PSHelpResource.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSHelpResources(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSHELPRESOURCE t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSPFPkg(String strPSPFPkgId, PSPFPkg psSFPkg) {
        return this.selectSingle(this.getSQL_getPSPFPkg(strPSPFPkgId), psSFPkg, "SYSTEM");
    }

    protected String getSQL_getPSPFPkg(String strPSPFPkgId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPKG t1 where  t1.PSPFPKGID='%1$s'", (Object)strPSPFPkgId);
    }

    @Override
    public CallResult getPSPFPkgVer(String strPSPFPkgVerId, PSPFPkgVer psSFPkgVer) {
        return this.selectSingle(this.getSQL_getPSPFPkgVer(strPSPFPkgVerId), psSFPkgVer, "SYSTEM");
    }

    protected String getSQL_getPSPFPkgVer(String strPSPFPkgVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPKGVER t1 where  t1.PSPFPKGVERID='%1$s'", (Object)strPSPFPkgVerId);
    }

    @Override
    public CallResult getPSPFStylePkgs(String strPSPFStyleId, Vector<PSPFStylePkg> psSysCounterList) {
        return this.selectMulti(this.getSQL_getPSPFStylePkgs(strPSPFStyleId), psSysCounterList, PSPFStylePkg.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPFStylePkgs(String strPSPFStyleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFSTYLEPKG t1 where t1.PSPFSTYLEID='%1$s' ", (Object)strPSPFStyleId);
    }

    @Override
    public CallResult getPSPFCDN(String strPSPFCDNId, PSPFCDN psPFCDN) {
        return this.selectSingle(this.getSQL_getPSPFCDN(strPSPFCDNId), psPFCDN, "SYSTEM");
    }

    protected String getSQL_getPSPFCDN(String strPSPFCDNId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFCDN t1 where  t1.PSPFCDNID='%1$s'", (Object)strPSPFCDNId);
    }

    @Override
    public CallResult getPSPFPkgVerCDN(String strPSPFPkgVerCDNId, PSPFPkgVerCDN psSFPkgVerCDN) {
        return this.selectSingle(this.getSQL_getPSPFPkgVerCDN(strPSPFPkgVerCDNId), psSFPkgVerCDN, "SYSTEM");
    }

    protected String getSQL_getPSPFPkgVerCDN(String strPSPFPkgVerCDNId) {
        String[] ids = strPSPFPkgVerCDNId.split("[|]");
        if (ids.length == 2) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSPFPKGVERCDN t1 where  t1.PSPFPKGVERID='%1$s' AND t1.PSPFCDNID='%2$s'", (Object)ids[0], (Object)ids[1]);
        }
        if (ids.length == 3) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSPFPKGVERCDN t1 where  t1.PSPFPKGVERID='%1$s' AND t1.PSPFCDNID='%2$s' AND t1.PSDEVCENTERID='%3$s' ", (Object)ids[0], (Object)ids[1], (Object)ids[2]);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSPFPKGVERCDN t1 where  t1.PSPFPKGVERCDNID='%1$s'", (Object)strPSPFPkgVerCDNId);
    }

    public CallResult getAllPSSysLans2(String strPSSystemId, Vector<PSAppLan> psAppLans) {
        return this.selectMulti(this.getSQL_getAllPSSysLans(strPSSystemId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysLans(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLAN t1 INNER JOIN T_SRFPSSYSAPP t2 ON t1.PSSYSAPPID = t2.PSSYSAPPID  where  t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDepSysType(String strPSDepSysTypeId, PSDepSysType psDepSysType) {
        return this.selectSingle(this.getSQL_getPSDepSysType(strPSDepSysTypeId), psDepSysType, "SYSTEM");
    }

    protected String getSQL_getPSDepSysType(String strPSDepSysTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSYSTYPE t1 where  t1.PSDEPSYSTYPEID='%1$s'", (Object)strPSDepSysTypeId);
    }

    @Override
    public CallResult getPSDepSlnType(String strPSDepSlnTypeId, PSDepSlnType psDepSlnType) {
        return this.selectSingle(this.getSQL_getPSDepSlnType(strPSDepSlnTypeId), psDepSlnType, "SYSTEM");
    }

    protected String getSQL_getPSDepSlnType(String strPSDepSlnTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSLNTYPE t1 where  t1.PSDEPSLNTYPEID='%1$s'", (Object)strPSDepSlnTypeId);
    }

    @Override
    public CallResult getAllPSDepSlnHosts(String strPSDepSlnId, Vector<PSDepSlnHost> psDepSlnHosts) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnHosts(strPSDepSlnId), psDepSlnHosts, PSDepSlnHost.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnHosts(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNHOST t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnDBInsts(String strPSDepSlnId, Vector<PSDepSlnDBInst> psDepSlnDBInsts) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnDBInsts(strPSDepSlnId), psDepSlnDBInsts, PSDepSlnDBInst.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnDBInsts(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNDBINST t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnMQInsts(String strPSDepSlnId, Vector<PSDepSlnMQInst> psDepSlnMQInsts) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnMQInsts(strPSDepSlnId), psDepSlnMQInsts, PSDepSlnMQInst.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnMQInsts(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNMQINST t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnASes(String strPSDepSlnId, Vector<PSDepSlnAS> psDepSlnASes) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnASes(strPSDepSlnId), psDepSlnASes, PSDepSlnAS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnASes(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNAS t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnASGroups(String strPSDepSlnId, Vector<PSDepSlnASGrp> psDepSlnASGroups) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnASGroups(strPSDepSlnId), psDepSlnASGroups, PSDepSlnASGrp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnASGroups(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNASGRP t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnASGroupItems(String strPSDepSlnId, Vector<PSDepSlnASItem> psDepSlnASItems) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnASGroupItems(strPSDepSlnId), psDepSlnASItems, PSDepSlnASItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnASGroupItems(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNASITEM t1 INNER JOIN t_SRFPSDEPSLNASGRP t2 on t1.PSDEPSLNASGRPID = t2.PSDEPSLNASGRPID  where  t2.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnSyses(String strPSDepSlnId, Vector<PSDepSlnSys> psDepSlnSyses) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnSyses(strPSDepSlnId), psDepSlnSyses, PSDepSlnSys.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnSyses(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNSYS t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnSysDBs(String strPSDepSlnId, Vector<PSDepSlnSysDB> psDepSlnSysDBs) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnSysDBs(strPSDepSlnId), psDepSlnSysDBs, PSDepSlnSysDB.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnSysDBs(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNSYSDB t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnSysMQs(String strPSDepSlnId, Vector<PSDepSlnSysMQ> psDepSlnSysMQs) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnSysMQs(strPSDepSlnId), psDepSlnSysMQs, PSDepSlnSysMQ.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnSysMQs(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNSYSMQ t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getAllPSDepSlnSysASes(String strPSDepSlnId, Vector<PSDepSlnSysAS> psDepSlnSysASes) {
        return this.selectMulti(this.getSQL_getAllPSDepSlnSysASes(strPSDepSlnId), psDepSlnSysASes, PSDepSlnSysAS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSlnSysASes(String strPSDepSlnId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSLNSYSAS t1 where  t1.PSDEPSLNID='%1$s'", (Object)strPSDepSlnId);
    }

    @Override
    public CallResult getPSDCDBInst(String strPSDCDBInstId, PSDevCenterDBInst psDevCenterDBInst) {
        return this.selectSingle(this.getSQL_getPSDCDBInst(strPSDCDBInstId), psDevCenterDBInst, "SYSTEM");
    }

    protected String getSQL_getPSDCDBInst(String strPSDCDBInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVCENTERDBINST t1 where t1.PSDEVCENTERDBINSTID='%1$s' ", (Object)strPSDCDBInstId);
    }

    @Override
    public CallResult getPSDCDBInst(String strPSDevCenterASId, String strDBType, PSDevCenterDBInst psDevCenterDBInst) {
        return this.selectSingle(this.getSQL_getPSDCDBInst(strPSDevCenterASId, strDBType), psDevCenterDBInst, "SYSTEM");
    }

    protected String getSQL_getPSDCDBInst(String strPSDevCenterASId, String strDBType) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVCENTERDBINST t1 where t1.PSDEVCENTERASID='%1$s' and DBTYPE='%2$s'", (Object)strPSDevCenterASId, (Object)strDBType);
    }

    @Override
    public CallResult getPSDCASGroup(String strPSDCASGroupId, PSDCASGroup psDCASGroup) {
        return this.selectSingle(this.getSQL_getPSDCASGroup(strPSDCASGroupId), psDCASGroup, "SYSTEM");
    }

    protected String getSQL_getPSDCASGroup(String strPSDCASGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCASGROUP t1 where t1.PSDCASGROUPID='%1$s' ", (Object)strPSDCASGroupId);
    }

    @Override
    public CallResult getPSASGroup(String strPSASGroupId, PSASGroup psASGroup) {
        return this.selectSingle(this.getSQL_getPSASGroup(strPSASGroupId), psASGroup, "SYSTEM");
    }

    protected String getSQL_getPSASGroup(String strPSASGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSASGROUP t1 where t1.PSASGROUPID='%1$s' ", (Object)strPSASGroupId);
    }

    @Override
    public CallResult getPSDevCenterAS(String strPSDevCenterASId, PSDevCenterAS psDevCenterAS) {
        return this.selectSingle(this.getSQL_getPSDevCenterAS(strPSDevCenterASId), psDevCenterAS, "SYSTEM");
    }

    protected String getSQL_getPSDevCenterAS(String strPSDevCenterASId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVCENTERAS t1 where t1.PSDEVCENTERASID='%1$s' ", (Object)strPSDevCenterASId);
    }

    @Override
    public CallResult getPSMQType(String strPSMQTypeId, PSMQType psMQType) {
        return this.selectSingle(this.getSQL_getPSMQType(strPSMQTypeId), psMQType, "SYSTEM");
    }

    protected String getSQL_getPSMQType(String strPSMQTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSMQTYPE t1 where  t1.PSMQTYPEID='%1$s'", (Object)strPSMQTypeId);
    }

    @Override
    public CallResult getPSMQInst(String strPSMQInstId, PSMQInst psMQInst) {
        return this.selectSingle(this.getSQL_getPSMQInst(strPSMQInstId), psMQInst, "SYSTEM");
    }

    protected String getSQL_getPSMQInst(String strPSMQInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSMQINST t1 where  t1.PSMQINSTID='%1$s'", (Object)strPSMQInstId);
    }

    @Override
    public CallResult getPSDCMQInst(String strPSDCMQInstId, PSDevCenterMQ psDevCenterMQ) {
        return this.selectSingle(this.getSQL_getPSDCMQInst(strPSDCMQInstId), psDevCenterMQ, "SYSTEM");
    }

    protected String getSQL_getPSDCMQInst(String strPSDCMQInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVCENTERMQ t1 where t1.PSDEVCENTERMQID='%1$s' ", (Object)strPSDCMQInstId);
    }

    @Override
    public CallResult getPSDepSys(String strPSDepSysId, PSDepSys psDepSys) {
        return this.selectSingle(this.getSQL_getPSDepSys(strPSDepSysId), psDepSys, "SYSTEM");
    }

    protected String getSQL_getPSDepSys(String strPSDepSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSYS t1 where t1.PSDEPSYSID='%1$s' ", (Object)strPSDepSysId);
    }

    @Override
    public CallResult getPSDepSysVer(String strPSDepSysVerId, PSDepSysVer psDepSysVer) {
        return this.selectSingle(this.getSQL_getPSDepSysVer(strPSDepSysVerId), psDepSysVer, "SYSTEM");
    }

    protected String getSQL_getPSDepSysVer(String strPSDepSysVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSYSVER t1 where t1.PSDEPSYSVERID='%1$s' ", (Object)strPSDepSysVerId);
    }

    @Override
    public CallResult getPSDepSaaSSysVer(String strPSDepSaaSSysVerId, PSDepSaaSSysVer psDepSaaSSysVer) {
        return this.selectSingle(this.getSQL_getPSDepSaaSSysVer(strPSDepSaaSSysVerId), psDepSaaSSysVer, "SYSTEM");
    }

    protected String getSQL_getPSDepSaaSSysVer(String strPSDepSaaSSysVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPSAASSYSVER t1 where t1.PSDEPSAASSYSVERID='%1$s' ", (Object)strPSDepSaaSSysVerId);
    }

    @Override
    public CallResult getAllPSDepSysApps(String strPSDepSysVerId, Vector<PSDepSysApp> psDepSysApps) {
        return this.selectMulti(this.getSQL_getAllPSDepSysApps(strPSDepSysVerId), psDepSysApps, PSDepSysApp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDepSysApps(String strPSDepSysVerId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEPSYSAPP t1 where  t1.PSDEPSYSVERID='%1$s'", (Object)strPSDepSysVerId);
    }

    @Override
    public CallResult getPSDepToolType(String strPSDepToolTypeId, PSDepToolType psDepToolType) {
        return this.selectSingle(this.getSQL_getPSDepToolType(strPSDepToolTypeId), psDepToolType, "SYSTEM");
    }

    protected String getSQL_getPSDepToolType(String strPSDepToolTypeId) {
        return StringHelper.Format((String)"SELECT t1.* from T_SRFPSDEPTOOLTYPE t1 where  t1.PSDEPTOOLTYPEID='%1$s'", (Object)strPSDepToolTypeId);
    }

    @Override
    public CallResult getPSSysEngineConfig(String strPSSysEngineConfigId, PSSysEngineCfg psSysEngineConfig) {
        return this.selectSingle(this.getSQL_getPSSysEngineConfig(strPSSysEngineConfigId), psSysEngineConfig, "SYSTEM");
    }

    protected String getSQL_getPSSysEngineConfig(String strPSSysEngineConfigId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSENGINECFG t1 where  t1.PSSYSENGINECFGID ='%1$s'", (Object)strPSSysEngineConfigId);
    }

    @Override
    public CallResult getPSDevCenterSVN(String strPSDevCenterSVNId, PSDevCenterSVN psDevCenterSVN) {
        return this.selectSingle(this.getSQL_getPSDevCenterSVN(strPSDevCenterSVNId), psDevCenterSVN, "SYSTEM");
    }

    protected String getSQL_getPSDevCenterSVN(String strPSDevCenterSVNId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVCENTERSVN t1 where t1.PSDEVCENTERSVNID='%1$s' ", (Object)strPSDevCenterSVNId);
    }

    @Override
    public CallResult getPSRobotType(String strPSRobotTypeId, PSRobotType psRobotType) {
        return this.selectSingle(this.getSQL_getPSRobotType(strPSRobotTypeId), psRobotType, "SYSTEM");
    }

    protected String getSQL_getPSRobotType(String strPSRobotTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSROBOTTYPE t1 where  t1.PSROBOTTYPEID='%1$s'", (Object)strPSRobotTypeId);
    }

    @Override
    public CallResult getPSRobotWorkType(String strPSRobotWorkTypeId, PSRobotWorkType psRobotWorkType) {
        return this.selectSingle(this.getSQL_getPSRobotWorkType(strPSRobotWorkTypeId), psRobotWorkType, "SYSTEM");
    }

    protected String getSQL_getPSRobotWorkType(String strPSRobotWorkTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSROBOTWORKTYPE t1 where  t1.PSROBOTWORKTYPEID='%1$s'", (Object)strPSRobotWorkTypeId);
    }

    @Override
    public CallResult getPSDCRobots(String strPSDevCenterId, Vector<PSDCRobot> psDCRobotList) {
        return this.selectMulti(this.getSQL_getPSDCRobots(strPSDevCenterId), psDCRobotList, PSDCRobot.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCRobots(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCROBOT t1 where  t1.PSDEVCENTERID='%1$s' ", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSRobot(String strPSRobotId, PSRobot psRobot) {
        return this.selectSingle(this.getSQL_getPSRobot(strPSRobotId), psRobot, "SYSTEM");
    }

    protected String getSQL_getPSRobot(String strPSRobotId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSROBOT t1 where  t1.PSROBOTID='%1$s'", (Object)strPSRobotId);
    }

    @Override
    public CallResult getPSGitUser(String strPSGitUserId, PSGitUser psGitUser) {
        return this.selectSingle(this.getSQL_getPSGitUser(strPSGitUserId), psGitUser, "SYSTEM");
    }

    protected String getSQL_getPSGitUser(String strPSGitUserId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSGITUSER t1 where  t1.PSGITUSERID='%1$s'", (Object)strPSGitUserId);
    }

    public CallResult getAllPSDEFInputTipSets2(String strPSSystemId, Vector<PSDEFInputTipSet> psDEFInputTipSetList) {
        return this.selectMulti(this.getSQL_getAllPSDEFInputTipSets(strPSSystemId), psDEFInputTipSetList, PSDEFInputTipSet.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDEFInputTipSets(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFINPUTTIPSET t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFInputTipSet(String strPSDEFInputTipSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFINPUTTIPSET t1 where  t1.PSDEFINPUTTIPSETID='%1$s'", (Object)strPSDEFInputTipSetId);
    }

    public CallResult getAllPSSysUniStates2(String strPSSystemId, Vector<PSSysUniState> psSysUniStateList) {
        return this.selectMulti(this.getSQL_getAllPSSysUniStates(strPSSystemId), psSysUniStateList, PSSysUniState.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUniStates(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNISTATE t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUniState(String strPSSysUniStateId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNISTATE t1 where  t1.PSSYSUNISTATEID='%1$s'", (Object)strPSSysUniStateId);
    }

    @Override
    public CallResult getPSBookingResType(String strPSBookingResTypeId, PSBookingResType psBookingResType) {
        return this.selectSingle(this.getSQL_getPSBookingResType(strPSBookingResTypeId), psBookingResType, "SYSTEM");
    }

    protected String getSQL_getPSBookingResType(String strPSBookingResTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSBOOKINGRESTYPE t1 where  t1.PSBOOKINGRESTYPEID='%1$s'", (Object)strPSBookingResTypeId);
    }

    @Override
    public CallResult getPSDevServerType(String strPSDevServerTypeId, PSDevServerType psDevServerType) {
        return this.selectSingle(this.getSQL_getPSDevServerType(strPSDevServerTypeId), psDevServerType, "SYSTEM");
    }

    protected String getSQL_getPSDevServerType(String strPSDevServerTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSERVERTYPE t1 where  t1.PSDEVSERVERTYPEID='%1$s'", (Object)strPSDevServerTypeId);
    }

    @Override
    public CallResult getPSDevServer(String strPSDevServerId, PSDevServer psDevServer) {
        return this.selectSingle(this.getSQL_getPSDevServer(strPSDevServerId), psDevServer, "SYSTEM");
    }

    protected String getSQL_getPSDevServer(String strPSDevServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSERVER t1 where  t1.PSDEVSERVERID='%1$s'", (Object)strPSDevServerId);
    }

    public CallResult getAllPSSysDEFTypes2(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
        return this.selectMulti(this.getSQL_getAllPSSysDEFTypes(strPSSystemId), psSysDEFTypeList, PSSysDEFType.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDEFTypes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDEFTYPE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDEFType(String strPSSysDEFTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDEFTYPE t1 where  t1.PSSYSDEFTYPEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysDEFTypeId);
    }

    @Override
    public CallResult getPSMobAppStartPage(String strPSMobAppStartPageId, PSMobAppStartPage psMobAppStartPage) {
        return this.selectSingle(this.getSQL_getPSMobAppStartPage(strPSMobAppStartPageId), psMobAppStartPage, "SYSTEM");
    }

    protected String getSQL_getPSMobAppStartPage(String strPSMobAppStartPageId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPSTARTPAGE t1 where  t1.PSMOBAPPSTARTPAGEID='%1$s'", (Object)strPSMobAppStartPageId);
    }

    public CallResult getAllPSMobAppStartPages2(String strPSApplicationId, Vector<PSMobAppStartPage> psMobAppStartPages) {
        return this.selectMulti(this.getSQL_getAllPSMobAppStartPages(strPSApplicationId), psMobAppStartPages, PSMobAppStartPage.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSMobAppStartPages(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPSTARTPAGE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSDCMobAppPackCerts(String strPSDevCenterId, Vector<PSDCMobAppPackCert> psDCMobAppPackCertList) {
        return this.selectMulti(this.getSQL_getPSDCMobAppPackCerts(strPSDevCenterId), psDCMobAppPackCertList, PSDCMobAppPackCert.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCMobAppPackCerts(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMOBPACKCERT t1 where  t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSDCMobAppTestDevices(String strPSDevCenterId, Vector<PSDCMobAppTestDevice> psDCMobAppTestDeviceList) {
        return this.selectMulti(this.getSQL_getPSDCMobAppTestDevices(strPSDevCenterId), psDCMobAppTestDeviceList, PSDCMobAppTestDevice.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCMobAppTestDevices(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMOBAPPTESTDEVICE t1 where  t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSMobAppPack(String strPSMobAppPackId, PSMobAppPack psMobAppPack) {
        return this.selectSingle(this.getSQL_getPSMobAppPack(strPSMobAppPackId), psMobAppPack, "SYSTEM");
    }

    protected String getSQL_getPSMobAppPack(String strPSMobAppPackId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPPACK t1 where  t1.PSMOBAPPPACKID='%1$s'", (Object)strPSMobAppPackId);
    }

    public CallResult getAllPSMobAppPacks2(String strPSApplicationId, Vector<PSMobAppPack> psMobAppPacks) {
        return this.selectMulti(this.getSQL_getAllPSMobAppPacks(strPSApplicationId), psMobAppPacks, PSMobAppPack.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSMobAppPacks(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPPACK t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    public CallResult getPSMobAppPackTDsBySysApp(String strPSSysAppId, Vector<PSMobAppPackTD> psMobAppPackTDList) {
        return this.selectMulti(this.getSQL_getPSMobAppPackTDsBySysApp(strPSSysAppId), psMobAppPackTDList, PSMobAppPackTD.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSMobAppPackTDsBySysApp(String strPSSysAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPPACKTD t1 INNER JOIN T_SRFPSMOBAPPPACK t2 on T1.PSMOBAPPPACKID = t2.PSMOBAPPPACKID where  t2.PSSYSAPPID='%1$s'", (Object)strPSSysAppId);
    }

    protected String getSQL_getPSMobAppPackTDs(String strPSMobAppPackId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPPACKTD t1 where  t1.PSMOBAPPPACKID='%1$s' ", (Object)strPSMobAppPackId);
    }

    @Override
    public CallResult getPSMobAppPackCert(String strPSMobAppPackCertId, PSDCMobAppPackCert psMobAppPackCert) {
        return this.selectSingle(this.getSQL_getPSMobAppPackCert(strPSMobAppPackCertId), psMobAppPackCert, "SYSTEM");
    }

    protected String getSQL_getPSMobAppPackCert(String strPSMobAppPackCertId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMOBPACKCERT t1 where  t1.PSDCMOBPACKCERTID='%1$s'", (Object)strPSMobAppPackCertId);
    }

    public CallResult getAllPSMobAppPackCerts2(String strPSApplicationId, Vector<PSDCMobAppPackCert> psMobAppPackCerts) {
        return this.selectMulti(this.getSQL_getAllPSMobAppPackCerts(strPSApplicationId), psMobAppPackCerts, PSDCMobAppPackCert.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSMobAppPackCerts(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMOBPACKCERT t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    public CallResult getAllPSSysLogics2(String strPSSystemId, Vector<PSSysLogic> psSysLogicList) {
        return this.selectMulti(this.getSQL_getAllPSSysLogics(strPSSystemId), psSysLogicList, PSSysLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysLogics(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDELOGICNODE t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSMobAppPackServer(String strPSMobAppPackServerId, PSMobAppPackServer psMobAppPackServer) {
        return this.selectSingle(this.getSQL_getPSMobAppPackServer(strPSMobAppPackServerId), psMobAppPackServer, "SYSTEM");
    }

    protected String getSQL_getPSMobAppPackServer(String strPSMobAppPackServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMOBAPPPACKSERVER t1 where  t1.PSMOBAPPPACKSERVERID='%1$s'", (Object)strPSMobAppPackServerId);
    }

    protected String getSQL_getPSSysLogic(String strPSSysLogicId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDELOGICNODE t1 where  t1.PSSYSDELOGICNODEID='%1$s'", (Object)strPSSysLogicId);
    }

    protected String getSQL_getPSDEUniStates(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNISTATE t1 where  t1.PSDEID='%1$s' AND t1.UNISTATETYPE = 'DE'  AND t1.VALIDFLAG=1 ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEUniStatesBySystem(String strPSSystemId, Vector<PSSysUniState> psDEUniStateList) {
        return this.selectMulti(this.getSQL_getPSDEUniStatesBySystem(strPSSystemId), psDEUniStateList, PSSysUniState.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUniStatesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUNISTATE t1  inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.UNISTATETYPE = 'DE'  AND t1.VALIDFLAG=1", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysSearchBars2(String strPSSystemId, Vector<PSSysSearchBar> psSysSearchBarList) {
        return this.selectMulti(this.getSQL_getAllPSSysSearchBars(strPSSystemId), psSysSearchBarList, PSSysSearchBar.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSearchBars(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHBAR t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchBar(String strPSSysSearchBarId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHBAR t1 where  t1.PSSYSSEARCHBARID='%1$s'", (Object)strPSSysSearchBarId);
    }

    public CallResult getPSSysSearchBarItemsBySystem(String strPSSystemId, Vector<PSSysSearchBarItem> psSysSearchBarItemList) {
        return this.selectMulti(this.getSQL_getPSSysSearchBarItemsBySystem(strPSSystemId), psSysSearchBarItemList, PSSysSearchBarItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchBarItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHBARITEM t1  inner join T_SRFPSSYSSEARCHBAR t2 on t1.PSSYSSEARCHBARID=t2.PSSYSSEARCHBARID where  t2.PSSYSTEMID='%1$s' order by ORDERVALUE,PSSYSSEARCHBARITEMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchBarItems(String strPSSysSearchBarId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHBARITEM t1 where  t1.PSSYSSEARCHBARID='%1$s' order by ORDERVALUE,PSSYSSEARCHBARITEMNAME", (Object)strPSSysSearchBarId);
    }

    @Override
    public CallResult getPSViewEngine(String strPSViewEngineId, PSViewEngine psViewEngine) {
        return this.selectSingle(this.getSQL_getPSViewEngine(strPSViewEngineId), psViewEngine, "SYSTEM");
    }

    protected String getSQL_getPSViewEngine(String strPSViewEngineId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSVIEWENGINE t1 where  t1.PSVIEWENGINEID='%1$s' AND  t1.VALIDFLAG = 1 ", (Object)strPSViewEngineId);
    }

    @Override
    public CallResult getPSDEServiceAPI(String strPSDEServiceAPIId, PSDEServiceAPI psDEServiceAPI) {
        return this.selectSingle(this.getSQL_getPSDEServiceAPI(strPSDEServiceAPIId), psDEServiceAPI, "SYSTEM");
    }

    protected String getSQL_getPSDEServiceAPI(String strPSDEServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESERVICEAPI t1 where  t1.PSDESERVICEAPIID='%1$s' ", (Object)strPSDEServiceAPIId);
    }

    protected String getSQL_getPSDEServiceAPIs(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESERVICEAPI t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDEId);
    }

    public CallResult getPSDEServiceAPIsBySystem(String strPSSystemId, Vector<PSDEServiceAPI> psDEServiceAPIList) {
        return this.selectMulti(this.getSQL_getPSDEServiceAPIsBySystem(strPSSystemId), psDEServiceAPIList, PSDEServiceAPI.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEServiceAPIsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESERVICEAPI t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDESADetail(String strPSDESADetailId, PSDESADetail psDESADetail) {
        return this.selectSingle(this.getSQL_getPSDESADetail(strPSDESADetailId), psDESADetail, "SYSTEM");
    }

    protected String getSQL_getPSDESADetail(String strPSDESADetailId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESADETAIL t1 where  t1.PSDESADETAILID='%1$s' ", (Object)strPSDESADetailId);
    }

    protected String getSQL_getPSDESADetails(String strPSDEServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESADETAIL t1 where  t1.PSDESERVICEAPIID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSDEServiceAPIId);
    }

    public CallResult getPSDESADetailsBySystem(String strPSSystemId, Vector<PSDESADetail> psDESADetailList) {
        return this.selectMulti(this.getSQL_getPSDESADetailsBySystem(strPSSystemId), psDESADetailList, PSDESADetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDESADetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDESADETAIL  t1 inner join T_SRFPSDESERVICEAPI t2 on t1.PSDESERVICEAPIID= t2.PSDESERVICEAPIID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) AND t2.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysServiceAPIs2(String strPSSystemId, Vector<PSSysServiceAPI> psSysServiceAPIList) {
        return this.selectMulti(this.getSQL_getAllPSSysServiceAPIs(strPSSystemId), psSysServiceAPIList, PSSysServiceAPI.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysServiceAPIs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSERVICEAPI t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysServiceAPI(String strPSSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSERVICEAPI t1 where  t1.PSSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysServiceAPIId);
    }

    protected String getSQL_getPSDEServiceAPIsBySSA(String strPSSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESERVICEAPI t1 where  t1.PSSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSysServiceAPIId);
    }

    protected String getSQL_getPSDEDTSQueues(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDTSQUEUE t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG=1 ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEDTSQueuesBySystem(String strPSSystemId, Vector<PSSysDTSQueue> psDEDTSQueueList) {
        return this.selectMulti(this.getSQL_getPSDEDTSQueuesBySystem(strPSSystemId), psDEDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDTSQueuesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDTSQUEUE t1  where t1.pssystemid= '%1$s' AND t1.VALIDFLAG=1", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysDTSQueues2(String strPSSystemId, Vector<PSSysDTSQueue> psSysDTSQueueList) {
        return this.selectMulti(this.getSQL_getAllPSSysDTSQueues(strPSSystemId), psSysDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDTSQueues(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDTSQUEUE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDTSQueue(String strPSSysDTSQueueId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDTSQUEUE t1 where  t1.PSDEDTSQUEUEID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysDTSQueueId);
    }

    @Override
    public CallResult getPSDeployServer(String strPSDeployServerId, PSDeployServer psDeployServer) {
        return this.selectSingle(this.getSQL_getPSDeployServer(strPSDeployServerId), psDeployServer, "SYSTEM");
    }

    protected String getSQL_getPSDeployServer(String strPSDeployServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPLOYSERVER t1 where  t1.PSDEPLOYSERVERID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSDeployServerId);
    }

    public CallResult getAllPSSubSysServiceAPIs2(String strPSSystemId, Vector<PSSubSysServiceAPI> psSubSysServiceAPIList) {
        return this.selectMulti(this.getSQL_getAllPSSubSysServiceAPIs(strPSSystemId), psSubSysServiceAPIList, PSSubSysServiceAPI.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSubSysServiceAPIs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSSERVICEAPI t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSubSysServiceAPI(String strPSSubSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSSERVICEAPI t1 where  t1.PSSUBSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSubSysServiceAPIId);
    }

    protected String getSQL_getPSSubSysSADetails(String strPSSubSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSUBSYSSADETAIL t1 where  t1.PSSUBSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSubSysServiceAPIId);
    }

    @Override
    public CallResult getPSDCDeployServer(String strPSDCDeployServerId, PSDCDeployServer psDCDeployServer) {
        return this.selectSingle(this.getSQL_getPSDCDeployServer(strPSDCDeployServerId), psDCDeployServer, "SYSTEM");
    }

    protected String getSQL_getPSDCDeployServer(String strPSDCDeployServerId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCDEPLOYSERVER t1 where t1.PSDCDEPLOYSERVERID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDCDeployServerId);
    }

    @Override
    public CallResult getDefaultPSDCDeployServer(String strPSDevCenterId, PSDCDeployServer psDCDeployServer) {
        return this.selectSingle(this.getSQL_getDefaultPSDCDeployServer(strPSDevCenterId), psDCDeployServer, "SYSTEM");
    }

    protected String getSQL_getDefaultPSDCDeployServer(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCDEPLOYSERVER t1 where t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1 AND t1.DEFAULTFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSDevSlnSysRes(String strPSDevSlnSysResId, PSDevSlnSysRes psDevSlnSysRes) {
        return this.selectSingle(this.getSQL_getPSDevSlnSysRes(strPSDevSlnSysResId), psDevSlnSysRes, "SYSTEM");
    }

    protected String getSQL_getPSDevSlnSysRes(String strPSDevSlnSysResId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSRES t1 where t1.PSDEVSLNSYSRESID='%1$s' ", (Object)strPSDevSlnSysResId);
    }

    protected String getSQL_getPSDEOPPrivRoles(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIVROLE t1 where  t1.PSDEID='%1$s'  AND t1.VALIDFLAG = 1  ", (Object)strPSDEId);
    }

    public CallResult getPSDEOPPrivRolesBySystem(String strPSSystemId, Vector<PSDEOPPrivRole> psDEOPPrivRoleList) {
        return this.selectMulti(this.getSQL_getPSDEOPPrivRolesBySystem(strPSSystemId), psDEOPPrivRoleList, PSDEOPPrivRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEOPPrivRolesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEOPPRIVROLE t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysUserRoles2(String strPSSystemId, Vector<PSSysUserRole> psSysUserRoleList) {
        return this.selectMulti(this.getSQL_getAllPSSysUserRoles(strPSSystemId), psSysUserRoleList, PSSysUserRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUserRoles(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSOPPRIV t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserRole(String strPSSysUserRoleId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSOPPRIV t1 where  t1.PSSYSOPPRIVID='%1$s'", (Object)strPSSysUserRoleId);
    }

    public CallResult getAllPSSysDashboards2(String strPSSystemId, Vector<PSSysDashboard> psSysDashboardList) {
        return this.selectMulti(this.getSQL_getAllPSSysDashboards(strPSSystemId), psSysDashboardList, PSSysDashboard.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDashboards(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDASHBOARD t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDashboard(String strPSSysDashboardId) {
        if (strPSSysDashboardId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDASHBOARD_TMP t1 where  t1.PSSYSDASHBOARDID='%1$s'", (Object)strPSSysDashboardId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDASHBOARD t1 where  t1.PSSYSDASHBOARDID='%1$s'", (Object)strPSSysDashboardId);
    }

    public CallResult getPSSysDashboardPartsBySystem(String strPSSystemId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
        return this.selectMulti(this.getSQL_getPSSysDashboardPartsBySystem(strPSSystemId), psSysDashboardPartList, PSSysDashboardPart.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDashboardPartsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDBPART t1  inner join T_SRFPSSYSDASHBOARD t2 on t1.PSSYSDASHBOARDID=t2.PSSYSDASHBOARDID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG=1 order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDashboardParts(String strPSSysDashboardId) {
        if (strPSSysDashboardId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSDBPART_TMP t1 where t1.PSSYSDASHBOARDID='%1$s' AND t1.srfdraftflag = 0 AND t1.VALIDFLAG=1 order by ORDERVALUE", (Object)strPSSysDashboardId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDBPART t1 where  t1.PSSYSDASHBOARDID='%1$s' AND t1.VALIDFLAG=1 order by ORDERVALUE", (Object)strPSSysDashboardId);
    }

    public CallResult getPSSysUserRoleResesBySystem(String strPSSystemId, Vector<PSSysUserRoleRes> psSysUserRoleResList) {
        return this.selectMulti(this.getSQL_getPSSysUserRoleResesBySystem(strPSSystemId), psSysUserRoleResList, PSSysUserRoleRes.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysUserRoleResesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERROLERES t1  inner join T_SRFPSSYSOPPRIV t2 on t1.PSSYSOPPRIVID=t2.PSSYSOPPRIVID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    public CallResult getPSSysUserRoleDatasBySystem(String strPSSystemId, Vector<PSSysUserRoleData> psSysUserRoleDataList) {
        return this.selectMulti(this.getSQL_getPSSysUserRoleDatasBySystem(strPSSystemId), psSysUserRoleDataList, PSSysUserRoleData.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysUserRoleDatasBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERROLEDATA t1  inner join T_SRFPSSYSOPPRIV t2 on t1.PSSYSOPPRIVID=t2.PSSYSOPPRIVID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    public CallResult getAllPSAppLocalDEs2(String strPSApplicationId, Vector<PSAppLocalDE> psAppLocalDEs) {
        return this.selectMulti(this.getSQL_getAllPSAppLocalDEs(strPSApplicationId), psAppLocalDEs, PSAppLocalDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppLocalDEs(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLOCALDE t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSSFPluginTempl(String strPSSFPluginTemplId, PSSFPluginTempl psSFPluginTempl) {
        return this.selectSingle(this.getSQL_getPSSFPluginTempl(strPSSFPluginTemplId), psSFPluginTempl, "SYSTEM");
    }

    protected String getSQL_getPSSFPluginTempl(String strPSSFPluginTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFPLUGINTEMPL t1 where  t1.PSSFPLUGINTEMPLID='%1$s'", (Object)strPSSFPluginTemplId);
    }

    public CallResult getAllPSSysSFPlugins2(String strPSSystemId, Vector<PSSysSFPlugin> psSysSFPluginList) {
        return this.selectMulti(this.getSQL_getAllPSSysSFPlugins(strPSSystemId), psSysSFPluginList, PSSysSFPlugin.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSFPlugins(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPLUGIN t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUserRoleRess(String strPSSysUserRoleId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERROLERES t1 where  t1.PSSYSOPPRIVID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSysUserRoleId);
    }

    protected String getSQL_getPSSysUserRoleDatas(String strPSSysUserRoleId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSUSERROLEDATA t1 where  t1.PSSYSOPPRIVID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSysUserRoleId);
    }

    @Override
    public CallResult getPSAppLocalDE(String strPSAppLocalDEId, PSAppLocalDE psAppLocalDE) {
        return this.selectSingle(this.getSQL_getPSAppLocalDE(strPSAppLocalDEId), psAppLocalDE, "SYSTEM");
    }

    protected String getSQL_getPSAppLocalDE(String strPSAppLocalDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLOCALDE t1 where  t1.PSAPPLOCALDEID='%1$s'  AND t1.VALIDFLAG = 1", (Object)strPSAppLocalDEId);
    }

    protected String getSQL_getPSSysSFPlugin(String strPSSysSFPluginId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPLUGIN t1 where  t1.PSSYSSFPLUGINID='%1$s'", (Object)strPSSysSFPluginId);
    }

    protected String getSQL_getAllPSSysSFPluginTempls(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPITEMPL t1   inner join T_SRFPSSYSSFPLUGIN t2 on t1.PSSYSSFPLUGINID = t2.PSSYSSFPLUGINID   where t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysSFPluginTempls2(String strPSSystemId, Vector<PSSysSFPluginTempl> psSysSFPluginTemplList) {
        return this.selectMulti(this.getSQL_getAllPSSysSFPluginTempls(strPSSystemId), psSysSFPluginTemplList, PSSysSFPluginTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSFPluginTempl(String strPSSysSFPluginTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSFPITEMPL t1 where  t1.PSSYSSFPITEMPLID='%1$s'", (Object)strPSSysSFPluginTemplId);
    }

    @Override
    public CallResult getPSPFPluginTempl(String strPSPFPluginTemplId, PSPFPluginTempl psPFPluginTempl) {
        return this.selectSingle(this.getSQL_getPSPFPluginTempl(strPSPFPluginTemplId), psPFPluginTempl, "SYSTEM");
    }

    protected String getSQL_getPSPFPluginTempl(String strPSPFPluginTemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPLUGINTEMPL t1 where  t1.PSPFPLUGINTEMPLID='%1$s'", (Object)strPSPFPluginTemplId);
    }

    protected String getSQL_getPSDEUtils(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUTILDE t1 where  t1.PSDEID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSDEId);
    }

    public CallResult getPSDEUtilsBySystem(String strPSSystemId, Vector<PSDEUtil> psDEUtilList) {
        return this.selectMulti(this.getSQL_getPSDEUtilsBySystem(strPSSystemId), psDEUtilList, PSDEUtil.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUtilsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUTILDE t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) and t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysUtils2(String strPSSystemId, Vector<PSSysUtil> psSysUtilList) {
        return this.selectMulti(this.getSQL_getAllPSSysUtils(strPSSystemId), psSysUtilList, PSSysUtil.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysUtils(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUTILDE t1 where t1.PSSYSTEMID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysUtil(String strPSSysUtilId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUTILDE t1 where  t1.PSSYSUTILDEID='%1$s'", (Object)strPSSysUtilId);
    }

    @Override
    public CallResult getPSDCCodeSnippet(String strPSDCCodeSnippetId, PSDCCodeSnippet psDCCodeSnippet) {
        return this.selectSingle(this.getSQL_getPSDCCodeSnippet(strPSDCCodeSnippetId), psDCCodeSnippet, "SYSTEM");
    }

    protected String getSQL_getPSDCCodeSnippet(String strPSDCCodeSnippetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCCODESNIPPET t1 where  t1.PSDCCODESNIPPETID='%1$s'", (Object)strPSDCCodeSnippetId);
    }

    @Override
    public CallResult getPSDCCodeSnippetRefs(String strPSDCCodeSnippetId, Vector<PSDCCodeSnippetRef> psDCCodeSnippetRefList) {
        return this.selectMulti(this.getSQL_getPSDCCodeSnippetRefs(strPSDCCodeSnippetId), psDCCodeSnippetRefList, PSDCCodeSnippetRef.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCCodeSnippetRefs(String strPSDCCodeSnippetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCCODESNIPPETREF t1 where  t1.PSDCCODESNIPPETID='%1$s' ", (Object)strPSDCCodeSnippetId);
    }

    @Override
    public CallResult getPSCodeSnippetType(String strPSCodeSnippetTypeId, PSCodeSnippetType psCodeSnippetType) {
        return this.selectSingle(this.getSQL_getPSCodeSnippetType(strPSCodeSnippetTypeId), psCodeSnippetType, "SYSTEM");
    }

    protected String getSQL_getPSCodeSnippetType(String strPSCodeSnippetTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCODESNIPPETTYPE t1 where  t1.PSCODESNIPPETTYPEID='%1$s'", (Object)strPSCodeSnippetTypeId);
    }

    @Override
    public CallResult getPSDeployCenter(String strPSDeployCenterId, PSDeployCenter psDeployCenter) {
        return this.selectSingle(this.getSQL_getPSDeployCenter(strPSDeployCenterId), psDeployCenter, "SYSTEM");
    }

    protected String getSQL_getPSDeployCenter(String strPSDeployCenterId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEPLOYCENTER t1 where  t1.PSDEPLOYCENTERID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSDeployCenterId);
    }

    @Override
    public CallResult getPSDCDeployCenter(String strPSDCDeployCenterId, PSDCDeployCenter psDCDeployCenter) {
        return this.selectSingle(this.getSQL_getPSDCDeployCenter(strPSDCDeployCenterId), psDCDeployCenter, "SYSTEM");
    }

    protected String getSQL_getPSDCDeployCenter(String strPSDCDeployCenterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCDEPLOYCENTER t1 where t1.PSDCDEPLOYCENTERID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDCDeployCenterId);
    }

    @Override
    public CallResult getDefaultPSDCDeployCenter(String strPSDevCenterId, PSDCDeployCenter psDCDeployCenter) {
        return this.selectSingle(this.getSQL_getDefaultPSDCDeployCenter(strPSDevCenterId), psDCDeployCenter, "SYSTEM");
    }

    protected String getSQL_getDefaultPSDCDeployCenter(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCDEPLOYCENTER t1 where t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1 AND t1.DEFAULTFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getDefaultPSDCRegistryRepo(String strPSDevCenterId, PSDCRegistryRepo psDCDeployCenter) {
        return this.selectSingle(this.getSQL_getDefaultPSDCRegistryRepo(strPSDevCenterId), psDCDeployCenter, "SYSTEM");
    }

    protected String getSQL_getDefaultPSDCRegistryRepo(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCREGISTRYREPO t1 where t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1 AND t1.DEFAULTFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSWorkshopServer(String strPSWorkshopServerId, PSWorkshopServer psWorkshopServer) {
        return this.selectSingle(this.getSQL_getPSWorkshopServer(strPSWorkshopServerId), psWorkshopServer, "SYSTEM");
    }

    protected String getSQL_getPSWorkshopServer(String strPSWorkshopServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSWORKSHOPSERVER t1 where  t1.PSWORKSHOPSERVERID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSWorkshopServerId);
    }

    @Override
    public CallResult getPSDCWorkshopServer(String strPSDCWorkshopServerId, PSDCWorkshopServer psDCWorkshopServer) {
        return this.selectSingle(this.getSQL_getPSDCWorkshopServer(strPSDCWorkshopServerId), psDCWorkshopServer, "SYSTEM");
    }

    protected String getSQL_getPSDCWorkshopServer(String strPSDCWorkshopServerId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCWORKSHOPSERVER t1 where t1.PSDCWORKSHOPSERVERID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDCWorkshopServerId);
    }

    @Override
    public CallResult getDefaultPSDCWorkshopServer(String strPSDevCenterId, PSDCWorkshopServer psDCWorkshopServer) {
        return this.selectSingle(this.getSQL_getDefaultPSDCWorkshopServer(strPSDevCenterId), psDCWorkshopServer, "SYSTEM");
    }

    protected String getSQL_getDefaultPSDCWorkshopServer(String strPSDevCenterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCWORKSHOPSERVER t1 where t1.PSDEVCENTERID='%1$s' AND t1.VALIDFLAG = 1 AND t1.DEFAULTFLAG = 1", (Object)strPSDevCenterId);
    }

    @Override
    public CallResult getPSMSPlatform(String strPSMSPlatformId, PSMSPlatform psMSPlatform) {
        return this.selectSingle(this.getSQL_getPSMSPlatform(strPSMSPlatformId), psMSPlatform, "SYSTEM");
    }

    protected String getSQL_getPSMSPlatform(String strPSMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMSPLATFORM t1 where  t1.PSMSPLATFORMID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSMSPlatformId);
    }

    @Override
    public CallResult getPSDCMSPlatform(String strPSDCMSPlatformId, PSDCMSPlatform psDCMSPlatform) {
        return this.selectSingle(this.getSQL_getPSDCMSPlatform(strPSDCMSPlatformId), psDCMSPlatform, "SYSTEM");
    }

    protected String getSQL_getPSDCMSPlatform(String strPSDCMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCMSPLATFORM t1 where t1.PSDCMSPLATFORMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDCMSPlatformId);
    }

    @Override
    public CallResult getPSMSPlatformFuncs(String strPSMSPlatformId, Vector<PSMSPlatformFunc> psMSPlatformFuncList) {
        return this.selectMulti(this.getSQL_getPSMSPlatformFuncs(strPSMSPlatformId), psMSPlatformFuncList, PSMSPlatformFunc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSMSPlatformFuncs(String strPSMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMSPLATFORMFUNC t1 where  t1.PSMSPLATFORMID='%1$s' ", (Object)strPSMSPlatformId);
    }

    @Override
    public CallResult getPSMSPlatformNodes(String strPSMSPlatformId, Vector<PSMSPlatformNode> psMSPlatformNodeList) {
        return this.selectMulti(this.getSQL_getPSMSPlatformNodes(strPSMSPlatformId), psMSPlatformNodeList, PSMSPlatformNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSMSPlatformNodes(String strPSMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMSPLATFORMNODE t1 where  t1.PSMSPLATFORMID='%1$s' ", (Object)strPSMSPlatformId);
    }

    @Override
    public CallResult getPSDCMSPlatformFuncs(String strPSDCMSPlatformId, Vector<PSDCMSPlatformFunc> psDCMSPlatformFuncList) {
        return this.selectMulti(this.getSQL_getPSDCMSPlatformFuncs(strPSDCMSPlatformId), psDCMSPlatformFuncList, PSDCMSPlatformFunc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCMSPlatformFuncs(String strPSDCMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMSPLATFORMFUNC t1 where  t1.PSDCMSPLATFORMID='%1$s' ", (Object)strPSDCMSPlatformId);
    }

    @Override
    public CallResult getPSDCMSPlatformNodes(String strPSDCMSPlatformId, Vector<PSDCMSPlatformNode> psDCMSPlatformNodeList) {
        return this.selectMulti(this.getSQL_getPSDCMSPlatformNodes(strPSDCMSPlatformId), psDCMSPlatformNodeList, PSDCMSPlatformNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDCMSPlatformNodes(String strPSDCMSPlatformId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMSPLATFORMNODE t1 where  t1.PSDCMSPLATFORMID='%1$s' ", (Object)strPSDCMSPlatformId);
    }

    @Override
    public CallResult getPSDevSlnMSDepApp(String strPSDevSlnMSDepAppId, PSDevSlnMSDepApp psDevSlnMSDepApp) {
        return this.selectSingle(this.getSQL_getPSDevSlnMSDepApp(strPSDevSlnMSDepAppId), psDevSlnMSDepApp, "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepApp(String strPSDevSlnMSDepAppId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPAPP t1 where  t1.PSDEVSLNMSDEPAPPID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSDevSlnMSDepAppId);
    }

    @Override
    public CallResult getPSDevSlnMSDepAPI(String strPSDevSlnMSDepAPIId, PSDevSlnMSDepAPI psDevSlnMSDepAPI) {
        return this.selectSingle(this.getSQL_getPSDevSlnMSDepAPI(strPSDevSlnMSDepAPIId), psDevSlnMSDepAPI, "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepAPI(String strPSDevSlnMSDepAPIId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPAPI t1 where  t1.PSDEVSLNMSDEPAPIID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSDevSlnMSDepAPIId);
    }

    @Override
    public CallResult getPSDevSlnMSDepAPIs(String strPSDevSlnSysId, Vector<PSDevSlnMSDepAPI> psDevSlnMSDepAPIList) {
        return this.selectMulti(this.getSQL_getPSDevSlnMSDepAPIs(strPSDevSlnSysId), psDevSlnMSDepAPIList, PSDevSlnMSDepAPI.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepAPIs(String strPSDevSlnSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPAPI t1 where  t1.PSDEVSLNSYSID='%1$s'  and t1.VALIDFLAG = 1 ", (Object)strPSDevSlnSysId);
    }

    @Override
    public CallResult getPSDevSlnMSDepApps(String strPSDevSlnSysId, Vector<PSDevSlnMSDepApp> psDevSlnMSDepAppList) {
        return this.selectMulti(this.getSQL_getPSDevSlnMSDepApps(strPSDevSlnSysId), psDevSlnMSDepAppList, PSDevSlnMSDepApp.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepApps(String strPSDevSlnSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPAPP t1 where  t1.PSDEVSLNSYSID='%1$s'  and t1.VALIDFLAG = 1 ", (Object)strPSDevSlnSysId);
    }

    protected String getSQL_getPSDEActionTempl(String strPSDEActionTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONTEMPL t1 where  t1.PSDEACTIONTEMPLID='%1$s'", (Object)strPSDEActionTemplId);
    }

    @Override
    public CallResult getPSMavenServer(String strPSMavenServerId, PSMavenServer psMavenServer) {
        return this.selectSingle(this.getSQL_getPSMavenServer(strPSMavenServerId), psMavenServer, "SYSTEM");
    }

    protected String getSQL_getPSMavenServer(String strPSMavenServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMAVENSERVER t1 where  t1.PSMAVENSERVERID='%1$s'  and t1.VALIDFLAG = 1 ", (Object)strPSMavenServerId);
    }

    @Override
    public CallResult getPSMavenServerType(String strPSMavenServerTypeId, PSMavenServerType psMavenServerType) {
        return this.selectSingle(this.getSQL_getPSMavenServerType(strPSMavenServerTypeId), psMavenServerType, "SYSTEM");
    }

    protected String getSQL_getPSMavenServerType(String strPSMavenServerTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMAVENSERVERTYPE t1 where  t1.PSMAVENSERVERTYPEID='%1$s'", (Object)strPSMavenServerTypeId);
    }

    @Override
    public CallResult getPSMavenRepo(String strPSMavenRepoId, PSMavenRepo psMavenRepo) {
        return this.selectSingle(this.getSQL_getPSMavenRepo(strPSMavenRepoId), psMavenRepo, "SYSTEM");
    }

    protected String getSQL_getPSMavenRepo(String strPSMavenRepoId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSMAVENREPO t1 where  t1.PSMAVENREPOID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSMavenRepoId);
    }

    public CallResult getAllPSSysCalendars2(String strPSSystemId, Vector<PSSysCalendar> psSysCalendarList) {
        return this.selectMulti(this.getSQL_getAllPSSysCalendars(strPSSystemId), psSysCalendarList, PSSysCalendar.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysCalendars(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCALENDAR t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCalendar(String strPSSysCalendarId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCALENDAR t1 where  t1.PSSYSCALENDARID='%1$s'", (Object)strPSSysCalendarId);
    }

    public CallResult getPSSysCalendarItemsBySystem(String strPSSystemId, Vector<PSSysCalendarItem> psSysCalendarItemList) {
        return this.selectMulti(this.getSQL_getPSSysCalendarItemsBySystem(strPSSystemId), psSysCalendarItemList, PSSysCalendarItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysCalendarItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARITEM t1  inner join T_SRFPSSYSCALENDAR t2 on t1.PSSYSCALENDARID=t2.PSSYSCALENDARID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG=1  order by PSSYSCALENDARITEMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCalendarItems(String strPSSysCalendarId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARITEM t1 where  t1.PSSYSCALENDARID='%1$s' AND t1.VALIDFLAG=1 order by PSSYSCALENDARITEMNAME", (Object)strPSSysCalendarId);
    }

    public CallResult getPSSysCalendarItemRVsBySystem(String strPSSystemId, Vector<PSSysCalendarItemRV> psSysCalendarItemRVList) {
        return this.selectMulti(this.getSQL_getPSSysCalendarItemRVsBySystem(strPSSystemId), psSysCalendarItemRVList, PSSysCalendarItemRV.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysCalendarItemRVsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARITEMRV t1  inner join t_SRFPSSYSCALENDAR t2 on t1.PSSYSCALENDARID=t2.PSSYSCALENDARID where  t2.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCalendarItemRVs(String strPSSysCalendarId) {
        if (strPSSysCalendarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSCALENDARITEMRV_TMP t1 where  t1.PSSYSCALENDARID='%1$s' AND  t1.srfdraftflag = 0  ", (Object)strPSSysCalendarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARITEMRV t1 where  t1.PSSYSCALENDARID='%1$s'  ", (Object)strPSSysCalendarId);
    }

    protected String getSQL_getPSDESampleDatas(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESAMPLEDATA t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDESampleDatasBySystem(String strPSSystemId, Vector<PSDESampleData> psDESampleDataList) {
        if (this.getModelInstVer() < 387) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDESampleDatasBySystem(strPSSystemId), psDESampleDataList, PSDESampleData.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDESampleDatasBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDESAMPLEDATA t1  inner join t_srfpsdataentity t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSPanelDetailType(String strPSPanelDetailTypeId, PSPanelDetailType psPanelDetailType) {
        return this.selectSingle(this.getSQL_getPSPanelDetailType(strPSPanelDetailTypeId), psPanelDetailType, "SYSTEM");
    }

    protected String getSQL_getPSPanelDetailType(String strPSPanelDetailTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELDETAILTYPE t1 where  t1.PSPANELDETAILTYPEID='%1$s'", (Object)strPSPanelDetailTypeId);
    }

    public CallResult getAllPSSysPanels2(String strPSSystemId, Vector<PSSysPanel> psSysPanelList) {
        return this.selectMulti(this.getSQL_getAllPSSysPanels(strPSSystemId), psSysPanelList, PSSysPanel.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysPanels(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSVIEWPANEL t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPanel(String strPSSysPanelId) {
        if (strPSSysPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSVIEWPANEL_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s'", (Object)strPSSysPanelId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSVIEWPANEL t1 where  t1.PSSYSVIEWPANELID='%1$s'", (Object)strPSSysPanelId);
    }

    public CallResult getPSSysPanelItemsBySystem(String strPSSystemId, Vector<PSSysPanelItem> psSysPanelItemList) {
        return this.selectMulti(this.getSQL_getPSSysPanelItemsBySystem(strPSSystemId), psSysPanelItemList, PSSysPanelItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysPanelItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELITEM t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPanelItems(String strPSSysPanelId) {
        if (strPSSysPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSVIEWPANELITEM_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSSysPanelId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELITEM t1 where  t1.PSSYSVIEWPANELID='%1$s' order by ORDERVALUE", (Object)strPSSysPanelId);
    }

    public CallResult getPSSysPanelModelsBySystem(String strPSSystemId, Vector<PSSysPanelModel> psSysPanelModelList) {
        return this.selectMulti(this.getSQL_getPSSysPanelModelsBySystem(strPSSystemId), psSysPanelModelList, PSSysPanelModel.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysPanelModelsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELMODEL t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by PSSYSVIEWPANELMODELNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPanelModels(String strPSSysPanelId) {
        if (strPSSysPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSVIEWPANELMODEL_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s' AND  t1.srfdraftflag = 0 order by PSSYSVIEWPANELMODELNAME", (Object)strPSSysPanelId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELMODEL t1 where  t1.PSSYSVIEWPANELID='%1$s'  order by PSSYSVIEWPANELMODELNAME", (Object)strPSSysPanelId);
    }

    protected String getSQL_getPSPanelEngines(String strPSPanelId) {
        if (strPSPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELENGINE_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s' AND  t1.srfdraftflag = 0 order by PSPANELENGINENAME", (Object)strPSPanelId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELENGINE t1 where  t1.PSSYSVIEWPANELID='%1$s'  order by PSPANELENGINENAME", (Object)strPSPanelId);
    }

    public CallResult getPSPanelEnginesBySystem(String strPSSystemId, Vector<PSPanelEngine> psPanelEngineList) {
        return this.selectMulti(this.getSQL_getPSPanelEnginesBySystem(strPSSystemId), psPanelEngineList, PSPanelEngine.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelEnginesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELENGINE t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by PSPANELENGINENAME", (Object)strPSSystemId);
    }

    public CallResult getPSPanelItemLogicsBySystem(String strPSSystemId, Vector<PSPanelItemLogic> psPanelItemLogicList) {
        return this.selectMulti(this.getSQL_getPSPanelItemLogicsBySystem(strPSSystemId), psPanelItemLogicList, PSPanelItemLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelItemLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELITEMLOGIC t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelItemLogics(String strPSSysPanelId) {
        if (strPSSysPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELITEMLOGIC_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSSysPanelId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELITEMLOGIC t1 where  t1.PSSYSVIEWPANELID='%1$s' order by ORDERVALUE", (Object)strPSSysPanelId);
    }

    @Override
    public CallResult getPSPanelItemLogicType(String strPSPanelItemLogicTypeId, PSPanelItemLogicType psPanelItemLogicType) {
        return this.selectSingle(this.getSQL_getPSPanelItemLogicType(strPSPanelItemLogicTypeId), psPanelItemLogicType, "SYSTEM");
    }

    protected String getSQL_getPSPanelItemLogicType(String strPSPanelItemLogicTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPILOGICTYPE t1 where  t1.PSPILOGICTYPEID='%1$s'", (Object)strPSPanelItemLogicTypeId);
    }

    @Override
    public CallResult getPSPanelLogicLinkCondType(String strPSPanelLogicLinkCondTypeId, PSPanelLogicLinkCondType psPanelLogicLinkCondType) {
        return this.selectSingle(this.getSQL_getPSPanelLogicLinkCondType(strPSPanelLogicLinkCondTypeId), psPanelLogicLinkCondType, "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicLinkCondType(String strPSPanelLogicLinkCondTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSPANELLLCONDTYPE t1 where  t1.PSPANELLLCONDTYPEID='%1$s'", (Object)strPSPanelLogicLinkCondTypeId);
    }

    public CallResult getPSSysPanelLogicsBySystem(String strPSSystemId, Vector<PSSysPanelLogic> psSysPanelLogicList) {
        return this.selectMulti(this.getSQL_getPSSysPanelLogicsBySystem(strPSSystemId), psSysPanelLogicList, PSSysPanelLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysPanelLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELLOGIC t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by PSSYSVIEWPANELLOGICNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPanelLogics(String strPSSysPanelId) {
        if (strPSSysPanelId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSVIEWPANELLOGIC_TMP t1 where  t1.PSSYSVIEWPANELID='%1$s' AND  t1.srfdraftflag = 0 order by PSSYSVIEWPANELLOGICNAME", (Object)strPSSysPanelId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWPANELLOGIC t1 where  t1.PSSYSVIEWPANELID='%1$s'  order by PSSYSVIEWPANELLOGICNAME", (Object)strPSSysPanelId);
    }

    public CallResult getPSPanelLogicParamsBySystem(String strPSSystemId, Vector<PSPanelLogicParam> psPanelLogicParamList) {
        return this.selectMulti(this.getSQL_getPSPanelLogicParamsBySystem(strPSSystemId), psPanelLogicParamList, PSPanelLogicParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICPARAM t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by PSPANELLOGICPARAMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelLogicParams(String strPSPanelLogicId) {
        if (strPSPanelLogicId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELLOGICPARAM_TMP t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s' AND  t1.srfdraftflag = 0 order by PSPANELLOGICPARAMNAME", (Object)strPSPanelLogicId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICPARAM t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s'  order by PSPANELLOGICPARAMNAME", (Object)strPSPanelLogicId);
    }

    public CallResult getPSPanelLogicNodesBySystem(String strPSSystemId, Vector<PSPanelLogicNode> psPanelLogicNodeList) {
        return this.selectMulti(this.getSQL_getPSPanelLogicNodesBySystem(strPSSystemId), psPanelLogicNodeList, PSPanelLogicNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicNodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICNODE t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by PSPANELLOGICNODENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelLogicNodes(String strPSPanelLogicId) {
        if (strPSPanelLogicId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELLOGICNODE_TMP t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s' AND  t1.srfdraftflag = 0 order by PSPANELLOGICNODENAME", (Object)strPSPanelLogicId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICNODE t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s'  order by PSPANELLOGICNODENAME", (Object)strPSPanelLogicId);
    }

    public CallResult getPSPanelLogicLinksBySystem(String strPSSystemId, Vector<PSPanelLogicLink> psPanelLogicLinkList) {
        return this.selectMulti(this.getSQL_getPSPanelLogicLinksBySystem(strPSSystemId), psPanelLogicLinkList, PSPanelLogicLink.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicLinksBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICLINK t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelLogicLinks(String strPSPanelLogicId) {
        if (strPSPanelLogicId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELLOGICLINK_TMP t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSPanelLogicId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLOGICLINK t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s'  order by ORDERVALUE", (Object)strPSPanelLogicId);
    }

    public CallResult getPSPanelLogicNodeParamsBySystem(String strPSSystemId, Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList) {
        return this.selectMulti(this.getSQL_getPSPanelLogicNodeParamsBySystem(strPSSystemId), psPanelLogicNodeParamList, PSPanelLogicNodeParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicNodeParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLNPARAM t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelLogicNodeParams(String strPSPanelLogicId) {
        if (strPSPanelLogicId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELLNPARAM_TMP t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSPanelLogicId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLNPARAM t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s'  order by ORDERVALUE", (Object)strPSPanelLogicId);
    }

    public CallResult getPSPanelLogicLinkCondsBySystem(String strPSSystemId, Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList) {
        return this.selectMulti(this.getSQL_getPSPanelLogicLinkCondsBySystem(strPSSystemId), psPanelLogicLinkCondList, PSPanelLogicLinkCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicLinkCondsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLLCOND t1  inner join T_SRFPSSYSVIEWPANEL t2 on t1.PSSYSVIEWPANELID=t2.PSSYSVIEWPANELID where  t2.PSSYSTEMID='%1$s'  order by ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSPanelLogicLinkConds(String strPSPanelLogicId) {
        if (strPSPanelLogicId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSPANELLLCOND_TMP t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSPanelLogicId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSPANELLLCOND t1 where  t1.PSSYSVIEWPANELLOGICID='%1$s'  order by ORDERVALUE", (Object)strPSPanelLogicId);
    }

    @Override
    public CallResult getPSPanelLogicNodeType(String strPSPanelLogicNodeTypeId, PSPanelLogicNodeType psPanelLogicNodeType) {
        return this.selectSingle(this.getSQL_getPSPanelLogicNodeType(strPSPanelLogicNodeTypeId), psPanelLogicNodeType, "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicNodeType(String strPSPanelLogicNodeTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSPANELLNTYPE t1 where  t1.PSPANELLNTYPEID='%1$s'", (Object)strPSPanelLogicNodeTypeId);
    }

    @Override
    public CallResult getPSPanelLogicLinkType(String strPSPanelLogicLinkTypeId, PSPanelLogicLinkType psPanelLogicLinkType) {
        return this.selectSingle(this.getSQL_getPSPanelLogicLinkType(strPSPanelLogicLinkTypeId), psPanelLogicLinkType, "SYSTEM");
    }

    protected String getSQL_getPSPanelLogicLinkType(String strPSPanelLogicLinkTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSPANELLLTYPE t1 where  t1.PSPANELLLTYPEID='%1$s'", (Object)strPSPanelLogicLinkTypeId);
    }

    public CallResult getAllPSAppUIStyles2(String strPSApplicationId, Vector<PSAppUIStyle> psAppUIStyles) {
        return this.selectMulti(this.getSQL_getAllPSAppUIStyles(strPSApplicationId), psAppUIStyles, PSAppUIStyle.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppUIStyles(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUISTYLE t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    public CallResult getAllPSDynaDETempls2(String strPSSystemId, Vector<PSDynaDETempl> psDynaDETemplList) {
        return this.selectMulti(this.getSQL_getAllPSDynaDETempls(strPSSystemId), psDynaDETemplList, PSDynaDETempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDynaDETempls(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADETEMPL t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDynaDETempl(String strPSDynaDETemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADETEMPL t1 where  t1.PSDYNADETEMPLID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDynaDETemplId);
    }

    public CallResult getAllPSDynaDEViewTemplsBySystem(String strPSSystemId, Vector<PSDynaDEViewTempl> psDynaDEViewTemplList) {
        return this.selectMulti(this.getSQL_getAllPSDynaDEViewTemplsBySystem(strPSSystemId), psDynaDEViewTemplList, PSDynaDEViewTempl.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getAllPSDynaDEViewTemplsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDYNADEVIEWTEMPL t1 INNER JOIN T_SRFPSDYNADETEMPL t2 ON t1.PSDYNADETEMPLID=t2.PSDYNADETEMPLID  where  t2.PSSYSTEMID='%1$s'", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDynaDEViewTempl(String strPSDynaDEViewTemplId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDYNADEVIEWTEMPL t1 where  t1.PSDYNADEVIEWTEMPLID='%1$s'", (Object)strPSDynaDEViewTemplId);
    }

    @Override
    public CallResult getPSAppUtilView(String strPSAppUtilViewId, PSAppUtilView psAppUtilView) {
        return this.selectSingle(this.getSQL_getPSAppUtilView(strPSAppUtilViewId), psAppUtilView, "SYSTEM");
    }

    protected String getSQL_getPSAppUtilView(String strPSAppUtilViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPUTILVIEW t1 where  t1.PSAPPUTILVIEWID='%1$s'", (Object)strPSAppUtilViewId);
    }

    @Override
    public CallResult getPSAppPanelView(String strPSAppPanelViewId, PSAppPanelView psAppPanelView) {
        return this.selectSingle(this.getSQL_getPSAppPanelView(strPSAppPanelViewId), psAppPanelView, "SYSTEM");
    }

    protected String getSQL_getPSAppPanelView(String strPSAppPanelViewId) {
        if (strPSAppPanelViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPPANELVIEW_TMP t1 where  t1.PSAPPPANELVIEWID='%1$s'", (Object)strPSAppPanelViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPPANELVIEW t1 where  t1.PSAPPPANELVIEWID='%1$s'", (Object)strPSAppPanelViewId);
    }

    @Override
    public CallResult getPSSysUtilType(String strPSSysUtilTypeId, PSSysUtilType psSysUtilType) {
        return this.selectSingle(this.getSQL_getPSSysUtilType(strPSSysUtilTypeId), psSysUtilType, "SYSTEM");
    }

    protected String getSQL_getPSSysUtilType(String strPSSysUtilTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSUTILTYPE t1 where  t1.PSSYSUTILTYPEID='%1$s'", (Object)strPSSysUtilTypeId);
    }

    public CallResult getAllPSSysServiceAPIHandlers2(String strPSSystemId, Vector<PSSysServiceAPIHandler> psSysServiceAPIHandlerList) {
        return this.selectMulti(this.getSQL_getAllPSSysServiceAPIHandlers(strPSSystemId), psSysServiceAPIHandlerList, PSSysServiceAPIHandler.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysServiceAPIHandlers(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSAHANDLER t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysServiceAPIHandler(String strPSSysServiceAPIHandlerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSAHANDLER t1 where  t1.PSSYSSAHANDLERID='%1$s' ", (Object)strPSSysServiceAPIHandlerId);
    }

    public CallResult getAllPSAppPDTViews2(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViews) {
        return this.selectMulti(this.getSQL_getAllPSAppPDTViews(strPSApplicationId), psAppPDTViews, PSAppPDTView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppPDTViews(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPPDTVIEW t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppPDTView(String strPSAppPDTViewId, PSAppPDTView psAppPDTView) {
        return this.selectSingle(this.getSQL_getPSAppPDTView(strPSAppPDTViewId), psAppPDTView, "SYSTEM");
    }

    protected String getSQL_getPSAppPDTView(String strPSAppPDTViewId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPPDTVIEW t1 where  t1.PSAPPPDTVIEWID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSAppPDTViewId);
    }

    public CallResult getPSDynaDEViewTemplsBySystem(String strPSSystemId, Vector<PSDynaDEViewTempl> psDynaDEViewTemplList) {
        return this.selectMulti(this.getSQL_getPSDynaDEViewTemplsBySystem(strPSSystemId), psDynaDEViewTemplList, PSDynaDEViewTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDynaDEViewTemplsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADEVIEWTEMPL t1  inner join T_SRFPSDYNADETEMPL t2 on t1.PSDYNADETEMPLID=t2.PSDYNADETEMPLID where  t2.PSSYSTEMID='%1$s'  order by PSDYNADEVIEWTEMPLNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDynaDEViewTempls(String strPSDynaDETemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADEVIEWTEMPL t1 where  t1.PSDYNADETEMPLID='%1$s' order by PSDYNADEVIEWTEMPLNAME", (Object)strPSDynaDETemplId);
    }

    public CallResult getPSDynaDEFormTemplsBySystem(String strPSSystemId, Vector<PSDynaDEFormTempl> psDynaDEFormTemplList) {
        return this.selectMulti(this.getSQL_getPSDynaDEFormTemplsBySystem(strPSSystemId), psDynaDEFormTemplList, PSDynaDEFormTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDynaDEFormTemplsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADEFORMTEMPL t1  inner join T_SRFPSDYNADETEMPL t2 on t1.PSDYNADETEMPLID=t2.PSDYNADETEMPLID where  t2.PSSYSTEMID='%1$s'  order by PSDYNADEFORMTEMPLNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDynaDEFormTempls(String strPSDynaDETemplId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDYNADEFORMTEMPL t1 where  t1.PSDYNADETEMPLID='%1$s' order by PSDYNADEFORMTEMPLNAME", (Object)strPSDynaDETemplId);
    }

    @Override
    public CallResult getPSDevSlnMSDepFuncItems(String strPSDevSlnMSDepFuncId, Vector<PSDevSlnMSDepFuncItem> psDevSlnMSDepFuncItemList) {
        return this.selectMulti(this.getSQL_getPSDevSlnMSDepFuncItems(strPSDevSlnMSDepFuncId), psDevSlnMSDepFuncItemList, PSDevSlnMSDepFuncItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepFuncItems(String strPSDevSlnMSDepFuncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPFUNCITEM t1 where  t1.PSDEVSLNMSDEPFUNCID='%1$s' ", (Object)strPSDevSlnMSDepFuncId);
    }

    @Override
    public CallResult getPSDevSlnMSDepFunc(String strPSDevSlnMSDepFuncId, PSDevSlnMSDepFunc psDevSlnMSDepFunc) {
        return this.selectSingle(this.getSQL_getPSDevSlnMSDepFunc(strPSDevSlnMSDepFuncId), psDevSlnMSDepFunc, "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepFunc(String strPSDevSlnMSDepFuncId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPFUNC t1 where  t1.PSDEVSLNMSDEPFUNCID='%1$s' and t1.VALIDFLAG = 1", (Object)strPSDevSlnMSDepFuncId);
    }

    @Override
    public CallResult getPSDevSlnMSDepFuncs(String strPSDevSlnSysId, Vector<PSDevSlnMSDepFunc> psDevSlnMSDepFuncList) {
        return this.selectMulti(this.getSQL_getPSDevSlnMSDepFuncs(strPSDevSlnSysId), psDevSlnMSDepFuncList, PSDevSlnMSDepFunc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnMSDepFuncs(String strPSDevSlnSysId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEVSLNMSDEPFUNC t1 where  t1.PSDEVSLNSYSID='%1$s'  and t1.VALIDFLAG = 1 ", (Object)strPSDevSlnSysId);
    }

    @Override
    public CallResult getPSSFPubObj(String strPSSFPubObjId, PSSFPubObj psSFPubObj) {
        return this.selectSingle(this.getSQL_getPSSFPubObj(strPSSFPubObjId), psSFPubObj, "SYSTEM");
    }

    protected String getSQL_getPSSFPubObj(String strPSSFPubObjId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFPUBOBJ t1 where  t1.PSSFPUBOBJID='%1$s'", (Object)strPSSFPubObjId);
    }

    @Override
    public CallResult getPSPFPubObj(String strPSPFPubObjId, PSPFPubObj psPFPubObj) {
        return this.selectSingle(this.getSQL_getPSPFPubObj(strPSPFPubObjId), psPFPubObj, "SYSTEM");
    }

    protected String getSQL_getPSPFPubObj(String strPSPFPubObjId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSPFPUBOBJ t1 where  t1.PSPFPUBOBJID='%1$s'", (Object)strPSPFPubObjId);
    }

    @Override
    public CallResult getPSSysDBValueOP(String strPSSystemId, String strPSSysDBValueOPId, PSSysDBValueOP psSysDBValueOP) {
        return this.selectSingle(this.getSQL_getPSSysDBValueOP(strPSSystemId, strPSSysDBValueOPId), psSysDBValueOP, "SYSTEM");
    }

    protected String getSQL_getPSSysDBValueOP(String strPSSystemId, String strPSSysDBValueOPId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDBVALUEOP t1 where t1.PSSYSTEMID='%1$s' AND  t1.PSSYSDBVALUEOPID='%2$s'", (Object)strPSSystemId, (Object)strPSSysDBValueOPId);
    }

    @Override
    public CallResult getPSUIEngineType(String strPSUIEngineTypeId, PSUIEngineType psUIEngineType) {
        return this.selectSingle(this.getSQL_getPSUIEngineType(strPSUIEngineTypeId), psUIEngineType, "SYSTEM");
    }

    protected String getSQL_getPSUIEngineType(String strPSUIEngineTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSUIENGINETYPE t1 where  t1.PSUIENGINETYPEID='%1$s'", (Object)strPSUIEngineTypeId);
    }

    public CallResult getPSSysViewLogicParamsBySystem(String strPSSystemId, Vector<PSSysViewLogicParam> psSysViewLogicParamList) {
        return this.selectMulti(this.getSQL_getPSSysViewLogicParamsBySystem(strPSSystemId), psSysViewLogicParamList, PSSysViewLogicParam.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysViewLogicParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSVIEWLOGICPARAM t1  inner join t_srfPSSYSVIEWLOGIC t2 on t1.PSSYSVIEWLOGICID=t2.PSSYSVIEWLOGICID where  t2.PSSYSTEMID='%1$s' order by PSSYSVIEWLOGICPARAMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysViewLogicParams(String strPSSysViewLogicId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSVIEWLOGICPARAM t1 where  t1.PSSYSVIEWLOGICID='%1$s' order by ORDERVALUE", (Object)strPSSysViewLogicId);
    }

    @Override
    public CallResult getPSDCMavenRepo(String strPSDCMavenRepoId, PSDCMavenRepo psDCMavenRepo) {
        return this.selectSingle(this.getSQL_getPSDCMavenRepo(strPSDCMavenRepoId), psDCMavenRepo, "SYSTEM");
    }

    protected String getSQL_getPSDCMavenRepo(String strPSDCMavenRepoId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDCMAVENREPO t1 where  t1.PSDCMAVENREPOID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSDCMavenRepoId);
    }

    public CallResult getAllPSSysFiles2(String strPSSystemId, Vector<PSSysFile> psSysFileList) {
        return this.selectMulti(this.getSQL_getAllPSSysFiles(strPSSystemId), psSysFileList, PSSysFile.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysFiles(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSFILE t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysFile(String strPSSysFileId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSFILE t1 where  t1.PSSYSFILEID='%1$s'", (Object)strPSSysFileId);
    }

    @Override
    public CallResult getPSDevSlnTempls(String strPSDevSlnSysId, Vector<PSDevSlnTempl> psDevSlnTemplList) {
        return this.selectMulti(this.getSQL_getPSDevSlnTempls(strPSDevSlnSysId), psDevSlnTemplList, PSDevSlnTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnTempls(String strPSDevSlnSysId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNTEMPL t1 where  t1.PSDEVSLNSYSID='%1$s' ", (Object)strPSDevSlnSysId);
    }

    @Override
    public CallResult getPSWorkspaceType(String strPSWorkspaceTypeId, PSWorkspaceType psWorkspaceType) {
        return this.selectSingle(this.getSQL_getPSWorkspaceType(strPSWorkspaceTypeId), psWorkspaceType, "SYSTEM");
    }

    protected String getSQL_getPSWorkspaceType(String strPSWorkspaceTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWORKSPACETYPE t1 where  t1.PSWORKSPACETYPEID='%1$s'", (Object)strPSWorkspaceTypeId);
    }

    @Override
    public CallResult getPSAppWF(String strPSAppWFId, PSAppWF psAppWF) {
        return this.selectSingle(this.getSQL_getPSAppWF(strPSAppWFId), psAppWF, "SYSTEM");
    }

    protected String getSQL_getPSAppWF(String strPSAppWFId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPWF t1 where  t1.PSAPPWFID='%1$s'", (Object)strPSAppWFId);
    }

    public CallResult getAllPSAppWFs2(String strPSApplicationId, Vector<PSAppWF> psAppWFs) {
        return this.selectMulti(this.getSQL_getAllPSAppWFs(strPSApplicationId), psAppWFs, PSAppWF.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppWFs(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPWF t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppWFVer(String strPSAppWFVerId, PSAppWFVer psAppWFVer) {
        return this.selectSingle(this.getSQL_getPSAppWFVer(strPSAppWFVerId), psAppWFVer, "SYSTEM");
    }

    protected String getSQL_getPSAppWFVer(String strPSAppWFVerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPWFVER t1 where  t1.PSAPPWFVERID='%1$s'", (Object)strPSAppWFVerId);
    }

    public CallResult getAllPSAppWFVers2(String strPSApplicationId, Vector<PSAppWFVer> psAppWFVers) {
        return this.selectMulti(this.getSQL_getAllPSAppWFVers(strPSApplicationId), psAppWFVers, PSAppWFVer.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppWFVers(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPWFVER t1 where  t1.PSSYSAPPID='%1$s'", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSDEFGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEFGroupsBySystem(String strPSSystemId, Vector<PSDEFGroup> psDEFGroupList) {
        return this.selectMulti(this.getSQL_getPSDEFGroupsBySystem(strPSSystemId), psDEFGroupList, PSDEFGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFGROUP t1 INNER JOIN T_SRFPSDATAENTITY t2 on t1.PSDEID = t2.PSDATAENTITYID where  t2.PSSYSTEMID='%1$s' AND t1.PSDEID IS NOT NULL ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFGroupDetails(String strPSDEFGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFGROUPDETAIL t1 where t1.VALIDFLAG = 1 AND t1.PSDEFGROUPID = '%1$s' order by ORDERVALUE", (Object)strPSDEFGroupId);
    }

    public CallResult getPSDEFGroupDetailsBySystem(String strPSSystemId, Vector<PSDEFGroupDetail> psDEFGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEFGroupDetailsBySystem(strPSSystemId), psDEFGroupDetailList, PSDEFGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFGROUPDETAIL t1 INNER JOIN T_SRFPSDEFGROUP t2 on t1.PSDEFGROUPID = t2.PSDEFGROUPID INNER JOIN T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t1.VALIDFLAG = 1 AND t3.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEFGroup(String strPSDEFGroupId, PSDEFGroup psDEFGroup) {
        return this.selectSingle(this.getSQL_getPSDEFGroup(strPSDEFGroupId), psDEFGroup, "SYSTEM");
    }

    protected String getSQL_getPSDEServiceAPIRSs(String strPSSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESARS t1 where  t1.PSSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSysServiceAPIId);
    }

    public CallResult getPSDEServiceAPIRSsBySystem(String strPSSystemId, Vector<PSDESARS> psDEServiceAPIRSList) {
        return this.selectMulti(this.getSQL_getPSDEServiceAPIRSsBySystem(strPSSystemId), psDEServiceAPIRSList, PSDESARS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEServiceAPIRSsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESARS t1  inner join  T_SRFPSSYSSERVICEAPI t2 on t1.PSSYSSERVICEAPIID = t2.PSSYSSERVICEAPIID where  t2.PSSYSTEMID ='%1$s'  AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    public CallResult getAllPSAppDERSs2(String strPSApplicationId, Vector<PSAppDERS> psAppDERSs) {
        return this.selectMulti(this.getSQL_getAllPSAppDERSs(strPSApplicationId), psAppDERSs, PSAppDERS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppDERSs(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPDERS t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppDERS(String strPSAppDERSId, PSAppDERS psAppDERS) {
        return this.selectSingle(this.getSQL_getPSAppDERS(strPSAppDERSId), psAppDERS, "SYSTEM");
    }

    protected String getSQL_getPSAppDERS(String strPSAppDERSId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPDERS t1 where  t1.PSAPPDERSID='%1$s'  AND t1.VALIDFLAG = 1", (Object)strPSAppDERSId);
    }

    protected String getSQL_getPSSubSysSADEs(String strPSSubSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* FROM T_SRFPSSUBSYSSADE t1 where  t1.PSSUBSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSubSysServiceAPIId);
    }

    protected String getSQL_getPSSubSysSADERSs(String strPSSubSysServiceAPIId) {
        return StringHelper.Format((String)"select t1.* FROM T_SRFPSSUBSYSSADERS t1 where  t1.PSSUBSYSSERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSubSysServiceAPIId);
    }

    public CallResult getPSSubSysSADetailsBySystem(String strPSSystemId, Vector<PSSubSysSADetail> psSubSysSADetailList) {
        return this.selectMulti(this.getSQL_getPSSubSysSADetailsBySystem(strPSSystemId), psSubSysSADetailList, PSSubSysSADetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSubSysSADetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSUBSYSSADETAIL t1 inner join T_SRFPSSUBSYSSERVICEAPI t2 on t1.PSSUBSYSSERVICEAPIID= t2.PSSUBSYSSERVICEAPIID where t2.PSSYSTEMID= '%1$s' AND t1.VALIDFLAG = 1 AND t2.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getPSSubSysSADEsBySystem(String strPSSystemId, Vector<PSSubSysSADE> psSubSysSADEList) {
        return this.selectMulti(this.getSQL_getPSSubSysSADEsBySystem(strPSSystemId), psSubSysSADEList, PSSubSysSADE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSubSysSADEsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSUBSYSSADE t1 inner join T_SRFPSSUBSYSSERVICEAPI t2 on t1.PSSUBSYSSERVICEAPIID= t2.PSSUBSYSSERVICEAPIID where t2.PSSYSTEMID= '%1$s' AND t1.VALIDFLAG = 1 AND t2.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getPSSubSysSADERSsBySystem(String strPSSystemId, Vector<PSSubSysSADERS> psSubSysSADERSList) {
        return this.selectMulti(this.getSQL_getPSSubSysSADERSsBySystem(strPSSystemId), psSubSysSADERSList, PSSubSysSADERS.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSubSysSADERSsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSUBSYSSADERS t1 inner join T_SRFPSSUBSYSSERVICEAPI t2 on t1.PSSUBSYSSERVICEAPIID= t2.PSSUBSYSSERVICEAPIID where t2.PSSYSTEMID= '%1$s' AND t1.VALIDFLAG = 1 AND t2.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getPSSubSysSADEFieldsBySystem(String strPSSystemId, Vector<PSSubSysSADEField> psSubSysSADEFieldList) {
        return this.selectMulti(this.getSQL_getPSSubSysSADEFieldsBySystem(strPSSystemId), psSubSysSADEFieldList, PSSubSysSADEField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSubSysSADEFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSUBSYSSADEFIELD  t1 inner join T_SRFPSSUBSYSSADE t2 on t1.PSSUBSYSSADEID= t2.PSSUBSYSSADEID inner join T_SRFPSSUBSYSSERVICEAPI t3 on t2.PSSUBSYSSERVICEAPIID = t3.PSSUBSYSSERVICEAPIID  where t3.PSSYSTEMID= '%1$s' AND t1.VALIDFLAG = 1 AND t2.VALIDFLAG = 1 AND t3.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSUBSYSSADEFIELDNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSubSysSADEFields(String strPSSubSysSADEId) {
        return StringHelper.Format((String)"SELECT t1.* FROM T_SRFPSSUBSYSSADEFIELD t1 WHERE t1.PSSUBSYSSADEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSUBSYSSADEFIELDNAME ", (Object)strPSSubSysSADEId);
    }

    public CallResult getAllPSSysDBSchemes2(String strPSSystemId, Vector<PSSysDBScheme> psSysDBSchemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysDBSchemes(strPSSystemId), psSysDBSchemeList, PSSysDBScheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDBSchemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBSCHEME t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDBScheme(String strPSSysDBSchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBSCHEME t1 where t1.PSSYSDBSCHEMEID='%1$s'", (Object)strPSSysDBSchemeId);
    }

    public CallResult getPSSysDBTablesBySystem(String strPSSystemId, Vector<PSSysDBTable> psSysDBTableList) {
        return this.selectMulti(this.getSQL_getPSSysDBTablesBySystem(strPSSystemId), psSysDBTableList, PSSysDBTable.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDBTablesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBTABLE t1  INNER JOIN T_SRFPSSYSDBSCHEME t2 on t1.PSSYSDBSCHEMEID=t2.PSSYSDBSCHEMEID WHERE  t2.PSSYSTEMID='%1$s' ORDER BY PSSYSDBTABLENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDBTables(String strPSSysDBSchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBTABLE t1 where  t1.PSSYSDBSCHEMEID='%1$s' order by PSSYSDBTABLENAME", (Object)strPSSysDBSchemeId);
    }

    protected String getSQL_getPSSysDBColumns(String strPSSysDBTableId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBCOLUMN t1 where  t1.PSSYSDBTABLEID='%1$s' ORDER BY t1.ORDERVALUE, t1.PSSYSDBCOLUMNNAME ", (Object)strPSSysDBTableId);
    }

    public CallResult getPSSysDBColumnsBySystem(String strPSSystemId, Vector<PSSysDBColumn> psSysDBColumnList) {
        return this.selectMulti(this.getSQL_getPSSysDBColumnsBySystem(strPSSystemId), psSysDBColumnList, PSSysDBColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDBColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBCOLUMN t1 LEFT JOIN T_SRFPSSYSDBTABLE t2 on t1.PSSYSDBTABLEID = t2.PSSYSDBTABLEID  LEFT JOIN T_SRFPSSYSDBSCHEME t3 on t2.PSSYSDBSCHEMEID = t3.PSSYSDBSCHEMEID   where  t3.PSSYSTEMID ='%1$s' ORDER BY t1.ORDERVALUE,t1.PSSYSDBCOLUMNNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDESAVRs(String strPSDEServiceAPIId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDESAVR t1 where t1.PSDESERVICEAPIID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSDEServiceAPIId);
    }

    public CallResult getPSDESAVRsBySystem(String strPSSystemId, Vector<PSDESAVR> psDESAVRList) {
        return this.selectMulti(this.getSQL_getPSDESAVRsBySystem(strPSSystemId), psDESAVRList, PSDESAVR.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDESAVRsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDESAVR  t1 inner join T_SRFPSDESERVICEAPI t2 on t1.PSDESERVICEAPIID= t2.PSDESERVICEAPIID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) AND t1.VALIDFLAG = 1 AND t2.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysResources2(String strPSSystemId, Vector<PSSysResource> psSysResourceList) {
        return this.selectMulti(this.getSQL_getAllPSSysResources(strPSSystemId), psSysResourceList, PSSysResource.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysResources(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSRESOURCE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysContentCats2(String strPSSystemId, Vector<PSSysContentCat> psSysContentCatList) {
        return this.selectMulti(this.getSQL_getAllPSSysContentCats2(strPSSystemId), psSysContentCatList, PSSysContentCat.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysContentCats(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENTCAT t1 where t1.PSSYSTEMID='%1$s' AND PPSSYSCONTENTCATID IS NULL ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSysContentCats2(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENTCAT t1 where t1.PSSYSTEMID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysContentCat(String strPSSysContentCatId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENTCAT t1 where t1.PSSYSCONTENTCATID='%1$s' ", (Object)strPSSysContentCatId);
    }

    protected String getSQL_getPSSysContentCats(String strPSSysContentCatId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENTCAT t1 where t1.PPSSYSCONTENTCATID='%1$s' ORDER BY t1.ORDERVALUE  ", (Object)strPSSysContentCatId);
    }

    public CallResult getAllPSSysContents2(String strPSSystemId, Vector<PSSysContent> psSysContentList) {
        return this.selectMulti(this.getSQL_getAllPSSysContents(strPSSystemId), psSysContentList, PSSysContent.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysContents(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENT t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysContents(String strPSSysContentCatId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENT t1 where t1.PSSYSCONTENTCATID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSysContentCatId);
    }

    protected String getSQL_getPSSysResource(String strPSSysResourceId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSRESOURCE t1 where t1.PSSYSRESOURCEID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysResourceId);
    }

    protected String getSQL_getPSSysContent(String strPSSysContentId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCONTENT t1 where t1.PSSYSCONTENTID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysContentId);
    }

    protected String getSQL_getAllPSAppResources(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPRESOURCE t1 where  t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppResource(String strPSAppResourceId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPRESOURCE t1 where  t1.PSAPPRESOURCEID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSAppResourceId);
    }

    protected String getSQL_getPSDEGroup(String strPSDEGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUP t1 where  t1.PSDEGROUPID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDEGroupId);
    }

    protected String getSQL_getPSDERGroup(String strPSDERGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUP t1 where  t1.PSDERGROUPID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDERGroupId);
    }

    protected String getSQL_getPSDEGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUP t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1  ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDERGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUP t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1  ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEGroupDetails(String strPSDEGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUPDETAIL t1 where  t1.PSDEGROUPID='%1$s'  AND t1.VALIDFLAG = 1 order by t1.ORDERVALUE", (Object)strPSDEGroupId);
    }

    protected String getSQL_getPSDERGroupDetails(String strPSDERGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUPDETAIL t1 where  t1.PSDERGROUPID='%1$s'  AND t1.VALIDFLAG = 1 order by t1.ORDERVALUE", (Object)strPSDERGroupId);
    }

    public CallResult getPSDEGroupDetailsBySystem(String strPSSystemId, Vector<PSDEGroupDetail> psDEGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEGroupDetailsBySystem(strPSSystemId), psDEGroupDetailList, PSDEGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUPDETAIL t1 INNER JOIN T_SRFPSDEGROUP t2 on t1.PSDEGROUPID = t2.PSDEGROUPID  where t1.VALIDFLAG = 1 AND t2.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    public CallResult getPSDERGroupDetailsBySystem(String strPSSystemId, Vector<PSDERGroupDetail> psDERGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDERGroupDetailsBySystem(strPSSystemId), psDERGroupDetailList, PSDERGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDERGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUPDETAIL t1 INNER JOIN T_SRFPSDERGROUP t2 on t1.PSDERGROUPID = t2.PSDERGROUPID  where t1.VALIDFLAG = 1 AND t2.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    public CallResult getPSDEGroupsBySystem(String strPSSystemId, Vector<PSDEGroup> psDEGroupList) {
        return this.selectMulti(this.getSQL_getPSDEGroupsBySystem(strPSSystemId), psDEGroupList, PSDEGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUP t1 where  t1.VALIDFLAG = 1 AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    public CallResult getPSDERGroupsBySystem(String strPSSystemId, Vector<PSDERGroup> psDERGroupList) {
        return this.selectMulti(this.getSQL_getPSDERGroupsBySystem(strPSSystemId), psDERGroupList, PSDERGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDERGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUP t1 where  t1.VALIDFLAG = 1 AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDEGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGROUP t1 where  t1.PSDEID IS NULL AND t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDERGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDERGROUP t1 where  t1.PSDEID IS NULL AND t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionGroup(String strPSDEActionGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONGROUP t1 where  t1.PSDEACTIONGROUPID='%1$s'", (Object)strPSDEActionGroupId);
    }

    protected String getSQL_getPSDEActionGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONGROUP t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    public CallResult getPSDEActionGroupsBySystem(String strPSSystemId, Vector<PSDEActionGroup> psDEActionGroupList) {
        return this.selectMulti(this.getSQL_getPSDEActionGroupsBySystem(strPSSystemId), psDEActionGroupList, PSDEActionGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONGROUP t1 INNER JOIN T_SRFPSDATAENTITY t2 on t1.PSDEID = t2.PSDATAENTITYID where  t2.PSSYSTEMID='%1$s' AND t1.PSDEID IS NOT NULL ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionGroupDetails(String strPSDEActionGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAGDETAIL t1 where t1.VALIDFLAG = 1 AND t1.PSDEACTIONGROUPID = '%1$s' order by ORDERVALUE", (Object)strPSDEActionGroupId);
    }

    public CallResult getPSDEActionGroupDetailsBySystem(String strPSSystemId, Vector<PSDEAGDetail> psDEActionGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSDEActionGroupDetailsBySystem(strPSSystemId), psDEActionGroupDetailList, PSDEAGDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEAGDETAIL t1 INNER JOIN T_SRFPSDEACTIONGROUP t2 on t1.PSDEACTIONGROUPID = t2.PSDEACTIONGROUPID INNER JOIN T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t1.VALIDFLAG = 1 AND t3.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEActionGroup(String strPSDEActionGroupId, PSDEActionGroup psDEActionGroup) {
        return this.selectSingle(this.getSQL_getPSDEActionGroup(strPSDEActionGroupId), psDEActionGroup, "SYSTEM");
    }

    public CallResult getAllPSSysTestPrjs2(String strPSSystemId, Vector<PSSysTestPrj> psSysTestPrjList) {
        return this.selectMulti(this.getSQL_getAllPSSysTestPrjs(strPSSystemId), psSysTestPrjList, PSSysTestPrj.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTestPrjs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTPRJ t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestPrj(String strPSSysTestPrjId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTPRJ t1 where  t1.PSSYSTESTPRJID='%1$s'", (Object)strPSSysTestPrjId);
    }

    public CallResult getAllPSSysTestModules2(String strPSSystemId, Vector<PSSysTestModule> psSysTestModuleList) {
        return this.selectMulti(this.getSQL_getAllPSSysTestModules(strPSSystemId), psSysTestModuleList, PSSysTestModule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTestModules(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTMODULE t1 INNER JOIN T_SRFPSSYSTESTPRJ t2 ON t1.PSSYSTESTPRJID = t2.PSSYSTESTPRJID  where t2.PSSYSTEMID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTestModule(String strPSSysTestModuleId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTMODULE t1 where  t1.PSSYSTESTMODULEID='%1$s'", (Object)strPSSysTestModuleId);
    }

    protected String getSQL_getPSSysTestModules(String strPSSysTestPrjId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTMODULE t1  where t1.PSSYSTESTPRJID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSysTestPrjId);
    }

    protected String getSQL_getPSSysTestCases(String strPSSysTestModuleId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTESTCASE t1  where t1.PSSYSTESTMODULEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSysTestModuleId);
    }

    public CallResult getAllPSSysReqModules2(String strPSSystemId, Vector<PSSysReqModule> psSysReqModuleList) {
        return this.selectMulti(this.getSQL_getAllPSSysReqModules2(strPSSystemId), psSysReqModuleList, PSSysReqModule.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysReqModules(String strPSSystemId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSTEMID='%1$s' AND PPSSYSREQMODULEID IS NULL AND (t1.MODULETYPE IS NULL OR t1.MODULETYPE <> 'AIAGENT') ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSTEMID='%1$s' AND PPSSYSREQMODULEID IS NULL ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSysReqModules2(String strPSSystemId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSTEMID='%1$s' AND (t1.MODULETYPE IS NULL OR t1.MODULETYPE <> 'AIAGENT') ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSTEMID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysReqModule(String strPSSysReqModuleId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSREQMODULEID='%1$s' AND (t1.MODULETYPE IS NULL OR t1.MODULETYPE <> 'AIAGENT')", (Object)strPSSysReqModuleId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PSSYSREQMODULEID='%1$s' ", (Object)strPSSysReqModuleId);
    }

    protected String getSQL_getPSSysReqModules(String strPSSysReqModuleId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PPSSYSREQMODULEID='%1$s' AND (t1.MODULETYPE IS NULL OR t1.MODULETYPE <> 'AIAGENT') ORDER BY t1.ORDERVALUE  ", (Object)strPSSysReqModuleId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQMODULE t1 where t1.PPSSYSREQMODULEID='%1$s' ORDER BY t1.ORDERVALUE  ", (Object)strPSSysReqModuleId);
    }

    public CallResult getAllPSSysReqItems2(String strPSSystemId, Vector<PSSysReqItem> psSysReqItemList) {
        return this.selectMulti(this.getSQL_getAllPSSysReqItems(strPSSystemId), psSysReqItemList, PSSysReqItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysReqItems(String strPSSystemId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQITEM t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 AND (t1.ITEMTYPE IS NULL OR t1.ITEMTYPE <> 'AIAGENT') ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQITEM t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysReqItem(String strPSSysReqItemId) {
        if (this.getModelInstVer() >= 803) {
            return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQITEM t1 where t1.PSSYSREQITEMID='%1$s' AND (t1.ITEMTYPE IS NULL OR t1.ITEMTYPE <> 'AIAGENT') ", (Object)strPSSysReqItemId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSREQITEM t1 where t1.PSSYSREQITEMID='%1$s' ", (Object)strPSSysReqItemId);
    }

    protected String getSQL_getPSDEDBTables(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDETABLE t1 where  t1.PSDEID='%1$s' ", (Object)strPSDataEntityId);
    }

    protected String getSQL_getPSDEDBTablesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDETABLE t1 inner join T_SRFPSDATAENTITY t2 on t1.PSDEID=t2.psdataentityid  where t2.pssystemid= '%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEUserRole(String strPSDEUserRoleId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEUSERROLE t1 where t1.PSDEUSERROLEID='%1$s'", (Object)strPSDEUserRoleId);
    }

    protected String getSQL_getPSCtrlLogicGroupDetails(String strPSCtrlLogicGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGRPDETAIL t1 where  t1.PSCTRLLOGICGROUPID='%1$s'  AND t1.VALIDFLAG = 1 order by t1.ORDERVALUE", (Object)strPSCtrlLogicGroupId);
    }

    protected String getSQL_getPSCtrlLogicGroup(String strPSCtrlLogicGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGROUP t1 where  t1.PSCTRLLOGICGROUPID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSCtrlLogicGroupId);
    }

    protected String getSQL_getPSCtrlLogicGroups(String strPSDataEntityId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGROUP t1 where  t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1  ", (Object)strPSDataEntityId);
    }

    public CallResult getPSCtrlLogicGroupDetailsBySystem(String strPSSystemId, Vector<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList) {
        return this.selectMulti(this.getSQL_getPSCtrlLogicGroupDetailsBySystem(strPSSystemId), psCtrlLogicGroupDetailList, PSCtrlLogicGroupDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSCtrlLogicGroupDetailsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGRPDETAIL t1 INNER JOIN T_SRFPSCTRLLOGICGROUP t2 on t1.PSCTRLLOGICGROUPID = t2.PSCTRLLOGICGROUPID  where t1.VALIDFLAG = 1 AND t2.PSSYSTEMID='%1$s' order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCtrlLogicGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGROUP t1 where  t1.PSDEID IS NULL AND t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getPSCtrlLogicGroupsBySystem(String strPSSystemId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
        return this.selectMulti(this.getSQL_getPSCtrlLogicGroupsBySystem(strPSSystemId), psCtrlLogicGroupList, PSCtrlLogicGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSCtrlLogicGroupsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSCTRLLOGICGROUP t1 where  t1.VALIDFLAG = 1 AND t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getAllPSSysModelGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMODELGROUP t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysModelGroup(String strPSSysModelGroupId, PSSysModelGroup psSysModelGroup) {
        return this.selectSingle(this.getSQL_getPSSysModelGroup(strPSSysModelGroupId), psSysModelGroup, "SYSTEM");
    }

    protected String getSQL_getPSSysModelGroup(String strPSSysModelGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMODELGROUP t1 where t1.PSSYSMODELGROUPID='%1$s' ", (Object)strPSSysModelGroupId);
    }

    public CallResult getAllPSSysSearchSchemes2(String strPSSystemId, Vector<PSSysSearchScheme> psSysSearchSchemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysSearchSchemes(strPSSystemId), psSysSearchSchemeList, PSSysSearchScheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSearchSchemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHSCHEME t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchScheme(String strPSSysSearchSchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHSCHEME t1 where  t1.PSSYSSEARCHSCHEMEID='%1$s'", (Object)strPSSysSearchSchemeId);
    }

    public CallResult getPSSysSearchDocsBySystem(String strPSSystemId, Vector<PSSysSearchDoc> psSysSearchDocList) {
        return this.selectMulti(this.getSQL_getPSSysSearchDocsBySystem(strPSSystemId), psSysSearchDocList, PSSysSearchDoc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchDocsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDOC t1  inner join T_SRFPSSYSSEARCHSCHEME t2 on t1.PSSYSSEARCHSCHEMEID=t2.PSSYSSEARCHSCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSSEARCHDOCNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchDocs(String strPSSysSearchSchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDOC t1 where  t1.PSSYSSEARCHSCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSSEARCHDOCNAME", (Object)strPSSysSearchSchemeId);
    }

    public CallResult getPSSysSearchDEsBySystem(String strPSSystemId, Vector<PSSysSearchDE> psSysSearchDEList) {
        return this.selectMulti(this.getSQL_getPSSysSearchDEsBySystem(strPSSystemId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchDEsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDE t1  inner join T_SRFPSSYSSEARCHSCHEME t2 on t1.PSSYSSEARCHSCHEMEID=t2.PSSYSSEARCHSCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSSEARCHDENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchDEs(String strPSSysSearchSchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDE t1 where  t1.PSSYSSEARCHSCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSSEARCHDENAME", (Object)strPSSysSearchSchemeId);
    }

    protected String getSQL_getPSSysSearchFields(String strPSSysSearchDocId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHFIELD t1 where  t1.PSSYSSEARCHDOCID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSSEARCHFIELDNAME ", (Object)strPSSysSearchDocId);
    }

    public CallResult getPSSysSearchFieldsBySystem(String strPSSystemId, Vector<PSSysSearchField> psSysSearchFieldList) {
        return this.selectMulti(this.getSQL_getPSSysSearchFieldsBySystem(strPSSystemId), psSysSearchFieldList, PSSysSearchField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHFIELD t1 LEFT JOIN T_SRFPSSYSSEARCHDOC t2 on t1.PSSYSSEARCHDOCID = t2.PSSYSSEARCHDOCID  LEFT JOIN T_SRFPSSYSSEARCHSCHEME t3 on t2.PSSYSSEARCHSCHEMEID = t3.PSSYSSEARCHSCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSSEARCHFIELDNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchDEFields(String strPSSysSearchDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDEFIELD t1 where  t1.PSSYSSEARCHDEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSSEARCHDEFIELDNAME ", (Object)strPSSysSearchDEId);
    }

    public CallResult getPSSysSearchDEFieldsBySystem(String strPSSystemId, Vector<PSSysSearchDEField> psSysSearchDEFieldList) {
        return this.selectMulti(this.getSQL_getPSSysSearchDEFieldsBySystem(strPSSystemId), psSysSearchDEFieldList, PSSysSearchDEField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchDEFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSSYSSEARCHDEFIELD t1 LEFT JOIN T_SRFPSSYSSEARCHDE t2 on t1.PSSYSSEARCHDEID = t2.PSSYSSEARCHDEID  LEFT JOIN T_SRFPSSYSSEARCHSCHEME t3 on t2.PSSYSSEARCHSCHEMEID = t3.PSSYSSEARCHSCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSSEARCHDEFIELDNAME ", (Object)strPSSystemId);
    }

    public CallResult getPSDESearchsBySystem(String strPSSystemId, Vector<PSSysSearchDE> psSysSearchDEList) {
        return this.selectMulti(this.getSQL_getPSDESearchsBySystem(strPSSystemId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDESearchsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDE t1 INNER JOIN T_SRFPSDATAENTITY t2 on t1.PSDEID=t2.PSDATAENTITYID  WHERE  t2.PSSYSTEMID='%1$s' and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) AND t1.VALIDFLAG = 1 ORDER BY PSSYSSEARCHDENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDESearchs(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDE t1 where t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSSEARCHDENAME", (Object)strPSDEId);
    }

    protected String getSQL_getPSSysSearchDEFieldsByDataEntity(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEARCHDEFIELD t1 LEFT JOIN T_SRFPSDEFIELD t2 on t1.PSDEFID=t2.PSDEFIELDID where t1.VALIDFLAG = 1 AND  t2.PSDEID='%1$s' ORDER BY t1.ORDERVALUE,t1.PSSYSSEARCHDEFIELDNAME ", (Object)strPSDEId);
    }

    public CallResult getAllPSSysMapViews2(String strPSSystemId, Vector<PSSysMapView> psSysMapViewList) {
        return this.selectMulti(this.getSQL_getAllPSSysMapViews(strPSSystemId), psSysMapViewList, PSSysMapView.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysMapViews(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMAPVIEW t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysMapView(String strPSSysMapViewId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMAPVIEW t1 where  t1.PSSYSMAPVIEWID='%1$s'", (Object)strPSSysMapViewId);
    }

    public CallResult getPSSysMapItemsBySystem(String strPSSystemId, Vector<PSSysMapItem> psSysMapItemList) {
        return this.selectMulti(this.getSQL_getPSSysMapItemsBySystem(strPSSystemId), psSysMapItemList, PSSysMapItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysMapItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMAPITEM t1  inner join T_SRFPSSYSMAPVIEW t2 on t1.PSSYSMAPVIEWID=t2.PSSYSMAPVIEWID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG=1  order by PSSYSMAPITEMNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysMapItems(String strPSSysMapViewId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMAPITEM t1 where  t1.PSSYSMAPVIEWID='%1$s' AND t1.VALIDFLAG=1 order by PSSYSMAPITEMNAME", (Object)strPSSysMapViewId);
    }

    @Override
    public CallResult getPSDEUtilType(String strPSDEUtilTypeId, PSDEUtilType psDEUtilType) {
        return this.selectSingle(this.getSQL_getPSDEUtilType(strPSDEUtilTypeId), psDEUtilType, "SYSTEM");
    }

    protected String getSQL_getPSDEUtilType(String strPSDEUtilTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEUTILTYPE t1 where t1.PSDEUTILTYPEID='%1$s'", (Object)strPSDEUtilTypeId);
    }

    @Override
    public CallResult getPSAppUtilType(String strPSAppUtilTypeId, PSAppUtilType psAppUtilType) {
        return this.selectSingle(this.getSQL_getPSAppUtilType(strPSAppUtilTypeId), psAppUtilType, "SYSTEM");
    }

    protected String getSQL_getPSAppUtilType(String strPSAppUtilTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPUTILTYPE t1 where t1.PSAPPUTILTYPEID='%1$s'", (Object)strPSAppUtilTypeId);
    }

    protected String getSQL_getAllPSAppUtils(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPUTIL t1 where t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppUtil(String strPSAppUtilId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPUTIL t1 where t1.PSAPPUTILID='%1$s'", (Object)strPSAppUtilId);
    }

    public CallResult getAllPSSysPortletCats2(String strPSSystemId, Vector<PSSysPortletCat> psSysPortletCatList) {
        return this.selectMulti(this.getSQL_getAllPSSysPortletCats(strPSSystemId), psSysPortletCatList, PSSysPortletCat.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysPortletCats(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSPORTLETCAT t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysPortletCat(String strPSSysPortletCatId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSPORTLETCAT t1 where  t1.PSSYSPORTLETCATID='%1$s'", (Object)strPSSysPortletCatId);
    }

    protected String getSQL_getAllPSAppPortlets(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPORTLET t1 where t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSAPPPORTLETNAME", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppPortlet(String strPSAppPortletId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPORTLET t1 where t1.PSAPPPORTLETID='%1$s'", (Object)strPSAppPortletId);
    }

    protected String getSQL_getAllPSAppPFPlugins(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPFPLUGIN t1 where t1.PSSYSAPPID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSAPPPFPLUGINNAME", (Object)strPSApplicationId);
    }

    protected String getSQL_getPSAppPFPlugin(String strPSAppPFPluginId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSAPPPFPLUGIN t1 where t1.PSAPPPFPLUGINID='%1$s'", (Object)strPSAppPFPluginId);
    }

    @Override
    public CallResult getPSDCRegistryRepo(String strPSDCRegistryRepoId, PSDCRegistryRepo psDCRegistryRepo) {
        return this.selectSingle(this.getSQL_getPSDCRegistryRepo(strPSDCRegistryRepoId), psDCRegistryRepo, "SYSTEM");
    }

    protected String getSQL_getPSDCRegistryRepo(String strPSDCRegistryRepoId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCREGISTRYREPO t1 where  t1.PSDCREGISTRYREPOID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSDCRegistryRepoId);
    }

    @Override
    public CallResult getPSRegistryRepo(String strPSRegistryRepoId, PSRegistryRepo psRegistryRepo) {
        return this.selectSingle(this.getSQL_getPSRegistryRepo(strPSRegistryRepoId), psRegistryRepo, "SYSTEM");
    }

    protected String getSQL_getPSRegistryRepo(String strPSRegistryRepoId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSREGISTRYREPO t1 where  t1.PSREGISTRYREPOID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSRegistryRepoId);
    }

    @Override
    public CallResult getPSDCWorkspace(String strPSDCWorkspaceId, PSDCWorkspace psDCWorkspace) {
        return this.selectSingle(this.getSQL_getPSDCWorkspace(strPSDCWorkspaceId), psDCWorkspace, "SYSTEM");
    }

    protected String getSQL_getPSDCWorkspace(String strPSDCWorkspaceId) {
        return String.format("SELECT t1.*, t11.CURACTION,t11.CURACTIVETIME,t11.CUREXPIREDTIME,t11.EXP,t11.EXP2,t11.EXPIREDTIME,t21.PSDEVSLNNAME,t11.PSWORKSPACENAME,t11.WORKSPACELEVEL,t11.WORKSPACESTATE,t11.WORKSPACETYPE,t11.UPDATEDATE AS WORKSPACEUPDATEDATE,t11.WORKSPACEUSAGE FROM T_SRFPSDCWORKSPACE t1 \r\nLEFT JOIN T_SRFPSWORKSPACE t11 ON t1.PSWORKSPACEID = t11.PSWORKSPACEID \r\nLEFT JOIN T_SRFPSDEVSLN t21 ON t1.PSDEVSLNID = t21.PSDEVSLNID where  t1.PSDCWORKSPACEID='%1$s'", strPSDCWorkspaceId);
    }

    protected String getSQL_getPSDEGridEditItemVRs(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEGEIVR_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIVR t1 where  t1.PSDEGRIDID='%1$s' ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    public CallResult getPSDEGridEditItemVRsBySystem(String strPSSystemId, Vector<PSDEGridEditItemVR> psDEGridEditItemVRList) {
        return this.selectMulti(this.getSQL_getPSDEGridEditItemVRsBySystem(strPSSystemId), psDEGridEditItemVRList, PSDEGridEditItemVR.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGridEditItemVRsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIVR t1 inner join T_SRFPSDEGRID t2 on t2.PSDEGRIDID =   t1.PSDEGRIDID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEActionVRs(String strPSDEActionId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONVR t1 where  t1.PSDEACTIONID='%1$s' order by t1.ORDERVALUE ", (Object)strPSDEActionId);
    }

    public CallResult getPSDEActionVRsBySystem(String strPSSystemId, Vector<PSDEActionVR> psDEActionVRList) {
        return this.selectMulti(this.getSQL_getPSDEActionVRsBySystem(strPSSystemId), psDEActionVRList, PSDEActionVR.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEActionVRsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEACTIONVR t1 inner join T_SRFPSDEACTION t2 on t1.PSDEACTIONID= t2.PSDEACTIONID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEMainStateFields(String strPSDEMainStateId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEMSFIELD t1 where  t1.PSDEMSID='%1$s' ", (Object)strPSDEMainStateId);
    }

    public CallResult getPSDEMainStateFieldsBySystem(String strPSSystemId, Vector<PSDEMainStateField> psDEMainStateFieldList) {
        return this.selectMulti(this.getSQL_getPSDEMainStateFieldsBySystem(strPSSystemId), psDEMainStateFieldList, PSDEMainStateField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEMainStateFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEID from T_SRFPSDEMSFIELD  t1 inner join T_SRFPSDEMAINSTATE t2 on t1.PSDEMSID= t2.PSDEMAINSTATEID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)  ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFGroupItems(String strPSDEFGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEFORMDETAIL t1  inner join t_SRFPSDEFORM t2 on t1.PSDEFORMID=t2.PSDEFORMID  inner join T_SRFPSDEFGROUP t3 on t2.PSDEFORMID = t3.PSDEFORMID   where  t3.PSDEFGROUPID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEFGroupId);
    }

    public CallResult getPSDEFGroupItemsBySystem(String strPSSystemId, Vector<PSDEFormDetail> psDEFormDetailList) {
        return this.selectMulti(this.getSQL_getPSDEFGroupItemsBySystem(strPSSystemId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFGroupItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t3.PSDEFGROUPID from T_SRFPSDEFORMDETAIL t1  inner join t_SRFPSDEFORM t2 on t1.PSDEFORMID=t2.PSDEFORMID  inner join T_SRFPSDEFGROUP t3 on t2.PSDEFORMID = t3.PSDEFORMID  inner join T_SRFPSDATAENTITY t4 on t3.PSDEID=t4.PSDATAENTITYID where  t4.PSSYSTEMID='%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFGroupColumns(String strPSDEFGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEGRIDCOL t1  inner join t_SRFPSDEGRID t2 on t1.PSDEGRIDID=t2.PSDEGRIDID  inner join T_SRFPSDEFGROUP t3 on t2.PSDEGRIDID = t3.PSDEGRIDID   where  t3.PSDEFGROUPID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEFGroupId);
    }

    public CallResult getPSDEFGroupColumnsBySystem(String strPSSystemId, Vector<PSDEGridColumn> psDEGridColumnList) {
        return this.selectMulti(this.getSQL_getPSDEFGroupColumnsBySystem(strPSSystemId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFGroupColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t3.PSDEFGROUPID from T_SRFPSDEGRIDCOL t1  inner join t_SRFPSDEGRID t2 on t1.PSDEGRIDID=t2.PSDEGRIDID  inner join T_SRFPSDEFGROUP t3 on t2.PSDEGRIDID = t3.PSDEGRIDID  inner join T_SRFPSDATAENTITY t4 on t3.PSDEID=t4.PSDATAENTITYID where  t4.PSSYSTEMID='%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDevSlnSysDepInst(String strPSDevSlnSysDepInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSDEPINST t1 where t1.PSDEVSLNSYSDEPINSTID='%1$s'", (Object)strPSDevSlnSysDepInstId);
    }

    protected String getSQL_getPSDevSlnSysDynaInst(String strPSDevSlnSysDynaInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSDYNAINST t1 where t1.PSDEVSLNSYSDYNAINSTID='%1$s'", (Object)strPSDevSlnSysDynaInstId);
    }

    @Override
    public CallResult getPSDevSlnSysDepInst(String strPSDevSlnSysDepInstId, PSDevSlnSysDepInst psDevSlnSysDepInst) {
        return this.selectSingle(this.getSQL_getPSDevSlnSysDepInst(strPSDevSlnSysDepInstId), psDevSlnSysDepInst, "SYSTEM");
    }

    @Override
    public CallResult getPSDevSlnSysDynaInst(String strPSDevSlnSysDynaInstId, PSDevSlnSysDynaInst psDevSlnSysDynaInst) {
        return this.selectSingle(this.getSQL_getPSDevSlnSysDynaInst(strPSDevSlnSysDynaInstId), psDevSlnSysDynaInst, "SYSTEM");
    }

    @Override
    public CallResult getPSDevSlnSysDynaInsts(String strPSDevSlnSysDynaInstId, Vector<PSDevSlnSysDynaInst> psDevSlnSysDynaInsts) {
        return this.selectMulti(this.getSQL_getPSDevSlnSysDynaInsts(strPSDevSlnSysDynaInstId), psDevSlnSysDynaInsts, PSDevSlnSysDynaInst.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnSysDynaInsts(String strPSDevSlnSysDynaInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSDYNAINST t1 where t1.PPSDEVSLNSYSDYNAINSTID = '%1$s' AND (t1.INSTSTATE >=30 AND t1.INSTSTATE <40) AND (t1.INSTTYPE = 'MODULE') ", (Object)strPSDevSlnSysDynaInstId);
    }

    @Override
    public CallResult getPSDevSlnSysDynaInstRefs(String strPSDevSlnSysDynaInstId, Vector<PSDevSlnSysDynaInstRef> psDevSlnSysDynaInstRefs) {
        return this.selectMulti(this.getSQL_getPSDevSlnSysDynaInstRefs(strPSDevSlnSysDynaInstId), psDevSlnSysDynaInstRefs, PSDevSlnSysDynaInstRef.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDevSlnSysDynaInstRefs(String strPSDevSlnSysDynaInstId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSDYNAINSTREF t1 where t1.PSDEVSLNSYSDYNAINSTID = '%1$s' AND (t1.VALIDFLAG =1) ORDER BY t1.ORDERVALUE  ", (Object)strPSDevSlnSysDynaInstId);
    }

    public CallResult getAllPSSysSequences2(String strPSSystemId, Vector<PSSysSequence> psSysSequenceList) {
        return this.selectMulti(this.getSQL_getAllPSSysSequences(strPSSystemId), psSysSequenceList, PSSysSequence.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysSequences(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEQUENCE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSequence(String strPSSysSequenceId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSSEQUENCE t1 where t1.PSSYSSEQUENCEID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysSequenceId);
    }

    public CallResult getAllPSSysTranslators2(String strPSSystemId, Vector<PSSysTranslator> psSysTranslatorList) {
        return this.selectMulti(this.getSQL_getAllPSSysTranslators(strPSSystemId), psSysTranslatorList, PSSysTranslator.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTranslators(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTRANSLATOR t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysTranslator(String strPSSysTranslatorId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTRANSLATOR t1 where t1.PSSYSTRANSLATORID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysTranslatorId);
    }

    protected String getSQL_getPSWFUtilUIActions(String strPSSysWFSettingId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSWFUTILUIACTION t1 where t1.PSSYSWFSETTINGID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSysWFSettingId);
    }

    public CallResult getAllPSSysMsgTargets2(String strPSSystemId, Vector<PSSysMsgTarget> psSysMsgTargetList) {
        return this.selectMulti(this.getSQL_getAllPSSysMsgTargets(strPSSystemId), psSysMsgTargetList, PSSysMsgTarget.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysMsgTargets(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMSGTARGET t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysMsgQueues2(String strPSSystemId, Vector<PSSysMsgQueue> psSysMsgQueueList) {
        return this.selectMulti(this.getSQL_getAllPSSysMsgQueues(strPSSystemId), psSysMsgQueueList, PSSysMsgQueue.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysMsgQueues(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSMSGQUEUE t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSSystemId);
    }

    public CallResult getPSDENotify(String strPSDENotifyId, PSDENotify psDENotify) {
        return this.selectSingle(this.getSQL_getPSDENotify(strPSDENotifyId), psDENotify, "SYSTEM");
    }

    protected String getSQL_getPSDENotify(String strPSDENotifyId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDENOTIFY t1 where  t1.PSDENOTIFYID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSDENotifyId);
    }

    protected String getSQL_getPSDENotifies(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDENOTIFY t1 where t1.PSDEID='%1$s' AND t1.VALIDFLAG = 1 ", (Object)strPSDEId);
    }

    public CallResult getPSDENotifiesBySystem(String strPSSystemId, Vector<PSDENotify> psDENotifyList) {
        return this.selectMulti(this.getSQL_getPSDENotifiesBySystem(strPSSystemId), psDENotifyList, PSDENotify.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDENotifiesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDENOTIFY t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDENotifyTargets(String strPSDENotifyId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDENOTIFYTARGET t1  inner join t_SRFPSDENOTIFY t2 on t1.PSDENOTIFYID=t2.PSDENOTIFYID  where t2.PSDENOTIFYID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSDENotifyId);
    }

    public CallResult getPSDENotifyTargetsBySystem(String strPSSystemId, Vector<PSDENotifyTarget> psDENotifyTargetList) {
        return this.selectMulti(this.getSQL_getPSDENotifyTargetsBySystem(strPSSystemId), psDENotifyTargetList, PSDENotifyTarget.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDENotifyTargetsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDENOTIFYTARGET t1 inner join t_SRFPSDENOTIFY t2 on t1.PSDENOTIFYID=t2.PSDENOTIFYID  inner join T_SRFPSDATAENTITY t3 on t2.PSDEID=t3.PSDATAENTITYID where  t3.PSSYSTEMID='%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) and t1.VALIDFLAG = 1  ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysEAISchemes2(String strPSSystemId, Vector<PSSysEAIScheme> psSysEAISchemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysEAISchemes(strPSSystemId), psSysEAISchemeList, PSSysEAIScheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysEAISchemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAISCHEME t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIScheme(String strPSSysEAISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAISCHEME t1 where  t1.PSSYSEAISCHEMEID='%1$s'", (Object)strPSSysEAISchemeId);
    }

    public CallResult getPSSysEAIDataTypesBySystem(String strPSSystemId, Vector<PSSysEAIDataType> psSysEAIDataTypeList) {
        return this.selectMulti(this.getSQL_getPSSysEAIDataTypesBySystem(strPSSystemId), psSysEAIDataTypeList, PSSysEAIDataType.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIDataTypesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDATATYPE t1  inner join T_SRFPSSYSEAISCHEME t2 on t1.PSSYSEAISCHEMEID=t2.PSSYSEAISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIDATATYPENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIDataTypes(String strPSSysEAISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDATATYPE t1 where  t1.PSSYSEAISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIDATATYPENAME", (Object)strPSSysEAISchemeId);
    }

    public CallResult getPSSysEAIElementsBySystem(String strPSSystemId, Vector<PSSysEAIElement> psSysEAIElementList) {
        return this.selectMulti(this.getSQL_getPSSysEAIElementsBySystem(strPSSystemId), psSysEAIElementList, PSSysEAIElement.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIElementsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENT t1  inner join T_SRFPSSYSEAISCHEME t2 on t1.PSSYSEAISCHEMEID=t2.PSSYSEAISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIELEMENTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIElements(String strPSSysEAISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENT t1 where  t1.PSSYSEAISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIELEMENTNAME", (Object)strPSSysEAISchemeId);
    }

    public CallResult getPSSysEAIDEsBySystem(String strPSSystemId, Vector<PSSysEAIDE> psSysEAIDEList) {
        return this.selectMulti(this.getSQL_getPSSysEAIDEsBySystem(strPSSystemId), psSysEAIDEList, PSSysEAIDE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIDEsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDE t1  inner join T_SRFPSSYSEAISCHEME t2 on t1.PSSYSEAISCHEMEID=t2.PSSYSEAISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIDENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIDEs(String strPSSysEAISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDE t1 where  t1.PSSYSEAISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSEAIDENAME", (Object)strPSSysEAISchemeId);
    }

    protected String getSQL_getPSSysEAIDataTypeItems(String strPSSysEAIDataTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDATATYPEITEM t1 where  t1.PSSYSEAIDATATYPEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSEAIDATATYPEITEMNAME ", (Object)strPSSysEAIDataTypeId);
    }

    public CallResult getPSSysEAIDataTypeItemsBySystem(String strPSSystemId, Vector<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList) {
        return this.selectMulti(this.getSQL_getPSSysEAIDataTypeItemsBySystem(strPSSystemId), psSysEAIDataTypeItemList, PSSysEAIDataTypeItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIDataTypeItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDATATYPEITEM t1 LEFT JOIN T_SRFPSSYSEAIDATATYPE t2 on t1.PSSYSEAIDATATYPEID = t2.PSSYSEAIDATATYPEID  LEFT JOIN T_SRFPSSYSEAISCHEME t3 on t2.PSSYSEAISCHEMEID = t3.PSSYSEAISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSEAIDATATYPEITEMNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIElementAttrs(String strPSSysEAIElementId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENTATTR t1 where  t1.PSSYSEAIELEMENTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSEAIELEMENTATTRNAME ", (Object)strPSSysEAIElementId);
    }

    public CallResult getPSSysEAIElementAttrsBySystem(String strPSSystemId, Vector<PSSysEAIElementAttr> psSysEAIElementAttrList) {
        return this.selectMulti(this.getSQL_getPSSysEAIElementAttrsBySystem(strPSSystemId), psSysEAIElementAttrList, PSSysEAIElementAttr.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIElementAttrsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENTATTR t1 LEFT JOIN T_SRFPSSYSEAIELEMENT t2 on t1.PSSYSEAIELEMENTID = t2.PSSYSEAIELEMENTID  LEFT JOIN T_SRFPSSYSEAISCHEME t3 on t2.PSSYSEAISCHEMEID = t3.PSSYSEAISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSEAIELEMENTATTRNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIElementREs(String strPSSysEAIElementId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENTRE t1 where  t1.PSSYSEAIELEMENTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSEAIELEMENTRENAME ", (Object)strPSSysEAIElementId);
    }

    public CallResult getPSSysEAIElementREsBySystem(String strPSSystemId, Vector<PSSysEAIElementRE> psSysEAIElementREList) {
        return this.selectMulti(this.getSQL_getPSSysEAIElementREsBySystem(strPSSystemId), psSysEAIElementREList, PSSysEAIElementRE.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIElementREsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIELEMENTRE t1 LEFT JOIN T_SRFPSSYSEAIELEMENT t2 on t1.PSSYSEAIELEMENTID = t2.PSSYSEAIELEMENTID  LEFT JOIN T_SRFPSSYSEAISCHEME t3 on t2.PSSYSEAISCHEMEID = t3.PSSYSEAISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSEAIELEMENTRENAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIDEFields(String strPSSysEAIDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDEFIELD t1 where  t1.PSSYSEAIDEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSEAIDEFIELDNAME ", (Object)strPSSysEAIDEId);
    }

    public CallResult getPSSysEAIDEFieldsBySystem(String strPSSystemId, Vector<PSSysEAIDEField> psSysEAIDEFieldList) {
        return this.selectMulti(this.getSQL_getPSSysEAIDEFieldsBySystem(strPSSystemId), psSysEAIDEFieldList, PSSysEAIDEField.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIDEFieldsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDEFIELD t1 LEFT JOIN T_SRFPSSYSEAIDE t2 on t1.PSSYSEAIDEID = t2.PSSYSEAIDEID  LEFT JOIN T_SRFPSSYSEAISCHEME t3 on t2.PSSYSEAISCHEMEID = t3.PSSYSEAISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSEAIDEFIELDNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysEAIDERs(String strPSSysEAIDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDER t1 where  t1.PSSYSEAIDEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSEAIDERNAME ", (Object)strPSSysEAIDEId);
    }

    public CallResult getPSSysEAIDERsBySystem(String strPSSystemId, Vector<PSSysEAIDER> psSysEAIDERList) {
        return this.selectMulti(this.getSQL_getPSSysEAIDERsBySystem(strPSSystemId), psSysEAIDERList, PSSysEAIDER.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysEAIDERsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSEAIDER t1 LEFT JOIN T_SRFPSSYSEAIDE t2 on t1.PSSYSEAIDEID = t2.PSSYSEAIDEID  LEFT JOIN T_SRFPSSYSEAISCHEME t3 on t2.PSSYSEAISCHEMEID = t3.PSSYSEAISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSEAIDERNAME ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysBISchemes2(String strPSSystemId, Vector<PSSysBIScheme> psSysBISchemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysBISchemes(strPSSystemId), psSysBISchemeList, PSSysBIScheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysBISchemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBISCHEME t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBIScheme(String strPSSysBISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBISCHEME t1 where  t1.PSSYSBISCHEMEID='%1$s'", (Object)strPSSysBISchemeId);
    }

    public CallResult getPSSysBIDimensionsBySystem(String strPSSystemId, Vector<PSSysBIDimension> psSysBIDimensionList) {
        return this.selectMulti(this.getSQL_getPSSysBIDimensionsBySystem(strPSSystemId), psSysBIDimensionList, PSSysBIDimension.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIDimensionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIDIMENSION t1  inner join T_SRFPSSYSBISCHEME t2 on t1.PSSYSBISCHEMEID=t2.PSSYSBISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIDIMENSIONNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBIDimensions(String strPSSysBISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIDIMENSION t1 where  t1.PSSYSBISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIDIMENSIONNAME", (Object)strPSSysBISchemeId);
    }

    protected String getSQL_getPSSysBIHierarchies(String strPSSysBIDimensionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIHIERARCHY t1 where  t1.PSSYSBIDIMENSIONID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSBIHIERARCHYNAME ", (Object)strPSSysBIDimensionId);
    }

    public CallResult getPSSysBIHierarchiesBySystem(String strPSSystemId, Vector<PSSysBIHierarchy> psSysBIHierarchyList) {
        return this.selectMulti(this.getSQL_getPSSysBIHierarchiesBySystem(strPSSystemId), psSysBIHierarchyList, PSSysBIHierarchy.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIHierarchiesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIHIERARCHY t1 LEFT JOIN T_SRFPSSYSBIDIMENSION t2 on t1.PSSYSBIDIMENSIONID = t2.PSSYSBIDIMENSIONID  LEFT JOIN T_SRFPSSYSBISCHEME t3 on t2.PSSYSBISCHEMEID = t3.PSSYSBISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSBIHIERARCHYNAME ", (Object)strPSSystemId);
    }

    public CallResult getPSSysBICubesBySystem(String strPSSystemId, Vector<PSSysBICube> psSysBICubeList) {
        return this.selectMulti(this.getSQL_getPSSysBICubesBySystem(strPSSystemId), psSysBICubeList, PSSysBICube.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBICubesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBE t1  inner join T_SRFPSSYSBISCHEME t2 on t1.PSSYSBISCHEMEID=t2.PSSYSBISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBICUBENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBICubes(String strPSSysBISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBE t1 where  t1.PSSYSBISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBICUBENAME", (Object)strPSSysBISchemeId);
    }

    public CallResult getPSSysBIAggTablesBySystem(String strPSSystemId, Vector<PSSysBIAggTable> psSysBIAggTableList) {
        return this.selectMulti(this.getSQL_getPSSysBIAggTablesBySystem(strPSSystemId), psSysBIAggTableList, PSSysBIAggTable.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIAggTablesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIAGGTABLE t1  inner join T_SRFPSSYSBISCHEME t2 on t1.PSSYSBISCHEMEID=t2.PSSYSBISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIAGGTABLENAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBIAggTables(String strPSSysBISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIAGGTABLE t1 where  t1.PSSYSBISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIAGGTABLENAME", (Object)strPSSysBISchemeId);
    }

    protected String getSQL_getPSSysBICubeDimensions(String strPSSysBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBEDIMENSION t1 where  t1.PSSYSBICUBEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSBICUBEDIMENSIONNAME ", (Object)strPSSysBICubeId);
    }

    public CallResult getPSSysBICubeDimensionsBySystem(String strPSSystemId, Vector<PSSysBICubeDimension> psSysBICubeDimensionList) {
        return this.selectMulti(this.getSQL_getPSSysBICubeDimensionsBySystem(strPSSystemId), psSysBICubeDimensionList, PSSysBICubeDimension.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBICubeDimensionsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBEDIMENSION t1 LEFT JOIN T_SRFPSSYSBICUBE t2 on t1.PSSYSBICUBEID = t2.PSSYSBICUBEID  LEFT JOIN T_SRFPSSYSBISCHEME t3 on t2.PSSYSBISCHEMEID = t3.PSSYSBISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSBICUBEDIMENSIONNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBICubeMeasures(String strPSSysBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBEMEASURE t1 where  t1.PSSYSBICUBEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSBICUBEMEASURENAME ", (Object)strPSSysBICubeId);
    }

    public CallResult getPSSysBICubeMeasuresBySystem(String strPSSystemId, Vector<PSSysBICubeMeasure> psSysBICubeMeasureList) {
        return this.selectMulti(this.getSQL_getPSSysBICubeMeasuresBySystem(strPSSystemId), psSysBICubeMeasureList, PSSysBICubeMeasure.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBICubeMeasuresBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBEMEASURE t1 LEFT JOIN T_SRFPSSYSBICUBE t2 on t1.PSSYSBICUBEID = t2.PSSYSBICUBEID  LEFT JOIN T_SRFPSSYSBISCHEME t3 on t2.PSSYSBISCHEMEID = t3.PSSYSBISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSBICUBEMEASURENAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBIAggColumns(String strPSSysBIAggTableId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIAGGCOLUMN t1 where  t1.PSSYSBIAGGTABLEID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSBIAGGCOLUMNNAME ", (Object)strPSSysBIAggTableId);
    }

    public CallResult getPSSysBIAggColumnsBySystem(String strPSSystemId, Vector<PSSysBIAggColumn> psSysBIAggColumnList) {
        return this.selectMulti(this.getSQL_getPSSysBIAggColumnsBySystem(strPSSystemId), psSysBIAggColumnList, PSSysBIAggColumn.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIAggColumnsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIAGGCOLUMN t1 LEFT JOIN T_SRFPSSYSBIAGGTABLE t2 on t1.PSSYSBIAGGTABLEID = t2.PSSYSBIAGGTABLEID  LEFT JOIN T_SRFPSSYSBISCHEME t3 on t2.PSSYSBISCHEMEID = t3.PSSYSBISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSBIAGGCOLUMNNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBILevels(String strPSSysBIHierarchyId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBILEVEL t1 where  t1.PSSYSBIHIERARCHYID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE, t1.PSSYSBILEVELNAME ", (Object)strPSSysBIHierarchyId);
    }

    public CallResult getPSSysBILevelsBySystem(String strPSSystemId, Vector<PSSysBILevel> psSysBILevelList) {
        return this.selectMulti(this.getSQL_getPSSysBILevelsBySystem(strPSSystemId), psSysBILevelList, PSSysBILevel.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBILevelsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBILEVEL t1  LEFT JOIN T_SRFPSSYSBIHIERARCHY t2 on t1.PSSYSBIHIERARCHYID = t2.PSSYSBIHIERARCHYID LEFT JOIN T_SRFPSSYSBIDIMENSION t3 ON T2.PSSYSBIDIMENSIONID = t3.PSSYSBIDIMENSIONID  LEFT JOIN T_SRFPSSYSBISCHEME t4 on t3.PSSYSBISCHEMEID = t4.PSSYSBISCHEMEID  where  t4.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE,t1.PSSYSBILEVELNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBICubeLevels(String strPSSysBIDimensionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBELEVEL t1 where  t1.PSSYSBICUBEDIMENSIONID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSBICUBELEVELNAME ", (Object)strPSSysBIDimensionId);
    }

    public CallResult getPSSysBICubeLevelsBySystem(String strPSSystemId, Vector<PSSysBICubeLevel> psSysBICubeLevelList) {
        return this.selectMulti(this.getSQL_getPSSysBICubeLevelsBySystem(strPSSystemId), psSysBICubeLevelList, PSSysBICubeLevel.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBICubeLevelsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBICUBELEVEL t1  LEFT JOIN T_SRFPSSYSBICUBEDIMENSION t2 on t1.PSSYSBICUBEDIMENSIONID = t2.PSSYSBICUBEDIMENSIONID LEFT JOIN T_SRFPSSYSBICUBE t3 ON T2.PSSYSBICUBEID = t3.PSSYSBICUBEID  LEFT JOIN T_SRFPSSYSBISCHEME t4 on t3.PSSYSBISCHEMEID = t4.PSSYSBISCHEMEID  where  t4.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSBICUBELEVELNAME ", (Object)strPSSystemId);
    }

    public CallResult getPSSysBIReportsBySystem(String strPSSystemId, Vector<PSSysBIReport> psSysBIReportList) {
        return this.selectMulti(this.getSQL_getPSSysBIReportsBySystem(strPSSystemId), psSysBIReportList, PSSysBIReport.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIReportsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIREPORT t1  inner join T_SRFPSSYSBISCHEME t2 on t1.PSSYSBISCHEMEID=t2.PSSYSBISCHEMEID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIREPORTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysBIReports(String strPSSysBISchemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIREPORT t1 where  t1.PSSYSBISCHEMEID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSBIREPORTNAME", (Object)strPSSysBISchemeId);
    }

    protected String getSQL_getPSSysBIReportItems(String strPSSysBIAggTableId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIREPORTITEM t1 where  t1.PSSYSBIREPORTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSBIREPORTITEMNAME ", (Object)strPSSysBIAggTableId);
    }

    public CallResult getPSSysBIReportItemsBySystem(String strPSSystemId, Vector<PSSysBIReportItem> psSysBIReportItemList) {
        return this.selectMulti(this.getSQL_getPSSysBIReportItemsBySystem(strPSSystemId), psSysBIReportItemList, PSSysBIReportItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysBIReportItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSBIREPORTITEM t1 LEFT JOIN T_SRFPSSYSBIREPORT t2 on t1.PSSYSBIREPORTID = t2.PSSYSBIREPORTID  LEFT JOIN T_SRFPSSYSBISCHEME t3 on t2.PSSYSBISCHEMEID = t3.PSSYSBISCHEMEID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getAllPSThresholdGroups2(String strPSSystemId, Vector<PSThresholdGroup> psThresholdGroupList) {
        return this.selectMulti(this.getSQL_getAllPSThresholdGroups(strPSSystemId), psThresholdGroupList, PSThresholdGroup.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSThresholdGroups(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSTHRESHOLDGROUP t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    protected String getSQL_getPSThresholds(String strPSThresholdGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSTHRESHOLD t1 where  t1.PSTHRESHOLDGROUPID='%1$s' AND t1.VALIDFLAG = 1 order by t1.BEGINVALUE, t1.PSTHRESHOLDNAME", (Object)strPSThresholdGroupId);
    }

    public CallResult getPSThresholdsBySystem(String strPSSystemId, Vector<PSThreshold> psThresholdList) {
        return this.selectMulti(this.getSQL_getPSThresholdsBySystem(strPSSystemId), psThresholdList, PSThreshold.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSThresholdsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSTHRESHOLD t1  inner join T_SRFPSTHRESHOLDGROUP t2 on t1.PSTHRESHOLDGROUPID=t2.PSTHRESHOLDGROUPID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1  order by t1.BEGINVALUE, t1.PSTHRESHOLDNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSThresholdGroup(String strPSThresholdGroupId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSTHRESHOLDGROUP t1 where t1.PSTHRESHOLDGROUPID='%1$s' AND ( t1.VALIDFLAG =1 )", (Object)strPSThresholdGroupId);
    }

    public CallResult getAllPSSysChartThemes2(String strPSSystemId, Vector<PSSysChartTheme> psSysChartThemeList) {
        return this.selectMulti(this.getSQL_getAllPSSysChartThemes(strPSSystemId), psSysChartThemeList, PSSysChartTheme.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysChartThemes(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCHARTTHEME t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysChartTheme(String strPSSysChartThemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSCHARTTHEME t1 where  t1.PSSYSCHARTTHEMEID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSysChartThemeId);
    }

    public CallResult getAllPSSysDBValueFuncs2(String strPSSystemId, Vector<PSSysDBValueFunc> psSysDBValueFuncList) {
        return this.selectMulti(this.getSQL_getAllPSSysDBValueFuncs(strPSSystemId), psSysDBValueFuncList, PSSysDBValueFunc.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysDBValueFuncs(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSDBVF t1 where t1.PSSYSTEMID='%1$s' ORDER BY t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDCCluster(String strPSDCClusterId, PSDCCluster psDCCluster) {
        return this.selectSingle(this.getSQL_getPSDCCluster(strPSDCClusterId), psDCCluster, "SYSTEM");
    }

    protected String getSQL_getPSDCCluster(String strPSDCClusterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDCCLUSTER t1 where t1.PSDCCLUSTERID='%1$s' ", (Object)strPSDCClusterId);
    }

    protected String getSQL_getPSDEDSParams(String strPSDataSetId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSPARAM t1 where  t1.PSDEDSID='%1$s' order by ORDERVALUE ", (Object)strPSDataSetId);
    }

    protected String getSQL_getPSDEDSParamsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDSPARAM t1  inner join t_srfpsdedataset t2 on t1.PSDEDSID=t2.PSDEDATASETID inner join t_srfpsdataentity  t3 on t2.psdeid = t3.psdataentityid  where  t3.PSSYSTEMID='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by t1.ORDERVALUE ", (Object)strPSSystemId);
    }

    public CallResult getPSDEGridLogicsBySystem(String strPSSystemId, Vector<PSDEGridLogic> psDEGridLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGridLogicsBySystem(strPSSystemId), psDEGridLogicList, PSDEGridLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGridLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGRIDLOGIC t1 inner join T_SRFPSDEGRID t2 on t2.PSDEGRIDID =   t1.PSDEGRIDID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEGridLogics(String strPSDEGridId) {
        if (strPSDEGridId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEGRIDLOGIC_TMP t1 where  t1.PSDEGRIDID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEGridId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGRIDLOGIC t1 where  t1.PSDEGRIDID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEGridId);
    }

    public CallResult getPSDEToolbarLogicsBySystem(String strPSSystemId, Vector<PSDEToolbarLogic> psDEToolbarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEToolbarLogicsBySystem(strPSSystemId), psDEToolbarLogicList, PSDEToolbarLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEToolbarLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETOOLBARLOGIC t1 inner join T_SRFPSDETOOLBAR t2 on t2.PSDETOOLBARID =   t1.PSDETOOLBARID  where  t2.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEToolbarLogics(String strPSDEToolbarId) {
        if (strPSDEToolbarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETOOLBARLOGIC_TMP t1 where  t1.PSDETOOLBARID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEToolbarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETOOLBARLOGIC t1 where  t1.PSDETOOLBARID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEToolbarId);
    }

    public CallResult getPSDETreeLogicsBySystem(String strPSSystemId, Vector<PSDETreeLogic> psDETreeLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeLogicsBySystem(strPSSystemId), psDETreeLogicList, PSDETreeLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDETreeLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREELOGIC t1 inner join T_SRFPSDETREEVIEW t2 on t2.PSDETREEVIEWID =   t1.PSDETREEVIEWID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDETreeLogics(String strPSDETreeId) {
        if (strPSDETreeId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDETREELOGIC_TMP t1 where  t1.PSDETREEVIEWID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDETreeId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDETREELOGIC t1 where  t1.PSDETREEVIEWID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDETreeId);
    }

    public CallResult getPSDEListLogicsBySystem(String strPSSystemId, Vector<PSDEListLogic> psDEListLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEListLogicsBySystem(strPSSystemId), psDEListLogicList, PSDEListLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEListLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTLOGIC t1 inner join T_SRFPSDELIST t2 on t2.PSDELISTID =   t1.PSDELISTID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEListLogics(String strPSDEListId) {
        if (strPSDEListId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDELISTLOGIC_TMP t1 where  t1.PSDELISTID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEListId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELISTLOGIC t1 where  t1.PSDELISTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEListId);
    }

    public CallResult getAllPSAppLogics2(String strPSApplicationId, Vector<PSAppLogic> psAppLogics) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMultiValid(this.getSQL_getAllPSAppLogics(strPSApplicationId), psAppLogics, PSAppLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppLogics(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLOGIC t1 where  t1.PSSYSAPPID='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE ", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSAppLogic(String strPSAppLogicId, PSAppLogic psAppLogic) {
        if (this.getModelInstVer() < 747) {
            return CallResult.create((int)3);
        }
        return this.selectSingle(this.getSQL_getPSAppLogic(strPSAppLogicId), psAppLogic, "SYSTEM");
    }

    protected String getSQL_getPSAppLogic(String strPSAppLogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPLOGIC t1 where  t1.PSAPPLOGICID='%1$s' and t1.VALIDFLAG = 1 ", (Object)strPSAppLogicId);
    }

    public CallResult getPSDEFormLogicsBySystem(String strPSSystemId, Vector<PSDEFormLogic> psDEFormLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFormLogicsBySystem(strPSSystemId), psDEFormLogicList, PSDEFormLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFormLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORMLOGIC t1 inner join T_SRFPSDEFORM t2 on t2.PSDEFORMID =   t1.PSDEFORMID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEFormLogics(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFORMLOGIC_TMP t1 where  t1.PSDEFORMID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFORMLOGIC t1 where  t1.PSDEFORMID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    public CallResult getPSDEDataViewLogicsBySystem(String strPSSystemId, Vector<PSDEDataViewLogic> psDEDataViewLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataViewLogicsBySystem(strPSSystemId), psDEDataViewLogicList, PSDEDataViewLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataViewLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAVIEWLOGIC t1 inner join T_SRFPSDEDATAVIEW t2 on t2.PSDEDATAVIEWID =   t1.PSDEDATAVIEWID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEDataViewLogics(String strPSDEDataViewId) {
        if (strPSDEDataViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDATAVIEWLOGIC_TMP t1 where  t1.PSDEDATAVIEWID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEDataViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAVIEWLOGIC t1 where  t1.PSDEDATAVIEWID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEDataViewId);
    }

    public CallResult getPSDEWizardLogicsBySystem(String strPSSystemId, Vector<PSDEWizardLogic> psDEWizardLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEWizardLogicsBySystem(strPSSystemId), psDEWizardLogicList, PSDEWizardLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEWizardLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARDLOGIC t1 inner join T_SRFPSDEWIZARD t2 on t2.PSDEWIZARDID =   t1.PSDEWIZARDID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEWizardLogics(String strPSDEWizardId) {
        if (strPSDEWizardId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEWIZARDLOGIC_TMP t1 where  t1.PSDEWIZARDID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEWizardId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEWIZARDLOGIC t1 where  t1.PSDEWIZARDID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEWizardId);
    }

    public CallResult getPSDEChartLogicsBySystem(String strPSSystemId, Vector<PSDEChartLogic> psDEChartLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEChartLogicsBySystem(strPSSystemId), psDEChartLogicList, PSDEChartLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEChartLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTLOGIC t1 inner join T_SRFPSDECHART t2 on t2.PSDECHARTID =   t1.PSDECHARTID  inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSDEChartLogics(String strPSDEChartId) {
        if (strPSDEChartId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDECHARTLOGIC_TMP t1 where  t1.PSDECHARTID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSDEChartId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTLOGIC t1 where  t1.PSDECHARTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSDEChartId);
    }

    public CallResult getPSSysCalendarLogicsBySystem(String strPSSystemId, Vector<PSSysCalendarLogic> psSysCalendarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysCalendarLogicsBySystem(strPSSystemId), psSysCalendarLogicList, PSSysCalendarLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysCalendarLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARLOGIC t1 inner join T_SRFPSSYSCALENDAR t2 on t2.PSSYSCALENDARID =   t1.PSSYSCALENDARID  where  t2.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysCalendarLogics(String strPSSysCalendarId) {
        if (strPSSysCalendarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSCALENDARLOGIC_TMP t1 where  t1.PSSYSCALENDARID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSSysCalendarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSCALENDARLOGIC t1 where  t1.PSSYSCALENDARID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysCalendarId);
    }

    public CallResult getPSSysDashboardLogicsBySystem(String strPSSystemId, Vector<PSSysDashboardLogic> psSysDashboardLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDashboardLogicsBySystem(strPSSystemId), psSysDashboardLogicList, PSSysDashboardLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysDashboardLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDASHBOARDLOGIC t1 inner join T_SRFPSSYSDASHBOARD t2 on t2.PSSYSDASHBOARDID =   t1.PSSYSDASHBOARDID  where  t2.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysDashboardLogics(String strPSSysDashboardId) {
        if (strPSSysDashboardId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSDASHBOARDLOGIC_TMP t1 where  t1.PSSYSDASHBOARDID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSSysDashboardId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDASHBOARDLOGIC t1 where  t1.PSSYSDASHBOARDID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysDashboardId);
    }

    public CallResult getPSSysMapLogicsBySystem(String strPSSystemId, Vector<PSSysMapLogic> psSysMapLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysMapLogicsBySystem(strPSSystemId), psSysMapLogicList, PSSysMapLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysMapLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSMAPLOGIC t1 inner join T_SRFPSSYSMAPVIEW t2 on t2.PSSYSMAPVIEWID =   t1.PSSYSMAPVIEWID  where  t2.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysMapLogics(String strPSSysMapId) {
        if (strPSSysMapId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSMAPLOGIC_TMP t1 where  t1.PSSYSMAPVIEWID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSSysMapId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSMAPLOGIC t1 where  t1.PSSYSMAPVIEWID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysMapId);
    }

    public CallResult getPSSysSearchBarLogicsBySystem(String strPSSystemId, Vector<PSSysSearchBarLogic> psSysSearchBarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchBarLogicsBySystem(strPSSystemId), psSysSearchBarLogicList, PSSysSearchBarLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysSearchBarLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSEARCHBARLOGIC t1 inner join T_SRFPSSYSSEARCHBAR t2 on t2.PSSYSSEARCHBARID =   t1.PSSYSSEARCHBARID  where  t2.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysSearchBarLogics(String strPSSysSearchBarId) {
        if (strPSSysSearchBarId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSSYSSEARCHBARLOGIC_TMP t1 where  t1.PSSYSSEARCHBARID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSSysSearchBarId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSSEARCHBARLOGIC t1 where  t1.PSSYSSEARCHBARID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSysSearchBarId);
    }

    public CallResult getPSAppMenuLogicsBySystem(String strPSSystemId, Vector<PSAppMenuLogic> psAppMenuLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSAppMenuLogicsBySystem(strPSSystemId), psAppMenuLogicList, PSAppMenuLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSAppMenuLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENULOGIC t1 inner join T_SRFPSAPPMENU t2 on t2.PSAPPMENUID =   t1.PSAPPMENUID  inner join  t_srfpssysapp t3 on t2.pssysappid = t3.pssysappid where  t3.PSSYSTEMID ='%1$s' and t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSSystemId);
    }

    protected String getSQL_getPSAppMenuLogics(String strPSAppMenuId) {
        if (strPSAppMenuId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSAPPMENULOGIC_TMP t1 where  t1.PSAPPMENUID='%1$s' AND t1.VALIDFLAG = 1 AND  t1.srfdraftflag = 0 ORDER BY t1.ORDERVALUE", (Object)strPSAppMenuId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPMENULOGIC t1 where  t1.PSAPPMENUID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.ORDERVALUE", (Object)strPSAppMenuId);
    }

    protected String getSQL_getPSCtrlMsgItems(String strPSCtrlMsgId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSCTRLMSGITEM t1 where  t1.PSCTRLMSGID='%1$s' ORDER BY t1.PSCTRLMSGITEMNAME ASC ", (Object)strPSCtrlMsgId);
    }

    public CallResult getPSCtrlMsgItemsBySystem(String strPSSystemId, Vector<PSCtrlMsgItem> psCtrlMsgItemList) {
        return this.selectMulti(this.getSQL_getPSCtrlMsgItemsBySystem(strPSSystemId), psCtrlMsgItemList, PSCtrlMsgItem.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSCtrlMsgItemsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSCTRLMSGITEM t1 inner join T_SRFPSCTRLMSG t2 on t1.PSCTRLMSGID= t2.PSCTRLMSGID where t2.PSSYSTEMID= '%1$s' ORDER BY t1.PSCTRLMSGITEMNAME ASC ", (Object)strPSSystemId);
    }

    public CallResult getAllPSSysAIFactories2(String strPSSystemId, Vector<PSSysAIFactory> psSysAIFactoryList) {
        return this.selectMulti(this.getSQL_getAllPSSysAIFactories(strPSSystemId), psSysAIFactoryList, PSSysAIFactory.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysAIFactories(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIFACTORY t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAIFactory(String strPSSysAIFactoryId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIFACTORY t1 where  t1.PSSYSAIFACTORYID='%1$s'", (Object)strPSSysAIFactoryId);
    }

    public CallResult getPSSysAIChatAgentsBySystem(String strPSSystemId, Vector<PSSysAIChatAgent> psSysAIChatAgentList) {
        return this.selectMulti(this.getSQL_getPSSysAIChatAgentsBySystem(strPSSystemId), psSysAIChatAgentList, PSSysAIChatAgent.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysAIChatAgentsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAICHATAGENT t1  inner join T_SRFPSSYSAIFACTORY t2 on t1.PSSYSAIFACTORYID=t2.PSSYSAIFACTORYID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAICHATAGENTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAIChatAgents(String strPSSysAIFactoryId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAICHATAGENT t1 where  t1.PSSYSAIFACTORYID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAICHATAGENTNAME", (Object)strPSSysAIFactoryId);
    }

    public CallResult getPSSysAIWorkerAgentsBySystem(String strPSSystemId, Vector<PSSysAIWorkerAgent> psSysAIWorkerAgentList) {
        return this.selectMulti(this.getSQL_getPSSysAIWorkerAgentsBySystem(strPSSystemId), psSysAIWorkerAgentList, PSSysAIWorkerAgent.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysAIWorkerAgentsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIWORKERAGENT t1  inner join T_SRFPSSYSAIFACTORY t2 on t1.PSSYSAIFACTORYID=t2.PSSYSAIFACTORYID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAIWORKERAGENTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAIWorkerAgents(String strPSSysAIFactoryId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIWORKERAGENT t1 where  t1.PSSYSAIFACTORYID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAIWORKERAGENTNAME", (Object)strPSSysAIFactoryId);
    }

    public CallResult getPSSysAIPipelineAgentsBySystem(String strPSSystemId, Vector<PSSysAIPipelineAgent> psSysAIPipelineAgentList) {
        return this.selectMulti(this.getSQL_getPSSysAIPipelineAgentsBySystem(strPSSystemId), psSysAIPipelineAgentList, PSSysAIPipelineAgent.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysAIPipelineAgentsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEAGENT t1  inner join T_SRFPSSYSAIFACTORY t2 on t1.PSSYSAIFACTORYID=t2.PSSYSAIFACTORYID where  t2.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAIPIPELINEAGENTNAME", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAIPipelineAgents(String strPSSysAIFactoryId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEAGENT t1 where  t1.PSSYSAIFACTORYID='%1$s' AND t1.VALIDFLAG = 1 order by PSSYSAIPIPELINEAGENTNAME", (Object)strPSSysAIFactoryId);
    }

    protected String getSQL_getPSSysAIPipelineJobs(String strPSSysBICubeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEJOB t1 where  t1.PSSYSAIPIPELINEAGENTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSAIPIPELINEJOBNAME ", (Object)strPSSysBICubeId);
    }

    public CallResult getPSSysAIPipelineJobsBySystem(String strPSSystemId, Vector<PSSysAIPipelineJob> psSysAIPipelineJobList) {
        return this.selectMulti(this.getSQL_getPSSysAIPipelineJobsBySystem(strPSSystemId), psSysAIPipelineJobList, PSSysAIPipelineJob.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysAIPipelineJobsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEJOB t1 LEFT JOIN T_SRFPSSYSAIPIPELINEAGENT t2 on t1.PSSYSAIPIPELINEAGENTID = t2.PSSYSAIPIPELINEAGENTID  LEFT JOIN T_SRFPSSYSAIFACTORY t3 on t2.PSSYSAIFACTORYID = t3.PSSYSAIFACTORYID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSAIPIPELINEJOBNAME ", (Object)strPSSystemId);
    }

    protected String getSQL_getPSSysAIPipelineWorkers(String strPSSysAIPipelineId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEWORKER t1 where  t1.PSSYSAIPIPELINEAGENTID='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSAIPIPELINEWORKERNAME ", (Object)strPSSysAIPipelineId);
    }

    public CallResult getPSSysAIPipelineWorkersBySystem(String strPSSystemId, Vector<PSSysAIPipelineWorker> psSysAIPipelineWorkerList) {
        return this.selectMulti(this.getSQL_getPSSysAIPipelineWorkersBySystem(strPSSystemId), psSysAIPipelineWorkerList, PSSysAIPipelineWorker.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSSysAIPipelineWorkersBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSAIPIPELINEWORKER t1 LEFT JOIN T_SRFPSSYSAIPIPELINEAGENT t2 on t1.PSSYSAIPIPELINEAGENTID = t2.PSSYSAIPIPELINEAGENTID  LEFT JOIN T_SRFPSSYSAIFACTORY t3 on t2.PSSYSAIFACTORYID = t3.PSSYSAIFACTORYID   where  t3.PSSYSTEMID ='%1$s' AND t1.VALIDFLAG = 1 ORDER BY t1.PSSYSAIPIPELINEWORKERNAME ", (Object)strPSSystemId);
    }
}

