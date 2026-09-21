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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPluginDEModel;

public abstract class PSSysSFPluginDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysSFPluginDEModel pSSysSFPluginDEModel;

    public PSSysSFPluginDR1CounterHandlerBase() {
        this.setId("27F2D475-062A-44FC-AA89-D2D3EF531920");
        this.setName("\u7cfb\u7edf\u670d\u52a1\u63d2\u4ef6\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysSFPluginDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"27F2D475-062A-44FC-AA89-D2D3EF531920", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSSFPITEMPLSCNT", "");
        super.onInit();
    }

    protected PSSysSFPluginDEModel getPSSysSFPluginDEModel() throws Exception {
        if (this.pSSysSFPluginDEModel == null) {
            this.pSSysSFPluginDEModel = (PSSysSFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPluginDEModel");
        }
        return this.pSSysSFPluginDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysSFPluginDEModel();
    }
}

