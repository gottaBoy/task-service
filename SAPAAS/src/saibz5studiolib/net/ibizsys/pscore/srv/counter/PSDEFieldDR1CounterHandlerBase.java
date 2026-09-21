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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel;

public abstract class PSDEFieldDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDEFieldDEModel pSDEFieldDEModel;

    public PSDEFieldDR1CounterHandlerBase() {
        this.setId("0DBFC407-CD84-49AB-B4D6-C63364ABA9A9");
        this.setName("\u5b9e\u4f53\u5c5e\u6027\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDEFieldDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"0DBFC407-CD84-49AB-B4D6-C63364ABA9A9", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDEFDTCOLSCNT", "");
        this.registerCounterItem("PSDEFUIMODESCNT", "");
        this.registerCounterItem("PSDEFIELDSCNT", "");
        this.registerCounterItem("PSDEFINPUTTIPSCNT", "");
        this.registerCounterItem("PSDEFSFITEMSCNT", "");
        this.registerCounterItem("PSDEFVALUERULESCNT", "");
        this.registerCounterItem("PSSYSTESTCASESCNT", "");
        super.onInit();
    }

    protected PSDEFieldDEModel getPSDEFieldDEModel() throws Exception {
        if (this.pSDEFieldDEModel == null) {
            this.pSDEFieldDEModel = (PSDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel");
        }
        return this.pSDEFieldDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDEFieldDEModel();
    }
}

