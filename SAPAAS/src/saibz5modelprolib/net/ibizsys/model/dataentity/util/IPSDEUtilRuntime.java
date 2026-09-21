/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.util.IPSDEUtil
 */
package net.ibizsys.model.dataentity.util;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.util.IPSDEUtil;
import net.ibizsys.model.entity.PSDEUtil;

public interface IPSDEUtilRuntime
extends IPSDEUtil {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEUtil var3) throws Exception;
}

