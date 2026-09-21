/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.security.IPSSysUniRes
 */
package net.ibizsys.model.security;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysUniRes;
import net.ibizsys.model.security.IPSSysUniRes;

public interface IPSSysUniResRuntime
extends IPSSysUniRes {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysUniRes var3) throws Exception;
}

