/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSASGroup;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.PS.Data.PSAppDEView;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSAppIndexView;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSAppLogic;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.PS.Data.PSAppMenuItemType;
import SA.SRFDA.PS.Data.PSAppMenuLogic;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFDA.PS.Data.PSAppPFPlugin;
import SA.SRFDA.PS.Data.PSAppPanelView;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.PS.Data.PSAppPortalView;
import SA.SRFDA.PS.Data.PSAppPortalViewPart;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSAppServerType;
import SA.SRFDA.PS.Data.PSAppSubApp;
import SA.SRFDA.PS.Data.PSAppTitleBar;
import SA.SRFDA.PS.Data.PSAppType;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.PS.Data.PSAppUtilType;
import SA.SRFDA.PS.Data.PSAppUtilView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSAppViewStyle;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSBDType;
import SA.SRFDA.PS.Data.PSBackService;
import SA.SRFDA.PS.Data.PSBookingResType;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSCodeSnippetType;
import SA.SRFDA.PS.Data.PSControlType;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.PS.Data.PSCounterType;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSCtrlLogicGroupDetail;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.PS.Data.PSDBSPPartTempl;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.PS.Data.PSDBSysProcType;
import SA.SRFDA.PS.Data.PSDBType;
import SA.SRFDA.PS.Data.PSDBValueFunc;
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
import SA.SRFDA.PS.Data.PSDEActionTempl;
import SA.SRFDA.PS.Data.PSDEActionType;
import SA.SRFDA.PS.Data.PSDEActionVR;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartAxes;
import SA.SRFDA.PS.Data.PSDEChartLogic;
import SA.SRFDA.PS.Data.PSDEChartSeries;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.PS.Data.PSDEDBTable;
import SA.SRFDA.PS.Data.PSDEDQPDCond;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.PS.Data.PSDEDRGroup;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.PS.Data.PSDEDSDQ;
import SA.SRFDA.PS.Data.PSDEDSGroupParam;
import SA.SRFDA.PS.Data.PSDEDSParam;
import SA.SRFDA.PS.Data.PSDEDTSQueue;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.PS.Data.PSDEDataImportItem;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Data.PSDEDataQueryCode;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeCond;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeExp;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFDA.PS.Data.PSDEDataView;
import SA.SRFDA.PS.Data.PSDEDataViewItem;
import SA.SRFDA.PS.Data.PSDEDataViewLogic;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.PS.Data.PSDEFGridColumn;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFDA.PS.Data.PSDEFGroupDetail;
import SA.SRFDA.PS.Data.PSDEFIUDetail;
import SA.SRFDA.PS.Data.PSDEFIUpdate;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.PS.Data.PSDEFValueRuleType;
import SA.SRFDA.PS.Data.PSDEFValueRuleTypeDetail;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEFieldType;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormItemVR;
import SA.SRFDA.PS.Data.PSDEFormLogic;
import SA.SRFDA.PS.Data.PSDEFormRF;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.PS.Data.PSDEGEIUpdate;
import SA.SRFDA.PS.Data.PSDEGrid;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEGridColumnType;
import SA.SRFDA.PS.Data.PSDEGridEditItemVR;
import SA.SRFDA.PS.Data.PSDEGridLogic;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFDA.PS.Data.PSDEGroupDetail;
import SA.SRFDA.PS.Data.PSDEJoinType;
import SA.SRFDA.PS.Data.PSDEList;
import SA.SRFDA.PS.Data.PSDEListItem;
import SA.SRFDA.PS.Data.PSDEListLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicLinkCondType;
import SA.SRFDA.PS.Data.PSDELogicLinkType;
import SA.SRFDA.PS.Data.PSDELogicNode;
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
import SA.SRFDA.PS.Data.PSDERType;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.PS.Data.PSDEReportItem;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.PS.Data.PSDESARS;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.PS.Data.PSDESampleData;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
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
import SA.SRFDA.PS.Data.PSDEUIActionType;
import SA.SRFDA.PS.Data.PSDEUserRole;
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
import SA.SRFDA.PS.Data.PSDataEntity;
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
import SA.SRFDA.PS.Data.PSDevSlnSysWSGit;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSDevUser;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.PS.Data.PSEditorType;
import SA.SRFDA.PS.Data.PSFDLogicType;
import SA.SRFDA.PS.Data.PSFormDetailType;
import SA.SRFDA.PS.Data.PSFormType;
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
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFDA.PS.Data.PSPFPluginTempl;
import SA.SRFDA.PS.Data.PSPFPluginType;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.PS.Data.PSPFPubObj;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSPFViewTempl;
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
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSFPkg;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFDA.PS.Data.PSSFPubObj;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.PS.Data.PSSVNServer;
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
import SA.SRFDA.PS.Data.PSSysDMVer;
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
import SA.SRFDA.PS.Data.PSSysTitleBar;
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
import SA.SRFDA.PS.Data.PSSystemApplication;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.PS.Data.PSSystemDeploy;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.PS.Data.PSToolbarItemType;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSViewEngine;
import SA.SRFDA.PS.Data.PSViewLogicType;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewType;
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
import SA.SRFDA.PS.Data.PSWFUtilUIAction;
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
import java.util.Vector;

@PSModelIgnoreMeta
public interface IPSModelHelper {
    public void active();

    public boolean isAlwaysActive();

    public void activeAlways();

    public long getLastActiveTime();

    public void resetCache();

    public boolean isDynaInstMode();

    public String getPSDynaInstId();

    public CallResult getPSSystem(String var1, PSSystem var2);

    public CallResult getPSDevSln(String var1, PSDevSln var2);

    public CallResult getPSDevCenter(String var1, PSDevCenter var2);

    public CallResult getPSDevSlnSys(String var1, PSDevSlnSys var2);

    public CallResult getPSDevSlnSysByMajorInst(String var1, PSDevSlnSys var2);

    public CallResult getPSModelInit(String var1, PSModelInit var2);

    public CallResult getPSModelInitSteps(String var1, Vector<PSModelInitStep> var2);

