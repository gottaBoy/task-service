/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="95136277e4eea61ed9048cf62b703370", name="\u5b9e\u4f53\u89c4\u5219\u5904\u7406_\u64cd\u4f5c\u903b\u8f91", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="=", text="\u7b49\u4e8e", realtext="\u7b49\u4e8e"), @CodeItem(value="<>", text="\u4e0d\u7b49\u4e8e", realtext="\u4e0d\u7b49\u4e8e"), @CodeItem(value=">=", text="\u5927\u4e8e\u7b49\u4e8e", realtext="\u5927\u4e8e\u7b49\u4e8e"), @CodeItem(value=">", text="\u5927\u4e8e", realtext="\u5927\u4e8e"), @CodeItem(value="<=", text="\u5c0f\u4e8e\u7b49\u4e8e", realtext="\u5c0f\u4e8e\u7b49\u4e8e"), @CodeItem(value="<", text="\u5c0f\u4e8e", realtext="\u5c0f\u4e8e"), @CodeItem(value="LIKE", text="\u6587\u672c\u5339\u914d", realtext="\u6587\u672c\u5339\u914d"), @CodeItem(value="ISNULL", text="\u4e3a\u7a7a", realtext="\u4e3a\u7a7a"), @CodeItem(value="ISNOTNULL", text="\u4e0d\u4e3a\u7a7a", realtext="\u4e0d\u4e3a\u7a7a")})
public abstract class CodeList111CodeListModelBase
extends StaticCodeListModelBase {
    public static final String EQ = "=";
    public static final String LTGT = "<>";
    public static final String GTEQ = ">=";
    public static final String GT = ">";
    public static final String LTEQ = "<=";
    public static final String LT = "<";
    public static final String LIKE = "LIKE";
    public static final String ISNULL = "ISNULL";
    public static final String ISNOTNULL = "ISNOTNULL";

    public CodeList111CodeListModelBase() {
        this.initAnnotation(CodeList111CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList111CodeListModel", this);
    }
}

