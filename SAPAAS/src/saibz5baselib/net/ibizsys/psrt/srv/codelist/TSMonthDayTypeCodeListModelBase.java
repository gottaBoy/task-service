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

@CodeList(id="70ba65aab4ff63fee8ce5fa67c686b71", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u6708\u5929\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EVERY", text="\u6bcf\u5929", realtext="\u6bcf\u5929"), @CodeItem(value="SOME", text="\u6307\u5b9a\u5929", realtext="\u6307\u5b9a\u5929"), @CodeItem(value="NONE", text="\u4e0d\u6307\u5b9a", realtext="\u4e0d\u6307\u5b9a")})
public abstract class TSMonthDayTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String EVERY = "EVERY";
    public static final String SOME = "SOME";
    public static final String NONE = "NONE";

    public TSMonthDayTypeCodeListModelBase() {
        this.initAnnotation(TSMonthDayTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel");
    }
}

