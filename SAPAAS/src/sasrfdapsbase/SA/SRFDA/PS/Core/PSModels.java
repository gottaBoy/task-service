/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppView
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService
 *  net.ibizsys.pscore.srv.util.PSModels
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineJob;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineWorker;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReportMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicLink;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicNode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReportItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicLink;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicNode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSAppLogic;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTOField;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.IPSAppPkg;
import SA.SRFDA.PS.Core.App.IPSAppResource;
import SA.SRFDA.PS.Core.App.IPSAppUtilPage;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationLogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppStartPage;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.App.Res.IPSAppEditorStyleRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppSubViewTypeRef;
import SA.SRFDA.PS.Core.App.Theme.IPSAppUITheme;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngineParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavContext;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFDE;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDER;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSThreshold;
import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItemRV;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarLogic;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallelAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLogic;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTab;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTabPage;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardLogic;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewDataItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewItem;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormLogic;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGEIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemVR;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridLogic;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.Control.IPSControlNavContext;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorItem;
import SA.SRFDA.PS.Core.Control.IPSMDControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSSDControl;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListItem;
import SA.SRFDA.PS.Core.Control.List.IPSDEListLogic;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapLogic;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelEngine;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelLogic2;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarLogic;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarLogic;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeLogic;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavContext;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRV;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionVR;
import SA.SRFDA.PS.Core.DataEntity.BA.IPSDEBDTable;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggDataDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportItem;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImportItem;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapAction;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.DataEntity.JIT.IPSDESampleData;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateOPPriv;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotifyTarget;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReportItem;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIVR;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.UniState.IPSDEUniState;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardLogic;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndexColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDMVer;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseAction;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseActions;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseActionsOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLogOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSet;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSetListOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSets;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSetsOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumn;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumns;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumnsOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraintsOwner;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFuncItem;
import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.Deploy.PSSysRunSessionImpl2;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonArraySchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefsOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchemaOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchemas;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonObjectSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperty;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.ER.IPSSysERMapNode;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpModule;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemImpl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsgItem;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSSysChartTheme;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
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
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleData;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleRes;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTOField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIHandler;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Components;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Info;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaType;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypeListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypes;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypesOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3OperationListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ParameterListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameters;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3RequestBodyOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Response;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ResponseListOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Responses;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3ResponsesOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3SchemaOwner;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseAssert;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCaseInput;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataItem;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUCMapNode;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogicParam;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Core.WF.IPSWFCallOrgActivityProcess;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveLink;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Core.WF.IPSWFLinkRole;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessParam;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroupDetail;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModels
extends net.ibizsys.pscore.srv.util.PSModels {
    private static final Log log = LogFactory.getLog(PSModels.class);
    private static ThreadLocal<String> psSysAppId = new ThreadLocal();
    private static HashMap<String, String> psModelIntMap = new HashMap();
    public static final String INT_PSACTIONCONTEXT = "net.ibizsys.model.IPSActionContext";
    public static final String INT_PSAJAXCONTROL = "net.ibizsys.model.control.IPSAjaxControl";
    public static final String INT_PSAJAXCONTROLHANDLER = "net.ibizsys.model.control.ajax.IPSAjaxControlHandler";
    public static final String INT_PSAJAXCONTROLHANDLERACTION = "net.ibizsys.model.control.ajax.IPSAjaxControlHandlerAction";
    public static final String INT_PSAJAXCONTROLPARAM = "net.ibizsys.model.control.IPSAjaxControlParam";
    public static final String INT_PSAJAXEDITOR = "net.ibizsys.model.control.IPSAjaxEditor";
    public static final String INT_PSAJAXHANDLER = "net.ibizsys.model.control.ajax.IPSAjaxHandler";
    public static final String INT_PSAJAXHANDLERACTION = "net.ibizsys.model.control.ajax.IPSAjaxHandlerAction";
    public static final String INT_PSAPPCODELIST = "net.ibizsys.model.app.codelist.IPSAppCodeList";
    public static final String INT_PSAPPMSGTEMPL = "net.ibizsys.model.app.msg.IPSAppMsgTempl";
    public static final String INT_PSAPPCOUNTER = "net.ibizsys.model.app.control.IPSAppCounter";
    public static final String INT_PSAPPCOUNTERREF = "net.ibizsys.model.app.control.IPSAppCounterRef";
    public static final String INT_PSAPPDEACMODE = "net.ibizsys.model.app.dataentity.IPSAppDEACMode";
    public static final String INT_PSAPPDEACMODEDATAITEM = "net.ibizsys.model.app.dataentity.IPSAppDEACModeDataItem";
    public static final String INT_PSAPPDEACTION = "net.ibizsys.model.app.dataentity.IPSAppDEAction";
    public static final String INT_PSAPPDECALENDAREXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDECalendarExplorerView";
    public static final String INT_PSAPPDECALENDARVIEW = "net.ibizsys.model.app.view.IPSAppDECalendarView";
    public static final String INT_PSAPPDECHARTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEChartExplorerView";
    public static final String INT_PSAPPDECHARTVIEW = "net.ibizsys.model.app.view.IPSAppDEChartView";
    public static final String INT_PSAPPDECUSTOMVIEW = "net.ibizsys.model.app.view.IPSAppDECustomView";
    public static final String INT_PSAPPDEDRGROUP = "net.ibizsys.model.app.dataentity.IPSAppDEDRGroup";
    public static final String INT_PSAPPDEDRITEM = "net.ibizsys.model.app.dataentity.IPSAppDEDRItem";
    public static final String INT_PSAPPDEDASHBOARDVIEW = "net.ibizsys.model.app.view.IPSAppDEDashboardView";
    public static final String INT_PSAPPDEDATAEXPORT = "net.ibizsys.model.app.dataentity.IPSAppDEDataExport";
    public static final String INT_PSAPPDEDATAEXPORTITEM = "net.ibizsys.model.app.dataentity.IPSAppDEDataExportItem";
    public static final String INT_PSAPPDEDATAEXPORTGROUP = "net.ibizsys.model.app.dataentity.IPSAppDEDataExportGroup";
    public static final String INT_PSAPPDEPRINT = "net.ibizsys.model.app.dataentity.IPSAppDEPrint";
    public static final String INT_PSAPPDEDATAIMPORT = "net.ibizsys.model.app.dataentity.IPSAppDEDataImport";
    public static final String INT_PSAPPDEDATAIMPORTITEM = "net.ibizsys.model.app.dataentity.IPSAppDEDataImportItem";
    public static final String INT_PSAPPDEDATASET = "net.ibizsys.model.app.dataentity.IPSAppDEDataSet";
    public static final String INT_PSAPPDEDATASETVIEWMSG = "net.ibizsys.model.app.view.IPSAppDEDataSetViewMsg";
    public static final String INT_PSAPPDEDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEDataView";
    public static final String INT_PSAPPDEDATAVIEWEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEDataViewExplorerView";
    public static final String INT_PSAPPDEEDITVIEW = "net.ibizsys.model.app.view.IPSAppDEEditView";
    public static final String INT_PSAPPDEEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEExplorerView";
    public static final String INT_PSAPPDEFVALUERULE = "net.ibizsys.model.app.dataentity.IPSAppDEFValueRule";
    public static final String INT_PSAPPDEFIELD = "net.ibizsys.model.app.dataentity.IPSAppDEField";
    public static final String INT_PSAPPDEGANTTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEGanttExplorerView";
    public static final String INT_PSAPPDEGANTTVIEW = "net.ibizsys.model.app.view.IPSAppDEGanttView";
    public static final String INT_PSAPPDEGRIDEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEGridExplorerView";
    public static final String INT_PSAPPDEGRIDVIEW = "net.ibizsys.model.app.view.IPSAppDEGridView";
    public static final String INT_PSAPPDEGRIDVIEW8 = "net.ibizsys.model.app.view.IPSAppDEGridView8";
    public static final String INT_PSAPPDEHTMLVIEW = "net.ibizsys.model.app.view.IPSAppDEHtmlView";
    public static final String INT_PSAPPDEINDEXVIEW = "net.ibizsys.model.app.view.IPSAppDEIndexView";
    public static final String INT_PSAPPDELISTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEListExplorerView";
    public static final String INT_PSAPPDELISTVIEW = "net.ibizsys.model.app.view.IPSAppDEListView";
    public static final String INT_PSAPPDELOGIC = "net.ibizsys.model.app.dataentity.IPSAppDELogic";
    public static final String INT_PSAPPDEFLOGIC = "net.ibizsys.model.app.dataentity.IPSAppDEFLogic";
    public static final String INT_PSAPPDELOGICLINK = "net.ibizsys.model.app.dataentity.IPSAppDELogicLink";
    public static final String INT_PSAPPDELOGICLINKCOND = "net.ibizsys.model.app.dataentity.IPSAppDELogicLinkCond";
    public static final String INT_PSAPPDELOGICNODE = "net.ibizsys.model.app.dataentity.IPSAppDELogicNode";
    public static final String INT_PSAPPDELOGICNODEPARAM = "net.ibizsys.model.app.dataentity.IPSAppDELogicNodeParam";
    public static final String INT_PSAPPDELOGICPARAM = "net.ibizsys.model.app.dataentity.IPSAppDELogicParam";
    public static final String INT_PSAPPDEMAPEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMapExplorerView";
    public static final String INT_PSAPPDEMAPVIEW = "net.ibizsys.model.app.view.IPSAppDEMapView";
    public static final String INT_PSAPPDEMETHOD = "net.ibizsys.model.app.dataentity.IPSAppDEMethod";
    public static final String INT_PSAPPDEMETHODLOGIC = "net.ibizsys.model.app.dataentity.IPSAppDEMethodLogic";
    public static final String INT_PSAPPDEMOBCALENDAREXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobCalendarExplorerView";
    public static final String INT_PSAPPDEMOBCALENDARVIEW = "net.ibizsys.model.app.view.IPSAppDEMobCalendarView";
    public static final String INT_PSAPPDEMOBCHARTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobChartExplorerView";
    public static final String INT_PSAPPDEMOBCHARTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobChartView";
    public static final String INT_PSAPPDEMOBDASHBOARDVIEW = "net.ibizsys.model.app.view.IPSAppDEMobDashboardView";
    public static final String INT_PSAPPDEMOBDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEMobDataView";
    public static final String INT_PSAPPDEMOBDATAVIEWEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobDataViewExplorerView";
    public static final String INT_PSAPPDEMOBEDITVIEW = "net.ibizsys.model.app.view.IPSAppDEMobEditView";
    public static final String INT_PSAPPDEMOBGANTTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobGanttExplorerView";
    public static final String INT_PSAPPDEMOBGANTTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobGanttView";
    public static final String INT_PSAPPDEMOBLISTEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobListExplorerView";
    public static final String INT_PSAPPDEMOBLISTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobListView";
    public static final String INT_PSAPPDEMOBMDVIEW = "net.ibizsys.model.app.view.IPSAppDEMobMDView";
    public static final String INT_PSAPPDEMOBMAPEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEMobMapExplorerView";
    public static final String INT_PSAPPDEMOBMAPVIEW = "net.ibizsys.model.app.view.IPSAppDEMobMapView";
    public static final String INT_PSAPPDEMOBPANELVIEW = "net.ibizsys.model.app.view.IPSAppDEMobPanelView";
    public static final String INT_PSAPPDEMOBREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobRedirectView";
    public static final String INT_PSAPPDEMOBVIEW = "net.ibizsys.model.app.view.IPSAppDEMobView";
    public static final String INT_PSAPPDEMOBWFACTIONVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFActionView";
    public static final String INT_PSAPPDEMOBWFDATAREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFDataRedirectView";
    public static final String INT_PSAPPDEMOBWFMDVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFMDView";
    public static final String INT_PSAPPDEMOBWFPROXYRESULTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFProxyResultView";
    public static final String INT_PSAPPDEMOBWFPROXYSTARTVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFProxyStartView";
    public static final String INT_PSAPPDEMOBWFVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWFView";
    public static final String INT_PSAPPDEMOBWIZARDVIEW = "net.ibizsys.model.app.view.IPSAppDEMobWizardView";
    public static final String INT_PSAPPDEMULTIDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEMultiDataView";
    public static final String INT_PSAPPDEPANELVIEW = "net.ibizsys.model.app.view.IPSAppDEPanelView";
    public static final String INT_PSAPPDEPICKUPVIEW = "net.ibizsys.model.app.view.IPSAppDEPickupView";
    public static final String INT_PSAPPDERS = "net.ibizsys.model.app.dataentity.IPSAppDERS";
    public static final String INT_PSAPPDEREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppDERedirectView";
    public static final String INT_PSAPPDESEARCHVIEW = "net.ibizsys.model.app.view.IPSAppDESearchView";
    public static final String INT_PSAPPDESEARCHVIEW2 = "net.ibizsys.model.app.view.IPSAppDESearchView2";
    public static final String INT_PSAPPDESIDEBAREXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDESideBarExplorerView";
    public static final String INT_PSAPPDETABEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDETabExplorerView";
    public static final String INT_PSAPPDETABFORMVIEW = "net.ibizsys.model.app.view.IPSAppDETabFormView";
    public static final String INT_PSAPPDETREEEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDETreeExplorerView";
    public static final String INT_PSAPPDETREEGRIDVIEW = "net.ibizsys.model.app.view.IPSAppDETreeGridView";
    public static final String INT_PSAPPDETREEVIEW = "net.ibizsys.model.app.view.IPSAppDETreeView";
    public static final String INT_PSAPPDEUIACTION = "net.ibizsys.model.app.dataentity.IPSAppDEUIAction";
    public static final String INT_PSAPPDEUIACTIONGROUP = "net.ibizsys.model.app.dataentity.IPSAppDEUIActionGroup";
    public static final String INT_PSAPPDEUIACTIONGROUPDETAIL = "net.ibizsys.model.app.dataentity.IPSAppDEUIActionGroupDetail";
    public static final String INT_PSAPPDEUILOGIC = "net.ibizsys.model.app.dataentity.IPSAppDEUILogic";
    public static final String INT_PSAPPDEUILOGICGROUP = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicGroup";
    public static final String INT_PSAPPDEUILOGICGROUPDETAIL = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicGroupDetail";
    public static final String INT_PSAPPDEUILOGICLINK = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicLink";
    public static final String INT_PSAPPDEUILOGICLINKCOND = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicLinkCond";
    public static final String INT_PSAPPDEUILOGICNODE = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicNode";
    public static final String INT_PSAPPDEUILOGICNODEPARAM = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicNodeParam";
    public static final String INT_PSAPPDEUILOGICPARAM = "net.ibizsys.model.app.dataentity.IPSAppDEUILogicParam";
    public static final String INT_PSAPPDEVIEW = "net.ibizsys.model.app.view.IPSAppDEView";
    public static final String INT_PSAPPDEVIEWBASE = "net.ibizsys.model.app.view.IPSAppDEViewBase";
    public static final String INT_PSAPPDEVIEWLOGIC = "net.ibizsys.model.app.view.IPSAppDEViewLogic";
    public static final String INT_PSAPPDEVIEWLOGIC2 = "net.ibizsys.model.app.view.logic.IPSAppDEViewLogic2";
    public static final String INT_PSAPPDEVIEWPLUGIN = "net.ibizsys.model.app.view.IPSAppDEViewPlugin";
    public static final String INT_PSAPPDEWFACTIONVIEW = "net.ibizsys.model.app.view.IPSAppDEWFActionView";
    public static final String INT_PSAPPDEWFDATAREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppDEWFDataRedirectView";
    public static final String INT_PSAPPDEWFDYNAACTIONVIEW = "net.ibizsys.model.app.view.IPSAppDEWFDynaActionView";
    public static final String INT_PSAPPDEWFDYNAEDITVIEW = "net.ibizsys.model.app.view.IPSAppDEWFDynaEditView";
    public static final String INT_PSAPPDEWFDYNAEXPGRIDVIEW = "net.ibizsys.model.app.view.IPSAppDEWFDynaExpGridView";
    public static final String INT_PSAPPDEWFEDITPROXYDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEWFEditProxyDataView";
    public static final String INT_PSAPPDEWFEDITVIEW = "net.ibizsys.model.app.view.IPSAppDEWFEditView";
    public static final String INT_PSAPPDEWFEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppDEWFExplorerView";
    public static final String INT_PSAPPDEWFGRIDVIEW = "net.ibizsys.model.app.view.IPSAppDEWFGridView";
    public static final String INT_PSAPPDEWFPROXYDATAREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppDEWFProxyDataRedirectView";
    public static final String INT_PSAPPDEWFPROXYDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEWFProxyDataView";
    public static final String INT_PSAPPDEWFPROXYRESULTVIEW = "net.ibizsys.model.app.view.IPSAppDEWFProxyResultView";
    public static final String INT_PSAPPDEWFPROXYSTARTVIEW = "net.ibizsys.model.app.view.IPSAppDEWFProxyStartView";
    public static final String INT_PSAPPDEWFVIEW = "net.ibizsys.model.app.view.IPSAppDEWFView";
    public static final String INT_PSAPPDEWIZARDVIEW = "net.ibizsys.model.app.view.IPSAppDEWizardView";
    public static final String INT_PSAPPDEXDATAVIEW = "net.ibizsys.model.app.view.IPSAppDEXDataView";
    public static final String INT_PSAPPDATAENTITY = "net.ibizsys.model.app.dataentity.IPSAppDataEntity";
    public static final String INT_PSAPPDATAENTITYOBJECT = "net.ibizsys.model.app.dataentity.IPSAppDataEntityObject";
    public static final String INT_PSAPPDATARELATIONVIEW = "net.ibizsys.model.app.view.IPSAppDataRelationView";
    public static final String INT_PSAPPDRAFTSTORAGEUTIL = "net.ibizsys.model.app.util.IPSAppDraftStorageUtil";
    public static final String INT_PSAPPDYNADEVIEW = "net.ibizsys.model.app.view.IPSAppDynaDEView";
    public static final String INT_PSAPPDYNADASHBOARDUTIL = "net.ibizsys.model.app.util.IPSAppDynaDashboardUtil";
    public static final String INT_PSAPPDYNAUTILBASE = "net.ibizsys.model.app.util.IPSAppDynaUtilBase";
    public static final String INT_PSAPPERRORVIEW = "net.ibizsys.model.app.view.IPSAppErrorView";
    public static final String INT_PSAPPEXPLORERVIEW = "net.ibizsys.model.app.view.IPSAppExplorerView";
    public static final String INT_PSAPPFILTERSTORAGEUTIL = "net.ibizsys.model.app.util.IPSAppFilterStorageUtil";
    public static final String INT_PSAPPFUNC = "net.ibizsys.model.app.func.IPSAppFunc";
    public static final String INT_PSAPPFUNCPICKUPVIEW = "net.ibizsys.model.app.view.IPSAppFuncPickupView";
    public static final String INT_PSAPPINDEXVIEW = "net.ibizsys.model.app.view.IPSAppIndexView";
    public static final String INT_PSAPPLAN = "net.ibizsys.model.app.IPSAppLan";
    public static final String INT_PSAPPLOCALDE = "net.ibizsys.model.app.mob.IPSAppLocalDE";
    public static final String INT_PSAPPMENU = "net.ibizsys.model.control.menu.IPSAppMenu";
    public static final String INT_PSAPPMENUITEM = "net.ibizsys.model.control.menu.IPSAppMenuItem";
    public static final String INT_PSAPPMENUMODEL = "net.ibizsys.model.app.appmenu.IPSAppMenuModel";
    public static final String INT_PSAPPMENUPARAM = "net.ibizsys.model.control.menu.IPSAppMenuParam";
    public static final String INT_PSAPPMOBVIEW = "net.ibizsys.model.app.view.IPSAppMobView";
    public static final String INT_PSAPPMODULE = "net.ibizsys.model.app.IPSAppModule";
    public static final String INT_PSAPPPDTVIEW = "net.ibizsys.model.app.IPSAppPDTView";
    public static final String INT_PSAPPPANELVIEW = "net.ibizsys.model.app.view.IPSAppPanelView";
    public static final String INT_PSAPPPKG = "net.ibizsys.model.app.IPSAppPkg";
    public static final String INT_PSAPPPORTALVIEW = "net.ibizsys.model.app.view.IPSAppPortalView";
    public static final String INT_PSAPPPORTLET = "net.ibizsys.model.app.control.IPSAppPortlet";
    public static final String INT_PSAPPPORTLETCAT = "net.ibizsys.model.app.control.IPSAppPortletCat";
    public static final String INT_PSAPPREDIRECTVIEW = "net.ibizsys.model.app.view.IPSAppRedirectView";
    public static final String INT_PSAPPRESOURCE = "net.ibizsys.model.app.IPSAppResource";
    public static final String INT_PSAPPSERVER = "net.ibizsys.model.deploy.IPSAppServer";
    public static final String INT_PSAPPTITLEBAR = "net.ibizsys.model.control.titlebar.IPSAppTitleBar";
    public static final String INT_PSAPPTYPE = "net.ibizsys.model.app.IPSAppType";
    public static final String INT_PSAPPUIACTION = "net.ibizsys.model.app.view.IPSAppUIAction";
    public static final String INT_PSAPPUILOGIC = "net.ibizsys.model.app.logic.IPSAppUILogic";
    public static final String INT_PSAPPUILOGICREFVIEW = "net.ibizsys.model.app.logic.IPSAppUILogicRefView";
    public static final String INT_PSAPPUINEWDATALOGIC = "net.ibizsys.model.app.logic.IPSAppUINewDataLogic";
    public static final String INT_PSAPPUIOPENDATALOGIC = "net.ibizsys.model.app.logic.IPSAppUIOpenDataLogic";
    public static final String INT_PSAPPUISTYLE = "net.ibizsys.model.app.IPSAppUIStyle";
    public static final String INT_PSAPPUITHEME = "net.ibizsys.model.app.theme.IPSAppUITheme";
    public static final String INT_PSAPPUSERMODE = "net.ibizsys.model.app.usermode.IPSAppUserMode";
    public static final String INT_PSAPPUTIL = "net.ibizsys.model.app.util.IPSAppUtil";
    public static final String INT_PSAPPUTILPAGE = "net.ibizsys.model.app.IPSAppUtilPage";
    public static final String INT_PSAPPUTILVIEW = "net.ibizsys.model.app.view.IPSAppUtilView";
    public static final String INT_PSAPPVALUERULE = "net.ibizsys.model.app.valuerule.IPSAppValueRule";
    public static final String INT_PSAPPVIEW = "net.ibizsys.model.app.view.IPSAppView";
    public static final String INT_PSAPPVIEWBASE = "net.ibizsys.model.app.view.IPSAppViewBase";
    public static final String INT_PSAPPVIEWCODE = "net.ibizsys.model.app.pub.IPSAppViewCode";
    public static final String INT_PSAPPVIEWENGINE = "net.ibizsys.model.app.view.IPSAppViewEngine";
    public static final String INT_PSAPPVIEWENGINEPARAM = "net.ibizsys.model.app.view.IPSAppViewEngineParam";
    public static final String INT_PSAPPVIEWLOGIC = "net.ibizsys.model.app.view.IPSAppViewLogic";
    public static final String INT_PSAPPVIEWLOGIC2 = "net.ibizsys.model.app.view.logic.IPSAppViewLogic2";
    public static final String INT_PSAPPVIEWLOGICREFVIEW = "net.ibizsys.model.app.view.logic.IPSAppViewLogicRefView";
    public static final String INT_PSAPPVIEWMSG = "net.ibizsys.model.app.view.IPSAppViewMsg";
    public static final String INT_PSAPPVIEWMSGGROUP = "net.ibizsys.model.app.view.IPSAppViewMsgGroup";
    public static final String INT_PSAPPVIEWMSGGROUPDETAIL = "net.ibizsys.model.app.view.IPSAppViewMsgGroupDetail";
    public static final String INT_PSAPPVIEWNAVCONTEXT = "net.ibizsys.model.app.view.IPSAppViewNavContext";
    public static final String INT_PSAPPVIEWNAVPARAM = "net.ibizsys.model.app.view.IPSAppViewNavParam";
    public static final String INT_PSCONTROLNAVCONTEXT = "net.ibizsys.model.control.IPSControlNavContext";
    public static final String INT_PSCONTROLNAVPARAM = "net.ibizsys.model.control.IPSControlNavParam";
    public static final String INT_PSAPPVIEWNEWDATALOGIC = "net.ibizsys.model.app.view.logic.IPSAppViewNewDataLogic";
    public static final String INT_PSAPPVIEWOPENDATALOGIC = "net.ibizsys.model.app.view.logic.IPSAppViewOpenDataLogic";
    public static final String INT_PSAPPVIEWPARAM = "net.ibizsys.model.app.view.IPSAppViewParam";
    public static final String INT_PSAPPVIEWPLUGIN = "net.ibizsys.model.app.view.IPSAppViewPlugin";
    public static final String INT_PSAPPVIEWQUICKGROUP = "net.ibizsys.model.app.control.IPSAppViewQuickGroup";
    public static final String INT_PSAPPVIEWQUICKGROUPITEM = "net.ibizsys.model.app.control.IPSAppViewQuickGroupItem";
    public static final String INT_PSAPPVIEWREF = "net.ibizsys.model.app.view.IPSAppViewRef";
    public static final String INT_PSAPPVIEWTESTCASE = "net.ibizsys.model.testing.IPSAppViewTestCase";
    public static final String INT_PSAPPVIEWUIACTION = "net.ibizsys.model.app.view.IPSAppViewUIAction";
    public static final String INT_PSAPPWF = "net.ibizsys.model.app.wf.IPSAppWF";
    public static final String INT_PSAPPWFUIACTION = "net.ibizsys.model.app.wf.IPSAppWFUIAction";
    public static final String INT_PSAPPWFUTILUIACTION = "net.ibizsys.model.app.wf.IPSAppWFUtilUIAction";
    public static final String INT_PSAPPWFUIACTIONGROUP = "net.ibizsys.model.app.wf.IPSAppWFUIActionGroup";
    public static final String INT_PSAPPWFUIACTIONGROUPDETAIL = "net.ibizsys.model.app.wf.IPSAppWFUIActionGroupDetail";
    public static final String INT_PSAPPWFVER = "net.ibizsys.model.app.wf.IPSAppWFVer";
    public static final String INT_PSAPPWFDE = "net.ibizsys.model.app.wf.IPSAppWFDE";
    public static final String INT_PSAPPLICATION = "net.ibizsys.model.app.IPSApplication";
    public static final String INT_PSAPPLICATIONOBJECT = "net.ibizsys.model.app.IPSApplicationObject";
    public static final String INT_PSAPPLICATIONUI = "net.ibizsys.model.app.IPSApplicationUI";
    public static final String INT_PSAUTOCOMPLETE = "net.ibizsys.model.control.editor.IPSAutoComplete";
    public static final String INT_PSBDCOLSET = "net.ibizsys.model.ba.IPSBDColSet";
    public static final String INT_PSBDCOLUMN = "net.ibizsys.model.ba.IPSBDColumn";
    public static final String INT_PSBDSCHEME = "net.ibizsys.model.ba.IPSBDScheme";
    public static final String INT_PSBDTABLE = "net.ibizsys.model.ba.IPSBDTable";
    public static final String INT_PSBDTABLEDE = "net.ibizsys.model.ba.IPSBDTableDE";
    public static final String INT_PSBACKSERVICE = "net.ibizsys.model.backservice.IPSBackService";
    public static final String INT_PSBARCODE2DREADER = "net.ibizsys.model.control.editor.IPSBarCode2DReader";
    public static final String INT_PSBARCODEREADER = "net.ibizsys.model.control.editor.IPSBarCodeReader";
    public static final String INT_PSBORDERLAYOUTPOS = "net.ibizsys.model.control.layout.IPSBorderLayoutPos";
    public static final String INT_PSBUTTON = "net.ibizsys.model.control.button.IPSButton";
    public static final String INT_PSBUTTONCONTAINER = "net.ibizsys.model.control.button.IPSButtonContainer";
    public static final String INT_PSBUTTONPARAM = "net.ibizsys.model.control.button.IPSButtonParam";
    public static final String INT_PSCALENDAR = "net.ibizsys.model.control.calendar.IPSCalendar";
    public static final String INT_PSCALENDAREXPBAR = "net.ibizsys.model.control.expbar.IPSCalendarExpBar";
    public static final String INT_PSCALENDAREXPBARPARAM = "net.ibizsys.model.control.expbar.IPSCalendarExpBarParam";
    public static final String INT_PSCALENDARITEM = "net.ibizsys.model.control.calendar.IPSCalendarItem";
    public static final String INT_PSCALENDARITEMDATAITEM = "net.ibizsys.model.control.calendar.IPSCalendarItemDataItem";
    public static final String INT_PSCALENDARPARAM = "net.ibizsys.model.control.calendar.IPSCalendarParam";
    public static final String INT_PSCHART = "net.ibizsys.model.control.chart.IPSChart";
    public static final String INT_PSCHARTANGLEAXIS = "net.ibizsys.model.control.chart.IPSChartAngleAxis";
    public static final String INT_PSCHARTAXES = "net.ibizsys.model.control.chart.IPSChartAxes";
    public static final String INT_PSCHARTAXIS = "net.ibizsys.model.control.chart.IPSChartAxis";
    public static final String INT_PSCHARTCALENDAR = "net.ibizsys.model.control.chart.IPSChartCalendar";
    public static final String INT_PSCHARTCOORDINATESYSTEM = "net.ibizsys.model.control.chart.IPSChartCoordinateSystem";
    public static final String INT_PSCHARTCOORDINATESYSTEMCALENDAR = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemCalendar";
    public static final String INT_PSCHARTCOORDINATESYSTEMCARTESIAN2D = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemCartesian2D";
    public static final String INT_PSCHARTCOORDINATESYSTEMCONTROL = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemControl";
    public static final String INT_PSCHARTCOORDINATESYSTEMGEO = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemGeo";
    public static final String INT_PSCHARTCOORDINATESYSTEMNONE = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemNone";
    public static final String INT_PSCHARTCOORDINATESYSTEMPARALLEL = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemParallel";
    public static final String INT_PSCHARTCOORDINATESYSTEMPOLAR = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemPolar";
    public static final String INT_PSCHARTCOORDINATESYSTEMRADAR = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemRadar";
    public static final String INT_PSCHARTCOORDINATESYSTEMSINGLE = "net.ibizsys.model.control.chart.IPSChartCoordinateSystemSingle";
    public static final String INT_PSCHARTDATAITEM = "net.ibizsys.model.control.chart.IPSChartDataItem";
    public static final String INT_PSCHARTDATASET = "net.ibizsys.model.control.chart.IPSChartDataSet";
    public static final String INT_PSCHARTDATASETFIELD = "net.ibizsys.model.control.chart.IPSChartDataSetField";
    public static final String INT_PSCHARTDATASETGROUP = "net.ibizsys.model.control.chart.IPSChartDataSetGroup";
    public static final String INT_PSCHARTEXPBAR = "net.ibizsys.model.control.expbar.IPSChartExpBar";
    public static final String INT_PSCHARTEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSChartExpBarParam";
    public static final String INT_PSCHARTGEO = "net.ibizsys.model.control.chart.IPSChartGeo";
    public static final String INT_PSCHARTGRAPHIC = "net.ibizsys.model.control.chart.IPSChartGraphic";
    public static final String INT_PSCHARTGRID = "net.ibizsys.model.control.chart.IPSChartGrid";
    public static final String INT_PSCHARTGRIDAXIS = "net.ibizsys.model.control.chart.IPSChartGridAxis";
    public static final String INT_PSCHARTGRIDXAXIS = "net.ibizsys.model.control.chart.IPSChartGridXAxis";
    public static final String INT_PSCHARTGRIDYAXIS = "net.ibizsys.model.control.chart.IPSChartGridYAxis";
    public static final String INT_PSCHARTLEGEND = "net.ibizsys.model.control.chart.IPSChartLegend";
    public static final String INT_PSCHARTOBJECT = "net.ibizsys.model.control.chart.IPSChartObject";
    public static final String INT_PSCHARTPARALLEL = "net.ibizsys.model.control.chart.IPSChartParallel";
    public static final String INT_PSCHARTPARALLELAXIS = "net.ibizsys.model.control.chart.IPSChartParallelAxis";
    public static final String INT_PSCHARTPOLAR = "net.ibizsys.model.control.chart.IPSChartPolar";
    public static final String INT_PSCHARTPOLARANGLEAXIS = "net.ibizsys.model.control.chart.IPSChartPolarAngleAxis";
    public static final String INT_PSCHARTPOLARAXIS = "net.ibizsys.model.control.chart.IPSChartPolarAxis";
    public static final String INT_PSCHARTPOLARRADIUSAXIS = "net.ibizsys.model.control.chart.IPSChartPolarRadiusAxis";
    public static final String INT_PSCHARTPOSITION = "net.ibizsys.model.control.chart.IPSChartPosition";
    public static final String INT_PSCHARTRADAR = "net.ibizsys.model.control.chart.IPSChartRadar";
    public static final String INT_PSCHARTRADIUSAXIS = "net.ibizsys.model.control.chart.IPSChartRadiusAxis";
    public static final String INT_PSCHARTSERIES = "net.ibizsys.model.control.chart.IPSChartSeries";
    public static final String INT_PSCHARTSERIESBAR = "net.ibizsys.model.control.chart.IPSChartSeriesBar";
    public static final String INT_PSCHARTSERIESBARSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesBarSupportable";
    public static final String INT_PSCHARTSERIESBOXPLOT = "net.ibizsys.model.control.chart.IPSChartSeriesBoxplot";
    public static final String INT_PSCHARTSERIESBOXPLOTSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesBoxplotSupportable";
    public static final String INT_PSCHARTSERIESCSCARTESIAN2DENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesCSCartesian2DEncode";
    public static final String INT_PSCHARTSERIESCSGEOENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesCSGeoEncode";
    public static final String INT_PSCHARTSERIESCSNONE = "net.ibizsys.model.control.chart.IPSChartSeriesCSNone";
    public static final String INT_PSCHARTSERIESCSNONEENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesCSNoneEncode";
    public static final String INT_PSCHARTSERIESCSPOLARENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesCSPolarEncode";
    public static final String INT_PSCHARTSERIESCSSINGLEENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesCSSingleEncode";
    public static final String INT_PSCHARTSERIESCANDLESTICK = "net.ibizsys.model.control.chart.IPSChartSeriesCandlestick";
    public static final String INT_PSCHARTSERIESCANDLESTICKSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesCandlestickSupportable";
    public static final String INT_PSCHARTSERIESCUSTOM = "net.ibizsys.model.control.chart.IPSChartSeriesCustom";
    public static final String INT_PSCHARTSERIESENCODE = "net.ibizsys.model.control.chart.IPSChartSeriesEncode";
    public static final String INT_PSCHARTSERIESFUNNEL = "net.ibizsys.model.control.chart.IPSChartSeriesFunnel";
    public static final String INT_PSCHARTSERIESGAUGE = "net.ibizsys.model.control.chart.IPSChartSeriesGauge";
    public static final String INT_PSCHARTSERIESGRAPH = "net.ibizsys.model.control.chart.IPSChartSeriesGraph";
    public static final String INT_PSCHARTSERIESGRAPHSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesGraphSupportable";
    public static final String INT_PSCHARTSERIESHEATMAP = "net.ibizsys.model.control.chart.IPSChartSeriesHeatmap";
    public static final String INT_PSCHARTSERIESHEATMAPSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesHeatmapSupportable";
    public static final String INT_PSCHARTSERIESLINE = "net.ibizsys.model.control.chart.IPSChartSeriesLine";
    public static final String INT_PSCHARTSERIESLINESUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesLineSupportable";
    public static final String INT_PSCHARTSERIESLINES = "net.ibizsys.model.control.chart.IPSChartSeriesLines";
    public static final String INT_PSCHARTSERIESLINESSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesLinesSupportable";
    public static final String INT_PSCHARTSERIESMAP = "net.ibizsys.model.control.chart.IPSChartSeriesMap";
    public static final String INT_PSCHARTSERIESPARALLEL = "net.ibizsys.model.control.chart.IPSChartSeriesParallel";
    public static final String INT_PSCHARTSERIESPARALLELSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesParallelSupportable";
    public static final String INT_PSCHARTSERIESPICTORIALBAR = "net.ibizsys.model.control.chart.IPSChartSeriesPictorialBar";
    public static final String INT_PSCHARTSERIESPICTORIALBARSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesPictorialBarSupportable";
    public static final String INT_PSCHARTSERIESPIE = "net.ibizsys.model.control.chart.IPSChartSeriesPie";
    public static final String INT_PSCHARTSERIESPIESUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesPieSupportable";
    public static final String INT_PSCHARTSERIESRADAR = "net.ibizsys.model.control.chart.IPSChartSeriesRadar";
    public static final String INT_PSCHARTSERIESRADARSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesRadarSupportable";
    public static final String INT_PSCHARTSERIESSANKEY = "net.ibizsys.model.control.chart.IPSChartSeriesSankey";
    public static final String INT_PSCHARTSERIESSCATTER = "net.ibizsys.model.control.chart.IPSChartSeriesScatter";
    public static final String INT_PSCHARTSERIESSCATTERSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesScatterSupportable";
    public static final String INT_PSCHARTSERIESSUNBURST = "net.ibizsys.model.control.chart.IPSChartSeriesSunburst";
    public static final String INT_PSCHARTSERIESTHEMERIVER = "net.ibizsys.model.control.chart.IPSChartSeriesThemeRiver";
    public static final String INT_PSCHARTSERIESTHEMERIVERSUPPORTABLE = "net.ibizsys.model.control.chart.IPSChartSeriesThemeRiverSupportable";
    public static final String INT_PSCHARTSERIESTREE = "net.ibizsys.model.control.chart.IPSChartSeriesTree";
    public static final String INT_PSCHARTSERIESTREEMAP = "net.ibizsys.model.control.chart.IPSChartSeriesTreemap";
    public static final String INT_PSCHARTSINGLE = "net.ibizsys.model.control.chart.IPSChartSingle";
    public static final String INT_PSCHARTSINGLEAXIS = "net.ibizsys.model.control.chart.IPSChartSingleAxis";
    public static final String INT_PSCHARTTIMELINE = "net.ibizsys.model.control.chart.IPSChartTimeline";
    public static final String INT_PSCHARTTITLE = "net.ibizsys.model.control.chart.IPSChartTitle";
    public static final String INT_PSCHARTVISUALMAP = "net.ibizsys.model.control.chart.IPSChartVisualMap";
    public static final String INT_PSCHARTXAXIS = "net.ibizsys.model.control.chart.IPSChartXAxis";
    public static final String INT_PSCHARTYAXIS = "net.ibizsys.model.control.chart.IPSChartYAxis";
    public static final String INT_PSCHECKBOX = "net.ibizsys.model.control.editor.IPSCheckBox";
    public static final String INT_PSCHECKBOXGROUP = "net.ibizsys.model.control.button.IPSCheckBoxGroup";
    public static final String INT_PSCHECKBOXLIST = "net.ibizsys.model.control.editor.IPSCheckBoxList";
    public static final String INT_PSCHECKBUTTON = "net.ibizsys.model.control.button.IPSCheckButton";
    public static final String INT_PSCHECKBUTTONGROUP = "net.ibizsys.model.control.button.IPSCheckButtonGroup";
    public static final String INT_PSCODEITEM = "net.ibizsys.model.codelist.IPSCodeItem";
    public static final String INT_PSCODELIST = "net.ibizsys.model.codelist.IPSCodeList";
    public static final String INT_PSCODELISTEDITOR = "net.ibizsys.model.control.editor.IPSCodeListEditor";
    public static final String INT_PSCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSCodePublisherContext";
    public static final String INT_PSCONTEXTMENU = "net.ibizsys.model.control.menu.IPSContextMenu";
    public static final String INT_PSCONTEXTMENUPARAM = "net.ibizsys.model.control.menu.IPSContextMenuParam";
    public static final String INT_PSCONTROL = "net.ibizsys.model.control.IPSControl";
    public static final String INT_PSCONTROLACTION = "net.ibizsys.model.control.IPSControlAction";
    public static final String INT_PSCONTROLCONTAINER = "net.ibizsys.model.control.IPSControlContainer";
    public static final String INT_PSCONTROLHANDLER = "net.ibizsys.model.control.IPSControlHandler";
    public static final String INT_PSCONTROLHANDLERACTION = "net.ibizsys.model.control.IPSControlHandlerAction";
    public static final String INT_PSCONTROLITEM = "net.ibizsys.model.control.IPSControlItem";
    public static final String INT_PSCONTROLLOGIC = "net.ibizsys.model.control.IPSControlLogic";
    public static final String INT_PSAPPLICATIONLOGIC = "net.ibizsys.model.app.IPSApplicationLogic";
    public static final String INT_PSCONTROLMDOBJECT = "net.ibizsys.model.control.IPSControlMDObject";
    public static final String INT_PSCONTROLMDATACONTAINER = "net.ibizsys.model.control.IPSControlMDataContainer";
    public static final String INT_PSCONTROLNAVIGATABLE = "net.ibizsys.model.control.IPSControlNavigatable";
    public static final String INT_PSCONTROLOBJECT = "net.ibizsys.model.control.IPSControlObject";
    public static final String INT_PSCONTROLOBJECTNAVIGATABLE = "net.ibizsys.model.control.IPSControlObjectNavigatable";
    public static final String INT_PSCONTROLPARAM = "net.ibizsys.model.control.IPSControlParam";
    public static final String INT_PSCONTROLTYPE = "net.ibizsys.model.control.IPSControlType";
    public static final String INT_PSCONTROLXDATACONTAINER = "net.ibizsys.model.control.IPSControlXDataContainer";
    public static final String INT_PSCOUNTER = "net.ibizsys.model.control.counter.IPSCounter";
    public static final String INT_PSCOUNTERTYPE = "net.ibizsys.model.control.counter.IPSCounterType";
    public static final String INT_PSCTRLMSG = "net.ibizsys.model.res.IPSCtrlMsg";
    public static final String INT_PSCTRLMSGITEM = "net.ibizsys.model.res.IPSCtrlMsgItem";
    public static final String INT_PSCUSTOMCONTROL = "net.ibizsys.model.control.custom.IPSCustomControl";
    public static final String INT_PSCUSTOMCONTROLHANDLER = "net.ibizsys.model.control.custom.IPSCustomControlHandler";
    public static final String INT_PSCUSTOMCONTROLPARAM = "net.ibizsys.model.control.custom.IPSCustomControlParam";
    public static final String INT_PSDBAPPMENUPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPart";
    public static final String INT_PSDBAPPMENUPORTLETPARTPARAM = "net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPartParam";
    public static final String INT_PSDBAPPVIEWPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBAppViewPortletPart";
    public static final String INT_PSDBAPPVIEWPORTLETPARTPARAM = "net.ibizsys.model.control.dashboard.IPSDBAppViewPortletPartParam";
    public static final String INT_PSDBCHARTPARTPORTLET = "net.ibizsys.model.control.dashboard.IPSDBChartPartPortlet";
    public static final String INT_PSDBCHARTPORTLET = "net.ibizsys.model.control.dashboard.IPSDBChartPortlet";
    public static final String INT_PSDBCONTAINERPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBContainerPortletPart";
    public static final String INT_PSDBCONTAINERPORTLETPARTPARAM = "net.ibizsys.model.control.dashboard.IPSDBContainerPortletPartParam";
    public static final String INT_PSDBCUSTOMPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBCustomPortletPart";
    public static final String INT_PSDBDEVINST = "net.ibizsys.model.deploy.IPSDBDevInst";
    public static final String INT_PSDBEDITFORMPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBEditFormPortletPart";
    public static final String INT_PSDBHTMLPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBHtmlPortletPart";
    public static final String INT_PSDBLISTPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBListPortletPart";
    public static final String INT_PSDBMENUPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBMenuPortletPart";
    public static final String INT_PSDBPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBPortletPart";
    public static final String INT_PSDBPORTLETPARTPARAM = "net.ibizsys.model.control.dashboard.IPSDBPortletPartParam";
    public static final String INT_PSDBSEARCHFORMPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBSearchFormPortletPart";
    public static final String INT_PSDBSYSPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBSysPortletPart";
    public static final String INT_PSDBSYSPORTLETPARTPARAM = "net.ibizsys.model.control.dashboard.IPSDBSysPortletPartParam";
    public static final String INT_PSDBVALUEFUNC = "net.ibizsys.model.database.IPSDBValueFunc";
    public static final String INT_PSDBVALUEOP = "net.ibizsys.model.database.IPSDBValueOP";
    public static final String INT_PSDBVIEWPORTLETPART = "net.ibizsys.model.control.dashboard.IPSDBViewPortletPart";
    public static final String INT_PSDCCODESNIPPET = "net.ibizsys.model.codesnippet.IPSDCCodeSnippet";
    public static final String INT_PSDCCODESNIPPETREF = "net.ibizsys.model.codesnippet.IPSDCCodeSnippetRef";
    public static final String INT_PSDCMSPDEPLOYITEM = "net.ibizsys.model.deploy.IPSDCMSPDeployItem";
    public static final String INT_PSDCMSPLATFORM = "net.ibizsys.model.deploy.IPSDCMSPlatform";
    public static final String INT_PSDCMSPLATFORMFUNC = "net.ibizsys.model.deploy.IPSDCMSPlatformFunc";
    public static final String INT_PSDCMSPLATFORMNODE = "net.ibizsys.model.deploy.IPSDCMSPlatformNode";
    public static final String INT_PSDEACMODE = "net.ibizsys.model.dataentity.ac.IPSDEACMode";
    public static final String INT_PSDEACMODEDATAITEM = "net.ibizsys.model.dataentity.ac.IPSDEACModeDataItem";
    public static final String INT_PSDEACTION = "net.ibizsys.model.dataentity.action.IPSDEAction";
    public static final String INT_PSDEACTIONVR = "net.ibizsys.model.dataentity.action.IPSDEActionVR";
    public static final String INT_PSDEACTIONGROUP = "net.ibizsys.model.dataentity.action.IPSDEActionGroup";
    public static final String INT_PSDEACTIONGROUPDETAIL = "net.ibizsys.model.dataentity.action.IPSDEActionGroupDetail";
    public static final String INT_PSDEACTIONLOGIC = "net.ibizsys.model.dataentity.action.IPSDEActionLogic";
    public static final String INT_PSDEACTIONPARAM = "net.ibizsys.model.dataentity.action.IPSDEActionParam";
    public static final String INT_PSDEACTIONINPUT = "net.ibizsys.model.dataentity.action.IPSDEActionInput";
    public static final String INT_PSDEACTIONRETURN = "net.ibizsys.model.dataentity.action.IPSDEActionReturn";
    public static final String INT_PSDEDATASETINPUT = "net.ibizsys.model.dataentity.ds.IPSDEDataSetInput";
    public static final String INT_PSDEDATASETRETURN = "net.ibizsys.model.dataentity.ds.IPSDEDataSetReturn";
    public static final String INT_PSDEDATAQUERYINPUT = "net.ibizsys.model.dataentity.ds.IPSDEDataSetInput";
    public static final String INT_PSDEDATAQUERYRETURN = "net.ibizsys.model.dataentity.ds.IPSDEDataSetReturn";
    public static final String INT_PSDESERVICEAPIMETHODINPUT = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIMethodInput";
    public static final String INT_PSDESERVICEAPIMETHODRETURN = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIMethodReturn";
    public static final String INT_PSDESERVICEAPIDTO = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIDTO";
    public static final String INT_PSDESERVICEAPIDTOFIELD = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIDTOField";
    public static final String INT_PSSUBSYSSERVICEAPIMETHODINPUT = "net.ibizsys.model.service.IPSSubSysServiceAPIMethodInput";
    public static final String INT_PSSUBSYSSERVICEAPIMETHODRETURN = "net.ibizsys.model.service.IPSSubSysServiceAPIMethodReturn";
    public static final String INT_PSSUBSYSSERVICEAPIDTO = "net.ibizsys.model.service.IPSSubSysServiceAPIDTO";
    public static final String INT_PSSUBSYSSERVICEAPIDTOFIELD = "net.ibizsys.model.service.IPSSubSysServiceAPIDTOField";
    public static final String INT_PSDEACTIONRESTFULAPI = "net.ibizsys.model.service.IPSDEActionRESTfulAPI";
    public static final String INT_PSDEACTIONTEMPL = "net.ibizsys.model.dataentity.action.IPSDEActionTempl";
    public static final String INT_PSDEACTIONTESTCASE = "net.ibizsys.model.testing.IPSDEActionTestCase";
    public static final String INT_PSDEACTIONWIZARD = "net.ibizsys.model.dataentity.wizard.IPSDEActionWizard";
    public static final String INT_PSDEACTIONWIZARDGROUP = "net.ibizsys.model.dataentity.wizard.IPSDEActionWizardGroup";
    public static final String INT_PSDEACTIONWIZARDGROUPDETAIL = "net.ibizsys.model.dataentity.wizard.IPSDEActionWizardGroupDetail";
    public static final String INT_PSDEACTIONWIZARDITEM = "net.ibizsys.model.dataentity.wizard.IPSDEActionWizardItem";
    public static final String INT_PSDEBDTABLE = "net.ibizsys.model.dataentity.ba.IPSDEBDTable";
    public static final String INT_PSDECMGROUPITEM = "net.ibizsys.model.control.toolbar.IPSDECMGroupItem";
    public static final String INT_PSDECMRAWITEM = "net.ibizsys.model.control.toolbar.IPSDECMRawItem";
    public static final String INT_PSDECMSEPERATORITEM = "net.ibizsys.model.control.toolbar.IPSDECMSeperatorItem";
    public static final String INT_PSDECMUIACTIONITEM = "net.ibizsys.model.control.toolbar.IPSDECMUIActionItem";
    public static final String INT_PSDECALENDAR = "net.ibizsys.model.control.calendar.IPSDECalendar";
    public static final String INT_PSDECALENDARITEM = "net.ibizsys.model.control.calendar.IPSDECalendarItem";
    public static final String INT_PSDECHART = "net.ibizsys.model.control.chart.IPSDEChart";
    public static final String INT_PSDECHARTAXES = "net.ibizsys.model.control.chart.IPSDEChartAxes";
    public static final String INT_PSDECHARTCALENDAR = "net.ibizsys.model.control.chart.IPSDEChartCalendar";
    public static final String INT_PSDECHARTCOORDINATESYSTEM = "net.ibizsys.model.control.chart.IPSDEChartCoordinateSystem";
    public static final String INT_PSDECHARTDATASET = "net.ibizsys.model.control.chart.IPSDEChartDataSet";
    public static final String INT_PSDECHARTDATASETFIELD = "net.ibizsys.model.control.chart.IPSDEChartDataSetField";
    public static final String INT_PSDECHARTDATASETGROUP = "net.ibizsys.model.control.chart.IPSDEChartDataSetGroup";
    public static final String INT_PSDECHARTGEO = "net.ibizsys.model.control.chart.IPSDEChartGeo";
    public static final String INT_PSDECHARTGRID = "net.ibizsys.model.control.chart.IPSDEChartGrid";
    public static final String INT_PSDECHARTHANDLER = "net.ibizsys.model.control.chart.IPSDEChartHandler";
    public static final String INT_PSDECHARTLEGEND = "net.ibizsys.model.control.chart.IPSDEChartLegend";
    public static final String INT_PSDECHARTDATAGRID = "net.ibizsys.model.control.chart.IPSDEChartDataGrid";
    public static final String INT_PSDECHARTOBJECT = "net.ibizsys.model.control.chart.IPSDEChartObject";
    public static final String INT_PSDECHARTPARALLEL = "net.ibizsys.model.control.chart.IPSDEChartParallel";
    public static final String INT_PSDECHARTPARAM = "net.ibizsys.model.control.chart.IPSDEChartParam";
    public static final String INT_PSDECHARTPOLAR = "net.ibizsys.model.control.chart.IPSDEChartPolar";
    public static final String INT_PSDECHARTRADAR = "net.ibizsys.model.control.chart.IPSDEChartRadar";
    public static final String INT_PSDECHARTSERIES = "net.ibizsys.model.control.chart.IPSDEChartSeries";
    public static final String INT_PSDECHARTSERIESENCODE = "net.ibizsys.model.control.chart.IPSDEChartSeriesEncode";
    public static final String INT_PSDECHARTSINGLE = "net.ibizsys.model.control.chart.IPSDEChartSingle";
    public static final String INT_PSDECHARTTITLE = "net.ibizsys.model.control.chart.IPSDEChartTitle";
    public static final String INT_PSDECHARTVISUALMAP = "net.ibizsys.model.control.chart.IPSDEChartVisualMap";
    public static final String INT_PSDECHARTXAXIS = "net.ibizsys.model.control.chart.IPSDEChartXAxis";
    public static final String INT_PSDECONTEXTMENU = "net.ibizsys.model.control.toolbar.IPSDEContextMenu";
    public static final String INT_PSDECONTEXTMENUITEM = "net.ibizsys.model.control.toolbar.IPSDEContextMenuItem";
    public static final String INT_PSDECONTEXTMENUPARAM = "net.ibizsys.model.control.toolbar.IPSDEContextMenuParam";
    public static final String INT_PSDEDBCONFIG = "net.ibizsys.model.database.IPSDEDBConfig";
    public static final String INT_PSDEDBINDEX = "net.ibizsys.model.database.IPSDEDBIndex";
    public static final String INT_PSDEDBINDEXFIELD = "net.ibizsys.model.database.IPSDEDBIndexField";
    public static final String INT_PSDEDBTABLE = "net.ibizsys.model.database.IPSDEDBTable";
    public static final String INT_PSDEDQCOLUMN = "net.ibizsys.model.dataentity.ds.IPSDEDQColumn";
    public static final String INT_PSDEDQCONDITION = "net.ibizsys.model.dataentity.ds.IPSDEDQCondition";
    public static final String INT_PSDEDQCUSTOMCONDITION = "net.ibizsys.model.dataentity.ds.IPSDEDQCustomCondition";
    public static final String INT_PSDEDQFIELDCONDITION = "net.ibizsys.model.dataentity.ds.IPSDEDQFieldCondition";
    public static final String INT_PSDEDQGROUPCONDITION = "net.ibizsys.model.dataentity.ds.IPSDEDQGroupCondition";
    public static final String INT_PSDEDQJOIN = "net.ibizsys.model.dataentity.ds.IPSDEDQJoin";
    public static final String INT_PSDEDQMAIN = "net.ibizsys.model.dataentity.ds.IPSDEDQMain";
    public static final String INT_PSDEDQPDCONDITION = "net.ibizsys.model.dataentity.ds.IPSDEDQPDCondition";
    public static final String INT_PSDEDRBAR = "net.ibizsys.model.control.drctrl.IPSDEDRBar";
    public static final String INT_PSDEDRBARGROUP = "net.ibizsys.model.control.drctrl.IPSDEDRBarGroup";
    public static final String INT_PSDEDRBARITEM = "net.ibizsys.model.control.drctrl.IPSDEDRBarItem";
    public static final String INT_PSDEDRBARPARAM = "net.ibizsys.model.control.drctrl.IPSDEDRBarParam";
    public static final String INT_PSDEDRCOUNTER = "net.ibizsys.model.control.counter.IPSDEDRCounter";
    public static final String INT_PSDEDRCTRL = "net.ibizsys.model.control.drctrl.IPSDEDRCtrl";
    public static final String INT_PSDEDRCTRLITEM = "net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem";
    public static final String INT_PSDEDRCTRLPARAM = "net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam";
    public static final String INT_PSDEDRCUSTOMITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRCustomItem";
    public static final String INT_PSDEDRDER11ITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRDER11Item";
    public static final String INT_PSDEDRDER1NITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRDER1NItem";
    public static final String INT_PSDEDRDETAIL = "net.ibizsys.model.dataentity.dr.IPSDEDRDetail";
    public static final String INT_PSDEDRGROUP = "net.ibizsys.model.dataentity.dr.IPSDEDRGroup";
    public static final String INT_PSDEDRITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRItem";
    public static final String INT_PSDEDRSYSDER11ITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRSysDER11Item";
    public static final String INT_PSDEDRSYSDER1NITEM = "net.ibizsys.model.dataentity.dr.IPSDEDRSysDER1NItem";
    public static final String INT_PSDEDRTAB = "net.ibizsys.model.control.drctrl.IPSDEDRTab";
    public static final String INT_PSDEDRTABPAGE = "net.ibizsys.model.control.drctrl.IPSDEDRTabPage";
    public static final String INT_PSDEDRTABPARAM = "net.ibizsys.model.control.drctrl.IPSDEDRTabParam";
    public static final String INT_PSDEDTSQUEUE = "net.ibizsys.model.dataentity.dts.IPSDEDTSQueue";
    public static final String INT_PSDEDASHBOARD = "net.ibizsys.model.control.dashboard.IPSDEDashboard";
    public static final String INT_PSDEDATAAUDITUTIL = "net.ibizsys.model.dataentity.util.IPSDEDataAuditUtil";
    public static final String INT_PSDEDATAEXPORT = "net.ibizsys.model.dataentity.dataexport.IPSDEDataExport";
    public static final String INT_PSDEDATAEXPORTITEM = "net.ibizsys.model.dataentity.dataexport.IPSDEDataExportItem";
    public static final String INT_PSDEDATAEXPORTGROUP = "net.ibizsys.model.dataentity.dataexport.IPSDEDataExportGroup";
    public static final String INT_PSDEDATAIMPORT = "net.ibizsys.model.dataentity.dataimport.IPSDEDataImport";
    public static final String INT_PSDEDATAIMPORTITEM = "net.ibizsys.model.dataentity.dataimport.IPSDEDataImportItem";
    public static final String INT_PSDENOTIFY = "net.ibizsys.model.dataentity.notify.IPSDENotify";
    public static final String INT_PSDENOTIFYTARGET = "net.ibizsys.model.dataentity.notify.IPSDENotifyTarget";
    public static final String INT_PSDEDATAQUERY = "net.ibizsys.model.dataentity.ds.IPSDEDataQuery";
    public static final String INT_PSDEDATAQUERYCODE = "net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode";
    public static final String INT_PSDEDATAQUERYCODECOND = "net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond";
    public static final String INT_PSDEDATAQUERYCODEEXP = "net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp";
    public static final String INT_PSDEDATARELATION = "net.ibizsys.model.dataentity.dr.IPSDEDataRelation";
    public static final String INT_PSDEDATASET = "net.ibizsys.model.dataentity.ds.IPSDEDataSet";
    public static final String INT_PSDEDATASETCODE = "net.ibizsys.model.dataentity.ds.IPSDEDataSetCode";
    public static final String INT_PSDEDATASETDEAW = "net.ibizsys.model.dataentity.wizard.IPSDEDataSetDEAW";
    public static final String INT_PSDEDATASETGROUPPARAM = "net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam";
    public static final String INT_PSDEDATASETVIEWMSG = "net.ibizsys.model.view.IPSDEDataSetViewMsg";
    public static final String INT_PSDEDATASYNC = "net.ibizsys.model.dataentity.datasync.IPSDEDataSync";
    public static final String INT_PSDEDATAVIEW = "net.ibizsys.model.control.dataview.IPSDEDataView";
    public static final String INT_PSDEDATAVIEWDATAITEM = "net.ibizsys.model.control.dataview.IPSDEDataViewDataItem";
    public static final String INT_PSDEDATAVIEWHANDLER = "net.ibizsys.model.control.dataview.IPSDEDataViewHandler";
    public static final String INT_PSDEDATAVIEWITEM = "net.ibizsys.model.control.dataview.IPSDEDataViewItem";
    public static final String INT_PSDEDATAVIEWPARAM = "net.ibizsys.model.control.dataview.IPSDEDataViewParam";
    public static final String INT_PSDEEDITFORM = "net.ibizsys.model.control.form.IPSDEEditForm";
    public static final String INT_PSDEEDITFORMHANDLER = "net.ibizsys.model.control.form.IPSDEEditFormHandler";
    public static final String INT_PSDEEDITFORMITEM = "net.ibizsys.model.control.form.IPSDEEditFormItem";
    public static final String INT_PSDEEDITFORMPARAM = "net.ibizsys.model.control.form.IPSDEEditFormParam";
    public static final String INT_PSDEFDCATGROUPLOGIC = "net.ibizsys.model.control.form.IPSDEFDCatGroupLogic";
    public static final String INT_PSDEFDCUSTOMLOGIC = "net.ibizsys.model.control.form.IPSDEFDCustomLogic";
    public static final String INT_PSDEFDGROUPLOGIC = "net.ibizsys.model.control.form.IPSDEFDGroupLogic";
    public static final String INT_PSDEFDLOGIC = "net.ibizsys.model.control.form.IPSDEFDLogic";
    public static final String INT_PSDEFDSINGLELOGIC = "net.ibizsys.model.control.form.IPSDEFDSingleLogic";
    public static final String INT_PSDEFDTCOLUMN = "net.ibizsys.model.database.IPSDEFDTColumn";
    public static final String INT_PSDEFDATARANGERULE = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFDataRangeRule";
    public static final String INT_PSDEFFORMITEM = "net.ibizsys.model.control.form.IPSDEFFormItem";
    public static final String INT_PSDEFGRIDCOLUMN = "net.ibizsys.model.control.grid.IPSDEFGridColumn";
    public static final String INT_PSDEFGROUP = "net.ibizsys.model.dataentity.defield.IPSDEFGroup";
    public static final String INT_PSDEFGROUPDETAIL = "net.ibizsys.model.dataentity.defield.IPSDEFGroupDetail";
    public static final String INT_PSDEDOMAIN = "net.ibizsys.model.dataentity.defield.IPSDEDomain";
    public static final String INT_PSDEDOMAINFIELD = "net.ibizsys.model.dataentity.defield.IPSDEDomainField";
    public static final String INT_PSDEMETHODDTO = "net.ibizsys.model.dataentity.service.IPSDEMethodDTO";
    public static final String INT_PSDEMETHODDTOFIELD = "net.ibizsys.model.dataentity.service.IPSDEMethodDTOField";
    public static final String INT_PSAPPDEMETHODDTO = "net.ibizsys.model.app.dataentity.IPSAppDEMethodDTO";
    public static final String INT_PSAPPDEMETHODDTOFIELD = "net.ibizsys.model.app.dataentity.IPSAppDEMethodDTOField";
    public static final String INT_PSAPPDEMETHODINPUT = "net.ibizsys.model.app.dataentity.IPSAppDEMethodInput";
    public static final String INT_PSAPPDEMETHODRETURN = "net.ibizsys.model.app.dataentity.IPSAppDEMethodReturn";
    public static final String INT_PSDEFILTER = "net.ibizsys.model.dataentity.defield.IPSDEFilter";
    public static final String INT_PSDEFILTERFIELD = "net.ibizsys.model.dataentity.defield.IPSDEFilterField";
    public static final String INT_PSDEFIUPDATEDETAIL = "net.ibizsys.model.control.form.IPSDEFIUpdateDetail";
    public static final String INT_PSDEFINPUTTIP = "net.ibizsys.model.dataentity.defield.IPSDEFInputTip";
    public static final String INT_PSDEFINPUTTIPSET = "net.ibizsys.model.res.IPSDEFInputTipSet";
    public static final String INT_PSDEFSEARCH = "net.ibizsys.model.dataentity.defield.search.IPSDEFSearch";
    public static final String INT_PSDEFSEARCHFORMITEM = "net.ibizsys.model.control.form.IPSDEFSearchFormItem";
    public static final String INT_PSDEFSEARCHMODE = "net.ibizsys.model.dataentity.defield.IPSDEFSearchMode";
    public static final String INT_PSDEFUIITEM = "net.ibizsys.model.dataentity.defield.IPSDEFUIItem";
    public static final String INT_PSDEFUIMODE = "net.ibizsys.model.dataentity.defield.IPSDEFUIMode";
    public static final String INT_PSAPPDEFUIMODE = "net.ibizsys.model.app.dataentity.IPSAppDEFUIMode";
    public static final String INT_PSDEFVRCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRCondition";
    public static final String INT_PSDEFVRGROUPCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRGroupCondition";
    public static final String INT_PSDEFVRQUERYCOUNTCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRQueryCountCondition";
    public static final String INT_PSDEFVRREGEXCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRRegExCondition";
    public static final String INT_PSDEFVRSIMPLECONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRSimpleCondition";
    public static final String INT_PSDEFVRSINGLECONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRSingleCondition";
    public static final String INT_PSDEFVRSTRINGLENGTHCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRStringLengthCondition";
    public static final String INT_PSDEFVRSYSVALUERULECONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRSysValueRuleCondition";
    public static final String INT_PSDEFVRTESTCASE = "net.ibizsys.model.testing.IPSDEFVRTestCase";
    public static final String INT_PSDEFVRVALUERANGE2CONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRValueRange2Condition";
    public static final String INT_PSDEFVRVALUERANGE3CONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRValueRange3Condition";
    public static final String INT_PSDEFVRVALUERANGECONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRValueRangeCondition";
    public static final String INT_PSDEFVRVALUERECURSIONCONDITION = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFVRValueRecursionCondition";
    public static final String INT_PSDEFVALUERULE = "net.ibizsys.model.dataentity.defield.valuerule.IPSDEFValueRule";
    public static final String INT_PSDEFIELD = "net.ibizsys.model.dataentity.defield.IPSDEField";
    public static final String INT_PSDEFIELDOBJECT = "net.ibizsys.model.dataentity.defield.IPSDEFieldObject";
    public static final String INT_PSDEFIELDTYPE = "net.ibizsys.model.dataentity.defield.IPSDEFieldType";
    public static final String INT_PSDEFORM = "net.ibizsys.model.control.form.IPSDEForm";
    public static final String INT_PSDEFORMBUTTON = "net.ibizsys.model.control.form.IPSDEFormButton";
    public static final String INT_PSDEFORMBUTTONLIST = "net.ibizsys.model.control.form.IPSDEFormButtonList";
    public static final String INT_PSDEFORMDRUIPART = "net.ibizsys.model.control.form.IPSDEFormDRUIPart";
    public static final String INT_PSDEFORMDATAITEM = "net.ibizsys.model.control.form.IPSDEFormDataItem";
    public static final String INT_PSDEFORMDETAIL = "net.ibizsys.model.control.form.IPSDEFormDetail";
    public static final String INT_PSDEFORMFORMPART = "net.ibizsys.model.control.form.IPSDEFormFormPart";
    public static final String INT_PSDEFORMGROUPBASE = "net.ibizsys.model.control.form.IPSDEFormGroupBase";
    public static final String INT_PSDEFORMGROUPPANEL = "net.ibizsys.model.control.form.IPSDEFormGroupPanel";
    public static final String INT_PSDEFORMIFRAME = "net.ibizsys.model.control.form.IPSDEFormIFrame";
    public static final String INT_PSDEFORMITEM = "net.ibizsys.model.control.form.IPSDEFormItem";
    public static final String INT_PSDEFORMITEMEX = "net.ibizsys.model.control.form.IPSDEFormItemEx";
    public static final String INT_PSDEFORMITEMUPDATE = "net.ibizsys.model.control.form.IPSDEFormItemUpdate";
    public static final String INT_PSDEFORMITEMVR = "net.ibizsys.model.control.form.IPSDEFormItemVR";
    public static final String INT_PSDEFORMMDCTRL = "net.ibizsys.model.control.form.IPSDEFormMDCtrl";
    public static final String INT_PSDEFORMPAGE = "net.ibizsys.model.control.form.IPSDEFormPage";
    public static final String INT_PSDEFORMPARAM = "net.ibizsys.model.control.form.IPSDEFormParam";
    public static final String INT_PSDEFORMRAWITEM = "net.ibizsys.model.control.form.IPSDEFormRawItem";
    public static final String INT_PSDEFORMTABPAGE = "net.ibizsys.model.control.form.IPSDEFormTabPage";
    public static final String INT_PSDEFORMTABPANEL = "net.ibizsys.model.control.form.IPSDEFormTabPanel";
    public static final String INT_PSDEFORMUSERCONTROL = "net.ibizsys.model.control.form.IPSDEFormUserControl";
    public static final String INT_PSDEGEIUPDATEDETAIL = "net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail";
    public static final String INT_PSDEGRID = "net.ibizsys.model.control.grid.IPSDEGrid";
    public static final String INT_PSDEGRIDCOLUMN = "net.ibizsys.model.control.grid.IPSDEGridColumn";
    public static final String INT_PSDEGRIDDATAITEM = "net.ibizsys.model.control.grid.IPSDEGridDataItem";
    public static final String INT_PSDEGRIDEDITITEM = "net.ibizsys.model.control.grid.IPSDEGridEditItem";
    public static final String INT_PSDEGRIDEDITITEMUPDATE = "net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate";
    public static final String INT_PSDEGRIDFIELDCOLUMN = "net.ibizsys.model.control.grid.IPSDEGridFieldColumn";
    public static final String INT_PSDEGRIDGROUPCOLUMN = "net.ibizsys.model.control.grid.IPSDEGridGroupColumn";
    public static final String INT_PSDEGRIDHANDLER = "net.ibizsys.model.control.grid.IPSDEGridHandler";
    public static final String INT_PSDEGRIDPARAM = "net.ibizsys.model.control.grid.IPSDEGridParam";
    public static final String INT_PSDEGRIDUACOLUMN = "net.ibizsys.model.control.grid.IPSDEGridUAColumn";
    public static final String INT_PSDEGROUP = "net.ibizsys.model.dataentity.IPSDEGroup";
    public static final String INT_PSDEGROUPDETAIL = "net.ibizsys.model.dataentity.IPSDEGroupDetail";
    public static final String INT_PSDELIST = "net.ibizsys.model.control.list.IPSDEList";
    public static final String INT_PSDELISTDATAITEM = "net.ibizsys.model.control.list.IPSDEListDataItem";
    public static final String INT_PSDELISTHANDLER = "net.ibizsys.model.control.list.IPSDEListHandler";
    public static final String INT_PSDELISTITEM = "net.ibizsys.model.control.list.IPSDEListItem";
    public static final String INT_PSDELISTPARAM = "net.ibizsys.model.control.list.IPSDEListParam";
    public static final String INT_PSDELOGIC = "net.ibizsys.model.dataentity.logic.IPSDELogic";
    public static final String INT_PSDEFLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEFLogic";
    public static final String INT_PSDELOGICACTION = "net.ibizsys.model.dataentity.action.IPSDELogicAction";
    public static final String INT_PSDELOGICBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicBase";
    public static final String INT_PSDELOGICLINK = "net.ibizsys.model.dataentity.logic.IPSDELogicLink";
    public static final String INT_PSDELOGICLINKBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkBase";
    public static final String INT_PSDELOGICLINKCOND = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond";
    public static final String INT_PSDELOGICLINKCONDBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondBase";
    public static final String INT_PSDELOGICLINKCUSTOMCOND = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkCustomCond";
    public static final String INT_PSDELOGICLINKCUSTOMCONDBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkCustomCondBase";
    public static final String INT_PSDELOGICLINKGROUPCOND = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond";
    public static final String INT_PSDELOGICLINKGROUPCONDBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCondBase";
    public static final String INT_PSDELOGICLINKSINGLECOND = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkSingleCond";
    public static final String INT_PSDELOGICLINKSINGLECONDBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicLinkSingleCondBase";
    public static final String INT_PSDELOGICNODE = "net.ibizsys.model.dataentity.logic.IPSDELogicNode";
    public static final String INT_PSDELOGICNODEBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicNodeBase";
    public static final String INT_PSDELOGICNODEPARAM = "net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam";
    public static final String INT_PSDELOGICNODEPARAMBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicNodeParamBase";
    public static final String INT_PSDELOGICPARAM = "net.ibizsys.model.dataentity.logic.IPSDELogicParam";
    public static final String INT_PSDELOGICPARAMBASE = "net.ibizsys.model.dataentity.logic.IPSDELogicParamBase";
    public static final String INT_PSDEMAINSTATE = "net.ibizsys.model.dataentity.mainstate.IPSDEMainState";
    public static final String INT_PSDEMAINSTATEACTION = "net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction";
    public static final String INT_PSDEMAINSTATEOPPRIV = "net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv";
    public static final String INT_PSDEMAINSTATEFIELD = "net.ibizsys.model.dataentity.mainstate.IPSDEMainStateField";
    public static final String INT_PSDEMAINSTATERS = "net.ibizsys.model.dataentity.mainstate.IPSDEMainStateRS";
    public static final String INT_PSDEMAP = "net.ibizsys.model.dataentity.datamap.IPSDEMap";
    public static final String INT_PSDEMAPACTION = "net.ibizsys.model.dataentity.datamap.IPSDEMapAction";
    public static final String INT_PSDEMAPDATAQUERY = "net.ibizsys.model.dataentity.datamap.IPSDEMapDataQuery";
    public static final String INT_PSDEMAPDATASET = "net.ibizsys.model.dataentity.datamap.IPSDEMapDataSet";
    public static final String INT_PSDEMAPFIELD = "net.ibizsys.model.dataentity.datamap.IPSDEMapField";
    public static final String INT_PSDEMOBMDCTRL = "net.ibizsys.model.control.list.IPSDEMobMDCtrl";
    public static final String INT_PSDEMOBMDCTRLPARAM = "net.ibizsys.model.control.list.IPSDEMobMDCtrlParam";
    public static final String INT_PSDEMULTIEDITVIEWPANEL = "net.ibizsys.model.control.grid.IPSDEMultiEditViewPanel";
    public static final String INT_PSDEMULTIEDITVIEWPANELPARAM = "net.ibizsys.model.control.grid.IPSDEMultiEditViewPanelParam";
    public static final String INT_PSDEOPPRIV = "net.ibizsys.model.dataentity.priv.IPSDEOPPriv";
    public static final String INT_PSDEOPPRIVROLE = "net.ibizsys.model.dataentity.priv.IPSDEOPPrivRole";
    public static final String INT_PSDEPICKUPVIEWPANEL = "net.ibizsys.model.control.viewpanel.IPSDEPickupViewPanel";
    public static final String INT_PSDEPRINT = "net.ibizsys.model.dataentity.print.IPSDEPrint";
    public static final String INT_PSDER11 = "net.ibizsys.model.dataentity.der.IPSDER11";
    public static final String INT_PSDER1N = "net.ibizsys.model.dataentity.der.IPSDER1N";
    public static final String INT_PSDER1NDEFIELDMAP = "net.ibizsys.model.dataentity.der.IPSDER1NDEFieldMap";
    public static final String INT_PSDERINDEXDEFIELDMAP = "net.ibizsys.model.dataentity.der.IPSDERIndexDEFieldMap";
    public static final String INT_PSDERAGGDATADEFIELDMAP = "net.ibizsys.model.dataentity.der.IPSDERAggDataDEFieldMap";
    public static final String INT_PSDER1NSELECTACTION = "net.ibizsys.model.dataentity.der.IPSDER1NSelectAction";
    public static final String INT_PSDERBASE = "net.ibizsys.model.dataentity.der.IPSDERBase";
    public static final String INT_PSDERCUSTOM = "net.ibizsys.model.dataentity.der.IPSDERCustom";
    public static final String INT_PSDERDEFIELDMAP = "net.ibizsys.model.dataentity.der.IPSDERDEFieldMap";
    public static final String INT_PSDERGROUP = "net.ibizsys.model.dataentity.der.IPSDERGroup";
    public static final String INT_PSDERGROUPDETAIL = "net.ibizsys.model.dataentity.der.IPSDERGroupDetail";
    public static final String INT_PSDERINDEX = "net.ibizsys.model.dataentity.der.IPSDERIndex";
    public static final String INT_PSDERINHERIT = "net.ibizsys.model.dataentity.der.IPSDERInherit";
    public static final String INT_PSDERMULTIINHERIT = "net.ibizsys.model.dataentity.der.IPSDERMultiInherit";
    public static final String INT_PSDERAGGDATA = "net.ibizsys.model.dataentity.der.IPSDERAggData";
    public static final String INT_PSDERNN = "net.ibizsys.model.dataentity.der.IPSDERNN";
    public static final String INT_PSDEREPORT = "net.ibizsys.model.dataentity.report.IPSDEReport";
    public static final String INT_PSDEREPORTITEM = "net.ibizsys.model.dataentity.report.IPSDEReportItem";
    public static final String INT_PSDEREPORTPANEL = "net.ibizsys.model.control.reportpanel.IPSDEReportPanel";
    public static final String INT_PSDEREPORTPANELPARAM = "net.ibizsys.model.control.reportpanel.IPSDEReportPanelParam";
    public static final String INT_PSDESAMETHODTESTCASE = "net.ibizsys.model.testing.IPSDESAMethodTestCase";
    public static final String INT_PSDESAMPLEDATA = "net.ibizsys.model.dataentity.jit.IPSDESampleData";
    public static final String INT_PSDESEARCH = "net.ibizsys.model.dataentity.search.IPSDESearch";
    public static final String INT_PSDESEARCHFORM = "net.ibizsys.model.control.form.IPSDESearchForm";
    public static final String INT_PSDESEARCHFORMHANDLER = "net.ibizsys.model.control.form.IPSDESearchFormHandler";
    public static final String INT_PSDESEARCHFORMITEM = "net.ibizsys.model.control.form.IPSDESearchFormItem";
    public static final String INT_PSDESEARCHFORMPARAM = "net.ibizsys.model.control.form.IPSDESearchFormParam";
    public static final String INT_PSDESELECTACTION = "net.ibizsys.model.dataentity.action.IPSDESelectAction";
    public static final String INT_PSDESELECTACTIONPARAM = "net.ibizsys.model.dataentity.action.IPSDESelectActionParam";
    public static final String INT_PSDESERVICEAPI = "net.ibizsys.model.dataentity.service.IPSDEServiceAPI";
    public static final String INT_PSDESERVICEAPIFIELD = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIField";
    public static final String INT_PSDESERVICEAPIMETHOD = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIMethod";
    public static final String INT_PSDESERVICEAPIRS = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIRS";
    public static final String INT_PSDESERVICEAPIVR = "net.ibizsys.model.dataentity.service.IPSDEServiceAPIVR";
    public static final String INT_PSDETBGROUPITEM = "net.ibizsys.model.control.toolbar.IPSDETBGroupItem";
    public static final String INT_PSDETBRAWITEM = "net.ibizsys.model.control.toolbar.IPSDETBRawItem";
    public static final String INT_PSDETBSEPERATORITEM = "net.ibizsys.model.control.toolbar.IPSDETBSeperatorItem";
    public static final String INT_PSDETBUIACTIONITEM = "net.ibizsys.model.control.toolbar.IPSDETBUIActionItem";
    public static final String INT_PSDETABVIEWPANEL = "net.ibizsys.model.control.viewpanel.IPSDETabViewPanel";
    public static final String INT_PSDETABVIEWPANELPARAM = "net.ibizsys.model.control.viewpanel.IPSDETabViewPanelParam";
    public static final String INT_PSDETOOLBAR = "net.ibizsys.model.control.toolbar.IPSDEToolbar";
    public static final String INT_PSDETOOLBARITEM = "net.ibizsys.model.control.toolbar.IPSDEToolbarItem";
    public static final String INT_PSDETOOLBARPARAM = "net.ibizsys.model.control.toolbar.IPSDEToolbarParam";
    public static final String INT_PSDETREE = "net.ibizsys.model.control.tree.IPSDETree";
    public static final String INT_PSDETREECODELISTNODE = "net.ibizsys.model.control.tree.IPSDETreeCodeListNode";
    public static final String INT_PSDETREECOLUMN = "net.ibizsys.model.control.tree.IPSDETreeColumn";
    public static final String INT_PSDETREEDEFCOLUMN = "net.ibizsys.model.control.tree.IPSDETreeDEFColumn";
    public static final String INT_PSDETREEDATASETNODE = "net.ibizsys.model.control.tree.IPSDETreeDataSetNode";
    public static final String INT_PSDETREEGRID = "net.ibizsys.model.control.grid.IPSDETreeGrid";
    public static final String INT_PSDETREEGRIDCOLUMN = "net.ibizsys.model.control.tree.IPSDETreeGridColumn";
    public static final String INT_PSDETREEGRIDFIELDCOLUMN = "net.ibizsys.model.control.grid.IPSDETreeGridFieldColumn";
    public static final String INT_PSDETREEGRIDPARAM = "net.ibizsys.model.control.grid.IPSDETreeGridParam";
    public static final String INT_PSDETREEHANDLER = "net.ibizsys.model.control.tree.IPSDETreeHandler";
    public static final String INT_PSDETREENODE = "net.ibizsys.model.control.tree.IPSDETreeNode";
    public static final String INT_PSDETREENODEDATAITEM = "net.ibizsys.model.control.tree.IPSDETreeNodeDataItem";
    public static final String INT_PSDETREENODECOLUMN = "net.ibizsys.model.control.tree.IPSDETreeNodeColumn";
    public static final String INT_PSDETREENODEEDITITEM = "net.ibizsys.model.control.tree.IPSDETreeNodeEditItem";
    public static final String INT_PSDETREENODERS = "net.ibizsys.model.control.tree.IPSDETreeNodeRS";
    public static final String INT_PSDETREENODERSNAVCONTEXT = "net.ibizsys.model.control.tree.IPSDETreeNodeRSNavContext";
    public static final String INT_PSDETREENODERSNAVPARAM = "net.ibizsys.model.control.tree.IPSDETreeNodeRSNavParam";
    public static final String INT_PSDETREENODERSPARAM = "net.ibizsys.model.control.tree.IPSDETreeNodeRSParam";
    public static final String INT_PSDETREENODERV = "net.ibizsys.model.control.tree.IPSDETreeNodeRV";
    public static final String INT_PSDETREEPARAM = "net.ibizsys.model.control.tree.IPSDETreeParam";
    public static final String INT_PSDETREESTATICNODE = "net.ibizsys.model.control.tree.IPSDETreeStaticNode";
    public static final String INT_PSDETREEUACOLUMN = "net.ibizsys.model.control.tree.IPSDETreeUAColumn";
    public static final String INT_PSDEUIACTION = "net.ibizsys.model.dataentity.uiaction.IPSDEUIAction";
    public static final String INT_PSDEUIACTIONGROUP = "net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup";
    public static final String INT_PSDEUIACTIONGROUPDETAIL = "net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail";
    public static final String INT_PSDEUIACTIONITEM = "net.ibizsys.model.app.view.IPSDEUIActionItem";
    public static final String INT_PSDEUIACTIONLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUIActionLogic";
    public static final String INT_PSDEUICTRLINVOKELOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUICtrlInvokeLogic";
    public static final String INT_PSDEUIDEACTIONLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUIDEActionLogic";
    public static final String INT_PSDEUILOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUILogic";
    public static final String INT_PSDEUILOGICGROUP = "net.ibizsys.model.dataentity.logic.IPSDEUILogicGroup";
    public static final String INT_PSDEUILOGICGROUPDETAIL = "net.ibizsys.model.dataentity.logic.IPSDEUILogicGroupDetail";
    public static final String INT_PSDEUILOGICLINK = "net.ibizsys.model.dataentity.logic.IPSDEUILogicLink";
    public static final String INT_PSDEUILOGICLINKCOND = "net.ibizsys.model.dataentity.logic.IPSDEUILogicLinkCond";
    public static final String INT_PSDEUILOGICLINKGROUPCOND = "net.ibizsys.model.dataentity.logic.IPSDEUILogicLinkGroupCond";
    public static final String INT_PSDEUILOGICLINKSINGLECOND = "net.ibizsys.model.dataentity.logic.IPSDEUILogicLinkSingleCond";
    public static final String INT_PSDEUILOGICNODE = "net.ibizsys.model.dataentity.logic.IPSDEUILogicNode";
    public static final String INT_PSDEUILOGICNODEBASE = "net.ibizsys.model.dataentity.logic.IPSDEUILogicNodeBase";
    public static final String INT_PSDEUILOGICNODEPARAM = "net.ibizsys.model.dataentity.logic.IPSDEUILogicNodeParam";
    public static final String INT_PSDEUILOGICPARAM = "net.ibizsys.model.dataentity.logic.IPSDEUILogicParam";
    public static final String INT_PSDEUIMSGBOXLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUIMsgBoxLogic";
    public static final String INT_PSDEUIPFPLUGINLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUIPFPluginLogic";
    public static final String INT_PSDEUIRAWCODELOGIC = "net.ibizsys.model.dataentity.logic.IPSDEUIRawCodeLogic";
    public static final String INT_PSDEUNISTATE = "net.ibizsys.model.dataentity.unistate.IPSDEUniState";
    public static final String INT_PSDEUSERCREATEACTION = "net.ibizsys.model.dataentity.action.IPSDEUserCreateAction";
    public static final String INT_PSDEUSERROLE = "net.ibizsys.model.dataentity.priv.IPSDEUserRole";
    public static final String INT_PSDEUSERROLEOPPRIV = "net.ibizsys.model.dataentity.priv.IPSDEUserRoleOPPriv";
    public static final String INT_PSDEUSERSYSUPDATEACTION = "net.ibizsys.model.dataentity.action.IPSDEUserSysUpdateAction";
    public static final String INT_PSDEUSERUPDATEACTION = "net.ibizsys.model.dataentity.action.IPSDEUserUpdateAction";
    public static final String INT_PSDEUTIL = "net.ibizsys.model.dataentity.util.IPSDEUtil";
    public static final String INT_PSDEVIEWLOGIC = "net.ibizsys.model.dataentity.logic.IPSDEViewLogic";
    public static final String INT_PSDEVIEWPANEL = "net.ibizsys.model.control.viewpanel.IPSDEViewPanel";
    public static final String INT_PSDEVIEWPANELPARAM = "net.ibizsys.model.control.viewpanel.IPSDEViewPanelParam";
    public static final String INT_PSDEWF = "net.ibizsys.model.dataentity.wf.IPSDEWF";
    public static final String INT_PSDEWIZARD = "net.ibizsys.model.dataentity.wizard.IPSDEWizard";
    public static final String INT_PSDEWIZARDEDITFORM = "net.ibizsys.model.control.form.IPSDEWizardEditForm";
    public static final String INT_PSDEWIZARDEDITFORMPARAM = "net.ibizsys.model.control.form.IPSDEWizardEditFormParam";
    public static final String INT_PSDEWIZARDFORM = "net.ibizsys.model.dataentity.wizard.IPSDEWizardForm";
    public static final String INT_PSDEWIZARDPANEL = "net.ibizsys.model.control.wizardpanel.IPSDEWizardPanel";
    public static final String INT_PSDEWIZARDPANELPARAM = "net.ibizsys.model.control.wizardpanel.IPSDEWizardPanelParam";
    public static final String INT_PSDEWIZARDSTEP = "net.ibizsys.model.dataentity.wizard.IPSDEWizardStep";
    public static final String INT_PSDRBAR = "net.ibizsys.model.control.drctrl.IPSDRBar";
    public static final String INT_PSDRCTRL = "net.ibizsys.model.control.drctrl.IPSDRCtrl";
    public static final String INT_PSDRTAB = "net.ibizsys.model.control.drctrl.IPSDRTab";
    public static final String INT_PSDASHBOARD = "net.ibizsys.model.control.dashboard.IPSDashboard";
    public static final String INT_PSDASHBOARDCONTAINER = "net.ibizsys.model.control.dashboard.IPSDashboardContainer";
    public static final String INT_PSDASHBOARDPARAM = "net.ibizsys.model.control.dashboard.IPSDashboardParam";
    public static final String INT_PSDATAENTITY = "net.ibizsys.model.dataentity.IPSDataEntity";
    public static final String INT_PSDATAENTITYOBJECT = "net.ibizsys.model.dataentity.IPSDataEntityObject";
    public static final String INT_PSDATAITEM = "net.ibizsys.model.data.IPSDataItem";
    public static final String INT_PSDATAITEMPARAM = "net.ibizsys.model.data.IPSDataItemParam";
    public static final String INT_PSDATAVIEWEXPBAR = "net.ibizsys.model.control.expbar.IPSDataViewExpBar";
    public static final String INT_PSDATAVIEWEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSDataViewExpBarParam";
    public static final String INT_PSDATEPICKER = "net.ibizsys.model.control.editor.IPSDatePicker";
    public static final String INT_PSDEVSLNMSDEPAPI = "net.ibizsys.model.deploy.IPSDevSlnMSDepAPI";
    public static final String INT_PSDEVSLNMSDEPAPP = "net.ibizsys.model.deploy.IPSDevSlnMSDepApp";
    public static final String INT_PSDEVSLNMSDEPFUNC = "net.ibizsys.model.deploy.IPSDevSlnMSDepFunc";
    public static final String INT_PSDEVSLNMSDEPFUNCAPI = "net.ibizsys.model.deploy.IPSDevSlnMSDepFuncAPI";
    public static final String INT_PSDEVSLNMSDEPFUNCAPP = "net.ibizsys.model.deploy.IPSDevSlnMSDepFuncApp";
    public static final String INT_PSDEVSLNMSDEPFUNCITEM = "net.ibizsys.model.deploy.IPSDevSlnMSDepFuncItem";
    public static final String INT_PSDEVTASK = "net.ibizsys.model.devtask.IPSDevTask";
    public static final String INT_PSDROPDOWNLIST = "net.ibizsys.model.control.editor.IPSDropDownList";
    public static final String INT_PSDYNADEFORMTEMPL = "net.ibizsys.model.dynasys.IPSDynaDEFormTempl";
    public static final String INT_PSDYNADETEMPL = "net.ibizsys.model.dynasys.IPSDynaDETempl";
    public static final String INT_PSDYNADEVIEWTEMPL = "net.ibizsys.model.dynasys.IPSDynaDEViewTempl";
    public static final String INT_PSDYNAMODEL = "net.ibizsys.model.dynamodel.IPSDynaModel";
    public static final String INT_PSDYNAMODELATTR = "net.ibizsys.model.dynamodel.IPSDynaModelAttr";
    public static final String INT_PSJSONSCHEMA = "net.ibizsys.model.dynamodel.IPSJsonSchema";
    public static final String INT_PSJSONNODESCHEMA = "net.ibizsys.model.dynamodel.IPSJsonNodeSchema";
    public static final String INT_PSJSONPROPERTY = "net.ibizsys.model.dynamodel.IPSJsonProperty";
    public static final String INT_PSECHARTS = "net.ibizsys.model.control.chart.IPSECharts";
    public static final String INT_PSECHARTSOBJECT = "net.ibizsys.model.control.chart.IPSEChartsObject";
    public static final String INT_PSECHARTSSERIES = "net.ibizsys.model.control.chart.IPSEChartsSeries";
    public static final String INT_PSERMAP = "net.ibizsys.model.er.IPSERMap";
    public static final String INT_PSERMAPNODE = "net.ibizsys.model.er.IPSERMapNode";
    public static final String INT_PSEDITOR = "net.ibizsys.model.control.IPSEditor";
    public static final String INT_PSEDITORITEM = "net.ibizsys.model.control.IPSEditorItem";
    public static final String INT_PSEDITORCONTAINER = "net.ibizsys.model.control.IPSEditorContainer";
    public static final String INT_PSEDITORPARAM = "net.ibizsys.model.control.IPSEditorParam";
    public static final String INT_PSEDITORTYPE = "net.ibizsys.model.control.IPSEditorType";
    public static final String INT_PSEXPBAR = "net.ibizsys.model.control.expbar.IPSExpBar";
    public static final String INT_PSEXPBARITEM = "net.ibizsys.model.control.expbar.IPSExpBarItem";
    public static final String INT_PSEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSExpBarParam";
    public static final String INT_PSFIDEFVALUERULE = "net.ibizsys.model.control.form.IPSFIDEFValueRule";
    public static final String INT_PSFILEUPLOADER = "net.ibizsys.model.control.editor.IPSFileUploader";
    public static final String INT_PSFLEXLAYOUT = "net.ibizsys.model.control.layout.IPSFlexLayout";
    public static final String INT_PSFLEXLAYOUTPOS = "net.ibizsys.model.control.layout.IPSFlexLayoutPos";
    public static final String INT_PSFORMULADEFIELD = "net.ibizsys.model.dataentity.defield.IPSFormulaDEField";
    public static final String INT_PSGEIDEFVALUERULE = "net.ibizsys.model.control.grid.IPSGEIDEFValueRule";
    public static final String INT_PSGANTT = "net.ibizsys.model.control.gantt.IPSGantt";
    public static final String INT_PSGANTTEXPBAR = "net.ibizsys.model.control.expbar.IPSGanttExpBar";
    public static final String INT_PSGANTTEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSGanttExpBarParam";
    public static final String INT_PSGANTTITEM = "net.ibizsys.model.control.gantt.IPSGanttItem";
    public static final String INT_PSGANTTITEMDATAITEM = "net.ibizsys.model.control.gantt.IPSGanttItemDataItem";
    public static final String INT_PSGANTTPARAM = "net.ibizsys.model.control.gantt.IPSGanttParam";
    public static final String INT_PSGENERATECODERESULT = "net.ibizsys.model.pub.IPSGenerateCodeResult";
    public static final String INT_PSGRIDEXPBAR = "net.ibizsys.model.control.expbar.IPSGridExpBar";
    public static final String INT_PSGRIDEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSGridExpBarParam";
    public static final String INT_PSGRIDLAYOUT = "net.ibizsys.model.control.layout.IPSGridLayout";
    public static final String INT_PSGRIDLAYOUTPOS = "net.ibizsys.model.control.layout.IPSGridLayoutPos";
    public static final String INT_PSHELPARTICLE = "net.ibizsys.model.help.IPSHelpArticle";
    public static final String INT_PSHELPMODULE = "net.ibizsys.model.help.IPSHelpModule";
    public static final String INT_PSHELPPRJ = "net.ibizsys.model.help.IPSHelpPrj";
    public static final String INT_PSHELPRESOURCE = "net.ibizsys.model.help.IPSHelpResource";
    public static final String INT_PSHELPSECTION = "net.ibizsys.model.help.IPSHelpSection";
    public static final String INT_PSHIDDEN = "net.ibizsys.model.control.editor.IPSHidden";
    public static final String INT_PSHTML = "net.ibizsys.model.control.editor.IPSHtml";
    public static final String INT_PSIFRAMEPANEL = "net.ibizsys.model.control.updatepanel.IPSIFramePanel";
    public static final String INT_PSIFRAMEPANELPARAM = "net.ibizsys.model.control.updatepanel.IPSIFramePanelParam";
    public static final String INT_PSIPADDRESS = "net.ibizsys.model.control.editor.IPSIPAddress";
    public static final String INT_PSINHERITDEFIELD = "net.ibizsys.model.dataentity.defield.IPSInheritDEField";
    public static final String INT_PSLANGUAGEITEM = "net.ibizsys.model.res.IPSLanguageItem";
    public static final String INT_PSLANGUAGERES = "net.ibizsys.model.res.IPSLanguageRes";
    public static final String INT_PSLAYOUT = "net.ibizsys.model.control.layout.IPSLayout";
    public static final String INT_PSLAYOUTCONTAINER = "net.ibizsys.model.control.layout.IPSLayoutContainer";
    public static final String INT_PSLAYOUTITEM = "net.ibizsys.model.control.layout.IPSLayoutItem";
    public static final String INT_PSLAYOUTPANEL = "net.ibizsys.model.control.panel.IPSLayoutPanel";
    public static final String INT_PSLAYOUTPOS = "net.ibizsys.model.control.layout.IPSLayoutPos";
    public static final String INT_PSLINKDEFIELD = "net.ibizsys.model.dataentity.defield.IPSLinkDEField";
    public static final String INT_PSLIST = "net.ibizsys.model.control.list.IPSList";
    public static final String INT_PSLISTBOX = "net.ibizsys.model.control.editor.IPSListBox";
    public static final String INT_PSLISTBOXPICKER = "net.ibizsys.model.control.editor.IPSListBoxPicker";
    public static final String INT_PSLISTDATAITEM = "net.ibizsys.model.control.list.IPSListDataItem";
    public static final String INT_PSLISTEXPBAR = "net.ibizsys.model.control.expbar.IPSListExpBar";
    public static final String INT_PSLISTEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSListExpBarParam";
    public static final String INT_PSLISTITEM = "net.ibizsys.model.control.list.IPSListItem";
    public static final String INT_PSMDAJAXCONTROL = "net.ibizsys.model.control.IPSMDAjaxControl";
    public static final String INT_PSMDAJAXCONTROLHANDLER = "net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler";
    public static final String INT_PSMDAJAXCONTROLPARAM = "net.ibizsys.model.control.IPSMDAjaxControlParam";
    public static final String INT_PSMDCONTROL = "net.ibizsys.model.control.IPSMDControl";
    public static final String INT_PSMDCONTROL2 = "net.ibizsys.model.control.IPSMDControl2";
    public static final String INT_PSMDROPDOWNLIST = "net.ibizsys.model.control.editor.IPSMDropDownList";
    public static final String INT_PSMPICKER = "net.ibizsys.model.control.editor.IPSMPicker";
    public static final String INT_PSMSPLATFORM = "net.ibizsys.model.deploy.IPSMSPlatform";
    public static final String INT_PSMSPLATFORMFUNC = "net.ibizsys.model.deploy.IPSMSPlatformFunc";
    public static final String INT_PSMSPLATFORMNODE = "net.ibizsys.model.deploy.IPSMSPlatformNode";
    public static final String INT_PSMAILADDRESS = "net.ibizsys.model.control.editor.IPSMailAddress";
    public static final String INT_PSMAP = "net.ibizsys.model.control.map.IPSMap";
    public static final String INT_PSMAPEXPBAR = "net.ibizsys.model.control.expbar.IPSMapExpBar";
    public static final String INT_PSMAPEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSMapExpBarParam";
    public static final String INT_PSMAPITEM = "net.ibizsys.model.control.map.IPSMapItem";
    public static final String INT_PSMAPITEMDATAITEM = "net.ibizsys.model.control.map.IPSMapItemDataItem";
    public static final String INT_PSMAPPARAM = "net.ibizsys.model.control.map.IPSMapParam";
    public static final String INT_PSMAVENREPO = "net.ibizsys.model.deploy.IPSMavenRepo";
    public static final String INT_PSMENU = "net.ibizsys.model.control.menu.IPSMenu";
    public static final String INT_PSMENUITEM = "net.ibizsys.model.control.menu.IPSMenuItem";
    public static final String INT_PSMOBAPPICON = "net.ibizsys.model.app.mob.IPSMobAppIcon";
    public static final String INT_PSMOBAPPPACK = "net.ibizsys.model.app.mob.IPSMobAppPack";
    public static final String INT_PSMOBAPPPACKCERT = "net.ibizsys.model.app.mob.IPSMobAppPackCert";
    public static final String INT_PSMOBAPPSTARTPAGE = "net.ibizsys.model.app.mob.IPSMobAppStartPage";
    public static final String INT_PSMODEL = "net.ibizsys.model.IPSModel";
    public static final String INT_PSMODELDIFFABLE = "net.ibizsys.model.IPSModelDiffable";
    public static final String INT_PSMODELOBJECT = "net.ibizsys.model.IPSModelObject";
    public static final String INT_PSMODELOBJECT2 = "net.ibizsys.model.IPSModelObject2";
    public static final String INT_PSNAVIGATABLE = "net.ibizsys.model.control.IPSNavigatable";
    public static final String INT_PSNUMBEREDITOR = "net.ibizsys.model.control.editor.IPSNumberEditor";
    public static final String INT_PSOBJECT = "net.ibizsys.model.IPSObject";
    public static final String INT_PSOFFICE = "net.ibizsys.model.control.editor.IPSOffice";
    public static final String INT_PSOFFICE2 = "net.ibizsys.model.control.editor.IPSOffice2";
    public static final String INT_PSONE2MANYDATADEFIELD = "net.ibizsys.model.dataentity.defield.IPSOne2ManyDataDEField";
    public static final String INT_PSPF = "net.ibizsys.model.pf.IPSPF";
    public static final String INT_PSPFAPPCOUNTERTEMPL = "net.ibizsys.model.pf.IPSPFAppCounterTempl";
    public static final String INT_PSPFAPPDATAENTITYTEMPL = "net.ibizsys.model.pf.IPSPFAppDataEntityTempl";
    public static final String INT_PSPFAPPTEMPL = "net.ibizsys.model.pf.IPSPFAppTempl";
    public static final String INT_PSPFAPPWFTEMPL = "net.ibizsys.model.pf.IPSPFAppWFTempl";
    public static final String INT_PSPFAPPWFVERTEMPL = "net.ibizsys.model.pf.IPSPFAppWFVerTempl";
    public static final String INT_PSPFCDN = "net.ibizsys.model.pf.IPSPFCDN";
    public static final String INT_PSPFCODEFOLDER = "net.ibizsys.model.pf.IPSPFCodeFolder";
    public static final String INT_PSPFCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPFCodePublisherContext";
    public static final String INT_PSPFCTRLCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPFCtrlCodePublisherContext";
    public static final String INT_PSPFCTRLTEMPL = "net.ibizsys.model.pf.IPSPFCtrlTempl";
    public static final String INT_PSPFCTRLTEMPLDETAIL = "net.ibizsys.model.pf.IPSPFCtrlTemplDetail";
    public static final String INT_PSPFEDITORCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPFEditorCodePublisherContext";
    public static final String INT_PSPFEDITORTEMPL = "net.ibizsys.model.pf.IPSPFEditorTempl";
    public static final String INT_PSPFOBJECT = "net.ibizsys.model.pf.IPSPFObject";
    public static final String INT_PSPFPKG = "net.ibizsys.model.pf.IPSPFPkg";
    public static final String INT_PSPFPKGVER = "net.ibizsys.model.pf.IPSPFPkgVer";
    public static final String INT_PSPFPKGVERCDN = "net.ibizsys.model.pf.IPSPFPkgVerCDN";
    public static final String INT_PSPFPLUGIN = "net.ibizsys.model.pf.IPSPFPlugin";
    public static final String INT_PSPFPLUGINTEMPL = "net.ibizsys.model.pf.IPSPFPluginTempl";
    public static final String INT_PSPFPUBCODE = "net.ibizsys.model.pf.IPSPFPubCode";
    public static final String INT_PSPFPUBOBJ = "net.ibizsys.model.pf.IPSPFPubObj";
    public static final String INT_PSPFSTYLE = "net.ibizsys.model.pf.IPSPFStyle";
    public static final String INT_PSPFSTYLECODE = "net.ibizsys.model.pf.IPSPFStyleCode";
    public static final String INT_PSPFSTYLEOBJECT = "net.ibizsys.model.pf.IPSPFStyleObject";
    public static final String INT_PSPFSTYLEPKG = "net.ibizsys.model.pf.IPSPFStylePkg";
    public static final String INT_PSPFSTYLEPRJ = "net.ibizsys.model.pf.IPSPFStylePrj";
    public static final String INT_PSPFUIACTIONTEMPL = "net.ibizsys.model.pf.IPSPFUIActionTempl";
    public static final String INT_PSPFVIEWCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPFViewCodePublisherContext";
    public static final String INT_PSPFVIEWCODEPUBLISHERCONTEXT2 = "net.ibizsys.model.pub.IPSPFViewCodePublisherContext2";
    public static final String INT_PSPFVIEWLOGICCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPFViewLogicCodePublisherContext";
    public static final String INT_PSPFVIEWLOGICTEMPL = "net.ibizsys.model.pf.IPSPFViewLogicTempl";
    public static final String INT_PSPFVIEWLOGICTEMPLDETAIL = "net.ibizsys.model.pf.IPSPFViewLogicTemplDetail";
    public static final String INT_PSPFVIEWTEMPL = "net.ibizsys.model.pf.IPSPFViewTempl";
    public static final String INT_PSPFXCODEOBJECT = "net.ibizsys.model.pf.IPSPFXCodeObject";
    public static final String INT_PSPANEL = "net.ibizsys.model.control.panel.IPSPanel";
    public static final String INT_PSPANELBUTTON = "net.ibizsys.model.control.panel.IPSPanelButton";
    public static final String INT_PSPANELCONTAINER = "net.ibizsys.model.control.panel.IPSPanelContainer";
    public static final String INT_PSPANELCONTROL = "net.ibizsys.model.control.panel.IPSPanelControl";
    public static final String INT_PSPANELCTRLPOS = "net.ibizsys.model.control.panel.IPSPanelCtrlPos";
    public static final String INT_PSPANELDRUIPART = "net.ibizsys.model.control.panel.IPSPanelDRUIPart";
    public static final String INT_PSPANELENGINE = "net.ibizsys.model.control.panel.IPSPanelEngine";
    public static final String INT_PSPANELFIELD = "net.ibizsys.model.control.panel.IPSPanelField";
    public static final String INT_PSPANELHANDLER = "net.ibizsys.model.control.panel.IPSPanelHandler";
    public static final String INT_PSPANELIFRAME = "net.ibizsys.model.control.panel.IPSPanelIFrame";
    public static final String INT_PSPANELITEM = "net.ibizsys.model.control.panel.IPSPanelItem";
    public static final String INT_PSPANELITEMCATGROUPLOGIC = "net.ibizsys.model.control.panel.IPSPanelItemCatGroupLogic";
    public static final String INT_PSPANELITEMCUSTOMLOGIC = "net.ibizsys.model.control.panel.IPSPanelItemCustomLogic";
    public static final String INT_PSPANELITEMGROUPLOGIC = "net.ibizsys.model.control.panel.IPSPanelItemGroupLogic";
    public static final String INT_PSPANELITEMLOGIC = "net.ibizsys.model.control.panel.IPSPanelItemLogic";
    public static final String INT_PSPANELITEMSINGLELOGIC = "net.ibizsys.model.control.panel.IPSPanelItemSingleLogic";
    public static final String INT_PSPANELLOGIC = "net.ibizsys.model.control.panel.IPSPanelLogic";
    public static final String INT_PSPANELMODEL = "net.ibizsys.model.control.panel.IPSPanelModel";
    public static final String INT_PSPANELOBJECT = "net.ibizsys.model.control.panel.IPSPanelObject";
    public static final String INT_PSPANELPARAM = "net.ibizsys.model.control.panel.IPSPanelParam";
    public static final String INT_PSPANELRAWITEM = "net.ibizsys.model.control.panel.IPSPanelRawItem";
    public static final String INT_PSPANELTAB = "net.ibizsys.model.control.panel.IPSPanelTab";
    public static final String INT_PSPANELTABPAGE = "net.ibizsys.model.control.panel.IPSPanelTabPage";
    public static final String INT_PSPANELTABPANEL = "net.ibizsys.model.control.panel.IPSPanelTabPanel";
    public static final String INT_PSPANELUSERCONTROL = "net.ibizsys.model.control.panel.IPSPanelUserControl";
    public static final String INT_PSPASSWORD = "net.ibizsys.model.control.editor.IPSPassword";
    public static final String INT_PSPICKER = "net.ibizsys.model.control.editor.IPSPicker";
    public static final String INT_PSPICKEREDITOR = "net.ibizsys.model.control.editor.IPSPickerEditor";
    public static final String INT_PSPICKUPDEFIELD = "net.ibizsys.model.dataentity.defield.IPSPickupDEField";
    public static final String INT_PSPICKUPDATADEFIELD = "net.ibizsys.model.dataentity.defield.IPSPickupDataDEField";
    public static final String INT_PSPICKUPTEXTDEFIELD = "net.ibizsys.model.dataentity.defield.IPSPickupTextDEField";
    public static final String INT_PSPICKUPVIEW = "net.ibizsys.model.control.editor.IPSPickupView";
    public static final String INT_PSPICTURE = "net.ibizsys.model.control.editor.IPSPicture";
    public static final String INT_PSPORTLETTYPE = "net.ibizsys.model.res.IPSPortletType";
    public static final String INT_PSPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSPublisherContext";
    public static final String INT_PSRESTFULAPI = "net.ibizsys.model.service.IPSRESTfulAPI";
    public static final String INT_PSRADIOBUTTON = "net.ibizsys.model.control.button.IPSRadioButton";
    public static final String INT_PSRADIOBUTTONGROUP = "net.ibizsys.model.control.button.IPSRadioButtonGroup";
    public static final String INT_PSRADIOBUTTONLIST = "net.ibizsys.model.control.editor.IPSRadioButtonList";
    public static final String INT_PSRATING = "net.ibizsys.model.control.editor.IPSRating";
    public static final String INT_PSRAW = "net.ibizsys.model.control.editor.IPSRaw";
    public static final String INT_PSREGISTRYREPO = "net.ibizsys.model.deploy.IPSRegistryRepo";
    public static final String INT_PSREMOTERESOBJECT = "net.ibizsys.model.deploy.IPSRemoteResObject";
    public static final String INT_PSSDAJAXCONTROL = "net.ibizsys.model.control.IPSSDAjaxControl";
    public static final String INT_PSSDAJAXCONTROLHANDLER = "net.ibizsys.model.control.ajax.IPSSDAjaxControlHandler";
    public static final String INT_PSSDAJAXCONTROLPARAM = "net.ibizsys.model.control.IPSSDAjaxControlParam";
    public static final String INT_PSSDCONTROL = "net.ibizsys.model.control.IPSSDControl";
    public static final String INT_PSSF = "net.ibizsys.model.sf.IPSSF";
    public static final String INT_PSSFACHANDLER = "net.ibizsys.model.sf.IPSSFACHandler";
    public static final String INT_PSSFCODEFOLDER = "net.ibizsys.model.sf.IPSSFCodeFolder";
    public static final String INT_PSSFCODEOBJECT = "net.ibizsys.model.sf.IPSSFCodeObject";
    public static final String INT_PSSFCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSSFCodePublisherContext";
    public static final String INT_PSSFCODETEMPL = "net.ibizsys.model.sf.IPSSFCodeTempl";
    public static final String INT_PSSFCODETYPE = "net.ibizsys.model.sf.IPSSFCodeType";
    public static final String INT_PSSFDBTEMPL = "net.ibizsys.model.sf.IPSSFDBTempl";
    public static final String INT_PSSFDBTEMPLDETAIL = "net.ibizsys.model.sf.IPSSFDBTemplDetail";
    public static final String INT_PSSFHELPTEMPL = "net.ibizsys.model.sf.IPSSFHelpTempl";
    public static final String INT_PSSFHELPTEMPLDETAIL = "net.ibizsys.model.sf.IPSSFHelpTemplDetail";
    public static final String INT_PSSFLOGICCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSSFLogicCodePublisherContext";
    public static final String INT_PSSFLOGICTEMPL = "net.ibizsys.model.sf.IPSSFLogicTempl";
    public static final String INT_PSSFLOGICTEMPLDETAIL = "net.ibizsys.model.sf.IPSSFLogicTemplDetail";
    public static final String INT_PSSFOBJECT = "net.ibizsys.model.sf.IPSSFObject";
    public static final String INT_PSSFPKG = "net.ibizsys.model.sf.IPSSFPkg";
    public static final String INT_PSSFPKGVER = "net.ibizsys.model.sf.IPSSFPkgVer";
    public static final String INT_PSSFPLUGINTEMPL = "net.ibizsys.model.sf.IPSSFPluginTempl";
    public static final String INT_PSSFPUBCODE = "net.ibizsys.model.sf.IPSSFPubCode";
    public static final String INT_PSSFPUBOBJ = "net.ibizsys.model.sf.IPSSFPubObj";
    public static final String INT_PSSFSTYLE = "net.ibizsys.model.sf.IPSSFStyle";
    public static final String INT_PSSFSTYLEOBJECT = "net.ibizsys.model.sf.IPSSFStyleObject";
    public static final String INT_PSSFSTYLEPARAM = "net.ibizsys.model.sf.IPSSFStyleParam";
    public static final String INT_PSSFSTYLEPKG = "net.ibizsys.model.sf.IPSSFStylePkg";
    public static final String INT_PSSFSTYLEPRJ = "net.ibizsys.model.sf.IPSSFStylePrj";
    public static final String INT_PSSFSTYLEVER = "net.ibizsys.model.sf.IPSSFStyleVer";
    public static final String INT_PSSFSYSCODEPUBLISHERCONTEXT = "net.ibizsys.model.pub.IPSSFSysCodePublisherContext";
    public static final String INT_PSSFVERCODE = "net.ibizsys.model.sf.IPSSFVerCode";
    public static final String INT_PSSFVERCODEITEM = "net.ibizsys.model.sf.IPSSFVerCodeItem";
    public static final String INT_PSSFXCODEOBJECT = "net.ibizsys.model.sf.IPSSFXCodeObject";
    public static final String INT_PSSEARCHBAR = "net.ibizsys.model.control.searchbar.IPSSearchBar";
    public static final String INT_PSSEARCHBARBUTTON = "net.ibizsys.model.control.searchbar.IPSSearchBarButton";
    public static final String INT_PSSEARCHBARINPUT = "net.ibizsys.model.control.searchbar.IPSSearchBarInput";
    public static final String INT_PSSEARCHBARITEM = "net.ibizsys.model.control.searchbar.IPSSearchBarItem";
    public static final String INT_PSSEARCHBAROBJECT = "net.ibizsys.model.control.searchbar.IPSSearchBarObject";
    public static final String INT_PSSEARCHBARPARAM = "net.ibizsys.model.control.searchbar.IPSSearchBarParam";
    public static final String INT_PSSEARCHDE = "net.ibizsys.model.search.IPSSearchDE";
    public static final String INT_PSSEARCHDEFIELD = "net.ibizsys.model.search.IPSSearchDEField";
    public static final String INT_PSSEARCHDEOBJECT = "net.ibizsys.model.search.IPSSearchDEObject";
    public static final String INT_PSSEARCHDOC = "net.ibizsys.model.search.IPSSearchDoc";
    public static final String INT_PSSEARCHDOCOBJECT = "net.ibizsys.model.search.IPSSearchDocObject";
    public static final String INT_PSSEARCHFIELD = "net.ibizsys.model.search.IPSSearchField";
    public static final String INT_PSSEARCHSCHEME = "net.ibizsys.model.search.IPSSearchScheme";
    public static final String INT_PSSEARCHSCHEMEOBJECT = "net.ibizsys.model.search.IPSSearchSchemeObject";
    public static final String INT_PSSLIDER = "net.ibizsys.model.control.editor.IPSSlider";
    public static final String INT_PSSPAN = "net.ibizsys.model.control.editor.IPSSpan";
    public static final String INT_PSSTEPPER = "net.ibizsys.model.control.editor.IPSStepper";
    public static final String INT_PSSUBSYS = "net.ibizsys.model.subsys.IPSSubSys";
    public static final String INT_PSSUBSYSOBJECT = "net.ibizsys.model.subsys.IPSSubSysObject";
    public static final String INT_PSSUBSYSREF = "net.ibizsys.model.system.IPSSubSysRef";
    public static final String INT_PSSUBSYSSERVICEAPI = "net.ibizsys.model.service.IPSSubSysServiceAPI";
    public static final String INT_PSSUBSYSSERVICEAPIDE = "net.ibizsys.model.service.IPSSubSysServiceAPIDE";
    public static final String INT_PSSUBSYSSERVICEAPIDEFIELD = "net.ibizsys.model.service.IPSSubSysServiceAPIDEField";
    public static final String INT_PSSUBSYSSERVICEAPIDEMETHOD = "net.ibizsys.model.service.IPSSubSysServiceAPIDEMethod";
    public static final String INT_PSSUBSYSSERVICEAPIDERS = "net.ibizsys.model.service.IPSSubSysServiceAPIDERS";
    public static final String INT_PSSUBSYSSERVICEAPIMETHOD = "net.ibizsys.model.service.IPSSubSysServiceAPIMethod";
    public static final String INT_PSSUBSYSVER = "net.ibizsys.model.subsys.IPSSubSysVer";
    public static final String INT_PSSUBVIEWTYPE = "net.ibizsys.model.res.IPSSubViewType";
    public static final String INT_PSSYSACTOR = "net.ibizsys.model.uml.IPSSysActor";
    public static final String INT_PSSYSBDCOLSET = "net.ibizsys.model.ba.IPSSysBDColSet";
    public static final String INT_PSSYSBDCOLUMN = "net.ibizsys.model.ba.IPSSysBDColumn";
    public static final String INT_PSSYSBDMODULE = "net.ibizsys.model.ba.IPSSysBDModule";
    public static final String INT_PSSYSBDPART = "net.ibizsys.model.ba.IPSSysBDPart";
    public static final String INT_PSSYSBDSCHEME = "net.ibizsys.model.ba.IPSSysBDScheme";
    public static final String INT_PSSYSBDSCHEMEOBJECT = "net.ibizsys.model.ba.IPSSysBDSchemeObject";
    public static final String INT_PSSYSBDTABLE = "net.ibizsys.model.ba.IPSSysBDTable";
    public static final String INT_PSSYSBDTABLEDE = "net.ibizsys.model.ba.IPSSysBDTableDE";
    public static final String INT_PSSYSBDTABLEOBJECT = "net.ibizsys.model.ba.IPSSysBDTableObject";
    public static final String INT_PSSYSBDTABLERS = "net.ibizsys.model.ba.IPSSysBDTableRS";
    public static final String INT_PSSYSBACKSERVICE = "net.ibizsys.model.backservice.IPSSysBackService";
    public static final String INT_PSSYSCALENDAR = "net.ibizsys.model.control.calendar.IPSSysCalendar";
    public static final String INT_PSSYSCALENDARITEM = "net.ibizsys.model.control.calendar.IPSSysCalendarItem";
    public static final String INT_PSSYSCALENDARITEMDATAITEM = "net.ibizsys.model.control.calendar.IPSSysCalendarItemDataItem";
    public static final String INT_PSSYSCALENDARITEMRV = "net.ibizsys.model.control.calendar.IPSSysCalendarItemRV";
    public static final String INT_PSSYSCALENDARPARAM = "net.ibizsys.model.control.calendar.IPSSysCalendarParam";
    public static final String INT_PSSYSCONTENT = "net.ibizsys.model.res.IPSSysContent";
    public static final String INT_PSSYSCONTENTCAT = "net.ibizsys.model.res.IPSSysContentCat";
    public static final String INT_PSSYSCOUNTER = "net.ibizsys.model.control.counter.IPSSysCounter";
    public static final String INT_PSSYSCOUNTERITEM = "net.ibizsys.model.control.counter.IPSSysCounterItem";
    public static final String INT_PSSYSCOUNTERREF = "net.ibizsys.model.control.counter.IPSSysCounterRef";
    public static final String INT_PSSYSCSS = "net.ibizsys.model.res.IPSSysCss";
    public static final String INT_PSSYSCUSTOMPORTLET = "net.ibizsys.model.res.IPSSysCustomPortlet";
    public static final String INT_PSSYSDBCOLUMN = "net.ibizsys.model.database.IPSSysDBColumn";
    public static final String INT_PSSYSDBSCHEME = "net.ibizsys.model.database.IPSSysDBScheme";
    public static final String INT_PSSYSDBSCHEMEOBJECT = "net.ibizsys.model.database.IPSSysDBSchemeObject";
    public static final String INT_PSSYSDBTABLE = "net.ibizsys.model.database.IPSSysDBTable";
    public static final String INT_PSSYSDBINDEX = "net.ibizsys.model.database.IPSSysDBIndex";
    public static final String INT_PSSYSDBINDEXCOLUMN = "net.ibizsys.model.database.IPSSysDBIndexColumn";
    public static final String INT_PSSYSDBTABLEOBJECT = "net.ibizsys.model.database.IPSSysDBTableObject";
    public static final String INT_PSSYSDBVALUEFUNC = "net.ibizsys.model.database.IPSSysDBValueFunc";
    public static final String INT_PSSYSDBVALUEFUNCCODE = "net.ibizsys.model.database.IPSSysDBValueFuncCode";
    public static final String INT_PSSYSDECHARTPORTLET = "net.ibizsys.model.res.IPSSysDEChartPortlet";
    public static final String INT_PSSYSDEEDITFORMPORTLET = "net.ibizsys.model.res.IPSSysDEEditFormPortlet";
    public static final String INT_PSSYSDEFINPUTTIP = "net.ibizsys.model.res.IPSSysDEFInputTip";
    public static final String INT_PSSYSDEFTYPE = "net.ibizsys.model.dataentity.defield.IPSSysDEFType";
    public static final String INT_PSSYSDELISTPORTLET = "net.ibizsys.model.res.IPSSysDEListPortlet";
    public static final String INT_PSSYSDESEARCHFORMPORTLET = "net.ibizsys.model.res.IPSSysDESearchFormPortlet";
    public static final String INT_PSSYSDEVIEWPORTLET = "net.ibizsys.model.res.IPSSysDEViewPortlet";
    public static final String INT_PSSYSDMITEM = "net.ibizsys.model.database.IPSSysDMItem";
    public static final String INT_PSSYSDMITEMBASE = "net.ibizsys.model.database.IPSSysDMItemBase";
    public static final String INT_PSSYSDMVER = "net.ibizsys.model.database.IPSSysDMVer";
    public static final String INT_PSSYSDTSQUEUE = "net.ibizsys.model.dts.IPSSysDTSQueue";
    public static final String INT_PSSYSDASHBOARD = "net.ibizsys.model.control.dashboard.IPSSysDashboard";
    public static final String INT_PSSYSDASHBOARDPARAM = "net.ibizsys.model.control.dashboard.IPSSysDashboardParam";
    public static final String INT_PSSYSDATAAUDITUTIL = "net.ibizsys.model.util.IPSSysDataAuditUtil";
    public static final String INT_PSSYSDATASYNCAGENT = "net.ibizsys.model.res.IPSSysDataSyncAgent";
    public static final String INT_PSSYSDICTCAT = "net.ibizsys.model.res.IPSSysDictCat";
    public static final String INT_PSSYSDYNAMODEL = "net.ibizsys.model.dynamodel.IPSSysDynaModel";
    public static final String INT_PSSYSDYNAMODELATTR = "net.ibizsys.model.dynamodel.IPSSysDynaModelAttr";
    public static final String INT_PSSYSERMAP = "net.ibizsys.model.er.IPSSysERMap";
    public static final String INT_PSSYSERMAPNODE = "net.ibizsys.model.er.IPSSysERMapNode";
    public static final String INT_PSSYSEDITORSTYLE = "net.ibizsys.model.res.IPSSysEditorStyle";
    public static final String INT_PSSYSENGINECONFIG = "net.ibizsys.model.IPSSysEngineConfig";
    public static final String INT_PSSYSFILE = "net.ibizsys.model.res.IPSSysFile";
    public static final String INT_PSSYSFILEUTIL = "net.ibizsys.model.util.IPSSysFileUtil";
    public static final String INT_PSSYSUCMAP = "net.ibizsys.model.uml.IPSSysUCMap";
    public static final String INT_PSSYSUCMAPNODE = "net.ibizsys.model.uml.IPSSysUCMapNode";
    public static final String INT_PSSYSHTMLPORTLET = "net.ibizsys.model.res.IPSSysHtmlPortlet";
    public static final String INT_PSSYSIMAGE = "net.ibizsys.model.res.IPSSysImage";
    public static final String INT_PSSYSLAN = "net.ibizsys.model.res.IPSSysLan";
    public static final String INT_PSSYSI18N = "net.ibizsys.model.res.IPSSysI18N";
    public static final String INT_PSSYSLAYOUTPANEL = "net.ibizsys.model.control.panel.IPSSysLayoutPanel";
    public static final String INT_PSSYSLOGIC = "net.ibizsys.model.res.IPSSysLogic";
    public static final String INT_PSSYSMAP = "net.ibizsys.model.control.map.IPSSysMap";
    public static final String INT_PSSYSMAPITEM = "net.ibizsys.model.control.map.IPSSysMapItem";
    public static final String INT_PSSYSMAPITEMDATAITEM = "net.ibizsys.model.control.map.IPSSysMapItemDataItem";
    public static final String INT_PSSYSMAPPARAM = "net.ibizsys.model.control.map.IPSSysMapParam";
    public static final String INT_PSSYSMODELGROUP = "net.ibizsys.model.system.IPSSysModelGroup";
    public static final String INT_PSSYSMSGTEMPL = "net.ibizsys.model.msg.IPSSysMsgTempl";
    public static final String INT_PSSYSPDTVIEW = "net.ibizsys.model.res.IPSSysPDTView";
    public static final String INT_PSSYSPFPLUGIN = "net.ibizsys.model.res.IPSSysPFPlugin";
    public static final String INT_PSSYSPFPLUGINTEMPL = "net.ibizsys.model.res.IPSSysPFPluginTempl";
    public static final String INT_PSSYSPFUSERCODE = "net.ibizsys.model.pub.IPSSysPFUserCode";
    public static final String INT_PSSYSPANEL = "net.ibizsys.model.control.panel.IPSSysPanel";
    public static final String INT_PSSYSPANELBUTTON = "net.ibizsys.model.control.panel.IPSSysPanelButton";
    public static final String INT_PSSYSPANELBUTTONLIST = "net.ibizsys.model.control.panel.IPSSysPanelButtonList";
    public static final String INT_PSSYSPANELCONTAINER = "net.ibizsys.model.control.panel.IPSSysPanelContainer";
    public static final String INT_PSSYSPANELCONTROL = "net.ibizsys.model.control.panel.IPSSysPanelControl";
    public static final String INT_PSSYSPANELCTRL = "net.ibizsys.model.control.panel.IPSSysPanelCtrl";
    public static final String INT_PSSYSPANELCTRLPOS = "net.ibizsys.model.control.panel.IPSSysPanelCtrlPos";
    public static final String INT_PSSYSPANELDATAITEM = "net.ibizsys.model.control.panel.IPSSysPanelDataItem";
    public static final String INT_PSSYSPANELFIELD = "net.ibizsys.model.control.panel.IPSSysPanelField";
    public static final String INT_PSSYSPANELHANDLER = "net.ibizsys.model.control.panel.IPSSysPanelHandler";
    public static final String INT_PSSYSPANELITEM = "net.ibizsys.model.control.panel.IPSSysPanelItem";
    public static final String INT_PSSYSPANELITEMPARAM = "net.ibizsys.model.control.panel.IPSSysPanelItemParam";
    public static final String INT_PSSYSPANELLOGIC = "net.ibizsys.model.control.panel.IPSSysPanelLogic";
    public static final String INT_PSSYSPANELLOGIC2 = "net.ibizsys.model.control.panel.IPSSysPanelLogic2";
    public static final String INT_PSSYSPANELMODEL = "net.ibizsys.model.control.panel.IPSSysPanelModel";
    public static final String INT_PSSYSPANELPARAM = "net.ibizsys.model.control.panel.IPSSysPanelParam";
    public static final String INT_PSSYSPANELRAWITEM = "net.ibizsys.model.control.panel.IPSSysPanelRawItem";
    public static final String INT_PSSYSPANELTABPAGE = "net.ibizsys.model.control.panel.IPSSysPanelTabPage";
    public static final String INT_PSSYSPANELTABPANEL = "net.ibizsys.model.control.panel.IPSSysPanelTabPanel";
    public static final String INT_PSSYSPANELUSERCONTROL = "net.ibizsys.model.control.panel.IPSSysPanelUserControl";
    public static final String INT_PSSYSPORTLET = "net.ibizsys.model.res.IPSSysPortlet";
    public static final String INT_PSSYSPORTLETCAT = "net.ibizsys.model.res.IPSSysPortletCat";
    public static final String INT_PSSYSPUBRUNTIME = "net.ibizsys.model.pub.IPSSysPubRuntime";
    public static final String INT_PSSYSREF = "net.ibizsys.model.system.IPSSysRef";
    public static final String INT_PSSYSREFMAVENREPO = "net.ibizsys.model.system.IPSSysRefMavenRepo";
    public static final String INT_PSSYSREQITEM = "net.ibizsys.model.requirement.IPSSysReqItem";
    public static final String INT_PSSYSRESOURCE = "net.ibizsys.model.res.IPSSysResource";
    public static final String INT_PSSYSRUNSESSION = "net.ibizsys.model.deploy.IPSSysRunSession";
    public static final String INT_PSSYSSFPLUGIN = "net.ibizsys.model.res.IPSSysSFPlugin";
    public static final String INT_PSSYSSFPLUGINTEMPL = "net.ibizsys.model.res.IPSSysSFPluginTempl";
    public static final String INT_PSSYSSFPUB = "net.ibizsys.model.pub.IPSSysSFPub";
    public static final String INT_PSSYSSFPUBOBJECT = "net.ibizsys.model.pub.IPSSysSFPubObject";
    public static final String INT_PSSYSSFPUBPKG = "net.ibizsys.model.pub.IPSSysSFPubPkg";
    public static final String INT_PSSYSSFUSERCODE = "net.ibizsys.model.pub.IPSSysSFUserCode";
    public static final String INT_PSSYSSAMPLEVALUE = "net.ibizsys.model.res.IPSSysSampleValue";
    public static final String INT_PSSYSSEARCHBAR = "net.ibizsys.model.control.searchbar.IPSSysSearchBar";
    public static final String INT_PSSYSSEARCHBARGROUP = "net.ibizsys.model.control.searchbar.IPSSysSearchBarGroup";
    public static final String INT_PSSYSSEARCHBARFILTER = "net.ibizsys.model.control.searchbar.IPSSysSearchBarFilter";
    public static final String INT_PSSYSSEARCHBARQUICKSEARCH = "net.ibizsys.model.control.searchbar.IPSSysSearchBarQuickSearch";
    public static final String INT_PSSYSSEARCHBARITEM = "net.ibizsys.model.control.searchbar.IPSSysSearchBarItem";
    public static final String INT_PSSYSSEARCHBAROBJECT = "net.ibizsys.model.control.searchbar.IPSSysSearchBarObject";
    public static final String INT_PSSYSSEARCHBARPARAM = "net.ibizsys.model.control.searchbar.IPSSysSearchBarParam";
    public static final String INT_PSSYSSEARCHDE = "net.ibizsys.model.search.IPSSysSearchDE";
    public static final String INT_PSSYSSEARCHDEFIELD = "net.ibizsys.model.search.IPSSysSearchDEField";
    public static final String INT_PSSYSSEARCHDEOBJECT = "net.ibizsys.model.search.IPSSysSearchDEObject";
    public static final String INT_PSSYSSEARCHDOC = "net.ibizsys.model.search.IPSSysSearchDoc";
    public static final String INT_PSSYSSEARCHDOCOBJECT = "net.ibizsys.model.search.IPSSysSearchDocObject";
    public static final String INT_PSSYSSEARCHFIELD = "net.ibizsys.model.search.IPSSysSearchField";
    public static final String INT_PSSYSSEARCHSCHEME = "net.ibizsys.model.search.IPSSysSearchScheme";
    public static final String INT_PSSYSSEARCHSCHEMEOBJECT = "net.ibizsys.model.search.IPSSysSearchSchemeObject";
    public static final String INT_PSSYSSERVICEAPI = "net.ibizsys.model.service.IPSSysServiceAPI";
    public static final String INT_PSSYSSERVICEAPIHANDLER = "net.ibizsys.model.service.IPSSysServiceAPIHandler";
    public static final String INT_PSSYSTESTCASE = "net.ibizsys.model.testing.IPSSysTestCase";
    public static final String INT_PSSYSTESTCASE2 = "net.ibizsys.model.testing.IPSSysTestCase2";
    public static final String INT_PSSYSTESTCASEASSERT = "net.ibizsys.model.testing.IPSSysTestCaseAssert";
    public static final String INT_PSSYSTESTCASEINPUT = "net.ibizsys.model.testing.IPSSysTestCaseInput";
    public static final String INT_PSSYSTESTDATA = "net.ibizsys.model.testing.IPSSysTestData";
    public static final String INT_PSSYSTESTDATAINST = "net.ibizsys.model.testing.IPSSysTestDataInst";
    public static final String INT_PSSYSTESTDATAITEM = "net.ibizsys.model.testing.IPSSysTestDataItem";
    public static final String INT_PSSYSTESTMODULE = "net.ibizsys.model.testing.IPSSysTestModule";
    public static final String INT_PSSYSTESTPRJ = "net.ibizsys.model.testing.IPSSysTestPrj";
    public static final String INT_PSSYSTITLEBAR = "net.ibizsys.model.control.titlebar.IPSSysTitleBar";
    public static final String INT_PSSYSUNIRES = "net.ibizsys.model.security.IPSSysUniRes";
    public static final String INT_PSSYSUNISTATE = "net.ibizsys.model.res.IPSSysUniState";
    public static final String INT_PSSYSUNIT = "net.ibizsys.model.res.IPSSysUnit";
    public static final String INT_PSSYSUSECASE = "net.ibizsys.model.uml.IPSSysUseCase";
    public static final String INT_PSSYSUSECASERS = "net.ibizsys.model.uml.IPSSysUseCaseRS";
    public static final String INT_PSSYSUSERDR = "net.ibizsys.model.security.IPSSysUserDR";
    public static final String INT_PSSYSUSERMODE = "net.ibizsys.model.security.IPSSysUserMode";
    public static final String INT_PSSYSUSERROLE = "net.ibizsys.model.security.IPSSysUserRole";
    public static final String INT_PSSYSUSERROLEDATA = "net.ibizsys.model.security.IPSSysUserRoleData";
    public static final String INT_PSSYSUSERROLERES = "net.ibizsys.model.security.IPSSysUserRoleRes";
    public static final String INT_PSSYSUTIL = "net.ibizsys.model.res.IPSSysUtil";
    public static final String INT_PSSYSUTILTYPE = "net.ibizsys.model.res.IPSSysUtilType";
    public static final String INT_PSSYSVALUERULE = "net.ibizsys.model.valuerule.IPSSysValueRule";
    public static final String INT_PSSYSVIEWLAYOUTPANEL = "net.ibizsys.model.control.panel.IPSSysViewLayoutPanel";
    public static final String INT_PSSYSVIEWLAYOUTPANELPARAM = "net.ibizsys.model.control.panel.IPSSysViewLayoutPanelParam";
    public static final String INT_PSSYSVIEWLOGIC = "net.ibizsys.model.res.IPSSysViewLogic";
    public static final String INT_PSSYSVIEWLOGICPARAM = "net.ibizsys.model.res.IPSSysViewLogicParam";
    public static final String INT_PSSYSWFSETTING = "net.ibizsys.model.wf.IPSSysWFSetting";
    public static final String INT_PSWFUTILUIACTION = "net.ibizsys.model.wf.IPSWFUtilUIAction";
    public static final String INT_PSSYSTEM = "net.ibizsys.model.IPSSystem";
    public static final String INT_PSSYSTEMCONTAINER = "net.ibizsys.model.IPSSystemContainer";
    public static final String INT_PSSYSTEMDBCONFIG = "net.ibizsys.model.database.IPSSystemDBConfig";
    public static final String INT_PSSYSTEMMODULE = "net.ibizsys.model.system.IPSSystemModule";
    public static final String INT_PSSYSTEMOBJECT = "net.ibizsys.model.IPSSystemObject";
    public static final String INT_PSSYSTEMSETTING = "net.ibizsys.model.IPSSystemSetting";
    public static final String INT_PSTABEXPPAGE = "net.ibizsys.model.control.expbar.IPSTabExpPage";
    public static final String INT_PSTABEXPPANEL = "net.ibizsys.model.control.expbar.IPSTabExpPanel";
    public static final String INT_PSTABEXPPANELPARAM = "net.ibizsys.model.control.expbar.IPSTabExpPanelParam";
    public static final String INT_PSTABLELAYOUTPOS = "net.ibizsys.model.control.layout.IPSTableLayoutPos";
    public static final String INT_PSTEXTAREA = "net.ibizsys.model.control.editor.IPSTextArea";
    public static final String INT_PSTEXTBOX = "net.ibizsys.model.control.editor.IPSTextBox";
    public static final String INT_PSTHICKNESS = "net.ibizsys.model.control.IPSThickness";
    public static final String INT_PSTITLEBAR = "net.ibizsys.model.control.titlebar.IPSTitleBar";
    public static final String INT_PSTITLEBARPARAM = "net.ibizsys.model.control.titlebar.IPSTitleBarParam";
    public static final String INT_PSTREEEXPBAR = "net.ibizsys.model.control.expbar.IPSTreeExpBar";
    public static final String INT_PSTREEEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSTreeExpBarParam";
    public static final String INT_PSUIACTION = "net.ibizsys.model.view.IPSUIAction";
    public static final String INT_PSUIACTIONGROUP = "net.ibizsys.model.view.IPSUIActionGroup";
    public static final String INT_PSUIACTIONGROUPDETAIL = "net.ibizsys.model.view.IPSUIActionGroupDetail";
    public static final String INT_PSUIACTIONITEM = "net.ibizsys.model.app.view.IPSUIActionItem";
    public static final String INT_PSUIENGINE = "net.ibizsys.model.view.IPSUIEngine";
    public static final String INT_PSUIENGINEPARAM = "net.ibizsys.model.view.IPSUIEngineParam";
    public static final String INT_PSUIENGINETYPE = "net.ibizsys.model.view.IPSUIEngineType";
    public static final String INT_PSUILOGIC = "net.ibizsys.model.view.IPSUILogic";
    public static final String INT_PSUMLOBJECT = "net.ibizsys.model.uml.IPSUMLObject";
    public static final String INT_PSUPDATEPANEL = "net.ibizsys.model.control.updatepanel.IPSUpdatePanel";
    public static final String INT_PSUPDATEPANELPARAM = "net.ibizsys.model.control.updatepanel.IPSUpdatePanelParam";
    public static final String INT_PSUSERCONTROL = "net.ibizsys.model.control.IPSUserControl";
    public static final String INT_PSVALUEITEMEDITOR = "net.ibizsys.model.control.editor.IPSValueItemEditor";
    public static final String INT_PSVALUEOP = "net.ibizsys.model.data.IPSValueOP";
    public static final String INT_PSVIEWENGINE = "net.ibizsys.model.view.IPSViewEngine";
    public static final String INT_PSVIEWLAYOUTPANEL = "net.ibizsys.model.control.panel.IPSViewLayoutPanel";
    public static final String INT_PSVIEWLOGIC = "net.ibizsys.model.view.IPSViewLogic";
    public static final String INT_PSVIEWLOGICPARAM = "net.ibizsys.model.view.IPSViewLogicParam";
    public static final String INT_PSVIEWMSG = "net.ibizsys.model.view.IPSViewMsg";
    public static final String INT_PSVIEWMSGGROUP = "net.ibizsys.model.view.IPSViewMsgGroup";
    public static final String INT_PSVIEWMSGGROUPDETAIL = "net.ibizsys.model.view.IPSViewMsgGroupDetail";
    public static final String INT_PSVIEWTYPE = "net.ibizsys.model.view.IPSViewType";
    public static final String INT_PSVIEWWIZARDGROUP = "net.ibizsys.model.view.IPSViewWizardGroup";
    public static final String INT_PSWFCALLACTIVITYPROCESS = "net.ibizsys.model.wf.IPSWFCallActivityProcess";
    public static final String INT_PSWFCALLORGACTIVITYPROCESS = "net.ibizsys.model.wf.IPSWFCallOrgActivityProcess";
    public static final String INT_PSWFDEACTIONPROCESS = "net.ibizsys.model.wf.IPSWFDEActionProcess";
    public static final String INT_PSWFDEDATASETROLE = "net.ibizsys.model.wf.IPSWFDEDataSetRole";
    public static final String INT_PSWFEDITFORM = "net.ibizsys.model.control.form.IPSWFEditForm";
    public static final String INT_PSWFEMBEDWFPROCESS = "net.ibizsys.model.wf.IPSWFEmbedWFProcess";
    public static final String INT_PSWFEMBEDWFPROCESSBASE = "net.ibizsys.model.wf.IPSWFEmbedWFProcessBase";
    public static final String INT_PSWFEMBEDWFRETURNLINK = "net.ibizsys.model.wf.IPSWFEmbedWFReturnLink";
    public static final String INT_PSWFENDPROCESS = "net.ibizsys.model.wf.IPSWFEndProcess";
    public static final String INT_PSWFEXCLUSIVEGATEWAYPROCESS = "net.ibizsys.model.wf.IPSWFExclusiveGatewayProcess";
    public static final String INT_PSWFEXPBAR = "net.ibizsys.model.control.expbar.IPSWFExpBar";
    public static final String INT_PSWFEXPBARPARAM = "net.ibizsys.model.control.expbar.IPSWFExpBarParam";
    public static final String INT_PSWFGATEWAYPROCESSBASE = "net.ibizsys.model.wf.IPSWFGatewayProcessBase";
    public static final String INT_PSWFINCLUSIVEGATEWAYPROCESS = "net.ibizsys.model.wf.IPSWFInclusiveGatewayProcess";
    public static final String INT_PSWFINTERACTIVELINK = "net.ibizsys.model.wf.IPSWFInteractiveLink";
    public static final String INT_PSWFINTERACTIVEPROCESS = "net.ibizsys.model.wf.IPSWFInteractiveProcess";
    public static final String INT_PSWFLINK = "net.ibizsys.model.wf.IPSWFLink";
    public static final String INT_PSWFLINKCOND = "net.ibizsys.model.wf.IPSWFLinkCond";
    public static final String INT_PSWFLINKCUSTOMCOND = "net.ibizsys.model.wf.IPSWFLinkCustomCond";
    public static final String INT_PSWFLINKGROUPCOND = "net.ibizsys.model.wf.IPSWFLinkGroupCond";
    public static final String INT_PSWFLINKSINGLECOND = "net.ibizsys.model.wf.IPSWFLinkSingleCond";
    public static final String INT_PSWFPARALLELGATEWAYPROCESS = "net.ibizsys.model.wf.IPSWFParallelGatewayProcess";
    public static final String INT_PSWFPARALLELSUBWFPROCESS = "net.ibizsys.model.wf.IPSWFParallelSubWFProcess";
    public static final String INT_PSWFPROCESS = "net.ibizsys.model.wf.IPSWFProcess";
    public static final String INT_PSWFPROCESSPARAM = "net.ibizsys.model.wf.IPSWFProcessParam";
    public static final String INT_PSWFPROCESSROLE = "net.ibizsys.model.wf.IPSWFProcessRole";
    public static final String INT_PSWFLINKROLE = "net.ibizsys.model.wf.IPSWFLinkRole";
    public static final String INT_PSWFPROCESSSUBWF = "net.ibizsys.model.wf.IPSWFProcessSubWF";
    public static final String INT_PSWFROLE = "net.ibizsys.model.wf.IPSWFRole";
    public static final String INT_PSWFROUTELINK = "net.ibizsys.model.wf.IPSWFRouteLink";
    public static final String INT_PSWFSTARTPROCESS = "net.ibizsys.model.wf.IPSWFStartProcess";
    public static final String INT_PSWFTIMEOUTLINK = "net.ibizsys.model.wf.IPSWFTimeoutLink";
    public static final String INT_PSWFTIMEREVENTPROCESS = "net.ibizsys.model.wf.IPSWFTimerEventProcess";
    public static final String INT_PSWFUIACTION = "net.ibizsys.model.wf.uiaction.IPSWFUIAction";
    public static final String INT_PSWFUIACTIONGROUP = "net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup";
    public static final String INT_PSWFUIACTIONGROUPDETAIL = "net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail";
    public static final String INT_PSWFUIACTIONITEM = "net.ibizsys.model.app.view.IPSWFUIActionItem";
    public static final String INT_PSWFVERSION = "net.ibizsys.model.wf.IPSWFVersion";
    public static final String INT_PSWXACCOUNT = "net.ibizsys.model.wx.IPSWXAccount";
    public static final String INT_PSWXACCOUNTOBJECT = "net.ibizsys.model.wx.IPSWXAccountObject";
    public static final String INT_PSWXENTAPP = "net.ibizsys.model.wx.IPSWXEntApp";
    public static final String INT_PSWXLOGIC = "net.ibizsys.model.wx.IPSWXLogic";
    public static final String INT_PSWXMENU = "net.ibizsys.model.wx.IPSWXMenu";
    public static final String INT_PSWXMENUFUNC = "net.ibizsys.model.wx.IPSWXMenuFunc";
    public static final String INT_PSWXMENUITEM = "net.ibizsys.model.wx.IPSWXMenuItem";
    public static final String INT_PSWIZARDPANEL = "net.ibizsys.model.control.wizardpanel.IPSWizardPanel";
    public static final String INT_PSWIZARDPANELITEM = "net.ibizsys.model.control.wizardpanel.IPSWizardPanelItem";
    public static final String INT_PSWIZARDPANELPARAM = "net.ibizsys.model.control.wizardpanel.IPSWizardPanelParam";
    public static final String INT_PSWORKFLOW = "net.ibizsys.model.wf.IPSWorkflow";
    public static final String INT_PSWORKFLOWOBJECT = "net.ibizsys.model.wf.IPSWorkflowObject";
    public static final String INT_PSWORKSPACE = "net.ibizsys.model.workspace.IPSWorkspace";
    public static final String INT_PSXCODEOBJECT = "net.ibizsys.model.pub.IPSXCodeObject";
    public static final String INT_PSDETREEGRIDEX = "net.ibizsys.model.control.tree.IPSDETreeGridEx";
    public static final String INT_PSDEGANTT = "net.ibizsys.model.control.tree.IPSDEGantt";
    public static final String INT_PSWFWORKTIME = "net.ibizsys.model.wf.IPSWFWorkTime";
    public static final String INT_PSDEGRIDEDITITEMVR = "net.ibizsys.model.control.grid.IPSDEGridEditItemVR";
    public static final String INT_PSDEKANBAN = "net.ibizsys.model.control.dataview.IPSDEKanban";
    public static final String INT_PSNAVIGATECONTEXT = "net.ibizsys.model.control.IPSNavigateContext";
    public static final String INT_PSNAVIGATEPARAM = "net.ibizsys.model.control.IPSNavigateParam";
    public static final String INT_PSUIACTIONPARAM = "net.ibizsys.model.view.IPSUIActionParam";
    public static final String INT_PSDEMETHOD = "net.ibizsys.model.dataentity.service.IPSDEMethod";
    public static final String INT_PSDEACTIONMETHOD = "net.ibizsys.model.dataentity.service.IPSDEActionMethod";
    public static final String INT_PSDEDATASETMETHOD = "net.ibizsys.model.dataentity.service.IPSDEDataSetMethod";
    public static final String INT_PSDESTATEWIZARDPANEL = "net.ibizsys.model.control.wizardpanel.IPSDEStateWizardPanel";
    public static final String INT_PSAPPPFPLUGINREF = "net.ibizsys.model.app.res.IPSAppPFPluginRef";
    public static final String INT_PSAPPEDITORSTYLEREF = "net.ibizsys.model.app.res.IPSAppEditorStyleRef";
    public static final String INT_PSAPPSUBVIEWTYPEREF = "net.ibizsys.model.app.res.IPSAppSubViewTypeRef";
    public static final String INT_PSSYSSEQUENCE = "net.ibizsys.model.res.IPSSysSequence";
    public static final String INT_PSSYSTRANSLATOR = "net.ibizsys.model.res.IPSSysTranslator";
    public static final String INT_PSSYSMSGQUEUE = "net.ibizsys.model.msg.IPSSysMsgQueue";
    public static final String INT_PSSYSMSGTARGET = "net.ibizsys.model.msg.IPSSysMsgTarget";
    public static final String INT_PSSYSMETHODDTO = "net.ibizsys.model.service.IPSSysMethodDTO";
    public static final String INT_PSSYSMETHODDTOFIELD = "net.ibizsys.model.service.IPSSysMethodDTOField";
    public static final String INT_PSAPPMETHODDTO = "net.ibizsys.model.app.IPSAppMethodDTO";
    public static final String INT_PSAPPMETHODDTOFIELD = "net.ibizsys.model.app.IPSAppMethodDTOField";
    public static final String INT_PSAPPDEREPORT = "net.ibizsys.model.app.dataentity.IPSAppDEReport";
    public static final String INT_PSAPPDEREPITEM = "net.ibizsys.model.app.dataentity.IPSAppDEReportItem";
    public static final String INT_PSDEDATASETPARAM = "net.ibizsys.model.dataentity.ds.IPSDEDataSetParam";
    public static final String INT_PSDEGRIDLOGIC = "net.ibizsys.model.control.grid.IPSDEGridLogic";
    public static final String INT_PSDETREELOGIC = "net.ibizsys.model.control.tree.IPSDETreeLogic";
    public static final String INT_PSAPPLOGIC = "net.ibizsys.model.app.IPSAppLogic";
    public static final String INT_PSDEFORMLOGIC = "net.ibizsys.model.control.form.IPSDEFormLogic";
    public static final String INT_PSDEDATAVIEWLOGIC = "net.ibizsys.model.control.dataview.IPSDEDataViewLogic";
    public static final String INT_PSDELISTLOGIC = "net.ibizsys.model.control.list.IPSDEListLogic";
    public static final String INT_PSDEWIZARDLOGIC = "net.ibizsys.model.dataentity.wizard.IPSDEWizardLogic";
    public static final String INT_PSDECHARTLOGIC = "net.ibizsys.model.control.chart.IPSDEChartLogic";
    public static final String INT_PSDETOOLBARLOGIC = "net.ibizsys.model.control.toolbar.IPSDEToolbarLogic";
    public static final String INT_PSSYSCALENDARLOGIC = "net.ibizsys.model.control.calendar.IPSSysCalendarLogic";
    public static final String INT_PSSYSDASHBOARDLOGIC = "net.ibizsys.model.control.dashboard.IPSSysDashboardLogic";
    public static final String INT_PSSYSMAPLOGIC = "net.ibizsys.model.control.map.IPSSysMapLogic";
    public static final String INT_PSSYSSEARCHBARLOGIC = "net.ibizsys.model.control.searchbar.IPSSysSearchBarLogic";
    public static final String INT_PSAPPMENULOGIC = "net.ibizsys.model.control.menu.IPSAppMenuLogic";
    public static final String INT_PSDEDRLOGIC = "net.ibizsys.model.dataentity.dr.IPSDEDRLogic";
    public static final String INT_PSCONTROLRENDER = "net.ibizsys.model.control.IPSControlRender";
    public static final String INT_PSCONTROLATTRIBUTE = "net.ibizsys.model.control.IPSControlAttribute";
    public static final String INT_PSAPPDEMAP = "net.ibizsys.model.app.dataentity.IPSAppDEMap";
    public static final String INT_PSAPPDEMAPFIELD = "net.ibizsys.model.app.dataentity.IPSAppDEMapField";
    public static final String PSDATAENTITY = "PSDATAENTITY";
    public static final String PSSYSTEM = "PSSYSTEM";
    public static final String PSDEFIELD = "PSDEFIELD";
    public static final String PSAPPVIEW = "PSAPPVIEW";
    public static final String PSCODELIST = "PSCODELIST";
    public static final String PSDEACMODE = "PSDEACMODE";
    public static final String PSWORKFLOW = "PSWORKFLOW";
    public static final String PSWFVERSION = "PSWFVERSION";
    public static final String PSWFROLE = "PSWFROLE";
    public static final String PSDELOGIC = "PSDELOGIC";
    public static final String PSDEDATAQUERY = "PSDEDATAQUERY";
    public static final String PSDEDATASET = "PSDEDATASET";
    public static final String PSSYSAPP = "PSSYSAPP";
    public static final String PSDEPRINT = "PSDEPRINT";
    public static final String PSDEREPORT = "PSDEREPORT";
    public static final String PSPFPKGCAT = "PSPFPKGCAT";
    public static final String PSCPVISSUE = "PSCPVISSUE";
    public static final String PSAPPVIEWTEMPL = "PSAPPVIEWTEMPL";
    public static final String PSDCSFPKGVER = "PSDCSFPKGVER";
    public static final String PSSYSUIACTION = "PSSYSUIACTION";
    public static final String PSMODELSFCODE = "PSMODELSFCODE";
    public static final String PSDEPSLN = "PSDEPSLN";
    public static final String PSDELOGICLINK = "PSDELOGICLINK";
    public static final String PSDEVSLNSYSTS = "PSDEVSLNSYSTS";
    public static final String PSPFCTRLTEMPL = "PSPFCTRLTEMPL";
    public static final String PSSYSCTRLSTYLE = "PSSYSCTRLSTYLE";
    public static final String PSSYSTEMAS = "PSSYSTEMAS";
    public static final String PSDEDATARELATION = "PSDEDATARELATION";
    public static final String PSSFCODETYPE = "PSSFCODETYPE";
    public static final String PSSYSBACKSERVICE = "PSSYSBACKSERVICE";
    public static final String PSMODELAPIMETHOD = "PSMODELAPIMETHOD";
    public static final String PSPFSTYLELOG = "PSPFSTYLELOG";
    public static final String PSSYSRUNSESSION = "PSSYSRUNSESSION";
    public static final String PSSFACHANDLER = "PSSFACHANDLER";
    public static final String PSSYSDSACTION = "PSSYSDSACTION";
    public static final String PSDEFDTCOL = "PSDEFDTCOL";
    public static final String PSPORTLETTYPE = "PSPORTLETTYPE";
    public static final String PSDEAWITEM = "PSDEAWITEM";
    public static final String PSDEFVRTYPEDETAIL = "PSDEFVRTYPEDETAIL";
    public static final String PSDEVSYSDIFFITEM = "PSDEVSYSDIFFITEM";
    public static final String PSDELOGICPARAM = "PSDELOGICPARAM";
    public static final String PSDEPSLNMODE = "PSDEPSLNMODE";
    public static final String PSSYSTDITEM = "PSSYSTDITEM";
    public static final String PSDEVSLNSYSVER = "PSDEVSLNSYSVER";
    public static final String PSSYSDATASYNCAGENT = "PSSYSDATASYNCAGENT";
    public static final String PSSYSPOLICYMODEL = "PSSYSPOLICYMODEL";
    public static final String PSDEMAINSTATE = "PSDEMAINSTATE";
    public static final String PSDEMAINSTATERS = "PSDEMAINSTATERS";
    public static final String PSDEDBCFG = "PSDEDBCFG";
    public static final String PSWFLINKROLE = "PSWFLINKROLE";
    public static final String PSSYSUSERCASE = "PSSYSUSERCASE";
    public static final String PSDEACTION = "PSDEACTION";
    public static final String PSDEPSLNDBINST = "PSDEPSLNDBINST";
    public static final String PSSUBDEVIEW = "PSSUBDEVIEW";
    public static final String PSAPPVIEWLOGIC = "PSAPPVIEWLOGIC";
    public static final String PSSYSSFPUBPKG = "PSSYSSFPUBPKG";
    public static final String PSLANGUAGEITEM = "PSLANGUAGEITEM";
    public static final String PSDEFVRTYPE = "PSDEFVRTYPE";
    public static final String PSSYSBDSCHEME = "PSSYSBDSCHEME";
    public static final String PSDEACMODEITEM = "PSDEACMODEITEM";
    public static final String PSFORMDETAILTYPE = "PSFORMDETAILTYPE";
    public static final String PSSYSWFSETTING = "PSSYSWFSETTING";
    public static final String PSWFUTILUIACTION = "PSWFUTILUIACTION";
    public static final String PSBDTYPE = "PSBDTYPE";
    public static final String PSDEJOINTYPE = "PSDEJOINTYPE";
    public static final String PSMQINST = "PSMQINST";
    public static final String PSDEVSLNUSER = "PSDEVSLNUSER";
    public static final String PSVALUERULE = "PSVALUERULE";
    public static final String PSDEGCTYPE = "PSDEGCTYPE";
    public static final String PSSYSOPPRIV = "PSSYSOPPRIV";
    public static final String PSPRODUCTTYPE = "PSPRODUCTTYPE";
    public static final String PSSYSWFMODE = "PSSYSWFMODE";
    public static final String PSSYSSAMPLEVALUE = "PSSYSSAMPLEVALUE";
    public static final String PSDEDATAEXP = "PSDEDATAEXP";
    public static final String PSVIEWENGINE = "PSVIEWENGINE";
    public static final String PSWXLOGIC = "PSWXLOGIC";
    public static final String PSSYSDBCHGLOG = "PSSYSDBCHGLOG";
    public static final String PSPFPKG = "PSPFPKG";
    public static final String PSPFPKGVER = "PSPFPKGVER";
    public static final String PSSYSCOUNTERITEM = "PSSYSCOUNTERITEM";
    public static final String PSDEUAGRPDETAIL = "PSDEUAGRPDETAIL";
    public static final String PSAPPDEUAGRPDETAIL = "PSAPPDEUAGRPDETAIL";
    public static final String PSSYSAPPDEUAGRPDETAIL = "PSSYSAPPDEUAGRPDETAIL";
    public static final String PSHELPSECTIONTYPE = "PSHELPSECTIONTYPE";
    public static final String PSDEACTIONLOGIC = "PSDEACTIONLOGIC";
    public static final String PSPFSTYLE = "PSPFSTYLE";
    public static final String PSAPPEDITORTEMPL = "PSAPPEDITORTEMPL";
    public static final String PSMODELHOTCODE = "PSMODELHOTCODE";
    public static final String PSSYSBDTABLE = "PSSYSBDTABLE";
    public static final String PSHELPARTSEC = "PSHELPARTSEC";
    public static final String PSVTCTRL = "PSVTCTRL";
    public static final String PSDBVALUEMODE = "PSDBVALUEMODE";
    public static final String PSAPPFUNC = "PSAPPFUNC";
    public static final String PSVIEWSTYLE = "PSVIEWSTYLE";
    public static final String PSDECHARTPARAM = "PSDECHARTPARAM";
    public static final String PSDEREPITEM = "PSDEREPITEM";
    public static final String PSTREENODETYPE = "PSTREENODETYPE";
    public static final String PSCSSTEMPL = "PSCSSTEMPL";
    public static final String PSDEFINPUTTIP = "PSDEFINPUTTIP";
    public static final String PSV3MIGRATEDE = "PSV3MIGRATEDE";
    public static final String PSPFSTYLEPRJ = "PSPFSTYLEPRJ";
    public static final String PSASBOOKINGLOG = "PSASBOOKINGLOG";
    public static final String PSSYSACHANDLER = "PSSYSACHANDLER";
    public static final String PSSYSMSGTEMPL = "PSSYSMSGTEMPL";
    public static final String PSCODEITEM = "PSCODEITEM";
    public static final String PSFDLOGICTYPE = "PSFDLOGICTYPE";
    public static final String PSWXENTAPP = "PSWXENTAPP";
    public static final String PSSUBDE = "PSSUBDE";
    public static final String PSDEUIACTIONTYPE = "PSDEUIACTIONTYPE";
    public static final String PSVIEWTYPECAT = "PSVIEWTYPECAT";
    public static final String PSSFCONFIG = "PSSFCONFIG";
    public static final String PSV3MGGRID = "PSV3MGGRID";
    public static final String PSCOREPRDFUNC = "PSCOREPRDFUNC";
    public static final String PSSYSUNIT = "PSSYSUNIT";
    public static final String PSPDTAPPFUNC = "PSPDTAPPFUNC";
    public static final String PSDEVIEWRV = "PSDEVIEWRV";
    public static final String PSSYSDICTCAT = "PSSYSDICTCAT";
    public static final String PSTASKSERVER = "PSTASKSERVER";
    public static final String PSVIEWTYPELOGIC = "PSVIEWTYPELOGIC";
    public static final String PSAPPUITHEME = "PSAPPUITHEME";
    public static final String PSAPPLAN = "PSAPPLAN";
    public static final String PSSYSLAN = "PSSYSLAN";
    public static final String PSSYSI18N = "PSSYSI18N";
    public static final String PSDEFSFITEM = "PSDEFSFITEM";
    public static final String PSHELPMODART = "PSHELPMODART";
    public static final String PSDCBKTASK = "PSDCBKTASK";
    public static final String PSDCDBPROC = "PSDCDBPROC";
    public static final String PSV3MGVIEW = "PSV3MGVIEW";
    public static final String PSSVNINSTREPO = "PSSVNINSTREPO";
    public static final String PSAPPPKG = "PSAPPPKG";
    public static final String PSASTYPE = "PSASTYPE";
    public static final String PSDEDSDQ = "PSDEDSDQ";
    public static final String PSDBSPPARTTEMPL = "PSDBSPPARTTEMPL";
    public static final String PSSYSDEVBKTASK = "PSSYSDEVBKTASK";
    public static final String PSDETBITEM = "PSDETBITEM";
    public static final String PSDEPSLNMODEPRD = "PSDEPSLNMODEPRD";
    public static final String PSDEVSLNSYS = "PSDEVSLNSYS";
    public static final String PSSYSVALUERULE = "PSSYSVALUERULE";
    public static final String PSSYSPFPITEMPL = "PSSYSPFPITEMPL";
    public static final String PSDEVRGRPDETAIL = "PSDEVRGRPDETAIL";
    public static final String PSAPPCTRLSTYLE = "PSAPPCTRLSTYLE";
    public static final String PSROSSERVER = "PSROSSERVER";
    public static final String PSDEDRITEM = "PSDEDRITEM";
    public static final String PSDEACTIONTYPE = "PSDEACTIONTYPE";
    public static final String PSCOREPRDVER = "PSCOREPRDVER";
    public static final String PSPFVIEWTEMPL = "PSPFVIEWTEMPL";
    public static final String PSSYSTASK = "PSSYSTASK";
    public static final String PSVTSAMPLE = "PSVTSAMPLE";
    public static final String PSDBVFCODE = "PSDBVFCODE";
    public static final String PSDELNPARAM = "PSDELNPARAM";
    public static final String PSSVRSERVER = "PSSVRSERVER";
    public static final String PSDECHARTAXES = "PSDECHARTAXES";
    public static final String PSUNKNOWN = "PSUNKNOWN";
    public static final String PSTASKSERVERLOG = "PSTASKSERVERLOG";
    public static final String PSSUBSYSSADETAIL = "PSSUBSYSSADETAIL";
    public static final String PSSVRDOMAIN = "PSSVRDOMAIN";
    public static final String PSHELPRESOURCE = "PSHELPRESOURCE";
    public static final String PSAPPUSERMODE = "PSAPPUSERMODE";
    public static final String PSDERDEFMAP = "PSDERDEFMAP";
    public static final String PSCTRLMSGITEM = "PSCTRLMSGITEM";
    public static final String PSDEVCENTERDBINST = "PSDEVCENTERDBINST";
    public static final String PSHELPARTICLETEMPL = "PSHELPARTICLETEMPL";
    public static final String PSCODELISTTEMPL = "PSCODELISTTEMPL";
    public static final String PSSFSTYLECODE = "PSSFSTYLECODE";
    public static final String PSPDTVIEW = "PSPDTVIEW";
    public static final String PSDEFVRDSPARAM = "PSDEFVRDSPARAM";
    public static final String PSDEVCENTERMQ = "PSDEVCENTERMQ";
    public static final String PSDESPCODEPART = "PSDESPCODEPART";
    public static final String PSDEVCENTERTS = "PSDEVCENTERTS";
    public static final String PSSYSUSERDR = "PSSYSUSERDR";
    public static final String PSSYSOUTYPE = "PSSYSOUTYPE";
    public static final String PSV3MIGRATE = "PSV3MIGRATE";
    public static final String PSSFSTYLE = "PSSFSTYLE";
    public static final String PSSYSDEVINFOTYPE = "PSSYSDEVINFOTYPE";
    public static final String PSSYSTCINPUT = "PSSYSTCINPUT";
    public static final String PSSYSTCINPUT2 = "PSSYSTCINPUT2";
    public static final String PSSYSTCASSERT = "PSSYSTCASSERT";
    public static final String PSSYSTCASSERT2 = "PSSYSTCASSERT2";
    public static final String PSDATASYNCAGENTTYPE = "PSDATASYNCAGENTTYPE";
    public static final String PSSYSLANITEM = "PSSYSLANITEM";
    public static final String PSDEDSCODE = "PSDEDSCODE";
    public static final String PSDCPRODUCT = "PSDCPRODUCT";
    public static final String PSDEDQPDCOND = "PSDEDQPDCOND";
    public static final String PSSYSISSUEENGINE = "PSSYSISSUEENGINE";
    public static final String PSDCSFPKG = "PSDCSFPKG";
    public static final String PSDEVUSER = "PSDEVUSER";
    public static final String PSMIDETAIL = "PSMIDETAIL";
    public static final String PSDEPSLNPRD = "PSDEPSLNPRD";
    public static final String PSAPPFUNCTYPE = "PSAPPFUNCTYPE";
    public static final String PSPFPLUGINTYPE = "PSPFPLUGINTYPE";
    public static final String PSEDITORTYPE = "PSEDITORTYPE";
    public static final String PSSVRPROVIDER = "PSSVRPROVIDER";
    public static final String PSDCBKTYPE = "PSDCBKTYPE";
    public static final String PSMODELRS = "PSMODELRS";
    public static final String PSWFSUBWF = "PSWFSUBWF";
    public static final String PSDEFDATATYPE = "PSDEFDATATYPE";
    public static final String PSDEFVRCODETYPE = "PSDEFVRCODETYPE";
    public static final String PSSFSTYLELOG = "PSSFSTYLELOG";
    public static final String PSDESPFIELD = "PSDESPFIELD";
    public static final String PSPFSTYLEPKG = "PSPFSTYLEPKG";
    public static final String PSMODELREF = "PSMODELREF";
    public static final String PSHELPSECTIONTEMPL = "PSHELPSECTIONTEMPL";
    public static final String PSDEFFORMITEM = "PSDEFFORMITEM";
    public static final String PSSYSREQMODULE = "PSSYSREQMODULE";
    public static final String PSDRITEMTYPE = "PSDRITEMTYPE";
    public static final String PSSYSDEVBTTYPE = "PSSYSDEVBTTYPE";
    public static final String PSSUBSYSSERVICEAPI = "PSSUBSYSSERVICEAPI";
    public static final String PSDCSYSPRODUCT = "PSDCSYSPRODUCT";
    public static final String PSDECTRL = "PSDECTRL";
    public static final String PSDEPSLNRUNLOG = "PSDEPSLNRUNLOG";
    public static final String PSSYSBDPART = "PSSYSBDPART";
    public static final String PSSYSTOOLBAR = "PSSYSTOOLBAR";
    public static final String PSDEDRGROUP = "PSDEDRGROUP";
    public static final String PSDEDQCOND = "PSDEDQCOND";
    public static final String PSCPVFUNC = "PSCPVFUNC";
    public static final String PSDEFGRIDCOL = "PSDEFGRIDCOL";
    public static final String PSDCDBFUNC = "PSDCDBFUNC";
    public static final String PSDEFIUDETAIL = "PSDEFIUDETAIL";
    public static final String PSWXMENUITEM = "PSWXMENUITEM";
    public static final String PSDEVRGROUP = "PSDEVRGROUP";
    public static final String PSDEVSLNSYSKEY = "PSDEVSLNSYSKEY";
    public static final String PSDEVCENTERRES = "PSDEVCENTERRES";
    public static final String PSCTRLTYPEACTION = "PSCTRLTYPEACTION";
    public static final String PSSUBSYSDM = "PSSUBSYSDM";
    public static final String PSDEVUSERRECENT = "PSDEVUSERRECENT";
    public static final String PSSYSTEMDBCFG = "PSSYSTEMDBCFG";
    public static final String PSSYSPRDVER = "PSSYSPRDVER";
    public static final String PSWXMENU = "PSWXMENU";
    public static final String PSSAMPLEVALUE = "PSSAMPLEVALUE";
    public static final String PSBDSERVER = "PSBDSERVER";
    public static final String PSWXACCOUNT = "PSWXACCOUNT";
    public static final String PSSYSDMITEM = "PSSYSDMITEM";
    public static final String PSSYSTASKDATA = "PSSYSTASKDATA";
    public static final String PSWFPROCPARAM = "PSWFPROCPARAM";
    public static final String PSWFPROCROLE = "PSWFPROCROLE";
    public static final String PSDEVENV = "PSDEVENV";
    public static final String PSDELISTITEM = "PSDELISTITEM";
    public static final String PSSYSSFCODE = "PSSYSSFCODE";
    public static final String PSDESYSPROC = "PSDESYSPROC";
    public static final String PSSYSMODELVER = "PSSYSMODELVER";
    public static final String PSSFPKGCAT = "PSSFPKGCAT";
    public static final String PSHELPPRJ = "PSHELPPRJ";
    public static final String PSSYSIMAGE = "PSSYSIMAGE";
    public static final String PSSUBAPP = "PSSUBAPP";
    public static final String PSBACKSERVICE = "PSBACKSERVICE";
    public static final String PSAPPVIEWSTYLE = "PSAPPVIEWSTYLE";
    public static final String PSDEDBINDEX = "PSDEDBINDEX";
    public static final String PSCTRLTYPE = "PSCTRLTYPE";
    public static final String PSAPPPORTALVIEW = "PSAPPPORTALVIEW";
    public static final String PSSYSDEVINFO = "PSSYSDEVINFO";
    public static final String PSDCSYSPRDVER = "PSDCSYSPRDVER";
    public static final String PSSYSREQITEMDATA = "PSSYSREQITEMDATA";
    public static final String PSAPPVIEWCODE = "PSAPPVIEWCODE";
    public static final String PSUNIT = "PSUNIT";
    public static final String PSSYSREFDE = "PSSYSREFDE";
    public static final String PSSYSBDTABLERS = "PSSYSBDTABLERS";
    public static final String PSDER_DER11 = "PSDER_DER11";
    public static final String PSDER_DERCUSTOM = "PSDER_DERCUSTOM";
    public static final String PSSUBSYSVER = "PSSUBSYSVER";
    public static final String PSDEGEIUPDATE = "PSDEGEIUPDATE";
    public static final String PSMODELAPIRS = "PSMODELAPIRS";
    public static final String PSSYSCSSCAT = "PSSYSCSSCAT";
    public static final String PSHELPSECTION = "PSHELPSECTION";
    public static final String PSDETREENODERV = "PSDETREENODERV";
    public static final String PSWFDE = "PSWFDE";
    public static final String PSDEDUPRULE = "PSDEDUPRULE";
    public static final String PSSYSMODELFUNCTEMPL = "PSSYSMODELFUNCTEMPL";
    public static final String PSPFPLUGINTEMPL = "PSPFPLUGINTEMPL";
    public static final String PSAPPUTILPAGE = "PSAPPUTILPAGE";
    public static final String PSSFSTYLEVER = "PSSFSTYLEVER";
    public static final String PSSUBDEACTION = "PSSUBDEACTION";
    public static final String PSVTSTYLE = "PSVTSTYLE";
    public static final String PSSYSEDITORSTYLE = "PSSYSEDITORSTYLE";
    public static final String PSVIEWLOGICTYPE = "PSVIEWLOGICTYPE";
    public static final String PSSFVERCODE = "PSSFVERCODE";
    public static final String PSPFCTDETAIL = "PSPFCTDETAIL";
    public static final String PSSYSDEPLOYDB = "PSSYSDEPLOYDB";
    public static final String PSDEVSERVER = "PSDEVSERVER";
    public static final String PSSYSDBVFCODE = "PSSYSDBVFCODE";
    public static final String PSDCCOREPRDISSUE = "PSDCCOREPRDISSUE";
    public static final String PSWFPROCESS = "PSWFPROCESS";
    public static final String PSSFVERCODEITEM = "PSSFVERCODEITEM";
    public static final String PSDER_DERMULINH = "PSDER_DERMULINH";
    public static final String PSSYSSERVICEAPI = "PSSYSSERVICEAPI";
    public static final String PSSYSISSUE = "PSSYSISSUE";
    public static final String PSDEVUSEROBJ = "PSDEVUSEROBJ";
    public static final String PSSYSREQITEM = "PSSYSREQITEM";
    public static final String PSDEVCENTERSF = "PSDEVCENTERSF";
    public static final String PSSYSPFPLUGIN = "PSSYSPFPLUGIN";
    public static final String PSCTRLMSG = "PSCTRLMSG";
    public static final String PSDBVALUEOP = "PSDBVALUEOP";
    public static final String PSDEPSLNASGRP = "PSDEPSLNASGRP";
    public static final String PSAPPSERVER = "PSAPPSERVER";
    public static final String PSSFSTYLEPRJ = "PSSFSTYLEPRJ";
    public static final String PSDEDQJOIN = "PSDEDQJOIN";
    public static final String PSDEPSLNAS = "PSDEPSLNAS";
    public static final String PSMODELINIT = "PSMODELINIT";
    public static final String PSDEFORM = "PSDEFORM";
    public static final String PSSYSISSUETYPE = "PSSYSISSUETYPE";
    public static final String PSCOUNTER = "PSCOUNTER";
    public static final String PSIMAGETEMPL = "PSIMAGETEMPL";
    public static final String PSDEDBOBJSQL = "PSDEDBOBJSQL";
    public static final String PSDECHART = "PSDECHART";
    public static final String PSSYSUSERMODE = "PSSYSUSERMODE";
    public static final String PSSUBSYSSF = "PSSUBSYSSF";
    public static final String PSMODELAPI = "PSMODELAPI";
    public static final String PSSFPKGVER = "PSSFPKGVER";
    public static final String PSCOREPRDCAT = "PSCOREPRDCAT";
    public static final String PSDER_DER1N = "PSDER_DER1N";
    public static final String PSDER_DERAGGDATA = "PSDER_DERAGGDATA";
    public static final String PSDESADETAIL = "PSDESADETAIL";
    public static final String PSSYSPRODUCT = "PSSYSPRODUCT";
    public static final String PSSYSACTOR = "PSSYSACTOR";
    public static final String PSACHANDLER = "PSACHANDLER";
    public static final String PSACHANDLERACTION = "PSACHANDLERACTION";
    public static final String PSDEVCENTERLOG = "PSDEVCENTERLOG";
    public static final String PSSYSRUNLOG = "PSSYSRUNLOG";
    public static final String PSDEVUSERMODEL = "PSDEVUSERMODEL";
    public static final String PSAPPMENU = "PSAPPMENU";
    public static final String PSDEGRID = "PSDEGRID";
    public static final String PSVIEWTYPE = "PSVIEWTYPE";
    public static final String PSDBDEVINST = "PSDBDEVINST";
    public static final String PSHELPARTICLETYPE = "PSHELPARTICLETYPE";
    public static final String PSDEVCENTERSERVER = "PSDEVCENTERSERVER";
    public static final String PSTSCMD = "PSTSCMD";
    public static final String PSDEPSLNASITEM = "PSDEPSLNASITEM";
    public static final String PSDEUAGROUP = "PSDEUAGROUP";
    public static final String PSAPPDEUAGROUP = "PSAPPDEUAGROUP";
    public static final String PSSYSAPPDEUAGROUP = "PSSYSAPPDEUAGROUP";
    public static final String PSDCDBTABLE = "PSDCDBTABLE";
    public static final String PSSFEXCEPTION = "PSSFEXCEPTION";
    public static final String PSDELOGICNODE = "PSDELOGICNODE";
    public static final String PSPFEDITORTEMPL = "PSPFEDITORTEMPL";
    public static final String PSSYSUSERCASERS = "PSSYSUSERCASERS";
    public static final String PSDEVSYSDIFFREP = "PSDEVSYSDIFFREP";
    public static final String PSSVNSERVER = "PSSVNSERVER";
    public static final String PSDELLCOND = "PSDELLCOND";
    public static final String PSCOUNTERTYPESF = "PSCOUNTERTYPESF";
    public static final String PSDBSERVER = "PSDBSERVER";
    public static final String PSSYSTESTDATA = "PSSYSTESTDATA";
    public static final String PSCSSCATTEMPL = "PSCSSCATTEMPL";
    public static final String PSSYSUNIRES = "PSSYSUNIRES";
    public static final String PSDEPSLNLOG = "PSDEPSLNLOG";
    public static final String PSDCDBSEQU = "PSDCDBSEQU";
    public static final String PSSYSDEPLOY = "PSSYSDEPLOY";
    public static final String PSSYSDSACTIONTYPE = "PSSYSDSACTIONTYPE";
    public static final String PSDEDQCODE = "PSDEDQCODE";
    public static final String PSCOUNTERTYPE = "PSCOUNTERTYPE";
    public static final String PSCTRLEVENT = "PSCTRLEVENT";
    public static final String PSDCBULLETIN = "PSDCBULLETIN";
    public static final String PSSFSTYLEPKG = "PSSFSTYLEPKG";
    public static final String PSVIEWWIZARDGROUP = "PSVIEWWIZARDGROUP";
    public static final String PSCTRLTYPEEVENT = "PSCTRLTYPEEVENT";
    public static final String PSDEVSERVERLEASE = "PSDEVSERVERLEASE";
    public static final String PSDCMTDEF = "PSDCMTDEF";
    public static final String PSDEUIACTION = "PSDEUIACTION";
    public static final String PSLANGUAGERES = "PSLANGUAGERES";
    public static final String PSDEMSACTION = "PSDEMSACTION";
    public static final String PSSYSBDTABLEDE = "PSSYSBDTABLEDE";
    public static final String PSVIEWMSG = "PSVIEWMSG";
    public static final String PSDCTASKLOG = "PSDCTASKLOG";
    public static final String PSPFVLTEMPL = "PSPFVLTEMPL";
    public static final String PSROBOT = "PSROBOT";
    public static final String PSDESERVICEAPI = "PSDESERVICEAPI";
    public static final String PSSYSERMAP = "PSSYSERMAP";
    public static final String PSDEDQCODECOND = "PSDEDQCODECOND";
    public static final String PSHELPARTICLE = "PSHELPARTICLE";
    public static final String PSPORTLET = "PSPORTLET";
    public static final String PSSYSTEMRUN = "PSSYSTEMRUN";
    public static final String PSSYSPOLICY = "PSSYSPOLICY";
    public static final String PSWFLINK = "PSWFLINK";
    public static final String PSV3MGFORM = "PSV3MGFORM";
    public static final String PSSYSLANRES = "PSSYSLANRES";
    public static final String PSAPPVIEWREF = "PSAPPVIEWREF";
    public static final String PSDEVSLN = "PSDEVSLN";
    public static final String PSDCBDINST = "PSDCBDINST";
    public static final String PSVTRV = "PSVTRV";
    public static final String PSDCSYSRES = "PSDCSYSRES";
    public static final String PSDEWIZARD = "PSDEWIZARD";
    public static final String PSSYSMODELFUNC = "PSSYSMODELFUNC";
    public static final String PSSYSREQITEMHIS = "PSSYSREQITEMHIS";
    public static final String PSMOBAPPPACK = "PSMOBAPPPACK";
    public static final String PSWFLINKCOND = "PSWFLINKCOND";
    public static final String PSSYSTEMMQ = "PSSYSTEMMQ";
    public static final String PSPFPLUGIN = "PSPFPLUGIN";
    public static final String PSDEVCENTERSRV = "PSDEVCENTERSRV";
    public static final String PSSYSDBDETAIL = "PSSYSDBDETAIL";
    public static final String PSDEMAPDETAIL = "PSDEMAPDETAIL";
    public static final String PSSTUDIOSERVER = "PSSTUDIOSERVER";
    public static final String PSSYSPDTVIEW = "PSSYSPDTVIEW";
    public static final String PSVARTYPE = "PSVARTYPE";
    public static final String PSDEFIUPDATE = "PSDEFIUPDATE";
    public static final String PSWFPROCESSTYPE = "PSWFPROCESSTYPE";
    public static final String PSWFWORKTIME = "PSWFWORKTIME";
    public static final String PSAPPMODULE = "PSAPPMODULE";
    public static final String PSSUBAPPVIEW = "PSSUBAPPVIEW";
    public static final String PSWFLINKTYPE = "PSWFLINKTYPE";
    public static final String PSSUBVIEWTYPE = "PSSUBVIEWTYPE";
    public static final String PSUAWIZARD = "PSUAWIZARD";
    public static final String PSVIEWMSGGRPDETAIL = "PSVIEWMSGGRPDETAIL";
    public static final String PSDEDSPARAM = "PSDEDSPARAM";
    public static final String PSSYSMODELINST = "PSSYSMODELINST";
    public static final String PSDEFORMDETAIL = "PSDEFORMDETAIL";
    public static final String PSDBPROCPARAM = "PSDBPROCPARAM";
    public static final String PSDCSERVER = "PSDCSERVER";
    public static final String PSDEGRIDCOL = "PSDEGRIDCOL";
    public static final String PSSFCODETEMPL = "PSSFCODETEMPL";
    public static final String PSWFPROCSUBWF = "PSWFPROCSUBWF";
    public static final String PSDEDATASYNC = "PSDEDATASYNC";
    public static final String PSPFAPPTEMPL = "PSPFAPPTEMPL";
    public static final String PSDCDBOBJ = "PSDCDBOBJ";
    public static final String PSDEDQCODEEXP = "PSDEDQCODEEXP";
    public static final String PSHELPMODULE = "PSHELPMODULE";
    public static final String PSDEVSERVERTYPE = "PSDEVSERVERTYPE";
    public static final String PSMODELPFCODE = "PSMODELPFCODE";
    public static final String PSAPPPVPART = "PSAPPPVPART";
    public static final String PSDEGEIUDETAIL = "PSDEGEIUDETAIL";
    public static final String PSSFPKG = "PSSFPKG";
    public static final String PSMODEL = "PSMODEL";
    public static final String PSFORMTYPE = "PSFORMTYPE";
    public static final String PSCTRLACTION = "PSCTRLACTION";
    public static final String PSSYSBDCOLUMN = "PSSYSBDCOLUMN";
    public static final String PSDEFDLOGIC = "PSDEFDLOGIC";
    public static final String PSSYSTESTCASE = "PSSYSTESTCASE";
    public static final String PSSYSTESTCASE2 = "PSSYSTESTCASE2";
    public static final String PSSYSTESTPRJ = "PSSYSTESTPRJ";
    public static final String PSSYSTESTMODULE = "PSSYSTESTMODULE";
    public static final String PSDETREENODERS = "PSDETREENODERS";
    public static final String PSSYSDEVSTUDIO = "PSSYSDEVSTUDIO";
    public static final String PSDERTYPE = "PSDERTYPE";
    public static final String PSSYSMODELLOG = "PSSYSMODELLOG";
    public static final String PSSYSORGTYPE = "PSSYSORGTYPE";
    public static final String PSSYSCOUNTER = "PSSYSCOUNTER";
    public static final String PSSUBSYS = "PSSUBSYS";
    public static final String PSDEVIEWCTRL = "PSDEVIEWCTRL";
    public static final String PSDCMTDECAT = "PSDCMTDECAT";
    public static final String PSDEVCENTERAS = "PSDEVCENTERAS";
    public static final String PSAMITEMTYPE = "PSAMITEMTYPE";
    public static final String PSDEVCENTER = "PSDEVCENTER";
    public static final String PSEDITORSTYLE = "PSEDITORSTYLE";
    public static final String PSBKTASKLOG = "PSBKTASKLOG";
    public static final String PSLISTITEMTYPE = "PSLISTITEMTYPE";
    public static final String PSSYSDEPLOYAS = "PSSYSDEPLOYAS";
    public static final String PSVIEWMSGGROUP = "PSVIEWMSGGROUP";
    public static final String PSDER = "PSDER";
    public static final String PSDCDBINDEX = "PSDCDBINDEX";
    public static final String PSDBOBJTYPE = "PSDBOBJTYPE";
    public static final String PSAPPUISTYLE = "PSAPPUISTYLE";
    public static final String PSSYSREPORT = "PSSYSREPORT";
    public static final String PSCOREPRD = "PSCOREPRD";
    public static final String PSDEMODELCNT = "PSDEMODELCNT";
    public static final String PSPFPUBCODE = "PSPFPUBCODE";
    public static final String PSDEFTYPE = "PSDEFTYPE";
    public static final String PSSF = "PSSF";
    public static final String PSLANGUAGE = "PSLANGUAGE";
    public static final String PSDEDATAIMP = "PSDEDATAIMP";
    public static final String PSPRODUCT = "PSPRODUCT";
    public static final String PSDEFIVR = "PSDEFIVR";
    public static final String PSMODELAPIINT = "PSMODELAPIINT";
    public static final String PSSYSOUTYPERS = "PSSYSOUTYPERS";
    public static final String PSAPPMENUITEM = "PSAPPMENUITEM";
    public static final String PSDEVSLNSYSPATCH = "PSDEVSLNSYSPATCH";
    public static final String PSDEACTIONWIZARD = "PSDEACTIONWIZARD";
    public static final String PSDEVIEWLOGIC = "PSDEVIEWLOGIC";
    public static final String PSDEFORMRF = "PSDEFORMRF";
    public static final String PSSYSVIEWPANEL = "PSSYSVIEWPANEL";
    public static final String PSWFLINKCONDTYPE = "PSWFLINKCONDTYPE";
    public static final String PSSYSDEPLOYAPP = "PSSYSDEPLOYAPP";
    public static final String PSVTCATDETAIL = "PSVTCATDETAIL";
    public static final String PSAPPTYPE = "PSAPPTYPE";
    public static final String PSSYSBDCOLSET = "PSSYSBDCOLSET";
    public static final String PSPFSTYLECODE = "PSPFSTYLECODE";
    public static final String PSDEDSGRPPARAM = "PSDEDSGRPPARAM";
    public static final String PSDBSYSPROCTEMPL = "PSDBSYSPROCTEMPL";
    public static final String PSDETOOLBAR = "PSDETOOLBAR";
    public static final String PSDEDUPRULEITEM = "PSDEDUPRULEITEM";
    public static final String PSDETREENODE = "PSDETREENODE";
    public static final String PSSYSTBITEM = "PSSYSTBITEM";
    public static final String PSDEWIZARDSTEP = "PSDEWIZARDSTEP";
    public static final String PSSYSPORTLET = "PSSYSPORTLET";
    public static final String PSDEDRDETAIL = "PSDEDRDETAIL";
    public static final String PSWXMENUFUNC = "PSWXMENUFUNC";
    public static final String PSDEVCENTERPF = "PSDEVCENTERPF";
    public static final String PSDEDATAVIEW = "PSDEDATAVIEW";
    public static final String PSDELNTYPE = "PSDELNTYPE";
    public static final String PSPFCODEFOLDER = "PSPFCODEFOLDER";
    public static final String PSSFCODEFOLDER = "PSSFCODEFOLDER";
    public static final String PSSYSMODELACTION = "PSSYSMODELACTION";
    public static final String PSCOREPRDISSUE = "PSCOREPRDISSUE";
    public static final String PSDEVIEWBASE = "PSDEVIEWBASE";
    public static final String PSSYSPROJECT = "PSSYSPROJECT";
    public static final String PSDBTYPE = "PSDBTYPE";
    public static final String PSDBSYSPROCTYPE = "PSDBSYSPROCTYPE";
    public static final String PSDEAWGRPDETAIL = "PSDEAWGRPDETAIL";
    public static final String PSDEMAP = "PSDEMAP";
    public static final String PSDELLTYPE = "PSDELLTYPE";
    public static final String PSDEWIZARDFORM = "PSDEWIZARDFORM";
    public static final String PSAPPSUBAPP = "PSAPPSUBAPP";
    public static final String PSDEDBIDXFIELD = "PSDEDBIDXFIELD";
    public static final String PSSYSDMITEMLOG = "PSSYSDMITEMLOG";
    public static final String PSTBITEMTYPE = "PSTBITEMTYPE";
    public static final String PSDCMODELTEMPL = "PSDCMODELTEMPL";
    public static final String PSDESPCODE = "PSDESPCODE";
    public static final String PSBDDEVINST = "PSBDDEVINST";
    public static final String PSDBVALUEFUNC = "PSDBVALUEFUNC";
    public static final String PSPFUATEMPL = "PSPFUATEMPL";
    public static final String PSCODENAME = "PSCODENAME";
    public static final String PSUAWIZARD2 = "PSUAWIZARD2";
    public static final String PSDCSERVERSTATE = "PSDCSERVERSTATE";
    public static final String PSSYSSFPUB = "PSSYSSFPUB";
    public static final String PSSYSDBVF = "PSSYSDBVF";
    public static final String PSDEVCENTERSVN = "PSDEVCENTERSVN";
    public static final String PSHELPARTICLECAT = "PSHELPARTICLECAT";
    public static final String PSDELIST = "PSDELIST";
    public static final String PSDEFVRCOND = "PSDEFVRCOND";
    public static final String PSSYSCSS = "PSSYSCSS";
    public static final String PSDEVSLNSYSMODEL = "PSDEVSLNSYSMODEL";
    public static final String PSDCINST = "PSDCINST";
    public static final String PSMODULE = "PSMODULE";
    public static final String PSSYSERMAPNODE = "PSSYSERMAPNODE";
    public static final String PSSYSREF = "PSSYSREF";
    public static final String PSSYSVIEWLOGIC = "PSSYSVIEWLOGIC";
    public static final String PSSYSVIEWLOGICPARAM = "PSSYSVIEWLOGICPARAM";
    public static final String PSDCDBVIEW = "PSDCDBVIEW";
    public static final String PSDEVUSERGROUP = "PSDEVUSERGROUP";
    public static final String PSDEFVALUERULE = "PSDEFVALUERULE";
    public static final String PSDELLCONDTYPE = "PSDELLCONDTYPE";
    public static final String PSSYSBDINSTCFG = "PSSYSBDINSTCFG";
    public static final String PSDEVUSERSQL = "PSDEVUSERSQL";
    public static final String PSDETREEVIEW = "PSDETREEVIEW";
    public static final String PSCHARTTYPE = "PSCHARTTYPE";
    public static final String PSAPPDEVIEW = "PSAPPDEVIEW";
    public static final String PSDEAWGROUP = "PSDEAWGROUP";
    public static final String PSAPPINDEXVIEW = "PSAPPINDEXVIEW";
    public static final String PSDEOPPRIV = "PSDEOPPRIV";
    public static final String PSSYSDEOPPRIV = "PSSYSDEOPPRIV";
    public static final String PSPF = "PSPF";
    public static final String PSHELPPRJTYPE = "PSHELPPRJTYPE";
    public static final String PSHELPPRJTEMPL = "PSHELPPRJTEMPL";
    public static final String PSMODELPLUGIN = "PSMODELPLUGIN";
    public static final String PSMODELMODULE = "PSMODELMODULE";
    public static final String PSVARSAMPLEVALUE = "PSVARSAMPLEVALUE";
    public static final String PSCOREPRDINSTLOG = "PSCOREPRDINSTLOG";
    public static final String PSMODELSECTION = "PSMODELSECTION";
    public static final String PSMODELEXAMPLE = "PSMODELEXAMPLE";
    public static final String PSMODELRESOURCE = "PSMODELRESOURCE";
    public static final String PSRTWXACCOUNT = "PSRTWXACCOUNT";
    public static final String PSROBOTWORK = "PSROBOTWORK";
    public static final String PSDEMSOPPRIV = "PSDEMSOPPRIV";
    public static final String PSMODELOBJ = "PSMODELOBJ";
    public static final String PSSYSVIEWPANELITEM = "PSSYSVIEWPANELITEM";
    public static final String PSDEFGROUPDETAIL = "PSDEFGROUPDETAIL";
    public static final String PSDEFGROUP = "PSDEFGROUP";
    public static final String PSDEDOMAIN = "PSDEDOMAIN";
    public static final String PSDEDOMAINFIELD = "PSDEDOMAINFIELD";
    public static final String PSDEMETHODDTO = "PSDEMETHODDTO";
    public static final String PSDEMETHODDTOFIELD = "PSDEMETHODDTOFIELD";
    public static final String PSAPPDEMETHODDTO = "PSAPPDEMETHODDTO";
    public static final String PSAPPDEMETHODDTOFIELD = "PSAPPDEMETHODDTOFIELD";
    public static final String PSAPPDEMETHODINPUT = "PSAPPDEMETHODINPUT";
    public static final String PSAPPDEMETHODRETURN = "PSAPPDEMETHODRETURN";
    public static final String PSDEFILTER = "PSDEFILTER";
    public static final String PSDEFILTERFIELD = "PSDEFILTERFIELD";
    public static final String PSSYSSEARCHBAR = "PSSYSSEARCHBAR";
    public static final String PSSYSBDTABLEDER = "PSSYSBDTABLEDER";
    public static final String PSSYSBDMODULE = "PSSYSBDMODULE";
    public static final String PSDEPSLNSYSAS = "PSDEPSLNSYSAS";
    public static final String PSDEPSLNSYSMQ = "PSDEPSLNSYSMQ";
    public static final String PSDEPSLNSYSDB = "PSDEPSLNSYSDB";
    public static final String PSDEPSLNMQINST = "PSDEPSLNMQINST";
    public static final String PSDEPSLNSYS = "PSDEPSLNSYS";
    public static final String PSSTUDIOSERVERGRP = "PSSTUDIOSERVERGRP";
    public static final String PSDEPSAASSYSAPP = "PSDEPSAASSYSAPP";
    public static final String PSDEPSAASSYSVER = "PSDEPSAASSYSVER";
    public static final String PSDEPSAASSYS = "PSDEPSAASSYS";
    public static final String PSDEPSYSAPP = "PSDEPSYSAPP";
    public static final String PSDEPSYS = "PSDEPSYS";
    public static final String PSDEPSYSVER = "PSDEPSYSVER";
    public static final String PSDEPSLNHOST = "PSDEPSLNHOST";
    public static final String PSSAASSYSDB = "PSSAASSYSDB";
    public static final String PSDEPSLNPACK = "PSDEPSLNPACK";
    public static final String PSDEPSLNDEPSESSION = "PSDEPSLNDEPSESSION";
    public static final String PSGITUSER = "PSGITUSER";
    public static final String PSNDFILE = "PSNDFILE";
    public static final String PSNDFILELINK = "PSNDFILELINK";
    public static final String PSSYSENGINECFG = "PSSYSENGINECFG";
    public static final String PSDEVPRD = "PSDEVPRD";
    public static final String PSDEVPRDVER = "PSDEVPRDVER";
    public static final String PSDEVPRDSUBVER = "PSDEVPRDSUBVER";
    public static final String PSDEVPRDSYS = "PSDEVPRDSYS";
    public static final String PSDEVPRDSYSSYNC = "PSDEVPRDSYSSYNC";
    public static final String PSDSBOOKINGLOG = "PSDSBOOKINGLOG";
    public static final String PSDCDBINSTREF = "PSDCDBINSTREF";
    public static final String PSDEVPRDSYSSYNCITEM = "PSDEVPRDSYSSYNCITEM";
    public static final String PSDEVPRDSPEC = "PSDEVPRDSPEC";
    public static final String PSDEVPRDSEPCPLAN = "PSDEVPRDSEPCPLAN";
    public static final String PSDEVPRDSPECPLAN = "PSDEVPRDSPECPLAN";
    public static final String PSDEVSLNSYSRES = "PSDEVSLNSYSRES";
    public static final String PSPFCDN = "PSPFCDN";
    public static final String PSPFEDITORTYPE = "PSPFEDITORTYPE";
    public static final String PSMODELERROR = "PSMODELERROR";
    public static final String PSPFPKGVERCDN = "PSPFPKGVERCDN";
    public static final String PSSYSMODELFUNCCAT = "PSSYSMODELFUNCCAT";
    public static final String PSMODELSTATE = "PSMODELSTATE";
    public static final String PSMODELVALUEGROUP = "PSMODELVALUEGROUP";
    public static final String PSMODELFIELDVALUE = "PSMODELFIELDVALUE";
    public static final String PSMODELFIELD = "PSMODELFIELD";
    public static final String PSSFVIEWTYPE = "PSSFVIEWTYPE";
    public static final String PSSFCTRLTYPE = "PSSFCTRLTYPE";
    public static final String PSPFVIEWTYPE = "PSPFVIEWTYPE";
    public static final String PSPFCTRLTYPE = "PSPFCTRLTYPE";
    public static final String PSMODELUIACTION = "PSMODELUIACTION";
    public static final String PSASBOOKING = "PSASBOOKING";
    public static final String PSDEDTSQUEUE = "PSDEDTSQUEUE";
    public static final String PSMODELEXAMPLESTEP = "PSMODELEXAMPLESTEP";
    public static final String PSMODELEXAMPLECAT = "PSMODELEXAMPLECAT";
    public static final String PSMODELSUBVIEW = "PSMODELSUBVIEW";
    public static final String PSMODELVIEW = "PSMODELVIEW";
    public static final String PSDEPSYSTYPE = "PSDEPSYSTYPE";
    public static final String PSMQTYPE = "PSMQTYPE";
    public static final String PSDCASGROUP = "PSDCASGROUP";
    public static final String PSASGROUP = "PSASGROUP";
    public static final String PSDEPSLNTYPE = "PSDEPSLNTYPE";
    public static final String PSMODELVIEWUIACTION = "PSMODELVIEWUIACTION";
    public static final String PSDCSYSLIC = "PSDCSYSLIC";
    public static final String PSDCDBINSTBK = "PSDCDBINSTBK";
    public static final String PSDCSVNBK = "PSDCSVNBK";
    public static final String PSSAASSYSAPP = "PSSAASSYSAPP";
    public static final String PSSAASSYSVER = "PSSAASSYSVER";
    public static final String PSSAASSYS = "PSSAASSYS";
    public static final String PSDEVCENTERFILE = "PSDEVCENTERFILE";
    public static final String PSSYSMODELMSG = "PSSYSMODELMSG";
    public static final String PSDER_DERINHERIT = "PSDER_DERINHERIT";
    public static final String PSDSBOOKING = "PSDSBOOKING";
    public static final String PSDEPLOYSERVER = "PSDEPLOYSERVER";
    public static final String PSSTUDIOSERVERLOG = "PSSTUDIOSERVERLOG";
    public static final String PSDBDEVINSTBK = "PSDBDEVINSTBK";
    public static final String PSSYSMODELINSTBK = "PSSYSMODELINSTBK";
    public static final String PSSYSUNISTATE = "PSSYSUNISTATE";
    public static final String PSSYSRTMSG = "PSSYSRTMSG";
    public static final String PSSYSSQLCMD = "PSSYSSQLCMD";
    public static final String PSSYSSQLCMDSQL = "PSSYSSQLCMDSQL";
    public static final String PSDERTAW = "PSDERTAW";
    public static final String PSDERTAWI = "PSDERTAWI";
    public static final String PSSYSRTDEFINPUTTIP = "PSSYSRTDEFINPUTTIP";
    public static final String PSMODELRTMSG = "PSMODELRTMSG";
    public static final String PSROBOTTYPE = "PSROBOTTYPE";
    public static final String PSROBOTWORKTYPE = "PSROBOTWORKTYPE";
    public static final String PSROBOTTYPEABILITY = "PSROBOTTYPEABILITY";
    public static final String PSSUBSYSVERINST = "PSSUBSYSVERINST";
    public static final String PSCTRLMSGTAG = "PSCTRLMSGTAG";
    public static final String PSBOOKINGRESTYPE = "PSBOOKINGRESTYPE";
    public static final String PSDEFINPUTTIPSET = "PSDEFINPUTTIPSET";
    public static final String PSDCNWFLOW = "PSDCNWFLOW";
    public static final String PSDCROBOT = "PSDCROBOT";
    public static final String PSDCROBOTABILITY = "PSDCROBOTABILITY";
    public static final String PSDCROBOTLOG = "PSDCROBOTLOG";
    public static final String PSDCRTMSG = "PSDCRTMSG";
    public static final String PSDCRESREP = "PSDCRESREP";
    public static final String PSDCABILITY = "PSDCABILITY";
    public static final String PSDCRESHOURSLOG = "PSDCRESHOURSLOG";
    public static final String PSDCRESHOURS = "PSDCRESHOURS";
    public static final String PSVIEWRTMSG = "PSVIEWRTMSG";
    public static final String PSSYSMODELINSTSUM = "PSSYSMODELINSTSUM";
    public static final String PSDCDEPLOYSERVER = "PSDCDEPLOYSERVER";
    public static final String PSSYSSEARCHBARITEM = "PSSYSSEARCHBARITEM";
    public static final String PSROBOTABILITY = "PSROBOTABILITY";
    public static final String PSDEUSERROLE = "PSDEUSERROLE";
    public static final String PSDER_DERINDEX = "PSDER_DERINDEX";
    public static final String PSDEFORMDETAIL_BUTTON = "PSDEFORMDETAIL_BUTTON";
    public static final String PSDEFORMDETAIL_FORMPART = "PSDEFORMDETAIL_FORMPART";
    public static final String PSDEFORMDETAIL_FORMPAGE = "PSDEFORMDETAIL_FORMPAGE";
    public static final String PSDEFORMDETAIL_FORMITEM = "PSDEFORMDETAIL_FORMITEM";
    public static final String PSDEFORMDETAIL_TABPANEL = "PSDEFORMDETAIL_TABPANEL";
    public static final String PSDEFORMDETAIL_TABPAGE = "PSDEFORMDETAIL_TABPAGE";
    public static final String PSDEFORMDETAIL_GROUPPANEL = "PSDEFORMDETAIL_GROUPPANEL";
    public static final String PSDEFORMDETAIL_DATAGRID = "PSDEFORMDETAIL_DATAGRID";
    public static final String PSDEFORMDETAIL_DRUIPART = "PSDEFORMDETAIL_DRUIPART";
    public static final String PSDEFORMDETAIL_USERCONTROL = "PSDEFORMDETAIL_USERCONTROL";
    public static final String PSDEFORMDETAIL_RAWITEM = "PSDEFORMDETAIL_RAWITEM";
    public static final String PSDEFORMDETAIL_IFRAME = "PSDEFORMDETAIL_IFRAME";
    public static final String PSDEFORMDETAIL_FORMITEMEX = "PSDEFORMDETAIL_FORMITEMEX";
    public static final String PSDEFORMDETAIL_MDCTRL = "PSDEFORMDETAIL_MDCTRL";
    public static final String PSDEFORMDETAIL_BUTTONLIST = "PSDEFORMDETAIL_BUTTONLIST";
    public static final String PSDEFORM_EDITFORM = "PSDEFORM_EDITFORM";
    public static final String PSDEFORM_SEARCHFORM = "PSDEFORM_SEARCHFORM";
    public static final String PSDCMOBAPPTESTDEVICE = "PSDCMOBAPPTESTDEVICE";
    public static final String PSDCMOBAPPTDREF = "PSDCMOBAPPTDREF";
    public static final String PSMOBAPPSTARTPAGE = "PSMOBAPPSTARTPAGE";
    public static final String PSMOBAPPPACKSESSION = "PSMOBAPPPACKSESSION";
    public static final String PSDCMOBPACKCERT = "PSDCMOBPACKCERT";
    public static final String PSMODELRT = "PSMODELRT";
    public static final String PSMOBAPPPACKTD = "PSMOBAPPPACKTD";
    public static final String PSSYSDEFTYPE = "PSSYSDEFTYPE";
    public static final String PSSYSDELOGICNODE = "PSSYSDELOGICNODE";
    public static final String PSDEVPRDISSUE = "PSDEVPRDISSUE";
    public static final String PSDEVPRDISSUEPLAN = "PSDEVPRDISSUEPLAN";
    public static final String PSDCPFPITEMPL = "PSDCPFPITEMPL";
    public static final String PSDCPFPLUGIN = "PSDCPFPLUGIN";
    public static final String PSMOBAPPPACKSERVER = "PSMOBAPPPACKSERVER";
    public static final String PSDCSYNCAGENT = "PSDCSYNCAGENT";
    public static final String PSDCSYNCDATATYPE = "PSDCSYNCDATATYPE";
    public static final String PSDCSYNCDATA = "PSDCSYNCDATA";
    public static final String PSDCSYNCDATA2 = "PSDCSYNCDATA2";
    public static final String PSSFPUBOBJPARAM = "PSSFPUBOBJPARAM";
    public static final String PSSFPUBOBJ = "PSSFPUBOBJ";
    public static final String PSPFPUBOBJ = "PSPFPUBOBJ";
    public static final String PSPFPUBOBJPARAM = "PSPFPUBOBJPARAM";
    public static final String PSDEOPPRIVROLE = "PSDEOPPRIVROLE";
    public static final String PSDEVIEWCTRLDS = "PSDEVIEWCTRLDS";
    public static final String PSDELOGIC_VIEWLOGIC = "PSDELOGIC_VIEWLOGIC";
    public static final String PSSYSDBPART = "PSSYSDBPART";
    public static final String PSSYSMODELLOADLOG = "PSSYSMODELLOADLOG";
    public static final String PSSYSDASHBOARD = "PSSYSDASHBOARD";
    public static final String PSSYSUTILDE = "PSSYSUTILDE";
    public static final String PSDEUTILDE = "PSDEUTILDE";
    public static final String PSAPPLOCALDE = "PSAPPLOCALDE";
    public static final String PSSYSUSERROLERES = "PSSYSUSERROLERES";
    public static final String PSSYSSFPITEMPL = "PSSYSSFPITEMPL";
    public static final String PSSYSSFPLUGIN = "PSSYSSFPLUGIN";
    public static final String PSSFPLUGIN = "PSSFPLUGIN";
    public static final String PSSFPLUGINTEMPL = "PSSFPLUGINTEMPL";
    public static final String PSDEUTILTYPE = "PSDEUTILTYPE";
    public static final String PSDEMODEL = "PSDEMODEL";
    public static final String PSDEVIEWGRPDETAIL = "PSDEVIEWGRPDETAIL";
    public static final String PSDEVIEWGROUP = "PSDEVIEWGROUP";
    public static final String PSAPPUTIL = "PSAPPUTIL";
    public static final String PSSYSCONSOLE = "PSSYSCONSOLE";
    public static final String PSDCCODESNIPPETREF = "PSDCCODESNIPPETREF";
    public static final String PSDCCODESNIPPET = "PSDCCODESNIPPET";
    public static final String PSSYSCODESNIPPET = "PSSYSCODESNIPPET";
    public static final String PSDEVSLNMSDEPAPI = "PSDEVSLNMSDEPAPI";
    public static final String PSDEVSLNSYSAPI = "PSDEVSLNSYSAPI";
    public static final String PSDEVSLNSYSAPP = "PSDEVSLNSYSAPP";
    public static final String PSDEVSLNMSDEPAPP = "PSDEVSLNMSDEPAPP";
    public static final String PSDEVSLNMSDEPLOY = "PSDEVSLNMSDEPLOY";
    public static final String PSDCMSPLATFORMNODE = "PSDCMSPLATFORMNODE";
    public static final String PSDCMSPLATFORMFUNC = "PSDCMSPLATFORMFUNC";
    public static final String PSDCMSPLATFORM = "PSDCMSPLATFORM";
    public static final String PSMSPLATFORMNODE = "PSMSPLATFORMNODE";
    public static final String PSMSPLATFORMFUNC = "PSMSPLATFORMFUNC";
    public static final String PSMSPLATFORM = "PSMSPLATFORM";
    public static final String PSDEPLOYCENTER = "PSDEPLOYCENTER";
    public static final String PSCODESNIPPETTYPE = "PSCODESNIPPETTYPE";
    public static final String PSDCDEPLOYCENTER = "PSDCDEPLOYCENTER";
    public static final String PSWORKSHOPSERVER = "PSWORKSHOPSERVER";
    public static final String PSDCWORKSHOPSERVER = "PSDCWORKSHOPSERVER";
    public static final String PSAPPDEVIEWREF = "PSAPPDEVIEWREF";
    public static final String PSDEDATAIMPITEM = "PSDEDATAIMPITEM";
    public static final String PSDEVSLNSYSWSGIT = "PSDEVSLNSYSWSGIT";
    public static final String PSSYSDYNAMODEL = "PSSYSDYNAMODEL";
    public static final String PSSYSDYNAMODELATTR = "PSSYSDYNAMODELATTR";
    public static final String PSSYSTITLEBAR = "PSSYSTITLEBAR";
    public static final String PSAPPTITLEBAR = "PSAPPTITLEBAR";
    public static final String PSDEACTIONPARAM = "PSDEACTIONPARAM";
    public static final String PSDEACTIONINPUT = "PSDEACTIONINPUT";
    public static final String PSDEACTIONRETURN = "PSDEACTIONRETURN";
    public static final String PSDEDATASETINPUT = "PSDEDATASETINPUT";
    public static final String PSDEDATASETRETURN = "PSDEDATASETRETURN";
    public static final String PSDEDATAQUERYINPUT = "PSDEDATAQUERYINPUT";
    public static final String PSDEDATAQUERYRETURN = "PSDEDATAQUERYRETURN";
    public static final String PSDESERVICEAPIMETHODINPUT = "PSDESERVICEAPIMETHODINPUT";
    public static final String PSDESERVICEAPIMETHODRETURN = "PSDESERVICEAPIMETHODRETURN";
    public static final String PSDESERVICEAPIDTO = "PSDESERVICEAPIDTO";
    public static final String PSDESERVICEAPIDTOFIELD = "PSDESERVICEAPIDTOFIELD";
    public static final String PSSUBSYSSERVICEAPIMETHODINPUT = "PSSUBSYSSERVICEAPIMETHODINPUT";
    public static final String PSSUBSYSSERVICEAPIMETHODRETURN = "PSSUBSYSSERVICEAPIMETHODRETURN";
    public static final String PSSUBSYSSERVICEAPIDTO = "PSSUBSYSSERVICEAPIDTO";
    public static final String PSSUBSYSSERVICEAPIDTOFIELD = "PSSUBSYSSERVICEAPIDTOFIELD";
    public static final String PSSYSTEM_SETTING = "PSSYSTEM_SETTING";
    public static final String PSSYSAPP_UI = "PSSYSAPP_UI";
    public static final String PSSYSCOUNTERREF = "PSSYSCOUNTERREF";
    public static final String PSDEGRIDEDITITEM = "PSDEGRIDEDITITEM";
    public static final String PSDEGRIDDATAITEM = "PSDEGRIDDATAITEM";
    public static final String PSACHANDLER_GRIDEDITITEM = "PSACHANDLER_GRIDEDITITEM";
    public static final String PSACHANDLER_FORMITEM = "PSACHANDLER_FORMITEM";
    public static final String PSACHANDLER_PANELFIELD = "PSACHANDLER_PANELFIELD";
    public static final String PSCUSTOMCONTROL = "PSCUSTOMCONTROL";
    public static final String PSDELLCOND_GROUP = "PSDELLCOND_GROUP";
    public static final String PSDELLCOND_SINGLE = "PSDELLCOND_SINGLE";
    public static final String PSDELLCOND_CUSTOM = "PSDELLCOND_CUSTOM";
    public static final String PSDEDRBAR = "PSDEDRBAR";
    public static final String PSDEDRTAB = "PSDEDRTAB";
    public static final String PSDEDRBARGROUP = "PSDEDRBARGROUP";
    public static final String PSDEDRBARITEM = "PSDEDRBARITEM";
    public static final String PSWFUIACTION = "PSWFUIACTION";
    public static final String PSDEDATAEXPITEM = "PSDEDATAEXPITEM";
    public static final String PSDEDATAEXPGROUP = "PSDEDATAEXPGROUP";
    public static final String PSDECHARTTITLE = "PSDECHARTTITLE";
    public static final String PSDECHARTCOORDINATESYSTEM = "PSDECHARTCOORDINATESYSTEM";
    public static final String PSDECHARTLEGEND = "PSDECHARTLEGEND";
    public static final String PSDECHARTGRID = "PSDECHARTGRID";
    public static final String PSDECHARTGRIDXAXIS = "PSDECHARTGRIDXAXIS";
    public static final String PSDECHARTGRIDYAXIS = "PSDECHARTGRIDYAXIS";
    public static final String PSDECHARTGEO = "PSDECHARTGEO";
    public static final String PSDECHARTCALENDAR = "PSDECHARTCALENDAR";
    public static final String PSDECHARTDATASET = "PSDECHARTDATASET";
    public static final String PSDECHARTDATASETFIELD = "PSDECHARTDATASETFIELD";
    public static final String PSDECHARTDATASETGROUP = "PSDECHARTDATASETGROUP";
    public static final String PSDECHARTPOLARANGLEAXIS = "PSDECHARTPOLARANGLEAXIS";
    public static final String PSDECHARTPOLARRADIUSAXIS = "PSDECHARTPOLARRADIUSAXIS";
    public static final String PSDECHARTPARALLELAXIS = "PSDECHARTPARALLELAXIS";
    public static final String PSDECHARTSINGLEAXIS = "PSDECHARTSINGLEAXIS";
    public static final String PSDECHARTSERIESENCODE = "PSDECHARTSERIESENCODE";
    public static final String PSDECHARTRADAR = "PSDECHARTRADAR";
    public static final String PSDECHARTPOLAR = "PSDECHARTPOLAR";
    public static final String PSDECHARTPARALLEL = "PSDECHARTPARALLEL";
    public static final String PSDECHARTSINGLE = "PSDECHARTSINGLE";
    public static final String PSDEUNISTATE = "PSDEUNISTATE";
    public static final String PSDEDATAVIEWDATAITEM = "PSDEDATAVIEWDATAITEM";
    public static final String PSEXPBAR = "PSEXPBAR";
    public static final String PSWFUAGROUP = "PSWFUAGROUP";
    public static final String PSWFUAGRPDETAIL = "PSWFUAGRPDETAIL";
    public static final String PSDELISTDATAITEM = "PSDELISTDATAITEM";
    public static final String PSVIEWPANEL = "PSVIEWPANEL";
    public static final String PSDEWIZARDPANEL = "PSDEWIZARDPANEL";
    public static final String PSDECONTEXTMENU = "PSDECONTEXTMENU";
    public static final String PSSYSDTSQUEUE = "PSSYSDTSQUEUE";
    public static final String PSDEREPORTPANEL = "PSDEREPORTPANEL";
    public static final String PSSYSDMVER = "PSSYSDMVER";
    public static final String PSDEACTIONTEMPL = "PSDEACTIONTEMPL";
    public static final String PSDETREECOL = "PSDETREECOL";
    public static final String PSDETREENODECOL = "PSDETREENODECOL";
    public static final String PSSYSCALENDAR = "PSSYSCALENDAR";
    public static final String PSSYSCALENDARITEM = "PSSYSCALENDARITEM";
    public static final String PSSYSCALENDARITEMRV = "PSSYSCALENDARITEMRV";
    public static final String PSDESAMPLEDATA = "PSDESAMPLEDATA";
    public static final String PSCAPTIONBAR = "PSCAPTIONBAR";
    public static final String PSDATAINFOBAR = "PSDATAINFOBAR";
    public static final String PSSYSVIEWPANELITEM_CONTAINER = "PSSYSVIEWPANELITEM_CONTAINER";
    public static final String PSSYSVIEWPANELITEM_FIELD = "PSSYSVIEWPANELITEM_FIELD";
    public static final String PSSYSVIEWPANELITEM_TABPANEL = "PSSYSVIEWPANELITEM_TABPANEL";
    public static final String PSSYSVIEWPANELITEM_TABPAGE = "PSSYSVIEWPANELITEM_TABPAGE";
    public static final String PSSYSVIEWPANELITEM_CONTROL = "PSSYSVIEWPANELITEM_CONTROL";
    public static final String PSSYSVIEWPANELITEM_CTRLPOS = "PSSYSVIEWPANELITEM_CTRLPOS";
    public static final String PSSYSVIEWPANELITEM_USERCONTROL = "PSSYSVIEWPANELITEM_USERCONTROL";
    public static final String PSSYSVIEWPANELITEM_RAWITEM = "PSSYSVIEWPANELITEM_RAWITEM";
    public static final String PSSYSVIEWPANELITEM_BUTTON = "PSSYSVIEWPANELITEM_BUTTON";
    public static final String PSSYSVIEWPANELITEM_BUTTONLIST = "PSSYSVIEWPANELITEM_BUTTONLIST";
    public static final String PSSYSVIEWPANELITEM_PARAM = "PSSYSVIEWPANELITEM_PARAM";
    public static final String PSSYSVIEWPANELMODEL = "PSSYSVIEWPANELMODEL";
    public static final String PSSYSVIEWPANELLOGIC = "PSSYSVIEWPANELLOGIC";
    public static final String PSPANELLOGICPARAM = "PSPANELLOGICPARAM";
    public static final String PSPANELLOGICNODE = "PSPANELLOGICNODE";
    public static final String PSPANELLOGICLINK = "PSPANELLOGICLINK";
    public static final String PSPANELLLCOND = "PSPANELLLCOND";
    public static final String PSPANELLNPARAM = "PSPANELLNPARAM";
    public static final String PSPANELLLCOND_GROUP = "PSPANELLLCOND_GROUP";
    public static final String PSPANELLLCOND_SINGLE = "PSPANELLLCOND_SINGLE";
    public static final String PSPANELLLCOND_CUSTOM = "PSPANELLLCOND_CUSTOM";
    public static final String PSAPPDYNADEVIEW = "PSAPPDYNADEVIEW";
    public static final String PSAPPUTILVIEW = "PSAPPUTILVIEW";
    public static final String PSDEVSLNMSDEPFUNC = "PSDEVSLNMSDEPFUNC";
    public static final String PSAPPPANELVIEW = "PSAPPPANELVIEW";
    public static final String PSSYSVIEWLAYOUTPANEL = "PSSYSVIEWLAYOUTPANEL";
    public static final String PSAPPVIEWLOGICREFVIEW = "PSAPPVIEWLOGICREFVIEW";
    public static final String PSAPPVIEWENGINE = "PSAPPVIEWENGINE";
    public static final String PSAPPVIEWENGINEPARAM = "PSAPPVIEWENGINEPARAM";
    public static final String PSAPPDATAENTITY = "PSAPPDATAENTITY";
    public static final String PSAPPVIEWPARAM = "PSAPPVIEWEPARAM";
    public static final String PSAPPVIEWNAVCONTEXT = "PSAPPVIEWNAVCONTEXT";
    public static final String PSAPPVIEWNAVPARAM = "PSAPPVIEWNAVPARAM";
    public static final String PSCONTROLNAVCONTEXT = "PSCONTROLNAVCONTEXT";
    public static final String PSCONTROLNAVPARAM = "PSCONTROLNAVPARAM";
    public static final String PSLAYOUT = "PSLAYOUT";
    public static final String PSLAYOUTPOS = "PSLAYOUTPOS";
    public static final String PSAPPVIEWUIACTION = "PSAPPVIEWUIACTION";
    public static final String PSCONTROLLOGIC = "PSCONTROLLOGIC";
    public static final String PSAPPLICATIONLOGIC = "PSAPPLICATIONLOGIC";
    public static final String PSAPPUILOGIC = "PSAPPUILOGIC";
    public static final String PSAPPUILOGICBUILDIN = "PSAPPUILOGICBUILDIN";
    public static final String PSDEMAPACTION = "PSDEMAPACTION";
    public static final String PSDEMAPDQ = "PSDEMAPDQ";
    public static final String PSDEMAPDS = "PSDEMAPDS";
    public static final String PSTABEXPPANEL = "PSTABEXPPANEL";
    public static final String PSDEDRTABPAGE = "PSDEDRTABPAGE";
    public static final String PSPFXCODEOBJECT = "PSPFXCODEOBJECT";
    public static final String PSSFXCODEOBJECT = "PSSFXCODEOBJECT";
    public static final String PSAPPWF = "PSAPPWF";
    public static final String PSAPPWFVER = "PSAPPWFVER";
    public static final String PSAPPWFDE = "PSAPPWFDE";
    public static final String PSDESERVICEAPIFIELD = "PSDESERVICEAPIFIELD";
    public static final String PSDESARS = "PSDESARS";
    public static final String PSAPPDERS = "PSAPPDERS";
    public static final String PSAPPDERSVIEW = "PSAPPDERSVIEW";
    public static final String PSSUBSYSSADE = "PSSUBSYSSADE";
    public static final String PSSUBSYSSADERS = "PSSUBSYSSADERS";
    public static final String PSSUBSYSSADEFIELD = "PSSUBSYSSADEFIELD";
    public static final String PSSYSDBSCHEME = "PSSYSDBSCHEME";
    public static final String PSSYSDBTABLE = "PSSYSDBTABLE";
    public static final String PSSYSDBCOLUMN = "PSSYSDBCOLUMN";
    public static final String PSDESAVR = "PSDESAVR";
    public static final String PSSYSRESOURCE = "PSSYSRESOURCE";
    public static final String PSSYSCONTENT = "PSSYSCONTENT";
    public static final String PSAPPRESOURCE = "PSAPPRESOURCE";
    public static final String PSAPPDEMETHOD = "PSAPPDEMETHOD";
    public static final String PSAPPDEFIELD = "PSAPPDEFIELD";
    public static final String PSAPPDEMETHODLOGIC = "PSAPPDEMETHODLOGIC";
    public static final String PSAPPDEUIACTION = "PSAPPDEUIACTION";
    public static final String PSSYSAPPDEUIACTION = "PSSYSAPPDEUIACTION";
    public static final String PSDEGROUPDETAIL = "PSDEGROUPDETAIL";
    public static final String PSDEGROUP = "PSDEGROUP";
    public static final String PSSYSDEGROUPDETAIL = "PSSYSDEGROUPDETAIL";
    public static final String PSSYSDEGROUP = "PSSYSDEGROUP";
    public static final String PSDERGROUPDETAIL = "PSDERGROUPDETAIL";
    public static final String PSDERGROUP = "PSDERGROUP";
    public static final String PSDEACTIONGROUP = "PSDEACTIONGROUP";
    public static final String PSDEAGDETAIL = "PSDEAGDETAIL";
    public static final String PSSYSCONTENTCAT = "PSSYSCONTENTCAT";
    public static final String PSDERNN = "PSDERNN";
    public static final String PSSYSSAHANDLER = "PSSYSSAHANDLER";
    public static final String PSDETABLE = "PSDETABLE";
    public static final String PSAPPCOUNTER = "PSAPPCOUNTER";
    public static final String PSAPPCODELIST = "PSAPPCODELIST";
    public static final String PSAPPWFUTILUIACTION = "PSAPPWFUTILUIACTION";
    public static final String PSAPPMSGTEMPL = "PSAPPMSGTEMPL";
    public static final String PSAPPIMAGE = "PSAPPIMAGE";
    public static final String PSAPPCSS = "PSAPPCSS";
    public static final String PSAPPVIEWMSG = "PSAPPVIEWMSG";
    public static final String PSAPPVIEWMSGGROUP = "PSAPPVIEWMSGGROUP";
    public static final String PSAPPVIEWMSGGRPDETAIL = "PSAPPVIEWMSGGRPDETAIL";
    public static final String PSAPPDELOGIC = "PSAPPDELOGIC";
    public static final String PSAPPDELOGICNODE = "PSAPPDELOGICNODE";
    public static final String PSAPPDELOGICPARAM = "PSAPPDELOGICPARAM";
    public static final String PSAPPDELOGICLINK = "PSAPPDELOGICLINK";
    public static final String PSAPPDELLCOND = "PSAPPDELLCOND";
    public static final String PSAPPDELNPARAM = "PSAPPDELNPARAM";
    public static final String PSCTRLLOGICGROUP = "PSCTRLLOGICGROUP";
    public static final String PSCTRLLOGICGRPDETAIL = "PSCTRLLOGICGRPDETAIL";
    public static final String PSSYSCTRLLOGICGROUP = "PSSYSCTRLLOGICGROUP";
    public static final String PSSYSCTRLLOGICGRPDETAIL = "PSSYSCTRLLOGICGRPDETAIL";
    public static final String PSPANELITEMLOGIC = "PSPANELITEMLOGIC";
    public static final String PSPANELENGINE = "PSPANELENGINE";
    public static final String PSPANELENGINEPARAM = "PSPANELENGINEPARAM";
    public static final String PSDEUILOGIC = "PSDEUILOGIC";
    public static final String PSDEUILOGICPARAM = "PSDEUILOGICPARAM";
    public static final String PSDEUILOGICNODE = "PSDEUILOGICNODE";
    public static final String PSDEUILOGICLINK = "PSDEUILOGICLINK";
    public static final String PSDEUILNPARAM = "PSDEUILNPARAM";
    public static final String PSDEUILLCOND = "PSDEUILLCOND";
    public static final String PSAPPDEUILOGIC = "PSAPPDEUILOGIC";
    public static final String PSAPPDEUILOGICNODE = "PSAPPDEUILOGICNODE";
    public static final String PSAPPDEUILOGICPARAM = "PSAPPDEUILOGICPARAM";
    public static final String PSAPPDEUILOGICLINK = "PSAPPDEUILOGICLINK";
    public static final String PSAPPDEUILLCOND = "PSAPPDEUILLCOND";
    public static final String PSAPPDEUILNPARAM = "PSAPPDEUILNPARAM";
    public static final String PSAPPDEACMODE = "PSAPPDEACMODE";
    public static final String PSAPPDEACMODEITEM = "PSAPPDEACMODEITEM";
    public static final String PSEDITOR = "PSEDITOR";
    public static final String PSEDITORITEM = "PSEDITORITEM";
    public static final String PSSYSMODELGROUP = "PSSYSMODELGROUP";
    public static final String PSSYSSEARCHSCHEME = "PSSYSSEARCHSCHEME";
    public static final String PSSYSSEARCHDOC = "PSSYSSEARCHDOC";
    public static final String PSSYSSEARCHDE = "PSSYSSEARCHDE";
    public static final String PSSYSSEARCHFIELD = "PSSYSSEARCHFIELD";
    public static final String PSSYSSEARCHDEFIELD = "PSSYSSEARCHDEFIELD";
    public static final String PSDESEARCH = "PSDESEARCH";
    public static final String PSDEFSEARCH = "PSDEFSEARCH";
    public static final String PSDEBDTABLE = "PSDEBDTABLE";
    public static final String PSSYSMAPVIEW = "PSSYSMAPVIEW";
    public static final String PSSYSMAPITEM = "PSSYSMAPITEM";
    public static final String PSAPPWFUIACTION = "PSAPPWFUIACTION";
    public static final String PSAPPWFVERUIACTION = "PSAPPWFVERUIACTION";
    public static final String PSAPPWFUAGROUP = "PSAPPWFUAGROUP";
    public static final String PSAPPWFVERUAGROUP = "PSAPPWFVERUAGROUP";
    public static final String PSAPPWFUAGRPDETAIL = "PSAPPWFUAGRPDETAIL";
    public static final String PSAPPWFVERUAGRPDETAIL = "PSAPPWFVERUAGRPDETAIL";
    public static final String PSSYSPORTLETCAT = "PSSYSPORTLETCAT";
    public static final String PSAPPPORTLET = "PSAPPPORTLET";
    public static final String PSAPPPORTLETCAT = "PSAPPPORTLETCAT";
    public static final String PSAPPDEDRITEM = "PSAPPDEDRITEM";
    public static final String PSAPPDEDRGROUP = "PSAPPDEDRGROUP";
    public static final String PSAPPDEPORTLET = "PSAPPDEPORTLET";
    public static final String PSSYSUSERROLEDATA = "PSSYSUSERROLEDATA";
    public static final String PSAPPPDTVIEW = "PSAPPPDTVIEW";
    public static final String PSAPPDEDATAEXP = "PSAPPDEDATAEXP";
    public static final String PSAPPDEDATAEXPITEM = "PSAPPDEDATAEXPITEM";
    public static final String PSAPPDEDATAEXPGROUP = "PSAPPDEDATAEXPGROUP";
    public static final String PSAPPDEDATAIMP = "PSAPPDEDATAIMP";
    public static final String PSAPPDEDATAIMPITEM = "PSAPPDEDATAIMPITEM";
    public static final String PSAPPVALUERULE = "PSAPPVALUERULE";
    public static final String PSDATAITEMPARAM = "PSDATAITEMPARAM";
    public static final String PSDEFORMDATAITEM = "PSDEFORMDATAITEM";
    public static final String PSDEDATAVIEWITEM = "PSDEDATAVIEWITEM";
    public static final String PSSYSPANELDATAITEM = "PSSYSPANELDATAITEM";
    public static final String PSDEACMODEDATAITEM = "PSDEACMODEDATAITEM";
    public static final String PSAPPDEACMODEDATAITEM = "PSAPPDEACMODEDATAITEM";
    public static final String PSCONTROL = "PSCONTROL";
    public static final String PSDCWORKSPACE = "PSDCWORKSPACE";
    public static final String PSDETREENODERSPARAM = "PSDETREENODERSEPARAM";
    public static final String PSDETREENODERSNAVCONTEXT = "PSDETREENODERSNAVCONTEXT";
    public static final String PSDETREENODERSNAVPARAM = "PSDETREENODERSNAVPARAM";
    public static final String PSSFPUBHELP = "PSSFPUBHELP";
    public static final String PSPFPUBHELP = "PSPFPUBHELP";
    public static final String PSSFCODEPUBLISHERMACRO = "PSSFCODEPUBLISHERMACRO";
    public static final String PSPFCODEPUBLISHERMACRO = "PSPFCODEPUBLISHERMACRO";
    public static final String PSSFCODEPUBLISHERPARAM = "PSSFCODEPUBLISHERPARAM";
    public static final String PSPFCODEPUBLISHERPARAM = "PSPFCODEPUBLISHERPARAM";
    public static final String PSDETREEGRIDEX = "PSDETREEGRIDEX";
    public static final String PSDEGANTT = "PSDEGANTT";
    public static final String PSDESARSDETAIL = "PSDESARSDETAIL";
    public static final String PSDEGEIVR = "PSDEGEIVR";
    public static final String PSDEKANBAN = "PSDEKANBAN";
    public static final String PSSYSSEARCHBARFILTER = "PSSYSSEARCHBARFILTER";
    public static final String PSSYSSEARCHBARQUICKSEARCH = "PSSYSSEARCHBARQUICKSEARCH";
    public static final String PSSYSSEARCHBARGROUP = "PSSYSSEARCHBARGROUP";
    public static final String PSNAVIGATECONTEXT = "PSNAVIGATECONTEXT";
    public static final String PSNAVIGATEPARAM = "PSNAVIGATEPARAM";
    public static final String PSUIACTIONPARAM = "PSUIACTIONPARAM";
    public static final String PSDER1NDEFMAP = "PSDER1NDEFMAP";
    public static final String PSDERINDEXDEFMAP = "PSDERINDEXDEFMAP";
    public static final String PSDERAGGDATADEFMAP = "PSDERAGGDATADEFMAP";
    public static final String PSDEMETHOD = "PSDEMETHOD";
    public static final String PSDEACTIONMETHOD = "PSDEACTIONMETHOD";
    public static final String PSDEDATASETMETHOD = "PSDEDATASETMETHOD";
    public static final String PSDEACTIONVR = "PSDEACTIONVR";
    public static final String PSDESTATEWIZARDPANEL = "PSDESTATEWIZARDPANEL";
    public static final String PSDEFLOGIC = "PSDEFLOGIC";
    public static final String PSAPPDEFLOGIC = "PSAPPDEFLOGIC";
    public static final String PSDEFUIMODE = "PSDEFUIMODE";
    public static final String PSDEFGRIDCOLUMN = "PSDEFGRIDCOLUMN";
    public static final String PSDEMSFIELD = "PSDEMSFIELD";
    public static final String PSAPPPFPLUGINREF = "PSAPPPFPLUGINREF";
    public static final String PSAPPEDITORSTYLEREF = "PSAPPEDITORSTYLEREF";
    public static final String PSAPPSUBVIEWTYPEREF = "PSAPPSUBVIEWTYPEREF";
    public static final String PSSYSSEQUENCE = "PSSYSSEQUENCE";
    public static final String PSSYSTRANSLATOR = "PSSYSTRANSLATOR";
    public static final String PSSYSMSGTARGET = "PSSYSMSGTARGET";
    public static final String PSSYSMSGQUEUE = "PSSYSMSGQUEUE";
    public static final String PSDENOTIFY = "PSDENOTIFY";
    public static final String PSDENOTIFYTARGET = "PSDENOTIFYTARGET";
    public static final String PSDEMSLOGIC = "PSDEMSLOGIC";
    public static final String PSDEMSLOGICPARAM = "PSDEMSLOGICPARAM";
    public static final String PSDEMSLOGICNODE = "PSDEMSLOGICNODE";
    public static final String PSDEMSLOGICLINK = "PSDEMSLOGICLINK";
    public static final String PSDEMSLNPARAM = "PSDEMSLNPARAM";
    public static final String PSDEMSLLCOND = "PSDEMSLLCOND";
    public static final String PSSYSEAIDATATYPEITEM = "PSSYSEAIDATATYPEITEM";
    public static final String PSSYSEAIDER = "PSSYSEAIDER";
    public static final String PSSYSEAIDEFIELD = "PSSYSEAIDEFIELD";
    public static final String PSSYSEAIDE = "PSSYSEAIDE";
    public static final String PSSYSEAIELEMENTRE = "PSSYSEAIELEMENTRE";
    public static final String PSSYSEAIELEMENTATTR = "PSSYSEAIELEMENTATTR";
    public static final String PSSYSEAIELEMENT = "PSSYSEAIELEMENT";
    public static final String PSSYSEAIDATATYPE = "PSSYSEAIDATATYPE";
    public static final String PSSYSEAISCHEME = "PSSYSEAISCHEME";
    public static final String PSSYSBIAGGCOLUMN = "PSSYSBIAGGCOLUMN";
    public static final String PSSYSBIAGGTABLE = "PSSYSBIAGGTABLE";
    public static final String PSSYSBICUBELEVEL = "PSSYSBICUBELEVEL";
    public static final String PSSYSBICUBEMEASURE = "PSSYSBICUBEMEASURE";
    public static final String PSSYSBICUBEDIMENSION = "PSSYSBICUBEDIMENSION";
    public static final String PSSYSBILEVEL = "PSSYSBILEVEL";
    public static final String PSSYSBIHIERARCHY = "PSSYSBIHIERARCHY";
    public static final String PSSYSBIDIMENSION = "PSSYSBIDIMENSION";
    public static final String PSSYSBICUBE = "PSSYSBICUBE";
    public static final String PSSYSBISCHEME = "PSSYSBISCHEME";
    public static final String PSTHRESHOLD = "PSTHRESHOLD";
    public static final String PSTHRESHOLDGROUP = "PSTHRESHOLDGROUP";
    public static final String PSSYSCHARTTHEME = "PSSYSCHARTTHEME";
    public static final String PSSUBSYSSERVICEAPIDE = "PSSUBSYSSERVICEAPIDE";
    public static final String PSSYSMETHODDTO = "PSSYSMETHODDTO";
    public static final String PSSYSMETHODDTOFIELD = "PSSYSMETHODDTOFIELD";
    public static final String PSAPPMETHODDTO = "PSAPPMETHODDTO";
    public static final String PSAPPMETHODDTOFIELD = "PSAPPMETHODDTOFIELD";
    public static final String PSAPPDEREPORT = "PSAPPDEREPORT";
    public static final String PSAPPDEREPITEM = "PSAPPDEREPITEM";
    public static final String PSSYSDASHBOARDLOGIC = "PSSYSDASHBOARDLOGIC";
    public static final String PSAPPMENULOGIC = "PSAPPMENULOGIC";
    public static final String PSDEFORMLOGIC = "PSDEFORMLOGIC";
    public static final String PSSYSSEARCHBARLOGIC = "PSSYSSEARCHBARLOGIC";
    public static final String PSAPPLOGIC = "PSAPPLOGIC";
    public static final String PSDETOOLBARLOGIC = "PSDETOOLBARLOGIC";
    public static final String PSDEWIZARDLOGIC = "PSDEWIZARDLOGIC";
    public static final String PSDELISTLOGIC = "PSDELISTLOGIC";
    public static final String PSSYSMAPLOGIC = "PSSYSMAPLOGIC";
    public static final String PSDETREELOGIC = "PSDETREELOGIC";
    public static final String PSDEDATAVIEWLOGIC = "PSDEDATAVIEWLOGIC";
    public static final String PSSYSCALENDARLOGIC = "PSSYSCALENDARLOGIC";
    public static final String PSDEGRIDLOGIC = "PSDEGRIDLOGIC";
    public static final String PSDECHARTLOGIC = "PSDECHARTLOGIC";
    public static final String PSDEDRLOGIC = "PSDEDRLOGIC";
    public static final String PSCONTROLRENDER = "PSCONTROLRENDER";
    public static final String PSCONTROLATTRIBUTE = "PSCONTROLATTRIBUTE";
    public static final String PSDETREENODEEDITITEM = "PSDETREENODEEDITITEM";
    public static final String PSDETREENODEDATAITEM = "PSDETREENODEDATAITEM";
    public static final String PSAPPDEMAP = "PSAPPDEMAP";
    public static final String PSAPPDEMAPFIELD = "PSAPPDEMAPFIELD";

    static {
        psModelIntMap.put(PSACHANDLER, INT_PSAJAXCONTROLHANDLER);
        psModelIntMap.put(PSACHANDLERACTION, INT_PSAJAXCONTROLHANDLERACTION);
        psModelIntMap.put(PSACHANDLER_FORMITEM, INT_PSAJAXHANDLER);
        psModelIntMap.put(PSACHANDLER_GRIDEDITITEM, INT_PSAJAXHANDLER);
        psModelIntMap.put(PSAPPCODELIST, INT_PSAPPCODELIST);
        psModelIntMap.put(PSAPPMSGTEMPL, INT_PSAPPMSGTEMPL);
        psModelIntMap.put(PSAPPCOUNTER, INT_PSAPPCOUNTER);
        psModelIntMap.put(PSAPPWFUTILUIACTION, INT_PSAPPWFUTILUIACTION);
        psModelIntMap.put(PSAPPDATAENTITY, INT_PSAPPDATAENTITY);
        psModelIntMap.put(PSAPPDEACMODE, INT_PSAPPDEACMODE);
        psModelIntMap.put(PSAPPDEACMODEDATAITEM, INT_PSAPPDEACMODEDATAITEM);
        psModelIntMap.put("PSAPPDEPRINT", INT_PSAPPDEPRINT);
        psModelIntMap.put(PSAPPDEDATAEXP, INT_PSAPPDEDATAEXPORT);
        psModelIntMap.put(PSAPPDEDATAEXPITEM, INT_PSAPPDEDATAEXPORTITEM);
        psModelIntMap.put(PSAPPDEDATAEXPGROUP, INT_PSAPPDEDATAEXPORTGROUP);
        psModelIntMap.put(PSAPPDEDATAIMP, INT_PSAPPDEDATAIMPORT);
        psModelIntMap.put(PSAPPDEDATAIMPITEM, INT_PSAPPDEDATAIMPORTITEM);
        psModelIntMap.put(PSAPPDEDRGROUP, INT_PSAPPDEDRGROUP);
        psModelIntMap.put(PSAPPDEDRITEM, INT_PSAPPDEDRITEM);
        psModelIntMap.put(PSAPPDEFIELD, INT_PSAPPDEFIELD);
        psModelIntMap.put(PSAPPDELLCOND, INT_PSAPPDELOGICLINKCOND);
        psModelIntMap.put(PSAPPDELNPARAM, INT_PSAPPDELOGICNODEPARAM);
        psModelIntMap.put(PSAPPDELOGIC, INT_PSAPPDELOGIC);
        psModelIntMap.put(PSAPPDELOGICLINK, INT_PSAPPDELOGICLINK);
        psModelIntMap.put(PSAPPDELOGICNODE, INT_PSAPPDELOGICNODE);
        psModelIntMap.put(PSAPPDELOGICPARAM, INT_PSAPPDELOGICPARAM);
        psModelIntMap.put(PSAPPDEMETHOD, INT_PSAPPDEMETHOD);
        psModelIntMap.put(PSAPPDEMETHODLOGIC, INT_PSAPPDEMETHODLOGIC);
        psModelIntMap.put(PSAPPDERS, INT_PSAPPDERS);
        psModelIntMap.put(PSAPPDEUAGROUP, INT_PSAPPDEUIACTIONGROUP);
        psModelIntMap.put(PSAPPDEUAGRPDETAIL, INT_PSAPPDEUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSAPPDEUIACTION, INT_PSAPPDEUIACTION);
        psModelIntMap.put(PSAPPDEUILLCOND, INT_PSAPPDEUILOGICLINKCOND);
        psModelIntMap.put(PSAPPDEUILNPARAM, INT_PSAPPDEUILOGICNODEPARAM);
        psModelIntMap.put(PSAPPDEUILOGIC, INT_PSAPPDEUILOGIC);
        psModelIntMap.put(PSAPPDEUILOGICLINK, INT_PSAPPDEUILOGICLINK);
        psModelIntMap.put(PSAPPDEUILOGICNODE, INT_PSAPPDEUILOGICNODE);
        psModelIntMap.put(PSAPPDEUILOGICPARAM, INT_PSAPPDEUILOGICPARAM);
        psModelIntMap.put(PSAPPDEVIEW, INT_PSAPPDEVIEW);
        psModelIntMap.put(PSAPPDYNADEVIEW, INT_PSAPPDYNADEVIEW);
        psModelIntMap.put(PSAPPFUNC, INT_PSAPPFUNC);
        psModelIntMap.put(PSAPPINDEXVIEW, INT_PSAPPINDEXVIEW);
        psModelIntMap.put(PSAPPLAN, INT_PSAPPLAN);
        psModelIntMap.put(PSSYSLAN, INT_PSSYSLAN);
        psModelIntMap.put(PSSYSI18N, INT_PSSYSI18N);
        psModelIntMap.put(PSAPPLOCALDE, INT_PSAPPLOCALDE);
        psModelIntMap.put(PSAPPMENU, INT_PSAPPMENU);
        psModelIntMap.put(PSAPPMENUITEM, INT_PSAPPMENUITEM);
        psModelIntMap.put(PSAPPMODULE, INT_PSAPPMODULE);
        psModelIntMap.put(PSAPPPANELVIEW, INT_PSAPPPANELVIEW);
        psModelIntMap.put(PSAPPPDTVIEW, INT_PSAPPPDTVIEW);
        psModelIntMap.put(PSAPPPKG, INT_PSAPPPKG);
        psModelIntMap.put(PSAPPPORTALVIEW, INT_PSAPPPORTALVIEW);
        psModelIntMap.put(PSAPPPORTLET, INT_PSAPPPORTLET);
        psModelIntMap.put(PSAPPPORTLETCAT, INT_PSAPPPORTLETCAT);
        psModelIntMap.put(PSAPPRESOURCE, INT_PSAPPRESOURCE);
        psModelIntMap.put(PSAPPSERVER, INT_PSAPPSERVER);
        psModelIntMap.put(PSAPPTITLEBAR, INT_PSAPPTITLEBAR);
        psModelIntMap.put(PSAPPTYPE, INT_PSAPPTYPE);
        psModelIntMap.put(PSAPPUILOGIC, INT_PSAPPUILOGIC);
        psModelIntMap.put(PSAPPUILOGICBUILDIN, INT_PSAPPUILOGIC);
        psModelIntMap.put(PSAPPUISTYLE, INT_PSAPPUISTYLE);
        psModelIntMap.put(PSAPPUITHEME, INT_PSAPPUITHEME);
        psModelIntMap.put(PSAPPUSERMODE, INT_PSAPPUSERMODE);
        psModelIntMap.put(PSAPPUTIL, INT_PSAPPUTIL);
        psModelIntMap.put(PSAPPUTILPAGE, INT_PSAPPUTILPAGE);
        psModelIntMap.put(PSAPPUTILVIEW, INT_PSAPPUTILVIEW);
        psModelIntMap.put(PSAPPVALUERULE, INT_PSAPPVALUERULE);
        psModelIntMap.put(PSAPPVIEW, INT_PSAPPVIEW);
        psModelIntMap.put(PSAPPVIEWCODE, INT_PSAPPVIEWCODE);
        psModelIntMap.put(PSAPPVIEWENGINE, INT_PSAPPVIEWENGINE);
        psModelIntMap.put(PSAPPVIEWENGINEPARAM, INT_PSAPPVIEWENGINEPARAM);
        psModelIntMap.put(PSAPPVIEWPARAM, INT_PSAPPVIEWPARAM);
        psModelIntMap.put(PSAPPVIEWLOGIC, INT_PSAPPVIEWLOGIC);
        psModelIntMap.put(PSAPPVIEWLOGICREFVIEW, INT_PSAPPVIEWLOGICREFVIEW);
        psModelIntMap.put(PSAPPVIEWMSG, INT_PSAPPVIEWMSG);
        psModelIntMap.put(PSAPPVIEWMSGGROUP, INT_PSAPPVIEWMSGGROUP);
        psModelIntMap.put(PSAPPVIEWMSGGRPDETAIL, INT_PSAPPVIEWMSGGROUPDETAIL);
        psModelIntMap.put(PSAPPVIEWNAVCONTEXT, INT_PSAPPVIEWNAVCONTEXT);
        psModelIntMap.put(PSAPPVIEWNAVPARAM, INT_PSAPPVIEWNAVPARAM);
        psModelIntMap.put(PSCONTROLNAVCONTEXT, INT_PSCONTROLNAVCONTEXT);
        psModelIntMap.put(PSCONTROLNAVPARAM, INT_PSCONTROLNAVPARAM);
        psModelIntMap.put(PSAPPVIEWREF, INT_PSAPPVIEWREF);
        psModelIntMap.put(PSAPPVIEWUIACTION, INT_PSAPPVIEWUIACTION);
        psModelIntMap.put(PSAPPWF, INT_PSAPPWF);
        psModelIntMap.put(PSAPPWFUAGROUP, INT_PSAPPWFUIACTIONGROUP);
        psModelIntMap.put(PSAPPWFUAGRPDETAIL, INT_PSAPPWFUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSAPPWFUIACTION, INT_PSAPPWFUIACTION);
        psModelIntMap.put(PSAPPWFVER, INT_PSAPPWFVER);
        psModelIntMap.put(PSAPPWFDE, INT_PSAPPWFDE);
        psModelIntMap.put(PSAPPWFVERUAGROUP, INT_PSAPPWFUIACTIONGROUP);
        psModelIntMap.put(PSAPPWFVERUAGRPDETAIL, INT_PSAPPWFUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSAPPWFVERUIACTION, INT_PSAPPWFUIACTION);
        psModelIntMap.put(PSBACKSERVICE, INT_PSBACKSERVICE);
        psModelIntMap.put(PSCODEITEM, INT_PSCODEITEM);
        psModelIntMap.put(PSCODELIST, INT_PSCODELIST);
        psModelIntMap.put(PSCONTROL, INT_PSCONTROL);
        psModelIntMap.put(PSCONTROLLOGIC, INT_PSCONTROLLOGIC);
        psModelIntMap.put(PSAPPLICATIONLOGIC, INT_PSAPPLICATIONLOGIC);
        psModelIntMap.put(PSCOUNTER, INT_PSCOUNTER);
        psModelIntMap.put(PSCOUNTERTYPE, INT_PSCOUNTERTYPE);
        psModelIntMap.put(PSCTRLMSG, INT_PSCTRLMSG);
        psModelIntMap.put(PSCTRLMSGITEM, INT_PSCTRLMSGITEM);
        psModelIntMap.put(PSCUSTOMCONTROL, INT_PSCUSTOMCONTROL);
        psModelIntMap.put(PSDATAENTITY, INT_PSDATAENTITY);
        psModelIntMap.put(PSDATAITEMPARAM, INT_PSDATAITEMPARAM);
        psModelIntMap.put(PSDBDEVINST, INT_PSDBDEVINST);
        psModelIntMap.put(PSDBVALUEFUNC, INT_PSDBVALUEFUNC);
        psModelIntMap.put(PSDBVALUEOP, INT_PSDBVALUEOP);
        psModelIntMap.put(PSDCCODESNIPPET, INT_PSDCCODESNIPPET);
        psModelIntMap.put(PSDCCODESNIPPETREF, INT_PSDCCODESNIPPETREF);
        psModelIntMap.put(PSDCMSPLATFORM, INT_PSDCMSPLATFORM);
        psModelIntMap.put(PSDCMSPLATFORMFUNC, INT_PSDCMSPLATFORMFUNC);
        psModelIntMap.put(PSDCMSPLATFORMNODE, INT_PSDCMSPLATFORMNODE);
        psModelIntMap.put(PSDEACMODE, INT_PSDEACMODE);
        psModelIntMap.put(PSDEACMODEDATAITEM, INT_PSDEACMODEDATAITEM);
        psModelIntMap.put(PSDEACTION, INT_PSDEACTION);
        psModelIntMap.put(PSDEACTIONGROUP, INT_PSDEACTIONGROUP);
        psModelIntMap.put(PSDEACTIONLOGIC, INT_PSDEACTIONLOGIC);
        psModelIntMap.put(PSDEACTIONPARAM, INT_PSDEACTIONPARAM);
        psModelIntMap.put(PSDEACTIONINPUT, INT_PSDEACTIONINPUT);
        psModelIntMap.put(PSDEACTIONRETURN, INT_PSDEACTIONRETURN);
        psModelIntMap.put(PSDEDATASETINPUT, "net.ibizsys.model.dataentity.ds.IPSDEDataSetInput");
        psModelIntMap.put(PSDEDATASETRETURN, "net.ibizsys.model.dataentity.ds.IPSDEDataSetReturn");
        psModelIntMap.put(PSDEDATAQUERYINPUT, "net.ibizsys.model.dataentity.ds.IPSDEDataSetInput");
        psModelIntMap.put(PSDEDATAQUERYRETURN, "net.ibizsys.model.dataentity.ds.IPSDEDataSetReturn");
        psModelIntMap.put(PSDESERVICEAPIMETHODINPUT, INT_PSDESERVICEAPIMETHODINPUT);
        psModelIntMap.put(PSDESERVICEAPIMETHODRETURN, INT_PSDESERVICEAPIMETHODRETURN);
        psModelIntMap.put(PSDESERVICEAPIDTO, INT_PSDESERVICEAPIDTO);
        psModelIntMap.put(PSDESERVICEAPIDTOFIELD, INT_PSDESERVICEAPIDTOFIELD);
        psModelIntMap.put(PSSUBSYSSERVICEAPIMETHODINPUT, INT_PSSUBSYSSERVICEAPIMETHODINPUT);
        psModelIntMap.put(PSSUBSYSSERVICEAPIMETHODRETURN, INT_PSSUBSYSSERVICEAPIMETHODRETURN);
        psModelIntMap.put(PSSUBSYSSERVICEAPIDTO, INT_PSSUBSYSSERVICEAPIDTO);
        psModelIntMap.put(PSSUBSYSSERVICEAPIDTOFIELD, INT_PSSUBSYSSERVICEAPIDTOFIELD);
        psModelIntMap.put(PSDEACTIONTEMPL, INT_PSDEACTIONTEMPL);
        psModelIntMap.put(PSDEACTIONWIZARD, INT_PSDEACTIONWIZARD);
        psModelIntMap.put(PSDEAGDETAIL, INT_PSDEACTIONGROUPDETAIL);
        psModelIntMap.put(PSDEAWGROUP, INT_PSDEACTIONWIZARDGROUP);
        psModelIntMap.put(PSDEAWGRPDETAIL, INT_PSDEACTIONWIZARDGROUPDETAIL);
        psModelIntMap.put(PSDEAWITEM, INT_PSDEACTIONWIZARDITEM);
        psModelIntMap.put(PSDEBDTABLE, INT_PSDEBDTABLE);
        psModelIntMap.put(PSDECHART, INT_PSDECHART);
        psModelIntMap.put(PSDECHARTAXES, INT_PSDECHARTAXES);
        psModelIntMap.put(PSDECHARTCALENDAR, INT_PSDECHARTCALENDAR);
        psModelIntMap.put(PSDECHARTCOORDINATESYSTEM, INT_PSDECHARTCOORDINATESYSTEM);
        psModelIntMap.put(PSDECHARTDATASET, INT_PSDECHARTDATASET);
        psModelIntMap.put(PSDECHARTDATASETFIELD, INT_PSDECHARTDATASETFIELD);
        psModelIntMap.put(PSDECHARTDATASETGROUP, INT_PSDECHARTDATASETGROUP);
        psModelIntMap.put(PSDECHARTGEO, INT_PSDECHARTGEO);
        psModelIntMap.put(PSDECHARTGRID, INT_PSDECHARTGRID);
        psModelIntMap.put(PSDECHARTGRIDXAXIS, INT_PSCHARTGRIDXAXIS);
        psModelIntMap.put(PSDECHARTGRIDYAXIS, INT_PSCHARTGRIDYAXIS);
        psModelIntMap.put(PSDECHARTLEGEND, INT_PSDECHARTLEGEND);
        psModelIntMap.put("PSDECHARTDATAGRID", INT_PSDECHARTDATAGRID);
        psModelIntMap.put(PSDECHARTPARALLEL, INT_PSDECHARTPARALLEL);
        psModelIntMap.put(PSDECHARTPARALLELAXIS, INT_PSCHARTPARALLELAXIS);
        psModelIntMap.put(PSDECHARTPARAM, INT_PSDECHARTPARAM);
        psModelIntMap.put(PSDECHARTPOLAR, INT_PSDECHARTPOLAR);
        psModelIntMap.put(PSDECHARTPOLARANGLEAXIS, INT_PSCHARTPOLARANGLEAXIS);
        psModelIntMap.put(PSDECHARTPOLARRADIUSAXIS, INT_PSCHARTPOLARRADIUSAXIS);
        psModelIntMap.put(PSDECHARTRADAR, INT_PSDECHARTRADAR);
        psModelIntMap.put(PSDECHARTSERIESENCODE, INT_PSDECHARTSERIESENCODE);
        psModelIntMap.put(PSDECHARTSINGLE, INT_PSDECHARTSINGLE);
        psModelIntMap.put(PSDECHARTSINGLEAXIS, INT_PSCHARTSINGLEAXIS);
        psModelIntMap.put(PSDECHARTTITLE, INT_PSDECHARTTITLE);
        psModelIntMap.put(PSDECONTEXTMENU, INT_PSDECONTEXTMENU);
        psModelIntMap.put(PSDEDATAEXP, INT_PSDEDATAEXPORT);
        psModelIntMap.put(PSDEDATAEXPITEM, INT_PSDEDATAEXPORTITEM);
        psModelIntMap.put(PSDEDATAEXPGROUP, INT_PSDEDATAEXPORTGROUP);
        psModelIntMap.put(PSDEDATAIMP, INT_PSDEDATAIMPORT);
        psModelIntMap.put(PSDEDATAIMPITEM, INT_PSDEDATAIMPORTITEM);
        psModelIntMap.put(PSDENOTIFY, INT_PSDENOTIFY);
        psModelIntMap.put(PSDENOTIFYTARGET, INT_PSDENOTIFYTARGET);
        psModelIntMap.put(PSDEDATAQUERY, INT_PSDEDATAQUERY);
        psModelIntMap.put(PSDEDATARELATION, INT_PSDEDATARELATION);
        psModelIntMap.put(PSDEDATASET, INT_PSDEDATASET);
        psModelIntMap.put(PSDEDATASYNC, INT_PSDEDATASYNC);
        psModelIntMap.put(PSDEDATAVIEW, INT_PSDEDATAVIEW);
        psModelIntMap.put(PSDEDATAVIEWDATAITEM, INT_PSDEDATAVIEWDATAITEM);
        psModelIntMap.put(PSDEDATAVIEWITEM, INT_PSDEDATAVIEWITEM);
        psModelIntMap.put(PSDEDBCFG, INT_PSDEDBCONFIG);
        psModelIntMap.put(PSDEDBIDXFIELD, INT_PSDEDBINDEXFIELD);
        psModelIntMap.put(PSDEDBINDEX, INT_PSDEDBINDEX);
        psModelIntMap.put(PSDEDQCODE, INT_PSDEDATAQUERYCODE);
        psModelIntMap.put(PSDEDQCODECOND, INT_PSDEDATAQUERYCODECOND);
        psModelIntMap.put(PSDEDQCODEEXP, INT_PSDEDATAQUERYCODEEXP);
        psModelIntMap.put(PSDEDQCOND, INT_PSDEDQCONDITION);
        psModelIntMap.put(PSDEDQJOIN, INT_PSDEDQJOIN);
        psModelIntMap.put(PSDEDRBAR, INT_PSDEDRBAR);
        psModelIntMap.put(PSDEDRBARGROUP, INT_PSDEDRBARGROUP);
        psModelIntMap.put(PSDEDRBARITEM, INT_PSDEDRBARITEM);
        psModelIntMap.put(PSDEDRDETAIL, INT_PSDEDRDETAIL);
        psModelIntMap.put(PSDEDRGROUP, INT_PSDEDRGROUP);
        psModelIntMap.put(PSDEDRITEM, INT_PSDEDRITEM);
        psModelIntMap.put(PSDEDRTAB, INT_PSDEDRTAB);
        psModelIntMap.put(PSDEDRTABPAGE, INT_PSDEDRTABPAGE);
        psModelIntMap.put(PSDEDSCODE, INT_PSDEDATASETCODE);
        psModelIntMap.put(PSDEDSGRPPARAM, INT_PSDEDATASETGROUPPARAM);
        psModelIntMap.put(PSDEDSPARAM, INT_PSDEDATASETPARAM);
        psModelIntMap.put(PSDEDTSQUEUE, INT_PSDEDTSQUEUE);
        psModelIntMap.put(PSDEFDLOGIC, INT_PSDEFDLOGIC);
        psModelIntMap.put(PSDEFDTCOL, INT_PSDEFDTCOLUMN);
        psModelIntMap.put(PSDEFFORMITEM, INT_PSDEFFORMITEM);
        psModelIntMap.put(PSDEFGROUP, INT_PSDEFGROUP);
        psModelIntMap.put(PSDEFGROUPDETAIL, INT_PSDEFGROUPDETAIL);
        psModelIntMap.put(PSDEDOMAIN, INT_PSDEDOMAIN);
        psModelIntMap.put(PSDEDOMAINFIELD, INT_PSDEDOMAINFIELD);
        psModelIntMap.put(PSDEMETHODDTO, INT_PSDEMETHODDTO);
        psModelIntMap.put(PSDEMETHODDTOFIELD, INT_PSDEMETHODDTOFIELD);
        psModelIntMap.put(PSAPPDEMETHODDTO, INT_PSAPPDEMETHODDTO);
        psModelIntMap.put(PSAPPDEMETHODDTOFIELD, INT_PSAPPDEMETHODDTOFIELD);
        psModelIntMap.put(PSAPPDEMETHODINPUT, INT_PSAPPDEMETHODINPUT);
        psModelIntMap.put(PSAPPDEMETHODRETURN, INT_PSAPPDEMETHODRETURN);
        psModelIntMap.put(PSDEFILTER, INT_PSDEFILTER);
        psModelIntMap.put(PSDEFILTERFIELD, INT_PSDEFILTERFIELD);
        psModelIntMap.put(PSDEFIELD, INT_PSDEFIELD);
        psModelIntMap.put(PSDEFINPUTTIP, INT_PSDEFINPUTTIP);
        psModelIntMap.put(PSDEFINPUTTIPSET, INT_PSDEFINPUTTIPSET);
        psModelIntMap.put(PSDEFIUDETAIL, INT_PSDEFIUPDATEDETAIL);
        psModelIntMap.put(PSDEFIUPDATE, INT_PSDEFORMITEMUPDATE);
        psModelIntMap.put(PSDEFIVR, INT_PSDEFORMITEMVR);
        psModelIntMap.put(PSDEFORM, INT_PSDEFORM);
        psModelIntMap.put(PSDEFORMDATAITEM, INT_PSDEFORMDATAITEM);
        psModelIntMap.put(PSDEFORMDETAIL, INT_PSDEFORMDETAIL);
        psModelIntMap.put(PSDEFORMDETAIL_BUTTON, INT_PSDEFORMBUTTON);
        psModelIntMap.put(PSDEFORMDETAIL_BUTTONLIST, INT_PSDEFORMBUTTONLIST);
        psModelIntMap.put(PSDEFORMDETAIL_DRUIPART, INT_PSDEFORMDRUIPART);
        psModelIntMap.put(PSDEFORMDETAIL_FORMITEM, INT_PSDEFORMITEM);
        psModelIntMap.put(PSDEFORMDETAIL_FORMITEMEX, INT_PSDEFORMITEMEX);
        psModelIntMap.put(PSDEFORMDETAIL_FORMPAGE, INT_PSDEFORMPAGE);
        psModelIntMap.put(PSDEFORMDETAIL_FORMPART, INT_PSDEFORMFORMPART);
        psModelIntMap.put(PSDEFORMDETAIL_GROUPPANEL, INT_PSDEFORMGROUPPANEL);
        psModelIntMap.put(PSDEFORMDETAIL_IFRAME, INT_PSDEFORMIFRAME);
        psModelIntMap.put(PSDEFORMDETAIL_MDCTRL, INT_PSDEFORMMDCTRL);
        psModelIntMap.put(PSDEFORMDETAIL_RAWITEM, INT_PSDEFORMRAWITEM);
        psModelIntMap.put(PSDEFORMDETAIL_TABPAGE, INT_PSDEFORMTABPAGE);
        psModelIntMap.put(PSDEFORMDETAIL_TABPANEL, INT_PSDEFORMTABPANEL);
        psModelIntMap.put(PSDEFORMDETAIL_USERCONTROL, INT_PSDEFORMUSERCONTROL);
        psModelIntMap.put(PSDEFORM_EDITFORM, INT_PSDEEDITFORM);
        psModelIntMap.put(PSDEFORM_SEARCHFORM, INT_PSDESEARCHFORM);
        psModelIntMap.put(PSDEFSEARCH, INT_PSDEFSEARCH);
        psModelIntMap.put(PSDEFSFITEM, INT_PSDEFSEARCHMODE);
        psModelIntMap.put(PSDEFTYPE, INT_PSDEFIELDTYPE);
        psModelIntMap.put(PSDEFVALUERULE, INT_PSDEFVALUERULE);
        psModelIntMap.put(PSDEFVRCOND, INT_PSDEFVRCONDITION);
        psModelIntMap.put(PSDEGEIUDETAIL, INT_PSDEGEIUPDATEDETAIL);
        psModelIntMap.put(PSDEGEIUPDATE, INT_PSDEGRIDEDITITEMUPDATE);
        psModelIntMap.put(PSDEGRID, INT_PSDEGRID);
        psModelIntMap.put(PSDEGRIDCOL, INT_PSDEGRIDCOLUMN);
        psModelIntMap.put(PSDEGRIDDATAITEM, INT_PSDEGRIDDATAITEM);
        psModelIntMap.put(PSDEGRIDEDITITEM, INT_PSDEGRIDEDITITEM);
        psModelIntMap.put(PSDEGROUP, INT_PSDEGROUP);
        psModelIntMap.put(PSDEGROUPDETAIL, INT_PSDEGROUPDETAIL);
        psModelIntMap.put(PSSYSDEGROUP, INT_PSDEGROUP);
        psModelIntMap.put(PSSYSDEGROUPDETAIL, INT_PSDEGROUPDETAIL);
        psModelIntMap.put(PSDELIST, INT_PSDELIST);
        psModelIntMap.put(PSDELISTDATAITEM, INT_PSDELISTDATAITEM);
        psModelIntMap.put(PSDELISTITEM, INT_PSDELISTITEM);
        psModelIntMap.put(PSDELLCOND, INT_PSDELOGICLINKCOND);
        psModelIntMap.put(PSDELLCOND_CUSTOM, INT_PSDELOGICLINKCUSTOMCOND);
        psModelIntMap.put(PSDELLCOND_GROUP, INT_PSDELOGICLINKGROUPCOND);
        psModelIntMap.put(PSDELLCOND_SINGLE, INT_PSDELOGICLINKSINGLECOND);
        psModelIntMap.put(PSDELNPARAM, INT_PSDELOGICNODEPARAM);
        psModelIntMap.put(PSDELOGIC, INT_PSDELOGIC);
        psModelIntMap.put(PSDELOGICLINK, INT_PSDELOGICLINK);
        psModelIntMap.put(PSDELOGICNODE, INT_PSDELOGICNODE);
        psModelIntMap.put(PSDELOGICPARAM, INT_PSDELOGICPARAM);
        psModelIntMap.put(PSDELOGIC_VIEWLOGIC, INT_PSDEUILOGIC);
        psModelIntMap.put(PSDEMAINSTATE, INT_PSDEMAINSTATE);
        psModelIntMap.put(PSDEMAINSTATERS, INT_PSDEMAINSTATERS);
        psModelIntMap.put(PSDEMAP, INT_PSDEMAP);
        psModelIntMap.put(PSDEMAPACTION, INT_PSDEMAPACTION);
        psModelIntMap.put(PSDEMAPDETAIL, INT_PSDEMAPFIELD);
        psModelIntMap.put(PSDEMAPDQ, INT_PSDEMAPDATAQUERY);
        psModelIntMap.put(PSDEMAPDS, INT_PSDEMAPDATASET);
        psModelIntMap.put(PSDEMSACTION, INT_PSDEMAINSTATEACTION);
        psModelIntMap.put(PSDEMSOPPRIV, INT_PSDEMAINSTATEOPPRIV);
        psModelIntMap.put(PSDEMSFIELD, INT_PSDEMAINSTATEFIELD);
        psModelIntMap.put(PSDEOPPRIV, INT_PSDEOPPRIV);
        psModelIntMap.put(PSDEOPPRIVROLE, INT_PSDEOPPRIVROLE);
        psModelIntMap.put(PSDEPRINT, INT_PSDEPRINT);
        psModelIntMap.put(PSDER, INT_PSDERBASE);
        psModelIntMap.put(PSDERDEFMAP, INT_PSDERDEFIELDMAP);
        psModelIntMap.put(PSDER1NDEFMAP, INT_PSDER1NDEFIELDMAP);
        psModelIntMap.put(PSDERINDEXDEFMAP, INT_PSDERINDEXDEFIELDMAP);
        psModelIntMap.put(PSDERAGGDATADEFMAP, INT_PSDERAGGDATADEFIELDMAP);
        psModelIntMap.put(PSDEREPITEM, INT_PSDEREPORTITEM);
        psModelIntMap.put(PSDEREPORT, INT_PSDEREPORT);
        psModelIntMap.put(PSDEREPORTPANEL, INT_PSDEREPORTPANEL);
        psModelIntMap.put(PSDERGROUP, INT_PSDERGROUP);
        psModelIntMap.put(PSDERGROUPDETAIL, INT_PSDERGROUPDETAIL);
        psModelIntMap.put(PSDERNN, INT_PSDERNN);
        psModelIntMap.put(PSDER_DER11, INT_PSDER11);
        psModelIntMap.put(PSDER_DER1N, INT_PSDER1N);
        psModelIntMap.put(PSDER_DERCUSTOM, INT_PSDERCUSTOM);
        psModelIntMap.put(PSDER_DERINDEX, INT_PSDERINDEX);
        psModelIntMap.put(PSDER_DERINHERIT, INT_PSDERINHERIT);
        psModelIntMap.put(PSDER_DERMULINH, INT_PSDERMULTIINHERIT);
        psModelIntMap.put(PSDER_DERAGGDATA, INT_PSDERAGGDATA);
        psModelIntMap.put(PSDESADETAIL, INT_PSDESERVICEAPIMETHOD);
        psModelIntMap.put(PSDESARSDETAIL, INT_PSDESERVICEAPIMETHOD);
        psModelIntMap.put(PSDESAMPLEDATA, INT_PSDESAMPLEDATA);
        psModelIntMap.put(PSDESARS, INT_PSDESERVICEAPIRS);
        psModelIntMap.put(PSDESAVR, INT_PSDESERVICEAPIVR);
        psModelIntMap.put(PSDESEARCH, INT_PSDESEARCH);
        psModelIntMap.put(PSDESERVICEAPI, INT_PSDESERVICEAPI);
        psModelIntMap.put(PSDESERVICEAPIFIELD, INT_PSDESERVICEAPIFIELD);
        psModelIntMap.put(PSDETABLE, INT_PSDEDBTABLE);
        psModelIntMap.put(PSDETBITEM, INT_PSDETOOLBARITEM);
        psModelIntMap.put(PSDETOOLBAR, INT_PSDETOOLBAR);
        psModelIntMap.put(PSDETREECOL, INT_PSDETREECOLUMN);
        psModelIntMap.put(PSDETREENODE, INT_PSDETREENODE);
        psModelIntMap.put(PSDETREENODEDATAITEM, INT_PSDETREENODEDATAITEM);
        psModelIntMap.put(PSDETREENODECOL, INT_PSDETREENODECOLUMN);
        psModelIntMap.put(PSDETREENODEEDITITEM, INT_PSDETREENODEEDITITEM);
        psModelIntMap.put(PSDETREENODERS, INT_PSDETREENODERS);
        psModelIntMap.put(PSDETREENODERSNAVCONTEXT, INT_PSDETREENODERSNAVCONTEXT);
        psModelIntMap.put(PSDETREENODERSNAVPARAM, INT_PSDETREENODERSNAVPARAM);
        psModelIntMap.put(PSDETREENODERV, INT_PSDETREENODERV);
        psModelIntMap.put(PSDETREEVIEW, INT_PSDETREE);
        psModelIntMap.put(PSDEUAGROUP, INT_PSDEUIACTIONGROUP);
        psModelIntMap.put(PSDEUAGRPDETAIL, INT_PSDEUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSDEUIACTION, INT_PSDEUIACTION);
        psModelIntMap.put(PSDEUILLCOND, INT_PSDEUILOGICLINK);
        psModelIntMap.put(PSDEUILNPARAM, INT_PSDEUILOGICNODEPARAM);
        psModelIntMap.put(PSDEUILOGIC, INT_PSDEUILOGIC);
        psModelIntMap.put(PSDEUILOGICLINK, INT_PSDEUILOGICLINK);
        psModelIntMap.put(PSDEUILOGICNODE, INT_PSDEUILOGICNODE);
        psModelIntMap.put(PSDEUILOGICPARAM, INT_PSDEUILOGICPARAM);
        psModelIntMap.put(PSDEUNISTATE, INT_PSDEUNISTATE);
        psModelIntMap.put(PSDEUSERROLE, INT_PSDEUSERROLE);
        psModelIntMap.put(PSDEUTILDE, INT_PSDEUTIL);
        psModelIntMap.put(PSDEVSLNMSDEPAPI, INT_PSDEVSLNMSDEPAPI);
        psModelIntMap.put(PSDEVSLNMSDEPAPP, INT_PSDEVSLNMSDEPAPP);
        psModelIntMap.put(PSDEVSLNMSDEPFUNC, INT_PSDEVSLNMSDEPFUNC);
        psModelIntMap.put(PSDEWIZARD, INT_PSDEWIZARD);
        psModelIntMap.put(PSDEWIZARDFORM, INT_PSDEWIZARDFORM);
        psModelIntMap.put(PSDEWIZARDPANEL, INT_PSDEWIZARDPANEL);
        psModelIntMap.put(PSDEWIZARDSTEP, INT_PSDEWIZARDSTEP);
        psModelIntMap.put(PSEDITOR, INT_PSEDITOR);
        psModelIntMap.put(PSEDITORITEM, INT_PSEDITORITEM);
        psModelIntMap.put(PSEDITORTYPE, INT_PSEDITORTYPE);
        psModelIntMap.put(PSEXPBAR, INT_PSEXPBAR);
        psModelIntMap.put(PSHELPARTICLE, INT_PSHELPARTICLE);
        psModelIntMap.put(PSHELPMODULE, INT_PSHELPMODULE);
        psModelIntMap.put(PSHELPPRJ, INT_PSHELPPRJ);
        psModelIntMap.put(PSHELPRESOURCE, INT_PSHELPRESOURCE);
        psModelIntMap.put(PSHELPSECTION, INT_PSHELPSECTION);
        psModelIntMap.put(PSLANGUAGEITEM, INT_PSLANGUAGEITEM);
        psModelIntMap.put(PSLANGUAGERES, INT_PSLANGUAGERES);
        psModelIntMap.put(PSLAYOUT, INT_PSLAYOUT);
        psModelIntMap.put(PSLAYOUTPOS, INT_PSLAYOUTPOS);
        psModelIntMap.put(PSMOBAPPPACK, INT_PSMOBAPPPACK);
        psModelIntMap.put(PSMOBAPPSTARTPAGE, INT_PSMOBAPPSTARTPAGE);
        psModelIntMap.put(PSMODEL, INT_PSMODEL);
        psModelIntMap.put(PSMODULE, INT_PSSYSTEMMODULE);
        psModelIntMap.put(PSMSPLATFORM, INT_PSMSPLATFORM);
        psModelIntMap.put(PSMSPLATFORMFUNC, INT_PSMSPLATFORMFUNC);
        psModelIntMap.put(PSMSPLATFORMNODE, INT_PSMSPLATFORMNODE);
        psModelIntMap.put(PSPANELENGINE, INT_PSPANELENGINE);
        psModelIntMap.put(PSPANELENGINEPARAM, INT_PSAPPVIEWENGINEPARAM);
        psModelIntMap.put(PSPANELITEMLOGIC, INT_PSPANELITEMLOGIC);
        psModelIntMap.put(PSPF, INT_PSPF);
        psModelIntMap.put(PSPFAPPTEMPL, INT_PSPFAPPTEMPL);
        psModelIntMap.put(PSPFCDN, INT_PSPFCDN);
        psModelIntMap.put(PSPFCODEFOLDER, INT_PSPFCODEFOLDER);
        psModelIntMap.put(PSPFCTRLTEMPL, INT_PSPFCTRLTEMPL);
        psModelIntMap.put(PSPFEDITORTEMPL, INT_PSPFEDITORTEMPL);
        psModelIntMap.put(PSPFPKG, INT_PSPFPKG);
        psModelIntMap.put(PSPFPKGVER, INT_PSPFPKGVER);
        psModelIntMap.put(PSPFPKGVERCDN, INT_PSPFPKGVERCDN);
        psModelIntMap.put(PSPFPLUGIN, INT_PSPFPLUGIN);
        psModelIntMap.put(PSPFPLUGINTEMPL, INT_PSPFPLUGINTEMPL);
        psModelIntMap.put(PSPFPUBCODE, INT_PSPFPUBCODE);
        psModelIntMap.put(PSPFPUBOBJ, INT_PSPFPUBOBJ);
        psModelIntMap.put(PSPFSTYLE, INT_PSPFSTYLE);
        psModelIntMap.put(PSPFSTYLECODE, INT_PSPFSTYLECODE);
        psModelIntMap.put(PSPFSTYLEPKG, INT_PSPFSTYLEPKG);
        psModelIntMap.put(PSPFSTYLEPRJ, INT_PSPFSTYLEPRJ);
        psModelIntMap.put(PSPFVIEWTEMPL, INT_PSPFVIEWTEMPL);
        psModelIntMap.put(PSPFXCODEOBJECT, INT_PSPFXCODEOBJECT);
        psModelIntMap.put(PSPORTLETTYPE, INT_PSPORTLETTYPE);
        psModelIntMap.put(PSSF, INT_PSSF);
        psModelIntMap.put(PSSFACHANDLER, INT_PSSFACHANDLER);
        psModelIntMap.put(PSSFCODEFOLDER, INT_PSSFCODEFOLDER);
        psModelIntMap.put(PSSFCODETEMPL, INT_PSSFCODETEMPL);
        psModelIntMap.put(PSSFCODETYPE, INT_PSSFCODETYPE);
        psModelIntMap.put(PSSFPKG, INT_PSSFPKG);
        psModelIntMap.put(PSSFPKGVER, INT_PSSFPKGVER);
        psModelIntMap.put(PSSFPLUGINTEMPL, INT_PSSFPLUGINTEMPL);
        psModelIntMap.put(PSSFPUBOBJ, INT_PSSFPUBOBJ);
        psModelIntMap.put(PSSFSTYLE, INT_PSSFSTYLE);
        psModelIntMap.put(PSSFSTYLEPKG, INT_PSSFSTYLEPKG);
        psModelIntMap.put(PSSFSTYLEPRJ, INT_PSSFSTYLEPRJ);
        psModelIntMap.put(PSSFSTYLEVER, INT_PSSFSTYLEVER);
        psModelIntMap.put(PSSFVERCODE, INT_PSSFVERCODE);
        psModelIntMap.put(PSSFVERCODEITEM, INT_PSSFVERCODEITEM);
        psModelIntMap.put(PSSFXCODEOBJECT, INT_PSSFXCODEOBJECT);
        psModelIntMap.put(PSSUBSYS, INT_PSSUBSYS);
        psModelIntMap.put(PSSUBSYSSERVICEAPI, INT_PSSUBSYSSERVICEAPI);
        psModelIntMap.put(PSSUBSYSVER, INT_PSSUBSYSVER);
        psModelIntMap.put(PSSUBVIEWTYPE, INT_PSSUBVIEWTYPE);
        psModelIntMap.put(PSSYSACTOR, INT_PSSYSACTOR);
        psModelIntMap.put(PSSYSAPP, INT_PSAPPLICATION);
        psModelIntMap.put(PSSYSAPPDEUAGROUP, INT_PSAPPDEUIACTIONGROUP);
        psModelIntMap.put(PSSYSAPPDEUAGRPDETAIL, INT_PSAPPDEUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSSYSAPPDEUIACTION, INT_PSAPPDEUIACTION);
        psModelIntMap.put(PSSYSAPP_UI, INT_PSAPPLICATIONUI);
        psModelIntMap.put(PSSYSBACKSERVICE, INT_PSSYSBACKSERVICE);
        psModelIntMap.put(PSSYSBDCOLSET, INT_PSSYSBDCOLSET);
        psModelIntMap.put(PSSYSBDCOLUMN, INT_PSSYSBDCOLUMN);
        psModelIntMap.put(PSSYSBDMODULE, INT_PSSYSBDMODULE);
        psModelIntMap.put(PSSYSBDPART, INT_PSSYSBDPART);
        psModelIntMap.put(PSSYSBDSCHEME, INT_PSSYSBDSCHEME);
        psModelIntMap.put(PSSYSBDTABLE, INT_PSSYSBDTABLE);
        psModelIntMap.put(PSSYSBDTABLEDE, INT_PSSYSBDTABLEDE);
        psModelIntMap.put(PSSYSBDTABLERS, INT_PSSYSBDTABLERS);
        psModelIntMap.put(PSSYSCALENDAR, INT_PSSYSCALENDAR);
        psModelIntMap.put(PSSYSCALENDARITEM, INT_PSSYSCALENDARITEM);
        psModelIntMap.put(PSSYSCALENDARITEMRV, INT_PSSYSCALENDARITEMRV);
        psModelIntMap.put(PSSYSCONTENT, INT_PSSYSCONTENT);
        psModelIntMap.put(PSSYSCONTENTCAT, INT_PSSYSCONTENTCAT);
        psModelIntMap.put(PSSYSCOUNTER, INT_PSSYSCOUNTER);
        psModelIntMap.put(PSSYSCOUNTERITEM, INT_PSSYSCOUNTERITEM);
        psModelIntMap.put(PSSYSCOUNTERREF, INT_PSSYSCOUNTERREF);
        psModelIntMap.put(PSSYSCSS, INT_PSSYSCSS);
        psModelIntMap.put(PSSYSCTRLLOGICGROUP, INT_PSAPPDEUILOGICGROUP);
        psModelIntMap.put(PSSYSCTRLLOGICGRPDETAIL, INT_PSAPPDEUILOGICGROUPDETAIL);
        psModelIntMap.put(PSSYSDASHBOARD, INT_PSSYSDASHBOARD);
        psModelIntMap.put(PSSYSDATASYNCAGENT, INT_PSSYSDATASYNCAGENT);
        psModelIntMap.put(PSSYSDBCOLUMN, INT_PSSYSDBCOLUMN);
        psModelIntMap.put(PSSYSDBSCHEME, INT_PSSYSDBSCHEME);
        psModelIntMap.put(PSSYSDBTABLE, INT_PSSYSDBTABLE);
        psModelIntMap.put(PSSYSDBVF, INT_PSSYSDBVALUEFUNC);
        psModelIntMap.put(PSSYSDBVFCODE, INT_PSSYSDBVALUEFUNCCODE);
        psModelIntMap.put(PSSYSDEFTYPE, INT_PSSYSDEFTYPE);
        psModelIntMap.put(PSSYSDICTCAT, INT_PSSYSDICTCAT);
        psModelIntMap.put(PSSYSDMITEM, INT_PSSYSDMITEM);
        psModelIntMap.put(PSSYSDMVER, INT_PSSYSDMVER);
        psModelIntMap.put(PSSYSDTSQUEUE, INT_PSSYSDTSQUEUE);
        psModelIntMap.put(PSSYSDYNAMODEL, INT_PSSYSDYNAMODEL);
        psModelIntMap.put(PSSYSDYNAMODELATTR, INT_PSSYSDYNAMODELATTR);
        psModelIntMap.put(PSSYSEDITORSTYLE, INT_PSSYSEDITORSTYLE);
        psModelIntMap.put(PSSYSERMAP, INT_PSSYSERMAP);
        psModelIntMap.put(PSSYSERMAPNODE, INT_PSSYSERMAPNODE);
        psModelIntMap.put("PSSYSUCMAP", INT_PSSYSUCMAP);
        psModelIntMap.put("PSSYSUCMAPNODE", INT_PSSYSUCMAPNODE);
        psModelIntMap.put(PSSYSIMAGE, INT_PSSYSIMAGE);
        psModelIntMap.put(PSSYSMAPITEM, INT_PSSYSMAPITEM);
        psModelIntMap.put(PSSYSMAPVIEW, INT_PSSYSMAP);
        psModelIntMap.put(PSSYSMODELGROUP, INT_PSSYSMODELGROUP);
        psModelIntMap.put(PSSYSMSGTEMPL, INT_PSSYSMSGTEMPL);
        psModelIntMap.put(PSSYSOPPRIV, INT_PSSYSUSERROLE);
        psModelIntMap.put("PSSYSUSERROLE", INT_PSSYSUSERROLE);
        psModelIntMap.put(PSSYSPANELDATAITEM, INT_PSSYSPANELDATAITEM);
        psModelIntMap.put(PSSYSPDTVIEW, INT_PSSYSPDTVIEW);
        psModelIntMap.put(PSSYSPFPITEMPL, INT_PSSYSPFPLUGINTEMPL);
        psModelIntMap.put(PSSYSPFPLUGIN, INT_PSSYSPFPLUGIN);
        psModelIntMap.put(PSSYSPORTLET, INT_PSSYSPORTLET);
        psModelIntMap.put(PSSYSPORTLETCAT, INT_PSSYSPORTLETCAT);
        psModelIntMap.put(PSSYSREF, INT_PSSYSREF);
        psModelIntMap.put(PSSYSREQITEM, INT_PSSYSREQITEM);
        psModelIntMap.put(PSSYSRESOURCE, INT_PSSYSRESOURCE);
        psModelIntMap.put(PSSYSRUNSESSION, INT_PSSYSRUNSESSION);
        psModelIntMap.put(PSSYSSAMPLEVALUE, INT_PSSYSSAMPLEVALUE);
        psModelIntMap.put(PSSYSSEARCHBAR, INT_PSSYSSEARCHBAR);
        psModelIntMap.put(PSSYSSEARCHBARITEM, INT_PSSYSSEARCHBARITEM);
        psModelIntMap.put(PSSYSSEARCHBARFILTER, INT_PSSYSSEARCHBARFILTER);
        psModelIntMap.put(PSSYSSEARCHBARGROUP, INT_PSSYSSEARCHBARGROUP);
        psModelIntMap.put(PSSYSSEARCHBARQUICKSEARCH, INT_PSSYSSEARCHBARQUICKSEARCH);
        psModelIntMap.put(PSSYSSEARCHDE, INT_PSSYSSEARCHDE);
        psModelIntMap.put(PSSYSSEARCHDEFIELD, INT_PSSYSSEARCHDEFIELD);
        psModelIntMap.put(PSSYSSEARCHDOC, INT_PSSYSSEARCHDOC);
        psModelIntMap.put(PSSYSSEARCHFIELD, INT_PSSYSSEARCHFIELD);
        psModelIntMap.put(PSSYSSEARCHSCHEME, INT_PSSYSSEARCHSCHEME);
        psModelIntMap.put(PSSYSSERVICEAPI, INT_PSSYSSERVICEAPI);
        psModelIntMap.put(PSSYSSFPITEMPL, INT_PSSYSSFPLUGINTEMPL);
        psModelIntMap.put(PSSYSSFPLUGIN, INT_PSSYSSFPLUGIN);
        psModelIntMap.put(PSSYSSFPUB, INT_PSSYSSFPUB);
        psModelIntMap.put(PSSYSSFPUBPKG, INT_PSSYSSFPUBPKG);
        psModelIntMap.put(PSSYSTCASSERT, INT_PSSYSTESTCASEASSERT);
        psModelIntMap.put(PSSYSTCASSERT2, INT_PSSYSTESTCASEASSERT);
        psModelIntMap.put(PSSYSTCINPUT, INT_PSSYSTESTCASEINPUT);
        psModelIntMap.put(PSSYSTCINPUT2, INT_PSSYSTESTCASEINPUT);
        psModelIntMap.put(PSSYSTDITEM, INT_PSSYSTESTDATAITEM);
        psModelIntMap.put(PSSYSTEM, INT_PSSYSTEM);
        psModelIntMap.put(PSSYSTEM_SETTING, INT_PSSYSTEMSETTING);
        psModelIntMap.put(PSSYSTESTCASE, INT_PSSYSTESTCASE);
        psModelIntMap.put(PSSYSTESTCASE2, INT_PSSYSTESTCASE2);
        psModelIntMap.put(PSSYSTESTDATA, INT_PSSYSTESTDATA);
        psModelIntMap.put(PSSYSTESTMODULE, INT_PSSYSTESTMODULE);
        psModelIntMap.put(PSSYSTESTPRJ, INT_PSSYSTESTPRJ);
        psModelIntMap.put(PSSYSTITLEBAR, INT_PSSYSTITLEBAR);
        psModelIntMap.put(PSSYSUNIRES, INT_PSSYSUNIRES);
        psModelIntMap.put(PSSYSUNISTATE, INT_PSSYSUNISTATE);
        psModelIntMap.put(PSSYSUNIT, INT_PSSYSUNIT);
        psModelIntMap.put(PSSYSUSERCASE, INT_PSSYSUSECASE);
        psModelIntMap.put(PSSYSUSERCASERS, INT_PSSYSUSECASERS);
        psModelIntMap.put("PSSYSUSECASE", INT_PSSYSUSECASE);
        psModelIntMap.put("PSSYSUSECASERS", INT_PSSYSUSECASERS);
        psModelIntMap.put(PSSYSUSERDR, INT_PSSYSUSERDR);
        psModelIntMap.put(PSSYSUSERMODE, INT_PSSYSUSERMODE);
        psModelIntMap.put(PSSYSUSERROLEDATA, INT_PSSYSUSERROLEDATA);
        psModelIntMap.put(PSSYSUSERROLERES, INT_PSSYSUSERROLERES);
        psModelIntMap.put(PSSYSUTILDE, INT_PSSYSUTIL);
        psModelIntMap.put(PSSYSVALUERULE, INT_PSSYSVALUERULE);
        psModelIntMap.put(PSSYSVIEWLAYOUTPANEL, INT_PSSYSVIEWLAYOUTPANEL);
        psModelIntMap.put(PSSYSVIEWLOGIC, INT_PSSYSVIEWLOGIC);
        psModelIntMap.put(PSSYSVIEWLOGICPARAM, INT_PSSYSVIEWLOGICPARAM);
        psModelIntMap.put(PSSYSVIEWPANEL, INT_PSSYSPANEL);
        psModelIntMap.put(PSSYSVIEWPANELITEM, INT_PSSYSPANELITEM);
        psModelIntMap.put(PSSYSVIEWPANELITEM_BUTTON, INT_PSSYSPANELBUTTON);
        psModelIntMap.put(PSSYSVIEWPANELITEM_BUTTONLIST, INT_PSSYSPANELBUTTONLIST);
        psModelIntMap.put(PSSYSVIEWPANELITEM_CONTAINER, INT_PSSYSPANELCONTAINER);
        psModelIntMap.put(PSSYSVIEWPANELITEM_CONTROL, INT_PSSYSPANELCONTROL);
        psModelIntMap.put(PSSYSVIEWPANELITEM_CTRLPOS, INT_PSSYSPANELCTRLPOS);
        psModelIntMap.put(PSSYSVIEWPANELITEM_FIELD, INT_PSSYSPANELFIELD);
        psModelIntMap.put(PSSYSVIEWPANELITEM_RAWITEM, INT_PSSYSPANELRAWITEM);
        psModelIntMap.put(PSSYSVIEWPANELITEM_TABPAGE, INT_PSSYSPANELTABPAGE);
        psModelIntMap.put(PSSYSVIEWPANELITEM_TABPANEL, INT_PSSYSPANELTABPANEL);
        psModelIntMap.put(PSSYSVIEWPANELITEM_USERCONTROL, INT_PSSYSPANELUSERCONTROL);
        psModelIntMap.put(PSSYSVIEWPANELITEM_PARAM, INT_PSSYSPANELITEMPARAM);
        psModelIntMap.put(PSSYSWFSETTING, INT_PSSYSWFSETTING);
        psModelIntMap.put(PSWFUTILUIACTION, INT_PSWFUTILUIACTION);
        psModelIntMap.put(PSTABEXPPANEL, INT_PSTABEXPPANEL);
        psModelIntMap.put(PSVIEWENGINE, INT_PSVIEWENGINE);
        psModelIntMap.put(PSVIEWMSG, INT_PSVIEWMSG);
        psModelIntMap.put(PSVIEWMSGGROUP, INT_PSVIEWMSGGROUP);
        psModelIntMap.put(PSVIEWMSGGRPDETAIL, INT_PSVIEWMSGGROUPDETAIL);
        psModelIntMap.put(PSVIEWTYPE, INT_PSVIEWTYPE);
        psModelIntMap.put(PSVIEWWIZARDGROUP, INT_PSVIEWWIZARDGROUP);
        psModelIntMap.put(PSWFDE, INT_PSDEWF);
        psModelIntMap.put(PSWFLINK, INT_PSWFLINK);
        psModelIntMap.put(PSWFLINKCOND, INT_PSWFLINKCOND);
        psModelIntMap.put(PSWFLINKROLE, INT_PSWFLINKROLE);
        psModelIntMap.put(PSWFPROCESS, INT_PSWFPROCESS);
        psModelIntMap.put(PSWFPROCPARAM, INT_PSWFPROCESSPARAM);
        psModelIntMap.put(PSWFPROCROLE, INT_PSWFPROCESSROLE);
        psModelIntMap.put(PSWFPROCSUBWF, INT_PSWFPROCESSSUBWF);
        psModelIntMap.put(PSWFROLE, INT_PSWFROLE);
        psModelIntMap.put(PSWFUAGROUP, INT_PSWFUIACTIONGROUP);
        psModelIntMap.put(PSWFUAGRPDETAIL, INT_PSWFUIACTIONGROUPDETAIL);
        psModelIntMap.put(PSWFUIACTION, INT_PSWFUIACTION);
        psModelIntMap.put(PSWFVERSION, INT_PSWFVERSION);
        psModelIntMap.put(PSWFWORKTIME, INT_PSWFWORKTIME);
        psModelIntMap.put(PSWORKFLOW, INT_PSWORKFLOW);
        psModelIntMap.put(PSWXACCOUNT, INT_PSWXACCOUNT);
        psModelIntMap.put(PSWXENTAPP, INT_PSWXENTAPP);
        psModelIntMap.put(PSWXLOGIC, INT_PSWXLOGIC);
        psModelIntMap.put(PSWXMENU, INT_PSWXMENU);
        psModelIntMap.put(PSWXMENUFUNC, INT_PSWXMENUFUNC);
        psModelIntMap.put(PSWXMENUITEM, INT_PSWXMENUITEM);
        psModelIntMap.put(PSDETREEGRIDEX, INT_PSDETREEGRIDEX);
        psModelIntMap.put(PSDEGANTT, INT_PSDEGANTT);
        psModelIntMap.put(PSDEGEIVR, INT_PSDEGRIDEDITITEMVR);
        psModelIntMap.put(PSDEKANBAN, INT_PSDEKANBAN);
        psModelIntMap.put(PSNAVIGATECONTEXT, INT_PSNAVIGATECONTEXT);
        psModelIntMap.put(PSNAVIGATEPARAM, INT_PSNAVIGATEPARAM);
        psModelIntMap.put(PSUIACTIONPARAM, INT_PSUIACTIONPARAM);
        psModelIntMap.put(PSDEMETHOD, INT_PSDEMETHOD);
        psModelIntMap.put(PSDEACTIONMETHOD, INT_PSDEACTIONMETHOD);
        psModelIntMap.put(PSDEDATASETMETHOD, INT_PSDEDATASETMETHOD);
        psModelIntMap.put(PSDEACTIONVR, INT_PSDEACTIONVR);
        psModelIntMap.put(PSDESTATEWIZARDPANEL, INT_PSDESTATEWIZARDPANEL);
        psModelIntMap.put(PSAPPDEFLOGIC, INT_PSAPPDEFLOGIC);
        psModelIntMap.put(PSDEFLOGIC, INT_PSDEFLOGIC);
        psModelIntMap.put(PSDEFUIMODE, INT_PSDEFUIMODE);
        psModelIntMap.put(PSDEFFORMITEM, INT_PSDEFFORMITEM);
        psModelIntMap.put(PSDEFGRIDCOLUMN, INT_PSDEFGRIDCOLUMN);
        psModelIntMap.put("PSAPPDEFUIMODE", INT_PSAPPDEFUIMODE);
        psModelIntMap.put(PSAPPPFPLUGINREF, INT_PSAPPPFPLUGINREF);
        psModelIntMap.put(PSAPPEDITORSTYLEREF, INT_PSAPPEDITORSTYLEREF);
        psModelIntMap.put(PSAPPSUBVIEWTYPEREF, INT_PSAPPSUBVIEWTYPEREF);
        psModelIntMap.put(PSSYSSEQUENCE, INT_PSSYSSEQUENCE);
        psModelIntMap.put(PSSYSTRANSLATOR, INT_PSSYSTRANSLATOR);
        psModelIntMap.put(PSSYSMSGQUEUE, INT_PSSYSMSGQUEUE);
        psModelIntMap.put(PSSYSMSGTARGET, INT_PSSYSMSGTARGET);
        psModelIntMap.put(PSSUBSYSSERVICEAPIDE, INT_PSSUBSYSSERVICEAPIDE);
        psModelIntMap.put(PSSYSDYNAMODEL, INT_PSDYNAMODEL);
        psModelIntMap.put(PSSYSDYNAMODELATTR, INT_PSDYNAMODELATTR);
        psModelIntMap.put("PSJSONSCHEMA", INT_PSJSONSCHEMA);
        psModelIntMap.put("PSJSONNODESCHEMA", INT_PSJSONNODESCHEMA);
        psModelIntMap.put("PSJSONPROPERTY", INT_PSJSONPROPERTY);
        psModelIntMap.put("PSSYSDBINDEX", INT_PSSYSDBINDEX);
        psModelIntMap.put("PSSYSDBINDEXCOLUMN", INT_PSSYSDBINDEXCOLUMN);
        psModelIntMap.put(PSSYSMETHODDTO, INT_PSSYSMETHODDTO);
        psModelIntMap.put(PSSYSMETHODDTOFIELD, INT_PSSYSMETHODDTOFIELD);
        psModelIntMap.put(PSAPPMETHODDTO, INT_PSAPPMETHODDTO);
        psModelIntMap.put(PSAPPMETHODDTOFIELD, INT_PSAPPMETHODDTOFIELD);
        psModelIntMap.put(PSAPPDEREPORT, INT_PSAPPDEREPORT);
        psModelIntMap.put(PSAPPDEREPITEM, INT_PSAPPDEREPITEM);
        psModelIntMap.put(PSDEGRIDLOGIC, INT_PSDEGRIDLOGIC);
        psModelIntMap.put(PSDETREELOGIC, INT_PSDETREELOGIC);
        psModelIntMap.put(PSAPPLOGIC, INT_PSAPPLOGIC);
        psModelIntMap.put(PSDEFORMLOGIC, INT_PSDEFORMLOGIC);
        psModelIntMap.put(PSDEDATAVIEWLOGIC, INT_PSDEDATAVIEWLOGIC);
        psModelIntMap.put(PSDELISTLOGIC, INT_PSDELISTLOGIC);
        psModelIntMap.put(PSDEWIZARDLOGIC, INT_PSDEWIZARDLOGIC);
        psModelIntMap.put(PSDECHARTLOGIC, INT_PSDECHARTLOGIC);
        psModelIntMap.put(PSDETOOLBARLOGIC, INT_PSDETOOLBARLOGIC);
        psModelIntMap.put(PSSYSCALENDARLOGIC, INT_PSSYSCALENDARLOGIC);
        psModelIntMap.put(PSSYSDASHBOARDLOGIC, INT_PSSYSDASHBOARDLOGIC);
        psModelIntMap.put(PSSYSMAPLOGIC, INT_PSSYSMAPLOGIC);
        psModelIntMap.put(PSSYSSEARCHBARLOGIC, INT_PSSYSSEARCHBARLOGIC);
        psModelIntMap.put(PSAPPMENULOGIC, INT_PSAPPMENULOGIC);
        psModelIntMap.put(PSDEDRLOGIC, INT_PSDEDRLOGIC);
        psModelIntMap.put(PSCONTROLRENDER, INT_PSCONTROLRENDER);
        psModelIntMap.put(PSCONTROLATTRIBUTE, INT_PSCONTROLATTRIBUTE);
        psModelIntMap.put("PSSYSPANELLOGIC", INT_PSSYSPANELLOGIC2);
        psModelIntMap.put(PSAPPDEMAP, INT_PSAPPDEMAP);
        psModelIntMap.put(PSAPPDEMAPFIELD, INT_PSAPPDEMAPFIELD);
    }

    public static final String getModelInterface(String strModelType) {
        if (strModelType == null) {
            return "";
        }
        String strType = psModelIntMap.get(strModelType);
        if (strType == null) {
            return "";
        }
        return strType;
    }

    /*
     * Opcode count of 25228 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    public static ArrayList<IPSObject> getPSModels(IPSSystem iPSSystem, String strModelType, String strModelId) throws Exception {
        IPSDEFUIMode iPSDEFUIMode;
        Iterator<?> psDEFUIModes;
        IPSPFPubSupportable iPSPFPubSupportable;
        IPSCodePublisherParam iPSCodePublisherParam;
        Iterator<IPSCodePublisherParam> params;
        IPSCodePublisherMacro iPSCodePublisherMacro;
        Iterator<IPSCodePublisherMacro> macros;
        IPSSFPubSupportable iPSSFPubSupportable;
        IPSNavigateParamContainer iPSNavigatable;
        IPSDETreeNodeRS iPSDETreeNodeRS;
        IDataItem iDataItem;
        IPSDEACMode iPSDEACMode;
        Iterator dataItems;
        IPSDataItem iPSDataItem;
        IPSWFUIActionGroupDetail iPSWFUIActionGroupDetail;
        IPSAppWFUIActionGroup iPSAppWFUIActionGroup;
        Iterator<IPSWFUIActionGroupDetail> psWFUIActionGroupDetails;
        IPSAppWFUIActionGroup iPSAppWFUIActionGroup2;
        Iterator<IPSAppWFUIActionGroup> psAppWFUIActionGroups;
        IPSAppWF iPSAppWF;
        IPSAppWFUIAction iPSAppWFUIAction;
        IPSAppWFVer iPSAppWFVer;
        Iterator<IPSAppWFUIAction> psAppWFUIActions;
        IPSSysBDTable iPSSysBDTable;
        IPSSysBDScheme iPSSysBDScheme;
        IPSSysAIPipelineAgent iPSSysAIPipelineAgent;
        IPSSysAIFactory iPSSysAIFactory;
        IPSAppBIReport iPSAppBIReport;
        IPSAppBICube iPSAppBICube;
        IPSAppBIScheme iPSAppBIScheme;
        IPSSysBIReport iPSSysBIReport;
        IPSSysBICube iPSSysBICube;
        Iterator<?> psSysBIHierarchies;
        IPSSysBIScheme iPSSysBIScheme;
        IPSSysEAIDE iPSSysEAIDE;
        IPSSysEAIElement iPSSysEAIElement;
        IPSSysEAIScheme iPSSysEAIScheme;
        IPSSysSearchScheme iPSSysSearchScheme;
        IPSAppDEMap iPSAppDEMap;
        IPSAppDEDataExport iPSAppDEDataExport;
        IPSDEMSLogic iPSDEMSLogic;
        IPSAppDEUILogic iPSAppDEUILogic;
        IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail;
        IPSAppDEUILogicGroup iPSAppDEUILogicGroup;
        Iterator<? extends IPSAppDEUILogicGroupDetail> psAppDEUILogicGroupDetails;
        IPSAppDEUILogicGroup iPSAppDEUILogicGroup2;
        Iterator<IPSAppDEUILogicGroup> psAppDEUILogicGroups;
        IPSSysUserRole iPSSysUserRole;
        IPSAppDELogic iPSAppDELogic;
        IPSSysDBTable iPSSysDBTable;
        IPSSysTestCaseAssert iPSSysTestCaseAssert;
        Iterator<IPSSysTestCaseAssert> psSysTestCaseAsserts;
        IPSSysTestCaseInput iPSSysTestCaseInput;
        Iterator<IPSSysTestCaseInput> psSysTestCaseInputs;
        Iterator<IPSSysReqItem> psSysReqItems;
        IPSSysTestPrj iPSSysTestPrj;
        IPSDEUIActionGroupDetail iPSDEUIActionGroupDetail;
        IPSAppDEUIActionGroup iPSAppDEUIActionGroup;
        Iterator<IPSDEUIActionGroupDetail> psDEUIActionGroupDetails;
        IPSDERGroupDetail iPSDERGroupDetail;
        Iterator<IPSDERGroupDetail> psDERGroupDetails;
        IPSDERGroup iPSDERGroup;
        IPSDEGroupDetail iPSDEGroupDetail;
        Iterator<IPSDEGroupDetail> psDEGroupDetails;
        IPSDEGroup iPSDEGroup;
        Iterator<IPSSysDEGroup> psDEGroups;
        IPSAppDEUIActionGroup iPSAppDEUIActionGroup2;
        Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups;
        IPSAppDEUIAction iPSAppDEUIAction;
        Iterator<IPSAppDEUIAction> psAppDEUIActions;
        IPSOpenAPI3Info iPSOpenAPI3Info;
        IPSOpenAPI3Components iPSOpenAPI3Components;
        IPSOpenAPI3Schema iPSOpenAPI3Schema;
        IPSModelObject item;
        Iterator<?> items;
        IPSJsonObjectSchema iPSJsonObjectSchema;
        IPSSysDynaModel iPSSysDynaModel;
        IPSSysContentCat iPSSysContentCat;
        Iterator<IPSSysContentCat> psSysContentCats;
        IPSDEServiceAPIMethod iPSDEServiceAPIMethod;
        Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods;
        IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIMethod;
        IPSDEServiceAPIMethod iPSDEServiceAPIMethod2;
        IPSSubSysServiceAPI iPSSubSysServiceAPI;
        IPSSysServiceAPI iPSSysServiceAPI;
        IPSDEServiceAPI iPSDEServiceAPI;
        IPSSysMethodDTO iPSSysMethodDTO;
        IPSAppDataEntity iPSAppDataEntity;
        Iterator<?> psDEMethodDTOFields;
        Iterator<?> psDEMethodDTOs;
        Iterator<?> psDEMapDataSets;
        Iterator<?> psDEMapActions;
        IPSDEMap iPSDEMap;
        Iterator<IPSDEDataSync> psDEDataSyncs;
        ArrayList<IPSObject> layoutList;
        IPSAppView iPSAppView;
        ArrayList<IPSObject> appViewList;
        IPSModelObject iPSPanelLogic;
        Iterator<?> psPanelLogics;
        IPSSysPanel iPSSysPanel;
        Iterator<? extends IPSPanelItem> psPanelItems;
        IPSSysPanel iPSSysPanel2;
        IPSDEList iPSDEList;
        IPSSysTestData iPSSysTestData;
        IPSSysTestCase iPSSysTestCase;
        IPSDEWizard iPSDEWizard;
        IPSDEDBIndex iPSDEDBIndex;
        IPSDEDBConfig iPSDEDBConfig;
        IPSDEField iPSDEField;
        IPSAppDEField iPSAppDEField;
        IPSDEMainState iPSDEMainState;
        ArrayList<IPSObject> psDEDataExpList;
        IPSSysCalendarItem iPSSysCalendarItem;
        IPSSysCalendar iPSSysCalendar;
        Iterator<IPSSysCalendarItem> psSysCalendarItems;
        IPSDETreeNode iPSDETreeNode;
        IPSDETreeNode iPSDETreeNode2;
        IPSDETree iPSDETree;
        Iterator<IPSDETreeNode> psDETreeNodes;
        IPSDEChart iPSDEChart;
        IPSDEDataImportItem iPSDEDataImportItem;
        Iterator<IPSDEDataImportItem> psDEDataImportItems;
        IPSDEDataExportGroup iPSDEDataExportGroup;
        Iterator<IPSDEDataExportGroup> psDEDataExportGroups;
        IPSDEDataExportItem iPSDEDataExportItem;
        IPSDEDataExport iPSDEDataExport;
        Iterator<IPSDEDataExportItem> psDEDataExportItems;
        ArrayList<IPSObject> psDEDataExpList2;
        ArrayList<IPSObject> appViewList2;
        String[] items2;
        IPSControl iPSControl;
        IPSDevSlnMSDepApp iPSDevSlnMSDepApp;
        Iterator<IPSDevSlnMSDepApp> psDevSlnMSDepApps;
        IPSSysRunSession iPSSysRunSession;
        ArrayList<IPSObject> psSysSFPubList;
        IPSSysSFPub iPSSysSFPub;
        Iterator<IPSSysSFPub> psSysSFPubs;
        IPSSystemRuntime iPSSystemRuntime;
        ArrayList<IPSObject> psObjectList;
        IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI;
        Iterator<IPSDevSlnMSDepAPI> psDevSlnMSDepAPIs;
        IPSWFProcess iPSWFProcess;
        IPSWFVersion iPSWFVersion;
        Iterator<IPSWFVersion> psWFVersions;
        IPSWorkflow iPSWorkflow;
        Iterator<IPSWorkflow> psWorkflows;
        IPSAppDEMethod iPSAppDEMethod;
        IPSDEAction iPSDEAction;
        IPSDEAction iPSDEAction2;
        Iterator<IPSDEAction> psDEActions;
        IPSDEDataSet iPSDEDataSet;
        IPSDEDataQueryCode iPSDEDataQueryCode;
        IPSDEDataQuery iPSDEDataQuery;
        Iterator<? extends IPSDELogicLink> psDELogicLinks;
        Iterator<? extends IPSDELogicNode> psDELogicNodes;
        IPSDELogic iPSDELogic;
        Iterator<IPSDELogic> psDELogics;
        Iterator<IPSDataEntity> psDataEntities;
        IPSDataEntity iPSDataEntity;
        ArrayList<IPSObject> psObjectList2;
        IPSAppView iPSAppView2;
        IPSApplication iPSApplication;
        Iterator<IPSApplication> psApplications;
        IPSAppUILogic iPSAppUILogic;
        IPSAppViewLogic iPSAppViewLogic;
        Iterator<IPSAppViewLogic> psAppViewLogics;
        IPSControlContainer iPSControlContainer;
        ArrayList<IPSObject> logicList;
        IPSDEForm iPSDEForm;
        IPSDEDataView iPSDEDataView;
        IPSDETree iPSDETree2;
        IPSDEChart iPSDEChart2;
        IPSSysSearchBar iPSSysSearchBar;
        IPSDEGridEditItem iPSDEGridEditItem;
        Iterator<IPSDEGridEditItem> psDEGridEditItems;
        IPSDEGrid iPSDEGrid;
        ArrayList<IPSObject> psControlList;
        IPSDEFormItem iPSDEFormItem;
        Iterator<IPSDEFormItem> psDEFormItems;
        IPSDEForm iPSDEForm2;
        ArrayList<IPSObject> psControlList2;
        IPSAppView iPSAppView3;
        ArrayList<IPSObject> appViewList3;
        String[] items3;
        ISRFDAGlobalHelper iDAGlobalHelper = ((PSSystemImpl)iPSSystem).getDAGlobalHelper();
        ArrayList<IPSObject> list = new ArrayList<IPSObject>();
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTEM, (boolean)false) == 0) {
            list.add(iPSSystem);
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDYNAMODEL, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysDynaModel(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDYNAMODELATTR, (boolean)false) == 0) {
            IPSSysDynaModel iPSSysDynaModel2;
            Iterator psDynaModelAttrs;
            ArrayList<IPSObject> dynaModelList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSDYNAMODEL, PSModels.getParentModelId(strModelId));
            if (dynaModelList != null && dynaModelList.size() > 0 && (psDynaModelAttrs = (iPSSysDynaModel2 = (IPSSysDynaModel)dynaModelList.get(0)).getPSDynaModelAttrs()) != null) {
                while (psDynaModelAttrs.hasNext()) {
                    IPSDynaModelAttr iPSDynaModelAttr = (IPSDynaModelAttr)psDynaModelAttrs.next();
                    if (StringHelper.Compare((String)iPSDynaModelAttr.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDynaModelAttr);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSFPUB, (boolean)false) == 0) {
            IPSSysSFPub iPSSysSFPub2 = iPSSystem.getPSSysSFPub(strModelId);
            try {
                PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId()));
                net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession psSysRunSession2 = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
                psSysRunSession2.setPSSysSFPubId(iPSSysSFPub2.getId());
                psSysRunSession2.setDebugMode(Integer.valueOf(1));
                if (psSysRunSessionService.select(psSysRunSession2, true)) {
                    PSSysRunSession psSysRunSession = new PSSysRunSession();
                    PSDEDataCtrl.convertEntity((IEntity)psSysRunSession2, psSysRunSession);
                    PSSysRunSessionImpl2 psSysRunSessionImpl2 = new PSSysRunSessionImpl2();
                    psSysRunSessionImpl2.init(((PSObjectImpl)((Object)iPSSystem)).getDAGlobalHelper(), iPSSysSFPub2, psSysRunSession);
                    iPSSysSFPub2 = psSysRunSessionImpl2;
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            list.add(iPSSysSFPub2);
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSAPP, (boolean)false) == 0) {
            list.add(iPSSystem.getPSApplication(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDATAENTITY, (boolean)false) == 0) {
            IPSDataEntity iPSDataEntity2 = iPSSystem.getPSDataEntity(strModelId);
            if (iPSDataEntity2 != null) {
                list.add(iPSDataEntity2);
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDER, (boolean)false) == 0 || strModelType.indexOf("PSDER_") == 0) {
            list.add(iPSSystem.getPSDER(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSMODULE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSystemModule(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMODELGROUP, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysModelGroup(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSREF, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysRef(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSLANGUAGERES, (boolean)false) == 0) {
            list.add(iPSSystem.getPSLanguageRes(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSIMAGE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysImage(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCSS, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysCss(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONTEMPL, (boolean)false) == 0) {
            list.add(iPSSystem.getPSDEActionTempl(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFIELD, (boolean)false) == 0) {
            Iterator<IPSDataEntity> psDataEntities2 = iPSSystem.getAllPSDataEntities();
            while (psDataEntities2.hasNext()) {
                IPSDataEntity iPSDataEntity3 = psDataEntities2.next();
                IPSDEField iPSDEField2 = iPSDataEntity3.getPSDEField(strModelId, true);
                if (iPSDEField2 == null) continue;
                list.add(iPSDEField2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCODELIST, (boolean)false) == 0) {
            list.add(iPSSystem.getPSCodeList(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCODEITEM, (boolean)false) == 0) {
            Iterator<IPSCodeList> psCodeLists = iPSSystem.getAllPSCodeLists();
            while (psCodeLists.hasNext()) {
                IPSCodeList iPSCodeList = psCodeLists.next();
                Iterator<IPSCodeItem> psCodeItems = iPSCodeList.getAllPSCodeItems();
                if (psCodeItems == null) continue;
                while (psCodeItems.hasNext()) {
                    IPSCodeItem iPSCodeItem = psCodeItems.next();
                    if (StringHelper.Compare((String)iPSCodeItem.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCodeItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFORM, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDELIST, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDETREEVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEGRID, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEDATAVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDETOOLBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPMENU, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEFORM_EDITFORM, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEFORM_SEARCHFORM, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSTITLEBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPTITLEBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSCUSTOMCONTROL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEDRBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEDRTAB, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSDASHBOARD, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSDBPART, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHART, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSEXPBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSVIEWPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEWIZARDPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEREPORTPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSCALENDAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSVIEWPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSTABEXPPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSMAPVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDETREEGRIDEX, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEGANTT, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEKANBAN, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDESTATEWIZARDPANEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSCONTROL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSCAPTIONBAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDATAINFOBAR, (boolean)false) == 0) {
            String[] items4 = strModelId.split("[#]");
            if (items4.length == 2) {
                ArrayList<IPSObject> appViewList4;
                String strPSAppViewId;
                if (!StringHelper.IsNullOrEmpty((String)items4[0]) && !StringHelper.IsNullOrEmpty((String)(strPSAppViewId = items4[0]))) {
                    String[] parts;
                    IPSApplication iPSApplication2;
                    Iterator<IPSAppDataEntity> appDataEntities;
                    if (strPSAppViewId.indexOf("__APPPORTLET") != -1) {
                        IPSApplication iPSApplication3 = iPSSystem.getPSApplication(strPSAppViewId = strPSAppViewId.replace("__APPPORTLET", ""));
                        Iterator<IPSAppPortlet> psAppPortlets = iPSApplication3.getAllPSAppPortlets();
                        if (psAppPortlets != null) {
                            while (psAppPortlets.hasNext()) {
                                IPSControlContainer iPSControlContainer2;
                                Iterator<IPSControl> psControls;
                                IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                                if (iPSAppPortlet.getPSControl() == null) continue;
                                if (StringHelper.Compare((String)iPSAppPortlet.getPSControl().getName(), (String)items4[1], (boolean)true) == 0) {
                                    list.add(iPSAppPortlet.getPSControl());
                                    return list;
                                }
                                if (!(iPSAppPortlet.getPSControl() instanceof IPSControlContainer) || (psControls = (iPSControlContainer2 = (IPSControlContainer)((Object)iPSAppPortlet.getPSControl())).getPSControls()) == null) continue;
                                while (psControls.hasNext()) {
                                    Iterator<IPSLayoutPanel> childPSControls;
                                    IPSControl iPSControl2 = psControls.next();
                                    if (StringHelper.Compare((String)iPSControl2.getName(), (String)items4[1], (boolean)true) == 0) {
                                        list.add(iPSControl2);
                                        return list;
                                    }
                                    if (!(iPSControl2 instanceof IPSControlContainer) || (childPSControls = ((IPSControlContainer)((Object)iPSControl2)).getPSLayoutPanels()) == null) continue;
                                    while (childPSControls.hasNext()) {
                                        IPSLayoutPanel iPSLayoutPanel = childPSControls.next();
                                        if (StringHelper.Compare((String)iPSLayoutPanel.getName(), (String)items4[1], (boolean)true) != 0) continue;
                                        list.add(iPSLayoutPanel);
                                        return list;
                                    }
                                }
                            }
                        }
                    } else if (strPSAppViewId.indexOf("__APPDEUIACTION__") != -1 && (appDataEntities = (iPSApplication2 = iPSSystem.getPSApplication((parts = strPSAppViewId.replace("__APPDEUIACTION__", "|").split("[|]"))[0])).getAllPSAppDataEntities()) != null) {
                        while (appDataEntities.hasNext()) {
                            IPSAppDataEntity iPSAppDataEntity2 = appDataEntities.next();
                            Iterator<IPSAppDEUIAction> appDEUIActions = iPSAppDataEntity2.getAllPSAppDEUIActions();
                            if (appDEUIActions == null) continue;
                            while (appDEUIActions.hasNext()) {
                                IPSAppDEUIAction iPSAppDEUIAction2 = appDEUIActions.next();
                                if (StringHelper.Compare((String)iPSAppDEUIAction2.getFullCodeName(), (String)parts[1], (boolean)true) != 0 || iPSAppDEUIAction2.getPSDEEditForm() == null) continue;
                                list.add(iPSAppDEUIAction2.getPSDEEditForm());
                                return list;
                            }
                        }
                    }
                }
                if ((appViewList4 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items4[0])).size() > 0) {
                    IPSLayoutPanel iPSLayoutPanel;
                    Iterator<IPSLayoutPanel> childPSControls;
                    IPSAppView iPSAppView4 = (IPSAppView)appViewList4.get(0);
                    for (IPSControl iPSControl3 : iPSAppView4.getAllPSControls()) {
                        if (StringHelper.Compare((String)iPSControl3.getName(), (String)items4[1], (boolean)true) == 0) {
                            list.add(iPSControl3);
                            return list;
                        }
                        if (!(iPSControl3 instanceof IPSControlContainer) || (childPSControls = ((IPSControlContainer)((Object)iPSControl3)).getPSLayoutPanels()) == null) continue;
                        while (childPSControls.hasNext()) {
                            iPSLayoutPanel = childPSControls.next();
                            if (StringHelper.Compare((String)iPSLayoutPanel.getName(), (String)items4[1], (boolean)true) != 0) continue;
                            list.add(iPSLayoutPanel);
                            return list;
                        }
                    }
                    Iterator childPSControls2 = iPSAppView4.getPSLayoutPanels();
                    if (childPSControls2 != null) {
                        while (childPSControls2.hasNext()) {
                            IPSLayoutPanel iPSLayoutPanel2 = (IPSLayoutPanel)childPSControls2.next();
                            if (StringHelper.Compare((String)iPSLayoutPanel2.getName(), (String)items4[1], (boolean)true) != 0) continue;
                            list.add(iPSLayoutPanel2);
                            return list;
                        }
                    }
                    if (iPSAppView4.getPSSysViewLayoutPanel() != null) {
                        for (IPSControl iPSControl3 : iPSAppView4.getPSSysViewLayoutPanel().getAllPSControls()) {
                            if (StringHelper.Compare((String)iPSControl3.getName(), (String)items4[1], (boolean)true) == 0) {
                                list.add(iPSControl3);
                                return list;
                            }
                            if (!(iPSControl3 instanceof IPSControlContainer) || (childPSControls = ((IPSControlContainer)((Object)iPSControl3)).getPSLayoutPanels()) == null) continue;
                            while (childPSControls.hasNext()) {
                                iPSLayoutPanel = childPSControls.next();
                                if (StringHelper.Compare((String)iPSLayoutPanel.getName(), (String)items4[1], (boolean)true) != 0) continue;
                                list.add(iPSLayoutPanel);
                                return list;
                            }
                        }
                    }
                }
            } else if (items4.length == 1 && StringHelper.Compare((String)strModelType, (String)PSAPPMENU, (boolean)false) == 0) {
                Iterator<IPSApplication> psApplications2 = iPSSystem.getAllPSApps();
                while (psApplications2.hasNext()) {
                    Iterator<IPSAppMenuModel> psAppMenuModels;
                    IPSApplication iPSApplication4 = psApplications2.next();
                    if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication4.getId(), (boolean)false) != 0 || (psAppMenuModels = iPSApplication4.getAllPSAppMenuModels()) == null) continue;
                    while (psAppMenuModels.hasNext()) {
                        IPSAppMenuModel iPSAppMenuModel = psAppMenuModels.next();
                        if (StringHelper.Compare((String)iPSAppMenuModel.getId(), (String)items4[0], (boolean)true) != 0) continue;
                        list.add(iPSAppMenuModel);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVIEWCTRL, (boolean)true) == 0 && (items3 = strModelId.split("[#]")).length == 2 && (appViewList3 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items3[0])).size() > 0) {
            iPSAppView3 = (IPSAppView)appViewList3.get(0);
            for (IPSControl iPSControl4 : iPSAppView3.getAllPSControls()) {
                if (StringHelper.Compare((String)iPSControl4.getName(), (String)items3[1], (boolean)true) != 0) continue;
                if (iPSControl4.getPSControlParam() != null) {
                    list.add(iPSControl4.getPSControlParam());
                }
                return list;
            }
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFORMDETAIL, (boolean)false) == 0 || strModelType.indexOf("PSDEFORMDETAIL_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFORM, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEForm2 = (IPSDEForm)psControlList2.get(0);
                Iterator<IPSDEFormDetail> psDEFormDetails = iPSDEForm2.getAllPSDEFormDetails();
                while (psDEFormDetails.hasNext()) {
                    IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
                    if (StringHelper.Compare((String)iPSDEFormDetail.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEFormDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFORMDATAITEM, (boolean)false) == 0 || strModelType.indexOf("PSDEFORMDATAITEM_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFORM, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDEFormItems = (iPSDEForm2 = (IPSDEForm)psControlList2.get(0)).getPSDEFormItems()) != null) {
                while (psDEFormItems.hasNext()) {
                    iPSDEFormItem = psDEFormItems.next();
                    if (StringHelper.Compare((String)iPSDEFormItem.getName(), (String)items3[2], (boolean)true) != 0 || !(iPSDEFormItem.getDataItem() instanceof IPSDataItem)) continue;
                    list.add((IPSDataItem)iPSDEFormItem.getDataItem());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSACHANDLER_FORMITEM, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFORM, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEForm2 = (IPSDEForm)psControlList2.get(0);
                if (StringHelper.Compare((String)strModelType, (String)PSDEFORMDETAIL_FORMITEM, (boolean)false) == 0) {
                    psDEFormItems = iPSDEForm2.getPSDEFormItems();
                    while (psDEFormItems.hasNext()) {
                        iPSDEFormItem = psDEFormItems.next();
                        if (StringHelper.Compare((String)iPSDEFormItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                        if (iPSDEFormItem.getItemPSAjaxHandler() != null) {
                            list.add(iPSDEFormItem.getItemPSAjaxHandler());
                        }
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETBITEM, (boolean)false) == 0 || strModelType.indexOf("PSDETBITEM_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETOOLBAR, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                IPSDEToolbar iPSDEToolbar = (IPSDEToolbar)psControlList2.get(0);
                Iterator<IPSDEToolbarItem> psDEToolbarItems = iPSDEToolbar.getAllPSDEToolbarItems();
                while (psDEToolbarItems.hasNext()) {
                    IPSDEToolbarItem iPSDEToolbarItem = psDEToolbarItems.next();
                    if (StringHelper.Compare((String)iPSDEToolbarItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEToolbarItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMENUITEM, (boolean)false) == 0 || strModelType.indexOf("PSAPPMENUITEM_") == 0) {
            IPSAppMenuItem iPSAppMenuItem;
            Iterator<IPSAppMenuItem> psAppMenuItems;
            IPSAppMenu iPSAppMenu;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPMENU, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSAppMenu = (IPSAppMenu)psControlList2.get(0);
                psAppMenuItems = iPSAppMenu.getAllPSAppMenuItems();
                while (psAppMenuItems.hasNext()) {
                    iPSAppMenuItem = psAppMenuItems.next();
                    if (StringHelper.Compare((String)iPSAppMenuItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSAppMenuItem);
                    return list;
                }
            }
            if (items3.length == 2 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPMENU, items3[0])).size() > 0) {
                iPSAppMenu = (IPSAppMenu)psControlList2.get(0);
                psAppMenuItems = iPSAppMenu.getAllPSAppMenuItems();
                while (psAppMenuItems.hasNext()) {
                    iPSAppMenuItem = psAppMenuItems.next();
                    if (StringHelper.Compare((String)iPSAppMenuItem.getName(), (String)items3[1], (boolean)true) != 0) continue;
                    list.add(iPSAppMenuItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGRIDCOL, (boolean)false) == 0 || strModelType.indexOf("PSDEGRIDCOL_") == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0) {
                iPSDEGrid = (IPSDEGrid)psControlList.get(0);
                Iterator<IPSDEGridColumn> psDEGridColumns = iPSDEGrid.getAllPSDEGridColumns();
                while (psDEGridColumns.hasNext()) {
                    IPSDEGridColumn iPSDEGridColumn = psDEGridColumns.next();
                    if (StringHelper.Compare((String)iPSDEGridColumn.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGridColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGRIDEDITITEM, (boolean)false) == 0 || strModelType.indexOf("PSDEGRIDEDITITEM_") == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGridEditItems = (iPSDEGrid = (IPSDEGrid)psControlList.get(0)).getPSDEGridEditItems()) != null) {
                while (psDEGridEditItems.hasNext()) {
                    iPSDEGridEditItem = psDEGridEditItems.next();
                    if (StringHelper.Compare((String)iPSDEGridEditItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGridEditItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSACHANDLER_GRIDEDITITEM, (boolean)false) == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGridEditItems = (iPSDEGrid = (IPSDEGrid)psControlList.get(0)).getPSDEGridEditItems()) != null) {
                while (psDEGridEditItems.hasNext()) {
                    iPSDEGridEditItem = psDEGridEditItems.next();
                    if (StringHelper.Compare((String)iPSDEGridEditItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    if (iPSDEGridEditItem.getItemPSAjaxHandler() != null) {
                        list.add(iPSDEGridEditItem.getItemPSAjaxHandler());
                    }
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGRIDDATAITEM, (boolean)false) == 0 || strModelType.indexOf("PSDEGRIDDATAITEM_") == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0) {
                Iterator<IPSDEGridEditItem> psDEGridEditItems2;
                iPSDEGrid = (IPSDEGrid)psControlList.get(0);
                Iterator<IPSDEGridDataItem> psDEGridDataItems = iPSDEGrid.getPSDEGridDataItems();
                if (psDEGridDataItems != null) {
                    while (psDEGridDataItems.hasNext()) {
                        IPSDEGridDataItem iPSDEGridDataItem = psDEGridDataItems.next();
                        if (StringHelper.Compare((String)iPSDEGridDataItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                        list.add(iPSDEGridDataItem);
                        return list;
                    }
                }
                if ((psDEGridEditItems2 = iPSDEGrid.getPSDEGridEditItems()) != null) {
                    while (psDEGridEditItems2.hasNext()) {
                        IPSDEGridDataItem iPSDEGridDataItem;
                        IPSDEGridEditItem iPSDEGridEditItem2 = psDEGridEditItems2.next();
                        if (!(iPSDEGridEditItem2.getDataItem() instanceof IPSDEGridDataItem) || StringHelper.Compare((String)(iPSDEGridDataItem = (IPSDEGridDataItem)iPSDEGridEditItem2.getDataItem()).getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                        list.add(iPSDEGridDataItem);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGEIUPDATE, (boolean)false) == 0 || strModelType.indexOf("PSDEGEIUPDATE_") == 0) {
            Iterator<IPSDEGridEditItemUpdate> psDEGridEditItemUpdates;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGridEditItemUpdates = (iPSDEGrid = (IPSDEGrid)psControlList.get(0)).getPSDEGridEditItemUpdates()) != null) {
                while (psDEGridEditItemUpdates.hasNext()) {
                    IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate = psDEGridEditItemUpdates.next();
                    if (StringHelper.Compare((String)iPSDEGridEditItemUpdate.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGridEditItemUpdate);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGEIUDETAIL, (boolean)false) == 0 || strModelType.indexOf("PSDEGEIUDETAIL_") == 0) {
            IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate;
            Iterator<IPSDEGEIUpdateDetail> psDEGEIUpdateDetails;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGEIUpdateDetails = (iPSDEGridEditItemUpdate = (IPSDEGridEditItemUpdate)psControlList.get(0)).getPSDEGEIUpdateDetails()) != null) {
                while (psDEGEIUpdateDetails.hasNext()) {
                    IPSDEGEIUpdateDetail iPSDEGEIUpdateDetail = psDEGEIUpdateDetails.next();
                    if (StringHelper.Compare((String)iPSDEGEIUpdateDetail.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGEIUpdateDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGEIVR, (boolean)false) == 0) {
            Iterator<IPSDEGridEditItemVR> psDEGridEditItemVRs;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGridEditItemVRs = (iPSDEGrid = (IPSDEGrid)psControlList.get(0)).getPSDEGridEditItemVRs()) != null) {
                while (psDEGridEditItemVRs.hasNext()) {
                    IPSDEGridEditItemVR iPSDEGridEditItemVR = psDEGridEditItemVRs.next();
                    if (StringHelper.Compare((String)iPSDEGridEditItemVR.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGridEditItemVR);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGRIDLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDEGridLogic> psDEGridLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEGridLogics = (iPSDEGrid = (IPSDEGrid)psControlList.get(0)).getPSDEGridLogics()) != null) {
                while (psDEGridLogics.hasNext()) {
                    IPSDEGridLogic iPSDEGridLogic = psDEGridLogics.next();
                    if (StringHelper.Compare((String)iPSDEGridLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEGridLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCALENDARLOGIC, (boolean)false) == 0) {
            IPSSysCalendar iPSSysCalendar2;
            Iterator<? extends IPSSysCalendarLogic> psSysCalendarLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSCALENDAR, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSysCalendarLogics = (iPSSysCalendar2 = (IPSSysCalendar)psControlList.get(0)).getPSSysCalendarLogics()) != null) {
                while (psSysCalendarLogics.hasNext()) {
                    IPSSysCalendarLogic iPSSysCalendarLogic = psSysCalendarLogics.next();
                    if (StringHelper.Compare((String)iPSSysCalendarLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSysCalendarLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDASHBOARDLOGIC, (boolean)false) == 0) {
            IPSSysDashboard iPSSysDashboard;
            Iterator<? extends IPSSysDashboardLogic> psSysDashboardLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSDASHBOARD, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSysDashboardLogics = (iPSSysDashboard = (IPSSysDashboard)psControlList.get(0)).getPSSysDashboardLogics()) != null) {
                while (psSysDashboardLogics.hasNext()) {
                    IPSSysDashboardLogic iPSSysDashboardLogic = psSysDashboardLogics.next();
                    if (StringHelper.Compare((String)iPSSysDashboardLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSysDashboardLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMAPLOGIC, (boolean)false) == 0) {
            IPSSysMap iPSSysMap;
            Iterator<? extends IPSSysMapLogic> psSysMapLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSMAPVIEW, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSysMapLogics = (iPSSysMap = (IPSSysMap)psControlList.get(0)).getPSSysMapLogics()) != null) {
                while (psSysMapLogics.hasNext()) {
                    IPSSysMapLogic iPSSysMapLogic = psSysMapLogics.next();
                    if (StringHelper.Compare((String)iPSSysMapLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSysMapLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBARLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSSysSearchBarLogic> psSysSearchBarLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSSEARCHBAR, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSysSearchBarLogics = (iPSSysSearchBar = (IPSSysSearchBar)psControlList.get(0)).getPSSysSearchBarLogics()) != null) {
                while (psSysSearchBarLogics.hasNext()) {
                    IPSSysSearchBarLogic iPSSysSearchBarLogic = psSysSearchBarLogics.next();
                    if (StringHelper.Compare((String)iPSSysSearchBarLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSysSearchBarLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMENULOGIC, (boolean)false) == 0) {
            IPSAppMenu iPSAppMenu;
            Iterator<? extends IPSAppMenuLogic> psAppMenuLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPMENU, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psAppMenuLogics = (iPSAppMenu = (IPSAppMenu)psControlList.get(0)).getPSAppMenuLogics()) != null) {
                while (psAppMenuLogics.hasNext()) {
                    IPSAppMenuLogic iPSAppMenuLogic = psAppMenuLogics.next();
                    if (StringHelper.Compare((String)iPSAppMenuLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppMenuLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETOOLBARLOGIC, (boolean)false) == 0) {
            IPSDEToolbar iPSDEToolbar;
            Iterator<? extends IPSDEToolbarLogic> psDEToolbarLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETOOLBAR, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEToolbarLogics = (iPSDEToolbar = (IPSDEToolbar)psControlList.get(0)).getPSDEToolbarLogics()) != null) {
                while (psDEToolbarLogics.hasNext()) {
                    IPSDEToolbarLogic iPSDEToolbarLogic = psDEToolbarLogics.next();
                    if (StringHelper.Compare((String)iPSDEToolbarLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEToolbarLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDEChartLogic> psDEChartLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEChartLogics = (iPSDEChart2 = (IPSDEChart)psControlList.get(0)).getPSDEChartLogics()) != null) {
                while (psDEChartLogics.hasNext()) {
                    IPSDEChartLogic iPSDEChartLogic = psDEChartLogics.next();
                    if (StringHelper.Compare((String)iPSDEChartLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEChartLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREELOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDETreeLogic> psDETreeLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDETreeLogics = (iPSDETree2 = (IPSDETree)psControlList.get(0)).getPSDETreeLogics()) != null) {
                while (psDETreeLogics.hasNext()) {
                    IPSDETreeLogic iPSDETreeLogic = psDETreeLogics.next();
                    if (StringHelper.Compare((String)iPSDETreeLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELISTLOGIC, (boolean)false) == 0) {
            IPSDEList iPSDEList2;
            Iterator<? extends IPSDEListLogic> psDEListLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDELIST, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEListLogics = (iPSDEList2 = (IPSDEList)psControlList.get(0)).getPSDEListLogics()) != null) {
                while (psDEListLogics.hasNext()) {
                    IPSDEListLogic iPSDEListLogic = psDEListLogics.next();
                    if (StringHelper.Compare((String)iPSDEListLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEListLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAVIEWLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDEDataViewLogic> psDEDataViewLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAVIEW, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEDataViewLogics = (iPSDEDataView = (IPSDEDataView)psControlList.get(0)).getPSDEDataViewLogics()) != null) {
                while (psDEDataViewLogics.hasNext()) {
                    IPSDEDataViewLogic iPSDEDataViewLogic = psDEDataViewLogics.next();
                    if (StringHelper.Compare((String)iPSDEDataViewLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEDataViewLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFORMLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDEFormLogic> psDEFormLogics;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFORM, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEFormLogics = (iPSDEForm = (IPSDEForm)psControlList.get(0)).getPSDEFormLogics()) != null) {
                while (psDEFormLogics.hasNext()) {
                    IPSDEFormLogic iPSDEFormLogic = psDEFormLogics.next();
                    if (StringHelper.Compare((String)iPSDEFormLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEFormLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFIVR, (boolean)false) == 0) {
            Iterator<IPSDEFormItemVR> psDEFormItemVRs;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFORM, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEFormItemVRs = (iPSDEForm = (IPSDEForm)psControlList.get(0)).getPSDEFormItemVRs()) != null) {
                while (psDEFormItemVRs.hasNext()) {
                    IPSDEFormItemVR iPSDEFormItemVR = psDEFormItemVRs.next();
                    if (StringHelper.Compare((String)iPSDEFormItemVR.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEFormItemVR);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSDATAITEMPARAM$") == 0) {
            IPSDataItem iPSDataItem2;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(16), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSDataItem && (iPSDataItem2 = (IPSDataItem)logicList.get(0)).getDataItemParams() != null) {
                IDataItemParam[] iPSDEGridDataItem = iPSDataItem2.getDataItemParams();
                int iPSDEGridEditItem2 = iPSDEGridDataItem.length;
                int iPSDEFormItemVR = 0;
                while (iPSDEFormItemVR < iPSDEGridEditItem2) {
                    IPSModelObject iPSModelObject;
                    IDataItemParam iDataItemParam = iPSDEGridDataItem[iPSDEFormItemVR];
                    if (iDataItemParam instanceof IPSModelObject && StringHelper.Compare((String)(iPSModelObject = (IPSModelObject)iDataItemParam).getModelId(), (String)strModelId, (boolean)false) == 0) {
                        list.add(iPSModelObject);
                        return list;
                    }
                    ++iPSDEFormItemVR;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSEDITOR$") == 0) {
            IPSEditorContainer iPSEditorContainer;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(9), strModelId);
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSEditorContainer && (iPSEditorContainer = (IPSEditorContainer)logicList.get(0)).getPSEditor() != null) {
                list.add(iPSEditorContainer.getPSEditor());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSEDITORITEM$") == 0) {
            IPSEditor iPSEditor;
            Iterator<? extends IPSEditorItem> psEditorItems;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(13), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSEditor && (psEditorItems = (iPSEditor = (IPSEditor)logicList.get(0)).getPSEditorItems()) != null) {
                while (psEditorItems.hasNext()) {
                    IPSEditorItem iPSEditorItem = psEditorItems.next();
                    if (StringHelper.Compare((String)strModelId, (String)iPSEditorItem.getModelId(), (boolean)false) != 0) continue;
                    list.add(iPSEditorItem);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSRAWITEM$") == 0) {
            IPSRawItemContainer iPSRawItemContainer;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(10), strModelId);
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSRawItemContainer && (iPSRawItemContainer = (IPSRawItemContainer)logicList.get(0)).getPSRawItem() != null) {
                list.add(iPSRawItemContainer.getPSRawItem());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSAPPVIEWREF$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(13), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0) {
                IPSAppViewRef iPSAppViewRef;
                IPSAppRedirectView iPSAppRedirectView;
                Iterator<IPSAppViewRef> psAppViewRefs;
                if (logicList.get(0) instanceof IPSAppRedirectView && (psAppViewRefs = (iPSAppRedirectView = (IPSAppRedirectView)logicList.get(0)).getRedirectPSAppViewRefs()) != null) {
                    while (psAppViewRefs.hasNext()) {
                        iPSAppViewRef = psAppViewRefs.next();
                        if (StringHelper.Compare((String)strModelId, (String)iPSAppViewRef.getModelId(), (boolean)true) != 0) continue;
                        list.add(iPSAppViewRef);
                        return list;
                    }
                }
                if (logicList.get(0) instanceof IPSControlMDataContainer) {
                    IPSControlMDataContainer iPSControlMDataContainer = (IPSControlMDataContainer)((Object)logicList.get(0));
                    psAppViewRefs = iPSControlMDataContainer.getPSAppViewRefs();
                    if (psAppViewRefs != null) {
                        while (psAppViewRefs.hasNext()) {
                            iPSAppViewRef = psAppViewRefs.next();
                            if (StringHelper.Compare((String)strModelId, (String)iPSAppViewRef.getModelId(), (boolean)true) != 0) continue;
                            list.add(iPSAppViewRef);
                            return list;
                        }
                    }
                } else {
                    iPSControlContainer = PSSystemUtil.getRefPSControlContainer(logicList.get(0), true);
                    if (iPSControlContainer != null && (psAppViewRefs = iPSControlContainer.getPSAppViewRefs()) != null) {
                        while (psAppViewRefs.hasNext()) {
                            iPSAppViewRef = psAppViewRefs.next();
                            if (StringHelper.Compare((String)strModelId, (String)iPSAppViewRef.getModelId(), (boolean)true) != 0) continue;
                            list.add(iPSAppViewRef);
                            return list;
                        }
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSAPPUILOGICBUILDIN$") == 0) {
            IPSControlContainer iPSControlContainer3;
            String strModelType2 = strModelType.substring(PSAPPUILOGICBUILDIN.length() + 1);
            ArrayList<IPSObject> logicList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType2, PSModels.getParentModelId(strModelId));
            if (logicList2.size() > 0 && (iPSControlContainer3 = PSSystemUtil.getRefPSControlContainer(logicList2.get(0), true)) != null && (psAppViewLogics = iPSControlContainer3.getPSAppViewLogics()) != null) {
                while (psAppViewLogics.hasNext()) {
                    iPSAppViewLogic = psAppViewLogics.next();
                    if (iPSAppViewLogic.getPSViewLogic() == null || StringHelper.Compare((String)iPSAppViewLogic.getPSViewLogic().getModelType(), (String)strModelType, (boolean)true) != 0 || StringHelper.Compare((String)iPSAppViewLogic.getPSViewLogic().getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppViewLogic.getPSViewLogic());
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSAPPVIEWUIACTION$") == 0) {
            Iterator<IPSAppViewUIAction> psAppViewUIActions;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(18), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && (iPSControlContainer = PSSystemUtil.getRefPSControlContainer(logicList.get(0), true)) != null && (psAppViewUIActions = iPSControlContainer.getPSAppViewUIActions()) != null) {
                while (psAppViewUIActions.hasNext()) {
                    IPSAppViewUIAction iPSAppViewUIAction = psAppViewUIActions.next();
                    if (StringHelper.Compare((String)strModelId, (String)iPSAppViewUIAction.getModelId(), (boolean)true) != 0) continue;
                    list.add(iPSAppViewUIAction);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSAPPVIEWLOGIC$") == 0) {
            Iterator<IPSAppViewLogic> psAppViewLogics2;
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(15), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && (iPSControlContainer = PSSystemUtil.getRefPSControlContainer(logicList.get(0), true)) != null && (psAppViewLogics2 = iPSControlContainer.getPSAppViewLogics()) != null) {
                while (psAppViewLogics2.hasNext()) {
                    IPSAppViewLogic iPSAppViewLogic2 = psAppViewLogics2.next();
                    if (StringHelper.Compare((String)strModelId, (String)iPSAppViewLogic2.getModelId(), (boolean)true) != 0) continue;
                    list.add(iPSAppViewLogic2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWLOGIC, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length >= 2 && (appViewList3 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items3[0])).size() > 0) {
                iPSAppView3 = (IPSAppView)appViewList3.get(0);
                psAppViewLogics = iPSAppView3.getPSAppViewLogics();
                while (psAppViewLogics.hasNext()) {
                    iPSAppViewLogic = psAppViewLogics.next();
                    if (StringHelper.Compare((String)iPSAppViewLogic.getModelId(), (String)strModelId, (boolean)true) == 0) {
                        list.add(iPSAppViewLogic);
                        return list;
                    }
                    if (iPSAppViewLogic.getPSViewLogic() == null || StringHelper.Compare((String)iPSAppViewLogic.getPSViewLogic().getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppViewLogic.getPSViewLogic());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWLOGICREFVIEW, (boolean)false) == 0) {
            ArrayList<IPSObject> appViewLogicList;
            items3 = strModelId.split("[#]");
            if (items3.length >= 3 && (appViewLogicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEWLOGIC, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                Iterator<IPSAppUILogicRefView> psAppUILogicRefViews;
                IPSObject iPSObject = appViewLogicList.get(0);
                if (iPSObject instanceof IPSAppViewLogic) {
                    iPSObject = ((IPSAppViewLogic)iPSObject).getPSViewLogic();
                }
                if (iPSObject instanceof IPSAppUILogic && (psAppUILogicRefViews = (iPSAppUILogic = (IPSAppUILogic)iPSObject).getPSAppUILogicRefViews()) != null) {
                    while (psAppUILogicRefViews.hasNext()) {
                        IPSAppUILogicRefView iPSAppUILogicRefView = psAppUILogicRefViews.next();
                        if (StringHelper.Compare((String)iPSAppUILogicRefView.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSAppUILogicRefView);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVIEWBASE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0 || (iPSAppView3 = iPSApplication.getPSAppViewByDEViewId(strModelId, true)) == null) continue;
                list.add(iPSAppView3);
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMODULE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppModule> psAppModules = iPSApplication.getAllPSAppModules();
                while (psAppModules.hasNext()) {
                    IPSAppModule iPSAppModule = psAppModules.next();
                    if (StringHelper.Compare((String)iPSAppModule.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppModule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPLAN, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppLan> psAppLans = iPSApplication.getAllPSAppLans();
                while (psAppLans.hasNext()) {
                    IPSAppLan iPSAppLan = psAppLans.next();
                    if (StringHelper.Compare((String)iPSAppLan.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppLan);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSLAN, (boolean)false) == 0) {
            Iterator<IPSSysLan> psSysLans = iPSSystem.getAllPSSysLans();
            while (psSysLans.hasNext()) {
                IPSSysLan iPSSysLan = psSysLans.next();
                if (StringHelper.Compare((String)iPSSysLan.getId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysLan);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSI18N, (boolean)false) == 0) {
            list.add(iPSSystem.getDefaultPSSysI18N());
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPLOGIC, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppLogic> psAppLogics = iPSApplication.getAllPSAppLogics();
                while (psAppLogics.hasNext()) {
                    IPSAppLogic iPSAppLogic = psAppLogics.next();
                    if (StringHelper.Compare((String)iPSAppLogic.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDATAENTITY, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPLOCALDE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppDataEntity> psAppDataEntities = iPSApplication.getAllPSAppDataEntities();
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity3 = psAppDataEntities.next();
                    if (StringHelper.Compare((String)iPSAppDataEntity3.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDataEntity3);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPFUNC, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppFunc> psAppFuncs = iPSApplication.getAllPSAppFuncs();
                while (psAppFuncs.hasNext()) {
                    IPSAppFunc iPSAppFunc = psAppFuncs.next();
                    if (StringHelper.Compare((String)iPSAppFunc.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppFunc);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWF, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppWF> psAppWFs = iPSApplication.getAllPSAppWFs();
                while (psAppWFs.hasNext()) {
                    IPSAppWF iPSAppWF2 = psAppWFs.next();
                    if (StringHelper.Compare((String)iPSAppWF2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWF2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFVER, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppWFVer> psAppWFVers = iPSApplication.getAllPSAppWFVers();
                while (psAppWFVers.hasNext()) {
                    IPSAppWFVer iPSAppWFVer2 = psAppWFVers.next();
                    if (StringHelper.Compare((String)iPSAppWFVer2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFVer2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPUSERMODE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppUserMode> psAppUserModes = iPSApplication.getAllPSAppUserModes();
                while (psAppUserModes.hasNext()) {
                    IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
                    if (StringHelper.Compare((String)iPSAppUserMode.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppUserMode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPUITHEME, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppUITheme> psAppUIThemes = iPSApplication.getAllPSAppUIThemes();
                while (psAppUIThemes.hasNext()) {
                    IPSAppUITheme iPSAppUITheme = psAppUIThemes.next();
                    if (StringHelper.Compare((String)iPSAppUITheme.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppUITheme);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPUTILPAGE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppUtilPage> psAppUtilPages = iPSApplication.getAllPSAppUtilPages();
                while (psAppUtilPages.hasNext()) {
                    IPSAppUtilPage iPSAppUtilPage = psAppUtilPages.next();
                    if (StringHelper.Compare((String)iPSAppUtilPage.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppUtilPage);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPRESOURCE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppResource> psAppResources = iPSApplication.getAllPSAppResources();
                while (psAppResources.hasNext()) {
                    IPSAppResource iPSAppResource = psAppResources.next();
                    if (StringHelper.Compare((String)iPSAppResource.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppResource);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPPFPLUGINREF, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppPFPluginRef> psAppPFPluginRefs = iPSApplication.getAllPSAppPFPluginRefs();
                while (psAppPFPluginRefs.hasNext()) {
                    IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
                    if (StringHelper.Compare((String)iPSAppPFPluginRef.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppPFPluginRef);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPEDITORSTYLEREF, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppEditorStyleRef> psAppEditorStyleRefs = iPSApplication.getAllPSAppEditorStyleRefs();
                while (psAppEditorStyleRefs.hasNext()) {
                    IPSAppEditorStyleRef iPSAppEditorStyleRef = psAppEditorStyleRefs.next();
                    if (StringHelper.Compare((String)iPSAppEditorStyleRef.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppEditorStyleRef);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPSUBVIEWTYPEREF, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs = iPSApplication.getAllPSAppSubViewTypeRefs();
                while (psAppSubViewTypeRefs.hasNext()) {
                    IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                    if (StringHelper.Compare((String)iPSAppSubViewTypeRef.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppSubViewTypeRef);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSMOBAPPSTARTPAGE, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                Iterator<IPSMobAppStartPage> psMobAppStartPages = iPSApplication.getAllPSMobAppStartPages();
                while (psMobAppStartPages.hasNext()) {
                    IPSMobAppStartPage iPSMobAppStartPage = psMobAppStartPages.next();
                    if (StringHelper.Compare((String)iPSMobAppStartPage.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSMobAppStartPage);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCOUNTERREF, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppView> psAppViews = iPSApplication.getAllPSAppViews();
                while (psAppViews.hasNext()) {
                    iPSAppView2 = psAppViews.next();
                    Iterator<IPSSysCounterRef> psSysCounterRefs = iPSAppView2.getPSSysCounterRefs();
                    if (psSysCounterRefs == null) continue;
                    while (psSysCounterRefs.hasNext()) {
                        IPSSysCounterRef iPSSysCounterRef = psSysCounterRefs.next();
                        if (StringHelper.Compare((String)iPSSysCounterRef.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSSysCounterRef);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCOUNTER, (boolean)false) == 0) {
            Iterator<IPSSysCounter> psSysCounters = iPSSystem.getAllPSSysCounters();
            while (psSysCounters.hasNext()) {
                IPSSysCounter iPSSysCounter = psSysCounters.next();
                if (StringHelper.Compare((String)iPSSysCounter.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysCounter);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSPFPLUGIN, (boolean)false) == 0) {
            Iterator<IPSSysPFPlugin> psSysPFPlugins = iPSSystem.getAllPSSysPFPlugins();
            while (psSysPFPlugins.hasNext()) {
                IPSSysPFPlugin iPSSysPFPlugin = psSysPFPlugins.next();
                if (StringHelper.Compare((String)iPSSysPFPlugin.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysPFPlugin);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSFPLUGIN, (boolean)false) == 0) {
            Iterator<IPSSysSFPlugin> psSysSFPlugins = iPSSystem.getAllPSSysSFPlugins();
            while (psSysSFPlugins.hasNext()) {
                IPSSysSFPlugin iPSSysSFPlugin = psSysSFPlugins.next();
                if (StringHelper.Compare((String)iPSSysSFPlugin.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysSFPlugin);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERMODE, (boolean)false) == 0) {
            Iterator<IPSSysUserMode> psSysUserModes = iPSSystem.getAllPSSysUserModes();
            while (psSysUserModes.hasNext()) {
                IPSSysUserMode iPSSysUserMode = psSysUserModes.next();
                if (StringHelper.Compare((String)iPSSysUserMode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysUserMode);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPINDEXVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPPORTALVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPDYNADEVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPUTILVIEW, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPPANELVIEW, (boolean)false) == 0) {
            PSAppViewServiceProxy psAppViewServiceProxy = (PSAppViewServiceProxy)ServiceGlobal.getService(PSAppViewServiceProxy.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId()));
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAppViewId(strModelId);
            if (psAppViewServiceProxy.get(psAppView, true)) {
                IPSApplication iPSApplication5 = iPSSystem.getPSApplication(psAppView.getPSSysAppId());
                iPSAppView2 = iPSApplication5.getPSAppView(strModelId, true);
                if (iPSAppView2 != null) {
                    list.add(iPSAppView2);
                }
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACMODE, (boolean)false) == 0) {
            IPSDEACMode iPSDEACMode2;
            Iterator<IPSDEACMode> psDEACModes;
            if (strModelId.indexOf("#") != -1) {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEACModes = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEACModes()) != null) {
                    while (psDEACModes.hasNext()) {
                        iPSDEACMode2 = psDEACModes.next();
                        if (StringHelper.Compare((String)iPSDEACMode2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEACMode2);
                        return list;
                    }
                }
            } else {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                    psDEACModes = iPSDataEntity.getAllPSDEACModes();
                    if (psDEACModes == null) continue;
                    while (psDEACModes.hasNext()) {
                        iPSDEACMode2 = psDEACModes.next();
                        if (StringHelper.Compare((String)iPSDEACMode2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEACMode2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRGROUP, (boolean)false) == 0) {
            Iterator<IPSDEDRGroup> psDEDRGroups;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRGroups = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDRGroups()) != null) {
                while (psDEDRGroups.hasNext()) {
                    IPSDEDRGroup iPSDEDRGroup = psDEDRGroups.next();
                    if (StringHelper.Compare((String)iPSDEDRGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRITEM, (boolean)false) == 0) {
            Iterator<IPSDEDRItem> psDEDRItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRItems = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDRItems()) != null) {
                while (psDEDRItems.hasNext()) {
                    IPSDEDRItem iPSDEDRItem = psDEDRItems.next();
                    if (StringHelper.Compare((String)iPSDEDRItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATARELATION, (boolean)false) == 0) {
            Iterator<IPSDEDataRelation> psDEDataRelations;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataRelations = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDataRelations()) != null) {
                while (psDEDataRelations.hasNext()) {
                    IPSDEDataRelation iPSDEDataRelation = psDEDataRelations.next();
                    if (StringHelper.Compare((String)iPSDEDataRelation.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataRelation);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRDETAIL, (boolean)false) == 0) {
            IPSDEDataRelation iPSDEDataRelation;
            Iterator<IPSDEDRDetail> psDEDRDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATARELATION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRDetails = (iPSDEDataRelation = (IPSDEDataRelation)psObjectList2.get(0)).getPSDEDRDetails()) != null) {
                while (psDEDRDetails.hasNext()) {
                    IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
                    if (StringHelper.Compare((String)iPSDEDRDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELOGIC, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEFLOGIC, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    if (StringHelper.Compare((String)iPSDELogic.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELOGICNODE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    psDELogicNodes = iPSDELogic.getPSDELogicNodes();
                    if (psDELogicNodes == null) continue;
                    while (psDELogicNodes.hasNext()) {
                        IPSDELogicNode iPSDELogicNode = psDELogicNodes.next();
                        if (StringHelper.Compare((String)iPSDELogicNode.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDELogicNode);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELNPARAM, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    psDELogicNodes = iPSDELogic.getPSDELogicNodes();
                    if (psDELogicNodes == null) continue;
                    while (psDELogicNodes.hasNext()) {
                        IPSDELogicNode iPSDELogicNode = psDELogicNodes.next();
                        Iterator<IPSDELogicNodeParam> psDELogicNodeParams = iPSDELogicNode.getPSDELogicNodeParams();
                        if (psDELogicNodeParams == null) continue;
                        while (psDELogicNodeParams.hasNext()) {
                            IPSDELogicNodeParam iPSDELogicNodeParam = psDELogicNodeParams.next();
                            if (StringHelper.Compare((String)iPSDELogicNodeParam.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDELogicNodeParam);
                            return list;
                        }
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELOGICPARAM, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    Iterator<? extends IPSDELogicParam> psDELogicParams = iPSDELogic.getPSDELogicParams();
                    if (psDELogicParams == null) continue;
                    while (psDELogicParams.hasNext()) {
                        IPSDELogicParam iPSDELogicParam = psDELogicParams.next();
                        if (StringHelper.Compare((String)iPSDELogicParam.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDELogicParam);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELOGICLINK, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    psDELogicLinks = iPSDELogic.getPSDELogicLinks();
                    if (psDELogicLinks == null) continue;
                    while (psDELogicLinks.hasNext()) {
                        IPSDELogicLink iPSDELogicLink = psDELogicLinks.next();
                        if (StringHelper.Compare((String)iPSDELogicLink.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDELogicLink);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELLCOND, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDELogics = iPSDataEntity.getAllPSDELogics();
                if (psDELogics == null) continue;
                while (psDELogics.hasNext()) {
                    iPSDELogic = psDELogics.next();
                    psDELogicLinks = iPSDELogic.getPSDELogicLinks();
                    if (psDELogicLinks == null) continue;
                    while (psDELogicLinks.hasNext()) {
                        IPSDELogicLink iPSDELogicLink = psDELogicLinks.next();
                        Iterator<? extends IPSDELogicLinkCond> psDELogicLinkConds = iPSDELogicLink.getAllPSDELogicLinkConds();
                        if (psDELogicLinkConds == null) continue;
                        while (psDELogicLinkConds.hasNext()) {
                            IPSDELogicLinkCond iPSDELogicLinkCond = psDELogicLinkConds.next();
                            if (StringHelper.Compare((String)iPSDELogicLinkCond.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDELogicLinkCond);
                            return list;
                        }
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAQUERY, (boolean)false) == 0) {
            IPSDEDataQuery iPSDEDataQuery2;
            Iterator<IPSDEDataQuery> psDEDataQueries;
            if (strModelId.indexOf("#") != -1) {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEDataQueries = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDataQueries()) != null) {
                    while (psDEDataQueries.hasNext()) {
                        iPSDEDataQuery2 = psDEDataQueries.next();
                        if (StringHelper.Compare((String)iPSDEDataQuery2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEDataQuery2);
                        return list;
                    }
                }
            } else {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                    psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
                    if (psDEDataQueries == null) continue;
                    while (psDEDataQueries.hasNext()) {
                        iPSDEDataQuery2 = psDEDataQueries.next();
                        if (StringHelper.Compare((String)iPSDEDataQuery2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEDataQuery2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDQCODE, (boolean)false) == 0) {
            Iterator<IPSDEDataQueryCode> psDEDataQueryCodes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATAQUERY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataQueryCodes = (iPSDEDataQuery = (IPSDEDataQuery)psObjectList2.get(0)).getAllPSDEDataQueryCodes()) != null) {
                while (psDEDataQueryCodes.hasNext()) {
                    IPSDEDataQueryCode iPSDEDataQueryCode2 = psDEDataQueryCodes.next();
                    if (StringHelper.Compare((String)iPSDEDataQueryCode2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataQueryCode2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDQCODECOND, (boolean)false) == 0) {
            Iterator<IPSDEDataQueryCodeCond> psDEDataQueryCodeConds;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDQCODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataQueryCodeConds = (iPSDEDataQueryCode = (IPSDEDataQueryCode)psObjectList2.get(0)).getPSDEDataQueryCodeConds()) != null) {
                while (psDEDataQueryCodeConds.hasNext()) {
                    IPSDEDataQueryCodeCond iPSDEDataQueryCodeCond = psDEDataQueryCodeConds.next();
                    if (StringHelper.Compare((String)iPSDEDataQueryCodeCond.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataQueryCodeCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDQCODEEXP, (boolean)false) == 0) {
            Iterator<IPSDEDataQueryCodeExp> psDEDataQueryCodeExps;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDQCODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataQueryCodeExps = (iPSDEDataQueryCode = (IPSDEDataQueryCode)psObjectList2.get(0)).getPSDEDataQueryCodeExps()) != null) {
                while (psDEDataQueryCodeExps.hasNext()) {
                    IPSDEDataQueryCodeExp iPSDEDataQueryCodeExp = psDEDataQueryCodeExps.next();
                    if (StringHelper.Compare((String)iPSDEDataQueryCodeExp.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataQueryCodeExp);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATASET, (boolean)false) == 0) {
            IPSDEDataSet iPSDEDataSet2;
            Iterator<IPSDEDataSet> psDEDataSets;
            if (strModelId.indexOf("#") != -1) {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEDataSets = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDataSets()) != null) {
                    while (psDEDataSets.hasNext()) {
                        iPSDEDataSet2 = psDEDataSets.next();
                        if (StringHelper.Compare((String)iPSDEDataSet2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEDataSet2);
                        return list;
                    }
                }
            } else {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                    psDEDataSets = iPSDataEntity.getAllPSDEDataSets();
                    if (psDEDataSets == null) continue;
                    while (psDEDataSets.hasNext()) {
                        iPSDEDataSet2 = psDEDataSets.next();
                        if (StringHelper.Compare((String)iPSDEDataSet2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEDataSet2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDSPARAM, (boolean)false) == 0) {
            Iterator<IPSDEDataSetParam> psDEDataSetParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATASET, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataSetParams = (iPSDEDataSet = (IPSDEDataSet)psObjectList2.get(0)).getPSDEDataSetParams()) != null) {
                while (psDEDataSetParams.hasNext()) {
                    IPSDEDataSetParam iPSDEDataSetParam = psDEDataSetParams.next();
                    if (StringHelper.Compare((String)iPSDEDataSetParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataSetParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDSGRPPARAM, (boolean)false) == 0) {
            Iterator<IPSDEDataSetGroupParam> psDEDataSetGroupParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATASET, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataSetGroupParams = (iPSDEDataSet = (IPSDEDataSet)psObjectList2.get(0)).getPSDEDataSetGroupParams()) != null) {
                while (psDEDataSetGroupParams.hasNext()) {
                    IPSDEDataSetGroupParam iPSDEDataSetGroupParam = psDEDataSetGroupParams.next();
                    if (StringHelper.Compare((String)iPSDEDataSetGroupParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataSetGroupParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEPRINT, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                Iterator<IPSDEPrint> psDEPrints = iPSDataEntity.getAllPSDEPrints();
                if (psDEPrints == null) continue;
                while (psDEPrints.hasNext()) {
                    IPSDEPrint iPSDEPrint = psDEPrints.next();
                    if (StringHelper.Compare((String)iPSDEPrint.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEPrint);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEREPORT, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                Iterator<IPSDEReport> psDEReports = iPSDataEntity.getAllPSDEReports();
                if (psDEReports == null) continue;
                while (psDEReports.hasNext()) {
                    IPSDEReport iPSDEReport = psDEReports.next();
                    if (StringHelper.Compare((String)iPSDEReport.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEReport);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEREPITEM, (boolean)false) == 0) {
            IPSDEReport iPSDEReport;
            Iterator<IPSDEReportItem> psDEReportItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEREPORT, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEReportItems = (iPSDEReport = (IPSDEReport)psObjectList2.get(0)).getPSDEReportItems()) != null) {
                while (psDEReportItems.hasNext()) {
                    IPSDEReportItem iPSDEReportItem = psDEReportItems.next();
                    if (StringHelper.Compare((String)iPSDEReportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEReportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTION, (boolean)false) == 0) {
            if (strModelId.indexOf("#") == -1) {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                    psDEActions = iPSDataEntity.getAllPSDEActions();
                    if (psDEActions == null) continue;
                    while (psDEActions.hasNext()) {
                        iPSDEAction2 = psDEActions.next();
                        if (StringHelper.Compare((String)strModelId, (String)iPSDEAction2.getId(), (boolean)true) != 0) continue;
                        list.add(iPSDEAction2);
                        return list;
                    }
                }
            } else {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEActions = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEActions()) != null) {
                    while (psDEActions.hasNext()) {
                        iPSDEAction2 = psDEActions.next();
                        if (StringHelper.Compare((String)strModelId, (String)iPSDEAction2.getModelId(), (boolean)true) != 0) continue;
                        list.add(iPSDEAction2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFDE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                Iterator<IPSDEWF> psDEWFs = iPSDataEntity.getAllPSDEWFs();
                if (psDEWFs == null) continue;
                while (psDEWFs.hasNext()) {
                    IPSDEWF iPSDEWF = psDEWFs.next();
                    if (StringHelper.Compare((String)iPSDEWF.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEWF);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONLOGIC, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                psDEActions = iPSDataEntity.getAllPSDEActions();
                while (psDEActions.hasNext()) {
                    iPSDEAction2 = psDEActions.next();
                    Iterator<IPSDEActionLogic> psDEActionLogics = iPSDEAction2.getPSDEActionLogics();
                    if (psDEActionLogics == null) continue;
                    while (psDEActionLogics.hasNext()) {
                        IPSDEActionLogic iPSDEActionLogic = psDEActionLogics.next();
                        if (StringHelper.Compare((String)iPSDEActionLogic.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEActionLogic);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONPARAM, (boolean)false) == 0) {
            Iterator<IPSDEActionParam> psDEActionParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEACTION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEActionParams = (iPSDEAction = (IPSDEAction)psObjectList2.get(0)).getPSDEActionParams()) != null) {
                while (psDEActionParams.hasNext()) {
                    IPSDEActionParam iPSDEActionParam = psDEActionParams.next();
                    if (StringHelper.Compare((String)iPSDEActionParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEActionParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEACTION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEAction = (IPSDEAction)psObjectList2.get(0);
                list.add(iPSDEAction.getPSDEActionInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEACTION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEAction = (IPSDEAction)psObjectList2.get(0);
                list.add(iPSDEAction.getPSDEActionReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATASETINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATASET, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEDataSet = (IPSDEDataSet)psObjectList2.get(0);
                list.add(iPSDEDataSet.getPSDEDataSetInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATASETRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATASET, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEDataSet = (IPSDEDataSet)psObjectList2.get(0);
                list.add(iPSDEDataSet.getPSDEDataSetReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAQUERYINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATAQUERY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEDataQuery = (IPSDEDataQuery)psObjectList2.get(0);
                list.add(iPSDEDataQuery.getPSDEDataQueryInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAQUERYRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDATAQUERY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSDEDataQuery = (IPSDEDataQuery)psObjectList2.get(0);
                list.add(iPSDEDataQuery.getPSDEDataQueryReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMETHODINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMETHOD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSAppDEMethod = (IPSAppDEMethod)psObjectList2.get(0);
                list.add(iPSAppDEMethod.getPSAppDEMethodInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMETHODRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMETHOD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSAppDEMethod = (IPSAppDEMethod)psObjectList2.get(0);
                list.add(iPSAppDEMethod.getPSAppDEMethodReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWORKFLOW, (boolean)false) == 0) {
            list.add(iPSSystem.getPSWorkflow(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFROLE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSWFRole(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFWORKTIME, (boolean)false) == 0) {
            list.add(iPSSystem.getPSWFWorkTime(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFVERSION, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    if (StringHelper.Compare((String)iPSWFVersion.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFVersion);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFUIACTION, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    Iterator<IPSWFUIAction> psWFUIActions = iPSWFVersion.getAllPSWFUIActions();
                    if (psWFUIActions == null) continue;
                    while (psWFUIActions.hasNext()) {
                        IPSWFUIAction iPSWFUIAction = psWFUIActions.next();
                        if (StringHelper.Compare((String)iPSWFUIAction.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSWFUIAction);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFPROCESS, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    Iterator<IPSWFProcess> psWFProcesses = iPSWFVersion.getPSWFProcesses();
                    while (psWFProcesses.hasNext()) {
                        IPSWFProcess iPSWFProcess2 = psWFProcesses.next();
                        if (StringHelper.Compare((String)iPSWFProcess2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSWFProcess2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFLINK, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    Iterator<IPSWFLink> psWFLinks = iPSWFVersion.getPSWFLinks();
                    while (psWFLinks.hasNext()) {
                        IPSWFLink iPSWFLink = psWFLinks.next();
                        if (StringHelper.Compare((String)iPSWFLink.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSWFLink);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFPROCPARAM, (boolean)false) == 0) {
            Iterator<IPSWFProcessParam> psWFProcessParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSWFPROCESS, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psWFProcessParams = (iPSWFProcess = (IPSWFProcess)psObjectList2.get(0)).getPSWFProcessParams()) != null) {
                while (psWFProcessParams.hasNext()) {
                    IPSWFProcessParam iPSWFProcessParam = psWFProcessParams.next();
                    if (StringHelper.Compare((String)iPSWFProcessParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFProcessParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFPROCSUBWF, (boolean)false) == 0) {
            Iterator<IPSWFProcessSubWF> psWFProcessSubWFs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSWFPROCESS, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSWFProcess = (IPSWFProcess)psObjectList2.get(0)) instanceof IPSWFEmbedWFProcessBase && (psWFProcessSubWFs = ((IPSWFEmbedWFProcessBase)iPSWFProcess).getPSWFProcessSubWFs()) != null) {
                while (psWFProcessSubWFs.hasNext()) {
                    IPSWFProcessSubWF iPSWFProcessSubWF = psWFProcessSubWFs.next();
                    if (StringHelper.Compare((String)iPSWFProcessSubWF.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFProcessSubWF);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFPROCROLE, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSWFPROCESS, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSWFCallOrgActivityProcess iPSWFCallOrgActivityProcess;
                IPSWFProcessRole iPSWFProcessRole;
                IPSWFInteractiveProcess iPSWFInteractiveProcess;
                Iterator<IPSWFProcessRole> psWFProcessRoles;
                iPSWFProcess = (IPSWFProcess)psObjectList2.get(0);
                if (iPSWFProcess instanceof IPSWFInteractiveProcess && (psWFProcessRoles = (iPSWFInteractiveProcess = (IPSWFInteractiveProcess)iPSWFProcess).getPSWFProcessRoles()) != null) {
                    while (psWFProcessRoles.hasNext()) {
                        iPSWFProcessRole = psWFProcessRoles.next();
                        if (StringHelper.Compare((String)iPSWFProcessRole.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSWFProcessRole);
                        return list;
                    }
                }
                if (iPSWFProcess instanceof IPSWFCallOrgActivityProcess && (psWFProcessRoles = (iPSWFCallOrgActivityProcess = (IPSWFCallOrgActivityProcess)iPSWFProcess).getPSWFProcessRoles()) != null) {
                    while (psWFProcessRoles.hasNext()) {
                        iPSWFProcessRole = psWFProcessRoles.next();
                        if (StringHelper.Compare((String)iPSWFProcessRole.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSWFProcessRole);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFLINKROLE, (boolean)false) == 0) {
            IPSWFInteractiveLink iPSWFInteractiveLink;
            Iterator<IPSWFLinkRole> psWFLinkRoles;
            IPSWFLink iPSWFLink;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSWFLINK, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSWFLink = (IPSWFLink)psObjectList2.get(0)) instanceof IPSWFInteractiveLink && (psWFLinkRoles = (iPSWFInteractiveLink = (IPSWFInteractiveLink)iPSWFLink).getPSWFLinkRoles()) != null) {
                while (psWFLinkRoles.hasNext()) {
                    IPSWFLinkRole iPSWFLinkRole = psWFLinkRoles.next();
                    if (StringHelper.Compare((String)iPSWFLinkRole.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFLinkRole);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSERVICEAPI, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysServiceAPI(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSERVICEAPI, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSubSysServiceAPI(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVSLNMSDEPAPI, (boolean)false) == 0) {
            psDevSlnMSDepAPIs = iPSSystem.getPSDevSlnMSDepAPIs();
            if (psDevSlnMSDepAPIs != null) {
                while (psDevSlnMSDepAPIs.hasNext()) {
                    iPSDevSlnMSDepAPI = psDevSlnMSDepAPIs.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepAPI.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepAPI);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVSLNMSDEPAPP, (boolean)false) == 0) {
            Iterator<IPSDevSlnMSDepApp> psDevSlnMSDepApps2 = iPSSystem.getPSDevSlnMSDepApps();
            if (psDevSlnMSDepApps2 != null) {
                while (psDevSlnMSDepApps2.hasNext()) {
                    IPSDevSlnMSDepApp iPSDevSlnMSDepApp2 = psDevSlnMSDepApps2.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepApp2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepApp2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVSLNMSDEPFUNC, (boolean)false) == 0) {
            Iterator<IPSDevSlnMSDepFunc> psDevSlnMSDepFuncs = iPSSystem.getAllPSDevSlnMSDepFuncs();
            if (psDevSlnMSDepFuncs != null) {
                while (psDevSlnMSDepFuncs.hasNext()) {
                    IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = psDevSlnMSDepFuncs.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepFunc.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepFunc);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSDEVSLNMSDEPFUNCITEM", (boolean)false) == 0) {
            IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc;
            Iterator<IPSDevSlnMSDepFuncItem> psDevSlnMSDepFuncItems;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psObjectList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEVSLNMSDEPFUNC, items3[0])).size() > 0 && (psDevSlnMSDepFuncItems = (iPSDevSlnMSDepFunc = (IPSDevSlnMSDepFunc)psObjectList.get(0)).getPSDevSlnMSDepFuncItems()) != null) {
                while (psDevSlnMSDepFuncItems.hasNext()) {
                    IPSDevSlnMSDepFuncItem iPSDevSlnMSDepFuncItem = psDevSlnMSDepFuncItems.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepFuncItem.getId(), (String)items3[1], (boolean)true) != 0) continue;
                    list.add(iPSDevSlnMSDepFuncItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDCDEPLOYCENTER, (boolean)false) == 0) {
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            if (iPSSystemRuntime.getPSDeployCenter() != null && StringHelper.Compare((String)iPSSystemRuntime.getPSDeployCenter().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystemRuntime.getPSDeployCenter());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDCWORKSHOPSERVER, (boolean)false) == 0) {
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            if (iPSSystemRuntime.getPSWorkshopServer() != null && StringHelper.Compare((String)iPSSystemRuntime.getPSWorkshopServer().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystemRuntime.getPSWorkshopServer());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVSLNSYSWSGIT, (boolean)false) == 0) {
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            if (iPSSystemRuntime.getPSDevSlnSysWSGit() != null && StringHelper.Compare((String)iPSSystemRuntime.getPSDevSlnSysWSGit().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystemRuntime.getPSDevSlnSysWSGit());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTEMDBCFG, (boolean)false) == 0) {
            Iterator<IPSSystemDBConfig> psSystemDBConfigs = iPSSystem.getAllPSSystemDBConfigs();
            if (psSystemDBConfigs != null) {
                while (psSystemDBConfigs.hasNext()) {
                    IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                    if (StringHelper.Compare((String)iPSSystemDBConfig.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSystemDBConfig);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDMVER, (boolean)false) == 0) {
            Iterator<IPSSysDMVer> psSysDMVers = iPSSystem.getAllPSSysDMVers();
            if (psSysDMVers != null) {
                while (psSysDMVers.hasNext()) {
                    IPSSysDMVer iPSSysDMVer = psSysDMVers.next();
                    if (StringHelper.Compare((String)iPSSysDMVer.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysDMVer);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTEM_SETTING, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSystemSetting());
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSAPP_UI, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    iPSApplication = psApplications.next();
                    if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0 || StringHelper.Compare((String)iPSApplication.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSApplication.getPSApplicationUI());
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSWFSETTING, (boolean)false) == 0) {
            if (iPSSystem.getPSSysWFSetting() != null) {
                list.add(iPSSystem.getPSSysWFSetting());
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMSGTEMPL, (boolean)false) == 0) {
            Iterator<IPSSysMsgTempl> psSysMsgTempls = iPSSystem.getAllPSSysMsgTempls();
            if (psSysMsgTempls != null) {
                while (psSysMsgTempls.hasNext()) {
                    IPSSysMsgTempl iPSSysMsgTempl = psSysMsgTempls.next();
                    if (StringHelper.Compare((String)iPSSysMsgTempl.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysMsgTempl);
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVCENTERAS, (boolean)false) == 0) {
            psSysSFPubs = iPSSystem.getAllPSSysSFPubs();
            if (psSysSFPubs != null) {
                while (psSysSFPubs.hasNext()) {
                    iPSSysSFPub = psSysSFPubs.next();
                    psSysSFPubList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSSFPUB, iPSSysSFPub.getId());
                    if (psSysSFPubList.size() <= 0 || !(psSysSFPubList.get(0) instanceof IPSSysRunSession) || (iPSSysRunSession = (IPSSysRunSession)psSysSFPubList.get(0)).getPSAppServer() == null || StringHelper.Compare((String)iPSSysRunSession.getPSAppServer().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysRunSession.getPSAppServer());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEVCENTERDBINST, (boolean)false) == 0) {
            Iterator<IPSDevSlnMSDepApp> psDevSlnMSDepApps3;
            Iterator<IPSDevSlnMSDepAPI> psDevSlnMSDepAPIs2;
            psSysSFPubs = iPSSystem.getAllPSSysSFPubs();
            if (psSysSFPubs != null) {
                while (psSysSFPubs.hasNext()) {
                    iPSSysSFPub = psSysSFPubs.next();
                    psSysSFPubList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSSFPUB, iPSSysSFPub.getId());
                    if (psSysSFPubList.size() <= 0 || !(psSysSFPubList.get(0) instanceof IPSSysRunSession) || (iPSSysRunSession = (IPSSysRunSession)psSysSFPubList.get(0)).getPSDBDevInst() == null || StringHelper.Compare((String)iPSSysRunSession.getPSDBDevInst().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysRunSession.getPSDBDevInst());
                    return list;
                }
            }
            if ((psDevSlnMSDepAPIs2 = iPSSystem.getAllPSDevSlnMSDepAPIs()) != null) {
                while (psDevSlnMSDepAPIs2.hasNext()) {
                    IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI2 = psDevSlnMSDepAPIs2.next();
                    if (iPSDevSlnMSDepAPI2.getPSDBDevInst() == null || StringHelper.Compare((String)iPSDevSlnMSDepAPI2.getPSDBDevInst().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepAPI2.getPSDBDevInst());
                    return list;
                }
            }
            if ((psDevSlnMSDepApps3 = iPSSystem.getAllPSDevSlnMSDepApps()) != null) {
                while (psDevSlnMSDepApps3.hasNext()) {
                    IPSDevSlnMSDepApp iPSDevSlnMSDepApp3 = psDevSlnMSDepApps3.next();
                    if (iPSDevSlnMSDepApp3.getPSDBDevInst() == null || StringHelper.Compare((String)iPSDevSlnMSDepApp3.getPSDBDevInst().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepApp3.getPSDBDevInst());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDBSERVER, (boolean)false) == 0) {
            psSysSFPubs = iPSSystem.getAllPSSysSFPubs();
            if (psSysSFPubs != null) {
                while (psSysSFPubs.hasNext()) {
                    iPSSysSFPub = psSysSFPubs.next();
                    psSysSFPubList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSSFPUB, iPSSysSFPub.getId());
                    if (psSysSFPubList.size() <= 0 || !(psSysSFPubList.get(0) instanceof IPSSysRunSession) || (iPSSysRunSession = (IPSSysRunSession)psSysSFPubList.get(0)).getPSDBDevInst() == null || iPSSysRunSession.getPSDBDevInst().getPSDBServer() == null || StringHelper.Compare((String)iPSSysRunSession.getPSDBDevInst().getPSDBServer().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysRunSession.getPSDBDevInst().getPSDBServer());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDCMSPLATFORM, (boolean)false) == 0) {
            psDevSlnMSDepAPIs = iPSSystem.getAllPSDevSlnMSDepAPIs();
            if (psDevSlnMSDepAPIs != null) {
                while (psDevSlnMSDepAPIs.hasNext()) {
                    iPSDevSlnMSDepAPI = psDevSlnMSDepAPIs.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepAPI.getPSDCMSPlatform().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepAPI.getPSDCMSPlatform());
                    return list;
                }
            }
            if ((psDevSlnMSDepApps = iPSSystem.getAllPSDevSlnMSDepApps()) != null) {
                while (psDevSlnMSDepApps.hasNext()) {
                    iPSDevSlnMSDepApp = psDevSlnMSDepApps.next();
                    if (StringHelper.Compare((String)iPSDevSlnMSDepApp.getPSDCMSPlatform().getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDevSlnMSDepApp.getPSDCMSPlatform());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDCMSPLATFORMNODE, (boolean)false) == 0) {
            psDevSlnMSDepAPIs = iPSSystem.getAllPSDevSlnMSDepAPIs();
            if (psDevSlnMSDepAPIs != null) {
                while (psDevSlnMSDepAPIs.hasNext()) {
                    iPSDevSlnMSDepAPI = psDevSlnMSDepAPIs.next();
                    Iterator<IPSDCMSPlatformNode> psDCMSPlatformNodes = iPSDevSlnMSDepAPI.getPSDCMSPlatform().getAllPSDCMSPlatformNodes();
                    while (psDCMSPlatformNodes.hasNext()) {
                        IPSDCMSPlatformNode iPSDCMSPlatformNode = psDCMSPlatformNodes.next();
                        if (StringHelper.Compare((String)iPSDCMSPlatformNode.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDCMSPlatformNode);
                        return list;
                    }
                }
            }
            if ((psDevSlnMSDepApps = iPSSystem.getAllPSDevSlnMSDepApps()) != null) {
                while (psDevSlnMSDepApps.hasNext()) {
                    iPSDevSlnMSDepApp = psDevSlnMSDepApps.next();
                    Iterator<IPSDCMSPlatformNode> psDCMSPlatformNodes = iPSDevSlnMSDepApp.getPSDCMSPlatform().getAllPSDCMSPlatformNodes();
                    while (psDCMSPlatformNodes.hasNext()) {
                        IPSDCMSPlatformNode iPSDCMSPlatformNode = psDCMSPlatformNodes.next();
                        if (StringHelper.Compare((String)iPSDCMSPlatformNode.getId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDCMSPlatformNode);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSACHANDLER, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSCONTROL, strModelId);
            if (psObjectList2.size() > 0) {
                IPSAjaxControl iPSAjaxControl;
                iPSControl = (IPSControl)psObjectList2.get(0);
                if (iPSControl.getPSControlHandler() != null) {
                    list.add(iPSControl.getPSControlHandler());
                    return list;
                }
                if (iPSControl instanceof IPSAjaxControl && (iPSAjaxControl = (IPSAjaxControl)iPSControl).isAjaxCtrl() && iPSAjaxControl.getPSAjaxControlHandler() != null) {
                    list.add(iPSAjaxControl.getPSAjaxControlHandler());
                    return list;
                }
            }
            if ((items2 = strModelId.split("[#]")).length == 2 && (appViewList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items2[0])).size() > 0) {
                iPSAppView2 = (IPSAppView)appViewList2.get(0);
                for (IPSControl iPSControl5 : iPSAppView2.getAllPSControls()) {
                    IPSAjaxControl iPSAjaxControl;
                    if (StringHelper.Compare((String)iPSControl5.getName(), (String)items2[1], (boolean)true) != 0) continue;
                    if (iPSControl5.getPSControlHandler() != null) {
                        list.add(iPSControl5.getPSControlHandler());
                        return list;
                    }
                    if (!(iPSControl5 instanceof IPSAjaxControl) || !(iPSAjaxControl = (IPSAjaxControl)iPSControl5).isAjaxCtrl() || iPSAjaxControl.getPSAjaxControlHandler() == null) continue;
                    list.add(iPSAjaxControl.getPSAjaxControlHandler());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSACHANDLERACTION, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSACHANDLER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSAjaxControlHandler iPSAjaxControlHandler;
                Iterator psAjaxHandlerActions;
                IPSControlHandler iPSControlHandler;
                Iterator<? extends IPSControlHandlerAction> psControlHandlerActions;
                if (psObjectList2.get(0) instanceof IPSControlHandler && (psControlHandlerActions = (iPSControlHandler = (IPSControlHandler)psObjectList2.get(0)).getPSHandlerActions()) != null) {
                    while (psControlHandlerActions.hasNext()) {
                        IPSControlHandlerAction iPSControlHandlerAction = psControlHandlerActions.next();
                        if (StringHelper.Compare((String)strModelId, (String)iPSControlHandlerAction.getModelId(), (boolean)false) != 0) continue;
                        list.add(iPSControlHandlerAction);
                        return list;
                    }
                }
                if (psObjectList2.get(0) instanceof IPSAjaxControlHandler && (psAjaxHandlerActions = (iPSAjaxControlHandler = (IPSAjaxControlHandler)psObjectList2.get(0)).getPSAjaxHandlerActions()) != null) {
                    while (psAjaxHandlerActions.hasNext()) {
                        IPSAjaxHandlerAction iPSAjaxHandlerAction = (IPSAjaxHandlerAction)psAjaxHandlerActions.next();
                        if (StringHelper.Compare((String)strModelId, (String)iPSAjaxHandlerAction.getModelId(), (boolean)false) != 0) continue;
                        list.add(iPSAjaxHandlerAction);
                        return list;
                    }
                }
            }
            if ((items2 = strModelId.split("[#]")).length == 3 && (appViewList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items2[0])).size() > 0) {
                iPSAppView2 = (IPSAppView)appViewList2.get(0);
                for (IPSControl iPSControl6 : iPSAppView2.getAllPSControls()) {
                    Iterator psAjaxHandlerActions;
                    IPSAjaxControl iPSAjaxControl;
                    if (StringHelper.Compare((String)iPSControl6.getName(), (String)items2[1], (boolean)true) != 0 || !(iPSControl6 instanceof IPSAjaxControl) || !(iPSAjaxControl = (IPSAjaxControl)iPSControl6).isAjaxCtrl() || iPSAjaxControl.getPSAjaxControlHandler() == null || (psAjaxHandlerActions = iPSAjaxControl.getPSAjaxControlHandler().getPSAjaxHandlerActions()) == null) continue;
                    while (psAjaxHandlerActions.hasNext()) {
                        IPSAjaxHandlerAction iPSAjaxHandlerAction = (IPSAjaxHandlerAction)psAjaxHandlerActions.next();
                        if (StringHelper.Compare((String)items2[2], (String)iPSAjaxHandlerAction.getName(), (boolean)false) != 0) continue;
                        list.add(iPSAjaxHandlerAction);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSEDITORTYPE, (boolean)false) == 0) {
            list.add(PSObjectFactory.getPSModelStorage(iDAGlobalHelper).getPSEditorType(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSVIEWTYPE, (boolean)false) == 0) {
            list.add(PSObjectFactory.getPSModelStorage(iDAGlobalHelper).getPSViewType(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEDITORSTYLE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysEditorStyle(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDELOGICNODE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysLogic(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERDR, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysUserDR(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSVNSERVER, (boolean)false) == 0) {
            if (iPSSystem.getReadOnlyPSSVNInstRepo() != null && iPSSystem.getReadOnlyPSSVNInstRepo().getPSSVNServer() != null && StringHelper.Compare((String)iPSSystem.getReadOnlyPSSVNInstRepo().getPSSVNServer().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystem.getReadOnlyPSSVNInstRepo().getPSSVNServer());
                return list;
            }
            if (iPSSystem.getPSSVNInstRepo() != null && iPSSystem.getPSSVNInstRepo().getPSSVNServer() != null && StringHelper.Compare((String)iPSSystem.getPSSVNInstRepo().getPSSVNServer().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystem.getPSSVNInstRepo().getPSSVNServer());
                return list;
            }
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            if (iPSSystemRuntime.getPSWorkshopServer() != null && iPSSystemRuntime.getPSWorkshopServer().getPSSVNServer() != null && StringHelper.Compare((String)iPSSystemRuntime.getPSWorkshopServer().getPSSVNServer().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystemRuntime.getPSWorkshopServer().getPSSVNServer());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSVNINSTREPO, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEVCENTERSVN, (boolean)false) == 0) {
            if (iPSSystem.getReadOnlyPSSVNInstRepo() != null && StringHelper.Compare((String)iPSSystem.getReadOnlyPSSVNInstRepo().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystem.getReadOnlyPSSVNInstRepo());
                return list;
            }
            if (iPSSystem.getPSSVNInstRepo() != null && StringHelper.Compare((String)iPSSystem.getPSSVNInstRepo().getId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSSystem.getPSSVNInstRepo());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAEXP, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEDataExport iPSDEDataExport2 = iPSDataEntity.getPSDEDataExport(strModelId, true);
                if (iPSDEDataExport2 == null) continue;
                list.add(iPSDEDataExport2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAEXPITEM, (boolean)false) == 0) {
            psDEDataExpList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAEXP, PSModels.getParentModelId(strModelId));
            if (psDEDataExpList2.size() > 0 && (psDEDataExportItems = (iPSDEDataExport = (IPSDEDataExport)psDEDataExpList2.get(0)).getPSDEDataExportItems()) != null) {
                while (psDEDataExportItems.hasNext()) {
                    iPSDEDataExportItem = psDEDataExportItems.next();
                    if (StringHelper.Compare((String)iPSDEDataExportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataExportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAEXPGROUP, (boolean)false) == 0) {
            psDEDataExpList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAEXP, PSModels.getParentModelId(strModelId));
            if (psDEDataExpList2.size() > 0 && (psDEDataExportGroups = (iPSDEDataExport = (IPSDEDataExport)psDEDataExpList2.get(0)).getPSDEDataExportGroups()) != null) {
                while (psDEDataExportGroups.hasNext()) {
                    iPSDEDataExportGroup = psDEDataExportGroups.next();
                    if (StringHelper.Compare((String)iPSDEDataExportGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataExportGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAIMP, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEDataImport iPSDEDataImport = iPSDataEntity.getPSDEDataImport(strModelId, true);
                if (iPSDEDataImport == null) continue;
                list.add(iPSDEDataImport);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAIMPITEM, (boolean)false) == 0) {
            IPSDEDataImport iPSDEDataImport;
            psDEDataExpList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAIMP, PSModels.getParentModelId(strModelId));
            if (psDEDataExpList2.size() > 0 && (psDEDataImportItems = (iPSDEDataImport = (IPSDEDataImport)psDEDataExpList2.get(0)).getPSDEDataImportItems()) != null) {
                while (psDEDataImportItems.hasNext()) {
                    iPSDEDataImportItem = psDEDataImportItems.next();
                    if (StringHelper.Compare((String)iPSDEDataImportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataImportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTTITLE, (boolean)false) == 0 || strModelType.indexOf("PSDECHARTTITLE_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEChart = (IPSDEChart)psControlList2.get(0);
                list.add(iPSDEChart.getPSDEChartTitle());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTCOORDINATESYSTEM, (boolean)false) == 0 || strModelType.indexOf("PSDECHARTCOORDINATESYSTEM_") == 0) {
            Iterator<? extends IPSChartCoordinateSystem> psChartCoordinateSystems;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psChartCoordinateSystems = (iPSDEChart2 = (IPSDEChart)psControlList.get(0)).getPSChartCoordinateSystems()) != null) {
                while (psChartCoordinateSystems.hasNext()) {
                    IPSChartCoordinateSystem iPSChartCoordinateSystem = psChartCoordinateSystems.next();
                    if (StringHelper.Compare((String)iPSChartCoordinateSystem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSChartCoordinateSystem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTGRID, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTRADAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTPOLAR, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTPARALLEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTSINGLE, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTGEO, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTCALENDAR, (boolean)false) == 0) {
            IPSDEChartCoordinateSystem iPSDEChartCoordinateSystem;
            IPSChartCoordinateSystemControl iPSChartCoordinateSystemControl;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTCOORDINATESYSTEM, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (iPSChartCoordinateSystemControl = (iPSDEChartCoordinateSystem = (IPSDEChartCoordinateSystem)psControlList.get(0)).getPSChartCoordinateSystemControl()) != null) {
                list.add(iPSChartCoordinateSystemControl);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTPOLARRADIUSAXIS, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTPOLARANGLEAXIS, (boolean)false) == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTPOLAR, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0) {
                IPSChartPolar iPSChartPolar = (IPSChartPolar)psControlList.get(0);
                if (iPSChartPolar.getPSChartPolarAngleAxis() != null && StringHelper.Compare((String)iPSChartPolar.getPSChartPolarAngleAxis().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartPolar.getPSChartPolarAngleAxis());
                    return list;
                }
                if (iPSChartPolar.getPSChartPolarRadiusAxis() != null && StringHelper.Compare((String)iPSChartPolar.getPSChartPolarRadiusAxis().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartPolar.getPSChartPolarRadiusAxis());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTGRIDXAXIS, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDECHARTGRIDYAXIS, (boolean)false) == 0) {
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTGRID, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0) {
                IPSChartGrid iPSChartGrid = (IPSChartGrid)psControlList.get(0);
                if (iPSChartGrid.getPSChartGridXAxis0() != null && StringHelper.Compare((String)iPSChartGrid.getPSChartGridXAxis0().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartGrid.getPSChartGridXAxis0());
                    return list;
                }
                if (iPSChartGrid.getPSChartGridXAxis1() != null && StringHelper.Compare((String)iPSChartGrid.getPSChartGridXAxis1().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartGrid.getPSChartGridXAxis1());
                    return list;
                }
                if (iPSChartGrid.getPSChartGridYAxis0() != null && StringHelper.Compare((String)iPSChartGrid.getPSChartGridYAxis0().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartGrid.getPSChartGridYAxis0());
                    return list;
                }
                if (iPSChartGrid.getPSChartGridYAxis1() != null && StringHelper.Compare((String)iPSChartGrid.getPSChartGridYAxis1().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSChartGrid.getPSChartGridYAxis1());
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTSINGLEAXIS, (boolean)false) == 0) {
            IPSChartSingle iPSChartSingle;
            IPSChartSingleAxis iPSChartSingleAxis;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTSINGLE, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (iPSChartSingleAxis = (iPSChartSingle = (IPSChartSingle)psControlList.get(0)).getPSChartSingleAxis()) != null && StringHelper.Compare((String)iPSChartSingleAxis.getModelId(), (String)strModelId, (boolean)false) == 0) {
                list.add(iPSChartSingleAxis);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTPARALLELAXIS, (boolean)false) == 0) {
            IPSChartParallel iPSChartParallel;
            Iterator<IPSChartParallelAxis> psChartParallelAxises;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTPARALLEL, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psChartParallelAxises = (iPSChartParallel = (IPSChartParallel)psControlList.get(0)).getPSChartParallelAxises()) != null) {
                while (psChartParallelAxises.hasNext()) {
                    IPSChartParallelAxis iPSChartParallelAxis = psChartParallelAxises.next();
                    if (StringHelper.Compare((String)iPSChartParallelAxis.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSChartParallelAxis);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTDATASET, (boolean)false) == 0) {
            Iterator<? extends IPSChartDataSet> psChartDataSets;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psChartDataSets = (iPSDEChart2 = (IPSDEChart)psControlList.get(0)).getPSChartDataSets()) != null) {
                while (psChartDataSets.hasNext()) {
                    IPSChartDataSet iPSChartDataSet = psChartDataSets.next();
                    if (StringHelper.Compare((String)iPSChartDataSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSChartDataSet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTDATASETGROUP, (boolean)false) == 0) {
            Iterator<? extends IPSChartDataSetGroup> psChartDataSetGroups;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psChartDataSetGroups = (iPSDEChart2 = (IPSDEChart)psControlList.get(0)).getPSChartDataSetGroups()) != null) {
                while (psChartDataSetGroups.hasNext()) {
                    IPSChartDataSetGroup iPSChartDataSetGroup = psChartDataSetGroups.next();
                    if (StringHelper.Compare((String)iPSChartDataSetGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSChartDataSetGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTDATASETFIELD, (boolean)false) == 0) {
            IPSChartDataSet iPSChartDataSet;
            Iterator<? extends IPSChartDataSetField> psChartDataSetFields;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTDATASET, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psChartDataSetFields = (iPSChartDataSet = (IPSChartDataSet)psControlList.get(0)).getPSChartDataSetFields()) != null) {
                while (psChartDataSetFields.hasNext()) {
                    IPSChartDataSetField iPSChartDataSetField = psChartDataSetFields.next();
                    if (StringHelper.Compare((String)iPSChartDataSetField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSChartDataSetField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTLEGEND, (boolean)false) == 0 || strModelType.indexOf("PSDECHARTLEGEND_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEChart = (IPSDEChart)psControlList2.get(0);
                list.add(iPSDEChart.getPSDEChartLegend());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSDECHARTDATAGRID", (boolean)false) == 0 || strModelType.indexOf("PSDECHARTDATAGRID_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEChart = (IPSDEChart)psControlList2.get(0);
                list.add(iPSDEChart.getPSDEChartDataGrid());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTAXES, (boolean)false) == 0 || strModelType.indexOf("PSDECHARTAXES_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEChart = (IPSDEChart)psControlList2.get(0);
                Iterator<IPSDEChartAxes> psDEChartAxess = iPSDEChart.getPSDEChartAxeses();
                while (psDEChartAxess.hasNext()) {
                    IPSDEChartAxes iPSDEChartAxes = psDEChartAxess.next();
                    if (StringHelper.Compare((String)iPSDEChartAxes.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEChartAxes);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTSERIESENCODE, (boolean)false) == 0) {
            IPSChartSeries iPSChartSeries;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHARTPARAM, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (iPSChartSeries = (IPSChartSeries)psControlList.get(0)).getPSChartSeriesEncode() != null) {
                list.add(iPSChartSeries.getPSChartSeriesEncode());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDECHARTPARAM, (boolean)false) == 0 || strModelType.indexOf("PSDECHARTPARAM_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDECHART, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0) {
                iPSDEChart = (IPSDEChart)psControlList2.get(0);
                Iterator<IPSDEChartSeries> psDEChartColumns = iPSDEChart.getPSDEChartSerieses();
                while (psDEChartColumns.hasNext()) {
                    IPSDEChartSeries iPSDEChartSeries = psDEChartColumns.next();
                    if (StringHelper.Compare((String)iPSDEChartSeries.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEChartSeries);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUNISTATE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEUniState iPSDEUniState = iPSDataEntity.getPSDEUniState(strModelId, true);
                if (iPSDEUniState == null) continue;
                list.add(iPSDEUniState);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESAMPLEDATA, (boolean)false) == 0) {
            Iterator<IPSDESampleData> psDESampleDatas;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDESampleDatas = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDESampleDatas()) != null) {
                while (psDESampleDatas.hasNext()) {
                    IPSDESampleData iPSDESampleData = psDESampleDatas.next();
                    if (StringHelper.Compare((String)iPSDESampleData.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDESampleData);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUNISTATE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysUniState(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDATASYNCAGENT, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysDataSyncAgent(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAVIEWDATAITEM, (boolean)false) == 0 || strModelType.indexOf("PSDEDATAVIEWDATAITEM_") == 0) {
            IPSDEDataView iPSDEDataView2;
            Iterator<IPSDEDataViewDataItem> psDEDataViewDataItems;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDEDataViewDataItems = (iPSDEDataView2 = (IPSDEDataView)psControlList2.get(0)).getPSDEDataViewDataItems()) != null) {
                while (psDEDataViewDataItems.hasNext()) {
                    IPSDEDataViewDataItem iPSDEDataViewDataItem = psDEDataViewDataItems.next();
                    if (StringHelper.Compare((String)iPSDEDataViewDataItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEDataViewDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUAGROUP, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEUIActionGroup iPSDEUIActionGroup = iPSDataEntity.getPSDEUIActionGroup(strModelId, true);
                if (iPSDEUIActionGroup == null) continue;
                list.add(iPSDEUIActionGroup);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUIACTION, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEUIAction iPSDEUIAction = iPSDataEntity.getPSDEUIAction(strModelId, true);
                if (iPSDEUIAction == null) continue;
                list.add(iPSDEUIAction);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUAGRPDETAIL, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 2) {
                Iterator<IPSDataEntity> psDataEntities3 = iPSSystem.getAllPSDataEntities();
                while (psDataEntities3.hasNext()) {
                    Iterator<IPSDEUIActionGroupDetail> psDEUIActionGroupDetails2;
                    IPSDataEntity iPSDataEntity4 = psDataEntities3.next();
                    IPSDEUIActionGroup iPSDEUIActionGroup = iPSDataEntity4.getPSDEUIActionGroup(items3[0], true);
                    if (iPSDEUIActionGroup == null || (psDEUIActionGroupDetails2 = iPSDEUIActionGroup.getPSDEUIActionGroupDetails()) == null) continue;
                    while (psDEUIActionGroupDetails2.hasNext()) {
                        IPSDEUIActionGroupDetail iPSDEUIActionGroupDetail2 = psDEUIActionGroupDetails2.next();
                        if (StringHelper.Compare((String)iPSDEUIActionGroupDetail2.getId(), (String)items3[1], (boolean)true) != 0) continue;
                        list.add(iPSDEUIActionGroupDetail2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFUAGROUP, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                if (psWFVersions == null) continue;
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    IPSWFUIActionGroup iPSWFUIActionGroup = iPSWFVersion.getPSWFUIActionGroup(strModelId, true);
                    if (iPSWFUIActionGroup == null) continue;
                    list.add(iPSWFUIActionGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFUIACTION, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                if (psWFVersions == null) continue;
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    IPSWFUIAction iPSWFUIAction = iPSWFVersion.getPSWFUIAction(strModelId, true);
                    if (iPSWFUIAction == null) continue;
                    list.add(iPSWFUIAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFUAGRPDETAIL, (boolean)false) == 0) {
            psWorkflows = iPSSystem.getAllPSWorkflows();
            while (psWorkflows.hasNext()) {
                iPSWorkflow = psWorkflows.next();
                psWFVersions = iPSWorkflow.getPSWFVersions();
                if (psWFVersions == null) continue;
                while (psWFVersions.hasNext()) {
                    iPSWFVersion = psWFVersions.next();
                    Iterator<IPSWFUIActionGroup> psWFUIActionGroups = iPSWFVersion.getPSWFUIActionGroups();
                    if (psWFUIActionGroups == null) continue;
                    while (psWFUIActionGroups.hasNext()) {
                        IPSWFUIActionGroup iPSWFUIActionGroup = psWFUIActionGroups.next();
                        Iterator<IPSWFUIActionGroupDetail> psWFUIActionGroupDetails2 = iPSWFUIActionGroup.getPSWFUIActionGroupDetails();
                        if (psWFUIActionGroupDetails2 == null) continue;
                        while (psWFUIActionGroupDetails2.hasNext()) {
                            IPSWFUIActionGroupDetail iPSWFUIActionGroupDetail2 = psWFUIActionGroupDetails2.next();
                            if (StringHelper.Compare((String)iPSWFUIActionGroupDetail2.getId(), (String)strModelId, (boolean)true) != 0) continue;
                            list.add(iPSWFUIActionGroupDetail2);
                            return list;
                        }
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODE, (boolean)false) == 0 || strModelType.indexOf("PSDETREENODE_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDETreeNodes = (iPSDETree = (IPSDETree)psControlList2.get(0)).getPSDETreeNodes()) != null) {
                while (psDETreeNodes.hasNext()) {
                    iPSDETreeNode2 = psDETreeNodes.next();
                    if (StringHelper.Compare((String)iPSDETreeNode2.getId(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDETreeNode2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODERS, (boolean)false) == 0 || strModelType.indexOf("PSDETREENODERS_") == 0) {
            Iterator<IPSDETreeNodeRS> psDETreeNodeRSs;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDETreeNodeRSs = (iPSDETree = (IPSDETree)psControlList2.get(0)).getPSDETreeNodeRSs()) != null) {
                while (psDETreeNodeRSs.hasNext()) {
                    IPSDETreeNodeRS iPSDETreeNodeRS2 = psDETreeNodeRSs.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeRS2.getId(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeRS2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODERV, (boolean)false) == 0 || strModelType.indexOf("PSDETREENODERV_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 4 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDETreeNodes = (iPSDETree = (IPSDETree)psControlList2.get(0)).getPSDETreeNodes()) != null) {
                while (psDETreeNodes.hasNext()) {
                    Iterator<IPSDETreeNodeRV> psDETreeNodeRVs;
                    iPSDETreeNode2 = psDETreeNodes.next();
                    if (StringHelper.Compare((String)iPSDETreeNode2.getId(), (String)items3[2], (boolean)true) != 0 || (psDETreeNodeRVs = iPSDETreeNode2.getPSDETreeNodeRVs()) == null) continue;
                    while (psDETreeNodeRVs.hasNext()) {
                        IPSDETreeNodeRV iPSDETreeNodeRV = psDETreeNodeRVs.next();
                        if (StringHelper.Compare((String)iPSDETreeNodeRV.getId(), (String)items3[3], (boolean)true) != 0) continue;
                        list.add(iPSDETreeNodeRV);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREECOL, (boolean)false) == 0) {
            Iterator<IPSDETreeColumn> psDETreeColumn;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDETreeColumn = (iPSDETree2 = (IPSDETree)psObjectList2.get(0)).getPSDETreeColumns()) != null) {
                while (psDETreeColumn.hasNext()) {
                    IPSDETreeColumn iPSDETreeColumn = psDETreeColumn.next();
                    if (StringHelper.Compare((String)iPSDETreeColumn.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODEDATAITEM, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeDataItem> psDETreeNodeDataItems;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDETreeNodeDataItems = (iPSDETreeNode = (IPSDETreeNode)psObjectList2.get(0)).getPSDETreeNodeDataItems()) != null) {
                while (psDETreeNodeDataItems.hasNext()) {
                    IPSDETreeNodeDataItem iPSDETreeNodeDataItem = psDETreeNodeDataItems.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeDataItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODECOL, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeColumn> psDETreeNodeColumns;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDETreeNodeColumns = (iPSDETreeNode = (IPSDETreeNode)psObjectList2.get(0)).getPSDETreeNodeColumns()) != null) {
                while (psDETreeNodeColumns.hasNext()) {
                    IPSDETreeNodeColumn iPSDETreeNodeColumn = psDETreeNodeColumns.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeColumn.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODEEDITITEM, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeEditItem> psDETreeNodeEditItems;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDETreeNodeEditItems = (iPSDETreeNode = (IPSDETreeNode)psObjectList2.get(0)).getPSDETreeNodeEditItems()) != null) {
                while (psDETreeNodeEditItems.hasNext()) {
                    IPSDETreeNodeEditItem iPSDETreeNodeEditItem = psDETreeNodeEditItems.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeEditItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeEditItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCALENDARITEM, (boolean)false) == 0 || strModelType.indexOf("PSSYSCALENDARITEM_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSCALENDAR, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psSysCalendarItems = (iPSSysCalendar = (IPSSysCalendar)psControlList2.get(0)).getPSSysCalendarItems()) != null) {
                while (psSysCalendarItems.hasNext()) {
                    iPSSysCalendarItem = psSysCalendarItems.next();
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getId(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSSysCalendarItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCALENDARITEMRV, (boolean)false) == 0 || strModelType.indexOf("PSSYSCALENDARITEMRV_") == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 4 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREEVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psSysCalendarItems = (iPSSysCalendar = (IPSSysCalendar)psControlList2.get(0)).getPSSysCalendarItems()) != null) {
                while (psSysCalendarItems.hasNext()) {
                    Iterator<IPSSysCalendarItemRV> psSysCalendarItemRVs;
                    iPSSysCalendarItem = psSysCalendarItems.next();
                    if (StringHelper.Compare((String)iPSSysCalendarItem.getId(), (String)items3[2], (boolean)true) != 0 || (psSysCalendarItemRVs = iPSSysCalendarItem.getPSSysCalendarItemRVs()) == null) continue;
                    while (psSysCalendarItemRVs.hasNext()) {
                        IPSSysCalendarItemRV iPSSysCalendarItemRV = psSysCalendarItemRVs.next();
                        if (StringHelper.Compare((String)iPSSysCalendarItemRV.getId(), (String)items3[3], (boolean)true) != 0) continue;
                        list.add(iPSSysCalendarItemRV);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBARITEM, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBARFILTER, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBARGROUP, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHBARQUICKSEARCH, (boolean)false) == 0) {
            Iterator<? extends IPSSearchBarItem> psSearchBarItems;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSSEARCHBAR, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSearchBarItems = (iPSSysSearchBar = (IPSSysSearchBar)psControlList.get(0)).getPSSearchBarItems()) != null) {
                while (psSearchBarItems.hasNext()) {
                    IPSSearchBarItem iPSSearchBarItem = psSearchBarItems.next();
                    if (StringHelper.Compare((String)iPSSearchBarItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSearchBarItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDQJOIN, (boolean)false) == 0 || strModelType.indexOf("PSDEDQJOIN_") == 0) {
            Iterator<IPSDEDQJoin> psDEDQJoins;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAQUERY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDQJoins = (iPSDEDataQuery = (IPSDEDataQuery)psObjectList2.get(0)).getAllPSDEDQJoins()) != null) {
                while (psDEDQJoins.hasNext()) {
                    IPSDEDQJoin iPSDEDQJoin = psDEDQJoins.next();
                    if (StringHelper.Compare((String)iPSDEDQJoin.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEDQJoin);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDQCOND, (boolean)false) == 0 || strModelType.indexOf("PSDEDQCOND_") == 0) {
            Iterator<IPSDEDQCondition> psDEDQConds;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAQUERY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDQConds = (iPSDEDataQuery = (IPSDEDataQuery)psObjectList2.get(0)).getAllPSDEDQConditions()) != null) {
                while (psDEDQConds.hasNext()) {
                    IPSDEDQCondition iPSDEDQCond = psDEDQConds.next();
                    if (StringHelper.Compare((String)iPSDEDQCond.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEDQCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSWFLINKCOND, (boolean)false) == 0 || strModelType.indexOf("PSWFLINKCOND_") == 0) {
            IPSWFVersion iPSWFVersion2;
            Iterator<IPSWFLinkCond> psWFLinkConds;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSWFVERSION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psWFLinkConds = (iPSWFVersion2 = (IPSWFVersion)psObjectList2.get(0)).getAllPSWFLinkConds()) != null) {
                while (psWFLinkConds.hasNext()) {
                    IPSWFLinkCond iPSWFLinkCond = psWFLinkConds.next();
                    if (StringHelper.Compare((String)iPSWFLinkCond.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSWFLinkCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSVIEWMSG, (boolean)false) == 0) {
            list.add(iPSSystem.getPSViewMsg(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSVIEWMSGGROUP, (boolean)false) == 0) {
            list.add(iPSSystem.getPSViewMsgGroup(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSVIEWMSGGRPDETAIL, (boolean)false) == 0) {
            IPSViewMsgGroup iPSViewMsgGroup;
            Iterator<? extends IPSViewMsgGroupDetail> psViewMsgGroupActions;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psDEDataExpList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSVIEWMSGGROUP, items3[0])).size() > 0 && (psViewMsgGroupActions = (iPSViewMsgGroup = (IPSViewMsgGroup)psDEDataExpList.get(0)).getPSViewMsgGroupDetails()) != null) {
                while (psViewMsgGroupActions.hasNext()) {
                    IPSViewMsgGroupDetail iPSViewMsgGroupDetail = psViewMsgGroupActions.next();
                    if (StringHelper.Compare((String)iPSViewMsgGroupDetail.getId(), (String)items3[1], (boolean)false) != 0) continue;
                    list.add(iPSViewMsgGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSVALUERULE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysValueRule(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDBVF, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysDBValueFunc(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDTSQUEUE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysDTSQueue(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSOPPRIV, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSSYSUSERROLE", (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysUserRole(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUNIRES, (boolean)false) == 0) {
            list.add(iPSSystem.getPSSysUniRes(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUSERROLE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEUserRole iPSDEUserRole = iPSDataEntity.getPSDEUserRole(strModelId, true);
                if (iPSDEUserRole == null) continue;
                list.add(iPSDEUserRole);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEOPPRIVROLE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                IPSDEOPPrivRole iPSDEOPPrivRole = iPSDataEntity.getPSDEOPPrivRole(strModelId, true);
                if (iPSDEOPPrivRole == null) continue;
                list.add(iPSDEOPPrivRole);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAINSTATE, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                iPSDEMainState = iPSDataEntity.getPSDEMainState(strModelId, true);
                if (iPSDEMainState == null) continue;
                list.add(iPSDEMainState);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAINSTATERS, (boolean)false) == 0) {
            Iterator<IPSDEMainStateRS> psDEMainStateRSs;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMainStateRSs = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEMainStateRSs()) != null) {
                while (psDEMainStateRSs.hasNext()) {
                    IPSDEMainStateRS iPSDEMainStateRS = psDEMainStateRSs.next();
                    if (StringHelper.Compare((String)iPSDEMainStateRS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMainStateRS);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSACTION, (boolean)false) == 0) {
            Iterator<IPSDEMainStateAction> psDEMainStateActions;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psDEDataExpList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEMAINSTATE, items3[0])).size() > 0 && (psDEMainStateActions = (iPSDEMainState = (IPSDEMainState)psDEDataExpList.get(0)).getPSDEMainStateActions()) != null) {
                while (psDEMainStateActions.hasNext()) {
                    IPSDEMainStateAction iPSDEMainStateAction = psDEMainStateActions.next();
                    if (StringHelper.Compare((String)iPSDEMainStateAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMainStateAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSOPPRIV, (boolean)false) == 0) {
            Iterator<IPSDEMainStateOPPriv> psDEMainStateOPPrivs;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psDEDataExpList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEMAINSTATE, items3[0])).size() > 0 && (psDEMainStateOPPrivs = (iPSDEMainState = (IPSDEMainState)psDEDataExpList.get(0)).getPSDEMainStateOPPrivs()) != null) {
                while (psDEMainStateOPPrivs.hasNext()) {
                    IPSDEMainStateOPPriv iPSDEMainStateOPPriv = psDEMainStateOPPrivs.next();
                    if (StringHelper.Compare((String)iPSDEMainStateOPPriv.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMainStateOPPriv);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSFIELD, (boolean)false) == 0) {
            IPSDEMainState iPSDEMainState2;
            Iterator<IPSDEMainStateField> psDEMainStateFields;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEMAINSTATE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMainStateFields = (iPSDEMainState2 = (IPSDEMainState)psObjectList2.get(0)).getPSDEMainStateFields()) != null) {
                while (psDEMainStateFields.hasNext()) {
                    IPSDEMainStateField iPSDEMainStateField = psDEMainStateFields.next();
                    if (StringHelper.Compare((String)iPSDEMainStateField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMainStateField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFSFITEM, (boolean)false) == 0) {
            IPSDEField iPSDEField3;
            Iterator<IPSDEFSearchMode> psDEFSearchModes;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psDEDataExpList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFIELD, items3[0])).size() > 0 && (psDEFSearchModes = (iPSDEField3 = (IPSDEField)psDEDataExpList.get(0)).getAllPSDEFSearchModes()) != null) {
                while (psDEFSearchModes.hasNext()) {
                    IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
                    if (StringHelper.Compare((String)iPSDEFSearchMode.getId(), (String)items3[1], (boolean)false) != 0) continue;
                    list.add(iPSDEFSearchMode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFVALUERULE, (boolean)false) == 0) {
            Iterator<IPSDEFValueRule> psDEFValueRules;
            psDEDataExpList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFIELD, PSModels.getParentModelId(strModelId));
            if (psDEDataExpList2.size() > 0 && (psDEFValueRules = (iPSDEField = (IPSDEField)psDEDataExpList2.get(0)).getAllPSDEFValueRules()) != null) {
                while (psDEFValueRules.hasNext()) {
                    IPSDEFValueRule iPSDEFValueRule = psDEFValueRules.next();
                    if (StringHelper.Compare((String)iPSDEFValueRule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFValueRule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFVRCOND, (boolean)false) == 0) {
            IPSDEFValueRule iPSDEFValueRule;
            Iterator<IPSDEFVRCondition> psDEFVRConditions;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFVALUERULE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFVRConditions = (iPSDEFValueRule = (IPSDEFValueRule)psObjectList2.get(0)).getAllPSDEFVRConditions()) != null) {
                while (psDEFVRConditions.hasNext()) {
                    IPSDEFVRCondition iPSDEFVRCondition = psDEFVRConditions.next();
                    if (StringHelper.Compare((String)iPSDEFVRCondition.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFVRCondition);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDBCFG, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (iPSDEDBConfig = (iPSDataEntity = iPSSystem.getPSDataEntity2(items3[0])).getPSDEDBConfig(items3[1], true)) != null) {
                list.add(iPSDEDBConfig);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFDTCOL, (boolean)false) == 0) {
            IPSDEFDTColumn iPSDEFDTCol;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psObjectList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDBCFG, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (iPSDEFDTCol = (iPSDEDBConfig = (IPSDEDBConfig)psObjectList.get(0)).getPSDEFDTColumn(items3[2], true)) != null) {
                list.add(iPSDEFDTCol);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDBINDEX, (boolean)false) == 0) {
            psDataEntities = iPSSystem.getAllPSDataEntities();
            while (psDataEntities.hasNext()) {
                iPSDataEntity = psDataEntities.next();
                iPSDEDBIndex = iPSDataEntity.getPSDEDBIndex(strModelId, true);
                if (iPSDEDBIndex == null) continue;
                list.add(iPSDEDBIndex);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDBIDXFIELD, (boolean)false) == 0) {
            Iterator<IPSDEDBIndexField> psDEDBIndexFields;
            items3 = strModelId.split("[#]");
            if (items3.length == 2 && (psDEDataExpList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDBIDXFIELD, items3[0])).size() > 0 && (psDEDBIndexFields = (iPSDEDBIndex = (IPSDEDBIndex)psDEDataExpList.get(0)).getAllPSDEDBIndexFields()) != null) {
                while (psDEDBIndexFields.hasNext()) {
                    IPSDEDBIndexField iPSDEDBIndexField = psDEDBIndexFields.next();
                    if (StringHelper.Compare((String)iPSDEDBIndexField.getId(), (String)items3[1], (boolean)false) != 0) continue;
                    list.add(iPSDEDBIndexField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEWIZARD, (boolean)false) == 0) {
            Iterator<IPSDEWizard> psDEWizards;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEWizards = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEWizards()) != null) {
                while (psDEWizards.hasNext()) {
                    IPSDEWizard iPSDEWizard2 = psDEWizards.next();
                    if (StringHelper.Compare((String)iPSDEWizard2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEWizard2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEWIZARDSTEP, (boolean)false) == 0) {
            Iterator<IPSDEWizardStep> psDEWizardSteps;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEWIZARD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEWizardSteps = (iPSDEWizard = (IPSDEWizard)psObjectList2.get(0)).getPSDEWizardSteps()) != null) {
                while (psDEWizardSteps.hasNext()) {
                    IPSDEWizardStep iPSDEWizardStep = psDEWizardSteps.next();
                    if (StringHelper.Compare((String)iPSDEWizardStep.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEWizardStep);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEWIZARDFORM, (boolean)false) == 0) {
            Iterator<IPSDEWizardForm> psDEWizardForms;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEWIZARD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEWizardForms = (iPSDEWizard = (IPSDEWizard)psObjectList2.get(0)).getPSDEWizardForms()) != null) {
                while (psDEWizardForms.hasNext()) {
                    IPSDEWizardForm iPSDEWizardForm = psDEWizardForms.next();
                    if (StringHelper.Compare((String)iPSDEWizardForm.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEWizardForm);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEWIZARDLOGIC, (boolean)false) == 0) {
            Iterator<? extends IPSDEWizardLogic> psDEWizardLogics;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEWIZARD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEWizardLogics = (iPSDEWizard = (IPSDEWizard)psObjectList2.get(0)).getPSDEWizardLogics()) != null) {
                while (psDEWizardLogics.hasNext()) {
                    IPSDEWizardLogic iPSDEWizardLogic = psDEWizardLogics.next();
                    if (StringHelper.Compare((String)iPSDEWizardLogic.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEWizardLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTESTCASE, (boolean)false) == 0) {
            Iterator<IPSSysTestCase> psSysTestCases = iPSSystem.getAllPSSysTestCases();
            while (psSysTestCases.hasNext()) {
                iPSSysTestCase = psSysTestCases.next();
                if (StringHelper.Compare((String)iPSSysTestCase.getId(), (String)strModelId, (boolean)true) != 0) continue;
                list.add(iPSSysTestCase);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTESTDATA, (boolean)false) == 0) {
            Iterator<IPSSysTestData> psSysTestDatas = iPSSystem.getAllPSSysTestDatas();
            while (psSysTestDatas.hasNext()) {
                iPSSysTestData = psSysTestDatas.next();
                if (StringHelper.Compare((String)iPSSysTestData.getId(), (String)strModelId, (boolean)true) != 0) continue;
                list.add(iPSSysTestData);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELISTDATAITEM, (boolean)false) == 0) {
            Iterator<IPSListDataItem> psListDataItems;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDELIST, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psListDataItems = (iPSDEList = (IPSDEList)psControlList2.get(0)).getPSListDataItems()) != null) {
                while (psListDataItems.hasNext()) {
                    IPSListDataItem iPSDEListDataItem = psListDataItems.next();
                    if (StringHelper.Compare((String)iPSDEListDataItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEListDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATAVIEWITEM, (boolean)false) == 0) {
            Iterator<IPSDEDataViewItem> psDEDataViewItems;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEDATAVIEW, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psDEDataViewItems = (iPSDEDataView = (IPSDEDataView)psControlList.get(0)).getPSDEDataViewItems()) != null) {
                while (psDEDataViewItems.hasNext()) {
                    IPSDEDataViewItem iPSDEDataViewItem = psDEDataViewItems.next();
                    if (StringHelper.Compare((String)iPSDEDataViewItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEDataViewItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDELISTITEM, (boolean)false) == 0) {
            Iterator<IPSDEListItem> psDEListItems;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDELIST, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psDEListItems = (iPSDEList = (IPSDEList)psControlList2.get(0)).getPSDEListItems()) != null) {
                while (psDEListItems.hasNext()) {
                    IPSDEListItem iPSDEListItem = psDEListItems.next();
                    if (StringHelper.Compare((String)iPSDEListItem.getName(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSDEListItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSVIEWPANELITEM, (boolean)false) == 0 || strModelType.indexOf("PSSYSVIEWPANELITEM_") == 0) {
            items3 = strModelId.split("[#]");
            psControlList2 = null;
            String strItemName = null;
            if (items3.length == 3) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
                strItemName = items3[2];
            } else if (items3.length == 2) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
                strItemName = items3[1];
            }
            if (psControlList2 != null && psControlList2.size() > 0) {
                iPSSysPanel2 = (IPSSysPanel)psControlList2.get(0);
                psPanelItems = iPSSysPanel2.getAllPSPanelItems();
                while (psPanelItems.hasNext()) {
                    IPSPanelItem iPSPanelItem = psPanelItems.next();
                    if (StringHelper.Compare((String)iPSPanelItem.getName(), (String)strItemName, (boolean)true) != 0) continue;
                    list.add(iPSPanelItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSVIEWPANELMODEL, (boolean)false) == 0) {
            Iterator<? extends IPSPanelModel> psPanelModels;
            items3 = strModelId.split("[#]");
            psControlList2 = null;
            if (items3.length == 3) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
            } else if (items3.length == 2) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
            }
            if (psControlList2 != null && psControlList2.size() > 0 && (psPanelModels = (iPSSysPanel = (IPSSysPanel)psControlList2.get(0)).getPSPanelModels()) != null) {
                while (psPanelModels.hasNext()) {
                    IPSPanelModel iPSPanelModel = psPanelModels.next();
                    if (StringHelper.Compare((String)iPSPanelModel.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSPanelModel);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSVIEWPANELLOGIC, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            psControlList2 = null;
            if (items3.length == 3) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
            } else if (items3.length == 2) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
            }
            if (psControlList2 != null && psControlList2.size() > 0 && (psPanelLogics = (iPSSysPanel = (IPSSysPanel)psControlList2.get(0)).getPSAppViewLogics()) != null) {
                while (psPanelLogics.hasNext()) {
                    iPSPanelLogic = (IPSAppViewLogic)((Object)psPanelLogics.next());
                    if (StringHelper.Compare((String)iPSPanelLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSPanelLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSPANELLOGIC", (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            psControlList2 = null;
            if (items3.length == 3) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
            } else if (items3.length == 2) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
            }
            if (psControlList2 != null && psControlList2.size() > 0 && (psPanelLogics = (iPSSysPanel = (IPSSysPanel)psControlList2.get(0)).getPSSysPanelLogic2s()) != null) {
                while (psPanelLogics.hasNext()) {
                    iPSPanelLogic = (IPSModelObject)psPanelLogics.next();
                    if (StringHelper.Compare((String)iPSPanelLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSPanelLogic);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSPANELENGINE, (boolean)false) == 0) {
            Iterator psPanelEngines;
            items3 = strModelId.split("[#]");
            psControlList2 = null;
            if (items3.length == 3) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
            } else if (items3.length == 2) {
                psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
            }
            if (psControlList2 != null && psControlList2.size() > 0 && (psPanelEngines = (iPSSysPanel = (IPSSysPanel)psControlList2.get(0)).getPSAppViewEngines()) != null) {
                while (psPanelEngines.hasNext()) {
                    IPSAppViewEngine iPSPanelEngine = (IPSAppViewEngine)psPanelEngines.next();
                    if (StringHelper.Compare((String)iPSPanelEngine.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSPanelEngine);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSPANELENGINEPARAM, (boolean)false) == 0) {
            IPSPanelEngine iPSPanelEngine;
            Iterator psAppViewEngineParams;
            ArrayList<IPSObject> panelEngineList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSPANELENGINE, PSModels.getParentModelId(strModelId));
            if (panelEngineList.size() > 0 && (psAppViewEngineParams = (iPSPanelEngine = (IPSPanelEngine)panelEngineList.get(0)).getPSAppViewEngineParams()) != null) {
                while (psAppViewEngineParams.hasNext()) {
                    IPSAppViewEngineParam iPSAppViewEngineParam = (IPSAppViewEngineParam)psAppViewEngineParams.next();
                    if (StringHelper.Compare((String)iPSAppViewEngineParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppViewEngineParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSPANELITEMLOGIC, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            String strItemModelId = null;
            ArrayList<IPSObject> psControlList3 = null;
            if (items3.length == 4) {
                psControlList3 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, String.valueOf(items3[0]) + "#" + items3[1]);
                strItemModelId = String.valueOf(items3[0]) + "#" + items3[1] + "#" + items3[2];
            } else if (items3.length == 3) {
                psControlList3 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWLAYOUTPANEL, items3[0]);
                strItemModelId = String.valueOf(items3[0]) + "#" + items3[1];
            }
            if (psControlList3 != null && psControlList3.size() > 0 && (psPanelItems = (iPSSysPanel2 = (IPSSysPanel)psControlList3.get(0)).getAllPSPanelItems()) != null) {
                while (psPanelItems.hasNext()) {
                    Iterator<IPSPanelItemLogic> psPanelItemLogics;
                    IPSPanelItem iPSPanelItem = psPanelItems.next();
                    if (StringHelper.Compare((String)iPSPanelItem.getModelId(), (String)strItemModelId, (boolean)true) != 0 || (psPanelItemLogics = iPSPanelItem.getAllPSPanelItemLogics()) == null) continue;
                    while (psPanelItemLogics.hasNext()) {
                        IPSPanelItemLogic iPSPanelItemLogic = psPanelItemLogics.next();
                        if (StringHelper.Compare((String)iPSPanelItemLogic.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                        list.add(iPSPanelItemLogic);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSVIEWLAYOUTPANEL, (boolean)false) == 0) {
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, strModelId);
            if (appViewList.size() > 0 && (iPSAppView = (IPSAppView)appViewList.get(0)).getPSSysViewLayoutPanel() != null) {
                list.add(iPSAppView.getPSSysViewLayoutPanel());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWPARAM, (boolean)false) == 0) {
            Iterator<IPSAppViewParam> psAppViewParams;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psAppViewParams = (iPSAppView = (IPSAppView)appViewList.get(0)).getPSAppViewParams()) != null) {
                while (psAppViewParams.hasNext()) {
                    IPSAppViewParam iPSAppViewParam = psAppViewParams.next();
                    if (StringHelper.Compare((String)iPSAppViewParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppViewParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWNAVPARAM, (boolean)false) == 0) {
            Iterator<IPSAppViewNavParam> psAppViewNavParams;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psAppViewNavParams = (iPSAppView = (IPSAppView)appViewList.get(0)).getPSAppViewNavParams()) != null) {
                while (psAppViewNavParams.hasNext()) {
                    IPSAppViewNavParam iPSAppViewNavParam = psAppViewNavParams.next();
                    if (StringHelper.Compare((String)iPSAppViewNavParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppViewNavParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWNAVCONTEXT, (boolean)false) == 0) {
            Iterator<IPSAppViewNavContext> psAppViewNavContexts;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psAppViewNavContexts = (iPSAppView = (IPSAppView)appViewList.get(0)).getPSAppViewNavContexts()) != null) {
                while (psAppViewNavContexts.hasNext()) {
                    IPSAppViewNavContext iPSAppViewNavContext = psAppViewNavContexts.next();
                    if (StringHelper.Compare((String)iPSAppViewNavContext.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppViewNavContext);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWENGINE, (boolean)false) == 0) {
            items3 = strModelId.split("[#]");
            if (items3.length >= 2 && (appViewList3 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEW, items3[0])).size() > 0) {
                iPSAppView3 = (IPSAppView)appViewList3.get(0);
                Iterator<IPSAppViewEngine> psAppViewEngines = iPSAppView3.getPSAppViewEngines();
                while (psAppViewEngines.hasNext()) {
                    IPSAppViewEngine iPSAppViewEngine = psAppViewEngines.next();
                    if (StringHelper.Compare((String)iPSAppViewEngine.getName(), (String)items3[1], (boolean)true) != 0) continue;
                    list.add(iPSAppViewEngine);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWENGINEPARAM, (boolean)false) == 0) {
            IPSAppViewEngine iPSAppViewEngine;
            Iterator<? extends IPSAppViewEngineParam> psAppViewEngineParams;
            ArrayList<IPSObject> appViewEngineList;
            items3 = strModelId.split("[#]");
            if (items3.length >= 3 && (appViewEngineList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPVIEWENGINE, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psAppViewEngineParams = (iPSAppViewEngine = (IPSAppViewEngine)appViewEngineList.get(0)).getPSAppViewEngineParams()) != null) {
                while (psAppViewEngineParams.hasNext()) {
                    IPSAppViewEngineParam iPSAppViewEngineParam = psAppViewEngineParams.next();
                    if (StringHelper.Compare((String)iPSAppViewEngineParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppViewEngineParam);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSLAYOUT$") == 0) {
            layoutList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(9), strModelId);
            if (layoutList.size() > 0 && layoutList.get(0) instanceof IPSLayoutContainer) {
                list.add(((IPSLayoutContainer)((Object)layoutList.get(0))).getPSLayout());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSLAYOUTPOS$") == 0) {
            layoutList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(12), strModelId);
            if (layoutList.size() > 0 && layoutList.get(0) instanceof IPSLayoutItem) {
                list.add(((IPSLayoutItem)((Object)layoutList.get(0))).getPSLayoutPos());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCONTROLNAVPARAM, (boolean)false) == 0) {
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSCONTROL, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0) {
                iPSControl = (IPSControl)appViewList.get(0);
                Iterator<IPSControlNavParam> psControlNavParams = null;
                if (iPSControl instanceof IPSMDControl) {
                    psControlNavParams = ((IPSMDControl)iPSControl).getPSControlNavParams();
                }
                if (psControlNavParams == null && iPSControl instanceof IPSSDControl) {
                    psControlNavParams = ((IPSSDControl)iPSControl).getPSControlNavParams();
                }
                if (psControlNavParams != null) {
                    while (psControlNavParams.hasNext()) {
                        IPSControlNavParam iPSControlNavParam = psControlNavParams.next();
                        if (StringHelper.Compare((String)iPSControlNavParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                        list.add(iPSControlNavParam);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCONTROLNAVCONTEXT, (boolean)false) == 0) {
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSCONTROL, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0) {
                iPSControl = (IPSControl)appViewList.get(0);
                Iterator<IPSControlNavContext> psControlNavContexts = null;
                if (iPSControl instanceof IPSMDControl) {
                    psControlNavContexts = ((IPSMDControl)iPSControl).getPSControlNavContexts();
                }
                if (psControlNavContexts == null && iPSControl instanceof IPSSDControl) {
                    psControlNavContexts = ((IPSSDControl)iPSControl).getPSControlNavContexts();
                }
                if (psControlNavContexts != null) {
                    while (psControlNavContexts.hasNext()) {
                        IPSControlNavContext iPSControlNavContext = psControlNavContexts.next();
                        if (StringHelper.Compare((String)iPSControlNavContext.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                        list.add(iPSControlNavContext);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.equals(PSDEFDLOGIC)) {
            IPSDEFormDetail iPSDEFormDetail;
            Iterator<IPSDEFDLogic> psDEFDLogics;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEFORMDETAIL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFDLogics = (iPSDEFormDetail = (IPSDEFormDetail)psObjectList2.get(0)).getAllPSDEFDLogics()) != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDEFDLogic iPSDEFDLogic = psDEFDLogics.next();
                    if (StringHelper.Compare((String)iPSDEFDLogic.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFDLogic);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.equals(PSDEFIUPDATE)) {
            Iterator<IPSDEFormItemUpdate> psDEFormItemUpdates;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEFORM, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFormItemUpdates = (iPSDEForm = (IPSDEForm)psObjectList2.get(0)).getPSDEFormItemUpdates()) != null) {
                while (psDEFormItemUpdates.hasNext()) {
                    IPSDEFormItemUpdate iPSDEFormItemUpdate = psDEFormItemUpdates.next();
                    if (StringHelper.Compare((String)iPSDEFormItemUpdate.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFormItemUpdate);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.equals(PSDEFIUDETAIL)) {
            IPSDEFormItemUpdate iPSDEFormItemUpdate;
            Iterator<IPSDEFIUpdateDetail> psDEFIUpdateDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEFIUPDATE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFIUpdateDetails = (iPSDEFormItemUpdate = (IPSDEFormItemUpdate)psObjectList2.get(0)).getPSDEFIUpdateDetails()) != null) {
                while (psDEFIUpdateDetails.hasNext()) {
                    IPSDEFIUpdateDetail iPSDEFIUpdateDetail = psDEFIUpdateDetails.next();
                    if (StringHelper.Compare((String)iPSDEFIUpdateDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFIUpdateDetail);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSCONTROLLOGIC$") == 0) {
            Iterator<? extends IPSControlLogic> psControlLogics;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(15), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSControl && (psControlLogics = (iPSControl = (IPSControl)psObjectList2.get(0)).getAllPSControlLogics()) != null) {
                while (psControlLogics.hasNext()) {
                    IPSControlLogic iPSControlLogic = psControlLogics.next();
                    if (StringHelper.Compare((String)iPSControlLogic.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSControlLogic);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSCONTROLRENDER$") == 0) {
            Iterator<? extends IPSControlRender> psControlRenders;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(16), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSControl && (psControlRenders = (iPSControl = (IPSControl)psObjectList2.get(0)).getAllPSControlRenders()) != null) {
                while (psControlRenders.hasNext()) {
                    IPSControlRender iPSControlRender = psControlRenders.next();
                    if (StringHelper.Compare((String)iPSControlRender.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSControlRender);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSCONTROLATTRIBUTE$") == 0) {
            Iterator<? extends IPSControlAttribute> psControlAttributes;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(19), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSControl && (psControlAttributes = (iPSControl = (IPSControl)psObjectList2.get(0)).getAllPSControlAttributes()) != null) {
                while (psControlAttributes.hasNext()) {
                    IPSControlAttribute iPSControlAttribute = psControlAttributes.next();
                    if (StringHelper.Compare((String)iPSControlAttribute.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSControlAttribute);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSAPPLICATIONLOGIC$") == 0) {
            Iterator<? extends IPSApplicationLogic> psApplicationLogics;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(19), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSApplication && (psApplicationLogics = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getPSApplicationLogics()) != null) {
                while (psApplicationLogics.hasNext()) {
                    IPSApplicationLogic iPSApplicationLogic = psApplicationLogics.next();
                    if (StringHelper.Compare((String)iPSApplicationLogic.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSApplicationLogic);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.equals(PSAPPUILOGIC)) {
            Iterator<IPSAppUILogic> psAppUILogics;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppUILogics = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppUILogics()) != null) {
                while (psAppUILogics.hasNext()) {
                    iPSAppUILogic = psAppUILogics.next();
                    if (StringHelper.Compare((String)iPSAppUILogic.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppUILogic);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.equals(PSSYSVIEWLOGIC)) {
            list.add(iPSSystem.getPSSysViewLogic(strModelId));
            return list;
        }
        if (strModelType.indexOf("PSSYSVIEWLOGICPARAM$") == 0) {
            IPSViewLogic iPSViewLogic;
            Iterator<? extends IPSViewLogicParam> psViewLogicParams;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring("PSSYSVIEWLOGICPARAM$".length()), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSViewLogic && (psViewLogicParams = (iPSViewLogic = (IPSViewLogic)psObjectList2.get(0)).getPSViewLogicParams()) != null) {
                while (psViewLogicParams.hasNext()) {
                    IPSViewLogicParam iPSViewLogicParam = psViewLogicParams.next();
                    if (StringHelper.Compare((String)iPSViewLogicParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSViewLogicParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDATASYNC, (boolean)false) == 0 && strModelId.indexOf("#") != -1 && (psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId))).size() > 0 && (psDEDataSyncs = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDataSyncs()) != null) {
            while (psDEDataSyncs.hasNext()) {
                IPSDEDataSync iPSDEDataSync = psDEDataSyncs.next();
                if (StringHelper.Compare((String)iPSDEDataSync.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSDEDataSync);
                return list;
            }
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAP, (boolean)false) == 0) {
            IPSDEMap iPSDEMap2;
            Iterator<IPSDEMap> psDEMaps;
            if (strModelId.indexOf("#") != -1) {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEMaps = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEMaps()) != null) {
                    while (psDEMaps.hasNext()) {
                        iPSDEMap2 = psDEMaps.next();
                        if (StringHelper.Compare((String)iPSDEMap2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEMap2);
                        return list;
                    }
                }
            } else {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                while (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                    psDEMaps = iPSDataEntity.getAllPSDEMaps();
                    if (psDEMaps == null) continue;
                    while (psDEMaps.hasNext()) {
                        iPSDEMap2 = psDEMaps.next();
                        if (StringHelper.Compare((String)iPSDEMap2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEMap2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAPDETAIL, (boolean)false) == 0) {
            Iterator<IPSDEMapField> psDEMapDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapDetails = (iPSDEMap = (IPSDEMap)psObjectList2.get(0)).getPSDEMapDetails()) != null) {
                while (psDEMapDetails.hasNext()) {
                    IPSDEMapField iPSDEMapDetail = psDEMapDetails.next();
                    if (StringHelper.Compare((String)iPSDEMapDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMapDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAPACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapActions = (iPSDEMap = (IPSDEMap)psObjectList2.get(0)).getPSDEMapActions()) != null) {
                while (psDEMapActions.hasNext()) {
                    IPSDEMapAction iPSDEMapAction = (IPSDEMapAction)psDEMapActions.next();
                    if (StringHelper.Compare((String)iPSDEMapAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMapAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAPDS, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapDataSets = (iPSDEMap = (IPSDEMap)psObjectList2.get(0)).getPSDEMapDataSets()) != null) {
                while (psDEMapDataSets.hasNext()) {
                    IPSDEMapDataSet iPSDEMapDataSet = (IPSDEMapDataSet)psDEMapDataSets.next();
                    if (StringHelper.Compare((String)iPSDEMapDataSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMapDataSet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMAPDQ, (boolean)false) == 0) {
            Iterator<IPSDEMapDataQuery> psDEMapDataQuerys;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapDataQuerys = (iPSDEMap = (IPSDEMap)psObjectList2.get(0)).getPSDEMapDataQueries()) != null) {
                while (psDEMapDataQuerys.hasNext()) {
                    IPSDEMapDataQuery iPSDEMapDataQuery = psDEMapDataQuerys.next();
                    if (StringHelper.Compare((String)iPSDEMapDataQuery.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMapDataQuery);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRBARGROUP, (boolean)false) == 0) {
            IPSDEDRBar iPSDEDRBar;
            Iterator<IPSDEDRBarGroup> psDEDRBarGroups;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDRBAR, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRBarGroups = (iPSDEDRBar = (IPSDEDRBar)psObjectList2.get(0)).getPSDEDRBarGroups()) != null) {
                while (psDEDRBarGroups.hasNext()) {
                    IPSDEDRBarGroup iPSDEDRBarGroup = psDEDRBarGroups.next();
                    if (StringHelper.Compare((String)iPSDEDRBarGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRBarGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRBARITEM, (boolean)false) == 0) {
            IPSDEDRBarGroup iPSDEDRBarGroup;
            Iterator<IPSDEDRBarItem> psDEDRBarItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDRBARGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRBarItems = (iPSDEDRBarGroup = (IPSDEDRBarGroup)psObjectList2.get(0)).getPSDEDRBarItems()) != null) {
                while (psDEDRBarItems.hasNext()) {
                    IPSDEDRBarItem iPSDEDRBarItem = psDEDRBarItems.next();
                    if (StringHelper.Compare((String)iPSDEDRBarItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRBarItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEDRTABPAGE, (boolean)false) == 0) {
            IPSDEDRTab iPSDEDRTab;
            Iterator<IPSDEDRTabPage> psDEDRTabPages;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEDRTAB, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDRTabPages = (iPSDEDRTab = (IPSDEDRTab)psObjectList2.get(0)).getPSDEDRTabPages()) != null) {
                while (psDEDRTabPages.hasNext()) {
                    IPSDEDRTabPage iPSDEDRTabPage = psDEDRTabPages.next();
                    if (StringHelper.Compare((String)iPSDEDRTabPage.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDRTabPage);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFGROUP, (boolean)false) == 0) {
            IPSDEFGroup iPSDEFGroup;
            Iterator<IPSDEFGroup> psDEFGroups;
            if (strModelId.indexOf("#") == -1) {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                if (psDataEntities != null) {
                    while (psDataEntities.hasNext()) {
                        iPSDataEntity = psDataEntities.next();
                        psDEFGroups = iPSDataEntity.getAllPSDEFGroups();
                        if (psDEFGroups == null) continue;
                        while (psDEFGroups.hasNext()) {
                            iPSDEFGroup = psDEFGroups.next();
                            if (StringHelper.Compare((String)iPSDEFGroup.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDEFGroup);
                            return list;
                        }
                    }
                }
            } else {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEFGroups = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEFGroups()) != null) {
                    while (psDEFGroups.hasNext()) {
                        iPSDEFGroup = psDEFGroups.next();
                        if (StringHelper.Compare((String)iPSDEFGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEFGroup);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFGROUPDETAIL, (boolean)false) == 0) {
            IPSDEFGroup iPSDEFGroup;
            Iterator<IPSDEFGroupDetail> psDEFGroupDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEFGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFGroupDetails = (iPSDEFGroup = (IPSDEFGroup)psObjectList2.get(0)).getPSDEFGroupDetails()) != null) {
                while (psDEFGroupDetails.hasNext()) {
                    IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEFGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMETHODDTO, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMethodDTOs = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEMethodDTOs()) != null) {
                while (psDEMethodDTOs.hasNext()) {
                    IPSDEMethodDTO iPSDEMethodDTO = (IPSDEMethodDTO)psDEMethodDTOs.next();
                    if (StringHelper.Compare((String)iPSDEMethodDTO.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMethodDTO);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMETHODDTOFIELD, (boolean)false) == 0) {
            IPSDEMethodDTO iPSDEMethodDTO;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMETHODDTO, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMethodDTOFields = (iPSDEMethodDTO = (IPSDEMethodDTO)psObjectList2.get(0)).getPSDEMethodDTOFields()) != null) {
                while (psDEMethodDTOFields.hasNext()) {
                    IPSDEMethodDTOField iPSDEMethodDTOField = (IPSDEMethodDTOField)psDEMethodDTOFields.next();
                    if (StringHelper.Compare((String)iPSDEMethodDTOField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMethodDTOField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMETHODDTO, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMethodDTOs = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEMethodDTOs()) != null) {
                while (psDEMethodDTOs.hasNext()) {
                    IPSAppDEMethodDTO iPSAppDEMethodDTO = (IPSAppDEMethodDTO)psDEMethodDTOs.next();
                    if (StringHelper.Compare((String)iPSAppDEMethodDTO.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMethodDTO);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMETHODDTOFIELD, (boolean)false) == 0) {
            IPSAppDEMethodDTO iPSAppDEMethodDTO;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMETHODDTO, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMethodDTOFields = (iPSAppDEMethodDTO = (IPSAppDEMethodDTO)psObjectList2.get(0)).getPSAppDEMethodDTOFields()) != null) {
                while (psDEMethodDTOFields.hasNext()) {
                    IPSAppDEMethodDTOField iPSAppDEMethodDTOField = (IPSAppDEMethodDTOField)psDEMethodDTOFields.next();
                    if (StringHelper.Compare((String)iPSAppDEMethodDTOField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMethodDTOField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMETHODDTO, (boolean)false) == 0) {
            Iterator<IPSSysMethodDTO> psSysMethodDTOs = iPSSystem.getAllPSSysMethodDTOs();
            if (psSysMethodDTOs != null) {
                while (psSysMethodDTOs.hasNext()) {
                    iPSSysMethodDTO = psSysMethodDTOs.next();
                    if (StringHelper.Compare((String)iPSSysMethodDTO.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysMethodDTO);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMETHODDTOFIELD, (boolean)false) == 0) {
            Iterator<? extends IPSSysMethodDTOField> psSysMethodDTOFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSMETHODDTO, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysMethodDTOFields = (iPSSysMethodDTO = (IPSSysMethodDTO)psObjectList2.get(0)).getPSSysMethodDTOFields()) != null) {
                while (psSysMethodDTOFields.hasNext()) {
                    IPSSysMethodDTOField iPSSysMethodDTOField = psSysMethodDTOFields.next();
                    if (StringHelper.Compare((String)iPSSysMethodDTOField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysMethodDTOField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMETHODDTO, (boolean)false) == 0) {
            Iterator<IPSAppMethodDTO> psAppMethodDTOs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppMethodDTOs = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppMethodDTOs()) != null) {
                while (psAppMethodDTOs.hasNext()) {
                    IPSAppMethodDTO iPSAppMethodDTO = psAppMethodDTOs.next();
                    if (StringHelper.Compare((String)iPSAppMethodDTO.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppMethodDTO);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMETHODDTOFIELD, (boolean)false) == 0) {
            IPSAppMethodDTO iPSAppMethodDTO;
            Iterator<? extends IPSAppMethodDTOField> psAppMethodDTOFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPMETHODDTO, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppMethodDTOFields = (iPSAppMethodDTO = (IPSAppMethodDTO)psObjectList2.get(0)).getPSAppMethodDTOFields()) != null) {
                while (psAppMethodDTOFields.hasNext()) {
                    IPSAppMethodDTOField iPSAppMethodDTOField = psAppMethodDTOFields.next();
                    if (StringHelper.Compare((String)iPSAppMethodDTOField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppMethodDTOField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESERVICEAPIFIELD, (boolean)false) == 0) {
            Iterator<? extends IPSDEServiceAPIField> psDEServiceAPIFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEServiceAPIFields = (iPSDEServiceAPI = (IPSDEServiceAPI)psObjectList2.get(0)).getPSDEServiceAPIFields()) != null) {
                while (psDEServiceAPIFields.hasNext()) {
                    IPSDEServiceAPIField iPSDEServiceAPIField = psDEServiceAPIFields.next();
                    if (StringHelper.Compare((String)iPSDEServiceAPIField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEServiceAPIField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESARS, (boolean)false) == 0) {
            Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEServiceAPIRSs = (iPSSysServiceAPI = (IPSSysServiceAPI)psObjectList2.get(0)).getPSDEServiceAPIRSs()) != null) {
                while (psDEServiceAPIRSs.hasNext()) {
                    IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                    if (StringHelper.Compare((String)iPSDEServiceAPIRS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEServiceAPIRS);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDERS, (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                Iterator<IPSAppDERS> psAppDERSs = iPSApplication.getAllPSAppDERSs();
                while (psAppDERSs.hasNext()) {
                    IPSAppDERS iPSAppDERS = psAppDERSs.next();
                    if (StringHelper.Compare((String)iPSAppDERS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDERS);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSADE, (boolean)false) == 0) {
            if (strModelId.indexOf("#") != -1) {
                Iterator<IPSSubSysServiceAPIDE> psSubSysServiceAPIDEs;
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psSubSysServiceAPIDEs = (iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psObjectList2.get(0)).getAllPSSubSysServiceAPIDEs()) != null) {
                    while (psSubSysServiceAPIDEs.hasNext()) {
                        IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = psSubSysServiceAPIDEs.next();
                        if (StringHelper.Compare((String)iPSSubSysServiceAPIDE.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSSubSysServiceAPIDE);
                        return list;
                    }
                }
            } else {
                Iterator<IPSSubSysServiceAPI> psSubSysServiceAPIs = iPSSystem.getAllPSSubSysServiceAPIs();
                if (psSubSysServiceAPIs != null) {
                    while (psSubSysServiceAPIs.hasNext()) {
                        iPSSubSysServiceAPI = psSubSysServiceAPIs.next();
                        IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = iPSSubSysServiceAPI.getPSSubSysServiceAPIDE(strModelId, true);
                        if (iPSSubSysServiceAPIDE == null) continue;
                        list.add(iPSSubSysServiceAPIDE);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSADERS, (boolean)false) == 0) {
            Iterator<IPSSubSysServiceAPIDERS> psSubSysServiceAPIDERSs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSubSysServiceAPIDERSs = (iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psObjectList2.get(0)).getAllPSSubSysServiceAPIDERSs()) != null) {
                while (psSubSysServiceAPIDERSs.hasNext()) {
                    IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysServiceAPIDERSs.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIDERS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSubSysServiceAPIDERS);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSADETAIL, (boolean)false) == 0) {
            Iterator<IPSSubSysServiceAPIMethod> psSubSysServiceAPIMethods;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSubSysServiceAPIMethods = (iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psObjectList2.get(0)).getPSSubSysServiceAPIMethods()) != null) {
                while (psSubSysServiceAPIMethods.hasNext()) {
                    IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod2 = psSubSysServiceAPIMethods.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIMethod2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSubSysServiceAPIMethod2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSADEFIELD, (boolean)false) == 0) {
            IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE;
            Iterator<IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSADE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSubSysServiceAPIDEFields = (iPSSubSysServiceAPIDE = (IPSSubSysServiceAPIDE)psObjectList2.get(0)).getPSSubSysServiceAPIDEFields()) != null) {
                while (psSubSysServiceAPIDEFields.hasNext()) {
                    IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = psSubSysServiceAPIDEFields.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIDEField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSubSysServiceAPIDEField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESERVICEAPI, (boolean)false) == 0) {
            if (strModelId.indexOf("#") == -1) {
                Iterator<IPSSysServiceAPI> psSysServiceAPIs = iPSSystem.getAllPSSysServiceAPIs();
                if (psSysServiceAPIs != null) {
                    while (psSysServiceAPIs.hasNext()) {
                        iPSSysServiceAPI = psSysServiceAPIs.next();
                        IPSDEServiceAPI iPSDEServiceAPI2 = iPSSysServiceAPI.getPSDEServiceAPI(strModelId, true);
                        if (iPSDEServiceAPI2 == null) continue;
                        list.add(iPSDEServiceAPI2);
                        return list;
                    }
                }
            } else {
                Iterator<IPSDEServiceAPI> psDEServiceAPIs;
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEServiceAPIs = (iPSSysServiceAPI = (IPSSysServiceAPI)psObjectList2.get(0)).getPSDEServiceAPIs()) != null) {
                    while (psDEServiceAPIs.hasNext()) {
                        IPSDEServiceAPI iPSDEServiceAPI3 = psDEServiceAPIs.next();
                        if (StringHelper.Compare((String)iPSDEServiceAPI3.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEServiceAPI3);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESERVICEAPIMETHODINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESADETAIL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSDEServiceAPIMethod2 = (IPSDEServiceAPIMethod)psObjectList2.get(0)).getPSDEServiceAPIMethodInput() != null) {
                list.add(iPSDEServiceAPIMethod2.getPSDEServiceAPIMethodInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESERVICEAPIMETHODRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESADETAIL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSDEServiceAPIMethod2 = (IPSDEServiceAPIMethod)psObjectList2.get(0)).getPSDEServiceAPIMethodReturn() != null) {
                list.add(iPSDEServiceAPIMethod2.getPSDEServiceAPIMethodReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSERVICEAPIDTO, (boolean)false) == 0) {
            Iterator<IPSSubSysServiceAPIDTO> psSubSysServiceAPIDTOs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSubSysServiceAPIDTOs = (iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psObjectList2.get(0)).getAllPSSubSysServiceAPIDTOs()) != null) {
                while (psSubSysServiceAPIDTOs.hasNext()) {
                    IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = psSubSysServiceAPIDTOs.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIDTO.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSubSysServiceAPIDTO);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSERVICEAPIDTOFIELD, (boolean)false) == 0) {
            IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO;
            Iterator<? extends IPSSubSysServiceAPIDTOField> psSubSysServiceAPIDTOFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSERVICEAPIDTO, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSubSysServiceAPIDTOFields = (iPSSubSysServiceAPIDTO = (IPSSubSysServiceAPIDTO)psObjectList2.get(0)).getPSSubSysServiceAPIDTOFields()) != null) {
                while (psSubSysServiceAPIDTOFields.hasNext()) {
                    IPSSubSysServiceAPIDTOField iPSSubSysServiceAPIDTOField = psSubSysServiceAPIDTOFields.next();
                    if (StringHelper.Compare((String)iPSSubSysServiceAPIDTOField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSubSysServiceAPIDTOField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSERVICEAPIMETHODINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSADETAIL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSSubSysServiceAPIMethod = (IPSSubSysServiceAPIDEMethod)psObjectList2.get(0)).getPSSubSysServiceAPIMethodInput() != null) {
                list.add(iPSSubSysServiceAPIMethod.getPSSubSysServiceAPIMethodInput());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSUBSYSSERVICEAPIMETHODRETURN, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSUBSYSSADETAIL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (iPSSubSysServiceAPIMethod = (IPSSubSysServiceAPIDEMethod)psObjectList2.get(0)).getPSSubSysServiceAPIMethodReturn() != null) {
                list.add(iPSSubSysServiceAPIMethod.getPSSubSysServiceAPIMethodReturn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESADETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEServiceAPIMethods = (iPSDEServiceAPI = (IPSDEServiceAPI)psObjectList2.get(0)).getPSDEServiceAPIMethods()) != null) {
                while (psDEServiceAPIMethods.hasNext()) {
                    iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                    if (StringHelper.Compare((String)iPSDEServiceAPIMethod.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEServiceAPIMethod);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESARSDETAIL, (boolean)false) == 0) {
            IPSDEServiceAPIRS iPSDEServiceAPIRS;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESARS, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEServiceAPIMethods = (iPSDEServiceAPIRS = (IPSDEServiceAPIRS)psObjectList2.get(0)).getPSDEServiceAPIMethods()) != null) {
                while (psDEServiceAPIMethods.hasNext()) {
                    iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                    if (StringHelper.Compare((String)iPSDEServiceAPIMethod.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEServiceAPIMethod);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESAVR, (boolean)false) == 0) {
            Iterator<? extends IPSDEServiceAPIVR> psDEServiceAPIVRs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDESERVICEAPI, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEServiceAPIVRs = (iPSDEServiceAPI = (IPSDEServiceAPI)psObjectList2.get(0)).getPSDEServiceAPIVRs()) != null) {
                while (psDEServiceAPIVRs.hasNext()) {
                    IPSDEServiceAPIVR iPSDEServiceAPIVR = psDEServiceAPIVRs.next();
                    if (StringHelper.Compare((String)iPSDEServiceAPIVR.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEServiceAPIVR);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSAMPLEVALUE, (boolean)false) == 0) {
            Iterator<IPSSysSampleValue> psSysSampleValues = iPSSystem.getAllPSSysSampleValues();
            while (psSysSampleValues.hasNext()) {
                IPSSysSampleValue iPSSysSampleValue = psSysSampleValues.next();
                if (StringHelper.Compare((String)iPSSysSampleValue.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysSampleValue);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSRESOURCE, (boolean)false) == 0) {
            Iterator<IPSSysResource> psSysResources = iPSSystem.getAllPSSysResources();
            while (psSysResources.hasNext()) {
                IPSSysResource iPSSysResource = psSysResources.next();
                if (StringHelper.Compare((String)iPSSysResource.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysResource);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSPDTVIEW, (boolean)false) == 0) {
            Iterator<IPSSysPDTView> psSysPDTViews = iPSSystem.getAllPSSysPDTViews();
            while (psSysPDTViews.hasNext()) {
                IPSSysPDTView iPSSysPDTView = psSysPDTViews.next();
                if (StringHelper.Compare((String)iPSSysPDTView.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysPDTView);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEQUENCE, (boolean)false) == 0) {
            Iterator<IPSSysSequence> psSysSequences = iPSSystem.getAllPSSysSequences();
            while (psSysSequences.hasNext()) {
                IPSSysSequence iPSSysSequence = psSysSequences.next();
                if (StringHelper.Compare((String)iPSSysSequence.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysSequence);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTRANSLATOR, (boolean)false) == 0) {
            Iterator<IPSSysTranslator> psSysTranslators = iPSSystem.getAllPSSysTranslators();
            while (psSysTranslators.hasNext()) {
                IPSSysTranslator iPSSysTranslator = psSysTranslators.next();
                if (StringHelper.Compare((String)iPSSysTranslator.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysTranslator);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMSGQUEUE, (boolean)false) == 0) {
            Iterator<IPSSysMsgQueue> psSysMsgQueues = iPSSystem.getAllPSSysMsgQueues();
            while (psSysMsgQueues.hasNext()) {
                IPSSysMsgQueue iPSSysMsgQueue = psSysMsgQueues.next();
                if (StringHelper.Compare((String)iPSSysMsgQueue.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysMsgQueue);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMSGTARGET, (boolean)false) == 0) {
            Iterator<IPSSysMsgTarget> psSysMsgTargets = iPSSystem.getAllPSSysMsgTargets();
            while (psSysMsgTargets.hasNext()) {
                IPSSysMsgTarget iPSSysMsgTarget = psSysMsgTargets.next();
                if (StringHelper.Compare((String)iPSSysMsgTarget.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysMsgTarget);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCONTENTCAT, (boolean)false) == 0 && (psSysContentCats = iPSSystem.getAllPSSysContentCats2()) != null) {
            while (psSysContentCats.hasNext()) {
                iPSSysContentCat = psSysContentCats.next();
                if (StringHelper.Compare((String)iPSSysContentCat.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysContentCat);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCONTENT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSCONTENTCAT, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSSysContentCat = (IPSSysContentCat)psObjectList2.get(0);
                Iterator<IPSSysContent> psSysContents = iPSSysContentCat.getPSSysContents();
                while (psSysContents.hasNext()) {
                    IPSSysContent iPSSysContent = psSysContents.next();
                    if (StringHelper.Compare((String)iPSSysContent.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysContent);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDICTCAT, (boolean)false) == 0) {
            Iterator<IPSSysDictCat> psSysDictCats = iPSSystem.getAllPSSysDictCats();
            while (psSysDictCats.hasNext()) {
                IPSSysDictCat iPSSysDictCat = psSysDictCats.next();
                if (StringHelper.Compare((String)iPSSysDictCat.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysDictCat);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSPORTLET, (boolean)false) == 0) {
            Iterator<IPSSysPortlet> psSysPortlets = iPSSystem.getAllPSSysPortlets();
            while (psSysPortlets.hasNext()) {
                IPSSysPortlet iPSSysPortlet = psSysPortlets.next();
                if (StringHelper.Compare((String)iPSSysPortlet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysPortlet);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSPORTLETCAT, (boolean)false) == 0) {
            Iterator<IPSSysPortletCat> psSysPortletCats = iPSSystem.getAllPSSysPortletCats();
            while (psSysPortletCats.hasNext()) {
                IPSSysPortletCat iPSSysPortletCat = psSysPortletCats.next();
                if (StringHelper.Compare((String)iPSSysPortletCat.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysPortletCat);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUNIT, (boolean)false) == 0) {
            Iterator<IPSSysUnit> psSysUnits = iPSSystem.getAllPSSysUnits();
            while (psSysUnits.hasNext()) {
                IPSSysUnit iPSSysUnit = psSysUnits.next();
                if (StringHelper.Compare((String)iPSSysUnit.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysUnit);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFINPUTTIPSET, (boolean)false) == 0) {
            Iterator<IPSDEFInputTipSet> psDEFInputTipSets = iPSSystem.getAllPSDEFInputTipSets();
            while (psDEFInputTipSets.hasNext()) {
                IPSDEFInputTipSet iPSDEFInputTipSet = psDEFInputTipSets.next();
                if (StringHelper.Compare((String)iPSDEFInputTipSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSDEFInputTipSet);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBACKSERVICE, (boolean)false) == 0) {
            Iterator<IPSSysBackService> psSysBackServices = iPSSystem.getAllPSSysBackServices();
            while (psSysBackServices.hasNext()) {
                IPSSysBackService iPSSysBackService = psSysBackServices.next();
                if (StringHelper.Compare((String)iPSSysBackService.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysBackService);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDYNAMODEL, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSJSONSCHEMA", (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSOPENAPI3SCHEMA", (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSLIQUIBASECHANGELOG", (boolean)false) == 0) {
            Iterator<IPSSysDynaModel> psSysDynaModels = iPSSystem.getAllPSSysDynaModels();
            while (psSysDynaModels.hasNext()) {
                iPSSysDynaModel = psSysDynaModels.next();
                if (StringHelper.Compare((String)iPSSysDynaModel.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysDynaModel);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDYNAMODELATTR, (boolean)false) == 0) {
            Iterator psDynaModelAttrs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSDYNAMODEL, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDynaModelAttrs = (iPSSysDynaModel = (IPSSysDynaModel)psObjectList2.get(0)).getPSDynaModelAttrs()) != null) {
                while (psDynaModelAttrs.hasNext()) {
                    IPSDynaModelAttr iPSDynaModelAttr = (IPSDynaModelAttr)psDynaModelAttrs.next();
                    if (StringHelper.Compare((String)iPSDynaModelAttr.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDynaModelAttr);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSJSONNODESCHEMA$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSJsonNodeSchemas iPSJsonNodeSchemas;
                IPSJsonNodeSchemaOwner iPSJsonNodeSchemaOwner;
                IPSJsonNodeSchema iPSJsonNodeSchema;
                if (psObjectList2.get(0) instanceof IPSJsonNodeSchema && StringHelper.Compare((String)(iPSJsonNodeSchema = (IPSJsonNodeSchema)psObjectList2.get(0)).getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(psObjectList2.get(0));
                    return list;
                }
                if (psObjectList2.get(0) instanceof IPSJsonObjectSchema && (iPSJsonObjectSchema = (IPSJsonObjectSchema)psObjectList2.get(0)).getAdditionalPSJsonNodeSchema() != null && StringHelper.Compare((String)iPSJsonObjectSchema.getAdditionalPSJsonNodeSchema().getModelId(), (String)strModelId, (boolean)false) == 0) {
                    list.add(iPSJsonObjectSchema.getAdditionalPSJsonNodeSchema());
                    return list;
                }
                if (psObjectList2.get(0) instanceof IPSJsonArraySchema) {
                    IPSJsonArraySchema iPSJsonArraySchema = (IPSJsonArraySchema)psObjectList2.get(0);
                    if (iPSJsonArraySchema.getPSJsonNodeSchema() != null && StringHelper.Compare((String)iPSJsonArraySchema.getPSJsonNodeSchema().getModelId(), (String)strModelId, (boolean)false) == 0) {
                        list.add(iPSJsonArraySchema.getPSJsonNodeSchema());
                        return list;
                    }
                    items = iPSJsonArraySchema.getPrefixPSJsonNodeSchemas();
                    if (items != null) {
                        while (items.hasNext()) {
                            item = (IPSJsonNodeSchema)items.next();
                            if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(item);
                            return list;
                        }
                    }
                    if ((items = iPSJsonArraySchema.getContainsPSJsonNodeSchemas()) != null) {
                        while (items.hasNext()) {
                            item = (IPSJsonNodeSchema)items.next();
                            if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(item);
                            return list;
                        }
                    }
                }
                if (psObjectList2.get(0) instanceof IPSJsonNodeSchemaOwner && (iPSJsonNodeSchemaOwner = (IPSJsonNodeSchemaOwner)((Object)psObjectList2.get(0))).getPSJsonNodeSchema() != null) {
                    list.add(iPSJsonNodeSchemaOwner.getPSJsonNodeSchema());
                    return list;
                }
                if (psObjectList2.get(0) instanceof IPSJsonNodeSchemas && (items = (iPSJsonNodeSchemas = (IPSJsonNodeSchemas)psObjectList2.get(0)).getItems()) != null) {
                    while (items.hasNext()) {
                        item = (IPSJsonNodeSchema)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSJSONPROPERTIES$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSJsonObjectSchema && (iPSJsonObjectSchema = (IPSJsonObjectSchema)psObjectList2.get(0)).getPSJsonProperties() != null) {
                list.add(iPSJsonObjectSchema.getPSJsonProperties());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSJSONPROPERTY$") == 0) {
            IPSJsonProperties iPSJsonProperties;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSJsonProperties && (items = (iPSJsonProperties = (IPSJsonProperties)psObjectList2.get(0)).getItems()) != null) {
                while (items.hasNext()) {
                    item = (IPSJsonProperty)items.next();
                    if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(item);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSJSONDEFS$") == 0) {
            IPSJsonDefsOwner iPSJsonDefsOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSJsonDefsOwner && (iPSJsonDefsOwner = (IPSJsonDefsOwner)((Object)psObjectList2.get(0))).getPSJsonDefs() != null) {
                list.add(iPSJsonDefsOwner.getPSJsonDefs());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3INFO$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Schema && (iPSOpenAPI3Schema = (IPSOpenAPI3Schema)psObjectList2.get(0)).getPSOpenAPI3Info() != null) {
                list.add(iPSOpenAPI3Schema.getPSOpenAPI3Info());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3COMPONENTS$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Schema && (iPSOpenAPI3Schema = (IPSOpenAPI3Schema)psObjectList2.get(0)).getPSOpenAPI3Components() != null) {
                list.add(iPSOpenAPI3Schema.getPSOpenAPI3Components());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3JSONNODESCHEMAS$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Components && (iPSOpenAPI3Components = (IPSOpenAPI3Components)psObjectList2.get(0)).getPSOpenAPI3JsonNodeSchemas() != null) {
                list.add(iPSOpenAPI3Components.getPSOpenAPI3JsonNodeSchemas());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3PARAMETERS$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Components && (iPSOpenAPI3Components = (IPSOpenAPI3Components)psObjectList2.get(0)).getPSOpenAPI3Parameters() != null) {
                list.add(iPSOpenAPI3Components.getPSOpenAPI3Parameters());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3PARAMETER$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSOpenAPI3ParameterListOwner iPSOpenAPI3ParameterListOwner;
                IPSOpenAPI3Parameters iPSOpenAPI3Parameters;
                if (psObjectList2.get(0) instanceof IPSOpenAPI3Parameters && (items = (iPSOpenAPI3Parameters = (IPSOpenAPI3Parameters)psObjectList2.get(0)).getItems()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3Parameter)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
                if (psObjectList2.get(0) instanceof IPSOpenAPI3ParameterListOwner && (items = (iPSOpenAPI3ParameterListOwner = (IPSOpenAPI3ParameterListOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3Parameters()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3Parameter)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3PATHS$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Schema && (iPSOpenAPI3Schema = (IPSOpenAPI3Schema)psObjectList2.get(0)).getPSOpenAPI3Paths() != null) {
                list.add(iPSOpenAPI3Schema.getPSOpenAPI3Paths());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3PATH$") == 0) {
            IPSOpenAPI3Paths iPSOpenAPI3Paths;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Paths && (items = (iPSOpenAPI3Paths = (IPSOpenAPI3Paths)psObjectList2.get(0)).getItems()) != null) {
                while (items.hasNext()) {
                    item = (IPSOpenAPI3Path)items.next();
                    if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(item);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3OPERATION$") == 0) {
            IPSOpenAPI3OperationListOwner iPSOpenAPI3OperationListOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3OperationListOwner && (items = (iPSOpenAPI3OperationListOwner = (IPSOpenAPI3OperationListOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3Operations()) != null) {
                while (items.hasNext()) {
                    item = (IPSOpenAPI3Operation)items.next();
                    if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(item);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3SCHEMA$") == 0) {
            IPSOpenAPI3SchemaOwner iPSOpenAPI3SchemaOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3SchemaOwner && (iPSOpenAPI3SchemaOwner = (IPSOpenAPI3SchemaOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3Schema() != null) {
                list.add(iPSOpenAPI3SchemaOwner.getPSOpenAPI3Schema());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3CONTACT$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Info && (iPSOpenAPI3Info = (IPSOpenAPI3Info)psObjectList2.get(0)).getPSOpenAPI3Contact() != null) {
                list.add(iPSOpenAPI3Info.getPSOpenAPI3Contact());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3LICENSE$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3Info && (iPSOpenAPI3Info = (IPSOpenAPI3Info)psObjectList2.get(0)).getPSOpenAPI3License() != null) {
                list.add(iPSOpenAPI3Info.getPSOpenAPI3License());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3REQUESTBODY$") == 0) {
            IPSOpenAPI3RequestBodyOwner IPSOpenAPI3RequestBodyOwner2;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3RequestBodyOwner && (IPSOpenAPI3RequestBodyOwner2 = (IPSOpenAPI3RequestBodyOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3RequestBody() != null) {
                list.add(IPSOpenAPI3RequestBodyOwner2.getPSOpenAPI3RequestBody());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3MEDIATYPES$") == 0) {
            IPSOpenAPI3MediaTypesOwner iPSOpenAPI3MediaTypesOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3MediaTypesOwner && (iPSOpenAPI3MediaTypesOwner = (IPSOpenAPI3MediaTypesOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3MediaTypes() != null) {
                list.add(iPSOpenAPI3MediaTypesOwner.getPSOpenAPI3MediaTypes());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3MEDIATYPE$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSOpenAPI3MediaTypeListOwner iPSOpenAPI3MediaTypeListOwner;
                IPSOpenAPI3MediaTypes iPSOpenAPI3MediaTypes;
                if (psObjectList2.get(0) instanceof IPSOpenAPI3MediaTypes && (items = (iPSOpenAPI3MediaTypes = (IPSOpenAPI3MediaTypes)psObjectList2.get(0)).getItems()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3MediaType)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
                if (psObjectList2.get(0) instanceof IPSOpenAPI3MediaTypeListOwner && (items = (iPSOpenAPI3MediaTypeListOwner = (IPSOpenAPI3MediaTypeListOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3MediaTypes()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3MediaType)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3RESPONSES$") == 0) {
            IPSOpenAPI3ResponsesOwner iPSOpenAPI3ResponsesOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSOpenAPI3ResponsesOwner && (iPSOpenAPI3ResponsesOwner = (IPSOpenAPI3ResponsesOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3Responses() != null) {
                list.add(iPSOpenAPI3ResponsesOwner.getPSOpenAPI3Responses());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSOPENAPI3RESPONSE$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSOpenAPI3ResponseListOwner iPSOpenAPI3ResponseListOwner;
                IPSOpenAPI3Responses iPSOpenAPI3Responses;
                if (psObjectList2.get(0) instanceof IPSOpenAPI3Responses && (items = (iPSOpenAPI3Responses = (IPSOpenAPI3Responses)psObjectList2.get(0)).getItems()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3Response)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
                if (psObjectList2.get(0) instanceof IPSOpenAPI3ResponseListOwner && (items = (iPSOpenAPI3ResponseListOwner = (IPSOpenAPI3ResponseListOwner)((Object)psObjectList2.get(0))).getPSOpenAPI3Responses()) != null) {
                    while (items.hasNext()) {
                        item = (IPSOpenAPI3Response)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECHANGELOG$") == 0) {
            IPSLiquibaseChangeLogOwner iPSLiquibaseChangeLogOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseChangeLogOwner && (iPSLiquibaseChangeLogOwner = (IPSLiquibaseChangeLogOwner)((Object)psObjectList2.get(0))).getPSLiquibaseChangeLog() != null) {
                list.add(iPSLiquibaseChangeLogOwner.getPSLiquibaseChangeLog());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECHANGESETS$") == 0) {
            IPSLiquibaseChangeSetsOwner iPSLiquibaseChangeSetsOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseChangeSetsOwner && (iPSLiquibaseChangeSetsOwner = (IPSLiquibaseChangeSetsOwner)((Object)psObjectList2.get(0))).getPSLiquibaseChangeSets() != null) {
                list.add(iPSLiquibaseChangeSetsOwner.getPSLiquibaseChangeSets());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECHANGESET$") == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                IPSLiquibaseChangeSets iPSLiquibaseChangeSets;
                IPSLiquibaseChangeSetListOwner iPSLiquibaseChangeSetListOwner;
                if (psObjectList2.get(0) instanceof IPSLiquibaseChangeSetListOwner && (items = (iPSLiquibaseChangeSetListOwner = (IPSLiquibaseChangeSetListOwner)((Object)psObjectList2.get(0))).getPSLiquibaseChangeSets()) != null) {
                    while (items.hasNext()) {
                        item = (IPSLiquibaseChangeSet)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
                if (psObjectList2.get(0) instanceof IPSLiquibaseChangeSets && (items = (iPSLiquibaseChangeSets = (IPSLiquibaseChangeSets)psObjectList2.get(0)).getItems()) != null) {
                    while (items.hasNext()) {
                        item = (IPSLiquibaseChangeSet)items.next();
                        if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(item);
                        return list;
                    }
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASEACTIONS$") == 0) {
            IPSLiquibaseActionsOwner iPSLiquibaseActionsOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseActionsOwner && (iPSLiquibaseActionsOwner = (IPSLiquibaseActionsOwner)((Object)psObjectList2.get(0))).getPSLiquibaseActions() != null) {
                list.add(iPSLiquibaseActionsOwner.getPSLiquibaseActions());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASEACTION$") == 0 || strModelType.indexOf("PSLIQUIBASECREATETABLE$") == 0) {
            IPSLiquibaseActions iPSLiquibaseActions;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseActions && (items = (iPSLiquibaseActions = (IPSLiquibaseActions)psObjectList2.get(0)).getItems()) != null) {
                while (items.hasNext()) {
                    item = (IPSLiquibaseAction)items.next();
                    if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(item);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECOLUMNS$") == 0) {
            IPSLiquibaseColumnsOwner iPSLiquibaseColumnsOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseColumnsOwner && (iPSLiquibaseColumnsOwner = (IPSLiquibaseColumnsOwner)((Object)psObjectList2.get(0))).getPSLiquibaseColumns() != null) {
                list.add(iPSLiquibaseColumnsOwner.getPSLiquibaseColumns());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECOLUMN$") == 0) {
            IPSLiquibaseColumns iPSLiquibaseColumns;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseColumns && (items = (iPSLiquibaseColumns = (IPSLiquibaseColumns)psObjectList2.get(0)).getItems()) != null) {
                while (items.hasNext()) {
                    item = (IPSLiquibaseColumn)items.next();
                    if (StringHelper.Compare((String)item.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(item);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSLIQUIBASECONSTRAINTS$") == 0) {
            IPSLiquibaseConstraintsOwner iPSLiquibaseConstraintsOwner;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSLiquibaseConstraintsOwner && (iPSLiquibaseConstraintsOwner = (IPSLiquibaseConstraintsOwner)((Object)psObjectList2.get(0))).getPSLiquibaseConstraints() != null) {
                list.add(iPSLiquibaseConstraintsOwner.getPSLiquibaseConstraints());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMETHOD, (boolean)false) == 0) {
            Iterator<? extends IPSAppDEMethod> psAppDEMethods;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEMethods = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEMethods()) != null) {
                while (psAppDEMethods.hasNext()) {
                    IPSAppDEMethod iPSAppDEMethod2 = psAppDEMethods.next();
                    if (StringHelper.Compare((String)iPSAppDEMethod2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMethod2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEFIELD, (boolean)false) == 0) {
            Iterator<? extends IPSAppDEField> psAppDEFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEFields = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEFields()) != null) {
                while (psAppDEFields.hasNext()) {
                    IPSAppDEField iPSAppDEField2 = psAppDEFields.next();
                    if (StringHelper.Compare((String)iPSAppDEField2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEField2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUIACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUIActions = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEUIActions()) != null) {
                while (psAppDEUIActions.hasNext()) {
                    iPSAppDEUIAction = psAppDEUIActions.next();
                    if (StringHelper.Compare((String)iPSAppDEUIAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUIAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSAPPDEUIACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUIActions = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppDEUIActions()) != null) {
                while (psAppDEUIActions.hasNext()) {
                    iPSAppDEUIAction = psAppDEUIActions.next();
                    if (StringHelper.Compare((String)iPSAppDEUIAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUIAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUAGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUIActionGroups = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEUIActionGroups()) != null) {
                while (psAppDEUIActionGroups.hasNext()) {
                    iPSAppDEUIActionGroup2 = psAppDEUIActionGroups.next();
                    if (StringHelper.Compare((String)iPSAppDEUIActionGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUIActionGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSAPPDEUAGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUIActionGroups = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppDEUIActionGroups()) != null) {
                while (psAppDEUIActionGroups.hasNext()) {
                    iPSAppDEUIActionGroup2 = psAppDEUIActionGroups.next();
                    if (StringHelper.Compare((String)iPSAppDEUIActionGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUIActionGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDEGROUP, (boolean)false) == 0) {
            psDEGroups = iPSSystem.getAllPSDEGroups();
            if (psDEGroups != null) {
                while (psDEGroups.hasNext()) {
                    iPSDEGroup = psDEGroups.next();
                    if (StringHelper.Compare((String)iPSDEGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGROUP, (boolean)false) == 0) {
            IPSDEGroup iPSDEGroup2;
            Iterator<IPSDEGroup> psDEGroups2;
            if (strModelId.indexOf("#") == -1) {
                psDEGroups = iPSSystem.getAllPSDEGroups();
                if (psDEGroups != null) {
                    while (psDEGroups.hasNext()) {
                        iPSDEGroup = psDEGroups.next();
                        if (StringHelper.Compare((String)iPSDEGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEGroup);
                        return list;
                    }
                }
                if ((psDataEntities = iPSSystem.getAllPSDataEntities()) != null) {
                    while (psDataEntities.hasNext()) {
                        iPSDataEntity = psDataEntities.next();
                        psDEGroups2 = iPSDataEntity.getAllPSDEGroups();
                        if (psDEGroups2 == null) continue;
                        while (psDEGroups2.hasNext()) {
                            iPSDEGroup2 = psDEGroups2.next();
                            if (StringHelper.Compare((String)iPSDEGroup2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDEGroup2);
                            return list;
                        }
                    }
                }
            } else {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEGroups2 = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEGroups()) != null) {
                    while (psDEGroups2.hasNext()) {
                        iPSDEGroup2 = psDEGroups2.next();
                        if (StringHelper.Compare((String)iPSDEGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEGroup2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEGROUPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEGroupDetails = (iPSDEGroup = (IPSDEGroup)psObjectList2.get(0)).getPSDEGroupDetails()) != null) {
                while (psDEGroupDetails.hasNext()) {
                    iPSDEGroupDetail = psDEGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDEGROUPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSDEGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEGroupDetails = (iPSDEGroup = (IPSDEGroup)psObjectList2.get(0)).getPSDEGroupDetails()) != null) {
                while (psDEGroupDetails.hasNext()) {
                    iPSDEGroupDetail = psDEGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSDERGROUP", (boolean)false) == 0) {
            Iterator<IPSSysDERGroup> psDERGroups = iPSSystem.getAllPSDERGroups();
            if (psDERGroups != null) {
                while (psDERGroups.hasNext()) {
                    iPSDERGroup = psDERGroups.next();
                    if (StringHelper.Compare((String)iPSDERGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDERGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDERGROUP, (boolean)false) == 0) {
            IPSDERGroup iPSDERGroup2;
            Iterator<IPSDERGroup> psDERGroups;
            if (strModelId.indexOf("#") == -1) {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                if (psDataEntities != null) {
                    while (psDataEntities.hasNext()) {
                        iPSDataEntity = psDataEntities.next();
                        psDERGroups = iPSDataEntity.getAllPSDERGroups();
                        if (psDERGroups == null) continue;
                        while (psDERGroups.hasNext()) {
                            iPSDERGroup2 = psDERGroups.next();
                            if (StringHelper.Compare((String)iPSDERGroup2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDERGroup2);
                            return list;
                        }
                    }
                }
            } else {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDERGroups = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDERGroups()) != null) {
                    while (psDERGroups.hasNext()) {
                        iPSDERGroup2 = psDERGroups.next();
                        if (StringHelper.Compare((String)iPSDERGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDERGroup2);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDERGROUPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDERGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDERGroupDetails = (iPSDERGroup = (IPSDERGroup)psObjectList2.get(0)).getPSDERGroupDetails()) != null) {
                while (psDERGroupDetails.hasNext()) {
                    iPSDERGroupDetail = psDERGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDERGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDERGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSDERGROUPDETAIL", (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSDERGROUP", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDERGroupDetails = (iPSDERGroup = (IPSDERGroup)psObjectList2.get(0)).getPSDERGroupDetails()) != null) {
                while (psDERGroupDetails.hasNext()) {
                    iPSDERGroupDetail = psDERGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDERGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDERGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONGROUP, (boolean)false) == 0) {
            IPSDEActionGroup iPSDEActionGroup;
            Iterator<IPSDEActionGroup> psDEActionGroups;
            if (strModelId.indexOf("#") == -1) {
                psDataEntities = iPSSystem.getAllPSDataEntities();
                if (psDataEntities != null) {
                    while (psDataEntities.hasNext()) {
                        iPSDataEntity = psDataEntities.next();
                        psDEActionGroups = iPSDataEntity.getAllPSDEActionGroups();
                        while (psDEActionGroups.hasNext()) {
                            iPSDEActionGroup = psDEActionGroups.next();
                            if (StringHelper.Compare((String)iPSDEActionGroup.getId(), (String)strModelId, (boolean)false) != 0) continue;
                            list.add(iPSDEActionGroup);
                            return list;
                        }
                    }
                }
            } else {
                psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
                if (psObjectList2.size() > 0 && (psDEActionGroups = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEActionGroups()) != null) {
                    while (psDEActionGroups.hasNext()) {
                        iPSDEActionGroup = psDEActionGroups.next();
                        if (StringHelper.Compare((String)iPSDEActionGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                        list.add(iPSDEActionGroup);
                        return list;
                    }
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEAGDETAIL, (boolean)false) == 0) {
            IPSDEActionGroup iPSDEActionGroup;
            Iterator<IPSDEActionGroupDetail> psDEActionGroupDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEACTIONGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEActionGroupDetails = (iPSDEActionGroup = (IPSDEActionGroup)psObjectList2.get(0)).getPSDEActionGroupDetails()) != null) {
                while (psDEActionGroupDetails.hasNext()) {
                    IPSDEActionGroupDetail iPSDEActionGroupDetail = psDEActionGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEActionGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEActionGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSHELPPRJ, (boolean)false) == 0) {
            list.add(iPSSystem.getPSHelpPrj(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSHELPARTICLE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSHelpArticle(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSHELPRESOURCE, (boolean)false) == 0) {
            list.add(iPSSystem.getPSHelpArticle(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSHELPMODULE, (boolean)false) == 0) {
            IPSHelpPrj iPSHelpPrj;
            Iterator<IPSHelpModule> psHelpModules;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSHELPPRJ, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psHelpModules = (iPSHelpPrj = (IPSHelpPrj)psObjectList2.get(0)).getAllPSHelpModules()) != null) {
                while (psHelpModules.hasNext()) {
                    IPSHelpModule iPSHelpModule = psHelpModules.next();
                    if (StringHelper.Compare((String)iPSHelpModule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSHelpModule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSHELPSECTION, (boolean)false) == 0) {
            IPSHelpArticle iPSHelpArticle;
            Iterator<IPSHelpSection> psHelpSections;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSHELPARTICLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psHelpSections = (iPSHelpArticle = (IPSHelpArticle)psObjectList2.get(0)).getAllPSHelpSections()) != null) {
                while (psHelpSections.hasNext()) {
                    IPSHelpSection iPSHelpSection = psHelpSections.next();
                    if (StringHelper.Compare((String)iPSHelpSection.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSHelpSection);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUAGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUAGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUIActionGroupDetails = (iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)psObjectList2.get(0)).getPSDEUIActionGroupDetails()) != null) {
                while (psDEUIActionGroupDetails.hasNext()) {
                    iPSDEUIActionGroupDetail = psDEUIActionGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEUIActionGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUIActionGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSAPPDEUAGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPPDEUAGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUIActionGroupDetails = (iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)psObjectList2.get(0)).getPSDEUIActionGroupDetails()) != null) {
                while (psDEUIActionGroupDetails.hasNext()) {
                    iPSDEUIActionGroupDetail = psDEUIActionGroupDetails.next();
                    if (StringHelper.Compare((String)iPSDEUIActionGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUIActionGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSACTOR, (boolean)false) == 0) {
            Iterator<IPSSysActor> psSysActors = iPSSystem.getAllPSSysActors();
            while (psSysActors.hasNext()) {
                IPSSysActor iPSSysActor = psSysActors.next();
                if (StringHelper.Compare((String)iPSSysActor.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysActor);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERCASE, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSSYSUSECASE", (boolean)false) == 0) {
            Iterator<IPSSysUseCase> psSysUseCases = iPSSystem.getAllPSSysUseCases();
            while (psSysUseCases.hasNext()) {
                IPSSysUseCase iPSSysUseCase = psSysUseCases.next();
                if (StringHelper.Compare((String)iPSSysUseCase.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysUseCase);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERCASERS, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)"PSSYSUSECASERS", (boolean)false) == 0) {
            Iterator<IPSSysUseCaseRS> psSysUseCaseRSs = iPSSystem.getAllPSSysUseCaseRSs();
            while (psSysUseCaseRSs.hasNext()) {
                IPSSysUseCaseRS iPSSysUseCaseRS = psSysUseCaseRSs.next();
                if (StringHelper.Compare((String)iPSSysUseCaseRS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysUseCaseRS);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTESTPRJ, (boolean)false) == 0) {
            Iterator<IPSSysTestPrj> psSysTestPrjs = iPSSystem.getAllPSSysTestPrjs();
            while (psSysTestPrjs.hasNext()) {
                iPSSysTestPrj = psSysTestPrjs.next();
                if (StringHelper.Compare((String)iPSSysTestPrj.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                list.add(iPSSysTestPrj);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTESTMODULE, (boolean)false) == 0) {
            Iterator<IPSSysTestModule> psSysTestModules;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTPRJ, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestModules = (iPSSysTestPrj = (IPSSysTestPrj)psObjectList2.get(0)).getPSSysTestModules()) != null) {
                while (psSysTestModules.hasNext()) {
                    IPSSysTestModule iPSSysTestModule = psSysTestModules.next();
                    if (StringHelper.Compare((String)iPSSysTestModule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestModule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTESTCASE2, (boolean)false) == 0) {
            IPSSysTestModule iPSSysTestModule;
            Iterator<IPSSysTestCase> psSysTestCases;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTMODULE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestCases = (iPSSysTestModule = (IPSSysTestModule)psObjectList2.get(0)).getPSSysTestCases()) != null) {
                while (psSysTestCases.hasNext()) {
                    IPSSysTestCase iPSSysTestCase2 = psSysTestCases.next();
                    if (StringHelper.Compare((String)iPSSysTestCase2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestCase2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSREQMODULE, (boolean)false) == 0) {
            Iterator<IPSSysReqModule> psSysReqModules = iPSSystem.getAllPSSysReqModules2();
            if (psSysReqModules != null) {
                while (psSysReqModules.hasNext()) {
                    IPSSysReqModule iPSSysReqModule = psSysReqModules.next();
                    if (StringHelper.Compare((String)iPSSysReqModule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysReqModule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSREQITEM, (boolean)false) == 0 && (psSysReqItems = iPSSystem.getAllPSSysReqItems()) != null) {
            while (psSysReqItems.hasNext()) {
                IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
                if (StringHelper.Compare((String)iPSSysReqItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                list.add(iPSSysReqItem);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDERNN, (boolean)false) == 0) {
            IPSDataEntity iPSDataEntity5 = iPSSystem.getPSDataEntity(strModelId);
            if (iPSDataEntity5 != null && iPSDataEntity5.getPSDERNN() != null) {
                list.add(iPSDataEntity5.getPSDERNN());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTCINPUT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTCASE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestCaseInputs = (iPSSysTestCase = (IPSSysTestCase)psObjectList2.get(0)).getPSSysTestCaseInputs()) != null) {
                while (psSysTestCaseInputs.hasNext()) {
                    iPSSysTestCaseInput = psSysTestCaseInputs.next();
                    if (StringHelper.Compare((String)iPSSysTestCaseInput.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestCaseInput);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTCINPUT2, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTCASE2, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestCaseInputs = (iPSSysTestCase = (IPSSysTestCase)psObjectList2.get(0)).getPSSysTestCaseInputs()) != null) {
                while (psSysTestCaseInputs.hasNext()) {
                    iPSSysTestCaseInput = psSysTestCaseInputs.next();
                    if (StringHelper.Compare((String)iPSSysTestCaseInput.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestCaseInput);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTCASSERT, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTCASE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestCaseAsserts = (iPSSysTestCase = (IPSSysTestCase)psObjectList2.get(0)).getPSSysTestCaseAsserts()) != null) {
                while (psSysTestCaseAsserts.hasNext()) {
                    iPSSysTestCaseAssert = psSysTestCaseAsserts.next();
                    if (StringHelper.Compare((String)iPSSysTestCaseAssert.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestCaseAssert);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTCASSERT2, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSTESTCASE2, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysTestCaseAsserts = (iPSSysTestCase = (IPSSysTestCase)psObjectList2.get(0)).getPSSysTestCaseAsserts()) != null) {
                while (psSysTestCaseAsserts.hasNext()) {
                    iPSSysTestCaseAssert = psSysTestCaseAsserts.next();
                    if (StringHelper.Compare((String)iPSSysTestCaseAssert.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysTestCaseAssert);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSAHANDLER, (boolean)false) == 0) {
            IPSSysServiceAPIHandler iPSSysServiceAPIHandler = iPSSystem.getPSSysServiceAPIHandler(strModelId, true);
            if (iPSSysServiceAPIHandler != null) {
                list.add(iPSSysServiceAPIHandler);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETABLE, (boolean)false) == 0) {
            Iterator<IPSDEDBTable> psDEDBTables;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDBTables = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEDBTables()) != null) {
                while (psDEDBTables.hasNext()) {
                    IPSDEDBTable iPSDEDBTable = psDEDBTables.next();
                    if (StringHelper.Compare((String)iPSDEDBTable.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDBTable);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDBSCHEME, (boolean)false) == 0) {
            IPSSysDBScheme iPSSysDBScheme = iPSSystem.getPSSysDBScheme(strModelId, true);
            if (iPSSysDBScheme != null) {
                list.add(iPSSysDBScheme);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDBTABLE, (boolean)false) == 0) {
            IPSSysDBScheme iPSSysDBScheme;
            Iterator<IPSSysDBTable> psSysDBTables;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSDBSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysDBTables = (iPSSysDBScheme = (IPSSysDBScheme)psObjectList2.get(0)).getAllPSSysDBTables()) != null) {
                while (psSysDBTables.hasNext()) {
                    IPSSysDBTable iPSSysDBTable2 = psSysDBTables.next();
                    if (StringHelper.Compare((String)iPSSysDBTable2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysDBTable2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDBCOLUMN, (boolean)false) == 0) {
            Iterator<IPSSysDBColumn> psSysDBColumns;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSDBTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysDBColumns = (iPSSysDBTable = (IPSSysDBTable)psObjectList2.get(0)).getAllPSSysDBColumns()) != null) {
                while (psSysDBColumns.hasNext()) {
                    IPSSysDBColumn iPSSysDBColumn = psSysDBColumns.next();
                    if (StringHelper.Compare((String)iPSSysDBColumn.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysDBColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSDBINDEX", (boolean)false) == 0) {
            Iterator<IPSSysDBIndex> psSysDBIndexs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSDBTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysDBIndexs = (iPSSysDBTable = (IPSSysDBTable)psObjectList2.get(0)).getAllPSSysDBIndices()) != null) {
                while (psSysDBIndexs.hasNext()) {
                    IPSSysDBIndex iPSSysDBIndex = psSysDBIndexs.next();
                    if (StringHelper.Compare((String)iPSSysDBIndex.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysDBIndex);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSDBINDEXCOLUMN", (boolean)false) == 0) {
            IPSSysDBIndex iPSSysDBIndex;
            Iterator<IPSSysDBIndexColumn> psSysDBIndexColumns;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSDBINDEX", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysDBIndexColumns = (iPSSysDBIndex = (IPSSysDBIndex)psObjectList2.get(0)).getAllPSSysDBIndexColumns()) != null) {
                while (psSysDBIndexColumns.hasNext()) {
                    IPSSysDBIndexColumn iPSSysDBIndexColumn = psSysDBIndexColumns.next();
                    if (StringHelper.Compare((String)iPSSysDBIndexColumn.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysDBIndexColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUTILDE, (boolean)false) == 0) {
            IPSSysUtil iPSSysUtil = iPSSystem.getPSSysUtil(strModelId, true);
            if (iPSSysUtil != null) {
                list.add(iPSSysUtil);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEUTILDE, (boolean)false) == 0) {
            Iterator<IPSDEUtil> psDEUtils;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUtils = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEUtils()) != null) {
                while (psDEUtils.hasNext()) {
                    IPSDEUtil iPSDEUtil = psDEUtils.next();
                    if (StringHelper.Compare((String)iPSDEUtil.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUtil);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSDEOPPRIV, (boolean)false) == 0) {
            list.add(iPSSystem.getPSDEOPPriv(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEOPPRIV, (boolean)false) == 0) {
            Iterator<IPSDEOPPriv> psDEOPPrivs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEOPPrivs = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEOPPrivs()) != null) {
                while (psDEOPPrivs.hasNext()) {
                    IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                    if (StringHelper.Compare((String)iPSDEOPPriv.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEOPPriv);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVALUERULE, (boolean)false) == 0) {
            Iterator<IPSAppValueRule> psAppValueRules;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppValueRules = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppValueRules()) != null) {
                while (psAppValueRules.hasNext()) {
                    IPSAppValueRule iPSAppValueRule = psAppValueRules.next();
                    if (StringHelper.Compare((String)iPSAppValueRule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppValueRule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPCOUNTER, (boolean)false) == 0) {
            Iterator<IPSAppCounter> psAppCounters;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppCounters = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppCounters()) != null) {
                while (psAppCounters.hasNext()) {
                    IPSAppCounter iPSAppCounter = psAppCounters.next();
                    if (StringHelper.Compare((String)iPSAppCounter.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppCounter);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPPORTLETCAT, (boolean)false) == 0) {
            Iterator<IPSAppPortletCat> psAppPortletCats;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppPortletCats = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppPortletCats()) != null) {
                while (psAppPortletCats.hasNext()) {
                    IPSAppPortletCat iPSAppPortletCat = psAppPortletCats.next();
                    if (StringHelper.Compare((String)iPSAppPortletCat.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppPortletCat);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPCODELIST, (boolean)false) == 0) {
            Iterator<IPSAppCodeList> psAppCodeLists;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppCodeLists = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppCodeLists()) != null) {
                while (psAppCodeLists.hasNext()) {
                    IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
                    if (StringHelper.Compare((String)iPSAppCodeList.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppCodeList);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPDEFINPUTTIPSET", (boolean)false) == 0) {
            Iterator<IPSAppDEFInputTipSet> psAppDEFInputTipSets;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEFInputTipSets = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppDEFInputTipSets()) != null) {
                while (psAppDEFInputTipSets.hasNext()) {
                    IPSAppDEFInputTipSet iPSAppDEFInputTipSet = psAppDEFInputTipSets.next();
                    if (StringHelper.Compare((String)iPSAppDEFInputTipSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEFInputTipSet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPMSGTEMPL, (boolean)false) == 0) {
            Iterator<IPSAppMsgTempl> psAppMsgTempls;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppMsgTempls = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppMsgTempls()) != null) {
                while (psAppMsgTempls.hasNext()) {
                    IPSAppMsgTempl iPSAppMsgTempl = psAppMsgTempls.next();
                    if (StringHelper.Compare((String)iPSAppMsgTempl.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppMsgTempl);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFUTILUIACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWF, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0) {
                iPSAppWF = (IPSAppWF)psObjectList2.get(0);
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWMSG, (boolean)false) == 0) {
            Iterator<? extends IPSAppViewMsg> psAppViewMsgs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppViewMsgs = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppViewMsgs()) != null) {
                while (psAppViewMsgs.hasNext()) {
                    IPSAppViewMsg iPSAppViewMsg = psAppViewMsgs.next();
                    if (StringHelper.Compare((String)iPSAppViewMsg.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppViewMsg);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWMSGGROUP, (boolean)false) == 0) {
            Iterator<? extends IPSAppViewMsgGroup> psAppViewMsgGroups;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppViewMsgGroups = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppViewMsgGroups()) != null) {
                while (psAppViewMsgGroups.hasNext()) {
                    IPSAppViewMsgGroup iPSAppViewMsgGroup = psAppViewMsgGroups.next();
                    if (StringHelper.Compare((String)iPSAppViewMsgGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppViewMsgGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPVIEWMSGGRPDETAIL, (boolean)false) == 0) {
            IPSAppViewMsgGroup iPSAppViewMsgGroup;
            Iterator<? extends IPSAppViewMsgGroupDetail> psAppViewMsgGroupDetails;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPVIEWMSGGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppViewMsgGroupDetails = (iPSAppViewMsgGroup = (IPSAppViewMsgGroup)psObjectList2.get(0)).getPSAppViewMsgGroupDetails()) != null) {
                while (psAppViewMsgGroupDetails.hasNext()) {
                    IPSAppViewMsgGroupDetail iPSAppViewMsgGroupDetail = psAppViewMsgGroupDetails.next();
                    if (StringHelper.Compare((String)iPSAppViewMsgGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppViewMsgGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELOGIC, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSAPPDEFLOGIC, (boolean)false) == 0) {
            Iterator<IPSAppDELogic> psAppDELogics;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDELogics = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDELogics()) != null) {
                while (psAppDELogics.hasNext()) {
                    IPSAppDELogic iPSAppDELogic2 = psAppDELogics.next();
                    if (StringHelper.Compare((String)iPSAppDELogic2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDELogic2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELOGICNODE, (boolean)false) == 0) {
            Iterator<? extends IPSDELogicNode> psDELogicNodes2;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDELOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDELogicNodes2 = (iPSAppDELogic = (IPSAppDELogic)psObjectList2.get(0)).getPSDELogicNodes()) != null) {
                while (psDELogicNodes2.hasNext()) {
                    IPSDELogicNode iPSDELogicNode = psDELogicNodes2.next();
                    if (StringHelper.Compare((String)iPSDELogicNode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogicNode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELOGICPARAM, (boolean)false) == 0) {
            Iterator<? extends IPSDELogicParam> psDELogicParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDELOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDELogicParams = (iPSAppDELogic = (IPSAppDELogic)psObjectList2.get(0)).getPSDELogicParams()) != null) {
                while (psDELogicParams.hasNext()) {
                    IPSDELogicParam iPSDELogicParam = psDELogicParams.next();
                    if (StringHelper.Compare((String)iPSDELogicParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogicParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELOGICLINK, (boolean)false) == 0) {
            Iterator<? extends IPSDELogicLink> psDELogicLinks2;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDELOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDELogicLinks2 = (iPSAppDELogic = (IPSAppDELogic)psObjectList2.get(0)).getPSDELogicLinks()) != null) {
                while (psDELogicLinks2.hasNext()) {
                    IPSDELogicLink iPSDELogicLink = psDELogicLinks2.next();
                    if (StringHelper.Compare((String)iPSDELogicLink.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogicLink);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELLCOND, (boolean)false) == 0) {
            IPSAppDELogicLink iPSAppDELogicLink;
            Iterator<? extends IPSDELogicLinkCond> psDELogicLinkConds;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDELOGICLINK, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDELogicLinkConds = (iPSAppDELogicLink = (IPSAppDELogicLink)psObjectList2.get(0)).getAllPSDELogicLinkConds()) != null) {
                while (psDELogicLinkConds.hasNext()) {
                    IPSDELogicLinkCond iPSDELogicLinkCond = psDELogicLinkConds.next();
                    if (StringHelper.Compare((String)iPSDELogicLinkCond.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogicLinkCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDELNPARAM, (boolean)false) == 0) {
            IPSAppDELogicNode iPSAppDELogicNode;
            Iterator<IPSDELogicNodeParam> psDELogicNodeParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDELOGICNODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDELogicNodeParams = (iPSAppDELogicNode = (IPSAppDELogicNode)psObjectList2.get(0)).getPSDELogicNodeParams()) != null) {
                while (psDELogicNodeParams.hasNext()) {
                    IPSDELogicNodeParam iPSDELogicNodeParam = psDELogicNodeParams.next();
                    if (StringHelper.Compare((String)iPSDELogicNodeParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDELogicNodeParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERROLERES, (boolean)false) == 0) {
            Iterator<IPSSysUserRoleRes> psSysUserRoleReses;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSOPPRIV, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysUserRoleReses = (iPSSysUserRole = (IPSSysUserRole)psObjectList2.get(0)).getPSSysUserRoleReses()) != null) {
                while (psSysUserRoleReses.hasNext()) {
                    IPSSysUserRoleRes iPSSysUserRoleRes = psSysUserRoleReses.next();
                    if (StringHelper.Compare((String)iPSSysUserRoleRes.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysUserRoleRes);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSUSERROLEDATA, (boolean)false) == 0) {
            Iterator<IPSSysUserRoleData> psSysUserRoleDatas;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSOPPRIV, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysUserRoleDatas = (iPSSysUserRole = (IPSSysUserRole)psObjectList2.get(0)).getPSSysUserRoleDatas()) != null) {
                while (psSysUserRoleDatas.hasNext()) {
                    IPSSysUserRoleData iPSSysUserRoleData = psSysUserRoleDatas.next();
                    if (StringHelper.Compare((String)iPSSysUserRoleData.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysUserRoleData);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCTRLLOGICGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUILogicGroups = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEUILogicGroups()) != null) {
                while (psAppDEUILogicGroups.hasNext()) {
                    iPSAppDEUILogicGroup2 = psAppDEUILogicGroups.next();
                    if (StringHelper.Compare((String)iPSAppDEUILogicGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUILogicGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCTRLLOGICGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSCTRLLOGICGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUILogicGroupDetails = (iPSAppDEUILogicGroup = (IPSAppDEUILogicGroup)psObjectList2.get(0)).getPSAppDEUILogicGroupDetails()) != null) {
                while (psAppDEUILogicGroupDetails.hasNext()) {
                    iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                    if (StringHelper.Compare((String)iPSAppDEUILogicGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUILogicGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCTRLLOGICGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUILogicGroups = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppDEUILogicGroups()) != null) {
                while (psAppDEUILogicGroups.hasNext()) {
                    iPSAppDEUILogicGroup2 = psAppDEUILogicGroups.next();
                    if (StringHelper.Compare((String)iPSAppDEUILogicGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUILogicGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCTRLLOGICGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSCTRLLOGICGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUILogicGroupDetails = (iPSAppDEUILogicGroup = (IPSAppDEUILogicGroup)psObjectList2.get(0)).getPSAppDEUILogicGroupDetails()) != null) {
                while (psAppDEUILogicGroupDetails.hasNext()) {
                    iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                    if (StringHelper.Compare((String)iPSAppDEUILogicGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUILogicGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILOGIC, (boolean)false) == 0) {
            Iterator<IPSAppDEUILogic> psAppDEUILogics;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEUILogics = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEUILogics()) != null) {
                while (psAppDEUILogics.hasNext()) {
                    IPSAppDEUILogic iPSAppDEUILogic2 = psAppDEUILogics.next();
                    if (StringHelper.Compare((String)iPSAppDEUILogic2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEUILogic2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILOGICNODE, (boolean)false) == 0) {
            Iterator<? extends IPSDEUILogicNode> psDEUILogicNodes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUILOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUILogicNodes = (iPSAppDEUILogic = (IPSAppDEUILogic)psObjectList2.get(0)).getPSDEUILogicNodes()) != null) {
                while (psDEUILogicNodes.hasNext()) {
                    IPSDEUILogicNode iPSDEUILogicNode = psDEUILogicNodes.next();
                    if (StringHelper.Compare((String)iPSDEUILogicNode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUILogicNode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILOGICPARAM, (boolean)false) == 0) {
            Iterator<? extends IPSDEUILogicParam> psDEUILogicParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUILOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUILogicParams = (iPSAppDEUILogic = (IPSAppDEUILogic)psObjectList2.get(0)).getPSDEUILogicParams()) != null) {
                while (psDEUILogicParams.hasNext()) {
                    IPSDEUILogicParam iPSDEUILogicParam = psDEUILogicParams.next();
                    if (StringHelper.Compare((String)iPSDEUILogicParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUILogicParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILOGICLINK, (boolean)false) == 0) {
            Iterator<? extends IPSDEUILogicLink> psDEUILogicLinks;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUILOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUILogicLinks = (iPSAppDEUILogic = (IPSAppDEUILogic)psObjectList2.get(0)).getPSDEUILogicLinks()) != null) {
                while (psDEUILogicLinks.hasNext()) {
                    IPSDEUILogicLink iPSDEUILogicLink = psDEUILogicLinks.next();
                    if (StringHelper.Compare((String)iPSDEUILogicLink.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUILogicLink);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILLCOND, (boolean)false) == 0) {
            IPSAppDEUILogicLink iPSAppDEUILogicLink;
            Iterator<? extends IPSDEUILogicLinkCond> psDEUILogicLinkConds;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUILOGICLINK, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUILogicLinkConds = (iPSAppDEUILogicLink = (IPSAppDEUILogicLink)psObjectList2.get(0)).getAllPSDEUILogicLinkConds()) != null) {
                while (psDEUILogicLinkConds.hasNext()) {
                    IPSDEUILogicLinkCond iPSDEUILogicLinkCond = psDEUILogicLinkConds.next();
                    if (StringHelper.Compare((String)iPSDEUILogicLinkCond.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUILogicLinkCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEUILNPARAM, (boolean)false) == 0) {
            IPSAppDEUILogicNode iPSAppDEUILogicNode;
            Iterator<IPSDEUILogicNodeParam> psDEUILogicNodeParams;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEUILOGICNODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEUILogicNodeParams = (iPSAppDEUILogicNode = (IPSAppDEUILogicNode)psObjectList2.get(0)).getPSDEUILogicNodeParams()) != null) {
                while (psDEUILogicNodeParams.hasNext()) {
                    IPSDEUILogicNodeParam iPSDEUILogicNodeParam = psDEUILogicNodeParams.next();
                    if (StringHelper.Compare((String)iPSDEUILogicNodeParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEUILogicNodeParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSLOGIC, (boolean)false) == 0) {
            Iterator<IPSDEMSLogic> psDEMSLogics;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMSLogics = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEMSLogics()) != null) {
                while (psDEMSLogics.hasNext()) {
                    IPSDEMSLogic iPSDEMSLogic2 = psDEMSLogics.next();
                    if (StringHelper.Compare((String)iPSDEMSLogic2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMSLogic2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSLOGICNODE, (boolean)false) == 0) {
            Iterator<? extends IPSDEMSLogicNode> psDEMSLogicNodes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMSLOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMSLogicNodes = (iPSDEMSLogic = (IPSDEMSLogic)psObjectList2.get(0)).getPSDEMSLogicNodes()) != null) {
                while (psDEMSLogicNodes.hasNext()) {
                    IPSDEMSLogicNode iPSDEMSLogicNode = psDEMSLogicNodes.next();
                    if (StringHelper.Compare((String)iPSDEMSLogicNode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMSLogicNode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSLOGICLINK, (boolean)false) == 0) {
            Iterator<? extends IPSDEMSLogicLink> psDEMSLogicLinks;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMSLOGIC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMSLogicLinks = (iPSDEMSLogic = (IPSDEMSLogic)psObjectList2.get(0)).getPSDEMSLogicLinks()) != null) {
                while (psDEMSLogicLinks.hasNext()) {
                    IPSDEMSLogicLink iPSDEMSLogicLink = psDEMSLogicLinks.next();
                    if (StringHelper.Compare((String)iPSDEMSLogicLink.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMSLogicLink);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMSLLCOND, (boolean)false) == 0) {
            IPSDEMSLogicLink iPSDEMSLogicLink;
            Iterator<? extends IPSDEMSLogicLinkCond> psDEMSLogicLinkConds;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEMSLOGICLINK, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMSLogicLinkConds = (iPSDEMSLogicLink = (IPSDEMSLogicLink)psObjectList2.get(0)).getAllPSDEMSLogicLinkConds()) != null) {
                while (psDEMSLogicLinkConds.hasNext()) {
                    IPSDEMSLogicLinkCond iPSDEMSLogicLinkCond = psDEMSLogicLinkConds.next();
                    if (StringHelper.Compare((String)iPSDEMSLogicLinkCond.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEMSLogicLinkCond);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPDEPRINT", (boolean)false) == 0) {
            Iterator<IPSAppDEPrint> psAppDEPrints;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEPrints = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEPrints()) != null) {
                while (psAppDEPrints.hasNext()) {
                    IPSAppDEPrint iPSAppDEPrint = psAppDEPrints.next();
                    if (StringHelper.Compare((String)iPSAppDEPrint.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEPrint);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEREPORT, (boolean)false) == 0) {
            Iterator<IPSAppDEReport> psAppDEReports;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEReports = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEReports()) != null) {
                while (psAppDEReports.hasNext()) {
                    IPSAppDEReport iPSAppDEReport = psAppDEReports.next();
                    if (StringHelper.Compare((String)iPSAppDEReport.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEReport);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEREPITEM, (boolean)false) == 0) {
            IPSAppDEReport iPSAppDEReport;
            Iterator<IPSAppDEReportItem> psAppDEReportItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEREPORT, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEReportItems = (iPSAppDEReport = (IPSAppDEReport)psObjectList2.get(0)).getPSAppDEReportItems()) != null) {
                while (psAppDEReportItems.hasNext()) {
                    IPSAppDEReportItem iPSAppDEReportItem = psAppDEReportItems.next();
                    if (StringHelper.Compare((String)iPSAppDEReportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEReportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEDATAEXP, (boolean)false) == 0) {
            Iterator<IPSAppDEDataExport> psAppDEDataExports;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEDataExports = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEDataExports()) != null) {
                while (psAppDEDataExports.hasNext()) {
                    IPSAppDEDataExport iPSAppDEDataExport2 = psAppDEDataExports.next();
                    if (StringHelper.Compare((String)iPSAppDEDataExport2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEDataExport2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEDATAEXPITEM, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEDATAEXP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataExportItems = (iPSAppDEDataExport = (IPSAppDEDataExport)psObjectList2.get(0)).getPSDEDataExportItems()) != null) {
                while (psDEDataExportItems.hasNext()) {
                    iPSDEDataExportItem = psDEDataExportItems.next();
                    if (StringHelper.Compare((String)iPSDEDataExportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataExportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEDATAEXPGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEDATAEXP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataExportGroups = (iPSAppDEDataExport = (IPSAppDEDataExport)psObjectList2.get(0)).getPSDEDataExportGroups()) != null) {
                while (psDEDataExportGroups.hasNext()) {
                    iPSDEDataExportGroup = psDEDataExportGroups.next();
                    if (StringHelper.Compare((String)iPSDEDataExportGroup.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataExportGroup);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEDATAIMP, (boolean)false) == 0) {
            Iterator<IPSAppDEDataImport> psAppDEDataImports;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEDataImports = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEDataImports()) != null) {
                while (psAppDEDataImports.hasNext()) {
                    IPSAppDEDataImport iPSAppDEDataImport = psAppDEDataImports.next();
                    if (StringHelper.Compare((String)iPSAppDEDataImport.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEDataImport);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEDATAIMPITEM, (boolean)false) == 0) {
            IPSAppDEDataImport iPSAppDEDataImport;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEDATAIMP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEDataImportItems = (iPSAppDEDataImport = (IPSAppDEDataImport)psObjectList2.get(0)).getPSDEDataImportItems()) != null) {
                while (psDEDataImportItems.hasNext()) {
                    iPSDEDataImportItem = psDEDataImportItems.next();
                    if (StringHelper.Compare((String)iPSDEDataImportItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEDataImportItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEACMODE, (boolean)false) == 0) {
            Iterator<IPSAppDEACMode> psAppDEACModes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEACModes = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEACModes()) != null) {
                while (psAppDEACModes.hasNext()) {
                    IPSAppDEACMode iPSAppDEACMode = psAppDEACModes.next();
                    if (StringHelper.Compare((String)iPSAppDEACMode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEACMode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMAP, (boolean)false) == 0) {
            Iterator<IPSAppDEMap> psAppDEMaps;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppDEMaps = (iPSAppDataEntity = (IPSAppDataEntity)psObjectList2.get(0)).getAllPSAppDEMaps()) != null) {
                while (psAppDEMaps.hasNext()) {
                    IPSAppDEMap iPSAppDEMap2 = psAppDEMaps.next();
                    if (StringHelper.Compare((String)iPSAppDEMap2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMap2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEMAPFIELD, (boolean)false) == 0) {
            Iterator<? extends IPSAppDEMapField> psDEMapFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapFields = (iPSAppDEMap = (IPSAppDEMap)psObjectList2.get(0)).getPSAppDEMapFields()) != null) {
                while (psDEMapFields.hasNext()) {
                    IPSAppDEMapField iPSAppDEMapField = psDEMapFields.next();
                    if (StringHelper.Compare((String)iPSAppDEMapField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMapField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPDEMAPACTION", (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapActions = (iPSAppDEMap = (IPSAppDEMap)psObjectList2.get(0)).getPSAppDEMapActions()) != null) {
                while (psDEMapActions.hasNext()) {
                    IPSAppDEMapAction iPSAppDEMapAction = (IPSAppDEMapAction)psDEMapActions.next();
                    if (StringHelper.Compare((String)iPSAppDEMapAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMapAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPDEMAPDS", (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPDEMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEMapDataSets = (iPSAppDEMap = (IPSAppDEMap)psObjectList2.get(0)).getPSAppDEMapDataSets()) != null) {
                while (psDEMapDataSets.hasNext()) {
                    IPSAppDEMapDataSet iPSAppDEMapDataSet = (IPSAppDEMapDataSet)psDEMapDataSets.next();
                    if (StringHelper.Compare((String)iPSAppDEMapDataSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppDEMapDataSet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSERMAP, (boolean)false) == 0) {
            IPSSysERMap iPSSysERMap = iPSSystem.getPSSysERMap(strModelId, true);
            if (iPSSysERMap != null) {
                list.add(iPSSysERMap);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSERMAPNODE, (boolean)false) == 0) {
            IPSSysERMap iPSSysERMap;
            Iterator<? extends IPSSysERMapNode> psSysERMapNodes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSERMAP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysERMapNodes = (iPSSysERMap = (IPSSysERMap)psObjectList2.get(0)).getPSSysERMapNodes()) != null) {
                while (psSysERMapNodes.hasNext()) {
                    IPSSysERMapNode iPSSysERMapNode = psSysERMapNodes.next();
                    if (StringHelper.Compare((String)iPSSysERMapNode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysERMapNode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSUCMAP", (boolean)false) == 0) {
            IPSSysUCMap iPSSysUCMap = iPSSystem.getPSSysUCMap(strModelId, true);
            if (iPSSysUCMap != null) {
                list.add(iPSSysUCMap);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSUCMAPNODE", (boolean)false) == 0) {
            IPSSysUCMap iPSSysUCMap;
            Iterator<? extends IPSSysUCMapNode> psSysUCMapNodes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSUCMAP", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysUCMapNodes = (iPSSysUCMap = (IPSSysUCMap)psObjectList2.get(0)).getPSSysUCMapNodes()) != null) {
                while (psSysUCMapNodes.hasNext()) {
                    IPSSysUCMapNode iPSSysUCMapNode = psSysUCMapNodes.next();
                    if (StringHelper.Compare((String)iPSSysUCMapNode.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysUCMapNode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHSCHEME, (boolean)false) == 0) {
            IPSSysSearchScheme iPSSysSearchScheme2 = iPSSystem.getPSSysSearchScheme(strModelId, true);
            if (iPSSysSearchScheme2 != null) {
                list.add(iPSSysSearchScheme2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHDOC, (boolean)false) == 0) {
            Iterator<? extends IPSSysSearchDoc> psSysSearchDocs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSEARCHSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysSearchDocs = (iPSSysSearchScheme = (IPSSysSearchScheme)psObjectList2.get(0)).getAllPSSysSearchDocs()) != null) {
                while (psSysSearchDocs.hasNext()) {
                    IPSSysSearchDoc iPSSysSearchDoc = psSysSearchDocs.next();
                    if (StringHelper.Compare((String)iPSSysSearchDoc.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysSearchDoc);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHDE, (boolean)false) == 0) {
            Iterator<? extends IPSSysSearchDE> psSysSearchDEs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSEARCHSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysSearchDEs = (iPSSysSearchScheme = (IPSSysSearchScheme)psObjectList2.get(0)).getAllPSSysSearchDEs()) != null) {
                while (psSysSearchDEs.hasNext()) {
                    IPSSysSearchDE iPSSysSearchDE = psSysSearchDEs.next();
                    if (StringHelper.Compare((String)iPSSysSearchDE.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysSearchDE);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHFIELD, (boolean)false) == 0) {
            IPSSysSearchDoc iPSSysSearchDoc;
            Iterator<? extends IPSSysSearchField> psSysSearchFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSEARCHDOC, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysSearchFields = (iPSSysSearchDoc = (IPSSysSearchDoc)psObjectList2.get(0)).getAllPSSysSearchFields()) != null) {
                while (psSysSearchFields.hasNext()) {
                    IPSSysSearchField iPSSysSearchField = psSysSearchFields.next();
                    if (StringHelper.Compare((String)iPSSysSearchField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysSearchField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSEARCHDEFIELD, (boolean)false) == 0) {
            IPSSysSearchDE iPSSysSearchDE;
            Iterator<? extends IPSSysSearchDEField> psSysSearchDEFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSEARCHDE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysSearchDEFields = (iPSSysSearchDE = (IPSSysSearchDE)psObjectList2.get(0)).getAllPSSysSearchDEFields()) != null) {
                while (psSysSearchDEFields.hasNext()) {
                    IPSSysSearchDEField iPSSysSearchDEField = psSysSearchDEFields.next();
                    if (StringHelper.Compare((String)iPSSysSearchDEField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysSearchDEField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDESEARCH, (boolean)false) == 0) {
            Iterator<IPSDESearch> psDESearchs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDESearchs = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDESearchs()) != null) {
                while (psDESearchs.hasNext()) {
                    IPSDESearch iPSDESearch = psDESearchs.next();
                    if (StringHelper.Compare((String)iPSDESearch.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDESearch);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFSEARCH, (boolean)false) == 0) {
            Iterator<IPSDEFSearch> psDEFSearchs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDEFIELD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEFSearchs = (iPSDEField = (IPSDEField)psObjectList2.get(0)).getAllPSDEFSearchs()) != null) {
                while (psDEFSearchs.hasNext()) {
                    IPSDEFSearch iPSDEFSearch = psDEFSearchs.next();
                    if (StringHelper.Compare((String)iPSDEFSearch.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEFSearch);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAISCHEME, (boolean)false) == 0) {
            IPSSysEAIScheme iPSSysEAIScheme2 = iPSSystem.getPSSysEAIScheme(strModelId, true);
            if (iPSSysEAIScheme2 != null) {
                list.add(iPSSysEAIScheme2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIDATATYPE, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIDataType> psSysEAIDataTypes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIDataTypes = (iPSSysEAIScheme = (IPSSysEAIScheme)psObjectList2.get(0)).getAllPSSysEAIDataTypes()) != null) {
                while (psSysEAIDataTypes.hasNext()) {
                    IPSSysEAIDataType iPSSysEAIDataType = psSysEAIDataTypes.next();
                    if (StringHelper.Compare((String)iPSSysEAIDataType.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIDataType);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIDATATYPEITEM, (boolean)false) == 0) {
            IPSSysEAIDataType iPSSysEAIDataType;
            Iterator<? extends IPSSysEAIDataTypeItem> psSysEAIDataTypeItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAIDATATYPE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIDataTypeItems = (iPSSysEAIDataType = (IPSSysEAIDataType)psObjectList2.get(0)).getAllPSSysEAIDataTypeItems()) != null) {
                while (psSysEAIDataTypeItems.hasNext()) {
                    IPSSysEAIDataTypeItem iPSSysEAIDataTypeItem = psSysEAIDataTypeItems.next();
                    if (StringHelper.Compare((String)iPSSysEAIDataTypeItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIDataTypeItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIELEMENT, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIElement> psSysEAIElements;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIElements = (iPSSysEAIScheme = (IPSSysEAIScheme)psObjectList2.get(0)).getAllPSSysEAIElements()) != null) {
                while (psSysEAIElements.hasNext()) {
                    IPSSysEAIElement iPSSysEAIElement2 = psSysEAIElements.next();
                    if (StringHelper.Compare((String)iPSSysEAIElement2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIElement2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIELEMENTATTR, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIElementAttr> psSysEAIElementAttrs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAIELEMENT, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIElementAttrs = (iPSSysEAIElement = (IPSSysEAIElement)psObjectList2.get(0)).getAllPSSysEAIElementAttrs()) != null) {
                while (psSysEAIElementAttrs.hasNext()) {
                    IPSSysEAIElementAttr iPSSysEAIElementAttr = psSysEAIElementAttrs.next();
                    if (StringHelper.Compare((String)iPSSysEAIElementAttr.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIElementAttr);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIELEMENTRE, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIElementRE> psSysEAIElementREs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAIELEMENT, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIElementREs = (iPSSysEAIElement = (IPSSysEAIElement)psObjectList2.get(0)).getAllPSSysEAIElementREs()) != null) {
                while (psSysEAIElementREs.hasNext()) {
                    IPSSysEAIElementRE iPSSysEAIElementRE = psSysEAIElementREs.next();
                    if (StringHelper.Compare((String)iPSSysEAIElementRE.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIElementRE);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIDE, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIDE> psSysEAIDEs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIDEs = (iPSSysEAIScheme = (IPSSysEAIScheme)psObjectList2.get(0)).getAllPSSysEAIDEs()) != null) {
                while (psSysEAIDEs.hasNext()) {
                    IPSSysEAIDE iPSSysEAIDE2 = psSysEAIDEs.next();
                    if (StringHelper.Compare((String)iPSSysEAIDE2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIDE2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIDEFIELD, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIDEField> psSysEAIDEFields;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAIDE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIDEFields = (iPSSysEAIDE = (IPSSysEAIDE)psObjectList2.get(0)).getAllPSSysEAIDEFields()) != null) {
                while (psSysEAIDEFields.hasNext()) {
                    IPSSysEAIDEField iPSSysEAIDEField = psSysEAIDEFields.next();
                    if (StringHelper.Compare((String)iPSSysEAIDEField.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIDEField);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSEAIDER, (boolean)false) == 0) {
            Iterator<? extends IPSSysEAIDER> psSysEAIDERs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSEAIDE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysEAIDERs = (iPSSysEAIDE = (IPSSysEAIDE)psObjectList2.get(0)).getAllPSSysEAIDERs()) != null) {
                while (psSysEAIDERs.hasNext()) {
                    IPSSysEAIDER iPSSysEAIDER = psSysEAIDERs.next();
                    if (StringHelper.Compare((String)iPSSysEAIDER.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysEAIDER);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSTHRESHOLDGROUP, (boolean)false) == 0) {
            IPSThresholdGroup iPSThresholdGroup = iPSSystem.getPSThresholdGroup(strModelId, true);
            if (iPSThresholdGroup != null) {
                list.add(iPSThresholdGroup);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSTHRESHOLD, (boolean)false) == 0) {
            IPSThresholdGroup iPSThresholdGroup;
            Iterator<? extends IPSThreshold> psThresholds;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSTHRESHOLDGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psThresholds = (iPSThresholdGroup = (IPSThresholdGroup)psObjectList2.get(0)).getPSThresholds()) != null) {
                while (psThresholds.hasNext()) {
                    IPSThreshold iPSThreshold = psThresholds.next();
                    if (StringHelper.Compare((String)iPSThreshold.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSThreshold);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSCHARTTHEME, (boolean)false) == 0) {
            IPSSysChartTheme iPSSysChartTheme = iPSSystem.getPSSysChartTheme(strModelId, true);
            if (iPSSysChartTheme != null) {
                list.add(iPSSysChartTheme);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBISCHEME, (boolean)false) == 0) {
            IPSSysBIScheme iPSSysBIScheme2 = iPSSystem.getPSSysBIScheme(strModelId, true);
            if (iPSSysBIScheme2 != null) {
                list.add(iPSSysBIScheme2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBIDIMENSION, (boolean)false) == 0) {
            Iterator<? extends IPSSysBIDimension> psSysBIDimensions;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIDimensions = (iPSSysBIScheme = (IPSSysBIScheme)psObjectList2.get(0)).getAllPSSysBIDimensions()) != null) {
                while (psSysBIDimensions.hasNext()) {
                    IPSSysBIDimension iPSSysBIDimension = psSysBIDimensions.next();
                    if (StringHelper.Compare((String)iPSSysBIDimension.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIDimension);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBIHIERARCHY, (boolean)false) == 0) {
            IPSSysBIDimension iPSSysBIDimension;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBIDIMENSION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIHierarchies = (iPSSysBIDimension = (IPSSysBIDimension)psObjectList2.get(0)).getAllPSSysBIHierarchies()) != null) {
                while (psSysBIHierarchies.hasNext()) {
                    IPSSysBIHierarchy iPSSysBIHierarchy = (IPSSysBIHierarchy)psSysBIHierarchies.next();
                    if (StringHelper.Compare((String)iPSSysBIHierarchy.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIHierarchy);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBILEVEL, (boolean)false) == 0) {
            IPSSysBIHierarchy iPSSysBIHierarchy;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBIHIERARCHY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIHierarchies = (iPSSysBIHierarchy = (IPSSysBIHierarchy)psObjectList2.get(0)).getAllPSSysBILevels()) != null) {
                while (psSysBIHierarchies.hasNext()) {
                    IPSSysBILevel iPSSysBILevel = (IPSSysBILevel)psSysBIHierarchies.next();
                    if (StringHelper.Compare((String)iPSSysBILevel.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBILevel);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBICUBE, (boolean)false) == 0) {
            Iterator<? extends IPSSysBICube> psSysBICubes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBICubes = (iPSSysBIScheme = (IPSSysBIScheme)psObjectList2.get(0)).getAllPSSysBICubes()) != null) {
                while (psSysBICubes.hasNext()) {
                    IPSSysBICube iPSSysBICube2 = psSysBICubes.next();
                    if (StringHelper.Compare((String)iPSSysBICube2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBICube2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBICUBEMEASURE, (boolean)false) == 0) {
            Iterator<? extends IPSSysBICubeMeasure> psSysBICubeMeasures;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBICUBE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBICubeMeasures = (iPSSysBICube = (IPSSysBICube)psObjectList2.get(0)).getAllPSSysBICubeMeasures()) != null) {
                while (psSysBICubeMeasures.hasNext()) {
                    IPSSysBICubeMeasure iPSSysBICubeMeasure = psSysBICubeMeasures.next();
                    if (StringHelper.Compare((String)iPSSysBICubeMeasure.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBICubeMeasure);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBICUBEDIMENSION, (boolean)false) == 0) {
            Iterator<? extends IPSSysBICubeDimension> psSysBICubeDimensions;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBICUBE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBICubeDimensions = (iPSSysBICube = (IPSSysBICube)psObjectList2.get(0)).getAllPSSysBICubeDimensions()) != null) {
                while (psSysBICubeDimensions.hasNext()) {
                    IPSSysBICubeDimension iPSSysBICubeDimension = psSysBICubeDimensions.next();
                    if (StringHelper.Compare((String)iPSSysBICubeDimension.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBICubeDimension);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBICUBELEVEL, (boolean)false) == 0) {
            IPSSysBICubeDimension iPSSysBICubeDimension;
            Iterator<? extends IPSSysBICubeLevel> psSysBICubeLevels;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBICUBEDIMENSION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBICubeLevels = (iPSSysBICubeDimension = (IPSSysBICubeDimension)psObjectList2.get(0)).getAllPSSysBICubeLevels()) != null) {
                while (psSysBICubeLevels.hasNext()) {
                    IPSSysBICubeLevel iPSSysBICubeLevel = psSysBICubeLevels.next();
                    if (StringHelper.Compare((String)iPSSysBICubeLevel.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBICubeLevel);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBIAGGTABLE, (boolean)false) == 0) {
            Iterator<? extends IPSSysBIAggTable> psSysBIAggTables;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIAggTables = (iPSSysBIScheme = (IPSSysBIScheme)psObjectList2.get(0)).getAllPSSysBIAggTables()) != null) {
                while (psSysBIAggTables.hasNext()) {
                    IPSSysBIAggTable iPSSysBIAggTable = psSysBIAggTables.next();
                    if (StringHelper.Compare((String)iPSSysBIAggTable.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIAggTable);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBIAGGCOLUMN, (boolean)false) == 0) {
            IPSSysBIAggTable iPSSysBIAggTable;
            Iterator<? extends IPSSysBIAggColumn> psSysBIAggColumns;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBIAGGTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIAggColumns = (iPSSysBIAggTable = (IPSSysBIAggTable)psObjectList2.get(0)).getAllPSSysBIAggColumns()) != null) {
                while (psSysBIAggColumns.hasNext()) {
                    IPSSysBIAggColumn iPSSysBIAggColumn = psSysBIAggColumns.next();
                    if (StringHelper.Compare((String)iPSSysBIAggColumn.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIAggColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSBIREPORT", (boolean)false) == 0) {
            Iterator<? extends IPSSysBIReport> psSysBIReports;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBISCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIReports = (iPSSysBIScheme = (IPSSysBIScheme)psObjectList2.get(0)).getAllPSSysBIReports()) != null) {
                while (psSysBIReports.hasNext()) {
                    IPSSysBIReport iPSSysBIReport2 = psSysBIReports.next();
                    if (StringHelper.Compare((String)iPSSysBIReport2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIReport2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSBIREPORTITEM_MEASURE", (boolean)false) == 0) {
            Iterator<? extends IPSSysBIReportMeasure> psSysBIReportMeasures;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSBIREPORT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIReportMeasures = (iPSSysBIReport = (IPSSysBIReport)psObjectList2.get(0)).getAllPSSysBIReportMeasures()) != null) {
                while (psSysBIReportMeasures.hasNext()) {
                    IPSSysBIReportMeasure iPSSysBIReportMeasure = psSysBIReportMeasures.next();
                    if (StringHelper.Compare((String)iPSSysBIReportMeasure.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIReportMeasure);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSBIREPORTITEM_DIMENSION", (boolean)false) == 0) {
            Iterator<? extends IPSSysBIReportDimension> psSysBIReportDimensions;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSBIREPORT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBIReportDimensions = (iPSSysBIReport = (IPSSysBIReport)psObjectList2.get(0)).getAllPSSysBIReportDimensions()) != null) {
                while (psSysBIReportDimensions.hasNext()) {
                    IPSSysBIReportDimension iPSSysBIReportDimension = psSysBIReportDimensions.next();
                    if (StringHelper.Compare((String)iPSSysBIReportDimension.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBIReportDimension);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBISCHEME", (boolean)false) == 0) {
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                Iterator<IPSAppBIScheme> psAppBISchemes;
                iPSApplication = psApplications.next();
                if (!StringHelper.IsNullOrEmpty((String)PSModels.getPSSysAppId()) && StringHelper.Compare((String)PSModels.getPSSysAppId(), (String)iPSApplication.getId(), (boolean)false) != 0 || (psAppBISchemes = iPSApplication.getAllPSAppBISchemes()) == null) continue;
                while (psAppBISchemes.hasNext()) {
                    IPSAppBIScheme iPSAppBIScheme2 = psAppBISchemes.next();
                    if (StringHelper.Compare((String)iPSAppBIScheme2.getId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBIScheme2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBICUBE", (boolean)false) == 0) {
            Iterator<IPSAppBICube> psAppBICubes;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBISCHEME", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBICubes = (iPSAppBIScheme = (IPSAppBIScheme)psObjectList2.get(0)).getPSAppBICubes()) != null) {
                while (psAppBICubes.hasNext()) {
                    IPSAppBICube iPSAppBICube2 = psAppBICubes.next();
                    if (StringHelper.Compare((String)iPSAppBICube2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBICube2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBICUBEMEASURE", (boolean)false) == 0) {
            Iterator<IPSAppBICubeMeasure> psAppBICubeMeasures;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBICUBE", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBICubeMeasures = (iPSAppBICube = (IPSAppBICube)psObjectList2.get(0)).getPSAppBICubeMeasures()) != null) {
                while (psAppBICubeMeasures.hasNext()) {
                    IPSAppBICubeMeasure iPSAppBICubeMeasure = psAppBICubeMeasures.next();
                    if (StringHelper.Compare((String)iPSAppBICubeMeasure.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBICubeMeasure);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBICUBEDIMENSION", (boolean)false) == 0) {
            Iterator<IPSAppBICubeDimension> psAppBICubeDimensions;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBICUBE", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBICubeDimensions = (iPSAppBICube = (IPSAppBICube)psObjectList2.get(0)).getPSAppBICubeDimensions()) != null) {
                while (psAppBICubeDimensions.hasNext()) {
                    IPSAppBICubeDimension iPSAppBICubeDimension = psAppBICubeDimensions.next();
                    if (StringHelper.Compare((String)iPSAppBICubeDimension.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBICubeDimension);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBIREPORT", (boolean)false) == 0) {
            Iterator<IPSAppBIReport> psAppBIReports;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBISCHEME", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBIReports = (iPSAppBIScheme = (IPSAppBIScheme)psObjectList2.get(0)).getPSAppBIReports()) != null) {
                while (psAppBIReports.hasNext()) {
                    IPSAppBIReport iPSAppBIReport2 = psAppBIReports.next();
                    if (StringHelper.Compare((String)iPSAppBIReport2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBIReport2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBIREPORTMEASURE", (boolean)false) == 0) {
            Iterator<IPSAppBIReportMeasure> psAppBIReportMeasures;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBIREPORT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBIReportMeasures = (iPSAppBIReport = (IPSAppBIReport)psObjectList2.get(0)).getPSAppBIReportMeasures()) != null) {
                while (psAppBIReportMeasures.hasNext()) {
                    IPSAppBIReportMeasure iPSAppBIReportMeasure = psAppBIReportMeasures.next();
                    if (StringHelper.Compare((String)iPSAppBIReportMeasure.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBIReportMeasure);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPBIREPORTDIMENSION", (boolean)false) == 0) {
            Iterator<IPSAppBIReportDimension> psAppBIReportDimensions;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSAPPBIREPORT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppBIReportDimensions = (iPSAppBIReport = (IPSAppBIReport)psObjectList2.get(0)).getPSAppBIReportDimensions()) != null) {
                while (psAppBIReportDimensions.hasNext()) {
                    IPSAppBIReportDimension iPSAppBIReportDimension = psAppBIReportDimensions.next();
                    if (StringHelper.Compare((String)iPSAppBIReportDimension.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppBIReportDimension);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAIFACTORY", (boolean)false) == 0) {
            IPSSysAIFactory iPSSysAIFactory2 = iPSSystem.getPSSysAIFactory(strModelId, true);
            if (iPSSysAIFactory2 != null) {
                list.add(iPSSysAIFactory2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAICHATAGENT", (boolean)false) == 0) {
            Iterator<? extends IPSSysAIChatAgent> psSysAIChatAgents;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSAIFACTORY", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysAIChatAgents = (iPSSysAIFactory = (IPSSysAIFactory)psObjectList2.get(0)).getAllPSSysAIChatAgents()) != null) {
                while (psSysAIChatAgents.hasNext()) {
                    IPSSysAIChatAgent iPSSysAIChatAgent = psSysAIChatAgents.next();
                    if (StringHelper.Compare((String)iPSSysAIChatAgent.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysAIChatAgent);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAIWORKERAGENT", (boolean)false) == 0) {
            Iterator<? extends IPSSysAIWorkerAgent> psSysAIWorkerAgents;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSAIFACTORY", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysAIWorkerAgents = (iPSSysAIFactory = (IPSSysAIFactory)psObjectList2.get(0)).getAllPSSysAIWorkerAgents()) != null) {
                while (psSysAIWorkerAgents.hasNext()) {
                    IPSSysAIWorkerAgent iPSSysAIWorkerAgent = psSysAIWorkerAgents.next();
                    if (StringHelper.Compare((String)iPSSysAIWorkerAgent.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysAIWorkerAgent);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAIPIPELINEAGENT", (boolean)false) == 0) {
            Iterator<? extends IPSSysAIPipelineAgent> psSysAIPipelineAgents;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSAIFACTORY", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysAIPipelineAgents = (iPSSysAIFactory = (IPSSysAIFactory)psObjectList2.get(0)).getAllPSSysAIPipelineAgents()) != null) {
                while (psSysAIPipelineAgents.hasNext()) {
                    IPSSysAIPipelineAgent iPSSysAIPipelineAgent2 = psSysAIPipelineAgents.next();
                    if (StringHelper.Compare((String)iPSSysAIPipelineAgent2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysAIPipelineAgent2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAIPIPELINEJOB", (boolean)false) == 0) {
            Iterator<? extends IPSSysAIPipelineJob> psSysAIPipelineJobs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSAIPIPELINEAGENT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysAIPipelineJobs = (iPSSysAIPipelineAgent = (IPSSysAIPipelineAgent)psObjectList2.get(0)).getAllPSSysAIPipelineJobs()) != null) {
                while (psSysAIPipelineJobs.hasNext()) {
                    IPSSysAIPipelineJob iPSSysAIPipelineJob = psSysAIPipelineJobs.next();
                    if (StringHelper.Compare((String)iPSSysAIPipelineJob.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysAIPipelineJob);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSSYSAIPIPELINEWORKER", (boolean)false) == 0) {
            Iterator<? extends IPSSysAIPipelineWorker> psSysAIPipelineWorkers;
            psObjectList2 = PSModels.getPSModels(iPSSystem, "PSSYSAIPIPELINEAGENT", PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysAIPipelineWorkers = (iPSSysAIPipelineAgent = (IPSSysAIPipelineAgent)psObjectList2.get(0)).getAllPSSysAIPipelineWorkers()) != null) {
                while (psSysAIPipelineWorkers.hasNext()) {
                    IPSSysAIPipelineWorker iPSSysAIPipelineWorker = psSysAIPipelineWorkers.next();
                    if (StringHelper.Compare((String)iPSSysAIPipelineWorker.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysAIPipelineWorker);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDSCHEME, (boolean)false) == 0) {
            IPSSysBDScheme iPSSysBDScheme2 = iPSSystem.getPSSysBDScheme(strModelId, true);
            if (iPSSysBDScheme2 != null) {
                list.add(iPSSysBDScheme2);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDTABLE, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDTable> psSysBDTables;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDTables = (iPSSysBDScheme = (IPSSysBDScheme)psObjectList2.get(0)).getAllPSSysBDTables()) != null) {
                while (psSysBDTables.hasNext()) {
                    IPSSysBDTable iPSSysBDTable2 = psSysBDTables.next();
                    if (StringHelper.Compare((String)iPSSysBDTable2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDTable2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDCOLSET, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDColSet> psSysBDColSets;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDColSets = (iPSSysBDTable = (IPSSysBDTable)psObjectList2.get(0)).getAllPSSysBDColSets()) != null) {
                while (psSysBDColSets.hasNext()) {
                    IPSSysBDColSet iPSSysBDColSet = psSysBDColSets.next();
                    if (StringHelper.Compare((String)iPSSysBDColSet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDColSet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDCOLUMN, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDColumn> psSysBDColumns;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDColumns = (iPSSysBDTable = (IPSSysBDTable)psObjectList2.get(0)).getAllPSSysBDColumns()) != null) {
                while (psSysBDColumns.hasNext()) {
                    IPSSysBDColumn iPSSysBDColumn = psSysBDColumns.next();
                    if (StringHelper.Compare((String)iPSSysBDColumn.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDColumn);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDPART, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDPart> psSysBDParts;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDParts = (iPSSysBDScheme = (IPSSysBDScheme)psObjectList2.get(0)).getAllPSSysBDParts()) != null) {
                while (psSysBDParts.hasNext()) {
                    IPSSysBDPart iPSSysBDPart = psSysBDParts.next();
                    if (StringHelper.Compare((String)iPSSysBDPart.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDPart);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDMODULE, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDModule> psSysBDModules;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDModules = (iPSSysBDScheme = (IPSSysBDScheme)psObjectList2.get(0)).getAllPSSysBDModules()) != null) {
                while (psSysBDModules.hasNext()) {
                    IPSSysBDModule iPSSysBDModule = psSysBDModules.next();
                    if (StringHelper.Compare((String)iPSSysBDModule.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDModule);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDTABLERS, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDTableRS> psSysBDTableRSs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDSCHEME, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDTableRSs = (iPSSysBDScheme = (IPSSysBDScheme)psObjectList2.get(0)).getAllPSSysBDTableRSs()) != null) {
                while (psSysBDTableRSs.hasNext()) {
                    IPSSysBDTableRS iPSSysBDTableRS = psSysBDTableRSs.next();
                    if (StringHelper.Compare((String)iPSSysBDTableRS.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDTableRS);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSBDTABLEDER, (boolean)false) == 0) {
            Iterator<? extends IPSSysBDTableDER> psSysBDTableDERs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSBDTABLE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysBDTableDERs = (iPSSysBDTable = (IPSSysBDTable)psObjectList2.get(0)).getAllPSSysBDTableDERs()) != null) {
                while (psSysBDTableDERs.hasNext()) {
                    IPSSysBDTableDER iPSSysBDTableDER = psSysBDTableDERs.next();
                    if (StringHelper.Compare((String)iPSSysBDTableDER.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysBDTableDER);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEBDTABLE, (boolean)false) == 0) {
            Iterator<IPSDEBDTable> psDEBDTables;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDEBDTables = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEBDTables()) != null) {
                while (psDEBDTables.hasNext()) {
                    IPSDEBDTable iPSDEBDTable = psDEBDTables.next();
                    if (StringHelper.Compare((String)iPSDEBDTable.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDEBDTable);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSMAPITEM, (boolean)false) == 0 || strModelType.indexOf("PSSYSMAPITEM_") == 0) {
            IPSSysMap iPSSysMap;
            Iterator<IPSSysMapItem> psSysMapItems;
            items3 = strModelId.split("[#]");
            if (items3.length == 3 && (psControlList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSMAPVIEW, String.valueOf(items3[0]) + "#" + items3[1])).size() > 0 && (psSysMapItems = (iPSSysMap = (IPSSysMap)psControlList2.get(0)).getPSSysMapItems()) != null) {
                while (psSysMapItems.hasNext()) {
                    IPSSysMapItem iPSSysMapItem = psSysMapItems.next();
                    if (StringHelper.Compare((String)iPSSysMapItem.getId(), (String)items3[2], (boolean)true) != 0) continue;
                    list.add(iPSSysMapItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFVERUIACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWFVER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppWFUIActions = (iPSAppWFVer = (IPSAppWFVer)psObjectList2.get(0)).getAllPSAppWFUIActions()) != null) {
                while (psAppWFUIActions.hasNext()) {
                    iPSAppWFUIAction = psAppWFUIActions.next();
                    if (StringHelper.Compare((String)iPSAppWFUIAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFUIAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFUIACTION, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWF, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppWFUIActions = (iPSAppWF = (IPSAppWF)psObjectList2.get(0)).getAllPSAppWFUIActions()) != null) {
                while (psAppWFUIActions.hasNext()) {
                    iPSAppWFUIAction = psAppWFUIActions.next();
                    if (StringHelper.Compare((String)iPSAppWFUIAction.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFUIAction);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFVERUAGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWFVER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppWFUIActionGroups = (iPSAppWFVer = (IPSAppWFVer)psObjectList2.get(0)).getPSAppWFUIActionGroups()) != null) {
                while (psAppWFUIActionGroups.hasNext()) {
                    iPSAppWFUIActionGroup2 = psAppWFUIActionGroups.next();
                    if (StringHelper.Compare((String)iPSAppWFUIActionGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFUIActionGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFUAGROUP, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWF, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppWFUIActionGroups = (iPSAppWF = (IPSAppWF)psObjectList2.get(0)).getPSAppWFUIActionGroups()) != null) {
                while (psAppWFUIActionGroups.hasNext()) {
                    iPSAppWFUIActionGroup2 = psAppWFUIActionGroups.next();
                    if (StringHelper.Compare((String)iPSAppWFUIActionGroup2.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFUIActionGroup2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFUAGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWFUAGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psWFUIActionGroupDetails = (iPSAppWFUIActionGroup = (IPSAppWFUIActionGroup)psObjectList2.get(0)).getPSWFUIActionGroupDetails()) != null) {
                while (psWFUIActionGroupDetails.hasNext()) {
                    iPSWFUIActionGroupDetail = psWFUIActionGroupDetails.next();
                    if (StringHelper.Compare((String)iPSWFUIActionGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFUIActionGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFVERUAGRPDETAIL, (boolean)false) == 0) {
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWFVERUAGROUP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psWFUIActionGroupDetails = (iPSAppWFUIActionGroup = (IPSAppWFUIActionGroup)psObjectList2.get(0)).getPSWFUIActionGroupDetails()) != null) {
                while (psWFUIActionGroupDetails.hasNext()) {
                    iPSWFUIActionGroupDetail = psWFUIActionGroupDetails.next();
                    if (StringHelper.Compare((String)iPSWFUIActionGroupDetail.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSWFUIActionGroupDetail);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPUTIL, (boolean)false) == 0) {
            Iterator<IPSAppUtil> psAppUtils;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppUtils = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppUtils()) != null) {
                while (psAppUtils.hasNext()) {
                    IPSAppUtil iPSAppUtil = psAppUtils.next();
                    if (StringHelper.Compare((String)iPSAppUtil.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppUtil);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPPORTLET, (boolean)false) == 0) {
            Iterator<IPSAppPortlet> psAppPortlets;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppPortlets = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppPortlets()) != null) {
                while (psAppPortlets.hasNext()) {
                    IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                    if (StringHelper.Compare((String)iPSAppPortlet.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppPortlet);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPPDTVIEW, (boolean)false) == 0) {
            Iterator<IPSAppPDTView> psAppPDTViews;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppPDTViews = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getAllPSAppPDTViews()) != null) {
                while (psAppPDTViews.hasNext()) {
                    IPSAppPDTView iPSAppPDTView = psAppPDTViews.next();
                    if (StringHelper.Compare((String)iPSAppPDTView.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppPDTView);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPPKG, (boolean)false) == 0) {
            Iterator<IPSAppPkg> psAppPkgs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSAPP, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppPkgs = (iPSApplication = (IPSApplication)psObjectList2.get(0)).getPSAppPkgs()) != null) {
                while (psAppPkgs.hasNext()) {
                    IPSAppPkg iPSAppPkg = psAppPkgs.next();
                    if (StringHelper.Compare((String)iPSAppPkg.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppPkg);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSSFPUBPKG, (boolean)false) == 0) {
            Iterator<IPSSysSFPubPkg> psSysSFPubPkgs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSSYSSFPUB, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psSysSFPubPkgs = (iPSSysSFPub = (IPSSysSFPub)psObjectList2.get(0)).getPSSysSFPubPkgs()) != null) {
                while (psSysSFPubPkgs.hasNext()) {
                    IPSSysSFPubPkg iPSSysSFPubPkg = psSysSFPubPkgs.next();
                    if (StringHelper.Compare((String)iPSSysSFPubPkg.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSSysSFPubPkg);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSPANELDATAITEM, (boolean)false) == 0 || strModelType.indexOf("PSSYSPANELDATAITEM_") == 0) {
            IPSSysPanel iPSSysPanel3;
            Iterator<? extends IPSPanelField> psSysPanelFields;
            psControlList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSVIEWPANEL, PSModels.getParentModelId(strModelId));
            if (psControlList.size() > 0 && (psSysPanelFields = (iPSSysPanel3 = (IPSSysPanel)psControlList.get(0)).getAllPSPanelFields()) != null) {
                while (psSysPanelFields.hasNext()) {
                    IPSPanelField iPSPanelField = psSysPanelFields.next();
                    if (!(iPSPanelField.getDataItem() instanceof IPSDataItem) || StringHelper.Compare((String)(iPSDataItem = (IPSDataItem)iPSPanelField.getDataItem()).getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACMODEDATAITEM, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEACMODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (dataItems = (iPSDEACMode = (IPSDEACMode)psObjectList2.get(0)).getDataItems()) != null) {
                while (dataItems.hasNext()) {
                    iDataItem = (IDataItem)dataItems.next();
                    if (!(iDataItem instanceof IPSDataItem) || StringHelper.Compare((String)(iPSDataItem = (IPSDataItem)iDataItem).getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPDEACMODEDATAITEM, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPDEACMODE, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (dataItems = (iPSDEACMode = (IPSDEACMode)psObjectList2.get(0)).getDataItems()) != null) {
                while (dataItems.hasNext()) {
                    iDataItem = (IDataItem)dataItems.next();
                    if (!(iDataItem instanceof IPSDataItem) || StringHelper.Compare((String)(iPSDataItem = (IPSDataItem)iDataItem).getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSPFXCODEOBJECT, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSPFPITEMPL, (boolean)false) == 0) {
            IPSSysPFPluginTempl iPSSysPFPluginTempl = iPSSystem.getPSSysPFPluginTempl(strModelId, true);
            if (iPSSysPFPluginTempl != null) {
                list.add(iPSSysPFPluginTempl);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSFXCODEOBJECT, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSSYSSFPITEMPL, (boolean)false) == 0) {
            IPSSysSFPluginTempl iPSSysSFPluginTempl = iPSSystem.getPSSysSFPluginTempl(strModelId, true);
            if (iPSSysSFPluginTempl != null) {
                list.add(iPSSysSFPluginTempl);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDCWORKSPACE, (boolean)false) == 0) {
            IPSWorkspace iPSWorkspace = ((IPSSystemRuntime)((Object)iPSSystem)).getPSWorkspace();
            if (iPSWorkspace != null) {
                list.add(iPSWorkspace);
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODERSPARAM, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeRSParam> psDETreeNodeRSParams;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODERS, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psDETreeNodeRSParams = (iPSDETreeNodeRS = (IPSDETreeNodeRS)appViewList.get(0)).getPSDETreeNodeRSParams()) != null) {
                while (psDETreeNodeRSParams.hasNext()) {
                    IPSDETreeNodeRSParam iPSDETreeNodeRSParam = psDETreeNodeRSParams.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeRSParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeRSParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODERSNAVPARAM, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeRSNavParam> psDETreeNodeRSNavParams;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODERS, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psDETreeNodeRSNavParams = (iPSDETreeNodeRS = (IPSDETreeNodeRS)appViewList.get(0)).getPSDETreeNodeRSNavParams()) != null) {
                while (psDETreeNodeRSNavParams.hasNext()) {
                    IPSDETreeNodeRSNavParam iPSDETreeNodeRSNavParam = psDETreeNodeRSNavParams.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeRSNavParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeRSNavParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDETREENODERSNAVCONTEXT, (boolean)false) == 0) {
            Iterator<IPSDETreeNodeRSNavContext> psDETreeNodeRSNavContexts;
            appViewList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDETREENODERS, PSModels.getParentModelId(strModelId));
            if (appViewList.size() > 0 && (psDETreeNodeRSNavContexts = (iPSDETreeNodeRS = (IPSDETreeNodeRS)appViewList.get(0)).getPSDETreeNodeRSNavContexts()) != null) {
                while (psDETreeNodeRSNavContexts.hasNext()) {
                    IPSDETreeNodeRSNavContext iPSDETreeNodeRSNavContext = psDETreeNodeRSNavContexts.next();
                    if (StringHelper.Compare((String)iPSDETreeNodeRSNavContext.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDETreeNodeRSNavContext);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSNAVIGATEPARAM$") == 0) {
            Iterator<? extends IPSNavigateParam> psNavigateParams;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(16), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSNavigateParamContainer && (psNavigateParams = (iPSNavigatable = (IPSNavigateParamContainer)((Object)psObjectList2.get(0))).getPSNavigateParams()) != null) {
                while (psNavigateParams.hasNext()) {
                    IPSNavigateParam iPSNavigateParam = psNavigateParams.next();
                    if (StringHelper.Compare((String)iPSNavigateParam.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSNavigateParam);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSNAVIGATECONTEXT$") == 0) {
            Iterator<? extends IPSNavigateContext> psNavigateContexts;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(18), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSNavigateParamContainer && (psNavigateContexts = (iPSNavigatable = (IPSNavigateParamContainer)((Object)psObjectList2.get(0))).getPSNavigateContexts()) != null) {
                while (psNavigateContexts.hasNext()) {
                    IPSNavigateContext iPSNavigateContext = psNavigateContexts.next();
                    if (StringHelper.Compare((String)iPSNavigateContext.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSNavigateContext);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSSFPUBHELP$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(12), strModelId);
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSSFPubSupportable && (iPSSFPubSupportable = (IPSSFPubSupportable)((Object)logicList.get(0))).getPSSFPubHelp() != null) {
                list.add(iPSSFPubSupportable.getPSSFPubHelp());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSSFCODEPUBLISHERMACRO$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(23), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSSFPubSupportable && (iPSSFPubSupportable = (IPSSFPubSupportable)((Object)logicList.get(0))).getPSSFPubHelp() != null && (macros = iPSSFPubSupportable.getPSSFPubHelp().getPSCodePublisherMacros()) != null) {
                while (macros.hasNext()) {
                    iPSCodePublisherMacro = macros.next();
                    if (StringHelper.Compare((String)iPSCodePublisherMacro.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCodePublisherMacro);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSSFCODEPUBLISHERPARAM$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(23), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSSFPubSupportable && (iPSSFPubSupportable = (IPSSFPubSupportable)((Object)logicList.get(0))).getPSSFPubHelp() != null && (params = iPSSFPubSupportable.getPSSFPubHelp().getPSCodePublisherParams()) != null) {
                while (params.hasNext()) {
                    iPSCodePublisherParam = params.next();
                    if (StringHelper.Compare((String)iPSCodePublisherParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCodePublisherParam);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSPFPUBHELP$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(12), strModelId);
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSPFPubSupportable && (iPSPFPubSupportable = (IPSPFPubSupportable)((Object)logicList.get(0))).getPSPFPubHelp() != null) {
                list.add(iPSPFPubSupportable.getPSPFPubHelp());
                return list;
            }
            return list;
        }
        if (strModelType.indexOf("PSPFCODEPUBLISHERMACRO$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(23), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSPFPubSupportable && (iPSPFPubSupportable = (IPSPFPubSupportable)((Object)logicList.get(0))).getPSPFPubHelp() != null && (macros = iPSPFPubSupportable.getPSPFPubHelp().getPSCodePublisherMacros()) != null) {
                while (macros.hasNext()) {
                    iPSCodePublisherMacro = macros.next();
                    if (StringHelper.Compare((String)iPSCodePublisherMacro.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCodePublisherMacro);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSPFCODEPUBLISHERPARAM$") == 0) {
            logicList = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(23), PSModels.getParentModelId(strModelId));
            if (logicList.size() > 0 && logicList.get(0) instanceof IPSPFPubSupportable && (iPSPFPubSupportable = (IPSPFPubSupportable)((Object)logicList.get(0))).getPSPFPubHelp() != null && (params = iPSPFPubSupportable.getPSPFPubHelp().getPSCodePublisherParams()) != null) {
                while (params.hasNext()) {
                    iPSCodePublisherParam = params.next();
                    if (StringHelper.Compare((String)iPSCodePublisherParam.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCodePublisherParam);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDER1NDEFMAP, (boolean)false) == 0) {
            IPSDER1N iPSDER1N;
            Iterator<IPSDER1NDEFieldMap> psDER1NDEFieldMaps;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDER1N && (psDER1NDEFieldMaps = (iPSDER1N = (IPSDER1N)psObjectList2.get(0)).getPSDER1NDEFieldMaps()) != null) {
                while (psDER1NDEFieldMaps.hasNext()) {
                    IPSDER1NDEFieldMap iPSDER1NDEFieldMap = psDER1NDEFieldMaps.next();
                    if (StringHelper.Compare((String)iPSDER1NDEFieldMap.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDER1NDEFieldMap);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDERINDEXDEFMAP, (boolean)false) == 0) {
            IPSDERIndex IPSDERIndex2;
            Iterator<IPSDERIndexDEFieldMap> psDERIndexDEFieldMaps;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDERIndex && (psDERIndexDEFieldMaps = (IPSDERIndex2 = (IPSDERIndex)psObjectList2.get(0)).getPSDERIndexDEFieldMaps()) != null) {
                while (psDERIndexDEFieldMaps.hasNext()) {
                    IPSDERIndexDEFieldMap iPSDERIndexDEFieldMap = psDERIndexDEFieldMaps.next();
                    if (StringHelper.Compare((String)iPSDERIndexDEFieldMap.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDERIndexDEFieldMap);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDERAGGDATADEFMAP, (boolean)false) == 0) {
            IPSDERAggData iPSDERAggData;
            Iterator<IPSDERAggDataDEFieldMap> psDERAggDataDEFieldMaps;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDER, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDERAggData && (psDERAggDataDEFieldMaps = (iPSDERAggData = (IPSDERAggData)psObjectList2.get(0)).getPSDERAggDataDEFieldMaps()) != null) {
                while (psDERAggDataDEFieldMaps.hasNext()) {
                    IPSDERAggDataDEFieldMap iPSDERAggDataDEFieldMap = psDERAggDataDEFieldMaps.next();
                    if (StringHelper.Compare((String)iPSDERAggDataDEFieldMap.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDERAggDataDEFieldMap);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEMETHOD, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEACTIONMETHOD, (boolean)false) == 0 || StringHelper.Compare((String)strModelType, (String)PSDEDATASETMETHOD, (boolean)false) == 0) {
            Iterator<IPSDEMethod> psDEMethods;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDataEntity && (psDEMethods = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDEMethods()) != null) {
                while (psDEMethods.hasNext()) {
                    IPSDEMethod iPSDEMethod = psDEMethods.next();
                    if (StringHelper.Compare((String)iPSDEMethod.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEMethod);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFUIMODE, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFIELD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEField && (psDEFUIModes = (iPSDEField = (IPSDEField)psObjectList2.get(0)).getAllPSDEFUIModes()) != null) {
                while (psDEFUIModes.hasNext()) {
                    IPSDEFUIMode iPSDEFUIMode2 = (IPSDEFUIMode)psDEFUIModes.next();
                    if (StringHelper.Compare((String)iPSDEFUIMode2.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEFUIMode2);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPDEFUIMODE", (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSAPPDEFIELD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSAppDEField && (psDEFUIModes = (iPSAppDEField = (IPSAppDEField)psObjectList2.get(0)).getAllPSAppDEFUIModes()) != null) {
                while (psDEFUIModes.hasNext()) {
                    IPSAppDEFUIMode iPSAppDEFUIMode = (IPSAppDEFUIMode)psDEFUIModes.next();
                    if (StringHelper.Compare((String)iPSAppDEFUIMode.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSAppDEFUIMode);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFINPUTTIP, (boolean)false) == 0) {
            Iterator<IPSDEFInputTip> psDEFInputTips;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFIELD, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEField && (psDEFInputTips = (iPSDEField = (IPSDEField)psObjectList2.get(0)).getAllPSDEFInputTips()) != null) {
                while (psDEFInputTips.hasNext()) {
                    IPSDEFInputTip iPSDEFInputTip = psDEFInputTips.next();
                    if (StringHelper.Compare((String)iPSDEFInputTip.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEFInputTip);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFFORMITEM, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFUIMODE, strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEFUIMode) {
                iPSDEFUIMode = (IPSDEFUIMode)psObjectList2.get(0);
                list.add(iPSDEFUIMode.getPSDEFFormItem());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEFGRIDCOLUMN, (boolean)false) == 0) {
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEFUIMODE, strModelId);
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEFUIMode) {
                iPSDEFUIMode = (IPSDEFUIMode)psObjectList2.get(0);
                list.add(iPSDEFUIMode.getPSDEFGridColumn());
                return list;
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDEACTIONVR, (boolean)false) == 0) {
            Iterator<IPSDEActionVR> psDEActionVRs;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSDEACTION, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEAction && (psDEActionVRs = (iPSDEAction = (IPSDEAction)psObjectList2.get(0)).getPSDEActionVRs()) != null) {
                while (psDEActionVRs.hasNext()) {
                    IPSDEActionVR iPSDEActionVR = psDEActionVRs.next();
                    if (StringHelper.Compare((String)iPSDEActionVR.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSDEActionVR);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSSYSTDITEM, (boolean)false) == 0) {
            Iterator<IPSSysTestDataItem> psSysTestDataItems;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(PSSYSTESTDATA, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSSysTestData && (psSysTestDataItems = (iPSSysTestData = (IPSSysTestData)psObjectList2.get(0)).getPSSysTestDataItems()) != null) {
                while (psSysTestDataItems.hasNext()) {
                    IPSSysTestDataItem iPSSysTestDataItem = psSysTestDataItems.next();
                    if (StringHelper.Compare((String)iPSSysTestDataItem.getModelId(), (String)strModelId, (boolean)true) != 0) continue;
                    list.add(iPSSysTestDataItem);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDENOTIFY, (boolean)false) == 0) {
            Iterator<IPSDENotify> psDENotifys;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDATAENTITY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDENotifys = (iPSDataEntity = (IPSDataEntity)psObjectList2.get(0)).getAllPSDENotifies()) != null) {
                while (psDENotifys.hasNext()) {
                    IPSDENotify iPSDENotify = psDENotifys.next();
                    if (StringHelper.Compare((String)iPSDENotify.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDENotify);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSDENOTIFYTARGET, (boolean)false) == 0) {
            IPSDENotify iPSDENotify;
            Iterator<IPSDENotifyTarget> psDENotifyTargets;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSDENOTIFY, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psDENotifyTargets = (iPSDENotify = (IPSDENotify)psObjectList2.get(0)).getPSDENotifyTargets()) != null) {
                while (psDENotifyTargets.hasNext()) {
                    IPSDENotifyTarget iPSDENotifyTarget = psDENotifyTargets.next();
                    if (StringHelper.Compare((String)iPSDENotifyTarget.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSDENotifyTarget);
                    return list;
                }
            }
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSAPPWFDE, (boolean)false) == 0) {
            Iterator<IPSAppWFDE> psAppWFDEs;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSAPPWF, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psAppWFDEs = (iPSAppWF = (IPSAppWF)psObjectList2.get(0)).getPSAppWFDEs()) != null) {
                while (psAppWFDEs.hasNext()) {
                    IPSAppWFDE iPSAppWFDE = psAppWFDEs.next();
                    if (StringHelper.Compare((String)iPSAppWFDE.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSAppWFDE);
                    return list;
                }
            }
            return list;
        }
        if (strModelType.indexOf("PSEDITORCONTAINER$") == 0) {
            IPSDEGridFieldColumn iPSDEGridFieldColumn;
            psObjectList2 = ((IPSSystemUtil)((Object)iPSSystem)).getPSModels(strModelType = strModelType.substring(strModelType.indexOf("$") + 1), PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && psObjectList2.get(0) instanceof IPSDEGridFieldColumn && (iPSDEGridFieldColumn = (IPSDEGridFieldColumn)psObjectList2.get(0)).getFilterPSEditor() != null) {
                list.add(iPSDEGridFieldColumn.getFilterPSEditor().getPSEditorContainer());
                return list;
            }
            return list;
        }
        if (strModelType.equals(PSCTRLMSG)) {
            list.add(iPSSystem.getPSCtrlMsg(strModelId));
            return list;
        }
        if (StringHelper.Compare((String)strModelType, (String)PSCTRLMSGITEM, (boolean)false) == 0) {
            IPSCtrlMsg iPSCtrlMsg;
            Iterator<IPSCtrlMsgItem> psCtrlMsgItems;
            psObjectList2 = PSModels.getPSModels(iPSSystem, PSCTRLMSG, PSModels.getParentModelId(strModelId));
            if (psObjectList2.size() > 0 && (psCtrlMsgItems = (iPSCtrlMsg = (IPSCtrlMsg)psObjectList2.get(0)).getPSCtrlMsgItems()) != null) {
                while (psCtrlMsgItems.hasNext()) {
                    IPSCtrlMsgItem iPSCtrlMsgItem = psCtrlMsgItems.next();
                    if (StringHelper.Compare((String)iPSCtrlMsgItem.getModelId(), (String)strModelId, (boolean)false) != 0) continue;
                    list.add(iPSCtrlMsgItem);
                    return list;
                }
            }
            return list;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6a21\u578b\u7c7b\u578b[%1$s]", (Object)strModelType));
    }

    protected static String getParentModelId(String strModelId) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strModelId)) {
            throw new Exception("\u6a21\u578b\u6807\u8bc6\u65e0\u6548");
        }
        String[] items = strModelId.split("[#]");
        if (items != null && items.length > 1) {
            StringBuilderEx sb = new StringBuilderEx();
            int i = 0;
            while (i < items.length - 1) {
                if (i != 0) {
                    sb.append("#");
                }
                sb.append(items[i]);
                ++i;
            }
            return sb.toString();
        }
        throw new Exception("\u6a21\u578b\u6807\u8bc6\u65e0\u6548");
    }

    public static void setPSSysAppId(String strPSSysAppId) {
        psSysAppId.set(strPSSysAppId);
    }

    public static String getPSSysAppId() {
        return psSysAppId.get();
    }
}
