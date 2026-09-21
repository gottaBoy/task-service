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

@CodeList(id="CAD75CD6-838C-46AC-9F95-55DB8FD73C66", name="\u5b9e\u4f53\u6570\u636e\u6d41\u6570\u636e\u5e93\u6e90\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DBTABLE", text="\u6570\u636e\u8868", realtext="\u6570\u636e\u8868"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6"), @CodeItem(value="DEDATAQUERY", text="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", realtext="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2"), @CodeItem(value="SQL", text="SQL\u4ee3\u7801", realtext="SQL\u4ee3\u7801")})
public class DEDataFlowSysDBSchemeSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DBTABLE = "DBTABLE";
    public static final String DEDATASET = "DEDATASET";
    public static final String DEDATAQUERY = "DEDATAQUERY";
    public static final String SQL = "SQL";

    public DEDataFlowSysDBSchemeSourceTypeCodeListModel() {
        this.initAnnotation(DEDataFlowSysDBSchemeSourceTypeCodeListModel.class);
        this.setUserData2("DEDataFlowSysDBSchemeSourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDBSchemeSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowSysDBSchemeSourceTypeCodeListModel");
    }
}

