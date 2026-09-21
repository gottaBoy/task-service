/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dynasys.IPSDynaInst
 */
package net.ibizsys.model.dynasys;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.entity.PSDynaInst;

public interface IPSDynaInstRuntime
extends IPSDynaInst {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSDynaInst var3) throws Exception;

    public IPSDynaInst getParentPSDynaInst() throws Exception;

    public IPSSystem getPSSystem();
}

