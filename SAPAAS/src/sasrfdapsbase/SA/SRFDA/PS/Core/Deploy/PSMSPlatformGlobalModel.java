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

import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.PSMSPlatformImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMSPlatform;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMSPlatformGlobalModel
extends PSGlobalModelBase<String, PSMSPlatform, IPSMSPlatform> {
    private static final Log log = LogFactory.getLog(PSMSPlatformGlobalModel.class);

    @Override
    protected PSMSPlatform GetObject(String strPSMSPlatformId) {
        PSMSPlatform psMSPlatform = new PSMSPlatform();
        CallResult callResult = this.iPSModelHelper.getPSMSPlatform(strPSMSPlatformId, psMSPlatform);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMSPlatformId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psMSPlatform;
    }

    @Override
    protected IPSMSPlatform OnCreateModelHelper(PSMSPlatform vt) throws Exception {
        PSMSPlatformImpl iPSMSPlatform = new PSMSPlatformImpl();
        iPSMSPlatform.init(this.iDAGlobalHelper, vt);
        return iPSMSPlatform;
    }

    @Override
    protected Boolean TestObjectRenew(PSMSPlatform obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMSPlatform vt) {
        return vt.getPSMSPLATFORMID();
    }
}

