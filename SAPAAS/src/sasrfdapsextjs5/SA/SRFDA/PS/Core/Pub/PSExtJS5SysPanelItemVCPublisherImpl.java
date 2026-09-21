/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSExtJS5SysPanelItemVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSSysPanelItem iPSSysPanelItem = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSSysPanelItem = (IPSSysPanelItem)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        this.iPSSysPanelItem = (IPSSysPanelItem)this.object;
        super.onFillGenerateCodeParams(params);
        if (this.iPSSysPanelItem.getParentPSSysPanelItem() != null) {
            params.put("parent", this.iPSSysPanelItem.getParentPSSysPanelItem());
        }
    }

    protected void onClose() {
        this.iPSSysPanelItem = null;
        super.onClose();
    }
}

