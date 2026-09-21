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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel;

public abstract class PSDERDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDERDEModel pSDERDEModel;

    public PSDERDR1CounterHandlerBase() {
        this.setId("293C747B-A732-4178-9AD6-7757E4262BF9");
        this.setName("\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDERDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"293C747B-A732-4178-9AD6-7757E4262BF9", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDEDRITEMSCNT", "");
        this.registerCounterItem("PSDEFIELDSCNT", "");
        this.registerCounterItem("PSDEOPPRIVSCNT", "");
        this.registerCounterItem("PSDERDEFMAPSCNT", "");
        super.onInit();
    }

    protected PSDERDEModel getPSDERDEModel() throws Exception {
        if (this.pSDERDEModel == null) {
            this.pSDERDEModel = (PSDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel");
        }
        return this.pSDERDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDERDEModel();
    }
}

