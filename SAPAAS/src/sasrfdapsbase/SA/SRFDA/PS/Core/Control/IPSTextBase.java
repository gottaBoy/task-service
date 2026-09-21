/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u6587\u672c\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSTextBase {
    public static final String PARAM_WRAPMODE = "WRAPMODE";
    public static final String PARAM_VALIGN = "VALIGN";
    public static final String PARAM_HALIGN = "HALIGN";

    public String getCaption();

    public String getRenderMode();

    public String getWrapMode();

    public String getVAlign();

    public String getHAlign();
}

