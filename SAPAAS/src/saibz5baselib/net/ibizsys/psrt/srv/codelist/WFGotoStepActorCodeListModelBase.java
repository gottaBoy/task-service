/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;

@CodeList(id="809A3060-7840-4678-8754-1CFD92B9B720", name="\u5de5\u4f5c\u6d41\u754c\u9762\u5411\u5bfc\u8df3\u8f6c\u6b65\u9aa4\u64cd\u4f5c\u7528\u6237", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class WFGotoStepActorCodeListModelBase
extends DynamicCodeListModelBase {
    public WFGotoStepActorCodeListModelBase() {
        this.initAnnotation(WFGotoStepActorCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel");
    }
}

