/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.CounterGlobal
 *  net.ibizsys.paas.ctrlhandler.CustomCounterHandlerBase
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 */
package net.ibizsys.pscore.srv.counter;

import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.CustomCounterHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;

public abstract class SysIndexViewCounterHandlerBase
extends CustomCounterHandlerBase {
    public SysIndexViewCounterHandlerBase() {
        this.setId("8B30D897-369F-4E7E-A765-954CCE13C79B");
        this.setName("\u7cfb\u7edf\u9996\u9875\u5b9a\u65f6\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.SysIndexViewCounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"8B30D897-369F-4E7E-A765-954CCE13C79B", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        super.onInit();
    }
}

