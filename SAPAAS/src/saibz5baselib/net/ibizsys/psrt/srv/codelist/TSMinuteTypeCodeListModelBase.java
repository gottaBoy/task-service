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

@CodeList(id="7f9c59497ee367e966cdf72ee069b941", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u5206\u949f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ZERO", text="0\u5206", realtext="0\u5206"), @CodeItem(value="EVERY", text="\u6bcf\u5206\u949f", realtext="\u6bcf\u5206\u949f"), @CodeItem(value="SOME", text="\u6307\u5b9a\u5206\u949f", realtext="\u6307\u5b9a\u5206\u949f")})
public abstract class TSMinuteTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ZERO = "ZERO";
    public static final String EVERY = "EVERY";
    public static final String SOME = "SOME";

    public TSMinuteTypeCodeListModelBase() {
        this.initAnnotation(TSMinuteTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel");
    }
}

