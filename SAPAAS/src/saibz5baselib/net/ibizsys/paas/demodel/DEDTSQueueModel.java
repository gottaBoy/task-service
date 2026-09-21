/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEDTSQueueModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.sysmodel.ISystemModel;

public class DEDTSQueueModel
extends ModelBase3Impl
implements IDEDTSQueueModel {
    private IDataEntity iDataEntity = null;
    private boolean bDefault = false;
    private ISystemModel iSystemModel = null;
    private IDTSQueueModel iDTSQueueModel = null;

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
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public IDTSQueueModel getDTSQueueModel() throws Exception {
        if (this.iDTSQueueModel == null) {
            this.iDTSQueueModel = this.iSystemModel.getDTSQueueModel(this.getId());
        }
        return this.iDTSQueueModel;
    }
}

