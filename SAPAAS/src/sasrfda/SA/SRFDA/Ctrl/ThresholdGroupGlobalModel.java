/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.THGroup;
import SA.SRFDA.Ctrl.Data.Threshold;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThresholdGroupGlobalModel
extends BaseDAGlobalModel {
    protected IDEDataCtrl thGroupDataCtrl = null;
    protected IDEDataCtrl thresholdDataCtrl = null;
    private static final Log log = LogFactory.getLog(ThresholdGroupGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "THGROUPRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11033000) {
            this.thGroupDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0118", "SYSTEM", null);
            if (this.thGroupDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0118"));
                return callResult;
            }
            this.thresholdDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0119", "SYSTEM", null);
            if (this.thresholdDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0119"));
                return callResult;
            }
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u9600\u503c\u5168\u5c40\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.thGroupDataCtrl == null) {
            return null;
        }
        THGroup thGroup = new THGroup();
        thGroup.setTHGROUPID((String)objObjectId);
        CallResult callResult = this.thGroupDataCtrl.Get(thGroup);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9600\u503c\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("THGROUPID", objObjectId);
        Vector thresholds = new Vector();
        callResult = this.thresholdDataCtrl.Select(cond, thresholds, Threshold.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u9600\u503c\u7ec4[%1$s]\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        thGroup.getThresholds().addAll(thresholds);
        return thGroup;
    }

    protected Boolean TestObjectRenew(Object obj) {
        THGroup thGroup = (THGroup)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0118", thGroup.getTHGROUPID()) != thGroup.getVERSION()) {
            return true;
        }
        return false;
    }
}

