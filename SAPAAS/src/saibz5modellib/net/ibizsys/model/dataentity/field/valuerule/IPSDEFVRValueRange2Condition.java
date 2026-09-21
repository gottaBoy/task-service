/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRValueRange2Condition
extends IPSDEFVRSingleCondition {
    public Double getMinValue();

    public boolean isIncludeMinValue();

    public Double getMaxValue();

    public boolean isIncludeMaxValue();
}

