/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="bd8c17546daf9605625319a4751a1e2e", name="\u5f00\u53d1\u6570\u636e\u7248\u672c\u63a7\u5236\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CHECKIN", text="\u7b7e\u5165", realtext="\u7b7e\u5165"), @CodeItem(value="CHECKOUT", text="\u7b7e\u51fa", realtext="\u7b7e\u51fa")})
public abstract class CodeList115CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CHECKIN = "CHECKIN";
    public static final String CHECKOUT = "CHECKOUT";

    public CodeList115CodeListModelBase() {
        this.initAnnotation(CodeList115CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList115CodeListModel", this);
    }
}

