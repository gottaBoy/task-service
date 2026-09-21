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
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSExtJS5DEFormDetailVCPublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DEFormGroupPanellVCPublisherImpl
extends PSExtJS5DEFormDetailVCPublisherImpl {
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
        String strLayoutType = this.iPSDEFormGroupPanel.getLayoutMode();
        if (StringHelper.Compare((String)strLayoutType, (String)"AUTOTABLE", (boolean)true) == 0 || StringHelper.Compare((String)strLayoutType, (String)"TABLE", (boolean)true) == 0) {
            HashMap<Integer, ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer, ColumnLayoutGroup>();
            for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
                int nRowId = this.iPSDEFormGroupPanel.getItemRowId(iPSDEFormDetail);
                ColumnLayoutGroup columnLayoutGroup = null;
                if (columnLayoutGroupMap.containsKey(nRowId)) {
                    columnLayoutGroup = (ColumnLayoutGroup)columnLayoutGroupMap.get(nRowId);
                } else {
                    columnLayoutGroup = new ColumnLayoutGroup();
                    columnLayoutGroupMap.put(nRowId, columnLayoutGroup);
                }
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEFormDetail);
                iPSPFCtrlPartCodePublisher.close();
                columnLayoutGroup.getItems().add(iPSGenerateCodeResult);
            }
            ArrayList<ColumnLayoutGroup> columnLayoutGroupList = new ArrayList<ColumnLayoutGroup>();
            int i = 0;
            while (i < 1000) {
                ColumnLayoutGroup columnLayoutGroup = (ColumnLayoutGroup)columnLayoutGroupMap.get(i);
                if (columnLayoutGroup == null) break;
                columnLayoutGroupList.add(columnLayoutGroup);
                ++i;
            }
            params.put("rows", columnLayoutGroupList);
        } else if (StringHelper.Compare((String)strLayoutType, (String)"BORDER", (boolean)true) == 0) {
            ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();
            for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEFormDetail);
                iPSPFCtrlPartCodePublisher.close();
                itemCodeList.add(iPSGenerateCodeResult);
            }
            params.put("items", itemCodeList);
        }
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

