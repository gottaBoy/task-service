/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="f2889e5249c0df08a524d556bd2acc37", name="\u811a\u672c\u529f\u80fd", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u57fa\u7840", realtext="\u57fa\u7840"), @CodeItem(value="128", text="\u6811\u89c6\u56fe\u5e38\u89c4", realtext="\u6811\u89c6\u56fe\u5e38\u89c4"), @CodeItem(value="2", text="\u6811\u89c6\u56fe\u9ad8\u7ea7", realtext="\u6811\u89c6\u56fe\u9ad8\u7ea7"), @CodeItem(value="4", text="TAB\u89c6\u56fe", realtext="TAB\u89c6\u56fe"), @CodeItem(value="8", text="\u52a8\u6001\u9762\u677f", realtext="\u52a8\u6001\u9762\u677f"), @CodeItem(value="16", text="\u641c\u7d22\u9762\u677f", realtext="\u641c\u7d22\u9762\u677f"), @CodeItem(value="32", text="\u8868\u683c\u89c6\u56fe\u5e38\u89c4", realtext="\u8868\u683c\u89c6\u56fe\u5e38\u89c4"), @CodeItem(value="64", text="\u8868\u683c\u89c6\u56fe\u9ad8\u7ea7", realtext="\u8868\u683c\u89c6\u56fe\u9ad8\u7ea7"), @CodeItem(value="256", text="\u6570\u636e\u89c6\u56fe", realtext="\u6570\u636e\u89c6\u56fe")})
public abstract class CodeList114CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_128 = "128";
    public static final String ITEM_2 = "2";
    public static final String ITEM_4 = "4";
    public static final String ITEM_8 = "8";
    public static final String ITEM_16 = "16";
    public static final String ITEM_32 = "32";
    public static final String ITEM_64 = "64";
    public static final String ITEM_256 = "256";

    public CodeList114CodeListModelBase() {
        this.initAnnotation(CodeList114CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList114CodeListModel", this);
    }
}

