/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.entity.PSDEGEIUDetail;

public interface IPSDEGEIUpdateDetailRuntime
extends IPSDEGEIUpdateDetail {
    public void init(IPSModelStorageContext var1, IPSDEGridEditItemUpdate var2, PSDEGEIUDetail var3) throws Exception;
}

