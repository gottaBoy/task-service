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

@CodeList(id="34d8c46af976fc06a2ff17d063f1208e", name="\u5927\u6570\u636e\u8868\u5173\u7cfb\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e00\u7ea7", realtext="\u4e00\u7ea7"), @CodeItem(value="2", text="\u4e8c\u7ea7", realtext="\u4e8c\u7ea7"), @CodeItem(value="3", text="\u4e09\u7ea7", realtext="\u4e09\u7ea7"), @CodeItem(value="4", text="\u56db\u7ea7", realtext="\u56db\u7ea7"), @CodeItem(value="5", text="\u4e94\u7ea7", realtext="\u4e94\u7ea7"), @CodeItem(value="6", text="\u516d\u7ea7", realtext="\u516d\u7ea7")})
public class BDTableDERLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer LEVEL1 = 1;
    public static final int INT_LEVEL1 = 1;
    public static final Integer LEVEL2 = 2;
    public static final int INT_LEVEL2 = 2;
    public static final Integer LEVEL3 = 3;
    public static final int INT_LEVEL3 = 3;
    public static final Integer LEVEL4 = 4;
    public static final int INT_LEVEL4 = 4;
    public static final Integer LEVEL5 = 5;
    public static final int INT_LEVEL5 = 5;
    public static final Integer LEVEL6 = 6;
    public static final int INT_LEVEL6 = 6;

    public BDTableDERLevelCodeListModel() {
        this.initAnnotation(BDTableDERLevelCodeListModel.class);
        this.setUserData2("BDTableDERLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDERLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableDERLevelCodeListModel");
    }
}

