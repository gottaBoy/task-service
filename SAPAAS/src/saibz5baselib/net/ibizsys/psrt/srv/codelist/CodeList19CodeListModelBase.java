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

@CodeList(id="584bb11071e826f19ad4da4ed4e2222f", name="\u5b9e\u4f53\u5f52\u5c5e", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="SRFDA", text="\u7cfb\u7edf", realtext="\u7cfb\u7edf"), @CodeItem(value="APPLICATION", text="\u5e94\u7528", realtext="\u5e94\u7528"), @CodeItem(value="USER", text="\u7528\u6237", realtext="\u7528\u6237")})
public abstract class CodeList19CodeListModelBase
extends StaticCodeListModelBase {
    public static final String SRFDA = "SRFDA";
    public static final String APPLICATION = "APPLICATION";
    public static final String USER = "USER";

    public CodeList19CodeListModelBase() {
        this.initAnnotation(CodeList19CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel");
    }
}

