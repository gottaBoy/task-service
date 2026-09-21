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
import SA.SRFDA.PS.Core.Res.IPSSysUtilType;
import SA.SRFDA.PS.Core.Res.PSSysUtilTypeImpl;
import SA.SRFDA.PS.Data.PSSysUtilType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUtilTypeGlobalModel
extends PSGlobalModelBase<String, PSSysUtilType, IPSSysUtilType> {
    private static final Log log = LogFactory.getLog(PSSysUtilTypeGlobalModel.class);

    @Override
    protected PSSysUtilType GetObject(String strPSSysUtilTypeId) {
        PSSysUtilType PSSysUtilType2 = new PSSysUtilType();
        CallResult callResult = this.iPSModelHelper.getPSSysUtilType(strPSSysUtilTypeId, PSSysUtilType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u7cfb\u7edf\u529f\u80fd\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUtilTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSysUtilType2;
    }

    @Override
    protected IPSSysUtilType OnCreateModelHelper(PSSysUtilType vt) throws Exception {
        PSSysUtilTypeImpl iPSSysUtilType = new PSSysUtilTypeImpl();
        iPSSysUtilType.init(this.iDAGlobalHelper, vt);
        return iPSSysUtilType;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUtilType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSysUtilType vt) {
        return vt.getPSSYSUTILTYPEID();
    }
}

