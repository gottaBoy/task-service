/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="7e7ebb43ec50bca7337e0512df3b4a24", name="\u6570\u636e\u901a\u77e5\u53d6\u503c\u89c4\u5219", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="AFTER", text="\u53d8\u66f4\u540e", realtext="\u53d8\u66f4\u540e"), @CodeItem(value="BEFORE", text="\u53d8\u66f4\u524d", realtext="\u53d8\u66f4\u524d"), @CodeItem(value="CHANGE", text="\u503c\u53d8\u66f4", realtext="\u503c\u53d8\u66f4")})
public abstract class CodeList69CodeListModelBase
extends StaticCodeListModelBase {
    public static final String AFTER = "AFTER";
    public static final String BEFORE = "BEFORE";
    public static final String CHANGE = "CHANGE";

    public CodeList69CodeListModelBase() {
        this.initAnnotation(CodeList69CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList69CodeListModel", this);
    }
}

