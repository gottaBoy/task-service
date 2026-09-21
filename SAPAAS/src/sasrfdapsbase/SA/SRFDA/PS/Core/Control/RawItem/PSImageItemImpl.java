/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.RawItem.IPSImageItem;
import SA.SRFDA.PS.Core.Control.RawItem.PSRawItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelImplementMeta(implement="IPSRawItemBase", typevalues={"IMAGE"})
public class PSImageItemImpl
extends PSRawItemImplBase
implements IPSImageItem {
    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f")
    public String getAlternativeText() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90")
    public IPSSysImage getPSSysImage() {
        return this.getPSRawItemContainer().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u95f4\u653e\u7f6e", ignoredumpvalues="false")
    public boolean isPlaceCenter() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9002\u914d\u6a21\u5f0f")
    public String getFitMode() {
        return null;
    }
}

