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
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.PSViewLogicTypeImpl;
import SA.SRFDA.PS.Data.PSViewLogicType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewLogicTypeGlobalModel
extends PSGlobalModelBase<String, PSViewLogicType, IPSViewLogicType> {
    private static final Log log = LogFactory.getLog(PSViewLogicTypeGlobalModel.class);

    @Override
    protected PSViewLogicType GetObject(String strPSViewLogicTypeId) {
        PSViewLogicType PSViewLogicType2 = new PSViewLogicType();
        CallResult callResult = this.iPSModelHelper.getPSViewLogicType(strPSViewLogicTypeId, PSViewLogicType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u89c6\u56fe\u903b\u8f91\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewLogicTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSViewLogicType2;
    }

    @Override
    protected IPSViewLogicType OnCreateModelHelper(PSViewLogicType vt) throws Exception {
        PSViewLogicTypeImpl iPSViewLogicType = new PSViewLogicTypeImpl();
        iPSViewLogicType.init(this.iDAGlobalHelper, vt);
        return iPSViewLogicType;
    }

    @Override
    protected Boolean TestObjectRenew(PSViewLogicType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSViewLogicType vt) {
        return vt.getPSVIEWLOGICTYPEID();
    }
}

