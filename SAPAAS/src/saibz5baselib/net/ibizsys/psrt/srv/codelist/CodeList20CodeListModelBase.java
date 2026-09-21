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

@CodeList(id="4bc7f1433da3a22f25eff878790f0be5", name="\u4ee3\u7801\u8868\u6216\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="NUMBERORMODE", text="\u6570\u5b57\u6216\u5904\u7406", realtext="\u6570\u5b57\u6216\u5904\u7406"), @CodeItem(value="STRINGORMODE", text="\u6587\u672c\u6216\u6a21\u5f0f", realtext="\u6587\u672c\u6216\u6a21\u5f0f")})
public abstract class CodeList20CodeListModelBase
extends StaticCodeListModelBase {
    public static final String NUMBERORMODE = "NUMBERORMODE";
    public static final String STRINGORMODE = "STRINGORMODE";

    public CodeList20CodeListModelBase() {
        this.initAnnotation(CodeList20CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel");
    }
}

