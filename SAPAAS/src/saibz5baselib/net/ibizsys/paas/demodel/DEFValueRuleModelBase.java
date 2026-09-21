/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEFValueRuleModel;

public abstract class DEFValueRuleModelBase
extends ModelBase3Impl
implements IDEFValueRuleModel {
    private IDataEntity iDataEntity = null;
    private IDEField iDEField = null;

    public void init() throws Exception {
    }

    public void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public IDEField getDEField() {
        return this.iDEField;
    }

    public void setDEField(IDEField iDEField) {
        this.iDEField = iDEField;
    }
}

