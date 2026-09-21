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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDSchemeDEModel;

public abstract class PSSysBDSchemeDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysBDSchemeDEModel pSSysBDSchemeDEModel;

    public PSSysBDSchemeDR1CounterHandlerBase() {
        this.setId("0E8F21FE-4BA4-44B6-A688-539A42236441");
        this.setName("\u7cfb\u7edf\u5927\u6570\u636e\u67b6\u6784\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysBDSchemeDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"0E8F21FE-4BA4-44B6-A688-539A42236441", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSBDPARTSCNT", "");
        this.registerCounterItem("PSSYSBDTABLESCNT", "");
        super.onInit();
    }

    protected PSSysBDSchemeDEModel getPSSysBDSchemeDEModel() throws Exception {
        if (this.pSSysBDSchemeDEModel == null) {
            this.pSSysBDSchemeDEModel = (PSSysBDSchemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDSchemeDEModel");
        }
        return this.pSSysBDSchemeDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysBDSchemeDEModel();
    }
}

