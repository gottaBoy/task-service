/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.menu;

import java.util.ArrayList;
import net.ibizsys.paas.control.menu.IMenuItem;

public interface IAppMenuItem
extends IMenuItem {
    public static final int STATE_NEW = 1;
    public static final int STATE_HOT = 2;

    public ArrayList<IAppMenuItem> getItems();

    public String getAppFuncId();

    public boolean isSeperator();

    public boolean isHideSideBar();

    public boolean isOpenDefault();

    public int getAppMenuItemState();
}

