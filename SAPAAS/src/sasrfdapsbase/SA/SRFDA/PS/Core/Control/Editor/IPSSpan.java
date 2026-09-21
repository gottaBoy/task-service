/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSCodeListEditor;
import SA.SRFDA.PS.Core.Control.IPSTextBase;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6807\u7b7e\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SPAN", "SPANEX", "SPAN_LINK"})
public interface IPSSpan
extends IPSCodeListEditor,
IPSTextBase {
    public static final String PARAM_LINKVIEW = "LINKVIEW";

    public boolean isEnableLinkView();

    public IPSAppView getLinkPSAppView() throws Exception;

    public Integer getPrecision();
}

