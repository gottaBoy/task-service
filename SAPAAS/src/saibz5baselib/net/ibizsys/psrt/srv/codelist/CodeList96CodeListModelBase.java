/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="cd54f62f7a50f2afc6c83d39183607f7", name="\u524d\u7aef\u5c55\u73b0\u6280\u672f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="HTML", text="HTML", realtext="HTML"), @CodeItem(value="SL", text="SilverLight", realtext="SilverLight"), @CodeItem(value="WinRT", text="WinRT", realtext="WinRT"), @CodeItem(value="Android", text="Android", realtext="Android"), @CodeItem(value="IOS", text="IOS", realtext="IOS")})
public abstract class CodeList96CodeListModelBase
extends StaticCodeListModelBase {
    public static final String HTML = "HTML";
    public static final String SL = "SL";
    public static final String WINRT = "WinRT";
    public static final String ANDROID = "Android";
    public static final String IOS = "IOS";

    public CodeList96CodeListModelBase() {
        this.initAnnotation(CodeList96CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList96CodeListModel", this);
    }
}

