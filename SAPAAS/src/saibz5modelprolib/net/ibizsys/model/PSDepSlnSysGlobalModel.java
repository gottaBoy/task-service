/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSDepSlnSys
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.PSDepSlnSysImpl;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnSysGlobalModel
extends PSGlobalModelBase<String, PSDepSlnSys, IPSDepSlnSys> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysGlobalModel.class);

    @Override
    protected PSDepSlnSys getObject(String strPSDepSlnSysId) {
        PSDepSlnSys PSDepSlnSys2 = new PSDepSlnSys();
        CallResult callResult = this.getPSModelQueryHelper().getPSDepSlnSys(strPSDepSlnSysId, PSDepSlnSys2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepSlnSysId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepSlnSys2;
    }

    @Override
    protected IPSDepSlnSys onCreateModelHelper(PSDepSlnSys vt) throws Exception {
        PSDepSlnSysImpl iPSDepSlnSys = new PSDepSlnSysImpl();
        iPSDepSlnSys.init(this.getPSModelStorageContext(), vt);
        return iPSDepSlnSys;
    }

    @Override
    protected Boolean testObjectRenew(PSDepSlnSys obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepSlnSys vt) {
        return vt.getPSDEPSLNSYSID();
    }
}

