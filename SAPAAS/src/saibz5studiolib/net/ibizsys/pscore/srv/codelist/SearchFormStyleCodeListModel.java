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

@CodeList(id="BE4AE056-246B-45F3-88DB-3313CA28D02A", name="\u641c\u7d22\u8868\u5355\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SEARCHBAR", text="\u641c\u7d22\u680f", realtext="\u641c\u7d22\u680f"), @CodeItem(value="SEARCHBAR2", text="\u641c\u7d22\u680f2", realtext="\u641c\u7d22\u680f2"), @CodeItem(value="MOBSEARCHBAR", text="\u79fb\u52a8\u7aef\u641c\u7d22\u680f", realtext="\u79fb\u52a8\u7aef\u641c\u7d22\u680f"), @CodeItem(value="MOBSEARCHBAR2", text="\u79fb\u52a8\u7aef\u641c\u7d22\u680f2", realtext="\u79fb\u52a8\u7aef\u641c\u7d22\u680f2"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class SearchFormStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String SEARCHBAR = "SEARCHBAR";
    public static final String SEARCHBAR2 = "SEARCHBAR2";
    public static final String MOBSEARCHBAR = "MOBSEARCHBAR";
    public static final String MOBSEARCHBAR2 = "MOBSEARCHBAR2";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public SearchFormStyleCodeListModel() {
        this.initAnnotation(SearchFormStyleCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormStyleCodeListModel");
    }
}

