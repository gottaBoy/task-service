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
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel;

public abstract class PSWXEntAppDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSWXEntAppDEModel pSWXEntAppDEModel;

    public PSWXEntAppDR1CounterHandlerBase() {
        this.setId("054C1B55-F76D-47BF-8CB5-1E707B45EEE0");
        this.setName("\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSWXEntAppDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"054C1B55-F76D-47BF-8CB5-1E707B45EEE0", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSWXLOGICSCNT", "");
        this.registerCounterItem("PSWXMENUFUNCSCNT", "");
        this.registerCounterItem("PSWXMENUSCNT", "");
        super.onInit();
    }

    protected PSWXEntAppDEModel getPSWXEntAppDEModel() throws Exception {
        if (this.pSWXEntAppDEModel == null) {
            this.pSWXEntAppDEModel = (PSWXEntAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel");
        }
        return this.pSWXEntAppDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSWXEntAppDEModel();
    }
}

