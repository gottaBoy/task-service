/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPartParam
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.PSControlTypeImpl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBPortletPartParam;
import net.ibizsys.model.res.IPSPortletTypeRuntime;

public class PSPortletControlTypeImpl
extends PSControlTypeImpl {
    @Override
    public IPSControl createPSControl(IPSControlParam iPSControlParam) throws Exception {
        IPSDBPortletPartParam iPSPortletParam = (IPSDBPortletPartParam)iPSControlParam;
        IPSDBPortletPart iPSPortlet = ((IPSPortletTypeRuntime)this.getPSModelStorageContext().getPSPortletType(iPSPortletParam.getPortletType())).createPSPortlet();
        ((IPSControlRuntime)iPSPortlet).setPSControlType(this);
        return iPSPortlet;
    }
}

