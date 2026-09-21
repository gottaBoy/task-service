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

@CodeList(id="F1CD9F45-4FB1-4F50-BE91-5C5AED27EDA5", name="\u5b9e\u4f53\u641c\u7d22\u680f\u8fc7\u6ee4\u5206\u7ec4\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SINGLE", text="\u5355\u9879", realtext="\u5355\u9879"), @CodeItem(value="AND", text="\u591a\u9879\uff08\u4e0e\u903b\u8f91\uff09", realtext="\u591a\u9879\uff08\u4e0e\u903b\u8f91\uff09"), @CodeItem(value="OR", text="\u591a\u9879\uff08\u6216\u903b\u8f91\uff09", realtext="\u591a\u9879\uff08\u6216\u903b\u8f91\uff09")})
public class SearchBarGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String SINGLE = "SINGLE";
    public static final String AND = "AND";
    public static final String OR = "OR";

    public SearchBarGroupModeCodeListModel() {
        this.initAnnotation(SearchBarGroupModeCodeListModel.class);
        this.setUserData2("SearchBarGroupMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarGroupModeCodeListModel");
    }
}

