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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel;

public abstract class PSSysAppDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSSysAppDEModel pSSysAppDEModel;

    public PSSysAppDR1CounterHandlerBase() {
        this.setId("58B34686-AA1D-4782-B9BC-FA38BA5E11A9");
        this.setName("\u7cfb\u7edf\u5e94\u7528\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSSysAppDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"58B34686-AA1D-4782-B9BC-FA38BA5E11A9", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSAPPEDITORTEMPLSCNT", "");
        this.registerCounterItem("PSAPPFUNCSCNT", "");
        this.registerCounterItem("PSAPPMENUSCNT", "");
        this.registerCounterItem("PSAPPMODULESCNT", "");
        this.registerCounterItem("PSAPPPKGSCNT", "");
        this.registerCounterItem("PSAPPTITLEBARSCNT", "");
        this.registerCounterItem("PSAPPUITHEMESCNT", "");
        this.registerCounterItem("PSAPPUSERMODESCNT", "");
        this.registerCounterItem("PSAPPUTILPAGESCNT", "");
        this.registerCounterItem("PSAPPVIEWCODESCNT", "");
        this.registerCounterItem("PSAPPVIEWSCNT", "");
        this.registerCounterItem("PSSYSTASKSCNT", "");
        super.onInit();
    }

    protected PSSysAppDEModel getPSSysAppDEModel() throws Exception {
        if (this.pSSysAppDEModel == null) {
            this.pSSysAppDEModel = (PSSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel");
        }
        return this.pSSysAppDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSSysAppDEModel();
    }
}

