/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2CtrlCodePublisherImpl;
import java.util.HashMap;

public class PSVue2ExpBarControllerCodePublisherImpl
extends PSVue2CtrlCodePublisherImpl {
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

