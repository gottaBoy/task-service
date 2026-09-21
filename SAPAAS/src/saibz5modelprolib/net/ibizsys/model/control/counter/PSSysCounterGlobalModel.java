/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.counter;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.IPSCounterTypeRuntime;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRuntime;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCounterGlobalModel
extends PSSystemGlobalModelBase<String, PSSysCounter, IPSSysCounter> {
    private static final Log log = LogFactory.getLog(PSSysCounterGlobalModel.class);

    @Override
    protected PSSysCounter getObject(String strPSSysCounterId) {
        PSSysCounter psSysCounter = new PSSysCounter();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysCounter(strPSSysCounterId, psSysCounter);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysCounterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysCounter;
    }

    @Override
    protected IPSSysCounter onCreateModelHelper(PSSysCounter vt) throws Exception {
        IPSCounterType iPSCounterType = this.getPSModelStorageContext().getPSCounterType(vt.getCOUNTERTYPE());
        IPSSysCounter iPSSysCounter = ((IPSCounterTypeRuntime)iPSCounterType).createPSSysCounter(vt);
        ((IPSSysCounterRuntime)iPSSysCounter).init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysCounter;
    }

    @Override
    protected Boolean testObjectRenew(PSSysCounter obj) {
        return false;
    }

    @Override
    protected IPSSysCounter registerModel(PSSysCounter vt) throws Exception {
        IPSSysCounter iPSSysCounter = (IPSSysCounter)this.internalGetModelHelper(vt.getPSSYSCOUNTERID());
        if (iPSSysCounter != null) {
            return iPSSysCounter;
        }
        this.setModel(vt.getPSSYSCOUNTERID(), vt, null);
        iPSSysCounter = (IPSSysCounter)this.findModelHelper(vt.getPSSYSCOUNTERID());
        return iPSSysCounter;
    }

    @Override
    protected Vector<PSSysCounter> getAllModels() throws Exception {
        Vector<PSSysCounter> list = new Vector<PSSysCounter>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysCounters(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u8ba1\u6570\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysCounter vt) {
        return vt.getPSSYSCOUNTERID();
    }
}

