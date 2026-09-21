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

import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.Deploy.PSDevServerTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevServerType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevServerTypeGlobalModel
extends PSGlobalModelBase<String, PSDevServerType, IPSDevServerType> {
    private static final Log log = LogFactory.getLog(PSDevServerTypeGlobalModel.class);

    @Override
    protected PSDevServerType GetObject(String strPSDevServerTypeId) {
        PSDevServerType PSDevServerType2 = new PSDevServerType();
        CallResult callResult = this.iPSModelHelper.getPSDevServerType(strPSDevServerTypeId, PSDevServerType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u684c\u9762\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevServerTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDevServerType2;
    }

    @Override
    protected IPSDevServerType OnCreateModelHelper(PSDevServerType vt) throws Exception {
        IPSDevServerType iPSDevServerType = null;
        iPSDevServerType = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new PSDevServerTypeImpl() : (IPSDevServerType)ObjectHelper.create((String)vt.getTYPEHELPER());
        iPSDevServerType.init(this.iDAGlobalHelper, vt);
        return iPSDevServerType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevServerType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevServerType vt) {
        return vt.getPSDEVSERVERTYPEID();
    }
}

