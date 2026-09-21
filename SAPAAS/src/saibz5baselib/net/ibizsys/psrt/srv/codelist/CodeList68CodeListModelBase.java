/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b33f1e647b1defd975ffd25f50ab7a74", name="\u6570\u636e\u5e93\u89e6\u53d1\u5668\u76ee\u6807", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="TABLE", text="\u4e3b\u8868", realtext="\u4e3b\u8868"), @CodeItem(value="VIEW", text="\u89c6\u56fe", realtext="\u89c6\u56fe")})
public abstract class CodeList68CodeListModelBase
extends StaticCodeListModelBase {
    public static final String TABLE = "TABLE";
    public static final String VIEW = "VIEW";

    public CodeList68CodeListModelBase() {
        this.initAnnotation(CodeList68CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList68CodeListModel", this);
    }
}

