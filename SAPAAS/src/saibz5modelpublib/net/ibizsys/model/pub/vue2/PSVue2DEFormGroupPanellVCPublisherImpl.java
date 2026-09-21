/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormGroupPanel
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.vue2.PSVue2DEFormDetailVCPublisherImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSVue2DEFormGroupPanellVCPublisherImpl
extends PSVue2DEFormDetailVCPublisherImpl {
    protected IPSDEFormGroupPanel iPSDEFormGroupPanel = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormGroupPanel = (IPSDEFormGroupPanel)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList<IPSDEFormDetail>();
        Iterator psDEFormDetails = this.iPSDEFormGroupPanel.getPSDEFormDetails();
        while (psDEFormDetails.hasNext()) {
            IPSDEFormItem iPSDEFormItem;
            IPSDEFormDetail iPSDEFormDetail = (IPSDEFormDetail)psDEFormDetails.next();
            if (iPSDEFormDetail instanceof IPSDEFormItem && StringHelper.compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
            psDEFormDetailList.add(iPSDEFormDetail);
        }
        String strLayoutType = this.iPSDEFormGroupPanel.getLayoutMode();
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
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSControl, (Object)iPSDEFormDetail);
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

    public class ColumnLayoutGroup {
        private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList();

        public ArrayList<IPSGenerateCodeResult> getItems() {
            return this.itemCodeList;
        }
    }
}

