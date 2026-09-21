/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanel
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewCtrlCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSPreviewSysPanelViewCodePublisherImpl
extends PSPreviewCtrlCodePublisherImpl {
    protected IPSPanel iPSPanel = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSPanel = (IPSPanel)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        HashMap<String, Object> rootParams;
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher;
        IPSPanelItem iPSPanelItem;
        this.iPSPanel = (IPSPanel)this.iPSControl;
        super.onFillGenerateCodeParams(params);
        Object objViewCtrl = params.get("srfviewctrl");
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        params.put("logics", itemList);
        ArrayList hiddenList = new ArrayList();
        params.put("hiddens", hiddenList);
        itemList = new ArrayList();
        Iterator psPanelItems = this.iPSPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            iPSPanelItem = (IPSPanelItem)psPanelItems.next();
            iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
            rootParams = new HashMap<String, Object>();
            if (objViewCtrl != null) {
                rootParams.put("srfviewctrl", objViewCtrl);
            }
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSPanel, (Object)iPSPanelItem, rootParams);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("rootitems", itemList);
        itemList = new ArrayList();
        psPanelItems = this.iPSPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            iPSPanelItem = (IPSPanelItem)psPanelItems.next();
            iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
            rootParams = new HashMap();
            if (objViewCtrl != null) {
                rootParams.put("srfviewctrl", objViewCtrl);
            }
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSPanel, (Object)iPSPanelItem, rootParams);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        psPanelItems = this.iPSPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            HashMap<String, Object> rootParams2 = new HashMap<String, Object>();
            if (objViewCtrl != null) {
                rootParams2.put("srfviewctrl", objViewCtrl);
            }
            IPSPanelItem iPSPanelItem2 = (IPSPanelItem)psPanelItems.next();
            this.fillPSSysPanelItems(iPSPanelItem2, itemList, rootParams2);
        }
        params.put("allitems", itemList);
    }

    protected void fillPSSysPanelItems(IPSPanelItem iPSPanelItem, ArrayList<IPSGenerateCodeResult> formDetailList, HashMap<String, Object> params) throws Exception {
        if (iPSPanelItem instanceof IPSPanelContainer) {
            IPSPanelContainer iPSPanelContainer = (IPSPanelContainer)iPSPanelItem;
            Iterator psPanelItems = iPSPanelContainer.getPSPanelItems();
            while (psPanelItems.hasNext()) {
                HashMap<String, Object> rootParams = new HashMap<String, Object>();
                if (params != null) {
                    rootParams.putAll(params);
                }
                IPSPanelItem childPSPanelItem = (IPSPanelItem)psPanelItems.next();
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSPanel, (Object)childPSPanelItem, rootParams);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
            }
            psPanelItems = iPSPanelContainer.getPSPanelItems();
            while (psPanelItems.hasNext()) {
                IPSPanelItem childPSPanelItem = (IPSPanelItem)psPanelItems.next();
                this.fillPSSysPanelItems(childPSPanelItem, formDetailList, params);
            }
            return;
        }
    }

    protected void onClose() {
        this.iPSPanel = null;
        super.onClose();
    }
}

