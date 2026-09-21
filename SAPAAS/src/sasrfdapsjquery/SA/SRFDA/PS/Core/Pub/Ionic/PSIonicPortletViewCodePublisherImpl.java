/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDBChartPortlet
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDBListPortletPart
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Ionic;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBChartPortlet;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBListPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.Ionic.PSIonicCtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.HashMap;

public class PSIonicPortletViewCodePublisherImpl
extends PSIonicCtrlCodePublisherImpl {
    protected IPSDBPortletPart iPSPortlet = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSDBListPortletPart iPSListPortlet;
        IPSPFCtrlTempl iPSPFCtrlTempl;
        super.onFillGenerateCodeParams(params);
        this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
        if (this.iPSPortlet instanceof IPSDBChartPortlet) {
            IPSDBChartPortlet iPSChartPortlet = (IPSDBChartPortlet)this.iPSPortlet;
            IPSPFCtrlTempl iPSPFCtrlTempl2 = this.iPSPFStyle.getPSPFCtrlTempl(iPSChartPortlet.getPSChart().getPSControlType(), this.getPSPFPubCode());
            if (iPSPFCtrlTempl2 != null) {
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl2.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)iPSChartPortlet.getPSChart());
                if (iPSGenerateCodeResult != null) {
                    params.put("chart", iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
        } else if (this.iPSPortlet instanceof IPSDBListPortletPart && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl((iPSListPortlet = (IPSDBListPortletPart)this.iPSPortlet).getPSList().getPSControlType(), this.getPSPFPubCode())) != null) {
            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)iPSListPortlet.getPSList());
            if (iPSGenerateCodeResult != null) {
                params.put("list", iPSGenerateCodeResult);
            }
            iPSPFCtrlCodePublisher.close();
        }
    }

    protected void onClose() {
        this.iPSPortlet = null;
        super.onClose();
    }
}

