/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSJQDEFormDetailVCPublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSJQDEFormTabPanellVCPublisherImpl
extends PSJQDEFormDetailVCPublisherImpl {
    protected IPSDEFormTabPanel iPSDEFormTabPanel = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormTabPanel = (IPSDEFormTabPanel)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> formPageList = new ArrayList<IPSGenerateCodeResult>();
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormTabPages = this.iPSDEFormTabPanel.getPSDEFormTabPages();
        while (psDEFormTabPages.hasNext()) {
            IPSDEFormTabPage iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEFormTabPage);
            formPageList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("tabpages", formPageList);
    }

    @Override
    protected void onClose() {
        this.iPSDEFormTabPanel = null;
        super.onClose();
    }
}

