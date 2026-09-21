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

@CodeList(id="43739242-A794-42CC-94F5-F6400689EBCD", name="\u5b9e\u4f53\u6570\u636e\u6d41\u5927\u6570\u636e\u5e93\u6d88\u8d39\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BDTABLE", text="\u5927\u6570\u636e\u8868", realtext="\u5927\u6570\u636e\u8868"), @CodeItem(value="DEFGROUP", text="\u5b9e\u4f53\u5c5e\u6027\u7ec4", realtext="\u5b9e\u4f53\u5c5e\u6027\u7ec4")})
public class DEDataFlowSysBDSchemeSinkTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BDTABLE = "BDTABLE";
    public static final String DEFGROUP = "DEFGROUP";

    public DEDataFlowSysBDSchemeSinkTypeCodeListModel() {
        this.initAnnotation(DEDataFlowSysBDSchemeSinkTypeCodeListModel.class);
        this.setUserData2("DEDataFlowSysBDSchemeSinkType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysBDSchemeSinkTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysBDSchemeSinkTypeCodeListModel");
    }
}

