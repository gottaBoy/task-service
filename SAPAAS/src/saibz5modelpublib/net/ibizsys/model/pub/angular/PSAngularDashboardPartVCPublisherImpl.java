/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDashboard
 *  net.ibizsys.model.pf.IPSPFCtrlTempl
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlCodePublisher
 */
package net.ibizsys.model.pub.angular;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.angular.PSAngularCtrlPartCodePublisherImpl;

public class PSAngularDashboardPartVCPublisherImpl
extends PSAngularCtrlPartCodePublisherImpl {
    public static final String CTRLPART_PART = "PART";
    protected IPSDashboard iPSDashboard = null;
    protected IPSDBPortletPart iPSPortlet = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDashboard = (IPSDashboard)iPSControl;
        this.iPSPortlet = (IPSDBPortletPart)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher;
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IPSPFCtrlTempl iPSPFCtrlTempl;
        super.onFillGenerateCodeParams(params);
        IPSControl contentPSControl = this.iPSPortlet.getContentPSControl();
        if (contentPSControl != null && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(contentPSControl.getPSControlType(), this.getPSPFPubCode())) != null && (iPSGenerateCodeResult = (iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher()).generateCode(contentPSControl)) != null) {
            params.put("content", iPSGenerateCodeResult);
        }
        if ((iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(this.iPSPortlet.getPSControlType(), this.getPSPFPubCode())) != null && (iPSGenerateCodeResult = (iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher()).generateCode((IPSControl)this.iPSPortlet)) != null) {
            params.put("portlet", iPSGenerateCodeResult);
        }
    }
}

