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

import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFPkgImpl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPkgGlobalModel
extends PSPFGlobalModelBase<String, PSPFPkg, IPSPFPkg> {
    private static final Log log = LogFactory.getLog(PSPFPkgGlobalModel.class);

    @Override
    protected PSPFPkg GetObject(String strPSPFPkgId) {
        PSPFPkg PSPFPkg2 = new PSPFPkg();
        CallResult callResult = this.iPSModelHelper.getPSPFPkg(strPSPFPkgId, PSPFPkg2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u524d\u7aef\u5e94\u7528\u7ec4\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPkgId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPkg2;
    }

    @Override
    protected IPSPFPkg OnCreateModelHelper(PSPFPkg vt) throws Exception {
        PSPFPkgImpl iPSPFPkg = new PSPFPkgImpl();
        iPSPFPkg.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFPkg;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPkg obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPkg vt) {
        return vt.getPSPFPKGID();
    }
}

