/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0c29f7bdeef16549e16a83da2102ef24", name="\u6570\u636e\u64cd\u4f5c\u6b65\u9aa4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="USERDECLARE", text="\u53d8\u91cf\u5b9a\u4e49", realtext="\u53d8\u91cf\u5b9a\u4e49"), @CodeItem(value="USERINIT", text="\u53d8\u91cf\u521d\u59cb\u5316", realtext="\u53d8\u91cf\u521d\u59cb\u5316"), @CodeItem(value="INPUTCHECK", text="\u6570\u636e\u68c0\u67e5", realtext="\u6570\u636e\u68c0\u67e5"), @CodeItem(value="BEFOREACTION", text="\u64cd\u4f5c\u4e4b\u524d", realtext="\u64cd\u4f5c\u4e4b\u524d"), @CodeItem(value="EXECUTEACTION", text="\u6267\u884c\u64cd\u4f5c", realtext="\u6267\u884c\u64cd\u4f5c"), @CodeItem(value="AFTERACTION", text="\u64cd\u4f5c\u4e4b\u540e", realtext="\u64cd\u4f5c\u4e4b\u540e")})
public abstract class CodeList11CodeListModelBase
extends StaticCodeListModelBase {
    public static final String USERDECLARE = "USERDECLARE";
    public static final String USERINIT = "USERINIT";
    public static final String INPUTCHECK = "INPUTCHECK";
    public static final String BEFOREACTION = "BEFOREACTION";
    public static final String EXECUTEACTION = "EXECUTEACTION";
    public static final String AFTERACTION = "AFTERACTION";

    public CodeList11CodeListModelBase() {
        this.initAnnotation(CodeList11CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList11CodeListModel", this);
    }
}

