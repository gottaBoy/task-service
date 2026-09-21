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

import SA.SRFDA.PS.Core.Deploy.IPSDepSysType;
import SA.SRFDA.PS.Core.Deploy.PSDepSysTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSysType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSysTypeGlobalModel
extends PSGlobalModelBase<String, PSDepSysType, IPSDepSysType> {
    private static final Log log = LogFactory.getLog(PSDepSysTypeGlobalModel.class);

    @Override
    protected PSDepSysType GetObject(String strPSDepSysTypeId) {
        PSDepSysType PSDepSysType2 = new PSDepSysType();
        CallResult callResult = this.iPSModelHelper.getPSDepSysType(strPSDepSysTypeId, PSDepSysType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u53ef\u90e8\u7f72\u7cfb\u7edf\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepSysTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepSysType2;
    }

    @Override
    protected IPSDepSysType OnCreateModelHelper(PSDepSysType vt) throws Exception {
        PSDepSysTypeImpl iPSDepSysType = new PSDepSysTypeImpl();
        iPSDepSysType.init(this.iDAGlobalHelper, vt);
        return iPSDepSysType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSysType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepSysType vt) {
        return vt.getPSDEPSYSTYPEID();
    }
}

