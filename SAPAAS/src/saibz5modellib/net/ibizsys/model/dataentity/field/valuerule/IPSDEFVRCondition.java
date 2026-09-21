/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.valuerule.IDEFVRCondition
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.paas.core.valuerule.IDEFVRCondition;

public interface IPSDEFVRCondition
extends IDEFVRCondition,
IPSModelObject {
    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition();

    public String getCondType();

    public String getRuleInfo();

    public boolean isNotMode();

    public boolean isTryMode();

    public boolean isKeyCond();
}

