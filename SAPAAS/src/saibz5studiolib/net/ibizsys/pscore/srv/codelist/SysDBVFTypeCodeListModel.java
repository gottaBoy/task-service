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

@CodeList(id="0599b0488f877ec9cc312e3aa368e2f0", name="\u7cfb\u7edf\u6570\u636e\u5e93\u503c\u51fd\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PS", text="\u4e91\u5e73\u53f0\u5185\u7f6e", realtext="\u4e91\u5e73\u53f0\u5185\u7f6e"), @CodeItem(value="UX", text="\u7528\u6237\u6269\u5c55", realtext="\u7528\u6237\u6269\u5c55")})
public class SysDBVFTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PS = "PS";
    public static final String UX = "UX";

    public SysDBVFTypeCodeListModel() {
        this.initAnnotation(SysDBVFTypeCodeListModel.class);
        this.setUserData2("DBValueFuncType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBVFTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDBVFTypeCodeListModel");
    }
}

