/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="279fd872b7376ddb13d270deb30c9227", name="\u5468\u671f\u65f6\u95f4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="MONTH", text="\u6708\u5ea6", realtext="\u6708\u5ea6"), @CodeItem(value="SEASON", text="\u5b63\u5ea6", realtext="\u5b63\u5ea6"), @CodeItem(value="WEEK", text="\u5468", realtext="\u5468"), @CodeItem(value="DAY", text="\u5929", realtext="\u5929")})
public abstract class CodeList40CodeListModelBase
extends StaticCodeListModelBase {
    public static final String MONTH = "MONTH";
    public static final String SEASON = "SEASON";
    public static final String WEEK = "WEEK";
    public static final String DAY = "DAY";

    public CodeList40CodeListModelBase() {
        this.initAnnotation(CodeList40CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList40CodeListModel", this);
    }
}

