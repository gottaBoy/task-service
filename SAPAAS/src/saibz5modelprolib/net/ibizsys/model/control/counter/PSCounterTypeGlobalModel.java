/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.PSCounterTypeImpl;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCounterTypeGlobalModel
extends PSGlobalModelBase<String, PSCounterType, IPSCounterType> {
    private static final Log log = LogFactory.getLog(PSCounterTypeGlobalModel.class);

    @Override
    protected PSCounterType getObject(String strPSCounterTypeId) {
        PSCounterType PSCounterType2 = new PSCounterType();
        CallResult callResult = this.getPSModelQueryHelper().getPSCounterType(strPSCounterTypeId, PSCounterType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u8ba1\u6570\u5668\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCounterTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSCounterType2;
    }

    @Override
    protected IPSCounterType onCreateModelHelper(PSCounterType vt) throws Exception {
        PSCounterTypeImpl iPSCounterType = new PSCounterTypeImpl();
        iPSCounterType.init(this.getPSModelStorageContext(), vt);
        return iPSCounterType;
    }

    @Override
    protected Boolean testObjectRenew(PSCounterType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSCounterType vt) {
        return vt.getPSCOUNTERTYPEID();
    }
}

