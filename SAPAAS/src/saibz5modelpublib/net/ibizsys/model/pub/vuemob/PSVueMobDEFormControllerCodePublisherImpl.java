/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vuemob;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlCodePublisherImpl;

public class PSVueMobDEFormControllerCodePublisherImpl
extends PSVueMobCtrlCodePublisherImpl {
    protected IPSDEForm iPSDEForm = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEForm = (IPSDEForm)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n");
    }

    protected void fillPSDEFormDetails(IPSDEFormDetail iPSDEFormDetail, ArrayList<IPSGenerateCodeResult> arrayList) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n");
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobDEFormControllerCodePublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlCodePublisherImpl\n");
    }
}

