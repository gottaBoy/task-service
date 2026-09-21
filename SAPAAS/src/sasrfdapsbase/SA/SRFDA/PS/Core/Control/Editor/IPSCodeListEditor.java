/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u4ee3\u7801\u8868\u7f16\u8f91\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSCodeListEditor
extends IPSEditor {
    public static final String EDITORPARAM_ARRAY = "ARRAY";
    public static final String EDITORPARAM_DEFAULTARRAY = "DEFAULTARRAY";
    public static final String EDITORPARAM_ALLITEMS = "ALLITEMS";
    public static final String EDITORPARAM_DEFAULTALLITEMS = "DEFAULTALLITEMS";
    public static final String EDITORPARAM_ALLITEMSTEXT = "ALLITEMSTEXT";
    public static final String EDITORPARAM_DEFAULTALLITEMSTEXT = "DEFAULTALLITEMSTEXT";

    public IPSCodeList getPSCodeList();

    public IPSAppCodeList getPSAppCodeList();

    public IPSAppCodeList getInlinePSAppCodeList();

    public boolean isArray();

    public boolean isAllItems();

    public String getAllItemsText();
}

