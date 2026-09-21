/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

public interface IPSDEFValueRule
extends IPSDEFieldObject,
IDEFValueRule,
IPSModelObject {
    public boolean isDefaultMode();

    public String getTypeDetail();

    public String getRuleInfo();

    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition();

    public boolean isCheckDefault();

    public Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions();
}

