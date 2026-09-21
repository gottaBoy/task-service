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
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXAccountDEModel;

public abstract class PSWXAccountDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSWXAccountDEModel pSWXAccountDEModel;

    public PSWXAccountDR1CounterHandlerBase() {
        this.setId("4EFB93C7-0217-492B-9137-00A0152F052E");
        this.setName("\u5fae\u4fe1\u516c\u4f17\u53f7\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSWXAccountDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"4EFB93C7-0217-492B-9137-00A0152F052E", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSWXENTAPPSCNT", "");
        this.registerCounterItem("PSWXLOGICSCNT", "");
        this.registerCounterItem("PSWXMENUFUNCSCNT", "");
        this.registerCounterItem("PSWXMENUSCNT", "");
        super.onInit();
    }

    protected PSWXAccountDEModel getPSWXAccountDEModel() throws Exception {
        if (this.pSWXAccountDEModel == null) {
            this.pSWXAccountDEModel = (PSWXAccountDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXAccountDEModel");
        }
        return this.pSWXAccountDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSWXAccountDEModel();
    }
}

