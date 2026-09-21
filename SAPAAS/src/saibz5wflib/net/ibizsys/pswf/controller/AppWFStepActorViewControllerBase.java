/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.ICtrlHandler
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel
 *  net.ibizsys.psrt.srv.wf.service.WFStepActorService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.pswf.controller.WFViewControllerBase;
import net.ibizsys.pswf.ctrlhandler.AppWFStepActorGridHandler;
import net.ibizsys.pswf.ctrlmodel.AppWFStepActorGridModel;
import org.hibernate.SessionFactory;

public abstract class AppWFStepActorViewControllerBase
extends WFViewControllerBase {
    private WFStepActorDEModel wFStepActorDEModel;

    public WFStepActorDEModel getWFStepActorDEModel() {
        if (this.wFStepActorDEModel == null) {
            try {
                this.wFStepActorDEModel = (WFStepActorDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepActorDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getWFStepActorDEModel();
    }

    public WFStepActorService getWFStepActorService() {
        try {
            return (WFStepActorService)ServiceGlobal.getService((String)"net.ibizsys.psrt.srv.wf.service.WFStepActorService", (SessionFactory)this.getSessionFactory());
        }
        catch (Exception ex) {
            return null;
        }
    }

    public IService getService() {
        return this.getWFStepActorService();
    }

    protected void prepareCtrlModels() throws Exception {
        AppWFStepActorGridModel grid = new AppWFStepActorGridModel();
        grid.init(this);
        this.registerCtrlModel("grid", (ICtrlModel)grid);
    }

    protected void prepareCtrlHandlers() throws Exception {
        AppWFStepActorGridHandler grid = new AppWFStepActorGridHandler();
        grid.init(this);
        this.registerCtrlHandler("grid", (ICtrlHandler)grid);
    }
}

