/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Pub.Base.PSSysPanelItemVCPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSSysPanelContainerVCPublisherImpl
extends PSSysPanelItemVCPublisherImpl {
    protected IPSPanelContainer iPSPanelContainer = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSPanelContainer = (IPSPanelContainer)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        ArrayList<IPSGenerateCodeResult> itemCodeList;
        super.onFillGenerateCodeParams(params);
        Object objViewCtrl = params.get("srfviewctrl");
        ArrayList<IPSPanelItem> psPanelItemList = new ArrayList<IPSPanelItem>();
        this.iPSPanelContainer = (IPSPanelContainer)this.object;
        Iterator psPanelItems = this.iPSPanelContainer.getPSPanelItems();
        while (psPanelItems.hasNext()) {
            IPSDEFormItem iPSDEFormItem;
            IPSPanelItem iPSPanelItem = (IPSPanelItem)psPanelItems.next();
            if (iPSPanelItem instanceof IPSDEFormItem && StringHelper.Compare((String)(iPSDEFormItem = (IPSDEFormItem)iPSPanelItem).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) continue;
            psPanelItemList.add(iPSPanelItem);
        }
        String strLayoutType = this.iPSPanelContainer.getLayoutMode();
        if (StringHelper.Compare((String)strLayoutType, (String)"AUTOTABLE", (boolean)true) == 0 || StringHelper.Compare((String)strLayoutType, (String)"TABLE", (boolean)true) == 0) {
            HashMap<Integer, ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer, ColumnLayoutGroup>();
            for (IPSPanelItem iPSPanelItem : psPanelItemList) {
                int nRowId = this.iPSPanelContainer.getItemRowId(iPSPanelItem);
                ColumnLayoutGroup columnLayoutGroup = null;
                if (columnLayoutGroupMap.containsKey(nRowId)) {
                    columnLayoutGroup = (ColumnLayoutGroup)columnLayoutGroupMap.get(nRowId);
                } else {
                    columnLayoutGroup = new ColumnLayoutGroup();
                    columnLayoutGroupMap.put(nRowId, columnLayoutGroup);
                }
                HashMap<String, Object> rootParams = new HashMap<String, Object>();
                if (objViewCtrl != null) {
                    rootParams.put("srfviewctrl", objViewCtrl);
                }
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSPanelItem, rootParams);
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
            itemCodeList = new ArrayList<IPSGenerateCodeResult>();
            for (IPSPanelItem iPSPanelItem : psPanelItemList) {
                HashMap<String, Object> rootParams = new HashMap<String, Object>();
                if (objViewCtrl != null) {
                    rootParams.put("srfviewctrl", objViewCtrl);
                }
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSPanelItem, rootParams);
                iPSPFCtrlPartCodePublisher.close();
                itemCodeList.add(iPSGenerateCodeResult);
            }
            params.put("items", itemCodeList);
        } else {
            itemCodeList = new ArrayList();
            for (IPSPanelItem iPSPanelItem : psPanelItemList) {
                HashMap<String, Object> rootParams = new HashMap<String, Object>();
                if (objViewCtrl != null) {
                    rootParams.put("srfviewctrl", objViewCtrl);
                }
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSPanelItem, rootParams);
                iPSPFCtrlPartCodePublisher.close();
                itemCodeList.add(iPSGenerateCodeResult);
            }
            params.put("items", itemCodeList);
        }
    }

    @Override
    protected void onClose() {
        this.iPSPanelContainer = null;
        super.onClose();
    }

    public class ColumnLayoutGroup {
        private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList();

        public ArrayList<IPSGenerateCodeResult> getItems() {
            return this.itemCodeList;
        }
    }
}

