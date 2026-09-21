/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlPartCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DECMUIActionCodePublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSDECMUIActionItem iPSDECMUIActionItem = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDECMUIActionItem = (IPSDECMUIActionItem)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEContextMenuItems = this.iPSDECMUIActionItem.getPSDEContextMenuItems();
        while (psDEContextMenuItems.hasNext()) {
            IPSDEContextMenuItem iPSDEContextMenuItem = (IPSDEContextMenuItem)psDEContextMenuItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEContextMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEContextMenuItem);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("items", itemList);
    }

    protected void onClose() {
        this.iPSDECMUIActionItem = null;
        super.onClose();
    }
}

