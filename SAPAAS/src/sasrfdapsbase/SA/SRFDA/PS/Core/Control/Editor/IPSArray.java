/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSNumberEditor;
import SA.SRFDA.PS.Core.Control.Editor.IPSTextEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6570\u7ec4\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"ARRAY", "MOBARRAY"})
public interface IPSArray
extends IPSTextEditor,
IPSNumberEditor {
    public static final String EDITORPARAM_DATATYPE = "DATATYPE";
    public static final String EDITORPARAM_DEFAULTARRAYDATATYPE = "DEFAULTARRAYDATATYPE";
    public static final String DATATYPE_STRING = "STRING";
    public static final String DATATYPE_NUMBER = "NUMBER";
    public static final String DATATYPE_INTEGER = "INTEGER";
    public static final String DATATYPE_URL = "URL";
    public static final String DATATYPE_IMAGE = "IMAGE";
    public static final String DATATYPE_MAIL = "MAIL";

    public String getDataType();
}

