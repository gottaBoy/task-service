/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Menu.IPSContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e0a\u4e0b\u6587\u83dc\u5355\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEToolbar")
public interface IPSDEContextMenu
extends IPSDEToolbar,
IPSContextMenu {
    @Deprecated
    public Iterator<IPSDEContextMenuItem> getPSContextMenuItems() throws Exception;

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception;
}

