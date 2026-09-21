/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="493b7805ad1d21a3fda2237355a7d871", name="\u5e94\u7528\u754c\u9762\u4e3b\u9898", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="APPUITHEME_DEFAULT", text="\u9ed8\u8ba4\u754c\u9762\u4e3b\u9898", realtext="\u9ed8\u8ba4\u754c\u9762\u4e3b\u9898"), @CodeItem(value="APPUITHEME_GRAY", text="\u754c\u9762\u4e3b\u9898\uff08\u7070\u8272\uff09", realtext="\u754c\u9762\u4e3b\u9898\uff08\u7070\u8272\uff09"), @CodeItem(value="APPUITHEME_RED", text="\u754c\u9762\u4e3b\u9898\uff08\u7ea2\u8272\uff09", realtext="\u754c\u9762\u4e3b\u9898\uff08\u7ea2\u8272\uff09"), @CodeItem(value="APPUITHEME_SLATE", text="\u754c\u9762\u4e3b\u9898\uff08\u77f3\u677f\u7070\uff09", realtext="\u754c\u9762\u4e3b\u9898\uff08\u77f3\u677f\u7070\uff09")})
public abstract class CodeList58CodeListModelBase
extends StaticCodeListModelBase {
    public static final String APPUITHEME_DEFAULT = "APPUITHEME_DEFAULT";
    public static final String APPUITHEME_GRAY = "APPUITHEME_GRAY";
    public static final String APPUITHEME_RED = "APPUITHEME_RED";
    public static final String APPUITHEME_SLATE = "APPUITHEME_SLATE";

    public CodeList58CodeListModelBase() {
        this.initAnnotation(CodeList58CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel");
    }
}

