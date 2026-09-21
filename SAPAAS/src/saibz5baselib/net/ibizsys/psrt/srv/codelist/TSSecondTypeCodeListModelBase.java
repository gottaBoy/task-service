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

@CodeList(id="d656f8b0316953dca1efb2cb139b1423", name="\u4efb\u52a1\u65f6\u523b\u7b56\u7565\u79d2\u949f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="ZERO", text="0\u79d2", realtext="0\u79d2"), @CodeItem(value="EVERY", text="\u6bcf\u79d2\u949f", realtext="\u6bcf\u79d2\u949f"), @CodeItem(value="SOME", text="\u6307\u5b9a\u79d2\u949f", realtext="\u6307\u5b9a\u79d2\u949f")})
public abstract class TSSecondTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ZERO = "ZERO";
    public static final String EVERY = "EVERY";
    public static final String SOME = "SOME";

    public TSSecondTypeCodeListModelBase() {
        this.initAnnotation(TSSecondTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel");
    }
}

