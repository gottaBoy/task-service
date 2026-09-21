/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETreeColumn;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

public interface IPSDETreeUAColumn
extends IPSDETreeColumn {
    public IPSDEUIActionGroup getPSDEUIActionGroup();
}

