/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.menu;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.menu.IAppMenuItem;

public interface IAppMenu
extends IControl {
    public Iterator<IAppMenuItem> getAppMenuItems();
}

