/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.entity.PSAppViewRef;

public interface IPSAppViewRefRuntime
extends IPSAppViewRef,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSAppView var2, PSAppViewRef var3) throws Exception;
}

