/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFRole
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public interface IDynaWFRoleModel
extends IWFRoleModel {
    public IDynaSysModel getDynaSysModel();

    public IPSWFRole getPSWFRole();
}

