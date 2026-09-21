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

@CodeList(id="9138F2EE-EB35-49FB-A97C-8C4277239D95", name="\u641c\u7d22\u680f\u9879\u6309\u94ae\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BUTTON_SEARCH", text="\u641c\u7d22\u6309\u94ae", realtext="\u641c\u7d22\u6309\u94ae"), @CodeItem(value="BUTTON_ADVSEARCH", text="\u9ad8\u7ea7\u641c\u7d22\u6309\u94ae", realtext="\u9ad8\u7ea7\u641c\u7d22\u6309\u94ae")})
public class SearchBarItemBtnTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BUTTON_SEARCH = "BUTTON_SEARCH";
    public static final String BUTTON_ADVSEARCH = "BUTTON_ADVSEARCH";

    public SearchBarItemBtnTypeCodeListModel() {
        this.initAnnotation(SearchBarItemBtnTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemBtnTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemBtnTypeCodeListModel");
    }
}

