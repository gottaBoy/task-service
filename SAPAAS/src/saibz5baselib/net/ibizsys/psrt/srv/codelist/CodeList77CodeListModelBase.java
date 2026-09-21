/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="87f5acf6e2c3b136d0280133a42f2890", name="\u8868\u5355\u5d4c\u5165\u8868\u683c\u5de5\u5177\u680f\u80fd\u529b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INSERT", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="ROWEDIT", text="\u542f\u7528\u884c\u7f16\u8f91", realtext="\u542f\u7528\u884c\u7f16\u8f91")})
public abstract class CodeList77CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String ROWEDIT = "ROWEDIT";

    public CodeList77CodeListModelBase() {
        this.initAnnotation(CodeList77CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList77CodeListModel", this);
    }
}

