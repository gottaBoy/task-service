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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel;

public abstract class PSWFVersionDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSWFVersionDEModel pSWFVersionDEModel;

    public PSWFVersionDR1CounterHandlerBase() {
        this.setId("CAD79E32-3AD0-477C-A654-994D85B54526");
        this.setName("\u5de5\u4f5c\u6d41\u7248\u672c\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSWFVersionDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"CAD79E32-3AD0-477C-A654-994D85B54526", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDEUAGROUPSCNT", "");
        this.registerCounterItem("PSDEUIACTIONSCNT", "");
        super.onInit();
    }

    protected PSWFVersionDEModel getPSWFVersionDEModel() throws Exception {
        if (this.pSWFVersionDEModel == null) {
            this.pSWFVersionDEModel = (PSWFVersionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel");
        }
        return this.pSWFVersionDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSWFVersionDEModel();
    }
}

