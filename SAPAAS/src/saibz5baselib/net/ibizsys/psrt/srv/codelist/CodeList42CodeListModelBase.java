/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="1e8acf2ededdd5ba8c440d940b493ef1", name="\u6d88\u606f\u6a21\u677f\u5185\u5bb9\u7c7b\u578b", type="STATIC", userscope=false)
@CodeItems(value={@CodeItem(value="TEXT", text="\u7eaf\u6587\u672c", realtext="\u7eaf\u6587\u672c"), @CodeItem(value="HTML", text="HTML\u7f51\u9875", realtext="HTML\u7f51\u9875")})
public abstract class CodeList42CodeListModelBase
extends StaticCodeListModelBase {
    public static final String TEXT = "TEXT";
    public static final String HTML = "HTML";

    public CodeList42CodeListModelBase() {
        this.initAnnotation(CodeList42CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList42CodeListModel", this);
    }
}

