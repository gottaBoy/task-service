/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFLinkCond
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFLinkCond;

public interface IPSWFLinkCondRuntime
extends IPSWFLinkCond {
    public void init(IPSModelStorageContext var1, IPSWFLink var2, IPSWFLinkCond var3, PSWFLinkCond var4) throws Exception;
}