    public CallResult getPSDEFieldType(String var1, PSDEFieldType var2);

    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> var1);

    public CallResult getPSCodeList(String var1, PSCodeList var2);

    public CallResult getPSCodeListByTempl(String var1, PSCodeList var2);

    public CallResult getPSSystemDeployDBs(String var1, Vector<PSSystemDeployDB> var2);

    public CallResult getPSDBType(String var1, PSDBType var2);

    public CallResult getPSDEFieldsNoSort(String var1, Vector<PSDEField> var2);

    public CallResult getPSDataEntity(String var1, String var2, PSDataEntity var3);

    public CallResult getPSDataEntity(String var1, PSDataEntity var2);

    public CallResult getPSDEField(String var1, PSDEField var2);

    public CallResult getPSDEDBConfigs(String var1, Vector<PSDEDBConfig> var2);

    public CallResult getPSDEDBConfig(String var1, String var2, PSDEDBConfig var3);

    public CallResult getPSDEFDTColumns(String var1, String var2, Vector<PSDEFDTColumn> var3);

    public CallResult getPSSystemDBConfigs(String var1, Vector<PSSystemDBConfig> var2);

    public CallResult getPSSystemDBConfig(String var1, String var2, PSSystemDBConfig var3);

    public CallResult getPSSystemDeploy(String var1, PSSystemDeploy var2);

    public CallResult getPSSystemApplication(String var1, PSSystemApplication var2);

    public CallResult getAllPSSystemApplications(String var1, Vector<PSSystemApplication> var2);

    public CallResult getAllPSSystemModules(String var1, Vector<PSSystemModule> var2);

    public CallResult getAllPSSystemDBConfigs(String var1, Vector<PSSystemDBConfig> var2);

    public CallResult getPSViewType(String var1, PSViewType var2);

    public CallResult getPSApplicationView(String var1, PSAppView var2);

    public CallResult getPSAppIndexView(String var1, PSAppIndexView var2);

    public CallResult getPSAppPortalView(String var1, PSAppPortalView var2);

    public CallResult getAllPSApplicationViews(String var1, Vector<PSAppView> var2);

    public CallResult getAllPSAppViewCodes(String var1, Vector<PSAppViewCode> var2);

    public CallResult getPSControlType(String var1, PSControlType var2);

    public CallResult getPSEditorType(String var1, PSEditorType var2);

    public CallResult getPSAppModule(String var1, PSAppModule var2);

    public CallResult getAllPSAppModules(String var1, Vector<PSAppModule> var2);

    public CallResult getPSPF(String var1, PSPF var2);

    public CallResult getPSPFStyle(String var1, PSPFStyle var2);

    public CallResult getPSPFStyleRefreshVersion(String var1, PSPFStyle var2);

    public CallResult getPSPFCodeFolder(String var1, PSPFCodeFolder var2);

    public CallResult getPSPFPubCodes(String var1, Vector<PSPFPubCode> var2);

    public CallResult getPSPFPubCodesByPPSPFPubCode(String var1, Vector<PSPFPubCode> var2);

    public CallResult getPSPFViewTempl(String var1, PSPFViewTempl var2);

    public CallResult getPSPFViewTemplsByPF(String var1, Vector<PSPFViewTempl> var2);

    public CallResult getPSPFPubCode(String var1, PSPFPubCode var2);

    public CallResult getPSDEUIActionType(String var1, PSDEUIActionType var2);

    public CallResult getPSPFCtrlTempl(String var1, PSPFCtrlTempl var2);

    public CallResult getPSDEGridColumnType(String var1, PSDEGridColumnType var2);

    public CallResult getPSDEFGridColumns(String var1, Vector<PSDEFGridColumn> var2);

    public CallResult getPSDEGridColumns(String var1, Vector<PSDEGridColumn> var2);

    public CallResult getPSPFCtrlTemplDetails(String var1, Vector<PSPFCtrlTemplDetail> var2);

    public CallResult getPSDERType(String var1, PSDERType var2);

    public CallResult getPSToolbarItemType(String var1, PSToolbarItemType var2);

    public CallResult getPSDEToolbarItems(String var1, Vector<PSDEToolbarItem> var2);

    public CallResult getPSDEUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSSysDEUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSDEUIAction(String var1, PSDEUIAction var2);

    public CallResult getPSDEUIActionGroup(String var1, PSDEUIActionGroup var2);

    public CallResult getPSAppViewStyle(String var1, PSAppViewStyle var2);

    public CallResult getPSFormType(String var1, PSFormType var2);

    public CallResult getPSDEFormDetails(String var1, Vector<PSDEFormDetail> var2);

    public CallResult getPSFormDetailType(String var1, PSFormDetailType var2);

    public CallResult getPSDEFGridColumnsByDataEntity(String var1, Vector<PSDEFGridColumn> var2);

    public CallResult getPSDEFUIModesByDataEntity(String var1, Vector<PSDEFUIMode> var2);

    public CallResult getPSDEFSearchModesByDataEntity(String var1, Vector<PSDEFSearchMode> var2);

    public CallResult getPSDEFDTColumnsByDataEntity(String var1, Vector<PSDEFDTColumn> var2);

    public CallResult getPSPFEditorTempl(String var1, PSPFEditorTempl var2);

    public CallResult getAllPSAppEditorTempls(String var1, Vector<PSAppEditorTempl> var2);

    public CallResult getPSAppEditorTempl(String var1, PSAppEditorTempl var2);

    public CallResult getPSDERs(String var1, Vector<PSDER> var2);

    public CallResult getPSDERsByMinorDEId(String var1, Vector<PSDER> var2);

    public CallResult getPSV3Migrate(String var1, PSV3Migrate var2);

    public CallResult getPSAppFunc(String var1, PSAppFunc var2);

    public CallResult getPSAppMenuItems(String var1, Vector<PSAppMenuItem> var2);

    public CallResult getPSAppMenuItemType(String var1, PSAppMenuItemType var2);

    public CallResult getPSDER(String var1, PSDER var2);

    public CallResult getPSDBValueFunc(String var1, PSDBValueFunc var2);

    public CallResult getPSSysDBValueFunc(String var1, String var2, PSSysDBValueFunc var3);

    public CallResult getPSDEJoinType(String var1, PSDEJoinType var2);

    public CallResult getPSDEDataQueries(String var1, Vector<PSDEDataQuery> var2);

    public CallResult getPSDEDataQuery(String var1, PSDEDataQuery var2);

    public CallResult getPSDEDataQueryJoins(String var1, Vector<PSDEDataQueryJoin> var2);

    public CallResult getPSDEDataQueryConds(String var1, Vector<PSDEDataQueryCond> var2);

    public CallResult getPSDEDataSets(String var1, Vector<PSDEDataSet> var2);

    public CallResult getPSDEDataSet(String var1, PSDEDataSet var2);

    public CallResult getPSDEDSDQs(String var1, Vector<PSDEDSDQ> var2);

    public CallResult getPSDEDSGroupParams(String var1, Vector<PSDEDSGroupParam> var2);

    public CallResult getPSSF(String var1, PSSF var2);

    public CallResult getPSSFStyle(String var1, PSSFStyle var2);

    public CallResult getPSSFStyleVer(String var1, PSSFStyleVer var2);

    public CallResult getPSSFACHandler(String var1, PSSFACHandler var2);

    public CallResult getPSSFCodeFolders(String var1, Vector<PSSFCodeFolder> var2);

    public CallResult getPSSFCodeTempl(String var1, PSSFCodeTempl var2);

    public CallResult getPSSFCodeTempls(String var1, Vector<PSSFCodeTempl> var2);

    public CallResult getPSSFCodeTypes(String var1, Vector<PSSFCodeType> var2);

    public CallResult getAllPSDataEntities(String var1, Vector<PSDataEntity> var2);

    public CallResult getPSSysAjaxControlHandlers(String var1, Vector<PSACHandler> var2);

    public CallResult getPSAjaxControlHandlers(String var1, Vector<PSACHandler> var2);

    public CallResult getPSAjaxControlHandler(String var1, String var2, PSACHandler var3);

    public CallResult getPSDEDataSetCodes(String var1, Vector<PSDEDataSetCode> var2);

    public CallResult getPSDEDataSetCode(String var1, String var2, PSDEDataSetCode var3);

    public CallResult getPSDBDevInst(String var1, PSDBDevInst var2);

    public CallResult getPSViewTypeViews(String var1, Vector<PSViewTypeView> var2);

    public CallResult getPSViewTypeCtrls(String var1, Vector<PSViewTypeCtrl> var2);

    public CallResult getPSDEViewViews(String var1, Vector<PSDEViewView> var2);

    public CallResult getPSDEViewCtrls(String var1, Vector<PSDEViewCtrl> var2);

    public CallResult getPSAppViewRefs(String var1, Vector<PSAppViewRef> var2);

    public CallResult getPSDEViewLogics(String var1, Vector<PSDEViewLogic> var2);

    public CallResult getPSDEViewEngines(String var1, Vector<PSDEViewEngine> var2);

    public CallResult getPSDEActionType(String var1, PSDEActionType var2);

    public CallResult getPSDEAction(String var1, PSDEAction var2);

    public CallResult getPSDEActions(String var1, Vector<PSDEAction> var2);

    public CallResult getPSDBSPPartTempl(String var1, PSDBSPPartTempl var2);

    public CallResult getPSDBSysProcTempl(String var1, PSDBSysProcTempl var2);

    public CallResult getPSDEDBSysProcCode(String var1, PSDEDBSysProcCode var2);

    public CallResult getPSDEDBSysProcs(String var1, Vector<PSDEDBSysProc> var2);

    public CallResult getPSDEDBSysProc(String var1, String var2, PSDEDBSysProc var3);

    public CallResult getPSDBSysProcParams(String var1, Vector<PSDBProcParam> var2);

    public CallResult getPSPFUIActionTempl(String var1, PSPFUIActionTempl var2);

    public CallResult getAllPSCodeLists(String var1, Vector<PSCodeList> var2);

    public CallResult getPSCodeItems(String var1, Vector<PSCodeItem> var2);

    public CallResult getPSPFViewLogicTempl(String var1, PSPFViewLogicTempl var2);

    public CallResult getPSAppViewLogics(String var1, Vector<PSAppViewLogic> var2);

    public CallResult getPSViewLogicType(String var1, PSViewLogicType var2);

    public CallResult getPSDEFValueRulesByDataEntity(String var1, Vector<PSDEFValueRule> var2);

    public CallResult getPSDEFValueRuleType(String var1, PSDEFValueRuleType var2);

    public CallResult getPSDEFValueRuleTypeDetail(String var1, PSDEFValueRuleTypeDetail var2);

    public CallResult getPSDEACMode(String var1, PSDEACMode var2);

    public CallResult getPSDEACModes(String var1, Vector<PSDEACMode> var2);

    public CallResult getPSDEACModeItems(String var1, Vector<PSDEACModeItem> var2);

    public CallResult getPSDBValueOP(String var1, PSDBValueOP var2);

    public CallResult getPSDEDRGroups(String var1, Vector<PSDEDRGroup> var2);

    public CallResult getPSDRItemType(String var1, PSDRItemType var2);

    public CallResult getPSDEDRItems(String var1, Vector<PSDEDRItem> var2);

    public CallResult getPSDEDRDetails(String var1, Vector<PSDEDRDetail> var2);

    public CallResult getPSAppMenu(String var1, PSAppMenu var2);

    public CallResult getPSDEGrid(String var1, PSDEGrid var2);

    public CallResult getPSDEToolbar(String var1, PSDEToolbar var2);

    public CallResult getPSDEForm(String var1, PSDEForm var2);

    public CallResult getPSDEDataRelations(String var1, Vector<PSDEDataRelation> var2);

    public CallResult getAllPSDERs(String var1, Vector<PSDER> var2);

    public CallResult getPSDEDataQueryCodes(String var1, Vector<PSDEDataQueryCode> var2);

    public CallResult getPSDEDataQueryCode(String var1, String var2, PSDEDataQueryCode var3);

    public CallResult getPSDEDataQueryCodeExps(String var1, Vector<PSDEDataQueryCodeExp> var2);

    public CallResult getPSSystemModule(String var1, PSSystemModule var2);

    public CallResult getPSDBSysProcType(String var1, PSDBSysProcType var2);

    public CallResult getAllPSAppDEViews(String var1, String var2, Vector<PSAppDEView> var3);

    public CallResult getPSFDLogicType(String var1, PSFDLogicType var2);

    public CallResult getPSDEFDLogics(String var1, Vector<PSDEFDLogic> var2);

    public CallResult getPSDEDataQueryCodeConds(String var1, Vector<PSDEDataQueryCodeCond> var2);

    public CallResult getPSPFAppTempl(String var1, PSPFAppTempl var2);

    public CallResult getPSDEDataView(String var1, PSDEDataView var2);

    public CallResult getPSDEDataViewItems(String var1, Vector<PSDEDataViewItem> var2);

    public CallResult getPSDEUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSDEUIActionGroupDetails(String var1, Vector<PSDEUIActionGroupDetail> var2);

    public CallResult getPSDELogicNodeType(String var1, PSDELogicNodeType var2);

    public CallResult getPSDELogicLinkType(String var1, PSDELogicLinkType var2);

    public CallResult getPSDELogicLinkCondType(String var1, PSDELogicLinkCondType var2);

    public CallResult getPSDELogicNodes(String var1, Vector<PSDELogicNode> var2);

    public CallResult getPSDELogicLinks(String var1, Vector<PSDELogicLink> var2);

    public CallResult getPSDELogicLinkConds(String var1, Vector<PSDELogicLinkCond> var2);

    public CallResult getPSDELogics(String var1, Vector<PSDELogic> var2);

    public CallResult getPSDELogicNodeParams(String var1, Vector<PSDELogicNodeParam> var2);

    public CallResult getPSDELogicParams(String var1, Vector<PSDELogicParam> var2);

    public CallResult getPSDEViews(String var1, Vector<PSDEViewBase> var2);

    public CallResult getPSDEEditForms(String var1, Vector<PSDEForm> var2);

    public CallResult getPSDEPredefinedViews(String var1, Vector<PSDEViewBase> var2);

    public CallResult getPSDEFIUpdates(String var1, Vector<PSDEFIUpdate> var2);

    public CallResult getPSDEFIUDetails(String var1, Vector<PSDEFIUDetail> var2);

    public CallResult getPSDEFormRFs(String var1, Vector<PSDEFormRF> var2);

    public CallResult getPSDEMap(String var1, PSDEMap var2);

    public CallResult getPSDEMaps(String var1, Vector<PSDEMap> var2);

    public CallResult getPSDEMapDetails(String var1, Vector<PSDEMapDetail> var2);

    public CallResult getPSDEMapActions(String var1, Vector<PSDEMapAction> var2);

    public CallResult getPSDEMapDataQueries(String var1, Vector<PSDEMapDataQuery> var2);

    public CallResult getPSDEMapDataSets(String var1, Vector<PSDEMapDataSet> var2);

    public CallResult getPSSysRef(String var1, PSSysRef var2);

    public CallResult getAllPSSysRefs(String var1, Vector<PSSysRef> var2);

    public CallResult getPSSysRefDEs(String var1, Vector<PSSysRefDE> var2);

    public CallResult getAllPSWorkflows(String var1, Vector<PSWorkflow> var2);

    public CallResult getPSWFVersions(String var1, Vector<PSWFVersion> var2);

    public CallResult getPSWFProcesses(String var1, Vector<PSWFProcess> var2);

    public CallResult getPSWFLinks(String var1, Vector<PSWFLink> var2);

    public CallResult getPSWFProcParams(String var1, Vector<PSWFProcParam> var2);

    public CallResult getPSWFProcSubWFs(String var1, Vector<PSWFProcSubWF> var2);

    public CallResult getPSWFProcRoles(String var1, Vector<PSWFProcRole> var2);

    public CallResult getPSWFLinkRoles(String var1, Vector<PSWFLinkRole> var2);

    public CallResult getPSWFLinkConds(String var1, Vector<PSWFLinkCond> var2);

    public CallResult getPSWFProcessType(String var1, PSWFProcessType var2);

    public CallResult getPSWFLinkType(String var1, PSWFLinkType var2);

    public CallResult getPSWFLinkCondType(String var1, PSWFLinkCondType var2);

    public CallResult getPSWFDEs(String var1, Vector<PSWFDE> var2);

    public CallResult getPSWFDEsByWF(String var1, Vector<PSWFDE> var2);

    public CallResult getPSWFUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSWFUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSWFUIActions2(String var1, Vector<PSDEUIAction> var2);

    public CallResult getPSWFUIActionGroups2(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getAllPSWFRoles(String var1, Vector<PSWFRole> var2);

    public CallResult getAllPSWFWorkTimes(String var1, Vector<PSWFWorkTime> var2);

    public CallResult getPSDEViewBase(String var1, PSDEViewBase var2);

    public void startLoadPSSysApp(String var1, int var2) throws Exception;

    public void stopLoadPSSysApp() throws Exception;

    public void startLoadPSSystem(String var1, int var2) throws Exception;

    public void stopLoadPSSystem() throws Exception;

    public CallResult getAllPSSysImages(String var1, Vector<PSSysImage> var2);

    public CallResult getPSSysImage(String var1, PSSysImage var2);

    public CallResult getAllPSSysCsses(String var1, Vector<PSSysCss> var2);

    public CallResult getPSSysCss(String var1, PSSysCss var2);

    public CallResult getPSPortletType(String var1, PSPortletType var2);

    public CallResult getPSAppPortalViewParts(String var1, Vector<PSAppPortalViewPart> var2);

    public CallResult getAllPSSysPortlets(String var1, Vector<PSSysPortlet> var2);

    public CallResult getPSSysPortlet(String var1, PSSysPortlet var2);

    public CallResult getPSDEChart(String var1, PSDEChart var2);

    public CallResult getPSDEReport(String var1, PSDEReport var2);

    public CallResult getPSDEChartAxeses(String var1, Vector<PSDEChartAxes> var2);

    public CallResult getPSDEChartSerieses(String var1, Vector<PSDEChartSeries> var2);

    public CallResult getPSDEList(String var1, PSDEList var2);

    public CallResult getPSDEListItems(String var1, Vector<PSDEListItem> var2);

    public CallResult getAllPSSysValueRules(String var1, Vector<PSSysValueRule> var2);

    public CallResult getPSSysValueRule(String var1, PSSysValueRule var2);

    public CallResult getPSDEActionLogics(String var1, Vector<PSDEActionLogic> var2);

    public CallResult getPSSysDevBTType(String var1, PSSysDevBTType var2);

    public CallResult getPSSysDevBKTasks(String var1, Vector<PSSysDevBKTask> var2);

    public CallResult getPSSysRunSession(String var1, PSSysRunSession var2);

    public CallResult getPSAppServerType(String var1, PSAppServerType var2);

    public CallResult getPSAppServer(String var1, PSAppServer var2);

    public CallResult getPSSystemASes(String var1, Vector<PSSystemAS> var2);

    public CallResult getPSSystemAS(String var1, PSSystemAS var2);

    public CallResult getPSSVNInstRepo(String var1, PSSVNInstRepo var2);

    public CallResult getPSSVNInstRepoByDevCenterSVNId(String var1, PSSVNInstRepo var2);

    public CallResult getPSDEFValueRuleConds(String var1, Vector<PSDEFValueRuleCond> var2);

    public CallResult getPSDEOPPriv(String var1, PSDEOPPriv var2);

    public CallResult getPSDEOPPrivs(String var1, Vector<PSDEOPPriv> var2);

    public CallResult getPSDEOPPrivsBySystem(String var1, Vector<PSDEOPPriv> var2);

    public CallResult getPSDEMainStates(String var1, Vector<PSDEMainState> var2);

    public CallResult getPSDEMainStateRSs(String var1, Vector<PSDEMainStateRS> var2);

    public CallResult getPSDEMainStateActions(String var1, Vector<PSDEMainStateAction> var2);

    public CallResult getPSDEMainStateOPPrivs(String var1, Vector<PSDEMainStateOPPriv> var2);

    public CallResult getAllPSSubDEs(String var1, Vector<PSSubDE> var2);

    public CallResult getPSSubDE(String var1, PSSubDE var2);

    public CallResult getAllPSSubDEViews(String var1, Vector<PSSubDEView> var2);

    public CallResult getPSSubDEView(String var1, PSSubDEView var2);

    public CallResult getAllPSSubApps(String var1, Vector<PSSubApp> var2);

    public CallResult getPSSubApp(String var1, PSSubApp var2);

    public CallResult getPSSubSys(String var1, PSSubSys var2);

    public CallResult getAllPSSubSysSFs(String var1, Vector<PSSubSysSF> var2);

    public CallResult getPSSubSysSF(String var1, PSSubSysSF var2);

    public CallResult getPSAppSubApp(String var1, PSAppSubApp var2);

    public CallResult getAllPSAppSubApps(String var1, Vector<PSAppSubApp> var2);

    public CallResult getAllPSSubAppViews(String var1, Vector<PSSubAppView> var2);

    public CallResult getPSSubAppView(String var1, PSSubAppView var2);

    public CallResult getAllPSSysPDTViews(String var1, Vector<PSSysPDTView> var2);

    public CallResult getPSSysPDTView(String var1, PSSysPDTView var2);

    public CallResult getPSDEDQPDCond(String var1, PSDEDQPDCond var2);

    public CallResult getPSPFPluginType(String var1, PSPFPluginType var2);

    public CallResult getAllPSSysPFPlugins(String var1, Vector<PSSysPFPlugin> var2);

    public CallResult getPSSysPFPlugin(String var1, PSSysPFPlugin var2);

    public CallResult getAllPSSysPFPluginTempls(String var1, Vector<PSSysPFPluginTempl> var2);

    public CallResult getPSSysPFPluginTempl(String var1, PSSysPFPluginTempl var2);

    public CallResult getPSDETreeNodeType(String var1, PSDETreeNodeType var2);

    public CallResult getPSDETreeNodes(String var1, Vector<PSDETreeNode> var2);

    public CallResult getPSDETreeNodeRSes(String var1, Vector<PSDETreeNodeRS> var2);

    public CallResult getPSDETreeNodeRVs(String var1, Vector<PSDETreeNodeRV> var2);

    public CallResult getPSDETreeView(String var1, PSDETreeView var2);

    public CallResult getPSDETreeColumns(String var1, Vector<PSDETreeColumn> var2);

    public CallResult getPSDETreeNodeColumns(String var1, Vector<PSDETreeNodeColumn> var2);

    public CallResult getPSCounterType(String var1, PSCounterType var2);

    public CallResult getAllPSSysCounters(String var1, Vector<PSSysCounter> var2);

    public CallResult getPSSysCounter(String var1, PSSysCounter var2);

    public CallResult getPSCounter(String var1, PSCounter var2);

    public CallResult getPSAppUtilPage(String var1, PSAppUtilPage var2);

    public CallResult getAllPSAppUtilPages(String var1, Vector<PSAppUtilPage> var2);

    public CallResult getPSDEFormItemVRs(String var1, Vector<PSDEFormItemVR> var2);

    public CallResult getPSPFStyleCodes(String var1, Vector<PSPFStyleCode> var2);

    public CallResult getAllPSSubViewTypes(String var1, Vector<PSSubViewType> var2);

    public CallResult getPSSubViewType(String var1, PSSubViewType var2);

    public CallResult getAllPSSysDictCats(String var1, Vector<PSSysDictCat> var2);

    public CallResult getPSSysDictCat(String var1, PSSysDictCat var2);

    public CallResult getAllPSSysUniReses(String var1, Vector<PSSysUniRes> var2);

    public CallResult getPSSysUniRes(String var1, PSSysUniRes var2);

    public CallResult getAllPSSysMsgTempls(String var1, Vector<PSSysMsgTempl> var2);

    public CallResult getPSSysMsgTempl(String var1, PSSysMsgTempl var2);

    public CallResult getAllPSSysBackServices(String var1, Vector<PSSysBackService> var2);

    public CallResult getPSSysBackService(String var1, PSSysBackService var2);

    public CallResult getPSBackService(String var1, PSBackService var2);

    public CallResult getAllPSSysEditorStyles(String var1, Vector<PSSysEditorStyle> var2);

    public CallResult getPSSysEditorStyle(String var1, PSSysEditorStyle var2);

    public CallResult getPSSysWFSetting(String var1, PSSysWFSetting var2);

    public CallResult getPSDEDBIndexs(String var1, Vector<PSDEDBIndex> var2);

    public CallResult getPSDEDBIndexFields(String var1, Vector<PSDEDBIndexField> var2);

    public CallResult getPSDEReports(String var1, Vector<PSDEReport> var2);

    public CallResult getPSDEReportItems(String var1, Vector<PSDEReportItem> var2);

    public CallResult getPSDepSlnPrd(String var1, PSDepSlnPrd var2);

    public CallResult getPSDEPrints(String var1, Vector<PSDEPrint> var2);

    public CallResult getAllPSSysIssueEngines(Vector<PSSysIssueEngine> var1);

    public CallResult getPSAppType(String var1, PSAppType var2);

    public CallResult getAllPSSysViewLogics(String var1, Vector<PSSysViewLogic> var2);

    public CallResult getPSSysViewLogic(String var1, PSSysViewLogic var2);

    public CallResult getAllPSAppFuncs(String var1, Vector<PSAppFunc> var2);

    public CallResult getPSSysDEUIActionGroups(String var1, Vector<PSDEUIActionGroup> var2);

    public CallResult getPSPFViewTemplsByPFStyle(String var1, Vector<PSPFViewTempl> var2);

    public CallResult getPSPFCtrlTemplsByPFStyle(String var1, Vector<PSPFCtrlTempl> var2);

    public CallResult getPSPFViewLogicTemplsByPFStyle(String var1, Vector<PSPFViewLogicTempl> var2);

    public CallResult getPSPFUIActionTemplsByPFStyle(String var1, Vector<PSPFUIActionTempl> var2);

    public CallResult getPSPFAppTemplsByPFStyle(String var1, Vector<PSPFAppTempl> var2);

    public CallResult getPSPFEditorTemplsByPFStyle(String var1, Vector<PSPFEditorTempl> var2);

    public CallResult getPSPFEditorTemplsByPF(String var1, Vector<PSPFEditorTempl> var2);

    public CallResult getAllPSSubSysVers(String var1, Vector<PSSubSysVer> var2);

    public CallResult getPSSubSysVer(String var1, PSSubSysVer var2);

    public CallResult getAllPSSysDMItems(String var1, Vector<PSSysDMItem> var2);

    public CallResult getAllPSSysActors(String var1, Vector<PSSysActor> var2);

    public CallResult getPSSysActor(String var1, PSSysActor var2);

    public CallResult getAllPSSysUserCases(String var1, Vector<PSSysUserCase> var2);

    public CallResult getPSSysUserCase(String var1, PSSysUserCase var2);

    public CallResult getAllPSSysUserCaseRSs(String var1, Vector<PSSysUserCaseRS> var2);

    public CallResult getPSSysUserCaseRS(String var1, PSSysUserCaseRS var2);

    public CallResult getAllPSSysTestCases(String var1, Vector<PSSysTestCase> var2);

    public CallResult getPSSysTestCase(String var1, PSSysTestCase var2);

    public CallResult getPSSysTestCaseInputs(String var1, Vector<PSSysTestCaseInput> var2);

    public CallResult getPSSysTestCaseAsserts(String var1, Vector<PSSysTestCaseAssert> var2);

    public CallResult getAllPSSysTestDatas(String var1, Vector<PSSysTestData> var2);

    public CallResult getPSSysTestData(String var1, PSSysTestData var2);

    public CallResult getPSSysTestDataItems(String var1, Vector<PSSysTestDataItem> var2);

    public CallResult getAllPSSysSampleValues(String var1, Vector<PSSysSampleValue> var2);

    public CallResult getPSSysSampleValue(String var1, PSSysSampleValue var2);

    public CallResult getAllPSAppMenus(String var1, Vector<PSAppMenu> var2);

    public CallResult getAllPSSysUserModes(String var1, Vector<PSSysUserMode> var2);

    public CallResult getPSSysUserMode(String var1, PSSysUserMode var2);

    public CallResult getPSAppUserMode(String var1, PSAppUserMode var2);

    public CallResult getAllPSAppUserModes(String var1, Vector<PSAppUserMode> var2);

    public CallResult getPSSFVerCodeItem(String var1, PSSFVerCodeItem var2);

    public CallResult getPSSFVerCodes(String var1, Vector<PSSFVerCode> var2);

    public CallResult getPSSFVerCodeItems(String var1, Vector<PSSFVerCodeItem> var2);

    public CallResult getPSDERDEFMaps(String var1, Vector<PSDERDEFMap> var2);

    public CallResult getAllPSSysERMaps(String var1, Vector<PSSysERMap> var2);

    public CallResult getPSSysERMap(String var1, PSSysERMap var2);

    public CallResult getPSSysERMapNodes(String var1, Vector<PSSysERMapNode> var2);

    public CallResult getPSSysSFPub(String var1, PSSysSFPub var2);

    public CallResult getAllPSSysSFPubs(String var1, Vector<PSSysSFPub> var2);

    public CallResult getPSPFStylePrjs(String var1, Vector<PSPFStylePrj> var2);

    public CallResult getPSSFStylePrjs(String var1, Vector<PSSFStylePrj> var2);

    public CallResult getPSSFPkgVer(String var1, PSSFPkgVer var2);

    public CallResult getPSSFPkg(String var1, PSSFPkg var2);

    public CallResult getPSSFStylePkgs(String var1, Vector<PSSFStylePkg> var2);

    public CallResult getPSDEGEIUpdates(String var1, Vector<PSDEGEIUpdate> var2);

    public CallResult getPSDEGEIUDetails(String var1, Vector<PSDEGEIUDetail> var2);

    public CallResult getPSDEWizard(String var1, PSDEWizard var2);

    public CallResult getPSDEWizards(String var1, Vector<PSDEWizard> var2);

    public CallResult getPSDEWizardSteps(String var1, Vector<PSDEWizardStep> var2);

    public CallResult getPSDEWizardStep(String var1, PSDEWizardStep var2);

    public CallResult getPSDEWizardForms(String var1, Vector<PSDEWizardForm> var2);

    public CallResult getAllPSSysDataSyncAgents(String var1, Vector<PSSysDataSyncAgent> var2);

    public CallResult getPSSysDataSyncAgent(String var1, PSSysDataSyncAgent var2);

    public CallResult getPSDEDataSync(String var1, PSDEDataSync var2);

    public CallResult getPSDEDataSyncs(String var1, Vector<PSDEDataSync> var2);

    public CallResult getPSDevUser(String var1, PSDevUser var2);

    public CallResult getPSSysSFCodes(String var1, Vector<PSSysSFCode> var2);

    public CallResult getAllPSSysUserDRs(String var1, Vector<PSSysUserDR> var2);

    public CallResult getPSSysUserDR(String var1, PSSysUserDR var2);

    public CallResult getPSBDType(String var1, PSBDType var2);

    public CallResult getAllPSSysBDSchemes(String var1, Vector<PSSysBDScheme> var2);

    public CallResult getPSSysBDScheme(String var1, PSSysBDScheme var2);

    public void setModelInstVer(int var1);

    public CallResult getPSAppLan(String var1, PSAppLan var2);

    public CallResult getAllPSAppLans(String var1, Vector<PSAppLan> var2);

    public CallResult getPSSysBDParts(String var1, Vector<PSSysBDPart> var2);

    public CallResult getPSSysBDModules(String var1, Vector<PSSysBDModule> var2);

    public CallResult getPSSysBDTableRSes(String var1, Vector<PSSysBDTableRS> var2);

    public CallResult getPSSysBDTables(String var1, Vector<PSSysBDTable> var2);

    public CallResult getPSSysBDColumns(String var1, Vector<PSSysBDColumn> var2);

    public CallResult getPSSysBDColSets(String var1, Vector<PSSysBDColSet> var2);

    public CallResult getPSSysBDTableDEs(String var1, Vector<PSSysBDTableDE> var2);

    public CallResult getPSSysBDTableDERs(String var1, Vector<PSSysBDTableDER> var2);

    public CallResult getPSDEBDTables(String var1, Vector<PSSysBDTableDE> var2);

    public CallResult getPSModelPlugin(String var1, PSModelPlugin var2);

    public CallResult getAllPSModelPlugins(Vector<PSModelPlugin> var1);

    public CallResult getPSDevCenterBTType(String var1, PSDCBKType var2);

    public CallResult getAllPSViewMsgs(String var1, Vector<PSViewMsg> var2);

    public CallResult getPSViewMsg(String var1, PSViewMsg var2);

    public CallResult getAllPSViewMsgGroups(String var1, Vector<PSViewMsgGroup> var2);

    public CallResult getPSViewMsgGroup(String var1, PSViewMsgGroup var2);

    public CallResult getPSViewMsgGroupDetails(String var1, Vector<PSViewMsgGroupDetail> var2);

    public CallResult getPSDEDataExport(String var1, PSDEDataExport var2);

    public CallResult getPSDEDataExports(String var1, Vector<PSDEDataExport> var2);

    public CallResult getPSDEDataImport(String var1, PSDEDataImport var2);

    public CallResult getPSDEDataImports(String var1, Vector<PSDEDataImport> var2);

    public CallResult getPSDEDataImportItems(String var1, Vector<PSDEDataImportItem> var2);

    public CallResult getPSDEDataExportItems(String var1, Vector<PSDEGridColumn> var2);

    public CallResult getPSDEFInputTipsByDataEntity(String var1, Vector<PSDEFInputTip> var2);

    public CallResult getPSDEFInputTipsBySystem(String var1, Vector<PSDEFInputTip> var2);

    public CallResult getPSModel(String var1, PSModel var2);

    public CallResult getPSModelPlugins(String var1, Vector<PSModelPlugin> var2);

    public CallResult getPSDEActionWizard(String var1, PSDEActionWizard var2);

    public CallResult getPSDEActionWizards(String var1, Vector<PSDEActionWizard> var2);

    public CallResult getPSDEActionWizardItems(String var1, Vector<PSDEAWItem> var2);

    public CallResult getPSDEActionWizardGroups(String var1, Vector<PSDEAWGroup> var2);

    public CallResult getPSDEActionWizardGroupDetails(String var1, Vector<PSDEAWGrpDetail> var2);

    public CallResult getAllPSWXAccounts(String var1, Vector<PSWXAccount> var2);

    public CallResult getPSWXAccount(String var1, PSWXAccount var2);

    public CallResult getPSWXEntApps(String var1, Vector<PSWXEntApp> var2);

    public CallResult getPSWXMenuFuncs(String var1, Vector<PSWXMenuFunc> var2);

    public CallResult getPSWXLogics(String var1, Vector<PSWXLogic> var2);

    public CallResult getPSWXMenus(String var1, Vector<PSWXMenu> var2);

    public CallResult getPSWXMenuFuncsByApp(String var1, Vector<PSWXMenuFunc> var2);

    public CallResult getPSWXLogicsByApp(String var1, Vector<PSWXLogic> var2);

    public CallResult getPSWXMenusByApp(String var1, Vector<PSWXMenu> var2);

    public CallResult getPSWXMenuItems(String var1, Vector<PSWXMenuItem> var2);

    public CallResult getPSWXMenu(String var1, PSWXMenu var2);

    public CallResult getPSDevCenterBKTasks(String var1, Vector<PSDCBKTask> var2);

    public CallResult getAllPSCtrlMsgs(String var1, Vector<PSCtrlMsg> var2);

    public CallResult getPSCtrlMsg(String var1, PSCtrlMsg var2);

    public CallResult getPSCtrlMsgItems(String var1, Vector<PSCtrlMsgItem> var2);

    public CallResult getAllPSSysUnits(String var1, Vector<PSSysUnit> var2);

    public CallResult getPSSysUnit(String var1, PSSysUnit var2);

    public CallResult getAllPSLanguageReses(String var1, Vector<PSLanguageRes> var2);

    public CallResult getPSLanguageRes(String var1, PSLanguageRes var2);

    public CallResult getAllPSLanguageItems(String var1, Vector<PSLanguageItem> var2);

    public CallResult getPSLanguageItem(String var1, PSLanguageItem var2);

    public CallResult getPSAppPkg(String var1, PSAppPkg var2);

    public CallResult getAllPSAppPkgs(String var1, Vector<PSAppPkg> var2);

    public CallResult getPSSysSFPubPkgs(String var1, Vector<PSSysSFPubPkg> var2);

    public CallResult getPSHelpArticleType(String var1, PSHelpArticleType var2);

    public CallResult getPSHelpSectionType(String var1, PSHelpSectionType var2);

    public CallResult getPSHelpPrjType(String var1, PSHelpPrjType var2);

    public CallResult getAllPSHelpArticles(String var1, Vector<PSHelpArticle> var2);

    public CallResult getAllPSHelpPrjs(String var1, Vector<PSHelpPrj> var2);

    public CallResult getAllPSHelpSections(String var1, Vector<PSHelpSection> var2);

    public CallResult getAllPSHelpModules(String var1, Vector<PSHelpModule> var2);

    public CallResult getPSHelpArticleTempls(Vector<PSHelpArticleTempl> var1);

    public CallResult getPSHelpPrjTempls(Vector<PSHelpPrjTempl> var1);

    public CallResult getPSHelpSectionTempls(Vector<PSHelpSectionTempl> var1);

    public CallResult getPSHelpArticleTempl(String var1, PSHelpArticleTempl var2);

    public CallResult getPSHelpSectionTempl(String var1, PSHelpSectionTempl var2);

    public CallResult getPSHelpPrjTempl(String var1, PSHelpPrjTempl var2);

    public CallResult getAllPSHelpResources(String var1, Vector<PSHelpResource> var2);

    public CallResult getPSPFPkgVer(String var1, PSPFPkgVer var2);

    public CallResult getPSPFPkg(String var1, PSPFPkg var2);

    public CallResult getPSPFStylePkgs(String var1, Vector<PSPFStylePkg> var2);

    public CallResult getPSPFCDN(String var1, PSPFCDN var2);

    public CallResult getAllPSSysLans(String var1, Vector<PSAppLan> var2);

    public CallResult getPSDepSlnType(String var1, PSDepSlnType var2);

    public CallResult getPSDepSysType(String var1, PSDepSysType var2);

    public CallResult getAllPSDepSlnHosts(String var1, Vector<PSDepSlnHost> var2);

    public CallResult getAllPSDepSlnDBInsts(String var1, Vector<PSDepSlnDBInst> var2);

    public CallResult getAllPSDepSlnMQInsts(String var1, Vector<PSDepSlnMQInst> var2);

    public CallResult getAllPSDepSlnASes(String var1, Vector<PSDepSlnAS> var2);

    public CallResult getAllPSDepSlnASGroups(String var1, Vector<PSDepSlnASGrp> var2);

    public CallResult getAllPSDepSlnASGroupItems(String var1, Vector<PSDepSlnASItem> var2);

    public CallResult getAllPSDepSlnSyses(String var1, Vector<PSDepSlnSys> var2);

    public CallResult getAllPSDepSlnSysDBs(String var1, Vector<PSDepSlnSysDB> var2);

    public CallResult getAllPSDepSlnSysMQs(String var1, Vector<PSDepSlnSysMQ> var2);

    public CallResult getAllPSDepSlnSysASes(String var1, Vector<PSDepSlnSysAS> var2);

    public CallResult getPSDCDBInst(String var1, PSDevCenterDBInst var2);

    public CallResult getPSDCDBInst(String var1, String var2, PSDevCenterDBInst var3);

    public CallResult getPSDCASGroup(String var1, PSDCASGroup var2);

    public CallResult getPSASGroup(String var1, PSASGroup var2);

    public CallResult getPSDevCenterAS(String var1, PSDevCenterAS var2);

    public CallResult getPSMQType(String var1, PSMQType var2);

    public CallResult getPSMQInst(String var1, PSMQInst var2);

    public CallResult getPSDCMQInst(String var1, PSDevCenterMQ var2);

    public CallResult getPSDepSys(String var1, PSDepSys var2);

    public CallResult getPSDepSysVer(String var1, PSDepSysVer var2);

    public CallResult getPSDepSaaSSysVer(String var1, PSDepSaaSSysVer var2);

    public CallResult getAllPSDepSysApps(String var1, Vector<PSDepSysApp> var2);

    public CallResult getPSPFPkgVerCDN(String var1, PSPFPkgVerCDN var2);

    public CallResult getPSDepToolType(String var1, PSDepToolType var2);

    public CallResult getPSSysEngineConfig(String var1, PSSysEngineCfg var2);

    public CallResult getPSDevCenterSVN(String var1, PSDevCenterSVN var2);

    public CallResult getPSRobotType(String var1, PSRobotType var2);

    public CallResult getPSRobotWorkType(String var1, PSRobotWorkType var2);

    public CallResult getPSDCRobots(String var1, Vector<PSDCRobot> var2);

    public CallResult getPSRobot(String var1, PSRobot var2);

    public CallResult getPSGitUser(String var1, PSGitUser var2);

    public CallResult getAllPSDEFInputTipSets(String var1, Vector<PSDEFInputTipSet> var2);

    public CallResult getPSDEFInputTipSet(String var1, PSDEFInputTipSet var2);

    public CallResult getAllPSSysUniStates(String var1, Vector<PSSysUniState> var2);

    public CallResult getPSSysUniState(String var1, PSSysUniState var2);

    public CallResult getPSBookingResType(String var1, PSBookingResType var2);

    public CallResult getPSDevServerType(String var1, PSDevServerType var2);

    public CallResult getPSDevServer(String var1, PSDevServer var2);

    public CallResult getAllPSSysDEFTypes(String var1, Vector<PSSysDEFType> var2);

    public CallResult getPSSysDEFType(String var1, PSSysDEFType var2);

    public CallResult getPSMobAppStartPage(String var1, PSMobAppStartPage var2);

    public CallResult getAllPSMobAppStartPages(String var1, Vector<PSMobAppStartPage> var2);

    public CallResult getPSDCMobAppPackCerts(String var1, Vector<PSDCMobAppPackCert> var2);

    public CallResult getPSDCMobAppTestDevices(String var1, Vector<PSDCMobAppTestDevice> var2);

    public CallResult getPSMobAppPack(String var1, PSMobAppPack var2);

    public CallResult getAllPSMobAppPacks(String var1, Vector<PSMobAppPack> var2);

    public CallResult getPSMobAppPackTDs(String var1, Vector<PSMobAppPackTD> var2);

    public CallResult getPSMobAppPackCert(String var1, PSDCMobAppPackCert var2);

    public CallResult getAllPSMobAppPackCerts(String var1, Vector<PSDCMobAppPackCert> var2);

    public CallResult getAllPSSysLogics(String var1, Vector<PSSysLogic> var2);

    public CallResult getPSSysLogic(String var1, PSSysLogic var2);

    public CallResult getPSMobAppPackServer(String var1, PSMobAppPackServer var2);

    public CallResult getPSDEUniStates(String var1, Vector<PSSysUniState> var2);

    public CallResult getAllPSSysSearchBars(String var1, Vector<PSSysSearchBar> var2);

    public CallResult getPSSysSearchBar(String var1, PSSysSearchBar var2);

    public CallResult getPSSysSearchBarItems(String var1, Vector<PSSysSearchBarItem> var2);

    public CallResult getPSViewEngine(String var1, PSViewEngine var2);

    public CallResult getPSDEServiceAPI(String var1, PSDEServiceAPI var2);

    public CallResult getPSDEServiceAPIs(String var1, Vector<PSDEServiceAPI> var2);

    public CallResult getPSDESADetail(String var1, PSDESADetail var2);

    public CallResult getPSDESADetails(String var1, Vector<PSDESADetail> var2);

    public CallResult getAllPSSysServiceAPIs(String var1, Vector<PSSysServiceAPI> var2);

    public CallResult getPSSysServiceAPI(String var1, PSSysServiceAPI var2);

    public CallResult getPSDEServiceAPIsBySSA(String var1, Vector<PSDEServiceAPI> var2);

    public CallResult getAllPSSysDTSQueues(String var1, Vector<PSSysDTSQueue> var2);

    public CallResult getPSSysDTSQueue(String var1, PSSysDTSQueue var2);

    public CallResult getPSDEDTSQueues(String var1, Vector<PSDEDTSQueue> var2);

    public CallResult getPSDeployServer(String var1, PSDeployServer var2);

    public CallResult getAllPSSubSysServiceAPIs(String var1, Vector<PSSubSysServiceAPI> var2);

    public CallResult getPSSubSysServiceAPI(String var1, PSSubSysServiceAPI var2);

    public CallResult getPSSubSysSADetails(String var1, Vector<PSSubSysSADetail> var2);

    public CallResult getPSDCDeployServer(String var1, PSDCDeployServer var2);

    public CallResult getDefaultPSDCDeployServer(String var1, PSDCDeployServer var2);

    public CallResult getPSDevSlnSysRes(String var1, PSDevSlnSysRes var2);

    public CallResult getPSDEUserRoles(String var1, Vector<PSDEUserRole> var2);

    public CallResult getPSDEOPPrivRoles(String var1, Vector<PSDEOPPrivRole> var2);

    public CallResult getAllPSSysUserRoles(String var1, Vector<PSSysUserRole> var2);

    public CallResult getPSSysUserRole(String var1, PSSysUserRole var2);

    public CallResult getPSSysDashboard(String var1, PSSysDashboard var2);

    public CallResult getPSSysDashboardParts(String var1, Vector<PSSysDashboardPart> var2);

    public CallResult getAllPSSysDashboards(String var1, Vector<PSSysDashboard> var2);

    public CallResult getPSSysUserRoleReses(String var1, Vector<PSSysUserRoleRes> var2);

    public CallResult getPSSysUserRoleDatas(String var1, Vector<PSSysUserRoleData> var2);

    public CallResult getPSAppLocalDE(String var1, PSAppLocalDE var2);

    public CallResult getAllPSAppLocalDEs(String var1, Vector<PSAppLocalDE> var2);

    public CallResult getPSSFPluginTempl(String var1, PSSFPluginTempl var2);

    public CallResult getAllPSSysSFPlugins(String var1, Vector<PSSysSFPlugin> var2);

    public CallResult getPSSysSFPlugin(String var1, PSSysSFPlugin var2);

    public CallResult getAllPSSysSFPluginTempls(String var1, Vector<PSSysSFPluginTempl> var2);

    public CallResult getPSSysSFPluginTempl(String var1, PSSysSFPluginTempl var2);

    public CallResult getPSPFPluginTempl(String var1, PSPFPluginTempl var2);

    public CallResult getPSDEUtils(String var1, Vector<PSDEUtil> var2);

    public CallResult getAllPSSysUtils(String var1, Vector<PSSysUtil> var2);

    public CallResult getPSSysUtil(String var1, PSSysUtil var2);

    public CallResult getPSDCCodeSnippet(String var1, PSDCCodeSnippet var2);

    public CallResult getPSDCCodeSnippetRefs(String var1, Vector<PSDCCodeSnippetRef> var2);

    public CallResult getPSCodeSnippetType(String var1, PSCodeSnippetType var2);

    public CallResult getPSWorkshopServer(String var1, PSWorkshopServer var2);

    public CallResult getPSDCWorkshopServer(String var1, PSDCWorkshopServer var2);

    public CallResult getDefaultPSDCWorkshopServer(String var1, PSDCWorkshopServer var2);

    public CallResult getPSDeployCenter(String var1, PSDeployCenter var2);

    public CallResult getPSDCDeployCenter(String var1, PSDCDeployCenter var2);

    public CallResult getDefaultPSDCDeployCenter(String var1, PSDCDeployCenter var2);

    public CallResult getDefaultPSDCRegistryRepo(String var1, PSDCRegistryRepo var2);

    public CallResult getPSMSPlatform(String var1, PSMSPlatform var2);

    public CallResult getPSDCMSPlatform(String var1, PSDCMSPlatform var2);

    public CallResult getPSMSPlatformFuncs(String var1, Vector<PSMSPlatformFunc> var2);

    public CallResult getPSMSPlatformNodes(String var1, Vector<PSMSPlatformNode> var2);

    public CallResult getPSDCMSPlatformFuncs(String var1, Vector<PSDCMSPlatformFunc> var2);

    public CallResult getPSDCMSPlatformNodes(String var1, Vector<PSDCMSPlatformNode> var2);

    public CallResult getPSDevSlnMSDepApp(String var1, PSDevSlnMSDepApp var2);

    public CallResult getPSDevSlnMSDepAPI(String var1, PSDevSlnMSDepAPI var2);

    public CallResult getPSDevSlnMSDepAPIs(String var1, Vector<PSDevSlnMSDepAPI> var2);

    public CallResult getPSDevSlnMSDepApps(String var1, Vector<PSDevSlnMSDepApp> var2);

    public CallResult getPSSVNServer(String var1, PSSVNServer var2);

    public CallResult getPSDevSlnSysWSGit(String var1, PSDevSlnSysWSGit var2);

    public CallResult getPSDELogic(String var1, PSDELogic var2);

    public CallResult getAllPSSysTitleBars(String var1, Vector<PSSysTitleBar> var2);

    public CallResult getPSSysTitleBar(String var1, PSSysTitleBar var2);

    public CallResult getPSAppTitleBar(String var1, PSAppTitleBar var2);

    public CallResult getAllPSAppTitleBars(String var1, Vector<PSAppTitleBar> var2);

    public CallResult getAllPSSysDynaModels(String var1, Vector<PSSysDynaModel> var2);

    public CallResult getPSSysDynaModel(String var1, PSSysDynaModel var2);

    public CallResult getPSSysDynaModelAttrs(String var1, Vector<PSSysDynaModelAttr> var2);

    public CallResult getPSDBServer(String var1, PSDBServer var2);

    public CallResult getAllPSSysDMVers(String var1, Vector<PSSysDMVer> var2);

    public CallResult getPSSFStyleParam(String var1, PSSFStyleParam var2);

    public CallResult getPSDEActionParams(String var1, Vector<PSDEActionParam> var2);

    public CallResult getAllPSDEActionTempls(String var1, Vector<PSDEActionTempl> var2);

    public CallResult getPSDEActionTempl(String var1, PSDEActionTempl var2);

    public CallResult getPSMavenServer(String var1, PSMavenServer var2);

    public CallResult getPSMavenServerType(String var1, PSMavenServerType var2);

    public CallResult getPSMavenRepo(String var1, PSMavenRepo var2);

    public CallResult getPSSysCalendar(String var1, PSSysCalendar var2);

    public CallResult getPSSysCalendarItems(String var1, Vector<PSSysCalendarItem> var2);

    public CallResult getAllPSSysCalendars(String var1, Vector<PSSysCalendar> var2);

    public CallResult getPSSysCalendarItemRVs(String var1, Vector<PSSysCalendarItemRV> var2);

    public CallResult getPSDESampleDatas(String var1, Vector<PSDESampleData> var2);

    public CallResult getPSPanelDetailType(String var1, PSPanelDetailType var2);

    public CallResult getPSSysPanel(String var1, PSSysPanel var2);

    public CallResult getPSSysPanelItems(String var1, Vector<PSSysPanelItem> var2);

    public CallResult getAllPSSysPanels(String var1, Vector<PSSysPanel> var2);

    public CallResult getPSSysPanelModels(String var1, Vector<PSSysPanelModel> var2);

    public CallResult getPSPanelItemLogics(String var1, Vector<PSPanelItemLogic> var2);

    public CallResult getPSPanelItemLogicType(String var1, PSPanelItemLogicType var2);

    public CallResult getPSPanelLogicLinkCondType(String var1, PSPanelLogicLinkCondType var2);

    public CallResult getPSSysPanelLogics(String var1, Vector<PSSysPanelLogic> var2);

    public CallResult getPSPanelLogicParams(String var1, Vector<PSPanelLogicParam> var2);

    public CallResult getPSPanelLogicNodes(String var1, Vector<PSPanelLogicNode> var2);

    public CallResult getPSPanelLogicLinks(String var1, Vector<PSPanelLogicLink> var2);

    public CallResult getPSPanelLogicNodeParams(String var1, Vector<PSPanelLogicNodeParam> var2);

    public CallResult getPSPanelLogicLinkConds(String var1, Vector<PSPanelLogicLinkCond> var2);

    public CallResult getPSPanelLogicNodeType(String var1, PSPanelLogicNodeType var2);

    public CallResult getPSPanelLogicLinkType(String var1, PSPanelLogicLinkType var2);

    public CallResult getPSPanelEngines(String var1, Vector<PSPanelEngine> var2);

    public CallResult getPSAppUIStyle(String var1, PSAppUIStyle var2);

    public CallResult getAllPSAppUIStyles(String var1, Vector<PSAppUIStyle> var2);

    public CallResult getPSAppUITheme(String var1, PSAppUITheme var2);

    public CallResult getAllPSAppUIThemes(String var1, Vector<PSAppUITheme> var2);

    public CallResult getAllPSDynaDETempls(String var1, Vector<PSDynaDETempl> var2);

    public CallResult getPSDynaDETempl(String var1, PSDynaDETempl var2);

    public CallResult getPSDynaDEViewTempl(String var1, PSDynaDEViewTempl var2);

    public CallResult getPSAppUtilView(String var1, PSAppUtilView var2);

    public CallResult getPSSysUtilType(String var1, PSSysUtilType var2);

    public CallResult getAllPSSysServiceAPIHandlers(String var1, Vector<PSSysServiceAPIHandler> var2);

    public CallResult getPSSysServiceAPIHandler(String var1, PSSysServiceAPIHandler var2);

    public CallResult getPSAppPDTView(String var1, PSAppPDTView var2);

    public CallResult getAllPSAppPDTViews(String var1, Vector<PSAppPDTView> var2);

    public CallResult getPSDynaDEViewTempls(String var1, Vector<PSDynaDEViewTempl> var2);

    public CallResult getPSDynaDEFormTempls(String var1, Vector<PSDynaDEFormTempl> var2);

    public CallResult getPSDevSlnMSDepFuncItems(String var1, Vector<PSDevSlnMSDepFuncItem> var2);

    public CallResult getPSDevSlnMSDepFunc(String var1, PSDevSlnMSDepFunc var2);

    public CallResult getPSDevSlnMSDepFuncs(String var1, Vector<PSDevSlnMSDepFunc> var2);

    public CallResult getPSAppPanelView(String var1, PSAppPanelView var2);

    public CallResult getPSSFPubObj(String var1, PSSFPubObj var2);

    public CallResult getPSPFPubObj(String var1, PSPFPubObj var2);

    public CallResult getPSUIEngineType(String var1, PSUIEngineType var2);

    public CallResult getPSSysDBValueOP(String var1, String var2, PSSysDBValueOP var3);

    public CallResult getPSSysViewLogicParams(String var1, Vector<PSSysViewLogicParam> var2);

    public CallResult getPSDCMavenRepo(String var1, PSDCMavenRepo var2);

    public CallResult getAllPSSysFiles(String var1, Vector<PSSysFile> var2);

    public CallResult getPSSysFile(String var1, PSSysFile var2);

    public CallResult getPSSFStyleRefreshVersion(String var1, PSSFStyle var2);

    public CallResult getPSDevSlnTempls(String var1, Vector<PSDevSlnTempl> var2);

    public CallResult getPSWorkspaceType(String var1, PSWorkspaceType var2);

    public CallResult getPSAppWF(String var1, PSAppWF var2);

    public CallResult getAllPSAppWFs(String var1, Vector<PSAppWF> var2);

    public CallResult getPSAppWFVer(String var1, PSAppWFVer var2);

    public CallResult getAllPSAppWFVers(String var1, Vector<PSAppWFVer> var2);

    public CallResult getPSDEFGroup(String var1, PSDEFGroup var2);

    public CallResult getPSDEFGroupDetails(String var1, Vector<PSDEFGroupDetail> var2);

    public CallResult getPSDEFGroupItems(String var1, Vector<PSDEFormDetail> var2);

    public CallResult getPSDEFGroupColumns(String var1, Vector<PSDEGridColumn> var2);

    public CallResult getPSDEFGroups(String var1, Vector<PSDEFGroup> var2);

    public CallResult getPSDEServiceAPIRSs(String var1, Vector<PSDESARS> var2);

    public CallResult getAllPSAppDERSs(String var1, Vector<PSAppDERS> var2);

    public CallResult getPSAppDERS(String var1, PSAppDERS var2);

    public CallResult getPSSubSysSADEs(String var1, Vector<PSSubSysSADE> var2);

    public CallResult getPSSubSysSADERSs(String var1, Vector<PSSubSysSADERS> var2);

    public CallResult getPSSubSysSADEFields(String var1, Vector<PSSubSysSADEField> var2);

    public CallResult getPSSysDBTables(String var1, Vector<PSSysDBTable> var2);

    public CallResult getPSSysDBColumns(String var1, Vector<PSSysDBColumn> var2);

    public CallResult getAllPSSysDBSchemes(String var1, Vector<PSSysDBScheme> var2);

    public CallResult getPSSysDBScheme(String var1, PSSysDBScheme var2);

    public CallResult getPSDESAVRs(String var1, Vector<PSDESAVR> var2);

    public CallResult getAllPSSysResources(String var1, Vector<PSSysResource> var2);

    public CallResult getPSSysResource(String var1, PSSysResource var2);

    public CallResult getAllPSSysContentCats(String var1, Vector<PSSysContentCat> var2);

    public CallResult getPSSysContentCats(String var1, Vector<PSSysContentCat> var2);

    public CallResult getPSSysContentCat(String var1, PSSysContentCat var2);

    public CallResult getPSSysContents(String var1, Vector<PSSysContent> var2);

    public CallResult getPSSysContent(String var1, PSSysContent var2);

    public CallResult getPSAppResource(String var1, PSAppResource var2);

    public CallResult getAllPSAppResources(String var1, Vector<PSAppResource> var2);

    public CallResult getPSDEGroups(String var1, Vector<PSDEGroup> var2);

    public CallResult getPSSysDEGroups(String var1, Vector<PSDEGroup> var2);

    public CallResult getPSDEGroup(String var1, PSDEGroup var2);

    public CallResult getPSDERGroups(String var1, Vector<PSDERGroup> var2);

    public CallResult getPSSysDERGroups(String var1, Vector<PSDERGroup> var2);

    public CallResult getPSDERGroup(String var1, PSDERGroup var2);

    public CallResult getPSDEGroupDetails(String var1, Vector<PSDEGroupDetail> var2);

    public CallResult getPSDERGroupDetails(String var1, Vector<PSDERGroupDetail> var2);

    public CallResult getPSDEActionGroup(String var1, PSDEActionGroup var2);

    public CallResult getPSDEActionGroupDetails(String var1, Vector<PSDEAGDetail> var2);

    public CallResult getPSDEActionGroups(String var1, Vector<PSDEActionGroup> var2);

    public CallResult getPSSysTestModules(String var1, Vector<PSSysTestModule> var2);

    public CallResult getAllPSSysTestPrjs(String var1, Vector<PSSysTestPrj> var2);

    public CallResult getPSSysTestPrj(String var1, PSSysTestPrj var2);

    public CallResult getPSSysTestCases(String var1, Vector<PSSysTestCase> var2);

    public CallResult getAllPSSysReqModules(String var1, Vector<PSSysReqModule> var2);

    public CallResult getPSSysReqModules(String var1, Vector<PSSysReqModule> var2);

    public CallResult getPSSysReqModule(String var1, PSSysReqModule var2);

    public CallResult getAllPSSysReqItems(String var1, Vector<PSSysReqItem> var2);

    public CallResult getPSSysReqItem(String var1, PSSysReqItem var2);

    public CallResult getPSDEDBTables(String var1, Vector<PSDEDBTable> var2);

    public CallResult getPSDEUserRole(String var1, PSDEUserRole var2);

    public CallResult getPSCtrlLogicGroups(String var1, Vector<PSCtrlLogicGroup> var2);

    public CallResult getPSSysCtrlLogicGroups(String var1, Vector<PSCtrlLogicGroup> var2);

    public CallResult getPSCtrlLogicGroup(String var1, PSCtrlLogicGroup var2);

    public CallResult getPSCtrlLogicGroupDetails(String var1, Vector<PSCtrlLogicGroupDetail> var2);

    public CallResult getPSSysModelGroup(String var1, PSSysModelGroup var2);

    public CallResult getAllPSSysModelGroups(String var1, Vector<PSSysModelGroup> var2);

    public CallResult getAllPSSysSearchSchemes(String var1, Vector<PSSysSearchScheme> var2);

    public CallResult getPSSysSearchScheme(String var1, PSSysSearchScheme var2);

    public CallResult getPSSysSearchDocs(String var1, Vector<PSSysSearchDoc> var2);

    public CallResult getPSSysSearchDEs(String var1, Vector<PSSysSearchDE> var2);

    public CallResult getPSSysSearchFields(String var1, Vector<PSSysSearchField> var2);

    public CallResult getPSSysSearchDEFields(String var1, Vector<PSSysSearchDEField> var2);

    public CallResult getPSDESearchs(String var1, Vector<PSSysSearchDE> var2);

    public CallResult getPSSysSearchDEFieldsByDataEntity(String var1, Vector<PSSysSearchDEField> var2);

    public CallResult getPSSysMapView(String var1, PSSysMapView var2);

    public CallResult getPSSysMapItems(String var1, Vector<PSSysMapItem> var2);

    public CallResult getAllPSSysMapViews(String var1, Vector<PSSysMapView> var2);

    public CallResult getPSDEUtilType(String var1, PSDEUtilType var2);

    public CallResult getPSAppUtilType(String var1, PSAppUtilType var2);

    public CallResult getPSAppUtil(String var1, PSAppUtil var2);

    public CallResult getAllPSAppUtils(String var1, Vector<PSAppUtil> var2);

    public CallResult getAllPSSysPortletCats(String var1, Vector<PSSysPortletCat> var2);

    public CallResult getPSSysPortletCat(String var1, PSSysPortletCat var2);

    public CallResult getPSAppPortlet(String var1, PSAppPortlet var2);

    public CallResult getAllPSAppPortlets(String var1, Vector<PSAppPortlet> var2);

    public CallResult getAllPSAppPFPlugins(String var1, Vector<PSAppPFPlugin> var2);

    public CallResult getPSDCRegistryRepo(String var1, PSDCRegistryRepo var2);

    public CallResult getPSRegistryRepo(String var1, PSRegistryRepo var2);

    public CallResult getPSDCWorkspace(String var1, PSDCWorkspace var2);

    public CallResult getPSDEGridEditItemVRs(String var1, Vector<PSDEGridEditItemVR> var2);

    public CallResult getPSDEActionVRs(String var1, Vector<PSDEActionVR> var2);

    public CallResult getPSDEMainStateFields(String var1, Vector<PSDEMainStateField> var2);

    public CallResult getPSDevSlnSysDepInst(String var1, PSDevSlnSysDepInst var2);

    public CallResult getPSDevSlnSysDynaInst(String var1, PSDevSlnSysDynaInst var2);

    public CallResult getPSDevSlnSysDynaInsts(String var1, Vector<PSDevSlnSysDynaInst> var2);

    public CallResult getAllPSSysSequences(String var1, Vector<PSSysSequence> var2);

    public CallResult getPSSysSequence(String var1, PSSysSequence var2);

    public CallResult getAllPSSysTranslators(String var1, Vector<PSSysTranslator> var2);

    public CallResult getPSSysTranslator(String var1, PSSysTranslator var2);

    public CallResult getPSWFUtilUIActions(String var1, Vector<PSWFUtilUIAction> var2);

    public CallResult getAllPSSysMsgTargets(String var1, Vector<PSSysMsgTarget> var2);

    public CallResult getAllPSSysMsgQueues(String var1, Vector<PSSysMsgQueue> var2);

    public CallResult getPSDENotifies(String var1, Vector<PSDENotify> var2);

    public CallResult getPSDENotifyTargets(String var1, Vector<PSDENotifyTarget> var2);

    public CallResult getAllPSSysEAISchemes(String var1, Vector<PSSysEAIScheme> var2);

    public CallResult getPSSysEAIScheme(String var1, PSSysEAIScheme var2);

    public CallResult getPSSysEAIDataTypes(String var1, Vector<PSSysEAIDataType> var2);

    public CallResult getPSSysEAIDataTypeItems(String var1, Vector<PSSysEAIDataTypeItem> var2);

    public CallResult getPSSysEAIElements(String var1, Vector<PSSysEAIElement> var2);

    public CallResult getPSSysEAIElementAttrs(String var1, Vector<PSSysEAIElementAttr> var2);

    public CallResult getPSSysEAIElementREs(String var1, Vector<PSSysEAIElementRE> var2);

    public CallResult getPSSysEAIDEs(String var1, Vector<PSSysEAIDE> var2);

    public CallResult getPSSysEAIDEFields(String var1, Vector<PSSysEAIDEField> var2);

    public CallResult getPSSysEAIDERs(String var1, Vector<PSSysEAIDER> var2);

    public CallResult getAllPSSysBISchemes(String var1, Vector<PSSysBIScheme> var2);

    public CallResult getPSSysBIScheme(String var1, PSSysBIScheme var2);

    public CallResult getPSSysBIDimensions(String var1, Vector<PSSysBIDimension> var2);

    public CallResult getPSSysBIHierarchies(String var1, Vector<PSSysBIHierarchy> var2);

    public CallResult getPSSysBILevels(String var1, Vector<PSSysBILevel> var2);

    public CallResult getPSSysBICubes(String var1, Vector<PSSysBICube> var2);

    public CallResult getPSSysBICubeDimensions(String var1, Vector<PSSysBICubeDimension> var2);

    public CallResult getPSSysBICubeLevels(String var1, Vector<PSSysBICubeLevel> var2);

    public CallResult getPSSysBICubeMeasures(String var1, Vector<PSSysBICubeMeasure> var2);

    public CallResult getPSSysBIAggTables(String var1, Vector<PSSysBIAggTable> var2);

    public CallResult getPSSysBIAggColumns(String var1, Vector<PSSysBIAggColumn> var2);

    public CallResult getPSSysBIReports(String var1, Vector<PSSysBIReport> var2);

    public CallResult getPSSysBIReportItems(String var1, Vector<PSSysBIReportItem> var2);

    public CallResult getPSThresholdGroup(String var1, PSThresholdGroup var2);

    public CallResult getAllPSThresholdGroups(String var1, Vector<PSThresholdGroup> var2);

    public CallResult getPSThresholds(String var1, Vector<PSThreshold> var2);

    public CallResult getAllPSSysChartThemes(String var1, Vector<PSSysChartTheme> var2);

    public CallResult getPSSysChartTheme(String var1, PSSysChartTheme var2);

    public CallResult getAllPSSysDBValueFuncs(String var1, Vector<PSSysDBValueFunc> var2);

    public CallResult getPSDevSlnSysDynaInstRefs(String var1, Vector<PSDevSlnSysDynaInstRef> var2);

    public CallResult getAllPSSysUCMaps(String var1, Vector<PSSysUCMap> var2);

    public CallResult getPSSysUCMap(String var1, PSSysUCMap var2);

    public CallResult getPSSysUCMapNodes(String var1, Vector<PSSysUCMapNode> var2);

    public CallResult getAllPSDELogics(String var1, Vector<PSDELogic> var2);

    public CallResult getAllPSDEUIActions(String var1, Vector<PSDEUIAction> var2);

    public CallResult getAllPSCtrlLogicGroups(String var1, Vector<PSCtrlLogicGroup> var2);

    public CallResult getPSDCCluster(String var1, PSDCCluster var2);

    public CallResult getPSDEDSParams(String var1, Vector<PSDEDSParam> var2);

    public CallResult getPSDEGridLogics(String var1, Vector<PSDEGridLogic> var2);

    public CallResult getPSDEChartLogics(String var1, Vector<PSDEChartLogic> var2);

    public CallResult getPSDETreeLogics(String var1, Vector<PSDETreeLogic> var2);

    public CallResult getPSAppLogic(String var1, PSAppLogic var2);

    public CallResult getAllPSAppLogics(String var1, Vector<PSAppLogic> var2);

    public CallResult getPSDEFormLogics(String var1, Vector<PSDEFormLogic> var2);

    public CallResult getPSDEDataViewLogics(String var1, Vector<PSDEDataViewLogic> var2);

    public CallResult getPSDEListLogics(String var1, Vector<PSDEListLogic> var2);

    public CallResult getPSDEWizardLogics(String var1, Vector<PSDEWizardLogic> var2);

    public CallResult getPSDEToolbarLogics(String var1, Vector<PSDEToolbarLogic> var2);

    public CallResult getPSSysCalendarLogics(String var1, Vector<PSSysCalendarLogic> var2);

    public CallResult getPSSysDashboardLogics(String var1, Vector<PSSysDashboardLogic> var2);

    public CallResult getPSSysSearchBarLogics(String var1, Vector<PSSysSearchBarLogic> var2);

    public CallResult getPSSysMapLogics(String var1, Vector<PSSysMapLogic> var2);

    public CallResult getPSAppMenuLogics(String var1, Vector<PSAppMenuLogic> var2);

    public CallResult getAllPSSysAIFactories(String var1, Vector<PSSysAIFactory> var2);

    public CallResult getPSSysAIFactory(String var1, PSSysAIFactory var2);

    public CallResult getPSSysAIWorkerAgents(String var1, Vector<PSSysAIWorkerAgent> var2);

    public CallResult getPSSysAIChatAgents(String var1, Vector<PSSysAIChatAgent> var2);

    public CallResult getPSSysAIPipelineAgents(String var1, Vector<PSSysAIPipelineAgent> var2);

    public CallResult getPSSysAIPipelineJobs(String var1, Vector<PSSysAIPipelineJob> var2);

    public CallResult getPSSysAIPipelineWorkers(String var1, Vector<PSSysAIPipelineWorker> var2);
}

