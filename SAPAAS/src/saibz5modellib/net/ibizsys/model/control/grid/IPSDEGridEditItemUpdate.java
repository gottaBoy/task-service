/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import java.util.Iterator;
import net.ibizsys.model.control.grid.IPSDEGEIUpdateDetail;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;

public interface IPSDEGridEditItemUpdate
extends IPSModelObject {
    public IPSDEGrid getPSDEGrid();

    public String getCodeName();

    public Iterator<IPSDEGEIUpdateDetail> getPSDEGEIUpdateDetails();

    public IPSDEAction getPSDEAction() throws Exception;
}

