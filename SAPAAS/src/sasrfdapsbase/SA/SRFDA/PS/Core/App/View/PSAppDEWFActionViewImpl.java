/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.PSAppDEEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFACTIONVIEW"})
public class PSAppDEWFActionViewImpl
extends PSAppDEEditViewImpl
implements IPSAppDEWFActionView {
    @Override
    protected void onInit() throws Exception {
        this.setWFIAMode(true);
        this.setWFUtilType(this.psViewBase.getWFVIEWPARAM4());
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode", fields={"OPENMODE"})
    public String getOpenMode() {
        String strOpenMode = super.getOpenMode();
        if (StringHelper.isNullOrEmpty((String)strOpenMode)) {
            return "POPUPMODAL";
        }
        return strOpenMode;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4ea4\u4e92\u6a21\u5f0f")
    public boolean isWFIAMode() {
        return super.isWFIAMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true)
    public String getWFStepValue() {
        return super.getWFStepValue();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u8f85\u52a9\u529f\u80fd\u7c7b\u578b", hideempty2=true, codelist="WFUtilUIActionType", fields={"WFVIEWPARAM4"})
    public String getWFUtilType() {
        return super.getWFUtilType();
    }
}

