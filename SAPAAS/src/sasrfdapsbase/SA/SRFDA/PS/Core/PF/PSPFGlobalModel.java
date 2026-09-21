/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.PSPFImpl;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFGlobalModel
extends BaseDAGlobalModel<String, PSPF, IPSPF> {
    private static final Log log = LogFactory.getLog(PSPFGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5e94\u7528\u6280\u672f\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSPF GetObject(String strPSPFId) {
        PSPF PSPF2 = new PSPF();
        CallResult callResult = this.iPSModelHelper.getPSPF(strPSPFId, PSPF2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6280\u672f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPF2;
    }

    protected IPSPF OnCreateModelHelper(PSPF vt) throws Exception {
        IPSPF iPSPF = null;
        iPSPF = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSPFImpl() : (IPSPF)ObjectHelper.Create((String)vt.getTYPEOBJ());
        iPSPF.init(this.iDAGlobalHelper, vt);
        return iPSPF;
    }

    protected Boolean TestObjectRenew(PSPF obj) {
        return false;
    }
}

