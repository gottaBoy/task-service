/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.GSR2
 *  SA.SRFDA.Ctrl.Data.GSR2Dimension
 *  SA.SRFDA.Ctrl.Data.GSR2SumTable
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
 *  SA.SRFDA.Web.Utility.DEDataImportTemplateHelper
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
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GSR2Dimension;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
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
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GSR2DataGridActionHelper
extends SRFExDataGridActionHelper {
    private static final Log log = LogFactory.getLog(GSR2DataGridActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected String strQueryKey = "";
    protected GSR2 gsr2 = null;

    protected boolean OnBeforeProcess() {
        return super.OnBeforeProcess();
    }

    protected boolean OnFetchAction() {
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        this.gsr2 = this.getGSR2();
        if (this.gsr2 == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.gsr2.getQUERYMODELID();
        boolean bUserDP = this.OnGetUserDP();
        daQueryModelHelper = !StringHelper.IsNullOrEmpty((String)strQueryModel) ? (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel)) : (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper(), "", false) : this.getPage().getDAModelStorage().getDAQueryModelHelper(this.getDEHelper()));
        this.strQueryKey = StringHelper.Format((String)"QUERYMODEL[%1$s] USERDP[%2$s]", (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
        log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
        if (daQueryModelHelper == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        String strQueryScript = this.GetDAModelQueryScript(daQueryModelHelper);
        Vector<String> userConditions = new Vector<String>();
        String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
        String strTD = this.getWebContext().GetPostValue("srftd");
        IDEHelper joinDEHelper = null;
        GSR2Dimension groupDimension = null;
        for (GSR2Dimension dimension : this.gsr2.getDimensions()) {
            if (StringHelper.Compare((String)dimension.getGSR2DIMENSIONID(), (String)strGroupField, (boolean)true) != 0) continue;
            groupDimension = dimension;
            break;
        }
        if (groupDimension == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7ef4\u5ea6[%1$s]", (Object)strGroupField));
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        joinDEHelper = this.getPage().getDAModelStorage().FindDEHelper(groupDimension.getJOINDEID());
        if (joinDEHelper == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)groupDimension.getJOINDEID()));
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        String strDTTableName = "";
        for (GSR2SumTable sumTable : this.gsr2.getSumTables()) {
            if (StringHelper.Compare((String)sumTable.getGSR2SUMTABLEID(), (String)strTD, (boolean)true) != 0) continue;
            strDTTableName = sumTable.getGSR2SUMTABLENAME();
            break;
        }
        IDEFHelper groupDEFHelper = this.getDEHelper().GetDEFHelper(this.gsr2.getGROUPDEFID());
        int nPos = strQueryScript.indexOf("SELECT");
        if (nPos != -1) {
            strQueryScript = "SELECT s1." + joinDEHelper.GetMajorDEFHelper().GetDTColumn().GetColumnName() + " AS SRFJOINNAME, " + strQueryScript.substring(nPos + 6);
            strQueryScript = String.valueOf(strQueryScript) + StringHelper.Format((String)"\nLEFT JOIN %1$s s1 ON t1.%2$s = s1.%3$s \n", (Object)joinDEHelper.GetMainTable(), (Object)groupDEFHelper.GetDTColumn().GetColumnName(), (Object)joinDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName());
            if (!StringHelper.IsNullOrEmpty((String)groupDimension.getEXTCOND())) {
                userConditions.add(groupDimension.getEXTCOND());
            }
        } else {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u67e5\u8be2\u8bed\u53e5\u4e2d\u5b9a\u4f4d\u7b2c\u4e00\u4e2a[SELECT]"));
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        strQueryScript = strQueryScript.replaceAll(this.getDEHelper().GetMainTable(), strDTTableName);
        script.Append(strQueryScript);
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
        strQueryScript = script.toString();
        String strSortParam = "";
        String strSortDirection = "";
        strSortParam = this.getPage().getRequest().getParameter("sort");
        String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            strSortParam = strRealSortParam;
        }
        strSortDirection = this.getPage().getRequest().getParameter("dir");
        String strTopN = this.getPage().getRequest().getParameter("srftopn");
        int nTopCount = 0;
        if (StringHelper.IsNullOrEmpty((String)strTopN)) {
            nTopCount = this.gsr2.getTopNCount(10);
        } else {
            nTopCount = Integer.parseInt(strTopN);
            if (nTopCount <= 0) {
                nTopCount = this.gsr2.getTopNCount(10);
            }
        }
        String strPagingSQL = this.GetPagingSQL(daQueryModelHelper, strQueryScript, 0, nTopCount, strSortParam, strSortDirection, "", "");
        strPagingSQL = daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext());
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.SelectAndFillFetchResult(strPagingSQL, list, fetchResult);
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected String OnGetAdditionalQueryModel() {
        return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", "");
    }

    protected boolean OnGetNoDefQuery() {
        return this.getPage().getPageParam("PAGE.DATAGRID.NODEFQUERY", false);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.USERDP", true);
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(dataEntity, "CREATE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected String OnGetDGUpdateMode() {
        return this.getPage().getPageParam("PAGE.DATAGRID.UPDATEMODE", "DEFAULT");
    }

    protected String OnGetDGInsertMode() {
        return this.getPage().getPageParam("PAGE.DATAGRID.INSERTMODE", "DEFAULT");
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        CallResult callResult;
        String strAction = this.OnGetDGUpdateMode();
        if (StringHelper.IsNullOrEmpty((String)strAction)) {
            strAction = "DEFAULT";
        }
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)"DEFAULT", (boolean)true) == 0) {
            strAction = "UPDATE";
        }
        if ((callResult = this.OnTestDataAction(dataEntity, strAction)).getRetCode() != 0) {
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

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillSearchFormCondition(userConditions, daQueryModelHelper);
        this.FillURLCondition(userConditions, daQueryModelHelper);
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

    protected void SelectAndFillFetchResult(String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult) {
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
            long nSelectTime = new Date().getTime();
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
            GridFetchResultHelper.Fill((SRFExWebContext)this.getWebContext(), (Vector)fetchResult.getItems(), (DataTable)ds.getTable(0), (DataGridConfig)this.getDataGrid().getDataGridConfig(), (String)this.getDataGrid().getUniqueID(), (boolean)false, (boolean)this.getDataGrid().isEnableItemPrivilege());
            this.FillSummaryInfo(fetchResult, ds.getTable(0));
            fetchResult.setRetCode(0);
            info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u8017\u65f6[%1$sms]\r\n", (Object)nSelectTime);
            LoggerEx.info((Log)log, (Object)info.toString(), null, (Object)this.getWebContext(), (Object)this.getDEHelper().getId());
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
        GSR2DataGridActionHelper.GenExcelFile(this.getPage(), this.getDataGrid(), selectResult, strTempFileName, strExportType);
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

    protected CallResult OnRemoveActionBeforeRemove(BaseDataEntity dataEntity) {
        return this.OnRemoveActionBeforeRemove(this.getDEDataCtrl(), dataEntity);
    }

    protected CallResult OnRemoveActionBeforeRemove(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(iDEDataCtrl.GetDEHelper(), dataEntity, "DELETE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return iDEDataCtrl.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected boolean OnExportImportTemplate() {
        CallResult callResult;
        SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
        String strTempFileName = Helper.GenGuid();
        String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId());
        File dir = new File(strDir);
        dir.mkdirs();
        String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)"xls");
        try {
            callResult = DEDataImportTemplateHelper.Output((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (IDEHelper)this.getDEHelper(), (String)strFullFileName);
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
        String strDownloadURL = "";
        strDownloadURL = StringHelper.Format((String)"'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", (Object)strTempFileName, (Object)"");
        String strScript = StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
    }

    protected String OnGetDGMode() {
        return this.getPage().getPageParam("PAGE.DGMODE", "");
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
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

    protected GSR2 getGSR2() {
        if (this.gsr2 != null) {
            return this.gsr2;
        }
        Object obj = this.getPage().getPageParam("GSR2");
        if (obj == null) {
            return null;
        }
        if (obj instanceof GSR2) {
            this.gsr2 = (GSR2)obj;
        }
        return this.gsr2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public CallResult AppendTimeGroupSQL(BaseDAQueryModelHelper daQueryModelHelper, String strTimeGroupFieldId, String strFromTimeParam, String strToTimeParam, boolean bAllowTimeParamEmpty, String strQueryScript, Vector<String> userConditions, String strTDType) {
        String strCond;
        String strFromTime;
        CallResult callResult = new CallResult();
        IDEFHelper timeGroupDEF = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper(strTimeGroupFieldId);
        if (timeGroupDEF == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u65f6\u95f4\u5206\u7ec4\u5c5e\u6027[%1$s]", (Object)strTimeGroupFieldId));
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strFromTimeParam)) {
            strFromTimeParam = StringHelper.Format((String)"n_%1$s_gtandeq", (Object)timeGroupDEF.GetDTColumn().GetColumnName().toLowerCase());
        }
        if (StringHelper.IsNullOrEmpty((String)strToTimeParam)) {
            strToTimeParam = StringHelper.Format((String)"n_%1$s_lt", (Object)timeGroupDEF.GetDTColumn().GetColumnName().toLowerCase());
        }
        if (StringHelper.IsNullOrEmpty((String)(strFromTime = this.getWebContext().GetPostValue(strFromTimeParam)))) {
            strFromTime = this.getWebContext().GetParamValue(strFromTimeParam);
        }
        if (!bAllowTimeParamEmpty && StringHelper.IsNullOrEmpty((String)strFromTime)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a[%1$s]\u7684\u8d77\u59cb\u65f6\u95f4", (Object)timeGroupDEF.getLogicName()));
            return callResult;
        }
        String strToTime = this.getWebContext().GetPostValue(strToTimeParam);
        if (StringHelper.IsNullOrEmpty((String)strToTime)) {
            strToTime = this.getWebContext().GetParamValue(strToTimeParam);
        }
        if (!bAllowTimeParamEmpty && StringHelper.IsNullOrEmpty((String)strToTime)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a[%1$s]\u7684\u7ec8\u6b62\u65f6\u95f4", (Object)timeGroupDEF.getLogicName()));
            return callResult;
        }
        int nPos = strQueryScript.indexOf("SELECT");
        if (nPos == -1) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u67e5\u8be2\u8bed\u53e5\u4e2d\u5b9a\u4f4d\u7b2c\u4e00\u4e2a[SELECT]"));
            return callResult;
        }
        strQueryScript = "SELECT s1.TIMEDIMENSIONID AS srftdid,s1.TIMEDIMENSIONNAME AS srftdname,s1.BEGINTIME AS srftdfrom,s1.ENDTIME AS srftdto, " + strQueryScript.substring(nPos + 6);
        strQueryScript = String.valueOf(strQueryScript) + StringHelper.Format((String)"\nLEFT OUTER JOIN t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n", (Object)daQueryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject());
        userConditions.add(StringHelper.Format((String)"s1.TIMEDIMENSIONID IS NOT NULL "));
        if (!StringHelper.IsNullOrEmpty((String)strFromTime)) {
            strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.BEGINTIME", 5, ">=", strFromTime);
            if (StringHelper.IsNullOrEmpty((String)strCond)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bbe\u7f6e[%1$s]\u7684\u8d77\u59cb\u65f6\u95f4[%2$s]", (Object)timeGroupDEF.getLogicName(), (Object)strFromTime));
                return callResult;
            }
            userConditions.add(strCond);
        }
        if (!StringHelper.IsNullOrEmpty((String)strToTime)) {
            strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.ENDTIME", 5, "<=", strToTime);
            if (StringHelper.IsNullOrEmpty((String)strCond)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bbe\u7f6e[%1$s]\u7684\u7ec8\u6b62\u65f6\u95f4[%2$s]", (Object)timeGroupDEF.getLogicName(), (Object)strToTime));
                return callResult;
            }
            userConditions.add(strCond);
        }
        userConditions.add(StringHelper.Format((String)"s1.TDTYPE='%1$s'", (Object)strTDType));
        callResult.setUserObject((Object)strQueryScript);
        return callResult;
    }

    protected String GetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        boolean bPaging = this.getDataGrid().getDataGridConfig().getPaging();
        if (!bPaging) {
            nStartRow = 0;
            nPageSize = this.getDataGrid().getDataGridConfig().getDataGridPagingConfig().getPageSize();
        }
        return String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(strScript, nStartRow, nPageSize, strSortParam, strSortDirection, strMinor, strMinorDirection);
    }
}

