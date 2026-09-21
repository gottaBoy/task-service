/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.IEditFormModel
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.Control.Form.IPSDEEditFormHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITWFEditFormHandler
extends WFEditFormHandlerBase
implements IPSJITCtrlHandler {
    private IPSControl iPSControl = null;
    private static final Log log = LogFactory.getLog(PSJITWFEditFormHandler.class);
    private IEditFormModel iEditFormModel = null;
    private IPSDEEditFormHandler iPSDEEditFormHandler = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
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
            Iterator<String> ajaxActions = this.getPSDEEditFormHandler().getAjaxActions();
            while (ajaxActions.hasNext()) {
                this.registerDataAccessAction(ajaxActions.next(), "NONE");
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

