/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.titlebar.IPSTitleBar;

public interface IPSAppTitleBar
extends IPSTitleBar {
    public IPSAppMenu getLeftPSAppMenu();

    public IPSAppMenu getRightPSAppMenu();
}

