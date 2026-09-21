/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.springframework.util.StringUtils
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRValueRange2Condition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.springframework.util.StringUtils;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"VALUERANGE2"})
public class PSDEFVRValueRange2ConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRange2Condition {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.getRuleInfo())) {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.Append("\u6570\u503c\u5fc5\u987b");
            if (this.isNotMode()) {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.Append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValueString());
                    } else {
                        sBuilderEx.Append("\u5c0f\u4e8e[%1$s]", (Object)this.getMinValueString());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.Append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.Append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValueString());
                    } else {
                        sBuilderEx.Append("\u5927\u4e8e[%1$s]", (Object)this.getMaxValueString());
                    }
                }
            } else {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.Append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValueString());
                    } else {
                        sBuilderEx.Append("\u5927\u4e8e[%1$s]", (Object)this.getMinValueString());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.Append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.Append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValueString());
                    } else {
                        sBuilderEx.Append("\u5c0f\u4e8e[%1$s]", (Object)this.getMaxValueString());
                    }
                }
            }
            this.setRuleInfo(sBuilderEx.toString());
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c", fields={"PARAM7"})
    public Double getMinValue() {
        if (this.psDEFValueRuleCond.isPARAM7Null()) {
            return null;
        }
        return Double.parseDouble(this.psDEFValueRuleCond.getPARAM7());
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
    @PSModelRTMeta(description="\u6700\u5927\u503c", fields={"PARAM8"})
    public Double getMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM8Null()) {
            return null;
        }
        return Double.parseDouble(this.psDEFValueRuleCond.getPARAM8());
    }

    @Override
    @PSModelRTMeta(description="\u542b\u6700\u5927\u503c", fields={"PARAM6"})
    public boolean isIncludeMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM6Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM6();
    }

    protected String getMaxValueString() {
        String strNumber2;
        Double fValue = this.getMaxValue();
        if (fValue == null) {
            return null;
        }
        String strValue = String.format("%1$f", fValue);
        String[] parts = strValue.split("[.]");
        if (parts.length == 2 && StringUtils.hasLength((String)(strNumber2 = StringUtils.trimTrailingCharacter((String)parts[1], (char)'0')))) {
            return String.format("%1$s.%2$s", parts[0], strNumber2);
        }
        if (this.getPSDEField() != null && !DataTypeHelper.isIntType((int)this.getPSDEField().getStdDataType())) {
            return String.format("%1$s.%2$s", parts[0], "0");
        }
        return parts[0];
    }

    protected String getMinValueString() {
        String strNumber2;
        Double fValue = this.getMinValue();
        if (fValue == null) {
            return null;
        }
        String strValue = String.format("%1$f", fValue);
        String[] parts = strValue.split("[.]");
        if (parts.length == 2 && StringUtils.hasLength((String)(strNumber2 = StringUtils.trimTrailingCharacter((String)parts[1], (char)'0')))) {
            return String.format("%1$s.%2$s", parts[0], strNumber2);
        }
        if (this.getPSDEField() != null && !DataTypeHelper.isIntType((int)this.getPSDEField().getStdDataType())) {
            return String.format("%1$s.%2$s", parts[0], "0");
        }
        return parts[0];
    }
}

