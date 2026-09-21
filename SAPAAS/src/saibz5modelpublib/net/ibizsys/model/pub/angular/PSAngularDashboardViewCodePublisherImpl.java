/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDashboard
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.angular.PSAngularCtrlCodePublisherImpl;

public class PSAngularDashboardViewCodePublisherImpl
extends PSAngularCtrlCodePublisherImpl {
    protected IPSDashboard iPSDashboard = null;
    public static final String CTRLPART_PART = "PART";
    public static final String CTRLPART_DEFCONTENT = "DEFCONTENT";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDashboard = (IPSDashboard)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSDashboard = (IPSDashboard)this.iPSControl;
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_PART).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psPortlets = this.iPSDashboard.getPSPortlets();
        while (psPortlets.hasNext()) {
            IPSDBPortletPart iPSPortlet = (IPSDBPortletPart)psPortlets.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDashboard, (Object)iPSPortlet);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        params.put("parts", gridRecordList);
    }
}

