/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0722c2b457b8882dc0602d17c557fd85", name="\u7f29\u7565\u754c\u9762\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="FORM", text="\u8868\u5355", realtext="\u8868\u5355"), @CodeItem(value="PAGE", text="\u5185\u7f6e\u9875\u9762", realtext="\u5185\u7f6e\u9875\u9762")})
public abstract class CodeList7CodeListModelBase
extends StaticCodeListModelBase {
    public static final String FORM = "FORM";
    public static final String PAGE = "PAGE";

    public CodeList7CodeListModelBase() {
        this.initAnnotation(CodeList7CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList7CodeListModel", this);
    }
}

