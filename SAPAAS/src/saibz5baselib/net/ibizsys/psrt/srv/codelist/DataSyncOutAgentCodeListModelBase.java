/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;

@CodeList(id="720c59ea1cd758d0f5fc4d815ef826ab", name="\u6570\u636e\u540c\u6b65\u4ee3\u7406\uff08\u8f93\u51fa\uff09", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class DataSyncOutAgentCodeListModelBase
extends DynamicCodeListModelBase {
    public DataSyncOutAgentCodeListModelBase() {
        this.initAnnotation(DataSyncOutAgentCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DataSyncOutAgentCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DataSyncOutAgentCodeListModel");
    }
}

