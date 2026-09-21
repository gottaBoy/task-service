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

@CodeList(id="47AF5D35-9003-48E9-AB2F-D407AA0BD029", name="\u591a\u6570\u636e\u90e8\u4ef6\u5185\u7f6e\u5bfc\u822a\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4\u663e\u793a", realtext="\u9ed8\u8ba4\u663e\u793a"), @CodeItem(value="1", text="\u9ed8\u8ba4\u9690\u85cf", realtext="\u9ed8\u8ba4\u9690\u85cf"), @CodeItem(value="2", text="\u663e\u793a\uff08\u7a0b\u5e8f\u63a7\u5236\uff09", realtext="\u663e\u793a\uff08\u7a0b\u5e8f\u63a7\u5236\uff09"), @CodeItem(value="3", text="\u9690\u85cf\uff08\u7a0b\u5e8f\u63a7\u5236\uff09", realtext="\u9690\u85cf\uff08\u7a0b\u5e8f\u63a7\u5236\uff09")})
public class NavViewShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SHOWDEFAULT = 0;
    public static final int INT_SHOWDEFAULT = 0;
    public static final Integer HIDEDEFAULT = 1;
    public static final int INT_HIDEDEFAULT = 1;
    public static final Integer SHOW = 2;
    public static final int INT_SHOW = 2;
    public static final Integer HIDE = 3;
    public static final int INT_HIDE = 3;

    public NavViewShowModeCodeListModel() {
        this.initAnnotation(NavViewShowModeCodeListModel.class);
        this.setUserData2("NavViewShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.NavViewShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.NavViewShowModeCodeListModel");
    }
}

