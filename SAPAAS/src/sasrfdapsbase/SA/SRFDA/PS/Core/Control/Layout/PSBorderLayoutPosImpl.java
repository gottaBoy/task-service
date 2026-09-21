/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSBorderLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutPosImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSBorderLayoutPosImpl
extends PSLayoutPosImplBase
implements IPSBorderLayoutPos {
    private String strLayoutPos = "CENTER";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSLayoutData().getBL_POS())) {
            this.strLayoutPos = this.getPSLayoutData().getBL_POS();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u5360\u4f4d", codelist="BorderLayoutPos", group="\u4f4d\u7f6e", fields={"AL_POS"})
    public String getLayoutPos() {
        return this.strLayoutPos;
    }
}

