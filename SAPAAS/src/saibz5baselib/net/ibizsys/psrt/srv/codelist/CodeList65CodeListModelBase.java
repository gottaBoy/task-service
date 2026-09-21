/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d15219b301d6e4024ff1d17b1f90874c", name="\u6570\u636e\u5e93\u89e6\u53d1\u5668\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="BEFORE", text="Before", realtext="Before"), @CodeItem(value="AFTER", text="After", realtext="After"), @CodeItem(value="INSTEADOF", text="Instead of", realtext="Instead of")})
public abstract class CodeList65CodeListModelBase
extends StaticCodeListModelBase {
    public static final String BEFORE = "BEFORE";
    public static final String AFTER = "AFTER";
    public static final String INSTEADOF = "INSTEADOF";

    public CodeList65CodeListModelBase() {
        this.initAnnotation(CodeList65CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList65CodeListModel", this);
    }
}

