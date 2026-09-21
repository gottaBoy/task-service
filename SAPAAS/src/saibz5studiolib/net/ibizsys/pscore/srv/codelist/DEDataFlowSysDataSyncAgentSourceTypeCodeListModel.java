/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="D88E388E-9B2B-4069-B906-0467847D9E4C", name="\u5b9e\u4f53\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6e90\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RAW", text="\u76f4\u63a5\u6d41", realtext="\u76f4\u63a5\u6d41")})
public class DEDataFlowSysDataSyncAgentSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RAW = "RAW";

    public DEDataFlowSysDataSyncAgentSourceTypeCodeListModel() {
        this.initAnnotation(DEDataFlowSysDataSyncAgentSourceTypeCodeListModel.class);
        this.setUserData2("DEDataFlowSysDataSyncAgentSourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDataSyncAgentSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDataSyncAgentSourceTypeCodeListModel");
    }
}

