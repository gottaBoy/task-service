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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubDEModel;

public abstract class PSSysSFPubDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysSFPubDEModel pSSysSFPubDEModel;

    public PSSysSFPubDR1CounterHandlerBase() {
        this.setId("529F5786-E2AD-446D-B028-BFCB53D887E3");
        this.setName("\u7cfb\u7edf\u670d\u52a1\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysSFPubDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"529F5786-E2AD-446D-B028-BFCB53D887E3", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSSYSSFCODESCNT", "");
        this.registerCounterItem("PSSYSSFPUBPKGSCNT", "");
        super.onInit();
    }

    protected PSSysSFPubDEModel getPSSysSFPubDEModel() throws Exception {
        if (this.pSSysSFPubDEModel == null) {
            this.pSSysSFPubDEModel = (PSSysSFPubDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubDEModel");
        }
        return this.pSSysSFPubDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysSFPubDEModel();
    }
}

