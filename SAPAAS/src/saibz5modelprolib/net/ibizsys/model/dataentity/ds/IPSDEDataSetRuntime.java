/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 */
package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.entity.PSDEDataSet;

public interface IPSDEDataSetRuntime
extends IPSDEDataSet {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEDataSet var3) throws Exception;
}

