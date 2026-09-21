/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterRuntime;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.IPSCounterTypeRuntime;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCounterGlobalModel
extends PSGlobalModelBase<String, PSCounter, IPSCounter> {
    private static final Log log = LogFactory.getLog(PSCounterGlobalModel.class);

    @Override
    protected PSCounter getObject(String strPSCounterId) {
        PSCounter psCounter = new PSCounter();
        CallResult callResult = this.getPSModelQueryHelper().getPSCounter(strPSCounterId, psCounter);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u9884\u7f6e\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCounterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psCounter;
    }

    @Override
    protected IPSCounter onCreateModelHelper(PSCounter vt) throws Exception {
        IPSCounterType iPSCounterType = this.getPSModelStorageContext().getPSCounterType(vt.getCOUNTERTYPE());
        IPSCounter iPSCounter = ((IPSCounterTypeRuntime)iPSCounterType).createPSCounter(vt);
        ((IPSCounterRuntime)iPSCounter).init(this.getPSModelStorageContext(), vt);
        return iPSCounter;
    }

    @Override
    protected Boolean testObjectRenew(PSCounter obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSCounter vt) {
        return vt.getPSCOUNTERID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

