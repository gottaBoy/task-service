/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRValueRange3Condition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"VALUERANGE3"})
public class PSDEFVRValueRange3ConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRange3Condition {
    private String strSeparator = ";";
    private String strValues = null;
    private String[] values = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPARAM())) {
            this.strSeparator = this.psDEFValueRuleCond.getPARAM();
        }
        this.strValues = this.psDEFValueRuleCond.getCONDVALUE();
        if (!StringHelper.isNullOrEmpty((String)this.strValues)) {
            this.values = StringHelper.split((String)this.strValues, (String)this.getSeparator());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u96c6\u5408", child=true, fields={"CONDVALUE"})
    public String[] getValueRanges() {
        return this.values;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26", fields={"PARAM"})
    public String getSeparator() {
        return this.strSeparator;
    }

    @Override
    public String getValues() {
        return this.strValues;
    }
}

