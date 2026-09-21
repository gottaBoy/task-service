/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="72366c28902f0efeab7c6d7999b8a498", name="\u5b9e\u4f53\u6570\u636e\u5904\u7406_\u53d8\u91cf\u540d\u79f0", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="%DEFAULT%", text="\u9ed8\u8ba4\u53d8\u91cf", realtext="\u9ed8\u8ba4\u53d8\u91cf"), @CodeItem(value="%ENV%", text="\u73af\u5883\u53d8\u91cf", realtext="\u73af\u5883\u53d8\u91cf"), @CodeItem(value="PARAM1", text="\u53d8\u91cf1", realtext="\u53d8\u91cf1"), @CodeItem(value="PARAM2", text="\u53d8\u91cf2", realtext="\u53d8\u91cf2"), @CodeItem(value="PARAM3", text="\u53d8\u91cf3", realtext="\u53d8\u91cf3"), @CodeItem(value="PARAM4", text="\u53d8\u91cf4", realtext="\u53d8\u91cf4"), @CodeItem(value="PARAM5", text="\u53d8\u91cf5", realtext="\u53d8\u91cf5"), @CodeItem(value="%LAST%", text="\u5386\u53f2\u503c", realtext="\u5386\u53f2\u503c"), @CodeItem(value="%GLOBAL1%", text="\u5168\u5c40\u53d8\u91cf1", realtext="\u5168\u5c40\u53d8\u91cf1"), @CodeItem(value="%GLOBAL2%", text="\u5168\u5c40\u53d8\u91cf2", realtext="\u5168\u5c40\u53d8\u91cf2"), @CodeItem(value="%GLOBAL3%", text="\u5168\u5c40\u53d8\u91cf3", realtext="\u5168\u5c40\u53d8\u91cf3"), @CodeItem(value="%GLOBAL4%", text="\u5168\u5c40\u53d8\u91cf4", realtext="\u5168\u5c40\u53d8\u91cf4"), @CodeItem(value="%GLOBAL5%", text="\u5168\u5c40\u53d8\u91cf5", realtext="\u5168\u5c40\u53d8\u91cf5"), @CodeItem(value="%BRINST%", text="\u5168\u5c40\u89c4\u5219\u5f15\u64ce\u5b9e\u4f8b\u53d8\u91cf", realtext="\u5168\u5c40\u89c4\u5219\u5f15\u64ce\u5b9e\u4f8b\u53d8\u91cf")})
public abstract class CodeList109CodeListModelBase
extends StaticCodeListModelBase {
    public static final String _DEFAULT_ = "%DEFAULT%";
    public static final String _ENV_ = "%ENV%";
    public static final String PARAM1 = "PARAM1";
    public static final String PARAM2 = "PARAM2";
    public static final String PARAM3 = "PARAM3";
    public static final String PARAM4 = "PARAM4";
    public static final String PARAM5 = "PARAM5";
    public static final String _LAST_ = "%LAST%";
    public static final String _GLOBAL1_ = "%GLOBAL1%";
    public static final String _GLOBAL2_ = "%GLOBAL2%";
    public static final String _GLOBAL3_ = "%GLOBAL3%";
    public static final String _GLOBAL4_ = "%GLOBAL4%";
    public static final String _GLOBAL5_ = "%GLOBAL5%";
    public static final String _BRINST_ = "%BRINST%";

    public CodeList109CodeListModelBase() {
        this.initAnnotation(CodeList109CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList109CodeListModel", this);
    }
}

