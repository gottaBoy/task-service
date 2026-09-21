/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRStringLengthCondition
extends IPSDEFVRSingleCondition {
    public Integer getMinValue();

    public boolean isIncludeMinValue();

    public Integer getMaxValue();

    public boolean isIncludeMaxValue();
}

