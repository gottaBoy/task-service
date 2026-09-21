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

@CodeList(id="68e95831f1ab736026fab82cca2e7b7e", name="\u4efb\u52a1\u65f6\u523b\u6708\u5468", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="STR", valueseparator=",", textseparator=",")
@CodeItems(value={@CodeItem(value="2", text="\u661f\u671f\u4e00", realtext="\u661f\u671f\u4e00"), @CodeItem(value="3", text="\u661f\u671f\u4e8c", realtext="\u661f\u671f\u4e8c"), @CodeItem(value="4", text="\u661f\u671f\u4e09", realtext="\u661f\u671f\u4e09"), @CodeItem(value="5", text="\u661f\u671f\u56db", realtext="\u661f\u671f\u56db"), @CodeItem(value="6", text="\u661f\u671f\u4e94", realtext="\u661f\u671f\u4e94"), @CodeItem(value="7", text="\u661f\u671f\u516d", realtext="\u661f\u671f\u516d"), @CodeItem(value="1", text="\u661f\u671f\u65e5", realtext="\u661f\u671f\u65e5")})
public abstract class TSWeekCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";
    public static final String ITEM_6 = "6";
    public static final String ITEM_7 = "7";
    public static final String ITEM_1 = "1";

    public TSWeekCodeListModelBase() {
        this.initAnnotation(TSWeekCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel");
    }
}

