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

@CodeList(id="E9F567D2-E249-4E65-9E0B-36387AFED353", name="\u641c\u7d22\u680f\u5feb\u901f\u641c\u7d22\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5426", realtext="\u5426", userdata="\u4e0d\u63d0\u4f9b"), @CodeItem(value="1", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4", userdata="\u5e38\u89c4\u7684\u5feb\u901f\u641c\u7d22\u6a21\u5f0f\uff0c\u6a21\u7cca\u67e5\u8be2\u5b9e\u4f53\u4e2d\u652f\u6301\u5feb\u901f\u641c\u7d22\u7684\u5c5e\u6027"), @CodeItem(value="2", text="\u9ad8\u7ea7\uff08\u5feb\u901f\u641c\u7d22\u9879\uff09", realtext="\u9ad8\u7ea7\uff08\u5feb\u901f\u641c\u7d22\u9879\uff09", userdata="\u5feb\u901f\u641c\u7d22\u9ad8\u7ea7\u6a21\u5f0f\uff0c\u901a\u8fc7\u5feb\u901f\u641c\u7d22\u9879\u5b9a\u4e49\u5feb\u901f\u641c\u7d22\u7684\u80fd\u529b\uff0c\u8fdb\u4e00\u6b65\u63d0\u4f9b\u4f18\u5316\u7684\u5feb\u901f\u641c\u7d22\u754c\u9762\uff0c\u5982\u5f15\u5bfc\u7528\u6237\u9009\u62e9\u641c\u7d22\u9879\uff0c\u4e3a\u5177\u4f53\u7684\u641c\u7d22\u9879\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u7b49\u8f85\u52a9\u8f93\u5165\u652f\u6301")})
public class SearchBarQuickSearchModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSUPPORTED = 0;
    public static final int INT_NOTSUPPORTED = 0;
    public static final Integer SUPPORTED = 1;
    public static final int INT_SUPPORTED = 1;
    public static final Integer ADVANCE = 2;
    public static final int INT_ADVANCE = 2;

    public SearchBarQuickSearchModeCodeListModel() {
        this.initAnnotation(SearchBarQuickSearchModeCodeListModel.class);
        this.setUserData2("SearchBarQuickSearchMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarQuickSearchModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchBarQuickSearchModeCodeListModel");
    }
}

