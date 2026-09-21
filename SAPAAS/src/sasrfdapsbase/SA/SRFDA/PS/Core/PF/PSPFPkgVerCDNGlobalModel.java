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

import SA.SRFDA.PS.Core.PF.IPSPFPkgVerCDN;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerCDNImpl;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgVerCDNGlobalModel
extends PSPFGlobalModelBase<String, PSPFPkgVerCDN, IPSPFPkgVerCDN> {
    private static final Log log = LogFactory.getLog(PSPFPkgVerCDNGlobalModel.class);

    @Override
    protected PSPFPkgVerCDN GetObject(String strPSPFPkgVerCDNId) {
        PSPFPkgVerCDN PSPFPkgVerCDN2 = new PSPFPkgVerCDN();
        CallResult callResult = this.iPSModelHelper.getPSPFPkgVerCDN(strPSPFPkgVerCDNId, PSPFPkgVerCDN2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u524d\u7aef\u5e94\u7528\u7ec4\u4ef6\u7248\u672cCDN[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPkgVerCDNId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPkgVerCDN2;
    }

    @Override
    protected IPSPFPkgVerCDN OnCreateModelHelper(PSPFPkgVerCDN vt) throws Exception {
        PSPFPkgVerCDNImpl iPSPFPkgVerCDN = new PSPFPkgVerCDNImpl();
        iPSPFPkgVerCDN.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFPkgVerCDN;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPkgVerCDN obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPkgVerCDN vt) {
        return vt.getPSPFPKGVERCDNID();
    }
}

