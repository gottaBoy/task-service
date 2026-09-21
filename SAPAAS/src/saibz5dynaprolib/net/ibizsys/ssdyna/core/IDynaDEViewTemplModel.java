/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.AppViewModel
 */
package net.ibizsys.ssdyna.core;

import java.util.Iterator;
import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.ssdyna.core.IDynaDEViewTempl;

public interface IDynaDEViewTemplModel
extends IDynaDEViewTempl {
    public void registerAppDynaDEView(String var1, String var2, String var3, Object var4) throws Exception;

    public Iterator<AppViewModel> getAppDynaDEViews();
}

