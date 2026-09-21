/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="1b0fc14560be977c47f0fa3463cd09df", name="\u540c\u6784\u6c47\u603b\u8868\u65f6\u95f4\u7ef4\u5ea6", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="MINUTE", text="\u6bcf\u5206\u949f", realtext="\u6bcf\u5206\u949f"), @CodeItem(value="MINUTE15", text="15\u5206\u949f", realtext="15\u5206\u949f"), @CodeItem(value="MINUTE05", text="5\u5206\u949f", realtext="5\u5206\u949f"), @CodeItem(value="HOUR", text="\u6bcf\u5c0f\u65f6", realtext="\u6bcf\u5c0f\u65f6"), @CodeItem(value="DAY", text="\u6bcf\u5929", realtext="\u6bcf\u5929"), @CodeItem(value="MONTH", text="\u6bcf\u6708", realtext="\u6bcf\u6708"), @CodeItem(value="SEASON", text="\u6bcf\u5b63\u5ea6", realtext="\u6bcf\u5b63\u5ea6")})
public abstract class CodeList95CodeListModelBase
extends StaticCodeListModelBase {
    public static final String MINUTE = "MINUTE";
    public static final String MINUTE15 = "MINUTE15";
    public static final String MINUTE05 = "MINUTE05";
    public static final String HOUR = "HOUR";
    public static final String DAY = "DAY";
    public static final String MONTH = "MONTH";
    public static final String SEASON = "SEASON";

    public CodeList95CodeListModelBase() {
        this.initAnnotation(CodeList95CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList95CodeListModel", this);
    }
}

