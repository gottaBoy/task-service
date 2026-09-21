/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u6807\u9898\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppTitleBar
extends IPSTitleBar {
    public IPSAppMenu getLeftPSAppMenu();

    public IPSAppMenu getRightPSAppMenu();
}

