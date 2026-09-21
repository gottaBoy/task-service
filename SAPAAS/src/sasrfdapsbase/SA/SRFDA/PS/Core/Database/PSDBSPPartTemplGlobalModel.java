/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBSPPartTempl;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.PSDBSPPartTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBSPPartTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBSPPartTemplGlobalModel
extends PSGlobalModelBase<String, PSDBSPPartTempl, IPSDBSPPartTempl> {
    private static final Log log = LogFactory.getLog(PSDBSPPartTemplGlobalModel.class);
    protected IPSDBSysProcTempl iPSDBSysProcTempl = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBSysProcTempl iPSDBSysProcTempl) {
        this.iPSDBSysProcTempl = iPSDBSysProcTempl;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDBSPPartTempl GetObject(String strPSDBSPPartTemplId) {
        PSDBSPPartTempl PSDBSPPartTempl2 = new PSDBSPPartTempl();
        CallResult callResult = this.iPSModelHelper.getPSDBSPPartTempl(strPSDBSPPartTemplId, PSDBSPPartTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u4ee3\u7801\u6a21\u7248[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBSPPartTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDBSPPartTempl2;
    }

    @Override
    protected IPSDBSPPartTempl OnCreateModelHelper(PSDBSPPartTempl vt) throws Exception {
        PSDBSPPartTemplImpl iPSDBSPPartTempl = new PSDBSPPartTemplImpl();
        iPSDBSPPartTempl.init(this.iDAGlobalHelper, this.iPSDBSysProcTempl, vt);
        return iPSDBSPPartTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSDBSPPartTempl obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDBSysProcTempl.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDBSPPartTempl vt) {
        return vt.getPSDBSPPARTTEMPLID();
    }
}

