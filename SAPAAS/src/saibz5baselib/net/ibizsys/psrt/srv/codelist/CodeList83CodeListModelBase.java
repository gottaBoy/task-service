/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="7cc93f7d8e55391b4e9e5043be433cfb", name="\u5b63\u5ea6\uff081\uff5e4\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="1\u5b63\u5ea6", realtext="1\u5b63\u5ea6"), @CodeItem(value="2", text="2\u5b63\u5ea6", realtext="2\u5b63\u5ea6"), @CodeItem(value="3", text="3\u5b63\u5ea6", realtext="3\u5b63\u5ea6"), @CodeItem(value="4", text="4\u5b63\u5ea6", realtext="4\u5b63\u5ea6")})
public abstract class CodeList83CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";

    public CodeList83CodeListModelBase() {
        this.initAnnotation(CodeList83CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList83CodeListModel", this);
    }
}

