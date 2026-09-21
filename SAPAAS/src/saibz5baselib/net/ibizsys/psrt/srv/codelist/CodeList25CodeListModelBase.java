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

@CodeList(id="439db79fec36426cb354d983b6b2b117", name="\u5b57\u6bb5\u6392\u5e8f\u65b9\u5411", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ASC", text="\u5347\u5e8f", realtext="\u5347\u5e8f"), @CodeItem(value="DESC", text="\u964d\u5e8f", realtext="\u964d\u5e8f")})
public abstract class CodeList25CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public CodeList25CodeListModelBase() {
        this.initAnnotation(CodeList25CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel");
    }
}

