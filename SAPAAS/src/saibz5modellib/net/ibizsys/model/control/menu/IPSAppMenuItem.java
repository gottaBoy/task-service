/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 */
package net.ibizsys.model.control.menu;

import java.util.Iterator;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.control.menu.IPSMenuItem;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.menu.IAppMenuItem;

public interface IPSAppMenuItem
extends IPSMenuItem,
IAppMenuItem {
    public Iterator<IPSAppMenuItem> getPSAppMenuItems();

    public IPSAppFunc getPSAppFunc();

    public boolean isOpenDefault();

    public boolean isDisableClose();

    public boolean isHideSideBar();

    public String getTooltip();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public boolean isValid();

    public String getCounterId();
}

