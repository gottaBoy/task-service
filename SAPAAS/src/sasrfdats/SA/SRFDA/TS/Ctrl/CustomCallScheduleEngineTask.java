/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.TS.Ctrl.BaseScheduleEngineTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class CustomCallScheduleEngineTask
extends BaseScheduleEngineTask {
    public static final String TASKPARAM_DEID = "DEID";
    public static final String TASKPARAM_CUSTOMCALL = "CUSTOMCALL";

    @Override
    public CallResult Execute(TSSDTask task) {
        CallResult callResult = new CallResult();
        ISRFDAGlobalHelper iDAGlobalHelper = this.iScheduleEngineContext.getDAGlobalHelper();
        Integer nIndex = 1;
        while (true) {
            IDEHelper iDEHelper;
            String strDEId = "";
            String strCustomCall = "";
            if (nIndex == 1) {
                strDEId = PropertiesHelper.GetProperty((Properties)task.getTaskParam(), (String)TASKPARAM_DEID, (String)"");
                strCustomCall = PropertiesHelper.GetProperty((Properties)task.getTaskParam(), (String)TASKPARAM_CUSTOMCALL, (String)"");
                if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
                    return callResult;
                }
                if (StringHelper.IsNullOrEmpty((String)strCustomCall)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u8c03\u7528"));
                    return callResult;
                }
            } else {
                strDEId = PropertiesHelper.GetProperty((Properties)task.getTaskParam(), (String)(TASKPARAM_DEID + nIndex.toString()), (String)"");
                strCustomCall = PropertiesHelper.GetProperty((Properties)task.getTaskParam(), (String)(TASKPARAM_CUSTOMCALL + nIndex.toString()), (String)"");
                if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                    return callResult;
                }
                if (StringHelper.IsNullOrEmpty((String)strCustomCall)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u8c03\u7528"));
                    return callResult;
                }
            }
            if ((iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId)) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u3002", (Object)strDEId));
                return callResult;
            }
            callResult = CustomCallScheduleEngineTask.GetCallParam(this.iScheduleEngineContext, iDEHelper, task.getUSERDATA());
            if (callResult.IsError()) {
                return callResult;
            }
            BaseDataEntity paramDataEntity = null;
            paramDataEntity = callResult.getUserObject() != null ? (BaseDataEntity)callResult.getUserObject() : new BaseDataEntity();
            IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null);
            if (iDEDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDEHelper.getId()));
                return callResult;
            }
            callResult = iDEDataCtrl.CustomCall(strCustomCall, paramDataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            nIndex = nIndex + 1;
        }
    }
}

