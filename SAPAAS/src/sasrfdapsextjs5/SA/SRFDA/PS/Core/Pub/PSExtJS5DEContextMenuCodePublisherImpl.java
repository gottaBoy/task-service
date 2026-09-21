/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu
 *  SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DEContextMenuCodePublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSDEContextMenu iPSDEContextMenu = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEContextMenu = (IPSDEContextMenu)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEContextMenuItems = this.iPSDEContextMenu.getPSDEContextMenuItems();
        while (psDEContextMenuItems.hasNext()) {
            IPSDEContextMenuItem iPSDEContextMenuItem = (IPSDEContextMenuItem)psDEContextMenuItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEContextMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEContextMenu, (Object)iPSDEContextMenuItem);
            if (iPSGenerateCodeResult != null) {
                itemList.add(iPSGenerateCodeResult);
            }
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("items", itemList);
    }

    protected void onClose() {
        this.iPSDEContextMenu = null;
        super.onClose();
    }
}

