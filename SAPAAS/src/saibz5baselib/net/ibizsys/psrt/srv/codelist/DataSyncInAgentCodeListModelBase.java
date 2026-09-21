/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;

@CodeList(id="de1a16047efd7cdfcbda77df156c73df", name="\u6570\u636e\u540c\u6b65\u4ee3\u7406\uff08\u8f93\u5165\uff09", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class DataSyncInAgentCodeListModelBase
extends DynamicCodeListModelBase {
    public DataSyncInAgentCodeListModelBase() {
        this.initAnnotation(DataSyncInAgentCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel");
    }
}

