/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;

public interface IPSDEFVRSingleCondition
extends IPSDEFVRCondition {
    public String getPSDEFId();

    public IPSDEField getPSDEField();

    public String getDEFName();
}

