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

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleTypeDetail;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleTypeDetailImpl;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeDetailGlobalModel
extends PSGlobalModelBase<String, PSDEFValueRuleTypeDetail, IPSDEFValueRuleTypeDetail> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeDetailGlobalModel.class);
    protected IPSDEFValueRuleType iPSDEFValueRuleType = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEFValueRuleType iPSDEFValueRuleType) throws Exception {
        this.iPSDEFValueRuleType = iPSDEFValueRuleType;
        super.init(iPSModelStorageContext);
    }

    @Override
    protected PSDEFValueRuleTypeDetail getObject(String strPSDEFValueRuleTypeDetailId) {
        PSDEFValueRuleTypeDetail PSDEFValueRuleTypeDetail2 = new PSDEFValueRuleTypeDetail();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b\u660e\u7ec6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleTypeDetailId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEFValueRuleTypeDetail2;
    }

    @Override
    protected IPSDEFValueRuleTypeDetail onCreateModelHelper(PSDEFValueRuleTypeDetail vt) throws Exception {
        PSDEFValueRuleTypeDetailImpl iPSDEFValueRuleTypeDetail = new PSDEFValueRuleTypeDetailImpl();
        iPSDEFValueRuleTypeDetail.init(this.getPSModelStorageContext(), this.iPSDEFValueRuleType, vt);
        return iPSDEFValueRuleTypeDetail;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFValueRuleTypeDetail obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEFValueRuleTypeDetail vt) {
        return vt.getPSDEFVRTYPEDETAILID();
    }
}

