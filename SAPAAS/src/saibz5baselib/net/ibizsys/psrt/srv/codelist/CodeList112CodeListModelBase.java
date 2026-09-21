/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0cc45b174e5994e6475000e524e154d1", name="\u5b9e\u4f53\u89c4\u5219\u5904\u7406_\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="VARCHAR", text="\u6587\u672c", realtext="\u6587\u672c"), @CodeItem(value="INT", text="\u6574\u5f62", realtext="\u6574\u5f62"), @CodeItem(value="FLOAT", text="\u6d6e\u70b9", realtext="\u6d6e\u70b9"), @CodeItem(value="DATETIME", text="\u65e5\u671f", realtext="\u65e5\u671f")})
public abstract class CodeList112CodeListModelBase
extends StaticCodeListModelBase {
    public static final String VARCHAR = "VARCHAR";
    public static final String INT = "INT";
    public static final String FLOAT = "FLOAT";
    public static final String DATETIME = "DATETIME";

    public CodeList112CodeListModelBase() {
        this.initAnnotation(CodeList112CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList112CodeListModel", this);
    }
}

