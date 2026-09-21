/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="62e71980ba833da6da5d2114ccb7c620", name="\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6b65\u9aa4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="GETDEFAULT", text="\u83b7\u53d6\u9ed8\u8ba4\u503c", realtext="\u83b7\u53d6\u9ed8\u8ba4\u503c"), @CodeItem(value="BEFORESAVE", text="\u4fdd\u5b58\u4e4b\u524d", realtext="\u4fdd\u5b58\u4e4b\u524d"), @CodeItem(value="AFTERSAVE", text="\u4fdd\u5b58\u4e4b\u540e", realtext="\u4fdd\u5b58\u4e4b\u540e"), @CodeItem(value="BEFOREREMOVE", text="\u5220\u9664\u4e4b\u524d", realtext="\u5220\u9664\u4e4b\u524d"), @CodeItem(value="AFTERREMOVE", text="\u5220\u9664\u4e4b\u540e", realtext="\u5220\u9664\u4e4b\u540e"), @CodeItem(value="TESTSAVE", text="\u6d4b\u8bd5\u4fdd\u5b58", realtext="\u6d4b\u8bd5\u4fdd\u5b58"), @CodeItem(value="CUSTOMCALL", text="\u81ea\u5b9a\u4e49\u64cd\u4f5c", realtext="\u81ea\u5b9a\u4e49\u64cd\u4f5c"), @CodeItem(value="INTERNALCALL", text="\u5185\u90e8\u8c03\u7528", realtext="\u5185\u90e8\u8c03\u7528")})
public abstract class CodeList106CodeListModelBase
extends StaticCodeListModelBase {
    public static final String GETDEFAULT = "GETDEFAULT";
    public static final String BEFORESAVE = "BEFORESAVE";
    public static final String AFTERSAVE = "AFTERSAVE";
    public static final String BEFOREREMOVE = "BEFOREREMOVE";
    public static final String AFTERREMOVE = "AFTERREMOVE";
    public static final String TESTSAVE = "TESTSAVE";
    public static final String CUSTOMCALL = "CUSTOMCALL";
    public static final String INTERNALCALL = "INTERNALCALL";

    public CodeList106CodeListModelBase() {
        this.initAnnotation(CodeList106CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList106CodeListModel", this);
    }
}

