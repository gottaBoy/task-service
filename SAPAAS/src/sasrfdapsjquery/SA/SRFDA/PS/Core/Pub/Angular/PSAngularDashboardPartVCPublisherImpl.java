/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.Angular.PSAngularCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import java.util.HashMap;

public class PSAngularDashboardPartVCPublisherImpl
extends PSAngularCtrlPartCodePublisherImpl {
    public static final String CTRLPART_PART = "PART";
    protected IPSDashboard iPSDashboard = null;
    protected IPSDBPortletPart iPSPortlet = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDashboard = (IPSDashboard)iPSControl;
        this.iPSPortlet = (IPSDBPortletPart)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher;
        IPSPFCtrlTempl iPSPFCtrlTempl;
        super.onFillGenerateCodeParams(params);
        IPSControl contentPSControl = this.iPSPortlet.getContentPSControl();
        if (contentPSControl != null && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(contentPSControl.getPSControlType(), this.getPSPFPubCode())) != null) {
            iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, contentPSControl);
            if (iPSGenerateCodeResult != null) {
                params.put("content", iPSGenerateCodeResult);
            }
            iPSPFCtrlCodePublisher.close();
        }
        if ((iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(this.iPSPortlet.getPSControlType(), this.getPSPFPubCode())) != null) {
            iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSPortlet);
            if (iPSGenerateCodeResult != null) {
                params.put("portlet", iPSGenerateCodeResult);
            }
            iPSPFCtrlCodePublisher.close();
        }
    }

    protected void onClose() {
        this.iPSDashboard = null;
        this.iPSPortlet = null;
        super.onClose();
    }
}

