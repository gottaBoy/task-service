/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.service.ServiceActionParamBase;

public class ServiceUpdateParam<ET extends IEntity>
extends ServiceActionParamBase<ET>
implements IServiceUpdateParam<ET> {
    private boolean bPrepareLast = false;
    private boolean bReturnData = true;
    private boolean bSysUpdate = false;

    @Override
    public boolean isReturnData() {
        return this.bReturnData;
    }

    @Override
    public boolean isPrepareLast() {
        return this.bPrepareLast;
    }

    public void setPrepareLast(boolean bPrepareLast) {
        this.bPrepareLast = bPrepareLast;
    }

    public void setReturnData(boolean bReturnData) {
        this.bReturnData = bReturnData;
    }

    @Override
    public boolean isSysUpdate() {
        return this.bSysUpdate;
    }

    public void setSysUpdate(boolean bSysUpdate) {
        this.bSysUpdate = bSysUpdate;
    }
}

