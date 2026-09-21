/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 */
package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.entity.PSDEOPPriv;

public interface IPSDEOPPrivRuntime
extends IPSDEOPPriv {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSDEOPPriv var3) throws Exception;
}

