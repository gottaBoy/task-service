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
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFPluginTemplImpl;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPluginTemplGlobalModel
extends PSGlobalModelBase<String, PSSFPluginTempl, IPSSFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSSFPluginTemplGlobalModel.class);

    @Override
    protected PSSFPluginTempl GetObject(String strPSSFPluginTemplId) {
        PSSFPluginTempl PSSFPluginTempl2 = new PSSFPluginTempl();
        CallResult callResult = this.iPSModelHelper.getPSSFPluginTempl(strPSSFPluginTemplId, PSSFPluginTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e73\u53f0\u540e\u53f0\u670d\u52a1\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFPluginTempl2;
    }

    @Override
    protected IPSSFPluginTempl OnCreateModelHelper(PSSFPluginTempl vt) throws Exception {
        PSSFPluginTemplImpl iPSSFPluginTempl = new PSSFPluginTemplImpl();
        iPSSFPluginTempl.init(this.iDAGlobalHelper, vt);
        return iPSSFPluginTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFPluginTempl obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSFPluginTempl vt) {
        return vt.getPSSFPLUGINTEMPLID();
    }
}

