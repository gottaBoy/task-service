/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBChartPortlet
 *  net.ibizsys.model.control.dashboard.IPSDBListPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.pf.IPSPFCtrlTempl
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBChartPortlet;
import net.ibizsys.model.control.dashboard.IPSDBListPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQCtrlCodePublisherImpl;

public class PSJQPortletViewCodePublisherImpl
extends PSJQCtrlCodePublisherImpl {
    protected IPSDBPortletPart iPSPortlet = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher;
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IPSDBListPortletPart iPSListPortlet;
        IPSPFCtrlTempl iPSPFCtrlTempl;
        super.onFillGenerateCodeParams(params);
        if (this.iPSPortlet instanceof IPSDBChartPortlet) {
            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher2;
            IPSGenerateCodeResult iPSGenerateCodeResult2;
            IPSDBChartPortlet iPSChartPortlet = (IPSDBChartPortlet)this.iPSPortlet;
            IPSPFCtrlTempl iPSPFCtrlTempl2 = this.iPSPFStyle.getPSPFCtrlTempl(iPSChartPortlet.getPSChart().getPSControlType(), this.getPSPFPubCode());
            if (iPSPFCtrlTempl2 != null && (iPSGenerateCodeResult2 = (iPSPFCtrlCodePublisher2 = iPSPFCtrlTempl2.getPSPFCtrlCodePublisher()).generateCode((IPSControl)iPSChartPortlet.getPSChart())) != null) {
                params.put("chart", iPSGenerateCodeResult2);
            }
        } else if (this.iPSPortlet instanceof IPSDBListPortletPart && (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl((iPSListPortlet = (IPSDBListPortletPart)this.iPSPortlet).getPSList().getPSControlType(), this.getPSPFPubCode())) != null && (iPSGenerateCodeResult = (iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher()).generateCode((IPSControl)iPSListPortlet.getPSList())) != null) {
            params.put("list", iPSGenerateCodeResult);
        }
    }
}

