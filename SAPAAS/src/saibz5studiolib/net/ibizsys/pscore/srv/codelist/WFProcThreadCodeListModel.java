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

@CodeList(id="309388c4cf7e2b09759a43e0bcaf2dea", name="\u6d41\u7a0b\u5904\u7406\u4e3b\u7ebf", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e3b\u7ebf1", realtext="\u4e3b\u7ebf1"), @CodeItem(value="2", text="\u4e3b\u7ebf2", realtext="\u4e3b\u7ebf2"), @CodeItem(value="3", text="\u4e3b\u7ebf3", realtext="\u4e3b\u7ebf3"), @CodeItem(value="4", text="\u4e3b\u7ebf4", realtext="\u4e3b\u7ebf4"), @CodeItem(value="5", text="\u4e3b\u7ebf5", realtext="\u4e3b\u7ebf5"), @CodeItem(value="6", text="\u4e3b\u7ebf6", realtext="\u4e3b\u7ebf6"), @CodeItem(value="7", text="\u4e3b\u7ebf7", realtext="\u4e3b\u7ebf7"), @CodeItem(value="8", text="\u4e3b\u7ebf8", realtext="\u4e3b\u7ebf8"), @CodeItem(value="9", text="\u4e3b\u7ebf9", realtext="\u4e3b\u7ebf9")})
public class WFProcThreadCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";
    public static final String ITEM_6 = "6";
    public static final String ITEM_7 = "7";
    public static final String ITEM_8 = "8";
    public static final String ITEM_9 = "9";

    public WFProcThreadCodeListModel() {
        this.initAnnotation(WFProcThreadCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcThreadCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFProcThreadCodeListModel");
    }
}

