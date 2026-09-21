/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlCodePublisherImpl;

public class PSVueMobPortletViewCodePublisherImpl
extends PSVueMobCtrlCodePublisherImpl {
    protected IPSDBPortletPart iPSPortlet = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved or is not a field\n\tThe method close() is undefined for the type IPSPFCtrlCodePublisher\n\tiPSPublisherContext cannot be resolved or is not a field\n\tThe method close() is undefined for the type IPSPFCtrlCodePublisher\n");
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobPortletViewCodePublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlCodePublisherImpl\n");
    }
}

