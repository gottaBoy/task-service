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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCModelTemplDEModel;

public abstract class PSDCModelTemplDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDCModelTemplDEModel pSDCModelTemplDEModel;

    public PSDCModelTemplDR1CounterHandlerBase() {
        this.setId("5B34442A-B0BC-4674-8CF9-EA0638898622");
        this.setName("\u4e91\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u6a21\u677f\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDCModelTemplDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"5B34442A-B0BC-4674-8CF9-EA0638898622", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSDCMTDEFSCNT", "");
        super.onInit();
    }

    protected PSDCModelTemplDEModel getPSDCModelTemplDEModel() throws Exception {
        if (this.pSDCModelTemplDEModel == null) {
            this.pSDCModelTemplDEModel = (PSDCModelTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCModelTemplDEModel");
        }
        return this.pSDCModelTemplDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDCModelTemplDEModel();
    }
}

