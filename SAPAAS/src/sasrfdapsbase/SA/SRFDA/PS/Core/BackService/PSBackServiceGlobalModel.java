/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BackService;

import SA.SRFDA.PS.Core.BackService.IPSBackService;
import SA.SRFDA.PS.Core.BackService.PSBackServiceImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSBackService;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSBackServiceGlobalModel
extends PSGlobalModelBase<String, PSBackService, IPSBackService> {
    private static final Log log = LogFactory.getLog(PSBackServiceGlobalModel.class);

    @Override
    protected PSBackService GetObject(String strPSBackServiceId) {
        PSBackService PSBackService2 = new PSBackService();
        CallResult callResult = this.iPSModelHelper.getPSBackService(strPSBackServiceId, PSBackService2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u9884\u7f6e\u540e\u53f0\u4efb\u52a1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSBackServiceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSBackService2;
    }

    @Override
    protected IPSBackService OnCreateModelHelper(PSBackService vt) throws Exception {
        PSBackServiceImpl iPSBackService = new PSBackServiceImpl();
        iPSBackService.init(this.iDAGlobalHelper, vt);
        return iPSBackService;
    }

    @Override
    protected Boolean TestObjectRenew(PSBackService obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSBackService vt) {
        return vt.getPSBACKSERVICEID();
    }
}

