/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSCode;
import SA.SRFDA.PS.Core.Control.Editor.PSTextAreaImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"CODE", "MOBCODE"})
public class PSCodeImpl
extends PSTextAreaImpl
implements IPSCode {
    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u7c7b\u578b[CODETYPE]")
    public String getCodeType() {
        return this.getEditorParam("CODETYPE", "");
    }

    @Override
    protected boolean getDefaultShowMaxLength() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f29\u7565\u56fe[MINIMAP]", ignoredumpvalues="false")
    public boolean isEnableMinimap() {
        return this.getEditorParam("MINIMAP", false);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5168\u5c4f[FULLSCREEN]", ignoredumpvalues="false")
    public boolean isEnableFullScreen() {
        return this.getEditorParam("FULLSCREEN", false);
    }
}

