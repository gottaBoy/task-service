/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.cache.UniStateModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;

public class DEUniStateModel
extends UniStateModelBase {
    private IService iService = null;
    private IDataEntityModel iDEModel = null;

    @Override
    protected void onInit() throws Exception {
        this.iDEModel = this.getSystemModel().getDataEntityModel(this.getDEName());
        this.iService = this.iDEModel.getService();
        super.onInit();
    }

    @Override
    public IEntity update(Object objKey) throws Exception {
        this.testEnabled();
        Object iEntity = this.iDEModel.createEntity();
        iEntity.set(this.iDEModel.getKeyDEField().getName(), objKey);
        this.iService.get(iEntity);
        this.update((IEntity)iEntity);
        return iEntity;
    }

    @Override
    public IEntity get(Object objKey, boolean bForceUpdate) throws Exception {
        this.testEnabled();
        if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
            Object iEntity = this.iDEModel.createEntity();
            iEntity.set(this.iDEModel.getKeyDEField().getName(), objKey);
            if (this.getUniStateManager().getEntity(this, (IEntity)iEntity, bForceUpdate)) {
                return iEntity;
            }
            return null;
        }
        return this.update(objKey);
    }

    @Override
    public IEntity get(Object objKey) throws Exception {
        this.testEnabled();
        if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
            Object iEntity = this.iDEModel.createEntity();
            iEntity.set(this.iDEModel.getKeyDEField().getName(), objKey);
            if (this.getUniStateManager().getEntity(this, (IEntity)iEntity)) {
                return iEntity;
            }
            return null;
        }
        return this.update(objKey);
    }

    @Override
    public Object get(Object objKey, String strStateField) throws Exception {
        this.testEnabled();
        if (StringHelper.isNullOrEmpty(strStateField)) {
            if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
                return this.getUniStateManager().getEntityState(this, objKey, this.getStateField());
            }
            return this.update(objKey).get(this.getStateField());
        }
        if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
            return this.getUniStateManager().getEntityState(this, objKey, strStateField);
        }
        return this.update(objKey).get(strStateField);
    }

    @Override
    public Object get(Object objKey, String strStateField, boolean bForceUpdate) throws Exception {
        this.testEnabled();
        if (StringHelper.isNullOrEmpty(strStateField)) {
            if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
                return this.getUniStateManager().getEntityState(this, objKey, this.getStateField(), bForceUpdate);
            }
            return this.update(objKey).get(this.getStateField());
        }
        if (this.getUniStateManager().containsEntity((IUniState)this, objKey)) {
            return this.getUniStateManager().getEntityState(this, objKey, strStateField, bForceUpdate);
        }
        return this.update(objKey).get(strStateField);
    }

    @Override
    public String getUniStateType() {
        return "DE";
    }
}

