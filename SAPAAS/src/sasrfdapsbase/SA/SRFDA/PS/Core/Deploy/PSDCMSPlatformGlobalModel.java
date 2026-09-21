/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPlatformImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDCMSPlatform;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMSPlatformGlobalModel
extends PSGlobalModelBase<String, PSDCMSPlatform, IPSDCMSPlatform> {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.nRenewTimer = 0;
        return super.OnInit();
    }

    @Override
    protected boolean getEnableRenew() {
        return true;
    }

    @Override
    protected PSDCMSPlatform GetObject(String strPSDCMSPlatformId) {
        PSDCMSPlatform psMSPlatform = new PSDCMSPlatform();
        CallResult callResult = this.iPSModelHelper.getPSDCMSPlatform(strPSDCMSPlatformId, psMSPlatform);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCMSPlatformId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psMSPlatform;
    }

    @Override
    protected IPSDCMSPlatform OnCreateModelHelper(PSDCMSPlatform vt) throws Exception {
        PSDCMSPlatformImpl iPSDCMSPlatform = new PSDCMSPlatformImpl();
        iPSDCMSPlatform.init(this.iDAGlobalHelper, vt);
        return iPSDCMSPlatform;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCMSPlatform obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDCMSPlatform vt) {
        return vt.getPSDCMSPLATFORMID();
    }
}

