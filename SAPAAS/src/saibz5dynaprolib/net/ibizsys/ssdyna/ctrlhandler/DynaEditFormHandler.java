/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEEditFormHandler
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IEditFormModel
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.ssdyna.ctrlhandler;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditFormHandler;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaEditFormHandler
extends EditFormHandlerBase
implements IDynaCtrlHandler {
    private IPSControl iPSControl = null;
    private IDynaCtrlModel iDynaCtrlModel = null;
    private IPSDEEditFormHandler iPSDEEditFormHandler = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        if (this.getPSDEForm().getPSAjaxControlHandler() != null) {
            this.iPSDEEditFormHandler = (IPSDEEditFormHandler)this.getPSDEForm().getPSAjaxControlHandler();
        }
        this.iDynaCtrlModel = (IDynaCtrlModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected IEditFormModel getEditFormModel() {
        return (IEditFormModel)this.iDynaCtrlModel;
    }

    public IPSDEForm getPSDEForm() {
        return (IPSDEForm)this.getPSControl();
    }

    public IPSDEEditFormHandler getPSDEEditFormHandler() {
        return this.iPSDEEditFormHandler;
    }

    protected void prepareDataAccessActions() throws Exception {
        super.prepareDataAccessActions();
        if (this.getPSDEEditFormHandler() != null) {
            Iterator ajaxActions = this.getPSDEEditFormHandler().getAjaxActions();
            while (ajaxActions.hasNext()) {
                this.registerDataAccessAction((String)ajaxActions.next(), "NONE");
            }
        }
    }

    protected void prepareCtrlItemHandlers() throws Exception {
        super.prepareCtrlItemHandlers();
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("load");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.getEntity(objKeyValue);
        }
        IEntity entity = this.getDEModel().createEntity();
        entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
        this.getService().executeAction(strDEActionName.toUpperCase(), entity);
        return entity;
    }

    protected String getGetEntityAction() {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("load");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.getGetEntityAction();
        }
        return strDEActionName.toUpperCase();
    }

    protected IEntity updateEntity(IEntity iEntity) throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("update");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.updateEntity(iEntity);
        }
        this.getService().executeAction(strDEActionName.toUpperCase(), iEntity);
        return iEntity;
    }

    protected IEntity getDraftEntity() throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("loaddraft");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.getDraftEntity();
        }
        IEntity entity = this.getDEModel().createEntity();
        this.fillDefaultValues((IDataObject)entity, false);
        this.getService().executeAction(strDEActionName.toUpperCase(), entity);
        return entity;
    }

    protected IEntity getDraftEntityFrom(Object objKeyValue) throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("loaddraftfrom");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.getDraftEntityFrom(objKeyValue);
        }
        IEntity entity = this.getDEModel().createEntity();
        entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
        this.getService().executeAction(strDEActionName.toUpperCase(), entity);
        return entity;
    }

    protected IEntity createEntity(IEntity iEntity) throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("create");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            return super.createEntity(iEntity);
        }
        this.getService().executeAction(strDEActionName.toUpperCase(), iEntity);
        return iEntity;
    }

    protected void removeEntity(Object objKeyValue) throws Exception {
        String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("remove");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            super.removeEntity(objKeyValue);
            return;
        }
        IEntity entity = this.getDEModel().createEntity();
        entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
        this.getService().executeAction(strDEActionName.toUpperCase(), entity);
    }

    public int getTempMode() {
        if (this.getPSDEEditFormHandler().getTempMode() > 0) {
            return this.getPSDEEditFormHandler().getTempMode();
        }
        return super.getTempMode();
    }
}

