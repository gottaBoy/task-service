/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

public interface IDynamicDEModel<ET extends IEntity>
extends IDataEntityModel<ET> {
    public void init(ISystemModel var1, DataEntity var2) throws Exception;
}

