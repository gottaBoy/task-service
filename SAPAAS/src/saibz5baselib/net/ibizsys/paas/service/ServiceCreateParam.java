/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.ServiceActionParamBase;

public class ServiceCreateParam<ET extends IEntity>
extends ServiceActionParamBase<ET>
implements IServiceCreateParam<ET> {
    private boolean bReturnData = true;

    @Override
    public boolean isReturnData() {
        return this.bReturnData;
    }

    public void setReturnData(boolean bReturnData) {
        this.bReturnData = bReturnData;
    }
}

