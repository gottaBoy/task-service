/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.security.IPSSysUniRes
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.security;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysUniRes;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.security.PSSysUniResImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUniResGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUniRes, IPSSysUniRes> {
    private static final Log log = LogFactory.getLog(PSSysUniResGlobalModel.class);

    @Override
    protected PSSysUniRes getObject(String strPSSysUniResId) {
        PSSysUniRes psSysUniRes = new PSSysUniRes();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysUniRes(strPSSysUniResId, psSysUniRes);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUniResId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUniRes;
    }

    @Override
    protected IPSSysUniRes onCreateModelHelper(PSSysUniRes vt) throws Exception {
        PSSysUniResImpl iPSSysUniRes = null;
        iPSSysUniRes = new PSSysUniResImpl();
        iPSSysUniRes.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysUniRes;
    }

    @Override
    protected Boolean testObjectRenew(PSSysUniRes obj) {
        return false;
    }

    @Override
    protected IPSSysUniRes registerModel(PSSysUniRes vt) throws Exception {
        IPSSysUniRes iIPSSysUniRes = (IPSSysUniRes)this.internalGetModelHelper(vt.getPSSYSUNIRESID());
        if (iIPSSysUniRes != null) {
            return iIPSSysUniRes;
        }
        this.setModel(vt.getPSSYSUNIRESID(), vt, null);
        return (IPSSysUniRes)this.findModelHelper(vt.getPSSYSUNIRESID());
    }

    @Override
    protected Vector<PSSysUniRes> getAllModels() throws Exception {
        Vector<PSSysUniRes> list = new Vector<PSSysUniRes>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysUniReses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUniRes vt) {
        return vt.getPSSYSUNIRESID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

