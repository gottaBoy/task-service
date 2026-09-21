/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u4e0a\u4e0b\u6587\u83dc\u5355\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETBGroupItemImpl", model="PSDETBItem")
@PSModelExtendMeta(extend="IPSDEContextMenuItem", typevalue={"ITEMS"})
public interface IPSDECMGroupItem
extends IPSDEContextMenuItem {
    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception;

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();

    public int getActionLevel();

    public String getButtonStyle();

    public String getBorderStyle();
}

