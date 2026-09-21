/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleTypeDetail;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleTypeDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeDetailImpl
extends PSObjectImpl
implements IPSDEFValueRuleTypeDetail {
    protected IPSDEFValueRuleType iPSDEFValueRuleType = null;
    protected PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail = null;
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeDetailImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFValueRuleType iPSDEFValueRuleType, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) throws Exception {
        this.psDEFValueRuleTypeDetail = psDEFValueRuleTypeDetail;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEFValueRuleTypeDetail.getPSDEFVRTYPEDETAILID());
        this.setName(psDEFValueRuleTypeDetail.getPSDEFVRTYPEDETAILNAME());
        this.setPSObjectData(this.psDEFValueRuleTypeDetail);
        this.onInit();
    }

    @Override
    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule psDEFValueRule) throws Exception {
        return (IPSDEFValueRule)ObjectHelper.Create((String)this.psDEFValueRuleTypeDetail.getPROCESSOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEFValueRuleType.getPSSysModelInstId();
    }
}

