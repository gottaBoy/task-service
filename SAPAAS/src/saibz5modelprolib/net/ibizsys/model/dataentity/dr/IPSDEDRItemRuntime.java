/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.entity.PSDEDRItem;

public interface IPSDEDRItemRuntime
extends IPSDEDRItem {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEDRItem var3) throws Exception;
}

