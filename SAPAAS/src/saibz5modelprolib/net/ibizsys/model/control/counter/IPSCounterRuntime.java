/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounter
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.entity.PSCounter;

public interface IPSCounterRuntime
extends IPSCounter {
    public void init(IPSModelStorageContext var1, PSCounter var2) throws Exception;
}

