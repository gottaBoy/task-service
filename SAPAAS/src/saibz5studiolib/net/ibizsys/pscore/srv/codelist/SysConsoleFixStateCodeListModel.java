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

@CodeList(id="5c40f3aa5512508271ce6e106def0dbb", name="\u63a7\u5236\u53f0\u9519\u8bef\u4fee\u590d\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u4e0d\u652f\u6301")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u652f\u6301", realtext="\u4e0d\u652f\u6301"), @CodeItem(value="1", text="\u53ef\u4fee\u590d", realtext="\u53ef\u4fee\u590d"), @CodeItem(value="2", text="\u5df2\u4fee\u590d", realtext="\u5df2\u4fee\u590d")})
public class SysConsoleFixStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNSUPPORT = 0;
    public static final int INT_UNSUPPORT = 0;
    public static final Integer SUPPORT = 1;
    public static final int INT_SUPPORT = 1;
    public static final Integer FIX = 2;
    public static final int INT_FIX = 2;

    public SysConsoleFixStateCodeListModel() {
        this.initAnnotation(SysConsoleFixStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel");
    }
}

