/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="ad1b5c4ab74e4f1bb645257d58586b5b", name="\u62a5\u8868\u8f93\u51fa\u683c\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PDF", text="PDF", realtext="PDF"), @CodeItem(value="EXCEL", text="EXCEL", realtext="EXCEL"), @CodeItem(value="HTML", text="HTML", realtext="HTML")})
public abstract class CodeList54CodeListModelBase
extends StaticCodeListModelBase {
    public static final String PDF = "PDF";
    public static final String EXCEL = "EXCEL";
    public static final String HTML = "HTML";

    public CodeList54CodeListModelBase() {
        this.initAnnotation(CodeList54CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList54CodeListModel", this);
    }
}

