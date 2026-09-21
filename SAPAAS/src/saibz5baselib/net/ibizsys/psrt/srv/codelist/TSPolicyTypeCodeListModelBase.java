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

@CodeList(id="e7616bafaba6e474f4ee06340c6d47b1", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="GROUP", text="\u7b56\u7565\u7ec4", realtext="\u7b56\u7565\u7ec4"), @CodeItem(value="ITEM", text="\u7b56\u7565\u9879", realtext="\u7b56\u7565\u9879")})
public abstract class TSPolicyTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String ITEM = "ITEM";

    public TSPolicyTypeCodeListModelBase() {
        this.initAnnotation(TSPolicyTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel");
    }
}

