/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup
 */
package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;

public interface IPSWFUIActionGroupRuntime
extends IPSWFUIActionGroup {
    public void init(IPSModelStorageContext var1, IPSWFVersion var2, PSDEUIActionGroup var3) throws Exception;
}

