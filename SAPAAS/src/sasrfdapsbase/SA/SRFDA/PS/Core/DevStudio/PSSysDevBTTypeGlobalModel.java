/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBTTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDevBTType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDevBTTypeGlobalModel
extends PSGlobalModelBase<String, PSSysDevBTType, IPSSysDevBTType> {
    private static final Log log = LogFactory.getLog(PSSysDevBTTypeGlobalModel.class);

    @Override
    protected PSSysDevBTType GetObject(String strPSSysDevBTTypeId) {
        PSSysDevBTType psSysDevBTType = new PSSysDevBTType();
        CallResult callResult = this.iPSModelHelper.getPSSysDevBTType(strPSSysDevBTTypeId, psSysDevBTType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDevBTTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDevBTType;
    }

    @Override
    protected IPSSysDevBTType OnCreateModelHelper(PSSysDevBTType vt) throws Exception {
        PSSysDevBTTypeImpl iPSSysDevBTType = new PSSysDevBTTypeImpl();
        iPSSysDevBTType.init(this.iDAGlobalHelper, vt);
        return iPSSysDevBTType;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDevBTType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSysDevBTType vt) {
        return vt.getPSSYSDEVBTTYPEID();
    }
}

