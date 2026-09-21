/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelJsonExporter2
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 */
package net.ibizsys.model.control.toolbar;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelJsonExporter2;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSDEToolbarItemRuntime
extends IPSDEToolbarItem,
IPSModelJsonExporter2 {
    public void init(IPSModelStorageContext var1, IPSDEToolbar var2, IPSDEToolbarItem var3, PSDEToolbarItem var4) throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillPSDEToolbarItems(ArrayList<IPSDEToolbarItem> var1);

    public IPSSysPFPlugin getPSSysPFPlugin();
}

