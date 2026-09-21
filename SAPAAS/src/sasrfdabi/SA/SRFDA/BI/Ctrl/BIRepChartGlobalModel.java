/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIModelHelperFactory;
import SA.SRFDA.BI.Ctrl.Data.BIRepChart;
import SA.SRFDA.BI.Ctrl.IBIModelHelper;
import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIRepChartGlobalModel
extends BaseDAGlobalModel {
    private static final Log log = LogFactory.getLog(BIRepChartGlobalModel.class);
    protected IBIModelHelper iBIModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iBIModelHelper = BIModelHelperFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5206\u6790\u7acb\u65b9\u4f53\u62a5\u8868\u56fe\u5f62\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        BIRepChart biRepChart = new BIRepChart();
        CallResult callRsult = this.iBIModelHelper.GetBIRepChart((String)objObjectId, biRepChart);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53\u62a5\u8868\u56fe\u5f62[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return biRepChart;
    }

    protected Boolean TestObjectRenew(Object obj) {
        BIRepChart biRepChart = (BIRepChart)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("BI0080", (Object)biRepChart.getBIREPCHARTID()) != biRepChart.getVERSION()) {
            return true;
        }
        return false;
    }
}

