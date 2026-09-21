/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.DEDataCtrl.IGSR2DataCtrl;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GSR2Helper
extends BaseDAGlobalModel {
    protected IGSR2DataCtrl gsrDataCtrl = null;
    private static final Log log = LogFactory.getLog(GSR2Helper.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "GSR2RENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11041000) {
            IDEDataCtrl deDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0500", "SYSTEM", null);
            if (deDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0500"));
                return callResult;
            }
            if (!(deDataCtrl instanceof IGSR2DataCtrl)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DE0500"));
                return callResult;
            }
            this.gsrDataCtrl = (IGSR2DataCtrl)deDataCtrl;
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.gsrDataCtrl == null) {
            return null;
        }
        GSR2 gsr = new GSR2();
        gsr.setGSR2ID((String)objObjectId);
        CallResult callResult = this.gsrDataCtrl.Get(gsr);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.gsrDataCtrl.ListSumTables(gsr.getGSR2ID(), gsr.getSumTables());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u6c47\u603b\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.gsrDataCtrl.ListDimensions(gsr.getGSR2ID(), gsr.getDimensions());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u5206\u7ec4\u7ef4\u5ea6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.gsrDataCtrl.ListDimensions2(gsr.getGSR2ID(), gsr.getDimensions2());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u5206\u7ec4\u7ef4\u5ea62[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.gsrDataCtrl.ListMeasures(gsr.getGSR2ID(), gsr.getMeasures());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u88682\u6307\u6807[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return gsr;
    }

    protected Boolean TestObjectRenew(Object obj) {
        GSR2 gsr = (GSR2)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0500", gsr.getGSR2ID()) != gsr.getVERSION()) {
            return true;
        }
        return false;
    }
}

