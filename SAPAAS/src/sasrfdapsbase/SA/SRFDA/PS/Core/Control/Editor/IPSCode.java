/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSTextArea;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u4ee3\u7801\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"CODE", "MOBCODE"})
public interface IPSCode
extends IPSTextArea {
    public static final String EDITORPARAM_CODETYPE = "CODETYPE";
    public static final String EDITORPARAM_MINIMAP = "MINIMAP";
    public static final String EDITORPARAM_FULLSCREEN = "FULLSCREEN";

    public String getCodeType();

    public boolean isEnableMinimap();

    public boolean isEnableFullScreen();
}

