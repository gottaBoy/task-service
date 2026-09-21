/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

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
}

