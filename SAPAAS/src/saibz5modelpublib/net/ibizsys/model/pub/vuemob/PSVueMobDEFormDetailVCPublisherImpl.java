/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSPublisherContext
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlPartCodePublisherImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobFileNameMethod;

public class PSVueMobDEFormDetailVCPublisherImpl
extends PSVueMobCtrlPartCodePublisherImpl {
    private static PSVueMobFileNameMethod psFileNameMethod = new PSVueMobFileNameMethod();
    protected IPSDEFormDetail iPSDEFormDetail = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tIPSPublisherContext cannot be resolved to a type\n");
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEFormDetail.getParentPSDEFormDetail() != null) {
            params.put("parent", this.iPSDEFormDetail.getParentPSDEFormDetail());
            params.put("classname", psFileNameMethod);
        }
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobDEFormDetailVCPublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlPartCodePublisherImpl\n");
    }
}

