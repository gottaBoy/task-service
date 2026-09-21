/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridHandlerParam
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

public interface IPSDEGridParam
extends IPSMDAjaxControlParam,
IGridHandlerParam {
    public String getPSDEGridId();

    public Boolean isSingleSelect();

    public Boolean isEnableRowEdit();
}

