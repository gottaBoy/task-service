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

@CodeList(id="5CD7C915-7850-4595-9153-E73B37DC35F4", name="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5e94\u7528\u81ea\u5efa", realtext="\u5e94\u7528\u81ea\u5efa"), @CodeItem(value="2", text="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb", realtext="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb")})
public class AppDERSModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;

    public AppDERSModeCodeListModel() {
        this.initAnnotation(AppDERSModeCodeListModel.class);
        this.setUserData2("AppDERSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDERSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDERSModeCodeListModel");
    }
}

