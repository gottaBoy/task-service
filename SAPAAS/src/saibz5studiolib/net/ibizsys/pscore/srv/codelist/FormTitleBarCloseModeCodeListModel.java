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

@CodeList(id="ecfac86be2bcc91397879989211afb69", name="\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u5173\u95ed", realtext="\u65e0\u5173\u95ed"), @CodeItem(value="1", text="\u542f\u7528\u5173\u95ed\uff08\u9ed8\u8ba4\u6253\u5f00\uff09", realtext="\u542f\u7528\u5173\u95ed\uff08\u9ed8\u8ba4\u6253\u5f00\uff09"), @CodeItem(value="2", text="\u542f\u7528\u5173\u95ed\uff08\u9ed8\u8ba4\u5173\u95ed\uff09", realtext="\u542f\u7528\u5173\u95ed\uff08\u9ed8\u8ba4\u5173\u95ed\uff09")})
public class FormTitleBarCloseModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer OPENDEFAULT = 1;
    public static final int INT_OPENDEFAULT = 1;
    public static final Integer CLOSEDEFAULT = 2;
    public static final int INT_CLOSEDEFAULT = 2;

    public FormTitleBarCloseModeCodeListModel() {
        this.initAnnotation(FormTitleBarCloseModeCodeListModel.class);
        this.setUserData2("GroupTitleBarCloseMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
    }
}

