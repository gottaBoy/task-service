/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFProcessRole
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRole;

public interface IPSWFProcessRoleRuntime
extends IPSWFProcessRole {
    public void init(IPSModelStorageContext var1, IPSWFProcess var2, PSWFProcRole var3) throws Exception;
}

