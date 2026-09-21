/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.menu.IPSAppMenu;

public interface IPSDBAppMenuPortletPart
extends IPSDBPortletPart {
    public IPSAppMenu getPSAppMenu();

    public String getAMListStyle();
}

