/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="c47cdacce46ae8a902910751fd93f6d2", name="\u5c5e\u6027\u9884\u5b9a\u4e49\u503c\u89c4\u5219", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INT", text="\u6574\u6570", realtext="\u6574\u6570"), @CodeItem(value="POSITIVEINT", text="\u6b63\u6574\u6570", realtext="\u6b63\u6574\u6570", parentvalue="INT"), @CodeItem(value="STRING", text="\u5b57\u7b26\u4e32", realtext="\u5b57\u7b26\u4e32"), @CodeItem(value="STRING_EMAIL", text="\u7535\u5b50\u90ae\u4ef6", realtext="\u7535\u5b50\u90ae\u4ef6", parentvalue="STRING"), @CodeItem(value="FLOAT", text="\u6d6e\u70b9\u6570", realtext="\u6d6e\u70b9\u6570"), @CodeItem(value="FLOAT_PERCENT", text="\u767e\u5206\u6bd4\u6570\u503c(0~100)", realtext="\u767e\u5206\u6bd4\u6570\u503c(0~100)", parentvalue="FLOAT"), @CodeItem(value="DATETIME", text="\u65e5\u671f\u65f6\u95f4", realtext="\u65e5\u671f\u65f6\u95f4"), @CodeItem(value="DATETIME_GTNOW", text="\u5927\u4e8e\u5f53\u5929\u65f6\u95f4", realtext="\u5927\u4e8e\u5f53\u5929\u65f6\u95f4", parentvalue="DATETIME"), @CodeItem(value="DATETIME_GTNOWNOHOUR", text="\u5927\u4e8e\u5f53\u5929\u65e5\u671f", realtext="\u5927\u4e8e\u5f53\u5929\u65e5\u671f", parentvalue="DATETIME"), @CodeItem(value="DATETIME_GTNOW3DAY", text="\u540e3\u5929", realtext="\u540e3\u5929", parentvalue="DATETIME")})
public abstract class CodeList13CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INT = "INT";
    public static final String POSITIVEINT = "POSITIVEINT";
    public static final String STRING = "STRING";
    public static final String STRING_EMAIL = "STRING_EMAIL";
    public static final String FLOAT = "FLOAT";
    public static final String FLOAT_PERCENT = "FLOAT_PERCENT";
    public static final String DATETIME = "DATETIME";
    public static final String DATETIME_GTNOW = "DATETIME_GTNOW";
    public static final String DATETIME_GTNOWNOHOUR = "DATETIME_GTNOWNOHOUR";
    public static final String DATETIME_GTNOW3DAY = "DATETIME_GTNOW3DAY";

    public CodeList13CodeListModelBase() {
        this.initAnnotation(CodeList13CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList13CodeListModel", this);
    }
}

