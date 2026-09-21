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

import SA.SRFDA.PS.Core.Deploy.IPSMQType;
import SA.SRFDA.PS.Core.Deploy.PSMQTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMQType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMQTypeGlobalModel
extends PSGlobalModelBase<String, PSMQType, IPSMQType> {
    private static final Log log = LogFactory.getLog(PSMQTypeGlobalModel.class);

    @Override
    protected PSMQType GetObject(String strPSMQTypeId) {
        PSMQType PSMQType2 = new PSMQType();
        CallResult callResult = this.iPSModelHelper.getPSMQType(strPSMQTypeId, PSMQType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0MQ\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMQTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSMQType2;
    }

    @Override
    protected IPSMQType OnCreateModelHelper(PSMQType vt) throws Exception {
        PSMQTypeImpl iPSMQType = new PSMQTypeImpl();
        iPSMQType.init(this.iDAGlobalHelper, vt);
        return iPSMQType;
    }

    @Override
    protected Boolean TestObjectRenew(PSMQType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMQType vt) {
        return vt.getPSMQTYPEID();
    }
}

