/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSDEUIActionItem;
import net.ibizsys.model.app.view.IPSWFUIActionItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;

public interface IPSDECMUIActionItem
extends IPSDEContextMenuItem,
IPSDEUIActionItem,
IPSWFUIActionItem {
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception;

    public IPSAppView getFrontPSAppView() throws Exception;

    public boolean isEnableToggleMode();

    public boolean isHiddenItem();

    public String getGroupExtractMode();
}

