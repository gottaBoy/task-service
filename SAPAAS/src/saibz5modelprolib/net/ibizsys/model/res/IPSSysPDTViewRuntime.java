/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysPDTView
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.res.IPSSysPDTView;

public interface IPSSysPDTViewRuntime
extends IPSSysPDTView {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysPDTView var3) throws Exception;
}

