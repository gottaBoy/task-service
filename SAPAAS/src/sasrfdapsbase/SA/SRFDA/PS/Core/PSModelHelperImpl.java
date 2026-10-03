package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelHelperBase.PSCtrlLogicGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSCtrlMsgStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEACModeStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEActionGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEActionStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEActionWizardGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEActionWizardStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataExportStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataImportStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataQueryCodeStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataQueryStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataRelationStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataSetStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEDataSyncStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEFGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEFValueRuleStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDELogicStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEMainStateStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEMapStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDENotifyStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEOPPrivRoleStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEPrintStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDERGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDERStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEReportStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEServiceAPIStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEUIActionGroupStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEUserRoleStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEUtilStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSDEWizardStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSubSysSADEStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSubSysServiceAPIStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSysAppStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSysModelCache;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSysServiceAPIStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSSystemStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSWFVersionStorage;
import SA.SRFDA.PS.Core.PSModelHelperBase.PSWorkflowStorage;
import SA.SRFDA.PS.Data.PSACHandler;
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
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.PS.Data.PSAppPortalView;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.PS.Data.PSAppTitleBar;
import SA.SRFDA.PS.Data.PSAppType;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSAppViewStyle;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSControlType;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSCtrlLogicGroupDetail;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSDBValueFunc;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
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
import SA.SRFDA.PS.Data.PSDEActionVR;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartAxes;
import SA.SRFDA.PS.Data.PSDEChartLogic;
import SA.SRFDA.PS.Data.PSDEChartSeries;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.PS.Data.PSDEDBTable;
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
import SA.SRFDA.PS.Data.PSDEField;
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
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
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
import SA.SRFDA.PS.Data.PSDETreeView;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUIActionType;
import SA.SRFDA.PS.Data.PSDEUserRole;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.PS.Data.PSDEViewLogic;
import SA.SRFDA.PS.Data.PSDEViewView;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFDA.PS.Data.PSDEWizardForm;
import SA.SRFDA.PS.Data.PSDEWizardLogic;
import SA.SRFDA.PS.Data.PSDEWizardStep;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSDevSlnSysWSGit;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.PS.Data.PSEditorType;
import SA.SRFDA.PS.Data.PSFormDetailType;
import SA.SRFDA.PS.Data.PSFormType;
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFDA.PS.Data.PSLanguageRes;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFDA.PS.Data.PSMobAppPackTD;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFDA.PS.Data.PSPanelEngine;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFDA.PS.Data.PSSVNServer;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFDA.PS.Data.PSSubSysSADetail;
import SA.SRFDA.PS.Data.PSSubSysServiceAPI;
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
import SA.SRFDA.PS.Data.PSSysDEFType;
import SA.SRFDA.PS.Data.PSSysDMVer;
import SA.SRFDA.PS.Data.PSSysDTSQueue;
import SA.SRFDA.PS.Data.PSSysDashboard;
import SA.SRFDA.PS.Data.PSSysDashboardLogic;
import SA.SRFDA.PS.Data.PSSysDashboardPart;
import SA.SRFDA.PS.Data.PSSysDataSyncAgent;
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
import SA.SRFDA.PS.Data.PSSysFile;
import SA.SRFDA.PS.Data.PSSysImage;
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
import SA.SRFDA.PS.Data.PSSysReqItem;
import SA.SRFDA.PS.Data.PSSysReqModule;
import SA.SRFDA.PS.Data.PSSysResource;
import SA.SRFDA.PS.Data.PSSysSFPlugin;
import SA.SRFDA.PS.Data.PSSysSFPluginTempl;
import SA.SRFDA.PS.Data.PSSysSFPub;
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
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.PS.Data.PSSysViewLogicParam;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSSystemApplication;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.PS.Data.PSSystemDeploy;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.PS.Data.PSToolbarItemType;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewType;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFUtilUIAction;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelHelperImpl extends PSModelHelperImplBase {
   private static final Log log = LogFactory.getLog(PSModelHelperImpl.class);
   protected ThreadLocal<ArrayList<PSSystemStorage>> psSystemStorageStack = new ThreadLocal<>();
   protected ThreadLocal<ArrayList<PSSysAppStorage>> psSysAppStorageStack = new ThreadLocal<>();

   public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
      this.iDAGlobalHelper = iDAGlobalHelper;
      this.strDBType = this.iDAGlobalHelper.getDAModelDB();
      if (!StringHelper.IsNullOrEmpty(strPSSysModelInstId)) {
         this.strPSSysModelInstId = strPSSysModelInstId;
         this.bAlwaysActive = bAlwaysActive;
         this.nLastActiveTime = System.currentTimeMillis();
         this.nLastSessionActiveTime = System.currentTimeMillis();
         if (this.bAlwaysActive) {
            PSSysModelInstGlobal.activeAlways(this.strPSSysModelInstId);
         }
      } else {
         this.bAlwaysActive = true;
      }

      this.onInit();
   }

   protected void onInit() throws Exception {
   }

   @Override
   public boolean isDynaInstMode() {
      return false;
   }

   @Override
   public String getPSDynaInstId() {
      return null;
   }

   @Override
   public CallResult getPSCodeList(String strPSCodeListId, PSCodeList psCodeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psCodeListMap.get(strPSCodeListId) != null) {
         psSystemStorage.psCodeListMap.get(strPSCodeListId).CopyTo(psCodeList, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSCodeList(strPSCodeListId), psCodeList, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEFieldsNoSort(String strPSDataEntityId, Vector<PSDEField> psDEFieldList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEFieldList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFieldsNoSort(strPSDataEntityId), psDEFieldList, PSDEField.class.getName(), "SYSTEM", true);
   }

   public CallResult getPSDEFieldsNoSortBySystem(String strPSSystemId, Vector<PSDEField> psDEFieldList) {
      return this.selectMulti(this.getSQL_getPSDEFieldsNoSortBySystem(strPSSystemId), psDEFieldList, PSDEField.class.getName(), "SYSTEM", true);
   }

   @Override
   public CallResult getPSDEField(String strPSDEFieldId, PSDEField psDEField) {
      return this.selectSingle(this.getSQL_getPSDEField(strPSDEFieldId), psDEField, "SYSTEM");
   }

   @Override
   public CallResult getPSDataEntity(String strPSSystemId, String strPSDataEntityName, PSDataEntity psDataEntity) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null) {
         if (psSystemStorage.psDataEntityMap.get(strPSDataEntityName) == null) {
            return CallResult.create(3);
         }

         psSystemStorage.psDataEntityMap.get(strPSDataEntityName).CopyTo(psDataEntity, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDataEntity(strPSSystemId, strPSDataEntityName), psDataEntity, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDataEntity(String strPSDataEntityId, PSDataEntity psDataEntity) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDataEntityMap.get(strPSDataEntityId) != null) {
         psSystemStorage.psDataEntityMap.get(strPSDataEntityId).CopyTo(psDataEntity, true);
         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.psDataEntityMap.get(strPSDataEntityId) != null) {
            psSysAppStorage.psDataEntityMap.get(strPSDataEntityId).CopyTo(psDataEntity, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSDataEntity(strPSDataEntityId), psDataEntity, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEDBConfigs(String strPSDataEntityId, Vector<PSDEDBConfig> psDEDBConfigList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDBConfigList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDBConfigList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDBConfigs(strPSDataEntityId), psDEDBConfigList, PSDEDBConfig.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDBConfigsBySystem(String strPSSystemId, Vector<PSDEDBConfig> psDEDBConfigList) {
      return this.selectMulti(this.getSQL_getPSDEDBConfigsBySystem(strPSSystemId), psDEDBConfigList, PSDEDBConfig.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDBConfig(String strPSDataEntityId, String strDBType, PSDEDBConfig psDEDBConfig) {
      return this.selectSingle(this.getSQL_getPSDataEntity(strPSDataEntityId, strDBType), psDEDBConfig, "SYSTEM");
   }

   @Override
   public CallResult getPSDEFDTColumns(String strPSDataEntityId, String strDBType, Vector<PSDEFDTColumn> psDEFDTColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null) {
         for (PSDEFDTColumn psDEFDTColumn : psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEFDTColumnList) {
            if (StringHelper.Compare(psDEFDTColumn.getDBType(), strDBType, true) == 0) {
               psDEFDTColumnList.add(psDEFDTColumn);
            }
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFDTColumns(strPSDataEntityId, strDBType), psDEFDTColumnList, PSDEFDTColumn.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSystemDBConfigs(String strPSSystemId, Vector<PSSystemDBConfig> psSystemDBConfigList) {
      return this.selectMulti(this.getSQL_getPSSystemDBConfigs(strPSSystemId), psSystemDBConfigList, PSSystemDBConfig.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSystemDBConfig(String strPSSystemId, String strDBType, PSSystemDBConfig psSystemDBConfig) {
      return this.selectSingle(this.getSQL_getPSSystemDBConfig(strPSSystemId, strDBType), psSystemDBConfig, "SYSTEM");
   }

   @Override
   public CallResult getPSSystemDeploy(String strPSSystemDeployId, PSSystemDeploy psSystemDeploy) {
      return this.selectSingle(this.getSQL_getPSSystemDeploy(strPSSystemDeployId), psSystemDeploy, "SYSTEM");
   }

   @Override
   public CallResult getPSSystemApplication(String strPSSystemApplicationId, PSSystemApplication psSystemApplication) {
      return this.selectSingle(this.getSQL_getPSSystemApplication(strPSSystemApplicationId), psSystemApplication, "SYSTEM");
   }

   @Override
   public CallResult getAllPSSystemApplications(String strPSSystemId, Vector<PSSystemApplication> psSystemApplicationList) {
      return this.selectMulti(this.getSQL_getAllPSSystemApplications(strPSSystemId), psSystemApplicationList, PSSystemApplication.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSystemModules(String strPSSystemId, Vector<PSSystemModule> psSystemModuleList) {
      return this.selectMulti(this.getSQL_getAllPSSystemModules(strPSSystemId), psSystemModuleList, PSSystemModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSystemDBConfigs(String strPSSystemId, Vector<PSSystemDBConfig> psSystemDBConfigList) {
      return this.selectMulti(this.getSQL_getAllPSSystemDBConfigs(strPSSystemId), psSystemDBConfigList, PSSystemDBConfig.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSViewType(String strPSViewTypeId, PSViewType psViewType) {
      return this.selectSingle(this.getSQL_getPSViewType(strPSViewTypeId), psViewType, "SYSTEM");
   }

   @Override
   public CallResult getPSApplicationView(String strPSApplicationViewId, PSAppView psApplicationView) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psAppViewMap.containsKey(strPSApplicationViewId)) {
         psSysAppStorage.psAppViewMap.get(strPSApplicationViewId).CopyTo(psApplicationView, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSApplicationView(strPSApplicationViewId), psApplicationView, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSAppIndexView(String strPSAppIndexViewId, PSAppIndexView psAppIndexView) {
      return this.selectSingle(this.getSQL_getPSAppIndexView(strPSAppIndexViewId), psAppIndexView, "SYSTEM");
   }

   @Override
   public CallResult getPSAppPortalView(String strPSAppPortalViewId, PSAppPortalView psAppPortalView) {
      return this.selectSingle(this.getSQL_getPSAppPortalView(strPSAppPortalViewId), psAppPortalView, "SYSTEM");
   }

   public CallResult getAllPSAppViews2(String strPSApplicationId, Vector<PSAppView> psApplicationViews) {
      return this.selectMulti(this.getSQL_getAllPSApplicationViews(strPSApplicationId), psApplicationViews, PSAppView.class.getName(), "SYSTEM", true);
   }

   @Override
   public CallResult getAllPSApplicationViews(String strPSApplicationId, Vector<PSAppView> psApplicationViews) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psApplicationViews, psSysAppStorage.psAppViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSApplicationViews(strPSApplicationId), psApplicationViews, PSAppView.class.getName(), "SYSTEM", true);
   }

   public CallResult getAllPSAppUtilPages2(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
      return this.selectMulti(this.getSQL_getAllPSAppUtilPages(strPSApplicationId), psAppUtilPages, PSAppUtilPage.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppUtilPages(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppUtilPages, psSysAppStorage.psAppUtilPageList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppUtilPages(strPSApplicationId), psAppUtilPages, PSAppUtilPage.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSAppViewCodes2(String strPSApplicationId, Vector<PSAppViewCode> psApplicationViews) {
      return this.selectMulti(this.getSQL_getAllPSAppViewCodes(strPSApplicationId), psApplicationViews, PSAppViewCode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppViewCodes(String strPSApplicationId, Vector<PSAppViewCode> psApplicationViews) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psApplicationViews, psSysAppStorage.psAppViewCodeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppViewCodes(strPSApplicationId), psApplicationViews, PSAppViewCode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppDEViews(String strPSSysAppId, String strPSDEId, Vector<PSAppDEView> psAppDEViewList) {
      return this.selectMulti(this.getSQL_getAllPSAppDEViews(strPSSysAppId, strPSDEId), psAppDEViewList, PSAppDEView.class.getName(), "SYSTEM", true);
   }

   public CallResult getAllPSAppDEViews(String strPSSysAppId, Vector<PSAppDEView> psAppDEViewList) {
      return this.selectMulti(this.getSQL_getAllPSAppDEViews(strPSSysAppId), psAppDEViewList, PSAppDEView.class.getName(), "SYSTEM", true);
   }

   public CallResult getAllPSDEViewBasesBySystem(String strPSSystemId, Vector<PSDEViewBase> psDEViewBaseList) {
      return this.selectMulti(this.getSQL_getAllPSDEViewBasesBySystem(strPSSystemId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
   }

   public CallResult getPSDEToolbarsBySystem(String strPSSystemId, Vector<PSDEToolbar> psDEToolbarList) {
      return this.selectMulti(this.getSQL_getPSDEToolbarsBySystem(strPSSystemId), psDEToolbarList, PSDEToolbar.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEToolbarItemsBySystem(String strPSSystemId, Vector<PSDEToolbarItem> psDEToolbarItemList) {
      return this.selectMulti(this.getSQL_getPSDEToolbarItemsBySystem(strPSSystemId), psDEToolbarItemList, PSDEToolbarItem.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEFormsBySystem(String strPSSystemId, Vector<PSDEForm> psDEFormList) {
      return this.selectMulti(this.getSQL_getPSDEFormsBySystem(strPSSystemId), psDEFormList, PSDEForm.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEGridsBySystem(String strPSSystemId, Vector<PSDEGrid> psDEGridList) {
      return this.selectMulti(this.getSQL_getPSDEGridsBySystem(strPSSystemId), psDEGridList, PSDEGrid.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEChartsBySystem(String strPSSystemId, Vector<PSDEChart> psDEChartList) {
      return this.selectMulti(this.getSQL_getPSDEChartsBySystem(strPSSystemId), psDEChartList, PSDEChart.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEFormDetailsBySystem(String strPSSystemId, Vector<PSDEFormDetail> psDEFormDetailList) {
      return this.selectMulti(this.getSQL_getPSDEFormDetailsBySystem(strPSSystemId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEGridColumnsBySystem(String strPSSystemId, Vector<PSDEGridColumn> psDEGridColumnList) {
      return this.selectMulti(this.getSQL_getPSDEGridColumnsBySystem(strPSSystemId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEChartAxesesBySystem(String strPSSystemId, Vector<PSDEChartAxes> psDEChartAxesList) {
      return this.selectMulti(this.getSQL_getPSDEChartAxesesBySystem(strPSSystemId), psDEChartAxesList, PSDEChartAxes.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEChartSeriesesBySystem(String strPSSystemId, Vector<PSDEChartSeries> psDEChartSeriesList) {
      return this.selectMulti(this.getSQL_getPSDEChartSeriesesBySystem(strPSSystemId), psDEChartSeriesList, PSDEChartSeries.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSControlType(String strPSControlTypeId, PSControlType psControlType) {
      return this.selectSingle(this.getSQL_getPSControlType(strPSControlTypeId), psControlType, "SYSTEM");
   }

   protected String getSQL_getPSControlType(String strPSControlTypeId) {
      return StringHelper.Format("select t1.* from V_SRFPSCTRLTYPE t1 where  t1.PSCTRLTYPEID='%1$s'", strPSControlTypeId);
   }

   @Override
   public CallResult getPSEditorType(String strPSEditorTypeId, PSEditorType psEditorType) {
      return this.selectSingle(this.getSQL_getPSEditorType(strPSEditorTypeId), psEditorType, "SYSTEM");
   }

   @Override
   public CallResult getPSAppModule(String strPSAppModuleId, PSAppModule psAppModule) {
      return this.selectSingle(this.getSQL_getPSAppModule(strPSAppModuleId), psAppModule, "SYSTEM");
   }

   public CallResult getAllPSAppModules2(String strPSApplicationId, Vector<PSAppModule> psAppModules) {
      return this.selectMulti(this.getSQL_getAllPSAppModules(strPSApplicationId), psAppModules, PSAppModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppModules(String strPSApplicationId, Vector<PSAppModule> psAppModules) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppModules, psSysAppStorage.psAppModuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppModules(strPSApplicationId), psAppModules, PSAppModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppUtilPage(String strPSAppUtilPageId, PSAppUtilPage psAppUtilPage) {
      return this.selectSingle(this.getSQL_getPSAppUtilPage(strPSAppUtilPageId), psAppUtilPage, "SYSTEM");
   }

   @Override
   public CallResult getPSAppUIStyle(String strPSAppUIStyleId, PSAppUIStyle psAppUIStyle) {
      return this.selectSingle(this.getSQL_getPSAppUIStyle(strPSAppUIStyleId), psAppUIStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSAppType(String strPSAppTypeId, PSAppType psAppType) {
      return this.selectSingle(this.getSQL_getPSAppType(strPSAppTypeId), psAppType, "SYSTEM");
   }

   @Override
   public CallResult getPSPFStyle(String strPSPFStyleId, PSPFStyle psPFStyle) {
      return this.selectSingle(this.getSQL_getPSPFStyle(strPSPFStyleId), psPFStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSPFStyleRefreshVersion(String strPSPFStyleId, PSPFStyle psPFStyle) {
      return this.selectSingle(this.getSQL_getPSPFStyleRefreshVersion(strPSPFStyleId), psPFStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSSFStyleRefreshVersion(String strPSSFStyleId, PSSFStyle psPFStyle) {
      return this.selectSingle(this.getSQL_getPSSFStyleRefreshVersion(strPSSFStyleId), psPFStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSPFCodeFolder(String strPSPFCodeFolderId, PSPFCodeFolder psPFCodeFolder) {
      return this.selectSingle(this.getSQL_getPSPFCodeFolder(strPSPFCodeFolderId), psPFCodeFolder, "SYSTEM");
   }

   @Override
   public CallResult getPSPFPubCodes(String strPSPFId, Vector<PSPFPubCode> psPFPubCodeList) {
      return this.selectMulti(this.getSQL_getPSPFPubCodes(strPSPFId), psPFPubCodeList, PSPFPubCode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId, Vector<PSPFPubCode> psPFPubCodeList) {
      return this.selectMulti(this.getSQL_getPSPFPubCodesByPPSPFPubCode(strPSPFPubCodeId), psPFPubCodeList, PSPFPubCode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPFViewTempl(String strPSPFViewTemplId, PSPFViewTempl psPFViewTempl) {
      return this.selectSingle(this.getSQL_getPSPFViewTempl(strPSPFViewTemplId), psPFViewTempl, "SYSTEM");
   }

   @Override
   public CallResult getPSPFViewTemplsByPF(String strPSPFId, Vector<PSPFViewTempl> psPFViewTemplList) {
      return this.selectMulti(this.getSQL_getPSPFViewTemplsByPF(strPSPFId), psPFViewTemplList, PSPFViewTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPFViewTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFViewTempl> psPFViewTemplList) {
      return this.selectMulti(this.getSQL_getPSPFViewTemplsByPFStyle(strPSPFStyleId), psPFViewTemplList, PSPFViewTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPFPubCode(String strPSPFPubCodeId, PSPFPubCode psPFPubCode) {
      return this.selectSingle(this.getSQL_getPSPFPubCode(strPSPFPubCodeId), psPFPubCode, "SYSTEM");
   }

   @Override
   public CallResult getPSDEUIActionType(String strPSDEUIActionTypeId, PSDEUIActionType psDEUIActionType) {
      return this.selectSingle(this.getSQL_getPSDEUIActionType(strPSDEUIActionTypeId), psDEUIActionType, "SYSTEM");
   }

   @Override
   public CallResult getPSPFCtrlTempl(String strPSPFCtrlTemplId, PSPFCtrlTempl psPFCtrlTempl) {
      return this.selectSingle(this.getSQL_getPSPFCtrlTempl(strPSPFCtrlTemplId), psPFCtrlTempl, "SYSTEM");
   }

   @Override
   public CallResult getPSDEGridColumnType(String strPSDEGridColumnTypeId, PSDEGridColumnType psDEGridColumnType) {
      return this.selectSingle(this.getSQL_getPSDEGridColumnType(strPSDEGridColumnTypeId), psDEGridColumnType, "SYSTEM");
   }

   @Override
   public CallResult getPSDEFGridColumns(String strPSDEFieldId, Vector<PSDEFGridColumn> psDEFGridColumnList) {
      return this.selectMulti(this.getSQL_getPSDEFGridColumns(strPSDEFieldId), psDEFGridColumnList, PSDEFGridColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEGridColumns(String strPSDEGridId, Vector<PSDEGridColumn> psDEGridColumnList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
         for (PSDEGridColumn psDEGridColumn : psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGridColumnList) {
            PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
            psDEGridColumn.CopyTo(psDEGridColumn2, true);
            psDEGridColumnList.add(psDEGridColumn2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEGridColumns(strPSDEGridId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEChartAxeses(String strPSDEChartId, Vector<PSDEChartAxes> psDEChartAxesList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
         for (PSDEChartAxes psDEChartAxes : psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId).psDEChartAxesList) {
            PSDEChartAxes psDEChartAxes2 = new PSDEChartAxes();
            psDEChartAxes.CopyTo(psDEChartAxes2, true);
            psDEChartAxesList.add(psDEChartAxes2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEChartAxeses(strPSDEChartId), psDEChartAxesList, PSDEChartAxes.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEChartSerieses(String strPSDEChartId, Vector<PSDEChartSeries> psDEChartSeriesList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
         for (PSDEChartSeries psDEChartSeries : psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId).psDEChartSeriesList) {
            PSDEChartSeries psDEChartSeries2 = new PSDEChartSeries();
            psDEChartSeries.CopyTo(psDEChartSeries2, true);
            psDEChartSeriesList.add(psDEChartSeries2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEChartSerieses(strPSDEChartId), psDEChartSeriesList, PSDEChartSeries.class.getName(), "SYSTEM");
      }
   }

   protected String getSQL_getPSDEChartSerieses(String strPSDEChartId) {
      return strPSDEChartId.indexOf("SRFTEMPKEY:") == 0
         ? StringHelper.Format(
            "select t1.* from V_PSDECHARTPARAM_TMP t1 where  t1.PSDECHARTID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", strPSDEChartId
         )
         : StringHelper.Format("select t1.* from V_SRFPSDECHARTPARAM t1 where  t1.PSDECHARTID='%1$s' order by ORDERVALUE", strPSDEChartId);
   }

   @Override
   public CallResult getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId, Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList) {
      return this.selectMulti(this.getSQL_getPSPFCtrlTemplDetails(strPSPFCtrlTemplId), psPFCtrlTemplDetailList, PSPFCtrlTemplDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERType(String strPSDERTypeId, PSDERType psDERType) {
      return this.selectSingle(this.getSQL_getPSDERType(strPSDERTypeId), psDERType, "SYSTEM");
   }

   @Override
   public CallResult getPSToolbarItemType(String strPSToolbarItemTypeId, PSToolbarItemType psToolbarItemType) {
      return this.selectSingle(this.getSQL_getPSToolbarItemType(strPSToolbarItemTypeId), psToolbarItemType, "SYSTEM");
   }

   @Override
   public CallResult getPSDEToolbarItems(String strPSDEToolbarId, Vector<PSDEToolbarItem> psDEToolbarItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId) != null) {
         for (PSDEToolbarItem psDEToolbarItem : psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId).psDEToolbarItemList) {
            PSDEToolbarItem psDEToolbarItem2 = new PSDEToolbarItem();
            psDEToolbarItem.CopyTo(psDEToolbarItem2, true);
            psDEToolbarItemList.add(psDEToolbarItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEToolbarItems(strPSDEToolbarId), psDEToolbarItemList, PSDEToolbarItem.class.getName(), "SYSTEM");
      }
   }

   public CallResult getPSDEUIActionsBySystem(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
      return this.selectMulti(this.getSQL_getPSDEUIActionsBySystem(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEUIActions(String strPSDataEntityId, Vector<PSDEUIAction> psDEUIActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
         && this.fromList(psDEUIActionList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEUIActionList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEUIActionList, psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId).psDEUIActionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEUIActions(strPSDataEntityId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && this.fromList(psDEUIActionList, psSystemStorage.psDEUIActionList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psDEUIActionList, psSysAppStorage.psDEUIActionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDEUIActions(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   public CallResult getPSSysDEUIActions2(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
      return this.selectMulti(this.getSQL_getPSSysDEUIActions(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEUIAction(String strPSDEUIActionId, PSDEUIAction psDEUIAction) {
      return this.selectSingle(this.getSQL_getPSDEUIAction(strPSDEUIActionId), psDEUIAction, "SYSTEM");
   }

   @Override
   public CallResult getPSDEUIActionGroup(String strPSDEUIActionGroupId, PSDEUIActionGroup psDEUIActionGroup) {
      return this.selectSingle(this.getSQL_getPSDEUIActionGroup(strPSDEUIActionGroupId), psDEUIActionGroup, "SYSTEM");
   }

   @Override
   public CallResult getPSAppViewStyle(String strPSAppViewStyleId, PSAppViewStyle psAppViewStyle) {
      return this.selectSingle(this.getSQL_getPSAppViewStyle(strPSAppViewStyleId), psAppViewStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSFormType(String strPSFormTypeId, PSFormType psFormType) {
      return this.selectSingle(this.getSQL_getPSFormType(strPSFormTypeId), psFormType, "SYSTEM");
   }

   @Override
   public CallResult getPSDEFormDetails(String strPSDEFormId, Vector<PSDEFormDetail> psDEFormDetailList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
         for (PSDEFormDetail psDEFormDetail : psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFormDetailList) {
            PSDEFormDetail psDEFormDetail2 = new PSDEFormDetail();
            psDEFormDetail.CopyTo(psDEFormDetail2, true);
            psDEFormDetailList.add(psDEFormDetail2);
         }

         return new CallResult();
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFormDetail psDEFormDetail : psSystemStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFormDetailList) {
               PSDEFormDetail psDEFormDetail2 = new PSDEFormDetail();
               psDEFormDetail.CopyTo(psDEFormDetail2, true);
               psDEFormDetailList.add(psDEFormDetail2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDEFormDetails(strPSDEFormId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSFormDetailType(String strPSFormDetailTypeId, PSFormDetailType psFormDetailType) {
      return this.selectSingle(this.getSQL_getPSFormDetailType(strPSFormDetailTypeId), psFormDetailType, "SYSTEM");
   }

   @Override
   public CallResult getPSDEFGridColumnsByDataEntity(String strPSDEId, Vector<PSDEFGridColumn> psDEFGridColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEFGridColumnList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFGridColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFGridColumnsByDataEntity(strPSDEId), psDEFGridColumnList, PSDEFGridColumn.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEFGridColumnsBySystem(String strPSSystemId, Vector<PSDEFGridColumn> psDEFGridColumnList) {
      return this.selectMulti(this.getSQL_getPSDEFGridColumnsBySystem(strPSSystemId), psDEFGridColumnList, PSDEFGridColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFUIModesByDataEntity(String strPSDEId, Vector<PSDEFUIMode> psDEFUIModeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFUIModeList != null) {
         psDEFUIModeList.addAll(psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFUIModeList);
         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFUIModesByDataEntity(strPSDEId), psDEFUIModeList, PSDEFUIMode.class.getName(), "SYSTEM");
      }
   }

   public CallResult getPSDEFUIModesBySystem(String strPSSystemId, Vector<PSDEFUIMode> psDEFUIModeList) {
      return this.selectMulti(this.getSQL_getPSDEFUIModesBySystem(strPSSystemId), psDEFUIModeList, PSDEFUIMode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFSearchModesByDataEntity(String strPSDEId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFSearchModeList != null) {
         psDEFSearchModeList.addAll(psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFSearchModeList);
         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFSearchModesByDataEntity(strPSDEId), psDEFSearchModeList, PSDEFSearchMode.class.getName(), "SYSTEM");
      }
   }

   public CallResult getPSDEFSearchModesBySystem(String strPSSystemId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
      return this.selectMulti(this.getSQL_getPSDEFSearchModesBySystem(strPSSystemId), psDEFSearchModeList, PSDEFSearchMode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFDTColumnsByDataEntity(String strPSDEId, Vector<PSDEFDTColumn> psDEFDTColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEFDTColumnList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFDTColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFDTColumnsByDataEntity(strPSDEId), psDEFDTColumnList, PSDEFDTColumn.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEFDTColumnsBySystem(String strPSSystemId, Vector<PSDEFDTColumn> psDEFDTColumnList) {
      return this.selectMulti(this.getSQL_getPSDEFDTColumnsBySystem(strPSSystemId), psDEFDTColumnList, PSDEFDTColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPFEditorTempl(String strPSPFEditorTemplId, PSPFEditorTempl psPFEditorTempl) {
      return this.selectSingle(this.getSQL_getPSPFEditorTempl(strPSPFEditorTemplId), psPFEditorTempl, "SYSTEM");
   }

   @Override
   public CallResult getPSAppEditorTempl(String strPSAppEditorTemplId, PSAppEditorTempl psAppEditorTempl) {
      return this.selectSingle(this.getSQL_getPSAppEditorTempl(strPSAppEditorTemplId), psAppEditorTempl, "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppEditorTempls(String strPSApplicationId, Vector<PSAppEditorTempl> psAppEditorTempls) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppEditorTempls, psSysAppStorage.psAppEditorTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppEditorTempls(strPSApplicationId), psAppEditorTempls, PSAppEditorTempl.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSAppEditorTempls2(String strPSApplicationId, Vector<PSAppEditorTempl> psAppEditorTempls) {
      return this.selectMulti(this.getSQL_getAllPSAppEditorTempls(strPSApplicationId), psAppEditorTempls, PSAppEditorTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERs(String strPSDataEntityId, Vector<PSDER> psDERList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDERList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDERList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDERs(strPSDataEntityId), psDERList, PSDER.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERsByMinorDEId(String strPSDataEntityId, Vector<PSDER> psDERList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDERList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDERList2)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDERsByMinorDEId(strPSDataEntityId), psDERList, PSDER.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSV3Migrate(String strPSV3MigrateId, PSV3Migrate psV3Migrate) {
      return this.selectSingle(this.getSQL_getPSV3Migrate(strPSV3MigrateId), psV3Migrate, "SYSTEM");
   }

   @Override
   public CallResult getPSAppFunc(String strPSAppFuncId, PSAppFunc psAppFunc) {
      return this.selectSingle(this.getSQL_getPSAppFunc(strPSAppFuncId), psAppFunc, "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppFuncs(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppFuncs, psSysAppStorage.psAppFuncList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppFuncs(strPSApplicationId), psAppFuncs, PSAppFunc.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSAppFuncs2(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
      return this.selectMulti(this.getSQL_getAllPSAppFuncs(strPSApplicationId), psAppFuncs, PSAppFunc.class.getName(), "SYSTEM");
   }

   public CallResult getPSAppMenuItemsBySysApp(String strPSSysAppId, Vector<PSAppMenuItem> psAppMenuItemList) {
      return this.selectMulti(this.getSQL_getPSAppMenuItemsBySysApp(strPSSysAppId), psAppMenuItemList, PSAppMenuItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppMenuItems(String strPSAppMenuId, Vector<PSAppMenuItem> psAppMenuItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null) {
         for (PSAppMenuItem psAppMenuItem : psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId).psAppMenuItemList) {
            PSAppMenuItem psAppMenuItem2 = new PSAppMenuItem();
            psAppMenuItem.CopyTo(psAppMenuItem2, true);
            psAppMenuItemList.add(psAppMenuItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSAppMenuItems(strPSAppMenuId), psAppMenuItemList, PSAppMenuItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSAppMenuItemType(String strPSAppMenuItemTypeId, PSAppMenuItemType psAppMenuItemType) {
      return this.selectSingle(this.getSQL_getPSAppMenuItemType(strPSAppMenuItemTypeId), psAppMenuItemType, "SYSTEM");
   }

   @Override
   public CallResult getPSDER(String strPSDERId, PSDER psDER) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDERMap.get(strPSDERId) != null) {
         psSystemStorage.psDERMap.get(strPSDERId).CopyTo(psDER, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDER(strPSDERId), psDER, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDBValueFunc(String strPSDBValueFuncId, PSDBValueFunc psDBValueFunc) {
      return this.selectSingle(this.getSQL_getPSDBValueFunc(strPSDBValueFuncId), psDBValueFunc, "SYSTEM");
   }

   @Override
   public CallResult getPSSysDBValueFunc(String strPSSystemId, String strPSSysDBValueFuncId, PSSysDBValueFunc psSysDBValueFunc) {
      return this.selectSingle(this.getSQL_getPSSysDBValueFunc(strPSSystemId, strPSSysDBValueFuncId), psSysDBValueFunc, "SYSTEM");
   }

   @Override
   public CallResult getPSDEJoinType(String strPSDEJoinTypeId, PSDEJoinType psDEJoinType) {
      return this.selectSingle(this.getSQL_getPSDEJoinType(strPSDEJoinTypeId), psDEJoinType, "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQueries(String strPSDataEntityId, Vector<PSDEDataQuery> psDEDataQueryList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDataQueryList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDataQueryList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataQueries(strPSDataEntityId), psDEDataQueryList, PSDEDataQuery.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDataQueriesBySystem(String strPSSystemId, Vector<PSDEDataQuery> psDEDataQueryList) {
      return this.selectMulti(this.getSQL_getPSDEDataQueriesBySystem(strPSSystemId), psDEDataQueryList, PSDEDataQuery.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQuery(String strPSDEDataQueryId, PSDEDataQuery psDEDataQuery) {
      return this.selectSingle(this.getSQL_getPSDEDataQuery(strPSDEDataQueryId), psDEDataQuery, "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQueryJoins(String strPSDEDataQueryId, Vector<PSDEDataQueryJoin> psDEDataQueryJoinList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null) {
         for (PSDEDataQueryJoin psDEDataQueryJoin : psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId).psDEDataQueryJoinList) {
            PSDEDataQueryJoin psDEDataQueryJoin2 = new PSDEDataQueryJoin();
            psDEDataQueryJoin.CopyTo(psDEDataQueryJoin2, true);
            psDEDataQueryJoinList.add(psDEDataQueryJoin2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEDataQueryJoins(strPSDEDataQueryId), psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName(), "SYSTEM");
      }
   }

   public CallResult getPSDEDataQueryJoinsBySystem(String strPSSystemId, Vector<PSDEDataQueryJoin> psDEDataQueryJoinList) {
      return this.selectMulti(this.getSQL_getPSDEDataQueryJoinsBySystem(strPSSystemId), psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQueryConds(String strPSDEDataQueryId, Vector<PSDEDataQueryCond> psDEDataQueryCondList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null) {
         for (PSDEDataQueryCond psDEDataQueryCond : psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId).psDEDataQueryCondList) {
            PSDEDataQueryCond psDEDataQueryCond2 = new PSDEDataQueryCond();
            psDEDataQueryCond.CopyTo(psDEDataQueryCond2, true);
            psDEDataQueryCondList.add(psDEDataQueryCond2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEDataQueryConds(strPSDEDataQueryId), psDEDataQueryCondList, PSDEDataQueryCond.class.getName(), "SYSTEM");
      }
   }

   public CallResult getPSDEDataQueryCondsBySystem(String strPSSystemId, Vector<PSDEDataQueryCond> psDEDataQueryCondList) {
      return this.selectMulti(this.getSQL_getPSDEDataQueryCondsBySystem(strPSSystemId), psDEDataQueryCondList, PSDEDataQueryCond.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDEDataQueryCondsBySystem(String strPSSystemId) {
      return StringHelper.Format(
         "select t1.* from V_SRFPSDEDQCOND t1 inner join t_srfpsdedataquery t2 on t1.PSDEDQID= t2.psdedataqueryid inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by ORDERVALUE ",
         strPSSystemId
      );
   }

   @Override
   public CallResult getPSDEDataSets(String strPSDataEntityId, Vector<PSDEDataSet> psDEDataSetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDataSetList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDataSetList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataSets(strPSDataEntityId), psDEDataSetList, PSDEDataSet.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDataSetsBySystem(String strPSSystemId, Vector<PSDEDataSet> psDEDataSetList) {
      return this.selectMulti(this.getSQL_getPSDEDataSetsBySystem(strPSSystemId), psDEDataSetList, PSDEDataSet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataSet(String strPSDEDataSetId, PSDEDataSet psDEDataSet) {
      return this.selectSingle(this.getSQL_getPSDEDataSet(strPSDEDataSetId), psDEDataSet, "SYSTEM");
   }

   @Override
   public CallResult getPSDEDSDQs(String strPSDataSetId, Vector<PSDEDSDQ> psDEDSDQList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null
            && this.fromList(psDEDSDQList, psSystemStorage.getPSDEDataSetStorage(strPSDataSetId).psDEDSDQList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDSDQs(strPSDataSetId), psDEDSDQList, PSDEDSDQ.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDSDQsBySystem(String strPSSystemId, Vector<PSDEDSDQ> psDEDSDQList) {
      return this.selectMulti(this.getSQL_getPSDEDSDQsBySystem(strPSSystemId), psDEDSDQList, PSDEDSDQ.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDSGroupParams(String strPSDataSetId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null
            && this.fromList(psDEDSGroupParamList, psSystemStorage.getPSDEDataSetStorage(strPSDataSetId).psDEDSGroupParamList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDSGroupParams(strPSDataSetId), psDEDSGroupParamList, PSDEDSGroupParam.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDSGroupParamsBySystem(String strPSSystemId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
      return this.selectMulti(this.getSQL_getPSDEDSGroupParamsBySystem(strPSSystemId), psDEDSGroupParamList, PSDEDSGroupParam.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSF(String strPSSFId, PSSF psSF) {
      return this.selectSingle(this.getSQL_getPSSF(strPSSFId), psSF, "SYSTEM");
   }

   @Override
   public CallResult getPSSFStyle(String strPSSFStyleId, PSSFStyle psSFStyle) {
      return this.selectSingle(this.getSQL_getPSSFStyle(strPSSFStyleId), psSFStyle, "SYSTEM");
   }

   @Override
   public CallResult getPSSFStyleVer(String strPSSFStyleVerId, PSSFStyleVer psSFStyleVer) {
      return this.selectSingle(this.getSQL_getPSSFStyleVer(strPSSFStyleVerId), psSFStyleVer, "SYSTEM");
   }

   @Override
   public CallResult getPSSFACHandler(String strPSSFACHandlerId, PSSFACHandler psSFACHandler) {
      return this.selectSingle(this.getSQL_getPSSFACHandler(strPSSFACHandlerId), psSFACHandler, "SYSTEM");
   }

   @Override
   public CallResult getPSSFCodeFolders(String strPSSFStyleId, Vector<PSSFCodeFolder> psSFCodeFolderList) {
      return this.selectMulti(this.getSQL_getPSSFCodeFolders(strPSSFStyleId), psSFCodeFolderList, PSSFCodeFolder.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSFCodeTempl(String strPSSFCodeTemplId, PSSFCodeTempl psSFCodeTempl) {
      return this.selectSingle(this.getSQL_getPSSFCodeTempl(strPSSFCodeTemplId), psSFCodeTempl, "SYSTEM");
   }

   @Override
   public CallResult getPSSFCodeTempls(String strPSSFCodeTypeId, Vector<PSSFCodeTempl> psSFCodeTemplList) {
      return this.selectMulti(this.getSQL_getPSSFCodeTempls(strPSSFCodeTypeId), psSFCodeTemplList, PSSFCodeTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSFCodeTypes(String strPSSFCodeFolderId, Vector<PSSFCodeType> psSFCodeTypeList) {
      return this.selectMulti(this.getSQL_getPSSFCodeTypes(strPSSFCodeFolderId), psSFCodeTypeList, PSSFCodeType.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSDataEntities2(String strPSSystemId, Vector<PSDataEntity> psDataEntityList) {
      return this.selectMulti(this.getSQL_getAllPSDataEntities(strPSSystemId), psDataEntityList, PSDataEntity.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDataEntities(String strPSSystemId, Vector<PSDataEntity> psDataEntityList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDataEntityList, psSystemStorage.psDataEntityList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSDataEntities(strPSSystemId), psDataEntityList, PSDataEntity.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAjaxControlHandlers(String strPSSystemId, Vector<PSACHandler> psAjaxControlHandlerList) {
      return this.selectMulti(this.getSQL_getPSSysAjaxControlHandlers(strPSSystemId), psAjaxControlHandlerList, PSACHandler.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAjaxControlHandlers(String strPSDataEntityId, Vector<PSACHandler> psAjaxControlHandlerList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psAjaxControlHandlerList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psACHandlerList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSAjaxControlHandlers(strPSDataEntityId), psAjaxControlHandlerList, PSACHandler.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEViewViews(String strPSDEViewId, Vector<PSDEViewView> psDEViewViewList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null
            && this.fromList(psDEViewViewList, psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId).psDEViewViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEViewViews(strPSDEViewId), psDEViewViewList, PSDEViewView.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEViewCtrls(String strPSDEViewId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null) {
         ArrayList<PSDEViewCtrl> psDEViewCtrlList2 = psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId).psDEViewCtrlList;
         if (psDEViewCtrlList2 != null) {
            for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList2) {
               PSDEViewCtrl psDEViewCtrl2 = new PSDEViewCtrl();
               psDEViewCtrl.CopyTo(psDEViewCtrl2, true);
               psDEViewCtrlList.add(psDEViewCtrl2);
            }

            return new CallResult();
         }
      }

      return this.selectMulti(this.getSQL_getPSDEViewCtrls(strPSDEViewId), psDEViewCtrlList, PSDEViewCtrl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppViewRefs(String strPSAppViewId, Vector<PSAppViewRef> psAppViewRefList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId) != null
            && this.fromList(psAppViewRefList, psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId).psAppViewRefList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSAppViewRefs(strPSAppViewId), psAppViewRefList, PSAppViewRef.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionLogics(String strPSDEActionId, Vector<PSDEActionLogic> psDEActionLogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
         for (PSDEActionLogic psDEActionLogic : psSystemStorage.getPSDEActionStorage(strPSDEActionId).psDEActionLogicList) {
            PSDEActionLogic psDEActionLogic2 = new PSDEActionLogic();
            psDEActionLogic.CopyTo(psDEActionLogic2, true);
            psDEActionLogicList.add(psDEActionLogic2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEActionLogics(strPSDEActionId), psDEActionLogicList, PSDEActionLogic.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEActionParams(String strPSDEActionId, Vector<PSDEActionParam> psDEActionParamList) {
      if (this.getModelInstVer() < 353) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
         for (PSDEActionParam psDEActionParam : psSystemStorage.getPSDEActionStorage(strPSDEActionId).psDEActionParamList) {
            PSDEActionParam psDEActionParam2 = new PSDEActionParam();
            psDEActionParam.CopyTo(psDEActionParam2, true);
            psDEActionParamList.add(psDEActionParam2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEActionParams(strPSDEActionId), psDEActionParamList, PSDEActionParam.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEActions(String strPSDataEntityId, Vector<PSDEAction> psDEActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEActionList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEActionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActions(strPSDataEntityId), psDEActionList, PSDEAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSCodeLists(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psCodeListList, psCodeListList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSCodeLists(strPSSystemId), psCodeListList, PSCodeList.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSCodeItems(String strPSCodeListId, Vector<PSCodeItem> psCodeItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSCodeListStorage(strPSCodeListId) != null
            && this.copyList(psSystemStorage.getPSCodeListStorage(strPSCodeListId).psCodeItemList, psCodeItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSCodeItems(strPSCodeListId), psCodeItemList, PSCodeItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppViewLogics(String strPSAppViewId, Vector<PSAppViewLogic> psAppViewLogicList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId) != null
            && this.fromList(psAppViewLogicList, psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId).psAppViewLogicList)
         ? new CallResult()
         : new CallResult();
   }

   @Override
   public CallResult getPSDEFValueRulesByDataEntity(String strPSDEId, Vector<PSDEFValueRule> psDEFValueRuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEFValueRuleList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFValueRuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFValueRulesByDataEntity(strPSDEId), psDEFValueRuleList, PSDEFValueRule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFValueRuleConds(String strPSDEFValueRuleId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEFValueRuleStorage(strPSDEFValueRuleId) != null) {
         for (PSDEFValueRuleCond psDEFValueRuleCond : psSystemStorage.getPSDEFValueRuleStorage(strPSDEFValueRuleId).psDEFValueRuleCondList) {
            PSDEFValueRuleCond psDEFValueRuleCond2 = new PSDEFValueRuleCond();
            psDEFValueRuleCond.CopyTo(psDEFValueRuleCond2, true);
            psDEFValueRuleCondList.add(psDEFValueRuleCond2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFValueRuleConds(strPSDEFValueRuleId), psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEACModes(String strPSDataEntityId, Vector<PSDEACMode> psDEACModeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
         && this.fromList(psDEACModeList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEACModeList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEACModeList, psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId).psDEACModeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEACModes(strPSDataEntityId), psDEACModeList, PSDEACMode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEACModeItems(String strPSDEACModeId, Vector<PSDEACModeItem> psDEACModeItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEACModeStorage(strPSDEACModeId) != null) {
         for (PSDEACModeItem psDEACModeItem : psSystemStorage.getPSDEACModeStorage(strPSDEACModeId).psDEACModeItemList) {
            PSDEACModeItem psDEACModeItem2 = new PSDEACModeItem();
            psDEACModeItem.CopyTo(psDEACModeItem2, true);
            psDEACModeItemList.add(psDEACModeItem2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDEACModeStorage(strPSDEACModeId) != null) {
            for (PSDEACModeItem psDEACModeItem : psSysAppStorage.getPSDEACModeStorage(strPSDEACModeId).psDEACModeItemList) {
               PSDEACModeItem psDEACModeItem2 = new PSDEACModeItem();
               psDEACModeItem.CopyTo(psDEACModeItem2, true);
               psDEACModeItemList.add(psDEACModeItem2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDEACModeItems(strPSDEACModeId), psDEACModeItemList, PSDEACModeItem.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEDRGroups(String strPSDataEntityId, Vector<PSDEDRGroup> psDEDRGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDRGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDRGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDRGroups(strPSDataEntityId), psDEDRGroupList, PSDEDRGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDRItems(String strPSDEId, Vector<PSDEDRItem> psDEDRItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEDRItemList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEDRItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDRItems(strPSDEId), psDEDRItemList, PSDEDRItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDRDetails(String strPSDEDRId, Vector<PSDEDRDetail> psDEDRDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEDataRelationStorage(strPSDEDRId) != null) {
         for (PSDEDRDetail psDEDRDetail : psSystemStorage.getPSDEDataRelationStorage(strPSDEDRId).psDEDRDetailList) {
            PSDEDRDetail psDEDRDetail2 = new PSDEDRDetail();
            psDEDRDetail.CopyTo(psDEDRDetail2, true);
            psDEDRDetailList.add(psDEDRDetail2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEDRDetails(strPSDEDRId), psDEDRDetailList, PSDEDRDetail.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppMenus(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppMenus, psSysAppStorage.psAppMenuList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppMenus(strPSApplicationId), psAppMenus, PSAppMenu.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppMenu(String strPSAppMenuId, PSAppMenu psAppMenu) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null) {
         psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId).psAppMenu.CopyTo(psAppMenu, false);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSAppMenu(strPSAppMenuId), psAppMenu, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEGrid(String strPSDEGridId, PSDEGrid psDEGrid) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.containsKey(strPSDEGridId)) {
         psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGrid.CopyTo(psDEGrid, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEGrid(strPSDEGridId), psDEGrid, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEChart(String strPSDEChartId, PSDEChart psDEChart) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
         psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId).psDEChart.CopyTo(psDEChart, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEChart(strPSDEChartId), psDEChart, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEReport(String strPSDEReportId, PSDEReport psDEReport) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEReportStorageMap.get(strPSDEReportId) != null) {
         psSysAppStorage.psDEReportStorageMap.get(strPSDEReportId).psDEReport.CopyTo(psDEReport, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEReport(strPSDEReportId), psDEReport, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEToolbar(String strPSDEToolbarId, PSDEToolbar psDEToolbar) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEToolbarStorageMap.containsKey(strPSDEToolbarId)) {
         psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId).psDEToolbar.CopyTo(psDEToolbar, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEToolbar(strPSDEToolbarId), psDEToolbar, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEForm(String strPSDEFormId, PSDEForm psDEForm) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.containsKey(strPSDEFormId)) {
         psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEForm.CopyTo(psDEForm, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEForm(strPSDEFormId), psDEForm, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEDataRelations(String strPSDEId, Vector<PSDEDataRelation> psDEDataRelationList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEDataRelationList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEDataRelationList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataRelations(strPSDEId), psDEDataRelationList, PSDEDataRelation.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDERs(String strPSSystemId, Vector<PSDER> psDataEntityList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDataEntityList, psSystemStorage.psDERList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSDERs(strPSSystemId), psDataEntityList, PSDER.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQueryCodes(String strPSDEDataQueryId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null
            && this.fromList(psDEDataQueryCodeList, psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId).psDEDataQueryCodeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataQueryCodes(strPSDEDataQueryId), psDEDataQueryCodeList, PSDEDataQueryCode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId) != null
            && this.fromList(psDEDataQueryCodeExpList, psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId).psDEDataQueryCodeExpList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSDEDataQueryCodeExps(strPSDEDataQueryCodeId), psDEDataQueryCodeExpList, PSDEDataQueryCodeExp.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSDEFDLogics(String strPSDEFormId, Vector<PSDEFDLogic> psDEFDLogicList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
         for (PSDEFDLogic psDEFDLogic : psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFDLogicList) {
            PSDEFDLogic psDEFDLogic2 = new PSDEFDLogic();
            psDEFDLogic.CopyTo(psDEFDLogic2, true);
            psDEFDLogicList.add(psDEFDLogic2);
         }

         return new CallResult();
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFDLogic psDEFDLogic : psSystemStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFDLogicList) {
               PSDEFDLogic psDEFDLogic2 = new PSDEFDLogic();
               psDEFDLogic.CopyTo(psDEFDLogic2, true);
               psDEFDLogicList.add(psDEFDLogic2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDEFDLogics(strPSDEFormId), psDEFDLogicList, PSDEFDLogic.class.getName(), "SYSTEM");
         }
      }
   }

   protected String getSQL_getPSDEFDLogics(String strPSDEFormId) {
      return strPSDEFormId.indexOf("SRFTEMPKEY:") == 0
         ? StringHelper.Format(
            "select t1.* from V_PSDEFDLOGIC_TMP t1 inner join t_srfpsdeformdetail_TMP t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE",
            strPSDEFormId
         )
         : StringHelper.Format(
            "select t1.* from V_SRFPSDEFDLOGIC t1 inner join t_srfpsdeformdetail t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' order by t1.ORDERVALUE",
            strPSDEFormId
         );
   }

   public CallResult getPSDEFDLogicsBySystem(String strPSSystemId, Vector<PSDEFDLogic> psDEFDLogicList) {
      return this.selectMulti(this.getSQL_getPSDEFDLogicsBySystem(strPSSystemId), psDEFDLogicList, PSDEFDLogic.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDEFDLogicsBySystem(String strPSSystemId) {
      return StringHelper.Format(
         "select t1.*,t2.PSDEFORMID from V_SRFPSDEFDLOGIC t1 inner join t_srfpsdeformdetail t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID  inner join t_srfpsdeform t3 on t2.psdeformid = t3.psdeformid inner join t_srfpsdataentity t4 on t3.psdeid = t4.psdataentityid  where t4.PSSYSTEMID='%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE",
         strPSSystemId
      );
   }

   @Override
   public CallResult getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId) != null
            && this.fromList(psDEDataQueryCodeCondList, psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId).psDEDataQueryCodeCondList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSDEDataQueryCodeConds(strPSDEDataQueryCodeId), psDEDataQueryCodeCondList, PSDEDataQueryCodeCond.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSDEDataView(String strPSDEDataViewId, PSDEDataView psDEDataView) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null) {
         psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId).psDEDataView.CopyTo(psDEDataView, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEDataView(strPSDEDataViewId), psDEDataView, "SYSTEM");
      }
   }

   protected String getSQL_getPSDEDataView(String strPSDEDataViewId) {
      return strPSDEDataViewId.indexOf("SRFTEMPKEY:") == 0
         ? StringHelper.Format("select t1.* from V_PSDEDATAVIEW_TMP t1 where  t1.PSDEDATAVIEWID='%1$s'", strPSDEDataViewId)
         : StringHelper.Format("select t1.* from V_SRFPSDEDATAVIEW t1 where  t1.PSDEDATAVIEWID='%1$s'", strPSDEDataViewId);
   }

   @Override
   public CallResult getPSDEDataViewItems(String strPSDEDataViewId, Vector<PSDEDataViewItem> psDEDataViewItemDataView) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null) {
         for (PSDEDataViewItem psDEDataViewItem : psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId).psDEDataViewItemList) {
            PSDEDataViewItem psDEDataViewItem2 = new PSDEDataViewItem();
            psDEDataViewItem.CopyTo(psDEDataViewItem2, true);
            psDEDataViewItemDataView.add(psDEDataViewItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEDataViewItems(strPSDEDataViewId), psDEDataViewItemDataView, PSDEDataViewItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEUIActionGroups(String strPSDataEntityId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
         && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEUIActionGroupList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId).psDEUIActionGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEUIActionGroups(strPSDataEntityId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId) != null
         && this.fromList(psDEUIActionGroupDetailList, psSystemStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId).psDEUIActionGroupDetailList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId) != null
            && this.fromList(psDEUIActionGroupDetailList, psSysAppStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId).psDEUIActionGroupDetailList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSDEUIActionGroupDetails(strPSDEUIActionGroupId), psDEUIActionGroupDetailList, PSDEUIActionGroupDetail.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSDELogicNodes(String strPSDELogicId, Vector<PSDELogicNode> psDELogicNodeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
         for (PSDELogicNode psDELogicNode : psSystemStorage.getPSDELogicStorage(strPSDELogicId).psDELogicNodeList) {
            PSDELogicNode psDELogicNode2 = new PSDELogicNode();
            psDELogicNode.CopyTo(psDELogicNode2, true);
            psDELogicNodeList.add(psDELogicNode2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNode psDELogicNode : psSysAppStorage.getPSDELogicStorage(strPSDELogicId).psDELogicNodeList) {
               PSDELogicNode psDELogicNode2 = new PSDELogicNode();
               psDELogicNode.CopyTo(psDELogicNode2, true);
               psDELogicNodeList.add(psDELogicNode2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDELogicNodes(strPSDELogicId), psDELogicNodeList, PSDELogicNode.class.getName(), "SYSTEM");
         }
      }
   }

   protected String getSQL_getPSDELogicNodes(String strPSDELogicId) {
      return StringHelper.Format("select t1.* from V_SRFPSDELOGICNODE t1 where  t1.PSDELOGICID='%1$s' ", strPSDELogicId);
   }

   public CallResult getPSDELogicNodesBySystem(String strPSSystemId, Vector<PSDELogicNode> psDELogicNodeList) {
      return this.selectMulti(this.getSQL_getPSDELogicNodesBySystem(strPSSystemId), psDELogicNodeList, PSDELogicNode.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDELogicNodesBySystem(String strPSSystemId) {
      return StringHelper.Format(
         "select t1.* from V_SRFPSDELOGICNODE t1 inner join T_SRFPSDELOGIC t2 on t1.PSDELOGICID= t2.PSDELOGICID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)",
         strPSSystemId
      );
   }

   @Override
   public CallResult getPSDELogicLinks(String strPSDELogicId, Vector<PSDELogicLink> psDELogicLinkList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
         for (PSDELogicLink psDELogicLink : psSystemStorage.getPSDELogicStorage(strPSDELogicId).psDELogicLinkList) {
            PSDELogicLink psDELogicLink2 = new PSDELogicLink();
            psDELogicLink.CopyTo(psDELogicLink2, true);
            psDELogicLinkList.add(psDELogicLink2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLink psDELogicLink : psSysAppStorage.getPSDELogicStorage(strPSDELogicId).psDELogicLinkList) {
               PSDELogicLink psDELogicLink2 = new PSDELogicLink();
               psDELogicLink.CopyTo(psDELogicLink2, true);
               psDELogicLinkList.add(psDELogicLink2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDELogicLinks(strPSDELogicId), psDELogicLinkList, PSDELogicLink.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDELogicLinkConds(String strPSDELogicId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
         for (PSDELogicLinkCond psDELogicLinkCond : psSystemStorage.getPSDELogicStorage(strPSDELogicId).psDELogicLinkCondList) {
            PSDELogicLinkCond psDELogicLinkCond2 = new PSDELogicLinkCond();
            psDELogicLinkCond.CopyTo(psDELogicLinkCond2, true);
            psDELogicLinkCondList.add(psDELogicLinkCond2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLinkCond psDELogicLinkCond : psSysAppStorage.getPSDELogicStorage(strPSDELogicId).psDELogicLinkCondList) {
               PSDELogicLinkCond psDELogicLinkCond2 = new PSDELogicLinkCond();
               psDELogicLinkCond.CopyTo(psDELogicLinkCond2, true);
               psDELogicLinkCondList.add(psDELogicLinkCond2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDELogicLinkConds(strPSDELogicId), psDELogicLinkCondList, PSDELogicLinkCond.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDELogics(String strPSDataEntityId, Vector<PSDELogic> psDELogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
         && this.fromList(psDELogicList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDELogicList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDELogicList, psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId).psDELogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDELogics(strPSDataEntityId), psDELogicList, PSDELogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDELogicNodeParams(String strPSDELogicId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
         for (PSDELogicNodeParam psDELogicNodeParam : psSystemStorage.getPSDELogicStorage(strPSDELogicId).psDELogicNodeParamList) {
            PSDELogicNodeParam psDELogicNodeParam2 = new PSDELogicNodeParam();
            psDELogicNodeParam.CopyTo(psDELogicNodeParam2, true);
            psDELogicNodeParamList.add(psDELogicNodeParam2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNodeParam psDELogicNodeParam : psSysAppStorage.getPSDELogicStorage(strPSDELogicId).psDELogicNodeParamList) {
               PSDELogicNodeParam psDELogicNodeParam2 = new PSDELogicNodeParam();
               psDELogicNodeParam.CopyTo(psDELogicNodeParam2, true);
               psDELogicNodeParamList.add(psDELogicNodeParam2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDELogicNodeParams(strPSDELogicId), psDELogicNodeParamList, PSDELogicNodeParam.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDELogicParams(String strPSDELogicId, Vector<PSDELogicParam> psDELogicParamList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
         for (PSDELogicParam psDELogicParam : psSystemStorage.getPSDELogicStorage(strPSDELogicId).psDELogicParamList) {
            PSDELogicParam psDELogicParam2 = new PSDELogicParam();
            psDELogicParam.CopyTo(psDELogicParam2, true);
            psDELogicParamList.add(psDELogicParam2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicParam psDELogicParam : psSysAppStorage.getPSDELogicStorage(strPSDELogicId).psDELogicParamList) {
               PSDELogicParam psDELogicParam2 = new PSDELogicParam();
               psDELogicParam.CopyTo(psDELogicParam2, true);
               psDELogicParamList.add(psDELogicParam2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDELogicParams(strPSDELogicId), psDELogicParamList, PSDELogicParam.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEPredefinedViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEViewBaseList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEPredefinedViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEPredefinedViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
   }

   @Override
   public CallResult getPSDEViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEViewBaseList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
   }

   @Override
   public CallResult getPSDEEditForms(String strPSDataEntityId, Vector<PSDEForm> psDEEditFormList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEEditFormList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEEditFormList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEEditForms(strPSDataEntityId), psDEEditFormList, PSDEForm.class.getName(), "SYSTEM", true);
   }

   @Override
   public CallResult getPSDEFIUpdates(String strPSDEFormId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
         for (PSDEFIUpdate psDEFIUpdate : psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFIUpdateList) {
            PSDEFIUpdate psDEFIUpdate2 = new PSDEFIUpdate();
            psDEFIUpdate.CopyTo(psDEFIUpdate2, true);
            psDEFIUpdateList.add(psDEFIUpdate2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFIUpdates(strPSDEFormId), psDEFIUpdateList, PSDEFIUpdate.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEFIUDetails(String strPSDEFormId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
         for (PSDEFIUDetail psDEFIUDetail : psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFIUDetailList) {
            PSDEFIUDetail psDEFIUDetail2 = new PSDEFIUDetail();
            psDEFIUDetail.CopyTo(psDEFIUDetail2, true);
            psDEFIUDetailList.add(psDEFIUDetail2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEFIUDetails(strPSDEFormId), psDEFIUDetailList, PSDEFIUDetail.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEFormRFs(String strPSDEFormId, Vector<PSDEFormRF> psDEFormRFList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null
            && this.fromList(psDEFormRFList, psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFormRFList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFormRFs(strPSDEFormId), psDEFormRFList, PSDEFormRF.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFormItemVRs(String strPSDEFormId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null
            && this.fromList(psDEFormItemVRList, psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFormItemVRList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFormItemVRs(strPSDEFormId), psDEFormItemVRList, PSDEFormItemVR.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEMaps(String strPSDEId, Vector<PSDEMap> psDEMapList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && this.fromList(psDEMapList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEMapList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEMapList, psSysAppStorage.getPSDataEntityStorage(strPSDEId).psDEMapList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEMaps(strPSDEId), psDEMapList, PSDEMap.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEMapDetails(String strPSDEMapId, Vector<PSDEMapDetail> psDEMapDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
         for (PSDEMapDetail psDEMapDetail : psSystemStorage.getPSDEMapStorage(strPSDEMapId).psDEMapDetailList) {
            PSDEMapDetail psDEMapDetail2 = new PSDEMapDetail();
            psDEMapDetail.CopyTo(psDEMapDetail2, true);
            psDEMapDetailList.add(psDEMapDetail2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEMapDetails(strPSDEMapId), psDEMapDetailList, PSDEMapDetail.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEMapActions(String strPSDEMapId, Vector<PSDEMapAction> psDEMapActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
         for (PSDEMapAction psDEMapAction : psSystemStorage.getPSDEMapStorage(strPSDEMapId).psDEMapActionList) {
            PSDEMapAction psDEMapAction2 = new PSDEMapAction();
            psDEMapAction.CopyTo(psDEMapAction2, true);
            psDEMapActionList.add(psDEMapAction2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEMapActions(strPSDEMapId), psDEMapActionList, PSDEMapAction.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEMapDataQueries(String strPSDEMapId, Vector<PSDEMapDataQuery> psDEMapDataQueryList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
         for (PSDEMapDataQuery psDEMapDataQuery : psSystemStorage.getPSDEMapStorage(strPSDEMapId).psDEMapDataQueryList) {
            PSDEMapDataQuery psDEMapDataQuery2 = new PSDEMapDataQuery();
            psDEMapDataQuery.CopyTo(psDEMapDataQuery2, true);
            psDEMapDataQueryList.add(psDEMapDataQuery2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEMapDataQuerys(strPSDEMapId), psDEMapDataQueryList, PSDEMapDataQuery.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEMapDataSets(String strPSDEMapId, Vector<PSDEMapDataSet> psDEMapDataSetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
         for (PSDEMapDataSet psDEMapDataSet : psSystemStorage.getPSDEMapStorage(strPSDEMapId).psDEMapDataSetList) {
            PSDEMapDataSet psDEMapDataSet2 = new PSDEMapDataSet();
            psDEMapDataSet.CopyTo(psDEMapDataSet2, true);
            psDEMapDataSetList.add(psDEMapDataSet2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEMapDataSets(strPSDEMapId), psDEMapDataSetList, PSDEMapDataSet.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSWorkflows(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psWorkflowList, psSystemStorage.psWorkflowList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSWorkflows(strPSSystemId), psWorkflowList, PSWorkflow.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFVersions(String strPSWFId, Vector<PSWFVersion> psVersionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWorkflowStorage(strPSWFId) != null
            && this.fromList(psVersionList, psSystemStorage.getPSWorkflowStorage(strPSWFId).psWFVersionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSVersions(strPSWFId), psVersionList, PSWFVersion.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFProcesses(String strPSWFVersionId, Vector<PSWFProcess> psWFProcessList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFProcessList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFProcessList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFProcesses(strPSWFVersionId), psWFProcessList, PSWFProcess.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFLinks(String strPSWFVersionId, Vector<PSWFLink> psWFLinkList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFLinkList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFLinkList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFLinks(strPSWFVersionId), psWFLinkList, PSWFLink.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFLinkConds(String strPSWFVersionId, Vector<PSWFLinkCond> psWFLinkCondList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFLinkCondList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFLinkCondList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFLinkConds(strPSWFVersionId), psWFLinkCondList, PSWFLinkCond.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFProcParams(String strPSWFVersionId, Vector<PSWFProcParam> psWFProcParamList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFProcParamList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFProcParamList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFProcParams(strPSWFVersionId), psWFProcParamList, PSWFProcParam.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFProcSubWFs(String strPSWFVersionId, Vector<PSWFProcSubWF> psWFProcSubWFList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFProcSubWFList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFProcSubWFList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFProcSubWFs(strPSWFVersionId), psWFProcSubWFList, PSWFProcSubWF.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFProcRoles(String strPSWFVersionId, Vector<PSWFProcRole> psWFProcRoleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFProcRoleList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFProcRoleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSProcRoles(strPSWFVersionId), psWFProcRoleList, PSWFProcRole.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFLinkRoles(String strPSWFVersionId, Vector<PSWFLinkRole> psWFLinkRoleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psWFLinkRoleList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psWFLinkRoleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSLinkRoles(strPSWFVersionId), psWFLinkRoleList, PSWFLinkRole.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFDEs(String strPSDataEntityId, Vector<PSWFDE> psWFDEList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psWFDEList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psWFDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFDEs(strPSDataEntityId), psWFDEList, PSWFDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFDEsByWF(String strPSWFId, Vector<PSWFDE> psWFDEList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWorkflowStorage(strPSWFId) != null
            && this.fromList(psWFDEList, psSystemStorage.getPSWorkflowStorage(strPSWFId).psWFDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFDEsByWF(strPSWFId), psWFDEList, PSWFDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFUIActions(String strPSWFVersionId, Vector<PSDEUIAction> psDEUIActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
         && this.fromList(psDEUIActionList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psDEUIActionList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psDEUIActionList, psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId).psDEUIActionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFUIActions(strPSWFVersionId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFUIActions2(String strPSWorkflowId, Vector<PSDEUIAction> psDEUIActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSWorkflowStorage(strPSWorkflowId) != null
         && this.fromList(psDEUIActionList, psSystemStorage.getPSWorkflowStorage(strPSWorkflowId).psDEUIActionList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId) != null
            && this.fromList(psDEUIActionList, psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId).psDEUIActionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFUIActions2(strPSWorkflowId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFUIActionGroups(String strPSWFVersionId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null
         && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSWFVersionStorage(strPSWFVersionId).psDEUIActionGroupList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId) != null
            && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId).psDEUIActionGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFUIActionGroups(strPSWFVersionId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWFUIActionGroups2(String strPSWorkflowId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSWorkflowStorage(strPSWorkflowId) != null
         && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSWorkflowStorage(strPSWorkflowId).psDEUIActionGroupList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId) != null
            && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId).psDEUIActionGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWFUIActionGroups2(strPSWorkflowId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEViewBase(String strPSDEViewBaseId, PSDEViewBase psDEViewBase) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseMap.get(strPSDEViewBaseId) != null) {
         psSysAppStorage.psDEViewBaseMap.get(strPSDEViewBaseId).CopyTo(psDEViewBase, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEViewBase(strPSDEViewBaseId), psDEViewBase, "SYSTEM");
      }
   }

   @Override
   public synchronized void startLoadPSSystem(String strPSSystemId, int nLoadLevel) throws Exception {
      this.active();
      PSSystemStorage psSystemStorage = this.createPSSystemStorage(strPSSystemId, nLoadLevel);
      ArrayList<PSSystemStorage> stack = this.psSystemStorageStack.get();
      if (stack == null) {
         stack = new ArrayList<>();
         this.psSystemStorageStack.set(stack);
      }

      stack.add(0, psSystemStorage);
   }

   protected PSSystemStorage createPSSystemStorage(String strPSSystemId, int nLoadLevel) throws Exception {
      long nBeginTime = System.currentTimeMillis();
      PSSystemStorage psSystemStorage = new PSSystemStorage();
      psSystemStorage.strPSSystemId = strPSSystemId;
      psSystemStorage.nLoadLevel = nLoadLevel;
      PSSysModelCache psSysModelCache = this.getPSSysModelCache("SYS:" + strPSSystemId);
      PSSystem psSystem = new PSSystem();
      CallResult callResult = this.getPSSystem(strPSSystemId, psSystem);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询系统发生错误，%1$s", callResult.getErrorInfo()));
      }

      if (psSystem.getCREATEDATE() != null) {
         String strModelCacheTag = DateHelper.toDateTimeString(psSystem.getCREATEDATE());
         if (!StringHelper.IsNullOrEmpty(psSysModelCache.getCacheTag()) && StringHelper.Compare(psSysModelCache.getCacheTag(), strModelCacheTag, false) != 0) {
            this.resetCache();
            psSysModelCache = this.getPSSysModelCache("SYS:" + strPSSystemId);
         }

         psSysModelCache.setCacheTag(strModelCacheTag);
      } else {
         log.warn(StringHelper.Format("系统[%1$s]建立时间为空", strPSSystemId));
      }

      HashMap<String, PSSysModelLog> psSysModelLogMap = new HashMap<>();
      Vector<PSSysModelLog> psSysModelLogList = new Vector<>();
      CallResult callResultx = this.getPSSysModelLogs(strPSSystemId, psSysModelLogList);
      if (callResultx.isError()) {
         throw new Exception(StringHelper.Format("查询系统模型日志发生错误，%1$s", callResultx.getErrorInfo()));
      }

      for (PSSysModelLog psSysModelLog : psSysModelLogList) {
         if (!psSysModelLogMap.containsKey(psSysModelLog.getPSSYSMODELLOGNAME())) {
            psSysModelLogMap.put(psSysModelLog.getPSSYSMODELLOGNAME(), psSysModelLog);
         }
      }

      PSSysModelLog psCodeListLog = psSysModelLogMap.get("PSCODELIST");
      Vector<PSCodeList> psCodeListList = psSysModelCache.getModelList("PSCODELIST", psCodeListLog);
      if (psCodeListList == null) {
         psCodeListList = new Vector<>();
         CallResult callResultxx = this.getAllPSCodeLists2(strPSSystemId, psCodeListList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有代码表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSCODELIST", psCodeListLog, psCodeListList);
      }

      psSystemStorage.psCodeListList.addAll(psCodeListList);

      for (PSCodeList psCodeList : psCodeListList) {
         psSystemStorage.psCodeListMap.put(psCodeList.getPSCODELISTID(), psCodeList);
         psSystemStorage.getPSCodeListStorage(psCodeList.getPSCODELISTID()).psCodeList = psCodeList;
      }

      PSSysModelLog psCodeItemLog = psSysModelLogMap.get("PSCODEITEM");
      Vector<PSCodeItem> psCodeItemList = psSysModelCache.getModelList("PSCODEITEM", psCodeListLog, psCodeItemLog);
      if (psCodeItemList == null) {
         psCodeItemList = new Vector<>();
         CallResult callResultxx = this.getPSCodeItemsBySystem(strPSSystemId, psCodeItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有代码项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSCODEITEM", psCodeListLog, psCodeItemLog, psCodeItemList);
      }

      for (PSCodeItem psCodeItem : psCodeItemList) {
         psSystemStorage.getPSCodeListStorage(psCodeItem.getPSCODELISTID()).psCodeItemList.add(psCodeItem);
      }

      if (this.getModelInstVer() >= 697) {
         PSSysModelLog psThresholdGroupLog = psSysModelLogMap.get("PSTHRESHOLDGROUP");
         Vector<PSThresholdGroup> psThresholdGroupList = psSysModelCache.getModelList("PSTHRESHOLDGROUP", psThresholdGroupLog);
         if (psThresholdGroupList == null) {
            psThresholdGroupList = new Vector<>();
            CallResult callResultxx = this.getAllPSThresholdGroups2(strPSSystemId, psThresholdGroupList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有阈值组发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSTHRESHOLDGROUP", psThresholdGroupLog, psThresholdGroupList);
         }

         psSystemStorage.psThresholdGroupList.addAll(psThresholdGroupList);

         for (PSThresholdGroup psThresholdGroup : psThresholdGroupList) {
            psSystemStorage.psThresholdGroupMap.put(psThresholdGroup.getPSTHRESHOLDGROUPID(), psThresholdGroup);
            psSystemStorage.getPSThresholdGroupStorage(psThresholdGroup.getPSTHRESHOLDGROUPID()).psThresholdGroup = psThresholdGroup;
         }

         PSSysModelLog psThresholdLog = psSysModelLogMap.get("PSTHRESHOLD");
         Vector<PSThreshold> psThresholdList = psSysModelCache.getModelList("PSTHRESHOLD", psThresholdGroupLog, psThresholdLog);
         if (psThresholdList == null) {
            psThresholdList = new Vector<>();
            CallResult callResultxx = this.getPSThresholdsBySystem(strPSSystemId, psThresholdList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有阈值项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSTHRESHOLD", psThresholdGroupLog, psThresholdLog, psThresholdList);
         }

         for (PSThreshold psThreshold : psThresholdList) {
            psSystemStorage.getPSThresholdGroupStorage(psThreshold.getPSTHRESHOLDGROUPID()).psThresholdList.add(psThreshold);
         }
      }

      if (this.getModelInstVer() >= 697) {
         PSSysModelLog psSysChartThemeLog = psSysModelLogMap.get("PSSYSCHARTTHEME");
         Vector<PSSysChartTheme> psSysChartThemeList = psSysModelCache.getModelList("PSSYSCHARTTHEME", psSysChartThemeLog);
         if (psSysChartThemeList == null) {
            psSysChartThemeList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysChartThemes2(strPSSystemId, psSysChartThemeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有图表主题发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSCHARTTHEME", psSysChartThemeLog, psSysChartThemeList);
         }

         psSystemStorage.psSysChartThemeList.addAll(psSysChartThemeList);

         for (PSSysChartTheme psSysChartTheme : psSysChartThemeList) {
            psSystemStorage.psSysChartThemeMap.put(psSysChartTheme.getPSSYSCHARTTHEMEID(), psSysChartTheme);
         }
      }

      PSSysModelLog psSysImageLog = psSysModelLogMap.get("PSSYSIMAGE");
      Vector<PSSysImage> psSysImageList = psSysModelCache.getModelList("PSSYSIMAGE", psSysImageLog);
      if (psSysImageList == null) {
         psSysImageList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysImages2(strPSSystemId, psSysImageList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有图片资源发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSIMAGE", psSysImageLog, psSysImageList);
      }

      psSystemStorage.psSysImageList.addAll(psSysImageList);

      for (PSSysImage psSysImage : psSysImageList) {
         psSystemStorage.psSysImageMap.put(psSysImage.getPSSYSIMAGEID(), psSysImage);
      }

      PSSysModelLog psSysCssLog = psSysModelLogMap.get("PSSYSCSS");
      Vector<PSSysCss> psSysCssList = psSysModelCache.getModelList("PSSYSCSS", psSysCssLog);
      if (psSysCssList == null) {
         psSysCssList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysCsses2(strPSSystemId, psSysCssList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有样式表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSCSS", psSysCssLog, psSysCssList);
      }

      psSystemStorage.psSysCssList.addAll(psSysCssList);

      for (PSSysCss psSysCss : psSysCssList) {
         psSystemStorage.psSysCssMap.put(psSysCss.getPSSYSCSSID(), psSysCss);
      }

      PSSysModelLog psSysCounterLog = psSysModelLogMap.get("PSSYSCOUNTER");
      Vector<PSSysCounter> psSysCounterList = psSysModelCache.getModelList("PSSYSCOUNTER", psSysCounterLog);
      if (psSysCounterList == null) {
         psSysCounterList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysCounters2(strPSSystemId, psSysCounterList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有计数器发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSCOUNTER", psSysCounterLog, psSysCounterList);
      }

      psSystemStorage.psSysCounterList.addAll(psSysCounterList);

      for (PSSysCounter psSysCounter : psSysCounterList) {
         psSystemStorage.psSysCounterMap.put(psSysCounter.getPSSYSCOUNTERID(), psSysCounter);
      }

      PSSysModelLog psCtrlMsgLog = psSysModelLogMap.get("PSCTRLMSG");
      Vector<PSCtrlMsg> psCtrlMsgList = psSysModelCache.getModelList("PSCTRLMSG", psCtrlMsgLog);
      if (psCtrlMsgList == null) {
         psCtrlMsgList = new Vector<>();
         CallResult callResultxx = this.getAllPSCtrlMsgs2(strPSSystemId, psCtrlMsgList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有部件消息发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSCTRLMSG", psCtrlMsgLog, psCtrlMsgList);
      }

      psSystemStorage.psCtrlMsgList.addAll(psCtrlMsgList);

      for (PSCtrlMsg psCtrlMsg : psCtrlMsgList) {
         psSystemStorage.psCtrlMsgMap.put(psCtrlMsg.getPSCTRLMSGID(), psCtrlMsg);
         PSCtrlMsgStorage psCtrlMsgStorage = psSystemStorage.getPSCtrlMsgStorage(psCtrlMsg.getPSCTRLMSGID());
         psCtrlMsgStorage.psCtrlMsg = psCtrlMsg;
      }

      PSSysModelLog psSysModelLog2 = psSysModelLogMap.get("PSCTRLMSGITEM");
      Vector<PSCtrlMsgItem> psCtrlMsgItemList = psSysModelCache.getModelList("PSCTRLMSGITEM", psCtrlMsgLog, psSysModelLog2);
      if (psCtrlMsgItemList == null) {
         psCtrlMsgItemList = new Vector<>();
         CallResult callResultxx = this.getPSCtrlMsgItemsBySystem(strPSSystemId, psCtrlMsgItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有部件消息项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSCTRLMSGITEM", psCtrlMsgLog, psSysModelLog2, psCtrlMsgItemList);
      }

      for (PSCtrlMsgItem psCtrlMsgItem : psCtrlMsgItemList) {
         PSCtrlMsgStorage psCtrlMsgStorage = psSystemStorage.getPSCtrlMsgStorage(psCtrlMsgItem.getPSCTRLMSGID());
         psCtrlMsgStorage.psCtrlMsgItemList.add(psCtrlMsgItem);
      }

      if (this.getModelInstVer() >= 353) {
         PSSysModelLog psDEActionTemplLog = psSysModelLogMap.get("PSDEACTIONTEMPL");
         Vector<PSDEActionTempl> psDEActionTemplList = psSysModelCache.getModelList("PSDEACTIONTEMPL", psDEActionTemplLog);
         if (psDEActionTemplList == null) {
            psDEActionTemplList = new Vector<>();
            CallResult callResultxx = this.getAllPSDEActionTempls2(strPSSystemId, psDEActionTemplList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体行为模板发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEACTIONTEMPL", psDEActionTemplLog, psDEActionTemplList);
         }

         psSystemStorage.psDEActionTemplList.addAll(psDEActionTemplList);

         for (PSDEActionTempl psDEActionTempl : psDEActionTemplList) {
            psSystemStorage.psDEActionTemplMap.put(psDEActionTempl.getPSDEACTIONTEMPLID(), psDEActionTempl);
         }
      }

      PSSysModelLog psSysDEFTypeLog = psSysModelLogMap.get("PSSYSDEFTYPE");
      Vector<PSSysDEFType> psSysDEFTypeList = psSysModelCache.getModelList("PSSYSDEFTYPE", psSysDEFTypeLog);
      if (psSysDEFTypeList == null) {
         psSysDEFTypeList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDEFTypes2(strPSSystemId, psSysDEFTypeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统属性类型发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDEFTYPE", psSysDEFTypeLog, psSysDEFTypeList);
      }

      psSystemStorage.psSysDEFTypeList.addAll(psSysDEFTypeList);

      for (PSSysDEFType psSysDEFType : psSysDEFTypeList) {
         psSystemStorage.psSysDEFTypeMap.put(psSysDEFType.getPSSYSDEFTYPEID(), psSysDEFType);
      }

      PSSysModelLog psSysLogicLog = psSysModelLogMap.get("PSSYSDELOGICNODE");
      Vector<PSSysLogic> psSysLogicList = psSysModelCache.getModelList("PSSYSDELOGICNODE", psSysLogicLog);
      if (psSysLogicList == null) {
         psSysLogicList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysLogics2(strPSSystemId, psSysLogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDELOGICNODE", psSysLogicLog, psSysLogicList);
      }

      psSystemStorage.psSysLogicList.addAll(psSysLogicList);

      for (PSSysLogic psSysLogic : psSysLogicList) {
         psSystemStorage.psSysLogicMap.put(psSysLogic.getPSSYSDELOGICNODEID(), psSysLogic);
      }

      PSSysModelLog psSysUnitLog = psSysModelLogMap.get("PSSYSUNIT");
      Vector<PSSysUnit> psSysUnitList = psSysModelCache.getModelList("PSSYSUNIT", psSysUnitLog);
      if (psSysUnitList == null) {
         psSysUnitList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUnits2(strPSSystemId, psSysUnitList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统单位发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUNIT", psSysUnitLog, psSysUnitList);
      }

      psSystemStorage.psSysUnitList.addAll(psSysUnitList);

      for (PSSysUnit psSysUnit : psSysUnitList) {
         psSystemStorage.psSysUnitMap.put(psSysUnit.getPSSYSUNITID(), psSysUnit);
      }

      PSSysModelLog psSysFileLog = psSysModelLogMap.get("PSSYSFILE");
      Vector<PSSysFile> psSysFileList = psSysModelCache.getModelList("PSSYSFILE", psSysFileLog);
      if (psSysFileList == null) {
         psSysFileList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysFiles2(strPSSystemId, psSysFileList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统文件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSFILE", psSysFileLog, psSysFileList);
      }

      psSystemStorage.psSysFileList.addAll(psSysFileList);

      for (PSSysFile psSysFile : psSysFileList) {
         psSystemStorage.psSysFileMap.put(psSysFile.getPSSYSFILEID(), psSysFile);
      }

      PSSysModelLog psSysModelLog = psSysModelLogMap.get("PSAPPLAN");
      Vector<PSAppLan> psSysLanList = psSysModelCache.getModelList("PSAPPLAN:SYS", psSysModelLog);
      if (psSysLanList == null) {
         psSysLanList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysLans2(strPSSystemId, psSysLanList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有应用语言发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPLAN:SYS", psSysModelLog, psSysLanList);
      }

      psSystemStorage.psSysLanList.addAll(psSysLanList);
      PSSysModelLog psLanguageResLog = psSysModelLogMap.get("PSLANGUAGERES");
      Vector<PSLanguageRes> psLanguageResList = psSysModelCache.getModelList("PSLANGUAGERES", psLanguageResLog);
      if (psLanguageResList == null) {
         psLanguageResList = new Vector<>();
         CallResult callResultxx = this.getAllPSLanguageReses2(strPSSystemId, psLanguageResList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统语言资源发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSLANGUAGERES", psLanguageResLog, psLanguageResList);
      }

      psSystemStorage.psLanguageResList.addAll(psLanguageResList);

      for (PSLanguageRes psLanguageRes : psLanguageResList) {
         psSystemStorage.psLanguageResMap.put(psLanguageRes.getPSLANGUAGERESID(), psLanguageRes);
      }

      PSSysModelLog psLanguageItemLog = psSysModelLogMap.get("PSLANGUAGEITEM");
      Vector<PSLanguageItem> psLanguageItemList = psSysModelCache.getModelList("PSLANGUAGEITEM", psLanguageItemLog);
      if (psLanguageItemList == null) {
         psLanguageItemList = new Vector<>();
         CallResult callResultxx = this.getAllPSLanguageItems2(strPSSystemId, psLanguageItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有语言资源项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSLANGUAGEITEM", psLanguageItemLog, psLanguageItemList);
      }

      psSystemStorage.psLanguageItemList.addAll(psLanguageItemList);

      for (PSLanguageItem psLanguageItem : psLanguageItemList) {
         psSystemStorage.psLanguageItemMap.put(psLanguageItem.getPSLANGUAGEITEMID(), psLanguageItem);
      }

      PSSysModelLog psSubViewTypeLog = psSysModelLogMap.get("PSSUBVIEWTYPE");
      Vector<PSSubViewType> psSubViewTypeList = psSysModelCache.getModelList("PSSUBVIEWTYPE", psSubViewTypeLog);
      if (psSubViewTypeList == null) {
         psSubViewTypeList = new Vector<>();
         CallResult callResultxx = this.getAllPSSubViewTypes2(strPSSystemId, psSubViewTypeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图子类型发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSUBVIEWTYPE", psSubViewTypeLog, psSubViewTypeList);
      }

      psSystemStorage.psSubViewTypeList.addAll(psSubViewTypeList);

      for (PSSubViewType psSubViewType : psSubViewTypeList) {
         psSystemStorage.psSubViewTypeMap.put(psSubViewType.getPSSUBVIEWTYPEID(), psSubViewType);
      }

      PSSysModelLog psSysValueRuleLog = psSysModelLogMap.get("PSSYSVALUERULE");
      Vector<PSSysValueRule> psSysValueRuleList = psSysModelCache.getModelList("PSSYSVALUERULE", psSysValueRuleLog);
      if (psSysValueRuleList == null) {
         psSysValueRuleList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysValueRules2(strPSSystemId, psSysValueRuleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有值规则发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSVALUERULE", psSysValueRuleLog, psSysValueRuleList);
      }

      psSystemStorage.psSysValueRuleList.addAll(psSysValueRuleList);

      for (PSSysValueRule psSysValueRule : psSysValueRuleList) {
         psSystemStorage.psSysValueRuleMap.put(psSysValueRule.getPSSYSVALUERULEID(), psSysValueRule);
      }

      PSSysModelLog psSysPortletLog = psSysModelLogMap.get("PSSYSPORTLET");
      Vector<PSSysPortlet> psSysPortletList = psSysModelCache.getModelList("PSSYSPORTLET", psSysPortletLog);
      if (psSysPortletList == null) {
         psSysPortletList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysPortlets2(strPSSystemId, psSysPortletList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有门户部件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSPORTLET", psSysPortletLog, psSysPortletList);
      }

      psSystemStorage.psSysPortletList.addAll(psSysPortletList);

      for (PSSysPortlet psSysPortlet : psSysPortletList) {
         psSystemStorage.psSysPortletMap.put(psSysPortlet.getPSSYSPORTLETID(), psSysPortlet);
      }

      PSSysModelLog psSysDictCatLog = psSysModelLogMap.get("PSSYSDICTCAT");
      Vector<PSSysDictCat> psSysDictCatList = psSysModelCache.getModelList("PSSYSDICTCAT", psSysDictCatLog);
      if (psSysDictCatList == null) {
         psSysDictCatList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDictCats2(strPSSystemId, psSysDictCatList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有词典分类发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDICTCAT", psSysDictCatLog, psSysDictCatList);
      }

      psSystemStorage.psSysDictCatList.addAll(psSysDictCatList);

      for (PSSysDictCat psSysDictCat : psSysDictCatList) {
         psSystemStorage.psSysDictCatMap.put(psSysDictCat.getPSSYSDICTCATID(), psSysDictCat);
      }

      if (this.getModelInstVer() >= 630) {
         PSSysModelLog psSysPortletCatLog = psSysModelLogMap.get("PSSYSPORTLETCAT");
         Vector<PSSysPortletCat> psSysPortletCatList = psSysModelCache.getModelList("PSSYSPORTLETCAT", psSysPortletCatLog);
         if (psSysPortletCatList == null) {
            psSysPortletCatList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysPortletCats2(strPSSystemId, psSysPortletCatList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有门户部件分类发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSPORTLETCAT", psSysPortletCatLog, psSysPortletCatList);
         }

         psSystemStorage.psSysPortletCatList.addAll(psSysPortletCatList);

         for (PSSysPortletCat psSysPortletCat : psSysPortletCatList) {
            psSystemStorage.psSysPortletCatMap.put(psSysPortletCat.getPSSYSPORTLETCATID(), psSysPortletCat);
         }
      }

      PSSysModelLog psSysEditorStyleLog = psSysModelLogMap.get("PSSYSEDITORSTYLE");
      Vector<PSSysEditorStyle> psSysEditorStyleList = psSysModelCache.getModelList("PSSYSEDITORSTYLE", psSysEditorStyleLog);
      if (psSysEditorStyleList == null) {
         psSysEditorStyleList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysEditorStyles2(strPSSystemId, psSysEditorStyleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有编辑器样式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSEDITORSTYLE", psSysEditorStyleLog, psSysEditorStyleList);
      }

      psSystemStorage.psSysEditorStyleList.addAll(psSysEditorStyleList);

      for (PSSysEditorStyle psSysEditorStyle : psSysEditorStyleList) {
         psSystemStorage.psSysEditorStyleMap.put(psSysEditorStyle.getPSSYSEDITORSTYLEID(), psSysEditorStyle);
      }

      PSSysModelLog psSysModelLogx = psSysModelLogMap.get("PSSYSPFPLUGIN");
      Vector<PSSysPFPlugin> psSysPFPluginList = psSysModelCache.getModelList("PSSYSPFPLUGIN", psSysModelLogx);
      if (psSysPFPluginList == null) {
         psSysPFPluginList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysPFPlugins2(strPSSystemId, psSysPFPluginList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有应用插件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSPFPLUGIN", psSysModelLogx, psSysPFPluginList);
      }

      psSystemStorage.psSysPFPluginList.addAll(psSysPFPluginList);

      for (PSSysPFPlugin psSysPFPlugin : psSysPFPluginList) {
         psSystemStorage.psSysPFPluginMap.put(psSysPFPlugin.getPSSYSPFPLUGINID(), psSysPFPlugin);
      }

      PSSysModelLog psSysModelLogxx = psSysModelLogMap.get("PSSYSPFPITEMPL");
      Vector<PSSysPFPluginTempl> psSysPFPluginTemplList = psSysModelCache.getModelList("PSSYSPFPITEMPL", psSysModelLogxx);
      if (psSysPFPluginTemplList == null) {
         psSysPFPluginTemplList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysPFPluginTempls2(strPSSystemId, psSysPFPluginTemplList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有应用插件模板发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSPFPITEMPL", psSysModelLogxx, psSysPFPluginTemplList);
      }

      psSystemStorage.psSysPFPluginTemplList.addAll(psSysPFPluginTemplList);

      for (PSSysPFPluginTempl psSysPFPluginTempl : psSysPFPluginTemplList) {
         psSystemStorage.psSysPFPluginTemplMap.put(psSysPFPluginTempl.getPSSYSPFPLUGINID(), psSysPFPluginTempl);
      }

      PSSysModelLog psSysModelLogxxx = psSysModelLogMap.get("PSSYSSFPLUGIN");
      Vector<PSSysSFPlugin> psSysSFPluginList = psSysModelCache.getModelList("PSSYSSFPLUGIN", psSysModelLogxxx);
      if (psSysSFPluginList == null) {
         psSysSFPluginList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysSFPlugins2(strPSSystemId, psSysSFPluginList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有服务插件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSFPLUGIN", psSysModelLogxxx, psSysSFPluginList);
      }

      psSystemStorage.psSysSFPluginList.addAll(psSysSFPluginList);

      for (PSSysSFPlugin psSysSFPlugin : psSysSFPluginList) {
         psSystemStorage.psSysSFPluginMap.put(psSysSFPlugin.getPSSYSSFPLUGINID(), psSysSFPlugin);
      }

      PSSysModelLog psSysModelLogxxxx = psSysModelLogMap.get("PSSYSSFPITEMPL");
      Vector<PSSysSFPluginTempl> psSysSFPluginTemplList = psSysModelCache.getModelList("PSSYSSFPITEMPL", psSysModelLogxxxx);
      if (psSysSFPluginTemplList == null) {
         psSysSFPluginTemplList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysSFPluginTempls2(strPSSystemId, psSysSFPluginTemplList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有服务插件模板发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSFPITEMPL", psSysModelLogxxxx, psSysSFPluginTemplList);
      }

      psSystemStorage.psSysSFPluginTemplList.addAll(psSysSFPluginTemplList);

      for (PSSysSFPluginTempl psSysSFPluginTempl : psSysSFPluginTemplList) {
         psSystemStorage.psSysSFPluginTemplMap.put(psSysSFPluginTempl.getPSSYSSFPLUGINID(), psSysSFPluginTempl);
      }

      PSSysModelLog psSysModelLogxxxxx = psSysModelLogMap.get("PSSYSUNIRES");
      Vector<PSSysUniRes> psSysUniResList = psSysModelCache.getModelList("PSSYSUNIRES", psSysModelLogxxxxx);
      if (psSysUniResList == null) {
         psSysUniResList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUniReses2(strPSSystemId, psSysUniResList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有统一资源发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUNIRES", psSysModelLogxxxxx, psSysUniResList);
      }

      psSystemStorage.psSysUniResList.addAll(psSysUniResList);

      for (PSSysUniRes psSysUniRes : psSysUniResList) {
         psSystemStorage.psSysUniResMap.put(psSysUniRes.getPSSYSUNIRESID(), psSysUniRes);
      }

      PSSysModelLog psSysModelLogxxxxxx = psSysModelLogMap.get("PSSYSOPPRIV");
      Vector<PSSysUserRole> psSysUserRoleList = psSysModelCache.getModelList("PSSYSOPPRIV", psSysModelLogxxxxxx);
      if (psSysUserRoleList == null) {
         psSysUserRoleList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUserRoles2(strPSSystemId, psSysUserRoleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有用户角色发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSOPPRIV", psSysModelLogxxxxxx, psSysUserRoleList);
      }

      psSystemStorage.psSysUserRoleList.addAll(psSysUserRoleList);

      for (PSSysUserRole psSysUserRole : psSysUserRoleList) {
         psSystemStorage.getPSSysUserRoleStorage(psSysUserRole.getPSSYSOPPRIVID()).psSysUserRole = psSysUserRole;
      }

      PSSysModelLog psSysModelLogxxxxxxx = psSysModelLogMap.get("PSSYSUSERROLERES");
      Vector<PSSysUserRoleRes> psSysUserRoleResList = psSysModelCache.getModelList("PSSYSUSERROLERES", psSysModelLogxxxxxxx);
      if (psSysUserRoleResList == null) {
         psSysUserRoleResList = new Vector<>();
         CallResult callResultxx = this.getPSSysUserRoleResesBySystem(strPSSystemId, psSysUserRoleResList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有用户角色统一资源发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUSERROLERES", psSysModelLogxxxxxxx, psSysUserRoleResList);
      }

      for (PSSysUserRoleRes psSysUserRoleRes : psSysUserRoleResList) {
         psSystemStorage.getPSSysUserRoleStorage(psSysUserRoleRes.getPSSYSOPPRIVID()).psSysUserRoleResList.add(psSysUserRoleRes);
      }

      if (this.getModelInstVer() >= 635) {
         PSSysModelLog psSysModelLogxxxxxxxx = psSysModelLogMap.get("PSSYSUSERROLEDATA");
         Vector<PSSysUserRoleData> psSysUserRoleDataList = psSysModelCache.getModelList("PSSYSUSERROLEDATA", psSysModelLogxxxxxxxx);
         if (psSysUserRoleDataList == null) {
            psSysUserRoleDataList = new Vector<>();
            CallResult callResultxx = this.getPSSysUserRoleDatasBySystem(strPSSystemId, psSysUserRoleDataList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有用户角色数据能力发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSUSERROLEDATA", psSysModelLogxxxxxxxx, psSysUserRoleDataList);
         }

         for (PSSysUserRoleData psSysUserRoleData : psSysUserRoleDataList) {
            psSystemStorage.getPSSysUserRoleStorage(psSysUserRoleData.getPSSYSOPPRIVID()).psSysUserRoleDataList.add(psSysUserRoleData);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxx = psSysModelLogMap.get("PSSYSMSGTEMPL");
      Vector<PSSysMsgTempl> psSysMsgTemplList = psSysModelCache.getModelList("PSSYSMSGTEMPL", psSysModelLogxxxxxxxx);
      if (psSysMsgTemplList == null) {
         psSysMsgTemplList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysMsgTempls2(strPSSystemId, psSysMsgTemplList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有消息模板发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSMSGTEMPL", psSysModelLogxxxxxxxx, psSysMsgTemplList);
      }

      psSystemStorage.psSysMsgTemplList.addAll(psSysMsgTemplList);

      for (PSSysMsgTempl psSysMsgTempl : psSysMsgTemplList) {
         psSystemStorage.psSysMsgTemplMap.put(psSysMsgTempl.getPSSYSMSGTEMPLID(), psSysMsgTempl);
      }

      PSSysModelLog psSysModelLogxxxxxxxxx = psSysModelLogMap.get("PSVIEWMSG");
      Vector<PSViewMsg> psViewMsgList = psSysModelCache.getModelList("PSVIEWMSG", psSysModelLogxxxxxxxxx);
      if (psViewMsgList == null) {
         psViewMsgList = new Vector<>();
         CallResult callResultxx = this.getAllPSViewMsgs2(strPSSystemId, psViewMsgList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图消息发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSVIEWMSG", psSysModelLogxxxxxxxxx, psViewMsgList);
      }

      psSystemStorage.psViewMsgList.addAll(psViewMsgList);

      for (PSViewMsg psViewMsg : psViewMsgList) {
         psSystemStorage.psViewMsgMap.put(psViewMsg.getPSVIEWMSGID(), psViewMsg);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxx = psSysModelLogMap.get("PSVIEWMSGGROUP");
      Vector<PSViewMsgGroup> psViewMsgGroupList = psSysModelCache.getModelList("PSVIEWMSGGROUP", psSysModelLogxxxxxxxxxx);
      if (psViewMsgGroupList == null) {
         psViewMsgGroupList = new Vector<>();
         CallResult callResultxx = this.getAllPSViewMsgGroups2(strPSSystemId, psViewMsgGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图消息组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSVIEWMSGGROUP", psSysModelLogxxxxxxxxxx, psViewMsgGroupList);
      }

      psSystemStorage.psViewMsgGroupList.addAll(psViewMsgGroupList);

      for (PSViewMsgGroup psViewMsgGroup : psViewMsgGroupList) {
         psSystemStorage.psViewMsgGroupMap.put(psViewMsgGroup.getPSVIEWMSGGROUPID(), psViewMsgGroup);
      }

      PSSysModelLog psSysModelLog2x = psSysModelLogMap.get("PSVIEWMSGGRPDETAIL");
      Vector<PSViewMsgGroupDetail> psViewMsgGroupDetailList = psSysModelCache.getModelList("PSVIEWMSGGRPDETAIL", psSysModelLogxxxxxxxxxx, psSysModelLog2x);
      if (psViewMsgGroupDetailList == null) {
         psViewMsgGroupDetailList = new Vector<>();
         CallResult callResultxx = this.getPSViewMsgGroupDetailsBySystem(strPSSystemId, psViewMsgGroupDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图消息组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSVIEWMSGGRPDETAIL", psSysModelLogxxxxxxxxxx, psSysModelLog2x, psViewMsgGroupDetailList);
      }

      for (PSViewMsgGroupDetail psViewMsgGroupDetail : psViewMsgGroupDetailList) {
         psSystemStorage.getPSViewMsgGroupStorage(psViewMsgGroupDetail.getPSVIEWMSGGROUPID()).psViewMsgGroupDetailList.add(psViewMsgGroupDetail);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSFPUB");
      Vector<PSSysSFPub> psSysSFPubList = psSysModelCache.getModelList("PSSYSSFPUB", psSysModelLogxxxxxxxxxxx);
      if (psSysSFPubList == null) {
         psSysSFPubList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysSFPubs2(strPSSystemId, psSysSFPubList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统服务发布发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSFPUB", psSysModelLogxxxxxxxxxxx, psSysSFPubList);
      }

      psSystemStorage.psSysSFPubList.addAll(psSysSFPubList);

      for (PSSysSFPub psSysSFPub : psSysSFPubList) {
         psSystemStorage.psSysSFPubMap.put(psSysSFPub.getPSSYSSFPUBID(), psSysSFPub);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSAHANDLER");
      Vector<PSSysServiceAPIHandler> psSysServiceAPIHandlerList = psSysModelCache.getModelList("PSSYSSAHANDLER", psSysModelLogxxxxxxxxxxxx);
      if (psSysServiceAPIHandlerList == null) {
         psSysServiceAPIHandlerList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysServiceAPIHandlers2(strPSSystemId, psSysServiceAPIHandlerList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统服务API处理器发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSAHANDLER", psSysModelLogxxxxxxxxxxxx, psSysServiceAPIHandlerList);
      }

      psSystemStorage.psSysServiceAPIHandlerList.addAll(psSysServiceAPIHandlerList);

      for (PSSysServiceAPIHandler psSysServiceAPIHandler : psSysServiceAPIHandlerList) {
         psSystemStorage.getPSSysServiceAPIHandlerStorage(psSysServiceAPIHandler.getPSSYSSAHANDLERID(), true).psSysServiceAPIHandler = psSysServiceAPIHandler;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSERVICEAPI");
      Vector<PSSysServiceAPI> psSysServiceAPIList = psSysModelCache.getModelList("PSSYSSERVICEAPI", psSysModelLogxxxxxxxxxxxxx);
      if (psSysServiceAPIList == null) {
         psSysServiceAPIList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysServiceAPIs2(strPSSystemId, psSysServiceAPIList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统服务API发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSERVICEAPI", psSysModelLogxxxxxxxxxxxxx, psSysServiceAPIList);
      }

      psSystemStorage.psSysServiceAPIList.addAll(psSysServiceAPIList);

      for (PSSysServiceAPI psSysServiceAPI : psSysServiceAPIList) {
         psSystemStorage.getPSSysServiceAPIStorage(psSysServiceAPI.getPSSYSSERVICEAPIID(), true).psSysServiceAPI = psSysServiceAPI;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSUBSYSSERVICEAPI");
      Vector<PSSubSysServiceAPI> psSubSysServiceAPIList = psSysModelCache.getModelList("PSSUBSYSSERVICEAPI", psSysModelLogxxxxxxxxxxxxxx);
      if (psSubSysServiceAPIList == null) {
         psSubSysServiceAPIList = new Vector<>();
         CallResult callResultxx = this.getAllPSSubSysServiceAPIs2(strPSSystemId, psSubSysServiceAPIList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询子系统服务API发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSUBSYSSERVICEAPI", psSysModelLogxxxxxxxxxxxxxx, psSubSysServiceAPIList);
      }

      psSystemStorage.psSubSysServiceAPIList.addAll(psSubSysServiceAPIList);

      for (PSSubSysServiceAPI psSubSysServiceAPI : psSubSysServiceAPIList) {
         psSystemStorage.getPSSubSysServiceAPIStorage(psSubSysServiceAPI.getPSSUBSYSSERVICEAPIID(), true).psSubSysServiceAPI = psSubSysServiceAPI;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSUBSYSSADETAIL");
      Vector<PSSubSysSADetail> psSubSysSADetailList = psSysModelCache.getModelList("PSSUBSYSSADETAIL", psSysModelLogxxxxxxxxxxxxxxx);
      if (psSubSysSADetailList == null) {
         psSubSysSADetailList = new Vector<>();
         CallResult callResultxx = this.getPSSubSysSADetailsBySystem(strPSSystemId, psSubSysSADetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有子系统接口成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSUBSYSSADETAIL", psSysModelLogxxxxxxxxxxxxxxx, psSubSysSADetailList);
      }

      for (PSSubSysSADetail psSubSysSADetail : psSubSysSADetailList) {
         PSSubSysServiceAPIStorage psSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(psSubSysSADetail.getPSSUBSYSSERVICEAPIID(), false);
         if (psSubSysServiceAPIStorage != null) {
            psSubSysServiceAPIStorage.psSubSysSADetailList.add(psSubSysSADetail);
         }
      }

      if (this.getModelInstVer() >= Version.V19100800) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSUBSYSSADE");
         Vector<PSSubSysSADE> psSubSysSADetailListx = psSysModelCache.getModelList("PSSUBSYSSADE", psSysModelLogxxxxxxxxxxxxxxxx);
         if (psSubSysSADetailListx == null) {
            psSubSysSADetailListx = new Vector<>();
            CallResult callResultxx = this.getPSSubSysSADEsBySystem(strPSSystemId, psSubSysSADetailListx);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有子系统接口实体发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSUBSYSSADE", psSysModelLogxxxxxxxxxxxxxxxx, psSubSysSADetailListx);
         }

         for (PSSubSysSADE psSubSysSADE : psSubSysSADetailListx) {
            PSSubSysServiceAPIStorage psSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(psSubSysSADE.getPSSUBSYSSERVICEAPIID(), false);
            if (psSubSysServiceAPIStorage != null) {
               psSubSysServiceAPIStorage.psSubSysSADEList.add(psSubSysSADE);
            }

            PSSubSysSADEStorage psSubSysSADEStorage = psSystemStorage.getPSSubSysSADEStorage(psSubSysSADE.getPSSUBSYSSADEID(), true);
            if (psSubSysSADEStorage != null) {
               psSubSysSADEStorage.psSubSysSADE = psSubSysSADE;
            }
         }
      }

      if (this.getModelInstVer() >= Version.V19100800) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSUBSYSSADERS");
         Vector<PSSubSysSADERS> psSubSysSADetailListx = psSysModelCache.getModelList("PSSUBSYSSADERS", psSysModelLogxxxxxxxxxxxxxxxx);
         if (psSubSysSADetailListx == null) {
            psSubSysSADetailListx = new Vector<>();
            CallResult callResultxx = this.getPSSubSysSADERSsBySystem(strPSSystemId, psSubSysSADetailListx);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有子系统接口实体关系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSUBSYSSADERS", psSysModelLogxxxxxxxxxxxxxxxx, psSubSysSADetailListx);
         }

         for (PSSubSysSADERS psSubSysSADERS : psSubSysSADetailListx) {
            PSSubSysServiceAPIStorage psSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(psSubSysSADERS.getPSSUBSYSSERVICEAPIID(), false);
            if (psSubSysServiceAPIStorage != null) {
               psSubSysServiceAPIStorage.psSubSysSADERSList.add(psSubSysSADERS);
            }
         }
      }

      if (this.getModelInstVer() >= Version.V19100800) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSUBSYSSADEFIELD");
         Vector<PSSubSysSADEField> psSubSysSADEFieldList = psSysModelCache.getModelList("PSSUBSYSSADEFIELD", psSysModelLogxxxxxxxxxxxxxxxx);
         if (psSubSysSADEFieldList == null) {
            psSubSysSADEFieldList = new Vector<>();
            CallResult callResultxx = this.getPSSubSysSADEFieldsBySystem(strPSSystemId, psSubSysSADEFieldList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有子系统接口实体属性错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSUBSYSSADEFIELD", psSysModelLogxxxxxxxxxxxxxxxx, psSubSysSADEFieldList);
         }

         for (PSSubSysSADEField psSubSysSADEField : psSubSysSADEFieldList) {
            PSSubSysSADEStorage psSubSysSADEStorage = psSystemStorage.getPSSubSysSADEStorage(psSubSysSADEField.getPSSUBSYSSADEID(), false);
            if (psSubSysSADEStorage != null) {
               psSubSysSADEStorage.psSubSysSADEFieldList.add(psSubSysSADEField);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_STARTUP) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBACKSERVICE");
         Vector<PSSysBackService> psSysBackServiceList = psSysModelCache.getModelList("PSSYSBACKSERVICE", psSysModelLogxxxxxxxxxxxxxxxx);
         if (psSysBackServiceList == null) {
            psSysBackServiceList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysBackServices2(strPSSystemId, psSysBackServiceList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有后台作业发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSBACKSERVICE", psSysModelLogxxxxxxxxxxxxxxxx, psSysBackServiceList);
         }

         psSystemStorage.psSysBackServiceList.addAll(psSysBackServiceList);

         for (PSSysBackService psSysBackService : psSysBackServiceList) {
            psSystemStorage.psSysBackServiceMap.put(psSysBackService.getPSSYSBACKSERVICEID(), psSysBackService);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSPDTVIEW");
      Vector<PSSysPDTView> psSysPDTViewList = psSysModelCache.getModelList("PSSYSPDTVIEW", psSysModelLogxxxxxxxxxxxxxxxx);
      if (psSysPDTViewList == null) {
         psSysPDTViewList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysPDTViews2(strPSSystemId, psSysPDTViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有预置视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSPDTVIEW", psSysModelLogxxxxxxxxxxxxxxxx, psSysPDTViewList);
      }

      psSystemStorage.psSysPDTViewList.addAll(psSysPDTViewList);

      for (PSSysPDTView psSysPDTView : psSysPDTViewList) {
         psSystemStorage.psSysPDTViewMap.put(psSysPDTView.getPSSYSPDTVIEWID(), psSysPDTView);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSVIEWLOGIC");
      boolean bLoadDetail = true;
      Vector<PSSysViewLogic> psSysViewLogicList = psSysModelCache.getModelList("PSSYSVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxx);
      if (psSysViewLogicList == null) {
         psSysViewLogicList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysViewLogics2(strPSSystemId, psSysViewLogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxx, psSysViewLogicList);
      }

      psSystemStorage.psSysViewLogicList.addAll(psSysViewLogicList);

      for (PSSysViewLogic psSysViewLogic : psSysViewLogicList) {
         psSystemStorage.psSysViewLogicMap.put(psSysViewLogic.getPSSYSVIEWLOGICID(), psSysViewLogic);
         psSystemStorage.getPSSysViewLogicStorage(psSysViewLogic.getPSSYSVIEWLOGICID()).psSysViewLogic = psSysViewLogic;
      }

      Vector<PSSysViewLogicParam> psSysViewLogicParamList = psSysModelCache.getModelList("PSSYSVIEWLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxx);
      if (psSysViewLogicParamList == null) {
         psSysViewLogicParamList = new Vector<>();
         CallResult callResultxx = this.getPSSysViewLogicParamsBySystem(strPSSystemId, psSysViewLogicParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图逻辑发生参数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSVIEWLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxx, psSysViewLogicParamList);
      }

      for (PSSysViewLogicParam psSysViewLogicParam : psSysViewLogicParamList) {
         psSystemStorage.getPSSysViewLogicStorage(psSysViewLogicParam.getPSSYSVIEWLOGICID()).psSysViewLogicParamList.add(psSysViewLogicParam);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDATASYNCAGENT");
      Vector<PSSysDataSyncAgent> psSysDataSyncAgentList = psSysModelCache.getModelList("PSSYSDATASYNCAGENT", psSysModelLogxxxxxxxxxxxxxxxxxx);
      if (psSysDataSyncAgentList == null) {
         psSysDataSyncAgentList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDataSyncAgents2(strPSSystemId, psSysDataSyncAgentList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有同步代理发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDATASYNCAGENT", psSysModelLogxxxxxxxxxxxxxxxxxx, psSysDataSyncAgentList);
      }

      psSystemStorage.psSysDataSyncAgentList.addAll(psSysDataSyncAgentList);

      for (PSSysDataSyncAgent psSysDataSyncAgent : psSysDataSyncAgentList) {
         psSystemStorage.psSysDataSyncAgentMap.put(psSysDataSyncAgent.getPSSYSDATASYNCAGENTID(), psSysDataSyncAgent);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDATAENTITY");
      Vector<PSDataEntity> psDataEntityList = psSysModelCache.getModelList("PSDATAENTITY", psSysModelLogxxxxxxxxxxxxxxxxxxx);
      if (psDataEntityList == null) {
         psDataEntityList = new Vector<>();
         CallResult callResultxx = this.getAllPSDataEntities2(strPSSystemId, psDataEntityList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDATAENTITY", psSysModelLogxxxxxxxxxxxxxxxxxxx, psDataEntityList);
      }

      psSystemStorage.psDataEntityList.addAll(psDataEntityList);

      for (PSDataEntity psDataEntity : psDataEntityList) {
         psSystemStorage.psDataEntityMap.put(psDataEntity.getPSDATAENTITYID(), psDataEntity);
         psSystemStorage.psDataEntityMap.put(psDataEntity.getPSDATAENTITYNAME(), psDataEntity);
         psSystemStorage.getPSDataEntityStorage(psDataEntity.getPSDATAENTITYID()).psDataEntity = psDataEntity;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFIELD");
      Vector<PSDEField> psDEFieldList = psSysModelCache.getModelList("PSDEFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxx);
      if (psDEFieldList == null) {
         psDEFieldList = new Vector<>();
         CallResult callResultxx = this.getPSDEFieldsNoSortBySystem(strPSSystemId, psDEFieldList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxx, psDEFieldList);
      }

      for (PSDEField psDEField : psDEFieldList) {
         psSystemStorage.getPSDataEntityStorage(psDEField.getPSDEID()).psDEFieldList.add(psDEField);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEVIEWBASE");
      Vector<PSDEViewBase> psDEViewBaseList = psSysModelCache.getModelList("PSDEVIEWBASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxx);
      if (psDEViewBaseList == null) {
         psDEViewBaseList = new Vector<>();
         CallResult callResultxx = this.getPSDEViewsBySystem(strPSSystemId, psDEViewBaseList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEVIEWBASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxx, psDEViewBaseList);
      }

      for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
         if (!StringHelper.IsNullOrEmpty(psDEViewBase.getPREDEFINEVIEWTYPE())) {
            psSystemStorage.getPSDataEntityStorage(psDEViewBase.getPSDEID()).psDEPredefinedViewList.add(psDEViewBase);
         }

         psSystemStorage.getPSDataEntityStorage(psDEViewBase.getPSDEID()).psDEViewList.add(psDEViewBase);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFORM");
      Vector<PSDEForm> psDEFormList = psSysModelCache.getModelList("PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFormList == null) {
         psDEFormList = new Vector<>();
         CallResult callResultxx = this.getPSDEEditFormsBySystem(strPSSystemId, psDEFormList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有编辑表单发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxx, psDEFormList);
      }

      for (PSDEForm psDEForm : psDEFormList) {
         psSystemStorage.getPSDataEntityStorage(psDEForm.getPSDEID()).psDEEditFormList.add(psDEForm);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFFORMITEM");
      Vector<PSDEFUIMode> psDEFUIModeList = psSysModelCache.getModelList("PSDEFFORMITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFUIModeList == null) {
         psDEFUIModeList = new Vector<>();
         CallResult callResultxx = this.getPSDEFUIModesBySystem(strPSSystemId, psDEFUIModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性界面模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFFORMITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx, psDEFUIModeList);
      }

      for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
         psSystemStorage.getPSDataEntityStorage(psDEFUIMode.getParamStringValue("PSDEID", "")).psDEFUIModeList.add(psDEFUIMode);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFSFITEM");
      Vector<PSDEFSearchMode> psDEFSearchModeList = psSysModelCache.getModelList("PSDEFSFITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFSearchModeList == null) {
         psDEFSearchModeList = new Vector<>();
         CallResult callResultxx = this.getPSDEFSearchModesBySystem(strPSSystemId, psDEFSearchModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性搜索模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFSFITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx, psDEFSearchModeList);
      }

      for (PSDEFSearchMode psDEFSearchMode : psDEFSearchModeList) {
         psSystemStorage.getPSDataEntityStorage(psDEFSearchMode.getParamStringValue("PSDEID", "")).psDEFSearchModeList.add(psDEFSearchMode);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFDTCOL");
      Vector<PSDEFDTColumn> psDEFDTColumnList = psSysModelCache.getModelList("PSDEFDTCOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFDTColumnList == null) {
         psDEFDTColumnList = new Vector<>();
         CallResult callResultxx = this.getPSDEFDTColumnsBySystem(strPSSystemId, psDEFDTColumnList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性数据表格列发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFDTCOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFDTColumnList);
      }

      for (PSDEFDTColumn psDEFDTColumn : psDEFDTColumnList) {
         psSystemStorage.getPSDataEntityStorage(psDEFDTColumn.getPSDEId()).psDEFDTColumnList.add(psDEFDTColumn);
      }

      if (this.getModelInstVer() >= 611) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSEARCHDEFIELD");
         Vector<PSSysSearchDEField> psSysSearchDEFieldList = psSysModelCache.getModelList("PSSYSSEARCHDEFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysSearchDEFieldList == null) {
            psSysSearchDEFieldList = new Vector<>();
            CallResult callResultxx = this.getPSSysSearchDEFieldsBySystem(strPSSystemId, psSysSearchDEFieldList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有属性全文检索发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSSEARCHDEFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSearchDEFieldList);
         }

         for (PSSysSearchDEField psSysSearchDEField : psSysSearchDEFieldList) {
            psSystemStorage.getPSDataEntityStorage(psSysSearchDEField.getPSDEID()).psSysSearchDEFieldList.add(psSysSearchDEField);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFVALUERULE");
      Vector<PSDEFValueRule> psDEFValueRuleList = psSysModelCache.getModelList("PSDEFVALUERULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFValueRuleList == null) {
         psDEFValueRuleList = new Vector<>();
         CallResult callResultxx = this.getPSDEFValueRulesBySystem(strPSSystemId, psDEFValueRuleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性值规则发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFVALUERULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFValueRuleList);
      }

      for (PSDEFValueRule psDEFValueRule : psDEFValueRuleList) {
         psSystemStorage.getPSDataEntityStorage(psDEFValueRule.getParamStringValue("PSDEID", "")).psDEFValueRuleList.add(psDEFValueRule);
      }

      Vector<PSDEFValueRuleCond> psDEFValueRuleCondList = psSysModelCache.getModelList("PSDEFVRCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFValueRuleCondList == null) {
         psDEFValueRuleCondList = new Vector<>();
         CallResult callResultxx = this.getPSDEFValueRuleCondsBySystem(strPSSystemId, psDEFValueRuleCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性值规则条件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFVRCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFValueRuleCondList);
      }

      for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
         PSDEFValueRuleStorage psDEFValueRuleStorage = psSystemStorage.getPSDEFValueRuleStorage(psDEFValueRuleCond.getPSDEFVRID());
         psDEFValueRuleStorage.psDEFValueRuleCondList.add(psDEFValueRuleCond);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFINPUTTIP");
      Vector<PSDEFInputTip> psDEFInputTipList = psSysModelCache.getModelList("PSDEFINPUTTIP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFInputTipList == null) {
         psDEFInputTipList = new Vector<>();
         CallResult callResultxx = this.getPSDEFInputTipsBySystem2(strPSSystemId, psDEFInputTipList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性输入提示发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFINPUTTIP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFInputTipList);
      }

      for (PSDEFInputTip psDEFInputTip : psDEFInputTipList) {
         psSystemStorage.getPSDataEntityStorage(psDEFInputTip.getPSDEID()).psDEFInputTipList.add(psDEFInputTip);
      }

      Vector<PSDEFInputTip> psDEFInputTipListx = psSysModelCache.getModelList("PSDEFINPUTTIP_SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFInputTipListx == null) {
         psDEFInputTipListx = new Vector<>();
         CallResult callResultxx = this.getPSDEFInputTipsBySystem3(strPSSystemId, psDEFInputTipListx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性输入提示发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFINPUTTIP_SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFInputTipListx);
      }

      psSystemStorage.psDEFInputTipList.addAll(psDEFInputTipListx);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDER");
      Vector<PSDER> psDERList = psSysModelCache.getModelList("PSDER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDERList == null) {
         psDERList = new Vector<>();
         CallResult callResultxx = this.getAllPSDERs2(strPSSystemId, psDERList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有关系发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDERList);
      }

      psSystemStorage.psDERList.addAll(psDERList);

      for (PSDER psDER : psDERList) {
         psSystemStorage.psDERMap.put(psDER.getPSDERID(), psDER);
         psSystemStorage.getPSDataEntityStorage(psDER.getMAJORPSDEID()).psDERList.add(psDER);
         psSystemStorage.getPSDataEntityStorage(psDER.getMINORPSDEID()).psDERList2.add(psDER);
         PSDERStorage psDERStorage = psSystemStorage.getPSDERStorage(psDER.getPSDERID());
         psDERStorage.psDER = psDER;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDERDEFMAP");
      Vector<PSDERDEFMap> psDEDERDEFMapList = psSysModelCache.getModelList("PSDERDEFMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDERDEFMapList == null) {
         psDEDERDEFMapList = new Vector<>();
         CallResult callResultxx = this.getPSDERDEFMapsBySystem(strPSSystemId, psDEDERDEFMapList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体关系属性映射发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDERDEFMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDERDEFMapList);
      }

      for (PSDERDEFMap psDEDERDEFMap : psDEDERDEFMapList) {
         psSystemStorage.getPSDERStorage(psDEDERDEFMap.getPSDERID()).psDERDEFMapList.add(psDEDERDEFMap);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDBCFG");
      Vector<PSDEDBConfig> psDEDBConfigList = psSysModelCache.getModelList("PSDEDBCFG", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDBConfigList == null) {
         psDEDBConfigList = new Vector<>();
         CallResult callResultxx = this.getPSDEDBConfigsBySystem(strPSSystemId, psDEDBConfigList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据库配置集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDBCFG", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDBConfigList);
      }

      for (PSDEDBConfig psDEDBConfig : psDEDBConfigList) {
         psSystemStorage.getPSDataEntityStorage(psDEDBConfig.getPSDEID()).psDEDBConfigList.add(psDEDBConfig);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDBINDEX");
      Vector<PSDEDBIndex> psDEDBIndexList = psSysModelCache.getModelList("PSDEDBINDEX", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDBIndexList == null) {
         psDEDBIndexList = new Vector<>();
         CallResult callResultxx = this.getPSDEDBIndexsBySystem(strPSSystemId, psDEDBIndexList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据库索引集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDBINDEX", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDBIndexList);
      }

      for (PSDEDBIndex psDEDBIndex : psDEDBIndexList) {
         psSystemStorage.getPSDataEntityStorage(psDEDBIndex.getPSDEID()).psDEDBIndexList.add(psDEDBIndex);
         psSystemStorage.getPSDEDBIndexStorage(psDEDBIndex.getPSDEDBINDEXID()).psDEDBIndex = psDEDBIndex;
      }

      PSSysModelLog psSysModelLog2xx = psSysModelLogMap.get("PSDEDBIDXFIELD");
      Vector<PSDEDBIndexField> psDEDBIndexFieldList = psSysModelCache.getModelList("PSDEDBIDXFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xx);
      if (psDEDBIndexFieldList == null) {
         psDEDBIndexFieldList = new Vector<>();
         CallResult callResultxx = this.getPSDEDBIndexFieldsBySystem(strPSSystemId, psDEDBIndexFieldList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据库索引属性集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDBIDXFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xx, psDEDBIndexFieldList);
      }

      for (PSDEDBIndexField psDEDBIndexField : psDEDBIndexFieldList) {
         psSystemStorage.getPSDEDBIndexStorage(psDEDBIndexField.getPSDEDBINDEXID()).psDEDBIndexFieldList.add(psDEDBIndexField);
      }

      if (this.getModelInstVer() >= 602) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDETABLE");
         Vector<PSDEDBTable> psDEDBTableList = psSysModelCache.getModelList("PSDETABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEDBTableList == null) {
            psDEDBTableList = new Vector<>();
            CallResult callResultxx = this.getPSDEDBTablesBySystem(strPSSystemId, psDEDBTableList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体数据库集合发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDETABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDBTableList);
         }

         for (PSDEDBTable psDEDBTable : psDEDBTableList) {
            psSystemStorage.getPSDataEntityStorage(psDEDBTable.getPSDEID()).psDEDBTableList.add(psDEDBTable);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATASET");
      Vector<PSDEDataSet> psDEDataSetList = psSysModelCache.getModelList("PSDEDATASET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDataSetList == null) {
         psDEDataSetList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataSetsBySystem(strPSSystemId, psDEDataSetList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATASET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataSetList);
      }

      for (PSDEDataSet psDEDataSet : psDEDataSetList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataSet.getPSDEID()).psDEDataSetList.add(psDEDataSet);
         PSDEDataSetStorage psDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(psDEDataSet.getPSDEDATASETID());
         psDEDataSetStorage.psDEDataSet = psDEDataSet;
      }

      PSSysModelLog psSysModelLog2xxx = psSysModelLogMap.get("PSDEDSDQ");
      Vector<PSDEDSDQ> psDEDSDQList = psSysModelCache.getModelList("PSDEDSDQ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxx);
      if (psDEDSDQList == null) {
         psDEDSDQList = new Vector<>();
         CallResult callResultxx = this.getPSDEDSDQsBySystem(strPSSystemId, psDEDSDQList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDSDQ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxx, psDEDSDQList);
      }

      for (PSDEDSDQ psDEDSDQ : psDEDSDQList) {
         PSDEDataSetStorage psDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(psDEDSDQ.getPSDEDATASETID());
         psDEDataSetStorage.psDEDSDQList.add(psDEDSDQ);
      }

      Vector<PSDEDSGroupParam> psDEDSGroupParamList = psSysModelCache.getModelList("PSDEDSGRPPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDSGroupParamList == null) {
         psDEDSGroupParamList = new Vector<>();
         CallResult callResultxx = this.getPSDEDSGroupParamsBySystem(strPSSystemId, psDEDSGroupParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据分组参数集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDSGRPPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDSGroupParamList);
      }

      for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList) {
         PSDEDataSetStorage psDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(psDEDSGroupParam.getPSDEDSID());
         psDEDataSetStorage.psDEDSGroupParamList.add(psDEDSGroupParam);
      }

      if (this.getModelInstVer() >= 746) {
         Vector<PSDEDSParam> psDEDSParamList = psSysModelCache.getModelList("PSDEDSPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEDSParamList == null) {
            psDEDSParamList = new Vector<>();
            CallResult callResultxx = this.getPSDEDSParamsBySystem(strPSSystemId, psDEDSParamList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有数据集参数集合发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEDSPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDSParamList);
         }

         for (PSDEDSParam psDEDSParam : psDEDSParamList) {
            PSDEDataSetStorage psDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(psDEDSParam.getPSDEDSID());
            psDEDataSetStorage.psDEDSParamList.add(psDEDSParam);
         }
      }

      PSSysModelLog psDEDQLog = psSysModelLogMap.get("PSDEDATAQUERY");
      Vector<PSDEDataQuery> psDEDataQueryList = psSysModelCache.getModelList("PSDEDATAQUERY", psDEDQLog);
      if (psDEDataQueryList == null) {
         psDEDataQueryList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueriesBySystem(strPSSystemId, psDEDataQueryList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAQUERY", psDEDQLog, psDEDataQueryList);
      }

      for (PSDEDataQuery psDEDataQuery : psDEDataQueryList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataQuery.getPSDEID()).psDEDataQueryList.add(psDEDataQuery);
         PSDEDataQueryStorage psDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(psDEDataQuery.getPSDEDATAQUERYID());
         psDEDataQueryStorage.psDEDataQuery = psDEDataQuery;
      }

      Vector<PSDEDataQueryCond> psDEDataQueryCondList = psSysModelCache.getModelList("PSDEDQCOND", psDEDQLog);
      if (psDEDataQueryCondList == null) {
         psDEDataQueryCondList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueryCondsBySystem(strPSSystemId, psDEDataQueryCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询条件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDQCOND", psDEDQLog, psDEDataQueryCondList);
      }

      for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
         PSDEDataQueryStorage psDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(psDEDataQueryCond.getPSDEDQID());
         psDEDataQueryStorage.psDEDataQueryCondList.add(psDEDataQueryCond);
      }

      Vector<PSDEDataQueryJoin> psDEDataQueryJoinList = psSysModelCache.getModelList("PSDEDQJOIN", psDEDQLog);
      if (psDEDataQueryJoinList == null) {
         psDEDataQueryJoinList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueryJoinsBySystem(strPSSystemId, psDEDataQueryJoinList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDQJOIN", psDEDQLog, psDEDataQueryJoinList);
      }

      for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
         PSDEDataQueryStorage psDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(psDEDataQueryJoin.getPSDEDQID());
         psDEDataQueryStorage.psDEDataQueryJoinList.add(psDEDataQueryJoin);
      }

      PSSysModelLog psDEDQCodeLog = psSysModelLogMap.get("PSDEDQCODE");
      Vector<PSDEDataQueryCode> psDEDataQueryCodeList = psSysModelCache.getModelList("PSDEDQCODE", psDEDQCodeLog);
      if (psDEDataQueryCodeList == null) {
         psDEDataQueryCodeList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueryCodesBySystem(strPSSystemId, psDEDataQueryCodeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询代码发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDQCODE", psDEDQCodeLog, psDEDataQueryCodeList);
      }

      for (PSDEDataQueryCode psDEDataQueryCode : psDEDataQueryCodeList) {
         PSDEDataQueryStorage psDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(psDEDataQueryCode.getPSDEDQID());
         psDEDataQueryStorage.psDEDataQueryCodeList.add(psDEDataQueryCode);
      }

      Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList = psSysModelCache.getModelList("PSDEDQCODEEXP", psDEDQCodeLog);
      if (psDEDataQueryCodeExpList == null) {
         psDEDataQueryCodeExpList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueryCodeExpsBySystem(strPSSystemId, psDEDataQueryCodeExpList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询代码表达式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDQCODEEXP", psDEDQCodeLog, psDEDataQueryCodeExpList);
      }

      for (PSDEDataQueryCodeExp psDEDataQueryCodeExp : psDEDataQueryCodeExpList) {
         PSDEDataQueryCodeStorage psDEDataQueryCodeStorage = psSystemStorage.getPSDEDataQueryCodeStorage(psDEDataQueryCodeExp.getPSDEDQCodeId());
         psDEDataQueryCodeStorage.psDEDataQueryCodeExpList.add(psDEDataQueryCodeExp);
      }

      PSSysModelLog psDEDQCodeCondLog = psSysModelLogMap.get("PSDEDQCODECOND");
      Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList = psSysModelCache.getModelList("PSDEDQCODECOND", psDEDQCodeCondLog);
      if (psDEDataQueryCodeCondList == null) {
         psDEDataQueryCodeCondList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataQueryCodeCondsBySystem(strPSSystemId, psDEDataQueryCodeCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有数据查询代码表达式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDQCODECOND", psDEDQCodeCondLog, psDEDataQueryCodeCondList);
      }

      for (PSDEDataQueryCodeCond psDEDataQueryCodeCond : psDEDataQueryCodeCondList) {
         PSDEDataQueryCodeStorage psDEDataQueryCodeStorage = psSystemStorage.getPSDEDataQueryCodeStorage(psDEDataQueryCodeCond.getPSDEDQCODEID());
         psDEDataQueryCodeStorage.psDEDataQueryCodeCondList.add(psDEDataQueryCodeCond);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDELOGIC");
      Vector<PSDELogic> psDELogicList = psSysModelCache.getModelList("PSDELOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicList == null) {
         psDELogicList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicList);
      }

      for (PSDELogic psDELogic : psDELogicList) {
         psSystemStorage.getPSDataEntityStorage(psDELogic.getPSDEID()).psDELogicList.add(psDELogic);
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogic.getPSDELOGICID());
         psDELogicStorage.psDELogic = psDELogic;
         psSystemStorage.psDELogicList.add(psDELogic);
         psSystemStorage.psDELogicMap.put(psDELogic.getPSDELOGICID(), psDELogic);
      }

      Vector<PSDELogicParam> psDELogicParamList = psSysModelCache.getModelList("PSDELOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicParamList == null) {
         psDELogicParamList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicParamsBySystem(strPSSystemId, psDELogicParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑参数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicParamList);
      }

      for (PSDELogicParam psDELogicParam : psDELogicParamList) {
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogicParam.getPSDELOGICID());
         psDELogicStorage.psDELogicParamList.add(psDELogicParam);
      }

      Vector<PSDELogicNode> psDELogicNodeList = psSysModelCache.getModelList("PSDELOGICNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicNodeList == null) {
         psDELogicNodeList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicNodesBySystem(strPSSystemId, psDELogicNodeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑节点发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicNodeList);
      }

      for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogicNode.getPSDELOGICID());
         psDELogicStorage.psDELogicNodeList.add(psDELogicNode);
      }

      Vector<PSDELogicLink> psDELogicLinkList = psSysModelCache.getModelList("PSDELOGICLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicLinkList == null) {
         psDELogicLinkList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicLinksBySystem(strPSSystemId, psDELogicLinkList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicLinkList);
      }

      for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogicLink.getPSDELOGICID());
         psDELogicStorage.psDELogicLinkList.add(psDELogicLink);
      }

      Vector<PSDELogicNodeParam> psDELogicNodeParamList = psSysModelCache.getModelList("PSDELNPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicNodeParamList == null) {
         psDELogicNodeParamList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicNodeParamsBySystem(strPSSystemId, psDELogicNodeParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑节点参数连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELNPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicNodeParamList);
      }

      for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogicNodeParam.getPSDELOGICID());
         psDELogicStorage.psDELogicNodeParamList.add(psDELogicNodeParam);
      }

      Vector<PSDELogicLinkCond> psDELogicLinkCondList = psSysModelCache.getModelList("PSDELLCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDELogicLinkCondList == null) {
         psDELogicLinkCondList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicLinkCondsBySystem(strPSSystemId, psDELogicLinkCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑连接条件连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELLCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDELogicLinkCondList);
      }

      for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
         PSDELogicStorage psDELogicStorage = psSystemStorage.getPSDELogicStorage(psDELogicLinkCond.getPSDELOGICID());
         psDELogicStorage.psDELogicLinkCondList.add(psDELogicLinkCond);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTION");
      Vector<PSDEAction> psDEActionList = psSysModelCache.getModelList("PSDEACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEActionList == null) {
         psDEActionList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionsBySystem(strPSSystemId, psDEActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体操作发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEActionList);
      }

      for (PSDEAction psDEAction : psDEActionList) {
         psSystemStorage.getPSDataEntityStorage(psDEAction.getPSDEID()).psDEActionList.add(psDEAction);
         PSDEActionStorage psDEActionStorage = psSystemStorage.getPSDEActionStorage(psDEAction.getPSDEACTIONID());
         psDEActionStorage.psDEAction = psDEAction;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTION");
      PSSysModelLog psSysModelLog2xxxx = psSysModelLogMap.get("PSDEACTIONLOGIC");
      Vector<PSDEActionLogic> psDEActionLogicList = psSysModelCache.getModelList("PSDEACTIONLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxx);
      if (psDEActionLogicList == null) {
         psDEActionLogicList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionLogicsBySystem(strPSSystemId, psDEActionLogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体行为附加逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACTIONLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxx, psDEActionLogicList);
      }

      for (PSDEActionLogic psDEActionLogic : psDEActionLogicList) {
         PSDEActionStorage psDEActionStorage = psSystemStorage.getPSDEActionStorage(psDEActionLogic.getPSDEACTIONID());
         psDEActionStorage.psDEActionLogicList.add(psDEActionLogic);
      }

      if (this.getModelInstVer() >= 353) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTION");
         PSSysModelLog psSysModelLog2xxxxx = psSysModelLogMap.get("PSDEACTIONPARAM");
         Vector<PSDEActionParam> psDEActionParamList = psSysModelCache.getModelList("PSDEACTIONPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx);
         if (psDEActionParamList == null) {
            psDEActionParamList = new Vector<>();
            CallResult callResultxx = this.getPSDEActionParamsBySystem(strPSSystemId, psDEActionParamList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体行为参数发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEACTIONPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx, psDEActionParamList);
         }

         for (PSDEActionParam psDEActionParam : psDEActionParamList) {
            PSDEActionStorage psDEActionStorage = psSystemStorage.getPSDEActionStorage(psDEActionParam.getPSDEACTIONID());
            psDEActionStorage.psDEActionParamList.add(psDEActionParam);
         }
      }

      if (this.getModelInstVer() >= 657) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTION");
         PSSysModelLog psSysModelLog2xxxxx = psSysModelLogMap.get("PSDEACTIONVR");
         Vector<PSDEActionVR> psDEActionVRList = psSysModelCache.getModelList("PSDEACTIONVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx);
         if (psDEActionVRList == null) {
            psDEActionVRList = new Vector<>();
            CallResult callResultxx = this.getPSDEActionVRsBySystem(strPSSystemId, psDEActionVRList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体行为附加值规则发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEACTIONVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx, psDEActionVRList);
         }

         for (PSDEActionVR psDEActionVR : psDEActionVRList) {
            PSDEActionStorage psDEActionStorage = psSystemStorage.getPSDEActionStorage(psDEActionVR.getPSDEACTIONID());
            psDEActionStorage.psDEActionVRList.add(psDEActionVR);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSACHANDLER");
      Vector<PSACHandler> psACHandlerList = psSysModelCache.getModelList("PSACHANDLER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psACHandlerList == null) {
         psACHandlerList = new Vector<>();
         CallResult callResultxx = this.getPSACHandlersBySystem(strPSSystemId, psACHandlerList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体后台处理发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSACHANDLER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psACHandlerList);
      }

      for (PSACHandler psACHandler : psACHandlerList) {
         if (!StringHelper.IsNullOrEmpty(psACHandler.getPSDEID())) {
            psSystemStorage.getPSDataEntityStorage(psACHandler.getPSDEID()).psACHandlerList.add(psACHandler);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDRITEM");
      Vector<PSDEDRItem> psDEDRItemList = psSysModelCache.getModelList("PSDEDRITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDRItemList == null) {
         psDEDRItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEDRItemsBySystem(strPSSystemId, psDEDRItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体关系界面项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDRITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDRItemList);
      }

      for (PSDEDRItem psDEDRItem : psDEDRItemList) {
         if (!StringHelper.IsNullOrEmpty(psDEDRItem.getPSDEID())) {
            psSystemStorage.getPSDataEntityStorage(psDEDRItem.getPSDEID()).psDEDRItemList.add(psDEDRItem);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDRGROUP");
      Vector<PSDEDRGroup> psDEDRGroupList = psSysModelCache.getModelList("PSDEDRGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDRGroupList == null) {
         psDEDRGroupList = new Vector<>();
         CallResult callResultxx = this.getPSDEDRGroupsBySystem(strPSSystemId, psDEDRGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体关系界面分组项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDRGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDRGroupList);
      }

      for (PSDEDRGroup psDEDRGroup : psDEDRGroupList) {
         if (!StringHelper.IsNullOrEmpty(psDEDRGroup.getPSDEID())) {
            psSystemStorage.getPSDataEntityStorage(psDEDRGroup.getPSDEID()).psDEDRGroupList.add(psDEDRGroup);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEMAP");
      Vector<PSDEMap> psDEMapList = psSysModelCache.getModelList("PSDEMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEMapList == null) {
         psDEMapList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapsBySystem(strPSSystemId, psDEMapList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEMapList);
      }

      for (PSDEMap psDEMap : psDEMapList) {
         psSystemStorage.getPSDataEntityStorage(psDEMap.getPSDEID()).psDEMapList.add(psDEMap);
         PSDEMapStorage psDEMapStorage = psSystemStorage.getPSDEMapStorage(psDEMap.getPSDEMAPID());
         psDEMapStorage.psDEMap = psDEMap;
      }

      PSSysModelLog psSysModelLog2xxxxx = psSysModelLogMap.get("PSDEMAPDETAIL");
      Vector<PSDEMapDetail> psDEMapDetailList = psSysModelCache.getModelList("PSDEMAPDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx);
      if (psDEMapDetailList == null) {
         psDEMapDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDetailsBySystem(strPSSystemId, psDEMapDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxx, psDEMapDetailList);
      }

      for (PSDEMapDetail psDEMapDetail : psDEMapDetailList) {
         psSystemStorage.getPSDEMapStorage(psDEMapDetail.getPSDEMAPID()).psDEMapDetailList.add(psDEMapDetail);
      }

      PSSysModelLog psSysModelLog2xxxxxx = psSysModelLogMap.get("PSDEMAPACTION");
      Vector<PSDEMapAction> psDEMapActionList = psSysModelCache.getModelList("PSDEMAPACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxx);
      if (psDEMapActionList == null) {
         psDEMapActionList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapActionsBySystem(strPSSystemId, psDEMapActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxx, psDEMapActionList);
      }

      for (PSDEMapAction psDEMapAction : psDEMapActionList) {
         psSystemStorage.getPSDEMapStorage(psDEMapAction.getPSDEMAPID()).psDEMapActionList.add(psDEMapAction);
      }

      PSSysModelLog psSysModelLog2xxxxxxx = psSysModelLogMap.get("PSDEMAPDQ");
      Vector<PSDEMapDataQuery> psDEMapDataQueryList = psSysModelCache.getModelList("PSDEMAPDQ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxx);
      if (psDEMapDataQueryList == null) {
         psDEMapDataQueryList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDataQueriesBySystem(strPSSystemId, psDEMapDataQueryList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射查询发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDQ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxx, psDEMapDataQueryList);
      }

      for (PSDEMapDataQuery psDEMapDataQuery : psDEMapDataQueryList) {
         psSystemStorage.getPSDEMapStorage(psDEMapDataQuery.getPSDEMAPID()).psDEMapDataQueryList.add(psDEMapDataQuery);
      }

      PSSysModelLog psSysModelLog2xxxxxxxx = psSysModelLogMap.get("PSDEMAPDS");
      Vector<PSDEMapDataSet> psDEMapDataSetList = psSysModelCache.getModelList("PSDEMAPDS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxx);
      if (psDEMapDataSetList == null) {
         psDEMapDataSetList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDataSetsBySystem(strPSSystemId, psDEMapDataSetList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射数据集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxx, psDEMapDataSetList);
      }

      for (PSDEMapDataSet psDEMapDataSet : psDEMapDataSetList) {
         psSystemStorage.getPSDEMapStorage(psDEMapDataSet.getPSDEMAPID()).psDEMapDataSetList.add(psDEMapDataSet);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATARELATION");
      Vector<PSDEDataRelation> psDEDataRelationList = psSysModelCache.getModelList("PSDEDATARELATION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDataRelationList == null) {
         psDEDataRelationList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataRelationsBySystem(strPSSystemId, psDEDataRelationList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体关系界面组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATARELATION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataRelationList);
      }

      for (PSDEDataRelation psDEDataRelation : psDEDataRelationList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataRelation.getPSDEID()).psDEDataRelationList.add(psDEDataRelation);
         PSDEDataRelationStorage psDEDataRelationStorage = psSystemStorage.getPSDEDataRelationStorage(psDEDataRelation.getPSDEDATARELATIONID());
         psDEDataRelationStorage.psDEDataRelation = psDEDataRelation;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxx = psSysModelLogMap.get("PSDEDRDETAIL");
      Vector<PSDEDRDetail> psDEDRDetailList = psSysModelCache.getModelList("PSDEDRDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxx);
      if (psDEDRDetailList == null) {
         psDEDRDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEDRDetailsBySystem(strPSSystemId, psDEDRDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体关系界面组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDRDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxx, psDEDRDetailList);
      }

      for (PSDEDRDetail psDEDataRelationDetail : psDEDRDetailList) {
         psSystemStorage.getPSDEDataRelationStorage(psDEDataRelationDetail.getPSDEDRID()).psDEDRDetailList.add(psDEDataRelationDetail);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACMODE");
      Vector<PSDEACMode> psDEACModeList = psSysModelCache.getModelList("PSDEACMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEACModeList == null) {
         psDEACModeList = new Vector<>();
         CallResult callResultxx = this.getPSDEACModesBySystem(strPSSystemId, psDEACModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体自填模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEACModeList);
      }

      for (PSDEACMode psDEACMode : psDEACModeList) {
         psSystemStorage.getPSDataEntityStorage(psDEACMode.getPSDEID()).psDEACModeList.add(psDEACMode);
         PSDEACModeStorage psDEACModeStorage = psSystemStorage.getPSDEACModeStorage(psDEACMode.getPSDEACMODEID());
         psDEACModeStorage.psDEACMode = psDEACMode;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxx = psSysModelLogMap.get("PSDEACMODEITEM");
      Vector<PSDEACModeItem> psDEACModeItemList = psSysModelCache.getModelList("PSDEACMODEITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx);
      if (psDEACModeItemList == null) {
         psDEACModeItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEACModeItemsBySystem(strPSSystemId, psDEACModeItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体自填数据项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACMODEITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx, psDEACModeItemList);
      }

      for (PSDEACModeItem psDEACModeItem : psDEACModeItemList) {
         PSDEACModeStorage psDEACModeStorage = psSystemStorage.getPSDEACModeStorage(psDEACModeItem.getPSDEACMODEID());
         psDEACModeStorage.psDEACModeItemList.add(psDEACModeItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION:SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEUIActionList == null) {
         psDEUIActionList = new Vector<>();
         CallResult callResultxx = this.getPSSysDEUIActions2(strPSSystemId, psDEUIActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUIACTION:SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionList);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionList) {
         psSystemStorage.psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListx = psSysModelCache.getModelList("PSDEUIACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEUIActionListx == null) {
         psDEUIActionListx = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionListx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUIACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionListx);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListx) {
         psSystemStorage.psDEUIActionList2.add(psDEUIAction);
         psSystemStorage.getPSDataEntityStorage(psDEUIAction.getPSDEID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupList = psSysModelCache.getModelList(
         "PSDEUAGROUP:SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionGroupList == null) {
         psDEUIActionGroupList = new Vector<>();
         CallResult callResultxx = this.getPSSysDEUIActionGroups2(strPSSystemId, psDEUIActionGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有全局实体界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUAGROUP:SYS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionGroupList);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
         psSystemStorage.psDEUIActionGroupList.add(psDEUIActionGroup);
         PSDEUIActionGroupStorage psDEUIActionGroupStorage = psSystemStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
         psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListx = psSysModelCache.getModelList("PSDEUAGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEUIActionGroupListx == null) {
         psDEUIActionGroupListx = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupListx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUAGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionGroupListx);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListx) {
         psSystemStorage.getPSDataEntityStorage(psDEUIActionGroup.getPSDEID()).psDEUIActionGroupList.add(psDEUIActionGroup);
         PSDEUIActionGroupStorage psDEUIActionGroupStorage = psSystemStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
         psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSCTRLLOGICGROUP");
      Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = psSysModelCache.getModelList(
         "PSCTRLLOGICGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psCtrlLogicGroupList == null) {
         psCtrlLogicGroupList = new Vector<>();
         CallResult callResultxx = this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有界面逻辑组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSCTRLLOGICGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psCtrlLogicGroupList);
      }

      for (PSCtrlLogicGroup psCtrlLogicGroup : psCtrlLogicGroupList) {
         psSystemStorage.psCtrlLogicGroupList2.add(psCtrlLogicGroup);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFGROUP");
      Vector<PSDEFGroup> psDEFGroupList = psSysModelCache.getModelList("PSDEFGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFGroupList == null) {
         psDEFGroupList = new Vector<>();
         CallResult callResultxx = this.getPSDEFGroupsBySystem(strPSSystemId, psDEFGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体属性组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFGroupList);
      }

      for (PSDEFGroup psDEFGroup : psDEFGroupList) {
         psSystemStorage.getPSDataEntityStorage(psDEFGroup.getPSDEID()).psDEFGroupList.add(psDEFGroup);
         PSDEFGroupStorage psDEFGroupStorage = psSystemStorage.getPSDEFGroupStorage(psDEFGroup.getPSDEFGROUPID());
         psDEFGroupStorage.psDEFGroup = psDEFGroup;
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGROUP");
         Vector<PSDEGroup> psDEGroupList = psSysModelCache.getModelList("PSDEGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEGroupList == null) {
            psDEGroupList = new Vector<>();
            CallResult callResultxx = this.getPSDEGroupsBySystem(strPSSystemId, psDEGroupList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体组发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGroupList);
         }

         for (PSDEGroup psDEGroup : psDEGroupList) {
            if (!StringHelper.IsNullOrEmpty(psDEGroup.getPSDEID())) {
               psSystemStorage.getPSDataEntityStorage(psDEGroup.getPSDEID()).psDEGroupList.add(psDEGroup);
            } else {
               psSystemStorage.psDEGroupList.add(psDEGroup);
            }

            PSDEGroupStorage psDEGroupStorage = psSystemStorage.getPSDEGroupStorage(psDEGroup.getPSDEGROUPID());
            psDEGroupStorage.psDEGroup = psDEGroup;
         }
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDERGROUP");
         Vector<PSDERGroup> psDERGroupList = psSysModelCache.getModelList("PSDERGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDERGroupList == null) {
            psDERGroupList = new Vector<>();
            CallResult callResultxx = this.getPSDERGroupsBySystem(strPSSystemId, psDERGroupList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体关系组发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDERGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDERGroupList);
         }

         for (PSDERGroup psDERGroup : psDERGroupList) {
            if (!StringHelper.IsNullOrEmpty(psDERGroup.getPSDEID())) {
               psSystemStorage.getPSDataEntityStorage(psDERGroup.getPSDEID()).psDERGroupList.add(psDERGroup);
            } else {
               psSystemStorage.psDERGroupList.add(psDERGroup);
            }

            PSDERGroupStorage psDERGroupStorage = psSystemStorage.getPSDERGroupStorage(psDERGroup.getPSDERGROUPID());
            psDERGroupStorage.psDERGroup = psDERGroup;
         }
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTIONGROUP");
         Vector<PSDEActionGroup> psDEActionGroupList = psSysModelCache.getModelList(
            "PSDEACTIONGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEActionGroupList == null) {
            psDEActionGroupList = new Vector<>();
            CallResult callResultxx = this.getPSDEActionGroupsBySystem(strPSSystemId, psDEActionGroupList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体行为组发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEACTIONGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEActionGroupList);
         }

         for (PSDEActionGroup psDEActionGroup : psDEActionGroupList) {
            psSystemStorage.getPSDataEntityStorage(psDEActionGroup.getPSDEID()).psDEActionGroupList.add(psDEActionGroup);
            PSDEActionGroupStorage psDEActionGroupStorage = psSystemStorage.getPSDEActionGroupStorage(psDEActionGroup.getPSDEACTIONGROUPID());
            psDEActionGroupStorage.psDEActionGroup = psDEActionGroup;
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWFDE");
      Vector<PSWFDE> psWFDEList = psSysModelCache.getModelList("PSWFDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psWFDEList == null) {
         psWFDEList = new Vector<>();
         CallResult callResultxx = this.getPSWFDEsBySystem(strPSSystemId, psWFDEList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体工作流发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFDEList);
      }

      for (PSWFDE psWFDE : psWFDEList) {
         psSystemStorage.getPSDataEntityStorage(psWFDE.getPSDEID()).psWFDEList.add(psWFDE);
         psSystemStorage.getPSWorkflowStorage(psWFDE.getPSWFID()).psWFDEList.add(psWFDE);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUNISTATE");
      Vector<PSSysUniState> psDEUniStateList = psSysModelCache.getModelList("PSSYSUNISTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEUniStateList == null) {
         psDEUniStateList = new Vector<>();
         CallResult callResultxx = this.getPSDEUniStatesBySystem(strPSSystemId, psDEUniStateList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体统一状态发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUNISTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUniStateList);
      }

      for (PSSysUniState psDEUniState : psDEUniStateList) {
         psSystemStorage.getPSDataEntityStorage(psDEUniState.getPSDEID()).psDEUniStateList.add(psDEUniState);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDTSQUEUE");
      Vector<PSSysDTSQueue> psDEDTSQueueList = psSysModelCache.getModelList("PSDEDTSQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDTSQueueList == null) {
         psDEDTSQueueList = new Vector<>();
         CallResult callResultxx = this.getPSDEDTSQueuesBySystem(strPSSystemId, psDEDTSQueueList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体分布事务队列发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDTSQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDTSQueueList);
      }

      for (PSSysDTSQueue psDEDTSQueue : psDEDTSQueueList) {
         psSystemStorage.getPSDataEntityStorage(psDEDTSQueue.getPSDEID()).psDEDTSQueueList.add(psDEDTSQueue);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEOPPRIV");
      Vector<PSDEOPPriv> psDEOPPrivList = psSysModelCache.getModelList("PSDEOPPRIV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEOPPrivList == null) {
         psDEOPPrivList = new Vector<>();
         CallResult callResultxx = this.getPSDEOPPrivsBySystem2(strPSSystemId, psDEOPPrivList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据操作标识发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEOPPRIV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEOPPrivList);
      }

      for (PSDEOPPriv psDEOPPriv : psDEOPPrivList) {
         String strPSDEId = psDEOPPriv.getPSDEID();
         if (!StringHelper.IsNullOrEmpty(strPSDEId)) {
            psSystemStorage.getPSDataEntityStorage(psDEOPPriv.getPSDEID()).psDEOPPrivList.add(psDEOPPriv);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEMAINSTATE");
      Vector<PSDEMainState> psDEMainStateList = psSysModelCache.getModelList("PSDEMAINSTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEMainStateList == null) {
         psDEMainStateList = new Vector<>();
         CallResult callResultxx = this.getPSDEMainStatesBySystem(strPSSystemId, psDEMainStateList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体主状态发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAINSTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEMainStateList);
      }

      for (PSDEMainState psDEMainState : psDEMainStateList) {
         psSystemStorage.getPSDataEntityStorage(psDEMainState.getPSDEID()).psDEMainStateList.add(psDEMainState);
         PSDEMainStateStorage psDEMainStateStorage = psSystemStorage.getPSDEMainStateStorage(psDEMainState.getPSDEMAINSTATEID());
         psDEMainStateStorage.psDEMainState = psDEMainState;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxx = psSysModelLogMap.get("PSDEMSACTION");
      Vector<PSDEMainStateAction> psDEMainStateActionList = psSysModelCache.getModelList(
         "PSDEMSACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxx
      );
      if (psDEMainStateActionList == null) {
         psDEMainStateActionList = new Vector<>();
         CallResult callResultxx = this.getPSDEMainStateActionsBySystem(strPSSystemId, psDEMainStateActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体主状态实体行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEMSACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxx, psDEMainStateActionList
         );
      }

      for (PSDEMainStateAction psDEMainStateAction : psDEMainStateActionList) {
         psSystemStorage.getPSDEMainStateStorage(psDEMainStateAction.getPSDEMSID()).psDEMainStateActionList.add(psDEMainStateAction);
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxx = psSysModelLogMap.get("PSDEMSOPPRIV");
      Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList = psSysModelCache.getModelList(
         "PSDEMSOPPRIV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxx
      );
      if (psDEMainStateOPPrivList == null) {
         psDEMainStateOPPrivList = new Vector<>();
         CallResult callResultxx = this.getPSDEMainStateOPPrivsBySystem(strPSSystemId, psDEMainStateOPPrivList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体主状态实体操作标识发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEMSOPPRIV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxx, psDEMainStateOPPrivList
         );
      }

      for (PSDEMainStateOPPriv psDEMainStateOPPriv : psDEMainStateOPPrivList) {
         psSystemStorage.getPSDEMainStateStorage(psDEMainStateOPPriv.getPSDEMAINSTATEID()).psDEMainStateOPPrivList.add(psDEMainStateOPPriv);
      }

      if (this.getModelInstVer() >= 659) {
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxx = psSysModelLogMap.get("PSDEMSFIELD");
         Vector<PSDEMainStateField> psDEMainStateFieldList = psSysModelCache.getModelList(
            "PSDEMSFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxx
         );
         if (psDEMainStateFieldList == null) {
            psDEMainStateFieldList = new Vector<>();
            CallResult callResultxx = this.getPSDEMainStateFieldsBySystem(strPSSystemId, psDEMainStateFieldList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体主状态实体属性发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEMSFIELD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxx, psDEMainStateFieldList
            );
         }

         for (PSDEMainStateField psDEMainStateField : psDEMainStateFieldList) {
            psSystemStorage.getPSDEMainStateStorage(psDEMainStateField.getPSDEMSID()).psDEMainStateFieldList.add(psDEMainStateField);
         }
      }

      if (this.getModelInstVer() >= 691) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEMAINSTATERS");
         Vector<PSDEMainStateRS> psDEMainStateRSList = psSysModelCache.getModelList(
            "PSDEMAINSTATERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEMainStateRSList == null) {
            psDEMainStateRSList = new Vector<>();
            CallResult callResultxx = this.getPSDEMainStateRSsBySystem(strPSSystemId, psDEMainStateRSList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体主状态关系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEMAINSTATERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEMainStateRSList);
         }

         for (PSDEMainStateRS psDEMainStateRS : psDEMainStateRSList) {
            String strPSDEId = psDEMainStateRS.getPSDEID();
            psSystemStorage.getPSDataEntityStorage(psDEMainStateRS.getPSDEID()).psDEMainStateRSList.add(psDEMainStateRS);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAEXP");
      Vector<PSDEDataExport> psDEDataExportList = psSysModelCache.getModelList(
         "PSDEDATAEXP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEDataExportList == null) {
         psDEDataExportList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataExportsBySystem(strPSSystemId, psDEDataExportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导出发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAEXP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataExportList);
      }

      for (PSDEDataExport psDEDataExport : psDEDataExportList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataExport.getPSDEID()).psDEDataExportList.add(psDEDataExport);
         PSDEDataExportStorage psDEDataExportStorage = psSystemStorage.getPSDEDataExportStorage(psDEDataExport.getPSDEDATAEXPID());
         psDEDataExportStorage.psDEDataExport = psDEDataExport;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGRIDCOL");
      if (psSysModelLog2xxxxxxxxxxxxx == null) {
         psSysModelLog2xxxxxxxxxxxxx = psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
      }

      Vector<PSDEGridColumn> psDEDataExportItemList = psSysModelCache.getModelList("PSDEDATAEXPITEM", psSysModelLog2xxxxxxxxxxxxx);
      if (psDEDataExportItemList == null) {
         psDEDataExportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataExportItemsBySystem(strPSSystemId, psDEDataExportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导出项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAEXPITEM", psSysModelLog2xxxxxxxxxxxxx, psDEDataExportItemList);
      }

      for (PSDEGridColumn psDEGridColumn : psDEDataExportItemList) {
         psSystemStorage.getPSDEDataExportStorage(psDEGridColumn.getParamStringValue("PSDEDATAEXPID", "")).psDEGridColumnList.add(psDEGridColumn);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAIMP");
      Vector<PSDEDataImport> psDEDataImportList = psSysModelCache.getModelList(
         "PSDEDATAIMP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEDataImportList == null) {
         psDEDataImportList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataImportsBySystem(strPSSystemId, psDEDataImportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导入发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAIMP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataImportList);
      }

      for (PSDEDataImport psDEDataImport : psDEDataImportList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataImport.getPSDEID()).psDEDataImportList.add(psDEDataImport);
         PSDEDataImportStorage psDEDataImportStorage = psSystemStorage.getPSDEDataImportStorage(psDEDataImport.getPSDEDATAIMPID());
         psDEDataImportStorage.psDEDataImport = psDEDataImport;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAIMPITEM");
      Vector<PSDEDataImportItem> psDEDataImportItemList = psSysModelCache.getModelList(
         "PSDEDATAIMPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxx
      );
      if (psDEDataImportItemList == null) {
         psDEDataImportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataImportItemsBySystem(strPSSystemId, psDEDataImportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导入项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEDATAIMPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxx, psDEDataImportItemList
         );
      }

      for (PSDEDataImportItem psDEDataImportItem : psDEDataImportItemList) {
         psSystemStorage.getPSDEDataImportStorage(psDEDataImportItem.getParamStringValue("PSDEDATAIMPID", "")).psDEDataImportItemList.add(psDEDataImportItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEREPORT");
      Vector<PSDEReport> psDEReportList = psSysModelCache.getModelList("PSDEREPORT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEReportList == null) {
         psDEReportList = new Vector<>();
         CallResult callResultxx = this.getPSDEReportsBySystem(strPSSystemId, psDEReportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体报表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEREPORT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEReportList);
      }

      for (PSDEReport psDEReport : psDEReportList) {
         psSystemStorage.getPSDataEntityStorage(psDEReport.getPSDEID()).psDEReportList.add(psDEReport);
         PSDEReportStorage psDEReportStorage = psSystemStorage.getPSDEReportStorage(psDEReport.getPSDEREPORTID());
         psDEReportStorage.psDEReport = psDEReport;
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEREPITEM");
      Vector<PSDEReportItem> psDEReportItemList = psSysModelCache.getModelList(
         "PSDEREPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxx
      );
      if (psDEReportItemList == null) {
         psDEReportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEReportItemsBySystem(strPSSystemId, psDEReportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体报表子项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEREPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxx, psDEReportItemList
         );
      }

      for (PSDEReportItem psDEReportItem : psDEReportItemList) {
         psSystemStorage.getPSDEReportStorage(psDEReportItem.getMAJORPSDEREPORTID()).psDEReportItemList.add(psDEReportItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEPRINT");
      Vector<PSDEPrint> psDEPrintList = psSysModelCache.getModelList("PSDEPRINT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEPrintList == null) {
         psDEPrintList = new Vector<>();
         CallResult callResultxx = this.getPSDEPrintsBySystem(strPSSystemId, psDEPrintList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体打印发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEPRINT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEPrintList);
      }

      for (PSDEPrint psDEPrint : psDEPrintList) {
         psSystemStorage.getPSDataEntityStorage(psDEPrint.getPSDEID()).psDEPrintList.add(psDEPrint);
         PSDEPrintStorage psDEPrintStorage = psSystemStorage.getPSDEPrintStorage(psDEPrint.getPSDEPRINTID());
         psDEPrintStorage.psDEPrint = psDEPrint;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUTILDE");
      Vector<PSDEUtil> psDEUtilList = psSysModelCache.getModelList("PSDEUTILDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEUtilList == null) {
         psDEUtilList = new Vector<>();
         CallResult callResultxx = this.getPSDEUtilsBySystem(strPSSystemId, psDEUtilList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体辅助功能发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUTILDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUtilList);
      }

      for (PSDEUtil psDEUtil : psDEUtilList) {
         psSystemStorage.getPSDataEntityStorage(psDEUtil.getPSDEID()).psDEUtilList.add(psDEUtil);
         PSDEUtilStorage psDEUtilStorage = psSystemStorage.getPSDEUtilStorage(psDEUtil.getPSDEUTILDEID());
         psDEUtilStorage.psDEUtil = psDEUtil;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUSERROLE");
      Vector<PSDEUserRole> psDEUserRoleList = psSysModelCache.getModelList(
         "PSDEUSERROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUserRoleList == null) {
         psDEUserRoleList = new Vector<>();
         CallResult callResultxx = this.getPSDEUserRolesBySystem(strPSSystemId, psDEUserRoleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体用户角色发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUSERROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUserRoleList);
      }

      for (PSDEUserRole psDEUserRole : psDEUserRoleList) {
         psSystemStorage.getPSDataEntityStorage(psDEUserRole.getPSDEID()).psDEUserRoleList.add(psDEUserRole);
         PSDEUserRoleStorage psDEUserRoleStorage = psSystemStorage.getPSDEUserRoleStorage(psDEUserRole.getPSDEUSERROLEID());
         psDEUserRoleStorage.psDEUserRole = psDEUserRole;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEOPPRIVROLE");
      Vector<PSDEOPPrivRole> psDEOPPrivRoleList = psSysModelCache.getModelList(
         "PSDEOPPRIVROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEOPPrivRoleList == null) {
         psDEOPPrivRoleList = new Vector<>();
         CallResult callResultxx = this.getPSDEOPPrivRolesBySystem(strPSSystemId, psDEOPPrivRoleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体用户角色发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEOPPRIVROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEOPPrivRoleList);
      }

      for (PSDEOPPrivRole psDEOPPrivRole : psDEOPPrivRoleList) {
         psSystemStorage.getPSDataEntityStorage(psDEOPPrivRole.getPSDEID()).psDEOPPrivRoleList.add(psDEOPPrivRole);
         PSDEOPPrivRoleStorage psDEOPPrivRoleStorage = psSystemStorage.getPSDEOPPrivRoleStorage(psDEOPPrivRole.getPSDEOPPRIVROLEID());
         psDEOPPrivRoleStorage.psDEOPPrivRole = psDEOPPrivRole;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUSERMODE");
      Vector<PSSysUserMode> psSysUserModeList = psSysModelCache.getModelList(
         "PSSYSUSERMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysUserModeList == null) {
         psSysUserModeList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUserModes2(strPSSystemId, psSysUserModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有用户模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUSERMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUserModeList);
      }

      psSystemStorage.psSysUserModeList.addAll(psSysUserModeList);

      for (PSSysUserMode psSysUserMode : psSysUserModeList) {
         psSystemStorage.psSysUserModeMap.put(psSysUserMode.getPSSYSUSERMODEID(), psSysUserMode);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUSERDR");
      Vector<PSSysUserDR> psSysUserDRList = psSysModelCache.getModelList(
         "PSSYSUSERDR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysUserDRList == null) {
         psSysUserDRList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUserDRs2(strPSSystemId, psSysUserDRList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有自定义权限数据范围发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSUSERDR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUserDRList);
      }

      psSystemStorage.psSysUserDRList.addAll(psSysUserDRList);

      for (PSSysUserDR psSysUserDR : psSysUserDRList) {
         psSystemStorage.psSysUserDRMap.put(psSysUserDR.getPSSYSUSERDRID(), psSysUserDR);
      }

      if (this.getModelInstVer() >= 387) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDESAMPLEDATA");
         Vector<PSDESampleData> psDESampleDataList = psSysModelCache.getModelList(
            "PSDESAMPLEDATA", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDESampleDataList == null) {
            psDESampleDataList = new Vector<>();
            CallResult callResultxx = this.getPSDESampleDatasBySystem(strPSSystemId, psDESampleDataList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体示例数据发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDESAMPLEDATA", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDESampleDataList);
         }

         for (PSDESampleData psDESampleData : psDESampleDataList) {
            psSystemStorage.getPSDataEntityStorage(psDESampleData.getPSDEID()).psDESampleDataList.add(psDESampleData);
         }
      }

      if (this.getModelInstVer() >= 598) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSACTOR");
         Vector<PSSysActor> psSysActorList = psSysModelCache.getModelList(
            "PSSYSACTOR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysActorList == null) {
            psSysActorList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysActors2(strPSSystemId, psSysActorList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有操作者发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSACTOR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysActorList);
         }

         psSystemStorage.psSysActorList.addAll(psSysActorList);

         for (PSSysActor psSysActor : psSysActorList) {
            psSystemStorage.psSysActorMap.put(psSysActor.getPSSYSACTORID(), psSysActor);
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUSERCASE");
         Vector<PSSysUserCase> psSysUserCaseList = psSysModelCache.getModelList(
            "PSSYSUSERCASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysUserCaseList == null) {
            psSysUserCaseList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysUserCases2(strPSSystemId, psSysUserCaseList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有用例发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSUSERCASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUserCaseList);
         }

         psSystemStorage.psSysUserCaseList.addAll(psSysUserCaseList);

         for (PSSysUserCase psSysUserCase : psSysUserCaseList) {
            psSystemStorage.psSysUserCaseMap.put(psSysUserCase.getPSSYSUSERCASEID(), psSysUserCase);
         }

         if (this.getModelInstVer() >= 598) {
            PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUSERCASERS");
            Vector<PSSysUserCaseRS> psSysUserCaseRSList = psSysModelCache.getModelList(
               "PSSYSUSERCASERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psSysUserCaseRSList == null) {
               psSysUserCaseRSList = new Vector<>();
               CallResult callResultxx = this.getAllPSSysUserCaseRSs2(strPSSystemId, psSysUserCaseRSList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有用例关系发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList(
                  "PSSYSUSERCASERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUserCaseRSList
               );
            }

            psSystemStorage.psSysUserCaseRSList.addAll(psSysUserCaseRSList);

            for (PSSysUserCaseRS psSysUserCaseRS : psSysUserCaseRSList) {
               psSystemStorage.psSysUserCaseRSMap.put(psSysUserCaseRS.getPSSYSUSERCASERSID(), psSysUserCaseRS);
            }
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSAMPLEVALUE");
      Vector<PSSysSampleValue> psSysSampleValueList = psSysModelCache.getModelList(
         "PSSYSSAMPLEVALUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysSampleValueList == null) {
         psSysSampleValueList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysSampleValues2(strPSSystemId, psSysSampleValueList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有示例值发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSSAMPLEVALUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSampleValueList);
      }

      psSystemStorage.psSysSampleValueList.addAll(psSysSampleValueList);

      for (PSSysSampleValue psSysSampleValue : psSysSampleValueList) {
         psSystemStorage.psSysSampleValueMap.put(psSysSampleValue.getPSSYSSAMPLEVALUEID(), psSysSampleValue);
      }

      if (this.getModelInstVer() >= 585) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSRESOURCE");
         Vector<PSSysResource> psSysResourceList = psSysModelCache.getModelList(
            "PSSYSRESOURCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysResourceList == null) {
            psSysResourceList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysResources2(strPSSystemId, psSysResourceList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有预置资源发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSRESOURCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysResourceList);
         }

         psSystemStorage.psSysResourceList.addAll(psSysResourceList);

         for (PSSysResource psSysResource : psSysResourceList) {
            psSystemStorage.psSysResourceMap.put(psSysResource.getPSSYSRESOURCEID(), psSysResource);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDBVF");
      Vector<PSSysDBValueFunc> psSysDBValueFuncList = psSysModelCache.getModelList(
         "PSSYSDBVF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysDBValueFuncList == null) {
         psSysDBValueFuncList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDBValueFuncs2(strPSSystemId, psSysDBValueFuncList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有值函数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDBVF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDBValueFuncList);
      }

      psSystemStorage.psSysDBValueFuncList.addAll(psSysDBValueFuncList);

      for (PSSysDBValueFunc psSysDBValueFunc : psSysDBValueFuncList) {
         psSystemStorage.psSysDBValueFuncMap.put(psSysDBValueFunc.getPSSYSDBVFID(), psSysDBValueFunc);
      }

      if (this.getModelInstVer() >= 683) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSEQUENCE");
         Vector<PSSysSequence> psSysSequenceList = psSysModelCache.getModelList(
            "PSSYSSEQUENCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysSequenceList == null) {
            psSysSequenceList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysSequences2(strPSSystemId, psSysSequenceList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有值序列发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSSEQUENCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSequenceList);
         }

         psSystemStorage.psSysSequenceList.addAll(psSysSequenceList);

         for (PSSysSequence psSysSequence : psSysSequenceList) {
            psSystemStorage.psSysSequenceMap.put(psSysSequence.getPSSYSSEQUENCEID(), psSysSequence);
         }
      }

      if (this.getModelInstVer() >= 685) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTRANSLATOR");
         Vector<PSSysTranslator> psSysTranslatorList = psSysModelCache.getModelList(
            "PSSYSTRANSLATOR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysTranslatorList == null) {
            psSysTranslatorList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysTranslators2(strPSSystemId, psSysTranslatorList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有值转换器发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSTRANSLATOR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTranslatorList
            );
         }

         psSystemStorage.psSysTranslatorList.addAll(psSysTranslatorList);

         for (PSSysTranslator psSysTranslator : psSysTranslatorList) {
            psSystemStorage.psSysTranslatorMap.put(psSysTranslator.getPSSYSTRANSLATORID(), psSysTranslator);
         }
      }

      if (this.getModelInstVer() >= 691) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSMSGQUEUE");
         Vector<PSSysMsgQueue> psSysMsgQueueList = psSysModelCache.getModelList(
            "PSSYSMSGQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysMsgQueueList == null) {
            psSysMsgQueueList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysMsgQueues2(strPSSystemId, psSysMsgQueueList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有消息队列发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSMSGQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysMsgQueueList);
         }

         psSystemStorage.psSysMsgQueueList.addAll(psSysMsgQueueList);
      }

      if (this.getModelInstVer() >= 691) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSMSGTARGET");
         Vector<PSSysMsgTarget> psSysMsgTargetList = psSysModelCache.getModelList(
            "PSSYSMSGTARGET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysMsgTargetList == null) {
            psSysMsgTargetList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysMsgTargets2(strPSSystemId, psSysMsgTargetList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有消息目标发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSMSGTARGET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysMsgTargetList);
         }

         psSystemStorage.psSysMsgTargetList.addAll(psSysMsgTargetList);
      }

      if (this.getModelInstVer() >= 691) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDENOTIFY");
         Vector<PSDENotify> psDENotifyList = psSysModelCache.getModelList(
            "PSDENOTIFY", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDENotifyList == null) {
            psDENotifyList = new Vector<>();
            CallResult callResultxx = this.getPSDENotifiesBySystem(strPSSystemId, psDENotifyList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体通知发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDENOTIFY", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDENotifyList);
         }

         for (PSDENotify psDENotify : psDENotifyList) {
            psSystemStorage.getPSDataEntityStorage(psDENotify.getPSDEID()).psDENotifyList.add(psDENotify);
            PSDENotifyStorage psDENotifyStorage = psSystemStorage.getPSDENotifyStorage(psDENotify.getPSDENOTIFYID());
            psDENotifyStorage.psDENotify = psDENotify;
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDENOTIFYTARGET");
         Vector<PSDENotifyTarget> psDENotifyTargetList = psSysModelCache.getModelList(
            "PSDENOTIFYTARGET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxx
         );
         if (psDENotifyTargetList == null) {
            psDENotifyTargetList = new Vector<>();
            CallResult callResultxx = this.getPSDENotifyTargetsBySystem(strPSSystemId, psDENotifyTargetList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体通知目标发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDENOTIFYTARGET",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxx,
               psDENotifyTargetList
            );
         }

         for (PSDENotifyTarget psDENotifyTarget : psDENotifyTargetList) {
            psSystemStorage.getPSDENotifyStorage(psDENotifyTarget.getPSDENOTIFYID()).psDENotifyTargetList.add(psDENotifyTarget);
         }
      }

      if (this.getModelInstVer() >= 598) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSCONTENTCAT");
         Vector<PSSysContentCat> psSysContentCatList = psSysModelCache.getModelList(
            "PSSYSCONTENTCAT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysContentCatList == null) {
            psSysContentCatList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysContentCats2(strPSSystemId, psSysContentCatList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有内容分类发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSCONTENTCAT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysContentCatList
            );
         }

         for (PSSysContentCat psSysContentCat : psSysContentCatList) {
            psSystemStorage.getPSSysContentCatStorage(psSysContentCat.getPSSYSCONTENTCATID()).psSysContentCat = psSysContentCat;
            if (StringHelper.IsNullOrEmpty(psSysContentCat.getPPSSYSCONTENTCATID())) {
               psSystemStorage.psSysContentCatList.add(psSysContentCat);
            } else {
               psSystemStorage.getPSSysContentCatStorage(psSysContentCat.getPPSSYSCONTENTCATID()).psSysContentCatList.add(psSysContentCat);
            }
         }
      }

      if (this.getModelInstVer() >= 585) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSCONTENT");
         Vector<PSSysContent> psSysContentList = psSysModelCache.getModelList(
            "PSSYSCONTENT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysContentList == null) {
            psSysContentList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysContents2(strPSSystemId, psSysContentList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有预置内容发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSCONTENT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysContentList);
         }

         for (PSSysContent psSysContent : psSysContentList) {
            psSystemStorage.psSysContentMap.put(psSysContent.getPSSYSCONTENTID(), psSysContent);
            psSystemStorage.getPSSysContentCatStorage(psSysContent.getPSSYSCONTENTCATID()).psSysContentList.add(psSysContent);
         }
      }

      if (this.getModelInstVer() >= 602) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSREQMODULE");
         Vector<PSSysReqModule> psSysReqModuleList = psSysModelCache.getModelList(
            "PSSYSREQMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysReqModuleList == null) {
            psSysReqModuleList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysReqModules2(strPSSystemId, psSysReqModuleList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有需求模块发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSREQMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysReqModuleList);
         }

         for (PSSysReqModule psSysReqModule : psSysReqModuleList) {
            psSystemStorage.getPSSysReqModuleStorage(psSysReqModule.getPSSYSREQMODULEID()).psSysReqModule = psSysReqModule;
            if (StringHelper.IsNullOrEmpty(psSysReqModule.getPPSSYSREQMODULEID())) {
               psSystemStorage.psSysReqModuleList.add(psSysReqModule);
            } else {
               psSystemStorage.getPSSysReqModuleStorage(psSysReqModule.getPPSSYSREQMODULEID()).psSysReqModuleList.add(psSysReqModule);
            }
         }
      }

      if (this.getModelInstVer() >= 602) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSREQITEM");
         Vector<PSSysReqItem> psSysReqItemList = psSysModelCache.getModelList(
            "PSSYSREQITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysReqItemList == null) {
            psSysReqItemList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysReqItems2(strPSSystemId, psSysReqItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有需求项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSREQITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysReqItemList);
         }

         for (PSSysReqItem psSysReqItem : psSysReqItemList) {
            psSystemStorage.psSysReqItemMap.put(psSysReqItem.getPSSYSREQITEMID(), psSysReqItem);
            psSystemStorage.psSysReqItemList.add(psSysReqItem);
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTESTDATA");
         Vector<PSSysTestData> psSysTestDataList = psSysModelCache.getModelList(
            "PSSYSTESTDATA", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysTestDataList == null) {
            psSysTestDataList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysTestDatas2(strPSSystemId, psSysTestDataList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有测试数据发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSTESTDATA", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTestDataList);
         }

         psSystemStorage.psSysTestDataList.addAll(psSysTestDataList);

         for (PSSysTestData psSysTestData : psSysTestDataList) {
            psSystemStorage.psSysTestDataMap.put(psSysTestData.getPSSYSTESTDATAID(), psSysTestData);
            psSystemStorage.getPSSysTestDataStorage(psSysTestData.getPSSYSTESTDATAID()).psSysTestData = psSysTestData;
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTDITEM");
         Vector<PSSysTestDataItem> psSysTestDataItemList = psSysModelCache.getModelList(
            "PSSYSTDITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxx
         );
         if (psSysTestDataItemList == null) {
            psSysTestDataItemList = new Vector<>();
            CallResult callResultxx = this.getPSSysTestDataItemsBySystem(strPSSystemId, psSysTestDataItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有测试数据项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSTDITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxx, psSysTestDataItemList
            );
         }

         for (PSSysTestDataItem psSysTestDataItem : psSysTestDataItemList) {
            psSystemStorage.getPSSysTestDataStorage(psSysTestDataItem.getPSSYSTESTDATAID()).psSysTestDataItemList.add(psSysTestDataItem);
         }

         if (this.getModelInstVer() >= 602) {
            PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTESTPRJ");
            boolean bLoadDetailx = true;
            Vector<PSSysTestPrj> psSysTestPrjList = psSysModelCache.getModelList("PSSYSTESTPRJ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
            if (psSysTestPrjList == null) {
               psSysTestPrjList = new Vector<>();
               CallResult callResultxx = this.getAllPSSysTestPrjs2(strPSSystemId, psSysTestPrjList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有测试项目发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSTESTPRJ", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTestPrjList);
            }

            psSystemStorage.psSysTestPrjList.addAll(psSysTestPrjList);

            for (PSSysTestPrj psSysTestPrj : psSysTestPrjList) {
               psSystemStorage.psSysTestPrjMap.put(psSysTestPrj.getPSSYSTESTPRJID(), psSysTestPrj);
               psSystemStorage.getPSSysTestPrjStorage(psSysTestPrj.getPSSYSTESTPRJID()).psSysTestPrj = psSysTestPrj;
            }

            PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTESTMODULE");
            boolean bLoadDetailxx = true;
            Vector<PSSysTestModule> psSysTestModuleList = psSysModelCache.getModelList("PSSYSTESTMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
            if (psSysTestModuleList == null) {
               psSysTestModuleList = new Vector<>();
               CallResult callResultxx = this.getAllPSSysTestModules2(strPSSystemId, psSysTestModuleList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有测试模块发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList(
                  "PSSYSTESTMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTestModuleList
               );
            }

            for (PSSysTestModule psSysTestModule : psSysTestModuleList) {
               psSystemStorage.getPSSysTestPrjStorage(psSysTestModule.getPSSYSTESTPRJID()).psSysTestModuleList.add(psSysTestModule);
               psSystemStorage.psSysTestModuleMap.put(psSysTestModule.getPSSYSTESTMODULEID(), psSysTestModule);
               psSystemStorage.getPSSysTestModuleStorage(psSysTestModule.getPSSYSTESTMODULEID()).psSysTestModule = psSysTestModule;
            }
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTESTCASE");
         boolean bLoadDetailx = true;
         Vector<PSSysTestCase> psSysTestCaseList = psSysModelCache.getModelList("PSSYSTESTCASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysTestCaseList == null) {
            psSysTestCaseList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysTestCases2(strPSSystemId, psSysTestCaseList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有测试用例发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSTESTCASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTestCaseList);
         }

         for (PSSysTestCase psSysTestCase : psSysTestCaseList) {
            if (StringHelper.IsNullOrEmpty(psSysTestCase.getPSSYSTESTMODULEID())) {
               psSystemStorage.psSysTestCaseList.add(psSysTestCase);
            } else {
               psSystemStorage.getPSSysTestModuleStorage(psSysTestCase.getPSSYSTESTMODULEID()).psSysTestCaseList.add(psSysTestCase);
            }

            psSystemStorage.psSysTestCaseMap.put(psSysTestCase.getPSSYSTESTCASEID(), psSysTestCase);
            psSystemStorage.getPSSysTestCaseStorage(psSysTestCase.getPSSYSTESTCASEID()).psSysTestCase = psSysTestCase;
         }

         boolean var353 = psSysTestCaseList.size() > 0;
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTCINPUT");
         Vector<PSSysTestCaseInput> psSysTestCaseInputList = psSysModelCache.getModelList(
            "PSSYSTCINPUT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxx
         );
         if (psSysTestCaseInputList == null) {
            psSysTestCaseInputList = new Vector<>();
            CallResult callResultxx = this.getPSSysTestCaseInputsBySystem(strPSSystemId, psSysTestCaseInputList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有测试用例输入发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSTCINPUT",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxx,
               psSysTestCaseInputList
            );
         }

         for (PSSysTestCaseInput psSysTestCaseInput : psSysTestCaseInputList) {
            psSystemStorage.getPSSysTestCaseInputStorage(psSysTestCaseInput.getPSSYSTCINPUTID()).psSysTestCaseInput = psSysTestCaseInput;
            psSystemStorage.getPSSysTestCaseStorage(psSysTestCaseInput.getPSSYSTESTCASEID()).psSysTestCaseInputList.add(psSysTestCaseInput);
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTCASSERT");
         Vector<PSSysTestCaseAssert> psSysTestCaseAssertList = psSysModelCache.getModelList(
            "PSSYSTCASSERT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxxx
         );
         if (psSysTestCaseAssertList == null) {
            psSysTestCaseAssertList = new Vector<>();
            CallResult callResultxx = this.getPSSysTestCaseAssertsBySystem(strPSSystemId, psSysTestCaseAssertList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有测试用例断言发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSTCASSERT",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxxx,
               psSysTestCaseAssertList
            );
         }

         for (PSSysTestCaseAssert psSysTestCaseAssert : psSysTestCaseAssertList) {
            psSystemStorage.getPSSysTestCaseInputStorage(psSysTestCaseAssert.getPSSYSTCINPUTID()).psSysTestCaseAssertList.add(psSysTestCaseAssert);
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWXACCOUNT");
         Vector<PSWXAccount> psWXAccountList = psSysModelCache.getModelList(
            "PSWXACCOUNT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXAccountList == null) {
            psWXAccountList = new Vector<>();
            CallResult callResultxx = this.getAllPSWXAccounts2(strPSSystemId, psWXAccountList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信公众号发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXACCOUNT", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXAccountList);
         }

         psSystemStorage.psWXAccountList.addAll(psWXAccountList);

         for (PSWXAccount psWXAccount : psWXAccountList) {
            psSystemStorage.getPSWXAccountStorage(psWXAccount.getPSWXACCOUNTID()).psWXAccount = psWXAccount;
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWXENTAPP");
         Vector<PSWXEntApp> psWXEntAppList = psSysModelCache.getModelList(
            "PSWXENTAPP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXEntAppList == null) {
            psWXEntAppList = new Vector<>();
            CallResult callResultxx = this.getPSWXEntAppsBySystem(strPSSystemId, psWXEntAppList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信公众号应用发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXENTAPP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXEntAppList);
         }

         for (PSWXEntApp psWXEntApp : psWXEntAppList) {
            psSystemStorage.getPSWXAccountStorage(psWXEntApp.getPSWXACCOUNTID()).psWXEntAppList.add(psWXEntApp);
            psSystemStorage.getPSWXEntAppStorage(psWXEntApp.getPSWXENTAPPID()).strPSWXEntAppId = psWXEntApp.getPSSYSAPPID();
            psSystemStorage.getPSWXEntAppStorage(psWXEntApp.getPSWXENTAPPID()).psWXEntApp = psWXEntApp;
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWXMENUFUNC");
         Vector<PSWXMenuFunc> psWXMenuFuncList = psSysModelCache.getModelList(
            "PSWXMENUFUNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXMenuFuncList == null) {
            psWXMenuFuncList = new Vector<>();
            CallResult callResultxx = this.getPSWXMenuFuncsBySystem(strPSSystemId, psWXMenuFuncList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信菜单功能发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXMENUFUNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXMenuFuncList);
         }

         for (PSWXMenuFunc psWXMenuFunc : psWXMenuFuncList) {
            if (StringHelper.IsNullOrEmpty(psWXMenuFunc.getPSWXENTAPPID())) {
               psSystemStorage.getPSWXAccountStorage(psWXMenuFunc.getPSWXACCOUNTID()).psWXMenuFuncList.add(psWXMenuFunc);
            } else {
               psSystemStorage.getPSWXEntAppStorage(psWXMenuFunc.getPSWXENTAPPID()).psWXMenuFuncList.add(psWXMenuFunc);
            }
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWXLOGIC");
         Vector<PSWXLogic> psWXLogicList = psSysModelCache.getModelList(
            "PSWXLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXLogicList == null) {
            psWXLogicList = new Vector<>();
            CallResult callResultxx = this.getPSWXLogicsBySystem(strPSSystemId, psWXLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信公众号响应逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXLogicList);
         }

         for (PSWXLogic psWXLogic : psWXLogicList) {
            if (StringHelper.IsNullOrEmpty(psWXLogic.getPSWXENTAPPID())) {
               psSystemStorage.getPSWXAccountStorage(psWXLogic.getPSWXACCOUNTID()).psWXLogicList.add(psWXLogic);
            } else {
               psSystemStorage.getPSWXEntAppStorage(psWXLogic.getPSWXENTAPPID()).psWXLogicList.add(psWXLogic);
            }
         }

         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWXMENU");
         Vector<PSWXMenu> psWXMenuList = psSysModelCache.getModelList(
            "PSWXMENU", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXMenuList == null) {
            psWXMenuList = new Vector<>();
            CallResult callResultxx = this.getPSWXMenusBySystem(strPSSystemId, psWXMenuList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信公众号菜单发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXMENU", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXMenuList);
         }

         for (PSWXMenu psWXMenu : psWXMenuList) {
            if (StringHelper.IsNullOrEmpty(psWXMenu.getPSWXENTAPPID())) {
               psSystemStorage.getPSWXAccountStorage(psWXMenu.getPSWXACCOUNTID()).psWXMenuList.add(psWXMenu);
            } else {
               psSystemStorage.getPSWXEntAppStorage(psWXMenu.getPSWXENTAPPID()).psWXMenuList.add(psWXMenu);
            }

            psSystemStorage.getPSWXMenuStorage(psWXMenu.getPSWXMENUID()).strPSWXMenuId = psWXMenu.getPSWXMENUID();
            psSystemStorage.getPSWXMenuStorage(psWXMenu.getPSWXMENUID()).psWXMenu = psWXMenu;
         }

         Vector<PSWXMenuItem> psWXMenuItemList = psSysModelCache.getModelList(
            "PSWXMENUITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psWXMenuItemList == null) {
            psWXMenuItemList = new Vector<>();
            CallResult callResultxx = this.getPSWXMenuItemsBySystem(strPSSystemId, psWXMenuItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有微信公众号菜单项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSWXMENUITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWXMenuItemList);
         }

         for (PSWXMenuItem psWXMenuItem : psWXMenuItemList) {
            psSystemStorage.getPSWXMenuStorage(psWXMenuItem.getPSWXMENUID()).psWXMenuItemList.add(psWXMenuItem);
         }
      }

      if (this.getModelInstVer() >= 611) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSEARCHSCHEME");
         boolean bLoadDetailx = true;
         Vector<PSSysSearchScheme> psSysSearchSchemeList = psSysModelCache.getModelList("PSSYSSEARCHSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysSearchSchemeList == null) {
            psSysSearchSchemeList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysSearchSchemes2(strPSSystemId, psSysSearchSchemeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有全文检索体系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSSEARCHSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSearchSchemeList);
         }

         psSystemStorage.psSysSearchSchemeList.addAll(psSysSearchSchemeList);

         for (PSSysSearchScheme psSysSearchScheme : psSysSearchSchemeList) {
            psSystemStorage.psSysSearchSchemeMap.put(psSysSearchScheme.getPSSYSSEARCHSCHEMEID(), psSysSearchScheme);
            psSystemStorage.getPSSysSearchSchemeStorage(psSysSearchScheme.getPSSYSSEARCHSCHEMEID()).psSysSearchScheme = psSysSearchScheme;
         }

         boolean var361 = psSysSearchSchemeList.size() > 0;
         if (var361) {
            PSSysModelLog var141 = psSysModelLogMap.get("PSSYSSEARCHDOC");
            Vector<PSSysSearchDoc> psSysSearchDocList = psSysModelCache.getModelList("PSSYSSEARCHDOC", var141);
            if (psSysSearchDocList == null) {
               psSysSearchDocList = new Vector<>();
               CallResult callResultxx = this.getPSSysSearchDocsBySystem(strPSSystemId, psSysSearchDocList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有全文检索文档发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSSEARCHDOC", var141, psSysSearchDocList);
            }

            for (PSSysSearchDoc psSysSearchDoc : psSysSearchDocList) {
               psSystemStorage.getPSSysSearchSchemeStorage(psSysSearchDoc.getPSSYSSEARCHSCHEMEID()).psSysSearchDocList.add(psSysSearchDoc);
            }
         }

         if (var361) {
            PSSysModelLog var142 = psSysModelLogMap.get("PSSYSSEARCHDE");
            Vector<PSSysSearchDE> psSysSearchDEList = psSysModelCache.getModelList("PSSYSSEARCHDE", var142);
            if (psSysSearchDEList == null) {
               psSysSearchDEList = new Vector<>();
               CallResult callResultxx = this.getPSSysSearchDEsBySystem(strPSSystemId, psSysSearchDEList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有全文检索实体发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSSEARCHDE", var142, psSysSearchDEList);
            }

            for (PSSysSearchDE psSysSearchDE : psSysSearchDEList) {
               psSystemStorage.getPSSysSearchSchemeStorage(psSysSearchDE.getPSSYSSEARCHSCHEMEID()).psSysSearchDEList.add(psSysSearchDE);
            }
         }

         if (var361) {
            PSSysModelLog var143 = psSysModelLogMap.get("PSSYSSEARCHFIELD");
            Vector<PSSysSearchField> psSysSearchFieldList = psSysModelCache.getModelList("PSSYSSEARCHFIELD", var143);
            if (psSysSearchFieldList == null) {
               psSysSearchFieldList = new Vector<>();
               CallResult callResultxx = this.getPSSysSearchFieldsBySystem(strPSSystemId, psSysSearchFieldList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有全文检索文档属性发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSSEARCHFIELD", var143, psSysSearchFieldList);
            }

            for (PSSysSearchField psSysSearchField : psSysSearchFieldList) {
               psSystemStorage.getPSSysSearchDocStorage(psSysSearchField.getPSSYSSEARCHDOCID()).psSysSearchFieldList.add(psSysSearchField);
            }
         }

         if (var361) {
            PSSysModelLog var144 = psSysModelLogMap.get("PSSYSSEARCHDEFIELD");
            Vector<PSSysSearchDEField> psSysSearchDEFieldList = psSysModelCache.getModelList("PSSYSSEARCHDEFIELD", var144);
            if (psSysSearchDEFieldList == null) {
               psSysSearchDEFieldList = new Vector<>();
               CallResult callResultxx = this.getPSSysSearchDEFieldsBySystem(strPSSystemId, psSysSearchDEFieldList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有全文检索实体属性发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSSEARCHDEFIELD", var144, psSysSearchDEFieldList);
            }

            for (PSSysSearchDEField psSysSearchDEField : psSysSearchDEFieldList) {
               psSystemStorage.getPSSysSearchDEStorage(psSysSearchDEField.getPSSYSSEARCHDEID()).psSysSearchDEFieldList.add(psSysSearchDEField);
            }
         }
      }

      if (this.getModelInstVer() >= 697) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSEAISCHEME");
         boolean bLoadDetailx = true;
         Vector<PSSysEAIScheme> psSysEAISchemeList = psSysModelCache.getModelList("PSSYSEAISCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysEAISchemeList == null) {
            psSysEAISchemeList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysEAISchemes2(strPSSystemId, psSysEAISchemeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有集成体系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSEAISCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysEAISchemeList);
         }

         psSystemStorage.psSysEAISchemeList.addAll(psSysEAISchemeList);

         for (PSSysEAIScheme psSysEAIScheme : psSysEAISchemeList) {
            psSystemStorage.psSysEAISchemeMap.put(psSysEAIScheme.getPSSYSEAISCHEMEID(), psSysEAIScheme);
            psSystemStorage.getPSSysEAISchemeStorage(psSysEAIScheme.getPSSYSEAISCHEMEID()).psSysEAIScheme = psSysEAIScheme;
         }

         boolean var363 = psSysEAISchemeList.size() > 0;
         if (var363) {
            PSSysModelLog var146 = psSysModelLogMap.get("PSSYSEAIDATATYPE");
            Vector<PSSysEAIDataType> psSysEAIDataTypeList = psSysModelCache.getModelList("PSSYSEAIDATATYPE", var146);
            if (psSysEAIDataTypeList == null) {
               psSysEAIDataTypeList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIDataTypesBySystem(strPSSystemId, psSysEAIDataTypeList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成数据类型发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIDATATYPE", var146, psSysEAIDataTypeList);
            }

            for (PSSysEAIDataType psSysEAIDataType : psSysEAIDataTypeList) {
               psSystemStorage.getPSSysEAISchemeStorage(psSysEAIDataType.getPSSYSEAISCHEMEID()).psSysEAIDataTypeList.add(psSysEAIDataType);
            }
         }

         if (var363) {
            PSSysModelLog var147 = psSysModelLogMap.get("PSSYSEAIDATATYPEITEM");
            Vector<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList = psSysModelCache.getModelList("PSSYSEAIDATATYPEITEM", var147);
            if (psSysEAIDataTypeItemList == null) {
               psSysEAIDataTypeItemList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIDataTypeItemsBySystem(strPSSystemId, psSysEAIDataTypeItemList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成数据类型项发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIDATATYPEITEM", var147, psSysEAIDataTypeItemList);
            }

            for (PSSysEAIDataTypeItem psSysEAIDataTypeItem : psSysEAIDataTypeItemList) {
               psSystemStorage.getPSSysEAIDataTypeStorage(psSysEAIDataTypeItem.getPSSYSEAIDATATYPEID()).psSysEAIDataTypeItemList.add(psSysEAIDataTypeItem);
            }
         }

         if (var363) {
            PSSysModelLog var148 = psSysModelLogMap.get("PSSYSEAIELEMENT");
            Vector<PSSysEAIElement> psSysEAIElementList = psSysModelCache.getModelList("PSSYSEAIELEMENT", var148);
            if (psSysEAIElementList == null) {
               psSysEAIElementList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIElementsBySystem(strPSSystemId, psSysEAIElementList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成元素发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIELEMENT", var148, psSysEAIElementList);
            }

            for (PSSysEAIElement psSysEAIElement : psSysEAIElementList) {
               psSystemStorage.getPSSysEAISchemeStorage(psSysEAIElement.getPSSYSEAISCHEMEID()).psSysEAIElementList.add(psSysEAIElement);
            }
         }

         if (var363) {
            PSSysModelLog var149 = psSysModelLogMap.get("PSSYSEAIELEMENTATTR");
            Vector<PSSysEAIElementAttr> psSysEAIElementAttrList = psSysModelCache.getModelList("PSSYSEAIELEMENTATTR", var149);
            if (psSysEAIElementAttrList == null) {
               psSysEAIElementAttrList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIElementAttrsBySystem(strPSSystemId, psSysEAIElementAttrList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成元素属性发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIELEMENTATTR", var149, psSysEAIElementAttrList);
            }

            for (PSSysEAIElementAttr psSysEAIElementAttr : psSysEAIElementAttrList) {
               psSystemStorage.getPSSysEAIElementStorage(psSysEAIElementAttr.getPSSYSEAIELEMENTID()).psSysEAIElementAttrList.add(psSysEAIElementAttr);
            }
         }

         if (var363) {
            PSSysModelLog var150 = psSysModelLogMap.get("PSSYSEAIELEMENTRE");
            Vector<PSSysEAIElementRE> psSysEAIElementREList = psSysModelCache.getModelList("PSSYSEAIELEMENTRE", var150);
            if (psSysEAIElementREList == null) {
               psSysEAIElementREList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIElementREsBySystem(strPSSystemId, psSysEAIElementREList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成元素引用元素发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIELEMENTRE", var150, psSysEAIElementREList);
            }

            for (PSSysEAIElementRE psSysEAIElementRE : psSysEAIElementREList) {
               psSystemStorage.getPSSysEAIElementStorage(psSysEAIElementRE.getPSSYSEAIELEMENTID()).psSysEAIElementREList.add(psSysEAIElementRE);
            }
         }

         if (var363) {
            PSSysModelLog var151 = psSysModelLogMap.get("PSSYSEAIDE");
            Vector<PSSysEAIDE> psSysEAIDEList = psSysModelCache.getModelList("PSSYSEAIDE", var151);
            if (psSysEAIDEList == null) {
               psSysEAIDEList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIDEsBySystem(strPSSystemId, psSysEAIDEList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成实体映射发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIDE", var151, psSysEAIDEList);
            }

            for (PSSysEAIDE psSysEAIDE : psSysEAIDEList) {
               psSystemStorage.getPSSysEAISchemeStorage(psSysEAIDE.getPSSYSEAISCHEMEID()).psSysEAIDEList.add(psSysEAIDE);
            }
         }

         if (var363) {
            PSSysModelLog var152 = psSysModelLogMap.get("PSSYSEAIDEFIELD");
            Vector<PSSysEAIDEField> psSysEAIDEFieldList = psSysModelCache.getModelList("PSSYSEAIDEFIELD", var152);
            if (psSysEAIDEFieldList == null) {
               psSysEAIDEFieldList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIDEFieldsBySystem(strPSSystemId, psSysEAIDEFieldList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成实体属性映射发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIDEFIELD", var152, psSysEAIDEFieldList);
            }

            for (PSSysEAIDEField psSysEAIDEField : psSysEAIDEFieldList) {
               psSystemStorage.getPSSysEAIDEStorage(psSysEAIDEField.getPSSYSEAIDEID()).psSysEAIDEFieldList.add(psSysEAIDEField);
            }
         }

         if (var363) {
            PSSysModelLog var153 = psSysModelLogMap.get("PSSYSEAIDER");
            Vector<PSSysEAIDER> psSysEAIDERList = psSysModelCache.getModelList("PSSYSEAIDER", var153);
            if (psSysEAIDERList == null) {
               psSysEAIDERList = new Vector<>();
               CallResult callResultxx = this.getPSSysEAIDERsBySystem(strPSSystemId, psSysEAIDERList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有集成实体关系映射发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSEAIDER", var153, psSysEAIDERList);
            }

            for (PSSysEAIDER psSysEAIDER : psSysEAIDERList) {
               psSystemStorage.getPSSysEAIDEStorage(psSysEAIDER.getPSSYSEAIDEID()).psSysEAIDERList.add(psSysEAIDER);
            }
         }
      }

      if (this.getModelInstVer() >= 697) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBISCHEME");
         boolean bLoadDetailx = true;
         Vector<PSSysBIScheme> psSysBISchemeList = psSysModelCache.getModelList("PSSYSBISCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysBISchemeList == null) {
            psSysBISchemeList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysBISchemes2(strPSSystemId, psSysBISchemeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有智能报表体系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSBISCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBISchemeList);
         }

         psSystemStorage.psSysBISchemeList.addAll(psSysBISchemeList);

         for (PSSysBIScheme psSysBIScheme : psSysBISchemeList) {
            psSystemStorage.psSysBISchemeMap.put(psSysBIScheme.getPSSYSBISCHEMEID(), psSysBIScheme);
            psSystemStorage.getPSSysBISchemeStorage(psSysBIScheme.getPSSYSBISCHEMEID()).psSysBIScheme = psSysBIScheme;
         }

         boolean var365 = psSysBISchemeList.size() > 0;
         if (var365) {
            PSSysModelLog var155 = psSysModelLogMap.get("PSSYSBIDIMENSION");
            Vector<PSSysBIDimension> psSysBIDimensionList = psSysModelCache.getModelList("PSSYSBIDIMENSION", var155);
            if (psSysBIDimensionList == null) {
               psSysBIDimensionList = new Vector<>();
               CallResult callResultxx = this.getPSSysBIDimensionsBySystem(strPSSystemId, psSysBIDimensionList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表维度发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBIDIMENSION", var155, psSysBIDimensionList);
            }

            for (PSSysBIDimension psSysBIDimension : psSysBIDimensionList) {
               psSystemStorage.getPSSysBISchemeStorage(psSysBIDimension.getPSSYSBISCHEMEID()).psSysBIDimensionList.add(psSysBIDimension);
            }
         }

         if (var365) {
            PSSysModelLog var156 = psSysModelLogMap.get("PSSYSBIHIERARCHY");
            Vector<PSSysBIHierarchy> psSysBIHierarchyList = psSysModelCache.getModelList("PSSYSBIHIERARCHY", var156);
            if (psSysBIHierarchyList == null) {
               psSysBIHierarchyList = new Vector<>();
               CallResult callResultxx = this.getPSSysBIHierarchiesBySystem(strPSSystemId, psSysBIHierarchyList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表维度架构发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBIHIERARCHY", var156, psSysBIHierarchyList);
            }

            for (PSSysBIHierarchy psSysBIHierarchy : psSysBIHierarchyList) {
               psSystemStorage.getPSSysBIDimensionStorage(psSysBIHierarchy.getPSSYSBIDIMENSIONID()).psSysBIHierarchyList.add(psSysBIHierarchy);
            }
         }

         if (var365) {
            PSSysModelLog var157 = psSysModelLogMap.get("PSSYSBILEVEL");
            Vector<PSSysBILevel> psSysBILevelList = psSysModelCache.getModelList("PSSYSBILEVEL", var157);
            if (psSysBILevelList == null) {
               psSysBILevelList = new Vector<>();
               CallResult callResultxx = this.getPSSysBILevelsBySystem(strPSSystemId, psSysBILevelList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表维度层级发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBILEVEL", var157, psSysBILevelList);
            }

            for (PSSysBILevel psSysBILevel : psSysBILevelList) {
               psSystemStorage.getPSSysBIHierarchyStorage(psSysBILevel.getPSSYSBIHIERARCHYID()).psSysBILevelList.add(psSysBILevel);
            }
         }

         if (var365) {
            PSSysModelLog var158 = psSysModelLogMap.get("PSSYSBICUBE");
            Vector<PSSysBICube> psSysBICubeList = psSysModelCache.getModelList("PSSYSBICUBE", var158);
            if (psSysBICubeList == null) {
               psSysBICubeList = new Vector<>();
               CallResult callResultxx = this.getPSSysBICubesBySystem(strPSSystemId, psSysBICubeList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表立方体发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBICUBE", var158, psSysBICubeList);
            }

            for (PSSysBICube psSysBICube : psSysBICubeList) {
               psSystemStorage.getPSSysBISchemeStorage(psSysBICube.getPSSYSBISCHEMEID()).psSysBICubeList.add(psSysBICube);
            }
         }

         if (var365) {
            PSSysModelLog var159 = psSysModelLogMap.get("PSSYSBICUBEDIMENSION");
            Vector<PSSysBICubeDimension> psSysBICubeDimensionList = psSysModelCache.getModelList("PSSYSBICUBEDIMENSION", var159);
            if (psSysBICubeDimensionList == null) {
               psSysBICubeDimensionList = new Vector<>();
               CallResult callResultxx = this.getPSSysBICubeDimensionsBySystem(strPSSystemId, psSysBICubeDimensionList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表立方体维度发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBICUBEDIMENSION", var159, psSysBICubeDimensionList);
            }

            for (PSSysBICubeDimension psSysBICubeDimension : psSysBICubeDimensionList) {
               psSystemStorage.getPSSysBICubeStorage(psSysBICubeDimension.getPSSYSBICUBEID()).psSysBICubeDimensionList.add(psSysBICubeDimension);
            }
         }

         if (var365) {
            PSSysModelLog var160 = psSysModelLogMap.get("PSSYSBICUBELEVEL");
            Vector<PSSysBICubeLevel> psSysBICubeLevelList = psSysModelCache.getModelList("PSSYSBICUBELEVEL", var160);
            if (psSysBICubeLevelList == null) {
               psSysBICubeLevelList = new Vector<>();
               CallResult callResultxx = this.getPSSysBICubeLevelsBySystem(strPSSystemId, psSysBICubeLevelList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表立方体维度层级发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBICUBELEVEL", var160, psSysBICubeLevelList);
            }

            for (PSSysBICubeLevel psSysBICubeLevel : psSysBICubeLevelList) {
               psSystemStorage.getPSSysBICubeDimensionStorage(psSysBICubeLevel.getPSSYSBICUBEDIMENSIONID()).psSysBICubeLevelList.add(psSysBICubeLevel);
            }
         }

         if (var365) {
            PSSysModelLog var161 = psSysModelLogMap.get("PSSYSBICUBEMEASURE");
            Vector<PSSysBICubeMeasure> psSysBICubeMeasureList = psSysModelCache.getModelList("PSSYSBICUBEMEASURE", var161);
            if (psSysBICubeMeasureList == null) {
               psSysBICubeMeasureList = new Vector<>();
               CallResult callResultxx = this.getPSSysBICubeMeasuresBySystem(strPSSystemId, psSysBICubeMeasureList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表立方体指标发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBICUBEMEASURE", var161, psSysBICubeMeasureList);
            }

            for (PSSysBICubeMeasure psSysBICubeMeasure : psSysBICubeMeasureList) {
               psSystemStorage.getPSSysBICubeStorage(psSysBICubeMeasure.getPSSYSBICUBEID()).psSysBICubeMeasureList.add(psSysBICubeMeasure);
            }
         }

         if (var365) {
            PSSysModelLog var162 = psSysModelLogMap.get("PSSYSBIAGGTABLE");
            Vector<PSSysBIAggTable> psSysBIAggTableList = psSysModelCache.getModelList("PSSYSBIAGGTABLE", var162);
            if (psSysBIAggTableList == null) {
               psSysBIAggTableList = new Vector<>();
               CallResult callResultxx = this.getPSSysBIAggTablesBySystem(strPSSystemId, psSysBIAggTableList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表数据聚合表发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBIAGGTABLE", var162, psSysBIAggTableList);
            }

            for (PSSysBIAggTable psSysBIAggTable : psSysBIAggTableList) {
               psSystemStorage.getPSSysBISchemeStorage(psSysBIAggTable.getPSSYSBISCHEMEID()).psSysBIAggTableList.add(psSysBIAggTable);
            }
         }

         if (var365) {
            PSSysModelLog var163 = psSysModelLogMap.get("PSSYSBIAGGCOLUMN");
            Vector<PSSysBIAggColumn> psSysBIAggColumnList = psSysModelCache.getModelList("PSSYSBIAGGCOLUMN", var163);
            if (psSysBIAggColumnList == null) {
               psSysBIAggColumnList = new Vector<>();
               CallResult callResultxx = this.getPSSysBIAggColumnsBySystem(strPSSystemId, psSysBIAggColumnList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有智能报表聚合数据列发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSBIAGGCOLUMN", var163, psSysBIAggColumnList);
            }

            for (PSSysBIAggColumn psSysBIAggColumn : psSysBIAggColumnList) {
               psSystemStorage.getPSSysBIAggTableStorage(psSysBIAggColumn.getPSSYSBIAGGTABLEID()).psSysBIAggColumnList.add(psSysBIAggColumn);
            }
         }

         if (this.getModelInstVer() >= 785) {
            if (var365) {
               PSSysModelLog var164 = psSysModelLogMap.get("PSSYSBIREPORT");
               Vector<PSSysBIReport> psSysBIReportList = psSysModelCache.getModelList("PSSYSBIREPORT", var164);
               if (psSysBIReportList == null) {
                  psSysBIReportList = new Vector<>();
                  CallResult callResultxx = this.getPSSysBIReportsBySystem(strPSSystemId, psSysBIReportList);
                  if (callResultxx.isError()) {
                     throw new Exception(StringHelper.Format("查询系统所有智能报表发生错误，%1$s", callResultxx.getErrorInfo()));
                  }

                  psSysModelCache.updateModelList("PSSYSBIREPORT", var164, psSysBIReportList);
               }

               for (PSSysBIReport psSysBIReport : psSysBIReportList) {
                  psSystemStorage.getPSSysBISchemeStorage(psSysBIReport.getPSSYSBISCHEMEID()).psSysBIReportList.add(psSysBIReport);
               }
            }

            if (var365) {
               PSSysModelLog var165 = psSysModelLogMap.get("PSSYSBIREPORTITEM");
               Vector<PSSysBIReportItem> psSysBIReportItemList = psSysModelCache.getModelList("PSSYSBIREPORTITEM", var165);
               if (psSysBIReportItemList == null) {
                  psSysBIReportItemList = new Vector<>();
                  CallResult callResultxx = this.getPSSysBIReportItemsBySystem(strPSSystemId, psSysBIReportItemList);
                  if (callResultxx.isError()) {
                     throw new Exception(StringHelper.Format("查询系统所有智能报表项发生错误，%1$s", callResultxx.getErrorInfo()));
                  }

                  psSysModelCache.updateModelList("PSSYSBIREPORTITEM", var165, psSysBIReportItemList);
               }

               for (PSSysBIReportItem psSysBIReportItem : psSysBIReportItemList) {
                  psSystemStorage.getPSSysBIReportStorage(psSysBIReportItem.getPSSYSBIREPORTID()).psSysBIReportItemList.add(psSysBIReportItem);
               }
            }
         }
      }

      if (this.getModelInstVer() >= 803) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSAIFACTORY");
         boolean bLoadDetailx = true;
         Vector<PSSysAIFactory> psSysAIFactoryList = psSysModelCache.getModelList("PSSYSAIFACTORY", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysAIFactoryList == null) {
            psSysAIFactoryList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysAIFactories2(strPSSystemId, psSysAIFactoryList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有AI工厂发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSAIFACTORY", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysAIFactoryList);
         }

         psSystemStorage.psSysAIFactoryList.addAll(psSysAIFactoryList);

         for (PSSysAIFactory psSysAIFactory : psSysAIFactoryList) {
            psSystemStorage.psSysAIFactoryMap.put(psSysAIFactory.getPSSYSAIFACTORYID(), psSysAIFactory);
            psSystemStorage.getPSSysAIFactoryStorage(psSysAIFactory.getPSSYSAIFACTORYID()).psSysAIFactory = psSysAIFactory;
         }

         boolean var367 = psSysAIFactoryList.size() > 0;
         if (var367) {
            PSSysModelLog var167 = psSysModelLogMap.get("PSSYSAICHATAGENT");
            Vector<PSSysAIChatAgent> psSysAIChatAgentList = psSysModelCache.getModelList("PSSYSAICHATAGENT", var167);
            if (psSysAIChatAgentList == null) {
               psSysAIChatAgentList = new Vector<>();
               CallResult callResultxx = this.getPSSysAIChatAgentsBySystem(strPSSystemId, psSysAIChatAgentList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有交谈者代理发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSAICHATAGENT", var167, psSysAIChatAgentList);
            }

            for (PSSysAIChatAgent psSysAIChatAgent : psSysAIChatAgentList) {
               psSystemStorage.getPSSysAIFactoryStorage(psSysAIChatAgent.getPSSYSAIFACTORYID()).psSysAIChatAgentList.add(psSysAIChatAgent);
            }
         }

         if (var367) {
            PSSysModelLog var168 = psSysModelLogMap.get("PSSYSAIWORKERAGENT");
            Vector<PSSysAIWorkerAgent> psSysAIWorkerAgentList = psSysModelCache.getModelList("PSSYSAIWORKERAGENT", var168);
            if (psSysAIWorkerAgentList == null) {
               psSysAIWorkerAgentList = new Vector<>();
               CallResult callResultxx = this.getPSSysAIWorkerAgentsBySystem(strPSSystemId, psSysAIWorkerAgentList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有交谈者代理发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSAIWORKERAGENT", var168, psSysAIWorkerAgentList);
            }

            for (PSSysAIWorkerAgent psSysAIWorkerAgent : psSysAIWorkerAgentList) {
               psSystemStorage.getPSSysAIFactoryStorage(psSysAIWorkerAgent.getPSSYSAIFACTORYID()).psSysAIWorkerAgentList.add(psSysAIWorkerAgent);
            }
         }

         if (var367) {
            PSSysModelLog var169 = psSysModelLogMap.get("PSSYSAIPIPELINEAGENT");
            Vector<PSSysAIPipelineAgent> psSysAIPipelineAgentList = psSysModelCache.getModelList("PSSYSAIPIPELINEAGENT", var169);
            if (psSysAIPipelineAgentList == null) {
               psSysAIPipelineAgentList = new Vector<>();
               CallResult callResultxx = this.getPSSysAIPipelineAgentsBySystem(strPSSystemId, psSysAIPipelineAgentList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有AI工厂生产线发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSAIPIPELINEAGENT", var169, psSysAIPipelineAgentList);
            }

            for (PSSysAIPipelineAgent psSysAIPipelineAgent : psSysAIPipelineAgentList) {
               psSystemStorage.getPSSysAIFactoryStorage(psSysAIPipelineAgent.getPSSYSAIFACTORYID()).psSysAIPipelineAgentList.add(psSysAIPipelineAgent);
            }
         }

         if (var367) {
            PSSysModelLog var170 = psSysModelLogMap.get("PSSYSAIPIPELINEJOB");
            Vector<PSSysAIPipelineJob> psSysAIPipelineJobList = psSysModelCache.getModelList("PSSYSAIPIPELINEJOB", var170);
            if (psSysAIPipelineJobList == null) {
               psSysAIPipelineJobList = new Vector<>();
               CallResult callResultxx = this.getPSSysAIPipelineJobsBySystem(strPSSystemId, psSysAIPipelineJobList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有AI工厂生产线作业发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSAIPIPELINEJOB", var170, psSysAIPipelineJobList);
            }

            for (PSSysAIPipelineJob psSysAIPipelineJob : psSysAIPipelineJobList) {
               psSystemStorage.getPSSysAIPipelineStorage(psSysAIPipelineJob.getPSSYSAIPIPELINEAGENTID()).psSysAIPipelineJobList.add(psSysAIPipelineJob);
            }
         }

         if (var367) {
            PSSysModelLog var171 = psSysModelLogMap.get("PSSYSAIPIPELINEWORKER");
            Vector<PSSysAIPipelineWorker> psSysAIPipelineWorkerList = psSysModelCache.getModelList("PSSYSAIPIPELINEWORKER", var171);
            if (psSysAIPipelineWorkerList == null) {
               psSysAIPipelineWorkerList = new Vector<>();
               CallResult callResultxx = this.getPSSysAIPipelineWorkersBySystem(strPSSystemId, psSysAIPipelineWorkerList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有AI工厂生产线工作者发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSAIPIPELINEWORKER", var171, psSysAIPipelineWorkerList);
            }

            for (PSSysAIPipelineWorker psSysAIPipelineWorker : psSysAIPipelineWorkerList) {
               psSystemStorage.getPSSysAIPipelineStorage(psSysAIPipelineWorker.getPSSYSAIPIPELINEAGENTID())
                  .psSysAIPipelineWorkerList
                  .add(psSysAIPipelineWorker);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSERMAP");
         boolean bLoadDetailx = true;
         Vector<PSSysERMap> psSysERMapList = psSysModelCache.getModelList("PSSYSERMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysERMapList == null) {
            psSysERMapList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysERMaps2(strPSSystemId, psSysERMapList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有ER图发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSERMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysERMapList);
         }

         psSystemStorage.psSysERMapList.addAll(psSysERMapList);

         for (PSSysERMap psSysERMap : psSysERMapList) {
            psSystemStorage.psSysERMapMap.put(psSysERMap.getPSSYSERMAPID(), psSysERMap);
            psSystemStorage.getPSSysERMapStorage(psSysERMap.getPSSYSERMAPID()).psSysERMap = psSysERMap;
         }

         boolean var369 = psSysERMapList.size() > 0;
         Vector<PSSysERMapNode> psSysERMapNodeList = psSysModelCache.getModelList("PSSYSERMAPNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysERMapNodeList == null) {
            psSysERMapNodeList = new Vector<>();
            CallResult callResultxx = this.getPSSysERMapNodesBySystem(strPSSystemId, psSysERMapNodeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有ER图节点发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSERMAPNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysERMapNodeList);
         }

         for (PSSysERMapNode psSysERMapNode : psSysERMapNodeList) {
            psSystemStorage.getPSSysERMapStorage(psSysERMapNode.getPSSYSERMAPID()).psSysERMapNodeList.add(psSysERMapNode);
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUCMAP");
         boolean bLoadDetailx = true;
         Vector<PSSysUCMap> psSysUCMapList = psSysModelCache.getModelList("PSSYSUCMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysUCMapList == null) {
            psSysUCMapList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysUCMaps2(strPSSystemId, psSysUCMapList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有UC图发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSUCMAP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUCMapList);
         }

         psSystemStorage.psSysUCMapList.addAll(psSysUCMapList);

         for (PSSysUCMap psSysUCMap : psSysUCMapList) {
            psSystemStorage.psSysUCMapMap.put(psSysUCMap.getPSSYSUCMAPID(), psSysUCMap);
            psSystemStorage.getPSSysUCMapStorage(psSysUCMap.getPSSYSUCMAPID()).psSysUCMap = psSysUCMap;
         }

         boolean var371 = psSysUCMapList.size() > 0;
         Vector<PSSysUCMapNode> psSysUCMapNodeList = psSysModelCache.getModelList("PSSYSUCMAPNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysUCMapNodeList == null) {
            psSysUCMapNodeList = new Vector<>();
            CallResult callResultxx = this.getPSSysUCMapNodesBySystem(strPSSystemId, psSysUCMapNodeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有UC图节点发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSUCMAPNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUCMapNodeList);
         }

         for (PSSysUCMapNode psSysUCMapNode : psSysUCMapNodeList) {
            psSystemStorage.getPSSysUCMapStorage(psSysUCMapNode.getPSSYSUCMAPID()).psSysUCMapNodeList.add(psSysUCMapNode);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDYNAMODEL");
      boolean bLoadDetailx = true;
      Vector<PSSysDynaModel> psSysDynaModelList = psSysModelCache.getModelList("PSSYSDYNAMODEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psSysDynaModelList == null) {
         psSysDynaModelList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDynaModels2(strPSSystemId, psSysDynaModelList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有动态模型发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSDYNAMODEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDynaModelList);
      }

      psSystemStorage.psSysDynaModelList.addAll(psSysDynaModelList);

      for (PSSysDynaModel psSysDynaModel : psSysDynaModelList) {
         psSystemStorage.psSysDynaModelMap.put(psSysDynaModel.getPSSYSDYNAMODELID(), psSysDynaModel);
         psSystemStorage.getPSSysDynaModelStorage(psSysDynaModel.getPSSYSDYNAMODELID()).psSysDynaModel = psSysDynaModel;
      }

      boolean var373 = psSysDynaModelList.size() > 0;
      if (var373) {
         Vector<PSSysDynaModelAttr> psSysDynaModelAttrList = psSysModelCache.getModelList("PSSYSDYNAMODELATTR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysDynaModelAttrList == null) {
            psSysDynaModelAttrList = new Vector<>();
            CallResult callResultxx = this.getPSSysDynaModelAttrsBySystem(strPSSystemId, psSysDynaModelAttrList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有动态模型属性发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSDYNAMODELATTR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDynaModelAttrList);
         }

         for (PSSysDynaModelAttr psSysDynaModelAttr : psSysDynaModelAttrList) {
            psSystemStorage.getPSSysDynaModelStorage(psSysDynaModelAttr.getPSSYSDYNAMODELID()).psSysDynaModelAttrList.add(psSysDynaModelAttr);
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDYNADETEMPL");
         boolean bLoadDetailxx = true;
         Vector<PSDynaDETempl> psDynaDETemplList = psSysModelCache.getModelList(
            "PSDYNADETEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDynaDETemplList == null) {
            psDynaDETemplList = new Vector<>();
            CallResult callResultxx = this.getAllPSDynaDETempls2(strPSSystemId, psDynaDETemplList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有动态实体模板发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDYNADETEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDynaDETemplList
            );
         }

         psSystemStorage.psDynaDETemplList.addAll(psDynaDETemplList);

         for (PSDynaDETempl psDynaDETempl : psDynaDETemplList) {
            psSystemStorage.psDynaDETemplMap.put(psDynaDETempl.getPSDYNADETEMPLID(), psDynaDETempl);
            psSystemStorage.getPSDynaDETemplStorage(psDynaDETempl.getPSDYNADETEMPLID()).psDynaDETempl = psDynaDETempl;
         }

         boolean var375 = psDynaDETemplList.size() > 0;
         if (var375) {
            Vector<PSDynaDEViewTempl> psDynaDEViewTemplList = psSysModelCache.getModelList(
               "PSDYNADEVIEWTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psDynaDEViewTemplList == null) {
               psDynaDEViewTemplList = new Vector<>();
               CallResult callResultxx = this.getPSDynaDEViewTemplsBySystem(strPSSystemId, psDynaDEViewTemplList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有动态实体模板视图发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList(
                  "PSDYNADEVIEWTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDynaDEViewTemplList
               );
            }

            for (PSDynaDEViewTempl psDynaDEViewTempl : psDynaDEViewTemplList) {
               psSystemStorage.getPSDynaDETemplStorage(psDynaDEViewTempl.getPSDYNADETEMPLID()).psDynaDEViewTemplList.add(psDynaDEViewTempl);
            }
         }

         if (var375) {
            Vector<PSDynaDEFormTempl> psDynaDEFormTemplList = psSysModelCache.getModelList(
               "PSDYNADEFORMTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psDynaDEFormTemplList == null) {
               psDynaDEFormTemplList = new Vector<>();
               CallResult callResultxx = this.getPSDynaDEFormTemplsBySystem(strPSSystemId, psDynaDEFormTemplList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有动态实体模板表单发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList(
                  "PSDYNADEFORMTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDynaDEFormTemplList
               );
            }

            for (PSDynaDEFormTempl psDynaDEFormTempl : psDynaDEFormTemplList) {
               psSystemStorage.getPSDynaDETemplStorage(psDynaDEFormTempl.getPSDYNADETEMPLID()).psDynaDEFormTemplList.add(psDynaDEFormTempl);
            }
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEWIZARD");
      boolean bLoadDetailxx = true;
      Vector<PSDEWizard> psDEWizardList = psSysModelCache.getModelList(
         "PSDEWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEWizardList == null) {
         psDEWizardList = new Vector<>();
         CallResult callResultxx = this.getPSDEWizardsBySystem(strPSSystemId, psDEWizardList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体向导发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEWizardList
         );
      }

      for (PSDEWizard psDEWizard : psDEWizardList) {
         psSystemStorage.getPSDataEntityStorage(psDEWizard.getPSDEID()).psDEWizardList.add(psDEWizard);
         PSDEWizardStorage psDEWizardStorage = psSystemStorage.getPSDEWizardStorage(psDEWizard.getPSDEWIZARDID());
         psDEWizardStorage.psDEWizard = psDEWizard;
      }

      boolean var377 = psDEWizardList.size() > 0;
      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEWIZARDSTEP");
      Vector<PSDEWizardStep> psDEWizardStepList = psSysModelCache.getModelList(
         "PSDEWIZARDSTEP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxx
      );
      if (psDEWizardStepList == null) {
         psDEWizardStepList = new Vector<>();
         CallResult callResultxx = this.getPSDEWizardStepsBySystem(strPSSystemId, psDEWizardStepList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体向导步骤发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEWIZARDSTEP",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxx,
            psDEWizardStepList
         );
      }

      for (PSDEWizardStep psDEWizardStep : psDEWizardStepList) {
         psSystemStorage.getPSDEWizardStorage(psDEWizardStep.getPSDEWIZARDID()).psDEWizardStepList.add(psDEWizardStep);
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEWIZARDFORM");
      Vector<PSDEWizardForm> psDEWizardFormList = psSysModelCache.getModelList(
         "PSDEWIZARDFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxx
      );
      if (psDEWizardFormList == null) {
         psDEWizardFormList = new Vector<>();
         CallResult callResultxx = this.getPSDEWizardFormsBySystem(strPSSystemId, psDEWizardFormList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体向导表单发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEWIZARDFORM",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxx,
            psDEWizardFormList
         );
      }

      for (PSDEWizardForm psDEWizardForm : psDEWizardFormList) {
         psSystemStorage.getPSDEWizardStorage(psDEWizardForm.getPSDEWIZARDID()).psDEWizardFormList.add(psDEWizardForm);
      }

      if (this.getModelInstVer() >= 747) {
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEWIZARDLOGIC");
         Vector<PSDEWizardLogic> psDEWizardLogicList = psSysModelCache.getModelList(
            "PSDEWIZARDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxxx
         );
         if (psDEWizardLogicList == null) {
            psDEWizardLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEWizardLogicsBySystem(strPSSystemId, psDEWizardLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体向导逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEWIZARDLOGIC",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxxx,
               psDEWizardLogicList
            );
         }

         for (PSDEWizardLogic psDEWizardLogic : psDEWizardLogicList) {
            psSystemStorage.getPSDEWizardStorage(psDEWizardLogic.getPSDEWIZARDID()).psDEWizardLogicList.add(psDEWizardLogic);
         }
      }

      boolean bLoadDetailxxx = true;
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDESERVICEAPI");
      Vector<PSDEServiceAPI> psDEServiceAPIList = psSysModelCache.getModelList("PSDESERVICEAPI", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEServiceAPIList == null) {
         psDEServiceAPIList = new Vector<>();
         CallResult callResultxx = this.getPSDEServiceAPIsBySystem(strPSSystemId, psDEServiceAPIList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体服务接口发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDESERVICEAPI", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEServiceAPIList);
      }

      for (PSDEServiceAPI psDEServiceAPI : psDEServiceAPIList) {
         PSSysServiceAPIStorage psSysServiceAPIStorage = psSystemStorage.getPSSysServiceAPIStorage(psDEServiceAPI.getPSSYSSERVICEAPIID(), false);
         if (psSysServiceAPIStorage != null) {
            psSystemStorage.getPSDataEntityStorage(psDEServiceAPI.getPSDEID()).psDEServiceAPIList.add(psDEServiceAPI);
            PSDEServiceAPIStorage psDEServiceAPIStorage = psSystemStorage.getPSDEServiceAPIStorage(psDEServiceAPI.getPSDESERVICEAPIID(), true);
            psDEServiceAPIStorage.psDEServiceAPI = psDEServiceAPI;
            psSysServiceAPIStorage.psDEServiceAPIList.add(psDEServiceAPI);
         }
      }

      boolean var178 = psDEServiceAPIList.size() > 0;
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDESARS");
      Vector<PSDESARS> psDESARSList = psSysModelCache.getModelList("PSDESARS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDESARSList == null) {
         psDESARSList = new Vector<>();
         CallResult callResultxx = this.getPSDEServiceAPIRSsBySystem(strPSSystemId, psDESARSList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体服务API关系发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDESARS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDESARSList);
      }

      for (PSDESARS psDESARS : psDESARSList) {
         PSSysServiceAPIStorage psSysServiceAPIStorage = psSystemStorage.getPSSysServiceAPIStorage(psDESARS.getPSSYSSERVICEAPIID(), false);
         if (psSysServiceAPIStorage != null) {
            psSysServiceAPIStorage.psDEServiceAPIRSList.add(psDESARS);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDESADETAIL");
      Vector<PSDESADetail> psDESADetailList = psSysModelCache.getModelList("PSDESADETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDESADetailList == null) {
         psDESADetailList = new Vector<>();
         CallResult callResultxx = this.getPSDESADetailsBySystem(strPSSystemId, psDESADetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体服务API方法错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDESADETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDESADetailList);
      }

      for (PSDESADetail psDESADetail : psDESADetailList) {
         PSDEServiceAPIStorage psDEServiceAPIStorage = psSystemStorage.getPSDEServiceAPIStorage(psDESADetail.getPSDESERVICEAPIID(), false);
         if (psDEServiceAPIStorage != null) {
            psDEServiceAPIStorage.psDESADetailList.add(psDESADetail);
         }
      }

      if (this.getModelInstVer() >= 581) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDESAVR");
         Vector<PSDESAVR> psDESAVRList = psSysModelCache.getModelList("PSDESAVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDESAVRList == null) {
            psDESAVRList = new Vector<>();
            CallResult callResultxx = this.getPSDESAVRsBySystem(strPSSystemId, psDESAVRList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体服务接口值规则错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDESAVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDESAVRList);
         }

         for (PSDESAVR psDESAVR : psDESAVRList) {
            PSDEServiceAPIStorage psDEServiceAPIStorage = psSystemStorage.getPSDEServiceAPIStorage(psDESAVR.getPSDESERVICEAPIID(), false);
            if (psDEServiceAPIStorage != null) {
               psDEServiceAPIStorage.psDESAVRList.add(psDESAVR);
            }
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATASYNC");
      Vector<PSDEDataSync> psDEDataSyncList = psSysModelCache.getModelList(
         "PSDEDATASYNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEDataSyncList == null) {
         psDEDataSyncList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataSyncsBySystem(strPSSystemId, psDEDataSyncList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据同步发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATASYNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataSyncList);
      }

      for (PSDEDataSync psDEDataSync : psDEDataSyncList) {
         psSystemStorage.getPSDataEntityStorage(psDEDataSync.getPSDEID()).psDEDataSyncList.add(psDEDataSync);
         PSDEDataSyncStorage psDEDataSyncStorage = psSystemStorage.getPSDEDataSyncStorage(psDEDataSync.getPSDEDATASYNCID());
         psDEDataSyncStorage.psDEDataSync = psDEDataSync;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDTABLEDE");
      Vector<PSSysBDTableDE> psDEBDTableList = psSysModelCache.getModelList(
         "PSSYSBDTABLEDEDEMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEBDTableList == null) {
         psDEBDTableList = new Vector<>();
         CallResult callResultxx = this.getPSDEBDTablesBySystem(strPSSystemId, psDEBDTableList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体大数据表配置发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSSYSBDTABLEDEDEMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEBDTableList
         );
      }

      for (PSSysBDTableDE psDEBDTableDE : psDEBDTableList) {
         psSystemStorage.getPSDataEntityStorage(psDEBDTableDE.getPSDEID()).psDEBDTableList.add(psDEBDTableDE);
      }

      if (this.getModelInstVer() >= 611) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSEARCHDE");
         Vector<PSSysSearchDE> psDESearchList = psSysModelCache.getModelList(
            "PSSYSSEARCHDEDEMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDESearchList == null) {
            psDESearchList = new Vector<>();
            CallResult callResultxx = this.getPSDESearchsBySystem(strPSSystemId, psDESearchList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体全文检索配置发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSSEARCHDEDEMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDESearchList
            );
         }

         for (PSSysSearchDE psDESearchDE : psDESearchList) {
            psSystemStorage.getPSDataEntityStorage(psDESearchDE.getPSDEID()).psDESearchList.add(psDESearchDE);
         }
      }

      boolean bLoadDetailxxxx = true;
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDSCHEME");
      Vector<PSSysBDScheme> psSysBDSchemeList = psSysModelCache.getModelList(
         "PSSYSBDSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysBDSchemeList == null) {
         psSysBDSchemeList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysBDSchemes2(strPSSystemId, psSysBDSchemeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有大数据架构发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSSYSBDSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDSchemeList
         );
      }

      psSystemStorage.psSysBDSchemeList.addAll(psSysBDSchemeList);

      for (PSSysBDScheme psSysBDScheme : psSysBDSchemeList) {
         psSystemStorage.psSysBDSchemeMap.put(psSysBDScheme.getPSSYSBDSCHEMEID(), psSysBDScheme);
         psSystemStorage.getPSSysBDSchemeStorage(psSysBDScheme.getPSSYSBDSCHEMEID()).psSysBDScheme = psSysBDScheme;
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDMODULE");
         Vector<PSSysBDModule> psSysBDModuleList = psSysModelCache.getModelList(
            "PSSYSBDMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDModuleList == null) {
            psSysBDModuleList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDModulesBySystem(strPSSystemId, psSysBDModuleList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构模块发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDMODULE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDModuleList
            );
         }

         for (PSSysBDModule psSysBDModule : psSysBDModuleList) {
            psSystemStorage.getPSSysBDSchemeStorage(psSysBDModule.getPSSYSBDSCHEMEID()).psSysBDModuleList.add(psSysBDModule);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDPART");
         Vector<PSSysBDPart> psSysBDPartList = psSysModelCache.getModelList(
            "PSSYSBDPART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDPartList == null) {
            psSysBDPartList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDPartsBySystem(strPSSystemId, psSysBDPartList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构分区发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDPART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDPartList
            );
         }

         for (PSSysBDPart psSysBDPart : psSysBDPartList) {
            psSystemStorage.getPSSysBDSchemeStorage(psSysBDPart.getPSSYSBDSCHEMEID()).psSysBDPartList.add(psSysBDPart);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDTABLE");
         Vector<PSSysBDTable> psSysBDTableList = psSysModelCache.getModelList(
            "PSSYSBDTABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDTableList == null) {
            psSysBDTableList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDTablesBySystem(strPSSystemId, psSysBDTableList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构数据表发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDTABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDTableList
            );
         }

         for (PSSysBDTable psSysBDTable : psSysBDTableList) {
            psSystemStorage.getPSSysBDSchemeStorage(psSysBDTable.getPSSYSBDSCHEMEID()).psSysBDTableList.add(psSysBDTable);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDTABLERS");
         Vector<PSSysBDTableRS> psSysBDTableRSList = psSysModelCache.getModelList(
            "PSSYSBDTABLERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDTableRSList == null) {
            psSysBDTableRSList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDTableRSesBySystem(strPSSystemId, psSysBDTableRSList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据表关系发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDTABLERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDTableRSList
            );
         }

         for (PSSysBDTableRS psSysBDTableRS : psSysBDTableRSList) {
            psSystemStorage.getPSSysBDSchemeStorage(psSysBDTableRS.getPSSYSBDSCHEMEID()).psSysBDTableRSList.add(psSysBDTableRS);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDCOLSET");
         Vector<PSSysBDColSet> psSysBDColSetList = psSysModelCache.getModelList(
            "PSSYSBDCOLSET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDColSetList == null) {
            psSysBDColSetList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDColSetsBySystem(strPSSystemId, psSysBDColSetList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构列族发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDCOLSET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDColSetList
            );
         }

         for (PSSysBDColSet psSysBDColSet : psSysBDColSetList) {
            psSystemStorage.getPSSysBDTableStorage(psSysBDColSet.getPSSYSBDTABLEID()).psSysBDColSetList.add(psSysBDColSet);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDTABLEDE");
         Vector<PSSysBDTableDE> psSysBDTableDEList = psSysModelCache.getModelList(
            "PSSYSBDTABLEDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDTableDEList == null) {
            psSysBDTableDEList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDTableDEsBySystem(strPSSystemId, psSysBDTableDEList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构数据表实体发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDTABLEDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDTableDEList
            );
         }

         for (PSSysBDTableDE psSysBDTableDE : psSysBDTableDEList) {
            psSystemStorage.getPSSysBDTableStorage(psSysBDTableDE.getPSSYSBDTABLEID()).psSysBDTableDEList.add(psSysBDTableDE);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDTABLEDER");
         Vector<PSSysBDTableDER> psSysBDTableDERList = psSysModelCache.getModelList(
            "PSSYSBDTABLEDER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDTableDERList == null) {
            psSysBDTableDERList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDTableDERsBySystem(strPSSystemId, psSysBDTableDERList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构数据表实体发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDTABLEDER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDTableDERList
            );
         }

         for (PSSysBDTableDER psSysBDTableDER : psSysBDTableDERList) {
            psSystemStorage.getPSSysBDTableStorage(psSysBDTableDER.getPSSYSBDTABLEID()).psSysBDTableDERList.add(psSysBDTableDER);
         }
      }

      if (bLoadDetailxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSBDCOLUMN");
         Vector<PSSysBDColumn> psSysBDColumnList = psSysModelCache.getModelList(
            "PSSYSBDCOLUMN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysBDColumnList == null) {
            psSysBDColumnList = new Vector<>();
            CallResult callResultxx = this.getPSSysBDColumnsBySystem(strPSSystemId, psSysBDColumnList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有大数据架构数据列发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSBDCOLUMN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysBDColumnList
            );
         }

         for (PSSysBDColumn psSysBDColumn : psSysBDColumnList) {
            psSystemStorage.getPSSysBDTableStorage(psSysBDColumn.getPSSYSBDTABLEID()).psSysBDColumnList.add(psSysBDColumn);
         }
      }

      boolean bLoadDetailxxxxx = true;
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDBSCHEME");
      Vector<PSSysDBScheme> psSysDBSchemeList = psSysModelCache.getModelList(
         "PSSYSDBSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysDBSchemeList == null) {
         psSysDBSchemeList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDBSchemes2(strPSSystemId, psSysDBSchemeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有关系数据库架构发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSSYSDBSCHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDBSchemeList
         );
      }

      psSystemStorage.psSysDBSchemeList.addAll(psSysDBSchemeList);

      for (PSSysDBScheme psSysDBScheme : psSysDBSchemeList) {
         psSystemStorage.psSysDBSchemeMap.put(psSysDBScheme.getPSSYSDBSCHEMEID(), psSysDBScheme);
         psSystemStorage.getPSSysDBSchemeStorage(psSysDBScheme.getPSSYSDBSCHEMEID()).psSysDBScheme = psSysDBScheme;
      }

      if (bLoadDetailxxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDBTABLE");
         Vector<PSSysDBTable> psSysDBTableList = psSysModelCache.getModelList(
            "PSSYSDBTABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysDBTableList == null) {
            psSysDBTableList = new Vector<>();
            CallResult callResultxx = this.getPSSysDBTablesBySystem(strPSSystemId, psSysDBTableList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有关系数据库架构数据表发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSDBTABLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDBTableList
            );
         }

         for (PSSysDBTable psSysDBTable : psSysDBTableList) {
            psSystemStorage.getPSSysDBSchemeStorage(psSysDBTable.getPSSYSDBSCHEMEID()).psSysDBTableList.add(psSysDBTable);
         }
      }

      if (bLoadDetailxxxxx) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDBCOLUMN");
         Vector<PSSysDBColumn> psSysDBColumnList = psSysModelCache.getModelList(
            "PSSYSDBCOLUMN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psSysDBColumnList == null) {
            psSysDBColumnList = new Vector<>();
            CallResult callResultxx = this.getPSSysDBColumnsBySystem(strPSSystemId, psSysDBColumnList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有关系数据库架构数据列发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSDBCOLUMN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDBColumnList
            );
         }

         for (PSSysDBColumn psSysDBColumn : psSysDBColumnList) {
            psSystemStorage.getPSSysDBTableStorage(psSysDBColumn.getPSSYSDBTABLEID()).psSysDBColumnList.add(psSysDBColumn);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEACTIONWIZARD");
      boolean bLoadDetailxxxxxx = true;
      Vector<PSDEActionWizard> psDEActionWizardList = psSysModelCache.getModelList(
         "PSDEACTIONWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEActionWizardList == null) {
         psDEActionWizardList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionWizardsBySystem(strPSSystemId, psDEActionWizardList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体操作向导发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEACTIONWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEActionWizardList
         );
      }

      for (PSDEActionWizard psDEActionWizard : psDEActionWizardList) {
         psSystemStorage.getPSDataEntityStorage(psDEActionWizard.getPSDEID()).psDEActionWizardList.add(psDEActionWizard);
         PSDEActionWizardStorage psDEActionWizardStorage = psSystemStorage.getPSDEActionWizardStorage(psDEActionWizard.getPSDEACTIONWIZARDID());
         psDEActionWizardStorage.psDEActionWizard = psDEActionWizard;
      }

      boolean var398 = psDEActionWizardList.size() > 0;
      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEAWITEM");
      Vector<PSDEAWItem> psDEAWItemList = psSysModelCache.getModelList(
         "PSDEAWITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxxx
      );
      if (psDEAWItemList == null) {
         psDEAWItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionWizardItemsBySystem(strPSSystemId, psDEAWItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体操作向导步骤发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEAWITEM",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxx,
            psDEAWItemList
         );
      }

      for (PSDEAWItem psDEActionWizardItem : psDEAWItemList) {
         psSystemStorage.getPSDEActionWizardStorage(psDEActionWizardItem.getPSDEACTIONWIZARDID()).psDEActionWizardItemList.add(psDEActionWizardItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEAWGROUP");
      boolean bLoadDetailxxxxxxx = true;
      Vector<PSDEAWGroup> psDEAWGroupList = psSysModelCache.getModelList(
         "PSDEAWGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEAWGroupList == null) {
         psDEAWGroupList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionWizardGroupsBySystem(strPSSystemId, psDEAWGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体操作向导组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEAWGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEAWGroupList
         );
      }

      for (PSDEAWGroup psDEAWGroup : psDEAWGroupList) {
         psSystemStorage.getPSDataEntityStorage(psDEAWGroup.getPSDEID()).psDEAWGroupList.add(psDEAWGroup);
         PSDEActionWizardGroupStorage psDEAWGroupStorage = psSystemStorage.getPSDEActionWizardGroupStorage(psDEAWGroup.getPSDEAWGROUPID());
         psDEAWGroupStorage.psDEAWGroup = psDEAWGroup;
      }

      boolean var400 = psDEAWGroupList.size() > 0;
      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEAWGRPDETAIL");
      Vector<PSDEAWGrpDetail> psDEAWGrpDetailList = psSysModelCache.getModelList(
         "PSDEAWGRPDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxxxx
      );
      if (psDEAWGrpDetailList == null) {
         psDEAWGrpDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEActionWizardGroupDetailsBySystem(strPSSystemId, psDEAWGrpDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体操作向导组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEAWGRPDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxx,
            psDEAWGrpDetailList
         );
      }

      for (PSDEAWGrpDetail psDEAWGroupItem : psDEAWGrpDetailList) {
         psSystemStorage.getPSDEActionWizardGroupStorage(psDEAWGroupItem.getPSDEAWGROUPID()).psDEAWGrpDetailList.add(psDEAWGroupItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWORKFLOW");
      Vector<PSWorkflow> psWorkflowList = psSysModelCache.getModelList(
         "PSWORKFLOW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWorkflowList == null) {
         psWorkflowList = new Vector<>();
         CallResult callResultxx = this.getAllPSWorkflows2(strPSSystemId, psWorkflowList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有工作流发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWORKFLOW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWorkflowList);
      }

      for (PSWorkflow psWorkflow : psWorkflowList) {
         psSystemStorage.psWorkflowList.add(psWorkflow);
         PSWorkflowStorage psWorkflowStorage = psSystemStorage.getPSWorkflowStorage(psWorkflow.getPSWORKFLOWID());
         psWorkflowStorage.psWorkflow = psWorkflow;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSWFVERSION");
      Vector<PSWFVersion> psWFVersionList = psSysModelCache.getModelList(
         "PSWFVERSION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFVersionList == null) {
         psWFVersionList = new Vector<>();
         CallResult callResultxx = this.getPSWFVersionsBySystem(strPSSystemId, psWFVersionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有工作流版本发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFVERSION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFVersionList
         );
      }

      for (PSWFVersion psWFVersion : psWFVersionList) {
         psSystemStorage.getPSWorkflowStorage(psWFVersion.getPSWFID()).psWFVersionList.add(psWFVersion);
         PSWFVersionStorage psWFVersionStorage = psSystemStorage.getPSWFVersionStorage(psWFVersion.getPSWFVERSIONID());
         psWFVersionStorage.psWFVersion = psWFVersion;
      }

      Vector<PSWFProcess> psWFProcessList = psSysModelCache.getModelList(
         "PSWFPROCESS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFProcessList == null) {
         psWFProcessList = new Vector<>();
         CallResult callResultxx = this.getPSWFProcessesBySystem(strPSSystemId, psWFProcessList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本处理发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFPROCESS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFProcessList
         );
      }

      for (PSWFProcess psProcess : psWFProcessList) {
         psSystemStorage.getPSWFVersionStorage(psProcess.getPSWFVERSIONID()).psWFProcessList.add(psProcess);
      }

      Vector<PSWFProcParam> psWFProcParamList = psSysModelCache.getModelList(
         "PSWFPROCPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFProcParamList == null) {
         psWFProcParamList = new Vector<>();
         CallResult callResultxx = this.getPSWFProcParamsBySystem(strPSSystemId, psWFProcParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本处理参数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFPROCPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFProcParamList
         );
      }

      for (PSWFProcParam psProcParam : psWFProcParamList) {
         psSystemStorage.getPSWFVersionStorage(psProcParam.getParamStringValue("PSWFVERSIONID", "")).psWFProcParamList.add(psProcParam);
      }

      Vector<PSWFProcRole> psWFProcRoleList = psSysModelCache.getModelList(
         "PSWFPROCROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFProcRoleList == null) {
         psWFProcRoleList = new Vector<>();
         CallResult callResultxx = this.getPSWFProcRolesBySystem(strPSSystemId, psWFProcRoleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本处理角色发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFPROCROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFProcRoleList
         );
      }

      for (PSWFProcRole psProcRole : psWFProcRoleList) {
         psSystemStorage.getPSWFVersionStorage(psProcRole.getParamStringValue("PSWFVERSIONID", "")).psWFProcRoleList.add(psProcRole);
      }

      Vector<PSWFLinkRole> psWFLinkRoleList = psSysModelCache.getModelList(
         "PSWFLINKROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFLinkRoleList == null) {
         psWFLinkRoleList = new Vector<>();
         CallResult callResultxx = this.getPSWFLinkRolesBySystem(strPSSystemId, psWFLinkRoleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本连接角色发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFLINKROLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFLinkRoleList
         );
      }

      for (PSWFLinkRole psLinkRole : psWFLinkRoleList) {
         psSystemStorage.getPSWFVersionStorage(psLinkRole.getParamStringValue("PSWFVERSIONID", "")).psWFLinkRoleList.add(psLinkRole);
      }

      Vector<PSWFProcSubWF> psWFProcSubWFList = psSysModelCache.getModelList(
         "PSWFPROCSUBWF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFProcSubWFList == null) {
         psWFProcSubWFList = new Vector<>();
         CallResult callResultxx = this.getPSWFProcSubWFsBySystem(strPSSystemId, psWFProcSubWFList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本处理子流程发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFPROCSUBWF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFProcSubWFList
         );
      }

      for (PSWFProcSubWF psProcSubWF : psWFProcSubWFList) {
         psSystemStorage.getPSWFVersionStorage(psProcSubWF.getParamStringValue("PSWFVERSIONID", "")).psWFProcSubWFList.add(psProcSubWF);
      }

      Vector<PSWFLink> psWFLinkList = psSysModelCache.getModelList(
         "PSWFLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFLinkList == null) {
         psWFLinkList = new Vector<>();
         CallResult callResultxx = this.getPSWFLinksBySystem(strPSSystemId, psWFLinkList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFLinkList);
      }

      for (PSWFLink psLink : psWFLinkList) {
         psSystemStorage.getPSWFVersionStorage(psLink.getPSWFVERSIONID()).psWFLinkList.add(psLink);
      }

      Vector<PSWFLinkCond> psWFLinkCondList = psSysModelCache.getModelList(
         "PSWFLINKCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psWFLinkCondList == null) {
         psWFLinkCondList = new Vector<>();
         CallResult callResultxx = this.getPSWFLinkCondsBySystem(strPSSystemId, psWFLinkCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本连接条件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFLINKCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psWFLinkCondList
         );
      }

      for (PSWFLinkCond psLinkCond : psWFLinkCondList) {
         psSystemStorage.getPSWFVersionStorage(psLinkCond.getPSWFVERSIONID()).psWFLinkCondList.add(psLinkCond);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListxx = psSysModelCache.getModelList(
         "PSWFUIACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionListxx == null) {
         psDEUIActionListxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionsBySystem(strPSSystemId, psDEUIActionListxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFUIACTION", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionListxx
         );
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListxx) {
         psSystemStorage.getPSWFVersionStorage(psDEUIAction.getPSWFVERSIONID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListxx = psSysModelCache.getModelList(
         "PSWFUIACTIONGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionGroupListxx == null) {
         psDEUIActionGroupListxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupListxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFUIACTIONGROUP", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionGroupListxx
         );
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListxx) {
         psSystemStorage.getPSWFVersionStorage(psDEUIActionGroup.getPSWFVERSIONID()).psDEUIActionGroupList.add(psDEUIActionGroup);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListxxx = psSysModelCache.getModelList(
         "PSWFUIACTION2", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionListxxx == null) {
         psDEUIActionListxxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActions2BySystem(strPSSystemId, psDEUIActionListxxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFUIACTION2", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionListxxx
         );
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListxxx) {
         psSystemStorage.getPSWorkflowStorage(psDEUIAction.getPSWFID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListxxx = psSysModelCache.getModelList(
         "PSWFUIACTIONGROUP2", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionGroupListxxx == null) {
         psDEUIActionGroupListxxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionGroups2BySystem(strPSSystemId, psDEUIActionGroupListxxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSWFUIACTIONGROUP2", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEUIActionGroupListxxx
         );
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListxxx) {
         psSystemStorage.getPSWorkflowStorage(psDEUIActionGroup.getPSWFID()).psDEUIActionGroupList.add(psDEUIActionGroup);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGRPDETAIL");
      Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = psSysModelCache.getModelList(
         "PSDEUAGRPDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxxxxxxxxxxx
      );
      if (psDEUIActionGroupDetailList == null) {
         psDEUIActionGroupDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionGroupDetailsBySystem(strPSSystemId, psDEUIActionGroupDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部界面行为组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEUAGRPDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxxx,
            psDEUIActionGroupDetailList
         );
      }

      for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
         psSystemStorage.getPSDEUIActionGroupStorage(psDEUIActionGroupDetail.getPSDEUAGROUPID()).psDEUIActionGroupDetailList.add(psDEUIActionGroupDetail);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFGROUP");
      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFGROUPDETAIL");
      Vector<PSDEFGroupDetail> psDEFGroupDetailList = psSysModelCache.getModelList(
         "PSDEFGROUPDETAIL",
         psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
         psSysModelLog2xxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEFGroupDetailList == null) {
         psDEFGroupDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEFGroupDetailsBySystem(strPSSystemId, psDEFGroupDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部属性组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEFGROUPDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxxxx,
            psDEFGroupDetailList
         );
      }

      for (PSDEFGroupDetail psDEFGroupDetail : psDEFGroupDetailList) {
         psSystemStorage.getPSDEFGroupStorage(psDEFGroupDetail.getPSDEFGROUPID()).psDEFGroupDetailList.add(psDEFGroupDetail);
      }

      PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFORMDETAIL");
      if (psSysModelLog2xxxxxxxxxxxxxxxxxxxxxx == null) {
         psSysModelLog2xxxxxxxxxxxxxxxxxxxxxx = psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
      }

      Vector<PSDEFormDetail> psDEFGroupItemList = psSysModelCache.getModelList("PSDEFGROUPITEM", psSysModelLog2xxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFGroupItemList == null) {
         psDEFGroupItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEFGroupItemsBySystem(strPSSystemId, psDEFGroupItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体属性组成员项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFGROUPITEM", psSysModelLog2xxxxxxxxxxxxxxxxxxxxxx, psDEFGroupItemList);
      }

      for (PSDEFormDetail psDEFormDetail : psDEFGroupItemList) {
         psSystemStorage.getPSDEFGroupStorage(psDEFormDetail.getParamStringValue("PSDEFGROUPID", "")).psDEFormDetailList.add(psDEFormDetail);
      }

      if (this.getModelInstVer() >= 810) {
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGRIDCOL");
         if (psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx == null) {
            psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
         }

         Vector<PSDEGridColumn> psDEFGroupColumnList = psSysModelCache.getModelList("PSDEFGROUPCOLUMN", psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFGroupColumnList == null) {
            psDEFGroupColumnList = new Vector<>();
            CallResult callResultxx = this.getPSDEFGroupColumnsBySystem(strPSSystemId, psDEFGroupColumnList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有实体属性组成员项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFGROUPCOLUMN", psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx, psDEFGroupColumnList);
         }

         for (PSDEGridColumn psDEGridColumn : psDEFGroupColumnList) {
            psSystemStorage.getPSDEFGroupStorage(psDEGridColumn.getParamStringValue("PSDEFGROUPID", "")).psDEGridColumnList.add(psDEGridColumn);
         }
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGROUP");
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGROUPDETAIL");
         Vector<PSDEGroupDetail> psDEGroupDetailList = psSysModelCache.getModelList(
            "PSDEGROUPDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEGroupDetailList == null) {
            psDEGroupDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEGroupDetailsBySystem(strPSSystemId, psDEGroupDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统全部实体组成员发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEGROUPDETAIL",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx,
               psDEGroupDetailList
            );
         }

         for (PSDEGroupDetail psDEGroupDetail : psDEGroupDetailList) {
            psSystemStorage.getPSDEGroupStorage(psDEGroupDetail.getPSDEGROUPID()).psDEGroupDetailList.add(psDEGroupDetail);
         }
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDERGROUP");
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDERGROUPDETAIL");
         Vector<PSDERGroupDetail> psDERGroupDetailList = psSysModelCache.getModelList(
            "PSDERGROUPDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDERGroupDetailList == null) {
            psDERGroupDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDERGroupDetailsBySystem(strPSSystemId, psDERGroupDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统全部实体关系组成员发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDERGROUPDETAIL",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx,
               psDERGroupDetailList
            );
         }

         for (PSDERGroupDetail psDERGroupDetail : psDERGroupDetailList) {
            psSystemStorage.getPSDERGroupStorage(psDERGroupDetail.getPSDERGROUPID()).psDERGroupDetailList.add(psDERGroupDetail);
         }
      }

      if (this.getModelInstVer() >= 591) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get(
            "PSDEACTIONGROUP"
         );
         PSSysModelLog psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEAGDETAIL");
         Vector<PSDEAGDetail> psDEAGDetailList = psSysModelCache.getModelList(
            "PSDEAGDETAIL",
            psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
            psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEAGDetailList == null) {
            psDEAGDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEActionGroupDetailsBySystem(strPSSystemId, psDEAGDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统全部行为组成员发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEAGDETAIL",
               psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
               psSysModelLog2xxxxxxxxxxxxxxxxxxxxxxx,
               psDEAGDetailList
            );
         }

         for (PSDEAGDetail psDEActionGroupDetail : psDEAGDetailList) {
            psSystemStorage.getPSDEActionGroupStorage(psDEActionGroupDetail.getPSDEACTIONGROUPID()).psDEActionGroupDetailList.add(psDEActionGroupDetail);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFINPUTTIPSET");
      Vector<PSDEFInputTipSet> psDEFInputTipSetList = psSysModelCache.getModelList(
         "PSDEFINPUTTIPSET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDEFInputTipSetList == null) {
         psDEFInputTipSetList = new Vector<>();
         CallResult callResultxx = this.getAllPSDEFInputTipSets2(strPSSystemId, psDEFInputTipSetList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有属性输入提示集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEFINPUTTIPSET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFInputTipSetList
         );
      }

      psSystemStorage.psDEFInputTipSetList.addAll(psDEFInputTipSetList);

      for (PSDEFInputTipSet psDEFInputTipSet : psDEFInputTipSetList) {
         psSystemStorage.psDEFInputTipSetMap.put(psDEFInputTipSet.getPSDEFINPUTTIPSETID(), psDEFInputTipSet);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUNISTATE");
      Vector<PSSysUniState> psSysUniStateList = psSysModelCache.getModelList(
         "PSSYSUNISTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysUniStateList == null) {
         psSysUniStateList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUniStates2(strPSSystemId, psSysUniStateList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统统一状态协同对象发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSSYSUNISTATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUniStateList
         );
      }

      psSystemStorage.psSysUniStateList.addAll(psSysUniStateList);

      for (PSSysUniState psSysUniState : psSysUniStateList) {
         psSystemStorage.psSysUniStateMap.put(psSysUniState.getPSSYSUNISTATEID(), psSysUniState);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDTSQUEUE");
      Vector<PSSysDTSQueue> psSysDTSQueueList = psSysModelCache.getModelList(
         "PSDEDTSQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysDTSQueueList == null) {
         psSysDTSQueueList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysDTSQueues2(strPSSystemId, psSysDTSQueueList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统分布事务队列对象发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSDEDTSQUEUE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDTSQueueList
         );
      }

      psSystemStorage.psSysDTSQueueList.addAll(psSysDTSQueueList);

      for (PSSysDTSQueue psSysDTSQueue : psSysDTSQueueList) {
         psSystemStorage.psSysDTSQueueMap.put(psSysDTSQueue.getPSDEDTSQUEUEID(), psSysDTSQueue);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSUTILDE");
      Vector<PSSysUtil> psSysUtilList = psSysModelCache.getModelList(
         "PSSYSUTILDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psSysUtilList == null) {
         psSysUtilList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysUtils2(strPSSystemId, psSysUtilList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有系统实体功能配置对象发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList(
            "PSSYSUTILDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysUtilList
         );
      }

      psSystemStorage.psSysUtilList.addAll(psSysUtilList);

      for (PSSysUtil psSysUtil : psSysUtilList) {
         psSystemStorage.psSysUtilMap.put(psSysUtil.getPSSYSUTILDEID(), psSysUtil);
      }

      if (this.getModelInstVer() >= 787) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFORM");
         Vector<PSDEForm> psDEFormListx = psSysModelCache.getModelList(
            "PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEFormListx == null) {
            psDEFormListx = new Vector<>();
            CallResult callResultxx = this.getPSDEFormsBySystem(strPSSystemId, psDEFormListx);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体表单发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormListx
            );
         }

         for (PSDEForm psDEForm : psDEFormListx) {
            psSystemStorage.getPSDEFormStorage(psDEForm.getPSDEFORMID()).psDEForm = psDEForm;
         }

         Vector<PSDEFormDetail> psDEFormDetailList = psSysModelCache.getModelList(
            "PSDEFORMDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEFormDetailList == null) {
            psDEFormDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEFormDetailsBySystem(strPSSystemId, psDEFormDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体表单项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEFORMDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormDetailList
            );
         }

         for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            psSystemStorage.getPSDEFormStorage(psDEFormDetail.getPSDEFORMID()).psDEFormDetailList.add(psDEFormDetail);
         }

         Vector<PSDEFDLogic> psDEFDLogicList = psSysModelCache.getModelList(
            "PSDEFDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEFDLogicList == null) {
            psDEFDLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEFDLogicsBySystem(strPSSystemId, psDEFDLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单项逻发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSDEFDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFDLogicList
            );
         }

         for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            psSystemStorage.getPSDEFormStorage(psDEFDLogic.getParamStringValue("PSDEFORMID", "")).psDEFDLogicList.add(psDEFDLogic);
         }
      }

      log.info(StringHelper.Format("预载系统[%1$s]耗时[%2$s]ms", strPSSystemId, System.currentTimeMillis() - nBeginTime));
      return psSystemStorage;
   }

   protected synchronized PSSystemStorage getCurrentPSSystemStorage() {
      ArrayList<PSSystemStorage> stack = this.psSystemStorageStack.get();
      return stack != null && stack.size() != 0 ? stack.get(0) : null;
   }

   @Override
   public synchronized void stopLoadPSSystem() throws Exception {
      this.active();
      ArrayList<PSSystemStorage> stack = this.psSystemStorageStack.get();
      if (stack != null && stack.size() != 0) {
         stack.remove(0);
      }
   }

   protected PSSysAppStorage createPSSysAppStorage(String strPSSysAppId, int nLoadLevel) throws Exception {
      long nBeginTime = System.currentTimeMillis();
      PSSysAppStorage psSysAppStorage = new PSSysAppStorage();
      psSysAppStorage.strPSSysAppId = strPSSysAppId;
      psSysAppStorage.nLoadLevel = nLoadLevel;
      PSSysModelCache psSysModelCache = this.getPSSysModelCache("APP:" + strPSSysAppId);
      HashMap<String, PSSysModelLog> psSysModelLogMap = new HashMap<>();
      PSSystemApplication psSystemApplication = new PSSystemApplication();
      CallResult callResult = this.getPSSystemApplication(strPSSysAppId, psSystemApplication);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询系统应用发生错误，%1$s", callResult.getErrorInfo()));
      }

      if (psSystemApplication.getCREATEDATE() != null) {
         String strModelCacheTag = DateHelper.toDateTimeString(psSystemApplication.getCREATEDATE());
         if (!StringHelper.IsNullOrEmpty(psSysModelCache.getCacheTag()) && StringHelper.Compare(psSysModelCache.getCacheTag(), strModelCacheTag, false) != 0) {
            this.resetCache();
            psSysModelCache = this.getPSSysModelCache("APP:" + strPSSysAppId);
         }

         psSysModelCache.setCacheTag(strModelCacheTag);
      } else {
         log.warn(StringHelper.Format("系统应用[%1$s]建立时间为空", strPSSysAppId));
      }

      String strPSSystemId = psSystemApplication.getPSSYSTEMID();
      Vector<PSSysModelLog> psSysModelLogList = new Vector<>();
      CallResult callResultx = this.getPSSysModelLogs(psSystemApplication.getPSSYSTEMID(), psSysModelLogList);
      if (callResultx.isError()) {
         throw new Exception(StringHelper.Format("查询系统模型日志发生错误，%1$s", callResultx.getErrorInfo()));
      }

      for (PSSysModelLog psSysModelLog : psSysModelLogList) {
         if (!psSysModelLogMap.containsKey(psSysModelLog.getPSSYSMODELLOGNAME())) {
            psSysModelLogMap.put(psSysModelLog.getPSSYSMODELLOGNAME(), psSysModelLog);
         }
      }

      PSSysModelLog psSysModelLog = psSysModelLogMap.get("PSDATAENTITY");
      Vector<PSDataEntity> psDataEntityList = psSysModelCache.getModelList("PSDATAENTITY", psSysModelLog);
      if (psDataEntityList == null) {
         psDataEntityList = new Vector<>();
         CallResult callResultxx = this.getAllPSDataEntities2(psSystemApplication.getPSSYSTEMID(), psDataEntityList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDATAENTITY", psSysModelLog, psDataEntityList);
      }

      for (PSDataEntity psDataEntity : psDataEntityList) {
         psSysAppStorage.psDataEntityMap.put(psDataEntity.getPSDATAENTITYID(), psDataEntity);
      }

      PSSysModelLog psSysModelLogx = psSysModelLogMap.get("PSDELOGIC");
      Vector<PSDELogic> psDELogicList = psSysModelCache.getModelList("PSDELOGIC", psSysModelLogx);
      if (psDELogicList == null) {
         psDELogicList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGIC", psSysModelLogx, psDELogicList);
      }

      for (PSDELogic psDELogic : psDELogicList) {
         psSysAppStorage.getPSDataEntityStorage(psDELogic.getPSDEID()).psDELogicList.add(psDELogic);
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogic.getPSDELOGICID());
         psDELogicStorage.psDELogic = psDELogic;
      }

      Vector<PSDELogicParam> psDELogicParamList = psSysModelCache.getModelList("PSDELOGICPARAM", psSysModelLogx);
      if (psDELogicParamList == null) {
         psDELogicParamList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicParamsBySystem(strPSSystemId, psDELogicParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑参数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICPARAM", psSysModelLogx, psDELogicParamList);
      }

      for (PSDELogicParam psDELogicParam : psDELogicParamList) {
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicParam.getPSDELOGICID());
         psDELogicStorage.psDELogicParamList.add(psDELogicParam);
      }

      Vector<PSDELogicNode> psDELogicNodeList = psSysModelCache.getModelList("PSDELOGICNODE", psSysModelLogx);
      if (psDELogicNodeList == null) {
         psDELogicNodeList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicNodesBySystem(strPSSystemId, psDELogicNodeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑节点发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICNODE", psSysModelLogx, psDELogicNodeList);
      }

      for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicNode.getPSDELOGICID());
         psDELogicStorage.psDELogicNodeList.add(psDELogicNode);
      }

      Vector<PSDELogicLink> psDELogicLinkList = psSysModelCache.getModelList("PSDELOGICLINK", psSysModelLogx);
      if (psDELogicLinkList == null) {
         psDELogicLinkList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicLinksBySystem(strPSSystemId, psDELogicLinkList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELOGICLINK", psSysModelLogx, psDELogicLinkList);
      }

      for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicLink.getPSDELOGICID());
         psDELogicStorage.psDELogicLinkList.add(psDELogicLink);
      }

      Vector<PSDELogicNodeParam> psDELogicNodeParamList = psSysModelCache.getModelList("PSDELNPARAM", psSysModelLogx);
      if (psDELogicNodeParamList == null) {
         psDELogicNodeParamList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicNodeParamsBySystem(strPSSystemId, psDELogicNodeParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑节点参数连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELNPARAM", psSysModelLogx, psDELogicNodeParamList);
      }

      for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicNodeParam.getPSDELOGICID());
         psDELogicStorage.psDELogicNodeParamList.add(psDELogicNodeParam);
      }

      Vector<PSDELogicLinkCond> psDELogicLinkCondList = psSysModelCache.getModelList("PSDELLCOND", psSysModelLogx);
      if (psDELogicLinkCondList == null) {
         psDELogicLinkCondList = new Vector<>();
         CallResult callResultxx = this.getPSDELogicLinkCondsBySystem(strPSSystemId, psDELogicLinkCondList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体逻辑连接条件连接发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELLCOND", psSysModelLogx, psDELogicLinkCondList);
      }

      for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
         PSDELogicStorage psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicLinkCond.getPSDELOGICID());
         psDELogicStorage.psDELogicLinkCondList.add(psDELogicLinkCond);
      }

      PSSysModelLog psSysModelLogxx = psSysModelLogMap.get("PSDEACMODE");
      Vector<PSDEACMode> psDEACModeList = psSysModelCache.getModelList("PSDEACMODE", psSysModelLogxx);
      if (psDEACModeList == null) {
         psDEACModeList = new Vector<>();
         CallResult callResultxx = this.getPSDEACModesBySystem(strPSSystemId, psDEACModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体自填模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACMODE", psSysModelLogxx, psDEACModeList);
      }

      for (PSDEACMode psDEACMode : psDEACModeList) {
         psSysAppStorage.getPSDataEntityStorage(psDEACMode.getPSDEID()).psDEACModeList.add(psDEACMode);
         PSDEACModeStorage psDEACModeStorage = psSysAppStorage.getPSDEACModeStorage(psDEACMode.getPSDEACMODEID());
         psDEACModeStorage.psDEACMode = psDEACMode;
      }

      PSSysModelLog psSysModelLog2 = psSysModelLogMap.get("PSDEACMODEITEM");
      Vector<PSDEACModeItem> psDEACModeItemList = psSysModelCache.getModelList("PSDEACMODEITEM", psSysModelLogxx, psSysModelLog2);
      if (psDEACModeItemList == null) {
         psDEACModeItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEACModeItemsBySystem(strPSSystemId, psDEACModeItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体自填数据项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEACMODEITEM", psSysModelLogxx, psSysModelLog2, psDEACModeItemList);
      }

      for (PSDEACModeItem psDEACModeItem : psDEACModeItemList) {
         PSDEACModeStorage psDEACModeStorage = psSysAppStorage.getPSDEACModeStorage(psDEACModeItem.getPSDEACMODEID());
         psDEACModeStorage.psDEACModeItemList.add(psDEACModeItem);
      }

      PSSysModelLog psSysModelLogxxx = psSysModelLogMap.get("PSDEMAP");
      Vector<PSDEMap> psDEMapList = psSysModelCache.getModelList("PSDEMAP", psSysModelLogxxx);
      if (psDEMapList == null) {
         psDEMapList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapsBySystem(strPSSystemId, psDEMapList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAP", psSysModelLogxxx, psDEMapList);
      }

      for (PSDEMap psDEMap : psDEMapList) {
         psSysAppStorage.getPSDataEntityStorage(psDEMap.getPSDEID()).psDEMapList.add(psDEMap);
         PSDEMapStorage psDEMapStorage = psSysAppStorage.getPSDEMapStorage(psDEMap.getPSDEMAPID());
         psDEMapStorage.psDEMap = psDEMap;
      }

      PSSysModelLog psSysModelLog2x = psSysModelLogMap.get("PSDEMAPDETAIL");
      Vector<PSDEMapDetail> psDEMapDetailList = psSysModelCache.getModelList("PSDEMAPDETAIL", psSysModelLogxxx, psSysModelLog2x);
      if (psDEMapDetailList == null) {
         psDEMapDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDetailsBySystem(strPSSystemId, psDEMapDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDETAIL", psSysModelLogxxx, psSysModelLog2x, psDEMapDetailList);
      }

      for (PSDEMapDetail psDEMapDetail : psDEMapDetailList) {
         psSysAppStorage.getPSDEMapStorage(psDEMapDetail.getPSDEMAPID()).psDEMapDetailList.add(psDEMapDetail);
      }

      PSSysModelLog psSysModelLog2xx = psSysModelLogMap.get("PSDEMAPACTION");
      Vector<PSDEMapAction> psDEMapActionList = psSysModelCache.getModelList("PSDEMAPACTION", psSysModelLogxxx, psSysModelLog2xx);
      if (psDEMapActionList == null) {
         psDEMapActionList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapActionsBySystem(strPSSystemId, psDEMapActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPACTION", psSysModelLogxxx, psSysModelLog2xx, psDEMapActionList);
      }

      for (PSDEMapAction psDEMapAction : psDEMapActionList) {
         psSysAppStorage.getPSDEMapStorage(psDEMapAction.getPSDEMAPID()).psDEMapActionList.add(psDEMapAction);
      }

      PSSysModelLog psSysModelLog2xxx = psSysModelLogMap.get("PSDEMAPDQ");
      Vector<PSDEMapDataQuery> psDEMapDataQueryList = psSysModelCache.getModelList("PSDEMAPDQ", psSysModelLogxxx, psSysModelLog2xxx);
      if (psDEMapDataQueryList == null) {
         psDEMapDataQueryList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDataQueriesBySystem(strPSSystemId, psDEMapDataQueryList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射查询发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDQ", psSysModelLogxxx, psSysModelLog2xxx, psDEMapDataQueryList);
      }

      for (PSDEMapDataQuery psDEMapDataQuery : psDEMapDataQueryList) {
         psSysAppStorage.getPSDEMapStorage(psDEMapDataQuery.getPSDEMAPID()).psDEMapDataQueryList.add(psDEMapDataQuery);
      }

      PSSysModelLog psSysModelLog2xxxx = psSysModelLogMap.get("PSDEMAPDS");
      Vector<PSDEMapDataSet> psDEMapDataSetList = psSysModelCache.getModelList("PSDEMAPDS", psSysModelLogxxx, psSysModelLog2xxxx);
      if (psDEMapDataSetList == null) {
         psDEMapDataSetList = new Vector<>();
         CallResult callResultxx = this.getPSDEMapDataSetsBySystem(strPSSystemId, psDEMapDataSetList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体映射数据集合发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEMAPDS", psSysModelLogxxx, psSysModelLog2xxxx, psDEMapDataSetList);
      }

      for (PSDEMapDataSet psDEMapDataSet : psDEMapDataSetList) {
         psSysAppStorage.getPSDEMapStorage(psDEMapDataSet.getPSDEMAPID()).psDEMapDataSetList.add(psDEMapDataSet);
      }

      if (this.getModelInstVer() >= 605) {
         PSSysModelLog psSysModelLogxxxx = psSysModelLogMap.get("PSCTRLLOGICGROUP");
         Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = psSysModelCache.getModelList("PSCTRLLOGICGROUP", psSysModelLogxxxx);
         if (psCtrlLogicGroupList == null) {
            psCtrlLogicGroupList = new Vector<>();
            CallResult callResultxx = this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有界面逻辑组发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSCTRLLOGICGROUP", psSysModelLogxxxx, psCtrlLogicGroupList);
         }

         for (PSCtrlLogicGroup psCtrlLogicGroup : psCtrlLogicGroupList) {
            if (!StringHelper.IsNullOrEmpty(psCtrlLogicGroup.getPSDEID())) {
               psSysAppStorage.getPSDataEntityStorage(psCtrlLogicGroup.getPSDEID()).psCtrlLogicGroupList.add(psCtrlLogicGroup);
            } else {
               psSysAppStorage.psCtrlLogicGroupList.add(psCtrlLogicGroup);
            }

            PSCtrlLogicGroupStorage psCtrlLogicGroupStorage = psSysAppStorage.getPSCtrlLogicGroupStorage(psCtrlLogicGroup.getPSCTRLLOGICGROUPID());
            psCtrlLogicGroupStorage.psCtrlLogicGroup = psCtrlLogicGroup;
         }

         PSSysModelLog psSysModelLogxxxxx = psSysModelLogMap.get("PSCTRLLOGICGROUP");
         PSSysModelLog psSysModelLog2xxxxx = psSysModelLogMap.get("PSCTRLLOGICGRPDETAIL");
         Vector<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList = psSysModelCache.getModelList("PSCTRLLOGICGRPDETAIL", psSysModelLogxxxxx, psSysModelLog2xxxxx);
         if (psCtrlLogicGroupDetailList == null) {
            psCtrlLogicGroupDetailList = new Vector<>();
            CallResult callResultxx = this.getPSCtrlLogicGroupDetailsBySystem(strPSSystemId, psCtrlLogicGroupDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统全部实体关系组成员发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSCTRLLOGICGRPDETAIL", psSysModelLogxxxxx, psSysModelLog2xxxxx, psCtrlLogicGroupDetailList);
         }

         for (PSCtrlLogicGroupDetail psCtrlLogicGroupDetail : psCtrlLogicGroupDetailList) {
            psSysAppStorage.getPSCtrlLogicGroupStorage(psCtrlLogicGroupDetail.getPSCTRLLOGICGROUPID()).psCtrlLogicGroupDetailList.add(psCtrlLogicGroupDetail);
         }
      }

      PSSysModelLog psSysModelLogxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION:SYS", psSysModelLogxxxx);
      if (psDEUIActionList == null) {
         psDEUIActionList = new Vector<>();
         CallResult callResultxx = this.getPSSysDEUIActions2(strPSSystemId, psDEUIActionList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUIACTION:SYS", psSysModelLogxxxx, psDEUIActionList);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionList) {
         psSysAppStorage.psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListx = psSysModelCache.getModelList("PSDEUIACTION", psSysModelLogxxxxx);
      if (psDEUIActionListx == null) {
         psDEUIActionListx = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionListx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUIACTION", psSysModelLogxxxxx, psDEUIActionListx);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListx) {
         psSysAppStorage.getPSDataEntityStorage(psDEUIAction.getPSDEID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupList = psSysModelCache.getModelList("PSDEUAGROUP:SYS", psSysModelLogxxxxxx);
      if (psDEUIActionGroupList == null) {
         psDEUIActionGroupList = new Vector<>();
         CallResult callResultxx = this.getPSSysDEUIActionGroups2(strPSSystemId, psDEUIActionGroupList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有全局实体界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUAGROUP:SYS", psSysModelLogxxxxxx, psDEUIActionGroupList);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
         psSysAppStorage.psDEUIActionGroupList.add(psDEUIActionGroup);
         PSDEUIActionGroupStorage psDEUIActionGroupStorage = psSysAppStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
         psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
      }

      PSSysModelLog psSysModelLogxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListx = psSysModelCache.getModelList("PSDEUAGROUP", psSysModelLogxxxxxxx);
      if (psDEUIActionGroupListx == null) {
         psDEUIActionGroupListx = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupListx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUAGROUP", psSysModelLogxxxxxxx, psDEUIActionGroupListx);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListx) {
         psSysAppStorage.getPSDataEntityStorage(psDEUIActionGroup.getPSDEID()).psDEUIActionGroupList.add(psDEUIActionGroup);
         PSDEUIActionGroupStorage psDEUIActionGroupStorage = psSysAppStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
         psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
      }

      PSSysModelLog psSysModelLogxxxxxxxx = psSysModelLogMap.get("PSDEPRINT");
      Vector<PSDEPrint> psDEPrintList = psSysModelCache.getModelList("PSDEPRINT", psSysModelLogxxxxxxxx);
      if (psDEPrintList == null) {
         psDEPrintList = new Vector<>();
         CallResult callResultxx = this.getPSDEPrintsBySystem(strPSSystemId, psDEPrintList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体打印发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEPRINT", psSysModelLogxxxxxxxx, psDEPrintList);
      }

      for (PSDEPrint psDEPrint : psDEPrintList) {
         psSysAppStorage.getPSDataEntityStorage(psDEPrint.getPSDEID()).psDEPrintList.add(psDEPrint);
         PSDEPrintStorage psDEPrintStorage = psSysAppStorage.getPSDEPrintStorage(psDEPrint.getPSDEPRINTID());
         psDEPrintStorage.psDEPrint = psDEPrint;
      }

      PSSysModelLog psSysModelLogxxxxxxxxx = psSysModelLogMap.get("PSDEREPORT");
      Vector<PSDEReport> psDEReportList = psSysModelCache.getModelList("PSDEREPORT", psSysModelLogxxxxxxxxx);
      if (psDEReportList == null) {
         psDEReportList = new Vector<>();
         CallResult callResultxx = this.getPSDEReportsBySystem(strPSSystemId, psDEReportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体报表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEREPORT", psSysModelLogxxxxxxxxx, psDEReportList);
      }

      for (PSDEReport psDEReport : psDEReportList) {
         psSysAppStorage.getPSDataEntityStorage(psDEReport.getPSDEID()).psDEReportList.add(psDEReport);
         PSDEReportStorage psDEReportStorage = psSysAppStorage.getPSDEReportStorage(psDEReport.getPSDEREPORTID());
         psDEReportStorage.psDEReport = psDEReport;
      }

      PSSysModelLog psSysModelLog2xxxxx = psSysModelLogMap.get("PSDEREPITEM");
      Vector<PSDEReportItem> psDEReportItemList = psSysModelCache.getModelList("PSDEREPITEM", psSysModelLogxxxxxxxxx, psSysModelLog2xxxxx);
      if (psDEReportItemList == null) {
         psDEReportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEReportItemsBySystem(strPSSystemId, psDEReportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体报表子项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEREPITEM", psSysModelLogxxxxxxxxx, psSysModelLog2xxxxx, psDEReportItemList);
      }

      for (PSDEReportItem psDEReportItem : psDEReportItemList) {
         psSysAppStorage.getPSDEReportStorage(psDEReportItem.getMAJORPSDEREPORTID()).psDEReportItemList.add(psDEReportItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAEXP");
      Vector<PSDEDataExport> psDEDataExportList = psSysModelCache.getModelList("PSDEDATAEXP", psSysModelLogxxxxxxxxxx);
      if (psDEDataExportList == null) {
         psDEDataExportList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataExportsBySystem(strPSSystemId, psDEDataExportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导出发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAEXP", psSysModelLogxxxxxxxxxx, psDEDataExportList);
      }

      for (PSDEDataExport psDEDataExport : psDEDataExportList) {
         psSysAppStorage.getPSDataEntityStorage(psDEDataExport.getPSDEID()).psDEDataExportList.add(psDEDataExport);
         PSDEDataExportStorage psDEDataExportStorage = psSysAppStorage.getPSDEDataExportStorage(psDEDataExport.getPSDEDATAEXPID());
         psDEDataExportStorage.psDEDataExport = psDEDataExport;
      }

      PSSysModelLog psSysModelLog2xxxxxx = psSysModelLogMap.get("PSDEGRIDCOL");
      if (psSysModelLog2xxxxxx == null) {
         psSysModelLog2xxxxxx = psSysModelLogxxxxxxxxxx;
      }

      Vector<PSDEGridColumn> psDEDataExportItemList = psSysModelCache.getModelList("PSDEDATAEXPITEM", psSysModelLog2xxxxxx);
      if (psDEDataExportItemList == null) {
         psDEDataExportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataExportItemsBySystem(strPSSystemId, psDEDataExportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导出项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAEXPITEM", psSysModelLog2xxxxxx, psDEDataExportItemList);
      }

      for (PSDEGridColumn psDEGridColumn : psDEDataExportItemList) {
         psSysAppStorage.getPSDEDataExportStorage(psDEGridColumn.getParamStringValue("PSDEDATAEXPID", "")).psDEGridColumnList.add(psDEGridColumn);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAIMP");
      Vector<PSDEDataImport> psDEDataImportList = psSysModelCache.getModelList("PSDEDATAIMP", psSysModelLogxxxxxxxxxxx);
      if (psDEDataImportList == null) {
         psDEDataImportList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataImportsBySystem(strPSSystemId, psDEDataImportList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导入发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAIMP", psSysModelLogxxxxxxxxxxx, psDEDataImportList);
      }

      for (PSDEDataImport psDEDataImport : psDEDataImportList) {
         psSysAppStorage.getPSDataEntityStorage(psDEDataImport.getPSDEID()).psDEDataImportList.add(psDEDataImport);
         PSDEDataImportStorage psDEDataImportStorage = psSysAppStorage.getPSDEDataImportStorage(psDEDataImport.getPSDEDATAIMPID());
         psDEDataImportStorage.psDEDataImport = psDEDataImport;
      }

      PSSysModelLog psSysModelLog2xxxxxxx = psSysModelLogMap.get("PSDEDATAIMPITEM");
      Vector<PSDEDataImportItem> psDEDataImportItemList = psSysModelCache.getModelList("PSDEDATAIMPITEM", psSysModelLogxxxxxxxxxxx, psSysModelLog2xxxxxxx);
      if (psDEDataImportItemList == null) {
         psDEDataImportItemList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataImportItemsBySystem(strPSSystemId, psDEDataImportItemList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体数据导入项发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAIMPITEM", psSysModelLogxxxxxxxxxxx, psSysModelLog2xxxxxxx, psDEDataImportItemList);
      }

      for (PSDEDataImportItem psDEDataImportItem : psDEDataImportItemList) {
         psSysAppStorage.getPSDEDataImportStorage(psDEDataImportItem.getParamStringValue("PSDEDATAIMPID", "")).psDEDataImportItemList.add(psDEDataImportItem);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListxx = psSysModelCache.getModelList("PSWFUIACTION", psSysModelLogxxxxxxxxxxxx);
      if (psDEUIActionListxx == null) {
         psDEUIActionListxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionsBySystem(strPSSystemId, psDEUIActionListxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFUIACTION", psSysModelLogxxxxxxxxxxxx, psDEUIActionListxx);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListxx) {
         psSysAppStorage.getPSWFVersionStorage(psDEUIAction.getPSWFVERSIONID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListxx = psSysModelCache.getModelList("PSWFUIACTIONGROUP", psSysModelLogxxxxxxxxxxxxx);
      if (psDEUIActionGroupListxx == null) {
         psDEUIActionGroupListxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupListxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程版本界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFUIACTIONGROUP", psSysModelLogxxxxxxxxxxxxx, psDEUIActionGroupListxx);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListxx) {
         psSysAppStorage.getPSWFVersionStorage(psDEUIActionGroup.getPSWFVERSIONID()).psDEUIActionGroupList.add(psDEUIActionGroup);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUIACTION");
      Vector<PSDEUIAction> psDEUIActionListxxx = psSysModelCache.getModelList("PSWFUIACTION2", psSysModelLogxxxxxxxxxxxxxx);
      if (psDEUIActionListxxx == null) {
         psDEUIActionListxxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActions2BySystem(strPSSystemId, psDEUIActionListxxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程界面行为发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFUIACTION2", psSysModelLogxxxxxxxxxxxxxx, psDEUIActionListxxx);
      }

      for (PSDEUIAction psDEUIAction : psDEUIActionListxxx) {
         psSysAppStorage.getPSWorkflowStorage(psDEUIAction.getPSWFID()).psDEUIActionList.add(psDEUIAction);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      Vector<PSDEUIActionGroup> psDEUIActionGroupListxxx = psSysModelCache.getModelList("PSWFUIACTIONGROUP2", psSysModelLogxxxxxxxxxxxxxxx);
      if (psDEUIActionGroupListxxx == null) {
         psDEUIActionGroupListxxx = new Vector<>();
         CallResult callResultxx = this.getPSWFUIActionGroups2BySystem(strPSSystemId, psDEUIActionGroupListxxx);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部流程界面行为组发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSWFUIACTIONGROUP2", psSysModelLogxxxxxxxxxxxxxxx, psDEUIActionGroupListxxx);
      }

      for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupListxxx) {
         psSysAppStorage.getPSWorkflowStorage(psDEUIActionGroup.getPSWFID()).psDEUIActionGroupList.add(psDEUIActionGroup);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEUAGROUP");
      PSSysModelLog psSysModelLog2xxxxxxxx = psSysModelLogMap.get("PSDEUAGRPDETAIL");
      Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = psSysModelCache.getModelList("PSDEUAGRPDETAIL", psSysModelLogxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxx);
      if (psDEUIActionGroupDetailList == null) {
         psDEUIActionGroupDetailList = new Vector<>();
         CallResult callResultxx = this.getPSDEUIActionGroupDetailsBySystem(strPSSystemId, psDEUIActionGroupDetailList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统全部界面行为组成员发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEUAGRPDETAIL", psSysModelLogxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxx, psDEUIActionGroupDetailList);
      }

      for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
         psSysAppStorage.getPSDEUIActionGroupStorage(psDEUIActionGroupDetail.getPSDEUAGROUPID()).psDEUIActionGroupDetailList.add(psDEUIActionGroupDetail);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPMODULE");
      Vector<PSAppModule> psAppModuleList = psSysModelCache.getModelList("PSAPPMODULE", psSysModelLogxxxxxxxxxxxxxxxxx);
      if (psAppModuleList == null) {
         psAppModuleList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppModules2(strPSSysAppId, psAppModuleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用模块发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPMODULE", psSysModelLogxxxxxxxxxxxxxxxxx, psAppModuleList);
      }

      psSysAppStorage.psAppModuleList.addAll(psAppModuleList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPVIEW");
      Vector<PSAppView> psAppViewList = psSysModelCache.getModelList("PSAPPVIEW", psSysModelLogxxxxxxxxxxxxxxxxxx);
      if (psAppViewList == null) {
         psAppViewList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppViews2(strPSSysAppId, psAppViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPVIEW", psSysModelLogxxxxxxxxxxxxxxxxxx, psAppViewList);
      }

      psSysAppStorage.psAppViewList.addAll(psAppViewList);

      for (PSAppView psAppView : psAppViewList) {
         psSysAppStorage.psAppViewMap.put(psAppView.getPSAPPVIEWID(), psAppView);
         psSysAppStorage.getPSAppViewStorage(psAppView.getPSAPPVIEWID()).psAppView = psAppView;
      }

      Vector<PSAppViewRef> psAppViewRefList = psSysModelCache.getModelList("PSAPPVIEWREF", psSysModelLogxxxxxxxxxxxxxxxxxx);
      if (psAppViewRefList == null) {
         psAppViewRefList = new Vector<>();
         CallResult callResultxx = this.getPSAppViewRefsBySystem(psSystemApplication.getPSSYSTEMID(), psAppViewRefList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体视图关联视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPVIEWREF", psSysModelLogxxxxxxxxxxxxxxxxxx, psAppViewRefList);
      }

      for (PSAppViewRef psAppViewRef : psAppViewRefList) {
         psSysAppStorage.getPSAppViewStorage(psAppViewRef.getMAJORPSAPPVIEWID()).psAppViewRefList.add(psAppViewRef);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPLAN");
      Vector<PSAppLan> psAppLanList = psSysModelCache.getModelList("PSAPPLAN", psSysModelLogxxxxxxxxxxxxxxxxxxx);
      if (psAppLanList == null) {
         psAppLanList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppLans2(strPSSysAppId, psAppLanList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用语言发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPLAN", psSysModelLogxxxxxxxxxxxxxxxxxxx, psAppLanList);
      }

      psSysAppStorage.psAppLanList.addAll(psAppLanList);
      if (this.getModelInstVer() >= 747) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPLOGIC");
         Vector<PSAppLogic> psAppLogicList = psSysModelCache.getModelList("PSAPPLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxx);
         if (psAppLogicList == null) {
            psAppLogicList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppLogics2(strPSSysAppId, psAppLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用所有应用逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxx, psAppLogicList);
         }

         psSysAppStorage.psAppLogicList.addAll(psAppLogicList);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPPKG");
      Vector<PSAppPkg> psAppPkgList = psSysModelCache.getModelList("PSAPPPKG", psSysModelLogxxxxxxxxxxxxxxxxxxxx);
      if (psAppPkgList == null) {
         psAppPkgList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppPkgs2(strPSSysAppId, psAppPkgList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用组件包发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPPKG", psSysModelLogxxxxxxxxxxxxxxxxxxxx, psAppPkgList);
      }

      psSysAppStorage.psAppPkgList.addAll(psAppPkgList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPUISTYLE");
      Vector<PSAppUIStyle> psAppUIStyleList = psSysModelCache.getModelList("PSAPPUISTYLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxx);
      if (psAppUIStyleList == null) {
         psAppUIStyleList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppUIStyles2(strPSSysAppId, psAppUIStyleList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用界面模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPUISTYLE", psSysModelLogxxxxxxxxxxxxxxxxxxxxx, psAppUIStyleList);
      }

      psSysAppStorage.psAppUIStyleList.addAll(psAppUIStyleList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPUTILPAGE");
      Vector<PSAppUtilPage> psAppUtilPageList = psSysModelCache.getModelList("PSAPPUTILPAGE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppUtilPageList == null) {
         psAppUtilPageList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppUtilPages2(strPSSysAppId, psAppUtilPageList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用功能页面发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPUTILPAGE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxx, psAppUtilPageList);
      }

      psSysAppStorage.psAppUtilPageList.addAll(psAppUtilPageList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPPDTVIEW");
      Vector<PSAppPDTView> psAppPDTViewList = psSysModelCache.getModelList("PSAPPPDTVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppPDTViewList == null) {
         psAppPDTViewList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppPDTViews2(strPSSysAppId, psAppPDTViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用预置视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPPDTVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxx, psAppPDTViewList);
      }

      psSysAppStorage.psAppPDTViewList.addAll(psAppPDTViewList);
      if (this.getModelInstVer() >= 585) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPRESOURCE");
         Vector<PSAppResource> psAppResourceList = psSysModelCache.getModelList("PSAPPRESOURCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppResourceList == null) {
            psAppResourceList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppResources2(strPSSysAppId, psAppResourceList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用所有应用预置资源发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPRESOURCE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx, psAppResourceList);
         }

         psSysAppStorage.psAppResourceList.addAll(psAppResourceList);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPFUNC");
      Vector<PSAppFunc> psAppFuncList = psSysModelCache.getModelList("PSAPPFUNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppFuncList == null) {
         psAppFuncList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppFuncs2(strPSSysAppId, psAppFuncList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用功能发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPFUNC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxx, psAppFuncList);
      }

      psSysAppStorage.psAppFuncList.addAll(psAppFuncList);
      if (this.getModelInstVer() >= 629) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPUTIL");
         Vector<PSAppUtil> psAppUtilList = psSysModelCache.getModelList("PSAPPUTIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppUtilList == null) {
            psAppUtilList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppUtils2(strPSSysAppId, psAppUtilList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用所有应用组件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPUTIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx, psAppUtilList);
         }

         psSysAppStorage.psAppUtilList.addAll(psAppUtilList);
      }

      if (this.getModelInstVer() >= 630) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPPORTLET");
         Vector<PSAppPortlet> psAppPortletList = psSysModelCache.getModelList("PSAPPPORTLET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppPortletList == null) {
            psAppPortletList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppPortlets2(strPSSysAppId, psAppPortletList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用所有应用门户部件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPPORTLET", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx, psAppPortletList);
         }

         psSysAppStorage.psAppPortletList.addAll(psAppPortletList);
      }

      if (this.getModelInstVer() >= 803) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPPFPLUGIN");
         Vector<PSAppPFPlugin> psAppPFPluginList = psSysModelCache.getModelList("PSAPPPFPLUGIN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppPFPluginList == null) {
            psAppPFPluginList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppPFPlugins2(strPSSysAppId, psAppPFPluginList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用所有应用前端插件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPPFPLUGIN", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx, psAppPFPluginList);
         }

         psSysAppStorage.psAppPFPluginList.addAll(psAppPFPluginList);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPWF");
      Vector<PSAppWF> psAppWFList = psSysModelCache.getModelList("PSAPPWF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppWFList == null) {
         psAppWFList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppWFs2(strPSSysAppId, psAppWFList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用工作流发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPWF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxx, psAppWFList);
      }

      psSysAppStorage.psAppWFList.addAll(psAppWFList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPWFVER");
      Vector<PSAppWFVer> psAppWFVerList = psSysModelCache.getModelList("PSAPPWFVER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppWFVerList == null) {
         psAppWFVerList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppWFVers2(strPSSysAppId, psAppWFVerList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用工作流版本发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPWFVER", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppWFVerList);
      }

      psSysAppStorage.psAppWFVerList.addAll(psAppWFVerList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPEDITORTEMPL");
      Vector<PSAppEditorTempl> psAppEditorTemplList = psSysModelCache.getModelList("PSAPPEDITORTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppEditorTemplList == null) {
         psAppEditorTemplList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppEditorTempls2(strPSSysAppId, psAppEditorTemplList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有编辑器模板发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPEDITORTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppEditorTemplList);
      }

      psSysAppStorage.psAppEditorTemplList.addAll(psAppEditorTemplList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPMENU");
      Vector<PSAppMenu> psAppMenuList = psSysModelCache.getModelList("PSAPPMENU", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppMenuList == null) {
         psAppMenuList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppMenus2(strPSSysAppId, psAppMenuList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用菜单发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPMENU", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppMenuList);
      }

      psSysAppStorage.psAppMenuList.addAll(psAppMenuList);

      for (PSAppMenu psAppMenu : psAppMenuList) {
         psSysAppStorage.getPSAppMenuStorage(psAppMenu.getPSAPPMENUID()).psAppMenu = psAppMenu;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSAppMenuItem> psAppMenuItemList = psSysModelCache.getModelList("PSAPPMENUITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppMenuItemList == null) {
            psAppMenuItemList = new Vector<>();
            CallResult callResultxx = this.getPSAppMenuItemsBySysApp(psSystemApplication.getPSSYSAPPID(), psAppMenuItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用菜单项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPMENUITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppMenuItemList);
         }

         for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            psSysAppStorage.getPSAppMenuStorage(psAppMenuItem.getPSAPPMENUID()).psAppMenuItemList.add(psAppMenuItem);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSAppMenuLogic> psAppMenuLogicList = psSysModelCache.getModelList("PSAPPMENULOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppMenuLogicList == null) {
            psAppMenuLogicList = new Vector<>();
            CallResult callResultxx = this.getPSAppMenuLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psAppMenuLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询应用菜单部件逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPMENULOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppMenuLogicList);
         }

         for (PSAppMenuLogic psAppMenuLogic : psAppMenuLogicList) {
            psSysAppStorage.getPSAppMenuStorage(psAppMenuLogic.getPSAPPMENUID()).psAppMenuLogicList.add(psAppMenuLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPUSERMODE");
      Vector<PSAppUserMode> psAppUserModeList = psSysModelCache.getModelList("PSAPPUSERMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppUserModeList == null) {
         psAppUserModeList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppUserModes2(strPSSysAppId, psAppUserModeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用用户模式发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPUSERMODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppUserModeList);
      }

      psSysAppStorage.psAppUserModeList.addAll(psAppUserModeList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPUITHEME");
      Vector<PSAppUITheme> psAppUIThemeList = psSysModelCache.getModelList("PSAPPUITHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppUIThemeList == null) {
         psAppUIThemeList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppUIThemes2(strPSSysAppId, psAppUIThemeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用界面主题发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPUITHEME", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppUIThemeList);
      }

      psSysAppStorage.psAppUIThemeList.addAll(psAppUIThemeList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPLOCALDE");
      Vector<PSAppLocalDE> psAppLocalDEList = psSysModelCache.getModelList("PSAPPLOCALDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppLocalDEList == null) {
         psAppLocalDEList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppLocalDEs2(strPSSysAppId, psAppLocalDEList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用本地实体发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPLOCALDE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppLocalDEList);
      }

      psSysAppStorage.psAppLocalDEList.addAll(psAppLocalDEList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPDERS");
      Vector<PSAppDERS> psAppDERSList = psSysModelCache.getModelList("PSAPPDERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppDERSList == null) {
         psAppDERSList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppDERSs2(strPSSysAppId, psAppDERSList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用实体关系发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPDERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppDERSList);
      }

      psSysAppStorage.psAppDERSList.addAll(psAppDERSList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPVIEWCODE");
      Vector<PSAppViewCode> psAppViewCodeList = psSysModelCache.getModelList("PSAPPVIEWCODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psAppViewCodeList == null) {
         psAppViewCodeList = new Vector<>();
         CallResult callResultxx = this.getAllPSAppViewCodes2(strPSSysAppId, psAppViewCodeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用视图代码发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSAPPVIEWCODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppViewCodeList);
      }

      psSysAppStorage.psAppViewCodeList.addAll(psAppViewCodeList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSMOBAPPSTARTPAGE");
      Vector<PSMobAppStartPage> psMobAppStartPageList = psSysModelCache.getModelList("PSMOBAPPSTARTPAGE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psMobAppStartPageList == null) {
         psMobAppStartPageList = new Vector<>();
         CallResult callResultxx = this.getAllPSMobAppStartPages2(strPSSysAppId, psMobAppStartPageList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有移动应用起始页发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSMOBAPPSTARTPAGE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psMobAppStartPageList);
      }

      psSysAppStorage.psMobAppStartPageList.addAll(psMobAppStartPageList);
      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSMOBAPPPACK");
      Vector<PSMobAppPack> psMobAppPackList = psSysModelCache.getModelList("PSMOBAPPPACK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psMobAppPackList == null) {
         psMobAppPackList = new Vector<>();
         CallResult callResultxx = this.getAllPSMobAppPacks2(strPSSysAppId, psMobAppPackList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有移动应用打包配置发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSMOBAPPPACK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psMobAppPackList);
      }

      psSysAppStorage.psMobAppPackList.addAll(psMobAppPackList);

      for (PSMobAppPack psMobAppPack : psMobAppPackList) {
         psSysAppStorage.getPSMobAppPackStorage(psMobAppPack.getPSMOBAPPPACKID()).psMobAppPack = psMobAppPack;
      }

      Vector<PSMobAppPackTD> psMobAppPackTDList = psSysModelCache.getModelList("PSMOBAPPPACKTD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psMobAppPackTDList == null) {
         psMobAppPackTDList = new Vector<>();
         CallResult callResultxx = this.getPSMobAppPackTDsBySysApp(psSystemApplication.getPSSYSAPPID(), psMobAppPackTDList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有移动应用打包测试设备发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSMOBAPPPACKTD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psMobAppPackTDList);
      }

      for (PSMobAppPackTD psMobAppPackTD : psMobAppPackTDList) {
         psSysAppStorage.getPSMobAppPackStorage(psMobAppPackTD.getPSMOBAPPPACKID()).psMobAppPackTDList.add(psMobAppPackTD);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEVIEWBASE");
      Vector<PSDEViewBase> psDEViewBaseList = psSysModelCache.getModelList("PSDEVIEWBASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEViewBaseList == null) {
         psDEViewBaseList = new Vector<>();
         CallResult callResultxx = this.getAllPSDEViewBasesBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewBaseList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有应用实体视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEVIEWBASE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEViewBaseList);
      }

      psSysAppStorage.psDEViewBaseList.addAll(psDEViewBaseList);

      for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
         psSysAppStorage.psDEViewBaseMap.put(psDEViewBase.getPSDEVIEWBASEID(), psDEViewBase);
         psSysAppStorage.getPSDEViewBaseStorage(psDEViewBase.getPSDEVIEWBASEID()).psDEViewBase = psDEViewBase;
      }

      Vector<PSDEViewView> psDEViewViewList = psSysModelCache.getModelList("PSDEVIEWRV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEViewViewList == null) {
         psDEViewViewList = new Vector<>();
         CallResult callResultxx = this.getPSDEViewViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体视图关联视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEVIEWRV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEViewViewList);
      }

      for (PSDEViewView psDEViewView : psDEViewViewList) {
         psSysAppStorage.getPSDEViewBaseStorage(psDEViewView.getMAJORPSDEVIEWID()).psDEViewViewList.add(psDEViewView);
      }

      PSSysModelLog psSysModelLog2xxxxxxxxx = psSysModelLogMap.get("PSDEVIEWCTRL");
      if (psSysModelLog2xxxxxxxxx == null) {
         psSysModelLog2xxxxxxxxx = psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
      }

      Vector<PSDEViewCtrl> psDEViewCtrlList = psSysModelCache.getModelList("PSDEVIEWCTRL", psSysModelLog2xxxxxxxxx);
      if (psDEViewCtrlList == null) {
         psDEViewCtrlList = new Vector<>();
         CallResult callResultxx = this.getPSDEViewCtrlsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewCtrlList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体视图部件发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEVIEWCTRL", psSysModelLog2xxxxxxxxx, psDEViewCtrlList);
      }

      for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
         psSysAppStorage.getPSDEViewBaseStorage(psDEViewCtrl.getPSDEVIEWBASEID()).psDEViewCtrlList.add(psDEViewCtrl);
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEViewLogic> psDEViewLogicList = psSysModelCache.getModelList("PSDEVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEViewLogicList == null) {
            psDEViewLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEViewLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体视图逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEViewLogicList);
         }

         for (PSDEViewLogic psDEViewLogic : psDEViewLogicList) {
            psSysAppStorage.getPSDEViewBaseStorage(psDEViewLogic.getPSDEVIEWBASEID()).psDEViewLogicList.add(psDEViewLogic);
         }
      }

      if (this.getModelInstVer() >= 605 && nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEViewEngine> psDEViewEngineList = psSysModelCache.getModelList("PSDEVIEWENGINE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEViewEngineList == null) {
            psDEViewEngineList = new Vector<>();
            CallResult callResultxx = this.getPSDEViewEnginesBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewEngineList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体视图界面引擎发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEVIEWENGINE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEViewEngineList);
         }

         for (PSDEViewEngine psDEViewEngine : psDEViewEngineList) {
            psSysAppStorage.getPSDEViewBaseStorage(psDEViewEngine.getPSDEVIEWBASEID()).psDEViewEngineList.add(psDEViewEngine);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDYNADEVIEWTEMPL");
      Vector<PSDynaDEViewTempl> psDynaDEViewTemplList = psSysModelCache.getModelList("PSDYNADEVIEWTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDynaDEViewTemplList == null) {
         psDynaDEViewTemplList = new Vector<>();
         CallResult callResultxx = this.getAllPSDynaDEViewTemplsBySystem(psSystemApplication.getPSSYSTEMID(), psDynaDEViewTemplList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询应用所有动态实体视图模板发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDYNADEVIEWTEMPL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDynaDEViewTemplList);
      }

      psSysAppStorage.psDynaDEViewTemplList.addAll(psDynaDEViewTemplList);

      for (PSDynaDEViewTempl psDynaDEViewTempl : psDynaDEViewTemplList) {
         psSysAppStorage.psDynaDEViewTemplMap.put(psDynaDEViewTempl.getPSDYNADEVIEWTEMPLID(), psDynaDEViewTempl);
         psSysAppStorage.getPSDynaDEViewTemplStorage(psDynaDEViewTempl.getPSDYNADEVIEWTEMPLID()).psDynaDEViewTempl = psDynaDEViewTempl;
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDETOOLBAR");
      Vector<PSDEToolbar> psDEToolbarList = psSysModelCache.getModelList("PSDETOOLBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEToolbarList == null) {
         psDEToolbarList = new Vector<>();
         CallResult callResultxx = this.getPSDEToolbarsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体工具栏发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETOOLBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEToolbarList);
      }

      for (PSDEToolbar psDEToolbar : psDEToolbarList) {
         psSysAppStorage.getPSDEToolbarStorage(psDEToolbar.getPSDETOOLBARID()).psDEToolbar = psDEToolbar;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEToolbarItem> psDEToolbarItemList = psSysModelCache.getModelList("PSDETBITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEToolbarItemList == null) {
            psDEToolbarItemList = new Vector<>();
            CallResult callResultxx = this.getPSDEToolbarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体工具栏项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDETBITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEToolbarItemList);
         }

         for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
            psSysAppStorage.getPSDEToolbarStorage(psDEToolbarItem.getPSDETOOLBARID()).psDEToolbarItemList.add(psDEToolbarItem);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEToolbarLogic> psDEToolbarLogicList = psSysModelCache.getModelList("PSDETOOLBARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEToolbarLogicList == null) {
            psDEToolbarLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEToolbarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询工具栏逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDETOOLBARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEToolbarLogicList);
         }

         for (PSDEToolbarLogic psDEToolbarLogic : psDEToolbarLogicList) {
            psSysAppStorage.getPSDEToolbarStorage(psDEToolbarLogic.getPSDETOOLBARID()).psDEToolbarLogicList.add(psDEToolbarLogic);
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSSEARCHBAR");
         Vector<PSSysSearchBar> psSysSearchBarList = psSysModelCache.getModelList("PSSYSSEARCHBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysSearchBarList == null) {
            psSysSearchBarList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysSearchBars2(psSystemApplication.getPSSYSTEMID(), psSysSearchBarList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有搜索栏发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSSEARCHBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSearchBarList);
         }

         psSysAppStorage.psSysSearchBarList.addAll(psSysSearchBarList);

         for (PSSysSearchBar psSysSearchBar : psSysSearchBarList) {
            psSysAppStorage.getPSSysSearchBarStorage(psSysSearchBar.getPSSYSSEARCHBARID()).psSysSearchBar = psSysSearchBar;
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxx = psSysModelLogMap.get("PSSYSSEARCHBARITEM");
         Vector<PSSysSearchBarItem> psSysSearchBarItemList = psSysModelCache.getModelList("PSSYSSEARCHBARITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx);
         if (psSysSearchBarItemList == null) {
            psSysSearchBarItemList = new Vector<>();
            CallResult callResultxx = this.getPSSysSearchBarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysSearchBarItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有搜索栏项目发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSSEARCHBARITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx, psSysSearchBarItemList
            );
         }

         for (PSSysSearchBarItem psSysSearchBarItem : psSysSearchBarItemList) {
            psSysAppStorage.getPSSysSearchBarStorage(psSysSearchBarItem.getPSSYSSEARCHBARID()).psSysSearchBarItemList.add(psSysSearchBarItem);
         }

         if (this.getModelInstVer() >= 747) {
            Vector<PSSysSearchBarLogic> psSysSearchBarLogicList = psSysModelCache.getModelList(
               "PSSYSSEARCHBARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psSysSearchBarLogicList == null) {
               psSysSearchBarLogicList = new Vector<>();
               CallResult callResultxx = this.getPSSysSearchBarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysSearchBarLogicList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询搜索栏部件逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSSEARCHBARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysSearchBarLogicList);
            }

            for (PSSysSearchBarLogic psSysSearchBarLogic : psSysSearchBarLogicList) {
               psSysAppStorage.getPSSysSearchBarStorage(psSysSearchBarLogic.getPSSYSSEARCHBARID()).psSysSearchBarLogicList.add(psSysSearchBarLogic);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSTITLEBAR");
         Vector<PSSysTitleBar> psSysTitleBarList = psSysModelCache.getModelList("PSSYSTITLEBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysTitleBarList == null) {
            psSysTitleBarList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysTitleBars2(psSystemApplication.getPSSYSTEMID(), psSysTitleBarList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有标题栏发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSTITLEBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysTitleBarList);
         }

         psSysAppStorage.psSysTitleBarList.addAll(psSysTitleBarList);

         for (PSSysTitleBar psSysTitleBar : psSysTitleBarList) {
            psSysAppStorage.getPSSysTitleBarStorage(psSysTitleBar.getPSSYSTITLEBARID()).psSysTitleBar = psSysTitleBar;
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSAPPTITLEBAR");
         Vector<PSAppTitleBar> psAppTitleBarList = psSysModelCache.getModelList("PSAPPTITLEBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psAppTitleBarList == null) {
            psAppTitleBarList = new Vector<>();
            CallResult callResultxx = this.getAllPSAppTitleBars2(psSystemApplication.getPSSYSTEMID(), psAppTitleBarList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("应用系统所有标题栏发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSAPPTITLEBAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psAppTitleBarList);
         }

         psSysAppStorage.psAppTitleBarList.addAll(psAppTitleBarList);

         for (PSAppTitleBar psAppTitleBar : psAppTitleBarList) {
            psSysAppStorage.getPSAppTitleBarStorage(psAppTitleBar.getPSAPPTITLEBARID()).psAppTitleBar = psAppTitleBar;
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSDASHBOARD");
         Vector<PSSysDashboard> psSysDashboardList = psSysModelCache.getModelList("PSSYSDASHBOARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysDashboardList == null) {
            psSysDashboardList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysDashboards2(psSystemApplication.getPSSYSTEMID(), psSysDashboardList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有数据看板发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSDASHBOARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDashboardList);
         }

         psSysAppStorage.psSysDashboardList.addAll(psSysDashboardList);

         for (PSSysDashboard psSysDashboard : psSysDashboardList) {
            psSysAppStorage.getPSSysDashboardStorage(psSysDashboard.getPSSYSDASHBOARDID()).psSysDashboard = psSysDashboard;
         }

         Vector<PSSysDashboardPart> psSysDashboardPartList = psSysModelCache.getModelList("PSSYSDBPART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysDashboardPartList == null) {
            psSysDashboardPartList = new Vector<>();
            CallResult callResultxx = this.getPSSysDashboardPartsBySystem(psSystemApplication.getPSSYSTEMID(), psSysDashboardPartList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有数据看板部件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSDBPART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDashboardPartList);
         }

         for (PSSysDashboardPart psSysDashboardPart : psSysDashboardPartList) {
            psSysAppStorage.getPSSysDashboardStorage(psSysDashboardPart.getPSSYSDASHBOARDID()).psSysDashboardPartList.add(psSysDashboardPart);
         }

         if (this.getModelInstVer() >= 747) {
            Vector<PSSysDashboardLogic> psSysDashboardLogicList = psSysModelCache.getModelList(
               "PSSYSDASHBOARDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psSysDashboardLogicList == null) {
               psSysDashboardLogicList = new Vector<>();
               CallResult callResultxx = this.getPSSysDashboardLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysDashboardLogicList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询数据看板部件逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSDASHBOARDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysDashboardLogicList);
            }

            for (PSSysDashboardLogic psSysDashboardLogic : psSysDashboardLogicList) {
               psSysAppStorage.getPSSysDashboardStorage(psSysDashboardLogic.getPSSYSDASHBOARDID()).psSysDashboardLogicList.add(psSysDashboardLogic);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSCALENDAR");
         Vector<PSSysCalendar> psSysCalendarList = psSysModelCache.getModelList("PSSYSCALENDAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysCalendarList == null) {
            psSysCalendarList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysCalendars2(psSystemApplication.getPSSYSTEMID(), psSysCalendarList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有日历部件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSCALENDAR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysCalendarList);
         }

         psSysAppStorage.psSysCalendarList.addAll(psSysCalendarList);

         for (PSSysCalendar psSysCalendar : psSysCalendarList) {
            psSysAppStorage.getPSSysCalendarStorage(psSysCalendar.getPSSYSCALENDARID()).psSysCalendar = psSysCalendar;
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxx = psSysModelLogMap.get("PSSYSCALENDARITEM");
         Vector<PSSysCalendarItem> psSysCalendarItemList = psSysModelCache.getModelList("PSSYSCALENDARITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx);
         if (psSysCalendarItemList == null) {
            psSysCalendarItemList = new Vector<>();
            CallResult callResultxx = this.getPSSysCalendarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有日历部件项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSCALENDARITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx, psSysCalendarItemList
            );
         }

         for (PSSysCalendarItem psSysCalendarItem : psSysCalendarItemList) {
            psSysAppStorage.getPSSysCalendarStorage(psSysCalendarItem.getPSSYSCALENDARID()).psSysCalendarItemList.add(psSysCalendarItem);
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxxx = psSysModelLogMap.get("PSSYSCALENDARITEMRV");
         Vector<PSSysCalendarItemRV> psSysCalendarItemRVList = psSysModelCache.getModelList(
            "PSSYSCALENDARITEMRV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxx
         );
         if (psSysCalendarItemRVList == null) {
            psSysCalendarItemRVList = new Vector<>();
            CallResult callResultxx = this.getPSSysCalendarItemRVsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarItemRVList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有日历部件项视图发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList(
               "PSSYSCALENDARITEMRV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxxx, psSysCalendarItemRVList
            );
         }

         for (PSSysCalendarItemRV psSysCalendarItemRV : psSysCalendarItemRVList) {
            psSysAppStorage.getPSSysCalendarStorage(psSysCalendarItemRV.getPSSYSCALENDARID()).psSysCalendarItemRVList.add(psSysCalendarItemRV);
         }

         if (this.getModelInstVer() >= 747) {
            Vector<PSSysCalendarLogic> psSysCalendarLogicList = psSysModelCache.getModelList(
               "PSSYSCALENDARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            );
            if (psSysCalendarLogicList == null) {
               psSysCalendarLogicList = new Vector<>();
               CallResult callResultxx = this.getPSSysCalendarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarLogicList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询日历部件逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSCALENDARLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysCalendarLogicList);
            }

            for (PSSysCalendarLogic psSysCalendarLogic : psSysCalendarLogicList) {
               psSysAppStorage.getPSSysCalendarStorage(psSysCalendarLogic.getPSSYSCALENDARID()).psSysCalendarLogicList.add(psSysCalendarLogic);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW && this.getModelInstVer() >= 614) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSMAPVIEW");
         Vector<PSSysMapView> psSysMapViewList = psSysModelCache.getModelList("PSSYSMAPVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysMapViewList == null) {
            psSysMapViewList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysMapViews2(psSystemApplication.getPSSYSTEMID(), psSysMapViewList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有地图部件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSMAPVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysMapViewList);
         }

         psSysAppStorage.psSysMapViewList.addAll(psSysMapViewList);

         for (PSSysMapView psSysMapView : psSysMapViewList) {
            psSysAppStorage.getPSSysMapViewStorage(psSysMapView.getPSSYSMAPVIEWID()).psSysMapView = psSysMapView;
         }

         PSSysModelLog psSysModelLog2xxxxxxxxxx = psSysModelLogMap.get("PSSYSMAPITEM");
         Vector<PSSysMapItem> psSysMapItemList = psSysModelCache.getModelList("PSSYSMAPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx);
         if (psSysMapItemList == null) {
            psSysMapItemList = new Vector<>();
            CallResult callResultxx = this.getPSSysMapItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysMapItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有地图部件项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSMAPITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysModelLog2xxxxxxxxxx, psSysMapItemList);
         }

         for (PSSysMapItem psSysMapItem : psSysMapItemList) {
            psSysAppStorage.getPSSysMapViewStorage(psSysMapItem.getPSSYSMAPVIEWID()).psSysMapItemList.add(psSysMapItem);
         }

         if (this.getModelInstVer() >= 747) {
            Vector<PSSysMapLogic> psSysMapLogicList = psSysModelCache.getModelList("PSSYSMAPLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
            if (psSysMapLogicList == null) {
               psSysMapLogicList = new Vector<>();
               CallResult callResultxx = this.getPSSysMapLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysMapLogicList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询地图部件逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSSYSMAPLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysMapLogicList);
            }

            for (PSSysMapLogic psSysMapLogic : psSysMapLogicList) {
               psSysAppStorage.getPSSysMapViewStorage(psSysMapLogic.getPSSYSMAPVIEWID()).psSysMapLogicList.add(psSysMapLogic);
            }
         }
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW && this.getModelInstVer() >= 397) {
         PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSVIEWPANEL");
         Vector<PSSysPanel> psSysPanelList = psSysModelCache.getModelList("PSSYSVIEWPANEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysPanelList == null) {
            psSysPanelList = new Vector<>();
            CallResult callResultxx = this.getAllPSSysPanels2(psSystemApplication.getPSSYSTEMID(), psSysPanelList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板部件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSVIEWPANEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysPanelList);
         }

         psSysAppStorage.psSysPanelList.addAll(psSysPanelList);

         for (PSSysPanel psSysPanel : psSysPanelList) {
            psSysAppStorage.getPSSysPanelStorage(psSysPanel.getPSSYSVIEWPANELID()).psSysPanel = psSysPanel;
         }

         Vector<PSSysPanelItem> psSysPanelItemList = psSysModelCache.getModelList("PSSYSVIEWPANELITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysPanelItemList == null) {
            psSysPanelItemList = new Vector<>();
            CallResult callResultxx = this.getPSSysPanelItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板部件项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSVIEWPANELITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysPanelItemList);
         }

         for (PSSysPanelItem psSysPanelItem : psSysPanelItemList) {
            psSysAppStorage.getPSSysPanelStorage(psSysPanelItem.getPSSYSVIEWPANELID()).psSysPanelItemList.add(psSysPanelItem);
         }

         Vector<PSSysPanelModel> psSysPanelModelList = psSysModelCache.getModelList("PSSYSVIEWPANELMODEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysPanelModelList == null) {
            psSysPanelModelList = new Vector<>();
            CallResult callResultxx = this.getPSSysPanelModelsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelModelList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板部件模型发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSVIEWPANELMODEL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysPanelModelList);
         }

         for (PSSysPanelModel psSysPanelModel : psSysPanelModelList) {
            psSysAppStorage.getPSSysPanelStorage(psSysPanelModel.getPSSYSVIEWPANELID()).psSysPanelModelList.add(psSysPanelModel);
         }

         Vector<PSPanelItemLogic> psPanelItemLogicList = psSysModelCache.getModelList("PSPANELITEMLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psPanelItemLogicList == null) {
            psPanelItemLogicList = new Vector<>();
            CallResult callResultxx = this.getPSPanelItemLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelItemLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板项逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELITEMLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelItemLogicList);
         }

         for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
            psSysAppStorage.getPSSysPanelStorage(psPanelItemLogic.getPSSYSVIEWPANELID()).psPanelItemLogicList.add(psPanelItemLogic);
         }

         Vector<PSSysPanelLogic> psSysPanelLogicList = psSysModelCache.getModelList("PSSYSVIEWPANELLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psSysPanelLogicList == null) {
            psSysPanelLogicList = new Vector<>();
            CallResult callResultxx = this.getPSSysPanelLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSSYSVIEWPANELLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysPanelLogicList);
         }

         for (PSSysPanelLogic psSysPanelLogic : psSysPanelLogicList) {
            psSysAppStorage.getPSSysPanelStorage(psSysPanelLogic.getPSSYSVIEWPANELID()).psSysPanelLogicList.add(psSysPanelLogic);
            psSysAppStorage.getPSPanelLogicStorage(psSysPanelLogic.getPSSYSVIEWPANELLOGICID()).psSysPanelLogic = psSysPanelLogic;
         }

         Vector<PSPanelLogicParam> psPanelLogicParamList = psSysModelCache.getModelList(
            "PSPANELLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psPanelLogicParamList == null) {
            psPanelLogicParamList = new Vector<>();
            CallResult callResultxx = this.getPSPanelLogicParamsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicParamList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑参数发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelLogicParamList);
         }

         for (PSPanelLogicParam psPanelLogicParam : psPanelLogicParamList) {
            psSysAppStorage.getPSPanelLogicStorage(psPanelLogicParam.getPSSYSVIEWPANELLOGICID()).psPanelLogicParamList.add(psPanelLogicParam);
         }

         Vector<PSPanelLogicNode> psPanelLogicNodeList = psSysModelCache.getModelList("PSPANELLOGICNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psPanelLogicNodeList == null) {
            psPanelLogicNodeList = new Vector<>();
            CallResult callResultxx = this.getPSPanelLogicNodesBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicNodeList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑节点发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELLOGICNODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelLogicNodeList);
         }

         for (PSPanelLogicNode psPanelLogicNode : psPanelLogicNodeList) {
            psSysAppStorage.getPSPanelLogicStorage(psPanelLogicNode.getPSSYSVIEWPANELLOGICID()).psPanelLogicNodeList.add(psPanelLogicNode);
         }

         Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList = psSysModelCache.getModelList(
            "PSPANELLNPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psPanelLogicNodeParamList == null) {
            psPanelLogicNodeParamList = new Vector<>();
            CallResult callResultxx = this.getPSPanelLogicNodeParamsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicNodeParamList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑节点参数发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELLNPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelLogicNodeParamList);
         }

         for (PSPanelLogicNodeParam psPanelLogicNodeParam : psPanelLogicNodeParamList) {
            psSysAppStorage.getPSPanelLogicStorage(psPanelLogicNodeParam.getPSSYSVIEWPANELLOGICID()).psPanelLogicNodeParamList.add(psPanelLogicNodeParam);
         }

         Vector<PSPanelLogicLink> psPanelLogicLinkList = psSysModelCache.getModelList("PSPANELLOGICLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psPanelLogicLinkList == null) {
            psPanelLogicLinkList = new Vector<>();
            CallResult callResultxx = this.getPSPanelLogicLinksBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicLinkList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑连接发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELLOGICLINK", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelLogicLinkList);
         }

         for (PSPanelLogicLink psPanelLogicLink : psPanelLogicLinkList) {
            psSysAppStorage.getPSPanelLogicStorage(psPanelLogicLink.getPSSYSVIEWPANELLOGICID()).psPanelLogicLinkList.add(psPanelLogicLink);
         }

         Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList = psSysModelCache.getModelList(
            "PSPANELLLCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psPanelLogicLinkCondList == null) {
            psPanelLogicLinkCondList = new Vector<>();
            CallResult callResultxx = this.getPSPanelLogicLinkCondsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicLinkCondList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统所有面板逻辑连接条件发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSPANELLLCOND", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelLogicLinkCondList);
         }

         for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
            psSysAppStorage.getPSPanelLogicStorage(psPanelLogicLinkCond.getPSSYSVIEWPANELLOGICID()).psPanelLogicLinkCondList.add(psPanelLogicLinkCond);
         }

         if (this.getModelInstVer() >= 609) {
            Vector<PSPanelEngine> psPanelEngineList = psSysModelCache.getModelList("PSPANELENGINE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
            if (psPanelEngineList == null) {
               psPanelEngineList = new Vector<>();
               CallResult callResultxx = this.getPSPanelEnginesBySystem(psSystemApplication.getPSSYSTEMID(), psPanelEngineList);
               if (callResultxx.isError()) {
                  throw new Exception(StringHelper.Format("查询系统所有面板界面引擎发生错误，%1$s", callResultxx.getErrorInfo()));
               }

               psSysModelCache.updateModelList("PSPANELENGINE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psPanelEngineList);
            }

            for (PSPanelEngine psPanelEngine : psPanelEngineList) {
               psSysAppStorage.getPSSysPanelStorage(psPanelEngine.getPSSYSVIEWPANELID()).psPanelEngineList.add(psPanelEngine);
            }
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEFORM");
      Vector<PSDEForm> psDEFormList = psSysModelCache.getModelList("PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEFormList == null) {
         psDEFormList = new Vector<>();
         CallResult callResultxx = this.getPSDEFormsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体表单发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEFORM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormList);
      }

      for (PSDEForm psDEForm : psDEFormList) {
         psSysAppStorage.getPSDEFormStorage(psDEForm.getPSDEFORMID()).psDEForm = psDEForm;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFormDetail> psDEFormDetailList = psSysModelCache.getModelList("PSDEFORMDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFormDetailList == null) {
            psDEFormDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEFormDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体表单项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFORMDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormDetailList);
         }

         for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            psSysAppStorage.getPSDEFormStorage(psDEFormDetail.getPSDEFORMID()).psDEFormDetailList.add(psDEFormDetail);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFDLogic> psDEFDLogicList = psSysModelCache.getModelList("PSDEFDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFDLogicList == null) {
            psDEFDLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEFDLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFDLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单项逻发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFDLogicList);
         }

         for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            psSysAppStorage.getPSDEFormStorage(psDEFDLogic.getParamStringValue("PSDEFORMID", "")).psDEFDLogicList.add(psDEFDLogic);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFIUpdate> psDEFIUpdateList = psSysModelCache.getModelList("PSDEFIUPDATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFIUpdateList == null) {
            psDEFIUpdateList = new Vector<>();
            CallResult callResultxx = this.getPSDEFIUpdatesBySystem(psSystemApplication.getPSSYSTEMID(), psDEFIUpdateList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单更新发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFIUPDATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFIUpdateList);
         }

         for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
            psSysAppStorage.getPSDEFormStorage(psDEFIUpdate.getPSDEFORMID()).psDEFIUpdateList.add(psDEFIUpdate);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFIUDetail> psDEFIUDetailList = psSysModelCache.getModelList("PSDEFIUDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFIUDetailList == null) {
            psDEFIUDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEFIUDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFIUDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单更新明细发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFIUDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFIUDetailList);
         }

         for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
            psSysAppStorage.getPSDEFormStorage(psDEFIUDetail.getPSDEFORMID()).psDEFIUDetailList.add(psDEFIUDetail);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFormRF> psDEFormRFList = psSysModelCache.getModelList("PSDEFORMRF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFormRFList == null) {
            psDEFormRFList = new Vector<>();
            CallResult callResultxx = this.getPSDEFormRFsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormRFList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单引用发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFORMRF", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormRFList);
         }

         for (PSDEFormRF psDEFormRF : psDEFormRFList) {
            psSysAppStorage.getPSDEFormStorage(psDEFormRF.getMAJORPSDEFORMID()).psDEFormRFList.add(psDEFormRF);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEFormItemVR> psDEFormItemVRList = psSysModelCache.getModelList("PSDEFIVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFormItemVRList == null) {
            psDEFormItemVRList = new Vector<>();
            CallResult callResultxx = this.getPSDEFormItemVRsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormItemVRList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单项值规则发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFIVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormItemVRList);
         }

         for (PSDEFormItemVR psDEFormItemVR : psDEFormItemVRList) {
            psSysAppStorage.getPSDEFormStorage(psDEFormItemVR.getPSDEFORMID()).psDEFormItemVRList.add(psDEFormItemVR);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEFormLogic> psDEFormLogicList = psSysModelCache.getModelList("PSDEFORMLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEFormLogicList == null) {
            psDEFormLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEFormLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表单逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEFORMLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEFormLogicList);
         }

         for (PSDEFormLogic psDEFormLogic : psDEFormLogicList) {
            psSysAppStorage.getPSDEFormStorage(psDEFormLogic.getPSDEFORMID()).psDEFormLogicList.add(psDEFormLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEGRID");
      Vector<PSDEGrid> psDEGridList = psSysModelCache.getModelList("PSDEGRID", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEGridList == null) {
         psDEGridList = new Vector<>();
         CallResult callResultxx = this.getPSDEGridsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体表格发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEGRID", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGridList);
      }

      for (PSDEGrid psDEGrid : psDEGridList) {
         psSysAppStorage.getPSDEGridStorage(psDEGrid.getPSDEGRIDID()).psDEGrid = psDEGrid;
      }

      if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
         PSSysModelLog psSysModelLog2xxxxxxxxxx = psSysModelLogMap.get("PSDEGRIDCOL");
         if (psSysModelLog2xxxxxxxxxx == null) {
            psSysModelLog2xxxxxxxxxx = psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
         }

         Vector<PSDEGridColumn> psDEGridColumnList = psSysModelCache.getModelList("PSDEGRIDCOL", psSysModelLog2xxxxxxxxxx);
         if (psDEGridColumnList == null) {
            psDEGridColumnList = new Vector<>();
            CallResult callResultxx = this.getPSDEGridColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridColumnList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体表格项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGRIDCOL", psSysModelLog2xxxxxxxxxx, psDEGridColumnList);
         }

         for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            psSysAppStorage.getPSDEGridStorage(psDEGridColumn.getPSDEGRIDID()).psDEGridColumnList.add(psDEGridColumn);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEGEIUpdate> psDEGEIUpdateList = psSysModelCache.getModelList("PSDEGEIUPDATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEGEIUpdateList == null) {
            psDEGEIUpdateList = new Vector<>();
            CallResult callResultxx = this.getPSDEGEIUpdatesBySystem(psSystemApplication.getPSSYSTEMID(), psDEGEIUpdateList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表格编辑项更新发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGEIUPDATE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGEIUpdateList);
         }

         for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            psSysAppStorage.getPSDEGridStorage(psDEGEIUpdate.getPSDEGRIDID()).psDEGEIUpdateList.add(psDEGEIUpdate);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEGEIUDetail> psDEGEIUDetailList = psSysModelCache.getModelList("PSDEGEIUDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEGEIUDetailList == null) {
            psDEGEIUDetailList = new Vector<>();
            CallResult callResultxx = this.getPSDEGEIUDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGEIUDetailList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表格编辑项更新明细发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGEIUDETAIL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGEIUDetailList);
         }

         for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            psSysAppStorage.getPSDEGridStorage(psDEGEIUDetail.getPSDEGRIDID()).psDEGEIUDetailList.add(psDEGEIUDetail);
         }
      }

      if (this.getModelInstVer() >= 652 && nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEGridEditItemVR> psDEGridEditItemVRList = psSysModelCache.getModelList("PSDEGEIVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEGridEditItemVRList == null) {
            psDEGridEditItemVRList = new Vector<>();
            CallResult callResultxx = this.getPSDEGridEditItemVRsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridEditItemVRList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表格编辑项值规则发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGEIVR", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGridEditItemVRList);
         }

         for (PSDEGridEditItemVR psDEGridEditItemVR : psDEGridEditItemVRList) {
            psSysAppStorage.getPSDEGridStorage(psDEGridEditItemVR.getPSDEGRIDID()).psDEGridEditItemVRList.add(psDEGridEditItemVR);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEGridLogic> psDEGridLogicList = psSysModelCache.getModelList("PSDEGRIDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEGridLogicList == null) {
            psDEGridLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEGridLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询表格逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEGRIDLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEGridLogicList);
         }

         for (PSDEGridLogic psDEGridLogic : psDEGridLogicList) {
            psSysAppStorage.getPSDEGridStorage(psDEGridLogic.getPSDEGRIDID()).psDEGridLogicList.add(psDEGridLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDETREEVIEW");
      Vector<PSDETreeView> psDETreeViewList = psSysModelCache.getModelList("PSDETREEVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDETreeViewList == null) {
         psDETreeViewList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREEVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeViewList);
      }

      for (PSDETreeView psDETreeView : psDETreeViewList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeView.getPSDETREEVIEWID()).psDETreeView = psDETreeView;
      }

      Vector<PSDETreeNode> psDETreeNodeList = psSysModelCache.getModelList("PSDETREENODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDETreeNodeList == null) {
         psDETreeNodeList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeNodesBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树节点发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREENODE", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeNodeList);
      }

      for (PSDETreeNode psDETreeNode : psDETreeNodeList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeNode.getPSDETREEVIEWID()).psDETreeNodeList.add(psDETreeNode);
      }

      Vector<PSDETreeColumn> psDETreeColumnList = psSysModelCache.getModelList("PSDETREECOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDETreeColumnList == null) {
         psDETreeColumnList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeColumnList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树表格列发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREECOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeColumnList);
      }

      for (PSDETreeColumn psDETreeColumn : psDETreeColumnList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeColumn.getPSDETREEVIEWID()).psDETreeColumnList.add(psDETreeColumn);
      }

      Vector<PSDETreeNodeRS> psDETreeNodeRSList = psSysModelCache.getModelList("PSDETREENODERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDETreeNodeRSList == null) {
         psDETreeNodeRSList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeNodeRSesBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeRSList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树节点关系发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREENODERS", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeNodeRSList);
      }

      for (PSDETreeNodeRS psDETreeNodeRS : psDETreeNodeRSList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeNodeRS.getPSDETREEVIEWID()).psDETreeNodeRSList.add(psDETreeNodeRS);
      }

      Vector<PSDETreeNodeColumn> psDETreeNodeColumnList = psSysModelCache.getModelList(
         "PSDETREENODECOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      );
      if (psDETreeNodeColumnList == null) {
         psDETreeNodeColumnList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeNodeColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeColumnList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树节点关系发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREENODECOL", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeNodeColumnList);
      }

      for (PSDETreeNodeColumn psDETreeNodeColumn : psDETreeNodeColumnList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeNodeColumn.getPSDETREEVIEWID()).psDETreeNodeColumnList.add(psDETreeNodeColumn);
      }

      Vector<PSDETreeNodeRV> psDETreeNodeRVList = psSysModelCache.getModelList("PSDETREENODERV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDETreeNodeRVList == null) {
         psDETreeNodeRVList = new Vector<>();
         CallResult callResultxx = this.getPSDETreeNodeRVsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeRVList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体树节点引用视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDETREENODERV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeNodeRVList);
      }

      for (PSDETreeNodeRV psDETreeNodeRV : psDETreeNodeRVList) {
         psSysAppStorage.getPSDETreeViewStorage(psDETreeNodeRV.getPSDETREEVIEWID()).psDETreeNodeRVList.add(psDETreeNodeRV);
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDETreeLogic> psDETreeLogicList = psSysModelCache.getModelList("PSDETREELOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDETreeLogicList == null) {
            psDETreeLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDETreeLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询树视图逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDETREELOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDETreeLogicList);
         }

         for (PSDETreeLogic psDETreeLogic : psDETreeLogicList) {
            psSysAppStorage.getPSDETreeViewStorage(psDETreeLogic.getPSDETREEVIEWID()).psDETreeLogicList.add(psDETreeLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDECHART");
      Vector<PSDEChart> psDEChartList = psSysModelCache.getModelList("PSDECHART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEChartList == null) {
         psDEChartList = new Vector<>();
         CallResult callResultxx = this.getPSDEChartsBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体图表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDECHART", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEChartList);
      }

      for (PSDEChart psDEChart : psDEChartList) {
         psSysAppStorage.getPSDEChartStorage(psDEChart.getPSDECHARTID()).psDEChart = psDEChart;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEChartAxes> psDEChartAxesList = psSysModelCache.getModelList("PSDECHARTAXES", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEChartAxesList == null) {
            psDEChartAxesList = new Vector<>();
            CallResult callResultxx = this.getPSDEChartAxesesBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartAxesList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体图表坐标轴发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDECHARTAXES", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEChartAxesList);
         }

         for (PSDEChartAxes psDEChartAxes : psDEChartAxesList) {
            psSysAppStorage.getPSDEChartStorage(psDEChartAxes.getPSDECHARTID()).psDEChartAxesList.add(psDEChartAxes);
         }
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEChartSeries> psDEChartSeriesList = psSysModelCache.getModelList("PSDECHARTPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEChartSeriesList == null) {
            psDEChartSeriesList = new Vector<>();
            CallResult callResultxx = this.getPSDEChartSeriesesBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartSeriesList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体图表数据序列发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDECHARTPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEChartSeriesList);
         }

         for (PSDEChartSeries psDEChartSeries : psDEChartSeriesList) {
            psSysAppStorage.getPSDEChartStorage(psDEChartSeries.getPSDECHARTID()).psDEChartSeriesList.add(psDEChartSeries);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEChartLogic> psDEChartLogicList = psSysModelCache.getModelList("PSDECHARTLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEChartLogicList == null) {
            psDEChartLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEChartLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询图表逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDECHARTLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEChartLogicList);
         }

         for (PSDEChartLogic psDEChartLogic : psDEChartLogicList) {
            psSysAppStorage.getPSDEChartStorage(psDEChartLogic.getPSDECHARTID()).psDEChartLogicList.add(psDEChartLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDELIST");
      Vector<PSDEList> psDEListList = psSysModelCache.getModelList("PSDELIST", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEListList == null) {
         psDEListList = new Vector<>();
         CallResult callResultxx = this.getPSDEListsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体列表发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDELIST", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEListList);
      }

      for (PSDEList psDEList : psDEListList) {
         psSysAppStorage.getPSDEListStorage(psDEList.getPSDELISTID()).psDEList = psDEList;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEListItem> psDEListItemList = psSysModelCache.getModelList("PSDELISTITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEListItemList == null) {
            psDEListItemList = new Vector<>();
            CallResult callResultxx = this.getPSDEListItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体列表数据项发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDELISTITEM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEListItemList);
         }

         for (PSDEListItem psDEListItem : psDEListItemList) {
            psSysAppStorage.getPSDEListStorage(psDEListItem.getPSDELISTID()).psDEListItemList.add(psDEListItem);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEListLogic> psDEListLogicList = psSysModelCache.getModelList("PSDELISTLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
         if (psDEListLogicList == null) {
            psDEListLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEListLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询列表逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDELISTLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEListLogicList);
         }

         for (PSDEListLogic psDEListLogic : psDEListLogicList) {
            psSysAppStorage.getPSDEListStorage(psDEListLogic.getPSDELISTID()).psDEListLogicList.add(psDEListLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEDATAVIEW");
      Vector<PSDEDataView> psDEDataViewList = psSysModelCache.getModelList("PSDEDATAVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEDataViewList == null) {
         psDEDataViewList = new Vector<>();
         CallResult callResultxx = this.getPSDEDataViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统实体数据视图发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEDATAVIEW", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataViewList);
      }

      for (PSDEDataView psDEDataView : psDEDataViewList) {
         psSysAppStorage.getPSDEDataViewStorage(psDEDataView.getPSDEDATAVIEWID()).psDEDataView = psDEDataView;
      }

      if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
         Vector<PSDEDataViewItem> psDEDataViewItemList = psSysModelCache.getModelList(
            "PSDELISTITEM_DV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEDataViewItemList == null) {
            psDEDataViewItemList = new Vector<>();
            CallResult callResultxx = this.getPSDEDataViewItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewItemList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询系统实体数据视图坐标轴发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDELISTITEM_DV", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataViewItemList);
         }

         for (PSDEDataViewItem psDEDataViewItem : psDEDataViewItemList) {
            psSysAppStorage.getPSDEDataViewStorage(psDEDataViewItem.getPSDEDATAVIEWID()).psDEDataViewItemList.add(psDEDataViewItem);
         }
      }

      if (this.getModelInstVer() >= 747) {
         Vector<PSDEDataViewLogic> psDEDataViewLogicList = psSysModelCache.getModelList(
            "PSDEDATAVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
         );
         if (psDEDataViewLogicList == null) {
            psDEDataViewLogicList = new Vector<>();
            CallResult callResultxx = this.getPSDEDataViewLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewLogicList);
            if (callResultxx.isError()) {
               throw new Exception(StringHelper.Format("查询卡片视图逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
            }

            psSysModelCache.updateModelList("PSDEDATAVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEDataViewLogicList);
         }

         for (PSDEDataViewLogic psDEDataViewLogic : psDEDataViewLogicList) {
            psSysAppStorage.getPSDEDataViewStorage(psDEDataViewLogic.getPSDEDATAVIEWID()).psDEDataViewLogicList.add(psDEDataViewLogic);
         }
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSSYSVIEWLOGIC");
      boolean bLoadDetail = true;
      Vector<PSSysViewLogic> psSysViewLogicList = psSysModelCache.getModelList("PSSYSVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psSysViewLogicList == null) {
         psSysViewLogicList = new Vector<>();
         CallResult callResultxx = this.getAllPSSysViewLogics2(psSystemApplication.getPSSYSTEMID(), psSysViewLogicList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图逻辑发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSVIEWLOGIC", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysViewLogicList);
      }

      psSysAppStorage.psSysViewLogicList.addAll(psSysViewLogicList);

      for (PSSysViewLogic psSysViewLogic : psSysViewLogicList) {
         psSysAppStorage.psSysViewLogicMap.put(psSysViewLogic.getPSSYSVIEWLOGICID(), psSysViewLogic);
         psSysAppStorage.getPSSysViewLogicStorage(psSysViewLogic.getPSSYSVIEWLOGICID()).psSysViewLogic = psSysViewLogic;
      }

      Vector<PSSysViewLogicParam> psSysViewLogicParamList = psSysModelCache.getModelList("PSSYSVIEWLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psSysViewLogicParamList == null) {
         psSysViewLogicParamList = new Vector<>();
         CallResult callResultxx = this.getPSSysViewLogicParamsBySystem(psSystemApplication.getPSSYSTEMID(), psSysViewLogicParamList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有视图逻辑发生参数发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSSYSVIEWLOGICPARAM", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psSysViewLogicParamList);
      }

      for (PSSysViewLogicParam psSysViewLogicParam : psSysViewLogicParamList) {
         psSysAppStorage.getPSSysViewLogicStorage(psSysViewLogicParam.getPSSYSVIEWLOGICID()).psSysViewLogicParamList.add(psSysViewLogicParam);
      }

      PSSysModelLog psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = psSysModelLogMap.get("PSDEWIZARD");
      Vector<PSDEWizard> psDEWizardList = psSysModelCache.getModelList("PSDEWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
      if (psDEWizardList == null) {
         psDEWizardList = new Vector<>();
         CallResult callResultxx = this.getPSDEWizardsBySystem(strPSSystemId, psDEWizardList);
         if (callResultxx.isError()) {
            throw new Exception(StringHelper.Format("查询系统所有实体向导发生错误，%1$s", callResultxx.getErrorInfo()));
         }

         psSysModelCache.updateModelList("PSDEWIZARD", psSysModelLogxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, psDEWizardList);
      }

      for (PSDEWizard psDEWizard : psDEWizardList) {
         PSDEWizardStorage psDEWizardStorage = psSysAppStorage.getPSDEWizardStorage(psDEWizard.getPSDEWIZARDID());
         psDEWizardStorage.psDEWizard = psDEWizard;
      }

      log.info(StringHelper.Format("预载系统应用[%1$s]耗时[%2$s]ms", strPSSysAppId, System.currentTimeMillis() - nBeginTime));
      return psSysAppStorage;
   }

   protected synchronized PSSysAppStorage getCurrentPSSysAppStorage() {
      ArrayList<PSSysAppStorage> stack = this.psSysAppStorageStack.get();
      return stack != null && stack.size() != 0 ? stack.get(0) : null;
   }

   @Override
   public synchronized void startLoadPSSysApp(String strPSSysAppId, int nLoadLevel) throws Exception {
      this.active();
      PSSysAppStorage psSysAppStorage = this.createPSSysAppStorage(strPSSysAppId, nLoadLevel);
      ArrayList<PSSysAppStorage> stack = this.psSysAppStorageStack.get();
      if (stack == null) {
         stack = new ArrayList<>();
         this.psSysAppStorageStack.set(stack);
      }

      stack.add(0, psSysAppStorage);
   }

   @Override
   public synchronized void stopLoadPSSysApp() throws Exception {
      this.active();
      ArrayList<PSSysAppStorage> stack = this.psSysAppStorageStack.get();
      if (stack != null && stack.size() != 0) {
         stack.remove(0);
      }
   }

   @Override
   public CallResult getAllPSSysImages(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysImageList, psSysImageList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysImages(strPSSystemId), psSysImageList, PSSysImage.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysImage(String strPSSysImageId, PSSysImage psSysImage) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysImageMap.get(strPSSysImageId) != null) {
         psSystemStorage.psSysImageMap.get(strPSSysImageId).CopyTo(psSysImage, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysImage(strPSSysImageId), psSysImage, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysCsses(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysCssList, psSysCssList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysCsses(strPSSystemId), psSysCssList, PSSysCss.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysCss(String strPSSysCssId, PSSysCss psSysCss) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysCssMap.get(strPSSysCssId) != null) {
         psSystemStorage.psSysCssMap.get(strPSSysCssId).CopyTo(psSysCss, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysCss(strPSSysCssId), psSysCss, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSubViewTypes(String strPSSystemId, Vector<PSSubViewType> psSubViewTypeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSubViewTypeList, psSubViewTypeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSubViewTypes(strPSSystemId), psSubViewTypeList, PSSubViewType.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSubViewType(String strPSSubViewTypeId, PSSubViewType psSubViewType) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSubViewTypeMap.get(strPSSubViewTypeId) != null) {
         psSystemStorage.psSubViewTypeMap.get(strPSSubViewTypeId).CopyTo(psSubViewType, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSubViewType(strPSSubViewTypeId), psSubViewType, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUniReses(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysUniResList, psSysUniResList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUniReses(strPSSystemId), psSysUniResList, PSSysUniRes.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUniRes(String strPSSysUniResId, PSSysUniRes psSysUniRes) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUniResMap.get(strPSSysUniResId) != null) {
         psSystemStorage.psSysUniResMap.get(strPSSysUniResId).CopyTo(psSysUniRes, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUniRes(strPSSysUniResId), psSysUniRes, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysBackServices(String strPSSystemId, Vector<PSSysBackService> psSysBackServiceList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysBackServiceList, psSystemStorage.psSysBackServiceList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysBackServices(strPSSystemId), psSysBackServiceList, PSSysBackService.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBackService(String strPSSysBackServiceId, PSSysBackService psSysBackService) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysBackServiceMap.get(strPSSysBackServiceId) != null) {
         psSystemStorage.psSysBackServiceMap.get(strPSSysBackServiceId).CopyTo(psSysBackService, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysBackService(strPSSysBackServiceId), psSysBackService, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysMsgTempls(String strPSSystemId, Vector<PSSysMsgTempl> psSysMsgTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysMsgTemplList, psSystemStorage.psSysMsgTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysMsgTempls(strPSSystemId), psSysMsgTemplList, PSSysMsgTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysMsgTempl(String strPSSysMsgTemplId, PSSysMsgTempl psSysMsgTempl) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysMsgTemplMap.get(strPSSysMsgTemplId) != null) {
         psSystemStorage.psSysMsgTemplMap.get(strPSSysMsgTemplId).CopyTo(psSysMsgTempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysMsgTempl(strPSSysMsgTemplId), psSysMsgTempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysPortlets(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysPortletList, psSystemStorage.psSysPortletList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPortlets(strPSSystemId), psSysPortletList, PSSysPortlet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPortlet(String strPSSysPortletId, PSSysPortlet psSysPortlet) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysPortletMap.get(strPSSysPortletId) != null) {
         psSystemStorage.psSysPortletMap.get(strPSSysPortletId).CopyTo(psSysPortlet, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysPortlet(strPSSysPortletId), psSysPortlet, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEList(String strPSDEListId, PSDEList psDEList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null) {
         psSysAppStorage.psDEListStorageMap.get(strPSDEListId).psDEList.CopyTo(psDEList, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEList(strPSDEListId), psDEList, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEListItems(String strPSDEListId, Vector<PSDEListItem> psDEListItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null) {
         for (PSDEListItem psDEListItem : psSysAppStorage.psDEListStorageMap.get(strPSDEListId).psDEListItemList) {
            PSDEListItem psDEListItem2 = new PSDEListItem();
            psDEListItem.CopyTo(psDEListItem2, true);
            psDEListItemList.add(psDEListItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEListItems(strPSDEListId), psDEListItemList, PSDEListItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysValueRules(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && this.copyList(psSystemStorage.psSysValueRuleList, psSysValueRuleList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.copyList(psSysAppStorage.psSysValueRuleList, psSysValueRuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysValueRules(strPSSystemId), psSysValueRuleList, PSSysValueRule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysValueRule(String strPSSysValueRuleId, PSSysValueRule psSysValueRule) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysValueRuleMap.get(strPSSysValueRuleId) != null) {
         psSystemStorage.psSysValueRuleMap.get(strPSSysValueRuleId).CopyTo(psSysValueRule, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysValueRule(strPSSysValueRuleId), psSysValueRule, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEOPPrivs(String strPSDataEntityId, Vector<PSDEOPPriv> psDEOPPrivList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEOPPrivList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEOPPrivList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEOPPrivs(strPSDataEntityId), psDEOPPrivList, PSDEOPPriv.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEMainStates(String strPSDEId, Vector<PSDEMainState> psDEMainStateList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEMainStateList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEMainStateList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEMainStates(strPSDEId), psDEMainStateList, PSDEMainState.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEMainStateRSs(String strPSDataEntityId, Vector<PSDEMainStateRS> psDEMainStateRSList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEMainStateRSList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEMainStateRSList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEMainStateRSs(strPSDataEntityId), psDEMainStateRSList, PSDEMainStateRS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEMainStateActions(String strPSDEMainStateId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
         for (PSDEMainStateAction psDEMainStateAction : psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId).psDEMainStateActionList) {
            PSDEMainStateAction psDEMainStateAction2 = new PSDEMainStateAction();
            psDEMainStateAction.CopyTo(psDEMainStateAction2, true);
            psDEMainStateActionList.add(psDEMainStateAction2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(
            this.getSQL_getPSDEMainStateActions(strPSDEMainStateId), psDEMainStateActionList, PSDEMainStateAction.class.getName(), "SYSTEM"
         );
      }
   }

   @Override
   public CallResult getPSDEMainStateOPPrivs(String strPSDEMainStateId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
         for (PSDEMainStateOPPriv psDEMainStateOPPriv : psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId).psDEMainStateOPPrivList) {
            PSDEMainStateOPPriv psDEMainStateOPPriv2 = new PSDEMainStateOPPriv();
            psDEMainStateOPPriv.CopyTo(psDEMainStateOPPriv2, true);
            psDEMainStateOPPrivList.add(psDEMainStateOPPriv2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(
            this.getSQL_getPSDEMainStateOPPrivs(strPSDEMainStateId), psDEMainStateOPPrivList, PSDEMainStateOPPriv.class.getName(), "SYSTEM"
         );
      }
   }

   @Override
   public CallResult getAllPSSysPDTViews(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysPDTViewList, psSystemStorage.psSysPDTViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPDTViews(strPSSystemId), psSysPDTViewList, PSSysPDTView.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPDTView(String strPSSysPDTViewId, PSSysPDTView psSysPDTView) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysPDTViewMap.get(strPSSysPDTViewId) != null) {
         psSystemStorage.psSysPDTViewMap.get(strPSSysPDTViewId).CopyTo(psSysPDTView, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysPDTView(strPSSysPDTViewId), psSysPDTView, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysPFPlugins(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysPFPluginList, psSysPFPluginList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPFPlugins(strPSSystemId), psSysPFPluginList, PSSysPFPlugin.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPFPlugin(String strPSSysPFPluginId, PSSysPFPlugin psSysPFPlugin) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysPFPluginMap.get(strPSSysPFPluginId) != null) {
         psSystemStorage.psSysPFPluginMap.get(strPSSysPFPluginId).CopyTo(psSysPFPlugin, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysPFPlugin(strPSSysPFPluginId), psSysPFPlugin, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysPFPluginTempls(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysPFPluginTemplList, psSysPFPluginTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPFPluginTempls(strPSSystemId), psSysPFPluginTemplList, PSSysPFPluginTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPFPluginTempl(String strPSSysPFPluginTemplId, PSSysPFPluginTempl psSysPFPluginTempl) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysPFPluginTemplMap.get(strPSSysPFPluginTemplId) != null) {
         psSystemStorage.psSysPFPluginTemplMap.get(strPSSysPFPluginTemplId).CopyTo(psSysPFPluginTempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysPFPluginTempl(strPSSysPFPluginTemplId), psSysPFPluginTempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeView(String strPSDETreeViewId, PSDETreeView psDETreeView) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeViewId) != null) {
         psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeViewId).psDETreeView.CopyTo(psDETreeView, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDETreeView(strPSDETreeViewId), psDETreeView, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeNodes(String strPSDETreeId, Vector<PSDETreeNode> psDETreeNodeList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
         for (PSDETreeNode psDETreeNode : psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeNodeList) {
            PSDETreeNode psDETreeNode2 = new PSDETreeNode();
            psDETreeNode.CopyTo(psDETreeNode2, true);
            psDETreeNodeList.add(psDETreeNode2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDETreeNodes(strPSDETreeId), psDETreeNodeList, PSDETreeNode.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeColumns(String strPSDETreeId, Vector<PSDETreeColumn> psDETreeColumnList) {
      if (this.getModelInstVer() < 363) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
         for (PSDETreeColumn psDETreeColumn : psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeColumnList) {
            PSDETreeColumn psDETreeColumn2 = new PSDETreeColumn();
            psDETreeColumn.CopyTo(psDETreeColumn2, true);
            psDETreeColumnList.add(psDETreeColumn2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDETreeColumns(strPSDETreeId), psDETreeColumnList, PSDETreeColumn.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeNodeColumns(String strPSDETreeId, Vector<PSDETreeNodeColumn> psDETreeNodeColumnList) {
      if (this.getModelInstVer() < 363) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
         for (PSDETreeNodeColumn psDETreeNodeColumn : psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeNodeColumnList) {
            PSDETreeNodeColumn psDETreeNodeColumn2 = new PSDETreeNodeColumn();
            psDETreeNodeColumn.CopyTo(psDETreeNodeColumn2, true);
            psDETreeNodeColumnList.add(psDETreeNodeColumn2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDETreeNodeColumns(strPSDETreeId), psDETreeNodeColumnList, PSDETreeNodeColumn.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeNodeRSes(String strPSDETreeId, Vector<PSDETreeNodeRS> psDETreeNodeRSList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
         for (PSDETreeNodeRS psDETreeNodeRS : psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeNodeRSList) {
            PSDETreeNodeRS psDETreeNodeRS2 = new PSDETreeNodeRS();
            psDETreeNodeRS.CopyTo(psDETreeNodeRS2, true);
            psDETreeNodeRSList.add(psDETreeNodeRS2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDETreeNodeRSes(strPSDETreeId), psDETreeNodeRSList, PSDETreeNodeRS.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDETreeNodeRVs(String strPSDETreeId, Vector<PSDETreeNodeRV> psDETreeNodeRVList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
         for (PSDETreeNodeRV psDETreeNodeRV : psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeNodeRVList) {
            PSDETreeNodeRV psDETreeNodeRV2 = new PSDETreeNodeRV();
            psDETreeNodeRV.CopyTo(psDETreeNodeRV2, true);
            psDETreeNodeRVList.add(psDETreeNodeRV2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDETreeNodeRVs(strPSDETreeId), psDETreeNodeRVList, PSDETreeNodeRV.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysCounters(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysCounterList, psSystemStorage.psSysCounterList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysCounters(strPSSystemId), psSysCounterList, PSSysCounter.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysCounter(String strPSSysCounterId, PSSysCounter psSysCounter) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysCounterMap.get(strPSSysCounterId) != null) {
         psSystemStorage.psSysCounterMap.get(strPSSysCounterId).CopyTo(psSysCounter, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysCounter(strPSSysCounterId), psSysCounter, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysDictCats(String strPSSystemId, Vector<PSSysDictCat> psSysDictCatList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysDictCatList, psSysDictCatList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDictCats(strPSSystemId), psSysDictCatList, PSSysDictCat.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDictCat(String strPSSysDictCatId, PSSysDictCat psSysDictCat) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDictCatMap.get(strPSSysDictCatId) != null) {
         psSystemStorage.psSysDictCatMap.get(strPSSysDictCatId).CopyTo(psSysDictCat, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDictCat(strPSSysDictCatId), psSysDictCat, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysEditorStyles(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysEditorStyleList, psSystemStorage.psSysEditorStyleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysEditorStyles(strPSSystemId), psSysEditorStyleList, PSSysEditorStyle.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEditorStyle(String strPSSysEditorStyleId, PSSysEditorStyle psSysEditorStyle) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysEditorStyleMap.get(strPSSysEditorStyleId) != null) {
         psSystemStorage.psSysEditorStyleMap.get(strPSSysEditorStyleId).CopyTo(psSysEditorStyle, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysEditorStyle(strPSSysEditorStyleId), psSysEditorStyle, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEDBIndexs(String strPSDataEntityId, Vector<PSDEDBIndex> psDEDBIndexList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDBIndexList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDBIndexList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDBIndexs(strPSDataEntityId), psDEDBIndexList, PSDEDBIndex.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDBIndexFields(String strPSDEDBIndexId, Vector<PSDEDBIndexField> psDEDBIndexFieldList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEDBIndexStorage(strPSDEDBIndexId) != null) {
         for (PSDEDBIndexField psDEDBIndexField : psSystemStorage.getPSDEDBIndexStorage(strPSDEDBIndexId).psDEDBIndexFieldList) {
            PSDEDBIndexField psDEDBIndexField2 = new PSDEDBIndexField();
            psDEDBIndexField.CopyTo(psDEDBIndexField2, true);
            psDEDBIndexFieldList.add(psDEDBIndexField2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEDBIndexFields(strPSDEDBIndexId), psDEDBIndexFieldList, PSDEDBIndexField.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEReports(String strPSDEId, Vector<PSDEReport> psDEReportList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && this.fromList(psDEReportList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEReportList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEReportList, psSysAppStorage.getPSDataEntityStorage(strPSDEId).psDEReportList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEReports(strPSDEId), psDEReportList, PSDEReport.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEReportItems(String strPSDEReportId, Vector<PSDEReportItem> psDEReportItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEReportStorage(strPSDEReportId) != null) {
         for (PSDEReportItem psDEReportItem : psSystemStorage.getPSDEReportStorage(strPSDEReportId).psDEReportItemList) {
            PSDEReportItem psDEReportItem2 = new PSDEReportItem();
            psDEReportItem.CopyTo(psDEReportItem2, true);
            psDEReportItemList.add(psDEReportItem2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.getPSDEReportStorage(strPSDEReportId) != null) {
            for (PSDEReportItem psDEReportItem : psSysAppStorage.getPSDEReportStorage(strPSDEReportId).psDEReportItemList) {
               PSDEReportItem psDEReportItem2 = new PSDEReportItem();
               psDEReportItem.CopyTo(psDEReportItem2, true);
               psDEReportItemList.add(psDEReportItem2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDEReportItems(strPSDEReportId), psDEReportItemList, PSDEReportItem.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEPrints(String strPSDEId, Vector<PSDEPrint> psDEPrintList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && this.fromList(psDEPrintList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEPrintList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEPrintList, psSysAppStorage.getPSDataEntityStorage(strPSDEId).psDEPrintList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEPrints(strPSDEId), psDEPrintList, PSDEPrint.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysViewLogics(String strPSSystemId, Vector<PSSysViewLogic> psSysViewLogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysViewLogicList, psSystemStorage.psSysViewLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysViewLogics(strPSSystemId), psSysViewLogicList, PSSysViewLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysViewLogic(String strPSSysViewLogicId, PSSysViewLogic psSysViewLogic) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysViewLogicMap.get(strPSSysViewLogicId) != null) {
         psSystemStorage.psSysViewLogicMap.get(strPSSysViewLogicId).CopyTo(psSysViewLogic, true);
         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.psSysViewLogicMap.get(strPSSysViewLogicId) != null) {
            psSysAppStorage.psSysViewLogicMap.get(strPSSysViewLogicId).CopyTo(psSysViewLogic, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysViewLogic(strPSSysViewLogicId), psSysViewLogic, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEViewLogics(String strPSDEViewId, Vector<PSDEViewLogic> psDEViewLogicList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null) {
         ArrayList<PSDEViewLogic> psDEViewLogicList2 = psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId).psDEViewLogicList;
         if (psDEViewLogicList2 != null) {
            for (PSDEViewLogic psDEViewLogic : psDEViewLogicList2) {
               PSDEViewLogic psDEViewLogic2 = new PSDEViewLogic();
               psDEViewLogic.CopyTo(psDEViewLogic2, true);
               psDEViewLogicList.add(psDEViewLogic2);
            }

            return new CallResult();
         }
      }

      return this.selectMulti(this.getSQL_getPSDEViewLogics(strPSDEViewId), psDEViewLogicList, PSDEViewLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEViewEngines(String strPSDEViewId, Vector<PSDEViewEngine> psDEViewEngineList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null) {
         ArrayList<PSDEViewEngine> psDEViewEngineList2 = psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId).psDEViewEngineList;
         if (psDEViewEngineList2 != null) {
            for (PSDEViewEngine psDEViewEngine : psDEViewEngineList2) {
               PSDEViewEngine psDEViewEngine2 = new PSDEViewEngine();
               psDEViewEngine.CopyTo(psDEViewEngine2, true);
               psDEViewEngineList.add(psDEViewEngine2);
            }

            return new CallResult();
         }
      }

      return this.selectMulti(this.getSQL_getPSDEViewEngines(strPSDEViewId), psDEViewEngineList, PSDEViewEngine.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDEUIActionGroups(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && this.fromList(psDEUIActionGroupList, psSystemStorage.psDEUIActionGroupList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psDEUIActionGroupList, psSysAppStorage.psDEUIActionGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDEUIActionGroups(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysActors(String strPSSystemId, Vector<PSSysActor> psSysActorList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysActorList, psSystemStorage.psSysActorList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysActors(strPSSystemId), psSysActorList, PSSysActor.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysActor(String strPSSysActorId, PSSysActor psSysActor) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysActorMap.get(strPSSysActorId) != null) {
         psSystemStorage.psSysActorMap.get(strPSSysActorId).CopyTo(psSysActor, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysActor(strPSSysActorId), psSysActor, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUserCases(String strPSSystemId, Vector<PSSysUserCase> psSysUserCaseList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUserCaseList, psSystemStorage.psSysUserCaseList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUserCases(strPSSystemId), psSysUserCaseList, PSSysUserCase.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserCase(String strPSSysUserCaseId, PSSysUserCase psSysUserCase) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUserCaseMap.get(strPSSysUserCaseId) != null) {
         psSystemStorage.psSysUserCaseMap.get(strPSSysUserCaseId).CopyTo(psSysUserCase, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUserCase(strPSSysUserCaseId), psSysUserCase, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUserCaseRSs(String strPSSystemId, Vector<PSSysUserCaseRS> psSysUserCaseRSList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUserCaseRSList, psSystemStorage.psSysUserCaseRSList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUserCaseRSs(strPSSystemId), psSysUserCaseRSList, PSSysUserCaseRS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserCaseRS(String strPSSysUserCaseRSId, PSSysUserCaseRS psSysUserCaseRS) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUserCaseRSMap.get(strPSSysUserCaseRSId) != null) {
         psSystemStorage.psSysUserCaseRSMap.get(strPSSysUserCaseRSId).CopyTo(psSysUserCaseRS, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUserCaseRS(strPSSysUserCaseRSId), psSysUserCaseRS, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysTestCases(String strPSSystemId, Vector<PSSysTestCase> psSysTestCaseList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && this.fromList(psSysTestCaseList, psSystemStorage.psSysTestCaseList)) {
         return new CallResult();
      } else {
         return this.getModelInstVer() >= 602
            ? this.selectMulti(this.getSQL_getAllPSSysTestCases2(strPSSystemId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM")
            : this.selectMulti(this.getSQL_getAllPSSysTestCases(strPSSystemId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysTestCase(String strPSSysTestCaseId, PSSysTestCase psSysTestCase) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysTestCaseMap.get(strPSSysTestCaseId) != null) {
         psSystemStorage.psSysTestCaseMap.get(strPSSysTestCaseId).CopyTo(psSysTestCase, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysTestCase(strPSSysTestCaseId), psSysTestCase, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysTestCaseInputs(String strPSSysTestCaseId, Vector<PSSysTestCaseInput> psSysTestCaseInputList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysTestCaseStorage(strPSSysTestCaseId) != null
            && this.fromList(psSysTestCaseInputList, psSystemStorage.getPSSysTestCaseStorage(strPSSysTestCaseId).psSysTestCaseInputList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysTestCaseInputs(strPSSysTestCaseId), psSysTestCaseInputList, PSSysTestCaseInput.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysTestCaseAsserts(String strPSSysTestCaseInputId, Vector<PSSysTestCaseAssert> psSysTestCaseAssertList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysTestCaseInputStorage(strPSSysTestCaseInputId) != null
            && this.fromList(psSysTestCaseAssertList, psSystemStorage.getPSSysTestCaseInputStorage(strPSSysTestCaseInputId).psSysTestCaseAssertList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSSysTestCaseAsserts(strPSSysTestCaseInputId), psSysTestCaseAssertList, PSSysTestCaseAssert.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getAllPSSysTestDatas(String strPSSystemId, Vector<PSSysTestData> psSysTestDataList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysTestDataList, psSystemStorage.psSysTestDataList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysTestDatas(strPSSystemId), psSysTestDataList, PSSysTestData.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysTestData(String strPSSysTestDataId, PSSysTestData psSysTestData) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysTestDataMap.get(strPSSysTestDataId) != null) {
         psSystemStorage.psSysTestDataMap.get(strPSSysTestDataId).CopyTo(psSysTestData, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysTestData(strPSSysTestDataId), psSysTestData, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysTestDataItems(String strPSSysTestDataId, Vector<PSSysTestDataItem> psSysTestDataItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysTestDataStorage(strPSSysTestDataId) != null
            && this.fromList(psSysTestDataItemList, psSystemStorage.getPSSysTestDataStorage(strPSSysTestDataId).psSysTestDataItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysTestDataItems(strPSSysTestDataId), psSysTestDataItemList, PSSysTestDataItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSampleValues(String strPSSystemId, Vector<PSSysSampleValue> psSysSampleValueList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysSampleValueList, psSystemStorage.psSysSampleValueList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSampleValues(strPSSystemId), psSysSampleValueList, PSSysSampleValue.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSampleValue(String strPSSysSampleValueId, PSSysSampleValue psSysSampleValue) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysSampleValueMap.get(strPSSysSampleValueId) != null) {
         psSystemStorage.psSysSampleValueMap.get(strPSSysSampleValueId).CopyTo(psSysSampleValue, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSampleValue(strPSSysSampleValueId), psSysSampleValue, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUserModes(String strPSSystemId, Vector<PSSysUserMode> psSysUserModeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUserModeList, psSystemStorage.psSysUserModeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUserModes(strPSSystemId), psSysUserModeList, PSSysUserMode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserMode(String strPSSysUserModeId, PSSysUserMode psSysUserMode) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUserModeMap.get(strPSSysUserModeId) != null) {
         psSystemStorage.psSysUserModeMap.get(strPSSysUserModeId).CopyTo(psSysUserMode, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUserMode(strPSSysUserModeId), psSysUserMode, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppUserModes(String strPSApplicationId, Vector<PSAppUserMode> psAppUserModes) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppUserModes, psSysAppStorage.psAppUserModeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppUserModes(strPSApplicationId), psAppUserModes, PSAppUserMode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppUIThemes(String strPSApplicationId, Vector<PSAppUITheme> psAppUIThemes) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppUIThemes, psSysAppStorage.psAppUIThemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppUIThemes(strPSApplicationId), psAppUIThemes, PSAppUITheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERDEFMaps(String strPSDERId, Vector<PSDERDEFMap> psDERDEFMapList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDERStorage(strPSDERId) != null) {
         for (PSDERDEFMap psDERDEFMap : psSystemStorage.getPSDERStorage(strPSDERId).psDERDEFMapList) {
            PSDERDEFMap psDERDEFMap2 = new PSDERDEFMap();
            psDERDEFMap.CopyTo(psDERDEFMap2, true);
            psDERDEFMapList.add(psDERDEFMap2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDERDEFMaps(strPSDERId), psDERDEFMapList, PSDERDEFMap.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysERMaps(String strPSSystemId, Vector<PSSysERMap> psSysERMapList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysERMapList, psSystemStorage.psSysERMapList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysERMaps(strPSSystemId), psSysERMapList, PSSysERMap.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysERMap(String strPSSysERMapId, PSSysERMap psSysERMap) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysERMapMap.get(strPSSysERMapId) != null) {
         psSystemStorage.psSysERMapMap.get(strPSSysERMapId).CopyTo(psSysERMap, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysERMap(strPSSysERMapId), psSysERMap, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysERMapNodes(String strPSSysERMapId, Vector<PSSysERMapNode> psSysERMapNodeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysERMapStorage(strPSSysERMapId) != null
            && this.fromList(psSysERMapNodeList, psSystemStorage.getPSSysERMapStorage(strPSSysERMapId).psSysERMapNodeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysERMapNodes(strPSSysERMapId), psSysERMapNodeList, PSSysERMapNode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysUCMaps(String strPSSystemId, Vector<PSSysUCMap> psSysUCMapList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUCMapList, psSystemStorage.psSysUCMapList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUCMaps(strPSSystemId), psSysUCMapList, PSSysUCMap.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUCMap(String strPSSysUCMapId, PSSysUCMap psSysUCMap) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUCMapMap.get(strPSSysUCMapId) != null) {
         psSystemStorage.psSysUCMapMap.get(strPSSysUCMapId).CopyTo(psSysUCMap, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUCMap(strPSSysUCMapId), psSysUCMap, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysUCMapNodes(String strPSSysUCMapId, Vector<PSSysUCMapNode> psSysUCMapNodeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysUCMapStorage(strPSSysUCMapId) != null
            && this.fromList(psSysUCMapNodeList, psSystemStorage.getPSSysUCMapStorage(strPSSysUCMapId).psSysUCMapNodeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysUCMapNodes(strPSSysUCMapId), psSysUCMapNodeList, PSSysUCMapNode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysDynaModels(String strPSSystemId, Vector<PSSysDynaModel> psSysDynaModelList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysDynaModelList, psSystemStorage.psSysDynaModelList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDynaModels(strPSSystemId), psSysDynaModelList, PSSysDynaModel.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDynaModel(String strPSSysDynaModelId, PSSysDynaModel psSysDynaModel) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDynaModelMap.get(strPSSysDynaModelId) != null) {
         psSystemStorage.psSysDynaModelMap.get(strPSSysDynaModelId).CopyTo(psSysDynaModel, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDynaModel(strPSSysDynaModelId), psSysDynaModel, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysDynaModelAttrs(String strPSSysDynaModelId, Vector<PSSysDynaModelAttr> psSysDynaModelAttrList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysDynaModelStorage(strPSSysDynaModelId) != null
            && this.fromList(psSysDynaModelAttrList, psSystemStorage.getPSSysDynaModelStorage(strPSSysDynaModelId).psSysDynaModelAttrList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDynaModelAttrs(strPSSysDynaModelId), psSysDynaModelAttrList, PSSysDynaModelAttr.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSFPubs(String strPSSystemId, Vector<PSSysSFPub> psSysSFPubList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysSFPubList, psSystemStorage.psSysSFPubList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSFPubs(strPSSystemId), psSysSFPubList, PSSysSFPub.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSFPub(String strPSSysSFPubId, PSSysSFPub psSysSFPub) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysSFPubMap.get(strPSSysSFPubId) != null) {
         psSystemStorage.psSysSFPubMap.get(strPSSysSFPubId).CopyTo(psSysSFPub, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSFPub(strPSSysSFPubId), psSysSFPub, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEGEIUpdates(String strPSDEGridId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
         for (PSDEGEIUpdate psDEGEIUpdate : psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGEIUpdateList) {
            PSDEGEIUpdate psDEGEIUpdate2 = new PSDEGEIUpdate();
            psDEGEIUpdate.CopyTo(psDEGEIUpdate2, true);
            psDEGEIUpdateList.add(psDEGEIUpdate2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEGEIUpdates(strPSDEGridId), psDEGEIUpdateList, PSDEGEIUpdate.class.getName(), "SYSTEM");
      }
   }

   protected String getSQL_getPSDEGEIUpdates(String strPSDEGridId) {
      return strPSDEGridId.indexOf("SRFTEMPKEY:") == 0
         ? StringHelper.Format("select t1.* from V_PSDEGEIUPDATE_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 ", strPSDEGridId)
         : StringHelper.Format("select t1.* from V_SRFPSDEGEIUPDATE t1 where  t1.PSDEGRIDID='%1$s' ", strPSDEGridId);
   }

   public CallResult getPSDEGEIUpdatesBySystem(String strPSSystemId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
      return this.selectMulti(this.getSQL_getPSDEGEIUpdatesBySystem(strPSSystemId), psDEGEIUpdateList, PSDEGEIUpdate.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDEGEIUpdatesBySystem(String strPSSystemId) {
      return StringHelper.Format(
         "select t1.* from V_SRFPSDEGEIUPDATE t1  inner join  t_srfpsdegrid t2 on t1.psdegridid = t2.psdegridid inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ",
         strPSSystemId
      );
   }

   @Override
   public CallResult getPSDEGEIUDetails(String strPSDEGridId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
         for (PSDEGEIUDetail psDEGEIUDetail : psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGEIUDetailList) {
            PSDEGEIUDetail psDEGEIUDetail2 = new PSDEGEIUDetail();
            psDEGEIUDetail.CopyTo(psDEGEIUDetail2, true);
            psDEGEIUDetailList.add(psDEGEIUDetail2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEGEIUDetails(strPSDEGridId), psDEGEIUDetailList, PSDEGEIUDetail.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEWizards(String strPSDEId, Vector<PSDEWizard> psDEWizardList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEWizardList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEWizardList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEWizards(strPSDEId), psDEWizardList, PSDEWizard.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEWizardSteps(String strPSDEWizardId, Vector<PSDEWizardStep> psDEWizardStepList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
         for (PSDEWizardStep psDEWizardStep : psSystemStorage.getPSDEWizardStorage(strPSDEWizardId).psDEWizardStepList) {
            PSDEWizardStep psDEWizardStep2 = new PSDEWizardStep();
            psDEWizardStep.CopyTo(psDEWizardStep2, true);
            psDEWizardStepList.add(psDEWizardStep2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEWizardSteps(strPSDEWizardId), psDEWizardStepList, PSDEWizardStep.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEWizardForms(String strPSDEWizardId, Vector<PSDEWizardForm> psDEWizardFormList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
         for (PSDEWizardForm psDEWizardForm : psSystemStorage.getPSDEWizardStorage(strPSDEWizardId).psDEWizardFormList) {
            PSDEWizardForm psDEWizardForm2 = new PSDEWizardForm();
            psDEWizardForm.CopyTo(psDEWizardForm2, true);
            psDEWizardFormList.add(psDEWizardForm2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEWizardForms(strPSDEWizardId), psDEWizardFormList, PSDEWizardForm.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysDataSyncAgents(String strPSSystemId, Vector<PSSysDataSyncAgent> psSysDataSyncAgentList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysDataSyncAgentList, psSystemStorage.psSysDataSyncAgentList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDataSyncAgents(strPSSystemId), psSysDataSyncAgentList, PSSysDataSyncAgent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDataSyncAgent(String strPSSysDataSyncAgentId, PSSysDataSyncAgent psSysDataSyncAgent) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDataSyncAgentMap.get(strPSSysDataSyncAgentId) != null) {
         psSystemStorage.psSysDataSyncAgentMap.get(strPSSysDataSyncAgentId).CopyTo(psSysDataSyncAgent, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDataSyncAgent(strPSSysDataSyncAgentId), psSysDataSyncAgent, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEDataSyncs(String strPSDEId, Vector<PSDEDataSync> psDEDataSyncList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEDataSyncList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEDataSyncList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataSyncs(strPSDEId), psDEDataSyncList, PSDEDataSync.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysUserDRs(String strPSSystemId, Vector<PSSysUserDR> psSysUserDRList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUserDRList, psSystemStorage.psSysUserDRList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUserDRs(strPSSystemId), psSysUserDRList, PSSysUserDR.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserDR(String strPSSysUserDRId, PSSysUserDR psSysUserDR) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUserDRMap.get(strPSSysUserDRId) != null) {
         psSystemStorage.psSysUserDRMap.get(strPSSysUserDRId).CopyTo(psSysUserDR, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUserDR(strPSSysUserDRId), psSysUserDR, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysBDSchemes(String strPSSystemId, Vector<PSSysBDScheme> psSysBDSchemeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysBDSchemeList, psSystemStorage.psSysBDSchemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysBDSchemes(strPSSystemId), psSysBDSchemeList, PSSysBDScheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDScheme(String strPSSysBDSchemeId, PSSysBDScheme psSysBDScheme) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysBDSchemeMap.get(strPSSysBDSchemeId) != null) {
         psSystemStorage.psSysBDSchemeMap.get(strPSSysBDSchemeId).CopyTo(psSysBDScheme, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysBDScheme(strPSSysBDSchemeId), psSysBDScheme, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppLans(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
      if (this.getModelInstVer() < 96) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppLans, psSysAppStorage.psAppLanList)
         ? new CallResult()
         : this.selectMultiValid(this.getSQL_getAllPSAppLans(strPSApplicationId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDModules(String strPSSysBDSchemeId, Vector<PSSysBDModule> psSysBDModuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null
            && this.fromList(psSysBDModuleList, psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId).psSysBDModuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDModules(strPSSysBDSchemeId), psSysBDModuleList, PSSysBDModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDParts(String strPSSysBDSchemeId, Vector<PSSysBDPart> psSysBDPartList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null
            && this.fromList(psSysBDPartList, psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId).psSysBDPartList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDParts(strPSSysBDSchemeId), psSysBDPartList, PSSysBDPart.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDTables(String strPSSysBDSchemeId, Vector<PSSysBDTable> psSysBDTableList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null
            && this.fromList(psSysBDTableList, psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId).psSysBDTableList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDTables(strPSSysBDSchemeId), psSysBDTableList, PSSysBDTable.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDTableRSes(String strPSSysBDSchemeId, Vector<PSSysBDTableRS> psSysBDTableRSList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null
            && this.fromList(psSysBDTableRSList, psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId).psSysBDTableRSList)
         ? new CallResult()
         : this.selectMultiValid(this.getSQL_getPSSysBDTableRSes(strPSSysBDSchemeId), psSysBDTableRSList, PSSysBDTableRS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDColumns(String strPSSysBDTableId, Vector<PSSysBDColumn> psSysBDColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null
            && this.fromList(psSysBDColumnList, psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId).psSysBDColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDColumns(strPSSysBDTableId), psSysBDColumnList, PSSysBDColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDColSets(String strPSSysBDTableId, Vector<PSSysBDColSet> psSysBDColSetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null
            && this.fromList(psSysBDColSetList, psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId).psSysBDColSetList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDColSets(strPSSysBDTableId), psSysBDColSetList, PSSysBDColSet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDTableDEs(String strPSSysBDTableId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null
            && this.fromList(psSysBDTableDEList, psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId).psSysBDTableDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDTableDEs(strPSSysBDTableId), psSysBDTableDEList, PSSysBDTableDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBDTableDERs(String strPSSysBDTableId, Vector<PSSysBDTableDER> psSysBDTableDERList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null
            && this.fromList(psSysBDTableDERList, psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId).psSysBDTableDERList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBDTableDERs(strPSSysBDTableId), psSysBDTableDERList, PSSysBDTableDER.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEBDTables(String strPSDEId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psSysBDTableDEList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEBDTableList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEBDTables(strPSDEId), psSysBDTableDEList, PSSysBDTable.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSViewMsgs(String strPSSystemId, Vector<PSViewMsg> psViewMsgList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psViewMsgList, psSystemStorage.psViewMsgList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSViewMsgs(strPSSystemId), psViewMsgList, PSViewMsg.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSViewMsg(String strPSViewMsgId, PSViewMsg psViewMsg) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psViewMsgMap.get(strPSViewMsgId) != null) {
         psSystemStorage.psViewMsgMap.get(strPSViewMsgId).CopyTo(psViewMsg, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSViewMsg(strPSViewMsgId), psViewMsg, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSViewMsgGroups(String strPSSystemId, Vector<PSViewMsgGroup> psViewMsgGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psViewMsgGroupList, psSystemStorage.psViewMsgGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSViewMsgGroups(strPSSystemId), psViewMsgGroupList, PSViewMsgGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSViewMsgGroup(String strPSViewMsgGroupId, PSViewMsgGroup psViewMsgGroup) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psViewMsgGroupMap.get(strPSViewMsgGroupId) != null) {
         psSystemStorage.psViewMsgGroupMap.get(strPSViewMsgGroupId).CopyTo(psViewMsgGroup, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSViewMsgGroup(strPSViewMsgGroupId), psViewMsgGroup, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSViewMsgGroupDetails(String strPSViewMsgGroupId, Vector<PSViewMsgGroupDetail> psViewMsgGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSViewMsgGroupStorage(strPSViewMsgGroupId) != null
            && this.fromList(psViewMsgGroupDetailList, psSystemStorage.getPSViewMsgGroupStorage(strPSViewMsgGroupId).psViewMsgGroupDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSViewMsgGroupDetails(strPSViewMsgGroupId), psViewMsgGroupDetailList, PSViewMsgGroupDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataExports(String strPSDEId, Vector<PSDEDataExport> psDEDataExportList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && this.fromList(psDEDataExportList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEDataExportList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEDataExportList, psSysAppStorage.getPSDataEntityStorage(strPSDEId).psDEDataExportList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataExports(strPSDEId), psDEDataExportList, PSDEDataExport.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataExportItems(String strPSDEDataExportId, Vector<PSDEGridColumn> psDEGridColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDEDataExportStorageMap.get(strPSDEDataExportId) != null) {
         for (PSDEGridColumn psDEGridColumn : psSystemStorage.psDEDataExportStorageMap.get(strPSDEDataExportId).psDEGridColumnList) {
            PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
            psDEGridColumn.CopyTo(psDEGridColumn2, true);
            psDEGridColumnList.add(psDEGridColumn2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.psDEDataExportStorageMap.get(strPSDEDataExportId) != null) {
            for (PSDEGridColumn psDEGridColumn : psSysAppStorage.psDEDataExportStorageMap.get(strPSDEDataExportId).psDEGridColumnList) {
               PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
               psDEGridColumn.CopyTo(psDEGridColumn2, true);
               psDEGridColumnList.add(psDEGridColumn2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(this.getSQL_getPSDEDataExportItems(strPSDEDataExportId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSDEDataImports(String strPSDEId, Vector<PSDEDataImport> psDEDataImportList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
         && this.fromList(psDEDataImportList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEDataImportList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEDataImportList, psSysAppStorage.getPSDataEntityStorage(strPSDEId).psDEDataImportList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataImports(strPSDEId), psDEDataImportList, PSDEDataImport.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataImportItems(String strPSDEDataImportId, Vector<PSDEDataImportItem> psDEDataImportItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDEDataImportStorageMap.get(strPSDEDataImportId) != null) {
         for (PSDEDataImportItem psDEDataImportItem : psSystemStorage.psDEDataImportStorageMap.get(strPSDEDataImportId).psDEDataImportItemList) {
            PSDEDataImportItem psDEDataImportItem2 = new PSDEDataImportItem();
            psDEDataImportItem.CopyTo(psDEDataImportItem2, true);
            psDEDataImportItemList.add(psDEDataImportItem2);
         }

         return new CallResult();
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.psDEDataImportStorageMap.get(strPSDEDataImportId) != null) {
            for (PSDEDataImportItem psDEDataImportItem : psSysAppStorage.psDEDataImportStorageMap.get(strPSDEDataImportId).psDEDataImportItemList) {
               PSDEDataImportItem psDEDataImportItem2 = new PSDEDataImportItem();
               psDEDataImportItem.CopyTo(psDEDataImportItem2, true);
               psDEDataImportItemList.add(psDEDataImportItem2);
            }

            return new CallResult();
         } else {
            return this.selectMulti(
               this.getSQL_getPSDEDataImportItems(strPSDEDataImportId), psDEDataImportItemList, PSDEDataImportItem.class.getName(), "SYSTEM"
            );
         }
      }
   }

   @Override
   public CallResult getPSDEFInputTipsByDataEntity(String strPSDEId, Vector<PSDEFInputTip> psDEFInputTipList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEFInputTipList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEFInputTipList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFInputTipsByDataEntity(strPSDEId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFInputTipsBySystem(String strPSSystemId, Vector<PSDEFInputTip> psDEFInputTipList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDEFInputTipList, psSystemStorage.psDEFInputTipList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFInputTipsBySystem3(strPSSystemId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionWizards(String strPSDEId, Vector<PSDEActionWizard> psDEActionWizardList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEActionWizardList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEActionWizardList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActionWizards(strPSDEId), psDEActionWizardList, PSDEActionWizard.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionWizardItems(String strPSDEActionWizardId, Vector<PSDEAWItem> psDEActionWizardItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEActionWizardStorage(strPSDEActionWizardId) != null
            && this.fromList(psDEActionWizardItemList, psSystemStorage.getPSDEActionWizardStorage(strPSDEActionWizardId).psDEActionWizardItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActionWizardItems(strPSDEActionWizardId), psDEActionWizardItemList, PSDEAWItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionWizardGroups(String strPSDEId, Vector<PSDEAWGroup> psDEActionWizardGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEActionWizardGroupList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEAWGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActionWizardGroups(strPSDEId), psDEActionWizardGroupList, PSDEAWGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionWizardGroupDetails(String strPSDEActionWizardGroupId, Vector<PSDEAWGrpDetail> psDEActionWizardGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEActionWizardGroupStorage(strPSDEActionWizardGroupId) != null
            && this.fromList(psDEActionWizardGroupDetailList, psSystemStorage.getPSDEActionWizardGroupStorage(strPSDEActionWizardGroupId).psDEAWGrpDetailList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSDEActionWizardGroupDetails(strPSDEActionWizardGroupId), psDEActionWizardGroupDetailList, PSDEAWGrpDetail.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getAllPSWXAccounts(String strPSSystemId, Vector<PSWXAccount> psWXAccountList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psWXAccountList, psSystemStorage.psWXAccountList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSWXAccounts(strPSSystemId), psWXAccountList, PSWXAccount.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXAccount(String strPSWXAccountId, PSWXAccount psWXAccount) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null) {
         psSystemStorage.getPSWXAccountStorage(strPSWXAccountId).psWXAccount.CopyTo(psWXAccount, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSWXAccount(strPSWXAccountId), psWXAccount, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSWXMenuItems(String strPSWXMenuId, Vector<PSWXMenuItem> psWXMenuItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId) != null) {
         for (PSWXMenuItem psWXMenuItem : psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId).psWXMenuItemList) {
            PSWXMenuItem psWXMenuItem2 = new PSWXMenuItem();
            psWXMenuItem.CopyTo(psWXMenuItem2, true);
            psWXMenuItemList.add(psWXMenuItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSWXMenuItems(strPSWXMenuId), psWXMenuItemList, PSWXMenuItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSWXEntApps(String strPSWXAccountId, Vector<PSWXEntApp> psWXEntAppList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null
            && this.fromList(psWXEntAppList, psSystemStorage.getPSWXAccountStorage(strPSWXAccountId).psWXEntAppList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXEntApps(strPSWXAccountId), psWXEntAppList, PSWXEntApp.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXMenuFuncs(String strPSWXAccountId, Vector<PSWXMenuFunc> psWXMenuFuncList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null
            && this.fromList(psWXMenuFuncList, psSystemStorage.getPSWXAccountStorage(strPSWXAccountId).psWXMenuFuncList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXMenuFuncs(strPSWXAccountId), psWXMenuFuncList, PSWXMenuFunc.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXMenuFuncsByApp(String strPSWXEntAppId, Vector<PSWXMenuFunc> psWXMenuFuncList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null
            && this.fromList(psWXMenuFuncList, psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId).psWXMenuFuncList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXMenuFuncsByApp(strPSWXEntAppId), psWXMenuFuncList, PSWXMenuFunc.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXLogics(String strPSWXAccountId, Vector<PSWXLogic> psWXLogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null
            && this.fromList(psWXLogicList, psSystemStorage.getPSWXAccountStorage(strPSWXAccountId).psWXLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXLogics(strPSWXAccountId), psWXLogicList, PSWXLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXLogicsByApp(String strPSWXEntAppId, Vector<PSWXLogic> psWXLogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null
            && this.fromList(psWXLogicList, psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId).psWXLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXLogicsByApp(strPSWXEntAppId), psWXLogicList, PSWXLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXMenus(String strPSWXAccountId, Vector<PSWXMenu> psWXMenuList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null
            && this.fromList(psWXMenuList, psSystemStorage.getPSWXAccountStorage(strPSWXAccountId).psWXMenuList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXMenus(strPSWXAccountId), psWXMenuList, PSWXMenu.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXMenusByApp(String strPSWXEntAppId, Vector<PSWXMenu> psWXMenuList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null
            && this.fromList(psWXMenuList, psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId).psWXMenuList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSWXMenusByApp(strPSWXEntAppId), psWXMenuList, PSWXMenu.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSWXMenu(String strPSWXMenuId, PSWXMenu psWXMenu) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId) != null) {
         psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId).psWXMenu.CopyTo(psWXMenu, false);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSWXMenu(strPSWXMenuId), psWXMenu, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSCtrlMsgs(String strPSSystemId, Vector<PSCtrlMsg> psCtrlMsgList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psCtrlMsgList, psCtrlMsgList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSCtrlMsgs(strPSSystemId), psCtrlMsgList, PSCtrlMsg.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSCtrlMsg(String strPSCtrlMsgId, PSCtrlMsg psCtrlMsg) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psCtrlMsgMap.get(strPSCtrlMsgId) != null) {
         psSystemStorage.psCtrlMsgMap.get(strPSCtrlMsgId).CopyTo(psCtrlMsg, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSCtrlMsg(strPSCtrlMsgId), psCtrlMsg, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSCtrlMsgItems(String strPSCtrlMsgId, Vector<PSCtrlMsgItem> psCtrlMsgItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSCtrlMsgStorage(strPSCtrlMsgId) != null) {
         for (PSCtrlMsgItem psCtrlMsgItem : psSystemStorage.getPSCtrlMsgStorage(strPSCtrlMsgId).psCtrlMsgItemList) {
            PSCtrlMsgItem psCtrlMsgItem2 = new PSCtrlMsgItem();
            psCtrlMsgItem.CopyTo(psCtrlMsgItem2, true);
            psCtrlMsgItemList.add(psCtrlMsgItem2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSCtrlMsgItems(strPSCtrlMsgId), psCtrlMsgItemList, PSCtrlMsgItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUnits(String strPSSystemId, Vector<PSSysUnit> psSysUnitList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysUnitList, psSysUnitList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUnits(strPSSystemId), psSysUnitList, PSSysUnit.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUnit(String strPSSysUnitId, PSSysUnit psSysUnit) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUnitMap.get(strPSSysUnitId) != null) {
         psSystemStorage.psSysUnitMap.get(strPSSysUnitId).CopyTo(psSysUnit, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUnit(strPSSysUnitId), psSysUnit, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSLanguageReses(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psLanguageResList != null) {
         psLanguageResList.addAll(psSystemStorage.psLanguageResList);
         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getAllPSLanguageReses(strPSSystemId), psLanguageResList, PSLanguageRes.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSLanguageRes(String strPSLanguageResId, PSLanguageRes psLanguageRes) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psLanguageResMap.get(strPSLanguageResId) != null) {
         psSystemStorage.psLanguageResMap.get(strPSLanguageResId).CopyTo(psLanguageRes, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSLanguageRes(strPSLanguageResId), psLanguageRes, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSLanguageItems(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psLanguageItemList != null) {
         psLanguageItemList.addAll(psSystemStorage.psLanguageItemList);
         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getAllPSLanguageItems(strPSSystemId), psLanguageItemList, PSLanguageItem.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSLanguageItem(String strPSLanguageItemId, PSLanguageItem psLanguageItem) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psLanguageItemMap.get(strPSLanguageItemId) != null) {
         psSystemStorage.psLanguageItemMap.get(strPSLanguageItemId).CopyTo(psLanguageItem, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSLanguageItem(strPSLanguageItemId), psLanguageItem, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppPkgs(String strPSApplicationId, Vector<PSAppPkg> psAppPkgs) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppPkgs, psSysAppStorage.psAppPkgList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppPkgs(strPSApplicationId), psAppPkgs, PSAppPkg.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysLans(String strPSSystemId, Vector<PSAppLan> psAppLans) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psAppLans, psSystemStorage.psSysLanList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysLans(strPSSystemId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDEFInputTipSets(String strPSSystemId, Vector<PSDEFInputTipSet> psDEFInputTipSetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDEFInputTipSetList, psSystemStorage.psDEFInputTipSetList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSDEFInputTipSets(strPSSystemId), psDEFInputTipSetList, PSDEFInputTipSet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFInputTipSet(String strPSDEFInputTipSetId, PSDEFInputTipSet psDEFInputTipSet) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDEFInputTipSetMap.get(strPSDEFInputTipSetId) != null) {
         psSystemStorage.psDEFInputTipSetMap.get(strPSDEFInputTipSetId).CopyTo(psDEFInputTipSet, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEFInputTipSet(strPSDEFInputTipSetId), psDEFInputTipSet, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysUniStates(String strPSSystemId, Vector<PSSysUniState> psSysUniStateList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUniStateList, psSystemStorage.psSysUniStateList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUniStates(strPSSystemId), psSysUniStateList, PSSysUniState.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUniState(String strPSSysUniStateId, PSSysUniState psSysUniState) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUniStateMap.get(strPSSysUniStateId) != null) {
         psSystemStorage.psSysUniStateMap.get(strPSSysUniStateId).CopyTo(psSysUniState, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUniState(strPSSysUniStateId), psSysUniState, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysDEFTypes(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysDEFTypeList, psSysDEFTypeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDEFTypes(strPSSystemId), psSysDEFTypeList, PSSysDEFType.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDEFType(String strPSSysDEFTypeId, PSSysDEFType psSysDEFType) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDEFTypeMap.get(strPSSysDEFTypeId) != null) {
         psSystemStorage.psSysDEFTypeMap.get(strPSSysDEFTypeId).CopyTo(psSysDEFType, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDEFType(strPSSysDEFTypeId), psSysDEFType, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSMobAppStartPages(String strPSApplicationId, Vector<PSMobAppStartPage> psMobAppStartPages) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psMobAppStartPages, psSysAppStorage.psMobAppStartPageList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSMobAppStartPages(strPSApplicationId), psMobAppStartPages, PSMobAppStartPage.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSMobAppPacks(String strPSApplicationId, Vector<PSMobAppPack> psMobAppPacks) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psMobAppPacks, psSysAppStorage.psMobAppPackList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSMobAppPacks(strPSApplicationId), psMobAppPacks, PSMobAppPack.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSMobAppPackTDs(String strPSMobAppPackId, Vector<PSMobAppPackTD> psMobAppPackTDList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psMobAppPackStorageMap.get(strPSMobAppPackId) != null) {
         for (PSMobAppPackTD psMobAppPackTD : psSysAppStorage.psMobAppPackStorageMap.get(strPSMobAppPackId).psMobAppPackTDList) {
            PSMobAppPackTD psMobAppPackTD2 = new PSMobAppPackTD();
            psMobAppPackTD.CopyTo(psMobAppPackTD2, true);
            psMobAppPackTDList.add(psMobAppPackTD2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSMobAppPackTDs(strPSMobAppPackId), psMobAppPackTDList, PSMobAppPackTD.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSMobAppPackCerts(String strPSApplicationId, Vector<PSDCMobAppPackCert> psMobAppPackCerts) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psMobAppPackCerts, psSysAppStorage.psDCMobAppPackCertList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSMobAppPackCerts(strPSApplicationId), psMobAppPackCerts, PSDCMobAppPackCert.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysLogics(String strPSSystemId, Vector<PSSysLogic> psSysLogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysLogicList, psSysLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysLogics(strPSSystemId), psSysLogicList, PSSysLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysLogic(String strPSSysLogicId, PSSysLogic psSysLogic) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysLogicMap.get(strPSSysLogicId) != null) {
         psSystemStorage.psSysLogicMap.get(strPSSysLogicId).CopyTo(psSysLogic, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysLogic(strPSSysLogicId), psSysLogic, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEUniStates(String strPSDataEntityId, Vector<PSSysUniState> psDEUniStateList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEUniStateList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEUniStateList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEUniStates(strPSDataEntityId), psDEUniStateList, PSSysUniState.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSearchBars(String strPSSystemId, Vector<PSSysSearchBar> psSysSearchBarList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysSearchBarList, psSysAppStorage.psSysSearchBarList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSearchBars(strPSSystemId), psSysSearchBarList, PSSysSearchBar.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchBar(String strPSSysSearchBarId, PSSysSearchBar psSysSearchBar) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysSearchBarStorageMap.containsKey(strPSSysSearchBarId)) {
         psSysAppStorage.psSysSearchBarStorageMap.get(strPSSysSearchBarId).psSysSearchBar.CopyTo(psSysSearchBar, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSearchBar(strPSSysSearchBarId), psSysSearchBar, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysSearchBarItems(String strPSSysSearchBarId, Vector<PSSysSearchBarItem> psSysSearchBarItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysSearchBarStorageMap.containsKey(strPSSysSearchBarId)
            && this.fromList(psSysSearchBarItemList, psSysAppStorage.getPSSysSearchBarStorage(strPSSysSearchBarId).psSysSearchBarItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchBarItems(strPSSysSearchBarId), psSysSearchBarItemList, PSSysSearchBarItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEServiceAPIs(String strPSDEId, Vector<PSDEServiceAPI> psDEServiceAPIList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEServiceAPIList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEServiceAPIList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEServiceAPIs(strPSDEId), psDEServiceAPIList, PSDEServiceAPI.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDESADetails(String strPSDEServiceAPIId, Vector<PSDESADetail> psDESADetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage == null) {
         return this.selectMulti(this.getSQL_getPSDESADetails(strPSDEServiceAPIId), psDESADetailList, PSDESADetail.class.getName(), "SYSTEM");
      }

      if (psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false) != null) {
         for (PSDESADetail psDESADetail : psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false).psDESADetailList) {
            PSDESADetail psDESADetail2 = new PSDESADetail();
            psDESADetail.CopyTo(psDESADetail2, true);
            psDESADetailList.add(psDESADetail2);
         }
      }

      return new CallResult();
   }

   @Override
   public CallResult getAllPSSysServiceAPIs(String strPSSystemId, Vector<PSSysServiceAPI> psSysServiceAPIList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysServiceAPIList, psSystemStorage.psSysServiceAPIList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysServiceAPIs(strPSSystemId), psSysServiceAPIList, PSSysServiceAPI.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysServiceAPI(String strPSSysServiceAPIId, PSSysServiceAPI psSysServiceAPI) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null) {
         psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false).psSysServiceAPI.CopyTo(psSysServiceAPI, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysServiceAPI(strPSSysServiceAPIId), psSysServiceAPI, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEServiceAPIsBySSA(String strPSSysServiceAPIId, Vector<PSDEServiceAPI> psDEServiceAPIList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null
            && this.fromList(psDEServiceAPIList, psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false).psDEServiceAPIList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEServiceAPIsBySSA(strPSSysServiceAPIId), psDEServiceAPIList, PSDEServiceAPI.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDTSQueues(String strPSDataEntityId, Vector<PSDEDTSQueue> psDEDTSQueueList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDTSQueueList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDTSQueueList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDTSQueues(strPSDataEntityId), psDEDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysDTSQueues(String strPSSystemId, Vector<PSSysDTSQueue> psSysDTSQueueList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysDTSQueueList, psSystemStorage.psSysDTSQueueList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDTSQueues(strPSSystemId), psSysDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDTSQueue(String strPSSysDTSQueueId, PSSysDTSQueue psSysDTSQueue) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDTSQueueMap.get(strPSSysDTSQueueId) != null) {
         psSystemStorage.psSysDTSQueueMap.get(strPSSysDTSQueueId).CopyTo(psSysDTSQueue, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDTSQueue(strPSSysDTSQueueId), psSysDTSQueue, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSubSysServiceAPIs(String strPSSystemId, Vector<PSSubSysServiceAPI> psSubSysServiceAPIList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSubSysServiceAPIList, psSystemStorage.psSubSysServiceAPIList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSubSysServiceAPIs(strPSSystemId), psSubSysServiceAPIList, PSSubSysServiceAPI.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSubSysServiceAPI(String strPSSubSysServiceAPIId, PSSubSysServiceAPI psSubSysServiceAPI) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null) {
         psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false).psSubSysServiceAPI.CopyTo(psSubSysServiceAPI, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSubSysServiceAPI(strPSSubSysServiceAPIId), psSubSysServiceAPI, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSubSysSADetails(String strPSSubSysServiceAPIId, Vector<PSSubSysSADetail> psSubSysSADetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null
            && this.fromList(psSubSysSADetailList, psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false).psSubSysSADetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSubSysSADetails(strPSSubSysServiceAPIId), psSubSysSADetailList, PSSubSysSADetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEUserRoles(String strPSDEId, Vector<PSDEUserRole> psDEUserRoleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEUserRoleList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEUserRoleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEUserRoles(strPSDEId), psDEUserRoleList, PSDEUserRole.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDEUserRoles(String strPSDEId) {
      return StringHelper.Format("select t1.* from V_SRFPSDEUSERROLE t1 where  t1.PSDEID='%1$s'  AND t1.VALIDFLAG = 1 ", strPSDEId);
   }

   public CallResult getPSDEUserRolesBySystem(String strPSSystemId, Vector<PSDEUserRole> psDEUserRoleList) {
      return this.selectMulti(this.getSQL_getPSDEUserRolesBySystem(strPSSystemId), psDEUserRoleList, PSDEUserRole.class.getName(), "SYSTEM");
   }

   protected String getSQL_getPSDEUserRolesBySystem(String strPSSystemId) {
      return StringHelper.Format(
         "select t1.* from V_SRFPSDEUSERROLE t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  AND t1.VALIDFLAG = 1  ",
         strPSSystemId
      );
   }

   @Override
   public CallResult getPSDEOPPrivRoles(String strPSDEId, Vector<PSDEOPPrivRole> psDEOPPrivRoleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEOPPrivRoleList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEOPPrivRoleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEOPPrivRoles(strPSDEId), psDEOPPrivRoleList, PSDEOPPrivRole.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysUserRoles(String strPSSystemId, Vector<PSSysUserRole> psSysUserRoleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysUserRoleList, psSysUserRoleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUserRoles(strPSSystemId), psSysUserRoleList, PSSysUserRole.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserRole(String strPSSysUserRoleId, PSSysUserRole psSysUserRole) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null) {
         if (psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null) {
            psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId).psSysUserRole.CopyTo(psSysUserRole, true);
         }

         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUserRole(strPSSysUserRoleId), psSysUserRole, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysDashboards(String strPSSystemId, Vector<PSSysDashboard> psSysDashboardList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysDashboardList, psSysAppStorage.psSysDashboardList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDashboards(strPSSystemId), psSysDashboardList, PSSysDashboard.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDashboard(String strPSSysDashboardId, PSSysDashboard psSysDashboard) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysDashboardStorageMap.containsKey(strPSSysDashboardId)) {
         psSysAppStorage.psSysDashboardStorageMap.get(strPSSysDashboardId).psSysDashboard.CopyTo(psSysDashboard, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDashboard(strPSSysDashboardId), psSysDashboard, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysDashboardParts(String strPSSysDashboardId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysDashboardStorageMap.containsKey(strPSSysDashboardId)
            && this.fromList(psSysDashboardPartList, psSysAppStorage.getPSSysDashboardStorage(strPSSysDashboardId).psSysDashboardPartList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDashboardParts(strPSSysDashboardId), psSysDashboardPartList, PSSysDashboardPart.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserRoleReses(String strPSSysUserRoleId, Vector<PSSysUserRoleRes> psSysUserRoleResList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null
            && this.fromList(psSysUserRoleResList, psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId).psSysUserRoleResList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysUserRoleRess(strPSSysUserRoleId), psSysUserRoleResList, PSSysUserRoleRes.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUserRoleDatas(String strPSSysUserRoleId, Vector<PSSysUserRoleData> psSysUserRoleDataList) {
      if (this.getModelInstVer() < 635) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null
            && this.fromList(psSysUserRoleDataList, psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId).psSysUserRoleDataList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysUserRoleDatas(strPSSysUserRoleId), psSysUserRoleDataList, PSSysUserRoleData.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppLocalDEs(String strPSApplicationId, Vector<PSAppLocalDE> psAppLocalDEs) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppLocalDEs, psSysAppStorage.psAppLocalDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppLocalDEs(strPSApplicationId), psAppLocalDEs, PSAppLocalDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSFPlugins(String strPSSystemId, Vector<PSSysSFPlugin> psSysSFPluginList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysSFPluginList, psSysSFPluginList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSFPlugins(strPSSystemId), psSysSFPluginList, PSSysSFPlugin.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSFPlugin(String strPSSysSFPluginId, PSSysSFPlugin psSysSFPlugin) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysSFPluginMap.get(strPSSysSFPluginId) != null) {
         psSystemStorage.psSysSFPluginMap.get(strPSSysSFPluginId).CopyTo(psSysSFPlugin, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSFPlugin(strPSSysSFPluginId), psSysSFPlugin, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysSFPluginTempls(String strPSSystemId, Vector<PSSysSFPluginTempl> psSysSFPluginTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysSFPluginTemplList, psSysSFPluginTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSFPluginTempls(strPSSystemId), psSysSFPluginTemplList, PSSysSFPluginTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSFPluginTempl(String strPSSysSFPluginTemplId, PSSysSFPluginTempl psSysSFPluginTempl) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysSFPluginTemplMap.get(strPSSysSFPluginTemplId) != null) {
         psSystemStorage.psSysSFPluginTemplMap.get(strPSSysSFPluginTemplId).CopyTo(psSysSFPluginTempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSFPluginTempl(strPSSysSFPluginTemplId), psSysSFPluginTempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEUtils(String strPSDEId, Vector<PSDEUtil> psDEUtilList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDEUtilList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDEUtilList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEUtils(strPSDEId), psDEUtilList, PSDEUtil.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysUtils(String strPSSystemId, Vector<PSSysUtil> psSysUtilList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysUtilList, psSystemStorage.psSysUtilList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysUtils(strPSSystemId), psSysUtilList, PSSysUtil.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysUtil(String strPSSysUtilId, PSSysUtil psSysUtil) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysUtilMap.get(strPSSysUtilId) != null) {
         psSystemStorage.psSysUtilMap.get(strPSSysUtilId).CopyTo(psSysUtil, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysUtil(strPSSysUtilId), psSysUtil, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSVNServer(String strPSSVNServerId, PSSVNServer psSVNServer) {
      return this.selectSingle(this.getSQL_getPSSVNServer(strPSSVNServerId), psSVNServer, "SYSTEM");
   }

   protected String getSQL_getPSSVNServer(String strPSSVNServerId) {
      return StringHelper.Format("select t1.* from T_SRFPSSVNSERVER t1 where  t1.PSSVNSERVERID='%1$s'  and t1.VALIDFLAG >= 1 ", strPSSVNServerId);
   }

   @Override
   public CallResult getPSDevSlnSysWSGit(String strPSDevSlnSysWSGitId, PSDevSlnSysWSGit psDevSlnSysWSGit) {
      return this.selectSingle(this.getSQL_getPSDevSlnSysWSGit(strPSDevSlnSysWSGitId), psDevSlnSysWSGit, "SYSTEM");
   }

   protected String getSQL_getPSDevSlnSysWSGit(String strPSDevSlnSysWSGitId) {
      return StringHelper.Format("select t1.* from T_SRFPSDEVSLNSYSWSGIT t1 where t1.PSDEVSLNSYSWSGITID='%1$s'  ", strPSDevSlnSysWSGitId);
   }

   public CallResult getAllPSSysTitleBars2(String strPSSystemId, Vector<PSSysTitleBar> psSysTitleBarList) {
      return this.selectMulti(this.getSQL_getAllPSSysTitleBars(strPSSystemId), psSysTitleBarList, PSSysTitleBar.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysTitleBars(String strPSSystemId, Vector<PSSysTitleBar> psSysTitleBarList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysTitleBarList, psSysAppStorage.psSysTitleBarList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysTitleBars(strPSSystemId), psSysTitleBarList, PSSysTitleBar.class.getName(), "SYSTEM");
   }

   protected String getSQL_getAllPSSysTitleBars(String strPSSystemId) {
      return StringHelper.Format("select t1.* from T_SRFPSSYSTITLEBAR t1 where t1.PSSYSTEMID='%1$s' ", strPSSystemId);
   }

   @Override
   public CallResult getPSSysTitleBar(String strPSSysTitleBarId, PSSysTitleBar psSysTitleBar) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysTitleBarStorageMap.containsKey(strPSSysTitleBarId)) {
         psSysAppStorage.psSysTitleBarStorageMap.get(strPSSysTitleBarId).psSysTitleBar.CopyTo(psSysTitleBar, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysTitleBar(strPSSysTitleBarId), psSysTitleBar, "SYSTEM");
      }
   }

   protected String getSQL_getPSSysTitleBar(String strPSSysTitleBarId) {
      return StringHelper.Format("select t1.* from T_SRFPSSYSTITLEBAR t1 where  t1.PSSYSTITLEBARID='%1$s'", strPSSysTitleBarId);
   }

   @Override
   public CallResult getPSAppTitleBar(String strPSAppTitleBarId, PSAppTitleBar psAppTitleBar) {
      return this.selectSingle(this.getSQL_getPSAppTitleBar(strPSAppTitleBarId), psAppTitleBar, "SYSTEM");
   }

   protected String getSQL_getPSAppTitleBar(String strPSAppTitleBarId) {
      return StringHelper.Format("select t1.* from V_SRFPSAPPTITLEBAR t1 where  t1.PSAPPTITLEBARID='%1$s'  ", strPSAppTitleBarId);
   }

   @Override
   public CallResult getAllPSAppTitleBars(String strPSApplicationId, Vector<PSAppTitleBar> psAppTitleBars) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppTitleBars, psSysAppStorage.psAppTitleBarList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppTitleBars(strPSApplicationId), psAppTitleBars, PSAppTitleBar.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSAppTitleBars2(String strPSApplicationId, Vector<PSAppTitleBar> psAppTitleBars) {
      return this.selectMulti(this.getSQL_getAllPSAppTitleBars(strPSApplicationId), psAppTitleBars, PSAppTitleBar.class.getName(), "SYSTEM");
   }

   protected String getSQL_getAllPSAppTitleBars(String strPSApplicationId) {
      return StringHelper.Format("select t1.* from V_SRFPSAPPTITLEBAR t1 where  t1.PSSYSAPPID='%1$s' ", strPSApplicationId);
   }

   @Override
   public CallResult getPSDBServer(String strPSDBServerId, PSDBServer psDBServer) {
      return this.selectSingle(this.getSQL_getPSDBServer(strPSDBServerId), psDBServer, "SYSTEM");
   }

   protected String getSQL_getPSDBServer(String strPSDBServerId) {
      return StringHelper.Format("select t1.* from V_SRFPSDBSERVER t1 where  t1.PSDBSERVERID='%1$s'", strPSDBServerId);
   }

   @Override
   public CallResult getAllPSSysDMVers(String strPSSystemId, Vector<PSSysDMVer> psSysDMVerList) {
      return this.getModelInstVer() < 340
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDMVers(strPSSystemId), psSysDMVerList, PSSysDMVer.class.getName(), "SYSTEM", true);
   }

   protected String getSQL_getAllPSSysDMVers(String strPSSystemId) {
      return StringHelper.Format("select t1.* from V_SRFPSSYSDMVER t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", strPSSystemId);
   }

   @Override
   public CallResult getPSSFStyleParam(String strPSSFStyleParamId, PSSFStyleParam psSFStyleParam) {
      return this.getModelInstVer() < 353 ? new CallResult() : this.selectSingle(this.getSQL_getPSSFStyleParam(strPSSFStyleParamId), psSFStyleParam, "SYSTEM");
   }

   protected String getSQL_getPSSFStyleParam(String strPSSFStyleParamId) {
      return StringHelper.Format("select t1.* from V_SRFPSSFSTYLEPARAM t1 where  t1.PSSFSTYLEPARAMID='%1$s'", strPSSFStyleParamId);
   }

   public CallResult getAllPSDEActionTempls2(String strPSSystemId, Vector<PSDEActionTempl> psDEActionTemplList) {
      return this.selectMulti(this.getSQL_getAllPSDEActionTempls(strPSSystemId), psDEActionTemplList, PSDEActionTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDEActionTempls(String strPSSystemId, Vector<PSDEActionTempl> psDEActionTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psDEActionTemplList, psDEActionTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSDEActionTempls(strPSSystemId), psDEActionTemplList, PSDEActionTempl.class.getName(), "SYSTEM");
   }

   protected String getSQL_getAllPSDEActionTempls(String strPSSystemId) {
      return StringHelper.Format("select t1.* from T_SRFPSDEACTIONTEMPL t1 where t1.PSSYSTEMID='%1$s'  ", strPSSystemId);
   }

   @Override
   public CallResult getPSDEActionTempl(String strPSDEActionTemplId, PSDEActionTempl psDEActionTempl) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDEActionTemplMap.get(strPSDEActionTemplId) != null) {
         psSystemStorage.psDEActionTemplMap.get(strPSDEActionTemplId).CopyTo(psDEActionTempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEActionTempl(strPSDEActionTemplId), psDEActionTempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysCalendars(String strPSSystemId, Vector<PSSysCalendar> psSysCalendarList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysCalendarList, psSysAppStorage.psSysCalendarList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysCalendars(strPSSystemId), psSysCalendarList, PSSysCalendar.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysCalendar(String strPSSysCalendarId, PSSysCalendar psSysCalendar) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.containsKey(strPSSysCalendarId)) {
         psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId).psSysCalendar.CopyTo(psSysCalendar, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysCalendar(strPSSysCalendarId), psSysCalendar, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysCalendarItems(String strPSSysCalendarId, Vector<PSSysCalendarItem> psSysCalendarItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysCalendarStorageMap.containsKey(strPSSysCalendarId)
            && this.fromList(psSysCalendarItemList, psSysAppStorage.getPSSysCalendarStorage(strPSSysCalendarId).psSysCalendarItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysCalendarItems(strPSSysCalendarId), psSysCalendarItemList, PSSysCalendarItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysCalendarItemRVs(String strPSSysCalendarId, Vector<PSSysCalendarItemRV> psSysCalendarItemRVList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId) != null) {
         for (PSSysCalendarItemRV psSysCalendarItemRV : psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId).psSysCalendarItemRVList) {
            PSSysCalendarItemRV psSysCalendarItemRV2 = new PSSysCalendarItemRV();
            psSysCalendarItemRV.CopyTo(psSysCalendarItemRV2, true);
            psSysCalendarItemRVList.add(psSysCalendarItemRV2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(
            this.getSQL_getPSSysCalendarItemRVs(strPSSysCalendarId), psSysCalendarItemRVList, PSSysCalendarItemRV.class.getName(), "SYSTEM"
         );
      }
   }

   @Override
   public CallResult getPSDESampleDatas(String strPSDataEntityId, Vector<PSDESampleData> psDESampleDataList) {
      if (this.getModelInstVer() < 387) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDESampleDataList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDESampleDataList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDESampleDatas(strPSDataEntityId), psDESampleDataList, PSDESampleData.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysPanels(String strPSSystemId, Vector<PSSysPanel> psSysPanelList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysPanelList, psSysAppStorage.psSysPanelList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPanels(strPSSystemId), psSysPanelList, PSSysPanel.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPanel(String strPSSysPanelId, PSSysPanel psSysPanel) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)) {
         psSysAppStorage.psSysPanelStorageMap.get(strPSSysPanelId).psSysPanel.CopyTo(psSysPanel, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysPanel(strPSSysPanelId), psSysPanel, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysPanelItems(String strPSSysPanelId, Vector<PSSysPanelItem> psSysPanelItemList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)
            && this.fromList(psSysPanelItemList, psSysAppStorage.getPSSysPanelStorage(strPSSysPanelId).psSysPanelItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysPanelItems(strPSSysPanelId), psSysPanelItemList, PSSysPanelItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPanelModels(String strPSSysPanelId, Vector<PSSysPanelModel> psSysPanelModelList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)
            && this.fromList(psSysPanelModelList, psSysAppStorage.getPSSysPanelStorage(strPSSysPanelId).psSysPanelModelList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysPanelModels(strPSSysPanelId), psSysPanelModelList, PSSysPanelModel.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelEngines(String strPSPanelId, Vector<PSPanelEngine> psPanelEngineList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSPanelId)
            && this.fromList(psPanelEngineList, psSysAppStorage.getPSSysPanelStorage(strPSPanelId).psPanelEngineList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelEngines(strPSPanelId), psPanelEngineList, PSPanelEngine.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelItemLogics(String strPSSysPanelId, Vector<PSPanelItemLogic> psPanelItemLogicList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)
            && this.fromList(psPanelItemLogicList, psSysAppStorage.getPSSysPanelStorage(strPSSysPanelId).psPanelItemLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelItemLogics(strPSSysPanelId), psPanelItemLogicList, PSPanelItemLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPanelLogics(String strPSSysPanelId, Vector<PSSysPanelLogic> psSysPanelLogicList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)
            && this.fromList(psSysPanelLogicList, psSysAppStorage.getPSSysPanelStorage(strPSSysPanelId).psSysPanelLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysPanelLogics(strPSSysPanelId), psSysPanelLogicList, PSSysPanelLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelLogicParams(String strPSPanelLogicId, Vector<PSPanelLogicParam> psPanelLogicParamList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId)
            && this.fromList(psPanelLogicParamList, psSysAppStorage.getPSPanelLogicStorage(strPSPanelLogicId).psPanelLogicParamList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelLogicParams(strPSPanelLogicId), psPanelLogicParamList, PSPanelLogicParam.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelLogicNodes(String strPSPanelLogicId, Vector<PSPanelLogicNode> psPanelLogicNodeList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId)
            && this.fromList(psPanelLogicNodeList, psSysAppStorage.getPSPanelLogicStorage(strPSPanelLogicId).psPanelLogicNodeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelLogicNodes(strPSPanelLogicId), psPanelLogicNodeList, PSPanelLogicNode.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelLogicLinks(String strPSPanelLogicId, Vector<PSPanelLogicLink> psPanelLogicLinkList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId)
            && this.fromList(psPanelLogicLinkList, psSysAppStorage.getPSPanelLogicStorage(strPSPanelLogicId).psPanelLogicLinkList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelLogicLinks(strPSPanelLogicId), psPanelLogicLinkList, PSPanelLogicLink.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSPanelLogicNodeParams(String strPSPanelLogicId, Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId)
            && this.fromList(psPanelLogicNodeParamList, psSysAppStorage.getPSPanelLogicStorage(strPSPanelLogicId).psPanelLogicNodeParamList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSPanelLogicNodeParams(strPSPanelLogicId), psPanelLogicNodeParamList, PSPanelLogicNodeParam.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSPanelLogicLinkConds(String strPSPanelLogicId, Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId)
            && this.fromList(psPanelLogicLinkCondList, psSysAppStorage.getPSPanelLogicStorage(strPSPanelLogicId).psPanelLogicLinkCondList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSPanelLogicLinkConds(strPSPanelLogicId), psPanelLogicLinkCondList, PSPanelLogicLinkCond.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppUIStyles(String strPSApplicationId, Vector<PSAppUIStyle> psAppUIStyles) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppUIStyles, psSysAppStorage.psAppUIStyleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppUIStyles(strPSApplicationId), psAppUIStyles, PSAppUIStyle.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDynaDETempls(String strPSSystemId, Vector<PSDynaDETempl> psDynaDETemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDynaDETemplList, psSystemStorage.psDynaDETemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSDynaDETempls(strPSSystemId), psDynaDETemplList, PSDynaDETempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDynaDETempl(String strPSDynaDETemplId, PSDynaDETempl psDynaDETempl) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDynaDETemplMap.get(strPSDynaDETemplId) != null) {
         psSystemStorage.psDynaDETemplMap.get(strPSDynaDETemplId).CopyTo(psDynaDETempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDynaDETempl(strPSDynaDETemplId), psDynaDETempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDynaDEViewTempl(String strPSDynaDEViewTemplId, PSDynaDEViewTempl psDynaDEViewTempl) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDynaDEViewTemplMap.get(strPSDynaDEViewTemplId) != null) {
         psSysAppStorage.psDynaDEViewTemplMap.get(strPSDynaDEViewTemplId).CopyTo(psDynaDEViewTempl, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDynaDEViewTempl(strPSDynaDEViewTemplId), psDynaDEViewTempl, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysServiceAPIHandlers(String strPSSystemId, Vector<PSSysServiceAPIHandler> psSysServiceAPIHandlerList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysServiceAPIHandlerList, psSystemStorage.psSysServiceAPIHandlerList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getAllPSSysServiceAPIHandlers(strPSSystemId), psSysServiceAPIHandlerList, PSSysServiceAPIHandler.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSSysServiceAPIHandler(String strPSSysServiceAPIHandlerId, PSSysServiceAPIHandler psSysServiceAPIHandler) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIHandlerStorage(strPSSysServiceAPIHandlerId, false) != null) {
         psSystemStorage.getPSSysServiceAPIHandlerStorage(strPSSysServiceAPIHandlerId, false).psSysServiceAPIHandler.CopyTo(psSysServiceAPIHandler, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysServiceAPIHandler(strPSSysServiceAPIHandlerId), psSysServiceAPIHandler, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppPDTViews(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViews) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppPDTViews, psSysAppStorage.psAppPDTViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppPDTViews(strPSApplicationId), psAppPDTViews, PSAppPDTView.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDynaDEViewTempls(String strPSDynaDETemplId, Vector<PSDynaDEViewTempl> psDynaDEViewTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId) != null
            && this.fromList(psDynaDEViewTemplList, psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId).psDynaDEViewTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDynaDEViewTempls(strPSDynaDETemplId), psDynaDEViewTemplList, PSDynaDEViewTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDynaDEFormTempls(String strPSDynaDETemplId, Vector<PSDynaDEFormTempl> psDynaDEFormTemplList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId) != null
            && this.fromList(psDynaDEFormTemplList, psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId).psDynaDEFormTemplList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDynaDEFormTempls(strPSDynaDETemplId), psDynaDEFormTemplList, PSDynaDEFormTempl.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysViewLogicParams(String strPSSysViewLogicId, Vector<PSSysViewLogicParam> psSysViewLogicParamList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null
         && psSystemStorage.getPSSysViewLogicStorage(strPSSysViewLogicId) != null
         && this.fromList(psSysViewLogicParamList, psSystemStorage.getPSSysViewLogicStorage(strPSSysViewLogicId).psSysViewLogicParamList)) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSSysViewLogicStorage(strPSSysViewLogicId) != null
            && this.fromList(psSysViewLogicParamList, psSysAppStorage.getPSSysViewLogicStorage(strPSSysViewLogicId).psSysViewLogicParamList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysViewLogicParams(strPSSysViewLogicId), psSysViewLogicParamList, PSSysViewLogicParam.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysFiles(String strPSSystemId, Vector<PSSysFile> psSysFileList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysFileList, psSysFileList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysFiles(strPSSystemId), psSysFileList, PSSysFile.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysFile(String strPSSysFileId, PSSysFile psSysFile) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysFileMap.get(strPSSysFileId) != null) {
         psSystemStorage.psSysFileMap.get(strPSSysFileId).CopyTo(psSysFile, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysFile(strPSSysFileId), psSysFile, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSAppWFs(String strPSApplicationId, Vector<PSAppWF> psAppWFs) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppWFs, psSysAppStorage.psAppWFList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppWFs(strPSApplicationId), psAppWFs, PSAppWF.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppWFVers(String strPSApplicationId, Vector<PSAppWFVer> psAppWFVers) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppWFVers, psSysAppStorage.psAppWFVerList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppWFVers(strPSApplicationId), psAppWFVers, PSAppWFVer.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFGroups(String strPSDataEntityId, Vector<PSDEFGroup> psDEFGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEFGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEFGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFGroups(strPSDataEntityId), psDEFGroupList, PSDEFGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFGroupDetails(String strPSDEFGroupId, Vector<PSDEFGroupDetail> psDEFGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null
            && this.fromList(psDEFGroupDetailList, psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId).psDEFGroupDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFGroupDetails(strPSDEFGroupId), psDEFGroupDetailList, PSDEFGroupDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEServiceAPIRSs(String strPSSysServiceAPIId, Vector<PSDESARS> psDEServiceAPIRSList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null
            && this.fromList(psDEServiceAPIRSList, psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false).psDEServiceAPIRSList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEServiceAPIRSs(strPSSysServiceAPIId), psDEServiceAPIRSList, PSDESARS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppDERSs(String strPSApplicationId, Vector<PSAppDERS> psAppDERSs) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppDERSs, psSysAppStorage.psAppDERSList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppDERSs(strPSApplicationId), psAppDERSs, PSAppDERS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSubSysSADEs(String strPSSubSysServiceAPIId, Vector<PSSubSysSADE> psSubSysSADEList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null
            && this.fromList(psSubSysSADEList, psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false).psSubSysSADEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSubSysSADEs(strPSSubSysServiceAPIId), psSubSysSADEList, PSSubSysSADE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSubSysSADERSs(String strPSSubSysServiceAPIId, Vector<PSSubSysSADERS> psSubSysSADERSList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null
            && this.fromList(psSubSysSADERSList, psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false).psSubSysSADERSList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSubSysSADERSs(strPSSubSysServiceAPIId), psSubSysSADERSList, PSSubSysSADERS.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSubSysSADEFields(String strPSSubSysSADEId, Vector<PSSubSysSADEField> psSubSysSADEFieldList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSubSysSADEStorage(strPSSubSysSADEId, false) != null
            && this.fromList(psSubSysSADEFieldList, psSystemStorage.getPSSubSysSADEStorage(strPSSubSysSADEId, false).psSubSysSADEFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSubSysSADEFields(strPSSubSysSADEId), psSubSysSADEFieldList, PSSubSysSADEField.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysDBSchemes(String strPSSystemId, Vector<PSSysDBScheme> psSysDBSchemeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysDBSchemeList, psSystemStorage.psSysDBSchemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDBSchemes(strPSSystemId), psSysDBSchemeList, PSSysDBScheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDBScheme(String strPSSysDBSchemeId, PSSysDBScheme psSysDBScheme) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysDBSchemeMap.get(strPSSysDBSchemeId) != null) {
         psSystemStorage.psSysDBSchemeMap.get(strPSSysDBSchemeId).CopyTo(psSysDBScheme, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysDBScheme(strPSSysDBSchemeId), psSysDBScheme, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysDBColumns(String strPSSysDBTableId, Vector<PSSysDBColumn> psSysDBColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysDBTableStorage(strPSSysDBTableId) != null
            && this.fromList(psSysDBColumnList, psSystemStorage.getPSSysDBTableStorage(strPSSysDBTableId).psSysDBColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDBColumns(strPSSysDBTableId), psSysDBColumnList, PSSysDBColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDBTables(String strPSSysDBSchemeId, Vector<PSSysDBTable> psSysDBTableList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysDBSchemeStorage(strPSSysDBSchemeId) != null
            && this.fromList(psSysDBTableList, psSystemStorage.getPSSysDBSchemeStorage(strPSSysDBSchemeId).psSysDBTableList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDBTables(strPSSysDBSchemeId), psSysDBTableList, PSSysDBTable.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDESAVRs(String strPSDEServiceAPIId, Vector<PSDESAVR> psDESAVRList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage == null) {
         return this.selectMulti(this.getSQL_getPSDESAVRs(strPSDEServiceAPIId), psDESAVRList, PSDESAVR.class.getName(), "SYSTEM");
      }

      if (psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false) != null) {
         for (PSDESAVR psDESAVR : psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false).psDESAVRList) {
            PSDESAVR psDESAVR2 = new PSDESAVR();
            psDESAVR.CopyTo(psDESAVR2, true);
            psDESAVRList.add(psDESAVR2);
         }
      }

      return new CallResult();
   }

   @Override
   public CallResult getAllPSSysResources(String strPSSystemId, Vector<PSSysResource> psSysResourceList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysResourceList, psSystemStorage.psSysResourceList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysResources(strPSSystemId), psSysResourceList, PSSysResource.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysResource(String strPSSysResourceId, PSSysResource psSysResource) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysResourceMap.get(strPSSysResourceId) != null) {
         psSystemStorage.psSysResourceMap.get(strPSSysResourceId).CopyTo(psSysResource, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysResource(strPSSysResourceId), psSysResource, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysContentCats(String strPSSystemId, Vector<PSSysContentCat> psSysContentCatList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysContentCatList, psSystemStorage.psSysContentCatList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysContentCats(strPSSystemId), psSysContentCatList, PSSysContentCat.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysContentCat(String strPSSysContentCatId, PSSysContentCat psSysContentCat) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null) {
         psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId).psSysContentCat.CopyTo(psSysContentCat, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysContentCat(strPSSysContentCatId), psSysContentCat, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysContentCats(String strPSSysContentCatId, Vector<PSSysContentCat> psSysContentCatList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null
            && this.fromList(psSysContentCatList, psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId).psSysContentCatList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysContentCats(strPSSysContentCatId), psSysContentCatList, PSSysContent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysContents(String strPSSysContentCatId, Vector<PSSysContent> psSysContentList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null
            && this.fromList(psSysContentList, psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId).psSysContentList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysContents(strPSSysContentCatId), psSysContentList, PSSysContent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysContent(String strPSSysContentId, PSSysContent psSysContent) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysContentMap.get(strPSSysContentId) != null) {
         psSystemStorage.psSysContentMap.get(strPSSysContentId).CopyTo(psSysContent, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysContent(strPSSysContentId), psSysContent, "SYSTEM");
      }
   }

   public CallResult getAllPSAppResources2(String strPSApplicationId, Vector<PSAppResource> psAppResources) {
      return this.selectMulti(this.getSQL_getAllPSAppResources(strPSApplicationId), psAppResources, PSAppResource.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppResources(String strPSApplicationId, Vector<PSAppResource> psAppResources) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppResources, psSysAppStorage.psAppResourceList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppResources(strPSApplicationId), psAppResources, PSAppResource.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppResource(String strPSAppResourceId, PSAppResource psAppResource) {
      return this.selectSingle(this.getSQL_getPSAppResource(strPSAppResourceId), psAppResource, "SYSTEM");
   }

   @Override
   public CallResult getPSDEGroup(String strPSDEGroupId, PSDEGroup psDEGroup) {
      return this.selectSingle(this.getSQL_getPSDEGroup(strPSDEGroupId), psDEGroup, "SYSTEM");
   }

   @Override
   public CallResult getPSDERGroup(String strPSDERGroupId, PSDERGroup psDERGroup) {
      return this.selectSingle(this.getSQL_getPSDERGroup(strPSDERGroupId), psDERGroup, "SYSTEM");
   }

   @Override
   public CallResult getPSDEGroups(String strPSDataEntityId, Vector<PSDEGroup> psDEGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEGroups(strPSDataEntityId), psDEGroupList, PSDEGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEGroupDetails(String strPSDEGroupId, Vector<PSDEGroupDetail> psDEGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEGroupStorage(strPSDEGroupId) != null
            && this.fromList(psDEGroupDetailList, psSystemStorage.getPSDEGroupStorage(strPSDEGroupId).psDEGroupDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEGroupDetails(strPSDEGroupId), psDEGroupDetailList, PSDEGroupDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERGroups(String strPSDataEntityId, Vector<PSDERGroup> psDERGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDERGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDERGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDERGroups(strPSDataEntityId), psDERGroupList, PSDERGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDERGroupDetails(String strPSDERGroupId, Vector<PSDERGroupDetail> psDERGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDERGroupStorage(strPSDERGroupId) != null
            && this.fromList(psDERGroupDetailList, psSystemStorage.getPSDERGroupStorage(strPSDERGroupId).psDERGroupDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDERGroupDetails(strPSDERGroupId), psDERGroupDetailList, PSDERGroupDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDEGroups(String strPSSystemId, Vector<PSDEGroup> psDEGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDEGroupList, psSystemStorage.psDEGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDEGroups(strPSSystemId), psDEGroupList, PSDEGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDERGroups(String strPSSystemId, Vector<PSDERGroup> psDERGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psDERGroupList, psSystemStorage.psDERGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDERGroups(strPSSystemId), psDERGroupList, PSDERGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionGroups(String strPSDataEntityId, Vector<PSDEActionGroup> psDEActionGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEActionGroupList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEActionGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActionGroups(strPSDataEntityId), psDEActionGroupList, PSDEActionGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEActionGroupDetails(String strPSDEActionGroupId, Vector<PSDEAGDetail> psDEActionGroupDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEActionGroupStorage(strPSDEActionGroupId) != null
            && this.fromList(psDEActionGroupDetailList, psSystemStorage.getPSDEActionGroupStorage(strPSDEActionGroupId).psDEActionGroupDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEActionGroupDetails(strPSDEActionGroupId), psDEActionGroupDetailList, PSDEAGDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysTestPrjs(String strPSSystemId, Vector<PSSysTestPrj> psSysTestPrjList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysTestPrjList, psSystemStorage.psSysTestPrjList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysTestPrjs(strPSSystemId), psSysTestPrjList, PSSysTestPrj.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysTestPrj(String strPSSysTestPrjId, PSSysTestPrj psSysTestPrj) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysTestPrjMap.get(strPSSysTestPrjId) != null) {
         psSystemStorage.psSysTestPrjMap.get(strPSSysTestPrjId).CopyTo(psSysTestPrj, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysTestPrj(strPSSysTestPrjId), psSysTestPrj, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysTestModules(String strPSSysTestPrjId, Vector<PSSysTestModule> psSysTestModuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysTestPrjStorage(strPSSysTestPrjId) != null
            && this.fromList(psSysTestModuleList, psSystemStorage.getPSSysTestPrjStorage(strPSSysTestPrjId).psSysTestModuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysTestModules(strPSSysTestPrjId), psSysTestModuleList, PSSysTestModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysTestCases(String strPSSysTestModuleId, Vector<PSSysTestCase> psSysTestCaseList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysTestModuleStorage(strPSSysTestModuleId) != null
            && this.fromList(psSysTestCaseList, psSystemStorage.getPSSysTestModuleStorage(strPSSysTestModuleId).psSysTestCaseList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysTestCases(strPSSysTestModuleId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysReqModules(String strPSSystemId, Vector<PSSysReqModule> psSysReqModuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysReqModuleList, psSystemStorage.psSysReqModuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysReqModules(strPSSystemId), psSysReqModuleList, PSSysReqModule.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysReqModule(String strPSSysReqModuleId, PSSysReqModule psSysReqModule) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId) != null) {
         psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId).psSysReqModule.CopyTo(psSysReqModule, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysReqModule(strPSSysReqModuleId), psSysReqModule, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSSysReqModules(String strPSSysReqModuleId, Vector<PSSysReqModule> psSysReqModuleList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId) != null
            && this.fromList(psSysReqModuleList, psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId).psSysReqModuleList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysReqModules(strPSSysReqModuleId), psSysReqModuleList, PSSysReqItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysReqItems(String strPSSystemId, Vector<PSSysReqItem> psSysReqItemList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysReqItemList, psSystemStorage.psSysReqItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysReqItems(strPSSystemId), psSysReqItemList, PSSysReqItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysReqItem(String strPSSysReqItemId, PSSysReqItem psSysReqItem) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysReqItemMap.get(strPSSysReqItemId) != null) {
         psSystemStorage.psSysReqItemMap.get(strPSSysReqItemId).CopyTo(psSysReqItem, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysReqItem(strPSSysReqItemId), psSysReqItem, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEDBTables(String strPSDataEntityId, Vector<PSDEDBTable> psDEDBTableList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psDEDBTableList, psSystemStorage.getPSDataEntityStorage(strPSDataEntityId).psDEDBTableList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDBTables(strPSDataEntityId), psDEDBTableList, PSDEDBTable.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDBTablesBySystem(String strPSSystemId, Vector<PSDEDBTable> psDEDBTableList) {
      return this.selectMulti(this.getSQL_getPSDEDBTablesBySystem(strPSSystemId), psDEDBTableList, PSDEDBTable.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEUserRole(String strPSDEUserRoleId, PSDEUserRole psDEUserRole) {
      return this.selectSingle(this.getSQL_getPSDEUserRole(strPSDEUserRoleId), psDEUserRole, "SYSTEM");
   }

   @Override
   public CallResult getPSCtrlLogicGroups(String strPSDataEntityId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null
            && this.fromList(psCtrlLogicGroupList, psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId).psCtrlLogicGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSCtrlLogicGroups(strPSDataEntityId), psCtrlLogicGroupList, PSCtrlLogicGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSCtrlLogicGroupDetails(String strPSCtrlLogicGroupId, Vector<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.getPSCtrlLogicGroupStorage(strPSCtrlLogicGroupId) != null
            && this.fromList(psCtrlLogicGroupDetailList, psSysAppStorage.getPSCtrlLogicGroupStorage(strPSCtrlLogicGroupId).psCtrlLogicGroupDetailList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSCtrlLogicGroupDetails(strPSCtrlLogicGroupId), psCtrlLogicGroupDetailList, PSCtrlLogicGroupDetail.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSSysCtrlLogicGroups(String strPSSystemId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psCtrlLogicGroupList, psSysAppStorage.psCtrlLogicGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysCtrlLogicGroups(strPSSystemId), psCtrlLogicGroupList, PSCtrlLogicGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSCtrlLogicGroup(String strPSCtrlLogicGroupId, PSCtrlLogicGroup psCtrlLogicGroup) {
      return this.selectSingle(this.getSQL_getPSCtrlLogicGroup(strPSCtrlLogicGroupId), psCtrlLogicGroup, "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysModelGroups(String strPSSystemId, Vector<PSSysModelGroup> psSysModelGroupList) {
      return this.selectMulti(this.getSQL_getAllPSSysModelGroups(strPSSystemId), psSysModelGroupList, PSSysModelGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSearchSchemes(String strPSSystemId, Vector<PSSysSearchScheme> psSysSearchSchemeList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysSearchSchemeList, psSystemStorage.psSysSearchSchemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSearchSchemes(strPSSystemId), psSysSearchSchemeList, PSSysSearchScheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchScheme(String strPSSysSearchSchemeId, PSSysSearchScheme psSysSearchScheme) {
      if (this.getModelInstVer() < 611) {
         return CallResult.create(3);
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psSysSearchSchemeMap.get(strPSSysSearchSchemeId) != null) {
            psSystemStorage.psSysSearchSchemeMap.get(strPSSysSearchSchemeId).CopyTo(psSysSearchScheme, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysSearchScheme(strPSSysSearchSchemeId), psSysSearchScheme, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSSysSearchDocs(String strPSSysSearchSchemeId, Vector<PSSysSearchDoc> psSysSearchDocList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId) != null
            && this.fromList(psSysSearchDocList, psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId).psSysSearchDocList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchDocs(strPSSysSearchSchemeId), psSysSearchDocList, PSSysSearchDoc.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchDEs(String strPSSysSearchSchemeId, Vector<PSSysSearchDE> psSysSearchDEList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId) != null
            && this.fromList(psSysSearchDEList, psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId).psSysSearchDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchDEs(strPSSysSearchSchemeId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchFields(String strPSSysSearchDocId, Vector<PSSysSearchField> psSysSearchFieldList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysSearchDocStorage(strPSSysSearchDocId) != null
            && this.fromList(psSysSearchFieldList, psSystemStorage.getPSSysSearchDocStorage(strPSSysSearchDocId).psSysSearchFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchFields(strPSSysSearchDocId), psSysSearchFieldList, PSSysSearchField.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchDEFields(String strPSSysSearchDEId, Vector<PSSysSearchDEField> psSysSearchDEFieldList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysSearchDEStorage(strPSSysSearchDEId) != null
            && this.fromList(psSysSearchDEFieldList, psSystemStorage.getPSSysSearchDEStorage(strPSSysSearchDEId).psSysSearchDEFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchDEFields(strPSSysSearchDEId), psSysSearchDEFieldList, PSSysSearchDEField.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDESearchs(String strPSDEId, Vector<PSSysSearchDE> psSysSearchDEList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psSysSearchDEList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDESearchList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDESearchs(strPSDEId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchDEFieldsByDataEntity(String strPSDEId, Vector<PSSysSearchDEField> psSysSearchDEFieldList) {
      if (this.getModelInstVer() < 611) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psSysSearchDEFieldList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psSysSearchDEFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchDEFieldsByDataEntity(strPSDEId), psSysSearchDEFieldList, PSSysSearchDEField.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysMapViews(String strPSSystemId, Vector<PSSysMapView> psSysMapViewList) {
      if (this.getModelInstVer() < 614) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psSysMapViewList, psSysAppStorage.psSysMapViewList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysMapViews(strPSSystemId), psSysMapViewList, PSSysMapView.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysMapView(String strPSSysMapViewId, PSSysMapView psSysMapView) {
      if (this.getModelInstVer() < 614) {
         return CallResult.create(3);
      } else {
         PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
         if (psSysAppStorage != null && psSysAppStorage.psSysMapViewStorageMap.containsKey(strPSSysMapViewId)) {
            psSysAppStorage.psSysMapViewStorageMap.get(strPSSysMapViewId).psSysMapView.CopyTo(psSysMapView, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysMapView(strPSSysMapViewId), psSysMapView, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSSysMapItems(String strPSSysMapViewId, Vector<PSSysMapItem> psSysMapItemList) {
      if (this.getModelInstVer() < 614) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysMapViewStorageMap.containsKey(strPSSysMapViewId)
            && this.fromList(psSysMapItemList, psSysAppStorage.getPSSysMapViewStorage(strPSSysMapViewId).psSysMapItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysMapItems(strPSSysMapViewId), psSysMapItemList, PSSysMapItem.class.getName(), "SYSTEM");
   }

   public CallResult getAllPSAppUtils2(String strPSApplicationId, Vector<PSAppUtil> psAppUtils) {
      return this.selectMulti(this.getSQL_getAllPSAppUtils(strPSApplicationId), psAppUtils, PSAppUtil.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppUtils(String strPSApplicationId, Vector<PSAppUtil> psAppUtils) {
      if (this.getModelInstVer() < 629) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppUtils, psSysAppStorage.psAppUtilList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppUtils(strPSApplicationId), psAppUtils, PSAppUtil.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppUtil(String strPSAppUtilId, PSAppUtil psAppUtil) {
      return this.getModelInstVer() < 629 ? CallResult.create(3) : this.selectSingle(this.getSQL_getPSAppUtil(strPSAppUtilId), psAppUtil, "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysPortletCats(String strPSSystemId, Vector<PSSysPortletCat> psSysPortletCatList) {
      if (this.getModelInstVer() < 630) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psSysPortletCatList, psSysPortletCatList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysPortletCats(strPSSystemId), psSysPortletCatList, PSSysPortletCat.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysPortletCat(String strPSSysPortletCatId, PSSysPortletCat psSysPortletCat) {
      if (this.getModelInstVer() < 630) {
         return CallResult.create(3);
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psSysPortletCatMap.get(strPSSysPortletCatId) != null) {
            psSystemStorage.psSysPortletCatMap.get(strPSSysPortletCatId).CopyTo(psSysPortletCat, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysPortletCat(strPSSysPortletCatId), psSysPortletCat, "SYSTEM");
         }
      }
   }

   public CallResult getAllPSAppPortlets2(String strPSApplicationId, Vector<PSAppPortlet> psAppPortlets) {
      return this.selectMulti(this.getSQL_getAllPSAppPortlets(strPSApplicationId), psAppPortlets, PSAppPortlet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppPortlets(String strPSApplicationId, Vector<PSAppPortlet> psAppPortlets) {
      if (this.getModelInstVer() < 630) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppPortlets, psSysAppStorage.psAppPortletList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppPortlets(strPSApplicationId), psAppPortlets, PSAppPortlet.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppPortlet(String strPSAppPortletId, PSAppPortlet psAppPortlet) {
      return this.getModelInstVer() < 630 ? CallResult.create(3) : this.selectSingle(this.getSQL_getPSAppPortlet(strPSAppPortletId), psAppPortlet, "SYSTEM");
   }

   public CallResult getAllPSAppPFPlugins2(String strPSApplicationId, Vector<PSAppPFPlugin> psAppPFPlugins) {
      return this.selectMulti(this.getSQL_getAllPSAppPFPlugins(strPSApplicationId), psAppPFPlugins, PSAppPFPlugin.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppPFPlugins(String strPSApplicationId, Vector<PSAppPFPlugin> psAppPFPlugins) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppPFPlugins, psSysAppStorage.psAppPFPluginList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSAppPFPlugins(strPSApplicationId), psAppPFPlugins, PSAppPFPlugin.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEGridEditItemVRs(String strPSDEGridId, Vector<PSDEGridEditItemVR> psDEGridEditItemVRList) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null
            && this.fromList(psDEGridEditItemVRList, psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGridEditItemVRList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEGridEditItemVRs(strPSDEGridId), psDEGridEditItemVRList, PSDEGridEditItemVR.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEWizard(String strPSDEWizardId, PSDEWizard psDEWizard) {
      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      if (psSysAppStorage != null && psSysAppStorage.psDEWizardStorageMap.containsKey(strPSDEWizardId)) {
         psSysAppStorage.psDEWizardStorageMap.get(strPSDEWizardId).psDEWizard.CopyTo(psDEWizard, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSDEWizard(strPSDEWizardId), psDEWizard, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEActionVRs(String strPSDEActionId, Vector<PSDEActionVR> psDEActionVRList) {
      if (this.getModelInstVer() < 657) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
         for (PSDEActionVR psDEActionVR : psSystemStorage.getPSDEActionStorage(strPSDEActionId).psDEActionVRList) {
            PSDEActionVR psDEActionVR2 = new PSDEActionVR();
            psDEActionVR.CopyTo(psDEActionVR2, true);
            psDEActionVRList.add(psDEActionVR2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEActionVRs(strPSDEActionId), psDEActionVRList, PSDEActionVR.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEMainStateFields(String strPSDEMainStateId, Vector<PSDEMainStateField> psDEMainStateFieldList) {
      if (this.getModelInstVer() < 659) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
         for (PSDEMainStateField psDEMainStateField : psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId).psDEMainStateFieldList) {
            PSDEMainStateField psDEMainStateField2 = new PSDEMainStateField();
            psDEMainStateField.CopyTo(psDEMainStateField2, true);
            psDEMainStateFieldList.add(psDEMainStateField2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEMainStateFields(strPSDEMainStateId), psDEMainStateFieldList, PSDEMainStateField.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEFGroupItems(String strPSDEFGroupId, Vector<PSDEFormDetail> psDEFormDetailList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null
            && this.fromList(psDEFormDetailList, psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId).psDEFormDetailList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFGroupItems(strPSDEFGroupId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFGroupColumns(String strPSDEFGroupId, Vector<PSDEGridColumn> psDEGridColumnList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null
            && this.fromList(psDEGridColumnList, psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId).psDEGridColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFGroupColumns(strPSDEFGroupId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysSequences(String strPSSystemId, Vector<PSSysSequence> psSysSequenceList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysSequenceList, psSystemStorage.psSysSequenceList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysSequences(strPSSystemId), psSysSequenceList, PSSysSequence.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSequence(String strPSSysSequenceId, PSSysSequence psSysSequence) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysSequenceMap.get(strPSSysSequenceId) != null) {
         psSystemStorage.psSysSequenceMap.get(strPSSysSequenceId).CopyTo(psSysSequence, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysSequence(strPSSysSequenceId), psSysSequence, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysTranslators(String strPSSystemId, Vector<PSSysTranslator> psSysTranslatorList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysTranslatorList, psSystemStorage.psSysTranslatorList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysTranslators(strPSSystemId), psSysTranslatorList, PSSysTranslator.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysTranslator(String strPSSysTranslatorId, PSSysTranslator psSysTranslator) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysTranslatorMap.get(strPSSysTranslatorId) != null) {
         psSystemStorage.psSysTranslatorMap.get(strPSSysTranslatorId).CopyTo(psSysTranslator, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysTranslator(strPSSysTranslatorId), psSysTranslator, "SYSTEM");
      }
   }

   @Override
   public CallResult getPSWFUtilUIActions(String strPSSysWFSettingId, Vector<PSWFUtilUIAction> psWFUtilUIActionList) {
      return this.selectMulti(this.getSQL_getPSWFUtilUIActions(strPSSysWFSettingId), psWFUtilUIActionList, PSWFUtilUIAction.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysMsgTargets(String strPSSystemId, Vector<PSSysMsgTarget> psSysMsgTargetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysMsgTargetList, psSystemStorage.psSysMsgTargetList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysMsgTargets(strPSSystemId), psSysMsgTargetList, PSSysMsgTarget.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysMsgQueues(String strPSSystemId, Vector<PSSysMsgQueue> psSysMsgQueueList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysMsgQueueList, psSystemStorage.psSysMsgQueueList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysMsgQueues(strPSSystemId), psSysMsgQueueList, PSSysMsgQueue.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDENotifies(String strPSDEId, Vector<PSDENotify> psDENotifyList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null
            && this.fromList(psDENotifyList, psSystemStorage.getPSDataEntityStorage(strPSDEId).psDENotifyList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDENotifies(strPSDEId), psDENotifyList, PSDENotify.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDENotifyTargets(String strPSDENotifyId, Vector<PSDENotifyTarget> psDENotifyTargetList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psDENotifyStorageMap.get(strPSDENotifyId) != null) {
         for (PSDENotifyTarget psDENotifyTarget : psSystemStorage.psDENotifyStorageMap.get(strPSDENotifyId).psDENotifyTargetList) {
            PSDENotifyTarget psDENotifyTarget2 = new PSDENotifyTarget();
            psDENotifyTarget.CopyTo(psDENotifyTarget2, true);
            psDENotifyTargetList.add(psDENotifyTarget2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDENotifyTargets(strPSDENotifyId), psDENotifyTargetList, PSDENotifyTarget.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysEAISchemes(String strPSSystemId, Vector<PSSysEAIScheme> psSysEAISchemeList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysEAISchemeList, psSystemStorage.psSysEAISchemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysEAISchemes(strPSSystemId), psSysEAISchemeList, PSSysEAIScheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIScheme(String strPSSysEAISchemeId, PSSysEAIScheme psSysEAIScheme) {
      if (this.getModelInstVer() < 697) {
         return CallResult.create(3);
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psSysEAISchemeMap.get(strPSSysEAISchemeId) != null) {
            psSystemStorage.psSysEAISchemeMap.get(strPSSysEAISchemeId).CopyTo(psSysEAIScheme, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysEAIScheme(strPSSysEAISchemeId), psSysEAIScheme, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSSysEAIDataTypes(String strPSSysEAISchemeId, Vector<PSSysEAIDataType> psSysEAIDataTypeList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null
            && this.fromList(psSysEAIDataTypeList, psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId).psSysEAIDataTypeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIDataTypes(strPSSysEAISchemeId), psSysEAIDataTypeList, PSSysEAIDataType.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIDataTypeItems(String strPSSysEAIDataTypeId, Vector<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAIDataTypeStorage(strPSSysEAIDataTypeId) != null
            && this.fromList(psSysEAIDataTypeItemList, psSystemStorage.getPSSysEAIDataTypeStorage(strPSSysEAIDataTypeId).psSysEAIDataTypeItemList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSSysEAIDataTypeItems(strPSSysEAIDataTypeId), psSysEAIDataTypeItemList, PSSysEAIDataTypeItem.class.getName(), "SYSTEM"
         );
   }

   @Override
   public CallResult getPSSysEAIElements(String strPSSysEAISchemeId, Vector<PSSysEAIElement> psSysEAIElementList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null
            && this.fromList(psSysEAIElementList, psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId).psSysEAIElementList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIElements(strPSSysEAISchemeId), psSysEAIElementList, PSSysEAIElement.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIElementAttrs(String strPSSysEAIElementId, Vector<PSSysEAIElementAttr> psSysEAIElementAttrList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId) != null
            && this.fromList(psSysEAIElementAttrList, psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId).psSysEAIElementAttrList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIElementAttrs(strPSSysEAIElementId), psSysEAIElementAttrList, PSSysEAIElementAttr.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIElementREs(String strPSSysEAIElementId, Vector<PSSysEAIElementRE> psSysEAIElementREList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId) != null
            && this.fromList(psSysEAIElementREList, psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId).psSysEAIElementREList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIElementREs(strPSSysEAIElementId), psSysEAIElementREList, PSSysEAIElementRE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIDEs(String strPSSysEAISchemeId, Vector<PSSysEAIDE> psSysEAIDEList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null
            && this.fromList(psSysEAIDEList, psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId).psSysEAIDEList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIDEs(strPSSysEAISchemeId), psSysEAIDEList, PSSysEAIDE.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIDEFields(String strPSSysEAIDEId, Vector<PSSysEAIDEField> psSysEAIDEFieldList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId) != null
            && this.fromList(psSysEAIDEFieldList, psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId).psSysEAIDEFieldList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIDEFields(strPSSysEAIDEId), psSysEAIDEFieldList, PSSysEAIDEField.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysEAIDERs(String strPSSysEAIDEId, Vector<PSSysEAIDER> psSysEAIDERList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId) != null
            && this.fromList(psSysEAIDERList, psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId).psSysEAIDERList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysEAIDERs(strPSSysEAIDEId), psSysEAIDERList, PSSysEAIDER.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysBISchemes(String strPSSystemId, Vector<PSSysBIScheme> psSysBISchemeList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysBISchemeList, psSystemStorage.psSysBISchemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysBISchemes(strPSSystemId), psSysBISchemeList, PSSysBIScheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIScheme(String strPSSysBISchemeId, PSSysBIScheme psSysBIScheme) {
      if (this.getModelInstVer() < 697) {
         return CallResult.create(3);
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psSysBISchemeMap.get(strPSSysBISchemeId) != null) {
            psSystemStorage.psSysBISchemeMap.get(strPSSysBISchemeId).CopyTo(psSysBIScheme, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysBIScheme(strPSSysBISchemeId), psSysBIScheme, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSSysBIDimensions(String strPSSysBISchemeId, Vector<PSSysBIDimension> psSysBIDimensionList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null
            && this.fromList(psSysBIDimensionList, psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId).psSysBIDimensionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIDimensions(strPSSysBISchemeId), psSysBIDimensionList, PSSysBIDimension.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIHierarchies(String strPSSysBIDimensionId, Vector<PSSysBIHierarchy> psSysBIHierarchyList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBIDimensionStorage(strPSSysBIDimensionId) != null
            && this.fromList(psSysBIHierarchyList, psSystemStorage.getPSSysBIDimensionStorage(strPSSysBIDimensionId).psSysBIHierarchyList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIHierarchies(strPSSysBIDimensionId), psSysBIHierarchyList, PSSysBIHierarchy.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBILevels(String strPSSysBIHierarchyId, Vector<PSSysBILevel> psSysBILevelList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBIHierarchyStorage(strPSSysBIHierarchyId) != null
            && this.fromList(psSysBILevelList, psSystemStorage.getPSSysBIHierarchyStorage(strPSSysBIHierarchyId).psSysBILevelList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBILevels(strPSSysBIHierarchyId), psSysBILevelList, PSSysBILevel.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBICubes(String strPSSysBISchemeId, Vector<PSSysBICube> psSysBICubeList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null
            && this.fromList(psSysBICubeList, psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId).psSysBICubeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBICubes(strPSSysBISchemeId), psSysBICubeList, PSSysBICube.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBICubeDimensions(String strPSSysBICubeId, Vector<PSSysBICubeDimension> psSysBICubeDimensionList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId) != null
            && this.fromList(psSysBICubeDimensionList, psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId).psSysBICubeDimensionList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBICubeDimensions(strPSSysBICubeId), psSysBICubeDimensionList, PSSysBICubeDimension.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBICubeMeasures(String strPSSysBICubeId, Vector<PSSysBICubeMeasure> psSysBICubeMeasureList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId) != null
            && this.fromList(psSysBICubeMeasureList, psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId).psSysBICubeMeasureList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBICubeMeasures(strPSSysBICubeId), psSysBICubeMeasureList, PSSysBICubeMeasure.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBICubeLevels(String strPSSysBIDimensionId, Vector<PSSysBICubeLevel> psSysBICubeLevelList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBICubeDimensionStorage(strPSSysBIDimensionId) != null
            && this.fromList(psSysBICubeLevelList, psSystemStorage.getPSSysBICubeDimensionStorage(strPSSysBIDimensionId).psSysBICubeLevelList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBICubeLevels(strPSSysBIDimensionId), psSysBICubeLevelList, PSSysBICubeLevel.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIAggTables(String strPSSysBISchemeId, Vector<PSSysBIAggTable> psSysBIAggTableList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null
            && this.fromList(psSysBIAggTableList, psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId).psSysBIAggTableList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIAggTables(strPSSysBISchemeId), psSysBIAggTableList, PSSysBIAggTable.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIAggColumns(String strPSSysBIAggTableId, Vector<PSSysBIAggColumn> psSysBIAggColumnList) {
      if (this.getModelInstVer() < 697) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBIAggTableStorage(strPSSysBIAggTableId) != null
            && this.fromList(psSysBIAggColumnList, psSystemStorage.getPSSysBIAggTableStorage(strPSSysBIAggTableId).psSysBIAggColumnList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIAggColumns(strPSSysBIAggTableId), psSysBIAggColumnList, PSSysBIAggColumn.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIReports(String strPSSysBISchemeId, Vector<PSSysBIReport> psSysBIReportList) {
      if (this.getModelInstVer() < 785) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null
            && this.fromList(psSysBIReportList, psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId).psSysBIReportList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIReports(strPSSysBISchemeId), psSysBIReportList, PSSysBIReport.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysBIReportItems(String strPSSysBIReportId, Vector<PSSysBIReportItem> psSysBIReportItemList) {
      if (this.getModelInstVer() < 785) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysBIReportStorage(strPSSysBIReportId) != null
            && this.fromList(psSysBIReportItemList, psSystemStorage.getPSSysBIReportStorage(strPSSysBIReportId).psSysBIReportItemList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysBIReportItems(strPSSysBIReportId), psSysBIReportItemList, PSSysBIReportItem.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSThresholdGroups(String strPSSystemId, Vector<PSThresholdGroup> psThresholdGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psThresholdGroupList, psThresholdGroupList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSThresholdGroups(strPSSystemId), psThresholdGroupList, PSThresholdGroup.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSThresholds(String strPSThresholdGroupId, Vector<PSThreshold> psThresholdList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSThresholdGroupStorage(strPSThresholdGroupId) != null
            && this.copyList(psSystemStorage.getPSThresholdGroupStorage(strPSThresholdGroupId).psThresholdList, psThresholdList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSThresholds(strPSThresholdGroupId), psThresholdList, PSThreshold.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSThresholdGroup(String strPSThresholdGroupId, PSThresholdGroup psThresholdGroup) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psThresholdGroupMap.get(strPSThresholdGroupId) != null) {
         psSystemStorage.psThresholdGroupMap.get(strPSThresholdGroupId).CopyTo(psThresholdGroup, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSThresholdGroup(strPSThresholdGroupId), psThresholdGroup, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysChartThemes(String strPSSystemId, Vector<PSSysChartTheme> psSysChartThemeList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysChartThemeList, psSystemStorage.psSysChartThemeList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysChartThemes(strPSSystemId), psSysChartThemeList, PSSysChartTheme.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysChartTheme(String strPSSysChartThemeId, PSSysChartTheme psSysChartTheme) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.psSysChartThemeMap.get(strPSSysChartThemeId) != null) {
         psSystemStorage.psSysChartThemeMap.get(strPSSysChartThemeId).CopyTo(psSysChartTheme, true);
         return new CallResult();
      } else {
         return this.selectSingle(this.getSQL_getPSSysChartTheme(strPSSysChartThemeId), psSysChartTheme, "SYSTEM");
      }
   }

   @Override
   public CallResult getAllPSSysDBValueFuncs(String strPSSystemId, Vector<PSSysDBValueFunc> psSysDBValueFuncList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysDBValueFuncList, psSystemStorage.psSysDBValueFuncList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysDBValueFuncs(strPSSystemId), psSysDBValueFuncList, PSSysDBValueFunc.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSDELogics(String strPSSystemId, Vector<PSDELogic> psDELogicList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psDELogicList, psDELogicList)
         ? new CallResult()
         : this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
   }

   @Override
   public CallResult getAllPSDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psDEUIActionList2, psDEUIActionList)
         ? new CallResult()
         : this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionList);
   }

   @Override
   public CallResult getAllPSCtrlLogicGroups(String strPSSystemId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.copyList(psSystemStorage.psCtrlLogicGroupList2, psCtrlLogicGroupList)
         ? new CallResult()
         : this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
   }

   @Override
   public CallResult getPSDEDSParams(String strPSDataSetId, Vector<PSDEDSParam> psDEDSParamList) {
      if (this.getModelInstVer() < 746) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null
            && this.fromList(psDEDSParamList, psSystemStorage.getPSDEDataSetStorage(strPSDataSetId).psDEDSParamList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDSParams(strPSDataSetId), psDEDSParamList, PSDEDSParam.class.getName(), "SYSTEM");
   }

   public CallResult getPSDEDSParamsBySystem(String strPSSystemId, Vector<PSDEDSParam> psDEDSParamList) {
      return this.getModelInstVer() < 746
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDSParamsBySystem(strPSSystemId), psDEDSParamList, PSDEDSParam.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEGridLogics(String strPSDEGridId, Vector<PSDEGridLogic> psDEGridLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null
            && this.fromList(psDEGridLogicList, psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId).psDEGridLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEGridLogics(strPSDEGridId), psDEGridLogicList, PSDEGridLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEToolbarLogics(String strPSDEToolbarId, Vector<PSDEToolbarLogic> psDEToolbarLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId) != null
            && this.fromList(psDEToolbarLogicList, psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId).psDEToolbarLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEToolbarLogics(strPSDEToolbarId), psDEToolbarLogicList, PSDEToolbarLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDETreeLogics(String strPSDETreeId, Vector<PSDETreeLogic> psDETreeLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null
            && this.fromList(psDETreeLogicList, psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId).psDETreeLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDETreeLogics(strPSDETreeId), psDETreeLogicList, PSDETreeLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEListLogics(String strPSDEListId, Vector<PSDEListLogic> psDEListLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null
            && this.fromList(psDEListLogicList, psSysAppStorage.psDEListStorageMap.get(strPSDEListId).psDEListLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEListLogics(strPSDEListId), psDEListLogicList, PSDEListLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSAppLogics(String strPSApplicationId, Vector<PSAppLogic> psAppLogics) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null && this.fromList(psAppLogics, psSysAppStorage.psAppLogicList)
         ? new CallResult()
         : this.selectMultiValid(this.getSQL_getAllPSAppLogics(strPSApplicationId), psAppLogics, PSAppLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEFormLogics(String strPSDEFormId, Vector<PSDEFormLogic> psDEFormLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null
            && this.fromList(psDEFormLogicList, psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId).psDEFormLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEFormLogics(strPSDEFormId), psDEFormLogicList, PSDEFormLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEDataViewLogics(String strPSDEDataViewId, Vector<PSDEDataViewLogic> psDEDataViewLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null
            && this.fromList(psDEDataViewLogicList, psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId).psDEDataViewLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEDataViewLogics(strPSDEDataViewId), psDEDataViewLogicList, PSDEDataViewLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSDEWizardLogics(String strPSDEWizardId, Vector<PSDEWizardLogic> psDEWizardLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
         for (PSDEWizardLogic psDEWizardLogic : psSystemStorage.getPSDEWizardStorage(strPSDEWizardId).psDEWizardLogicList) {
            PSDEWizardLogic psDEWizardLogic2 = new PSDEWizardLogic();
            psDEWizardLogic.CopyTo(psDEWizardLogic2, true);
            psDEWizardLogicList.add(psDEWizardLogic2);
         }

         return new CallResult();
      } else {
         return this.selectMulti(this.getSQL_getPSDEWizardLogics(strPSDEWizardId), psDEWizardLogicList, PSDEWizardLogic.class.getName(), "SYSTEM");
      }
   }

   @Override
   public CallResult getPSDEChartLogics(String strPSDEChartId, Vector<PSDEChartLogic> psDEChartLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null
            && this.fromList(psDEChartLogicList, psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId).psDEChartLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSDEChartLogics(strPSDEChartId), psDEChartLogicList, PSDEChartLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysCalendarLogics(String strPSSysCalendarId, Vector<PSSysCalendarLogic> psSysCalendarLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId) != null
            && this.fromList(psSysCalendarLogicList, psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId).psSysCalendarLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysCalendarLogics(strPSSysCalendarId), psSysCalendarLogicList, PSSysCalendarLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysDashboardLogics(String strPSSysDashboardId, Vector<PSSysDashboardLogic> psSysDashboardLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysDashboardStorageMap.get(strPSSysDashboardId) != null
            && this.fromList(psSysDashboardLogicList, psSysAppStorage.psSysDashboardStorageMap.get(strPSSysDashboardId).psSysDashboardLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysDashboardLogics(strPSSysDashboardId), psSysDashboardLogicList, PSSysDashboardLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysSearchBarLogics(String strPSSysSearchBarId, Vector<PSSysSearchBarLogic> psSysSearchBarLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysSearchBarStorageMap.get(strPSSysSearchBarId) != null
            && this.fromList(psSysSearchBarLogicList, psSysAppStorage.psSysSearchBarStorageMap.get(strPSSysSearchBarId).psSysSearchBarLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysSearchBarLogics(strPSSysSearchBarId), psSysSearchBarLogicList, PSSysSearchBarLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysMapLogics(String strPSSysMapId, Vector<PSSysMapLogic> psSysMapLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psSysMapViewStorageMap.get(strPSSysMapId) != null
            && this.fromList(psSysMapLogicList, psSysAppStorage.psSysMapViewStorageMap.get(strPSSysMapId).psSysMapLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysMapLogics(strPSSysMapId), psSysMapLogicList, PSSysMapLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSAppMenuLogics(String strPSAppMenuId, Vector<PSAppMenuLogic> psAppMenuLogicList) {
      if (this.getModelInstVer() < 747) {
         return new CallResult();
      }

      PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
      return psSysAppStorage != null
            && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null
            && this.fromList(psAppMenuLogicList, psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId).psAppMenuLogicList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSAppMenuLogics(strPSAppMenuId), psAppMenuLogicList, PSAppMenuLogic.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getAllPSSysAIFactories(String strPSSystemId, Vector<PSSysAIFactory> psSysAIFactoryList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null && this.fromList(psSysAIFactoryList, psSystemStorage.psSysAIFactoryList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getAllPSSysAIFactories(strPSSystemId), psSysAIFactoryList, PSSysAIFactory.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAIFactory(String strPSSysAIFactoryId, PSSysAIFactory psSysAIFactory) {
      if (this.getModelInstVer() < 803) {
         return CallResult.create(3);
      } else {
         PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
         if (psSystemStorage != null && psSystemStorage.psSysAIFactoryMap.get(strPSSysAIFactoryId) != null) {
            psSystemStorage.psSysAIFactoryMap.get(strPSSysAIFactoryId).CopyTo(psSysAIFactory, true);
            return new CallResult();
         } else {
            return this.selectSingle(this.getSQL_getPSSysAIFactory(strPSSysAIFactoryId), psSysAIFactory, "SYSTEM");
         }
      }
   }

   @Override
   public CallResult getPSSysAIChatAgents(String strPSSysAIFactoryId, Vector<PSSysAIChatAgent> psSysAIChatAgentList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null
            && this.fromList(psSysAIChatAgentList, psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId).psSysAIChatAgentList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysAIChatAgents(strPSSysAIFactoryId), psSysAIChatAgentList, PSSysAIChatAgent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAIWorkerAgents(String strPSSysAIFactoryId, Vector<PSSysAIWorkerAgent> psSysAIWorkerAgentList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null
            && this.fromList(psSysAIWorkerAgentList, psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId).psSysAIWorkerAgentList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysAIWorkerAgents(strPSSysAIFactoryId), psSysAIWorkerAgentList, PSSysAIWorkerAgent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAIPipelineAgents(String strPSSysAIFactoryId, Vector<PSSysAIPipelineAgent> psSysAIPipelineAgentList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null
            && this.fromList(psSysAIPipelineAgentList, psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId).psSysAIPipelineAgentList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysAIPipelineAgents(strPSSysAIFactoryId), psSysAIPipelineAgentList, PSSysAIPipelineAgent.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAIPipelineJobs(String strPSSysAIPipelineId, Vector<PSSysAIPipelineJob> psSysAIPipelineJobList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId) != null
            && this.fromList(psSysAIPipelineJobList, psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId).psSysAIPipelineJobList)
         ? new CallResult()
         : this.selectMulti(this.getSQL_getPSSysAIPipelineJobs(strPSSysAIPipelineId), psSysAIPipelineJobList, PSSysAIPipelineJob.class.getName(), "SYSTEM");
   }

   @Override
   public CallResult getPSSysAIPipelineWorkers(String strPSSysAIPipelineId, Vector<PSSysAIPipelineWorker> psSysAIPipelineWorkerList) {
      if (this.getModelInstVer() < 803) {
         return new CallResult();
      }

      PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
      return psSystemStorage != null
            && psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId) != null
            && this.fromList(psSysAIPipelineWorkerList, psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId).psSysAIPipelineWorkerList)
         ? new CallResult()
         : this.selectMulti(
            this.getSQL_getPSSysAIPipelineWorkers(strPSSysAIPipelineId), psSysAIPipelineWorkerList, PSSysAIPipelineWorker.class.getName(), "SYSTEM"
         );
   }
}
