/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSPublisherContext
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDashboard
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.angularga;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.angularga.PSAngularCtrlPartCodePublisherImpl;

public class PSAngularDashboardPartVCPublisherImpl
extends PSAngularCtrlPartCodePublisherImpl {
    public static final String CTRLPART_PART = "PART";
    protected IPSDashboard iPSDashboard = null;
    protected IPSDBPortletPart iPSPortlet = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tIPSPublisherContext cannot be resolved to a type\n");
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved or is not a field\n\tThe method close() is undefined for the type IPSPFCtrlCodePublisher\n\tiPSPublisherContext cannot be resolved or is not a field\n\tThe method close() is undefined for the type IPSPFCtrlCodePublisher\n");
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSAngularDashboardPartVCPublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSAngularCtrlPartCodePublisherImpl\n");
    }
}

