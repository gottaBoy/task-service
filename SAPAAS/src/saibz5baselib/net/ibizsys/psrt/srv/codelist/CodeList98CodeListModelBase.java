/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="77306567198d33a2eaaab5dcf63db0a5", name="\u6570\u636e\u901a\u77e5\u76d1\u63a7\u884c\u4e3a\uff08\u65b0\u5efa\u3001\u66f4\u65b0\u3001\u5220\u9664\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="4", text="\u5220\u9664", realtext="\u5220\u9664")})
public abstract class CodeList98CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_4 = "4";

    public CodeList98CodeListModelBase() {
        this.initAnnotation(CodeList98CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList98CodeListModel", this);
    }
}

