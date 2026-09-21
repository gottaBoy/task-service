/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMSeperatorItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBSeperatorItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarItemImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

public class PSDETBSeperatorItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBSeperatorItem,
IPSDECMSeperatorItem {
    private boolean bSpanMode = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEToolbarItem.isSPANFLAGNull()) {
            this.bSpanMode = this.psDEToolbarItem.getSPANFLAG();
        }
        super.onInit();
    }

    @Override
    public boolean isShowIcon() {
        return false;
    }

    @Override
    public String getTooltip() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u5ef6\u5c55", ignoredumpvalues="false", fields={"SPANFLAG"})
    public boolean isSpanMode() {
        return this.bSpanMode;
    }

    @Override
    public String getCaption() {
        return super.getCaption();
    }

    @Override
    public boolean isShowCaption() {
        return super.isShowCaption();
    }

    @Override
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    public IPSSysCss getPSSysCss() {
        return super.getPSSysCss();
    }

    @Override
    public IPSLanguageRes getCapPSLanguageRes() {
        return super.getCapPSLanguageRes();
    }
}

