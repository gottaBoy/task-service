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

import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.PSDBSysProcTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBSysProcTemplGlobalModel
extends PSGlobalModelBase<String, PSDBSysProcTempl, IPSDBSysProcTempl> {
    private static final Log log = LogFactory.getLog(PSDBSysProcTemplGlobalModel.class);
    protected IPSDBType iPSDBType = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType) {
        this.iPSDBType = iPSDBType;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDBSysProcTempl GetObject(String strPSDBSysProcTemplId) {
        PSDBSysProcTempl psDBSysProcTempl = new PSDBSysProcTempl();
        CallResult callResult = this.iPSModelHelper.getPSDBSysProcTempl(strPSDBSysProcTemplId, psDBSysProcTempl);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u7cfb\u7edf\u8fc7\u7a0b\u6a21\u7248[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBSysProcTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDBSysProcTempl;
    }

    @Override
    protected IPSDBSysProcTempl OnCreateModelHelper(PSDBSysProcTempl vt) throws Exception {
        PSDBSysProcTemplImpl iPSDBSysProcTempl = new PSDBSysProcTemplImpl();
        iPSDBSysProcTempl.init(this.iDAGlobalHelper, this.iPSDBType, vt);
        return iPSDBSysProcTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSDBSysProcTempl obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDBType.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDBSysProcTempl vt) {
        return vt.getPSDBSYSPROCTEMPLID();
    }
}

