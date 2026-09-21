/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppView
 */
package net.ibizsys.model.app.func;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.entity.PSAppFunc;

public interface IPSAppFuncRuntime
extends IPSAppFunc {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppFunc var3) throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getCodeName();
}

