/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRStringLengthCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"STRINGLENGTH"})
public class PSDEFVRStringLengthConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRStringLengthCondition {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.getRuleInfo())) {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.Append("\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b");
            if (this.isNotMode()) {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.Append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValue());
                    } else {
                        sBuilderEx.Append("\u5c0f\u4e8e[%1$s]", (Object)this.getMinValue());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.Append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.Append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValue());
                    } else {
                        sBuilderEx.Append("\u5927\u4e8e[%1$s]", (Object)this.getMaxValue());
                    }
                }
            } else {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.Append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValue());
                    } else {
                        sBuilderEx.Append("\u5927\u4e8e[%1$s]", (Object)this.getMinValue());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.Append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.Append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValue());
                    } else {
                        sBuilderEx.Append("\u5c0f\u4e8e[%1$s]", (Object)this.getMaxValue());
                    }
                }
            }
            this.setRuleInfo(sBuilderEx.toString());
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c", fields={"PARAM3"})
    public Integer getMinValue() {
        if (this.psDEFValueRuleCond.isPARAM3Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u542b\u6700\u5c0f\u503c", fields={"PARAM5"})
    public boolean isIncludeMinValue() {
        if (this.psDEFValueRuleCond.isPARAM5Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM5();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c", fields={"PARAM4"})
    public Integer getMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM4Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u542b\u6700\u5927\u503c", fields={"PARAM6"})
    public boolean isIncludeMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM6Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM6();
    }
}

