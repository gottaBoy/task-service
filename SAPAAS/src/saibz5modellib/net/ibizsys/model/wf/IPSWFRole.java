/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.pswf.core.IWFRoleModel;

public interface IPSWFRole
extends IPSSystemObject,
IWFRoleModel {
    public String getLogicName();

    public String getUserData();

    public String getUserData2();

    public String getWFRoleSN();
}

