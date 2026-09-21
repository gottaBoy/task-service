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

@CodeList(id="0d947aa77b9ea53b3a069eb655d69dc5", name="DA\u65e5\u5fd7\u64cd\u4f5c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CREATE", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664")})
public abstract class CodeList24CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    public CodeList24CodeListModelBase() {
        this.initAnnotation(CodeList24CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel");
    }
}

