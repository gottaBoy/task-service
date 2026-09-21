/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="55109493d150336bdcd4710454f76d72", name="\u8865\u4e01\u5f52\u5c5e", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u6846\u67b6\u57fa\u672c", realtext="\u6846\u67b6\u57fa\u672c"), @CodeItem(value="2", text="\u6846\u67b6\u9ad8\u7ea7", realtext="\u6846\u67b6\u9ad8\u7ea7"), @CodeItem(value="4", text="\u5de5\u4f5c\u6d41", realtext="\u5de5\u4f5c\u6d41"), @CodeItem(value="8", text="EAI", realtext="EAI"), @CodeItem(value="16", text="UAC", realtext="UAC"), @CodeItem(value="32", text="\u5168\u6587\u68c0\u7d22", realtext="\u5168\u6587\u68c0\u7d22"), @CodeItem(value="64", text="\u6570\u636e\u5206\u6790", realtext="\u6570\u636e\u5206\u6790"), @CodeItem(value="128", text="\u57fa\u7840\u7f51\u76d8", realtext="\u57fa\u7840\u7f51\u76d8"), @CodeItem(value="256", text="\u57fa\u7840\u7ec4\u7ec7", realtext="\u57fa\u7840\u7ec4\u7ec7")})
public abstract class CodeList36CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_4 = "4";
    public static final String ITEM_8 = "8";
    public static final String ITEM_16 = "16";
    public static final String ITEM_32 = "32";
    public static final String ITEM_64 = "64";
    public static final String ITEM_128 = "128";
    public static final String ITEM_256 = "256";

    public CodeList36CodeListModelBase() {
        this.initAnnotation(CodeList36CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList36CodeListModel", this);
    }
}

