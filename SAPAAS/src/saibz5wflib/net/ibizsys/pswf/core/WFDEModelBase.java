/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionSupporter
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFDEModel
 *  net.ibizsys.pswf.core.IWFModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFDEModel;
import net.ibizsys.pswf.core.IWFModel;

public abstract class WFDEModelBase
implements IWFDEModel {
    private IWFModel iWFModel = null;
    private String strWFStepField = "";
    private String strWFStateField = "";
    private String strUDStateField = "";
    private String strWFInstField = "";
    private String strEntityWFState = "";
    private String strWFActorsField = "";
    private String strWFRetField = "";
    private String strWFVerField = "";
    private String strId = "";
    private String strName = "";
    private String strWorkflowId = "";
    private String strWFStartName = "";
    private String strWorkflowField = "";
    private String strWFMode = "";

    public String getWFStepField() {
        return this.strWFStepField;
    }

    protected void setWFStepField(String strWFStepField) {
        this.strWFStepField = strWFStepField;
    }

    public String getWFStateField() {
        return this.strWFStateField;
    }

    protected void setWFStateField(String strWFStateField) {
        this.strWFStateField = strWFStateField;
    }

    public String getUDStateField() {
        return this.strUDStateField;
    }

    protected void setUDStateField(String strUDStateField) {
        this.strUDStateField = strUDStateField;
    }

    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }

    public String getId() {
        return this.strId;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    public String getName() {
        return this.strName;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public String getWorkflowId() {
        return this.strWorkflowId;
    }

    protected void setWorkflowId(String strWorkflowId) {
        this.strWorkflowId = strWorkflowId;
    }

    public String getWFInstField() {
        return this.strWFInstField;
    }

    public String getEntityWFState() {
        if (StringHelper.isNullOrEmpty((String)this.strEntityWFState)) {
            return this.getWFModel().getEntityWFState();
        }
        return this.strEntityWFState;
    }

    public void setWFInstField(String strWFInstField) {
        this.strWFInstField = strWFInstField;
    }

    public void setEntityWFState(String strEntityWFState) {
        this.strEntityWFState = strEntityWFState;
    }

    public String getWFActorsField() {
        return this.strWFActorsField;
    }

    public void setWFActorsField(String strWFActorsField) {
        this.strWFActorsField = strWFActorsField;
    }

    public boolean testDataInWF(IEntity iEntity) throws Exception {
        String strValue;
        if (!iEntity.contains(this.getUDStateField()) && iEntity instanceof IEntityActionSupporter && ((IEntityActionSupporter)iEntity).getActionHelper() != null) {
            ((IEntityActionSupporter)iEntity).get(true);
        }
        return StringHelper.compare((String)(strValue = DataObject.getStringValue((IDataObject)iEntity, (String)this.getUDStateField(), null)), (String)this.getEntityWFState(), (boolean)false) == 0;
    }

    public String getWFRetField() {
        return this.strWFRetField;
    }

    protected void setWFRetField(String strWFRetField) {
        this.strWFRetField = strWFRetField;
    }

    public String getWFStartName() {
        return this.strWFStartName;
    }

    protected void setWFStartName(String strWFStartName) {
        this.strWFStartName = strWFStartName;
    }

    public String getWFVerField() {
        return this.strWFVerField;
    }

    protected void setWFVerField(String strWFVerField) {
        this.strWFVerField = strWFVerField;
    }

    public String getWorkflowField() {
        return this.strWorkflowField;
    }

    protected void setWorkflowField(String strWorkflowField) {
        this.strWorkflowField = strWorkflowField;
    }

    public String getWFMode() {
        return this.strWFMode;
    }

    protected void setWFMode(String strWFMode) {
        this.strWFMode = strWFMode;
    }
}

