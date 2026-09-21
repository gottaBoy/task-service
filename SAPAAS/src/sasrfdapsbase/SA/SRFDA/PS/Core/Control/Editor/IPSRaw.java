/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u76f4\u63a5\u5185\u5bb9\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"RAW"})
public interface IPSRaw
extends IPSEditor {
    public static final String EDITORPARAM_CONTENTTYPE = "CONTENTTYPE";
    public static final String EDITORPARAM_TEMPLATE = "TEMPLATE";

    public String getContentType();

    public String getTemplate();
}

