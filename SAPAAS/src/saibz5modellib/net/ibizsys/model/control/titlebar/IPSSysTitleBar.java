/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.titlebar.IPSTitleBar;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;

public interface IPSSysTitleBar
extends IPSTitleBar {
    public IPSDEToolbar getLeftPSDEToolbar();

    public IPSDEToolbar getRightPSDEToolbar();
}

