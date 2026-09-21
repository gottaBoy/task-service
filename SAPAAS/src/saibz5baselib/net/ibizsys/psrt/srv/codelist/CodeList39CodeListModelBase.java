/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b19a68e5affe4c7984e6f82124d8eae0", name="\u6587\u4ef6\u7f16\u7801", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ANSI", text="ANSI", realtext="ANSI"), @CodeItem(value="UTF-8", text="UTF-8", realtext="UTF-8")})
public abstract class CodeList39CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ANSI = "ANSI";
    public static final String UTF_SUB_8 = "UTF-8";

    public CodeList39CodeListModelBase() {
        this.initAnnotation(CodeList39CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList39CodeListModel", this);
    }
}

