/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSFR7CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.HashMap;

public class PSFR7DRBarViewCodePublisherImpl
extends PSFR7CtrlCodePublisherImpl {
    protected IPSDRBar iPSDRBar = null;
    public static final String CTRLPART_STORE = "STORE";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDRBar = (IPSDRBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSDRBar = (IPSDRBar)this.iPSControl;
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDRBar, null);
        iPSPFCtrlPartCodePublisher.close();
        params.put("store", iPSGenerateCodeResult);
    }

    protected void onClose() {
        this.iPSDRBar = null;
        super.onClose();
    }
}

