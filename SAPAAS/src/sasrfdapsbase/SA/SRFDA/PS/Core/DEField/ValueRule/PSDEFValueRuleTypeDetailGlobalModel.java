/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleTypeDetail;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleTypeDetailImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFValueRuleTypeDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeDetailGlobalModel
extends PSGlobalModelBase<String, PSDEFValueRuleTypeDetail, IPSDEFValueRuleTypeDetail> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeDetailGlobalModel.class);
    protected IPSDEFValueRuleType iPSDEFValueRuleType = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFValueRuleType iPSDEFValueRuleType) {
        this.iPSDEFValueRuleType = iPSDEFValueRuleType;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDEFValueRuleTypeDetail GetObject(String strPSDEFValueRuleTypeDetailId) {
        PSDEFValueRuleTypeDetail PSDEFValueRuleTypeDetail2 = new PSDEFValueRuleTypeDetail();
        CallResult callResult = this.iPSModelHelper.getPSDEFValueRuleTypeDetail(strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b\u660e\u7ec6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleTypeDetailId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEFValueRuleTypeDetail2;
    }

    @Override
    protected IPSDEFValueRuleTypeDetail OnCreateModelHelper(PSDEFValueRuleTypeDetail vt) throws Exception {
        PSDEFValueRuleTypeDetailImpl iPSDEFValueRuleTypeDetail = new PSDEFValueRuleTypeDetailImpl();
        iPSDEFValueRuleTypeDetail.init(this.iDAGlobalHelper, this.iPSDEFValueRuleType, vt);
        return iPSDEFValueRuleTypeDetail;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFValueRuleTypeDetail obj) {
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

