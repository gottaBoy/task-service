/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.RawItem.IPSTextItem;
import SA.SRFDA.PS.Core.Control.RawItem.PSRawItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSRawItemBase", typevalues={"RAW"})
public class PSTextItemImpl
extends PSRawItemImplBase
implements IPSTextItem {
    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (this.getPSRawItemContainer().getPSSysResource() != null) {
            return this.getPSRawItemContainer().getPSSysResource().getContent();
        }
        return this.getPSRawItemContainer().getContent();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u6a21\u5f0f", codelist="TextRenderMode")
    public String getRenderMode() {
        return this.getPSRawItemContainer().getRenderMode();
    }

    @Override
    @PSModelRTMeta(description="\u6362\u884c\u6a21\u5f0f", codelist="WrapMode", ignoredumpvalues="NOWRAP")
    public String getWrapMode() {
        return this.getPSRawItemContainer().getRawItemParam("WRAPMODE", "");
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5782\u76f4\u5bf9\u9f50\u6a21\u5f0f[VALIGN]", codelist="TextVAlign", hideempty2=true, ignoredumpvalues="MIDDLE")
    public String getVAlign() {
        return this.getPSRawItemContainer().getRawItemParam("VALIGN", "");
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u6c34\u5e73\u5bf9\u9f50\u6a21\u5f0f[HALIGN]", codelist="TextAlign", hideempty2=true, ignoredumpvalues="LEFT")
    public String getHAlign() {
        return this.getPSRawItemContainer().getRawItemParam("HALIGN", "");
    }
}

