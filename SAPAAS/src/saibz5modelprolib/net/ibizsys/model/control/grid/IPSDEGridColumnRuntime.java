/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSDEGridColumnRuntime
extends IPSDEGridColumn {
    public void init(IPSModelStorageContext var1, IPSDEGrid var2, IPSDEGridColumn var3, PSDEGridColumn var4) throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public IPSSysPFPlugin getRenderPSSysPFPlugin();
}

