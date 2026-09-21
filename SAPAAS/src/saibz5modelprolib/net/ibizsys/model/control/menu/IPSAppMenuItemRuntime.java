/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.menu.IPSAppMenuModel
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 */
package net.ibizsys.model.control.menu;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItem;

public interface IPSAppMenuItemRuntime
extends IPSAppMenuItem,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSAppMenuModel var2, IPSAppMenuItem var3, PSAppMenuItem var4) throws Exception;

    public void fillRelatedPSAppFuncs(ArrayList<IPSAppFunc> var1);

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;
}

