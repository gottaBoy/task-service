/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.control.grid.IPSDEGrid;

public interface IPSDEMultiEditViewPanel
extends IPSDEGrid {
    public IPSAppDEView getPSAppDEView();

    public String getPanelStyle();
}

