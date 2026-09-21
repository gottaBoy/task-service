/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFLinkCond
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFLinkCondType;
import net.ibizsys.model.wf.IPSWFLinkCond;

public interface IPSWFLinkCondType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSWFLinkCondType var2) throws Exception;

    public IPSWFLinkCond createPSWFLinkCond(PSWFLinkCond var1) throws Exception;
}

