/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBTTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDCBKType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterBTTypeGlobalModel
extends PSGlobalModelBase<String, PSDCBKType, IPSDevCenterBTType> {
    private static final Log log = LogFactory.getLog(PSDevCenterBTTypeGlobalModel.class);

    @Override
    protected PSDCBKType GetObject(String strPSDevCenterBKTypeId) {
        PSDCBKType psDevCenterBKType = new PSDCBKType();
        CallResult callResult = this.iPSModelHelper.getPSDevCenterBTType(strPSDevCenterBKTypeId, psDevCenterBKType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevCenterBKTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevCenterBKType;
    }

    @Override
    protected IPSDevCenterBTType OnCreateModelHelper(PSDCBKType vt) throws Exception {
        PSDevCenterBTTypeImpl iPSDevCenterBKType = new PSDevCenterBTTypeImpl();
        iPSDevCenterBKType.init(this.iDAGlobalHelper, vt);
        return iPSDevCenterBKType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCBKType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDCBKType vt) {
        return vt.getPSDCBKTYPEID();
    }
}

