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

@CodeList(id="0629D3FB-45BC-4F87-A14C-61D1C3448960", name="\u7cfb\u7edf\u6570\u636e\u5e93\u8868\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATE", text="\u5efa\u7acb", realtext="\u5efa\u7acb"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="UPSERT", text="\u81ea\u52a8\u5efa\u7acb\u6216\u66f4\u65b0", realtext="\u81ea\u52a8\u5efa\u7acb\u6216\u66f4\u65b0"), @CodeItem(value="REPLACE", text="\u66ff\u6362", realtext="\u66ff\u6362"), @CodeItem(value="READ", text="\u83b7\u53d6", realtext="\u83b7\u53d6"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664")})
public class SysDBTableActionCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String UPSERT = "UPSERT";
    public static final String REPLACE = "REPLACE";
    public static final String READ = "READ";
    public static final String DELETE = "DELETE";

    public SysDBTableActionCodeListModel() {
        this.initAnnotation(SysDBTableActionCodeListModel.class);
        this.setUserData2("DBTableAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBTableActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBTableActionCodeListModel");
    }
}

