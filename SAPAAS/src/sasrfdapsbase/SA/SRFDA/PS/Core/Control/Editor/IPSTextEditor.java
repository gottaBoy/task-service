/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelInterfaceMeta(title="\u6587\u672c\u7f16\u8f91\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSTextEditor
extends IPSEditor {
    public static final String EDITORPARAM_MAXLENGTH = "MAXLENGTH";
    public static final String EDITORPARAM_MINLENGTH = "MINLENGTH";
    public static final String EDITORPARAM_DEFAULTMAXLENGTH = "DEFAULTMAXLENGTH";
    public static final String EDITORPARAM_DEFAULTMINLENGTH = "DEFAULTMINLENGTH";
    public static final String EDITORPARAM_SHOWMAXLENGTH = "SHOWMAXLENGTH";

    public Integer getMaxLength();

    public Integer getMinLength();

    public IPSSysValueRule getPSSysValueRule() throws Exception;

    public boolean isShowMaxLength();

    public IPSCodeList getPSCodeList();

    public IPSAppCodeList getPSAppCodeList();
}

