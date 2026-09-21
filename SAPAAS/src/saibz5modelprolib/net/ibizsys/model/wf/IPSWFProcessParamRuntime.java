/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFProcessParam
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessParam;

public interface IPSWFProcessParamRuntime
extends IPSWFProcessParam {
    public void init(IPSModelStorageContext var1, IPSWFProcess var2, PSWFProcParam var3) throws Exception;
}

