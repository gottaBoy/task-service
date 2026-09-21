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

@CodeList(id="FC518738-6110-40DB-8E58-E277EA4D095C", name="\u5bfc\u822a\u533a\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="1", text="\u542f\u7528\u5207\u6362\uff08\u9ed8\u8ba4\u663e\u793a\uff09", realtext="\u542f\u7528\u5207\u6362\uff08\u9ed8\u8ba4\u663e\u793a\uff09"), @CodeItem(value="2", text="\u652f\u6301\u5207\u6362\uff08\u9ed8\u8ba4\u9690\u85cf\uff09", realtext="\u652f\u6301\u5207\u6362\uff08\u9ed8\u8ba4\u9690\u85cf\uff09")})
public class ExpRegionShowModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public ExpRegionShowModeCodeListModel() {
        this.initAnnotation(ExpRegionShowModeCodeListModel.class);
        this.setUserData2("ExpRegionShowMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ExpRegionShowModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ExpRegionShowModeCodeListModel");
    }
}

