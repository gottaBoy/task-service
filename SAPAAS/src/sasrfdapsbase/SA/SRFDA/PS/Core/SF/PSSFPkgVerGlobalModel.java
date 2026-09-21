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

import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFPkgVerImpl;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPkgVerGlobalModel
extends PSSFGlobalModelBase<String, PSSFPkgVer, IPSSFPkgVer> {
    private static final Log log = LogFactory.getLog(PSSFPkgVerGlobalModel.class);

    @Override
    protected PSSFPkgVer GetObject(String strPSSFPkgVerId) {
        PSSFPkgVer PSSFPkgVer2 = new PSSFPkgVer();
        CallResult callResult = this.iPSModelHelper.getPSSFPkgVer(strPSSFPkgVerId, PSSFPkgVer2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFPkgVerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFPkgVer2;
    }

    @Override
    protected IPSSFPkgVer OnCreateModelHelper(PSSFPkgVer vt) throws Exception {
        PSSFPkgVerImpl iPSSFPkgVer = new PSSFPkgVerImpl();
        iPSSFPkgVer.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFPkgVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFPkgVer obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFPkgVer vt) {
        return vt.getPSSFPKGVERID();
    }
}

