/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;

public interface IInheritDEServiceProxy<ET extends IEntity>
extends IService<ET> {
    public ET getReal(ET var1, boolean var2) throws Exception;

    public IService getRealService(ET var1) throws Exception;
}

