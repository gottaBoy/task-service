/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart
 *  SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DashboardViewCodePublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSDashboard iPSDashboard = null;
    public static final String CTRLPART_PART = "PART";
    public static final String CTRLPART_DEFCONTENT = "DEFCONTENT";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDashboard = (IPSDashboard)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IPSDBPortletPart iPSPortlet;
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_PART).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psPortlets = this.iPSDashboard.getPSPortlets();
        while (psPortlets.hasNext()) {
            iPSPortlet = (IPSDBPortletPart)psPortlets.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDashboard, (Object)iPSPortlet);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("parts", gridRecordList);
        iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_DEFCONTENT).getPSPFCtrlPartCodePublisher();
        gridRecordList = new ArrayList();
        psPortlets = this.iPSDashboard.getPSPortlets();
        while (psPortlets.hasNext()) {
            iPSPortlet = (IPSDBPortletPart)psPortlets.next();
            if (iPSPortlet.getDefaultColId() < 0) continue;
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDashboard, (Object)iPSPortlet);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("defcontents", gridRecordList);
    }

    protected void onClose() {
        this.iPSDashboard = null;
        super.onClose();
    }
}

