/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSSpan;
import SA.SRFDA.PS.Core.Control.Editor.PSCodeListEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"SPAN", "SPANEX", "SPAN_LINK"})
public class PSSpanImpl
extends PSCodeListEditorImpl
implements IPSSpan {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", ignoredumpvalues="false")
    public boolean isEditable() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u94fe\u63a5\u89c6\u56fe[LINKVIEW]")
    public boolean isEnableLinkView() {
        return this.getEditorParam("LINKVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u94fe\u63a5\u89c6\u56fe", dumpref=true)
    public IPSAppView getLinkPSAppView() throws Exception {
        return this.getPSEditorContainer().getRefLinkPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u6d6e\u70b9\u7cbe\u5ea6[PRECISION]")
    public Integer getPrecision() {
        return this.getEditorParam("PRECISION", this.getDefaultPrecision());
    }

    protected Integer getDefaultPrecision() {
        String strValue = this.getEditorParam("DEFAULTPRECISION", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getCaption() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u6a21\u5f0f", codelist="TextRenderMode")
    public String getRenderMode() {
        return this.getPSEditorContainer().getRenderMode();
    }

    @Override
    @PSModelRTMeta(description="\u6362\u884c\u6a21\u5f0f[WRAPMODE]", codelist="WrapMode", hideempty2=true, ignoredumpvalues="NOWRAP")
    public String getWrapMode() {
        return this.getEditorParam("WRAPMODE", "");
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5782\u76f4\u5bf9\u9f50\u6a21\u5f0f[VALIGN]", codelist="TextVAlign", hideempty2=true, ignoredumpvalues="MIDDLE")
    public String getVAlign() {
        return this.getEditorParam("VALIGN", "");
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u6c34\u5e73\u5bf9\u9f50\u6a21\u5f0f[HALIGN]", codelist="TextAlign", hideempty2=true, ignoredumpvalues="LEFT")
    public String getHAlign() {
        return this.getEditorParam("HALIGN", "");
    }
}

