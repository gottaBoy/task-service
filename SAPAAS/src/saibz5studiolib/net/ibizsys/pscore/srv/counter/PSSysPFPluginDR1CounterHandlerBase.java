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
import net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel;

public abstract class PSSysPFPluginDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysPFPluginDEModel pSSysPFPluginDEModel;

    public PSSysPFPluginDR1CounterHandlerBase() {
        this.setId("CA9AFD82-476C-4EAE-9B66-330BC57E8E8E");
        this.setName("\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysPFPluginDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"CA9AFD82-476C-4EAE-9B66-330BC57E8E8E", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSPFPITEMPLSCNT", "");
        super.onInit();
    }

    protected PSSysPFPluginDEModel getPSSysPFPluginDEModel() throws Exception {
        if (this.pSSysPFPluginDEModel == null) {
            this.pSSysPFPluginDEModel = (PSSysPFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel");
        }
        return this.pSSysPFPluginDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysPFPluginDEModel();
    }
}

