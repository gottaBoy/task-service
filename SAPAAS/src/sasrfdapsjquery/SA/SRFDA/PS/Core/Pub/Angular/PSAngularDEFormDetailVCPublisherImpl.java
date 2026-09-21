/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.Angular.PSAngularCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import java.util.HashMap;

public class PSAngularDEFormDetailVCPublisherImpl
extends PSAngularCtrlPartCodePublisherImpl {
    protected IPSDEFormDetail iPSDEFormDetail = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEFormDetail = (IPSDEFormDetail)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEFormDetail.getParentPSDEFormDetail() != null) {
            params.put("parent", this.iPSDEFormDetail.getParentPSDEFormDetail());
        }
    }

    protected void onClose() {
        this.iPSDEFormDetail = null;
        super.onClose();
    }
}

