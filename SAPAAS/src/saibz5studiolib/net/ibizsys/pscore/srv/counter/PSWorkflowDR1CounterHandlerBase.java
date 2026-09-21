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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWorkflowDEModel;

public abstract class PSWorkflowDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSWorkflowDEModel pSWorkflowDEModel;

    public PSWorkflowDR1CounterHandlerBase() {
        this.setId("096A081D-D294-4DC9-B1F8-9D268A11CDF2");
        this.setName("\u7cfb\u7edf\u5de5\u4f5c\u6d41\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSWorkflowDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"096A081D-D294-4DC9-B1F8-9D268A11CDF2", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSWFDESCNT", "");
        this.registerCounterItem("PSWFVERSIONSCNT", "");
        super.onInit();
    }

    protected PSWorkflowDEModel getPSWorkflowDEModel() throws Exception {
        if (this.pSWorkflowDEModel == null) {
            this.pSWorkflowDEModel = (PSWorkflowDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWorkflowDEModel");
        }
        return this.pSWorkflowDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSWorkflowDEModel();
    }
}

