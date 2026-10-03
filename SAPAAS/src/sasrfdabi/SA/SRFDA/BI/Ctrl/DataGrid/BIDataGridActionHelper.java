/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.DGModelBaseLogicConfig
 *  SA.SRFDA.Model.DGModelGroupLogicConfig
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.Utility.ISRFDAPOLogger
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.DataEntityTable
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridActionHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridConfig
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  SA.SRFramework.WebEx.UI.ItemParamConfig
 *  SA.SRFramework.WebEx.Utility.DataGridExcelReportHelper
 *  SA.SRFramework.WebEx.Utility.DataGridExcelReportHelperEx
 *  SA.SRFramework.WebEx.Utility.GridFetchResultHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.DataEntityTable;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelper;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelperEx;
import SA.SRFramework.WebEx.Utility.GridFetchResultHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIDataGridActionHelper
extends SRFExDataGridActionHelper {
    protected DataGrid gridView = null;
    private static final Log log = LogFactory.getLog(BIDataGridActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    Vector<String> biConditions = new Vector();
    protected String strQueryKey = "";

    protected boolean OnBeforeProcess() {
        return super.OnBeforeProcess();
    }

    protected boolean OnFetchAction() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        this.gridView = this.getGridView();
        if (this.gridView == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u8868\u683c\u89c6\u56fe\u5bf9\u8c61");
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.gridView) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(this.gridView);
            this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s] QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)"", (Object)(bUserDP ? "TRUE" : "FALSE"));
        } else if (this.OnGetNoDefQuery()) {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
            this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s]\u7981\u7528  QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
        } else {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel, this.gridView) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel, this.gridView);
            this.strQueryKey = StringHelper.Format((String)"GRIDVIEW[%1$s] QUERYMODEL[%2$s] USERDP[%3$s]", (Object)this.gridView.getDATAGRIDID(), (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s] \u8054\u5408 [%2$s]", (Object)strQueryModel, (Object)this.gridView.getDATAGRIDID()));
        }
        if (daQueryModelHelper == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
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
        String strCountSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetCountSQL(script.toString());
        strCountSQL = daQueryModelHelper.ReplaceURLParamMacro(strCountSQL, (ISRFExWebContext)this.getWebContext());
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
        if (!this.gridView.getNOSORT()) {
            strSortParam = this.getPage().getRequest().getParameter("sort");
            String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
            if (StringHelper.Length((String)strRealSortParam) > 0) {
                strSortParam = strRealSortParam;
            }
            strSortDirection = this.getPage().getRequest().getParameter("dir");
        }
        String strPagingSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(script.toString(), nStartRow, nPageSize, strSortParam, strSortDirection, "", "");
        strPagingSQL = daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext());
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.SelectAndFillFetchResult(strCountSQL, strPagingSQL, list, fetchResult);
        this.FillSummaryInfo(fetchResult, daQueryModelHelper);
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected String OnGetAdditionalQueryModel() {
        return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", "");
    }

    protected boolean OnGetNoDefQuery() {
        return this.getPage().getPageParam("PAGE.DATAGRID.NODEFQUERY", false);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        String strBICond2;
        IDEHelper majorDEHelper;
        String strTableAlias;
        Vector<DER1N> der1ns;
        String strScript = daQueryModelHelper.GetQueryModelScript();
        TreeMap<String, String> tableAliasMap = new TreeMap<String, String>();
        String strBICond = this.getWebContext().GetParamValue("SRFBICOND");
        if (!StringHelper.IsNullOrEmpty((String)strBICond)) {
            JSONArray ja = JSONArray.fromString((String)strBICond);
            int i = 0;
            while (i < ja.length()) {
                JSONObject jo = ja.getJSONObject(i);
                String strDEId = jo.getString("deid");
                String strDEFId = jo.getString("defid");
                String strCOND = jo.getString("cond");
                der1ns = this.getDEHelper().GetDER1Ns(false);
                for (DER1N der1n : der1ns) {
                    strTableAlias = "";
                    if (StringHelper.Compare((String)der1n.getMAJORDEID(), (String)strDEId, (boolean)true) != 0) continue;
                    majorDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                    if (tableAliasMap.containsKey(der1n.getDERID())) {
                        strTableAlias = (String)tableAliasMap.get(der1n.getDERID());
                    } else {
                        int nAlias = daQueryModelHelper.GetMajorDERAlias(der1n.getDERID());
                        if (nAlias == -1) {
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)" LEFT JOIN  %1$s bi%2$s on t1.%3$s=bi%2$s.%4$s ", (Object)majorDEHelper.GetMainTable(), (Object)i, (Object)der1n.getMAJORKEYDEFNAME(), (Object)majorDEHelper.GetKeyDEFHelper().getName());
                            strTableAlias = StringHelper.Format((String)"bi%1$s", (Object)i);
                            tableAliasMap.put(der1n.getDERID(), strTableAlias);
                        } else {
                            strTableAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                            tableAliasMap.put(der1n.getDERID(), strTableAlias);
                        }
                    }
                    IDEFHelper iDEFHelper = majorDEHelper.GetDEFHelper(strDEFId);
                    if (iDEFHelper == null) break;
                    if (DataTypeHelper.IsStringType((String)iDEFHelper.GetDataType())) {
                        this.biConditions.add(StringHelper.Format((String)"%1$s.%2$s='%3$s'", (Object)strTableAlias, (Object)iDEFHelper.getName(), (Object)strCOND));
                        break;
                    }
                    this.biConditions.add(StringHelper.Format((String)"%1$s.%2$s=%3$s", (Object)strTableAlias, (Object)iDEFHelper.getName(), (Object)strCOND));
                    break;
                }
                ++i;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strBICond2 = this.getWebContext().GetParamValue("SRFBICOND2")))) {
            Hashtable<String, String> condsMap = new Hashtable<String, String>();
            JSONArray ja = JSONArray.fromString((String)strBICond2);
            int i = 0;
            while (i < ja.length()) {
                JSONObject jo = ja.getJSONObject(i);
                String strDEId = jo.getString("srfdeid");
                der1ns = this.getDEHelper().GetDER1Ns(false);
                for (DER1N der1n : der1ns) {
                    strTableAlias = "";
                    if (StringHelper.Compare((String)der1n.getMAJORDEID(), (String)strDEId, (boolean)true) != 0) continue;
                    majorDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                    if (tableAliasMap.containsKey(der1n.getDERID())) {
                        strTableAlias = (String)tableAliasMap.get(der1n.getDERID());
                    } else {
                        int nAlias = daQueryModelHelper.GetMajorDERAlias(der1n.getDERID());
                        if (nAlias == -1) {
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)" LEFT JOIN  %1$s bi%2$s on t1.%3$s=bi%2$s.%4$s ", (Object)majorDEHelper.GetMainTable(), (Object)i, (Object)der1n.getMAJORKEYDEFNAME(), (Object)majorDEHelper.GetKeyDEFHelper().getName());
                            strTableAlias = StringHelper.Format((String)"bi%1$s", (Object)i);
                            tableAliasMap.put(der1n.getDERID(), strTableAlias);
                        } else {
                            strTableAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                            tableAliasMap.put(der1n.getDERID(), strTableAlias);
                        }
                    }
                    String strCurCondition = "";
                    Iterator it = jo.keys();
                    while (it.hasNext()) {
                        IDEFHelper iDEFHelper;
                        String strKey = (String)it.next();
                        if (StringHelper.Compare((String)strKey, (String)"srfdeid", (boolean)true) == 0 || (iDEFHelper = majorDEHelper.GetDEFHelper(strKey)) == null) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strCurCondition)) {
                            strCurCondition = String.valueOf(strCurCondition) + " AND ";
                        }
                        strCurCondition = DataTypeHelper.IsStringType((String)iDEFHelper.GetDataType()) ? String.valueOf(strCurCondition) + StringHelper.Format((String)"%1$s.%2$s='%3$s'", (Object)strTableAlias, (Object)iDEFHelper.getName(), (Object)jo.get(strKey)) : String.valueOf(strCurCondition) + StringHelper.Format((String)"%1$s.%2$s=%3$s", (Object)strTableAlias, (Object)iDEFHelper.getName(), (Object)jo.get(strKey));
                    }
                    if (condsMap.containsKey(strDEId)) {
                        String strOriCode = (String)condsMap.get(strDEId);
                        strOriCode = String.valueOf(strOriCode) + " OR (" + strCurCondition + ")";
                        condsMap.put(strDEId, strOriCode);
                        break;
                    }
                    condsMap.put(strDEId, "(" + strCurCondition + ")");
                    break;
                }
                ++i;
            }
            for (String strCode : condsMap.values()) {
                this.biConditions.add(strCode);
            }
        }
        return strScript;
    }

    protected boolean OnGetUserDP() {
        return false;
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.OnTestDataAction(this.getDEHelper(), dataEntity, strAction);
    }

    protected CallResult OnTestDataAction(IDEHelper iDEHelper, BaseDataEntity dataEntity, String strAction) {
        return iDEHelper.GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected void FillAdditionalDPCode(TreeMap<String, String> codeSets) {
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillSearchFormCondition(userConditions, daQueryModelHelper);
        this.FillURLCondition(userConditions, daQueryModelHelper);
        for (String strCondition : this.biConditions) {
            userConditions.add(strCondition);
        }
    }

    protected void FillPickupModeCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected boolean FillURLCondition(BaseDataEntity userConditions) {
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
        String strDERID = this.getWebContext().getSRFDERID();
        if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
            String strCondition;
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
            if (!StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, (IDEFHelper)pickupDEFHelper, "", "=", strValue)))) {
                userConditions.add(strCondition);
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
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                String strCondition;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                String strValue = this.getPage().getRequest().getParameter(strFormItemId.toLowerCase());
                if (strValue == null && StringHelper.IsNullOrEmpty((String)(strValue = this.getWebContext().GetParamValue(strFormItemId.toUpperCase()))) && (filterMap == null || !filterMap.containsKey(strFormItemId.toUpperCase()) || StringHelper.IsNullOrEmpty((String)(strValue = this.getWebContext().GetParamValue((String)filterMap.get(strFormItemId.toUpperCase()))))) || StringHelper.IsNullOrEmpty((String)(strValue = strValue.trim())) || StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, searchItemConfig, strValue = strValue.replace("\\'", "'"))))) continue;
                userConditions.add(strCondition);
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
        DGModelGroupLogicConfig realGroupLogicConfig = new DGModelGroupLogicConfig();
        realGroupLogicConfig.InitLogicsConfig();
        realGroupLogicConfig.setCondition("OR");
        TreeMap<String, DGModelGroupLogicConfig> groups = new TreeMap<String, DGModelGroupLogicConfig>();
        for (DGModelBaseLogicConfig dgModelBaseLogicConfig : dgModelGroupLogicConfig.getLogicsConfig()) {
            String strGroupNo = dgModelBaseLogicConfig.GetExtValue("GROUPNO", "");
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
        CallResult callResult = daQueryModelHelper.GetGroupCondition(realGroupLogicConfig);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u81ea\u5b9a\u4e49\u641c\u7d22\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        userConditions.add(callResult.getUserObject().toString());
    }

    protected void SelectAndFillFetchResult(String strCountSQL, String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult) {
        try {
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
            long nCountTime = new Date().getTime();
            SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strCountSQL, list);
            if (selectResult == null) {
                info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return;
            }
            nCountTime = new Date().getTime() - nCountTime;
            if (selectResult.getRetCode() != 0) {
                info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult.getErrorInfo());
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.From((DBResult)selectResult);
                return;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
                fetchResult.setRetCode(1);
                fetchResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                return;
            }
            DataSet ds = selectResult.getSelectData();
            String strTotalRow = ds.getTable(0).GetRow(0).Get("TOTALROW").toString();
            fetchResult.setTotalRow(Integer.parseInt(strTotalRow));
            long nSelectTime = new Date().getTime();
            selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strPagingSQL, list);
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
            ds = selectResult.getSelectData();
            GridFetchResultHelper.Fill((SRFExWebContext)this.getWebContext(), (Vector)fetchResult.getItems(), (DataTable)ds.getTable(0), (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID(), (boolean)false, (boolean)this.getDataGrid().isEnableItemPrivilege());
            this.FillSummaryInfo(fetchResult, ds.getTable(0));
            fetchResult.setRetCode(0);
            if (StringHelper.Compare((String)this.getDataGrid().getDataGridConfig().getResponseType(), (String)"JSONARRAY", (boolean)true) == 0) {
                BaseDADataGridActionHelper.ConverItemsToArray((SRFExGridFetchResult)fetchResult, (ISRFDAWebContext)this.getWebContext(), (DataGridConfig)this.getDataGrid().getDataGridConfig(), (boolean)false);
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
                BaseDADataGridActionHelper.ConverItemsToArray((SRFExGridFetchResult)fetchResult, (ISRFDAWebContext)this.getWebContext(), (DataGridConfig)this.getDataGrid().getDataGridConfig(), (boolean)false);
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
        BIDataGridActionHelper.GenExcelFile(this.getPage(), this.getDataGrid(), selectResult, strTempFileName, strExportType);
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

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORT", (boolean)true) == 0) {
            this.OnExport();
            return true;
        }
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
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(gridView) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(gridView);
        } else {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel, gridView) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel, gridView);
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s] \u8054\u5408 [%2$s]", (Object)strQueryModel, (Object)gridView.getDATAGRIDID()));
        }
        if (daQueryModelHelper == null) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
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
        String strSortParam = this.getPage().getRequest().getParameter("sort");
        String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            strSortParam = strRealSortParam;
        }
        String strSortDirection = this.getPage().getRequest().getParameter("dir");
        String strPagingSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(script.toString(), nStartRow, nPageSize, strSortParam, strSortDirection, "", "");
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        String strExportType = this.GetExportType();
        CallResult callResult = this.SelectAndExport(strPagingSQL, list, strExportType);
        if (callResult.getRetCode() != 0) {
            callResult.From((CallResult)exportResult);
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String strDownloadURL = "";
        strDownloadURL = StringHelper.Format((String)"'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", (Object)callResult.getUserObject(), (Object)strExportType);
        String strScript = StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
    }

    protected boolean OnGetDGSaveAtNew() {
        return this.getPage().getPageParam("PAGE.DGACTIONHELPER.SAVEATNEW", false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void FillMajorDataEntity(BaseDataEntity dataEntity) {
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
        String strKeyValue = this.getWebContext().GetPostValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            return;
        }
        Object objKeyValue = pickupDEFHelper.GetRealDEFHelper().GetDEFValue(strKeyValue);
        if (objKeyValue == null) {
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
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)callResult.getErrorInfo()));
            return;
        }
        dataEntity.SetParamValue(pickupDEFHelper.GetPickupTextDEFHelper().getName(), (Object)realDataEntity.GetParamStringValue(pickupDEFHelper.GetPickupTextDEFHelper().GetRealDEFHelper().getName(), ""));
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
        Object obj = this.getPage().getPageParam("GRIDVIEW");
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
        return "";
    }

    protected IDEHelper getDEHelper() {
        return this.getPage().getDEHelper();
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
}
