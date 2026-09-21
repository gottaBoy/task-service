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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDEModel;

public abstract class PSSysReqItemDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysReqItemDEModel pSSysReqItemDEModel;

    public PSSysReqItemDR1CounterHandlerBase() {
        this.setId("BD52D376-DEEE-4300-AF1B-DB4A8C339B18");
        this.setName("\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysReqItemDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"BD52D376-DEEE-4300-AF1B-DB4A8C339B18", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSREQITEMDATASCNT", "");
        super.onInit();
    }

    protected PSSysReqItemDEModel getPSSysReqItemDEModel() throws Exception {
        if (this.pSSysReqItemDEModel == null) {
            this.pSSysReqItemDEModel = (PSSysReqItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDEModel");
        }
        return this.pSSysReqItemDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysReqItemDEModel();
    }
}

