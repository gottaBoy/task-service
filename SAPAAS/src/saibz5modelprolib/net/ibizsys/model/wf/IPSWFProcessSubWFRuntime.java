/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFEmbedWFProcessBase
 *  net.ibizsys.model.wf.IPSWFProcessSubWF
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.wf.IPSWFEmbedWFProcessBase;
import net.ibizsys.model.wf.IPSWFProcessSubWF;

public interface IPSWFProcessSubWFRuntime
extends IPSWFProcessSubWF {
    public void init(IPSModelStorageContext var1, IPSWFEmbedWFProcessBase var2, PSWFProcSubWF var3) throws Exception;
}

