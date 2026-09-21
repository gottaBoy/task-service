/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dynasys;

import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.dynasys.PSDynaInstImpl;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDynaInstGlobalModel
extends PSSystemGlobalModelBase<String, PSDynaInst, IPSDynaInst> {
    private static final Log log = LogFactory.getLog(PSDynaInstGlobalModel.class);

    @Override
    protected PSDynaInst getObject(String strPSDynaInstId) {
        PSDynaInst psDynaInst = new PSDynaInst();
        CallResult callResult = this.getPSModelQueryHelper().getPSDynaInst(strPSDynaInstId, psDynaInst);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDynaInstId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDynaInst;
    }

    @Override
    protected IPSDynaInst onCreateModelHelper(PSDynaInst vt) throws Exception {
        PSDynaInstImpl iPSDynaInst = null;
        iPSDynaInst = new PSDynaInstImpl();
        iPSDynaInst.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSDynaInst;
    }

    @Override
    protected Boolean testObjectRenew(PSDynaInst obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSDynaInst vt) {
        return vt.getPSDYNAINSTID();
    }
}

