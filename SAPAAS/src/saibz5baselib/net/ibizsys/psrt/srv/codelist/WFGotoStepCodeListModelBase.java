/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;

@CodeList(id="55EFBB82-1A34-4570-9656-B0124C6A9423", name="\u5de5\u4f5c\u6d41\u754c\u9762\u5411\u5bfc\u8df3\u8f6c\u6b65\u9aa4", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class WFGotoStepCodeListModelBase
extends DynamicCodeListModelBase {
    public WFGotoStepCodeListModelBase() {
        this.initAnnotation(WFGotoStepCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel");
    }
}

