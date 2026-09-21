/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleTypeImpl;
import net.ibizsys.model.entity.PSDEFValueRuleType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeGlobalModel
extends PSGlobalModelBase<String, PSDEFValueRuleType, IPSDEFValueRuleType> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeGlobalModel.class);

    @Override
    protected PSDEFValueRuleType getObject(String strPSDEFValueRuleTypeId) {
        PSDEFValueRuleType PSDEFValueRuleType2 = new PSDEFValueRuleType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEFValueRuleType(strPSDEFValueRuleTypeId, PSDEFValueRuleType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEFValueRuleType2;
    }

    @Override
    protected IPSDEFValueRuleType onCreateModelHelper(PSDEFValueRuleType vt) throws Exception {
        PSDEFValueRuleTypeImpl iPSDEFValueRuleType = new PSDEFValueRuleTypeImpl();
        iPSDEFValueRuleType.init(this.getPSModelStorageContext(), vt);
        return iPSDEFValueRuleType;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFValueRuleType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEFValueRuleType vt) {
        return vt.getPSDEFVRTYPEID();
    }
}

