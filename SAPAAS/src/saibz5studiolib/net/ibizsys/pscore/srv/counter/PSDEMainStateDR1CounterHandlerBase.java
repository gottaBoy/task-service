/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.CounterGlobal
 *  net.ibizsys.paas.ctrlhandler.DRCounterHandlerBase
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 */
package net.ibizsys.pscore.srv.counter;

import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.DRCounterHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateDEModel;

public abstract class PSDEMainStateDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDEMainStateDEModel pSDEMainStateDEModel;

    public PSDEMainStateDR1CounterHandlerBase() {
        this.setId("7FA825E2-B09E-45E3-8132-12D5D26A058B");
        this.setName("\u5b9e\u4f53\u4e3b\u72b6\u6001\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDEMainStateDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"7FA825E2-B09E-45E3-8132-12D5D26A058B", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    protected PSDEMainStateDEModel getPSDEMainStateDEModel() throws Exception {
        if (this.pSDEMainStateDEModel == null) {
            this.pSDEMainStateDEModel = (PSDEMainStateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateDEModel");
        }
        return this.pSDEMainStateDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDEMainStateDEModel();
    }
}

