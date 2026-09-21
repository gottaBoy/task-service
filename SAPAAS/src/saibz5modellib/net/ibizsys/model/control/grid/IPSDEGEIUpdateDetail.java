/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDEGEIUpdateDetail
extends IPSModelObject {
    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate();

    public String getPSDEGridColumnName();

    public String getPSDEGridColumnId();
}

