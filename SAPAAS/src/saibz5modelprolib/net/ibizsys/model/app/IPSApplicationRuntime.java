/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;

public interface IPSApplicationRuntime
extends IPSApplication,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSystemApplication var3) throws Exception;

    public IPSAppView getPSAppView(String var1, boolean var2) throws Exception;

    public IPSAppView getPSAppViewByDEViewId(String var1, boolean var2) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, IPSAppView var3) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, boolean var3) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, boolean var3, IPSAppView var4) throws Exception;

    public void markPSAppViewUsage(String var1, int var2, Object var3);

    public int getPSAppViewUsage(String var1);

    public void log(int var1, IPSModelObject var2, String var3);

    public void log(int var1, IPSModelObject var2, String var3, String var4);

    public void log(int var1, IPSModelObject var2, String var3, String var4, String var5);

    public IPSPF getPSPF();

    public IPSPFStyle getPSPFStyle();

    public IPSPFStyle getPSPFStyle(String var1) throws Exception;

    public IPSAppPDTView getPSAppPDTView(String var1, boolean var2) throws Exception;
}

