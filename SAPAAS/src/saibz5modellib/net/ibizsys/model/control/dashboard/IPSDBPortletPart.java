/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dashboard.IPortlet
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.paas.control.dashboard.IPortlet;

public interface IPSDBPortletPart
extends IPSAjaxControl,
IPortlet,
IPSControlContainer {
    public int getDefaultColId();

    public IPSControl getContentPSControl();

    public String getColCssClass();

    public boolean isShowTitleBar();
}

