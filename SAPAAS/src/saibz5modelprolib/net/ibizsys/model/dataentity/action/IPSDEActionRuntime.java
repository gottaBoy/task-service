/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.entity.PSDEAction;

public interface IPSDEActionRuntime
extends IPSDEAction {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEAction var3) throws Exception;
}

