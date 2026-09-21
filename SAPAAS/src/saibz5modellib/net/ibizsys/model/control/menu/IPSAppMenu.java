/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenu
 */
package net.ibizsys.model.control.menu;

import java.util.Iterator;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;

public interface IPSAppMenu
extends IPSAjaxControl,
IAppMenu,
IPSAppMenuModel {
    @Override
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception;

    @Override
    public AppMenuRootItem getRootItem();

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    public IPSSysCounter getPSSysCounter();

    public Iterator<IPSAppMenuItem> getAllPSAppMenuItems() throws Exception;
}

