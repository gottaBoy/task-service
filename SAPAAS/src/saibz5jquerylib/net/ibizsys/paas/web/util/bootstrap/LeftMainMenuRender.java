/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.paas.web.util.bootstrap;

import java.util.Iterator;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.util.bootstrap.MenuRenderBase;

public class LeftMainMenuRender
extends MenuRenderBase {
    public static String output(int nMode, IAppMenuModel iAppMenuModel, IWebContext iWebContext, String strCurPagePath) throws Exception {
        webContext.set(iWebContext);
        activeAppMenuItem.set(null);
        StringBuilderEx sb = new StringBuilderEx();
        boolean bFirst = true;
        Iterator appMenuItems = iAppMenuModel.getAppMenuItems();
        while (appMenuItems.hasNext()) {
            IAppMenuItem iAppMenuItem = (IAppMenuItem)appMenuItems.next();
            String strExtClass = null;
            if (bFirst) {
                strExtClass = "start";
                bFirst = false;
            }
            LeftMainMenuRender.outputMenuItem(sb, nMode, iAppMenuItem, strExtClass);
        }
        webContext.set(null);
        activeAppMenuItem.set(null);
        return sb.toString();
    }
}

