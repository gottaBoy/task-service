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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel;

public abstract class PSDEViewBaseDRCounter1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDEViewBaseDEModel pSDEViewBaseDEModel;

    public PSDEViewBaseDRCounter1CounterHandlerBase() {
        this.setId("FCDAECE5-21F0-4898-8B9A-D35149A6D5CD");
        this.setName("\u5b9e\u4f53\u89c6\u56fe\u5173\u7cfb\u6570\u636e\u8ba1\u6570\u566801");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDEViewBaseDRCounter1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"FCDAECE5-21F0-4898-8B9A-D35149A6D5CD", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSAPPVIEWCNT", "");
        super.onInit();
    }

    protected PSDEViewBaseDEModel getPSDEViewBaseDEModel() throws Exception {
        if (this.pSDEViewBaseDEModel == null) {
            this.pSDEViewBaseDEModel = (PSDEViewBaseDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel");
        }
        return this.pSDEViewBaseDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDEViewBaseDEModel();
    }
}

