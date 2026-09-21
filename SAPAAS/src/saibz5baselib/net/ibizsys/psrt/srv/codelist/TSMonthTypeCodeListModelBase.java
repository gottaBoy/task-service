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

@CodeList(id="c7d219f186cee41ed8bbea15fcaa5528", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u6708\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="EVERY", text="\u6bcf\u6708", realtext="\u6bcf\u6708"), @CodeItem(value="SOME", text="\u6307\u5b9a\u6708", realtext="\u6307\u5b9a\u6708")})
public abstract class TSMonthTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String EVERY = "EVERY";
    public static final String SOME = "SOME";

    public TSMonthTypeCodeListModelBase() {
        this.initAnnotation(TSMonthTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel");
    }
}

