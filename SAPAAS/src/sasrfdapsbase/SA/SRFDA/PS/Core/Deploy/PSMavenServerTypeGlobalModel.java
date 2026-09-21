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

import SA.SRFDA.PS.Core.Deploy.IPSMavenServerType;
import SA.SRFDA.PS.Core.Deploy.PSMavenServerTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMavenServerType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMavenServerTypeGlobalModel
extends PSGlobalModelBase<String, PSMavenServerType, IPSMavenServerType> {
    private static final Log log = LogFactory.getLog(PSMavenServerTypeGlobalModel.class);

    @Override
    protected PSMavenServerType GetObject(String strPSMavenServerTypeId) {
        PSMavenServerType PSMavenServerType2 = new PSMavenServerType();
        CallResult callResult = this.iPSModelHelper.getPSMavenServerType(strPSMavenServerTypeId, PSMavenServerType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0Maven\u670d\u52a1\u5668\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMavenServerTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSMavenServerType2;
    }

    @Override
    protected IPSMavenServerType OnCreateModelHelper(PSMavenServerType vt) throws Exception {
        IPSMavenServerType iPSMavenServerType = null;
        iPSMavenServerType = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSMavenServerTypeImpl() : (IPSMavenServerType)ObjectHelper.create((String)vt.getTYPEOBJ());
        iPSMavenServerType.init(this.iDAGlobalHelper, vt);
        return iPSMavenServerType;
    }

    @Override
    protected Boolean TestObjectRenew(PSMavenServerType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMavenServerType vt) {
        return vt.getPSMAVENSERVERTYPEID();
    }
}

