/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem
 *  SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel
 *  SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelContainer
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelContainer;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5SysPanelViewCodePublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSSysPanel iPSSysPanel = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSSysPanel = (IPSSysPanel)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        HashMap<String, Object> rootParams;
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher;
        IPSPanelItem iPSPanelItem;
        this.iPSSysPanel = (IPSSysPanel)this.iPSControl;
        super.onFillGenerateCodeParams(params);
        Object objViewCtrl = params.get("srfviewctrl");
        ArrayList hiddenList = new ArrayList();
        params.put("hiddens", hiddenList);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psPanelItems = this.iPSSysPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            iPSPanelItem = (IPSPanelItem)psPanelItems.next();
            iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
            rootParams = new HashMap<String, Object>();
            if (objViewCtrl != null) {
                rootParams.put("srfviewctrl", objViewCtrl);
            }
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSSysPanel, (Object)iPSPanelItem, rootParams);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("rootitems", itemList);
        itemList = new ArrayList();
        psPanelItems = this.iPSSysPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            iPSPanelItem = (IPSPanelItem)psPanelItems.next();
            iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
            rootParams = new HashMap();
            if (objViewCtrl != null) {
                rootParams.put("srfviewctrl", objViewCtrl);
            }
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSSysPanel, (Object)iPSPanelItem, rootParams);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        psPanelItems = this.iPSSysPanel.getRootPSPanelItems();
        while (psPanelItems.hasNext()) {
            HashMap<String, Object> rootParams2 = new HashMap<String, Object>();
            if (objViewCtrl != null) {
                rootParams2.put("srfviewctrl", objViewCtrl);
            }
            IPSPanelItem iPSPanelItem2 = (IPSPanelItem)psPanelItems.next();
            this.fillPSPanelItems(iPSPanelItem2, itemList, rootParams2);
        }
        params.put("allitems", itemList);
    }

    protected void fillPSPanelItems(IPSPanelItem iPSPanelItem, ArrayList<IPSGenerateCodeResult> formDetailList, HashMap<String, Object> params) throws Exception {
        if (iPSPanelItem instanceof IPSSysPanelContainer) {
            IPSSysPanelContainer iPSSysPanelContainer = (IPSSysPanelContainer)iPSPanelItem;
            Iterator psPanelItems = iPSSysPanelContainer.getPSPanelItems();
            while (psPanelItems.hasNext()) {
                HashMap<String, Object> rootParams = new HashMap<String, Object>();
                if (params != null) {
                    rootParams.putAll(params);
                }
                IPSPanelItem childPSPanelItem = (IPSPanelItem)psPanelItems.next();
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSSysPanel, (Object)childPSPanelItem, rootParams);
                formDetailList.add(iPSGenerateCodeResult);
                iPSPFCtrlPartCodePublisher.close();
            }
            psPanelItems = iPSSysPanelContainer.getPSPanelItems();
            while (psPanelItems.hasNext()) {
                IPSPanelItem childPSPanelItem = (IPSPanelItem)psPanelItems.next();
                this.fillPSPanelItems(childPSPanelItem, formDetailList, params);
            }
            return;
        }
    }

    protected void onClose() {
        this.iPSSysPanel = null;
        super.onClose();
    }
}

