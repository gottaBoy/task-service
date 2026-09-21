/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControlParam
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.entity.PSDEViewCtrl;

public interface IPSControlParamRuntime
extends IPSControlParam {
    public void init(IPSModelStorageContext var1, IPSAppView var2, PSDEViewCtrl var3) throws Exception;

    public String getPSSysPFPluginId();
}

