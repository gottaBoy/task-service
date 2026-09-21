/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenu
 *  net.ibizsys.model.control.toolbar.IPSDEContextMenuItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSExtJS5CtrlCodePublisherImpl;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

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
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEContextMenu, (Object)iPSDEContextMenuItem);
            if (iPSGenerateCodeResult == null) continue;
            itemList.add(iPSGenerateCodeResult);
        }
        params.put("items", itemList);
    }
}

