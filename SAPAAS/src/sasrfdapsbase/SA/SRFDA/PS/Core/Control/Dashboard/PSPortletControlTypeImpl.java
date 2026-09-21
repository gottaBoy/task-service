/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPartParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlTypeImpl;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITPortletType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public class PSPortletControlTypeImpl
extends PSControlTypeImpl {
    @Override
    public IPSControl createPSControl(IPSControlParam iPSControlParam) throws Exception {
        IPSDBPortletPartParam iPSPortletParam = (IPSDBPortletPartParam)iPSControlParam;
        IPSDBPortletPart iPSPortlet = this.getPSModelStorage().getPSPortletType(iPSPortletParam.getPortletType()).createPSPortlet();
        iPSPortlet.setPSControlType(this);
        return iPSPortlet;
    }

    @Override
    public IPSJITCtrlModel createPSJITCtrlModel(IPSControl iPSControl) throws Exception {
        IPSDBPortletPart iPSDBPortletPart = (IPSDBPortletPart)iPSControl;
        return ((IPSJITPortletType)this.getPSModelStorage().getPSPortletType(iPSDBPortletPart.getPortletType())).createPSJITCtrlModel(iPSControl);
    }

    @Override
    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl iPSControl) throws Exception {
        IPSDBPortletPart iPSDBPortletPart = (IPSDBPortletPart)iPSControl;
        return ((IPSJITPortletType)this.getPSModelStorage().getPSPortletType(iPSDBPortletPart.getPortletType())).createPSJITCtrlHandler(iPSControl);
    }
}

