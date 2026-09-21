/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSLanguageItem
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.res.IPSLanguageItem;

public interface IPSLanguageItemRuntime
extends IPSLanguageItem {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSLanguageItem var3) throws Exception;
}

