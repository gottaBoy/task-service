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

@CodeList(id="c96649398a23bb5a1f6962e93515aaa7", name="\u83dc\u5355\u9879\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u529f\u80fd", realtext="\u65b0\u529f\u80fd"), @CodeItem(value="2", text="\u70ed\u95e8\u529f\u80fd", realtext="\u70ed\u95e8\u529f\u80fd")})
public class MenuItemStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NEW = 1;
    public static final int INT_NEW = 1;
    public static final Integer HOT = 2;
    public static final int INT_HOT = 2;

    public MenuItemStateCodeListModel() {
        this.initAnnotation(MenuItemStateCodeListModel.class);
        this.setUserData2("MenuItemState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MenuItemStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MenuItemStateCodeListModel");
    }
}

