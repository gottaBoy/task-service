/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub.angular;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.angular.PSAngularCtrlPartCodePublisherImpl;

public class PSAngularDEFormDetailVCPublisherImpl
extends PSAngularCtrlPartCodePublisherImpl {
    protected IPSDEFormDetail iPSDEFormDetail = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormDetail = (IPSDEFormDetail)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEFormDetail.getParentPSDEFormDetail() != null) {
            params.put("parent", this.iPSDEFormDetail.getParentPSDEFormDetail());
        }
    }
}

