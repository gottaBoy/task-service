/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarLogic;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEToolbar")
public interface IPSDEToolbar
extends IPSControl {
    public static final String TOOLBARSTYLE_TOOLBAR = "TOOLBAR";
    public static final String TOOLBARSTYLE_MENU = "MENU";
    public static final String TOOLBARSTYLE_CONTEXTMENU = "CONTEXTMENU";
    public static final String TOOLBARSTYLE_MOBNAVLEFTMENU = "MOBNAVLEFTMENU";
    public static final String TOOLBARSTYLE_MOBNAVRIGHTMENU = "MOBNAVRIGHTMENU";
    public static final String TOOLBARSTYLE_MOBWFACTIONMENU = "MOBWFACTIONMENU";

    public String getToolbarStyle();

    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception;

    public Iterator<IPSDEToolbarItem> getAllPSDEToolbarItems() throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1) throws Exception;

    public Object getOwner();

    public Iterator<? extends IPSDEToolbarLogic> getPSDEToolbarLogics();

    public String getXDataControlName();
}

