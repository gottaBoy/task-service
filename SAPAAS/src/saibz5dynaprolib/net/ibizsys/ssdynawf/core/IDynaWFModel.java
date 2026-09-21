/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.sswf.core.ISaaSWFModel
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.sswf.core.ISaaSWFModel;

public interface IDynaWFModel
extends ISaaSWFModel {
    public IDynaSysModel getDynaSysModel();

    public IPSWorkflow getPSWorkflow();
}

