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

@CodeList(id="630AD7FF-5763-4C10-9401-4E82559827B5", name="\u5e73\u53f0\u6570\u636e\u540c\u6b65\u4ee3\u7406\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IN", text="\u8f93\u5165", realtext="\u8f93\u5165", userdata="\u4ece\u5916\u90e8\u7cfb\u7edf\u83b7\u53d6\u6570\u636e"), @CodeItem(value="OUT", text="\u8f93\u51fa", realtext="\u8f93\u51fa", userdata="\u5411\u5916\u90e8\u7cfb\u7edf\u53d1\u9001\u6570\u636e"), @CodeItem(value="INOUT", text="\u8f93\u5165\u8f93\u51fa", realtext="\u8f93\u5165\u8f93\u51fa")})
public class DataSyncAgentDirCodeListModel
extends StaticCodeListModelBase {
    public static final String IN = "IN";
    public static final String OUT = "OUT";
    public static final String INOUT = "INOUT";

    public DataSyncAgentDirCodeListModel() {
        this.initAnnotation(DataSyncAgentDirCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("DataSyncAgentDir");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncAgentDirCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncAgentDirCodeListModel");
    }
}

