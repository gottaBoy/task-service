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

@CodeList(id="63A6B638-B3C5-446B-8A35-B60BA8B0EC79", name="\u5b9e\u4f53\u6570\u636e\u6d41\u6570\u636e\u5e93\u6d88\u8d39\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DBTABLE", text="\u6570\u636e\u8868", realtext="\u6570\u636e\u8868"), @CodeItem(value="DEFGROUP", text="\u5b9e\u4f53\u5c5e\u6027\u7ec4", realtext="\u5b9e\u4f53\u5c5e\u6027\u7ec4")})
public class DEDataFlowSysDBSchemeSinkTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DBTABLE = "DBTABLE";
    public static final String DEFGROUP = "DEFGROUP";

    public DEDataFlowSysDBSchemeSinkTypeCodeListModel() {
        this.initAnnotation(DEDataFlowSysDBSchemeSinkTypeCodeListModel.class);
        this.setUserData2("DEDataFlowSysDBSchemeSinkType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDBSchemeSinkTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDBSchemeSinkTypeCodeListModel");
    }
}

