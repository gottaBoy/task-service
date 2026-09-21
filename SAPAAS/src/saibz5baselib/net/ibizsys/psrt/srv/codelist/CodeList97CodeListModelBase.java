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

@CodeList(id="fce0a2be420665e49abcb647a02f3460", name="\u6570\u636e\u540c\u6b65\u65b9\u5411", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="IN", text="\u8f93\u5165", realtext="\u8f93\u5165"), @CodeItem(value="OUT", text="\u8f93\u51fa", realtext="\u8f93\u51fa")})
public abstract class CodeList97CodeListModelBase
extends StaticCodeListModelBase {
    public static final String IN = "IN";
    public static final String OUT = "OUT";

    public CodeList97CodeListModelBase() {
        this.initAnnotation(CodeList97CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel");
    }
}

