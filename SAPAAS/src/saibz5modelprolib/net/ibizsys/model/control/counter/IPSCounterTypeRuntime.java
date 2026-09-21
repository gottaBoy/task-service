/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.model.control.counter.IPSSysCounter
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.model.entity.PSSysCounter;

public interface IPSCounterTypeRuntime
extends IPSCounterType {
    public void init(IPSModelStorageContext var1, PSCounterType var2) throws Exception;

    public String getBaseClass(String var1) throws Exception;

    public IPSCounter createPSCounter(PSCounter var1) throws Exception;

    public IPSSysCounter createPSSysCounter(PSSysCounter var1) throws Exception;
}

