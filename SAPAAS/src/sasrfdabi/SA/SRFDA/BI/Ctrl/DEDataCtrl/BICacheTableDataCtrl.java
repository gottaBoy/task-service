/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BICacheTableDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(BICacheTableDataCtrl.class);
    public static final String CUSTOMCALL_REMOVEEXPIRED = "REMOVEEXPIRED";

    protected IDEDataCtrlHelper GetDEDataCtrlHelper(String strDBStorage) {
        return this.globalHelperEx.getDEDataCtrlHelper(strDBStorage);
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_REMOVEEXPIRED, (boolean)true) == 0) {
            return this.RemoveExpired();
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult RemoveExpired() {
        try {
            return this.OnRemoveExpired();
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8fc7\u671f\u6570\u636e\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult OnRemoveExpired() throws Exception {
        Date curDate = new Date();
        Date removeDate = new Date();
        removeDate.setTime(curDate.getTime() - 86400000L);
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)removeDate);
        String strSQL = StringHelper.Format((String)"SELECT * FROM  T_SRFBICacheTable WHERE CREATEDATE<=?");
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)"");
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8fc7\u671f\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (BaseDataEntity baseDataEntity : list) {
            callResult = this.Remove(baseDataEntity);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrlHelper iDEDataCtrlHelper = this.GetDEDataCtrlHelper(this.GetDEHelper().GetDBStorage());
        if (iDEDataCtrlHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b58\u50a8[%1$s]\u6570\u636e\u5e93\u8bbf\u95ee\u63a7\u5236\u5bf9\u8c61", (Object)this.GetDEHelper().GetDBStorage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strTableName = dataEntity.GetParamStringValue("BICACHETABLENAME", "");
        String strExistTableSQL = iDEDataCtrlHelper.GetSQL_IsTableExist(strTableName);
        BaseDataEntity rowCount = new BaseDataEntity();
        callResult = BICacheTableDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strExistTableSQL, (BaseDataEntity)rowCount);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u5224\u65adBI\u4e34\u65f6\u8868\u662f\u5426\u5b58\u5728\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        if (nRowCnt >= 1) {
            String strDropTableSQL = iDEDataCtrlHelper.GetSQL_DropTable(strTableName);
            callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (String)this.GetDEHelper().GetDBStorage(), (String)strDropTableSQL, null);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5220\u9664BI\u4e34\u65f6\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
        }
        return callResult;
    }
}

