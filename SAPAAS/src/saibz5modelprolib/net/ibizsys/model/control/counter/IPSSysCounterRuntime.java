/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.control.counter.IPSSysCounter
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.entity.PSSysCounter;

public interface IPSSysCounterRuntime
extends IPSSysCounter {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysCounter var3) throws Exception;

    public String getCodeName();
}

