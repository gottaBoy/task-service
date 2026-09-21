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
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEModel;

public abstract class PSSysBDTableDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysBDTableDEModel pSSysBDTableDEModel;

    public PSSysBDTableDR1CounterHandlerBase() {
        this.setId("9C50C661-E119-42EF-A84A-7CADC36B0C89");
        this.setName("\u5927\u6570\u636e\u8868\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysBDTableDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"9C50C661-E119-42EF-A84A-7CADC36B0C89", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSBDCOLSETSCNT", "");
        this.registerCounterItem("PSSYSBDCOLUMNSCNT", "");
        this.registerCounterItem("PSSYSBDTABLEDERSCNT", "");
        this.registerCounterItem("PSSYSBDTABLEDESCNT", "");
        super.onInit();
    }

    protected PSSysBDTableDEModel getPSSysBDTableDEModel() throws Exception {
        if (this.pSSysBDTableDEModel == null) {
            this.pSSysBDTableDEModel = (PSSysBDTableDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEModel");
        }
        return this.pSSysBDTableDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysBDTableDEModel();
    }
}

