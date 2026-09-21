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

@CodeList(id="1d4e7da5672612464d0f950804264dee", name="\u6570\u636e\u540c\u6b65\u4ee3\u7406\u7c7b\u578b\uff08\u9759\u6001\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ACTIVEMQ", text="ActiveMQ", realtext="ActiveMQ")})
public abstract class DataSyncAgentTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ACTIVEMQ = "ACTIVEMQ";

    public DataSyncAgentTypeCodeListModelBase() {
        this.initAnnotation(DataSyncAgentTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel");
    }
}

