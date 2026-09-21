/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysDBValueFunc
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.database;

import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.database.PSSysDBValueFuncImpl;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDBValueFuncGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDBValueFunc, IPSSysDBValueFunc> {
    private static final Log log = LogFactory.getLog(PSSysDBValueFuncGlobalModel.class);

    @Override
    protected PSSysDBValueFunc getObject(String strPSSysDBValueFuncId) {
        PSSysDBValueFunc PSSysDBValueFunc2 = new PSSysDBValueFunc();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysDBValueFunc(strPSSysDBValueFuncId, PSSysDBValueFunc2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6570\u636e\u5e93\u503c\u51fd\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDBValueFuncId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSysDBValueFunc2;
    }

    @Override
    protected IPSSysDBValueFunc onCreateModelHelper(PSSysDBValueFunc vt) throws Exception {
        PSSysDBValueFuncImpl iPSSysDBValueFunc = new PSSysDBValueFuncImpl();
        iPSSysDBValueFunc.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysDBValueFunc;
    }

    @Override
    protected Boolean testObjectRenew(PSSysDBValueFunc obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSysDBValueFunc vt) {
        return vt.getPSSYSDBVFID();
    }
}

