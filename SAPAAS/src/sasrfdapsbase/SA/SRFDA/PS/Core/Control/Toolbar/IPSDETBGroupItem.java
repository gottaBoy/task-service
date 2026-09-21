/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u5206\u7ec4\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETBGroupItemImpl", model="PSDETBItem")
@PSModelExtendMeta(extend="IPSDEToolbarItem", typevalue={"ITEMS"})
public interface IPSDETBGroupItem
extends IPSDEToolbarItem {
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";
    public static final String GROUPEXTRACTMODE_ITEMX = "ITEMX";

    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception;

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();

    public int getActionLevel();

    public String getButtonStyle();

    public String getBorderStyle();

    public IPSUIActionGroup getPSUIActionGroup();

    public String getGroupExtractMode();
}

