/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 */
package net.ibizsys.pscore.srv.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;

public interface IPSModelService<ET extends IEntity>
extends IService<ET> {
    public void initModel(String var1, IEntity var2, String var3) throws Exception;
}

