/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="bb6e831c02e4811de3a22a995d9f2d12", name="\u6570\u636e\u901a\u77e5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="TIME", text="\u5b9a\u65f6", realtext="\u5b9a\u65f6"), @CodeItem(value="NORMAL", text="\u503c\u53d8\u66f4", realtext="\u503c\u53d8\u66f4"), @CodeItem(value="TIMEEX", text="\u5b9a\u65f6+\u503c\u5224\u65ad", realtext="\u5b9a\u65f6+\u503c\u5224\u65ad")})
public abstract class CodeList61CodeListModelBase
extends StaticCodeListModelBase {
    public static final String TIME = "TIME";
    public static final String NORMAL = "NORMAL";
    public static final String TIMEEX = "TIMEEX";

    public CodeList61CodeListModelBase() {
        this.initAnnotation(CodeList61CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList61CodeListModel", this);
    }
}

