/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.RawItem.IPSHtmlItem;
import SA.SRFDA.PS.Core.Control.RawItem.PSRawItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSRawItemBase", typevalues={"HTML"})
public class PSHtmlItemImpl
extends PSRawItemImplBase
implements IPSHtmlItem {
    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        if (this.getPSRawItemContainer().getPSSysResource() != null) {
            return this.getPSRawItemContainer().getPSSysResource().getContent();
        }
        return this.getPSRawItemContainer().getContent();
    }
}

