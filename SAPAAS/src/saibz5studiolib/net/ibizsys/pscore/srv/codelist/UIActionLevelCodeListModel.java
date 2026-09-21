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

@CodeList(id="29b659ec40ee14accb1522e9d0216d57", name="\u754c\u9762\u884c\u4e3a\u884c\u4e3a\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="50", text="\u4e0d\u5e38\u7528", realtext="\u4e0d\u5e38\u7528"), @CodeItem(value="100", text="\u4e00\u822c\u64cd\u4f5c", realtext="\u4e00\u822c\u64cd\u4f5c"), @CodeItem(value="200", text="\u5e38\u7528\u64cd\u4f5c", realtext="\u5e38\u7528\u64cd\u4f5c"), @CodeItem(value="250", text="\u5173\u952e\u64cd\u4f5c", realtext="\u5173\u952e\u64cd\u4f5c")})
public class UIActionLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTOFTEN = 50;
    public static final int INT_NOTOFTEN = 50;
    public static final Integer NORMAL = 100;
    public static final int INT_NORMAL = 100;
    public static final Integer OFTEN = 200;
    public static final int INT_OFTEN = 200;
    public static final Integer KEY = 250;
    public static final int INT_KEY = 250;

    public UIActionLevelCodeListModel() {
        this.initAnnotation(UIActionLevelCodeListModel.class);
        this.setUserData2("UIActionLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionLevelCodeListModel");
    }
}

