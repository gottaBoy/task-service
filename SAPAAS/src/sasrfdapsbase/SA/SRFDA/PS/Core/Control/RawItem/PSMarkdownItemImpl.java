/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.RawItem.IPSMarkdownItem;
import SA.SRFDA.PS.Core.Control.RawItem.PSRawItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSRawItemBase", typevalues={"MARKDOWN"})
public class PSMarkdownItemImpl
extends PSRawItemImplBase
implements IPSMarkdownItem {
    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        if (this.getPSRawItemContainer().getPSSysResource() != null) {
            return this.getPSRawItemContainer().getPSSysResource().getContent();
        }
        return this.getPSRawItemContainer().getContent();
    }
}

