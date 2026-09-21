/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateOPPriv;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;

public interface IPSDEMainStateOPPrivRuntime
extends IPSDEMainStateOPPriv {
    public void init(IPSModelStorageContext var1, IPSDEMainState var2, PSDEMainStateOPPriv var3) throws Exception;
}

