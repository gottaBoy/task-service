/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="40f5d330b000794be41a3aa056eea7a9", name="\u6708\u5468\uff081\uff5e5\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="1\u5468", realtext="1\u5468"), @CodeItem(value="2", text="2\u5468", realtext="2\u5468"), @CodeItem(value="3", text="3\u5468", realtext="3\u5468"), @CodeItem(value="4", text="4\u5468", realtext="4\u5468"), @CodeItem(value="5", text="5\u5468", realtext="5\u5468")})
public abstract class CodeList86CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";

    public CodeList86CodeListModelBase() {
        this.initAnnotation(CodeList86CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList86CodeListModel", this);
    }
}

