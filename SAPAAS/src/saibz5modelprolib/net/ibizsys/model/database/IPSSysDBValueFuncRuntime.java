/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysDBValueFunc
 */
package net.ibizsys.model.database;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysDBValueFunc;

public interface IPSSysDBValueFuncRuntime
extends IPSSysDBValueFunc {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysDBValueFunc var3) throws Exception;
}

