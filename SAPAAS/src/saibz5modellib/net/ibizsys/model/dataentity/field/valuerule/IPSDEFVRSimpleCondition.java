/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRSimpleCondition
extends IPSDEFVRSingleCondition {
    public String getPSDBValueOPId();

    public String getParamType();

    public String getParamValue();
}

