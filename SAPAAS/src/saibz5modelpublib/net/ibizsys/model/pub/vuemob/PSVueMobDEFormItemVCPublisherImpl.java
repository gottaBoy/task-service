/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSPublisherContext
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.vuemob.PSVueMobDEFormDetailVCPublisherImpl;

public class PSVueMobDEFormItemVCPublisherImpl
extends PSVueMobDEFormDetailVCPublisherImpl {
    protected IPSDEFormItem iPSDEFormItem = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tIPSPublisherContext cannot be resolved to a type\n");
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tThe method getPSModelStorage() is undefined for the type PSVueMobDEFormItemVCPublisherImpl\n\tThe method getPSSysPFPlugin() is undefined for the type IPSSysEditorStyle\n\tThe method getPSPFEditorTempl(IPSEditorType, String, IPSPFPubCode, String) is undefined for the type IPSApplication\n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFEditorCodePublisher\n");
    }

    @Override
    protected void onClose() {
        this.iPSDEFormItem = null;
        super.onClose();
    }
}

