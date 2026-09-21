/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.wf.IPSWFRole
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.wf.IPSWFRole;

public interface IPSWFRoleRuntime
extends IPSWFRole {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSWFRole var3) throws Exception;

    public String getCodeName();
}

