/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.print.IPSDEPrint
 */
package net.ibizsys.model.dataentity.print;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.print.IPSDEPrint;
import net.ibizsys.model.entity.PSDEPrint;

public interface IPSDEPrintRuntime
extends IPSDEPrint {
    public void init(IPSModelStorageContext var1, IPSDataEntity var2, PSDEPrint var3) throws Exception;
}

