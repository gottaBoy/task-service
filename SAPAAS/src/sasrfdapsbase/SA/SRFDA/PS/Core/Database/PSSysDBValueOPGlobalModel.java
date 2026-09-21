/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBValueOP;
import SA.SRFDA.PS.Core.Database.PSSysDBValueOPImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDBValueOP;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBValueOPGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDBValueOP, IPSSysDBValueOP> {
    private static final Log log = LogFactory.getLog(PSSysDBValueOPGlobalModel.class);

    @Override
    protected PSSysDBValueOP GetObject(String strPSSysDBValueOPId) {
        PSSysDBValueOP PSSysDBValueOP2 = new PSSysDBValueOP();
        CallResult callResult = this.iPSModelHelper.getPSSysDBValueOP(this.getPSSystem().getId(), strPSSysDBValueOPId, PSSysDBValueOP2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u64cd\u4f5c\u7b26[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDBValueOPId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSysDBValueOP2;
    }

    @Override
    protected IPSSysDBValueOP OnCreateModelHelper(PSSysDBValueOP vt) throws Exception {
        PSSysDBValueOPImpl iPSSysDBValueOP = new PSSysDBValueOPImpl();
        iPSSysDBValueOP.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDBValueOP;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDBValueOP obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSysDBValueOP vt) {
        return vt.getPSSYSDBVALUEOPID();
    }
}

