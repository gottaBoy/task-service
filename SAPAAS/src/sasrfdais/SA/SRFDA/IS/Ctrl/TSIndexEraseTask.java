/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFTS.Ctrl.ISRFTSTask
 *  SRFTS.Ctrl.ISRFTSTaskContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.IS.Ctrl.DefaultIndexGroupEraseHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFTS.Ctrl.ISRFTSTask;
import SRFTS.Ctrl.ISRFTSTaskContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TSIndexEraseTask
implements ISRFTSTask {
    private static Log log = LogFactory.getLog(TSIndexEraseTask.class);

    protected static ISRFDAGlobalHelper GetGlobalHelper(ISRFTSTaskContext context) {
        return (ISRFDAGlobalHelper)context.getGlobalHelper();
    }

    public CallResult Run(ISRFTSTaskContext context) {
        CallResult callResult = new CallResult();
        String strISGroupId = context.getTaskItem().getTaskParam("ISGROUP", "");
        if (StringHelper.IsNullOrEmpty((String)strISGroupId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7d22\u5f15\u7ec4\u7f16\u53f7"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DefaultIndexGroupEraseHelper defaultIndexGroupHelper = new DefaultIndexGroupEraseHelper();
        return defaultIndexGroupHelper.Erase(TSIndexEraseTask.GetGlobalHelper(context), strISGroupId);
    }
}

