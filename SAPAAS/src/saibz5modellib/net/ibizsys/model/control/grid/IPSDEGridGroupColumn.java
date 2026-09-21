/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import java.util.Iterator;
import net.ibizsys.model.control.grid.IPSDEGridColumn;

public interface IPSDEGridGroupColumn
extends IPSDEGridColumn {
    public Iterator<IPSDEGridColumn> getPSDEGridColumns();
}

