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

@CodeList(id="4a200d473aa022843978b630872496d2", name="\u641c\u7d22\u8868\u5355\u6309\u94ae\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4", userdata="\u9ed8\u8ba4\u6837\u5f0f\uff0c\u8f93\u51fa\u3010\u641c\u7d22\u3011\u53ca\u3010\u91cd\u7f6e\u3011\u6309\u94ae"), @CodeItem(value="NONE", text="\u4e0d\u663e\u793a", realtext="\u4e0d\u663e\u793a", userdata="\u65e0\u641c\u7d22\u6309\u94ae\uff0c\u641c\u7d22\u8868\u5355\u9879\u503c\u53d1\u751f\u53d8\u5316\u65f6\u81ea\u52a8\u641c\u7d22"), @CodeItem(value="SEARCHONLY", text="\u53ea\u6709\u641c\u7d22", realtext="\u53ea\u6709\u641c\u7d22", userdata="\u4ec5\u8f93\u51fa\u3010\u641c\u7d22\u3011\u6309\u94ae"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class SearchFormButtonStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String NONE = "NONE";
    public static final String SEARCHONLY = "SEARCHONLY";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public SearchFormButtonStyleCodeListModel() {
        this.initAnnotation(SearchFormButtonStyleCodeListModel.class);
        this.setUserData2("SearchFormButtonStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormButtonStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFormButtonStyleCodeListModel");
    }
}

