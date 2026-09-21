/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterItem
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterItem;
import net.ibizsys.model.entity.PSSysCounterItem;

public interface IPSSysCounterItemRuntime
extends IPSSysCounterItem {
    public void init(IPSModelStorageContext var1, IPSSysCounter var2, PSSysCounterItem var3) throws Exception;
}

