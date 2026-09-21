/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig
 *  SA.SRFDA.Model.DGModelBaseLogicConfig
 *  SA.SRFDA.Model.DGModelGroupLogicConfig
 *  SA.SRFDA.Model.DGModelSingleLogicConfig
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
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
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.Ctrl.MBFetchResultHelper;
import SA.SRFDA.Mobile.Ctrl.SRFDAMBFetchResult;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig;
import SA.SRFDA.Mobile.Web.BaseMBPanelPage;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelSingleLogicConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebContext;
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
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SRFDAMBUIPartActionHelper {
    private static final Log log = LogFactory.getLog(SRFDAMBUIPartActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected boolean bEnableItemPrivilege = false;
    protected BaseMBPanelPage page = null;
    protected String strCtrlId = "";
    private IDEHelper iDEHelper = null;
    private MBUIPartConfig mbUIPartConfig = null;
    protected int nStartRow = 0;
    protected int nPageSize = 25;

    protected void InitHelper(BaseMBPanelPage page, IDEHelper iDEHelper, MBUIPartConfig mbUIPartConfig, String strCtrlId) throws Exception {
        this.page = page;
        this.strCtrlId = strCtrlId;
        this.iDEHelper = iDEHelper;
        this.mbUIPartConfig = mbUIPartConfig;
    }

    protected SRFDAWebContext getWebContext() {
        return this.page.getWebContext();
    }

    protected BaseMBPanelPage getPage() {
        return this.page;
    }

    protected IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    protected SRFDAMBFetchResult DoFetchAction() throws Exception {
        SRFDAMBFetchResult fetchResult = new SRFDAMBFetchResult();
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper()) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(this.getDEHelper());
        } else {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
        }
        if (daQueryModelHelper == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)fetchResult.getErrorInfo());
            return fetchResult;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.OnGetDAModelQueryScript(daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.OnFillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
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
        String strTemp = this.getPage().getRequest().getParameter("start");
        if (StringHelper.Length((String)strTemp) != 0) {
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
        strSortParam = this.getPage().getRequest().getParameter("sort");
        String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
        if (StringHelper.Length((String)strRealSortParam) > 0) {
            strSortParam = strRealSortParam;
        }
        strSortDirection = this.getPage().getRequest().getParameter("dir");
        String strPagingSQL = this.OnGetPagingSQL(daQueryModelHelper, script.toString(), this.nStartRow, this.nPageSize, strSortParam, strSortDirection, "", "");
        strPagingSQL = daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext());
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.OnSelectAndFillFetchResult(daQueryModelHelper, strCountSQL, strPagingSQL, list, fetchResult);
        this.OnFillSummaryInfo(fetchResult, daQueryModelHelper);
        return fetchResult;
    }

    protected boolean OnGetUserDP() {
        return StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) != 0;
    }

    protected String OnGetQueryModel() {
        return "";
    }

    protected String OnGetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected void OnFillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.OnFillSearchFormCondition(userConditions, daQueryModelHelper);
        this.OnFillURLCondition(userConditions, daQueryModelHelper);
    }

    protected boolean OnFillURLCondition(BaseDataEntity userConditions) {
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

    protected void OnFillURLCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
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

    protected void OnFillSearchFormCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.OnFillSearchFormCSMCondition(userConditions, daQueryModelHelper);
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
                if (StringHelper.IsNullOrEmpty((String)strValue) || StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, searchItemConfig, strValue = strValue.replace("\\'", "'"))))) continue;
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

    protected void OnFillSearchFormCSMCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
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
                realGroupLogicConfig.getLogicsConfig().add((Object)curGroupLogicConfig);
            } else {
                curGroupLogicConfig = (DGModelGroupLogicConfig)groups.get(strGroupNo.toUpperCase());
            }
            curGroupLogicConfig.getLogicsConfig().add((Object)dgModelBaseLogicConfig);
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

    protected void OnFillSummaryInfo(SRFDAMBFetchResult fetchResult, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected void OnFillSummaryInfo(SRFDAMBFetchResult fetchResult, DataTable dataTable) {
    }

    protected void OnSelectAndFillFetchResult(BaseDAQueryModelHelper daQueryModelHelper, String strCountSQL, String strPagingSQL, Vector<CallParam> list, SRFDAMBFetchResult fetchResult) {
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
                fetchResult.setTotalRow(this.nStartRow + ds.getTable(0).GetRowCount());
            } else {
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
                    info.Append("\u8bb0\u5f55\u6570\u67e5\u8be2\u5931\u8d25\uff0c%1$s\r\n", (Object)selectResult.getErrorInfo());
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
                String strTotalRow = dsCount.getTable(0).GetRow(0).Get("TOTALROW").toString();
                fetchResult.setTotalRow(Integer.parseInt(strTotalRow));
            }
            MBFetchResultHelper.Fill(this.getWebContext(), fetchResult.getItems(), ds.getTable(0), this.mbUIPartConfig, false, this.OnGetEnableItemPrivilege());
            this.OnFillSummaryInfo(fetchResult, ds.getTable(0));
            fetchResult.setRetCode(0);
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

    protected boolean OnGetLogQueryPerformance() {
        return this.getDEHelper().GetProperty("LOGPODBQUERY", true);
    }

    public void LogQueryPerformance(String strSQL, int nProcessTime) {
        if (!this.OnGetLogQueryPerformance()) {
            return;
        }
        ISRFDAPOLogger poLogger = this.getWebContext().getGlobalHelper().getPOLoggerEx();
        if (poLogger == null) {
            return;
        }
        poLogger.LogDBQuery(this.getDEHelper().getId(), "QUERYKEY", strSQL, this.getWebContext().getCurUserId(), nProcessTime);
    }

    protected String OnGetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        return String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(strScript, nStartRow, nPageSize, strSortParam, strSortDirection, strMinor, strMinorDirection);
    }

    protected boolean OnGetEnableItemPrivilege() {
        return true;
    }
}

