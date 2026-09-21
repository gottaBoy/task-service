/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="57e083a5e9c3455f05dc283dc18ce1d0", name="\u4efb\u52a1\u65f6\u523b\u8868\u6708\u4efd", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="STR", valueseparator=",", textseparator=",")
@CodeItems(value={@CodeItem(value="1", text="\u4e00\u6708", realtext="\u4e00\u6708"), @CodeItem(value="2", text="\u4e8c\u6708", realtext="\u4e8c\u6708"), @CodeItem(value="3", text="\u4e09\u6708", realtext="\u4e09\u6708"), @CodeItem(value="4", text="\u56db\u6708", realtext="\u56db\u6708"), @CodeItem(value="5", text="\u4e94\u6708", realtext="\u4e94\u6708"), @CodeItem(value="6", text="\u516d\u6708", realtext="\u516d\u6708"), @CodeItem(value="7", text="\u4e03\u6708", realtext="\u4e03\u6708"), @CodeItem(value="8", text="\u516b\u6708", realtext="\u516b\u6708"), @CodeItem(value="9", text="\u4e5d\u6708", realtext="\u4e5d\u6708"), @CodeItem(value="10", text="\u5341\u6708", realtext="\u5341\u6708"), @CodeItem(value="11", text="\u5341\u4e00\u6708", realtext="\u5341\u4e00\u6708"), @CodeItem(value="12", text="\u5341\u4e8c\u6708", realtext="\u5341\u4e8c\u6708")})
public abstract class TSMonthCodeListModelBase
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
    public static final String ITEM_10 = "10";
    public static final String ITEM_11 = "11";
    public static final String ITEM_12 = "12";

    public TSMonthCodeListModelBase() {
        this.initAnnotation(TSMonthCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel");
    }
}

