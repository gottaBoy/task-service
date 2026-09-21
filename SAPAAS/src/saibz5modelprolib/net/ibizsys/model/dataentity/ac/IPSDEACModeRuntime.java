/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 */
package net.ibizsys.model.dataentity.ac;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.entity.PSDEACMode;

public interface IPSDEACModeRuntime
extends IPSDEACMode {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEACMode var3) throws Exception;
}

