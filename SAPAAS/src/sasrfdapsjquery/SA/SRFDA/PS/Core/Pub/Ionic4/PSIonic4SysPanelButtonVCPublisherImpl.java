/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelButton
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelButton;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4CtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSIonic4SysPanelButtonVCPublisherImpl
extends PSIonic4CtrlPartCodePublisherImpl {
    protected IPSSysPanelButton iPSSysPanelButton = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSSysPanelButton = (IPSSysPanelButton)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        this.iPSSysPanelButton = (IPSSysPanelButton)this.object;
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        this.iPSSysPanelButton = null;
        super.onClose();
    }
}

