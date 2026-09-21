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

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.PSSFImpl;
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFGlobalModel
extends PSGlobalModelBase<String, PSSF, IPSSF> {
    private static final Log log = LogFactory.getLog(PSSFGlobalModel.class);

    @Override
    protected PSSF GetObject(String strPSSFId) {
        PSSF PSSF2 = new PSSF();
        CallResult callResult = this.iPSModelHelper.getPSSF(strPSSFId, PSSF2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6280\u672f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSF2;
    }

    @Override
    protected IPSSF OnCreateModelHelper(PSSF vt) throws Exception {
        PSSFImpl iPSSF = new PSSFImpl();
        iPSSF.init(this.iDAGlobalHelper, vt);
        return iPSSF;
    }

    @Override
    protected Boolean TestObjectRenew(PSSF obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSF vt) {
        return vt.getPSSFID();
    }
}

