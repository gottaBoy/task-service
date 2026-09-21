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

@CodeList(id="f469066c2d6e62ab2bc15f68128e412d", name="\u95e8\u6237\u90e8\u4ef6\u4f7f\u7528\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5e94\u7528\u6570\u636e\u770b\u677f", realtext="\u5e94\u7528\u6570\u636e\u770b\u677f", userdata="\u95e8\u6237\u90e8\u4ef6\u4ec5\u652f\u6301\u653e\u7f6e\u5728\u5168\u5c40\u7684\u6570\u636e\u770b\u677f\u4e0a"), @CodeItem(value="2", text="\u5b9e\u4f53\u6570\u636e\u770b\u677f", realtext="\u5b9e\u4f53\u6570\u636e\u770b\u677f", userdata="\u95e8\u6237\u90e8\u4ef6\u4ec5\u652f\u6301\u653e\u7f6e\u5728\u5b9e\u4f53\u7684\u6570\u636e\u770b\u677f\u4e0a\uff0c\u95e8\u6237\u90e8\u4ef6\u9700\u8981\u6307\u5b9a\u5f53\u524d\u5b9e\u4f53\u7684\u503c"), @CodeItem(value="3", text="\u5e94\u7528\u53ca\u5b9e\u4f53\u6570\u636e\u770b\u677f", realtext="\u5e94\u7528\u53ca\u5b9e\u4f53\u6570\u636e\u770b\u677f", userdata="\u95e8\u6237\u90e8\u4ef6\u652f\u6301\u653e\u7f6e\u5728\u7cfb\u7edf\u6216\u5b9e\u4f53\u7684\u6570\u636e\u770b\u677f\u4e0a")})
public class DashboardScopeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer APP = 1;
    public static final int INT_APP = 1;
    public static final Integer DE = 2;
    public static final int INT_DE = 2;
    public static final Integer APPANDDE = 3;
    public static final int INT_APPANDDE = 3;

    public DashboardScopeCodeListModel() {
        this.initAnnotation(DashboardScopeCodeListModel.class);
        this.setUserData2("DashboardScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DashboardScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DashboardScopeCodeListModel");
    }
}

