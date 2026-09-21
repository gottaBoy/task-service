/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcessType;
import SA.SRFDA.PS.Core.WF.PSWFProcessTypeImpl;
import SA.SRFDA.PS.Data.PSWFProcessType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSWFProcessTypeGlobalModel
extends PSGlobalModelBase<String, PSWFProcessType, IPSWFProcessType> {
    private static final Log log = LogFactory.getLog(PSWFProcessTypeGlobalModel.class);

    @Override
    protected PSWFProcessType GetObject(String strPSWFProcessTypeId) {
        PSWFProcessType PSWFProcessType2 = new PSWFProcessType();
        CallResult callResult = this.iPSModelHelper.getPSWFProcessType(strPSWFProcessTypeId, PSWFProcessType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6d41\u7a0b\u5904\u7406\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFProcessTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWFProcessType2;
    }

    @Override
    protected IPSWFProcessType OnCreateModelHelper(PSWFProcessType vt) throws Exception {
        PSWFProcessTypeImpl iPSWFProcessType = new PSWFProcessTypeImpl();
        iPSWFProcessType.init(this.iDAGlobalHelper, vt);
        return iPSWFProcessType;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFProcessType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWFProcessType vt) {
        return vt.getPSWFPROCESSTYPEID();
    }
}

