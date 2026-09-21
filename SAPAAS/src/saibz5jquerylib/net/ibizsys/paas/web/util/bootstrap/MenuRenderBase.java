/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.paas.web.util.bootstrap;

import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public abstract class MenuRenderBase {
    public static final Integer RENDERMODE_NORMAL = 1;
    protected static ThreadLocal<IWebContext> webContext = new ThreadLocal();
    protected static ThreadLocal<IAppMenuItem> activeAppMenuItem = new ThreadLocal();

    public static void outputMenuItem(StringBuilderEx sb, int nMode, IAppMenuItem iAppMenuItem, String strExtCssClass) throws Exception {
        IWebContext iWebContext = webContext.get();
        if ((iAppMenuItem.getAccUserMode() & AccessUserModes.LOGINUSER) > 0 || (iAppMenuItem.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
            if (iWebContext == null || StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId())) {
                return;
            }
            if ((iAppMenuItem.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0 && !iWebContext.getUserPrivilegeMgr().test(iWebContext, iAppMenuItem.getAccessKey())) {
                return;
            }
        }
        iAppMenuItem.getItems().size();
    }
}

