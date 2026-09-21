/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="c1362f43a191c5791c535059efcf6dac", name="\u65e5\u5386\u53c2\u4e0e\u8005\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="UNDECIDED", text="\u672a\u786e\u5b9a", realtext="\u672a\u786e\u5b9a"), @CodeItem(value="ACCEPT", text="\u63a5\u53d7", realtext="\u63a5\u53d7"), @CodeItem(value="REJECT", text="\u62d2\u7edd", realtext="\u62d2\u7edd")})
public abstract class CodeList15CodeListModelBase
extends StaticCodeListModelBase {
    public static final String UNDECIDED = "UNDECIDED";
    public static final String ACCEPT = "ACCEPT";
    public static final String REJECT = "REJECT";

    public CodeList15CodeListModelBase() {
        this.initAnnotation(CodeList15CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList15CodeListModel", this);
    }
}

