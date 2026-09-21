/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFVersion;

public interface IPSWFProcessRuntime
extends IPSWFProcess {
    public void init(IPSModelStorageContext var1, IPSWFVersion var2, PSWFProcess var3) throws Exception;
}

