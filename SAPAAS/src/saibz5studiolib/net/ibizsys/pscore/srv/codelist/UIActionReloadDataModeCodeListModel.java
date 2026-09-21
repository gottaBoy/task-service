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

@CodeList(id="C5BDE9F5-E550-4148-B235-D746D0DC5E06", name="\u754c\u9762\u884c\u4e3a\u91cd\u65b0\u52a0\u8f7d\u6570\u636e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u65e0\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u5f15\u7528\u89c6\u56fe\u6216\u6811\u8282\u70b9", realtext="\u5f15\u7528\u89c6\u56fe\u6216\u6811\u8282\u70b9", userdata="\u5f53\u524d\u5f15\u7528\u89c6\u56fe\u6216\u662f\u6811\u8282\u70b9"), @CodeItem(value="2", text="\u5f15\u7528\u6811\u8282\u70b9\u7236\u8282\u70b9", realtext="\u5f15\u7528\u6811\u8282\u70b9\u7236\u8282\u70b9", userdata="\u5237\u65b0\u5f15\u7528\u6811\u8282\u70b9\u7684\u4e0a\u7ea7\u8282\u70b9"), @CodeItem(value="3", text="\u5f15\u7528\u6811\u8282\u70b9\u6839\u8282\u70b9", realtext="\u5f15\u7528\u6811\u8282\u70b9\u6839\u8282\u70b9", userdata="\u5237\u65b0\u5f15\u7528\u6811\u8282\u70b9\u7684\u6839\u8282\u70b9\uff0c\u5237\u65b0\u6574\u4e2a\u6811")})
public class UIActionReloadDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer DEFAULT = 1;
    public static final int INT_DEFAULT = 1;
    public static final Integer PARENTNODE = 2;
    public static final int INT_PARENTNODE = 2;
    public static final Integer ROOTNODE = 3;
    public static final int INT_ROOTNODE = 3;

    public UIActionReloadDataModeCodeListModel() {
        this.initAnnotation(UIActionReloadDataModeCodeListModel.class);
        this.setUserData2("UIActionReloadDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionReloadDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionReloadDataModeCodeListModel");
    }
}

