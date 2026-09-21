/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.der.IPSDERBase
 */
package net.ibizsys.model.der;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.entity.PSDER;

public interface IPSDERRuntime
extends IPSDERBase {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, IPSDataEntity var3, PSDER var4) throws Exception;
}

