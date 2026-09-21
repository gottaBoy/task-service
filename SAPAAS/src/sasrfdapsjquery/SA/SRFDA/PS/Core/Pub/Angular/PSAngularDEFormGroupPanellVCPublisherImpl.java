/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.Angular.PSAngularDEFormDetailVCPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSAngularDEFormGroupPanellVCPublisherImpl
extends PSAngularDEFormDetailVCPublisherImpl {
    protected IPSDEFormGroupPanel iPSDEFormGroupPanel = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormGroupPanel = (IPSDEFormGroupPanel)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList<IPSDEFormDetail>();
        Iterator psDEFormDetails = this.iPSDEFormGroupPanel.getPSDEFormDetails();
        while (psDEFormDetails.hasNext()) {
            IPSDEFormItem iPSDEFormItem;
            IPSDEFormDetail iPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
            if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.Compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
            psDEFormDetailList.add(iPSDEFormDetail);
        }
        ArrayList<IPSGenerateCodeResult> formDetailCodeList = new ArrayList<IPSGenerateCodeResult>();
        for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEFormDetail);
            iPSPFCtrlPartCodePublisher.close();
            formDetailCodeList.add(iPSGenerateCodeResult);
        }
        params.put("items", formDetailCodeList);
    }

    @Override
    protected void onClose() {
        this.iPSDEFormGroupPanel = null;
        super.onClose();
    }

    public class ColumnLayoutGroup {
        private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList();

        public ArrayList<IPSGenerateCodeResult> getItems() {
            return this.itemCodeList;
        }
    }
}

