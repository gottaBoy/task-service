/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IApplication
 */
package net.ibizsys.model.app;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSAppUtilPage;
import net.ibizsys.model.app.IPSApplicationUI;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.IApplication;

public interface IPSApplication
extends IPSSystemObject,
IApplication,
IPSModelObject {
    public IPSAppFunc getPSAppFunc(String var1) throws Exception;

    public IPSApplicationUI getPSApplicationUI();

    public boolean isMobileApp();

    public String getPFType();

    public String getPFStyle();

    public String getPKGCodeName();

    public String getCodeFolder();

    public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception;

    public IPSAppUtilPage getPSAppUtilPage(String var1) throws Exception;

    public boolean isEnableUACLogin();

    public IPSAppView getPSAppView(String var1, boolean var2) throws Exception;

    public boolean getDefaultFlag();

    public IPSAppModule getPSAppModule(String var1) throws Exception;

    public String getAppFolder();
}

