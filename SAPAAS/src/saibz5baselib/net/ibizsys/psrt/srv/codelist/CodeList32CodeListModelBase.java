/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b7887b6761ae42ad82505631b68dde9d", name="\u65e5\u5fd7\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="50000", text="\u81f4\u547d(FATAL)", realtext="\u81f4\u547d(FATAL)"), @CodeItem(value="40000", text="\u9519\u8bef(ERROR)", realtext="\u9519\u8bef(ERROR)"), @CodeItem(value="30000", text="\u8b66\u544a(WARN)", realtext="\u8b66\u544a(WARN)"), @CodeItem(value="20000", text="\u4fe1\u606f(INFO)", realtext="\u4fe1\u606f(INFO)"), @CodeItem(value="10000", text="\u8c03\u8bd5(DEBUG)", realtext="\u8c03\u8bd5(DEBUG)"), @CodeItem(value="5000", text="\u8c03\u8bd5(TRACE)", realtext="\u8c03\u8bd5(TRACE)")})
public abstract class CodeList32CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_50000 = "50000";
    public static final String ITEM_40000 = "40000";
    public static final String ITEM_30000 = "30000";
    public static final String ITEM_20000 = "20000";
    public static final String ITEM_10000 = "10000";
    public static final String ITEM_5000 = "5000";

    public CodeList32CodeListModelBase() {
        this.initAnnotation(CodeList32CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList32CodeListModel", this);
    }
}

