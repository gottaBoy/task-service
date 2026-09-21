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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel;

public abstract class PSDevSlnDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDevSlnDEModel pSDevSlnDEModel;

    public PSDevSlnDR1CounterHandlerBase() {
        this.setId("65BB2EA0-A524-458F-9D37-32974119307B");
        this.setName("\u5f00\u53d1\u65b9\u6848\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDevSlnDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"65BB2EA0-A524-458F-9D37-32974119307B", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDEVSLNMSDEPLOYSCNT", "");
        this.registerCounterItem("PSDEVSLNSYSSCNT", "");
        this.registerCounterItem("PSDEVSLNUSERSCNT", "");
        super.onInit();
    }

    protected PSDevSlnDEModel getPSDevSlnDEModel() throws Exception {
        if (this.pSDevSlnDEModel == null) {
            this.pSDevSlnDEModel = (PSDevSlnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnDEModel");
        }
        return this.pSDevSlnDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDevSlnDEModel();
    }
}

