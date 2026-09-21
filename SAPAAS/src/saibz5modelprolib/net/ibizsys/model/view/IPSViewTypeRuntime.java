/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.view.IPSViewType
 */
package net.ibizsys.model.view;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.view.IPSViewType;

public interface IPSViewTypeRuntime
extends IPSViewType {
    public void init(IPSModelStorageContext var1, PSViewType var2) throws Exception;

    public IPSAppView createPSAppView(PSAppView var1) throws Exception;
}

