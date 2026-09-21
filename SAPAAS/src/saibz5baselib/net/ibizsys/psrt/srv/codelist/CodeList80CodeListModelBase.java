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

@CodeList(id="79e9fa593c9008f53d82dbc1b3776016", name="\u5b9e\u4f53\u5b58\u50a8\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001\u5b58\u50a8", realtext="\u9759\u6001\u5b58\u50a8"), @CodeItem(value="DYNAMIC", text="\u52a8\u6001\u5b58\u50a8", realtext="\u52a8\u6001\u5b58\u50a8"), @CodeItem(value="NONE", text="\u65e0\u5b58\u50a8", realtext="\u65e0\u5b58\u50a8")})
public abstract class CodeList80CodeListModelBase
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DYNAMIC = "DYNAMIC";
    public static final String NONE = "NONE";

    public CodeList80CodeListModelBase() {
        this.initAnnotation(CodeList80CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel");
    }
}

