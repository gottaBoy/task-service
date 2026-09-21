/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psrt.srv.wf.entity.WFStepData
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 */
package net.ibizsys.pswf.ctrlhandler;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.pswf.ctrlhandler.WFStepDataGridHandlerBase;
import net.ibizsys.pswf.ctrlmodel.AppWFStepDataGridModel;

public class ActiveWFStepDataGridHandler
extends WFStepDataGridHandlerBase {
    protected AppWFStepDataGridModel gridModel = null;

    protected void onInit() throws Exception {
        this.gridModel = (AppWFStepDataGridModel)this.getViewController().getCtrlModel("grid");
        super.onInit();
    }

    protected IGridModel getGridModel() {
        return this.getRealGridModel();
    }

    protected AppWFStepDataGridModel getRealGridModel() {
        return this.gridModel;
    }

    protected WFStepDataService getRealService() {
        return (WFStepDataService)this.getService();
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
        WFStepData entity = new WFStepData();
        this.getDraftEntity(entity);
        return entity;
    }

    protected void getDraftEntity(WFStepData entity) throws Exception {
        this.getRealService().executeAction("GETDRAFT", (IEntity)entity);
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        WFStepData entity = new WFStepData();
        entity.set("WFSTEPDATAID", objKeyValue);
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
        WFStepData entity = new WFStepData();
        entity.set("WFSTEPDATAID", objKeyValue);
        this.getRealService().executeAction("REMOVE", (IEntity)entity);
    }
}

