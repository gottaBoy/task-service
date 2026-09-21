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

import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProcCode;
import SA.SRFDA.PS.Core.Database.PSDEDBSysProcCodeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBSysProcCodeGlobalModel
extends PSGlobalModelBase<String, PSDEDBSysProcCode, IPSDEDBSysProcCode> {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcCodeGlobalModel.class);
    protected IPSDEDBSysProc iPSDEDBSysProc = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBSysProc iPSDEDBSysProc) {
        this.iPSDEDBSysProc = iPSDEDBSysProc;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDEDBSysProcCode GetObject(String strPSDESysProcCodeId) {
        PSDEDBSysProcCode psDESysProcCode = new PSDEDBSysProcCode();
        CallResult callResult = this.iPSModelHelper.getPSDEDBSysProcCode(strPSDESysProcCodeId, psDESysProcCode);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u7cfb\u7edf\u8fc7\u7a0b\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDESysProcCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDESysProcCode;
    }

    @Override
    protected IPSDEDBSysProcCode OnCreateModelHelper(PSDEDBSysProcCode vt) throws Exception {
        PSDEDBSysProcCodeImpl iPSDEDBSysProcCode = new PSDEDBSysProcCodeImpl();
        iPSDEDBSysProcCode.init(this.iDAGlobalHelper, this.iPSDEDBSysProc, vt);
        return iPSDEDBSysProcCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDBSysProcCode obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDBSysProc.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDBSysProcCode vt) {
        return vt.getPSDESPCODEID();
    }
}

