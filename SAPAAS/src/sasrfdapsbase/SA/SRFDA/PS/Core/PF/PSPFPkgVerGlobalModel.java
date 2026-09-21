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

import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerImpl;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgVerGlobalModel
extends PSPFGlobalModelBase<String, PSPFPkgVer, IPSPFPkgVer> {
    private static final Log log = LogFactory.getLog(PSPFPkgVerGlobalModel.class);

    @Override
    protected PSPFPkgVer GetObject(String strPSPFPkgVerId) {
        PSPFPkgVer PSPFPkgVer2 = new PSPFPkgVer();
        CallResult callResult = this.iPSModelHelper.getPSPFPkgVer(strPSPFPkgVerId, PSPFPkgVer2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u524d\u7aef\u5e94\u7528\u7ec4\u4ef6\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPkgVerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPkgVer2;
    }

    @Override
    protected IPSPFPkgVer OnCreateModelHelper(PSPFPkgVer vt) throws Exception {
        PSPFPkgVerImpl iPSPFPkgVer = new PSPFPkgVerImpl();
        iPSPFPkgVer.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFPkgVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPkgVer obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPkgVer vt) {
        return vt.getPSPFPKGVERID();
    }
}

