/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.PSPortletTypeImpl;
import SA.SRFDA.PS.Data.PSPortletType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPortletTypeGlobalModel
extends PSGlobalModelBase<String, PSPortletType, IPSPortletType> {
    private static final Log log = LogFactory.getLog(PSPortletTypeGlobalModel.class);

    @Override
    protected PSPortletType GetObject(String strPSPortletTypeId) {
        PSPortletType PSPortletType2 = new PSPortletType();
        CallResult callResult = this.iPSModelHelper.getPSPortletType(strPSPortletTypeId, PSPortletType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u770b\u677f\u90e8\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPortletTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPortletType2;
    }

    @Override
    protected IPSPortletType OnCreateModelHelper(PSPortletType vt) throws Exception {
        PSPortletTypeImpl iPSPortletType = new PSPortletTypeImpl();
        iPSPortletType.init(this.iDAGlobalHelper, vt);
        return iPSPortletType;
    }

    @Override
    protected Boolean TestObjectRenew(PSPortletType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSPortletType vt) {
        return vt.getPSPORTLETTYPEID();
    }
}

