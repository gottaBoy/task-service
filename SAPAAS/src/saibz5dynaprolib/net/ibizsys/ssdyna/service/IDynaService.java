/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.saas.service.ISaaSService
 */
package net.ibizsys.ssdyna.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.service.ISaaSService;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public interface IDynaService<ET extends IEntity>
extends ISaaSService<ET> {
    public void init(IDynaDEModel<ET> var1) throws Exception;

    public boolean isDynaDETemplMode();
}

