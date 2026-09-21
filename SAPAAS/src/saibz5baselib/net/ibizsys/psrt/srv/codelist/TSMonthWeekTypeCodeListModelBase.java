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

@CodeList(id="1e43c9c2b94911ff15708c0d13e66391", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u6708\u5468\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EVERY", text="\u6bcf\u5468", realtext="\u6bcf\u5468"), @CodeItem(value="ONE", text="\u7b2c\u4e00\u5468", realtext="\u7b2c\u4e00\u5468"), @CodeItem(value="TWO", text="\u7b2c\u4e8c\u5468", realtext="\u7b2c\u4e8c\u5468"), @CodeItem(value="THREE", text="\u7b2c\u4e09\u5468", realtext="\u7b2c\u4e09\u5468"), @CodeItem(value="FOUR", text="\u7b2c\u56db\u5468", realtext="\u7b2c\u56db\u5468"), @CodeItem(value="FIVE", text="\u7b2c\u4e94\u5468", realtext="\u7b2c\u4e94\u5468"), @CodeItem(value="NONE", text="\u4e0d\u6307\u5b9a", realtext="\u4e0d\u6307\u5b9a")})
public abstract class TSMonthWeekTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String EVERY = "EVERY";
    public static final String ONE = "ONE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String FOUR = "FOUR";
    public static final String FIVE = "FIVE";
    public static final String NONE = "NONE";

    public TSMonthWeekTypeCodeListModelBase() {
        this.initAnnotation(TSMonthWeekTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel");
    }
}

