/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRValueRecursionCondition
extends IPSDEFVRSingleCondition {
    public IPSDataEntity getMajorPSDataEntity();

    public boolean isAlwaysCheck();
}

