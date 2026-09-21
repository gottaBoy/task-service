/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="c8495a290c2636dfc95ccc621699e17d", name="\u7cfb\u7edf\u5185\u7f6e\u83dc\u5355", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="SYSTEMDEVELOP", text="\u7cfb\u7edf\u8bbe\u8ba1\u4e3b\u83dc\u5355", realtext="\u7cfb\u7edf\u8bbe\u8ba1\u4e3b\u83dc\u5355"), @CodeItem(value="DEFAULT4", text="IBIZSYS\u4ea7\u54c1\u6f14\u793a\u4e3b\u83dc\u5355", realtext="IBIZSYS\u4ea7\u54c1\u6f14\u793a\u4e3b\u83dc\u5355"), @CodeItem(value="EAI", text="EAI\u4e3b\u83dc\u5355", realtext="EAI\u4e3b\u83dc\u5355"), @CodeItem(value="DEFAULT", text="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355", realtext="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355"), @CodeItem(value="DEFAULT:ZHCN:SL", text="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(SilverLight\uff0c\u4e2d\u6587)", realtext="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(SilverLight\uff0c\u4e2d\u6587)"), @CodeItem(value="GAADMIN", text="\u6b63\u7248\u7ba1\u7406", realtext="\u6b63\u7248\u7ba1\u7406"), @CodeItem(value="SUBMENU_DEMO1", text="\u6d4b\u8bd5\u83dc\u5355", realtext="\u6d4b\u8bd5\u83dc\u5355"), @CodeItem(value="SYSTEMDEVELOP2", text="\u7cfb\u7edf\u8bbe\u8ba1\u4e3b\u83dc\u5355", realtext="\u7cfb\u7edf\u8bbe\u8ba1\u4e3b\u83dc\u5355"), @CodeItem(value="\u6d4b\u8bd5\u5b50\u83dc\u53552", text="\u6d4b\u8bd5\u5b50\u83dc\u53552 ", realtext="\u6d4b\u8bd5\u5b50\u83dc\u53552 "), @CodeItem(value="DEFAULT:EN", text="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355", realtext="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355"), @CodeItem(value="DEFAULT::SL", text="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(SilverLight\uff0c\u4e2d\u6587)", realtext="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(SilverLight\uff0c\u4e2d\u6587)"), @CodeItem(value="DEFAULT::WinRT", text="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(WinRT\uff0c\u4e2d\u6587)", realtext="\u7cfb\u7edf\u9ed8\u8ba4\u4e3b\u83dc\u5355(WinRT\uff0c\u4e2d\u6587)")})
public abstract class CodeList79CodeListModelBase
extends StaticCodeListModelBase {
    public static final String SYSTEMDEVELOP = "SYSTEMDEVELOP";
    public static final String DEFAULT4 = "DEFAULT4";
    public static final String EAI = "EAI";
    public static final String DEFAULT = "DEFAULT";
    public static final String DEFAULT_ZHCN_SL = "DEFAULT:ZHCN:SL";
    public static final String GAADMIN = "GAADMIN";
    public static final String SUBMENU_DEMO1 = "SUBMENU_DEMO1";
    public static final String SYSTEMDEVELOP2 = "SYSTEMDEVELOP2";
    public static final String ITEM_9 = "\u6d4b\u8bd5\u5b50\u83dc\u53552";
    public static final String DEFAULT_EN = "DEFAULT:EN";
    public static final String DEFAULT_SL = "DEFAULT::SL";
    public static final String DEFAULT_WINRT = "DEFAULT::WinRT";

    public CodeList79CodeListModelBase() {
        this.initAnnotation(CodeList79CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList79CodeListModel", this);
    }
}

