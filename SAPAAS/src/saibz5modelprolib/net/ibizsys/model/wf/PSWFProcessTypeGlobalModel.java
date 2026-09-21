/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.wf.IPSWFProcessType;
import net.ibizsys.model.wf.PSWFProcessTypeImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessTypeGlobalModel
extends PSGlobalModelBase<String, PSWFProcessType, IPSWFProcessType> {
    private static final Log log = LogFactory.getLog(PSWFProcessTypeGlobalModel.class);

    @Override
    protected PSWFProcessType getObject(String strPSWFProcessTypeId) {
        PSWFProcessType PSWFProcessType2 = new PSWFProcessType();
        CallResult callResult = this.getPSModelQueryHelper().getPSWFProcessType(strPSWFProcessTypeId, PSWFProcessType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6d41\u7a0b\u5904\u7406\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFProcessTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWFProcessType2;
    }

    @Override
    protected IPSWFProcessType onCreateModelHelper(PSWFProcessType vt) throws Exception {
        PSWFProcessTypeImpl iPSWFProcessType = new PSWFProcessTypeImpl();
        iPSWFProcessType.init(this.getPSModelStorageContext(), vt);
        return iPSWFProcessType;
    }

    @Override
    protected Boolean testObjectRenew(PSWFProcessType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWFProcessType vt) {
        return vt.getPSWFPROCESSTYPEID();
    }
}

