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
import SA.SRFDA.PS.Core.Pub.PSJQDEFormDetailVCPublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSNGDEFormGroupPanellVCPublisherImpl
extends PSJQDEFormDetailVCPublisherImpl {
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
        if (StringHelper.Compare((String)strLayoutType, (String)"TABLE_12COL", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u4ec5\u652f\u6301\u6805\u683c\uff0812\u5217\u5747\u5206\uff09\u5e03\u5c40"));
        }
        int nColPos = 0;
        int nRowId = 0;
        HashMap<Integer, ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer, ColumnLayoutGroup>();
        ArrayList<IPSGenerateCodeResult> formDetailCodeList = new ArrayList<IPSGenerateCodeResult>();
        for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
            int nColSpan = iPSDEFormDetail.getColSpan();
            if (nColSpan == 0 || nColSpan > this.iPSDEFormGroupPanel.getColumnCount()) {
                nColSpan = this.iPSDEFormGroupPanel.getColumnCount();
            }
            if (nColPos + nColSpan > this.iPSDEFormGroupPanel.getColumnCount()) {
                ++nRowId;
                nColPos = 0;
            } else {
                nColPos += nColSpan;
            }
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
            formDetailCodeList.add(iPSGenerateCodeResult);
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

