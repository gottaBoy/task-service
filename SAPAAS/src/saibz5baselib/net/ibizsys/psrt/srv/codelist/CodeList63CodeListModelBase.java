/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="271cd41fbe4d765ae22c8f88be592896", name="\u9875\u9762\u53c2\u6570\u503c\u53d8\u91cf", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PARAM1", text="\u53c2\u65701(\u5b57\u7b26)", realtext="\u53c2\u65701(\u5b57\u7b26)"), @CodeItem(value="PARAM2", text="\u53c2\u65702(\u5b57\u7b26)", realtext="\u53c2\u65702(\u5b57\u7b26)")})
public abstract class CodeList63CodeListModelBase
extends StaticCodeListModelBase {
    public static final String PARAM1 = "PARAM1";
    public static final String PARAM2 = "PARAM2";

    public CodeList63CodeListModelBase() {
        this.initAnnotation(CodeList63CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList63CodeListModel", this);
    }
}

