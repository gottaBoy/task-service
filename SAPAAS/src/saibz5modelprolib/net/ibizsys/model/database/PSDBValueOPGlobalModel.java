/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.data.IPSDBValueOP
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.database;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.data.IPSDBValueOP;
import net.ibizsys.model.database.PSDBValueOPImpl;
import net.ibizsys.model.entity.PSDBValueOP;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBValueOPGlobalModel
extends PSGlobalModelBase<String, PSDBValueOP, IPSDBValueOP> {
    private static final Log log = LogFactory.getLog(PSDBValueOPGlobalModel.class);

    @Override
    protected PSDBValueOP getObject(String strPSDBValueOPId) {
        PSDBValueOP psDBValueOP = new PSDBValueOP();
        CallResult callResult = this.getPSModelQueryHelper().getPSDBValueOP(strPSDBValueOPId, psDBValueOP);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6570\u636e\u5e93\u503c\u64cd\u4f5c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBValueOPId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDBValueOP;
    }

    @Override
    protected IPSDBValueOP onCreateModelHelper(PSDBValueOP vt) throws Exception {
        PSDBValueOPImpl iPSDBValueOP = new PSDBValueOPImpl();
        iPSDBValueOP.init(this.getPSModelStorageContext(), vt);
        return iPSDBValueOP;
    }

    @Override
    protected Boolean testObjectRenew(PSDBValueOP obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDBValueOP vt) {
        return vt.getPSDBVALUEOPID();
    }
}

