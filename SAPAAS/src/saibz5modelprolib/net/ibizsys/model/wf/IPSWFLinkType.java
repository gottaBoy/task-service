/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFLink
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.wf.IPSWFLink;

public interface IPSWFLinkType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSWFLinkType var2) throws Exception;

    public IPSWFLink createPSWFLink(PSWFLink var1) throws Exception;
}

