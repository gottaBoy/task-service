/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 */
package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.view.IPSUIActionRuntime;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;

public interface IPSWFUIActionRuntime
extends IPSWFUIAction,
IPSUIActionRuntime {
    public void init(IPSModelStorageContext var1, IPSWFVersion var2, PSDEUIAction var3) throws Exception;
}

