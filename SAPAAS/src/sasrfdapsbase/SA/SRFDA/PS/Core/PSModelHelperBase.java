/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataColumn
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.IDataColumn
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.dao.PSSystemDAO
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSAppLan;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSAppLogic;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.PS.Data.PSAppMenuLogic;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFDA.PS.Data.PSAppPFPlugin;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.PS.Data.PSAppTitleBar;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSCtrlLogicGroupDetail;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
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
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFDA.PS.Data.PSLanguageRes;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFDA.PS.Data.PSMobAppPackTD;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFDA.PS.Data.PSPanelEngine;
import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.PS.Data.PSPanelLogicLinkCond;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
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
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFVersion;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemDAO;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelHelperBase
implements IPSModelHelper {
    private static final Log log = LogFactory.getLog(PSModelHelperBase.class);
    public static final String TEMPKEY = "SRFTEMPKEY:";
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strDBType = "";
    protected String strPSSysModelInstId = null;
    protected IDAO iDAO = null;
    public static final Integer MAXMODELINSTVER = 99999999;
    protected int nModelInstVer = MAXMODELINSTVER;
    protected long nLastActiveTime = 0L;
    protected long nLastSessionActiveTime = 0L;
    protected boolean bAlwaysActive = false;
    protected boolean bClear = false;
    protected HashMap<String, PSSysModelCache> psSysModelCacheMap = new HashMap();
    private boolean bUseDAOOnly = false;
    private boolean bUseTableOnly = false;

    public void setUseDAOOnly(boolean bUseDAOOnly) {
        this.bUseDAOOnly = bUseDAOOnly;
    }

    public boolean isUseDAOOnly() {
        return this.bUseDAOOnly;
    }

    public void setUseTableOnly(boolean bUseTableOnly) {
        this.bUseTableOnly = bUseTableOnly;
    }

    public boolean isUseTableOnly() {
        return this.bUseTableOnly;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected PSSysModelCache getPSSysModelCache(String strId) throws Exception {
        HashMap<String, PSSysModelCache> hashMap = this.psSysModelCacheMap;
        synchronized (hashMap) {
            PSSysModelCache psSysModelCache = this.psSysModelCacheMap.get(strId);
            if (psSysModelCache == null) {
                psSysModelCache = new PSSysModelCache();
                this.psSysModelCacheMap.put(strId, psSysModelCache);
            }
            return psSysModelCache;
        }
    }

    public String getDBStorage() {
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetCache() {
        this.active();
        HashMap<String, PSSysModelCache> hashMap = this.psSysModelCacheMap;
        synchronized (hashMap) {
            this.psSysModelCacheMap.clear();
        }
    }

    public String getDBType() {
        return this.strDBType;
    }

    protected synchronized IDAO getDAO() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSSysModelInstId())) {
            if (this.iDAO != null) {
                return this.iDAO;
            }
            PSSystemDAO psSystemDAO = (PSSystemDAO)DAOGlobal.getDAO(PSSystemDAO.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            this.iDAO = psSystemDAO;
            return this.iDAO;
        }
        if (PSSysModelInstGlobal.isEnableProxyMode()) {
            SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
            if (this.iDAO != null) {
                return this.iDAO;
            }
            PSSystemDAO psSystemDAO = (PSSystemDAO)DAOGlobal.getDAO(PSSystemDAO.class, (SessionFactory)sessionFactory);
            this.iDAO = psSystemDAO;
            return this.iDAO;
        }
        if (this.iDAO != null) {
            return this.iDAO;
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSSystemDAO psSystemDAO = (PSSystemDAO)DAOGlobal.getDAO(PSSystemDAO.class, (SessionFactory)sessionFactory);
        this.iDAO = psSystemDAO;
        return this.iDAO;
    }

    @Override
    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
        if (this.getPSSysModelInstId() != null && this.nLastSessionActiveTime + 20000L < this.nLastActiveTime) {
            this.nLastSessionActiveTime = this.nLastActiveTime;
            if (!this.isAlwaysActive()) {
                PSSysModelInstGlobal.active((String)this.strPSSysModelInstId);
            }
        }
    }

    @Override
    public void activeAlways() {
        if (this.isAlwaysActive()) {
            return;
        }
        this.bAlwaysActive = true;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysModelInstId())) {
            PSSysModelInstGlobal.activeAlways((String)this.strPSSysModelInstId);
        }
    }

    @Override
    public long getLastActiveTime() {
        if (this.isAlwaysActive()) {
            return System.currentTimeMillis();
        }
        return this.nLastActiveTime;
    }

    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    @Override
    public boolean isAlwaysActive() {
        return this.bAlwaysActive;
    }

    @Override
    public void setModelInstVer(int nModelInstVer) {
        this.nModelInstVer = nModelInstVer;
    }

    public int getModelInstVer() {
        return this.nModelInstVer;
    }

    protected CallResult selectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            long nBeginTime = System.currentTimeMillis();
            if (this.getPSSysModelInstId() == null && !this.isUseDAOOnly()) {
                if (this.isUseTableOnly()) {
                    strSQL = strSQL.replace(" V_SRFPS", " T_SRFPS");
                }
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectSingle\r\n%1$s", (Object)strSQL));
                SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
                if (selectResult == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                    return callResult;
                }
                if (selectResult.getRetCode() != 0) {
                    callResult.from((DBResult)selectResult);
                    return callResult;
                }
                if (selectResult.getMainTable() == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                    return callResult;
                }
                if (selectResult.getMainTable().GetRowCount() == 0) {
                    callResult.setRetCode(3);
                    return callResult;
                }
                this.fromDataRow(dataEntity, selectResult.getMainTable().GetRow(0), true);
                callResult.setRetCode(0);
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - nBeginTime)));
                return callResult;
            }
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            if (iDataTable.getCachedRowCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            IDataRow iDataRow = iDataTable.getCachedRow(0);
            this.fromDataRow(dataEntity, iDataRow, true);
            callResult.setRetCode(0);
            SessionFactoryManager.releaseRef((boolean)true);
            log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - nBeginTime)));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getPSSysModelInstId() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult selectSingle(String strSQL, IEntity dataEntity, String strOpPersonId) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            long nBeginTime = System.currentTimeMillis();
            if (this.getPSSysModelInstId() == null && !this.isUseDAOOnly()) {
                if (this.isUseTableOnly()) {
                    strSQL = strSQL.replace(" V_SRFPS", " T_SRFPS");
                }
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectSingle\r\n%1$s", (Object)strSQL));
                SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
                if (selectResult == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                    return callResult;
                }
                if (selectResult.getRetCode() != 0) {
                    callResult.from((DBResult)selectResult);
                    return callResult;
                }
                if (selectResult.getMainTable() == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                    return callResult;
                }
                if (selectResult.getMainTable().GetRowCount() == 0) {
                    callResult.setRetCode(3);
                    return callResult;
                }
                this.fromDataRow(dataEntity, selectResult.getMainTable().GetRow(0), true);
                callResult.setRetCode(0);
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - nBeginTime)));
                return callResult;
            }
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            if (iDataTable.getCachedRowCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            IDataRow iDataRow = iDataTable.getCachedRow(0);
            this.fromDataRow(dataEntity, iDataRow, true);
            callResult.setRetCode(0);
            SessionFactoryManager.releaseRef((boolean)true);
            log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - nBeginTime)));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getPSSysModelInstId() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult selectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        return this.selectMulti(strSQL, list, classType, strOpPersonId, false);
    }

    protected CallResult selectMulti(String strSQL, Vector list, Class classType, String strOpPersonId, boolean bSystemFields) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            long nBeginTime = System.currentTimeMillis();
            Object objSample = null;
            boolean bEntityMode = false;
            if (classType != null && (objSample = (Object)classType.newInstance()) instanceof IEntity) {
                bEntityMode = true;
            }
            if (this.getPSSysModelInstId() == null && !this.isUseDAOOnly()) {
                SelectResult selectResult;
                if (this.isUseTableOnly()) {
                    strSQL = strSQL.replace(" V_SRFPS", " T_SRFPS");
                }
                if ((selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL)) == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                    return callResult;
                }
                if (selectResult.getRetCode() != 0) {
                    callResult.from((DBResult)selectResult);
                    return callResult;
                }
                if (selectResult.getMainTable() == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                    return callResult;
                }
                int nRowCount = selectResult.getMainTable().GetRowCount();
                int i = 0;
                while (i < nRowCount) {
                    IEntity dataEntity;
                    if (bEntityMode) {
                        dataEntity = (IEntity)objSample.getClass().newInstance();
                        this.fromDataRow(dataEntity, selectResult.getMainTable().GetRow(i), bSystemFields);
                        list.add(dataEntity);
                    } else {
                        dataEntity = null;
                        if (objSample != null) {
                            dataEntity = (BaseDataEntity)objSample.getClass().newInstance();
                        } else {
                            Object obj;
                            if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                                dataEntity = (BaseDataEntity)obj;
                            }
                            if (dataEntity == null) {
                                dataEntity = new BaseDataEntity();
                            }
                        }
                        dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                        list.add(dataEntity);
                    }
                    ++i;
                }
                callResult.setRetCode(0);
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectMulti \u8017\u65f6[%1$s]ms\r\n%2$s", (Object)(System.currentTimeMillis() - nBeginTime), (Object)strSQL));
                return callResult;
            }
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            int i = 0;
            while (i < iDataTable.getCachedRowCount()) {
                IEntity dataEntity;
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                if (bEntityMode) {
                    dataEntity = (IEntity)objSample.getClass().newInstance();
                    this.fromDataRow(dataEntity, iDataRow, bSystemFields);
                    list.add(dataEntity);
                } else {
                    dataEntity = null;
                    if (objSample != null) {
                        dataEntity = (BaseDataEntity)objSample.getClass().newInstance();
                    } else {
                        Object obj;
                        if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                            dataEntity = (BaseDataEntity)obj;
                        }
                        if (dataEntity == null) {
                            dataEntity = new BaseDataEntity();
                        }
                    }
                    this.fromDataRow((BaseDataEntity)dataEntity, iDataRow, bSystemFields);
                    list.add(dataEntity);
                }
                ++i;
            }
            SessionFactoryManager.releaseRef((boolean)true);
            callResult.setRetCode(0);
            log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectMulti \u8017\u65f6[%1$s]ms\r\n%2$s", (Object)(System.currentTimeMillis() - nBeginTime), (Object)strSQL));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getPSSysModelInstId() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult selectMultiValid(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = this.selectMulti(strSQL, list, strObjectName, strOpPersonId, false);
        if (callResult.isError() || list.size() == 0) {
            return callResult;
        }
        Vector<BaseDataEntity> list2 = new Vector<BaseDataEntity>();
        for (Object obj : list) {
            BaseDataEntity item;
            if (obj instanceof BaseDataEntity) {
                item = (BaseDataEntity)obj;
                if (item.GetParamIntValue("VALIDFLAG", 1) == 0) continue;
                list2.add(item);
                continue;
            }
            if (!(obj instanceof IEntity)) continue;
            item = (IEntity)obj;
            try {
                if (DataObject.getIntegerValue((IDataObject)item, (String)"VALIDFLAG", (int)1) == 0) continue;
                list2.add(item);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        list.clear();
        list.addAll(list2);
        return callResult;
    }

    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        return this.selectMulti(strSQL, list, strObjectName, strOpPersonId, false);
    }

    protected CallResult selectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId, boolean bSystemFields) {
        this.active();
        CallResult callResult = new CallResult();
        try {
            Object objSample = null;
            boolean bEntityMode = false;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strObjectName) && (objSample = ObjectHelper.Create((String)strObjectName)) instanceof IEntity) {
                bEntityMode = true;
            }
            long nBeginTime = System.currentTimeMillis();
            if (this.getPSSysModelInstId() == null && !this.isUseDAOOnly()) {
                SelectResult selectResult;
                if (this.isUseTableOnly()) {
                    strSQL = strSQL.replace(" V_SRFPS", " T_SRFPS");
                }
                if ((selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL)) == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                    return callResult;
                }
                if (selectResult.getRetCode() != 0) {
                    callResult.from((DBResult)selectResult);
                    return callResult;
                }
                if (selectResult.getMainTable() == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                    return callResult;
                }
                int nRowCount = selectResult.getMainTable().GetRowCount();
                int i = 0;
                while (i < nRowCount) {
                    IEntity dataEntity;
                    if (bEntityMode) {
                        dataEntity = (IEntity)objSample.getClass().newInstance();
                        this.fromDataRow(dataEntity, selectResult.getMainTable().GetRow(i), bSystemFields);
                        list.add(dataEntity);
                    } else {
                        dataEntity = null;
                        if (objSample != null) {
                            dataEntity = (BaseDataEntity)objSample.getClass().newInstance();
                        } else {
                            Object obj;
                            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                                dataEntity = (BaseDataEntity)obj;
                            }
                            if (dataEntity == null) {
                                dataEntity = new BaseDataEntity();
                            }
                        }
                        this.fromDataRow((BaseDataEntity)dataEntity, selectResult.getMainTable().GetRow(i), bSystemFields);
                        list.add(dataEntity);
                    }
                    ++i;
                }
                callResult.setRetCode(0);
                log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectMulti \u8017\u65f6[%1$s]ms\r\n%2$s", (Object)(System.currentTimeMillis() - nBeginTime), (Object)strSQL));
                return callResult;
            }
            strSQL = strSQL.replace(" V_SRFPS", " V_PS");
            SessionFactoryManager.addRef();
            DBCallResult dbCallResult = this.getDAO().executeRawSql(null, strSQL, null);
            if (dbCallResult.getDataSet() == null || dbCallResult.getDataSet().getDataTableCount() == 0) {
                SessionFactoryManager.releaseRef((boolean)false);
                callResult.setRetCode(3);
                return callResult;
            }
            dbCallResult.getDataSet().cacheDataRow();
            IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
            int i = 0;
            while (i < iDataTable.getCachedRowCount()) {
                IEntity dataEntity;
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                if (bEntityMode) {
                    dataEntity = (IEntity)objSample.getClass().newInstance();
                    this.fromDataRow(dataEntity, iDataRow, bSystemFields);
                    list.add(dataEntity);
                } else {
                    dataEntity = null;
                    if (objSample != null) {
                        dataEntity = (BaseDataEntity)objSample.getClass().newInstance();
                    } else {
                        Object obj;
                        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                            dataEntity = (BaseDataEntity)obj;
                        }
                        if (dataEntity == null) {
                            dataEntity = new BaseDataEntity();
                        }
                    }
                    this.fromDataRow((BaseDataEntity)dataEntity, iDataRow, bSystemFields);
                    list.add(dataEntity);
                }
                ++i;
            }
            SessionFactoryManager.releaseRef((boolean)true);
            callResult.setRetCode(0);
            log.debug((Object)SA.SRFramework.Utility.StringHelper.Format((String)"selectSingle \u8017\u65f6[%1$s]ms\r\n%2$s", (Object)(System.currentTimeMillis() - nBeginTime), (Object)strSQL));
            return callResult;
        }
        catch (Exception ex) {
            if (this.getPSSysModelInstId() != null) {
                SessionFactoryManager.releaseRef((boolean)false);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected final void fromDataRow(BaseDataEntity dataEntity, IDataRow dr, boolean bSystemFields) throws Exception {
        if (dr == null) {
            throw new Exception("\u65e0\u6548\u6570\u636e\u96c6\u5408");
        }
        IDataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (!dr.isDBNull(i) && SA.SRFramework.Utility.StringHelper.Compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.setParamValue(dataColumn.getName(), dr.get(i));
                }
                ++i;
            }
        }
    }

    protected final void fromDataRow(BaseDataEntity dataEntity, DataRow dr, boolean bSystemFields) throws Exception {
        DataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.GetColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                DataColumn dataColumn = dataTable.GetDataColumn(i);
                if (!dr.IsDBNull(i) && SA.SRFramework.Utility.StringHelper.Compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.SetParamValue(dataColumn.getName(), dr.Get(i));
                }
                ++i;
            }
        }
    }

    protected final void fromDataRow(IEntity dataEntity, IDataRow dr, boolean bSystemFields) throws Exception {
        if (dr == null) {
            throw new Exception("\u65e0\u6548\u6570\u636e\u96c6\u5408");
        }
        IDataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (!dr.isDBNull(i) && SA.SRFramework.Utility.StringHelper.Compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.set(dataColumn.getName(), dr.get(i));
                }
                ++i;
            }
        }
    }

    protected final void fromDataRow(IEntity dataEntity, DataRow dr, boolean bSystemFields) throws Exception {
        DataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.GetColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                String strColumnName;
                DataColumn dataColumn = dataTable.GetDataColumn(i);
                if (!dr.IsDBNull(i) && SA.SRFramework.Utility.StringHelper.Compare((String)(strColumnName = dataColumn.getName()), (String)"CREATEMAN", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEMAN", (boolean)true) != 0 && (bSystemFields || SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"CREATEDATE", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)strColumnName, (String)"UPDATEDATE", (boolean)true) != 0)) {
                    dataEntity.set(dataColumn.getName(), dr.Get(i));
                }
                ++i;
            }
        }
    }

    protected boolean copyList(ArrayList src, Vector dst) {
        block7: {
            if (src.size() != 0) break block7;
            return true;
        }
        try {
            if (src.get(0) instanceof IEntity) {
                for (Object t : src) {
                    IEntity t2 = (IEntity)t.getClass().newInstance();
                    ((IEntity)t).copyTo((IDataObject)t2, false);
                    dst.add(t2);
                }
            } else {
                for (Object t : src) {
                    BaseDataEntity t2 = (BaseDataEntity)t.getClass().newInstance();
                    ((BaseDataEntity)t).CopyTo(t2, false);
                    dst.add(t2);
                }
            }
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    protected boolean fromList(Vector dst, ArrayList src) {
        block8: {
            if (dst == null || src == null) {
                log.error((Object)"\u8c03\u7528fromList\u53d1\u751f\u9519\u8bef\uff0c\u6e90\u5bf9\u8c61\u6216\u76ee\u6807\u5bf9\u8c61\u65e0\u6548");
                return false;
            }
            if (src.size() != 0) break block8;
            return true;
        }
        try {
            if (src.get(0) instanceof IEntity) {
                for (Object t : src) {
                    IEntity t2 = (IEntity)t.getClass().newInstance();
                    ((IEntity)t).copyTo((IDataObject)t2, false);
                    dst.add(t2);
                }
            } else {
                for (Object t : src) {
                    BaseDataEntity t2 = (BaseDataEntity)t.getClass().newInstance();
                    ((BaseDataEntity)t).CopyTo(t2, false);
                    dst.add(t2);
                }
            }
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    protected class PSAppMenuStorage {
        public String strPSAppMenuId = "";
        public ArrayList<PSAppMenuItem> psAppMenuItemList = new ArrayList();
        public ArrayList<PSAppMenuLogic> psAppMenuLogicList = new ArrayList();
        public PSAppMenu psAppMenu = null;
    }

    protected class PSAppTitleBarStorage {
        public String strPSAppTitleBarId = "";
        public PSAppTitleBar psAppTitleBar = null;
    }

    protected class PSAppViewStorage {
        public String strPSAppViewId = "";
        public ArrayList<PSAppViewRef> psAppViewRefList = new ArrayList();
        public ArrayList<PSAppViewLogic> psAppViewLogicList = new ArrayList();
        public PSAppView psAppView = null;
    }

    protected class PSCodeListStorage {
        public String strPSCodeListId = "";
        public ArrayList<PSCodeItem> psCodeItemList = new ArrayList();
        public PSCodeList psCodeList = null;
    }

    protected class PSCtrlLogicGroupStorage {
        public String strPSCtrlLogicGroupId = "";
        public PSCtrlLogicGroup psCtrlLogicGroup = null;
        public ArrayList<PSCtrlLogicGroupDetail> psCtrlLogicGroupDetailList = new ArrayList();
    }

    protected class PSCtrlMsgStorage {
        public String strPSCtrlMsgId = "";
        public PSCtrlMsg psCtrlMsg = null;
        public Vector<PSCtrlMsgItem> psCtrlMsgItemList = new Vector();
    }

    protected class PSDEACModeStorage {
        public String strPSDEACModeId = "";
        public PSDEACMode psDEACMode = null;
        public Vector<PSDEACModeItem> psDEACModeItemList = new Vector();
    }

    protected class PSDEActionGroupStorage {
        public String strPSDEActionGroupId = "";
        public PSDEActionGroup psDEActionGroup = null;
        public ArrayList<PSDEAGDetail> psDEActionGroupDetailList = new ArrayList();
    }

    protected class PSDEActionStorage {
        public String strPSDEActionId = "";
        public PSDEAction psDEAction = null;
        public Vector<PSDEActionLogic> psDEActionLogicList = new Vector();
        public Vector<PSDEActionParam> psDEActionParamList = new Vector();
        public Vector<PSDEActionVR> psDEActionVRList = new Vector();
    }

    protected class PSDEActionWizardGroupStorage {
        public String strPSDEActionWizardGroupId = "";
        public ArrayList<PSDEAWGrpDetail> psDEAWGrpDetailList = new ArrayList();
        public PSDEAWGroup psDEAWGroup = null;
    }

    protected class PSDEActionWizardStorage {
        public String strPSDEActionWizardId = "";
        public ArrayList<PSDEAWItem> psDEActionWizardItemList = new ArrayList();
        public PSDEActionWizard psDEActionWizard = null;
    }

    protected class PSDEChartStorage {
        public String strPSDEChartId = "";
        public ArrayList<PSDEChartAxes> psDEChartAxesList = new ArrayList();
        public ArrayList<PSDEChartSeries> psDEChartSeriesList = new ArrayList();
        public ArrayList<PSDEChartLogic> psDEChartLogicList = new ArrayList();
        public PSDEChart psDEChart = null;
    }

    protected class PSDEDBIndexStorage {
        public String strPSDEDBIndexId = "";
        public PSDEDBIndex psDEDBIndex = null;
        public ArrayList<PSDEDBIndexField> psDEDBIndexFieldList = new ArrayList();
    }

    protected class PSDEDataExportStorage {
        public String strPSDEDataExportId = "";
        public ArrayList<PSDEGridColumn> psDEGridColumnList = new ArrayList();
        public PSDEDataExport psDEDataExport = null;
    }

    protected class PSDEDataImportStorage {
        public String strPSDEDataImportId = "";
        public ArrayList<PSDEDataImportItem> psDEDataImportItemList = new ArrayList();
        public PSDEDataImport psDEDataImport = null;
    }

    protected class PSDEDataQueryCodeStorage {
        public String strPSDEDataQueryCodeId = "";
        public ArrayList<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList = new ArrayList();
        public ArrayList<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList = new ArrayList();
        public PSDEDataQueryCode psDEDataQueryCode = null;
    }

    protected class PSDEDataQueryStorage {
        public String strPSDEDataQueryId = "";
        public ArrayList<PSDEDataQueryJoin> psDEDataQueryJoinList = new ArrayList();
        public ArrayList<PSDEDataQueryCond> psDEDataQueryCondList = new ArrayList();
        public ArrayList<PSDEDataQueryCode> psDEDataQueryCodeList = new ArrayList();
        public PSDEDataQuery psDEDataQuery = null;
    }

    protected class PSDEDataRelationStorage {
        public String strPSDEDataRelationId = "";
        public Vector<PSDEDRDetail> psDEDRDetailList = new Vector();
        public PSDEDataRelation psDEDataRelation = null;
    }

    protected class PSDEDataSetStorage {
        public String strPSDEDataSetId = "";
        public ArrayList<PSDEDSDQ> psDEDSDQList = new ArrayList();
        public ArrayList<PSDEDSGroupParam> psDEDSGroupParamList = new ArrayList();
        public ArrayList<PSDEDSParam> psDEDSParamList = new ArrayList();
        public PSDEDataSet psDEDataSet = null;
    }

    protected class PSDEDataSyncStorage {
        public String strPSDEDataSyncId = "";
        public PSDEDataSync psDEDataSync = null;
    }

    protected class PSDEDataViewStorage {
        public String strPSDEDataViewId = "";
        public ArrayList<PSDEDataViewItem> psDEDataViewItemList = new ArrayList();
        public ArrayList<PSDEDataViewLogic> psDEDataViewLogicList = new ArrayList();
        public PSDEDataView psDEDataView = null;
    }

    protected class PSDEFGroupStorage {
        public String strPSDEFGroupId = "";
        public PSDEFGroup psDEFGroup = null;
        public ArrayList<PSDEFGroupDetail> psDEFGroupDetailList = new ArrayList();
        public ArrayList<PSDEFormDetail> psDEFormDetailList = new ArrayList();
        public ArrayList<PSDEGridColumn> psDEGridColumnList = new ArrayList();
    }

    protected class PSDEFValueRuleStorage {
        public String strPSDEFValueRuleId = "";
        public PSDEFValueRule psDEFValueRule = null;
        public Vector<PSDEFValueRuleCond> psDEFValueRuleCondList = new Vector();
    }

    protected class PSDEFormStorage {
        public String strPSDEFormId = "";
        public ArrayList<PSDEFormDetail> psDEFormDetailList = new ArrayList();
        public ArrayList<PSDEFDLogic> psDEFDLogicList = new ArrayList();
        public ArrayList<PSDEFIUpdate> psDEFIUpdateList = new ArrayList();
        public ArrayList<PSDEFIUDetail> psDEFIUDetailList = new ArrayList();
        public ArrayList<PSDEFormRF> psDEFormRFList = new ArrayList();
        public ArrayList<PSDEFormItemVR> psDEFormItemVRList = new ArrayList();
        public ArrayList<PSDEFormLogic> psDEFormLogicList = new ArrayList();
        public PSDEForm psDEForm = null;
    }

    protected class PSDEGridStorage {
        public String strPSDEGridId = "";
        public ArrayList<PSDEGridColumn> psDEGridColumnList = new ArrayList();
        public ArrayList<PSDEGEIUpdate> psDEGEIUpdateList = new ArrayList();
        public ArrayList<PSDEGEIUDetail> psDEGEIUDetailList = new ArrayList();
        public ArrayList<PSDEGridEditItemVR> psDEGridEditItemVRList = new ArrayList();
        public ArrayList<PSDEGridLogic> psDEGridLogicList = new ArrayList();
        public PSDEGrid psDEGrid = null;
    }

    protected class PSDEGroupStorage {
        public String strPSDEGroupId = "";
        public PSDEGroup psDEGroup = null;
        public ArrayList<PSDEGroupDetail> psDEGroupDetailList = new ArrayList();
    }

    protected class PSDEListStorage {
        public String strPSDEListId = "";
        public ArrayList<PSDEListItem> psDEListItemList = new ArrayList();
        public ArrayList<PSDEListLogic> psDEListLogicList = new ArrayList();
        public PSDEList psDEList = null;
    }

    protected class PSDELogicStorage {
        public String strPSDELogicId = "";
        public PSDELogic psDELogic = null;
        public Vector<PSDELogicParam> psDELogicParamList = new Vector();
        public Vector<PSDELogicNode> psDELogicNodeList = new Vector();
        public Vector<PSDELogicLink> psDELogicLinkList = new Vector();
        public Vector<PSDELogicNodeParam> psDELogicNodeParamList = new Vector();
        public Vector<PSDELogicLinkCond> psDELogicLinkCondList = new Vector();
    }

    protected class PSDEMainStateStorage {
        public String strPSDEMainStateId = "";
        public Vector<PSDEMainStateAction> psDEMainStateActionList = new Vector();
        public Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList = new Vector();
        public Vector<PSDEMainStateField> psDEMainStateFieldList = new Vector();
        public PSDEMainState psDEMainState = null;
    }

    protected class PSDEMapStorage {
        public String strPSDEMapId = "";
        public Vector<PSDEMapDetail> psDEMapDetailList = new Vector();
        public Vector<PSDEMapAction> psDEMapActionList = new Vector();
        public Vector<PSDEMapDataQuery> psDEMapDataQueryList = new Vector();
        public Vector<PSDEMapDataSet> psDEMapDataSetList = new Vector();
        public PSDEMap psDEMap = null;
    }

    protected class PSDENotifyStorage {
        public String strPSDENotifyId = "";
        public ArrayList<PSDENotifyTarget> psDENotifyTargetList = new ArrayList();
        public PSDENotify psDENotify = null;
    }

    protected class PSDEOPPrivRoleStorage {
        public String strPSDEOPPrivRoleId = "";
        public PSDEOPPrivRole psDEOPPrivRole = null;
    }

    protected class PSDEPrintStorage {
        public String strPSDEPrintId = "";
        public PSDEPrint psDEPrint = null;
    }

    protected class PSDERGroupStorage {
        public String strPSDERGroupId = "";
        public PSDERGroup psDERGroup = null;
        public ArrayList<PSDERGroupDetail> psDERGroupDetailList = new ArrayList();
    }

    protected class PSDERStorage {
        public String strPSDERId = "";
        public PSDER psDER = null;
        public ArrayList<PSDERDEFMap> psDERDEFMapList = new ArrayList();
    }

    protected class PSDEReportStorage {
        public String strPSDEReportId = "";
        public Vector<PSDEReportItem> psDEReportItemList = new Vector();
        public PSDEReport psDEReport = null;
    }

    protected class PSDEServiceAPIStorage {
        public String strPSDEServiceAPIId = "";
        public Vector<PSDESADetail> psDESADetailList = new Vector();
        public Vector<PSDESAVR> psDESAVRList = new Vector();
        public PSDEServiceAPI psDEServiceAPI = null;
    }

    protected class PSDEToolbarStorage {
        public String strPSDEToolbarId = "";
        public ArrayList<PSDEToolbarItem> psDEToolbarItemList = new ArrayList();
        public ArrayList<PSDEToolbarLogic> psDEToolbarLogicList = new ArrayList();
        public PSDEToolbar psDEToolbar = null;
    }

    protected class PSDETreeViewStorage {
        public String strPSDETreeViewId = "";
        public ArrayList<PSDETreeNode> psDETreeNodeList = new ArrayList();
        public ArrayList<PSDETreeNodeRS> psDETreeNodeRSList = new ArrayList();
        public ArrayList<PSDETreeNodeRV> psDETreeNodeRVList = new ArrayList();
        public ArrayList<PSDETreeColumn> psDETreeColumnList = new ArrayList();
        public ArrayList<PSDETreeNodeColumn> psDETreeNodeColumnList = new ArrayList();
        public ArrayList<PSDETreeLogic> psDETreeLogicList = new ArrayList();
        public PSDETreeView psDETreeView = null;
    }

    protected class PSDEUIActionGroupStorage {
        public String strPSDEUIActionGroupId = "";
        public PSDEUIActionGroup psDEUIActionGroup = null;
        public ArrayList<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new ArrayList();
    }

    protected class PSDEUserRoleStorage {
        public String strPSDEUserRoleId = "";
        public PSDEUserRole psDEUserRole = null;
    }

    protected class PSDEUtilStorage {
        public String strPSDEUtilId = "";
        public PSDEUtil psDEUtil = null;
    }

    protected class PSDEViewBaseStorage {
        public String strPSDEViewBaseId = "";
        public ArrayList<PSDEViewCtrl> psDEViewCtrlList = new ArrayList();
        public ArrayList<PSDEViewView> psDEViewViewList = new ArrayList();
        public ArrayList<PSDEViewLogic> psDEViewLogicList = new ArrayList();
        public ArrayList<PSDEViewEngine> psDEViewEngineList = new ArrayList();
        public PSDEViewBase psDEViewBase = null;
    }

    protected class PSDEWizardStorage {
        public String strPSDEWizardId = "";
        public Vector<PSDEWizardStep> psDEWizardStepList = new Vector();
        public Vector<PSDEWizardForm> psDEWizardFormList = new Vector();
        public Vector<PSDEWizardLogic> psDEWizardLogicList = new Vector();
        public PSDEWizard psDEWizard = null;
    }

    protected class PSDataEntityStorage {
        public String strPSDataEntityId = "";
        public ArrayList<PSDEField> psDEFieldList = new ArrayList();
        public ArrayList<PSDEViewBase> psDEPredefinedViewList = new ArrayList();
        public ArrayList<PSDEViewBase> psDEViewList = new ArrayList();
        public ArrayList<PSDEForm> psDEEditFormList = new ArrayList();
        public ArrayList<PSDEFGridColumn> psDEFGridColumnList = new ArrayList();
        public ArrayList<PSDEFUIMode> psDEFUIModeList = new ArrayList();
        public ArrayList<PSDEFSearchMode> psDEFSearchModeList = new ArrayList();
        public ArrayList<PSDEFDTColumn> psDEFDTColumnList = new ArrayList();
        public ArrayList<PSDEFValueRule> psDEFValueRuleList = new ArrayList();
        public ArrayList<PSDEDataSet> psDEDataSetList = new ArrayList();
        public ArrayList<PSDEDataQuery> psDEDataQueryList = new ArrayList();
        public ArrayList<PSDEAction> psDEActionList = new ArrayList();
        public ArrayList<PSDER> psDERList = new ArrayList();
        public ArrayList<PSDER> psDERList2 = new ArrayList();
        public ArrayList<PSDEMap> psDEMapList = new ArrayList();
        public ArrayList<PSDEACMode> psDEACModeList = new ArrayList();
        public ArrayList<PSDEOPPriv> psDEOPPrivList = new ArrayList();
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
        public ArrayList<PSDELogic> psDELogicList = new ArrayList();
        public ArrayList<PSWFDE> psWFDEList = new ArrayList();
        public ArrayList<PSDEDBConfig> psDEDBConfigList = new ArrayList();
        public ArrayList<PSDEDBIndex> psDEDBIndexList = new ArrayList();
        public ArrayList<PSACHandler> psACHandlerList = new ArrayList();
        public ArrayList<PSDEDRItem> psDEDRItemList = new ArrayList();
        public ArrayList<PSDEDRGroup> psDEDRGroupList = new ArrayList();
        public ArrayList<PSDEDataRelation> psDEDataRelationList = new ArrayList();
        public ArrayList<PSDEMainState> psDEMainStateList = new ArrayList();
        public ArrayList<PSDEReport> psDEReportList = new ArrayList();
        public ArrayList<PSDEPrint> psDEPrintList = new ArrayList();
        public ArrayList<PSDEWizard> psDEWizardList = new ArrayList();
        public ArrayList<PSDEDataSync> psDEDataSyncList = new ArrayList();
        public ArrayList<PSSysBDTableDE> psDEBDTableList = new ArrayList();
        public ArrayList<PSDEDataExport> psDEDataExportList = new ArrayList();
        public ArrayList<PSDEDataImport> psDEDataImportList = new ArrayList();
        public ArrayList<PSDEFInputTip> psDEFInputTipList = new ArrayList();
        public ArrayList<PSDEActionWizard> psDEActionWizardList = new ArrayList();
        public ArrayList<PSDEAWGroup> psDEAWGroupList = new ArrayList();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public ArrayList<PSSysUniState> psDEUniStateList = new ArrayList();
        public ArrayList<PSDEServiceAPI> psDEServiceAPIList = new ArrayList();
        public ArrayList<PSDEDTSQueue> psDEDTSQueueList = new ArrayList();
        public ArrayList<PSDEUserRole> psDEUserRoleList = new ArrayList();
        public ArrayList<PSDEOPPrivRole> psDEOPPrivRoleList = new ArrayList();
        public ArrayList<PSDEUtil> psDEUtilList = new ArrayList();
        public ArrayList<PSDESampleData> psDESampleDataList = new ArrayList();
        public ArrayList<PSDEFGroup> psDEFGroupList = new ArrayList();
        public ArrayList<PSDEGroup> psDEGroupList = new ArrayList();
        public ArrayList<PSDERGroup> psDERGroupList = new ArrayList();
        public ArrayList<PSDEActionGroup> psDEActionGroupList = new ArrayList();
        public ArrayList<PSDEDBTable> psDEDBTableList = new ArrayList();
        public ArrayList<PSSysSearchDE> psDESearchList = new ArrayList();
        public ArrayList<PSSysSearchDEField> psSysSearchDEFieldList = new ArrayList();
        public ArrayList<PSDEMainStateRS> psDEMainStateRSList = new ArrayList();
        public ArrayList<PSDENotify> psDENotifyList = new ArrayList();
        public PSDataEntity psDataEntity = null;
    }

    protected class PSDataEntityStorage2 {
        public String strPSDataEntityId = "";
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public ArrayList<PSDELogic> psDELogicList = new ArrayList();
        public ArrayList<PSCtrlLogicGroup> psCtrlLogicGroupList = new ArrayList();
        public ArrayList<PSDEACMode> psDEACModeList = new ArrayList();
        public ArrayList<PSDEDataExport> psDEDataExportList = new ArrayList();
        public ArrayList<PSDEDataImport> psDEDataImportList = new ArrayList();
        public ArrayList<PSDEPrint> psDEPrintList = new ArrayList();
        public ArrayList<PSDEReport> psDEReportList = new ArrayList();
        public ArrayList<PSDEMap> psDEMapList = new ArrayList();

        protected PSDataEntityStorage2() {
        }
    }

    protected class PSDynaDETemplStorage {
        public String strPSDynaDETemplId = "";
        public ArrayList<PSDynaDEViewTempl> psDynaDEViewTemplList = new ArrayList();
        public ArrayList<PSDynaDEFormTempl> psDynaDEFormTemplList = new ArrayList();
        public PSDynaDETempl psDynaDETempl = null;
    }

    protected class PSDynaDEViewTemplStorage {
        public String strPSDynaDEViewTemplId = "";
        public PSDynaDEViewTempl psDynaDEViewTempl = null;
    }

    protected class PSMobAppPackStorage {
        public String strPSMobAppPackId = "";
        public ArrayList<PSMobAppPackTD> psMobAppPackTDList = new ArrayList();
        public PSMobAppPack psMobAppPack = null;
    }

    protected class PSPanelLogicStorage {
        public String strPSPanelLogicId = "";
        public PSSysPanelLogic psSysPanelLogic = null;
        public ArrayList<PSPanelLogicParam> psPanelLogicParamList = new ArrayList();
        public ArrayList<PSPanelLogicNode> psPanelLogicNodeList = new ArrayList();
        public ArrayList<PSPanelLogicLink> psPanelLogicLinkList = new ArrayList();
        public ArrayList<PSPanelLogicNodeParam> psPanelLogicNodeParamList = new ArrayList();
        public ArrayList<PSPanelLogicLinkCond> psPanelLogicLinkCondList = new ArrayList();
    }

    protected class PSSubSysSADEStorage {
        public String strPSSubSysSADEId = "";
        public ArrayList<PSSubSysSADEField> psSubSysSADEFieldList = new ArrayList();
        public PSSubSysSADE psSubSysSADE = null;
    }

    protected class PSSubSysServiceAPIStorage {
        public String strPSSubSysServiceAPIId = "";
        public ArrayList<PSSubSysSADE> psSubSysSADEList = new ArrayList();
        public ArrayList<PSSubSysSADERS> psSubSysSADERSList = new ArrayList();
        public ArrayList<PSSubSysSADetail> psSubSysSADetailList = new ArrayList();
        public PSSubSysServiceAPI psSubSysServiceAPI = null;
    }

    protected class PSSysAIFactoryStorage {
        public String strPSSysAIFactoryId = "";
        public ArrayList<PSSysAIChatAgent> psSysAIChatAgentList = new ArrayList();
        public ArrayList<PSSysAIWorkerAgent> psSysAIWorkerAgentList = new ArrayList();
        public ArrayList<PSSysAIPipelineAgent> psSysAIPipelineAgentList = new ArrayList();
        public PSSysAIFactory psSysAIFactory = null;
    }

    protected class PSSysAIPipelineStorage {
        public String strPSSysAIPipelineAgentId = "";
        public ArrayList<PSSysAIPipelineJob> psSysAIPipelineJobList = new ArrayList();
        public ArrayList<PSSysAIPipelineWorker> psSysAIPipelineWorkerList = new ArrayList();
        public PSSysAIPipelineAgent psSysAIPipelineAgent = null;
    }

    protected class PSSysActorStorage {
        public String strPSSysActorId = "";
        public ArrayList<PSSysUserCaseRS> psSysUserCaseRSList = new ArrayList();
        public PSSysActor psSysActor = null;
    }

    protected class PSSysAppStorage {
        public String strPSSysAppId = "";
        public int nLoadLevel = IPSSystem.LOADLEVEL_NONE;
        public HashMap<String, PSAppViewStorage> psAppViewStorageMap = new HashMap();
        public ArrayList<PSAppView> psAppViewList = new ArrayList();
        public ArrayList<PSAppUtilPage> psAppUtilPageList = new ArrayList();
        public ArrayList<PSAppPDTView> psAppPDTViewList = new ArrayList();
        public ArrayList<PSAppModule> psAppModuleList = new ArrayList();
        public ArrayList<PSAppFunc> psAppFuncList = new ArrayList();
        public ArrayList<PSAppEditorTempl> psAppEditorTemplList = new ArrayList();
        public ArrayList<PSAppMenu> psAppMenuList = new ArrayList();
        public HashMap<String, PSAppView> psAppViewMap = new HashMap();
        public HashMap<String, PSDEViewBaseStorage> psDEViewBaseStorageMap = new HashMap();
        public ArrayList<PSDEViewBase> psDEViewBaseList = new ArrayList();
        public HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap();
        public HashMap<String, PSDynaDEViewTemplStorage> psDynaDEViewTemplStorageMap = new HashMap();
        public ArrayList<PSDynaDEViewTempl> psDynaDEViewTemplList = new ArrayList();
        public HashMap<String, PSDynaDEViewTempl> psDynaDEViewTemplMap = new HashMap();
        public HashMap<String, PSDataEntity> psDataEntityMap = new HashMap();
        public HashMap<String, PSDEToolbarStorage> psDEToolbarStorageMap = new HashMap();
        public HashMap<String, PSDEFormStorage> psDEFormStorageMap = new HashMap();
        public HashMap<String, PSDEGridStorage> psDEGridStorageMap = new HashMap();
        public HashMap<String, PSDEChartStorage> psDEChartStorageMap = new HashMap();
        public ArrayList<PSAppViewCode> psAppViewCodeList = new ArrayList();
        public HashMap<String, PSDEListStorage> psDEListStorageMap = new HashMap();
        public HashMap<String, PSDETreeViewStorage> psDETreeViewStorageMap = new HashMap();
        public HashMap<String, PSDEDataViewStorage> psDEDataViewStorageMap = new HashMap();
        public ArrayList<PSAppUserMode> psAppUserModeList = new ArrayList();
        public ArrayList<PSAppLan> psAppLanList = new ArrayList();
        public ArrayList<PSMobAppStartPage> psMobAppStartPageList = new ArrayList();
        public HashMap<String, PSAppMenuStorage> psAppMenuStorageMap = new HashMap();
        public ArrayList<PSMobAppPack> psMobAppPackList = new ArrayList();
        public HashMap<String, PSMobAppPackStorage> psMobAppPackStorageMap = new HashMap();
        public ArrayList<PSAppPkg> psAppPkgList = new ArrayList();
        public ArrayList<PSDCMobAppPackCert> psDCMobAppPackCertList = new ArrayList();
        public ArrayList<PSSysSearchBar> psSysSearchBarList = new ArrayList();
        public HashMap<String, PSSysSearchBarStorage> psSysSearchBarStorageMap = new HashMap();
        public ArrayList<PSSysDashboard> psSysDashboardList = new ArrayList();
        public HashMap<String, PSSysDashboardStorage> psSysDashboardStorageMap = new HashMap();
        public ArrayList<PSAppLocalDE> psAppLocalDEList = new ArrayList();
        public ArrayList<PSSysTitleBar> psSysTitleBarList = new ArrayList();
        public HashMap<String, PSSysTitleBarStorage> psSysTitleBarStorageMap = new HashMap();
        public ArrayList<PSAppTitleBar> psAppTitleBarList = new ArrayList();
        public HashMap<String, PSAppTitleBarStorage> psAppTitleBarStorageMap = new HashMap();
        public ArrayList<PSSysCalendar> psSysCalendarList = new ArrayList();
        public HashMap<String, PSSysCalendarStorage> psSysCalendarStorageMap = new HashMap();
        public ArrayList<PSSysPanel> psSysPanelList = new ArrayList();
        public HashMap<String, PSSysPanelStorage> psSysPanelStorageMap = new HashMap();
        public HashMap<String, PSPanelLogicStorage> psPanelLogicStorageMap = new HashMap();
        public ArrayList<PSAppUIStyle> psAppUIStyleList = new ArrayList();
        public ArrayList<PSAppUITheme> psAppUIThemeList = new ArrayList();
        public ArrayList<PSSysViewLogic> psSysViewLogicList = new ArrayList();
        public HashMap<String, PSSysViewLogic> psSysViewLogicMap = new HashMap();
        public HashMap<String, PSSysViewLogicStorage> psSysViewLogicStorageMap = new HashMap();
        public ArrayList<PSAppWF> psAppWFList = new ArrayList();
        public ArrayList<PSAppWFVer> psAppWFVerList = new ArrayList();
        public ArrayList<PSAppDERS> psAppDERSList = new ArrayList();
        public ArrayList<PSAppResource> psAppResourceList = new ArrayList();
        public HashMap<String, PSDEUIActionGroupStorage> psDEUIActionGroupStorageMap = new HashMap();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
        public HashMap<String, PSDataEntityStorage2> psDataEntityStorageMap = new HashMap();
        public HashMap<String, PSWorkflowStorage> psWorkflowStorageMap = new HashMap();
        public HashMap<String, PSWFVersionStorage> psWFVersionStorageMap = new HashMap();
        public HashMap<String, PSDELogicStorage> psDELogicStorageMap = new HashMap();
        public HashMap<String, PSCtrlLogicGroupStorage> psCtrlLogicGroupStorageMap = new HashMap();
        public ArrayList<PSCtrlLogicGroup> psCtrlLogicGroupList = new ArrayList();
        public HashMap<String, PSDEACModeStorage> psDEACModeStorageMap = new HashMap();
        public ArrayList<PSSysMapView> psSysMapViewList = new ArrayList();
        public HashMap<String, PSSysMapViewStorage> psSysMapViewStorageMap = new HashMap();
        public ArrayList<PSAppUtil> psAppUtilList = new ArrayList();
        public ArrayList<PSAppPortlet> psAppPortletList = new ArrayList();
        public ArrayList<PSAppPFPlugin> psAppPFPluginList = new ArrayList();
        public HashMap<String, PSDEDataExportStorage> psDEDataExportStorageMap = new HashMap();
        public HashMap<String, PSDEDataImportStorage> psDEDataImportStorageMap = new HashMap();
        public ArrayList<PSSysValueRule> psSysValueRuleList = new ArrayList();
        public HashMap<String, PSSysValueRule> psSysValueRuleMap = new HashMap();
        public HashMap<String, PSDEWizardStorage> psDEWizardStorageMap = new HashMap();
        public HashMap<String, PSDEPrintStorage> psDEPrintStorageMap = new HashMap();
        public HashMap<String, PSDEReportStorage> psDEReportStorageMap = new HashMap();
        public ArrayList<PSAppLogic> psAppLogicList = new ArrayList();
        public HashMap<String, PSDEMapStorage> psDEMapStorageMap = new HashMap();

        public PSDEViewBaseStorage getPSDEViewBaseStorage(String strDEId) {
            PSDEViewBaseStorage psDEViewBaseStorage = this.psDEViewBaseStorageMap.get(strDEId);
            if (psDEViewBaseStorage == null) {
                psDEViewBaseStorage = new PSDEViewBaseStorage();
                this.psDEViewBaseStorageMap.put(strDEId, psDEViewBaseStorage);
            }
            return psDEViewBaseStorage;
        }

        public PSDynaDEViewTemplStorage getPSDynaDEViewTemplStorage(String strDEId) {
            PSDynaDEViewTemplStorage psDynaDEViewTemplStorage = this.psDynaDEViewTemplStorageMap.get(strDEId);
            if (psDynaDEViewTemplStorage == null) {
                psDynaDEViewTemplStorage = new PSDynaDEViewTemplStorage();
                this.psDynaDEViewTemplStorageMap.put(strDEId, psDynaDEViewTemplStorage);
            }
            return psDynaDEViewTemplStorage;
        }

        public PSAppViewStorage getPSAppViewStorage(String strAppViewId) {
            PSAppViewStorage psAppViewStorage = this.psAppViewStorageMap.get(strAppViewId);
            if (psAppViewStorage == null) {
                psAppViewStorage = new PSAppViewStorage();
                this.psAppViewStorageMap.put(strAppViewId, psAppViewStorage);
            }
            return psAppViewStorage;
        }

        public PSDEToolbarStorage getPSDEToolbarStorage(String strDEId) {
            PSDEToolbarStorage psDEToolbarStorage = this.psDEToolbarStorageMap.get(strDEId);
            if (psDEToolbarStorage == null) {
                psDEToolbarStorage = new PSDEToolbarStorage();
                this.psDEToolbarStorageMap.put(strDEId, psDEToolbarStorage);
            }
            return psDEToolbarStorage;
        }

        public PSDEFormStorage getPSDEFormStorage(String strDEId) {
            PSDEFormStorage psDEFormStorage = this.psDEFormStorageMap.get(strDEId);
            if (psDEFormStorage == null) {
                psDEFormStorage = new PSDEFormStorage();
                this.psDEFormStorageMap.put(strDEId, psDEFormStorage);
            }
            return psDEFormStorage;
        }

        public PSDEGridStorage getPSDEGridStorage(String strDEId) {
            PSDEGridStorage psDEGridStorage = this.psDEGridStorageMap.get(strDEId);
            if (psDEGridStorage == null) {
                psDEGridStorage = new PSDEGridStorage();
                this.psDEGridStorageMap.put(strDEId, psDEGridStorage);
            }
            return psDEGridStorage;
        }

        public PSDETreeViewStorage getPSDETreeViewStorage(String strPSDETreeViewId) {
            PSDETreeViewStorage psDETreeViewStorage = this.psDETreeViewStorageMap.get(strPSDETreeViewId);
            if (psDETreeViewStorage == null) {
                psDETreeViewStorage = new PSDETreeViewStorage();
                this.psDETreeViewStorageMap.put(strPSDETreeViewId, psDETreeViewStorage);
            }
            return psDETreeViewStorage;
        }

        public PSDEChartStorage getPSDEChartStorage(String strDEId) {
            PSDEChartStorage psDEChartStorage = this.psDEChartStorageMap.get(strDEId);
            if (psDEChartStorage == null) {
                psDEChartStorage = new PSDEChartStorage();
                this.psDEChartStorageMap.put(strDEId, psDEChartStorage);
            }
            return psDEChartStorage;
        }

        public PSDEListStorage getPSDEListStorage(String strDEId) {
            PSDEListStorage psDEListStorage = this.psDEListStorageMap.get(strDEId);
            if (psDEListStorage == null) {
                psDEListStorage = new PSDEListStorage();
                this.psDEListStorageMap.put(strDEId, psDEListStorage);
            }
            return psDEListStorage;
        }

        public PSDEDataViewStorage getPSDEDataViewStorage(String strDEId) {
            PSDEDataViewStorage psDEDataViewStorage = this.psDEDataViewStorageMap.get(strDEId);
            if (psDEDataViewStorage == null) {
                psDEDataViewStorage = new PSDEDataViewStorage();
                this.psDEDataViewStorageMap.put(strDEId, psDEDataViewStorage);
            }
            return psDEDataViewStorage;
        }

        public PSAppMenuStorage getPSAppMenuStorage(String strDEId) {
            PSAppMenuStorage psAppMenuStorage = this.psAppMenuStorageMap.get(strDEId);
            if (psAppMenuStorage == null) {
                psAppMenuStorage = new PSAppMenuStorage();
                this.psAppMenuStorageMap.put(strDEId, psAppMenuStorage);
            }
            return psAppMenuStorage;
        }

        public PSMobAppPackStorage getPSMobAppPackStorage(String strDEId) {
            PSMobAppPackStorage psMobAppPackStorage = this.psMobAppPackStorageMap.get(strDEId);
            if (psMobAppPackStorage == null) {
                psMobAppPackStorage = new PSMobAppPackStorage();
                this.psMobAppPackStorageMap.put(strDEId, psMobAppPackStorage);
            }
            return psMobAppPackStorage;
        }

        public PSSysSearchBarStorage getPSSysSearchBarStorage(String strSysSearchBarId) {
            PSSysSearchBarStorage psSysSearchBarStorage = this.psSysSearchBarStorageMap.get(strSysSearchBarId);
            if (psSysSearchBarStorage == null) {
                psSysSearchBarStorage = new PSSysSearchBarStorage();
                this.psSysSearchBarStorageMap.put(strSysSearchBarId, psSysSearchBarStorage);
            }
            return psSysSearchBarStorage;
        }

        public PSSysDashboardStorage getPSSysDashboardStorage(String strSysDashboardId) {
            PSSysDashboardStorage psSysDashboardStorage = this.psSysDashboardStorageMap.get(strSysDashboardId);
            if (psSysDashboardStorage == null) {
                psSysDashboardStorage = new PSSysDashboardStorage();
                this.psSysDashboardStorageMap.put(strSysDashboardId, psSysDashboardStorage);
            }
            return psSysDashboardStorage;
        }

        public PSSysTitleBarStorage getPSSysTitleBarStorage(String strSysTitleBarId) {
            PSSysTitleBarStorage psSysTitleBarStorage = this.psSysTitleBarStorageMap.get(strSysTitleBarId);
            if (psSysTitleBarStorage == null) {
                psSysTitleBarStorage = new PSSysTitleBarStorage();
                this.psSysTitleBarStorageMap.put(strSysTitleBarId, psSysTitleBarStorage);
            }
            return psSysTitleBarStorage;
        }

        public PSAppTitleBarStorage getPSAppTitleBarStorage(String strAppTitleBarId) {
            PSAppTitleBarStorage psAppTitleBarStorage = this.psAppTitleBarStorageMap.get(strAppTitleBarId);
            if (psAppTitleBarStorage == null) {
                psAppTitleBarStorage = new PSAppTitleBarStorage();
                this.psAppTitleBarStorageMap.put(strAppTitleBarId, psAppTitleBarStorage);
            }
            return psAppTitleBarStorage;
        }

        public PSSysCalendarStorage getPSSysCalendarStorage(String strSysCalendarId) {
            PSSysCalendarStorage psSysCalendarStorage = this.psSysCalendarStorageMap.get(strSysCalendarId);
            if (psSysCalendarStorage == null) {
                psSysCalendarStorage = new PSSysCalendarStorage();
                this.psSysCalendarStorageMap.put(strSysCalendarId, psSysCalendarStorage);
            }
            return psSysCalendarStorage;
        }

        public PSSysPanelStorage getPSSysPanelStorage(String strSysPanelId) {
            PSSysPanelStorage psSysPanelStorage = this.psSysPanelStorageMap.get(strSysPanelId);
            if (psSysPanelStorage == null) {
                psSysPanelStorage = new PSSysPanelStorage();
                this.psSysPanelStorageMap.put(strSysPanelId, psSysPanelStorage);
            }
            return psSysPanelStorage;
        }

        public PSPanelLogicStorage getPSPanelLogicStorage(String strPanelLogicId) {
            PSPanelLogicStorage psPanelLogicStorage = this.psPanelLogicStorageMap.get(strPanelLogicId);
            if (psPanelLogicStorage == null) {
                psPanelLogicStorage = new PSPanelLogicStorage();
                this.psPanelLogicStorageMap.put(strPanelLogicId, psPanelLogicStorage);
            }
            return psPanelLogicStorage;
        }

        public PSSysViewLogicStorage getPSSysViewLogicStorage(String strSysViewLogicId) {
            PSSysViewLogicStorage psSysViewLogicStorage = this.psSysViewLogicStorageMap.get(strSysViewLogicId);
            if (psSysViewLogicStorage == null) {
                psSysViewLogicStorage = new PSSysViewLogicStorage();
                this.psSysViewLogicStorageMap.put(strSysViewLogicId, psSysViewLogicStorage);
            }
            return psSysViewLogicStorage;
        }

        public PSDEUIActionGroupStorage getPSDEUIActionGroupStorage(String strDEId) {
            PSDEUIActionGroupStorage psDEUIActionGroupStorage = this.psDEUIActionGroupStorageMap.get(strDEId);
            if (psDEUIActionGroupStorage == null) {
                psDEUIActionGroupStorage = new PSDEUIActionGroupStorage();
                this.psDEUIActionGroupStorageMap.put(strDEId, psDEUIActionGroupStorage);
            }
            return psDEUIActionGroupStorage;
        }

        public PSDataEntityStorage2 getPSDataEntityStorage(String strDEId) {
            PSDataEntityStorage2 psDataEntityStorage2 = this.psDataEntityStorageMap.get(strDEId);
            if (psDataEntityStorage2 == null) {
                psDataEntityStorage2 = new PSDataEntityStorage2();
                this.psDataEntityStorageMap.put(strDEId, psDataEntityStorage2);
            }
            return psDataEntityStorage2;
        }

        public PSWFVersionStorage getPSWFVersionStorage(String strDEId) {
            PSWFVersionStorage psWFVersionStorage = this.psWFVersionStorageMap.get(strDEId);
            if (psWFVersionStorage == null) {
                psWFVersionStorage = new PSWFVersionStorage();
                this.psWFVersionStorageMap.put(strDEId, psWFVersionStorage);
            }
            return psWFVersionStorage;
        }

        public PSWorkflowStorage getPSWorkflowStorage(String strDEId) {
            PSWorkflowStorage psWorkflowStorage = this.psWorkflowStorageMap.get(strDEId);
            if (psWorkflowStorage == null) {
                psWorkflowStorage = new PSWorkflowStorage();
                this.psWorkflowStorageMap.put(strDEId, psWorkflowStorage);
            }
            return psWorkflowStorage;
        }

        public PSDELogicStorage getPSDELogicStorage(String strDEId) {
            PSDELogicStorage psDELogicStorage = this.psDELogicStorageMap.get(strDEId);
            if (psDELogicStorage == null) {
                psDELogicStorage = new PSDELogicStorage();
                this.psDELogicStorageMap.put(strDEId, psDELogicStorage);
            }
            return psDELogicStorage;
        }

        public PSCtrlLogicGroupStorage getPSCtrlLogicGroupStorage(String strPSCtrlLogicGroupId) {
            PSCtrlLogicGroupStorage psCtrlLogicGroupStorage = this.psCtrlLogicGroupStorageMap.get(strPSCtrlLogicGroupId);
            if (psCtrlLogicGroupStorage == null) {
                psCtrlLogicGroupStorage = new PSCtrlLogicGroupStorage();
                this.psCtrlLogicGroupStorageMap.put(strPSCtrlLogicGroupId, psCtrlLogicGroupStorage);
            }
            return psCtrlLogicGroupStorage;
        }

        public PSDEACModeStorage getPSDEACModeStorage(String strDEId) {
            PSDEACModeStorage psDEACModeStorage = this.psDEACModeStorageMap.get(strDEId);
            if (psDEACModeStorage == null) {
                psDEACModeStorage = new PSDEACModeStorage();
                this.psDEACModeStorageMap.put(strDEId, psDEACModeStorage);
            }
            return psDEACModeStorage;
        }

        public PSSysMapViewStorage getPSSysMapViewStorage(String strSysMapViewId) {
            PSSysMapViewStorage psSysMapViewStorage = this.psSysMapViewStorageMap.get(strSysMapViewId);
            if (psSysMapViewStorage == null) {
                psSysMapViewStorage = new PSSysMapViewStorage();
                this.psSysMapViewStorageMap.put(strSysMapViewId, psSysMapViewStorage);
            }
            return psSysMapViewStorage;
        }

        public PSDEPrintStorage getPSDEPrintStorage(String strDEId) {
            PSDEPrintStorage psDEPrintStorage = this.psDEPrintStorageMap.get(strDEId);
            if (psDEPrintStorage == null) {
                psDEPrintStorage = new PSDEPrintStorage();
                this.psDEPrintStorageMap.put(strDEId, psDEPrintStorage);
            }
            return psDEPrintStorage;
        }

        public PSDEReportStorage getPSDEReportStorage(String strDEId) {
            PSDEReportStorage psDEReportStorage = this.psDEReportStorageMap.get(strDEId);
            if (psDEReportStorage == null) {
                psDEReportStorage = new PSDEReportStorage();
                this.psDEReportStorageMap.put(strDEId, psDEReportStorage);
            }
            return psDEReportStorage;
        }

        public PSDEDataExportStorage getPSDEDataExportStorage(String strDEDataExportId) {
            PSDEDataExportStorage psDEDataExportStorage = this.psDEDataExportStorageMap.get(strDEDataExportId);
            if (psDEDataExportStorage == null) {
                psDEDataExportStorage = new PSDEDataExportStorage();
                this.psDEDataExportStorageMap.put(strDEDataExportId, psDEDataExportStorage);
            }
            return psDEDataExportStorage;
        }

        public PSDEDataImportStorage getPSDEDataImportStorage(String strDEDataImportId) {
            PSDEDataImportStorage psDEDataImportStorage = this.psDEDataImportStorageMap.get(strDEDataImportId);
            if (psDEDataImportStorage == null) {
                psDEDataImportStorage = new PSDEDataImportStorage();
                this.psDEDataImportStorageMap.put(strDEDataImportId, psDEDataImportStorage);
            }
            return psDEDataImportStorage;
        }

        public PSDEWizardStorage getPSDEWizardStorage(String strDEWizardId) {
            PSDEWizardStorage psDEWizardStorage = this.psDEWizardStorageMap.get(strDEWizardId);
            if (psDEWizardStorage == null) {
                psDEWizardStorage = new PSDEWizardStorage();
                this.psDEWizardStorageMap.put(strDEWizardId, psDEWizardStorage);
            }
            return psDEWizardStorage;
        }

        public PSDEMapStorage getPSDEMapStorage(String strDEId) {
            PSDEMapStorage psDEMapStorage = this.psDEMapStorageMap.get(strDEId);
            if (psDEMapStorage == null) {
                psDEMapStorage = new PSDEMapStorage();
                this.psDEMapStorageMap.put(strDEId, psDEMapStorage);
            }
            return psDEMapStorage;
        }
    }

    protected class PSSysBDSchemeStorage {
        public String strPSSysBDSchemeId = "";
        public ArrayList<PSSysBDModule> psSysBDModuleList = new ArrayList();
        public ArrayList<PSSysBDPart> psSysBDPartList = new ArrayList();
        public ArrayList<PSSysBDTable> psSysBDTableList = new ArrayList();
        public ArrayList<PSSysBDTableRS> psSysBDTableRSList = new ArrayList();
        public PSSysBDScheme psSysBDScheme = null;
    }

    protected class PSSysBDTableStorage {
        public String strPSSysBDTableId = "";
        public ArrayList<PSSysBDColumn> psSysBDColumnList = new ArrayList();
        public ArrayList<PSSysBDColSet> psSysBDColSetList = new ArrayList();
        public ArrayList<PSSysBDTableDE> psSysBDTableDEList = new ArrayList();
        public ArrayList<PSSysBDTableDER> psSysBDTableDERList = new ArrayList();
        public PSSysBDTable psSysBDTable = null;
    }

    protected class PSSysBIAggTableStorage {
        public String strPSSysBIAggTableId = "";
        public ArrayList<PSSysBIAggColumn> psSysBIAggColumnList = new ArrayList();
        public PSSysBIAggTable psSysBIAggTable = null;
    }

    protected class PSSysBICubeDimensionStorage {
        public String strPSSysBICubeDimensionId = "";
        public ArrayList<PSSysBICubeLevel> psSysBICubeLevelList = new ArrayList();
        public PSSysBICubeDimension psSysBICubeDimension = null;
    }

    protected class PSSysBICubeStorage {
        public String strPSSysBICubeId = "";
        public ArrayList<PSSysBICubeDimension> psSysBICubeDimensionList = new ArrayList();
        public ArrayList<PSSysBICubeMeasure> psSysBICubeMeasureList = new ArrayList();
        public PSSysBICube psSysBICube = null;
    }

    protected class PSSysBIDimensionStorage {
        public String strPSSysBIDimensionId = "";
        public ArrayList<PSSysBIHierarchy> psSysBIHierarchyList = new ArrayList();
        public PSSysBIDimension psSysBIDimension = null;
    }

    protected class PSSysBIHierarchyStorage {
        public String strPSSysBIHierarchyId = "";
        public ArrayList<PSSysBILevel> psSysBILevelList = new ArrayList();
        public PSSysBIHierarchy psSysBIHierarchy = null;
    }

    protected class PSSysBIReportStorage {
        public String strPSSysBIReportId = "";
        public ArrayList<PSSysBIReportItem> psSysBIReportItemList = new ArrayList();
        public PSSysBIReport psSysBIReport = null;
    }

    protected class PSSysBISchemeStorage {
        public String strPSSysBISchemeId = "";
        public ArrayList<PSSysBIDimension> psSysBIDimensionList = new ArrayList();
        public ArrayList<PSSysBICube> psSysBICubeList = new ArrayList();
        public ArrayList<PSSysBIAggTable> psSysBIAggTableList = new ArrayList();
        public ArrayList<PSSysBIReport> psSysBIReportList = new ArrayList();
        public PSSysBIScheme psSysBIScheme = null;
    }

    protected class PSSysCalendarStorage {
        public String strPSSysCalendarId = "";
        public ArrayList<PSSysCalendarItem> psSysCalendarItemList = new ArrayList();
        public ArrayList<PSSysCalendarItemRV> psSysCalendarItemRVList = new ArrayList();
        public ArrayList<PSSysCalendarLogic> psSysCalendarLogicList = new ArrayList();
        public PSSysCalendar psSysCalendar = null;
    }

    protected class PSSysContentCatStorage {
        public String strPSSysContentCatId = "";
        public PSSysContentCat psSysContentCat = null;
        public ArrayList<PSSysContent> psSysContentList = new ArrayList();
        public ArrayList<PSSysContentCat> psSysContentCatList = new ArrayList();
    }

    protected class PSSysDBSchemeStorage {
        public String strPSSysDBSchemeId = "";
        public ArrayList<PSSysDBTable> psSysDBTableList = new ArrayList();
        public PSSysDBScheme psSysDBScheme = null;
    }

    protected class PSSysDBTableStorage {
        public String strPSSysDBTableId = "";
        public ArrayList<PSSysDBColumn> psSysDBColumnList = new ArrayList();
        public PSSysDBTable psSysDBTable = null;
    }

    protected class PSSysDashboardStorage {
        public String strPSSysDashboardId = "";
        public ArrayList<PSSysDashboardPart> psSysDashboardPartList = new ArrayList();
        public ArrayList<PSSysDashboardLogic> psSysDashboardLogicList = new ArrayList();
        public PSSysDashboard psSysDashboard = null;
    }

    protected class PSSysDynaModelStorage {
        public String strPSSysDynaModelId = "";
        public ArrayList<PSSysDynaModelAttr> psSysDynaModelAttrList = new ArrayList();
        public PSSysDynaModel psSysDynaModel = null;
    }

    protected class PSSysEAIDEStorage {
        public String strPSSysEAIDEId = "";
        public ArrayList<PSSysEAIDEField> psSysEAIDEFieldList = new ArrayList();
        public ArrayList<PSSysEAIDER> psSysEAIDERList = new ArrayList();
        public PSSysEAIDE psSysEAIDE = null;
    }

    protected class PSSysEAIDataTypeStorage {
        public String strPSSysEAIDataTypeId = "";
        public ArrayList<PSSysEAIDataTypeItem> psSysEAIDataTypeItemList = new ArrayList();
        public PSSysEAIDataType psSysEAIDataType = null;
    }

    protected class PSSysEAIElementStorage {
        public String strPSSysEAIElementId = "";
        public ArrayList<PSSysEAIElementAttr> psSysEAIElementAttrList = new ArrayList();
        public ArrayList<PSSysEAIElementRE> psSysEAIElementREList = new ArrayList();
        public PSSysEAIElement psSysEAIElement = null;
    }

    protected class PSSysEAISchemeStorage {
        public String strPSSysEAISchemeId = "";
        public ArrayList<PSSysEAIDataType> psSysEAIDataTypeList = new ArrayList();
        public ArrayList<PSSysEAIElement> psSysEAIElementList = new ArrayList();
        public ArrayList<PSSysEAIDE> psSysEAIDEList = new ArrayList();
        public PSSysEAIScheme psSysEAIScheme = null;
    }

    protected class PSSysERMapStorage {
        public String strPSSysERMapId = "";
        public ArrayList<PSSysERMapNode> psSysERMapNodeList = new ArrayList();
        public PSSysERMap psSysERMap = null;
    }

    protected class PSSysMapViewStorage {
        public String strPSSysMapViewId = "";
        public ArrayList<PSSysMapItem> psSysMapItemList = new ArrayList();
        public ArrayList<PSSysMapLogic> psSysMapLogicList = new ArrayList();
        public PSSysMapView psSysMapView = null;
    }

    protected class PSSysModelCache {
        private HashMap<String, PSSysModelLog> psSysModelLogMap = new HashMap();
        private HashMap<String, Vector> psSysModelListMap = new HashMap();
        private String strCacheTag = null;

        protected PSSysModelCache() {
        }

        public void setCacheTag(String strCacheTag) {
            this.strCacheTag = strCacheTag;
        }

        public String getCacheTag() {
            return this.strCacheTag;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Vector getModelList(String strModelName, PSSysModelLog psSysModelLog) throws Exception {
            HashMap<String, PSSysModelLog> hashMap = this.psSysModelLogMap;
            synchronized (hashMap) {
                block8: {
                    String strTag2;
                    Vector lastList;
                    block7: {
                        lastList = this.psSysModelListMap.get(strModelName);
                        if (lastList != null) break block7;
                        return null;
                    }
                    PSSysModelLog lastPSSysModelLog = this.psSysModelLogMap.get(strModelName);
                    if (psSysModelLog == null && lastPSSysModelLog == null) {
                        return lastList;
                    }
                    if (psSysModelLog == null || lastPSSysModelLog == null) break block8;
                    String strTag1 = DateHelper.toDateTimeString((Date)psSysModelLog.getUPDATEDATE());
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strTag1, (String)(strTag2 = DateHelper.toDateTimeString((Date)lastPSSysModelLog.getUPDATEDATE())), (boolean)false) == 0) {
                        return lastList;
                    }
                    return null;
                }
                return null;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Vector getModelList(String strModelName, PSSysModelLog psSysModelLog, PSSysModelLog psSysModelLog2) throws Exception {
            if (psSysModelLog == null) {
                psSysModelLog = psSysModelLog2;
            } else if (psSysModelLog2 != null && psSysModelLog.getUPDATEDATE() != null && psSysModelLog2.getUPDATEDATE() != null && psSysModelLog2.getUPDATEDATE().getTime() > psSysModelLog.getUPDATEDATE().getTime()) {
                psSysModelLog = psSysModelLog2;
            }
            HashMap<String, PSSysModelLog> hashMap = this.psSysModelLogMap;
            synchronized (hashMap) {
                block11: {
                    String strTag2;
                    Vector lastList;
                    block10: {
                        lastList = this.psSysModelListMap.get(strModelName);
                        if (lastList != null) break block10;
                        return null;
                    }
                    PSSysModelLog lastPSSysModelLog = this.psSysModelLogMap.get(strModelName);
                    if (psSysModelLog == null && lastPSSysModelLog == null) {
                        return lastList;
                    }
                    if (psSysModelLog == null || lastPSSysModelLog == null) break block11;
                    String strTag1 = DateHelper.toDateTimeString((Date)psSysModelLog.getUPDATEDATE());
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strTag1, (String)(strTag2 = DateHelper.toDateTimeString((Date)lastPSSysModelLog.getUPDATEDATE())), (boolean)false) == 0) {
                        return lastList;
                    }
                    return null;
                }
                return null;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateModelList(String strModelName, PSSysModelLog psSysModelLog, PSSysModelLog psSysModelLog2, Vector list) throws Exception {
            if (psSysModelLog == null) {
                psSysModelLog = psSysModelLog2;
            } else if (psSysModelLog2 != null && psSysModelLog.getUPDATEDATE() != null && psSysModelLog2.getUPDATEDATE() != null && psSysModelLog2.getUPDATEDATE().getTime() > psSysModelLog.getUPDATEDATE().getTime()) {
                psSysModelLog = psSysModelLog2;
            }
            HashMap<String, PSSysModelLog> hashMap = this.psSysModelLogMap;
            synchronized (hashMap) {
                this.psSysModelListMap.put(strModelName, list);
                if (psSysModelLog == null) {
                    this.psSysModelLogMap.remove(strModelName);
                } else {
                    this.psSysModelLogMap.put(strModelName, psSysModelLog);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateModelList(String strModelName, PSSysModelLog psSysModelLog, Vector list) throws Exception {
            HashMap<String, PSSysModelLog> hashMap = this.psSysModelLogMap;
            synchronized (hashMap) {
                this.psSysModelListMap.put(strModelName, list);
                if (psSysModelLog == null) {
                    this.psSysModelLogMap.remove(strModelName);
                } else {
                    this.psSysModelLogMap.put(strModelName, psSysModelLog);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void removeModelList(String strModelName) {
            HashMap<String, PSSysModelLog> hashMap = this.psSysModelLogMap;
            synchronized (hashMap) {
                this.psSysModelLogMap.remove(strModelName);
                this.psSysModelListMap.remove(strModelName);
            }
        }
    }

    protected class PSSysPanelStorage {
        public String strPSSysPanelId = "";
        public ArrayList<PSSysPanelItem> psSysPanelItemList = new ArrayList();
        public ArrayList<PSSysPanelModel> psSysPanelModelList = new ArrayList();
        public ArrayList<PSPanelItemLogic> psPanelItemLogicList = new ArrayList();
        public ArrayList<PSSysPanelLogic> psSysPanelLogicList = new ArrayList();
        public ArrayList<PSPanelEngine> psPanelEngineList = new ArrayList();
        public PSSysPanel psSysPanel = null;
    }

    protected class PSSysReqModuleStorage {
        public String strPSSysReqModuleId = "";
        public PSSysReqModule psSysReqModule = null;
        public ArrayList<PSSysReqModule> psSysReqModuleList = new ArrayList();
    }

    protected class PSSysSearchBarStorage {
        public String strPSSysSearchBarId = "";
        public ArrayList<PSSysSearchBarItem> psSysSearchBarItemList = new ArrayList();
        public ArrayList<PSSysSearchBarLogic> psSysSearchBarLogicList = new ArrayList();
        public PSSysSearchBar psSysSearchBar = null;
    }

    protected class PSSysSearchDEStorage {
        public String strPSSysSearchDEId = "";
        public ArrayList<PSSysSearchDEField> psSysSearchDEFieldList = new ArrayList();
        public PSSysSearchDE psSysSearchDE = null;
    }

    protected class PSSysSearchDocStorage {
        public String strPSSysSearchDocId = "";
        public ArrayList<PSSysSearchField> psSysSearchFieldList = new ArrayList();
        public PSSysSearchDoc psSysSearchDoc = null;
    }

    protected class PSSysSearchSchemeStorage {
        public String strPSSysSearchSchemeId = "";
        public ArrayList<PSSysSearchDoc> psSysSearchDocList = new ArrayList();
        public ArrayList<PSSysSearchDE> psSysSearchDEList = new ArrayList();
        public PSSysSearchScheme psSysSearchScheme = null;
    }

    protected class PSSysServiceAPIHandlerStorage {
        public String strPSSysServiceAPIHandlerId = "";
        public PSSysServiceAPIHandler psSysServiceAPIHandler = null;
    }

    protected class PSSysServiceAPIStorage {
        public String strPSSysServiceAPIId = "";
        public ArrayList<PSDEServiceAPI> psDEServiceAPIList = new ArrayList();
        public ArrayList<PSDESARS> psDEServiceAPIRSList = new ArrayList();
        public PSSysServiceAPI psSysServiceAPI = null;
    }

    protected class PSSysTestCaseInputStorage {
        public String strPSSysTestCaseInputId = "";
        public ArrayList<PSSysTestCaseAssert> psSysTestCaseAssertList = new ArrayList();
        public PSSysTestCaseInput psSysTestCaseInput = null;
    }

    protected class PSSysTestCaseStorage {
        public String strPSSysTestCaseId = "";
        public ArrayList<PSSysTestCaseInput> psSysTestCaseInputList = new ArrayList();
        public PSSysTestCase psSysTestCase = null;
    }

    protected class PSSysTestDataStorage {
        public String strPSSysTestDataId = "";
        public ArrayList<PSSysTestDataItem> psSysTestDataItemList = new ArrayList();
        public PSSysTestData psSysTestData = null;
    }

    protected class PSSysTestModuleStorage {
        public String strPSSysTestModuleId = "";
        public ArrayList<PSSysTestCase> psSysTestCaseList = new ArrayList();
        public PSSysTestModule psSysTestModule = null;
    }

    protected class PSSysTestPrjStorage {
        public String strPSSysTestPrjId = "";
        public ArrayList<PSSysTestModule> psSysTestModuleList = new ArrayList();
        public PSSysTestPrj psSysTestPrj = null;
    }

    protected class PSSysTitleBarStorage {
        public String strPSSysTitleBarId = "";
        public PSSysTitleBar psSysTitleBar = null;
    }

    protected class PSSysUCMapStorage {
        public String strPSSysUCMapId = "";
        public ArrayList<PSSysUCMapNode> psSysUCMapNodeList = new ArrayList();
        public PSSysUCMap psSysUCMap = null;
    }

    protected class PSSysUserRoleStorage {
        public String strPSSysUserRoleId = "";
        public ArrayList<PSSysUserRoleRes> psSysUserRoleResList = new ArrayList();
        public ArrayList<PSSysUserRoleData> psSysUserRoleDataList = new ArrayList();
        public PSSysUserRole psSysUserRole = null;
    }

    protected class PSSysViewLogicStorage {
        public String strPSSysViewLogicId = "";
        public ArrayList<PSSysViewLogicParam> psSysViewLogicParamList = new ArrayList();
        public PSSysViewLogic psSysViewLogic = null;
    }

    protected class PSSystemStorage {
        public String strPSSystemId = "";
        public int nLoadLevel = IPSSystem.LOADLEVEL_NONE;
        public HashMap<String, PSDataEntityStorage> psDataEntityStorageMap = new HashMap();
        public ArrayList<PSDataEntity> psDataEntityList = new ArrayList();
        public HashMap<String, PSDataEntity> psDataEntityMap = new HashMap();
        public HashMap<String, PSCodeListStorage> psCodeListStorageMap = new HashMap();
        public ArrayList<PSCodeList> psCodeListList = new ArrayList();
        public HashMap<String, PSCodeList> psCodeListMap = new HashMap();
        public ArrayList<PSDER> psDERList = new ArrayList();
        public HashMap<String, PSDER> psDERMap = new HashMap();
        public HashMap<String, PSDERStorage> psDERStorageMap = new HashMap();
        public HashMap<String, PSDEDataSetStorage> psDEDataSetStorageMap = new HashMap();
        public HashMap<String, PSDEDataQueryStorage> psDEDataQueryStorageMap = new HashMap();
        public HashMap<String, PSDEActionStorage> psDEActionStorageMap = new HashMap();
        public HashMap<String, PSDEFValueRuleStorage> psDEFValueRuleStorageMap = new HashMap();
        public HashMap<String, PSDEMapStorage> psDEMapStorageMap = new HashMap();
        public HashMap<String, PSDEACModeStorage> psDEACModeStorageMap = new HashMap();
        public HashMap<String, PSDEUIActionGroupStorage> psDEUIActionGroupStorageMap = new HashMap();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public HashMap<String, PSDELogicStorage> psDELogicStorageMap = new HashMap();
        public HashMap<String, PSDEDataQueryCodeStorage> psDEDataQueryCodeStorageMap = new HashMap();
        public HashMap<String, PSDEMainStateStorage> psDEMainStateStorageMap = new HashMap();
        public HashMap<String, PSDEDBIndexStorage> psDEDBIndexStorageMap = new HashMap();
        public HashMap<String, PSDEReportStorage> psDEReportStorageMap = new HashMap();
        public HashMap<String, PSDEPrintStorage> psDEPrintStorageMap = new HashMap();
        public HashMap<String, PSDEUserRoleStorage> psDEUserRoleStorageMap = new HashMap();
        public HashMap<String, PSDEOPPrivRoleStorage> psDEOPPrivRoleStorageMap = new HashMap();
        public ArrayList<PSSysImage> psSysImageList = new ArrayList();
        public HashMap<String, PSSysImage> psSysImageMap = new HashMap();
        public ArrayList<PSSysCss> psSysCssList = new ArrayList();
        public HashMap<String, PSSysCss> psSysCssMap = new HashMap();
        public ArrayList<PSSubViewType> psSubViewTypeList = new ArrayList();
        public HashMap<String, PSSubViewType> psSubViewTypeMap = new HashMap();
        public ArrayList<PSSysUniRes> psSysUniResList = new ArrayList();
        public HashMap<String, PSSysUniRes> psSysUniResMap = new HashMap();
        public ArrayList<PSSysMsgTempl> psSysMsgTemplList = new ArrayList();
        public HashMap<String, PSSysMsgTempl> psSysMsgTemplMap = new HashMap();
        public ArrayList<PSSysBackService> psSysBackServiceList = new ArrayList();
        public HashMap<String, PSSysBackService> psSysBackServiceMap = new HashMap();
        public ArrayList<PSSysPortlet> psSysPortletList = new ArrayList();
        public HashMap<String, PSSysPortlet> psSysPortletMap = new HashMap();
        public ArrayList<PSSysValueRule> psSysValueRuleList = new ArrayList();
        public HashMap<String, PSSysValueRule> psSysValueRuleMap = new HashMap();
        public HashMap<String, PSDEDataRelationStorage> psDEDataRelationStorageMap = new HashMap();
        public ArrayList<PSSysPDTView> psSysPDTViewList = new ArrayList();
        public HashMap<String, PSSysPDTView> psSysPDTViewMap = new HashMap();
        public ArrayList<PSSysPFPlugin> psSysPFPluginList = new ArrayList();
        public HashMap<String, PSSysPFPlugin> psSysPFPluginMap = new HashMap();
        public ArrayList<PSSysPFPluginTempl> psSysPFPluginTemplList = new ArrayList();
        public HashMap<String, PSSysPFPluginTempl> psSysPFPluginTemplMap = new HashMap();
        public ArrayList<PSSysCounter> psSysCounterList = new ArrayList();
        public HashMap<String, PSSysCounter> psSysCounterMap = new HashMap();
        public ArrayList<PSSysDictCat> psSysDictCatList = new ArrayList();
        public HashMap<String, PSSysDictCat> psSysDictCatMap = new HashMap();
        public ArrayList<PSSysEditorStyle> psSysEditorStyleList = new ArrayList();
        public HashMap<String, PSSysEditorStyle> psSysEditorStyleMap = new HashMap();
        public ArrayList<PSSysViewLogic> psSysViewLogicList = new ArrayList();
        public HashMap<String, PSSysViewLogic> psSysViewLogicMap = new HashMap();
        public HashMap<String, PSSysViewLogicStorage> psSysViewLogicStorageMap = new HashMap();
        public ArrayList<PSSysActor> psSysActorList = new ArrayList();
        public HashMap<String, PSSysActor> psSysActorMap = new HashMap();
        public ArrayList<PSSysUserCase> psSysUserCaseList = new ArrayList();
        public HashMap<String, PSSysUserCase> psSysUserCaseMap = new HashMap();
        public ArrayList<PSSysUserCaseRS> psSysUserCaseRSList = new ArrayList();
        public HashMap<String, PSSysUserCaseRS> psSysUserCaseRSMap = new HashMap();
        public ArrayList<PSSysTestCase> psSysTestCaseList = new ArrayList();
        public HashMap<String, PSSysTestCase> psSysTestCaseMap = new HashMap();
        public HashMap<String, PSSysTestCaseStorage> psSysTestCaseStorageMap = new HashMap();
        public HashMap<String, PSSysTestCaseInputStorage> psSysTestCaseInputStorageMap = new HashMap();
        public ArrayList<PSSysTestData> psSysTestDataList = new ArrayList();
        public HashMap<String, PSSysTestData> psSysTestDataMap = new HashMap();
        public HashMap<String, PSSysTestDataStorage> psSysTestDataStorageMap = new HashMap();
        public ArrayList<PSSysSampleValue> psSysSampleValueList = new ArrayList();
        public HashMap<String, PSSysSampleValue> psSysSampleValueMap = new HashMap();
        public ArrayList<PSSysUserMode> psSysUserModeList = new ArrayList();
        public HashMap<String, PSSysUserMode> psSysUserModeMap = new HashMap();
        public ArrayList<PSSysUserDR> psSysUserDRList = new ArrayList();
        public HashMap<String, PSSysUserDR> psSysUserDRMap = new HashMap();
        public ArrayList<PSSysERMap> psSysERMapList = new ArrayList();
        public HashMap<String, PSSysERMap> psSysERMapMap = new HashMap();
        public HashMap<String, PSSysERMapStorage> psSysERMapStorageMap = new HashMap();
        public ArrayList<PSSysUCMap> psSysUCMapList = new ArrayList();
        public HashMap<String, PSSysUCMap> psSysUCMapMap = new HashMap();
        public HashMap<String, PSSysUCMapStorage> psSysUCMapStorageMap = new HashMap();
        public ArrayList<PSSysSFPub> psSysSFPubList = new ArrayList();
        public HashMap<String, PSSysSFPub> psSysSFPubMap = new HashMap();
        public HashMap<String, PSDEWizardStorage> psDEWizardStorageMap = new HashMap();
        public ArrayList<PSSysDataSyncAgent> psSysDataSyncAgentList = new ArrayList();
        public HashMap<String, PSSysDataSyncAgent> psSysDataSyncAgentMap = new HashMap();
        public HashMap<String, PSDEDataSyncStorage> psDEDataSyncStorageMap = new HashMap();
        public ArrayList<PSSysBDScheme> psSysBDSchemeList = new ArrayList();
        public HashMap<String, PSSysBDScheme> psSysBDSchemeMap = new HashMap();
        public HashMap<String, PSSysBDSchemeStorage> psSysBDSchemeStorageMap = new HashMap();
        public HashMap<String, PSSysBDTableStorage> psSysBDTableStorageMap = new HashMap();
        public ArrayList<PSViewMsg> psViewMsgList = new ArrayList();
        public HashMap<String, PSViewMsg> psViewMsgMap = new HashMap();
        public ArrayList<PSViewMsgGroup> psViewMsgGroupList = new ArrayList();
        public HashMap<String, PSViewMsgGroup> psViewMsgGroupMap = new HashMap();
        public HashMap<String, PSDEDataExportStorage> psDEDataExportStorageMap = new HashMap();
        public HashMap<String, PSDEDataImportStorage> psDEDataImportStorageMap = new HashMap();
        public ArrayList<PSDEFInputTip> psDEFInputTipList = new ArrayList();
        public HashMap<String, PSDEActionWizardStorage> psDEActionWizardStorageMap = new HashMap();
        public HashMap<String, PSDEActionWizardGroupStorage> psDEActionWizardGroupStorageMap = new HashMap();
        public HashMap<String, PSViewMsgGroupStorage> psViewMsgGroupStorageMap = new HashMap();
        public ArrayList<PSWorkflow> psWorkflowList = new ArrayList();
        public HashMap<String, PSWorkflowStorage> psWorkflowStorageMap = new HashMap();
        public ArrayList<PSWFVersion> psWFVersionList = new ArrayList();
        public HashMap<String, PSWFVersionStorage> psWFVersionStorageMap = new HashMap();
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
        public ArrayList<PSWXAccount> psWXAccountList = new ArrayList();
        public HashMap<String, PSWXAccountStorage> psWXAccountStorageMap = new HashMap();
        public HashMap<String, PSWXMenuStorage> psWXMenuStorageMap = new HashMap();
        public HashMap<String, PSWXEntAppStorage> psWXEntAppStorageMap = new HashMap();
        public ArrayList<PSCtrlMsg> psCtrlMsgList = new ArrayList();
        public HashMap<String, PSCtrlMsg> psCtrlMsgMap = new HashMap();
        public ArrayList<PSSysUnit> psSysUnitList = new ArrayList();
        public HashMap<String, PSSysUnit> psSysUnitMap = new HashMap();
        public ArrayList<PSLanguageRes> psLanguageResList = new ArrayList();
        public HashMap<String, PSLanguageRes> psLanguageResMap = new HashMap();
        public ArrayList<PSLanguageItem> psLanguageItemList = new ArrayList();
        public HashMap<String, PSLanguageItem> psLanguageItemMap = new HashMap();
        public ArrayList<PSAppLan> psSysLanList = new ArrayList();
        public ArrayList<PSDEFInputTipSet> psDEFInputTipSetList = new ArrayList();
        public HashMap<String, PSDEFInputTipSet> psDEFInputTipSetMap = new HashMap();
        public ArrayList<PSSysUniState> psSysUniStateList = new ArrayList();
        public HashMap<String, PSSysUniState> psSysUniStateMap = new HashMap();
        public ArrayList<PSSysDEFType> psSysDEFTypeList = new ArrayList();
        public HashMap<String, PSSysDEFType> psSysDEFTypeMap = new HashMap();
        public ArrayList<PSSysLogic> psSysLogicList = new ArrayList();
        public HashMap<String, PSSysLogic> psSysLogicMap = new HashMap();
        public HashMap<String, PSDEServiceAPIStorage> psDEServiceAPIStorageMap = new HashMap();
        public ArrayList<PSSysServiceAPI> psSysServiceAPIList = new ArrayList();
        public HashMap<String, PSSysServiceAPIStorage> psSysServiceAPIStorageMap = new HashMap();
        public ArrayList<PSSysDTSQueue> psSysDTSQueueList = new ArrayList();
        public HashMap<String, PSSysDTSQueue> psSysDTSQueueMap = new HashMap();
        public ArrayList<PSSubSysServiceAPI> psSubSysServiceAPIList = new ArrayList();
        public HashMap<String, PSSubSysServiceAPIStorage> psSubSysServiceAPIStorageMap = new HashMap();
        public ArrayList<PSSysUserRole> psSysUserRoleList = new ArrayList();
        public HashMap<String, PSSysUserRoleStorage> psSysUserRoleStorageMap = new HashMap();
        public ArrayList<PSSysSFPlugin> psSysSFPluginList = new ArrayList();
        public HashMap<String, PSSysSFPlugin> psSysSFPluginMap = new HashMap();
        public ArrayList<PSSysSFPluginTempl> psSysSFPluginTemplList = new ArrayList();
        public HashMap<String, PSSysSFPluginTempl> psSysSFPluginTemplMap = new HashMap();
        public HashMap<String, PSDEUtilStorage> psDEUtilStorageMap = new HashMap();
        public ArrayList<PSSysUtil> psSysUtilList = new ArrayList();
        public HashMap<String, PSSysUtil> psSysUtilMap = new HashMap();
        public ArrayList<PSSysDynaModel> psSysDynaModelList = new ArrayList();
        public HashMap<String, PSSysDynaModel> psSysDynaModelMap = new HashMap();
        public HashMap<String, PSSysDynaModelStorage> psSysDynaModelStorageMap = new HashMap();
        public ArrayList<PSDEActionTempl> psDEActionTemplList = new ArrayList();
        public HashMap<String, PSDEActionTempl> psDEActionTemplMap = new HashMap();
        public ArrayList<PSDynaDETempl> psDynaDETemplList = new ArrayList();
        public HashMap<String, PSDynaDETempl> psDynaDETemplMap = new HashMap();
        public HashMap<String, PSDynaDETemplStorage> psDynaDETemplStorageMap = new HashMap();
        public ArrayList<PSSysServiceAPIHandler> psSysServiceAPIHandlerList = new ArrayList();
        public HashMap<String, PSSysServiceAPIHandlerStorage> psSysServiceAPIHandlerStorageMap = new HashMap();
        public ArrayList<PSSysFile> psSysFileList = new ArrayList();
        public HashMap<String, PSSysFile> psSysFileMap = new HashMap();
        public HashMap<String, PSDEFGroupStorage> psDEFGroupStorageMap = new HashMap();
        public HashMap<String, PSSubSysSADEStorage> psSubSysSADEStorageMap = new HashMap();
        public ArrayList<PSSysDBScheme> psSysDBSchemeList = new ArrayList();
        public HashMap<String, PSSysDBScheme> psSysDBSchemeMap = new HashMap();
        public HashMap<String, PSSysDBSchemeStorage> psSysDBSchemeStorageMap = new HashMap();
        public HashMap<String, PSSysDBTableStorage> psSysDBTableStorageMap = new HashMap();
        public ArrayList<PSSysContentCat> psSysContentCatList = new ArrayList();
        public HashMap<String, PSSysContentCatStorage> psSysContentCatStorageMap = new HashMap();
        public ArrayList<PSSysResource> psSysResourceList = new ArrayList();
        public HashMap<String, PSSysResource> psSysResourceMap = new HashMap();
        public ArrayList<PSDEGroup> psDEGroupList = new ArrayList();
        public ArrayList<PSDERGroup> psDERGroupList = new ArrayList();
        public HashMap<String, PSDEGroupStorage> psDEGroupStorageMap = new HashMap();
        public HashMap<String, PSDERGroupStorage> psDERGroupStorageMap = new HashMap();
        public HashMap<String, PSDEActionGroupStorage> psDEActionGroupStorageMap = new HashMap();
        public HashMap<String, PSSysContent> psSysContentMap = new HashMap();
        public ArrayList<PSSysTestPrj> psSysTestPrjList = new ArrayList();
        public HashMap<String, PSSysTestPrj> psSysTestPrjMap = new HashMap();
        public HashMap<String, PSSysTestPrjStorage> psSysTestPrjStorageMap = new HashMap();
        public HashMap<String, PSSysTestModule> psSysTestModuleMap = new HashMap();
        public HashMap<String, PSSysTestModuleStorage> psSysTestModuleStorageMap = new HashMap();
        public HashMap<String, PSSysReqItem> psSysReqItemMap = new HashMap();
        public ArrayList<PSSysReqModule> psSysReqModuleList = new ArrayList();
        public ArrayList<PSSysReqItem> psSysReqItemList = new ArrayList();
        public HashMap<String, PSSysReqModuleStorage> psSysReqModuleStorageMap = new HashMap();
        public ArrayList<PSSysSearchScheme> psSysSearchSchemeList = new ArrayList();
        public HashMap<String, PSSysSearchScheme> psSysSearchSchemeMap = new HashMap();
        public HashMap<String, PSSysSearchSchemeStorage> psSysSearchSchemeStorageMap = new HashMap();
        public HashMap<String, PSSysSearchDocStorage> psSysSearchDocStorageMap = new HashMap();
        public HashMap<String, PSSysSearchDEStorage> psSysSearchDEStorageMap = new HashMap();
        public ArrayList<PSSysPortletCat> psSysPortletCatList = new ArrayList();
        public HashMap<String, PSSysPortletCat> psSysPortletCatMap = new HashMap();
        public ArrayList<PSSysSequence> psSysSequenceList = new ArrayList();
        public HashMap<String, PSSysSequence> psSysSequenceMap = new HashMap();
        public ArrayList<PSSysTranslator> psSysTranslatorList = new ArrayList();
        public HashMap<String, PSSysTranslator> psSysTranslatorMap = new HashMap();
        public ArrayList<PSSysMsgTarget> psSysMsgTargetList = new ArrayList();
        public ArrayList<PSSysMsgQueue> psSysMsgQueueList = new ArrayList();
        public HashMap<String, PSDENotifyStorage> psDENotifyStorageMap = new HashMap();
        public ArrayList<PSSysEAIScheme> psSysEAISchemeList = new ArrayList();
        public HashMap<String, PSSysEAIScheme> psSysEAISchemeMap = new HashMap();
        public HashMap<String, PSSysEAISchemeStorage> psSysEAISchemeStorageMap = new HashMap();
        public HashMap<String, PSSysEAIDataTypeStorage> psSysEAIDataTypeStorageMap = new HashMap();
        public HashMap<String, PSSysEAIElementStorage> psSysEAIElementStorageMap = new HashMap();
        public HashMap<String, PSSysEAIDEStorage> psSysEAIDEStorageMap = new HashMap();
        public ArrayList<PSSysBIScheme> psSysBISchemeList = new ArrayList();
        public HashMap<String, PSSysBIScheme> psSysBISchemeMap = new HashMap();
        public HashMap<String, PSSysBISchemeStorage> psSysBISchemeStorageMap = new HashMap();
        public HashMap<String, PSSysBIDimensionStorage> psSysBIDimensionStorageMap = new HashMap();
        public HashMap<String, PSSysBICubeStorage> psSysBICubeStorageMap = new HashMap();
        public HashMap<String, PSSysBIAggTableStorage> psSysBIAggTableStorageMap = new HashMap();
        public HashMap<String, PSSysBIHierarchyStorage> psSysBIHierarchyStorageMap = new HashMap();
        public HashMap<String, PSSysBICubeDimensionStorage> psSysBICubeDimensionStorageMap = new HashMap();
        public HashMap<String, PSSysBIReportStorage> psSysBIReportStorageMap = new HashMap();
        public HashMap<String, PSThresholdGroupStorage> psThresholdGroupStorageMap = new HashMap();
        public ArrayList<PSThresholdGroup> psThresholdGroupList = new ArrayList();
        public HashMap<String, PSThresholdGroup> psThresholdGroupMap = new HashMap();
        public ArrayList<PSSysChartTheme> psSysChartThemeList = new ArrayList();
        public HashMap<String, PSSysChartTheme> psSysChartThemeMap = new HashMap();
        public ArrayList<PSSysDBValueFunc> psSysDBValueFuncList = new ArrayList();
        public HashMap<String, PSSysDBValueFunc> psSysDBValueFuncMap = new HashMap();
        public ArrayList<PSDELogic> psDELogicList = new ArrayList();
        public HashMap<String, PSDELogic> psDELogicMap = new HashMap();
        public ArrayList<PSDEUIAction> psDEUIActionList2 = new ArrayList();
        public ArrayList<PSCtrlLogicGroup> psCtrlLogicGroupList2 = new ArrayList();
        public HashMap<String, PSCtrlMsgStorage> psCtrlMsgStorageMap = new HashMap();
        public HashMap<String, PSDEFormStorage> psDEFormStorageMap = new HashMap();
        public ArrayList<PSSysAIFactory> psSysAIFactoryList = new ArrayList();
        public HashMap<String, PSSysAIFactory> psSysAIFactoryMap = new HashMap();
        public HashMap<String, PSSysAIFactoryStorage> psSysAIFactoryStorageMap = new HashMap();
        public HashMap<String, PSSysAIPipelineStorage> psSysAIPipelineStorageMap = new HashMap();

        public PSDataEntityStorage getPSDataEntityStorage(String strDEId) {
            PSDataEntityStorage psDataEntityStorage = this.psDataEntityStorageMap.get(strDEId);
            if (psDataEntityStorage == null) {
                psDataEntityStorage = new PSDataEntityStorage();
                this.psDataEntityStorageMap.put(strDEId, psDataEntityStorage);
            }
            return psDataEntityStorage;
        }

        public PSCodeListStorage getPSCodeListStorage(String strCodeListId) {
            PSCodeListStorage psCodeListStorage = this.psCodeListStorageMap.get(strCodeListId);
            if (psCodeListStorage == null) {
                psCodeListStorage = new PSCodeListStorage();
                this.psCodeListStorageMap.put(strCodeListId, psCodeListStorage);
            }
            return psCodeListStorage;
        }

        public PSThresholdGroupStorage getPSThresholdGroupStorage(String strThresholdGroupId) {
            PSThresholdGroupStorage psThresholdGroupStorage = this.psThresholdGroupStorageMap.get(strThresholdGroupId);
            if (psThresholdGroupStorage == null) {
                psThresholdGroupStorage = new PSThresholdGroupStorage();
                this.psThresholdGroupStorageMap.put(strThresholdGroupId, psThresholdGroupStorage);
            }
            return psThresholdGroupStorage;
        }

        public PSDEDataSetStorage getPSDEDataSetStorage(String strDEId) {
            PSDEDataSetStorage psDEDataSetStorage = this.psDEDataSetStorageMap.get(strDEId);
            if (psDEDataSetStorage == null) {
                psDEDataSetStorage = new PSDEDataSetStorage();
                this.psDEDataSetStorageMap.put(strDEId, psDEDataSetStorage);
            }
            return psDEDataSetStorage;
        }

        public PSDEDataQueryStorage getPSDEDataQueryStorage(String strDEId) {
            PSDEDataQueryStorage psDEDataQueryStorage = this.psDEDataQueryStorageMap.get(strDEId);
            if (psDEDataQueryStorage == null) {
                psDEDataQueryStorage = new PSDEDataQueryStorage();
                this.psDEDataQueryStorageMap.put(strDEId, psDEDataQueryStorage);
            }
            return psDEDataQueryStorage;
        }

        public PSDEDataQueryCodeStorage getPSDEDataQueryCodeStorage(String strDEId) {
            PSDEDataQueryCodeStorage psDEDataQueryCodeStorage = this.psDEDataQueryCodeStorageMap.get(strDEId);
            if (psDEDataQueryCodeStorage == null) {
                psDEDataQueryCodeStorage = new PSDEDataQueryCodeStorage();
                this.psDEDataQueryCodeStorageMap.put(strDEId, psDEDataQueryCodeStorage);
            }
            return psDEDataQueryCodeStorage;
        }

        public PSDEActionStorage getPSDEActionStorage(String strDEId) {
            PSDEActionStorage psDEActionStorage = this.psDEActionStorageMap.get(strDEId);
            if (psDEActionStorage == null) {
                psDEActionStorage = new PSDEActionStorage();
                this.psDEActionStorageMap.put(strDEId, psDEActionStorage);
            }
            return psDEActionStorage;
        }

        public PSDEFValueRuleStorage getPSDEFValueRuleStorage(String strDEId) {
            PSDEFValueRuleStorage psDEFValueRuleStorage = this.psDEFValueRuleStorageMap.get(strDEId);
            if (psDEFValueRuleStorage == null) {
                psDEFValueRuleStorage = new PSDEFValueRuleStorage();
                this.psDEFValueRuleStorageMap.put(strDEId, psDEFValueRuleStorage);
            }
            return psDEFValueRuleStorage;
        }

        public PSDEMapStorage getPSDEMapStorage(String strDEId) {
            PSDEMapStorage psDEMapStorage = this.psDEMapStorageMap.get(strDEId);
            if (psDEMapStorage == null) {
                psDEMapStorage = new PSDEMapStorage();
                this.psDEMapStorageMap.put(strDEId, psDEMapStorage);
            }
            return psDEMapStorage;
        }

        public PSDEACModeStorage getPSDEACModeStorage(String strDEId) {
            PSDEACModeStorage psDEACModeStorage = this.psDEACModeStorageMap.get(strDEId);
            if (psDEACModeStorage == null) {
                psDEACModeStorage = new PSDEACModeStorage();
                this.psDEACModeStorageMap.put(strDEId, psDEACModeStorage);
            }
            return psDEACModeStorage;
        }

        public PSDEUIActionGroupStorage getPSDEUIActionGroupStorage(String strDEId) {
            PSDEUIActionGroupStorage psDEUIActionGroupStorage = this.psDEUIActionGroupStorageMap.get(strDEId);
            if (psDEUIActionGroupStorage == null) {
                psDEUIActionGroupStorage = new PSDEUIActionGroupStorage();
                this.psDEUIActionGroupStorageMap.put(strDEId, psDEUIActionGroupStorage);
            }
            return psDEUIActionGroupStorage;
        }

        public PSDELogicStorage getPSDELogicStorage(String strDEId) {
            PSDELogicStorage psDELogicStorage = this.psDELogicStorageMap.get(strDEId);
            if (psDELogicStorage == null) {
                psDELogicStorage = new PSDELogicStorage();
                this.psDELogicStorageMap.put(strDEId, psDELogicStorage);
            }
            return psDELogicStorage;
        }

        public PSDEDataRelationStorage getPSDEDataRelationStorage(String strDEId) {
            PSDEDataRelationStorage psDEDataRelationStorage = this.psDEDataRelationStorageMap.get(strDEId);
            if (psDEDataRelationStorage == null) {
                psDEDataRelationStorage = new PSDEDataRelationStorage();
                this.psDEDataRelationStorageMap.put(strDEId, psDEDataRelationStorage);
            }
            return psDEDataRelationStorage;
        }

        public PSDEMainStateStorage getPSDEMainStateStorage(String strDEId) {
            PSDEMainStateStorage psDEMainStateStorage = this.psDEMainStateStorageMap.get(strDEId);
            if (psDEMainStateStorage == null) {
                psDEMainStateStorage = new PSDEMainStateStorage();
                this.psDEMainStateStorageMap.put(strDEId, psDEMainStateStorage);
            }
            return psDEMainStateStorage;
        }

        public PSDEDBIndexStorage getPSDEDBIndexStorage(String strDEId) {
            PSDEDBIndexStorage psDEDBIndexStorage = this.psDEDBIndexStorageMap.get(strDEId);
            if (psDEDBIndexStorage == null) {
                psDEDBIndexStorage = new PSDEDBIndexStorage();
                this.psDEDBIndexStorageMap.put(strDEId, psDEDBIndexStorage);
            }
            return psDEDBIndexStorage;
        }

        public PSDEReportStorage getPSDEReportStorage(String strDEId) {
            PSDEReportStorage psDEReportStorage = this.psDEReportStorageMap.get(strDEId);
            if (psDEReportStorage == null) {
                psDEReportStorage = new PSDEReportStorage();
                this.psDEReportStorageMap.put(strDEId, psDEReportStorage);
            }
            return psDEReportStorage;
        }

        public PSDEPrintStorage getPSDEPrintStorage(String strDEId) {
            PSDEPrintStorage psDEPrintStorage = this.psDEPrintStorageMap.get(strDEId);
            if (psDEPrintStorage == null) {
                psDEPrintStorage = new PSDEPrintStorage();
                this.psDEPrintStorageMap.put(strDEId, psDEPrintStorage);
            }
            return psDEPrintStorage;
        }

        public PSSysTestCaseStorage getPSSysTestCaseStorage(String strSysTestCaseId) {
            PSSysTestCaseStorage psSysTestCaseStorage = this.psSysTestCaseStorageMap.get(strSysTestCaseId);
            if (psSysTestCaseStorage == null) {
                psSysTestCaseStorage = new PSSysTestCaseStorage();
                this.psSysTestCaseStorageMap.put(strSysTestCaseId, psSysTestCaseStorage);
            }
            return psSysTestCaseStorage;
        }

        public PSSysTestCaseInputStorage getPSSysTestCaseInputStorage(String strSysTestCaseInputId) {
            PSSysTestCaseInputStorage psSysTestCaseInputStorage = this.psSysTestCaseInputStorageMap.get(strSysTestCaseInputId);
            if (psSysTestCaseInputStorage == null) {
                psSysTestCaseInputStorage = new PSSysTestCaseInputStorage();
                this.psSysTestCaseInputStorageMap.put(strSysTestCaseInputId, psSysTestCaseInputStorage);
            }
            return psSysTestCaseInputStorage;
        }

        public PSSysTestDataStorage getPSSysTestDataStorage(String strSysTestDataId) {
            PSSysTestDataStorage psSysTestDataStorage = this.psSysTestDataStorageMap.get(strSysTestDataId);
            if (psSysTestDataStorage == null) {
                psSysTestDataStorage = new PSSysTestDataStorage();
                this.psSysTestDataStorageMap.put(strSysTestDataId, psSysTestDataStorage);
            }
            return psSysTestDataStorage;
        }

        public PSDERStorage getPSDERStorage(String strDERId) {
            PSDERStorage psDERStorage = this.psDERStorageMap.get(strDERId);
            if (psDERStorage == null) {
                psDERStorage = new PSDERStorage();
                this.psDERStorageMap.put(strDERId, psDERStorage);
            }
            return psDERStorage;
        }

        public PSSysERMapStorage getPSSysERMapStorage(String strSysERMapId) {
            PSSysERMapStorage psSysERMapStorage = this.psSysERMapStorageMap.get(strSysERMapId);
            if (psSysERMapStorage == null) {
                psSysERMapStorage = new PSSysERMapStorage();
                this.psSysERMapStorageMap.put(strSysERMapId, psSysERMapStorage);
            }
            return psSysERMapStorage;
        }

        public PSSysUCMapStorage getPSSysUCMapStorage(String strSysUCMapId) {
            PSSysUCMapStorage psSysUCMapStorage = this.psSysUCMapStorageMap.get(strSysUCMapId);
            if (psSysUCMapStorage == null) {
                psSysUCMapStorage = new PSSysUCMapStorage();
                this.psSysUCMapStorageMap.put(strSysUCMapId, psSysUCMapStorage);
            }
            return psSysUCMapStorage;
        }

        public PSSysDynaModelStorage getPSSysDynaModelStorage(String strSysDynaModelId) {
            PSSysDynaModelStorage psSysDynaModelStorage = this.psSysDynaModelStorageMap.get(strSysDynaModelId);
            if (psSysDynaModelStorage == null) {
                psSysDynaModelStorage = new PSSysDynaModelStorage();
                this.psSysDynaModelStorageMap.put(strSysDynaModelId, psSysDynaModelStorage);
            }
            return psSysDynaModelStorage;
        }

        public PSDynaDETemplStorage getPSDynaDETemplStorage(String strDynaDETemplId) {
            PSDynaDETemplStorage psDynaDETemplStorage = this.psDynaDETemplStorageMap.get(strDynaDETemplId);
            if (psDynaDETemplStorage == null) {
                psDynaDETemplStorage = new PSDynaDETemplStorage();
                this.psDynaDETemplStorageMap.put(strDynaDETemplId, psDynaDETemplStorage);
            }
            return psDynaDETemplStorage;
        }

        public PSDEWizardStorage getPSDEWizardStorage(String strDEId) {
            PSDEWizardStorage psDEWizardStorage = this.psDEWizardStorageMap.get(strDEId);
            if (psDEWizardStorage == null) {
                psDEWizardStorage = new PSDEWizardStorage();
                this.psDEWizardStorageMap.put(strDEId, psDEWizardStorage);
            }
            return psDEWizardStorage;
        }

        public PSDEDataSyncStorage getPSDEDataSyncStorage(String strDEId) {
            PSDEDataSyncStorage psDEDataSyncStorage = this.psDEDataSyncStorageMap.get(strDEId);
            if (psDEDataSyncStorage == null) {
                psDEDataSyncStorage = new PSDEDataSyncStorage();
                this.psDEDataSyncStorageMap.put(strDEId, psDEDataSyncStorage);
            }
            return psDEDataSyncStorage;
        }

        public PSSysBDSchemeStorage getPSSysBDSchemeStorage(String strSysBDSchemeId) {
            PSSysBDSchemeStorage psSysBDSchemeStorage = this.psSysBDSchemeStorageMap.get(strSysBDSchemeId);
            if (psSysBDSchemeStorage == null) {
                psSysBDSchemeStorage = new PSSysBDSchemeStorage();
                this.psSysBDSchemeStorageMap.put(strSysBDSchemeId, psSysBDSchemeStorage);
            }
            return psSysBDSchemeStorage;
        }

        public PSSysBDTableStorage getPSSysBDTableStorage(String strSysBDTableId) {
            PSSysBDTableStorage psSysBDTableStorage = this.psSysBDTableStorageMap.get(strSysBDTableId);
            if (psSysBDTableStorage == null) {
                psSysBDTableStorage = new PSSysBDTableStorage();
                this.psSysBDTableStorageMap.put(strSysBDTableId, psSysBDTableStorage);
            }
            return psSysBDTableStorage;
        }

        public PSDEDataExportStorage getPSDEDataExportStorage(String strDEDataExportId) {
            PSDEDataExportStorage psDEDataExportStorage = this.psDEDataExportStorageMap.get(strDEDataExportId);
            if (psDEDataExportStorage == null) {
                psDEDataExportStorage = new PSDEDataExportStorage();
                this.psDEDataExportStorageMap.put(strDEDataExportId, psDEDataExportStorage);
            }
            return psDEDataExportStorage;
        }

        public PSDEDataImportStorage getPSDEDataImportStorage(String strDEDataImportId) {
            PSDEDataImportStorage psDEDataImportStorage = this.psDEDataImportStorageMap.get(strDEDataImportId);
            if (psDEDataImportStorage == null) {
                psDEDataImportStorage = new PSDEDataImportStorage();
                this.psDEDataImportStorageMap.put(strDEDataImportId, psDEDataImportStorage);
            }
            return psDEDataImportStorage;
        }

        public PSDEActionWizardStorage getPSDEActionWizardStorage(String strDEId) {
            PSDEActionWizardStorage psDEActionWizardStorage = this.psDEActionWizardStorageMap.get(strDEId);
            if (psDEActionWizardStorage == null) {
                psDEActionWizardStorage = new PSDEActionWizardStorage();
                this.psDEActionWizardStorageMap.put(strDEId, psDEActionWizardStorage);
            }
            return psDEActionWizardStorage;
        }

        public PSDEActionWizardGroupStorage getPSDEActionWizardGroupStorage(String strDEId) {
            PSDEActionWizardGroupStorage psDEActionWizardGroupStorage = this.psDEActionWizardGroupStorageMap.get(strDEId);
            if (psDEActionWizardGroupStorage == null) {
                psDEActionWizardGroupStorage = new PSDEActionWizardGroupStorage();
                this.psDEActionWizardGroupStorageMap.put(strDEId, psDEActionWizardGroupStorage);
            }
            return psDEActionWizardGroupStorage;
        }

        public PSViewMsgGroupStorage getPSViewMsgGroupStorage(String strDEId) {
            PSViewMsgGroupStorage psViewMsgGroupStorage = this.psViewMsgGroupStorageMap.get(strDEId);
            if (psViewMsgGroupStorage == null) {
                psViewMsgGroupStorage = new PSViewMsgGroupStorage();
                this.psViewMsgGroupStorageMap.put(strDEId, psViewMsgGroupStorage);
            }
            return psViewMsgGroupStorage;
        }

        public PSWFVersionStorage getPSWFVersionStorage(String strDEId) {
            PSWFVersionStorage psWFVersionStorage = this.psWFVersionStorageMap.get(strDEId);
            if (psWFVersionStorage == null) {
                psWFVersionStorage = new PSWFVersionStorage();
                this.psWFVersionStorageMap.put(strDEId, psWFVersionStorage);
            }
            return psWFVersionStorage;
        }

        public PSWorkflowStorage getPSWorkflowStorage(String strDEId) {
            PSWorkflowStorage psWorkflowStorage = this.psWorkflowStorageMap.get(strDEId);
            if (psWorkflowStorage == null) {
                psWorkflowStorage = new PSWorkflowStorage();
                this.psWorkflowStorageMap.put(strDEId, psWorkflowStorage);
            }
            return psWorkflowStorage;
        }

        public PSWXAccountStorage getPSWXAccountStorage(String strWXAccountId) {
            PSWXAccountStorage psWXAccountStorage = this.psWXAccountStorageMap.get(strWXAccountId);
            if (psWXAccountStorage == null) {
                psWXAccountStorage = new PSWXAccountStorage();
                this.psWXAccountStorageMap.put(strWXAccountId, psWXAccountStorage);
            }
            return psWXAccountStorage;
        }

        public PSWXMenuStorage getPSWXMenuStorage(String strWXMenuId) {
            PSWXMenuStorage psWXMenuStorage = this.psWXMenuStorageMap.get(strWXMenuId);
            if (psWXMenuStorage == null) {
                psWXMenuStorage = new PSWXMenuStorage();
                this.psWXMenuStorageMap.put(strWXMenuId, psWXMenuStorage);
            }
            return psWXMenuStorage;
        }

        public PSWXEntAppStorage getPSWXEntAppStorage(String strWXEntAppId) {
            PSWXEntAppStorage psWXEntAppStorage = this.psWXEntAppStorageMap.get(strWXEntAppId);
            if (psWXEntAppStorage == null) {
                psWXEntAppStorage = new PSWXEntAppStorage();
                this.psWXEntAppStorageMap.put(strWXEntAppId, psWXEntAppStorage);
            }
            return psWXEntAppStorage;
        }

        public PSSysServiceAPIStorage getPSSysServiceAPIStorage(String strDEId, boolean bCreateIfNull) {
            PSSysServiceAPIStorage psSysServiceAPIStorage = this.psSysServiceAPIStorageMap.get(strDEId);
            if (psSysServiceAPIStorage == null && bCreateIfNull) {
                psSysServiceAPIStorage = new PSSysServiceAPIStorage();
                this.psSysServiceAPIStorageMap.put(strDEId, psSysServiceAPIStorage);
            }
            return psSysServiceAPIStorage;
        }

        public PSDEServiceAPIStorage getPSDEServiceAPIStorage(String strDEId, boolean bCreateIfNull) {
            PSDEServiceAPIStorage psDEServiceAPIStorage = this.psDEServiceAPIStorageMap.get(strDEId);
            if (psDEServiceAPIStorage == null && bCreateIfNull) {
                psDEServiceAPIStorage = new PSDEServiceAPIStorage();
                this.psDEServiceAPIStorageMap.put(strDEId, psDEServiceAPIStorage);
            }
            return psDEServiceAPIStorage;
        }

        public PSSubSysServiceAPIStorage getPSSubSysServiceAPIStorage(String strDEId, boolean bCreateIfNull) {
            PSSubSysServiceAPIStorage psSubSysServiceAPIStorage = this.psSubSysServiceAPIStorageMap.get(strDEId);
            if (psSubSysServiceAPIStorage == null && bCreateIfNull) {
                psSubSysServiceAPIStorage = new PSSubSysServiceAPIStorage();
                this.psSubSysServiceAPIStorageMap.put(strDEId, psSubSysServiceAPIStorage);
            }
            return psSubSysServiceAPIStorage;
        }

        public PSSysServiceAPIHandlerStorage getPSSysServiceAPIHandlerStorage(String strDEId, boolean bCreateIfNull) {
            PSSysServiceAPIHandlerStorage psSysServiceAPIHandlerStorage = this.psSysServiceAPIHandlerStorageMap.get(strDEId);
            if (psSysServiceAPIHandlerStorage == null && bCreateIfNull) {
                psSysServiceAPIHandlerStorage = new PSSysServiceAPIHandlerStorage();
                this.psSysServiceAPIHandlerStorageMap.put(strDEId, psSysServiceAPIHandlerStorage);
            }
            return psSysServiceAPIHandlerStorage;
        }

        public PSDEUserRoleStorage getPSDEUserRoleStorage(String strDEId) {
            PSDEUserRoleStorage psDEUserRoleStorage = this.psDEUserRoleStorageMap.get(strDEId);
            if (psDEUserRoleStorage == null) {
                psDEUserRoleStorage = new PSDEUserRoleStorage();
                this.psDEUserRoleStorageMap.put(strDEId, psDEUserRoleStorage);
            }
            return psDEUserRoleStorage;
        }

        public PSDEOPPrivRoleStorage getPSDEOPPrivRoleStorage(String strDEId) {
            PSDEOPPrivRoleStorage psDEOPPrivRoleStorage = this.psDEOPPrivRoleStorageMap.get(strDEId);
            if (psDEOPPrivRoleStorage == null) {
                psDEOPPrivRoleStorage = new PSDEOPPrivRoleStorage();
                this.psDEOPPrivRoleStorageMap.put(strDEId, psDEOPPrivRoleStorage);
            }
            return psDEOPPrivRoleStorage;
        }

        public PSSysUserRoleStorage getPSSysUserRoleStorage(String strDEId) {
            PSSysUserRoleStorage psSysUserRoleStorage = this.psSysUserRoleStorageMap.get(strDEId);
            if (psSysUserRoleStorage == null) {
                psSysUserRoleStorage = new PSSysUserRoleStorage();
                this.psSysUserRoleStorageMap.put(strDEId, psSysUserRoleStorage);
            }
            return psSysUserRoleStorage;
        }

        public PSDEUtilStorage getPSDEUtilStorage(String strDEId) {
            PSDEUtilStorage psDEUtilStorage = this.psDEUtilStorageMap.get(strDEId);
            if (psDEUtilStorage == null) {
                psDEUtilStorage = new PSDEUtilStorage();
                this.psDEUtilStorageMap.put(strDEId, psDEUtilStorage);
            }
            return psDEUtilStorage;
        }

        public PSSysViewLogicStorage getPSSysViewLogicStorage(String strSysViewLogicId) {
            PSSysViewLogicStorage psSysViewLogicStorage = this.psSysViewLogicStorageMap.get(strSysViewLogicId);
            if (psSysViewLogicStorage == null) {
                psSysViewLogicStorage = new PSSysViewLogicStorage();
                this.psSysViewLogicStorageMap.put(strSysViewLogicId, psSysViewLogicStorage);
            }
            return psSysViewLogicStorage;
        }

        public PSDEFGroupStorage getPSDEFGroupStorage(String strDEId) {
            PSDEFGroupStorage psDEFGroupStorage = this.psDEFGroupStorageMap.get(strDEId);
            if (psDEFGroupStorage == null) {
                psDEFGroupStorage = new PSDEFGroupStorage();
                this.psDEFGroupStorageMap.put(strDEId, psDEFGroupStorage);
            }
            return psDEFGroupStorage;
        }

        public PSSubSysSADEStorage getPSSubSysSADEStorage(String strPSSubSysSADEId, boolean bCreateIfNull) {
            PSSubSysSADEStorage psSubSysSADEStorage = this.psSubSysSADEStorageMap.get(strPSSubSysSADEId);
            if (psSubSysSADEStorage == null && bCreateIfNull) {
                psSubSysSADEStorage = new PSSubSysSADEStorage();
                this.psSubSysSADEStorageMap.put(strPSSubSysSADEId, psSubSysSADEStorage);
            }
            return psSubSysSADEStorage;
        }

        public PSSysDBSchemeStorage getPSSysDBSchemeStorage(String strSysDBSchemeId) {
            PSSysDBSchemeStorage psSysDBSchemeStorage = this.psSysDBSchemeStorageMap.get(strSysDBSchemeId);
            if (psSysDBSchemeStorage == null) {
                psSysDBSchemeStorage = new PSSysDBSchemeStorage();
                this.psSysDBSchemeStorageMap.put(strSysDBSchemeId, psSysDBSchemeStorage);
            }
            return psSysDBSchemeStorage;
        }

        public PSSysDBTableStorage getPSSysDBTableStorage(String strSysDBTableId) {
            PSSysDBTableStorage psSysDBTableStorage = this.psSysDBTableStorageMap.get(strSysDBTableId);
            if (psSysDBTableStorage == null) {
                psSysDBTableStorage = new PSSysDBTableStorage();
                this.psSysDBTableStorageMap.put(strSysDBTableId, psSysDBTableStorage);
            }
            return psSysDBTableStorage;
        }

        public PSDEGroupStorage getPSDEGroupStorage(String strPSDEGroupId) {
            PSDEGroupStorage psDEGroupStorage = this.psDEGroupStorageMap.get(strPSDEGroupId);
            if (psDEGroupStorage == null) {
                psDEGroupStorage = new PSDEGroupStorage();
                this.psDEGroupStorageMap.put(strPSDEGroupId, psDEGroupStorage);
            }
            return psDEGroupStorage;
        }

        public PSDERGroupStorage getPSDERGroupStorage(String strPSDERGroupId) {
            PSDERGroupStorage psDERGroupStorage = this.psDERGroupStorageMap.get(strPSDERGroupId);
            if (psDERGroupStorage == null) {
                psDERGroupStorage = new PSDERGroupStorage();
                this.psDERGroupStorageMap.put(strPSDERGroupId, psDERGroupStorage);
            }
            return psDERGroupStorage;
        }

        public PSDEActionGroupStorage getPSDEActionGroupStorage(String strDEId) {
            PSDEActionGroupStorage psDEActionGroupStorage = this.psDEActionGroupStorageMap.get(strDEId);
            if (psDEActionGroupStorage == null) {
                psDEActionGroupStorage = new PSDEActionGroupStorage();
                this.psDEActionGroupStorageMap.put(strDEId, psDEActionGroupStorage);
            }
            return psDEActionGroupStorage;
        }

        public PSSysContentCatStorage getPSSysContentCatStorage(String strPSSysContentCatId) {
            PSSysContentCatStorage psSysContentCatStorage = this.psSysContentCatStorageMap.get(strPSSysContentCatId);
            if (psSysContentCatStorage == null) {
                psSysContentCatStorage = new PSSysContentCatStorage();
                this.psSysContentCatStorageMap.put(strPSSysContentCatId, psSysContentCatStorage);
            }
            return psSysContentCatStorage;
        }

        public PSSysTestPrjStorage getPSSysTestPrjStorage(String strSysTestPrjId) {
            PSSysTestPrjStorage psSysTestPrjStorage = this.psSysTestPrjStorageMap.get(strSysTestPrjId);
            if (psSysTestPrjStorage == null) {
                psSysTestPrjStorage = new PSSysTestPrjStorage();
                this.psSysTestPrjStorageMap.put(strSysTestPrjId, psSysTestPrjStorage);
            }
            return psSysTestPrjStorage;
        }

        public PSSysTestModuleStorage getPSSysTestModuleStorage(String strSysTestModuleId) {
            PSSysTestModuleStorage psSysTestModuleStorage = this.psSysTestModuleStorageMap.get(strSysTestModuleId);
            if (psSysTestModuleStorage == null) {
                psSysTestModuleStorage = new PSSysTestModuleStorage();
                this.psSysTestModuleStorageMap.put(strSysTestModuleId, psSysTestModuleStorage);
            }
            return psSysTestModuleStorage;
        }

        public PSSysReqModuleStorage getPSSysReqModuleStorage(String strPSSysReqModuleId) {
            PSSysReqModuleStorage psSysReqModuleStorage = this.psSysReqModuleStorageMap.get(strPSSysReqModuleId);
            if (psSysReqModuleStorage == null) {
                psSysReqModuleStorage = new PSSysReqModuleStorage();
                this.psSysReqModuleStorageMap.put(strPSSysReqModuleId, psSysReqModuleStorage);
            }
            return psSysReqModuleStorage;
        }

        public PSSysSearchSchemeStorage getPSSysSearchSchemeStorage(String strSysSearchSchemeId) {
            PSSysSearchSchemeStorage psSysSearchSchemeStorage = this.psSysSearchSchemeStorageMap.get(strSysSearchSchemeId);
            if (psSysSearchSchemeStorage == null) {
                psSysSearchSchemeStorage = new PSSysSearchSchemeStorage();
                this.psSysSearchSchemeStorageMap.put(strSysSearchSchemeId, psSysSearchSchemeStorage);
            }
            return psSysSearchSchemeStorage;
        }

        public PSSysSearchDocStorage getPSSysSearchDocStorage(String strSysSearchDocId) {
            PSSysSearchDocStorage psSysSearchDocStorage = this.psSysSearchDocStorageMap.get(strSysSearchDocId);
            if (psSysSearchDocStorage == null) {
                psSysSearchDocStorage = new PSSysSearchDocStorage();
                this.psSysSearchDocStorageMap.put(strSysSearchDocId, psSysSearchDocStorage);
            }
            return psSysSearchDocStorage;
        }

        public PSSysSearchDEStorage getPSSysSearchDEStorage(String strSysSearchDEId) {
            PSSysSearchDEStorage psSysSearchDEStorage = this.psSysSearchDEStorageMap.get(strSysSearchDEId);
            if (psSysSearchDEStorage == null) {
                psSysSearchDEStorage = new PSSysSearchDEStorage();
                this.psSysSearchDEStorageMap.put(strSysSearchDEId, psSysSearchDEStorage);
            }
            return psSysSearchDEStorage;
        }

        public PSDENotifyStorage getPSDENotifyStorage(String strDENotifyId) {
            PSDENotifyStorage psDENotifyStorage = this.psDENotifyStorageMap.get(strDENotifyId);
            if (psDENotifyStorage == null) {
                psDENotifyStorage = new PSDENotifyStorage();
                this.psDENotifyStorageMap.put(strDENotifyId, psDENotifyStorage);
            }
            return psDENotifyStorage;
        }

        public PSSysEAISchemeStorage getPSSysEAISchemeStorage(String strSysEAISchemeId) {
            PSSysEAISchemeStorage psSysEAISchemeStorage = this.psSysEAISchemeStorageMap.get(strSysEAISchemeId);
            if (psSysEAISchemeStorage == null) {
                psSysEAISchemeStorage = new PSSysEAISchemeStorage();
                this.psSysEAISchemeStorageMap.put(strSysEAISchemeId, psSysEAISchemeStorage);
            }
            return psSysEAISchemeStorage;
        }

        public PSSysEAIDataTypeStorage getPSSysEAIDataTypeStorage(String strSysEAIDataTypeId) {
            PSSysEAIDataTypeStorage psSysEAIDataTypeStorage = this.psSysEAIDataTypeStorageMap.get(strSysEAIDataTypeId);
            if (psSysEAIDataTypeStorage == null) {
                psSysEAIDataTypeStorage = new PSSysEAIDataTypeStorage();
                this.psSysEAIDataTypeStorageMap.put(strSysEAIDataTypeId, psSysEAIDataTypeStorage);
            }
            return psSysEAIDataTypeStorage;
        }

        public PSSysEAIElementStorage getPSSysEAIElementStorage(String strSysEAIElementId) {
            PSSysEAIElementStorage psSysEAIElementStorage = this.psSysEAIElementStorageMap.get(strSysEAIElementId);
            if (psSysEAIElementStorage == null) {
                psSysEAIElementStorage = new PSSysEAIElementStorage();
                this.psSysEAIElementStorageMap.put(strSysEAIElementId, psSysEAIElementStorage);
            }
            return psSysEAIElementStorage;
        }

        public PSSysEAIDEStorage getPSSysEAIDEStorage(String strSysEAIDEId) {
            PSSysEAIDEStorage psSysEAIDEStorage = this.psSysEAIDEStorageMap.get(strSysEAIDEId);
            if (psSysEAIDEStorage == null) {
                psSysEAIDEStorage = new PSSysEAIDEStorage();
                this.psSysEAIDEStorageMap.put(strSysEAIDEId, psSysEAIDEStorage);
            }
            return psSysEAIDEStorage;
        }

        public PSSysBISchemeStorage getPSSysBISchemeStorage(String strSysBISchemeId) {
            PSSysBISchemeStorage psSysBISchemeStorage = this.psSysBISchemeStorageMap.get(strSysBISchemeId);
            if (psSysBISchemeStorage == null) {
                psSysBISchemeStorage = new PSSysBISchemeStorage();
                this.psSysBISchemeStorageMap.put(strSysBISchemeId, psSysBISchemeStorage);
            }
            return psSysBISchemeStorage;
        }

        public PSSysBIDimensionStorage getPSSysBIDimensionStorage(String strSysBIDimensionId) {
            PSSysBIDimensionStorage psSysBIDimensionStorage = this.psSysBIDimensionStorageMap.get(strSysBIDimensionId);
            if (psSysBIDimensionStorage == null) {
                psSysBIDimensionStorage = new PSSysBIDimensionStorage();
                this.psSysBIDimensionStorageMap.put(strSysBIDimensionId, psSysBIDimensionStorage);
            }
            return psSysBIDimensionStorage;
        }

        public PSSysBIHierarchyStorage getPSSysBIHierarchyStorage(String strSysBIHierarchyId) {
            PSSysBIHierarchyStorage psSysBIHierarchyStorage = this.psSysBIHierarchyStorageMap.get(strSysBIHierarchyId);
            if (psSysBIHierarchyStorage == null) {
                psSysBIHierarchyStorage = new PSSysBIHierarchyStorage();
                this.psSysBIHierarchyStorageMap.put(strSysBIHierarchyId, psSysBIHierarchyStorage);
            }
            return psSysBIHierarchyStorage;
        }

        public PSSysBICubeStorage getPSSysBICubeStorage(String strSysBICubeId) {
            PSSysBICubeStorage psSysBICubeStorage = this.psSysBICubeStorageMap.get(strSysBICubeId);
            if (psSysBICubeStorage == null) {
                psSysBICubeStorage = new PSSysBICubeStorage();
                this.psSysBICubeStorageMap.put(strSysBICubeId, psSysBICubeStorage);
            }
            return psSysBICubeStorage;
        }

        public PSSysBIAggTableStorage getPSSysBIAggTableStorage(String strSysBIAggTableId) {
            PSSysBIAggTableStorage psSysBIAggTableStorage = this.psSysBIAggTableStorageMap.get(strSysBIAggTableId);
            if (psSysBIAggTableStorage == null) {
                psSysBIAggTableStorage = new PSSysBIAggTableStorage();
                this.psSysBIAggTableStorageMap.put(strSysBIAggTableId, psSysBIAggTableStorage);
            }
            return psSysBIAggTableStorage;
        }

        public PSSysBICubeDimensionStorage getPSSysBICubeDimensionStorage(String strSysBICubeDimensionId) {
            PSSysBICubeDimensionStorage psSysBICubeDimensionStorage = this.psSysBICubeDimensionStorageMap.get(strSysBICubeDimensionId);
            if (psSysBICubeDimensionStorage == null) {
                psSysBICubeDimensionStorage = new PSSysBICubeDimensionStorage();
                this.psSysBICubeDimensionStorageMap.put(strSysBICubeDimensionId, psSysBICubeDimensionStorage);
            }
            return psSysBICubeDimensionStorage;
        }

        public PSSysBIReportStorage getPSSysBIReportStorage(String strSysBIReportId) {
            PSSysBIReportStorage psSysBIReportStorage = this.psSysBIReportStorageMap.get(strSysBIReportId);
            if (psSysBIReportStorage == null) {
                psSysBIReportStorage = new PSSysBIReportStorage();
                this.psSysBIReportStorageMap.put(strSysBIReportId, psSysBIReportStorage);
            }
            return psSysBIReportStorage;
        }

        public PSCtrlMsgStorage getPSCtrlMsgStorage(String strDEId) {
            PSCtrlMsgStorage psCtrlMsgStorage = this.psCtrlMsgStorageMap.get(strDEId);
            if (psCtrlMsgStorage == null) {
                psCtrlMsgStorage = new PSCtrlMsgStorage();
                this.psCtrlMsgStorageMap.put(strDEId, psCtrlMsgStorage);
            }
            return psCtrlMsgStorage;
        }

        public PSDEFormStorage getPSDEFormStorage(String strDEId) {
            PSDEFormStorage psDEFormStorage = this.psDEFormStorageMap.get(strDEId);
            if (psDEFormStorage == null) {
                psDEFormStorage = new PSDEFormStorage();
                this.psDEFormStorageMap.put(strDEId, psDEFormStorage);
            }
            return psDEFormStorage;
        }

        public PSSysAIFactoryStorage getPSSysAIFactoryStorage(String strSysAIFactoryId) {
            PSSysAIFactoryStorage psSysAIFactoryStorage = this.psSysAIFactoryStorageMap.get(strSysAIFactoryId);
            if (psSysAIFactoryStorage == null) {
                psSysAIFactoryStorage = new PSSysAIFactoryStorage();
                this.psSysAIFactoryStorageMap.put(strSysAIFactoryId, psSysAIFactoryStorage);
            }
            return psSysAIFactoryStorage;
        }

        public PSSysAIPipelineStorage getPSSysAIPipelineStorage(String strSysAIPipelineId) {
            PSSysAIPipelineStorage psSysAIPipelineStorage = this.psSysAIPipelineStorageMap.get(strSysAIPipelineId);
            if (psSysAIPipelineStorage == null) {
                psSysAIPipelineStorage = new PSSysAIPipelineStorage();
                this.psSysAIPipelineStorageMap.put(strSysAIPipelineId, psSysAIPipelineStorage);
            }
            return psSysAIPipelineStorage;
        }
    }

    protected class PSThresholdGroupStorage {
        public String strPSThresholdGroupId = "";
        public ArrayList<PSThreshold> psThresholdList = new ArrayList();
        public PSThresholdGroup psThresholdGroup = null;
    }

    protected class PSViewMsgGroupStorage {
        public String strPSViewMsgGroupId = "";
        public ArrayList<PSViewMsgGroupDetail> psViewMsgGroupDetailList = new ArrayList();
        public PSViewMsgGroup psViewMsgGroup = null;
    }

    protected class PSWFVersionStorage {
        public String strPSWFVersionId = "";
        public PSWFVersion psWFVersion = null;
        public ArrayList<PSWFProcSubWF> psWFProcSubWFList = new ArrayList();
        public ArrayList<PSWFProcess> psWFProcessList = new ArrayList();
        public ArrayList<PSWFLink> psWFLinkList = new ArrayList();
        public ArrayList<PSWFProcParam> psWFProcParamList = new ArrayList();
        public ArrayList<PSWFLinkCond> psWFLinkCondList = new ArrayList();
        public ArrayList<PSWFProcRole> psWFProcRoleList = new ArrayList();
        public ArrayList<PSWFLinkRole> psWFLinkRoleList = new ArrayList();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
    }

    protected class PSWXAccountStorage {
        public String strPSWXAccountId = "";
        public ArrayList<PSWXEntApp> psWXEntAppList = new ArrayList();
        public ArrayList<PSWXMenuFunc> psWXMenuFuncList = new ArrayList();
        public ArrayList<PSWXLogic> psWXLogicList = new ArrayList();
        public ArrayList<PSWXMenu> psWXMenuList = new ArrayList();
        public PSWXAccount psWXAccount = null;
    }

    protected class PSWXEntAppStorage {
        public String strPSWXEntAppId = "";
        public ArrayList<PSWXMenuFunc> psWXMenuFuncList = new ArrayList();
        public ArrayList<PSWXLogic> psWXLogicList = new ArrayList();
        public ArrayList<PSWXMenu> psWXMenuList = new ArrayList();
        public PSWXEntApp psWXEntApp = null;
    }

    protected class PSWXMenuStorage {
        public String strPSWXMenuId = "";
        public ArrayList<PSWXMenuItem> psWXMenuItemList = new ArrayList();
        public PSWXMenu psWXMenu = null;
    }

    protected class PSWorkflowStorage {
        public String strPSWorkflowId = "";
        public PSWorkflow psWorkflow = null;
        public ArrayList<PSWFVersion> psWFVersionList = new ArrayList();
        public ArrayList<PSDEUIActionGroup> psDEUIActionGroupList = new ArrayList();
        public ArrayList<PSDEUIAction> psDEUIActionList = new ArrayList();
        public ArrayList<PSWFDE> psWFDEList = new ArrayList();
    }
}

