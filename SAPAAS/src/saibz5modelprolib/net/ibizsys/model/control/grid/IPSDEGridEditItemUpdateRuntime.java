/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.entity.PSDEGEIUpdate;

public interface IPSDEGridEditItemUpdateRuntime
extends IPSDEGridEditItemUpdate {
    public void init(IPSModelStorageContext var1, IPSDEGrid var2, PSDEGEIUpdate var3) throws Exception;
}

