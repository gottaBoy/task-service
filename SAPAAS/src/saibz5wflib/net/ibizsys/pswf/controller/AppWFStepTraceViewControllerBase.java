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
 *  net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.pswf.controller.AppWFStepDataViewControllerBase;
import net.ibizsys.pswf.ctrlhandler.ActiveWFStepDataGridHandler;
import net.ibizsys.pswf.ctrlmodel.AppWFStepDataGridModel;
import org.hibernate.SessionFactory;

public abstract class AppWFStepTraceViewControllerBase
extends AppWFStepDataViewControllerBase {
    private WFStepDataDEModel wFStepDataDEModel;

    @Override
    public WFStepDataDEModel getWFStepDataDEModel() {
        if (this.wFStepDataDEModel == null) {
            try {
                this.wFStepDataDEModel = (WFStepDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDataDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFStepDataDEModel();
    }

    @Override
    public WFStepDataService getWFStepDataService() {
        try {
            return (WFStepDataService)ServiceGlobal.getService((String)"net.ibizsys.psrt.srv.wf.service.WFStepDataService", (SessionFactory)this.getSessionFactory());
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    public IService getService() {
        return this.getWFStepDataService();
    }

    @Override
    protected void prepareCtrlModels() throws Exception {
        AppWFStepDataGridModel grid = new AppWFStepDataGridModel();
        grid.init(this);
        this.registerCtrlModel("grid", (ICtrlModel)grid);
    }

    @Override
    protected void prepareCtrlHandlers() throws Exception {
        ActiveWFStepDataGridHandler grid = new ActiveWFStepDataGridHandler();
        grid.init(this);
        this.registerCtrlHandler("grid", (ICtrlHandler)grid);
    }
}

