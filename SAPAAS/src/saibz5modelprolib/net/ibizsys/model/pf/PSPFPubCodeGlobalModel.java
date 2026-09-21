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

import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.PSPFGlobalModelBase;
import net.ibizsys.model.pf.PSPFPubCodeImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubCodeGlobalModel
extends PSPFGlobalModelBase<String, PSPFPubCode, IPSPFPubCode> {
    private static final Log log = LogFactory.getLog(PSPFPubCodeGlobalModel.class);

    @Override
    protected PSPFPubCode getObject(String strPSPFPubCodeId) {
        PSPFPubCode PSPFPubCode2 = new PSPFPubCode();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFPubCode(strPSPFPubCodeId, PSPFPubCode2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u53d1\u5e03\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPubCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPubCode2;
    }

    @Override
    protected IPSPFPubCode onCreateModelHelper(PSPFPubCode vt) throws Exception {
        PSPFPubCodeImpl iPSPFPubCode = new PSPFPubCodeImpl();
        iPSPFPubCode.init(this.getPSModelStorageContext(), this.getPSPF(), null, vt);
        return iPSPFPubCode;
    }

    @Override
    protected Boolean testObjectRenew(PSPFPubCode obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPubCode vt) {
        return vt.getPSPFPUBCODEID();
    }
}

