/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction
 */
package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainStateAction;
import net.ibizsys.model.entity.PSDEMainStateAction;

public interface IPSDEMainStateActionRuntime
extends IPSDEMainStateAction {
    public void init(IPSModelStorageContext var1, IPSDEMainState var2, PSDEMainStateAction var3) throws Exception;
}

