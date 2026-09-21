/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetailRuntime;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.angular.PSAngularCtrlCodePublisherImpl;

public class PSAngularAppMenuVCPublisherImpl
extends PSAngularCtrlCodePublisherImpl {
    protected IPSAppMenu iPSAppMenu = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psAppMenuItems = this.iPSAppMenu.getPSAppMenuItems();
        while (psAppMenuItems.hasNext()) {
            IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)psAppMenuItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = ((IPSPFCtrlTemplDetailRuntime)this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType())).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSAppMenu, (Object)iPSAppMenuItem);
            itemList.add(iPSGenerateCodeResult);
        }
        params.put("items", itemList);
    }
}

