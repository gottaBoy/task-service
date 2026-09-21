/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.PSViewTypeImpl;
import SA.SRFDA.PS.Data.PSViewType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewTypeGlobalModel
extends PSGlobalModelBase<String, PSViewType, IPSViewType> {
    private static final Log log = LogFactory.getLog(PSViewTypeGlobalModel.class);

    @Override
    protected PSViewType GetObject(String strPSViewTypeId) {
        PSViewType PSViewType2 = new PSViewType();
        CallResult callResult = this.iPSModelHelper.getPSViewType(strPSViewTypeId, PSViewType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSViewType2;
    }

    @Override
    protected IPSViewType OnCreateModelHelper(PSViewType vt) throws Exception {
        PSViewTypeImpl iPSViewType = new PSViewTypeImpl();
        iPSViewType.init(this.iDAGlobalHelper, vt);
        return iPSViewType;
    }

    @Override
    protected Boolean TestObjectRenew(PSViewType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSViewType vt) {
        return vt.getPSVIEWTYPEID();
    }
}

