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

@CodeList(id="991077bb522c0edcf68114f488098b9a", name="\u641c\u7d22\u8868\u5355\u6309\u94ae\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RIGHT", text="\u53f3\u8fb9", realtext="\u53f3\u8fb9"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9")})
public class SearchFormButtonPosCodeListModel
extends StaticCodeListModelBase {
    public static final String RIGHT = "RIGHT";
    public static final String BOTTOM = "BOTTOM";

    public SearchFormButtonPosCodeListModel() {
        this.initAnnotation(SearchFormButtonPosCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("SearchFormButtonPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormButtonPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormButtonPosCodeListModel");
    }
}

