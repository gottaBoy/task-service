/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSAbsoluteLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutPosImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSAbsoluteLayoutPosImpl
extends PSLayoutPosImplBase
implements IPSAbsoluteLayoutPos {
    private String strLayoutPos = "LTWH";
    private int nLeft = 0;
    private int nTop = 0;
    private int nRight = 0;
    private int nBottom = 0;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSLayoutData().getAL_POS())) {
            this.strLayoutPos = this.getPSLayoutData().getAL_POS();
        }
        if (!this.getPSLayoutData().isLEFTPOSNull()) {
            this.nLeft = this.getPSLayoutData().getLEFTPOS();
        }
        if (!this.getPSLayoutData().isRIGHTPOSNull()) {
            this.nRight = this.getPSLayoutData().getRIGHTPOS();
        }
        if (!this.getPSLayoutData().isTOPPOSNull()) {
            this.nTop = this.getPSLayoutData().getTOPPOS();
        }
        if (!this.getPSLayoutData().isBOTTOMPOSNull()) {
            this.nBottom = this.getPSLayoutData().getBOTTOMPOS();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u5360\u4f4d", codelist="AbsoluteLayoutMode", group="\u4f4d\u7f6e", fields={"AL_POS"})
    public String getLayoutPos() {
        return this.strLayoutPos;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e", group="\u4f4d\u7f6e", fields={"LEFTPOS"}, ignoredumpvalues="0")
    public int getLeft() {
        return this.nLeft;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e", group="\u4f4d\u7f6e", fields={"TOPPOS"}, ignoredumpvalues="0")
    public int getTop() {
        return this.nTop;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u65b9\u4f4d\u7f6e", group="\u4f4d\u7f6e", fields={"BOTTOMPOS"}, ignoredumpvalues="0")
    public int getBottom() {
        return this.nBottom;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u4f4d\u7f6e", group="\u4f4d\u7f6e", fields={"RIGHTPOS"}, ignoredumpvalues="0")
    public int getRight() {
        return this.nRight;
    }
}

