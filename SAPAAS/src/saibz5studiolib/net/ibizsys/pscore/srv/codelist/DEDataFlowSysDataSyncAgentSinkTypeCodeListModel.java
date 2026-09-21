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

@CodeList(id="ACD0A0EE-EACE-4577-9060-7C9055E271BA", name="\u5b9e\u4f53\u6570\u636e\u6d41\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6d88\u8d39\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RAW", text="\u76f4\u63a5\u6d41", realtext="\u76f4\u63a5\u6d41"), @CodeItem(value="DEDATASYNC", text="\u5b9e\u4f53\u6570\u636e\u540c\u6b65", realtext="\u5b9e\u4f53\u6570\u636e\u540c\u6b65")})
public class DEDataFlowSysDataSyncAgentSinkTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RAW = "RAW";
    public static final String DEDATASYNC = "DEDATASYNC";

    public DEDataFlowSysDataSyncAgentSinkTypeCodeListModel() {
        this.initAnnotation(DEDataFlowSysDataSyncAgentSinkTypeCodeListModel.class);
        this.setUserData2("DEDataFlowSysDataSyncAgentSinkType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDataSyncAgentSinkTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDataSyncAgentSinkTypeCodeListModel");
    }
}

