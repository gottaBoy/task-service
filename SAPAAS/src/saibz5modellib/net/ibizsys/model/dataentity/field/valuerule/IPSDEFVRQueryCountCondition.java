/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSingleCondition;

public interface IPSDEFVRQueryCountCondition
extends IPSDEFVRSingleCondition {
    public String getPSDEDataQueryId();

    public IPSDEDataQuery getPSDEDataQuery();

    public Integer getMinValue();

    public boolean isIncludeMinValue();

    public Integer getMaxValue();

    public boolean isIncludeMaxValue();

    public boolean isAlwaysCheck();
}

