/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SRFTS.Ctrl.ISRFTSTaskContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.TS.Ctrl.BaseDATSTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SRFTS.Ctrl.ISRFTSTaskContext;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAQueryAndCallTSTask
extends BaseDATSTask {
    private static Log log = LogFactory.getLog(DAQueryAndCallTSTask.class);
    public static final String TASKPARAM_QUERYMODELID = "QUERYMODELID";

    public CallResult Run(ISRFTSTaskContext context) {
        CallResult callResult = new CallResult();
        ISRFDAGlobalHelper iDAGlobalHelper = DAQueryAndCallTSTask.GetGlobalHelper(context);
        String strQueryModelId = context.getTaskItem().getTaskParam(TASKPARAM_QUERYMODELID, "");
        String strDEId = context.getTaskItem().getTaskParam("DEID", "");
        String strCustomCall = context.getTaskItem().getTaskParam("CUSTOMCALL", "");
        if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u6a21\u578b"));
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strCustomCall)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u8c03\u7528"));
            return callResult;
        }
        BaseDAQueryModelHelper queryModelHelper = iDAGlobalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
        if (queryModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61\u3002", (Object)strQueryModelId));
            return callResult;
        }
        IDEHelper iDEHelper = null;
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            iDEHelper = queryModelHelper.GetMajorDEHelper();
        } else {
            iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u3002", (Object)strDEId));
                return callResult;
            }
        }
        callResult = DAQueryAndCallTSTask.GetCallParam(iDEHelper, context);
        if (callResult.IsError()) {
            return callResult;
        }
        BaseDataEntity paramDataEntity = null;
        if (callResult.getUserObject() != null) {
            paramDataEntity = (BaseDataEntity)callResult.getUserObject();
        }
        DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(queryModelHelper.GetQMDeclareScript());
        script.Append(qmUserContext.GetQMDeclareScript());
        script.Append(queryModelHelper.GetQueryModelScript());
        Vector userConditions = new Vector();
        queryModelHelper.FillMajorConditions(userConditions);
        BaseDAQueryModelHelper.AppendConditionSQL((StringBuilderEx)script, userConditions);
        Vector list = new Vector();
        queryModelHelper.FillQMDeclareParams(list, null, iDAGlobalHelper, "SYSTEM", paramDataEntity);
        qmUserContext.FillQMDeclareParams(list, null, iDAGlobalHelper, "SYSTEM", paramDataEntity);
        queryModelHelper.FillCallParams(list, null, iDAGlobalHelper, "SYSTEM", paramDataEntity);
        log.info((Object)CallParamList.toDebugInfo(list));
        Vector results = new Vector();
        String strSQL = script.toString();
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDAGlobalHelper, (String)queryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strSQL, list, results, (String)"");
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSQL));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        if (results.size() == 0) {
            callResult.Reset();
            return callResult;
        }
        IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null);
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDEHelper.getId()));
            return callResult;
        }
        String strError = "";
        boolean bError = false;
        for (BaseDataEntity item : results) {
            callResult = iDEDataCtrl.CustomCall(strCustomCall, item);
            if (!callResult.IsError()) continue;
            if (bError) {
                strError = String.valueOf(strError) + ";";
            }
            strError = String.valueOf(strError) + callResult.getErrorInfo();
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u81ea\u5b9a\u4e49\u8c03\u7528[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEHelper.getId(), (Object)strCustomCall, (Object)callResult.getErrorInfo()));
            bError = true;
        }
        callResult.Reset();
        if (bError) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(strError);
        }
        return callResult;
    }
}

