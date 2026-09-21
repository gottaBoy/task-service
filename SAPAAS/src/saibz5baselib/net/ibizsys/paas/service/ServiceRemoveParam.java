/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceRemoveParam;
import net.ibizsys.paas.service.ServiceActionParamBase;

public class ServiceRemoveParam<ET extends IEntity>
extends ServiceActionParamBase<ET>
implements IServiceRemoveParam<ET> {
    private boolean bPrepareLast = false;

    @Override
    public boolean isPrepareLast() {
        return this.bPrepareLast;
    }

    public void setPrepareLast(boolean bPrepareLast) {
        this.bPrepareLast = bPrepareLast;
    }
}

