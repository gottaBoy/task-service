/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSimpleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"SIMPLE"})
public class PSDEFVRSimpleConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRSimpleCondition {
    private String strParamType = null;
    private String strParamValue = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPARAMTYPE())) {
            this.strParamType = this.psDEFValueRuleCond.getPARAMTYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getCONDVALUE())) {
            this.strParamValue = this.psDEFValueRuleCond.getCONDVALUE();
        }
    }

    @Override
    public String getPSDBValueOPId() {
        return this.psDEFValueRuleCond.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="DEFVRParamType", fields={"PARAMTYPE"})
    public String getParamType() {
        return this.strParamType;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u503c", fields={"CONDVALUE"})
    public String getParamValue() {
        return this.strParamValue;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u64cd\u4f5c", fields={"PSDBVALUEOPID"})
    public String getCondOp() {
        return this.getPSDBValueOPId();
    }
}

