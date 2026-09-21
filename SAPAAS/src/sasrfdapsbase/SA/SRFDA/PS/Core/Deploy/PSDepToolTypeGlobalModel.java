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

import SA.SRFDA.PS.Core.Deploy.IPSDepToolType;
import SA.SRFDA.PS.Core.Deploy.PSDepToolTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepToolType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepToolTypeGlobalModel
extends PSGlobalModelBase<String, PSDepToolType, IPSDepToolType> {
    private static final Log log = LogFactory.getLog(PSDepToolTypeGlobalModel.class);

    @Override
    protected PSDepToolType GetObject(String strPSDepToolTypeId) {
        PSDepToolType PSDepToolType2 = new PSDepToolType();
        CallResult callResult = this.iPSModelHelper.getPSDepToolType(strPSDepToolTypeId, PSDepToolType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u90e8\u7f72\u5de5\u5177\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepToolTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepToolType2;
    }

    @Override
    protected IPSDepToolType OnCreateModelHelper(PSDepToolType vt) throws Exception {
        PSDepToolTypeImpl iPSDepToolType = new PSDepToolTypeImpl();
        iPSDepToolType.init(this.iDAGlobalHelper, vt);
        return iPSDepToolType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepToolType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepToolType vt) {
        return vt.getPSDEPTOOLTYPEID();
    }
}

