/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSRaw;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"RAW"})
public class PSRawImpl
extends PSEditorImpl
implements IPSRaw {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false")
    public boolean isEditable() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b[CONTENTTYPE]{RAW|HTML|IMAGE|MARKDOWN}", ignoredumpvalues="RAW")
    public String getContentType() {
        return this.getEditorParam("CONTENTTYPE", "RAW");
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u5185\u5bb9[TEMPLATE]")
    public String getTemplate() {
        return this.getEditorParam("TEMPLATE", "");
    }
}

