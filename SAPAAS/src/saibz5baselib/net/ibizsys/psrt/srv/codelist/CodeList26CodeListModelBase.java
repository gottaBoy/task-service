/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d62ba560b42f88d71683dab85cd77fc4", name="\u8868\u683c\u6bcf\u9875\u8bb0\u5f55\u6570", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="10", text="10\u884c", realtext="10\u884c"), @CodeItem(value="20", text="20\u884c", realtext="20\u884c"), @CodeItem(value="30", text="30\u884c", realtext="30\u884c"), @CodeItem(value="40", text="40\u884c", realtext="40\u884c"), @CodeItem(value="50", text="50\u884c", realtext="50\u884c"), @CodeItem(value="60", text="60\u884c", realtext="60\u884c"), @CodeItem(value="70", text="70\u884c", realtext="70\u884c"), @CodeItem(value="80", text="80\u884c", realtext="80\u884c"), @CodeItem(value="90", text="90\u884c", realtext="90\u884c"), @CodeItem(value="100", text="100\u884c", realtext="100\u884c")})
public abstract class CodeList26CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";
    public static final String ITEM_40 = "40";
    public static final String ITEM_50 = "50";
    public static final String ITEM_60 = "60";
    public static final String ITEM_70 = "70";
    public static final String ITEM_80 = "80";
    public static final String ITEM_90 = "90";
    public static final String ITEM_100 = "100";

    public CodeList26CodeListModelBase() {
        this.initAnnotation(CodeList26CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList26CodeListModel", this);
    }
}

