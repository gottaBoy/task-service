/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEUserRoleModel;
import net.ibizsys.paas.sysmodel.ISystemModel;

public class DEUserRoleModel
extends ModelBase3Impl
implements IDEUserRoleModel {
    private IDataEntity iDataEntity = null;
    private ISystemModel iSystemModel = null;
    private String strRoleTag = null;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = iDataEntity;
        this.iSystemModel = (ISystemModel)this.iDataEntity.getSystem();
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public String getRoleTag() {
        return this.strRoleTag;
    }

    public void setRoleTag(String strRoleTag) {
        this.strRoleTag = strRoleTag;
    }
}

