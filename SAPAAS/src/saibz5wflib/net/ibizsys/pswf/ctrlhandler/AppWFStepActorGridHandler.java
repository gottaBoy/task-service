/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psrt.srv.wf.entity.WFStepActor
 *  net.ibizsys.psrt.srv.wf.service.WFStepActorService
 */
package net.ibizsys.pswf.ctrlhandler;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.pswf.ctrlhandler.WFStepActorGridHandlerBase;
import net.ibizsys.pswf.ctrlmodel.AppWFStepActorGridModel;

public class AppWFStepActorGridHandler
extends WFStepActorGridHandlerBase {
    protected AppWFStepActorGridModel gridModel = null;

    protected void onInit() throws Exception {
        this.gridModel = (AppWFStepActorGridModel)this.getViewController().getCtrlModel("grid");
        super.onInit();
    }

    protected IGridModel getGridModel() {
        return this.getRealGridModel();
    }

    protected AppWFStepActorGridModel getRealGridModel() {
        return this.gridModel;
    }

    protected WFStepActorService getRealService() {
        return (WFStepActorService)this.getService();
    }

    protected void prepareDataAccessActions() throws Exception {
        super.prepareDataAccessActions();
        this.registerDataAccessAction("update", "UPDATE");
        this.registerDataAccessAction("remove", "DELETE");
        this.registerDataAccessAction("loaddraft", "CREATE");
        this.registerDataAccessAction("load", "READ");
        this.registerDataAccessAction("create", "CREATE");
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
        return this.getRealService().fetchDefault((IDEDataSetFetchContext)deDataSetFetchContext);
    }

    protected IEntity getDraftEntity() throws Exception {
        WFStepActor entity = new WFStepActor();
        this.getDraftEntity(entity);
        return entity;
    }

    protected void getDraftEntity(WFStepActor entity) throws Exception {
        this.getRealService().executeAction("GETDRAFT", (IEntity)entity);
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        WFStepActor entity = new WFStepActor();
        entity.set("WFSTEPACTORID", objKeyValue);
        this.getRealService().executeAction("GET", (IEntity)entity);
        return entity;
    }

    protected IEntity createEntity(IEntity iEntity) throws Exception {
        this.getRealService().executeAction("CREATE", iEntity);
        return iEntity;
    }

    protected IEntity updateEntity(IEntity iEntity) throws Exception {
        this.getRealService().executeAction("UPDATE", iEntity);
        return iEntity;
    }

    protected void removeEntity(Object objKeyValue) throws Exception {
        WFStepActor entity = new WFStepActor();
        entity.set("WFSTEPACTORID", objKeyValue);
        this.getRealService().executeAction("REMOVE", (IEntity)entity);
    }
}

