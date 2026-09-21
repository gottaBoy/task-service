/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.valuerule.IDEFVRGroupCondition
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.Iterator;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.paas.core.valuerule.IDEFVRGroupCondition;

public interface IPSDEFVRGroupCondition
extends IPSDEFVRCondition,
IDEFVRGroupCondition {
    public Iterator<IPSDEFVRCondition> getPSDEFVRConditions();
}

