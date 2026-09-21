/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.toolbar.IPSDECMGroupItem
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenuItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDECMGroupItem;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSExtJS5CtrlPartCodePublisherImpl;

public class PSExtJS5DECMGroupItemCodePublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSDECMGroupItem iPSDECMGroupItem = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDECMGroupItem = (IPSDECMGroupItem)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEContextMenuItems = this.iPSDECMGroupItem.getPSDEContextMenuItems();
        while (psDEContextMenuItems.hasNext()) {
            IPSDEContextMenuItem iPSDEContextMenuItem = (IPSDEContextMenuItem)psDEContextMenuItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEContextMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSControl, (Object)iPSDEContextMenuItem);
            if (iPSGenerateCodeResult == null) continue;
            itemList.add(iPSGenerateCodeResult);
        }
        params.put("items", itemList);
    }
}

