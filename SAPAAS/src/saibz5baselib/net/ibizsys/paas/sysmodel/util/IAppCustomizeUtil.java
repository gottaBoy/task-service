/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel.util;

import java.util.Iterator;
import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.sysmodel.ISystemUtil;

public interface IAppCustomizeUtil
extends ISystemUtil {
    public static final String UTILTYPE_APPCUSTOMIZE = "APPCUSTOMIZE";

    public Iterator<IAppMenuItem> getAppMenuItems(IAppMenu var1) throws Exception;

    public void installAll() throws Exception;

    public void installAppMenu(IAppMenu var1) throws Exception;

    public void installAllAppMenus() throws Exception;

    public void resetCache() throws Exception;
}

