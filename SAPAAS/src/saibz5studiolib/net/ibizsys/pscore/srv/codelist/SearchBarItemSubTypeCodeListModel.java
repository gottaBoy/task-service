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

@CodeList(id="47cbb243f5b69aa4cfd5ac4a6f20428b", name="\u641c\u7d22\u680f\u9879\u5b50\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INPUT_RADIOBUTTONLIST", text="\u5355\u9009\u6309\u94ae\u5217\u8868", realtext="\u5355\u9009\u6309\u94ae\u5217\u8868"), @CodeItem(value="INPUT_CHECKBOXLIST", text="\u591a\u9009\u6309\u94ae\u5217\u8868", realtext="\u591a\u9009\u6309\u94ae\u5217\u8868"), @CodeItem(value="INPUT_CHECKBOX", text="\u9009\u9879\u6309\u94ae", realtext="\u9009\u9879\u6309\u94ae"), @CodeItem(value="INPUT_TEXTBOX", text="\u6587\u672c\u6846", realtext="\u6587\u672c\u6846"), @CodeItem(value="BUTTON_SEARCH", text="\u641c\u7d22\u6309\u94ae", realtext="\u641c\u7d22\u6309\u94ae"), @CodeItem(value="BUTTON_ADVSEARCH", text="\u9ad8\u7ea7\u641c\u7d22\u6309\u94ae", realtext="\u9ad8\u7ea7\u641c\u7d22\u6309\u94ae"), @CodeItem(value="BUTTON_RESET", text="\u91cd\u7f6e\u6309\u94ae", realtext="\u91cd\u7f6e\u6309\u94ae")})
public class SearchBarItemSubTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INPUT_RADIOBUTTONLIST = "INPUT_RADIOBUTTONLIST";
    public static final String INPUT_CHECKBOXLIST = "INPUT_CHECKBOXLIST";
    public static final String INPUT_CHECKBOX = "INPUT_CHECKBOX";
    public static final String INPUT_TEXTBOX = "INPUT_TEXTBOX";
    public static final String BUTTON_SEARCH = "BUTTON_SEARCH";
    public static final String BUTTON_ADVSEARCH = "BUTTON_ADVSEARCH";
    public static final String BUTTON_RESET = "BUTTON_RESET";

    public SearchBarItemSubTypeCodeListModel() {
        this.initAnnotation(SearchBarItemSubTypeCodeListModel.class);
        this.setUserData2("SearchBarItemSubType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemSubTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarItemSubTypeCodeListModel");
    }
}

