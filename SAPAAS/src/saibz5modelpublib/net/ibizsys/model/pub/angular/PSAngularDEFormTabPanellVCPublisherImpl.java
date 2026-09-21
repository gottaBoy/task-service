/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormTabPage
 *  net.ibizsys.model.control.form.IPSDEFormTabPanel
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.IPSDEFormTabPanel;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.angular.PSAngularDEFormDetailVCPublisherImpl;

public class PSAngularDEFormTabPanellVCPublisherImpl
extends PSAngularDEFormDetailVCPublisherImpl {
    protected IPSDEFormTabPanel iPSDEFormTabPanel = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormTabPanel = (IPSDEFormTabPanel)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> formPageList = new ArrayList<IPSGenerateCodeResult>();
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail("FORMPAGE").getPSPFCtrlPartCodePublisher();
        Iterator psDEFormTabPages = this.iPSDEFormTabPanel.getPSDEFormTabPages();
        while (psDEFormTabPages.hasNext()) {
            IPSDEFormTabPage iPSDEFormTabPage = (IPSDEFormTabPage)psDEFormTabPages.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSControl, (Object)iPSDEFormTabPage);
            formPageList.add(iPSGenerateCodeResult);
        }
        params.put("tabpages", formPageList);
    }
}

