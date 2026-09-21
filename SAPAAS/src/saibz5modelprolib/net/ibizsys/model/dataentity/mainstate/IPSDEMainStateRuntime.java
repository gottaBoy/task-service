/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.entity.PSDEMainState;

public interface IPSDEMainStateRuntime
extends IPSDEMainState {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEMainState var3) throws Exception;
}

