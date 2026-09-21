/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vue2.PSVue2CtrlCodePublisherImpl;

public class PSVue2DEToolbarVCPublisherImpl
extends PSVue2CtrlCodePublisherImpl {
    protected IPSDEToolbar iPSDEToolbar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEToolbar = (IPSDEToolbar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEToolbarItems = this.iPSDEToolbar.getPSDEToolbarItems();
        while (psDEToolbarItems.hasNext()) {
            IPSDEToolbarItem iPSDEToolbarItem = (IPSDEToolbarItem)psDEToolbarItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEToolbarItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEToolbar, (Object)iPSDEToolbarItem);
            if (iPSGenerateCodeResult == null) continue;
            itemList.add(iPSGenerateCodeResult);
        }
        params.put("items", itemList);
    }
}

