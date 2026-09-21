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

@CodeList(id="39c2d4cae93ef3bb3b870eeda9a7e4cf", name="\u7528\u6237\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="USER", text="\u7528\u6237", realtext="\u7528\u6237"), @CodeItem(value="USERGROUP", text="\u7528\u6237\u7ec4", realtext="\u7528\u6237\u7ec4")})
public abstract class CodeList5CodeListModelBase
extends StaticCodeListModelBase {
    public static final String USER = "USER";
    public static final String USERGROUP = "USERGROUP";

    public CodeList5CodeListModelBase() {
        this.initAnnotation(CodeList5CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel");
    }
}

