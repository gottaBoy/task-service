/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.pf.PSPFPluginTemplImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTemplGlobalModel
extends PSGlobalModelBase<String, PSPFPluginTempl, IPSPFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSPFPluginTemplGlobalModel.class);

    @Override
    protected PSPFPluginTempl getObject(String strPSPFPluginTemplId) {
        PSPFPluginTempl PSPFPluginTempl2 = new PSPFPluginTempl();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFPluginTempl(strPSPFPluginTemplId, PSPFPluginTempl2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e73\u53f0\u524d\u7aef\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPluginTempl2;
    }

    @Override
    protected IPSPFPluginTempl onCreateModelHelper(PSPFPluginTempl vt) throws Exception {
        PSPFPluginTemplImpl iPSPFPluginTempl = new PSPFPluginTemplImpl();
        iPSPFPluginTempl.init(this.getPSModelStorageContext(), vt);
        return iPSPFPluginTempl;
    }

    @Override
    protected Boolean testObjectRenew(PSPFPluginTempl obj) {
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

