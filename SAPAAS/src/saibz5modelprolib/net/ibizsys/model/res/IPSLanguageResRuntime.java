/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSLanguageRes
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSLanguageResRuntime
extends IPSLanguageRes {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSLanguageRes var3) throws Exception;
}

