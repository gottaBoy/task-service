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

@CodeList(id="efd8309a059f41e707b3ec155dfb8100", name="\u89c6\u56fe\u90e8\u4ef6\u5f02\u6b65\u8bf7\u6c42\u5904\u7406", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5168\u90e8\u8bf7\u6c42", realtext="\u5168\u90e8\u8bf7\u6c42"), @CodeItem(value="1", text="\u89c6\u56fe\u6ce8\u518c\u754c\u9762\u884c\u4e3a", realtext="\u89c6\u56fe\u6ce8\u518c\u754c\u9762\u884c\u4e3a")})
public class ViewCtrlAjaxProcessModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ALL = 0;
    public static final int INT_ALL = 0;
    public static final Integer VIEWUAONLY = 1;
    public static final int INT_VIEWUAONLY = 1;

    public ViewCtrlAjaxProcessModeCodeListModel() {
        this.initAnnotation(ViewCtrlAjaxProcessModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewCtrlAjaxProcessModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewCtrlAjaxProcessModeCodeListModel");
    }
}

