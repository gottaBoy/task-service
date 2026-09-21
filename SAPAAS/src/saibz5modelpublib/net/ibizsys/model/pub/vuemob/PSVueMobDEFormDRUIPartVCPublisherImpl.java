/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSPublisherContext
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.vuemob.PSVueMobDEFormDetailVCPublisherImpl;

public class PSVueMobDEFormDRUIPartVCPublisherImpl
extends PSVueMobDEFormDetailVCPublisherImpl {
    protected IPSDEFormDRUIPart iPSDEFormDRUIPart = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tIPSPublisherContext cannot be resolved to a type\n");
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }

    @Override
    protected void onClose() {
        this.iPSDEFormDRUIPart = null;
        super.onClose();
    }
}

