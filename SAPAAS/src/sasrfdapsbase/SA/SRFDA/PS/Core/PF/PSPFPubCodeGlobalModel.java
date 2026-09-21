/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFPubCodeImpl;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubCodeGlobalModel
extends PSPFGlobalModelBase<String, PSPFPubCode, IPSPFPubCode> {
    private static final Log log = LogFactory.getLog(PSPFPubCodeGlobalModel.class);

    @Override
    protected PSPFPubCode GetObject(String strPSPFPubCodeId) {
        PSPFPubCode PSPFPubCode2 = new PSPFPubCode();
        CallResult callResult = this.iPSModelHelper.getPSPFPubCode(strPSPFPubCodeId, PSPFPubCode2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u53d1\u5e03\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPubCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPubCode2;
    }

    @Override
    protected IPSPFPubCode OnCreateModelHelper(PSPFPubCode vt) throws Exception {
        PSPFPubCodeImpl iPSPFPubCode = new PSPFPubCodeImpl();
        iPSPFPubCode.init(this.iDAGlobalHelper, this.getPSPF(), null, vt);
        return iPSPFPubCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPubCode obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPubCode vt) {
        return vt.getPSPFPUBCODEID();
    }
}

