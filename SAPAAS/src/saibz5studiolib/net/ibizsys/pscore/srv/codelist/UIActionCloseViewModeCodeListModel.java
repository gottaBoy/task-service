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

@CodeList(id="73C35A21-173C-432A-91A8-5EF78D0078F9", name="\u754c\u9762\u884c\u4e3a\u5173\u95ed\u89c6\u56fe\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u5173\u95ed", realtext="\u4e0d\u5173\u95ed"), @CodeItem(value="1", text="\u5173\u95ed\uff08\u786e\u8ba4\uff09", realtext="\u5173\u95ed\uff08\u786e\u8ba4\uff09"), @CodeItem(value="2", text="\u5173\u95ed\uff08\u53d6\u6d88\uff09", realtext="\u5173\u95ed\uff08\u53d6\u6d88\uff09")})
public class UIActionCloseViewModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTCLOSE = 0;
    public static final int INT_NOTCLOSE = 0;
    public static final Integer CLOSE_OK = 1;
    public static final int INT_CLOSE_OK = 1;
    public static final Integer CLOSE_CANCEL = 2;
    public static final int INT_CLOSE_CANCEL = 2;

    public UIActionCloseViewModeCodeListModel() {
        this.initAnnotation(UIActionCloseViewModeCodeListModel.class);
        this.setUserData2("UIActionCloseViewMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionCloseViewModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionCloseViewModeCodeListModel");
    }
}

