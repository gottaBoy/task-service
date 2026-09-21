/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2ExpBarControllerCodePublisherImpl;
import java.util.HashMap;

public class PSVue2TreeExpBarControllerCodePublisherImpl
extends PSVue2ExpBarControllerCodePublisherImpl {
    protected IPSTreeExpBar iPSTreeExpBar = null;

    @Override
    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSTreeExpBar = (IPSTreeExpBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }

    @Override
    protected void onClose() {
        this.iPSTreeExpBar = null;
        super.onClose();
    }
}

