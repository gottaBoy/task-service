/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFProcess
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.wf.IPSWFProcess;

public interface IPSWFProcessType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSWFProcessType var2) throws Exception;

    public IPSWFProcess createPSWFProcess(PSWFProcess var1) throws Exception;
}

