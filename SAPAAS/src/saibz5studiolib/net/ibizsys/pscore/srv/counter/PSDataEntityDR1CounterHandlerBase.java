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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel;

public abstract class PSDataEntityDR1CounterHandlerBase
extends DRCounterHandlerBase {
    private PSDataEntityDEModel pSDataEntityDEModel;

    public PSDataEntityDR1CounterHandlerBase() {
        this.setId("1DE05412-118E-41B8-9F22-6BF1FDD6F31F");
        this.setName("\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u8ba1\u6570\u5668");
        CounterGlobal.registerCounterHandler((String)"net.ibizsys.pscore.srv.counter.PSDataEntityDR1CounterHandler", (ICounterHandler)this);
        CounterGlobal.registerCounterHandler((String)"1DE05412-118E-41B8-9F22-6BF1FDD6F31F", (ICounterHandler)this);
    }

    protected void onInit() throws Exception {
        this.registerCounterItem("PSACHANDLERSCNT", "");
        this.registerCounterItem("PSCODELISTSCNT", "");
        this.registerCounterItem("PSDEACMODESCNT", "");
        this.registerCounterItem("DSTPSDEACTIONLOGICSCNT", "");
        this.registerCounterItem("PSDEACTIONLOGICSCNT", "");
        this.registerCounterItem("PSDEAWSCNT", "");
        this.registerCounterItem("PSDEACTIONSCNT", "");
        this.registerCounterItem("PSDEAWGRPSCNT", "");
        this.registerCounterItem("PSDECHARTSCNT", "");
        this.registerCounterItem("PSDEDATAEXPSCNT", "");
        this.registerCounterItem("PSDEDATAIMPSCNT", "");
        this.registerCounterItem("PSDEDATAQUERYSCNT", "");
        this.registerCounterItem("PSDEDATARELATIONSCNT", "");
        this.registerCounterItem("PSDEDATASETSCNT", "");
        this.registerCounterItem("PSDEDATASYNCSCNT", "");
        this.registerCounterItem("PSDEDATAVIEWSCNT", "");
        this.registerCounterItem("PSDEDBCFGSCNT", "");
        this.registerCounterItem("PSDEDBINDEXSCNT", "");
        this.registerCounterItem("PSDEDRGROUPSCNT", "");
        this.registerCounterItem("PSDEDRITEMSCNT", "");
        this.registerCounterItem("PSDEDTSQUEUESCNT", "");
        this.registerCounterItem("PSDEFIELDSCNT", "");
        this.registerCounterItem("PSDEFORMSCNT", "");
        this.registerCounterItem("PSDEFSFITEMSCNT", "");
        this.registerCounterItem("PSDEFVALUERULESCNT", "");
        this.registerCounterItem("PSDEGRIDSCNT", "");
        this.registerCounterItem("PSDELISTSCNT", "");
        this.registerCounterItem("PSDELOGICSCNT", "");
        this.registerCounterItem("PSDEMAINSTATESCNT", "");
        this.registerCounterItem("SRCPSDEMAPSCNT", "");
        this.registerCounterItem("PSDEOPPRIVROLESCNT", "");
        this.registerCounterItem("PSDEOPPRIVSCNT", "");
        this.registerCounterItem("PSDEPRINTSCNT", "");
        this.registerCounterItem("PSDEREPORTSCNT", "");
        this.registerCounterItem("MAJORPSDERSCNT", "");
        this.registerCounterItem("MINORPSDERSCNT", "");
        this.registerCounterItem("PSDESERVICEAPISCNT", "");
        this.registerCounterItem("PSDETOOLBARSCNT", "");
        this.registerCounterItem("PSDETREEVIEWSCNT", "");
        this.registerCounterItem("PSDEUAGROUPSCNT", "");
        this.registerCounterItem("PSDEUIACTIONSCNT", "");
        this.registerCounterItem("PSDEUSERROLESCNT", "");
        this.registerCounterItem("PSDEVIEWBASESCNT", "");
        this.registerCounterItem("PSDEWIZARDSCNT", "");
        this.registerCounterItem("PSSYSBDTABLESCNT", "");
        this.registerCounterItem("PSSYSCOUNTERSCNT", "");
        this.registerCounterItem("PSSYSTASKSCNT", "");
        this.registerCounterItem("PSSYSTESTCASESCNT", "");
        this.registerCounterItem("PSSYSTESTDATASCNT", "");
        this.registerCounterItem("PSWFDESCNT", "");
        super.onInit();
    }

    protected PSDataEntityDEModel getPSDataEntityDEModel() throws Exception {
        if (this.pSDataEntityDEModel == null) {
            this.pSDataEntityDEModel = (PSDataEntityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel");
        }
        return this.pSDataEntityDEModel;
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getPSDataEntityDEModel();
    }
}

