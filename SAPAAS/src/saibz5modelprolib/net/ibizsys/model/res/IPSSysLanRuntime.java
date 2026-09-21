/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysLan
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.model.res.IPSSysLan;

public interface IPSSysLanRuntime
extends IPSSysLan {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSAppLan var3) throws Exception;
}

