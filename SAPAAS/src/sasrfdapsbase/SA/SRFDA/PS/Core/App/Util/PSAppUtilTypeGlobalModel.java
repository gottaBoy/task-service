/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.Util.IPSAppUtilType;
import SA.SRFDA.PS.Core.App.Util.PSAppUtilTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppUtilType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppUtilTypeGlobalModel
extends PSGlobalModelBase<String, PSAppUtilType, IPSAppUtilType> {
    private static final Log log = LogFactory.getLog(PSAppUtilTypeGlobalModel.class);

    @Override
    protected PSAppUtilType GetObject(String strPSAppUtilTypeId) {
        PSAppUtilType PSAppUtilType2 = new PSAppUtilType();
        CallResult callResult = this.iPSModelHelper.getPSAppUtilType(strPSAppUtilTypeId, PSAppUtilType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUtilTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSAppUtilType2;
    }

    @Override
    protected IPSAppUtilType OnCreateModelHelper(PSAppUtilType vt) throws Exception {
        PSAppUtilTypeImpl iPSAppUtilType = new PSAppUtilTypeImpl();
        iPSAppUtilType.init(this.iDAGlobalHelper, vt);
        return iPSAppUtilType;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUtilType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSAppUtilType vt) {
        return vt.getPSAPPUTILTYPEID();
    }
}

