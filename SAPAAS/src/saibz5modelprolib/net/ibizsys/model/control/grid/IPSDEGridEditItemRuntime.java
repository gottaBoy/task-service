/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.dataentity.field.IPSDEField;

public interface IPSDEGridEditItemRuntime
extends IPSDEGridEditItem {
    public void init(IPSModelStorageContext var1, IPSDEGrid var2, IPSDEField var3) throws Exception;
}

