/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public interface IDynaCounterHandler
extends ICounterHandler {
    public void init(IDynaSysModel var1, IPSSysCounter var2) throws Exception;
}

