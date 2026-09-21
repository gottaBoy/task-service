/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.res.IPSSysPortlet;

public interface IPSDBSysPortletPart
extends IPSDBPortletPart {
    public IPSSysPortlet getPSSysPortlet();

    public long getTimer();
}

