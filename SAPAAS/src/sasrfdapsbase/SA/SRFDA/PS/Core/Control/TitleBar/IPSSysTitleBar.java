/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;

public interface IPSSysTitleBar
extends IPSTitleBar {
    public IPSDEToolbar getLeftPSDEToolbar();

    public IPSDEToolbar getRightPSDEToolbar();
}

