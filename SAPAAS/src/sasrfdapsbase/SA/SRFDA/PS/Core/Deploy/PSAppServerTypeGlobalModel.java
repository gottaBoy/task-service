/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.Deploy.PSAppServerTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppServerType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppServerTypeGlobalModel
extends PSGlobalModelBase<String, PSAppServerType, IPSAppServerType> {
    private static final Log log = LogFactory.getLog(PSAppServerTypeGlobalModel.class);

    @Override
    protected PSAppServerType GetObject(String strPSAppServerTypeId) {
        PSAppServerType PSAppServerType2 = new PSAppServerType();
        CallResult callResult = this.iPSModelHelper.getPSAppServerType(strPSAppServerTypeId, PSAppServerType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e94\u7528\u670d\u52a1\u5668\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppServerTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSAppServerType2;
    }

    @Override
    protected IPSAppServerType OnCreateModelHelper(PSAppServerType vt) throws Exception {
        IPSAppServerType iPSAppServerType = null;
        iPSAppServerType = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new PSAppServerTypeImpl() : (IPSAppServerType)ObjectHelper.create((String)vt.getTYPEHELPER());
        iPSAppServerType.init(this.iDAGlobalHelper, vt);
        return iPSAppServerType;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppServerType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSAppServerType vt) {
        return vt.getPSASTYPEID();
    }
}

