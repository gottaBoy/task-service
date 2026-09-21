/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEUniStateModel;
import net.ibizsys.paas.sysmodel.ISystemModel;

public class DEUniStateModel
extends ModelBase3Impl
implements IDEUniStateModel {
    private IDataEntity iDataEntity = null;
    private boolean bDefault = false;
    private ISystemModel iSystemModel = null;
    private IUniStateModel iUniStateModel = null;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = iDataEntity;
        this.iSystemModel = (ISystemModel)this.iDataEntity.getSystem();
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public boolean isDefault() {
        return this.bDefault;
    }

    public void setDefault(boolean bDefault) {
        this.bDefault = bDefault;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public IUniStateModel getUniStateModel() throws Exception {
        if (this.iUniStateModel == null) {
            this.iUniStateModel = this.iSystemModel.getUniStateModel(this.getId());
        }
        return this.iUniStateModel;
    }
}

