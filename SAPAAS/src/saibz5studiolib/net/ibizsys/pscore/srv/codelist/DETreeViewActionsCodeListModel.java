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

@CodeList(id="A636924D-BDB9-4E41-86AE-DF7DBE76B6C2", name="\u4e91\u5b9e\u4f53\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\uff08\u6811\u89c6\u56fe\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u652f\u6301\u5efa\u7acb", realtext="\u652f\u6301\u5efa\u7acb"), @CodeItem(value="2", text="\u652f\u6301\u7f16\u8f91", realtext="\u652f\u6301\u7f16\u8f91"), @CodeItem(value="4", text="\u652f\u6301\u67e5\u770b", realtext="\u652f\u6301\u67e5\u770b"), @CodeItem(value="8", text="\u652f\u6301\u5220\u9664", realtext="\u652f\u6301\u5220\u9664"), @CodeItem(value="16", text="\u652f\u6301\u62f7\u8d1d", realtext="\u652f\u6301\u62f7\u8d1d")})
public class DETreeViewActionsCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer VIEW = 4;
    public static final int INT_VIEW = 4;
    public static final Integer REMOVE = 8;
    public static final int INT_REMOVE = 8;
    public static final Integer COPY = 16;
    public static final int INT_COPY = 16;

    public DETreeViewActionsCodeListModel() {
        this.initAnnotation(DETreeViewActionsCodeListModel.class);
        this.setUserData2("CtrlUIAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeViewActionsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeViewActionsCodeListModel");
    }
}

