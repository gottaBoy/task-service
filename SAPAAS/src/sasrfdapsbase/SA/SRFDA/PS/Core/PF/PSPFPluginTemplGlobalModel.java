/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.PSPFPluginTemplImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFPluginTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTemplGlobalModel
extends PSGlobalModelBase<String, PSPFPluginTempl, IPSPFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSPFPluginTemplGlobalModel.class);

    @Override
    protected PSPFPluginTempl GetObject(String strPSPFPluginTemplId) {
        PSPFPluginTempl PSPFPluginTempl2 = new PSPFPluginTempl();
        CallResult callResult = this.iPSModelHelper.getPSPFPluginTempl(strPSPFPluginTemplId, PSPFPluginTempl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e73\u53f0\u524d\u7aef\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPluginTempl2;
    }

    @Override
    protected IPSPFPluginTempl OnCreateModelHelper(PSPFPluginTempl vt) throws Exception {
        PSPFPluginTemplImpl iPSPFPluginTempl = new PSPFPluginTemplImpl();
        iPSPFPluginTempl.init(this.iDAGlobalHelper, vt);
        return iPSPFPluginTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPluginTempl obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSPFPluginTempl vt) {
        return vt.getPSPFPLUGINTEMPLID();
    }
}

