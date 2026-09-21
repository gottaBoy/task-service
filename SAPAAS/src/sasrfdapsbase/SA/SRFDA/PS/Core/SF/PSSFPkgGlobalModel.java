/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFPkgImpl;
import SA.SRFDA.PS.Data.PSSFPkg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPkgGlobalModel
extends PSSFGlobalModelBase<String, PSSFPkg, IPSSFPkg> {
    private static final Log log = LogFactory.getLog(PSSFPkgGlobalModel.class);

    @Override
    protected PSSFPkg GetObject(String strPSSFPkgId) {
        PSSFPkg PSSFPkg2 = new PSSFPkg();
        CallResult callResult = this.iPSModelHelper.getPSSFPkg(strPSSFPkgId, PSSFPkg2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFPkgId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFPkg2;
    }

    @Override
    protected IPSSFPkg OnCreateModelHelper(PSSFPkg vt) throws Exception {
        PSSFPkgImpl iPSSFPkg = new PSSFPkgImpl();
        iPSSFPkg.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFPkg;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFPkg obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFPkg vt) {
        return vt.getPSSFPKGID();
    }
}

