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

@CodeList(id="d54260d064a4fea75dd5e1ee7b812790", name="\u5ba1\u8ba1\u64cd\u4f5c\u884c\u4e3a", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CREATE", text="\u5efa\u7acb", realtext="\u5efa\u7acb"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664")})
public abstract class AuditDEActionCodeListModelBase
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    public AuditDEActionCodeListModelBase() {
        this.initAnnotation(AuditDEActionCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel");
    }
}

