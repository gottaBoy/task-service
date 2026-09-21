/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;

public interface IPSWFVersionRuntime
extends IPSWFVersion {
    public void init(IPSModelStorageContext var1, IPSWorkflow var2, PSWFVersion var3) throws Exception;
}

