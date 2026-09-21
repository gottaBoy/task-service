/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBGroupItem
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBGroupItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlPartCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DETBGroupItemVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSDETBGroupItem iPSDETBGroupItem = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDETBGroupItem = (IPSDETBGroupItem)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEToolbarItems = this.iPSDETBGroupItem.getPSDEToolbarItems();
        while (psDEToolbarItems.hasNext()) {
            IPSDEToolbarItem iPSDEToolbarItem = (IPSDEToolbarItem)psDEToolbarItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEToolbarItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEToolbarItem);
            if (iPSGenerateCodeResult != null) {
                itemList.add(iPSGenerateCodeResult);
            }
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("items", itemList);
    }

    protected void onClose() {
        this.iPSDETBGroupItem = null;
        super.onClose();
    }
}

