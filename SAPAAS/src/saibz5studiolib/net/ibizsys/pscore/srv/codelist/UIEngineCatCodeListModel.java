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

@CodeList(id="46a96cb98a2389d2441b4bbeeb7dc931", name="\u754c\u9762\u5f15\u64ce\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VIEW", text="\u5185\u7f6e\u89c6\u56fe\u754c\u9762\u5f15\u64ce", realtext="\u5185\u7f6e\u89c6\u56fe\u754c\u9762\u5f15\u64ce"), @CodeItem(value="UXVIEW", text="\u6269\u5c55\u89c6\u56fe\u754c\u9762\u5f15\u64ce", realtext="\u6269\u5c55\u89c6\u56fe\u754c\u9762\u5f15\u64ce"), @CodeItem(value="CTRL", text="\u90e8\u4ef6\u4ea4\u4e92\u754c\u9762\u5f15\u64ce", realtext="\u90e8\u4ef6\u4ea4\u4e92\u754c\u9762\u5f15\u64ce"), @CodeItem(value="CUSTOM", text="\u7528\u6237\u81ea\u5efa", realtext="\u7528\u6237\u81ea\u5efa")})
public class UIEngineCatCodeListModel
extends StaticCodeListModelBase {
    public static final String VIEW = "VIEW";
    public static final String UXVIEW = "UXVIEW";
    public static final String CTRL = "CTRL";
    public static final String CUSTOM = "CUSTOM";

    public UIEngineCatCodeListModel() {
        this.initAnnotation(UIEngineCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIEngineCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIEngineCatCodeListModel");
    }
}

