/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFVersion
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFVersion;

public interface IPSWFLinkRuntime
extends IPSWFLink {
    public void init(IPSModelStorageContext var1, IPSWFVersion var2, PSWFLink var3) throws Exception;
}

