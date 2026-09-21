/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.dr.IPSDRItemType;
import net.ibizsys.model.entity.PSDRItemType;

public interface IPSDRItemTypeRuntime
extends IPSDRItemType {
    public void init(IPSModelStorageContext var1, PSDRItemType var2) throws Exception;
}

