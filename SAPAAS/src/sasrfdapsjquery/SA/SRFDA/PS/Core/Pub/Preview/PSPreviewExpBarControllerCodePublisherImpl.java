/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewCtrlCodePublisherImpl;
import java.util.HashMap;

public class PSPreviewExpBarControllerCodePublisherImpl
extends PSPreviewCtrlCodePublisherImpl {
    protected IPSExpBar iPSExpBar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSExpBar = (IPSExpBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        this.iPSExpBar = null;
        super.onClose();
    }
}

