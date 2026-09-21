/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 */
package net.ibizsys.model.app.menu;

import java.util.Iterator;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;

public interface IPSAppMenuModel
extends IPSApplicationObject {
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception;

    public AppMenuRootItem getRootItem();

    public Iterator<IPSAppFunc> getPSAppFuncs();

    public String getCodeName();
}

