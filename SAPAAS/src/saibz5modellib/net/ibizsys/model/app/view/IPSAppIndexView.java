/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import java.util.Iterator;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.menu.IPSAppMenu;

public interface IPSAppIndexView
extends IPSAppView {
    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    public IPSAppMenu getPSAppMenu();

    public boolean isDefaultPage();

    public String getAppIconPath();

    public String getAppIconPath2();

    @Override
    public String getMainMenuAlign();

    public IPSAppView getDefPSAppView();
}

