/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="182e9b4bb6bcab7216fb161b5af86790", name="\u52a8\u6001\u9762\u677f\u5206\u533a\u7f29\u653e\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EXPAND", text="\u5c55\u5f00", realtext="\u5c55\u5f00"), @CodeItem(value="COLLAPSE", text="\u6536\u7f29", realtext="\u6536\u7f29")})
public abstract class CodeList93CodeListModelBase
extends StaticCodeListModelBase {
    public static final String EXPAND = "EXPAND";
    public static final String COLLAPSE = "COLLAPSE";

    public CodeList93CodeListModelBase() {
        this.initAnnotation(CodeList93CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList93CodeListModel", this);
    }
}

