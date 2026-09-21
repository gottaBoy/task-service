/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRValueRange3Condition
extends IPSDEFVRSingleCondition {
    public String getSeparator();

    public String[] getValueRanges();

    public String getValues();
}

