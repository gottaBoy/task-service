/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEEditFormHandler
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.paas.ctrlmodel.IEditFormModel
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase
 *  net.ibizsys.sswf.api.SaaSWFActionParam
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdynawf.ctrlhandler;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditFormHandler;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFActionFormHandler
extends WFActionFormHandlerBase
implements IDynaCtrlHandler {
    private IPSControl iPSControl = null;
    private static final Log log = LogFactory.getLog(DynaWFActionFormHandler.class);
    private IEditFormModel iEditFormModel = null;
    private IPSDEEditFormHandler iPSDEEditFormHandler = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected void onInit() throws Exception {
        this.iEditFormModel = (IEditFormModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        if (this.getPSDEForm().getPSAjaxControlHandler() != null) {
            this.iPSDEEditFormHandler = (IPSDEEditFormHandler)this.getPSDEForm().getPSAjaxControlHandler();
        }
        super.onInit();
    }

    protected IEditFormModel getEditFormModel() {
        return this.iEditFormModel;
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

    protected WFActionParam createWFActionParam(IEntity entity, IEntity srcEntity) throws Exception {
        SaaSWFActionParam wfActionParam = new SaaSWFActionParam();
        String strAddStepType = DataObject.getStringValue((IDataObject)srcEntity, (String)"SRFADDSTEPTYPE", (String)"");
        if (!StringHelper.isNullOrEmpty((String)strAddStepType)) {
            wfActionParam.setAddStepType(strAddStepType);
            wfActionParam.setAppPersonId(DataObject.getStringValue((IDataObject)srcEntity, (String)"SRFAPPPERSONID", (String)""));
            wfActionParam.setAppPersonName(DataObject.getStringValue((IDataObject)srcEntity, (String)"SRFAPPPERSONNAME", (String)""));
            wfActionParam.setAppPersonList(DataObject.getStringValue((IDataObject)srcEntity, (String)"SRFAPPPERSONLIST", (String)""));
        }
        return wfActionParam;
    }
}

