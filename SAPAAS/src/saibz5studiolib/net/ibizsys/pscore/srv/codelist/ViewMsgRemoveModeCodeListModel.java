/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="D4310BE0-4D1F-4BFC-ACAC-66A4BAC7C849", name="\u89c6\u56fe\u6d88\u606f\u5220\u9664\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u5173\u95ed", realtext="\u65e0\u5173\u95ed"), @CodeItem(value="1", text="\u9ed8\u8ba4\u5173\u95ed", realtext="\u9ed8\u8ba4\u5173\u95ed", userdata="\u89c6\u56fe\u6d88\u606f\u5173\u95ed\u6389\u4e0d\u518d\u51fa\u73b0"), @CodeItem(value="2", text="\u672c\u6b21\u5173\u95ed", realtext="\u672c\u6b21\u5173\u95ed", userdata="\u89c6\u56fe\u6d88\u606f\u672c\u6b21\u5173\u95ed\uff0c\u4e0b\u6b21\u4f1a\u7ee7\u7eed\u663e\u793a")})
public class ViewMsgRemoveModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer ALWAYS = 1;
    public static final int INT_ALWAYS = 1;
    public static final Integer ONCE = 2;
    public static final int INT_ONCE = 2;

    public ViewMsgRemoveModeCodeListModel() {
        this.initAnnotation(ViewMsgRemoveModeCodeListModel.class);
        this.setUserData2("ViewMsgRemoveMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgRemoveModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgRemoveModeCodeListModel");
    }
}

