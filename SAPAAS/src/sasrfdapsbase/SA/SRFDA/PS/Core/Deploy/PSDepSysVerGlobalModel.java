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
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSysVerGlobalModel
extends PSGlobalModelBase<String, PSDepSysVer, IPSDepSysVer> {
    private static final Log log = LogFactory.getLog(PSDepSysVerGlobalModel.class);

    @Override
    protected PSDepSysVer GetObject(String strPSDepSysVerId) {
        PSDepSysVer PSDepSysVer2 = new PSDepSysVer();
        CallResult callResult = this.iPSModelHelper.getPSDepSysVer(strPSDepSysVerId, PSDepSysVer2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u53ef\u90e8\u7f72\u7cfb\u7edf\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepSysVerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepSysVer2;
    }

    @Override
    protected IPSDepSysVer OnCreateModelHelper(PSDepSysVer vt) throws Exception {
        IPSDepSysType iPSDepSysType = this.iPSModelStorage.getPSDepSysType(vt.getPSDEPSYSVERTYPE());
        IPSDepSysVer iPSDepSysVer = iPSDepSysType.createPSDepSysVer(vt);
        return iPSDepSysVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSysVer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepSysVer vt) {
        return vt.getPSDEPSYSVERID();
    }
}

