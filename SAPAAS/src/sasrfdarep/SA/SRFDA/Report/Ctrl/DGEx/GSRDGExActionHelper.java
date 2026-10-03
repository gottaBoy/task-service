/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DGEx.BaseDADGExActionHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.GSRGroupColumn
 *  SA.SRFDA.Ctrl.Data.GSRMeasure
 *  SA.SRFDA.Ctrl.Data.GroupStatisticsRep
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.DGModelBaseLogicConfig
 *  SA.SRFDA.Model.DGModelGroupLogicConfig
 *  SA.SRFDA.Model.QueryGroupItemConfig
 *  SA.SRFDA.Model.QueryGroupModelConfig
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
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelper
 *  SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.DGEx.SRFExDGExActionHelper
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Ctrl.DGEx;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DGEx.BaseDADGExActionHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFDA.Model.QueryGroupModelConfig;
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
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelper;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.SRFExDGExActionHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GSRDGExActionHelper
extends SRFExDGExActionHelper {
    private static final Log log = LogFactory.getLog(BaseDADGExActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected GroupStatisticsRep groupStatisticsRep = null;
    protected String strQueryKey = "";

    protected boolean OnBeforeProcess() {
        return super.OnBeforeProcess();
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORT", (boolean)true) == 0) {
            this.OnExport();
            return true;
        }
        return true;
    }

    protected boolean OnFetchAction() {
        QueryGroupItemConfig queryGroupItemConfig;
        SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
        this.groupStatisticsRep = this.getGroupStatisticsRep();
        if (this.groupStatisticsRep == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
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
        String strSortParam = this.getPage().getRequest().getParameter("sort");
        String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            strSortParam = strRealSortParam;
        }
        String strSortDirection = this.getPage().getRequest().getParameter("dir");
        QueryGroupModelConfig queryGroupModelConfig = new QueryGroupModelConfig();
        String strTopN = this.getPage().getRequest().getParameter("srftopn");
        if (StringHelper.IsNullOrEmpty((String)strTopN)) {
            queryGroupModelConfig.setTopCount(100);
        } else {
            int nInt = Integer.parseInt(strTopN);
            if (nInt <= 0) {
                nInt = 100;
            }
            queryGroupModelConfig.setTopCount(nInt);
        }
        String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
        if (!StringHelper.IsNullOrEmpty((String)strGroupField)) {
            for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                if (StringHelper.Compare((String)groupColumn.getDEFIELDNAME(), (String)strGroupField, (boolean)true) != 0) continue;
                queryGroupItemConfig = new QueryGroupItemConfig();
                queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                queryGroupItemConfig.setDEFields(groupColumn.getDEFIELDNAME());
                queryGroupItemConfig.setIsGroup(true);
                if (StringHelper.Compare((String)strSortParam, (String)groupColumn.getDEFIELDNAME(), (boolean)true) == 0) {
                    queryGroupItemConfig.setOrder(0);
                    queryGroupItemConfig.setOrderDirection(strSortDirection);
                }
                queryGroupModelConfig.add(queryGroupItemConfig);
                break;
            }
        }
        for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
            queryGroupItemConfig = new QueryGroupItemConfig();
            queryGroupItemConfig.setAlias(gsrMeasure.getEXPALIAS());
            queryGroupItemConfig.setFormular(gsrMeasure.getEXPRESSION());
            queryGroupItemConfig.setIsGroup(false);
            if (StringHelper.Compare((String)strSortParam, (String)gsrMeasure.getEXPALIAS(), (boolean)true) == 0) {
                queryGroupItemConfig.setOrder(0);
                queryGroupItemConfig.setOrderDirection(strSortDirection);
            }
            queryGroupModelConfig.add(queryGroupItemConfig);
        }
        Vector<CallParam> params = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), "");
        String strSQL = daQueryModelHelper.GetGroupSQL(script.toString(), queryGroupModelConfig, params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), "", null);
        daQueryModelHelper.FillCallParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), "");
        strSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + strSQL;
        strSQL = daQueryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.getWebContext());
        this.SelectAndFillFetchResult(strSQL, params, fetchResult, strSortParam, strSortDirection);
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected String OnGetAdditionalQueryModel() {
        return this.groupStatisticsRep.getQUERYMODELID();
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

    protected void SelectAndFillFetchResult(String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult, String strSortParam, String strSortDirection) {
        try {
            StringBuilderEx paramInfo = new StringBuilderEx();
            StringBuilderEx info = new StringBuilderEx();
            info.Append("GROUP SQL\r\n%1$s\r\n", (Object)strPagingSQL);
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
                info.Append("\u6570\u636e\u67e5\u8be2\u5931\u8d25\r\n");
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
            DataTable dt = ds.getTable(0);
            int nRowCount = dt.GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                JSONObject objJSON = new JSONObject();
                DataRow dr = dt.GetRow(i);
                fetchResult.getItems().add(objJSON);
                ++i;
            }
            StringBuilderEx sb = new StringBuilderEx();
            DGExFetchResultHelperContext context = new DGExFetchResultHelperContext();
            context.setDGExConfig(this.getDGEx().getDGExConfig());
            context.setDGExUniqueId(this.getDGEx().getUniqueID());
            context.setWebContext((ISRFExWebContext)this.getWebContext());
            context.setSortDir(strSortDirection);
            context.setSortField(strSortParam);
            DGExFetchResultHelper.Output((DGExFetchResultHelperContext)context, (StringBuilderEx)sb, (DataTable)selectResult.getMainTable());
            fetchResult.setSummaryInfo(sb.toString());
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

    protected static CallResult SelectAndExport(SRFDAPage page, SRFExDGEx dgEx, String strPagingSQL, Vector<CallParam> list) {
        CallResult callResult = new CallResult();
        try {
            StringBuilderEx paramInfo = new StringBuilderEx();
            StringBuilderEx info = new StringBuilderEx();
            info.Append("GROUP SQL\r\n%1$s\r\n", (Object)strPagingSQL);
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
            SelectResult selectResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)page.getWebContext().getGlobalHelper(), (String)page.getDEHelper().GetDBStorage(), (String)strPagingSQL, list);
            if (selectResult == null) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)page.getWebContext(), (Object)page.getDEHelper().getId());
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            nSelectTime = new Date().getTime() - nSelectTime;
            if (selectResult.getRetCode() != 0) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult.getErrorInfo());
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)page.getWebContext(), (Object)page.getDEHelper().getId());
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                info.Append("\u5206\u9875\u6570\u636e\u67e5\u8be2\u5931\u8d25\uff0c\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\r\n");
                LoggerEx.error((Log)log, (Object)info.toString(), null, (Object)page.getWebContext(), (Object)page.getDEHelper().getId());
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
                return callResult;
            }
            String strTempFileName = Helper.GenGuid();
            String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)page.getWebContext().getGlobalHelper().GetTempPath(), (Object)page.getWebContext().getSessionId());
            File dir = new File(strDir);
            dir.mkdirs();
            String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)page.getWebContext().getGlobalHelper().GetTempPath(), (Object)page.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)"xls");
            FileWriter fw = new FileWriter(new File(strFullFileName));
            fw.flush();
            StringBuilderEx sb = new StringBuilderEx((Writer)fw);
            sb.Append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
            sb.Append("<html>\r\n");
            sb.Append("<head>\r\n");
            sb.Append("<title>\u590d\u5408\u6570\u636e\u62a5\u8868</title>\r\n");
            sb.Append("<meta http-equiv=content-type content=\"text/html; charset=GBK\">\r\n");
            sb.Append("</head>\r\n");
            sb.Append("<body>\r\n");
            DGExFetchResultHelperContext context = new DGExFetchResultHelperContext();
            context.setDGExConfig(dgEx.getDGExConfig());
            context.setDGExUniqueId(dgEx.getUniqueID());
            context.setWebContext((ISRFExWebContext)page.getWebContext());
            context.setExportMode(true);
            DGExFetchResultHelper.Output((DGExFetchResultHelperContext)context, (StringBuilderEx)sb, (DataTable)selectResult.getMainTable());
            DGExFetchResultHelper.Output((DGExFetchResultHelperContext)context, (StringBuilderEx)sb, (DataTable)selectResult.getMainTable());
            sb.Append("</body>\r\n");
            sb.Append("</html>\r\n");
            fw.close();
            callResult.setUserObject((Object)strTempFileName);
            callResult.setRetCode(0);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected boolean OnExport() {
        SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
        this.groupStatisticsRep = this.getGroupStatisticsRep();
        if (this.groupStatisticsRep == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            exportResult.setRetCode(1);
            exportResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u5bf9\u8c61");
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        daQueryModelHelper = !StringHelper.IsNullOrEmpty((String)strQueryModel) ? (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel)) : (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper(), "") : this.getPage().getDAModelStorage().getDAQueryModelHelper(this.getDEHelper()));
        this.strQueryKey = StringHelper.Format((String)" QUERYMODEL[%1$s] USERDP[%2$s]", (Object)strQueryModel, (Object)(bUserDP ? "TRUE" : "FALSE"));
        log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
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
        CallResult callResult = GSRDGExActionHelper.SelectAndExport(this.getPage(), this.getDGEx(), strPagingSQL, list);
        if (callResult.getRetCode() != 0) {
            callResult.From((CallResult)exportResult);
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String strDownloadURL = "";
        strDownloadURL = StringHelper.Format((String)"'../srfpage/exportexcel.jsp?FILEID=%1$s'", (Object)callResult.getUserObject());
        String strScript = StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
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

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected GroupStatisticsRep getGroupStatisticsRep() {
        if (this.groupStatisticsRep != null) {
            return this.groupStatisticsRep;
        }
        Object obj = this.getPage().getPageParam("GROUPSTATISTICSREP");
        if (obj == null) {
            return null;
        }
        if (obj instanceof GroupStatisticsRep) {
            this.groupStatisticsRep = (GroupStatisticsRep)obj;
        }
        return this.groupStatisticsRep;
    }

    protected IDEDataCtrl getDEDataCtrl() {
        return this.getPage().GetDEDataCtrl();
    }

    protected IDEHelper getDEHelper() {
        return this.getPage().getDEHelper();
    }
}

