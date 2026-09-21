/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.IS.Ctrl.Data.ISEraseItem;
import SA.SRFDA.IS.Ctrl.ISRFISEraseItemHelper;
import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultEraseItemHelper
implements ISRFISEraseItemHelper {
    private static Log log = LogFactory.getLog(DefaultEraseItemHelper.class);

    @Override
    public CallResult Erase(ISRFISIndexContext context, ISEraseItem eraseItem, TreeMap<String, String> docs) {
        Vector dataEntities;
        BaseDAQueryModelHelper daQueryModelHelper;
        CallResult callResult = new CallResult();
        IDEHelper iDEHelper = context.getGlobalHelper().getDAModelStorage().FindDEHelper(eraseItem.getDEID());
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)eraseItem.getDEID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strDBStorage = "";
        String strDEHelperObject = "";
        if (!StringHelper.IsNullOrEmpty((String)strDBStorage)) {
            strDEHelperObject = context.getGlobalHelper().getDAModelStorage().FindDBStorage(strDBStorage).GetProperty("DAQUERYMODELHELPER");
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            strDEHelperObject = context.getGlobalHelper().getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
        }
        if ((daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDEHelperObject));
            return callResult;
        }
        int nStartRow = 0;
        int nPageSize = eraseItem.getPAGESIZE();
        if (nPageSize <= 0) {
            nPageSize = 500;
        }
        String strSortInfo = eraseItem.getPAGEORDERINFO();
        strSortInfo = strSortInfo.trim();
        String strSortField = "";
        String strSordDir = "";
        if (!StringHelper.IsNullOrEmpty((String)strSortInfo)) {
            String[] parts = strSortInfo.split("[ ]");
            if (parts.length >= 1) {
                strSortField = parts[0];
            }
            if (parts.length >= 2) {
                strSordDir = parts[1];
            }
        }
        String strKeyFieldName = iDEHelper.GetKeyDEFHelper().getName();
        String strMajorFieldName = iDEHelper.GetMajorDEFHelper().getName();
        CallParamList callParamList = new CallParamList();
        String strSQL = StringHelper.Format((String)"select %2$s,%3$s from %1$s ", (Object)iDEHelper.GetMainTable(), (Object)strMajorFieldName, (Object)strKeyFieldName);
        String strCond = "";
        if (iDEHelper.IsLogicValid()) {
            IDEFHelper iDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iDEFHelper != null) {
                strCond = StringHelper.Format((String)" %1$s = %2$s ", (Object)iDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iDEHelper.GetProperty("VALIDVALUE"));
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)eraseItem.getDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)eraseItem.getEXTCOND())) {
            if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                strCond = String.valueOf(strCond) + " AND ";
            }
            strCond = String.valueOf(strCond) + eraseItem.getEXTCOND();
        }
        if (!StringHelper.IsNullOrEmpty((String)strCond)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCond;
        }
        int nTotalRowCount = 0;
        do {
            String strPageSQL = daQueryModelHelper.GetPagingSQL(strSQL, nStartRow, nPageSize, strSortField, strSordDir, "", "");
            dataEntities = new Vector();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)context.getGlobalHelper(), (String)iDEHelper.GetDBStorage(), (String)strPageSQL, (Vector)callParamList.GetList(), dataEntities, (String)"");
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo()), (Object)strPageSQL));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
                return callResult;
            }
            int nRowCount = dataEntities.size();
            int i = 0;
            while (i < nRowCount) {
                BaseDataEntity dataEntity = (BaseDataEntity)dataEntities.get(i);
                docs.put(dataEntity.GetParamStringValue(strKeyFieldName, ""), dataEntity.GetParamStringValue(strMajorFieldName, ""));
                ++i;
            }
            if (dataEntities.size() < nPageSize) break;
            nStartRow += nPageSize;
        } while ((nTotalRowCount += dataEntities.size()) < 5000);
        return callResult;
    }

    @Override
    public CallResult FinishErase(ISRFISIndexContext context, ISEraseItem eraseItem, TreeMap<String, String> docs) {
        CallResult callResult = new CallResult();
        IDEHelper iDEHelper = context.getGlobalHelper().getDAModelStorage().FindDEHelper(eraseItem.getDEID());
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)eraseItem.getDEID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strSQL = StringHelper.Format((String)"DELETE from %1$s WHERE %2$s=?", (Object)iDEHelper.GetMainTable(), (Object)iDEHelper.GetKeyDEFHelper().getName());
        Vector<CallParam> callParams = new Vector<CallParam>();
        CallParam callParam = new CallParam();
        callParams.add(callParam);
        for (String strKey : docs.keySet()) {
            callParam.setDataType(25);
            callParam.setValue((Object)strKey);
            BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)context.getGlobalHelper(), (String)iDEHelper.GetDBStorage(), (String)strSQL, callParams);
        }
        return callResult;
    }
}

