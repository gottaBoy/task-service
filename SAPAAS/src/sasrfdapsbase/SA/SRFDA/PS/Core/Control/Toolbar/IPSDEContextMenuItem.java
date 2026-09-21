/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u4e0a\u4e0b\u6587\u83dc\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="itemType", model="PSDETBItem")
public interface IPSDEContextMenuItem
extends IPSDEToolbarItem {
    public IPSDEContextMenu getPSDEContextMenu();

    public IPSDEContextMenuItem getParentPSDEContextMenuItem();
}

