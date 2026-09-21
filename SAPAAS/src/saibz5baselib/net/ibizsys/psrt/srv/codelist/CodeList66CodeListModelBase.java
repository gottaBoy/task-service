/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="48f8fa9e84cb9134562d9034af8ce962", name="\u6570\u636e\u5e93\u89e6\u53d1\u5668\u4e8b\u4ef6", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INSERT", text="Insert", realtext="Insert"), @CodeItem(value="UPDATE", text="Update", realtext="Update"), @CodeItem(value="DELETE", text="Delete", realtext="Delete")})
public abstract class CodeList66CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    public CodeList66CodeListModelBase() {
        this.initAnnotation(CodeList66CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList66CodeListModel", this);
    }
}

