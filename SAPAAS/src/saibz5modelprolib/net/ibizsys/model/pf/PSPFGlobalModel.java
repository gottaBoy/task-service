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
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFRuntime;
import net.ibizsys.model.pf.PSPFImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFGlobalModel
extends PSGlobalModelBase<String, PSPF, IPSPF> {
    private static final Log log = LogFactory.getLog(PSPFGlobalModel.class);

    @Override
    protected PSPF getObject(String strPSPFId) {
        PSPF PSPF2 = new PSPF();
        CallResult callResult = this.getPSModelQueryHelper().getPSPF(strPSPFId, PSPF2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6280\u672f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPF2;
    }

    @Override
    protected IPSPF onCreateModelHelper(PSPF vt) throws Exception {
        IPSPF iPSPF = null;
        iPSPF = StringHelper.isNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSPFImpl() : (IPSPF)this.getPSModelStorageContext().createObject(vt.getTYPEOBJ());
        ((IPSPFRuntime)iPSPF).init(this.getPSModelStorageContext(), vt);
        return iPSPF;
    }

    @Override
    protected Boolean testObjectRenew(PSPF obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSPF vt) {
        return vt.getPSPFID();
    }
}

