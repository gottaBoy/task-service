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
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TBTemplGlobalModel
extends BaseDAGlobalModel {
    protected IDEDataCtrl tbTemplDataCtrl = null;
    private static final Log log = LogFactory.getLog(TBTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "TBTEMPLRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            this.tbTemplDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0127", "SYSTEM", null);
            if (this.tbTemplDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0127"));
                return callResult;
            }
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u5de5\u5177\u680f\u6a21\u677f\u5168\u5c40\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.tbTemplDataCtrl == null) {
            return null;
        }
        TBTempl tbTempl = new TBTempl();
        tbTempl.setTBTEMPLID((String)objObjectId);
        CallResult callResult = this.tbTemplDataCtrl.Get(tbTempl);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u5177\u680f\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return tbTempl;
    }

    protected Boolean TestObjectRenew(Object obj) {
        TBTempl tbTempl = (TBTempl)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0127", tbTempl.getTBTEMPLID()) != tbTempl.getVERSION()) {
            return true;
        }
        return false;
    }
}

