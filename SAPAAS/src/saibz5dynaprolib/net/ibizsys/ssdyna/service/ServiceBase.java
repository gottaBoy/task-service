/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.saas.service.ServiceBase
 */
package net.ibizsys.ssdyna.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.service.IDynaService;

public abstract class ServiceBase<ET extends IEntity>
extends net.ibizsys.saas.service.ServiceBase<ET>
implements IDynaService<ET> {
    @Override
    public void init(IDynaDEModel<ET> iDynaDEModel) throws Exception {
        throw new Exception("\u5f53\u524d\u5b9e\u4f53\u670d\u52a1\u5bf9\u8c61\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
    }

    @Override
    public boolean isDynaDETemplMode() {
        if (this.getDEModel() instanceof IDynaDEModel) {
            return ((IDynaDEModel)this.getDEModel()).isDynaDETemplMode();
        }
        return false;
    }
}

