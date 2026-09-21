/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="277ed862d320c30630c6197379bd1c80", name="\u5c5e\u6027\u5f15\u7528\u5173\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="DER1N", text="1:N\u5173\u7cfb", realtext="1:N\u5173\u7cfb"), @CodeItem(value="DERCUSTOM", text="\u81ea\u5b9a\u4e49\u5173\u7cfb", realtext="\u81ea\u5b9a\u4e49\u5173\u7cfb")})
public abstract class CodeList90CodeListModelBase
extends StaticCodeListModelBase {
    public static final String DER1N = "DER1N";
    public static final String DERCUSTOM = "DERCUSTOM";

    public CodeList90CodeListModelBase() {
        this.initAnnotation(CodeList90CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList90CodeListModel", this);
    }
}

