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

@CodeList(id="80244a99b3b9f03f7c919512d5dd70df", name="\u7528\u6237\u6570\u636e\u884c\u4e3a", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u65e0\u5efa\u7acb", realtext="\u65e0\u5efa\u7acb"), @CodeItem(value="2", text="\u65e0\u66f4\u65b0", realtext="\u65e0\u66f4\u65b0"), @CodeItem(value="4", text="\u65e0\u5220\u9664", realtext="\u65e0\u5220\u9664"), @CodeItem(value="8", text="\u65e0\u67e5\u770b", realtext="\u65e0\u67e5\u770b")})
public abstract class CodeList71CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_4 = "4";
    public static final String ITEM_8 = "8";

    public CodeList71CodeListModelBase() {
        this.initAnnotation(CodeList71CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel");
    }
}

