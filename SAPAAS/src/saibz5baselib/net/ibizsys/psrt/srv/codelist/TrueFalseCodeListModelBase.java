/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="402b576dd38baa58e2cdf47659637a1d", name="\u662f\u5426\uff08TRUE\uff0cFALSE\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="TRUE", text="\u662f", realtext="\u662f"), @CodeItem(value="FALSE", text="\u5426", realtext="\u5426")})
public abstract class TrueFalseCodeListModelBase
extends StaticCodeListModelBase {
    public static final String TRUE = "TRUE";
    public static final String FALSE = "FALSE";

    public TrueFalseCodeListModelBase() {
        this.initAnnotation(TrueFalseCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TrueFalseCodeListModel", this);
    }
}

