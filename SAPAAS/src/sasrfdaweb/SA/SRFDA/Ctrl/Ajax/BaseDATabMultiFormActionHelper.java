/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.TempData
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.Utility.ISRFDAPOLogger
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Ajax;

import SA.SRFDA.Ctrl.Ajax.BaseDAAjaxActionHelper;
import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDATabMultiFormActionHelper
extends BaseDAAjaxActionHelper {
    private static final Log log = LogFactory.getLog(BaseDATabMultiFormActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected boolean bTempDataMode = false;
    protected String strQueryKey = "";

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        this.bTempDataMode = SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false);
        return true;
    }

    protected boolean OnFetchAction() {
        SRFExAjaxListResult fetchResult = new SRFExAjaxListResult();
        if (this.bTempDataMode) {
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        daQueryModelHelper = StringHelper.IsNullOrEmpty((String)strQueryModel) ? (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper()) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(this.getDEHelper())) : (bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel));
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
        int nStartRow = 0;
        int nPageSize = 100;
        String strSortParam = this.GetOrderField();
        String strSortDirection = this.GetOrderDir();
        String strPagingSQL = this.GetPagingSQL(daQueryModelHelper, script.toString(), nStartRow, nPageSize, strSortParam, strSortDirection, "", "");
        strPagingSQL = daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext());
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.SelectAndFillFetchResult(strPagingSQL, list, fetchResult);
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected String GetOrderField() {
        return this.getPage().getPageParam("PAGE.TMF.SORTFIELD", "");
    }

    protected String GetOrderDir() {
        return this.getPage().getPageParam("PAGE.TMF.SORTDIR", "");
    }

    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected String OnGetAdditionalQueryModel() {
        return this.getPage().getPageParam("PAGE.TMF.QUERYMODEL", "");
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String GetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        return String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(strScript, nStartRow, nPageSize, strSortParam, strSortDirection, strMinor, strMinorDirection);
    }

    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        return this.getPage().getPageParam("PAGE.TMF.USERDP", true);
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
        this.FillURLCondition(userConditions, daQueryModelHelper);
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

    protected void SelectAndFillFetchResult(String strPagingSQL, Vector<CallParam> list, SRFExAjaxListResult fetchResult) {
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
            DataTable dt = ds.getTable(0);
            String strKeyField = this.getDEHelper().GetKeyDEFHelper().getName();
            String strMajorField = this.getDEHelper().GetMajorDEFHelper().getName();
            int i = 0;
            while (i < dt.GetRowCount()) {
                try {
                    DataRow dr = dt.GetRow(i);
                    String strKey = dr.Get(strKeyField).toString();
                    String strText = dr.Get(strMajorField).toString();
                    JSONObject jo = new JSONObject();
                    jo.put("key", (Object)strKey);
                    jo.put("text", (Object)strText);
                    fetchResult.getItems().add(jo);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                ++i;
            }
            fetchResult.setRetCode(0);
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
    }

    protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, DataTable dataTable) {
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
            Vector derIndexList = null;
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
        CallResult callResult = this.OnTestDataAction(iDEDataCtrl.GetDEHelper(), dataEntity, "DELETE");
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return iDEDataCtrl.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    @Override
    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    @Override
    protected SRFDAWebContext getWebContext() {
        return super.getWebContext();
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

    protected boolean OnProcess(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"list", (boolean)true) == 0) {
            return this.OnFetchAction();
        }
        if (StringHelper.Compare((String)strAction, (String)"remove", (boolean)true) == 0) {
            return this.OnRemoveAction();
        }
        return super.OnProcess(strAction);
    }

    protected boolean isTempDataMode() {
        return this.bTempDataMode;
    }

    protected String OnGetAppendParams() {
        return this.getPage().getPageParam("PAGE.TMF.APPENDPARAMS", "");
    }
}

