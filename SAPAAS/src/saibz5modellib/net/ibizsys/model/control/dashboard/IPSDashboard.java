/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dashboard.IDashboard
 */
package net.ibizsys.model.control.dashboard;

import java.util.Iterator;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.paas.control.dashboard.IDashboard;

public interface IPSDashboard
extends IPSAjaxControl,
IPSControlContainer,
IDashboard {
    public Iterator<IPSDBPortletPart> getPSPortlets();

    public void registerPSPortlet(IPSDBPortletPart var1) throws Exception;
}

