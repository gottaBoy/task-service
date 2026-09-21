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

@CodeList(id="d5c9515f172104a64b4d7c42a81d770a", name="\u6570\u636e\u5b9e\u4f53_\u6253\u5370\u529f\u80fd", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ENABLE", text="\u63d0\u4f9b", realtext="\u63d0\u4f9b"), @CodeItem(value="DISABLE", text="\u4e0d\u63d0\u4f9b", realtext="\u4e0d\u63d0\u4f9b"), @CodeItem(value="AUTO", text="\u81ea\u52a8\u5224\u65ad", realtext="\u81ea\u52a8\u5224\u65ad")})
public abstract class DEPrintFuncCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ENABLE = "ENABLE";
    public static final String DISABLE = "DISABLE";
    public static final String AUTO = "AUTO";

    public DEPrintFuncCodeListModelBase() {
        this.initAnnotation(DEPrintFuncCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel");
    }
}

