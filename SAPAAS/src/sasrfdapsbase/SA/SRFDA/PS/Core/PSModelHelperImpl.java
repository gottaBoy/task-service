/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelHelperBase;
import SA.SRFDA.PS.Core.PSModelHelperImplBase;
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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelHelperImpl
extends PSModelHelperImplBase {
    private static final Log log = LogFactory.getLog(PSModelHelperImpl.class);
    protected ThreadLocal<ArrayList<PSModelHelperBase.PSSystemStorage>> psSystemStorageStack = new ThreadLocal();
    protected ThreadLocal<ArrayList<PSModelHelperBase.PSSysAppStorage>> psSysAppStorageStack = new ThreadLocal();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strDBType = this.iDAGlobalHelper.getDAModelDB();
        if (!StringHelper.IsNullOrEmpty((String)strPSSysModelInstId)) {
            this.strPSSysModelInstId = strPSSysModelInstId;
            this.bAlwaysActive = bAlwaysActive;
            this.nLastActiveTime = System.currentTimeMillis();
            this.nLastSessionActiveTime = System.currentTimeMillis();
            if (this.bAlwaysActive) {
                PSSysModelInstGlobal.activeAlways((String)this.strPSSysModelInstId);
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psCodeListMap.get(strPSCodeListId) != null) {
            psSystemStorage.psCodeListMap.get(strPSCodeListId).CopyTo(psCodeList, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSCodeList(strPSCodeListId), psCodeList, "SYSTEM");
    }

    @Override
    public CallResult getPSDEFieldsNoSort(String strPSDataEntityId, Vector<PSDEField> psDEFieldList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEFieldList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFieldsNoSort(strPSDataEntityId), psDEFieldList, PSDEField.class.getName(), "SYSTEM", true);
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null) {
            if (psSystemStorage.psDataEntityMap.get(strPSDataEntityName) == null) {
                return CallResult.create((int)3);
            }
            psSystemStorage.psDataEntityMap.get(strPSDataEntityName).CopyTo(psDataEntity, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDataEntity(strPSSystemId, strPSDataEntityName), psDataEntity, "SYSTEM");
    }

    @Override
    public CallResult getPSDataEntity(String strPSDataEntityId, PSDataEntity psDataEntity) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDataEntityMap.get(strPSDataEntityId) != null) {
            psSystemStorage.psDataEntityMap.get(strPSDataEntityId).CopyTo(psDataEntity, true);
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDataEntityMap.get(strPSDataEntityId) != null) {
            psSysAppStorage.psDataEntityMap.get(strPSDataEntityId).CopyTo(psDataEntity, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDataEntity(strPSDataEntityId), psDataEntity, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDBConfigs(String strPSDataEntityId, Vector<PSDEDBConfig> psDEDBConfigList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDBConfigList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDBConfigList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDBConfigs(strPSDataEntityId), psDEDBConfigList, PSDEDBConfig.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null) {
            for (PSDEFDTColumn psDEFDTColumn : psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEFDTColumnList) {
                if (StringHelper.Compare((String)psDEFDTColumn.getDBType(), (String)strDBType, (boolean)true) != 0) continue;
                psDEFDTColumnList.add(psDEFDTColumn);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFDTColumns(strPSDataEntityId, strDBType), psDEFDTColumnList, PSDEFDTColumn.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppViewMap.containsKey(strPSApplicationViewId)) {
            psSysAppStorage.psAppViewMap.get(strPSApplicationViewId).CopyTo(psApplicationView, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSApplicationView(strPSApplicationViewId), psApplicationView, "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psApplicationViews, psSysAppStorage.psAppViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSApplicationViews(strPSApplicationId), psApplicationViews, PSAppView.class.getName(), "SYSTEM", true);
    }

    public CallResult getAllPSAppUtilPages2(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
        return this.selectMulti(this.getSQL_getAllPSAppUtilPages(strPSApplicationId), psAppUtilPages, PSAppUtilPage.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppUtilPages(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppUtilPages, psSysAppStorage.psAppUtilPageList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppUtilPages(strPSApplicationId), psAppUtilPages, PSAppUtilPage.class.getName(), "SYSTEM");
    }

    public CallResult getAllPSAppViewCodes2(String strPSApplicationId, Vector<PSAppViewCode> psApplicationViews) {
        return this.selectMulti(this.getSQL_getAllPSAppViewCodes(strPSApplicationId), psApplicationViews, PSAppViewCode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppViewCodes(String strPSApplicationId, Vector<PSAppViewCode> psApplicationViews) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psApplicationViews, psSysAppStorage.psAppViewCodeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppViewCodes(strPSApplicationId), psApplicationViews, PSAppViewCode.class.getName(), "SYSTEM");
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
        return StringHelper.Format((String)"select t1.* from V_SRFPSCTRLTYPE t1 where  t1.PSCTRLTYPEID='%1$s'", (Object)strPSControlTypeId);
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppModules, psSysAppStorage.psAppModuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppModules(strPSApplicationId), psAppModules, PSAppModule.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
            for (PSDEGridColumn psDEGridColumn : psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGridColumnList) {
                PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
                psDEGridColumn.CopyTo(psDEGridColumn2, true);
                psDEGridColumnList.add(psDEGridColumn2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGridColumns(strPSDEGridId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEChartAxeses(String strPSDEChartId, Vector<PSDEChartAxes> psDEChartAxesList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
            for (PSDEChartAxes psDEChartAxes : psSysAppStorage.psDEChartStorageMap.get((Object)strPSDEChartId).psDEChartAxesList) {
                PSDEChartAxes psDEChartAxes2 = new PSDEChartAxes();
                psDEChartAxes.CopyTo(psDEChartAxes2, true);
                psDEChartAxesList.add(psDEChartAxes2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEChartAxeses(strPSDEChartId), psDEChartAxesList, PSDEChartAxes.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEChartSerieses(String strPSDEChartId, Vector<PSDEChartSeries> psDEChartSeriesList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
            for (PSDEChartSeries psDEChartSeries : psSysAppStorage.psDEChartStorageMap.get((Object)strPSDEChartId).psDEChartSeriesList) {
                PSDEChartSeries psDEChartSeries2 = new PSDEChartSeries();
                psDEChartSeries.CopyTo(psDEChartSeries2, true);
                psDEChartSeriesList.add(psDEChartSeries2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEChartSerieses(strPSDEChartId), psDEChartSeriesList, PSDEChartSeries.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEChartSerieses(String strPSDEChartId) {
        if (strPSDEChartId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDECHARTPARAM_TMP t1 where  t1.PSDECHARTID='%1$s' AND  t1.srfdraftflag = 0 order by ORDERVALUE", (Object)strPSDEChartId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDECHARTPARAM t1 where  t1.PSDECHARTID='%1$s' order by ORDERVALUE", (Object)strPSDEChartId);
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId) != null) {
            for (PSDEToolbarItem psDEToolbarItem : psSysAppStorage.psDEToolbarStorageMap.get((Object)strPSDEToolbarId).psDEToolbarItemList) {
                PSDEToolbarItem psDEToolbarItem2 = new PSDEToolbarItem();
                psDEToolbarItem.CopyTo(psDEToolbarItem2, true);
                psDEToolbarItemList.add(psDEToolbarItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEToolbarItems(strPSDEToolbarId), psDEToolbarItemList, PSDEToolbarItem.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEUIActionsBySystem(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        return this.selectMulti(this.getSQL_getPSDEUIActionsBySystem(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEUIActions(String strPSDataEntityId, Vector<PSDEUIAction> psDEUIActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEUIActionList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEUIActionList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEUIActionList, psSysAppStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEUIActionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUIActions(strPSDataEntityId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDEUIActionList, psSystemStorage.psDEUIActionList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psDEUIActionList, psSysAppStorage.psDEUIActionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDEUIActions(strPSSystemId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFormDetail psDEFormDetail : psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFormDetailList) {
                PSDEFormDetail psDEFormDetail2 = new PSDEFormDetail();
                psDEFormDetail.CopyTo(psDEFormDetail2, true);
                psDEFormDetailList.add(psDEFormDetail2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFormDetail psDEFormDetail : psSystemStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFormDetailList) {
                PSDEFormDetail psDEFormDetail2 = new PSDEFormDetail();
                psDEFormDetail.CopyTo(psDEFormDetail2, true);
                psDEFormDetailList.add(psDEFormDetail2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFormDetails(strPSDEFormId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSFormDetailType(String strPSFormDetailTypeId, PSFormDetailType psFormDetailType) {
        return this.selectSingle(this.getSQL_getPSFormDetailType(strPSFormDetailTypeId), psFormDetailType, "SYSTEM");
    }

    @Override
    public CallResult getPSDEFGridColumnsByDataEntity(String strPSDEId, Vector<PSDEFGridColumn> psDEFGridColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEFGridColumnList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFGridColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFGridColumnsByDataEntity(strPSDEId), psDEFGridColumnList, PSDEFGridColumn.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEFGridColumnsBySystem(String strPSSystemId, Vector<PSDEFGridColumn> psDEFGridColumnList) {
        return this.selectMulti(this.getSQL_getPSDEFGridColumnsBySystem(strPSSystemId), psDEFGridColumnList, PSDEFGridColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFUIModesByDataEntity(String strPSDEId, Vector<PSDEFUIMode> psDEFUIModeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFUIModeList != null) {
            psDEFUIModeList.addAll(psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFUIModeList);
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFUIModesByDataEntity(strPSDEId), psDEFUIModeList, PSDEFUIMode.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEFUIModesBySystem(String strPSSystemId, Vector<PSDEFUIMode> psDEFUIModeList) {
        return this.selectMulti(this.getSQL_getPSDEFUIModesBySystem(strPSSystemId), psDEFUIModeList, PSDEFUIMode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFSearchModesByDataEntity(String strPSDEId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFSearchModeList != null) {
            psDEFSearchModeList.addAll(psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFSearchModeList);
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFSearchModesByDataEntity(strPSDEId), psDEFSearchModeList, PSDEFSearchMode.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEFSearchModesBySystem(String strPSSystemId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
        return this.selectMulti(this.getSQL_getPSDEFSearchModesBySystem(strPSSystemId), psDEFSearchModeList, PSDEFSearchMode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFDTColumnsByDataEntity(String strPSDEId, Vector<PSDEFDTColumn> psDEFDTColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEFDTColumnList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFDTColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFDTColumnsByDataEntity(strPSDEId), psDEFDTColumnList, PSDEFDTColumn.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppEditorTempls, psSysAppStorage.psAppEditorTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppEditorTempls(strPSApplicationId), psAppEditorTempls, PSAppEditorTempl.class.getName(), "SYSTEM");
    }

    public CallResult getAllPSAppEditorTempls2(String strPSApplicationId, Vector<PSAppEditorTempl> psAppEditorTempls) {
        return this.selectMulti(this.getSQL_getAllPSAppEditorTempls(strPSApplicationId), psAppEditorTempls, PSAppEditorTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDERs(String strPSDataEntityId, Vector<PSDER> psDERList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDERList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDERList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDERs(strPSDataEntityId), psDERList, PSDER.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDERsByMinorDEId(String strPSDataEntityId, Vector<PSDER> psDERList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDERList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDERList2)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDERsByMinorDEId(strPSDataEntityId), psDERList, PSDER.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppFuncs, psSysAppStorage.psAppFuncList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppFuncs(strPSApplicationId), psAppFuncs, PSAppFunc.class.getName(), "SYSTEM");
    }

    public CallResult getAllPSAppFuncs2(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
        return this.selectMulti(this.getSQL_getAllPSAppFuncs(strPSApplicationId), psAppFuncs, PSAppFunc.class.getName(), "SYSTEM");
    }

    public CallResult getPSAppMenuItemsBySysApp(String strPSSysAppId, Vector<PSAppMenuItem> psAppMenuItemList) {
        return this.selectMulti(this.getSQL_getPSAppMenuItemsBySysApp(strPSSysAppId), psAppMenuItemList, PSAppMenuItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppMenuItems(String strPSAppMenuId, Vector<PSAppMenuItem> psAppMenuItemList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null) {
            for (PSAppMenuItem psAppMenuItem : psSysAppStorage.psAppMenuStorageMap.get((Object)strPSAppMenuId).psAppMenuItemList) {
                PSAppMenuItem psAppMenuItem2 = new PSAppMenuItem();
                psAppMenuItem.CopyTo(psAppMenuItem2, true);
                psAppMenuItemList.add(psAppMenuItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSAppMenuItems(strPSAppMenuId), psAppMenuItemList, PSAppMenuItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppMenuItemType(String strPSAppMenuItemTypeId, PSAppMenuItemType psAppMenuItemType) {
        return this.selectSingle(this.getSQL_getPSAppMenuItemType(strPSAppMenuItemTypeId), psAppMenuItemType, "SYSTEM");
    }

    @Override
    public CallResult getPSDER(String strPSDERId, PSDER psDER) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDERMap.get(strPSDERId) != null) {
            psSystemStorage.psDERMap.get(strPSDERId).CopyTo(psDER, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDER(strPSDERId), psDER, "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDataQueryList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDataQueryList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueries(strPSDataEntityId), psDEDataQueryList, PSDEDataQuery.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null) {
            for (PSDEDataQueryJoin psDEDataQueryJoin : psSystemStorage.getPSDEDataQueryStorage((String)strPSDEDataQueryId).psDEDataQueryJoinList) {
                PSDEDataQueryJoin psDEDataQueryJoin2 = new PSDEDataQueryJoin();
                psDEDataQueryJoin.CopyTo(psDEDataQueryJoin2, true);
                psDEDataQueryJoinList.add(psDEDataQueryJoin2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueryJoins(strPSDEDataQueryId), psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEDataQueryJoinsBySystem(String strPSSystemId, Vector<PSDEDataQueryJoin> psDEDataQueryJoinList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryJoinsBySystem(strPSSystemId), psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataQueryConds(String strPSDEDataQueryId, Vector<PSDEDataQueryCond> psDEDataQueryCondList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null) {
            for (PSDEDataQueryCond psDEDataQueryCond : psSystemStorage.getPSDEDataQueryStorage((String)strPSDEDataQueryId).psDEDataQueryCondList) {
                PSDEDataQueryCond psDEDataQueryCond2 = new PSDEDataQueryCond();
                psDEDataQueryCond.CopyTo(psDEDataQueryCond2, true);
                psDEDataQueryCondList.add(psDEDataQueryCond2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueryConds(strPSDEDataQueryId), psDEDataQueryCondList, PSDEDataQueryCond.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEDataQueryCondsBySystem(String strPSSystemId, Vector<PSDEDataQueryCond> psDEDataQueryCondList) {
        return this.selectMulti(this.getSQL_getPSDEDataQueryCondsBySystem(strPSSystemId), psDEDataQueryCondList, PSDEDataQueryCond.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEDataQueryCondsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDQCOND t1 inner join t_srfpsdedataquery t2 on t1.PSDEDQID= t2.psdedataqueryid inner join t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid  where t3.pssystemid= '%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) order by ORDERVALUE ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDataSets(String strPSDataEntityId, Vector<PSDEDataSet> psDEDataSetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDataSetList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDataSetList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataSets(strPSDataEntityId), psDEDataSetList, PSDEDataSet.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null && this.fromList(psDEDSDQList, psSystemStorage.getPSDEDataSetStorage((String)strPSDataSetId).psDEDSDQList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDSDQs(strPSDataSetId), psDEDSDQList, PSDEDSDQ.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEDSDQsBySystem(String strPSSystemId, Vector<PSDEDSDQ> psDEDSDQList) {
        return this.selectMulti(this.getSQL_getPSDEDSDQsBySystem(strPSSystemId), psDEDSDQList, PSDEDSDQ.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDSGroupParams(String strPSDataSetId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null && this.fromList(psDEDSGroupParamList, psSystemStorage.getPSDEDataSetStorage((String)strPSDataSetId).psDEDSGroupParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDSGroupParams(strPSDataSetId), psDEDSGroupParamList, PSDEDSGroupParam.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDataEntityList, psSystemStorage.psDataEntityList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSDataEntities(strPSSystemId), psDataEntityList, PSDataEntity.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAjaxControlHandlers(String strPSSystemId, Vector<PSACHandler> psAjaxControlHandlerList) {
        return this.selectMulti(this.getSQL_getPSSysAjaxControlHandlers(strPSSystemId), psAjaxControlHandlerList, PSACHandler.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAjaxControlHandlers(String strPSDataEntityId, Vector<PSACHandler> psAjaxControlHandlerList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psAjaxControlHandlerList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psACHandlerList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSAjaxControlHandlers(strPSDataEntityId), psAjaxControlHandlerList, PSACHandler.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEViewViews(String strPSDEViewId, Vector<PSDEViewView> psDEViewViewList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null && this.fromList(psDEViewViewList, psSysAppStorage.psDEViewBaseStorageMap.get((Object)strPSDEViewId).psDEViewViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEViewViews(strPSDEViewId), psDEViewViewList, PSDEViewView.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEViewCtrls(String strPSDEViewId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
        ArrayList<PSDEViewCtrl> psDEViewCtrlList2;
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null && (psDEViewCtrlList2 = psSysAppStorage.psDEViewBaseStorageMap.get((Object)strPSDEViewId).psDEViewCtrlList) != null) {
            for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList2) {
                PSDEViewCtrl psDEViewCtrl2 = new PSDEViewCtrl();
                psDEViewCtrl.CopyTo(psDEViewCtrl2, true);
                psDEViewCtrlList.add(psDEViewCtrl2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEViewCtrls(strPSDEViewId), psDEViewCtrlList, PSDEViewCtrl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppViewRefs(String strPSAppViewId, Vector<PSAppViewRef> psAppViewRefList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId) != null && this.fromList(psAppViewRefList, psSysAppStorage.psAppViewStorageMap.get((Object)strPSAppViewId).psAppViewRefList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSAppViewRefs(strPSAppViewId), psAppViewRefList, PSAppViewRef.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionLogics(String strPSDEActionId, Vector<PSDEActionLogic> psDEActionLogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
            for (PSDEActionLogic psDEActionLogic : psSystemStorage.getPSDEActionStorage((String)strPSDEActionId).psDEActionLogicList) {
                PSDEActionLogic psDEActionLogic2 = new PSDEActionLogic();
                psDEActionLogic.CopyTo(psDEActionLogic2, true);
                psDEActionLogicList.add(psDEActionLogic2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionLogics(strPSDEActionId), psDEActionLogicList, PSDEActionLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionParams(String strPSDEActionId, Vector<PSDEActionParam> psDEActionParamList) {
        if (this.getModelInstVer() < 353) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
            for (PSDEActionParam psDEActionParam : psSystemStorage.getPSDEActionStorage((String)strPSDEActionId).psDEActionParamList) {
                PSDEActionParam psDEActionParam2 = new PSDEActionParam();
                psDEActionParam.CopyTo(psDEActionParam2, true);
                psDEActionParamList.add(psDEActionParam2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionParams(strPSDEActionId), psDEActionParamList, PSDEActionParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActions(String strPSDataEntityId, Vector<PSDEAction> psDEActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEActionList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEActionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActions(strPSDataEntityId), psDEActionList, PSDEAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSCodeLists(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psCodeListList, psCodeListList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSCodeLists(strPSSystemId), psCodeListList, PSCodeList.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSCodeItems(String strPSCodeListId, Vector<PSCodeItem> psCodeItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSCodeListStorage(strPSCodeListId) != null && this.copyList(psSystemStorage.getPSCodeListStorage((String)strPSCodeListId).psCodeItemList, psCodeItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSCodeItems(strPSCodeListId), psCodeItemList, PSCodeItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppViewLogics(String strPSAppViewId, Vector<PSAppViewLogic> psAppViewLogicList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppViewStorageMap.get(strPSAppViewId) != null && this.fromList(psAppViewLogicList, psSysAppStorage.psAppViewStorageMap.get((Object)strPSAppViewId).psAppViewLogicList)) {
            return new CallResult();
        }
        return new CallResult();
    }

    @Override
    public CallResult getPSDEFValueRulesByDataEntity(String strPSDEId, Vector<PSDEFValueRule> psDEFValueRuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEFValueRuleList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFValueRuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFValueRulesByDataEntity(strPSDEId), psDEFValueRuleList, PSDEFValueRule.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFValueRuleConds(String strPSDEFValueRuleId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEFValueRuleStorage(strPSDEFValueRuleId) != null) {
            for (PSDEFValueRuleCond psDEFValueRuleCond : psSystemStorage.getPSDEFValueRuleStorage((String)strPSDEFValueRuleId).psDEFValueRuleCondList) {
                PSDEFValueRuleCond psDEFValueRuleCond2 = new PSDEFValueRuleCond();
                psDEFValueRuleCond.CopyTo(psDEFValueRuleCond2, true);
                psDEFValueRuleCondList.add(psDEFValueRuleCond2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFValueRuleConds(strPSDEFValueRuleId), psDEFValueRuleCondList, PSDEFValueRuleCond.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEACModes(String strPSDataEntityId, Vector<PSDEACMode> psDEACModeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEACModeList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEACModeList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEACModeList, psSysAppStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEACModeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEACModes(strPSDataEntityId), psDEACModeList, PSDEACMode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEACModeItems(String strPSDEACModeId, Vector<PSDEACModeItem> psDEACModeItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEACModeStorage(strPSDEACModeId) != null) {
            for (PSDEACModeItem psDEACModeItem : psSystemStorage.getPSDEACModeStorage((String)strPSDEACModeId).psDEACModeItemList) {
                PSDEACModeItem psDEACModeItem2 = new PSDEACModeItem();
                psDEACModeItem.CopyTo(psDEACModeItem2, true);
                psDEACModeItemList.add(psDEACModeItem2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDEACModeStorage(strPSDEACModeId) != null) {
            for (PSDEACModeItem psDEACModeItem : psSysAppStorage.getPSDEACModeStorage((String)strPSDEACModeId).psDEACModeItemList) {
                PSDEACModeItem psDEACModeItem2 = new PSDEACModeItem();
                psDEACModeItem.CopyTo(psDEACModeItem2, true);
                psDEACModeItemList.add(psDEACModeItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEACModeItems(strPSDEACModeId), psDEACModeItemList, PSDEACModeItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDRGroups(String strPSDataEntityId, Vector<PSDEDRGroup> psDEDRGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDRGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDRGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDRGroups(strPSDataEntityId), psDEDRGroupList, PSDEDRGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDRItems(String strPSDEId, Vector<PSDEDRItem> psDEDRItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDRItemList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEDRItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDRItems(strPSDEId), psDEDRItemList, PSDEDRItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDRDetails(String strPSDEDRId, Vector<PSDEDRDetail> psDEDRDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataRelationStorage(strPSDEDRId) != null) {
            for (PSDEDRDetail psDEDRDetail : psSystemStorage.getPSDEDataRelationStorage((String)strPSDEDRId).psDEDRDetailList) {
                PSDEDRDetail psDEDRDetail2 = new PSDEDRDetail();
                psDEDRDetail.CopyTo(psDEDRDetail2, true);
                psDEDRDetailList.add(psDEDRDetail2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDRDetails(strPSDEDRId), psDEDRDetailList, PSDEDRDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppMenus(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppMenus, psSysAppStorage.psAppMenuList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppMenus(strPSApplicationId), psAppMenus, PSAppMenu.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppMenu(String strPSAppMenuId, PSAppMenu psAppMenu) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null) {
            psSysAppStorage.psAppMenuStorageMap.get((Object)strPSAppMenuId).psAppMenu.CopyTo(psAppMenu, false);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSAppMenu(strPSAppMenuId), psAppMenu, "SYSTEM");
    }

    @Override
    public CallResult getPSDEGrid(String strPSDEGridId, PSDEGrid psDEGrid) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.containsKey(strPSDEGridId)) {
            psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGrid.CopyTo(psDEGrid, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEGrid(strPSDEGridId), psDEGrid, "SYSTEM");
    }

    @Override
    public CallResult getPSDEChart(String strPSDEChartId, PSDEChart psDEChart) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null) {
            psSysAppStorage.psDEChartStorageMap.get((Object)strPSDEChartId).psDEChart.CopyTo(psDEChart, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEChart(strPSDEChartId), psDEChart, "SYSTEM");
    }

    @Override
    public CallResult getPSDEReport(String strPSDEReportId, PSDEReport psDEReport) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEReportStorageMap.get(strPSDEReportId) != null) {
            psSysAppStorage.psDEReportStorageMap.get((Object)strPSDEReportId).psDEReport.CopyTo(psDEReport, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEReport(strPSDEReportId), psDEReport, "SYSTEM");
    }

    @Override
    public CallResult getPSDEToolbar(String strPSDEToolbarId, PSDEToolbar psDEToolbar) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEToolbarStorageMap.containsKey(strPSDEToolbarId)) {
            psSysAppStorage.psDEToolbarStorageMap.get((Object)strPSDEToolbarId).psDEToolbar.CopyTo(psDEToolbar, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEToolbar(strPSDEToolbarId), psDEToolbar, "SYSTEM");
    }

    @Override
    public CallResult getPSDEForm(String strPSDEFormId, PSDEForm psDEForm) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.containsKey(strPSDEFormId)) {
            psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEForm.CopyTo(psDEForm, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEForm(strPSDEFormId), psDEForm, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataRelations(String strPSDEId, Vector<PSDEDataRelation> psDEDataRelationList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataRelationList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataRelationList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataRelations(strPSDEId), psDEDataRelationList, PSDEDataRelation.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSDERs(String strPSSystemId, Vector<PSDER> psDataEntityList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDataEntityList, psSystemStorage.psDERList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSDERs(strPSSystemId), psDataEntityList, PSDER.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataQueryCodes(String strPSDEDataQueryId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryStorage(strPSDEDataQueryId) != null && this.fromList(psDEDataQueryCodeList, psSystemStorage.getPSDEDataQueryStorage((String)strPSDEDataQueryId).psDEDataQueryCodeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodes(strPSDEDataQueryId), psDEDataQueryCodeList, PSDEDataQueryCode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId) != null && this.fromList(psDEDataQueryCodeExpList, psSystemStorage.getPSDEDataQueryCodeStorage((String)strPSDEDataQueryCodeId).psDEDataQueryCodeExpList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeExps(strPSDEDataQueryCodeId), psDEDataQueryCodeExpList, PSDEDataQueryCodeExp.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFDLogics(String strPSDEFormId, Vector<PSDEFDLogic> psDEFDLogicList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFDLogic psDEFDLogic : psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFDLogicList) {
                PSDEFDLogic psDEFDLogic2 = new PSDEFDLogic();
                psDEFDLogic.CopyTo(psDEFDLogic2, true);
                psDEFDLogicList.add(psDEFDLogic2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFDLogic psDEFDLogic : psSystemStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFDLogicList) {
                PSDEFDLogic psDEFDLogic2 = new PSDEFDLogic();
                psDEFDLogic.CopyTo(psDEFDLogic2, true);
                psDEFDLogicList.add(psDEFDLogic2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFDLogics(strPSDEFormId), psDEFDLogicList, PSDEFDLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFDLogics(String strPSDEFormId) {
        if (strPSDEFormId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEFDLOGIC_TMP t1 inner join t_srfpsdeformdetail_TMP t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' AND  t1.srfdraftflag = 0 order by t1.ORDERVALUE", (Object)strPSDEFormId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEFDLOGIC t1 inner join t_srfpsdeformdetail t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID where t2.PSDEFORMID='%1$s' order by t1.ORDERVALUE", (Object)strPSDEFormId);
    }

    public CallResult getPSDEFDLogicsBySystem(String strPSSystemId, Vector<PSDEFDLogic> psDEFDLogicList) {
        return this.selectMulti(this.getSQL_getPSDEFDLogicsBySystem(strPSSystemId), psDEFDLogicList, PSDEFDLogic.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEFDLogicsBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.*,t2.PSDEFORMID from V_SRFPSDEFDLOGIC t1 inner join t_srfpsdeformdetail t2 on t1.PSDEFORMDETAILID = t2.PSDEFORMDETAILID  inner join t_srfpsdeform t3 on t2.psdeformid = t3.psdeformid inner join t_srfpsdataentity t4 on t3.psdeid = t4.psdataentityid  where t4.PSSYSTEMID='%1$s'  and (t4.DYNAMODELFLAG IS NULL OR t4.DYNAMODELFLAG = 0) order by t1.ORDERVALUE", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataQueryCodeStorage(strPSDEDataQueryCodeId) != null && this.fromList(psDEDataQueryCodeCondList, psSystemStorage.getPSDEDataQueryCodeStorage((String)strPSDEDataQueryCodeId).psDEDataQueryCodeCondList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataQueryCodeConds(strPSDEDataQueryCodeId), psDEDataQueryCodeCondList, PSDEDataQueryCodeCond.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataView(String strPSDEDataViewId, PSDEDataView psDEDataView) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null) {
            psSysAppStorage.psDEDataViewStorageMap.get((Object)strPSDEDataViewId).psDEDataView.CopyTo(psDEDataView, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEDataView(strPSDEDataViewId), psDEDataView, "SYSTEM");
    }

    protected String getSQL_getPSDEDataView(String strPSDEDataViewId) {
        if (strPSDEDataViewId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEDATAVIEW_TMP t1 where  t1.PSDEDATAVIEWID='%1$s'", (Object)strPSDEDataViewId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEDATAVIEW t1 where  t1.PSDEDATAVIEWID='%1$s'", (Object)strPSDEDataViewId);
    }

    @Override
    public CallResult getPSDEDataViewItems(String strPSDEDataViewId, Vector<PSDEDataViewItem> psDEDataViewItemDataView) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null) {
            for (PSDEDataViewItem psDEDataViewItem : psSysAppStorage.psDEDataViewStorageMap.get((Object)strPSDEDataViewId).psDEDataViewItemList) {
                PSDEDataViewItem psDEDataViewItem2 = new PSDEDataViewItem();
                psDEDataViewItem.CopyTo(psDEDataViewItem2, true);
                psDEDataViewItemDataView.add(psDEDataViewItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataViewItems(strPSDEDataViewId), psDEDataViewItemDataView, PSDEDataViewItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEUIActionGroups(String strPSDataEntityId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUIActionGroups(strPSDataEntityId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId) != null && this.fromList(psDEUIActionGroupDetailList, psSystemStorage.getPSDEUIActionGroupStorage((String)strPSDEUIActionGroupId).psDEUIActionGroupDetailList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDEUIActionGroupStorage(strPSDEUIActionGroupId) != null && this.fromList(psDEUIActionGroupDetailList, psSysAppStorage.getPSDEUIActionGroupStorage((String)strPSDEUIActionGroupId).psDEUIActionGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUIActionGroupDetails(strPSDEUIActionGroupId), psDEUIActionGroupDetailList, PSDEUIActionGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDELogicNodes(String strPSDELogicId, Vector<PSDELogicNode> psDELogicNodeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNode psDELogicNode : psSystemStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicNodeList) {
                PSDELogicNode psDELogicNode2 = new PSDELogicNode();
                psDELogicNode.CopyTo(psDELogicNode2, true);
                psDELogicNodeList.add(psDELogicNode2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNode psDELogicNode : psSysAppStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicNodeList) {
                PSDELogicNode psDELogicNode2 = new PSDELogicNode();
                psDELogicNode.CopyTo(psDELogicNode2, true);
                psDELogicNodeList.add(psDELogicNode2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogicNodes(strPSDELogicId), psDELogicNodeList, PSDELogicNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicNodes(String strPSDELogicId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICNODE t1 where  t1.PSDELOGICID='%1$s' ", (Object)strPSDELogicId);
    }

    public CallResult getPSDELogicNodesBySystem(String strPSSystemId, Vector<PSDELogicNode> psDELogicNodeList) {
        return this.selectMulti(this.getSQL_getPSDELogicNodesBySystem(strPSSystemId), psDELogicNodeList, PSDELogicNode.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDELogicNodesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDELOGICNODE t1 inner join T_SRFPSDELOGIC t2 on t1.PSDELOGICID= t2.PSDELOGICID inner join T_SRFPSDATAENTITY t3 on t2.PSDEID = t3.PSDATAENTITYID  where t3.PSSYSTEMID= '%1$s' and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0)", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDELogicLinks(String strPSDELogicId, Vector<PSDELogicLink> psDELogicLinkList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLink psDELogicLink : psSystemStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicLinkList) {
                PSDELogicLink psDELogicLink2 = new PSDELogicLink();
                psDELogicLink.CopyTo(psDELogicLink2, true);
                psDELogicLinkList.add(psDELogicLink2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLink psDELogicLink : psSysAppStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicLinkList) {
                PSDELogicLink psDELogicLink2 = new PSDELogicLink();
                psDELogicLink.CopyTo(psDELogicLink2, true);
                psDELogicLinkList.add(psDELogicLink2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogicLinks(strPSDELogicId), psDELogicLinkList, PSDELogicLink.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDELogicLinkConds(String strPSDELogicId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLinkCond psDELogicLinkCond : psSystemStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicLinkCondList) {
                PSDELogicLinkCond psDELogicLinkCond2 = new PSDELogicLinkCond();
                psDELogicLinkCond.CopyTo(psDELogicLinkCond2, true);
                psDELogicLinkCondList.add(psDELogicLinkCond2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicLinkCond psDELogicLinkCond : psSysAppStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicLinkCondList) {
                PSDELogicLinkCond psDELogicLinkCond2 = new PSDELogicLinkCond();
                psDELogicLinkCond.CopyTo(psDELogicLinkCond2, true);
                psDELogicLinkCondList.add(psDELogicLinkCond2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogicLinkConds(strPSDELogicId), psDELogicLinkCondList, PSDELogicLinkCond.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDELogics(String strPSDataEntityId, Vector<PSDELogic> psDELogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDELogicList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDELogicList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDELogicList, psSysAppStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDELogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogics(strPSDataEntityId), psDELogicList, PSDELogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDELogicNodeParams(String strPSDELogicId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNodeParam psDELogicNodeParam : psSystemStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicNodeParamList) {
                PSDELogicNodeParam psDELogicNodeParam2 = new PSDELogicNodeParam();
                psDELogicNodeParam.CopyTo(psDELogicNodeParam2, true);
                psDELogicNodeParamList.add(psDELogicNodeParam2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicNodeParam psDELogicNodeParam : psSysAppStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicNodeParamList) {
                PSDELogicNodeParam psDELogicNodeParam2 = new PSDELogicNodeParam();
                psDELogicNodeParam.CopyTo(psDELogicNodeParam2, true);
                psDELogicNodeParamList.add(psDELogicNodeParam2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogicNodeParams(strPSDELogicId), psDELogicNodeParamList, PSDELogicNodeParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDELogicParams(String strPSDELogicId, Vector<PSDELogicParam> psDELogicParamList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicParam psDELogicParam : psSystemStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicParamList) {
                PSDELogicParam psDELogicParam2 = new PSDELogicParam();
                psDELogicParam.CopyTo(psDELogicParam2, true);
                psDELogicParamList.add(psDELogicParam2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDELogicStorage(strPSDELogicId) != null) {
            for (PSDELogicParam psDELogicParam : psSysAppStorage.getPSDELogicStorage((String)strPSDELogicId).psDELogicParamList) {
                PSDELogicParam psDELogicParam2 = new PSDELogicParam();
                psDELogicParam.CopyTo(psDELogicParam2, true);
                psDELogicParamList.add(psDELogicParam2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDELogicParams(strPSDELogicId), psDELogicParamList, PSDELogicParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEPredefinedViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEViewBaseList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEPredefinedViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEPredefinedViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
    }

    @Override
    public CallResult getPSDEViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEViewBaseList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEViews(strPSDataEntityId), psDEViewBaseList, PSDEViewBase.class.getName(), "SYSTEM", true);
    }

    @Override
    public CallResult getPSDEEditForms(String strPSDataEntityId, Vector<PSDEForm> psDEEditFormList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEEditFormList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEEditFormList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEEditForms(strPSDataEntityId), psDEEditFormList, PSDEForm.class.getName(), "SYSTEM", true);
    }

    @Override
    public CallResult getPSDEFIUpdates(String strPSDEFormId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFIUpdate psDEFIUpdate : psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFIUpdateList) {
                PSDEFIUpdate psDEFIUpdate2 = new PSDEFIUpdate();
                psDEFIUpdate.CopyTo(psDEFIUpdate2, true);
                psDEFIUpdateList.add(psDEFIUpdate2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFIUpdates(strPSDEFormId), psDEFIUpdateList, PSDEFIUpdate.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFIUDetails(String strPSDEFormId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null) {
            for (PSDEFIUDetail psDEFIUDetail : psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFIUDetailList) {
                PSDEFIUDetail psDEFIUDetail2 = new PSDEFIUDetail();
                psDEFIUDetail.CopyTo(psDEFIUDetail2, true);
                psDEFIUDetailList.add(psDEFIUDetail2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFIUDetails(strPSDEFormId), psDEFIUDetailList, PSDEFIUDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFormRFs(String strPSDEFormId, Vector<PSDEFormRF> psDEFormRFList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null && this.fromList(psDEFormRFList, psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFormRFList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFormRFs(strPSDEFormId), psDEFormRFList, PSDEFormRF.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFormItemVRs(String strPSDEFormId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null && this.fromList(psDEFormItemVRList, psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFormItemVRList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFormItemVRs(strPSDEFormId), psDEFormItemVRList, PSDEFormItemVR.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMaps(String strPSDEId, Vector<PSDEMap> psDEMapList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEMapList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEMapList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEMapList, psSysAppStorage.getPSDataEntityStorage((String)strPSDEId).psDEMapList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMaps(strPSDEId), psDEMapList, PSDEMap.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMapDetails(String strPSDEMapId, Vector<PSDEMapDetail> psDEMapDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
            for (PSDEMapDetail psDEMapDetail : psSystemStorage.getPSDEMapStorage((String)strPSDEMapId).psDEMapDetailList) {
                PSDEMapDetail psDEMapDetail2 = new PSDEMapDetail();
                psDEMapDetail.CopyTo(psDEMapDetail2, true);
                psDEMapDetailList.add(psDEMapDetail2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMapDetails(strPSDEMapId), psDEMapDetailList, PSDEMapDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMapActions(String strPSDEMapId, Vector<PSDEMapAction> psDEMapActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
            for (PSDEMapAction psDEMapAction : psSystemStorage.getPSDEMapStorage((String)strPSDEMapId).psDEMapActionList) {
                PSDEMapAction psDEMapAction2 = new PSDEMapAction();
                psDEMapAction.CopyTo(psDEMapAction2, true);
                psDEMapActionList.add(psDEMapAction2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMapActions(strPSDEMapId), psDEMapActionList, PSDEMapAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMapDataQueries(String strPSDEMapId, Vector<PSDEMapDataQuery> psDEMapDataQueryList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
            for (PSDEMapDataQuery psDEMapDataQuery : psSystemStorage.getPSDEMapStorage((String)strPSDEMapId).psDEMapDataQueryList) {
                PSDEMapDataQuery psDEMapDataQuery2 = new PSDEMapDataQuery();
                psDEMapDataQuery.CopyTo(psDEMapDataQuery2, true);
                psDEMapDataQueryList.add(psDEMapDataQuery2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMapDataQuerys(strPSDEMapId), psDEMapDataQueryList, PSDEMapDataQuery.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMapDataSets(String strPSDEMapId, Vector<PSDEMapDataSet> psDEMapDataSetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMapStorage(strPSDEMapId) != null) {
            for (PSDEMapDataSet psDEMapDataSet : psSystemStorage.getPSDEMapStorage((String)strPSDEMapId).psDEMapDataSetList) {
                PSDEMapDataSet psDEMapDataSet2 = new PSDEMapDataSet();
                psDEMapDataSet.CopyTo(psDEMapDataSet2, true);
                psDEMapDataSetList.add(psDEMapDataSet2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMapDataSets(strPSDEMapId), psDEMapDataSetList, PSDEMapDataSet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSWorkflows(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psWorkflowList, psSystemStorage.psWorkflowList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSWorkflows(strPSSystemId), psWorkflowList, PSWorkflow.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFVersions(String strPSWFId, Vector<PSWFVersion> psVersionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWorkflowStorage(strPSWFId) != null && this.fromList(psVersionList, psSystemStorage.getPSWorkflowStorage((String)strPSWFId).psWFVersionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSVersions(strPSWFId), psVersionList, PSWFVersion.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFProcesses(String strPSWFVersionId, Vector<PSWFProcess> psWFProcessList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFProcessList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFProcessList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFProcesses(strPSWFVersionId), psWFProcessList, PSWFProcess.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFLinks(String strPSWFVersionId, Vector<PSWFLink> psWFLinkList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFLinkList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFLinkList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFLinks(strPSWFVersionId), psWFLinkList, PSWFLink.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFLinkConds(String strPSWFVersionId, Vector<PSWFLinkCond> psWFLinkCondList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFLinkCondList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFLinkCondList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFLinkConds(strPSWFVersionId), psWFLinkCondList, PSWFLinkCond.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFProcParams(String strPSWFVersionId, Vector<PSWFProcParam> psWFProcParamList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFProcParamList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFProcParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFProcParams(strPSWFVersionId), psWFProcParamList, PSWFProcParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFProcSubWFs(String strPSWFVersionId, Vector<PSWFProcSubWF> psWFProcSubWFList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFProcSubWFList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFProcSubWFList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFProcSubWFs(strPSWFVersionId), psWFProcSubWFList, PSWFProcSubWF.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFProcRoles(String strPSWFVersionId, Vector<PSWFProcRole> psWFProcRoleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFProcRoleList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFProcRoleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSProcRoles(strPSWFVersionId), psWFProcRoleList, PSWFProcRole.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFLinkRoles(String strPSWFVersionId, Vector<PSWFLinkRole> psWFLinkRoleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psWFLinkRoleList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psWFLinkRoleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSLinkRoles(strPSWFVersionId), psWFLinkRoleList, PSWFLinkRole.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFDEs(String strPSDataEntityId, Vector<PSWFDE> psWFDEList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psWFDEList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psWFDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFDEs(strPSDataEntityId), psWFDEList, PSWFDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFDEsByWF(String strPSWFId, Vector<PSWFDE> psWFDEList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWorkflowStorage(strPSWFId) != null && this.fromList(psWFDEList, psSystemStorage.getPSWorkflowStorage((String)strPSWFId).psWFDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFDEsByWF(strPSWFId), psWFDEList, PSWFDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFUIActions(String strPSWFVersionId, Vector<PSDEUIAction> psDEUIActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psDEUIActionList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psDEUIActionList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psDEUIActionList, psSysAppStorage.getPSWFVersionStorage((String)strPSWFVersionId).psDEUIActionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFUIActions(strPSWFVersionId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFUIActions2(String strPSWorkflowId, Vector<PSDEUIAction> psDEUIActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWorkflowStorage(strPSWorkflowId) != null && this.fromList(psDEUIActionList, psSystemStorage.getPSWorkflowStorage((String)strPSWorkflowId).psDEUIActionList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId) != null && this.fromList(psDEUIActionList, psSysAppStorage.getPSWorkflowStorage((String)strPSWorkflowId).psDEUIActionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFUIActions2(strPSWorkflowId), psDEUIActionList, PSDEUIAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFUIActionGroups(String strPSWFVersionId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSWFVersionStorage((String)strPSWFVersionId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSWFVersionStorage(strPSWFVersionId) != null && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSWFVersionStorage((String)strPSWFVersionId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFUIActionGroups(strPSWFVersionId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWFUIActionGroups2(String strPSWorkflowId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWorkflowStorage(strPSWorkflowId) != null && this.fromList(psDEUIActionGroupList, psSystemStorage.getPSWorkflowStorage((String)strPSWorkflowId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSWorkflowStorage(strPSWorkflowId) != null && this.fromList(psDEUIActionGroupList, psSysAppStorage.getPSWorkflowStorage((String)strPSWorkflowId).psDEUIActionGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWFUIActionGroups2(strPSWorkflowId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEViewBase(String strPSDEViewBaseId, PSDEViewBase psDEViewBase) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseMap.get(strPSDEViewBaseId) != null) {
            psSysAppStorage.psDEViewBaseMap.get(strPSDEViewBaseId).CopyTo(psDEViewBase, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEViewBase(strPSDEViewBaseId), psDEViewBase, "SYSTEM");
    }

    @Override
    public synchronized void startLoadPSSystem(String strPSSystemId, int nLoadLevel) throws Exception {
        this.active();
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.createPSSystemStorage(strPSSystemId, nLoadLevel);
        ArrayList<PSModelHelperBase.PSSystemStorage> stack = this.psSystemStorageStack.get();
        if (stack == null) {
            stack = new ArrayList();
            this.psSystemStorageStack.set(stack);
        }
        stack.add(0, psSystemStorage);
    }

    /*
     * Opcode count of 15677 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     * WARNING - void declaration
     */
    protected PSModelHelperBase.PSSystemStorage createPSSystemStorage(String strPSSystemId, int nLoadLevel) throws Exception {
        Vector<PSDEFInputTipSet> psDEFInputTipSetList;
        void var10_1512;
        Vector vector;
        void var10_1509;
        void var10_1506;
        void var11_559;
        void var10_1450;
        void var11_552;
        void var10_1446;
        void var10_1435;
        void var10_1400;
        Vector<PSDEDataSync> psDEDataSyncList;
        PSModelHelperBase.PSDEServiceAPIStorage psDEServiceAPIStorage;
        void var10_1381;
        void var10_1378;
        PSModelHelperBase.PSSysServiceAPIStorage psSysServiceAPIStorage;
        void var10_1375;
        void var11_473;
        void var11_470;
        void var10_1368;
        void var10_1350;
        Vector<PSSysDBValueFunc> psSysDBValueFuncList;
        Vector<PSSysSampleValue> psSysSampleValueList;
        void var10_1077;
        void var10_1070;
        void var10_1063;
        Vector vector2;
        Vector<PSDEDataExport> psDEDataExportList;
        void var10_1048;
        void var10_1045;
        Vector<PSWFDE> psWFDEList;
        Iterator psDEACModeStorage;
        void var10_986;
        void var10_979;
        void var10_972;
        void var10_969;
        void var10_966;
        void var10_963;
        Vector<PSACHandler> psACHandlerList;
        PSModelHelperBase.PSDEActionStorage psDEActionStorage;
        void var10_936;
        PSSysModelLog psDEDQLog;
        Vector<PSDEDataQuery> psDEDataQueryList;
        void var10_873;
        Vector<PSDEDataSet> psDEDataSetList;
        void var10_862;
        Vector<PSDEFValueRule> psDEFValueRuleList;
        void var10_793;
        void var10_790;
        Vector<PSSysPDTView> psSysPDTViewList;
        void var10_747;
        Vector<PSSysMsgTempl> psSysMsgTemplList;
        PSSysModelLog psSysEditorStyleLog;
        Vector<PSSysEditorStyle> psSysEditorStyleList;
        PSSysModelLog psSysDEFTypeLog;
        Vector<PSSysDEFType> psSysDEFTypeList;
        void var10_646;
        PSSysModelLog psSysImageLog;
        Vector<PSSysImage> psSysImageList;
        void var10_615;
        long nBeginTime = System.currentTimeMillis();
        PSModelHelperBase.PSSystemStorage psSystemStorage = new PSModelHelperBase.PSSystemStorage();
        psSystemStorage.strPSSystemId = strPSSystemId;
        psSystemStorage.nLoadLevel = nLoadLevel;
        PSModelHelperBase.PSSysModelCache psSysModelCache = this.getPSSysModelCache("SYS:" + strPSSystemId);
        PSSystem psSystem = new PSSystem();
        CallResult callResult4 = this.getPSSystem(strPSSystemId, psSystem);
        if (callResult4.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult4.getErrorInfo()));
        }
        if (psSystem.getCREATEDATE() != null) {
            String strModelCacheTag = DateHelper.toDateTimeString((Date)psSystem.getCREATEDATE());
            if (!StringHelper.IsNullOrEmpty((String)psSysModelCache.getCacheTag()) && StringHelper.Compare((String)psSysModelCache.getCacheTag(), (String)strModelCacheTag, (boolean)false) != 0) {
                this.resetCache();
                psSysModelCache = this.getPSSysModelCache("SYS:" + strPSSystemId);
            }
            psSysModelCache.setCacheTag(strModelCacheTag);
        } else {
            log.warn((Object)StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u5efa\u7acb\u65f6\u95f4\u4e3a\u7a7a", (Object)strPSSystemId));
        }
        HashMap<String, PSSysModelLog> psSysModelLogMap = new HashMap<String, PSSysModelLog>();
        Vector<PSSysModelLog> psSysModelLogList = new Vector<PSSysModelLog>();
        CallResult callResult5 = this.getPSSysModelLogs(strPSSystemId, psSysModelLogList);
        if (callResult5.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6a21\u578b\u65e5\u5fd7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult5.getErrorInfo()));
        }
        for (PSSysModelLog pSSysModelLog : psSysModelLogList) {
            if (psSysModelLogMap.containsKey(pSSysModelLog.getPSSYSMODELLOGNAME())) continue;
            psSysModelLogMap.put(pSSysModelLog.getPSSYSMODELLOGNAME(), pSSysModelLog);
        }
        PSSysModelLog psCodeListLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCODELIST"));
        Vector<PSCodeList> psCodeListList = psSysModelCache.getModelList("PSCODELIST", psCodeListLog);
        if (psCodeListList == null) {
            psCodeListList = new Vector<PSCodeList>();
            CallResult callResult = this.getAllPSCodeLists2(strPSSystemId, psCodeListList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSCODELIST", psCodeListLog, psCodeListList);
        }
        psSystemStorage.psCodeListList.addAll(psCodeListList);
        for (PSCodeList pSCodeList : psCodeListList) {
            psSystemStorage.psCodeListMap.put(pSCodeList.getPSCODELISTID(), pSCodeList);
            psSystemStorage.getPSCodeListStorage((String)pSCodeList.getPSCODELISTID()).psCodeList = pSCodeList;
        }
        PSSysModelLog psCodeItemLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCODEITEM"));
        Vector vector3 = psSysModelCache.getModelList("PSCODEITEM", psCodeListLog, psCodeItemLog);
        if (vector3 == null) {
            Vector<PSCodeItem> vector4 = new Vector<PSCodeItem>();
            CallResult callResult = this.getPSCodeItemsBySystem(strPSSystemId, vector4);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSCODEITEM", psCodeListLog, psCodeItemLog, vector4);
        }
        for (PSCodeItem pSCodeItem : var10_615) {
            psSystemStorage.getPSCodeListStorage((String)pSCodeItem.getPSCODELISTID()).psCodeItemList.add(pSCodeItem);
        }
        if (this.getModelInstVer() >= 697) {
            void var10_622;
            PSSysModelLog psThresholdGroupLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSTHRESHOLDGROUP"));
            Vector<PSThresholdGroup> psThresholdGroupList = psSysModelCache.getModelList("PSTHRESHOLDGROUP", psThresholdGroupLog);
            if (psThresholdGroupList == null) {
                psThresholdGroupList = new Vector<PSThresholdGroup>();
                CallResult callResult = this.getAllPSThresholdGroups2(strPSSystemId, psThresholdGroupList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9608\u503c\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSTHRESHOLDGROUP", psThresholdGroupLog, psThresholdGroupList);
            }
            psSystemStorage.psThresholdGroupList.addAll(psThresholdGroupList);
            for (PSThresholdGroup pSThresholdGroup : psThresholdGroupList) {
                psSystemStorage.psThresholdGroupMap.put(pSThresholdGroup.getPSTHRESHOLDGROUPID(), pSThresholdGroup);
                psSystemStorage.getPSThresholdGroupStorage((String)pSThresholdGroup.getPSTHRESHOLDGROUPID()).psThresholdGroup = pSThresholdGroup;
            }
            PSSysModelLog psThresholdLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSTHRESHOLD"));
            Vector vector5 = psSysModelCache.getModelList("PSTHRESHOLD", psThresholdGroupLog, psThresholdLog);
            if (vector5 == null) {
                Vector<PSThreshold> vector6 = new Vector<PSThreshold>();
                CallResult callResult = this.getPSThresholdsBySystem(strPSSystemId, vector6);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9608\u503c\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSTHRESHOLD", psThresholdGroupLog, psThresholdLog, vector6);
            }
            for (PSThreshold pSThreshold : var10_622) {
                psSystemStorage.getPSThresholdGroupStorage((String)pSThreshold.getPSTHRESHOLDGROUPID()).psThresholdList.add(pSThreshold);
            }
        }
        if (this.getModelInstVer() >= 697) {
            PSSysModelLog psSysChartThemeLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCHARTTHEME"));
            Vector<PSSysChartTheme> psSysChartThemeList = psSysModelCache.getModelList("PSSYSCHARTTHEME", psSysChartThemeLog);
            if (psSysChartThemeList == null) {
                psSysChartThemeList = new Vector<PSSysChartTheme>();
                CallResult callResult = this.getAllPSSysChartThemes2(strPSSystemId, psSysChartThemeList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u56fe\u8868\u4e3b\u9898\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCHARTTHEME", psSysChartThemeLog, psSysChartThemeList);
            }
            psSystemStorage.psSysChartThemeList.addAll(psSysChartThemeList);
            for (PSSysChartTheme pSSysChartTheme : psSysChartThemeList) {
                psSystemStorage.psSysChartThemeMap.put(pSSysChartTheme.getPSSYSCHARTTHEMEID(), pSSysChartTheme);
            }
        }
        if ((psSysImageList = psSysModelCache.getModelList("PSSYSIMAGE", psSysImageLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSIMAGE")))) == null) {
            psSysImageList = new Vector<PSSysImage>();
            CallResult callResult = this.getAllPSSysImages2(strPSSystemId, psSysImageList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSIMAGE", psSysImageLog, psSysImageList);
        }
        psSystemStorage.psSysImageList.addAll(psSysImageList);
        for (PSSysImage pSSysImage : psSysImageList) {
            psSystemStorage.psSysImageMap.put(pSSysImage.getPSSYSIMAGEID(), pSSysImage);
        }
        PSSysModelLog psSysCssLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCSS"));
        Vector<PSSysCss> psSysCssList = psSysModelCache.getModelList("PSSYSCSS", psSysCssLog);
        if (psSysCssList == null) {
            psSysCssList = new Vector<PSSysCss>();
            CallResult callResult = this.getAllPSSysCsses2(strPSSystemId, psSysCssList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6837\u5f0f\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSCSS", psSysCssLog, psSysCssList);
        }
        psSystemStorage.psSysCssList.addAll(psSysCssList);
        for (PSSysCss pSSysCss : psSysCssList) {
            psSystemStorage.psSysCssMap.put(pSSysCss.getPSSYSCSSID(), pSSysCss);
        }
        PSSysModelLog psSysCounterLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCOUNTER"));
        Vector<PSSysCounter> psSysCounterList = psSysModelCache.getModelList("PSSYSCOUNTER", psSysCounterLog);
        if (psSysCounterList == null) {
            psSysCounterList = new Vector<PSSysCounter>();
            CallResult callResult = this.getAllPSSysCounters2(strPSSystemId, psSysCounterList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u8ba1\u6570\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSCOUNTER", psSysCounterLog, psSysCounterList);
        }
        psSystemStorage.psSysCounterList.addAll(psSysCounterList);
        for (PSSysCounter pSSysCounter : psSysCounterList) {
            psSystemStorage.psSysCounterMap.put(pSSysCounter.getPSSYSCOUNTERID(), pSSysCounter);
        }
        PSSysModelLog psCtrlMsgLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLMSG"));
        Vector<PSCtrlMsg> psCtrlMsgList = psSysModelCache.getModelList("PSCTRLMSG", psCtrlMsgLog);
        if (psCtrlMsgList == null) {
            psCtrlMsgList = new Vector<PSCtrlMsg>();
            CallResult callResult = this.getAllPSCtrlMsgs2(strPSSystemId, psCtrlMsgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u90e8\u4ef6\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSCTRLMSG", psCtrlMsgLog, psCtrlMsgList);
        }
        psSystemStorage.psCtrlMsgList.addAll(psCtrlMsgList);
        for (PSCtrlMsg pSCtrlMsg : psCtrlMsgList) {
            psSystemStorage.psCtrlMsgMap.put(pSCtrlMsg.getPSCTRLMSGID(), pSCtrlMsg);
            PSModelHelperBase.PSCtrlMsgStorage pSCtrlMsgStorage = psSystemStorage.getPSCtrlMsgStorage(pSCtrlMsg.getPSCTRLMSGID());
            pSCtrlMsgStorage.psCtrlMsg = pSCtrlMsg;
        }
        PSSysModelLog psSysModelLog22 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLMSGITEM"));
        Vector vector7 = psSysModelCache.getModelList("PSCTRLMSGITEM", psCtrlMsgLog, psSysModelLog22);
        if (vector7 == null) {
            Vector<PSCtrlMsgItem> vector8 = new Vector<PSCtrlMsgItem>();
            CallResult callResult = this.getPSCtrlMsgItemsBySystem(strPSSystemId, vector8);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u90e8\u4ef6\u6d88\u606f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSCTRLMSGITEM", psCtrlMsgLog, psSysModelLog22, vector8);
        }
        for (PSCtrlMsgItem pSCtrlMsgItem : var10_646) {
            PSModelHelperBase.PSCtrlMsgStorage psCtrlMsgStorage = psSystemStorage.getPSCtrlMsgStorage(pSCtrlMsgItem.getPSCTRLMSGID());
            psCtrlMsgStorage.psCtrlMsgItemList.add(pSCtrlMsgItem);
        }
        if (this.getModelInstVer() >= 353) {
            PSSysModelLog psDEActionTemplLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONTEMPL"));
            Vector<PSDEActionTempl> psDEActionTemplList = psSysModelCache.getModelList("PSDEACTIONTEMPL", psDEActionTemplLog);
            if (psDEActionTemplList == null) {
                psDEActionTemplList = new Vector<PSDEActionTempl>();
                CallResult callResult = this.getAllPSDEActionTempls2(strPSSystemId, psDEActionTemplList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEACTIONTEMPL", psDEActionTemplLog, psDEActionTemplList);
            }
            psSystemStorage.psDEActionTemplList.addAll(psDEActionTemplList);
            for (PSDEActionTempl pSDEActionTempl : psDEActionTemplList) {
                psSystemStorage.psDEActionTemplMap.put(pSDEActionTempl.getPSDEACTIONTEMPLID(), pSDEActionTempl);
            }
        }
        if ((psSysDEFTypeList = psSysModelCache.getModelList("PSSYSDEFTYPE", psSysDEFTypeLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDEFTYPE")))) == null) {
            psSysDEFTypeList = new Vector<PSSysDEFType>();
            CallResult callResult = this.getAllPSSysDEFTypes2(strPSSystemId, psSysDEFTypeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDEFTYPE", psSysDEFTypeLog, psSysDEFTypeList);
        }
        psSystemStorage.psSysDEFTypeList.addAll(psSysDEFTypeList);
        for (PSSysDEFType pSSysDEFType : psSysDEFTypeList) {
            psSystemStorage.psSysDEFTypeMap.put(pSSysDEFType.getPSSYSDEFTYPEID(), pSSysDEFType);
        }
        PSSysModelLog psSysLogicLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDELOGICNODE"));
        Vector<PSSysLogic> psSysLogicList = psSysModelCache.getModelList("PSSYSDELOGICNODE", psSysLogicLog);
        if (psSysLogicList == null) {
            psSysLogicList = new Vector<PSSysLogic>();
            CallResult callResult = this.getAllPSSysLogics2(strPSSystemId, psSysLogicList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDELOGICNODE", psSysLogicLog, psSysLogicList);
        }
        psSystemStorage.psSysLogicList.addAll(psSysLogicList);
        for (PSSysLogic pSSysLogic : psSysLogicList) {
            psSystemStorage.psSysLogicMap.put(pSSysLogic.getPSSYSDELOGICNODEID(), pSSysLogic);
        }
        PSSysModelLog psSysUnitLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUNIT"));
        Vector<PSSysUnit> psSysUnitList = psSysModelCache.getModelList("PSSYSUNIT", psSysUnitLog);
        if (psSysUnitList == null) {
            psSysUnitList = new Vector<PSSysUnit>();
            CallResult callResult = this.getAllPSSysUnits2(strPSSystemId, psSysUnitList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u5355\u4f4d\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUNIT", psSysUnitLog, psSysUnitList);
        }
        psSystemStorage.psSysUnitList.addAll(psSysUnitList);
        for (PSSysUnit pSSysUnit : psSysUnitList) {
            psSystemStorage.psSysUnitMap.put(pSSysUnit.getPSSYSUNITID(), pSSysUnit);
        }
        PSSysModelLog psSysFileLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSFILE"));
        Vector<PSSysFile> psSysFileList = psSysModelCache.getModelList("PSSYSFILE", psSysFileLog);
        if (psSysFileList == null) {
            psSysFileList = new Vector<PSSysFile>();
            CallResult callResult = this.getAllPSSysFiles2(strPSSystemId, psSysFileList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSFILE", psSysFileLog, psSysFileList);
        }
        psSystemStorage.psSysFileList.addAll(psSysFileList);
        for (PSSysFile pSSysFile : psSysFileList) {
            psSystemStorage.psSysFileMap.put(pSSysFile.getPSSYSFILEID(), pSSysFile);
        }
        PSSysModelLog psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPLAN"));
        Vector<PSAppLan> psSysLanList = psSysModelCache.getModelList("PSAPPLAN:SYS", psSysModelLog);
        if (psSysLanList == null) {
            psSysLanList = new Vector<PSAppLan>();
            CallResult callResult = this.getAllPSSysLans2(strPSSystemId, psSysLanList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5e94\u7528\u8bed\u8a00\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPLAN:SYS", psSysModelLog, psSysLanList);
        }
        psSystemStorage.psSysLanList.addAll(psSysLanList);
        PSSysModelLog psLanguageResLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSLANGUAGERES"));
        Vector<PSLanguageRes> psLanguageResList = psSysModelCache.getModelList("PSLANGUAGERES", psLanguageResLog);
        if (psLanguageResList == null) {
            psLanguageResList = new Vector<PSLanguageRes>();
            CallResult callResult = this.getAllPSLanguageReses2(strPSSystemId, psLanguageResList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u8bed\u8a00\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSLANGUAGERES", psLanguageResLog, psLanguageResList);
        }
        psSystemStorage.psLanguageResList.addAll(psLanguageResList);
        for (PSLanguageRes pSLanguageRes : psLanguageResList) {
            psSystemStorage.psLanguageResMap.put(pSLanguageRes.getPSLANGUAGERESID(), pSLanguageRes);
        }
        PSSysModelLog psLanguageItemLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSLANGUAGEITEM"));
        Vector<PSLanguageItem> psLanguageItemList = psSysModelCache.getModelList("PSLANGUAGEITEM", psLanguageItemLog);
        if (psLanguageItemList == null) {
            psLanguageItemList = new Vector<PSLanguageItem>();
            CallResult callResult = this.getAllPSLanguageItems2(strPSSystemId, psLanguageItemList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u8bed\u8a00\u8d44\u6e90\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSLANGUAGEITEM", psLanguageItemLog, psLanguageItemList);
        }
        psSystemStorage.psLanguageItemList.addAll(psLanguageItemList);
        for (PSLanguageItem pSLanguageItem : psLanguageItemList) {
            psSystemStorage.psLanguageItemMap.put(pSLanguageItem.getPSLANGUAGEITEMID(), pSLanguageItem);
        }
        PSSysModelLog psSubViewTypeLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBVIEWTYPE"));
        Vector<PSSubViewType> psSubViewTypeList = psSysModelCache.getModelList("PSSUBVIEWTYPE", psSubViewTypeLog);
        if (psSubViewTypeList == null) {
            psSubViewTypeList = new Vector<PSSubViewType>();
            CallResult callResult = this.getAllPSSubViewTypes2(strPSSystemId, psSubViewTypeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u5b50\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSUBVIEWTYPE", psSubViewTypeLog, psSubViewTypeList);
        }
        psSystemStorage.psSubViewTypeList.addAll(psSubViewTypeList);
        for (PSSubViewType pSSubViewType : psSubViewTypeList) {
            psSystemStorage.psSubViewTypeMap.put(pSSubViewType.getPSSUBVIEWTYPEID(), pSSubViewType);
        }
        PSSysModelLog psSysValueRuleLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSVALUERULE"));
        Vector<PSSysValueRule> psSysValueRuleList = psSysModelCache.getModelList("PSSYSVALUERULE", psSysValueRuleLog);
        if (psSysValueRuleList == null) {
            psSysValueRuleList = new Vector<PSSysValueRule>();
            CallResult callResult = this.getAllPSSysValueRules2(strPSSystemId, psSysValueRuleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSVALUERULE", psSysValueRuleLog, psSysValueRuleList);
        }
        psSystemStorage.psSysValueRuleList.addAll(psSysValueRuleList);
        for (PSSysValueRule pSSysValueRule : psSysValueRuleList) {
            psSystemStorage.psSysValueRuleMap.put(pSSysValueRule.getPSSYSVALUERULEID(), pSSysValueRule);
        }
        PSSysModelLog psSysPortletLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSPORTLET"));
        Vector<PSSysPortlet> psSysPortletList = psSysModelCache.getModelList("PSSYSPORTLET", psSysPortletLog);
        if (psSysPortletList == null) {
            psSysPortletList = new Vector<PSSysPortlet>();
            CallResult callResult = this.getAllPSSysPortlets2(strPSSystemId, psSysPortletList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u95e8\u6237\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSPORTLET", psSysPortletLog, psSysPortletList);
        }
        psSystemStorage.psSysPortletList.addAll(psSysPortletList);
        for (PSSysPortlet pSSysPortlet : psSysPortletList) {
            psSystemStorage.psSysPortletMap.put(pSSysPortlet.getPSSYSPORTLETID(), pSSysPortlet);
        }
        PSSysModelLog psSysDictCatLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDICTCAT"));
        Vector<PSSysDictCat> psSysDictCatList = psSysModelCache.getModelList("PSSYSDICTCAT", psSysDictCatLog);
        if (psSysDictCatList == null) {
            psSysDictCatList = new Vector<PSSysDictCat>();
            CallResult callResult = this.getAllPSSysDictCats2(strPSSystemId, psSysDictCatList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u8bcd\u5178\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDICTCAT", psSysDictCatLog, psSysDictCatList);
        }
        psSystemStorage.psSysDictCatList.addAll(psSysDictCatList);
        for (PSSysDictCat pSSysDictCat : psSysDictCatList) {
            psSystemStorage.psSysDictCatMap.put(pSSysDictCat.getPSSYSDICTCATID(), pSSysDictCat);
        }
        if (this.getModelInstVer() >= 630) {
            PSSysModelLog psSysPortletCatLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSPORTLETCAT"));
            Vector<PSSysPortletCat> psSysPortletCatList = psSysModelCache.getModelList("PSSYSPORTLETCAT", psSysPortletCatLog);
            if (psSysPortletCatList == null) {
                psSysPortletCatList = new Vector<PSSysPortletCat>();
                CallResult callResult = this.getAllPSSysPortletCats2(strPSSystemId, psSysPortletCatList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSPORTLETCAT", psSysPortletCatLog, psSysPortletCatList);
            }
            psSystemStorage.psSysPortletCatList.addAll(psSysPortletCatList);
            for (PSSysPortletCat pSSysPortletCat : psSysPortletCatList) {
                psSystemStorage.psSysPortletCatMap.put(pSSysPortletCat.getPSSYSPORTLETCATID(), pSSysPortletCat);
            }
        }
        if ((psSysEditorStyleList = psSysModelCache.getModelList("PSSYSEDITORSTYLE", psSysEditorStyleLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEDITORSTYLE")))) == null) {
            psSysEditorStyleList = new Vector<PSSysEditorStyle>();
            CallResult callResult = this.getAllPSSysEditorStyles2(strPSSystemId, psSysEditorStyleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7f16\u8f91\u5668\u6837\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSEDITORSTYLE", psSysEditorStyleLog, psSysEditorStyleList);
        }
        psSystemStorage.psSysEditorStyleList.addAll(psSysEditorStyleList);
        for (PSSysEditorStyle pSSysEditorStyle : psSysEditorStyleList) {
            psSystemStorage.psSysEditorStyleMap.put(pSSysEditorStyle.getPSSYSEDITORSTYLEID(), pSSysEditorStyle);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSPFPLUGIN"));
        Vector<PSSysPFPlugin> psSysPFPluginList = psSysModelCache.getModelList("PSSYSPFPLUGIN", psSysModelLog);
        if (psSysPFPluginList == null) {
            psSysPFPluginList = new Vector<PSSysPFPlugin>();
            CallResult callResult = this.getAllPSSysPFPlugins2(strPSSystemId, psSysPFPluginList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5e94\u7528\u63d2\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSPFPLUGIN", psSysModelLog, psSysPFPluginList);
        }
        psSystemStorage.psSysPFPluginList.addAll(psSysPFPluginList);
        for (PSSysPFPlugin pSSysPFPlugin : psSysPFPluginList) {
            psSystemStorage.psSysPFPluginMap.put(pSSysPFPlugin.getPSSYSPFPLUGINID(), pSSysPFPlugin);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSPFPITEMPL"));
        Vector<PSSysPFPluginTempl> psSysPFPluginTemplList = psSysModelCache.getModelList("PSSYSPFPITEMPL", psSysModelLog);
        if (psSysPFPluginTemplList == null) {
            psSysPFPluginTemplList = new Vector<PSSysPFPluginTempl>();
            CallResult callResult = this.getAllPSSysPFPluginTempls2(strPSSystemId, psSysPFPluginTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5e94\u7528\u63d2\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSPFPITEMPL", psSysModelLog, psSysPFPluginTemplList);
        }
        psSystemStorage.psSysPFPluginTemplList.addAll(psSysPFPluginTemplList);
        for (PSSysPFPluginTempl pSSysPFPluginTempl : psSysPFPluginTemplList) {
            psSystemStorage.psSysPFPluginTemplMap.put(pSSysPFPluginTempl.getPSSYSPFPLUGINID(), pSSysPFPluginTempl);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSFPLUGIN"));
        Vector<PSSysSFPlugin> psSysSFPluginList = psSysModelCache.getModelList("PSSYSSFPLUGIN", psSysModelLog);
        if (psSysSFPluginList == null) {
            psSysSFPluginList = new Vector<PSSysSFPlugin>();
            CallResult callResult = this.getAllPSSysSFPlugins2(strPSSystemId, psSysSFPluginList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u670d\u52a1\u63d2\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSFPLUGIN", psSysModelLog, psSysSFPluginList);
        }
        psSystemStorage.psSysSFPluginList.addAll(psSysSFPluginList);
        for (PSSysSFPlugin pSSysSFPlugin : psSysSFPluginList) {
            psSystemStorage.psSysSFPluginMap.put(pSSysSFPlugin.getPSSYSSFPLUGINID(), pSSysSFPlugin);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSFPITEMPL"));
        Vector<PSSysSFPluginTempl> psSysSFPluginTemplList = psSysModelCache.getModelList("PSSYSSFPITEMPL", psSysModelLog);
        if (psSysSFPluginTemplList == null) {
            psSysSFPluginTemplList = new Vector<PSSysSFPluginTempl>();
            CallResult callResult = this.getAllPSSysSFPluginTempls2(strPSSystemId, psSysSFPluginTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u670d\u52a1\u63d2\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSFPITEMPL", psSysModelLog, psSysSFPluginTemplList);
        }
        psSystemStorage.psSysSFPluginTemplList.addAll(psSysSFPluginTemplList);
        for (PSSysSFPluginTempl pSSysSFPluginTempl : psSysSFPluginTemplList) {
            psSystemStorage.psSysSFPluginTemplMap.put(pSSysSFPluginTempl.getPSSYSSFPLUGINID(), pSSysSFPluginTempl);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUNIRES"));
        Vector<PSSysUniRes> psSysUniResList = psSysModelCache.getModelList("PSSYSUNIRES", psSysModelLog);
        if (psSysUniResList == null) {
            psSysUniResList = new Vector<PSSysUniRes>();
            CallResult callResult = this.getAllPSSysUniReses2(strPSSystemId, psSysUniResList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7edf\u4e00\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUNIRES", psSysModelLog, psSysUniResList);
        }
        psSystemStorage.psSysUniResList.addAll(psSysUniResList);
        for (PSSysUniRes pSSysUniRes : psSysUniResList) {
            psSystemStorage.psSysUniResMap.put(pSSysUniRes.getPSSYSUNIRESID(), pSSysUniRes);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSOPPRIV"));
        Vector<PSSysUserRole> psSysUserRoleList = psSysModelCache.getModelList("PSSYSOPPRIV", psSysModelLog);
        if (psSysUserRoleList == null) {
            psSysUserRoleList = new Vector<PSSysUserRole>();
            CallResult callResult = this.getAllPSSysUserRoles2(strPSSystemId, psSysUserRoleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u6237\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSOPPRIV", psSysModelLog, psSysUserRoleList);
        }
        psSystemStorage.psSysUserRoleList.addAll(psSysUserRoleList);
        Iterator iterator = psSysUserRoleList.iterator();
        while (iterator.hasNext()) {
            PSSysUserRole pSSysUserRole;
            psSystemStorage.getPSSysUserRoleStorage((String)pSSysUserRole.getPSSYSOPPRIVID()).psSysUserRole = pSSysUserRole = (PSSysUserRole)((Object)iterator.next());
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERROLERES"));
        Vector<PSSysUserRoleRes> psSysUserRoleResList = psSysModelCache.getModelList("PSSYSUSERROLERES", psSysModelLog);
        if (psSysUserRoleResList == null) {
            psSysUserRoleResList = new Vector<PSSysUserRoleRes>();
            CallResult callResult = this.getPSSysUserRoleResesBySystem(strPSSystemId, psSysUserRoleResList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u6237\u89d2\u8272\u7edf\u4e00\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUSERROLERES", psSysModelLog, psSysUserRoleResList);
        }
        for (PSSysUserRoleRes pSSysUserRoleRes : psSysUserRoleResList) {
            psSystemStorage.getPSSysUserRoleStorage((String)pSSysUserRoleRes.getPSSYSOPPRIVID()).psSysUserRoleResList.add(pSSysUserRoleRes);
        }
        if (this.getModelInstVer() >= 635) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERROLEDATA"));
            Vector<PSSysUserRoleData> psSysUserRoleDataList = psSysModelCache.getModelList("PSSYSUSERROLEDATA", psSysModelLog);
            if (psSysUserRoleDataList == null) {
                psSysUserRoleDataList = new Vector<PSSysUserRoleData>();
                CallResult callResult = this.getPSSysUserRoleDatasBySystem(strPSSystemId, psSysUserRoleDataList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u6237\u89d2\u8272\u6570\u636e\u80fd\u529b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSUSERROLEDATA", psSysModelLog, psSysUserRoleDataList);
            }
            for (PSSysUserRoleData pSSysUserRoleData : psSysUserRoleDataList) {
                psSystemStorage.getPSSysUserRoleStorage((String)pSSysUserRoleData.getPSSYSOPPRIVID()).psSysUserRoleDataList.add(pSSysUserRoleData);
            }
        }
        if ((psSysMsgTemplList = psSysModelCache.getModelList("PSSYSMSGTEMPL", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSMSGTEMPL")))) == null) {
            psSysMsgTemplList = new Vector<PSSysMsgTempl>();
            CallResult callResult = this.getAllPSSysMsgTempls2(strPSSystemId, psSysMsgTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d88\u606f\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSMSGTEMPL", psSysModelLog, psSysMsgTemplList);
        }
        psSystemStorage.psSysMsgTemplList.addAll(psSysMsgTemplList);
        for (PSSysMsgTempl pSSysMsgTempl : psSysMsgTemplList) {
            psSystemStorage.psSysMsgTemplMap.put(pSSysMsgTempl.getPSSYSMSGTEMPLID(), pSSysMsgTempl);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSVIEWMSG"));
        Vector<PSViewMsg> psViewMsgList = psSysModelCache.getModelList("PSVIEWMSG", psSysModelLog);
        if (psViewMsgList == null) {
            psViewMsgList = new Vector<PSViewMsg>();
            CallResult callResult = this.getAllPSViewMsgs2(strPSSystemId, psViewMsgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSVIEWMSG", psSysModelLog, psViewMsgList);
        }
        psSystemStorage.psViewMsgList.addAll(psViewMsgList);
        for (PSViewMsg pSViewMsg : psViewMsgList) {
            psSystemStorage.psViewMsgMap.put(pSViewMsg.getPSVIEWMSGID(), pSViewMsg);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSVIEWMSGGROUP"));
        Vector<PSViewMsgGroup> psViewMsgGroupList = psSysModelCache.getModelList("PSVIEWMSGGROUP", psSysModelLog);
        if (psViewMsgGroupList == null) {
            psViewMsgGroupList = new Vector<PSViewMsgGroup>();
            CallResult callResult = this.getAllPSViewMsgGroups2(strPSSystemId, psViewMsgGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u6d88\u606f\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSVIEWMSGGROUP", psSysModelLog, psViewMsgGroupList);
        }
        psSystemStorage.psViewMsgGroupList.addAll(psViewMsgGroupList);
        for (PSViewMsgGroup pSViewMsgGroup : psViewMsgGroupList) {
            psSystemStorage.psViewMsgGroupMap.put(pSViewMsgGroup.getPSVIEWMSGGROUPID(), pSViewMsgGroup);
        }
        PSSysModelLog psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSVIEWMSGGRPDETAIL"));
        Vector vector9 = psSysModelCache.getModelList("PSVIEWMSGGRPDETAIL", psSysModelLog, psSysModelLog2);
        if (vector9 == null) {
            Vector<PSViewMsgGroupDetail> vector10 = new Vector<PSViewMsgGroupDetail>();
            CallResult callResult = this.getPSViewMsgGroupDetailsBySystem(strPSSystemId, vector10);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSVIEWMSGGRPDETAIL", psSysModelLog, psSysModelLog2, vector10);
        }
        for (PSViewMsgGroupDetail pSViewMsgGroupDetail : var10_747) {
            psSystemStorage.getPSViewMsgGroupStorage((String)pSViewMsgGroupDetail.getPSVIEWMSGGROUPID()).psViewMsgGroupDetailList.add(pSViewMsgGroupDetail);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSFPUB"));
        Vector<PSSysSFPub> psSysSFPubList = psSysModelCache.getModelList("PSSYSSFPUB", psSysModelLog);
        if (psSysSFPubList == null) {
            psSysSFPubList = new Vector<PSSysSFPub>();
            CallResult callResult = this.getAllPSSysSFPubs2(strPSSystemId, psSysSFPubList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1\u53d1\u5e03\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSFPUB", psSysModelLog, psSysSFPubList);
        }
        psSystemStorage.psSysSFPubList.addAll(psSysSFPubList);
        for (PSSysSFPub pSSysSFPub : psSysSFPubList) {
            psSystemStorage.psSysSFPubMap.put(pSSysSFPub.getPSSYSSFPUBID(), pSSysSFPub);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSAHANDLER"));
        Vector<PSSysServiceAPIHandler> psSysServiceAPIHandlerList = psSysModelCache.getModelList("PSSYSSAHANDLER", psSysModelLog);
        if (psSysServiceAPIHandlerList == null) {
            psSysServiceAPIHandlerList = new Vector<PSSysServiceAPIHandler>();
            CallResult callResult = this.getAllPSSysServiceAPIHandlers2(strPSSystemId, psSysServiceAPIHandlerList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1API\u5904\u7406\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSAHANDLER", psSysModelLog, psSysServiceAPIHandlerList);
        }
        psSystemStorage.psSysServiceAPIHandlerList.addAll(psSysServiceAPIHandlerList);
        Iterator iterator2 = psSysServiceAPIHandlerList.iterator();
        while (iterator2.hasNext()) {
            PSSysServiceAPIHandler pSSysServiceAPIHandler;
            psSystemStorage.getPSSysServiceAPIHandlerStorage((String)pSSysServiceAPIHandler.getPSSYSSAHANDLERID(), (boolean)true).psSysServiceAPIHandler = pSSysServiceAPIHandler = (PSSysServiceAPIHandler)((Object)iterator2.next());
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSERVICEAPI"));
        Vector<PSSysServiceAPI> psSysServiceAPIList = psSysModelCache.getModelList("PSSYSSERVICEAPI", psSysModelLog);
        if (psSysServiceAPIList == null) {
            psSysServiceAPIList = new Vector<PSSysServiceAPI>();
            CallResult callResult = this.getAllPSSysServiceAPIs2(strPSSystemId, psSysServiceAPIList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1API\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSERVICEAPI", psSysModelLog, psSysServiceAPIList);
        }
        psSystemStorage.psSysServiceAPIList.addAll(psSysServiceAPIList);
        Iterator iterator3 = psSysServiceAPIList.iterator();
        while (iterator3.hasNext()) {
            PSSysServiceAPI pSSysServiceAPI;
            psSystemStorage.getPSSysServiceAPIStorage((String)pSSysServiceAPI.getPSSYSSERVICEAPIID(), (boolean)true).psSysServiceAPI = pSSysServiceAPI = (PSSysServiceAPI)((Object)iterator3.next());
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBSYSSERVICEAPI"));
        Vector<PSSubSysServiceAPI> psSubSysServiceAPIList = psSysModelCache.getModelList("PSSUBSYSSERVICEAPI", psSysModelLog);
        if (psSubSysServiceAPIList == null) {
            psSubSysServiceAPIList = new Vector<PSSubSysServiceAPI>();
            CallResult callResult = this.getAllPSSubSysServiceAPIs2(strPSSystemId, psSubSysServiceAPIList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u670d\u52a1API\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSUBSYSSERVICEAPI", psSysModelLog, psSubSysServiceAPIList);
        }
        psSystemStorage.psSubSysServiceAPIList.addAll(psSubSysServiceAPIList);
        Iterator iterator4 = psSubSysServiceAPIList.iterator();
        while (iterator4.hasNext()) {
            PSSubSysServiceAPI pSSubSysServiceAPI;
            psSystemStorage.getPSSubSysServiceAPIStorage((String)pSSubSysServiceAPI.getPSSUBSYSSERVICEAPIID(), (boolean)true).psSubSysServiceAPI = pSSubSysServiceAPI = (PSSubSysServiceAPI)((Object)iterator4.next());
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBSYSSADETAIL"));
        Vector<PSSubSysSADE> psSubSysSADetailList = psSysModelCache.getModelList("PSSUBSYSSADETAIL", psSysModelLog);
        if (psSubSysSADetailList == null) {
            psSubSysSADetailList = new Vector<PSSubSysSADE>();
            CallResult callResult = this.getPSSubSysSADetailsBySystem(strPSSystemId, psSubSysSADetailList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b50\u7cfb\u7edf\u63a5\u53e3\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSUBSYSSADETAIL", psSysModelLog, psSubSysSADetailList);
        }
        for (PSSubSysSADetail pSSubSysSADetail : psSubSysSADetailList) {
            PSModelHelperBase.PSSubSysServiceAPIStorage pSSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(pSSubSysSADetail.getPSSUBSYSSERVICEAPIID(), false);
            if (pSSubSysServiceAPIStorage == null) continue;
            pSSubSysServiceAPIStorage.psSubSysSADetailList.add(pSSubSysSADetail);
        }
        if (this.getModelInstVer() >= Version.V19100800) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBSYSSADE"));
            psSubSysSADetailList = psSysModelCache.getModelList("PSSUBSYSSADE", psSysModelLog);
            if (psSubSysSADetailList == null) {
                psSubSysSADetailList = new Vector<PSSubSysSADE>();
                CallResult callResult = this.getPSSubSysSADEsBySystem(strPSSystemId, psSubSysSADetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b50\u7cfb\u7edf\u63a5\u53e3\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSUBSYSSADE", psSysModelLog, psSubSysSADetailList);
            }
            for (PSSubSysSADE pSSubSysSADE : psSubSysSADetailList) {
                PSModelHelperBase.PSSubSysSADEStorage psSubSysSADEStorage;
                PSModelHelperBase.PSSubSysServiceAPIStorage pSSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(pSSubSysSADE.getPSSUBSYSSERVICEAPIID(), false);
                if (pSSubSysServiceAPIStorage != null) {
                    pSSubSysServiceAPIStorage.psSubSysSADEList.add(pSSubSysSADE);
                }
                if ((psSubSysSADEStorage = psSystemStorage.getPSSubSysSADEStorage(pSSubSysSADE.getPSSUBSYSSADEID(), true)) == null) continue;
                psSubSysSADEStorage.psSubSysSADE = pSSubSysSADE;
            }
        }
        if (this.getModelInstVer() >= Version.V19100800) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBSYSSADERS"));
            psSubSysSADetailList = psSysModelCache.getModelList("PSSUBSYSSADERS", psSysModelLog);
            if (psSubSysSADetailList == null) {
                psSubSysSADetailList = new Vector();
                CallResult callResult = this.getPSSubSysSADERSsBySystem(strPSSystemId, psSubSysSADetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b50\u7cfb\u7edf\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSUBSYSSADERS", psSysModelLog, psSubSysSADetailList);
            }
            for (PSSubSysSADERS pSSubSysSADERS : psSubSysSADetailList) {
                PSModelHelperBase.PSSubSysServiceAPIStorage pSSubSysServiceAPIStorage = psSystemStorage.getPSSubSysServiceAPIStorage(pSSubSysSADERS.getPSSUBSYSSERVICEAPIID(), false);
                if (pSSubSysServiceAPIStorage == null) continue;
                pSSubSysServiceAPIStorage.psSubSysSADERSList.add(pSSubSysSADERS);
            }
        }
        if (this.getModelInstVer() >= Version.V19100800) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSUBSYSSADEFIELD"));
            Vector<PSSubSysSADEField> psSubSysSADEFieldList = psSysModelCache.getModelList("PSSUBSYSSADEFIELD", psSysModelLog);
            if (psSubSysSADEFieldList == null) {
                psSubSysSADEFieldList = new Vector<PSSubSysSADEField>();
                CallResult callResult = this.getPSSubSysSADEFieldsBySystem(strPSSystemId, psSubSysSADEFieldList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b50\u7cfb\u7edf\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSUBSYSSADEFIELD", psSysModelLog, psSubSysSADEFieldList);
            }
            for (PSSubSysSADEField pSSubSysSADEField : psSubSysSADEFieldList) {
                PSModelHelperBase.PSSubSysSADEStorage pSSubSysSADEStorage = psSystemStorage.getPSSubSysSADEStorage(pSSubSysSADEField.getPSSUBSYSSADEID(), false);
                if (pSSubSysSADEStorage == null) continue;
                pSSubSysSADEStorage.psSubSysSADEFieldList.add(pSSubSysSADEField);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_STARTUP) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBACKSERVICE"));
            Vector<PSSysBackService> psSysBackServiceList = psSysModelCache.getModelList("PSSYSBACKSERVICE", psSysModelLog);
            if (psSysBackServiceList == null) {
                psSysBackServiceList = new Vector<PSSysBackService>();
                CallResult callResult = this.getAllPSSysBackServices2(strPSSystemId, psSysBackServiceList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u540e\u53f0\u4f5c\u4e1a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBACKSERVICE", psSysModelLog, psSysBackServiceList);
            }
            psSystemStorage.psSysBackServiceList.addAll(psSysBackServiceList);
            for (PSSysBackService pSSysBackService : psSysBackServiceList) {
                psSystemStorage.psSysBackServiceMap.put(pSSysBackService.getPSSYSBACKSERVICEID(), pSSysBackService);
            }
        }
        if ((psSysPDTViewList = psSysModelCache.getModelList("PSSYSPDTVIEW", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSPDTVIEW")))) == null) {
            psSysPDTViewList = new Vector<PSSysPDTView>();
            CallResult callResult = this.getAllPSSysPDTViews2(strPSSystemId, psSysPDTViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSPDTVIEW", psSysModelLog, psSysPDTViewList);
        }
        psSystemStorage.psSysPDTViewList.addAll(psSysPDTViewList);
        for (PSSysPDTView pSSysPDTView : psSysPDTViewList) {
            psSystemStorage.psSysPDTViewMap.put(pSSysPDTView.getPSSYSPDTVIEWID(), pSSysPDTView);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSVIEWLOGIC"));
        boolean bLoadDetail = true;
        Vector vector11 = psSysModelCache.getModelList("PSSYSVIEWLOGIC", psSysModelLog);
        if (vector11 == null) {
            Vector<PSSysViewLogic> vector12 = new Vector<PSSysViewLogic>();
            CallResult callResult = this.getAllPSSysViewLogics2(strPSSystemId, vector12);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSVIEWLOGIC", psSysModelLog, vector12);
        }
        psSystemStorage.psSysViewLogicList.addAll((Collection<PSSysViewLogic>)var10_790);
        for (PSSysViewLogic pSSysViewLogic : var10_790) {
            psSystemStorage.psSysViewLogicMap.put(pSSysViewLogic.getPSSYSVIEWLOGICID(), pSSysViewLogic);
            psSystemStorage.getPSSysViewLogicStorage((String)pSSysViewLogic.getPSSYSVIEWLOGICID()).psSysViewLogic = pSSysViewLogic;
        }
        Vector vector13 = psSysModelCache.getModelList("PSSYSVIEWLOGICPARAM", psSysModelLog);
        if (vector13 == null) {
            Vector<PSSysViewLogicParam> vector14 = new Vector<PSSysViewLogicParam>();
            CallResult callResult = this.getPSSysViewLogicParamsBySystem(strPSSystemId, vector14);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSVIEWLOGICPARAM", psSysModelLog, vector14);
        }
        for (PSSysViewLogicParam pSSysViewLogicParam : var10_793) {
            psSystemStorage.getPSSysViewLogicStorage((String)pSSysViewLogicParam.getPSSYSVIEWLOGICID()).psSysViewLogicParamList.add(pSSysViewLogicParam);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDATASYNCAGENT"));
        Vector<PSSysDataSyncAgent> psSysDataSyncAgentList = psSysModelCache.getModelList("PSSYSDATASYNCAGENT", psSysModelLog);
        if (psSysDataSyncAgentList == null) {
            psSysDataSyncAgentList = new Vector<PSSysDataSyncAgent>();
            CallResult callResult = this.getAllPSSysDataSyncAgents2(strPSSystemId, psSysDataSyncAgentList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u540c\u6b65\u4ee3\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDATASYNCAGENT", psSysModelLog, psSysDataSyncAgentList);
        }
        psSystemStorage.psSysDataSyncAgentList.addAll(psSysDataSyncAgentList);
        for (PSSysDataSyncAgent pSSysDataSyncAgent : psSysDataSyncAgentList) {
            psSystemStorage.psSysDataSyncAgentMap.put(pSSysDataSyncAgent.getPSSYSDATASYNCAGENTID(), pSSysDataSyncAgent);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDATAENTITY"));
        Vector<PSDataEntity> psDataEntityList = psSysModelCache.getModelList("PSDATAENTITY", psSysModelLog);
        if (psDataEntityList == null) {
            psDataEntityList = new Vector<PSDataEntity>();
            CallResult callResult = this.getAllPSDataEntities2(strPSSystemId, psDataEntityList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDATAENTITY", psSysModelLog, psDataEntityList);
        }
        psSystemStorage.psDataEntityList.addAll(psDataEntityList);
        for (PSDataEntity pSDataEntity : psDataEntityList) {
            psSystemStorage.psDataEntityMap.put(pSDataEntity.getPSDATAENTITYID(), pSDataEntity);
            psSystemStorage.psDataEntityMap.put(pSDataEntity.getPSDATAENTITYNAME(), pSDataEntity);
            psSystemStorage.getPSDataEntityStorage((String)pSDataEntity.getPSDATAENTITYID()).psDataEntity = pSDataEntity;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFIELD"));
        Vector<PSDEField> psDEFieldList = psSysModelCache.getModelList("PSDEFIELD", psSysModelLog);
        if (psDEFieldList == null) {
            psDEFieldList = new Vector<PSDEField>();
            CallResult callResult = this.getPSDEFieldsNoSortBySystem(strPSSystemId, psDEFieldList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFIELD", psSysModelLog, psDEFieldList);
        }
        for (PSDEField pSDEField : psDEFieldList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEField.getPSDEID()).psDEFieldList.add(pSDEField);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEVIEWBASE"));
        Vector<PSDEViewBase> psDEViewBaseList = psSysModelCache.getModelList("PSDEVIEWBASE", psSysModelLog);
        if (psDEViewBaseList == null) {
            psDEViewBaseList = new Vector<PSDEViewBase>();
            CallResult callResult = this.getPSDEViewsBySystem(strPSSystemId, psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEVIEWBASE", psSysModelLog, psDEViewBaseList);
        }
        for (PSDEViewBase pSDEViewBase : psDEViewBaseList) {
            if (!StringHelper.IsNullOrEmpty((String)pSDEViewBase.getPREDEFINEVIEWTYPE())) {
                psSystemStorage.getPSDataEntityStorage((String)pSDEViewBase.getPSDEID()).psDEPredefinedViewList.add(pSDEViewBase);
            }
            psSystemStorage.getPSDataEntityStorage((String)pSDEViewBase.getPSDEID()).psDEViewList.add(pSDEViewBase);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFORM"));
        Vector<PSDEForm> psDEFormList = psSysModelCache.getModelList("PSDEFORM", psSysModelLog);
        if (psDEFormList == null) {
            psDEFormList = new Vector<PSDEForm>();
            CallResult callResult = this.getPSDEEditFormsBySystem(strPSSystemId, psDEFormList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7f16\u8f91\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFORM", psSysModelLog, psDEFormList);
        }
        for (PSDEForm pSDEForm : psDEFormList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEForm.getPSDEID()).psDEEditFormList.add(pSDEForm);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFFORMITEM"));
        Vector<PSDEFUIMode> psDEFUIModeList = psSysModelCache.getModelList("PSDEFFORMITEM", psSysModelLog);
        if (psDEFUIModeList == null) {
            psDEFUIModeList = new Vector<PSDEFUIMode>();
            CallResult callResult = this.getPSDEFUIModesBySystem(strPSSystemId, psDEFUIModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFFORMITEM", psSysModelLog, psDEFUIModeList);
        }
        for (PSDEFUIMode pSDEFUIMode : psDEFUIModeList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFUIMode.getParamStringValue((String)"PSDEID", (String)"")).psDEFUIModeList.add(pSDEFUIMode);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFSFITEM"));
        Vector<PSDEFSearchMode> psDEFSearchModeList = psSysModelCache.getModelList("PSDEFSFITEM", psSysModelLog);
        if (psDEFSearchModeList == null) {
            psDEFSearchModeList = new Vector<PSDEFSearchMode>();
            CallResult callResult = this.getPSDEFSearchModesBySystem(strPSSystemId, psDEFSearchModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFSFITEM", psSysModelLog, psDEFSearchModeList);
        }
        for (PSDEFSearchMode pSDEFSearchMode : psDEFSearchModeList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFSearchMode.getParamStringValue((String)"PSDEID", (String)"")).psDEFSearchModeList.add(pSDEFSearchMode);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFDTCOL"));
        Vector<PSDEFDTColumn> psDEFDTColumnList = psSysModelCache.getModelList("PSDEFDTCOL", psSysModelLog);
        if (psDEFDTColumnList == null) {
            psDEFDTColumnList = new Vector<PSDEFDTColumn>();
            CallResult callResult = this.getPSDEFDTColumnsBySystem(strPSSystemId, psDEFDTColumnList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u6570\u636e\u8868\u683c\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFDTCOL", psSysModelLog, psDEFDTColumnList);
        }
        for (PSDEFDTColumn pSDEFDTColumn : psDEFDTColumnList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFDTColumn.getPSDEId()).psDEFDTColumnList.add(pSDEFDTColumn);
        }
        if (this.getModelInstVer() >= 611) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHDEFIELD"));
            Vector<PSSysSearchDEField> psSysSearchDEFieldList = psSysModelCache.getModelList("PSSYSSEARCHDEFIELD", psSysModelLog);
            if (psSysSearchDEFieldList == null) {
                psSysSearchDEFieldList = new Vector<PSSysSearchDEField>();
                CallResult callResult = this.getPSSysSearchDEFieldsBySystem(strPSSystemId, psSysSearchDEFieldList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u5168\u6587\u68c0\u7d22\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEARCHDEFIELD", psSysModelLog, psSysSearchDEFieldList);
            }
            for (PSSysSearchDEField pSSysSearchDEField : psSysSearchDEFieldList) {
                psSystemStorage.getPSDataEntityStorage((String)pSSysSearchDEField.getPSDEID()).psSysSearchDEFieldList.add(pSSysSearchDEField);
            }
        }
        if ((psDEFValueRuleList = psSysModelCache.getModelList("PSDEFVALUERULE", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFVALUERULE")))) == null) {
            psDEFValueRuleList = new Vector<PSDEFValueRule>();
            CallResult callResult = this.getPSDEFValueRulesBySystem(strPSSystemId, psDEFValueRuleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFVALUERULE", psSysModelLog, psDEFValueRuleList);
        }
        for (PSDEFValueRule pSDEFValueRule : psDEFValueRuleList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFValueRule.getParamStringValue((String)"PSDEID", (String)"")).psDEFValueRuleList.add(pSDEFValueRule);
        }
        Vector<PSDEFValueRuleCond> psDEFValueRuleCondList = psSysModelCache.getModelList("PSDEFVRCOND", psSysModelLog);
        if (psDEFValueRuleCondList == null) {
            psDEFValueRuleCondList = new Vector<PSDEFValueRuleCond>();
            CallResult callResult = this.getPSDEFValueRuleCondsBySystem(strPSSystemId, psDEFValueRuleCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u503c\u89c4\u5219\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFVRCOND", psSysModelLog, psDEFValueRuleCondList);
        }
        for (PSDEFValueRuleCond pSDEFValueRuleCond : psDEFValueRuleCondList) {
            PSModelHelperBase.PSDEFValueRuleStorage pSDEFValueRuleStorage = psSystemStorage.getPSDEFValueRuleStorage(pSDEFValueRuleCond.getPSDEFVRID());
            pSDEFValueRuleStorage.psDEFValueRuleCondList.add(pSDEFValueRuleCond);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFINPUTTIP"));
        Vector<PSDEFInputTip> psDEFInputTipList = psSysModelCache.getModelList("PSDEFINPUTTIP", psSysModelLog);
        if (psDEFInputTipList == null) {
            psDEFInputTipList = new Vector<PSDEFInputTip>();
            CallResult callResult = this.getPSDEFInputTipsBySystem2(strPSSystemId, psDEFInputTipList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFINPUTTIP", psSysModelLog, psDEFInputTipList);
        }
        for (PSDEFInputTip pSDEFInputTip : psDEFInputTipList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFInputTip.getPSDEID()).psDEFInputTipList.add(pSDEFInputTip);
        }
        psDEFInputTipList = psSysModelCache.getModelList("PSDEFINPUTTIP_SYS", psSysModelLog);
        if (psDEFInputTipList == null) {
            psDEFInputTipList = new Vector<PSDEFInputTip>();
            CallResult callResult = this.getPSDEFInputTipsBySystem3(strPSSystemId, psDEFInputTipList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFINPUTTIP_SYS", psSysModelLog, psDEFInputTipList);
        }
        psSystemStorage.psDEFInputTipList.addAll(psDEFInputTipList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDER"));
        Vector<PSDER> psDERList = psSysModelCache.getModelList("PSDER", psSysModelLog);
        if (psDERList == null) {
            psDERList = new Vector<PSDER>();
            CallResult callResult = this.getAllPSDERs2(strPSSystemId, psDERList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDER", psSysModelLog, psDERList);
        }
        psSystemStorage.psDERList.addAll(psDERList);
        for (PSDER pSDER : psDERList) {
            psSystemStorage.psDERMap.put(pSDER.getPSDERID(), pSDER);
            psSystemStorage.getPSDataEntityStorage((String)pSDER.getMAJORPSDEID()).psDERList.add(pSDER);
            psSystemStorage.getPSDataEntityStorage((String)pSDER.getMINORPSDEID()).psDERList2.add(pSDER);
            PSModelHelperBase.PSDERStorage pSDERStorage = psSystemStorage.getPSDERStorage(pSDER.getPSDERID());
            pSDERStorage.psDER = pSDER;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDERDEFMAP"));
        Vector<PSDERDEFMap> psDEDERDEFMapList = psSysModelCache.getModelList("PSDERDEFMAP", psSysModelLog);
        if (psDEDERDEFMapList == null) {
            psDEDERDEFMapList = new Vector<PSDERDEFMap>();
            CallResult callResult = this.getPSDERDEFMapsBySystem(strPSSystemId, psDEDERDEFMapList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDERDEFMAP", psSysModelLog, psDEDERDEFMapList);
        }
        for (PSDERDEFMap pSDERDEFMap : psDEDERDEFMapList) {
            psSystemStorage.getPSDERStorage((String)pSDERDEFMap.getPSDERID()).psDERDEFMapList.add(pSDERDEFMap);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDBCFG"));
        Vector<PSDEDBConfig> psDEDBConfigList = psSysModelCache.getModelList("PSDEDBCFG", psSysModelLog);
        if (psDEDBConfigList == null) {
            psDEDBConfigList = new Vector<PSDEDBConfig>();
            CallResult callResult = this.getPSDEDBConfigsBySystem(strPSSystemId, psDEDBConfigList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDBCFG", psSysModelLog, psDEDBConfigList);
        }
        for (PSDEDBConfig pSDEDBConfig : psDEDBConfigList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDBConfig.getPSDEID()).psDEDBConfigList.add(pSDEDBConfig);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDBINDEX"));
        Vector<PSDEDBIndex> psDEDBIndexList = psSysModelCache.getModelList("PSDEDBINDEX", psSysModelLog);
        if (psDEDBIndexList == null) {
            psDEDBIndexList = new Vector<PSDEDBIndex>();
            CallResult callResult = this.getPSDEDBIndexsBySystem(strPSSystemId, psDEDBIndexList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5e93\u7d22\u5f15\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDBINDEX", psSysModelLog, psDEDBIndexList);
        }
        for (PSDEDBIndex pSDEDBIndex : psDEDBIndexList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDBIndex.getPSDEID()).psDEDBIndexList.add(pSDEDBIndex);
            psSystemStorage.getPSDEDBIndexStorage((String)pSDEDBIndex.getPSDEDBINDEXID()).psDEDBIndex = pSDEDBIndex;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDBIDXFIELD"));
        Vector vector15 = psSysModelCache.getModelList("PSDEDBIDXFIELD", psSysModelLog, psSysModelLog2);
        if (vector15 == null) {
            Vector<PSDEDBIndexField> vector16 = new Vector<PSDEDBIndexField>();
            CallResult callResult = this.getPSDEDBIndexFieldsBySystem(strPSSystemId, vector16);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5e93\u7d22\u5f15\u5c5e\u6027\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDBIDXFIELD", psSysModelLog, psSysModelLog2, vector16);
        }
        for (PSDEDBIndexField pSDEDBIndexField : var10_862) {
            psSystemStorage.getPSDEDBIndexStorage((String)pSDEDBIndexField.getPSDEDBINDEXID()).psDEDBIndexFieldList.add(pSDEDBIndexField);
        }
        if (this.getModelInstVer() >= 602) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDETABLE"));
            Vector<PSDEDBTable> psDEDBTableList = psSysModelCache.getModelList("PSDETABLE", psSysModelLog);
            if (psDEDBTableList == null) {
                psDEDBTableList = new Vector<PSDEDBTable>();
                CallResult callResult = this.getPSDEDBTablesBySystem(strPSSystemId, psDEDBTableList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5e93\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDETABLE", psSysModelLog, psDEDBTableList);
            }
            for (PSDEDBTable pSDEDBTable : psDEDBTableList) {
                psSystemStorage.getPSDataEntityStorage((String)pSDEDBTable.getPSDEID()).psDEDBTableList.add(pSDEDBTable);
            }
        }
        if ((psDEDataSetList = psSysModelCache.getModelList("PSDEDATASET", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATASET")))) == null) {
            psDEDataSetList = new Vector<PSDEDataSet>();
            CallResult callResult = this.getPSDEDataSetsBySystem(strPSSystemId, psDEDataSetList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATASET", psSysModelLog, psDEDataSetList);
        }
        for (PSDEDataSet pSDEDataSet : psDEDataSetList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataSet.getPSDEID()).psDEDataSetList.add(pSDEDataSet);
            PSModelHelperBase.PSDEDataSetStorage pSDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(pSDEDataSet.getPSDEDATASETID());
            pSDEDataSetStorage.psDEDataSet = pSDEDataSet;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDSDQ"));
        Vector vector17 = psSysModelCache.getModelList("PSDEDSDQ", psSysModelLog, psSysModelLog2);
        if (vector17 == null) {
            Vector<PSDEDSDQ> vector18 = new Vector<PSDEDSDQ>();
            CallResult callResult = this.getPSDEDSDQsBySystem(strPSSystemId, vector18);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDSDQ", psSysModelLog, psSysModelLog2, vector18);
        }
        for (PSDEDSDQ pSDEDSDQ : var10_873) {
            PSModelHelperBase.PSDEDataSetStorage psDEDataSetStorage2 = psSystemStorage.getPSDEDataSetStorage(pSDEDSDQ.getPSDEDATASETID());
            psDEDataSetStorage2.psDEDSDQList.add(pSDEDSDQ);
        }
        Vector<PSDEDSGroupParam> psDEDSGroupParamList = psSysModelCache.getModelList("PSDEDSGRPPARAM", psSysModelLog);
        if (psDEDSGroupParamList == null) {
            psDEDSGroupParamList = new Vector<PSDEDSGroupParam>();
            CallResult callResult = this.getPSDEDSGroupParamsBySystem(strPSSystemId, psDEDSGroupParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u5206\u7ec4\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDSGRPPARAM", psSysModelLog, psDEDSGroupParamList);
        }
        for (PSDEDSGroupParam pSDEDSGroupParam : psDEDSGroupParamList) {
            PSModelHelperBase.PSDEDataSetStorage pSDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(pSDEDSGroupParam.getPSDEDSID());
            pSDEDataSetStorage.psDEDSGroupParamList.add(pSDEDSGroupParam);
        }
        if (this.getModelInstVer() >= 746) {
            Vector<PSDEDSParam> psDEDSParamList = psSysModelCache.getModelList("PSDEDSPARAM", psSysModelLog);
            if (psDEDSParamList == null) {
                psDEDSParamList = new Vector<PSDEDSParam>();
                CallResult callResult = this.getPSDEDSParamsBySystem(strPSSystemId, psDEDSParamList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u96c6\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEDSPARAM", psSysModelLog, psDEDSParamList);
            }
            for (PSDEDSParam pSDEDSParam : psDEDSParamList) {
                PSModelHelperBase.PSDEDataSetStorage pSDEDataSetStorage = psSystemStorage.getPSDEDataSetStorage(pSDEDSParam.getPSDEDSID());
                pSDEDataSetStorage.psDEDSParamList.add(pSDEDSParam);
            }
        }
        if ((psDEDataQueryList = psSysModelCache.getModelList("PSDEDATAQUERY", psDEDQLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAQUERY")))) == null) {
            psDEDataQueryList = new Vector<PSDEDataQuery>();
            CallResult callResult = this.getPSDEDataQueriesBySystem(strPSSystemId, psDEDataQueryList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAQUERY", psDEDQLog, psDEDataQueryList);
        }
        for (PSDEDataQuery pSDEDataQuery : psDEDataQueryList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataQuery.getPSDEID()).psDEDataQueryList.add(pSDEDataQuery);
            PSModelHelperBase.PSDEDataQueryStorage pSDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(pSDEDataQuery.getPSDEDATAQUERYID());
            pSDEDataQueryStorage.psDEDataQuery = pSDEDataQuery;
        }
        Vector<PSDEDataQueryCond> psDEDataQueryCondList = psSysModelCache.getModelList("PSDEDQCOND", psDEDQLog);
        if (psDEDataQueryCondList == null) {
            psDEDataQueryCondList = new Vector<PSDEDataQueryCond>();
            CallResult callResult = this.getPSDEDataQueryCondsBySystem(strPSSystemId, psDEDataQueryCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDQCOND", psDEDQLog, psDEDataQueryCondList);
        }
        for (PSDEDataQueryCond pSDEDataQueryCond : psDEDataQueryCondList) {
            PSModelHelperBase.PSDEDataQueryStorage pSDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(pSDEDataQueryCond.getPSDEDQID());
            pSDEDataQueryStorage.psDEDataQueryCondList.add(pSDEDataQueryCond);
        }
        Vector<PSDEDataQueryJoin> psDEDataQueryJoinList = psSysModelCache.getModelList("PSDEDQJOIN", psDEDQLog);
        if (psDEDataQueryJoinList == null) {
            psDEDataQueryJoinList = new Vector<PSDEDataQueryJoin>();
            CallResult callResult = this.getPSDEDataQueryJoinsBySystem(strPSSystemId, psDEDataQueryJoinList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDQJOIN", psDEDQLog, psDEDataQueryJoinList);
        }
        for (PSDEDataQueryJoin pSDEDataQueryJoin : psDEDataQueryJoinList) {
            PSModelHelperBase.PSDEDataQueryStorage pSDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(pSDEDataQueryJoin.getPSDEDQID());
            pSDEDataQueryStorage.psDEDataQueryJoinList.add(pSDEDataQueryJoin);
        }
        PSSysModelLog psDEDQCodeLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDQCODE"));
        Vector<PSDEDataQueryCode> psDEDataQueryCodeList = psSysModelCache.getModelList("PSDEDQCODE", psDEDQCodeLog);
        if (psDEDataQueryCodeList == null) {
            psDEDataQueryCodeList = new Vector<PSDEDataQueryCode>();
            CallResult callResult = this.getPSDEDataQueryCodesBySystem(strPSSystemId, psDEDataQueryCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDQCODE", psDEDQCodeLog, psDEDataQueryCodeList);
        }
        for (PSDEDataQueryCode pSDEDataQueryCode : psDEDataQueryCodeList) {
            PSModelHelperBase.PSDEDataQueryStorage pSDEDataQueryStorage = psSystemStorage.getPSDEDataQueryStorage(pSDEDataQueryCode.getPSDEDQID());
            pSDEDataQueryStorage.psDEDataQueryCodeList.add(pSDEDataQueryCode);
        }
        Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList = psSysModelCache.getModelList("PSDEDQCODEEXP", psDEDQCodeLog);
        if (psDEDataQueryCodeExpList == null) {
            psDEDataQueryCodeExpList = new Vector<PSDEDataQueryCodeExp>();
            CallResult callResult = this.getPSDEDataQueryCodeExpsBySystem(strPSSystemId, psDEDataQueryCodeExpList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDQCODEEXP", psDEDQCodeLog, psDEDataQueryCodeExpList);
        }
        for (PSDEDataQueryCodeExp pSDEDataQueryCodeExp : psDEDataQueryCodeExpList) {
            PSModelHelperBase.PSDEDataQueryCodeStorage pSDEDataQueryCodeStorage = psSystemStorage.getPSDEDataQueryCodeStorage(pSDEDataQueryCodeExp.getPSDEDQCodeId());
            pSDEDataQueryCodeStorage.psDEDataQueryCodeExpList.add(pSDEDataQueryCodeExp);
        }
        PSSysModelLog psDEDQCodeCondLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDQCODECOND"));
        Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList = psSysModelCache.getModelList("PSDEDQCODECOND", psDEDQCodeCondLog);
        if (psDEDataQueryCodeCondList == null) {
            psDEDataQueryCodeCondList = new Vector<PSDEDataQueryCodeCond>();
            CallResult callResult = this.getPSDEDataQueryCodeCondsBySystem(strPSSystemId, psDEDataQueryCodeCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDQCODECOND", psDEDQCodeCondLog, psDEDataQueryCodeCondList);
        }
        for (PSDEDataQueryCodeCond pSDEDataQueryCodeCond : psDEDataQueryCodeCondList) {
            PSModelHelperBase.PSDEDataQueryCodeStorage pSDEDataQueryCodeStorage = psSystemStorage.getPSDEDataQueryCodeStorage(pSDEDataQueryCodeCond.getPSDEDQCODEID());
            pSDEDataQueryCodeStorage.psDEDataQueryCodeCondList.add(pSDEDataQueryCodeCond);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDELOGIC"));
        Vector<PSDELogic> psDELogicList = psSysModelCache.getModelList("PSDELOGIC", psSysModelLog);
        if (psDELogicList == null) {
            psDELogicList = new Vector<PSDELogic>();
            CallResult callResult = this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGIC", psSysModelLog, psDELogicList);
        }
        for (PSDELogic pSDELogic : psDELogicList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDELogic.getPSDEID()).psDELogicList.add(pSDELogic);
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogic.getPSDELOGICID());
            pSDELogicStorage.psDELogic = pSDELogic;
            psSystemStorage.psDELogicList.add(pSDELogic);
            psSystemStorage.psDELogicMap.put(pSDELogic.getPSDELOGICID(), pSDELogic);
        }
        Vector<PSDELogicParam> psDELogicParamList = psSysModelCache.getModelList("PSDELOGICPARAM", psSysModelLog);
        if (psDELogicParamList == null) {
            psDELogicParamList = new Vector<PSDELogicParam>();
            CallResult callResult = this.getPSDELogicParamsBySystem(strPSSystemId, psDELogicParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICPARAM", psSysModelLog, psDELogicParamList);
        }
        for (PSDELogicParam pSDELogicParam : psDELogicParamList) {
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogicParam.getPSDELOGICID());
            pSDELogicStorage.psDELogicParamList.add(pSDELogicParam);
        }
        Vector<PSDELogicNode> psDELogicNodeList = psSysModelCache.getModelList("PSDELOGICNODE", psSysModelLog);
        if (psDELogicNodeList == null) {
            psDELogicNodeList = new Vector<PSDELogicNode>();
            CallResult callResult = this.getPSDELogicNodesBySystem(strPSSystemId, psDELogicNodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICNODE", psSysModelLog, psDELogicNodeList);
        }
        for (PSDELogicNode pSDELogicNode : psDELogicNodeList) {
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogicNode.getPSDELOGICID());
            pSDELogicStorage.psDELogicNodeList.add(pSDELogicNode);
        }
        Vector<PSDELogicLink> psDELogicLinkList = psSysModelCache.getModelList("PSDELOGICLINK", psSysModelLog);
        if (psDELogicLinkList == null) {
            psDELogicLinkList = new Vector<PSDELogicLink>();
            CallResult callResult = this.getPSDELogicLinksBySystem(strPSSystemId, psDELogicLinkList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICLINK", psSysModelLog, psDELogicLinkList);
        }
        for (PSDELogicLink pSDELogicLink : psDELogicLinkList) {
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogicLink.getPSDELOGICID());
            pSDELogicStorage.psDELogicLinkList.add(pSDELogicLink);
        }
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = psSysModelCache.getModelList("PSDELNPARAM", psSysModelLog);
        if (psDELogicNodeParamList == null) {
            psDELogicNodeParamList = new Vector<PSDELogicNodeParam>();
            CallResult callResult = this.getPSDELogicNodeParamsBySystem(strPSSystemId, psDELogicNodeParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53c2\u6570\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELNPARAM", psSysModelLog, psDELogicNodeParamList);
        }
        for (PSDELogicNodeParam pSDELogicNodeParam : psDELogicNodeParamList) {
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogicNodeParam.getPSDELOGICID());
            pSDELogicStorage.psDELogicNodeParamList.add(pSDELogicNodeParam);
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = psSysModelCache.getModelList("PSDELLCOND", psSysModelLog);
        if (psDELogicLinkCondList == null) {
            psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
            CallResult callResult = this.getPSDELogicLinkCondsBySystem(strPSSystemId, psDELogicLinkCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELLCOND", psSysModelLog, psDELogicLinkCondList);
        }
        for (PSDELogicLinkCond pSDELogicLinkCond : psDELogicLinkCondList) {
            PSModelHelperBase.PSDELogicStorage pSDELogicStorage = psSystemStorage.getPSDELogicStorage(pSDELogicLinkCond.getPSDELOGICID());
            pSDELogicStorage.psDELogicLinkCondList.add(pSDELogicLinkCond);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTION"));
        Vector<PSDEAction> psDEActionList = psSysModelCache.getModelList("PSDEACTION", psSysModelLog);
        if (psDEActionList == null) {
            psDEActionList = new Vector<PSDEAction>();
            CallResult callResult = this.getPSDEActionsBySystem(strPSSystemId, psDEActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u64cd\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACTION", psSysModelLog, psDEActionList);
        }
        for (PSDEAction pSDEAction : psDEActionList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEAction.getPSDEID()).psDEActionList.add(pSDEAction);
            PSModelHelperBase.PSDEActionStorage pSDEActionStorage = psSystemStorage.getPSDEActionStorage(pSDEAction.getPSDEACTIONID());
            pSDEActionStorage.psDEAction = pSDEAction;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTION"));
        Vector vector19 = psSysModelCache.getModelList("PSDEACTIONLOGIC", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONLOGIC")));
        if (vector19 == null) {
            Vector<PSDEActionLogic> vector20 = new Vector<PSDEActionLogic>();
            CallResult callResult = this.getPSDEActionLogicsBySystem(strPSSystemId, vector20);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACTIONLOGIC", psSysModelLog, psSysModelLog2, vector20);
        }
        for (PSDEActionLogic pSDEActionLogic : var10_936) {
            psDEActionStorage = psSystemStorage.getPSDEActionStorage(pSDEActionLogic.getPSDEACTIONID());
            psDEActionStorage.psDEActionLogicList.add(pSDEActionLogic);
        }
        if (this.getModelInstVer() >= 353) {
            void var10_939;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTION"));
            Vector vector21 = psSysModelCache.getModelList("PSDEACTIONPARAM", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONPARAM")));
            if (vector21 == null) {
                Vector<PSDEActionParam> vector22 = new Vector<PSDEActionParam>();
                CallResult callResult = this.getPSDEActionParamsBySystem(strPSSystemId, vector22);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEACTIONPARAM", psSysModelLog, psSysModelLog2, vector22);
            }
            for (PSDEActionParam pSDEActionParam : var10_939) {
                psDEActionStorage = psSystemStorage.getPSDEActionStorage(pSDEActionParam.getPSDEACTIONID());
                psDEActionStorage.psDEActionParamList.add(pSDEActionParam);
            }
        }
        if (this.getModelInstVer() >= 657) {
            void var10_943;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTION"));
            Vector vector23 = psSysModelCache.getModelList("PSDEACTIONVR", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONVR")));
            if (vector23 == null) {
                Vector<PSDEActionVR> vector24 = new Vector<PSDEActionVR>();
                CallResult callResult = this.getPSDEActionVRsBySystem(strPSSystemId, vector24);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEACTIONVR", psSysModelLog, psSysModelLog2, vector24);
            }
            for (PSDEActionVR pSDEActionVR : var10_943) {
                psDEActionStorage = psSystemStorage.getPSDEActionStorage(pSDEActionVR.getPSDEACTIONID());
                psDEActionStorage.psDEActionVRList.add(pSDEActionVR);
            }
        }
        if ((psACHandlerList = psSysModelCache.getModelList("PSACHANDLER", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSACHANDLER")))) == null) {
            psACHandlerList = new Vector<PSACHandler>();
            CallResult callResult = this.getPSACHandlersBySystem(strPSSystemId, psACHandlerList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u540e\u53f0\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSACHANDLER", psSysModelLog, psACHandlerList);
        }
        for (PSACHandler pSACHandler : psACHandlerList) {
            if (StringHelper.IsNullOrEmpty((String)pSACHandler.getPSDEID())) continue;
            psSystemStorage.getPSDataEntityStorage((String)pSACHandler.getPSDEID()).psACHandlerList.add(pSACHandler);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDRITEM"));
        Vector<PSDEDRItem> psDEDRItemList = psSysModelCache.getModelList("PSDEDRITEM", psSysModelLog);
        if (psDEDRItemList == null) {
            psDEDRItemList = new Vector<PSDEDRItem>();
            CallResult callResult = this.getPSDEDRItemsBySystem(strPSSystemId, psDEDRItemList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDRITEM", psSysModelLog, psDEDRItemList);
        }
        for (PSDEDRItem pSDEDRItem : psDEDRItemList) {
            if (StringHelper.IsNullOrEmpty((String)pSDEDRItem.getPSDEID())) continue;
            psSystemStorage.getPSDataEntityStorage((String)pSDEDRItem.getPSDEID()).psDEDRItemList.add(pSDEDRItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDRGROUP"));
        Vector<PSDEDRGroup> psDEDRGroupList = psSysModelCache.getModelList("PSDEDRGROUP", psSysModelLog);
        if (psDEDRGroupList == null) {
            psDEDRGroupList = new Vector<PSDEDRGroup>();
            CallResult callResult = this.getPSDEDRGroupsBySystem(strPSSystemId, psDEDRGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u5206\u7ec4\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDRGROUP", psSysModelLog, psDEDRGroupList);
        }
        for (PSDEDRGroup pSDEDRGroup : psDEDRGroupList) {
            if (StringHelper.IsNullOrEmpty((String)pSDEDRGroup.getPSDEID())) continue;
            psSystemStorage.getPSDataEntityStorage((String)pSDEDRGroup.getPSDEID()).psDEDRGroupList.add(pSDEDRGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAP"));
        Vector<PSDEMap> psDEMapList = psSysModelCache.getModelList("PSDEMAP", psSysModelLog);
        if (psDEMapList == null) {
            psDEMapList = new Vector<PSDEMap>();
            CallResult callResult = this.getPSDEMapsBySystem(strPSSystemId, psDEMapList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAP", psSysModelLog, psDEMapList);
        }
        for (PSDEMap pSDEMap : psDEMapList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEMap.getPSDEID()).psDEMapList.add(pSDEMap);
            PSModelHelperBase.PSDEMapStorage pSDEMapStorage = psSystemStorage.getPSDEMapStorage(pSDEMap.getPSDEMAPID());
            pSDEMapStorage.psDEMap = pSDEMap;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDETAIL"));
        Vector vector25 = psSysModelCache.getModelList("PSDEMAPDETAIL", psSysModelLog, psSysModelLog2);
        if (vector25 == null) {
            Vector<PSDEMapDetail> vector26 = new Vector<PSDEMapDetail>();
            CallResult callResult = this.getPSDEMapDetailsBySystem(strPSSystemId, vector26);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDETAIL", psSysModelLog, psSysModelLog2, vector26);
        }
        for (PSDEMapDetail pSDEMapDetail : var10_963) {
            psSystemStorage.getPSDEMapStorage((String)pSDEMapDetail.getPSDEMAPID()).psDEMapDetailList.add(pSDEMapDetail);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPACTION"));
        Vector vector27 = psSysModelCache.getModelList("PSDEMAPACTION", psSysModelLog, psSysModelLog2);
        if (vector27 == null) {
            Vector<PSDEMapAction> vector28 = new Vector<PSDEMapAction>();
            CallResult callResult = this.getPSDEMapActionsBySystem(strPSSystemId, vector28);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPACTION", psSysModelLog, psSysModelLog2, vector28);
        }
        for (PSDEMapAction pSDEMapAction : var10_966) {
            psSystemStorage.getPSDEMapStorage((String)pSDEMapAction.getPSDEMAPID()).psDEMapActionList.add(pSDEMapAction);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDQ"));
        Vector vector29 = psSysModelCache.getModelList("PSDEMAPDQ", psSysModelLog, psSysModelLog2);
        if (vector29 == null) {
            Vector<PSDEMapDataQuery> vector30 = new Vector<PSDEMapDataQuery>();
            CallResult callResult = this.getPSDEMapDataQueriesBySystem(strPSSystemId, vector30);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDQ", psSysModelLog, psSysModelLog2, vector30);
        }
        for (PSDEMapDataQuery pSDEMapDataQuery : var10_969) {
            psSystemStorage.getPSDEMapStorage((String)pSDEMapDataQuery.getPSDEMAPID()).psDEMapDataQueryList.add(pSDEMapDataQuery);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDS"));
        Vector vector31 = psSysModelCache.getModelList("PSDEMAPDS", psSysModelLog, psSysModelLog2);
        if (vector31 == null) {
            Vector<PSDEMapDataSet> vector32 = new Vector<PSDEMapDataSet>();
            CallResult callResult = this.getPSDEMapDataSetsBySystem(strPSSystemId, vector32);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u6570\u636e\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDS", psSysModelLog, psSysModelLog2, vector32);
        }
        for (PSDEMapDataSet pSDEMapDataSet : var10_972) {
            psSystemStorage.getPSDEMapStorage((String)pSDEMapDataSet.getPSDEMAPID()).psDEMapDataSetList.add(pSDEMapDataSet);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATARELATION"));
        Vector<PSDEDataRelation> psDEDataRelationList = psSysModelCache.getModelList("PSDEDATARELATION", psSysModelLog);
        if (psDEDataRelationList == null) {
            psDEDataRelationList = new Vector<PSDEDataRelation>();
            CallResult callResult = this.getPSDEDataRelationsBySystem(strPSSystemId, psDEDataRelationList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATARELATION", psSysModelLog, psDEDataRelationList);
        }
        for (PSDEDataRelation pSDEDataRelation : psDEDataRelationList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataRelation.getPSDEID()).psDEDataRelationList.add(pSDEDataRelation);
            PSModelHelperBase.PSDEDataRelationStorage pSDEDataRelationStorage = psSystemStorage.getPSDEDataRelationStorage(pSDEDataRelation.getPSDEDATARELATIONID());
            pSDEDataRelationStorage.psDEDataRelation = pSDEDataRelation;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDRDETAIL"));
        Vector vector33 = psSysModelCache.getModelList("PSDEDRDETAIL", psSysModelLog, psSysModelLog2);
        if (vector33 == null) {
            Vector<PSDEDRDetail> vector34 = new Vector<PSDEDRDetail>();
            CallResult callResult = this.getPSDEDRDetailsBySystem(strPSSystemId, vector34);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDRDETAIL", psSysModelLog, psSysModelLog2, vector34);
        }
        for (PSDEDRDetail pSDEDRDetail : var10_979) {
            psSystemStorage.getPSDEDataRelationStorage((String)pSDEDRDetail.getPSDEDRID()).psDEDRDetailList.add(pSDEDRDetail);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACMODE"));
        Vector<PSDEACMode> psDEACModeList = psSysModelCache.getModelList("PSDEACMODE", psSysModelLog);
        if (psDEACModeList == null) {
            psDEACModeList = new Vector<PSDEACMode>();
            CallResult callResult = this.getPSDEACModesBySystem(strPSSystemId, psDEACModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACMODE", psSysModelLog, psDEACModeList);
        }
        for (PSDEACMode pSDEACMode : psDEACModeList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEACMode.getPSDEID()).psDEACModeList.add(pSDEACMode);
            PSModelHelperBase.PSDEACModeStorage pSDEACModeStorage = psSystemStorage.getPSDEACModeStorage(pSDEACMode.getPSDEACMODEID());
            pSDEACModeStorage.psDEACMode = pSDEACMode;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACMODEITEM"));
        Vector vector35 = psSysModelCache.getModelList("PSDEACMODEITEM", psSysModelLog, psSysModelLog2);
        if (vector35 == null) {
            Vector<PSDEACModeItem> vector36 = new Vector<PSDEACModeItem>();
            CallResult callResult = this.getPSDEACModeItemsBySystem(strPSSystemId, vector36);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACMODEITEM", psSysModelLog, psSysModelLog2, vector36);
        }
        for (PSDEACModeItem pSDEACModeItem : var10_986) {
            psDEACModeStorage = psSystemStorage.getPSDEACModeStorage(pSDEACModeItem.getPSDEACMODEID());
            ((PSModelHelperBase.PSDEACModeStorage)((Object)psDEACModeStorage)).psDEACModeItemList.add(pSDEACModeItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        Vector<PSDEUIAction> psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION:SYS", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            CallResult callResult = this.getPSSysDEUIActions2(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUIACTION:SYS", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction pSDEUIAction : psDEUIActionList) {
            psSystemStorage.psDEUIActionList.add(pSDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            CallResult callResult = this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUIACTION", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction pSDEUIAction : psDEUIActionList) {
            psSystemStorage.psDEUIActionList2.add(pSDEUIAction);
            psSystemStorage.getPSDataEntityStorage((String)pSDEUIAction.getPSDEID()).psDEUIActionList.add(pSDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = psSysModelCache.getModelList("PSDEUAGROUP:SYS", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            CallResult callResult = this.getPSSysDEUIActionGroups2(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGROUP:SYS", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup pSDEUIActionGroup : psDEUIActionGroupList) {
            psSystemStorage.psDEUIActionGroupList.add(pSDEUIActionGroup);
            PSModelHelperBase.PSDEUIActionGroupStorage pSDEUIActionGroupStorage = psSystemStorage.getPSDEUIActionGroupStorage(pSDEUIActionGroup.getPSDEUAGROUPID());
            pSDEUIActionGroupStorage.psDEUIActionGroup = pSDEUIActionGroup;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSDEUAGROUP", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            CallResult callResult = this.getPSDEUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGROUP", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup pSDEUIActionGroup : psDEUIActionGroupList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEUIActionGroup.getPSDEID()).psDEUIActionGroupList.add(pSDEUIActionGroup);
            PSModelHelperBase.PSDEUIActionGroupStorage pSDEUIActionGroupStorage = psSystemStorage.getPSDEUIActionGroupStorage(pSDEUIActionGroup.getPSDEUAGROUPID());
            pSDEUIActionGroupStorage.psDEUIActionGroup = pSDEUIActionGroup;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLLOGICGROUP"));
        Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = psSysModelCache.getModelList("PSCTRLLOGICGROUP", psSysModelLog);
        if (psCtrlLogicGroupList == null) {
            psCtrlLogicGroupList = new Vector<PSCtrlLogicGroup>();
            CallResult callResult = this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u754c\u9762\u903b\u8f91\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSCTRLLOGICGROUP", psSysModelLog, psCtrlLogicGroupList);
        }
        for (PSCtrlLogicGroup pSCtrlLogicGroup : psCtrlLogicGroupList) {
            psSystemStorage.psCtrlLogicGroupList2.add(pSCtrlLogicGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFGROUP"));
        Vector<PSDEFGroup> psDEFGroupList = psSysModelCache.getModelList("PSDEFGROUP", psSysModelLog);
        if (psDEFGroupList == null) {
            psDEFGroupList = new Vector<PSDEFGroup>();
            CallResult callResult = this.getPSDEFGroupsBySystem(strPSSystemId, psDEFGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5c5e\u6027\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFGROUP", psSysModelLog, psDEFGroupList);
        }
        for (PSDEFGroup pSDEFGroup : psDEFGroupList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEFGroup.getPSDEID()).psDEFGroupList.add(pSDEFGroup);
            PSModelHelperBase.PSDEFGroupStorage pSDEFGroupStorage = psSystemStorage.getPSDEFGroupStorage(pSDEFGroup.getPSDEFGROUPID());
            pSDEFGroupStorage.psDEFGroup = pSDEFGroup;
        }
        if (this.getModelInstVer() >= 591) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGROUP"));
            Vector<PSDEGroup> psDEGroupList = psSysModelCache.getModelList("PSDEGROUP", psSysModelLog);
            if (psDEGroupList == null) {
                psDEGroupList = new Vector<PSDEGroup>();
                CallResult callResult = this.getPSDEGroupsBySystem(strPSSystemId, psDEGroupList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGROUP", psSysModelLog, psDEGroupList);
            }
            for (PSDEGroup pSDEGroup : psDEGroupList) {
                if (!StringHelper.IsNullOrEmpty((String)pSDEGroup.getPSDEID())) {
                    psSystemStorage.getPSDataEntityStorage((String)pSDEGroup.getPSDEID()).psDEGroupList.add(pSDEGroup);
                } else {
                    psSystemStorage.psDEGroupList.add(pSDEGroup);
                }
                PSModelHelperBase.PSDEGroupStorage pSDEGroupStorage = psSystemStorage.getPSDEGroupStorage(pSDEGroup.getPSDEGROUPID());
                pSDEGroupStorage.psDEGroup = pSDEGroup;
            }
        }
        if (this.getModelInstVer() >= 591) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDERGROUP"));
            Vector<PSDERGroup> psDERGroupList = psSysModelCache.getModelList("PSDERGROUP", psSysModelLog);
            if (psDERGroupList == null) {
                psDERGroupList = new Vector<PSDERGroup>();
                CallResult callResult = this.getPSDERGroupsBySystem(strPSSystemId, psDERGroupList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5173\u7cfb\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDERGROUP", psSysModelLog, psDERGroupList);
            }
            for (PSDERGroup pSDERGroup : psDERGroupList) {
                if (!StringHelper.IsNullOrEmpty((String)pSDERGroup.getPSDEID())) {
                    psSystemStorage.getPSDataEntityStorage((String)pSDERGroup.getPSDEID()).psDERGroupList.add(pSDERGroup);
                } else {
                    psSystemStorage.psDERGroupList.add(pSDERGroup);
                }
                PSModelHelperBase.PSDERGroupStorage pSDERGroupStorage = psSystemStorage.getPSDERGroupStorage(pSDERGroup.getPSDERGROUPID());
                pSDERGroupStorage.psDERGroup = pSDERGroup;
            }
        }
        if (this.getModelInstVer() >= 591) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONGROUP"));
            Vector<PSDEActionGroup> psDEActionGroupList = psSysModelCache.getModelList("PSDEACTIONGROUP", psSysModelLog);
            if (psDEActionGroupList == null) {
                psDEActionGroupList = new Vector<PSDEActionGroup>();
                CallResult callResult = this.getPSDEActionGroupsBySystem(strPSSystemId, psDEActionGroupList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEACTIONGROUP", psSysModelLog, psDEActionGroupList);
            }
            for (PSDEActionGroup pSDEActionGroup : psDEActionGroupList) {
                psSystemStorage.getPSDataEntityStorage((String)pSDEActionGroup.getPSDEID()).psDEActionGroupList.add(pSDEActionGroup);
                PSModelHelperBase.PSDEActionGroupStorage pSDEActionGroupStorage = psSystemStorage.getPSDEActionGroupStorage(pSDEActionGroup.getPSDEACTIONGROUPID());
                pSDEActionGroupStorage.psDEActionGroup = pSDEActionGroup;
            }
        }
        if ((psWFDEList = psSysModelCache.getModelList("PSWFDE", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWFDE")))) == null) {
            psWFDEList = new Vector<PSWFDE>();
            CallResult callResult = this.getPSWFDEsBySystem(strPSSystemId, psWFDEList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5de5\u4f5c\u6d41\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFDE", psSysModelLog, psWFDEList);
        }
        for (PSWFDE pSWFDE : psWFDEList) {
            psSystemStorage.getPSDataEntityStorage((String)pSWFDE.getPSDEID()).psWFDEList.add(pSWFDE);
            psSystemStorage.getPSWorkflowStorage((String)pSWFDE.getPSWFID()).psWFDEList.add(pSWFDE);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUNISTATE"));
        Vector<PSSysUniState> psDEUniStateList = psSysModelCache.getModelList("PSSYSUNISTATE", psSysModelLog);
        if (psDEUniStateList == null) {
            psDEUniStateList = new Vector<PSSysUniState>();
            CallResult callResult = this.getPSDEUniStatesBySystem(strPSSystemId, psDEUniStateList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUNISTATE", psSysModelLog, psDEUniStateList);
        }
        for (PSSysUniState pSSysUniState : psDEUniStateList) {
            psSystemStorage.getPSDataEntityStorage((String)pSSysUniState.getPSDEID()).psDEUniStateList.add(pSSysUniState);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDTSQUEUE"));
        Vector<PSSysDTSQueue> psDEDTSQueueList = psSysModelCache.getModelList("PSDEDTSQUEUE", psSysModelLog);
        if (psDEDTSQueueList == null) {
            psDEDTSQueueList = new Vector<PSSysDTSQueue>();
            CallResult callResult = this.getPSDEDTSQueuesBySystem(strPSSystemId, psDEDTSQueueList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDTSQUEUE", psSysModelLog, psDEDTSQueueList);
        }
        for (PSSysDTSQueue pSSysDTSQueue : psDEDTSQueueList) {
            psSystemStorage.getPSDataEntityStorage((String)pSSysDTSQueue.getPSDEID()).psDEDTSQueueList.add(pSSysDTSQueue);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEOPPRIV"));
        Vector<PSDEOPPriv> psDEOPPrivList = psSysModelCache.getModelList("PSDEOPPRIV", psSysModelLog);
        if (psDEOPPrivList == null) {
            psDEOPPrivList = new Vector<PSDEOPPriv>();
            CallResult callResult = this.getPSDEOPPrivsBySystem2(strPSSystemId, psDEOPPrivList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEOPPRIV", psSysModelLog, psDEOPPrivList);
        }
        for (PSDEOPPriv pSDEOPPriv : psDEOPPrivList) {
            String string = pSDEOPPriv.getPSDEID();
            if (StringHelper.IsNullOrEmpty((String)string)) continue;
            psSystemStorage.getPSDataEntityStorage((String)pSDEOPPriv.getPSDEID()).psDEOPPrivList.add(pSDEOPPriv);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAINSTATE"));
        Vector<PSDEMainState> psDEMainStateList = psSysModelCache.getModelList("PSDEMAINSTATE", psSysModelLog);
        if (psDEMainStateList == null) {
            psDEMainStateList = new Vector<PSDEMainState>();
            CallResult callResult = this.getPSDEMainStatesBySystem(strPSSystemId, psDEMainStateList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAINSTATE", psSysModelLog, psDEMainStateList);
        }
        for (PSDEMainState pSDEMainState : psDEMainStateList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEMainState.getPSDEID()).psDEMainStateList.add(pSDEMainState);
            PSModelHelperBase.PSDEMainStateStorage pSDEMainStateStorage = psSystemStorage.getPSDEMainStateStorage(pSDEMainState.getPSDEMAINSTATEID());
            pSDEMainStateStorage.psDEMainState = pSDEMainState;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMSACTION"));
        Vector vector37 = psSysModelCache.getModelList("PSDEMSACTION", psSysModelLog, psSysModelLog2);
        if (vector37 == null) {
            Vector<PSDEMainStateAction> vector38 = new Vector<PSDEMainStateAction>();
            CallResult callResult = this.getPSDEMainStateActionsBySystem(strPSSystemId, vector38);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMSACTION", psSysModelLog, psSysModelLog2, vector38);
        }
        for (PSDEMainStateAction pSDEMainStateAction : var10_1045) {
            psSystemStorage.getPSDEMainStateStorage((String)pSDEMainStateAction.getPSDEMSID()).psDEMainStateActionList.add(pSDEMainStateAction);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMSOPPRIV"));
        Vector vector39 = psSysModelCache.getModelList("PSDEMSOPPRIV", psSysModelLog, psSysModelLog2);
        if (vector39 == null) {
            Vector<PSDEMainStateOPPriv> vector40 = new Vector<PSDEMainStateOPPriv>();
            CallResult callResult = this.getPSDEMainStateOPPrivsBySystem(strPSSystemId, vector40);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMSOPPRIV", psSysModelLog, psSysModelLog2, vector40);
        }
        for (PSDEMainStateOPPriv pSDEMainStateOPPriv : var10_1048) {
            psSystemStorage.getPSDEMainStateStorage((String)pSDEMainStateOPPriv.getPSDEMAINSTATEID()).psDEMainStateOPPrivList.add(pSDEMainStateOPPriv);
        }
        if (this.getModelInstVer() >= 659) {
            void var10_1051;
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMSFIELD"));
            Vector vector41 = psSysModelCache.getModelList("PSDEMSFIELD", psSysModelLog, psSysModelLog2);
            if (vector41 == null) {
                Vector<PSDEMainStateField> vector42 = new Vector<PSDEMainStateField>();
                CallResult callResult = this.getPSDEMainStateFieldsBySystem(strPSSystemId, vector42);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEMSFIELD", psSysModelLog, psSysModelLog2, vector42);
            }
            for (PSDEMainStateField pSDEMainStateField : var10_1051) {
                psSystemStorage.getPSDEMainStateStorage((String)pSDEMainStateField.getPSDEMSID()).psDEMainStateFieldList.add(pSDEMainStateField);
            }
        }
        if (this.getModelInstVer() >= 691) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAINSTATERS"));
            Vector<PSDEMainStateRS> psDEMainStateRSList = psSysModelCache.getModelList("PSDEMAINSTATERS", psSysModelLog);
            if (psDEMainStateRSList == null) {
                psDEMainStateRSList = new Vector<PSDEMainStateRS>();
                CallResult callResult = this.getPSDEMainStateRSsBySystem(strPSSystemId, psDEMainStateRSList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEMAINSTATERS", psSysModelLog, psDEMainStateRSList);
            }
            for (PSDEMainStateRS pSDEMainStateRS : psDEMainStateRSList) {
                String string = pSDEMainStateRS.getPSDEID();
                psSystemStorage.getPSDataEntityStorage((String)pSDEMainStateRS.getPSDEID()).psDEMainStateRSList.add(pSDEMainStateRS);
            }
        }
        if ((psDEDataExportList = psSysModelCache.getModelList("PSDEDATAEXP", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAEXP")))) == null) {
            psDEDataExportList = new Vector<PSDEDataExport>();
            CallResult callResult = this.getPSDEDataExportsBySystem(strPSSystemId, psDEDataExportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAEXP", psSysModelLog, psDEDataExportList);
        }
        for (PSDEDataExport pSDEDataExport : psDEDataExportList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataExport.getPSDEID()).psDEDataExportList.add(pSDEDataExport);
            PSModelHelperBase.PSDEDataExportStorage pSDEDataExportStorage = psSystemStorage.getPSDEDataExportStorage(pSDEDataExport.getPSDEDATAEXPID());
            pSDEDataExportStorage.psDEDataExport = pSDEDataExport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGRIDCOL"));
        if (psSysModelLog2 == null) {
            psSysModelLog2 = psSysModelLog;
        }
        if ((vector2 = psSysModelCache.getModelList("PSDEDATAEXPITEM", psSysModelLog2)) == null) {
            Vector<PSDEGridColumn> vector43 = new Vector<PSDEGridColumn>();
            CallResult callResult = this.getPSDEDataExportItemsBySystem(strPSSystemId, vector43);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAEXPITEM", psSysModelLog2, vector43);
        }
        for (PSDEGridColumn pSDEGridColumn : var10_1063) {
            psSystemStorage.getPSDEDataExportStorage((String)pSDEGridColumn.getParamStringValue((String)"PSDEDATAEXPID", (String)"")).psDEGridColumnList.add(pSDEGridColumn);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAIMP"));
        Vector<PSDEDataImport> psDEDataImportList = psSysModelCache.getModelList("PSDEDATAIMP", psSysModelLog);
        if (psDEDataImportList == null) {
            psDEDataImportList = new Vector<PSDEDataImport>();
            CallResult callResult = this.getPSDEDataImportsBySystem(strPSSystemId, psDEDataImportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAIMP", psSysModelLog, psDEDataImportList);
        }
        for (PSDEDataImport pSDEDataImport : psDEDataImportList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataImport.getPSDEID()).psDEDataImportList.add(pSDEDataImport);
            PSModelHelperBase.PSDEDataImportStorage pSDEDataImportStorage = psSystemStorage.getPSDEDataImportStorage(pSDEDataImport.getPSDEDATAIMPID());
            pSDEDataImportStorage.psDEDataImport = pSDEDataImport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAIMPITEM"));
        Vector vector44 = psSysModelCache.getModelList("PSDEDATAIMPITEM", psSysModelLog, psSysModelLog2);
        if (vector44 == null) {
            Vector<PSDEDataImportItem> vector45 = new Vector<PSDEDataImportItem>();
            CallResult callResult = this.getPSDEDataImportItemsBySystem(strPSSystemId, vector45);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAIMPITEM", psSysModelLog, psSysModelLog2, vector45);
        }
        for (PSDEDataImportItem pSDEDataImportItem : var10_1070) {
            psSystemStorage.getPSDEDataImportStorage((String)pSDEDataImportItem.getParamStringValue((String)"PSDEDATAIMPID", (String)"")).psDEDataImportItemList.add(pSDEDataImportItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEREPORT"));
        Vector<PSDEReport> psDEReportList = psSysModelCache.getModelList("PSDEREPORT", psSysModelLog);
        if (psDEReportList == null) {
            psDEReportList = new Vector<PSDEReport>();
            CallResult callResult = this.getPSDEReportsBySystem(strPSSystemId, psDEReportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEREPORT", psSysModelLog, psDEReportList);
        }
        for (PSDEReport pSDEReport : psDEReportList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEReport.getPSDEID()).psDEReportList.add(pSDEReport);
            PSModelHelperBase.PSDEReportStorage pSDEReportStorage = psSystemStorage.getPSDEReportStorage(pSDEReport.getPSDEREPORTID());
            pSDEReportStorage.psDEReport = pSDEReport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEREPITEM"));
        Vector vector46 = psSysModelCache.getModelList("PSDEREPITEM", psSysModelLog, psSysModelLog2);
        if (vector46 == null) {
            Vector<PSDEReportItem> vector47 = new Vector<PSDEReportItem>();
            CallResult callResult = this.getPSDEReportItemsBySystem(strPSSystemId, vector47);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u62a5\u8868\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEREPITEM", psSysModelLog, psSysModelLog2, vector47);
        }
        for (PSDEReportItem pSDEReportItem : var10_1077) {
            psSystemStorage.getPSDEReportStorage((String)pSDEReportItem.getMAJORPSDEREPORTID()).psDEReportItemList.add(pSDEReportItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEPRINT"));
        Vector<PSDEPrint> psDEPrintList = psSysModelCache.getModelList("PSDEPRINT", psSysModelLog);
        if (psDEPrintList == null) {
            psDEPrintList = new Vector<PSDEPrint>();
            CallResult callResult = this.getPSDEPrintsBySystem(strPSSystemId, psDEPrintList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEPRINT", psSysModelLog, psDEPrintList);
        }
        for (PSDEPrint pSDEPrint : psDEPrintList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEPrint.getPSDEID()).psDEPrintList.add(pSDEPrint);
            PSModelHelperBase.PSDEPrintStorage pSDEPrintStorage = psSystemStorage.getPSDEPrintStorage(pSDEPrint.getPSDEPRINTID());
            pSDEPrintStorage.psDEPrint = pSDEPrint;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUTILDE"));
        Vector<PSDEUtil> psDEUtilList = psSysModelCache.getModelList("PSDEUTILDE", psSysModelLog);
        if (psDEUtilList == null) {
            psDEUtilList = new Vector<PSDEUtil>();
            CallResult callResult = this.getPSDEUtilsBySystem(strPSSystemId, psDEUtilList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u8f85\u52a9\u529f\u80fd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUTILDE", psSysModelLog, psDEUtilList);
        }
        for (PSDEUtil pSDEUtil : psDEUtilList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEUtil.getPSDEID()).psDEUtilList.add(pSDEUtil);
            PSModelHelperBase.PSDEUtilStorage pSDEUtilStorage = psSystemStorage.getPSDEUtilStorage(pSDEUtil.getPSDEUTILDEID());
            pSDEUtilStorage.psDEUtil = pSDEUtil;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUSERROLE"));
        Vector<PSDEUserRole> psDEUserRoleList = psSysModelCache.getModelList("PSDEUSERROLE", psSysModelLog);
        if (psDEUserRoleList == null) {
            psDEUserRoleList = new Vector<PSDEUserRole>();
            CallResult callResult = this.getPSDEUserRolesBySystem(strPSSystemId, psDEUserRoleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u7528\u6237\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUSERROLE", psSysModelLog, psDEUserRoleList);
        }
        for (PSDEUserRole pSDEUserRole : psDEUserRoleList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEUserRole.getPSDEID()).psDEUserRoleList.add(pSDEUserRole);
            PSModelHelperBase.PSDEUserRoleStorage pSDEUserRoleStorage = psSystemStorage.getPSDEUserRoleStorage(pSDEUserRole.getPSDEUSERROLEID());
            pSDEUserRoleStorage.psDEUserRole = pSDEUserRole;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEOPPRIVROLE"));
        Vector<PSDEOPPrivRole> psDEOPPrivRoleList = psSysModelCache.getModelList("PSDEOPPRIVROLE", psSysModelLog);
        if (psDEOPPrivRoleList == null) {
            psDEOPPrivRoleList = new Vector<PSDEOPPrivRole>();
            CallResult callResult = this.getPSDEOPPrivRolesBySystem(strPSSystemId, psDEOPPrivRoleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u7528\u6237\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEOPPRIVROLE", psSysModelLog, psDEOPPrivRoleList);
        }
        for (PSDEOPPrivRole pSDEOPPrivRole : psDEOPPrivRoleList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEOPPrivRole.getPSDEID()).psDEOPPrivRoleList.add(pSDEOPPrivRole);
            PSModelHelperBase.PSDEOPPrivRoleStorage pSDEOPPrivRoleStorage = psSystemStorage.getPSDEOPPrivRoleStorage(pSDEOPPrivRole.getPSDEOPPRIVROLEID());
            pSDEOPPrivRoleStorage.psDEOPPrivRole = pSDEOPPrivRole;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERMODE"));
        Vector<PSSysUserMode> psSysUserModeList = psSysModelCache.getModelList("PSSYSUSERMODE", psSysModelLog);
        if (psSysUserModeList == null) {
            psSysUserModeList = new Vector<PSSysUserMode>();
            CallResult callResult = this.getAllPSSysUserModes2(strPSSystemId, psSysUserModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u6237\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUSERMODE", psSysModelLog, psSysUserModeList);
        }
        psSystemStorage.psSysUserModeList.addAll(psSysUserModeList);
        for (PSSysUserMode pSSysUserMode : psSysUserModeList) {
            psSystemStorage.psSysUserModeMap.put(pSSysUserMode.getPSSYSUSERMODEID(), pSSysUserMode);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERDR"));
        Vector<PSSysUserDR> psSysUserDRList = psSysModelCache.getModelList("PSSYSUSERDR", psSysModelLog);
        if (psSysUserDRList == null) {
            psSysUserDRList = new Vector<PSSysUserDR>();
            CallResult callResult = this.getAllPSSysUserDRs2(strPSSystemId, psSysUserDRList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u81ea\u5b9a\u4e49\u6743\u9650\u6570\u636e\u8303\u56f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUSERDR", psSysModelLog, psSysUserDRList);
        }
        psSystemStorage.psSysUserDRList.addAll(psSysUserDRList);
        for (PSSysUserDR pSSysUserDR : psSysUserDRList) {
            psSystemStorage.psSysUserDRMap.put(pSSysUserDR.getPSSYSUSERDRID(), pSSysUserDR);
        }
        if (this.getModelInstVer() >= 387) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDESAMPLEDATA"));
            Vector<PSDESampleData> psDESampleDataList = psSysModelCache.getModelList("PSDESAMPLEDATA", psSysModelLog);
            if (psDESampleDataList == null) {
                psDESampleDataList = new Vector<PSDESampleData>();
                CallResult callResult = this.getPSDESampleDatasBySystem(strPSSystemId, psDESampleDataList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDESAMPLEDATA", psSysModelLog, psDESampleDataList);
            }
            for (PSDESampleData pSDESampleData : psDESampleDataList) {
                psSystemStorage.getPSDataEntityStorage((String)pSDESampleData.getPSDEID()).psDESampleDataList.add(pSDESampleData);
            }
        }
        if (this.getModelInstVer() >= 598) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSACTOR"));
            Vector<PSSysActor> psSysActorList = psSysModelCache.getModelList("PSSYSACTOR", psSysModelLog);
            if (psSysActorList == null) {
                psSysActorList = new Vector<PSSysActor>();
                CallResult callResult = this.getAllPSSysActors2(strPSSystemId, psSysActorList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u64cd\u4f5c\u8005\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSACTOR", psSysModelLog, psSysActorList);
            }
            psSystemStorage.psSysActorList.addAll(psSysActorList);
            for (PSSysActor pSSysActor : psSysActorList) {
                psSystemStorage.psSysActorMap.put(pSSysActor.getPSSYSACTORID(), pSSysActor);
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERCASE"));
            Vector<PSSysUserCase> psSysUserCaseList = psSysModelCache.getModelList("PSSYSUSERCASE", psSysModelLog);
            if (psSysUserCaseList == null) {
                psSysUserCaseList = new Vector<PSSysUserCase>();
                CallResult callResult = this.getAllPSSysUserCases2(strPSSystemId, psSysUserCaseList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSUSERCASE", psSysModelLog, psSysUserCaseList);
            }
            psSystemStorage.psSysUserCaseList.addAll(psSysUserCaseList);
            for (PSSysUserCase pSSysUserCase : psSysUserCaseList) {
                psSystemStorage.psSysUserCaseMap.put(pSSysUserCase.getPSSYSUSERCASEID(), pSSysUserCase);
            }
            if (this.getModelInstVer() >= 598) {
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUSERCASERS"));
                Vector<PSSysUserCaseRS> psSysUserCaseRSList = psSysModelCache.getModelList("PSSYSUSERCASERS", psSysModelLog);
                if (psSysUserCaseRSList == null) {
                    psSysUserCaseRSList = new Vector<PSSysUserCaseRS>();
                    CallResult callResult = this.getAllPSSysUserCaseRSs2(strPSSystemId, psSysUserCaseRSList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7528\u4f8b\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSUSERCASERS", psSysModelLog, psSysUserCaseRSList);
                }
                psSystemStorage.psSysUserCaseRSList.addAll(psSysUserCaseRSList);
                for (PSSysUserCaseRS pSSysUserCaseRS : psSysUserCaseRSList) {
                    psSystemStorage.psSysUserCaseRSMap.put(pSSysUserCaseRS.getPSSYSUSERCASERSID(), pSSysUserCaseRS);
                }
            }
        }
        if ((psSysSampleValueList = psSysModelCache.getModelList("PSSYSSAMPLEVALUE", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSAMPLEVALUE")))) == null) {
            psSysSampleValueList = new Vector<PSSysSampleValue>();
            CallResult callResult = this.getAllPSSysSampleValues2(strPSSystemId, psSysSampleValueList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u793a\u4f8b\u503c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSSAMPLEVALUE", psSysModelLog, psSysSampleValueList);
        }
        psSystemStorage.psSysSampleValueList.addAll(psSysSampleValueList);
        for (PSSysSampleValue pSSysSampleValue : psSysSampleValueList) {
            psSystemStorage.psSysSampleValueMap.put(pSSysSampleValue.getPSSYSSAMPLEVALUEID(), pSSysSampleValue);
        }
        if (this.getModelInstVer() >= 585) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSRESOURCE"));
            Vector<PSSysResource> psSysResourceList = psSysModelCache.getModelList("PSSYSRESOURCE", psSysModelLog);
            if (psSysResourceList == null) {
                psSysResourceList = new Vector<PSSysResource>();
                CallResult callResult = this.getAllPSSysResources2(strPSSystemId, psSysResourceList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9884\u7f6e\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSRESOURCE", psSysModelLog, psSysResourceList);
            }
            psSystemStorage.psSysResourceList.addAll(psSysResourceList);
            for (PSSysResource pSSysResource : psSysResourceList) {
                psSystemStorage.psSysResourceMap.put(pSSysResource.getPSSYSRESOURCEID(), pSSysResource);
            }
        }
        if ((psSysDBValueFuncList = psSysModelCache.getModelList("PSSYSDBVF", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDBVF")))) == null) {
            psSysDBValueFuncList = new Vector<PSSysDBValueFunc>();
            CallResult callResult = this.getAllPSSysDBValueFuncs2(strPSSystemId, psSysDBValueFuncList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u503c\u51fd\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDBVF", psSysModelLog, psSysDBValueFuncList);
        }
        psSystemStorage.psSysDBValueFuncList.addAll(psSysDBValueFuncList);
        for (PSSysDBValueFunc pSSysDBValueFunc : psSysDBValueFuncList) {
            psSystemStorage.psSysDBValueFuncMap.put(pSSysDBValueFunc.getPSSYSDBVFID(), pSSysDBValueFunc);
        }
        if (this.getModelInstVer() >= 683) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEQUENCE"));
            Vector<PSSysSequence> psSysSequenceList = psSysModelCache.getModelList("PSSYSSEQUENCE", psSysModelLog);
            if (psSysSequenceList == null) {
                psSysSequenceList = new Vector<PSSysSequence>();
                CallResult callResult = this.getAllPSSysSequences2(strPSSystemId, psSysSequenceList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u503c\u5e8f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEQUENCE", psSysModelLog, psSysSequenceList);
            }
            psSystemStorage.psSysSequenceList.addAll(psSysSequenceList);
            for (PSSysSequence pSSysSequence : psSysSequenceList) {
                psSystemStorage.psSysSequenceMap.put(pSSysSequence.getPSSYSSEQUENCEID(), pSSysSequence);
            }
        }
        if (this.getModelInstVer() >= 685) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTRANSLATOR"));
            Vector<PSSysTranslator> psSysTranslatorList = psSysModelCache.getModelList("PSSYSTRANSLATOR", psSysModelLog);
            if (psSysTranslatorList == null) {
                psSysTranslatorList = new Vector<PSSysTranslator>();
                CallResult callResult = this.getAllPSSysTranslators2(strPSSystemId, psSysTranslatorList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u503c\u8f6c\u6362\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTRANSLATOR", psSysModelLog, psSysTranslatorList);
            }
            psSystemStorage.psSysTranslatorList.addAll(psSysTranslatorList);
            for (PSSysTranslator pSSysTranslator : psSysTranslatorList) {
                psSystemStorage.psSysTranslatorMap.put(pSSysTranslator.getPSSYSTRANSLATORID(), pSSysTranslator);
            }
        }
        if (this.getModelInstVer() >= 691) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSMSGQUEUE"));
            Vector<PSSysMsgQueue> psSysMsgQueueList = psSysModelCache.getModelList("PSSYSMSGQUEUE", psSysModelLog);
            if (psSysMsgQueueList == null) {
                psSysMsgQueueList = new Vector<PSSysMsgQueue>();
                CallResult callResult = this.getAllPSSysMsgQueues2(strPSSystemId, psSysMsgQueueList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d88\u606f\u961f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSMSGQUEUE", psSysModelLog, psSysMsgQueueList);
            }
            psSystemStorage.psSysMsgQueueList.addAll(psSysMsgQueueList);
        }
        if (this.getModelInstVer() >= 691) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSMSGTARGET"));
            Vector<PSSysMsgTarget> psSysMsgTargetList = psSysModelCache.getModelList("PSSYSMSGTARGET", psSysModelLog);
            if (psSysMsgTargetList == null) {
                psSysMsgTargetList = new Vector<PSSysMsgTarget>();
                CallResult callResult = this.getAllPSSysMsgTargets2(strPSSystemId, psSysMsgTargetList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d88\u606f\u76ee\u6807\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSMSGTARGET", psSysModelLog, psSysMsgTargetList);
            }
            psSystemStorage.psSysMsgTargetList.addAll(psSysMsgTargetList);
        }
        if (this.getModelInstVer() >= 691) {
            void var10_1148;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDENOTIFY"));
            Vector<PSDENotify> psDENotifyList = psSysModelCache.getModelList("PSDENOTIFY", psSysModelLog);
            if (psDENotifyList == null) {
                psDENotifyList = new Vector<PSDENotify>();
                CallResult callResult = this.getPSDENotifiesBySystem(strPSSystemId, psDENotifyList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u901a\u77e5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDENOTIFY", psSysModelLog, psDENotifyList);
            }
            for (PSDENotify pSDENotify : psDENotifyList) {
                psSystemStorage.getPSDataEntityStorage((String)pSDENotify.getPSDEID()).psDENotifyList.add(pSDENotify);
                PSModelHelperBase.PSDENotifyStorage pSDENotifyStorage = psSystemStorage.getPSDENotifyStorage(pSDENotify.getPSDENOTIFYID());
                pSDENotifyStorage.psDENotify = pSDENotify;
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDENOTIFYTARGET"));
            Vector vector48 = psSysModelCache.getModelList("PSDENOTIFYTARGET", psSysModelLog, psSysModelLog2);
            if (vector48 == null) {
                Vector<PSDENotifyTarget> vector49 = new Vector<PSDENotifyTarget>();
                CallResult callResult = this.getPSDENotifyTargetsBySystem(strPSSystemId, vector49);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u901a\u77e5\u76ee\u6807\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDENOTIFYTARGET", psSysModelLog, psSysModelLog2, vector49);
            }
            for (PSDENotifyTarget pSDENotifyTarget : var10_1148) {
                psSystemStorage.getPSDENotifyStorage((String)pSDENotifyTarget.getPSDENOTIFYID()).psDENotifyTargetList.add(pSDENotifyTarget);
            }
        }
        if (this.getModelInstVer() >= 598) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCONTENTCAT"));
            Vector<PSSysContentCat> psSysContentCatList = psSysModelCache.getModelList("PSSYSCONTENTCAT", psSysModelLog);
            if (psSysContentCatList == null) {
                psSysContentCatList = new Vector<PSSysContentCat>();
                CallResult callResult = this.getAllPSSysContentCats2(strPSSystemId, psSysContentCatList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5185\u5bb9\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCONTENTCAT", psSysModelLog, psSysContentCatList);
            }
            Iterator iterator5 = psSysContentCatList.iterator();
            while (iterator5.hasNext()) {
                PSSysContentCat pSSysContentCat;
                psSystemStorage.getPSSysContentCatStorage((String)pSSysContentCat.getPSSYSCONTENTCATID()).psSysContentCat = pSSysContentCat = (PSSysContentCat)((Object)iterator5.next());
                if (StringHelper.IsNullOrEmpty((String)pSSysContentCat.getPPSSYSCONTENTCATID())) {
                    psSystemStorage.psSysContentCatList.add(pSSysContentCat);
                    continue;
                }
                psSystemStorage.getPSSysContentCatStorage((String)pSSysContentCat.getPPSSYSCONTENTCATID()).psSysContentCatList.add(pSSysContentCat);
            }
        }
        if (this.getModelInstVer() >= 585) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCONTENT"));
            Vector<PSSysContent> psSysContentList = psSysModelCache.getModelList("PSSYSCONTENT", psSysModelLog);
            if (psSysContentList == null) {
                psSysContentList = new Vector<PSSysContent>();
                CallResult callResult = this.getAllPSSysContents2(strPSSystemId, psSysContentList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9884\u7f6e\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCONTENT", psSysModelLog, psSysContentList);
            }
            for (PSSysContent pSSysContent : psSysContentList) {
                psSystemStorage.psSysContentMap.put(pSSysContent.getPSSYSCONTENTID(), pSSysContent);
                psSystemStorage.getPSSysContentCatStorage((String)pSSysContent.getPSSYSCONTENTCATID()).psSysContentList.add(pSSysContent);
            }
        }
        if (this.getModelInstVer() >= 602) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSREQMODULE"));
            Vector<PSSysReqModule> psSysReqModuleList = psSysModelCache.getModelList("PSSYSREQMODULE", psSysModelLog);
            if (psSysReqModuleList == null) {
                psSysReqModuleList = new Vector<PSSysReqModule>();
                CallResult callResult = this.getAllPSSysReqModules2(strPSSystemId, psSysReqModuleList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9700\u6c42\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSREQMODULE", psSysModelLog, psSysReqModuleList);
            }
            Iterator iterator6 = psSysReqModuleList.iterator();
            while (iterator6.hasNext()) {
                PSSysReqModule pSSysReqModule;
                psSystemStorage.getPSSysReqModuleStorage((String)pSSysReqModule.getPSSYSREQMODULEID()).psSysReqModule = pSSysReqModule = (PSSysReqModule)((Object)iterator6.next());
                if (StringHelper.IsNullOrEmpty((String)pSSysReqModule.getPPSSYSREQMODULEID())) {
                    psSystemStorage.psSysReqModuleList.add(pSSysReqModule);
                    continue;
                }
                psSystemStorage.getPSSysReqModuleStorage((String)pSSysReqModule.getPPSSYSREQMODULEID()).psSysReqModuleList.add(pSSysReqModule);
            }
        }
        if (this.getModelInstVer() >= 602) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSREQITEM"));
            Vector<PSSysReqItem> psSysReqItemList = psSysModelCache.getModelList("PSSYSREQITEM", psSysModelLog);
            if (psSysReqItemList == null) {
                psSysReqItemList = new Vector<PSSysReqItem>();
                CallResult callResult = this.getAllPSSysReqItems2(strPSSystemId, psSysReqItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9700\u6c42\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSREQITEM", psSysModelLog, psSysReqItemList);
            }
            for (PSSysReqItem pSSysReqItem : psSysReqItemList) {
                psSystemStorage.psSysReqItemMap.put(pSSysReqItem.getPSSYSREQITEMID(), pSSysReqItem);
                psSystemStorage.psSysReqItemList.add(pSSysReqItem);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
            void var11_291;
            void var11_288;
            void var10_1182;
            void var10_1172;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTESTDATA"));
            Vector<PSSysTestData> psSysTestDataList = psSysModelCache.getModelList("PSSYSTESTDATA", psSysModelLog);
            if (psSysTestDataList == null) {
                psSysTestDataList = new Vector<PSSysTestData>();
                CallResult callResult = this.getAllPSSysTestDatas2(strPSSystemId, psSysTestDataList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTESTDATA", psSysModelLog, psSysTestDataList);
            }
            psSystemStorage.psSysTestDataList.addAll(psSysTestDataList);
            for (PSSysTestData pSSysTestData : psSysTestDataList) {
                psSystemStorage.psSysTestDataMap.put(pSSysTestData.getPSSYSTESTDATAID(), pSSysTestData);
                psSystemStorage.getPSSysTestDataStorage((String)pSSysTestData.getPSSYSTESTDATAID()).psSysTestData = pSSysTestData;
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTDITEM"));
            Vector vector50 = psSysModelCache.getModelList("PSSYSTDITEM", psSysModelLog, psSysModelLog2);
            if (vector50 == null) {
                Vector<PSSysTestDataItem> vector51 = new Vector<PSSysTestDataItem>();
                CallResult callResult = this.getPSSysTestDataItemsBySystem(strPSSystemId, vector51);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTDITEM", psSysModelLog, psSysModelLog2, vector51);
            }
            for (PSSysTestDataItem pSSysTestDataItem : var10_1172) {
                psSystemStorage.getPSSysTestDataStorage((String)pSSysTestDataItem.getPSSYSTESTDATAID()).psSysTestDataItemList.add(pSSysTestDataItem);
            }
            if (this.getModelInstVer() >= 602) {
                void var10_1178;
                void var10_1175;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTESTPRJ"));
                bLoadDetail = true;
                Vector vector52 = psSysModelCache.getModelList("PSSYSTESTPRJ", psSysModelLog);
                if (vector52 == null) {
                    Vector<PSSysTestPrj> vector53 = new Vector<PSSysTestPrj>();
                    CallResult callResult = this.getAllPSSysTestPrjs2(strPSSystemId, vector53);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSTESTPRJ", psSysModelLog, vector53);
                }
                psSystemStorage.psSysTestPrjList.addAll((Collection<PSSysTestPrj>)var10_1175);
                for (PSSysTestPrj pSSysTestPrj : var10_1175) {
                    psSystemStorage.psSysTestPrjMap.put(pSSysTestPrj.getPSSYSTESTPRJID(), pSSysTestPrj);
                    psSystemStorage.getPSSysTestPrjStorage((String)pSSysTestPrj.getPSSYSTESTPRJID()).psSysTestPrj = pSSysTestPrj;
                }
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTESTMODULE"));
                bLoadDetail = true;
                Vector vector54 = psSysModelCache.getModelList("PSSYSTESTMODULE", psSysModelLog);
                if (vector54 == null) {
                    Vector<PSSysTestModule> vector55 = new Vector<PSSysTestModule>();
                    CallResult callResult = this.getAllPSSysTestModules2(strPSSystemId, vector55);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSTESTMODULE", psSysModelLog, vector55);
                }
                for (PSSysTestModule pSSysTestModule : var10_1178) {
                    psSystemStorage.getPSSysTestPrjStorage((String)pSSysTestModule.getPSSYSTESTPRJID()).psSysTestModuleList.add(pSSysTestModule);
                    psSystemStorage.psSysTestModuleMap.put(pSSysTestModule.getPSSYSTESTMODULEID(), pSSysTestModule);
                    psSystemStorage.getPSSysTestModuleStorage((String)pSSysTestModule.getPSSYSTESTMODULEID()).psSysTestModule = pSSysTestModule;
                }
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTESTCASE"));
            bLoadDetail = true;
            Vector vector56 = psSysModelCache.getModelList("PSSYSTESTCASE", psSysModelLog);
            if (vector56 == null) {
                Vector<PSSysTestCase> vector57 = new Vector<PSSysTestCase>();
                CallResult callResult = this.getAllPSSysTestCases2(strPSSystemId, vector57);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u7528\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTESTCASE", psSysModelLog, vector57);
            }
            for (PSSysTestCase pSSysTestCase : var10_1182) {
                if (StringHelper.IsNullOrEmpty((String)pSSysTestCase.getPSSYSTESTMODULEID())) {
                    psSystemStorage.psSysTestCaseList.add(pSSysTestCase);
                } else {
                    psSystemStorage.getPSSysTestModuleStorage((String)pSSysTestCase.getPSSYSTESTMODULEID()).psSysTestCaseList.add(pSSysTestCase);
                }
                psSystemStorage.psSysTestCaseMap.put(pSSysTestCase.getPSSYSTESTCASEID(), pSSysTestCase);
                psSystemStorage.getPSSysTestCaseStorage((String)pSSysTestCase.getPSSYSTESTCASEID()).psSysTestCase = pSSysTestCase;
            }
            bLoadDetail = var10_1182.size() > 0;
            PSSysModelLog pSSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTCINPUT"));
            Vector vector58 = psSysModelCache.getModelList("PSSYSTCINPUT", psSysModelLog, pSSysModelLog);
            if (vector58 == null) {
                Vector<PSSysTestCaseInput> vector59 = new Vector<PSSysTestCaseInput>();
                CallResult callResult = this.getPSSysTestCaseInputsBySystem(strPSSystemId, vector59);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTCINPUT", psSysModelLog, pSSysModelLog, vector59);
            }
            psDEACModeStorage = var11_288.iterator();
            while (psDEACModeStorage.hasNext()) {
                PSSysTestCaseInput pSSysTestCaseInput;
                psSystemStorage.getPSSysTestCaseInputStorage((String)pSSysTestCaseInput.getPSSYSTCINPUTID()).psSysTestCaseInput = pSSysTestCaseInput = (PSSysTestCaseInput)((Object)psDEACModeStorage.next());
                psSystemStorage.getPSSysTestCaseStorage((String)pSSysTestCaseInput.getPSSYSTESTCASEID()).psSysTestCaseInputList.add(pSSysTestCaseInput);
            }
            PSSysModelLog pSSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTCASSERT"));
            Vector vector60 = psSysModelCache.getModelList("PSSYSTCASSERT", psSysModelLog, pSSysModelLog2);
            if (vector60 == null) {
                Vector<PSSysTestCaseAssert> vector61 = new Vector<PSSysTestCaseAssert>();
                CallResult callResult = this.getPSSysTestCaseAssertsBySystem(strPSSystemId, vector61);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6d4b\u8bd5\u7528\u4f8b\u65ad\u8a00\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTCASSERT", psSysModelLog, pSSysModelLog2, vector61);
            }
            for (PSSysTestCaseAssert pSSysTestCaseAssert : var11_291) {
                psSystemStorage.getPSSysTestCaseInputStorage((String)pSSysTestCaseAssert.getPSSYSTCINPUTID()).psSysTestCaseAssertList.add(pSSysTestCaseAssert);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWXACCOUNT"));
            Vector<PSWXAccount> psWXAccountList = psSysModelCache.getModelList("PSWXACCOUNT", psSysModelLog);
            if (psWXAccountList == null) {
                psWXAccountList = new Vector<PSWXAccount>();
                CallResult callResult = this.getAllPSWXAccounts2(strPSSystemId, psWXAccountList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u516c\u4f17\u53f7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXACCOUNT", psSysModelLog, psWXAccountList);
            }
            psSystemStorage.psWXAccountList.addAll(psWXAccountList);
            Iterator iterator7 = psWXAccountList.iterator();
            while (iterator7.hasNext()) {
                PSWXAccount pSWXAccount;
                psSystemStorage.getPSWXAccountStorage((String)pSWXAccount.getPSWXACCOUNTID()).psWXAccount = pSWXAccount = (PSWXAccount)((Object)iterator7.next());
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWXENTAPP"));
            Vector<PSWXEntApp> psWXEntAppList = psSysModelCache.getModelList("PSWXENTAPP", psSysModelLog);
            if (psWXEntAppList == null) {
                psWXEntAppList = new Vector<PSWXEntApp>();
                CallResult callResult = this.getPSWXEntAppsBySystem(strPSSystemId, psWXEntAppList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u516c\u4f17\u53f7\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXENTAPP", psSysModelLog, psWXEntAppList);
            }
            for (PSWXEntApp pSWXEntApp : psWXEntAppList) {
                psSystemStorage.getPSWXAccountStorage((String)pSWXEntApp.getPSWXACCOUNTID()).psWXEntAppList.add(pSWXEntApp);
                psSystemStorage.getPSWXEntAppStorage((String)pSWXEntApp.getPSWXENTAPPID()).strPSWXEntAppId = pSWXEntApp.getPSSYSAPPID();
                psSystemStorage.getPSWXEntAppStorage((String)pSWXEntApp.getPSWXENTAPPID()).psWXEntApp = pSWXEntApp;
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWXMENUFUNC"));
            Vector<PSWXMenuFunc> psWXMenuFuncList = psSysModelCache.getModelList("PSWXMENUFUNC", psSysModelLog);
            if (psWXMenuFuncList == null) {
                psWXMenuFuncList = new Vector<PSWXMenuFunc>();
                CallResult callResult = this.getPSWXMenuFuncsBySystem(strPSSystemId, psWXMenuFuncList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u83dc\u5355\u529f\u80fd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXMENUFUNC", psSysModelLog, psWXMenuFuncList);
            }
            for (PSWXMenuFunc pSWXMenuFunc : psWXMenuFuncList) {
                if (StringHelper.IsNullOrEmpty((String)pSWXMenuFunc.getPSWXENTAPPID())) {
                    psSystemStorage.getPSWXAccountStorage((String)pSWXMenuFunc.getPSWXACCOUNTID()).psWXMenuFuncList.add(pSWXMenuFunc);
                    continue;
                }
                psSystemStorage.getPSWXEntAppStorage((String)pSWXMenuFunc.getPSWXENTAPPID()).psWXMenuFuncList.add(pSWXMenuFunc);
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWXLOGIC"));
            Vector<PSWXLogic> psWXLogicList = psSysModelCache.getModelList("PSWXLOGIC", psSysModelLog);
            if (psWXLogicList == null) {
                psWXLogicList = new Vector<PSWXLogic>();
                CallResult callResult = this.getPSWXLogicsBySystem(strPSSystemId, psWXLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u516c\u4f17\u53f7\u54cd\u5e94\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXLOGIC", psSysModelLog, psWXLogicList);
            }
            for (PSWXLogic pSWXLogic : psWXLogicList) {
                if (StringHelper.IsNullOrEmpty((String)pSWXLogic.getPSWXENTAPPID())) {
                    psSystemStorage.getPSWXAccountStorage((String)pSWXLogic.getPSWXACCOUNTID()).psWXLogicList.add(pSWXLogic);
                    continue;
                }
                psSystemStorage.getPSWXEntAppStorage((String)pSWXLogic.getPSWXENTAPPID()).psWXLogicList.add(pSWXLogic);
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWXMENU"));
            Vector<PSWXMenu> psWXMenuList = psSysModelCache.getModelList("PSWXMENU", psSysModelLog);
            if (psWXMenuList == null) {
                psWXMenuList = new Vector<PSWXMenu>();
                CallResult callResult = this.getPSWXMenusBySystem(strPSSystemId, psWXMenuList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXMENU", psSysModelLog, psWXMenuList);
            }
            for (PSWXMenu pSWXMenu : psWXMenuList) {
                if (StringHelper.IsNullOrEmpty((String)pSWXMenu.getPSWXENTAPPID())) {
                    psSystemStorage.getPSWXAccountStorage((String)pSWXMenu.getPSWXACCOUNTID()).psWXMenuList.add(pSWXMenu);
                } else {
                    psSystemStorage.getPSWXEntAppStorage((String)pSWXMenu.getPSWXENTAPPID()).psWXMenuList.add(pSWXMenu);
                }
                psSystemStorage.getPSWXMenuStorage((String)pSWXMenu.getPSWXMENUID()).strPSWXMenuId = pSWXMenu.getPSWXMENUID();
                psSystemStorage.getPSWXMenuStorage((String)pSWXMenu.getPSWXMENUID()).psWXMenu = pSWXMenu;
            }
            Vector<PSWXMenuItem> psWXMenuItemList = psSysModelCache.getModelList("PSWXMENUITEM", psSysModelLog);
            if (psWXMenuItemList == null) {
                psWXMenuItemList = new Vector<PSWXMenuItem>();
                CallResult callResult = this.getPSWXMenuItemsBySystem(strPSSystemId, psWXMenuItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSWXMENUITEM", psSysModelLog, psWXMenuItemList);
            }
            for (PSWXMenuItem pSWXMenuItem : psWXMenuItemList) {
                psSystemStorage.getPSWXMenuStorage((String)pSWXMenuItem.getPSWXMENUID()).psWXMenuItemList.add(pSWXMenuItem);
            }
        }
        if (this.getModelInstVer() >= 611) {
            void var10_1212;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHSCHEME"));
            bLoadDetail = true;
            Vector vector62 = psSysModelCache.getModelList("PSSYSSEARCHSCHEME", psSysModelLog);
            if (vector62 == null) {
                Vector<PSSysSearchScheme> vector63 = new Vector<PSSysSearchScheme>();
                CallResult callResult = this.getAllPSSysSearchSchemes2(strPSSystemId, vector63);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u6587\u68c0\u7d22\u4f53\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEARCHSCHEME", psSysModelLog, vector63);
            }
            psSystemStorage.psSysSearchSchemeList.addAll((Collection<PSSysSearchScheme>)var10_1212);
            for (PSSysSearchScheme pSSysSearchScheme : var10_1212) {
                psSystemStorage.psSysSearchSchemeMap.put(pSSysSearchScheme.getPSSYSSEARCHSCHEMEID(), pSSysSearchScheme);
                psSystemStorage.getPSSysSearchSchemeStorage((String)pSSysSearchScheme.getPSSYSSEARCHSCHEMEID()).psSysSearchScheme = pSSysSearchScheme;
            }
            boolean bl = bLoadDetail = var10_1212.size() > 0;
            if (bLoadDetail) {
                void var10_1215;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHDOC"));
                Vector vector64 = psSysModelCache.getModelList("PSSYSSEARCHDOC", psSysModelLog);
                if (vector64 == null) {
                    Vector<PSSysSearchDoc> vector65 = new Vector<PSSysSearchDoc>();
                    CallResult callResult = this.getPSSysSearchDocsBySystem(strPSSystemId, vector65);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u6587\u68c0\u7d22\u6587\u6863\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSSEARCHDOC", psSysModelLog, vector65);
                }
                for (PSSysSearchDoc pSSysSearchDoc : var10_1215) {
                    psSystemStorage.getPSSysSearchSchemeStorage((String)pSSysSearchDoc.getPSSYSSEARCHSCHEMEID()).psSysSearchDocList.add(pSSysSearchDoc);
                }
            }
            if (bLoadDetail) {
                void var10_1219;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHDE"));
                Vector vector66 = psSysModelCache.getModelList("PSSYSSEARCHDE", psSysModelLog);
                if (vector66 == null) {
                    Vector<PSSysSearchDE> vector67 = new Vector<PSSysSearchDE>();
                    CallResult callResult = this.getPSSysSearchDEsBySystem(strPSSystemId, vector67);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSSEARCHDE", psSysModelLog, vector67);
                }
                for (PSSysSearchDE pSSysSearchDE : var10_1219) {
                    psSystemStorage.getPSSysSearchSchemeStorage((String)pSSysSearchDE.getPSSYSSEARCHSCHEMEID()).psSysSearchDEList.add(pSSysSearchDE);
                }
            }
            if (bLoadDetail) {
                void var10_1223;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHFIELD"));
                Vector vector68 = psSysModelCache.getModelList("PSSYSSEARCHFIELD", psSysModelLog);
                if (vector68 == null) {
                    Vector<PSSysSearchField> vector69 = new Vector<PSSysSearchField>();
                    CallResult callResult = this.getPSSysSearchFieldsBySystem(strPSSystemId, vector69);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u6587\u68c0\u7d22\u6587\u6863\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSSEARCHFIELD", psSysModelLog, vector69);
                }
                for (PSSysSearchField pSSysSearchField : var10_1223) {
                    psSystemStorage.getPSSysSearchDocStorage((String)pSSysSearchField.getPSSYSSEARCHDOCID()).psSysSearchFieldList.add(pSSysSearchField);
                }
            }
            if (bLoadDetail) {
                void var10_1227;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHDEFIELD"));
                Vector vector70 = psSysModelCache.getModelList("PSSYSSEARCHDEFIELD", psSysModelLog);
                if (vector70 == null) {
                    Vector<PSSysSearchDEField> vector71 = new Vector<PSSysSearchDEField>();
                    CallResult callResult = this.getPSSysSearchDEFieldsBySystem(strPSSystemId, vector71);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSSEARCHDEFIELD", psSysModelLog, vector71);
                }
                for (PSSysSearchDEField pSSysSearchDEField : var10_1227) {
                    psSystemStorage.getPSSysSearchDEStorage((String)pSSysSearchDEField.getPSSYSSEARCHDEID()).psSysSearchDEFieldList.add(pSSysSearchDEField);
                }
            }
        }
        if (this.getModelInstVer() >= 697) {
            void var10_1231;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAISCHEME"));
            bLoadDetail = true;
            Vector vector72 = psSysModelCache.getModelList("PSSYSEAISCHEME", psSysModelLog);
            if (vector72 == null) {
                Vector<PSSysEAIScheme> vector73 = new Vector<PSSysEAIScheme>();
                CallResult callResult = this.getAllPSSysEAISchemes2(strPSSystemId, vector73);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u4f53\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSEAISCHEME", psSysModelLog, vector73);
            }
            psSystemStorage.psSysEAISchemeList.addAll((Collection<PSSysEAIScheme>)var10_1231);
            for (PSSysEAIScheme pSSysEAIScheme : var10_1231) {
                psSystemStorage.psSysEAISchemeMap.put(pSSysEAIScheme.getPSSYSEAISCHEMEID(), pSSysEAIScheme);
                psSystemStorage.getPSSysEAISchemeStorage((String)pSSysEAIScheme.getPSSYSEAISCHEMEID()).psSysEAIScheme = pSSysEAIScheme;
            }
            boolean bl = bLoadDetail = var10_1231.size() > 0;
            if (bLoadDetail) {
                void var10_1234;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIDATATYPE"));
                Vector vector74 = psSysModelCache.getModelList("PSSYSEAIDATATYPE", psSysModelLog);
                if (vector74 == null) {
                    Vector<PSSysEAIDataType> vector75 = new Vector<PSSysEAIDataType>();
                    CallResult callResult = this.getPSSysEAIDataTypesBySystem(strPSSystemId, vector75);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u6570\u636e\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIDATATYPE", psSysModelLog, vector75);
                }
                for (PSSysEAIDataType pSSysEAIDataType : var10_1234) {
                    psSystemStorage.getPSSysEAISchemeStorage((String)pSSysEAIDataType.getPSSYSEAISCHEMEID()).psSysEAIDataTypeList.add(pSSysEAIDataType);
                }
            }
            if (bLoadDetail) {
                void var10_1238;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIDATATYPEITEM"));
                Vector vector76 = psSysModelCache.getModelList("PSSYSEAIDATATYPEITEM", psSysModelLog);
                if (vector76 == null) {
                    Vector<PSSysEAIDataTypeItem> vector77 = new Vector<PSSysEAIDataTypeItem>();
                    CallResult callResult = this.getPSSysEAIDataTypeItemsBySystem(strPSSystemId, vector77);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIDATATYPEITEM", psSysModelLog, vector77);
                }
                for (PSSysEAIDataTypeItem pSSysEAIDataTypeItem : var10_1238) {
                    psSystemStorage.getPSSysEAIDataTypeStorage((String)pSSysEAIDataTypeItem.getPSSYSEAIDATATYPEID()).psSysEAIDataTypeItemList.add(pSSysEAIDataTypeItem);
                }
            }
            if (bLoadDetail) {
                void var10_1242;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIELEMENT"));
                Vector vector78 = psSysModelCache.getModelList("PSSYSEAIELEMENT", psSysModelLog);
                if (vector78 == null) {
                    Vector<PSSysEAIElement> vector79 = new Vector<PSSysEAIElement>();
                    CallResult callResult = this.getPSSysEAIElementsBySystem(strPSSystemId, vector79);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5143\u7d20\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIELEMENT", psSysModelLog, vector79);
                }
                for (PSSysEAIElement pSSysEAIElement : var10_1242) {
                    psSystemStorage.getPSSysEAISchemeStorage((String)pSSysEAIElement.getPSSYSEAISCHEMEID()).psSysEAIElementList.add(pSSysEAIElement);
                }
            }
            if (bLoadDetail) {
                void var10_1246;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIELEMENTATTR"));
                Vector vector80 = psSysModelCache.getModelList("PSSYSEAIELEMENTATTR", psSysModelLog);
                if (vector80 == null) {
                    Vector<PSSysEAIElementAttr> vector81 = new Vector<PSSysEAIElementAttr>();
                    CallResult callResult = this.getPSSysEAIElementAttrsBySystem(strPSSystemId, vector81);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5143\u7d20\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIELEMENTATTR", psSysModelLog, vector81);
                }
                for (PSSysEAIElementAttr pSSysEAIElementAttr : var10_1246) {
                    psSystemStorage.getPSSysEAIElementStorage((String)pSSysEAIElementAttr.getPSSYSEAIELEMENTID()).psSysEAIElementAttrList.add(pSSysEAIElementAttr);
                }
            }
            if (bLoadDetail) {
                void var10_1250;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIELEMENTRE"));
                Vector vector82 = psSysModelCache.getModelList("PSSYSEAIELEMENTRE", psSysModelLog);
                if (vector82 == null) {
                    Vector<PSSysEAIElementRE> vector83 = new Vector<PSSysEAIElementRE>();
                    CallResult callResult = this.getPSSysEAIElementREsBySystem(strPSSystemId, vector83);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIELEMENTRE", psSysModelLog, vector83);
                }
                for (PSSysEAIElementRE pSSysEAIElementRE : var10_1250) {
                    psSystemStorage.getPSSysEAIElementStorage((String)pSSysEAIElementRE.getPSSYSEAIELEMENTID()).psSysEAIElementREList.add(pSSysEAIElementRE);
                }
            }
            if (bLoadDetail) {
                void var10_1254;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIDE"));
                Vector vector84 = psSysModelCache.getModelList("PSSYSEAIDE", psSysModelLog);
                if (vector84 == null) {
                    Vector<PSSysEAIDE> vector85 = new Vector<PSSysEAIDE>();
                    CallResult callResult = this.getPSSysEAIDEsBySystem(strPSSystemId, vector85);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5b9e\u4f53\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIDE", psSysModelLog, vector85);
                }
                for (PSSysEAIDE pSSysEAIDE : var10_1254) {
                    psSystemStorage.getPSSysEAISchemeStorage((String)pSSysEAIDE.getPSSYSEAISCHEMEID()).psSysEAIDEList.add(pSSysEAIDE);
                }
            }
            if (bLoadDetail) {
                void var10_1258;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIDEFIELD"));
                Vector vector86 = psSysModelCache.getModelList("PSSYSEAIDEFIELD", psSysModelLog);
                if (vector86 == null) {
                    Vector<PSSysEAIDEField> vector87 = new Vector<PSSysEAIDEField>();
                    CallResult callResult = this.getPSSysEAIDEFieldsBySystem(strPSSystemId, vector87);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIDEFIELD", psSysModelLog, vector87);
                }
                for (PSSysEAIDEField pSSysEAIDEField : var10_1258) {
                    psSystemStorage.getPSSysEAIDEStorage((String)pSSysEAIDEField.getPSSYSEAIDEID()).psSysEAIDEFieldList.add(pSSysEAIDEField);
                }
            }
            if (bLoadDetail) {
                void var10_1262;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSEAIDER"));
                Vector vector88 = psSysModelCache.getModelList("PSSYSEAIDER", psSysModelLog);
                if (vector88 == null) {
                    Vector<PSSysEAIDER> vector89 = new Vector<PSSysEAIDER>();
                    CallResult callResult = this.getPSSysEAIDERsBySystem(strPSSystemId, vector89);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSEAIDER", psSysModelLog, vector89);
                }
                for (PSSysEAIDER pSSysEAIDER : var10_1262) {
                    psSystemStorage.getPSSysEAIDEStorage((String)pSSysEAIDER.getPSSYSEAIDEID()).psSysEAIDERList.add(pSSysEAIDER);
                }
            }
        }
        if (this.getModelInstVer() >= 697) {
            void var10_1266;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBISCHEME"));
            bLoadDetail = true;
            Vector vector90 = psSysModelCache.getModelList("PSSYSBISCHEME", psSysModelLog);
            if (vector90 == null) {
                Vector<PSSysBIScheme> vector91 = new Vector<PSSysBIScheme>();
                CallResult callResult = this.getAllPSSysBISchemes2(strPSSystemId, vector91);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBISCHEME", psSysModelLog, vector91);
            }
            psSystemStorage.psSysBISchemeList.addAll((Collection<PSSysBIScheme>)var10_1266);
            for (PSSysBIScheme pSSysBIScheme : var10_1266) {
                psSystemStorage.psSysBISchemeMap.put(pSSysBIScheme.getPSSYSBISCHEMEID(), pSSysBIScheme);
                psSystemStorage.getPSSysBISchemeStorage((String)pSSysBIScheme.getPSSYSBISCHEMEID()).psSysBIScheme = pSSysBIScheme;
            }
            boolean bl = bLoadDetail = var10_1266.size() > 0;
            if (bLoadDetail) {
                void var10_1269;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIDIMENSION"));
                Vector vector92 = psSysModelCache.getModelList("PSSYSBIDIMENSION", psSysModelLog);
                if (vector92 == null) {
                    Vector<PSSysBIDimension> vector93 = new Vector<PSSysBIDimension>();
                    CallResult callResult = this.getPSSysBIDimensionsBySystem(strPSSystemId, vector93);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBIDIMENSION", psSysModelLog, vector93);
                }
                for (PSSysBIDimension pSSysBIDimension : var10_1269) {
                    psSystemStorage.getPSSysBISchemeStorage((String)pSSysBIDimension.getPSSYSBISCHEMEID()).psSysBIDimensionList.add(pSSysBIDimension);
                }
            }
            if (bLoadDetail) {
                void var10_1273;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIHIERARCHY"));
                Vector vector94 = psSysModelCache.getModelList("PSSYSBIHIERARCHY", psSysModelLog);
                if (vector94 == null) {
                    Vector<PSSysBIHierarchy> vector95 = new Vector<PSSysBIHierarchy>();
                    CallResult callResult = this.getPSSysBIHierarchiesBySystem(strPSSystemId, vector95);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u67b6\u6784\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBIHIERARCHY", psSysModelLog, vector95);
                }
                for (PSSysBIHierarchy pSSysBIHierarchy : var10_1273) {
                    psSystemStorage.getPSSysBIDimensionStorage((String)pSSysBIHierarchy.getPSSYSBIDIMENSIONID()).psSysBIHierarchyList.add(pSSysBIHierarchy);
                }
            }
            if (bLoadDetail) {
                void var10_1277;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBILEVEL"));
                Vector vector96 = psSysModelCache.getModelList("PSSYSBILEVEL", psSysModelLog);
                if (vector96 == null) {
                    Vector<PSSysBILevel> vector97 = new Vector<PSSysBILevel>();
                    CallResult callResult = this.getPSSysBILevelsBySystem(strPSSystemId, vector97);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u5c42\u7ea7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBILEVEL", psSysModelLog, vector97);
                }
                for (PSSysBILevel pSSysBILevel : var10_1277) {
                    psSystemStorage.getPSSysBIHierarchyStorage((String)pSSysBILevel.getPSSYSBIHIERARCHYID()).psSysBILevelList.add(pSSysBILevel);
                }
            }
            if (bLoadDetail) {
                void var10_1281;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBICUBE"));
                Vector vector98 = psSysModelCache.getModelList("PSSYSBICUBE", psSysModelLog);
                if (vector98 == null) {
                    Vector<PSSysBICube> vector99 = new Vector<PSSysBICube>();
                    CallResult callResult = this.getPSSysBICubesBySystem(strPSSystemId, vector99);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBICUBE", psSysModelLog, vector99);
                }
                for (PSSysBICube pSSysBICube : var10_1281) {
                    psSystemStorage.getPSSysBISchemeStorage((String)pSSysBICube.getPSSYSBISCHEMEID()).psSysBICubeList.add(pSSysBICube);
                }
            }
            if (bLoadDetail) {
                void var10_1285;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBICUBEDIMENSION"));
                Vector vector100 = psSysModelCache.getModelList("PSSYSBICUBEDIMENSION", psSysModelLog);
                if (vector100 == null) {
                    Vector<PSSysBICubeDimension> vector101 = new Vector<PSSysBICubeDimension>();
                    CallResult callResult = this.getPSSysBICubeDimensionsBySystem(strPSSystemId, vector101);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBICUBEDIMENSION", psSysModelLog, vector101);
                }
                for (PSSysBICubeDimension pSSysBICubeDimension : var10_1285) {
                    psSystemStorage.getPSSysBICubeStorage((String)pSSysBICubeDimension.getPSSYSBICUBEID()).psSysBICubeDimensionList.add(pSSysBICubeDimension);
                }
            }
            if (bLoadDetail) {
                void var10_1289;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBICUBELEVEL"));
                Vector vector102 = psSysModelCache.getModelList("PSSYSBICUBELEVEL", psSysModelLog);
                if (vector102 == null) {
                    Vector<PSSysBICubeLevel> vector103 = new Vector<PSSysBICubeLevel>();
                    CallResult callResult = this.getPSSysBICubeLevelsBySystem(strPSSystemId, vector103);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5c42\u7ea7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBICUBELEVEL", psSysModelLog, vector103);
                }
                for (PSSysBICubeLevel pSSysBICubeLevel : var10_1289) {
                    psSystemStorage.getPSSysBICubeDimensionStorage((String)pSSysBICubeLevel.getPSSYSBICUBEDIMENSIONID()).psSysBICubeLevelList.add(pSSysBICubeLevel);
                }
            }
            if (bLoadDetail) {
                void var10_1293;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBICUBEMEASURE"));
                Vector vector104 = psSysModelCache.getModelList("PSSYSBICUBEMEASURE", psSysModelLog);
                if (vector104 == null) {
                    Vector<PSSysBICubeMeasure> vector105 = new Vector<PSSysBICubeMeasure>();
                    CallResult callResult = this.getPSSysBICubeMeasuresBySystem(strPSSystemId, vector105);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u6307\u6807\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBICUBEMEASURE", psSysModelLog, vector105);
                }
                for (PSSysBICubeMeasure pSSysBICubeMeasure : var10_1293) {
                    psSystemStorage.getPSSysBICubeStorage((String)pSSysBICubeMeasure.getPSSYSBICUBEID()).psSysBICubeMeasureList.add(pSSysBICubeMeasure);
                }
            }
            if (bLoadDetail) {
                void var10_1297;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIAGGTABLE"));
                Vector vector106 = psSysModelCache.getModelList("PSSYSBIAGGTABLE", psSysModelLog);
                if (vector106 == null) {
                    Vector<PSSysBIAggTable> vector107 = new Vector<PSSysBIAggTable>();
                    CallResult callResult = this.getPSSysBIAggTablesBySystem(strPSSystemId, vector107);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u6570\u636e\u805a\u5408\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBIAGGTABLE", psSysModelLog, vector107);
                }
                for (PSSysBIAggTable pSSysBIAggTable : var10_1297) {
                    psSystemStorage.getPSSysBISchemeStorage((String)pSSysBIAggTable.getPSSYSBISCHEMEID()).psSysBIAggTableList.add(pSSysBIAggTable);
                }
            }
            if (bLoadDetail) {
                void var10_1301;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIAGGCOLUMN"));
                Vector vector108 = psSysModelCache.getModelList("PSSYSBIAGGCOLUMN", psSysModelLog);
                if (vector108 == null) {
                    Vector<PSSysBIAggColumn> vector109 = new Vector<PSSysBIAggColumn>();
                    CallResult callResult = this.getPSSysBIAggColumnsBySystem(strPSSystemId, vector109);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSBIAGGCOLUMN", psSysModelLog, vector109);
                }
                for (PSSysBIAggColumn pSSysBIAggColumn : var10_1301) {
                    psSystemStorage.getPSSysBIAggTableStorage((String)pSSysBIAggColumn.getPSSYSBIAGGTABLEID()).psSysBIAggColumnList.add(pSSysBIAggColumn);
                }
            }
            if (this.getModelInstVer() >= 785) {
                if (bLoadDetail) {
                    void var10_1305;
                    psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIREPORT"));
                    Vector vector110 = psSysModelCache.getModelList("PSSYSBIREPORT", psSysModelLog);
                    if (vector110 == null) {
                        Vector<PSSysBIReport> vector111 = new Vector<PSSysBIReport>();
                        CallResult callResult = this.getPSSysBIReportsBySystem(strPSSystemId, vector111);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        psSysModelCache.updateModelList("PSSYSBIREPORT", psSysModelLog, vector111);
                    }
                    for (PSSysBIReport pSSysBIReport : var10_1305) {
                        psSystemStorage.getPSSysBISchemeStorage((String)pSSysBIReport.getPSSYSBISCHEMEID()).psSysBIReportList.add(pSSysBIReport);
                    }
                }
                if (bLoadDetail) {
                    void var10_1309;
                    psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBIREPORTITEM"));
                    Vector vector112 = psSysModelCache.getModelList("PSSYSBIREPORTITEM", psSysModelLog);
                    if (vector112 == null) {
                        Vector<PSSysBIReportItem> vector113 = new Vector<PSSysBIReportItem>();
                        CallResult callResult = this.getPSSysBIReportItemsBySystem(strPSSystemId, vector113);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u667a\u80fd\u62a5\u8868\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        psSysModelCache.updateModelList("PSSYSBIREPORTITEM", psSysModelLog, vector113);
                    }
                    for (PSSysBIReportItem pSSysBIReportItem : var10_1309) {
                        psSystemStorage.getPSSysBIReportStorage((String)pSSysBIReportItem.getPSSYSBIREPORTID()).psSysBIReportItemList.add(pSSysBIReportItem);
                    }
                }
            }
        }
        if (this.getModelInstVer() >= 803) {
            void var10_1313;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAIFACTORY"));
            bLoadDetail = true;
            Vector vector114 = psSysModelCache.getModelList("PSSYSAIFACTORY", psSysModelLog);
            if (vector114 == null) {
                Vector<PSSysAIFactory> vector115 = new Vector<PSSysAIFactory>();
                CallResult callResult = this.getAllPSSysAIFactories2(strPSSystemId, vector115);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709AI\u5de5\u5382\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSAIFACTORY", psSysModelLog, vector115);
            }
            psSystemStorage.psSysAIFactoryList.addAll((Collection<PSSysAIFactory>)var10_1313);
            for (PSSysAIFactory pSSysAIFactory : var10_1313) {
                psSystemStorage.psSysAIFactoryMap.put(pSSysAIFactory.getPSSYSAIFACTORYID(), pSSysAIFactory);
                psSystemStorage.getPSSysAIFactoryStorage((String)pSSysAIFactory.getPSSYSAIFACTORYID()).psSysAIFactory = pSSysAIFactory;
            }
            boolean bl = bLoadDetail = var10_1313.size() > 0;
            if (bLoadDetail) {
                void var10_1316;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAICHATAGENT"));
                Vector vector116 = psSysModelCache.getModelList("PSSYSAICHATAGENT", psSysModelLog);
                if (vector116 == null) {
                    Vector<PSSysAIChatAgent> vector117 = new Vector<PSSysAIChatAgent>();
                    CallResult callResult = this.getPSSysAIChatAgentsBySystem(strPSSystemId, vector117);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u4ea4\u8c08\u8005\u4ee3\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSAICHATAGENT", psSysModelLog, vector117);
                }
                for (PSSysAIChatAgent pSSysAIChatAgent : var10_1316) {
                    psSystemStorage.getPSSysAIFactoryStorage((String)pSSysAIChatAgent.getPSSYSAIFACTORYID()).psSysAIChatAgentList.add(pSSysAIChatAgent);
                }
            }
            if (bLoadDetail) {
                void var10_1320;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAIWORKERAGENT"));
                Vector vector118 = psSysModelCache.getModelList("PSSYSAIWORKERAGENT", psSysModelLog);
                if (vector118 == null) {
                    Vector<PSSysAIWorkerAgent> vector119 = new Vector<PSSysAIWorkerAgent>();
                    CallResult callResult = this.getPSSysAIWorkerAgentsBySystem(strPSSystemId, vector119);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u4ea4\u8c08\u8005\u4ee3\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSAIWORKERAGENT", psSysModelLog, vector119);
                }
                for (PSSysAIWorkerAgent pSSysAIWorkerAgent : var10_1320) {
                    psSystemStorage.getPSSysAIFactoryStorage((String)pSSysAIWorkerAgent.getPSSYSAIFACTORYID()).psSysAIWorkerAgentList.add(pSSysAIWorkerAgent);
                }
            }
            if (bLoadDetail) {
                void var10_1324;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAIPIPELINEAGENT"));
                Vector vector120 = psSysModelCache.getModelList("PSSYSAIPIPELINEAGENT", psSysModelLog);
                if (vector120 == null) {
                    Vector<PSSysAIPipelineAgent> vector121 = new Vector<PSSysAIPipelineAgent>();
                    CallResult callResult = this.getPSSysAIPipelineAgentsBySystem(strPSSystemId, vector121);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709AI\u5de5\u5382\u751f\u4ea7\u7ebf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSAIPIPELINEAGENT", psSysModelLog, vector121);
                }
                for (PSSysAIPipelineAgent pSSysAIPipelineAgent : var10_1324) {
                    psSystemStorage.getPSSysAIFactoryStorage((String)pSSysAIPipelineAgent.getPSSYSAIFACTORYID()).psSysAIPipelineAgentList.add(pSSysAIPipelineAgent);
                }
            }
            if (bLoadDetail) {
                void var10_1328;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAIPIPELINEJOB"));
                Vector vector122 = psSysModelCache.getModelList("PSSYSAIPIPELINEJOB", psSysModelLog);
                if (vector122 == null) {
                    Vector<PSSysAIPipelineJob> vector123 = new Vector<PSSysAIPipelineJob>();
                    CallResult callResult = this.getPSSysAIPipelineJobsBySystem(strPSSystemId, vector123);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709AI\u5de5\u5382\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSAIPIPELINEJOB", psSysModelLog, vector123);
                }
                for (PSSysAIPipelineJob pSSysAIPipelineJob : var10_1328) {
                    psSystemStorage.getPSSysAIPipelineStorage((String)pSSysAIPipelineJob.getPSSYSAIPIPELINEAGENTID()).psSysAIPipelineJobList.add(pSSysAIPipelineJob);
                }
            }
            if (bLoadDetail) {
                void var10_1332;
                psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSAIPIPELINEWORKER"));
                Vector vector124 = psSysModelCache.getModelList("PSSYSAIPIPELINEWORKER", psSysModelLog);
                if (vector124 == null) {
                    Vector<PSSysAIPipelineWorker> vector125 = new Vector<PSSysAIPipelineWorker>();
                    CallResult callResult = this.getPSSysAIPipelineWorkersBySystem(strPSSystemId, vector125);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709AI\u5de5\u5382\u751f\u4ea7\u7ebf\u5de5\u4f5c\u8005\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSAIPIPELINEWORKER", psSysModelLog, vector125);
                }
                for (PSSysAIPipelineWorker pSSysAIPipelineWorker : var10_1332) {
                    psSystemStorage.getPSSysAIPipelineStorage((String)pSSysAIPipelineWorker.getPSSYSAIPIPELINEAGENTID()).psSysAIPipelineWorkerList.add(pSSysAIPipelineWorker);
                }
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
            void var10_1339;
            void var10_1336;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSERMAP"));
            bLoadDetail = true;
            Vector vector126 = psSysModelCache.getModelList("PSSYSERMAP", psSysModelLog);
            if (vector126 == null) {
                Vector<PSSysERMap> vector127 = new Vector<PSSysERMap>();
                CallResult callResult = this.getAllPSSysERMaps2(strPSSystemId, vector127);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709ER\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSERMAP", psSysModelLog, vector127);
            }
            psSystemStorage.psSysERMapList.addAll((Collection<PSSysERMap>)var10_1336);
            for (PSSysERMap pSSysERMap : var10_1336) {
                psSystemStorage.psSysERMapMap.put(pSSysERMap.getPSSYSERMAPID(), pSSysERMap);
                psSystemStorage.getPSSysERMapStorage((String)pSSysERMap.getPSSYSERMAPID()).psSysERMap = pSSysERMap;
            }
            bLoadDetail = var10_1336.size() > 0;
            Vector vector128 = psSysModelCache.getModelList("PSSYSERMAPNODE", psSysModelLog);
            if (vector128 == null) {
                Vector<PSSysERMapNode> vector129 = new Vector<PSSysERMapNode>();
                CallResult callResult = this.getPSSysERMapNodesBySystem(strPSSystemId, vector129);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709ER\u56fe\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSERMAPNODE", psSysModelLog, vector129);
            }
            for (PSSysERMapNode pSSysERMapNode : var10_1339) {
                psSystemStorage.getPSSysERMapStorage((String)pSSysERMapNode.getPSSYSERMAPID()).psSysERMapNodeList.add(pSSysERMapNode);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
            void var10_1346;
            void var10_1343;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUCMAP"));
            bLoadDetail = true;
            Vector vector130 = psSysModelCache.getModelList("PSSYSUCMAP", psSysModelLog);
            if (vector130 == null) {
                Vector<PSSysUCMap> vector131 = new Vector<PSSysUCMap>();
                CallResult callResult = this.getAllPSSysUCMaps2(strPSSystemId, vector131);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709UC\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSUCMAP", psSysModelLog, vector131);
            }
            psSystemStorage.psSysUCMapList.addAll((Collection<PSSysUCMap>)var10_1343);
            for (PSSysUCMap pSSysUCMap : var10_1343) {
                psSystemStorage.psSysUCMapMap.put(pSSysUCMap.getPSSYSUCMAPID(), pSSysUCMap);
                psSystemStorage.getPSSysUCMapStorage((String)pSSysUCMap.getPSSYSUCMAPID()).psSysUCMap = pSSysUCMap;
            }
            bLoadDetail = var10_1343.size() > 0;
            Vector vector132 = psSysModelCache.getModelList("PSSYSUCMAPNODE", psSysModelLog);
            if (vector132 == null) {
                Vector<PSSysUCMapNode> vector133 = new Vector<PSSysUCMapNode>();
                CallResult callResult = this.getPSSysUCMapNodesBySystem(strPSSystemId, vector133);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709UC\u56fe\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSUCMAPNODE", psSysModelLog, vector133);
            }
            for (PSSysUCMapNode pSSysUCMapNode : var10_1346) {
                psSystemStorage.getPSSysUCMapStorage((String)pSSysUCMapNode.getPSSYSUCMAPID()).psSysUCMapNodeList.add(pSSysUCMapNode);
            }
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDYNAMODEL"));
        bLoadDetail = true;
        Vector vector134 = psSysModelCache.getModelList("PSSYSDYNAMODEL", psSysModelLog);
        if (vector134 == null) {
            Vector<PSSysDynaModel> vector135 = new Vector<PSSysDynaModel>();
            CallResult callResult = this.getAllPSSysDynaModels2(strPSSystemId, vector135);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u52a8\u6001\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDYNAMODEL", psSysModelLog, vector135);
        }
        psSystemStorage.psSysDynaModelList.addAll((Collection<PSSysDynaModel>)var10_1350);
        for (PSSysDynaModel pSSysDynaModel : var10_1350) {
            psSystemStorage.psSysDynaModelMap.put(pSSysDynaModel.getPSSYSDYNAMODELID(), pSSysDynaModel);
            psSystemStorage.getPSSysDynaModelStorage((String)pSSysDynaModel.getPSSYSDYNAMODELID()).psSysDynaModel = pSSysDynaModel;
        }
        boolean bl = bLoadDetail = var10_1350.size() > 0;
        if (bLoadDetail) {
            void var10_1353;
            Vector vector136 = psSysModelCache.getModelList("PSSYSDYNAMODELATTR", psSysModelLog);
            if (vector136 == null) {
                Vector<PSSysDynaModelAttr> vector137 = new Vector<PSSysDynaModelAttr>();
                CallResult callResult = this.getPSSysDynaModelAttrsBySystem(strPSSystemId, vector137);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSDYNAMODELATTR", psSysModelLog, vector137);
            }
            for (PSSysDynaModelAttr pSSysDynaModelAttr : var10_1353) {
                psSystemStorage.getPSSysDynaModelStorage((String)pSSysDynaModelAttr.getPSSYSDYNAMODELID()).psSysDynaModelAttrList.add(pSSysDynaModelAttr);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_CODE) {
            void var10_1357;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDYNADETEMPL"));
            bLoadDetail = true;
            Vector vector138 = psSysModelCache.getModelList("PSDYNADETEMPL", psSysModelLog);
            if (vector138 == null) {
                Vector<PSDynaDETempl> vector139 = new Vector<PSDynaDETempl>();
                CallResult callResult = this.getAllPSDynaDETempls2(strPSSystemId, vector139);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDYNADETEMPL", psSysModelLog, vector139);
            }
            psSystemStorage.psDynaDETemplList.addAll((Collection<PSDynaDETempl>)var10_1357);
            for (PSDynaDETempl pSDynaDETempl : var10_1357) {
                psSystemStorage.psDynaDETemplMap.put(pSDynaDETempl.getPSDYNADETEMPLID(), pSDynaDETempl);
                psSystemStorage.getPSDynaDETemplStorage((String)pSDynaDETempl.getPSDYNADETEMPLID()).psDynaDETempl = pSDynaDETempl;
            }
            boolean bl2 = bLoadDetail = var10_1357.size() > 0;
            if (bLoadDetail) {
                void var10_1360;
                Vector vector140 = psSysModelCache.getModelList("PSDYNADEVIEWTEMPL", psSysModelLog);
                if (vector140 == null) {
                    Vector<PSDynaDEViewTempl> vector141 = new Vector<PSDynaDEViewTempl>();
                    CallResult callResult = this.getPSDynaDEViewTemplsBySystem(strPSSystemId, vector141);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSDYNADEVIEWTEMPL", psSysModelLog, vector141);
                }
                for (PSDynaDEViewTempl pSDynaDEViewTempl : var10_1360) {
                    psSystemStorage.getPSDynaDETemplStorage((String)pSDynaDEViewTempl.getPSDYNADETEMPLID()).psDynaDEViewTemplList.add(pSDynaDEViewTempl);
                }
            }
            if (bLoadDetail) {
                void var10_1364;
                Vector vector142 = psSysModelCache.getModelList("PSDYNADEFORMTEMPL", psSysModelLog);
                if (vector142 == null) {
                    Vector<PSDynaDEFormTempl> vector143 = new Vector<PSDynaDEFormTempl>();
                    CallResult callResult = this.getPSDynaDEFormTemplsBySystem(strPSSystemId, vector143);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSDYNADEFORMTEMPL", psSysModelLog, vector143);
                }
                for (PSDynaDEFormTempl pSDynaDEFormTempl : var10_1364) {
                    psSystemStorage.getPSDynaDETemplStorage((String)pSDynaDEFormTempl.getPSDYNADETEMPLID()).psDynaDEFormTemplList.add(pSDynaDEFormTempl);
                }
            }
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEWIZARD"));
        bLoadDetail = true;
        Vector vector144 = psSysModelCache.getModelList("PSDEWIZARD", psSysModelLog);
        if (vector144 == null) {
            Vector<PSDEWizard> vector145 = new Vector<PSDEWizard>();
            CallResult callResult = this.getPSDEWizardsBySystem(strPSSystemId, vector145);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEWIZARD", psSysModelLog, vector145);
        }
        for (PSDEWizard pSDEWizard : var10_1368) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEWizard.getPSDEID()).psDEWizardList.add(pSDEWizard);
            Iterator psDEWizardStorage = psSystemStorage.getPSDEWizardStorage(pSDEWizard.getPSDEWIZARDID());
            ((PSModelHelperBase.PSDEWizardStorage)((Object)psDEWizardStorage)).psDEWizard = pSDEWizard;
        }
        bLoadDetail = var10_1368.size() > 0;
        PSSysModelLog pSSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEWIZARDSTEP"));
        Vector vector146 = psSysModelCache.getModelList("PSDEWIZARDSTEP", psSysModelLog, pSSysModelLog);
        if (vector146 == null) {
            Vector<PSDEWizardStep> vector147 = new Vector<PSDEWizardStep>();
            CallResult callResult = this.getPSDEWizardStepsBySystem(strPSSystemId, vector147);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEWIZARDSTEP", psSysModelLog, pSSysModelLog, vector147);
        }
        for (PSDEWizardStep pSDEWizardStep : var11_470) {
            psSystemStorage.getPSDEWizardStorage((String)pSDEWizardStep.getPSDEWIZARDID()).psDEWizardStepList.add(pSDEWizardStep);
        }
        PSSysModelLog pSSysModelLog3 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEWIZARDFORM"));
        Vector vector148 = psSysModelCache.getModelList("PSDEWIZARDFORM", psSysModelLog, pSSysModelLog3);
        if (vector148 == null) {
            Vector<PSDEWizardForm> vector149 = new Vector<PSDEWizardForm>();
            CallResult callResult = this.getPSDEWizardFormsBySystem(strPSSystemId, vector149);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEWIZARDFORM", psSysModelLog, pSSysModelLog3, vector149);
        }
        for (PSDEWizardForm pSDEWizardForm : var11_473) {
            psSystemStorage.getPSDEWizardStorage((String)pSDEWizardForm.getPSDEWIZARDID()).psDEWizardFormList.add(pSDEWizardForm);
        }
        if (this.getModelInstVer() >= 747) {
            void var11_476;
            PSSysModelLog pSSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEWIZARDLOGIC"));
            Vector vector150 = psSysModelCache.getModelList("PSDEWIZARDLOGIC", psSysModelLog, pSSysModelLog4);
            if (vector150 == null) {
                Vector<PSDEWizardLogic> vector151 = new Vector<PSDEWizardLogic>();
                CallResult callResult = this.getPSDEWizardLogicsBySystem(strPSSystemId, vector151);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5411\u5bfc\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEWIZARDLOGIC", psSysModelLog, pSSysModelLog4, vector151);
            }
            for (PSDEWizardLogic pSDEWizardLogic : var11_476) {
                psSystemStorage.getPSDEWizardStorage((String)pSDEWizardLogic.getPSDEWIZARDID()).psDEWizardLogicList.add(pSDEWizardLogic);
            }
        }
        boolean bLoadDetail2 = true;
        PSSysModelLog psSysModelLog3 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDESERVICEAPI"));
        Vector vector152 = psSysModelCache.getModelList("PSDESERVICEAPI", psSysModelLog3);
        if (vector152 == null) {
            Vector<PSDEServiceAPI> vector153 = new Vector<PSDEServiceAPI>();
            CallResult callResult = this.getPSDEServiceAPIsBySystem(strPSSystemId, vector153);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDESERVICEAPI", psSysModelLog3, vector153);
        }
        for (PSDEServiceAPI pSDEServiceAPI : var10_1375) {
            psSysServiceAPIStorage = psSystemStorage.getPSSysServiceAPIStorage(pSDEServiceAPI.getPSSYSSERVICEAPIID(), false);
            if (psSysServiceAPIStorage == null) continue;
            psSystemStorage.getPSDataEntityStorage((String)pSDEServiceAPI.getPSDEID()).psDEServiceAPIList.add(pSDEServiceAPI);
            PSModelHelperBase.PSDEServiceAPIStorage psDEServiceAPIStorage2 = psSystemStorage.getPSDEServiceAPIStorage(pSDEServiceAPI.getPSDESERVICEAPIID(), true);
            psDEServiceAPIStorage2.psDEServiceAPI = pSDEServiceAPI;
            psSysServiceAPIStorage.psDEServiceAPIList.add(pSDEServiceAPI);
        }
        bLoadDetail2 = var10_1375.size() > 0;
        PSSysModelLog psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDESARS"));
        Vector vector154 = psSysModelCache.getModelList("PSDESARS", psSysModelLog4);
        if (vector154 == null) {
            Vector<PSDESARS> vector155 = new Vector<PSDESARS>();
            CallResult callResult = this.getPSDEServiceAPIRSsBySystem(strPSSystemId, vector155);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u670d\u52a1API\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDESARS", psSysModelLog4, vector155);
        }
        for (PSDESARS pSDESARS : var10_1378) {
            psSysServiceAPIStorage = psSystemStorage.getPSSysServiceAPIStorage(pSDESARS.getPSSYSSERVICEAPIID(), false);
            if (psSysServiceAPIStorage == null) continue;
            psSysServiceAPIStorage.psDEServiceAPIRSList.add(pSDESARS);
        }
        psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDESADETAIL"));
        Vector vector156 = psSysModelCache.getModelList("PSDESADETAIL", psSysModelLog4);
        if (vector156 == null) {
            Vector<PSDESADetail> vector157 = new Vector<PSDESADetail>();
            CallResult callResult = this.getPSDESADetailsBySystem(strPSSystemId, vector157);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u670d\u52a1API\u65b9\u6cd5\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDESADETAIL", psSysModelLog4, vector157);
        }
        for (PSDESADetail pSDESADetail : var10_1381) {
            psDEServiceAPIStorage = psSystemStorage.getPSDEServiceAPIStorage(pSDESADetail.getPSDESERVICEAPIID(), false);
            if (psDEServiceAPIStorage == null) continue;
            psDEServiceAPIStorage.psDESADetailList.add(pSDESADetail);
        }
        if (this.getModelInstVer() >= 581) {
            void var10_1384;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDESAVR"));
            Vector vector158 = psSysModelCache.getModelList("PSDESAVR", psSysModelLog4);
            if (vector158 == null) {
                Vector<PSDESAVR> vector159 = new Vector<PSDESAVR>();
                CallResult callResult = this.getPSDESAVRsBySystem(strPSSystemId, vector159);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u503c\u89c4\u5219\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDESAVR", psSysModelLog4, vector159);
            }
            for (PSDESAVR pSDESAVR : var10_1384) {
                psDEServiceAPIStorage = psSystemStorage.getPSDEServiceAPIStorage(pSDESAVR.getPSDESERVICEAPIID(), false);
                if (psDEServiceAPIStorage == null) continue;
                psDEServiceAPIStorage.psDESAVRList.add(pSDESAVR);
            }
        }
        if ((psDEDataSyncList = psSysModelCache.getModelList("PSDEDATASYNC", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATASYNC")))) == null) {
            psDEDataSyncList = new Vector<PSDEDataSync>();
            CallResult callResult = this.getPSDEDataSyncsBySystem(strPSSystemId, psDEDataSyncList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATASYNC", psSysModelLog, psDEDataSyncList);
        }
        for (PSDEDataSync pSDEDataSync : psDEDataSyncList) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEDataSync.getPSDEID()).psDEDataSyncList.add(pSDEDataSync);
            PSModelHelperBase.PSDEDataSyncStorage pSDEDataSyncStorage = psSystemStorage.getPSDEDataSyncStorage(pSDEDataSync.getPSDEDATASYNCID());
            pSDEDataSyncStorage.psDEDataSync = pSDEDataSync;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDTABLEDE"));
        Vector<PSSysBDTableDE> psDEBDTableList = psSysModelCache.getModelList("PSSYSBDTABLEDEDEMODE", psSysModelLog);
        if (psDEBDTableList == null) {
            psDEBDTableList = new Vector<PSSysBDTableDE>();
            CallResult callResult = this.getPSDEBDTablesBySystem(strPSSystemId, psDEBDTableList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5927\u6570\u636e\u8868\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSBDTABLEDEDEMODE", psSysModelLog, psDEBDTableList);
        }
        for (PSSysBDTableDE pSSysBDTableDE : psDEBDTableList) {
            psSystemStorage.getPSDataEntityStorage((String)pSSysBDTableDE.getPSDEID()).psDEBDTableList.add(pSSysBDTableDE);
        }
        if (this.getModelInstVer() >= 611) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHDE"));
            Vector<PSSysSearchDE> psDESearchList = psSysModelCache.getModelList("PSSYSSEARCHDEDEMODE", psSysModelLog);
            if (psDESearchList == null) {
                psDESearchList = new Vector<PSSysSearchDE>();
                CallResult callResult = this.getPSDESearchsBySystem(strPSSystemId, psDESearchList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5168\u6587\u68c0\u7d22\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEARCHDEDEMODE", psSysModelLog, psDESearchList);
            }
            for (PSSysSearchDE pSSysSearchDE : psDESearchList) {
                psSystemStorage.getPSDataEntityStorage((String)pSSysSearchDE.getPSDEID()).psDESearchList.add(pSSysSearchDE);
            }
        }
        boolean bLoadDetail3 = true;
        psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDSCHEME"));
        Vector vector160 = psSysModelCache.getModelList("PSSYSBDSCHEME", psSysModelLog4);
        if (vector160 == null) {
            Vector<PSSysBDScheme> vector161 = new Vector<PSSysBDScheme>();
            CallResult callResult = this.getAllPSSysBDSchemes2(strPSSystemId, vector161);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSBDSCHEME", psSysModelLog4, vector161);
        }
        psSystemStorage.psSysBDSchemeList.addAll((Collection<PSSysBDScheme>)var10_1400);
        for (PSSysBDScheme pSSysBDScheme : var10_1400) {
            psSystemStorage.psSysBDSchemeMap.put(pSSysBDScheme.getPSSYSBDSCHEMEID(), pSSysBDScheme);
            psSystemStorage.getPSSysBDSchemeStorage((String)pSSysBDScheme.getPSSYSBDSCHEMEID()).psSysBDScheme = pSSysBDScheme;
        }
        if (bLoadDetail3) {
            void var10_1403;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDMODULE"));
            Vector vector162 = psSysModelCache.getModelList("PSSYSBDMODULE", psSysModelLog4);
            if (vector162 == null) {
                Vector<PSSysBDModule> vector163 = new Vector<PSSysBDModule>();
                CallResult callResult = this.getPSSysBDModulesBySystem(strPSSystemId, vector163);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDMODULE", psSysModelLog4, vector163);
            }
            for (PSSysBDModule pSSysBDModule : var10_1403) {
                psSystemStorage.getPSSysBDSchemeStorage((String)pSSysBDModule.getPSSYSBDSCHEMEID()).psSysBDModuleList.add(pSSysBDModule);
            }
        }
        if (bLoadDetail3) {
            void var10_1407;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDPART"));
            Vector vector164 = psSysModelCache.getModelList("PSSYSBDPART", psSysModelLog4);
            if (vector164 == null) {
                Vector<PSSysBDPart> vector165 = new Vector<PSSysBDPart>();
                CallResult callResult = this.getPSSysBDPartsBySystem(strPSSystemId, vector165);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u5206\u533a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDPART", psSysModelLog4, vector165);
            }
            for (PSSysBDPart pSSysBDPart : var10_1407) {
                psSystemStorage.getPSSysBDSchemeStorage((String)pSSysBDPart.getPSSYSBDSCHEMEID()).psSysBDPartList.add(pSSysBDPart);
            }
        }
        if (bLoadDetail3) {
            void var10_1411;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDTABLE"));
            Vector vector166 = psSysModelCache.getModelList("PSSYSBDTABLE", psSysModelLog4);
            if (vector166 == null) {
                Vector<PSSysBDTable> vector167 = new Vector<PSSysBDTable>();
                CallResult callResult = this.getPSSysBDTablesBySystem(strPSSystemId, vector167);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDTABLE", psSysModelLog4, vector167);
            }
            for (PSSysBDTable pSSysBDTable : var10_1411) {
                psSystemStorage.getPSSysBDSchemeStorage((String)pSSysBDTable.getPSSYSBDSCHEMEID()).psSysBDTableList.add(pSSysBDTable);
            }
        }
        if (bLoadDetail3) {
            void var10_1415;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDTABLERS"));
            Vector vector168 = psSysModelCache.getModelList("PSSYSBDTABLERS", psSysModelLog4);
            if (vector168 == null) {
                Vector<PSSysBDTableRS> vector169 = new Vector<PSSysBDTableRS>();
                CallResult callResult = this.getPSSysBDTableRSesBySystem(strPSSystemId, vector169);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u8868\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDTABLERS", psSysModelLog4, vector169);
            }
            for (PSSysBDTableRS pSSysBDTableRS : var10_1415) {
                psSystemStorage.getPSSysBDSchemeStorage((String)pSSysBDTableRS.getPSSYSBDSCHEMEID()).psSysBDTableRSList.add(pSSysBDTableRS);
            }
        }
        if (bLoadDetail3) {
            void var10_1419;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDCOLSET"));
            Vector vector170 = psSysModelCache.getModelList("PSSYSBDCOLSET", psSysModelLog4);
            if (vector170 == null) {
                Vector<PSSysBDColSet> vector171 = new Vector<PSSysBDColSet>();
                CallResult callResult = this.getPSSysBDColSetsBySystem(strPSSystemId, vector171);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u5217\u65cf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDCOLSET", psSysModelLog4, vector171);
            }
            for (PSSysBDColSet pSSysBDColSet : var10_1419) {
                psSystemStorage.getPSSysBDTableStorage((String)pSSysBDColSet.getPSSYSBDTABLEID()).psSysBDColSetList.add(pSSysBDColSet);
            }
        }
        if (bLoadDetail3) {
            void var10_1423;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDTABLEDE"));
            Vector vector172 = psSysModelCache.getModelList("PSSYSBDTABLEDE", psSysModelLog4);
            if (vector172 == null) {
                Vector<PSSysBDTableDE> vector173 = new Vector<PSSysBDTableDE>();
                CallResult callResult = this.getPSSysBDTableDEsBySystem(strPSSystemId, vector173);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u6570\u636e\u8868\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDTABLEDE", psSysModelLog4, vector173);
            }
            for (PSSysBDTableDE pSSysBDTableDE : var10_1423) {
                psSystemStorage.getPSSysBDTableStorage((String)pSSysBDTableDE.getPSSYSBDTABLEID()).psSysBDTableDEList.add(pSSysBDTableDE);
            }
        }
        if (bLoadDetail3) {
            void var10_1427;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDTABLEDER"));
            Vector vector174 = psSysModelCache.getModelList("PSSYSBDTABLEDER", psSysModelLog4);
            if (vector174 == null) {
                Vector<PSSysBDTableDER> vector175 = new Vector<PSSysBDTableDER>();
                CallResult callResult = this.getPSSysBDTableDERsBySystem(strPSSystemId, vector175);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u6570\u636e\u8868\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDTABLEDER", psSysModelLog4, vector175);
            }
            for (PSSysBDTableDER pSSysBDTableDER : var10_1427) {
                psSystemStorage.getPSSysBDTableStorage((String)pSSysBDTableDER.getPSSYSBDTABLEID()).psSysBDTableDERList.add(pSSysBDTableDER);
            }
        }
        if (bLoadDetail3) {
            void var10_1431;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSBDCOLUMN"));
            Vector vector176 = psSysModelCache.getModelList("PSSYSBDCOLUMN", psSysModelLog4);
            if (vector176 == null) {
                Vector<PSSysBDColumn> vector177 = new Vector<PSSysBDColumn>();
                CallResult callResult = this.getPSSysBDColumnsBySystem(strPSSystemId, vector177);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5927\u6570\u636e\u67b6\u6784\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSBDCOLUMN", psSysModelLog4, vector177);
            }
            for (PSSysBDColumn pSSysBDColumn : var10_1431) {
                psSystemStorage.getPSSysBDTableStorage((String)pSSysBDColumn.getPSSYSBDTABLEID()).psSysBDColumnList.add(pSSysBDColumn);
            }
        }
        bLoadDetail3 = true;
        psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDBSCHEME"));
        Vector vector178 = psSysModelCache.getModelList("PSSYSDBSCHEME", psSysModelLog4);
        if (vector178 == null) {
            Vector<PSSysDBScheme> vector179 = new Vector<PSSysDBScheme>();
            CallResult callResult = this.getAllPSSysDBSchemes2(strPSSystemId, vector179);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSDBSCHEME", psSysModelLog4, vector179);
        }
        psSystemStorage.psSysDBSchemeList.addAll((Collection<PSSysDBScheme>)var10_1435);
        for (PSSysDBScheme pSSysDBScheme : var10_1435) {
            psSystemStorage.psSysDBSchemeMap.put(pSSysDBScheme.getPSSYSDBSCHEMEID(), pSSysDBScheme);
            psSystemStorage.getPSSysDBSchemeStorage((String)pSSysDBScheme.getPSSYSDBSCHEMEID()).psSysDBScheme = pSSysDBScheme;
        }
        if (bLoadDetail3) {
            void var10_1438;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDBTABLE"));
            Vector vector180 = psSysModelCache.getModelList("PSSYSDBTABLE", psSysModelLog4);
            if (vector180 == null) {
                Vector<PSSysDBTable> vector181 = new Vector<PSSysDBTable>();
                CallResult callResult = this.getPSSysDBTablesBySystem(strPSSystemId, vector181);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSDBTABLE", psSysModelLog4, vector181);
            }
            for (PSSysDBTable pSSysDBTable : var10_1438) {
                psSystemStorage.getPSSysDBSchemeStorage((String)pSSysDBTable.getPSSYSDBSCHEMEID()).psSysDBTableList.add(pSSysDBTable);
            }
        }
        if (bLoadDetail3) {
            void var10_1442;
            psSysModelLog4 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDBCOLUMN"));
            Vector vector182 = psSysModelCache.getModelList("PSSYSDBCOLUMN", psSysModelLog4);
            if (vector182 == null) {
                Vector<PSSysDBColumn> vector183 = new Vector<PSSysDBColumn>();
                CallResult callResult = this.getPSSysDBColumnsBySystem(strPSSystemId, vector183);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSDBCOLUMN", psSysModelLog4, vector183);
            }
            for (PSSysDBColumn pSSysDBColumn : var10_1442) {
                psSystemStorage.getPSSysDBTableStorage((String)pSSysDBColumn.getPSSYSDBTABLEID()).psSysDBColumnList.add(pSSysDBColumn);
            }
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONWIZARD"));
        bLoadDetail = true;
        Vector vector184 = psSysModelCache.getModelList("PSDEACTIONWIZARD", psSysModelLog);
        if (vector184 == null) {
            Vector<PSDEActionWizard> vector185 = new Vector<PSDEActionWizard>();
            CallResult callResult = this.getPSDEActionWizardsBySystem(strPSSystemId, vector185);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACTIONWIZARD", psSysModelLog, vector185);
        }
        for (PSDEActionWizard pSDEActionWizard : var10_1446) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEActionWizard.getPSDEID()).psDEActionWizardList.add(pSDEActionWizard);
            PSModelHelperBase.PSDEActionWizardStorage psDEActionWizardStorage = psSystemStorage.getPSDEActionWizardStorage(pSDEActionWizard.getPSDEACTIONWIZARDID());
            psDEActionWizardStorage.psDEActionWizard = pSDEActionWizard;
        }
        bLoadDetail = var10_1446.size() > 0;
        PSSysModelLog pSSysModelLog5 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEAWITEM"));
        Vector vector186 = psSysModelCache.getModelList("PSDEAWITEM", psSysModelLog, pSSysModelLog5);
        if (vector186 == null) {
            Vector<PSDEAWItem> vector187 = new Vector<PSDEAWItem>();
            CallResult callResult = this.getPSDEActionWizardItemsBySystem(strPSSystemId, vector187);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEAWITEM", psSysModelLog, pSSysModelLog5, vector187);
        }
        for (PSDEAWItem pSDEAWItem : var11_552) {
            psSystemStorage.getPSDEActionWizardStorage((String)pSDEAWItem.getPSDEACTIONWIZARDID()).psDEActionWizardItemList.add(pSDEAWItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEAWGROUP"));
        bLoadDetail = true;
        Vector vector188 = psSysModelCache.getModelList("PSDEAWGROUP", psSysModelLog);
        if (vector188 == null) {
            Vector<PSDEAWGroup> vector189 = new Vector<PSDEAWGroup>();
            CallResult callResult = this.getPSDEActionWizardGroupsBySystem(strPSSystemId, vector189);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEAWGROUP", psSysModelLog, vector189);
        }
        for (PSDEAWGroup pSDEAWGroup : var10_1450) {
            psSystemStorage.getPSDataEntityStorage((String)pSDEAWGroup.getPSDEID()).psDEAWGroupList.add(pSDEAWGroup);
            PSModelHelperBase.PSDEActionWizardGroupStorage psDEAWGroupStorage = psSystemStorage.getPSDEActionWizardGroupStorage(pSDEAWGroup.getPSDEAWGROUPID());
            psDEAWGroupStorage.psDEAWGroup = pSDEAWGroup;
        }
        bLoadDetail = var10_1450.size() > 0;
        PSSysModelLog pSSysModelLog6 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEAWGRPDETAIL"));
        Vector vector190 = psSysModelCache.getModelList("PSDEAWGRPDETAIL", psSysModelLog, pSSysModelLog6);
        if (vector190 == null) {
            Vector<PSDEAWGrpDetail> vector191 = new Vector<PSDEAWGrpDetail>();
            CallResult callResult = this.getPSDEActionWizardGroupDetailsBySystem(strPSSystemId, vector191);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEAWGRPDETAIL", psSysModelLog, pSSysModelLog6, vector191);
        }
        for (PSDEAWGrpDetail pSDEAWGrpDetail : var11_559) {
            psSystemStorage.getPSDEActionWizardGroupStorage((String)pSDEAWGrpDetail.getPSDEAWGROUPID()).psDEAWGrpDetailList.add(pSDEAWGrpDetail);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWORKFLOW"));
        Vector<PSWorkflow> psWorkflowList = psSysModelCache.getModelList("PSWORKFLOW", psSysModelLog);
        if (psWorkflowList == null) {
            psWorkflowList = new Vector<PSWorkflow>();
            CallResult callResult = this.getAllPSWorkflows2(strPSSystemId, psWorkflowList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5de5\u4f5c\u6d41\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWORKFLOW", psSysModelLog, psWorkflowList);
        }
        for (PSWorkflow pSWorkflow : psWorkflowList) {
            psSystemStorage.psWorkflowList.add(pSWorkflow);
            PSModelHelperBase.PSWorkflowStorage pSWorkflowStorage = psSystemStorage.getPSWorkflowStorage(pSWorkflow.getPSWORKFLOWID());
            pSWorkflowStorage.psWorkflow = pSWorkflow;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSWFVERSION"));
        Vector<PSWFVersion> psWFVersionList = psSysModelCache.getModelList("PSWFVERSION", psSysModelLog);
        if (psWFVersionList == null) {
            psWFVersionList = new Vector<PSWFVersion>();
            CallResult callResult = this.getPSWFVersionsBySystem(strPSSystemId, psWFVersionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5de5\u4f5c\u6d41\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFVERSION", psSysModelLog, psWFVersionList);
        }
        for (PSWFVersion pSWFVersion : psWFVersionList) {
            psSystemStorage.getPSWorkflowStorage((String)pSWFVersion.getPSWFID()).psWFVersionList.add(pSWFVersion);
            PSModelHelperBase.PSWFVersionStorage pSWFVersionStorage = psSystemStorage.getPSWFVersionStorage(pSWFVersion.getPSWFVERSIONID());
            pSWFVersionStorage.psWFVersion = pSWFVersion;
        }
        Vector<PSWFProcess> psWFProcessList = psSysModelCache.getModelList("PSWFPROCESS", psSysModelLog);
        if (psWFProcessList == null) {
            psWFProcessList = new Vector<PSWFProcess>();
            CallResult callResult = this.getPSWFProcessesBySystem(strPSSystemId, psWFProcessList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFPROCESS", psSysModelLog, psWFProcessList);
        }
        for (PSWFProcess pSWFProcess : psWFProcessList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFProcess.getPSWFVERSIONID()).psWFProcessList.add(pSWFProcess);
        }
        Vector<PSWFProcParam> psWFProcParamList = psSysModelCache.getModelList("PSWFPROCPARAM", psSysModelLog);
        if (psWFProcParamList == null) {
            psWFProcParamList = new Vector<PSWFProcParam>();
            CallResult callResult = this.getPSWFProcParamsBySystem(strPSSystemId, psWFProcParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u5904\u7406\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFPROCPARAM", psSysModelLog, psWFProcParamList);
        }
        for (PSWFProcParam pSWFProcParam : psWFProcParamList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFProcParam.getParamStringValue((String)"PSWFVERSIONID", (String)"")).psWFProcParamList.add(pSWFProcParam);
        }
        Vector<PSWFProcRole> psWFProcRoleList = psSysModelCache.getModelList("PSWFPROCROLE", psSysModelLog);
        if (psWFProcRoleList == null) {
            psWFProcRoleList = new Vector<PSWFProcRole>();
            CallResult callResult = this.getPSWFProcRolesBySystem(strPSSystemId, psWFProcRoleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u5904\u7406\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFPROCROLE", psSysModelLog, psWFProcRoleList);
        }
        for (PSWFProcRole pSWFProcRole : psWFProcRoleList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFProcRole.getParamStringValue((String)"PSWFVERSIONID", (String)"")).psWFProcRoleList.add(pSWFProcRole);
        }
        Vector<PSWFLinkRole> psWFLinkRoleList = psSysModelCache.getModelList("PSWFLINKROLE", psSysModelLog);
        if (psWFLinkRoleList == null) {
            psWFLinkRoleList = new Vector<PSWFLinkRole>();
            CallResult callResult = this.getPSWFLinkRolesBySystem(strPSSystemId, psWFLinkRoleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u8fde\u63a5\u89d2\u8272\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFLINKROLE", psSysModelLog, psWFLinkRoleList);
        }
        for (PSWFLinkRole pSWFLinkRole : psWFLinkRoleList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFLinkRole.getParamStringValue((String)"PSWFVERSIONID", (String)"")).psWFLinkRoleList.add(pSWFLinkRole);
        }
        Vector<PSWFProcSubWF> psWFProcSubWFList = psSysModelCache.getModelList("PSWFPROCSUBWF", psSysModelLog);
        if (psWFProcSubWFList == null) {
            psWFProcSubWFList = new Vector<PSWFProcSubWF>();
            CallResult callResult = this.getPSWFProcSubWFsBySystem(strPSSystemId, psWFProcSubWFList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u5904\u7406\u5b50\u6d41\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFPROCSUBWF", psSysModelLog, psWFProcSubWFList);
        }
        for (PSWFProcSubWF pSWFProcSubWF : psWFProcSubWFList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFProcSubWF.getParamStringValue((String)"PSWFVERSIONID", (String)"")).psWFProcSubWFList.add(pSWFProcSubWF);
        }
        Vector<PSWFLink> psWFLinkList = psSysModelCache.getModelList("PSWFLINK", psSysModelLog);
        if (psWFLinkList == null) {
            psWFLinkList = new Vector<PSWFLink>();
            CallResult callResult = this.getPSWFLinksBySystem(strPSSystemId, psWFLinkList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFLINK", psSysModelLog, psWFLinkList);
        }
        for (PSWFLink pSWFLink : psWFLinkList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFLink.getPSWFVERSIONID()).psWFLinkList.add(pSWFLink);
        }
        Vector<PSWFLinkCond> psWFLinkCondList = psSysModelCache.getModelList("PSWFLINKCOND", psSysModelLog);
        if (psWFLinkCondList == null) {
            psWFLinkCondList = new Vector<PSWFLinkCond>();
            CallResult callResult = this.getPSWFLinkCondsBySystem(strPSSystemId, psWFLinkCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u8fde\u63a5\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFLINKCOND", psSysModelLog, psWFLinkCondList);
        }
        for (PSWFLinkCond pSWFLinkCond : psWFLinkCondList) {
            psSystemStorage.getPSWFVersionStorage((String)pSWFLinkCond.getPSWFVERSIONID()).psWFLinkCondList.add(pSWFLinkCond);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSWFUIACTION", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            CallResult callResult = this.getPSWFUIActionsBySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTION", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction pSDEUIAction : psDEUIActionList) {
            psSystemStorage.getPSWFVersionStorage((String)pSDEUIAction.getPSWFVERSIONID()).psDEUIActionList.add(pSDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSWFUIACTIONGROUP", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            CallResult callResult = this.getPSWFUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTIONGROUP", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup pSDEUIActionGroup : psDEUIActionGroupList) {
            psSystemStorage.getPSWFVersionStorage((String)pSDEUIActionGroup.getPSWFVERSIONID()).psDEUIActionGroupList.add(pSDEUIActionGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSWFUIACTION2", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            CallResult callResult = this.getPSWFUIActions2BySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTION2", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction pSDEUIAction : psDEUIActionList) {
            psSystemStorage.getPSWorkflowStorage((String)pSDEUIAction.getPSWFID()).psDEUIActionList.add(pSDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSWFUIACTIONGROUP2", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            CallResult callResult = this.getPSWFUIActionGroups2BySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTIONGROUP2", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup pSDEUIActionGroup : psDEUIActionGroupList) {
            psSystemStorage.getPSWorkflowStorage((String)pSDEUIActionGroup.getPSWFID()).psDEUIActionGroupList.add(pSDEUIActionGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        Vector vector192 = psSysModelCache.getModelList("PSDEUAGRPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGRPDETAIL")));
        if (vector192 == null) {
            Vector<PSDEUIActionGroupDetail> vector193 = new Vector<PSDEUIActionGroupDetail>();
            CallResult callResult = this.getPSDEUIActionGroupDetailsBySystem(strPSSystemId, vector193);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGRPDETAIL", psSysModelLog, psSysModelLog2, vector193);
        }
        for (PSDEUIActionGroupDetail pSDEUIActionGroupDetail : var10_1506) {
            psSystemStorage.getPSDEUIActionGroupStorage((String)pSDEUIActionGroupDetail.getPSDEUAGROUPID()).psDEUIActionGroupDetailList.add(pSDEUIActionGroupDetail);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFGROUP"));
        Vector vector194 = psSysModelCache.getModelList("PSDEFGROUPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFGROUPDETAIL")));
        if (vector194 == null) {
            Vector<PSDEFGroupDetail> vector195 = new Vector<PSDEFGroupDetail>();
            CallResult callResult = this.getPSDEFGroupDetailsBySystem(strPSSystemId, vector195);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5c5e\u6027\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFGROUPDETAIL", psSysModelLog, psSysModelLog2, vector195);
        }
        for (PSDEFGroupDetail pSDEFGroupDetail : var10_1509) {
            psSystemStorage.getPSDEFGroupStorage((String)pSDEFGroupDetail.getPSDEFGROUPID()).psDEFGroupDetailList.add(pSDEFGroupDetail);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFORMDETAIL"));
        if (psSysModelLog2 == null) {
            psSysModelLog2 = psSysModelLog;
        }
        if ((vector = psSysModelCache.getModelList("PSDEFGROUPITEM", psSysModelLog2)) == null) {
            Vector<PSDEFormDetail> vector196 = new Vector<PSDEFormDetail>();
            CallResult callResult = this.getPSDEFGroupItemsBySystem(strPSSystemId, vector196);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFGROUPITEM", psSysModelLog2, vector196);
        }
        for (PSDEFormDetail pSDEFormDetail : var10_1512) {
            psSystemStorage.getPSDEFGroupStorage((String)pSDEFormDetail.getParamStringValue((String)"PSDEFGROUPID", (String)"")).psDEFormDetailList.add(pSDEFormDetail);
        }
        if (this.getModelInstVer() >= 810) {
            void var10_1515;
            Vector vector197;
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGRIDCOL"));
            if (psSysModelLog2 == null) {
                psSysModelLog2 = psSysModelLog;
            }
            if ((vector197 = psSysModelCache.getModelList("PSDEFGROUPCOLUMN", psSysModelLog2)) == null) {
                Vector<PSDEGridColumn> vector198 = new Vector<PSDEGridColumn>();
                CallResult callResult = this.getPSDEFGroupColumnsBySystem(strPSSystemId, vector198);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFGROUPCOLUMN", psSysModelLog2, vector198);
            }
            for (PSDEGridColumn pSDEGridColumn : var10_1515) {
                psSystemStorage.getPSDEFGroupStorage((String)pSDEGridColumn.getParamStringValue((String)"PSDEFGROUPID", (String)"")).psDEGridColumnList.add(pSDEGridColumn);
            }
        }
        if (this.getModelInstVer() >= 591) {
            void var10_1519;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGROUP"));
            Vector vector199 = psSysModelCache.getModelList("PSDEGROUPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGROUPDETAIL")));
            if (vector199 == null) {
                Vector<PSDEGroupDetail> vector200 = new Vector<PSDEGroupDetail>();
                CallResult callResult = this.getPSDEGroupDetailsBySystem(strPSSystemId, vector200);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGROUPDETAIL", psSysModelLog, psSysModelLog2, vector200);
            }
            for (PSDEGroupDetail pSDEGroupDetail : var10_1519) {
                psSystemStorage.getPSDEGroupStorage((String)pSDEGroupDetail.getPSDEGROUPID()).psDEGroupDetailList.add(pSDEGroupDetail);
            }
        }
        if (this.getModelInstVer() >= 591) {
            void var10_1523;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDERGROUP"));
            Vector vector201 = psSysModelCache.getModelList("PSDERGROUPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDERGROUPDETAIL")));
            if (vector201 == null) {
                Vector<PSDERGroupDetail> vector202 = new Vector<PSDERGroupDetail>();
                CallResult callResult = this.getPSDERGroupDetailsBySystem(strPSSystemId, vector202);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDERGROUPDETAIL", psSysModelLog, psSysModelLog2, vector202);
            }
            for (PSDERGroupDetail pSDERGroupDetail : var10_1523) {
                psSystemStorage.getPSDERGroupStorage((String)pSDERGroupDetail.getPSDERGROUPID()).psDERGroupDetailList.add(pSDERGroupDetail);
            }
        }
        if (this.getModelInstVer() >= 591) {
            void var10_1527;
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACTIONGROUP"));
            Vector vector203 = psSysModelCache.getModelList("PSDEAGDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEAGDETAIL")));
            if (vector203 == null) {
                Vector<PSDEAGDetail> vector204 = new Vector<PSDEAGDetail>();
                CallResult callResult = this.getPSDEActionGroupDetailsBySystem(strPSSystemId, vector204);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u884c\u4e3a\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEAGDETAIL", psSysModelLog, psSysModelLog2, vector204);
            }
            for (PSDEAGDetail pSDEAGDetail : var10_1527) {
                psSystemStorage.getPSDEActionGroupStorage((String)pSDEAGDetail.getPSDEACTIONGROUPID()).psDEActionGroupDetailList.add(pSDEAGDetail);
            }
        }
        if ((psDEFInputTipSetList = psSysModelCache.getModelList("PSDEFINPUTTIPSET", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFINPUTTIPSET")))) == null) {
            psDEFInputTipSetList = new Vector<PSDEFInputTipSet>();
            CallResult callResult = this.getAllPSDEFInputTipSets2(strPSSystemId, psDEFInputTipSetList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFINPUTTIPSET", psSysModelLog, psDEFInputTipSetList);
        }
        psSystemStorage.psDEFInputTipSetList.addAll(psDEFInputTipSetList);
        for (PSDEFInputTipSet pSDEFInputTipSet : psDEFInputTipSetList) {
            psSystemStorage.psDEFInputTipSetMap.put(pSDEFInputTipSet.getPSDEFINPUTTIPSETID(), pSDEFInputTipSet);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUNISTATE"));
        Vector<PSSysUniState> psSysUniStateList = psSysModelCache.getModelList("PSSYSUNISTATE", psSysModelLog);
        if (psSysUniStateList == null) {
            psSysUniStateList = new Vector<PSSysUniState>();
            CallResult callResult = this.getAllPSSysUniStates2(strPSSystemId, psSysUniStateList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUNISTATE", psSysModelLog, psSysUniStateList);
        }
        psSystemStorage.psSysUniStateList.addAll(psSysUniStateList);
        for (PSSysUniState pSSysUniState : psSysUniStateList) {
            psSystemStorage.psSysUniStateMap.put(pSSysUniState.getPSSYSUNISTATEID(), pSSysUniState);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDTSQUEUE"));
        Vector<PSSysDTSQueue> psSysDTSQueueList = psSysModelCache.getModelList("PSDEDTSQUEUE", psSysModelLog);
        if (psSysDTSQueueList == null) {
            psSysDTSQueueList = new Vector<PSSysDTSQueue>();
            CallResult callResult = this.getAllPSSysDTSQueues2(strPSSystemId, psSysDTSQueueList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDTSQUEUE", psSysModelLog, psSysDTSQueueList);
        }
        psSystemStorage.psSysDTSQueueList.addAll(psSysDTSQueueList);
        for (PSSysDTSQueue pSSysDTSQueue : psSysDTSQueueList) {
            psSystemStorage.psSysDTSQueueMap.put(pSSysDTSQueue.getPSDEDTSQUEUEID(), pSSysDTSQueue);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSUTILDE"));
        Vector<PSSysUtil> psSysUtilList = psSysModelCache.getModelList("PSSYSUTILDE", psSysModelLog);
        if (psSysUtilList == null) {
            psSysUtilList = new Vector<PSSysUtil>();
            CallResult callResult = this.getAllPSSysUtils2(strPSSystemId, psSysUtilList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u7cfb\u7edf\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSUTILDE", psSysModelLog, psSysUtilList);
        }
        psSystemStorage.psSysUtilList.addAll(psSysUtilList);
        for (PSSysUtil pSSysUtil : psSysUtilList) {
            psSystemStorage.psSysUtilMap.put(pSSysUtil.getPSSYSUTILDEID(), pSSysUtil);
        }
        if (this.getModelInstVer() >= 787) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFORM"));
            psDEFormList = psSysModelCache.getModelList("PSDEFORM", psSysModelLog);
            if (psDEFormList == null) {
                psDEFormList = new Vector<PSDEForm>();
                CallResult callResult = this.getPSDEFormsBySystem(strPSSystemId, psDEFormList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFORM", psSysModelLog, psDEFormList);
            }
            Iterator iterator8 = psDEFormList.iterator();
            while (iterator8.hasNext()) {
                PSDEForm pSDEForm;
                psSystemStorage.getPSDEFormStorage((String)pSDEForm.getPSDEFORMID()).psDEForm = pSDEForm = (PSDEForm)((Object)iterator8.next());
            }
            Vector<PSDEFormDetail> psDEFormDetailList2 = psSysModelCache.getModelList("PSDEFORMDETAIL", psSysModelLog);
            if (psDEFormDetailList2 == null) {
                psDEFormDetailList2 = new Vector<PSDEFormDetail>();
                CallResult callResult = this.getPSDEFormDetailsBySystem(strPSSystemId, psDEFormDetailList2);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFORMDETAIL", psSysModelLog, psDEFormDetailList2);
            }
            for (PSDEFormDetail pSDEFormDetail : psDEFormDetailList2) {
                psSystemStorage.getPSDEFormStorage((String)pSDEFormDetail.getPSDEFORMID()).psDEFormDetailList.add(pSDEFormDetail);
            }
            Vector<PSDEFDLogic> psDEFDLogicList = psSysModelCache.getModelList("PSDEFDLOGIC", psSysModelLog);
            if (psDEFDLogicList == null) {
                psDEFDLogicList = new Vector<PSDEFDLogic>();
                CallResult callResult = this.getPSDEFDLogicsBySystem(strPSSystemId, psDEFDLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u903b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFDLOGIC", psSysModelLog, psDEFDLogicList);
            }
            for (PSDEFDLogic pSDEFDLogic : psDEFDLogicList) {
                psSystemStorage.getPSDEFormStorage((String)pSDEFDLogic.getParamStringValue((String)"PSDEFORMID", (String)"")).psDEFDLogicList.add(pSDEFDLogic);
            }
        }
        log.info((Object)StringHelper.Format((String)"\u9884\u8f7d\u7cfb\u7edf[%1$s]\u8017\u65f6[%2$s]ms", (Object)strPSSystemId, (Object)(System.currentTimeMillis() - nBeginTime)));
        return psSystemStorage;
    }

    protected synchronized PSModelHelperBase.PSSystemStorage getCurrentPSSystemStorage() {
        ArrayList<PSModelHelperBase.PSSystemStorage> stack = this.psSystemStorageStack.get();
        if (stack == null || stack.size() == 0) {
            return null;
        }
        return stack.get(0);
    }

    @Override
    public synchronized void stopLoadPSSystem() throws Exception {
        this.active();
        ArrayList<PSModelHelperBase.PSSystemStorage> stack = this.psSystemStorageStack.get();
        if (stack == null || stack.size() == 0) {
            return;
        }
        stack.remove(0);
    }

    protected PSModelHelperBase.PSSysAppStorage createPSSysAppStorage(String strPSSysAppId, int nLoadLevel) throws Exception {
        Vector<PSDEDataView> psDEDataViewList;
        Vector<PSDEList> psDEListList;
        Vector<PSDEChart> psDEChartList;
        Vector<PSDETreeView> psDETreeViewList;
        Vector<PSDEGrid> psDEGridList;
        Vector<PSDEForm> psDEFormList;
        Vector<PSDynaDEViewTempl> psDynaDEViewTemplList;
        Vector<PSDEViewCtrl> psDEViewCtrlList;
        Vector<PSAppUserMode> psAppUserModeList;
        Vector<PSAppWF> psAppWFList;
        Vector<PSAppFunc> psAppFuncList;
        Vector<PSAppPkg> psAppPkgList;
        Vector<PSDEGridColumn> psDEGridColumnList;
        PSModelHelperBase.PSDEUIActionGroupStorage psDEUIActionGroupStorage;
        Vector<PSDEUIAction> psDEUIActionList;
        PSModelHelperBase.PSDELogicStorage psDELogicStorage;
        CallResult callResult;
        long nBeginTime = System.currentTimeMillis();
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = new PSModelHelperBase.PSSysAppStorage();
        psSysAppStorage.strPSSysAppId = strPSSysAppId;
        psSysAppStorage.nLoadLevel = nLoadLevel;
        PSModelHelperBase.PSSysModelCache psSysModelCache = this.getPSSysModelCache("APP:" + strPSSysAppId);
        HashMap<String, PSSysModelLog> psSysModelLogMap = new HashMap<String, PSSysModelLog>();
        PSSystemApplication psSystemApplication = new PSSystemApplication();
        CallResult callResult3 = this.getPSSystemApplication(strPSSysAppId, psSystemApplication);
        if (callResult3.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult3.getErrorInfo()));
        }
        if (psSystemApplication.getCREATEDATE() != null) {
            String strModelCacheTag = DateHelper.toDateTimeString((Date)psSystemApplication.getCREATEDATE());
            if (!StringHelper.IsNullOrEmpty((String)psSysModelCache.getCacheTag()) && StringHelper.Compare((String)psSysModelCache.getCacheTag(), (String)strModelCacheTag, (boolean)false) != 0) {
                this.resetCache();
                psSysModelCache = this.getPSSysModelCache("APP:" + strPSSysAppId);
            }
            psSysModelCache.setCacheTag(strModelCacheTag);
        } else {
            log.warn((Object)StringHelper.Format((String)"\u7cfb\u7edf\u5e94\u7528[%1$s]\u5efa\u7acb\u65f6\u95f4\u4e3a\u7a7a", (Object)strPSSysAppId));
        }
        String strPSSystemId = psSystemApplication.getPSSYSTEMID();
        Vector<PSSysModelLog> psSysModelLogList = new Vector<PSSysModelLog>();
        CallResult callResult4 = this.getPSSysModelLogs(psSystemApplication.getPSSYSTEMID(), psSysModelLogList);
        if (callResult4.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6a21\u578b\u65e5\u5fd7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult4.getErrorInfo()));
        }
        for (PSSysModelLog psSysModelLog : psSysModelLogList) {
            if (psSysModelLogMap.containsKey(psSysModelLog.getPSSYSMODELLOGNAME())) continue;
            psSysModelLogMap.put(psSysModelLog.getPSSYSMODELLOGNAME(), psSysModelLog);
        }
        PSSysModelLog psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDATAENTITY"));
        Vector<PSDataEntity> psDataEntityList = psSysModelCache.getModelList("PSDATAENTITY", psSysModelLog);
        if (psDataEntityList == null) {
            psDataEntityList = new Vector<PSDataEntity>();
            CallResult callResult2 = this.getAllPSDataEntities2(psSystemApplication.getPSSYSTEMID(), psDataEntityList);
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDATAENTITY", psSysModelLog, psDataEntityList);
        }
        for (PSDataEntity psDataEntity : psDataEntityList) {
            psSysAppStorage.psDataEntityMap.put(psDataEntity.getPSDATAENTITYID(), psDataEntity);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDELOGIC"));
        Vector<PSDELogic> psDELogicList = psSysModelCache.getModelList("PSDELOGIC", psSysModelLog);
        if (psDELogicList == null) {
            psDELogicList = new Vector<PSDELogic>();
            callResult = this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGIC", psSysModelLog, psDELogicList);
        }
        for (PSDELogic psDELogic : psDELogicList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDELogic.getPSDEID()).psDELogicList.add(psDELogic);
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogic.getPSDELOGICID());
            psDELogicStorage.psDELogic = psDELogic;
        }
        Vector<PSDELogicParam> psDELogicParamList = psSysModelCache.getModelList("PSDELOGICPARAM", psSysModelLog);
        if (psDELogicParamList == null) {
            psDELogicParamList = new Vector<PSDELogicParam>();
            callResult = this.getPSDELogicParamsBySystem(strPSSystemId, psDELogicParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICPARAM", psSysModelLog, psDELogicParamList);
        }
        for (PSDELogicParam psDELogicParam : psDELogicParamList) {
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicParam.getPSDELOGICID());
            psDELogicStorage.psDELogicParamList.add(psDELogicParam);
        }
        Vector<PSDELogicNode> psDELogicNodeList = psSysModelCache.getModelList("PSDELOGICNODE", psSysModelLog);
        if (psDELogicNodeList == null) {
            psDELogicNodeList = new Vector<PSDELogicNode>();
            callResult = this.getPSDELogicNodesBySystem(strPSSystemId, psDELogicNodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICNODE", psSysModelLog, psDELogicNodeList);
        }
        for (PSDELogicNode psDELogicNode : psDELogicNodeList) {
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicNode.getPSDELOGICID());
            psDELogicStorage.psDELogicNodeList.add(psDELogicNode);
        }
        Vector<PSDELogicLink> psDELogicLinkList = psSysModelCache.getModelList("PSDELOGICLINK", psSysModelLog);
        if (psDELogicLinkList == null) {
            psDELogicLinkList = new Vector<PSDELogicLink>();
            callResult = this.getPSDELogicLinksBySystem(strPSSystemId, psDELogicLinkList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELOGICLINK", psSysModelLog, psDELogicLinkList);
        }
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicLink.getPSDELOGICID());
            psDELogicStorage.psDELogicLinkList.add(psDELogicLink);
        }
        Vector<PSDELogicNodeParam> psDELogicNodeParamList = psSysModelCache.getModelList("PSDELNPARAM", psSysModelLog);
        if (psDELogicNodeParamList == null) {
            psDELogicNodeParamList = new Vector<PSDELogicNodeParam>();
            callResult = this.getPSDELogicNodeParamsBySystem(strPSSystemId, psDELogicNodeParamList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53c2\u6570\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELNPARAM", psSysModelLog, psDELogicNodeParamList);
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicNodeParam.getPSDELOGICID());
            psDELogicStorage.psDELogicNodeParamList.add(psDELogicNodeParam);
        }
        Vector<PSDELogicLinkCond> psDELogicLinkCondList = psSysModelCache.getModelList("PSDELLCOND", psSysModelLog);
        if (psDELogicLinkCondList == null) {
            psDELogicLinkCondList = new Vector<PSDELogicLinkCond>();
            callResult = this.getPSDELogicLinkCondsBySystem(strPSSystemId, psDELogicLinkCondList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELLCOND", psSysModelLog, psDELogicLinkCondList);
        }
        for (PSDELogicLinkCond psDELogicLinkCond : psDELogicLinkCondList) {
            psDELogicStorage = psSysAppStorage.getPSDELogicStorage(psDELogicLinkCond.getPSDELOGICID());
            psDELogicStorage.psDELogicLinkCondList.add(psDELogicLinkCond);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACMODE"));
        Vector<PSDEACMode> psDEACModeList = psSysModelCache.getModelList("PSDEACMODE", psSysModelLog);
        if (psDEACModeList == null) {
            psDEACModeList = new Vector<PSDEACMode>();
            callResult = this.getPSDEACModesBySystem(strPSSystemId, psDEACModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACMODE", psSysModelLog, psDEACModeList);
        }
        for (PSDEACMode psDEACMode : psDEACModeList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEACMode.getPSDEID()).psDEACModeList.add(psDEACMode);
            PSModelHelperBase.PSDEACModeStorage psDEACModeStorage = psSysAppStorage.getPSDEACModeStorage(psDEACMode.getPSDEACMODEID());
            psDEACModeStorage.psDEACMode = psDEACMode;
        }
        PSSysModelLog psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEACMODEITEM"));
        Vector<PSDEACModeItem> psDEACModeItemList = psSysModelCache.getModelList("PSDEACMODEITEM", psSysModelLog, psSysModelLog2);
        if (psDEACModeItemList == null) {
            psDEACModeItemList = new Vector<PSDEACModeItem>();
            CallResult callResult2 = this.getPSDEACModeItemsBySystem(strPSSystemId, psDEACModeItemList);
            if (callResult2.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEACMODEITEM", psSysModelLog, psSysModelLog2, psDEACModeItemList);
        }
        for (PSDEACModeItem pSDEACModeItem : psDEACModeItemList) {
            PSModelHelperBase.PSDEACModeStorage psDEACModeStorage = psSysAppStorage.getPSDEACModeStorage(pSDEACModeItem.getPSDEACMODEID());
            psDEACModeStorage.psDEACModeItemList.add(pSDEACModeItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAP"));
        Vector<PSDEMap> psDEMapList = psSysModelCache.getModelList("PSDEMAP", psSysModelLog);
        if (psDEMapList == null) {
            psDEMapList = new Vector<PSDEMap>();
            callResult = this.getPSDEMapsBySystem(strPSSystemId, psDEMapList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAP", psSysModelLog, psDEMapList);
        }
        for (PSDEMap psDEMap : psDEMapList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEMap.getPSDEID()).psDEMapList.add(psDEMap);
            Iterator psDEMapStorage = psSysAppStorage.getPSDEMapStorage(psDEMap.getPSDEMAPID());
            ((PSModelHelperBase.PSDEMapStorage)((Object)psDEMapStorage)).psDEMap = psDEMap;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDETAIL"));
        Vector<PSDEMapDetail> psDEMapDetailList = psSysModelCache.getModelList("PSDEMAPDETAIL", psSysModelLog, psSysModelLog2);
        if (psDEMapDetailList == null) {
            psDEMapDetailList = new Vector<PSDEMapDetail>();
            CallResult callResult5 = this.getPSDEMapDetailsBySystem(strPSSystemId, psDEMapDetailList);
            if (callResult5.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult5.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDETAIL", psSysModelLog, psSysModelLog2, psDEMapDetailList);
        }
        for (PSDEMapDetail pSDEMapDetail : psDEMapDetailList) {
            psSysAppStorage.getPSDEMapStorage((String)pSDEMapDetail.getPSDEMAPID()).psDEMapDetailList.add(pSDEMapDetail);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPACTION"));
        Vector<PSDEMapAction> psDEMapActionList = psSysModelCache.getModelList("PSDEMAPACTION", psSysModelLog, psSysModelLog2);
        if (psDEMapActionList == null) {
            psDEMapActionList = new Vector<PSDEMapAction>();
            CallResult callResult6 = this.getPSDEMapActionsBySystem(strPSSystemId, psDEMapActionList);
            if (callResult6.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult6.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPACTION", psSysModelLog, psSysModelLog2, psDEMapActionList);
        }
        for (PSDEMapAction pSDEMapAction : psDEMapActionList) {
            psSysAppStorage.getPSDEMapStorage((String)pSDEMapAction.getPSDEMAPID()).psDEMapActionList.add(pSDEMapAction);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDQ"));
        Vector<PSDEMapDataQuery> psDEMapDataQueryList = psSysModelCache.getModelList("PSDEMAPDQ", psSysModelLog, psSysModelLog2);
        if (psDEMapDataQueryList == null) {
            psDEMapDataQueryList = new Vector<PSDEMapDataQuery>();
            CallResult callResult7 = this.getPSDEMapDataQueriesBySystem(strPSSystemId, psDEMapDataQueryList);
            if (callResult7.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult7.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDQ", psSysModelLog, psSysModelLog2, psDEMapDataQueryList);
        }
        for (PSDEMapDataQuery pSDEMapDataQuery : psDEMapDataQueryList) {
            psSysAppStorage.getPSDEMapStorage((String)pSDEMapDataQuery.getPSDEMAPID()).psDEMapDataQueryList.add(pSDEMapDataQuery);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEMAPDS"));
        Vector<PSDEMapDataSet> psDEMapDataSetList = psSysModelCache.getModelList("PSDEMAPDS", psSysModelLog, psSysModelLog2);
        if (psDEMapDataSetList == null) {
            psDEMapDataSetList = new Vector<PSDEMapDataSet>();
            CallResult callResult8 = this.getPSDEMapDataSetsBySystem(strPSSystemId, psDEMapDataSetList);
            if (callResult8.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6620\u5c04\u6570\u636e\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult8.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEMAPDS", psSysModelLog, psSysModelLog2, psDEMapDataSetList);
        }
        for (PSDEMapDataSet pSDEMapDataSet : psDEMapDataSetList) {
            psSysAppStorage.getPSDEMapStorage((String)pSDEMapDataSet.getPSDEMAPID()).psDEMapDataSetList.add(pSDEMapDataSet);
        }
        if (this.getModelInstVer() >= 605) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLLOGICGROUP"));
            Vector<PSCtrlLogicGroup> psCtrlLogicGroupList = psSysModelCache.getModelList("PSCTRLLOGICGROUP", psSysModelLog);
            if (psCtrlLogicGroupList == null) {
                psCtrlLogicGroupList = new Vector<PSCtrlLogicGroup>();
                callResult = this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u754c\u9762\u903b\u8f91\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSCTRLLOGICGROUP", psSysModelLog, psCtrlLogicGroupList);
            }
            for (PSCtrlLogicGroup psCtrlLogicGroup : psCtrlLogicGroupList) {
                if (!StringHelper.IsNullOrEmpty((String)psCtrlLogicGroup.getPSDEID())) {
                    psSysAppStorage.getPSDataEntityStorage((String)psCtrlLogicGroup.getPSDEID()).psCtrlLogicGroupList.add(psCtrlLogicGroup);
                } else {
                    psSysAppStorage.psCtrlLogicGroupList.add(psCtrlLogicGroup);
                }
                PSModelHelperBase.PSCtrlLogicGroupStorage psCtrlLogicGroupStorage = psSysAppStorage.getPSCtrlLogicGroupStorage(psCtrlLogicGroup.getPSCTRLLOGICGROUPID());
                psCtrlLogicGroupStorage.psCtrlLogicGroup = psCtrlLogicGroup;
            }
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLLOGICGROUP"));
            Vector<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList = psSysModelCache.getModelList("PSCTRLLOGICGRPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSCTRLLOGICGRPDETAIL")));
            if (psCtrlLogicGroupDetailList == null) {
                psCtrlLogicGroupDetailList = new Vector<PSCtrlLogicGroupDetail>();
                CallResult callResult9 = this.getPSCtrlLogicGroupDetailsBySystem(strPSSystemId, psCtrlLogicGroupDetailList);
                if (callResult9.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult9.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSCTRLLOGICGRPDETAIL", psSysModelLog, psSysModelLog2, psCtrlLogicGroupDetailList);
            }
            for (PSCtrlLogicGroupDetail pSCtrlLogicGroupDetail : psCtrlLogicGroupDetailList) {
                psSysAppStorage.getPSCtrlLogicGroupStorage((String)pSCtrlLogicGroupDetail.getPSCTRLLOGICGROUPID()).psCtrlLogicGroupDetailList.add(pSCtrlLogicGroupDetail);
            }
        }
        if ((psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION:SYS", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION")))) == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            callResult = this.getPSSysDEUIActions2(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUIACTION:SYS", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psSysAppStorage.psDEUIActionList.add(psDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSDEUIACTION", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            callResult = this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUIACTION", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEUIAction.getPSDEID()).psDEUIActionList.add(psDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = psSysModelCache.getModelList("PSDEUAGROUP:SYS", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            callResult = this.getPSSysDEUIActionGroups2(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGROUP:SYS", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            psSysAppStorage.psDEUIActionGroupList.add(psDEUIActionGroup);
            psDEUIActionGroupStorage = psSysAppStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
            psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSDEUAGROUP", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            callResult = this.getPSDEUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGROUP", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEUIActionGroup.getPSDEID()).psDEUIActionGroupList.add(psDEUIActionGroup);
            psDEUIActionGroupStorage = psSysAppStorage.getPSDEUIActionGroupStorage(psDEUIActionGroup.getPSDEUAGROUPID());
            psDEUIActionGroupStorage.psDEUIActionGroup = psDEUIActionGroup;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEPRINT"));
        Vector<PSDEPrint> psDEPrintList = psSysModelCache.getModelList("PSDEPRINT", psSysModelLog);
        if (psDEPrintList == null) {
            psDEPrintList = new Vector<PSDEPrint>();
            callResult = this.getPSDEPrintsBySystem(strPSSystemId, psDEPrintList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEPRINT", psSysModelLog, psDEPrintList);
        }
        for (PSDEPrint psDEPrint : psDEPrintList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEPrint.getPSDEID()).psDEPrintList.add(psDEPrint);
            PSModelHelperBase.PSDEPrintStorage psDEPrintStorage = psSysAppStorage.getPSDEPrintStorage(psDEPrint.getPSDEPRINTID());
            psDEPrintStorage.psDEPrint = psDEPrint;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEREPORT"));
        Vector<PSDEReport> psDEReportList = psSysModelCache.getModelList("PSDEREPORT", psSysModelLog);
        if (psDEReportList == null) {
            psDEReportList = new Vector<PSDEReport>();
            callResult = this.getPSDEReportsBySystem(strPSSystemId, psDEReportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEREPORT", psSysModelLog, psDEReportList);
        }
        for (PSDEReport psDEReport : psDEReportList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEReport.getPSDEID()).psDEReportList.add(psDEReport);
            PSModelHelperBase.PSDEReportStorage psDEReportStorage = psSysAppStorage.getPSDEReportStorage(psDEReport.getPSDEREPORTID());
            psDEReportStorage.psDEReport = psDEReport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEREPITEM"));
        Vector<PSDEReportItem> psDEReportItemList = psSysModelCache.getModelList("PSDEREPITEM", psSysModelLog, psSysModelLog2);
        if (psDEReportItemList == null) {
            psDEReportItemList = new Vector<PSDEReportItem>();
            CallResult callResult10 = this.getPSDEReportItemsBySystem(strPSSystemId, psDEReportItemList);
            if (callResult10.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u62a5\u8868\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult10.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEREPITEM", psSysModelLog, psSysModelLog2, psDEReportItemList);
        }
        for (PSDEReportItem pSDEReportItem : psDEReportItemList) {
            psSysAppStorage.getPSDEReportStorage((String)pSDEReportItem.getMAJORPSDEREPORTID()).psDEReportItemList.add(pSDEReportItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAEXP"));
        Vector<PSDEDataExport> psDEDataExportList = psSysModelCache.getModelList("PSDEDATAEXP", psSysModelLog);
        if (psDEDataExportList == null) {
            psDEDataExportList = new Vector<PSDEDataExport>();
            callResult = this.getPSDEDataExportsBySystem(strPSSystemId, psDEDataExportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAEXP", psSysModelLog, psDEDataExportList);
        }
        for (PSDEDataExport psDEDataExport : psDEDataExportList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEDataExport.getPSDEID()).psDEDataExportList.add(psDEDataExport);
            PSModelHelperBase.PSDEDataExportStorage psDEDataExportStorage = psSysAppStorage.getPSDEDataExportStorage(psDEDataExport.getPSDEDATAEXPID());
            psDEDataExportStorage.psDEDataExport = psDEDataExport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGRIDCOL"));
        if (psSysModelLog2 == null) {
            psSysModelLog2 = psSysModelLog;
        }
        if ((psDEGridColumnList = psSysModelCache.getModelList("PSDEDATAEXPITEM", psSysModelLog2)) == null) {
            psDEGridColumnList = new Vector<PSDEGridColumn>();
            CallResult callResult11 = this.getPSDEDataExportItemsBySystem(strPSSystemId, psDEGridColumnList);
            if (callResult11.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult11.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAEXPITEM", psSysModelLog2, psDEGridColumnList);
        }
        for (PSDEGridColumn pSDEGridColumn : psDEGridColumnList) {
            psSysAppStorage.getPSDEDataExportStorage((String)pSDEGridColumn.getParamStringValue((String)"PSDEDATAEXPID", (String)"")).psDEGridColumnList.add(pSDEGridColumn);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAIMP"));
        Vector<PSDEDataImport> psDEDataImportList = psSysModelCache.getModelList("PSDEDATAIMP", psSysModelLog);
        if (psDEDataImportList == null) {
            psDEDataImportList = new Vector<PSDEDataImport>();
            callResult = this.getPSDEDataImportsBySystem(strPSSystemId, psDEDataImportList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAIMP", psSysModelLog, psDEDataImportList);
        }
        for (PSDEDataImport psDEDataImport : psDEDataImportList) {
            psSysAppStorage.getPSDataEntityStorage((String)psDEDataImport.getPSDEID()).psDEDataImportList.add(psDEDataImport);
            Iterator psDEDataImportStorage = psSysAppStorage.getPSDEDataImportStorage(psDEDataImport.getPSDEDATAIMPID());
            ((PSModelHelperBase.PSDEDataImportStorage)((Object)psDEDataImportStorage)).psDEDataImport = psDEDataImport;
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAIMPITEM"));
        Vector<PSDEDataImportItem> psDEDataImportItemList = psSysModelCache.getModelList("PSDEDATAIMPITEM", psSysModelLog, psSysModelLog2);
        if (psDEDataImportItemList == null) {
            psDEDataImportItemList = new Vector<PSDEDataImportItem>();
            CallResult callResult12 = this.getPSDEDataImportItemsBySystem(strPSSystemId, psDEDataImportItemList);
            if (callResult12.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult12.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAIMPITEM", psSysModelLog, psSysModelLog2, psDEDataImportItemList);
        }
        for (PSDEDataImportItem pSDEDataImportItem : psDEDataImportItemList) {
            psSysAppStorage.getPSDEDataImportStorage((String)pSDEDataImportItem.getParamStringValue((String)"PSDEDATAIMPID", (String)"")).psDEDataImportItemList.add(pSDEDataImportItem);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSWFUIACTION", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            callResult = this.getPSWFUIActionsBySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTION", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psSysAppStorage.getPSWFVersionStorage((String)psDEUIAction.getPSWFVERSIONID()).psDEUIActionList.add(psDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSWFUIACTIONGROUP", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            callResult = this.getPSWFUIActionGroupsBySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTIONGROUP", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            psSysAppStorage.getPSWFVersionStorage((String)psDEUIActionGroup.getPSWFVERSIONID()).psDEUIActionGroupList.add(psDEUIActionGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUIACTION"));
        psDEUIActionList = psSysModelCache.getModelList("PSWFUIACTION2", psSysModelLog);
        if (psDEUIActionList == null) {
            psDEUIActionList = new Vector<PSDEUIAction>();
            callResult = this.getPSWFUIActions2BySystem(strPSSystemId, psDEUIActionList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTION2", psSysModelLog, psDEUIActionList);
        }
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psSysAppStorage.getPSWorkflowStorage((String)psDEUIAction.getPSWFID()).psDEUIActionList.add(psDEUIAction);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        psDEUIActionGroupList = psSysModelCache.getModelList("PSWFUIACTIONGROUP2", psSysModelLog);
        if (psDEUIActionGroupList == null) {
            psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
            callResult = this.getPSWFUIActionGroups2BySystem(strPSSystemId, psDEUIActionGroupList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSWFUIACTIONGROUP2", psSysModelLog, psDEUIActionGroupList);
        }
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            psSysAppStorage.getPSWorkflowStorage((String)psDEUIActionGroup.getPSWFID()).psDEUIActionGroupList.add(psDEUIActionGroup);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGROUP"));
        Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = psSysModelCache.getModelList("PSDEUAGRPDETAIL", psSysModelLog, psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEUAGRPDETAIL")));
        if (psDEUIActionGroupDetailList == null) {
            psDEUIActionGroupDetailList = new Vector<PSDEUIActionGroupDetail>();
            CallResult callResult13 = this.getPSDEUIActionGroupDetailsBySystem(strPSSystemId, psDEUIActionGroupDetailList);
            if (callResult13.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult13.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEUAGRPDETAIL", psSysModelLog, psSysModelLog2, psDEUIActionGroupDetailList);
        }
        for (PSDEUIActionGroupDetail pSDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
            psSysAppStorage.getPSDEUIActionGroupStorage((String)pSDEUIActionGroupDetail.getPSDEUAGROUPID()).psDEUIActionGroupDetailList.add(pSDEUIActionGroupDetail);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPMODULE"));
        Vector<PSAppModule> psAppModuleList = psSysModelCache.getModelList("PSAPPMODULE", psSysModelLog);
        if (psAppModuleList == null) {
            psAppModuleList = new Vector<PSAppModule>();
            callResult = this.getAllPSAppModules2(strPSSysAppId, psAppModuleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPMODULE", psSysModelLog, psAppModuleList);
        }
        psSysAppStorage.psAppModuleList.addAll(psAppModuleList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPVIEW"));
        Vector<PSAppView> psAppViewList = psSysModelCache.getModelList("PSAPPVIEW", psSysModelLog);
        if (psAppViewList == null) {
            psAppViewList = new Vector<PSAppView>();
            callResult = this.getAllPSAppViews2(strPSSysAppId, psAppViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPVIEW", psSysModelLog, psAppViewList);
        }
        psSysAppStorage.psAppViewList.addAll(psAppViewList);
        for (PSAppView psAppView : psAppViewList) {
            psSysAppStorage.psAppViewMap.put(psAppView.getPSAPPVIEWID(), psAppView);
            psSysAppStorage.getPSAppViewStorage((String)psAppView.getPSAPPVIEWID()).psAppView = psAppView;
        }
        Vector<PSAppViewRef> psAppViewRefList = psSysModelCache.getModelList("PSAPPVIEWREF", psSysModelLog);
        if (psAppViewRefList == null) {
            psAppViewRefList = new Vector<PSAppViewRef>();
            callResult = this.getPSAppViewRefsBySystem(psSystemApplication.getPSSYSTEMID(), psAppViewRefList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPVIEWREF", psSysModelLog, psAppViewRefList);
        }
        for (PSAppViewRef psAppViewRef : psAppViewRefList) {
            psSysAppStorage.getPSAppViewStorage((String)psAppViewRef.getMAJORPSAPPVIEWID()).psAppViewRefList.add(psAppViewRef);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPLAN"));
        Vector<PSAppLan> psAppLanList = psSysModelCache.getModelList("PSAPPLAN", psSysModelLog);
        if (psAppLanList == null) {
            psAppLanList = new Vector<PSAppLan>();
            callResult = this.getAllPSAppLans2(strPSSysAppId, psAppLanList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u8bed\u8a00\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPLAN", psSysModelLog, psAppLanList);
        }
        psSysAppStorage.psAppLanList.addAll(psAppLanList);
        if (this.getModelInstVer() >= 747) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPLOGIC"));
            Vector<PSAppLogic> psAppLogicList = psSysModelCache.getModelList("PSAPPLOGIC", psSysModelLog);
            if (psAppLogicList == null) {
                psAppLogicList = new Vector<PSAppLogic>();
                callResult = this.getAllPSAppLogics2(strPSSysAppId, psAppLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPLOGIC", psSysModelLog, psAppLogicList);
            }
            psSysAppStorage.psAppLogicList.addAll(psAppLogicList);
        }
        if ((psAppPkgList = psSysModelCache.getModelList("PSAPPPKG", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPPKG")))) == null) {
            psAppPkgList = new Vector<PSAppPkg>();
            callResult = this.getAllPSAppPkgs2(strPSSysAppId, psAppPkgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPPKG", psSysModelLog, psAppPkgList);
        }
        psSysAppStorage.psAppPkgList.addAll(psAppPkgList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPUISTYLE"));
        Vector<PSAppUIStyle> psAppUIStyleList = psSysModelCache.getModelList("PSAPPUISTYLE", psSysModelLog);
        if (psAppUIStyleList == null) {
            psAppUIStyleList = new Vector<PSAppUIStyle>();
            callResult = this.getAllPSAppUIStyles2(strPSSysAppId, psAppUIStyleList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u754c\u9762\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPUISTYLE", psSysModelLog, psAppUIStyleList);
        }
        psSysAppStorage.psAppUIStyleList.addAll(psAppUIStyleList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPUTILPAGE"));
        Vector<PSAppUtilPage> psAppUtilPageList = psSysModelCache.getModelList("PSAPPUTILPAGE", psSysModelLog);
        if (psAppUtilPageList == null) {
            psAppUtilPageList = new Vector<PSAppUtilPage>();
            callResult = this.getAllPSAppUtilPages2(strPSSysAppId, psAppUtilPageList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u529f\u80fd\u9875\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPUTILPAGE", psSysModelLog, psAppUtilPageList);
        }
        psSysAppStorage.psAppUtilPageList.addAll(psAppUtilPageList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPPDTVIEW"));
        Vector<PSAppPDTView> psAppPDTViewList = psSysModelCache.getModelList("PSAPPPDTVIEW", psSysModelLog);
        if (psAppPDTViewList == null) {
            psAppPDTViewList = new Vector<PSAppPDTView>();
            callResult = this.getAllPSAppPDTViews2(strPSSysAppId, psAppPDTViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u9884\u7f6e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPPDTVIEW", psSysModelLog, psAppPDTViewList);
        }
        psSysAppStorage.psAppPDTViewList.addAll(psAppPDTViewList);
        if (this.getModelInstVer() >= 585) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPRESOURCE"));
            Vector<PSAppResource> psAppResourceList = psSysModelCache.getModelList("PSAPPRESOURCE", psSysModelLog);
            if (psAppResourceList == null) {
                psAppResourceList = new Vector<PSAppResource>();
                callResult = this.getAllPSAppResources2(strPSSysAppId, psAppResourceList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u9884\u7f6e\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPRESOURCE", psSysModelLog, psAppResourceList);
            }
            psSysAppStorage.psAppResourceList.addAll(psAppResourceList);
        }
        if ((psAppFuncList = psSysModelCache.getModelList("PSAPPFUNC", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPFUNC")))) == null) {
            psAppFuncList = new Vector<PSAppFunc>();
            callResult = this.getAllPSAppFuncs2(strPSSysAppId, psAppFuncList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u529f\u80fd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPFUNC", psSysModelLog, psAppFuncList);
        }
        psSysAppStorage.psAppFuncList.addAll(psAppFuncList);
        if (this.getModelInstVer() >= 629) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPUTIL"));
            Vector<PSAppUtil> psAppUtilList = psSysModelCache.getModelList("PSAPPUTIL", psSysModelLog);
            if (psAppUtilList == null) {
                psAppUtilList = new Vector<PSAppUtil>();
                callResult = this.getAllPSAppUtils2(strPSSysAppId, psAppUtilList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u7ec4\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPUTIL", psSysModelLog, psAppUtilList);
            }
            psSysAppStorage.psAppUtilList.addAll(psAppUtilList);
        }
        if (this.getModelInstVer() >= 630) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPPORTLET"));
            Vector<PSAppPortlet> psAppPortletList = psSysModelCache.getModelList("PSAPPPORTLET", psSysModelLog);
            if (psAppPortletList == null) {
                psAppPortletList = new Vector<PSAppPortlet>();
                callResult = this.getAllPSAppPortlets2(strPSSysAppId, psAppPortletList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPPORTLET", psSysModelLog, psAppPortletList);
            }
            psSysAppStorage.psAppPortletList.addAll(psAppPortletList);
        }
        if (this.getModelInstVer() >= 803) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPPFPLUGIN"));
            Vector<PSAppPFPlugin> psAppPFPluginList = psSysModelCache.getModelList("PSAPPPFPLUGIN", psSysModelLog);
            if (psAppPFPluginList == null) {
                psAppPFPluginList = new Vector<PSAppPFPlugin>();
                callResult = this.getAllPSAppPFPlugins2(strPSSysAppId, psAppPFPluginList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPPFPLUGIN", psSysModelLog, psAppPFPluginList);
            }
            psSysAppStorage.psAppPFPluginList.addAll(psAppPFPluginList);
        }
        if ((psAppWFList = psSysModelCache.getModelList("PSAPPWF", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPWF")))) == null) {
            psAppWFList = new Vector<PSAppWF>();
            callResult = this.getAllPSAppWFs2(strPSSysAppId, psAppWFList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u5de5\u4f5c\u6d41\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPWF", psSysModelLog, psAppWFList);
        }
        psSysAppStorage.psAppWFList.addAll(psAppWFList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPWFVER"));
        Vector<PSAppWFVer> psAppWFVerList = psSysModelCache.getModelList("PSAPPWFVER", psSysModelLog);
        if (psAppWFVerList == null) {
            psAppWFVerList = new Vector<PSAppWFVer>();
            callResult = this.getAllPSAppWFVers2(strPSSysAppId, psAppWFVerList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPWFVER", psSysModelLog, psAppWFVerList);
        }
        psSysAppStorage.psAppWFVerList.addAll(psAppWFVerList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPEDITORTEMPL"));
        Vector<PSAppEditorTempl> psAppEditorTemplList = psSysModelCache.getModelList("PSAPPEDITORTEMPL", psSysModelLog);
        if (psAppEditorTemplList == null) {
            psAppEditorTemplList = new Vector<PSAppEditorTempl>();
            callResult = this.getAllPSAppEditorTempls2(strPSSysAppId, psAppEditorTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPEDITORTEMPL", psSysModelLog, psAppEditorTemplList);
        }
        psSysAppStorage.psAppEditorTemplList.addAll(psAppEditorTemplList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPMENU"));
        Vector<PSAppMenu> psAppMenuList = psSysModelCache.getModelList("PSAPPMENU", psSysModelLog);
        if (psAppMenuList == null) {
            psAppMenuList = new Vector<PSAppMenu>();
            callResult = this.getAllPSAppMenus2(strPSSysAppId, psAppMenuList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPMENU", psSysModelLog, psAppMenuList);
        }
        psSysAppStorage.psAppMenuList.addAll(psAppMenuList);
        Iterator iterator = psAppMenuList.iterator();
        while (iterator.hasNext()) {
            PSAppMenu psAppMenu;
            psSysAppStorage.getPSAppMenuStorage((String)psAppMenu.getPSAPPMENUID()).psAppMenu = psAppMenu = (PSAppMenu)((Object)iterator.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSAppMenuItem> psAppMenuItemList = psSysModelCache.getModelList("PSAPPMENUITEM", psSysModelLog);
            if (psAppMenuItemList == null) {
                psAppMenuItemList = new Vector<PSAppMenuItem>();
                callResult = this.getPSAppMenuItemsBySysApp(psSystemApplication.getPSSYSAPPID(), psAppMenuItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPMENUITEM", psSysModelLog, psAppMenuItemList);
            }
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                psSysAppStorage.getPSAppMenuStorage((String)psAppMenuItem.getPSAPPMENUID()).psAppMenuItemList.add(psAppMenuItem);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSAppMenuLogic> psAppMenuLogicList = psSysModelCache.getModelList("PSAPPMENULOGIC", psSysModelLog);
            if (psAppMenuLogicList == null) {
                psAppMenuLogicList = new Vector<PSAppMenuLogic>();
                callResult = this.getPSAppMenuLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psAppMenuLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u90e8\u4ef6\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPMENULOGIC", psSysModelLog, psAppMenuLogicList);
            }
            for (PSAppMenuLogic psAppMenuLogic : psAppMenuLogicList) {
                psSysAppStorage.getPSAppMenuStorage((String)psAppMenuLogic.getPSAPPMENUID()).psAppMenuLogicList.add(psAppMenuLogic);
            }
        }
        if ((psAppUserModeList = psSysModelCache.getModelList("PSAPPUSERMODE", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPUSERMODE")))) == null) {
            psAppUserModeList = new Vector<PSAppUserMode>();
            callResult = this.getAllPSAppUserModes2(strPSSysAppId, psAppUserModeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u7528\u6237\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPUSERMODE", psSysModelLog, psAppUserModeList);
        }
        psSysAppStorage.psAppUserModeList.addAll(psAppUserModeList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPUITHEME"));
        Vector<PSAppUITheme> psAppUIThemeList = psSysModelCache.getModelList("PSAPPUITHEME", psSysModelLog);
        if (psAppUIThemeList == null) {
            psAppUIThemeList = new Vector<PSAppUITheme>();
            callResult = this.getAllPSAppUIThemes2(strPSSysAppId, psAppUIThemeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u754c\u9762\u4e3b\u9898\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPUITHEME", psSysModelLog, psAppUIThemeList);
        }
        psSysAppStorage.psAppUIThemeList.addAll(psAppUIThemeList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPLOCALDE"));
        Vector<PSAppLocalDE> psAppLocalDEList = psSysModelCache.getModelList("PSAPPLOCALDE", psSysModelLog);
        if (psAppLocalDEList == null) {
            psAppLocalDEList = new Vector<PSAppLocalDE>();
            callResult = this.getAllPSAppLocalDEs2(strPSSysAppId, psAppLocalDEList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u672c\u5730\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPLOCALDE", psSysModelLog, psAppLocalDEList);
        }
        psSysAppStorage.psAppLocalDEList.addAll(psAppLocalDEList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPDERS"));
        Vector<PSAppDERS> psAppDERSList = psSysModelCache.getModelList("PSAPPDERS", psSysModelLog);
        if (psAppDERSList == null) {
            psAppDERSList = new Vector<PSAppDERS>();
            callResult = this.getAllPSAppDERSs2(strPSSysAppId, psAppDERSList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPDERS", psSysModelLog, psAppDERSList);
        }
        psSysAppStorage.psAppDERSList.addAll(psAppDERSList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPVIEWCODE"));
        Vector<PSAppViewCode> psAppViewCodeList = psSysModelCache.getModelList("PSAPPVIEWCODE", psSysModelLog);
        if (psAppViewCodeList == null) {
            psAppViewCodeList = new Vector<PSAppViewCode>();
            callResult = this.getAllPSAppViewCodes2(strPSSysAppId, psAppViewCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSAPPVIEWCODE", psSysModelLog, psAppViewCodeList);
        }
        psSysAppStorage.psAppViewCodeList.addAll(psAppViewCodeList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSMOBAPPSTARTPAGE"));
        Vector<PSMobAppStartPage> psMobAppStartPageList = psSysModelCache.getModelList("PSMOBAPPSTARTPAGE", psSysModelLog);
        if (psMobAppStartPageList == null) {
            psMobAppStartPageList = new Vector<PSMobAppStartPage>();
            callResult = this.getAllPSMobAppStartPages2(strPSSysAppId, psMobAppStartPageList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u79fb\u52a8\u5e94\u7528\u8d77\u59cb\u9875\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSMOBAPPSTARTPAGE", psSysModelLog, psMobAppStartPageList);
        }
        psSysAppStorage.psMobAppStartPageList.addAll(psMobAppStartPageList);
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSMOBAPPPACK"));
        Vector<PSMobAppPack> psMobAppPackList = psSysModelCache.getModelList("PSMOBAPPPACK", psSysModelLog);
        if (psMobAppPackList == null) {
            psMobAppPackList = new Vector<PSMobAppPack>();
            callResult = this.getAllPSMobAppPacks2(strPSSysAppId, psMobAppPackList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u79fb\u52a8\u5e94\u7528\u6253\u5305\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSMOBAPPPACK", psSysModelLog, psMobAppPackList);
        }
        psSysAppStorage.psMobAppPackList.addAll(psMobAppPackList);
        Iterator iterator2 = psMobAppPackList.iterator();
        while (iterator2.hasNext()) {
            PSMobAppPack psMobAppPack;
            psSysAppStorage.getPSMobAppPackStorage((String)psMobAppPack.getPSMOBAPPPACKID()).psMobAppPack = psMobAppPack = (PSMobAppPack)((Object)iterator2.next());
        }
        Vector<PSMobAppPackTD> psMobAppPackTDList = psSysModelCache.getModelList("PSMOBAPPPACKTD", psSysModelLog);
        if (psMobAppPackTDList == null) {
            psMobAppPackTDList = new Vector<PSMobAppPackTD>();
            CallResult callResult14 = this.getPSMobAppPackTDsBySysApp(psSystemApplication.getPSSYSAPPID(), psMobAppPackTDList);
            if (callResult14.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u79fb\u52a8\u5e94\u7528\u6253\u5305\u6d4b\u8bd5\u8bbe\u5907\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult14.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSMOBAPPPACKTD", psSysModelLog, psMobAppPackTDList);
        }
        for (PSMobAppPackTD pSMobAppPackTD : psMobAppPackTDList) {
            psSysAppStorage.getPSMobAppPackStorage((String)pSMobAppPackTD.getPSMOBAPPPACKID()).psMobAppPackTDList.add(pSMobAppPackTD);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEVIEWBASE"));
        Vector<PSDEViewBase> psDEViewBaseList = psSysModelCache.getModelList("PSDEVIEWBASE", psSysModelLog);
        if (psDEViewBaseList == null) {
            psDEViewBaseList = new Vector<PSDEViewBase>();
            callResult = this.getAllPSDEViewBasesBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewBaseList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEVIEWBASE", psSysModelLog, psDEViewBaseList);
        }
        psSysAppStorage.psDEViewBaseList.addAll(psDEViewBaseList);
        for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
            psSysAppStorage.psDEViewBaseMap.put(psDEViewBase.getPSDEVIEWBASEID(), psDEViewBase);
            psSysAppStorage.getPSDEViewBaseStorage((String)psDEViewBase.getPSDEVIEWBASEID()).psDEViewBase = psDEViewBase;
        }
        Vector<PSDEViewView> psDEViewViewList = psSysModelCache.getModelList("PSDEVIEWRV", psSysModelLog);
        if (psDEViewViewList == null) {
            psDEViewViewList = new Vector<PSDEViewView>();
            callResult = this.getPSDEViewViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEVIEWRV", psSysModelLog, psDEViewViewList);
        }
        for (PSDEViewView psDEViewView : psDEViewViewList) {
            psSysAppStorage.getPSDEViewBaseStorage((String)psDEViewView.getMAJORPSDEVIEWID()).psDEViewViewList.add(psDEViewView);
        }
        psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEVIEWCTRL"));
        if (psSysModelLog2 == null) {
            psSysModelLog2 = psSysModelLog;
        }
        if ((psDEViewCtrlList = psSysModelCache.getModelList("PSDEVIEWCTRL", psSysModelLog2)) == null) {
            psDEViewCtrlList = new Vector<PSDEViewCtrl>();
            CallResult callResult15 = this.getPSDEViewCtrlsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewCtrlList);
            if (callResult15.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult15.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEVIEWCTRL", psSysModelLog2, psDEViewCtrlList);
        }
        for (PSDEViewCtrl pSDEViewCtrl : psDEViewCtrlList) {
            psSysAppStorage.getPSDEViewBaseStorage((String)pSDEViewCtrl.getPSDEVIEWBASEID()).psDEViewCtrlList.add(pSDEViewCtrl);
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEViewLogic> psDEViewLogicList = psSysModelCache.getModelList("PSDEVIEWLOGIC", psSysModelLog);
            if (psDEViewLogicList == null) {
                psDEViewLogicList = new Vector<PSDEViewLogic>();
                callResult = this.getPSDEViewLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEVIEWLOGIC", psSysModelLog, psDEViewLogicList);
            }
            for (PSDEViewLogic psDEViewLogic : psDEViewLogicList) {
                psSysAppStorage.getPSDEViewBaseStorage((String)psDEViewLogic.getPSDEVIEWBASEID()).psDEViewLogicList.add(psDEViewLogic);
            }
        }
        if (this.getModelInstVer() >= 605 && nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEViewEngine> psDEViewEngineList = psSysModelCache.getModelList("PSDEVIEWENGINE", psSysModelLog);
            if (psDEViewEngineList == null) {
                psDEViewEngineList = new Vector<PSDEViewEngine>();
                callResult = this.getPSDEViewEnginesBySystem(psSystemApplication.getPSSYSTEMID(), psDEViewEngineList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEVIEWENGINE", psSysModelLog, psDEViewEngineList);
            }
            for (PSDEViewEngine psDEViewEngine : psDEViewEngineList) {
                psSysAppStorage.getPSDEViewBaseStorage((String)psDEViewEngine.getPSDEVIEWBASEID()).psDEViewEngineList.add(psDEViewEngine);
            }
        }
        if ((psDynaDEViewTemplList = psSysModelCache.getModelList("PSDYNADEVIEWTEMPL", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDYNADEVIEWTEMPL")))) == null) {
            psDynaDEViewTemplList = new Vector<PSDynaDEViewTempl>();
            callResult = this.getAllPSDynaDEViewTemplsBySystem(psSystemApplication.getPSSYSTEMID(), psDynaDEViewTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6240\u6709\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDYNADEVIEWTEMPL", psSysModelLog, psDynaDEViewTemplList);
        }
        psSysAppStorage.psDynaDEViewTemplList.addAll(psDynaDEViewTemplList);
        for (PSDynaDEViewTempl psDynaDEViewTempl : psDynaDEViewTemplList) {
            psSysAppStorage.psDynaDEViewTemplMap.put(psDynaDEViewTempl.getPSDYNADEVIEWTEMPLID(), psDynaDEViewTempl);
            psSysAppStorage.getPSDynaDEViewTemplStorage((String)psDynaDEViewTempl.getPSDYNADEVIEWTEMPLID()).psDynaDEViewTempl = psDynaDEViewTempl;
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDETOOLBAR"));
        Vector<PSDEToolbar> psDEToolbarList = psSysModelCache.getModelList("PSDETOOLBAR", psSysModelLog);
        if (psDEToolbarList == null) {
            psDEToolbarList = new Vector<PSDEToolbar>();
            callResult = this.getPSDEToolbarsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETOOLBAR", psSysModelLog, psDEToolbarList);
        }
        Iterator iterator3 = psDEToolbarList.iterator();
        while (iterator3.hasNext()) {
            PSDEToolbar psDEToolbar;
            psSysAppStorage.getPSDEToolbarStorage((String)psDEToolbar.getPSDETOOLBARID()).psDEToolbar = psDEToolbar = (PSDEToolbar)((Object)iterator3.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEToolbarItem> psDEToolbarItemList = psSysModelCache.getModelList("PSDETBITEM", psSysModelLog);
            if (psDEToolbarItemList == null) {
                psDEToolbarItemList = new Vector<PSDEToolbarItem>();
                callResult = this.getPSDEToolbarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u5de5\u5177\u680f\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDETBITEM", psSysModelLog, psDEToolbarItemList);
            }
            for (PSDEToolbarItem psDEToolbarItem : psDEToolbarItemList) {
                psSysAppStorage.getPSDEToolbarStorage((String)psDEToolbarItem.getPSDETOOLBARID()).psDEToolbarItemList.add(psDEToolbarItem);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEToolbarLogic> psDEToolbarLogicList = psSysModelCache.getModelList("PSDETOOLBARLOGIC", psSysModelLog);
            if (psDEToolbarLogicList == null) {
                psDEToolbarLogicList = new Vector<PSDEToolbarLogic>();
                callResult = this.getPSDEToolbarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEToolbarLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5de5\u5177\u680f\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDETOOLBARLOGIC", psSysModelLog, psDEToolbarLogicList);
            }
            for (PSDEToolbarLogic psDEToolbarLogic : psDEToolbarLogicList) {
                psSysAppStorage.getPSDEToolbarStorage((String)psDEToolbarLogic.getPSDETOOLBARID()).psDEToolbarLogicList.add(psDEToolbarLogic);
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHBAR"));
            Vector<PSSysSearchBar> psSysSearchBarList = psSysModelCache.getModelList("PSSYSSEARCHBAR", psSysModelLog);
            if (psSysSearchBarList == null) {
                psSysSearchBarList = new Vector<PSSysSearchBar>();
                callResult = this.getAllPSSysSearchBars2(psSystemApplication.getPSSYSTEMID(), psSysSearchBarList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u641c\u7d22\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEARCHBAR", psSysModelLog, psSysSearchBarList);
            }
            psSysAppStorage.psSysSearchBarList.addAll(psSysSearchBarList);
            Iterator iterator4 = psSysSearchBarList.iterator();
            while (iterator4.hasNext()) {
                PSSysSearchBar psSysSearchBar;
                psSysAppStorage.getPSSysSearchBarStorage((String)psSysSearchBar.getPSSYSSEARCHBARID()).psSysSearchBar = psSysSearchBar = (PSSysSearchBar)((Object)iterator4.next());
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSSEARCHBARITEM"));
            Vector<PSSysSearchBarItem> psSysSearchBarItemList = psSysModelCache.getModelList("PSSYSSEARCHBARITEM", psSysModelLog, psSysModelLog2);
            if (psSysSearchBarItemList == null) {
                psSysSearchBarItemList = new Vector<PSSysSearchBarItem>();
                CallResult callResult16 = this.getPSSysSearchBarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysSearchBarItemList);
                if (callResult16.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u641c\u7d22\u680f\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult16.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSSEARCHBARITEM", psSysModelLog, psSysModelLog2, psSysSearchBarItemList);
            }
            for (PSSysSearchBarItem pSSysSearchBarItem : psSysSearchBarItemList) {
                psSysAppStorage.getPSSysSearchBarStorage((String)pSSysSearchBarItem.getPSSYSSEARCHBARID()).psSysSearchBarItemList.add(pSSysSearchBarItem);
            }
            if (this.getModelInstVer() >= 747) {
                Vector<PSSysSearchBarLogic> psSysSearchBarLogicList = psSysModelCache.getModelList("PSSYSSEARCHBARLOGIC", psSysModelLog);
                if (psSysSearchBarLogicList == null) {
                    psSysSearchBarLogicList = new Vector<PSSysSearchBarLogic>();
                    callResult = this.getPSSysSearchBarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysSearchBarLogicList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u641c\u7d22\u680f\u90e8\u4ef6\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSSEARCHBARLOGIC", psSysModelLog, psSysSearchBarLogicList);
                }
                for (PSSysSearchBarLogic psSysSearchBarLogic : psSysSearchBarLogicList) {
                    psSysAppStorage.getPSSysSearchBarStorage((String)psSysSearchBarLogic.getPSSYSSEARCHBARID()).psSysSearchBarLogicList.add(psSysSearchBarLogic);
                }
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSTITLEBAR"));
            Vector<PSSysTitleBar> psSysTitleBarList = psSysModelCache.getModelList("PSSYSTITLEBAR", psSysModelLog);
            if (psSysTitleBarList == null) {
                psSysTitleBarList = new Vector<PSSysTitleBar>();
                callResult = this.getAllPSSysTitleBars2(psSystemApplication.getPSSYSTEMID(), psSysTitleBarList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6807\u9898\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSTITLEBAR", psSysModelLog, psSysTitleBarList);
            }
            psSysAppStorage.psSysTitleBarList.addAll(psSysTitleBarList);
            Iterator iterator5 = psSysTitleBarList.iterator();
            while (iterator5.hasNext()) {
                PSSysTitleBar psSysTitleBar;
                psSysAppStorage.getPSSysTitleBarStorage((String)psSysTitleBar.getPSSYSTITLEBARID()).psSysTitleBar = psSysTitleBar = (PSSysTitleBar)((Object)iterator5.next());
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSAPPTITLEBAR"));
            Vector<PSAppTitleBar> psAppTitleBarList = psSysModelCache.getModelList("PSAPPTITLEBAR", psSysModelLog);
            if (psAppTitleBarList == null) {
                psAppTitleBarList = new Vector<PSAppTitleBar>();
                callResult = this.getAllPSAppTitleBars2(psSystemApplication.getPSSYSTEMID(), psAppTitleBarList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u7cfb\u7edf\u6240\u6709\u6807\u9898\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSAPPTITLEBAR", psSysModelLog, psAppTitleBarList);
            }
            psSysAppStorage.psAppTitleBarList.addAll(psAppTitleBarList);
            Iterator iterator6 = psAppTitleBarList.iterator();
            while (iterator6.hasNext()) {
                PSAppTitleBar psAppTitleBar;
                psSysAppStorage.getPSAppTitleBarStorage((String)psAppTitleBar.getPSAPPTITLEBARID()).psAppTitleBar = psAppTitleBar = (PSAppTitleBar)((Object)iterator6.next());
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSDASHBOARD"));
            Vector<PSSysDashboard> psSysDashboardList = psSysModelCache.getModelList("PSSYSDASHBOARD", psSysModelLog);
            if (psSysDashboardList == null) {
                psSysDashboardList = new Vector<PSSysDashboard>();
                callResult = this.getAllPSSysDashboards2(psSystemApplication.getPSSYSTEMID(), psSysDashboardList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u770b\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSDASHBOARD", psSysModelLog, psSysDashboardList);
            }
            psSysAppStorage.psSysDashboardList.addAll(psSysDashboardList);
            Iterator iterator7 = psSysDashboardList.iterator();
            while (iterator7.hasNext()) {
                PSSysDashboard psSysDashboard;
                psSysAppStorage.getPSSysDashboardStorage((String)psSysDashboard.getPSSYSDASHBOARDID()).psSysDashboard = psSysDashboard = (PSSysDashboard)((Object)iterator7.next());
            }
            Vector<PSSysDashboardPart> psSysDashboardPartList = psSysModelCache.getModelList("PSSYSDBPART", psSysModelLog);
            if (psSysDashboardPartList == null) {
                psSysDashboardPartList = new Vector<PSSysDashboardPart>();
                callResult = this.getPSSysDashboardPartsBySystem(psSystemApplication.getPSSYSTEMID(), psSysDashboardPartList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u6570\u636e\u770b\u677f\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSDBPART", psSysModelLog, psSysDashboardPartList);
            }
            for (PSSysDashboardPart psSysDashboardPart : psSysDashboardPartList) {
                psSysAppStorage.getPSSysDashboardStorage((String)psSysDashboardPart.getPSSYSDASHBOARDID()).psSysDashboardPartList.add(psSysDashboardPart);
            }
            if (this.getModelInstVer() >= 747) {
                Vector<PSSysDashboardLogic> psSysDashboardLogicList = psSysModelCache.getModelList("PSSYSDASHBOARDLOGIC", psSysModelLog);
                if (psSysDashboardLogicList == null) {
                    psSysDashboardLogicList = new Vector<PSSysDashboardLogic>();
                    callResult = this.getPSSysDashboardLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysDashboardLogicList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u770b\u677f\u90e8\u4ef6\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSDASHBOARDLOGIC", psSysModelLog, psSysDashboardLogicList);
                }
                for (PSSysDashboardLogic psSysDashboardLogic : psSysDashboardLogicList) {
                    psSysAppStorage.getPSSysDashboardStorage((String)psSysDashboardLogic.getPSSYSDASHBOARDID()).psSysDashboardLogicList.add(psSysDashboardLogic);
                }
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCALENDAR"));
            Vector<PSSysCalendar> psSysCalendarList = psSysModelCache.getModelList("PSSYSCALENDAR", psSysModelLog);
            if (psSysCalendarList == null) {
                psSysCalendarList = new Vector<PSSysCalendar>();
                callResult = this.getAllPSSysCalendars2(psSystemApplication.getPSSYSTEMID(), psSysCalendarList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u65e5\u5386\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCALENDAR", psSysModelLog, psSysCalendarList);
            }
            psSysAppStorage.psSysCalendarList.addAll(psSysCalendarList);
            Iterator iterator8 = psSysCalendarList.iterator();
            while (iterator8.hasNext()) {
                PSSysCalendar psSysCalendar;
                psSysAppStorage.getPSSysCalendarStorage((String)psSysCalendar.getPSSYSCALENDARID()).psSysCalendar = psSysCalendar = (PSSysCalendar)((Object)iterator8.next());
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCALENDARITEM"));
            Vector<PSSysCalendarItem> psSysCalendarItemList = psSysModelCache.getModelList("PSSYSCALENDARITEM", psSysModelLog, psSysModelLog2);
            if (psSysCalendarItemList == null) {
                psSysCalendarItemList = new Vector<PSSysCalendarItem>();
                CallResult callResult17 = this.getPSSysCalendarItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarItemList);
                if (callResult17.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u65e5\u5386\u90e8\u4ef6\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult17.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCALENDARITEM", psSysModelLog, psSysModelLog2, psSysCalendarItemList);
            }
            for (PSSysCalendarItem pSSysCalendarItem : psSysCalendarItemList) {
                psSysAppStorage.getPSSysCalendarStorage((String)pSSysCalendarItem.getPSSYSCALENDARID()).psSysCalendarItemList.add(pSSysCalendarItem);
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSCALENDARITEMRV"));
            Vector<PSSysCalendarItemRV> psSysCalendarItemRVList = psSysModelCache.getModelList("PSSYSCALENDARITEMRV", psSysModelLog, psSysModelLog2);
            if (psSysCalendarItemRVList == null) {
                psSysCalendarItemRVList = new Vector<PSSysCalendarItemRV>();
                CallResult callResult18 = this.getPSSysCalendarItemRVsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarItemRVList);
                if (callResult18.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u65e5\u5386\u90e8\u4ef6\u9879\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult18.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSCALENDARITEMRV", psSysModelLog, psSysModelLog2, psSysCalendarItemRVList);
            }
            for (PSSysCalendarItemRV pSSysCalendarItemRV : psSysCalendarItemRVList) {
                psSysAppStorage.getPSSysCalendarStorage((String)pSSysCalendarItemRV.getPSSYSCALENDARID()).psSysCalendarItemRVList.add(pSSysCalendarItemRV);
            }
            if (this.getModelInstVer() >= 747) {
                Vector<PSSysCalendarLogic> psSysCalendarLogicList = psSysModelCache.getModelList("PSSYSCALENDARLOGIC", psSysModelLog);
                if (psSysCalendarLogicList == null) {
                    psSysCalendarLogicList = new Vector<PSSysCalendarLogic>();
                    callResult = this.getPSSysCalendarLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysCalendarLogicList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u65e5\u5386\u90e8\u4ef6\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSCALENDARLOGIC", psSysModelLog, psSysCalendarLogicList);
                }
                for (PSSysCalendarLogic psSysCalendarLogic : psSysCalendarLogicList) {
                    psSysAppStorage.getPSSysCalendarStorage((String)psSysCalendarLogic.getPSSYSCALENDARID()).psSysCalendarLogicList.add(psSysCalendarLogic);
                }
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW && this.getModelInstVer() >= 614) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSMAPVIEW"));
            Vector<PSSysMapView> psSysMapViewList = psSysModelCache.getModelList("PSSYSMAPVIEW", psSysModelLog);
            if (psSysMapViewList == null) {
                psSysMapViewList = new Vector<PSSysMapView>();
                callResult = this.getAllPSSysMapViews2(psSystemApplication.getPSSYSTEMID(), psSysMapViewList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5730\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSMAPVIEW", psSysModelLog, psSysMapViewList);
            }
            psSysAppStorage.psSysMapViewList.addAll(psSysMapViewList);
            Iterator iterator9 = psSysMapViewList.iterator();
            while (iterator9.hasNext()) {
                PSSysMapView psSysMapView;
                psSysAppStorage.getPSSysMapViewStorage((String)psSysMapView.getPSSYSMAPVIEWID()).psSysMapView = psSysMapView = (PSSysMapView)((Object)iterator9.next());
            }
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSMAPITEM"));
            Vector<PSSysMapItem> psSysMapItemList = psSysModelCache.getModelList("PSSYSMAPITEM", psSysModelLog, psSysModelLog2);
            if (psSysMapItemList == null) {
                psSysMapItemList = new Vector<PSSysMapItem>();
                CallResult callResult19 = this.getPSSysMapItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysMapItemList);
                if (callResult19.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5730\u56fe\u90e8\u4ef6\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult19.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSMAPITEM", psSysModelLog, psSysModelLog2, psSysMapItemList);
            }
            for (PSSysMapItem pSSysMapItem : psSysMapItemList) {
                psSysAppStorage.getPSSysMapViewStorage((String)pSSysMapItem.getPSSYSMAPVIEWID()).psSysMapItemList.add(pSSysMapItem);
            }
            if (this.getModelInstVer() >= 747) {
                Vector<PSSysMapLogic> psSysMapLogicList = psSysModelCache.getModelList("PSSYSMAPLOGIC", psSysModelLog);
                if (psSysMapLogicList == null) {
                    psSysMapLogicList = new Vector<PSSysMapLogic>();
                    callResult = this.getPSSysMapLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysMapLogicList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5730\u56fe\u90e8\u4ef6\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSSYSMAPLOGIC", psSysModelLog, psSysMapLogicList);
                }
                for (PSSysMapLogic psSysMapLogic : psSysMapLogicList) {
                    psSysAppStorage.getPSSysMapViewStorage((String)psSysMapLogic.getPSSYSMAPVIEWID()).psSysMapLogicList.add(psSysMapLogic);
                }
            }
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW && this.getModelInstVer() >= 397) {
            psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSVIEWPANEL"));
            Vector<PSSysPanel> psSysPanelList = psSysModelCache.getModelList("PSSYSVIEWPANEL", psSysModelLog);
            if (psSysPanelList == null) {
                psSysPanelList = new Vector<PSSysPanel>();
                callResult = this.getAllPSSysPanels2(psSystemApplication.getPSSYSTEMID(), psSysPanelList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSVIEWPANEL", psSysModelLog, psSysPanelList);
            }
            psSysAppStorage.psSysPanelList.addAll(psSysPanelList);
            Iterator iterator10 = psSysPanelList.iterator();
            while (iterator10.hasNext()) {
                PSSysPanel psSysPanel;
                psSysAppStorage.getPSSysPanelStorage((String)psSysPanel.getPSSYSVIEWPANELID()).psSysPanel = psSysPanel = (PSSysPanel)((Object)iterator10.next());
            }
            Vector<PSSysPanelItem> psSysPanelItemList = psSysModelCache.getModelList("PSSYSVIEWPANELITEM", psSysModelLog);
            if (psSysPanelItemList == null) {
                psSysPanelItemList = new Vector<PSSysPanelItem>();
                callResult = this.getPSSysPanelItemsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u90e8\u4ef6\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSVIEWPANELITEM", psSysModelLog, psSysPanelItemList);
            }
            for (PSSysPanelItem psSysPanelItem : psSysPanelItemList) {
                psSysAppStorage.getPSSysPanelStorage((String)psSysPanelItem.getPSSYSVIEWPANELID()).psSysPanelItemList.add(psSysPanelItem);
            }
            Vector<PSSysPanelModel> psSysPanelModelList = psSysModelCache.getModelList("PSSYSVIEWPANELMODEL", psSysModelLog);
            if (psSysPanelModelList == null) {
                psSysPanelModelList = new Vector<PSSysPanelModel>();
                callResult = this.getPSSysPanelModelsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelModelList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSVIEWPANELMODEL", psSysModelLog, psSysPanelModelList);
            }
            for (PSSysPanelModel psSysPanelModel : psSysPanelModelList) {
                psSysAppStorage.getPSSysPanelStorage((String)psSysPanelModel.getPSSYSVIEWPANELID()).psSysPanelModelList.add(psSysPanelModel);
            }
            Vector<PSPanelItemLogic> psPanelItemLogicList = psSysModelCache.getModelList("PSPANELITEMLOGIC", psSysModelLog);
            if (psPanelItemLogicList == null) {
                psPanelItemLogicList = new Vector<PSPanelItemLogic>();
                callResult = this.getPSPanelItemLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelItemLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u9879\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELITEMLOGIC", psSysModelLog, psPanelItemLogicList);
            }
            for (PSPanelItemLogic psPanelItemLogic : psPanelItemLogicList) {
                psSysAppStorage.getPSSysPanelStorage((String)psPanelItemLogic.getPSSYSVIEWPANELID()).psPanelItemLogicList.add(psPanelItemLogic);
            }
            Vector<PSSysPanelLogic> psSysPanelLogicList = psSysModelCache.getModelList("PSSYSVIEWPANELLOGIC", psSysModelLog);
            if (psSysPanelLogicList == null) {
                psSysPanelLogicList = new Vector<PSSysPanelLogic>();
                callResult = this.getPSSysPanelLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psSysPanelLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSSYSVIEWPANELLOGIC", psSysModelLog, psSysPanelLogicList);
            }
            for (PSSysPanelLogic psSysPanelLogic : psSysPanelLogicList) {
                psSysAppStorage.getPSSysPanelStorage((String)psSysPanelLogic.getPSSYSVIEWPANELID()).psSysPanelLogicList.add(psSysPanelLogic);
                psSysAppStorage.getPSPanelLogicStorage((String)psSysPanelLogic.getPSSYSVIEWPANELLOGICID()).psSysPanelLogic = psSysPanelLogic;
            }
            Vector<PSPanelLogicParam> psPanelLogicParamList = psSysModelCache.getModelList("PSPANELLOGICPARAM", psSysModelLog);
            if (psPanelLogicParamList == null) {
                psPanelLogicParamList = new Vector<PSPanelLogicParam>();
                callResult = this.getPSPanelLogicParamsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicParamList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELLOGICPARAM", psSysModelLog, psPanelLogicParamList);
            }
            for (PSPanelLogicParam psPanelLogicParam : psPanelLogicParamList) {
                psSysAppStorage.getPSPanelLogicStorage((String)psPanelLogicParam.getPSSYSVIEWPANELLOGICID()).psPanelLogicParamList.add(psPanelLogicParam);
            }
            Vector<PSPanelLogicNode> psPanelLogicNodeList = psSysModelCache.getModelList("PSPANELLOGICNODE", psSysModelLog);
            if (psPanelLogicNodeList == null) {
                psPanelLogicNodeList = new Vector<PSPanelLogicNode>();
                callResult = this.getPSPanelLogicNodesBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicNodeList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELLOGICNODE", psSysModelLog, psPanelLogicNodeList);
            }
            for (PSPanelLogicNode psPanelLogicNode : psPanelLogicNodeList) {
                psSysAppStorage.getPSPanelLogicStorage((String)psPanelLogicNode.getPSSYSVIEWPANELLOGICID()).psPanelLogicNodeList.add(psPanelLogicNode);
            }
            Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList = psSysModelCache.getModelList("PSPANELLNPARAM", psSysModelLog);
            if (psPanelLogicNodeParamList == null) {
                psPanelLogicNodeParamList = new Vector<PSPanelLogicNodeParam>();
                callResult = this.getPSPanelLogicNodeParamsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicNodeParamList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u8282\u70b9\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELLNPARAM", psSysModelLog, psPanelLogicNodeParamList);
            }
            for (PSPanelLogicNodeParam psPanelLogicNodeParam : psPanelLogicNodeParamList) {
                psSysAppStorage.getPSPanelLogicStorage((String)psPanelLogicNodeParam.getPSSYSVIEWPANELLOGICID()).psPanelLogicNodeParamList.add(psPanelLogicNodeParam);
            }
            Vector<PSPanelLogicLink> psPanelLogicLinkList = psSysModelCache.getModelList("PSPANELLOGICLINK", psSysModelLog);
            if (psPanelLogicLinkList == null) {
                psPanelLogicLinkList = new Vector<PSPanelLogicLink>();
                callResult = this.getPSPanelLogicLinksBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicLinkList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELLOGICLINK", psSysModelLog, psPanelLogicLinkList);
            }
            for (PSPanelLogicLink psPanelLogicLink : psPanelLogicLinkList) {
                psSysAppStorage.getPSPanelLogicStorage((String)psPanelLogicLink.getPSSYSVIEWPANELLOGICID()).psPanelLogicLinkList.add(psPanelLogicLink);
            }
            Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList = psSysModelCache.getModelList("PSPANELLLCOND", psSysModelLog);
            if (psPanelLogicLinkCondList == null) {
                psPanelLogicLinkCondList = new Vector<PSPanelLogicLinkCond>();
                callResult = this.getPSPanelLogicLinkCondsBySystem(psSystemApplication.getPSSYSTEMID(), psPanelLogicLinkCondList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSPANELLLCOND", psSysModelLog, psPanelLogicLinkCondList);
            }
            for (PSPanelLogicLinkCond psPanelLogicLinkCond : psPanelLogicLinkCondList) {
                psSysAppStorage.getPSPanelLogicStorage((String)psPanelLogicLinkCond.getPSSYSVIEWPANELLOGICID()).psPanelLogicLinkCondList.add(psPanelLogicLinkCond);
            }
            if (this.getModelInstVer() >= 609) {
                Vector<PSPanelEngine> psPanelEngineList = psSysModelCache.getModelList("PSPANELENGINE", psSysModelLog);
                if (psPanelEngineList == null) {
                    psPanelEngineList = new Vector<PSPanelEngine>();
                    callResult = this.getPSPanelEnginesBySystem(psSystemApplication.getPSSYSTEMID(), psPanelEngineList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u9762\u677f\u754c\u9762\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psSysModelCache.updateModelList("PSPANELENGINE", psSysModelLog, psPanelEngineList);
                }
                for (PSPanelEngine psPanelEngine : psPanelEngineList) {
                    psSysAppStorage.getPSSysPanelStorage((String)psPanelEngine.getPSSYSVIEWPANELID()).psPanelEngineList.add(psPanelEngine);
                }
            }
        }
        if ((psDEFormList = psSysModelCache.getModelList("PSDEFORM", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEFORM")))) == null) {
            psDEFormList = new Vector<PSDEForm>();
            callResult = this.getPSDEFormsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEFORM", psSysModelLog, psDEFormList);
        }
        Iterator iterator11 = psDEFormList.iterator();
        while (iterator11.hasNext()) {
            PSDEForm psDEForm;
            psSysAppStorage.getPSDEFormStorage((String)psDEForm.getPSDEFORMID()).psDEForm = psDEForm = (PSDEForm)((Object)iterator11.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFormDetail> psDEFormDetailList = psSysModelCache.getModelList("PSDEFORMDETAIL", psSysModelLog);
            if (psDEFormDetailList == null) {
                psDEFormDetailList = new Vector<PSDEFormDetail>();
                callResult = this.getPSDEFormDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormDetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u5355\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFORMDETAIL", psSysModelLog, psDEFormDetailList);
            }
            for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFormDetail.getPSDEFORMID()).psDEFormDetailList.add(psDEFormDetail);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFDLogic> psDEFDLogicList = psSysModelCache.getModelList("PSDEFDLOGIC", psSysModelLog);
            if (psDEFDLogicList == null) {
                psDEFDLogicList = new Vector<PSDEFDLogic>();
                callResult = this.getPSDEFDLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFDLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u903b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFDLOGIC", psSysModelLog, psDEFDLogicList);
            }
            for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFDLogic.getParamStringValue((String)"PSDEFORMID", (String)"")).psDEFDLogicList.add(psDEFDLogic);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFIUpdate> psDEFIUpdateList = psSysModelCache.getModelList("PSDEFIUPDATE", psSysModelLog);
            if (psDEFIUpdateList == null) {
                psDEFIUpdateList = new Vector<PSDEFIUpdate>();
                callResult = this.getPSDEFIUpdatesBySystem(psSystemApplication.getPSSYSTEMID(), psDEFIUpdateList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u66f4\u65b0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFIUPDATE", psSysModelLog, psDEFIUpdateList);
            }
            for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFIUpdate.getPSDEFORMID()).psDEFIUpdateList.add(psDEFIUpdate);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFIUDetail> psDEFIUDetailList = psSysModelCache.getModelList("PSDEFIUDETAIL", psSysModelLog);
            if (psDEFIUDetailList == null) {
                psDEFIUDetailList = new Vector<PSDEFIUDetail>();
                callResult = this.getPSDEFIUDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFIUDetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u66f4\u65b0\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFIUDETAIL", psSysModelLog, psDEFIUDetailList);
            }
            for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFIUDetail.getPSDEFORMID()).psDEFIUDetailList.add(psDEFIUDetail);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFormRF> psDEFormRFList = psSysModelCache.getModelList("PSDEFORMRF", psSysModelLog);
            if (psDEFormRFList == null) {
                psDEFormRFList = new Vector<PSDEFormRF>();
                callResult = this.getPSDEFormRFsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormRFList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u5f15\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFORMRF", psSysModelLog, psDEFormRFList);
            }
            for (PSDEFormRF psDEFormRF : psDEFormRFList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFormRF.getMAJORPSDEFORMID()).psDEFormRFList.add(psDEFormRF);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEFormItemVR> psDEFormItemVRList = psSysModelCache.getModelList("PSDEFIVR", psSysModelLog);
            if (psDEFormItemVRList == null) {
                psDEFormItemVRList = new Vector<PSDEFormItemVR>();
                callResult = this.getPSDEFormItemVRsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormItemVRList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFIVR", psSysModelLog, psDEFormItemVRList);
            }
            for (PSDEFormItemVR psDEFormItemVR : psDEFormItemVRList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFormItemVR.getPSDEFORMID()).psDEFormItemVRList.add(psDEFormItemVR);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEFormLogic> psDEFormLogicList = psSysModelCache.getModelList("PSDEFORMLOGIC", psSysModelLog);
            if (psDEFormLogicList == null) {
                psDEFormLogicList = new Vector<PSDEFormLogic>();
                callResult = this.getPSDEFormLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEFormLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEFORMLOGIC", psSysModelLog, psDEFormLogicList);
            }
            for (PSDEFormLogic psDEFormLogic : psDEFormLogicList) {
                psSysAppStorage.getPSDEFormStorage((String)psDEFormLogic.getPSDEFORMID()).psDEFormLogicList.add(psDEFormLogic);
            }
        }
        if ((psDEGridList = psSysModelCache.getModelList("PSDEGRID", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGRID")))) == null) {
            psDEGridList = new Vector<PSDEGrid>();
            callResult = this.getPSDEGridsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEGRID", psSysModelLog, psDEGridList);
        }
        Iterator iterator12 = psDEGridList.iterator();
        while (iterator12.hasNext()) {
            PSDEGrid psDEGrid;
            psSysAppStorage.getPSDEGridStorage((String)psDEGrid.getPSDEGRIDID()).psDEGrid = psDEGrid = (PSDEGrid)((Object)iterator12.next());
        }
        if (nLoadLevel >= IPSSystem.LOADLEVEL_PREVIEW) {
            psSysModelLog2 = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEGRIDCOL"));
            if (psSysModelLog2 == null) {
                psSysModelLog2 = psSysModelLog;
            }
            if ((psDEGridColumnList = psSysModelCache.getModelList("PSDEGRIDCOL", psSysModelLog2)) == null) {
                psDEGridColumnList = new Vector<PSDEGridColumn>();
                CallResult callResult20 = this.getPSDEGridColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridColumnList);
                if (callResult20.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u8868\u683c\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult20.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGRIDCOL", psSysModelLog2, psDEGridColumnList);
            }
            for (PSDEGridColumn pSDEGridColumn : psDEGridColumnList) {
                psSysAppStorage.getPSDEGridStorage((String)pSDEGridColumn.getPSDEGRIDID()).psDEGridColumnList.add(pSDEGridColumn);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEGEIUpdate> psDEGEIUpdateList = psSysModelCache.getModelList("PSDEGEIUPDATE", psSysModelLog);
            if (psDEGEIUpdateList == null) {
                psDEGEIUpdateList = new Vector<PSDEGEIUpdate>();
                callResult = this.getPSDEGEIUpdatesBySystem(psSystemApplication.getPSSYSTEMID(), psDEGEIUpdateList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGEIUPDATE", psSysModelLog, psDEGEIUpdateList);
            }
            for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
                psSysAppStorage.getPSDEGridStorage((String)psDEGEIUpdate.getPSDEGRIDID()).psDEGEIUpdateList.add(psDEGEIUpdate);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEGEIUDetail> psDEGEIUDetailList = psSysModelCache.getModelList("PSDEGEIUDETAIL", psSysModelLog);
            if (psDEGEIUDetailList == null) {
                psDEGEIUDetailList = new Vector<PSDEGEIUDetail>();
                callResult = this.getPSDEGEIUDetailsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGEIUDetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGEIUDETAIL", psSysModelLog, psDEGEIUDetailList);
            }
            for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
                psSysAppStorage.getPSDEGridStorage((String)psDEGEIUDetail.getPSDEGRIDID()).psDEGEIUDetailList.add(psDEGEIUDetail);
            }
        }
        if (this.getModelInstVer() >= 652 && nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEGridEditItemVR> psDEGridEditItemVRList = psSysModelCache.getModelList("PSDEGEIVR", psSysModelLog);
            if (psDEGridEditItemVRList == null) {
                psDEGridEditItemVRList = new Vector<PSDEGridEditItemVR>();
                callResult = this.getPSDEGridEditItemVRsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridEditItemVRList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGEIVR", psSysModelLog, psDEGridEditItemVRList);
            }
            for (PSDEGridEditItemVR psDEGridEditItemVR : psDEGridEditItemVRList) {
                psSysAppStorage.getPSDEGridStorage((String)psDEGridEditItemVR.getPSDEGRIDID()).psDEGridEditItemVRList.add(psDEGridEditItemVR);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEGridLogic> psDEGridLogicList = psSysModelCache.getModelList("PSDEGRIDLOGIC", psSysModelLog);
            if (psDEGridLogicList == null) {
                psDEGridLogicList = new Vector<PSDEGridLogic>();
                callResult = this.getPSDEGridLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEGridLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEGRIDLOGIC", psSysModelLog, psDEGridLogicList);
            }
            for (PSDEGridLogic psDEGridLogic : psDEGridLogicList) {
                psSysAppStorage.getPSDEGridStorage((String)psDEGridLogic.getPSDEGRIDID()).psDEGridLogicList.add(psDEGridLogic);
            }
        }
        if ((psDETreeViewList = psSysModelCache.getModelList("PSDETREEVIEW", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDETREEVIEW")))) == null) {
            psDETreeViewList = new Vector<PSDETreeView>();
            callResult = this.getPSDETreeViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREEVIEW", psSysModelLog, psDETreeViewList);
        }
        Iterator iterator13 = psDETreeViewList.iterator();
        while (iterator13.hasNext()) {
            PSDETreeView psDETreeView;
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeView.getPSDETREEVIEWID()).psDETreeView = psDETreeView = (PSDETreeView)((Object)iterator13.next());
        }
        Vector<PSDETreeNode> psDETreeNodeList = psSysModelCache.getModelList("PSDETREENODE", psSysModelLog);
        if (psDETreeNodeList == null) {
            psDETreeNodeList = new Vector<PSDETreeNode>();
            callResult = this.getPSDETreeNodesBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREENODE", psSysModelLog, psDETreeNodeList);
        }
        for (PSDETreeNode psDETreeNode : psDETreeNodeList) {
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeNode.getPSDETREEVIEWID()).psDETreeNodeList.add(psDETreeNode);
        }
        Vector<PSDETreeColumn> psDETreeColumnList = psSysModelCache.getModelList("PSDETREECOL", psSysModelLog);
        if (psDETreeColumnList == null) {
            psDETreeColumnList = new Vector<PSDETreeColumn>();
            callResult = this.getPSDETreeColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeColumnList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u8868\u683c\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREECOL", psSysModelLog, psDETreeColumnList);
        }
        for (PSDETreeColumn psDETreeColumn : psDETreeColumnList) {
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeColumn.getPSDETREEVIEWID()).psDETreeColumnList.add(psDETreeColumn);
        }
        Vector<PSDETreeNodeRS> psDETreeNodeRSList = psSysModelCache.getModelList("PSDETREENODERS", psSysModelLog);
        if (psDETreeNodeRSList == null) {
            psDETreeNodeRSList = new Vector<PSDETreeNodeRS>();
            callResult = this.getPSDETreeNodeRSesBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeRSList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u8282\u70b9\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREENODERS", psSysModelLog, psDETreeNodeRSList);
        }
        for (PSDETreeNodeRS psDETreeNodeRS : psDETreeNodeRSList) {
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeNodeRS.getPSDETREEVIEWID()).psDETreeNodeRSList.add(psDETreeNodeRS);
        }
        Vector<PSDETreeNodeColumn> psDETreeNodeColumnList = psSysModelCache.getModelList("PSDETREENODECOL", psSysModelLog);
        if (psDETreeNodeColumnList == null) {
            psDETreeNodeColumnList = new Vector<PSDETreeNodeColumn>();
            callResult = this.getPSDETreeNodeColumnsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeColumnList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u8282\u70b9\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREENODECOL", psSysModelLog, psDETreeNodeColumnList);
        }
        for (PSDETreeNodeColumn psDETreeNodeColumn : psDETreeNodeColumnList) {
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeNodeColumn.getPSDETREEVIEWID()).psDETreeNodeColumnList.add(psDETreeNodeColumn);
        }
        Vector<PSDETreeNodeRV> psDETreeNodeRVList = psSysModelCache.getModelList("PSDETREENODERV", psSysModelLog);
        if (psDETreeNodeRVList == null) {
            psDETreeNodeRVList = new Vector<PSDETreeNodeRV>();
            callResult = this.getPSDETreeNodeRVsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeNodeRVList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6811\u8282\u70b9\u5f15\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDETREENODERV", psSysModelLog, psDETreeNodeRVList);
        }
        for (PSDETreeNodeRV psDETreeNodeRV : psDETreeNodeRVList) {
            psSysAppStorage.getPSDETreeViewStorage((String)psDETreeNodeRV.getPSDETREEVIEWID()).psDETreeNodeRVList.add(psDETreeNodeRV);
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDETreeLogic> psDETreeLogicList = psSysModelCache.getModelList("PSDETREELOGIC", psSysModelLog);
            if (psDETreeLogicList == null) {
                psDETreeLogicList = new Vector<PSDETreeLogic>();
                callResult = this.getPSDETreeLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDETreeLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6811\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDETREELOGIC", psSysModelLog, psDETreeLogicList);
            }
            for (PSDETreeLogic psDETreeLogic : psDETreeLogicList) {
                psSysAppStorage.getPSDETreeViewStorage((String)psDETreeLogic.getPSDETREEVIEWID()).psDETreeLogicList.add(psDETreeLogic);
            }
        }
        if ((psDEChartList = psSysModelCache.getModelList("PSDECHART", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDECHART")))) == null) {
            psDEChartList = new Vector<PSDEChart>();
            callResult = this.getPSDEChartsBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u56fe\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDECHART", psSysModelLog, psDEChartList);
        }
        Iterator iterator14 = psDEChartList.iterator();
        while (iterator14.hasNext()) {
            PSDEChart psDEChart;
            psSysAppStorage.getPSDEChartStorage((String)psDEChart.getPSDECHARTID()).psDEChart = psDEChart = (PSDEChart)((Object)iterator14.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEChartAxes> psDEChartAxesList = psSysModelCache.getModelList("PSDECHARTAXES", psSysModelLog);
            if (psDEChartAxesList == null) {
                psDEChartAxesList = new Vector<PSDEChartAxes>();
                callResult = this.getPSDEChartAxesesBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartAxesList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u56fe\u8868\u5750\u6807\u8f74\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDECHARTAXES", psSysModelLog, psDEChartAxesList);
            }
            for (PSDEChartAxes psDEChartAxes : psDEChartAxesList) {
                psSysAppStorage.getPSDEChartStorage((String)psDEChartAxes.getPSDECHARTID()).psDEChartAxesList.add(psDEChartAxes);
            }
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEChartSeries> psDEChartSeriesList = psSysModelCache.getModelList("PSDECHARTPARAM", psSysModelLog);
            if (psDEChartSeriesList == null) {
                psDEChartSeriesList = new Vector<PSDEChartSeries>();
                callResult = this.getPSDEChartSeriesesBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartSeriesList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u5e8f\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDECHARTPARAM", psSysModelLog, psDEChartSeriesList);
            }
            for (PSDEChartSeries psDEChartSeries : psDEChartSeriesList) {
                psSysAppStorage.getPSDEChartStorage((String)psDEChartSeries.getPSDECHARTID()).psDEChartSeriesList.add(psDEChartSeries);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEChartLogic> psDEChartLogicList = psSysModelCache.getModelList("PSDECHARTLOGIC", psSysModelLog);
            if (psDEChartLogicList == null) {
                psDEChartLogicList = new Vector<PSDEChartLogic>();
                callResult = this.getPSDEChartLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEChartLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u56fe\u8868\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDECHARTLOGIC", psSysModelLog, psDEChartLogicList);
            }
            for (PSDEChartLogic psDEChartLogic : psDEChartLogicList) {
                psSysAppStorage.getPSDEChartStorage((String)psDEChartLogic.getPSDECHARTID()).psDEChartLogicList.add(psDEChartLogic);
            }
        }
        if ((psDEListList = psSysModelCache.getModelList("PSDELIST", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDELIST")))) == null) {
            psDEListList = new Vector<PSDEList>();
            callResult = this.getPSDEListsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u5217\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDELIST", psSysModelLog, psDEListList);
        }
        Iterator iterator15 = psDEListList.iterator();
        while (iterator15.hasNext()) {
            PSDEList psDEList;
            psSysAppStorage.getPSDEListStorage((String)psDEList.getPSDELISTID()).psDEList = psDEList = (PSDEList)((Object)iterator15.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEListItem> psDEListItemList = psSysModelCache.getModelList("PSDELISTITEM", psSysModelLog);
            if (psDEListItemList == null) {
                psDEListItemList = new Vector<PSDEListItem>();
                callResult = this.getPSDEListItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u5217\u8868\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDELISTITEM", psSysModelLog, psDEListItemList);
            }
            for (PSDEListItem psDEListItem : psDEListItemList) {
                psSysAppStorage.getPSDEListStorage((String)psDEListItem.getPSDELISTID()).psDEListItemList.add(psDEListItem);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEListLogic> psDEListLogicList = psSysModelCache.getModelList("PSDELISTLOGIC", psSysModelLog);
            if (psDEListLogicList == null) {
                psDEListLogicList = new Vector<PSDEListLogic>();
                callResult = this.getPSDEListLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEListLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5217\u8868\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDELISTLOGIC", psSysModelLog, psDEListLogicList);
            }
            for (PSDEListLogic psDEListLogic : psDEListLogicList) {
                psSysAppStorage.getPSDEListStorage((String)psDEListLogic.getPSDELISTID()).psDEListLogicList.add(psDEListLogic);
            }
        }
        if ((psDEDataViewList = psSysModelCache.getModelList("PSDEDATAVIEW", psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEDATAVIEW")))) == null) {
            psDEDataViewList = new Vector<PSDEDataView>();
            callResult = this.getPSDEDataViewsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEDATAVIEW", psSysModelLog, psDEDataViewList);
        }
        Iterator iterator16 = psDEDataViewList.iterator();
        while (iterator16.hasNext()) {
            PSDEDataView psDEDataView;
            psSysAppStorage.getPSDEDataViewStorage((String)psDEDataView.getPSDEDATAVIEWID()).psDEDataView = psDEDataView = (PSDEDataView)((Object)iterator16.next());
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_PREVIEW) {
            Vector<PSDEDataViewItem> psDEDataViewItemList = psSysModelCache.getModelList("PSDELISTITEM_DV", psSysModelLog);
            if (psDEDataViewItemList == null) {
                psDEDataViewItemList = new Vector<PSDEDataViewItem>();
                callResult = this.getPSDEDataViewItemsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\u5750\u6807\u8f74\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDELISTITEM_DV", psSysModelLog, psDEDataViewItemList);
            }
            for (PSDEDataViewItem psDEDataViewItem : psDEDataViewItemList) {
                psSysAppStorage.getPSDEDataViewStorage((String)psDEDataViewItem.getPSDEDATAVIEWID()).psDEDataViewItemList.add(psDEDataViewItem);
            }
        }
        if (this.getModelInstVer() >= 747) {
            Vector<PSDEDataViewLogic> psDEDataViewLogicList = psSysModelCache.getModelList("PSDEDATAVIEWLOGIC", psSysModelLog);
            if (psDEDataViewLogicList == null) {
                psDEDataViewLogicList = new Vector<PSDEDataViewLogic>();
                callResult = this.getPSDEDataViewLogicsBySystem(psSystemApplication.getPSSYSTEMID(), psDEDataViewLogicList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5361\u7247\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSysModelCache.updateModelList("PSDEDATAVIEWLOGIC", psSysModelLog, psDEDataViewLogicList);
            }
            for (PSDEDataViewLogic psDEDataViewLogic : psDEDataViewLogicList) {
                psSysAppStorage.getPSDEDataViewStorage((String)psDEDataViewLogic.getPSDEDATAVIEWID()).psDEDataViewLogicList.add(psDEDataViewLogic);
            }
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSSYSVIEWLOGIC"));
        boolean bLoadDetail = true;
        Vector<PSSysViewLogic> psSysViewLogicList = psSysModelCache.getModelList("PSSYSVIEWLOGIC", psSysModelLog);
        if (psSysViewLogicList == null) {
            psSysViewLogicList = new Vector<PSSysViewLogic>();
            CallResult callResult21 = this.getAllPSSysViewLogics2(psSystemApplication.getPSSYSTEMID(), psSysViewLogicList);
            if (callResult21.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult21.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSVIEWLOGIC", psSysModelLog, psSysViewLogicList);
        }
        psSysAppStorage.psSysViewLogicList.addAll(psSysViewLogicList);
        for (PSSysViewLogic pSSysViewLogic : psSysViewLogicList) {
            psSysAppStorage.psSysViewLogicMap.put(pSSysViewLogic.getPSSYSVIEWLOGICID(), pSSysViewLogic);
            psSysAppStorage.getPSSysViewLogicStorage((String)pSSysViewLogic.getPSSYSVIEWLOGICID()).psSysViewLogic = pSSysViewLogic;
        }
        Vector<PSSysViewLogicParam> psSysViewLogicParamList = psSysModelCache.getModelList("PSSYSVIEWLOGICPARAM", psSysModelLog);
        if (psSysViewLogicParamList == null) {
            psSysViewLogicParamList = new Vector<PSSysViewLogicParam>();
            CallResult callResult22 = this.getPSSysViewLogicParamsBySystem(psSystemApplication.getPSSYSTEMID(), psSysViewLogicParamList);
            if (callResult22.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult22.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSSYSVIEWLOGICPARAM", psSysModelLog, psSysViewLogicParamList);
        }
        for (PSSysViewLogicParam pSSysViewLogicParam : psSysViewLogicParamList) {
            psSysAppStorage.getPSSysViewLogicStorage((String)pSSysViewLogicParam.getPSSYSVIEWLOGICID()).psSysViewLogicParamList.add(pSSysViewLogicParam);
        }
        psSysModelLog = (PSSysModelLog)((Object)psSysModelLogMap.get("PSDEWIZARD"));
        Vector<PSDEWizard> psDEWizardList = psSysModelCache.getModelList("PSDEWIZARD", psSysModelLog);
        if (psDEWizardList == null) {
            psDEWizardList = new Vector<PSDEWizard>();
            callResult = this.getPSDEWizardsBySystem(strPSSystemId, psDEWizardList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6240\u6709\u5b9e\u4f53\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            psSysModelCache.updateModelList("PSDEWIZARD", psSysModelLog, psDEWizardList);
        }
        for (PSDEWizard psDEWizard : psDEWizardList) {
            PSModelHelperBase.PSDEWizardStorage psDEWizardStorage = psSysAppStorage.getPSDEWizardStorage(psDEWizard.getPSDEWIZARDID());
            psDEWizardStorage.psDEWizard = psDEWizard;
        }
        log.info((Object)StringHelper.Format((String)"\u9884\u8f7d\u7cfb\u7edf\u5e94\u7528[%1$s]\u8017\u65f6[%2$s]ms", (Object)strPSSysAppId, (Object)(System.currentTimeMillis() - nBeginTime)));
        return psSysAppStorage;
    }

    protected synchronized PSModelHelperBase.PSSysAppStorage getCurrentPSSysAppStorage() {
        ArrayList<PSModelHelperBase.PSSysAppStorage> stack = this.psSysAppStorageStack.get();
        if (stack == null || stack.size() == 0) {
            return null;
        }
        return stack.get(0);
    }

    @Override
    public synchronized void startLoadPSSysApp(String strPSSysAppId, int nLoadLevel) throws Exception {
        this.active();
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.createPSSysAppStorage(strPSSysAppId, nLoadLevel);
        ArrayList<PSModelHelperBase.PSSysAppStorage> stack = this.psSysAppStorageStack.get();
        if (stack == null) {
            stack = new ArrayList();
            this.psSysAppStorageStack.set(stack);
        }
        stack.add(0, psSysAppStorage);
    }

    @Override
    public synchronized void stopLoadPSSysApp() throws Exception {
        this.active();
        ArrayList<PSModelHelperBase.PSSysAppStorage> stack = this.psSysAppStorageStack.get();
        if (stack == null || stack.size() == 0) {
            return;
        }
        stack.remove(0);
    }

    @Override
    public CallResult getAllPSSysImages(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysImageList, psSysImageList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysImages(strPSSystemId), psSysImageList, PSSysImage.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysImage(String strPSSysImageId, PSSysImage psSysImage) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysImageMap.get(strPSSysImageId) != null) {
            psSystemStorage.psSysImageMap.get(strPSSysImageId).CopyTo(psSysImage, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysImage(strPSSysImageId), psSysImage, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysCsses(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysCssList, psSysCssList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysCsses(strPSSystemId), psSysCssList, PSSysCss.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCss(String strPSSysCssId, PSSysCss psSysCss) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysCssMap.get(strPSSysCssId) != null) {
            psSystemStorage.psSysCssMap.get(strPSSysCssId).CopyTo(psSysCss, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysCss(strPSSysCssId), psSysCss, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSubViewTypes(String strPSSystemId, Vector<PSSubViewType> psSubViewTypeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSubViewTypeList, psSubViewTypeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSubViewTypes(strPSSystemId), psSubViewTypeList, PSSubViewType.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSubViewType(String strPSSubViewTypeId, PSSubViewType psSubViewType) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSubViewTypeMap.get(strPSSubViewTypeId) != null) {
            psSystemStorage.psSubViewTypeMap.get(strPSSubViewTypeId).CopyTo(psSubViewType, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSubViewType(strPSSubViewTypeId), psSubViewType, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUniReses(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysUniResList, psSysUniResList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUniReses(strPSSystemId), psSysUniResList, PSSysUniRes.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUniRes(String strPSSysUniResId, PSSysUniRes psSysUniRes) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUniResMap.get(strPSSysUniResId) != null) {
            psSystemStorage.psSysUniResMap.get(strPSSysUniResId).CopyTo(psSysUniRes, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUniRes(strPSSysUniResId), psSysUniRes, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysBackServices(String strPSSystemId, Vector<PSSysBackService> psSysBackServiceList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysBackServiceList, psSystemStorage.psSysBackServiceList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysBackServices(strPSSystemId), psSysBackServiceList, PSSysBackService.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBackService(String strPSSysBackServiceId, PSSysBackService psSysBackService) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysBackServiceMap.get(strPSSysBackServiceId) != null) {
            psSystemStorage.psSysBackServiceMap.get(strPSSysBackServiceId).CopyTo(psSysBackService, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysBackService(strPSSysBackServiceId), psSysBackService, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysMsgTempls(String strPSSystemId, Vector<PSSysMsgTempl> psSysMsgTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysMsgTemplList, psSystemStorage.psSysMsgTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysMsgTempls(strPSSystemId), psSysMsgTemplList, PSSysMsgTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysMsgTempl(String strPSSysMsgTemplId, PSSysMsgTempl psSysMsgTempl) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysMsgTemplMap.get(strPSSysMsgTemplId) != null) {
            psSystemStorage.psSysMsgTemplMap.get(strPSSysMsgTemplId).CopyTo(psSysMsgTempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysMsgTempl(strPSSysMsgTemplId), psSysMsgTempl, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPortlets(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysPortletList, psSystemStorage.psSysPortletList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPortlets(strPSSystemId), psSysPortletList, PSSysPortlet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPortlet(String strPSSysPortletId, PSSysPortlet psSysPortlet) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysPortletMap.get(strPSSysPortletId) != null) {
            psSystemStorage.psSysPortletMap.get(strPSSysPortletId).CopyTo(psSysPortlet, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPortlet(strPSSysPortletId), psSysPortlet, "SYSTEM");
    }

    @Override
    public CallResult getPSDEList(String strPSDEListId, PSDEList psDEList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null) {
            psSysAppStorage.psDEListStorageMap.get((Object)strPSDEListId).psDEList.CopyTo(psDEList, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEList(strPSDEListId), psDEList, "SYSTEM");
    }

    @Override
    public CallResult getPSDEListItems(String strPSDEListId, Vector<PSDEListItem> psDEListItemList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null) {
            for (PSDEListItem psDEListItem : psSysAppStorage.psDEListStorageMap.get((Object)strPSDEListId).psDEListItemList) {
                PSDEListItem psDEListItem2 = new PSDEListItem();
                psDEListItem.CopyTo(psDEListItem2, true);
                psDEListItemList.add(psDEListItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEListItems(strPSDEListId), psDEListItemList, PSDEListItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysValueRules(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysValueRuleList, psSysValueRuleList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.copyList(psSysAppStorage.psSysValueRuleList, psSysValueRuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysValueRules(strPSSystemId), psSysValueRuleList, PSSysValueRule.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysValueRule(String strPSSysValueRuleId, PSSysValueRule psSysValueRule) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysValueRuleMap.get(strPSSysValueRuleId) != null) {
            psSystemStorage.psSysValueRuleMap.get(strPSSysValueRuleId).CopyTo(psSysValueRule, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysValueRule(strPSSysValueRuleId), psSysValueRule, "SYSTEM");
    }

    @Override
    public CallResult getPSDEOPPrivs(String strPSDataEntityId, Vector<PSDEOPPriv> psDEOPPrivList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEOPPrivList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEOPPrivList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEOPPrivs(strPSDataEntityId), psDEOPPrivList, PSDEOPPriv.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMainStates(String strPSDEId, Vector<PSDEMainState> psDEMainStateList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEMainStateList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEMainStateList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMainStates(strPSDEId), psDEMainStateList, PSDEMainState.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMainStateRSs(String strPSDataEntityId, Vector<PSDEMainStateRS> psDEMainStateRSList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEMainStateRSList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEMainStateRSList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMainStateRSs(strPSDataEntityId), psDEMainStateRSList, PSDEMainStateRS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMainStateActions(String strPSDEMainStateId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
            for (PSDEMainStateAction psDEMainStateAction : psSystemStorage.getPSDEMainStateStorage((String)strPSDEMainStateId).psDEMainStateActionList) {
                PSDEMainStateAction psDEMainStateAction2 = new PSDEMainStateAction();
                psDEMainStateAction.CopyTo(psDEMainStateAction2, true);
                psDEMainStateActionList.add(psDEMainStateAction2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMainStateActions(strPSDEMainStateId), psDEMainStateActionList, PSDEMainStateAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMainStateOPPrivs(String strPSDEMainStateId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
            for (PSDEMainStateOPPriv psDEMainStateOPPriv : psSystemStorage.getPSDEMainStateStorage((String)strPSDEMainStateId).psDEMainStateOPPrivList) {
                PSDEMainStateOPPriv psDEMainStateOPPriv2 = new PSDEMainStateOPPriv();
                psDEMainStateOPPriv.CopyTo(psDEMainStateOPPriv2, true);
                psDEMainStateOPPrivList.add(psDEMainStateOPPriv2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMainStateOPPrivs(strPSDEMainStateId), psDEMainStateOPPrivList, PSDEMainStateOPPriv.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPDTViews(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysPDTViewList, psSystemStorage.psSysPDTViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPDTViews(strPSSystemId), psSysPDTViewList, PSSysPDTView.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPDTView(String strPSSysPDTViewId, PSSysPDTView psSysPDTView) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysPDTViewMap.get(strPSSysPDTViewId) != null) {
            psSystemStorage.psSysPDTViewMap.get(strPSSysPDTViewId).CopyTo(psSysPDTView, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPDTView(strPSSysPDTViewId), psSysPDTView, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPFPlugins(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysPFPluginList, psSysPFPluginList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPFPlugins(strPSSystemId), psSysPFPluginList, PSSysPFPlugin.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPFPlugin(String strPSSysPFPluginId, PSSysPFPlugin psSysPFPlugin) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysPFPluginMap.get(strPSSysPFPluginId) != null) {
            psSystemStorage.psSysPFPluginMap.get(strPSSysPFPluginId).CopyTo(psSysPFPlugin, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPFPlugin(strPSSysPFPluginId), psSysPFPlugin, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPFPluginTempls(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysPFPluginTemplList, psSysPFPluginTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPFPluginTempls(strPSSystemId), psSysPFPluginTemplList, PSSysPFPluginTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPFPluginTempl(String strPSSysPFPluginTemplId, PSSysPFPluginTempl psSysPFPluginTempl) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysPFPluginTemplMap.get(strPSSysPFPluginTemplId) != null) {
            psSystemStorage.psSysPFPluginTemplMap.get(strPSSysPFPluginTemplId).CopyTo(psSysPFPluginTempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPFPluginTempl(strPSSysPFPluginTemplId), psSysPFPluginTempl, "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeView(String strPSDETreeViewId, PSDETreeView psDETreeView) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeViewId) != null) {
            psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeViewId).psDETreeView.CopyTo(psDETreeView, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDETreeView(strPSDETreeViewId), psDETreeView, "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeNodes(String strPSDETreeId, Vector<PSDETreeNode> psDETreeNodeList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
            for (PSDETreeNode psDETreeNode : psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeNodeList) {
                PSDETreeNode psDETreeNode2 = new PSDETreeNode();
                psDETreeNode.CopyTo(psDETreeNode2, true);
                psDETreeNodeList.add(psDETreeNode2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeNodes(strPSDETreeId), psDETreeNodeList, PSDETreeNode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeColumns(String strPSDETreeId, Vector<PSDETreeColumn> psDETreeColumnList) {
        if (this.getModelInstVer() < 363) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
            for (PSDETreeColumn psDETreeColumn : psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeColumnList) {
                PSDETreeColumn psDETreeColumn2 = new PSDETreeColumn();
                psDETreeColumn.CopyTo(psDETreeColumn2, true);
                psDETreeColumnList.add(psDETreeColumn2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeColumns(strPSDETreeId), psDETreeColumnList, PSDETreeColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeNodeColumns(String strPSDETreeId, Vector<PSDETreeNodeColumn> psDETreeNodeColumnList) {
        if (this.getModelInstVer() < 363) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
            for (PSDETreeNodeColumn psDETreeNodeColumn : psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeNodeColumnList) {
                PSDETreeNodeColumn psDETreeNodeColumn2 = new PSDETreeNodeColumn();
                psDETreeNodeColumn.CopyTo(psDETreeNodeColumn2, true);
                psDETreeNodeColumnList.add(psDETreeNodeColumn2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeNodeColumns(strPSDETreeId), psDETreeNodeColumnList, PSDETreeNodeColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeNodeRSes(String strPSDETreeId, Vector<PSDETreeNodeRS> psDETreeNodeRSList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
            for (PSDETreeNodeRS psDETreeNodeRS : psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeNodeRSList) {
                PSDETreeNodeRS psDETreeNodeRS2 = new PSDETreeNodeRS();
                psDETreeNodeRS.CopyTo(psDETreeNodeRS2, true);
                psDETreeNodeRSList.add(psDETreeNodeRS2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeNodeRSes(strPSDETreeId), psDETreeNodeRSList, PSDETreeNodeRS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeNodeRVs(String strPSDETreeId, Vector<PSDETreeNodeRV> psDETreeNodeRVList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null) {
            for (PSDETreeNodeRV psDETreeNodeRV : psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeNodeRVList) {
                PSDETreeNodeRV psDETreeNodeRV2 = new PSDETreeNodeRV();
                psDETreeNodeRV.CopyTo(psDETreeNodeRV2, true);
                psDETreeNodeRVList.add(psDETreeNodeRV2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeNodeRVs(strPSDETreeId), psDETreeNodeRVList, PSDETreeNodeRV.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysCounters(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysCounterList, psSystemStorage.psSysCounterList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysCounters(strPSSystemId), psSysCounterList, PSSysCounter.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCounter(String strPSSysCounterId, PSSysCounter psSysCounter) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysCounterMap.get(strPSSysCounterId) != null) {
            psSystemStorage.psSysCounterMap.get(strPSSysCounterId).CopyTo(psSysCounter, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysCounter(strPSSysCounterId), psSysCounter, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDictCats(String strPSSystemId, Vector<PSSysDictCat> psSysDictCatList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysDictCatList, psSysDictCatList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDictCats(strPSSystemId), psSysDictCatList, PSSysDictCat.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDictCat(String strPSSysDictCatId, PSSysDictCat psSysDictCat) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDictCatMap.get(strPSSysDictCatId) != null) {
            psSystemStorage.psSysDictCatMap.get(strPSSysDictCatId).CopyTo(psSysDictCat, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDictCat(strPSSysDictCatId), psSysDictCat, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysEditorStyles(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysEditorStyleList, psSystemStorage.psSysEditorStyleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysEditorStyles(strPSSystemId), psSysEditorStyleList, PSSysEditorStyle.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEditorStyle(String strPSSysEditorStyleId, PSSysEditorStyle psSysEditorStyle) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysEditorStyleMap.get(strPSSysEditorStyleId) != null) {
            psSystemStorage.psSysEditorStyleMap.get(strPSSysEditorStyleId).CopyTo(psSysEditorStyle, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysEditorStyle(strPSSysEditorStyleId), psSysEditorStyle, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDBIndexs(String strPSDataEntityId, Vector<PSDEDBIndex> psDEDBIndexList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDBIndexList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDBIndexList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDBIndexs(strPSDataEntityId), psDEDBIndexList, PSDEDBIndex.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDBIndexFields(String strPSDEDBIndexId, Vector<PSDEDBIndexField> psDEDBIndexFieldList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDBIndexStorage(strPSDEDBIndexId) != null) {
            for (PSDEDBIndexField psDEDBIndexField : psSystemStorage.getPSDEDBIndexStorage((String)strPSDEDBIndexId).psDEDBIndexFieldList) {
                PSDEDBIndexField psDEDBIndexField2 = new PSDEDBIndexField();
                psDEDBIndexField.CopyTo(psDEDBIndexField2, true);
                psDEDBIndexFieldList.add(psDEDBIndexField2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDBIndexFields(strPSDEDBIndexId), psDEDBIndexFieldList, PSDEDBIndexField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEReports(String strPSDEId, Vector<PSDEReport> psDEReportList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEReportList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEReportList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEReportList, psSysAppStorage.getPSDataEntityStorage((String)strPSDEId).psDEReportList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEReports(strPSDEId), psDEReportList, PSDEReport.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEReportItems(String strPSDEReportId, Vector<PSDEReportItem> psDEReportItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEReportStorage(strPSDEReportId) != null) {
            for (PSDEReportItem psDEReportItem : psSystemStorage.getPSDEReportStorage((String)strPSDEReportId).psDEReportItemList) {
                PSDEReportItem psDEReportItem2 = new PSDEReportItem();
                psDEReportItem.CopyTo(psDEReportItem2, true);
                psDEReportItemList.add(psDEReportItem2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDEReportStorage(strPSDEReportId) != null) {
            for (PSDEReportItem psDEReportItem : psSysAppStorage.getPSDEReportStorage((String)strPSDEReportId).psDEReportItemList) {
                PSDEReportItem psDEReportItem2 = new PSDEReportItem();
                psDEReportItem.CopyTo(psDEReportItem2, true);
                psDEReportItemList.add(psDEReportItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEReportItems(strPSDEReportId), psDEReportItemList, PSDEReportItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEPrints(String strPSDEId, Vector<PSDEPrint> psDEPrintList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEPrintList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEPrintList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEPrintList, psSysAppStorage.getPSDataEntityStorage((String)strPSDEId).psDEPrintList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEPrints(strPSDEId), psDEPrintList, PSDEPrint.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysViewLogics(String strPSSystemId, Vector<PSSysViewLogic> psSysViewLogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysViewLogicList, psSystemStorage.psSysViewLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysViewLogics(strPSSystemId), psSysViewLogicList, PSSysViewLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysViewLogic(String strPSSysViewLogicId, PSSysViewLogic psSysViewLogic) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysViewLogicMap.get(strPSSysViewLogicId) != null) {
            psSystemStorage.psSysViewLogicMap.get(strPSSysViewLogicId).CopyTo(psSysViewLogic, true);
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysViewLogicMap.get(strPSSysViewLogicId) != null) {
            psSysAppStorage.psSysViewLogicMap.get(strPSSysViewLogicId).CopyTo(psSysViewLogic, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysViewLogic(strPSSysViewLogicId), psSysViewLogic, "SYSTEM");
    }

    @Override
    public CallResult getPSDEViewLogics(String strPSDEViewId, Vector<PSDEViewLogic> psDEViewLogicList) {
        ArrayList<PSDEViewLogic> psDEViewLogicList2;
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null && (psDEViewLogicList2 = psSysAppStorage.psDEViewBaseStorageMap.get((Object)strPSDEViewId).psDEViewLogicList) != null) {
            for (PSDEViewLogic psDEViewLogic : psDEViewLogicList2) {
                PSDEViewLogic psDEViewLogic2 = new PSDEViewLogic();
                psDEViewLogic.CopyTo(psDEViewLogic2, true);
                psDEViewLogicList.add(psDEViewLogic2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEViewLogics(strPSDEViewId), psDEViewLogicList, PSDEViewLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEViewEngines(String strPSDEViewId, Vector<PSDEViewEngine> psDEViewEngineList) {
        ArrayList<PSDEViewEngine> psDEViewEngineList2;
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEViewBaseStorageMap.get(strPSDEViewId) != null && (psDEViewEngineList2 = psSysAppStorage.psDEViewBaseStorageMap.get((Object)strPSDEViewId).psDEViewEngineList) != null) {
            for (PSDEViewEngine psDEViewEngine : psDEViewEngineList2) {
                PSDEViewEngine psDEViewEngine2 = new PSDEViewEngine();
                psDEViewEngine.CopyTo(psDEViewEngine2, true);
                psDEViewEngineList.add(psDEViewEngine2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEViewEngines(strPSDEViewId), psDEViewEngineList, PSDEViewEngine.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDEUIActionGroups(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDEUIActionGroupList, psSystemStorage.psDEUIActionGroupList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psDEUIActionGroupList, psSysAppStorage.psDEUIActionGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDEUIActionGroups(strPSSystemId), psDEUIActionGroupList, PSDEUIActionGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysActors(String strPSSystemId, Vector<PSSysActor> psSysActorList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysActorList, psSystemStorage.psSysActorList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysActors(strPSSystemId), psSysActorList, PSSysActor.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysActor(String strPSSysActorId, PSSysActor psSysActor) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysActorMap.get(strPSSysActorId) != null) {
            psSystemStorage.psSysActorMap.get(strPSSysActorId).CopyTo(psSysActor, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysActor(strPSSysActorId), psSysActor, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUserCases(String strPSSystemId, Vector<PSSysUserCase> psSysUserCaseList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUserCaseList, psSystemStorage.psSysUserCaseList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUserCases(strPSSystemId), psSysUserCaseList, PSSysUserCase.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserCase(String strPSSysUserCaseId, PSSysUserCase psSysUserCase) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUserCaseMap.get(strPSSysUserCaseId) != null) {
            psSystemStorage.psSysUserCaseMap.get(strPSSysUserCaseId).CopyTo(psSysUserCase, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUserCase(strPSSysUserCaseId), psSysUserCase, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUserCaseRSs(String strPSSystemId, Vector<PSSysUserCaseRS> psSysUserCaseRSList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUserCaseRSList, psSystemStorage.psSysUserCaseRSList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUserCaseRSs(strPSSystemId), psSysUserCaseRSList, PSSysUserCaseRS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserCaseRS(String strPSSysUserCaseRSId, PSSysUserCaseRS psSysUserCaseRS) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUserCaseRSMap.get(strPSSysUserCaseRSId) != null) {
            psSystemStorage.psSysUserCaseRSMap.get(strPSSysUserCaseRSId).CopyTo(psSysUserCaseRS, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUserCaseRS(strPSSysUserCaseRSId), psSysUserCaseRS, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysTestCases(String strPSSystemId, Vector<PSSysTestCase> psSysTestCaseList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysTestCaseList, psSystemStorage.psSysTestCaseList)) {
            return new CallResult();
        }
        if (this.getModelInstVer() >= 602) {
            return this.selectMulti(this.getSQL_getAllPSSysTestCases2(strPSSystemId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
        }
        return this.selectMulti(this.getSQL_getAllPSSysTestCases(strPSSystemId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestCase(String strPSSysTestCaseId, PSSysTestCase psSysTestCase) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysTestCaseMap.get(strPSSysTestCaseId) != null) {
            psSystemStorage.psSysTestCaseMap.get(strPSSysTestCaseId).CopyTo(psSysTestCase, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysTestCase(strPSSysTestCaseId), psSysTestCase, "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestCaseInputs(String strPSSysTestCaseId, Vector<PSSysTestCaseInput> psSysTestCaseInputList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysTestCaseStorage(strPSSysTestCaseId) != null && this.fromList(psSysTestCaseInputList, psSystemStorage.getPSSysTestCaseStorage((String)strPSSysTestCaseId).psSysTestCaseInputList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysTestCaseInputs(strPSSysTestCaseId), psSysTestCaseInputList, PSSysTestCaseInput.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestCaseAsserts(String strPSSysTestCaseInputId, Vector<PSSysTestCaseAssert> psSysTestCaseAssertList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysTestCaseInputStorage(strPSSysTestCaseInputId) != null && this.fromList(psSysTestCaseAssertList, psSystemStorage.getPSSysTestCaseInputStorage((String)strPSSysTestCaseInputId).psSysTestCaseAssertList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysTestCaseAsserts(strPSSysTestCaseInputId), psSysTestCaseAssertList, PSSysTestCaseAssert.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysTestDatas(String strPSSystemId, Vector<PSSysTestData> psSysTestDataList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysTestDataList, psSystemStorage.psSysTestDataList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysTestDatas(strPSSystemId), psSysTestDataList, PSSysTestData.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestData(String strPSSysTestDataId, PSSysTestData psSysTestData) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysTestDataMap.get(strPSSysTestDataId) != null) {
            psSystemStorage.psSysTestDataMap.get(strPSSysTestDataId).CopyTo(psSysTestData, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysTestData(strPSSysTestDataId), psSysTestData, "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestDataItems(String strPSSysTestDataId, Vector<PSSysTestDataItem> psSysTestDataItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysTestDataStorage(strPSSysTestDataId) != null && this.fromList(psSysTestDataItemList, psSystemStorage.getPSSysTestDataStorage((String)strPSSysTestDataId).psSysTestDataItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysTestDataItems(strPSSysTestDataId), psSysTestDataItemList, PSSysTestDataItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSampleValues(String strPSSystemId, Vector<PSSysSampleValue> psSysSampleValueList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysSampleValueList, psSystemStorage.psSysSampleValueList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSampleValues(strPSSystemId), psSysSampleValueList, PSSysSampleValue.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSampleValue(String strPSSysSampleValueId, PSSysSampleValue psSysSampleValue) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSampleValueMap.get(strPSSysSampleValueId) != null) {
            psSystemStorage.psSysSampleValueMap.get(strPSSysSampleValueId).CopyTo(psSysSampleValue, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSampleValue(strPSSysSampleValueId), psSysSampleValue, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUserModes(String strPSSystemId, Vector<PSSysUserMode> psSysUserModeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUserModeList, psSystemStorage.psSysUserModeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUserModes(strPSSystemId), psSysUserModeList, PSSysUserMode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserMode(String strPSSysUserModeId, PSSysUserMode psSysUserMode) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUserModeMap.get(strPSSysUserModeId) != null) {
            psSystemStorage.psSysUserModeMap.get(strPSSysUserModeId).CopyTo(psSysUserMode, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUserMode(strPSSysUserModeId), psSysUserMode, "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppUserModes(String strPSApplicationId, Vector<PSAppUserMode> psAppUserModes) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppUserModes, psSysAppStorage.psAppUserModeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppUserModes(strPSApplicationId), psAppUserModes, PSAppUserMode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppUIThemes(String strPSApplicationId, Vector<PSAppUITheme> psAppUIThemes) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppUIThemes, psSysAppStorage.psAppUIThemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppUIThemes(strPSApplicationId), psAppUIThemes, PSAppUITheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDERDEFMaps(String strPSDERId, Vector<PSDERDEFMap> psDERDEFMapList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDERStorage(strPSDERId) != null) {
            for (PSDERDEFMap psDERDEFMap : psSystemStorage.getPSDERStorage((String)strPSDERId).psDERDEFMapList) {
                PSDERDEFMap psDERDEFMap2 = new PSDERDEFMap();
                psDERDEFMap.CopyTo(psDERDEFMap2, true);
                psDERDEFMapList.add(psDERDEFMap2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDERDEFMaps(strPSDERId), psDERDEFMapList, PSDERDEFMap.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysERMaps(String strPSSystemId, Vector<PSSysERMap> psSysERMapList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysERMapList, psSystemStorage.psSysERMapList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysERMaps(strPSSystemId), psSysERMapList, PSSysERMap.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysERMap(String strPSSysERMapId, PSSysERMap psSysERMap) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysERMapMap.get(strPSSysERMapId) != null) {
            psSystemStorage.psSysERMapMap.get(strPSSysERMapId).CopyTo(psSysERMap, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysERMap(strPSSysERMapId), psSysERMap, "SYSTEM");
    }

    @Override
    public CallResult getPSSysERMapNodes(String strPSSysERMapId, Vector<PSSysERMapNode> psSysERMapNodeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysERMapStorage(strPSSysERMapId) != null && this.fromList(psSysERMapNodeList, psSystemStorage.getPSSysERMapStorage((String)strPSSysERMapId).psSysERMapNodeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysERMapNodes(strPSSysERMapId), psSysERMapNodeList, PSSysERMapNode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUCMaps(String strPSSystemId, Vector<PSSysUCMap> psSysUCMapList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUCMapList, psSystemStorage.psSysUCMapList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUCMaps(strPSSystemId), psSysUCMapList, PSSysUCMap.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUCMap(String strPSSysUCMapId, PSSysUCMap psSysUCMap) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUCMapMap.get(strPSSysUCMapId) != null) {
            psSystemStorage.psSysUCMapMap.get(strPSSysUCMapId).CopyTo(psSysUCMap, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUCMap(strPSSysUCMapId), psSysUCMap, "SYSTEM");
    }

    @Override
    public CallResult getPSSysUCMapNodes(String strPSSysUCMapId, Vector<PSSysUCMapNode> psSysUCMapNodeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysUCMapStorage(strPSSysUCMapId) != null && this.fromList(psSysUCMapNodeList, psSystemStorage.getPSSysUCMapStorage((String)strPSSysUCMapId).psSysUCMapNodeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysUCMapNodes(strPSSysUCMapId), psSysUCMapNodeList, PSSysUCMapNode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDynaModels(String strPSSystemId, Vector<PSSysDynaModel> psSysDynaModelList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysDynaModelList, psSystemStorage.psSysDynaModelList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDynaModels(strPSSystemId), psSysDynaModelList, PSSysDynaModel.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDynaModel(String strPSSysDynaModelId, PSSysDynaModel psSysDynaModel) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDynaModelMap.get(strPSSysDynaModelId) != null) {
            psSystemStorage.psSysDynaModelMap.get(strPSSysDynaModelId).CopyTo(psSysDynaModel, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDynaModel(strPSSysDynaModelId), psSysDynaModel, "SYSTEM");
    }

    @Override
    public CallResult getPSSysDynaModelAttrs(String strPSSysDynaModelId, Vector<PSSysDynaModelAttr> psSysDynaModelAttrList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysDynaModelStorage(strPSSysDynaModelId) != null && this.fromList(psSysDynaModelAttrList, psSystemStorage.getPSSysDynaModelStorage((String)strPSSysDynaModelId).psSysDynaModelAttrList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDynaModelAttrs(strPSSysDynaModelId), psSysDynaModelAttrList, PSSysDynaModelAttr.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSFPubs(String strPSSystemId, Vector<PSSysSFPub> psSysSFPubList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysSFPubList, psSystemStorage.psSysSFPubList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSFPubs(strPSSystemId), psSysSFPubList, PSSysSFPub.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSFPub(String strPSSysSFPubId, PSSysSFPub psSysSFPub) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSFPubMap.get(strPSSysSFPubId) != null) {
            psSystemStorage.psSysSFPubMap.get(strPSSysSFPubId).CopyTo(psSysSFPub, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSFPub(strPSSysSFPubId), psSysSFPub, "SYSTEM");
    }

    @Override
    public CallResult getPSDEGEIUpdates(String strPSDEGridId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
            for (PSDEGEIUpdate psDEGEIUpdate : psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGEIUpdateList) {
                PSDEGEIUpdate psDEGEIUpdate2 = new PSDEGEIUpdate();
                psDEGEIUpdate.CopyTo(psDEGEIUpdate2, true);
                psDEGEIUpdateList.add(psDEGEIUpdate2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGEIUpdates(strPSDEGridId), psDEGEIUpdateList, PSDEGEIUpdate.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGEIUpdates(String strPSDEGridId) {
        if (strPSDEGridId.indexOf("SRFTEMPKEY:") == 0) {
            return StringHelper.Format((String)"select t1.* from V_PSDEGEIUPDATE_TMP t1 where  t1.PSDEGRIDID='%1$s' AND  t1.srfdraftflag = 0 ", (Object)strPSDEGridId);
        }
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIUPDATE t1 where  t1.PSDEGRIDID='%1$s' ", (Object)strPSDEGridId);
    }

    public CallResult getPSDEGEIUpdatesBySystem(String strPSSystemId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
        return this.selectMulti(this.getSQL_getPSDEGEIUpdatesBySystem(strPSSystemId), psDEGEIUpdateList, PSDEGEIUpdate.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEGEIUpdatesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEGEIUPDATE t1  inner join  t_srfpsdegrid t2 on t1.psdegridid = t2.psdegridid inner join  t_srfpsdataentity t3 on t2.psdeid = t3.psdataentityid where  t3.PSSYSTEMID ='%1$s'  and (t3.DYNAMODELFLAG IS NULL OR t3.DYNAMODELFLAG = 0) ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEGEIUDetails(String strPSDEGridId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null) {
            for (PSDEGEIUDetail psDEGEIUDetail : psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGEIUDetailList) {
                PSDEGEIUDetail psDEGEIUDetail2 = new PSDEGEIUDetail();
                psDEGEIUDetail.CopyTo(psDEGEIUDetail2, true);
                psDEGEIUDetailList.add(psDEGEIUDetail2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGEIUDetails(strPSDEGridId), psDEGEIUDetailList, PSDEGEIUDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEWizards(String strPSDEId, Vector<PSDEWizard> psDEWizardList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEWizardList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEWizardList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEWizards(strPSDEId), psDEWizardList, PSDEWizard.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEWizardSteps(String strPSDEWizardId, Vector<PSDEWizardStep> psDEWizardStepList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
            for (PSDEWizardStep psDEWizardStep : psSystemStorage.getPSDEWizardStorage((String)strPSDEWizardId).psDEWizardStepList) {
                PSDEWizardStep psDEWizardStep2 = new PSDEWizardStep();
                psDEWizardStep.CopyTo(psDEWizardStep2, true);
                psDEWizardStepList.add(psDEWizardStep2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEWizardSteps(strPSDEWizardId), psDEWizardStepList, PSDEWizardStep.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEWizardForms(String strPSDEWizardId, Vector<PSDEWizardForm> psDEWizardFormList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
            for (PSDEWizardForm psDEWizardForm : psSystemStorage.getPSDEWizardStorage((String)strPSDEWizardId).psDEWizardFormList) {
                PSDEWizardForm psDEWizardForm2 = new PSDEWizardForm();
                psDEWizardForm.CopyTo(psDEWizardForm2, true);
                psDEWizardFormList.add(psDEWizardForm2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEWizardForms(strPSDEWizardId), psDEWizardFormList, PSDEWizardForm.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDataSyncAgents(String strPSSystemId, Vector<PSSysDataSyncAgent> psSysDataSyncAgentList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysDataSyncAgentList, psSystemStorage.psSysDataSyncAgentList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDataSyncAgents(strPSSystemId), psSysDataSyncAgentList, PSSysDataSyncAgent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDataSyncAgent(String strPSSysDataSyncAgentId, PSSysDataSyncAgent psSysDataSyncAgent) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDataSyncAgentMap.get(strPSSysDataSyncAgentId) != null) {
            psSystemStorage.psSysDataSyncAgentMap.get(strPSSysDataSyncAgentId).CopyTo(psSysDataSyncAgent, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDataSyncAgent(strPSSysDataSyncAgentId), psSysDataSyncAgent, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataSyncs(String strPSDEId, Vector<PSDEDataSync> psDEDataSyncList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataSyncList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataSyncList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataSyncs(strPSDEId), psDEDataSyncList, PSDEDataSync.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUserDRs(String strPSSystemId, Vector<PSSysUserDR> psSysUserDRList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUserDRList, psSystemStorage.psSysUserDRList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUserDRs(strPSSystemId), psSysUserDRList, PSSysUserDR.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserDR(String strPSSysUserDRId, PSSysUserDR psSysUserDR) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUserDRMap.get(strPSSysUserDRId) != null) {
            psSystemStorage.psSysUserDRMap.get(strPSSysUserDRId).CopyTo(psSysUserDR, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUserDR(strPSSysUserDRId), psSysUserDR, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysBDSchemes(String strPSSystemId, Vector<PSSysBDScheme> psSysBDSchemeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysBDSchemeList, psSystemStorage.psSysBDSchemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysBDSchemes(strPSSystemId), psSysBDSchemeList, PSSysBDScheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDScheme(String strPSSysBDSchemeId, PSSysBDScheme psSysBDScheme) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysBDSchemeMap.get(strPSSysBDSchemeId) != null) {
            psSystemStorage.psSysBDSchemeMap.get(strPSSysBDSchemeId).CopyTo(psSysBDScheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysBDScheme(strPSSysBDSchemeId), psSysBDScheme, "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppLans(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
        if (this.getModelInstVer() < 96) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppLans, psSysAppStorage.psAppLanList)) {
            return new CallResult();
        }
        return this.selectMultiValid(this.getSQL_getAllPSAppLans(strPSApplicationId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDModules(String strPSSysBDSchemeId, Vector<PSSysBDModule> psSysBDModuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null && this.fromList(psSysBDModuleList, psSystemStorage.getPSSysBDSchemeStorage((String)strPSSysBDSchemeId).psSysBDModuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDModules(strPSSysBDSchemeId), psSysBDModuleList, PSSysBDModule.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDParts(String strPSSysBDSchemeId, Vector<PSSysBDPart> psSysBDPartList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null && this.fromList(psSysBDPartList, psSystemStorage.getPSSysBDSchemeStorage((String)strPSSysBDSchemeId).psSysBDPartList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDParts(strPSSysBDSchemeId), psSysBDPartList, PSSysBDPart.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDTables(String strPSSysBDSchemeId, Vector<PSSysBDTable> psSysBDTableList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null && this.fromList(psSysBDTableList, psSystemStorage.getPSSysBDSchemeStorage((String)strPSSysBDSchemeId).psSysBDTableList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDTables(strPSSysBDSchemeId), psSysBDTableList, PSSysBDTable.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDTableRSes(String strPSSysBDSchemeId, Vector<PSSysBDTableRS> psSysBDTableRSList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDSchemeStorage(strPSSysBDSchemeId) != null && this.fromList(psSysBDTableRSList, psSystemStorage.getPSSysBDSchemeStorage((String)strPSSysBDSchemeId).psSysBDTableRSList)) {
            return new CallResult();
        }
        return this.selectMultiValid(this.getSQL_getPSSysBDTableRSes(strPSSysBDSchemeId), psSysBDTableRSList, PSSysBDTableRS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDColumns(String strPSSysBDTableId, Vector<PSSysBDColumn> psSysBDColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null && this.fromList(psSysBDColumnList, psSystemStorage.getPSSysBDTableStorage((String)strPSSysBDTableId).psSysBDColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDColumns(strPSSysBDTableId), psSysBDColumnList, PSSysBDColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDColSets(String strPSSysBDTableId, Vector<PSSysBDColSet> psSysBDColSetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null && this.fromList(psSysBDColSetList, psSystemStorage.getPSSysBDTableStorage((String)strPSSysBDTableId).psSysBDColSetList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDColSets(strPSSysBDTableId), psSysBDColSetList, PSSysBDColSet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDTableDEs(String strPSSysBDTableId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null && this.fromList(psSysBDTableDEList, psSystemStorage.getPSSysBDTableStorage((String)strPSSysBDTableId).psSysBDTableDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDTableDEs(strPSSysBDTableId), psSysBDTableDEList, PSSysBDTableDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBDTableDERs(String strPSSysBDTableId, Vector<PSSysBDTableDER> psSysBDTableDERList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBDTableStorage(strPSSysBDTableId) != null && this.fromList(psSysBDTableDERList, psSystemStorage.getPSSysBDTableStorage((String)strPSSysBDTableId).psSysBDTableDERList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBDTableDERs(strPSSysBDTableId), psSysBDTableDERList, PSSysBDTableDER.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEBDTables(String strPSDEId, Vector<PSSysBDTableDE> psSysBDTableDEList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psSysBDTableDEList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEBDTableList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEBDTables(strPSDEId), psSysBDTableDEList, PSSysBDTable.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSViewMsgs(String strPSSystemId, Vector<PSViewMsg> psViewMsgList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psViewMsgList, psSystemStorage.psViewMsgList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSViewMsgs(strPSSystemId), psViewMsgList, PSViewMsg.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSViewMsg(String strPSViewMsgId, PSViewMsg psViewMsg) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psViewMsgMap.get(strPSViewMsgId) != null) {
            psSystemStorage.psViewMsgMap.get(strPSViewMsgId).CopyTo(psViewMsg, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSViewMsg(strPSViewMsgId), psViewMsg, "SYSTEM");
    }

    @Override
    public CallResult getAllPSViewMsgGroups(String strPSSystemId, Vector<PSViewMsgGroup> psViewMsgGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psViewMsgGroupList, psSystemStorage.psViewMsgGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSViewMsgGroups(strPSSystemId), psViewMsgGroupList, PSViewMsgGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSViewMsgGroup(String strPSViewMsgGroupId, PSViewMsgGroup psViewMsgGroup) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psViewMsgGroupMap.get(strPSViewMsgGroupId) != null) {
            psSystemStorage.psViewMsgGroupMap.get(strPSViewMsgGroupId).CopyTo(psViewMsgGroup, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSViewMsgGroup(strPSViewMsgGroupId), psViewMsgGroup, "SYSTEM");
    }

    @Override
    public CallResult getPSViewMsgGroupDetails(String strPSViewMsgGroupId, Vector<PSViewMsgGroupDetail> psViewMsgGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSViewMsgGroupStorage(strPSViewMsgGroupId) != null && this.fromList(psViewMsgGroupDetailList, psSystemStorage.getPSViewMsgGroupStorage((String)strPSViewMsgGroupId).psViewMsgGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSViewMsgGroupDetails(strPSViewMsgGroupId), psViewMsgGroupDetailList, PSViewMsgGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataExports(String strPSDEId, Vector<PSDEDataExport> psDEDataExportList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataExportList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataExportList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataExportList, psSysAppStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataExportList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataExports(strPSDEId), psDEDataExportList, PSDEDataExport.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataExportItems(String strPSDEDataExportId, Vector<PSDEGridColumn> psDEGridColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEDataExportStorageMap.get(strPSDEDataExportId) != null) {
            for (PSDEGridColumn psDEGridColumn : psSystemStorage.psDEDataExportStorageMap.get((Object)strPSDEDataExportId).psDEGridColumnList) {
                PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
                psDEGridColumn.CopyTo(psDEGridColumn2, true);
                psDEGridColumnList.add(psDEGridColumn2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEDataExportStorageMap.get(strPSDEDataExportId) != null) {
            for (PSDEGridColumn psDEGridColumn : psSysAppStorage.psDEDataExportStorageMap.get((Object)strPSDEDataExportId).psDEGridColumnList) {
                PSDEGridColumn psDEGridColumn2 = new PSDEGridColumn();
                psDEGridColumn.CopyTo(psDEGridColumn2, true);
                psDEGridColumnList.add(psDEGridColumn2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataExportItems(strPSDEDataExportId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataImports(String strPSDEId, Vector<PSDEDataImport> psDEDataImportList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataImportList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataImportList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEDataImportList, psSysAppStorage.getPSDataEntityStorage((String)strPSDEId).psDEDataImportList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataImports(strPSDEId), psDEDataImportList, PSDEDataImport.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataImportItems(String strPSDEDataImportId, Vector<PSDEDataImportItem> psDEDataImportItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEDataImportStorageMap.get(strPSDEDataImportId) != null) {
            for (PSDEDataImportItem psDEDataImportItem : psSystemStorage.psDEDataImportStorageMap.get((Object)strPSDEDataImportId).psDEDataImportItemList) {
                PSDEDataImportItem psDEDataImportItem2 = new PSDEDataImportItem();
                psDEDataImportItem.CopyTo(psDEDataImportItem2, true);
                psDEDataImportItemList.add(psDEDataImportItem2);
            }
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEDataImportStorageMap.get(strPSDEDataImportId) != null) {
            for (PSDEDataImportItem psDEDataImportItem : psSysAppStorage.psDEDataImportStorageMap.get((Object)strPSDEDataImportId).psDEDataImportItemList) {
                PSDEDataImportItem psDEDataImportItem2 = new PSDEDataImportItem();
                psDEDataImportItem.CopyTo(psDEDataImportItem2, true);
                psDEDataImportItemList.add(psDEDataImportItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataImportItems(strPSDEDataImportId), psDEDataImportItemList, PSDEDataImportItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFInputTipsByDataEntity(String strPSDEId, Vector<PSDEFInputTip> psDEFInputTipList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEFInputTipList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEFInputTipList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFInputTipsByDataEntity(strPSDEId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFInputTipsBySystem(String strPSSystemId, Vector<PSDEFInputTip> psDEFInputTipList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDEFInputTipList, psSystemStorage.psDEFInputTipList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFInputTipsBySystem3(strPSSystemId), psDEFInputTipList, PSDEFInputTip.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionWizards(String strPSDEId, Vector<PSDEActionWizard> psDEActionWizardList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEActionWizardList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEActionWizardList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionWizards(strPSDEId), psDEActionWizardList, PSDEActionWizard.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionWizardItems(String strPSDEActionWizardId, Vector<PSDEAWItem> psDEActionWizardItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionWizardStorage(strPSDEActionWizardId) != null && this.fromList(psDEActionWizardItemList, psSystemStorage.getPSDEActionWizardStorage((String)strPSDEActionWizardId).psDEActionWizardItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionWizardItems(strPSDEActionWizardId), psDEActionWizardItemList, PSDEAWItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionWizardGroups(String strPSDEId, Vector<PSDEAWGroup> psDEActionWizardGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEActionWizardGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEAWGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionWizardGroups(strPSDEId), psDEActionWizardGroupList, PSDEAWGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionWizardGroupDetails(String strPSDEActionWizardGroupId, Vector<PSDEAWGrpDetail> psDEActionWizardGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionWizardGroupStorage(strPSDEActionWizardGroupId) != null && this.fromList(psDEActionWizardGroupDetailList, psSystemStorage.getPSDEActionWizardGroupStorage((String)strPSDEActionWizardGroupId).psDEAWGrpDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionWizardGroupDetails(strPSDEActionWizardGroupId), psDEActionWizardGroupDetailList, PSDEAWGrpDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSWXAccounts(String strPSSystemId, Vector<PSWXAccount> psWXAccountList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psWXAccountList, psSystemStorage.psWXAccountList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSWXAccounts(strPSSystemId), psWXAccountList, PSWXAccount.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXAccount(String strPSWXAccountId, PSWXAccount psWXAccount) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null) {
            psSystemStorage.getPSWXAccountStorage((String)strPSWXAccountId).psWXAccount.CopyTo(psWXAccount, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSWXAccount(strPSWXAccountId), psWXAccount, "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenuItems(String strPSWXMenuId, Vector<PSWXMenuItem> psWXMenuItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId) != null) {
            for (PSWXMenuItem psWXMenuItem : psSystemStorage.psWXMenuStorageMap.get((Object)strPSWXMenuId).psWXMenuItemList) {
                PSWXMenuItem psWXMenuItem2 = new PSWXMenuItem();
                psWXMenuItem.CopyTo(psWXMenuItem2, true);
                psWXMenuItemList.add(psWXMenuItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXMenuItems(strPSWXMenuId), psWXMenuItemList, PSWXMenuItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXEntApps(String strPSWXAccountId, Vector<PSWXEntApp> psWXEntAppList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null && this.fromList(psWXEntAppList, psSystemStorage.getPSWXAccountStorage((String)strPSWXAccountId).psWXEntAppList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXEntApps(strPSWXAccountId), psWXEntAppList, PSWXEntApp.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenuFuncs(String strPSWXAccountId, Vector<PSWXMenuFunc> psWXMenuFuncList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null && this.fromList(psWXMenuFuncList, psSystemStorage.getPSWXAccountStorage((String)strPSWXAccountId).psWXMenuFuncList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXMenuFuncs(strPSWXAccountId), psWXMenuFuncList, PSWXMenuFunc.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenuFuncsByApp(String strPSWXEntAppId, Vector<PSWXMenuFunc> psWXMenuFuncList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null && this.fromList(psWXMenuFuncList, psSystemStorage.getPSWXEntAppStorage((String)strPSWXEntAppId).psWXMenuFuncList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXMenuFuncsByApp(strPSWXEntAppId), psWXMenuFuncList, PSWXMenuFunc.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXLogics(String strPSWXAccountId, Vector<PSWXLogic> psWXLogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null && this.fromList(psWXLogicList, psSystemStorage.getPSWXAccountStorage((String)strPSWXAccountId).psWXLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXLogics(strPSWXAccountId), psWXLogicList, PSWXLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXLogicsByApp(String strPSWXEntAppId, Vector<PSWXLogic> psWXLogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null && this.fromList(psWXLogicList, psSystemStorage.getPSWXEntAppStorage((String)strPSWXEntAppId).psWXLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXLogicsByApp(strPSWXEntAppId), psWXLogicList, PSWXLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenus(String strPSWXAccountId, Vector<PSWXMenu> psWXMenuList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXAccountStorage(strPSWXAccountId) != null && this.fromList(psWXMenuList, psSystemStorage.getPSWXAccountStorage((String)strPSWXAccountId).psWXMenuList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXMenus(strPSWXAccountId), psWXMenuList, PSWXMenu.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenusByApp(String strPSWXEntAppId, Vector<PSWXMenu> psWXMenuList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSWXEntAppStorage(strPSWXEntAppId) != null && this.fromList(psWXMenuList, psSystemStorage.getPSWXEntAppStorage((String)strPSWXEntAppId).psWXMenuList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSWXMenusByApp(strPSWXEntAppId), psWXMenuList, PSWXMenu.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSWXMenu(String strPSWXMenuId, PSWXMenu psWXMenu) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psWXMenuStorageMap.get(strPSWXMenuId) != null) {
            psSystemStorage.psWXMenuStorageMap.get((Object)strPSWXMenuId).psWXMenu.CopyTo(psWXMenu, false);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSWXMenu(strPSWXMenuId), psWXMenu, "SYSTEM");
    }

    @Override
    public CallResult getAllPSCtrlMsgs(String strPSSystemId, Vector<PSCtrlMsg> psCtrlMsgList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psCtrlMsgList, psCtrlMsgList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSCtrlMsgs(strPSSystemId), psCtrlMsgList, PSCtrlMsg.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSCtrlMsg(String strPSCtrlMsgId, PSCtrlMsg psCtrlMsg) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psCtrlMsgMap.get(strPSCtrlMsgId) != null) {
            psSystemStorage.psCtrlMsgMap.get(strPSCtrlMsgId).CopyTo(psCtrlMsg, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSCtrlMsg(strPSCtrlMsgId), psCtrlMsg, "SYSTEM");
    }

    @Override
    public CallResult getPSCtrlMsgItems(String strPSCtrlMsgId, Vector<PSCtrlMsgItem> psCtrlMsgItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSCtrlMsgStorage(strPSCtrlMsgId) != null) {
            for (PSCtrlMsgItem psCtrlMsgItem : psSystemStorage.getPSCtrlMsgStorage((String)strPSCtrlMsgId).psCtrlMsgItemList) {
                PSCtrlMsgItem psCtrlMsgItem2 = new PSCtrlMsgItem();
                psCtrlMsgItem.CopyTo(psCtrlMsgItem2, true);
                psCtrlMsgItemList.add(psCtrlMsgItem2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSCtrlMsgItems(strPSCtrlMsgId), psCtrlMsgItemList, PSCtrlMsgItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUnits(String strPSSystemId, Vector<PSSysUnit> psSysUnitList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysUnitList, psSysUnitList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUnits(strPSSystemId), psSysUnitList, PSSysUnit.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUnit(String strPSSysUnitId, PSSysUnit psSysUnit) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUnitMap.get(strPSSysUnitId) != null) {
            psSystemStorage.psSysUnitMap.get(strPSSysUnitId).CopyTo(psSysUnit, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUnit(strPSSysUnitId), psSysUnit, "SYSTEM");
    }

    @Override
    public CallResult getAllPSLanguageReses(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psLanguageResList != null) {
            psLanguageResList.addAll(psSystemStorage.psLanguageResList);
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSLanguageReses(strPSSystemId), psLanguageResList, PSLanguageRes.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSLanguageRes(String strPSLanguageResId, PSLanguageRes psLanguageRes) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psLanguageResMap.get(strPSLanguageResId) != null) {
            psSystemStorage.psLanguageResMap.get(strPSLanguageResId).CopyTo(psLanguageRes, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSLanguageRes(strPSLanguageResId), psLanguageRes, "SYSTEM");
    }

    @Override
    public CallResult getAllPSLanguageItems(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psLanguageItemList != null) {
            psLanguageItemList.addAll(psSystemStorage.psLanguageItemList);
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSLanguageItems(strPSSystemId), psLanguageItemList, PSLanguageItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSLanguageItem(String strPSLanguageItemId, PSLanguageItem psLanguageItem) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psLanguageItemMap.get(strPSLanguageItemId) != null) {
            psSystemStorage.psLanguageItemMap.get(strPSLanguageItemId).CopyTo(psLanguageItem, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSLanguageItem(strPSLanguageItemId), psLanguageItem, "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppPkgs(String strPSApplicationId, Vector<PSAppPkg> psAppPkgs) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppPkgs, psSysAppStorage.psAppPkgList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppPkgs(strPSApplicationId), psAppPkgs, PSAppPkg.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysLans(String strPSSystemId, Vector<PSAppLan> psAppLans) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psAppLans, psSystemStorage.psSysLanList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysLans(strPSSystemId), psAppLans, PSAppLan.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSDEFInputTipSets(String strPSSystemId, Vector<PSDEFInputTipSet> psDEFInputTipSetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDEFInputTipSetList, psSystemStorage.psDEFInputTipSetList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSDEFInputTipSets(strPSSystemId), psDEFInputTipSetList, PSDEFInputTipSet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFInputTipSet(String strPSDEFInputTipSetId, PSDEFInputTipSet psDEFInputTipSet) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEFInputTipSetMap.get(strPSDEFInputTipSetId) != null) {
            psSystemStorage.psDEFInputTipSetMap.get(strPSDEFInputTipSetId).CopyTo(psDEFInputTipSet, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEFInputTipSet(strPSDEFInputTipSetId), psDEFInputTipSet, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUniStates(String strPSSystemId, Vector<PSSysUniState> psSysUniStateList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUniStateList, psSystemStorage.psSysUniStateList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUniStates(strPSSystemId), psSysUniStateList, PSSysUniState.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUniState(String strPSSysUniStateId, PSSysUniState psSysUniState) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUniStateMap.get(strPSSysUniStateId) != null) {
            psSystemStorage.psSysUniStateMap.get(strPSSysUniStateId).CopyTo(psSysUniState, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUniState(strPSSysUniStateId), psSysUniState, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDEFTypes(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysDEFTypeList, psSysDEFTypeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDEFTypes(strPSSystemId), psSysDEFTypeList, PSSysDEFType.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDEFType(String strPSSysDEFTypeId, PSSysDEFType psSysDEFType) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDEFTypeMap.get(strPSSysDEFTypeId) != null) {
            psSystemStorage.psSysDEFTypeMap.get(strPSSysDEFTypeId).CopyTo(psSysDEFType, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDEFType(strPSSysDEFTypeId), psSysDEFType, "SYSTEM");
    }

    @Override
    public CallResult getAllPSMobAppStartPages(String strPSApplicationId, Vector<PSMobAppStartPage> psMobAppStartPages) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psMobAppStartPages, psSysAppStorage.psMobAppStartPageList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSMobAppStartPages(strPSApplicationId), psMobAppStartPages, PSMobAppStartPage.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSMobAppPacks(String strPSApplicationId, Vector<PSMobAppPack> psMobAppPacks) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psMobAppPacks, psSysAppStorage.psMobAppPackList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSMobAppPacks(strPSApplicationId), psMobAppPacks, PSMobAppPack.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSMobAppPackTDs(String strPSMobAppPackId, Vector<PSMobAppPackTD> psMobAppPackTDList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psMobAppPackStorageMap.get(strPSMobAppPackId) != null) {
            for (PSMobAppPackTD psMobAppPackTD : psSysAppStorage.psMobAppPackStorageMap.get((Object)strPSMobAppPackId).psMobAppPackTDList) {
                PSMobAppPackTD psMobAppPackTD2 = new PSMobAppPackTD();
                psMobAppPackTD.CopyTo(psMobAppPackTD2, true);
                psMobAppPackTDList.add(psMobAppPackTD2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSMobAppPackTDs(strPSMobAppPackId), psMobAppPackTDList, PSMobAppPackTD.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSMobAppPackCerts(String strPSApplicationId, Vector<PSDCMobAppPackCert> psMobAppPackCerts) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psMobAppPackCerts, psSysAppStorage.psDCMobAppPackCertList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSMobAppPackCerts(strPSApplicationId), psMobAppPackCerts, PSDCMobAppPackCert.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysLogics(String strPSSystemId, Vector<PSSysLogic> psSysLogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysLogicList, psSysLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysLogics(strPSSystemId), psSysLogicList, PSSysLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysLogic(String strPSSysLogicId, PSSysLogic psSysLogic) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysLogicMap.get(strPSSysLogicId) != null) {
            psSystemStorage.psSysLogicMap.get(strPSSysLogicId).CopyTo(psSysLogic, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysLogic(strPSSysLogicId), psSysLogic, "SYSTEM");
    }

    @Override
    public CallResult getPSDEUniStates(String strPSDataEntityId, Vector<PSSysUniState> psDEUniStateList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEUniStateList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEUniStateList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUniStates(strPSDataEntityId), psDEUniStateList, PSSysUniState.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSearchBars(String strPSSystemId, Vector<PSSysSearchBar> psSysSearchBarList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysSearchBarList, psSysAppStorage.psSysSearchBarList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSearchBars(strPSSystemId), psSysSearchBarList, PSSysSearchBar.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchBar(String strPSSysSearchBarId, PSSysSearchBar psSysSearchBar) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysSearchBarStorageMap.containsKey(strPSSysSearchBarId)) {
            psSysAppStorage.psSysSearchBarStorageMap.get((Object)strPSSysSearchBarId).psSysSearchBar.CopyTo(psSysSearchBar, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSearchBar(strPSSysSearchBarId), psSysSearchBar, "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchBarItems(String strPSSysSearchBarId, Vector<PSSysSearchBarItem> psSysSearchBarItemList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysSearchBarStorageMap.containsKey(strPSSysSearchBarId) && this.fromList(psSysSearchBarItemList, psSysAppStorage.getPSSysSearchBarStorage((String)strPSSysSearchBarId).psSysSearchBarItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchBarItems(strPSSysSearchBarId), psSysSearchBarItemList, PSSysSearchBarItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEServiceAPIs(String strPSDEId, Vector<PSDEServiceAPI> psDEServiceAPIList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEServiceAPIList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEServiceAPIList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEServiceAPIs(strPSDEId), psDEServiceAPIList, PSDEServiceAPI.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDESADetails(String strPSDEServiceAPIId, Vector<PSDESADetail> psDESADetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null) {
            if (psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false) != null) {
                for (PSDESADetail psDESADetail : psSystemStorage.getPSDEServiceAPIStorage((String)strPSDEServiceAPIId, (boolean)false).psDESADetailList) {
                    PSDESADetail psDESADetail2 = new PSDESADetail();
                    psDESADetail.CopyTo(psDESADetail2, true);
                    psDESADetailList.add(psDESADetail2);
                }
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDESADetails(strPSDEServiceAPIId), psDESADetailList, PSDESADetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysServiceAPIs(String strPSSystemId, Vector<PSSysServiceAPI> psSysServiceAPIList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysServiceAPIList, psSystemStorage.psSysServiceAPIList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysServiceAPIs(strPSSystemId), psSysServiceAPIList, PSSysServiceAPI.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysServiceAPI(String strPSSysServiceAPIId, PSSysServiceAPI psSysServiceAPI) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null) {
            psSystemStorage.getPSSysServiceAPIStorage((String)strPSSysServiceAPIId, (boolean)false).psSysServiceAPI.CopyTo(psSysServiceAPI, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysServiceAPI(strPSSysServiceAPIId), psSysServiceAPI, "SYSTEM");
    }

    @Override
    public CallResult getPSDEServiceAPIsBySSA(String strPSSysServiceAPIId, Vector<PSDEServiceAPI> psDEServiceAPIList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null && this.fromList(psDEServiceAPIList, psSystemStorage.getPSSysServiceAPIStorage((String)strPSSysServiceAPIId, (boolean)false).psDEServiceAPIList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEServiceAPIsBySSA(strPSSysServiceAPIId), psDEServiceAPIList, PSDEServiceAPI.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDTSQueues(String strPSDataEntityId, Vector<PSDEDTSQueue> psDEDTSQueueList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDTSQueueList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDTSQueueList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDTSQueues(strPSDataEntityId), psDEDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDTSQueues(String strPSSystemId, Vector<PSSysDTSQueue> psSysDTSQueueList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysDTSQueueList, psSystemStorage.psSysDTSQueueList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDTSQueues(strPSSystemId), psSysDTSQueueList, PSSysDTSQueue.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDTSQueue(String strPSSysDTSQueueId, PSSysDTSQueue psSysDTSQueue) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDTSQueueMap.get(strPSSysDTSQueueId) != null) {
            psSystemStorage.psSysDTSQueueMap.get(strPSSysDTSQueueId).CopyTo(psSysDTSQueue, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDTSQueue(strPSSysDTSQueueId), psSysDTSQueue, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSubSysServiceAPIs(String strPSSystemId, Vector<PSSubSysServiceAPI> psSubSysServiceAPIList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSubSysServiceAPIList, psSystemStorage.psSubSysServiceAPIList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSubSysServiceAPIs(strPSSystemId), psSubSysServiceAPIList, PSSubSysServiceAPI.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSubSysServiceAPI(String strPSSubSysServiceAPIId, PSSubSysServiceAPI psSubSysServiceAPI) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null) {
            psSystemStorage.getPSSubSysServiceAPIStorage((String)strPSSubSysServiceAPIId, (boolean)false).psSubSysServiceAPI.CopyTo(psSubSysServiceAPI, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSubSysServiceAPI(strPSSubSysServiceAPIId), psSubSysServiceAPI, "SYSTEM");
    }

    @Override
    public CallResult getPSSubSysSADetails(String strPSSubSysServiceAPIId, Vector<PSSubSysSADetail> psSubSysSADetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null && this.fromList(psSubSysSADetailList, psSystemStorage.getPSSubSysServiceAPIStorage((String)strPSSubSysServiceAPIId, (boolean)false).psSubSysSADetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSubSysSADetails(strPSSubSysServiceAPIId), psSubSysSADetailList, PSSubSysSADetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEUserRoles(String strPSDEId, Vector<PSDEUserRole> psDEUserRoleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEUserRoleList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEUserRoleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUserRoles(strPSDEId), psDEUserRoleList, PSDEUserRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUserRoles(String strPSDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUSERROLE t1 where  t1.PSDEID='%1$s'  AND t1.VALIDFLAG = 1 ", (Object)strPSDEId);
    }

    public CallResult getPSDEUserRolesBySystem(String strPSSystemId, Vector<PSDEUserRole> psDEUserRoleList) {
        return this.selectMulti(this.getSQL_getPSDEUserRolesBySystem(strPSSystemId), psDEUserRoleList, PSDEUserRole.class.getName(), "SYSTEM");
    }

    protected String getSQL_getPSDEUserRolesBySystem(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDEUSERROLE t1  inner join  t_srfpsdataentity t2 on t1.psdeid = t2.psdataentityid where  t2.PSSYSTEMID ='%1$s'  and (t2.DYNAMODELFLAG IS NULL OR t2.DYNAMODELFLAG = 0)  AND t1.VALIDFLAG = 1  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEOPPrivRoles(String strPSDEId, Vector<PSDEOPPrivRole> psDEOPPrivRoleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEOPPrivRoleList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEOPPrivRoleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEOPPrivRoles(strPSDEId), psDEOPPrivRoleList, PSDEOPPrivRole.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUserRoles(String strPSSystemId, Vector<PSSysUserRole> psSysUserRoleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysUserRoleList, psSysUserRoleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUserRoles(strPSSystemId), psSysUserRoleList, PSSysUserRole.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserRole(String strPSSysUserRoleId, PSSysUserRole psSysUserRole) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null) {
            if (psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null) {
                psSystemStorage.getPSSysUserRoleStorage((String)strPSSysUserRoleId).psSysUserRole.CopyTo(psSysUserRole, true);
            }
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUserRole(strPSSysUserRoleId), psSysUserRole, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDashboards(String strPSSystemId, Vector<PSSysDashboard> psSysDashboardList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysDashboardList, psSysAppStorage.psSysDashboardList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDashboards(strPSSystemId), psSysDashboardList, PSSysDashboard.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDashboard(String strPSSysDashboardId, PSSysDashboard psSysDashboard) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysDashboardStorageMap.containsKey(strPSSysDashboardId)) {
            psSysAppStorage.psSysDashboardStorageMap.get((Object)strPSSysDashboardId).psSysDashboard.CopyTo(psSysDashboard, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDashboard(strPSSysDashboardId), psSysDashboard, "SYSTEM");
    }

    @Override
    public CallResult getPSSysDashboardParts(String strPSSysDashboardId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysDashboardStorageMap.containsKey(strPSSysDashboardId) && this.fromList(psSysDashboardPartList, psSysAppStorage.getPSSysDashboardStorage((String)strPSSysDashboardId).psSysDashboardPartList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDashboardParts(strPSSysDashboardId), psSysDashboardPartList, PSSysDashboardPart.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserRoleReses(String strPSSysUserRoleId, Vector<PSSysUserRoleRes> psSysUserRoleResList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null && this.fromList(psSysUserRoleResList, psSystemStorage.getPSSysUserRoleStorage((String)strPSSysUserRoleId).psSysUserRoleResList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysUserRoleRess(strPSSysUserRoleId), psSysUserRoleResList, PSSysUserRoleRes.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUserRoleDatas(String strPSSysUserRoleId, Vector<PSSysUserRoleData> psSysUserRoleDataList) {
        if (this.getModelInstVer() < 635) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysUserRoleStorage(strPSSysUserRoleId) != null && this.fromList(psSysUserRoleDataList, psSystemStorage.getPSSysUserRoleStorage((String)strPSSysUserRoleId).psSysUserRoleDataList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysUserRoleDatas(strPSSysUserRoleId), psSysUserRoleDataList, PSSysUserRoleData.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppLocalDEs(String strPSApplicationId, Vector<PSAppLocalDE> psAppLocalDEs) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppLocalDEs, psSysAppStorage.psAppLocalDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppLocalDEs(strPSApplicationId), psAppLocalDEs, PSAppLocalDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSFPlugins(String strPSSystemId, Vector<PSSysSFPlugin> psSysSFPluginList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysSFPluginList, psSysSFPluginList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSFPlugins(strPSSystemId), psSysSFPluginList, PSSysSFPlugin.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSFPlugin(String strPSSysSFPluginId, PSSysSFPlugin psSysSFPlugin) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSFPluginMap.get(strPSSysSFPluginId) != null) {
            psSystemStorage.psSysSFPluginMap.get(strPSSysSFPluginId).CopyTo(psSysSFPlugin, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSFPlugin(strPSSysSFPluginId), psSysSFPlugin, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSFPluginTempls(String strPSSystemId, Vector<PSSysSFPluginTempl> psSysSFPluginTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysSFPluginTemplList, psSysSFPluginTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSFPluginTempls(strPSSystemId), psSysSFPluginTemplList, PSSysSFPluginTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSFPluginTempl(String strPSSysSFPluginTemplId, PSSysSFPluginTempl psSysSFPluginTempl) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSFPluginTemplMap.get(strPSSysSFPluginTemplId) != null) {
            psSystemStorage.psSysSFPluginTemplMap.get(strPSSysSFPluginTemplId).CopyTo(psSysSFPluginTempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSFPluginTempl(strPSSysSFPluginTemplId), psSysSFPluginTempl, "SYSTEM");
    }

    @Override
    public CallResult getPSDEUtils(String strPSDEId, Vector<PSDEUtil> psDEUtilList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDEUtilList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDEUtilList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEUtils(strPSDEId), psDEUtilList, PSDEUtil.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysUtils(String strPSSystemId, Vector<PSSysUtil> psSysUtilList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysUtilList, psSystemStorage.psSysUtilList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysUtils(strPSSystemId), psSysUtilList, PSSysUtil.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysUtil(String strPSSysUtilId, PSSysUtil psSysUtil) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysUtilMap.get(strPSSysUtilId) != null) {
            psSystemStorage.psSysUtilMap.get(strPSSysUtilId).CopyTo(psSysUtil, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysUtil(strPSSysUtilId), psSysUtil, "SYSTEM");
    }

    @Override
    public CallResult getPSSVNServer(String strPSSVNServerId, PSSVNServer psSVNServer) {
        return this.selectSingle(this.getSQL_getPSSVNServer(strPSSVNServerId), psSVNServer, "SYSTEM");
    }

    protected String getSQL_getPSSVNServer(String strPSSVNServerId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSVNSERVER t1 where  t1.PSSVNSERVERID='%1$s'  and t1.VALIDFLAG >= 1 ", (Object)strPSSVNServerId);
    }

    @Override
    public CallResult getPSDevSlnSysWSGit(String strPSDevSlnSysWSGitId, PSDevSlnSysWSGit psDevSlnSysWSGit) {
        return this.selectSingle(this.getSQL_getPSDevSlnSysWSGit(strPSDevSlnSysWSGitId), psDevSlnSysWSGit, "SYSTEM");
    }

    protected String getSQL_getPSDevSlnSysWSGit(String strPSDevSlnSysWSGitId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEVSLNSYSWSGIT t1 where t1.PSDEVSLNSYSWSGITID='%1$s'  ", (Object)strPSDevSlnSysWSGitId);
    }

    public CallResult getAllPSSysTitleBars2(String strPSSystemId, Vector<PSSysTitleBar> psSysTitleBarList) {
        return this.selectMulti(this.getSQL_getAllPSSysTitleBars(strPSSystemId), psSysTitleBarList, PSSysTitleBar.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysTitleBars(String strPSSystemId, Vector<PSSysTitleBar> psSysTitleBarList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysTitleBarList, psSysAppStorage.psSysTitleBarList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysTitleBars(strPSSystemId), psSysTitleBarList, PSSysTitleBar.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSSysTitleBars(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTITLEBAR t1 where t1.PSSYSTEMID='%1$s' ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSysTitleBar(String strPSSysTitleBarId, PSSysTitleBar psSysTitleBar) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysTitleBarStorageMap.containsKey(strPSSysTitleBarId)) {
            psSysAppStorage.psSysTitleBarStorageMap.get((Object)strPSSysTitleBarId).psSysTitleBar.CopyTo(psSysTitleBar, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysTitleBar(strPSSysTitleBarId), psSysTitleBar, "SYSTEM");
    }

    protected String getSQL_getPSSysTitleBar(String strPSSysTitleBarId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSSYSTITLEBAR t1 where  t1.PSSYSTITLEBARID='%1$s'", (Object)strPSSysTitleBarId);
    }

    @Override
    public CallResult getPSAppTitleBar(String strPSAppTitleBarId, PSAppTitleBar psAppTitleBar) {
        return this.selectSingle(this.getSQL_getPSAppTitleBar(strPSAppTitleBarId), psAppTitleBar, "SYSTEM");
    }

    protected String getSQL_getPSAppTitleBar(String strPSAppTitleBarId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPTITLEBAR t1 where  t1.PSAPPTITLEBARID='%1$s'  ", (Object)strPSAppTitleBarId);
    }

    @Override
    public CallResult getAllPSAppTitleBars(String strPSApplicationId, Vector<PSAppTitleBar> psAppTitleBars) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppTitleBars, psSysAppStorage.psAppTitleBarList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppTitleBars(strPSApplicationId), psAppTitleBars, PSAppTitleBar.class.getName(), "SYSTEM");
    }

    public CallResult getAllPSAppTitleBars2(String strPSApplicationId, Vector<PSAppTitleBar> psAppTitleBars) {
        return this.selectMulti(this.getSQL_getAllPSAppTitleBars(strPSApplicationId), psAppTitleBars, PSAppTitleBar.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSAppTitleBars(String strPSApplicationId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSAPPTITLEBAR t1 where  t1.PSSYSAPPID='%1$s' ", (Object)strPSApplicationId);
    }

    @Override
    public CallResult getPSDBServer(String strPSDBServerId, PSDBServer psDBServer) {
        return this.selectSingle(this.getSQL_getPSDBServer(strPSDBServerId), psDBServer, "SYSTEM");
    }

    protected String getSQL_getPSDBServer(String strPSDBServerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSDBSERVER t1 where  t1.PSDBSERVERID='%1$s'", (Object)strPSDBServerId);
    }

    @Override
    public CallResult getAllPSSysDMVers(String strPSSystemId, Vector<PSSysDMVer> psSysDMVerList) {
        if (this.getModelInstVer() < 340) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDMVers(strPSSystemId), psSysDMVerList, PSSysDMVer.class.getName(), "SYSTEM", true);
    }

    protected String getSQL_getAllPSSysDMVers(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSYSDMVER t1 where t1.PSSYSTEMID='%1$s' AND t1.VALIDFLAG = 1", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSSFStyleParam(String strPSSFStyleParamId, PSSFStyleParam psSFStyleParam) {
        if (this.getModelInstVer() < 353) {
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSFStyleParam(strPSSFStyleParamId), psSFStyleParam, "SYSTEM");
    }

    protected String getSQL_getPSSFStyleParam(String strPSSFStyleParamId) {
        return StringHelper.Format((String)"select t1.* from V_SRFPSSFSTYLEPARAM t1 where  t1.PSSFSTYLEPARAMID='%1$s'", (Object)strPSSFStyleParamId);
    }

    public CallResult getAllPSDEActionTempls2(String strPSSystemId, Vector<PSDEActionTempl> psDEActionTemplList) {
        return this.selectMulti(this.getSQL_getAllPSDEActionTempls(strPSSystemId), psDEActionTemplList, PSDEActionTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSDEActionTempls(String strPSSystemId, Vector<PSDEActionTempl> psDEActionTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psDEActionTemplList, psDEActionTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSDEActionTempls(strPSSystemId), psDEActionTemplList, PSDEActionTempl.class.getName(), "SYSTEM");
    }

    protected String getSQL_getAllPSDEActionTempls(String strPSSystemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFPSDEACTIONTEMPL t1 where t1.PSSYSTEMID='%1$s'  ", (Object)strPSSystemId);
    }

    @Override
    public CallResult getPSDEActionTempl(String strPSDEActionTemplId, PSDEActionTempl psDEActionTempl) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDEActionTemplMap.get(strPSDEActionTemplId) != null) {
            psSystemStorage.psDEActionTemplMap.get(strPSDEActionTemplId).CopyTo(psDEActionTempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEActionTempl(strPSDEActionTemplId), psDEActionTempl, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysCalendars(String strPSSystemId, Vector<PSSysCalendar> psSysCalendarList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysCalendarList, psSysAppStorage.psSysCalendarList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysCalendars(strPSSystemId), psSysCalendarList, PSSysCalendar.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCalendar(String strPSSysCalendarId, PSSysCalendar psSysCalendar) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.containsKey(strPSSysCalendarId)) {
            psSysAppStorage.psSysCalendarStorageMap.get((Object)strPSSysCalendarId).psSysCalendar.CopyTo(psSysCalendar, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysCalendar(strPSSysCalendarId), psSysCalendar, "SYSTEM");
    }

    @Override
    public CallResult getPSSysCalendarItems(String strPSSysCalendarId, Vector<PSSysCalendarItem> psSysCalendarItemList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.containsKey(strPSSysCalendarId) && this.fromList(psSysCalendarItemList, psSysAppStorage.getPSSysCalendarStorage((String)strPSSysCalendarId).psSysCalendarItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysCalendarItems(strPSSysCalendarId), psSysCalendarItemList, PSSysCalendarItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCalendarItemRVs(String strPSSysCalendarId, Vector<PSSysCalendarItemRV> psSysCalendarItemRVList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId) != null) {
            for (PSSysCalendarItemRV psSysCalendarItemRV : psSysAppStorage.psSysCalendarStorageMap.get((Object)strPSSysCalendarId).psSysCalendarItemRVList) {
                PSSysCalendarItemRV psSysCalendarItemRV2 = new PSSysCalendarItemRV();
                psSysCalendarItemRV.CopyTo(psSysCalendarItemRV2, true);
                psSysCalendarItemRVList.add(psSysCalendarItemRV2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysCalendarItemRVs(strPSSysCalendarId), psSysCalendarItemRVList, PSSysCalendarItemRV.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDESampleDatas(String strPSDataEntityId, Vector<PSDESampleData> psDESampleDataList) {
        if (this.getModelInstVer() < 387) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDESampleDataList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDESampleDataList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDESampleDatas(strPSDataEntityId), psDESampleDataList, PSDESampleData.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPanels(String strPSSystemId, Vector<PSSysPanel> psSysPanelList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysPanelList, psSysAppStorage.psSysPanelList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPanels(strPSSystemId), psSysPanelList, PSSysPanel.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPanel(String strPSSysPanelId, PSSysPanel psSysPanel) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId)) {
            psSysAppStorage.psSysPanelStorageMap.get((Object)strPSSysPanelId).psSysPanel.CopyTo(psSysPanel, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPanel(strPSSysPanelId), psSysPanel, "SYSTEM");
    }

    @Override
    public CallResult getPSSysPanelItems(String strPSSysPanelId, Vector<PSSysPanelItem> psSysPanelItemList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId) && this.fromList(psSysPanelItemList, psSysAppStorage.getPSSysPanelStorage((String)strPSSysPanelId).psSysPanelItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysPanelItems(strPSSysPanelId), psSysPanelItemList, PSSysPanelItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPanelModels(String strPSSysPanelId, Vector<PSSysPanelModel> psSysPanelModelList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId) && this.fromList(psSysPanelModelList, psSysAppStorage.getPSSysPanelStorage((String)strPSSysPanelId).psSysPanelModelList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysPanelModels(strPSSysPanelId), psSysPanelModelList, PSSysPanelModel.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelEngines(String strPSPanelId, Vector<PSPanelEngine> psPanelEngineList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSPanelId) && this.fromList(psPanelEngineList, psSysAppStorage.getPSSysPanelStorage((String)strPSPanelId).psPanelEngineList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelEngines(strPSPanelId), psPanelEngineList, PSPanelEngine.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelItemLogics(String strPSSysPanelId, Vector<PSPanelItemLogic> psPanelItemLogicList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId) && this.fromList(psPanelItemLogicList, psSysAppStorage.getPSSysPanelStorage((String)strPSSysPanelId).psPanelItemLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelItemLogics(strPSSysPanelId), psPanelItemLogicList, PSPanelItemLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPanelLogics(String strPSSysPanelId, Vector<PSSysPanelLogic> psSysPanelLogicList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysPanelStorageMap.containsKey(strPSSysPanelId) && this.fromList(psSysPanelLogicList, psSysAppStorage.getPSSysPanelStorage((String)strPSSysPanelId).psSysPanelLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysPanelLogics(strPSSysPanelId), psSysPanelLogicList, PSSysPanelLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelLogicParams(String strPSPanelLogicId, Vector<PSPanelLogicParam> psPanelLogicParamList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId) && this.fromList(psPanelLogicParamList, psSysAppStorage.getPSPanelLogicStorage((String)strPSPanelLogicId).psPanelLogicParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelLogicParams(strPSPanelLogicId), psPanelLogicParamList, PSPanelLogicParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelLogicNodes(String strPSPanelLogicId, Vector<PSPanelLogicNode> psPanelLogicNodeList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId) && this.fromList(psPanelLogicNodeList, psSysAppStorage.getPSPanelLogicStorage((String)strPSPanelLogicId).psPanelLogicNodeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelLogicNodes(strPSPanelLogicId), psPanelLogicNodeList, PSPanelLogicNode.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelLogicLinks(String strPSPanelLogicId, Vector<PSPanelLogicLink> psPanelLogicLinkList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId) && this.fromList(psPanelLogicLinkList, psSysAppStorage.getPSPanelLogicStorage((String)strPSPanelLogicId).psPanelLogicLinkList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelLogicLinks(strPSPanelLogicId), psPanelLogicLinkList, PSPanelLogicLink.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelLogicNodeParams(String strPSPanelLogicId, Vector<PSPanelLogicNodeParam> psPanelLogicNodeParamList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId) && this.fromList(psPanelLogicNodeParamList, psSysAppStorage.getPSPanelLogicStorage((String)strPSPanelLogicId).psPanelLogicNodeParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelLogicNodeParams(strPSPanelLogicId), psPanelLogicNodeParamList, PSPanelLogicNodeParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSPanelLogicLinkConds(String strPSPanelLogicId, Vector<PSPanelLogicLinkCond> psPanelLogicLinkCondList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psPanelLogicStorageMap.containsKey(strPSPanelLogicId) && this.fromList(psPanelLogicLinkCondList, psSysAppStorage.getPSPanelLogicStorage((String)strPSPanelLogicId).psPanelLogicLinkCondList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSPanelLogicLinkConds(strPSPanelLogicId), psPanelLogicLinkCondList, PSPanelLogicLinkCond.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppUIStyles(String strPSApplicationId, Vector<PSAppUIStyle> psAppUIStyles) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppUIStyles, psSysAppStorage.psAppUIStyleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppUIStyles(strPSApplicationId), psAppUIStyles, PSAppUIStyle.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSDynaDETempls(String strPSSystemId, Vector<PSDynaDETempl> psDynaDETemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDynaDETemplList, psSystemStorage.psDynaDETemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSDynaDETempls(strPSSystemId), psDynaDETemplList, PSDynaDETempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDynaDETempl(String strPSDynaDETemplId, PSDynaDETempl psDynaDETempl) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDynaDETemplMap.get(strPSDynaDETemplId) != null) {
            psSystemStorage.psDynaDETemplMap.get(strPSDynaDETemplId).CopyTo(psDynaDETempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDynaDETempl(strPSDynaDETemplId), psDynaDETempl, "SYSTEM");
    }

    @Override
    public CallResult getPSDynaDEViewTempl(String strPSDynaDEViewTemplId, PSDynaDEViewTempl psDynaDEViewTempl) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDynaDEViewTemplMap.get(strPSDynaDEViewTemplId) != null) {
            psSysAppStorage.psDynaDEViewTemplMap.get(strPSDynaDEViewTemplId).CopyTo(psDynaDEViewTempl, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDynaDEViewTempl(strPSDynaDEViewTemplId), psDynaDEViewTempl, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysServiceAPIHandlers(String strPSSystemId, Vector<PSSysServiceAPIHandler> psSysServiceAPIHandlerList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysServiceAPIHandlerList, psSystemStorage.psSysServiceAPIHandlerList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysServiceAPIHandlers(strPSSystemId), psSysServiceAPIHandlerList, PSSysServiceAPIHandler.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysServiceAPIHandler(String strPSSysServiceAPIHandlerId, PSSysServiceAPIHandler psSysServiceAPIHandler) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIHandlerStorage(strPSSysServiceAPIHandlerId, false) != null) {
            psSystemStorage.getPSSysServiceAPIHandlerStorage((String)strPSSysServiceAPIHandlerId, (boolean)false).psSysServiceAPIHandler.CopyTo(psSysServiceAPIHandler, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysServiceAPIHandler(strPSSysServiceAPIHandlerId), psSysServiceAPIHandler, "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppPDTViews(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViews) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppPDTViews, psSysAppStorage.psAppPDTViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppPDTViews(strPSApplicationId), psAppPDTViews, PSAppPDTView.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDynaDEViewTempls(String strPSDynaDETemplId, Vector<PSDynaDEViewTempl> psDynaDEViewTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId) != null && this.fromList(psDynaDEViewTemplList, psSystemStorage.getPSDynaDETemplStorage((String)strPSDynaDETemplId).psDynaDEViewTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDynaDEViewTempls(strPSDynaDETemplId), psDynaDEViewTemplList, PSDynaDEViewTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDynaDEFormTempls(String strPSDynaDETemplId, Vector<PSDynaDEFormTempl> psDynaDEFormTemplList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDynaDETemplStorage(strPSDynaDETemplId) != null && this.fromList(psDynaDEFormTemplList, psSystemStorage.getPSDynaDETemplStorage((String)strPSDynaDETemplId).psDynaDEFormTemplList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDynaDEFormTempls(strPSDynaDETemplId), psDynaDEFormTemplList, PSDynaDEFormTempl.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysViewLogicParams(String strPSSysViewLogicId, Vector<PSSysViewLogicParam> psSysViewLogicParamList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysViewLogicStorage(strPSSysViewLogicId) != null && this.fromList(psSysViewLogicParamList, psSystemStorage.getPSSysViewLogicStorage((String)strPSSysViewLogicId).psSysViewLogicParamList)) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSSysViewLogicStorage(strPSSysViewLogicId) != null && this.fromList(psSysViewLogicParamList, psSysAppStorage.getPSSysViewLogicStorage((String)strPSSysViewLogicId).psSysViewLogicParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysViewLogicParams(strPSSysViewLogicId), psSysViewLogicParamList, PSSysViewLogicParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysFiles(String strPSSystemId, Vector<PSSysFile> psSysFileList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysFileList, psSysFileList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysFiles(strPSSystemId), psSysFileList, PSSysFile.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysFile(String strPSSysFileId, PSSysFile psSysFile) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysFileMap.get(strPSSysFileId) != null) {
            psSystemStorage.psSysFileMap.get(strPSSysFileId).CopyTo(psSysFile, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysFile(strPSSysFileId), psSysFile, "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppWFs(String strPSApplicationId, Vector<PSAppWF> psAppWFs) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppWFs, psSysAppStorage.psAppWFList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppWFs(strPSApplicationId), psAppWFs, PSAppWF.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppWFVers(String strPSApplicationId, Vector<PSAppWFVer> psAppWFVers) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppWFVers, psSysAppStorage.psAppWFVerList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppWFVers(strPSApplicationId), psAppWFVers, PSAppWFVer.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFGroups(String strPSDataEntityId, Vector<PSDEFGroup> psDEFGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEFGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEFGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFGroups(strPSDataEntityId), psDEFGroupList, PSDEFGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFGroupDetails(String strPSDEFGroupId, Vector<PSDEFGroupDetail> psDEFGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null && this.fromList(psDEFGroupDetailList, psSystemStorage.getPSDEFGroupStorage((String)strPSDEFGroupId).psDEFGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFGroupDetails(strPSDEFGroupId), psDEFGroupDetailList, PSDEFGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEServiceAPIRSs(String strPSSysServiceAPIId, Vector<PSDESARS> psDEServiceAPIRSList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysServiceAPIStorage(strPSSysServiceAPIId, false) != null && this.fromList(psDEServiceAPIRSList, psSystemStorage.getPSSysServiceAPIStorage((String)strPSSysServiceAPIId, (boolean)false).psDEServiceAPIRSList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEServiceAPIRSs(strPSSysServiceAPIId), psDEServiceAPIRSList, PSDESARS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppDERSs(String strPSApplicationId, Vector<PSAppDERS> psAppDERSs) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppDERSs, psSysAppStorage.psAppDERSList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppDERSs(strPSApplicationId), psAppDERSs, PSAppDERS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSubSysSADEs(String strPSSubSysServiceAPIId, Vector<PSSubSysSADE> psSubSysSADEList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null && this.fromList(psSubSysSADEList, psSystemStorage.getPSSubSysServiceAPIStorage((String)strPSSubSysServiceAPIId, (boolean)false).psSubSysSADEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSubSysSADEs(strPSSubSysServiceAPIId), psSubSysSADEList, PSSubSysSADE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSubSysSADERSs(String strPSSubSysServiceAPIId, Vector<PSSubSysSADERS> psSubSysSADERSList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSubSysServiceAPIStorage(strPSSubSysServiceAPIId, false) != null && this.fromList(psSubSysSADERSList, psSystemStorage.getPSSubSysServiceAPIStorage((String)strPSSubSysServiceAPIId, (boolean)false).psSubSysSADERSList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSubSysSADERSs(strPSSubSysServiceAPIId), psSubSysSADERSList, PSSubSysSADERS.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSubSysSADEFields(String strPSSubSysSADEId, Vector<PSSubSysSADEField> psSubSysSADEFieldList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSubSysSADEStorage(strPSSubSysSADEId, false) != null && this.fromList(psSubSysSADEFieldList, psSystemStorage.getPSSubSysSADEStorage((String)strPSSubSysSADEId, (boolean)false).psSubSysSADEFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSubSysSADEFields(strPSSubSysSADEId), psSubSysSADEFieldList, PSSubSysSADEField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDBSchemes(String strPSSystemId, Vector<PSSysDBScheme> psSysDBSchemeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysDBSchemeList, psSystemStorage.psSysDBSchemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDBSchemes(strPSSystemId), psSysDBSchemeList, PSSysDBScheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDBScheme(String strPSSysDBSchemeId, PSSysDBScheme psSysDBScheme) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysDBSchemeMap.get(strPSSysDBSchemeId) != null) {
            psSystemStorage.psSysDBSchemeMap.get(strPSSysDBSchemeId).CopyTo(psSysDBScheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysDBScheme(strPSSysDBSchemeId), psSysDBScheme, "SYSTEM");
    }

    @Override
    public CallResult getPSSysDBColumns(String strPSSysDBTableId, Vector<PSSysDBColumn> psSysDBColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysDBTableStorage(strPSSysDBTableId) != null && this.fromList(psSysDBColumnList, psSystemStorage.getPSSysDBTableStorage((String)strPSSysDBTableId).psSysDBColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDBColumns(strPSSysDBTableId), psSysDBColumnList, PSSysDBColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDBTables(String strPSSysDBSchemeId, Vector<PSSysDBTable> psSysDBTableList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysDBSchemeStorage(strPSSysDBSchemeId) != null && this.fromList(psSysDBTableList, psSystemStorage.getPSSysDBSchemeStorage((String)strPSSysDBSchemeId).psSysDBTableList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDBTables(strPSSysDBSchemeId), psSysDBTableList, PSSysDBTable.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDESAVRs(String strPSDEServiceAPIId, Vector<PSDESAVR> psDESAVRList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null) {
            if (psSystemStorage.getPSDEServiceAPIStorage(strPSDEServiceAPIId, false) != null) {
                for (PSDESAVR psDESAVR : psSystemStorage.getPSDEServiceAPIStorage((String)strPSDEServiceAPIId, (boolean)false).psDESAVRList) {
                    PSDESAVR psDESAVR2 = new PSDESAVR();
                    psDESAVR.CopyTo(psDESAVR2, true);
                    psDESAVRList.add(psDESAVR2);
                }
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDESAVRs(strPSDEServiceAPIId), psDESAVRList, PSDESAVR.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysResources(String strPSSystemId, Vector<PSSysResource> psSysResourceList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysResourceList, psSystemStorage.psSysResourceList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysResources(strPSSystemId), psSysResourceList, PSSysResource.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysResource(String strPSSysResourceId, PSSysResource psSysResource) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysResourceMap.get(strPSSysResourceId) != null) {
            psSystemStorage.psSysResourceMap.get(strPSSysResourceId).CopyTo(psSysResource, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysResource(strPSSysResourceId), psSysResource, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysContentCats(String strPSSystemId, Vector<PSSysContentCat> psSysContentCatList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysContentCatList, psSystemStorage.psSysContentCatList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysContentCats(strPSSystemId), psSysContentCatList, PSSysContentCat.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysContentCat(String strPSSysContentCatId, PSSysContentCat psSysContentCat) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null) {
            psSystemStorage.getPSSysContentCatStorage((String)strPSSysContentCatId).psSysContentCat.CopyTo(psSysContentCat, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysContentCat(strPSSysContentCatId), psSysContentCat, "SYSTEM");
    }

    @Override
    public CallResult getPSSysContentCats(String strPSSysContentCatId, Vector<PSSysContentCat> psSysContentCatList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null && this.fromList(psSysContentCatList, psSystemStorage.getPSSysContentCatStorage((String)strPSSysContentCatId).psSysContentCatList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysContentCats(strPSSysContentCatId), psSysContentCatList, PSSysContent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysContents(String strPSSysContentCatId, Vector<PSSysContent> psSysContentList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysContentCatStorage(strPSSysContentCatId) != null && this.fromList(psSysContentList, psSystemStorage.getPSSysContentCatStorage((String)strPSSysContentCatId).psSysContentList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysContents(strPSSysContentCatId), psSysContentList, PSSysContent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysContent(String strPSSysContentId, PSSysContent psSysContent) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysContentMap.get(strPSSysContentId) != null) {
            psSystemStorage.psSysContentMap.get(strPSSysContentId).CopyTo(psSysContent, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysContent(strPSSysContentId), psSysContent, "SYSTEM");
    }

    public CallResult getAllPSAppResources2(String strPSApplicationId, Vector<PSAppResource> psAppResources) {
        return this.selectMulti(this.getSQL_getAllPSAppResources(strPSApplicationId), psAppResources, PSAppResource.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppResources(String strPSApplicationId, Vector<PSAppResource> psAppResources) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppResources, psSysAppStorage.psAppResourceList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppResources(strPSApplicationId), psAppResources, PSAppResource.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGroups(strPSDataEntityId), psDEGroupList, PSDEGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEGroupDetails(String strPSDEGroupId, Vector<PSDEGroupDetail> psDEGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEGroupStorage(strPSDEGroupId) != null && this.fromList(psDEGroupDetailList, psSystemStorage.getPSDEGroupStorage((String)strPSDEGroupId).psDEGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGroupDetails(strPSDEGroupId), psDEGroupDetailList, PSDEGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDERGroups(String strPSDataEntityId, Vector<PSDERGroup> psDERGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDERGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDERGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDERGroups(strPSDataEntityId), psDERGroupList, PSDERGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDERGroupDetails(String strPSDERGroupId, Vector<PSDERGroupDetail> psDERGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDERGroupStorage(strPSDERGroupId) != null && this.fromList(psDERGroupDetailList, psSystemStorage.getPSDERGroupStorage((String)strPSDERGroupId).psDERGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDERGroupDetails(strPSDERGroupId), psDERGroupDetailList, PSDERGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDEGroups(String strPSSystemId, Vector<PSDEGroup> psDEGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDEGroupList, psSystemStorage.psDEGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDEGroups(strPSSystemId), psDEGroupList, PSDEGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDERGroups(String strPSSystemId, Vector<PSDERGroup> psDERGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psDERGroupList, psSystemStorage.psDERGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDERGroups(strPSSystemId), psDERGroupList, PSDERGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionGroups(String strPSDataEntityId, Vector<PSDEActionGroup> psDEActionGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEActionGroupList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEActionGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionGroups(strPSDataEntityId), psDEActionGroupList, PSDEActionGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionGroupDetails(String strPSDEActionGroupId, Vector<PSDEAGDetail> psDEActionGroupDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionGroupStorage(strPSDEActionGroupId) != null && this.fromList(psDEActionGroupDetailList, psSystemStorage.getPSDEActionGroupStorage((String)strPSDEActionGroupId).psDEActionGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionGroupDetails(strPSDEActionGroupId), psDEActionGroupDetailList, PSDEAGDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysTestPrjs(String strPSSystemId, Vector<PSSysTestPrj> psSysTestPrjList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysTestPrjList, psSystemStorage.psSysTestPrjList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysTestPrjs(strPSSystemId), psSysTestPrjList, PSSysTestPrj.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestPrj(String strPSSysTestPrjId, PSSysTestPrj psSysTestPrj) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysTestPrjMap.get(strPSSysTestPrjId) != null) {
            psSystemStorage.psSysTestPrjMap.get(strPSSysTestPrjId).CopyTo(psSysTestPrj, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysTestPrj(strPSSysTestPrjId), psSysTestPrj, "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestModules(String strPSSysTestPrjId, Vector<PSSysTestModule> psSysTestModuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysTestPrjStorage(strPSSysTestPrjId) != null && this.fromList(psSysTestModuleList, psSystemStorage.getPSSysTestPrjStorage((String)strPSSysTestPrjId).psSysTestModuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysTestModules(strPSSysTestPrjId), psSysTestModuleList, PSSysTestModule.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTestCases(String strPSSysTestModuleId, Vector<PSSysTestCase> psSysTestCaseList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysTestModuleStorage(strPSSysTestModuleId) != null && this.fromList(psSysTestCaseList, psSystemStorage.getPSSysTestModuleStorage((String)strPSSysTestModuleId).psSysTestCaseList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysTestCases(strPSSysTestModuleId), psSysTestCaseList, PSSysTestCase.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysReqModules(String strPSSystemId, Vector<PSSysReqModule> psSysReqModuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysReqModuleList, psSystemStorage.psSysReqModuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysReqModules(strPSSystemId), psSysReqModuleList, PSSysReqModule.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysReqModule(String strPSSysReqModuleId, PSSysReqModule psSysReqModule) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId) != null) {
            psSystemStorage.getPSSysReqModuleStorage((String)strPSSysReqModuleId).psSysReqModule.CopyTo(psSysReqModule, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysReqModule(strPSSysReqModuleId), psSysReqModule, "SYSTEM");
    }

    @Override
    public CallResult getPSSysReqModules(String strPSSysReqModuleId, Vector<PSSysReqModule> psSysReqModuleList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysReqModuleStorage(strPSSysReqModuleId) != null && this.fromList(psSysReqModuleList, psSystemStorage.getPSSysReqModuleStorage((String)strPSSysReqModuleId).psSysReqModuleList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysReqModules(strPSSysReqModuleId), psSysReqModuleList, PSSysReqItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysReqItems(String strPSSystemId, Vector<PSSysReqItem> psSysReqItemList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysReqItemList, psSystemStorage.psSysReqItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysReqItems(strPSSystemId), psSysReqItemList, PSSysReqItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysReqItem(String strPSSysReqItemId, PSSysReqItem psSysReqItem) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysReqItemMap.get(strPSSysReqItemId) != null) {
            psSystemStorage.psSysReqItemMap.get(strPSSysReqItemId).CopyTo(psSysReqItem, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysReqItem(strPSSysReqItemId), psSysReqItem, "SYSTEM");
    }

    @Override
    public CallResult getPSDEDBTables(String strPSDataEntityId, Vector<PSDEDBTable> psDEDBTableList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psDEDBTableList, psSystemStorage.getPSDataEntityStorage((String)strPSDataEntityId).psDEDBTableList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDBTables(strPSDataEntityId), psDEDBTableList, PSDEDBTable.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSDataEntityStorage(strPSDataEntityId) != null && this.fromList(psCtrlLogicGroupList, psSysAppStorage.getPSDataEntityStorage((String)strPSDataEntityId).psCtrlLogicGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSCtrlLogicGroups(strPSDataEntityId), psCtrlLogicGroupList, PSCtrlLogicGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSCtrlLogicGroupDetails(String strPSCtrlLogicGroupId, Vector<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.getPSCtrlLogicGroupStorage(strPSCtrlLogicGroupId) != null && this.fromList(psCtrlLogicGroupDetailList, psSysAppStorage.getPSCtrlLogicGroupStorage((String)strPSCtrlLogicGroupId).psCtrlLogicGroupDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSCtrlLogicGroupDetails(strPSCtrlLogicGroupId), psCtrlLogicGroupDetailList, PSCtrlLogicGroupDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCtrlLogicGroups(String strPSSystemId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psCtrlLogicGroupList, psSysAppStorage.psCtrlLogicGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysCtrlLogicGroups(strPSSystemId), psCtrlLogicGroupList, PSCtrlLogicGroup.class.getName(), "SYSTEM");
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
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysSearchSchemeList, psSystemStorage.psSysSearchSchemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSearchSchemes(strPSSystemId), psSysSearchSchemeList, PSSysSearchScheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchScheme(String strPSSysSearchSchemeId, PSSysSearchScheme psSysSearchScheme) {
        if (this.getModelInstVer() < 611) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSearchSchemeMap.get(strPSSysSearchSchemeId) != null) {
            psSystemStorage.psSysSearchSchemeMap.get(strPSSysSearchSchemeId).CopyTo(psSysSearchScheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSearchScheme(strPSSysSearchSchemeId), psSysSearchScheme, "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchDocs(String strPSSysSearchSchemeId, Vector<PSSysSearchDoc> psSysSearchDocList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId) != null && this.fromList(psSysSearchDocList, psSystemStorage.getPSSysSearchSchemeStorage((String)strPSSysSearchSchemeId).psSysSearchDocList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchDocs(strPSSysSearchSchemeId), psSysSearchDocList, PSSysSearchDoc.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchDEs(String strPSSysSearchSchemeId, Vector<PSSysSearchDE> psSysSearchDEList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysSearchSchemeStorage(strPSSysSearchSchemeId) != null && this.fromList(psSysSearchDEList, psSystemStorage.getPSSysSearchSchemeStorage((String)strPSSysSearchSchemeId).psSysSearchDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchDEs(strPSSysSearchSchemeId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchFields(String strPSSysSearchDocId, Vector<PSSysSearchField> psSysSearchFieldList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysSearchDocStorage(strPSSysSearchDocId) != null && this.fromList(psSysSearchFieldList, psSystemStorage.getPSSysSearchDocStorage((String)strPSSysSearchDocId).psSysSearchFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchFields(strPSSysSearchDocId), psSysSearchFieldList, PSSysSearchField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchDEFields(String strPSSysSearchDEId, Vector<PSSysSearchDEField> psSysSearchDEFieldList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysSearchDEStorage(strPSSysSearchDEId) != null && this.fromList(psSysSearchDEFieldList, psSystemStorage.getPSSysSearchDEStorage((String)strPSSysSearchDEId).psSysSearchDEFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchDEFields(strPSSysSearchDEId), psSysSearchDEFieldList, PSSysSearchDEField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDESearchs(String strPSDEId, Vector<PSSysSearchDE> psSysSearchDEList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psSysSearchDEList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDESearchList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDESearchs(strPSDEId), psSysSearchDEList, PSSysSearchDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchDEFieldsByDataEntity(String strPSDEId, Vector<PSSysSearchDEField> psSysSearchDEFieldList) {
        if (this.getModelInstVer() < 611) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psSysSearchDEFieldList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psSysSearchDEFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchDEFieldsByDataEntity(strPSDEId), psSysSearchDEFieldList, PSSysSearchDEField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysMapViews(String strPSSystemId, Vector<PSSysMapView> psSysMapViewList) {
        if (this.getModelInstVer() < 614) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psSysMapViewList, psSysAppStorage.psSysMapViewList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysMapViews(strPSSystemId), psSysMapViewList, PSSysMapView.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysMapView(String strPSSysMapViewId, PSSysMapView psSysMapView) {
        if (this.getModelInstVer() < 614) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysMapViewStorageMap.containsKey(strPSSysMapViewId)) {
            psSysAppStorage.psSysMapViewStorageMap.get((Object)strPSSysMapViewId).psSysMapView.CopyTo(psSysMapView, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysMapView(strPSSysMapViewId), psSysMapView, "SYSTEM");
    }

    @Override
    public CallResult getPSSysMapItems(String strPSSysMapViewId, Vector<PSSysMapItem> psSysMapItemList) {
        if (this.getModelInstVer() < 614) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysMapViewStorageMap.containsKey(strPSSysMapViewId) && this.fromList(psSysMapItemList, psSysAppStorage.getPSSysMapViewStorage((String)strPSSysMapViewId).psSysMapItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysMapItems(strPSSysMapViewId), psSysMapItemList, PSSysMapItem.class.getName(), "SYSTEM");
    }

    public CallResult getAllPSAppUtils2(String strPSApplicationId, Vector<PSAppUtil> psAppUtils) {
        return this.selectMulti(this.getSQL_getAllPSAppUtils(strPSApplicationId), psAppUtils, PSAppUtil.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppUtils(String strPSApplicationId, Vector<PSAppUtil> psAppUtils) {
        if (this.getModelInstVer() < 629) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppUtils, psSysAppStorage.psAppUtilList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppUtils(strPSApplicationId), psAppUtils, PSAppUtil.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppUtil(String strPSAppUtilId, PSAppUtil psAppUtil) {
        if (this.getModelInstVer() < 629) {
            return CallResult.create((int)3);
        }
        return this.selectSingle(this.getSQL_getPSAppUtil(strPSAppUtilId), psAppUtil, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysPortletCats(String strPSSystemId, Vector<PSSysPortletCat> psSysPortletCatList) {
        if (this.getModelInstVer() < 630) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psSysPortletCatList, psSysPortletCatList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysPortletCats(strPSSystemId), psSysPortletCatList, PSSysPortletCat.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysPortletCat(String strPSSysPortletCatId, PSSysPortletCat psSysPortletCat) {
        if (this.getModelInstVer() < 630) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysPortletCatMap.get(strPSSysPortletCatId) != null) {
            psSystemStorage.psSysPortletCatMap.get(strPSSysPortletCatId).CopyTo(psSysPortletCat, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysPortletCat(strPSSysPortletCatId), psSysPortletCat, "SYSTEM");
    }

    public CallResult getAllPSAppPortlets2(String strPSApplicationId, Vector<PSAppPortlet> psAppPortlets) {
        return this.selectMulti(this.getSQL_getAllPSAppPortlets(strPSApplicationId), psAppPortlets, PSAppPortlet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppPortlets(String strPSApplicationId, Vector<PSAppPortlet> psAppPortlets) {
        if (this.getModelInstVer() < 630) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppPortlets, psSysAppStorage.psAppPortletList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppPortlets(strPSApplicationId), psAppPortlets, PSAppPortlet.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppPortlet(String strPSAppPortletId, PSAppPortlet psAppPortlet) {
        if (this.getModelInstVer() < 630) {
            return CallResult.create((int)3);
        }
        return this.selectSingle(this.getSQL_getPSAppPortlet(strPSAppPortletId), psAppPortlet, "SYSTEM");
    }

    public CallResult getAllPSAppPFPlugins2(String strPSApplicationId, Vector<PSAppPFPlugin> psAppPFPlugins) {
        return this.selectMulti(this.getSQL_getAllPSAppPFPlugins(strPSApplicationId), psAppPFPlugins, PSAppPFPlugin.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppPFPlugins(String strPSApplicationId, Vector<PSAppPFPlugin> psAppPFPlugins) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppPFPlugins, psSysAppStorage.psAppPFPluginList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSAppPFPlugins(strPSApplicationId), psAppPFPlugins, PSAppPFPlugin.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEGridEditItemVRs(String strPSDEGridId, Vector<PSDEGridEditItemVR> psDEGridEditItemVRList) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null && this.fromList(psDEGridEditItemVRList, psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGridEditItemVRList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGridEditItemVRs(strPSDEGridId), psDEGridEditItemVRList, PSDEGridEditItemVR.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEWizard(String strPSDEWizardId, PSDEWizard psDEWizard) {
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEWizardStorageMap.containsKey(strPSDEWizardId)) {
            psSysAppStorage.psDEWizardStorageMap.get((Object)strPSDEWizardId).psDEWizard.CopyTo(psDEWizard, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSDEWizard(strPSDEWizardId), psDEWizard, "SYSTEM");
    }

    @Override
    public CallResult getPSDEActionVRs(String strPSDEActionId, Vector<PSDEActionVR> psDEActionVRList) {
        if (this.getModelInstVer() < 657) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEActionStorage(strPSDEActionId) != null) {
            for (PSDEActionVR psDEActionVR : psSystemStorage.getPSDEActionStorage((String)strPSDEActionId).psDEActionVRList) {
                PSDEActionVR psDEActionVR2 = new PSDEActionVR();
                psDEActionVR.CopyTo(psDEActionVR2, true);
                psDEActionVRList.add(psDEActionVR2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEActionVRs(strPSDEActionId), psDEActionVRList, PSDEActionVR.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEMainStateFields(String strPSDEMainStateId, Vector<PSDEMainStateField> psDEMainStateFieldList) {
        if (this.getModelInstVer() < 659) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEMainStateStorage(strPSDEMainStateId) != null) {
            for (PSDEMainStateField psDEMainStateField : psSystemStorage.getPSDEMainStateStorage((String)strPSDEMainStateId).psDEMainStateFieldList) {
                PSDEMainStateField psDEMainStateField2 = new PSDEMainStateField();
                psDEMainStateField.CopyTo(psDEMainStateField2, true);
                psDEMainStateFieldList.add(psDEMainStateField2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEMainStateFields(strPSDEMainStateId), psDEMainStateFieldList, PSDEMainStateField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFGroupItems(String strPSDEFGroupId, Vector<PSDEFormDetail> psDEFormDetailList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null && this.fromList(psDEFormDetailList, psSystemStorage.getPSDEFGroupStorage((String)strPSDEFGroupId).psDEFormDetailList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFGroupItems(strPSDEFGroupId), psDEFormDetailList, PSDEFormDetail.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFGroupColumns(String strPSDEFGroupId, Vector<PSDEGridColumn> psDEGridColumnList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEFGroupStorage(strPSDEFGroupId) != null && this.fromList(psDEGridColumnList, psSystemStorage.getPSDEFGroupStorage((String)strPSDEFGroupId).psDEGridColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFGroupColumns(strPSDEFGroupId), psDEGridColumnList, PSDEGridColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysSequences(String strPSSystemId, Vector<PSSysSequence> psSysSequenceList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysSequenceList, psSystemStorage.psSysSequenceList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysSequences(strPSSystemId), psSysSequenceList, PSSysSequence.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSequence(String strPSSysSequenceId, PSSysSequence psSysSequence) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysSequenceMap.get(strPSSysSequenceId) != null) {
            psSystemStorage.psSysSequenceMap.get(strPSSysSequenceId).CopyTo(psSysSequence, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysSequence(strPSSysSequenceId), psSysSequence, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysTranslators(String strPSSystemId, Vector<PSSysTranslator> psSysTranslatorList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysTranslatorList, psSystemStorage.psSysTranslatorList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysTranslators(strPSSystemId), psSysTranslatorList, PSSysTranslator.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysTranslator(String strPSSysTranslatorId, PSSysTranslator psSysTranslator) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysTranslatorMap.get(strPSSysTranslatorId) != null) {
            psSystemStorage.psSysTranslatorMap.get(strPSSysTranslatorId).CopyTo(psSysTranslator, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysTranslator(strPSSysTranslatorId), psSysTranslator, "SYSTEM");
    }

    @Override
    public CallResult getPSWFUtilUIActions(String strPSSysWFSettingId, Vector<PSWFUtilUIAction> psWFUtilUIActionList) {
        return this.selectMulti(this.getSQL_getPSWFUtilUIActions(strPSSysWFSettingId), psWFUtilUIActionList, PSWFUtilUIAction.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysMsgTargets(String strPSSystemId, Vector<PSSysMsgTarget> psSysMsgTargetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysMsgTargetList, psSystemStorage.psSysMsgTargetList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysMsgTargets(strPSSystemId), psSysMsgTargetList, PSSysMsgTarget.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysMsgQueues(String strPSSystemId, Vector<PSSysMsgQueue> psSysMsgQueueList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysMsgQueueList, psSystemStorage.psSysMsgQueueList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysMsgQueues(strPSSystemId), psSysMsgQueueList, PSSysMsgQueue.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDENotifies(String strPSDEId, Vector<PSDENotify> psDENotifyList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDataEntityStorage(strPSDEId) != null && this.fromList(psDENotifyList, psSystemStorage.getPSDataEntityStorage((String)strPSDEId).psDENotifyList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDENotifies(strPSDEId), psDENotifyList, PSDENotify.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDENotifyTargets(String strPSDENotifyId, Vector<PSDENotifyTarget> psDENotifyTargetList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psDENotifyStorageMap.get(strPSDENotifyId) != null) {
            for (PSDENotifyTarget psDENotifyTarget : psSystemStorage.psDENotifyStorageMap.get((Object)strPSDENotifyId).psDENotifyTargetList) {
                PSDENotifyTarget psDENotifyTarget2 = new PSDENotifyTarget();
                psDENotifyTarget.CopyTo(psDENotifyTarget2, true);
                psDENotifyTargetList.add(psDENotifyTarget2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDENotifyTargets(strPSDENotifyId), psDENotifyTargetList, PSDENotifyTarget.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysEAISchemes(String strPSSystemId, Vector<PSSysEAIScheme> psSysEAISchemeList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysEAISchemeList, psSystemStorage.psSysEAISchemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysEAISchemes(strPSSystemId), psSysEAISchemeList, PSSysEAIScheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIScheme(String strPSSysEAISchemeId, PSSysEAIScheme psSysEAIScheme) {
        if (this.getModelInstVer() < 697) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysEAISchemeMap.get(strPSSysEAISchemeId) != null) {
            psSystemStorage.psSysEAISchemeMap.get(strPSSysEAISchemeId).CopyTo(psSysEAIScheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysEAIScheme(strPSSysEAISchemeId), psSysEAIScheme, "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIDataTypes(String strPSSysEAISchemeId, Vector<PSSysEAIDataType> psSysEAIDataTypeList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null && this.fromList(psSysEAIDataTypeList, psSystemStorage.getPSSysEAISchemeStorage((String)strPSSysEAISchemeId).psSysEAIDataTypeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIDataTypes(strPSSysEAISchemeId), psSysEAIDataTypeList, PSSysEAIDataType.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIDataTypeItems(String strPSSysEAIDataTypeId, Vector<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAIDataTypeStorage(strPSSysEAIDataTypeId) != null && this.fromList(psSysEAIDataTypeItemList, psSystemStorage.getPSSysEAIDataTypeStorage((String)strPSSysEAIDataTypeId).psSysEAIDataTypeItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIDataTypeItems(strPSSysEAIDataTypeId), psSysEAIDataTypeItemList, PSSysEAIDataTypeItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIElements(String strPSSysEAISchemeId, Vector<PSSysEAIElement> psSysEAIElementList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null && this.fromList(psSysEAIElementList, psSystemStorage.getPSSysEAISchemeStorage((String)strPSSysEAISchemeId).psSysEAIElementList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIElements(strPSSysEAISchemeId), psSysEAIElementList, PSSysEAIElement.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIElementAttrs(String strPSSysEAIElementId, Vector<PSSysEAIElementAttr> psSysEAIElementAttrList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId) != null && this.fromList(psSysEAIElementAttrList, psSystemStorage.getPSSysEAIElementStorage((String)strPSSysEAIElementId).psSysEAIElementAttrList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIElementAttrs(strPSSysEAIElementId), psSysEAIElementAttrList, PSSysEAIElementAttr.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIElementREs(String strPSSysEAIElementId, Vector<PSSysEAIElementRE> psSysEAIElementREList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAIElementStorage(strPSSysEAIElementId) != null && this.fromList(psSysEAIElementREList, psSystemStorage.getPSSysEAIElementStorage((String)strPSSysEAIElementId).psSysEAIElementREList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIElementREs(strPSSysEAIElementId), psSysEAIElementREList, PSSysEAIElementRE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIDEs(String strPSSysEAISchemeId, Vector<PSSysEAIDE> psSysEAIDEList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAISchemeStorage(strPSSysEAISchemeId) != null && this.fromList(psSysEAIDEList, psSystemStorage.getPSSysEAISchemeStorage((String)strPSSysEAISchemeId).psSysEAIDEList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIDEs(strPSSysEAISchemeId), psSysEAIDEList, PSSysEAIDE.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIDEFields(String strPSSysEAIDEId, Vector<PSSysEAIDEField> psSysEAIDEFieldList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId) != null && this.fromList(psSysEAIDEFieldList, psSystemStorage.getPSSysEAIDEStorage((String)strPSSysEAIDEId).psSysEAIDEFieldList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIDEFields(strPSSysEAIDEId), psSysEAIDEFieldList, PSSysEAIDEField.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysEAIDERs(String strPSSysEAIDEId, Vector<PSSysEAIDER> psSysEAIDERList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysEAIDEStorage(strPSSysEAIDEId) != null && this.fromList(psSysEAIDERList, psSystemStorage.getPSSysEAIDEStorage((String)strPSSysEAIDEId).psSysEAIDERList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysEAIDERs(strPSSysEAIDEId), psSysEAIDERList, PSSysEAIDER.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysBISchemes(String strPSSystemId, Vector<PSSysBIScheme> psSysBISchemeList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysBISchemeList, psSystemStorage.psSysBISchemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysBISchemes(strPSSystemId), psSysBISchemeList, PSSysBIScheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIScheme(String strPSSysBISchemeId, PSSysBIScheme psSysBIScheme) {
        if (this.getModelInstVer() < 697) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysBISchemeMap.get(strPSSysBISchemeId) != null) {
            psSystemStorage.psSysBISchemeMap.get(strPSSysBISchemeId).CopyTo(psSysBIScheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysBIScheme(strPSSysBISchemeId), psSysBIScheme, "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIDimensions(String strPSSysBISchemeId, Vector<PSSysBIDimension> psSysBIDimensionList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null && this.fromList(psSysBIDimensionList, psSystemStorage.getPSSysBISchemeStorage((String)strPSSysBISchemeId).psSysBIDimensionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIDimensions(strPSSysBISchemeId), psSysBIDimensionList, PSSysBIDimension.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIHierarchies(String strPSSysBIDimensionId, Vector<PSSysBIHierarchy> psSysBIHierarchyList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBIDimensionStorage(strPSSysBIDimensionId) != null && this.fromList(psSysBIHierarchyList, psSystemStorage.getPSSysBIDimensionStorage((String)strPSSysBIDimensionId).psSysBIHierarchyList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIHierarchies(strPSSysBIDimensionId), psSysBIHierarchyList, PSSysBIHierarchy.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBILevels(String strPSSysBIHierarchyId, Vector<PSSysBILevel> psSysBILevelList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBIHierarchyStorage(strPSSysBIHierarchyId) != null && this.fromList(psSysBILevelList, psSystemStorage.getPSSysBIHierarchyStorage((String)strPSSysBIHierarchyId).psSysBILevelList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBILevels(strPSSysBIHierarchyId), psSysBILevelList, PSSysBILevel.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBICubes(String strPSSysBISchemeId, Vector<PSSysBICube> psSysBICubeList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null && this.fromList(psSysBICubeList, psSystemStorage.getPSSysBISchemeStorage((String)strPSSysBISchemeId).psSysBICubeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBICubes(strPSSysBISchemeId), psSysBICubeList, PSSysBICube.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBICubeDimensions(String strPSSysBICubeId, Vector<PSSysBICubeDimension> psSysBICubeDimensionList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId) != null && this.fromList(psSysBICubeDimensionList, psSystemStorage.getPSSysBICubeStorage((String)strPSSysBICubeId).psSysBICubeDimensionList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBICubeDimensions(strPSSysBICubeId), psSysBICubeDimensionList, PSSysBICubeDimension.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBICubeMeasures(String strPSSysBICubeId, Vector<PSSysBICubeMeasure> psSysBICubeMeasureList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBICubeStorage(strPSSysBICubeId) != null && this.fromList(psSysBICubeMeasureList, psSystemStorage.getPSSysBICubeStorage((String)strPSSysBICubeId).psSysBICubeMeasureList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBICubeMeasures(strPSSysBICubeId), psSysBICubeMeasureList, PSSysBICubeMeasure.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBICubeLevels(String strPSSysBIDimensionId, Vector<PSSysBICubeLevel> psSysBICubeLevelList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBICubeDimensionStorage(strPSSysBIDimensionId) != null && this.fromList(psSysBICubeLevelList, psSystemStorage.getPSSysBICubeDimensionStorage((String)strPSSysBIDimensionId).psSysBICubeLevelList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBICubeLevels(strPSSysBIDimensionId), psSysBICubeLevelList, PSSysBICubeLevel.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIAggTables(String strPSSysBISchemeId, Vector<PSSysBIAggTable> psSysBIAggTableList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null && this.fromList(psSysBIAggTableList, psSystemStorage.getPSSysBISchemeStorage((String)strPSSysBISchemeId).psSysBIAggTableList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIAggTables(strPSSysBISchemeId), psSysBIAggTableList, PSSysBIAggTable.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIAggColumns(String strPSSysBIAggTableId, Vector<PSSysBIAggColumn> psSysBIAggColumnList) {
        if (this.getModelInstVer() < 697) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBIAggTableStorage(strPSSysBIAggTableId) != null && this.fromList(psSysBIAggColumnList, psSystemStorage.getPSSysBIAggTableStorage((String)strPSSysBIAggTableId).psSysBIAggColumnList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIAggColumns(strPSSysBIAggTableId), psSysBIAggColumnList, PSSysBIAggColumn.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIReports(String strPSSysBISchemeId, Vector<PSSysBIReport> psSysBIReportList) {
        if (this.getModelInstVer() < 785) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBISchemeStorage(strPSSysBISchemeId) != null && this.fromList(psSysBIReportList, psSystemStorage.getPSSysBISchemeStorage((String)strPSSysBISchemeId).psSysBIReportList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIReports(strPSSysBISchemeId), psSysBIReportList, PSSysBIReport.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysBIReportItems(String strPSSysBIReportId, Vector<PSSysBIReportItem> psSysBIReportItemList) {
        if (this.getModelInstVer() < 785) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysBIReportStorage(strPSSysBIReportId) != null && this.fromList(psSysBIReportItemList, psSystemStorage.getPSSysBIReportStorage((String)strPSSysBIReportId).psSysBIReportItemList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysBIReportItems(strPSSysBIReportId), psSysBIReportItemList, PSSysBIReportItem.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSThresholdGroups(String strPSSystemId, Vector<PSThresholdGroup> psThresholdGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psThresholdGroupList, psThresholdGroupList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSThresholdGroups(strPSSystemId), psThresholdGroupList, PSThresholdGroup.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSThresholds(String strPSThresholdGroupId, Vector<PSThreshold> psThresholdList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSThresholdGroupStorage(strPSThresholdGroupId) != null && this.copyList(psSystemStorage.getPSThresholdGroupStorage((String)strPSThresholdGroupId).psThresholdList, psThresholdList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSThresholds(strPSThresholdGroupId), psThresholdList, PSThreshold.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSThresholdGroup(String strPSThresholdGroupId, PSThresholdGroup psThresholdGroup) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psThresholdGroupMap.get(strPSThresholdGroupId) != null) {
            psSystemStorage.psThresholdGroupMap.get(strPSThresholdGroupId).CopyTo(psThresholdGroup, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSThresholdGroup(strPSThresholdGroupId), psThresholdGroup, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysChartThemes(String strPSSystemId, Vector<PSSysChartTheme> psSysChartThemeList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysChartThemeList, psSystemStorage.psSysChartThemeList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysChartThemes(strPSSystemId), psSysChartThemeList, PSSysChartTheme.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysChartTheme(String strPSSysChartThemeId, PSSysChartTheme psSysChartTheme) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysChartThemeMap.get(strPSSysChartThemeId) != null) {
            psSystemStorage.psSysChartThemeMap.get(strPSSysChartThemeId).CopyTo(psSysChartTheme, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysChartTheme(strPSSysChartThemeId), psSysChartTheme, "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysDBValueFuncs(String strPSSystemId, Vector<PSSysDBValueFunc> psSysDBValueFuncList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysDBValueFuncList, psSystemStorage.psSysDBValueFuncList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysDBValueFuncs(strPSSystemId), psSysDBValueFuncList, PSSysDBValueFunc.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSDELogics(String strPSSystemId, Vector<PSDELogic> psDELogicList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psDELogicList, psDELogicList)) {
            return new CallResult();
        }
        return this.getPSDELogicsBySystem(strPSSystemId, psDELogicList);
    }

    @Override
    public CallResult getAllPSDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psDEUIActionList2, psDEUIActionList)) {
            return new CallResult();
        }
        return this.getPSDEUIActionsBySystem(strPSSystemId, psDEUIActionList);
    }

    @Override
    public CallResult getAllPSCtrlLogicGroups(String strPSSystemId, Vector<PSCtrlLogicGroup> psCtrlLogicGroupList) {
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.copyList(psSystemStorage.psCtrlLogicGroupList2, psCtrlLogicGroupList)) {
            return new CallResult();
        }
        return this.getPSCtrlLogicGroupsBySystem(strPSSystemId, psCtrlLogicGroupList);
    }

    @Override
    public CallResult getPSDEDSParams(String strPSDataSetId, Vector<PSDEDSParam> psDEDSParamList) {
        if (this.getModelInstVer() < 746) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEDataSetStorage(strPSDataSetId) != null && this.fromList(psDEDSParamList, psSystemStorage.getPSDEDataSetStorage((String)strPSDataSetId).psDEDSParamList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDSParams(strPSDataSetId), psDEDSParamList, PSDEDSParam.class.getName(), "SYSTEM");
    }

    public CallResult getPSDEDSParamsBySystem(String strPSSystemId, Vector<PSDEDSParam> psDEDSParamList) {
        if (this.getModelInstVer() < 746) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDSParamsBySystem(strPSSystemId), psDEDSParamList, PSDEDSParam.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEGridLogics(String strPSDEGridId, Vector<PSDEGridLogic> psDEGridLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEGridStorageMap.get(strPSDEGridId) != null && this.fromList(psDEGridLogicList, psSysAppStorage.psDEGridStorageMap.get((Object)strPSDEGridId).psDEGridLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEGridLogics(strPSDEGridId), psDEGridLogicList, PSDEGridLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEToolbarLogics(String strPSDEToolbarId, Vector<PSDEToolbarLogic> psDEToolbarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEToolbarStorageMap.get(strPSDEToolbarId) != null && this.fromList(psDEToolbarLogicList, psSysAppStorage.psDEToolbarStorageMap.get((Object)strPSDEToolbarId).psDEToolbarLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEToolbarLogics(strPSDEToolbarId), psDEToolbarLogicList, PSDEToolbarLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDETreeLogics(String strPSDETreeId, Vector<PSDETreeLogic> psDETreeLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDETreeViewStorageMap.get(strPSDETreeId) != null && this.fromList(psDETreeLogicList, psSysAppStorage.psDETreeViewStorageMap.get((Object)strPSDETreeId).psDETreeLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDETreeLogics(strPSDETreeId), psDETreeLogicList, PSDETreeLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEListLogics(String strPSDEListId, Vector<PSDEListLogic> psDEListLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEListStorageMap.get(strPSDEListId) != null && this.fromList(psDEListLogicList, psSysAppStorage.psDEListStorageMap.get((Object)strPSDEListId).psDEListLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEListLogics(strPSDEListId), psDEListLogicList, PSDEListLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSAppLogics(String strPSApplicationId, Vector<PSAppLogic> psAppLogics) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && this.fromList(psAppLogics, psSysAppStorage.psAppLogicList)) {
            return new CallResult();
        }
        return this.selectMultiValid(this.getSQL_getAllPSAppLogics(strPSApplicationId), psAppLogics, PSAppLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEFormLogics(String strPSDEFormId, Vector<PSDEFormLogic> psDEFormLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEFormStorageMap.get(strPSDEFormId) != null && this.fromList(psDEFormLogicList, psSysAppStorage.psDEFormStorageMap.get((Object)strPSDEFormId).psDEFormLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEFormLogics(strPSDEFormId), psDEFormLogicList, PSDEFormLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEDataViewLogics(String strPSDEDataViewId, Vector<PSDEDataViewLogic> psDEDataViewLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEDataViewStorageMap.get(strPSDEDataViewId) != null && this.fromList(psDEDataViewLogicList, psSysAppStorage.psDEDataViewStorageMap.get((Object)strPSDEDataViewId).psDEDataViewLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEDataViewLogics(strPSDEDataViewId), psDEDataViewLogicList, PSDEDataViewLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEWizardLogics(String strPSDEWizardId, Vector<PSDEWizardLogic> psDEWizardLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSDEWizardStorage(strPSDEWizardId) != null) {
            for (PSDEWizardLogic psDEWizardLogic : psSystemStorage.getPSDEWizardStorage((String)strPSDEWizardId).psDEWizardLogicList) {
                PSDEWizardLogic psDEWizardLogic2 = new PSDEWizardLogic();
                psDEWizardLogic.CopyTo(psDEWizardLogic2, true);
                psDEWizardLogicList.add(psDEWizardLogic2);
            }
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEWizardLogics(strPSDEWizardId), psDEWizardLogicList, PSDEWizardLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSDEChartLogics(String strPSDEChartId, Vector<PSDEChartLogic> psDEChartLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psDEChartStorageMap.get(strPSDEChartId) != null && this.fromList(psDEChartLogicList, psSysAppStorage.psDEChartStorageMap.get((Object)strPSDEChartId).psDEChartLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSDEChartLogics(strPSDEChartId), psDEChartLogicList, PSDEChartLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysCalendarLogics(String strPSSysCalendarId, Vector<PSSysCalendarLogic> psSysCalendarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysCalendarStorageMap.get(strPSSysCalendarId) != null && this.fromList(psSysCalendarLogicList, psSysAppStorage.psSysCalendarStorageMap.get((Object)strPSSysCalendarId).psSysCalendarLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysCalendarLogics(strPSSysCalendarId), psSysCalendarLogicList, PSSysCalendarLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysDashboardLogics(String strPSSysDashboardId, Vector<PSSysDashboardLogic> psSysDashboardLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysDashboardStorageMap.get(strPSSysDashboardId) != null && this.fromList(psSysDashboardLogicList, psSysAppStorage.psSysDashboardStorageMap.get((Object)strPSSysDashboardId).psSysDashboardLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysDashboardLogics(strPSSysDashboardId), psSysDashboardLogicList, PSSysDashboardLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysSearchBarLogics(String strPSSysSearchBarId, Vector<PSSysSearchBarLogic> psSysSearchBarLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysSearchBarStorageMap.get(strPSSysSearchBarId) != null && this.fromList(psSysSearchBarLogicList, psSysAppStorage.psSysSearchBarStorageMap.get((Object)strPSSysSearchBarId).psSysSearchBarLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysSearchBarLogics(strPSSysSearchBarId), psSysSearchBarLogicList, PSSysSearchBarLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysMapLogics(String strPSSysMapId, Vector<PSSysMapLogic> psSysMapLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psSysMapViewStorageMap.get(strPSSysMapId) != null && this.fromList(psSysMapLogicList, psSysAppStorage.psSysMapViewStorageMap.get((Object)strPSSysMapId).psSysMapLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysMapLogics(strPSSysMapId), psSysMapLogicList, PSSysMapLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSAppMenuLogics(String strPSAppMenuId, Vector<PSAppMenuLogic> psAppMenuLogicList) {
        if (this.getModelInstVer() < 747) {
            return new CallResult();
        }
        PSModelHelperBase.PSSysAppStorage psSysAppStorage = this.getCurrentPSSysAppStorage();
        if (psSysAppStorage != null && psSysAppStorage.psAppMenuStorageMap.get(strPSAppMenuId) != null && this.fromList(psAppMenuLogicList, psSysAppStorage.psAppMenuStorageMap.get((Object)strPSAppMenuId).psAppMenuLogicList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSAppMenuLogics(strPSAppMenuId), psAppMenuLogicList, PSAppMenuLogic.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getAllPSSysAIFactories(String strPSSystemId, Vector<PSSysAIFactory> psSysAIFactoryList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && this.fromList(psSysAIFactoryList, psSystemStorage.psSysAIFactoryList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getAllPSSysAIFactories(strPSSystemId), psSysAIFactoryList, PSSysAIFactory.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIFactory(String strPSSysAIFactoryId, PSSysAIFactory psSysAIFactory) {
        if (this.getModelInstVer() < 803) {
            return CallResult.create((int)3);
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.psSysAIFactoryMap.get(strPSSysAIFactoryId) != null) {
            psSystemStorage.psSysAIFactoryMap.get(strPSSysAIFactoryId).CopyTo(psSysAIFactory, true);
            return new CallResult();
        }
        return this.selectSingle(this.getSQL_getPSSysAIFactory(strPSSysAIFactoryId), psSysAIFactory, "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIChatAgents(String strPSSysAIFactoryId, Vector<PSSysAIChatAgent> psSysAIChatAgentList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null && this.fromList(psSysAIChatAgentList, psSystemStorage.getPSSysAIFactoryStorage((String)strPSSysAIFactoryId).psSysAIChatAgentList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysAIChatAgents(strPSSysAIFactoryId), psSysAIChatAgentList, PSSysAIChatAgent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIWorkerAgents(String strPSSysAIFactoryId, Vector<PSSysAIWorkerAgent> psSysAIWorkerAgentList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null && this.fromList(psSysAIWorkerAgentList, psSystemStorage.getPSSysAIFactoryStorage((String)strPSSysAIFactoryId).psSysAIWorkerAgentList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysAIWorkerAgents(strPSSysAIFactoryId), psSysAIWorkerAgentList, PSSysAIWorkerAgent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIPipelineAgents(String strPSSysAIFactoryId, Vector<PSSysAIPipelineAgent> psSysAIPipelineAgentList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysAIFactoryStorage(strPSSysAIFactoryId) != null && this.fromList(psSysAIPipelineAgentList, psSystemStorage.getPSSysAIFactoryStorage((String)strPSSysAIFactoryId).psSysAIPipelineAgentList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysAIPipelineAgents(strPSSysAIFactoryId), psSysAIPipelineAgentList, PSSysAIPipelineAgent.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIPipelineJobs(String strPSSysAIPipelineId, Vector<PSSysAIPipelineJob> psSysAIPipelineJobList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId) != null && this.fromList(psSysAIPipelineJobList, psSystemStorage.getPSSysAIPipelineStorage((String)strPSSysAIPipelineId).psSysAIPipelineJobList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysAIPipelineJobs(strPSSysAIPipelineId), psSysAIPipelineJobList, PSSysAIPipelineJob.class.getName(), "SYSTEM");
    }

    @Override
    public CallResult getPSSysAIPipelineWorkers(String strPSSysAIPipelineId, Vector<PSSysAIPipelineWorker> psSysAIPipelineWorkerList) {
        if (this.getModelInstVer() < 803) {
            return new CallResult();
        }
        PSModelHelperBase.PSSystemStorage psSystemStorage = this.getCurrentPSSystemStorage();
        if (psSystemStorage != null && psSystemStorage.getPSSysAIPipelineStorage(strPSSysAIPipelineId) != null && this.fromList(psSysAIPipelineWorkerList, psSystemStorage.getPSSysAIPipelineStorage((String)strPSSysAIPipelineId).psSysAIPipelineWorkerList)) {
            return new CallResult();
        }
        return this.selectMulti(this.getSQL_getPSSysAIPipelineWorkers(strPSSysAIPipelineId), psSysAIPipelineWorkerList, PSSysAIPipelineWorker.class.getName(), "SYSTEM");
    }
}

