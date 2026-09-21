/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysEditorStyle
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSSysEditorStyleRuntime
extends IPSSysEditorStyle {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysEditorStyle var3) throws Exception;

    public IPSSysPFPlugin getPSSysPFPlugin();
}

