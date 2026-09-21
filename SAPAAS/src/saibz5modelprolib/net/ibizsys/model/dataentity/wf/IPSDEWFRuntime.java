/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 */
package net.ibizsys.model.dataentity.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSWFDE;

public interface IPSDEWFRuntime
extends IPSDEWF {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSWFDE var3) throws Exception;
}

