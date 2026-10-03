/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEAction
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEDataImport
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.FIUpdate
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
 *  SA.SRFDA.Ctrl.Data.TempData
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Model.DGModelBaseLogicConfig
 *  SA.SRFDA.Model.DGModelGroupLogicConfig
 *  SA.SRFDA.Model.DGModelSingleLogicConfig
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.Utility.ISRFDAPOLogger
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.DataEntityTable
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DataGrid.DataGridRowActionHelperEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridActionHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  SA.SRFramework.WebEx.SRFExGridRowActionResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.UI.DataGridConfig
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  SA.SRFramework.WebEx.UI.DataGridEditItemErrors
 *  SA.SRFramework.WebEx.UI.ItemParamConfig
 *  SA.SRFramework.WebEx.Utility.DADVHelper
 *  SA.SRFramework.WebEx.Utility.DataGridExcelReportHelper
 *  SA.SRFramework.WebEx.Utility.DataGridExcelReportHelperEx
 *  SA.SRFramework.WebEx.Utility.GridFetchResultHelper
 *  SA.SRFramework.WebEx.Utility.GridRowActionHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelSingleLogicConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.IDEMainStatePage;
import SA.SRFDA.Web.IParentDataPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.DEDataImportTemplateHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.DataEntityTable;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.DataGridRowActionHelperEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.SRFramework.WebEx.SRFExGridRowActionResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemErrors;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelper;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelperEx;
import SA.SRFramework.WebEx.Utility.GridFetchResultHelper;
import SA.SRFramework.WebEx.Utility.GridRowActionHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDADataGridActionHelper
extends SRFExDataGridActionHelper {
    public static final String ACTION_GETLAST = "getlast";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKIN = "checkin";
    public static final String ACTION_AUTOCHECKOUT = "autocheckout";
    protected DataGrid gridView = null;
    protected PPDataGrid ppDataGrid = null;
    private static final Log log = LogFactory.getLog(BaseDADataGridActionHelper.class);
    public static final String TAG_PICKUPMODE = "PICKUPMODE";
    protected DataGridRowActionHelperEx dgRowActionHelperEx = null;
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected boolean bEnableItemPrivilege = false;
    protected boolean bTempDataMode = false;
    protected String strQueryKey = "";
    protected int nStartRow = -1;
    protected int nPageSize = 0;
    protected IDEMainStateHelper iDEMainStateHelper = null;
    private BaseDAQueryModelHelper daQueryModelHelper = null;
    private String strTestRecordSQL = "";

    protected boolean OnBeforeProcess() {
        IDEMainStatePage iDEMainStatePage;
        if (!super.OnBeforeProcess()) {
            return false;
        }
        this.dgRowActionHelperEx = new DataGridRowActionHelperEx(this.getDataGrid());
        if (!this.OnGetDGPickupMode()) {
            this.bTempDataMode = SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false);
        }
        this.bEnableItemPrivilege = this.getDataGrid().isEnableItemPrivilege();
        BaseDataEntity pageParam = this.getPage().getAdvPageParam(this.getDataGrid().getID().toUpperCase(), "PP_DATAGRID");
        if (pageParam != null && pageParam instanceof PPDataGrid) {
            this.ppDataGrid = (PPDataGrid)pageParam;
        }
        if (this.getPage() instanceof IDEMainStatePage && (iDEMainStatePage = (IDEMainStatePage)((Object)this.getPage())).isEnableDEMainState()) {
            this.iDEMainStateHelper = iDEMainStatePage.getDEMainState();
        }
        return true;
    }

    protected boolean OnFetchAction() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        if (this.bTempDataMode) {
            BaseDataEntity cond = new BaseDataEntity();
            if (!this.FillURLCondition(cond)) {
                log.error((Object)"\u586b\u5145URL\u6761\u4ef6\u5931\u8d25");
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u586b\u5145URL\u6761\u4ef6\u5931\u8d25");
                this.getPage().Output(fetchResult.ToJSONString());
                return true;
            }
            cond.SetParamValue("TEMPDATANAME", (Object)this.getDEHelper().getId());
            this.SelectAndFillFetchResult(cond, fetchResult);
        } else {
            boolean bOptimizeCount;
            String strTemp;
            this.gridView = this.getGridView();
            if (this.gridView == null) {
                log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
                this.getPage().Output(fetchResult.ToJSONString());
                return true;
            }
            String strQueryModel = this.OnGetAdditionalQueryModel();
            boolean bUserDP = this.OnGetUserDP();
            String strDPDataAction = "";
            if (bUserDP) {
                strDPDataAction = this.OnGetDPDataAction();
            }
            String strSelectedColumns = this.OnGetSelectedColumns(this.getDataGrid().getDataGridConfig());
            this.gridView.getDataGridModelConfig().getMainQueryConfig().setSelectedColumns(strSelectedColumns);
            if (this.gridView.getDISTINCTMODE()) {
                this.gridView.getDataGridModelConfig().getMainQueryConfig().setDistinct(true);
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
                this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(this.gridView, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(this.gridView);
                this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s] QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)"", (Object)(bUserDP ? "TRUE" : "FALSE"));
            } else if (this.OnGetNoDefQuery()) {
                this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(strQueryModel, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
                this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s]\u7981\u7528  QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
                log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
            } else {
                this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(strQueryModel, this.gridView, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel, this.gridView);
                this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s] QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
                log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s] \u8054\u5408 [%2$s]", (Object)strQueryModel, (Object)this.gridView.getDATAGRIDID()));
            }
            if (this.daQueryModelHelper == null) {
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
                log.error((Object)fetchResult.getErrorInfo());
                this.getPage().Output(fetchResult.ToJSONString());
                return true;
            }
            this.qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(this.GetDAModelQueryScript(this.daQueryModelHelper));
            Vector<String> userConditions = new Vector<String>();
            this.daQueryModelHelper.FillMajorConditions(userConditions);
            this.FillDAQueryModelHelperCondition(userConditions, this.daQueryModelHelper);
            if (userConditions.size() != 0) {
                script.Append(" WHERE ");
                boolean bFirst = true;
                for (String strCondition : userConditions) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(" AND ");
                    }
                    script.Append("(%1$s)", (Object)strCondition);
                }
            }
            Vector dynamicTables = null;
            boolean bDynamicMode = false;
            if (StringHelper.Compare((String)this.getDEHelper().getDataEntity().getSTORAGETYPE(), (String)"DYNAMIC", (boolean)true) == 0) {
                String strTime2;
                bDynamicMode = true;
                String strTimeFrom = this.getDEHelper().GetProperty("DYNAMICFROM");
                String strTimeTo = this.getDEHelper().GetProperty("DYNAMICTO");
                String strTime1 = this.getPage().getRequest().getParameter(strTimeFrom.toLowerCase());
                if (strTime1 == null) {
                    strTime1 = this.getWebContext().GetParamValue(strTimeFrom.toUpperCase());
                }
                if ((strTime2 = this.getPage().getRequest().getParameter(strTimeTo.toLowerCase())) == null) {
                    strTime2 = this.getWebContext().GetParamValue(strTimeTo.toUpperCase());
                }
                if (StringHelper.IsNullOrEmpty((String)strTime1) || StringHelper.IsNullOrEmpty((String)strTime2)) {
                    log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u5f00\u59cb\u6216\u7ed3\u675f\u65f6\u95f4");
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5f00\u59cb\u6216\u7ed3\u675f\u65f6\u95f4");
                    this.getPage().Output(fetchResult.ToJSONString());
                    return true;
                }
                try {
                    Date startDate = DateParser.Parse((String)strTime1);
                    Date endDate = DateParser.Parse((String)strTime2);
                    dynamicTables = new Vector();
                    CallResult callResult = this.getDEHelper().GetDynamicTables(startDate, endDate, dynamicTables);
                    if (callResult.IsError()) {
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(callResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo(e.getMessage());
                    this.getPage().Output(fetchResult.ToJSONString());
                    return true;
                }
            }
            String strCountSQL = String.valueOf(this.daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + this.daQueryModelHelper.GetCountSQL(script.toString());
            strCountSQL = this.daQueryModelHelper.ReplaceURLParamMacro(strCountSQL, (ISRFExWebContext)this.getWebContext(), true);
            if (bDynamicMode) {
                strCountSQL = this.daQueryModelHelper.ReplaceDynamicTableMacro(strCountSQL, dynamicTables);
            }
            if (StringHelper.Length((String)(strTemp = this.getPage().getRequest().getParameter("start"))) != 0) {
                try {
                    this.nStartRow = Integer.parseInt(strTemp);
                }
                catch (Exception ex) {
                    this.nStartRow = -1;
                }
            }
            if (StringHelper.Length((String)(strTemp = this.getPage().getRequest().getParameter("limit"))) != 0) {
                try {
                    this.nPageSize = Integer.parseInt(strTemp);
                }
                catch (Exception ex) {
                    this.nPageSize = 0;
                }
            }
            String strSortParam = "";
            String strSortDirection = "";
            if (!this.gridView.getNOSORT()) {
                strSortParam = this.getPage().getRequest().getParameter("sort");
                String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
                if (StringHelper.Length((String)strRealSortParam) > 0) {
                    strSortParam = strRealSortParam;
                }
                strSortDirection = this.getPage().getRequest().getParameter("dir");
            }
            String strPagingSQL = this.GetPagingSQL(this.daQueryModelHelper, script.toString(), this.nStartRow, this.nPageSize, strSortParam, strSortDirection, this.OnGetMinorSortField(), this.OnGetMinorSortDir());
            strPagingSQL = this.daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext(), true);
            if (bDynamicMode) {
                strPagingSQL = this.daQueryModelHelper.ReplaceDynamicTableMacro(strPagingSQL, dynamicTables);
            }
            boolean bl = bOptimizeCount = bUserDP && this.gridView.getOPTIMIZECOUNT();
            if (bOptimizeCount && this.gridView.getREALCNTRANGE() > 0) {
                this.strTestRecordSQL = this.GetPagingSQL(this.daQueryModelHelper, script.toString(), this.gridView.getREALCNTRANGE(), 1, "", "", "", "");
                this.strTestRecordSQL = this.daQueryModelHelper.ReplaceURLParamMacro(this.strTestRecordSQL, (ISRFExWebContext)this.getWebContext(), true);
                if (bDynamicMode) {
                    this.strTestRecordSQL = this.daQueryModelHelper.ReplaceDynamicTableMacro(this.strTestRecordSQL, dynamicTables);
                }
            }
            Vector<CallParam> list = new Vector<CallParam>();
            this.daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.SelectAndFillFetchResult(strCountSQL, strPagingSQL, list, fetchResult);
            this.FillSummaryInfo(fetchResult, this.daQueryModelHelper);
            if (this.OnGetMajorDataHashCode()) {
                String strPDataHashCode = this.GetMajorDataHashCode();
                if (StringHelper.IsNullOrEmpty((String)strPDataHashCode)) {
                    fetchResult.setExtInfo("srfpdatahashcode", "");
                } else {
                    fetchResult.setExtInfo("srfpdatahashcode", strPDataHashCode);
                }
            }
        }
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected boolean OnGetMajorDataHashCode() {
        String strPDataHashCode = this.getWebContext().GetPostValue("srfpdatahashcode");
        return StringHelper.Compare((String)strPDataHashCode, (String)"TRUE", (boolean)true) == 0;
    }

    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected String OnGetAdditionalQueryModel() {
        String strDGQueryModelId = "";
        if (this.OnGetDGPickupMode()) {
            DER1N der1n;
            String strDER1NID = SRFDAWebCTXHelper.GetDER1NId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)strDER1NID) && (der1n = this.getDEHelper().FindDER1N(strDER1NID)) != null) {
                strDGQueryModelId = der1n.getQUERYMODELID();
            }
        } else if (this.iDEMainStateHelper != null) {
            strDGQueryModelId = this.iDEMainStateHelper.getQueryModelId();
        }
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("QUERYMODELID")) {
            strDGQueryModelId = this.ppDataGrid.getQUERYMODELID();
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", strDGQueryModelId);
    }

    protected boolean OnGetNoDefQuery() {
        boolean bNoDefQuery = false;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("NODEFQUERY")) {
            bNoDefQuery = this.ppDataGrid.getNODEFQUERY();
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.NODEFQUERY", bNoDefQuery);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String OnGetMinorSortField() {
        if (StringHelper.Compare((String)this.gridView.getMINORSORTMODE(), (String)"DISABLE", (boolean)false) == 0) {
            return "";
        }
        String strMinorSortField = this.gridView.getMINORSORTFIELD();
        strMinorSortField = this.getPage().getPageParam("PAGE.DATAGRID.MINORSORTFIELD", strMinorSortField);
        if (!StringHelper.IsNullOrEmpty((String)strMinorSortField) && StringHelper.Compare((String)this.gridView.getMINORSORTMODE(), (String)"ENABLE_AUTO", (boolean)false) != 0) {
            return strMinorSortField;
        }
        String strMinorSortFieldAuto = this.getPage().getRequest().getParameter("realsort2");
        if (StringHelper.IsNullOrEmpty((String)strMinorSortFieldAuto)) {
            strMinorSortFieldAuto = this.getPage().getRequest().getParameter("sort2");
        }
        if (!StringHelper.IsNullOrEmpty((String)strMinorSortFieldAuto)) {
            return strMinorSortFieldAuto;
        }
        return strMinorSortField;
    }

    protected String OnGetMinorSortDir() {
        if (StringHelper.Compare((String)this.gridView.getMINORSORTMODE(), (String)"DISABLE", (boolean)false) == 0) {
            return "";
        }
        String strMinorSortDir = this.gridView.getMINORSORTDIR();
        strMinorSortDir = this.getPage().getPageParam("PAGE.DATAGRID.MINORSORTDIR", strMinorSortDir);
        if (!StringHelper.IsNullOrEmpty((String)strMinorSortDir) && StringHelper.Compare((String)this.gridView.getMINORSORTMODE(), (String)"ENABLE_AUTO", (boolean)false) != 0) {
            return strMinorSortDir;
        }
        String strMinorSortDirAuto = this.getPage().getRequest().getParameter("dir2");
        if (!StringHelper.IsNullOrEmpty((String)strMinorSortDirAuto)) {
            return strMinorSortDirAuto;
        }
        return strMinorSortDir;
    }

    protected String GetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        boolean bPaging = this.getDataGrid().getDataGridConfig().getPaging();
        if (!bPaging && nPageSize <= 0) {
            nStartRow = 0;
            nPageSize = this.getDataGrid().getDataGridConfig().getDataGridPagingConfig().getPageSize();
        }
        if (this.gridView.isENABLEGROUP() && !StringHelper.IsNullOrEmpty((String)this.gridView.getGROUPCOLUMN()) && StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel()) && StringHelper.Compare((String)strSortParam, (String)this.gridView.getGROUPCOLUMN(), (boolean)true) != 0) {
            return String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(strScript, nStartRow, nPageSize, this.gridView.getGROUPCOLUMN(), this.gridView.getGROUPDIR(), strSortParam, strSortDirection, strMinor, strMinorDirection);
        }
        return String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(strScript, nStartRow, nPageSize, strSortParam, strSortDirection, strMinor, strMinorDirection);
    }

    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        boolean bDGUserDP = true;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("DGUSERDP")) {
            bDGUserDP = this.ppDataGrid.getDGUSERDP();
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.USERDP", bDGUserDP);
    }

    protected String OnGetDPDataAction() {
        return this.getPage().getPageParam("PAGE.DATAGRID.DPDATAACTION", "");
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(dataEntity, "CREATE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected String OnGetDGUpdateMode() {
        String strUpdateMode = "";
        if (this.ppDataGrid != null) {
            strUpdateMode = this.ppDataGrid.getUPDATEMODE();
        }
        if (StringHelper.IsNullOrEmpty((String)strUpdateMode)) {
            strUpdateMode = "DEFAULT";
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.UPDATEMODE", strUpdateMode);
    }

    protected String OnGetDGInsertMode() {
        String strInsertMode = "";
        if (this.ppDataGrid != null) {
            strInsertMode = this.ppDataGrid.getINSERTEMODE();
        }
        if (StringHelper.IsNullOrEmpty((String)strInsertMode)) {
            strInsertMode = "DEFAULT";
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.INSERTMODE", strInsertMode);
    }

    protected String GetUpdateDataAction() {
        String strAction = this.OnGetDGUpdateMode();
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)"DEFAULT", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFACTION", (boolean)true) == 0) {
            strAction = "UPDATE";
        }
        return strAction;
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        String strAction = this.GetUpdateDataAction();
        CallResult callResult = this.OnTestDataAction(dataEntity, strAction);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.OnTestDataAction(this.getDEHelper(), dataEntity, strAction);
    }

    protected CallResult OnTestDataAction(IDEHelper iDEHelper, BaseDataEntity dataEntity, String strAction) {
        return iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected void FillAdditionalDPCode(TreeMap<String, String> codeSets) {
    }

    protected boolean OnGetDGPickupMode() {
        return this.getPage().getPageParam(TAG_PICKUPMODE, false);
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillSearchFormCondition(userConditions, daQueryModelHelper);
        this.FillURLCondition(userConditions, daQueryModelHelper);
        if (this.OnGetDGPickupMode()) {
            this.FillPickupModeCondition(userConditions, daQueryModelHelper);
        }
    }

    protected void FillPickupModeCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected boolean FillURLCondition(BaseDataEntity userConditions) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
            IPickupDEFHelper pickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(strDERID);
            if (pickupDEFHelper == null && this.getDEHelper().IsInheritMode()) {
                pickupDEFHelper = this.getDEHelper().GetInheritDEHelper().FindPickupDEFHelper(strDERID);
            }
            if (pickupDEFHelper == null) {
                return false;
            }
            String strValue = "";
            String strParamName = "";
            String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
            if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
                DERINDEX derIndex = new DERINDEX();
                CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
                } else {
                    IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                    if (iDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                    } else {
                        strParamName = iDEHelper.GetKeyDEFHelper().getName();
                    }
                }
            } else {
                strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
            }
            strValue = this.getWebContext().GetPostValue(strParamName);
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = this.getWebContext().GetParamValue(strParamName);
            }
            if (strValue != null) {
                strValue = strValue.trim();
            }
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = "NA";
            }
            userConditions.SetParamValue("PTEMPKEYVALUE", (Object)strValue);
            userConditions.SetParamValue("PDEID", (Object)pickupDEFHelper.GetRealDEFHelper().getDEHelper().getId());
            return true;
        }
        return false;
    }

    protected void FillURLCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        block21: {
            if (this.getPage() instanceof IParentDataPage) {
                IParentDataPage iParentDataPage = (IParentDataPage)((Object)this.getPage());
                try {
                    if (iParentDataPage.getParentDEHelper() == null) break block21;
                    String strParentKey = "";
                    Object objParentKey = iParentDataPage.getPickupDEFValue();
                    strParentKey = objParentKey == null ? "NA" : objParentKey.toString();
                    String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, (IDEFHelper)iParentDataPage.getPickupDEFHelper(), "", "=", strParentKey);
                    if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                        userConditions.add(strCondition);
                        break block21;
                    }
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5c5e\u6027[%1$s]SQL\u6761\u4ef6\u53d1\u751f\u9519\u8bef", (Object)iParentDataPage.getPickupDEFHelper().getName()));
                }
                catch (Exception e) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u586b\u5145\u7236\u6570\u636e\u6761\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
                }
            } else {
                String strDERID = this.getWebContext().getSRFDERID();
                if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
                    ILinkDEFHelper pickupDEFHelper = null;
                    for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                        ILinkDEFHelper linkDEFHelper;
                        if (!iDEFHelper.IsLinkDEField() || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strDERID, (boolean)true) != 0 || StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                        pickupDEFHelper = linkDEFHelper;
                        break;
                    }
                    if (pickupDEFHelper == null) {
                        return;
                    }
                    String strValue = "";
                    boolean bAppendIndexValue = false;
                    String strIndexType = "";
                    String strParamName = "";
                    String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
                    if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
                        DERINDEX derIndex = new DERINDEX();
                        CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
                        if (callResult.getRetCode() != 0) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
                        } else {
                            IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                            if (iDEHelper == null) {
                                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                            } else {
                                strParamName = iDEHelper.GetKeyDEFHelper().getName();
                                if (iDEHelper.GetIndexMode() == 1) {
                                    bAppendIndexValue = true;
                                    strIndexType = derIndex.getTYPEVALUE();
                                }
                            }
                        }
                    } else {
                        strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
                    }
                    strValue = this.getWebContext().GetPostValue(strParamName);
                    if (StringHelper.IsNullOrEmpty((String)strValue)) {
                        strValue = this.getWebContext().GetParamValue(strParamName);
                    }
                    if (strValue != null) {
                        strValue = strValue.trim();
                    }
                    if (StringHelper.IsNullOrEmpty((String)strValue)) {
                        strValue = "NA";
                    } else if (bAppendIndexValue) {
                        strValue = BaseDEHelper.GetIndexDEKeyValueWithType((String)strIndexType, (Object)strValue);
                    }
                    String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, (IDEFHelper)pickupDEFHelper, "", "=", strValue);
                    if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                        userConditions.add(strCondition);
                    }
                }
            }
        }
    }

    protected void FillSearchFormCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillSearchFormCSMCondition(userConditions, daQueryModelHelper);
        String strFilter = this.getWebContext().getSRFFILTER();
        TreeMap<String, String> filterMap = null;
        if (!StringHelper.IsNullOrEmpty((String)strFilter)) {
            filterMap = new TreeMap<String, String>();
            String[] parts = strFilter.split("[;]");
            int i = 0;
            while (i < parts.length) {
                String[] params;
                String strPart = parts[i];
                if (!StringHelper.IsNullOrEmpty((String)strPart) && (params = strPart.split("[|]")).length >= 2) {
                    filterMap.put(params[0].toUpperCase(), params[1].toUpperCase());
                }
                ++i;
            }
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            SearchModelConfig searchModelConfig;
            if (this.bEnableItemPrivilege && iDEFHelper.IsEnableDEFieldPriv()) {
                String strPrivilegeId = StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId());
                if ((iUserPrivilegeMgr.TestColumn((ISRFExWebContext)this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) continue;
            }
            if ((searchModelConfig = iDEFHelper.GetSearchModel()) == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                String strCondition;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                String strValue = this.getPage().getRequest().getParameter(strFormItemId.toLowerCase());
                if (StringHelper.IsNullOrEmpty((String)strValue) && StringHelper.IsNullOrEmpty((String)(strValue = this.getWebContext().GetParamValue(strFormItemId.toUpperCase()))) && (filterMap == null || !filterMap.containsKey(strFormItemId.toUpperCase()) || StringHelper.IsNullOrEmpty((String)(strValue = this.getWebContext().GetParamValue((String)filterMap.get(strFormItemId.toUpperCase())))))) continue;
                if (!StringHelper.IsNullOrEmpty((String)strValue)) {
                    strValue = strValue.trim();
                }
                if (StringHelper.IsNullOrEmpty((String)strValue) || StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, searchItemConfig, strValue)))) continue;
                userConditions.add(strCondition);
            }
        }
        String strQuickSearch = this.getPage().getRequest().getParameter("SRFQUICKSEARCH".toLowerCase());
        if (!StringHelper.IsNullOrEmpty((String)strQuickSearch)) {
            Vector<String> acConditions = new Vector<String>();
            for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                if (!iDEFHelper.getDEField().isACSEARCH(iDEFHelper.IsMajorDEField())) continue;
                acConditions.add(daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "LIKE", strQuickSearch));
            }
            if (acConditions.size() != 0) {
                String strACCondtion = "";
                boolean bFirst = true;
                for (String strCondition : acConditions) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        strACCondtion = String.valueOf(strACCondtion) + " OR ";
                    }
                    strACCondtion = String.valueOf(strACCondtion) + StringHelper.Format((String)"(%1$s)", (Object)strCondition);
                }
                userConditions.add(strACCondtion);
            }
        }
    }

    protected void FillSearchFormCSMCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        String strValue = this.getPage().getRequest().getParameter("srfcsm");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return;
        }
        DGModelGroupLogicConfig dgModelGroupLogicConfig = new DGModelGroupLogicConfig();
        if (!XMLConfig.LoadFromXML((String)strValue, (XMLConfig)dgModelGroupLogicConfig)) {
            log.error((Object)StringHelper.Format((String)"\u641c\u7d22\u8868\u5355\u52a8\u6001\u67e5\u8be2\u6a21\u578b\u65e0\u6548"));
            return;
        }
        if (dgModelGroupLogicConfig.getLogicsConfig() == null) {
            return;
        }
        DGModelGroupLogicConfig realGroupLogicConfig = null;
        String strSRFCSMMode = dgModelGroupLogicConfig.GetExtValue("SRFCSMMODE", "");
        if (StringHelper.Compare((String)strSRFCSMMode, (String)"ADVANCE", (boolean)true) == 0) {
            realGroupLogicConfig = dgModelGroupLogicConfig;
        } else {
            realGroupLogicConfig = new DGModelGroupLogicConfig();
            realGroupLogicConfig.InitLogicsConfig();
            realGroupLogicConfig.setCondition("OR");
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
            TreeMap<String, DGModelGroupLogicConfig> groups = new TreeMap<String, DGModelGroupLogicConfig>();
            for (DGModelBaseLogicConfig dgModelBaseLogicConfig : dgModelGroupLogicConfig.getLogicsConfig()) {
                String strGroupNo = dgModelBaseLogicConfig.GetExtValue("GROUPNO", "");
                if (this.bEnableItemPrivilege && dgModelBaseLogicConfig instanceof DGModelSingleLogicConfig) {
                    DGModelSingleLogicConfig singleLogicConfig = (DGModelSingleLogicConfig)dgModelBaseLogicConfig;
                    IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(singleLogicConfig.getDEField());
                    if (iDEFHelper == null) continue;
                    if (iDEFHelper.IsEnableDEFieldPriv()) {
                        String strPrivilegeId = StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId());
                        if ((iUserPrivilegeMgr.TestColumn((ISRFExWebContext)this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) continue;
                    }
                }
                DGModelGroupLogicConfig curGroupLogicConfig = null;
                if (!groups.containsKey(strGroupNo.toUpperCase())) {
                    curGroupLogicConfig = new DGModelGroupLogicConfig();
                    curGroupLogicConfig.InitLogicsConfig();
                    curGroupLogicConfig.setCondition("AND");
                    groups.put(strGroupNo.toUpperCase(), curGroupLogicConfig);
                    realGroupLogicConfig.getLogicsConfig().add(curGroupLogicConfig);
                } else {
                    curGroupLogicConfig = (DGModelGroupLogicConfig)groups.get(strGroupNo.toUpperCase());
                }
                curGroupLogicConfig.getLogicsConfig().add(dgModelBaseLogicConfig);
            }
        }
        CallResult callResult = daQueryModelHelper.GetGroupCondition(realGroupLogicConfig);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u81ea\u5b9a\u4e49\u641c\u7d22\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        String strGroupCondition = callResult.getUserObject().toString();
        if (!StringHelper.IsNullOrEmpty((String)strGroupCondition)) {
            userConditions.add(callResult.getUserObject().toString());
        }
    }

    protected void SelectAndFillFetchResult(String strCountSQL, String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult) {
        try {
            boolean bEnableDP = this.OnGetUserDP();
            boolean bOptimizeCount = bEnableDP && this.gridView.getOPTIMIZECOUNT();
            String strCountKey = "";
            if (bOptimizeCount) {
                strCountKey = StringHelper.Format((String)"COUNT_%1$s", (Object)Helper.GenMD5((String)strCountSQL));
            }
            StringBuilderEx paramInfo = new StringBuilderEx();
            StringBuilderEx info = new StringBuilderEx();
            info.Append("PAGING SQL\r\n%1$s\r\n", (Object)strPagingSQL);
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = list.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    paramInfo.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            long nSelectTime = new Date().getTime();
            long nCountTime = 0L;
            SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strPagingSQL, list);
            if (selectResult == null) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return;
            }
            nSelectTime = new Date().getTime() - nSelectTime;
            if (selectResult.getRetCode() != 0) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult.getErrorInfo());
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.From((DBResult)selectResult);
                return;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                return;
            }
            DataSet ds = selectResult.getSelectData();
            if ((ds.getTable(0).GetRowCount() != 0 || this.nStartRow == 0) && ds.getTable(0).GetRowCount() < this.nPageSize) {
                int nTotalRow = this.nStartRow + ds.getTable(0).GetRowCount();
                fetchResult.setTotalRow(nTotalRow);
                if (bOptimizeCount) {
                    this.daQueryModelHelper.setAttribute(strCountKey, (Object)nTotalRow);
                }
            } else {
                int nTotalRow = -1;
                if (bOptimizeCount && this.nStartRow > 0) {
                    nTotalRow = (Integer)this.daQueryModelHelper.getAttribute(strCountKey, (Object)nTotalRow);
                }
                if (nTotalRow == -1 && !StringHelper.IsNullOrEmpty((String)this.strTestRecordSQL)) {
                    if (this.nStartRow < this.gridView.getREALCNTRANGE()) {
                        SelectResult selectResult3 = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(this.strTestRecordSQL, list);
                        if (selectResult3 == null) {
                            info.Append("\u8ba1\u6570\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\r\n");
                            LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                            fetchResult.setRetCode(1);
                            fetchResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                            return;
                        }
                        if (selectResult3.getRetCode() != 0) {
                            info.Append("\u8ba1\u6570\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult3.getErrorInfo());
                            LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                            fetchResult.From((DBResult)selectResult3);
                            return;
                        }
                        if (selectResult3.getSelectData().getTableCount() != 1) {
                            info.Append("\u8ba1\u6570\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\r\n");
                            LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                            fetchResult.setRetCode(1);
                            fetchResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                            return;
                        }
                        DataSet ds3 = selectResult3.getSelectData();
                        if (ds3.getTable(0).GetRowCount() > 0 && (nTotalRow = this.gridView.getMAXRECORD()) <= 0) {
                            nTotalRow = 99999999;
                        }
                    } else {
                        nTotalRow = this.gridView.getMAXRECORD();
                        if (nTotalRow <= 0) {
                            nTotalRow = 99999999;
                        }
                    }
                }
                if (nTotalRow == -1) {
                    nCountTime = new Date().getTime();
                    SelectResult selectResult2 = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strCountSQL, list);
                    if (selectResult2 == null) {
                        info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\r\n");
                        LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                        return;
                    }
                    nCountTime = new Date().getTime() - nCountTime;
                    if (selectResult2.getRetCode() != 0) {
                        info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult2.getErrorInfo());
                        LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                        fetchResult.From((DBResult)selectResult);
                        return;
                    }
                    if (selectResult2.getSelectData().getTableCount() != 1) {
                        info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\r\n");
                        LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                        return;
                    }
                    DataSet dsCount = selectResult2.getSelectData();
                    nTotalRow = Integer.parseInt(dsCount.getTable(0).GetRow(0).Get("TOTALROW").toString());
                    if (bOptimizeCount) {
                        this.daQueryModelHelper.setAttribute(strCountKey, (Object)nTotalRow);
                    }
                }
                String strTotalRow = StringHelper.Format((String)"%1$s", (Object)nTotalRow);
                fetchResult.setTotalRow(Integer.parseInt(strTotalRow));
            }
            fetchResult.setRetCode(0);
            GridFetchResultHelper.Fill((SRFExWebContext)this.getWebContext(), (Vector)fetchResult.getItems(), (DataTable)ds.getTable(0), (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID(), (boolean)false, (boolean)this.getDataGrid().isEnableItemPrivilege());
            this.FillSummaryInfo(fetchResult, ds.getTable(0));
            if (StringHelper.Compare((String)this.getDataGrid().getDataGridConfig().getResponseType(), (String)"JSONARRAY", (boolean)true) == 0) {
                BaseDADataGridActionHelper.ConverItemsToArray(fetchResult, (ISRFDAWebContext)this.getWebContext(), this.getDataGrid().getDataGridConfig(), this.bEnableItemPrivilege);
            }
            info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u8017\u65f6[%1$sms],\u5206\u9875\u6570\u636e\u67e5\u8be2\u8017\u65f6[%2$sms]\r\n", (Object)nCountTime, (Object)nSelectTime);
            LoggerEx.info((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
            this.LogQueryPerformance(String.valueOf(strCountSQL) + "\r\n" + paramInfo.toString(), (int)nCountTime);
            this.LogQueryPerformance(String.valueOf(strPagingSQL) + "\r\n" + paramInfo.toString(), (int)nSelectTime);
        }
        catch (Exception ex) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(ex.getMessage());
        }
    }

    protected boolean isLogQueryPerformance() {
        return this.getDEHelper().GetProperty("LOGPODBQUERY", true);
    }

    public void LogQueryPerformance(String strSQL, int nProcessTime) {
        if (!this.isLogQueryPerformance()) {
            return;
        }
        ISRFDAPOLogger poLogger = this.getWebContext().getGlobalHelper().getPOLoggerEx();
        if (poLogger == null) {
            return;
        }
        poLogger.LogDBQuery(this.getDEHelper().getId(), this.strQueryKey, strSQL, this.getWebContext().getCurUserId(), nProcessTime);
    }

    protected void SelectAndFillFetchResult(BaseDataEntity cond, SRFExGridFetchResult fetchResult) {
        try {
            IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext());
            if (iTempDataCtrl == null) {
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                log.error((Object)fetchResult.getErrorInfo());
                return;
            }
            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
            CallResult callResult = iTempDataCtrl.Select(cond, list);
            if (callResult == null) {
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return;
            }
            if (callResult.getRetCode() != 0) {
                fetchResult.From(callResult);
                return;
            }
            fetchResult.setTotalRow(list.size());
            Vector<BaseDataEntity> realList = new Vector<BaseDataEntity>();
            for (BaseDataEntity dataEntity : list) {
                BaseDataEntity realDE = BaseDataEntity.FromString((String)dataEntity.GetParamStringValue("DEDATA", ""));
                realDE.SetParamValue("SRFDATEMPKEYID", dataEntity.GetParamValue("TEMPDATAID"));
                realList.add(realDE);
            }
            DataEntityTable dataEntityTable = new DataEntityTable(realList);
            GridFetchResultHelper.Fill((SRFExWebContext)this.getWebContext(), (Vector)fetchResult.getItems(), (DataTable)dataEntityTable, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID(), (boolean)true);
            fetchResult.setRetCode(0);
            if (StringHelper.Compare((String)this.getDataGrid().getDataGridConfig().getResponseType(), (String)"JSONARRAY", (boolean)true) == 0) {
                BaseDADataGridActionHelper.ConverItemsToArray(fetchResult, (ISRFDAWebContext)this.getWebContext(), this.getDataGrid().getDataGridConfig(), this.bEnableItemPrivilege);
            }
        }
        catch (Exception ex) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(ex.getMessage());
        }
    }

    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, DataTable dataTable) {
    }

    protected CallResult SelectAndExport(String strPagingSQL, Vector<CallParam> list, String strExportType) {
        CallResult callResult = new CallResult();
        try {
            StringBuilderEx info = new StringBuilderEx();
            info.Append("PAGING SQL\r\n%1$s\r\n", (Object)strPagingSQL);
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = list.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            log.info((Object)info.toString());
            SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strPagingSQL, list);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                return callResult;
            }
            String strFileSuffix = "";
            strFileSuffix = StringHelper.Compare((String)strExportType, (String)"HTML", (boolean)true) == 0 ? "htm" : "xls";
            String strTempFileName = Helper.GenGuid();
            String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId());
            File dir = new File(strDir);
            dir.mkdirs();
            String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)strFileSuffix);
            this.GenExcelFile(selectResult, strFullFileName, strExportType);
            callResult.setUserObject((Object)strTempFileName);
            callResult.setRetCode(0);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected void GenExcelFile(SelectResult selectResult, String strTempFileName, String strExportType) {
        BaseDADataGridActionHelper.GenExcelFile(this.getPage(), this.getDataGrid(), selectResult, strTempFileName, strExportType);
    }

    protected static void GenExcelFile(SRFDAPage page, SRFExDataGrid dataGrid, SelectResult selectResult, String strTempFileName, String strExportType) {
        try {
            DataGrid excelDataGrid = new DataGrid();
            CallResult callResult = page.getDAModelHelper().GetExcelExportDEDataGrid(page.getPageDataEntityId(), excelDataGrid);
            callResult = CallResult.ToCallResult((CallResult)callResult);
            DataGridConfig dataGridConfig = null;
            if (callResult.getRetCode() == 0) {
                String strDGConfigId = page.getDAConfigHelper().GetGridViewDGConfigId(page.getDEHelper(), null, excelDataGrid, "");
                if (StringHelper.IsNullOrEmpty((String)strDGConfigId)) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u4e0b\u8f7d\u8868\u683c\u914d\u914d\u7f6e\u8def\u5f84\u5931\u8d25"));
                    return;
                }
                dataGridConfig = page.getWebContext().getDataGridMgr().GetDataGridConfig(strDGConfigId);
                if (dataGridConfig == null) {
                    page.PageLog((Object)page, 1, StringHelper.Format((String)"\u83b7\u53d6\u4e0b\u8f7d\u8868\u683c\u914d\u914d\u7f6e\u5931\u8d25"));
                    return;
                }
            } else {
                dataGridConfig = dataGrid.getDataGridConfig();
            }
            if (StringHelper.Compare((String)strExportType, (String)"HTML", (boolean)true) == 0) {
                DataGridExcelReportHelper excelReportHelper = new DataGridExcelReportHelper();
                excelReportHelper.setPrint(true);
                excelReportHelper.setCloseAfterPrint(true);
                excelReportHelper.setDataSource(selectResult.getMainTable());
                excelReportHelper.setWebContext((SRFExWebContext)page.getWebContext());
                excelReportHelper.setConfig(dataGridConfig);
                excelReportHelper.setEnableItemPrivilege(dataGrid.isEnableItemPrivilege());
                FileWriter fw = new FileWriter(new File(strTempFileName));
                fw.flush();
                excelReportHelper.Output((Writer)fw);
                fw.close();
            } else {
                DataGridExcelReportHelperEx excelReportHelperEx = new DataGridExcelReportHelperEx();
                excelReportHelperEx.setConfig(dataGridConfig);
                excelReportHelperEx.setWebContext((SRFExWebContext)page.getWebContext());
                excelReportHelperEx.setDataSource(selectResult.getMainTable());
                excelReportHelperEx.setEnableItemPrivilege(dataGrid.isEnableItemPrivilege());
                excelReportHelperEx.Output(strTempFileName);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected String GetExportType() {
        String strExportType = this.getWebContext().GetPostValue("exporttype");
        if (StringHelper.IsNullOrEmpty((String)strExportType)) {
            return "";
        }
        return strExportType;
    }

    protected boolean OnRemoveAction() {
        SRFExAjaxActionResult removeActionResult = new SRFExAjaxActionResult();
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        if (this.bTempDataMode) {
            IDEDataCtrl iTempDataCtrl;
            String strErrorInfo = "";
            boolean bIndexDEMode = false;
            TreeMap<String, IDEDataCtrl> deDataCtrlMap = null;
            if (this.getDEHelper().IsIndexDE()) {
                deDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
                bIndexDEMode = true;
            }
            if ((iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext())) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                removeActionResult.setRetCode(1);
                removeActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                this.getPage().Output(removeActionResult.ToJSONString());
                return true;
            }
            IDEDataCtrl iRealDataCtrl = this.getDEDataCtrl();
            int i = 0;
            while (i < keys.length) {
                String strKeyId = keys[i];
                if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                    CallResult callResult;
                    TempData dataEntity = new TempData();
                    dataEntity.setTEMPDATAID(strKeyId);
                    if (bIndexDEMode) {
                        String[] keyParts = strKeyId.split("[:]");
                        if (keyParts.length >= 2) {
                            strKeyId = StringHelper.Format((String)"%1$s:%2$s", (Object)keyParts[0], (Object)keyParts[1]);
                        }
                        dataEntity.setTEMPDATAID(strKeyId);
                        callResult = iTempDataCtrl.Get((BaseDataEntity)dataEntity);
                        if (callResult.getRetCode() != 0) {
                            strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                            break;
                        }
                        if (deDataCtrlMap.containsKey(dataEntity.getTEMPDATANAME())) {
                            iRealDataCtrl = (IDEDataCtrl)deDataCtrlMap.get(dataEntity.getTEMPDATANAME());
                        } else {
                            iRealDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl(dataEntity.getTEMPDATANAME(), (ISRFDAWebContext)this.getWebContext());
                            deDataCtrlMap.put(dataEntity.getTEMPDATANAME(), iRealDataCtrl);
                        }
                    }
                    DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                    transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                    transactionManager.Register(this.getDEDataCtrl());
                    callResult = iRealDataCtrl.RemoveTempData(dataEntity);
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                    } else {
                        transactionManager.Commit();
                    }
                    if (callResult.getRetCode() != 0) {
                        strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                        break;
                    }
                }
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                removeActionResult.setRetCode(0);
            } else {
                removeActionResult.setRetCode(1);
                removeActionResult.setErrorInfo(strErrorInfo);
            }
        } else {
            String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
            String strErrorInfo = "";
            boolean bIndexDEMode = false;
            Vector<DERINDEX> derIndexList = null;
            TreeMap<String, DERINDEX> derIndexMap = null;
            TreeMap<String, IDEDataCtrl> deDataCtrlMap = null;
            if (this.getDEHelper().IsIndexDE()) {
                derIndexList = this.getDEHelper().GetDERINDEXs(true);
                derIndexMap = new TreeMap<String, DERINDEX>();
                deDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
                bIndexDEMode = true;
                for (DERINDEX derIndex : derIndexList) {
                    derIndexMap.put(derIndex.getTYPEVALUE(), derIndex);
                }
            }
            IDEDataCtrl iRealDataCtrl = this.getDEDataCtrl();
            int i = 0;
            while (i < keys.length) {
                String strKeyId = keys[i];
                if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                    CallResult callResult;
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                    if (bIndexDEMode) {
                        callResult = this.getDEDataCtrl().Get(dataEntity);
                        if (callResult.getRetCode() != 0) {
                            strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                            break;
                        }
                        String strType = dataEntity.GetParamStringValue(this.getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                        if (!derIndexMap.containsKey(strType)) {
                            strErrorInfo = StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7d22\u5f15\u5b9e\u4f53[%1$s]\u7c7b\u578b\u503c[%2$s]", (Object)this.getDEHelper().getId(), (Object)strType);
                            break;
                        }
                        DERINDEX derIndex = (DERINDEX)derIndexMap.get(strType);
                        if (deDataCtrlMap.containsKey(derIndex.getDEID())) {
                            iRealDataCtrl = (IDEDataCtrl)deDataCtrlMap.get(derIndex.getDEID());
                        } else {
                            iRealDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl(derIndex.getDEID(), (ISRFDAWebContext)this.getWebContext());
                            deDataCtrlMap.put(derIndex.getDEID(), iRealDataCtrl);
                        }
                        dataEntity.Reset();
                        dataEntity.SetParamValue(iRealDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)strKeyId);
                        callResult = iRealDataCtrl.Get(dataEntity);
                        if (callResult.getRetCode() != 0) {
                            strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                            break;
                        }
                    }
                    if ((callResult = this.OnRemoveActionBeforeRemove(iRealDataCtrl, dataEntity)).getRetCode() != 0) {
                        strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                        break;
                    }
                    DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                    transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                    transactionManager.Register(this.getDEDataCtrl());
                    callResult = iRealDataCtrl.Remove(dataEntity);
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                    } else {
                        transactionManager.Commit();
                    }
                    if (callResult.getRetCode() != 0) {
                        strErrorInfo = StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                        break;
                    }
                }
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                removeActionResult.setRetCode(0);
                if (this.OnGetMajorDataHashCode()) {
                    String strPDataHashCode = this.GetMajorDataHashCode();
                    if (StringHelper.IsNullOrEmpty((String)strPDataHashCode)) {
                        removeActionResult.setExtInfo("srfpdatahashcode", "");
                    } else {
                        removeActionResult.setExtInfo("srfpdatahashcode", strPDataHashCode);
                    }
                }
            } else {
                removeActionResult.setRetCode(1);
                removeActionResult.setErrorInfo(strErrorInfo);
            }
        }
        this.getPage().Output(this.OnRemoveActionOutputResult(removeActionResult));
        return true;
    }

    protected String OnRemoveActionOutputResult(SRFExAjaxActionResult removeActionResult) {
        return removeActionResult.ToJSONString();
    }

    protected CallResult OnRemoveActionBeforeRemove(BaseDataEntity dataEntity) {
        return this.OnRemoveActionBeforeRemove(this.getDEDataCtrl(), dataEntity);
    }

    protected CallResult OnRemoveActionBeforeRemove(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity) {
        CallResult callResult;
        if (!this.bTempDataMode && (callResult = this.OnTestDataAction(iDEDataCtrl.GetDEHelper(), dataEntity, "DELETE")).getRetCode() != 0) {
            return callResult;
        }
        return iDEDataCtrl.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORTXML", (boolean)true) == 0) {
            this.OnExportXML();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORT", (boolean)true) == 0) {
            this.OnExport();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORTIMPTEMPLATE", (boolean)true) == 0) {
            this.OnExportImportTemplate();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)"SRFDAADDBATCH", (boolean)true) == 0) {
            this.OnAddBatch();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)"SRFBEHAVIOR", (boolean)true) == 0) {
            this.OnDEBehavior(this.getWebContext().GetPostValue("srfbehaviorid"));
            return true;
        }
        return this.OnCustomCall(strAction);
    }

    protected boolean OnCustomCall(String strAction) {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        String strErrorInfo = "";
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        if (StringHelper.IsNullOrEmpty((String)strKeys)) {
            BaseDataEntity dataEntity = new BaseDataEntity();
            CallResult callResult = this.getDEDataCtrl().CustomCall(strAction, dataEntity);
            if (callResult.getRetCode() != 0) {
                strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
            }
        } else {
            String[] keys = strKeys.split("[,]");
            String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
            int i = 0;
            while (i < keys.length) {
                String strKeyId = keys[i];
                if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                    CallResult callResult = this.getDEDataCtrl().CustomCall(strAction, dataEntity);
                    if (callResult.getRetCode() != 0) {
                        strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                        break;
                    }
                    if (keys.length == 1) {
                        JSONObject objJSON = new JSONObject();
                        GridRowActionHelper.FillRow((SRFExWebContext)this.getWebContext(), (int)this.getWebContext().getRowIndex(), (JSONObject)objJSON, (BaseDataEntity)dataEntity, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID());
                        customActionResult.setRow(objJSON);
                    }
                }
                ++i;
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            customActionResult.setRetCode(0);
        } else {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(strErrorInfo);
        }
        this.getPage().Output(customActionResult.ToJSONString());
        return true;
    }

    protected boolean OnExportXML() {
        Vector<XMLNode> exportXMLNodes = new Vector<XMLNode>();
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        boolean bFrameOnly = false;
        String strFrameOnly = this.getWebContext().GetPostValue("frameonly");
        if (!StringHelper.IsNullOrEmpty((String)strFrameOnly)) {
            bFrameOnly = StringHelper.Compare((String)strFrameOnly, (String)"TRUE", (boolean)true) == 0;
        }
        String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                CallResult callResult = this.getDEDataCtrl().Export(dataEntity, exportXMLNodes, true, bFrameOnly);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u5931\u8d25\uff0c%3$s", (Object)this.getDEHelper().getName(), (Object)strKeyId, (Object)callResult.getErrorInfo()));
                }
            }
            ++i;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFDAXMLEXPORTS");
        for (XMLNode xmlNode : exportXMLNodes) {
            xmlNode.setNodeName("SRFDAXMLEXPORT");
            rootNode.AddNode(xmlNode);
        }
        String strTempId = Helper.GenGuidEx();
        String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.srfbak", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
        XMLNode.WriteToFile((XMLNode)rootNode, (String)strTempFilePath);
        String strDownloadURL = StringHelper.Format((String)"'../srfpage/export.jsp?FILEID=%1$s.srfbak'", (Object)strTempId);
        String strScript = BrowserJSHelper.getShowWindowScript((String)strDownloadURL, (String)"", (String)"'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0,width=30,height=30'", (boolean)false);
        customActionResult.setJSCode(strScript);
        customActionResult.setReload(false);
        this.getPage().Output(customActionResult.ToJSONString());
        return true;
    }

    protected boolean OnExport() {
        SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
        DataGrid gridView = this.getGridView();
        if (gridView == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
            exportResult.setRetCode(1);
            exportResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        String strDPDataAction = "";
        if (bUserDP) {
            strDPDataAction = this.OnGetDPDataAction();
        }
        if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(gridView, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(gridView);
        } else if (this.OnGetNoDefQuery()) {
            this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(strQueryModel, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
            this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s]\u7981\u7528  QUERYMODEL[%2$s] USERDP[%3$s]", (Object)gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
        } else {
            this.daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelperEx(strQueryModel, gridView, strDPDataAction, false) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel, gridView);
            this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s] QUERYMODEL[%2$s] USERDP[%3$s]", (Object)gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s] \u8054\u5408 [%2$s]", (Object)strQueryModel, (Object)gridView.getDATAGRIDID()));
        }
        if (this.daQueryModelHelper == null) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(this.daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        this.daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(userConditions, this.daQueryModelHelper);
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        int nStartRow = -1;
        int nPageSize = 0;
        String strTemp = this.getPage().getRequest().getParameter("start");
        if (StringHelper.Length((String)strTemp) != 0) {
            try {
                nStartRow = Integer.parseInt(strTemp);
            }
            catch (Exception ex) {
                nStartRow = -1;
            }
        }
        if (StringHelper.Length((String)(strTemp = this.getPage().getRequest().getParameter("limit"))) != 0) {
            try {
                nPageSize = Integer.parseInt(strTemp);
            }
            catch (Exception ex) {
                nPageSize = 0;
            }
        }
        String strSortParam = "";
        String strSortDirection = "";
        if (!gridView.getNOSORT()) {
            strSortParam = this.getPage().getRequest().getParameter("sort");
            String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
            if (StringHelper.Length((String)strRealSortParam) > 0) {
                strSortParam = strRealSortParam;
            }
            strSortDirection = this.getPage().getRequest().getParameter("dir");
        }
        String strPagingSQL = String.valueOf(this.daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + this.daQueryModelHelper.GetPagingSQL(script.toString(), nStartRow, nPageSize, strSortParam, strSortDirection, this.OnGetMinorSortField(), this.OnGetMinorSortDir());
        strPagingSQL = this.daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext(), true);
        Vector<CallParam> list = new Vector<CallParam>();
        this.daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        String strExportType = this.GetExportType();
        CallResult callResult = this.SelectAndExport(strPagingSQL, list, strExportType);
        if (callResult.getRetCode() != 0) {
            callResult.From((CallResult)exportResult);
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String strDownloadURL = "";
        strDownloadURL = StringHelper.Format((String)"'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", (Object)callResult.getUserObject(), (Object)strExportType);
        String strScript = "";
        strScript = StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel()) ? StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL) : StringHelper.Format((String)"SRFUtility.download(%1$s);", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
    }

    protected boolean OnExportImportTemplate() {
        SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
        String strDownloadURL = "";
        boolean bDefault = true;
        String strDataImport = "";
        if (this.ppDataGrid != null) {
            strDataImport = this.ppDataGrid.getDEDATAIMPORTNAME();
        }
        this.page.getPageParam("PAGE.DATAIMPORT", strDataImport);
        if (StringHelper.IsNullOrEmpty((String)strDataImport)) {
            strDataImport = "DEFAULT";
            bDefault = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDataImport)) {
            if (this.getDEHelper() == null) {
                if (!bDefault) {
                    this.page.PageLog((Object)this, 1, StringHelper.Format((String)"\u9875\u9762\u6307\u5b9a\u4e86\u6570\u636e\u5bfc\u5165\u6a21\u5f0f\uff0c\u4f46\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548"));
                }
            } else {
                DEDataImport dataImport = this.getDEHelper().GetDataImport(strDataImport);
                if (dataImport == null) {
                    if (!bDefault) {
                        this.page.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)this.getDEHelper().getId(), (Object)strDataImport));
                    }
                } else if (!StringHelper.IsNullOrEmpty((String)dataImport.getTEMPLPATH())) {
                    strDownloadURL = dataImport.getTEMPLPATH();
                }
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strDownloadURL)) {
            CallResult callResult;
            String strTempFileName = Helper.GenGuid();
            String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId());
            File dir = new File(strDir);
            dir.mkdirs();
            String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)"xls");
            try {
                callResult = DEDataImportTemplateHelper.Output((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getDEHelper(), strFullFileName);
            }
            catch (Exception e) {
                callResult = new CallResult();
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u5bfc\u5165\u6a21\u677f\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
                log.error((Object)callResult.getErrorInfo(), (Throwable)e);
            }
            if (callResult.getRetCode() != 0) {
                callResult.From((CallResult)exportResult);
                this.getPage().Output(exportResult.ToJSONString());
                return true;
            }
            strDownloadURL = StringHelper.Format((String)"../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s", (Object)strTempFileName, (Object)"");
        }
        String strScript = "";
        strScript = StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel()) ? StringHelper.Format((String)"SRFUtility.root().location='%1$s';", (Object)strDownloadURL) : StringHelper.Format((String)"SRFUtility.download('%1$s');", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
    }

    protected String OnGetDGMode() {
        String strDGMode = "";
        if (this.ppDataGrid != null) {
            strDGMode = this.ppDataGrid.getDGMODE();
        }
        return this.getPage().getPageParam("PAGE.DGMODE", strDGMode);
    }

    protected boolean OnAddBatch() {
        SRFExDGAjaxActionResult addBatchResult = new SRFExDGAjaxActionResult();
        DER1N srcDER1N = null;
        DER1N dstDER1N = null;
        if (this.getDEHelper().getDataEntity().getDETYPE() != 2 && this.getDEHelper().getDataEntity().getDETYPE() != 3) {
            addBatchResult.setRetCode(1);
            addBatchResult.setErrorInfo("\u76ee\u524d\u53ea\u6709\u5173\u7cfb\u5b9e\u4f53\u63d0\u4f9b\u6279\u589e\u52a0\u80fd\u529b");
            this.getPage().Output(addBatchResult.ToJSONString());
            return true;
        }
        String strDERId = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERId)) {
            addBatchResult.setRetCode(1);
            addBatchResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7f16\u53f7");
            this.getPage().Output(addBatchResult.ToJSONString());
            return true;
        }
        Vector<DER1N> derList = this.getDEHelper().GetDER1Ns(false);
        String strBatchDSTDERID = this.getWebContext().GetParamValue("SRFDSTDERID");
        for (DER1N der1n : derList) {
            if ((der1n.getDERSUBTYPE() & 8) == 0) continue;
            if (StringHelper.Compare((String)strDERId, (String)der1n.getDERID(), (boolean)true) == 0) {
                srcDER1N = der1n;
                continue;
            }
            if (!StringHelper.IsNullOrEmpty((String)strBatchDSTDERID)) {
                if (StringHelper.Compare((String)der1n.getDERID(), (String)strBatchDSTDERID, (boolean)true) != 0) continue;
                dstDER1N = der1n;
                continue;
            }
            dstDER1N = der1n;
        }
        if (srcDER1N == null || dstDER1N == null) {
            addBatchResult.setRetCode(1);
            addBatchResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u5b9e\u4f53\u5173\u7cfb\u6709\u8bef", (Object)this.getDEHelper().getId()));
            log.error((Object)addBatchResult.getErrorInfo());
            this.getPage().Output(addBatchResult.ToJSONString());
            return true;
        }
        IPickupDEFHelper iPickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(srcDER1N.getDERID());
        if (iPickupDEFHelper == null && this.getDEHelper().IsInheritMode()) {
            iPickupDEFHelper = this.getDEHelper().GetInheritDEHelper().FindPickupDEFHelper(srcDER1N.getDERID());
        }
        if (iPickupDEFHelper == null) {
            addBatchResult.setRetCode(1);
            addBatchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5173\u7cfb\u5c5e\u6027[%2$s]", (Object)this.getDEHelper().getId(), (Object)srcDER1N.getDERID()));
            log.error((Object)addBatchResult.getErrorInfo());
            this.getPage().Output(addBatchResult.ToJSONString());
            return true;
        }
        String strParamName = "";
        String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
        if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
            DERINDEX derIndex = new DERINDEX();
            CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
            } else {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                } else {
                    strParamName = iDEHelper.GetKeyDEFHelper().getName();
                }
            }
        } else {
            strParamName = iPickupDEFHelper.GetRelatedDEFHelper().getName();
        }
        String strDstDEFValue = "";
        String strSrcDEFValue = "";
        if (StringHelper.Compare((String)strParamName, (String)dstDER1N.getMAJORKEYDEFNAME(), (boolean)true) == 0) {
            strSrcDEFValue = this.getWebContext().GetParamValue(strParamName);
            strDstDEFValue = this.getWebContext().GetPostValue(strParamName);
        } else {
            strSrcDEFValue = this.getWebContext().GetPostValue(strParamName);
            if (StringHelper.IsNullOrEmpty((String)strSrcDEFValue)) {
                strSrcDEFValue = this.getWebContext().GetParamValue(strParamName);
            }
            if (StringHelper.IsNullOrEmpty((String)(strDstDEFValue = this.getWebContext().GetPostValue(dstDER1N.getMAJORKEYDEFNAME())))) {
                strDstDEFValue = this.getWebContext().GetParamValue(dstDER1N.getMAJORKEYDEFNAME());
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strSrcDEFValue) || StringHelper.IsNullOrEmpty((String)strDstDEFValue)) {
            addBatchResult.setRetCode(1);
            addBatchResult.setErrorInfo(StringHelper.Format((String)"\u5173\u7cfb\u6570\u636e\u65e0\u6548"));
            log.error((Object)addBatchResult.getErrorInfo());
            this.getPage().Output(addBatchResult.ToJSONString());
            return true;
        }
        TreeMap<String, DGModeDetail> dgModeDetailMap = new TreeMap<String, DGModeDetail>();
        String strDGMode = this.OnGetDGMode();
        if (!StringHelper.IsNullOrEmpty((String)strDGMode)) {
            Vector<DGModeDetail> dgModeDetails = new Vector<DGModeDetail>();
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDGModeDetails(strDGMode, dgModeDetails);
            if (callResult == null || callResult.getRetCode() != 0) {
                addBatchResult.setRetCode(1);
                addBatchResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u8868\u683c\u6a21\u5f0f\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                log.error((Object)addBatchResult.getErrorInfo());
                this.getPage().Output(addBatchResult.ToJSONString());
                return true;
            }
            for (DGModeDetail dgModeDetail : dgModeDetails) {
                dgModeDetailMap.put(dgModeDetail.getDEFNAME().toUpperCase(), dgModeDetail);
            }
        }
        if (this.bTempDataMode) {
            IDEDataCtrl dstDEDataCtrl = this.getPage().getDAModelStorage().FindDEDataCtrlEx(dstDER1N.getMAJORDEID(), this.getDEDataCtrl());
            if (dstDEDataCtrl == null) {
                addBatchResult.setRetCode(1);
                addBatchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)dstDER1N.getMAJORDEID()));
                log.error((Object)addBatchResult.getErrorInfo());
                this.getPage().Output(addBatchResult.ToJSONString());
                return true;
            }
            String[] dstKeys = strDstDEFValue.split("[,]");
            int i = 0;
            while (i < dstKeys.length) {
                String strDstKey = dstKeys[i];
                BaseDataEntity dataEntity = new BaseDataEntity();
                this.OnNewActionBeforeFillDataEntity(dataEntity);
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    String strParamValue;
                    if (iDEFHelper.IsKeyDEField() || StringHelper.IsNullOrEmpty((String)(strParamValue = this.getWebContext().GetPostValue(iDEFHelper.getName())))) continue;
                    Object fieldValue = iDEFHelper.GetDEFValue(strParamValue);
                    if (fieldValue == null) continue;
                    dataEntity.SetParamValue(iDEFHelper.getName(), fieldValue);
                }
                this.dgRowActionHelperEx.FillDataEntityDV(dataEntity);
                CallResult callResult = this.getDEDataCtrl().GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
                if (dataEntity.IsParamNull(srcDER1N.getMAJORKEYDEFNAME())) {
                    dataEntity.SetParamValue(srcDER1N.getMAJORKEYDEFNAME(), (Object)strSrcDEFValue);
                }
                dataEntity.SetParamValue(dstDER1N.getMAJORKEYDEFNAME(), (Object)strDstKey);
                DataEntity dstDataEntity = new DataEntity();
                dstDataEntity.SetParamValue(dstDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)strDstKey);
                callResult = dstDEDataCtrl.Get((BaseDataEntity)dstDataEntity);
                if (callResult.IsError()) {
                    addBatchResult.From(callResult);
                    log.error((Object)addBatchResult.getErrorInfo());
                    this.getPage().Output(addBatchResult.ToJSONString());
                    return true;
                }
                dataEntity.SetParamValue(dstDER1N.getMAJORTEXTDEFNAME(), dstDataEntity.GetParamValue(dstDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName()));
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    if (iDEFHelper.IsKeyDEField() || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                    DGModeDetail dgModeDetail = (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName());
                    String strDVT = iDEFHelper.getDGItem().GetDefaultValueType(dgModeDetail);
                    String strDV = iDEFHelper.getDGItem().GetDefaultValue(dgModeDetail);
                    if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0) continue;
                    dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
                }
                callResult = this.OnSaveActionBeforeInsert(dataEntity);
                if (callResult.getRetCode() != 0) {
                    addBatchResult.setRetCode(1);
                    addBatchResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    log.error((Object)addBatchResult.getErrorInfo());
                    this.getPage().Output(addBatchResult.ToJSONString());
                    return true;
                }
                String strInsertMode = this.OnGetDGInsertMode();
                if (StringHelper.IsNullOrEmpty((String)strInsertMode)) {
                    strInsertMode = "DEFAULT";
                }
                TempData tempData = new TempData();
                tempData.setTEMPDATAID("SRFDATEMPKEYID:" + Helper.GenGuid());
                tempData.setPDEID(srcDER1N.getMAJORDEID());
                tempData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
                tempData.setSAVEMODE(strInsertMode);
                tempData.setPTEMPKEYNAME(srcDER1N.getMAJORKEYDEFNAME());
                tempData.setPTEMPKEYVALUE(strSrcDEFValue);
                callResult = this.getDEDataCtrl().SaveTempData(tempData, dataEntity);
                if (callResult.getRetCode() != 0 && callResult.getRetCode() != 1006 && callResult.getRetCode() != 6 && callResult.getRetCode() != 1007 && callResult.getRetCode() != 7 && callResult.getRetCode() != 0) {
                    addBatchResult.setRetCode(1);
                    addBatchResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u4e34\u65f6\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    log.error((Object)addBatchResult.getErrorInfo());
                    this.getPage().Output(addBatchResult.ToJSONString());
                    return true;
                }
                ++i;
            }
        } else {
            String[] dstKeys = strDstDEFValue.split("[,]");
            int i = 0;
            while (i < dstKeys.length) {
                String strDstKey = dstKeys[i];
                BaseDataEntity dataEntity = new BaseDataEntity();
                this.OnNewActionBeforeFillDataEntity(dataEntity);
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    Object objValue;
                    String strParamValue;
                    if (iDEFHelper.IsKeyDEField() || StringHelper.IsNullOrEmpty((String)(strParamValue = this.getWebContext().GetPostValue(iDEFHelper.getName()))) || (objValue = iDEFHelper.GetDEFValue(strParamValue)) == null) continue;
                    dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                }
                this.dgRowActionHelperEx.FillDataEntityDV(dataEntity);
                CallResult callResult = this.getDEDataCtrl().GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
                dataEntity.SetParamValue(srcDER1N.getMAJORKEYDEFNAME(), (Object)strSrcDEFValue);
                dataEntity.SetParamValue(dstDER1N.getMAJORKEYDEFNAME(), (Object)strDstKey);
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    if (iDEFHelper.IsKeyDEField() || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                    DGModeDetail dgModeDetail = (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName());
                    String strDVT = iDEFHelper.getDGItem().GetDefaultValueType(dgModeDetail);
                    String strDV = iDEFHelper.getDGItem().GetDefaultValue(dgModeDetail);
                    if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0) continue;
                    dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
                }
                callResult = this.OnSaveActionBeforeInsert(dataEntity);
                if (callResult.getRetCode() != 0) {
                    addBatchResult.setRetCode(1);
                    addBatchResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    log.error((Object)addBatchResult.getErrorInfo());
                    this.getPage().Output(addBatchResult.ToJSONString());
                    return true;
                }
                String strInsertMode = this.OnGetDGInsertMode();
                if (StringHelper.IsNullOrEmpty((String)strInsertMode)) {
                    strInsertMode = "DEFAULT";
                }
                callResult = this.getDEDataCtrl().Save(true, strInsertMode, dataEntity);
                if ((callResult = this.OnSaveActionAfterInsert(callResult, dataEntity)).getRetCode() != 0 && callResult.getRetCode() != 1006 && callResult.getRetCode() != 6 && callResult.getRetCode() != 1007 && callResult.getRetCode() != 7 && callResult.getRetCode() != 0) {
                    addBatchResult.setRetCode(1);
                    addBatchResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    log.error((Object)addBatchResult.getErrorInfo());
                    this.getPage().Output(addBatchResult.ToJSONString());
                    return true;
                }
                ++i;
            }
        }
        addBatchResult.setRetCode(0);
        addBatchResult.setReload(true);
        this.getPage().Output(addBatchResult.ToJSONString());
        return true;
    }

    protected boolean OnGetDGSaveAtNew() {
        boolean bSaveAtNew = false;
        if (this.ppDataGrid != null && !this.ppDataGrid.IsParamNull("SAVEATNEW")) {
            bSaveAtNew = this.ppDataGrid.getSAVEATNEW();
        }
        return this.getPage().getPageParam("PAGE.DGACTIONHELPER.SAVEATNEW", bSaveAtNew);
    }

    protected boolean OnNewRowAction() {
        SRFExGridRowActionResult newRowResult = new SRFExGridRowActionResult();
        BaseDataEntity dataEntity = new BaseDataEntity();
        this.OnNewActionBeforeFillDataEntity(dataEntity);
        this.FillMajorDataEntity(dataEntity);
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            Object objValue;
            String strParamValue;
            if (iDEFHelper.IsKeyDEField() || StringHelper.IsNullOrEmpty((String)(strParamValue = this.getWebContext().GetPostValue(iDEFHelper.getName()))) || (objValue = iDEFHelper.GetDEFValue(strParamValue)) == null) continue;
            dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
        }
        this.dgRowActionHelperEx.FillDataEntityDV(dataEntity);
        CallResult callResult = this.getDEDataCtrl().GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
        newRowResult.From(callResult);
        if (newRowResult.getRetCode() != 0) {
            this.getPage().Output(newRowResult.ToJSONString());
            return true;
        }
        if (this.OnGetDGSaveAtNew()) {
            String strErrorMsg;
            DataGridEditItemErrors dgEditItemErrors = new DataGridEditItemErrors();
            if (!this.OnSaveActionAfterFillDataEntity(dataEntity, true, dgEditItemErrors)) {
                newRowResult.setRetCode(5);
                strErrorMsg = StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
                newRowResult.setErrorInfo(strErrorMsg);
                this.getPage().Output(newRowResult.ToJSONString());
                return true;
            }
            callResult = this.OnSaveActionBeforeInsert(dataEntity);
            if (callResult.getRetCode() != 0) {
                newRowResult.setRetCode(5);
                strErrorMsg = StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)callResult.getErrorInfo());
                newRowResult.setErrorInfo(strErrorMsg);
                this.getPage().Output(newRowResult.ToJSONString());
                return true;
            }
            callResult = this.getDEDataCtrl().Save(true, dataEntity);
            callResult = this.OnSaveActionAfterInsert(callResult, dataEntity);
            newRowResult.From(callResult);
            if (newRowResult.getRetCode() != 0 && callResult.IsUserError()) {
                this.FillDGRowUserErrors(dgEditItemErrors, callResult);
                newRowResult.setRetCode(5);
                strErrorMsg = StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
                newRowResult.setErrorInfo(strErrorMsg);
                JSONObject objJSON = new JSONObject();
                objJSON.put("rowindex", this.getWebContext().getRowIndex());
                newRowResult.setRow(objJSON);
                dgEditItemErrors.FillJSONs(newRowResult.getErrors());
            }
            newRowResult.setRowDirty(false);
        } else {
            newRowResult.setRowDirty(true);
        }
        JSONObject objJSON = new JSONObject();
        GridRowActionHelper.FillRow((SRFExWebContext)this.getWebContext(), (int)this.getWebContext().getRowIndex(), (JSONObject)objJSON, (BaseDataEntity)dataEntity, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID());
        objJSON.put("rowindex", this.getWebContext().getRowIndex());
        newRowResult.setRow(objJSON);
        String strContent = newRowResult.ToJSONString();
        this.getPage().Output(strContent);
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void FillMajorDataEntity(BaseDataEntity dataEntity) {
        Object objKeyValue;
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return;
        }
        IPickupDEFHelper pickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) {
                    return;
                }
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
            strDERID = pickupDEFHelper.GetDERId();
            this.getWebContext().SetParamValue("SRFDERID", strDERID);
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return;
        }
        boolean bAppendIndexValue = false;
        String strIndexType = "";
        String strParamName = "";
        String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
        if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
            DERINDEX derIndex = new DERINDEX();
            CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
            } else {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                } else {
                    strParamName = iDEHelper.GetKeyDEFHelper().getName();
                    if (iDEHelper.GetIndexMode() == 1) {
                        bAppendIndexValue = true;
                        strIndexType = derIndex.getTYPEVALUE();
                    }
                }
            }
        } else {
            strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
        }
        String strKeyValue = this.getWebContext().GetPostValue(strParamName);
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().GetParamValue(strParamName);
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            return;
        }
        if (bAppendIndexValue) {
            strKeyValue = BaseDEHelper.GetIndexDEKeyValueWithType((String)strIndexType, (Object)strKeyValue);
        }
        if ((objKeyValue = pickupDEFHelper.GetRealDEFHelper().GetDEFValue(strKeyValue)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5b9e\u9645\u5bf9\u8c61\u503c[%2$s]", (Object)pickupDEFHelper.GetRealDEFHelper().GetFullName(), (Object)strKeyValue));
            return;
        }
        dataEntity.SetParamValue(pickupDEFHelper.GetFormCtrl().GetFormCtrlId(), (Object)strKeyValue);
        DataEntity realDataEntity = new DataEntity();
        realDataEntity.SetParamValue(pickupDEFHelper.GetRealDEFHelper().getName(), objKeyValue);
        IDEDataCtrl iRealDataCtrl = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (iRealDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetFullName()));
            return;
        }
        CallResult callResult = iRealDataCtrl.Get((BaseDataEntity)realDataEntity);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)iRealDataCtrl.GetDEHelper().getName(), (Object)callResult.getErrorInfo()));
            return;
        }
        dataEntity.SetParamValue(pickupDEFHelper.GetPickupTextDEFHelper().getName(), (Object)realDataEntity.GetParamStringValue(pickupDEFHelper.GetPickupTextDEFHelper().GetRealDEFHelper().getName(), ""));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String GetMajorDataHashCode() {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return null;
        }
        IPickupDEFHelper pickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return null;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return null;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) {
                    return null;
                }
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return null;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
            strDERID = pickupDEFHelper.GetDERId();
            this.getWebContext().SetParamValue("SRFDERID", strDERID);
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return null;
        }
        String strParamName = "";
        String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
        if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
            DERINDEX derIndex = new DERINDEX();
            CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
            } else {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                } else {
                    strParamName = iDEHelper.GetKeyDEFHelper().getName();
                }
            }
        } else {
            strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
        }
        String strKeyValue = this.getWebContext().GetPostValue(strParamName);
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().GetParamValue(strParamName);
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            return null;
        }
        Object objKeyValue = pickupDEFHelper.GetRealDEFHelper().GetDEFValue(strKeyValue);
        if (objKeyValue == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5b9e\u9645\u5bf9\u8c61\u503c[%2$s]", (Object)pickupDEFHelper.GetRealDEFHelper().GetFullName(), (Object)strKeyValue));
            return null;
        }
        DataEntity realDataEntity = new DataEntity();
        realDataEntity.SetParamValue(pickupDEFHelper.GetRealDEFHelper().getName(), objKeyValue);
        IDEDataCtrl iRealDataCtrl = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (iRealDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetFullName()));
            return null;
        }
        CallResult callResult = iRealDataCtrl.Get((BaseDataEntity)realDataEntity);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)iRealDataCtrl.GetDEHelper().getName(), (Object)callResult.getErrorInfo()));
            return null;
        }
        String strCode = BaseDataEntity.ToString((BaseDataEntity)realDataEntity, (boolean)true);
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            int nCode = strCode.hashCode();
            return StringHelper.Format((String)"%1$s%2$s", (Object)(nCode >= 0 ? "A" : "B"), (Object)Math.abs(nCode));
        }
        return "";
    }

    protected boolean OnSaveRowAction() {
        return this.OnSaveAction();
    }

    protected boolean OnSaveAction() {
        DefaultTransactionManager transactionManager;
        JSONObject objJSON;
        SRFExGridRowActionResult saveRowResult = new SRFExGridRowActionResult();
        CallResult callResult = null;
        IDEDataCtrl iDEDataCtrl = this.getDEDataCtrl();
        BaseDataEntity dataEntity = new BaseDataEntity();
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        String strDataKey = "";
        strDataKey = this.bTempDataMode ? this.getWebContext().GetPostValue("SRFDATEMPKEYID") : this.getWebContext().GetPostValue(keyDEFHelper.getName());
        boolean bInsert = true;
        if (!this.bTempDataMode && !StringHelper.IsNullOrEmpty((String)strDataKey)) {
            dataEntity.SetParamValue(keyDEFHelper.getName(), keyDEFHelper.GetDEFValue(strDataKey));
            BaseDataEntity checkkeyparam = new BaseDataEntity();
            dataEntity.CopyTo(checkkeyparam, true);
            callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
            if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                saveRowResult.setRetCode(1);
                String strErrorMsg = "";
                strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)"\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!") : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)"\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!");
                JSONObject objJSON2 = new JSONObject();
                objJSON2.put("rowindex", this.getWebContext().getRowIndex());
                saveRowResult.setRow(objJSON2);
                saveRowResult.setErrorInfo(strErrorMsg);
                this.getPage().Output(saveRowResult.ToJSONString());
                return true;
            }
            int nState = (Integer)callResult.getUserObject();
            if (nState == 0) {
                bInsert = true;
            } else if (nState == 1) {
                bInsert = false;
            } else {
                saveRowResult.setRetCode(5);
                String strErrorMsg = "";
                strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)"\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!") : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)"\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!");
                saveRowResult.setErrorInfo(strErrorMsg);
                JSONObject objJSON3 = new JSONObject();
                objJSON3.put("rowindex", this.getWebContext().getRowIndex());
                saveRowResult.setRow(objJSON3);
                this.getPage().Output(saveRowResult.ToJSONString());
                return true;
            }
        }
        if (!bInsert && (callResult = iDEDataCtrl.Get(dataEntity)).getRetCode() != 0) {
            saveRowResult.setRetCode(1);
            String strErrorMsg = "";
            strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)callResult.getErrorInfo()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)callResult.getErrorInfo());
            saveRowResult.setErrorInfo(strErrorMsg);
            JSONObject objJSON4 = new JSONObject();
            objJSON4.put("rowindex", this.getWebContext().getRowIndex());
            saveRowResult.setRow(objJSON4);
            this.getPage().Output(saveRowResult.ToJSONString());
            return true;
        }
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        DataGridEditItemErrors dgEditItemErrors = new DataGridEditItemErrors();
        if (!this.OnSaveActionFillDataEntity(bInsert, dataEntity, dgEditItemErrors)) {
            saveRowResult.setRetCode(5);
            String strErrorMsg = "";
            strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)dgEditItemErrors.getTotalErrorMessage()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
            saveRowResult.setErrorInfo(strErrorMsg);
            JSONObject objJSON5 = new JSONObject();
            objJSON5.put("rowindex", this.getWebContext().getRowIndex());
            saveRowResult.setRow(objJSON5);
            this.getPage().Output(saveRowResult.ToJSONString());
            return true;
        }
        if (bInsert) {
            TreeMap<String, DGModeDetail> dgModeDetailMap = new TreeMap<String, DGModeDetail>();
            String strDGMode = this.OnGetDGMode();
            if (!StringHelper.IsNullOrEmpty((String)strDGMode)) {
                Vector<DGModeDetail> dgModeDetails = new Vector<DGModeDetail>();
                callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDGModeDetails(strDGMode, dgModeDetails);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u683c\u6a21\u5f0f\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    saveRowResult.setRetCode(1);
                    String strErrorMsg = "";
                    strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)callResult.getErrorInfo()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)callResult.getErrorInfo());
                    saveRowResult.setErrorInfo(strErrorMsg);
                    JSONObject objJSON6 = new JSONObject();
                    objJSON6.put("rowindex", this.getWebContext().getRowIndex());
                    saveRowResult.setRow(objJSON6);
                    this.getPage().Output(saveRowResult.ToJSONString());
                    return true;
                }
                for (DGModeDetail dgModeDetail : dgModeDetails) {
                    dgModeDetailMap.put(dgModeDetail.getDEFNAME().toUpperCase(), dgModeDetail);
                }
            }
            for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                if (iDEFHelper.IsKeyDEField() || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                DGModeDetail dgModeDetail = (DGModeDetail)dgModeDetailMap.get(iDEFHelper.getName());
                String strDVT = iDEFHelper.getDGItem().GetDefaultValueType(dgModeDetail);
                String strDV = iDEFHelper.getDGItem().GetDefaultValue(dgModeDetail);
                if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0) continue;
                dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
            }
        }
        this.dgRowActionHelperEx.RemoveInvalidValue(dataEntity, bInsert);
        if (!this.OnSaveActionAfterFillDataEntity(dataEntity, bInsert, dgEditItemErrors)) {
            saveRowResult.setRetCode(5);
            String strErrorMsg = "";
            strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)dgEditItemErrors.getTotalErrorMessage()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
            saveRowResult.setErrorInfo(strErrorMsg);
            objJSON = new JSONObject();
            objJSON.put("rowindex", this.getWebContext().getRowIndex());
            saveRowResult.setRow(objJSON);
            this.getPage().Output(saveRowResult.ToJSONString());
            return true;
        }
        if (bInsert) {
            callResult = this.OnSaveActionBeforeInsert(dataEntity);
            if (callResult.getRetCode() != 0) {
                saveRowResult.setRetCode(5);
                String strErrorMsg = "";
                strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)callResult.getErrorInfo()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)callResult.getErrorInfo());
                saveRowResult.setErrorInfo(strErrorMsg);
                objJSON = new JSONObject();
                objJSON.put("rowindex", this.getWebContext().getRowIndex());
                saveRowResult.setRow(objJSON);
                this.getPage().Output(saveRowResult.ToJSONString());
                return true;
            }
            String strInsertMode = this.OnGetDGInsertMode();
            if (StringHelper.IsNullOrEmpty((String)strInsertMode)) {
                strInsertMode = "DEFAULT";
            }
            transactionManager = new DefaultTransactionManager();
            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            if (this.bTempDataMode) {
                TempData tempData = new TempData();
                tempData.setTEMPDATAID(strDataKey);
                IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext());
                if (iTempDataCtrl == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                    saveRowResult.setRetCode(1);
                    saveRowResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                    this.getPage().Output(saveRowResult.ToJSONString());
                    return true;
                }
                boolean bFillTempDataPDEInfo = false;
                if (!StringHelper.IsNullOrEmpty((String)strDataKey)) {
                    callResult = iTempDataCtrl.Get((BaseDataEntity)tempData);
                    if (callResult.getRetCode() == 3) {
                        bFillTempDataPDEInfo = true;
                    }
                } else {
                    bFillTempDataPDEInfo = true;
                }
                if (bFillTempDataPDEInfo && !this.FillTempDataPDEInfo(tempData, dataEntity)) {
                    saveRowResult.setRetCode(1);
                    saveRowResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u5b9e\u4f53\u6570\u636e"));
                    this.getPage().Output(saveRowResult.ToJSONString());
                    return true;
                }
                tempData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
                tempData.setSAVEMODE(strInsertMode);
                transactionManager.Register(iDEDataCtrl);
                callResult = iDEDataCtrl.SaveTempData(tempData, dataEntity);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                } else {
                    transactionManager.Commit();
                }
                if (callResult.IsError()) {
                    saveRowResult.From(callResult);
                    this.getPage().Output(saveRowResult.ToJSONString());
                    return true;
                }
                dataEntity.SetParamValue("SRFDATEMPKEYID", (Object)tempData.getTEMPDATAID());
            } else {
                transactionManager.Register(iDEDataCtrl);
                callResult = iDEDataCtrl.Save(true, strInsertMode, dataEntity);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                } else {
                    transactionManager.Commit();
                }
                callResult = this.OnSaveActionAfterInsert(callResult, dataEntity);
            }
        } else {
            callResult = this.OnSaveActionBeforeUpdate(dataEntity);
            if (callResult.getRetCode() != 0) {
                saveRowResult.setRetCode(5);
                String strErrorMsg = "";
                strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)callResult.getErrorInfo()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)callResult.getErrorInfo());
                saveRowResult.setErrorInfo(strErrorMsg);
                objJSON = new JSONObject();
                objJSON.put("rowindex", this.getWebContext().getRowIndex());
                saveRowResult.setRow(objJSON);
                this.getPage().Output(saveRowResult.ToJSONString());
                return true;
            }
            String strUpdateMode = this.OnGetDGUpdateMode();
            if (StringHelper.IsNullOrEmpty((String)strUpdateMode)) {
                strUpdateMode = "DEFAULT";
            }
            transactionManager = new DefaultTransactionManager();
            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            transactionManager.Register(iDEDataCtrl);
            callResult = iDEDataCtrl.Save(false, strUpdateMode, dataEntity);
            if (callResult.IsError()) {
                transactionManager.Rollback();
            } else {
                transactionManager.Commit();
            }
            callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity);
        }
        saveRowResult.From(callResult);
        if (saveRowResult.getRetCode() != 0) {
            if (callResult.IsUserError()) {
                this.FillDGRowUserErrors(dgEditItemErrors, callResult);
                saveRowResult.setRetCode(5);
                String strErrorMsg = "";
                strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u4fdd\u5b58\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n%1$s", (Object)dgEditItemErrors.getTotalErrorMessage()) : StringHelper.Format((String)"\u4fdd\u5b58\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
                saveRowResult.setErrorInfo(strErrorMsg);
                objJSON = new JSONObject();
                objJSON.put("rowindex", this.getWebContext().getRowIndex());
                saveRowResult.setRow(objJSON);
                dgEditItemErrors.FillJSONs(saveRowResult.getErrors());
            }
        } else {
            if (this.OnGetMajorDataHashCode()) {
                String strPDataHashCode = this.GetMajorDataHashCode();
                if (StringHelper.IsNullOrEmpty((String)strPDataHashCode)) {
                    saveRowResult.setExtInfo("srfpdatahashcode", "");
                } else {
                    saveRowResult.setExtInfo("srfpdatahashcode", strPDataHashCode);
                }
            }
            JSONObject objJSON7 = new JSONObject();
            GridRowActionHelper.FillRow((SRFExWebContext)this.getWebContext(), (int)this.getWebContext().getRowIndex(), (JSONObject)objJSON7, (BaseDataEntity)dataEntity, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID());
            objJSON7.put("rowindex", this.getWebContext().getRowIndex());
            saveRowResult.setRow(objJSON7);
        }
        this.getPage().Output(this.OnSaveActionOutputResult(dataEntity, saveRowResult));
        return true;
    }

    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExGridRowActionResult saveRowResult) {
        return saveRowResult.ToJSONString();
    }

    protected void FillDGRowUserErrors(DataGridEditItemErrors dgEditItemErrors, CallResult callResult) {
        DBResult result;
        Object objDBResult = callResult.getUserObject();
        if (objDBResult != null && objDBResult instanceof DBResult && (result = (DBResult)objDBResult).getOutValues().containsKey("SRF_TAG")) {
            String strFormItems = (String)result.getOutValues().get("SRF_TAG");
            String[] formItems = StringHelper.Split((String)strFormItems, (char)'|');
            int i = 0;
            while (i < formItems.length) {
                String strFormItemId = formItems[i];
                if (StringHelper.Length((String)strFormItemId) != 0) {
                    IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strFormItemId);
                    if (iDEFHelper != null) {
                        dgEditItemErrors.Register(iDEFHelper.getName(), iDEFHelper.getLogicName(this.getPage().getLanguage()), 3, callResult.getErrorInfo());
                    } else {
                        String strErrorInfo = "";
                        strErrorInfo = StringHelper.Format((String)"\u8868\u683c\u4e2d\u4e0d\u5b58\u5728[%1$s]", (Object)strFormItemId);
                        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo) && !StringHelper.IsNullOrEmpty((String)callResult.getErrorInfo())) {
                            strErrorInfo = String.valueOf(strErrorInfo) + ",";
                        }
                        strErrorInfo = String.valueOf(strErrorInfo) + callResult.getErrorInfo();
                        dgEditItemErrors.Register(strFormItemId, strFormItemId, 3, strErrorInfo);
                    }
                }
                ++i;
            }
        }
    }

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected boolean OnSaveActionAfterFillDataEntity(BaseDataEntity dataEntity, boolean bInsert, DataGridEditItemErrors dgEditItemErrors) {
        Vector<ValueError> errors = new Vector<ValueError>();
        String strActionMode = "DEFAULT";
        strActionMode = bInsert ? this.OnGetDGInsertMode() : this.OnGetDGUpdateMode();
        CallResult callResult = this.getDEDataCtrl().TestSave(bInsert, strActionMode, dataEntity, errors);
        if (callResult.getRetCode() != 0) {
            for (ValueError valueError : errors) {
                String strErrorInfo = "";
                IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(valueError.getValue());
                if (iDEFHelper != null) {
                    strErrorInfo = StringHelper.Format((String)"\u8868\u683c\u4e2d\u4e0d\u5b58\u5728[%1$s]", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
                }
                if (!StringHelper.IsNullOrEmpty((String)strErrorInfo) && !StringHelper.IsNullOrEmpty((String)callResult.getErrorInfo())) {
                    strErrorInfo = String.valueOf(strErrorInfo) + ",";
                }
                strErrorInfo = String.valueOf(strErrorInfo) + callResult.getErrorInfo();
                if (iDEFHelper != null) {
                    dgEditItemErrors.Register(iDEFHelper.getName(), iDEFHelper.getLogicName(this.getPage().getLanguage()), 3, strErrorInfo);
                    continue;
                }
                dgEditItemErrors.Register(valueError.getValue(), valueError.getValue(), 3, strErrorInfo);
            }
            return false;
        }
        return true;
    }

    protected boolean IsContainKey(BaseDataEntity dataEntity) {
        return GridRowActionHelper.IsContainerKeyValue((SRFExWebContext)this.getWebContext(), (BaseDataEntity)dataEntity, (SRFExDataGrid)this.getDataGrid());
    }

    protected void OnSaveActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected void OnNewActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean OnSaveActionFillDataEntity(boolean bInsert, BaseDataEntity dataEntity, DataGridEditItemErrors dgEditItemErrors) {
        return this.dgRowActionHelperEx.FillDataEntityEx(bInsert, dataEntity, false, dgEditItemErrors);
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected DataGrid getGridView() {
        if (this.gridView != null) {
            return this.gridView;
        }
        Object obj = this.getPage().getPageParam(this.getDataGrid().getID().toUpperCase());
        if (obj != null && obj instanceof DataGrid) {
            this.gridView = (DataGrid)obj;
            return this.gridView;
        }
        obj = this.getPage().getPageParam("GRIDVIEW");
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataGrid) {
            this.gridView = (DataGrid)obj;
        }
        return this.gridView;
    }

    protected IDEDataCtrl getDEDataCtrl() {
        return this.getPage().GetDEDataCtrl();
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        try {
            return this.getDEHelper().GetDataLockKey((ISRFDAWebContext)this.getWebContext(), dataEntity);
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u9501\u94a5\u5319\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected IDEHelper getDEHelper() {
        return this.getPage().getDEHelper();
    }

    protected String OnGetSelectedColumns(DataGridConfig dataGridConfig) {
        DGModelGroupLogicConfig dgModelGroupLogicConfig;
        String strValue;
        String strColumns = "";
        boolean bOptimizedMode = false;
        if (!this.gridView.isOPTIMIZEQUERYNull() && this.gridView.getOPTIMIZEQUERY()) {
            bOptimizedMode = true;
        }
        if (bOptimizedMode && !StringHelper.IsNullOrEmpty((String)(strValue = this.getPage().getRequest().getParameter("srfcsm"))) && XMLConfig.LoadFromXML((String)strValue, (XMLConfig)(dgModelGroupLogicConfig = new DGModelGroupLogicConfig())) && dgModelGroupLogicConfig.getLogicsConfig() != null && dgModelGroupLogicConfig.getLogicsConfig().size() > 0) {
            bOptimizedMode = false;
        }
        log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2\u542f\u7528\u4f18\u5316\u6a21\u5f0f[%1$s]", (Object)bOptimizedMode));
        if (bOptimizedMode) {
            strColumns = this.getDEHelper().GetSearchableColumns();
            strColumns = String.valueOf(strColumns) + ";";
            this.gridView.setOptimizeQueryMode(true);
        } else {
            strColumns = this.getDEHelper().GetDGColumns();
            strColumns = String.valueOf(strColumns) + ";";
            this.gridView.setOptimizeQueryMode(false);
        }
        strColumns = String.valueOf(strColumns) + BaseDADataGridActionHelper.GetSelectedColumns(dataGridConfig);
        return strColumns;
    }

    public static String GetSelectedColumns(DataGridConfig dataGridConfig) {
        String strColumns = "";
        int nSize = dataGridConfig.getDataGridDSConfig().getList().size();
        int i = 0;
        while (i < nSize) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridConfig.getDataGridDSConfig().getList().get(i);
            if (dsItemConfig.getItemParamsConfig() == null) {
                strColumns = String.valueOf(strColumns) + dsItemConfig.getID();
                strColumns = String.valueOf(strColumns) + ";";
            } else {
                int nSize2 = dsItemConfig.getItemParamsConfig().getList().size();
                int j = 0;
                while (j < nSize2) {
                    ItemParamConfig itemParamConfig = (ItemParamConfig)dsItemConfig.getItemParamsConfig().getList().get(j);
                    strColumns = String.valueOf(strColumns) + itemParamConfig.getID();
                    strColumns = String.valueOf(strColumns) + ";";
                    ++j;
                }
            }
            ++i;
        }
        return strColumns;
    }

    public static void ConverItemsToArray(SRFExGridFetchResult result, ISRFDAWebContext webContext, DataGridConfig dataGridConfig, boolean bEnableItemPrivilege) {
        IUserPrivilegeMgr iUserPrivilegeMgr = webContext.GetUserPrivilegeMgr();
        Vector<String> keys = new Vector<String>();
        if (dataGridConfig.getSelectColumn()) {
            keys.add("SELECTCOLUMN");
        }
        keys.add("KEYS");
        ArrayList dsItems = dataGridConfig.getDataGridDSConfig().getList();
        int i = 0;
        while (i < dsItems.size()) {
            DataGridDSItemConfig dsItem = (DataGridDSItemConfig)dsItems.get(i);
            if (!bEnableItemPrivilege || iUserPrivilegeMgr.TestColumn((ISRFExWebContext)webContext, dsItem.getPrivilegeId()) != 0) {
                keys.add(dsItem.getID().toLowerCase());
                if (dsItem.getKey()) {
                    keys.add(dsItem.getID().toUpperCase());
                }
            }
            ++i;
        }
        Vector items = result.getItems();
        Vector<Object[]> arrs = new Vector<Object[]>();
        int i2 = 0;
        while (i2 < items.size()) {
            JSONObject jo = (JSONObject)items.get(i2);
            Object[] objs = new Object[keys.size()];
            int j = 0;
            while (j < keys.size()) {
                objs[j] = jo.get((String)keys.get(j));
                ++j;
            }
            arrs.add(objs);
            ++i2;
        }
        result.getItems().clear();
        result.getItems().addAll(arrs);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void OnDEBehavior(String strDEBehaviorId) {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)customActionResult);
        DEBehavior deBehavior = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEBehavior(strDEBehaviorId);
        if (deBehavior == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)strDEBehaviorId));
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        if (StringHelper.IsNullOrEmpty((String)deBehavior.getDEACTIONID())) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6240\u5bf9\u5e94\u7684\u5b9e\u4f53\u64cd\u4f5c", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        DEAction deAction = this.getPage().getDEHelper().GetDEAction(deBehavior.getDEACTIONID());
        if (deAction == null) {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u884c\u4e3a[%1$s]", (Object)deBehavior.getDEACTIONID()));
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getRESOURCEID()) && !this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), deBehavior.getRESOURCEID())) {
            customActionResult.setRetCode(2);
            customActionResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6743\u9650\u4e0d\u8db3", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(customActionResult.ToJSONString());
            return;
        }
        String strErrorInfo = "";
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        if (StringHelper.IsNullOrEmpty((String)strKeys)) {
            if (StringHelper.Compare((String)"NONE", (String)deBehavior.getACTIONTARGET(), (boolean)true) != 0) {
                customActionResult.setRetCode(1);
                customActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u4f20\u5165\u7684\u6570\u636e");
                this.getPage().Output(customActionResult.ToJSONString());
                return;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            transactionManager.Register(this.getDEDataCtrl());
            CallResult callResult = this.getDEDataCtrl().Execute(deAction, dataEntity);
            if (callResult.IsError()) {
                transactionManager.Rollback();
            } else {
                transactionManager.Commit();
            }
            if (callResult.getRetCode() != 0) {
                strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                customActionResult.setRetCode(1);
                customActionResult.setErrorInfo(strErrorInfo);
                this.getPage().Output(customActionResult.ToJSONString());
                return;
            }
        } else {
            String[] keys = strKeys.split("[,]");
            String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
            int i = 0;
            while (i < keys.length) {
                String strKeyId = keys[i];
                if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                    CallResult callResult;
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                    if (!StringHelper.IsNullOrEmpty((String)deAction.getDEDATAACTION()) && (callResult = this.OnTestDataAction(dataEntity, deAction.getDEDATAACTION())).getRetCode() != 0) {
                        customActionResult.From(callResult);
                        this.getPage().Output(customActionResult.ToJSONString());
                        return;
                    }
                    transactionManager.Register(this.getDEDataCtrl());
                    callResult = this.getDEDataCtrl().Execute(deAction, dataEntity);
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                    } else {
                        transactionManager.Commit();
                    }
                    if (callResult.getRetCode() != 0) {
                        strErrorInfo = StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                        customActionResult.setRetCode(1);
                        customActionResult.setErrorInfo(strErrorInfo);
                        this.getPage().Output(customActionResult.ToJSONString());
                        return;
                    }
                    if (keys.length == 1) {
                        JSONObject objJSON = new JSONObject();
                        GridRowActionHelper.FillRow((SRFExWebContext)this.getWebContext(), (int)this.getWebContext().getRowIndex(), (JSONObject)objJSON, (BaseDataEntity)dataEntity, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID());
                        customActionResult.setRow(objJSON);
                    }
                }
                ++i;
            }
        }
        customActionResult.setReload(deBehavior.getRELOADDATA());
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSINFO())) {
            customActionResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)deBehavior.getSUCCESSINFO()));
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSCODE())) {
            customActionResult.AppendJSCode(deBehavior.getSUCCESSCODE());
        }
        this.getPage().Output(customActionResult.ToJSONString());
    }

    protected boolean OnItemUpdateActionFillDataEntity(BaseDataEntity dataEntity, DataGridEditItemErrors dgEditItemErrors) {
        return this.dgRowActionHelperEx.FillDataEntityEx(false, dataEntity, true, dgEditItemErrors);
    }

    protected boolean OnItemUpdateAction(String strAction) {
        String strMessage;
        SRFExGridRowActionResult itemUpdateResult = new SRFExGridRowActionResult();
        FIUpdate fiUpdate = this.getPage().getDAModelStorage().FindFIUpdate(this.getPage().getPageDataEntityId(), strAction);
        if (fiUpdate == null) {
            itemUpdateResult.setRetCode(1);
            itemUpdateResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879\u586b\u5145\u6a21\u5f0f[%1$s-%2$s]", (Object)this.getPage().getPageDataEntityId(), (Object)strAction));
            this.getPage().PageLog((Object)this, 1, itemUpdateResult.getErrorInfo());
            this.getPage().Output(itemUpdateResult.ToJSONString());
            return true;
        }
        String strActionMode = fiUpdate.GetParamStringValue("ACTIONMODE", "");
        BaseDataEntity dataEntity = new BaseDataEntity();
        DataGridEditItemErrors dgEditItemErrors = new DataGridEditItemErrors();
        if (!this.OnItemUpdateActionFillDataEntity(dataEntity, dgEditItemErrors)) {
            itemUpdateResult.setRetCode(5);
            String strErrorMsg = "";
            strErrorMsg = this.getWebContext().getRowIndex() == -1 ? StringHelper.Format((String)"\u8868\u5355\u9879\u66f4\u65b0\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%1$s", (Object)dgEditItemErrors.getTotalErrorMessage()) : StringHelper.Format((String)"\u8868\u5355\u9879\u66f4\u65b0\u7b2c[%1$s]\u884c\u6570\u636e\u51fa\u73b0\u9519\u8bef\uff0c\u539f\u56e0:\r\n\r\n%2$s", (Object)(this.getWebContext().getRowIndex() + 1), (Object)dgEditItemErrors.getTotalErrorMessage());
            itemUpdateResult.setErrorInfo(strErrorMsg);
            JSONObject objJSON = new JSONObject();
            objJSON.put("rowindex", this.getWebContext().getRowIndex());
            itemUpdateResult.setRow(objJSON);
            this.getPage().Output(itemUpdateResult.ToJSONString());
            return true;
        }
        CallResult callResult = this.getDEDataCtrl().CustomCall(strActionMode, dataEntity);
        if (callResult.IsError()) {
            itemUpdateResult.From(callResult);
            this.getPage().PageLog((Object)this, 1, itemUpdateResult.getErrorInfo());
            this.getPage().Output(itemUpdateResult.ToJSONString());
            return true;
        }
        String strInfoField = fiUpdate.getInfoField();
        if (!StringHelper.IsNullOrEmpty((String)strInfoField) && !StringHelper.IsNullOrEmpty((String)(strMessage = dataEntity.GetParamStringValue(strInfoField, "")))) {
            itemUpdateResult.AppendJSCode(BrowserJSHelper.getAlertMessageScript((String)strMessage));
        }
        JSONObject objJSON = new JSONObject();
        GridRowActionHelper.FillRow((SRFExWebContext)this.getWebContext(), (int)this.getWebContext().getRowIndex(), (JSONObject)objJSON, (BaseDataEntity)dataEntity, (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID());
        if (fiUpdate.getRelatedFields() != null) {
            boolean bLoop = true;
            while (bLoop) {
                boolean bRemove = false;
                Iterator keys = objJSON.keys();
                while (keys.hasNext()) {
                    String strKey = (String)keys.next();
                    if (fiUpdate.getRelatedFields().containsKey(strKey.toLowerCase()) || fiUpdate.getRelatedFields().containsKey(strKey.toUpperCase())) continue;
                    bRemove = true;
                    objJSON.remove(strKey);
                    break;
                }
                if (bRemove) continue;
                bLoop = false;
            }
        }
        objJSON.put("rowindex", this.getWebContext().getRowIndex());
        itemUpdateResult.setRow(objJSON);
        this.getPage().Output(itemUpdateResult.ToJSONString());
        return true;
    }

    protected boolean isTempDataMode() {
        return this.bTempDataMode;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean FillTempDataPDEInfo(TempData tempData, BaseDataEntity dataEntity) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return false;
        }
        IPickupDEFHelper pickupDEFHelper = this.getPage().getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return false;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return false;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) return false;
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return false;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return false;
        }
        tempData.setPDEID(pickupDEFHelper.GetRealDEFHelper().getDEHelper().getId());
        tempData.setPTEMPKEYNAME(pickupDEFHelper.getName());
        String strKeyValue = dataEntity.GetParamStringValue(pickupDEFHelper.GetRelatedDEFHelper().getName(), "");
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) return false;
            Vector<DERINDEX> list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
            boolean bFind = false;
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                    continue;
                }
                strKeyValue = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) continue;
                bFind = true;
                break;
            }
            if (!bFind) {
                return false;
            }
        }
        tempData.setPTEMPKEYVALUE(strKeyValue);
        return true;
    }

    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_GETLAST, (boolean)true) == 0) {
            this.OnGetLastAction();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_CHECKIN, (boolean)true) == 0) {
            this.OnCheckInAction();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_CHECKOUT, (boolean)true) == 0) {
            this.OnCheckOutAction();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_AUTOCHECKOUT, (boolean)true) == 0) {
            this.OnAutoCheckOutAction();
            return true;
        }
        return super.OnProcess(strAction);
    }

    protected void OnGetLastAction() {
        SRFExGridRowActionResult rowActionResult = new SRFExGridRowActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)rowActionResult);
        String strErrorInfo = "";
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        String[] keys = strKeys.split("[,]");
        String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
        ArrayList<JSONObject> arrList = new ArrayList<JSONObject>();
        HashMap dataMap = new HashMap();
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                transactionManager.Register(this.getDEDataCtrl());
                CallResult callResult = this.getDEDataCtrl().GetDataLastVersion(dataEntity, arrList, dataMap, false);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                } else {
                    transactionManager.Commit();
                }
                if (callResult.getRetCode() != 0) {
                    strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u79bb\u7ebf\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    rowActionResult.setRetCode(1);
                    rowActionResult.setErrorInfo(strErrorInfo);
                    this.getPage().Output(rowActionResult.ToJSONString());
                    return;
                }
            }
            ++i;
        }
        for (JSONObject item : arrList) {
            rowActionResult.getItems().add(item);
        }
        this.getPage().Output(rowActionResult.ToJSONString());
    }

    protected void OnAutoCheckOutAction() {
        SRFExGridRowActionResult rowActionResult = new SRFExGridRowActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)rowActionResult);
        String strErrorInfo = "";
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        String[] keys = strKeys.split("[,]");
        String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
        ArrayList<JSONObject> arrList = new ArrayList<JSONObject>();
        HashMap dataMap = new HashMap();
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                transactionManager.Register(this.getDEDataCtrl());
                CallResult callResult = this.getDEDataCtrl().AutoCheckoutData(dataEntity, arrList, dataMap);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                } else {
                    transactionManager.Commit();
                }
                if (callResult.getRetCode() != 0) {
                    strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u79bb\u7ebf\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    rowActionResult.setRetCode(1);
                    rowActionResult.setErrorInfo(strErrorInfo);
                    this.getPage().Output(rowActionResult.ToJSONString());
                    return;
                }
            }
            ++i;
        }
        for (JSONObject item : arrList) {
            rowActionResult.getItems().add(item);
        }
        this.getPage().Output(rowActionResult.ToJSONString());
    }

    protected void OnCheckOutAction() {
        SRFExGridRowActionResult rowActionResult = new SRFExGridRowActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)rowActionResult);
        String strErrorInfo = "";
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        String[] keys = strKeys.split("[,]");
        String strKeyParam = this.getDEHelper().GetKeyDEFHelper().getName();
        ArrayList<JSONObject> arrList = new ArrayList<JSONObject>();
        HashMap dataMap = new HashMap();
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyId);
                transactionManager.Register(this.getDEDataCtrl());
                CallResult callResult = this.getDEDataCtrl().CheckoutData(dataEntity, arrList, dataMap);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                } else {
                    transactionManager.Commit();
                }
                if (callResult.getRetCode() != 0) {
                    strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u79bb\u7ebf\u6570\u636e\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    rowActionResult.setRetCode(1);
                    rowActionResult.setErrorInfo(strErrorInfo);
                    this.getPage().Output(rowActionResult.ToJSONString());
                    return;
                }
            }
            ++i;
        }
        for (JSONObject item : arrList) {
            rowActionResult.getItems().add(item);
        }
        this.getPage().Output(rowActionResult.ToJSONString());
    }

    protected void OnCheckInAction() {
        SRFExGridRowActionResult rowActionResult = new SRFExGridRowActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)rowActionResult);
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        try {
            String strCheckInData = this.getWebContext().GetPostValue("srfcheckindata");
            JSONArray ja = JSONArray.fromString((String)strCheckInData);
            IDEDataCtrl rootDataCtrl = this.getDEDataCtrl();
            transactionManager.Register(rootDataCtrl);
            for (int i = 0; i < ja.length(); ++i) {
                JSONObject item = ja.getJSONObject(i);
                String strDEId = item.getString("srfdeid");
                IDEDataCtrl iDEDataCtrl = rootDataCtrl.GetRelatedDataCtrl(strDEId);
                CallResult callResult = iDEDataCtrl.CheckinData(item);
                if (!callResult.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            transactionManager.Commit();
            this.OnGetLastAction();
            return;
        }
        catch (Exception ex) {
            transactionManager.Rollback();
            rowActionResult.setRetCode(1);
            rowActionResult.setErrorInfo(ex.getMessage());
            this.getPage().Output(rowActionResult.ToJSONString());
            return;
        }
    }
}
