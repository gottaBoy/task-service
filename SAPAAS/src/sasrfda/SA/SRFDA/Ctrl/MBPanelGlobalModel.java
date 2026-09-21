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
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MBPanelGlobalModel
extends BaseDAGlobalModel {
    private static final Log log = LogFactory.getLog(MBPanelGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "MBPANELRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        MBPanel mbPanel = new MBPanel();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetMBPanel((String)objObjectId, mbPanel);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u9762\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return mbPanel;
    }

    protected Boolean TestObjectRenew(Object obj) {
        MBPanel mbPanel = (MBPanel)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0431", mbPanel.getMBPANELID()) != mbPanel.getVERSION()) {
            return true;
        }
        return false;
    }
}

