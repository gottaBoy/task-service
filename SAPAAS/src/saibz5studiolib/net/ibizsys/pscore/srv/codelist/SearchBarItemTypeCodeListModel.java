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

@CodeList(id="2f6a956cbe6cc1bb74caf2fd829a8ac3", name="\u641c\u7d22\u680f\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FILTER", text="\u8fc7\u6ee4\u9879", realtext="\u8fc7\u6ee4\u9879", userdata="\u5173\u8054\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u7684\u67e5\u8be2\u6761\u4ef6\u8f93\u5165\u9879"), @CodeItem(value="GROUP", text="\u5206\u7ec4\u9879", realtext="\u5206\u7ec4\u9879", userdata="\u9884\u7f6e\u8fc7\u6ee4\u6761\u4ef6\uff08\u4e00\u9879\u6216\u591a\u9879\uff09\u7684\u6570\u636e\u67e5\u8be2\u9879"), @CodeItem(value="QUICKSEARCH", text="\u5feb\u901f\u641c\u7d22\u9879", realtext="\u5feb\u901f\u641c\u7d22\u9879", userdata="\u5feb\u901f\u641c\u7d22\u6761\u4ef6\u7684\u8f93\u5165\u9879")})
public class SearchBarItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FILTER = "FILTER";
    public static final String GROUP = "GROUP";
    public static final String QUICKSEARCH = "QUICKSEARCH";

    public SearchBarItemTypeCodeListModel() {
        this.initAnnotation(SearchBarItemTypeCodeListModel.class);
        this.setUserData2("SearchBarItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemTypeCodeListModel");
    }
}

