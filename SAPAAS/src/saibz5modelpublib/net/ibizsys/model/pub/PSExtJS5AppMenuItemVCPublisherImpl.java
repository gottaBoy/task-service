/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSExtJS5CtrlPartCodePublisherImpl;

public class PSExtJS5AppMenuItemVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSAppMenuItem iPSAppMenuItem = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSAppMenuItem = (IPSAppMenuItem)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psAppMenuItems = this.iPSAppMenuItem.getPSAppMenuItems();
        if (psAppMenuItems != null) {
            while (psAppMenuItems.hasNext()) {
                IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)psAppMenuItems.next();
                IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSControl, (Object)iPSAppMenuItem);
                itemList.add(iPSGenerateCodeResult);
            }
            params.put("items", itemList);
        }
    }
}

