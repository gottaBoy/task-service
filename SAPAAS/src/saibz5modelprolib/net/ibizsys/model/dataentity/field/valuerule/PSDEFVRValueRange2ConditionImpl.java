/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRange2Condition
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRange2Condition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRValueRange2ConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRange2Condition {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.getRuleInfo())) {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append("\u6570\u503c\u5fc5\u987b");
            if (this.isNotMode()) {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValue());
                    } else {
                        sBuilderEx.append("\u5c0f\u4e8e[%1$s]", (Object)this.getMinValue());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValue());
                    } else {
                        sBuilderEx.append("\u5927\u4e8e[%1$s]", (Object)this.getMaxValue());
                    }
                }
            } else {
                if (this.getMinValue() != null) {
                    if (this.isIncludeMinValue()) {
                        sBuilderEx.append("\u5927\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMinValue());
                    } else {
                        sBuilderEx.append("\u5927\u4e8e[%1$s]", (Object)this.getMinValue());
                    }
                }
                if (this.getMaxValue() != null) {
                    if (this.getMinValue() != null) {
                        sBuilderEx.append("\u4e14");
                    }
                    if (this.isIncludeMaxValue()) {
                        sBuilderEx.append("\u5c0f\u4e8e\u7b49\u4e8e[%1$s]", (Object)this.getMaxValue());
                    } else {
                        sBuilderEx.append("\u5c0f\u4e8e[%1$s]", (Object)this.getMaxValue());
                    }
                }
            }
            this.setRuleInfo(sBuilderEx.toString());
        }
    }

    @PSModelRTMeta(description="\u6700\u5c0f\u503c")
    public Double getMinValue() {
        if (this.psDEFValueRuleCond.isPARAM7Null()) {
            return null;
        }
        return Double.parseDouble(this.psDEFValueRuleCond.getPARAM7());
    }

    @PSModelRTMeta(description="\u542b\u6700\u5c0f\u503c")
    public boolean isIncludeMinValue() {
        if (this.psDEFValueRuleCond.isPARAM5Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM5();
    }

    @PSModelRTMeta(description="\u6700\u5927\u503c")
    public Double getMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM8Null()) {
            return null;
        }
        return Double.parseDouble(this.psDEFValueRuleCond.getPARAM8());
    }

    @PSModelRTMeta(description="\u542b\u6700\u5927\u503c")
    public boolean isIncludeMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM6Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM6();
    }
}

