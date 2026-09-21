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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel;

public abstract class PSDEActionDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDEActionDEModel pSDEActionDEModel;

    public PSDEActionDR1CounterHandlerBase() {
        this.setId("8D15D5D7-4C52-42F6-B4F7-4B47FCF39EAB");
        this.setName("\u5b9e\u4f53\u884c\u4e3a\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDEActionDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"8D15D5D7-4C52-42F6-B4F7-4B47FCF39EAB", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDEACTIONLOGICSCNT", "");
        this.registerCounterItem("PSDEMSACTIONSCNT", "");
        this.registerCounterItem("PSSYSTESTCASESCNT", "");
        super.onInit();
    }

    protected PSDEActionDEModel getPSDEActionDEModel() throws Exception {
        if (this.pSDEActionDEModel == null) {
            this.pSDEActionDEModel = (PSDEActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel");
        }
        return this.pSDEActionDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDEActionDEModel();
    }
}

