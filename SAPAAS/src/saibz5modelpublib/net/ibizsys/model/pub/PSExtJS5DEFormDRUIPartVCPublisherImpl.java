/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.PSExtJS5DEFormDetailVCPublisherImpl;

public class PSExtJS5DEFormDRUIPartVCPublisherImpl
extends PSExtJS5DEFormDetailVCPublisherImpl {
    protected IPSDEFormDRUIPart iPSDEFormDRUIPart = null;

    @Override
    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormDRUIPart = (IPSDEFormDRUIPart)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

