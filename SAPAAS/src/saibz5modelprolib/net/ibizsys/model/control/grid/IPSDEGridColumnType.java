/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumnType;

public interface IPSDEGridColumnType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSDEGridColumnType var2) throws Exception;

    public IPSDEGridColumn createPSDEGridColumn(PSDEGridColumn var1) throws Exception;
}

