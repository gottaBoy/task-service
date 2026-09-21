/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.PSControlTypeImpl;
import net.ibizsys.model.entity.PSControlType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlTypeGlobalModel
extends PSGlobalModelBase<String, PSControlType, IPSControlType> {
    private static final Log log = LogFactory.getLog(PSControlTypeGlobalModel.class);

    @Override
    protected PSControlType getObject(String strPSControlTypeId) {
        PSControlType PSControlType2 = new PSControlType();
        CallResult callResult = this.getPSModelQueryHelper().getPSControlType(strPSControlTypeId, PSControlType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u63a7\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSControlTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSControlType2;
    }

    @Override
    protected IPSControlTypeRuntime onCreateModelHelper(PSControlType vt) throws Exception {
        IPSControlTypeRuntime iPSControlType = null;
        iPSControlType = StringHelper.isNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSControlTypeImpl() : (IPSControlTypeRuntime)this.getPSModelStorageContext().createObject(vt.getTYPEOBJ());
        iPSControlType.init(this.getPSModelStorageContext(), vt);
        return iPSControlType;
    }

    @Override
    protected Boolean testObjectRenew(PSControlType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSControlType vt) {
        return vt.getPSCTRLTYPEID();
    }
}

