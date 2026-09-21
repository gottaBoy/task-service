/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridHandlerParam
 */
package net.ibizsys.model.control.dataview;

import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

public interface IPSDEDataViewParam
extends IPSMDAjaxControlParam,
IGridHandlerParam {
    public String getPSDEDataViewId();

    public boolean isSingleSelect();
}

